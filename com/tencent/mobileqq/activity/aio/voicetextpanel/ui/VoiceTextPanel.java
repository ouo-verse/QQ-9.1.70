package com.tencent.mobileqq.activity.aio.voicetextpanel.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.activity.aio.voicetextpanel.controller.VoiceTextSttProcessController;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.c;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.d;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.e;
import com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView;
import com.tencent.mobileqq.ptt.temp.api.IVoice2TxtTmpApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import mqq.app.AppRuntime;

/* loaded from: classes10.dex */
public class VoiceTextPanel extends BaseVoicetoTextView {
    private d C;
    private com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.b D;
    private e E;
    private c F;
    private c71.a G;
    private b H;
    private int I;
    private boolean J;
    private boolean K;

    /* renamed from: d, reason: collision with root package name */
    private a61.b f180199d;

    /* renamed from: e, reason: collision with root package name */
    private p f180200e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f180201f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f180202h;

    /* renamed from: i, reason: collision with root package name */
    private d71.c f180203i;

    /* renamed from: m, reason: collision with root package name */
    private VoiceTextSttProcessController f180204m;

    /* loaded from: classes10.dex */
    public class a implements c71.a {
        public a() {
        }

        @Override // c71.a
        public void a() {
            if (QLog.isColorLevel()) {
                QLog.d("VoiceTextPanel", 2, "scrollListener [onHideSoftInput]");
            }
            ((IVoice2TxtTmpApi) QRoute.api(IVoice2TxtTmpApi.class)).hideSoftInput(VoiceTextPanel.this.f180199d);
            VoiceTextPanel.this.w(false);
        }

        @Override // c71.a
        public void b(int i3, int i16) {
            if (QLog.isColorLevel()) {
                QLog.d("VoiceTextPanel", 2, "scrollListener [onEnterEditState] endHeight: " + i3 + ", panelLastTop: " + i16);
            }
            VoiceTextPanel.this.D.a();
            VoiceTextPanel.this.C.a(i3, i16, VoiceTextPanel.this.getHeight(), VoiceTextPanel.this.getTop());
            VoiceTextPanel.this.f180199d.c().f(1, true);
        }

        @Override // c71.a
        public void c() {
            VoiceTextPanel.this.C.l(false);
            VoiceTextPanel.this.f180202h = false;
            if (!VoiceTextPanel.this.J) {
                VoiceTextPanel.this.w(false);
            }
        }

        @Override // c71.a
        public void d(int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("VoiceTextPanel", 2, "scrollListener [onActionDown] screenHeight: " + i3);
            }
            if (VoiceTextPanel.this.C.c() == 0) {
                VoiceTextPanel.this.f180202h = true;
                QLog.d("VoiceTextPanel", 1, "measure [onActionDown]");
                VoiceTextPanel voiceTextPanel = VoiceTextPanel.this;
                voiceTextPanel.measure(View.MeasureSpec.makeMeasureSpec(voiceTextPanel.getRight() - VoiceTextPanel.this.getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(i3 - VoiceTextPanel.this.getTop(), 1073741824));
                VoiceTextPanel voiceTextPanel2 = VoiceTextPanel.this;
                voiceTextPanel2.layout(voiceTextPanel2.getLeft(), VoiceTextPanel.this.getTop(), VoiceTextPanel.this.getRight(), i3);
                VoiceTextPanel.this.C.g(VoiceTextPanel.this.getLeft(), VoiceTextPanel.this.getTop(), VoiceTextPanel.this.getRight(), VoiceTextPanel.this.getBottom(), i3);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("VoiceTextPanel", 2, "onActionDown but mHeader cannot see");
            }
        }

        @Override // c71.a
        public void e(int i3, int i16, int i17) {
            if (QLog.isColorLevel()) {
                QLog.d("VoiceTextPanel", 2, "scrollListener [onExitEditState]");
            }
            VoiceTextPanel.this.C.b(i3, i16, i17);
            VoiceTextPanel.this.D.e();
            VoiceTextPanel.this.K = false;
        }

        @Override // c71.a
        public int f() {
            return XPanelContainer.f384714h0;
        }

        @Override // c71.a
        public void g() {
            VoiceTextPanel.this.C.l(true);
            VoiceTextPanel.this.f180202h = false;
            VoiceTextPanel.this.f180204m.p();
        }
    }

    /* loaded from: classes10.dex */
    public class b implements c71.c {
        public b() {
        }

        @Override // c71.c
        public void a() {
            if (QLog.isColorLevel()) {
                QLog.d("VoiceTextPanel", 2, "opListener [onSend]");
            }
            ((IVoice2TxtTmpApi) QRoute.api(IVoice2TxtTmpApi.class)).setCustomTitleVisiable(VoiceTextPanel.this.f180199d, 0);
            VoiceTextPanel.this.f180204m.v();
            if (!VoiceTextPanel.this.f180203i.d().a()) {
                VoiceTextPanel.this.f180199d.c().f(2, false);
            } else {
                VoiceTextPanel.this.F.e(2);
                VoiceTextPanel.this.f180199d.c().c(true);
            }
            VoiceTextPanel.this.v();
        }

        @Override // c71.c
        public void b(String str) {
            if (QLog.isColorLevel()) {
                QLog.d("VoiceTextPanel", 2, "opListener [onAfterEditText]");
            }
            VoiceTextPanel.this.f180204m.n(str);
            VoiceTextPanel.this.f180203i.d().f(true);
            VoiceTextPanel.this.E.a();
            VoiceTextPanel.this.y();
        }

        @Override // c71.c
        public void onCancel() {
            if (QLog.isColorLevel()) {
                QLog.d("VoiceTextPanel", 2, "opListener [onCancel]");
            }
            ((IVoice2TxtTmpApi) QRoute.api(IVoice2TxtTmpApi.class)).setCustomTitleVisiable(VoiceTextPanel.this.f180199d, 0);
            if (!VoiceTextPanel.this.f180203i.d().a()) {
                VoiceTextPanel.this.f180199d.c().f(2, false);
                VoiceTextPanel.this.f180204m.j();
                e71.a.a("0X800A1DB", 1, 0);
            } else {
                VoiceTextPanel.this.F.e(1);
                VoiceTextPanel.this.f180199d.c().c(true);
                e71.a.a("0X800A1DB", 2, 0);
            }
            VoiceTextPanel.this.v();
        }
    }

    public VoiceTextPanel(Context context) {
        super(context);
        this.f180201f = true;
        this.f180202h = false;
        this.K = true;
    }

    private void t() {
        this.f180204m.m();
        this.E.c(this);
        this.D.b(this);
        this.C.f(this);
    }

    private boolean u(int i3) {
        boolean z16;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_voice_text_panel_check_layout_switch_8985", true) && !this.K) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.K = true;
            return false;
        }
        if (this.C.d() > 0 && (this.C.d() + getTop()) - i3 < ScreenUtil.dip2px(2.0f)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        this.f180204m.q();
        this.E.d();
        this.C.h();
        this.f180204m.o();
        ((IVoice2TxtTmpApi) QRoute.api(IVoice2TxtTmpApi.class)).restoreChatPieOtherFunction(this.f180199d);
        ((IVoice2TxtTmpApi) QRoute.api(IVoice2TxtTmpApi.class)).setIsInVoiceTxt(false);
        this.f180201f = true;
    }

    private void x() {
        this.f180204m.t();
        this.f180203i.e();
        this.E.f();
        this.F.d();
        this.C.k();
        this.D.c();
        this.f180201f = false;
    }

    @Override // com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView
    public void a(AppRuntime appRuntime, a61.b bVar, p pVar, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.f180200e = pVar;
        this.f180199d = bVar;
        this.G = new a();
        this.H = new b();
        d71.c cVar = new d71.c();
        this.f180203i = cVar;
        this.f180204m = new VoiceTextSttProcessController(cVar, appRuntime, this);
        this.E = new e();
        this.D = new com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.b();
        this.C = new d();
        this.F = new c();
        t();
        this.F.b(viewGroup2, this, viewGroup, this.f180199d);
    }

    @Override // com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView
    public void b() {
        v();
    }

    @Override // com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView
    public void c() {
        this.E.e();
    }

    @Override // com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView
    public void d(int i3, int i16, int i17, int i18, boolean z16) {
        w(z16);
        if (!this.f180202h) {
            int customTitleViewBottom = ((IVoice2TxtTmpApi) QRoute.api(IVoice2TxtTmpApi.class)).getCustomTitleViewBottom(this.f180199d);
            if (i16 != 0) {
                this.C.m(i18);
            } else {
                i16 += customTitleViewBottom;
            }
            if (i16 > customTitleViewBottom) {
                getTop();
            }
            if (getTop() == i16 && i18 == getBottom() && z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("VoiceTextPanel", 2, "onXContainerLayout edit state need no layout");
                }
            } else if (u(i16)) {
                if (QLog.isColorLevel()) {
                    QLog.d("VoiceTextPanel", 2, "onXContainerLayout normal state need no layout");
                }
            } else {
                measure(View.MeasureSpec.makeMeasureSpec(i17 - i3, 1073741824), View.MeasureSpec.makeMeasureSpec(i18 - i16, 1073741824));
                layout(i3, i16, i17, i18);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView
    public void e() {
        this.F.c();
        if (this.F.a() != 0) {
            this.f180204m.j();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView
    public boolean f() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_voice2text_panel_switch_9015", false);
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        if (QLog.isColorLevel()) {
            QLog.e("VoiceTextPanel", 2, "onSizeChanged h=" + i16 + ", oldH=" + i18);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) getLayoutParams();
        layoutParams.bottomMargin = i16;
        setLayoutParams(layoutParams);
    }

    public c71.a r() {
        return this.G;
    }

    public c71.c s() {
        return this.H;
    }

    @Override // com.tencent.mobileqq.activity.aio.voicetextpanel.view.BaseVoicetoTextView
    public void setParam(String str, RecordParams.RecorderParam recorderParam, int i3, String str2) {
        this.E.b(str, recorderParam, i3, this);
        this.f180204m.l(this.f180199d, this.f180200e, recorderParam, i3, str2, str);
        IVoice2TxtTmpApi iVoice2TxtTmpApi = (IVoice2TxtTmpApi) QRoute.api(IVoice2TxtTmpApi.class);
        this.C.e();
        this.C.n(iVoice2TxtTmpApi.getAudioPanelContainerEditStateDeltaHeight(this.f180199d));
        x();
        iVoice2TxtTmpApi.hideChatPieOtherFunction(this.f180199d);
        this.f180204m.u();
    }

    public void w(boolean z16) {
        boolean z17;
        if (this.J != z16) {
            this.J = z16;
            if (z16) {
                this.I = XPanelContainer.f384714h0;
            } else {
                int i3 = this.I;
                if (i3 > 0) {
                    XPanelContainer.f384714h0 = i3;
                }
            }
            z17 = true;
        } else {
            z17 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.e("VoiceTextPanel", 2, "onSoftInputShowing change= " + z17 + " isShow= " + z16 + " isDrag= " + this.f180202h + " mOriginExternalPanelHeight= " + this.I);
        }
        this.f180203i.d().e(z16);
        if (z16) {
            e71.a.a("0X800A1DC", 0, 0);
            this.C.j();
            this.D.a();
        } else {
            if (!this.f180202h) {
                this.D.e();
            }
            this.C.i();
        }
    }

    public void y() {
        measure(View.MeasureSpec.makeMeasureSpec(getRight() - getLeft(), 1073741824), View.MeasureSpec.makeMeasureSpec(getBottom() - getTop(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    public VoiceTextPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f180201f = true;
        this.f180202h = false;
        this.K = true;
    }

    public VoiceTextPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f180201f = true;
        this.f180202h = false;
        this.K = true;
    }
}
