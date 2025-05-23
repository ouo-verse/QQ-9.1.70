package com.tencent.state.square;

import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.data.SquareAvatarItem;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/state/square/SquareAreaRankAdapter$getUserInfo$1", "Lcom/tencent/state/service/ResultCallback;", "Lcom/tencent/state/square/data/SquareAvatarItem;", "onResultFailure", "", "error", "", "message", "", "onResultSuccess", "result", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareAreaRankAdapter$getUserInfo$1 implements ResultCallback<SquareAvatarItem> {
    final /* synthetic */ Function1 $onSuccess;
    final /* synthetic */ String $uin;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SquareAreaRankAdapter$getUserInfo$1(String str, Function1 function1) {
        this.$uin = str;
        this.$onSuccess = function1;
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int i3, String str, String str2) {
        ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int error, String message) {
        SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "SquareAreaRankAdapter", "getUserInfo failed: error=" + error + ", message=" + message, null, 4, null);
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultSuccess(SquareAvatarItem result) {
        if (result == null) {
            SquareBaseKt.getSquareLog().i("SquareAreaRankAdapter", "getUseInfo result = null");
        } else {
            ISquareBaseMessageService.DefaultImpls.getSingleUnreadMsg$default(Square.INSTANCE.getConfig().getSquareMiniAioServiceProvider().createService(), this.$uin, false, null, new SquareAreaRankAdapter$getUserInfo$1$onResultSuccess$1(this, result), 6, null);
        }
    }
}
