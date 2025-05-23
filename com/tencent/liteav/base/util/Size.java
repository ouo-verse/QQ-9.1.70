package com.tencent.liteav.base.util;

import com.tencent.liteav.base.annotations.JNINamespace;

/* compiled from: P */
@JNINamespace("liteav")
/* loaded from: classes7.dex */
public class Size {
    public int height;
    public int width;

    public Size() {
        this.width = 0;
        this.height = 0;
    }

    public double aspectRatio() {
        return (this.width * 1.0d) / this.height;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (size.width == this.width && size.height == this.height) {
            return true;
        }
        return false;
    }

    public int getArea() {
        if (!isValid()) {
            return 0;
        }
        return this.width * this.height;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width * 32713) + this.height;
    }

    public boolean isValid() {
        if (this.width > 0 && this.height > 0) {
            return true;
        }
        return false;
    }

    public void set(Size size) {
        if (size != null) {
            this.width = size.width;
            this.height = size.height;
        } else {
            this.width = 0;
            this.height = 0;
        }
    }

    public void swap() {
        int i3 = this.width;
        this.width = this.height;
        this.height = i3;
    }

    public String toString() {
        return "Size(" + this.width + ", " + this.height + ")";
    }

    public Size(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }

    public void set(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }

    public Size(Size size) {
        this.width = 0;
        this.height = 0;
        set(size);
    }
}
