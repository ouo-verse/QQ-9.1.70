package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProLabel implements Serializable {
    public int color;

    /* renamed from: id, reason: collision with root package name */
    public int f359295id;
    long serialVersionUID = 1;
    public String text = "";

    public int getColor() {
        return this.color;
    }

    public int getId() {
        return this.f359295id;
    }

    public String getText() {
        return this.text;
    }

    public String toString() {
        return "GProLabel{id=" + this.f359295id + ",text=" + this.text + ",color=" + this.color + ",}";
    }
}
