package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class JoinDragonGroupEmojiReq {
    public Long latestMsgSeq;
    public int manageEmojiId;
    public long manageMsgSeq;
    public Contact peerContact;

    public JoinDragonGroupEmojiReq() {
        this.peerContact = new Contact();
    }

    public Long getLatestMsgSeq() {
        return this.latestMsgSeq;
    }

    public int getManageEmojiId() {
        return this.manageEmojiId;
    }

    public long getManageMsgSeq() {
        return this.manageMsgSeq;
    }

    public Contact getPeerContact() {
        return this.peerContact;
    }

    public String toString() {
        return "JoinDragonGroupEmojiReq{manageEmojiId=" + this.manageEmojiId + ",manageMsgSeq=" + this.manageMsgSeq + ",latestMsgSeq=" + this.latestMsgSeq + ",peerContact=" + this.peerContact + ",}";
    }

    public JoinDragonGroupEmojiReq(int i3, long j3, Long l3, Contact contact) {
        new Contact();
        this.manageEmojiId = i3;
        this.manageMsgSeq = j3;
        this.latestMsgSeq = l3;
        this.peerContact = contact;
    }
}
