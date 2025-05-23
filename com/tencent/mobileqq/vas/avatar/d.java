package com.tencent.mobileqq.vas.avatar;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {
    public static int a(int i3) {
        if (i3 < 0) {
            QLog.e("Q.qqhead.VasFaceManager", 1, "unknown DynamicSource", new RuntimeException("DynamicFaceDrawable don't have " + i3));
            return 7;
        }
        return i3;
    }
}
