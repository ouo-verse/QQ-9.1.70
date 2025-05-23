package com.tencent.ams.xsad.rewarded;

import android.app.Activity;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.ams.dsdk.utils.DynamicUtils;
import com.tencent.ams.xsad.rewarded.RewardedAdListener;
import com.tencent.ams.xsad.rewarded.event.ModuleEvent;
import com.tencent.ams.xsad.rewarded.loader.a;
import com.tencent.ams.xsad.rewarded.report.RewardedTaskReporter;
import com.tencent.ams.xsad.rewarded.view.RewardedAdController;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RewardedAd implements a.InterfaceC0704a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private f f71664a;

    /* renamed from: b, reason: collision with root package name */
    private RewardedAdListener f71665b;

    /* renamed from: c, reason: collision with root package name */
    private com.tencent.ams.xsad.rewarded.loader.a f71666c;

    /* renamed from: d, reason: collision with root package name */
    private a f71667d;

    /* renamed from: e, reason: collision with root package name */
    private RewardedAdData f71668e;

    /* renamed from: f, reason: collision with root package name */
    private RewardedAdController f71669f;

    /* renamed from: g, reason: collision with root package name */
    private int f71670g;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes3.dex */
    @interface AdStatus {
        public static final int STATE_CLOSED = 6;
        public static final int STATE_IDLE = 0;
        public static final int STATE_LOADING = 1;
        public static final int STATE_LOAD_FAILED = 2;
        public static final int STATE_LOAD_FINISH = 3;
        public static final int STATE_SHOWING = 4;
        public static final int STATE_SHOW_FAILED = 5;
        public static final int STATE_SWITCHING = 7;
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public int f71679a;

        /* renamed from: b, reason: collision with root package name */
        public String f71680b;

        /* renamed from: c, reason: collision with root package name */
        public String f71681c;

        /* renamed from: d, reason: collision with root package name */
        public Map<String, Object> f71682d;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private static class b extends c {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        private RewardedTaskReporter f71683e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f71684f;

        /* renamed from: h, reason: collision with root package name */
        private a f71685h;

        public b(RewardedAdListener rewardedAdListener, a aVar, RewardedAdData rewardedAdData) {
            super(rewardedAdListener);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, rewardedAdListener, aVar, rewardedAdData);
            } else {
                this.f71685h = aVar;
                c(rewardedAdData);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAd.c, com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void Od(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            super.Od(i3);
            RewardedTaskReporter rewardedTaskReporter = this.f71683e;
            if (rewardedTaskReporter != null && !this.f71684f) {
                rewardedTaskReporter.h(i3);
            }
        }

        void c(RewardedAdData rewardedAdData) {
            if (rewardedAdData != null && !TextUtils.isEmpty(rewardedAdData.f71711y) && this.f71685h != null) {
                RewardedTaskReporter rewardedTaskReporter = new RewardedTaskReporter();
                rewardedTaskReporter.j(this.f71685h.f71679a);
                rewardedTaskReporter.k(this.f71685h.f71680b);
                rewardedTaskReporter.q(this.f71685h.f71681c);
                rewardedTaskReporter.n(rewardedAdData.f71711y);
                rewardedTaskReporter.m(rewardedAdData.f71710x);
                rewardedTaskReporter.p(rewardedAdData.f71708v);
                rewardedTaskReporter.o(rewardedAdData.f71709w);
                rewardedTaskReporter.l(rewardedAdData.f71693g);
                this.f71683e = rewardedTaskReporter;
                return;
            }
            com.tencent.ams.xsad.rewarded.utils.c.e("RewardedAd", "\u4efb\u52a1\u4e0a\u62a5\u53c2\u6570\u4e0d\u5168(taskReportUrl\u4e3a\u7a7a)\uff0c\u8bf7\u68c0\u67e5");
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAd.c, com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void onAdPlayStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAdPlayStart();
            RewardedTaskReporter rewardedTaskReporter = this.f71683e;
            if (rewardedTaskReporter != null) {
                rewardedTaskReporter.i();
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAd.c, com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void yg(com.tencent.ams.xsad.rewarded.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) bVar);
                return;
            }
            this.f71684f = true;
            super.yg(bVar);
            RewardedTaskReporter rewardedTaskReporter = this.f71683e;
            if (rewardedTaskReporter != null) {
                rewardedTaskReporter.g();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class c implements RewardedAdListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private RewardedAdListener f71686d;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void A1(com.tencent.ams.xsad.rewarded.view.a aVar, JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar, (Object) jSONObject);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.A1(aVar, jSONObject);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void Ab(RewardedAdListener.ClickInfo clickInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) clickInfo);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.Ab(clickInfo);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void D2() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.D2();
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void J1(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
                iPatchRedirector.redirect((short) 18, (Object) this, z16);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.J1(z16);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void K6(ModuleEvent moduleEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
                iPatchRedirector.redirect((short) 21, (Object) this, (Object) moduleEvent);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.K6(moduleEvent);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void L7(RewardedAdError rewardedAdError) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) rewardedAdError);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.L7(rewardedAdError);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void Od(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                iPatchRedirector.redirect((short) 16, (Object) this, i3);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.Od(i3);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void S7(com.tencent.ams.xsad.rewarded.view.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.S7(aVar);
            }
        }

        public RewardedAdListener a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
                return (RewardedAdListener) iPatchRedirector.redirect((short) 23, (Object) this);
            }
            return this.f71686d;
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void a5() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.a5();
            }
        }

        public void b(RewardedAdListener rewardedAdListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
                iPatchRedirector.redirect((short) 22, (Object) this, (Object) rewardedAdListener);
            } else {
                this.f71686d = rewardedAdListener;
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void gb(com.tencent.ams.xsad.rewarded.view.a aVar, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                iPatchRedirector.redirect((short) 10, this, aVar, Boolean.valueOf(z16));
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.gb(aVar, z16);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void jb(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                iPatchRedirector.redirect((short) 11, (Object) this, j3);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.jb(j3);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void m6(int i3, RewardedAdListener.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
                iPatchRedirector.redirect((short) 20, (Object) this, i3, (Object) bVar);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.m6(i3, bVar);
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void onAdPlayComplete() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                iPatchRedirector.redirect((short) 15, (Object) this);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.onAdPlayComplete();
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void onAdPlayPause() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                iPatchRedirector.redirect((short) 13, (Object) this);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.onAdPlayPause();
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void onAdPlayResume() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                iPatchRedirector.redirect((short) 14, (Object) this);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.onAdPlayResume();
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void onAdPlayStart() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                iPatchRedirector.redirect((short) 12, (Object) this);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.onAdPlayStart();
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void onOriginalExposure() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
                iPatchRedirector.redirect((short) 19, (Object) this);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.onOriginalExposure();
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void we() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.we();
            }
        }

        @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener
        public void yg(com.tencent.ams.xsad.rewarded.b bVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
                iPatchRedirector.redirect((short) 17, (Object) this, (Object) bVar);
                return;
            }
            RewardedAdListener rewardedAdListener = this.f71686d;
            if (rewardedAdListener != null) {
                rewardedAdListener.yg(bVar);
            }
        }

        public c(RewardedAdListener rewardedAdListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.f71686d = rewardedAdListener;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) rewardedAdListener);
            }
        }
    }

    public RewardedAd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f71670g = 0;
        }
    }

    private void f(RewardedAdError rewardedAdError) {
        com.tencent.ams.xsad.rewarded.utils.c.e("RewardedAd", "failLoad, error: " + rewardedAdError.toString());
        f fVar = this.f71664a;
        if (fVar != null) {
            fVar.b(this, rewardedAdError);
        }
    }

    private int k() {
        if (this.f71668e == null) {
            return 1;
        }
        if (!com.tencent.ams.xsad.rewarded.c.f().j() || TextUtils.isEmpty(this.f71668e.f71703q)) {
            return this.f71668e.f71688b ? 1 : 0;
        }
        RewardedAdData rewardedAdData = this.f71668e;
        if (rewardedAdData.f71712z == 1) {
            return 1;
        }
        return com.tencent.ams.xsad.rewarded.dynamic.b.b(rewardedAdData.f71689c);
    }

    private boolean m(RewardedAdData rewardedAdData) {
        if (rewardedAdData == null) {
            return false;
        }
        int i3 = rewardedAdData.f71712z;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3) {
                    return true;
                }
                return !TextUtils.isEmpty(rewardedAdData.f71705s);
            }
            return !TextUtils.isEmpty(rewardedAdData.B);
        }
        return !TextUtils.isEmpty(rewardedAdData.f71691e);
    }

    private void p(int i3, String str) {
        RewardedAdError rewardedAdError = new RewardedAdError(i3, str);
        RewardedAdListener rewardedAdListener = this.f71665b;
        if (rewardedAdListener != null) {
            rewardedAdListener.L7(rewardedAdError);
        }
        if (i3 >= 201) {
            this.f71670g = 5;
        }
        com.tencent.ams.xsad.rewarded.utils.c.e("RewardedAd", "onFail: " + rewardedAdError);
    }

    private void r(Activity activity, ViewGroup viewGroup, RewardedAdListener rewardedAdListener, float f16) {
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAd", "showRewardAd");
        this.f71665b = rewardedAdListener;
        if (activity != null && viewGroup != null) {
            if (f16 <= 0.0f) {
                p(202, "\u6700\u5927\u89e3\u9501\u65f6\u957f\u9519\u8bef\uff0c\u65e0\u6cd5\u5c55\u793a");
                return;
            }
            if (!l()) {
                p(203, "\u5e7f\u544a\u6ca1\u6709\u52a0\u8f7d\u597d\uff0c\u65e0\u6cd5\u5c55\u793a");
                com.tencent.ams.xsad.rewarded.utils.c.e("RewardedAd", "\u5e7f\u544a\u6ca1\u6709\u52a0\u8f7d\u597d\uff0c\u65e0\u6cd5\u5c55\u793a");
                return;
            }
            if (!m(this.f71668e)) {
                p(204, "\u5e7f\u544a\u8ba2\u5355\u65e0\u6548\uff0c\u65e0\u6cd5\u5c55\u793a");
                com.tencent.ams.xsad.rewarded.utils.c.e("RewardedAd", "\u5e7f\u544a\u6ca1\u6709\u52a0\u8f7d\u597d\uff0c\u65e0\u6cd5\u5c55\u793a");
                return;
            }
            RewardedAdData rewardedAdData = this.f71668e;
            if (rewardedAdData.f71712z == 0) {
                rewardedAdData.f71693g = (int) Math.min(f16 * 1000.0f, rewardedAdData.f71690d);
            }
            int k3 = k();
            activity.setRequestedOrientation(k3);
            com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAd", "orientation: " + k3);
            com.tencent.ams.xsad.rewarded.utils.c.e("RewardedAd", "\u5f00\u59cb\u5c55\u793a\u5e7f\u544a");
            this.f71670g = 4;
            d dVar = new d();
            this.f71669f = dVar;
            dVar.setRewardedAdListener(new b(rewardedAdListener, this.f71667d, this.f71668e, viewGroup) { // from class: com.tencent.ams.xsad.rewarded.RewardedAd.3
                static IPatchRedirector $redirector_;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ ViewGroup f71674i;

                /* compiled from: P */
                /* renamed from: com.tencent.ams.xsad.rewarded.RewardedAd$3$a */
                /* loaded from: classes3.dex */
                class a implements RewardedAdListener.b {
                    static IPatchRedirector $redirector_;

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ RewardedAdListener.b f71677a;

                    a(RewardedAdListener.b bVar) {
                        this.f71677a = bVar;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this, (Object) bVar);
                        }
                    }

                    @Override // com.tencent.ams.xsad.rewarded.RewardedAdListener.b
                    public void a(RewardedAdListener.a aVar) {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
                            return;
                        }
                        if (aVar != null && aVar.f71724b != null) {
                            RewardedAd.this.f71670g = 4;
                        }
                        if (aVar != null) {
                            c(aVar.f71724b);
                        }
                        RewardedAdListener.b bVar = this.f71677a;
                        if (bVar != null) {
                            bVar.a(aVar);
                        }
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(rewardedAdListener, r7, r8);
                    this.f71674i = viewGroup;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, RewardedAd.this, rewardedAdListener, r7, r8, viewGroup);
                    }
                }

                @Override // com.tencent.ams.xsad.rewarded.RewardedAd.c, com.tencent.ams.xsad.rewarded.RewardedAdListener
                public void jb(long j3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, j3);
                        return;
                    }
                    DynamicUtils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.xsad.rewarded.RewardedAd.3.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                AnonymousClass3.this.f71674i.removeAllViews();
                            }
                        }
                    });
                    super.jb(j3);
                    RewardedAd.this.f71670g = 6;
                }

                @Override // com.tencent.ams.xsad.rewarded.RewardedAd.c, com.tencent.ams.xsad.rewarded.RewardedAdListener
                public void m6(int i3, RewardedAdListener.b bVar) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                        RewardedAd.this.f71670g = 7;
                        super.m6(i3, new a(bVar));
                    } else {
                        iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bVar);
                    }
                }
            });
            this.f71669f.b(activity, viewGroup, this.f71668e, null);
            return;
        }
        p(201, "context\u4e3a\u7a7a\uff0c\u65e0\u6cd5\u5c55\u793a");
    }

    @Override // com.tencent.ams.xsad.rewarded.loader.a.InterfaceC0704a
    public void a(RewardedAd rewardedAd) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) rewardedAd);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.a("RewardedAd", "\u5f00\u59cb\u8bf7\u6c42\u5e7f\u544a");
        this.f71670g = 1;
        f fVar = this.f71664a;
        if (fVar != null) {
            fVar.a(rewardedAd);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.loader.a.InterfaceC0704a
    public void b(RewardedAd rewardedAd, RewardedAdData rewardedAdData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) rewardedAd, (Object) rewardedAdData);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.a("RewardedAd", "\u8bf7\u6c42\u5e7f\u544a\u6210\u529f");
        this.f71670g = 3;
        if (!m(rewardedAdData)) {
            f(new RewardedAdError(106, "\u65e0\u6548\u7684\u5e7f\u544a\u6570\u636e"));
            return;
        }
        this.f71668e = rewardedAdData;
        f fVar = this.f71664a;
        if (fVar != null) {
            fVar.c(this);
        }
    }

    @Override // com.tencent.ams.xsad.rewarded.loader.a.InterfaceC0704a
    public void c(RewardedAd rewardedAd, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) rewardedAd, (Object) str);
            return;
        }
        String str2 = "\u8bf7\u6c42\u5e7f\u544a\u5931\u8d25";
        com.tencent.ams.xsad.rewarded.utils.c.e("RewardedAd", "\u8bf7\u6c42\u5e7f\u544a\u5931\u8d25");
        this.f71670g = 2;
        int i3 = 0;
        try {
            JSONObject jSONObject = new JSONObject(str);
            i3 = jSONObject.optInt("code");
            str2 = jSONObject.optString("message");
        } catch (Throwable unused) {
        }
        if (i3 != 0) {
            f(new RewardedAdError(i3, str2));
        } else {
            f(new RewardedAdError(104, str));
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        this.f71664a = null;
        this.f71665b = null;
        this.f71666c = null;
        this.f71669f = null;
    }

    public RewardedAdData g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (RewardedAdData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f71668e;
    }

    public RewardedAdController h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (RewardedAdController) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f71669f;
    }

    public a i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (a) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.f71667d;
    }

    public long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this)).longValue();
        }
        RewardedAdController rewardedAdController = this.f71669f;
        if (rewardedAdController != null) {
            return rewardedAdController.c();
        }
        return 0L;
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        if (this.f71670g == 3) {
            return true;
        }
        return false;
    }

    public void n(a aVar, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar, (Object) fVar);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAd", "loadAd");
        int i3 = this.f71670g;
        if (i3 != 0 && i3 != 7) {
            com.tencent.ams.xsad.rewarded.utils.c.e("RewardedAd", "\u4e0d\u80fd\u91cd\u590d\u52a0\u8f7d\u5e7f\u544a");
            return;
        }
        this.f71667d = aVar;
        this.f71664a = fVar;
        com.tencent.ams.xsad.rewarded.loader.a b16 = com.tencent.ams.xsad.rewarded.c.f().b();
        this.f71666c = b16;
        if (b16 == null) {
            f(new RewardedAdError(101, "load provider\u4e3a\u7a7a"));
        } else {
            b16.c(this, this);
        }
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        com.tencent.ams.xsad.rewarded.utils.c.a("RewardedAd", "onBackPressed");
        RewardedAdController rewardedAdController = this.f71669f;
        if (rewardedAdController != null) {
            rewardedAdController.onBackPressed();
        }
    }

    public void q(Activity activity, RewardedAdListener rewardedAdListener, float f16) {
        FrameLayout frameLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, activity, rewardedAdListener, Float.valueOf(f16));
            return;
        }
        if (activity != null) {
            frameLayout = new FrameLayout(activity);
            activity.setContentView(frameLayout);
        } else {
            frameLayout = null;
        }
        r(activity, frameLayout, new b(rewardedAdListener, null, null, activity) { // from class: com.tencent.ams.xsad.rewarded.RewardedAd.2
            static IPatchRedirector $redirector_;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ Activity f71671i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(rewardedAdListener, r7, r8);
                this.f71671i = activity;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RewardedAd.this, rewardedAdListener, r7, r8, activity);
                }
            }

            @Override // com.tencent.ams.xsad.rewarded.RewardedAd.c, com.tencent.ams.xsad.rewarded.RewardedAdListener
            public void jb(long j3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, j3);
                    return;
                }
                DynamicUtils.runOnUiThread(new Runnable() { // from class: com.tencent.ams.xsad.rewarded.RewardedAd.2.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) AnonymousClass2.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this);
                            return;
                        }
                        Activity activity2 = AnonymousClass2.this.f71671i;
                        if (activity2 != null) {
                            activity2.finish();
                        }
                    }
                });
                com.tencent.ams.xsad.rewarded.utils.c.c("RewardedAd", "close reward activity");
                super.jb(j3);
            }
        }, f16);
    }
}
