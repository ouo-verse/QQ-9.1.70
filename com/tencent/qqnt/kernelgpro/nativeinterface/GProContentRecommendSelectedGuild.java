package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProContentRecommendSelectedGuild implements Serializable {
    long serialVersionUID = 1;
    public ArrayList<GProSelectedGuildCard> selectedGuilds = new ArrayList<>();

    public ArrayList<GProSelectedGuildCard> getSelectedGuilds() {
        return this.selectedGuilds;
    }

    public String toString() {
        return "GProContentRecommendSelectedGuild{selectedGuilds=" + this.selectedGuilds + ",}";
    }
}
