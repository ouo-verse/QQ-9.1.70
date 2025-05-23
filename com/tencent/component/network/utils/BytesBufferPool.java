package com.tencent.component.network.utils;

import java.util.ArrayList;

/* loaded from: classes5.dex */
public class BytesBufferPool {
    private final int mBufferSize;
    private final ArrayList<BytesBuffer> mList;
    private final int mPoolSize;

    /* loaded from: classes5.dex */
    public static class BytesBuffer {
        public byte[] data;
        public int length;
        public int offset;

        BytesBuffer(int i3) {
            this.data = new byte[i3];
        }
    }

    public BytesBufferPool(int i3, int i16) {
        this.mList = new ArrayList<>(i3);
        this.mPoolSize = i3;
        this.mBufferSize = i16;
    }

    public synchronized void clear() {
        this.mList.clear();
    }

    public synchronized BytesBuffer get() {
        BytesBuffer bytesBuffer;
        int size = this.mList.size();
        if (size > 0) {
            bytesBuffer = this.mList.remove(size - 1);
        } else {
            bytesBuffer = new BytesBuffer(this.mBufferSize);
        }
        return bytesBuffer;
    }

    public synchronized void recycle(BytesBuffer bytesBuffer) {
        if (bytesBuffer.data.length != this.mBufferSize) {
            return;
        }
        if (this.mList.size() < this.mPoolSize) {
            bytesBuffer.offset = 0;
            bytesBuffer.length = 0;
            this.mList.add(bytesBuffer);
        }
    }
}
