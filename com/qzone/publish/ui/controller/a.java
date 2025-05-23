package com.qzone.publish.ui.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.qzone.publish.ui.activity.QZonePublishMoodTabActivity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.smtt.sdk.WebView;

/* compiled from: P */
/* loaded from: classes39.dex */
public interface a {
    void O4(View view);

    boolean Q();

    void Vf(View view);

    String getCurrentUrl();

    Activity getHostActivity();

    WebViewFragment getHostFragment();

    WebView getHostWebView();

    Share getShare();

    CustomWebView getWebView();

    void gotoSelectPicture(WebViewPlugin webViewPlugin, Intent intent, byte b16);

    boolean isActivityResume();

    void onBack();

    void onNewIntent(Intent intent);

    void pd(QZonePublishMoodTabActivity qZonePublishMoodTabActivity);

    int pluginStartActivityForResult(WebViewPlugin webViewPlugin, Intent intent, byte b16);

    boolean setShareUrl(String str);

    boolean setSummary(String str, String str2, String str3, String str4, Bundle bundle);

    void showActionSheet();

    int switchRequestCode(WebViewPlugin webViewPlugin, byte b16);

    String v0();

    String w();

    void x4();
}
