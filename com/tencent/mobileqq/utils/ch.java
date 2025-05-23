package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ch {
    public static int a(boolean z16, boolean z17, boolean z18) {
        if (!com.tencent.mobileqq.inject.a.f238063a.enableTalkBack()) {
            if (z18) {
                return R.string.hq_;
            }
            if (z17) {
                return R.string.hqb;
            }
            if (z16) {
                return R.string.hqd;
            }
            return R.string.hqa;
        }
        return 0;
    }
}
