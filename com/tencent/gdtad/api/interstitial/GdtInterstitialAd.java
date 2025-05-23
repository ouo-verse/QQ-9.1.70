package com.tencent.gdtad.api.interstitial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.ad.tangram.ipc.AdIPCManager;
import com.tencent.ad.tangram.process.AdProcessManager;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtInterstitialAd implements IGdtInterstitialAd {

    /* renamed from: a, reason: collision with root package name */
    private GdtInterstitialParams f108590a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f108591b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f108592c = false;

    /* renamed from: d, reason: collision with root package name */
    @NonNull
    private AdIPCManager.Callback f108593d = new a();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static final class IPCHandlerForClose implements AdIPCManager.Handler {
        @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Handler
        @NonNull
        public AdIPCManager.Result handle(@Nullable AdIPCManager.Params params) {
            String str;
            Bundle bundle;
            final GdtInterstitialFragment c16;
            AdIPCManager.Result result = new AdIPCManager.Result();
            if (params != null && params.isValid() && (bundle = params.bundle) != null) {
                String string = bundle.getString("TRACE_ID");
                if (params.bundle != null && (c16 = e.d().c(string)) != null) {
                    GdtInterstitialNotifyReg.s(BaseApplication.getContext(), c16.th(), c16.uh());
                    result.success = true;
                    AdThreadManager.getInstance().postDelayed(new Runnable() { // from class: com.tencent.gdtad.api.interstitial.GdtInterstitialAd.IPCHandlerForClose.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GdtLog.e("GdtInterstitialAd", "IPCHandlerForClose.handle timeout");
                            c16.sh(4, 13, Integer.MIN_VALUE, Integer.MIN_VALUE);
                        }
                    }, 0, 2000L);
                }
            }
            Object[] objArr = new Object[3];
            String str2 = null;
            if (params != null) {
                str = params.getAction();
            } else {
                str = null;
            }
            objArr[0] = str;
            if (params != null) {
                str2 = params.getToProcessName();
            }
            objArr[1] = str2;
            objArr[2] = Boolean.valueOf(result.success);
            GdtLog.i("GdtInterstitialAd", String.format("IPCHandlerForClose.handle action:%s to:%s success:%b", objArr));
            return result;
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements AdIPCManager.Callback {
        a() {
        }

        @Override // com.tencent.ad.tangram.ipc.AdIPCManager.Callback
        public void onCallback(AdIPCManager.Params params, @Nullable AdIPCManager.Result result) {
            boolean z16 = true;
            Object[] objArr = new Object[1];
            if (result == null || !result.success) {
                z16 = false;
            }
            objArr[0] = Boolean.valueOf(z16);
            GdtLog.i("GdtInterstitialAd", String.format("close.onCallback %b", objArr));
        }
    }

    public GdtInterstitialAd(Context context, GdtInterstitialParams gdtInterstitialParams) {
        this.f108590a = gdtInterstitialParams;
        ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).initGdtContext(context, new InitGdtContextParams());
    }

    private GdtInterstitialParams a() {
        return this.f108590a;
    }

    @Override // com.tencent.gdtad.api.interstitial.IGdtInterstitialAd
    public boolean canShow() {
        if (!this.f108591b && a() != null && a().canShow()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gdtad.api.interstitial.IGdtInterstitialAd
    public void close(Activity activity) {
        boolean z16;
        if (Looper.myLooper() == Looper.getMainLooper() && this.f108591b && !this.f108592c && a() != null) {
            this.f108592c = true;
            Bundle bundle = new Bundle();
            bundle.putString(AdIPCManager.Params.KEY_ACTION, "ipc_interstitial_close");
            bundle.putString(AdIPCManager.Params.KEY_TO_PROCESS_NAME, AdProcessManager.getInstance().getWebProcessName());
            bundle.putString("TRACE_ID", a().getTraceId());
            AdIPCManager.getInstance().send(activity, new AdIPCManager.Params(bundle), new WeakReference<>(this.f108593d));
            z16 = true;
        } else {
            z16 = false;
        }
        GdtLog.i("GdtInterstitialAd", String.format("close %b", Boolean.valueOf(z16)));
    }

    @Override // com.tencent.gdtad.api.interstitial.IGdtInterstitialAd
    public void onClose(Activity activity, int i3, @Nullable Intent intent) {
        GdtLog.i("GdtInterstitialAd", "onClose");
        if (intent != null) {
        }
    }

    @Override // com.tencent.gdtad.api.interstitial.IGdtInterstitialAd
    public void setAntiSpamParamsForDisplayOnReportServer(JSONObject jSONObject) {
        GdtInterstitialParams gdtInterstitialParams = this.f108590a;
        if (gdtInterstitialParams != null) {
            gdtInterstitialParams.antiSpamParamsForDisplayOnReportServer = jSONObject;
        }
    }

    @Override // com.tencent.gdtad.api.interstitial.IGdtInterstitialAd
    public boolean show(Activity activity) {
        int i3;
        if (Looper.myLooper() != Looper.getMainLooper() || !canShow()) {
            i3 = 1;
        } else {
            i3 = GdtInterstitialFragment.Ah(activity, a());
            if (i3 == 0) {
                this.f108591b = true;
                i3 = 0;
            }
        }
        GdtLog.i("GdtInterstitialAd", String.format("show %d", Integer.valueOf(i3)));
        GdtAnalysisHelperForInterstitial.reportFortShowInterstitialStart(activity, a(), i3);
        if (i3 != 0) {
            return false;
        }
        return true;
    }
}
