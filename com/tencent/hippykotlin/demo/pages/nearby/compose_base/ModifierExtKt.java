package com.tencent.hippykotlin.demo.pages.nearby.compose_base;

import com.tencent.kuikly.core.base.w;
import com.tencent.ntcompose.core.i;
import com.tencent.ntcompose.foundation.layout.ComposeLayoutPropUpdaterKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ModifierExtKt {
    public static final i size(i iVar, w wVar) {
        return ComposeLayoutPropUpdaterKt.k(ComposeLayoutPropUpdaterKt.w(iVar, wVar.getWidth()), wVar.getHeight());
    }
}
