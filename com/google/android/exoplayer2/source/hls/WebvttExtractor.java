package com.google.android.exoplayer2.source.hls;

import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.webvtt.WebvttParserUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes2.dex */
final class WebvttExtractor implements Extractor {
    private static final Pattern LOCAL_TIMESTAMP = Pattern.compile("LOCAL:([^,]+)");
    private static final Pattern MEDIA_TIMESTAMP = Pattern.compile("MPEGTS:(\\d+)");
    private final String language;
    private ExtractorOutput output;
    private int sampleSize;
    private final TimestampAdjuster timestampAdjuster;
    private final ParsableByteArray sampleDataWrapper = new ParsableByteArray();
    private byte[] sampleData = new byte[1024];

    public WebvttExtractor(String str, TimestampAdjuster timestampAdjuster) {
        this.language = str;
        this.timestampAdjuster = timestampAdjuster;
    }

    private TrackOutput buildTrackOutput(long j3) {
        TrackOutput track = this.output.track(0, 3);
        track.format(Format.createTextSampleFormat((String) null, "text/vtt", (String) null, -1, 0, this.language, (DrmInitData) null, j3));
        this.output.endTracks();
        return track;
    }

    private void processSample() throws ParserException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.sampleData);
        try {
            WebvttParserUtil.validateWebvttHeaderLine(parsableByteArray);
            long j3 = 0;
            long j16 = 0;
            while (true) {
                String readLine = parsableByteArray.readLine();
                if (!TextUtils.isEmpty(readLine)) {
                    if (readLine.startsWith("X-TIMESTAMP-MAP")) {
                        Matcher matcher = LOCAL_TIMESTAMP.matcher(readLine);
                        if (matcher.find()) {
                            Matcher matcher2 = MEDIA_TIMESTAMP.matcher(readLine);
                            if (matcher2.find()) {
                                j16 = WebvttParserUtil.parseTimestampUs(matcher.group(1));
                                j3 = TimestampAdjuster.ptsToUs(Long.parseLong(matcher2.group(1)));
                            } else {
                                throw new ParserException("X-TIMESTAMP-MAP doesn't contain media timestamp: " + readLine);
                            }
                        } else {
                            throw new ParserException("X-TIMESTAMP-MAP doesn't contain local timestamp: " + readLine);
                        }
                    }
                } else {
                    Matcher findNextCueHeader = WebvttParserUtil.findNextCueHeader(parsableByteArray);
                    if (findNextCueHeader == null) {
                        buildTrackOutput(0L);
                        return;
                    }
                    long parseTimestampUs = WebvttParserUtil.parseTimestampUs(findNextCueHeader.group(1));
                    long adjustTsTimestamp = this.timestampAdjuster.adjustTsTimestamp(TimestampAdjuster.usToPts((j3 + parseTimestampUs) - j16));
                    TrackOutput buildTrackOutput = buildTrackOutput(adjustTsTimestamp - parseTimestampUs);
                    this.sampleDataWrapper.reset(this.sampleData, this.sampleSize);
                    buildTrackOutput.sampleData(this.sampleDataWrapper, this.sampleSize);
                    buildTrackOutput.sampleMetadata(adjustTsTimestamp, 1, this.sampleSize, 0, null);
                    return;
                }
            }
        } catch (SubtitleDecoderException e16) {
            throw new ParserException(e16);
        }
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void init(ExtractorOutput extractorOutput) {
        this.output = extractorOutput;
        extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException, InterruptedException {
        int length;
        int length2 = (int) extractorInput.getLength();
        int i3 = this.sampleSize;
        byte[] bArr = this.sampleData;
        if (i3 == bArr.length) {
            if (length2 != -1) {
                length = length2;
            } else {
                length = bArr.length;
            }
            this.sampleData = Arrays.copyOf(bArr, (length * 3) / 2);
        }
        byte[] bArr2 = this.sampleData;
        int i16 = this.sampleSize;
        int read = extractorInput.read(bArr2, i16, bArr2.length - i16);
        if (read != -1) {
            int i17 = this.sampleSize + read;
            this.sampleSize = i17;
            if (length2 == -1 || i17 != length2) {
                return 0;
            }
        }
        processSample();
        return -1;
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void seek(long j3, long j16) {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public boolean sniff(ExtractorInput extractorInput) throws IOException, InterruptedException {
        throw new IllegalStateException();
    }

    @Override // com.google.android.exoplayer2.extractor.Extractor
    public void release() {
    }
}
