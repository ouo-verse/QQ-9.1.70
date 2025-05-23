package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.biz.pubaccount.api.IPublicAccountWebviewPlugin;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes9.dex */
public class em {
    static IPatchRedirector $redirector_;

    private static void a(Activity activity) {
        Intent intent = new Intent();
        intent.putExtra("last_key_words", "");
        intent.putExtra("from_key", 2);
        intent.putExtra(ClassificationSearchActivity.L0, ClassificationSearchActivity.I0);
        intent.setClass(activity, ClassificationSearchActivity.class);
        ClassificationSearchActivity.V2(activity, intent, null);
    }

    public static void b(Activity activity) {
        a(activity);
    }

    public static void c(Activity activity, String str) {
        Intent intent = new Intent(activity, (Class<?>) ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
        if (activity instanceof BaseActivity) {
            intent.putExtra("uin", ((QQAppInterface) ((BaseActivity) activity).getAppRuntime()).getCurrentAccountUin());
        }
        if (com.tencent.mobileqq.webview.swift.ag.f314191a.containsKey(IPublicAccountWebviewPlugin.NAME_SPACE)) {
            intent.putExtra("insertPluginsArray", new String[]{IPublicAccountWebviewPlugin.NAME_SPACE});
        }
        intent.putExtra("fromLocalUrl", true);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra(IPublicAccountBrowser.KEY_HIDE_SHARE_BUTTON, true);
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, activity.getString(R.string.f171208d54));
        intent.putExtra(IPublicAccountBrowser.KEY_BACK_TEXT, activity.getString(R.string.f171208d54));
        if (TextUtils.isEmpty(str)) {
            intent.putExtra("url", ((IPublicAccountConfigUtil) QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountCategoryUrl());
        } else {
            intent.putExtra("url", "https://find.mp.qq.com/search/index?_wv=67109947&keyword=" + str);
        }
        activity.startActivity(intent);
    }

    public static void d(Activity activity, String str, String str2, String str3) {
        Intent intent = new Intent(activity, (Class<?>) ((IPublicAccountProxy) QRoute.api(IPublicAccountProxy.class)).getImplClass(IPublicAccountBrowser.class));
        if (TextUtils.isEmpty(str2)) {
            if (activity instanceof BaseActivity) {
                intent.putExtra("uin", ((QQAppInterface) ((BaseActivity) activity).getAppRuntime()).getCurrentAccountUin());
            }
        } else {
            intent.putExtra("uin", str2);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, str);
            intent.putExtra(IPublicAccountBrowser.KEY_BACK_TEXT, str);
        }
        if (com.tencent.mobileqq.webview.swift.ag.f314191a.containsKey(IPublicAccountWebviewPlugin.NAME_SPACE)) {
            intent.putExtra("insertPluginsArray", new String[]{IPublicAccountWebviewPlugin.NAME_SPACE});
        }
        if (TextUtils.isEmpty(str3)) {
            str3 = "https://dyzx.mp.qq.com/static/v8/page/subscribeindex.html?_wv=67109947&_bid=2278&_wwv=1";
        }
        intent.putExtra("fromLocalUrl", true);
        intent.putExtra("hide_operation_bar", true);
        intent.putExtra("url", str3);
        intent.putExtra(IPublicAccountBrowser.KEY_HIDE_SHARE_BUTTON, true);
        activity.startActivity(intent);
    }
}
