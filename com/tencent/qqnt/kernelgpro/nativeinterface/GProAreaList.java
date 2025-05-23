package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAreaList {
    public ArrayList<GProArea> areas = new ArrayList<>();
    public byte[] cookie = new byte[0];
    public boolean isEnd;
    public int level;

    public ArrayList<GProArea> getAreas() {
        return this.areas;
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public int getLevel() {
        return this.level;
    }

    public String toString() {
        return "GProAreaList{level=" + this.level + ",areas=" + this.areas + ",cookie=" + this.cookie + ",isEnd=" + this.isEnd + ",}";
    }
}
