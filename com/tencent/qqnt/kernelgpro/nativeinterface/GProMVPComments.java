package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProMVPComments {
    public ArrayList<GProMVPComment> comments = new ArrayList<>();
    public byte[] cookie = new byte[0];
    public int count;
    public boolean isEnd;

    public ArrayList<GProMVPComment> getComments() {
        return this.comments;
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public int getCount() {
        return this.count;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public String toString() {
        return "GProMVPComments{comments=" + this.comments + ",count=" + this.count + ",cookie=" + this.cookie + ",isEnd=" + this.isEnd + ",}";
    }
}
