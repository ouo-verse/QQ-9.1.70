package com.tencent.mobileqq.webview.swift;

import android.app.Activity;
import android.text.TextUtils;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import org.json.JSONObject;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes20.dex */
public class QzoneSwitchFragmentTitleBarUI extends SwiftIphoneTitleBarUI {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements RadioGroup.OnCheckedChangeListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QzoneSwitchFragmentTitleBarUI.this);
            }
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i3) {
            EventCollector.getInstance().onRadioGroupCheckedBefore(radioGroup, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) radioGroup, i3);
            } else {
                int g06 = QzoneSwitchFragmentTitleBarUI.this.g0(radioGroup);
                Activity activity = QzoneSwitchFragmentTitleBarUI.this.f314045d.E;
                if (((QQBrowserActivity) activity).oldTabSelectIndex != g06) {
                    WebViewFragment switchFragment = QQBrowserActivity.switchFragment(g06, (QQBrowserActivity) activity);
                    ((QQBrowserActivity) QzoneSwitchFragmentTitleBarUI.this.f314045d.E).oldTabSelectIndex = g06;
                    if (switchFragment.getSwiftTitleUI() != null && switchFragment.getSwiftTitleUI().f314060m0 != null) {
                        switchFragment.getSwiftTitleUI().f314060m0.setSelectedTab(g06);
                    }
                }
            }
            EventCollector.getInstance().onRadioGroupChecked(radioGroup, i3);
        }
    }

    public QzoneSwitchFragmentTitleBarUI(com.tencent.mobileqq.webview.swift.component.v vVar) {
        super(vVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) vVar);
        }
    }

    @Override // com.tencent.mobileqq.webview.swift.SwiftIphoneTitleBarUI
    public void M(SwiftIphoneTitleBarUI.h hVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) hVar);
            return;
        }
        if (hVar != null) {
            WebViewTopTabView webViewTopTabView = new WebViewTopTabView(BaseApplication.getContext());
            this.f314060m0 = webViewTopTabView;
            webViewTopTabView.setButtonNum(hVar.f314080b, hVar.f314079a);
            this.f314060m0.setButtonText(hVar.f314083e);
            this.f314060m0.setButtonBackgroundResource(R.drawable.b7w, R.drawable.b7x, R.drawable.b7y);
            this.f314060m0.setButtonTextColorStateList(R.color.aks);
            this.f314060m0.setLeftAndRightPaddingByDp(10);
            U(this.f314047e.G);
            int i3 = -1;
            try {
                this.P.removeAllViews();
                this.P.addView(this.f314060m0, new RelativeLayout.LayoutParams(-2, -1));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            if (this.f314045d.E.getIntent().getBooleanExtra(QQBrowserActivity.TOPTAB_SWITCH_FRAGMENT, false)) {
                this.f314060m0.setOnCheckedChangeListener(new a());
                Activity activity = this.f314045d.E;
                if (((QQBrowserActivity) activity).oldTabSelectIndex != -1) {
                    this.f314060m0.setSelectedTab(((QQBrowserActivity) activity).oldTabSelectIndex);
                } else {
                    this.f314060m0.setSelectedTab(activity.getIntent().getIntExtra(QQBrowserActivity.TOPTAB_SELECT_INDEX, 0));
                }
            }
            com.tencent.mobileqq.webview.ui.a aVar = this.f314061n0;
            if (aVar != null) {
                aVar.a(hVar.f314082d, true);
            }
            TouchWebView u16 = this.f314045d.u();
            if (u16 != null && !TextUtils.isEmpty(hVar.f314081c)) {
                if (TextUtils.isEmpty(hVar.f314082d)) {
                    str = "the subTabCallback isEmpty";
                } else {
                    str = FaceConstant.HeadUpload.QQ_HEAD_UPLOAD_ERRMSG_SUCCESS;
                    i3 = 0;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", i3);
                    jSONObject.put("message", str);
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
                u16.callJs(hVar.f314081c, jSONObject.toString());
            }
        }
    }

    public int g0(RadioGroup radioGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) radioGroup)).intValue();
        }
        if (radioGroup != null && (radioGroup instanceof WebViewTopTabView)) {
            for (int i3 = 0; i3 < radioGroup.getChildCount(); i3++) {
                if (((RadioButton) radioGroup.getChildAt(i3)).isChecked()) {
                    return i3;
                }
            }
            return -1;
        }
        return -1;
    }
}
