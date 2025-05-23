package com.tencent.state.square.feeds;

import com.tencent.state.service.ResultCallback;
import com.tencent.state.square.SquareBaseKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/state/square/feeds/SquareQZoneFeedsManager$queryQZonePrivacy$1", "Lcom/tencent/state/service/ResultCallback;", "", "onResultFailure", "", "error", "", "message", "", "onResultSuccess", "result", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareQZoneFeedsManager$queryQZonePrivacy$1 implements ResultCallback<Boolean> {
    final /* synthetic */ Function1 $callback;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SquareQZoneFeedsManager$queryQZonePrivacy$1(Function1 function1) {
        this.$callback = function1;
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int i3, String str, String str2) {
        ResultCallback.DefaultImpls.onResultFailure(this, i3, str, str2);
    }

    @Override // com.tencent.state.service.ResultCallback
    public /* bridge */ /* synthetic */ void onResultSuccess(Boolean bool) {
        onResultSuccess(bool.booleanValue());
    }

    @Override // com.tencent.state.service.ResultCallback
    public void onResultFailure(int error, String message) {
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.feeds.SquareQZoneFeedsManager$queryQZonePrivacy$1$onResultFailure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SquareQZoneFeedsManager$queryQZonePrivacy$1.this.$callback.invoke(Boolean.TRUE);
            }
        });
    }

    public void onResultSuccess(final boolean result) {
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.feeds.SquareQZoneFeedsManager$queryQZonePrivacy$1$onResultSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SquareQZoneFeedsManager$queryQZonePrivacy$1.this.$callback.invoke(Boolean.valueOf(result));
            }
        });
    }
}
