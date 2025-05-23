package com.tencent.open.agent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QIphoneTitleBarActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginStatus;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.ShaderAnimLayout;
import com.tencent.open.agent.SwitchAccountActivity;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.t;
import com.tencent.open.agent.util.u;
import com.tencent.open.model.AccountManage;
import com.tencent.open.virtual.OpenSdkVirtualUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import oicq.wlogin_sdk.tools.ErrMsg;

/* compiled from: P */
@RoutePage(desc = "\u4e92\u8054\u5207\u6362\u8d26\u53f7\u9875\u9762", path = RouterConstants.UI_ROUTER_SWITCH_ACCOUNT)
/* loaded from: classes22.dex */
public class SwitchAccountActivity extends QIphoneTitleBarActivity {
    private static final String TAG = "SwitchAccountActivity";
    private SharedPreferences.Editor accountEdi;
    private ArrayList<String> accountList;
    private SharedPreferences accountPre;
    private LinearLayout container;
    private String mAccount;
    private boolean mHasSlide;
    private long mLoginBTS;
    private QQProgressDialog mProgress;
    private String mThirdAppId;
    private int mReqSrc = 1;
    private com.tencent.mobileqq.loginregister.servlet.f ssoLoginObserver = new a();
    private View.OnTouchListener onTouch = new g();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a extends com.tencent.mobileqq.loginregister.servlet.f {
        a() {
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void a(String str, int i3, int i16, Bundle bundle) {
            String str2;
            SwitchAccountActivity.this.hideLoginTip();
            String string = bundle.getString("error");
            int i17 = bundle.getInt("code");
            com.tencent.open.agent.util.d.o("agent_login", SwitchAccountActivity.this.mLoginBTS, 0L, 0L, i17, str, "ret: " + i16 + " | error: " + string);
            if (i16 == -1000) {
                SwitchAccountActivity switchAccountActivity = SwitchAccountActivity.this;
                AuthUIUtil.h(switchAccountActivity, switchAccountActivity.getResources().getString(R.string.f171155cp4));
            } else if (i16 == 1 || i16 == -1004) {
                SwitchAccountActivity.this.showLoginActivity();
            } else {
                ErrMsg errMsg = (ErrMsg) bundle.getParcelable(NotificationActivity.KEY_LAST_ERROR);
                if (errMsg != null) {
                    str2 = errMsg.getMessage();
                } else {
                    str2 = null;
                }
                if (str2 == null || str2.length() == 0) {
                    str2 = SwitchAccountActivity.this.getString(R.string.iab);
                }
                AuthUIUtil.h(SwitchAccountActivity.this, str2);
            }
            t.b(SwitchAccountActivity.TAG, "rec | cmd: g_t_n_p | uin : *" + com.tencent.open.agent.util.g.C(str) + " | ret : " + i16 + " - error: " + string + " | code: " + i17);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void c(String str, byte[] bArr, int i3, Bundle bundle) {
            String str2;
            if (!bundle.getBoolean("fake_callback") && i3 == 64) {
                up3.b.o(str, System.currentTimeMillis());
            }
            SwitchAccountActivity.this.hideLoginTip();
            if (i3 == 64) {
                str2 = new String(bArr);
            } else {
                str2 = null;
            }
            SwitchAccountActivity.this.loginSuccess(str, str2, bundle);
            t.b(SwitchAccountActivity.TAG, "rec | cmd: g_t_n_p | uin : *" + com.tencent.open.agent.util.g.C(str) + " | ret : success | code: " + bundle.getInt("code"));
            com.tencent.open.agent.util.d.o("agent_login", SwitchAccountActivity.this.mLoginBTS, 0L, 0L, 0, str, null);
        }

        @Override // com.tencent.mobileqq.loginregister.servlet.f
        public void d(String str, int i3, Bundle bundle) {
            SwitchAccountActivity.this.hideLoginTip();
            t.b(SwitchAccountActivity.TAG, "rec | cmd: g_t_n_p | uin : *" + com.tencent.open.agent.util.g.C(str) + " | ret : on_user_cancel | code: " + bundle.getInt("code"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            View view2 = (View) view.getParent().getParent();
            if (view2 != null && view2.getTag() != null) {
                SwitchAccountActivity.this.deleteAccount((String) view2.getTag());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!SwitchAccountActivity.this.mHasSlide) {
                SwitchAccountActivity.this.mAccount = (String) view.getTag();
                SwitchAccountActivity.this.login();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            SwitchAccountActivity.this.showLoginActivity();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class e implements u {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z16) {
            if (z16) {
                SwitchAccountActivity.this.showLoginActivity();
                return;
            }
            t.b(SwitchAccountActivity.TAG, "-->login--has atwo");
            SwitchAccountActivity switchAccountActivity = SwitchAccountActivity.this;
            switchAccountActivity.loginSuccess(switchAccountActivity.mAccount, null, null);
        }

        @Override // com.tencent.open.agent.util.u
        public void onResult(final boolean z16, String str) {
            SwitchAccountActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.p
                @Override // java.lang.Runnable
                public final void run() {
                    SwitchAccountActivity.e.this.b(z16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class f implements u {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(boolean z16) {
            if (z16) {
                SwitchAccountActivity.this.showLoginActivity();
            } else {
                t.b(SwitchAccountActivity.TAG, "send | cmd: g_t_n_p | uin : *" + com.tencent.open.agent.util.g.C(SwitchAccountActivity.this.mAccount));
                com.tencent.open.agent.util.d.B("KEY_DELEGATE_GET_TICKET_NO_PASSWD");
                AccountManage.g().e(SwitchAccountActivity.this.mAccount, SwitchAccountActivity.this.ssoLoginObserver, SwitchAccountActivity.this.mThirdAppId, 1);
            }
            SwitchAccountActivity.this.showLoginTip();
        }

        @Override // com.tencent.open.agent.util.u
        public void onResult(final boolean z16, String str) {
            SwitchAccountActivity.this.runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.q
                @Override // java.lang.Runnable
                public final void run() {
                    SwitchAccountActivity.f.this.b(z16);
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class g implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        View f340068d;

        /* renamed from: e, reason: collision with root package name */
        WeakReference<View> f340069e;

        /* renamed from: f, reason: collision with root package name */
        protected GestureDetector.SimpleOnGestureListener f340070f = new a();

        /* renamed from: h, reason: collision with root package name */
        protected GestureDetector f340071h = new GestureDetector(this.f340070f);

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a extends GestureDetector.SimpleOnGestureListener {
            a() {
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
                View findViewById;
                View findViewById2;
                WeakReference<View> weakReference;
                View findViewById3;
                if (Math.abs(f16) > Math.abs(f17) && Math.abs(f16) > 20.0f && !SwitchAccountActivity.this.mHasSlide) {
                    SwitchAccountActivity.this.mHasSlide = true;
                    View view = g.this.f340068d;
                    if (view != null) {
                        view.setPressed(false);
                    }
                    if (f16 < -20.0f && (weakReference = g.this.f340069e) != null) {
                        View view2 = weakReference.get();
                        if (view2 != null && (findViewById3 = view2.findViewById(R.id.iqk)) != null && findViewById3.getVisibility() == 0) {
                            ((ShaderAnimLayout) findViewById3).a();
                        }
                        g.this.f340069e = null;
                    }
                    if (f16 > 20.0f) {
                        WeakReference<View> weakReference2 = g.this.f340069e;
                        if (weakReference2 != null && weakReference2.get() != null) {
                            View view3 = g.this.f340069e.get();
                            if (view3 != g.this.f340068d && (findViewById2 = view3.findViewById(R.id.iqk)) != null && findViewById2.getVisibility() == 0) {
                                ((ShaderAnimLayout) findViewById2).a();
                            }
                            g.this.f340069e = null;
                        } else {
                            View view4 = g.this.f340068d;
                            if (view4 != null && (findViewById = view4.findViewById(R.id.iqk)) != null && findViewById.getVisibility() != 0) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("AccountManage", 2, "show current selectedAccountView");
                                }
                                ((ShaderAnimLayout) findViewById).f();
                                g.this.f340069e = new WeakReference<>(g.this.f340068d);
                                g.this.f340068d = null;
                            }
                        }
                    }
                    return true;
                }
                return false;
            }
        }

        g() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (QLog.isColorLevel()) {
                QLog.i("AccountManage", 2, "action = " + action);
            }
            if (action == 0) {
                this.f340068d = view;
                if (SwitchAccountActivity.this.mHasSlide) {
                    SwitchAccountActivity.this.mHasSlide = false;
                }
            }
            this.f340071h.onTouchEvent(motionEvent);
            return false;
        }
    }

    private static String convertUserInfoToJson(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{");
        sb5.append("uin:'");
        sb5.append(str);
        sb5.append("',");
        sb5.append("a2:'");
        if (str2 != null) {
            sb5.append(str2);
        }
        sb5.append("'}");
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deleteAccount(String str) {
        String string;
        t.b(TAG, "-->deleteAccount--account to delete is " + com.tencent.open.agent.util.g.C(str));
        up3.b.g(str);
        String[] strArr = null;
        if (this.accountPre.getString("accList", null) != null && (string = this.accountPre.getString("accList", null)) != null) {
            strArr = string.split(",");
        }
        ArrayList arrayList = new ArrayList();
        if (strArr != null) {
            for (String str2 : strArr) {
                arrayList.add(str2);
            }
        }
        while (arrayList.contains("")) {
            arrayList.remove("");
        }
        if (arrayList.contains(str)) {
            arrayList.remove(str);
            Iterator it = arrayList.iterator();
            String str3 = "";
            while (it.hasNext()) {
                str3 = str3 + "," + ((String) it.next());
            }
            this.accountEdi.putString("accList", str3);
            this.accountEdi.commit();
        }
        if (str.equals(this.accountPre.getString("last_account", ""))) {
            t.b(TAG, "-->deleteAccount--account to delete equals last account, clear last account");
            this.accountEdi.remove("last_account").commit();
        }
        File file = new File(OpenSdkVirtualUtil.n(OpenSdkVirtualUtil.b(str)));
        if (!file.exists()) {
            file.delete();
        }
        for (int i3 = 0; i3 < this.container.getChildCount(); i3++) {
            View childAt = this.container.getChildAt(i3);
            if (childAt.getTag().equals(str)) {
                this.container.removeView(childAt);
                if (i3 == 0) {
                    View childAt2 = this.container.getChildAt(i3);
                    if (this.container.getChildCount() == 1) {
                        childAt2.setBackgroundResource(R.drawable.common_strip_setting_bg);
                        return;
                    } else {
                        childAt2.setBackgroundResource(R.drawable.common_strip_setting_top);
                        return;
                    }
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoginTip() {
        QQProgressDialog qQProgressDialog = this.mProgress;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            try {
                this.mProgress.dismiss();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$login$0(boolean z16) {
        if (z16) {
            t.b(TAG, "-->login--has aone");
            loginSuccess(this.mAccount, null, null);
        } else {
            showLoginActivity();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$login$1(final boolean z16, String str) {
        runOnUiThread(new Runnable() { // from class: com.tencent.open.agent.o
            @Override // java.lang.Runnable
            public final void run() {
                SwitchAccountActivity.this.lambda$login$0(z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void login() {
        int i3 = this.mReqSrc;
        if (i3 == 2) {
            com.tencent.open.agent.util.g.g(this.mAccount, new u() { // from class: com.tencent.open.agent.n
                @Override // com.tencent.open.agent.util.u
                public final void onResult(boolean z16, String str) {
                    SwitchAccountActivity.this.lambda$login$1(z16, str);
                }
            });
        } else if (i3 == 3) {
            com.tencent.open.agent.util.g.f(this.mAccount, new e());
        } else {
            com.tencent.open.agent.util.g.f(this.mAccount, new f());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginSuccess(String str, String str2, Bundle bundle) {
        boolean z16;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("-->loginSucess--mReqSrc = ");
        sb5.append(this.mReqSrc);
        sb5.append(", userAccount = *");
        sb5.append(com.tencent.open.agent.util.g.C(str));
        sb5.append(", bundle = null ? ");
        if (bundle == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        objArr[0] = sb5.toString();
        t.b(TAG, objArr);
        up3.b.b(str);
        Intent intent = new Intent();
        int i3 = this.mReqSrc;
        if (i3 != 2 && i3 != 3) {
            String b16 = OpenSdkVirtualUtil.b(str);
            com.tencent.open.agent.util.d.j("KEY_DELEGATE_GET_TICKET_NO_PASSWD", b16, true);
            intent.putExtra("nick", com.tencent.mobileqq.login.account.b.c(b16));
            intent.putExtra("last_account", b16);
            intent.putExtra(QAdLoginDefine$LoginStatus.IS_LOGIN, this.accountList.contains(b16));
            if (bundle != null) {
                byte[] byteArray = bundle.getByteArray("st_temp");
                byte[] byteArray2 = bundle.getByteArray("st_temp_key");
                intent.putExtra("st_temp", byteArray);
                intent.putExtra("st_temp_key", byteArray2);
            }
        } else {
            String b17 = OpenSdkVirtualUtil.b(str);
            intent.putExtra("last_account", b17);
            intent.putExtra(QAdLoginDefine$LoginStatus.IS_LOGIN, this.accountList.contains(b17));
        }
        super.setResult(-1, intent);
        super.finish();
    }

    private void showAccountList() {
        if (this.accountList == null) {
            return;
        }
        LayoutInflater layoutInflater = super.getLayoutInflater();
        int i3 = 0;
        for (int i16 = 0; i16 < this.accountList.size(); i16++) {
            View inflate = layoutInflater.inflate(R.layout.c4l, (ViewGroup) this.container, false);
            TextView textView = (TextView) inflate.findViewById(R.id.f97);
            TextView textView2 = (TextView) inflate.findViewById(R.id.f167075kh1);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.c0o);
            String str = this.accountList.get(i16);
            String c16 = com.tencent.mobileqq.login.account.b.c(str);
            if (TextUtils.isEmpty(c16)) {
                c16 = str;
            }
            textView.setText(c16);
            textView2.setText(str);
            Bitmap i17 = OpenSdkVirtualUtil.i(str, 60, true);
            if (i17 != null) {
                Bitmap s16 = com.tencent.open.agent.util.g.s(this, i17, 63, 63);
                i17.recycle();
                if (s16 != null) {
                    imageView.setImageBitmap(s16);
                }
            }
            if (i3 == 0) {
                inflate.setBackgroundResource(R.drawable.common_strip_setting_top);
            }
            inflate.findViewById(R.id.bex).setOnClickListener(new b());
            inflate.setOnClickListener(new c());
            inflate.setOnTouchListener(this.onTouch);
            inflate.setTag(str);
            this.container.addView(inflate);
            i3++;
            if (i3 >= 10) {
                break;
            }
        }
        t.b(TAG, "-->showAccountList--count = " + i3);
        ReportCenter.f().q("", "", "", "1010", String.valueOf(i3), "0", false, true);
        View inflate2 = layoutInflater.inflate(R.layout.c4m, (ViewGroup) this.container, false);
        this.container.addView(inflate2);
        inflate2.setOnClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoginActivity() {
        t.b(TAG, "-->showLoginActivity");
        Intent intent = new Intent();
        intent.putExtra("key_req_src", this.mReqSrc);
        intent.putExtra("appid", this.mThirdAppId);
        intent.putExtra("param_qr_code_url", getIntent().getStringExtra("param_qr_code_url"));
        intent.putExtra("packagename", getIntent().getStringExtra("packagename"));
        intent.putExtra("oauth_app_name", getIntent().getStringExtra("oauth_app_name"));
        intent.putExtra("is_open_sdk_add_account", true);
        intent.putExtra("loginFragmentType", 5);
        intent.putExtra("key_login_page_entrance", 4);
        intent.putExtra("key_login_page_title", BaseApplication.getContext().getString(R.string.f9p));
        RouteUtils.startActivityForResult(this, intent, RouterConstants.UI_ROUTER_LOGIN, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showLoginTip() {
        this.mProgress.setMessage(super.getString(R.string.f171154cp2));
        if (!super.isFinishing() && !this.mProgress.isShowing() && getWindow().isActive()) {
            this.mProgress.show();
        }
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int i3, int i16, Intent intent) {
        boolean z16;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("-->onActivityResult--reqCode = ");
        sb5.append(i3);
        sb5.append(", resCode = ");
        sb5.append(i16);
        sb5.append(", data = null ? ");
        if (intent == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        objArr[0] = sb5.toString();
        t.b(TAG, objArr);
        if (i3 == 1) {
            super.getIntent().getStringExtra("key_action");
            if (i16 == 0) {
                if (this.mProgress.isShowing()) {
                    this.mProgress.dismiss();
                }
            } else if (-1 == i16) {
                super.setResult(-1, intent);
                super.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent */
    public boolean getNeedGestureBack() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QIphoneTitleBarActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @SuppressLint({"CommitPrefEdits"})
    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        super.setContentView(R.layout.c5i);
        SharedPreferences sharedPreferences = super.getSharedPreferences("accountList", 0);
        this.accountPre = sharedPreferences;
        this.accountEdi = sharedPreferences.edit();
        Intent intent = super.getIntent();
        if (intent != null && (extras = intent.getExtras()) != null) {
            this.mReqSrc = extras.getInt("key_req_src", 1);
            this.mThirdAppId = extras.getString(AppConstants.Key.KEY_THIRD_APPID, "");
        }
        t.b(TAG, "mReqSrc:" + this.mReqSrc);
        super.setTitle(R.string.cpe);
        this.mProgress = new QQProgressDialog(this, getTitleBarHeight());
        this.container = (LinearLayout) super.findViewById(R.id.f163886b8);
        this.mLoginBTS = SystemClock.elapsedRealtime();
        this.accountList = up3.b.j();
        String stringExtra = super.getIntent().getStringExtra("param_uin");
        ArrayList<String> arrayList = this.accountList;
        if (arrayList != null) {
            arrayList.remove(stringExtra);
        }
        showAccountList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        QQProgressDialog qQProgressDialog = this.mProgress;
        if (qQProgressDialog != null && qQProgressDialog.isShowing()) {
            this.mProgress.dismiss();
        }
    }
}
