package com.tencent.timi.game.web.business.api.task;

import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.utils.l;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import lo4.a;
import mm4.b;
import org.jetbrains.annotations.NotNull;
import tl.h;
import trpc.yes.common.LiveActivityServerOuterClass$UserRedpacket;
import trpc.yes.common.MessageOuterClass$H5Msg;
import trpc.yes.common.MessageOuterClass$LiveRoomLotteryResultMsg;
import trpc.yes.common.MessageOuterClass$PowerRedpacketLotteryResultMsg;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\nH\u0002J\u0016\u0010\u0011\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0016J\u000e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/timi/game/web/business/api/task/LiveLotteryTaskDataManager;", "", "", "key", "additionInfo", "", "j", "action", MiniAppGetGameTaskTicketServlet.KEY_TASKID, "a", "Ltrpc/yes/common/MessageOuterClass$H5Msg;", "msg", "d", "h5Msg", "f", "", "participateState", "k", "", "i", "c", "b", "Ltrpc/yes/common/MessageOuterClass$LiveRoomLotteryResultMsg;", "g", "Ltrpc/yes/common/MessageOuterClass$PowerRedpacketLotteryResultMsg;", h.F, "Ltrpc/yes/common/LiveActivityServerOuterClass$UserRedpacket;", "data", "e", "<init>", "()V", "TaskActivityState", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LiveLotteryTaskDataManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final LiveLotteryTaskDataManager f380318a = new LiveLotteryTaskDataManager();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/timi/game/web/business/api/task/LiveLotteryTaskDataManager$TaskActivityState;", "", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    /* loaded from: classes26.dex */
    public @interface TaskActivityState {
    }

    LiveLotteryTaskDataManager() {
    }

    private final String a(String action, String taskId) {
        return "timi_game_live_task_" + action + "_" + taskId;
    }

    private final void d(String taskId, MessageOuterClass$H5Msg msg2) {
        boolean z16;
        f(msg2);
        int c16 = c(taskId);
        l.h("LiveTaskDataManager_", 1, "handleCommonLotteryMsg taskState:" + c16);
        if (c16 != 0 && c16 != 2) {
            int i3 = msg2.type.get();
            String jumpUrl = msg2.url.get();
            l.h("LiveTaskDataManager_", 1, "handleCommonLotteryMsg jumpUrl:" + jumpUrl + ", type:" + i3);
            if (jumpUrl != null && jumpUrl.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return;
            }
            BaseApplication context = BaseApplication.context;
            if (i3 != 0) {
                if (i3 == 1) {
                    Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
                    intent.addFlags(268435456);
                    intent.putExtra("url", jumpUrl);
                    context.startActivity(intent);
                    return;
                }
                return;
            }
            a aVar = (a) b.b(a.class);
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Intrinsics.checkNotNullExpressionValue(jumpUrl, "jumpUrl");
            aVar.Y(context, jumpUrl);
            return;
        }
        l.k("LiveTaskDataManager_", 1, "handleCommonLotteryMsg taskId:" + taskId + ", isParticipated=false!");
    }

    private final void f(MessageOuterClass$H5Msg h5Msg) {
        l.h("LiveTaskDataManager_", 1, "on receive h5Msg " + h5Msg.key.get() + ", " + h5Msg.value.get() + ", " + h5Msg.url.get() + ", " + h5Msg.type.get());
        String str = h5Msg.key.get();
        Intrinsics.checkNotNullExpressionValue(str, "h5Msg.key.get()");
        String str2 = h5Msg.value.get();
        Intrinsics.checkNotNullExpressionValue(str2, "h5Msg.value.get()");
        j(str, str2);
    }

    private final void j(String key, String additionInfo) {
        boolean z16;
        if (key.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        rm4.a.g(a("action_addition_info", key), additionInfo);
        l.h("LiveTaskDataManager_", 1, "recordTaskAdditionInfo " + key + " " + additionInfo);
    }

    @NotNull
    public final String b(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        String additionInfo = rm4.a.f(a("action_addition_info", key), "");
        l.h("LiveTaskDataManager_", 1, "getTaskAdditionInfo " + key + " " + additionInfo);
        Intrinsics.checkNotNullExpressionValue(additionInfo, "additionInfo");
        return additionInfo;
    }

    public final int c(@NotNull String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        return rm4.a.c(a("action_participate", taskId), 0);
    }

    public final void e(@NotNull LiveActivityServerOuterClass$UserRedpacket data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String activityId = data.activity_id.get();
        int i3 = data.status.get();
        Intrinsics.checkNotNullExpressionValue(activityId, "activityId");
        int c16 = c(activityId);
        l.h("LiveTaskDataManager_", 2, "handleParticipatedState activityId:" + activityId + ",localState:" + c16 + ", serverState:" + i3);
        if (c16 == 2) {
            return;
        }
        k(activityId, i3);
    }

    public final void g(@NotNull MessageOuterClass$LiveRoomLotteryResultMsg msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        l.h("LiveTaskDataManager_", 1, "handleLiveRoomLotteryResultMsg");
        String valueOf = String.valueOf(msg2.task_id.get());
        MessageOuterClass$H5Msg messageOuterClass$H5Msg = msg2.h5_msg.get();
        Intrinsics.checkNotNullExpressionValue(messageOuterClass$H5Msg, "msg.h5_msg.get()");
        d(valueOf, messageOuterClass$H5Msg);
    }

    public final void h(@NotNull MessageOuterClass$PowerRedpacketLotteryResultMsg msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        l.h("LiveTaskDataManager_", 1, "handlePowerRedPacketLotteryResultMsg");
        String str = msg2.activity_id.get();
        Intrinsics.checkNotNullExpressionValue(str, "msg.activity_id.get()");
        MessageOuterClass$H5Msg messageOuterClass$H5Msg = msg2.h5_msg.get();
        Intrinsics.checkNotNullExpressionValue(messageOuterClass$H5Msg, "msg.h5_msg.get()");
        d(str, messageOuterClass$H5Msg);
    }

    public final boolean i(@NotNull String taskId) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        int c16 = rm4.a.c(a("action_participate", taskId), 0);
        l.h("LiveTaskDataManager_", 1, "isParticipateStated " + taskId + " " + c16);
        if (c16 != 1) {
            return false;
        }
        return true;
    }

    public final void k(@NotNull String taskId, int participateState) {
        Intrinsics.checkNotNullParameter(taskId, "taskId");
        rm4.a.g(a("action_participate", taskId), Integer.valueOf(participateState));
        l.h("LiveTaskDataManager_", 1, "recordTaskParticipateState " + taskId + " " + participateState);
    }
}
