package com.tencent.mobileqq.triton.engine;

import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.utils.TritonKeep;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J$\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/triton/engine/TTLog;", "", "()V", "VCONSOLE_LOG_DEBUG", "", "printConsoleLog", "", "logMsg", "", "printNativeLog", "level", "tagBytes", "", "infoBytes", "Triton_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes19.dex */
public final class TTLog {
    public static final TTLog INSTANCE = new TTLog();
    private static final int VCONSOLE_LOG_DEBUG = 100;

    TTLog() {
    }

    @JvmStatic
    @TritonKeep
    public static final void printConsoleLog(@NotNull String logMsg) {
        Intrinsics.checkParameterIsNotNull(logMsg, "logMsg");
        Logger.printConsoleLog(logMsg);
    }

    @JvmStatic
    @TritonKeep
    public static final void printNativeLog(int level, @Nullable byte[] tagBytes, @Nullable byte[] infoBytes) {
        if (tagBytes == null) {
            Intrinsics.throwNpe();
        }
        Charset charset = Charsets.UTF_8;
        String str = new String(tagBytes, charset);
        if (infoBytes == null) {
            Intrinsics.throwNpe();
        }
        String str2 = new String(infoBytes, charset);
        if (level >= 100) {
            int i3 = (level - 100) + 2;
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 5) {
                        if (i3 != 6) {
                            Logger.cv$default(str, str2, null, 4, null);
                            return;
                        } else {
                            Logger.ce$default(str, str2, null, 4, null);
                            return;
                        }
                    }
                    Logger.cw$default(str, str2, null, 4, null);
                    return;
                }
                Logger.ci$default(str, str2, null, 4, null);
                return;
            }
            Logger.cd$default(str, str2, null, 4, null);
            return;
        }
        int i16 = level + 2;
        if (i16 != 3) {
            if (i16 != 4) {
                if (i16 != 5) {
                    if (i16 != 6) {
                        Logger.v$default(str, str2, null, 4, null);
                        return;
                    } else {
                        Logger.e$default(str, str2, null, 4, null);
                        return;
                    }
                }
                Logger.w$default(str, str2, null, 4, null);
                return;
            }
            Logger.i$default(str, str2, null, 4, null);
            return;
        }
        Logger.d$default(str, str2, null, 4, null);
    }
}
