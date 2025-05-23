package com.google.android.exoplayer2.text.cea;

import android.util.Log;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class CeaUtil {
    private static final int COUNTRY_CODE = 181;
    private static final int PAYLOAD_TYPE_CC = 4;
    private static final int PROVIDER_CODE_ATSC = 49;
    private static final int PROVIDER_CODE_DIRECTV = 47;
    private static final String TAG = "CeaUtil";
    private static final int USER_DATA_TYPE_CODE = 3;
    private static final int USER_ID_GA94 = Util.getIntegerCodeForString("GA94");
    private static final int USER_ID_DTG1 = Util.getIntegerCodeForString("DTG1");

    CeaUtil() {
    }

    public static void consume(long j3, ParsableByteArray parsableByteArray, TrackOutput[] trackOutputArr) {
        int i3;
        boolean z16;
        boolean z17;
        while (parsableByteArray.bytesLeft() > 1) {
            int readNon255TerminatedValue = readNon255TerminatedValue(parsableByteArray);
            int readNon255TerminatedValue2 = readNon255TerminatedValue(parsableByteArray);
            int position = parsableByteArray.getPosition() + readNon255TerminatedValue2;
            if (readNon255TerminatedValue2 != -1 && readNon255TerminatedValue2 <= parsableByteArray.bytesLeft()) {
                if (readNon255TerminatedValue == 4 && readNon255TerminatedValue2 >= 8) {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    int readUnsignedShort = parsableByteArray.readUnsignedShort();
                    if (readUnsignedShort == 49) {
                        i3 = parsableByteArray.readInt();
                    } else {
                        i3 = 0;
                    }
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    if (readUnsignedShort == 47) {
                        parsableByteArray.skipBytes(1);
                    }
                    if (readUnsignedByte == 181 && ((readUnsignedShort == 49 || readUnsignedShort == 47) && readUnsignedByte2 == 3)) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (readUnsignedShort == 49) {
                        if (i3 != USER_ID_GA94 && i3 != USER_ID_DTG1) {
                            z17 = false;
                        } else {
                            z17 = true;
                        }
                        z16 &= z17;
                    }
                    if (z16) {
                        int readUnsignedByte3 = parsableByteArray.readUnsignedByte() & 31;
                        parsableByteArray.skipBytes(1);
                        int i16 = readUnsignedByte3 * 3;
                        int position2 = parsableByteArray.getPosition();
                        for (TrackOutput trackOutput : trackOutputArr) {
                            parsableByteArray.setPosition(position2);
                            trackOutput.sampleData(parsableByteArray, i16);
                            trackOutput.sampleMetadata(j3, 1, i16, 0, null);
                        }
                    }
                }
            } else {
                Log.w(TAG, "Skipping remainder of malformed SEI NAL unit.");
                position = parsableByteArray.limit();
            }
            parsableByteArray.setPosition(position);
        }
    }

    private static int readNon255TerminatedValue(ParsableByteArray parsableByteArray) {
        int i3 = 0;
        while (parsableByteArray.bytesLeft() != 0) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            i3 += readUnsignedByte;
            if (readUnsignedByte != 255) {
                return i3;
            }
        }
        return -1;
    }
}
