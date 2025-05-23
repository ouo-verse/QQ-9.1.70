package com.tencent.hippykotlin.demo.pages.adelie.page.compose;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GuardFastClickKt {
    public static long lastClickTime;

    public static final void guardFastClick(Function0<Unit> function0) {
        long currentTimeStamp = Utils.INSTANCE.currentBridgeModule().currentTimeStamp();
        if (currentTimeStamp - lastClickTime > 500) {
            function0.invoke();
            lastClickTime = currentTimeStamp;
        }
    }
}
