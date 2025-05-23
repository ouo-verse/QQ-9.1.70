package com.tencent.component.media.image;

/* loaded from: classes5.dex */
public interface BytePoolParams {

    /* loaded from: classes5.dex */
    public static class ByteArrayParams {
        public int arraysSize;
        public int byteMinSize;

        public ByteArrayParams(int i3, int i16) {
            this.byteMinSize = i3;
            this.arraysSize = i16;
        }
    }

    ByteArrayParams getByteArrayParams(int i3);

    int getBytePoolSize();
}
