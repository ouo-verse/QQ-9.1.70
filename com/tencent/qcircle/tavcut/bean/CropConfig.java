package com.tencent.qcircle.tavcut.bean;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class CropConfig implements Cloneable, Serializable {
    private float height;
    private float width;

    /* renamed from: x, reason: collision with root package name */
    private float f342452x;

    /* renamed from: y, reason: collision with root package name */
    private float f342453y;

    public CropConfig(float f16, float f17, float f18, float f19) {
        this.f342452x = f16;
        this.f342453y = f17;
        this.width = f18;
        this.height = f19;
    }

    public float getHeight() {
        return this.height;
    }

    public float getWidth() {
        return this.width;
    }

    public float getX() {
        return this.f342452x;
    }

    public float getY() {
        return this.f342453y;
    }

    public void setHeight(float f16) {
        this.height = f16;
    }

    public void setWidth(float f16) {
        this.width = f16;
    }

    public void setX(float f16) {
        this.f342452x = f16;
    }

    public void setY(float f16) {
        this.f342453y = f16;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CropConfig m235clone() {
        return new CropConfig(this.f342452x, this.f342453y, this.width, this.height);
    }
}
