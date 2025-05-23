package com.tencent.ams.dsdk.fodder;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ams.dsdk.cache.ModuleConfigCache;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.data.ModuleInfo;
import com.tencent.ams.dsdk.download.DownloadException;
import com.tencent.ams.dsdk.download.DownloadManager;
import com.tencent.ams.dsdk.download.DownloadRequest;
import com.tencent.ams.dsdk.download.SimpleDownloadCallback;
import com.tencent.ams.dsdk.fodder.BundleEventListener;
import com.tencent.ams.dsdk.monitor.metric.DynamicReporter;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.dsdk.utils.FileUtils;
import com.tencent.ams.dsdk.utils.Md5Utils;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.oskplayer.cache.FileDataSink;
import com.tencent.pts.utils.PTSFileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class ModuleBundleManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "BundleManager";
    private final String mFileDir;
    private String mFilePath;
    private final byte[] mLock;
    private final ConcurrentHashMap<String, Object> mLockCacheMap;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ModuleBundleManager(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.mFilePath = null;
        this.mLock = new byte[0];
        this.mLockCacheMap = new ConcurrentHashMap<>();
        this.mFileDir = str;
        initPath();
    }

    private DownloadRequest buildRequest(ModuleInfo moduleInfo) {
        if (moduleInfo == null || TextUtils.isEmpty(moduleInfo.getName()) || TextUtils.isEmpty(moduleInfo.getUrl())) {
            return null;
        }
        String filePath = getFilePath();
        if (TextUtils.isEmpty(filePath)) {
            DLog.w(TAG, "build request failed: filePath is empty");
            return null;
        }
        return new DownloadRequest.Builder().setName(moduleInfo.getName()).setFileMd5(moduleInfo.getMd5()).setUrl(moduleInfo.getUrl()).setFolder(filePath).build();
    }

    private boolean checkModuleBundleMD5(ModuleInfo moduleInfo, File file) {
        DLog.d(TAG, "checkModuleBundleMD5 bundleDir: " + file);
        if (moduleInfo.getEncryptType() != 1 && !DKConfiguration.isCheckAllEncryptTypeModuleBundleMD5()) {
            DLog.i(TAG, "checkModuleBundleMD5 success: not des encrypt and not check all type");
            DynamicReporter.reportModuleCheckUnzipFileMD5(moduleInfo, TagValue.IGNORE);
            return true;
        }
        if (file != null && file.exists()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                DLog.w(TAG, "checkModuleBundleMD5 failed: bundleDir list files is null");
                DynamicReporter.reportModuleCheckUnzipFileMD5(moduleInfo, TagValue.FILES_EMPTY);
                return false;
            }
            File file2 = new File(file, "manifest.json");
            if (!file2.exists()) {
                if (moduleInfo.getEncryptType() == 1) {
                    DLog.w(TAG, "checkModuleBundleMD5 failed: manifest file not found");
                    DynamicReporter.reportModuleCheckUnzipFileMD5(moduleInfo, TagValue.MANIFEST_INVALID);
                    return false;
                }
                DynamicReporter.reportModuleCheckUnzipFileMD5(moduleInfo, TagValue.MANIFEST_INVALID_SUCCESS);
                DLog.w(TAG, "checkModuleBundleMD5 success: manifest file not found, not des encrypt, ignore check");
                return true;
            }
            Map<String, String> readBundleMD5Map = readBundleMD5Map(file2);
            if (readBundleMD5Map != null && !readBundleMD5Map.isEmpty()) {
                for (File file3 : listFiles) {
                    if (file3 != null && file3.getName().endsWith(PTSFileUtil.JS_FORMAT)) {
                        String md5 = Md5Utils.toMd5(file3);
                        String str = readBundleMD5Map.get(file3.getName());
                        if (str == null || !str.equals(md5)) {
                            DLog.w(TAG, "checkModuleBundleMD5 failed: '" + file + "/" + file3.getName() + "' md5 not equal, mf md5=" + str + ", fileMD5=" + md5);
                            DynamicReporter.reportModuleCheckUnzipFileMD5(moduleInfo, TagValue.MD5_UNEQUAL, file3.getName());
                            return false;
                        }
                    }
                }
                DLog.i(TAG, "checkModuleBundleMD5 success: " + file);
                DynamicReporter.reportModuleCheckUnzipFileMD5(moduleInfo, "none");
                return true;
            }
            DLog.w(TAG, "checkModuleBundleMD5 failed: md5Map is empty");
            DynamicReporter.reportModuleCheckUnzipFileMD5(moduleInfo, TagValue.MD5_MAP_EMPTY);
            return false;
        }
        DLog.w(TAG, "checkModuleBundleMD5 failed: bundleDir not exists");
        DynamicReporter.reportModuleCheckUnzipFileMD5(moduleInfo, TagValue.DIR_INVALID);
        return false;
    }

    private void deleteModuleFile(ModuleInfo moduleInfo) {
        DLog.i(TAG, "deleteModuleFile, moduleInfo: " + moduleInfo);
        if (moduleInfo == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        DynamicReporter.reportModuleClearStart(moduleInfo);
        DynamicReporter.reportModuleClearEnd(uptimeMillis, FileUtils.deleteFile(getModuleFilePath(moduleInfo)), moduleInfo);
        long uptimeMillis2 = SystemClock.uptimeMillis();
        File file = new File(getFilePath(), moduleInfo.getName() + FileDataSink.TEMP_FILE);
        if (file.exists()) {
            DynamicReporter.reportModuleTempClearStart(moduleInfo);
            DynamicReporter.reportModuleTempClearEnd(uptimeMillis2, FileUtils.deleteFile(file), moduleInfo);
        }
    }

    private List<ModuleInfo> filterValidAndUpdateModifyDateExitsBundle(List<ModuleInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (ModuleInfo moduleInfo : list) {
                if (isValidModule(moduleInfo)) {
                    arrayList.add(moduleInfo);
                    if (checkModuleBundleExits(moduleInfo)) {
                        DLog.d(TAG, "bundle exits.");
                        updateModuleFileModifyDate(moduleInfo);
                    }
                }
            }
        }
        return arrayList;
    }

    private String getBundleFilePath(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (!file.exists()) {
            return null;
        }
        return file.getAbsolutePath();
    }

    @BundleEventListener.ErrorCode
    private int getErrorCode(Exception exc) {
        if (exc == null) {
            return 0;
        }
        if (!(exc instanceof DownloadException)) {
            return 6;
        }
        switch (((DownloadException) exc).getErrorCode()) {
            case 1:
                return 1;
            case 2:
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                return 6;
        }
    }

    private String getFileName(ModuleInfo moduleInfo) {
        String name;
        if (moduleInfo == null) {
            name = null;
        } else {
            name = moduleInfo.getName();
        }
        if (TextUtils.isEmpty(name)) {
            return null;
        }
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf > 0) {
            return name.substring(0, lastIndexOf);
        }
        return name;
    }

    private Object getModuleLock(String str) {
        Object obj;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (ModuleBundleManager.class) {
            obj = this.mLockCacheMap.get(str);
            if (obj == null) {
                obj = new byte[0];
                this.mLockCacheMap.put(str, obj);
            }
        }
        return obj;
    }

    private void initPath() {
        if (TextUtils.isEmpty(this.mFileDir)) {
            DLog.w(TAG, "init path failed: null dir");
            return;
        }
        String fileDir = FileUtils.getFileDir();
        if (fileDir != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(fileDir);
            String str = File.separator;
            sb5.append(str);
            sb5.append(this.mFileDir);
            sb5.append(str);
            this.mFilePath = sb5.toString();
            DLog.i(TAG, "init path success: " + this.mFilePath);
            return;
        }
        DLog.w(TAG, "init path failed: null root path");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isContains(List<ModuleInfo> list, ModuleInfo moduleInfo) {
        if (list != null && !list.isEmpty() && moduleInfo != null) {
            for (ModuleInfo moduleInfo2 : list) {
                if (moduleInfo2 != null && !TextUtils.isEmpty(moduleInfo2.getId()) && moduleInfo2.getId().equals(moduleInfo.getId())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDownloadFinish(ModuleInfo moduleInfo, Exception exc, long j3) {
        String id5;
        DLog.i(TAG, "notifyDownloadFinish, moduleInfo: " + moduleInfo + ", exception: " + exc);
        BundleEventListener bundleEventListener = DKConfiguration.getBundleEventListener();
        if (bundleEventListener != null) {
            if (moduleInfo == null) {
                id5 = null;
            } else {
                id5 = moduleInfo.getId();
            }
            bundleEventListener.onDownloadFinish(id5, getErrorCode(exc), System.currentTimeMillis() - j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyDownloadStart(ModuleInfo moduleInfo) {
        String id5;
        DLog.i(TAG, "notifyDownloadStart, moduleInfo: " + moduleInfo);
        BundleEventListener bundleEventListener = DKConfiguration.getBundleEventListener();
        if (bundleEventListener != null) {
            if (moduleInfo == null) {
                id5 = null;
            } else {
                id5 = moduleInfo.getId();
            }
            bundleEventListener.onDownloadStart(id5);
        }
    }

    private Map<String, String> readBundleMD5Map(File file) {
        if (file != null && file.exists()) {
            try {
                JSONArray optJSONArray = new JSONObject(FileUtils.stringFromFile(file)).optJSONArray("files");
                if (optJSONArray != null) {
                    HashMap hashMap = new HashMap();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("name");
                            String optString2 = optJSONObject.optString("md5");
                            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                                hashMap.put(optString, optString2);
                            }
                        }
                    }
                    return hashMap;
                }
            } catch (JSONException e16) {
                DLog.w(TAG, "readBundleMD5Map failed", e16);
            }
            DLog.w(TAG, "readBundleMD5Map failed: invalid json content");
        }
        return null;
    }

    private void removeModuleLock(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (ModuleBundleManager.class) {
            this.mLockCacheMap.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unzipBundleFile(ModuleInfo moduleInfo) {
        DLog.d(TAG, "unzipBundleFile, module info: " + moduleInfo);
        DynamicReporter.reportUnzipBundleFileStart(moduleInfo);
        if (moduleInfo != null && !TextUtils.isEmpty(moduleInfo.getName())) {
            String filePath = getFilePath();
            if (TextUtils.isEmpty(filePath)) {
                DLog.w(TAG, "zip file path is null.");
                DynamicReporter.reportUnzipBundleFileEnd(moduleInfo, TagValue.FILE_PATH_INVALID);
                return;
            }
            String str = filePath + moduleInfo.getName();
            File file = new File(str);
            Object moduleLock = getModuleLock(str);
            DLog.d(TAG, "lock: " + moduleLock);
            if (moduleLock != null) {
                synchronized (moduleLock) {
                    DLog.d(TAG, "start unzip");
                    if (!file.exists()) {
                        DLog.w(TAG, "zip file not exists. file: " + str);
                        DynamicReporter.reportUnzipBundleFileEnd(moduleInfo, TagValue.ZIP_FILE_INVALID);
                        return;
                    }
                    String moduleFilePath = getModuleFilePath(moduleInfo);
                    if (TextUtils.isEmpty(moduleFilePath)) {
                        DLog.w(TAG, "target file path is null.");
                        DynamicReporter.reportUnzipBundleFileEnd(moduleInfo, TagValue.TARGET_PATH_INVALID);
                        return;
                    }
                    File file2 = new File(moduleFilePath);
                    FileUtils.deleteFile(file2);
                    try {
                        File file3 = new File(moduleFilePath + "_temp");
                        FileUtils.deleteFile(file3);
                        FileUtils.unZipFile(str, file3, moduleInfo.getEncryptType());
                        if (!checkModuleBundleMD5(moduleInfo, file3)) {
                            DLog.d(TAG, "decrypt bundle file md5 error");
                        } else {
                            DLog.i(TAG, "unzipBundleFile success: " + file3.renameTo(file2));
                        }
                        FileUtils.deleteFile(file3);
                        FileUtils.deleteFile(file);
                        DynamicReporter.reportUnzipBundleFileEnd(moduleInfo, "none");
                    } catch (Throwable th5) {
                        DLog.e(TAG, "unzip file error.", th5);
                        FileUtils.deleteFile(file2);
                        DynamicReporter.reportUnzipBundleFileEnd(moduleInfo, th5.getClass().getSimpleName(), th5.getMessage());
                    }
                    DLog.d(TAG, "end unzip");
                    removeModuleLock(str);
                    return;
                }
            }
            return;
        }
        DLog.w(TAG, "module info is invalid.");
        DynamicReporter.reportUnzipBundleFileEnd(moduleInfo, TagValue.MODULE_INFO_INVALID);
    }

    public boolean checkModuleBundleExits(ModuleInfo moduleInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) moduleInfo)).booleanValue();
        }
        DLog.d(TAG, "checkModuleExits, module: " + moduleInfo);
        String moduleFilePath = getModuleFilePath(moduleInfo);
        if (TextUtils.isEmpty(moduleFilePath)) {
            DLog.w(TAG, "module file path is null.");
            return false;
        }
        return new File(moduleFilePath).exists();
    }

    public void clearCache(List<ModuleInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) list);
        } else {
            doClearCache(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deleteModuleInfo(ModuleInfo moduleInfo) {
        if (isValidModule(moduleInfo)) {
            ModuleConfigCache.deleteModuleInfo(moduleInfo);
            deleteModuleFile(moduleInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doClearCache(List<ModuleInfo> list) {
        File[] listFiles;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) list);
            return;
        }
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(ModuleConfigCache.getModuleInfoList());
            arrayList.addAll(list);
            String filePath = getFilePath();
            if (FileUtils.isFileExist(filePath) && (listFiles = new File(filePath).listFiles()) != null && listFiles.length != 0) {
                for (File file : listFiles) {
                    if (isNeedDelete(file, arrayList)) {
                        FileUtils.deleteFile(file);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: doUpdateBundles, reason: merged with bridge method [inline-methods] */
    public void lambda$updateBundles$0(List<ModuleInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
            return;
        }
        DLog.d(TAG, "doUpdateBundles");
        if (list == null || list.isEmpty()) {
            DLog.w(TAG, "preload response is empty, use local module info.");
            list = ModuleConfigCache.getModuleInfoList();
        }
        if (list != null && !list.isEmpty()) {
            for (ModuleInfo moduleInfo : list) {
                if (isValidModule(moduleInfo)) {
                    if (moduleInfo.isForceUpdate()) {
                        ModuleConfigCache.saveModuleInfo(moduleInfo);
                        downloadBundleAsync(moduleInfo);
                    } else if (!checkModuleBundleExits(moduleInfo)) {
                        downloadBundleAsync(moduleInfo);
                    } else {
                        ModuleConfigCache.saveModuleInfo(moduleInfo);
                        updateModuleFileModifyDate(moduleInfo);
                        DynamicReporter.reportDownloadHitCache(moduleInfo);
                    }
                }
            }
            return;
        }
        DLog.w(TAG, "preload module info list is empty.");
    }

    protected void downloadBundleAsync(ModuleInfo moduleInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) moduleInfo);
            return;
        }
        DLog.i(TAG, "downloadBundleAsync, module: " + moduleInfo);
        long currentTimeMillis = System.currentTimeMillis();
        long uptimeMillis = SystemClock.uptimeMillis();
        DownloadRequest buildRequest = buildRequest(moduleInfo);
        if (buildRequest == null) {
            return;
        }
        DownloadManager.getInstance().download(buildRequest, new SimpleDownloadCallback(moduleInfo, currentTimeMillis, uptimeMillis) { // from class: com.tencent.ams.dsdk.fodder.ModuleBundleManager.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ModuleInfo val$moduleInfo;
            final /* synthetic */ long val$startTime;
            final /* synthetic */ long val$startTimeByUp;

            {
                this.val$moduleInfo = moduleInfo;
                this.val$startTime = currentTimeMillis;
                this.val$startTimeByUp = uptimeMillis;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ModuleBundleManager.this, moduleInfo, Long.valueOf(currentTimeMillis), Long.valueOf(uptimeMillis));
                }
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onCancelled() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                DLog.i(ModuleBundleManager.TAG, "onCancelled async, moduleInfo: " + this.val$moduleInfo);
                ModuleBundleManager.this.notifyDownloadFinish(this.val$moduleInfo, new DownloadException.CancelledException(), this.val$startTime);
                DynamicReporter.reportDownloadEnd(this.val$startTimeByUp, TagValue.DOWNLOAD_CANCEL, this.val$moduleInfo);
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadComplete() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                    return;
                }
                DLog.i(ModuleBundleManager.TAG, "download complete async. module: " + this.val$moduleInfo);
                ModuleBundleManager.this.unzipBundleFile(this.val$moduleInfo);
                ModuleBundleManager.this.notifyDownloadFinish(this.val$moduleInfo, null, this.val$startTime);
                if (!this.val$moduleInfo.isForceUpdate()) {
                    ModuleConfigCache.saveModuleInfo(this.val$moduleInfo);
                }
                DynamicReporter.reportDownloadEnd(this.val$startTimeByUp, "none", this.val$moduleInfo);
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadFailed(Exception exc) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) exc);
                    return;
                }
                DLog.e(ModuleBundleManager.TAG, "download failed. module: " + this.val$moduleInfo, exc);
                ModuleBundleManager.this.notifyDownloadFinish(this.val$moduleInfo, exc, this.val$startTime);
                DynamicReporter.reportDownloadEnd(this.val$startTimeByUp, TagValue.DOWNLOAD_FAIL, this.val$moduleInfo);
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this);
                    return;
                }
                DLog.i(ModuleBundleManager.TAG, "onDownloadStart, async");
                ModuleBundleManager.this.notifyDownloadStart(this.val$moduleInfo);
                DynamicReporter.reportDownloadStart(this.val$moduleInfo);
            }
        });
    }

    protected String downloadBundleSync(ModuleInfo moduleInfo, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, this, moduleInfo, Long.valueOf(j3));
        }
        DLog.i(TAG, "downloadBundle, module: " + moduleInfo);
        long currentTimeMillis = System.currentTimeMillis();
        DownloadRequest buildRequest = buildRequest(moduleInfo);
        if (buildRequest == null) {
            DLog.w(TAG, "request is null, download failed.");
            return null;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        DownloadManager.getInstance().download(buildRequest, new SimpleDownloadCallback(moduleInfo, currentTimeMillis, countDownLatch) { // from class: com.tencent.ams.dsdk.fodder.ModuleBundleManager.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ CountDownLatch val$latch;
            final /* synthetic */ ModuleInfo val$moduleInfo;
            final /* synthetic */ long val$startTime;

            {
                this.val$moduleInfo = moduleInfo;
                this.val$startTime = currentTimeMillis;
                this.val$latch = countDownLatch;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, ModuleBundleManager.this, moduleInfo, Long.valueOf(currentTimeMillis), countDownLatch);
                }
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onCancelled() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 4)) {
                    iPatchRedirector2.redirect((short) 4, (Object) this);
                    return;
                }
                DLog.i(ModuleBundleManager.TAG, "onCancelled. moduleInfo: " + this.val$moduleInfo);
                ModuleBundleManager.this.notifyDownloadFinish(this.val$moduleInfo, new DownloadException.CancelledException(), this.val$startTime);
                this.val$latch.countDown();
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadComplete() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this);
                    return;
                }
                DLog.i(ModuleBundleManager.TAG, "download complete. module: " + this.val$moduleInfo);
                ModuleBundleManager.this.unzipBundleFile(this.val$moduleInfo);
                ModuleBundleManager.this.notifyDownloadFinish(this.val$moduleInfo, null, this.val$startTime);
                this.val$latch.countDown();
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadFailed(Exception exc) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 5)) {
                    iPatchRedirector2.redirect((short) 5, (Object) this, (Object) exc);
                    return;
                }
                DLog.i(ModuleBundleManager.TAG, "download failed. module: " + this.val$moduleInfo);
                ModuleBundleManager.this.notifyDownloadFinish(this.val$moduleInfo, exc, this.val$startTime);
                this.val$latch.countDown();
            }

            @Override // com.tencent.ams.dsdk.download.SimpleDownloadCallback, com.tencent.ams.dsdk.download.Download.Callback
            public void onDownloadStart() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                DLog.i(ModuleBundleManager.TAG, "onDownloadStart, moduleInfo: " + this.val$moduleInfo);
                ModuleBundleManager.this.notifyDownloadStart(this.val$moduleInfo);
            }
        });
        try {
            countDownLatch.await(j3, TimeUnit.MILLISECONDS);
        } catch (Throwable th5) {
            DLog.d(TAG, "await error.", th5);
        }
        return getModuleFilePath(moduleInfo);
    }

    public String getFilePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (TextUtils.isEmpty(this.mFilePath)) {
            initPath();
        }
        return this.mFilePath;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getModuleBundleFilePath(String str, String str2, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? getModuleBundleFilePath(ModuleConfigCache.getModuleInfo(str), str2, z16, j3) : (String) iPatchRedirector.redirect((short) 5, this, str, str2, Boolean.valueOf(z16), Long.valueOf(j3));
    }

    protected String getModuleFilePath(ModuleInfo moduleInfo) {
        String fileName;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this, (Object) moduleInfo);
        }
        String filePath = getFilePath();
        if (TextUtils.isEmpty(filePath) || (fileName = getFileName(moduleInfo)) == null) {
            return null;
        }
        return filePath + fileName;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isInModuleList(File file, List<ModuleInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) file, (Object) list)).booleanValue();
        }
        if (file != null && list != null && !list.isEmpty()) {
            String name = file.getName();
            for (ModuleInfo moduleInfo : list) {
                if (moduleInfo != null && !TextUtils.isEmpty(moduleInfo.getName())) {
                    String name2 = moduleInfo.getName();
                    if (name.contains(name2) || name2.contains(name)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    protected abstract boolean isNeedDelete(File file, List<ModuleInfo> list);

    protected abstract boolean isValidModule(ModuleInfo moduleInfo);

    public void updateBundles(final List<ModuleInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.ams.dsdk.fodder.a
            @Override // java.lang.Runnable
            public final void run() {
                ModuleBundleManager.this.lambda$updateBundles$0(list);
            }
        };
        if (DKConfiguration.isEnableOrganizeThreads()) {
            DynamicUtils.runOnAsyncThread(runnable);
        } else {
            WorkThreadManager.getInstance().getImmediateThreadPool().execute(runnable);
        }
    }

    protected void updateModuleFileModifyDate(ModuleInfo moduleInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) moduleInfo);
            return;
        }
        DLog.d(TAG, "updateModuleFileModifyDate, module: " + moduleInfo);
        String moduleFilePath = getModuleFilePath(moduleInfo);
        if (!TextUtils.isEmpty(moduleFilePath)) {
            try {
                File file = new File(moduleFilePath);
                if (file.exists()) {
                    FileUtils.updateLastModified(file);
                }
            } catch (Throwable th5) {
                DLog.e(TAG, "updateModuleFileModifyDate error.", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getModuleBundleFilePath(ModuleInfo moduleInfo, String str, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, this, moduleInfo, str, Boolean.valueOf(z16), Long.valueOf(j3));
        }
        if (moduleInfo == null) {
            return null;
        }
        synchronized (moduleInfo) {
            String moduleFilePath = getModuleFilePath(moduleInfo);
            String bundleFilePath = getBundleFilePath(moduleFilePath, str);
            if (!TextUtils.isEmpty(bundleFilePath)) {
                updateModuleFileModifyDate(moduleInfo);
                return bundleFilePath;
            }
            if (z16) {
                moduleFilePath = downloadBundleSync(moduleInfo, j3);
            } else {
                downloadBundleAsync(moduleInfo);
            }
            return getBundleFilePath(moduleFilePath, str);
        }
    }

    void deleteModuleInfo(String str) {
        DLog.i(TAG, "deleteModuleInfo, moduleId: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        deleteModuleFile(ModuleConfigCache.getModuleInfo(str));
    }
}
