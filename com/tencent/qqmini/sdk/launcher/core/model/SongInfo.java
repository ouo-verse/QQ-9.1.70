package com.tencent.qqmini.sdk.launcher.core.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class SongInfo implements Parcelable {
    public static final Parcelable.Creator<SongInfo> CREATOR = new Parcelable.Creator<SongInfo>() { // from class: com.tencent.qqmini.sdk.launcher.core.model.SongInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SongInfo createFromParcel(Parcel parcel) {
            return new SongInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SongInfo[] newArray(int i3) {
            return new SongInfo[i3];
        }
    };
    public static final int TYPE_BROADCAST_FM = 9;
    public static final int TYPE_NEXT_RADIO = 6;
    public static final int TYPE_NEXT_RADIO_BACKGROUND = 8;
    public static final int TYPE_OUT_MUSIC = 7;
    public static final int TYPE_PROFILE_MUSIC = 10;
    public static final int TYPE_QQMUSIC = 4;
    public static final int TYPE_QQ_MUSIC_BACKGROUND = 3;
    public static final int TYPE_QZVIP_MUSIC_BACKGROUND = 11;
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_UPLOAD_BACKGROUND = 5;
    public String album;
    public String coverUrl;
    public String detailUrl;
    public long duration;
    public boolean fromMini;

    /* renamed from: id, reason: collision with root package name */
    public long f348087id;
    public String mid;
    public String singer;
    public long singerId;
    public int startTime;
    public String summary;
    public String title;
    public int type;
    public long uin;
    public String url;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        float f16;
        parcel.writeString(this.url);
        parcel.writeString(this.title);
        parcel.writeString(this.summary);
        parcel.writeString(this.coverUrl);
        parcel.writeString(this.detailUrl);
        parcel.writeLong(this.f348087id);
        parcel.writeString(this.album);
        parcel.writeString(this.singer);
        parcel.writeInt(this.type);
        parcel.writeLong(this.singerId);
        parcel.writeInt(this.startTime);
        if (this.fromMini) {
            f16 = 1.0f;
        } else {
            f16 = 0.0f;
        }
        parcel.writeFloat(f16);
        parcel.writeLong(this.duration);
        parcel.writeLong(this.uin);
        parcel.writeString(this.mid);
    }

    public SongInfo() {
    }

    public SongInfo(long j3, String str, String str2) {
        this.f348087id = j3;
        this.album = str;
        this.url = str2;
    }

    SongInfo(Parcel parcel) {
        this.url = parcel.readString();
        this.title = parcel.readString();
        this.summary = parcel.readString();
        this.coverUrl = parcel.readString();
        this.detailUrl = parcel.readString();
        this.f348087id = parcel.readLong();
        this.album = parcel.readString();
        this.singer = parcel.readString();
        this.type = parcel.readInt();
        this.singerId = parcel.readLong();
        this.startTime = parcel.readInt();
        this.fromMini = parcel.readFloat() != 0.0f;
        this.duration = parcel.readLong();
        this.uin = parcel.readLong();
        this.mid = parcel.readString();
    }
}
