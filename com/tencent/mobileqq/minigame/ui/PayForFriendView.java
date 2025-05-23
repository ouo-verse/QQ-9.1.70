package com.tencent.mobileqq.minigame.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.utils.GameWnsUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.m;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* loaded from: classes33.dex */
public class PayForFriendView extends TouchWebView {
    public static final String TAG = "[minigame] PayForFriendView";
    private BaseActivity mActivity;
    private String mAppIconUrl;
    private String mAppId;
    private String mAppName;
    private int mAppVerType;
    private String mAppVersionId;
    private TouchWebView mWebView;

    public PayForFriendView(Context context) {
        super(context);
        this.mActivity = (BaseActivity) context;
        initUI();
    }

    private void initUI() {
        this.mWebView = this;
        setBackgroundColor(0);
        this.mWebView.getBackground().setAlpha(0);
        this.mWebView.getSettings().setCacheMode(2);
        IQzoneWebViewPluginHelper iQzoneWebViewPluginHelper = (IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class);
        Context context = getContext();
        BaseActivity baseActivity = this.mActivity;
        new m((com.tencent.mobileqq.webview.util.m) iQzoneWebViewPluginHelper.getQzoneWebViewBaseBuilder(context, baseActivity, null, baseActivity.getAppInterface(), false, this.mWebView)).a(null, MiniAppUtils.getAppInterface(), null);
    }

    public String getAppIconUrl() {
        return this.mAppIconUrl;
    }

    public String getAppId() {
        return this.mAppId;
    }

    public String getAppName() {
        return this.mAppName;
    }

    public int getAppVerType() {
        return this.mAppVerType;
    }

    public String getAppVersionId() {
        return this.mAppVersionId;
    }

    public boolean setUrl(String str, String str2, String str3, String str4, String str5, int i3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            this.mAppId = str2;
            this.mAppName = str3;
            this.mAppIconUrl = str4;
            this.mAppVersionId = str5;
            this.mAppVerType = i3;
            String replace = GameWnsUtils.getPayForFriendUrl().replace("{appid}", str2).replace("{prepayId}", str);
            WebSoService.j().e();
            if (this.mWebView != null) {
                QLog.d(TAG, 1, "setUrl url:" + replace);
                this.mWebView.loadUrl(replace);
                return true;
            }
        }
        return false;
    }

    public PayForFriendView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initUI();
    }
}
