package com.tencent.now.linkpkanchorplay.rankpkhistory.model;

import com.tencent.component.callback.ITimedCallback;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.now.linkpkanchorplay.sso.request.GetAnchorRankPKHistoryRequest;
import g55.u;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ,\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/rankpkhistory/model/RankPKHistoryModel;", "", "", "roomId", "", "extra", "", "pkType", "Lcom/tencent/component/callback/ITimedCallback;", "Lg55/u;", "callback", "", "a", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class RankPKHistoryModel {
    public final void a(long roomId, @NotNull String extra, int pkType, @NotNull final ITimedCallback<u> callback) {
        Intrinsics.checkNotNullParameter(extra, "extra");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new GetAnchorRankPKHistoryRequest(roomId, pkType, extra), new Function1<QQLiveResponse<u>, Unit>() { // from class: com.tencent.now.linkpkanchorplay.rankpkhistory.model.RankPKHistoryModel$getRankPKHistory$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<u> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<u> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isFailed()) {
                    callback.fail((int) response.getRetCode(), response.getErrMsg());
                } else {
                    callback.success(response.getRsp());
                }
            }
        });
    }
}
