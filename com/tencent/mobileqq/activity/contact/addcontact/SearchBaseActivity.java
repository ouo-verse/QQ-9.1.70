package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.ac;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SearchBaseActivity extends BaseActivity {
    static IPatchRedirector $redirector_;

    /* renamed from: n0, reason: collision with root package name */
    public static final Pattern f180755n0;

    /* renamed from: o0, reason: collision with root package name */
    public static final Pattern f180756o0;

    /* renamed from: p0, reason: collision with root package name */
    public static final Pattern f180757p0;

    /* renamed from: a0, reason: collision with root package name */
    public final int f180758a0;

    /* renamed from: b0, reason: collision with root package name */
    protected String f180759b0;

    /* renamed from: c0, reason: collision with root package name */
    protected int f180760c0;

    /* renamed from: d0, reason: collision with root package name */
    protected int f180761d0;

    /* renamed from: e0, reason: collision with root package name */
    protected int f180762e0;

    /* renamed from: f0, reason: collision with root package name */
    TextView f180763f0;

    /* renamed from: g0, reason: collision with root package name */
    ImageView f180764g0;

    /* renamed from: h0, reason: collision with root package name */
    EditText f180765h0;

    /* renamed from: i0, reason: collision with root package name */
    ImageView f180766i0;

    /* renamed from: j0, reason: collision with root package name */
    QUISearchBar f180767j0;

    /* renamed from: k0, reason: collision with root package name */
    SearchBaseFragment f180768k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f180769l0;

    /* renamed from: m0, reason: collision with root package name */
    private Handler f180770m0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class a implements TextView.OnEditorActionListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchBaseActivity.this);
            }
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
            boolean booleanValue;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                booleanValue = ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, Integer.valueOf(i3), keyEvent)).booleanValue();
            } else {
                booleanValue = SearchBaseActivity.this.F2(textView, i3, keyEvent).booleanValue();
            }
            EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
            return booleanValue;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchBaseActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                SearchBaseActivity.this.f180765h0.setText("");
                SearchBaseActivity searchBaseActivity = SearchBaseActivity.this;
                int i3 = searchBaseActivity.f180760c0;
                if (i3 != 1 && i3 != 6) {
                    searchBaseActivity.f180768k0.wh();
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchBaseActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                SearchBaseActivity.this.setResult(1);
                SearchBaseActivity.this.finish();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class d extends Handler {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchBaseActivity.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else {
                SearchBaseActivity.this.f180765h0.clearFocus();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static final class e {
        static IPatchRedirector $redirector_;

        public static String a(int i3) {
            if (i3 == 0) {
                return "1";
            }
            if (i3 == 1) {
                return "2";
            }
            return "";
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(67829);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
            return;
        }
        f180755n0 = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,})$", 2);
        f180756o0 = Pattern.compile("[^0-9]");
        f180757p0 = Pattern.compile("^1[0-9]{2}\\d{8}$");
    }

    public SearchBaseActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f180758a0 = 64;
            this.f180770m0 = new d();
        }
    }

    private void L2() {
        int i3 = this.f180760c0;
        if (i3 == 1) {
            if (ac.a()) {
                this.f180761d0 = 7;
                return;
            } else {
                this.f180761d0 = 4;
                return;
            }
        }
        if (i3 == 6) {
            this.f180761d0 = 2;
        }
    }

    public Boolean F2(TextView textView, int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Boolean) iPatchRedirector.redirect((short) 12, this, textView, Integer.valueOf(i3), keyEvent);
        }
        if (i3 != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return Boolean.FALSE;
        }
        String obj = this.f180765h0.getText().toString();
        if (!TextUtils.isEmpty(obj) && !TextUtils.isEmpty(obj.trim())) {
            if (!TextUtils.isEmpty(obj)) {
                K2();
                SearchUtils.V0("add_page", "search", "clk_search_all", this.f180760c0 + 1, 0, "", "", obj, "");
                this.f180768k0.Bh(obj, false);
                this.f180765h0.setText("");
            }
            return Boolean.TRUE;
        }
        H2(true, this.f180765h0);
        QQToast.makeText(getApplicationContext(), HardCodeUtil.qqStr(R.string.t66), 0).show();
        return Boolean.TRUE;
    }

    public int G2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.f180769l0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean H2(boolean z16, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), view)).booleanValue();
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
        if (inputMethodManager == null || view == null || !inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0)) {
            return false;
        }
        if (z16) {
            view.clearFocus();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void I2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Intent intent = getIntent();
        if (intent.hasExtra("from_key")) {
            this.f180760c0 = intent.getIntExtra("from_key", 0);
            this.f180759b0 = intent.getStringExtra("last_key_words");
            this.f180769l0 = intent.getIntExtra("jump_src_key", 1);
        }
        if (intent.hasExtra(IProfileCardConst.KEY_FROM_TYPE)) {
            this.f180762e0 = intent.getIntExtra(IProfileCardConst.KEY_FROM_TYPE, -1);
        }
    }

    protected SearchBaseFragment J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (SearchBaseFragment) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new SearchBaseFragment();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle)).booleanValue();
        }
        ca.a(this);
        super.doOnCreate(bundle);
        super.setContentView(R.layout.b1q);
        View findViewById = super.findViewById(R.id.root);
        if (this.mNeedStatusTrans && ImmersiveUtils.isSupporImmersive() == 1) {
            findViewById.setFitsSystemWindows(true);
        }
        super.getWindow().setBackgroundDrawable(null);
        I2();
        L2();
        initViews();
        SearchBaseFragment J2 = J2();
        this.f180768k0 = J2;
        if (J2 instanceof ClassificationSearchFragment) {
            ((ClassificationSearchFragment) J2).mi(this.f180762e0);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("from_key", this.f180760c0);
        bundle2.putInt("user_source", this.f180761d0);
        bundle2.putString("last_key_words", this.f180759b0);
        bundle2.putString("start_search_key", getIntent().getStringExtra("start_search_key"));
        bundle2.putBoolean("auto_add_and_prohibit_auto_search", getIntent().getBooleanExtra("auto_add_and_prohibit_auto_search", false));
        this.f180768k0.setArguments(bundle2);
        this.f180768k0.Uh(this.f180770m0);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.b8q, this.f180768k0);
        beginTransaction.commitAllowingStateLoss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.doOnDestroy();
            ViewFactory.f().b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
        } else {
            super.doOnResume();
            setContentBackgroundResource(R.drawable.bg_texture_theme_version2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void initViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        this.f180767j0 = (QUISearchBar) findViewById(R.id.ik9);
        this.f180763f0 = (TextView) findViewById(R.id.f658039x);
        EditText editText = (EditText) findViewById(R.id.f66003_g);
        this.f180765h0 = editText;
        editText.setHint(getResources().getString(R.string.f170090fm));
        this.f180765h0.setFilters(new InputFilter[]{new InputFilter.LengthFilter(64)});
        this.f180765h0.setTextSize(0, getResources().getDimension(R.dimen.ayp));
        this.f180765h0.setImeOptions(3);
        this.f180765h0.setSingleLine();
        this.f180765h0.setOnEditorActionListener(new a());
        ImageView imageView = (ImageView) findViewById(R.id.f65943_a);
        this.f180764g0 = imageView;
        imageView.setOnClickListener(new b());
        ImageView imageView2 = (ImageView) findViewById(R.id.f657839v);
        this.f180766i0 = imageView2;
        if (AppSetting.f99565y) {
            imageView2.setContentDescription(HardCodeUtil.qqStr(R.string.f171898lr0));
        }
        this.f180766i0.setOnClickListener(new c());
    }

    @Override // com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void requestWindowFeature(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        } else {
            requestWindowFeature(1);
        }
    }
}
