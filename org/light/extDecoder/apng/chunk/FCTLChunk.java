package org.light.extDecoder.apng.chunk;

/* compiled from: P */
/* loaded from: classes29.dex */
public class FCTLChunk extends Chunk {
    public static final int APNG_BLEND_OP_OVER = 1;
    public static final int APNG_BLEND_OP_SOURCE = 0;
    public static final int APNG_DISPOSE_OP_BACKGROUND = 1;
    public static final int APNG_DISPOSE_OP_NON = 0;
    public static final int APNG_DISPOSE_OP_PREVIOUS = 2;
    public static final int ID = Chunk.fourCCToInt("fcTL");
    public byte blend_op;
    public short delay_den;
    public short delay_num;
    public byte dispose_op;
    public int height;
    public int sequence_number;
    public int width;
    public int x_offset;
    public int y_offset;
}
