package com.tencent.rmonitor.common.logger;

import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.raft.codegenmeta.utils.RLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/rmonitor/common/logger/LogState;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "OFF", RLog.ERROR, "WARN", "INFO", "DEBUG", "VERBOS", "bugly-common_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public enum LogState {
    OFF(0),
    ERROR(1),
    WARN(2),
    INFO(3),
    DEBUG(4),
    VERBOS(5);

    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final LogState[] values = values();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/rmonitor/common/logger/LogState$a;", "", "", "value", "Lcom/tencent/rmonitor/common/logger/LogState;", "a", "", "values", "[Lcom/tencent/rmonitor/common/logger/LogState;", "<init>", "()V", "bugly-common_release"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rmonitor.common.logger.LogState$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        @Nullable
        public final LogState a(int value) {
            boolean z16;
            for (LogState logState : LogState.values) {
                if (logState.getValue() == value) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    return logState;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    LogState(int i3) {
        this.value = i3;
    }

    public final int getValue() {
        return this.value;
    }
}
