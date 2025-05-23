package com.tencent.aelight.camera.aioeditor.capture.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.capture.music.QIMMusicConfigManager;
import com.tencent.aelight.camera.aioeditor.capture.music.g;
import com.tencent.aelight.camera.aioeditor.capture.view.ProviderView;
import com.tencent.aelight.camera.aioeditor.capture.view.QimMusicSeekView;
import com.tencent.aelight.camera.aioeditor.shortvideo.ShortVideoUtils;
import com.tencent.aelight.camera.struct.editor.FlowMusic;
import com.tencent.biz.qqstory.utils.d;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.en;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.video.decode.AVDecodeError;
import common.config.service.QzoneConfig;
import fr.f;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppActivity;
import mqq.app.BaseActivity;
import qs.e;

/* loaded from: classes32.dex */
public class MusicFragmentProviderView extends ProviderView implements QimMusicSeekView.a, View.OnClickListener, Handler.Callback {
    private QimMusicSeekView N;
    private View P;
    private View Q;
    private TextView R;
    private TextView S;
    private TextView T;
    private TextView U;
    private TextView V;
    private TextView W;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f67227a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f67228b0;

    /* renamed from: c0, reason: collision with root package name */
    private ProgressBar f67229c0;

    /* renamed from: d0, reason: collision with root package name */
    private ImageView f67230d0;

    /* renamed from: e0, reason: collision with root package name */
    private MusicItemInfo f67231e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f67232f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f67233g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f67234h0;

    /* renamed from: i0, reason: collision with root package name */
    private AtomicInteger f67235i0;

    /* renamed from: j0, reason: collision with root package name */
    private Timer f67236j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f67237k0;

    /* renamed from: l0, reason: collision with root package name */
    private AtomicBoolean f67238l0;

    /* renamed from: m0, reason: collision with root package name */
    private MusicPlayTask f67239m0;

    /* renamed from: n0, reason: collision with root package name */
    private long f67240n0;

    /* renamed from: o0, reason: collision with root package name */
    WeakReferenceHandler f67241o0;

    /* renamed from: p0, reason: collision with root package name */
    private g f67242p0;

    /* renamed from: q0, reason: collision with root package name */
    private e f67243q0;

    /* renamed from: r0, reason: collision with root package name */
    private com.tencent.aelight.camera.aioeditor.capture.music.e f67244r0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes32.dex */
    public class MusicPlayTask extends TimerTask {
        protected MusicPlayTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (MusicFragmentProviderView.this.f67242p0 != null) {
                MusicFragmentProviderView.this.f67235i0.incrementAndGet();
                WeakReferenceHandler weakReferenceHandler = MusicFragmentProviderView.this.f67241o0;
                if (weakReferenceHandler != null) {
                    weakReferenceHandler.sendEmptyMessage(0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements ns.a {
        c() {
        }

        @Override // ns.a
        public void a(boolean z16, Object obj) {
            WeakReferenceHandler weakReferenceHandler = MusicFragmentProviderView.this.f67241o0;
            if (weakReferenceHandler != null) {
                Message obtainMessage = weakReferenceHandler.obtainMessage();
                obtainMessage.arg1 = z16 ? 1 : 0;
                obtainMessage.obj = obj;
                obtainMessage.what = 7;
                MusicFragmentProviderView.this.f67241o0.sendMessage(obtainMessage);
            }
        }
    }

    public MusicFragmentProviderView(Context context) {
        super(context);
        this.f67232f0 = 0;
        this.f67233g0 = 0;
        this.f67234h0 = 10000;
        this.f67235i0 = new AtomicInteger(-1);
        this.f67236j0 = null;
        this.f67237k0 = false;
        this.f67238l0 = new AtomicBoolean(false);
        this.f67239m0 = null;
        this.f67240n0 = 400L;
        this.f67243q0 = new a();
        this.f67244r0 = new b();
    }

    private int P() {
        int i3 = this.f67234h0;
        int i16 = 5000;
        return (i3 >= 5000 && i3 <= (i16 = CodecParam.RECORD_MAX_TIME)) ? i3 : i16;
    }

    private void R(boolean z16) {
        MusicItemInfo musicItemInfo = this.f67231e0;
        this.f67232f0 = musicItemInfo.musicStart;
        this.f67233g0 = musicItemInfo.musicEnd;
        this.P.setVisibility(8);
        MusicItemInfo musicItemInfo2 = this.f67231e0;
        musicItemInfo2.musicStart = 0;
        musicItemInfo2.musicEnd = this.f67234h0;
        musicItemInfo2.musicDuration = (int) ShortVideoUtils.a(musicItemInfo2.getLocalPath());
        MusicItemInfo musicItemInfo3 = this.f67231e0;
        int i3 = musicItemInfo3.musicDuration;
        if (i3 < musicItemInfo3.musicEnd) {
            musicItemInfo3.musicEnd = i3;
        }
        this.f67237k0 = true;
        this.N.setDurations((P() + 500) / 1000, (Math.max(this.f67231e0.musicDuration, this.f67234h0) + 500) / 1000);
        this.N.c(0);
        MusicItemInfo musicItemInfo4 = this.f67231e0;
        Y(musicItemInfo4.musicStart, musicItemInfo4.musicEnd);
        this.Q.setVisibility(0);
        this.V.setEnabled(true);
        int i16 = this.K;
        if (i16 == 0 && !z16) {
            this.f67242p0.x(this.f67231e0, i16);
        } else {
            this.f67242p0.u(this.f67231e0);
        }
        ProviderView.a aVar = this.M;
        if (aVar != null) {
            aVar.H(!z16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("MusicFragmentProviderView", 2, "prepareStartMusic musicName" + this.f67231e0.mMusicName);
        }
    }

    private void T() {
        MusicItemInfo musicItemInfo = this.f67231e0;
        if (musicItemInfo == null) {
            QLog.i("MusicFragmentProviderView", 1, "startDownload mCurMusicItemInfo is null");
            return;
        }
        String str = musicItemInfo.mSongMid;
        if (TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("MusicFragmentProviderView", 2, "songMid not exist");
            }
            U(AVDecodeError.JNI_BITMAP_STRIDE_ERR);
        } else if (!NetworkUtil.isNetSupport(this.f67276d)) {
            if (QLog.isColorLevel()) {
                QLog.d("MusicFragmentProviderView", 2, "Net not Support");
            }
            U(-104);
        } else {
            if (NetworkUtil.isMobileNetWork(this.f67276d)) {
                W(1);
            }
            ((QIMMusicConfigManager) f.c(2)).C(str, this.f67231e0 instanceof VsMusicItemInfo, new c());
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public boolean B() {
        N();
        return true;
    }

    public void N() {
        MusicItemInfo musicItemInfo;
        if (this.f67238l0.compareAndSet(true, false) && (musicItemInfo = this.f67231e0) != null) {
            g gVar = this.f67242p0;
            if (gVar != null) {
                gVar.g(musicItemInfo);
            }
            this.f67231e0.mProgress = -1;
        }
        MusicItemInfo musicItemInfo2 = this.f67231e0;
        if (musicItemInfo2 != null && this.f67237k0) {
            musicItemInfo2.musicStart = this.f67232f0;
            musicItemInfo2.musicEnd = this.f67233g0;
            g gVar2 = this.f67242p0;
            if (gVar2 != null) {
                gVar2.i();
                this.f67242p0.z(this.K);
            }
            if (((QIMMusicConfigManager) f.c(2)).u(this.f67231e0.mItemId) == null) {
                d.h(new File(this.f67231e0.getLocalPath()));
                if (QLog.isColorLevel()) {
                    QLog.d("MusicFragmentProviderView", 2, "delete file=" + this.f67231e0.mMusicName);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("MusicFragmentProviderView", 2, "cancel musicStart=" + this.f67231e0.musicStart + " musicEnd=" + this.f67231e0.musicEnd + " musicDuration" + this.f67231e0.musicDuration + " premusicStart" + this.f67232f0 + " premusicEnd" + this.f67233g0 + " musicName" + this.f67231e0.mMusicName);
            }
            this.f67231e0 = null;
            S();
        }
        ProviderView.a aVar = this.M;
        if (aVar != null) {
            aVar.E(1);
        }
        WeakReferenceHandler weakReferenceHandler = this.f67241o0;
        if (weakReferenceHandler != null) {
            weakReferenceHandler.removeCallbacksAndMessages(null);
            this.f67241o0 = null;
        }
        g gVar3 = this.f67242p0;
        if (gVar3 != null) {
            gVar3.t(this.f67244r0);
            this.f67242p0 = null;
        }
    }

    public void O() {
        int i3;
        MusicItemInfo musicItemInfo = this.f67231e0;
        if (musicItemInfo != null && this.f67237k0) {
            g gVar = this.f67242p0;
            if (gVar != null && (i3 = this.K) == 0) {
                gVar.y(musicItemInfo, true, i3);
            } else if (gVar != null) {
                gVar.u(musicItemInfo);
            }
            ProviderView.a aVar = this.M;
            if (aVar != null) {
                aVar.H(true);
            }
            ((QIMMusicConfigManager) f.c(2)).o(this.f67231e0, true);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder("complete musicStart=");
                sb5.append(this.f67231e0.musicStart);
                sb5.append(" musicEnd=");
                sb5.append(this.f67231e0.musicEnd);
                sb5.append(" musicDuration");
                sb5.append(this.f67231e0.musicDuration);
                sb5.append(" premusicStart");
                sb5.append(this.f67232f0);
                sb5.append(" premusicEnd");
                sb5.append(this.f67233g0);
                sb5.append(" musicName");
                String str = this.f67231e0.mMusicName;
                if (str == null) {
                    str = "";
                }
                sb5.append(str);
                QLog.d("MusicFragmentProviderView", 2, sb5.toString());
            }
            this.f67231e0 = null;
            S();
        }
        ProviderView.a aVar2 = this.M;
        if (aVar2 != null) {
            aVar2.E(1);
        }
        WeakReferenceHandler weakReferenceHandler = this.f67241o0;
        if (weakReferenceHandler != null) {
            weakReferenceHandler.removeCallbacksAndMessages(null);
            this.f67241o0 = null;
        }
        g gVar2 = this.f67242p0;
        if (gVar2 != null) {
            gVar2.t(this.f67244r0);
            this.f67242p0 = null;
        }
    }

    void Q() {
        S();
        this.f67236j0 = new BaseTimer();
        MusicPlayTask musicPlayTask = new MusicPlayTask();
        this.f67239m0 = musicPlayTask;
        this.f67240n0 = 400L;
        int i3 = this.f67234h0;
        if (i3 > CodecParam.RECORD_MAX_TIME) {
            this.f67240n0 = (i3 * 400.0f) / r1;
        } else if (i3 < 5000) {
            this.f67240n0 = (i3 * 400.0f) / 5000;
        }
        this.f67236j0.schedule(musicPlayTask, 0L, this.f67240n0);
    }

    protected void S() {
        Timer timer = this.f67236j0;
        if (timer != null) {
            timer.cancel();
            this.f67236j0 = null;
        }
        MusicPlayTask musicPlayTask = this.f67239m0;
        if (musicPlayTask != null) {
            musicPlayTask.cancel();
            this.f67239m0 = null;
        }
    }

    void U(int i3) {
        WeakReferenceHandler weakReferenceHandler = this.f67241o0;
        if (weakReferenceHandler != null) {
            Message obtainMessage = weakReferenceHandler.obtainMessage();
            obtainMessage.what = 8;
            obtainMessage.arg1 = i3;
            this.f67241o0.sendMessage(obtainMessage);
        }
    }

    void V(int i3) {
        WeakReferenceHandler weakReferenceHandler = this.f67241o0;
        if (weakReferenceHandler != null) {
            Message obtainMessage = weakReferenceHandler.obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.arg1 = i3;
            this.f67241o0.sendMessage(obtainMessage);
        }
    }

    void W(int i3) {
        WeakReferenceHandler weakReferenceHandler = this.f67241o0;
        if (weakReferenceHandler != null) {
            Message obtainMessage = weakReferenceHandler.obtainMessage();
            obtainMessage.what = 4;
            obtainMessage.arg1 = i3;
            this.f67241o0.sendMessage(obtainMessage);
        }
    }

    void X(String str, int i3) {
        WeakReferenceHandler weakReferenceHandler;
        MusicItemInfo musicItemInfo = this.f67231e0;
        if (musicItemInfo == null || !musicItemInfo.getLocalPath().equals(str) || (weakReferenceHandler = this.f67241o0) == null) {
            return;
        }
        Message obtainMessage = weakReferenceHandler.obtainMessage();
        obtainMessage.what = 1;
        obtainMessage.arg1 = i3;
        this.f67241o0.sendMessage(obtainMessage);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.QimMusicSeekView.a
    public void a(int i3, int i16, int i17) {
        MusicItemInfo musicItemInfo = this.f67231e0;
        if (musicItemInfo != null) {
            int i18 = musicItemInfo.musicDuration;
            int i19 = (int) (i18 * (i17 / i3));
            int i26 = this.f67234h0;
            int i27 = i19 + i26;
            if (i19 < i18 && i27 > i18) {
                musicItemInfo.musicStart = i18 - i26;
                musicItemInfo.musicEnd = i18;
            } else {
                musicItemInfo.musicStart = i19;
                musicItemInfo.musicEnd = i19 + i26;
            }
            Y(musicItemInfo.musicStart, musicItemInfo.musicEnd);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.QimMusicSeekView.a
    public void g(int i3, int i16, int i17) {
        g gVar = this.f67242p0;
        if (gVar != null) {
            gVar.q();
        }
        ProviderView.a aVar = this.M;
        if (aVar != null) {
            aVar.H(false);
        }
        a(i3, i16, i17);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.QimMusicSeekView.a
    public void h(int i3, int i16) {
        int measureText = (int) (this.W.getPaint().measureText(QzoneConfig.ALBUM_RECOM_EVENT_ALGO_USER_SAMPLE_DEFAULT) / 2.0f);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.W.getLayoutParams();
        layoutParams.leftMargin = i3 - measureText;
        this.W.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f67227a0.getLayoutParams();
        layoutParams2.leftMargin = i16 - (measureText * 2);
        this.f67227a0.setLayoutParams(layoutParams2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01de, code lost:
    
        if (r11.isResume() == false) goto L65;
     */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean handleMessage(Message message) {
        boolean z16 = true;
        switch (message.what) {
            case 0:
                this.N.setPlayedPosition(this.f67235i0.get());
                return false;
            case 1:
                int i3 = message.arg1;
                this.P.setVisibility(0);
                this.Q.setVisibility(8);
                if (i3 >= 100) {
                    this.P.setVisibility(8);
                } else {
                    this.f67230d0.setVisibility(8);
                    this.f67229c0.setProgress(i3);
                    this.T.setVisibility(8);
                    if (QLog.isColorLevel()) {
                        QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_PROGRESS percent=" + i3);
                    }
                }
                return false;
            case 2:
                if (QLog.isColorLevel()) {
                    QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_REPLAY ");
                }
                if (getContext() instanceof AppActivity) {
                    AppActivity appActivity = (AppActivity) getContext();
                    if (QLog.isColorLevel()) {
                        QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_REPLAY isResume" + appActivity.isResume());
                    }
                    z16 = true ^ appActivity.isResume();
                } else {
                    if (getContext() instanceof BaseActivity) {
                        BaseActivity baseActivity = (BaseActivity) getContext();
                        if (QLog.isColorLevel()) {
                            QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_REPLAY isResume" + baseActivity.isResume());
                        }
                        break;
                    }
                    z16 = false;
                }
                MusicItemInfo musicItemInfo = this.f67231e0;
                if (musicItemInfo != null && !TextUtils.isEmpty(musicItemInfo.getLocalPath())) {
                    R(z16);
                } else if (QLog.isColorLevel()) {
                    QLog.d("MusicFragmentProviderView", 2, "curretInfo ==null or path not exsist");
                }
                return false;
            case 3:
                this.S.setText(this.f67276d.getResources().getString(R.string.f2y));
                return false;
            case 4:
                int i16 = message.arg1;
                if (i16 == 1) {
                    this.S.setText(this.f67276d.getResources().getString(R.string.f2w));
                }
                this.f67230d0.setVisibility(8);
                this.T.setVisibility(8);
                if (QLog.isColorLevel()) {
                    QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_NET_CHANGE state=" + i16);
                }
                return false;
            case 5:
                if (this.f67231e0 != null) {
                    this.N.c(message.arg1);
                    MusicItemInfo musicItemInfo2 = this.f67231e0;
                    Y(musicItemInfo2.musicStart, musicItemInfo2.musicEnd);
                }
                return false;
            case 6:
                Object obj = message.obj;
                if (obj != null) {
                    this.f67228b0.setText((String) obj);
                    this.f67228b0.setVisibility(0);
                }
                return false;
            case 7:
                String string = this.f67276d.getResources().getString(R.string.f2s);
                if (message.arg1 == 1) {
                    FlowMusic flowMusic = (FlowMusic) message.obj;
                    if (QLog.isColorLevel()) {
                        QLog.d("MusicFragmentProviderView", 2, "onGetSingleMusicInfo flowMusic:" + flowMusic.toString());
                    }
                    MusicItemInfo musicItemInfo3 = this.f67231e0;
                    String str = flowMusic.url;
                    musicItemInfo3.mUrl = str;
                    musicItemInfo3.fileSize = flowMusic.size;
                    musicItemInfo3.mAlbumUrl = flowMusic.albumUrl;
                    if (flowMusic.playable == 1 && !TextUtils.isEmpty(str)) {
                        this.f67242p0.v(this.f67231e0, this.f67243q0);
                        return false;
                    }
                    if (flowMusic.playable != 1) {
                        string = this.f67276d.getResources().getString(R.string.f2t);
                    }
                }
                this.f67230d0.setVisibility(0);
                this.S.setText(string);
                this.T.setVisibility(8);
                if (QLog.isColorLevel()) {
                    QLog.d("MusicFragmentProviderView", 2, "MSG_GET_SINGLE_MUSIC failed");
                }
                return false;
            case 8:
                int i17 = message.arg1;
                if (i17 == 0) {
                    this.P.setVisibility(8);
                } else if (i17 == -104) {
                    this.f67230d0.setVisibility(0);
                    this.T.setVisibility(8);
                    this.S.setText(this.f67276d.getResources().getString(R.string.f2x));
                } else {
                    this.f67230d0.setVisibility(0);
                    this.T.setVisibility(8);
                    this.S.setText(this.f67276d.getResources().getString(R.string.f2s));
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MusicFragmentProviderView", 2, "MSG_UPDATE_DOWNLOAD_FINISH_STATE finishState=" + i17);
                }
                return false;
            default:
                return false;
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.QimMusicSeekView.a
    public void k(int i3, int i16, int i17) {
        a(i3, i16, i17);
        ProviderView.a aVar = this.M;
        if (aVar != null) {
            aVar.H(true);
        }
        g gVar = this.f67242p0;
        if (gVar != null) {
            int i18 = this.K;
            if (i18 == 0) {
                gVar.y(this.f67231e0, true, i18);
            } else {
                gVar.u(this.f67231e0);
            }
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public boolean n(MotionEvent motionEvent) {
        float y16 = motionEvent.getY();
        float screenHeight = ViewUtils.getScreenHeight() - this.J;
        if (QLog.isColorLevel()) {
            QLog.d("MusicFragmentProviderView", 2, "checkToInterceptTouchArea, touchY=" + y16 + ", minTouchingY=" + screenHeight);
        }
        return y16 < screenHeight;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.amm) {
            N();
        } else if (id5 == R.id.amw) {
            O();
        } else if (id5 == R.id.bpl) {
            if (!this.f67242p0.h(this.f67231e0)) {
                T();
            }
            if (QLog.isColorLevel()) {
                QLog.d("MusicFragmentProviderView", 2, "download_try_again");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    protected int p() {
        return R.layout.aon;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.view.ProviderView
    public void v(Bundle bundle) {
        super.v(bundle);
        if (this.D == null) {
            this.D = LayoutInflater.from(getContext()).inflate(R.layout.aon, (ViewGroup) this, false);
        }
        l(this.D);
        this.D.setOnClickListener(this);
        QimMusicSeekView qimMusicSeekView = (QimMusicSeekView) this.D.findViewById(R.id.f36);
        this.N = qimMusicSeekView;
        qimMusicSeekView.setOnSeekListener(this);
        this.P = this.D.findViewById(R.id.efd);
        this.f67230d0 = (ImageView) this.D.findViewById(R.id.boz);
        TextView textView = (TextView) this.D.findViewById(R.id.bpl);
        this.T = textView;
        textView.setOnClickListener(this);
        this.f67229c0 = (ProgressBar) this.D.findViewById(R.id.f3c);
        this.S = (TextView) this.D.findViewById(R.id.bpc);
        this.Q = this.D.findViewById(R.id.imf);
        this.f67228b0 = (TextView) this.D.findViewById(R.id.iyq);
        this.W = (TextView) this.D.findViewById(R.id.ill);
        this.f67227a0 = (TextView) this.D.findViewById(R.id.ilk);
        this.R = (TextView) this.D.findViewById(R.id.f3y);
        this.U = (TextView) this.D.findViewById(R.id.amm);
        this.V = (TextView) this.D.findViewById(R.id.amw);
        this.U.setOnClickListener(this);
        this.V.setOnClickListener(this);
    }

    /* loaded from: classes32.dex */
    class a extends e {
        a() {
        }

        @Override // qs.e
        public void b(String str) {
            if (MusicFragmentProviderView.this.f67231e0 != null && MusicFragmentProviderView.this.f67231e0.getLocalPath().equals(str)) {
                MusicFragmentProviderView.this.f67231e0.mProgress = -1;
                WeakReferenceHandler weakReferenceHandler = MusicFragmentProviderView.this.f67241o0;
                if (weakReferenceHandler != null) {
                    weakReferenceHandler.sendEmptyMessage(3);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("MusicFragmentProviderView", 2, "download onCancel");
            }
            MusicFragmentProviderView.this.f67238l0.set(false);
        }

        @Override // qs.e
        public void c(String str, boolean z16, int i3) {
            MusicFragmentProviderView.this.U(i3);
            if (z16 && MusicFragmentProviderView.this.f67231e0 != null && MusicFragmentProviderView.this.f67231e0.getLocalPath().equals(str)) {
                MusicFragmentProviderView.this.f67231e0.musicStart = 0;
                MusicFragmentProviderView.this.f67231e0.musicEnd = MusicFragmentProviderView.this.f67231e0.musicStart + MusicFragmentProviderView.this.f67234h0;
                MusicFragmentProviderView.this.f67231e0.musicDuration = (int) ShortVideoUtils.a(MusicFragmentProviderView.this.f67231e0.getLocalPath());
                if (MusicFragmentProviderView.this.f67231e0.musicEnd > MusicFragmentProviderView.this.f67231e0.musicDuration) {
                    MusicFragmentProviderView.this.f67231e0.musicEnd = MusicFragmentProviderView.this.f67231e0.musicDuration;
                }
                MusicFragmentProviderView musicFragmentProviderView = MusicFragmentProviderView.this;
                musicFragmentProviderView.f67232f0 = musicFragmentProviderView.f67231e0.musicStart;
                MusicFragmentProviderView musicFragmentProviderView2 = MusicFragmentProviderView.this;
                musicFragmentProviderView2.f67233g0 = musicFragmentProviderView2.f67231e0.musicEnd;
                QIMMusicConfigManager qIMMusicConfigManager = (QIMMusicConfigManager) f.c(2);
                MusicItemInfo u16 = qIMMusicConfigManager.u(MusicFragmentProviderView.this.f67231e0.mItemId);
                if (u16 != null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MusicFragmentProviderView", 2, "music exist name =" + u16.mMusicName);
                    }
                    qIMMusicConfigManager.o(MusicFragmentProviderView.this.f67231e0, false);
                }
                WeakReferenceHandler weakReferenceHandler = MusicFragmentProviderView.this.f67241o0;
                if (weakReferenceHandler != null) {
                    weakReferenceHandler.sendEmptyMessage(2);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MusicFragmentProviderView", 2, "onFinish musicStart=" + MusicFragmentProviderView.this.f67231e0.musicStart + " musicEnd=" + MusicFragmentProviderView.this.f67231e0.musicEnd + " musicDuration" + MusicFragmentProviderView.this.f67231e0.musicDuration + " premusicStart" + MusicFragmentProviderView.this.f67232f0 + " premusicEnd" + MusicFragmentProviderView.this.f67233g0 + " musicName" + MusicFragmentProviderView.this.f67231e0.mMusicName);
                }
            }
            MusicFragmentProviderView.this.f67238l0.set(false);
        }

        @Override // qs.e
        public void d(int i3) {
            MusicFragmentProviderView.this.W(i3);
        }

        @Override // qs.e
        public void e(String str, int i3) {
            MusicFragmentProviderView.this.X(str, i3);
            MusicFragmentProviderView.this.f67238l0.set(true);
        }

        @Override // qs.e
        public void f(String str, boolean z16) {
            if (z16) {
                return;
            }
            MusicFragmentProviderView.this.U(AVDecodeError.JNI_BITMAP_STRIDE_ERR);
            MusicFragmentProviderView.this.f67238l0.set(false);
        }
    }

    public void setMusicProviderView(MusicItemInfo musicItemInfo) {
        QIMMusicConfigManager qIMMusicConfigManager = (QIMMusicConfigManager) f.c(2);
        this.f67241o0 = new WeakReferenceHandler(Looper.getMainLooper(), this);
        this.f67231e0 = musicItemInfo;
        qIMMusicConfigManager.N = musicItemInfo;
        this.f67235i0.set(-1);
        this.f67237k0 = false;
        this.f67238l0.set(false);
        this.f67242p0 = (g) f.d().g(8);
        ProviderView.a aVar = this.M;
        if (aVar != null) {
            int videoDuration = aVar.getVideoDuration();
            this.f67234h0 = videoDuration;
            if (videoDuration < 1000) {
                this.f67234h0 = 1000;
            }
        } else {
            this.f67234h0 = 10000;
        }
        int i3 = this.f67234h0;
        if (i3 == CodecParam.SEGMENT_RECORD_MAX_TIME) {
            this.f67240n0 = (int) (((i3 * 1.0f) / (P() + 1)) * 400.0f);
        } else {
            this.f67240n0 = i3 < 5000 ? (int) ((i3 / 6) * 0.4d) : 400L;
        }
        this.f67242p0.i();
        if (this.f67242p0.h(musicItemInfo)) {
            this.P.setVisibility(8);
            this.f67241o0.sendEmptyMessage(2);
        } else {
            this.f67229c0.setProgress(1);
            this.S.setText(this.f67276d.getResources().getString(R.string.cx_));
            this.f67230d0.setVisibility(8);
            this.T.setVisibility(8);
            this.S.setVisibility(0);
            this.P.setVisibility(0);
            this.Q.setVisibility(8);
            this.V.setEnabled(false);
            T();
        }
        if (QLog.isColorLevel()) {
            QLog.d("MusicFragmentProviderView", 2, "setMusicProviderView file not exist fileName=" + musicItemInfo.mMusicName + " mid=" + musicItemInfo.mSongMid);
        }
        this.f67242p0.f(this.f67244r0);
    }

    /* loaded from: classes32.dex */
    class b implements com.tencent.aelight.camera.aioeditor.capture.music.e {
        b() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.e
        public void a() {
            MusicFragmentProviderView.this.S();
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.e
        public void b(int i3, MusicItemInfo musicItemInfo) {
            MusicFragmentProviderView.this.V(i3);
            if (i3 != -1) {
                MusicFragmentProviderView.this.f67235i0.set(-1);
                MusicFragmentProviderView.this.Q();
            } else {
                MusicFragmentProviderView.this.S();
            }
            if (MusicFragmentProviderView.this.f67242p0 != null) {
                MusicFragmentProviderView.this.f67242p0.F();
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.e
        public void e(int i3, MusicItemInfo musicItemInfo) {
            MusicFragmentProviderView.this.S();
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.e
        public void g(MusicItemInfo musicItemInfo) {
            ProviderView.a aVar = MusicFragmentProviderView.this.M;
            if (aVar != null) {
                if (musicItemInfo.mType == 2) {
                    aVar.J(true);
                } else {
                    aVar.J(false);
                }
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.e
        public void d(int i3, MusicItemInfo musicItemInfo) {
            if (i3 != -1) {
                MusicFragmentProviderView.this.V(i3);
                MusicFragmentProviderView.this.f67235i0.set(-1);
                MusicFragmentProviderView.this.Q();
                return;
            }
            MusicFragmentProviderView.this.S();
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.e
        public void f(int i3, MusicItemInfo musicItemInfo) {
            if (i3 != -1) {
                MusicFragmentProviderView.this.Q();
            } else {
                MusicFragmentProviderView.this.S();
            }
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.music.e
        public void c(MusicItemInfo musicItemInfo) {
        }
    }

    private void Y(int i3, int i16) {
        int i17 = i16 - i3;
        int i18 = i17 / 1000;
        int i19 = i17 % 1000;
        if (i18 < 0) {
            i18 = 1;
        } else if (i19 > 500) {
            i18++;
        }
        String j3 = en.j(i3, false);
        String j16 = en.j((i18 * 1000) + i3, false);
        if (QLog.isColorLevel()) {
            QLog.d("MusicFragmentProviderView", 2, "start = " + i3 + ", end = " + i16 + ", displayStart = " + j3 + ", displayEnd = " + j16);
        }
        this.R.setText(j3 + "-" + j16);
        this.W.setText(j3);
        this.f67227a0.setText(j16);
    }
}
