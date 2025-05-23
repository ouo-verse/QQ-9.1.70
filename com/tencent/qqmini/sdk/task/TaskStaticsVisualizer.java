package com.tencent.qqmini.sdk.task;

import com.tencent.mobileqq.vip.IGameCardManager;
import com.tencent.qqmini.sdk.task.TaskExecutionStatics;
import com.tencent.raft.codegenmeta.utils.Constants;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0014\u0010\t\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqmini/sdk/task/TaskStaticsVisualizer;", "", IGameCardManager.VISITOR, "Lcom/tencent/qqmini/sdk/task/TaskStaticsVisualizer$TaskVisitor;", "(Lcom/tencent/qqmini/sdk/task/TaskStaticsVisualizer$TaskVisitor;)V", "visitRootTask", "", "root", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "visitTasks", Constants.Raft.TASKS, "", "Companion", "TaskVisitor", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes23.dex */
public final class TaskStaticsVisualizer {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final TaskVisitor visitor;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqmini/sdk/task/TaskStaticsVisualizer$Companion;", "", "()V", "visualizeToString", "", "task", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", Constants.Raft.TASKS, "", "ToStringVisitor", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @NotNull
        public final String visualizeToString(@NotNull List<TaskExecutionStatics> tasks) {
            Intrinsics.checkParameterIsNotNull(tasks, "tasks");
            if (tasks.size() == 1) {
                return visualizeToString(tasks.get(0));
            }
            ToStringVisitor toStringVisitor = new ToStringVisitor();
            new TaskStaticsVisualizer(toStringVisitor).visitTasks(tasks);
            return toStringVisitor.build();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final String visualizeToString(@NotNull TaskExecutionStatics task) {
            Intrinsics.checkParameterIsNotNull(task, "task");
            ToStringVisitor toStringVisitor = new ToStringVisitor();
            new TaskStaticsVisualizer(toStringVisitor).visitRootTask(task);
            return toStringVisitor.build();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J&\u0010\u0015\u001a\u00020\u000f2\u001b\u0010\u0016\u001a\u0017\u0012\b\u0012\u00060\u0004j\u0002`\u0005\u0012\u0004\u0012\u00020\u000f0\u0017\u00a2\u0006\u0002\b\u0018H\u0082\bJ\b\u0010\u0019\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u000fH\u0016J\n\u0010\u001b\u001a\u00020\u0014*\u00020\u001cR\u0015\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqmini/sdk/task/TaskStaticsVisualizer$Companion$ToStringVisitor;", "Lcom/tencent/qqmini/sdk/task/TaskStaticsVisualizer$TaskVisitor;", "()V", "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "getBuilder", "()Ljava/lang/StringBuilder;", "indent", "", "getIndent", "()I", "setIndent", "(I)V", "beginDependencies", "", "beginTask", "statics", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "build", "", "buildLine", "line", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "endDependencies", "endTask", "ms", "", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 1, 16})
        /* loaded from: classes23.dex */
        public static final class ToStringVisitor implements TaskVisitor {

            @NotNull
            private final StringBuilder builder = new StringBuilder();
            private int indent;

            /* compiled from: P */
            @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
            /* loaded from: classes23.dex */
            public final /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[TaskExecutionStatics.Status.values().length];
                    $EnumSwitchMapping$0 = iArr;
                    iArr[TaskExecutionStatics.Status.SUCCESS.ordinal()] = 1;
                    iArr[TaskExecutionStatics.Status.FAIL.ordinal()] = 2;
                    iArr[TaskExecutionStatics.Status.WAIT.ordinal()] = 3;
                    iArr[TaskExecutionStatics.Status.RUNNING.ordinal()] = 4;
                    iArr[TaskExecutionStatics.Status.CACHED.ordinal()] = 5;
                }
            }

            private final void buildLine(Function1<? super StringBuilder, Unit> line) {
                int indent = getIndent();
                for (int i3 = 0; i3 < indent; i3++) {
                    getBuilder().append("|   ");
                }
                getBuilder().append("|-> ");
                line.invoke(getBuilder());
                getBuilder().append('\n');
            }

            @Override // com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor
            public void beginDependencies() {
                this.indent++;
            }

            @Override // com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor
            public void beginTask(@NotNull TaskExecutionStatics statics) {
                String str;
                String str2;
                Intrinsics.checkParameterIsNotNull(statics, "statics");
                int indent = getIndent();
                boolean z16 = false;
                for (int i3 = 0; i3 < indent; i3++) {
                    getBuilder().append("|   ");
                }
                getBuilder().append("|-> ");
                StringBuilder builder = getBuilder();
                int i16 = WhenMappings.$EnumSwitchMapping$0[statics.getStatus().ordinal()];
                if (i16 != 1) {
                    if (i16 != 2) {
                        if (i16 != 3) {
                            if (i16 != 4) {
                                if (i16 == 5) {
                                    str = "\u1f4be";
                                } else {
                                    throw new NoWhenBranchMatchedException();
                                }
                            } else {
                                str = "\u1f680";
                            }
                        } else {
                            str = "\u26d4\ufe0f";
                        }
                    } else {
                        str = "\u274c";
                    }
                } else {
                    str = "\u2705";
                }
                if (statics.getMessage().length() > 0) {
                    z16 = true;
                }
                if (z16) {
                    str2 = '\"' + statics.getMessage() + '\"';
                } else {
                    str2 = "";
                }
                builder.append(str + " [" + statics.getName() + "] " + ms(statics.getRunDurationMs()) + '/' + ms(statics.getTotalRunDurationMs()) + TokenParser.SP + str2);
                getBuilder().append('\n');
            }

            @NotNull
            public final String build() {
                String sb5 = this.builder.toString();
                Intrinsics.checkExpressionValueIsNotNull(sb5, "builder.toString()");
                return sb5;
            }

            @Override // com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor
            public void endDependencies() {
                this.indent--;
            }

            @NotNull
            public final StringBuilder getBuilder() {
                return this.builder;
            }

            public final int getIndent() {
                return this.indent;
            }

            @NotNull
            public final String ms(long j3) {
                if (j3 < 1000) {
                    return j3 + "ms";
                }
                String format = String.format("%.2fs", Arrays.copyOf(new Object[]{Double.valueOf(j3 / 1000.0d)}, 1));
                Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(this, *args)");
                return format;
            }

            public final void setIndent(int i3) {
                this.indent = i3;
            }

            @Override // com.tencent.qqmini.sdk.task.TaskStaticsVisualizer.TaskVisitor
            public void endTask() {
            }
        }
    }

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqmini/sdk/task/TaskStaticsVisualizer$TaskVisitor;", "", "beginDependencies", "", "beginTask", "statics", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "endDependencies", "endTask", "lib_minisdk_internalRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes23.dex */
    public interface TaskVisitor {
        void beginDependencies();

        void beginTask(@NotNull TaskExecutionStatics statics);

        void endDependencies();

        void endTask();
    }

    public TaskStaticsVisualizer(@NotNull TaskVisitor visitor) {
        Intrinsics.checkParameterIsNotNull(visitor, "visitor");
        this.visitor = visitor;
    }

    @JvmStatic
    @NotNull
    public static final String visualizeToString(@NotNull TaskExecutionStatics taskExecutionStatics) {
        return INSTANCE.visualizeToString(taskExecutionStatics);
    }

    public final void visitRootTask(@NotNull TaskExecutionStatics root) {
        Intrinsics.checkParameterIsNotNull(root, "root");
        this.visitor.beginTask(root);
        if (!root.getSubSteps().isEmpty()) {
            this.visitor.beginDependencies();
            Iterator<T> it = root.getSubSteps().iterator();
            while (it.hasNext()) {
                visitRootTask((TaskExecutionStatics) it.next());
            }
            this.visitor.endDependencies();
        }
        this.visitor.endTask();
    }

    public final void visitTasks(@NotNull List<TaskExecutionStatics> tasks) {
        Intrinsics.checkParameterIsNotNull(tasks, "tasks");
        Iterator<T> it = tasks.iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += ((TaskExecutionStatics) it.next()).getTotalRunDurationMs();
        }
        visitRootTask(new TaskExecutionStatics("root", 0L, j3, TaskExecutionStatics.Status.SUCCESS, "", tasks, 0L, 64, null));
    }

    @JvmStatic
    @NotNull
    public static final String visualizeToString(@NotNull List<TaskExecutionStatics> list) {
        return INSTANCE.visualizeToString(list);
    }
}
