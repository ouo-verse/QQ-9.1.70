package com.tencent.qqmini.minigame.utils;

import com.tencent.mobileqq.triton.utils.LogDelegate;
import com.tencent.qqmini.minigame.manager.GameVConsoleManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J*\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0017J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqmini/minigame/utils/d;", "Lcom/tencent/mobileqq/triton/utils/LogDelegate;", "Lcom/tencent/mobileqq/triton/utils/LogDelegate$Level;", "level", "", "tag", "message", "", "throwable", "", "printLog", "printConsoleLog", "logStr", "printJsConsoleLog", "<init>", "()V", "a", "lib_minigame_internalRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes23.dex */
public final class d implements LogDelegate {
    @Override // com.tencent.mobileqq.triton.utils.LogDelegate
    @Deprecated(message = "use[printJsConsoleLog]")
    public void printConsoleLog(@NotNull LogDelegate.Level level, @NotNull String tag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(level, "level");
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
    }

    @Override // com.tencent.mobileqq.triton.utils.LogDelegate
    public void printJsConsoleLog(@NotNull String logStr) {
        Intrinsics.checkParameterIsNotNull(logStr, "logStr");
        GameVConsoleManager.INSTANCE.e(logStr);
    }

    @Override // com.tencent.mobileqq.triton.utils.LogDelegate
    public void printLog(@NotNull LogDelegate.Level level, @NotNull String tag, @NotNull String message, @Nullable Throwable throwable) {
        Intrinsics.checkParameterIsNotNull(level, "level");
        Intrinsics.checkParameterIsNotNull(tag, "tag");
        Intrinsics.checkParameterIsNotNull(message, "message");
        int i3 = e.f346837a[level.ordinal()];
        if (i3 != 1 && i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 == 5) {
                        QMLog.e("[minigame]" + tag, message, throwable);
                        return;
                    }
                    return;
                }
                QMLog.w("[minigame]" + tag, message, throwable);
                return;
            }
            QMLog.d("[minigame]" + tag, message, throwable);
            return;
        }
        QMLog.i("[minigame]" + tag, message, throwable);
    }
}
