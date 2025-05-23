package com.tencent.luggage.wxa.kj;

import android.content.Context;
import android.view.View;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public interface o0 extends com.tencent.luggage.wxa.ei.j, com.tencent.luggage.wxa.hp.a {
    boolean A();

    void a(int i3, int i16);

    void a(int i3, long j3);

    void a(Context context);

    void a(String str, String str2);

    void c(Runnable runnable);

    @Override // com.tencent.luggage.wxa.ei.j
    void destroy();

    int getContentHeight();

    View getContentView();

    com.tencent.luggage.wxa.wj.d getFullscreenImpl();

    int getHeight();

    v getPageView();

    String getUserAgentString();

    int getWebScrollX();

    int getWebScrollY();

    int getWidth();

    View getWrapperView();

    void onBackground();

    void onForeground();

    void setAppBrandInfo(Map map);

    void setAppBrandWebViewClient(b0 b0Var);

    void setBackgroundColor(int i3);

    void setDisableContextMenuItems(int i3);

    void setFullscreenImpl(com.tencent.luggage.wxa.wj.d dVar);

    void setOnScrollChangedListener(f0 f0Var);

    void setOnTrimListener(e0 e0Var);

    void setVerticalScrollBarEnabled(boolean z16);

    void setWebViewLayoutListener(d0 d0Var);

    void setXWebKeyboardImpl(h0 h0Var);

    boolean x();

    void z();
}
