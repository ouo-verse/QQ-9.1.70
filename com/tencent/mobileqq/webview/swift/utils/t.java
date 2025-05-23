package com.tencent.mobileqq.webview.swift.utils;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.ad;
import com.tencent.mobileqq.webview.swift.z;

/* compiled from: P */
/* loaded from: classes20.dex */
public interface t extends z {
    int getCacheMode(ad adVar);

    boolean interceptInitUIFrame();

    boolean interceptStartLoadUrl();

    boolean interceptTouchEvent(View view, MotionEvent motionEvent);

    void loadUrlFinish();

    void onDataInit(Bundle bundle);

    void onFinalState(Bundle bundle);

    void onInitBottomBar(Bundle bundle);

    void onInitTitleBar(Bundle bundle);

    void onInitUIContent(Bundle bundle);

    void onShowPreview(Bundle bundle);

    void onWebViewInit(Bundle bundle, TouchWebView touchWebView);

    void onX5Init(Bundle bundle);

    boolean softKeyboardResizeCompactOn();
}
