package com.google.android.exoplayer2.extractor.wav;

import android.util.Log;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes2.dex */
final class WavHeaderReader {
    private static final String TAG = "WavHeaderReader";
    private static final int TYPE_FLOAT = 3;
    private static final int TYPE_PCM = 1;
    private static final int TYPE_WAVE_FORMAT_EXTENSIBLE = 65534;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static final class ChunkHeader {
        public static final int SIZE_IN_BYTES = 8;

        /* renamed from: id, reason: collision with root package name */
        public final int f32943id;
        public final long size;

        ChunkHeader(int i3, long j3) {
            this.f32943id = i3;
            this.size = j3;
        }

        public static ChunkHeader peek(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws IOException, InterruptedException {
            extractorInput.peekFully(parsableByteArray.data, 0, 8);
            parsableByteArray.setPosition(0);
            return new ChunkHeader(parsableByteArray.readInt(), parsableByteArray.readLittleEndianUnsignedInt());
        }
    }

    WavHeaderReader() {
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static WavHeader peek(ExtractorInput extractorInput) throws IOException, InterruptedException {
        boolean z16;
        int pcmEncoding;
        Assertions.checkNotNull(extractorInput);
        ParsableByteArray parsableByteArray = new ParsableByteArray(16);
        if (ChunkHeader.peek(extractorInput, parsableByteArray).f32943id != Util.getIntegerCodeForString("RIFF")) {
            return null;
        }
        int i3 = 0;
        extractorInput.peekFully(parsableByteArray.data, 0, 4);
        parsableByteArray.setPosition(0);
        int readInt = parsableByteArray.readInt();
        if (readInt != Util.getIntegerCodeForString("WAVE")) {
            Log.e(TAG, "Unsupported RIFF format: " + readInt);
            return null;
        }
        ChunkHeader peek = ChunkHeader.peek(extractorInput, parsableByteArray);
        while (peek.f32943id != Util.getIntegerCodeForString("fmt ")) {
            extractorInput.advancePeekPosition((int) peek.size);
            peek = ChunkHeader.peek(extractorInput, parsableByteArray);
        }
        if (peek.size >= 16) {
            z16 = true;
        } else {
            z16 = false;
        }
        Assertions.checkState(z16);
        extractorInput.peekFully(parsableByteArray.data, 0, 16);
        parsableByteArray.setPosition(0);
        int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedShort2 = parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedIntToInt = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readLittleEndianUnsignedIntToInt2 = parsableByteArray.readLittleEndianUnsignedIntToInt();
        int readLittleEndianUnsignedShort3 = parsableByteArray.readLittleEndianUnsignedShort();
        int readLittleEndianUnsignedShort4 = parsableByteArray.readLittleEndianUnsignedShort();
        int i16 = (readLittleEndianUnsignedShort2 * readLittleEndianUnsignedShort4) / 8;
        if (readLittleEndianUnsignedShort3 == i16) {
            if (readLittleEndianUnsignedShort != 1) {
                if (readLittleEndianUnsignedShort != 3) {
                    if (readLittleEndianUnsignedShort != 65534) {
                        Log.e(TAG, "Unsupported WAV format type: " + readLittleEndianUnsignedShort);
                        return null;
                    }
                } else {
                    if (readLittleEndianUnsignedShort4 == 32) {
                        i3 = 4;
                    }
                    pcmEncoding = i3;
                    if (pcmEncoding != 0) {
                        Log.e(TAG, "Unsupported WAV bit depth " + readLittleEndianUnsignedShort4 + " for type " + readLittleEndianUnsignedShort);
                        return null;
                    }
                    extractorInput.advancePeekPosition(((int) peek.size) - 16);
                    return new WavHeader(readLittleEndianUnsignedShort2, readLittleEndianUnsignedIntToInt, readLittleEndianUnsignedIntToInt2, readLittleEndianUnsignedShort3, readLittleEndianUnsignedShort4, pcmEncoding);
                }
            }
            pcmEncoding = Util.getPcmEncoding(readLittleEndianUnsignedShort4);
            if (pcmEncoding != 0) {
            }
        } else {
            throw new ParserException("Expected block alignment: " + i16 + "; got: " + readLittleEndianUnsignedShort3);
        }
    }

    public static void skipToData(ExtractorInput extractorInput, WavHeader wavHeader) throws IOException, InterruptedException {
        Assertions.checkNotNull(extractorInput);
        Assertions.checkNotNull(wavHeader);
        extractorInput.resetPeekPosition();
        ParsableByteArray parsableByteArray = new ParsableByteArray(8);
        ChunkHeader peek = ChunkHeader.peek(extractorInput, parsableByteArray);
        while (peek.f32943id != Util.getIntegerCodeForString("data")) {
            Log.w(TAG, "Ignoring unknown WAV chunk: " + peek.f32943id);
            long j3 = peek.size + 8;
            if (peek.f32943id == Util.getIntegerCodeForString("RIFF")) {
                j3 = 12;
            }
            if (j3 <= TTL.MAX_VALUE) {
                extractorInput.skipFully((int) j3);
                peek = ChunkHeader.peek(extractorInput, parsableByteArray);
            } else {
                throw new ParserException("Chunk is too large (~2GB+) to skip; id: " + peek.f32943id);
            }
        }
        extractorInput.skipFully(8);
        wavHeader.setDataBounds(extractorInput.getPosition(), peek.size);
    }
}
