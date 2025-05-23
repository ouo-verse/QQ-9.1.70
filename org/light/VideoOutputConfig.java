package org.light;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes29.dex */
public class VideoOutputConfig implements Parcelable {
    public static final Parcelable.Creator<VideoOutputConfig> CREATOR = new Parcelable.Creator<VideoOutputConfig>() { // from class: org.light.VideoOutputConfig.1
        @Override // android.os.Parcelable.Creator
        public VideoOutputConfig createFromParcel(Parcel parcel) {
            return new VideoOutputConfig(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public VideoOutputConfig[] newArray(int i3) {
            return new VideoOutputConfig[i3];
        }
    };
    public float frameRate;
    public int seekTolerance;

    public VideoOutputConfig(float f16, int i3) {
        this.frameRate = f16;
        this.seekTolerance = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeFloat(this.frameRate);
        parcel.writeInt(this.seekTolerance);
    }

    protected VideoOutputConfig(Parcel parcel) {
        this.frameRate = 30.0f;
        this.seekTolerance = 0;
        this.frameRate = parcel.readFloat();
        this.seekTolerance = parcel.readInt();
    }
}
