package com.tencent.state.square;

import com.tencent.rapier.b;
import com.tencent.state.service.UserFormatKt;
import com.tencent.state.square.api.ISquareBaseMessageService;
import com.tencent.state.square.api.MessageRecordType;
import com.tencent.state.square.api.SquareBaseMessageRecord;
import com.tencent.state.square.api.SquareTroopMessageRecord;
import com.tencent.state.square.data.SquareTroopItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/state/square/SquareAreaRankAdapter$getTroopInfo$1", "Lcom/tencent/rapier/b;", "Lht4/b;", "response", "", "onSuccess", "", "errorCode", "", "errorMessage", "onFailure", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareAreaRankAdapter$getTroopInfo$1 implements b<ht4.b> {
    final /* synthetic */ Function1 $onSuccess;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SquareAreaRankAdapter$getTroopInfo$1(Function1 function1) {
        this.$onSuccess = function1;
    }

    @Override // com.tencent.rapier.b
    public void onFailure(int errorCode, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        SquareBaseKt.getSquareLog().i("SquareAreaRankAdapter", "getTroopInfo errorCode = " + errorCode + ", errorMessage = " + errorMessage);
    }

    @Override // com.tencent.rapier.b
    public void onSuccess(ht4.b response) {
        Intrinsics.checkNotNullParameter(response, "response");
        final SquareTroopItem formatSquareItem = UserFormatKt.formatSquareItem(response);
        if (formatSquareItem != null) {
            final ISquareBaseMessageService createService = Square.INSTANCE.getConfig().getSquareMiniAioServiceProvider().createService();
            ISquareBaseMessageService.DefaultImpls.getSingleUnreadMsg$default(createService, formatSquareItem.getUin(), false, MessageRecordType.RECORD_TYPE_TROOP, new Function1<SquareBaseMessageRecord, Unit>() { // from class: com.tencent.state.square.SquareAreaRankAdapter$getTroopInfo$1$onSuccess$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(SquareBaseMessageRecord squareBaseMessageRecord) {
                    invoke2(squareBaseMessageRecord);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SquareBaseMessageRecord squareBaseMessageRecord) {
                    boolean z16 = !createService.isReceiveNotify(formatSquareItem.getUin(), MessageRecordType.RECORD_TYPE_TROOP);
                    SquareTroopItem squareTroopItem = formatSquareItem;
                    if (!(squareBaseMessageRecord instanceof SquareTroopMessageRecord)) {
                        squareBaseMessageRecord = null;
                    }
                    SquareTroopMessageRecord squareTroopMessageRecord = (SquareTroopMessageRecord) squareBaseMessageRecord;
                    if (squareTroopMessageRecord != null) {
                        squareTroopItem.setLastMsg(squareTroopMessageRecord);
                        formatSquareItem.getExtra().setDisturb(z16);
                        SquareAreaRankAdapter$getTroopInfo$1.this.$onSuccess.invoke(formatSquareItem);
                    }
                }
            }, 2, null);
        }
    }
}
