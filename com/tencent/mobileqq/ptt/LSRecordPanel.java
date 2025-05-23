package com.tencent.mobileqq.ptt;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateSquareView;
import com.tencent.mobileqq.activity.aio.item.n;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.ptt.TouchProxyRelativeLayout;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.pttlogic.api.IPttBuffer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.QQAudioUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.TransFileUtil;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.cm;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import com.tencent.util.WeakReferenceHandler;
import java.io.File;

/* loaded from: classes16.dex */
public final class LSRecordPanel extends RelativeLayout implements TouchProxyRelativeLayout.a, com.tencent.mobileqq.activity.aio.audiopanel.c, d.a, Handler.Callback {
    static IPatchRedirector $redirector_;
    private int C;
    private long D;
    private View E;
    private View F;
    private View G;
    private boolean H;
    private VolumeIndicateSquareView I;
    private LSRecordTextView J;
    private Rect K;
    private View L;
    private TouchProxyRelativeLayout M;
    private Rect N;
    private Point P;
    private volatile int Q;
    private Rect R;
    private com.tencent.mobileqq.ptt.d S;
    private volatile boolean T;
    private String U;
    private boolean V;
    public Animation W;

    /* renamed from: a0, reason: collision with root package name */
    public h f261186a0;

    /* renamed from: b0, reason: collision with root package name */
    public Animation f261187b0;

    /* renamed from: c0, reason: collision with root package name */
    public Animation f261188c0;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f261189d;

    /* renamed from: d0, reason: collision with root package name */
    public Animation f261190d0;

    /* renamed from: e, reason: collision with root package name */
    private f f261191e;

    /* renamed from: e0, reason: collision with root package name */
    public h f261192e0;

    /* renamed from: f, reason: collision with root package name */
    private SessionInfo f261193f;

    /* renamed from: h, reason: collision with root package name */
    private Handler f261194h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f261195i;

    /* renamed from: m, reason: collision with root package name */
    private String f261196m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class a extends g {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LSRecordPanel.this);
            }
        }

        @Override // com.tencent.mobileqq.ptt.g, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("LsRecord", 4, "LS startRecordingBarAnimation onAnimationEnd");
            }
            LSRecordPanel.this.f261188c0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LSRecordPanel.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class c extends g {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LSRecordPanel.this);
            }
        }

        @Override // com.tencent.mobileqq.ptt.g
        public void a(Animation animation, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, animation, Float.valueOf(f16));
                return;
            }
            LSRecordPanel lSRecordPanel = LSRecordPanel.this;
            if (lSRecordPanel.f261188c0 == null && lSRecordPanel.W != null && f16 >= 0.5f) {
                lSRecordPanel.G();
            }
        }

        @Override // com.tencent.mobileqq.ptt.g, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("LsRecord", 4, "LS startExpandAnimation onAnimationEnd");
            }
            LSRecordPanel lSRecordPanel = LSRecordPanel.this;
            if (animation == lSRecordPanel.W) {
                lSRecordPanel.F();
            }
            LSRecordPanel.this.W = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class d extends g {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LSRecordPanel.this);
            }
        }

        @Override // com.tencent.mobileqq.ptt.g, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("LsRecord", 4, "LS startSideAnimation onAnimationEnd");
            }
            LSRecordPanel.this.f261192e0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public class e extends g {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LSRecordPanel.this);
            }
        }

        @Override // com.tencent.mobileqq.ptt.g, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) animation);
                return;
            }
            if (QLog.isDevelopLevel()) {
                QLog.d("LsRecord", 4, "LS startCloseAnimation onAnimationEnd");
            }
            if (LSRecordPanel.this.H) {
                LSRecordPanel lSRecordPanel = LSRecordPanel.this;
                if (animation == lSRecordPanel.f261187b0) {
                    lSRecordPanel.K();
                }
                LSRecordPanel lSRecordPanel2 = LSRecordPanel.this;
                lSRecordPanel2.f261186a0 = null;
                lSRecordPanel2.f261187b0 = null;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) lSRecordPanel2.G.getLayoutParams();
                int i3 = (int) (LSRecordPanel.this.getResources().getDisplayMetrics().density * 4.0f);
                layoutParams.height -= i3;
                layoutParams.width -= i3;
                layoutParams.rightMargin += i3 / 2;
                LSRecordPanel.this.H = false;
                LSRecordPanel.this.G.setLayoutParams(layoutParams);
            }
        }
    }

    /* loaded from: classes16.dex */
    public interface f {
        void T1(boolean z16, boolean z17, LSRecordPanel lSRecordPanel);

        void a1();

        void d0(boolean z16, int i3, String str, boolean z17, boolean z18);

        void d2();
    }

    public LSRecordPanel(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f261193f = new SessionInfo();
        this.D = 0L;
        this.K = new Rect();
        this.N = new Rect();
        this.P = new Point();
        this.R = new Rect();
        this.V = true;
    }

    private void A(RecordParams.RecorderParam recorderParam) {
        MessageRecord K = ChatActivityFacade.K(this.f261189d, this.f261196m, this.f261193f, -2, recorderParam.f307257f);
        if (K == null) {
            return;
        }
        ((MessageForPtt) K).c2cViaOffline = true;
        long j3 = K.uniseq;
        Bundle bundle = new Bundle();
        bundle.putInt("DiyTextId", K.vipBubbleDiyTextId);
        QQAppInterface qQAppInterface = this.f261189d;
        SessionInfo sessionInfo = this.f261193f;
        ChatActivityFacade.b1(qQAppInterface, sessionInfo.f179555d, sessionInfo.f179557e, this.f261196m, j3, false, this.C, recorderParam.f307257f, true, 0, 3, true, K.vipSubBubbleId, bundle);
        this.f261196m = null;
        cm.c(this.f261189d, this.f261193f.f179555d, 8, this.C);
    }

    private void B(int i3) {
        if (i3 == this.Q) {
            return;
        }
        this.Q = i3;
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS setMode: " + this.Q);
        }
    }

    private void E() {
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS startCheckingClick");
        }
        B(1);
        this.f261194h.sendEmptyMessageDelayed(101, 250L);
        f fVar = this.f261191e;
        if (fVar != null) {
            fVar.T1(false, false, this);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
        int i3 = (int) (getResources().getDisplayMetrics().density * 4.0f);
        layoutParams.height += i3;
        layoutParams.width += i3;
        layoutParams.rightMargin -= i3 / 2;
        this.H = true;
        this.G.setLayoutParams(layoutParams);
    }

    private void I(boolean z16) {
        int i3;
        int i16 = -43434;
        if (z16) {
            i3 = -15550475;
        } else {
            i3 = -43434;
        }
        if (!z16) {
            i16 = -15550475;
        }
        h hVar = this.f261192e0;
        if (hVar != null) {
            i16 = hVar.f261238b;
        } else {
            h hVar2 = new h();
            this.f261192e0 = hVar2;
            hVar2.f261238b = i16;
        }
        com.tencent.mobileqq.ptt.f fVar = new com.tencent.mobileqq.ptt.f(this.F, i16, i3, this.f261192e0);
        fVar.setInterpolator(new AccelerateDecelerateInterpolator());
        fVar.setDuration(300L);
        fVar.setFillAfter(true);
        fVar.setAnimationListener(new d());
        this.F.startAnimation(fVar);
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS startSideAnimation");
        }
    }

    private void J(boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS stopCheckingChick:" + z16);
        }
        if (!z16) {
            if (this.H) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
                int i3 = (int) (getResources().getDisplayMetrics().density * 4.0f);
                layoutParams.height -= i3;
                layoutParams.width -= i3;
                layoutParams.rightMargin += i3 / 2;
                this.H = false;
                this.G.setLayoutParams(layoutParams);
            }
            this.f261194h.removeMessages(101);
            B(0);
            f fVar = this.f261191e;
            if (fVar != null) {
                fVar.d0(false, -1, HardCodeUtil.qqStr(R.string.nwn), true, false);
                return;
            }
            return;
        }
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS stopRecord");
        }
        com.tencent.mobileqq.ptt.d dVar = this.S;
        boolean z16 = false;
        if (dVar != null && !dVar.a() && !this.f261194h.hasMessages(16711686)) {
            this.f261194h.removeMessages(16711688);
            this.f261194h.removeMessages(16711686);
            this.f261194h.removeMessages(16711687);
            if (QLog.isDevelopLevel()) {
                QLog.d("LsRecord", 4, "stopRecord() is called,time is:" + System.currentTimeMillis());
            }
            boolean stop = this.S.stop();
            z(R.raw.f169427y);
            QQAudioUtils.i(BaseApplicationImpl.sApplication, false);
            z16 = stop;
        }
        if (!z16 || !this.V) {
            y(true);
        }
    }

    private void o() {
        if (this.f261196m != null) {
            ((IPttBuffer) QRoute.api(IPttBuffer.class)).cancelBufferTask(this.f261196m);
            this.f261196m = null;
            cm.b(this.f261189d, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z16) {
        q(z16, false);
    }

    private void q(boolean z16, boolean z17) {
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS close: " + this.Q + " done:" + z16);
        }
        this.f261194h.removeMessages(101);
        if (this.Q != 0) {
            if (z17 || this.Q != 5) {
                this.T = z16;
                if (this.Q == 1) {
                    J(false);
                    return;
                }
                if (z17) {
                    if (this.H) {
                        B(5);
                        this.G.clearAnimation();
                        this.G.setVisibility(0);
                        this.F.setAnimation(null);
                        this.F.setVisibility(4);
                        ((GradientDrawable) this.G.getBackground()).setColor(-15550475);
                        this.W = null;
                        L();
                        K();
                        this.f261186a0 = null;
                        this.f261187b0 = null;
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.G.getLayoutParams();
                        int i3 = (int) (getResources().getDisplayMetrics().density * 4.0f);
                        layoutParams.height -= i3;
                        layoutParams.width -= i3;
                        layoutParams.rightMargin += i3 / 2;
                        this.H = false;
                        this.G.setLayoutParams(layoutParams);
                        s();
                        return;
                    }
                    return;
                }
                if (this.f261186a0 != null) {
                    B(5);
                    this.G.setVisibility(0);
                    this.F.setAnimation(null);
                    this.F.setVisibility(4);
                    GradientDrawable gradientDrawable = (GradientDrawable) this.G.getBackground();
                    int i16 = this.f261186a0.f261238b;
                    gradientDrawable.setColor(i16);
                    float f16 = this.f261186a0.f261237a;
                    this.W = null;
                    L();
                    com.tencent.mobileqq.ptt.e eVar = new com.tencent.mobileqq.ptt.e(f16, 1.0f, f16, 1.0f, 1, 0.5f, 1, 0.5f, this.f261186a0);
                    eVar.a(gradientDrawable, i16, -15550475);
                    eVar.setInterpolator(new LinearInterpolator());
                    eVar.setDuration(500L);
                    eVar.setFillAfter(true);
                    eVar.setAnimationListener(new e());
                    this.f261187b0 = eVar;
                    this.G.startAnimation(eVar);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("LsRecord", 4, "LS startCloseAnimation");
                    }
                    s();
                    return;
                }
                y(false);
            }
        }
    }

    private RecordParams.RecorderParam r() {
        int i3 = this.f261193f.f179555d;
        if (i3 != 0 && i3 != 3000) {
            return new RecordParams.RecorderParam(RecordParams.f307250a, 8000, 0);
        }
        return RecordParams.c(this.f261189d, false);
    }

    private void t() {
        float f16;
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS expand");
        }
        B(2);
        h hVar = this.f261186a0;
        if (hVar == null) {
            getGlobalVisibleRect(this.R);
            this.G.getGlobalVisibleRect(new Rect());
            float width = r0.width() * 0.5f;
            Rect rect = this.R;
            float f17 = (r0.left + width) - rect.left;
            float f18 = (r0.top + width) - rect.top;
            float sqrt = (float) Math.sqrt((f17 * f17) + (f18 * f18));
            if (QLog.isDevelopLevel()) {
                QLog.d("LsRecord", 4, "LS init dest bgTrack: " + f17 + ", " + sqrt);
            }
            f16 = sqrt / width;
            h hVar2 = new h();
            this.f261186a0 = hVar2;
            hVar2.f261237a = 1.0f;
        } else {
            f16 = hVar.f261237a;
        }
        float f19 = f16;
        this.f261187b0 = null;
        com.tencent.mobileqq.ptt.e eVar = new com.tencent.mobileqq.ptt.e(1.0f, f19, 1.0f, f19, 1, 0.5f, 1, 0.5f, this.f261186a0);
        eVar.setInterpolator(new LinearInterpolator());
        eVar.setDuration(450L);
        eVar.setFillAfter(true);
        eVar.setAnimationListener(new c());
        this.W = eVar;
        this.G.startAnimation(eVar);
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS startExpandAnimation");
        }
        H();
    }

    private void w() {
        this.Q = 0;
        View findViewById = super.findViewById(R.id.kwq);
        this.E = findViewById;
        findViewById.setVisibility(4);
        View findViewById2 = super.findViewById(R.id.kwp);
        this.F = findViewById2;
        findViewById2.setVisibility(4);
        this.G = super.findViewById(R.id.kwr);
        if (AppSetting.f99565y) {
            super.setContentDescription(null);
            this.E.setContentDescription(null);
            this.F.setContentDescription(null);
            this.G.setContentDescription(HardCodeUtil.qqStr(R.string.nwm));
        }
        this.J = (LSRecordTextView) super.findViewById(R.id.izm);
        this.I = (VolumeIndicateSquareView) super.findViewById(R.id.djm);
        this.J.setNotLayoutInSettingText(true);
        this.J.setVisibility(4);
        this.I.setVisibility(4);
        if (((int) (r0.widthPixels / getResources().getDisplayMetrics().density)) >= 320) {
            this.I.setCount(30);
        }
        this.J.setText("-:--");
        View findViewById3 = super.findViewById(R.id.i3p);
        this.L = findViewById3;
        findViewById3.setOnClickListener(new b());
        this.L.setContentDescription(HardCodeUtil.qqStr(R.string.nwj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z16) {
        this.J.setText("-:--");
        this.I.b();
        B(0);
        f fVar = this.f261191e;
        if (fVar != null) {
            fVar.d0(this.T, -1, this.U, false, z16);
        }
        this.U = null;
        this.T = false;
    }

    private void z(int i3) {
        AudioUtil.n(i3, false);
    }

    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        if (this.Q != 5 && this.Q != 0) {
            if (QLog.isDevelopLevel()) {
                QLog.d("LsRecord", 4, "LS startRecord");
            }
            f fVar = this.f261191e;
            if (fVar != null) {
                fVar.T1(true, false, this);
            }
            this.G.setAnimation(null);
            this.G.setVisibility(4);
            if (this.Q == 4) {
                this.F.setBackgroundColor(-43434);
            } else {
                this.F.setBackgroundColor(-15616011);
            }
            this.F.setVisibility(0);
            B(3);
            RecordParams.RecorderParam r16 = r();
            if (!FileUtils.hasSDCardAndWritable()) {
                this.U = getResources().getString(R.string.ck7);
            } else if (!((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).checkExternalStorageForRecord()) {
                this.U = getResources().getString(R.string.h_0);
            } else if (!((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).checkIntenalStorageForRecord(r16.f307257f)) {
                this.U = getResources().getString(R.string.by8);
            } else if (this.f261189d.isVideoChatting()) {
                this.U = getResources().getString(R.string.f171206d52);
            } else if (AudioUtil.h(1)) {
                this.U = getResources().getString(R.string.f6o);
            } else {
                this.U = null;
            }
            if (this.U != null) {
                p(false);
                return;
            }
            if (this.S == null) {
                this.S = ((IQQRecorderUtils) QRoute.api(IQQRecorderUtils.class)).createQQRecorder(BaseApplicationImpl.sApplication);
            }
            this.S.e(r16);
            String transferFilePath = TransFileUtil.getTransferFilePath(this.f261189d.getCurrentAccountUin(), null, 2, null, false);
            String localFilePath = MessageForPtt.getLocalFilePath(r16.f307257f, transferFilePath);
            if (transferFilePath != null && !transferFilePath.equals(localFilePath)) {
                new File(transferFilePath).deleteOnExit();
                transferFilePath = localFilePath;
            }
            if (QLog.isColorLevel()) {
                QLog.i("QQRecorder", 2, "path: " + transferFilePath);
            }
            this.S.b(this);
            QQAudioUtils.i(BaseApplicationImpl.sApplication, true);
            if (QLog.isColorLevel()) {
                QLog.d("LsRecord", 2, "QQRecorder start() is called,time is:" + System.currentTimeMillis());
            }
            this.J.setText("-:--");
            this.I.b();
            this.S.c(transferFilePath, true);
        }
    }

    public void G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS startRecordingBarAnimation");
        }
        this.f261190d0 = null;
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(200L);
        this.I.setVisibility(0);
        this.I.startAnimation(alphaAnimation);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
        this.f261188c0 = alphaAnimation2;
        alphaAnimation2.setDuration(200L);
        this.f261188c0.setFillAfter(true);
        this.f261188c0.setAnimationListener(new a());
        this.J.setVisibility(0);
        this.J.startAnimation(this.f261188c0);
    }

    public void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS startRecordingMark");
        }
        this.E.setBackgroundColor(-16777216);
        this.E.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.6f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(300L);
        this.E.startAnimation(alphaAnimation);
        f fVar = this.f261191e;
        if (fVar != null) {
            fVar.d2();
        }
    }

    public void L() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.I.getVisibility() != 0) {
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS stopRecordingBarAnimation");
        }
        this.f261188c0 = null;
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(200L);
        this.I.startAnimation(alphaAnimation);
        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.0f);
        this.f261190d0 = alphaAnimation2;
        alphaAnimation2.setDuration(200L);
        this.f261190d0.setFillAfter(true);
        this.f261190d0.setAnimationListener(new g() { // from class: com.tencent.mobileqq.ptt.LSRecordPanel.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LSRecordPanel.this);
                }
            }

            @Override // com.tencent.mobileqq.ptt.g, android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) animation);
                    return;
                }
                if (QLog.isDevelopLevel()) {
                    QLog.d("LsRecord", 4, "LS stopRecordingBarAnimation onAnimationEnd");
                }
                LSRecordPanel.this.f261194h.post(new Runnable() { // from class: com.tencent.mobileqq.ptt.LSRecordPanel.2.1
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
                        LSRecordPanel lSRecordPanel = LSRecordPanel.this;
                        lSRecordPanel.f261190d0 = null;
                        lSRecordPanel.J.setVisibility(4);
                        LSRecordPanel.this.I.setVisibility(4);
                    }
                });
            }
        });
        this.J.startAnimation(this.f261190d0);
    }

    public void M(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, str, Integer.valueOf(i3), str2);
            return;
        }
        SessionInfo sessionInfo = this.f261193f;
        sessionInfo.f179555d = i3;
        sessionInfo.f179557e = str;
        sessionInfo.f179559f = str2;
    }

    @Override // com.tencent.mobileqq.ptt.TouchProxyRelativeLayout.a
    public boolean a(MotionEvent motionEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (getVisibility() != 0) {
            return false;
        }
        this.M.getGlobalVisibleRect(this.N, this.P);
        this.L.getGlobalVisibleRect(this.K);
        Rect rect = this.K;
        int i3 = rect.right;
        int i16 = rect.left;
        int i17 = i3 - i16;
        Point point = this.P;
        int i18 = i16 - point.x;
        rect.left = i18;
        rect.right = i18 + i17;
        int i19 = rect.bottom;
        int i26 = rect.top;
        int i27 = i19 - i26;
        int i28 = i26 - point.y;
        rect.top = i28;
        rect.bottom = i28 + i27;
        int x16 = (int) motionEvent.getX();
        int y16 = (int) motionEvent.getY();
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS agent:" + motionEvent + "\n container: " + this.N + "\n bg: " + this.K);
        }
        if (this.Q == 0) {
            if (motionEvent.getAction() != 0 || !this.K.contains(x16, y16)) {
                return false;
            }
            this.C = 0;
            E();
        } else if (this.Q != 5) {
            if (this.Q == 1) {
                if (motionEvent.getAction() != 2) {
                    J(false);
                }
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z17 = z16;
            if (!z16) {
                if (motionEvent.getAction() == 3) {
                    p(false);
                } else if (motionEvent.getAction() == 1) {
                    if (QLog.isDevelopLevel()) {
                        QLog.d("LsRecord", 4, "LS ACTION_UP: " + this.Q);
                    }
                    if (this.Q != 3 && this.Q != 2) {
                        if (this.Q == 4) {
                            p(false);
                        }
                    } else if (this.C >= 500) {
                        p(true);
                    } else {
                        this.U = HardCodeUtil.qqStr(R.string.nwl);
                        p(false);
                    }
                } else if (motionEvent.getAction() == 2) {
                    super.getGlobalVisibleRect(this.R);
                    Rect rect2 = this.R;
                    int i29 = rect2.right;
                    int i36 = rect2.left;
                    int i37 = i29 - i36;
                    Point point2 = this.P;
                    int i38 = i36 - point2.x;
                    rect2.left = i38;
                    rect2.right = i38 + i37;
                    int i39 = rect2.bottom;
                    int i46 = rect2.top;
                    int i47 = i39 - i46;
                    int i48 = i46 - point2.y;
                    rect2.top = i48;
                    rect2.bottom = i48 + i47;
                    if (rect2.contains(x16, y16)) {
                        if (this.Q == 4) {
                            I(true);
                        }
                        if (this.Q != 3) {
                            B(3);
                            f fVar = this.f261191e;
                            if (fVar != null) {
                                fVar.T1(true, false, this);
                            }
                        }
                    } else {
                        if (this.Q == 3) {
                            I(false);
                        }
                        if (this.Q != 4) {
                            B(4);
                            f fVar2 = this.f261191e;
                            if (fVar2 != null) {
                                fVar2.T1(false, true, this);
                            }
                        }
                    }
                }
            } else {
                return z17;
            }
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Boolean) iPatchRedirector.redirect((short) 32, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 101) {
            switch (i3) {
                case 16711686:
                    if (QLog.isColorLevel()) {
                        QLog.d("QQRecorder", 2, "QQRecorder stop() is called,time is:" + System.currentTimeMillis());
                    }
                    this.S.stop();
                    z(R.raw.f169427y);
                    QQAudioUtils.i(BaseApplicationImpl.sApplication, false);
                    break;
                case 16711687:
                    p(true);
                    break;
            }
        } else {
            J(true);
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Boolean) iPatchRedirector.redirect((short) 30, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onBeginReceiveData(String str, RecordParams.RecorderParam recorderParam) {
        int c16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Integer) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str, (Object) recorderParam)).intValue();
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS onBeginReceiveData");
        }
        int c17 = n.c(this.f261189d, "Normal_MaxPtt") * 1000;
        int privilegeFlags = VasUtil.getSignedService(this.f261189d).getVipStatus().getPrivilegeFlags(null);
        if ((privilegeFlags & 4) != 0) {
            c16 = n.c(this.f261189d, "SVIP_MaxPtt");
        } else {
            if ((privilegeFlags & 2) != 0) {
                c16 = n.c(this.f261189d, "VIP_MaxPtt");
            }
            int i3 = c17 - 200;
            this.f261194h.sendEmptyMessageDelayed(16711687, i3);
            return i3 + 200;
        }
        c17 = c16 * 1000;
        int i36 = c17 - 200;
        this.f261194h.sendEmptyMessageDelayed(16711687, i36);
        return i36 + 200;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            super.onFinishInflate();
            w();
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitFailed(String str, RecordParams.RecorderParam recorderParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, (Object) str, (Object) recorderParam);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS onInitFailed");
        }
        o();
        this.f261194h.post(new Runnable() { // from class: com.tencent.mobileqq.ptt.LSRecordPanel.11
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LSRecordPanel.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    LSRecordPanel.this.V = false;
                    LSRecordPanel.this.U = HardCodeUtil.qqStr(R.string.nwh);
                    LSRecordPanel.this.p(false);
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitSuccess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS onInitSuccess");
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        super.onLayout(z16, i3, i16, i17, i18);
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS onLayout: " + z16);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            q(false, true);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderAbnormal(String str, RecordParams.RecorderParam recorderParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) str, (Object) recorderParam);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS onRecorderAbnormal");
        }
        o();
        this.f261194h.post(new Runnable() { // from class: com.tencent.mobileqq.ptt.LSRecordPanel.12
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LSRecordPanel.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    LSRecordPanel.this.V = false;
                    LSRecordPanel.this.U = HardCodeUtil.qqStr(R.string.nwo);
                    LSRecordPanel.this.p(false);
                    return;
                }
                iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderEnd(String str, RecordParams.RecorderParam recorderParam, double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, this, str, recorderParam, Double.valueOf(d16));
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS onRecorderEnd");
        }
        this.f261194h.removeMessages(1);
        if (this.T) {
            if (this.C < 500) {
                this.T = false;
                this.U = HardCodeUtil.qqStr(R.string.nwk);
                o();
            } else {
                A(recorderParam);
            }
        } else {
            o();
        }
        this.f261194h.post(new Runnable() { // from class: com.tencent.mobileqq.ptt.LSRecordPanel.9
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LSRecordPanel.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    LSRecordPanel.this.y(false);
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderError(String str, RecordParams.RecorderParam recorderParam, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, this, str, recorderParam, str2);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS onRecorderError");
        }
        o();
        this.f261194h.post(new Runnable() { // from class: com.tencent.mobileqq.ptt.LSRecordPanel.10
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LSRecordPanel.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                LSRecordPanel.this.U = HardCodeUtil.qqStr(R.string.nwi);
                LSRecordPanel.this.p(false);
            }
        });
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderPrepare(String str, RecordParams.RecorderParam recorderParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) str, (Object) recorderParam);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS onRecorderPrepare");
        }
        byte[] a16 = RecordParams.a(recorderParam.f307257f, recorderParam.f307255d);
        ((IPttBuffer) QRoute.api(IPttBuffer.class)).createBufferTask(str);
        ((IPttBuffer) QRoute.api(IPttBuffer.class)).appendBuffer(str, a16, a16.length);
        this.f261196m = str;
        this.f261194h.post(new Runnable() { // from class: com.tencent.mobileqq.ptt.LSRecordPanel.7
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LSRecordPanel.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    LSRecordPanel.this.C();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        if (this.f261196m != null) {
            z(R.raw.f169416n);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderSilceEnd(String str, byte[] bArr, int i3, int i16, double d16, RecordParams.RecorderParam recorderParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, this, str, bArr, Integer.valueOf(i3), Integer.valueOf(i16), Double.valueOf(d16), recorderParam);
            return;
        }
        ((IPttBuffer) QRoute.api(IPttBuffer.class)).appendBuffer(str, bArr, i3);
        if (this.f261195i) {
            this.f261195i = false;
            this.f261194h.removeMessages(1);
        }
        if (x() && this.Q != 5) {
            this.f261194h.post(new Runnable(i16, d16) { // from class: com.tencent.mobileqq.ptt.LSRecordPanel.13
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f261197d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ double f261198e;

                {
                    this.f261197d = i16;
                    this.f261198e = d16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, LSRecordPanel.this, Integer.valueOf(i16), Double.valueOf(d16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    LSRecordPanel.this.u(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getVolumeLevel(this.f261197d));
                    LSRecordPanel.this.J.setText(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.f261198e));
                }
            });
        }
        this.C = (int) d16;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onRecorderStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS onRecorderStart");
        }
        this.C = 0;
        this.f261194h.post(new Runnable() { // from class: com.tencent.mobileqq.ptt.LSRecordPanel.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LSRecordPanel.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    LSRecordPanel.this.D();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
        this.f261194h.removeMessages(1);
        this.f261194h.sendEmptyMessageDelayed(1, 2000L);
        this.f261195i = true;
        return ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderVolumeStateChanged(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
        } else if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS onRecorderVolumeStateChanged");
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        super.requestLayout();
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS requestLayout");
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        this.E.setBackgroundColor(-16777216);
        this.E.setVisibility(0);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.6f, 0.0f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration(300L);
        this.E.startAnimation(alphaAnimation);
        f fVar = this.f261191e;
        if (fVar != null) {
            fVar.a1();
        }
    }

    public void u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.I.c(i3 / 1180);
        }
    }

    public void v(QQAppInterface qQAppInterface, TouchProxyRelativeLayout touchProxyRelativeLayout, f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, qQAppInterface, touchProxyRelativeLayout, fVar);
            return;
        }
        this.f261189d = qQAppInterface;
        this.M = touchProxyRelativeLayout;
        this.f261191e = fVar;
        this.f261194h = new WeakReferenceHandler(Looper.getMainLooper(), this);
        if (QLog.isDevelopLevel()) {
            QLog.d("LsRecord", 4, "LS init");
        }
    }

    public boolean x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        if (this.D == 0) {
            this.D = SystemClock.uptimeMillis();
        } else if (SystemClock.uptimeMillis() - this.D < 75) {
            return false;
        }
        this.D = SystemClock.uptimeMillis();
        return true;
    }

    public LSRecordPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f261193f = new SessionInfo();
        this.D = 0L;
        this.K = new Rect();
        this.N = new Rect();
        this.P = new Point();
        this.R = new Rect();
        this.V = true;
    }

    public LSRecordPanel(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f261193f = new SessionInfo();
        this.D = 0L;
        this.K = new Rect();
        this.N = new Rect();
        this.P = new Point();
        this.R = new Rect();
        this.V = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
    }
}
