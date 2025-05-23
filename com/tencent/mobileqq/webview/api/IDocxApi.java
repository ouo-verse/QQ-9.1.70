package com.tencent.mobileqq.webview.api;

import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IDocxApi extends QRouteApi {
    void sendDocsDataBack(String str, TouchWebView touchWebView);
}
