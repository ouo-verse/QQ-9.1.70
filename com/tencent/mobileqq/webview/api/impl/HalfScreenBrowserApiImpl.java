package com.tencent.mobileqq.webview.api.impl;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.activity.aio.intimate.reborn.model.HalfScreenWebViewCloseEvent;
import com.tencent.mobileqq.webview.api.IHalfScreenBrowserApi;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes35.dex */
public class HalfScreenBrowserApiImpl implements IHalfScreenBrowserApi {
    private static final String TAG = "HalfScreenBrowserApiImpl";

    @Override // com.tencent.mobileqq.webview.api.IHalfScreenBrowserApi
    public void webViewClose(int i3) {
        QLog.i(TAG, 1, "webViewClose");
        SimpleEventBus.getInstance().dispatchEvent(new HalfScreenWebViewCloseEvent(i3), true);
    }
}
