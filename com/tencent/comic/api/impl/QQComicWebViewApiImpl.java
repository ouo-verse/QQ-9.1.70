package com.tencent.comic.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.comic.VipComicHelper;
import com.tencent.comic.api.IQQComicWebViewApi;
import com.tencent.comic.data.c;
import com.tencent.comic.hippy.QQHippyCommonJsPluginFactory;
import com.tencent.comic.ui.QQComicFragment;
import com.tencent.comic.ui.QQComicTabBarView;
import com.tencent.comic.ui.QQComicTitleBarView;
import com.tencent.comic.utils.h;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;
import com.tencent.mobileqq.webview.swift.component.v;
import com.tencent.mobileqq.widget.TabBarView;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QQComicWebViewApiImpl implements IQQComicWebViewApi {
    @Override // com.tencent.comic.api.IQQComicWebViewApi
    public String addUrlField(String str, String str2, String str3) {
        return h.b(str, str2, str3);
    }

    @Override // com.tencent.comic.api.IQQComicWebViewApi
    public Object createComicFragment(Intent intent) {
        return QQComicFragment.wh(intent);
    }

    @Override // com.tencent.comic.api.IQQComicWebViewApi
    public View createComicTabBarView(Context context, Intent intent, List<c> list, TabBarView.d dVar) {
        QQComicTabBarView qQComicTabBarView = new QQComicTabBarView(context);
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            WebViewTabBarData webViewTabBarData = new WebViewTabBarData();
            webViewTabBarData.tabIcon = cVar.f99320d;
            webViewTabBarData.tabName = cVar.f99317a;
            webViewTabBarData.tag = cVar.f99318b;
            webViewTabBarData.url = cVar.f99319c;
            arrayList.add(webViewTabBarData);
        }
        qQComicTabBarView.a(intent, arrayList, dVar);
        return qQComicTabBarView;
    }

    @Override // com.tencent.comic.api.IQQComicWebViewApi
    public Object createComicTitleBarUI(Object obj) {
        if (obj instanceof v) {
            return new QQComicTitleBarView((v) obj);
        }
        return null;
    }

    @Override // com.tencent.comic.api.IQQComicWebViewApi
    public Object getCommonJsPluginFactory() {
        return new QQHippyCommonJsPluginFactory();
    }

    @Override // com.tencent.comic.api.IQQComicWebViewApi
    public boolean isBoodoUrl(String str) {
        return h.e(str);
    }

    @Override // com.tencent.comic.api.IQQComicWebViewApi
    public void openComicWebView(Activity activity, String str, Intent intent) {
        if (VipComicHelper.e(str, intent)) {
            intent.setClassName("com.qqcomic", "com.qqcomic.activity.media.VipComicMediaPlayActivity");
            activity.startActivityForResult(intent, 100);
        } else {
            VipComicHelper.f(activity, intent, 100);
        }
    }

    @Override // com.tencent.comic.api.IQQComicWebViewApi
    public String replaceUrlFieldValueReg(String str, String str2, String str3) {
        return h.f(str, str2, str3);
    }

    @Override // com.tencent.comic.api.IQQComicWebViewApi
    public void updateOfflinePkgAsync(int i3, AppRuntime appRuntime) {
    }
}
