package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProMVPRoleGroup implements Serializable {
    public int color;

    /* renamed from: id, reason: collision with root package name */
    public long f359301id;
    public String name;
    long serialVersionUID;

    public GProMVPRoleGroup() {
        this.serialVersionUID = 1L;
        this.name = "";
    }

    public int getColor() {
        return this.color;
    }

    public long getId() {
        return this.f359301id;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProMVPRoleGroup{id=" + this.f359301id + ",name=" + this.name + ",color=" + this.color + ",}";
    }

    public GProMVPRoleGroup(long j3, String str, int i3) {
        this.serialVersionUID = 1L;
        this.f359301id = j3;
        this.name = str;
        this.color = i3;
    }
}
