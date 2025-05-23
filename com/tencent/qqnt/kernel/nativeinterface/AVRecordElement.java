package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AVRecordElement {
    public Integer extraType;
    public boolean hasRead;
    public int mainType;
    public String text;
    public long time;
    public int type;

    public AVRecordElement() {
        this.text = "";
    }

    public Integer getExtraType() {
        return this.extraType;
    }

    public boolean getHasRead() {
        return this.hasRead;
    }

    public int getMainType() {
        return this.mainType;
    }

    public String getText() {
        return this.text;
    }

    public long getTime() {
        return this.time;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "AVRecordElement{type=" + this.type + ",time=" + this.time + ",text=" + this.text + ",mainType=" + this.mainType + ",hasRead=" + this.hasRead + ",extraType=" + this.extraType + ",}";
    }

    public AVRecordElement(int i3, long j3, String str, int i16, boolean z16, Integer num) {
        this.type = i3;
        this.time = j3;
        this.text = str;
        this.mainType = i16;
        this.hasRead = z16;
        this.extraType = num;
    }
}
