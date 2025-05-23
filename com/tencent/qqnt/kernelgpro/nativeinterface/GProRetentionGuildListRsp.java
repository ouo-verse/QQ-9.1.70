package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRetentionGuildListRsp {
    public byte[] cookies;
    public boolean isEnd;
    public int nextTs;
    public ArrayList<GProRetentionChannelInfo> recommendChannels;

    public GProRetentionGuildListRsp() {
        this.recommendChannels = new ArrayList<>();
        this.cookies = new byte[0];
    }

    public byte[] getCookies() {
        return this.cookies;
    }

    public boolean getIsEnd() {
        return this.isEnd;
    }

    public int getNextTs() {
        return this.nextTs;
    }

    public ArrayList<GProRetentionChannelInfo> getRecommendChannels() {
        return this.recommendChannels;
    }

    public String toString() {
        return "GProRetentionGuildListRsp{recommendChannels=" + this.recommendChannels + ",nextTs=" + this.nextTs + ",cookies=" + this.cookies + ",isEnd=" + this.isEnd + ",}";
    }

    public GProRetentionGuildListRsp(ArrayList<GProRetentionChannelInfo> arrayList, int i3, byte[] bArr, boolean z16) {
        new ArrayList();
        this.recommendChannels = arrayList;
        this.nextTs = i3;
        this.cookies = bArr;
        this.isEnd = z16;
    }
}
