package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {
    private static final int DESCRIPTOR_TAG_CAPTION_SERVICE = 134;
    public static final int FLAG_ALLOW_NON_IDR_KEYFRAMES = 1;
    public static final int FLAG_DETECT_ACCESS_UNITS = 8;
    public static final int FLAG_IGNORE_AAC_STREAM = 2;
    public static final int FLAG_IGNORE_H264_STREAM = 4;
    public static final int FLAG_IGNORE_SPLICE_INFO_STREAM = 16;
    public static final int FLAG_OVERRIDE_CAPTION_DESCRIPTORS = 32;
    private final List<Format> closedCaptionFormats;
    private final int flags;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Flags {
    }

    public DefaultTsPayloadReaderFactory() {
        this(0);
    }

    private SeiReader buildSeiReader(TsPayloadReader.EsInfo esInfo) {
        boolean z16;
        int i3;
        String str;
        if (isSet(32)) {
            return new SeiReader(this.closedCaptionFormats);
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.descriptorBytes);
        List<Format> list = this.closedCaptionFormats;
        while (parsableByteArray.bytesLeft() > 0) {
            int readUnsignedByte = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition() + parsableByteArray.readUnsignedByte();
            if (readUnsignedByte == 134) {
                list = new ArrayList<>();
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 31;
                for (int i16 = 0; i16 < readUnsignedByte2; i16++) {
                    String readString = parsableByteArray.readString(3);
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    if ((readUnsignedByte3 & 128) != 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        i3 = readUnsignedByte3 & 63;
                        str = "application/cea-708";
                    } else {
                        i3 = 1;
                        str = "application/cea-608";
                    }
                    list.add(Format.createTextSampleFormat((String) null, str, (String) null, -1, 0, readString, i3, (DrmInitData) null));
                    parsableByteArray.skipBytes(2);
                }
            }
            parsableByteArray.setPosition(position);
        }
        return new SeiReader(list);
    }

    private boolean isSet(int i3) {
        if ((i3 & this.flags) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public SparseArray<TsPayloadReader> createInitialPayloadReaders() {
        return new SparseArray<>();
    }

    @Override // com.google.android.exoplayer2.extractor.ts.TsPayloadReader.Factory
    public TsPayloadReader createPayloadReader(int i3, TsPayloadReader.EsInfo esInfo) {
        if (i3 != 2) {
            if (i3 != 3 && i3 != 4) {
                if (i3 != 15) {
                    if (i3 != 17) {
                        if (i3 != 21) {
                            if (i3 != 27) {
                                if (i3 != 36) {
                                    if (i3 != 89) {
                                        if (i3 != 138) {
                                            if (i3 != 129) {
                                                if (i3 != 130) {
                                                    if (i3 != 134) {
                                                        if (i3 != 135) {
                                                            return null;
                                                        }
                                                    } else {
                                                        if (isSet(16)) {
                                                            return null;
                                                        }
                                                        return new SectionReader(new SpliceInfoSectionReader());
                                                    }
                                                }
                                            }
                                            return new PesReader(new Ac3Reader(esInfo.language));
                                        }
                                        return new PesReader(new DtsReader(esInfo.language));
                                    }
                                    return new PesReader(new DvbSubtitleReader(esInfo.dvbSubtitleInfos));
                                }
                                return new PesReader(new H265Reader(buildSeiReader(esInfo)));
                            }
                            if (isSet(4)) {
                                return null;
                            }
                            return new PesReader(new H264Reader(buildSeiReader(esInfo), isSet(1), isSet(8)));
                        }
                        return new PesReader(new Id3Reader());
                    }
                    if (isSet(2)) {
                        return null;
                    }
                    return new PesReader(new LatmReader(esInfo.language));
                }
                if (isSet(2)) {
                    return null;
                }
                return new PesReader(new AdtsReader(false, esInfo.language));
            }
            return new PesReader(new MpegAudioReader(esInfo.language));
        }
        return new PesReader(new H262Reader());
    }

    public DefaultTsPayloadReaderFactory(int i3) {
        this(i3, Collections.emptyList());
    }

    public DefaultTsPayloadReaderFactory(int i3, List<Format> list) {
        this.flags = i3;
        if (!isSet(32) && list.isEmpty()) {
            list = Collections.singletonList(Format.createTextSampleFormat(null, "application/cea-608", 0, null));
        }
        this.closedCaptionFormats = list;
    }
}
