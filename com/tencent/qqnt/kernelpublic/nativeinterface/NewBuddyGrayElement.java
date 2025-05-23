package com.tencent.qqnt.kernelpublic.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class NewBuddyGrayElement implements Serializable {
    public String friendNick;
    public boolean isInitiator;
    long serialVersionUID;
    public int sourceId;
    public int subSourceId;
    public long time;

    public NewBuddyGrayElement() {
        this.serialVersionUID = 1L;
        this.friendNick = "";
    }

    public String getFriendNick() {
        return this.friendNick;
    }

    public boolean getIsInitiator() {
        return this.isInitiator;
    }

    public int getSourceId() {
        return this.sourceId;
    }

    public int getSubSourceId() {
        return this.subSourceId;
    }

    public long getTime() {
        return this.time;
    }

    public String toString() {
        return "NewBuddyGrayElement{time=" + this.time + ",sourceId=" + this.sourceId + ",subSourceId=" + this.subSourceId + ",isInitiator=" + this.isInitiator + ",friendNick=" + this.friendNick + ",}";
    }

    public NewBuddyGrayElement(long j3, int i3, int i16, boolean z16, String str) {
        this.serialVersionUID = 1L;
        this.time = j3;
        this.sourceId = i3;
        this.subSourceId = i16;
        this.isInitiator = z16;
        this.friendNick = str;
    }
}
