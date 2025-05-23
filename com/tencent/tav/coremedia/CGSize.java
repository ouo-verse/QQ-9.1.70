package com.tencent.tav.coremedia;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CGSize implements Cloneable {
    public static final CGSize CGSizeZero = new CGSize(0.0f, 0.0f);
    public float height;
    public float width;

    public CGSize(float f16, float f17) {
        this.width = f16;
        this.height = f17;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CGSize)) {
            return false;
        }
        CGSize cGSize = (CGSize) obj;
        if (cGSize.width != this.width || cGSize.height != this.height) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "[" + this.width + "," + this.height + "]";
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public CGSize m258clone() {
        return new CGSize(this.width, this.height);
    }

    public CGSize() {
        this(1.0f, 1.0f);
    }
}
