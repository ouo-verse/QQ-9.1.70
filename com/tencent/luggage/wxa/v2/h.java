package com.tencent.luggage.wxa.v2;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class h implements Parcelable {
    public static final b D = new b(null);
    public static final Parcelable.Creator E = new a();
    public boolean C;

    /* renamed from: a, reason: collision with root package name */
    public int f143018a;

    /* renamed from: b, reason: collision with root package name */
    public int f143019b;

    /* renamed from: c, reason: collision with root package name */
    public j f143020c;

    /* renamed from: d, reason: collision with root package name */
    public String f143021d;

    /* renamed from: e, reason: collision with root package name */
    public String f143022e;

    /* renamed from: f, reason: collision with root package name */
    public String f143023f;

    /* renamed from: g, reason: collision with root package name */
    public String f143024g;

    /* renamed from: h, reason: collision with root package name */
    public String f143025h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f143026i;

    /* renamed from: j, reason: collision with root package name */
    public int f143027j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f143028k;

    /* renamed from: l, reason: collision with root package name */
    public String f143029l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f143030m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h createFromParcel(Parcel in5) {
            Intrinsics.checkNotNullParameter(in5, "in");
            return new h(in5);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h[] newArray(int i3) {
            return new h[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public h(int i3, int i16) {
        this.f143019b = 2;
        this.f143021d = "";
        this.f143022e = "";
        this.f143023f = "";
        this.f143024g = "";
        this.f143025h = "";
        this.f143026i = true;
        this.f143028k = true;
        this.f143029l = "";
        this.f143030m = true;
        this.f143027j = i3;
        this.f143018a = i16;
    }

    public final void a(int i3) {
        this.f143019b = i3;
    }

    public final void b(int i3) {
        this.f143018a = i3;
    }

    public final void c(boolean z16) {
        this.C = z16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i3) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.f143018a);
        dest.writeParcelable(this.f143020c, i3);
        dest.writeString(this.f143021d);
        dest.writeString(this.f143022e);
        dest.writeString(this.f143023f);
        dest.writeString(this.f143024g);
        dest.writeInt(this.f143019b);
        dest.writeInt(this.f143026i ? 1 : 0);
        dest.writeInt(this.f143027j);
        dest.writeByte(this.f143028k ? (byte) 1 : (byte) 0);
        dest.writeString(this.f143029l);
        dest.writeByte(this.f143030m ? (byte) 1 : (byte) 0);
        dest.writeByte(this.C ? (byte) 1 : (byte) 0);
    }

    public final void a(j jVar) {
        this.f143020c = jVar;
    }

    public final j b() {
        return this.f143020c;
    }

    public final String a() {
        return this.f143021d;
    }

    public final void b(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f143024g = str;
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f143023f = str;
    }

    public final void b(boolean z16) {
        this.f143030m = z16;
    }

    public final void a(boolean z16) {
        this.f143028k = z16;
    }

    public final h a(String filename, String videoPath, String thumbpath, String picturepath) {
        Intrinsics.checkNotNullParameter(filename, "filename");
        Intrinsics.checkNotNullParameter(videoPath, "videoPath");
        Intrinsics.checkNotNullParameter(thumbpath, "thumbpath");
        Intrinsics.checkNotNullParameter(picturepath, "picturepath");
        this.f143023f = filename;
        this.f143021d = videoPath;
        this.f143022e = thumbpath;
        this.f143024g = picturepath;
        return this;
    }

    public h(Parcel in5) {
        Intrinsics.checkNotNullParameter(in5, "in");
        this.f143019b = 2;
        this.f143021d = "";
        this.f143022e = "";
        this.f143023f = "";
        this.f143024g = "";
        this.f143025h = "";
        this.f143026i = true;
        this.f143027j = -1;
        this.f143028k = true;
        this.f143029l = "";
        this.f143030m = true;
        this.f143018a = in5.readInt();
        Parcelable readParcelable = in5.readParcelable(j.class.getClassLoader());
        Intrinsics.checkNotNull(readParcelable, "null cannot be cast to non-null type com.tencent.luggage.jsapi.media.video.VideoTransPara");
        this.f143020c = (j) readParcelable;
        String readString = in5.readString();
        this.f143021d = readString == null ? "" : readString;
        String readString2 = in5.readString();
        this.f143022e = readString2 == null ? "" : readString2;
        String readString3 = in5.readString();
        this.f143023f = readString3 == null ? "" : readString3;
        String readString4 = in5.readString();
        this.f143024g = readString4 == null ? "" : readString4;
        this.f143019b = in5.readInt();
        this.f143026i = in5.readInt() > 0;
        this.f143027j = in5.readInt();
        this.f143028k = in5.readByte() != 0;
        String readString5 = in5.readString();
        this.f143029l = readString5 != null ? readString5 : "";
        this.f143030m = in5.readByte() != 0;
        this.C = in5.readByte() != 0;
    }
}
