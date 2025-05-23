package com.tencent.now.linkpkanchorplay.linkscreen.model;

import com.tencent.component.callback.ITimedCallback;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.now.linkpkanchorplay.sso.request.AbortLinkRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import g55.b;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/now/linkpkanchorplay/linkscreen/model/AnchorInLinkScreenCtrlModel;", "", "", "roomId", "Lcom/tencent/component/callback/ITimedCallback;", "Lg55/b;", "callback", "", "a", "<init>", "()V", "qq-live-link-pk-anchorplay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class AnchorInLinkScreenCtrlModel {
    public final void a(long roomId, @NotNull final ITimedCallback<b> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        AegisLogger.INSTANCE.i("PK_Biz|AnchorInPkControlModel", "send endLinkScreen, roomId:" + roomId);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new AbortLinkRequest(roomId), new Function1<QQLiveResponse<b>, Unit>() { // from class: com.tencent.now.linkpkanchorplay.linkscreen.model.AnchorInLinkScreenCtrlModel$endLinkScreen$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<b> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<b> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                b rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    AegisLogger.INSTANCE.i("PK_Biz|AnchorInPkControlModel", "endLinkScreen", "success");
                    callback.success(rsp);
                    return;
                }
                AegisLogger.INSTANCE.e("PK_Biz|AnchorInPkControlModel", "endLinkScreen", "fail, code:" + response.getRetCode() + ", msg:" + response.getErrMsg());
                callback.fail((int) response.getRetCode(), response.getErrMsg());
            }
        });
    }
}
