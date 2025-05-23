package com.tencent.biz.richframework.monitor.window;

import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a8\u0006\u0004"}, d2 = {"getRefresh", "", "window", "Landroid/view/Window;", "monitor_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class WindowUtilsKt {
    public static final float getRefresh(@Nullable Window window) {
        float f16;
        if (window != null) {
            WindowManager windowManager = window.getWindowManager();
            Intrinsics.checkNotNullExpressionValue(windowManager, "window.windowManager");
            Display display = windowManager.getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(display, "display");
            f16 = display.getRefreshRate();
        } else {
            f16 = 60.0f;
        }
        if (f16 < 30.0f) {
            return 60.0f;
        }
        if (f16 > 200.0f) {
            return 120.0f;
        }
        return f16;
    }
}
