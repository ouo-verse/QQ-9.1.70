package com.tencent.mobileqq.activity.qqsettingme;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.NightModeLogic;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ag extends com.tencent.mobileqq.processor.c {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public MutableLiveData<Integer> f184790h;

    /* renamed from: i, reason: collision with root package name */
    public MutableLiveData<Integer> f184791i;

    /* renamed from: j, reason: collision with root package name */
    private NightModeLogic f184792j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f184793k;

    /* renamed from: l, reason: collision with root package name */
    private View f184794l;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.mobileqq.qqsettingme.a f184795m;

    /* renamed from: n, reason: collision with root package name */
    private final NightModeLogic.NightModeCallback f184796n;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements NightModeLogic.NightModeCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ag.this);
            }
        }

        @Override // com.tencent.mobileqq.vas.theme.NightModeLogic.NightModeCallback
        public void onRespComplete(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
                return;
            }
            int i3 = bundle.getInt("start_status");
            if (i3 == 1) {
                ag.this.e();
                return;
            }
            if (i3 == 2) {
                ag.this.e();
            } else if (i3 == 3) {
                ag.this.f184791i.setValue(Integer.valueOf(bundle.getInt("percent")));
            }
        }

        @Override // com.tencent.mobileqq.vas.theme.NightModeLogic.NightModeCallback
        public void onRespError(Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            } else {
                ag.this.e();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements Observer<Integer> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184798d;

        b(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184798d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ag.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
            } else {
                this.f184798d.J(num.intValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class c implements Observer<Integer> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.qqsettingme.a f184800d;

        c(com.tencent.mobileqq.qqsettingme.a aVar) {
            this.f184800d = aVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ag.this, (Object) aVar);
            }
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) num);
            } else {
                if (num.intValue() == 0) {
                    return;
                }
                this.f184800d.K(num.intValue());
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d implements DarkModeManager.e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f184802a;

        d(View view) {
            this.f184802a = view;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ag.this, (Object) view);
            }
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.theme.DarkModeManager.e
        public void onConfirm() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                ag.this.n(this.f184802a);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }
    }

    public ag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f184790h = new MutableLiveData<>();
        this.f184791i = new MutableLiveData<>();
        this.f184796n = new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(View view) {
        String str;
        String str2;
        if (QQTheme.isNowThemeIsNight()) {
            str = "0";
        } else {
            str = "1";
        }
        ReportController.o(null, "dc00898", "", "", "0x800C0D3", "0x800C0D3", 0, 0, str, "", "", "");
        VideoReport.reportEvent("clck", view, null);
        if (this.f184792j == null) {
            QLog.e("QQSettingMeBaseProcessor", 1, "onNightModeClick mNightModeLogic is null");
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity == null) {
            return;
        }
        this.f184792j.startNightMode(qBaseActivity);
        View view2 = this.f184794l;
        if (view2 != null) {
            view2.setOnClickListener(null);
            this.f184794l.setClickable(false);
            DrawerFrame.f185113z0 = 0;
            if (AppSetting.f99565y) {
                if (!QQTheme.isNowThemeIsNight()) {
                    str2 = "\u5173\u95ed\u591c\u95f4\u6a21\u5f0f";
                } else {
                    str2 = "\u591c\u95f4\u6a21\u5f0f ";
                }
                AccessibilityUtil.c(this.f184794l, str2, Button.class.getName());
            }
        }
        com.tencent.mobileqq.activity.qcircle.utils.c.g().downloadSkinPackage("https://downv6.qq.com/video_story/qcircle/skin/debug/darkmode-v241225144809.skin");
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void c(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
            return;
        }
        if (this.f184793k) {
            this.f184792j.registerModeCallbacks(this.f184796n, false);
            this.f184792j.onAccountChanged(appRuntime);
            this.f184792j.registerModeCallbacks(this.f184796n, true);
        }
        this.f259740a = new WeakReference<>(appRuntime);
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void d(com.tencent.mobileqq.qqsettingme.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
            return;
        }
        this.f184793k = false;
        this.f184795m = aVar;
        if (aVar.n()) {
            return;
        }
        this.f184794l = aVar.j();
        this.f184790h.observe(this.f259743d, new b(aVar));
        this.f184791i.observe(this.f259743d, new c(aVar));
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        com.tencent.mobileqq.qqsettingme.a aVar = this.f184795m;
        if (aVar != null && aVar.n()) {
            return;
        }
        this.f184790h.setValue(Integer.valueOf(this.f184792j.getNightModeStatus()));
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onClick(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
            return;
        }
        QBaseActivity qBaseActivity = this.f259741b.get();
        if (qBaseActivity != null && !DarkModeManager.w(qBaseActivity, "", new d(view))) {
            n(view);
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onDestroy() {
        NightModeLogic nightModeLogic;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f184793k && (nightModeLogic = this.f184792j) != null) {
            nightModeLogic.registerModeCallbacks(this.f184796n, false);
            this.f184792j.destroy();
        }
        this.f184794l = null;
        this.f184795m = null;
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onPostThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        NightModeLogic nightModeLogic = this.f184792j;
        if (nightModeLogic != null) {
            nightModeLogic.onPostThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onResume();
        com.tencent.mobileqq.qqsettingme.a aVar = this.f184795m;
        if (aVar != null && aVar.n()) {
            return;
        }
        if (!this.f184793k || this.f184792j == null) {
            NightModeLogic nightModeLogic = new NightModeLogic(MobileQQ.sMobileQQ.peekAppRuntime());
            this.f184792j = nightModeLogic;
            nightModeLogic.registerModeCallbacks(this.f184796n, true);
            this.f184793k = true;
        }
        e();
    }

    @Override // com.tencent.mobileqq.processor.c, com.tencent.mobileqq.processor.b
    public String w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "d_night_mode";
    }
}
