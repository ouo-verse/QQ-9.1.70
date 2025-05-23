package com.tencent.qqmusic.mediaplayer.seektable.flac;

import com.tencent.qqmusic.mediaplayer.seektable.InvalidBoxException;
import com.tencent.qqmusic.mediaplayer.seektable.Parsable;
import com.tencent.qqmusic.mediaplayer.seektable.ParsableInputStreamWrapper;
import com.tencent.qqmusic.mediaplayer.seektable.SeekTable;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: P */
/* loaded from: classes23.dex */
public class FlacSeekTable implements SeekTable {
    private static final int SEEK_POINT_SIZE = 18;
    private static final byte TYPE_SEEKTABLE = 3;
    private static final byte TYPE_STREAMINFO = 0;
    private long firstFrameOffset;
    private long[] offsets;
    private long[] sampleNumbers;
    private int sampleRate;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface BlockHandler {
        boolean handle(Parsable parsable, int i3) throws IOException, InvalidBoxException;
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class SeektableHandler implements BlockHandler {
        public SeektableHandler() {
        }

        @Override // com.tencent.qqmusic.mediaplayer.seektable.flac.FlacSeekTable.BlockHandler
        public boolean handle(Parsable parsable, int i3) throws IOException, InvalidBoxException {
            if (i3 != 3) {
                return false;
            }
            byte[] bArr = new byte[3];
            parsable.readBytes(bArr, 0, 3);
            int from = BytesUtil.from(bArr) / 18;
            FlacSeekTable.this.sampleNumbers = new long[from];
            FlacSeekTable.this.offsets = new long[from];
            for (int i16 = 0; i16 < from; i16++) {
                FlacSeekTable.this.sampleNumbers[i16] = parsable.readLong();
                FlacSeekTable.this.offsets[i16] = parsable.readLong();
                parsable.skip(2L);
            }
            if (FlacSeekTable.seekToFirstFrame(parsable)) {
                FlacSeekTable.this.firstFrameOffset = parsable.tell() - 2;
                return true;
            }
            throw new InvalidBoxException("can't find audio frame!");
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public class StreamInfoHandler implements BlockHandler {
        public StreamInfoHandler() {
        }

        @Override // com.tencent.qqmusic.mediaplayer.seektable.flac.FlacSeekTable.BlockHandler
        public boolean handle(Parsable parsable, int i3) throws IOException, InvalidBoxException {
            if (i3 != 0) {
                return false;
            }
            parsable.skip(13L);
            parsable.readBytes(new byte[3], 0, 3);
            parsable.skip(21L);
            return true;
        }
    }

    public FlacSeekTable(int i3) {
        this.sampleRate = i3;
    }

    private static int binarySearchFloor(long[] jArr, long j3, boolean z16, boolean z17) {
        int binarySearch = Arrays.binarySearch(jArr, j3);
        if (binarySearch < 0) {
            binarySearch = -(binarySearch + 2);
        } else if (!z16) {
            binarySearch--;
        }
        if (z17) {
            return Math.max(0, binarySearch);
        }
        return binarySearch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean seekToFirstFrame(Parsable parsable) throws IOException {
        byte[] bArr = new byte[1];
        byte[] bArr2 = new byte[3];
        boolean z16 = false;
        while (true) {
            if (parsable.available() <= 0) {
                break;
            }
            if (z16) {
                byte[] bArr3 = new byte[2];
                parsable.readBytes(bArr3, 0, 2);
                if ((bArr3[0] & 255) == 255 && ((bArr3[1] & 255) >> 2) == 62) {
                    return true;
                }
            } else {
                parsable.readBytes(bArr, 0, 1);
                if (((255 & bArr[0]) >> 7) == 1) {
                    z16 = true;
                }
                parsable.readBytes(bArr2, 0, 3);
                parsable.skip(BytesUtil.from(bArr2));
            }
        }
        return false;
    }

    private static boolean seekToFlac(Parsable parsable) throws IOException {
        byte[] bArr = new byte[4];
        parsable.readBytes(bArr, 0, 4);
        if (bArr[0] == 73 && bArr[1] == 68 && bArr[2] == 51) {
            parsable.skip(2L);
            parsable.skip(Id3Util.unsynchsafe(parsable.readInt()));
            parsable.readBytes(bArr, 0, 4);
        }
        if (bArr[0] != 102 || bArr[1] != 76 || bArr[2] != 97 || bArr[3] != 67) {
            return false;
        }
        return true;
    }

    private static boolean walkThrough(Parsable parsable, BlockHandler... blockHandlerArr) throws IOException, InvalidBoxException {
        byte[] bArr = new byte[1];
        byte[] bArr2 = new byte[3];
        HashSet hashSet = new HashSet();
        while (hashSet.size() < blockHandlerArr.length && parsable.available() > 0) {
            parsable.readBytes(bArr, 0, 1);
            int i3 = bArr[0] & Byte.MAX_VALUE;
            int length = blockHandlerArr.length;
            int i16 = 0;
            boolean z16 = false;
            while (true) {
                if (i16 >= length) {
                    break;
                }
                BlockHandler blockHandler = blockHandlerArr[i16];
                boolean handle = blockHandler.handle(parsable, i3);
                if (handle) {
                    hashSet.add(Integer.valueOf(blockHandler.hashCode()));
                    z16 = handle;
                    break;
                }
                i16++;
                z16 = handle;
            }
            if (!z16) {
                if (((bArr[0] & 255) >> 7) == 1) {
                    break;
                }
                parsable.readBytes(bArr2, 0, 3);
                parsable.skip(BytesUtil.from(bArr2));
            }
        }
        if (hashSet.size() == blockHandlerArr.length) {
            return true;
        }
        return false;
    }

    public long[] getOffsetRangeOfSample(int i3) {
        int binarySearchFloor = binarySearchFloor(this.sampleNumbers, i3, true, true);
        int i16 = binarySearchFloor + 1;
        long[] jArr = this.offsets;
        if (i16 >= jArr.length) {
            return new long[]{this.firstFrameOffset + jArr[binarySearchFloor], -1};
        }
        long j3 = this.firstFrameOffset;
        return new long[]{jArr[binarySearchFloor] + j3, j3 + jArr[i16]};
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public void parse(IDataSource iDataSource) throws IOException, InvalidBoxException {
        BlockHandler[] blockHandlerArr;
        ParsableInputStreamWrapper parsableInputStreamWrapper = new ParsableInputStreamWrapper(iDataSource);
        if (!seekToFlac(parsableInputStreamWrapper)) {
            return;
        }
        if (this.sampleRate == 0) {
            blockHandlerArr = new BlockHandler[]{new SeektableHandler(), new StreamInfoHandler()};
        } else {
            blockHandlerArr = new BlockHandler[]{new SeektableHandler()};
        }
        if (walkThrough(parsableInputStreamWrapper, blockHandlerArr)) {
        } else {
            throw new InvalidBoxException("lack one or more critical BLOCK(s) to create seek table!");
        }
    }

    @Override // com.tencent.qqmusic.mediaplayer.seektable.SeekTable
    public long seek(long j3) {
        return this.firstFrameOffset + this.offsets[binarySearchFloor(this.sampleNumbers, (int) (Math.round(j3 / 1000.0d) * this.sampleRate), true, true)];
    }
}
