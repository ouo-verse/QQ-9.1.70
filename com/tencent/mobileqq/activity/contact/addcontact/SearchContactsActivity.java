package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.res.Configuration;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.fragment.SearchSuggestFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.view.AutoHintLayout;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.WebView;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class SearchContactsActivity extends SearchBaseActivity implements AutoHintLayout.b {
    static IPatchRedirector $redirector_;

    /* renamed from: q0, reason: collision with root package name */
    private final String f180804q0;

    /* renamed from: r0, reason: collision with root package name */
    private AutoHintLayout f180805r0;

    /* renamed from: s0, reason: collision with root package name */
    private final MessageQueue.IdleHandler f180806s0;

    /* renamed from: t0, reason: collision with root package name */
    private SearchSuggestFragment f180807t0;

    /* renamed from: u0, reason: collision with root package name */
    private int f180808u0;

    /* renamed from: v0, reason: collision with root package name */
    private String f180809v0;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    private static final class ShowInputKeyboardHandler implements MessageQueue.IdleHandler {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final SearchContactsActivity f180810d;

        public ShowInputKeyboardHandler(SearchContactsActivity searchContactsActivity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) searchContactsActivity);
            } else {
                this.f180810d = searchContactsActivity;
            }
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
            }
            this.f180810d.f180765h0.requestFocus();
            this.f180810d.f180765h0.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.activity.contact.addcontact.SearchContactsActivity.ShowInputKeyboardHandler.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ShowInputKeyboardHandler.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        ((InputMethodManager) ShowInputKeyboardHandler.this.f180810d.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(ShowInputKeyboardHandler.this.f180810d.f180765h0, 1);
                    }
                }
            }, 100L);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f180811d;

        a(boolean z16) {
            this.f180811d = z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SearchContactsActivity.this, Boolean.valueOf(z16));
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i3;
            SearchContactsActivity searchContactsActivity;
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
                return;
            }
            SearchContactsActivity searchContactsActivity2 = SearchContactsActivity.this;
            searchContactsActivity2.f180809v0 = searchContactsActivity2.f180765h0.getText().toString();
            boolean isEmpty = TextUtils.isEmpty(SearchContactsActivity.this.f180809v0);
            SearchContactsActivity searchContactsActivity3 = SearchContactsActivity.this;
            searchContactsActivity3.S2(searchContactsActivity3.f180809v0);
            ImageView imageView = SearchContactsActivity.this.f180764g0;
            if (isEmpty) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            imageView.setVisibility(i3);
            int i17 = 1;
            if (this.f180811d && (i16 = (searchContactsActivity = SearchContactsActivity.this).f180760c0) != 1 && i16 != 6) {
                ((SearchContactsFragment) searchContactsActivity.f180768k0).Ji(searchContactsActivity.f180809v0);
            }
            SearchContactsActivity searchContactsActivity4 = SearchContactsActivity.this;
            if (!isEmpty) {
                i17 = 2;
            }
            searchContactsActivity4.V2(i17);
            if (SearchContactsActivity.this.f180807t0 != null && !isEmpty) {
                SearchContactsActivity.this.f180807t0.wh(SearchContactsActivity.this.f180809v0);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class b implements QUISearchBar.ActionCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchContactsActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onBack() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public int onCancel() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            SearchContactsActivity.this.setResult(0);
            SearchContactsActivity.this.finish();
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onClear() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class c implements SearchSuggestFragment.a {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchContactsActivity.this);
            }
        }

        @Override // com.tencent.mobileqq.search.fragment.SearchSuggestFragment.a
        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            SearchBaseFragment searchBaseFragment = SearchContactsActivity.this.f180768k0;
            if (searchBaseFragment instanceof SearchContactsFragment) {
                ((SearchContactsFragment) searchBaseFragment).qi(str, false, 9);
                SearchContactsActivity.this.f180765h0.setText("");
            }
        }

        @Override // com.tencent.mobileqq.search.fragment.SearchSuggestFragment.a
        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                SearchContactsActivity.this.f180765h0.setText("");
            }
        }
    }

    public SearchContactsActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f180804q0 = "\u7fa4\u53f7/\u7fa4\u540d";
        this.f180806s0 = new ShowInputKeyboardHandler(this);
        this.f180808u0 = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S2(String str) {
        String str2;
        String str3;
        if (!TextUtils.isEmpty(str) && str.equals("//gettbs")) {
            String tBSDpcParam = WebAccelerateHelper.getInstance().getTBSDpcParam();
            if (!TextUtils.isEmpty(tBSDpcParam) && tBSDpcParam.length() > 2) {
                str2 = String.valueOf(tBSDpcParam.charAt(0));
                str3 = String.valueOf(tBSDpcParam.charAt(2));
            } else {
                str2 = "";
                str3 = "";
            }
            QQToast.makeText(getActivity().getApplicationContext(), String.format("tbs_download:%s\ntbs_enable:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d", str2, str3, Integer.valueOf(QbSdk.getTbsVersion(this)), Integer.valueOf(WebView.getTbsSDKVersion(this))), 0).show(getTitleBarHeight());
        }
    }

    private void T2(Fragment fragment, Fragment fragment2) {
        if (fragment != null && !fragment.isVisible()) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (fragment.isAdded()) {
                beginTransaction.show(fragment);
            } else {
                beginTransaction.add(R.id.b8q, fragment);
            }
            if (fragment2 != null) {
                beginTransaction.hide(fragment2);
            }
            beginTransaction.commitNowAllowingStateLoss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V2(int i3) {
        QLog.d("qqBaseActivity", 2, "showFragment fragment=" + i3);
        int i16 = this.f180760c0;
        if ((i16 == 1 || i16 == 6) && this.f180808u0 != i3 && !isFinishing()) {
            this.f180808u0 = i3;
            if (i3 != 1) {
                if (i3 == 2 && NetworkUtil.isNetSupport(this)) {
                    if (this.f180807t0 == null) {
                        this.f180807t0 = new SearchSuggestFragment();
                    }
                    T2(this.f180807t0, this.f180768k0);
                    this.f180807t0.xh(new c());
                    return;
                }
                return;
            }
            if (this.f180768k0 == null) {
                this.f180768k0 = J2();
            }
            T2(this.f180768k0, this.f180807t0);
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity
    public Boolean F2(TextView textView, int i3, KeyEvent keyEvent) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Boolean) iPatchRedirector.redirect((short) 9, this, textView, Integer.valueOf(i3), keyEvent);
        }
        if (i3 != 3 && (keyEvent == null || keyEvent.getKeyCode() != 66)) {
            return Boolean.FALSE;
        }
        String obj = this.f180765h0.getText().toString();
        String i16 = this.f180805r0.i();
        if (obj.length() > 0 && TextUtils.isEmpty(obj.trim())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            H2(true, this.f180765h0);
            QQToast.makeText(getApplicationContext(), HardCodeUtil.qqStr(R.string.t66), 0).show();
            return Boolean.TRUE;
        }
        if (!TextUtils.isEmpty(obj) && !TextUtils.isEmpty(obj.trim())) {
            z17 = false;
        } else {
            z17 = true;
        }
        boolean equals = TextUtils.equals(i16, "\u7fa4\u53f7/\u7fa4\u540d");
        if (z17 && (equals || TextUtils.isEmpty(i16))) {
            H2(true, this.f180765h0);
            QQToast.makeText(getApplicationContext(), HardCodeUtil.qqStr(R.string.t66), 0).show();
            return Boolean.TRUE;
        }
        if (z17) {
            obj = i16;
        }
        if (!TextUtils.isEmpty(obj)) {
            K2();
            SearchUtils.V0("add_page", "search", "clk_search_all", this.f180760c0 + 1, 0, "", "", obj, "");
            if (z17) {
                SearchBaseFragment searchBaseFragment = this.f180768k0;
                if (searchBaseFragment instanceof SearchContactsFragment) {
                    int ri5 = ((SearchContactsFragment) searchBaseFragment).ri();
                    ((SearchContactsFragment) this.f180768k0).Ki(27);
                    this.f180768k0.Bh(obj, false);
                    ((SearchContactsFragment) this.f180768k0).Ki(ri5);
                    this.f180765h0.setText("");
                }
            }
            this.f180768k0.Bh(obj, false);
            this.f180765h0.setText("");
        }
        return Boolean.TRUE;
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity
    protected SearchBaseFragment J2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (SearchBaseFragment) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return SearchContactsFragment.Di(this.f180762e0);
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity
    protected void K2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            super.K2();
            V2(1);
        }
    }

    public void U2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        QUISearchBar qUISearchBar = this.f180767j0;
        if (qUISearchBar != null) {
            VideoReport.setElementId(qUISearchBar, "em_bas_search_box");
            QUISearchBar qUISearchBar2 = this.f180767j0;
            ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
            VideoReport.setElementExposePolicy(qUISearchBar2, exposurePolicy);
            QUISearchBar qUISearchBar3 = this.f180767j0;
            ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
            VideoReport.setElementClickPolicy(qUISearchBar3, clickPolicy);
            QUISearchBar qUISearchBar4 = this.f180767j0;
            EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
            VideoReport.setElementEndExposePolicy(qUISearchBar4, endExposurePolicy);
            QuickPinyinEditText inputWidget = this.f180767j0.getInputWidget();
            VideoReport.setElementId(inputWidget, "em_search_grey_word");
            VideoReport.setElementClickPolicy(inputWidget, clickPolicy);
            VideoReport.setElementExposePolicy(inputWidget, exposurePolicy);
            VideoReport.setElementEndExposePolicy(inputWidget, endExposurePolicy);
        }
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    protected void doOnDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.doOnDestroy();
        Looper.myQueue().removeIdleHandler(this.f180806s0);
        AutoHintLayout autoHintLayout = this.f180805r0;
        if (autoHintLayout != null) {
            autoHintLayout.u(this);
        }
        this.f180767j0.unbindSearchChain(false);
        AutoHintLayout autoHintLayout2 = this.f180805r0;
        if (autoHintLayout2 != null) {
            autoHintLayout2.u(this);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.finish();
        if (!TextUtils.isEmpty(getIntent().getStringExtra("start_search_key"))) {
            return;
        }
        overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity
    protected void initViews() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.initViews();
        this.f180805r0 = this.f180767j0.getAutoHintLayout();
        this.f180766i0.setVisibility(8);
        String stringExtra = getIntent().getStringExtra("start_search_key");
        boolean isEmpty = TextUtils.isEmpty(stringExtra);
        int i3 = 0;
        if (!isEmpty) {
            if (this.f180762e0 == 12) {
                this.f180765h0.setHint(HardCodeUtil.qqStr(R.string.t6_) + ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getSubscriptName(this.app, getApplicationContext()) + HardCodeUtil.qqStr(R.string.t69));
            } else {
                this.f180765h0.setHint(HardCodeUtil.qqStr(R.string.t6f));
            }
            this.f180765h0.setText(stringExtra);
            EditText editText = this.f180765h0;
            editText.setSelection(editText.getText().length());
            this.f180764g0.setVisibility(0);
        }
        int i16 = this.f180760c0;
        if (i16 == 1 || i16 == 6) {
            if (this.f180761d0 == 4) {
                this.f180765h0.setHint(HardCodeUtil.qqStr(R.string.t6g));
            } else {
                this.f180765h0.setHint(HardCodeUtil.qqStr(R.string.yk_));
            }
        }
        this.f180765h0.addTextChangedListener(new a(isEmpty));
        this.f180767j0.setActionCallback(new b());
        if (AppSetting.f99565y) {
            if (this.f180762e0 == 12) {
                this.f180765h0.setContentDescription(HardCodeUtil.qqStr(R.string.t6i));
            } else {
                this.f180765h0.setContentDescription(HardCodeUtil.qqStr(R.string.t6e));
            }
        }
        if (!TextUtils.isEmpty(stringExtra) && !getIntent().getBooleanExtra("auto_add_and_prohibit_auto_search", false)) {
            return;
        }
        Looper.myQueue().addIdleHandler(this.f180806s0);
        this.f180767j0.bindSearchChain(false);
        ArrayList<String> stringArrayListExtra = getIntent().getStringArrayListExtra("home_hint_words");
        U2();
        if (stringArrayListExtra != null && !stringArrayListExtra.isEmpty()) {
            i3 = 1;
        }
        if (i3 != 0) {
            this.f180805r0.setHintList(stringArrayListExtra);
            this.f180805r0.setInterval(5000L);
            this.f180805r0.setAnimDuration(400);
            this.f180805r0.m(this);
        } else {
            this.f180765h0.setHint("\u7fa4\u53f7/\u7fa4\u540d");
            QLog.i("qqBaseActivity", 1, "hintWords is null or empty");
        }
        VideoReport.setElementParam(this.f180767j0, "is_shading", Integer.valueOf(i3));
    }

    @Override // com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity, com.tencent.mobileqq.app.BaseActivity, com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    @Override // com.tencent.mobileqq.search.view.AutoHintLayout.b
    public void onHintChange(int i3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), str, str2);
            return;
        }
        QuickPinyinEditText inputWidget = this.f180767j0.getInputWidget();
        HashMap hashMap = new HashMap();
        hashMap.put("literal_text", str);
        VideoReport.setElementId(inputWidget, "em_search_grey_word");
        VideoReport.setElementParams(inputWidget, hashMap);
        VideoReport.reportEvent("dt_imp", inputWidget, hashMap);
    }
}
