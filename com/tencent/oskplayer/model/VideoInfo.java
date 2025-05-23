package com.tencent.oskplayer.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoInfo implements Parcelable {
    public static final Parcelable.Creator<VideoInfo> CREATOR = new Parcelable.Creator<VideoInfo>() { // from class: com.tencent.oskplayer.model.VideoInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoInfo[] newArray(int i3) {
            return null;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoInfo createFromParcel(Parcel parcel) {
            VideoInfo videoInfo = new VideoInfo(parcel.createStringArray(), parcel.createStringArray(), parcel.readInt());
            videoInfo.setCurrentStream(parcel.readInt());
            videoInfo.setCurrentPosition(parcel.readInt());
            videoInfo.setDurationAllow(parcel.readInt());
            videoInfo.playScene = parcel.readString();
            videoInfo.refer = parcel.readString();
            return videoInfo;
        }
    };
    private int currentPosition;
    private int currentStream;
    private int defaultStream;
    private int durationAllow;
    private String playScene;
    private String refer;
    private String[] streamNames;
    private String[] streamUrls;

    public VideoInfo(String[] strArr, String[] strArr2) {
        this(strArr, strArr2, 0);
    }

    public static void validate(VideoInfo videoInfo) throws IllegalArgumentException {
        String[] strArr;
        if (videoInfo != null) {
            String[] strArr2 = videoInfo.streamNames;
            if (strArr2 != null && (strArr = videoInfo.streamUrls) != null && strArr2.length != 0 && strArr.length != 0 && strArr2.length == strArr.length) {
                int i3 = videoInfo.defaultStream;
                if (i3 >= 0 && i3 < strArr2.length) {
                    return;
                } else {
                    throw new IllegalArgumentException("default stream index out of bound");
                }
            }
            throw new IllegalArgumentException("Illegal streamNames or streamUrls");
        }
        throw new IllegalArgumentException("videoInfo is null");
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getCurrentPosition() {
        return this.currentPosition;
    }

    public int getCurrentStream() {
        return this.currentStream;
    }

    public String getCurrentStreamUrl() {
        return this.streamUrls[this.currentStream];
    }

    public int getDefaultStream() {
        return this.defaultStream;
    }

    public String getDefaultStreamName() {
        String[] strArr = this.streamNames;
        if (strArr != null) {
            int length = strArr.length;
            int i3 = this.defaultStream;
            if (length >= i3 && i3 >= 0) {
                return strArr[i3];
            }
            return null;
        }
        return null;
    }

    public String getDefaultStreamUrl() {
        String[] strArr = this.streamUrls;
        if (strArr != null) {
            int length = strArr.length;
            int i3 = this.defaultStream;
            if (length >= i3 && i3 >= 0) {
                return strArr[i3];
            }
            return null;
        }
        return null;
    }

    public int getDurationAllow() {
        return this.durationAllow;
    }

    public String getPlayScene() {
        return this.playScene;
    }

    public String getRefer() {
        return this.refer;
    }

    public String[] getStreamNames() {
        return this.streamNames;
    }

    public String[] getStreamUrls() {
        return this.streamUrls;
    }

    public void setCurrentPosition(int i3) {
        this.currentPosition = i3;
    }

    public void setCurrentStream(int i3) {
        this.currentStream = i3;
    }

    public void setDurationAllow(int i3) {
        this.durationAllow = i3;
    }

    public void setPlayScene(String str) {
        this.playScene = str;
    }

    public void setRefer(String str) {
        this.refer = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeStringArray(this.streamNames);
        parcel.writeStringArray(this.streamUrls);
        parcel.writeInt(this.defaultStream);
        parcel.writeInt(this.currentStream);
        parcel.writeInt(this.currentPosition);
        parcel.writeInt(this.durationAllow);
        parcel.writeString(this.playScene);
        parcel.writeString(this.refer);
    }

    public VideoInfo(String[] strArr, String[] strArr2, String str, String str2) {
        this(strArr, strArr2, 0, -1, str, str2);
    }

    public VideoInfo(String[] strArr, String[] strArr2, int i3) {
        this(strArr, strArr2, i3, -1);
    }

    public VideoInfo(String[] strArr, String[] strArr2, int i3, int i16) {
        this(strArr, strArr2, i3, i16, "", "");
    }

    public VideoInfo(String[] strArr, String[] strArr2, int i3, int i16, String str, String str2) {
        this.streamNames = strArr;
        this.streamUrls = strArr2;
        this.defaultStream = i3;
        this.currentStream = i3;
        this.currentPosition = 0;
        this.durationAllow = i16;
        this.playScene = str;
        this.refer = str2;
    }
}
