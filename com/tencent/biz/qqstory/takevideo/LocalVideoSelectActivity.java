package com.tencent.biz.qqstory.takevideo;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.boundaries.extension.widgets.TrimTextureVideoView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LiuHaiUtils;
import cooperation.peak.PeakConstants;
import fd0.a;
import hd0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class LocalVideoSelectActivity extends QQStoryBaseActivity implements View.OnClickListener, ScrollFrameSelectBar.b {

    /* renamed from: a0, reason: collision with root package name */
    private TrimTextureVideoView f94232a0;

    /* renamed from: b0, reason: collision with root package name */
    private ScrollFrameSelectBar f94233b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f94234c0;

    /* renamed from: d0, reason: collision with root package name */
    private Button f94235d0;

    /* renamed from: e0, reason: collision with root package name */
    private TextView f94236e0;

    /* renamed from: f0, reason: collision with root package name */
    private LinearLayout f94237f0;

    /* renamed from: g0, reason: collision with root package name */
    private LocalMediaInfo f94238g0;

    /* renamed from: h0, reason: collision with root package name */
    private int f94239h0;

    /* renamed from: i0, reason: collision with root package name */
    private int f94240i0;

    /* renamed from: j0, reason: collision with root package name */
    private ImageView f94241j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f94242k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f94243l0;

    /* renamed from: n0, reason: collision with root package name */
    public int f94245n0;

    /* renamed from: o0, reason: collision with root package name */
    public int f94246o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f94247p0;

    /* renamed from: q0, reason: collision with root package name */
    public int f94248q0;

    /* renamed from: r0, reason: collision with root package name */
    public String f94249r0;

    /* renamed from: s0, reason: collision with root package name */
    public long f94250s0;

    /* renamed from: t0, reason: collision with root package name */
    public long f94251t0;

    /* renamed from: x0, reason: collision with root package name */
    private RelativeLayout f94255x0;

    /* renamed from: y0, reason: collision with root package name */
    private LinearLayout f94256y0;

    /* renamed from: m0, reason: collision with root package name */
    private int f94244m0 = 0;

    /* renamed from: u0, reason: collision with root package name */
    private int f94252u0 = -1;

    /* renamed from: v0, reason: collision with root package name */
    private int f94253v0 = -1;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f94254w0 = false;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f94257z0 = false;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements a.c {
        a() {
        }

        @Override // fd0.a.c
        public boolean d(fd0.a aVar, int i3, int i16) {
            LocalVideoSelectActivity.this.f94232a0.k();
            LocalVideoSelectActivity.this.f94232a0.t(true);
            return true;
        }
    }

    private void Q2() {
        this.f94257z0 = false;
        this.f94256y0 = (LinearLayout) findViewById(R.id.aau);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.aas);
        this.f94255x0 = relativeLayout;
        this.f94257z0 = LiuHaiUtils.initLiuHaiScreenUI_Common(this.f94256y0, relativeLayout, 0);
    }

    private void cancel() {
        finish();
    }

    protected void R2(int i3, int i16) {
        String format;
        int floor = (int) Math.floor((i16 - i3) / 1000.0f);
        int ceil = (int) Math.ceil(floor / 10.0f);
        if (this.f94254w0) {
            format = String.format(HardCodeUtil.qqStr(R.string.nth), Integer.valueOf(floor), Integer.valueOf(ceil));
        } else {
            format = String.format(HardCodeUtil.qqStr(R.string.nti), Integer.valueOf(floor));
        }
        this.f94236e0.setText(format);
    }

    @Override // com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar.b
    public void a0(int i3, int i16) {
        R2(i3, i16);
    }

    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnBackPressed() {
        cancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    @TargetApi(11)
    public boolean doOnCreate(@Nullable Bundle bundle) {
        LiuHaiUtils.initLiuHaiProperty(this);
        getWindow().addFlags(1024);
        if (LiuHaiUtils.needCloseFullScreen()) {
            LiuHaiUtils.closeFullScreen(this);
        }
        this.mNeedStatusTrans = false;
        this.mActNeedImmersive = false;
        this.isClearCoverLayer = false;
        super.doOnCreate(bundle);
        this.f94243l0 = getIntent().getBooleanExtra(ShortVideoConstants.FROM_SLIDESHOW_TO_SHARE, false);
        this.f94244m0 = getIntent().getIntExtra("video_index", 0);
        this.f94246o0 = getIntent().getIntExtra("start_index", 0);
        this.f94247p0 = getIntent().getIntExtra("end_index", 0);
        this.f94245n0 = getIntent().getIntExtra("scroll_x", 0);
        this.f94248q0 = getIntent().getIntExtra("entrance_type", 0);
        this.f94249r0 = getIntent().getStringExtra("op_entrance_type");
        this.f94250s0 = getIntent().getLongExtra("start_time", 0L);
        this.f94251t0 = getIntent().getLongExtra("end_time", 0L);
        setContentViewC(R.layout.b6x);
        c.t("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onCreate");
        Q2();
        this.f94241j0 = (ImageView) findViewById(R.id.gxf);
        LocalMediaInfo localMediaInfo = (LocalMediaInfo) getIntent().getParcelableExtra(ShortVideoConstants.MEDIA_INFO);
        this.f94238g0 = localMediaInfo;
        this.f94234c0 = localMediaInfo.path;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(this.f94234c0);
                this.f94238g0.mediaHeight = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                this.f94238g0.mediaWidth = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                this.f94238g0.rotation = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    e16.printStackTrace();
                }
            }
            mediaMetadataRetriever.release();
            this.f94237f0 = (LinearLayout) findViewById(R.id.gxe);
            this.f94235d0 = (Button) findViewById(R.id.gxh);
            this.f94236e0 = (TextView) findViewById(R.id.gxg);
            ScrollFrameSelectBar scrollFrameSelectBar = (ScrollFrameSelectBar) findViewById(R.id.gwq);
            this.f94233b0 = scrollFrameSelectBar;
            scrollFrameSelectBar.setMinDuration(2000);
            if (this.f94257z0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f94233b0.getLayoutParams();
                layoutParams.bottomMargin = 0;
                this.f94233b0.setLayoutParams(layoutParams);
            }
            this.f94232a0 = (TrimTextureVideoView) findViewById(R.id.eg6);
            this.f94235d0.setOnClickListener(this);
            this.f94237f0.setOnClickListener(this);
            this.f94233b0.setOnRangeValueChangeListener(this);
            this.f94233b0.post(new Runnable() { // from class: com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    LocalVideoSelectActivity.this.f94233b0.f(LocalVideoSelectActivity.this.f94234c0, (int) LocalVideoSelectActivity.this.f94238g0.mDuration, LocalVideoSelectActivity.this.f94239h0, LocalVideoSelectActivity.this.f94240i0, LocalVideoSelectActivity.this.f94242k0, LocalVideoSelectActivity.this.f94254w0, LocalVideoSelectActivity.this.getIntent().getBooleanExtra("readinjoy_video", false) ? 1 : 0);
                    ScrollFrameSelectBar scrollFrameSelectBar2 = LocalVideoSelectActivity.this.f94233b0;
                    LocalVideoSelectActivity localVideoSelectActivity = LocalVideoSelectActivity.this;
                    scrollFrameSelectBar2.g(localVideoSelectActivity.f94245n0, localVideoSelectActivity.f94246o0, localVideoSelectActivity.f94247p0, localVideoSelectActivity.f94251t0, localVideoSelectActivity.f94250s0);
                    if (QLog.isColorLevel()) {
                        QLog.d("Q.qqstory.publish.edit.LocalVideoSelectActivity", 2, "mScrollFrameSelectBar.post  scrollX : " + LocalVideoSelectActivity.this.f94245n0 + "startIndex : " + LocalVideoSelectActivity.this.f94246o0 + " endIndex : " + LocalVideoSelectActivity.this.f94247p0 + " endTime : " + LocalVideoSelectActivity.this.f94251t0 + " startTime : " + LocalVideoSelectActivity.this.f94250s0);
                    }
                }
            });
            this.f94232a0.setVideoPath(this.f94234c0);
            if (this.f94257z0) {
                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.f164579a60);
                ((ViewGroup) relativeLayout.getParent()).removeView(relativeLayout);
                ViewGroup.LayoutParams layoutParams2 = relativeLayout.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(layoutParams2.width, layoutParams2.height);
                layoutParams3.topMargin = ViewUtils.dip2px(14.0f);
                layoutParams3.leftMargin = ViewUtils.dip2px(12.0f);
                layoutParams3.rightMargin = ViewUtils.dip2px(12.0f);
                layoutParams3.addRule(10, -1);
                layoutParams3.addRule(12, 0);
                this.f94255x0.addView(relativeLayout, layoutParams3);
            }
            String stringExtra = getIntent().getStringExtra(PeakConstants.VIDEO_REFER);
            if (!"tribe".equals(stringExtra) && !"READINJOY_VIDEO".equals(stringExtra)) {
                TrimTextureVideoView trimTextureVideoView = this.f94232a0;
                LocalMediaInfo localMediaInfo2 = this.f94238g0;
                this.f94242k0 = trimTextureVideoView.v(localMediaInfo2.rotation, localMediaInfo2.mediaWidth, localMediaInfo2.mediaHeight);
            } else {
                this.f94232a0.setCenterInside(true);
            }
            this.f94241j0.setScaleType(ImageView.ScaleType.FIT_CENTER);
            LocalMediaInfo localMediaInfo3 = this.f94238g0;
            this.f94239h0 = Math.min(localMediaInfo3.mediaHeight, localMediaInfo3.mediaWidth);
            LocalMediaInfo localMediaInfo4 = this.f94238g0;
            this.f94240i0 = Math.max(localMediaInfo4.mediaHeight, localMediaInfo4.mediaWidth);
            this.f94233b0.setLocalVideoView(this.f94232a0);
            this.f94232a0.setOnPreparedListener(new a.e() { // from class: com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity.2
                @Override // fd0.a.e
                public void a(fd0.a aVar) {
                    c.t("Q.qqstory.publish.edit.LocalVideoSelectActivity", "video prrepared completed!");
                    LocalVideoSelectActivity.this.f94233b0.o();
                    LocalVideoSelectActivity.this.f94241j0.postDelayed(new Runnable() { // from class: com.tencent.biz.qqstory.takevideo.LocalVideoSelectActivity.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            LocalVideoSelectActivity.this.f94241j0.setVisibility(8);
                        }
                    }, 300L);
                }
            });
            this.f94232a0.setOnErrorListener(new a());
            id0.a.n("video_edit", "exp_cut", 0, 0, new String[0]);
            return false;
        } catch (Throwable th5) {
            mediaMetadataRetriever.release();
            throw th5;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        this.f94233b0.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        TrimTextureVideoView trimTextureVideoView = this.f94232a0;
        if (trimTextureVideoView != null && !trimTextureVideoView.isPlaying()) {
            this.f94232a0.t(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        super.doOnStop();
        TrimTextureVideoView trimTextureVideoView = this.f94232a0;
        if (trimTextureVideoView != null) {
            trimTextureVideoView.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    @Override // com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar.b
    public void n(int i3, int i16) {
        R2(i3, i16);
        if (this.f94252u0 < 0 || this.f94253v0 < 0) {
            this.f94252u0 = i3;
            this.f94253v0 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        if ((i3 == 10002 || i3 == 10012 || i3 == 10013) && i16 == -1) {
            c.m("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult from edit video activity, requestCode=%d, resultCode=%d", Integer.valueOf(i3), Integer.valueOf(i16));
            setResult(i16, intent);
            finish();
            return;
        }
        c.m("Q.qqstory.publish.edit.LocalVideoSelectActivity", "onActivityResult, requestCode=%d, resultCode=%d", Integer.valueOf(i3), Integer.valueOf(i16));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f94235d0) {
            if (this.f94243l0) {
                this.f94232a0.k();
                int p16 = this.f94232a0.p();
                int n3 = this.f94232a0.n();
                int j3 = this.f94233b0.j();
                int l3 = this.f94233b0.l();
                int i3 = this.f94233b0.i();
                Intent intent = new Intent();
                intent.putExtra("start_time", p16);
                intent.putExtra("end_time", n3);
                intent.putExtra("video_index", this.f94244m0);
                intent.putExtra("start_index", l3);
                intent.putExtra("end_index", i3);
                intent.putExtra("scroll_x", j3);
                setResult(-1, intent);
                id0.a.n("pic_choose", "done_cutVideo", this.f94248q0, 0, this.f94249r0, p16 + "-" + n3);
                finish();
            }
        } else if (view == this.f94237f0) {
            cancel();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.IphoneTitleBarActivity, mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        requestWindowFeature(1);
    }
}
