package com.tencent.qqnt.aio.audiopanel;

import android.animation.Animator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager;
import com.tencent.mobileqq.activity.aio.audiopanel.CircleProgressView;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelPresenterCreater;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeChangeView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.utils.VoicePlayer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.ArrayList;

/* loaded from: classes34.dex */
public class ListenPanel extends RelativeLayout implements View.OnClickListener, VoicePlayer.a, com.tencent.mobileqq.activity.aio.audiopanel.c, com.tencent.mobileqq.qqaudio.audioplayer.h, Handler.Callback, AudioTransitionAnimManager.c, y51.a {

    /* renamed from: c0, reason: collision with root package name */
    public static int f349575c0 = 1;

    /* renamed from: d0, reason: collision with root package name */
    public static int f349576d0 = 1 + 1;
    private CircleProgressView C;
    private LinearLayout D;
    private TextView E;
    private TextView F;
    private ViewGroup G;
    private Handler H;
    private int I;
    private double J;
    private boolean K;
    private boolean L;
    private VolumeChangeView M;
    private VolumeChangeView N;
    private com.tencent.mobileqq.ptt.a P;
    private RecordParams.RecorderParam Q;
    private int R;
    private m S;
    private AudioPanel T;
    private ArrayList<Byte> U;
    int V;
    LottieDrawable W;

    /* renamed from: a0, reason: collision with root package name */
    Drawable f349577a0;

    /* renamed from: b0, reason: collision with root package name */
    private Runnable f349578b0;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f349579d;

    /* renamed from: e, reason: collision with root package name */
    private ViewGroup f349580e;

    /* renamed from: f, reason: collision with root package name */
    private String f349581f;

    /* renamed from: h, reason: collision with root package name */
    private RecordParams.RecorderParam f349582h;

    /* renamed from: i, reason: collision with root package name */
    private VoicePlayer f349583i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f349584m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes34.dex */
    public class a extends AccessibilityDelegateCompat {
        a() {
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription((ListenPanel.this.J < 1000.0d ? 0 : (int) ((ListenPanel.this.J / 1000.0d) + 0.5d)) + ListenPanel.this.getContext().getString(R.string.a_m));
        }
    }

    public ListenPanel(Context context) {
        super(context);
        this.K = false;
        this.L = false;
        this.R = f349575c0;
        this.f349578b0 = new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.ListenPanel.2
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOAudioPanel", 2, "ListenPanel playAnimRunable:,isEnabled= " + ListenPanel.this.isEnabled());
                }
                if (ListenPanel.this.isEnabled()) {
                    ListenPanel.this.j();
                }
            }
        };
    }

    private void g(int i3) {
        this.V = i3;
        AudioTransitionAnimManager k3 = AudioTransitionAnimManager.k();
        LottieDrawable lottieDrawable = this.W;
        if (lottieDrawable != null && k3.m(lottieDrawable)) {
            k3.g(this.W);
        }
        LottieDrawable i16 = k3.i(this.f349579d.getApplication().getApplicationContext(), this.V);
        this.W = i16;
        if (i16 != null) {
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.W == null) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOAudioPanel", 2, "playTransitionAnim mCurLottieDrawable == null");
            }
        } else {
            if (!(this.C.getDrawable() instanceof LottieDrawable)) {
                this.f349577a0 = this.C.getDrawable();
            }
            this.C.setScaleType(ImageView.ScaleType.FIT_CENTER);
            AudioTransitionAnimManager.k().u(this.W, this.V, this.C, true);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager.c
    public void a(LottieDrawable lottieDrawable, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "ListenPanel onDrawableLoaded mCurAnimType:" + this.V + ",type= " + i3 + " drawable=" + lottieDrawable);
        }
        if (!com.tencent.mobileqq.activity.aio.audiopanel.e.d(i3) && this.V == i3) {
            this.W = lottieDrawable;
            if (lottieDrawable != null) {
                ThreadManager.getUIHandler().removeCallbacks(this.f349578b0);
                ThreadManager.getUIHandler().post(this.f349578b0);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.AudioTransitionAnimManager.c
    public void b(Animator animator, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "ListenPanel onAnimationEnd  type=" + i3);
        }
        if (com.tencent.mobileqq.activity.aio.audiopanel.e.d(i3)) {
            return;
        }
        this.C.setScaleType(ImageView.ScaleType.CENTER);
        Drawable drawable = this.f349577a0;
        if (drawable != null) {
            this.C.setImageDrawable(drawable);
        }
    }

    @Override // y51.a
    public void d(int i3) {
        int a16 = com.tencent.mobileqq.activity.aio.audiopanel.e.a(i3);
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "ListenPanel startPlayAnimByType:,type= " + a16 + " isEnabled()" + isEnabled() + " getVisibility=" + getVisibility());
        }
        if (!AudioTransitionAnimManager.k().j()) {
            if (QLog.isColorLevel()) {
                QLog.d("AIOAudioPanel", 2, "fileNotExsit");
            }
        } else if (this.T.n() == 2 && getVisibility() == 0 && isEnabled()) {
            AudioTransitionAnimManager.k().f(this);
            this.T.t();
            g(a16);
        }
    }

    public void h(int i3) {
        int a16 = this.P.a(i3);
        this.M.c(a16);
        this.N.c(a16);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what != 1) {
            return false;
        }
        h(message.arg1);
        return true;
    }

    public void i(QQAppInterface qQAppInterface, ViewGroup viewGroup, AudioPanel audioPanel, ViewGroup viewGroup2, int i3, m mVar) {
        this.f349579d = qQAppInterface;
        this.T = audioPanel;
        this.f349580e = viewGroup2;
        this.G = viewGroup;
        this.I = i3;
        this.S = mVar;
        this.H = new Handler(Looper.getMainLooper(), this);
        TextView textView = (TextView) findViewById(R.id.izm);
        this.f349584m = textView;
        textView.setText(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(0.0d));
        CircleProgressView circleProgressView = (CircleProgressView) findViewById(R.id.ebx);
        this.C = circleProgressView;
        circleProgressView.setPresenter(((IAudioPanelPresenterCreater) QRoute.api(IAudioPanelPresenterCreater.class)).createCircleProcessViewPresenter(this.C));
        this.E = (TextView) findViewById(R.id.ebw);
        this.D = (LinearLayout) findViewById(R.id.eby);
        this.F = (TextView) findViewById(R.id.listen_panel_send_tv);
        this.M = (VolumeChangeView) findViewById(R.id.djn);
        this.N = (VolumeChangeView) findViewById(R.id.djo);
        k(true);
        this.C.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.P = ((IPttUtils) QRoute.api(IPttUtils.class)).creatPttAudioDataManager();
        this.C.setRingWidth(BaseAIOUtils.f(4.0f, getResources()));
        if (XPanelContainer.f384714h0 < XPanelContainer.f384715i0) {
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.djl);
            if (viewGroup3 != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) viewGroup3.getLayoutParams();
                marginLayoutParams.topMargin = 0;
                viewGroup3.setLayoutParams(marginLayoutParams);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.C.getLayoutParams();
            int dimension = (int) getResources().getDimension(R.dimen.d5t);
            marginLayoutParams2.width = dimension;
            marginLayoutParams2.height = dimension;
            marginLayoutParams2.topMargin = 0;
            this.C.setLayoutParams(marginLayoutParams2);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.D.getLayoutParams();
            layoutParams.height = BaseAIOUtils.f(64.0f, getContext().getResources());
            this.D.setLayoutParams(layoutParams);
        }
        this.M.setColor(getContext().getColor(R.color.qui_common_icon_primary));
        this.M.setBgColor(getContext().getColor(R.color.qui_common_fill_standard_secondary));
        this.N.setColor(getContext().getColor(R.color.qui_common_icon_primary));
        this.N.setBgColor(getContext().getColor(R.color.qui_common_fill_standard_secondary));
        this.C.setRingBgColor(getContext().getColor(R.color.qui_common_fill_standard_secondary));
        this.C.setRingColor(getContext().getColor(R.color.qui_common_icon_primary));
        if (FontSettingManager.getFontLevel() > 17.0f) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) this.C.getLayoutParams();
            marginLayoutParams3.topMargin = 0;
            this.C.setLayoutParams(marginLayoutParams3);
            e.g(this.C);
        }
    }

    void m() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "ListenPanel. stopAudioPlayer " + this.f349581f);
        }
        d(203);
        VoicePlayer voicePlayer = this.f349583i;
        if (voicePlayer != null) {
            voicePlayer.v();
            this.f349583i = null;
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public boolean onBackEvent() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "ListenPanel.onBackEvent() is called,audioPath is:" + this.f349581f);
        }
        m();
        this.S.O(this.f349581f);
        int i3 = this.I;
        if (i3 == 1) {
            setVisibility(8);
            PressToSpeakPanel pressToSpeakPanel = (PressToSpeakPanel) this.G.findViewById(R.id.fya);
            pressToSpeakPanel.N();
            pressToSpeakPanel.setVisibility(0);
        } else if (i3 == 2) {
            setVisibility(8);
            RecordSoundPanel recordSoundPanel = (RecordSoundPanel) this.G.findViewById(R.id.f166768i41);
            recordSoundPanel.k();
            recordSoundPanel.setVisibility(0);
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "ListenPanel.onDestroy() is called,audioPath is:" + this.f349581f);
        }
        m();
        int i3 = this.I;
        if (i3 == 1) {
            setVisibility(8);
            PressToSpeakPanel pressToSpeakPanel = (PressToSpeakPanel) this.G.findViewById(R.id.fya);
            pressToSpeakPanel.N();
            pressToSpeakPanel.setVisibility(0);
            return;
        }
        if (i3 == 2) {
            setVisibility(8);
            RecordSoundPanel recordSoundPanel = (RecordSoundPanel) this.G.findViewById(R.id.f166768i41);
            recordSoundPanel.k();
            recordSoundPanel.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public void onPause() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "ListenPanel.onPause() is called,audioPath is:" + this.f349581f);
        }
        if (this.f349583i != null) {
            k(true);
            m();
            this.f349584m.setText(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.J));
            this.C.setProgress(0);
            this.C.setContentDescription(getContext().getString(R.string.a_k));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setAudioData(ArrayList<Byte> arrayList) {
        this.U = arrayList;
    }

    public void setAudioPath(String str, double d16, RecordParams.RecorderParam recorderParam) {
        this.f349581f = str;
        this.J = d16;
        this.f349582h = recorderParam;
        this.f349584m.setText(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(d16));
        this.C.setProgress(0);
        this.C.setAnimFlag(true);
        k(true);
        this.C.setContentDescription(getContext().getString(R.string.a_k));
        this.Q = recorderParam;
        if (AppSetting.f99565y) {
            this.f349584m.setFocusable(true);
            ViewCompat.setAccessibilityDelegate(this.f349584m, new a());
            TextView textView = this.E;
            textView.setContentDescription(textView.getText());
            TextView textView2 = this.F;
            textView2.setContentDescription(textView2.getText());
            QQAppInterface.speak(getContext().getString(R.string.a_i));
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "ListenPanel.setAudioPath() is called,path is:" + str + ",recordTime is:" + d16);
        }
    }

    public void setJumpSource(int i3) {
        this.R = i3;
    }

    public void setNeedAudioData(boolean z16) {
        this.L = z16;
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void u4(int i3, String str, int i16) {
        this.C.setProgress(0);
        k(true);
        this.C.setContentDescription(getContext().getString(R.string.a_k));
        l(false);
        m();
    }

    private void k(boolean z16) {
        if (z16) {
            if (!QQTheme.isNowThemeSimpleNight() && !QQTheme.isNowThemeIsNight()) {
                this.C.setImageDrawable(getContext().getResources().getDrawable(R.drawable.qui_aio_audio_panel_new_listen_play_btn));
                return;
            } else {
                this.C.setImageDrawable(getContext().getResources().getDrawable(R.drawable.qui_aio_audio_panel_new_listen_play_btn_night));
                return;
            }
        }
        if (!QQTheme.isNowThemeSimpleNight() && !QQTheme.isNowThemeIsNight()) {
            this.C.setImageDrawable(getContext().getResources().getDrawable(R.drawable.qui_aio_audio_panel_new_listen_stop_btn));
        } else {
            this.C.setImageDrawable(getContext().getResources().getDrawable(R.drawable.qui_aio_audio_panel_new_listen_stop_btn_night));
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioplayer.h
    public void c(byte[] bArr) {
        if (bArr == null || bArr.length <= 0 || !this.P.b()) {
            return;
        }
        int b16 = (int) AudioHelper.b(this.f349579d.getApplication().getApplicationContext(), bArr, bArr.length, 1.0f);
        Handler handler = this.H;
        handler.sendMessage(handler.obtainMessage(1, b16, 0));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (id5 == R.id.ebx) {
            if (AppSetting.f99565y) {
                AudioUtil.n(R.raw.f169428z, false);
            }
            if (!this.K) {
                this.K = true;
                QQAppInterface qQAppInterface = this.f349579d;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.R == f349576d0 ? 1 : 2);
                sb5.append("");
                ReportController.o(qQAppInterface, "CliOper", "", "", "0X8004602", "0X8004602", 0, 0, sb5.toString(), "", "", "");
                if (QLog.isColorLevel()) {
                    QLog.d("QQRecorder", 2, "ListenPanel listened, jump source = " + this.R);
                }
            }
            if (this.f349583i == null) {
                VoicePlayer voicePlayer = new VoicePlayer(this.f349581f, new Handler(), this.f349582h.f307257f);
                this.f349583i = voicePlayer;
                if (this.L && voicePlayer.r()) {
                    this.f349583i.x(this);
                }
                this.f349583i.y(getContext());
                this.f349583i.z();
                this.f349583i.l(this);
                this.f349583i.A();
                k(false);
                d(202);
                this.C.setContentDescription(getContext().getString(R.string.a_l));
                l(true);
                return;
            }
            k(true);
            m();
            this.f349584m.setText(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(this.J));
            this.C.setProgress(0);
            this.C.setContentDescription(getContext().getString(R.string.a_k));
            l(false);
            return;
        }
        if (id5 == R.id.ebw) {
            m();
            this.S.O(this.f349581f);
            int i3 = this.I;
            if (i3 == 1) {
                setVisibility(8);
                PressToSpeakPanel pressToSpeakPanel = (PressToSpeakPanel) this.G.findViewById(R.id.fya);
                pressToSpeakPanel.N();
                pressToSpeakPanel.setVisibility(0);
            } else if (i3 == 2) {
                setVisibility(8);
                RecordSoundPanel recordSoundPanel = (RecordSoundPanel) this.G.findViewById(R.id.f166768i41);
                recordSoundPanel.k();
                recordSoundPanel.setVisibility(0);
                ReportController.o(this.f349579d, "CliOper", "", "", "Voice_record", "Voice_record _cancel", 0, 0, "", "", "", "");
            }
            l(false);
            return;
        }
        if (id5 == R.id.listen_panel_send_tv) {
            m();
            int i16 = (int) this.J;
            if (this.I == 2) {
                ReportController.o(this.f349579d, "CliOper", "", "", "Voice_record", "Record_attribute", 0, 0, String.valueOf(i16), "", "", "");
            }
            if (this.J < 1000.0d) {
                QQToast.makeText(getContext(), getResources().getString(R.string.f8z), 0).show();
                return;
            }
            this.S.P0(this.f349581f, i16, this.U, this.f349582h);
            int i17 = this.I;
            if (i17 == 1) {
                setVisibility(8);
                PressToSpeakPanel pressToSpeakPanel2 = (PressToSpeakPanel) this.G.findViewById(R.id.fya);
                pressToSpeakPanel2.N();
                pressToSpeakPanel2.setVisibility(0);
            } else if (i17 == 2) {
                setVisibility(8);
                RecordSoundPanel recordSoundPanel2 = (RecordSoundPanel) this.G.findViewById(R.id.f166768i41);
                recordSoundPanel2.k();
                recordSoundPanel2.setVisibility(0);
            }
            l(false);
        }
    }

    public ListenPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.K = false;
        this.L = false;
        this.R = f349575c0;
        this.f349578b0 = new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.ListenPanel.2
            @Override // java.lang.Runnable
            public void run() {
                if (QLog.isColorLevel()) {
                    QLog.d("AIOAudioPanel", 2, "ListenPanel playAnimRunable:,isEnabled= " + ListenPanel.this.isEnabled());
                }
                if (ListenPanel.this.isEnabled()) {
                    ListenPanel.this.j();
                }
            }
        };
    }

    private void l(boolean z16) {
        int i3 = this.Q.f307257f == 1 ? z16 ? 0 : 8 : 8;
        this.M.setVisibility(i3);
        this.N.setVisibility(i3);
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void c5(String str, int i3, int i16) {
        int i17;
        if (i3 <= 0 || i16 <= 0) {
            i17 = 0;
        } else {
            i17 = i16 > i3 ? 100 : (i16 * 100) / i3;
        }
        this.C.setProgress(i17);
        this.f349584m.setText(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(i16));
    }

    @Override // com.tencent.mobileqq.utils.VoicePlayer.a
    public void ic(String str, int i3, int i16) {
    }
}
