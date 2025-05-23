package com.tencent.state.square;

import com.tencent.state.service.VasFocusLikeService;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.template.data.CommonFootLabel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringNumberConversionsKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n\u00a2\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "msg", "Lcom/tencent/state/square/api/SquareBaseMessageRecord;", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes38.dex */
final class SquareAreaRankAdapter$getUserInfo$1$onResultSuccess$1 extends Lambda implements Function1<SquareBaseMessageRecord, Unit> {
    final /* synthetic */ SquareAvatarItem $result;
    final /* synthetic */ SquareAreaRankAdapter$getUserInfo$1 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SquareAreaRankAdapter$getUserInfo$1$onResultSuccess$1(SquareAreaRankAdapter$getUserInfo$1 squareAreaRankAdapter$getUserInfo$1, SquareAvatarItem squareAvatarItem) {
        super(1);
        this.this$0 = squareAreaRankAdapter$getUserInfo$1;
        this.$result = squareAvatarItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SquareBaseMessageRecord squareBaseMessageRecord) {
        invoke2(squareBaseMessageRecord);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SquareBaseMessageRecord squareBaseMessageRecord) {
        Long longOrNull;
        this.$result.getExtra().setLastUnReadMsg(squareBaseMessageRecord);
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(this.this$0.$uin);
        if (longOrNull != null) {
            VasFocusLikeService.INSTANCE.getTargetFootLabel(longOrNull.longValue(), new Function2<Boolean, CommonFootLabel, Unit>() { // from class: com.tencent.state.square.SquareAreaRankAdapter$getUserInfo$1$onResultSuccess$1$$special$$inlined$let$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, CommonFootLabel commonFootLabel) {
                    invoke(bool.booleanValue(), commonFootLabel);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, CommonFootLabel commonFootLabel) {
                    if (z16 && commonFootLabel != null) {
                        SquareAreaRankAdapter$getUserInfo$1$onResultSuccess$1.this.$result.getExtra().setFootLabel(commonFootLabel);
                    }
                    SquareAreaRankAdapter$getUserInfo$1$onResultSuccess$1 squareAreaRankAdapter$getUserInfo$1$onResultSuccess$1 = SquareAreaRankAdapter$getUserInfo$1$onResultSuccess$1.this;
                    squareAreaRankAdapter$getUserInfo$1$onResultSuccess$1.this$0.$onSuccess.invoke(squareAreaRankAdapter$getUserInfo$1$onResultSuccess$1.$result);
                }
            });
        }
    }
}
