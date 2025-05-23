package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class Position {

    /* renamed from: x, reason: collision with root package name */
    public int f359201x;

    /* renamed from: y, reason: collision with root package name */
    public int f359202y;

    public Position() {
    }

    public int getX() {
        return this.f359201x;
    }

    public int getY() {
        return this.f359202y;
    }

    public String toString() {
        return "Position{x=" + this.f359201x + ",y=" + this.f359202y + ",}";
    }

    public Position(int i3, int i16) {
        this.f359201x = i3;
        this.f359202y = i16;
    }
}
