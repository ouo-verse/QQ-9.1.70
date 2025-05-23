package com.tencent.hippykotlin.demo.pages.goods_center.shell;

import java.util.Set;

/* compiled from: P */
/* loaded from: classes31.dex */
public interface IGoodsCenterEvent {
    Set<String> canHandleEventName();

    void onEvent(String str, Object obj);
}
