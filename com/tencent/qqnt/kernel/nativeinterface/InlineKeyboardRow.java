package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class InlineKeyboardRow {
    public ArrayList<InlineKeyboardButton> buttons;

    public InlineKeyboardRow() {
        this.buttons = new ArrayList<>();
    }

    public ArrayList<InlineKeyboardButton> getButtons() {
        return this.buttons;
    }

    public String toString() {
        return "InlineKeyboardRow{buttons=" + this.buttons + ",}";
    }

    public InlineKeyboardRow(ArrayList<InlineKeyboardButton> arrayList) {
        new ArrayList();
        this.buttons = arrayList;
    }
}
