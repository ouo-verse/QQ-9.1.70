package com.tencent.ams.dsdk.cache;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.data.TemplateInfo;
import com.tencent.ams.dsdk.utils.DLog;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.dsdk.utils.FileUtils;
import com.tencent.ams.dsdk.utils.ParcelableUtil;
import com.tencent.ams.dsdk.utils.WorkThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TemplateConfigCache {
    static IPatchRedirector $redirector_ = null;
    private static final String CACHE_DIR = "conf";
    protected static final String CACHE_FILE_NAME = "templates.conf";
    private static final String TAG = "TemplateConfigCache";
    private String mCachePath;
    private boolean mIsInited;
    private final ConcurrentHashMap<String, ConcurrentHashMap<String, TemplateInfo>> mOtherTemplateCache;
    private final ConcurrentHashMap<String, TemplateInfo> mTemplateCache;
    private TemplateConfig mTemplateConfig;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class Holder {
        static IPatchRedirector $redirector_;
        private static final TemplateConfigCache INSTANCE;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14097);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                INSTANCE = new TemplateConfigCache(null);
            }
        }

        Holder() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class TemplateConfig implements Parcelable {
        static IPatchRedirector $redirector_;
        public static final Parcelable.Creator<TemplateConfig> CREATOR;
        private Map<String, Map<String, TemplateInfo>> mOtherScenesCache;
        private Map<String, TemplateInfo> mTemplateInfoCache;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14118);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 6)) {
                redirector.redirect((short) 6);
            } else {
                CREATOR = new Parcelable.Creator<TemplateConfig>() { // from class: com.tencent.ams.dsdk.cache.TemplateConfigCache.TemplateConfig.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this);
                        }
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public TemplateConfig createFromParcel(Parcel parcel) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new TemplateConfig(parcel) : (TemplateConfig) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // android.os.Parcelable.Creator
                    public TemplateConfig[] newArray(int i3) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new TemplateConfig[i3] : (TemplateConfig[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                    }
                };
            }
        }

        /* synthetic */ TemplateConfig(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                return;
            }
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) anonymousClass1);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            } else {
                parcel.writeMap(this.mTemplateInfoCache);
                parcel.writeMap(this.mOtherScenesCache);
            }
        }

        TemplateConfig() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        protected TemplateConfig(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            } else {
                this.mTemplateInfoCache = parcel.readHashMap(getClass().getClassLoader());
                this.mOtherScenesCache = parcel.readHashMap(getClass().getClassLoader());
            }
        }
    }

    /* synthetic */ TemplateConfigCache(AnonymousClass1 anonymousClass1) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return;
        }
        iPatchRedirector.redirect((short) 9, (Object) this, (Object) anonymousClass1);
    }

    private TemplateConfig createTemplateConfig(String str, Map<String, TemplateInfo> map) {
        TemplateConfig templateConfig = this.mTemplateConfig;
        if (templateConfig == null) {
            templateConfig = new TemplateConfig((AnonymousClass1) null);
        }
        if (TextUtils.isEmpty(str)) {
            templateConfig.mTemplateInfoCache = map;
        } else {
            Map map2 = templateConfig.mOtherScenesCache;
            if (map2 == null) {
                map2 = new HashMap();
                templateConfig.mOtherScenesCache = map2;
            }
            map2.put(str, map);
        }
        return templateConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void doInitIfNeed() {
        if (this.mIsInited) {
            return;
        }
        DLog.i(TAG, "real doInit");
        try {
            this.mTemplateConfig = readCacheWithParcel();
            updateMemoryCache();
        } catch (Throwable th5) {
            DLog.e(TAG, "doInitIfNeed error.", th5);
            this.mTemplateConfig = null;
        }
        this.mIsInited = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: doUpdateTemplateCache, reason: merged with bridge method [inline-methods] */
    public synchronized void lambda$updateTemplateCache$1(String str, List<TemplateInfo> list) {
        TemplateConfig createTemplateConfig = createTemplateConfig(str, mapOf(list));
        this.mTemplateConfig = createTemplateConfig;
        if (saveCacheWithParcel(createTemplateConfig)) {
            updateMemoryCache();
        }
    }

    private synchronized void doUpdateTemplateInfo(TemplateInfo templateInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            this.mTemplateCache.put(templateInfo.getTemplateId(), templateInfo);
        } else {
            getOrCreateSceneTemplateCache(str).put(templateInfo.getTemplateId(), templateInfo);
        }
        TemplateConfig createTemplateConfig = createTemplateConfig((String) null, templateInfo);
        this.mTemplateConfig = createTemplateConfig;
        saveCacheWithParcel(createTemplateConfig);
    }

    private String getCachePath() {
        if (this.mCachePath == null) {
            String fileDir = FileUtils.getFileDir();
            if (TextUtils.isEmpty(fileDir)) {
                return null;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(fileDir);
            String str = File.separator;
            sb5.append(str);
            sb5.append(CACHE_DIR);
            sb5.append(str);
            sb5.append(CACHE_FILE_NAME);
            this.mCachePath = sb5.toString();
        }
        return this.mCachePath;
    }

    public static TemplateConfigCache getInstance() {
        return Holder.INSTANCE;
    }

    @NonNull
    private ConcurrentHashMap<String, TemplateInfo> getOrCreateSceneTemplateCache(String str) {
        ConcurrentHashMap<String, TemplateInfo> concurrentHashMap = this.mOtherTemplateCache.get(str);
        if (concurrentHashMap == null) {
            ConcurrentHashMap<String, TemplateInfo> concurrentHashMap2 = new ConcurrentHashMap<>();
            this.mOtherTemplateCache.put(str, concurrentHashMap2);
            return concurrentHashMap2;
        }
        return concurrentHashMap;
    }

    private void incrementalUpdateMemoryCache(Map<String, TemplateInfo> map) {
        incrementalUpdateMemoryCache(map, this.mTemplateCache);
    }

    private void init() {
        DLog.i(TAG, "init");
        WorkThreadManager.getInstance().getImmediateThreadPool().execute(new Runnable() { // from class: com.tencent.ams.dsdk.cache.TemplateConfigCache.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) TemplateConfigCache.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    DLog.i(TemplateConfigCache.TAG, "doInit");
                    TemplateConfigCache.this.doInitIfNeed();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTemplateCache$0(List list) {
        doInitIfNeed();
        lambda$updateTemplateCache$1(null, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$updateTemplateInfo$2(TemplateInfo templateInfo, String str) {
        doInitIfNeed();
        doUpdateTemplateInfo(templateInfo, str);
    }

    private Map<String, TemplateInfo> mapOf(List<TemplateInfo> list) {
        String templateId;
        if (list == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (TemplateInfo templateInfo : list) {
            if (templateInfo == null) {
                templateId = null;
            } else {
                templateId = templateInfo.getTemplateId();
            }
            if (templateInfo != null && !TextUtils.isEmpty(templateId) && !TextUtils.isEmpty(templateInfo.getUrl())) {
                hashMap.put(templateId, templateInfo);
            }
        }
        return hashMap;
    }

    private TemplateConfig readCacheWithParcel() {
        String cachePath = getCachePath();
        TemplateConfig templateConfig = null;
        if (cachePath == null) {
            DLog.w(TAG, "filePath is null or empty.");
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            byte[] readBytesFromFile = FileUtils.readBytesFromFile(cachePath);
            if (readBytesFromFile != null) {
                templateConfig = TemplateConfig.CREATOR.createFromParcel(ParcelableUtil.unmarshall(readBytesFromFile));
            }
        } catch (Throwable th5) {
            DLog.e(TAG, "readCacheWithParcel error.", th5);
        }
        DLog.d(TAG, "readCacheWithParcel, timeCost: " + (System.currentTimeMillis() - currentTimeMillis));
        return templateConfig;
    }

    private boolean saveCacheWithParcel(TemplateConfig templateConfig) {
        DLog.d(TAG, "saveCacheWithParcel");
        boolean z16 = false;
        if (templateConfig != null && ((templateConfig.mTemplateInfoCache != null && !templateConfig.mTemplateInfoCache.isEmpty()) || (templateConfig.mOtherScenesCache != null && !templateConfig.mOtherScenesCache.isEmpty()))) {
            String cachePath = getCachePath();
            if (TextUtils.isEmpty(cachePath)) {
                DLog.w(TAG, "cache path is null or empty.");
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            try {
                z16 = FileUtils.writeBytesToFile(ParcelableUtil.marshall(templateConfig), cachePath);
            } catch (Throwable th5) {
                DLog.e(TAG, "saveCacheWithParcel error.", th5);
            }
            DLog.d(TAG, "saveCacheWithParcel, timeCost: " + (System.currentTimeMillis() - currentTimeMillis));
            return z16;
        }
        DLog.w(TAG, "config is null or empty.");
        return false;
    }

    private void updateMemoryCache() {
        TemplateConfig templateConfig = this.mTemplateConfig;
        if (templateConfig != null) {
            updateTemplateMemoryCache(templateConfig.mTemplateInfoCache);
            if (this.mTemplateConfig.mOtherScenesCache != null) {
                for (String str : this.mTemplateConfig.mOtherScenesCache.keySet()) {
                    Map<String, TemplateInfo> map = (Map) this.mTemplateConfig.mOtherScenesCache.get(str);
                    if (map != null) {
                        incrementalUpdateMemoryCache(map, getOrCreateSceneTemplateCache(str));
                    }
                }
            }
        }
    }

    private void updateTemplateMemoryCache(Map<String, TemplateInfo> map) {
        DLog.i(TAG, "updateTemplateMemoryCache");
        this.mTemplateCache.clear();
        incrementalUpdateMemoryCache(map);
    }

    public TemplateInfo getTemplateInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? getTemplateInfo(str, null) : (TemplateInfo) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
    }

    public List<TemplateInfo> getTemplateList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        DLog.i(TAG, "getTemplateList");
        doInitIfNeed();
        return new ArrayList(this.mTemplateCache.values());
    }

    public synchronized TemplateInfo removeTemplateCache(String str, String str2) {
        Map map;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TemplateInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
        }
        DLog.i(TAG, "removeTemplateCache, scene: " + str + ", templateId: " + str2);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        doInitIfNeed();
        this.mTemplateCache.remove(str2);
        if (this.mTemplateConfig != null) {
            if (TextUtils.isEmpty(str)) {
                if (this.mTemplateConfig.mTemplateInfoCache != null) {
                    return (TemplateInfo) this.mTemplateConfig.mTemplateInfoCache.remove(str2);
                }
            } else if (this.mTemplateConfig.mOtherScenesCache != null && (map = (Map) this.mTemplateConfig.mOtherScenesCache.get(str)) != null) {
                return (TemplateInfo) map.remove(str2);
            }
            saveCacheWithParcel(this.mTemplateConfig);
        }
        return null;
    }

    public void updateTemplateCache(final List<TemplateInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        DLog.i(TAG, "updateTemplateCache");
        if (list == null || list.isEmpty()) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.ams.dsdk.cache.e
            @Override // java.lang.Runnable
            public final void run() {
                TemplateConfigCache.this.lambda$updateTemplateCache$0(list);
            }
        };
        if (DKConfiguration.isEnableOrganizeThreads()) {
            DynamicUtils.runOnAsyncThread(runnable);
        } else {
            WorkThreadManager.getInstance().getImmediateThreadPool().execute(runnable);
        }
    }

    public void updateTemplateInfo(final TemplateInfo templateInfo, @DKEngine.SceneType final String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) templateInfo, (Object) str);
            return;
        }
        DLog.i(TAG, "updateTemplateInfo");
        if (templateInfo != null && !TextUtils.isEmpty(templateInfo.getTemplateId())) {
            Runnable runnable = new Runnable() { // from class: com.tencent.ams.dsdk.cache.c
                @Override // java.lang.Runnable
                public final void run() {
                    TemplateConfigCache.this.lambda$updateTemplateInfo$2(templateInfo, str);
                }
            };
            if (DKConfiguration.isEnableOrganizeThreads()) {
                DynamicUtils.runOnAsyncThread(runnable);
                return;
            } else {
                WorkThreadManager.getInstance().getImmediateThreadPool().execute(runnable);
                return;
            }
        }
        DLog.w(TAG, "invalid template info.");
    }

    TemplateConfigCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mTemplateCache = new ConcurrentHashMap<>();
        this.mOtherTemplateCache = new ConcurrentHashMap<>();
        this.mCachePath = null;
        this.mIsInited = false;
        init();
    }

    private void incrementalUpdateMemoryCache(Map<String, TemplateInfo> map, Map<String, TemplateInfo> map2) {
        if (map == null || map2 == null) {
            return;
        }
        try {
            for (String str : map.keySet()) {
                try {
                    TemplateInfo templateInfo = map.get(str);
                    if (!TextUtils.isEmpty(str) && templateInfo != null) {
                        map2.put(str, templateInfo);
                    }
                } catch (Throwable th5) {
                    DLog.e(TAG, "get template info error. key: " + str, th5);
                }
            }
        } catch (Throwable th6) {
            DLog.e(TAG, "incrementalUpdateMemoryCache error.", th6);
        }
    }

    public TemplateInfo getTemplateInfo(String str, @DKEngine.SceneType String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (TemplateInfo) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
        }
        DLog.i(TAG, "getTemplateInfo, templateId: " + str + ", scene: " + str2);
        TemplateInfo templateInfo = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        doInitIfNeed();
        if (TextUtils.isEmpty(str2)) {
            templateInfo = this.mTemplateCache.get(str);
        } else {
            ConcurrentHashMap<String, TemplateInfo> concurrentHashMap = this.mOtherTemplateCache.get(str2);
            if (concurrentHashMap != null) {
                templateInfo = concurrentHashMap.get(str);
            }
        }
        if (templateInfo != null) {
            templateInfo.setDownloadType(0);
        }
        return templateInfo;
    }

    public void updateTemplateCache(final String str, final List<TemplateInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) list);
            return;
        }
        if (list == null || list.isEmpty()) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.tencent.ams.dsdk.cache.d
            @Override // java.lang.Runnable
            public final void run() {
                TemplateConfigCache.this.lambda$updateTemplateCache$1(str, list);
            }
        };
        if (DKConfiguration.isEnableOrganizeThreads()) {
            DynamicUtils.runOnAsyncThread(runnable);
        } else {
            WorkThreadManager.getInstance().getImmediateThreadPool().execute(runnable);
        }
    }

    private TemplateConfig createTemplateConfig(String str, TemplateInfo templateInfo) {
        Map map;
        if (templateInfo != null && !TextUtils.isEmpty(templateInfo.getTemplateId())) {
            TemplateConfig templateConfig = this.mTemplateConfig;
            if (templateConfig == null) {
                templateConfig = new TemplateConfig((AnonymousClass1) null);
                this.mTemplateConfig = templateConfig;
            }
            if (TextUtils.isEmpty(str)) {
                map = templateConfig.mTemplateInfoCache;
                if (map == null) {
                    map = new HashMap();
                    templateConfig.mTemplateInfoCache = map;
                }
            } else {
                Map map2 = templateConfig.mOtherScenesCache;
                if (map2 == null) {
                    map2 = new HashMap();
                    templateConfig.mOtherScenesCache = map2;
                }
                Map map3 = (Map) map2.get(str);
                if (map3 == null) {
                    map3 = new HashMap();
                    map2.put(str, map3);
                }
                map = map3;
            }
            map.put(templateInfo.getTemplateId(), templateInfo);
            return templateConfig;
        }
        return this.mTemplateConfig;
    }
}
