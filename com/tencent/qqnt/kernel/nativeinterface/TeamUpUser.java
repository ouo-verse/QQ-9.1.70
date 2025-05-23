package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class TeamUpUser implements Serializable {
    public long uin;
    long serialVersionUID = 1;
    public String nick = "";
    public String head = "";

    public String getHead() {
        return this.head;
    }

    public String getNick() {
        return this.nick;
    }

    public long getUin() {
        return this.uin;
    }

    public String toString() {
        return "TeamUpUser{uin=" + this.uin + ",nick=" + this.nick + ",head=" + this.head + ",}";
    }
}
