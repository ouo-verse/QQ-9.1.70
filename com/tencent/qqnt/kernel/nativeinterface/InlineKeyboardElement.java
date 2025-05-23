package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class InlineKeyboardElement {
    public long botAppid;
    public InlineKeyboardStyle keyboardStyle;
    public ArrayList<InlineKeyboardRow> rows;

    public InlineKeyboardElement() {
        this.rows = new ArrayList<>();
        this.keyboardStyle = new InlineKeyboardStyle();
    }

    public long getBotAppid() {
        return this.botAppid;
    }

    public InlineKeyboardStyle getKeyboardStyle() {
        return this.keyboardStyle;
    }

    public ArrayList<InlineKeyboardRow> getRows() {
        return this.rows;
    }

    public String toString() {
        return "InlineKeyboardElement{rows=" + this.rows + ",botAppid=" + this.botAppid + ",keyboardStyle=" + this.keyboardStyle + ",}";
    }

    public InlineKeyboardElement(ArrayList<InlineKeyboardRow> arrayList, long j3) {
        this.rows = new ArrayList<>();
        this.keyboardStyle = new InlineKeyboardStyle();
        this.rows = arrayList;
        this.botAppid = j3;
    }
}
