package com.tencent.hippykotlin.demo.pages.compose_ui.compose_base.components;

import androidx.compose.runtime.Composer;
import com.tencent.ntcompose.foundation.layout.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QUIActionSheetItem {
    public final String accessibility;
    public final Function3<b, Composer, Integer, Unit> content;
    public final Function0<Unit> onClick;

    /* JADX WARN: Multi-variable type inference failed */
    public QUIActionSheetItem(String str, Function3<? super b, ? super Composer, ? super Integer, Unit> function3, Function0<Unit> function0) {
        this.accessibility = str;
        this.content = function3;
        this.onClick = function0;
    }
}
