package oj4;

import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0000\"\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0002\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/data/gift/GiftMessage;", "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "a", "", "", "Ljava/util/List;", "FORBIDDEN_ANIM_GIFT_SET", "timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @JvmField
    @NotNull
    public static final List<Integer> f423029a;

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{301467, 301468, 301469});
        f423029a = listOf;
    }

    @Nullable
    public static final com.tencent.mobileqq.qqgift.mvvm.business.anim.a a(@Nullable GiftMessage giftMessage) {
        if (giftMessage == null || f423029a.contains(Integer.valueOf(giftMessage.giftID))) {
            return null;
        }
        if (giftMessage.giftNum == 0) {
            giftMessage.giftNum = 1;
        }
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
