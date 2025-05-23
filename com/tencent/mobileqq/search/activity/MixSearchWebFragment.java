package com.tencent.mobileqq.search.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinEngine;
import com.tencent.widget.immersive.ImmersiveUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MixSearchWebFragment extends WebViewFragment implements TextView.OnEditorActionListener, TextWatcher {
    protected RelativeLayout C;
    protected QuickPinyinEditText D;
    protected Button E;
    protected ImageButton F;
    protected ImageView G;
    public String H;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends com.tencent.mobileqq.webview.swift.proxy.a {
        a(t tVar) {
            super(tVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onFinalState(Bundle bundle) {
            super.onFinalState(bundle);
            MixSearchWebFragment.this.rh(bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MixSearchWebFragment.this.D.setText("");
            MixSearchWebFragment.this.D.requestFocus();
            InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.showSoftInput(MixSearchWebFragment.this.D, 0);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MixSearchWebFragment.this.qh(1);
            MixSearchWebFragment.this.doOnBackEvent();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            MixSearchWebFragment.this.qh(3);
            MixSearchWebFragment.this.doOnBackEvent();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                MixSearchWebFragment.this.D.requestFocus();
                inputMethodManager.showSoftInput(MixSearchWebFragment.this.D, 0);
            }
            MixSearchWebFragment.this.D.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh(Bundle bundle) {
        if ("1".equals(getIntent().getStringExtra("showloadingbar"))) {
            getUIStyleHandler().U.l(true);
        } else {
            getUIStyleHandler().U.l(false);
        }
        if (getSwiftTitleUI().M.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            BaseApplicationImpl application = BaseApplicationImpl.getApplication();
            getSwiftTitleUI().M.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) getSwiftTitleUI().M.getParent();
            View inflate = LayoutInflater.from(application).inflate(R.layout.b1x, (ViewGroup) null);
            int statusBarHeight = ImmersiveUtils.getStatusBarHeight(BaseApplicationImpl.getApplication());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) application.getResources().getDimension(R.dimen.title_bar_height));
            layoutParams.addRule(10, -1);
            layoutParams.topMargin = statusBarHeight;
            viewGroup.addView(inflate, layoutParams);
            QuickPinyinEditText quickPinyinEditText = (QuickPinyinEditText) inflate.findViewById(R.id.et_search_keyword);
            this.D = quickPinyinEditText;
            quickPinyinEditText.setOnEditorActionListener(this);
            this.D.addTextChangedListener(this);
            this.D.setFilters(new InputFilter[]{new InputFilter.LengthFilter(50)});
            QuickPinyinEditText quickPinyinEditText2 = this.D;
            quickPinyinEditText2.mMaxTextLen = 50;
            quickPinyinEditText2.setImeOptions(3);
            this.D.setHint(getIntent().getStringExtra("placeholder"));
            this.H = getIntent().getStringExtra("searchword");
            ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.ib_clear_text);
            this.F = imageButton;
            imageButton.setOnClickListener(new b());
            Button button = (Button) inflate.findViewById(R.id.btn_cancel_search);
            this.E = button;
            button.setText(R.string.cancel);
            this.E.setOnClickListener(new c());
            if ("1".equals(getIntent().getStringExtra("hiderightbtn"))) {
                this.E.setVisibility(8);
            } else {
                this.E.setVisibility(0);
            }
            this.G = (ImageView) inflate.findViewById(R.id.du6);
            if ("1".equals(getIntent().getStringExtra("hideleftarrow"))) {
                this.G.setVisibility(8);
            } else {
                this.G.setVisibility(0);
            }
            if (this.E.getVisibility() == 8 && this.G.getVisibility() == 8) {
                this.E.setVisibility(0);
            }
            this.G.setOnClickListener(new d());
            this.D.getViewTreeObserver().addOnGlobalLayoutListener(new e());
            if (!TextUtils.isEmpty(this.H)) {
                if (this.H.length() > 50) {
                    this.H = this.H.substring(0, 50);
                }
                this.D.setText(this.H);
            }
            this.C = (RelativeLayout) inflate;
            sh();
        }
    }

    private void sh() {
        RelativeLayout relativeLayout = this.C;
        if (relativeLayout == null) {
            return;
        }
        relativeLayout.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(R.drawable.skin_searchbar_bg_theme_version2));
        this.E.setTextColor(Color.parseColor("#777777"));
        this.E.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(R.drawable.skin_searchbar_button_normal_theme_version2));
        this.D.setBackgroundDrawable(SkinEngine.getInstances().getDefaultThemeDrawable(R.drawable.skin_searchbar_input_theme_version2));
        this.D.setCompoundDrawablesWithIntrinsicBounds(SkinEngine.getInstances().getDefaultThemeDrawable(R.drawable.skin_searchbar_icon_theme_version2), (Drawable) null, (Drawable) null, (Drawable) null);
        this.D.setPadding(UIUtils.b(getQBaseActivity(), 10.0f), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
        this.D.setTextColor(-16777216);
        this.D.setHintTextColor(Color.parseColor("#a6a6a6"));
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(editable)) {
            this.F.setVisibility(8);
        } else {
            this.F.setVisibility(0);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("searchWord", editable.toString());
        } catch (JSONException e16) {
            QLog.e(WebViewFragment.TAG, 1, "afterTextChanged, searchWord = " + editable.toString() + ", e = " + e16);
        }
        getWebView().callJs("MixSearchWordDidChange", jSONObject.toString());
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webview.swift.WebViewProvider
    public void doOnBackEvent() {
        if (getWebView() != null) {
            qh(2);
        }
        super.doOnBackEvent();
        if (!"1".equals(getIntent().getStringExtra("openanimtype"))) {
            getQBaseActivity().overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new a(this.webViewSurface);
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i3, KeyEvent keyEvent) {
        String trim;
        boolean z16 = false;
        if (i3 == 3 || (keyEvent != null && keyEvent.getKeyCode() == 66)) {
            String str = "";
            if (this.D.getText() == null) {
                trim = "";
            } else {
                trim = this.D.getText().toString().trim();
            }
            if (this.D.getHint() != null) {
                str = this.D.getHint().toString().trim();
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("searchWord", trim);
                jSONObject.put("placeholder", str);
            } catch (JSONException e16) {
                QLog.e(WebViewFragment.TAG, 1, "onEditorAction, searchWord = " + trim + ", placeholder = " + str + ", e = " + e16);
            }
            getWebView().callJs("MixSearchButtonClicked", jSONObject.toString());
            InputMethodManager inputMethodManager = (InputMethodManager) BaseApplication.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.D.getWindowToken(), 0);
            }
            this.D.clearFocus();
            z16 = true;
        }
        EventCollector.getInstance().onEditorAction(textView, i3, keyEvent);
        return z16;
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        sh();
    }

    protected void qh(int i3) {
        if (i3 >= 1 && i3 <= 3) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("type", i3);
            } catch (JSONException e16) {
                QLog.e(WebViewFragment.TAG, 1, "callJsOnBackClicked, type = " + i3 + ", e = " + e16);
            }
            getWebView().callJs("MixSearchBackClicked", jSONObject.toString());
        }
    }

    public void th(String str, String str2) {
        QuickPinyinEditText quickPinyinEditText = this.D;
        if (quickPinyinEditText != null) {
            quickPinyinEditText.setHint(str2);
            this.D.setText(str);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
    }
}
