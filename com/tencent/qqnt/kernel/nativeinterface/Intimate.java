package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class Intimate {
    public int iconFlag;
    public boolean isListenTogetherOpen;
    public ArrayList<MutualMark> mutual;

    public Intimate() {
        this.mutual = new ArrayList<>();
    }

    public int getIconFlag() {
        return this.iconFlag;
    }

    public boolean getIsListenTogetherOpen() {
        return this.isListenTogetherOpen;
    }

    public ArrayList<MutualMark> getMutual() {
        return this.mutual;
    }

    public Intimate(int i3, boolean z16, ArrayList<MutualMark> arrayList) {
        new ArrayList();
        this.iconFlag = i3;
        this.isListenTogetherOpen = z16;
        this.mutual = arrayList;
    }
}
