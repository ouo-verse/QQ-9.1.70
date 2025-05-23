package com.tencent.mobileqq.minigame.publicaccount;

import android.app.Activity;
import android.content.Context;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qqgamepub.web.c;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import java.util.ArrayList;

/* loaded from: classes33.dex */
public class MiniGamePublicAccountWebViewBuilder extends c {
    public MiniGamePublicAccountWebViewBuilder(Context context, Activity activity, AppInterface appInterface, TouchWebView touchWebView) {
        super(context, activity, appInterface, touchWebView);
    }

    @Override // com.tencent.mobileqq.qqgamepub.web.c, com.tencent.mobileqq.webview.AbsWebView
    public void bindJavaScript(ArrayList<WebViewPlugin> arrayList) {
        super.bindJavaScript(arrayList);
        arrayList.add(new MiniGamePublicAccountWebViewJsPlugin());
    }
}
