package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.views.ce;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TextViewExtKt {
    public static final String fixLineHeightForView(String str) {
        if (!AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(c.f117352a)) {
            return str;
        }
        return (char) 0 + str;
    }

    public static final void textWithLineHeightFix(ce ceVar, String str) {
        if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(c.f117352a)) {
            ceVar.text((char) 0 + str);
            return;
        }
        ceVar.text(str);
    }
}
