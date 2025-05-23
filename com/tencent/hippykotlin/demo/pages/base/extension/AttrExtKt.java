package com.tencent.hippykotlin.demo.pages.base.extension;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.views.ce;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AttrExtKt {
    public static final void backgroundColorToken(Attr attr, String str) {
        h hVar;
        hVar = IPagerIdKtxKt.getSkinColor(attr).tokenColor(str, false);
        attr.mo113backgroundColor(hVar);
    }

    public static final void colorToken(ce ceVar, String str) {
        h hVar;
        hVar = IPagerIdKtxKt.getSkinColor(ceVar).tokenColor(str, false);
        ceVar.color(hVar);
    }
}
