package com.tencent.tav.player;

/* loaded from: classes26.dex */
public class PlayerMessage {
    public Object bizMsg1;
    public Object bizMsg2;
    public String form;
    public long msgId;

    public PlayerMessage(Object obj, long j3) {
        this.bizMsg1 = obj;
        this.msgId = j3;
    }

    public String toString() {
        return "PlayerMessage{bizMsg1=" + this.bizMsg1 + ", form='" + this.form + "', msgId=" + this.msgId + '}';
    }

    public PlayerMessage(Object obj, String str, long j3) {
        this.bizMsg1 = obj;
        this.form = str;
        this.msgId = j3;
    }

    public PlayerMessage(Object obj, Object obj2, String str, long j3) {
        this.bizMsg1 = obj;
        this.bizMsg2 = obj2;
        this.form = str;
        this.msgId = j3;
    }
}
