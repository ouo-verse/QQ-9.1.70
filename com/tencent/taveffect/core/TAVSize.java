package com.tencent.taveffect.core;

/* compiled from: P */
/* loaded from: classes26.dex */
public class TAVSize implements Cloneable {
    public int height;
    public int width;

    public TAVSize() {
        this(0, 0);
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TAVSize)) {
            return false;
        }
        TAVSize tAVSize = (TAVSize) obj;
        if (this.width != tAVSize.width || this.height != tAVSize.height) {
            return false;
        }
        return true;
    }

    public TAVSize(int i3, int i16) {
        this.width = i3;
        this.height = i16;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public TAVSize m265clone() {
        return new TAVSize(this.width, this.height);
    }
}
