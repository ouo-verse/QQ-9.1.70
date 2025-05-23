package com.tencent.mobileqq.wink.editor.music;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$StCommonExt;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;

/* compiled from: P */
/* loaded from: classes21.dex */
public class VsMusicItemInfo extends MusicItemInfo {
    public static final Parcelable.Creator<VsMusicItemInfo> CREATOR = new a();
    public String C;
    public boolean D;
    public String E;
    public String F;
    public String G;
    public String H;

    /* renamed from: d, reason: collision with root package name */
    public String f320651d;

    /* renamed from: e, reason: collision with root package name */
    public String f320652e;

    /* renamed from: f, reason: collision with root package name */
    public long f320653f;

    /* renamed from: h, reason: collision with root package name */
    public int f320654h;

    /* renamed from: i, reason: collision with root package name */
    public int f320655i;

    /* renamed from: m, reason: collision with root package name */
    public String f320656m;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<VsMusicItemInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VsMusicItemInfo createFromParcel(Parcel parcel) {
            return new VsMusicItemInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VsMusicItemInfo[] newArray(int i3) {
            return new VsMusicItemInfo[i3];
        }
    }

    protected VsMusicItemInfo(Parcel parcel) {
        super(parcel);
        this.f320654h = 1;
        this.f320655i = 0;
        this.D = false;
        this.f320652e = parcel.readString();
        this.f320651d = parcel.readString();
        this.f320655i = parcel.readInt();
        this.f320656m = parcel.readString();
        this.C = parcel.readString();
    }

    public void a(QQCircleSmartMatchMusic$MusicInfo qQCircleSmartMatchMusic$MusicInfo) {
        PBRepeatMessageField<FeedCloudCommon$Entry> pBRepeatMessageField;
        this.mSongMid = qQCircleSmartMatchMusic$MusicInfo.songInfo.MID.get();
        this.mType = 5;
        this.mUrl = qQCircleSmartMatchMusic$MusicInfo.songInfo.PlayUrl.get();
        boolean z16 = true;
        if (qQCircleSmartMatchMusic$MusicInfo.songInfo.Copyright.get() != 1) {
            z16 = false;
        }
        this.mHasCopyright = z16;
        this.mSingername = qQCircleSmartMatchMusic$MusicInfo.singerInfo.name.get();
        this.mMusicName = qQCircleSmartMatchMusic$MusicInfo.songInfo.name.get();
        this.f320653f = qQCircleSmartMatchMusic$MusicInfo.songInfo.ID.get();
        this.mAlbumUrl = qQCircleSmartMatchMusic$MusicInfo.albumInfo.picURL.get();
        this.f320652e = qQCircleSmartMatchMusic$MusicInfo.lyricInfo.strLyric.get();
        int i3 = qQCircleSmartMatchMusic$MusicInfo.confInfo.startPos.get();
        this.musicStart = i3;
        if (i3 < 0) {
            this.musicStart = 0;
        }
        this.musicEnd = 0;
        this.f320651d = qQCircleSmartMatchMusic$MusicInfo.lyricInfo.strFormat.get();
        this.mItemId = (int) qQCircleSmartMatchMusic$MusicInfo.lyricInfo.uiSongId.get();
        this.musicDuration = qQCircleSmartMatchMusic$MusicInfo.songInfo.IPlayTime.get() * 1000;
        this.fileSize = qQCircleSmartMatchMusic$MusicInfo.songInfo.ISize.get();
        this.f320655i = qQCircleSmartMatchMusic$MusicInfo.confInfo.isCollected.get();
        this.f320656m = qQCircleSmartMatchMusic$MusicInfo.foreignlyric.strLyric.get();
        this.C = qQCircleSmartMatchMusic$MusicInfo.foreignlyric.strFormat.get();
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = qQCircleSmartMatchMusic$MusicInfo.extInfo;
        if (feedCloudCommon$StCommonExt != null && (pBRepeatMessageField = feedCloudCommon$StCommonExt.mapInfo) != null) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : pBRepeatMessageField.get()) {
                String str = feedCloudCommon$Entry.key.get();
                if ("subscript_url".equals(str)) {
                    this.E = feedCloudCommon$Entry.value.get();
                } else if ("toast_text".equals(str)) {
                    this.F = feedCloudCommon$Entry.value.get();
                } else if ("jump_url".equals(str)) {
                    this.G = feedCloudCommon$Entry.value.get();
                } else if ("tag".equals(str)) {
                    this.H = feedCloudCommon$Entry.value.get();
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f320652e);
        parcel.writeString(this.f320651d);
        parcel.writeInt(this.f320655i);
        parcel.writeString(this.f320656m);
        parcel.writeString(this.C);
    }

    public VsMusicItemInfo() {
        this.f320654h = 1;
        this.f320655i = 0;
        this.D = false;
    }

    public VsMusicItemInfo(QQCircleSmartMatchMusic$MusicInfo qQCircleSmartMatchMusic$MusicInfo) {
        this.f320654h = 1;
        this.f320655i = 0;
        this.D = false;
        if (qQCircleSmartMatchMusic$MusicInfo == null) {
            return;
        }
        a(qQCircleSmartMatchMusic$MusicInfo);
    }
}
