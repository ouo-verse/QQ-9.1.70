package com.tencent.mobileqq.mini.app;

import NS_COMM.COMM;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.apkg.PreCacheInfo;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.servlet.MiniAppContentAccelerateServlet;
import com.tencent.mobileqq.mini.util.ParcelableUtil;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.ResourcePreCacheInfo;
import common.config.service.QzoneConfig;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class PreCacheManager {
    public static final String CACHE_TYPE_PERIODIC = "periodic";
    public static final String CACHE_TYPE_PRE = "pre";
    public static final String CACHE_TYPE_STATIC = "static";
    private static final String TAG = "miniapp-start_PreCacheManager";
    private static PreCacheManager instance;
    private static byte[] lock = new byte[0];
    private int PRECACHE_CONTENT_SIZE = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_precache_size_limit", 262144);
    private long PRECACHE_PERIOD_MILLIS = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_precache_period_millis", 43200000L);
    private int PRECACHE_RESOURCE_MAX_COUNT = QzoneConfig.getInstance().getConfig("qqminiapp", "mini_app_precache_resource_maxsize", 3);

    /* loaded from: classes33.dex */
    public static class ContentAccelerateRsp implements Parcelable {
        public static final Parcelable.Creator<ContentAccelerateRsp> CREATOR = new Parcelable.Creator<ContentAccelerateRsp>() { // from class: com.tencent.mobileqq.mini.app.PreCacheManager.ContentAccelerateRsp.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ContentAccelerateRsp createFromParcel(Parcel parcel) {
                return new ContentAccelerateRsp(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ContentAccelerateRsp[] newArray(int i3) {
                return new ContentAccelerateRsp[i3];
            }
        };
        public byte[] cacheData;
        public int httpReturnCode;
        public List<COMM.Entry> rspHeaders;

        public ContentAccelerateRsp() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeList(this.rspHeaders);
            parcel.writeByteArray(this.cacheData);
            parcel.writeInt(this.httpReturnCode);
        }

        protected ContentAccelerateRsp(Parcel parcel) {
            ArrayList arrayList = new ArrayList();
            this.rspHeaders = arrayList;
            parcel.readList(arrayList, COMM.Entry.class.getClassLoader());
            this.cacheData = parcel.createByteArray();
            this.httpReturnCode = parcel.readInt();
        }
    }

    /* loaded from: classes33.dex */
    public interface OnCacheListener {
        void onCacheUpdated(boolean z16, boolean z17);
    }

    /* loaded from: classes33.dex */
    public static class PreCacheDescData implements Parcelable {
        public static final Parcelable.Creator<PreCacheDescData> CREATOR = new Parcelable.Creator<PreCacheDescData>() { // from class: com.tencent.mobileqq.mini.app.PreCacheManager.PreCacheDescData.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PreCacheDescData createFromParcel(Parcel parcel) {
                return new PreCacheDescData(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public PreCacheDescData[] newArray(int i3) {
                return new PreCacheDescData[i3];
            }
        };
        public String appid;
        public String cacheKey;
        public byte[] data;
        public String filePath;
        public String path;
        public int scene;
        public long timeStamp;
        public String url;

        public PreCacheDescData() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String getCacheKey(String str) {
            if ("periodic".equals(str)) {
                return "" + (this.appid + "_" + this.url).hashCode();
            }
            if (TextUtils.isEmpty(this.cacheKey)) {
                this.cacheKey = "" + (this.appid + "_" + this.url + "_" + this.scene + "_" + this.path).hashCode();
            }
            return this.cacheKey;
        }

        public String getQuery() {
            if (TextUtils.isEmpty(this.path) || !this.path.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                return "";
            }
            String str = this.path;
            return str.substring(str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.appid);
            parcel.writeString(this.url);
            parcel.writeInt(this.scene);
            parcel.writeString(this.path);
            parcel.writeLong(this.timeStamp);
            parcel.writeString(this.filePath);
        }

        public PreCacheDescData(MiniAppConfig miniAppConfig, String str) {
            if (miniAppConfig != null) {
                this.appid = miniAppConfig.config.appId;
                LaunchParam launchParam = miniAppConfig.launchParam;
                this.scene = launchParam.scene;
                this.path = launchParam.entryPath;
                int cacheType = PreCacheManager.getCacheType(str);
                ArrayList<PreCacheInfo> arrayList = miniAppConfig.config.preCacheList;
                if (arrayList != null) {
                    Iterator<PreCacheInfo> it = arrayList.iterator();
                    while (it.hasNext()) {
                        PreCacheInfo next = it.next();
                        if (next != null && next.cacheType == cacheType) {
                            this.url = next.getDataUrl;
                            return;
                        }
                    }
                }
            }
        }

        protected PreCacheDescData(Parcel parcel) {
            this.appid = parcel.readString();
            this.url = parcel.readString();
            this.scene = parcel.readInt();
            this.path = parcel.readString();
            this.timeStamp = parcel.readLong();
            this.filePath = parcel.readString();
        }
    }

    public static PreCacheManager g() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new PreCacheManager();
                }
            }
        }
        return instance;
    }

    public static int getCacheType(String str) {
        if ("pre".equals(str)) {
            return 1;
        }
        return "periodic".equals(str) ? 2 : 0;
    }

    public void fetchPreCacheData(final MiniAppConfig miniAppConfig) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.app.PreCacheManager.1
            @Override // java.lang.Runnable
            public void run() {
                PreCacheManager.this.doFetchPreCacheData(miniAppConfig, "pre", null);
            }
        }, 16, null, false);
    }

    public void fetchPreResourceIfNeed(final MiniAppConfig miniAppConfig) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.mini.app.PreCacheManager.5
            @Override // java.lang.Runnable
            public void run() {
                PreCacheManager.this.doFetchPreResourceIfNeed(miniAppConfig);
            }
        }, 16, null, false);
    }

    public PreCacheDescData getPreFetchAppCacheData(MiniAppConfig miniAppConfig, String str) {
        FileInputStream fileInputStream;
        if (miniAppConfig == null) {
            return null;
        }
        PreCacheDescData preCacheDescData = new PreCacheDescData(miniAppConfig, str);
        MiniAppFileManager.getInstance();
        try {
            preCacheDescData = (PreCacheDescData) ParcelableUtil.readParcelableFromFile(PreCacheDescData.class, MiniAppFileManager.getPreCacheFilePath(miniAppConfig.config.appId, str, preCacheDescData.getCacheKey(str) + "_index"));
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "", th5);
        }
        if (preCacheDescData != null && preCacheDescData.filePath != null) {
            try {
                File file = new File(preCacheDescData.filePath);
                if (!file.exists()) {
                    return null;
                }
                fileInputStream = new FileInputStream(file);
                try {
                    int available = fileInputStream.available();
                    byte[] bArr = new byte[available];
                    fileInputStream.read(bArr, 0, available);
                    preCacheDescData.data = bArr;
                    try {
                        fileInputStream.close();
                    } catch (Throwable th6) {
                        QDLog.e(TAG, "", th6);
                    }
                    return preCacheDescData;
                } catch (Throwable th7) {
                    th = th7;
                    try {
                        QLog.e(TAG, 1, "", th);
                        return null;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th8) {
                                QDLog.e(TAG, "", th8);
                            }
                        }
                    }
                }
            } catch (Throwable th9) {
                th = th9;
                fileInputStream = null;
            }
        }
        return null;
    }

    public String getResourcePreCachePath(String str, String str2) {
        MiniAppFileManager.getInstance();
        return MiniAppFileManager.getPreCacheFilePath(str, "static", "" + str2.hashCode());
    }

    public void doFetchPreResourceIfNeed(MiniAppConfig miniAppConfig) {
        MiniAppInfo miniAppInfo;
        ArrayList<ResourcePreCacheInfo> arrayList;
        if (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null || (arrayList = miniAppInfo.resourcePreCacheInfo) == null || arrayList.size() <= 0) {
            return;
        }
        int i3 = this.PRECACHE_RESOURCE_MAX_COUNT;
        Iterator<ResourcePreCacheInfo> it = miniAppConfig.config.resourcePreCacheInfo.iterator();
        while (it.hasNext()) {
            ResourcePreCacheInfo next = it.next();
            if (i3 <= 0) {
                return;
            }
            if (next != null && !TextUtils.isEmpty(next.getDataUrl)) {
                i3--;
                QLog.i(TAG, 1, "[Resource Cache] fetch PreCache url:" + next.getDataUrl + " maxCount:" + this.PRECACHE_RESOURCE_MAX_COUNT);
                final String resourcePreCachePath = getResourcePreCachePath(miniAppConfig.config.appId, next.getDataUrl);
                if (new File(resourcePreCachePath).exists()) {
                    QLog.i(TAG, 1, "[Resource Cache] PreCache already exist. path=" + resourcePreCachePath);
                } else {
                    MiniappDownloadUtil.getInstance().download(next.getDataUrl, resourcePreCachePath, false, new Downloader.DownloadListener() { // from class: com.tencent.mobileqq.mini.app.PreCacheManager.6
                        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                        public void onDownloadCanceled(String str) {
                            QLog.i(PreCacheManager.TAG, 1, "[Resource Cache] download Resource url canceled! url=" + str);
                        }

                        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                        public void onDownloadFailed(String str, DownloadResult downloadResult) {
                            QLog.i(PreCacheManager.TAG, 1, "[Resource Cache] download Resource url failed! url=" + str + " path=" + resourcePreCachePath);
                        }

                        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
                            QLog.i(PreCacheManager.TAG, 1, "[Resource Cache] download Resource url succeed! url=" + str);
                        }

                        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
                        public void onDownloadProgress(String str, long j3, float f16) {
                        }
                    }, Downloader.DownloadMode.StrictMode, null);
                }
            }
        }
    }

    public void setBackgroundFetchToken(MiniAppConfig miniAppConfig, String str) {
        if (miniAppConfig == null || TextUtils.isEmpty(str)) {
            return;
        }
        StorageUtil.getPreference().edit().putString(miniAppConfig.config.appId + "_precache_token", str).apply();
    }

    public void fetchPeriodicCacheIfNeed(MiniAppConfig miniAppConfig, OnCacheListener onCacheListener) {
        if (miniAppConfig == null) {
            return;
        }
        doFetchPreCacheData(miniAppConfig, "periodic", onCacheListener);
    }

    public String getBackgroundFetchToken(MiniAppConfig miniAppConfig) {
        if (miniAppConfig == null) {
            return null;
        }
        return StorageUtil.getPreference().getString(miniAppConfig.config.appId + "_precache_token", null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01aa  */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r8v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doFetchPreCacheData(final MiniAppConfig miniAppConfig, final String str, final OnCacheListener onCacheListener) {
        MiniAppInfo miniAppInfo;
        ArrayList<PreCacheInfo> arrayList;
        String str2;
        int i3;
        OnCacheListener onCacheListener2;
        int i16;
        String str3;
        int i17;
        String str4;
        MiniAppConfig miniAppConfig2 = miniAppConfig;
        OnCacheListener onCacheListener3 = onCacheListener;
        String str5 = "UTF-8";
        if (miniAppConfig2 == null || (miniAppInfo = miniAppConfig2.config) == null || (arrayList = miniAppInfo.preCacheList) == null || arrayList.size() <= 0) {
            return;
        }
        int cacheType = getCacheType(str);
        final String str6 = "[" + str + " Cache]";
        Iterator<PreCacheInfo> it = miniAppConfig2.config.preCacheList.iterator();
        int i18 = 1;
        int i19 = 1;
        while (it.hasNext()) {
            final PreCacheInfo next = it.next();
            if (i19 <= 0) {
                return;
            }
            if (next == null || next.cacheType != cacheType) {
                str2 = str5;
                i3 = cacheType;
                onCacheListener2 = onCacheListener;
                i16 = i18;
            } else {
                int i26 = i19 - 1;
                PreCacheDescData preFetchAppCacheData = getPreFetchAppCacheData(miniAppConfig, str);
                if (preFetchAppCacheData != null) {
                    QLog.i(TAG, i18, str6 + " last PreCache url:" + preFetchAppCacheData.url + " timestamp:" + preFetchAppCacheData.timeStamp);
                    if ("periodic".equals(str) && next.getDataUrl.equals(preFetchAppCacheData.url)) {
                        str3 = "periodic";
                        if (System.currentTimeMillis() - preFetchAppCacheData.timeStamp < this.PRECACHE_PERIOD_MILLIS) {
                            QLog.i(TAG, i18, str6 + " last PreCache is still in validity period.");
                            if (onCacheListener3 != 0) {
                                onCacheListener3.onCacheUpdated(i18, false);
                                return;
                            }
                            return;
                        }
                        if (!"pre".equals(str)) {
                            String str7 = miniAppConfig2.launchParam.entryPath;
                            String str8 = "";
                            String str9 = str7 == null ? "" : str7;
                            if (str9.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                                str8 = str9.substring(str9.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + i18);
                            }
                            String str10 = str8;
                            try {
                                str9 = URLEncoder.encode(str9, str5);
                                str4 = URLEncoder.encode(str10, str5);
                            } catch (Throwable th5) {
                                QLog.e(TAG, 1, th5, new Object[0]);
                                str4 = str10;
                            }
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("appid=");
                            sb5.append(miniAppConfig2.config.appId);
                            sb5.append("&timestamp=");
                            sb5.append(System.currentTimeMillis());
                            sb5.append("&path=");
                            sb5.append(str9);
                            sb5.append("&query=");
                            sb5.append(str4);
                            sb5.append("&scene=");
                            miniAppConfig2 = miniAppConfig;
                            sb5.append(miniAppConfig2.launchParam.scene);
                            final String sb6 = sb5.toString();
                            String backgroundFetchToken = getBackgroundFetchToken(miniAppConfig);
                            if (TextUtils.isEmpty(backgroundFetchToken)) {
                                str2 = str5;
                                i3 = cacheType;
                                i17 = 1;
                                MiniAppCmdUtil.getInstance().getLoginCode(miniAppConfig2.config.appId, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.app.PreCacheManager.2
                                    @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                                    public void onCmdListener(boolean z16, JSONObject jSONObject) {
                                        if (z16) {
                                            QLog.d(PreCacheManager.TAG, 1, str6 + "call API_LOGIN  code:" + jSONObject.toString());
                                            String optString = jSONObject.optString("code");
                                            if (TextUtils.isEmpty(optString)) {
                                                return;
                                            }
                                            PreCacheManager.this.doRequestPreCacheData(miniAppConfig, next, str, sb6 + "&code=" + optString, onCacheListener);
                                            return;
                                        }
                                        QLog.e(PreCacheManager.TAG, 1, "call API_LOGIN failed ");
                                    }
                                });
                            } else {
                                str2 = str5;
                                i3 = cacheType;
                                i17 = 1;
                                doRequestPreCacheData(miniAppConfig, next, str, sb6 + "&token=" + backgroundFetchToken, onCacheListener);
                            }
                        } else {
                            i3 = cacheType;
                            String str11 = str3;
                            i17 = i18;
                            str2 = str5;
                            if (str11.equals(str)) {
                                String backgroundFetchToken2 = getBackgroundFetchToken(miniAppConfig);
                                if (TextUtils.isEmpty(backgroundFetchToken2)) {
                                    QLog.e(TAG, i17, str6 + "token is null!");
                                    return;
                                }
                                doRequestPreCacheData(miniAppConfig, next, str, "appid=" + miniAppConfig2.config.appId + "&token=" + backgroundFetchToken2 + "&timestamp=" + System.currentTimeMillis(), onCacheListener);
                            }
                        }
                        onCacheListener2 = onCacheListener;
                        i16 = i17;
                        i19 = i26;
                    }
                }
                str3 = "periodic";
                if (!"pre".equals(str)) {
                }
                onCacheListener2 = onCacheListener;
                i16 = i17;
                i19 = i26;
            }
            str5 = str2;
            cacheType = i3;
            i18 = i16;
            onCacheListener3 = onCacheListener2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRequestPreCacheData(final MiniAppConfig miniAppConfig, PreCacheInfo preCacheInfo, final String str, String str2, final OnCacheListener onCacheListener) {
        String str3;
        final String str4 = "[" + str + " Cache]";
        final String str5 = preCacheInfo.getDataUrl;
        int indexOf = str5.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf >= 0) {
            str3 = str5.substring(0, indexOf) + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + ContainerUtils.FIELD_DELIMITER + str5.substring(indexOf + 1);
        } else {
            str3 = str5 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
        }
        String str6 = str3;
        QLog.i(TAG, 1, str4 + "doRequestPreCacheData requestUrl:" + str6 + " useProxy:" + preCacheInfo.useProxy + " query:" + str2);
        if (preCacheInfo.useProxy > 0) {
            MiniAppCmdUtil.getInstance().getContentAccelerate(miniAppConfig.config.appId, str6, 1, null, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.app.PreCacheManager.3
                @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
                public void onCmdListener(boolean z16, JSONObject jSONObject) {
                    if (z16) {
                        try {
                            ContentAccelerateRsp contentAccelerateRsp = (ContentAccelerateRsp) jSONObject.get(MiniAppContentAccelerateServlet.KEY_RSP_DATA);
                            QLog.i(PreCacheManager.TAG, 1, str4 + " fetch PreCache succful. CacheType:" + str + " httpCode=" + contentAccelerateRsp.httpReturnCode + " length=" + contentAccelerateRsp.cacheData.length);
                            if (contentAccelerateRsp.httpReturnCode != 200 || contentAccelerateRsp.cacheData.length > PreCacheManager.this.PRECACHE_CONTENT_SIZE) {
                                return;
                            }
                            PreCacheDescData preCacheDescData = new PreCacheDescData();
                            MiniAppConfig miniAppConfig2 = miniAppConfig;
                            preCacheDescData.appid = miniAppConfig2.config.appId;
                            preCacheDescData.url = str5;
                            LaunchParam launchParam = miniAppConfig2.launchParam;
                            preCacheDescData.scene = launchParam.scene;
                            preCacheDescData.path = launchParam.entryPath;
                            preCacheDescData.timeStamp = System.currentTimeMillis();
                            MiniAppFileManager.getInstance();
                            String str7 = miniAppConfig.config.appId;
                            String str8 = str;
                            String preCacheFilePath = MiniAppFileManager.getPreCacheFilePath(str7, str8, preCacheDescData.getCacheKey(str8));
                            FileUtils.writeFile(contentAccelerateRsp.cacheData, preCacheFilePath);
                            preCacheDescData.filePath = preCacheFilePath;
                            MiniAppFileManager.getInstance();
                            String preCacheFilePath2 = MiniAppFileManager.getPreCacheFilePath(miniAppConfig.config.appId, str, preCacheDescData.getCacheKey(str) + "_index");
                            ParcelableUtil.writeParcelableToFile(preCacheDescData, preCacheFilePath2);
                            QLog.i(PreCacheManager.TAG, 1, str4 + " save PreCache info. index=" + preCacheFilePath2 + " content=" + preCacheFilePath);
                            OnCacheListener onCacheListener2 = onCacheListener;
                            if (onCacheListener2 != null) {
                                onCacheListener2.onCacheUpdated(true, true);
                                return;
                            }
                            return;
                        } catch (Throwable th5) {
                            QLog.e(PreCacheManager.TAG, 1, str4 + " request PreCache exception!", th5);
                            OnCacheListener onCacheListener3 = onCacheListener;
                            if (onCacheListener3 != null) {
                                onCacheListener3.onCacheUpdated(false, false);
                                return;
                            }
                            return;
                        }
                    }
                    QLog.i(PreCacheManager.TAG, 1, str4 + " fetch PreCache failed! retCode=" + jSONObject.optInt("retCode") + " msg=" + jSONObject.optString("errMsg"));
                    OnCacheListener onCacheListener4 = onCacheListener;
                    if (onCacheListener4 != null) {
                        onCacheListener4.onCacheUpdated(false, false);
                    }
                }
            });
            return;
        }
        final PreCacheDescData preCacheDescData = new PreCacheDescData();
        preCacheDescData.appid = miniAppConfig.config.appId;
        preCacheDescData.url = str5;
        LaunchParam launchParam = miniAppConfig.launchParam;
        preCacheDescData.scene = launchParam.scene;
        preCacheDescData.path = launchParam.entryPath;
        MiniAppFileManager.getInstance();
        final String preCacheFilePath = MiniAppFileManager.getPreCacheFilePath(miniAppConfig.config.appId, str, preCacheDescData.getCacheKey(str));
        MiniappDownloadUtil.getInstance().download(str6, preCacheFilePath, false, new Downloader.DownloadListener() { // from class: com.tencent.mobileqq.mini.app.PreCacheManager.4
            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadCanceled(String str7) {
                QLog.i(PreCacheManager.TAG, 1, str4 + " fetch PreCache url canceled! url=" + str7);
                OnCacheListener onCacheListener2 = onCacheListener;
                if (onCacheListener2 != null) {
                    onCacheListener2.onCacheUpdated(false, false);
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadFailed(String str7, DownloadResult downloadResult) {
                QLog.i(PreCacheManager.TAG, 1, str4 + " fetch PreCache url failed! url=" + str7);
                OnCacheListener onCacheListener2 = onCacheListener;
                if (onCacheListener2 != null) {
                    onCacheListener2.onCacheUpdated(false, false);
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadSucceed(String str7, DownloadResult downloadResult) {
                try {
                    QLog.i(PreCacheManager.TAG, 1, str4 + " fetch PreCache succful. url" + str7 + " length=" + downloadResult.getContent().length);
                    if (downloadResult.getContent().length <= PreCacheManager.this.PRECACHE_CONTENT_SIZE) {
                        preCacheDescData.timeStamp = System.currentTimeMillis();
                        preCacheDescData.filePath = preCacheFilePath;
                        MiniAppFileManager.getInstance();
                        String preCacheFilePath2 = MiniAppFileManager.getPreCacheFilePath(miniAppConfig.config.appId, str, preCacheDescData.getCacheKey(str) + "_index");
                        ParcelableUtil.writeParcelableToFile(preCacheDescData, preCacheFilePath2);
                        QLog.i(PreCacheManager.TAG, 1, str4 + " save PreCache info. index=" + preCacheFilePath2 + " content=" + preCacheFilePath);
                        OnCacheListener onCacheListener2 = onCacheListener;
                        if (onCacheListener2 != null) {
                            onCacheListener2.onCacheUpdated(true, true);
                        }
                    }
                } catch (Throwable th5) {
                    QLog.i(PreCacheManager.TAG, 1, str4 + " fetch PreCache exception!", th5);
                    OnCacheListener onCacheListener3 = onCacheListener;
                    if (onCacheListener3 != null) {
                        onCacheListener3.onCacheUpdated(false, false);
                    }
                }
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadProgress(String str7, long j3, float f16) {
            }
        }, Downloader.DownloadMode.StrictMode, null);
    }
}
