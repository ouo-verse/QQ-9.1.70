package com.tencent.biz;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.biz.JoinGroupHandler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes2.dex */
public class JoinGroupTransitActivity extends BaseActivity {

    /* renamed from: a0, reason: collision with root package name */
    private String f78149a0;

    /* renamed from: b0, reason: collision with root package name */
    private String f78150b0 = "";

    /* renamed from: c0, reason: collision with root package name */
    private JoinGroupHandler f78151c0;

    /* renamed from: d0, reason: collision with root package name */
    private long f78152d0;

    /* renamed from: e0, reason: collision with root package name */
    private b f78153e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f78154f0;

    /* renamed from: g0, reason: collision with root package name */
    private String f78155g0;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements JoinGroupHandler.b {
        a() {
        }

        @Override // com.tencent.biz.JoinGroupHandler.b
        public void a() {
            JoinGroupTransitActivity.this.f78153e0.sendEmptyMessage(3);
        }

        @Override // com.tencent.biz.JoinGroupHandler.b
        public void error() {
            JoinGroupTransitActivity.this.f78153e0.sendEmptyMessage(1);
        }

        @Override // com.tencent.biz.JoinGroupHandler.b
        public void success() {
            JoinGroupTransitActivity.this.f78153e0.sendEmptyMessage(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<JoinGroupTransitActivity> f78157a;

        public b(JoinGroupTransitActivity joinGroupTransitActivity) {
            this.f78157a = new WeakReference<>(joinGroupTransitActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            JoinGroupTransitActivity joinGroupTransitActivity = this.f78157a.get();
            if (message != null && joinGroupTransitActivity != null && !joinGroupTransitActivity.isFinishing()) {
                QLog.i("JoinGroupTransitActivity", 2, "handle message. what = " + message.what);
                int i3 = message.what;
                if (i3 != 0) {
                    if (i3 == 1 || i3 == 2 || i3 == 3) {
                        joinGroupTransitActivity.finish();
                        return;
                    }
                    return;
                }
                joinGroupTransitActivity.f78151c0.k(joinGroupTransitActivity.f78152d0, joinGroupTransitActivity.f78155g0);
            }
        }
    }

    public static String J2(String str, int i3, String str2) {
        return String.format("mqqapi://app/joinImmediately?source_id=3&version=1.0&src_type=app&pkg=com.tencent.mobileqq&cmp=com.tencent.biz.JoinGroupTransitActivity&group_code=%s&subsource_id=%s&authSig=%s", str, Integer.valueOf(i3), str2);
    }

    private void init() {
        try {
            String stringExtra = getIntent().getStringExtra("source_scheme");
            this.f78149a0 = stringExtra;
            if (TextUtils.isEmpty(stringExtra)) {
                finish();
            }
            this.f78153e0 = new b(this);
            ax c16 = bi.c(this.app, this, this.f78149a0);
            if (c16 != null) {
                this.f78150b0 = c16.f("activity_titile_name");
                this.f78152d0 = Long.parseLong(c16.f("group_code"));
                this.f78154f0 = Integer.parseInt(c16.f("subsource_id"));
                this.f78155g0 = c16.f("authSig");
            }
        } catch (Exception e16) {
            QLog.e("JoinGroupTransitActivity", 1, e16, "init exception");
            finish();
        }
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        init();
        JoinGroupHandler joinGroupHandler = new JoinGroupHandler(this, this.app, this.f78154f0, this.f78150b0, new a());
        this.f78151c0 = joinGroupHandler;
        joinGroupHandler.g();
        this.f78151c0.i(getIntent().getExtras());
        this.f78153e0.sendEmptyMessage(0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        this.f78151c0.h();
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }
}
