package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

/* loaded from: classes24.dex */
public final class ProfilePic {
    public String picId;
    public int picTime;
    public HashMap<Integer, ProfilePicUrl> picUrlMap;

    public ProfilePic() {
        this.picId = "";
        this.picUrlMap = new HashMap<>();
    }

    public String getPicId() {
        return this.picId;
    }

    public int getPicTime() {
        return this.picTime;
    }

    public HashMap<Integer, ProfilePicUrl> getPicUrlMap() {
        return this.picUrlMap;
    }

    public ProfilePic(String str, int i3, HashMap<Integer, ProfilePicUrl> hashMap) {
        this.picId = "";
        new HashMap();
        this.picId = str;
        this.picTime = i3;
        this.picUrlMap = hashMap;
    }
}
