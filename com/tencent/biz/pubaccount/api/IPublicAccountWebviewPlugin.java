package com.tencent.biz.pubaccount.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPublicAccountWebviewPlugin extends QRouteApi {
    public static final String NAME_SPACE = "PublicAccountJs";
    public static final String SCHEME = "publicaccount";

    WebViewPlugin getWebViewPlugin();
}
