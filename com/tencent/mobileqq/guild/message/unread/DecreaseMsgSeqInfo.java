package com.tencent.mobileqq.guild.message.unread;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes14.dex */
public class DecreaseMsgSeqInfo implements Serializable {
    public static int MSGTYPE_ATALL = 1;
    public static int MSGTYPE_NONE = 0;
    private static final long serialVersionUID = 1;
    public long msgSeq;
    public int msgType;

    public DecreaseMsgSeqInfo() {
        this.msgType = MSGTYPE_NONE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && ((DecreaseMsgSeqInfo) obj).msgSeq == this.msgSeq) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) this.msgSeq;
    }

    public String toString() {
        return "msgSeq:" + this.msgSeq + " msgType:" + this.msgType + " ";
    }

    public DecreaseMsgSeqInfo(long j3, int i3) {
        this.msgSeq = j3;
        this.msgType = i3;
    }
}
