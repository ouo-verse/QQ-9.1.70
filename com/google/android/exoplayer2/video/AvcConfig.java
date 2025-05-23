package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class AvcConfig {
    public final int height;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthAspectRatio;
    public final int width;

    AvcConfig(List<byte[]> list, int i3, int i16, int i17, float f16) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i3;
        this.width = i16;
        this.height = i17;
        this.pixelWidthAspectRatio = f16;
    }

    private static byte[] buildNalUnitForChild(ParsableByteArray parsableByteArray) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(readUnsignedShort);
        return CodecSpecificDataUtil.buildNalUnit(parsableByteArray.data, position, readUnsignedShort);
    }

    public static AvcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        int i3;
        int i16;
        float f16;
        try {
            parsableByteArray.skipBytes(4);
            int readUnsignedByte = (parsableByteArray.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte != 3) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i17 = 0; i17 < readUnsignedByte2; i17++) {
                    arrayList.add(buildNalUnitForChild(parsableByteArray));
                }
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                for (int i18 = 0; i18 < readUnsignedByte3; i18++) {
                    arrayList.add(buildNalUnitForChild(parsableByteArray));
                }
                if (readUnsignedByte2 > 0) {
                    NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                    int i19 = parseSpsNalUnit.width;
                    int i26 = parseSpsNalUnit.height;
                    f16 = parseSpsNalUnit.pixelWidthAspectRatio;
                    i3 = i19;
                    i16 = i26;
                } else {
                    i3 = -1;
                    i16 = -1;
                    f16 = 1.0f;
                }
                return new AvcConfig(arrayList, readUnsignedByte, i3, i16, f16);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e16) {
            throw new ParserException("Error parsing AVC config", e16);
        }
    }
}
