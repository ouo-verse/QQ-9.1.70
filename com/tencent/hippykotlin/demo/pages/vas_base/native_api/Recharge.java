package com.tencent.hippykotlin.demo.pages.vas_base.native_api;

import com.tencent.hippykotlin.demo.pages.foundation.lib.QQContext;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class Recharge {
    public Recharge() {
        if (QQContext.INSTANCE.isDebug() && QQUtils.INSTANCE.compare("9.0.85") < 0) {
            throw new RuntimeException("debug\u5305\u5f02\u5e38\uff1a\u4e0d\u652f\u63019085\u4ee5\u4e0b\u7248\u672c\u8c03\u7528");
        }
    }
}
