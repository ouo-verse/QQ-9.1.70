package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMVPReplys {
    public int count;
    public boolean isEnd;
    public ArrayList<GProMVPReply> replys = new ArrayList<>();
    public byte[] cookie = new byte[0];

    public byte[] getCookie() {
        return this.cookie;
    }

    public int getCount() {
        return this.count;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public ArrayList<GProMVPReply> getReplys() {
        return this.replys;
    }

    public String toString() {
        return "GProMVPReplys{replys=" + this.replys + ",count=" + this.count + ",cookie=" + this.cookie + ",isEnd=" + this.isEnd + ",}";
    }
}
