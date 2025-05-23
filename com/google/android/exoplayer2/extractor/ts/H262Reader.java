package com.google.android.exoplayer2.extractor.ts;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import java.util.Arrays;
import java.util.Collections;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class H262Reader implements ElementaryStreamReader {
    private static final double[] FRAME_RATE_VALUES = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private static final int START_EXTENSION = 181;
    private static final int START_GROUP = 184;
    private static final int START_PICTURE = 0;
    private static final int START_SEQUENCE_HEADER = 179;
    private String formatId;
    private long frameDurationUs;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private boolean sampleHasPicture;
    private boolean sampleIsKeyframe;
    private long samplePosition;
    private long sampleTimeUs;
    private boolean startedFirstSample;
    private long totalBytesWritten;
    private final boolean[] prefixFlags = new boolean[4];
    private final CsdBuffer csdBuffer = new CsdBuffer(128);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class CsdBuffer {
        private static final byte[] START_CODE = {0, 0, 1};
        public byte[] data;
        private boolean isFilling;
        public int length;
        public int sequenceExtensionPosition;

        public CsdBuffer(int i3) {
            this.data = new byte[i3];
        }

        public void onData(byte[] bArr, int i3, int i16) {
            if (!this.isFilling) {
                return;
            }
            int i17 = i16 - i3;
            byte[] bArr2 = this.data;
            int length = bArr2.length;
            int i18 = this.length;
            if (length < i18 + i17) {
                this.data = Arrays.copyOf(bArr2, (i18 + i17) * 2);
            }
            System.arraycopy(bArr, i3, this.data, this.length, i17);
            this.length += i17;
        }

        public boolean onStartCode(int i3, int i16) {
            if (this.isFilling) {
                int i17 = this.length - i16;
                this.length = i17;
                if (this.sequenceExtensionPosition == 0 && i3 == 181) {
                    this.sequenceExtensionPosition = i17;
                } else {
                    this.isFilling = false;
                    return true;
                }
            } else if (i3 == 179) {
                this.isFilling = true;
            }
            byte[] bArr = START_CODE;
            onData(bArr, 0, bArr.length);
            return false;
        }

        public void reset() {
            this.isFilling = false;
            this.length = 0;
            this.sequenceExtensionPosition = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pair<Format, Long> parseCsdBuffer(CsdBuffer csdBuffer, String str) {
        float f16;
        int i3;
        float f17;
        int i16;
        long j3;
        byte[] copyOf = Arrays.copyOf(csdBuffer.data, csdBuffer.length);
        int i17 = copyOf[4] & 255;
        int i18 = copyOf[5] & 255;
        int i19 = (i17 << 4) | (i18 >> 4);
        int i26 = ((i18 & 15) << 8) | (copyOf[6] & 255);
        int i27 = (copyOf[7] & 240) >> 4;
        if (i27 != 2) {
            if (i27 != 3) {
                if (i27 != 4) {
                    f17 = 1.0f;
                    Format createVideoSampleFormat = Format.createVideoSampleFormat(str, "video/mpeg2", null, -1, -1, i19, i26, -1.0f, Collections.singletonList(copyOf), -1, f17, null);
                    i16 = (copyOf[7] & RegisterType.DOUBLE_HI) - 1;
                    if (i16 >= 0) {
                        double[] dArr = FRAME_RATE_VALUES;
                        if (i16 < dArr.length) {
                            double d16 = dArr[i16];
                            byte b16 = copyOf[csdBuffer.sequenceExtensionPosition + 9];
                            int i28 = (b16 & Constants.VIRTUAL_GAMEPAD_SDK_DATA) >> 5;
                            if (i28 != (b16 & 31)) {
                                d16 *= (i28 + 1.0d) / (r0 + 1);
                            }
                            j3 = (long) (1000000.0d / d16);
                            return Pair.create(createVideoSampleFormat, Long.valueOf(j3));
                        }
                    }
                    j3 = 0;
                    return Pair.create(createVideoSampleFormat, Long.valueOf(j3));
                }
                f16 = i26 * 121;
                i3 = i19 * 100;
            } else {
                f16 = i26 * 16;
                i3 = i19 * 9;
            }
        } else {
            f16 = i26 * 4;
            i3 = i19 * 3;
        }
        f17 = f16 / i3;
        Format createVideoSampleFormat2 = Format.createVideoSampleFormat(str, "video/mpeg2", null, -1, -1, i19, i26, -1.0f, Collections.singletonList(copyOf), -1, f17, null);
        i16 = (copyOf[7] & RegisterType.DOUBLE_HI) - 1;
        if (i16 >= 0) {
        }
        j3 = 0;
        return Pair.create(createVideoSampleFormat2, Long.valueOf(j3));
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void consume(ParsableByteArray parsableByteArray) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] bArr = parsableByteArray.data;
        this.totalBytesWritten += parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
        while (true) {
            int findNalUnit = NalUnitUtil.findNalUnit(bArr, position, limit, this.prefixFlags);
            if (findNalUnit == limit) {
                break;
            }
            int i16 = findNalUnit + 3;
            int i17 = parsableByteArray.data[i16] & 255;
            if (!this.hasOutputFormat) {
                int i18 = findNalUnit - position;
                if (i18 > 0) {
                    this.csdBuffer.onData(bArr, position, findNalUnit);
                }
                if (i18 < 0) {
                    i3 = -i18;
                } else {
                    i3 = 0;
                }
                if (this.csdBuffer.onStartCode(i17, i3)) {
                    Pair<Format, Long> parseCsdBuffer = parseCsdBuffer(this.csdBuffer, this.formatId);
                    this.output.format((Format) parseCsdBuffer.first);
                    this.frameDurationUs = ((Long) parseCsdBuffer.second).longValue();
                    this.hasOutputFormat = true;
                }
            }
            if (i17 != 0 && i17 != 179) {
                if (i17 == 184) {
                    this.sampleIsKeyframe = true;
                }
            } else {
                int i19 = limit - findNalUnit;
                if (this.startedFirstSample && this.sampleHasPicture && this.hasOutputFormat) {
                    this.output.sampleMetadata(this.sampleTimeUs, this.sampleIsKeyframe ? 1 : 0, ((int) (this.totalBytesWritten - this.samplePosition)) - i19, i19, null);
                }
                boolean z19 = this.startedFirstSample;
                if (z19 && !this.sampleHasPicture) {
                    z16 = false;
                    z17 = true;
                } else {
                    this.samplePosition = this.totalBytesWritten - i19;
                    long j3 = this.pesTimeUs;
                    if (j3 == -9223372036854775807L) {
                        if (z19) {
                            j3 = this.sampleTimeUs + this.frameDurationUs;
                        } else {
                            j3 = 0;
                        }
                    }
                    this.sampleTimeUs = j3;
                    z16 = false;
                    this.sampleIsKeyframe = false;
                    this.pesTimeUs = -9223372036854775807L;
                    z17 = true;
                    this.startedFirstSample = true;
                }
                if (i17 == 0) {
                    z18 = z17;
                } else {
                    z18 = z16;
                }
                this.sampleHasPicture = z18;
            }
            position = i16;
        }
        if (!this.hasOutputFormat) {
            this.csdBuffer.onData(bArr, position, limit);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetStarted(long j3, boolean z16) {
        this.pesTimeUs = j3;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void seek() {
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.csdBuffer.reset();
        this.totalBytesWritten = 0L;
        this.startedFirstSample = false;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader
    public void packetFinished() {
    }
}
