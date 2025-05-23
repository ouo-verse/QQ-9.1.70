package com.tencent.state.square.mayknow;

import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/state/square/mayknow/MayKnowDataProvider;", "", "()V", "cookies", "", "getMayKnowUserList", "", "callback", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/square/mayknow/MayKnowListInfo;", "hideMayKnowEntrance", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class MayKnowDataProvider {
    private static final int PAGE_COUNT = 80;
    private static final String TAG = "MayKnowDataProvider";
    private byte[] cookies = new byte[0];

    public final void getMayKnowUserList(final ResultCallback<MayKnowListInfo> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        MayKnowService.INSTANCE.getMayKnowList(this.cookies, 80, new ResultCallback<MayKnowListInfo>() { // from class: com.tencent.state.square.mayknow.MayKnowDataProvider$getMayKnowUserList$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                callback.onResultFailure(error, message);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(MayKnowListInfo result) {
                Intrinsics.checkNotNullParameter(result, "result");
                MayKnowDataProvider.this.cookies = result.getCookies();
                callback.onResultSuccess(result);
            }
        });
    }

    public final void hideMayKnowEntrance() {
        MayKnowService.INSTANCE.hideMayKnowEntrance(new ResultCallback<Object>() { // from class: com.tencent.state.square.mayknow.MayKnowDataProvider$hideMayKnowEntrance$1
            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int i3, String str, String str2) {
                ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultSuccess(Object result) {
                SquareBaseKt.getSquareLog().d("MayKnowDataProvider", "hideMayKnowEntrance onResultSuccess");
            }

            @Override // com.tencent.state.service.ResultCallback
            public void onResultFailure(int error, String message) {
                SquareBaseKt.getSquareLog().d("MayKnowDataProvider", "hideMayKnowEntrance onResultFailure " + error + ", msg:" + message);
            }
        });
    }
}
