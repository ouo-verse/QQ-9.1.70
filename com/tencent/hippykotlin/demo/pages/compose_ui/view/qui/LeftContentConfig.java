package com.tencent.hippykotlin.demo.pages.compose_ui.view.qui;

import androidx.compose.runtime.Composer;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class LeftContentConfig {
    public final Function0<Unit> leftClickCallback;
    public final Function0<Unit> leftClickDidAppearCallback;
    public final Function2<Composer, Integer, Unit> leftContent;
    public final int leftContentType;
    public final String leftIconCircleColor;
    public final String leftIconColor;
    public final String leftText;
    public final String leftTextColor;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0<Lkotlin/Unit;>;Lkotlin/jvm/functions/Function0<Lkotlin/Unit;>;Lkotlin/jvm/functions/Function2<-Landroidx/compose/runtime/Composer;-Ljava/lang/Integer;Lkotlin/Unit;>;)V */
    public LeftContentConfig(int i3, String str, String str2, String str3, String str4, Function0 function0, Function0 function02, Function2 function2) {
        this.leftContentType = i3;
        this.leftText = str;
        this.leftTextColor = str2;
        this.leftIconColor = str3;
        this.leftIconCircleColor = str4;
        this.leftClickDidAppearCallback = function0;
        this.leftClickCallback = function02;
        this.leftContent = function2;
    }

    public /* synthetic */ LeftContentConfig(String str, Function0 function0, int i3) {
        this((i3 & 1) != 0 ? 1 : 3, null, (i3 & 4) != 0 ? "text_nav_secondary" : null, (i3 & 8) != 0 ? "icon_nav_secondary" : str, (i3 & 16) != 0 ? "icon_allwhite_primary" : null, null, (i3 & 64) != 0 ? null : function0, null);
    }
}
