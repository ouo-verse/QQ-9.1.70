package com.tencent.mobileqq.avatar.dynamicavatar;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ConfigurationInfo;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.FlowActivity;
import com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import com.tencent.mobileqq.activity.richmedia.state.g;
import com.tencent.mobileqq.activity.richmedia.view.CameraCover;
import com.tencent.mobileqq.activity.richmedia.view.CameraGLSurfaceView;
import com.tencent.mobileqq.activity.richmedia.view.CameraTextureView;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.audioplayer.f;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.mediadevice.AudioCapture;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraPreview;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraProxy;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.shortvideo.mediadevice.PreviewContext;
import com.tencent.mobileqq.shortvideo.mediadevice.e;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.CircleProgress;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportProgressDialog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ActionSheet;
import cooperation.peak.PeakConstants;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.PerfTracer;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DynamicAvatarRecordActivity extends FlowActivity implements g, View.OnClickListener {
    static IPatchRedirector $redirector_;
    private BroadcastReceiver A0;
    View.OnTouchListener B0;
    CameraExceptionHandler.a C0;
    int S;
    private boolean T;
    RMVideoStateMgr U;
    int V;
    int W;
    boolean X;
    boolean Y;
    CameraProxy Z;

    /* renamed from: a0, reason: collision with root package name */
    Handler f199972a0;

    /* renamed from: b0, reason: collision with root package name */
    CameraCover f199973b0;

    /* renamed from: c0, reason: collision with root package name */
    CameraGLSurfaceView f199974c0;

    /* renamed from: d0, reason: collision with root package name */
    Button f199975d0;

    /* renamed from: e0, reason: collision with root package name */
    Button f199976e0;

    /* renamed from: f0, reason: collision with root package name */
    TextView f199977f0;

    /* renamed from: g0, reason: collision with root package name */
    TextView f199978g0;

    /* renamed from: h0, reason: collision with root package name */
    ImageViewVideoPlayer f199979h0;

    /* renamed from: i0, reason: collision with root package name */
    TextView f199980i0;

    /* renamed from: j0, reason: collision with root package name */
    TextView f199981j0;

    /* renamed from: k0, reason: collision with root package name */
    TextView f199982k0;

    /* renamed from: l0, reason: collision with root package name */
    ImageView f199983l0;

    /* renamed from: m0, reason: collision with root package name */
    ImageView f199984m0;

    /* renamed from: n0, reason: collision with root package name */
    CircleProgress f199985n0;

    /* renamed from: o0, reason: collision with root package name */
    boolean f199986o0;

    /* renamed from: p0, reason: collision with root package name */
    int f199987p0;

    /* renamed from: q0, reason: collision with root package name */
    int f199988q0;

    /* renamed from: r0, reason: collision with root package name */
    private int f199989r0;

    /* renamed from: s0, reason: collision with root package name */
    ProgressDialog f199990s0;

    /* renamed from: t0, reason: collision with root package name */
    ActionSheet f199991t0;

    /* renamed from: u0, reason: collision with root package name */
    int f199992u0;

    /* renamed from: v0, reason: collision with root package name */
    String f199993v0;

    /* renamed from: w0, reason: collision with root package name */
    QQCustomDialog f199994w0;

    /* renamed from: x0, reason: collision with root package name */
    volatile AtomicBoolean f199995x0;

    /* renamed from: y0, reason: collision with root package name */
    volatile AtomicBoolean f199996y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f199997z0;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DynamicAvatarRecordActivity.this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            AudioCapture audioCapture;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            if (ITroopHWApi.ACTION_START_VIDEO_CHAT.equals(intent.getAction())) {
                if (QLog.isColorLevel()) {
                    QLog.d("DynamicAvatarRecordActivity", 2, "receive ACTION_START_VIDEO_CHAT.");
                }
                View n06 = BaseActivity2.n0(DynamicAvatarRecordActivity.this.f199973b0, R.id.cdg);
                if (n06 != null) {
                    DynamicAvatarRecordActivity.this.f199973b0.removeView(n06);
                }
                RMVideoStateMgr rMVideoStateMgr = DynamicAvatarRecordActivity.this.U;
                if (rMVideoStateMgr != null && (audioCapture = rMVideoStateMgr.J) != null) {
                    audioCapture.t();
                }
                DynamicAvatarRecordActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DynamicAvatarRecordActivity.this);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
            } else if (i3 == 0) {
                DynamicAvatarRecordActivity.this.U.k("DynamicAvatarRecordActivity");
                DynamicAvatarRecordActivity.this.finish();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class c implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DynamicAvatarRecordActivity.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            DynamicAvatarRecordActivity dynamicAvatarRecordActivity = DynamicAvatarRecordActivity.this;
            if (!dynamicAvatarRecordActivity.Y) {
                return false;
            }
            if (view == dynamicAvatarRecordActivity.f199983l0 || view == dynamicAvatarRecordActivity.f199985n0) {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action == 1 || action == 3) {
                        if (DynamicAvatarRecordActivity.this.U.A()) {
                            if (QLog.isColorLevel()) {
                                QLog.i("DynamicAvatarRecordActivity", 2, "ACTION_UP, current state is already preview!");
                            }
                            return true;
                        }
                        DynamicAvatarRecordActivity.this.U.p();
                        long currentTimeMillis = System.currentTimeMillis();
                        DynamicAvatarRecordActivity dynamicAvatarRecordActivity2 = DynamicAvatarRecordActivity.this;
                        RMVideoStateMgr rMVideoStateMgr = dynamicAvatarRecordActivity2.U;
                        if (currentTimeMillis - rMVideoStateMgr.f185895e >= 500) {
                            dynamicAvatarRecordActivity2.F0();
                        } else {
                            rMVideoStateMgr.q(false);
                            DynamicAvatarRecordActivity.this.U.M();
                            DynamicAvatarRecordActivity.this.Q0();
                        }
                        return true;
                    }
                } else {
                    DynamicAvatarRecordActivity.this.f199975d0.setVisibility(4);
                    DynamicAvatarRecordActivity.this.f199976e0.setVisibility(4);
                    DynamicAvatarRecordActivity.this.f199977f0.setText("0\"");
                    DynamicAvatarRecordActivity.this.f199977f0.setVisibility(0);
                    DynamicAvatarRecordActivity.this.f199978g0.setVisibility(4);
                    DynamicAvatarRecordActivity.this.f199980i0.setVisibility(4);
                    DynamicAvatarRecordActivity.this.f199981j0.setVisibility(4);
                    DynamicAvatarRecordActivity.this.f199983l0.setVisibility(4);
                    DynamicAvatarRecordActivity.this.f199984m0.setVisibility(0);
                    DynamicAvatarRecordActivity.this.f199985n0.setVisibility(0);
                    DynamicAvatarRecordActivity.this.f199982k0.setVisibility(4);
                    DynamicAvatarRecordActivity.this.f199985n0.setProgress(0.0f);
                    DynamicAvatarRecordActivity.this.U.f185895e = System.currentTimeMillis();
                    DynamicAvatarRecordActivity.this.U.o();
                    if (DynamicAvatarRecordActivity.this.S == 1) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    ReportController.o(null, "dc00898", "", "", "0X8007106", "0X8007106", i3, 0, "", "", "", "");
                    return true;
                }
            }
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class d implements CameraExceptionHandler.a {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DynamicAvatarRecordActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.a
        public void b(Exception exc) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) exc);
            } else if (QLog.isColorLevel()) {
                QLog.i("DynamicAvatarRecordActivity", 2, "[onCameraException]", exc);
            }
        }

        @Override // com.tencent.mobileqq.shortvideo.mediadevice.CameraExceptionHandler.a
        public void c(RuntimeException runtimeException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) runtimeException);
            } else if (QLog.isColorLevel()) {
                QLog.i("DynamicAvatarRecordActivity", 2, "[onDispatchThreadException]", runtimeException);
            }
        }
    }

    public DynamicAvatarRecordActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.U = RMVideoStateMgr.u();
        this.V = 0;
        this.W = 0;
        this.X = false;
        this.f199972a0 = new Handler();
        this.f199986o0 = true;
        this.f199987p0 = -1;
        this.f199988q0 = -1;
        this.f199995x0 = new AtomicBoolean(false);
        this.f199996y0 = new AtomicBoolean(false);
        this.f199997z0 = 0;
        this.A0 = new a();
        this.B0 = new c();
        this.C0 = new d();
    }

    private boolean C0() {
        int i3;
        this.f199976e0.setEnabled(false);
        this.U.stopWatching();
        F(104);
        this.f199973b0.removeViewAt(0);
        if (com.tencent.mobileqq.activity.richmedia.c.f185845b == 1) {
            com.tencent.mobileqq.activity.richmedia.c.f185845b = 2;
        } else {
            com.tencent.mobileqq.activity.richmedia.c.f185845b = 1;
        }
        if (com.tencent.mobileqq.activity.richmedia.c.f185845b == 1) {
            i3 = R.string.lth;
        } else {
            i3 = R.string.lto;
        }
        String qqStr = HardCodeUtil.qqStr(i3);
        this.f199976e0.setContentDescription(HardCodeUtil.qqStr(R.string.ltr) + qqStr + HardCodeUtil.qqStr(R.string.lts));
        O0(false);
        this.f199976e0.setEnabled(true);
        this.U.startWatching();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        long j3;
        if (this.U.I == null) {
            return;
        }
        this.f199995x0.getAndSet(true);
        long currentTimeMillis = System.currentTimeMillis();
        RMVideoStateMgr u16 = RMVideoStateMgr.u();
        if (VideoEnvironment.supportSubmitCallback()) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread, false).post(new Runnable(u16) { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RMVideoStateMgr f200003d;

                {
                    this.f200003d = u16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) DynamicAvatarRecordActivity.this, (Object) u16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.i("DynamicAvatarRecordActivity", 2, "stopRecord(): Async, mVideoFileDir:" + this.f200003d.M + ",is to call AVideoCodec.recordSubmit()");
                        }
                        com.tencent.mobileqq.shortvideo.mediadevice.c.b().c().recordSubmit();
                    } catch (UnsatisfiedLinkError e16) {
                        e16.printStackTrace();
                        synchronized (this.f200003d.f185905k0) {
                            this.f200003d.f185905k0.set(true);
                            this.f200003d.f185905k0.notifyAll();
                            if (QLog.isColorLevel()) {
                                QLog.d("DynamicAvatarRecordActivity", 2, "stopRecord(): Async, mVideoFileDir:" + this.f200003d.M + ", call AVideoCodec.recordSubmit() fail, error = " + e16.getMessage());
                            }
                        }
                    }
                }
            });
        } else {
            try {
                com.tencent.mobileqq.shortvideo.mediadevice.c.b().c().recordSubmit();
                if (QLog.isColorLevel()) {
                    QLog.d("DynamicAvatarRecordActivity", 2, " stopRecord Sync recordSubmit ...");
                }
            } catch (UnsatisfiedLinkError e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("DynamicAvatarRecordActivity", 2, " stopRecord...exception...UnsatisfiedLinkError");
                }
                e16.printStackTrace();
            }
        }
        if (VideoEnvironment.supportSubmitCallback()) {
            synchronized (u16.f185905k0) {
                j3 = 0;
                if (!u16.f185905k0.get()) {
                    try {
                        if (QLog.isColorLevel()) {
                            QLog.i("DynamicAvatarRecordActivity", 2, "[@] doInBackground before wait");
                        }
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        u16.f185905k0.wait(15000L);
                        j3 = SystemClock.elapsedRealtime() - elapsedRealtime;
                        if (QLog.isColorLevel()) {
                            QLog.i("DynamicAvatarRecordActivity", 2, "[@] doInBackground after wait, waitDuration = " + j3);
                        }
                    } catch (InterruptedException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.i("DynamicAvatarRecordActivity", 2, "[@] doInBackground, exception = " + e17.getMessage());
                        }
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("DynamicAvatarRecordActivity", 2, "[@] doInBackground after sync block");
            }
            if (j3 < 30) {
                int i3 = 30 - ((int) j3);
                if (QLog.isColorLevel()) {
                    QLog.d("DynamicAvatarRecordActivity", 2, "[@] doInBackground after sync block: needSleep=" + i3);
                }
                if (i3 < 10) {
                    i3 = 10;
                }
                try {
                    LockMethodProxy.sleep(i3);
                } catch (InterruptedException unused) {
                }
            }
        }
        PreviewContext previewContext = u16.I;
        if (previewContext == null) {
            return;
        }
        CodecParam.mRecordTime = (int) u16.H;
        CodecParam.mRecordFrames = previewContext.getFrameIndex();
        int i16 = CodecParam.mGopSize;
        CodecParam.mGopSize = -1;
        EncodeThread encodeThread = new EncodeThread(null, null, u16.M, null, null);
        encodeThread.setEnableHardEncode(true);
        encodeThread.setEnableDeleteCache(false);
        encodeThread.setEnableBaselineMp4Encode(true);
        encodeThread.run();
        CodecParam.mGopSize = i16;
        String str = encodeThread.mTargetFilePath;
        this.f199993v0 = str;
        if (!TextUtils.isEmpty(str)) {
            File file = new File(this.f199993v0);
            if (file.exists()) {
                FileUtils.createFileIfNotExits(file.getParent() + File.separator + ".nomedia");
            }
        }
        this.f199995x0.getAndSet(false);
        if (this.f199996y0.get()) {
            D0();
            I0();
        }
        if (QLog.isColorLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 2, "video encode finished, mVideoPath = " + this.f199993v0 + ", time cost = " + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        N0();
        K0();
        ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.6
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DynamicAvatarRecordActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    DynamicAvatarRecordActivity.this.E0();
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                }
            }
        }, null, true);
    }

    private int G0() {
        return ((((this.W - getResources().getDimensionPixelSize(R.dimen.dm_)) - getResources().getDimensionPixelSize(R.dimen.b3s)) - getResources().getDimensionPixelSize(R.dimen.b3v)) - getResources().getDimensionPixelSize(R.dimen.b3u)) - getResources().getDimensionPixelSize(R.dimen.dm9);
    }

    private void I0() {
        String str;
        this.f199996y0.set(false);
        Intent intent = new Intent(this, (Class<?>) SelectCoverActivity.class);
        intent.putExtra("param_source", this.S);
        intent.putExtra("param_from_newer_guide", this.T);
        intent.putExtra("key_video_file_path", this.f199993v0);
        intent.putExtra("key_video_duration", this.f199992u0);
        String str2 = "1";
        if (((Boolean) this.f199975d0.getTag()).booleanValue()) {
            str = "1";
        } else {
            str = "0";
        }
        intent.putExtra("key_video_has_voice", str);
        if (com.tencent.mobileqq.activity.richmedia.c.f185845b == 1) {
            str2 = "0";
        }
        intent.putExtra("key_camera_id", str2);
        startActivityForResult(intent, 1);
    }

    private void J0(Bundle bundle, boolean z16) {
        if (bundle == null) {
            return;
        }
        com.tencent.mobileqq.shortvideo.hwcodec.b.f288004b = bundle.getBoolean(PeakConstants.KEY_VIDEO_HARD_ENCODE_ENABLE, false);
        float f16 = bundle.getFloat(PeakConstants.KEY_VIDEO_PRESEND_SLINCE_DURATION, 1.5f);
        if (f16 > 0.0f) {
            com.tencent.mobileqq.shortvideo.hwcodec.b.f288003a = (int) (f16 * 1000.0f);
        }
        if (RMVideoStateMgr.E(z16)) {
            this.X = this.U.T(16);
        } else {
            this.U.T(4);
        }
    }

    private void L0() {
        if (this.f199997z0 == 1) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ITroopHWApi.ACTION_START_VIDEO_CHAT);
        intentFilter.addAction("tencent.av.v2q.StopVideoChat");
        try {
            registerReceiver(this.A0, intentFilter);
            this.f199997z0 = 1;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private void N0() {
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.5
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DynamicAvatarRecordActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                DynamicAvatarRecordActivity.this.f199977f0.setVisibility(4);
                DynamicAvatarRecordActivity.this.f199980i0.setVisibility(4);
                DynamicAvatarRecordActivity.this.f199981j0.setVisibility(0);
                DynamicAvatarRecordActivity.this.f199983l0.setVisibility(4);
                DynamicAvatarRecordActivity.this.f199984m0.setVisibility(4);
                DynamicAvatarRecordActivity.this.f199985n0.setVisibility(4);
                DynamicAvatarRecordActivity.this.f199982k0.setVisibility(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.8
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) DynamicAvatarRecordActivity.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                DynamicAvatarRecordActivity.this.f199975d0.setVisibility(0);
                DynamicAvatarRecordActivity.this.f199975d0.setEnabled(true);
                DynamicAvatarRecordActivity.this.f199976e0.setVisibility(0);
                DynamicAvatarRecordActivity.this.f199976e0.setEnabled(true);
                DynamicAvatarRecordActivity.this.f199977f0.setText("0\"");
                DynamicAvatarRecordActivity.this.f199977f0.setVisibility(4);
                DynamicAvatarRecordActivity dynamicAvatarRecordActivity = DynamicAvatarRecordActivity.this;
                if (dynamicAvatarRecordActivity.f199986o0) {
                    dynamicAvatarRecordActivity.f199978g0.setVisibility(0);
                } else {
                    dynamicAvatarRecordActivity.f199978g0.setVisibility(4);
                }
                DynamicAvatarRecordActivity.this.f199981j0.setVisibility(4);
                DynamicAvatarRecordActivity.this.f199980i0.setVisibility(0);
                DynamicAvatarRecordActivity.this.f199983l0.setVisibility(0);
                DynamicAvatarRecordActivity.this.f199983l0.setEnabled(true);
                DynamicAvatarRecordActivity.this.f199984m0.setVisibility(4);
                DynamicAvatarRecordActivity.this.f199985n0.setVisibility(4);
                DynamicAvatarRecordActivity.this.f199982k0.setVisibility(4);
            }
        });
    }

    private void R0(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 2, "showProgressDialog");
        }
        try {
            if (this.f199990s0 == null) {
                ReportProgressDialog reportProgressDialog = new ReportProgressDialog(this, R.style.qZoneInputDialog);
                this.f199990s0 = reportProgressDialog;
                reportProgressDialog.setCancelable(false);
                this.f199990s0.show();
                this.f199990s0.setContentView(R.layout.f168383uh);
            }
            ((TextView) this.f199990s0.findViewById(R.id.photo_prievew_progress_dialog_text)).setText(str);
            if (!this.f199990s0.isShowing()) {
                this.f199990s0.show();
            }
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.i("DynamicAvatarRecordActivity", 2, "showProgressDialog", th5);
            }
        }
    }

    public static void S0(Activity activity, int i3, int i16) {
        Class cls;
        if (((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68989c)) {
            cls = MX3DynamicAvatarRecordActivity.class;
        } else {
            cls = DynamicAvatarRecordActivity.class;
        }
        Intent intent = new Intent(activity, (Class<?>) cls);
        intent.putExtra("param_source", i3);
        activity.startActivityForResult(intent, i16);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "initUI_InitState()");
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "getFirstFrame()");
        }
        CameraGLSurfaceView cameraGLSurfaceView = this.f199974c0;
        if (cameraGLSurfaceView != null && cameraGLSurfaceView.getVisibility() != 0) {
            this.f199974c0.setVisibility(0);
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void D(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        this.f199992u0 = i3;
        this.U.S++;
        if (z16) {
            N0();
        } else {
            ThreadManager.getUIHandler().post(new Runnable(i3) { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.10
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f199998d;

                {
                    this.f199998d = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DynamicAvatarRecordActivity.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int i16 = this.f199998d / 1000;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(i16);
                    sb5.append("\"");
                    DynamicAvatarRecordActivity.this.f199977f0.setText(sb5);
                    DynamicAvatarRecordActivity.this.f199985n0.setProgress(this.f199998d / 80);
                }
            });
        }
    }

    protected void D0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 2, "dismissProgressDialog");
        }
        try {
            ProgressDialog progressDialog = this.f199990s0;
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void F(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "realDeleteVideoSegment(), delReason = " + i3);
        }
    }

    int H0(int i3, int i16, int[] iArr, boolean z16) {
        int i17;
        int i18;
        int measuredHeight = this.f199973b0.getMeasuredHeight();
        int i19 = (int) (i16 * com.tencent.mobileqq.activity.richmedia.c.f185844a);
        int i26 = this.V;
        if (measuredHeight <= i26) {
            i18 = (measuredHeight - ((int) (measuredHeight * 0.83f))) / 2;
            i26 = this.f199989r0;
            iArr[0] = i16;
            iArr[1] = i19;
            i17 = i26;
        } else {
            i17 = (i3 * i26) / i16;
            iArr[0] = i16;
            iArr[1] = (measuredHeight * i16) / i26;
            i18 = (measuredHeight - i26) / 2;
        }
        if (z16) {
            i17 = i26;
        }
        if (i26 % 2 != 0) {
            i26--;
        }
        if (i17 % 2 != 0) {
            i17--;
        }
        iArr[2] = i26;
        iArr[3] = i17;
        iArr[4] = i16;
        iArr[5] = i19;
        return i18;
    }

    public void K0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        int vFileAndAFile = this.f199979h0.getVFileAndAFile(this.U.M);
        boolean checkVideoSourceValidate = this.f199979h0.checkVideoSourceValidate(this.U);
        if (QLog.isColorLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 2, "playVideo getVFileAndAFile=" + this.U.M + ", errcode=" + vFileAndAFile + ", hasFrame=" + checkVideoSourceValidate);
        }
        if (vFileAndAFile == 0 && checkVideoSourceValidate) {
            if (this.U.A()) {
                if (QLog.isColorLevel()) {
                    QLog.i("DynamicAvatarRecordActivity", 2, "playVideo isCurrentPreviewState= true......");
                    return;
                }
                return;
            }
            this.f199979h0.mSecurityChecked = true;
            View n06 = BaseActivity2.n0(this.f199973b0, R.id.cdg);
            if (n06 != null) {
                this.f199973b0.removeView(n06);
            }
            this.U.f(4);
            if (QLog.isColorLevel()) {
                QLog.i("DynamicAvatarRecordActivity", 2, "replay totaltime = " + ((int) this.U.H));
                return;
            }
            return;
        }
        this.U.b(0, HardCodeUtil.qqStr(R.string.ltn), false);
        M0();
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void M() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "recordVideoFinish()");
        }
        this.U.p();
        this.U.stopWatching();
        F0();
    }

    public void M0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        RMVideoStateMgr rMVideoStateMgr = this.U;
        if (rMVideoStateMgr != null) {
            rMVideoStateMgr.q(false);
            this.U.M();
            this.f199977f0.setText("0\"");
            this.f199977f0.setVisibility(4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void O0(boolean z16) {
        PreviewContext previewContext;
        CameraPreview cameraPreview;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (BaseActivity2.n0(this.f199973b0, R.id.cdg) == null && z16) {
            previewContext = this.U.I;
        } else {
            previewContext = null;
        }
        if (VersionUtils.isIceScreamSandwich()) {
            CameraTextureView cameraTextureView = new CameraTextureView(this);
            if (previewContext != null && (previewContext instanceof e)) {
                cameraTextureView.f186031d = (e) previewContext;
            } else {
                cameraTextureView.f186031d = new e(this.Z, this.V, this.W);
            }
            this.U.S(cameraTextureView.f186031d);
            cameraPreview = cameraTextureView;
        } else {
            CameraPreview cameraPreview2 = new CameraPreview(this);
            if (previewContext != null && (previewContext instanceof com.tencent.mobileqq.shortvideo.mediadevice.d)) {
                cameraPreview2.f288132e = (com.tencent.mobileqq.shortvideo.mediadevice.d) previewContext;
            } else {
                cameraPreview2.f288132e = new com.tencent.mobileqq.shortvideo.mediadevice.d(this.Z, this.V, this.W);
            }
            this.U.S(cameraPreview2.f288132e);
            cameraPreview = cameraPreview2;
        }
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) super.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getDeviceConfigurationInfo();
        boolean isBeautySupported = VideoEnvironment.isBeautySupported();
        if (deviceConfigurationInfo != null && deviceConfigurationInfo.reqGlEsVersion >= 131072 && isBeautySupported) {
            CameraGLSurfaceView cameraGLSurfaceView = (CameraGLSurfaceView) findViewById(R.id.cej);
            this.f199974c0 = cameraGLSurfaceView;
            if (cameraGLSurfaceView != null) {
                cameraGLSurfaceView.setVideoContext(this.U.I);
            }
            layoutParams.height = 1;
            layoutParams.width = 1;
        } else {
            CameraGLSurfaceView cameraGLSurfaceView2 = (CameraGLSurfaceView) findViewById(R.id.cej);
            this.f199974c0 = cameraGLSurfaceView2;
            cameraGLSurfaceView2.setVisibility(8);
            this.f199974c0 = null;
        }
        cameraPreview.setId(R.id.cdg);
        this.f199973b0.addView(cameraPreview, 0, layoutParams);
        this.f199973b0.setCameraView(cameraPreview);
        this.Y = true;
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void U() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "addOneSegment_RecordState()");
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "initUI_previewState()");
        }
        this.f199979h0.initPlayer(CodecParam.RECORD_MAX_TIME, this.f199992u0, this.U.I.getFrameIndex(), this.U.M);
        this.f199979h0.setCyclePlay(true);
        this.U.f185900h.a();
        this.f199979h0.startPlayer();
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void W() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "initUI_RecordState()");
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void Y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this);
        } else if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "finishUI()");
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void d0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "notifyAvcodecOK()");
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.FlowActivity, com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void e0(int i3, int i16) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "previewSizeAdjustUI(), width = " + i3 + ", height = " + i16);
        }
        RMVideoStateMgr rMVideoStateMgr = this.U;
        if (rMVideoStateMgr == null) {
            if (QLog.isColorLevel()) {
                QLog.i("DynamicAvatarRecordActivity", 2, "[previewSizeAdjustUI]rmStateMgr == null");
                return;
            }
            return;
        }
        this.f199987p0 = i3;
        this.f199988q0 = i16;
        int[] iArr = new int[6];
        com.tencent.mobileqq.activity.richmedia.state.b bVar = rMVideoStateMgr.f185908m0;
        View view = this.f199974c0;
        if (view == null) {
            view = findViewById(R.id.cdg);
        }
        if (view == this.f199974c0) {
            z16 = true;
        } else {
            z16 = false;
        }
        H0(i3, i16, iArr, z16);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) BaseActivity2.o0(view);
        layoutParams.width = iArr[2];
        layoutParams.height = iArr[3];
        view.setLayoutParams(layoutParams);
        bVar.f185924c = iArr[0];
        bVar.f185925d = iArr[1];
        bVar.f185926e = 480;
        bVar.f185927f = 480;
        this.U.V(bVar, false);
        CameraGLSurfaceView cameraGLSurfaceView = this.f199974c0;
        if (cameraGLSurfaceView != null) {
            cameraGLSurfaceView.setPreviewSize(this.f199987p0, this.f199988q0, bVar);
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
        } else if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "onViewDestroy()");
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "initRecordEngineOK()");
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, z16);
        } else if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "deleteLastVideoSegment(), deleteNative = " + z16);
        }
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(i3), Integer.valueOf(i16), intent);
            return;
        }
        if (i16 == -1) {
            if (i3 == 1) {
                int i17 = this.S;
                if (i17 == 1) {
                    if (this.T) {
                        setResult(-1, intent);
                    } else {
                        setResult(-1);
                    }
                    finish();
                } else if (i17 == 2 && intent != null && !TextUtils.isEmpty(intent.getStringExtra("key_photo_file_path"))) {
                    setResult(-1, intent);
                    finish();
                }
            }
        } else if (i16 == 0) {
            this.U.q(false);
        }
        if (QLog.isColorLevel()) {
            QLog.d("DynamicAvatarRecordActivity", 2, "onActivityResult\uff0crequestCode:" + i3 + ",resultCode:" + i16);
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.FlowActivity, com.tencent.mobileqq.app.BaseActivity2, android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.U.H == 0.0d) {
            finish();
            return;
        }
        if (this.f199991t0 == null) {
            this.f199991t0 = ActionSheet.createFullScreenDialog(this, false);
        }
        this.f199991t0.setMainTitle(HardCodeUtil.qqStr(R.string.ltw));
        this.f199991t0.addButton(HardCodeUtil.qqStr(R.string.ltp), 3);
        this.f199991t0.addCancelButton(HardCodeUtil.qqStr(R.string.j6l));
        this.f199991t0.setOnButtonClickListener(new b());
        this.f199991t0.show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) view);
        } else {
            Button button = this.f199975d0;
            if (view == button) {
                if (((Boolean) button.getTag()).booleanValue()) {
                    this.U.R(false);
                    this.f199975d0.setTag(Boolean.FALSE);
                    this.f199975d0.setBackgroundResource(R.drawable.abx);
                    this.f199975d0.setContentDescription(HardCodeUtil.qqStr(R.string.ltl));
                } else {
                    this.U.R(true);
                    this.f199975d0.setTag(Boolean.TRUE);
                    this.f199975d0.setBackgroundResource(R.drawable.aby);
                    this.f199975d0.setContentDescription(HardCodeUtil.qqStr(R.string.ltq));
                }
                if (this.S == 1) {
                    i19 = 0;
                } else {
                    i19 = 1;
                }
                ReportController.o(null, "dc00898", "", "", "0X8007104", "0X8007104", i19, 0, "", "", "", "");
            } else if (view == this.f199976e0) {
                C0();
                if (this.S == 1) {
                    i18 = 0;
                } else {
                    i18 = 1;
                }
                ReportController.o(null, "dc00898", "", "", "0X8007105", "0X8007105", i18, 0, "", "", "", "");
            } else if (view == this.f199982k0) {
                VideoReport.reportEvent("dt_clck", view, null);
                this.f199996y0.set(true);
                if (this.f199995x0.get()) {
                    R0(HardCodeUtil.qqStr(R.string.ltg));
                } else if (!TextUtils.isEmpty(this.f199993v0) && new File(this.f199993v0).exists()) {
                    I0();
                } else {
                    this.f199996y0.set(false);
                    QQToast.makeText(this, HardCodeUtil.qqStr(R.string.ltf), 0).show();
                }
                if (this.S == 1) {
                    i17 = 0;
                } else {
                    i17 = 1;
                }
                ReportController.o(null, "dc00898", "", "", "0X8007109", "0X8007109", i17, 0, "", "", "", "");
            } else if (view == this.f199980i0) {
                if (this.S == 1) {
                    i16 = 0;
                } else {
                    i16 = 1;
                }
                ReportController.o(null, "dc00898", "", "", "0X8007107", "0X8007107", i16, 0, "", "", "", "");
                finish();
            } else if (view == this.f199981j0) {
                EncodeThread.cancelCurrentEncoder();
                this.f199979h0.stopPlayer();
                this.f199979h0.releasePlayer();
                O0(true);
                this.U.q(false);
                this.U.M();
                Q0();
                this.f199993v0 = null;
                if (this.S == 1) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                ReportController.o(null, "dc00898", "", "", "0X8007108", "0X8007108", i3, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.FlowActivity, com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.richmedia.FlowActivity, com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) bundle);
            return;
        }
        sendBroadcast(new Intent(PeakConstants.AE_BROADCAST_ACTION_AE_OPEN_CAMERA), "com.tencent.msg.permission.pushnotify");
        if (QLog.isColorLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 2, "DeviceInfo:PRODUCT=" + Build.PRODUCT + "|MODEL=" + DeviceInfoMonitor.getModel() + "|BOARD=" + Build.BOARD + "|BOOTLOADER=" + Build.BOOTLOADER + "|CPU_ABI=" + Build.CPU_ABI + "|CPU_ABI2=" + Build.CPU_ABI2 + "|DEVICE=" + Build.DEVICE + "|DISPLAY=" + Build.DISPLAY + "|FLNGERPRINT=" + Build.FINGERPRINT + "|HARDWARE=" + Build.HARDWARE + "|ID=" + Build.ID + "|MANUFACTURER=" + Build.MANUFACTURER + "|SDK_INT=" + Build.VERSION.SDK_INT + "|");
        }
        this.F = true;
        this.G = false;
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU.equals(Build.MANUFACTURER) && "M032".equals(DeviceInfoMonitor.getModel())) {
            this.f199986o0 = false;
        }
        PerfTracer.traceStart(PerfTracer.VIDEO_COMPONENT_ONCREATE);
        super.onCreate(bundle);
        if (isInMultiWindow()) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.ltm), 0).show();
            finish();
        } else if (f.j()) {
            QQToast.makeText(this, HardCodeUtil.qqStr(R.string.ltk), 0).show();
            finish();
        } else {
            PerfTracer.traceEnd(PerfTracer.VIDEO_COMPONENT_ONCREATE);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.richmedia.FlowActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        super.onDestroy();
        this.U.H();
        QQCustomDialog qQCustomDialog = this.f199994w0;
        if (qQCustomDialog != null) {
            qQCustomDialog.dismiss();
            this.f199994w0 = null;
        }
        sendBroadcast(new Intent(PeakConstants.AE_BROADCAST_ACTION_AE_CLOSE_CAMERA), "com.tencent.msg.permission.pushnotify");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.richmedia.FlowActivity, com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onPause();
        this.U.I();
        CameraGLSurfaceView cameraGLSurfaceView = this.f199974c0;
        if (cameraGLSurfaceView != null) {
            cameraGLSurfaceView.onPause();
        }
        View n06 = BaseActivity2.n0(this.f199973b0, R.id.cdg);
        if (n06 != null) {
            this.f199973b0.removeView(n06);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.richmedia.FlowActivity, com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        super.onResume();
        if (this.Y) {
            this.U.J();
        }
        if (BaseActivity2.n0(this.f199973b0, R.id.cdg) == null && this.U.f185904j0.get() != 4) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DynamicAvatarRecordActivity.this);
                    }
                }

                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return ((Boolean) iPatchRedirector2.redirect((short) 2, (Object) this)).booleanValue();
                    }
                    if (((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68988b)) {
                        DynamicAvatarRecordActivity.this.O0(true);
                    } else {
                        DynamicAvatarRecordActivity.this.O0(false);
                    }
                    CameraGLSurfaceView cameraGLSurfaceView = DynamicAvatarRecordActivity.this.f199974c0;
                    if (cameraGLSurfaceView != null) {
                        cameraGLSurfaceView.onResume();
                    }
                    DynamicAvatarRecordActivity.this.U.J();
                    DynamicAvatarRecordActivity.this.Q0();
                    if (QLog.isColorLevel()) {
                        QLog.i("PEAK_CAMERA", 2, "Added camera view.");
                    }
                    return false;
                }
            });
        }
        CameraGLSurfaceView cameraGLSurfaceView = this.f199974c0;
        if (cameraGLSurfaceView != null) {
            cameraGLSurfaceView.onResume();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            super.onStart();
            L0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onStop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onStop();
        try {
            ImageViewVideoPlayer imageViewVideoPlayer = this.f199979h0;
            if (imageViewVideoPlayer != null) {
                imageViewVideoPlayer.stopPlayer();
            }
            this.U.M();
            if (this.f199997z0 == 1) {
                unregisterReceiver(this.A0);
                this.f199997z0 = 0;
            }
        } catch (IllegalArgumentException e16) {
            if (QLog.isColorLevel()) {
                QLog.i("DynamicAvatarRecordActivity", 2, " already unregisterReceiver" + e16);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void p(int i3, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, this, Integer.valueOf(i3), str, Boolean.valueOf(z16));
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "errorOcured(), errCode = " + i3 + ", errMsg = " + str + ", isReport = " + z16);
        }
        runOnUiThread(new Runnable(str, i3) { // from class: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity.11
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f199999d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f200000e;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarRecordActivity$11$a */
            /* loaded from: classes11.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass11.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else {
                        DynamicAvatarRecordActivity.this.finish();
                    }
                }
            }

            {
                this.f199999d = str;
                this.f200000e = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, DynamicAvatarRecordActivity.this, str, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                String str2 = this.f199999d;
                if (this.f200000e == 2002) {
                    str2 = DynamicAvatarRecordActivity.this.getString(R.string.f171514fr0);
                }
                DynamicAvatarRecordActivity dynamicAvatarRecordActivity = DynamicAvatarRecordActivity.this;
                dynamicAvatarRecordActivity.f199994w0 = DialogUtil.createCustomDialog(dynamicAvatarRecordActivity, 230).setMessage(str2).setPositiveButton(DynamicAvatarRecordActivity.this.getString(R.string.c7n), new a());
                try {
                    DynamicAvatarRecordActivity.this.f199994w0.setCancelable(false);
                    DynamicAvatarRecordActivity.this.f199994w0.show();
                } catch (WindowManager.BadTokenException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("DynamicAvatarRecordActivity", 2, "", e16);
                    }
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return ((Integer) iPatchRedirector.redirect((short) 35, (Object) this)).intValue();
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "getCurrentBlockTimeLength()");
            return 0;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.richmedia.FlowActivity
    public void x0(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
            return;
        }
        super.x0(bundle);
        this.S = bundle.getInt("param_source", 0);
        this.T = bundle.getBoolean("param_from_newer_guide", false);
        if (this.S != 0) {
            com.tencent.mobileqq.activity.richmedia.c.f185845b = 1;
            if (!com.tencent.mobileqq.shortvideo.mediadevice.a.k()) {
                com.tencent.mobileqq.activity.richmedia.c.f185845b = 2;
            }
            com.tencent.mobileqq.activity.richmedia.c.f185844a = 1.0f;
            J0(bundle, false);
            this.U.y(4, 8);
            boolean G = this.U.G(this, getAppRuntime().getAccount(), this);
            this.U.U(false);
            if (!G) {
                QQToast.makeText(this, "\u521d\u59cb\u5316\u5931\u8d25", 0).show();
                super.finish();
                return;
            }
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i3 = displayMetrics.widthPixels;
            this.V = i3;
            this.W = displayMetrics.heightPixels;
            if (i3 <= 0) {
                DisplayMetrics displayMetrics2 = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displayMetrics2);
                this.V = displayMetrics2.widthPixels;
                this.W = displayMetrics2.heightPixels;
            }
            CameraProxy cameraProxy = new CameraProxy(this, this.f199972a0);
            this.Z = cameraProxy;
            this.U.Q(cameraProxy);
            this.Z.B(new CameraExceptionHandler(this.f199972a0, this.C0));
            return;
        }
        throw new IllegalArgumentException("source must not be null");
    }

    @Override // com.tencent.mobileqq.activity.richmedia.state.g
    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else if (QLog.isDevelopLevel()) {
            QLog.i("DynamicAvatarRecordActivity", 4, "initUI_IdleState()");
        }
    }

    @Override // com.tencent.mobileqq.activity.richmedia.FlowActivity
    protected void y0(ViewGroup viewGroup) {
        int i3;
        FrameLayout.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup);
            return;
        }
        View inflate = getLayoutInflater().inflate(R.layout.atr, viewGroup);
        this.f199973b0 = (CameraCover) findViewById(R.id.f165246ce0);
        VideoReport.addToDetectionWhitelist(this);
        VideoReport.setPageId(inflate, "pg_profile_dynamic_avatar");
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f199973b0.getLayoutParams();
        layoutParams2.height = Math.min(G0(), this.V);
        this.f199973b0.setLayoutParams(layoutParams2);
        this.f199989r0 = layoutParams2.height;
        Button button = (Button) findViewById(R.id.kzr);
        this.f199975d0 = button;
        button.setEnabled(false);
        this.f199975d0.setTag(Boolean.TRUE);
        this.f199975d0.setContentDescription(HardCodeUtil.qqStr(R.string.lti));
        Button button2 = (Button) findViewById(R.id.aoh);
        this.f199976e0 = button2;
        button2.setEnabled(false);
        if (com.tencent.mobileqq.activity.richmedia.c.f185845b == 1) {
            i3 = R.string.lte;
        } else {
            i3 = R.string.ltx;
        }
        String qqStr = HardCodeUtil.qqStr(i3);
        this.f199976e0.setContentDescription(HardCodeUtil.qqStr(R.string.ltu) + qqStr + HardCodeUtil.qqStr(R.string.ltv));
        this.f199977f0 = (TextView) findViewById(R.id.f166771i45);
        this.f199978g0 = (TextView) findViewById(R.id.fy9);
        this.f199979h0 = (ImageViewVideoPlayer) findViewById(R.id.ce5);
        this.f199980i0 = (TextView) findViewById(R.id.b_e);
        this.f199981j0 = (TextView) findViewById(R.id.b_i);
        TextView textView = (TextView) findViewById(R.id.b_f);
        this.f199982k0 = textView;
        VideoReport.setElementId(textView, "em_use_avatar_button");
        VideoReport.setElementClickPolicy(this.f199982k0, ClickPolicy.REPORT_ALL);
        ImageView imageView = (ImageView) findViewById(R.id.b_g);
        this.f199983l0 = imageView;
        imageView.setEnabled(false);
        this.f199983l0.setOnTouchListener(this.B0);
        this.f199984m0 = (ImageView) findViewById(R.id.b_h);
        CircleProgress circleProgress = (CircleProgress) findViewById(R.id.i3u);
        this.f199985n0 = circleProgress;
        circleProgress.setBgAndProgressColor(100, getResources().getColor(R.color.f158017al3), 100, getResources().getColor(R.color.f156818c9));
        this.f199985n0.setStrokeWidth(6.0f);
        this.f199982k0 = (TextView) findViewById(R.id.b_f);
        this.f199975d0.setOnClickListener(this);
        this.f199976e0.setOnClickListener(this);
        this.f199980i0.setOnClickListener(this);
        this.f199981j0.setOnClickListener(this);
        this.f199982k0.setOnClickListener(this);
        ImageView imageView2 = new ImageView(this);
        if (this.f199989r0 > 0) {
            int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.dm8);
            int i16 = this.f199989r0;
            imageView2.setImageBitmap(DynamicUtils.g(i16, i16, (i16 / 2) - dimensionPixelSize));
            layoutParams = new FrameLayout.LayoutParams(-1, -1);
        } else {
            imageView2.setImageBitmap(DynamicUtils.g(5, 5, 2));
            layoutParams = new FrameLayout.LayoutParams(1, 1);
        }
        this.f199973b0.addView(imageView2, -1, layoutParams);
    }
}
