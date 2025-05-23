package com.google.android.exoplayer2.extractor.mkv;

import android.support.annotation.Nullable;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.video.HevcConfig;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import org.apache.commons.fileupload.MultipartStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class MatroskaExtractor implements Extractor {
    private static final int BLOCK_STATE_DATA = 2;
    private static final int BLOCK_STATE_HEADER = 1;
    private static final int BLOCK_STATE_START = 0;
    private static final String CODEC_ID_AAC = "A_AAC";
    private static final String CODEC_ID_AC3 = "A_AC3";
    private static final String CODEC_ID_ACM = "A_MS/ACM";
    private static final String CODEC_ID_ASS = "S_TEXT/ASS";
    private static final String CODEC_ID_DTS = "A_DTS";
    private static final String CODEC_ID_DTS_EXPRESS = "A_DTS/EXPRESS";
    private static final String CODEC_ID_DTS_LOSSLESS = "A_DTS/LOSSLESS";
    private static final String CODEC_ID_DVBSUB = "S_DVBSUB";
    private static final String CODEC_ID_E_AC3 = "A_EAC3";
    private static final String CODEC_ID_FLAC = "A_FLAC";
    private static final String CODEC_ID_FOURCC = "V_MS/VFW/FOURCC";
    private static final String CODEC_ID_H264 = "V_MPEG4/ISO/AVC";
    private static final String CODEC_ID_H265 = "V_MPEGH/ISO/HEVC";
    private static final String CODEC_ID_MP2 = "A_MPEG/L2";
    private static final String CODEC_ID_MP3 = "A_MPEG/L3";
    private static final String CODEC_ID_MPEG2 = "V_MPEG2";
    private static final String CODEC_ID_MPEG4_AP = "V_MPEG4/ISO/AP";
    private static final String CODEC_ID_MPEG4_ASP = "V_MPEG4/ISO/ASP";
    private static final String CODEC_ID_MPEG4_SP = "V_MPEG4/ISO/SP";
    private static final String CODEC_ID_OPUS = "A_OPUS";
    private static final String CODEC_ID_PCM_INT_LIT = "A_PCM/INT/LIT";
    private static final String CODEC_ID_PGS = "S_HDMV/PGS";
    private static final String CODEC_ID_SUBRIP = "S_TEXT/UTF8";
    private static final String CODEC_ID_THEORA = "V_THEORA";
    private static final String CODEC_ID_TRUEHD = "A_TRUEHD";
    private static final String CODEC_ID_VOBSUB = "S_VOBSUB";
    private static final String CODEC_ID_VORBIS = "A_VORBIS";
    private static final String CODEC_ID_VP8 = "V_VP8";
    private static final String CODEC_ID_VP9 = "V_VP9";
    private static final String DOC_TYPE_MATROSKA = "matroska";
    private static final String DOC_TYPE_WEBM = "webm";
    private static final int ENCRYPTION_IV_SIZE = 8;
    public static final int FLAG_DISABLE_SEEK_FOR_CUES = 1;
    private static final int FOURCC_COMPRESSION_VC1 = 826496599;
    private static final int ID_AUDIO = 225;
    private static final int ID_AUDIO_BIT_DEPTH = 25188;
    private static final int ID_BLOCK = 161;
    private static final int ID_BLOCK_DURATION = 155;
    private static final int ID_BLOCK_GROUP = 160;
    private static final int ID_CHANNELS = 159;
    private static final int ID_CLUSTER = 524531317;
    private static final int ID_CODEC_DELAY = 22186;
    private static final int ID_CODEC_ID = 134;
    private static final int ID_CODEC_PRIVATE = 25506;
    private static final int ID_COLOUR = 21936;
    private static final int ID_COLOUR_PRIMARIES = 21947;
    private static final int ID_COLOUR_RANGE = 21945;
    private static final int ID_COLOUR_TRANSFER = 21946;
    private static final int ID_CONTENT_COMPRESSION = 20532;
    private static final int ID_CONTENT_COMPRESSION_ALGORITHM = 16980;
    private static final int ID_CONTENT_COMPRESSION_SETTINGS = 16981;
    private static final int ID_CONTENT_ENCODING = 25152;
    private static final int ID_CONTENT_ENCODINGS = 28032;
    private static final int ID_CONTENT_ENCODING_ORDER = 20529;
    private static final int ID_CONTENT_ENCODING_SCOPE = 20530;
    private static final int ID_CONTENT_ENCRYPTION = 20533;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS = 18407;
    private static final int ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE = 18408;
    private static final int ID_CONTENT_ENCRYPTION_ALGORITHM = 18401;
    private static final int ID_CONTENT_ENCRYPTION_KEY_ID = 18402;
    private static final int ID_CUES = 475249515;
    private static final int ID_CUE_CLUSTER_POSITION = 241;
    private static final int ID_CUE_POINT = 187;
    private static final int ID_CUE_TIME = 179;
    private static final int ID_CUE_TRACK_POSITIONS = 183;
    private static final int ID_DEFAULT_DURATION = 2352003;
    private static final int ID_DISPLAY_HEIGHT = 21690;
    private static final int ID_DISPLAY_UNIT = 21682;
    private static final int ID_DISPLAY_WIDTH = 21680;
    private static final int ID_DOC_TYPE = 17026;
    private static final int ID_DOC_TYPE_READ_VERSION = 17029;
    private static final int ID_DURATION = 17545;
    private static final int ID_EBML = 440786851;
    private static final int ID_EBML_READ_VERSION = 17143;
    private static final int ID_FLAG_DEFAULT = 136;
    private static final int ID_FLAG_FORCED = 21930;
    private static final int ID_INFO = 357149030;
    private static final int ID_LANGUAGE = 2274716;
    private static final int ID_LUMNINANCE_MAX = 21977;
    private static final int ID_LUMNINANCE_MIN = 21978;
    private static final int ID_MASTERING_METADATA = 21968;
    private static final int ID_MAX_CLL = 21948;
    private static final int ID_MAX_FALL = 21949;
    private static final int ID_PIXEL_HEIGHT = 186;
    private static final int ID_PIXEL_WIDTH = 176;
    private static final int ID_PRIMARY_B_CHROMATICITY_X = 21973;
    private static final int ID_PRIMARY_B_CHROMATICITY_Y = 21974;
    private static final int ID_PRIMARY_G_CHROMATICITY_X = 21971;
    private static final int ID_PRIMARY_G_CHROMATICITY_Y = 21972;
    private static final int ID_PRIMARY_R_CHROMATICITY_X = 21969;
    private static final int ID_PRIMARY_R_CHROMATICITY_Y = 21970;
    private static final int ID_PROJECTION = 30320;
    private static final int ID_PROJECTION_PRIVATE = 30322;
    private static final int ID_REFERENCE_BLOCK = 251;
    private static final int ID_SAMPLING_FREQUENCY = 181;
    private static final int ID_SEEK = 19899;
    private static final int ID_SEEK_HEAD = 290298740;
    private static final int ID_SEEK_ID = 21419;
    private static final int ID_SEEK_POSITION = 21420;
    private static final int ID_SEEK_PRE_ROLL = 22203;
    private static final int ID_SEGMENT = 408125543;
    private static final int ID_SEGMENT_INFO = 357149030;
    private static final int ID_SIMPLE_BLOCK = 163;
    private static final int ID_STEREO_MODE = 21432;
    private static final int ID_TIMECODE_SCALE = 2807729;
    private static final int ID_TIME_CODE = 231;
    private static final int ID_TRACKS = 374648427;
    private static final int ID_TRACK_ENTRY = 174;
    private static final int ID_TRACK_NUMBER = 215;
    private static final int ID_TRACK_TYPE = 131;
    private static final int ID_VIDEO = 224;
    private static final int ID_WHITE_POINT_CHROMATICITY_X = 21975;
    private static final int ID_WHITE_POINT_CHROMATICITY_Y = 21976;
    private static final int LACING_EBML = 3;
    private static final int LACING_FIXED_SIZE = 2;
    private static final int LACING_NONE = 0;
    private static final int LACING_XIPH = 1;
    private static final int OPUS_MAX_INPUT_SIZE = 5760;
    private static final int SSA_PREFIX_END_TIMECODE_OFFSET = 21;
    private static final String SSA_TIMECODE_FORMAT = "%01d:%02d:%02d:%02d";
    private static final long SSA_TIMECODE_LAST_VALUE_SCALING_FACTOR = 10000;
    private static final int SUBRIP_PREFIX_END_TIMECODE_OFFSET = 19;
    private static final String SUBRIP_TIMECODE_FORMAT = "%02d:%02d:%02d,%03d";
    private static final long SUBRIP_TIMECODE_LAST_VALUE_SCALING_FACTOR = 1000;
    private static final String TAG = "MatroskaExtractor";
    private static final int TRACK_TYPE_AUDIO = 2;
    private static final int UNSET_ENTRY_ID = -1;
    private static final int VORBIS_MAX_INPUT_SIZE = 8192;
    private static final int WAVE_FORMAT_EXTENSIBLE = 65534;
    private static final int WAVE_FORMAT_PCM = 1;
    private static final int WAVE_FORMAT_SIZE = 18;
    private long blockDurationUs;
    private int blockFlags;
    private int blockLacingSampleCount;
    private int blockLacingSampleIndex;
    private int[] blockLacingSampleSizes;
    private int blockState;
    private long blockTimeUs;
    private int blockTrackNumber;
    private int blockTrackNumberLength;
    private long clusterTimecodeUs;
    private LongArray cueClusterPositions;
    private LongArray cueTimesUs;
    private long cuesContentPosition;
    private Track currentTrack;
    private long durationTimecode;
    private long durationUs;
    private final ParsableByteArray encryptionInitializationVector;
    private final ParsableByteArray encryptionSubsampleData;
    private ByteBuffer encryptionSubsampleDataBuffer;
    private ExtractorOutput extractorOutput;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private final EbmlReader reader;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private boolean sampleEncodingHandled;
    private boolean sampleInitializationVectorRead;
    private int samplePartitionCount;
    private boolean samplePartitionCountRead;
    private boolean sampleRead;
    private boolean sampleSeenReferenceBlock;
    private byte sampleSignalByte;
    private boolean sampleSignalByteRead;
    private final ParsableByteArray sampleStrippedBytes;
    private final ParsableByteArray scratch;
    private int seekEntryId;
    private final ParsableByteArray seekEntryIdBytes;
    private long seekEntryPosition;
    private boolean seekForCues;
    private final boolean seekForCuesEnabled;
    private long seekPositionAfterBuildingCues;
    private boolean seenClusterPositionForCurrentCuePoint;
    private long segmentContentPosition;
    private long segmentContentSize;
    private boolean sentSeekMap;
    private final ParsableByteArray subtitleSample;
    private long timecodeScale;
    private final SparseArray<Track> tracks;
    private final VarintReader varintReader;
    private final ParsableByteArray vorbisNumPageSamples;
    public static final ExtractorsFactory FACTORY = new ExtractorsFactory() { // from class: com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor.1
        @Override // com.google.android.exoplayer2.extractor.ExtractorsFactory
        public Extractor[] createExtractors() {
            return new Extractor[]{new MatroskaExtractor()};
        }
    };
    private static final byte[] SUBRIP_PREFIX = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, MultipartStream.DASH, MultipartStream.DASH, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] SUBRIP_TIMECODE_EMPTY = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final byte[] SSA_DIALOGUE_FORMAT = Util.getUtf8Bytes("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");
    private static final byte[] SSA_PREFIX = {68, 105, 97, Constants.SDK_SEND_CHANNEL_DATA_TYPE, PublicAccountH5AbilityPluginImpl.OPENIMG, 103, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};
    private static final byte[] SSA_TIMECODE_EMPTY = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID WAVE_SUBFORMAT_PCM = new UUID(72057594037932032L, -9223371306706625679L);

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Flags {
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private final class InnerEbmlReaderOutput implements EbmlReaderOutput {
        InnerEbmlReaderOutput() {
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void binaryElement(int i3, int i16, ExtractorInput extractorInput) throws IOException, InterruptedException {
            MatroskaExtractor.this.binaryElement(i3, i16, extractorInput);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void endMasterElement(int i3) throws ParserException {
            MatroskaExtractor.this.endMasterElement(i3);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void floatElement(int i3, double d16) throws ParserException {
            MatroskaExtractor.this.floatElement(i3, d16);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public int getElementType(int i3) {
            return MatroskaExtractor.this.getElementType(i3);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void integerElement(int i3, long j3) throws ParserException {
            MatroskaExtractor.this.integerElement(i3, j3);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public boolean isLevel1Element(int i3) {
            return MatroskaExtractor.this.isLevel1Element(i3);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void startMasterElement(int i3, long j3, long j16) throws ParserException {
            MatroskaExtractor.this.startMasterElement(i3, j3, j16);
        }

        @Override // com.google.android.exoplayer2.extractor.mkv.EbmlReaderOutput
        public void stringElement(int i3, String str) throws ParserException {
            MatroskaExtractor.this.stringElement(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Track {
        private static final int DEFAULT_MAX_CLL = 1000;
        private static final int DEFAULT_MAX_FALL = 200;
        private static final int DISPLAY_UNIT_PIXELS = 0;
        private static final int MAX_CHROMATICITY = 50000;
        public int audioBitDepth;
        public int channelCount;
        public long codecDelayNs;
        public String codecId;
        public byte[] codecPrivate;
        public int colorRange;
        public int colorSpace;
        public int colorTransfer;
        public TrackOutput.CryptoData cryptoData;
        public int defaultSampleDurationNs;
        public int displayHeight;
        public int displayUnit;
        public int displayWidth;
        public DrmInitData drmInitData;
        public boolean flagDefault;
        public boolean flagForced;
        public boolean hasColorInfo;
        public boolean hasContentEncryption;
        public int height;
        private String language;
        public int maxContentLuminance;
        public int maxFrameAverageLuminance;
        public float maxMasteringLuminance;
        public float minMasteringLuminance;
        public int nalUnitLengthFieldLength;
        public int number;
        public TrackOutput output;
        public float primaryBChromaticityX;
        public float primaryBChromaticityY;
        public float primaryGChromaticityX;
        public float primaryGChromaticityY;
        public float primaryRChromaticityX;
        public float primaryRChromaticityY;
        public byte[] projectionData;
        public int sampleRate;
        public byte[] sampleStrippedBytes;
        public long seekPreRollNs;
        public int stereoMode;

        @Nullable
        public TrueHdSampleRechunker trueHdSampleRechunker;
        public int type;
        public float whitePointChromaticityX;
        public float whitePointChromaticityY;
        public int width;

        Track() {
            this.width = -1;
            this.height = -1;
            this.displayWidth = -1;
            this.displayHeight = -1;
            this.displayUnit = 0;
            this.projectionData = null;
            this.stereoMode = -1;
            this.hasColorInfo = false;
            this.colorSpace = -1;
            this.colorTransfer = -1;
            this.colorRange = -1;
            this.maxContentLuminance = 1000;
            this.maxFrameAverageLuminance = 200;
            this.primaryRChromaticityX = -1.0f;
            this.primaryRChromaticityY = -1.0f;
            this.primaryGChromaticityX = -1.0f;
            this.primaryGChromaticityY = -1.0f;
            this.primaryBChromaticityX = -1.0f;
            this.primaryBChromaticityY = -1.0f;
            this.whitePointChromaticityX = -1.0f;
            this.whitePointChromaticityY = -1.0f;
            this.maxMasteringLuminance = -1.0f;
            this.minMasteringLuminance = -1.0f;
            this.channelCount = 1;
            this.audioBitDepth = -1;
            this.sampleRate = 8000;
            this.codecDelayNs = 0L;
            this.seekPreRollNs = 0L;
            this.flagDefault = true;
            this.language = "eng";
        }

        private byte[] getHdrStaticInfo() {
            if (this.primaryRChromaticityX != -1.0f && this.primaryRChromaticityY != -1.0f && this.primaryGChromaticityX != -1.0f && this.primaryGChromaticityY != -1.0f && this.primaryBChromaticityX != -1.0f && this.primaryBChromaticityY != -1.0f && this.whitePointChromaticityX != -1.0f && this.whitePointChromaticityY != -1.0f && this.maxMasteringLuminance != -1.0f && this.minMasteringLuminance != -1.0f) {
                byte[] bArr = new byte[25];
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                wrap.put((byte) 0);
                wrap.putShort((short) ((this.primaryRChromaticityX * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.primaryRChromaticityY * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.primaryGChromaticityX * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.primaryGChromaticityY * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.primaryBChromaticityX * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.primaryBChromaticityY * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.whitePointChromaticityX * 50000.0f) + 0.5f));
                wrap.putShort((short) ((this.whitePointChromaticityY * 50000.0f) + 0.5f));
                wrap.putShort((short) (this.maxMasteringLuminance + 0.5f));
                wrap.putShort((short) (this.minMasteringLuminance + 0.5f));
                wrap.putShort((short) this.maxContentLuminance);
                wrap.putShort((short) this.maxFrameAverageLuminance);
                return bArr;
            }
            return null;
        }

        private static List<byte[]> parseFourCcVc1Private(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                parsableByteArray.skipBytes(16);
                if (parsableByteArray.readLittleEndianUnsignedInt() != 826496599) {
                    return null;
                }
                byte[] bArr = parsableByteArray.data;
                for (int position = parsableByteArray.getPosition() + 20; position < bArr.length - 4; position++) {
                    if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                        return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                    }
                }
                throw new ParserException("Failed to find FourCC VC1 initialization data");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing FourCC VC1 codec private");
            }
        }

        private static boolean parseMsAcmCodecPrivate(ParsableByteArray parsableByteArray) throws ParserException {
            try {
                int readLittleEndianUnsignedShort = parsableByteArray.readLittleEndianUnsignedShort();
                if (readLittleEndianUnsignedShort == 1) {
                    return true;
                }
                if (readLittleEndianUnsignedShort != 65534) {
                    return false;
                }
                parsableByteArray.setPosition(24);
                if (parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getMostSignificantBits()) {
                    if (parsableByteArray.readLong() == MatroskaExtractor.WAVE_SUBFORMAT_PCM.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing MS/ACM codec private");
            }
        }

        private static List<byte[]> parseVorbisCodecPrivate(byte[] bArr) throws ParserException {
            int i3;
            int i16;
            try {
                if (bArr[0] == 2) {
                    int i17 = 0;
                    int i18 = 1;
                    while (true) {
                        i3 = bArr[i18];
                        if (i3 != -1) {
                            break;
                        }
                        i17 += 255;
                        i18++;
                    }
                    int i19 = i18 + 1;
                    int i26 = i17 + i3;
                    int i27 = 0;
                    while (true) {
                        i16 = bArr[i19];
                        if (i16 != -1) {
                            break;
                        }
                        i27 += 255;
                        i19++;
                    }
                    int i28 = i19 + 1;
                    int i29 = i27 + i16;
                    if (bArr[i28] == 1) {
                        byte[] bArr2 = new byte[i26];
                        System.arraycopy(bArr, i28, bArr2, 0, i26);
                        int i36 = i28 + i26;
                        if (bArr[i36] == 3) {
                            int i37 = i36 + i29;
                            if (bArr[i37] == 5) {
                                byte[] bArr3 = new byte[bArr.length - i37];
                                System.arraycopy(bArr, i37, bArr3, 0, bArr.length - i37);
                                ArrayList arrayList = new ArrayList(2);
                                arrayList.add(bArr2);
                                arrayList.add(bArr3);
                                return arrayList;
                            }
                            throw new ParserException("Error parsing vorbis codec private");
                        }
                        throw new ParserException("Error parsing vorbis codec private");
                    }
                    throw new ParserException("Error parsing vorbis codec private");
                }
                throw new ParserException("Error parsing vorbis codec private");
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ParserException("Error parsing vorbis codec private");
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:5:0x01d4. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0386  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x038e  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x03b4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void initializeOutput(ExtractorOutput extractorOutput, int i3) throws ParserException {
            char c16;
            List<byte[]> singletonList;
            String str;
            int pcmEncoding;
            String str2;
            String str3;
            int i16;
            String str4;
            int i17;
            List<byte[]> list;
            int i18;
            Format createImageSampleFormat;
            int i19;
            float f16;
            ColorInfo colorInfo;
            int i26;
            String str5 = this.codecId;
            str5.hashCode();
            int i27 = 1;
            int i28 = 0;
            switch (str5.hashCode()) {
                case -2095576542:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_MPEG4_AP)) {
                        c16 = 0;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -2095575984:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_MPEG4_SP)) {
                        c16 = 1;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1985379776:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_ACM)) {
                        c16 = 2;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1784763192:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_TRUEHD)) {
                        c16 = 3;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1730367663:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_VORBIS)) {
                        c16 = 4;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1482641358:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_MP2)) {
                        c16 = 5;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1482641357:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_MP3)) {
                        c16 = 6;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -1373388978:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_FOURCC)) {
                        c16 = 7;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -933872740:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_DVBSUB)) {
                        c16 = '\b';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -538363189:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_MPEG4_ASP)) {
                        c16 = '\t';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -538363109:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_H264)) {
                        c16 = '\n';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -425012669:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_VOBSUB)) {
                        c16 = 11;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case -356037306:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_DTS_LOSSLESS)) {
                        c16 = '\f';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 62923557:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_AAC)) {
                        c16 = '\r';
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 62923603:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_AC3)) {
                        c16 = 14;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 62927045:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_DTS)) {
                        c16 = 15;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 82338133:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_VP8)) {
                        c16 = 16;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 82338134:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_VP9)) {
                        c16 = 17;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 99146302:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_PGS)) {
                        c16 = 18;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 444813526:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_THEORA)) {
                        c16 = 19;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 542569478:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_DTS_EXPRESS)) {
                        c16 = 20;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 725957860:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_PCM_INT_LIT)) {
                        c16 = 21;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 738597099:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_ASS)) {
                        c16 = 22;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 855502857:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_H265)) {
                        c16 = 23;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1422270023:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_SUBRIP)) {
                        c16 = 24;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1809237540:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_MPEG2)) {
                        c16 = 25;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1950749482:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_E_AC3)) {
                        c16 = 26;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1950789798:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_FLAC)) {
                        c16 = 27;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                case 1951062397:
                    if (str5.equals(MatroskaExtractor.CODEC_ID_OPUS)) {
                        c16 = 28;
                        break;
                    }
                    c16 = '\uffff';
                    break;
                default:
                    c16 = '\uffff';
                    break;
            }
            String str6 = "audio/x-unknown";
            switch (c16) {
                case 0:
                case 1:
                case '\t':
                    byte[] bArr = this.codecPrivate;
                    if (bArr == null) {
                        singletonList = null;
                    } else {
                        singletonList = Collections.singletonList(bArr);
                    }
                    str = "video/mp4v-es";
                    str6 = str;
                    i18 = -1;
                    i17 = -1;
                    int i29 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                        i28 = 2;
                    }
                    int i36 = i29 | i28;
                    if (MimeTypes.isAudio(str6)) {
                        createImageSampleFormat = Format.createAudioSampleFormat(Integer.toString(i3), str6, null, -1, i17, this.channelCount, this.sampleRate, i18, singletonList, this.drmInitData, i36, this.language);
                    } else if (MimeTypes.isVideo(str6)) {
                        if (this.displayUnit == 0) {
                            int i37 = this.displayWidth;
                            i19 = -1;
                            if (i37 == -1) {
                                i37 = this.width;
                            }
                            this.displayWidth = i37;
                            int i38 = this.displayHeight;
                            if (i38 == -1) {
                                i38 = this.height;
                            }
                            this.displayHeight = i38;
                        } else {
                            i19 = -1;
                        }
                        if (this.displayWidth != i19 && (i26 = this.displayHeight) != i19) {
                            f16 = (this.height * r2) / (this.width * i26);
                        } else {
                            f16 = -1.0f;
                        }
                        float f17 = f16;
                        if (this.hasColorInfo) {
                            colorInfo = new ColorInfo(this.colorSpace, this.colorRange, this.colorTransfer, getHdrStaticInfo());
                        } else {
                            colorInfo = null;
                        }
                        createImageSampleFormat = Format.createVideoSampleFormat(Integer.toString(i3), str6, null, -1, i17, this.width, this.height, -1.0f, singletonList, -1, f17, this.projectionData, this.stereoMode, colorInfo, this.drmInitData);
                        i27 = 2;
                    } else {
                        if ("application/x-subrip".equals(str6)) {
                            createImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i3), str6, i36, this.language, this.drmInitData);
                        } else if ("text/x-ssa".equals(str6)) {
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(MatroskaExtractor.SSA_DIALOGUE_FORMAT);
                            arrayList.add(this.codecPrivate);
                            createImageSampleFormat = Format.createTextSampleFormat(Integer.toString(i3), str6, null, -1, i36, this.language, -1, this.drmInitData, Long.MAX_VALUE, arrayList);
                        } else {
                            if (!"application/vobsub".equals(str6) && !"application/pgs".equals(str6) && !"application/dvbsubs".equals(str6)) {
                                throw new ParserException("Unexpected MIME type.");
                            }
                            createImageSampleFormat = Format.createImageSampleFormat(Integer.toString(i3), str6, null, -1, i36, singletonList, this.language, this.drmInitData);
                        }
                        i27 = 3;
                    }
                    TrackOutput track = extractorOutput.track(this.number, i27);
                    this.output = track;
                    track.format(createImageSampleFormat);
                    return;
                case 2:
                    if (parseMsAcmCodecPrivate(new ParsableByteArray(this.codecPrivate))) {
                        pcmEncoding = Util.getPcmEncoding(this.audioBitDepth);
                        if (pcmEncoding == 0) {
                            Log.w(MatroskaExtractor.TAG, "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        }
                        i18 = pcmEncoding;
                        str6 = "audio/raw";
                        singletonList = null;
                        i17 = -1;
                        int i292 = (this.flagDefault ? 1 : 0) | 0;
                        if (this.flagForced) {
                        }
                        int i362 = i292 | i28;
                        if (MimeTypes.isAudio(str6)) {
                        }
                        TrackOutput track2 = extractorOutput.track(this.number, i27);
                        this.output = track2;
                        track2.format(createImageSampleFormat);
                        return;
                    }
                    Log.w(MatroskaExtractor.TAG, "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown");
                    singletonList = null;
                    i18 = -1;
                    i17 = -1;
                    int i2922 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i3622 = i2922 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track22 = extractorOutput.track(this.number, i27);
                    this.output = track22;
                    track22.format(createImageSampleFormat);
                    return;
                case 3:
                    this.trueHdSampleRechunker = new TrueHdSampleRechunker();
                    str2 = "audio/true-hd";
                    str6 = str2;
                    singletonList = null;
                    i18 = -1;
                    i17 = -1;
                    int i29222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i36222 = i29222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track222 = extractorOutput.track(this.number, i27);
                    this.output = track222;
                    track222.format(createImageSampleFormat);
                    return;
                case 4:
                    singletonList = parseVorbisCodecPrivate(this.codecPrivate);
                    str3 = "audio/vorbis";
                    i16 = 8192;
                    str6 = str3;
                    i17 = i16;
                    i18 = -1;
                    int i292222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i362222 = i292222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track2222 = extractorOutput.track(this.number, i27);
                    this.output = track2222;
                    track2222.format(createImageSampleFormat);
                    return;
                case 5:
                    str4 = "audio/mpeg-L2";
                    str6 = str4;
                    i17 = 4096;
                    singletonList = null;
                    i18 = -1;
                    int i2922222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i3622222 = i2922222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track22222 = extractorOutput.track(this.number, i27);
                    this.output = track22222;
                    track22222.format(createImageSampleFormat);
                    return;
                case 6:
                    str4 = "audio/mpeg";
                    str6 = str4;
                    i17 = 4096;
                    singletonList = null;
                    i18 = -1;
                    int i29222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i36222222 = i29222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track222222 = extractorOutput.track(this.number, i27);
                    this.output = track222222;
                    track222222.format(createImageSampleFormat);
                    return;
                case 7:
                    singletonList = parseFourCcVc1Private(new ParsableByteArray(this.codecPrivate));
                    if (singletonList != null) {
                        str = "video/wvc1";
                        str6 = str;
                        i18 = -1;
                        i17 = -1;
                        int i292222222 = (this.flagDefault ? 1 : 0) | 0;
                        if (this.flagForced) {
                        }
                        int i362222222 = i292222222 | i28;
                        if (MimeTypes.isAudio(str6)) {
                        }
                        TrackOutput track2222222 = extractorOutput.track(this.number, i27);
                        this.output = track2222222;
                        track2222222.format(createImageSampleFormat);
                        return;
                    }
                    Log.w(MatroskaExtractor.TAG, "Unsupported FourCC. Setting mimeType to video/x-unknown");
                    str6 = "video/x-unknown";
                    i18 = -1;
                    i17 = -1;
                    int i2922222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i3622222222 = i2922222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track22222222 = extractorOutput.track(this.number, i27);
                    this.output = track22222222;
                    track22222222.format(createImageSampleFormat);
                    return;
                case '\b':
                    byte[] bArr2 = this.codecPrivate;
                    singletonList = Collections.singletonList(new byte[]{bArr2[0], bArr2[1], bArr2[2], bArr2[3]});
                    str6 = "application/dvbsubs";
                    i18 = -1;
                    i17 = -1;
                    int i29222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i36222222222 = i29222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track222222222 = extractorOutput.track(this.number, i27);
                    this.output = track222222222;
                    track222222222.format(createImageSampleFormat);
                    return;
                case '\n':
                    AvcConfig parse = AvcConfig.parse(new ParsableByteArray(this.codecPrivate));
                    list = parse.initializationData;
                    this.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                    str = "video/avc";
                    singletonList = list;
                    str6 = str;
                    i18 = -1;
                    i17 = -1;
                    int i292222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i362222222222 = i292222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track2222222222 = extractorOutput.track(this.number, i27);
                    this.output = track2222222222;
                    track2222222222.format(createImageSampleFormat);
                    return;
                case 11:
                    singletonList = Collections.singletonList(this.codecPrivate);
                    str6 = "application/vobsub";
                    i18 = -1;
                    i17 = -1;
                    int i2922222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i3622222222222 = i2922222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track22222222222 = extractorOutput.track(this.number, i27);
                    this.output = track22222222222;
                    track22222222222.format(createImageSampleFormat);
                    return;
                case '\f':
                    str2 = "audio/vnd.dts.hd";
                    str6 = str2;
                    singletonList = null;
                    i18 = -1;
                    i17 = -1;
                    int i29222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i36222222222222 = i29222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track222222222222;
                    track222222222222.format(createImageSampleFormat);
                    return;
                case '\r':
                    singletonList = Collections.singletonList(this.codecPrivate);
                    str = "audio/mp4a-latm";
                    str6 = str;
                    i18 = -1;
                    i17 = -1;
                    int i292222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i362222222222222 = i292222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track2222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track2222222222222;
                    track2222222222222.format(createImageSampleFormat);
                    return;
                case 14:
                    str2 = "audio/ac3";
                    str6 = str2;
                    singletonList = null;
                    i18 = -1;
                    i17 = -1;
                    int i2922222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i3622222222222222 = i2922222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track22222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track22222222222222;
                    track22222222222222.format(createImageSampleFormat);
                    return;
                case 15:
                case 20:
                    str2 = "audio/vnd.dts";
                    str6 = str2;
                    singletonList = null;
                    i18 = -1;
                    i17 = -1;
                    int i29222222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i36222222222222222 = i29222222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track222222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track222222222222222;
                    track222222222222222.format(createImageSampleFormat);
                    return;
                case 16:
                    str2 = "video/x-vnd.on2.vp8";
                    str6 = str2;
                    singletonList = null;
                    i18 = -1;
                    i17 = -1;
                    int i292222222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i362222222222222222 = i292222222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track2222222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track2222222222222222;
                    track2222222222222222.format(createImageSampleFormat);
                    return;
                case 17:
                    str2 = "video/x-vnd.on2.vp9";
                    str6 = str2;
                    singletonList = null;
                    i18 = -1;
                    i17 = -1;
                    int i2922222222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i3622222222222222222 = i2922222222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track22222222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track22222222222222222;
                    track22222222222222222.format(createImageSampleFormat);
                    return;
                case 18:
                    str6 = "application/pgs";
                    singletonList = null;
                    i18 = -1;
                    i17 = -1;
                    int i29222222222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i36222222222222222222 = i29222222222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track222222222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track222222222222222222;
                    track222222222222222222.format(createImageSampleFormat);
                    return;
                case 19:
                    str6 = "video/x-unknown";
                    singletonList = null;
                    i18 = -1;
                    i17 = -1;
                    int i292222222222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i362222222222222222222 = i292222222222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track2222222222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track2222222222222222222;
                    track2222222222222222222.format(createImageSampleFormat);
                    return;
                case 21:
                    pcmEncoding = Util.getPcmEncoding(this.audioBitDepth);
                    if (pcmEncoding == 0) {
                        Log.w(MatroskaExtractor.TAG, "Unsupported PCM bit depth: " + this.audioBitDepth + ". Setting mimeType to audio/x-unknown");
                        singletonList = null;
                        i18 = -1;
                        i17 = -1;
                        int i2922222222222222222222 = (this.flagDefault ? 1 : 0) | 0;
                        if (this.flagForced) {
                        }
                        int i3622222222222222222222 = i2922222222222222222222 | i28;
                        if (MimeTypes.isAudio(str6)) {
                        }
                        TrackOutput track22222222222222222222 = extractorOutput.track(this.number, i27);
                        this.output = track22222222222222222222;
                        track22222222222222222222.format(createImageSampleFormat);
                        return;
                    }
                    i18 = pcmEncoding;
                    str6 = "audio/raw";
                    singletonList = null;
                    i17 = -1;
                    int i29222222222222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i36222222222222222222222 = i29222222222222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track222222222222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track222222222222222222222;
                    track222222222222222222222.format(createImageSampleFormat);
                    return;
                case 22:
                    str6 = "text/x-ssa";
                    singletonList = null;
                    i18 = -1;
                    i17 = -1;
                    int i292222222222222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i362222222222222222222222 = i292222222222222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track2222222222222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track2222222222222222222222;
                    track2222222222222222222222.format(createImageSampleFormat);
                    return;
                case 23:
                    HevcConfig parse2 = HevcConfig.parse(new ParsableByteArray(this.codecPrivate));
                    list = parse2.initializationData;
                    this.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                    str = "video/hevc";
                    singletonList = list;
                    str6 = str;
                    i18 = -1;
                    i17 = -1;
                    int i2922222222222222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i3622222222222222222222222 = i2922222222222222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track22222222222222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track22222222222222222222222;
                    track22222222222222222222222.format(createImageSampleFormat);
                    return;
                case 24:
                    str6 = "application/x-subrip";
                    singletonList = null;
                    i18 = -1;
                    i17 = -1;
                    int i29222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i36222222222222222222222222 = i29222222222222222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track222222222222222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track222222222222222222222222;
                    track222222222222222222222222.format(createImageSampleFormat);
                    return;
                case 25:
                    str2 = "video/mpeg2";
                    str6 = str2;
                    singletonList = null;
                    i18 = -1;
                    i17 = -1;
                    int i292222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i362222222222222222222222222 = i292222222222222222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track2222222222222222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track2222222222222222222222222;
                    track2222222222222222222222222.format(createImageSampleFormat);
                    return;
                case 26:
                    str2 = "audio/eac3";
                    str6 = str2;
                    singletonList = null;
                    i18 = -1;
                    i17 = -1;
                    int i2922222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i3622222222222222222222222222 = i2922222222222222222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track22222222222222222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track22222222222222222222222222;
                    track22222222222222222222222222.format(createImageSampleFormat);
                    return;
                case 27:
                    singletonList = Collections.singletonList(this.codecPrivate);
                    str = "audio/flac";
                    str6 = str;
                    i18 = -1;
                    i17 = -1;
                    int i29222222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i36222222222222222222222222222 = i29222222222222222222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track222222222222222222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track222222222222222222222222222;
                    track222222222222222222222222222.format(createImageSampleFormat);
                    return;
                case 28:
                    singletonList = new ArrayList<>(3);
                    singletonList.add(this.codecPrivate);
                    singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.codecDelayNs).array());
                    singletonList.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(this.seekPreRollNs).array());
                    str3 = "audio/opus";
                    i16 = MatroskaExtractor.OPUS_MAX_INPUT_SIZE;
                    str6 = str3;
                    i17 = i16;
                    i18 = -1;
                    int i292222222222222222222222222222 = (this.flagDefault ? 1 : 0) | 0;
                    if (this.flagForced) {
                    }
                    int i362222222222222222222222222222 = i292222222222222222222222222222 | i28;
                    if (MimeTypes.isAudio(str6)) {
                    }
                    TrackOutput track2222222222222222222222222222 = extractorOutput.track(this.number, i27);
                    this.output = track2222222222222222222222222222;
                    track2222222222222222222222222222.format(createImageSampleFormat);
                    return;
                default:
                    throw new ParserException("Unrecognized codec identifier.");
            }
        }

        public void outputPendingSampleMetadata() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.outputPendingSampleMetadata(this);
            }
        }

        public void reset() {
            TrueHdSampleRechunker trueHdSampleRechunker = this.trueHdSampleRechunker;
            if (trueHdSampleRechunker != null) {
                trueHdSampleRechunker.reset();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class TrueHdSampleRechunker {
        private int blockFlags;
        private int chunkSize;
        private boolean foundSyncframe;
        private int sampleCount;
        private final byte[] syncframePrefix = new byte[12];
        private long timeUs;

        public void outputPendingSampleMetadata(Track track) {
            if (this.foundSyncframe && this.sampleCount > 0) {
                track.output.sampleMetadata(this.timeUs, this.blockFlags, this.chunkSize, 0, track.cryptoData);
                this.sampleCount = 0;
            }
        }

        public void reset() {
            this.foundSyncframe = false;
        }

        public void sampleMetadata(Track track, long j3) {
            if (!this.foundSyncframe) {
                return;
            }
            int i3 = this.sampleCount;
            int i16 = i3 + 1;
            this.sampleCount = i16;
            if (i3 == 0) {
                this.timeUs = j3;
            }
            if (i16 < 8) {
                return;
            }
            track.output.sampleMetadata(this.timeUs, this.blockFlags, this.chunkSize, 0, track.cryptoData);
            this.sampleCount = 0;
        }

        public void startSample(ExtractorInput extractorInput, int i3, int i16) throws IOException, InterruptedException {
            if (!this.foundSyncframe) {
                extractorInput.peekFully(this.syncframePrefix, 0, 12);
                extractorInput.resetPeekPosition();
                if (Ac3Util.parseTrueHdSyncframeAudioSampleCount(this.syncframePrefix) == -1) {
                    return;
                }
                this.foundSyncframe = true;
                this.sampleCount = 0;
            }
            if (this.sampleCount == 0) {
                this.blockFlags = i3;
                this.chunkSize = 0;
            }
            this.chunkSize += i16;
        }
    }

    public MatroskaExtractor() {
        this(0);
    }

    private SeekMap buildSeekMap() {
        LongArray longArray;
        LongArray longArray2;
        if (this.segmentContentPosition != -1 && this.durationUs != -9223372036854775807L && (longArray = this.cueTimesUs) != null && longArray.size() != 0 && (longArray2 = this.cueClusterPositions) != null && longArray2.size() == this.cueTimesUs.size()) {
            int size = this.cueTimesUs.size();
            int[] iArr = new int[size];
            long[] jArr = new long[size];
            long[] jArr2 = new long[size];
            long[] jArr3 = new long[size];
            int i3 = 0;
            for (int i16 = 0; i16 < size; i16++) {
                jArr3[i16] = this.cueTimesUs.get(i16);
                jArr[i16] = this.segmentContentPosition + this.cueClusterPositions.get(i16);
            }
            while (true) {
                int i17 = size - 1;
                if (i3 < i17) {
                    int i18 = i3 + 1;
                    iArr[i3] = (int) (jArr[i18] - jArr[i3]);
                    jArr2[i3] = jArr3[i18] - jArr3[i3];
                    i3 = i18;
                } else {
                    iArr[i17] = (int) ((this.segmentContentPosition + this.segmentContentSize) - jArr[i17]);
                    jArr2[i17] = this.durationUs - jArr3[i17];
                    this.cueTimesUs = null;
                    this.cueClusterPositions = null;
                    return new ChunkIndex(iArr, jArr, jArr2, jArr3);
                }
            }
        } else {
            this.cueTimesUs = null;
            this.cueClusterPositions = null;
            return new SeekMap.Unseekable(this.durationUs);
        }
    }

    private void commitSampleToOutput(Track track, long j3) {
        TrueHdSampleRechunker trueHdSampleRechunker = track.trueHdSampleRechunker;
        if (trueHdSampleRechunker != null) {
            trueHdSampleRechunker.sampleMetadata(track, j3);
        } else {
            if (CODEC_ID_SUBRIP.equals(track.codecId)) {
                commitSubtitleSample(track, SUBRIP_TIMECODE_FORMAT, 19, 1000L, SUBRIP_TIMECODE_EMPTY);
            } else if (CODEC_ID_ASS.equals(track.codecId)) {
                commitSubtitleSample(track, SSA_TIMECODE_FORMAT, 21, 10000L, SSA_TIMECODE_EMPTY);
            }
            track.output.sampleMetadata(j3, this.blockFlags, this.sampleBytesWritten, 0, track.cryptoData);
        }
        this.sampleRead = true;
        resetSample();
    }

    private void commitSubtitleSample(Track track, String str, int i3, long j3, byte[] bArr) {
        setSampleDuration(this.subtitleSample.data, this.blockDurationUs, str, i3, j3, bArr);
        TrackOutput trackOutput = track.output;
        ParsableByteArray parsableByteArray = this.subtitleSample;
        trackOutput.sampleData(parsableByteArray, parsableByteArray.limit());
        this.sampleBytesWritten += this.subtitleSample.limit();
    }

    private static int[] ensureArrayCapacity(int[] iArr, int i3) {
        if (iArr == null) {
            return new int[i3];
        }
        if (iArr.length >= i3) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i3)];
    }

    private static boolean isCodecSupported(String str) {
        if (!CODEC_ID_VP8.equals(str) && !CODEC_ID_VP9.equals(str) && !CODEC_ID_MPEG2.equals(str) && !CODEC_ID_MPEG4_SP.equals(str) && !CODEC_ID_MPEG4_ASP.equals(str) && !CODEC_ID_MPEG4_AP.equals(str) && !CODEC_ID_H264.equals(str) && !CODEC_ID_H265.equals(str) && !CODEC_ID_FOURCC.equals(str) && !CODEC_ID_THEORA.equals(str) && !CODEC_ID_OPUS.equals(str) && !CODEC_ID_VORBIS.equals(str) && !CODEC_ID_AAC.equals(str) && !CODEC_ID_MP2.equals(str) && !CODEC_ID_MP3.equals(str) && !CODEC_ID_AC3.equals(str) && !CODEC_ID_E_AC3.equals(str) && !CODEC_ID_TRUEHD.equals(str) && !CODEC_ID_DTS.equals(str) && !CODEC_ID_DTS_EXPRESS.equals(str) && !CODEC_ID_DTS_LOSSLESS.equals(str) && !CODEC_ID_FLAC.equals(str) && !CODEC_ID_ACM.equals(str) && !CODEC_ID_PCM_INT_LIT.equals(str) && !CODEC_ID_SUBRIP.equals(str) && !CODEC_ID_ASS.equals(str) && !CODEC_ID_VOBSUB.equals(str) && !CODEC_ID_PGS.equals(str) && !CODEC_ID_DVBSUB.equals(str)) {
            return false;
        }
        return true;
    }

    private boolean maybeSeekForCues(PositionHolder positionHolder, long j3) {
        if (this.seekForCues) {
            this.seekPositionAfterBuildingCues = j3;
            positionHolder.position = this.cuesContentPosition;
            this.seekForCues = false;
            return true;
        }
        if (this.sentSeekMap) {
            long j16 = this.seekPositionAfterBuildingCues;
            if (j16 != -1) {
                positionHolder.position = j16;
                this.seekPositionAfterBuildingCues = -1L;
                return true;
            }
        }
        return false;
    }

    private void readScratch(ExtractorInput extractorInput, int i3) throws IOException, InterruptedException {
        if (this.scratch.limit() >= i3) {
            return;
        }
        if (this.scratch.capacity() < i3) {
            ParsableByteArray parsableByteArray = this.scratch;
            byte[] bArr = parsableByteArray.data;
            parsableByteArray.reset(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i3)), this.scratch.limit());
        }
        ParsableByteArray parsableByteArray2 = this.scratch;
        extractorInput.readFully(parsableByteArray2.data, parsableByteArray2.limit(), i3 - this.scratch.limit());
        this.scratch.setLimit(i3);
    }

    private int readToOutput(ExtractorInput extractorInput, TrackOutput trackOutput, int i3) throws IOException, InterruptedException {
        int sampleData;
        int bytesLeft = this.sampleStrippedBytes.bytesLeft();
        if (bytesLeft > 0) {
            sampleData = Math.min(i3, bytesLeft);
            trackOutput.sampleData(this.sampleStrippedBytes, sampleData);
        } else {
            sampleData = trackOutput.sampleData(extractorInput, i3, false);
        }
        this.sampleBytesRead += sampleData;
        this.sampleBytesWritten += sampleData;
        return sampleData;
    }

    private void readToTarget(ExtractorInput extractorInput, byte[] bArr, int i3, int i16) throws IOException, InterruptedException {
        int min = Math.min(i16, this.sampleStrippedBytes.bytesLeft());
        extractorInput.readFully(bArr, i3 + min, i16 - min);
        if (min > 0) {
            this.sampleStrippedBytes.readBytes(bArr, i3, min);
        }
        this.sampleBytesRead += i16;
    }

    private void resetSample() {
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        this.sampleEncodingHandled = false;
        this.sampleSignalByteRead = false;
        this.samplePartitionCountRead = false;
        this.samplePartitionCount = 0;
        this.sampleSignalByte = (byte) 0;
        this.sampleInitializationVectorRead = false;
        this.sampleStrippedBytes.reset();
    }

    private long scaleTimecodeToUs(long j3) throws ParserException {
        long j16 = this.timecodeScale;
        if (j16 != -9223372036854775807L) {
            return Util.scaleLargeTimestamp(j3, j16, 1000L);
        }
        throw new ParserException("Can't scale timecode prior to timecodeScale being set.");
    }

    private static void setSampleDuration(byte[] bArr, long j3, String str, int i3, long j16, byte[] bArr2) {
        byte[] utf8Bytes;
        if (j3 == -9223372036854775807L) {
            utf8Bytes = bArr2;
        } else {
            int i16 = (int) (j3 / 3600000000L);
            long j17 = j3 - ((i16 * 3600) * 1000000);
            int i17 = (int) (j17 / AEEditorConstants.MAX_CLIP_TIME_US);
            long j18 = j17 - ((i17 * 60) * 1000000);
            int i18 = (int) (j18 / 1000000);
            utf8Bytes = Util.getUtf8Bytes(String.format(Locale.US, str, Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf((int) ((j18 - (i18 * 1000000)) / j16))));
        }
        System.arraycopy(utf8Bytes, 0, bArr, i3, bArr2.length);
    }

    private void writeSampleData(ExtractorInput extractorInput, Track track, int i3) throws IOException, InterruptedException {
        boolean z16;
        boolean z17;
        int i16;
        if (CODEC_ID_SUBRIP.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SUBRIP_PREFIX, i3);
            return;
        }
        if (CODEC_ID_ASS.equals(track.codecId)) {
            writeSubtitleSampleData(extractorInput, SSA_PREFIX, i3);
            return;
        }
        TrackOutput trackOutput = track.output;
        boolean z18 = true;
        if (!this.sampleEncodingHandled) {
            if (track.hasContentEncryption) {
                this.blockFlags &= -1073741825;
                int i17 = 128;
                if (!this.sampleSignalByteRead) {
                    extractorInput.readFully(this.scratch.data, 0, 1);
                    this.sampleBytesRead++;
                    byte b16 = this.scratch.data[0];
                    if ((b16 & 128) != 128) {
                        this.sampleSignalByte = b16;
                        this.sampleSignalByteRead = true;
                    } else {
                        throw new ParserException("Extension bit is set in signal byte");
                    }
                }
                byte b17 = this.sampleSignalByte;
                if ((b17 & 1) == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if ((b17 & 2) == 2) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    this.blockFlags |= 1073741824;
                    if (!this.sampleInitializationVectorRead) {
                        extractorInput.readFully(this.encryptionInitializationVector.data, 0, 8);
                        this.sampleBytesRead += 8;
                        this.sampleInitializationVectorRead = true;
                        ParsableByteArray parsableByteArray = this.scratch;
                        byte[] bArr = parsableByteArray.data;
                        if (!z17) {
                            i17 = 0;
                        }
                        bArr[0] = (byte) (i17 | 8);
                        parsableByteArray.setPosition(0);
                        trackOutput.sampleData(this.scratch, 1);
                        this.sampleBytesWritten++;
                        this.encryptionInitializationVector.setPosition(0);
                        trackOutput.sampleData(this.encryptionInitializationVector, 8);
                        this.sampleBytesWritten += 8;
                    }
                    if (z17) {
                        if (!this.samplePartitionCountRead) {
                            extractorInput.readFully(this.scratch.data, 0, 1);
                            this.sampleBytesRead++;
                            this.scratch.setPosition(0);
                            this.samplePartitionCount = this.scratch.readUnsignedByte();
                            this.samplePartitionCountRead = true;
                        }
                        int i18 = this.samplePartitionCount * 4;
                        this.scratch.reset(i18);
                        extractorInput.readFully(this.scratch.data, 0, i18);
                        this.sampleBytesRead += i18;
                        short s16 = (short) ((this.samplePartitionCount / 2) + 1);
                        int i19 = (s16 * 6) + 2;
                        ByteBuffer byteBuffer = this.encryptionSubsampleDataBuffer;
                        if (byteBuffer == null || byteBuffer.capacity() < i19) {
                            this.encryptionSubsampleDataBuffer = ByteBuffer.allocate(i19);
                        }
                        this.encryptionSubsampleDataBuffer.position(0);
                        this.encryptionSubsampleDataBuffer.putShort(s16);
                        int i26 = 0;
                        int i27 = 0;
                        while (true) {
                            i16 = this.samplePartitionCount;
                            if (i26 >= i16) {
                                break;
                            }
                            int readUnsignedIntToInt = this.scratch.readUnsignedIntToInt();
                            if (i26 % 2 == 0) {
                                this.encryptionSubsampleDataBuffer.putShort((short) (readUnsignedIntToInt - i27));
                            } else {
                                this.encryptionSubsampleDataBuffer.putInt(readUnsignedIntToInt - i27);
                            }
                            i26++;
                            i27 = readUnsignedIntToInt;
                        }
                        int i28 = (i3 - this.sampleBytesRead) - i27;
                        if (i16 % 2 == 1) {
                            this.encryptionSubsampleDataBuffer.putInt(i28);
                        } else {
                            this.encryptionSubsampleDataBuffer.putShort((short) i28);
                            this.encryptionSubsampleDataBuffer.putInt(0);
                        }
                        this.encryptionSubsampleData.reset(this.encryptionSubsampleDataBuffer.array(), i19);
                        trackOutput.sampleData(this.encryptionSubsampleData, i19);
                        this.sampleBytesWritten += i19;
                    }
                }
            } else {
                byte[] bArr2 = track.sampleStrippedBytes;
                if (bArr2 != null) {
                    this.sampleStrippedBytes.reset(bArr2, bArr2.length);
                }
            }
            this.sampleEncodingHandled = true;
        }
        int limit = i3 + this.sampleStrippedBytes.limit();
        if (!CODEC_ID_H264.equals(track.codecId) && !CODEC_ID_H265.equals(track.codecId)) {
            if (track.trueHdSampleRechunker != null) {
                if (this.sampleStrippedBytes.limit() != 0) {
                    z18 = false;
                }
                Assertions.checkState(z18);
                track.trueHdSampleRechunker.startSample(extractorInput, this.blockFlags, limit);
            }
            while (true) {
                int i29 = this.sampleBytesRead;
                if (i29 >= limit) {
                    break;
                } else {
                    readToOutput(extractorInput, trackOutput, limit - i29);
                }
            }
        } else {
            byte[] bArr3 = this.nalLength.data;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i36 = track.nalUnitLengthFieldLength;
            int i37 = 4 - i36;
            while (this.sampleBytesRead < limit) {
                int i38 = this.sampleCurrentNalBytesRemaining;
                if (i38 == 0) {
                    readToTarget(extractorInput, bArr3, i37, i36);
                    this.nalLength.setPosition(0);
                    this.sampleCurrentNalBytesRemaining = this.nalLength.readUnsignedIntToInt();
                    this.nalStartCode.setPosition(0);
                    trackOutput.sampleData(this.nalStartCode, 4);
                    this.sampleBytesWritten += 4;
                } else {
                    this.sampleCurrentNalBytesRemaining = i38 - readToOutput(extractorInput, trackOutput, i38);
                }
            }
        }
        if (CODEC_ID_VORBIS.equals(track.codecId)) {
            this.vorbisNumPageSamples.setPosition(0);
            trackOutput.sampleData(this.vorbisNumPageSamples, 4);
            this.sampleBytesWritten += 4;
        }
    }

    private void writeSubtitleSampleData(ExtractorInput extractorInput, byte[] bArr, int i3) throws IOException, InterruptedException {
        int length = bArr.length + i3;
        if (this.subtitleSample.capacity() < length) {
            this.subtitleSample.data = Arrays.copyOf(bArr, length + i3);
        } else {
            System.arraycopy(bArr, 0, this.subtitleSample.data, 0, bArr.length);
        }
        extractorInput.readFully(this.subtitleSample.data, bArr.length, i3);
        this.subtitleSample.reset(length);
    }

    void binaryElement(int i3, int i16, ExtractorInput extractorInput) throws IOException, InterruptedException {
        int i17;
        char c16;
        long j3;
        int i18;
        int i19;
        int i26;
        boolean z16;
        int i27;
        int i28;
        int i29 = 0;
        int i36 = 1;
        if (i3 != 161 && i3 != 163) {
            if (i3 != ID_CONTENT_COMPRESSION_SETTINGS) {
                if (i3 != ID_CONTENT_ENCRYPTION_KEY_ID) {
                    if (i3 != ID_SEEK_ID) {
                        if (i3 != ID_CODEC_PRIVATE) {
                            if (i3 == ID_PROJECTION_PRIVATE) {
                                byte[] bArr = new byte[i16];
                                this.currentTrack.projectionData = bArr;
                                extractorInput.readFully(bArr, 0, i16);
                                return;
                            } else {
                                throw new ParserException("Unexpected id: " + i3);
                            }
                        }
                        byte[] bArr2 = new byte[i16];
                        this.currentTrack.codecPrivate = bArr2;
                        extractorInput.readFully(bArr2, 0, i16);
                        return;
                    }
                    Arrays.fill(this.seekEntryIdBytes.data, (byte) 0);
                    extractorInput.readFully(this.seekEntryIdBytes.data, 4 - i16, i16);
                    this.seekEntryIdBytes.setPosition(0);
                    this.seekEntryId = (int) this.seekEntryIdBytes.readUnsignedInt();
                    return;
                }
                byte[] bArr3 = new byte[i16];
                extractorInput.readFully(bArr3, 0, i16);
                this.currentTrack.cryptoData = new TrackOutput.CryptoData(1, bArr3, 0, 0);
                return;
            }
            byte[] bArr4 = new byte[i16];
            this.currentTrack.sampleStrippedBytes = bArr4;
            extractorInput.readFully(bArr4, 0, i16);
            return;
        }
        if (this.blockState == 0) {
            this.blockTrackNumber = (int) this.varintReader.readUnsignedVarint(extractorInput, false, true, 8);
            this.blockTrackNumberLength = this.varintReader.getLastLength();
            this.blockDurationUs = -9223372036854775807L;
            this.blockState = 1;
            this.scratch.reset();
        }
        Track track = this.tracks.get(this.blockTrackNumber);
        if (track == null) {
            extractorInput.skipFully(i16 - this.blockTrackNumberLength);
            this.blockState = 0;
            return;
        }
        if (this.blockState == 1) {
            readScratch(extractorInput, 3);
            int i37 = (this.scratch.data[2] & 6) >> 1;
            byte b16 = 255;
            if (i37 == 0) {
                this.blockLacingSampleCount = 1;
                int[] ensureArrayCapacity = ensureArrayCapacity(this.blockLacingSampleSizes, 1);
                this.blockLacingSampleSizes = ensureArrayCapacity;
                ensureArrayCapacity[0] = (i16 - this.blockTrackNumberLength) - 3;
            } else if (i3 == 163) {
                int i38 = 4;
                readScratch(extractorInput, 4);
                int i39 = (this.scratch.data[3] & 255) + 1;
                this.blockLacingSampleCount = i39;
                int[] ensureArrayCapacity2 = ensureArrayCapacity(this.blockLacingSampleSizes, i39);
                this.blockLacingSampleSizes = ensureArrayCapacity2;
                if (i37 == 2) {
                    int i46 = (i16 - this.blockTrackNumberLength) - 4;
                    int i47 = this.blockLacingSampleCount;
                    Arrays.fill(ensureArrayCapacity2, 0, i47, i46 / i47);
                } else if (i37 == 1) {
                    int i48 = 0;
                    int i49 = 0;
                    while (true) {
                        i18 = this.blockLacingSampleCount;
                        if (i48 >= i18 - 1) {
                            break;
                        }
                        this.blockLacingSampleSizes[i48] = 0;
                        do {
                            i38++;
                            readScratch(extractorInput, i38);
                            i19 = this.scratch.data[i38 - 1] & 255;
                            int[] iArr = this.blockLacingSampleSizes;
                            i26 = iArr[i48] + i19;
                            iArr[i48] = i26;
                        } while (i19 == 255);
                        i49 += i26;
                        i48++;
                    }
                    this.blockLacingSampleSizes[i18 - 1] = ((i16 - this.blockTrackNumberLength) - i38) - i49;
                } else {
                    if (i37 == 3) {
                        int i56 = 0;
                        int i57 = 0;
                        while (true) {
                            int i58 = this.blockLacingSampleCount;
                            if (i56 < i58 - 1) {
                                this.blockLacingSampleSizes[i56] = i29;
                                i38++;
                                readScratch(extractorInput, i38);
                                int i59 = i38 - 1;
                                if (this.scratch.data[i59] != 0) {
                                    int i65 = i29;
                                    while (true) {
                                        if (i65 < 8) {
                                            int i66 = i36 << (7 - i65);
                                            if ((this.scratch.data[i59] & i66) != 0) {
                                                i38 += i65;
                                                readScratch(extractorInput, i38);
                                                j3 = (~i66) & this.scratch.data[i59] & b16;
                                                int i67 = i59 + 1;
                                                while (i67 < i38) {
                                                    j3 = (j3 << 8) | (this.scratch.data[i67] & b16);
                                                    i67++;
                                                    b16 = 255;
                                                }
                                                if (i56 > 0) {
                                                    j3 -= (1 << ((i65 * 7) + 6)) - 1;
                                                }
                                            } else {
                                                i65++;
                                                i36 = 1;
                                                b16 = 255;
                                            }
                                        } else {
                                            j3 = 0;
                                            break;
                                        }
                                    }
                                    if (j3 < WebViewConstants.WV.ENABLE_WEBAIO_SWITCH || j3 > TTL.MAX_VALUE) {
                                        break;
                                    }
                                    int i68 = (int) j3;
                                    int[] iArr2 = this.blockLacingSampleSizes;
                                    if (i56 != 0) {
                                        i68 += iArr2[i56 - 1];
                                    }
                                    iArr2[i56] = i68;
                                    i57 += i68;
                                    i56++;
                                    i29 = 0;
                                    i36 = 1;
                                    b16 = 255;
                                } else {
                                    throw new ParserException("No valid varint length mask found");
                                }
                            } else {
                                c16 = 1;
                                this.blockLacingSampleSizes[i58 - 1] = ((i16 - this.blockTrackNumberLength) - i38) - i57;
                                break;
                            }
                        }
                        throw new ParserException("EBML lacing sample size out of range.");
                    }
                    throw new ParserException("Unexpected lacing value: " + i37);
                }
            } else {
                throw new ParserException("Lacing only supported in SimpleBlocks.");
            }
            c16 = 1;
            byte[] bArr5 = this.scratch.data;
            this.blockTimeUs = this.clusterTimecodeUs + scaleTimecodeToUs((bArr5[c16] & 255) | (bArr5[0] << 8));
            byte b17 = this.scratch.data[2];
            if ((b17 & 8) == 8) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (track.type != 2 && (i3 != 163 || (b17 & 128) != 128)) {
                i27 = 0;
            } else {
                i27 = 1;
            }
            if (z16) {
                i28 = Integer.MIN_VALUE;
            } else {
                i28 = 0;
            }
            this.blockFlags = i27 | i28;
            this.blockState = 2;
            this.blockLacingSampleIndex = 0;
            i17 = 163;
        } else {
            i17 = 163;
        }
        if (i3 != i17) {
            writeSampleData(extractorInput, track, this.blockLacingSampleSizes[0]);
            return;
        }
        while (true) {
            int i69 = this.blockLacingSampleIndex;
            if (i69 < this.blockLacingSampleCount) {
                writeSampleData(extractorInput, track, this.blockLacingSampleSizes[i69]);
                commitSampleToOutput(track, this.blockTimeUs + ((this.blockLacingSampleIndex * track.defaultSampleDurationNs) / 1000));
                this.blockLacingSampleIndex++;
            } else {
                this.blockState = 0;
                return;
            }
        }
    }

    void endMasterElement(int i3) throws ParserException {
        if (i3 != 160) {
            if (i3 != 174) {
                if (i3 != ID_SEEK) {
                    if (i3 != ID_CONTENT_ENCODING) {
                        if (i3 != ID_CONTENT_ENCODINGS) {
                            if (i3 != 357149030) {
                                if (i3 != ID_TRACKS) {
                                    if (i3 == ID_CUES && !this.sentSeekMap) {
                                        this.extractorOutput.seekMap(buildSeekMap());
                                        this.sentSeekMap = true;
                                        return;
                                    }
                                    return;
                                }
                                if (this.tracks.size() != 0) {
                                    this.extractorOutput.endTracks();
                                    return;
                                }
                                throw new ParserException("No valid tracks were found");
                            }
                            if (this.timecodeScale == -9223372036854775807L) {
                                this.timecodeScale = 1000000L;
                            }
                            long j3 = this.durationTimecode;
                            if (j3 != -9223372036854775807L) {
                                this.durationUs = scaleTimecodeToUs(j3);
                                return;
                            }
                            return;
                        }
                        Track track = this.currentTrack;
                        if (track.hasContentEncryption && track.sampleStrippedBytes != null) {
                            throw new ParserException("Combining encryption and compression is not supported");
                        }
                        return;
                    }
                    Track track2 = this.currentTrack;
                    if (track2.hasContentEncryption) {
                        if (track2.cryptoData != null) {
                            track2.drmInitData = new DrmInitData(new DrmInitData.SchemeData(C.UUID_NIL, "video/webm", this.currentTrack.cryptoData.encryptionKey));
                            return;
                        }
                        throw new ParserException("Encrypted Track found but ContentEncKeyID was not found");
                    }
                    return;
                }
                int i16 = this.seekEntryId;
                if (i16 != -1) {
                    long j16 = this.seekEntryPosition;
                    if (j16 != -1) {
                        if (i16 == ID_CUES) {
                            this.cuesContentPosition = j16;
                            return;
                        }
                        return;
                    }
                }
                throw new ParserException("Mandatory element SeekID or SeekPosition not found");
            }
            if (isCodecSupported(this.currentTrack.codecId)) {
                Track track3 = this.currentTrack;
                track3.initializeOutput(this.extractorOutput, track3.number);
                SparseArray<Track> sparseArray = this.tracks;
                Track track4 = this.currentTrack;
                sparseArray.put(track4.number, track4);
            }
            this.currentTrack = null;
            return;
        }
        if (this.blockState != 2) {
            return;
        }
        if (!this.sampleSeenReferenceBlock) {
            this.blockFlags |= 1;
        }
        commitSampleToOutput(this.tracks.get(this.blockTrackNumber), this.blockTimeUs);
        this.blockState = 0;
    }

    void floatElement(int i3, double d16) {
        if (i3 != 181) {
            if (i3 != ID_DURATION) {
                switch (i3) {
                    case ID_PRIMARY_R_CHROMATICITY_X /* 21969 */:
                        this.currentTrack.primaryRChromaticityX = (float) d16;
                        return;
                    case ID_PRIMARY_R_CHROMATICITY_Y /* 21970 */:
                        this.currentTrack.primaryRChromaticityY = (float) d16;
                        return;
                    case ID_PRIMARY_G_CHROMATICITY_X /* 21971 */:
                        this.currentTrack.primaryGChromaticityX = (float) d16;
                        return;
                    case ID_PRIMARY_G_CHROMATICITY_Y /* 21972 */:
                        this.currentTrack.primaryGChromaticityY = (float) d16;
                        return;
                    case ID_PRIMARY_B_CHROMATICITY_X /* 21973 */:
                        this.currentTrack.primaryBChromaticityX = (float) d16;
                        return;
                    case ID_PRIMARY_B_CHROMATICITY_Y /* 21974 */:
                        this.currentTrack.primaryBChromaticityY = (float) d16;
                        return;
                    case ID_WHITE_POINT_CHROMATICITY_X /* 21975 */:
                        this.currentTrack.whitePointChromaticityX = (float) d16;
                        return;
                    case ID_WHITE_POINT_CHROMATICITY_Y /* 21976 */:
                        this.currentTrack.whitePointChromaticityY = (float) d16;
                        return;
                    case ID_LUMNINANCE_MAX /* 21977 */:
                        this.currentTrack.maxMasteringLuminance = (float) d16;
                        return;
                    case ID_LUMNINANCE_MIN /* 21978 */:
                        this.currentTrack.minMasteringLuminance = (float) d16;
                        return;
                    default:
                        return;
                }
            }
            this.durationTimecode = (long) d16;
            return;
        }
        this.currentTrack.sampleRate = (int) d16;
    }

    int getElementType(int i3) {
        switch (i3) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case ID_CONTENT_COMPRESSION_ALGORITHM /* 16980 */:
            case ID_DOC_TYPE_READ_VERSION /* 17029 */:
            case ID_EBML_READ_VERSION /* 17143 */:
            case ID_CONTENT_ENCRYPTION_ALGORITHM /* 18401 */:
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /* 18408 */:
            case ID_CONTENT_ENCODING_ORDER /* 20529 */:
            case ID_CONTENT_ENCODING_SCOPE /* 20530 */:
            case ID_SEEK_POSITION /* 21420 */:
            case ID_STEREO_MODE /* 21432 */:
            case ID_DISPLAY_WIDTH /* 21680 */:
            case ID_DISPLAY_UNIT /* 21682 */:
            case ID_DISPLAY_HEIGHT /* 21690 */:
            case ID_FLAG_FORCED /* 21930 */:
            case ID_COLOUR_RANGE /* 21945 */:
            case ID_COLOUR_TRANSFER /* 21946 */:
            case ID_COLOUR_PRIMARIES /* 21947 */:
            case ID_MAX_CLL /* 21948 */:
            case ID_MAX_FALL /* 21949 */:
            case ID_CODEC_DELAY /* 22186 */:
            case ID_SEEK_PRE_ROLL /* 22203 */:
            case ID_AUDIO_BIT_DEPTH /* 25188 */:
            case ID_DEFAULT_DURATION /* 2352003 */:
            case ID_TIMECODE_SCALE /* 2807729 */:
                return 2;
            case 134:
            case ID_DOC_TYPE /* 17026 */:
            case ID_LANGUAGE /* 2274716 */:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case ID_CONTENT_ENCRYPTION_AES_SETTINGS /* 18407 */:
            case ID_SEEK /* 19899 */:
            case ID_CONTENT_COMPRESSION /* 20532 */:
            case ID_CONTENT_ENCRYPTION /* 20533 */:
            case ID_COLOUR /* 21936 */:
            case ID_MASTERING_METADATA /* 21968 */:
            case ID_CONTENT_ENCODING /* 25152 */:
            case ID_CONTENT_ENCODINGS /* 28032 */:
            case ID_PROJECTION /* 30320 */:
            case ID_SEEK_HEAD /* 290298740 */:
            case 357149030:
            case ID_TRACKS /* 374648427 */:
            case ID_SEGMENT /* 408125543 */:
            case ID_EBML /* 440786851 */:
            case ID_CUES /* 475249515 */:
            case ID_CLUSTER /* 524531317 */:
                return 1;
            case 161:
            case 163:
            case ID_CONTENT_COMPRESSION_SETTINGS /* 16981 */:
            case ID_CONTENT_ENCRYPTION_KEY_ID /* 18402 */:
            case ID_SEEK_ID /* 21419 */:
            case ID_CODEC_PRIVATE /* 25506 */:
            case ID_PROJECTION_PRIVATE /* 30322 */:
                return 4;
            case 181:
            case ID_DURATION /* 17545 */:
            case ID_PRIMARY_R_CHROMATICITY_X /* 21969 */:
            case ID_PRIMARY_R_CHROMATICITY_Y /* 21970 */:
            case ID_PRIMARY_G_CHROMATICITY_X /* 21971 */:
            case ID_PRIMARY_G_CHROMATICITY_Y /* 21972 */:
            case ID_PRIMARY_B_CHROMATICITY_X /* 21973 */:
            case ID_PRIMARY_B_CHROMATICITY_Y /* 21974 */:
            case ID_WHITE_POINT_CHROMATICITY_X /* 21975 */:
            case ID_WHITE_POINT_CHROMATICITY_Y /* 21976 */:
            case ID_LUMNINANCE_MAX /* 21977 */:
            case ID_LUMNINANCE_MIN /* 21978 */:
                return 5;
            default:
                return 0;
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.extractorOutput = extractorOutput;
    }

    void integerElement(int i3, long j3) throws ParserException {
        if (i3 != ID_CONTENT_ENCODING_ORDER) {
            if (i3 != ID_CONTENT_ENCODING_SCOPE) {
                boolean z16 = false;
                switch (i3) {
                    case 131:
                        this.currentTrack.type = (int) j3;
                        return;
                    case 136:
                        Track track = this.currentTrack;
                        if (j3 == 1) {
                            z16 = true;
                        }
                        track.flagForced = z16;
                        return;
                    case 155:
                        this.blockDurationUs = scaleTimecodeToUs(j3);
                        return;
                    case 159:
                        this.currentTrack.channelCount = (int) j3;
                        return;
                    case 176:
                        this.currentTrack.width = (int) j3;
                        return;
                    case 179:
                        this.cueTimesUs.add(scaleTimecodeToUs(j3));
                        return;
                    case 186:
                        this.currentTrack.height = (int) j3;
                        return;
                    case 215:
                        this.currentTrack.number = (int) j3;
                        return;
                    case 231:
                        this.clusterTimecodeUs = scaleTimecodeToUs(j3);
                        return;
                    case 241:
                        if (!this.seenClusterPositionForCurrentCuePoint) {
                            this.cueClusterPositions.add(j3);
                            this.seenClusterPositionForCurrentCuePoint = true;
                            return;
                        }
                        return;
                    case 251:
                        this.sampleSeenReferenceBlock = true;
                        return;
                    case ID_CONTENT_COMPRESSION_ALGORITHM /* 16980 */:
                        if (j3 != 3) {
                            throw new ParserException("ContentCompAlgo " + j3 + " not supported");
                        }
                        return;
                    case ID_DOC_TYPE_READ_VERSION /* 17029 */:
                        if (j3 < 1 || j3 > 2) {
                            throw new ParserException("DocTypeReadVersion " + j3 + " not supported");
                        }
                        return;
                    case ID_EBML_READ_VERSION /* 17143 */:
                        if (j3 != 1) {
                            throw new ParserException("EBMLReadVersion " + j3 + " not supported");
                        }
                        return;
                    case ID_CONTENT_ENCRYPTION_ALGORITHM /* 18401 */:
                        if (j3 != 5) {
                            throw new ParserException("ContentEncAlgo " + j3 + " not supported");
                        }
                        return;
                    case ID_CONTENT_ENCRYPTION_AES_SETTINGS_CIPHER_MODE /* 18408 */:
                        if (j3 != 1) {
                            throw new ParserException("AESSettingsCipherMode " + j3 + " not supported");
                        }
                        return;
                    case ID_SEEK_POSITION /* 21420 */:
                        this.seekEntryPosition = j3 + this.segmentContentPosition;
                        return;
                    case ID_STEREO_MODE /* 21432 */:
                        int i16 = (int) j3;
                        if (i16 != 0) {
                            if (i16 != 1) {
                                if (i16 != 3) {
                                    if (i16 == 15) {
                                        this.currentTrack.stereoMode = 3;
                                        return;
                                    }
                                    return;
                                }
                                this.currentTrack.stereoMode = 1;
                                return;
                            }
                            this.currentTrack.stereoMode = 2;
                            return;
                        }
                        this.currentTrack.stereoMode = 0;
                        return;
                    case ID_DISPLAY_WIDTH /* 21680 */:
                        this.currentTrack.displayWidth = (int) j3;
                        return;
                    case ID_DISPLAY_UNIT /* 21682 */:
                        this.currentTrack.displayUnit = (int) j3;
                        return;
                    case ID_DISPLAY_HEIGHT /* 21690 */:
                        this.currentTrack.displayHeight = (int) j3;
                        return;
                    case ID_FLAG_FORCED /* 21930 */:
                        Track track2 = this.currentTrack;
                        if (j3 == 1) {
                            z16 = true;
                        }
                        track2.flagDefault = z16;
                        return;
                    case ID_CODEC_DELAY /* 22186 */:
                        this.currentTrack.codecDelayNs = j3;
                        return;
                    case ID_SEEK_PRE_ROLL /* 22203 */:
                        this.currentTrack.seekPreRollNs = j3;
                        return;
                    case ID_AUDIO_BIT_DEPTH /* 25188 */:
                        this.currentTrack.audioBitDepth = (int) j3;
                        return;
                    case ID_DEFAULT_DURATION /* 2352003 */:
                        this.currentTrack.defaultSampleDurationNs = (int) j3;
                        return;
                    case ID_TIMECODE_SCALE /* 2807729 */:
                        this.timecodeScale = j3;
                        return;
                    default:
                        switch (i3) {
                            case ID_COLOUR_RANGE /* 21945 */:
                                int i17 = (int) j3;
                                if (i17 != 1) {
                                    if (i17 == 2) {
                                        this.currentTrack.colorRange = 1;
                                        return;
                                    }
                                    return;
                                }
                                this.currentTrack.colorRange = 2;
                                return;
                            case ID_COLOUR_TRANSFER /* 21946 */:
                                int i18 = (int) j3;
                                if (i18 != 1) {
                                    if (i18 != 16) {
                                        if (i18 != 18) {
                                            if (i18 != 6 && i18 != 7) {
                                                return;
                                            }
                                        } else {
                                            this.currentTrack.colorTransfer = 7;
                                            return;
                                        }
                                    } else {
                                        this.currentTrack.colorTransfer = 6;
                                        return;
                                    }
                                }
                                this.currentTrack.colorTransfer = 3;
                                return;
                            case ID_COLOUR_PRIMARIES /* 21947 */:
                                Track track3 = this.currentTrack;
                                track3.hasColorInfo = true;
                                int i19 = (int) j3;
                                if (i19 != 1) {
                                    if (i19 != 9) {
                                        if (i19 == 4 || i19 == 5 || i19 == 6 || i19 == 7) {
                                            track3.colorSpace = 2;
                                            return;
                                        }
                                        return;
                                    }
                                    track3.colorSpace = 6;
                                    return;
                                }
                                track3.colorSpace = 1;
                                return;
                            case ID_MAX_CLL /* 21948 */:
                                this.currentTrack.maxContentLuminance = (int) j3;
                                return;
                            case ID_MAX_FALL /* 21949 */:
                                this.currentTrack.maxFrameAverageLuminance = (int) j3;
                                return;
                            default:
                                return;
                        }
                }
            }
            if (j3 != 1) {
                throw new ParserException("ContentEncodingScope " + j3 + " not supported");
            }
            return;
        }
        if (j3 == 0) {
            return;
        }
        throw new ParserException("ContentEncodingOrder " + j3 + " not supported");
    }

    boolean isLevel1Element(int i3) {
        if (i3 != 357149030 && i3 != ID_CLUSTER && i3 != ID_CUES && i3 != ID_TRACKS) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        this.sampleRead = false;
        boolean z16 = true;
        while (z16 && !this.sampleRead) {
            z16 = this.reader.read(extractorInput);
            if (z16 && maybeSeekForCues(positionHolder, extractorInput.getPosition())) {
                return 1;
            }
        }
        if (z16) {
            return 0;
        }
        for (int i3 = 0; i3 < this.tracks.size(); i3++) {
            this.tracks.valueAt(i3).outputPendingSampleMetadata();
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j3, long j16) {
        this.clusterTimecodeUs = -9223372036854775807L;
        this.blockState = 0;
        this.reader.reset();
        this.varintReader.reset();
        resetSample();
        for (int i3 = 0; i3 < this.tracks.size(); i3++) {
            this.tracks.valueAt(i3).reset();
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        return new Sniffer().sniff(extractorInput);
    }

    void startMasterElement(int i3, long j3, long j16) throws ParserException {
        if (i3 != 160) {
            if (i3 != 174) {
                if (i3 != 187) {
                    if (i3 != ID_SEEK) {
                        if (i3 != ID_CONTENT_ENCRYPTION) {
                            if (i3 != ID_MASTERING_METADATA) {
                                if (i3 != ID_SEGMENT) {
                                    if (i3 != ID_CUES) {
                                        if (i3 == ID_CLUSTER && !this.sentSeekMap) {
                                            if (this.seekForCuesEnabled && this.cuesContentPosition != -1) {
                                                this.seekForCues = true;
                                                return;
                                            } else {
                                                this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs));
                                                this.sentSeekMap = true;
                                                return;
                                            }
                                        }
                                        return;
                                    }
                                    this.cueTimesUs = new LongArray();
                                    this.cueClusterPositions = new LongArray();
                                    return;
                                }
                                long j17 = this.segmentContentPosition;
                                if (j17 != -1 && j17 != j3) {
                                    throw new ParserException("Multiple Segment elements not supported");
                                }
                                this.segmentContentPosition = j3;
                                this.segmentContentSize = j16;
                                return;
                            }
                            this.currentTrack.hasColorInfo = true;
                            return;
                        }
                        this.currentTrack.hasContentEncryption = true;
                        return;
                    }
                    this.seekEntryId = -1;
                    this.seekEntryPosition = -1L;
                    return;
                }
                this.seenClusterPositionForCurrentCuePoint = false;
                return;
            }
            this.currentTrack = new Track();
            return;
        }
        this.sampleSeenReferenceBlock = false;
    }

    void stringElement(int i3, String str) throws ParserException {
        if (i3 != 134) {
            if (i3 != ID_DOC_TYPE) {
                if (i3 == ID_LANGUAGE) {
                    this.currentTrack.language = str;
                    return;
                }
                return;
            } else {
                if (!DOC_TYPE_WEBM.equals(str) && !DOC_TYPE_MATROSKA.equals(str)) {
                    throw new ParserException("DocType " + str + " not supported");
                }
                return;
            }
        }
        this.currentTrack.codecId = str;
    }

    public MatroskaExtractor(int i3) {
        this(new DefaultEbmlReader(), i3);
    }

    MatroskaExtractor(EbmlReader ebmlReader, int i3) {
        this.segmentContentPosition = -1L;
        this.timecodeScale = -9223372036854775807L;
        this.durationTimecode = -9223372036854775807L;
        this.durationUs = -9223372036854775807L;
        this.cuesContentPosition = -1L;
        this.seekPositionAfterBuildingCues = -1L;
        this.clusterTimecodeUs = -9223372036854775807L;
        this.reader = ebmlReader;
        ebmlReader.init(new InnerEbmlReaderOutput());
        this.seekForCuesEnabled = (i3 & 1) == 0;
        this.varintReader = new VarintReader();
        this.tracks = new SparseArray<>();
        this.scratch = new ParsableByteArray(4);
        this.vorbisNumPageSamples = new ParsableByteArray(ByteBuffer.allocate(4).putInt(-1).array());
        this.seekEntryIdBytes = new ParsableByteArray(4);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.sampleStrippedBytes = new ParsableByteArray();
        this.subtitleSample = new ParsableByteArray();
        this.encryptionInitializationVector = new ParsableByteArray(8);
        this.encryptionSubsampleData = new ParsableByteArray();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }
}
