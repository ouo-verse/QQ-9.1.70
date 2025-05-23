package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetSelectChannelIDReq {
    public String code;
    public ArrayList<GProSelectChannel> selectChannels;

    public GProGetSelectChannelIDReq() {
        this.code = "";
        this.selectChannels = new ArrayList<>();
    }

    public String getCode() {
        return this.code;
    }

    public ArrayList<GProSelectChannel> getSelectChannels() {
        return this.selectChannels;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setSelectChannels(ArrayList<GProSelectChannel> arrayList) {
        this.selectChannels = arrayList;
    }

    public String toString() {
        return "GProGetSelectChannelIDReq{code=" + this.code + ",selectChannels=" + this.selectChannels + ",}";
    }

    public GProGetSelectChannelIDReq(String str, ArrayList<GProSelectChannel> arrayList) {
        this.code = "";
        new ArrayList();
        this.code = str;
        this.selectChannels = arrayList;
    }
}
