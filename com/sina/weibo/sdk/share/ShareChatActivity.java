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
import com.sina.weibo.sdk.api.ChatObject;
import com.sina.weibo.sdk.b.b;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mobileqq.profilecard.bussiness.anonymous.jsp.AskAnonymouslyApiPlugin;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.storage.database.DbConst;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ShareChatActivity extends BaseActivity {

    /* renamed from: v, reason: collision with root package name */
    private Intent f61270v;

    /* renamed from: w, reason: collision with root package name */
    private FrameLayout f61271w;

    /* renamed from: x, reason: collision with root package name */
    private com.sina.weibo.sdk.b.d f61272x;

    /* renamed from: y, reason: collision with root package name */
    private Handler f61273y = new Handler(Looper.getMainLooper()) { // from class: com.sina.weibo.sdk.share.ShareChatActivity.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            ShareChatActivity.a(ShareChatActivity.this);
        }
    };

    static /* synthetic */ void a(ShareChatActivity shareChatActivity) {
        FrameLayout frameLayout = shareChatActivity.f61271w;
        if (frameLayout != null) {
            frameLayout.setVisibility(8);
        }
        try {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("_weibo_resp_errcode", 1);
            intent.putExtras(bundle);
            shareChatActivity.setResult(-1, intent);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        Handler handler = shareChatActivity.f61273y;
        if (handler != null) {
            handler.removeMessages(0);
            shareChatActivity.f61273y = null;
        }
        shareChatActivity.finish();
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
        Handler handler = this.f61273y;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(0, 100L);
        }
    }

    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sina.weibo.sdk.share.BaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        View progressBar;
        com.sina.weibo.sdk.b.b bVar;
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.f61270v = intent;
        if (intent == null) {
            finish();
            return;
        }
        if (intent.getIntExtra("start_flag", -1) != 0) {
            finish();
            return;
        }
        this.f61271w = new FrameLayout(this);
        int intExtra = getIntent().getIntExtra("progress_id", -1);
        if (intExtra != -1) {
            progressBar = ((LayoutInflater) getSystemService("layout_inflater")).inflate(intExtra, (ViewGroup) null);
        } else {
            progressBar = new ProgressBar(this);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.f61271w.addView(progressBar, layoutParams);
        this.f61271w.setBackgroundColor(855638016);
        setContentView(this.f61271w);
        Bundle extras = this.f61270v.getExtras();
        if (extras == null) {
            finish();
            return;
        }
        final ChatObject chatObject = (ChatObject) extras.getParcelable("chat_object");
        if (chatObject != null) {
            com.sina.weibo.sdk.b.d dVar = this.f61272x;
            if (dVar != null) {
                dVar.T.cancel(true);
            }
            this.f61272x = new com.sina.weibo.sdk.b.d(this, chatObject, new com.sina.weibo.sdk.net.c<String>() { // from class: com.sina.weibo.sdk.share.ShareChatActivity.2
                @Override // com.sina.weibo.sdk.net.c
                public final /* synthetic */ void a(String str) {
                    String str2 = str;
                    ShareChatActivity.this.f61271w.setVisibility(4);
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            int optInt = jSONObject.optInt("code");
                            String optString = jSONObject.optString(HippyReporter.EXTRA_KEY_REPORT_ERRMSG);
                            String optString2 = jSONObject.optString("data");
                            if (optInt == 0 && !TextUtils.isEmpty(optString2)) {
                                JSONObject jSONObject2 = new JSONObject(optString2);
                                ShareChatActivity.a(ShareChatActivity.this, chatObject, jSONObject2.optString("short_url"), jSONObject2.optString(DbConst.OBJECT_ID));
                                return;
                            }
                            ShareChatActivity.a(ShareChatActivity.this, optString + "(" + optInt + ")");
                        } catch (JSONException e16) {
                            e16.printStackTrace();
                        }
                    }
                }

                @Override // com.sina.weibo.sdk.net.c
                public final void onError(Throwable th5) {
                    ShareChatActivity.this.f61271w.setVisibility(4);
                    ShareChatActivity.a(ShareChatActivity.this, th5.getMessage());
                }
            });
            bVar = b.a.Q;
            bVar.a(this.f61272x);
            return;
        }
        this.f61271w.setVisibility(4);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Handler handler = this.f61273y;
        if (handler != null) {
            handler.removeMessages(0);
            this.f61273y = null;
        }
        setResult(-1, intent);
        finish();
    }

    static /* synthetic */ void a(ShareChatActivity shareChatActivity, ChatObject chatObject, String str, String str2) {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("page_url", str);
            bundle.putString("page_id", str2);
            bundle.putInt(MiniAppPlugin.ATTR_PAGE_TYPE, 0);
            bundle.putInt("composer_launch_type", 4002);
            bundle.putBoolean("page_showcard", true);
            bundle.putString("page_pic", chatObject.image_url);
            bundle.putString("page_title", chatObject.content);
            Intent intent = new Intent();
            intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
            intent.setData(Uri.parse("sinaweibo://extendthirdshare"));
            intent.setPackage("com.sina.weibo");
            Bundle bundle2 = new Bundle();
            bundle2.putBundle("param_bundle", bundle);
            bundle2.putInt(AskAnonymouslyApiPlugin.KEY_SHARE_TYPE, 1001);
            intent.putExtras(bundle2);
            shareChatActivity.startActivityForResult(intent, 10001);
        } catch (Exception unused) {
        }
    }

    static /* synthetic */ void a(ShareChatActivity shareChatActivity, String str) {
        FrameLayout frameLayout = shareChatActivity.f61271w;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putInt("_weibo_resp_errcode", 2);
        bundle.putString("_weibo_resp_errstr", str);
        intent.putExtras(bundle);
        shareChatActivity.setResult(-1, intent);
        shareChatActivity.finish();
    }
}
