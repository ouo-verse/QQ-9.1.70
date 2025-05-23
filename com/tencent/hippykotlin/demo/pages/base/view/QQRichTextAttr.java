package com.tencent.hippykotlin.demo.pages.base.view;

import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.views.ce;
import defpackage.k;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQRichTextAttr extends AccessibilityRichTextAttr {
    public static final Companion Companion = new Companion();

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public final float qqFontSize(float f16) {
            c cVar = c.f117352a;
            return k.a(cVar) ? (((float) cVar.g().getPageData().n().i("qqScaleDensity", 1.0d)) * f16) / PageDataExtKt.getDpScaleDensity(cVar.g().getPageData()) : f16;
        }
    }

    @Override // com.tencent.kuikly.core.views.ce
    public final ce fontSize(float f16, Boolean bool) {
        return super.fontSize(Companion.qqFontSize(f16), bool);
    }
}
