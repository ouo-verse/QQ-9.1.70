package okhttp3.internal.concurrent;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0001H\u0002\u001a5\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000eH\u0080\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u001a*\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eH\u0080\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u0012"}, d2 = {"formatDuration", "", "ns", "", "log", "", "task", "Lokhttp3/internal/concurrent/Task;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "Lokhttp3/internal/concurrent/TaskQueue;", "message", "logElapsed", "T", "block", "Lkotlin/Function0;", "(Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "taskLog", "messageBlock", "okhttp"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public final class TaskLoggerKt {
    public static final /* synthetic */ void access$log(Task task, TaskQueue taskQueue, String str) {
        log(task, taskQueue, str);
    }

    @NotNull
    public static final String formatDuration(long j3) {
        String str;
        if (j3 <= -999500000) {
            str = ((j3 - 500000000) / 1000000000) + " s ";
        } else if (j3 <= -999500) {
            str = ((j3 - 500000) / 1000000) + " ms";
        } else if (j3 <= 0) {
            str = ((j3 - 500) / 1000) + " \u00b5s";
        } else if (j3 < 999500) {
            str = ((j3 + 500) / 1000) + " \u00b5s";
        } else if (j3 < 999500000) {
            str = ((j3 + 500000) / 1000000) + " ms";
        } else {
            str = ((j3 + 500000000) / 1000000000) + " s ";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void log(Task task, TaskQueue taskQueue, String str) {
        Logger logger = TaskRunner.INSTANCE.getLogger();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(taskQueue.getName());
        sb5.append(TokenParser.SP);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        sb5.append(format);
        sb5.append(MsgSummary.STR_COLON);
        sb5.append(task.getName());
        logger.fine(sb5.toString());
    }

    public static final <T> T logElapsed(@NotNull Task task, @NotNull TaskQueue queue, @NotNull Function0<? extends T> block) {
        long j3;
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(queue, "queue");
        Intrinsics.checkNotNullParameter(block, "block");
        boolean isLoggable = TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE);
        if (isLoggable) {
            j3 = queue.getTaskRunner().getBackend().nanoTime();
            log(task, queue, "starting");
        } else {
            j3 = -1;
        }
        try {
            T invoke = block.invoke();
            InlineMarker.finallyStart(1);
            if (isLoggable) {
                log(task, queue, "finished run in " + formatDuration(queue.getTaskRunner().getBackend().nanoTime() - j3));
            }
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th5) {
            InlineMarker.finallyStart(1);
            if (isLoggable) {
                log(task, queue, "failed a run in " + formatDuration(queue.getTaskRunner().getBackend().nanoTime() - j3));
            }
            InlineMarker.finallyEnd(1);
            throw th5;
        }
    }

    public static final void taskLog(@NotNull Task task, @NotNull TaskQueue queue, @NotNull Function0<String> messageBlock) {
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(queue, "queue");
        Intrinsics.checkNotNullParameter(messageBlock, "messageBlock");
        if (TaskRunner.INSTANCE.getLogger().isLoggable(Level.FINE)) {
            log(task, queue, messageBlock.invoke());
        }
    }
}
