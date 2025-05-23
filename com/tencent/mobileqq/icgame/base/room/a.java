package com.tencent.mobileqq.icgame.base.room;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000\u00a8\u0006\u0003"}, d2 = {"", "", "a", "ic-game-room-base_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    @NotNull
    public static final String a(@Nullable Object obj) {
        StringBuilder sb5 = new StringBuilder();
        Thread currentThread = Thread.currentThread();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        sb5.append("ThreadName:");
        sb5.append(currentThread.getId());
        sb5.append("_");
        sb5.append(currentThread.getName());
        sb5.append("\n");
        StackTraceElement[] stackTraceElementArr = allStackTraces.get(currentThread);
        if (stackTraceElementArr == null) {
            return "";
        }
        int i3 = 4;
        while (true) {
            StackTraceElement stackTraceElement = stackTraceElementArr[i3];
            Intrinsics.checkNotNullExpressionValue(stackTraceElement, "arrayOfStackTraceElements[i]");
            sb5.append("line");
            sb5.append(i3 - 4);
            sb5.append(MsgSummary.STR_COLON);
            sb5.append(stackTraceElement.getClassName() + '.' + stackTraceElement.getMethodName());
            sb5.append("\n");
            if (i3 != 10) {
                i3++;
            } else {
                String sb6 = sb5.toString();
                Intrinsics.checkNotNullExpressionValue(sb6, "sb.toString()");
                return sb6;
            }
        }
    }
}
