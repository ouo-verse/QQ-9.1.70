package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotRecommendCard {
    public RobotRecommendCardType cardType = RobotRecommendCardType.values()[0];
    public ArrayList<RobotRecommendCardInfo> cards = new ArrayList<>();

    public RobotRecommendCardType getCardType() {
        return this.cardType;
    }

    public ArrayList<RobotRecommendCardInfo> getCards() {
        return this.cards;
    }
}
