package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class ProfilePicInfo {
    public ArrayList<ProfilePic> picList;

    public ProfilePicInfo() {
        this.picList = new ArrayList<>();
    }

    public ArrayList<ProfilePic> getPicList() {
        return this.picList;
    }

    public ProfilePicInfo(ArrayList<ProfilePic> arrayList) {
        new ArrayList();
        this.picList = arrayList;
    }
}
