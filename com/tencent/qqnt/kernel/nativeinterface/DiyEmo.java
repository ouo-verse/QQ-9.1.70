package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DiyEmo {

    /* renamed from: id, reason: collision with root package name */
    public int f359165id;
    public int type;
    public String word;

    public DiyEmo() {
        this.word = "";
    }

    public int getId() {
        return this.f359165id;
    }

    public int getType() {
        return this.type;
    }

    public String getWord() {
        return this.word;
    }

    public String toString() {
        return "DiyEmo{id=" + this.f359165id + ",type=" + this.type + ",word=" + this.word + ",}";
    }

    public DiyEmo(int i3, int i16, String str) {
        this.f359165id = i3;
        this.type = i16;
        this.word = str;
    }
}
