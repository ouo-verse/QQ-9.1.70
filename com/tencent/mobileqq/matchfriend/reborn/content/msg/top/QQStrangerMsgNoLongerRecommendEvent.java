package com.tencent.mobileqq.matchfriend.reborn.content.msg.top;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$CardInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/top/QQStrangerMsgNoLongerRecommendEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "cardInfo", "Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$CardInfo;", "(Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$CardInfo;)V", "getCardInfo", "()Lcom/tencent/trpcprotocol/kuolie/prompt/prompt/Prompt$CardInfo;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerMsgNoLongerRecommendEvent extends SimpleBaseEvent {
    private final Prompt$CardInfo cardInfo;

    public QQStrangerMsgNoLongerRecommendEvent(Prompt$CardInfo cardInfo) {
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        this.cardInfo = cardInfo;
    }

    /* renamed from: component1, reason: from getter */
    public final Prompt$CardInfo getCardInfo() {
        return this.cardInfo;
    }

    public final QQStrangerMsgNoLongerRecommendEvent copy(Prompt$CardInfo cardInfo) {
        Intrinsics.checkNotNullParameter(cardInfo, "cardInfo");
        return new QQStrangerMsgNoLongerRecommendEvent(cardInfo);
    }

    public final Prompt$CardInfo getCardInfo() {
        return this.cardInfo;
    }

    public int hashCode() {
        return this.cardInfo.hashCode();
    }

    public String toString() {
        return "QQStrangerMsgNoLongerRecommendEvent(cardInfo=" + this.cardInfo + ")";
    }

    public static /* synthetic */ QQStrangerMsgNoLongerRecommendEvent copy$default(QQStrangerMsgNoLongerRecommendEvent qQStrangerMsgNoLongerRecommendEvent, Prompt$CardInfo prompt$CardInfo, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            prompt$CardInfo = qQStrangerMsgNoLongerRecommendEvent.cardInfo;
        }
        return qQStrangerMsgNoLongerRecommendEvent.copy(prompt$CardInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof QQStrangerMsgNoLongerRecommendEvent) && Intrinsics.areEqual(this.cardInfo, ((QQStrangerMsgNoLongerRecommendEvent) other).cardInfo);
    }
}
