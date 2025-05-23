package com.tencent.gdtad.kuikly;

import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtKuiklyRenderViewDelegate implements h {

    /* renamed from: d, reason: collision with root package name */
    private final GdtAd f109257d;

    /* renamed from: e, reason: collision with root package name */
    private final WeakReference<a> f109258e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f109259f;

    /* renamed from: h, reason: collision with root package name */
    private final String f109260h;

    /* renamed from: i, reason: collision with root package name */
    private final String f109261i;

    /* renamed from: m, reason: collision with root package name */
    private volatile long f109262m = WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        int onLoadFailed(int i3);

        int onLoadSuccess();
    }

    public GdtKuiklyRenderViewDelegate(GdtAd gdtAd, WeakReference<a> weakReference, Handler handler, String str, String str2) {
        this.f109257d = gdtAd;
        this.f109258e = weakReference;
        this.f109259f = handler;
        this.f109260h = str;
        this.f109261i = str2;
    }

    private long c() {
        if (this.f109262m == WebViewConstants.WV.ENABLE_WEBAIO_SWITCH) {
            return WebViewConstants.WV.ENABLE_WEBAIO_SWITCH;
        }
        return System.currentTimeMillis() - this.f109262m;
    }

    private void d(final int i3) {
        Handler handler = this.f109259f;
        if (handler == null) {
            e(i3);
        } else {
            handler.post(new Runnable() { // from class: com.tencent.gdtad.kuikly.GdtKuiklyRenderViewDelegate.2
                @Override // java.lang.Runnable
                public void run() {
                    GdtKuiklyRenderViewDelegate.this.e(i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i3) {
        a aVar;
        WeakReference<a> weakReference = this.f109258e;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            QLog.e("GdtKuiklyRenderViewDelegate", 1, "[notifyFailedImpl] error, listener is null, errorCode:" + i3);
            return;
        }
        QLog.i("GdtKuiklyRenderViewDelegate", 1, "[notifyFailedImpl] start, errorCode:" + i3);
        QLog.i("GdtKuiklyRenderViewDelegate", 1, "[notifyFailedImpl] end, result:" + aVar.onLoadFailed(i3) + " errorCode:" + i3);
    }

    private void f() {
        Handler handler = this.f109259f;
        if (handler == null) {
            g();
        } else {
            handler.post(new Runnable() { // from class: com.tencent.gdtad.kuikly.GdtKuiklyRenderViewDelegate.1
                @Override // java.lang.Runnable
                public void run() {
                    GdtKuiklyRenderViewDelegate.this.g();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        a aVar;
        WeakReference<a> weakReference = this.f109258e;
        if (weakReference != null) {
            aVar = weakReference.get();
        } else {
            aVar = null;
        }
        if (aVar == null) {
            QLog.e("GdtKuiklyRenderViewDelegate", 1, "[notifySuccessImpl] error, listener is null");
            return;
        }
        QLog.i("GdtKuiklyRenderViewDelegate", 1, "[notifySuccessImpl] start");
        QLog.i("GdtKuiklyRenderViewDelegate", 1, "[notifySuccessImpl] end, result:" + aVar.onLoadSuccess());
    }

    public void h(long j3) {
        this.f109262m = j3;
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideErrorView() {
        QLog.i("GdtKuiklyRenderViewDelegate", 1, "[hideErrorView] durationMillis:" + c());
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void hideLoadingView() {
        QLog.i("GdtKuiklyRenderViewDelegate", 1, "[hideLoadingView] durationMillis:" + c());
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void onPageLoadComplete(boolean z16, @Nullable ErrorReason errorReason, @NonNull KuiklyRenderCoreExecuteMode kuiklyRenderCoreExecuteMode) {
        Integer num;
        if (z16) {
            f();
            com.tencent.gdtad.kuikly.a.h("GdtKuiklyRenderViewDelegate", "[onPageLoadComplete] isSucceed:" + z16 + " errorReason:" + errorReason + " executeMode:" + kuiklyRenderCoreExecuteMode + " durationMillis:" + c(), AdMetricID.Kuikly.RenderViewDelegate.ON_PAGE_LOAD_COMPLETE_SUCCESS, AdMetricID.Kuikly.RenderViewDelegate.ON_PAGE_LOAD_COMPLETE_SUCCESS_TIME_MILLIS, this.f109257d, this.f109260h, this.f109261i, c());
            return;
        }
        d(402);
        String str = "[onPageLoadComplete] error, isSucceed:" + z16 + " errorReason:" + errorReason + " executeMode:" + kuiklyRenderCoreExecuteMode + " durationMillis:" + c();
        GdtAd gdtAd = this.f109257d;
        String str2 = this.f109260h;
        String str3 = this.f109261i;
        long c16 = c();
        if (errorReason != null) {
            num = Integer.valueOf(errorReason.ordinal());
        } else {
            num = null;
        }
        com.tencent.gdtad.kuikly.a.d("GdtKuiklyRenderViewDelegate", str, null, AdMetricID.Kuikly.RenderViewDelegate.ON_PAGE_LOAD_COMPLETE_FAILED, AdMetricID.Kuikly.RenderViewDelegate.ON_PAGE_LOAD_COMPLETE_FAILED_TIME_MILLIS, gdtAd, str2, str3, c16, 402, AdMetricTag.Kuikly.ON_PAGE_LOAD_FAILED_ERROR_CODE, num);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showErrorView() {
        d(401);
        com.tencent.gdtad.kuikly.a.h("GdtKuiklyRenderViewDelegate", "[showErrorView] durationMillis:" + c(), AdMetricID.Kuikly.RenderViewDelegate.SHOW_ERROR_VIEW, AdMetricID.Kuikly.RenderViewDelegate.SHOW_ERROR_VIEW_TIME_MILLIS, this.f109257d, this.f109260h, this.f109261i, c());
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h
    public void showLoadingView() {
        QLog.i("GdtKuiklyRenderViewDelegate", 1, "[showLoadingView] durationMillis:" + c());
    }
}
