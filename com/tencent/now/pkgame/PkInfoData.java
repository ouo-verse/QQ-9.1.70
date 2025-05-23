package com.tencent.now.pkgame;

import com.tencent.component.callback.ITimedCallback;
import com.tencent.component.core.log.LogUtil;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.now.sso.request.GetAnchorPKInfoRequest;
import com.tencent.now.sso.request.GetLinkMicInfoRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import or4.g;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ$\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005J\u001c\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\n0\u0005\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/now/pkgame/PkInfoData;", "", "", "roomId", "anchorId", "Lcom/tencent/component/callback/ITimedCallback;", "Lor4/g;", "callback", "", "b", "Lg55/q;", "a", "<init>", "()V", "qq-live-linkpk-ui-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class PkInfoData {
    public final void a(long roomId, @NotNull final ITimedCallback<q> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AegisLogger.INSTANCE.i("PK_Biz|PkInfoData", "getAnchorPKInfo, roomId: " + roomId);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new GetAnchorPKInfoRequest(roomId), new Function1<QQLiveResponse<q>, Unit>() { // from class: com.tencent.now.pkgame.PkInfoData$getAnchorPKInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<q> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<q> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                q rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    AegisLogger.INSTANCE.i("PK_Biz|PkInfoData", "getAnchorPKInfo success");
                    callback.success(rsp);
                    return;
                }
                AegisLogger.INSTANCE.e("PK_Biz|PkInfoData", "getAnchorPKInfo", "fail, code:" + response.getRetCode() + ", msg:" + response.getErrMsg());
                callback.fail((int) response.getRetCode(), response.getErrMsg());
            }
        });
    }

    public final void b(long roomId, long anchorId, @NotNull final ITimedCallback<g> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        LogUtil.i("PK_Biz|PkInfoData", "getLinkMicInfo roomId: " + roomId + ", anchorUid: " + anchorId, new Object[0]);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new GetLinkMicInfoRequest(roomId, anchorId), new Function1<QQLiveResponse<g>, Unit>() { // from class: com.tencent.now.pkgame.PkInfoData$getLinkMicInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<g> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<g> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                g rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    callback.success(rsp);
                    return;
                }
                AegisLogger.INSTANCE.e("PK_Biz|PkInfoData", "getLinkMicInfo", "fail, code:" + response.getRetCode() + ", msg:" + response.getErrMsg());
                callback.fail((int) response.getRetCode(), response.getErrMsg());
            }
        });
    }
}
