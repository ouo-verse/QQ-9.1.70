package com.tencent.xweb;

import android.view.View;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface WebViewCallbackClient {
    void onContentHeightChanged(int i3);

    void onOverScrolled(int i3, int i16, boolean z16, boolean z17, View view);

    void onScrollChanged(int i3, int i16, int i17, int i18, View view);

    boolean overScrollBy(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, boolean z16, View view);
}
