package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildRobotAuthSetInfo {
    public int flag;

    /* renamed from: id, reason: collision with root package name */
    public int f359172id;

    public GProGuildRobotAuthSetInfo() {
    }

    public int getFlag() {
        return this.flag;
    }

    public int getId() {
        return this.f359172id;
    }

    public String toString() {
        return "GProGuildRobotAuthSetInfo{id=" + this.f359172id + ",flag=" + this.flag + ",}";
    }

    public GProGuildRobotAuthSetInfo(int i3, int i16) {
        this.f359172id = i3;
        this.flag = i16;
    }
}
