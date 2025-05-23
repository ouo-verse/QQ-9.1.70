package org.light.bean;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SizeI {
    public int height;
    public int width;

    public SizeI() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SizeI sizeI = (SizeI) obj;
        if (this.width == sizeI.width && this.height == sizeI.height) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.width * 31) + this.height;
    }

    public String toString() {
        return "width = " + this.width + ", height = " + this.height;
    }

    public SizeI(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }
}
