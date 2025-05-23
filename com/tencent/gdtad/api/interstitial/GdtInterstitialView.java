package com.tencent.gdtad.api.interstitial;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.ark.open.ArkView;
import com.tencent.gdtad.api.GdtAdView;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
final class GdtInterstitialView implements GdtAdView {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    private ArkView f108620d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes6.dex */
    public class a implements ArkViewImplement.LoadCallback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f108624d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f108625e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ WeakReference f108626f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ WeakReference f108627h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ GdtInterstitialParams f108628i;

        a(long j3, String str, WeakReference weakReference, WeakReference weakReference2, GdtInterstitialParams gdtInterstitialParams) {
            this.f108624d = j3;
            this.f108625e = str;
            this.f108626f = weakReference;
            this.f108627h = weakReference2;
            this.f108628i = gdtInterstitialParams;
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadFailed(int i3, int i16, String str, boolean z16) {
            int a16 = b.a(i16);
            if (a16 == 0) {
                a16 = 1;
            }
            GdtLog.i("GdtInterstitialView", String.format("onLoadFailed state:%d duration:%d errCode:%d msg:%s canRetry:%b error:%d", Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis() - this.f108624d), Integer.valueOf(i16), str, Boolean.valueOf(z16), Integer.valueOf(a16)));
            GdtInterstitialView.b(a16, i16, this.f108625e);
            GdtInterstitialStatus gdtInterstitialStatus = (GdtInterstitialStatus) this.f108626f.get();
            if (gdtInterstitialStatus != null && !gdtInterstitialStatus.arkViewLoadedReported) {
                gdtInterstitialStatus.arkViewLoadedReported = true;
                GdtAnalysisHelperForInterstitial.reportFortShowInterstitialLoadArkViewEnd((Context) this.f108627h.get(), this.f108628i, gdtInterstitialStatus, a16, i16);
            }
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadState(int i3) {
            GdtLog.i("GdtInterstitialView", String.format("onLoadState state:%d duration:%d", Integer.valueOf(i3), Long.valueOf(System.currentTimeMillis() - this.f108624d)));
            GdtInterstitialStatus gdtInterstitialStatus = (GdtInterstitialStatus) this.f108626f.get();
            if (i3 == 1 && gdtInterstitialStatus != null && !gdtInterstitialStatus.arkViewLoadedReported) {
                gdtInterstitialStatus.arkViewLoadedReported = true;
                gdtInterstitialStatus.arkViewLoaded = true;
                GdtAnalysisHelperForInterstitial.reportFortShowInterstitialLoadArkViewEnd((Context) this.f108627h.get(), this.f108628i, gdtInterstitialStatus, 0, Integer.MIN_VALUE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GdtInterstitialView(Context context, GdtInterstitialParams gdtInterstitialParams, GdtInterstitialStatus gdtInterstitialStatus) {
        this.f108620d = c(context, gdtInterstitialParams, gdtInterstitialStatus);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final int i3, final int i16, final String str) {
        AdThreadManager.getInstance().post(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtInterstitialView.2
            @Override // java.lang.Runnable
            public void run() {
                boolean z16;
                GdtInterstitialFragment c16;
                if (TextUtils.isEmpty(str) || (c16 = e.d().c(str)) == null) {
                    z16 = false;
                } else {
                    c16.sh(4, i3, i16, Integer.MIN_VALUE);
                    z16 = true;
                }
                GdtLog.i("GdtInterstitialView", String.format("close %b error:%d traceId:%s", Boolean.valueOf(z16), Integer.valueOf(i3), str));
            }
        }, 0);
    }

    @Nullable
    private static ArkView c(Context context, @Nullable GdtInterstitialParams gdtInterstitialParams, GdtInterstitialStatus gdtInterstitialStatus) {
        String str;
        int i3;
        WeakReference weakReference = new WeakReference(context);
        WeakReference weakReference2 = new WeakReference(gdtInterstitialStatus);
        ArkView arkView = null;
        if (gdtInterstitialParams != null) {
            str = gdtInterstitialParams.getTraceId();
        } else {
            str = null;
        }
        try {
            com.tencent.gdtad.api.interstitial.a a16 = e.d().a();
            GdtLog.i("GdtInterstitialView", String.format("load appName:%s view:%s minver:%s", a16.f108629a, a16.f108630b, a16.f108632d));
            long currentTimeMillis = System.currentTimeMillis();
            ArkView arkView2 = new ArkView(context, null);
            if (gdtInterstitialParams != null) {
                try {
                    int i16 = gdtInterstitialParams.width;
                    if (i16 >= 0 && (i3 = gdtInterstitialParams.height) >= 0) {
                        ArkAppInfo.Size size = new ArkAppInfo.Size(i16, i3);
                        arkView2.setSize(size, size, size);
                    }
                } catch (Throwable th5) {
                    th = th5;
                    arkView = arkView2;
                    AdLog.e("GdtInterstitialView", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, th);
                    ArkView arkView3 = arkView;
                    GdtAnalysisHelperForInterstitial.reportFortShowInterstitialLoadArkViewStart((Context) weakReference.get(), gdtInterstitialParams, (GdtInterstitialStatus) weakReference2.get());
                    return arkView3;
                }
            }
            String d16 = d(context, gdtInterstitialParams);
            arkView2.setBorderType(0);
            arkView = arkView2;
            arkView2.load(a16.f108629a, a16.f108630b, a16.f108632d, d16, null, new a(currentTimeMillis, str, weakReference2, weakReference, gdtInterstitialParams));
        } catch (Throwable th6) {
            th = th6;
        }
        ArkView arkView32 = arkView;
        GdtAnalysisHelperForInterstitial.reportFortShowInterstitialLoadArkViewStart((Context) weakReference.get(), gdtInterstitialParams, (GdtInterstitialStatus) weakReference2.get());
        return arkView32;
    }

    private static String d(Context context, @Nullable GdtInterstitialParams gdtInterstitialParams) {
        String str;
        int i3;
        if (gdtInterstitialParams != null && gdtInterstitialParams.canShow()) {
            int i16 = gdtInterstitialParams.orientation;
            if (i16 == 1) {
                str = "vertical";
                i3 = 1;
            } else if (i16 != 0 && i16 != 8) {
                str = null;
                i3 = Integer.MIN_VALUE;
            } else {
                str = "horizontal";
                i3 = 0;
            }
            if (!TextUtils.isEmpty(str) && i3 != Integer.MIN_VALUE) {
                int px2dp = AdUIUtils.px2dp(context, gdtInterstitialParams.width);
                int px2dp2 = AdUIUtils.px2dp(context, gdtInterstitialParams.height);
                GdtLog.i("GdtInterstitialView", String.format("getMetaData width:%d height:%d ptWidth:%d ptHeight:%d", Integer.valueOf(gdtInterstitialParams.width), Integer.valueOf(gdtInterstitialParams.height), Integer.valueOf(px2dp), Integer.valueOf(px2dp2)));
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("style", i3);
                    jSONObject.put("screenType", str);
                    Object pbToJson = GdtJsonPbUtil.pbToJson(gdtInterstitialParams.clickOptions.f108486ad.info);
                    if (pbToJson != null && !JSONObject.NULL.equals(pbToJson)) {
                        jSONObject.put("adInfo", pbToJson);
                    }
                    jSONObject.put("viewWidth", px2dp);
                    jSONObject.put("viewHeight", px2dp2);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("gdt", jSONObject);
                    return jSONObject2.toString();
                } catch (Throwable th5) {
                    GdtLog.e("GdtInterstitialView", "getMetaData", th5);
                    return null;
                }
            }
            GdtLog.e("GdtInterstitialView", "getMetaData error");
            return null;
        }
        GdtLog.e("GdtInterstitialView", "getMetaData error");
        return null;
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public void destroy(Context context) {
        GdtLog.i("GdtInterstitialView", "destroy");
        ArkView arkView = this.f108620d;
        if (arkView != null) {
            arkView.onDestroy();
        }
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    @Nullable
    public View getView() {
        return this.f108620d;
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public void pause(Context context) {
        GdtLog.i("GdtInterstitialView", "pause");
        ArkView arkView = this.f108620d;
        if (arkView != null) {
            arkView.onPause();
        }
    }

    @Override // com.tencent.gdtad.api.GdtAdView
    public void resume(Context context) {
        GdtLog.i("GdtInterstitialView", "resume");
        ArkView arkView = this.f108620d;
        if (arkView != null) {
            arkView.onResume();
        }
    }
}
