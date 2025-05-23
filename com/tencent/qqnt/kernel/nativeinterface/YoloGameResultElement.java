package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class YoloGameResultElement {
    public ArrayList<YoloGameUserInfo> userInfo;

    public YoloGameResultElement() {
        this.userInfo = new ArrayList<>();
    }

    public ArrayList<YoloGameUserInfo> getUserInfo() {
        return this.userInfo;
    }

    public String toString() {
        return "YoloGameResultElement{userInfo=" + this.userInfo + ",}";
    }

    public YoloGameResultElement(ArrayList<YoloGameUserInfo> arrayList) {
        new ArrayList();
        this.userInfo = arrayList;
    }
}
