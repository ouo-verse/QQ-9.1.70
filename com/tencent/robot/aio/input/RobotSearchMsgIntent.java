package com.tencent.robot.aio.input;

import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.h;
import com.tencent.qqnt.kernel.nativeinterface.QueryHalfViewDataRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/aio/input/RobotSearchMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "GetBotSearchResponseMsgIntent", "OnRobotSearchDialogChanged", "OnRobotSearchDismissAnimStart", "RefreshBotSearchMsgIntent", "RequestBotSearchMsgIntent", "ShowRobotSearchDialog", "Lcom/tencent/robot/aio/input/RobotSearchMsgIntent$GetBotSearchResponseMsgIntent;", "Lcom/tencent/robot/aio/input/RobotSearchMsgIntent$OnRobotSearchDialogChanged;", "Lcom/tencent/robot/aio/input/RobotSearchMsgIntent$OnRobotSearchDismissAnimStart;", "Lcom/tencent/robot/aio/input/RobotSearchMsgIntent$RefreshBotSearchMsgIntent;", "Lcom/tencent/robot/aio/input/RobotSearchMsgIntent$RequestBotSearchMsgIntent;", "Lcom/tencent/robot/aio/input/RobotSearchMsgIntent$ShowRobotSearchDialog;", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotSearchMsgIntent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/robot/aio/input/RobotSearchMsgIntent$GetBotSearchResponseMsgIntent;", "Lcom/tencent/robot/aio/input/RobotSearchMsgIntent;", "", "isSticky", "", "toString", "", "hashCode", "", "other", "equals", "d", "Z", "c", "()Z", "success", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;", "response", "<init>", "(ZLjava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class GetBotSearchResponseMsgIntent extends RobotSearchMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean success;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String errMsg;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final QueryHalfViewDataRsp response;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetBotSearchResponseMsgIntent(boolean z16, @NotNull String errMsg, @Nullable QueryHalfViewDataRsp queryHalfViewDataRsp) {
            super(null);
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            this.success = z16;
            this.errMsg = errMsg;
            this.response = queryHalfViewDataRsp;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getErrMsg() {
            return this.errMsg;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final QueryHalfViewDataRsp getResponse() {
            return this.response;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getSuccess() {
            return this.success;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GetBotSearchResponseMsgIntent)) {
                return false;
            }
            GetBotSearchResponseMsgIntent getBotSearchResponseMsgIntent = (GetBotSearchResponseMsgIntent) other;
            if (this.success == getBotSearchResponseMsgIntent.success && Intrinsics.areEqual(this.errMsg, getBotSearchResponseMsgIntent.errMsg) && Intrinsics.areEqual(this.response, getBotSearchResponseMsgIntent.response)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.success;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int hashCode2 = ((r06 * 31) + this.errMsg.hashCode()) * 31;
            QueryHalfViewDataRsp queryHalfViewDataRsp = this.response;
            if (queryHalfViewDataRsp == null) {
                hashCode = 0;
            } else {
                hashCode = queryHalfViewDataRsp.hashCode();
            }
            return hashCode2 + hashCode;
        }

        @Override // com.tencent.robot.aio.input.RobotSearchMsgIntent, com.tencent.mvi.base.route.MsgIntent
        public boolean isSticky() {
            return true;
        }

        @NotNull
        public String toString() {
            return "GetBotSearchResponseMsgIntent(success=" + this.success + ", errMsg=" + this.errMsg + ", response=" + this.response + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/aio/input/RobotSearchMsgIntent$OnRobotSearchDialogChanged;", "Lcom/tencent/robot/aio/input/RobotSearchMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "a", "()Z", ViewStickEventHelper.IS_SHOW, "<init>", "(Z)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnRobotSearchDialogChanged extends RobotSearchMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isShow;

        public OnRobotSearchDialogChanged(boolean z16) {
            super(null);
            this.isShow = z16;
        }

        /* renamed from: a, reason: from getter */
        public final boolean getIsShow() {
            return this.isShow;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnRobotSearchDialogChanged) && this.isShow == ((OnRobotSearchDialogChanged) other).isShow) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.isShow;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "OnRobotSearchDialogChanged(isShow=" + this.isShow + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/input/RobotSearchMsgIntent$OnRobotSearchDismissAnimStart;", "Lcom/tencent/robot/aio/input/RobotSearchMsgIntent;", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class OnRobotSearchDismissAnimStart extends RobotSearchMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final OnRobotSearchDismissAnimStart f367155d = new OnRobotSearchDismissAnimStart();

        OnRobotSearchDismissAnimStart() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/input/RobotSearchMsgIntent$RefreshBotSearchMsgIntent;", "Lcom/tencent/robot/aio/input/RobotSearchMsgIntent;", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class RefreshBotSearchMsgIntent extends RobotSearchMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final RefreshBotSearchMsgIntent f367156d = new RefreshBotSearchMsgIntent();

        RefreshBotSearchMsgIntent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/input/RobotSearchMsgIntent$RequestBotSearchMsgIntent;", "Lcom/tencent/robot/aio/input/RobotSearchMsgIntent;", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class RequestBotSearchMsgIntent extends RobotSearchMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final RequestBotSearchMsgIntent f367157d = new RequestBotSearchMsgIntent();

        RequestBotSearchMsgIntent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/input/RobotSearchMsgIntent$ShowRobotSearchDialog;", "Lcom/tencent/robot/aio/input/RobotSearchMsgIntent;", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class ShowRobotSearchDialog extends RobotSearchMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ShowRobotSearchDialog f367158d = new ShowRobotSearchDialog();

        ShowRobotSearchDialog() {
            super(null);
        }
    }

    public /* synthetic */ RobotSearchMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    RobotSearchMsgIntent() {
    }
}
