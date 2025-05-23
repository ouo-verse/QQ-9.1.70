package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SecurityInfo {
    public ArrayList<SecurityButton> buttons;
    public String wording;

    public SecurityInfo() {
        this.wording = "";
        this.buttons = new ArrayList<>();
    }

    public ArrayList<SecurityButton> getButtons() {
        return this.buttons;
    }

    public String getWording() {
        return this.wording;
    }

    public SecurityInfo(String str, ArrayList<SecurityButton> arrayList) {
        this.wording = "";
        new ArrayList();
        this.wording = str;
        this.buttons = arrayList;
    }
}
