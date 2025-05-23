package com.tencent.qqlive.superplayer.vinfo.vod;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TVKCGIVideoInfo implements Parcelable {
    public static final Parcelable.Creator<TVKCGIVideoInfo> CREATOR = new a();
    private ArrayList<TVKCGIVideoMp4ClipInfo> A0;
    private ArrayList<TVKCGIVideoTVLogoInfo> B0;
    private int C;
    private String C0;
    private int D;
    private boolean D0;
    private String E;
    private String E0;
    private String F;
    private ArrayList<String> F0;
    private int G;
    private String G0;
    private String H;
    private String H0;
    private int I;
    private int I0;
    private int J;
    private long J0;
    private int K;
    private String K0;
    private int L;
    private String M;
    private String N;
    private String P;
    private String Q;
    private long R;
    private int S;
    private int T;
    private int U;
    private int V;
    private String W;
    private int X;
    private int Y;
    private int Z;

    /* renamed from: a0, reason: collision with root package name */
    private long f345645a0;

    /* renamed from: b0, reason: collision with root package name */
    private float f345646b0;

    /* renamed from: c0, reason: collision with root package name */
    private String f345647c0;

    /* renamed from: d, reason: collision with root package name */
    private String f345648d;

    /* renamed from: d0, reason: collision with root package name */
    private int f345649d0;

    /* renamed from: e, reason: collision with root package name */
    private int f345650e;

    /* renamed from: e0, reason: collision with root package name */
    private int f345651e0;

    /* renamed from: f, reason: collision with root package name */
    private int f345652f;

    /* renamed from: f0, reason: collision with root package name */
    private int f345653f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f345654g0;

    /* renamed from: h, reason: collision with root package name */
    private int f345655h;

    /* renamed from: h0, reason: collision with root package name */
    private float f345656h0;

    /* renamed from: i, reason: collision with root package name */
    private int f345657i;

    /* renamed from: i0, reason: collision with root package name */
    private String f345658i0;

    /* renamed from: j0, reason: collision with root package name */
    private int f345659j0;

    /* renamed from: k0, reason: collision with root package name */
    private int f345660k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f345661l0;

    /* renamed from: m, reason: collision with root package name */
    private long f345662m;

    /* renamed from: m0, reason: collision with root package name */
    private int f345663m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f345664n0;

    /* renamed from: o0, reason: collision with root package name */
    private String f345665o0;

    /* renamed from: p0, reason: collision with root package name */
    private double f345666p0;

    /* renamed from: q0, reason: collision with root package name */
    private String f345667q0;

    /* renamed from: r0, reason: collision with root package name */
    private String f345668r0;

    /* renamed from: s0, reason: collision with root package name */
    private ArrayList<TVKCGIVideoFormatInfo> f345669s0;

    /* renamed from: t0, reason: collision with root package name */
    private ArrayList<TVKCGIVideoAudioTrackInfo> f345670t0;

    /* renamed from: u0, reason: collision with root package name */
    private ArrayList<TVKCGIVideoSubtitleInfo> f345671u0;

    /* renamed from: v0, reason: collision with root package name */
    private ArrayList<TVKCGIVideoPictureInfo> f345672v0;

    /* renamed from: w0, reason: collision with root package name */
    private String f345673w0;

    /* renamed from: x0, reason: collision with root package name */
    private ArrayList<TVKCGIVideoUrlInfo> f345674x0;

    /* renamed from: y0, reason: collision with root package name */
    private ArrayList<TVKCGIVideoWatermarkInfo> f345675y0;

    /* renamed from: z0, reason: collision with root package name */
    private int f345676z0;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class TVKCGIVideoAudioTrackInfo implements Parcelable {
        public static final Parcelable.Creator<TVKCGIVideoAudioTrackInfo> CREATOR = new a();
        private int C;
        private String D;
        private ArrayList<String> E;

        /* renamed from: d, reason: collision with root package name */
        private int f345677d;

        /* renamed from: e, reason: collision with root package name */
        private String f345678e;

        /* renamed from: f, reason: collision with root package name */
        private int f345679f;

        /* renamed from: h, reason: collision with root package name */
        private String f345680h;

        /* renamed from: i, reason: collision with root package name */
        private int f345681i;

        /* renamed from: m, reason: collision with root package name */
        private String f345682m;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements Parcelable.Creator<TVKCGIVideoAudioTrackInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoAudioTrackInfo createFromParcel(Parcel parcel) {
                return new TVKCGIVideoAudioTrackInfo(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoAudioTrackInfo[] newArray(int i3) {
                return new TVKCGIVideoAudioTrackInfo[0];
            }
        }

        /* synthetic */ TVKCGIVideoAudioTrackInfo(Parcel parcel, a aVar) {
            this(parcel);
        }

        public void a(String str) {
            if (this.E == null) {
                this.E = new ArrayList<>();
            }
            this.E.add(str);
        }

        public String b() {
            return this.f345678e;
        }

        public int c() {
            return this.f345679f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f345680h;
        }

        public int f() {
            return this.f345681i;
        }

        public String g() {
            return this.f345682m;
        }

        public int j() {
            return this.C;
        }

        public int k() {
            return this.f345677d;
        }

        public String l() {
            return this.D;
        }

        public ArrayList<String> m() {
            return this.E;
        }

        public void n(Parcel parcel) {
            this.f345677d = parcel.readInt();
            this.f345678e = parcel.readString();
            this.f345679f = parcel.readInt();
            this.f345680h = parcel.readString();
            this.f345681i = parcel.readInt();
            this.f345682m = parcel.readString();
            this.C = parcel.readInt();
            this.D = parcel.readString();
            this.E = parcel.readArrayList(TVKCGIVideoAudioTrackInfo.class.getClassLoader());
        }

        public void o(String str) {
            this.f345678e = str;
        }

        public void p(int i3) {
            this.f345679f = i3;
        }

        public void q(String str) {
            this.f345680h = str;
        }

        public void r(int i3) {
            this.f345681i = i3;
        }

        public void s(String str) {
            this.f345682m = str;
        }

        public void t(int i3) {
            this.C = i3;
        }

        public void u(int i3) {
            this.f345677d = i3;
        }

        public void v(String str) {
            this.D = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f345677d);
            parcel.writeString(this.f345678e);
            parcel.writeInt(this.f345679f);
            parcel.writeString(this.f345680h);
            parcel.writeInt(this.f345681i);
            parcel.writeString(this.f345682m);
            parcel.writeInt(this.C);
            parcel.writeString(this.D);
            parcel.writeList(this.E);
        }

        public TVKCGIVideoAudioTrackInfo() {
            this.E = null;
        }

        TVKCGIVideoAudioTrackInfo(Parcel parcel) {
            this();
            n(parcel);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class TVKCGIVideoFormatInfo implements Parcelable {
        public static final Parcelable.Creator<TVKCGIVideoFormatInfo> CREATOR = new a();
        private int C;
        private int D;
        private int E;
        private int F;
        private int G;
        private int H;
        private int I;
        private int J;
        private long K;
        private int L;

        /* renamed from: d, reason: collision with root package name */
        private String f345683d;

        /* renamed from: e, reason: collision with root package name */
        private String f345684e;

        /* renamed from: f, reason: collision with root package name */
        private String f345685f;

        /* renamed from: h, reason: collision with root package name */
        private String f345686h;

        /* renamed from: i, reason: collision with root package name */
        private int f345687i;

        /* renamed from: m, reason: collision with root package name */
        private int f345688m;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements Parcelable.Creator<TVKCGIVideoFormatInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoFormatInfo createFromParcel(Parcel parcel) {
                return new TVKCGIVideoFormatInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoFormatInfo[] newArray(int i3) {
                return new TVKCGIVideoFormatInfo[0];
            }
        }

        public TVKCGIVideoFormatInfo() {
        }

        public int a() {
            return this.G;
        }

        public int b() {
            return this.J;
        }

        public String c() {
            return this.f345684e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int e() {
            return this.E;
        }

        public long f() {
            return this.K;
        }

        public int g() {
            return this.L;
        }

        public int j() {
            return this.f345687i;
        }

        public int k() {
            return this.C;
        }

        public String l() {
            return this.f345683d;
        }

        public String m() {
            return this.f345686h;
        }

        public int n() {
            return this.f345688m;
        }

        public String o() {
            return this.f345685f;
        }

        public int p() {
            return this.F;
        }

        public void q(Parcel parcel) {
            this.f345683d = parcel.readString();
            this.f345684e = parcel.readString();
            this.f345687i = parcel.readInt();
            this.f345688m = parcel.readInt();
            this.C = parcel.readInt();
            this.D = parcel.readInt();
            this.E = parcel.readInt();
            this.F = parcel.readInt();
            this.G = parcel.readInt();
            this.H = parcel.readInt();
            this.I = parcel.readInt();
            this.J = parcel.readInt();
            this.K = parcel.readLong();
            this.L = parcel.readInt();
            this.f345685f = parcel.readString();
            this.f345686h = parcel.readString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f345683d);
            parcel.writeString(this.f345684e);
            parcel.writeInt(this.f345687i);
            parcel.writeInt(this.f345688m);
            parcel.writeInt(this.C);
            parcel.writeInt(this.D);
            parcel.writeInt(this.E);
            parcel.writeInt(this.F);
            parcel.writeInt(this.G);
            parcel.writeInt(this.H);
            parcel.writeInt(this.I);
            parcel.writeInt(this.J);
            parcel.writeLong(this.K);
            parcel.writeInt(this.L);
            parcel.writeString(this.f345685f);
            parcel.writeString(this.f345686h);
        }

        public TVKCGIVideoFormatInfo(Parcel parcel) {
            this();
            q(parcel);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class TVKCGIVideoMp4ClipInfo implements Parcelable {
        public static final Parcelable.Creator<TVKCGIVideoMp4ClipInfo> CREATOR = new a();
        private String C;
        private ArrayList<String> D;

        /* renamed from: d, reason: collision with root package name */
        private double f345689d;

        /* renamed from: e, reason: collision with root package name */
        private long f345690e;

        /* renamed from: f, reason: collision with root package name */
        private int f345691f;

        /* renamed from: h, reason: collision with root package name */
        private String f345692h;

        /* renamed from: i, reason: collision with root package name */
        private String f345693i;

        /* renamed from: m, reason: collision with root package name */
        private String f345694m;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements Parcelable.Creator<TVKCGIVideoMp4ClipInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoMp4ClipInfo createFromParcel(Parcel parcel) {
                return new TVKCGIVideoMp4ClipInfo(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoMp4ClipInfo[] newArray(int i3) {
                return new TVKCGIVideoMp4ClipInfo[0];
            }
        }

        /* synthetic */ TVKCGIVideoMp4ClipInfo(Parcel parcel, a aVar) {
            this(parcel);
        }

        public void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.D.add(str);
            }
        }

        public double b() {
            return this.f345689d;
        }

        public int c() {
            return this.f345691f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f345693i;
        }

        public long f() {
            return this.f345690e;
        }

        public String g() {
            return this.f345694m;
        }

        public String j() {
            return this.C;
        }

        public void k(Parcel parcel) {
            this.f345689d = parcel.readDouble();
            this.f345690e = parcel.readLong();
            this.f345691f = parcel.readInt();
            this.f345692h = parcel.readString();
            this.f345693i = parcel.readString();
            this.f345694m = parcel.readString();
            this.C = parcel.readString();
            this.D = parcel.readArrayList(TVKCGIVideoMp4ClipInfo.class.getClassLoader());
        }

        public void l(String str) {
            this.f345692h = str;
        }

        public void m(double d16) {
            this.f345689d = d16;
        }

        public void n(int i3) {
            this.f345691f = i3;
        }

        public void o(String str) {
            this.f345693i = str;
        }

        public void p(long j3) {
            this.f345690e = j3;
        }

        public void q(String str) {
            this.f345694m = str;
        }

        public void r(String str) {
            this.C = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeDouble(this.f345689d);
            parcel.writeLong(this.f345690e);
            parcel.writeInt(this.f345691f);
            parcel.writeString(this.f345692h);
            parcel.writeString(this.f345693i);
            parcel.writeString(this.f345694m);
            parcel.writeString(this.C);
            parcel.writeList(this.D);
        }

        public TVKCGIVideoMp4ClipInfo() {
            this.D = new ArrayList<>();
        }

        TVKCGIVideoMp4ClipInfo(Parcel parcel) {
            this();
            k(parcel);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class TVKCGIVideoPictureInfo implements Parcelable {
        public static final Parcelable.Creator<TVKCGIVideoPictureInfo> CREATOR = new a();
        private String C;
        private String D;

        /* renamed from: d, reason: collision with root package name */
        private int f345695d;

        /* renamed from: e, reason: collision with root package name */
        private int f345696e;

        /* renamed from: f, reason: collision with root package name */
        private int f345697f;

        /* renamed from: h, reason: collision with root package name */
        private int f345698h;

        /* renamed from: i, reason: collision with root package name */
        private int f345699i;

        /* renamed from: m, reason: collision with root package name */
        private int f345700m;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements Parcelable.Creator<TVKCGIVideoPictureInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoPictureInfo createFromParcel(Parcel parcel) {
                return new TVKCGIVideoPictureInfo(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoPictureInfo[] newArray(int i3) {
                return new TVKCGIVideoPictureInfo[0];
            }
        }

        /* synthetic */ TVKCGIVideoPictureInfo(Parcel parcel, a aVar) {
            this(parcel);
        }

        public String a() {
            return this.D;
        }

        public void b(Parcel parcel) {
            this.f345695d = parcel.readInt();
            this.f345696e = parcel.readInt();
            this.f345697f = parcel.readInt();
            this.f345698h = parcel.readInt();
            this.f345699i = parcel.readInt();
            this.f345700m = parcel.readInt();
            this.C = parcel.readString();
            this.D = parcel.readString();
        }

        public void c(int i3) {
            this.f345697f = i3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void e(int i3) {
            this.f345696e = i3;
        }

        public void f(int i3) {
            this.f345695d = i3;
        }

        public void g(String str) {
            this.D = str;
        }

        public void j(int i3) {
            this.f345698h = i3;
        }

        public void k(int i3) {
            this.f345700m = i3;
        }

        public void l(int i3) {
            this.f345699i = i3;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f345695d);
            parcel.writeInt(this.f345696e);
            parcel.writeInt(this.f345697f);
            parcel.writeInt(this.f345698h);
            parcel.writeInt(this.f345699i);
            parcel.writeInt(this.f345700m);
            parcel.writeString(this.C);
            parcel.writeString(this.D);
        }

        public TVKCGIVideoPictureInfo() {
        }

        TVKCGIVideoPictureInfo(Parcel parcel) {
            this();
            b(parcel);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class TVKCGIVideoSubtitleInfo implements Parcelable {
        public static final Parcelable.Creator<TVKCGIVideoSubtitleInfo> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        private String f345701d;

        /* renamed from: e, reason: collision with root package name */
        private String f345702e;

        /* renamed from: f, reason: collision with root package name */
        private String f345703f;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements Parcelable.Creator<TVKCGIVideoSubtitleInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoSubtitleInfo createFromParcel(Parcel parcel) {
                return new TVKCGIVideoSubtitleInfo(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoSubtitleInfo[] newArray(int i3) {
                return new TVKCGIVideoSubtitleInfo[0];
            }
        }

        /* synthetic */ TVKCGIVideoSubtitleInfo(Parcel parcel, a aVar) {
            this(parcel);
        }

        public String a() {
            return this.f345703f;
        }

        public String b() {
            return this.f345701d;
        }

        public String c() {
            return this.f345702e;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void e(Parcel parcel) {
            this.f345701d = parcel.readString();
            this.f345702e = parcel.readString();
            this.f345703f = parcel.readString();
        }

        public void f(String str) {
            this.f345703f = str;
        }

        public void g(String str) {
            this.f345701d = str;
        }

        public void j(String str) {
            this.f345702e = str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f345701d);
            parcel.writeString(this.f345702e);
            parcel.writeString(this.f345703f);
        }

        public TVKCGIVideoSubtitleInfo() {
        }

        TVKCGIVideoSubtitleInfo(Parcel parcel) {
            this();
            e(parcel);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class TVKCGIVideoTVLogoInfo implements Parcelable {
        public static final Parcelable.Creator<TVKCGIVideoTVLogoInfo> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        private int f345704d;

        /* renamed from: e, reason: collision with root package name */
        private int f345705e;

        /* renamed from: f, reason: collision with root package name */
        private int f345706f;

        /* renamed from: h, reason: collision with root package name */
        private int f345707h;

        /* renamed from: i, reason: collision with root package name */
        private int f345708i;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements Parcelable.Creator<TVKCGIVideoTVLogoInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoTVLogoInfo createFromParcel(Parcel parcel) {
                return new TVKCGIVideoTVLogoInfo(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoTVLogoInfo[] newArray(int i3) {
                return new TVKCGIVideoTVLogoInfo[0];
            }
        }

        /* synthetic */ TVKCGIVideoTVLogoInfo(Parcel parcel, a aVar) {
            this(parcel);
        }

        public int a() {
            return this.f345704d;
        }

        public int b() {
            return this.f345705e;
        }

        public int c() {
            return this.f345706f;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public int e() {
            return this.f345707h;
        }

        public void f(Parcel parcel) {
            this.f345704d = parcel.readInt();
            this.f345705e = parcel.readInt();
            this.f345706f = parcel.readInt();
            this.f345707h = parcel.readInt();
            this.f345708i = parcel.readInt();
        }

        public void g(int i3) {
            this.f345704d = i3;
        }

        public void j(int i3) {
            this.f345708i = i3;
        }

        public void k(int i3) {
            this.f345705e = i3;
        }

        public void l(int i3) {
            this.f345706f = i3;
        }

        public void m(int i3) {
            this.f345707h = i3;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f345704d);
            parcel.writeInt(this.f345705e);
            parcel.writeInt(this.f345706f);
            parcel.writeInt(this.f345707h);
            parcel.writeInt(this.f345708i);
        }

        public TVKCGIVideoTVLogoInfo() {
        }

        TVKCGIVideoTVLogoInfo(Parcel parcel) {
            this();
            f(parcel);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class TVKCGIVideoUrlInfo implements Parcelable {
        public static final Parcelable.Creator<TVKCGIVideoUrlInfo> CREATOR = new a();
        private String C;

        /* renamed from: d, reason: collision with root package name */
        private int f345709d;

        /* renamed from: e, reason: collision with root package name */
        private String f345710e;

        /* renamed from: f, reason: collision with root package name */
        private String f345711f;

        /* renamed from: h, reason: collision with root package name */
        private String f345712h;

        /* renamed from: i, reason: collision with root package name */
        private String f345713i;

        /* renamed from: m, reason: collision with root package name */
        private String f345714m;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements Parcelable.Creator<TVKCGIVideoUrlInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoUrlInfo createFromParcel(Parcel parcel) {
                return new TVKCGIVideoUrlInfo(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoUrlInfo[] newArray(int i3) {
                return new TVKCGIVideoUrlInfo[0];
            }
        }

        /* synthetic */ TVKCGIVideoUrlInfo(Parcel parcel, a aVar) {
            this(parcel);
        }

        public String a() {
            return this.f345714m;
        }

        public String b() {
            return this.f345713i;
        }

        public String c() {
            return this.C;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String e() {
            return this.f345711f;
        }

        public String f() {
            return this.f345712h;
        }

        public String g() {
            return this.f345710e;
        }

        public int j() {
            return this.f345709d;
        }

        public void k(Parcel parcel) {
            this.f345709d = parcel.readInt();
            this.f345710e = parcel.readString();
            this.f345711f = parcel.readString();
            this.f345712h = parcel.readString();
            this.f345713i = parcel.readString();
            this.f345714m = parcel.readString();
            this.C = parcel.readString();
        }

        public void l(String str) {
            this.f345714m = str;
        }

        public void m(String str) {
            this.f345713i = str;
        }

        public void n(String str) {
            this.C = str;
        }

        public void o(String str) {
            this.f345711f = str;
        }

        public void p(String str) {
            this.f345712h = str;
        }

        public void q(String str) {
            this.f345710e = str;
        }

        public void r(int i3) {
            this.f345709d = i3;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f345709d);
            parcel.writeString(this.f345710e);
            parcel.writeString(this.f345711f);
            parcel.writeString(this.f345712h);
            parcel.writeString(this.f345713i);
            parcel.writeString(this.f345714m);
            parcel.writeString(this.C);
        }

        public TVKCGIVideoUrlInfo() {
            this.f345710e = "";
        }

        TVKCGIVideoUrlInfo(Parcel parcel) {
            this();
            k(parcel);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class TVKCGIVideoWatermarkInfo implements Parcelable {
        public static final Parcelable.Creator<TVKCGIVideoWatermarkInfo> CREATOR = new a();
        private String C;
        private String D;
        private String E;

        /* renamed from: d, reason: collision with root package name */
        private int f345715d;

        /* renamed from: e, reason: collision with root package name */
        private int f345716e;

        /* renamed from: f, reason: collision with root package name */
        private int f345717f;

        /* renamed from: h, reason: collision with root package name */
        private int f345718h;

        /* renamed from: i, reason: collision with root package name */
        private int f345719i;

        /* renamed from: m, reason: collision with root package name */
        private int f345720m;

        /* compiled from: P */
        /* loaded from: classes22.dex */
        class a implements Parcelable.Creator<TVKCGIVideoWatermarkInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoWatermarkInfo createFromParcel(Parcel parcel) {
                return new TVKCGIVideoWatermarkInfo(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TVKCGIVideoWatermarkInfo[] newArray(int i3) {
                return new TVKCGIVideoWatermarkInfo[0];
            }
        }

        /* synthetic */ TVKCGIVideoWatermarkInfo(Parcel parcel, a aVar) {
            this(parcel);
        }

        public String a() {
            return this.C;
        }

        public void b(Parcel parcel) {
            this.f345715d = parcel.readInt();
            this.f345716e = parcel.readInt();
            this.f345717f = parcel.readInt();
            this.f345718h = parcel.readInt();
            this.f345719i = parcel.readInt();
            this.f345720m = parcel.readInt();
            this.C = parcel.readString();
            this.D = parcel.readString();
            this.E = parcel.readString();
        }

        public void c(int i3) {
            this.f345720m = i3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public void e(int i3) {
            this.f345718h = i3;
        }

        public void f(int i3) {
            this.f345715d = i3;
        }

        public void g(String str) {
            this.C = str;
        }

        public void j(String str) {
            this.E = str;
        }

        public void k(String str) {
            this.D = str;
        }

        public void l(int i3) {
            this.f345719i = i3;
        }

        public void m(int i3) {
            this.f345716e = i3;
        }

        public void n(int i3) {
            this.f345717f = i3;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f345715d);
            parcel.writeInt(this.f345716e);
            parcel.writeInt(this.f345717f);
            parcel.writeInt(this.f345718h);
            parcel.writeInt(this.f345719i);
            parcel.writeInt(this.f345720m);
            parcel.writeString(this.C);
            parcel.writeString(this.D);
            parcel.writeString(this.E);
        }

        public TVKCGIVideoWatermarkInfo() {
        }

        TVKCGIVideoWatermarkInfo(Parcel parcel) {
            this();
            b(parcel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements Parcelable.Creator<TVKCGIVideoInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TVKCGIVideoInfo createFromParcel(Parcel parcel) {
            return new TVKCGIVideoInfo(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TVKCGIVideoInfo[] newArray(int i3) {
            return new TVKCGIVideoInfo[0];
        }
    }

    /* synthetic */ TVKCGIVideoInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    public ArrayList<TVKCGIVideoFormatInfo> A() {
        return this.f345669s0;
    }

    public void A0(String str) {
        this.F = str;
    }

    public void A1(int i3) {
        this.f345654g0 = i3;
    }

    public int B() {
        return this.C;
    }

    public void B0(int i3) {
        this.f345664n0 = i3;
    }

    public void B1(float f16) {
        this.f345656h0 = f16;
    }

    public long C() {
        return this.R;
    }

    public void C0(int i3) {
        this.G = i3;
    }

    public void D0(String str) {
        this.H = str;
    }

    public String E() {
        return this.f345665o0;
    }

    public void E0(int i3) {
        this.I = i3;
    }

    public int F() {
        return this.T;
    }

    public void F0(int i3) {
        this.f345657i = i3;
    }

    public int G() {
        return this.U;
    }

    public void G0(int i3) {
        this.J = i3;
    }

    public void H0(int i3) {
        this.K = i3;
    }

    public void I0(double d16) {
        this.f345666p0 = d16;
    }

    public void J0(int i3) {
        this.f345650e = i3;
    }

    public void K0(int i3) {
        this.L = i3;
    }

    public void L0(int i3) {
        this.f345652f = i3;
    }

    public int M() {
        return this.V;
    }

    public void M0(int i3) {
        this.f345676z0 = i3;
    }

    public String N() {
        return this.E;
    }

    public void N0(String str) {
        this.M = str;
    }

    public void O0(String str) {
        this.N = str;
    }

    public void P0(int i3) {
        this.C = i3;
    }

    public void Q0(String str) {
        this.P = str;
    }

    public void R0(long j3) {
        this.R = j3;
    }

    public void S0(int i3) {
        this.S = i3;
    }

    public void T0(String str) {
        this.f345665o0 = str;
    }

    public void U0(int i3) {
        this.T = i3;
    }

    public String V() {
        return this.W;
    }

    public void V0(int i3) {
        this.U = i3;
    }

    public void W0(int i3) {
        this.V = i3;
    }

    public void X0(String str) {
        this.E = str;
    }

    public void Y0(String str) {
        this.Q = str;
    }

    public ArrayList<TVKCGIVideoMp4ClipInfo> Z() {
        return this.A0;
    }

    public void Z0(String str) {
        this.W = str;
    }

    public void a(TVKCGIVideoAudioTrackInfo tVKCGIVideoAudioTrackInfo) {
        this.f345670t0.add(tVKCGIVideoAudioTrackInfo);
    }

    public int a0() {
        return this.X;
    }

    public void a1(String str) {
        this.K0 = str;
    }

    public void b(TVKCGIVideoFormatInfo tVKCGIVideoFormatInfo) {
        this.f345669s0.add(tVKCGIVideoFormatInfo);
    }

    public String b0() {
        return this.f345673w0;
    }

    public void b1(int i3) {
        this.X = i3;
    }

    public void c(TVKCGIVideoMp4ClipInfo tVKCGIVideoMp4ClipInfo) {
        this.A0.add(tVKCGIVideoMp4ClipInfo);
    }

    public int c0() {
        return this.f345655h;
    }

    public void c1(String str) {
        this.f345673w0 = str;
    }

    public int d0() {
        return this.Y;
    }

    public void d1(int i3) {
        this.f345655h = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(TVKCGIVideoPictureInfo tVKCGIVideoPictureInfo) {
        this.f345672v0.add(tVKCGIVideoPictureInfo);
    }

    public ArrayList<TVKCGIVideoSubtitleInfo> e0() {
        return this.f345671u0;
    }

    public void e1(String str) {
        this.f345648d = str;
    }

    public void f(TVKCGIVideoSubtitleInfo tVKCGIVideoSubtitleInfo) {
        this.f345671u0.add(tVKCGIVideoSubtitleInfo);
    }

    public int f0() {
        return this.Z;
    }

    public void f1(long j3) {
        this.J0 = j3;
    }

    public void g(TVKCGIVideoTVLogoInfo tVKCGIVideoTVLogoInfo) {
        this.B0.add(tVKCGIVideoTVLogoInfo);
    }

    public long g0() {
        return this.f345645a0;
    }

    public void g1(String str) {
        this.H0 = str;
    }

    public float h0() {
        return this.f345646b0;
    }

    public void h1(int i3) {
        this.I0 = i3;
    }

    public String i0() {
        return this.f345647c0;
    }

    public void i1(int i3) {
        this.Y = i3;
    }

    public void j(TVKCGIVideoUrlInfo tVKCGIVideoUrlInfo) {
        this.f345674x0.add(tVKCGIVideoUrlInfo);
    }

    public int j0() {
        return this.f345649d0;
    }

    public void j1(int i3) {
        this.f345663m0 = i3;
    }

    public void k(TVKCGIVideoWatermarkInfo tVKCGIVideoWatermarkInfo) {
        this.f345675y0.add(tVKCGIVideoWatermarkInfo);
    }

    public int k0() {
        return this.D;
    }

    public void k1(int i3) {
        this.Z = i3;
    }

    public String l() {
        return this.f345667q0;
    }

    public String l0() {
        return this.E0;
    }

    public void l1(long j3) {
        this.f345645a0 = j3;
    }

    public String m() {
        return this.C0;
    }

    public ArrayList<TVKCGIVideoUrlInfo> m0() {
        return this.f345674x0;
    }

    public void m1(float f16) {
        this.f345646b0 = f16;
    }

    public String n() {
        return this.f345668r0;
    }

    public int n0() {
        return this.f345653f0;
    }

    public void n1(String str) {
        this.f345647c0 = str;
    }

    public ArrayList<TVKCGIVideoAudioTrackInfo> o() {
        return this.f345670t0;
    }

    public String o0() {
        return this.f345658i0;
    }

    public void o1(int i3) {
        this.f345649d0 = i3;
    }

    public String p() {
        return this.F;
    }

    public int p0() {
        return this.f345659j0;
    }

    public void p1(long j3) {
        this.f345662m = j3;
    }

    public int q() {
        return this.f345664n0;
    }

    public String q0() {
        return this.G0;
    }

    public void q1(int i3) {
        this.D = i3;
    }

    public int r() {
        return this.G;
    }

    public int r0() {
        return this.f345660k0;
    }

    public void r1(int i3) {
        this.f345651e0 = i3;
    }

    public String s() {
        return this.H;
    }

    public int s0() {
        return this.f345661l0;
    }

    public void s1(String str) {
        this.E0 = str;
    }

    public int t() {
        return this.f345657i;
    }

    public int t0() {
        return this.f345654g0;
    }

    public void t1(ArrayList<String> arrayList) {
        this.F0 = arrayList;
    }

    public int u() {
        return this.J;
    }

    public ArrayList<TVKCGIVideoWatermarkInfo> u0() {
        return this.f345675y0;
    }

    public void u1(int i3) {
        this.f345653f0 = i3;
    }

    public int v() {
        return this.K;
    }

    public float v0() {
        return this.f345656h0;
    }

    public void v1(String str) {
        this.f345658i0 = str;
    }

    public int w() {
        return this.L;
    }

    public boolean w0() {
        return this.D0;
    }

    public void w1(int i3) {
        this.f345659j0 = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f345648d);
        parcel.writeInt(this.f345650e);
        parcel.writeInt(this.f345652f);
        parcel.writeInt(this.f345655h);
        parcel.writeInt(this.f345657i);
        parcel.writeLong(this.f345662m);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeInt(this.G);
        parcel.writeString(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        parcel.writeInt(this.K);
        parcel.writeInt(this.L);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.P);
        parcel.writeString(this.Q);
        parcel.writeLong(this.R);
        parcel.writeInt(this.S);
        parcel.writeInt(this.T);
        parcel.writeInt(this.U);
        parcel.writeInt(this.V);
        parcel.writeString(this.W);
        parcel.writeInt(this.X);
        parcel.writeInt(this.Y);
        parcel.writeInt(this.Z);
        parcel.writeLong(this.f345645a0);
        parcel.writeFloat(this.f345646b0);
        parcel.writeString(this.f345647c0);
        parcel.writeInt(this.f345649d0);
        parcel.writeInt(this.f345651e0);
        parcel.writeInt(this.f345653f0);
        parcel.writeInt(this.f345654g0);
        parcel.writeFloat(this.f345656h0);
        parcel.writeString(this.f345658i0);
        parcel.writeInt(this.f345659j0);
        parcel.writeInt(this.f345660k0);
        parcel.writeInt(this.f345661l0);
        parcel.writeInt(this.f345663m0);
        parcel.writeInt(this.f345664n0);
        parcel.writeInt(this.f345676z0);
        parcel.writeString(this.f345665o0);
        parcel.writeDouble(this.f345666p0);
        parcel.writeString(this.f345667q0);
        parcel.writeString(this.f345668r0);
        parcel.writeList(this.f345669s0);
        parcel.writeList(this.f345670t0);
        parcel.writeList(this.f345671u0);
        parcel.writeList(this.f345672v0);
        parcel.writeList(this.f345674x0);
        parcel.writeList(this.f345675y0);
        parcel.writeList(this.A0);
        parcel.writeList(this.B0);
        parcel.writeString(this.E0);
        parcel.writeString(this.G0);
        parcel.writeString(this.C0);
        parcel.writeString(this.f345673w0);
        parcel.writeString(this.H0);
        parcel.writeInt(this.I0);
        parcel.writeLong(this.J0);
        parcel.writeInt(this.D0 ? 1 : 0);
    }

    public int x() {
        return this.f345652f;
    }

    public void x0(Parcel parcel) {
        boolean z16;
        this.f345648d = parcel.readString();
        this.f345650e = parcel.readInt();
        this.f345652f = parcel.readInt();
        this.f345655h = parcel.readInt();
        this.f345657i = parcel.readInt();
        this.f345662m = parcel.readLong();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readInt();
        this.H = parcel.readString();
        this.I = parcel.readInt();
        this.J = parcel.readInt();
        this.K = parcel.readInt();
        this.L = parcel.readInt();
        this.M = parcel.readString();
        this.N = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readString();
        this.R = parcel.readLong();
        this.S = parcel.readInt();
        this.T = parcel.readInt();
        this.U = parcel.readInt();
        this.V = parcel.readInt();
        this.W = parcel.readString();
        this.X = parcel.readInt();
        this.Y = parcel.readInt();
        this.Z = parcel.readInt();
        this.f345645a0 = parcel.readLong();
        this.f345646b0 = parcel.readFloat();
        this.f345647c0 = parcel.readString();
        this.f345649d0 = parcel.readInt();
        this.f345651e0 = parcel.readInt();
        this.f345653f0 = parcel.readInt();
        this.f345654g0 = parcel.readInt();
        this.f345656h0 = parcel.readFloat();
        this.f345658i0 = parcel.readString();
        this.f345659j0 = parcel.readInt();
        this.f345660k0 = parcel.readInt();
        this.f345661l0 = parcel.readInt();
        this.f345663m0 = parcel.readInt();
        this.f345664n0 = parcel.readInt();
        this.f345676z0 = parcel.readInt();
        this.f345665o0 = parcel.readString();
        this.f345666p0 = parcel.readDouble();
        this.f345667q0 = parcel.readString();
        this.f345668r0 = parcel.readString();
        this.f345669s0 = parcel.readArrayList(TVKCGIVideoFormatInfo.class.getClassLoader());
        this.f345670t0 = parcel.readArrayList(TVKCGIVideoAudioTrackInfo.class.getClassLoader());
        this.f345671u0 = parcel.readArrayList(TVKCGIVideoSubtitleInfo.class.getClassLoader());
        this.f345672v0 = parcel.readArrayList(TVKCGIVideoPictureInfo.class.getClassLoader());
        this.f345674x0 = parcel.readArrayList(TVKCGIVideoUrlInfo.class.getClassLoader());
        this.f345675y0 = parcel.readArrayList(TVKCGIVideoWatermarkInfo.class.getClassLoader());
        this.A0 = parcel.readArrayList(TVKCGIVideoMp4ClipInfo.class.getClassLoader());
        this.B0 = parcel.readArrayList(TVKCGIVideoTVLogoInfo.class.getClassLoader());
        this.E0 = parcel.readString();
        this.G0 = parcel.readString();
        this.C0 = parcel.readString();
        this.f345673w0 = parcel.readString();
        this.H0 = parcel.readString();
        this.I0 = parcel.readInt();
        this.J0 = parcel.readLong();
        if (parcel.readInt() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.D0 = z16;
    }

    public void x1(String str) {
        this.G0 = str;
    }

    public int y() {
        return this.f345676z0;
    }

    public void y0(String str) {
        this.f345667q0 = str;
    }

    public void y1(int i3) {
        this.f345660k0 = i3;
    }

    public String z() {
        return this.N;
    }

    public void z0(String str) {
        this.f345668r0 = str;
    }

    public void z1(int i3) {
        this.f345661l0 = i3;
    }

    public TVKCGIVideoInfo() {
        this.C = 0;
        this.D = 0;
        this.f345669s0 = new ArrayList<>();
        this.f345670t0 = new ArrayList<>();
        this.f345671u0 = new ArrayList<>();
        this.f345672v0 = new ArrayList<>();
        this.f345674x0 = new ArrayList<>();
        this.f345675y0 = new ArrayList<>();
        this.A0 = new ArrayList<>();
        this.B0 = new ArrayList<>();
        this.E0 = "";
        this.F0 = new ArrayList<>();
        this.G0 = "";
    }

    TVKCGIVideoInfo(Parcel parcel) {
        this.C = 0;
        this.D = 0;
        this.f345669s0 = new ArrayList<>();
        this.f345670t0 = new ArrayList<>();
        this.f345671u0 = new ArrayList<>();
        this.f345672v0 = new ArrayList<>();
        this.f345674x0 = new ArrayList<>();
        this.f345675y0 = new ArrayList<>();
        this.A0 = new ArrayList<>();
        this.B0 = new ArrayList<>();
        this.E0 = "";
        this.F0 = new ArrayList<>();
        this.G0 = "";
        x0(parcel);
    }
}
