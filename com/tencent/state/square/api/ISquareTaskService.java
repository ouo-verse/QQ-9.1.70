package com.tencent.state.square.api;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016J$\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\u000bH\u0016J\u001c\u0010\r\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u0007H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/api/ISquareTaskService;", "", "fetchQuestReward", "", "questId", "", "callback", "Lcom/tencent/state/square/api/ResultCallback;", "Lcom/tencent/state/square/api/TaskRewardItem;", "getTaskRedPointFlag", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lkotlin/Function1;", "", "loadLeYuanTask", "", "Lcom/tencent/state/square/api/TaskItem;", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public interface ISquareTaskService {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes26.dex */
    public static final class DefaultImpls {
        public static void fetchQuestReward(@NotNull ISquareTaskService iSquareTaskService, long j3, @NotNull ResultCallback<TaskRewardItem> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
        }

        public static void getTaskRedPointFlag(@NotNull ISquareTaskService iSquareTaskService, long j3, @NotNull Function1<? super Boolean, Unit> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
        }

        public static void loadLeYuanTask(@NotNull ISquareTaskService iSquareTaskService, @NotNull ResultCallback<List<TaskItem>> callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
        }
    }

    void fetchQuestReward(long questId, @NotNull ResultCallback<TaskRewardItem> callback);

    void getTaskRedPointFlag(long taskId, @NotNull Function1<? super Boolean, Unit> callback);

    void loadLeYuanTask(@NotNull ResultCallback<List<TaskItem>> callback);
}
