package com.tencent.state.square.detail;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.state.api.SquareErrorData;
import com.tencent.state.service.SetStatusResult;
import com.tencent.state.service.VasPublishStatusService;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.Square;
import com.tencent.state.square.data.AvatarLocationInfo;
import com.tencent.state.square.data.OnlineStatus;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006JH\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013J\u0006\u0010\u0015\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/state/square/detail/StatusPublishHelper;", "", "()V", "statusService", "Lcom/tencent/state/service/VasPublishStatusService;", "destroy", "", "doPublish", "context", "Landroid/content/Context;", "status", "Lcom/tencent/state/square/data/OnlineStatus;", "motionId", "", "customText", "", "avatarLocationInfo", "Lcom/tencent/state/square/data/AvatarLocationInfo;", "callback", "Lkotlin/Function1;", "Lcom/tencent/state/square/detail/StatusPublishHelper$PublishResult;", "init", "Companion", "PublishResult", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class StatusPublishHelper {
    public static final int PUBLISH_FAILED = 1;
    public static final int PUBLISH_SECURITY_ERROR = 2;
    public static final int PUBLISH_SUCCESS = 0;
    private static final String TAG = "StatusPublishHelper";
    private final VasPublishStatusService statusService = new VasPublishStatusService();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/state/square/detail/StatusPublishHelper$PublishResult;", "", "code", "", "isStatusSuccess", "", "data", "Lcom/tencent/state/api/SquareErrorData;", "(IZLcom/tencent/state/api/SquareErrorData;)V", "getCode", "()I", "getData", "()Lcom/tencent/state/api/SquareErrorData;", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final /* data */ class PublishResult {
        private final int code;
        private final SquareErrorData data;
        private final boolean isStatusSuccess;

        public PublishResult(int i3, boolean z16, SquareErrorData squareErrorData) {
            this.code = i3;
            this.isStatusSuccess = z16;
            this.data = squareErrorData;
        }

        /* renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsStatusSuccess() {
            return this.isStatusSuccess;
        }

        /* renamed from: component3, reason: from getter */
        public final SquareErrorData getData() {
            return this.data;
        }

        public final PublishResult copy(int code, boolean isStatusSuccess, SquareErrorData data) {
            return new PublishResult(code, isStatusSuccess, data);
        }

        public final int getCode() {
            return this.code;
        }

        public final SquareErrorData getData() {
            return this.data;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = this.code * 31;
            boolean z16 = this.isStatusSuccess;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (i3 + i16) * 31;
            SquareErrorData squareErrorData = this.data;
            return i17 + (squareErrorData != null ? squareErrorData.hashCode() : 0);
        }

        public final boolean isStatusSuccess() {
            return this.isStatusSuccess;
        }

        public String toString() {
            return "PublishResult(code=" + this.code + ", isStatusSuccess=" + this.isStatusSuccess + ", data=" + this.data + ")";
        }

        public /* synthetic */ PublishResult(int i3, boolean z16, SquareErrorData squareErrorData, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this(i3, z16, (i16 & 4) != 0 ? null : squareErrorData);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PublishResult)) {
                return false;
            }
            PublishResult publishResult = (PublishResult) other;
            return this.code == publishResult.code && this.isStatusSuccess == publishResult.isStatusSuccess && Intrinsics.areEqual(this.data, publishResult.data);
        }

        public static /* synthetic */ PublishResult copy$default(PublishResult publishResult, int i3, boolean z16, SquareErrorData squareErrorData, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = publishResult.code;
            }
            if ((i16 & 2) != 0) {
                z16 = publishResult.isStatusSuccess;
            }
            if ((i16 & 4) != 0) {
                squareErrorData = publishResult.data;
            }
            return publishResult.copy(i3, z16, squareErrorData);
        }
    }

    public final void destroy() {
        this.statusService.destroy();
    }

    public final void doPublish(final Context context, OnlineStatus status, int motionId, String customText, AvatarLocationInfo avatarLocationInfo, final Function1<? super PublishResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(customText, "customText");
        Intrinsics.checkNotNullParameter(avatarLocationInfo, "avatarLocationInfo");
        this.statusService.requestSetStatus(status, motionId, customText, avatarLocationInfo, new Function1<SetStatusResult, Unit>() { // from class: com.tencent.state.square.detail.StatusPublishHelper$doPublish$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SetStatusResult setStatusResult) {
                invoke2(setStatusResult);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SetStatusResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                if (result.isSetStatusSuccess()) {
                    Function1 function1 = Function1.this;
                    if (function1 != null) {
                        return;
                    }
                    return;
                }
                SquareErrorData setCustomTextErrorData = result.getSetCustomTextErrorData();
                Integer errCode = setCustomTextErrorData != null ? setCustomTextErrorData.getErrCode() : null;
                int i3 = 1;
                if (errCode == null || errCode.intValue() != 0) {
                    String prompt = setCustomTextErrorData != null ? setCustomTextErrorData.getPrompt() : null;
                    if ((prompt == null || prompt.length() == 0) == false) {
                        Context context2 = context;
                        if (context2 != null) {
                            Square.INSTANCE.getConfig().getCommonUtils().showToast(context2, setCustomTextErrorData != null ? setCustomTextErrorData.getPrompt() : null, 1);
                        }
                        Function1 function12 = Function1.this;
                        if (function12 != null) {
                            return;
                        }
                        return;
                    }
                }
                Integer errCode2 = setCustomTextErrorData != null ? setCustomTextErrorData.getErrCode() : null;
                if (errCode2 != null && errCode2.intValue() == -10032) {
                    Context context3 = context;
                    if (context3 != null) {
                        Square.INSTANCE.getConfig().getCommonUtils().showToast(context3, R.string.xee, 1);
                    }
                    i3 = 2;
                } else if (errCode2 != null && errCode2.intValue() == -23252) {
                    Context context4 = context;
                    if (context4 != null) {
                        ICommonUtils commonUtils = Square.INSTANCE.getConfig().getCommonUtils();
                        String errMsg = setCustomTextErrorData.getErrMsg();
                        if (errMsg == null) {
                            errMsg = context.getResources().getString(R.string.xd6);
                            Intrinsics.checkNotNullExpressionValue(errMsg, "context.resources.getStr\u2026quare_toast_publish_fail)");
                        }
                        commonUtils.showToast(context4, errMsg, 1);
                    }
                } else {
                    Context context5 = context;
                    if (context5 != null) {
                        ICommonUtils.DefaultImpls.showToast$default(Square.INSTANCE.getConfig().getCommonUtils(), context5, R.string.xea, 0, 4, (Object) null);
                    }
                }
                Function1 function13 = Function1.this;
                if (function13 != null) {
                }
            }
        });
    }

    public final void init() {
        this.statusService.init();
    }

    public static /* synthetic */ void doPublish$default(StatusPublishHelper statusPublishHelper, Context context, OnlineStatus onlineStatus, int i3, String str, AvatarLocationInfo avatarLocationInfo, Function1 function1, int i16, Object obj) {
        if ((i16 & 32) != 0) {
            function1 = null;
        }
        statusPublishHelper.doPublish(context, onlineStatus, i3, str, avatarLocationInfo, function1);
    }
}
