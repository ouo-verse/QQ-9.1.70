package com.tencent.robot.aio.input;

import a44.a;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernel.nativeinterface.QueryHalfViewDataRsp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0003\u0004\u0005\u0006\u0007\b\tB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0007\n\u000b\f\r\u000e\u000f\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/aio/input/RobotDrawMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "GetAnchorViewMsgIntent", "GetBotDrawResponseMsgIntent", "OnReviseSwitchChanged", "RequestBotDrawMsgIntent", "ShowRobotDrawDialog", "SubmitListMsgIntent", "UpdateRobotDrawData", "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$GetAnchorViewMsgIntent;", "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$GetBotDrawResponseMsgIntent;", "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$OnReviseSwitchChanged;", "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$RequestBotDrawMsgIntent;", "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$ShowRobotDrawDialog;", "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$SubmitListMsgIntent;", "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$UpdateRobotDrawData;", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotDrawMsgIntent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$GetAnchorViewMsgIntent;", "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent;", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class GetAnchorViewMsgIntent extends RobotDrawMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetAnchorViewMsgIntent f367131d = new GetAnchorViewMsgIntent();

        GetAnchorViewMsgIntent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$GetBotDrawResponseMsgIntent;", "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent;", "", "isSticky", "", "toString", "", "hashCode", "", "other", "equals", "d", "Z", "c", "()Z", "success", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;", "response", "<init>", "(ZLjava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class GetBotDrawResponseMsgIntent extends RobotDrawMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean success;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String errMsg;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final QueryHalfViewDataRsp response;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetBotDrawResponseMsgIntent(boolean z16, @NotNull String errMsg, @Nullable QueryHalfViewDataRsp queryHalfViewDataRsp) {
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
            if (!(other instanceof GetBotDrawResponseMsgIntent)) {
                return false;
            }
            GetBotDrawResponseMsgIntent getBotDrawResponseMsgIntent = (GetBotDrawResponseMsgIntent) other;
            if (this.success == getBotDrawResponseMsgIntent.success && Intrinsics.areEqual(this.errMsg, getBotDrawResponseMsgIntent.errMsg) && Intrinsics.areEqual(this.response, getBotDrawResponseMsgIntent.response)) {
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

        @Override // com.tencent.robot.aio.input.RobotDrawMsgIntent, com.tencent.mvi.base.route.MsgIntent
        public boolean isSticky() {
            return true;
        }

        @NotNull
        public String toString() {
            return "GetBotDrawResponseMsgIntent(success=" + this.success + ", errMsg=" + this.errMsg + ", response=" + this.response + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\b\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$OnReviseSwitchChanged;", "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "Z", "isChecked", "()Z", "<init>", "(Z)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class OnReviseSwitchChanged extends RobotDrawMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isChecked;

        public OnReviseSwitchChanged(boolean z16) {
            super(null);
            this.isChecked = z16;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof OnReviseSwitchChanged) && this.isChecked == ((OnReviseSwitchChanged) other).isChecked) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            boolean z16 = this.isChecked;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "OnReviseSwitchChanged(isChecked=" + this.isChecked + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$RequestBotDrawMsgIntent;", "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent;", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class RequestBotDrawMsgIntent extends RobotDrawMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final RequestBotDrawMsgIntent f367136d = new RequestBotDrawMsgIntent();

        RequestBotDrawMsgIntent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$ShowRobotDrawDialog;", "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent;", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class ShowRobotDrawDialog extends RobotDrawMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ShowRobotDrawDialog f367137d = new ShowRobotDrawDialog();

        ShowRobotDrawDialog() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$SubmitListMsgIntent;", "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "La44/a;", "d", "La44/a;", "a", "()La44/a;", "drawData", "<init>", "(La44/a;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SubmitListMsgIntent extends RobotDrawMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final a drawData;

        public SubmitListMsgIntent(@Nullable a aVar) {
            super(null);
            this.drawData = aVar;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final a getDrawData() {
            return this.drawData;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof SubmitListMsgIntent) && Intrinsics.areEqual(this.drawData, ((SubmitListMsgIntent) other).drawData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            a aVar = this.drawData;
            if (aVar == null) {
                return 0;
            }
            return aVar.hashCode();
        }

        @NotNull
        public String toString() {
            return "SubmitListMsgIntent(drawData=" + this.drawData + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0011\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0012R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001b\u0010\u0012\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$UpdateRobotDrawData;", "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "e", "()I", "setType", "(I)V", "type", "Ljava/lang/String;", "()Ljava/lang/String;", "styleName", "f", "c", "styleData", h.F, "b", "requireName", "i", "a", "requireData", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class UpdateRobotDrawData extends RobotDrawMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String styleName;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String styleData;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String requireName;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String requireData;

        public UpdateRobotDrawData(int i3, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            super(null);
            this.type = i3;
            this.styleName = str;
            this.styleData = str2;
            this.requireName = str3;
            this.requireData = str4;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getRequireData() {
            return this.requireData;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getRequireName() {
            return this.requireName;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getStyleData() {
            return this.styleData;
        }

        @Nullable
        /* renamed from: d, reason: from getter */
        public final String getStyleName() {
            return this.styleName;
        }

        /* renamed from: e, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateRobotDrawData)) {
                return false;
            }
            UpdateRobotDrawData updateRobotDrawData = (UpdateRobotDrawData) other;
            if (this.type == updateRobotDrawData.type && Intrinsics.areEqual(this.styleName, updateRobotDrawData.styleName) && Intrinsics.areEqual(this.styleData, updateRobotDrawData.styleData) && Intrinsics.areEqual(this.requireName, updateRobotDrawData.requireName) && Intrinsics.areEqual(this.requireData, updateRobotDrawData.requireData)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int hashCode3;
            int i3 = this.type * 31;
            String str = this.styleName;
            int i16 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            String str2 = this.styleData;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i18 = (i17 + hashCode2) * 31;
            String str3 = this.requireName;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i19 = (i18 + hashCode3) * 31;
            String str4 = this.requireData;
            if (str4 != null) {
                i16 = str4.hashCode();
            }
            return i19 + i16;
        }

        @NotNull
        public String toString() {
            return "UpdateRobotDrawData(type=" + this.type + ", styleName=" + this.styleName + ", styleData=" + this.styleData + ", requireName=" + this.requireName + ", requireData=" + this.requireData + ")";
        }
    }

    public /* synthetic */ RobotDrawMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mvi.base.route.i
    public /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    @Override // com.tencent.mvi.base.route.MsgIntent
    public boolean isSticky() {
        return MsgIntent.a.a(this);
    }

    RobotDrawMsgIntent() {
    }
}
