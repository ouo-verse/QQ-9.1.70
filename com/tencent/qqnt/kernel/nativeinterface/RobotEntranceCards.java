package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class RobotEntranceCards {
    public boolean hasRed;
    public String entranceText = "";
    public ArrayList<EntranceCard> cards = new ArrayList<>();
    public String redDotAttach = "";

    public ArrayList<EntranceCard> getCards() {
        return this.cards;
    }

    public String getEntranceText() {
        return this.entranceText;
    }

    public boolean getHasRed() {
        return this.hasRed;
    }

    public String getRedDotAttach() {
        return this.redDotAttach;
    }

    public String toString() {
        return "RobotEntranceCards{hasRed=" + this.hasRed + ",entranceText=" + this.entranceText + ",cards=" + this.cards + ",redDotAttach=" + this.redDotAttach + ",}";
    }
}
