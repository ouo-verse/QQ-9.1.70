package com.tencent.biz.qqstory.takevideo;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.f;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import hd0.c;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QQStoryTakeVideoCloseAnimationActivity extends QQStoryBaseActivity implements Handler.Callback {

    /* renamed from: g0, reason: collision with root package name */
    public static final String f94261g0 = AppConstants.SDCARD_FILE_SAVE_TMP_PATH + "qqstory/animation_cover.jpg";

    /* renamed from: h0, reason: collision with root package name */
    public static boolean f94262h0 = false;

    /* renamed from: a0, reason: collision with root package name */
    protected ImageView f94263a0;

    /* renamed from: b0, reason: collision with root package name */
    private Handler f94264b0;

    /* renamed from: c0, reason: collision with root package name */
    private float f94265c0;

    /* renamed from: d0, reason: collision with root package name */
    private float f94266d0;

    /* renamed from: e0, reason: collision with root package name */
    private float f94267e0;

    /* renamed from: f0, reason: collision with root package name */
    private float f94268f0;

    @TargetApi(14)
    public void G2(float f16, float f17, float f18, float f19) {
        gd0.a.a("Q.qqstory:QQStoryTakeVideoCloseAnimationActivity", HardCodeUtil.qqStr(R.string.f172490ra4), Float.valueOf(f16), ",bottom:", Float.valueOf(f19));
        this.f94264b0.removeMessages(1);
        float l3 = UIUtils.l(this);
        float m3 = UIUtils.m(this);
        float f26 = f19 - f16;
        float f27 = f18 - f17;
        ViewPropertyAnimator y16 = this.f94263a0.animate().setDuration(250L).scaleXBy(1.0f).scaleX(f27 / m3).scaleYBy(1.0f).scaleY(f26 / l3).x(((f27 / 2.0f) + f17) - (m3 / 2.0f)).y(((f26 / 2.0f) + f16) - (l3 / 2.0f));
        y16.setListener(new a());
        y16.start();
    }

    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.IphoneTitleBarActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        Bitmap decodeFile;
        f94262h0 = true;
        this.mNeedStatusTrans = false;
        this.mActNeedImmersive = false;
        this.f94264b0 = new Handler(this);
        super.doOnCreate(bundle);
        this.f94263a0 = new AutoPlayImageView(this);
        super.getWindow().addFlags(1024);
        super.setContentViewNoTitle(this.f94263a0);
        String stringExtra = getIntent().getStringExtra("path");
        this.f94265c0 = r5.getIntExtra("target_top", 0);
        this.f94266d0 = r5.getIntExtra("target_right", 0);
        this.f94267e0 = r5.getIntExtra("target_left", 0);
        this.f94268f0 = r5.getIntExtra("target_bottom", 0);
        c.a("Q.qqstory:QQStoryTakeVideoCloseAnimationActivity", "\u52a8\u753bactivity\u7ec8\u4e8e OnCreate \u4e86\uff01\uff01\uff01");
        this.f94263a0.setScaleType(ImageView.ScaleType.CENTER_CROP);
        try {
            decodeFile = BitmapFactory.decodeFile(stringExtra);
        } catch (OutOfMemoryError unused) {
            finish();
        }
        if (decodeFile == null) {
            finish();
            return false;
        }
        Bitmap copy = decodeFile.copy(Bitmap.Config.ARGB_8888, true);
        if (copy == null) {
            finish();
            return false;
        }
        this.f94263a0.setImageBitmap(copy);
        this.f94264b0.sendEmptyMessageDelayed(1, 3000L);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        f94262h0 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        super.doOnStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqstory.storyHome.QQStoryBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStop() {
        super.doOnStop();
        this.f94264b0.removeMessages(1);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            c.a("Q.qqstory:QQStoryTakeVideoCloseAnimationActivity", "\u52a8\u753b\u7b49\u8d85\u65f6\u4e86");
            G2(0.0f, 0.0f, 0.0f, 0.0f);
        }
        return true;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a extends f {
        a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            QQStoryTakeVideoCloseAnimationActivity.this.finish();
            QQStoryTakeVideoCloseAnimationActivity.this.overridePendingTransition(0, R.anim.f154550b4);
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            QQStoryTakeVideoCloseAnimationActivity.this.finish();
            QQStoryTakeVideoCloseAnimationActivity.this.overridePendingTransition(0, R.anim.f154550b4);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }
}
