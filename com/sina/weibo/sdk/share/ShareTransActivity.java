package com.sina.weibo.sdk.share;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.c.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ShareTransActivity extends BaseActivity {
    private d D;

    /* renamed from: v, reason: collision with root package name */
    private Intent f61279v;

    /* renamed from: w, reason: collision with root package name */
    private FrameLayout f61280w;

    /* renamed from: y, reason: collision with root package name */
    private Handler f61281y = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.share.ShareTransActivity.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            ShareTransActivity.a(ShareTransActivity.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        FrameLayout frameLayout = this.f61280w;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_resp_errcode", 2);
        bundle.putString("_weibo_resp_errstr", str);
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i3, int i16, Intent intent) {
        super.onActivityResult(i3, i16, intent);
        com.sina.weibo.sdk.c.c.a("WBShareTag", "onActivityResult.");
        Handler handler = this.f61281y;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(0, 100L);
        }
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        View progressBar;
        super.onCreate(bundle);
        com.sina.weibo.sdk.c.c.a("WBShareTag", "start share activity.");
        Intent intent = getIntent();
        this.f61279v = intent;
        if (intent == null) {
            finish();
            return;
        }
        if (intent.getIntExtra("start_flag", -1) != 0) {
            finish();
            return;
        }
        this.f61280w = new FrameLayout(this);
        int intExtra = getIntent().getIntExtra("progress_id", -1);
        if (intExtra != -1) {
            progressBar = ((LayoutInflater) getSystemService("layout_inflater")).inflate(intExtra, (ViewGroup) null);
        } else {
            progressBar = new ProgressBar(this);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f61280w.addView(progressBar, layoutParams);
        this.f61280w.setBackgroundColor(855638016);
        setContentView(this.f61280w);
        com.sina.weibo.sdk.c.c.a("WBShareTag", "prepare wb resource.");
        Bundle extras = this.f61279v.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
        weiboMultiMessage.readFromBundle(extras);
        if (weiboMultiMessage.multiImageObject == null && weiboMultiMessage.videoSourceObject == null) {
            a(weiboMultiMessage);
            return;
        }
        d dVar = this.D;
        if (dVar != null) {
            dVar.cancel(true);
        }
        d dVar2 = new d(this, new b() { // from class: com.sina.weibo.sdk.share.ShareTransActivity.2
            @Override // com.sina.weibo.sdk.share.b
            public final void a(c cVar) {
                ShareTransActivity.this.f61280w.setVisibility(4);
                if (cVar == null) {
                    ShareTransActivity.this.c("Trans result is null.");
                    return;
                }
                if (cVar.F) {
                    ShareTransActivity.this.a(cVar.G);
                } else if (TextUtils.isEmpty(cVar.errorMessage)) {
                    ShareTransActivity.this.c("Trans resource fail.");
                } else {
                    ShareTransActivity.this.c(cVar.errorMessage);
                }
            }
        });
        this.D = dVar2;
        dVar2.execute(weiboMultiMessage);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        com.sina.weibo.sdk.c.c.a("WBShareTag", "start share activity again.");
        Handler handler = this.f61281y;
        if (handler != null) {
            handler.removeMessages(0);
            this.f61281y = null;
        }
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(WeiboMultiMessage weiboMultiMessage) {
        com.sina.weibo.sdk.c.c.a("WBShareTag", "start wb composer");
        try {
            this.f61279v.putExtra("start_flag", -1);
            Bundle extras = this.f61279v.getExtras();
            Intent intent = new Intent("com.sina.weibo.sdk.action.ACTION_WEIBO_ACTIVITY");
            intent.putExtras(weiboMultiMessage.writeToBundle(extras));
            intent.putExtra("_weibo_sdkVersion", "0041005000");
            intent.putExtra("_weibo_appPackage", getPackageName());
            intent.putExtra("_weibo_appKey", com.sina.weibo.sdk.a.a().getAppKey());
            intent.putExtra("_weibo_flag", 538116905);
            intent.putExtra("_weibo_sign", com.sina.weibo.sdk.c.d.e(com.sina.weibo.sdk.c.e.e(this, getPackageName())));
            String stringExtra = this.f61279v.getStringExtra("start_web_activity");
            if (!TextUtils.isEmpty(stringExtra) && "com.sina.weibo.sdk.web.WebActivity".equals(stringExtra)) {
                intent.setClassName(this, stringExtra);
                startActivityForResult(intent, 10001);
            } else {
                if (com.sina.weibo.sdk.a.a(this)) {
                    a.C0511a c16 = com.sina.weibo.sdk.c.a.c(this);
                    if (c16 != null) {
                        intent.setPackage(c16.packageName);
                    }
                    startActivityForResult(intent, 10001);
                    return;
                }
                c("Start weibo client's composer fail. And Weibo client is not installed.");
            }
        } catch (Throwable th5) {
            com.sina.weibo.sdk.c.c.b("WBShareTag", "start wb composer fail," + th5.getMessage());
            c("Start weibo client's composer fail. " + th5.getMessage());
        }
    }

    static /* synthetic */ void a(ShareTransActivity shareTransActivity) {
        FrameLayout frameLayout = shareTransActivity.f61280w;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        try {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("_weibo_resp_errcode", 1);
            intent.putExtras(bundle);
            shareTransActivity.setResult(-1, intent);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        Handler handler = shareTransActivity.f61281y;
        if (handler != null) {
            handler.removeMessages(0);
            shareTransActivity.f61281y = null;
        }
        shareTransActivity.finish();
    }
}
