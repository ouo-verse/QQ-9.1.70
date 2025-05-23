package com.tencent.qqmusic.mediaplayer.seektable.mpeg4;

import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import com.tencent.qqmusic.mediaplayer.seektable.ParsableInputStreamWrapper;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Co64;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.GhostBox;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.IMpeg4Box;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Mdhd;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stco;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stsc;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stsz;
import com.tencent.qqmusic.mediaplayer.seektable.mpeg4.boxes.Stts;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.StringTokenizer;

/* compiled from: P */
/* loaded from: classes23.dex */
public class Mp4SeekTable implements SeekTable {
    private final Map<String, IMpeg4Box> essentialStblChunkMap;
    private final Mdhd mdhd;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface Function1<T, R> {
        R call(T t16);
    }

    public Mp4SeekTable() {
        HashMap hashMap = new HashMap();
        this.essentialStblChunkMap = hashMap;
        hashMap.put("stco", new Stco());
        hashMap.put("co64", new Co64());
        hashMap.put("stts", new Stts());
        hashMap.put("stsc", new Stsc());
        hashMap.put("stsz", new Stsz());
        this.mdhd = new Mdhd();
    }

    private static void chunkOfSample(Stsc stsc, int i3, int[] iArr) {
        boolean z16;
        int i16;
        int entryCount = stsc.getEntryCount();
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i26 = 1;
        while (true) {
            int i27 = stsc.getFirstChunk()[i18];
            int i28 = ((i27 - i26) * i19) + i17;
            if (i3 < i28) {
                z16 = true;
                break;
            }
            i19 = stsc.getSamplesPerChunk()[i18];
            if (i18 < entryCount) {
                i18++;
                i17 = i28;
            }
            if (i18 >= entryCount) {
                z16 = false;
                i26 = i27;
                break;
            }
            i26 = i27;
        }
        if (i19 != 0) {
            if (z16) {
                i16 = ((i3 - i17) / i19) + i26;
            } else {
                i16 = i26;
            }
        } else {
            i16 = 1;
        }
        iArr[0] = i16;
        iArr[1] = i17 + ((i16 - i26) * i19);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean needMoreChunks(HashSet<String> hashSet) {
        if (hashSet.size() > 2) {
            return true;
        }
        if (hashSet.contains("stco") && hashSet.contains("co64")) {
            return true;
        }
        return false;
    }

    private static long offset64OfChunk(Co64 co64, int i3) {
        if (i3 > co64.getEntryCount()) {
            return co64.getChunkOffset()[co64.getEntryCount() - 1];
        }
        if (co64.getEntryCount() > 0) {
            return co64.getChunkOffset()[i3 - 1];
        }
        return 8L;
    }

    private static int offsetOfChunk(Stco stco, int i3) {
        if (i3 > stco.getEntryCount()) {
            return stco.getChunkOffset()[stco.getEntryCount() - 1];
        }
        if (stco.getEntryCount() > 0) {
            return stco.getChunkOffset()[i3 - 1];
        }
        return 8;
    }

    private static int offsetOfSampleInChunk(Stsz stsz, int i3, int i16) {
        if (stsz.getSampleSize() != 0) {
            return (i3 - i16) * stsz.getSampleSize();
        }
        int min = Math.min(i3, stsz.getSampleCount());
        int i17 = 0;
        while (i16 < min) {
            i17 += stsz.getEntrySize()[i16];
            i16++;
        }
        return i17;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0065, code lost:
    
        throw new com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException("invalid box: critical box not found!");
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x005a, code lost:
    
        if (r8.call(r1).booleanValue() != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void parseChunks(Parsable parsable, Map<String, IMpeg4Box> map, Function1<HashSet<String>, Boolean> function1) throws IOException, InvalidBoxException {
        GhostBox ghostBox = new GhostBox();
        HashSet<String> hashSet = new HashSet<>(map.keySet());
        while (true) {
            if ((function1 == null || function1.call(hashSet).booleanValue()) && hashSet.size() != 0 && parsable.available() > 0) {
                ghostBox.parse(parsable, null);
                String type = ghostBox.getType();
                IMpeg4Box iMpeg4Box = map.get(type);
                if (iMpeg4Box == null) {
                    parsable.skip(ghostBox.getSize() - 8);
                } else {
                    iMpeg4Box.parse(parsable, ghostBox);
                    hashSet.remove(type);
                }
            }
        }
    }

    private static int sampleOfTime(Stts stts, int i3) {
        int entryCount = stts.getEntryCount();
        boolean z16 = false;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            if (i16 >= entryCount) {
                break;
            }
            i18 = stts.getSampleDelta()[i16];
            int i19 = stts.getSampleCount()[i16];
            int i26 = i19 * i18;
            if (i3 < i26) {
                z16 = true;
                break;
            }
            i3 -= i26;
            i17 += i19;
            i16++;
        }
        if (z16) {
            return i17 + (i3 / i18);
        }
        return i17;
    }

    private long seekInternal(int i3) {
        long offset64OfChunk;
        int[] iArr = new int[2];
        chunkOfSample((Stsc) this.essentialStblChunkMap.get("stsc"), sampleOfTime((Stts) this.essentialStblChunkMap.get("stts"), i3), iArr);
        int i16 = iArr[0];
        int i17 = iArr[1];
        if (this.essentialStblChunkMap.get("stco").getSize() != 0) {
            offset64OfChunk = offsetOfChunk((Stco) this.essentialStblChunkMap.get("stco"), i16);
        } else if (this.essentialStblChunkMap.get("co64").getSize() != 0) {
            offset64OfChunk = offset64OfChunk((Co64) this.essentialStblChunkMap.get("co64"), i16);
        } else {
            throw new RuntimeException("invalid stbl: both [stco] nor [co64] was found!");
        }
        return offset64OfChunk + offsetOfSampleInChunk((Stsz) this.essentialStblChunkMap.get("stsz"), r9, i17);
    }

    private static IMpeg4Box seekTo(Parsable parsable, String str) throws IOException, InvalidBoxException {
        GhostBox ghostBox = new GhostBox();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
        GhostBox ghostBox2 = null;
        while (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            boolean z16 = false;
            while (true) {
                if (!z16 && parsable.available() > 0) {
                    ghostBox.parse(parsable, null);
                    if (!nextToken.equalsIgnoreCase(ghostBox.getType())) {
                        parsable.skip(ghostBox.getSize() - 8);
                    } else {
                        if (!stringTokenizer.hasMoreTokens()) {
                            ghostBox2 = ghostBox;
                            break;
                        }
                        z16 = true;
                    }
                }
            }
        }
        return ghostBox2;
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public void parse(IDataSource iDataSource) throws IOException, InvalidBoxException {
        ParsableInputStreamWrapper parsableInputStreamWrapper = new ParsableInputStreamWrapper(iDataSource);
        if (seekTo(parsableInputStreamWrapper, "moov.trak.mdia") != null) {
            HashMap hashMap = new HashMap(2);
            hashMap.put("mdhd", this.mdhd);
            hashMap.put("minf", new GhostBox());
            parseChunks(parsableInputStreamWrapper, hashMap, null);
            if (seekTo(parsableInputStreamWrapper, "stbl") != null) {
                parseChunks(parsableInputStreamWrapper, this.essentialStblChunkMap, new Function1<HashSet<String>, Boolean>() { // from class: com.tencent.qqmusic.mediaplayer.seektable.mpeg4.Mp4SeekTable.1
                    @Override // com.tencent.qqmusic.mediaplayer.seektable.mpeg4.Mp4SeekTable.Function1
                    public Boolean call(HashSet<String> hashSet) {
                        return Boolean.valueOf(Mp4SeekTable.needMoreChunks(hashSet));
                    }
                });
                return;
            }
            throw new InvalidBoxException("invalid mp4: no [stbl] was found!");
        }
        throw new InvalidBoxException("invalid mp4: no [mdia] was found!");
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public long seek(long j3) {
        return seekInternal((int) Math.round((this.mdhd.getTimeScale() * j3) / 1000.0d));
    }
}
