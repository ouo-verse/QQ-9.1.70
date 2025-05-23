package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class HevcConfig {
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;

    HevcConfig(List<byte[]> list, int i3) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i3;
    }

    public static HevcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        List singletonList;
        try {
            parsableByteArray.skipBytes(21);
            int readUnsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i3 = 0;
            for (int i16 = 0; i16 < readUnsignedByte2; i16++) {
                parsableByteArray.skipBytes(1);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                for (int i17 = 0; i17 < readUnsignedShort; i17++) {
                    int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                    i3 += readUnsignedShort2 + 4;
                    parsableByteArray.skipBytes(readUnsignedShort2);
                }
            }
            parsableByteArray.setPosition(position);
            byte[] bArr = new byte[i3];
            int i18 = 0;
            for (int i19 = 0; i19 < readUnsignedByte2; i19++) {
                parsableByteArray.skipBytes(1);
                int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
                for (int i26 = 0; i26 < readUnsignedShort3; i26++) {
                    int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                    byte[] bArr2 = NalUnitUtil.NAL_START_CODE;
                    System.arraycopy(bArr2, 0, bArr, i18, bArr2.length);
                    int length = i18 + bArr2.length;
                    System.arraycopy(parsableByteArray.data, parsableByteArray.getPosition(), bArr, length, readUnsignedShort4);
                    i18 = length + readUnsignedShort4;
                    parsableByteArray.skipBytes(readUnsignedShort4);
                }
            }
            if (i3 == 0) {
                singletonList = null;
            } else {
                singletonList = Collections.singletonList(bArr);
            }
            return new HevcConfig(singletonList, readUnsignedByte + 1);
        } catch (ArrayIndexOutOfBoundsException e16) {
            throw new ParserException("Error parsing HEVC config", e16);
        }
    }
}
