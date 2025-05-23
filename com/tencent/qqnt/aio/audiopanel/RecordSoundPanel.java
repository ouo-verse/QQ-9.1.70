package com.tencent.qqnt.aio.audiopanel;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.audiopanel.AudioPanelUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.IAudioPanelUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.VolumeChangeView;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ptt.api.IPttInfoCollector;
import com.tencent.mobileqq.ptt.d;
import com.tencent.mobileqq.pttlogic.api.IPttUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.PttInfoCollector;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IAIOPttControlApi;
import com.tencent.qqnt.aio.audiopanel.c;
import com.tencent.qqnt.aio.audiopanel.e;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import com.tencent.util.hapticcreator.HapticUtil;
import com.tencent.widget.XPanelContainer;
import java.lang.ref.WeakReference;

/* loaded from: classes34.dex */
public class RecordSoundPanel extends RelativeLayout implements d.a, View.OnClickListener, com.tencent.mobileqq.activity.aio.audiopanel.c {
    protected VolumeChangeView C;
    protected TextView D;
    protected ImageView E;
    protected boolean F;
    protected ViewGroup G;
    protected String H;
    protected PopupWindow I;
    protected View J;
    protected double K;
    protected com.tencent.mobileqq.ptt.a L;
    private boolean M;
    private m N;
    private com.tencent.qqnt.aio.audiopanel.c P;
    public Handler Q;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f349656d;

    /* renamed from: e, reason: collision with root package name */
    protected ViewGroup f349657e;

    /* renamed from: f, reason: collision with root package name */
    protected AudioPanel f349658f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f349659h;

    /* renamed from: i, reason: collision with root package name */
    protected ViewGroup f349660i;

    /* renamed from: m, reason: collision with root package name */
    protected VolumeChangeView f349661m;

    /* loaded from: classes34.dex */
    class a implements e.a {
        a() {
        }

        @Override // com.tencent.qqnt.aio.audiopanel.e.a
        public void onStart() {
            m mVar = RecordSoundPanel.this.N;
            RecordSoundPanel recordSoundPanel = RecordSoundPanel.this;
            mVar.s0(recordSoundPanel, RecordParams.c(recordSoundPanel.f349656d, false));
        }
    }

    /* loaded from: classes34.dex */
    class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            RecordSoundPanel.this.N.j(false);
            RecordSoundPanel.this.k();
            QQToast.makeText(RecordSoundPanel.this.getContext(), RecordSoundPanel.this.getResources().getString(R.string.f8t), 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes34.dex */
    public static class c implements c.b {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<RecordSoundPanel> f349669a;

        c(RecordSoundPanel recordSoundPanel) {
            this.f349669a = new WeakReference<>(recordSoundPanel);
        }

        @Override // com.tencent.qqnt.aio.audiopanel.c.b
        public void a(boolean z16) {
            RecordSoundPanel recordSoundPanel = this.f349669a.get();
            if (recordSoundPanel != null) {
                recordSoundPanel.i(z16);
            }
        }
    }

    public RecordSoundPanel(Context context) {
        super(context);
        this.F = true;
        this.M = false;
        this.Q = new b(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        PopupWindow popupWindow = this.I;
        if (popupWindow != null) {
            if (popupWindow.isShowing()) {
                try {
                    this.I.dismiss();
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("AIOAudioPanel", 2, "RecordSoundPanel dismiss topMaskPanel caused exception,it is no matter.", e16);
                    }
                }
            }
            this.I = null;
        }
    }

    private int e(int i3) {
        return getContext().getColorStateList(i3).getDefaultColor();
    }

    private void h() {
        com.tencent.qqnt.aio.audiopanel.c cVar = new com.tencent.qqnt.aio.audiopanel.c();
        this.P = cVar;
        cVar.g(new c(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel onCallStateChanged isCalling = " + z16);
        }
        if (z16) {
            o();
        }
    }

    private void l() {
        if (!QQTheme.isNowThemeSimpleNight() && !QQTheme.isNowThemeIsNight()) {
            this.E.setImageResource(R.drawable.kon);
        } else {
            this.E.setImageResource(R.drawable.kop);
        }
    }

    private final void m() {
        this.f349659h.setTextColor(e(R.color.qui_common_text_secondary));
        this.f349661m.setColor(e(R.color.qui_common_icon_primary));
        this.f349661m.setBgColor(e(R.color.qui_common_fill_standard_secondary));
        this.C.setColor(e(R.color.qui_common_icon_primary));
        this.C.setBgColor(e(R.color.qui_common_fill_standard_secondary));
    }

    private void o() {
        boolean isRecording = this.N.isRecording();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.stopRecord(), isRecording is:" + isRecording);
        }
        if (isRecording) {
            l();
            if (this.N.M0()) {
                setClickable(false);
                this.N.j(false);
            }
        }
    }

    public void f(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "level = " + i3);
        }
        int a16 = this.L.a(i3);
        this.f349661m.c(a16);
        this.C.c(a16);
    }

    public void g(QQAppInterface qQAppInterface, ViewGroup viewGroup, AudioPanel audioPanel, ViewGroup viewGroup2, m mVar) {
        this.f349656d = qQAppInterface;
        this.G = viewGroup;
        this.f349658f = audioPanel;
        this.f349657e = viewGroup2;
        this.N = mVar;
        TextView textView = (TextView) findViewById(R.id.fy8);
        this.f349659h = textView;
        textView.setContentDescription(HardCodeUtil.qqStr(R.string.sxc));
        this.f349660i = (ViewGroup) findViewById(R.id.djl);
        this.f349661m = (VolumeChangeView) findViewById(R.id.djn);
        this.C = (VolumeChangeView) findViewById(R.id.djo);
        this.D = (TextView) findViewById(R.id.i46);
        ImageView imageView = (ImageView) findViewById(R.id.f166767i40);
        this.E = imageView;
        imageView.setOnClickListener(this);
        setClickable(true);
        this.L = ((IPttUtils) QRoute.api(IPttUtils.class)).creatPttAudioDataManager();
        l();
        e.b(this.f349659h);
        if (XPanelContainer.f384714h0 <= XPanelContainer.f384715i0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f349660i.getLayoutParams();
            marginLayoutParams.topMargin = 0;
            this.f349660i.setLayoutParams(marginLayoutParams);
        }
        if (FontSettingManager.getFontLevel() > 17.0f) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.f349660i.getLayoutParams();
            marginLayoutParams2.topMargin = 0;
            this.f349660i.setLayoutParams(marginLayoutParams2);
            AudioPanelUtils.c(this.E);
        }
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.init() is called,time is:" + System.currentTimeMillis());
        }
        m();
        h();
    }

    public void j() {
        this.f349659h.setVisibility(8);
        this.f349660i.setVisibility(8);
        this.E.setVisibility(0);
        this.f349657e.setVisibility(4);
    }

    public void k() {
        boolean isRecording = this.N.isRecording();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.reset() is called, isRecording is:" + isRecording);
        }
        setClickable(true);
        this.f349659h.setVisibility(0);
        this.f349660i.setVisibility(8);
        l();
        this.E.setVisibility(0);
        this.E.setContentDescription(HardCodeUtil.qqStr(R.string.sxe));
        this.D.setText(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(0.0d));
        this.f349658f.setStatus(1);
        this.f349657e.setVisibility(0);
        d();
        View view = this.J;
        if (view != null) {
            if (view.getParent() != null) {
                ((ViewGroup) this.J.getParent()).removeView(this.J);
            }
            this.J = null;
        }
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("aio_audio_panel_reset_stop_record_switch_9025_121189656", true) && isRecording) {
            this.N.j(false);
        }
    }

    public void n() {
        VolumeChangeView volumeChangeView = this.f349661m;
        if (volumeChangeView != null && this.C != null) {
            volumeChangeView.b();
            this.C.b();
        }
        this.f349659h.setVisibility(8);
        this.f349660i.setVisibility(0);
        this.E.setVisibility(0);
        this.f349657e.setVisibility(4);
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public boolean onBackEvent() {
        boolean isRecording = this.N.isRecording();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onBackEvent() is called,isRecording is:" + isRecording);
        }
        if (!isRecording) {
            return false;
        }
        l();
        this.N.j(false);
        return true;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onBeginReceiveData(String str, RecordParams.RecorderParam recorderParam) {
        return k.b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id5 = view.getId();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onClick() is called");
        }
        com.tencent.mobileqq.activity.aio.l.f179531g = true;
        if (id5 == R.id.f166767i40) {
            ((IAIOPttControlApi) QRoute.api(IAIOPttControlApi.class)).pauseCurrentPttPlay();
            boolean isRecording = this.N.isRecording();
            if (QLog.isColorLevel()) {
                QLog.d("AIOAudioPanel", 2, "isRecording is:" + isRecording);
            }
            if (isRecording) {
                o();
                return;
            }
            HapticUtil.INSTANCE.play(view);
            ((IPttInfoCollector) QRoute.api(IPttInfoCollector.class)).setsCostUntilPrepare(SystemClock.uptimeMillis());
            if (this.N.H0()) {
                this.f349658f.J(5);
                if (!QQTheme.isNowThemeSimpleNight() && !QQTheme.isNowThemeIsNight()) {
                    this.E.setImageResource(R.drawable.koq);
                } else {
                    this.E.setImageResource(R.drawable.kor);
                }
                this.E.setContentDescription(HardCodeUtil.qqStr(R.string.sxd));
                e.e(R.raw.f169428z, new a());
                this.f349658f.setStatus(3);
                this.I = AudioPanel.H(getContext(), getWidth(), getResources().getDisplayMetrics().heightPixels - this.N.v(), this, 0, 0, 0, 0);
            }
            ReportController.o(this.f349656d, "CliOper", "", "", "Voice_record", "Voice_record_clk", 0, 0, "", "", "", "");
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public void onDestroy() {
        k();
        boolean isRecording = this.N.isRecording();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onDestroy() is called,isRecording is:" + isRecording);
        }
        if (isRecording) {
            this.N.j(false);
        }
        com.tencent.qqnt.aio.audiopanel.c cVar = this.P;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitFailed(String str, RecordParams.RecorderParam recorderParam) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitFailed() is called");
        }
        this.N.g0(str, true, recorderParam);
        this.Q.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.RecordSoundPanel.4
            @Override // java.lang.Runnable
            public void run() {
                RecordSoundPanel.this.k();
            }
        });
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onInitSuccess() {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onInitSuccess() is called");
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.audiopanel.c
    public void onPause() {
        boolean isRecording = this.N.isRecording();
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onPause() is called,isRecording is:" + isRecording);
        }
        if (isRecording) {
            l();
            this.N.j(false);
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderAbnormal(String str, RecordParams.RecorderParam recorderParam) {
        this.N.g0(str, true, recorderParam);
        this.Q.removeMessages(1);
        this.Q.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.RecordSoundPanel.6
            @Override // java.lang.Runnable
            public void run() {
                RecordSoundPanel.this.k();
            }
        });
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderEnd(final String str, final RecordParams.RecorderParam recorderParam, double d16) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderEnd() is called,path is:" + str);
        }
        this.Q.removeMessages(1);
        if (this.K < 500.0d) {
            this.N.O(str);
            this.Q.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.RecordSoundPanel.8
                @Override // java.lang.Runnable
                public void run() {
                    QQToast.makeText(RecordSoundPanel.this.getContext(), R.string.f170312ly, 1).show(com.tencent.mobileqq.activity.aio.l.D(RecordSoundPanel.this.getContext()));
                    RecordSoundPanel.this.k();
                }
            });
        } else {
            ((IPttInfoCollector) QRoute.api(IPttInfoCollector.class)).reportGcAndMemoryUse(2, (int) this.K);
            this.Q.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.RecordSoundPanel.9
                @Override // java.lang.Runnable
                public void run() {
                    RecordSoundPanel.this.f349657e.setVisibility(8);
                    ListenPanel listenPanel = (ListenPanel) RecordSoundPanel.this.G.findViewById(R.id.ebv);
                    listenPanel.setVisibility(0);
                    listenPanel.setAudioPath(str, RecordSoundPanel.this.K, recorderParam);
                    listenPanel.setJumpSource(ListenPanel.f349576d0);
                    RecordParams.RecorderParam recorderParam2 = recorderParam;
                    listenPanel.setAudioData(k.c(recorderParam2.D, recorderParam2.C));
                    RecordSoundPanel.this.f349658f.setStatus(4);
                    RecordSoundPanel.this.setVisibility(8);
                    RecordSoundPanel.this.d();
                    RecordSoundPanel.this.setClickable(true);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderError(String str, RecordParams.RecorderParam recorderParam, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderError() is called,path is:" + str);
        }
        this.N.g0(str, false, recorderParam);
        this.Q.removeMessages(1);
        this.Q.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.RecordSoundPanel.7
            @Override // java.lang.Runnable
            public void run() {
                RecordSoundPanel.this.k();
            }
        });
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderPrepare(final String str, RecordParams.RecorderParam recorderParam) {
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderPrepare() is called");
        }
        this.Q.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.RecordSoundPanel.2
            @Override // java.lang.Runnable
            public void run() {
                RecordSoundPanel.this.j();
                RecordSoundPanel.this.H = str;
            }
        });
        e.f(R.raw.f169428z, str);
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderSilceEnd(String str, byte[] bArr, int i3, final int i16, final double d16, RecordParams.RecorderParam recorderParam) {
        if (this.F) {
            this.F = false;
            this.Q.removeMessages(1);
        }
        if (this.L.b()) {
            this.Q.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.RecordSoundPanel.5
                @Override // java.lang.Runnable
                public void run() {
                    RecordSoundPanel.this.f(i16);
                    RecordSoundPanel.this.D.setText(((IAudioPanelUtils) QRoute.api(IAudioPanelUtils.class)).getTimeStrByMillis(d16));
                }
            });
        }
        this.K = d16;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return this.N.isRecording();
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public int onRecorderStart() {
        this.K = 0.0d;
        if (QLog.isColorLevel()) {
            QLog.d("AIOAudioPanel", 2, "RecordSoundPanel.onRecorderStart() is called");
        }
        this.Q.post(new Runnable() { // from class: com.tencent.qqnt.aio.audiopanel.RecordSoundPanel.3
            @Override // java.lang.Runnable
            public void run() {
                RecordSoundPanel.this.n();
            }
        });
        this.Q.removeMessages(1);
        this.Q.sendEmptyMessageDelayed(1, 2000L);
        this.F = true;
        PttInfoCollector.reportCostUntilPrepare(2);
        this.N.c();
        return ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID;
    }

    @Override // com.tencent.mobileqq.ptt.d.a
    public void onRecorderVolumeStateChanged(int i3) {
        if (i3 == 1) {
            ReportController.o(this.f349656d, "CliOper", "", "", "0X800484D", "0X800484D", 0, 0, "", "", "", "");
        }
    }

    public RecordSoundPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.F = true;
        this.M = false;
        this.Q = new b(Looper.getMainLooper());
    }
}
