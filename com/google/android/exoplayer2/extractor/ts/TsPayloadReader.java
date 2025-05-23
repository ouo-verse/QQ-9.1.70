package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public interface TsPayloadReader {

    /* loaded from: classes2.dex */
    public static final class DvbSubtitleInfo {
        public final byte[] initializationData;
        public final String language;
        public final int type;

        public DvbSubtitleInfo(String str, int i3, byte[] bArr) {
            this.language = str;
            this.type = i3;
            this.initializationData = bArr;
        }
    }

    /* loaded from: classes2.dex */
    public static final class EsInfo {
        public final byte[] descriptorBytes;
        public final List<DvbSubtitleInfo> dvbSubtitleInfos;
        public final String language;
        public final int streamType;

        public EsInfo(int i3, String str, List<DvbSubtitleInfo> list, byte[] bArr) {
            List<DvbSubtitleInfo> unmodifiableList;
            this.streamType = i3;
            this.language = str;
            if (list == null) {
                unmodifiableList = Collections.emptyList();
            } else {
                unmodifiableList = Collections.unmodifiableList(list);
            }
            this.dvbSubtitleInfos = unmodifiableList;
            this.descriptorBytes = bArr;
        }
    }

    /* loaded from: classes2.dex */
    public interface Factory {
        SparseArray<TsPayloadReader> createInitialPayloadReaders();

        TsPayloadReader createPayloadReader(int i3, EsInfo esInfo);
    }

    /* loaded from: classes2.dex */
    public static final class TrackIdGenerator {
        private static final int ID_UNSET = Integer.MIN_VALUE;
        private final int firstTrackId;
        private String formatId;
        private final String formatIdPrefix;
        private int trackId;
        private final int trackIdIncrement;

        public TrackIdGenerator(int i3, int i16) {
            this(Integer.MIN_VALUE, i3, i16);
        }

        private void maybeThrowUninitializedError() {
            if (this.trackId != Integer.MIN_VALUE) {
            } else {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void generateNewId() {
            int i3;
            int i16 = this.trackId;
            if (i16 == Integer.MIN_VALUE) {
                i3 = this.firstTrackId;
            } else {
                i3 = i16 + this.trackIdIncrement;
            }
            this.trackId = i3;
            this.formatId = this.formatIdPrefix + this.trackId;
        }

        public String getFormatId() {
            maybeThrowUninitializedError();
            return this.formatId;
        }

        public int getTrackId() {
            maybeThrowUninitializedError();
            return this.trackId;
        }

        public TrackIdGenerator(int i3, int i16, int i17) {
            String str;
            if (i3 != Integer.MIN_VALUE) {
                str = i3 + "/";
            } else {
                str = "";
            }
            this.formatIdPrefix = str;
            this.firstTrackId = i16;
            this.trackIdIncrement = i17;
            this.trackId = Integer.MIN_VALUE;
        }
    }

    void consume(ParsableByteArray parsableByteArray, boolean z16) throws ParserException;

    void init(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TrackIdGenerator trackIdGenerator);

    void seek();
}
