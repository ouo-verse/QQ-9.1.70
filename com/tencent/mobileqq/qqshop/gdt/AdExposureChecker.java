package com.tencent.mobileqq.qqshop.gdt;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.annotation.AdKeep;
import com.tencent.ad.tangram.statistics.AdAnalysisHelperForUtil;
import com.tencent.ad.tangram.util.AdExposureListHolder;
import com.tencent.ad.tangram.util.AdUIUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

/* compiled from: P */
@AdKeep
/* loaded from: classes17.dex */
public final class AdExposureChecker {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqshop.gdt.AdExposureChecker$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ AdExposureChecker this$0;

        @Override // java.lang.Runnable
        public void run() {
            View view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (AdExposureChecker.h(null) != null) {
                view = (View) AdExposureChecker.h(null).get();
            } else {
                view = null;
            }
            if (view != null && AdExposureChecker.a(null) != null && AdExposureChecker.j(null) != 1) {
                if (!AdExposureListHolder.getInstance().containsTraceIdForAnalysis(AdExposureChecker.a(null).getTraceId())) {
                    AdAnalysisHelperForUtil.reportForExposureApiInvoked(view.getContext(), AdExposureChecker.a(null));
                    AdExposureListHolder.getInstance().addTraceIdForAnalysis(AdExposureChecker.a(null).getTraceId());
                }
                AdExposureChecker.p(null, view);
                if (AdExposureChecker.d(null) == null) {
                    AdExposureChecker.l(null, new InternalTask(null));
                }
                AdExposureChecker.o(null, 1);
                AdExposureChecker.i(null).post(AdExposureChecker.d(null));
                return;
            }
            QLog.e("AdExposureChecker", 2, "startCheck: " + AdExposureChecker.j(null));
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqshop.gdt.AdExposureChecker$2, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass2 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ AdExposureChecker this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.d("AdExposureChecker", 2, "onActivityResume");
            AdExposureChecker.n(null, true);
            AdExposureChecker.s(null);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqshop.gdt.AdExposureChecker$3, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass3 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ AdExposureChecker this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.e("AdExposureChecker", 2, "onActivityPause");
            AdExposureChecker.n(null, false);
            AdExposureChecker.r(null);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqshop.gdt.AdExposureChecker$4, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass4 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ AdExposureChecker this$0;

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.e("AdExposureChecker", 2, "onActivityDestroy");
            AdExposureChecker.m(null, true);
            AdExposureChecker.q(null);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqshop.gdt.AdExposureChecker$5, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass5 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f274456d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WeakReference f274457e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ad f274458f;

        @Override // java.lang.Runnable
        public void run() {
            Ad ad5;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.f274456d != null && this.f274457e != null && (ad5 = this.f274458f) != null && ad5.isValid() && !TextUtils.isEmpty(this.f274458f.getTraceId())) {
                if (!AdExposureListHolder.getInstance().inCheckedList(this.f274458f.getTraceId())) {
                    AdExposureListHolder.getInstance().putExternalReportData(this.f274456d, this.f274458f.getTraceId());
                    a aVar = (a) this.f274457e.get();
                    if (aVar != null) {
                        aVar.onExposure(null);
                    }
                    AdAnalysisHelperForUtil.reportForExposureCallback(this.f274456d, this.f274458f, 1);
                    return;
                }
                return;
            }
            QLog.e("AdExposureChecker", 2, "onClick error");
        }
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    private class InternalTask implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ AdExposureChecker this$0;

        InternalTask(AdExposureChecker adExposureChecker) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) adExposureChecker);
            }
        }

        private boolean e() {
            View view;
            a aVar;
            String str;
            QLog.i("AdExposureChecker", 2, "count:" + AdExposureChecker.b(null) + " status: " + AdExposureChecker.j(null));
            if (AdExposureChecker.a(null) != null && AdExposureListHolder.getInstance().inCheckedList(AdExposureChecker.a(null).getTraceId())) {
                QLog.e("AdExposureChecker", 2, "trace id is already exposured " + AdExposureChecker.a(null).getTraceId());
            } else {
                if (AdExposureChecker.h(null) != null) {
                    view = (View) AdExposureChecker.h(null).get();
                } else {
                    view = null;
                }
                if (AdExposureChecker.g(null) != null) {
                    aVar = (a) AdExposureChecker.g(null).get();
                } else {
                    aVar = null;
                }
                if (view != null && aVar != null && !AdExposureChecker.e(null) && AdExposureChecker.f(null) && AdExposureChecker.j(null) == 1) {
                    if (!view.isShown()) {
                        QLog.e("AdExposureChecker", 2, "!mViewRef.get().isShown()");
                    } else {
                        if (!AdExposureChecker.v(view)) {
                            return false;
                        }
                        if (AdExposureChecker.b(null) >= 1000 / AdExposureChecker.c(null)) {
                            Context context = view.getContext();
                            AdExposureListHolder adExposureListHolder = AdExposureListHolder.getInstance();
                            if (AdExposureChecker.a(null) != null) {
                                str = AdExposureChecker.a(null).getTraceId();
                            } else {
                                str = null;
                            }
                            adExposureListHolder.putExternalReportData(context, str);
                            aVar.onExposure(AdExposureChecker.h(null));
                            AdExposureChecker.o(null, 2);
                            AdAnalysisHelperForUtil.reportForExposureCallback(context, AdExposureChecker.a(null), 0);
                            QLog.d("AdExposureChecker", 2, "exposure success stop check");
                            AdExposureChecker.t(null);
                        }
                        AdExposureChecker.k(null, AdExposureChecker.b(null) + 1);
                        return true;
                    }
                } else {
                    QLog.e("AdExposureChecker", 2, "check failed : isViewDestroyed " + AdExposureChecker.e(null) + " isViewOnForeground " + AdExposureChecker.f(null) + " status " + AdExposureChecker.j(null) + " no callback :" + aVar);
                }
            }
            AdExposureChecker.t(null);
            AdExposureChecker.o(null, 3);
            return false;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                e();
                AdExposureChecker.i(null).postDelayed(AdExposureChecker.d(null), AdExposureChecker.c(null));
            }
        }
    }

    /* compiled from: P */
    @AdKeep
    /* loaded from: classes17.dex */
    public interface a {
        void onExposure(WeakReference<View> weakReference);
    }

    static /* bridge */ /* synthetic */ Ad a(AdExposureChecker adExposureChecker) {
        throw null;
    }

    static /* bridge */ /* synthetic */ int b(AdExposureChecker adExposureChecker) {
        throw null;
    }

    static /* bridge */ /* synthetic */ long c(AdExposureChecker adExposureChecker) {
        throw null;
    }

    static /* bridge */ /* synthetic */ InternalTask d(AdExposureChecker adExposureChecker) {
        throw null;
    }

    static /* bridge */ /* synthetic */ boolean e(AdExposureChecker adExposureChecker) {
        throw null;
    }

    static /* bridge */ /* synthetic */ boolean f(AdExposureChecker adExposureChecker) {
        throw null;
    }

    static /* bridge */ /* synthetic */ WeakReference g(AdExposureChecker adExposureChecker) {
        throw null;
    }

    static /* bridge */ /* synthetic */ WeakReference h(AdExposureChecker adExposureChecker) {
        throw null;
    }

    static /* bridge */ /* synthetic */ Handler i(AdExposureChecker adExposureChecker) {
        throw null;
    }

    static /* bridge */ /* synthetic */ int j(AdExposureChecker adExposureChecker) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void k(AdExposureChecker adExposureChecker, int i3) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void l(AdExposureChecker adExposureChecker, InternalTask internalTask) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void m(AdExposureChecker adExposureChecker, boolean z16) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void n(AdExposureChecker adExposureChecker, boolean z16) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void o(AdExposureChecker adExposureChecker, int i3) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void p(AdExposureChecker adExposureChecker, View view) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void q(AdExposureChecker adExposureChecker) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void r(AdExposureChecker adExposureChecker) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void s(AdExposureChecker adExposureChecker) {
        throw null;
    }

    static /* bridge */ /* synthetic */ void t(AdExposureChecker adExposureChecker) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean v(@Nullable View view) {
        if (view == null || view.getVisibility() != 0 || AdUIUtils.getPercentageOfGlobalVisibleRect(view) < 0.5d) {
            return false;
        }
        return true;
    }
}
