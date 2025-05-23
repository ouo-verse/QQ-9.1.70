package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class RedPoint {
    public ArrayList<Entry> entry = new ArrayList<>();
    public long num;
    public int redPosition;
    public int redType;

    public ArrayList<Entry> getEntry() {
        return this.entry;
    }

    public long getNum() {
        return this.num;
    }

    public int getRedPosition() {
        return this.redPosition;
    }

    public int getRedType() {
        return this.redType;
    }

    public void setEntry(ArrayList<Entry> arrayList) {
        this.entry = arrayList;
    }

    public void setNum(long j3) {
        this.num = j3;
    }

    public void setRedPosition(int i3) {
        this.redPosition = i3;
    }

    public void setRedType(int i3) {
        this.redType = i3;
    }
}
