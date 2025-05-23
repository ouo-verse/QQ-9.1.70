package com.tencent.mobileqq.zplan.show;

import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QRouteFactory(singleton = false)
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 \u000f2\u00020\u0001:\u0002\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zplan/show/IZPlanMsgService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/data/AIOParam;", "aioParam", "", "init", "Lcom/tencent/mobileqq/zplan/show/a;", "listener", "addListener", "clearListener", "", "friendUin", "Lcom/tencent/mobileqq/zplan/show/IZPlanMsgService$b;", "msg", "sendActionMsg", "Companion", "a", "b", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes21.dex */
public interface IZPlanMsgService extends QRouteApi {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f335616a;

    @NotNull
    public static final String ZPLAN_MSG_PREFIX = "[\u8d85\u7ea7QQ\u79c0]";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/zplan/show/IZPlanMsgService$a;", "", "<init>", "()V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.show.IZPlanMsgService$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f335616a = new Companion();

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u000e\u0010\fR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0012\u001a\u0004\b\t\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/show/IZPlanMsgService$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "d", "()I", "masterActionId", "b", "c", "guestActionId", "actionType", "Ljava/lang/String;", "()Ljava/lang/String;", "setActionName", "(Ljava/lang/String;)V", "actionName", "<init>", "(IIILjava/lang/String;)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.show.IZPlanMsgService$b, reason: from toString */
    /* loaded from: classes21.dex */
    public static final /* data */ class ZPlanActionMsg {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int masterActionId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final int guestActionId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int actionType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private String actionName;

        public ZPlanActionMsg(int i3, int i16, int i17, @NotNull String actionName) {
            Intrinsics.checkNotNullParameter(actionName, "actionName");
            this.masterActionId = i3;
            this.guestActionId = i16;
            this.actionType = i17;
            this.actionName = actionName;
            this.actionName = IZPlanMsgService.ZPLAN_MSG_PREFIX + this.actionName;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getActionName() {
            return this.actionName;
        }

        /* renamed from: b, reason: from getter */
        public final int getActionType() {
            return this.actionType;
        }

        /* renamed from: c, reason: from getter */
        public final int getGuestActionId() {
            return this.guestActionId;
        }

        /* renamed from: d, reason: from getter */
        public final int getMasterActionId() {
            return this.masterActionId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ZPlanActionMsg)) {
                return false;
            }
            ZPlanActionMsg zPlanActionMsg = (ZPlanActionMsg) other;
            if (this.masterActionId == zPlanActionMsg.masterActionId && this.guestActionId == zPlanActionMsg.guestActionId && this.actionType == zPlanActionMsg.actionType && Intrinsics.areEqual(this.actionName, zPlanActionMsg.actionName)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.masterActionId * 31) + this.guestActionId) * 31) + this.actionType) * 31) + this.actionName.hashCode();
        }

        @NotNull
        public String toString() {
            return "ZPlanActionMsg(masterActionId=" + this.masterActionId + ", guestActionId=" + this.guestActionId + ", actionType=" + this.actionType + ", actionName=" + this.actionName + ')';
        }
    }

    void addListener(@NotNull a listener);

    void clearListener(@NotNull a listener);

    void init(@NotNull AIOParam aioParam);

    void sendActionMsg(@NotNull String friendUin, @NotNull ZPlanActionMsg msg2);
}
