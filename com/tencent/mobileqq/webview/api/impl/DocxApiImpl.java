package com.tencent.mobileqq.webview.api.impl;

import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.jsp.DocxApiPlugin;
import com.tencent.mobileqq.webview.api.IDocxApi;

/* compiled from: P */
/* loaded from: classes35.dex */
public class DocxApiImpl implements IDocxApi {
    @Override // com.tencent.mobileqq.webview.api.IDocxApi
    public void sendDocsDataBack(String str, TouchWebView touchWebView) {
        DocxApiPlugin.sendDocsDataBack(str, touchWebView);
    }
}
