package com.tencent.mobileqq.activity.shortvideo;

import android.content.res.Configuration;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.aelight.camera.videoplay.IHWVideoPlay;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.AndroidOUIWrapperUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.photo.PeakActivity;
import com.tencent.mobileqq.activity.shortvideo.a;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* loaded from: classes10.dex */
public class PreviewVideoActivity extends PeakActivity implements View.OnClickListener, ImageViewVideoPlayer.IMPlayerEndListener {
    private String P;
    private ImageViewVideoPlayer Q;
    private GLSurfaceView R;
    private int S;

    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 != R.id.b8q && id5 != R.id.ajj) {
            if (id5 == R.id.ajw) {
                setResult(-1);
                finish();
            }
        } else {
            finish();
            overridePendingTransition(R.anim.f154454a3, R.anim.f154458a7);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        a.C7209a b16;
        this.F = true;
        this.G = false;
        if (AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            AndroidOUIWrapperUtil.fixOrientation(this);
        }
        super.onCreate(bundle);
        setContentView(R.layout.bpw);
        try {
            if (VideoEnvironment.loadAVCodecSo() != 0) {
                QLog.e("PreviewVideoActivity", 4, "load so failed");
                finish();
            }
        } catch (Exception unused) {
            QLog.e("PreviewVideoActivity", 4, "load so failed");
            finish();
        }
        yq2.a.a();
        if (getIntent() == null) {
            QQToast.makeText(getApplicationContext(), HardCodeUtil.qqStr(R.string.pcv), 1).show();
            finish();
            return;
        }
        if (getIntent().getBooleanExtra("from_qzone_camera", false)) {
            String stringExtra = getIntent().getStringExtra(QzoneCameraConst.Tag.ARG_PARAM_VIDEO_PATH);
            String stringExtra2 = getIntent().getStringExtra("audio_path");
            if (TextUtils.isEmpty(stringExtra)) {
                QQToast.makeText(getApplicationContext(), HardCodeUtil.qqStr(R.string.pcu), 1).show();
                QLog.e("PreviewVideoActivity", 4, "videoPath is null");
                finish();
                return;
            } else {
                b16 = new a.C7209a();
                b16.f186311a = stringExtra;
                b16.f186312b = stringExtra2;
                findViewById(R.id.ic5).setVisibility(0);
                findViewById(R.id.ajj).setOnClickListener(this);
                findViewById(R.id.ajw).setOnClickListener(this);
            }
        } else {
            int intExtra = getIntent().getIntExtra("video_type", -1);
            if (intExtra != 0 && intExtra != 1) {
                QQToast.makeText(getApplicationContext(), HardCodeUtil.qqStr(R.string.pct), 1).show();
                QLog.e("PreviewVideoActivity", 4, "init error, mVideoType=" + intExtra);
                finish();
                return;
            }
            String stringExtra3 = getIntent().getStringExtra("video_source_path");
            this.P = stringExtra3;
            if (TextUtils.isEmpty(stringExtra3)) {
                QQToast.makeText(getApplicationContext(), HardCodeUtil.qqStr(R.string.pcw), 1).show();
                QLog.e("PreviewVideoActivity", 4, "init error, mSourcePath=" + this.P);
                finish();
                return;
            }
            findViewById(R.id.jfb).setVisibility(0);
            findViewById(R.id.b8q).setOnClickListener(this);
            b16 = a.b(this.P);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.kwo);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(displayMetrics.widthPixels, displayMetrics.heightPixels, 17);
        if (b16 != null) {
            this.R = ((IHWVideoPlay) QRoute.api(IHWVideoPlay.class)).getHWVideoPlayView(this);
            ((IHWVideoPlay) QRoute.api(IHWVideoPlay.class)).setFilePath(this.R, b16.f186311a, b16.f186312b);
            frameLayout.addView(this.R, layoutParams);
            ((IHWVideoPlay) QRoute.api(IHWVideoPlay.class)).startPlay(this.R);
            ((IHWVideoPlay) QRoute.api(IHWVideoPlay.class)).setRepeat(this.R, true);
            return;
        }
        this.S = getIntent().getBundleExtra(ShortVideoConstants.ENCODE_VIDEO_PARAMS).getInt(ShortVideoConstants.SV_TOTAL_FRAME_COUNT);
        ImageViewVideoPlayer imageViewVideoPlayer = new ImageViewVideoPlayer(getApplicationContext());
        this.Q = imageViewVideoPlayer;
        imageViewVideoPlayer.setCyclePlay(true);
        this.Q.updateUISize(displayMetrics.widthPixels, displayMetrics.heightPixels, false, ScreenUtil.dip2px(5.0f));
        frameLayout.addView(this.Q, layoutParams);
        this.Q.setIMPlayerEndListener(this);
    }

    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("PreviewVideoActivity", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        super.onDestroy();
        ImageViewVideoPlayer imageViewVideoPlayer = this.Q;
        if (imageViewVideoPlayer != null) {
            imageViewVideoPlayer.stopPlayer();
            this.Q.releasePlayer();
        }
        yq2.a.f();
        if (this.R != null) {
            ((IHWVideoPlay) QRoute.api(IHWVideoPlay.class)).stopPlay(this.R);
            this.R = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ImageViewVideoPlayer imageViewVideoPlayer = this.Q;
        if (imageViewVideoPlayer != null) {
            imageViewVideoPlayer.stopPlayer();
        }
        GLSurfaceView gLSurfaceView = this.R;
        if (gLSurfaceView != null) {
            gLSurfaceView.onPause();
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener
    public void onPlayerEnd() {
        if (!TextUtils.isEmpty(this.P)) {
            this.Q.initPlayer(0, 0, this.S, this.P);
            this.Q.startPlayer();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.photo.PeakActivity, com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.Q != null && !TextUtils.isEmpty(this.P)) {
            this.Q.initPlayer(0, 0, this.S, this.P);
            this.Q.startPlayer();
        }
        GLSurfaceView gLSurfaceView = this.R;
        if (gLSurfaceView != null) {
            gLSurfaceView.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity2, mqq.app.BaseActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ImageViewVideoPlayer imageViewVideoPlayer = this.Q;
        if (imageViewVideoPlayer != null) {
            imageViewVideoPlayer.stopPlayer();
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener
    public void onDrawLastFrameEnd() {
    }

    @Override // com.tencent.mobileqq.shortvideo.widget.ImageViewVideoPlayer.IMPlayerEndListener
    public void onPlayerRecyle() {
    }
}
