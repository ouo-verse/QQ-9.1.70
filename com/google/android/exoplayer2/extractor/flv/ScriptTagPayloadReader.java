package com.google.android.exoplayer2.extractor.flv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/* loaded from: classes2.dex */
final class ScriptTagPayloadReader extends TagPayloadReader {
    private static final int AMF_TYPE_BOOLEAN = 1;
    private static final int AMF_TYPE_DATE = 11;
    private static final int AMF_TYPE_ECMA_ARRAY = 8;
    private static final int AMF_TYPE_END_MARKER = 9;
    private static final int AMF_TYPE_NUMBER = 0;
    private static final int AMF_TYPE_OBJECT = 3;
    private static final int AMF_TYPE_STRICT_ARRAY = 10;
    private static final int AMF_TYPE_STRING = 2;
    private static final String KEY_DURATION = "duration";
    private static final String NAME_METADATA = "onMetaData";
    private long durationUs;

    public ScriptTagPayloadReader() {
        super(null);
        this.durationUs = -9223372036854775807L;
    }

    private static Boolean readAmfBoolean(ParsableByteArray parsableByteArray) {
        boolean z16 = true;
        if (parsableByteArray.readUnsignedByte() != 1) {
            z16 = false;
        }
        return Boolean.valueOf(z16);
    }

    private static Object readAmfData(ParsableByteArray parsableByteArray, int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 8) {
                            if (i3 != 10) {
                                if (i3 != 11) {
                                    return null;
                                }
                                return readAmfDate(parsableByteArray);
                            }
                            return readAmfStrictArray(parsableByteArray);
                        }
                        return readAmfEcmaArray(parsableByteArray);
                    }
                    return readAmfObject(parsableByteArray);
                }
                return readAmfString(parsableByteArray);
            }
            return readAmfBoolean(parsableByteArray);
        }
        return readAmfDouble(parsableByteArray);
    }

    private static Date readAmfDate(ParsableByteArray parsableByteArray) {
        Date date = new Date((long) readAmfDouble(parsableByteArray).doubleValue());
        parsableByteArray.skipBytes(2);
        return date;
    }

    private static Double readAmfDouble(ParsableByteArray parsableByteArray) {
        return Double.valueOf(Double.longBitsToDouble(parsableByteArray.readLong()));
    }

    private static HashMap<String, Object> readAmfEcmaArray(ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        HashMap<String, Object> hashMap = new HashMap<>(readUnsignedIntToInt);
        for (int i3 = 0; i3 < readUnsignedIntToInt; i3++) {
            hashMap.put(readAmfString(parsableByteArray), readAmfData(parsableByteArray, readAmfType(parsableByteArray)));
        }
        return hashMap;
    }

    private static HashMap<String, Object> readAmfObject(ParsableByteArray parsableByteArray) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String readAmfString = readAmfString(parsableByteArray);
            int readAmfType = readAmfType(parsableByteArray);
            if (readAmfType == 9) {
                return hashMap;
            }
            hashMap.put(readAmfString, readAmfData(parsableByteArray, readAmfType));
        }
    }

    private static ArrayList<Object> readAmfStrictArray(ParsableByteArray parsableByteArray) {
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        ArrayList<Object> arrayList = new ArrayList<>(readUnsignedIntToInt);
        for (int i3 = 0; i3 < readUnsignedIntToInt; i3++) {
            arrayList.add(readAmfData(parsableByteArray, readAmfType(parsableByteArray)));
        }
        return arrayList;
    }

    private static String readAmfString(ParsableByteArray parsableByteArray) {
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(readUnsignedShort);
        return new String(parsableByteArray.data, position, readUnsignedShort);
    }

    private static int readAmfType(ParsableByteArray parsableByteArray) {
        return parsableByteArray.readUnsignedByte();
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected boolean parseHeader(ParsableByteArray parsableByteArray) {
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    protected void parsePayload(ParsableByteArray parsableByteArray, long j3) throws ParserException {
        if (readAmfType(parsableByteArray) == 2) {
            if (!NAME_METADATA.equals(readAmfString(parsableByteArray)) || readAmfType(parsableByteArray) != 8) {
                return;
            }
            HashMap<String, Object> readAmfEcmaArray = readAmfEcmaArray(parsableByteArray);
            if (readAmfEcmaArray.containsKey("duration")) {
                double doubleValue = ((Double) readAmfEcmaArray.get("duration")).doubleValue();
                if (doubleValue > 0.0d) {
                    this.durationUs = (long) (doubleValue * 1000000.0d);
                    return;
                }
                return;
            }
            return;
        }
        throw new ParserException();
    }

    @Override // com.google.android.exoplayer2.extractor.flv.TagPayloadReader
    public void seek() {
    }
}
