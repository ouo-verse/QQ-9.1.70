package com.sina.weibo.sdk.share;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
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
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.sina.weibo.sdk.api.StoryMessage;
import com.sina.weibo.sdk.api.StoryObject;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ShareStoryActivity extends BaseActivity {
    private e B;

    /* renamed from: v, reason: collision with root package name */
    private Intent f61276v;

    /* renamed from: w, reason: collision with root package name */
    private FrameLayout f61277w;

    /* renamed from: y, reason: collision with root package name */
    private Handler f61278y = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.share.ShareStoryActivity.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            ShareStoryActivity.this.a(1, "cancel");
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        Handler handler = this.f61278y;
        if (handler != null) {
            handler.removeMessages(0);
            this.f61278y = null;
        }
        a(2, str);
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
        Handler handler = this.f61278y;
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
        Intent intent = getIntent();
        this.f61276v = intent;
        if (intent == null) {
            finish();
            return;
        }
        if (intent.getIntExtra("start_flag", -1) != 0) {
            finish();
            return;
        }
        this.f61277w = new FrameLayout(this);
        int intExtra = getIntent().getIntExtra("progress_id", -1);
        if (intExtra != -1) {
            progressBar = ((LayoutInflater) getSystemService("layout_inflater")).inflate(intExtra, (ViewGroup) null);
        } else {
            progressBar = new ProgressBar(this);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f61277w.addView(progressBar, layoutParams);
        this.f61277w.setBackgroundColor(855638016);
        setContentView(this.f61277w);
        if (this.f61276v.getExtras() == null) {
            finish();
            return;
        }
        StoryMessage storyMessage = (StoryMessage) getIntent().getParcelableExtra("_weibo_message_stroy");
        if (storyMessage == null) {
            c("StoryMessage is null.");
            return;
        }
        if (storyMessage.checkResource() && com.sina.weibo.sdk.a.b(this)) {
            e eVar = this.B;
            if (eVar != null) {
                eVar.cancel(true);
            }
            e eVar2 = new e(this, new b() { // from class: com.sina.weibo.sdk.share.ShareStoryActivity.2
                @Override // com.sina.weibo.sdk.share.b
                public final void a(c cVar) {
                    ShareStoryActivity.this.f61277w.setVisibility(4);
                    if (cVar == null) {
                        ShareStoryActivity.this.c("Trans result is null.");
                        return;
                    }
                    if (cVar.F) {
                        ShareStoryActivity.a(ShareStoryActivity.this, cVar.H);
                    } else if (TextUtils.isEmpty(cVar.errorMessage)) {
                        ShareStoryActivity.this.c("Trans story fail.");
                    } else {
                        ShareStoryActivity.this.c(cVar.errorMessage);
                    }
                }
            });
            this.B = eVar2;
            eVar2.execute(storyMessage);
            return;
        }
        c("StoryMessage's resource is error.");
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Handler handler = this.f61278y;
        if (handler != null) {
            handler.removeMessages(0);
            this.f61278y = null;
        }
        if (intent.getIntExtra("backType", 0) == 0) {
            a(1, "cancel");
        } else {
            a(0, FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i3, String str) {
        FrameLayout frameLayout = this.f61277w;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        try {
            try {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putInt("_weibo_resp_errcode", i3);
                bundle.putString("_weibo_resp_errstr", str);
                intent.putExtras(bundle);
                setResult(-1, intent);
                Handler handler = this.f61278y;
                if (handler != null) {
                    handler.removeMessages(0);
                    this.f61278y = null;
                }
                finish();
            } catch (Exception e16) {
                e16.printStackTrace();
                Handler handler2 = this.f61278y;
                if (handler2 != null) {
                    handler2.removeMessages(0);
                    this.f61278y = null;
                }
                finish();
            }
        } catch (Throwable th5) {
            Handler handler3 = this.f61278y;
            if (handler3 != null) {
                handler3.removeMessages(0);
                this.f61278y = null;
            }
            finish();
            throw th5;
        }
    }

    static /* synthetic */ void a(ShareStoryActivity shareStoryActivity, StoryObject storyObject) {
        try {
            Intent intent = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL, Uri.parse("sinaweibo://story/publish?forceedit=1&finish=true"));
            intent.setPackage("com.sina.weibo");
            intent.putExtra("storyData", storyObject);
            shareStoryActivity.startActivityForResult(intent, 10001);
        } catch (Exception e16) {
            shareStoryActivity.c(e16.getMessage());
        }
    }
}
