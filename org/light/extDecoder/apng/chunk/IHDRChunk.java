package org.light.extDecoder.apng.chunk;

/* compiled from: P */
/* loaded from: classes29.dex */
public class IHDRChunk extends Chunk {
    public static final int ID = Chunk.fourCCToInt("IHDR");
    public byte[] data = new byte[5];
    public int height;
    public int width;
}
