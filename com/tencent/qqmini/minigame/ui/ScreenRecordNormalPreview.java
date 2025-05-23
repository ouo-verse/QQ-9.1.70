package com.tencent.qqmini.minigame.ui;

import android.content.Context;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qqlive.module.videoreport.dtreport.audio.playback.ReportMediaPlayer;
import com.tencent.qqmini.minigame.R;
import com.tencent.qqmini.minigame.screenrecord.GuideBubbleViewCtrl;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;

/* loaded from: classes23.dex */
public class ScreenRecordNormalPreview extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private SurfaceView f346791d;

    /* renamed from: e, reason: collision with root package name */
    private MediaPlayer f346792e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f346793f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f346794h;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f346795i;

    /* renamed from: m, reason: collision with root package name */
    private GuideBubbleViewCtrl f346796m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes23.dex */
    public class b implements MediaPlayer.OnCompletionListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            ScreenRecordNormalPreview.this.f346792e.seekTo(0);
            ScreenRecordNormalPreview.this.f346792e.start();
        }
    }

    public ScreenRecordNormalPreview(@NonNull Context context) {
        super(context);
        this.f346796m = new GuideBubbleViewCtrl();
        d();
    }

    private void d() {
        LayoutInflater.from(getContext()).inflate(R.layout.mini_sdk_screen_recorder_preview_normal, (ViewGroup) this, true);
        this.f346795i = (FrameLayout) findViewById(R.id.fl_main);
        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.sv_player);
        this.f346791d = surfaceView;
        surfaceView.getHolder().setType(3);
        this.f346794h = (RelativeLayout) findViewById(R.id.rl_record_normal_container);
        this.f346793f = (TextView) findViewById(R.id.tv_total_time);
        float f16 = getContext().getResources().getDisplayMetrics().widthPixels;
        int i3 = (int) (0.53f * f16);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f346791d.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = (int) (((getContext().getResources().getDisplayMetrics().heightPixels * 1.0f) * i3) / f16);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f346795i.getLayoutParams();
        GuideBubbleView b16 = this.f346796m.b(2, getContext());
        if (b16 != null) {
            int i16 = R.id.screen_record_guide_result;
            b16.setId(i16);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams3.topMargin = DisplayUtil.dip2px(getContext(), 80.0f);
            this.f346794h.addView(b16, layoutParams3);
            layoutParams2.addRule(3, i16);
        }
        if (b16 != null) {
            ((RelativeLayout.LayoutParams) b16.getLayoutParams()).topMargin = DisplayUtil.dip2px(getContext(), 80.0f);
        } else {
            layoutParams2.topMargin = DisplayUtil.dip2px(getContext(), 80.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(String str) {
        try {
            this.f346792e.setLooping(true);
            this.f346792e.reset();
            this.f346792e.setAudioStreamType(3);
            this.f346792e.setDataSource(str);
            this.f346792e.setDisplay(this.f346791d.getHolder());
            this.f346792e.prepare();
            this.f346792e.start();
            h(this.f346792e.getDuration());
            this.f346792e.setOnCompletionListener(new b());
        } catch (Throwable th5) {
            QMLog.e("ScreenRecordPreview", "[playInner] error." + th5.getMessage());
        }
    }

    private void h(long j3) {
        final String O = ScreenRecDragableView.O((int) (j3 / 1000.0d));
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.qqmini.minigame.ui.ScreenRecordNormalPreview.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ScreenRecordNormalPreview.this.f346793f.setText(O);
                } catch (Throwable th5) {
                    QMLog.e("ScreenRecordPreview", "[setTotalTime], error:" + th5.getMessage());
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void e() {
        MediaPlayer mediaPlayer = this.f346792e;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f346792e.release();
            this.f346792e = null;
        }
    }

    public void g(String str) {
        if (TextUtils.isEmpty(str) || !FileUtils.fileExists(str)) {
            return;
        }
        if (this.f346792e == null) {
            this.f346792e = new ReportMediaPlayer();
        }
        this.f346791d.getHolder().addCallback(new a(str));
    }

    public ScreenRecordNormalPreview(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f346796m = new GuideBubbleViewCtrl();
        d();
    }

    /* loaded from: classes23.dex */
    class a implements SurfaceHolder.Callback {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f346798d;

        a(String str) {
            this.f346798d = str;
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            ScreenRecordNormalPreview.this.f(this.f346798d);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            QMLog.i("ScreenRecordPreview", "[surfaceDestroyed]");
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        }
    }
}
