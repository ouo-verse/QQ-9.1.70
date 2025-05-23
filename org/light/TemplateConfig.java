package org.light;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes29.dex */
public class TemplateConfig implements Parcelable {
    public static final Parcelable.Creator<TemplateConfig> CREATOR = new Parcelable.Creator<TemplateConfig>() { // from class: org.light.TemplateConfig.1
        @Override // android.os.Parcelable.Creator
        public TemplateConfig createFromParcel(Parcel parcel) {
            return new TemplateConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public TemplateConfig[] newArray(int i3) {
            return new TemplateConfig[i3];
        }
    };
    public static final int SourceType_MultiMedia = 2;
    public static final int SourceType_Photo = 1;
    public static final int SourceType_Video = 0;
    public String[] cropEvents;
    public int dynamicDurationStretchMode;
    public int headProtectDuration;
    public int imageCropSpace;
    public int maxClipAssetCount;
    public int maxImageDuration;
    public int minClipAssetCount;
    public int minFreezePointInterval;
    public int minImageDuration;
    public int minTotalDuration;
    public int minVideoDuration;
    public float originVolume;
    public long preferredCoverTime;
    public float preferredCoverTimePercent;
    public int type;
    public boolean useDynamicDuration;
    public boolean useInternalRhythm;
    public int videoCropSpace;

    public TemplateConfig(int i3, int i16, int i17, int i18, int i19, int i26, long j3, float f16, float f17, int i27, int i28, String[] strArr, int i29, int i36, boolean z16, int i37, boolean z17, int i38) {
        this.type = i3;
        this.minImageDuration = i16;
        this.maxImageDuration = i17;
        this.minClipAssetCount = i18;
        this.maxClipAssetCount = i19;
        this.minVideoDuration = i26;
        this.preferredCoverTime = j3;
        this.preferredCoverTimePercent = f16;
        this.originVolume = f17;
        this.imageCropSpace = i27;
        this.videoCropSpace = i28;
        this.cropEvents = strArr;
        this.minFreezePointInterval = i29;
        this.headProtectDuration = i36;
        this.useInternalRhythm = z16;
        this.minTotalDuration = i37;
        this.useDynamicDuration = z17;
        this.dynamicDurationStretchMode = i38;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "TemplateConfig{type=" + this.type + ", minClipAssetCount=" + this.minClipAssetCount + ", maxClipAssetCount=" + this.maxClipAssetCount + ", minVideoDuration=" + this.minVideoDuration + ", minImageDuration=" + this.minImageDuration + ", maxImageDuration=" + this.maxImageDuration + ", preferredCoverTime=" + this.preferredCoverTime + ", preferredCoverTimePercent=" + this.preferredCoverTimePercent + ", originVolume=" + this.originVolume + ", imageCropSpace=" + this.imageCropSpace + ", videoCropSpace=" + this.videoCropSpace + ", cropEvents=" + Arrays.toString(this.cropEvents) + ", minFreezePointInterval=" + this.minFreezePointInterval + ", headProtectDuration=" + this.headProtectDuration + ", useInternalRhythm=" + this.useInternalRhythm + ", minTotalDuration=" + this.minTotalDuration + ", useDynamicDuration=" + this.useDynamicDuration + ", dynamicDurationStretchMode=" + this.dynamicDurationStretchMode + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.type);
        parcel.writeInt(this.minClipAssetCount);
        parcel.writeInt(this.maxClipAssetCount);
        parcel.writeInt(this.minVideoDuration);
        parcel.writeInt(this.minImageDuration);
        parcel.writeInt(this.maxImageDuration);
        parcel.writeLong(this.preferredCoverTime);
        parcel.writeFloat(this.preferredCoverTimePercent);
        parcel.writeFloat(this.originVolume);
        parcel.writeInt(this.imageCropSpace);
        parcel.writeInt(this.videoCropSpace);
        String[] strArr = this.cropEvents;
        if (strArr == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(strArr.length);
            parcel.writeStringArray(this.cropEvents);
        }
        parcel.writeInt(this.minFreezePointInterval);
        parcel.writeInt(this.headProtectDuration);
        parcel.writeByte(this.useInternalRhythm ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.minTotalDuration);
        parcel.writeByte(this.useDynamicDuration ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.dynamicDurationStretchMode);
    }

    protected TemplateConfig(Parcel parcel) {
        this.type = 0;
        this.minClipAssetCount = 0;
        this.maxClipAssetCount = 0;
        this.minVideoDuration = 0;
        this.minImageDuration = 0;
        this.maxImageDuration = 0;
        this.preferredCoverTime = 0L;
        this.preferredCoverTimePercent = 0.0f;
        this.originVolume = 0.0f;
        this.imageCropSpace = 0;
        this.videoCropSpace = 0;
        this.cropEvents = null;
        this.minFreezePointInterval = 0;
        this.headProtectDuration = 0;
        this.useInternalRhythm = false;
        this.minTotalDuration = 0;
        this.useDynamicDuration = false;
        this.dynamicDurationStretchMode = 0;
        this.type = parcel.readInt();
        this.minClipAssetCount = parcel.readInt();
        this.maxClipAssetCount = parcel.readInt();
        this.minVideoDuration = parcel.readInt();
        this.minImageDuration = parcel.readInt();
        this.maxImageDuration = parcel.readInt();
        this.preferredCoverTime = parcel.readLong();
        this.preferredCoverTimePercent = parcel.readFloat();
        this.originVolume = parcel.readFloat();
        this.imageCropSpace = parcel.readInt();
        this.videoCropSpace = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            String[] strArr = new String[readInt];
            this.cropEvents = strArr;
            parcel.readStringArray(strArr);
        }
        this.minFreezePointInterval = parcel.readInt();
        this.headProtectDuration = parcel.readInt();
        this.useInternalRhythm = parcel.readByte() != 0;
        this.minTotalDuration = parcel.readInt();
        this.useDynamicDuration = parcel.readByte() != 0;
        this.dynamicDurationStretchMode = parcel.readInt();
    }
}
