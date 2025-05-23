package com.tencent.qqmusic.mediaplayer.audioplaylist;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TrackInfo extends AudioPlayListItemInfo {
    public static final Parcelable.Creator<TrackInfo> CREATOR = new Parcelable.Creator<TrackInfo>() { // from class: com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TrackInfo createFromParcel(Parcel parcel) {
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            long readLong = parcel.readLong();
            long readLong2 = parcel.readLong();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            TrackInfo trackInfo = new TrackInfo(readInt);
            trackInfo.setFilePath(readString);
            trackInfo.setTitle(readString2);
            trackInfo.setStartPosition(readLong);
            trackInfo.setEndPostion(readLong2);
            trackInfo.setPerformer(readString3);
            trackInfo.setAlbum(readString4);
            return trackInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public TrackInfo[] newArray(int i3) {
            return new TrackInfo[i3];
        }
    };
    private long mEndPostion;
    private long mStartPosition;
    private String mTitle = "";
    private String mPerformer = "";
    private String mAlbum = "";

    public TrackInfo(int i3) {
        this.mType = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAlbum() {
        return this.mAlbum;
    }

    public String getPerformer() {
        return this.mPerformer;
    }

    public Pair<Long, Long> getRange() {
        return new Pair<>(Long.valueOf(this.mStartPosition), Long.valueOf(this.mEndPostion));
    }

    public String getTitle() {
        return this.mTitle;
    }

    public String getUri() {
        return this.mUri;
    }

    public void setAlbum(String str) {
        this.mAlbum = str;
    }

    public void setEndPostion(long j3) {
        this.mEndPostion = j3;
    }

    public void setFilePath(String str) {
        this.mUri = str;
    }

    public void setPerformer(String str) {
        this.mPerformer = str;
    }

    public void setStartPosition(long j3) {
        this.mStartPosition = j3;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.mType);
        parcel.writeString(this.mUri);
        parcel.writeString(this.mTitle);
        parcel.writeLong(this.mStartPosition);
        parcel.writeLong(this.mEndPostion);
        parcel.writeString(this.mPerformer);
        parcel.writeString(this.mAlbum);
    }
}
