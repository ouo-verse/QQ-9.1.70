package com.tencent.mobileqq.activity.aio.voicetextpanel.controller;

import android.os.Handler;
import android.os.Looper;
import c71.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextEditViewHelper;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSendViewHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import d71.c;
import mqq.app.AppRuntime;

/* loaded from: classes10.dex */
public class VoiceTextSttProcessController implements b {

    /* renamed from: a, reason: collision with root package name */
    private AppRuntime f180153a;

    /* renamed from: b, reason: collision with root package name */
    private a61.b f180154b;

    /* renamed from: c, reason: collision with root package name */
    private p f180155c;

    /* renamed from: d, reason: collision with root package name */
    private RecordParams.RecorderParam f180156d;

    /* renamed from: e, reason: collision with root package name */
    private String f180157e;

    /* renamed from: f, reason: collision with root package name */
    private String f180158f;

    /* renamed from: g, reason: collision with root package name */
    private int f180159g;

    /* renamed from: h, reason: collision with root package name */
    private VoiceTextPanel f180160h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f180161i;

    /* renamed from: j, reason: collision with root package name */
    private VoiceTextSendViewHelper f180162j;

    /* renamed from: k, reason: collision with root package name */
    private VoiceTextEditViewHelper f180163k;

    /* renamed from: l, reason: collision with root package name */
    private c f180164l;

    /* renamed from: m, reason: collision with root package name */
    private VoiceTextSttQueryController f180165m;

    /* renamed from: n, reason: collision with root package name */
    private INetInfoHandler f180166n = new INetInfoHandler() { // from class: com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController.1
        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
            VoiceTextSttProcessController.this.f180161i.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController.1.1
                @Override // java.lang.Runnable
                public void run() {
                    VoiceTextSttProcessController.this.i();
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
            VoiceTextSttProcessController.this.f180161i.post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController.1.2
                @Override // java.lang.Runnable
                public void run() {
                    VoiceTextSttProcessController.this.i();
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String str) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String str) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String str) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String str) {
        }
    };

    /* renamed from: com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController$2, reason: invalid class name */
    /* loaded from: classes10.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ VoiceTextSttProcessController this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.f180163k.s();
            this.this$0.f180164l.c().g(5);
            QQToast.makeText(this.this$0.f180160h.getContext(), HardCodeUtil.qqStr(R.string.f214705tm), 0).show(this.this$0.f180160h.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        }
    }

    public VoiceTextSttProcessController(c cVar, AppRuntime appRuntime, VoiceTextPanel voiceTextPanel) {
        this.f180153a = appRuntime;
        this.f180160h = voiceTextPanel;
        this.f180164l = cVar;
        this.f180162j = new VoiceTextSendViewHelper(cVar, appRuntime, appRuntime.getApp().getSharedPreferences(AppConstants.Preferences.CHECK_UPDATE_SP_KEY, 0));
        Handler handler = new Handler(Looper.getMainLooper());
        this.f180161i = handler;
        this.f180163k = new VoiceTextEditViewHelper(cVar, appRuntime, handler);
        this.f180165m = new VoiceTextSttQueryController();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (this.f180164l.c().d() || this.f180164l.c().a()) {
            QQToast.makeText(this.f180160h.getContext(), HardCodeUtil.qqStr(R.string.viz), 0).show(this.f180160h.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
            w();
            this.f180163k.r();
            this.f180165m.s();
            this.f180163k.q(this.f180164l.b().b());
            this.f180164l.c().g(5);
        }
    }

    private void k() {
        if (this.f180164l.c().c()) {
            this.f180156d.E = this.f180164l.b().b();
            String str = this.f180156d.E;
            if (str != null && str.length() > 150) {
                RecordParams.RecorderParam recorderParam = this.f180156d;
                recorderParam.E = recorderParam.E.substring(0, 150);
            }
        }
    }

    private void r() {
        if (QLog.isColorLevel()) {
            QLog.d("VoiceTextSttProcessController", 2, "sendRequest  net unAvailable");
        }
        QQToast.makeText(this.f180160h.getContext(), HardCodeUtil.qqStr(R.string.viy), 0).show(this.f180160h.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        w();
        this.f180164l.c().g(5);
    }

    private void s() {
        if (this.f180164l.d().b()) {
            e71.a.a("0X800A1DA", 3, 0);
        } else {
            e71.a.a("0X800A1DA", 2, 0);
        }
    }

    private void x(boolean z16) {
        this.f180162j.w(z16);
    }

    private void y() {
        if (!StringUtil.isEmpty(this.f180164l.b().b())) {
            this.f180164l.c().g(2);
            if (!this.f180162j.q()) {
                x(true);
            }
        }
    }

    @Override // c71.b
    public void a(int i3) {
        QQToast.makeText(this.f180160h.getContext(), HardCodeUtil.qqStr(R.string.viz), 0).show(this.f180160h.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height));
        w();
        this.f180163k.r();
        this.f180165m.s();
        this.f180163k.q(this.f180164l.b().b());
        this.f180164l.c().g(5);
    }

    @Override // c71.b
    public void b(String str) {
        if (!this.f180164l.c().b() && !this.f180164l.c().e()) {
            this.f180164l.b().d(str);
            y();
        } else if (QLog.isColorLevel()) {
            QLog.d("VoiceTextSttProcessController", 2, "updateText has finish");
        }
    }

    @Override // c71.b
    public void c() {
        this.f180164l.c().g(4);
    }

    public void j() {
        this.f180163k.i();
        this.f180165m.i();
    }

    public void l(a61.b bVar, p pVar, RecordParams.RecorderParam recorderParam, int i3, String str, String str2) {
        this.f180157e = str2;
        this.f180154b = bVar;
        this.f180158f = str;
        this.f180155c = pVar;
        this.f180156d = recorderParam;
        this.f180159g = i3;
        this.f180162j.e(this.f180160h.s());
        this.f180163k.e(this.f180160h.s());
        this.f180165m.p(str, this.f180153a, this, pVar.f179555d, pVar.f179557e);
    }

    public void m() {
        this.f180162j.f(this.f180160h);
        this.f180163k.f(this.f180160h);
    }

    public void n(String str) {
        if (StringUtil.isEmpty(str)) {
            x(false);
        } else {
            x(true);
        }
        this.f180162j.n();
    }

    public void o() {
        this.f180162j.g();
        this.f180163k.g();
        this.f180161i.removeCallbacks(null);
        this.f180165m.u(null);
        this.f180165m.r();
    }

    public void p() {
        this.f180163k.o();
    }

    public void q() {
        INetInfoHandler iNetInfoHandler = this.f180166n;
        if (iNetInfoHandler != null) {
            AppNetConnInfo.unregisterNetInfoHandler(iNetInfoHandler);
            this.f180166n = null;
        }
        Handler handler = this.f180161i;
        if (handler != null) {
            handler.removeCallbacks(null);
        }
        j();
        this.f180163k.r();
    }

    public void t() {
        j();
        this.f180163k.p();
        this.f180162j.t();
    }

    public void u() {
        if (this.f180158f == null) {
            return;
        }
        if (!NetworkUtil.isNetworkAvailable(this.f180160h.getContext())) {
            r();
            return;
        }
        ((IVoice2TxtTmpApi) QRoute.api(IVoice2TxtTmpApi.class)).setIsInVoiceTxt(true);
        e71.a.a("0X800A1D7", 0, 0);
        AppNetConnInfo.registerConnectionChangeReceiver(this.f180160h.getContext(), this.f180166n);
        this.f180164l.c().g(1);
        this.f180165m.m(this.f180157e);
        this.f180163k.n();
    }

    public void v() {
        int i3;
        if (this.f180164l.d().d() && this.f180164l.d().c()) {
            k();
            if (this.f180164l.c().c()) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            ((IVoice2TxtTmpApi) QRoute.api(IVoice2TxtTmpApi.class)).sendVoiceAndTxt(this.f180154b, this.f180157e, 5, this.f180159g, this.f180156d, 0, false, i3);
            e71.a.a("0X800A1DA", 1, 0);
            return;
        }
        ((IVoice2TxtTmpApi) QRoute.api(IVoice2TxtTmpApi.class)).sendTxt(this.f180154b, this.f180153a, this.f180155c, this.f180164l.a(), this.f180160h.getContext());
        s();
    }

    public void w() {
        this.f180162j.v();
        this.f180163k.j().setFocusableInTouchMode(true);
    }
}
