package com.tencent.qqnt.aio.audiopanel;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.TraeHelper;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeChangeView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.earlydownload.api.IEarlyDownloadService;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOPttControlApi;
import com.tencent.qqnt.aio.audiopanel.c;
import com.tencent.qqnt.aio.audiopanel.e;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import com.tencent.util.VersionUtils;
import com.tencent.util.hapticcreator.HapticUtil;
import com.tencent.widget.XPanelContainer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes34.dex */
public class PressToChangeVoicePanel extends RelativeLayout implements d.a, View.OnTouchListener, com.tencent.mobileqq.activity.aio.audiopanel.c {
    public static String U;
    private ImageView C;
    private TextView D;
    protected ViewGroup E;
    protected VolumeChangeView F;
    protected VolumeChangeView G;
    protected ViewGroup H;
    protected PopupWindow I;
    protected View J;
    protected double K;
    protected com.tencent.mobileqq.ptt.a L;
    private m M;
    private com.tencent.qqnt.aio.audiopanel.c N;
    private int P;
    private Handler Q;
    private boolean R;
    public AudioPanelAdapter S;
    public boolean T;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f349586d;

    /* renamed from: e, reason: collision with root package name */
    protected ViewGroup f349587e;

    /* renamed from: f, reason: collision with root package name */
    public AudioPanel f349588f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f349589h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f349590i;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f349591m;

    /* loaded from: classes34.dex */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                switch (message.what) {
                    case 1001:
                        PressToChangeVoicePanel.this.q();
                        break;
                    case 1002:
                        PressToChangeVoicePanel.this.u();
                        break;
                    case 1003:
                        HashMap hashMap = (HashMap) message.obj;
                        String str = (String) hashMap.get(0);
                        PressToChangeVoicePanel.this.s();
                        PressToChangeVoicePanel.this.M.O(str);
                        break;
                    case 1004:
                        PressToChangeVoicePanel.this.M.O((String) message.obj);
                        PressToChangeVoicePanel.this.s();
                        break;
                    case 1005:
                        PressToChangeVoicePanel.this.P = 0;
                        HashMap hashMap2 = (HashMap) message.obj;
                        String str2 = (String) hashMap2.get(0);
                        ArrayList<Byte> arrayList = (ArrayList) hashMap2.get(1);
                        RecordParams.RecorderParam recorderParam = (RecordParams.RecorderParam) hashMap2.get(2);
                        PressToChangeVoicePanel.this.f349587e.setVisibility(8);
                        ListenChangeVoicePanel listenChangeVoicePanel = (ListenChangeVoicePanel) PressToChangeVoicePanel.this.H.findViewById(R.id.ebv);
                        listenChangeVoicePanel.o();
                        listenChangeVoicePanel.setVisibility(0);
                        listenChangeVoicePanel.setAudioPath(str2, PressToChangeVoicePanel.this.K, recorderParam);
                        listenChangeVoicePanel.setAudioData(arrayList);
                        PressToChangeVoicePanel.this.f349588f.setStatus(4);
                        PressToChangeVoicePanel.this.f349588f.setBlurView(false);
                        PressToChangeVoicePanel.this.setVisibility(8);
                        PressToChangeVoicePanel.this.i();
                        PressToChangeVoicePanel.this.setClickable(true);
                        ViewGroup viewGroup = (ViewGroup) listenChangeVoicePanel.findViewById(R.id.atf);
                        if (VersionUtils.isHoneycomb()) {
                            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(viewGroup, BasicAnimation.KeyPath.SCALE_X, 0.4f, 1.0f);
                            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(viewGroup, BasicAnimation.KeyPath.SCALE_Y, 0.4f, 1.0f);
                            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(viewGroup, com.tencent.luggage.wxa.c8.c.f123400v, 0.4f, 1.0f);
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.play(ofFloat).with(ofFloat2).with(ofFloat3);
                            animatorSet.setDuration(300L);
                            animatorSet.addListener(new C9468a(viewGroup));
                            animatorSet.start();
                            break;
                        } else {
                            viewGroup.setVisibility(0);
                            break;
                        }
                    case 1006:
                        PressToChangeVoicePanel.this.s();
                        break;
                    case 1007:
                        PressToChangeVoicePanel.this.l(message.arg1);
                        PressToChangeVoicePanel.this.D.setText(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(((Double) message.obj).doubleValue()));
                        break;
                }
            } catch (Exception e16) {
                QLog.e("PressToChangeVoicePanel", 1, "uiHandler Error:" + e16.getMessage());
            }
        }

        /* renamed from: com.tencent.qqnt.aio.audiopanel.PressToChangeVoicePanel$a$a, reason: collision with other inner class name */
        /* loaded from: classes34.dex */
        class C9468a extends com.tencent.mobileqq.widget.f {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ ViewGroup f349598d;

            C9468a(ViewGroup viewGroup) {
                this.f349598d = viewGroup;
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                this.f349598d.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOAudioPanel", 2, "startStartRecordAnim(),onAnimationEnd is called,time is:" + System.currentTimeMillis());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOAudioPanel", 2, "startStartRecordAnim(),onAnimationRepeat is called,time is:" + System.currentTimeMillis());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOAudioPanel", 2, "startStartRecordAnim(),onAnimationStart is called,time is:" + System.currentTimeMillis());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes34.dex */
    public static class c implements c.b {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<PressToChangeVoicePanel> f349601a;

        c(PressToChangeVoicePanel pressToChangeVoicePanel) {
            this.f349601a = new WeakReference<>(pressToChangeVoicePanel);
        }

        @Override // com.tencent.qqnt.aio.audiopanel.c.b
        public void a(boolean z16) {
            PressToChangeVoicePanel pressToChangeVoicePanel = this.f349601a.get();
            if (pressToChangeVoicePanel != null) {
                pressToChangeVoicePanel.p(z16);
            }
        }
    }

    public PressToChangeVoicePanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.P = 0;
        this.Q = new a(Looper.getMainLooper());
        this.R = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        PopupWindow popupWindow = this.I;
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                try {
                    this.I.dismiss();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOAudioPanel", 2, "PressToChangeVoicePanel dismiss topMaskPanel caused exception,it is no matter.", e16);
                    }
                }
            }
            this.I = null;
        }
    }

    private int j(int i3) {
        return getContext().getColorStateList(i3).getDefaultColor();
    }

    private boolean k(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int rawY = (int) motionEvent.getRawY();
        int rawX = (int) motionEvent.getRawX();
        if (action == 0) {
            if (this.M.M0()) {
                this.M.j(false);
                this.P = 1;
            }
        } else if (action == 2) {
            view.getLocationOnScreen(new int[2]);
            double width = view.getWidth();
            double height = view.getHeight();
            double d16 = r0[1] + height;
            if (Math.abs(rawX - (r0[0] + width)) > width || Math.abs(rawY - d16) > height) {
                if (this.R) {
                    this.R = false;
                    if (this.M.M0()) {
                        setClickable(false);
                        this.M.j(false);
                        this.P = 1;
                    }
                } else {
                    this.Q.removeMessages(1);
                }
            }
        } else if (action == 1 || action == 3) {
            w();
        }
        return true;
    }

    private void o() {
        com.tencent.qqnt.aio.audiopanel.c cVar = new com.tencent.qqnt.aio.audiopanel.c();
        this.N = cVar;
        cVar.g(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToChangeVoicePanel onCallStateChanged isCalling = " + z16);
        }
        if (z16) {
            w();
        }
    }

    private final void t() {
        this.D.setTextColor(j(R.color.qui_common_text_secondary));
        this.f349589h.setTextColor(j(R.color.qui_common_text_secondary));
        this.F.setColor(j(R.color.qui_common_icon_primary));
        this.F.setBgColor(j(R.color.qui_common_fill_standard_secondary));
        this.G.setColor(j(R.color.qui_common_icon_primary));
        this.G.setBgColor(j(R.color.qui_common_fill_standard_secondary));
    }

    private void w() {
        QLog.i("PressToChangeVoicePanel", 1, "stopRecord(), touchValid is:" + this.R);
        this.f349590i.clearAnimation();
        this.f349591m.clearAnimation();
        this.C.setPressed(false);
        if (this.R) {
            this.R = false;
            if (this.M.M0()) {
                setClickable(false);
                this.M.j(false);
                this.P = 1;
                return;
            }
            return;
        }
        this.Q.removeMessages(1);
    }

    public void l(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "level = " + i3);
        }
        int a16 = this.L.a(i3);
        this.F.c(a16);
        this.G.c(a16);
    }

    public void m(QQAppInterface qQAppInterface, ViewGroup viewGroup, AudioPanel audioPanel, ViewGroup viewGroup2, AudioPanelAdapter audioPanelAdapter, m mVar) {
        this.f349586d = qQAppInterface;
        this.H = viewGroup;
        this.f349588f = audioPanel;
        this.f349587e = viewGroup2;
        this.S = audioPanelAdapter;
        this.M = mVar;
        this.f349589h = (TextView) findViewById(R.id.fyb);
        this.E = (ViewGroup) findViewById(R.id.djl);
        this.F = (VolumeChangeView) findViewById(R.id.djn);
        this.G = (VolumeChangeView) findViewById(R.id.djo);
        this.D = (TextView) findViewById(R.id.izm);
        this.f349590i = (ImageView) findViewById(R.id.f26990f1);
        this.f349591m = (ImageView) findViewById(R.id.f27000f2);
        ImageView imageView = (ImageView) findViewById(R.id.fy6);
        this.C = imageView;
        imageView.setOnTouchListener(this);
        this.L = ((IPttUtils) QRoute.api(IPttUtils.class)).creatPttAudioDataManager();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToChangeVoice.init() is called");
        }
        if (!QQTheme.isNowThemeSimpleNight() && !QQTheme.isNowThemeIsNight()) {
            this.f349590i.setImageResource(R.drawable.lmb);
            this.f349591m.setImageResource(R.drawable.lmd);
            this.C.setImageResource(R.drawable.lma);
        } else {
            this.f349590i.setImageResource(R.drawable.lmc);
            this.f349591m.setImageResource(R.drawable.lme);
            this.C.setImageResource(R.drawable.lmf);
        }
        if (XPanelContainer.f384714h0 <= XPanelContainer.f384715i0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.E.getLayoutParams();
            marginLayoutParams.topMargin = (int) getResources().getDimension(R.dimen.d5v);
            this.E.setLayoutParams(marginLayoutParams);
        }
        if (FontSettingManager.getFontLevel() > 17.0f) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.E.getLayoutParams();
            marginLayoutParams2.topMargin = 0;
            this.E.setLayoutParams(marginLayoutParams2);
            e.g(this.f349590i);
            e.g(this.f349591m);
            e.g(this.C);
        }
        if (AppSetting.f99565y) {
            ViewCompat.setImportantForAccessibility(this.f349589h, 2);
            ViewCompat.setImportantForAccessibility(this.f349590i, 2);
            ViewCompat.setImportantForAccessibility(this.f349591m, 2);
            this.C.setContentDescription(getContext().getString(R.string.a_g));
        }
        e.b(this.f349589h);
        t();
        o();
    }

    public void n() {
        if (this.T) {
            return;
        }
        ViewGroup viewGroup = this.S.f349535i;
        if (viewGroup == null) {
            ListenChangeVoicePanel listenChangeVoicePanel = (ListenChangeVoicePanel) LayoutInflater.from(getContext()).inflate(R.layout.gvo, (ViewGroup) null);
            listenChangeVoicePanel.n(this.f349586d, this.M, this.H);
            this.S.f349535i = listenChangeVoicePanel;
        } else {
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(this.S.f349535i);
            }
            ((ListenChangeVoicePanel) this.S.f349535i).n(this.f349586d, this.M, this.H);
        }
        ListenChangeVoicePanel listenChangeVoicePanel2 = (ListenChangeVoicePanel) this.S.f349535i;
        listenChangeVoicePanel2.r();
        this.H.addView(listenChangeVoicePanel2, new FrameLayout.LayoutParams(-1, -1));
        listenChangeVoicePanel2.setVisibility(8);
        this.T = true;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public boolean onBackEvent() {
        boolean isRecording = this.M.isRecording();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToChangeVoicePanel.onBackEvent() is called,isRecording is:" + isRecording);
        }
        if (!isRecording) {
            return false;
        }
        this.M.j(false);
        return true;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onBeginReceiveData(String str, RecordParams.RecorderParam recorderParam) {
        return k.b();
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public void onDestroy() {
        s();
        boolean isRecording = this.M.isRecording();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.onDestroy() is called,isRecording is:" + isRecording);
        }
        if (isRecording) {
            this.P = 3;
            this.M.j(false);
        }
        com.tencent.qqnt.aio.audiopanel.c cVar = this.N;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitFailed(String str, RecordParams.RecorderParam recorderParam) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToChangePanel.onInitFailed() is called");
        }
        this.M.g0(str, true, recorderParam);
        this.Q.sendEmptyMessage(1006);
        ReportController.o(this.f349586d, "CliOper", "", "", "0X8005A17", "0X8005A17", 3, 0, "", "", "", AppSetting.f99551k);
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitSuccess() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToChangePanel.onInitSuccess() is called");
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public void onPause() {
        boolean isRecording = this.M.isRecording();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToChangeVoicePanel.onPause() is called,isRecording is:" + isRecording);
        }
        if (isRecording) {
            this.P = 1;
            this.M.j(false);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderAbnormal(String str, RecordParams.RecorderParam recorderParam) {
        this.M.g0(str, true, recorderParam);
        this.Q.sendEmptyMessage(1006);
        ReportController.o(this.f349586d, "CliOper", "", "", "0X8005A17", "0X8005A17", 4, 0, "", "", "", AppSetting.f99551k);
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderError(String str, RecordParams.RecorderParam recorderParam, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToChangeVoicePanel.onRecorderError() is called,path is:" + str + ",errorCode is:" + str2);
        }
        this.M.g0(str, false, recorderParam);
        this.Q.sendEmptyMessage(1006);
        ReportController.o(this.f349586d, "CliOper", "", "", "0X8005A17", "0X8005A17", 2, 0, "", "", "", AppSetting.f99551k);
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderPrepare(String str, RecordParams.RecorderParam recorderParam) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToChanegVoicePanel.onRecorderPrepare() is called,path is:" + str);
        }
        this.Q.sendEmptyMessage(1001);
        e.f(R.raw.f169428z, str);
        this.M.c();
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderSilceEnd(String str, byte[] bArr, int i3, int i16, double d16, RecordParams.RecorderParam recorderParam) {
        if (this.L.b()) {
            Handler handler = this.Q;
            handler.sendMessage(handler.obtainMessage(1007, i16, 0, Double.valueOf(d16)));
        }
        this.K = d16;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToChangeVoice.onTouch() is called,action is:" + action);
        }
        if (view.getId() != R.id.fy6) {
            return false;
        }
        if (action == 0) {
            ((IAIOPttControlApi) QRoute.api(IAIOPttControlApi.class)).pauseCurrentPttPlay();
            this.C.setPressed(true);
            HapticUtil.INSTANCE.play(view);
            Message obtain = Message.obtain(this.Q, new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToChangeVoicePanel.3

                /* renamed from: com.tencent.qqnt.aio.audiopanel.PressToChangeVoicePanel$3$a */
                /* loaded from: classes34.dex */
                class a implements e.a {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ RecordParams.RecorderParam f349595a;

                    a(RecordParams.RecorderParam recorderParam) {
                        this.f349595a = recorderParam;
                    }

                    @Override // com.tencent.qqnt.aio.audiopanel.e.a
                    public void onStart() {
                        PressToChangeVoicePanel.this.M.s0(PressToChangeVoicePanel.this, this.f349595a);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    PressToChangeVoicePanel.this.R = true;
                    PressToChangeVoicePanel.this.P = 1;
                    boolean isRecording = PressToChangeVoicePanel.this.M.isRecording();
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOAudioPanel", 2, "isRecording is:" + isRecording);
                    }
                    if (isRecording) {
                        if (PressToChangeVoicePanel.this.M.M0()) {
                            PressToChangeVoicePanel.this.setClickable(false);
                            PressToChangeVoicePanel.this.M.j(false);
                            return;
                        }
                        return;
                    }
                    PressToChangeVoicePanel.h(PressToChangeVoicePanel.this.f349586d, true, "0X8006386");
                    if (PressToChangeVoicePanel.U == null) {
                        QQToast.makeText(BaseApplication.getContext(), R.string.f6j, 0).show();
                        return;
                    }
                    if (PressToChangeVoicePanel.this.M.H0()) {
                        PressToChangeVoicePanel.this.n();
                        RecordParams.RecorderParam c16 = RecordParams.c(PressToChangeVoicePanel.this.f349586d, true);
                        c16.F = true;
                        e.e(R.raw.f169428z, new a(c16));
                        AudioPanel audioPanel = PressToChangeVoicePanel.this.f349588f;
                        if (audioPanel != null) {
                            audioPanel.setStatus(3);
                        }
                        PressToChangeVoicePanel.this.v();
                        int v3 = (PressToChangeVoicePanel.this.getResources().getDisplayMetrics().heightPixels - PressToChangeVoicePanel.this.M.v()) - (PressToChangeVoicePanel.this.getContext().getResources().getDimensionPixelSize(R.dimen.f158195bz2) * 2);
                        PressToChangeVoicePanel pressToChangeVoicePanel = PressToChangeVoicePanel.this;
                        pressToChangeVoicePanel.I = AudioPanel.H(pressToChangeVoicePanel.getContext(), PressToChangeVoicePanel.this.getWidth(), v3, PressToChangeVoicePanel.this, 0, 0, 0, 0);
                    }
                    PressToChangeVoicePanel pressToChangeVoicePanel2 = PressToChangeVoicePanel.this;
                    AudioPanel audioPanel2 = pressToChangeVoicePanel2.f349588f;
                    if (audioPanel2 != null) {
                        audioPanel2.B(pressToChangeVoicePanel2);
                    }
                }
            });
            obtain.what = 1;
            this.Q.sendMessageDelayed(obtain, 150L);
            return true;
        }
        k(view, motionEvent);
        return true;
    }

    public void q() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "PressToSpeakPanel.prepareRecord() is called,time is:" + System.currentTimeMillis());
        }
        com.tencent.mobileqq.activity.aio.l.f179531g = true;
        this.f349589h.setVisibility(8);
        this.E.setVisibility(8);
        this.C.setVisibility(0);
        this.F.setVisibility(8);
        this.G.setVisibility(8);
        this.f349587e.setVisibility(4);
    }

    public void r() {
        if (AppSetting.f99565y) {
            this.C.postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToChangeVoicePanel.6
                @Override // java.lang.Runnable
                public void run() {
                    PressToChangeVoicePanel.this.C.sendAccessibilityEvent(128);
                }
            }, 500L);
        }
    }

    public void u() {
        QLog.i("PressToChangeVoicePanel", 1, "startRecord() is called, time is " + System.currentTimeMillis());
        this.F.b();
        this.G.b();
        this.f349589h.setVisibility(8);
        this.E.setVisibility(0);
        this.C.setVisibility(0);
        this.F.setVisibility(0);
        this.G.setVisibility(0);
        this.f349587e.setVisibility(4);
    }

    void v() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154928tt);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.f154929tu);
        loadAnimation.setAnimationListener(new b());
        this.f349590i.startAnimation(loadAnimation);
        this.f349591m.startAnimation(loadAnimation2);
    }

    public void s() {
        this.R = false;
        if ((getContext() instanceof Activity) && ((Activity) getContext()).isFinishing()) {
            return;
        }
        this.f349589h.setVisibility(0);
        this.E.setVisibility(8);
        this.f349590i.clearAnimation();
        this.f349591m.clearAnimation();
        this.C.setVisibility(0);
        this.D.setText(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(0.0d));
        this.F.setVisibility(8);
        this.G.setVisibility(8);
        this.f349587e.setVisibility(0);
        this.f349588f.setStatus(1);
        this.f349588f.setBlurView(true);
        i();
        View view = this.J;
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) this.J.getParent()).removeView(this.J);
            }
            this.J = null;
        }
        r();
    }

    public static void h(final QQAppInterface qQAppInterface, final boolean z16, final String str) {
        if (z16) {
            if (U == null) {
                U = TraeHelper.J(BaseApplicationImpl.sApplication);
            }
            if (QLog.isColorLevel()) {
                QLog.d("AIOAudioPanel", 2, "checkVcSo sync:" + U);
            }
        }
        if (U == null) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToChangeVoicePanel.2
                @Override // java.lang.Runnable
                public void run() {
                    if (!z16) {
                        if (PressToChangeVoicePanel.U == null) {
                            PressToChangeVoicePanel.U = TraeHelper.J(BaseApplicationImpl.sApplication);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("AIOAudioPanel", 2, "checkVcSo async:" + PressToChangeVoicePanel.U);
                        }
                    }
                    if (PressToChangeVoicePanel.U == null) {
                        if (AVCoreSystemInfo.getCpuArchitecture() <= 2) {
                            try {
                                com.tencent.mobileqq.earlydownload.handler.b earlyHandler = ((IEarlyDownloadService) qQAppInterface.getRuntimeService(IEarlyDownloadService.class, "")).getEarlyHandler(com.tencent.mobileqq.earlydownload.handler.m.O());
                                if (earlyHandler != null) {
                                    earlyHandler.I(false);
                                } else {
                                    QLog.e("AIOAudioPanel", 1, "voiceChang checkVcSo null == earlyHandler:");
                                }
                            } catch (Exception e16) {
                                QLog.e("AIOAudioPanel", 1, "voiceChang checkVcSo Exception:" + e16.getMessage());
                            }
                        } else {
                            AVSoUtils.i(BaseApplicationImpl.sApplication, "traeimp-armeabi-v7a", true);
                        }
                        QQAppInterface qQAppInterface2 = qQAppInterface;
                        String str2 = str;
                        ReportController.o(qQAppInterface2, "dc00898", "", "", str2, str2, 0, 0, "", "", "", "");
                    }
                }
            }, 5, null, false);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onRecorderStart() {
        this.K = 0.0d;
        QLog.i("PressToChangeVoicePanel", 1, "onRecorderStart() is called");
        this.Q.sendEmptyMessage(1002);
        PttInfoCollector.reportCostUntilPrepare(0);
        return ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderEnd(String str, RecordParams.RecorderParam recorderParam, double d16) {
        QLog.i("PressToChangeVoicePanel", 1, "onRecorderEnd() is called, path is:" + str + ", type: " + recorderParam.f307257f + ", time:" + this.K);
        if (this.K < 800.0d) {
            this.M.O(str);
            post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.PressToChangeVoicePanel.4
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(PressToChangeVoicePanel.this.getContext(), R.string.f170312ly, 1).show(com.tencent.mobileqq.activity.aio.l.D(PressToChangeVoicePanel.this.getContext()));
                    PressToChangeVoicePanel.this.s();
                }
            });
            HashMap hashMap = new HashMap();
            hashMap.put(0, str);
            hashMap.put(1, recorderParam);
            Handler handler = this.Q;
            handler.sendMessage(handler.obtainMessage(1003, hashMap));
            ReportController.o(this.f349586d, "CliOper", "", "", "0X8005A17", "0X8005A17", 1, 0, String.valueOf((int) this.K), "", "", AppSetting.f99551k);
            ReportController.o(this.f349586d, "CliOper", "", "", "changevoice", "0X8006F4E", 0, 0, "1", "", "", "");
            return;
        }
        ((IPttInfoCollector) QRoute.api(IPttInfoCollector.class)).reportGcAndMemoryUse(3, (int) this.K);
        ReportController.o(this.f349586d, "CliOper", "", "", "changevoice", "0X8006F4E", 0, 0, "0", "", "", "");
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "pressState is:" + this.P);
        }
        if (this.P == 1) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put(0, str);
            hashMap2.put(1, k.c(recorderParam.D, recorderParam.C));
            hashMap2.put(2, recorderParam);
            Handler handler2 = this.Q;
            handler2.sendMessage(handler2.obtainMessage(1005, hashMap2));
            return;
        }
        Handler handler3 = this.Q;
        handler3.sendMessage(handler3.obtainMessage(1004, str));
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderVolumeStateChanged(int i3) {
    }
}
