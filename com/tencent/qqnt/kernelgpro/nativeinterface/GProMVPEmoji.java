package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPEmoji implements Serializable {
    public long count;
    public boolean hasJoin;
    public int type;
    long serialVersionUID = 1;

    /* renamed from: id, reason: collision with root package name */
    public String f359297id = "";

    public long getCount() {
        return this.count;
    }

    public boolean getHasJoin() {
        return this.hasJoin;
    }

    public String getId() {
        return this.f359297id;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GProMVPEmoji{id=" + this.f359297id + ",type=" + this.type + ",count=" + this.count + ",hasJoin=" + this.hasJoin + ",}";
    }
}
