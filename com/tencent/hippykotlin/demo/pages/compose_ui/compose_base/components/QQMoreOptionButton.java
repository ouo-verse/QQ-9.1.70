package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import bp3.c;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIColor;
import com.tencent.kuikly.core.base.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQMoreOptionButton {
    public final Function2<Composer, Integer, Unit> buttonBuilder;
    public final Function0<Unit> buttonClickFn;
    public final h buttonColor;
    public final float buttonWidth;
    public final String text;
    public final Function2<Composer, Integer, Unit> textBuilder;
    public final h textColor;
    public final float textFontSize;
    public final c textFontWeight;

    public QQMoreOptionButton() {
        this(0.0f, null, null, null, 0.0f, null, 511);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QQMoreOptionButton(float f16, h hVar, Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, String str, float f17, c cVar, h hVar2, Function2<? super Composer, ? super Integer, Unit> function22) {
        this.buttonWidth = f16;
        this.buttonColor = hVar;
        this.buttonClickFn = function0;
        this.buttonBuilder = function2;
        this.text = str;
        this.textFontSize = f17;
        this.textFontWeight = cVar;
        this.textColor = hVar2;
        this.textBuilder = function22;
    }

    public /* synthetic */ QQMoreOptionButton(float f16, h hVar, Function0 function0, String str, float f17, c cVar, int i3) {
        this((i3 & 1) != 0 ? 0.0f : f16, (i3 & 2) != 0 ? QUIColor.INSTANCE.getButtonBgPrimaryDefault() : hVar, (i3 & 4) != 0 ? new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components.QQMoreOptionButton.1
            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                return Unit.INSTANCE;
            }
        } : function0, null, (i3 & 16) != 0 ? "" : str, (i3 & 32) != 0 ? 17.0f : f17, (i3 & 64) != 0 ? c.INSTANCE.e() : cVar, (i3 & 128) != 0 ? h.INSTANCE.m() : null, null);
    }
}
