package com.tencent.mobileqq.qqvideoedit.editor.music.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qqvideoedit.editor.music.VsMusicItemInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class VideoEditorMusicInfo implements Parcelable {
    public static final Parcelable.Creator<VideoEditorMusicInfo> CREATOR = new a();
    public static final List<VideoEditorMusicInfo> D = a();
    public static final VideoEditorMusicInfo E = b();
    public final int C;

    /* renamed from: d, reason: collision with root package name */
    private VsMusicItemInfo f275809d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f275810e;

    /* renamed from: f, reason: collision with root package name */
    public int f275811f;

    /* renamed from: h, reason: collision with root package name */
    public int f275812h;

    /* renamed from: i, reason: collision with root package name */
    public final int f275813i;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f275814m;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    private @interface DownloadStatus {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes17.dex */
    public @interface ItemType {
    }

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements Parcelable.Creator<VideoEditorMusicInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoEditorMusicInfo createFromParcel(Parcel parcel) {
            return new VideoEditorMusicInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VideoEditorMusicInfo[] newArray(int i3) {
            return new VideoEditorMusicInfo[i3];
        }
    }

    protected VideoEditorMusicInfo(Parcel parcel) {
        this.f275812h = 0;
        this.f275809d = (VsMusicItemInfo) parcel.readParcelable(VsMusicItemInfo.class.getClassLoader());
        this.f275810e = parcel.readByte() != 0;
        this.f275811f = parcel.readInt();
        this.f275812h = parcel.readInt();
        this.f275813i = parcel.readInt();
        this.f275814m = parcel.readByte() != 0;
        this.C = parcel.readInt();
    }

    @NonNull
    private static List<VideoEditorMusicInfo> a() {
        VideoEditorMusicInfo videoEditorMusicInfo;
        LinkedList linkedList = new LinkedList();
        int i3 = 0;
        while (i3 < 6) {
            VsMusicItemInfo vsMusicItemInfo = new VsMusicItemInfo();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("fakeMid");
            int i16 = i3 + 1;
            sb5.append(i16);
            vsMusicItemInfo.mSongMid = sb5.toString();
            vsMusicItemInfo.mMusicName = "";
            vsMusicItemInfo.mUrl = "";
            vsMusicItemInfo.mAlbumUrl = "";
            if (i3 == 0) {
                videoEditorMusicInfo = new VideoEditorMusicInfo(vsMusicItemInfo, false, 1);
            } else {
                videoEditorMusicInfo = new VideoEditorMusicInfo(vsMusicItemInfo, false, 0);
            }
            linkedList.add(videoEditorMusicInfo);
            i3 = i16;
        }
        return linkedList;
    }

    public static VideoEditorMusicInfo b() {
        VsMusicItemInfo vsMusicItemInfo = new VsMusicItemInfo();
        vsMusicItemInfo.mSongMid = "fakeMid_template_bgm";
        vsMusicItemInfo.mMusicName = "";
        vsMusicItemInfo.mUrl = "";
        vsMusicItemInfo.mAlbumUrl = "";
        return new VideoEditorMusicInfo(vsMusicItemInfo, false, 3);
    }

    @NonNull
    public String c() {
        String str;
        VsMusicItemInfo vsMusicItemInfo = this.f275809d;
        if (vsMusicItemInfo == null || (str = vsMusicItemInfo.mSongMid) == null) {
            return "";
        }
        return str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String e() {
        String str;
        VsMusicItemInfo vsMusicItemInfo = this.f275809d;
        if (vsMusicItemInfo == null || (str = vsMusicItemInfo.mMusicName) == null) {
            return "";
        }
        return str;
    }

    @NonNull
    public String f() {
        String str;
        VsMusicItemInfo vsMusicItemInfo = this.f275809d;
        if (vsMusicItemInfo == null || (str = vsMusicItemInfo.mUrl) == null) {
            return "";
        }
        return str;
    }

    @NonNull
    public String toString() {
        return "{songMid:" + c() + ", songName:" + e() + ", songUrl:" + f() + ", selected:" + this.f275810e + ", downloadStatus:" + this.f275811f + ", itemType:" + this.f275813i + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f275809d, i3);
        parcel.writeByte(this.f275810e ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f275811f);
        parcel.writeInt(this.f275812h);
        parcel.writeInt(this.f275813i);
        parcel.writeByte(this.f275814m ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.C);
    }

    public VideoEditorMusicInfo(@NonNull VsMusicItemInfo vsMusicItemInfo, boolean z16, int i3) {
        this(vsMusicItemInfo, z16, i3, false, -1);
    }

    public VideoEditorMusicInfo(@NonNull VsMusicItemInfo vsMusicItemInfo, boolean z16, int i3, boolean z17, int i16) {
        this.f275812h = 0;
        this.f275809d = vsMusicItemInfo;
        this.f275810e = z16;
        this.f275811f = 0;
        this.f275813i = i3;
        this.f275814m = z17;
        this.C = i16;
    }
}
