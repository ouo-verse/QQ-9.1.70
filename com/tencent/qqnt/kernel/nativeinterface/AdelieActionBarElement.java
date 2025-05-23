package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class AdelieActionBarElement {
    public long botAppid;
    public InlineKeyboardStyle keyboardStyle;
    public ArrayList<InlineKeyboardRow> rows;

    public AdelieActionBarElement() {
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
        return "AdelieActionBarElement{rows=" + this.rows + ",botAppid=" + this.botAppid + ",keyboardStyle=" + this.keyboardStyle + ",}";
    }

    public AdelieActionBarElement(ArrayList<InlineKeyboardRow> arrayList, long j3) {
        this.rows = new ArrayList<>();
        this.keyboardStyle = new InlineKeyboardStyle();
        this.rows = arrayList;
        this.botAppid = j3;
    }
}
