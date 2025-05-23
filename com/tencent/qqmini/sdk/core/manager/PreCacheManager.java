package com.tencent.qqmini.sdk.core.manager;

import NS_COMM.COMM;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.proxy.service.DownloaderProxyDefault;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.core.utils.ParcelableUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.PreCacheInfo;
import com.tencent.qqmini.sdk.launcher.model.ResourcePreCacheInfo;
import com.tencent.qqmini.sdk.launcher.model.SubPkgInfo;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes23.dex */
public class PreCacheManager {
    public static final String CACHE_TYPE_PERIODIC = "periodic";
    public static final String CACHE_TYPE_PRE = "pre";
    public static final String CACHE_TYPE_STATIC = "static";
    private static final String TAG = "minisdk-start_PreCacheManager";
    private static PreCacheManager instance;
    private static byte[] lock = new byte[0];
    private static int PRECACHE_CONTENT_SIZE = WnsConfig.getConfig("qqminiapp", "mini_app_precache_size_limit", 262144);
    private static long PRECACHE_PERIOD_MILLIS = WnsConfig.getConfig("qqminiapp", "mini_app_precache_period_millis", 43200000L);
    private static int PRECACHE_RESOURCE_MAX_COUNT = WnsConfig.getConfig("qqminiapp", "mini_app_precache_resource_maxsize", 3);

    /* loaded from: classes23.dex */
    public static class ContentAccelerateRsp implements Parcelable {
        public static final Parcelable.Creator<ContentAccelerateRsp> CREATOR = new Parcelable.Creator<ContentAccelerateRsp>() { // from class: com.tencent.qqmini.sdk.core.manager.PreCacheManager.ContentAccelerateRsp.1
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

    /* loaded from: classes23.dex */
    public interface OnCacheListener {
        void onCacheUpdated(boolean z16, boolean z17);
    }

    /* loaded from: classes23.dex */
    public static class PreCacheDescData implements Parcelable {
        public static final Parcelable.Creator<PreCacheDescData> CREATOR = new Parcelable.Creator<PreCacheDescData>() { // from class: com.tencent.qqmini.sdk.core.manager.PreCacheManager.PreCacheDescData.1
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

        public PreCacheDescData(MiniAppInfo miniAppInfo, String str) {
            if (miniAppInfo != null) {
                this.appid = miniAppInfo.appId;
                LaunchParam launchParam = miniAppInfo.launchParam;
                this.scene = launchParam.scene;
                this.path = launchParam.entryPath;
                int cacheType = PreCacheManager.getCacheType(str);
                ArrayList<PreCacheInfo> arrayList = miniAppInfo.preCacheList;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class a implements MiniAppProxy.GetA2InfoCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MiniAppProxy f348023a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MiniAppInfo f348024b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f348025c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f348026d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Map f348027e;

        /* renamed from: com.tencent.qqmini.sdk.core.manager.PreCacheManager$a$a, reason: collision with other inner class name */
        /* loaded from: classes23.dex */
        class C9410a implements MiniAppProxy.GetStringCallback {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f348029a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f348030b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f348031c;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Map f348032d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f348033e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ SubPkgInfo f348034f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ c f348035g;

            C9410a(String str, String str2, String str3, Map map, String str4, SubPkgInfo subPkgInfo, c cVar) {
                this.f348029a = str;
                this.f348030b = str2;
                this.f348031c = str3;
                this.f348032d = map;
                this.f348033e = str4;
                this.f348034f = subPkgInfo;
                this.f348035g = cVar;
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.GetStringCallback
            public void onResult(String str) {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                this.f348032d.put("cookie", "uin=" + this.f348029a + ";a2=" + this.f348030b + ";pskey=" + str + ";qua=" + this.f348031c);
                a aVar = a.this;
                PreCacheManager.this.downloadContainerPreFetchData(aVar.f348024b, this.f348033e, this.f348034f.subPkgName, this.f348035g.f348044a, this.f348032d);
            }
        }

        a(MiniAppProxy miniAppProxy, MiniAppInfo miniAppInfo, String str, String str2, Map map) {
            this.f348023a = miniAppProxy;
            this.f348024b = miniAppInfo;
            this.f348025c = str;
            this.f348026d = str2;
            this.f348027e = map;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.GetA2InfoCallback
        public void onFail(int i3, String str) {
            QMLog.e(PreCacheManager.TAG, " GetA2InfoCallback errorCode: " + i3 + " errorMsg: " + str);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy.GetA2InfoCallback
        public void onSuccess(String str, String str2, String str3) {
            String str4;
            String str5;
            a aVar = this;
            String uin = aVar.f348023a.getUin();
            String platformQUA = aVar.f348023a.getPlatformQUA();
            for (SubPkgInfo subPkgInfo : aVar.f348024b.subpkgs) {
                String str6 = subPkgInfo.preFetchConfig;
                if (!TextUtils.isEmpty(str6)) {
                    ArrayList<c> c16 = c.c(str6);
                    if (c16 != null) {
                        if (c16.size() != 0) {
                            Iterator<c> it = c16.iterator();
                            while (it.hasNext()) {
                                c next = it.next();
                                boolean isEmpty = TextUtils.isEmpty(aVar.f348025c);
                                if (!isEmpty || !next.f348048e) {
                                    HashMap hashMap = new HashMap();
                                    String str7 = "";
                                    if (!isEmpty) {
                                        if (TextUtils.equals(next.f348044a, aVar.f348025c)) {
                                            if (!TextUtils.isEmpty(aVar.f348026d) && !aVar.f348026d.startsWith(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                                                str7 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + aVar.f348026d;
                                            }
                                            Map map = aVar.f348027e;
                                            if (map != null && map.size() > 0) {
                                                hashMap.putAll(aVar.f348027e);
                                            }
                                        }
                                    }
                                    if (next.b()) {
                                        str4 = next.f348046c;
                                    } else {
                                        str4 = next.f348047d + str7;
                                    }
                                    String str8 = str4;
                                    try {
                                        str5 = uin;
                                    } catch (MalformedURLException e16) {
                                        e = e16;
                                        str5 = uin;
                                    }
                                    try {
                                        aVar.f348023a.getPskey(new URL(str8).getHost(), new C9410a(uin, str, platformQUA, hashMap, str8, subPkgInfo, next));
                                    } catch (MalformedURLException e17) {
                                        e = e17;
                                        QMLog.e(PreCacheManager.TAG, "doFetchContainerPreFetchData e: " + e);
                                        aVar = this;
                                        uin = str5;
                                    }
                                    aVar = this;
                                    uin = str5;
                                }
                            }
                        }
                    }
                    aVar = this;
                }
            }
        }
    }

    /* loaded from: classes23.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f348044a;

        /* renamed from: b, reason: collision with root package name */
        public String f348045b;

        /* renamed from: c, reason: collision with root package name */
        public String f348046c;

        /* renamed from: d, reason: collision with root package name */
        public String f348047d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f348048e;

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            return TPReportKeys.Common.COMMON_ONLINE.equals(this.f348045b);
        }

        public static ArrayList<c> c(String str) {
            ArrayList<c> arrayList = new ArrayList<>();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                    if (optJSONObject != null) {
                        c cVar = new c();
                        cVar.f348044a = optJSONObject.optString("path");
                        cVar.f348045b = optJSONObject.optString("activeEnv");
                        cVar.f348046c = optJSONObject.optString("onlineUrl");
                        cVar.f348047d = optJSONObject.optString("testUrl");
                        cVar.f348048e = optJSONObject.optBoolean("customLoadTime");
                        arrayList.add(cVar);
                    }
                }
            } catch (Exception e16) {
                QMLog.e(PreCacheManager.TAG, "parsePreFetchConfigList error, " + e16.getMessage());
                e16.printStackTrace();
            }
            return arrayList;
        }
    }

    private boolean doCachePre(MiniAppInfo miniAppInfo, String str, OnCacheListener onCacheListener, String str2, PreCacheInfo preCacheInfo) {
        if ("pre".equals(str)) {
            docachePre(miniAppInfo, str, onCacheListener, str2, preCacheInfo);
            return false;
        }
        if ("periodic".equals(str)) {
            String backgroundFetchToken = getBackgroundFetchToken(miniAppInfo);
            if (TextUtils.isEmpty(backgroundFetchToken)) {
                QMLog.e(TAG, str2 + "token is null!");
                return true;
            }
            doRequestPreCacheData(miniAppInfo, preCacheInfo, str, "appid=" + miniAppInfo.appId + "&token=" + backgroundFetchToken + "&timestamp=" + System.currentTimeMillis(), onCacheListener);
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFetchContainerPreFetchData(MiniAppInfo miniAppInfo, String str, String str2, Map<String, String> map) {
        if (miniAppInfo == null) {
            QMLog.i(TAG, "fetchContainerPreFetchData error, app info is null");
            return;
        }
        List<SubPkgInfo> list = miniAppInfo.subpkgs;
        if (list != null && list.size() != 0) {
            MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
            miniAppProxy.getA2(new a(miniAppProxy, miniAppInfo, str, str2, map));
        } else {
            QMLog.i(TAG, "fetchContainerPreFetchData error, subpkgs is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFetchPreCacheData(MiniAppInfo miniAppInfo, String str, OnCacheListener onCacheListener) {
        if (miniAppInfo == null) {
            return;
        }
        QMLog.i(TAG, "doFetchPreCacheData last PreCache url:");
        ArrayList<PreCacheInfo> arrayList = miniAppInfo.preCacheList;
        if (arrayList != null && arrayList.size() > 0) {
            int cacheType = getCacheType(str);
            String str2 = "[" + str + " Cache]";
            Iterator<PreCacheInfo> it = miniAppInfo.preCacheList.iterator();
            int i3 = 1;
            while (it.hasNext()) {
                PreCacheInfo next = it.next();
                if (i3 > 0) {
                    if (next != null && next.cacheType == cacheType) {
                        int i16 = i3 - 1;
                        PreCacheDescData preFetchAppCacheData = getPreFetchAppCacheData(miniAppInfo, str);
                        if (preFetchAppCacheData != null) {
                            QMLog.i(TAG, str2 + " last PreCache url:" + preFetchAppCacheData.url + " timestamp:" + preFetchAppCacheData.timeStamp);
                            if ("periodic".equals(str) && next.getDataUrl.equals(preFetchAppCacheData.url) && System.currentTimeMillis() - preFetchAppCacheData.timeStamp < PRECACHE_PERIOD_MILLIS) {
                                QMLog.i(TAG, str2 + " last PreCache is still in validity period.");
                                if (onCacheListener != null) {
                                    onCacheListener.onCacheUpdated(true, false);
                                    return;
                                }
                                return;
                            }
                        }
                        if (doCachePre(miniAppInfo, str, onCacheListener, str2, next)) {
                            return;
                        } else {
                            i3 = i16;
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRequestPreCacheData(MiniAppInfo miniAppInfo, PreCacheInfo preCacheInfo, String str, String str2, OnCacheListener onCacheListener) {
        String str3;
        String str4 = "[" + str + " Cache]";
        String str5 = preCacheInfo.getDataUrl;
        int indexOf = str5.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf >= 0) {
            str3 = str5.substring(0, indexOf) + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + ContainerUtils.FIELD_DELIMITER + str5.substring(indexOf + 1);
        } else {
            str3 = str5 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2;
        }
        String str6 = str3;
        QMLog.i(TAG, str4 + "doRequestPreCacheData requestUrl:" + str6 + " useProxy:" + preCacheInfo.useProxy + " query:" + str2);
        if (preCacheInfo.useProxy > 0) {
            getContentAccelerate(miniAppInfo, str, onCacheListener, str4, str5, str6);
        } else {
            downloadFile(miniAppInfo, str, onCacheListener, str4, str5, str6);
        }
    }

    private void docachePre(final MiniAppInfo miniAppInfo, final String str, final OnCacheListener onCacheListener, final String str2, final PreCacheInfo preCacheInfo) {
        String str3;
        String str4 = miniAppInfo.launchParam.entryPath;
        if (str4 == null) {
            str4 = "";
        }
        if (!str4.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str3 = "";
        } else {
            str3 = str4.substring(str4.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1);
        }
        try {
            str4 = URLEncoder.encode(str4, "UTF-8");
            str3 = URLEncoder.encode(str3, "UTF-8");
        } catch (Throwable th5) {
            QMLog.e(TAG, "", th5);
        }
        final String str5 = "appid=" + miniAppInfo.appId + "&timestamp=" + System.currentTimeMillis() + "&path=" + str4 + "&query=" + str3 + "&scene=" + miniAppInfo.launchParam.scene;
        String backgroundFetchToken = getBackgroundFetchToken(miniAppInfo);
        if (TextUtils.isEmpty(backgroundFetchToken)) {
            ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).login(miniAppInfo.appId, new AsyncResult() { // from class: com.tencent.qqmini.sdk.core.manager.PreCacheManager.2
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
                public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                    if (z16) {
                        QMLog.d(PreCacheManager.TAG, str2 + "call API_LOGIN  code:" + jSONObject.toString());
                        String optString = jSONObject.optString("code");
                        if (!TextUtils.isEmpty(optString)) {
                            PreCacheManager.this.doRequestPreCacheData(miniAppInfo, preCacheInfo, str, str5 + "&code=" + optString, onCacheListener);
                            return;
                        }
                        return;
                    }
                    QMLog.e(PreCacheManager.TAG, "call API_LOGIN failed ");
                }
            });
            return;
        }
        doRequestPreCacheData(miniAppInfo, preCacheInfo, str, str5 + "&token=" + backgroundFetchToken, onCacheListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadContainerPreFetchData(MiniAppInfo miniAppInfo, String str, String str2, String str3, Map<String, String> map) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            QMLog.i(TAG, "start downloadContainerPreFetchData url: " + str);
            PreCacheDescData preCacheDescData = new PreCacheDescData();
            String str4 = miniAppInfo.appId;
            preCacheDescData.appid = str4;
            preCacheDescData.url = str;
            LaunchParam launchParam = miniAppInfo.launchParam;
            preCacheDescData.scene = launchParam.scene;
            preCacheDescData.path = launchParam.entryPath;
            String containerPreCacheFilePath = MiniAppFileManager.getContainerPreCacheFilePath(str4, str2, str3, "");
            new DownloaderProxyDefault().download(str, map, containerPreCacheFilePath, 20, new b(str, preCacheDescData, containerPreCacheFilePath, miniAppInfo, str2, str3));
            return;
        }
        QMLog.i(TAG, "downloadContainerPreFetchData error, pkgName=" + str2 + " ,path=" + str3);
    }

    private void downloadFile(final MiniAppInfo miniAppInfo, final String str, final OnCacheListener onCacheListener, final String str2, String str3, final String str4) {
        final PreCacheDescData preCacheDescData = new PreCacheDescData();
        String str5 = miniAppInfo.appId;
        preCacheDescData.appid = str5;
        preCacheDescData.url = str3;
        LaunchParam launchParam = miniAppInfo.launchParam;
        preCacheDescData.scene = launchParam.scene;
        preCacheDescData.path = launchParam.entryPath;
        final String preCacheFilePath = MiniAppFileManager.getPreCacheFilePath(str5, str, preCacheDescData.getCacheKey(str));
        new DownloaderProxyDefault().download(str4, null, preCacheFilePath, 20, new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.sdk.core.manager.PreCacheManager.3
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadFailed(int i3, String str6) {
                QMLog.i(PreCacheManager.TAG, str2 + " fetch PreCache url failed! url=" + str4);
                OnCacheListener onCacheListener2 = onCacheListener;
                if (onCacheListener2 != null) {
                    onCacheListener2.onCacheUpdated(false, false);
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadSucceed(int i3, String str6, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
                try {
                    File file = new File(str6);
                    QMLog.i(PreCacheManager.TAG, str2 + " fetch PreCache succful. url" + str4 + " length=" + file.length());
                    if (file.length() <= PreCacheManager.PRECACHE_CONTENT_SIZE) {
                        preCacheDescData.timeStamp = System.currentTimeMillis();
                        preCacheDescData.filePath = preCacheFilePath;
                        String preCacheFilePath2 = MiniAppFileManager.getPreCacheFilePath(miniAppInfo.appId, str, preCacheDescData.getCacheKey(str) + "_index");
                        ParcelableUtil.writeParcelableToFile(preCacheDescData, preCacheFilePath2);
                        QMLog.i(PreCacheManager.TAG, str2 + " save PreCache info. index=" + preCacheFilePath2 + " content=" + preCacheFilePath);
                        OnCacheListener onCacheListener2 = onCacheListener;
                        if (onCacheListener2 != null) {
                            onCacheListener2.onCacheUpdated(true, true);
                        }
                    }
                } catch (Throwable th5) {
                    QMLog.i(PreCacheManager.TAG, str2 + " fetch PreCache exception!", th5);
                    OnCacheListener onCacheListener3 = onCacheListener;
                    if (onCacheListener3 != null) {
                        onCacheListener3.onCacheUpdated(false, false);
                    }
                }
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadHeadersReceived(int i3, Map<String, List<String>> map) {
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
            public void onDownloadProgress(float f16, long j3, long j16) {
            }
        });
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
        if ("periodic".equals(str)) {
            return 2;
        }
        return 0;
    }

    private void getContentAccelerate(final MiniAppInfo miniAppInfo, final String str, final OnCacheListener onCacheListener, final String str2, final String str3, String str4) {
        ((ChannelProxy) ProxyManager.get(ChannelProxy.class)).getContentAccelerate(miniAppInfo.appId, str4, 1, null, new AsyncResult() { // from class: com.tencent.qqmini.sdk.core.manager.PreCacheManager.4
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult
            public void onReceiveResult(boolean z16, JSONObject jSONObject) {
                if (z16) {
                    try {
                        ContentAccelerateRsp contentAccelerateRsp = (ContentAccelerateRsp) jSONObject.get("data");
                        QMLog.i(PreCacheManager.TAG, str2 + " fetch PreCache succful. CacheType:" + str + " httpCode=" + contentAccelerateRsp.httpReturnCode + " length=" + contentAccelerateRsp.cacheData.length);
                        if (contentAccelerateRsp.httpReturnCode == 200 && contentAccelerateRsp.cacheData.length <= PreCacheManager.PRECACHE_CONTENT_SIZE) {
                            PreCacheDescData preCacheDescData = new PreCacheDescData();
                            MiniAppInfo miniAppInfo2 = miniAppInfo;
                            preCacheDescData.appid = miniAppInfo2.appId;
                            preCacheDescData.url = str3;
                            LaunchParam launchParam = miniAppInfo2.launchParam;
                            preCacheDescData.scene = launchParam.scene;
                            preCacheDescData.path = launchParam.entryPath;
                            preCacheDescData.timeStamp = System.currentTimeMillis();
                            String str5 = miniAppInfo.appId;
                            String str6 = str;
                            String preCacheFilePath = MiniAppFileManager.getPreCacheFilePath(str5, str6, preCacheDescData.getCacheKey(str6));
                            FileUtils.writeFile(contentAccelerateRsp.cacheData, preCacheFilePath);
                            preCacheDescData.filePath = preCacheFilePath;
                            String preCacheFilePath2 = MiniAppFileManager.getPreCacheFilePath(miniAppInfo.appId, str, preCacheDescData.getCacheKey(str) + "_index");
                            ParcelableUtil.writeParcelableToFile(preCacheDescData, preCacheFilePath2);
                            QMLog.i(PreCacheManager.TAG, str2 + " save PreCache info. index=" + preCacheFilePath2 + " content=" + preCacheFilePath);
                            OnCacheListener onCacheListener2 = onCacheListener;
                            if (onCacheListener2 != null) {
                                onCacheListener2.onCacheUpdated(true, true);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (Throwable th5) {
                        QMLog.e(PreCacheManager.TAG, str2 + " request PreCache exception!", th5);
                        OnCacheListener onCacheListener3 = onCacheListener;
                        if (onCacheListener3 != null) {
                            onCacheListener3.onCacheUpdated(false, false);
                            return;
                        }
                        return;
                    }
                }
                QMLog.i(PreCacheManager.TAG, str2 + " fetch PreCache failed! retCode=" + jSONObject.optInt("retCode") + " msg=");
                OnCacheListener onCacheListener4 = onCacheListener;
                if (onCacheListener4 != null) {
                    onCacheListener4.onCacheUpdated(false, false);
                }
            }
        });
    }

    public void doFetchPreResourceIfNeed(MiniAppInfo miniAppInfo) {
        ArrayList<ResourcePreCacheInfo> arrayList;
        if (miniAppInfo != null && (arrayList = miniAppInfo.resourcePreCacheInfo) != null && arrayList.size() > 0) {
            int i3 = PRECACHE_RESOURCE_MAX_COUNT;
            Iterator<ResourcePreCacheInfo> it = miniAppInfo.resourcePreCacheInfo.iterator();
            while (it.hasNext()) {
                ResourcePreCacheInfo next = it.next();
                if (i3 > 0) {
                    if (next != null && !TextUtils.isEmpty(next.getDataUrl)) {
                        i3--;
                        QMLog.i(TAG, "[Resource Cache] fetch PreCache url:" + next.getDataUrl + " maxCount:" + PRECACHE_RESOURCE_MAX_COUNT);
                        final String resourcePreCachePath = getResourcePreCachePath(miniAppInfo.appId, next.getDataUrl);
                        if (new File(resourcePreCachePath).exists()) {
                            QMLog.i(TAG, "[Resource Cache] PreCache already exist. path=" + resourcePreCachePath);
                        } else {
                            DownloaderProxyDefault downloaderProxyDefault = new DownloaderProxyDefault();
                            final String str = next.getDataUrl;
                            downloaderProxyDefault.download(str, null, resourcePreCachePath, 20, new DownloaderProxy.DownloadListener() { // from class: com.tencent.qqmini.sdk.core.manager.PreCacheManager.6
                                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                                public void onDownloadFailed(int i16, String str2) {
                                    QMLog.i(PreCacheManager.TAG, "[Resource Cache] download Resource url failed! url=" + str + " path=" + resourcePreCachePath);
                                }

                                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                                public void onDownloadSucceed(int i16, String str2, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
                                    QMLog.i(PreCacheManager.TAG, "[Resource Cache] download Resource url succeed! url=" + str);
                                }

                                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                                public void onDownloadHeadersReceived(int i16, Map<String, List<String>> map) {
                                }

                                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
                                public void onDownloadProgress(float f16, long j3, long j16) {
                                }
                            });
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void fetchContainerPreFetchData(final MiniAppInfo miniAppInfo, final String str, final String str2, final Map<String, String> map) {
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.core.manager.PreCacheManager.7
            @Override // java.lang.Runnable
            public void run() {
                PreCacheManager.this.doFetchContainerPreFetchData(miniAppInfo, str, str2, map);
            }
        });
    }

    public void fetchPeriodicCacheIfNeed(MiniAppInfo miniAppInfo, OnCacheListener onCacheListener) {
        if (miniAppInfo == null) {
            return;
        }
        doFetchPreCacheData(miniAppInfo, "periodic", onCacheListener);
    }

    public void fetchPreCacheData(final MiniAppInfo miniAppInfo) {
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.core.manager.PreCacheManager.1
            @Override // java.lang.Runnable
            public void run() {
                PreCacheManager.this.doFetchPreCacheData(miniAppInfo, "pre", null);
            }
        });
    }

    public void fetchPreResourceIfNeed(final MiniAppInfo miniAppInfo) {
        ThreadManager.executeOnDiskIOThreadPool(new Runnable() { // from class: com.tencent.qqmini.sdk.core.manager.PreCacheManager.5
            @Override // java.lang.Runnable
            public void run() {
                PreCacheManager.this.doFetchPreResourceIfNeed(miniAppInfo);
            }
        });
    }

    public String getBackgroundFetchToken(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return null;
        }
        return StorageUtil.getPreference().getString(miniAppInfo.appId + "_precache_token", null);
    }

    public PreCacheDescData getContainerPreFetchAppCacheData(MiniAppInfo miniAppInfo, String str, String str2, String str3) {
        FileInputStream fileInputStream;
        if (miniAppInfo == null) {
            return null;
        }
        PreCacheDescData preCacheDescData = new PreCacheDescData(miniAppInfo, str3);
        try {
            preCacheDescData = (PreCacheDescData) ParcelableUtil.readParcelableFromFile(PreCacheDescData.class, MiniAppFileManager.getContainerPreCacheFilePath(miniAppInfo.appId, str, str2, "_index"));
        } catch (Throwable th5) {
            QMLog.i(TAG, "", th5);
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
                        QMLog.e(TAG, "", th6);
                    }
                    return preCacheDescData;
                } catch (Throwable th7) {
                    th = th7;
                    try {
                        QMLog.e(TAG, "", th);
                        return null;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th8) {
                                QMLog.e(TAG, "", th8);
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

    public PreCacheDescData getPreFetchAppCacheData(MiniAppInfo miniAppInfo, String str) {
        FileInputStream fileInputStream;
        if (miniAppInfo == null) {
            return null;
        }
        PreCacheDescData preCacheDescData = new PreCacheDescData(miniAppInfo, str);
        try {
            preCacheDescData = (PreCacheDescData) ParcelableUtil.readParcelableFromFile(PreCacheDescData.class, MiniAppFileManager.getPreCacheFilePath(miniAppInfo.appId, str, preCacheDescData.getCacheKey(str) + "_index"));
        } catch (Throwable th5) {
            QMLog.i(TAG, "", th5);
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
                        QMLog.e(TAG, "", th6);
                    }
                    return preCacheDescData;
                } catch (Throwable th7) {
                    th = th7;
                    try {
                        QMLog.e(TAG, "", th);
                        return null;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Throwable th8) {
                                QMLog.e(TAG, "", th8);
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
        return MiniAppFileManager.getPreCacheFilePath(str, "static", "" + str2.hashCode());
    }

    public void notifyPeriodicCacheUpdated(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return;
        }
        QMLog.i(TAG, "[periodic Cache] notify PeriodicCacheUpdated");
    }

    public void setBackgroundFetchToken(MiniAppInfo miniAppInfo, String str) {
        if (miniAppInfo != null && !TextUtils.isEmpty(str)) {
            StorageUtil.getPreference().edit().putString(miniAppInfo.appId + "_precache_token", str).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class b implements DownloaderProxy.DownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f348037a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ PreCacheDescData f348038b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f348039c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MiniAppInfo f348040d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f348041e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f348042f;

        b(String str, PreCacheDescData preCacheDescData, String str2, MiniAppInfo miniAppInfo, String str3, String str4) {
            this.f348037a = str;
            this.f348038b = preCacheDescData;
            this.f348039c = str2;
            this.f348040d = miniAppInfo;
            this.f348041e = str3;
            this.f348042f = str4;
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadFailed(int i3, String str) {
            QMLog.i(PreCacheManager.TAG, " fetch container pre data url failed! url=" + this.f348037a + ", statusCode=" + i3 + ", errorMsg=" + str);
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadSucceed(int i3, String str, DownloaderProxy.DownloadListener.DownloadResult downloadResult) {
            try {
                File file = new File(str);
                QMLog.i(PreCacheManager.TAG, " fetch container pre data success. url" + this.f348037a + " length=" + file.length());
                if (file.length() <= PreCacheManager.PRECACHE_CONTENT_SIZE) {
                    this.f348038b.timeStamp = System.currentTimeMillis();
                    this.f348038b.filePath = this.f348039c;
                    String containerPreCacheFilePath = MiniAppFileManager.getContainerPreCacheFilePath(this.f348040d.appId, this.f348041e, this.f348042f, "_index");
                    ParcelableUtil.writeParcelableToFile(this.f348038b, containerPreCacheFilePath);
                    QMLog.i(PreCacheManager.TAG, "downloadContainerPreFetchData save PreCache info. index=" + containerPreCacheFilePath + " content=" + this.f348039c);
                }
            } catch (Throwable th5) {
                QMLog.i(PreCacheManager.TAG, "fetch container pre data success. exception!", th5);
            }
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadHeadersReceived(int i3, Map<String, List<String>> map) {
        }

        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.DownloaderProxy.DownloadListener
        public void onDownloadProgress(float f16, long j3, long j16) {
        }
    }
}
