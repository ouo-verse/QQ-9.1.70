package com.tencent.qzonehub.api.webview.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewplugin.QzonePlugin;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewProvider;
import com.tencent.mobileqq.webview.util.m;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import com.tencent.smtt.sdk.WebView;
import cooperation.qzone.model.Size;
import cooperation.qzone.webviewplugin.QZoneWebViewPlugin;
import cooperation.qzone.webviewplugin.QzoneDynamicAlbumPlugin;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelperCallBack;
import cooperation.qzone.webviewplugin.QzoneOfflinePluginJsForQQ;
import cooperation.qzone.webviewplugin.QzonePersonalizeJsPlugin;
import cooperation.qzone.webviewplugin.QzonePhotoWallPlugin;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import cooperation.qzone.webviewplugin.personalize.QZonePersonalizeH5Service;
import cooperation.qzone.webviewwrapper.IWebviewWrapper;
import cooperation.qzone.webviewwrapper.QzoneWebViewBaseBuilder;
import cooperation.qzone.webviewwrapper.WebviewWrapper;
import java.io.File;
import java.util.Map;

/* loaded from: classes34.dex */
public class QzoneWebViewPluginHelperImpl implements IQzoneWebViewPluginHelper {
    private static final String TAG = "QzoneWebViewPluginHelperImpl";

    @Override // com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper
    public boolean checkOfflineUrl(String str) {
        return QzoneOfflinePluginJsForQQ.checkOfflineUrl(str);
    }

    @Override // com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper
    public File downLoadFileIfNeeded(AppInterface appInterface, String str, QzoneOfflineCacheHelperCallBack qzoneOfflineCacheHelperCallBack, boolean z16, String str2) {
        return QzoneOfflineCacheHelper.downLoadFileIfNeeded(appInterface, str, qzoneOfflineCacheHelperCallBack, z16, str2);
    }

    @Override // com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper
    public String encodeBase64File(String str, int i3, int i16) {
        return QzoneDynamicAlbumPlugin.encodeBase64File(str, i3, i16);
    }

    @Override // com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper
    public Size getBitmapSize(String str) {
        return QzoneDynamicAlbumPlugin.getBitmapSize(str);
    }

    @Override // com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper
    public Map<Integer, Long> getCTime(Long l3) {
        return QZonePersonalizeH5Service.getCTime(l3);
    }

    @Override // com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper
    public double getRatio(Context context, int i3, Size size) {
        return QzonePhotoWallPlugin.getRatio(context, i3, size);
    }

    @Override // com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper
    public IWebviewWrapper getWebviewWrapper(Context context) {
        return new WebviewWrapper(context);
    }

    @Override // com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper
    public void notifyWebviewStartAnimation(WebView webView) {
        if (webView instanceof CustomWebView) {
            QzonePersonalizeJsPlugin.notifyWebviewStartAnimation((CustomWebView) webView);
        }
    }

    @Override // com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper
    public void savePayActionResult(WebViewProvider webViewProvider, String str) {
        QzonePlugin qzonePlugin = (QzonePlugin) webViewProvider.getWebView().getPluginEngine().n(QzonePlugin.C, true);
        if (qzonePlugin != null) {
            qzonePlugin.u(str);
            return;
        }
        QLog.e(TAG, 1, "savePayActionResult error, qzone plugin is null, result is: " + str);
    }

    @Override // com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper
    public void updateCTime(Integer num, Long l3) {
        QZonePersonalizeH5Service.updateCTime(num, l3);
    }

    @Override // com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper
    public m getQzoneWebViewBaseBuilder(Context context, Activity activity, Intent intent, AppInterface appInterface, boolean z16, WebView webView) {
        QzoneWebViewBaseBuilder qzoneWebViewBaseBuilder = new QzoneWebViewBaseBuilder(context, activity, intent, appInterface, z16);
        if (webView instanceof TouchWebView) {
            qzoneWebViewBaseBuilder.setWebView((TouchWebView) webView);
        }
        return qzoneWebViewBaseBuilder;
    }

    @Override // com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper
    public WebViewPlugin getQzoneWebViewOfflinePlugin() {
        return new QzoneWebViewOfflinePlugin();
    }

    @Override // com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper
    public WebViewPlugin getQzoneWebViewPlugin() {
        return new QZoneWebViewPlugin();
    }
}
