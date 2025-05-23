package com.tencent.mobileqq.wink.editor.util;

import com.tencent.mobileqq.wink.sdk.Wink;

/* compiled from: P */
/* loaded from: classes21.dex */
public class o {
    public static boolean a(String str, boolean z16) {
        z93.e h16 = Wink.INSTANCE.h();
        if (h16 != null) {
            return h16.preloadWebView(str, z16);
        }
        return false;
    }
}
