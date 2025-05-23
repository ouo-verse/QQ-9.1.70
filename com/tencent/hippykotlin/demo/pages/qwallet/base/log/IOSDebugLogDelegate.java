package com.tencent.hippykotlin.demo.pages.qwallet.base.log;

import com.tencent.kuikly.core.manager.c;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class IOSDebugLogDelegate {
    public final void print(String str) {
        if (c.f117352a.g().getPageData().u()) {
            System.out.println((Object) str);
        }
    }
}
