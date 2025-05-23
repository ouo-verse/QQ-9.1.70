package com.tencent.hippykotlin.demo.pages.compose_ui.view.qui;

import androidx.compose.runtime.Composer;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class CenterContentConfig {
    public final Function2<Composer, Integer, Unit> centerContent;
    public final int centerContentType;
    public final String centerText;
    public final String centerTextColor;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2<-Landroidx/compose/runtime/Composer;-Ljava/lang/Integer;Lkotlin/Unit;>;)V */
    public CenterContentConfig(int i3, String str, String str2, Function2 function2) {
        this.centerContentType = i3;
        this.centerText = str;
        this.centerTextColor = str2;
        this.centerContent = function2;
    }

    public /* synthetic */ CenterContentConfig(String str) {
        this(2, str, "text_nav_secondary", null);
    }
}
