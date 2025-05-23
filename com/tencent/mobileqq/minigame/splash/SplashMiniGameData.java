package com.tencent.mobileqq.minigame.splash;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class SplashMiniGameData implements Parcelable {
    public static final Parcelable.Creator<SplashMiniGameData> CREATOR = new Parcelable.Creator<SplashMiniGameData>() { // from class: com.tencent.mobileqq.minigame.splash.SplashMiniGameData.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SplashMiniGameData createFromParcel(Parcel parcel) {
            return new SplashMiniGameData(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SplashMiniGameData[] newArray(int i3) {
            return new SplashMiniGameData[i3];
        }
    };
    public String appId;
    public String desc;
    public String developerDesc;
    public ArrayList<String> downloadFileDomianList;
    public String downloadUrl;
    public int enable;
    public long endTime;
    public int fileSize;
    public int guide;
    public String iconUrl;
    public Boolean isPlayed;
    public String name;
    public String picLocalPath;
    public String picUrl;
    public int priority;
    public ArrayList<String> requestDomianList;
    public long startTime;
    public String version;
    public int videoDuration;
    public String videoLocalPath;
    public int videoMute;
    public String videoUrl;

    public SplashMiniGameData() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SplashMiniGameData{isPlayed=" + this.isPlayed + ", videoUrl='" + this.videoUrl + "', videoDuration=" + this.videoDuration + ", videoMute=" + this.videoMute + ", videoLocalPath='" + this.videoLocalPath + "', picUrl='" + this.picUrl + "', picLocalPath='" + this.picLocalPath + "', enable=" + this.enable + ", guide=" + this.guide + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", priority=" + this.priority + ", appId='" + this.appId + "', version='" + this.version + "', downloadUrl='" + this.downloadUrl + "', fileSize=" + this.fileSize + ", iconUrl='" + this.iconUrl + "', name='" + this.name + "', desc='" + this.desc + "', developerDesc='" + this.developerDesc + "', downloadFileDomianList=" + this.downloadFileDomianList + ", requestDomianList=" + this.requestDomianList + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i16;
        Boolean bool = this.isPlayed;
        if (bool == null) {
            i16 = 0;
        } else if (bool.booleanValue()) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        parcel.writeByte((byte) i16);
        parcel.writeString(this.videoUrl);
        parcel.writeInt(this.videoDuration);
        parcel.writeInt(this.videoMute);
        parcel.writeString(this.videoLocalPath);
        parcel.writeString(this.picUrl);
        parcel.writeString(this.picLocalPath);
        parcel.writeInt(this.enable);
        parcel.writeInt(this.guide);
        parcel.writeLong(this.startTime);
        parcel.writeLong(this.endTime);
        parcel.writeInt(this.priority);
        parcel.writeString(this.appId);
        parcel.writeString(this.version);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.fileSize);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.name);
        parcel.writeString(this.desc);
        parcel.writeString(this.developerDesc);
        parcel.writeStringList(this.downloadFileDomianList);
        parcel.writeStringList(this.requestDomianList);
    }

    protected SplashMiniGameData(Parcel parcel) {
        Boolean valueOf;
        byte readByte = parcel.readByte();
        if (readByte == 0) {
            valueOf = null;
        } else {
            valueOf = Boolean.valueOf(readByte == 1);
        }
        this.isPlayed = valueOf;
        this.videoUrl = parcel.readString();
        this.videoDuration = parcel.readInt();
        this.videoMute = parcel.readInt();
        this.videoLocalPath = parcel.readString();
        this.picUrl = parcel.readString();
        this.picLocalPath = parcel.readString();
        this.enable = parcel.readInt();
        this.guide = parcel.readInt();
        this.startTime = parcel.readLong();
        this.endTime = parcel.readLong();
        this.priority = parcel.readInt();
        this.appId = parcel.readString();
        this.version = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.fileSize = parcel.readInt();
        this.iconUrl = parcel.readString();
        this.name = parcel.readString();
        this.desc = parcel.readString();
        this.developerDesc = parcel.readString();
        this.downloadFileDomianList = parcel.createStringArrayList();
        this.requestDomianList = parcel.createStringArrayList();
    }
}
