package com.tencent.hippykotlin.demo.pages.foundation.qui_token;

import com.tencent.kuikly.core.pager.Pager;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUITokenKt {
    public static final QUITokenThemeMode quiTokenThemeMode(Pager pager) {
        Object obj = pager.getExtProps().get("quiTokenThemeMode");
        if (obj instanceof QUITokenThemeMode) {
            return (QUITokenThemeMode) obj;
        }
        return null;
    }
}
