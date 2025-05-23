package org.light.extDecoder.apng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.light.extDecoder.apng.ApngWrapper;
import org.light.extDecoder.apng.chunk.ACTLChunk;
import org.light.extDecoder.apng.chunk.Chunk;
import org.light.extDecoder.apng.chunk.FCTLChunk;
import org.light.extDecoder.apng.chunk.FDATChunk;
import org.light.extDecoder.apng.chunk.IDATChunk;
import org.light.extDecoder.apng.chunk.IENDChunk;
import org.light.extDecoder.apng.chunk.IHDRChunk;
import org.light.extDecoder.apng.io.APNGReader;
import org.light.utils.LightLogUtil;

/* loaded from: classes29.dex */
public class ApngParser {
    private static final String TAG = "ApngParser";

    public static ApngWrapper parse(APNGReader aPNGReader) {
        try {
            ApngWrapper apngWrapper = new ApngWrapper();
            List<Chunk> parseFrame = parseFrame(aPNGReader);
            ArrayList arrayList = new ArrayList();
            boolean z16 = false;
            byte[] bArr = new byte[0];
            ArrayList arrayList2 = new ArrayList();
            ApngWrapper.ApngFrameResource apngFrameResource = null;
            for (Chunk chunk : parseFrame) {
                if (chunk instanceof ACTLChunk) {
                    apngWrapper.setLoopCount(((ACTLChunk) chunk).num_plays);
                    z16 = true;
                } else if (chunk instanceof FCTLChunk) {
                    apngFrameResource = new ApngWrapper.ApngFrameResource((FCTLChunk) chunk);
                    apngFrameResource.prefixChunks = arrayList;
                    apngFrameResource.ihdrData = bArr;
                    arrayList2.add(apngFrameResource);
                } else if (chunk instanceof FDATChunk) {
                    if (apngFrameResource != null) {
                        apngFrameResource.imageChunks.add(chunk);
                    }
                } else if (chunk instanceof IDATChunk) {
                    if (!z16) {
                        break;
                    }
                    if (apngFrameResource != null) {
                        apngFrameResource.imageChunks.add(chunk);
                    }
                } else if (chunk instanceof IHDRChunk) {
                    bArr = ((IHDRChunk) chunk).data;
                    apngWrapper.setWidth(((IHDRChunk) chunk).width);
                    apngWrapper.setHeight(((IHDRChunk) chunk).height);
                } else if (!(chunk instanceof IENDChunk)) {
                    arrayList.add(chunk);
                }
            }
            apngWrapper.setFrameList(arrayList2);
            return apngWrapper;
        } catch (IOException e16) {
            LightLogUtil.e(TAG, e16.getMessage(), e16);
            return null;
        }
    }

    public static Chunk parseACTLChunk(int i3, int i16, int i17, APNGReader aPNGReader) throws IOException {
        ACTLChunk aCTLChunk = new ACTLChunk();
        aCTLChunk.offset = i3;
        aCTLChunk.fourcc = i17;
        aCTLChunk.length = i16;
        int available = aPNGReader.available();
        aCTLChunk.num_frames = aPNGReader.readInt();
        aCTLChunk.num_plays = aPNGReader.readInt();
        int available2 = available - aPNGReader.available();
        if (available2 <= i16) {
            if (available2 < i16) {
                aPNGReader.skip(i16 - available2);
            }
            aCTLChunk.crc = aPNGReader.readInt();
            return aCTLChunk;
        }
        throw new IOException("Out of chunk area");
    }

    private static Chunk parseChunk(APNGReader aPNGReader) throws IOException {
        int position = aPNGReader.position();
        int readInt = aPNGReader.readInt();
        int readFourCC = aPNGReader.readFourCC();
        if (readFourCC == ACTLChunk.ID) {
            return parseACTLChunk(position, readInt, readFourCC, aPNGReader);
        }
        if (readFourCC == FCTLChunk.ID) {
            return parseFCTLChunk(position, readInt, readFourCC, aPNGReader);
        }
        if (readFourCC == FDATChunk.ID) {
            return parseFDATChunk(position, readInt, readFourCC, aPNGReader);
        }
        if (readFourCC == IDATChunk.ID) {
            return parseIDATChunk(position, readInt, readFourCC, aPNGReader);
        }
        if (readFourCC == IENDChunk.ID) {
            return parseIENDChunk(position, readInt, readFourCC, aPNGReader);
        }
        if (readFourCC == IHDRChunk.ID) {
            return parseIHDRChunk(position, readInt, readFourCC, aPNGReader);
        }
        return parseSimpleChunk(position, readInt, readFourCC, aPNGReader);
    }

    private static Chunk parseFCTLChunk(int i3, int i16, int i17, APNGReader aPNGReader) throws IOException {
        FCTLChunk fCTLChunk = new FCTLChunk();
        fCTLChunk.offset = i3;
        fCTLChunk.fourcc = i17;
        fCTLChunk.length = i16;
        int available = aPNGReader.available();
        fCTLChunk.sequence_number = aPNGReader.readInt();
        fCTLChunk.width = aPNGReader.readInt();
        fCTLChunk.height = aPNGReader.readInt();
        fCTLChunk.x_offset = aPNGReader.readInt();
        fCTLChunk.y_offset = aPNGReader.readInt();
        fCTLChunk.delay_num = aPNGReader.readShort();
        fCTLChunk.delay_den = aPNGReader.readShort();
        fCTLChunk.dispose_op = aPNGReader.peek();
        fCTLChunk.blend_op = aPNGReader.peek();
        int available2 = available - aPNGReader.available();
        if (available2 <= i16) {
            if (available2 < i16) {
                aPNGReader.skip(i16 - available2);
            }
            fCTLChunk.crc = aPNGReader.readInt();
            return fCTLChunk;
        }
        throw new IOException("Out of chunk area");
    }

    private static Chunk parseFDATChunk(int i3, int i16, int i17, APNGReader aPNGReader) throws IOException {
        FDATChunk fDATChunk = new FDATChunk();
        fDATChunk.offset = i3;
        fDATChunk.fourcc = i17;
        fDATChunk.length = i16;
        int available = aPNGReader.available();
        fDATChunk.sequence_number = aPNGReader.readInt();
        int available2 = available - aPNGReader.available();
        if (available2 <= i16) {
            if (available2 < i16) {
                aPNGReader.skip(i16 - available2);
            }
            fDATChunk.crc = aPNGReader.readInt();
            return fDATChunk;
        }
        throw new IOException("Out of chunk area");
    }

    public static List<Chunk> parseFrame(APNGReader aPNGReader) throws IOException {
        if (aPNGReader.matchFourCC("\u0089PNG") && aPNGReader.matchFourCC("\r\n\u001a\n")) {
            ArrayList arrayList = new ArrayList();
            while (aPNGReader.available() > 0) {
                arrayList.add(parseChunk(aPNGReader));
            }
            return arrayList;
        }
        throw new IOException();
    }

    private static Chunk parseIDATChunk(int i3, int i16, int i17, APNGReader aPNGReader) throws IOException {
        IDATChunk iDATChunk = new IDATChunk();
        iDATChunk.offset = i3;
        iDATChunk.fourcc = i17;
        iDATChunk.length = i16;
        int available = aPNGReader.available() - aPNGReader.available();
        if (available <= i16) {
            if (available < i16) {
                aPNGReader.skip(i16 - available);
            }
            iDATChunk.crc = aPNGReader.readInt();
            return iDATChunk;
        }
        throw new IOException("Out of chunk area");
    }

    private static Chunk parseIENDChunk(int i3, int i16, int i17, APNGReader aPNGReader) throws IOException {
        IENDChunk iENDChunk = new IENDChunk();
        iENDChunk.offset = i3;
        iENDChunk.fourcc = i17;
        iENDChunk.length = i16;
        int available = aPNGReader.available() - aPNGReader.available();
        if (available <= i16) {
            if (available < i16) {
                aPNGReader.skip(i16 - available);
            }
            iENDChunk.crc = aPNGReader.readInt();
            return iENDChunk;
        }
        throw new IOException("Out of chunk area");
    }

    private static Chunk parseIHDRChunk(int i3, int i16, int i17, APNGReader aPNGReader) throws IOException {
        IHDRChunk iHDRChunk = new IHDRChunk();
        iHDRChunk.offset = i3;
        iHDRChunk.fourcc = i17;
        iHDRChunk.length = i16;
        int available = aPNGReader.available();
        iHDRChunk.width = aPNGReader.readInt();
        iHDRChunk.height = aPNGReader.readInt();
        byte[] bArr = iHDRChunk.data;
        aPNGReader.read(bArr, 0, bArr.length);
        int available2 = available - aPNGReader.available();
        if (available2 <= i16) {
            if (available2 < i16) {
                aPNGReader.skip(i16 - available2);
            }
            iHDRChunk.crc = aPNGReader.readInt();
            return iHDRChunk;
        }
        throw new IOException("Out of chunk area");
    }

    private static Chunk parseSimpleChunk(int i3, int i16, int i17, APNGReader aPNGReader) throws IOException {
        Chunk chunk = new Chunk();
        chunk.offset = i3;
        chunk.fourcc = i17;
        chunk.length = i16;
        int available = aPNGReader.available() - aPNGReader.available();
        if (available <= i16) {
            if (available < i16) {
                aPNGReader.skip(i16 - available);
            }
            chunk.crc = aPNGReader.readInt();
            return chunk;
        }
        throw new IOException("Out of chunk area");
    }
}
