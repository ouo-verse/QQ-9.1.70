package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class VideoUrl implements Parcelable {
    public static final Parcelable.Creator<VideoUrl> CREATOR = new Parcelable.Creator<VideoUrl>() { // from class: cooperation.qzone.model.VideoUrl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoUrl createFromParcel(Parcel parcel) {
            VideoUrl videoUrl = new VideoUrl();
            videoUrl.url = parcel.readString();
            videoUrl.decoderType = parcel.readInt();
            videoUrl.videoRate = parcel.readInt();
            return videoUrl;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoUrl[] newArray(int i3) {
            return new VideoUrl[i3];
        }
    };
    public int decoderType;
    public String url;
    public int videoRate;

    public VideoUrl() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "VideoUrl [url=" + this.url + ", decoderType=" + this.decoderType + ", videoRate=" + this.videoRate + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.url);
        parcel.writeInt(this.decoderType);
        parcel.writeInt(this.videoRate);
    }

    public VideoUrl(String str) {
        this.url = str;
        this.decoderType = 1;
    }

    public VideoUrl(String str, int i3) {
        this.url = str;
        this.decoderType = i3;
    }

    public VideoUrl(String str, int i3, int i16) {
        this.url = str;
        this.decoderType = i3;
        this.videoRate = i16;
    }
}
