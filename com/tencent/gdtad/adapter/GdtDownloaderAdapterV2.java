package com.tencent.gdtad.adapter;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.downloader.AdDownloaderAdapterV2;
import com.tencent.ad.tangram.downloader.AdDownloaderV2;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtDownloaderAdapterV2 implements AdDownloaderAdapterV2 {

    /* renamed from: c, reason: collision with root package name */
    private static volatile GdtDownloaderAdapterV2 f108442c;

    /* renamed from: a, reason: collision with root package name */
    private List<WeakReference<AdDownloaderV2.OnStatusChangedListener>> f108443a = new CopyOnWriteArrayList();

    /* renamed from: b, reason: collision with root package name */
    private xm0.d f108444b = new a(new WeakReference(this));

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static final class a implements xm0.d {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<GdtDownloaderAdapterV2> f108449a;

        a(WeakReference<GdtDownloaderAdapterV2> weakReference) {
            this.f108449a = weakReference;
        }

        @Override // xm0.d
        public void a(DownloadInfo downloadInfo) {
            int i3;
            String str;
            String str2;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[DownloadIPCMainClientListenerImpl][callBackJs] downloaderStatus:");
            int i16 = Integer.MIN_VALUE;
            if (downloadInfo != null) {
                i3 = downloadInfo.f();
            } else {
                i3 = Integer.MIN_VALUE;
            }
            sb5.append(i3);
            sb5.append(" progress:");
            if (downloadInfo != null) {
                i16 = downloadInfo.Q;
            }
            sb5.append(i16);
            sb5.append(" aid:");
            GdtDownloaderAdapterV2 gdtDownloaderAdapterV2 = null;
            if (downloadInfo != null) {
                str = downloadInfo.f341194k0;
            } else {
                str = null;
            }
            sb5.append(str);
            sb5.append(" url:");
            if (downloadInfo != null) {
                str2 = downloadInfo.f341186f;
            } else {
                str2 = null;
            }
            sb5.append(str2);
            GdtLog.i("GdtDownloaderAdapterV2", sb5.toString());
            WeakReference<GdtDownloaderAdapterV2> weakReference = this.f108449a;
            if (weakReference != null) {
                gdtDownloaderAdapterV2 = weakReference.get();
            }
            if (gdtDownloaderAdapterV2 == null) {
                GdtLog.e("GdtDownloaderAdapterV2", "[callBackJs] error, adapter is null");
            } else if (downloadInfo == null || downloadInfo.f() != 1) {
                gdtDownloaderAdapterV2.g(downloadInfo);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static final class b implements com.tencent.gdtad.downloader.x {

        /* renamed from: a, reason: collision with root package name */
        private String f108450a;

        /* renamed from: b, reason: collision with root package name */
        private Ad f108451b;

        /* renamed from: c, reason: collision with root package name */
        private WeakReference<AdDownloaderV2.OnQueryListener> f108452c;

        public b(String str, Ad ad5, WeakReference<AdDownloaderV2.OnQueryListener> weakReference) {
            this.f108450a = str;
            this.f108451b = ad5;
            this.f108452c = weakReference;
        }

        private void b(int i3, int i16) {
            AdDownloaderV2.OnQueryListener onQueryListener;
            WeakReference<AdDownloaderV2.OnQueryListener> weakReference = this.f108452c;
            if (weakReference != null) {
                onQueryListener = weakReference.get();
            } else {
                onQueryListener = null;
            }
            if (onQueryListener == null) {
                GdtLog.e("GdtDownloaderAdapterV2", "[QueryCallbackImpl][notifyListener] error, listener is null");
                return;
            }
            if (i3 == Integer.MIN_VALUE) {
                GdtLog.i("GdtDownloaderAdapterV2", "[QueryCallbackImpl][notifyListener] error, status:" + i3);
                return;
            }
            if (i3 != 5 && i3 != 6) {
                if (i3 == 7) {
                    onQueryListener.onQuery(this.f108450a, i3, 100);
                    return;
                } else {
                    onQueryListener.onQuery(this.f108450a, i3);
                    return;
                }
            }
            onQueryListener.onQuery(this.f108450a, i3, i16);
        }

        @Override // com.tencent.gdtad.downloader.x
        public void a(@NonNull String str) {
            Long l3;
            try {
                JSONObject jSONObject = (JSONObject) new JSONArray(str).get(0);
                int i3 = jSONObject.getInt("state");
                int d16 = GdtDownloaderAdapterV2.d(i3);
                int i16 = jSONObject.getInt(WadlResult.WEB_KEY_PROGRESS);
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[DownloadTaskListener][callBackJs] aid:");
                Ad ad5 = this.f108451b;
                if (ad5 != null && ad5.isValid()) {
                    l3 = Long.valueOf(this.f108451b.getAId());
                } else {
                    l3 = null;
                }
                sb5.append(l3);
                sb5.append(" downloaderStatus:");
                sb5.append(i3);
                sb5.append(" status:");
                sb5.append(d16);
                sb5.append(" progress:");
                sb5.append(i16);
                sb5.append(" url:");
                sb5.append(this.f108450a);
                sb5.append(" result:");
                sb5.append(str);
                GdtLog.i("GdtDownloaderAdapterV2", sb5.toString());
                b(d16, i16);
            } catch (Throwable th5) {
                GdtLog.e("GdtDownloaderAdapterV2", "[DownloadTaskListener][callBackJs]", th5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(int i3) {
        int i16 = 0;
        if (i3 == 1) {
            return 0;
        }
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 10) {
                        i16 = Integer.MIN_VALUE;
                        if (i3 != 20) {
                            if (i3 == 30 || i3 == 40) {
                                return 8;
                            }
                            GdtLog.e("GdtDownloaderAdapterV2", "[convertStatusCode] unknown code:" + i3);
                            return Integer.MIN_VALUE;
                        }
                    }
                    return i16;
                }
                return 7;
            }
            return 6;
        }
        return 5;
    }

    private JSONObject e(String str, Ad ad5, int i3, int i16) {
        if (!TextUtils.isEmpty(str) && ad5 != null && ad5.isValid()) {
            JSONObject newJSONObject = AdJSONUtil.newJSONObject();
            AdJSONUtil.put(newJSONObject, "appId", ad5.getAppId());
            AdJSONUtil.put(newJSONObject, "posId", ad5.getPosId());
            AdJSONUtil.put(newJSONObject, "adId", Long.valueOf(ad5.getAId()));
            AdJSONUtil.put(newJSONObject, "traceId", ad5.getTraceId());
            AdJSONUtil.put(newJSONObject, "isAutoInstall", 1);
            AdJSONUtil.put(newJSONObject, "packageName", ad5.getAppPackageName());
            AdJSONUtil.put(newJSONObject, VirtualAppProxy.KEY_DOWNLOAD_SCENE, Integer.valueOf(i3));
            AdJSONUtil.put(newJSONObject, com.tencent.open.downloadnew.e.f341501j, str);
            AdJSONUtil.put(newJSONObject, com.tencent.open.downloadnew.e.f341502k, Integer.valueOf(i16));
            AdJSONUtil.put(newJSONObject, com.tencent.open.downloadnew.e.f341503l, ad5.getAppName());
            return newJSONObject;
        }
        GdtLog.e("GdtDownloaderAdapterV2", "[createDownloadInfo] error");
        return null;
    }

    public static GdtDownloaderAdapterV2 f() {
        if (f108442c == null) {
            synchronized (GdtDownloaderAdapterV2.class) {
                if (f108442c == null) {
                    f108442c = new GdtDownloaderAdapterV2();
                }
            }
        }
        return f108442c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(final DownloadInfo downloadInfo) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.adapter.GdtDownloaderAdapterV2.2
            @Override // java.lang.Runnable
            public void run() {
                AdDownloaderV2.OnStatusChangedListener onStatusChangedListener;
                DownloadInfo downloadInfo2 = downloadInfo;
                if (downloadInfo2 != null) {
                    int d16 = GdtDownloaderAdapterV2.d(downloadInfo2.f());
                    int min = Math.min(100, Math.max(0, downloadInfo.Q));
                    if (d16 == Integer.MIN_VALUE) {
                        GdtLog.i("GdtDownloaderAdapterV2", "[notifyListeners] do nothing");
                        return;
                    }
                    for (WeakReference weakReference : GdtDownloaderAdapterV2.this.f108443a) {
                        if (weakReference != null && (onStatusChangedListener = (AdDownloaderV2.OnStatusChangedListener) weakReference.get()) != null) {
                            if (d16 != 5 && d16 != 6) {
                                onStatusChangedListener.onStatusChanged(downloadInfo.f341186f, d16);
                            } else {
                                onStatusChangedListener.onStatusChanged(downloadInfo.f341186f, d16, min);
                            }
                        }
                    }
                    return;
                }
                GdtLog.e("GdtDownloaderAdapterV2", "[notifyListeners] error, downloadInfo is null");
            }
        }, 0);
    }

    @Override // com.tencent.ad.tangram.downloader.AdDownloaderAdapterV2
    public void cancelDownload(String str, Ad ad5, int i3) {
        if (!TextUtils.isEmpty(str) && ad5 != null && ad5.isValid()) {
            JSONObject e16 = e(str, ad5, i3, 10);
            GdtLog.i("GdtDownloaderAdapterV2", "[cancelDownload] jsonObject:" + e16);
            com.tencent.gdtad.downloader.p.f109191a.i(e16, xm0.c.f448149d.e());
            return;
        }
        GdtLog.e("GdtDownloaderAdapterV2", "[cancelDownload] error");
    }

    @Override // com.tencent.ad.tangram.downloader.AdDownloaderAdapterV2
    public void installDownload(String str, Ad ad5, int i3) {
        if (!TextUtils.isEmpty(str) && ad5 != null && ad5.isValid()) {
            JSONObject e16 = e(str, ad5, i3, 5);
            GdtLog.i("GdtDownloaderAdapterV2", "[installDownload] jsonObject:" + e16);
            com.tencent.gdtad.downloader.p.f109191a.i(e16, xm0.c.f448149d.e());
            return;
        }
        GdtLog.e("GdtDownloaderAdapterV2", "[installDownload] error");
    }

    @Override // com.tencent.ad.tangram.downloader.AdDownloaderAdapterV2
    public void pauseDownload(String str, Ad ad5, int i3) {
        if (TextUtils.isEmpty(str)) {
            GdtLog.e("GdtDownloaderAdapterV2", "[pauseDownload] error");
            return;
        }
        JSONObject e16 = e(str, ad5, i3, 3);
        GdtLog.i("GdtDownloaderAdapterV2", "[pauseDownload] jsonObject:" + e16);
        com.tencent.gdtad.downloader.p.f109191a.i(e16, xm0.c.f448149d.e());
    }

    @Override // com.tencent.ad.tangram.downloader.AdDownloaderAdapterV2
    public void queryDownload(final String str, final Ad ad5, int i3, final WeakReference<AdDownloaderV2.OnQueryListener> weakReference) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.adapter.GdtDownloaderAdapterV2.1
            @Override // java.lang.Runnable
            public void run() {
                Ad ad6;
                if (!TextUtils.isEmpty(str) && (ad6 = ad5) != null && ad6.isValid()) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("url", str);
                        JSONArray jSONArray = new JSONArray();
                        jSONArray.mo162put(jSONObject);
                        com.tencent.gdtad.downloader.p.f109191a.j(jSONArray, new b(str, ad5, weakReference));
                        GdtLog.i("GdtDownloaderAdapterV2", "[queryDownload] jsonObject:" + jSONObject);
                        return;
                    } catch (Throwable th5) {
                        GdtLog.e("GdtDownloaderAdapterV2", "[queryDownload]", th5);
                        return;
                    }
                }
                GdtLog.e("GdtDownloaderAdapterV2", "[queryDownload] error");
            }
        }, 4);
    }

    @Override // com.tencent.ad.tangram.downloader.AdDownloaderAdapterV2
    public void registerListener(WeakReference<AdDownloaderV2.OnStatusChangedListener> weakReference) {
        if (weakReference != null && weakReference.get() != null) {
            for (WeakReference<AdDownloaderV2.OnStatusChangedListener> weakReference2 : this.f108443a) {
                if (weakReference2 != null && weakReference2.get() == weakReference.get()) {
                    GdtLog.i("GdtDownloaderAdapterV2", "[registerListener] listener exists");
                    return;
                }
            }
            GdtLog.i("GdtDownloaderAdapterV2", "[registerListener]");
            if (this.f108443a.isEmpty()) {
                xm0.c.f448149d.g(new WeakReference<>(this.f108444b));
            }
            this.f108443a.add(weakReference);
        }
    }

    @Override // com.tencent.ad.tangram.downloader.AdDownloaderAdapterV2
    public void startDownload(String str, Ad ad5, int i3) {
        if (!TextUtils.isEmpty(str) && ad5 != null && ad5.isValid()) {
            JSONObject e16 = e(str, ad5, i3, 2);
            GdtLog.i("GdtDownloaderAdapterV2", "[startDownload] jsonObject:" + e16);
            com.tencent.gdtad.downloader.p.f109191a.i(e16, xm0.c.f448149d.e());
            return;
        }
        GdtLog.e("GdtDownloaderAdapterV2", "[startDownload] error");
    }

    @Override // com.tencent.ad.tangram.downloader.AdDownloaderAdapterV2
    public void unregisterListener(WeakReference<AdDownloaderV2.OnStatusChangedListener> weakReference) {
        if (weakReference != null && weakReference.get() != null) {
            for (WeakReference<AdDownloaderV2.OnStatusChangedListener> weakReference2 : this.f108443a) {
                if (weakReference2 != null && weakReference2.get() == weakReference.get()) {
                    GdtLog.i("GdtDownloaderAdapterV2", "[unregisterListener]");
                    this.f108443a.remove(weakReference2);
                    if (this.f108443a.isEmpty()) {
                        xm0.c.f448149d.h(new WeakReference<>(this.f108444b));
                        return;
                    }
                    return;
                }
            }
            GdtLog.i("GdtDownloaderAdapterV2", "[unregisterListener] listener not exists");
        }
    }
}
