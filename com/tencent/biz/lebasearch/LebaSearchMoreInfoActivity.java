package com.tencent.biz.lebasearch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes2.dex */
public class LebaSearchMoreInfoActivity extends AbsBaseWebViewActivity {

    /* renamed from: a0, reason: collision with root package name */
    View f78571a0;

    /* renamed from: b0, reason: collision with root package name */
    TextView f78572b0;

    /* renamed from: c0, reason: collision with root package name */
    FrameLayout f78573c0;

    /* renamed from: d0, reason: collision with root package name */
    String f78574d0;

    /* renamed from: e0, reason: collision with root package name */
    String f78575e0;

    /* renamed from: f0, reason: collision with root package name */
    long f78576f0;

    /* renamed from: k0, reason: collision with root package name */
    com.tencent.biz.troop.b f78581k0;

    /* renamed from: g0, reason: collision with root package name */
    boolean f78577g0 = false;

    /* renamed from: h0, reason: collision with root package name */
    String f78578h0 = null;

    /* renamed from: i0, reason: collision with root package name */
    QQCustomDialog f78579i0 = null;

    /* renamed from: j0, reason: collision with root package name */
    Handler f78580j0 = new a();

    /* renamed from: l0, reason: collision with root package name */
    public BusinessObserver f78582l0 = new b();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1001) {
                Bundle bundle = (Bundle) message.obj;
                LebaSearchMoreInfoActivity lebaSearchMoreInfoActivity = LebaSearchMoreInfoActivity.this;
                lebaSearchMoreInfoActivity.f78581k0.z0(17, bundle, lebaSearchMoreInfoActivity.f78582l0);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class b implements BusinessObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            String string;
            int i16;
            if (obj == null) {
                return;
            }
            Bundle bundle = (Bundle) obj;
            int i17 = 0;
            if (i3 != 17) {
                if (i3 == 18) {
                    LebaSearchMoreInfoActivity.this.f78577g0 = bundle.getBoolean(h.f248218g);
                    LebaSearchMoreInfoActivity.this.f78578h0 = bundle.getString("name");
                    LebaSearchMoreInfoActivity lebaSearchMoreInfoActivity = LebaSearchMoreInfoActivity.this;
                    String str = lebaSearchMoreInfoActivity.f78578h0;
                    if (str != null) {
                        lebaSearchMoreInfoActivity.f78575e0 = lebaSearchMoreInfoActivity.getString(R.string.doz, str);
                    }
                    LebaSearchMoreInfoActivity.this.N2();
                    return;
                }
                return;
            }
            boolean z17 = bundle.getBoolean("result");
            StringBuilder sb5 = new StringBuilder();
            if (z17) {
                string = LebaSearchMoreInfoActivity.this.getString(R.string.dnc);
            } else {
                string = LebaSearchMoreInfoActivity.this.getString(R.string.dnb);
            }
            sb5.append(string);
            sb5.append(LebaSearchMoreInfoActivity.this.getString(R.string.dna));
            sb5.append(LebaSearchMoreInfoActivity.this.f78578h0);
            if (z17) {
                i16 = 2;
            } else {
                i16 = 1;
            }
            QQToast.makeText(LebaSearchMoreInfoActivity.this, i16, sb5.toString(), 1).show(LebaSearchMoreInfoActivity.this.getTitleBarHeight());
            LebaSearchMoreInfoActivity lebaSearchMoreInfoActivity2 = LebaSearchMoreInfoActivity.this;
            if (z17) {
                i17 = -1;
            }
            lebaSearchMoreInfoActivity2.setResult(i17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N2() {
        String account;
        boolean z16;
        if (this.f78577g0) {
            return;
        }
        if (this.f78575e0 == null) {
            this.f78571a0.setVisibility(8);
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences("leba_search_more_config", 0);
        if (getAppRuntime() == null) {
            account = "";
        } else {
            account = getAppRuntime().getAccount();
        }
        if (!TextUtils.isEmpty(this.f78575e0)) {
            this.f78572b0.setText(this.f78575e0);
            this.f78572b0.setContentDescription(this.f78575e0 + ";" + getString(R.string.f171275dp0));
        } else {
            this.f78572b0.setContentDescription("");
        }
        if (System.currentTimeMillis() - sharedPreferences.getLong("time_" + account + "_" + this.f78576f0, 0L) > 86400000) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            sharedPreferences.edit().putLong("time_" + account + "_" + this.f78576f0, System.currentTimeMillis());
            this.f78571a0.setVisibility(0);
        }
    }

    private void initData() {
        com.tencent.biz.troop.b A = com.tencent.biz.troop.b.A();
        this.f78581k0 = A;
        A.p();
        this.f78581k0.f(this.f78582l0);
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        this.f78574d0 = intent.getStringExtra("url");
        this.f78576f0 = intent.getLongExtra("id", -1L);
        if (TextUtils.isEmpty(this.f78574d0)) {
            finish();
        }
    }

    private void initUI() {
        View findViewById = findViewById(R.id.fvv);
        this.f78571a0 = findViewById;
        findViewById.setVisibility(8);
        TextView textView = (TextView) this.f78571a0.findViewById(R.id.f_f);
        this.f78572b0 = textView;
        textView.setCompoundDrawables(null, null, null, null);
        this.f78571a0.setOnClickListener(this);
        ImageView imageView = (ImageView) this.f78571a0.findViewById(R.id.f_d);
        imageView.setImageResource(R.drawable.ftc);
        imageView.setOnClickListener(this);
        this.f78573c0 = (FrameLayout) findViewById(R.id.l1r);
        this.f78580j0.post(new Runnable() { // from class: com.tencent.biz.lebasearch.LebaSearchMoreInfoActivity.2
            @Override // java.lang.Runnable
            public void run() {
                LebaSearchMoreInfoActivity lebaSearchMoreInfoActivity = LebaSearchMoreInfoActivity.this;
                lebaSearchMoreInfoActivity.getWebView(lebaSearchMoreInfoActivity.f78573c0).loadUrl(LebaSearchMoreInfoActivity.this.f78574d0);
            }
        });
        if (this.f78576f0 != -1) {
            Bundle bundle = new Bundle();
            bundle.putLong("uiResId", this.f78576f0);
            this.f78581k0.z0(18, bundle, this.f78582l0);
        }
    }

    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle bundle) {
        super.doOnCreate(bundle);
        setContentView(R.layout.f168536a03);
        initData();
        initUI();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        com.tencent.biz.troop.b bVar = this.f78581k0;
        if (bVar != null) {
            bVar.q();
            this.f78581k0.n0(this.f78582l0);
        }
        super.doOnDestroy();
    }

    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        super.onClick(view);
        int id5 = view.getId();
        if (id5 != R.id.fvv && id5 != R.id.ba5) {
            if (id5 == R.id.f_d) {
                this.f78571a0.setVisibility(8);
            }
        } else {
            this.f78571a0.setVisibility(8);
            if (this.f78579i0 == null) {
                this.f78579i0 = Utils.createPluginSetDialogForWeb(this, this.f78581k0, this.f78582l0, 1, this.f78576f0, this.f78578h0, null);
            }
            if (this.f78579i0.isShowing()) {
                this.f78579i0.dismiss();
            }
            this.f78579i0.show();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity, com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.biz.webviewbase.AbsBaseWebViewActivity
    protected void onReceivedTitle(WebView webView, String str) {
        setTitle(str);
    }
}
