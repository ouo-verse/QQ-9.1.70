package com.tencent.now.pkgame.pklib.utils;

import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.now.pkgame.sso.request.ControlVoiceRequest;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import or4.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a8\u0006\t"}, d2 = {"", "selfUid", "targetUid", "", "muteType", "Lcom/tencent/now/pkgame/pklib/utils/a;", "callback", "", "a", "qq-live-linkpk-ui-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class MuteAnchorHelperKt {
    public static final void a(long j3, long j16, final int i3, @Nullable final a aVar) {
        AegisLogger.INSTANCE.i("PK_Biz|MuteAnchorHelper", "muteAnchorAudio, selfUid " + j3 + ", targetUid " + j16 + ", muteType " + i3);
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new ControlVoiceRequest(j3, j16, i3), new Function1<QQLiveResponse<d>, Unit>() { // from class: com.tencent.now.pkgame.pklib.utils.MuteAnchorHelperKt$muteAnchorAudio$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<d> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<d> response) {
                Intrinsics.checkNotNullParameter(response, "response");
                d rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    a aVar2 = a.this;
                    if (aVar2 != null) {
                        aVar2.a(i3, rsp.f423481a, rsp.f423482b);
                        return;
                    }
                    return;
                }
                AegisLogger.INSTANCE.e("PK_Biz|MuteAnchorHelper", "muteAnchorAudio", "onFailure, code:" + response.getRetCode() + ", msg:" + response.getErrMsg());
                a aVar3 = a.this;
                if (aVar3 != null) {
                    aVar3.a(i3, (int) response.getRetCode(), response.getErrMsg());
                }
            }
        });
    }
}
