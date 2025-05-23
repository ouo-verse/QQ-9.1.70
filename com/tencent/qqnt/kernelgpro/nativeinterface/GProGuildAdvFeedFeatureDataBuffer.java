package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildAdvFeedFeatureDataBuffer {
    public String compressAlgorithm = "";
    public byte[] data = new byte[0];
    public long decompressedSize;

    public String getCompressAlgorithm() {
        return this.compressAlgorithm;
    }

    public byte[] getData() {
        return this.data;
    }

    public long getDecompressedSize() {
        return this.decompressedSize;
    }

    public String toString() {
        return "GProGuildAdvFeedFeatureDataBuffer{compressAlgorithm=" + this.compressAlgorithm + ",decompressedSize=" + this.decompressedSize + ",data=" + this.data + ",}";
    }
}
