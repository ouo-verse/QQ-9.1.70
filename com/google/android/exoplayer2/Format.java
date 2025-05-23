package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Format implements Parcelable {
    public static final Parcelable.Creator<Format> CREATOR = new Parcelable.Creator<Format>() { // from class: com.google.android.exoplayer2.Format.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Format createFromParcel(Parcel parcel) {
            return new Format(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Format[] newArray(int i3) {
            return new Format[i3];
        }
    };
    public static final int NO_VALUE = -1;
    public static final long OFFSET_SAMPLE_RELATIVE = Long.MAX_VALUE;
    public final int accessibilityChannel;
    public final int bitrate;
    public final int channelCount;
    public final String codecs;
    public final ColorInfo colorInfo;
    public final String containerMimeType;
    public final DrmInitData drmInitData;
    public final int encoderDelay;
    public final int encoderPadding;
    public final float frameRate;
    private int hashCode;
    public final int height;

    /* renamed from: id, reason: collision with root package name */
    public final String f32936id;
    public final List<byte[]> initializationData;
    public final String language;
    public final int maxInputSize;
    public final Metadata metadata;
    public final int pcmEncoding;
    public final float pixelWidthHeightRatio;
    public final byte[] projectionData;
    public final int rotationDegrees;
    public final String sampleMimeType;
    public final int sampleRate;
    public final int selectionFlags;
    public final int stereoMode;
    public final long subsampleOffsetUs;
    public final int width;

    Format(String str, String str2, String str3, String str4, int i3, int i16, int i17, int i18, float f16, int i19, float f17, byte[] bArr, int i26, ColorInfo colorInfo, int i27, int i28, int i29, int i36, int i37, int i38, String str5, int i39, long j3, List<byte[]> list, DrmInitData drmInitData, Metadata metadata) {
        this.f32936id = str;
        this.containerMimeType = str2;
        this.sampleMimeType = str3;
        this.codecs = str4;
        this.bitrate = i3;
        this.maxInputSize = i16;
        this.width = i17;
        this.height = i18;
        this.frameRate = f16;
        this.rotationDegrees = i19;
        this.pixelWidthHeightRatio = f17;
        this.projectionData = bArr;
        this.stereoMode = i26;
        this.colorInfo = colorInfo;
        this.channelCount = i27;
        this.sampleRate = i28;
        this.pcmEncoding = i29;
        this.encoderDelay = i36;
        this.encoderPadding = i37;
        this.selectionFlags = i38;
        this.language = str5;
        this.accessibilityChannel = i39;
        this.subsampleOffsetUs = j3;
        this.initializationData = list == null ? Collections.emptyList() : list;
        this.drmInitData = drmInitData;
        this.metadata = metadata;
    }

    public static Format createAudioContainerFormat(String str, String str2, String str3, String str4, int i3, int i16, int i17, List<byte[]> list, int i18, String str5) {
        return new Format(str, str2, str3, str4, i3, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i16, i17, -1, -1, -1, i18, str5, -1, Long.MAX_VALUE, list, null, null);
    }

    public static Format createAudioSampleFormat(String str, String str2, String str3, int i3, int i16, int i17, int i18, List<byte[]> list, DrmInitData drmInitData, int i19, String str4) {
        return createAudioSampleFormat(str, str2, str3, i3, i16, i17, i18, -1, list, drmInitData, i19, str4);
    }

    public static Format createContainerFormat(String str, String str2, String str3, String str4, int i3, int i16, String str5) {
        return new Format(str, str2, str3, str4, i3, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i16, str5, -1, Long.MAX_VALUE, null, null, null);
    }

    public static Format createImageSampleFormat(String str, String str2, String str3, int i3, int i16, List<byte[]> list, String str4, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i3, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i16, str4, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    public static Format createSampleFormat(String str, String str2, long j3) {
        return new Format(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j3, null, null, null);
    }

    public static Format createTextContainerFormat(String str, String str2, String str3, String str4, int i3, int i16, String str5) {
        return createTextContainerFormat(str, str2, str3, str4, i3, i16, str5, -1);
    }

    public static Format createTextSampleFormat(String str, String str2, int i3, String str3) {
        return createTextSampleFormat(str, str2, i3, str3, null);
    }

    public static Format createVideoContainerFormat(String str, String str2, String str3, String str4, int i3, int i16, int i17, float f16, List<byte[]> list, int i18) {
        return new Format(str, str2, str3, str4, i3, -1, i16, i17, f16, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i18, null, -1, Long.MAX_VALUE, list, null, null);
    }

    public static Format createVideoSampleFormat(String str, String str2, String str3, int i3, int i16, int i17, int i18, float f16, List<byte[]> list, DrmInitData drmInitData) {
        return createVideoSampleFormat(str, str2, str3, i3, i16, i17, i18, f16, list, -1, -1.0f, drmInitData);
    }

    @TargetApi(16)
    private static void maybeSetByteBufferV16(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    @TargetApi(24)
    private static void maybeSetColorInfoV24(MediaFormat mediaFormat, ColorInfo colorInfo) {
        if (colorInfo == null) {
            return;
        }
        maybeSetIntegerV16(mediaFormat, "color-transfer", colorInfo.colorTransfer);
        maybeSetIntegerV16(mediaFormat, "color-standard", colorInfo.colorSpace);
        maybeSetIntegerV16(mediaFormat, "color-range", colorInfo.colorRange);
        maybeSetByteBufferV16(mediaFormat, "hdr-static-info", colorInfo.hdrStaticInfo);
    }

    @TargetApi(16)
    private static void maybeSetFloatV16(MediaFormat mediaFormat, String str, float f16) {
        if (f16 != -1.0f) {
            mediaFormat.setFloat(str, f16);
        }
    }

    @TargetApi(16)
    private static void maybeSetIntegerV16(MediaFormat mediaFormat, String str, int i3) {
        if (i3 != -1) {
            mediaFormat.setInteger(str, i3);
        }
    }

    @TargetApi(16)
    private static void maybeSetStringV16(MediaFormat mediaFormat, String str, String str2) {
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    public static String toLogString(Format format) {
        if (format == null) {
            return "null";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("id=");
        sb5.append(format.f32936id);
        sb5.append(", mimeType=");
        sb5.append(format.sampleMimeType);
        if (format.bitrate != -1) {
            sb5.append(", bitrate=");
            sb5.append(format.bitrate);
        }
        if (format.width != -1 && format.height != -1) {
            sb5.append(", res=");
            sb5.append(format.width);
            sb5.append(HippyTKDListViewAdapter.X);
            sb5.append(format.height);
        }
        if (format.frameRate != -1.0f) {
            sb5.append(", fps=");
            sb5.append(format.frameRate);
        }
        if (format.channelCount != -1) {
            sb5.append(", channels=");
            sb5.append(format.channelCount);
        }
        if (format.sampleRate != -1) {
            sb5.append(", sample_rate=");
            sb5.append(format.sampleRate);
        }
        if (format.language != null) {
            sb5.append(", language=");
            sb5.append(format.language);
        }
        return sb5.toString();
    }

    public Format copyWithContainerInfo(String str, String str2, String str3, int i3, int i16, int i17, int i18, String str4) {
        return new Format(str, this.containerMimeType, str2, str3, i3, this.maxInputSize, i16, i17, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, i18, str4, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public Format copyWithDrmInitData(DrmInitData drmInitData) {
        return new Format(this.f32936id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, drmInitData, this.metadata);
    }

    public Format copyWithGaplessInfo(int i3, int i16) {
        return new Format(this.f32936id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, i3, i16, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public Format copyWithManifestFormatInfo(Format format) {
        if (this == format) {
            return this;
        }
        String str = format.f32936id;
        String str2 = this.codecs;
        if (str2 == null) {
            str2 = format.codecs;
        }
        String str3 = str2;
        int i3 = this.bitrate;
        if (i3 == -1) {
            i3 = format.bitrate;
        }
        int i16 = i3;
        float f16 = this.frameRate;
        if (f16 == -1.0f) {
            f16 = format.frameRate;
        }
        float f17 = f16;
        int i17 = this.selectionFlags | format.selectionFlags;
        String str4 = this.language;
        if (str4 == null) {
            str4 = format.language;
        }
        return new Format(str, this.containerMimeType, this.sampleMimeType, str3, i16, this.maxInputSize, this.width, this.height, f17, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, i17, str4, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, DrmInitData.createSessionCreationData(format.drmInitData, this.drmInitData), this.metadata);
    }

    public Format copyWithMaxInputSize(int i3) {
        return new Format(this.f32936id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, i3, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public Format copyWithMetadata(Metadata metadata) {
        return new Format(this.f32936id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, metadata);
    }

    public Format copyWithRotationDegrees(int i3) {
        return new Format(this.f32936id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, i3, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, this.subsampleOffsetUs, this.initializationData, this.drmInitData, this.metadata);
    }

    public Format copyWithSubsampleOffsetUs(long j3) {
        return new Format(this.f32936id, this.containerMimeType, this.sampleMimeType, this.codecs, this.bitrate, this.maxInputSize, this.width, this.height, this.frameRate, this.rotationDegrees, this.pixelWidthHeightRatio, this.projectionData, this.stereoMode, this.colorInfo, this.channelCount, this.sampleRate, this.pcmEncoding, this.encoderDelay, this.encoderPadding, this.selectionFlags, this.language, this.accessibilityChannel, j3, this.initializationData, this.drmInitData, this.metadata);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && Format.class == obj.getClass()) {
            Format format = (Format) obj;
            if (this.bitrate == format.bitrate && this.maxInputSize == format.maxInputSize && this.width == format.width && this.height == format.height && this.frameRate == format.frameRate && this.rotationDegrees == format.rotationDegrees && this.pixelWidthHeightRatio == format.pixelWidthHeightRatio && this.stereoMode == format.stereoMode && this.channelCount == format.channelCount && this.sampleRate == format.sampleRate && this.pcmEncoding == format.pcmEncoding && this.encoderDelay == format.encoderDelay && this.encoderPadding == format.encoderPadding && this.subsampleOffsetUs == format.subsampleOffsetUs && this.selectionFlags == format.selectionFlags && Util.areEqual(this.f32936id, format.f32936id) && Util.areEqual(this.language, format.language) && this.accessibilityChannel == format.accessibilityChannel && Util.areEqual(this.containerMimeType, format.containerMimeType) && Util.areEqual(this.sampleMimeType, format.sampleMimeType) && Util.areEqual(this.codecs, format.codecs) && Util.areEqual(this.drmInitData, format.drmInitData) && Util.areEqual(this.metadata, format.metadata) && Util.areEqual(this.colorInfo, format.colorInfo) && Arrays.equals(this.projectionData, format.projectionData) && this.initializationData.size() == format.initializationData.size()) {
                for (int i3 = 0; i3 < this.initializationData.size(); i3++) {
                    if (!Arrays.equals(this.initializationData.get(i3), format.initializationData.get(i3))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat getFrameworkMediaFormatV16() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.sampleMimeType);
        maybeSetStringV16(mediaFormat, IjkMediaMeta.IJKM_KEY_LANGUAGE, this.language);
        maybeSetIntegerV16(mediaFormat, "max-input-size", this.maxInputSize);
        maybeSetIntegerV16(mediaFormat, "width", this.width);
        maybeSetIntegerV16(mediaFormat, "height", this.height);
        maybeSetFloatV16(mediaFormat, "frame-rate", this.frameRate);
        maybeSetIntegerV16(mediaFormat, "rotation-degrees", this.rotationDegrees);
        maybeSetIntegerV16(mediaFormat, "channel-count", this.channelCount);
        maybeSetIntegerV16(mediaFormat, "sample-rate", this.sampleRate);
        for (int i3 = 0; i3 < this.initializationData.size(); i3++) {
            mediaFormat.setByteBuffer("csd-" + i3, ByteBuffer.wrap(this.initializationData.get(i3)));
        }
        maybeSetColorInfoV24(mediaFormat, this.colorInfo);
        return mediaFormat;
    }

    public int getPixelCount() {
        int i3;
        int i16 = this.width;
        if (i16 == -1 || (i3 = this.height) == -1) {
            return -1;
        }
        return i16 * i3;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        if (this.hashCode == 0) {
            String str = this.f32936id;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (527 + hashCode) * 31;
            String str2 = this.containerMimeType;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.sampleMimeType;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.codecs;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i19 = (((((((((((i18 + hashCode4) * 31) + this.bitrate) * 31) + this.width) * 31) + this.height) * 31) + this.channelCount) * 31) + this.sampleRate) * 31;
            String str5 = this.language;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int i26 = (((i19 + hashCode5) * 31) + this.accessibilityChannel) * 31;
            DrmInitData drmInitData = this.drmInitData;
            if (drmInitData == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = drmInitData.hashCode();
            }
            int i27 = (i26 + hashCode6) * 31;
            Metadata metadata = this.metadata;
            if (metadata != null) {
                i3 = metadata.hashCode();
            }
            this.hashCode = i27 + i3;
        }
        return this.hashCode;
    }

    public String toString() {
        return "Format(" + this.f32936id + ", " + this.containerMimeType + ", " + this.sampleMimeType + ", " + this.bitrate + ", " + this.language + ", [" + this.width + ", " + this.height + ", " + this.frameRate + "], [" + this.channelCount + ", " + this.sampleRate + "])";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i16;
        parcel.writeString(this.f32936id);
        parcel.writeString(this.containerMimeType);
        parcel.writeString(this.sampleMimeType);
        parcel.writeString(this.codecs);
        parcel.writeInt(this.bitrate);
        parcel.writeInt(this.maxInputSize);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.frameRate);
        parcel.writeInt(this.rotationDegrees);
        parcel.writeFloat(this.pixelWidthHeightRatio);
        if (this.projectionData != null) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        parcel.writeInt(i16);
        byte[] bArr = this.projectionData;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.stereoMode);
        parcel.writeParcelable(this.colorInfo, i3);
        parcel.writeInt(this.channelCount);
        parcel.writeInt(this.sampleRate);
        parcel.writeInt(this.pcmEncoding);
        parcel.writeInt(this.encoderDelay);
        parcel.writeInt(this.encoderPadding);
        parcel.writeInt(this.selectionFlags);
        parcel.writeString(this.language);
        parcel.writeInt(this.accessibilityChannel);
        parcel.writeLong(this.subsampleOffsetUs);
        int size = this.initializationData.size();
        parcel.writeInt(size);
        for (int i17 = 0; i17 < size; i17++) {
            parcel.writeByteArray(this.initializationData.get(i17));
        }
        parcel.writeParcelable(this.drmInitData, 0);
        parcel.writeParcelable(this.metadata, 0);
    }

    public static Format createAudioSampleFormat(String str, String str2, String str3, int i3, int i16, int i17, int i18, int i19, List<byte[]> list, DrmInitData drmInitData, int i26, String str4) {
        return createAudioSampleFormat(str, str2, str3, i3, i16, i17, i18, i19, -1, -1, list, drmInitData, i26, str4, null);
    }

    public static Format createSampleFormat(String str, String str2, String str3, int i3, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i3, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, drmInitData, null);
    }

    public static Format createTextContainerFormat(String str, String str2, String str3, String str4, int i3, int i16, String str5, int i17) {
        return new Format(str, str2, str3, str4, i3, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i16, str5, i17, Long.MAX_VALUE, null, null, null);
    }

    public static Format createTextSampleFormat(String str, String str2, int i3, String str3, DrmInitData drmInitData) {
        return createTextSampleFormat(str, str2, null, -1, i3, str3, -1, drmInitData, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format createVideoSampleFormat(String str, String str2, String str3, int i3, int i16, int i17, int i18, float f16, List<byte[]> list, int i19, float f17, DrmInitData drmInitData) {
        return createVideoSampleFormat(str, str2, str3, i3, i16, i17, i18, f16, list, i19, f17, null, -1, null, drmInitData);
    }

    public static Format createAudioSampleFormat(String str, String str2, String str3, int i3, int i16, int i17, int i18, int i19, int i26, int i27, List<byte[]> list, DrmInitData drmInitData, int i28, String str4, Metadata metadata) {
        return new Format(str, null, str2, str3, i3, i16, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i17, i18, i19, i26, i27, i28, str4, -1, Long.MAX_VALUE, list, drmInitData, metadata);
    }

    public static Format createVideoSampleFormat(String str, String str2, String str3, int i3, int i16, int i17, int i18, float f16, List<byte[]> list, int i19, float f17, byte[] bArr, int i26, ColorInfo colorInfo, DrmInitData drmInitData) {
        return new Format(str, null, str2, str3, i3, i16, i17, i18, f16, i19, f17, bArr, i26, colorInfo, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, drmInitData, null);
    }

    public static Format createTextSampleFormat(String str, String str2, String str3, int i3, int i16, String str4, int i17, DrmInitData drmInitData) {
        return createTextSampleFormat(str, str2, str3, i3, i16, str4, i17, drmInitData, Long.MAX_VALUE, Collections.emptyList());
    }

    public static Format createTextSampleFormat(String str, String str2, String str3, int i3, int i16, String str4, DrmInitData drmInitData, long j3) {
        return createTextSampleFormat(str, str2, str3, i3, i16, str4, -1, drmInitData, j3, Collections.emptyList());
    }

    public static Format createTextSampleFormat(String str, String str2, String str3, int i3, int i16, String str4, int i17, DrmInitData drmInitData, long j3, List<byte[]> list) {
        return new Format(str, null, str2, str3, i3, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i16, str4, i17, j3, list, drmInitData, null);
    }

    Format(Parcel parcel) {
        this.f32936id = parcel.readString();
        this.containerMimeType = parcel.readString();
        this.sampleMimeType = parcel.readString();
        this.codecs = parcel.readString();
        this.bitrate = parcel.readInt();
        this.maxInputSize = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.frameRate = parcel.readFloat();
        this.rotationDegrees = parcel.readInt();
        this.pixelWidthHeightRatio = parcel.readFloat();
        this.projectionData = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.stereoMode = parcel.readInt();
        this.colorInfo = (ColorInfo) parcel.readParcelable(ColorInfo.class.getClassLoader());
        this.channelCount = parcel.readInt();
        this.sampleRate = parcel.readInt();
        this.pcmEncoding = parcel.readInt();
        this.encoderDelay = parcel.readInt();
        this.encoderPadding = parcel.readInt();
        this.selectionFlags = parcel.readInt();
        this.language = parcel.readString();
        this.accessibilityChannel = parcel.readInt();
        this.subsampleOffsetUs = parcel.readLong();
        int readInt = parcel.readInt();
        this.initializationData = new ArrayList(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            this.initializationData.add(parcel.createByteArray());
        }
        this.drmInitData = (DrmInitData) parcel.readParcelable(DrmInitData.class.getClassLoader());
        this.metadata = (Metadata) parcel.readParcelable(Metadata.class.getClassLoader());
    }
}
