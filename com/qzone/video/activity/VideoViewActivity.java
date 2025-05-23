package com.qzone.video.activity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.common.activities.base.BaseFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes37.dex */
public class VideoViewActivity extends BaseFragment {
    private FrameLayout C;
    private String D;
    private long E;
    private long F;
    private FixedSizeVideoView G;
    String H = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastVideoPreviewParamError", "\u9884\u89c8\u89c6\u9891\u53c2\u6570\u9519\u8bef");
    String I = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastPreviewNoParam", "\u9884\u89c8\u89c6\u9891\u65e0\u53c2\u6570");

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            VideoViewActivity.this.finish();
            VideoViewActivity.this.overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements MediaPlayer.OnErrorListener {
        b() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i3, int i16) {
            QQToast.makeText(VideoViewActivity.this.getApplicationContext(), VideoViewActivity.this.H, 1).show();
            QLog.e("VideoViewActivity", 1, "onError: what=" + i3 + "extra=" + i16);
            VideoViewActivity.this.finish();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class c implements MediaPlayer.OnPreparedListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ DisplayMetrics f60044d;

        c(DisplayMetrics displayMetrics) {
            this.f60044d = displayMetrics;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            int videoWidth = mediaPlayer.getVideoWidth();
            int videoHeight = mediaPlayer.getVideoHeight();
            ViewGroup.LayoutParams layoutParams = VideoViewActivity.this.G.getLayoutParams();
            int i3 = this.f60044d.widthPixels;
            layoutParams.width = i3;
            layoutParams.height = (i3 * videoHeight) / videoWidth;
            VideoViewActivity.this.G.setLayoutParams(layoutParams);
            if (VideoViewActivity.this.F == VideoViewActivity.this.E) {
                VideoViewActivity videoViewActivity = VideoViewActivity.this;
                videoViewActivity.F = videoViewActivity.E + mediaPlayer.getDuration();
            }
            VideoViewActivity.this.G.setPlayDuration((int) VideoViewActivity.this.E, (int) (VideoViewActivity.this.F - VideoViewActivity.this.E));
            VideoViewActivity.this.G.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class d implements FixedSizeVideoView.c {
        d() {
        }

        @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.c
        public void a(FixedSizeVideoView fixedSizeVideoView, int i3, int i16) {
            fixedSizeVideoView.pause();
            fixedSizeVideoView.seekTo(i3);
            fixedSizeVideoView.start();
        }

        @Override // com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView.c
        public void b(MediaPlayer mediaPlayer) {
            mediaPlayer.seekTo((int) VideoViewActivity.this.E);
            mediaPlayer.start();
        }
    }

    private void wh() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3, 17);
        FixedSizeVideoView fixedSizeVideoView = new FixedSizeVideoView(getApplicationContext());
        this.G = fixedSizeVideoView;
        this.C.addView(fixedSizeVideoView, layoutParams);
        this.G.setOnErrorListener(new b());
        this.G.setOnPreparedListener(new c(displayMetrics));
        this.G.setOnFixVDPlayCompelteListener(new d());
        this.G.setVideoPath(this.D);
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        yq2.a.f();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        FixedSizeVideoView fixedSizeVideoView = this.G;
        if (fixedSizeVideoView != null) {
            fixedSizeVideoView.pause();
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        FixedSizeVideoView fixedSizeVideoView = this.G;
        if (fixedSizeVideoView != null) {
            fixedSizeVideoView.start();
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        FixedSizeVideoView fixedSizeVideoView = this.G;
        if (fixedSizeVideoView != null) {
            fixedSizeVideoView.suspend();
        }
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        requestWindowFeature(1);
        getWindow().setFlags(1024, 1024);
        if (getIntent() == null) {
            QQToast.makeText(getApplicationContext(), this.I, 1).show();
            QLog.e("VideoViewActivity", 1, "init error, intent == null");
            finish();
            return;
        }
        int intExtra = getIntent().getIntExtra("video_type", -1);
        if (intExtra != 1) {
            QQToast.makeText(getApplicationContext(), this.H, 1).show();
            QLog.e("VideoViewActivity", 1, "init error, mVideoType=" + intExtra);
            finish();
            return;
        }
        String stringExtra = getIntent().getStringExtra("video_source_path");
        this.D = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            QQToast.makeText(getApplicationContext(), this.H, 1).show();
            QLog.e("VideoViewActivity", 1, "init error, mSourcePath=" + this.D);
            finish();
            return;
        }
        this.E = getIntent().getLongExtra("start_time", -1L);
        long longExtra = getIntent().getLongExtra("end_time", -1L);
        this.F = longExtra;
        if (this.E >= 0 && longExtra >= 0) {
            yq2.a.a();
            this.C = (FrameLayout) findViewById(R.id.kwo);
            findViewById(R.id.b8q).setOnClickListener(new a());
            wh();
            return;
        }
        QQToast.makeText(getApplicationContext(), this.H, 1).show();
        QLog.e("VideoViewActivity", 1, "init error, mStartTime=" + this.E + ", mEndTime=" + this.F);
        finish();
    }

    @Override // com.qzone.common.activities.base.BaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.bpw, viewGroup, false);
    }
}
