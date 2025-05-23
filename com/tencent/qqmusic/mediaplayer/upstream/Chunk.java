package com.tencent.qqmusic.mediaplayer.upstream;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Chunk {
    public final int bufferSize;
    public final long size;
    public final long start;

    public Chunk(int i3, long j3, long j16) {
        this.bufferSize = i3;
        this.start = j3;
        this.size = j16;
    }

    public boolean contains(long j3) {
        if (isEndless()) {
            if (j3 >= this.start) {
                return true;
            }
            return false;
        }
        long j16 = this.start;
        if (j3 >= j16 && j3 <= j16 + this.size) {
            return true;
        }
        return false;
    }

    public boolean isEndless() {
        if (this.size == -1) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "Chunk{bufferSize=" + this.bufferSize + ", start=" + this.start + ", size=" + this.size + '}';
    }
}
