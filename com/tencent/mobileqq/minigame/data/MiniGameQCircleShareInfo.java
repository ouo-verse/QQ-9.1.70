package com.tencent.mobileqq.minigame.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniGameQCircleShareInfo implements Parcelable {
    public static final Parcelable.Creator<MiniGameQCircleShareInfo> CREATOR = new Parcelable.Creator<MiniGameQCircleShareInfo>() { // from class: com.tencent.mobileqq.minigame.data.MiniGameQCircleShareInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniGameQCircleShareInfo createFromParcel(Parcel parcel) {
            return new MiniGameQCircleShareInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniGameQCircleShareInfo[] newArray(int i3) {
            return new MiniGameQCircleShareInfo[i3];
        }
    };
    public static final int VIDEO_STATE_DOWNLOADING = 3;
    public static final int VIDEO_STATE_ERROR = -1;
    public static final int VIDEO_STATE_LOCAL_VALID = 1;
    public static final int VIDEO_STATE_NEED_DOWNLOAD = 2;
    public static final int VIDEO_STATE_UN_KNOW = 0;
    private String cover;
    private boolean isLandscape;
    private MiniAppInfo miniAppInfo;
    private String tag;
    private String text;
    private String video;
    private String videoPath;
    private int videoState;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes33.dex */
    public @interface VideoState {
    }

    public MiniGameQCircleShareInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getCover() {
        return this.cover;
    }

    public MiniAppInfo getMiniAppInfo() {
        return this.miniAppInfo;
    }

    public String getTag() {
        return this.tag;
    }

    public String getText() {
        return this.text;
    }

    public String getVideo() {
        return this.video;
    }

    public String getVideoPath() {
        return this.videoPath;
    }

    public int getVideoState() {
        return this.videoState;
    }

    public boolean isLandscape() {
        return this.isLandscape;
    }

    public void setCover(String str) {
        this.cover = str;
    }

    public void setLandscape(boolean z16) {
        this.isLandscape = z16;
    }

    public void setMiniAppInfo(MiniAppInfo miniAppInfo) {
        this.miniAppInfo = miniAppInfo;
    }

    public void setTag(String str) {
        this.tag = str;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setVideo(String str) {
        this.video = str;
    }

    public void setVideoPath(String str) {
        this.videoPath = str;
    }

    public void setVideoState(int i3) {
        this.videoState = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.miniAppInfo, i3);
        parcel.writeString(this.text);
        parcel.writeString(this.video);
        parcel.writeString(this.cover);
        parcel.writeString(this.tag);
        parcel.writeByte(this.isLandscape ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.videoState);
        parcel.writeString(this.videoPath);
    }

    protected MiniGameQCircleShareInfo(Parcel parcel) {
        this.miniAppInfo = (MiniAppInfo) parcel.readParcelable(MiniAppInfo.class.getClassLoader());
        this.text = parcel.readString();
        this.video = parcel.readString();
        this.cover = parcel.readString();
        this.tag = parcel.readString();
        this.isLandscape = parcel.readByte() != 0;
        this.videoState = parcel.readInt();
        this.videoPath = parcel.readString();
    }
}
