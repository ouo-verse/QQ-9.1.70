package com.tencent.mobileqq.vas.social.config;

import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskCommonRewardData;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskItemData;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskRewardInfo;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskRewardStatus;
import com.tencent.sqshow.zootopia.data.ZootopiaTaskSystemMainData;
import com.tencent.state.square.api.ISquareTaskService;
import com.tencent.state.square.api.JumpType;
import com.tencent.state.square.api.ResultCallback;
import com.tencent.state.square.api.TaskItem;
import com.tencent.state.square.api.TaskRewardItem;
import com.tencent.state.square.api.TaskState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xv4.ab;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\u000b\u001a\u00020\n2\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u0016J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0006H\u0016J$\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\f2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\u0011H\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/y;", "Lcom/tencent/state/square/api/ISquareTaskService;", "", "questStatus", "Lcom/tencent/state/square/api/TaskState;", "b", "Lcom/tencent/state/square/api/ResultCallback;", "", "Lcom/tencent/state/square/api/TaskItem;", "callback", "", "loadLeYuanTask", "", "questId", "Lcom/tencent/state/square/api/TaskRewardItem;", "fetchQuestReward", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "Lkotlin/Function1;", "", "getTaskRedPointFlag", "Ldc4/a;", "a", "Ldc4/a;", "repository", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class y implements ISquareTaskService {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final dc4.a repository = new dc4.b(ZootopiaSource.INSTANCE.g());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/social/config/y$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/t;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<ZootopiaTaskCommonRewardData> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ResultCallback<TaskRewardItem> f310748d;

        b(ResultCallback<TaskRewardItem> resultCallback) {
            this.f310748d = resultCallback;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaTaskCommonRewardData result) {
            b bVar;
            String str;
            String str2;
            String str3;
            String str4;
            Intrinsics.checkNotNullParameter(result, "result");
            List<ZootopiaTaskRewardInfo> b16 = result.b();
            ZootopiaTaskRewardInfo zootopiaTaskRewardInfo = null;
            if (b16 != null && (!b16.isEmpty())) {
                zootopiaTaskRewardInfo = b16.get(0);
            }
            List<ab> a16 = result.a();
            String str5 = "";
            if (a16 == null) {
                bVar = this;
                str = "";
                str2 = str;
                str3 = str2;
                str4 = str3;
            } else {
                String str6 = "";
                String str7 = str6;
                String str8 = str7;
                for (ab abVar : a16) {
                    int i3 = abVar.f448770c;
                    if (i3 == 100001) {
                        str6 = abVar.f448769b;
                        Intrinsics.checkNotNullExpressionValue(str6, "it.url");
                    } else if (i3 != 201000000) {
                        int i16 = abVar.f448768a;
                        if (i16 == 1) {
                            str7 = abVar.f448769b;
                            Intrinsics.checkNotNullExpressionValue(str7, "it.url");
                        } else if (i16 == 2) {
                            str8 = abVar.f448769b;
                            Intrinsics.checkNotNullExpressionValue(str8, "it.url");
                        }
                    } else {
                        str5 = abVar.f448769b;
                        Intrinsics.checkNotNullExpressionValue(str5, "it.url");
                    }
                }
                bVar = this;
                str = str5;
                str2 = str6;
                str3 = str7;
                str4 = str8;
            }
            ResultCallback<TaskRewardItem> resultCallback = bVar.f310748d;
            ZootopiaTaskRewardStatus rewardStatus = result.getRewardStatus();
            long billId = rewardStatus != null ? rewardStatus.getBillId() : 0L;
            ZootopiaTaskRewardStatus rewardStatus2 = result.getRewardStatus();
            int questCurrentCnt = rewardStatus2 != null ? rewardStatus2.getQuestCurrentCnt() : 0;
            ZootopiaTaskRewardStatus rewardStatus3 = result.getRewardStatus();
            ZootopiaTaskRewardInfo zootopiaTaskRewardInfo2 = zootopiaTaskRewardInfo;
            resultCallback.onResultSuccess(new TaskRewardItem(billId, questCurrentCnt, rewardStatus3 != null ? rewardStatus3.getTargetAmount() : 0, zootopiaTaskRewardInfo2 != null ? zootopiaTaskRewardInfo2.getRewardItemId() : 0L, zootopiaTaskRewardInfo2 != null ? zootopiaTaskRewardInfo2.getRewardItemCnt() : 0, str, str2, str3, str4));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f310748d.onResultFailure(error, message);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/social/config/y$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lxv4/r;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<xv4.r> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f310749d;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super Boolean, Unit> function1) {
            this.f310749d = function1;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(xv4.r result) {
            Intrinsics.checkNotNullParameter(result, "result");
            Function1<Boolean, Unit> function1 = this.f310749d;
            xv4.v vVar = result.f448817a;
            function1.invoke(Boolean.valueOf(vVar != null && vVar.f448823b > 0));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f310749d.invoke(Boolean.FALSE);
        }
    }

    @Override // com.tencent.state.square.api.ISquareTaskService
    public void fetchQuestReward(long questId, ResultCallback<TaskRewardItem> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.repository.c(21L, questId, new b(callback));
    }

    @Override // com.tencent.state.square.api.ISquareTaskService
    public void getTaskRedPointFlag(long taskId, Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.repository.i(taskId, new c(callback));
    }

    @Override // com.tencent.state.square.api.ISquareTaskService
    public void loadLeYuanTask(ResultCallback<List<TaskItem>> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.repository.d(21L, new d(callback, this));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/vas/social/config/y$d", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lcom/tencent/sqshow/zootopia/data/y;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements com.tencent.mobileqq.zootopia.api.e<ZootopiaTaskSystemMainData> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ResultCallback<List<TaskItem>> f310750d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ y f310751e;

        d(ResultCallback<List<TaskItem>> resultCallback, y yVar) {
            this.f310750d = resultCallback;
            this.f310751e = yVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            this.f310750d.onResultFailure(error, message);
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ZootopiaTaskSystemMainData result) {
            JumpType jumpType;
            String itemIcon;
            Intrinsics.checkNotNullParameter(result, "result");
            ArrayList arrayList = new ArrayList();
            List<ZootopiaTaskItemData> c16 = result.c();
            if (c16 != null) {
                y yVar = this.f310751e;
                for (ZootopiaTaskItemData zootopiaTaskItemData : c16) {
                    ZootopiaTaskRewardInfo zootopiaTaskRewardInfo = zootopiaTaskItemData.k().isEmpty() ^ true ? zootopiaTaskItemData.k().get(0) : null;
                    long questId = zootopiaTaskItemData.getQuestId();
                    String questIcon = zootopiaTaskItemData.getQuestIcon();
                    String str = questIcon == null ? "" : questIcon;
                    String questTitle = zootopiaTaskItemData.getQuestTitle();
                    String str2 = questTitle == null ? "" : questTitle;
                    String questDesc = zootopiaTaskItemData.getQuestDesc();
                    String str3 = questDesc == null ? "" : questDesc;
                    String questJumpTitle = zootopiaTaskItemData.getQuestJumpTitle();
                    String str4 = questJumpTitle == null ? "" : questJumpTitle;
                    String questJumpSchema = zootopiaTaskItemData.getQuestJumpSchema();
                    String str5 = questJumpSchema == null ? "" : questJumpSchema;
                    int questCurrentCnt = zootopiaTaskItemData.getQuestCurrentCnt();
                    int questAmount = zootopiaTaskItemData.getQuestAmount();
                    long rewardItemId = zootopiaTaskRewardInfo != null ? zootopiaTaskRewardInfo.getRewardItemId() : 0L;
                    String str6 = (zootopiaTaskRewardInfo == null || (itemIcon = zootopiaTaskRewardInfo.getItemIcon()) == null) ? "" : itemIcon;
                    int rewardItemCnt = zootopiaTaskRewardInfo != null ? zootopiaTaskRewardInfo.getRewardItemCnt() : 0;
                    if (zootopiaTaskItemData.getQuestJumpType() == 0) {
                        jumpType = JumpType.DISMISS;
                    } else {
                        jumpType = JumpType.SCHEME;
                    }
                    arrayList.add(new TaskItem(questId, str, str2, str3, str4, str5, questCurrentCnt, questAmount, rewardItemId, str6, rewardItemCnt, jumpType, yVar.b(zootopiaTaskItemData.getQuestStatus())));
                }
            }
            this.f310750d.onResultSuccess(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TaskState b(int questStatus) {
        boolean z16 = false;
        if (questStatus >= 0 && questStatus < 3) {
            z16 = true;
        }
        if (z16) {
            return TaskState.TO_COMPLETE;
        }
        if (questStatus == 3) {
            return TaskState.TO_RECEIVE;
        }
        return TaskState.RECEIVED;
    }
}
