package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.mp3.Mp3Extractor;
import com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor;
import com.google.android.exoplayer2.extractor.ts.Ac3Extractor;
import com.google.android.exoplayer2.extractor.ts.AdtsExtractor;
import com.google.android.exoplayer2.extractor.ts.DefaultTsPayloadReaderFactory;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class DefaultHlsExtractorFactory implements HlsExtractorFactory {
    public static final String AAC_FILE_EXTENSION = ".aac";
    public static final String AC3_FILE_EXTENSION = ".ac3";
    public static final String EC3_FILE_EXTENSION = ".ec3";
    public static final String M4_FILE_EXTENSION_PREFIX = ".m4";
    public static final String MP3_FILE_EXTENSION = ".mp3";
    public static final String MP4_FILE_EXTENSION = ".mp4";
    public static final String MP4_FILE_EXTENSION_PREFIX = ".mp4";
    public static final String VTT_FILE_EXTENSION = ".vtt";
    public static final String WEBVTT_FILE_EXTENSION = ".webvtt";

    @Override // com.google.android.exoplayer2.source.hls.HlsExtractorFactory
    public Pair<Extractor, Boolean> createExtractor(Extractor extractor, Uri uri, Format format, List<Format> list, DrmInitData drmInitData, TimestampAdjuster timestampAdjuster) {
        int i3;
        String lastPathSegment = uri.getLastPathSegment();
        boolean z16 = false;
        if (!"text/vtt".equals(format.sampleMimeType) && !lastPathSegment.endsWith(WEBVTT_FILE_EXTENSION) && !lastPathSegment.endsWith(VTT_FILE_EXTENSION)) {
            if (lastPathSegment.endsWith(AAC_FILE_EXTENSION)) {
                extractor = new AdtsExtractor();
            } else if (!lastPathSegment.endsWith(AC3_FILE_EXTENSION) && !lastPathSegment.endsWith(EC3_FILE_EXTENSION)) {
                if (lastPathSegment.endsWith(MP3_FILE_EXTENSION)) {
                    extractor = new Mp3Extractor(0, 0L);
                } else if (extractor == null) {
                    if (!lastPathSegment.endsWith(".mp4") && !lastPathSegment.startsWith(M4_FILE_EXTENSION_PREFIX, lastPathSegment.length() - 4) && !lastPathSegment.startsWith(".mp4", lastPathSegment.length() - 5)) {
                        if (list != null) {
                            i3 = 48;
                        } else {
                            list = Collections.emptyList();
                            i3 = 16;
                        }
                        String str = format.codecs;
                        if (!TextUtils.isEmpty(str)) {
                            if (!"audio/mp4a-latm".equals(MimeTypes.getAudioMediaMimeType(str))) {
                                i3 |= 2;
                            }
                            if (!"video/avc".equals(MimeTypes.getVideoMediaMimeType(str))) {
                                i3 |= 4;
                            }
                        }
                        extractor = new TsExtractor(2, timestampAdjuster, new DefaultTsPayloadReaderFactory(i3, list));
                    } else {
                        if (list == null) {
                            list = Collections.emptyList();
                        }
                        extractor = new FragmentedMp4Extractor(0, timestampAdjuster, null, drmInitData, list);
                    }
                }
            } else {
                extractor = new Ac3Extractor();
            }
            z16 = true;
        } else {
            extractor = new WebvttExtractor(format.language, timestampAdjuster);
        }
        return Pair.create(extractor, Boolean.valueOf(z16));
    }
}
