package com.tencent.mobileqq.wink.editor.music.vo;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.wink.editor.music.VsMusicItemInfo;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.qcircle.weseevideo.editor.sticker.music.LyricParseHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkEditorMusicInfo implements Parcelable {
    public final int C;
    public String D;
    public String E;
    public boolean F;
    public com.tencent.mobileqq.wink.editor.music.vo.a G;

    /* renamed from: d, reason: collision with root package name */
    private VsMusicItemInfo f321258d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f321259e;

    /* renamed from: f, reason: collision with root package name */
    public int f321260f;

    /* renamed from: h, reason: collision with root package name */
    public int f321261h;

    /* renamed from: i, reason: collision with root package name */
    public final int f321262i;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f321263m;
    public static final Long H = -1L;
    public static final Parcelable.Creator<WinkEditorMusicInfo> CREATOR = new a();
    public static final List<WinkEditorMusicInfo> I = a("FAKE_CATEGORY_RECOMMEND_ID");
    public static final WinkEditorMusicInfo J = b();

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes21.dex */
    private @interface DownloadStatus {
    }

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes21.dex */
    public @interface ItemType {
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<WinkEditorMusicInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WinkEditorMusicInfo createFromParcel(Parcel parcel) {
            return new WinkEditorMusicInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WinkEditorMusicInfo[] newArray(int i3) {
            return new WinkEditorMusicInfo[i3];
        }
    }

    protected WinkEditorMusicInfo(Parcel parcel) {
        this.f321261h = 0;
        this.D = "";
        this.E = "";
        this.F = false;
        this.G = null;
        this.f321258d = (VsMusicItemInfo) parcel.readParcelable(VsMusicItemInfo.class.getClassLoader());
        this.f321259e = parcel.readByte() != 0;
        this.f321260f = parcel.readInt();
        this.f321261h = parcel.readInt();
        this.f321262i = parcel.readInt();
        this.f321263m = parcel.readByte() != 0;
        this.C = parcel.readInt();
    }

    @NonNull
    public static List<WinkEditorMusicInfo> a(String str) {
        LinkedList linkedList = new LinkedList();
        int i3 = 0;
        while (i3 < 6) {
            VsMusicItemInfo vsMusicItemInfo = new VsMusicItemInfo();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("fakeMid");
            i3++;
            sb5.append(i3);
            vsMusicItemInfo.mSongMid = sb5.toString();
            vsMusicItemInfo.mMusicName = "";
            vsMusicItemInfo.mUrl = "";
            vsMusicItemInfo.mAlbumUrl = "";
            linkedList.add(new WinkEditorMusicInfo(vsMusicItemInfo, false, 0, str));
        }
        return linkedList;
    }

    public static WinkEditorMusicInfo b() {
        VsMusicItemInfo vsMusicItemInfo = new VsMusicItemInfo();
        vsMusicItemInfo.f320653f = H.longValue();
        vsMusicItemInfo.mSongMid = "fakeMid_template_bgm";
        vsMusicItemInfo.mMusicName = "";
        vsMusicItemInfo.mUrl = "";
        vsMusicItemInfo.mAlbumUrl = "";
        WinkEditorMusicInfo winkEditorMusicInfo = new WinkEditorMusicInfo(vsMusicItemInfo, false, 3, "FAKE_CATEGORY_RECOMMEND_ID");
        winkEditorMusicInfo.D = "FAKE_CATEGORY_RECOMMEND_ID";
        return winkEditorMusicInfo;
    }

    public void A(int i3) {
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo != null) {
            vsMusicItemInfo.musicDuration = i3;
        }
    }

    public void B(boolean z16) {
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo != null) {
            vsMusicItemInfo.D = z16;
        }
    }

    @NonNull
    public String c() {
        String str;
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null || (str = vsMusicItemInfo.mAlbumUrl) == null) {
            return "";
        }
        return str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null) {
            return "";
        }
        return vsMusicItemInfo.E;
    }

    @NonNull
    public String f() {
        String str;
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null || (str = vsMusicItemInfo.f320656m) == null) {
            return "";
        }
        return str;
    }

    @NonNull
    public String g() {
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null || TextUtils.isEmpty(vsMusicItemInfo.C)) {
            return LyricParseHelper.LYRIC_FROMAT_LRC;
        }
        return this.f321258d.C;
    }

    @Nullable
    public VsMusicItemInfo j() {
        return this.f321258d;
    }

    @NonNull
    public String k() {
        String str;
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null || (str = vsMusicItemInfo.f320652e) == null) {
            return "";
        }
        return str;
    }

    @NonNull
    public String l() {
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null || TextUtils.isEmpty(vsMusicItemInfo.f320651d)) {
            return LyricParseHelper.LYRIC_FROMAT_LRC;
        }
        return this.f321258d.f320651d;
    }

    public String m() {
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null) {
            return "";
        }
        return vsMusicItemInfo.H;
    }

    public int n() {
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null) {
            return 0;
        }
        return vsMusicItemInfo.musicDuration;
    }

    @NonNull
    public long o() {
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null) {
            return 0L;
        }
        return vsMusicItemInfo.f320653f;
    }

    @NonNull
    public String p() {
        String str;
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null || (str = vsMusicItemInfo.mSongMid) == null) {
            return "";
        }
        return str;
    }

    @NonNull
    public String q() {
        String str;
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null || (str = vsMusicItemInfo.mMusicName) == null) {
            return "";
        }
        return str;
    }

    public String r() {
        return WinkEditorMusicHelper.o(this);
    }

    public int s() {
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null) {
            return 0;
        }
        return vsMusicItemInfo.musicStart;
    }

    @NonNull
    public String t() {
        String str;
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null || (str = vsMusicItemInfo.mUrl) == null) {
            return "";
        }
        return str;
    }

    @NonNull
    public String toString() {
        return "{songMid:" + p() + ", songName:" + q() + ", songUrl:" + t() + ", selected:" + this.f321259e + ", downloadStatus:" + this.f321260f + ", itemType:" + this.f321262i + ", duration:" + n() + "}";
    }

    public String u() {
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null) {
            return "";
        }
        return vsMusicItemInfo.G;
    }

    public String v() {
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null) {
            return "";
        }
        return vsMusicItemInfo.F;
    }

    public boolean w() {
        VsMusicItemInfo vsMusicItemInfo = this.f321258d;
        if (vsMusicItemInfo == null) {
            return true;
        }
        return vsMusicItemInfo.D;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.f321258d, i3);
        parcel.writeByte(this.f321259e ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f321260f);
        parcel.writeInt(this.f321261h);
        parcel.writeInt(this.f321262i);
        parcel.writeByte(this.f321263m ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.C);
    }

    public boolean x() {
        if (this.f321258d.f320655i == 1) {
            return true;
        }
        return false;
    }

    public boolean y() {
        return TextUtils.isEmpty(p());
    }

    public void z(boolean z16) {
        this.f321258d.f320655i = z16 ? 1 : 0;
    }

    public WinkEditorMusicInfo(@NonNull VsMusicItemInfo vsMusicItemInfo, boolean z16, int i3, String str) {
        this(vsMusicItemInfo, z16, i3, false, -1, str, "");
    }

    public WinkEditorMusicInfo(@NonNull VsMusicItemInfo vsMusicItemInfo, boolean z16, int i3, boolean z17, int i16, String str, String str2) {
        this.f321261h = 0;
        this.F = false;
        this.G = null;
        this.f321258d = vsMusicItemInfo;
        this.f321259e = z16;
        this.f321260f = 0;
        this.f321262i = i3;
        this.f321263m = z17;
        this.C = i16;
        this.D = str;
        this.E = str2;
    }
}
