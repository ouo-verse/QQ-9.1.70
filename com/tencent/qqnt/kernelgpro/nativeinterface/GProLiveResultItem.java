package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProLiveResultItem {
    public GProLiveRoomInfo liveChannel;
    public ArrayList<MsgAbstract> msgAbstracts;

    public GProLiveResultItem() {
        this.liveChannel = new GProLiveRoomInfo();
        this.msgAbstracts = new ArrayList<>();
    }

    public GProLiveRoomInfo getLiveChannel() {
        return this.liveChannel;
    }

    public ArrayList<MsgAbstract> getMsgAbstracts() {
        return this.msgAbstracts;
    }

    public String toString() {
        return "GProLiveResultItem{liveChannel=" + this.liveChannel + ",msgAbstracts=" + this.msgAbstracts + ",}";
    }

    public GProLiveResultItem(GProLiveRoomInfo gProLiveRoomInfo) {
        this.liveChannel = new GProLiveRoomInfo();
        this.msgAbstracts = new ArrayList<>();
        this.liveChannel = gProLiveRoomInfo;
    }
}
