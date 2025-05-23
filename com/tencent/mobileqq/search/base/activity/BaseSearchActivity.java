package com.tencent.mobileqq.search.base.activity;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.api.IFTSFetcher;
import com.tencent.mobileqq.search.base.fragment.BaseSearchFragment;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.search.util.ai;
import com.tencent.mobileqq.search.util.x;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ca;
import com.tencent.mobileqq.widget.search.ActionCallbackAdapter;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.MobileQQ;
import rn2.d;
import rn2.k;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class BaseSearchActivity extends QBaseActivity implements TextWatcher {

    /* renamed from: m0, reason: collision with root package name */
    public static int f282781m0 = -1;

    /* renamed from: a0, reason: collision with root package name */
    protected String f282782a0;

    /* renamed from: b0, reason: collision with root package name */
    protected QUISearchBar f282783b0;

    /* renamed from: c0, reason: collision with root package name */
    protected QuickPinyinEditText f282784c0;

    /* renamed from: d0, reason: collision with root package name */
    protected BaseSearchFragment f282785d0;

    /* renamed from: e0, reason: collision with root package name */
    protected CancelReceiver f282786e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f282787f0;

    /* renamed from: g0, reason: collision with root package name */
    protected View f282788g0;

    /* renamed from: h0, reason: collision with root package name */
    protected boolean f282789h0 = false;

    /* renamed from: i0, reason: collision with root package name */
    public String f282790i0 = null;

    /* renamed from: j0, reason: collision with root package name */
    public String f282791j0 = null;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f282792k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    public int f282793l0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class CancelReceiver extends BroadcastReceiver {
        public CancelReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.tencent.mobileqq.search.cancel".equals(intent.getAction())) {
                BaseSearchActivity.this.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a extends ActionCallbackAdapter {
        a() {
        }

        @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public int onCancel() {
            BaseSearchActivity.this.G2();
            return 1;
        }

        @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onClear() {
            BaseSearchActivity.f282781m0 = 1;
            return super.onClear();
        }

        @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
            BaseSearchActivity.this.H2();
            String trim = BaseSearchActivity.this.f282784c0.getText().toString().trim();
            if (!TextUtils.isEmpty(trim)) {
                BaseSearchActivity.this.L2(trim);
            }
            BaseSearchActivity.this.hideInputMethod();
        }
    }

    private void initView() {
        QUISearchBar qUISearchBar = (QUISearchBar) super.findViewById(R.id.search_box);
        this.f282783b0 = qUISearchBar;
        qUISearchBar.bindSearchChain(false);
        this.f282783b0.setCustomResource(k.a());
        this.f282783b0.setActionCallback(new a());
        QuickPinyinEditText inputWidget = this.f282783b0.getInputWidget();
        this.f282784c0 = inputWidget;
        inputWidget.setHint(J2());
        this.f282784c0.addTextChangedListener(this);
        if ("1".equals(((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.search_input_type.name(), "0"))) {
            this.f282784c0.setInputType(524321);
        } else {
            this.f282784c0.setInputType(524289);
        }
        if (this.f282789h0) {
            this.f282784c0.getInputExtras(true).putInt("QUICK_SEARCH", 1);
        }
        N2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G2() {
        if (QLog.isColorLevel()) {
            QLog.d("searchUtils", 2, "cancelType-3 ResultModule:" + d.c());
        }
        ReportController.o(null, "CliOper", "", "", "0X8005E13", "0X8005E13", 0, 0, "3", "", d.c(), "");
        super.sendBroadcast(new Intent("com.tencent.mobileqq.search.cancel"));
        f282781m0 = 0;
        finish();
    }

    protected String I2() {
        return String.valueOf(0);
    }

    protected String J2() {
        return HardCodeUtil.qqStr(R.string.jzt);
    }

    protected abstract BaseSearchFragment K2();

    /* JADX INFO: Access modifiers changed from: protected */
    public void L2(String str) {
        String str2 = this.f282782a0;
        if (str2 != null && str2.equals(str)) {
            return;
        }
        this.f282782a0 = str;
        this.f282785d0.startSearch(str);
    }

    protected void N2() {
        QUISearchBar qUISearchBar = this.f282783b0;
        if (qUISearchBar != null) {
            ai.c(qUISearchBar.getBackView());
            ai.d(this.f282783b0.getCancelView());
            ai.l(this.f282783b0.getInputWidget());
        }
    }

    public void afterTextChanged(Editable editable) {
        String obj = this.f282784c0.getText().toString();
        TextUtils.isEmpty(obj);
        String trim = obj.trim();
        if (!trim.equals(this.f282782a0)) {
            SearchUtils.f284957f = 0L;
        }
        ai.i(this, findViewById(R.id.root), I2(), x.k(), trim, "");
        M2(trim);
        L2(trim);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    @TargetApi(14)
    public boolean doOnCreate(Bundle bundle) {
        f282781m0 = -1;
        ca.a(this);
        super.doOnCreate(bundle);
        super.setContentView(getLayoutId());
        this.f282788g0 = super.findViewById(R.id.root);
        if (this.mNeedStatusTrans && ImmersiveUtils.isSupporImmersive() == 1) {
            this.f282788g0.setFitsSystemWindows(true);
        }
        this.f282787f0 = super.getIntent().getIntExtra("extra_key_fts_type", 0);
        initView();
        this.f282782a0 = super.getIntent().getStringExtra("keyword");
        FragmentManager supportFragmentManager = super.getSupportFragmentManager();
        this.f282785d0 = K2();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.replace(R.id.ijj, this.f282785d0);
        beginTransaction.commitAllowingStateLoss();
        if (!TextUtils.isEmpty(this.f282782a0)) {
            this.f282784c0.setText(this.f282782a0);
            this.f282784c0.setSelection(this.f282782a0.length());
            this.f282785d0.startSearch(this.f282782a0);
            hideInputMethod();
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.search.base.activity.BaseSearchActivity.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseSearchActivity.this.f282784c0.requestFocus();
                    ((InputMethodManager) BaseSearchActivity.this.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).showSoftInput(BaseSearchActivity.this.f282784c0, 0);
                }
            }, 500L);
        }
        this.f282786e0 = new CancelReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mobileqq.search.cancel");
        super.registerReceiver(this.f282786e0, intentFilter);
        ai.i(this, this.f282788g0, I2(), "", "", "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        try {
            CancelReceiver cancelReceiver = this.f282786e0;
            if (cancelReceiver != null) {
                super.unregisterReceiver(cancelReceiver);
                this.f282786e0 = null;
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        try {
            this.f282784c0.setFocusable(false);
            this.f282784c0.setFocusableInTouchMode(false);
            this.f282784c0.setVisibility(8);
            if (this.f282784c0.getParent() != null) {
                ((ViewGroup) this.f282784c0.getParent()).removeView(this.f282784c0);
            }
            this.f282784c0.removeTextChangedListener(this);
            this.f282784c0.setOnEditorActionListener(null);
            this.f282783b0.unbindSearchChain(false);
        } catch (Error e17) {
            e17.printStackTrace();
        } catch (Exception e18) {
            e18.printStackTrace();
        }
        SearchUtils.f284962k = null;
        f282781m0 = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnStart() {
        super.doOnStart();
        ((IFTSFetcher) QRoute.api(IFTSFetcher.class)).setIntoFTSMessagePage(false);
    }

    protected int getLayoutId() {
        return R.layout.b1s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void hideInputMethod() {
        this.f282784c0.clearFocus();
        ((InputMethodManager) MobileQQ.sMobileQQ.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)).hideSoftInputFromWindow(this.f282784c0.getWindowToken(), 0);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        EventCollector.getInstance().onActivityConfigurationChanged(this, configuration);
    }

    protected void H2() {
    }

    protected void M2(String str) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
