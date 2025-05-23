package com.google.android.exoplayer2.extractor.mp4;

import android.support.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Track {
    public static final int TRANSFORMATION_CEA608_CDAT = 1;
    public static final int TRANSFORMATION_NONE = 0;
    public final long durationUs;

    @Nullable
    public final long[] editListDurations;

    @Nullable
    public final long[] editListMediaTimes;
    public final Format format;

    /* renamed from: id, reason: collision with root package name */
    public final int f32942id;
    public final long movieTimescale;
    public final int nalUnitLengthFieldLength;

    @Nullable
    private final TrackEncryptionBox[] sampleDescriptionEncryptionBoxes;
    public final int sampleTransformation;
    public final long timescale;
    public final int type;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface Transformation {
    }

    public Track(int i3, int i16, long j3, long j16, long j17, Format format, int i17, @Nullable TrackEncryptionBox[] trackEncryptionBoxArr, int i18, @Nullable long[] jArr, @Nullable long[] jArr2) {
        this.f32942id = i3;
        this.type = i16;
        this.timescale = j3;
        this.movieTimescale = j16;
        this.durationUs = j17;
        this.format = format;
        this.sampleTransformation = i17;
        this.sampleDescriptionEncryptionBoxes = trackEncryptionBoxArr;
        this.nalUnitLengthFieldLength = i18;
        this.editListDurations = jArr;
        this.editListMediaTimes = jArr2;
    }

    public TrackEncryptionBox getSampleDescriptionEncryptionBox(int i3) {
        TrackEncryptionBox[] trackEncryptionBoxArr = this.sampleDescriptionEncryptionBoxes;
        if (trackEncryptionBoxArr == null) {
            return null;
        }
        return trackEncryptionBoxArr[i3];
    }
}
