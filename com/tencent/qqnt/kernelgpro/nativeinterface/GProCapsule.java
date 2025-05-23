package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProCapsule {
    public ArrayList<String> avatarMetaList = new ArrayList<>();
    public String text = "";

    public ArrayList<String> getAvatarMetaList() {
        return this.avatarMetaList;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "GProCapsule{avatarMetaList=" + this.avatarMetaList + ",text=" + this.text + ",}";
    }
}
