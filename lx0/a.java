package lx0;

import com.tencent.mobileqq.icgame.data.gift.GiftMessage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/icgame/data/gift/GiftMessage;", "giftMessage", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "a", "ic-game-timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {
    @NotNull
    public static final com.tencent.mobileqq.qqgift.mvvm.business.anim.a a(@NotNull GiftMessage giftMessage) {
        Intrinsics.checkNotNullParameter(giftMessage, "giftMessage");
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = new com.tencent.mobileqq.qqgift.mvvm.business.anim.a();
        aVar.f264910a = giftMessage.giftID;
        aVar.f264911b = giftMessage.giftType;
        aVar.f264913d = giftMessage.giftName;
        aVar.f264914e = giftMessage.materialID;
        aVar.f264915f = giftMessage.giftNum;
        aVar.f264918i = giftMessage.sender;
        aVar.f264919j = giftMessage.senderNick;
        aVar.f264922m = giftMessage.senderHead;
        aVar.f264921l = giftMessage.receiverNick;
        aVar.f264923n = giftMessage.receiverHead;
        aVar.f264924o = giftMessage.effectLevel;
        aVar.f264925p = giftMessage.comboSeq;
        aVar.f264926q = giftMessage.allComboCnt;
        aVar.f264912c = giftMessage.giftPrice;
        aVar.f264917h = giftMessage.batchSendCnt;
        return aVar;
    }
}
