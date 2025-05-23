package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupGuildNotifyInfo {
    public long channelId;
    public int muteSwitch;
    public Contact peer;
    public ArrayList<SceneDetailInfo> sceneDetailInfo;
    public long senderUin;
    public Summary summary;
    public long timeStamp;

    public GroupGuildNotifyInfo() {
        this.peer = new Contact();
        this.sceneDetailInfo = new ArrayList<>();
        this.summary = new Summary();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getMuteSwitch() {
        return this.muteSwitch;
    }

    public Contact getPeer() {
        return this.peer;
    }

    public ArrayList<SceneDetailInfo> getSceneDetailInfo() {
        return this.sceneDetailInfo;
    }

    public long getSenderUin() {
        return this.senderUin;
    }

    public Summary getSummary() {
        return this.summary;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public String toString() {
        return "GroupGuildNotifyInfo{peer=" + this.peer + ",sceneDetailInfo=" + this.sceneDetailInfo + ",timeStamp=" + this.timeStamp + ",muteSwitch=" + this.muteSwitch + ",senderUin=" + this.senderUin + ",summary=" + this.summary + ",channelId=" + this.channelId + ",}";
    }

    public GroupGuildNotifyInfo(Contact contact, ArrayList<SceneDetailInfo> arrayList, long j3, int i3, long j16, Summary summary, long j17) {
        this.peer = new Contact();
        this.sceneDetailInfo = new ArrayList<>();
        new Summary();
        this.peer = contact;
        this.sceneDetailInfo = arrayList;
        this.timeStamp = j3;
        this.muteSwitch = i3;
        this.senderUin = j16;
        this.summary = summary;
        this.channelId = j17;
    }
}
