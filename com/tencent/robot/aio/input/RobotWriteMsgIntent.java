package com.tencent.robot.aio.input;

import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qqnt.kernel.nativeinterface.QueryHalfViewDataRsp;
import e74.f;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0006\t\n\u000b\f\r\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/aio/input/RobotWriteMsgIntent;", "Lcom/tencent/mvi/base/route/MsgIntent;", "()V", "GetAnchorViewMsgIntent", "GetBotWriteResponseMsgIntent", "RequestBotWriteMsgIntent", "ShowRobotWriteDialog", "SubmitListMsgIntent", "UpdateRobotWriteData", "Lcom/tencent/robot/aio/input/RobotWriteMsgIntent$GetAnchorViewMsgIntent;", "Lcom/tencent/robot/aio/input/RobotWriteMsgIntent$GetBotWriteResponseMsgIntent;", "Lcom/tencent/robot/aio/input/RobotWriteMsgIntent$RequestBotWriteMsgIntent;", "Lcom/tencent/robot/aio/input/RobotWriteMsgIntent$ShowRobotWriteDialog;", "Lcom/tencent/robot/aio/input/RobotWriteMsgIntent$SubmitListMsgIntent;", "Lcom/tencent/robot/aio/input/RobotWriteMsgIntent$UpdateRobotWriteData;", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public abstract class RobotWriteMsgIntent implements MsgIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/input/RobotWriteMsgIntent$GetAnchorViewMsgIntent;", "Lcom/tencent/robot/aio/input/RobotWriteMsgIntent;", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class GetAnchorViewMsgIntent extends RobotWriteMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final GetAnchorViewMsgIntent f367159d = new GetAnchorViewMsgIntent();

        GetAnchorViewMsgIntent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0004\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/robot/aio/input/RobotWriteMsgIntent$GetBotWriteResponseMsgIntent;", "Lcom/tencent/robot/aio/input/RobotWriteMsgIntent;", "", "isSticky", "", "toString", "", "hashCode", "", "other", "equals", "d", "Z", "c", "()Z", "success", "e", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;", "b", "()Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;", "response", "<init>", "(ZLjava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/QueryHalfViewDataRsp;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class GetBotWriteResponseMsgIntent extends RobotWriteMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean success;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String errMsg;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final QueryHalfViewDataRsp response;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetBotWriteResponseMsgIntent(boolean z16, @NotNull String errMsg, @Nullable QueryHalfViewDataRsp queryHalfViewDataRsp) {
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
            if (!(other instanceof GetBotWriteResponseMsgIntent)) {
                return false;
            }
            GetBotWriteResponseMsgIntent getBotWriteResponseMsgIntent = (GetBotWriteResponseMsgIntent) other;
            if (this.success == getBotWriteResponseMsgIntent.success && Intrinsics.areEqual(this.errMsg, getBotWriteResponseMsgIntent.errMsg) && Intrinsics.areEqual(this.response, getBotWriteResponseMsgIntent.response)) {
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

        @Override // com.tencent.robot.aio.input.RobotWriteMsgIntent, com.tencent.mvi.base.route.MsgIntent
        public boolean isSticky() {
            return true;
        }

        @NotNull
        public String toString() {
            return "GetBotWriteResponseMsgIntent(success=" + this.success + ", errMsg=" + this.errMsg + ", response=" + this.response + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/input/RobotWriteMsgIntent$RequestBotWriteMsgIntent;", "Lcom/tencent/robot/aio/input/RobotWriteMsgIntent;", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class RequestBotWriteMsgIntent extends RobotWriteMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final RequestBotWriteMsgIntent f367163d = new RequestBotWriteMsgIntent();

        RequestBotWriteMsgIntent() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/robot/aio/input/RobotWriteMsgIntent$ShowRobotWriteDialog;", "Lcom/tencent/robot/aio/input/RobotWriteMsgIntent;", "()V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public static final class ShowRobotWriteDialog extends RobotWriteMsgIntent {

        /* renamed from: d, reason: collision with root package name */
        @NotNull
        public static final ShowRobotWriteDialog f367164d = new ShowRobotWriteDialog();

        ShowRobotWriteDialog() {
            super(null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/robot/aio/input/RobotWriteMsgIntent$SubmitListMsgIntent;", "Lcom/tencent/robot/aio/input/RobotWriteMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "Le74/f;", "d", "Le74/f;", "a", "()Le74/f;", "drawData", "<init>", "(Le74/f;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class SubmitListMsgIntent extends RobotWriteMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final f drawData;

        public SubmitListMsgIntent(@Nullable f fVar) {
            super(null);
            this.drawData = fVar;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final f getDrawData() {
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
            f fVar = this.drawData;
            if (fVar == null) {
                return 0;
            }
            return fVar.hashCode();
        }

        @NotNull
        public String toString() {
            return "SubmitListMsgIntent(drawData=" + this.drawData + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B{\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0004\u0012\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0011\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012B\u0010 \u001a>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001c\u0018\u00010\u0010j&\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001cj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001d\u0018\u0001`\u0011\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR+\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0010j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aRS\u0010 \u001a>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001c\u0018\u00010\u0010j&\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u001cj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u001d\u0018\u0001`\u00118\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\u00a8\u0006#"}, d2 = {"Lcom/tencent/robot/aio/input/RobotWriteMsgIntent$UpdateRobotWriteData;", "Lcom/tencent/robot/aio/input/RobotWriteMsgIntent;", "", "toString", "", "hashCode", "", "other", "", "equals", "d", "I", "()I", "setType", "(I)V", "type", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "e", "Ljava/util/ArrayList;", "c", "()Ljava/util/ArrayList;", "template", "f", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "placeHolder", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", h.F, "a", "data", "<init>", "(ILjava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final /* data */ class UpdateRobotWriteData extends RobotWriteMsgIntent {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private int type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final ArrayList<String> template;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String placeHolder;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final ArrayList<HashMap<String, String>> data;

        public UpdateRobotWriteData(int i3, @Nullable ArrayList<String> arrayList, @Nullable String str, @Nullable ArrayList<HashMap<String, String>> arrayList2) {
            super(null);
            this.type = i3;
            this.template = arrayList;
            this.placeHolder = str;
            this.data = arrayList2;
        }

        @Nullable
        public final ArrayList<HashMap<String, String>> a() {
            return this.data;
        }

        @Nullable
        /* renamed from: b, reason: from getter */
        public final String getPlaceHolder() {
            return this.placeHolder;
        }

        @Nullable
        public final ArrayList<String> c() {
            return this.template;
        }

        /* renamed from: d, reason: from getter */
        public final int getType() {
            return this.type;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UpdateRobotWriteData)) {
                return false;
            }
            UpdateRobotWriteData updateRobotWriteData = (UpdateRobotWriteData) other;
            if (this.type == updateRobotWriteData.type && Intrinsics.areEqual(this.template, updateRobotWriteData.template) && Intrinsics.areEqual(this.placeHolder, updateRobotWriteData.placeHolder) && Intrinsics.areEqual(this.data, updateRobotWriteData.data)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode;
            int hashCode2;
            int i3 = this.type * 31;
            ArrayList<String> arrayList = this.template;
            int i16 = 0;
            if (arrayList == null) {
                hashCode = 0;
            } else {
                hashCode = arrayList.hashCode();
            }
            int i17 = (i3 + hashCode) * 31;
            String str = this.placeHolder;
            if (str == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str.hashCode();
            }
            int i18 = (i17 + hashCode2) * 31;
            ArrayList<HashMap<String, String>> arrayList2 = this.data;
            if (arrayList2 != null) {
                i16 = arrayList2.hashCode();
            }
            return i18 + i16;
        }

        @NotNull
        public String toString() {
            return "UpdateRobotWriteData(type=" + this.type + ", template=" + this.template + ", placeHolder=" + this.placeHolder + ", data=" + this.data + ")";
        }
    }

    public /* synthetic */ RobotWriteMsgIntent(DefaultConstructorMarker defaultConstructorMarker) {
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

    RobotWriteMsgIntent() {
    }
}
