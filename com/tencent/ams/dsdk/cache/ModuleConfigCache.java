package com.tencent.ams.dsdk.cache;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.data.ModuleInfo;
import com.tencent.ams.dsdk.monitor.metric.DynamicReporter;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.FileUtils;
import com.tencent.ams.dsdk.utils.ParcelableUtil;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ModuleConfigCache {
    static IPatchRedirector $redirector_ = null;
    private static final String CACHE_DIR = "conf";
    private static final String CACHE_SUFFIX = ".conf";
    private static final String PATH_DIV;
    private static final String TAG = "ModuleConfigCache";
    private static String dirStr;
    private static final List<String> sDeletedModuleList;
    private static final String[] sExcludeConfFiles;
    private static boolean sIsReadAllLocal;
    private static final ConcurrentHashMap<String, Object> sLockCacheMap;
    private static final ConcurrentHashMap<String, ModuleInfo> sModuleInfoCache;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14017);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        PATH_DIV = File.separator;
        sLockCacheMap = new ConcurrentHashMap<>();
        sModuleInfoCache = new ConcurrentHashMap<>();
        sDeletedModuleList = new ArrayList();
        sExcludeConfFiles = new String[]{"templates.conf", "so_configs.conf"};
        dirStr = null;
        sIsReadAllLocal = false;
    }

    public ModuleConfigCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void cacheModuleWithParcelable(ModuleInfo moduleInfo) {
        long uptimeMillis = SystemClock.uptimeMillis();
        DynamicReporter.reportBundleLocalConfigUpdateStart(moduleInfo);
        DLog.d(TAG, "cacheModuleWithParcelable, module: " + moduleInfo);
        if (moduleInfo != null && !TextUtils.isEmpty(moduleInfo.getId())) {
            String id5 = moduleInfo.getId();
            WorkThreadManager.getInstance().getCachedThreadPool().execute(new Runnable(id5, getCacheFilePath(id5), uptimeMillis) { // from class: com.tencent.ams.dsdk.cache.ModuleConfigCache.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$filePath;
                final /* synthetic */ String val$moduleId;
                final /* synthetic */ long val$startTime;

                {
                    this.val$moduleId = id5;
                    this.val$filePath = r7;
                    this.val$startTime = uptimeMillis;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, ModuleInfo.this, id5, r7, Long.valueOf(uptimeMillis));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    byte[] marshall = ParcelableUtil.marshall(ModuleInfo.this);
                    DLog.d(ModuleConfigCache.TAG, "config to bytes time cost: " + (System.currentTimeMillis() - currentTimeMillis));
                    if (marshall != null && marshall.length > 0) {
                        Object moduleLock = ModuleConfigCache.getModuleLock(this.val$moduleId);
                        if (moduleLock != null) {
                            long currentTimeMillis2 = System.currentTimeMillis();
                            synchronized (moduleLock) {
                                if (!ModuleConfigCache.sDeletedModuleList.contains(this.val$moduleId)) {
                                    if (FileUtils.writeBytesToFile(marshall, this.val$filePath)) {
                                        DynamicReporter.reportBundleLocalConfigUpdateEnd(this.val$startTime, "none", ModuleInfo.this);
                                    } else {
                                        DLog.w(ModuleConfigCache.TAG, "config write to file failed.");
                                        DynamicReporter.reportBundleLocalConfigUpdateEnd(this.val$startTime, TagValue.CONFIG_WRITE_TO_FILE_FAIL, ModuleInfo.this);
                                    }
                                } else {
                                    DynamicReporter.reportBundleLocalConfigUpdateEnd(this.val$startTime, TagValue.CONFIG_DELETING, ModuleInfo.this);
                                }
                            }
                            DLog.d("bytes to file time cost: " + (System.currentTimeMillis() - currentTimeMillis2));
                            return;
                        }
                        DLog.w(ModuleConfigCache.TAG, "get lock failed.");
                        DynamicReporter.reportBundleLocalConfigUpdateEnd(this.val$startTime, TagValue.CONFIG_GET_LOCK_FAIL, ModuleInfo.this);
                        return;
                    }
                    DLog.w(ModuleConfigCache.TAG, "config to bytes failed.");
                    DynamicReporter.reportBundleLocalConfigUpdateEnd(this.val$startTime, TagValue.CONFIG_TO_BYTE_FAIL, ModuleInfo.this);
                }
            });
        } else {
            DLog.w(TAG, "module info config is invalid.");
            DynamicReporter.reportBundleLocalConfigUpdateEnd(uptimeMillis, TagValue.CONFIG_INVALID, moduleInfo);
        }
    }

    public static synchronized boolean deleteModuleInfo(ModuleInfo moduleInfo) {
        synchronized (ModuleConfigCache.class) {
            if (moduleInfo != null) {
                if (!TextUtils.isEmpty(moduleInfo.getId())) {
                    String id5 = moduleInfo.getId();
                    Object moduleLock = getModuleLock(id5);
                    if (moduleLock == null) {
                        return false;
                    }
                    synchronized (moduleLock) {
                        sDeletedModuleList.add(id5);
                        removeModuleInfoCache(moduleInfo);
                        deleteModuleInfoParcelable(moduleInfo);
                    }
                    return true;
                }
            }
            return false;
        }
    }

    private static void deleteModuleInfoParcelable(final ModuleInfo moduleInfo) {
        DLog.i(TAG, "deleteModuleInfoParcelable, moduleInfo: " + moduleInfo);
        if (moduleInfo != null && !TextUtils.isEmpty(moduleInfo.getId())) {
            final String id5 = moduleInfo.getId();
            final String cacheFilePath = getCacheFilePath(id5);
            final Object moduleLock = getModuleLock(id5);
            Runnable runnable = new Runnable() { // from class: com.tencent.ams.dsdk.cache.a
                @Override // java.lang.Runnable
                public final void run() {
                    ModuleConfigCache.lambda$deleteModuleInfoParcelable$0(moduleLock, id5, cacheFilePath, moduleInfo);
                }
            };
            if (DKConfiguration.isEnableOrganizeThreads()) {
                WorkThreadManager.getInstance().getBackgroundThreadPool().execute(runnable);
                return;
            } else {
                WorkThreadManager.getInstance().getImmediateThreadPool().execute(runnable);
                return;
            }
        }
        DLog.w(TAG, "module info is empty.");
    }

    public static List<ModuleInfo> getBusinessInfoList() {
        return getModuleInfoList(2);
    }

    private static String getCacheDir() {
        if (dirStr == null) {
            String fileDir = FileUtils.getFileDir();
            if (TextUtils.isEmpty(fileDir)) {
                return null;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(fileDir);
            String str = PATH_DIV;
            sb5.append(str);
            sb5.append(CACHE_DIR);
            sb5.append(str);
            dirStr = sb5.toString();
        }
        return dirStr;
    }

    private static String getCacheFilePath(String str) {
        String cacheDir = getCacheDir();
        if (TextUtils.isEmpty(cacheDir)) {
            return null;
        }
        return cacheDir + str + CACHE_SUFFIX;
    }

    private static ModuleInfo getCacheModuleInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return sModuleInfoCache.get(str);
    }

    private static List<String> getModuleIds() {
        File[] listFiles;
        String cacheDir = getCacheDir();
        if (!FileUtils.isFileExist(cacheDir) || (listFiles = new File(cacheDir).listFiles()) == null || listFiles.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : listFiles) {
            if (file != null) {
                String name = file.getName();
                if (isExclude(name)) {
                    DLog.i(TAG, "exclude file: " + name);
                } else {
                    int indexOf = name.indexOf(CACHE_SUFFIX);
                    if (indexOf > 0) {
                        arrayList.add(name.substring(0, indexOf));
                    }
                }
            }
        }
        return arrayList;
    }

    public static ModuleInfo getModuleInfo(String str) {
        Object moduleLock;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ModuleInfo cacheModuleInfo = getCacheModuleInfo(str);
        if (cacheModuleInfo == null && (moduleLock = getModuleLock(str)) != null) {
            synchronized (moduleLock) {
                cacheModuleInfo = getCacheModuleInfo(str);
                if (cacheModuleInfo == null && !sDeletedModuleList.contains(str)) {
                    ModuleInfo readModuleCacheWithParcelable = readModuleCacheWithParcelable(str);
                    putCacheModuleInfo(readModuleCacheWithParcelable);
                    cacheModuleInfo = readModuleCacheWithParcelable;
                }
            }
        }
        return cacheModuleInfo;
    }

    public static synchronized List<ModuleInfo> getModuleInfoList() {
        synchronized (ModuleConfigCache.class) {
            if (sIsReadAllLocal) {
                return new ArrayList(sModuleInfoCache.values());
            }
            List<String> moduleIds = getModuleIds();
            ArrayList arrayList = new ArrayList();
            if (moduleIds != null && !moduleIds.isEmpty()) {
                Iterator<String> it = moduleIds.iterator();
                while (it.hasNext()) {
                    ModuleInfo moduleInfo = getModuleInfo(it.next());
                    if (moduleInfo != null) {
                        arrayList.add(moduleInfo);
                    }
                }
                sIsReadAllLocal = true;
                return arrayList;
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized Object getModuleLock(String str) {
        synchronized (ModuleConfigCache.class) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            ConcurrentHashMap<String, Object> concurrentHashMap = sLockCacheMap;
            Object obj = concurrentHashMap.get(str);
            if (obj == null) {
                obj = new byte[0];
                concurrentHashMap.put(str, obj);
            }
            return obj;
        }
    }

    public static List<ModuleInfo> getVendorInfoList() {
        return getModuleInfoList(1);
    }

    private static boolean isExclude(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        for (String str2 : sExcludeConfFiles) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteModuleInfoParcelable$0(Object obj, String str, String str2, ModuleInfo moduleInfo) {
        if (obj != null) {
            synchronized (obj) {
                if (sDeletedModuleList.contains(str)) {
                    FileUtils.deleteFile(str2);
                    DLog.i(TAG, "deleteModuleInfoParcelable finish, moduleInfo: " + moduleInfo);
                }
            }
        }
    }

    private static void putCacheModuleInfo(ModuleInfo moduleInfo) {
        if (moduleInfo != null && !TextUtils.isEmpty(moduleInfo.getId())) {
            sModuleInfoCache.put(moduleInfo.getId(), moduleInfo);
        }
    }

    private static ModuleInfo readModuleCacheWithParcelable(String str) {
        DLog.d(TAG, "readModuleCacheWithParcelable, moduleId: " + str);
        ModuleInfo moduleInfo = null;
        if (TextUtils.isEmpty(str)) {
            DLog.w(TAG, "module id is empty.");
            return null;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            String cacheFilePath = getCacheFilePath(str);
            byte[] readBytesFromFile = FileUtils.readBytesFromFile(cacheFilePath);
            if (readBytesFromFile != null && readBytesFromFile.length > 0) {
                DLog.d(TAG, "read cache file time cost:" + (System.currentTimeMillis() - currentTimeMillis) + ", cache path: " + cacheFilePath);
                long currentTimeMillis2 = System.currentTimeMillis();
                ModuleInfo createFromParcel = ModuleInfo.CREATOR.createFromParcel(ParcelableUtil.unmarshall(readBytesFromFile));
                try {
                    DLog.d(TAG, "byte to model time cost:" + (System.currentTimeMillis() - currentTimeMillis2) + ", cache path: " + cacheFilePath);
                    moduleInfo = createFromParcel;
                } catch (Throwable th5) {
                    th = th5;
                    moduleInfo = createFromParcel;
                    DLog.e(TAG, "readModuleCacheWithParcelable error.", th);
                    return moduleInfo;
                }
            } else {
                DLog.w(TAG, "read file to bytes failed.");
            }
        } catch (Throwable th6) {
            th = th6;
        }
        return moduleInfo;
    }

    public static void removeModuleInfoCache(ModuleInfo moduleInfo) {
        if (moduleInfo != null && !TextUtils.isEmpty(moduleInfo.getId())) {
            sModuleInfoCache.remove(moduleInfo.getId());
        }
    }

    public static synchronized void saveModuleInfo(ModuleInfo moduleInfo) {
        String id5;
        synchronized (ModuleConfigCache.class) {
            if (moduleInfo == null) {
                id5 = null;
            } else {
                id5 = moduleInfo.getId();
            }
            if (TextUtils.isEmpty(id5)) {
                return;
            }
            Object moduleLock = getModuleLock(id5);
            if (moduleLock != null) {
                synchronized (moduleLock) {
                    putCacheModuleInfo(moduleInfo);
                    sDeletedModuleList.remove(id5);
                    cacheModuleWithParcelable(moduleInfo);
                }
            }
        }
    }

    private static List<ModuleInfo> getModuleInfoList(int i3) {
        List<ModuleInfo> moduleInfoList = getModuleInfoList();
        ArrayList arrayList = new ArrayList();
        for (ModuleInfo moduleInfo : moduleInfoList) {
            if (moduleInfo != null && moduleInfo.getFileType() == i3) {
                arrayList.add(moduleInfo);
            }
        }
        return arrayList;
    }
}
