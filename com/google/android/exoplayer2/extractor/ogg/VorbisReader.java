package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.extractor.ogg.VorbisUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes2.dex */
final class VorbisReader extends StreamReader {
    private VorbisUtil.CommentHeader commentHeader;
    private int previousPacketBlockSize;
    private boolean seenFirstAudioPacket;
    private VorbisUtil.VorbisIdHeader vorbisIdHeader;
    private VorbisSetup vorbisSetup;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class VorbisSetup {
        public final VorbisUtil.CommentHeader commentHeader;
        public final int iLogModes;
        public final VorbisUtil.VorbisIdHeader idHeader;
        public final VorbisUtil.Mode[] modes;
        public final byte[] setupHeaderData;

        public VorbisSetup(VorbisUtil.VorbisIdHeader vorbisIdHeader, VorbisUtil.CommentHeader commentHeader, byte[] bArr, VorbisUtil.Mode[] modeArr, int i3) {
            this.idHeader = vorbisIdHeader;
            this.commentHeader = commentHeader;
            this.setupHeaderData = bArr;
            this.modes = modeArr;
            this.iLogModes = i3;
        }
    }

    static void appendNumberOfSamples(ParsableByteArray parsableByteArray, long j3) {
        parsableByteArray.setLimit(parsableByteArray.limit() + 4);
        parsableByteArray.data[parsableByteArray.limit() - 4] = (byte) (j3 & 255);
        parsableByteArray.data[parsableByteArray.limit() - 3] = (byte) ((j3 >>> 8) & 255);
        parsableByteArray.data[parsableByteArray.limit() - 2] = (byte) ((j3 >>> 16) & 255);
        parsableByteArray.data[parsableByteArray.limit() - 1] = (byte) ((j3 >>> 24) & 255);
    }

    private static int decodeBlockSize(byte b16, VorbisSetup vorbisSetup) {
        if (!vorbisSetup.modes[readBits(b16, vorbisSetup.iLogModes, 1)].blockFlag) {
            return vorbisSetup.idHeader.blockSize0;
        }
        return vorbisSetup.idHeader.blockSize1;
    }

    static int readBits(byte b16, int i3, int i16) {
        return (b16 >> i16) & (255 >>> (8 - i3));
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        try {
            return VorbisUtil.verifyVorbisHeaderCapturePattern(1, parsableByteArray, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void onSeekEnd(long j3) {
        boolean z16;
        super.onSeekEnd(j3);
        int i3 = 0;
        if (j3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.seenFirstAudioPacket = z16;
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.vorbisIdHeader;
        if (vorbisIdHeader != null) {
            i3 = vorbisIdHeader.blockSize0;
        }
        this.previousPacketBlockSize = i3;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected long preparePayload(ParsableByteArray parsableByteArray) {
        int i3 = 0;
        byte b16 = parsableByteArray.data[0];
        if ((b16 & 1) == 1) {
            return -1L;
        }
        int decodeBlockSize = decodeBlockSize(b16, this.vorbisSetup);
        if (this.seenFirstAudioPacket) {
            i3 = (this.previousPacketBlockSize + decodeBlockSize) / 4;
        }
        long j3 = i3;
        appendNumberOfSamples(parsableByteArray, j3);
        this.seenFirstAudioPacket = true;
        this.previousPacketBlockSize = decodeBlockSize;
        return j3;
    }

    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    protected boolean readHeaders(ParsableByteArray parsableByteArray, long j3, StreamReader.SetupData setupData) throws IOException, InterruptedException {
        if (this.vorbisSetup != null) {
            return false;
        }
        VorbisSetup readSetupHeaders = readSetupHeaders(parsableByteArray);
        this.vorbisSetup = readSetupHeaders;
        if (readSetupHeaders == null) {
            return true;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.vorbisSetup.idHeader.data);
        arrayList.add(this.vorbisSetup.setupHeaderData);
        VorbisUtil.VorbisIdHeader vorbisIdHeader = this.vorbisSetup.idHeader;
        setupData.format = Format.createAudioSampleFormat(null, "audio/vorbis", null, vorbisIdHeader.bitrateNominal, -1, vorbisIdHeader.channels, (int) vorbisIdHeader.sampleRate, arrayList, null, 0, null);
        return true;
    }

    VorbisSetup readSetupHeaders(ParsableByteArray parsableByteArray) throws IOException {
        if (this.vorbisIdHeader == null) {
            this.vorbisIdHeader = VorbisUtil.readVorbisIdentificationHeader(parsableByteArray);
            return null;
        }
        if (this.commentHeader == null) {
            this.commentHeader = VorbisUtil.readVorbisCommentHeader(parsableByteArray);
            return null;
        }
        byte[] bArr = new byte[parsableByteArray.limit()];
        System.arraycopy(parsableByteArray.data, 0, bArr, 0, parsableByteArray.limit());
        return new VorbisSetup(this.vorbisIdHeader, this.commentHeader, bArr, VorbisUtil.readVorbisModes(parsableByteArray, this.vorbisIdHeader.channels), VorbisUtil.iLog(r5.length - 1));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.extractor.ogg.StreamReader
    public void reset(boolean z16) {
        super.reset(z16);
        if (z16) {
            this.vorbisSetup = null;
            this.vorbisIdHeader = null;
            this.commentHeader = null;
        }
        this.previousPacketBlockSize = 0;
        this.seenFirstAudioPacket = false;
    }
}
