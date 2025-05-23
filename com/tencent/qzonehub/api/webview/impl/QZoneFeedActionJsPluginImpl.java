package com.tencent.qzonehub.api.webview.impl;

import com.tencent.qzonehub.api.webview.IQZoneFeedActionJsPlugin;
import cooperation.qzone.webviewplugin.QZoneFeedActionJsPlugin;

/* loaded from: classes34.dex */
public class QZoneFeedActionJsPluginImpl implements IQZoneFeedActionJsPlugin {
    @Override // com.tencent.qzonehub.api.webview.IQZoneFeedActionJsPlugin
    public String getName() {
        return QZoneFeedActionJsPlugin.name;
    }

    @Override // com.tencent.qzonehub.api.webview.IQZoneFeedActionJsPlugin
    public boolean getsAcceptEncoded() {
        return QZoneFeedActionJsPlugin.sAcceptEncoded;
    }
}
