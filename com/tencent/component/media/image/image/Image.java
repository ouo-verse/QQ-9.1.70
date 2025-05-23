package com.tencent.component.media.image.image;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class Image {

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class MetaInfo {
        public int height;
        public int width;
    }

    public abstract boolean isRecycled();

    public abstract void recycle();

    public abstract int size();
}
