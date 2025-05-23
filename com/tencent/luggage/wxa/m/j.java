package com.tencent.luggage.wxa.m;

import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.luggage.wxa.n0.v;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j implements Parcelable {
    public static final Parcelable.Creator<j> CREATOR = new a();
    public final float C;
    public final int D;
    public final byte[] E;
    public final com.tencent.luggage.wxa.o0.b F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final int K;
    public final long L;
    public final int M;
    public final String N;
    public final int O;
    public int P;

    /* renamed from: a, reason: collision with root package name */
    public final String f133891a;

    /* renamed from: b, reason: collision with root package name */
    public final int f133892b;

    /* renamed from: c, reason: collision with root package name */
    public final String f133893c;

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.a0.a f133894d;

    /* renamed from: e, reason: collision with root package name */
    public final String f133895e;

    /* renamed from: f, reason: collision with root package name */
    public final String f133896f;

    /* renamed from: g, reason: collision with root package name */
    public final int f133897g;

    /* renamed from: h, reason: collision with root package name */
    public final List f133898h;

    /* renamed from: i, reason: collision with root package name */
    public final com.tencent.luggage.wxa.p.a f133899i;

    /* renamed from: j, reason: collision with root package name */
    public final int f133900j;

    /* renamed from: k, reason: collision with root package name */
    public final int f133901k;

    /* renamed from: l, reason: collision with root package name */
    public final float f133902l;

    /* renamed from: m, reason: collision with root package name */
    public final int f133903m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i3) {
            return new j[i3];
        }
    }

    public j(String str, String str2, String str3, String str4, int i3, int i16, int i17, int i18, float f16, int i19, float f17, byte[] bArr, int i26, com.tencent.luggage.wxa.o0.b bVar, int i27, int i28, int i29, int i36, int i37, int i38, String str5, int i39, long j3, List list, com.tencent.luggage.wxa.p.a aVar, com.tencent.luggage.wxa.a0.a aVar2) {
        this.f133891a = str;
        this.f133895e = str2;
        this.f133896f = str3;
        this.f133893c = str4;
        this.f133892b = i3;
        this.f133897g = i16;
        this.f133900j = i17;
        this.f133901k = i18;
        this.f133902l = f16;
        this.f133903m = i19;
        this.C = f17;
        this.E = bArr;
        this.D = i26;
        this.F = bVar;
        this.G = i27;
        this.H = i28;
        this.I = i29;
        this.J = i36;
        this.K = i37;
        this.M = i38;
        this.N = str5;
        this.O = i39;
        this.L = j3;
        this.f133898h = list == null ? Collections.emptyList() : list;
        this.f133899i = aVar;
        this.f133894d = aVar2;
    }

    public static j a(String str, String str2, String str3, String str4, int i3, int i16, int i17, float f16, List list, int i18) {
        return new j(str, str2, str3, str4, i3, -1, i16, i17, f16, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i18, null, -1, Long.MAX_VALUE, list, null, null);
    }

    public static j b(String str, String str2, String str3, String str4, int i3, int i16, String str5) {
        return a(str, str2, str3, str4, i3, i16, str5, -1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j.class == obj.getClass()) {
            j jVar = (j) obj;
            if (this.f133892b == jVar.f133892b && this.f133897g == jVar.f133897g && this.f133900j == jVar.f133900j && this.f133901k == jVar.f133901k && this.f133902l == jVar.f133902l && this.f133903m == jVar.f133903m && this.C == jVar.C && this.D == jVar.D && this.G == jVar.G && this.H == jVar.H && this.I == jVar.I && this.J == jVar.J && this.K == jVar.K && this.L == jVar.L && this.M == jVar.M && v.a(this.f133891a, jVar.f133891a) && v.a(this.N, jVar.N) && this.O == jVar.O && v.a(this.f133895e, jVar.f133895e) && v.a(this.f133896f, jVar.f133896f) && v.a(this.f133893c, jVar.f133893c) && v.a(this.f133899i, jVar.f133899i) && v.a(this.f133894d, jVar.f133894d) && v.a(this.F, jVar.F) && Arrays.equals(this.E, jVar.E) && this.f133898h.size() == jVar.f133898h.size()) {
                for (int i3 = 0; i3 < this.f133898h.size(); i3++) {
                    if (!Arrays.equals((byte[]) this.f133898h.get(i3), (byte[]) jVar.f133898h.get(i3))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        if (this.P == 0) {
            String str = this.f133891a;
            int i3 = 0;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            int i16 = (hashCode + 527) * 31;
            String str2 = this.f133895e;
            if (str2 == null) {
                hashCode2 = 0;
            } else {
                hashCode2 = str2.hashCode();
            }
            int i17 = (i16 + hashCode2) * 31;
            String str3 = this.f133896f;
            if (str3 == null) {
                hashCode3 = 0;
            } else {
                hashCode3 = str3.hashCode();
            }
            int i18 = (i17 + hashCode3) * 31;
            String str4 = this.f133893c;
            if (str4 == null) {
                hashCode4 = 0;
            } else {
                hashCode4 = str4.hashCode();
            }
            int i19 = (((((((((((i18 + hashCode4) * 31) + this.f133892b) * 31) + this.f133900j) * 31) + this.f133901k) * 31) + this.G) * 31) + this.H) * 31;
            String str5 = this.N;
            if (str5 == null) {
                hashCode5 = 0;
            } else {
                hashCode5 = str5.hashCode();
            }
            int i26 = (((i19 + hashCode5) * 31) + this.O) * 31;
            com.tencent.luggage.wxa.p.a aVar = this.f133899i;
            if (aVar == null) {
                hashCode6 = 0;
            } else {
                hashCode6 = aVar.hashCode();
            }
            int i27 = (i26 + hashCode6) * 31;
            com.tencent.luggage.wxa.a0.a aVar2 = this.f133894d;
            if (aVar2 != null) {
                i3 = aVar2.hashCode();
            }
            this.P = i27 + i3;
        }
        return this.P;
    }

    public String toString() {
        return "Format(" + this.f133891a + ", " + this.f133895e + ", " + this.f133896f + ", " + this.f133892b + ", " + this.N + ", [" + this.f133900j + ", " + this.f133901k + ", " + this.f133902l + "], [" + this.G + ", " + this.H + "])";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i16;
        parcel.writeString(this.f133891a);
        parcel.writeString(this.f133895e);
        parcel.writeString(this.f133896f);
        parcel.writeString(this.f133893c);
        parcel.writeInt(this.f133892b);
        parcel.writeInt(this.f133897g);
        parcel.writeInt(this.f133900j);
        parcel.writeInt(this.f133901k);
        parcel.writeFloat(this.f133902l);
        parcel.writeInt(this.f133903m);
        parcel.writeFloat(this.C);
        if (this.E != null) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        parcel.writeInt(i16);
        byte[] bArr = this.E;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.D);
        parcel.writeParcelable(this.F, i3);
        parcel.writeInt(this.G);
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        parcel.writeInt(this.K);
        parcel.writeInt(this.M);
        parcel.writeString(this.N);
        parcel.writeInt(this.O);
        parcel.writeLong(this.L);
        int size = this.f133898h.size();
        parcel.writeInt(size);
        for (int i17 = 0; i17 < size; i17++) {
            parcel.writeByteArray((byte[]) this.f133898h.get(i17));
        }
        parcel.writeParcelable(this.f133899i, 0);
        parcel.writeParcelable(this.f133894d, 0);
    }

    public static j a(String str, String str2, String str3, int i3, int i16, int i17, int i18, float f16, List list, int i19, float f17, com.tencent.luggage.wxa.p.a aVar) {
        return a(str, str2, str3, i3, i16, i17, i18, f16, list, i19, f17, (byte[]) null, -1, (com.tencent.luggage.wxa.o0.b) null, aVar);
    }

    public int b() {
        int i3;
        int i16 = this.f133900j;
        if (i16 == -1 || (i3 = this.f133901k) == -1) {
            return -1;
        }
        return i16 * i3;
    }

    public static j a(String str, String str2, String str3, int i3, int i16, int i17, int i18, float f16, List list, int i19, float f17, byte[] bArr, int i26, com.tencent.luggage.wxa.o0.b bVar, com.tencent.luggage.wxa.p.a aVar) {
        return new j(str, null, str2, str3, i3, i16, i17, i18, f16, i19, f17, bArr, i26, bVar, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, list, aVar, null);
    }

    public static j a(String str, String str2, String str3, String str4, int i3, int i16, int i17, List list, int i18, String str5) {
        return new j(str, str2, str3, str4, i3, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i16, i17, -1, -1, -1, i18, str5, -1, Long.MAX_VALUE, list, null, null);
    }

    public static j a(String str, String str2, String str3, int i3, int i16, int i17, int i18, List list, com.tencent.luggage.wxa.p.a aVar, int i19, String str4) {
        return a(str, str2, str3, i3, i16, i17, i18, -1, list, aVar, i19, str4);
    }

    public static j a(String str, String str2, String str3, int i3, int i16, int i17, int i18, int i19, List list, com.tencent.luggage.wxa.p.a aVar, int i26, String str4) {
        return a(str, str2, str3, i3, i16, i17, i18, i19, -1, -1, list, aVar, i26, str4, (com.tencent.luggage.wxa.a0.a) null);
    }

    public static j a(String str, String str2, String str3, int i3, int i16, int i17, int i18, int i19, int i26, int i27, List list, com.tencent.luggage.wxa.p.a aVar, int i28, String str4, com.tencent.luggage.wxa.a0.a aVar2) {
        return new j(str, null, str2, str3, i3, i16, -1, -1, -1.0f, -1, -1.0f, null, -1, null, i17, i18, i19, i26, i27, i28, str4, -1, Long.MAX_VALUE, list, aVar, aVar2);
    }

    public static j a(String str, String str2, String str3, String str4, int i3, int i16, String str5, int i17) {
        return new j(str, str2, str3, str4, i3, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i16, str5, i17, Long.MAX_VALUE, null, null, null);
    }

    public static j a(String str, String str2, int i3, String str3) {
        return a(str, str2, i3, str3, (com.tencent.luggage.wxa.p.a) null);
    }

    public static j a(String str, String str2, int i3, String str3, com.tencent.luggage.wxa.p.a aVar) {
        return a(str, str2, (String) null, -1, i3, str3, -1, aVar, Long.MAX_VALUE, Collections.emptyList());
    }

    public static j a(String str, String str2, String str3, int i3, int i16, String str4, int i17, com.tencent.luggage.wxa.p.a aVar) {
        return a(str, str2, str3, i3, i16, str4, i17, aVar, Long.MAX_VALUE, Collections.emptyList());
    }

    public static j a(String str, String str2, String str3, int i3, int i16, String str4, com.tencent.luggage.wxa.p.a aVar, long j3) {
        return a(str, str2, str3, i3, i16, str4, -1, aVar, j3, Collections.emptyList());
    }

    public static j a(String str, String str2, String str3, int i3, int i16, String str4, int i17, com.tencent.luggage.wxa.p.a aVar, long j3, List list) {
        return new j(str, null, str2, str3, i3, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i16, str4, i17, j3, list, aVar, null);
    }

    public static j a(String str, String str2, String str3, int i3, List list, String str4, com.tencent.luggage.wxa.p.a aVar) {
        return new j(str, null, str2, str3, i3, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, str4, -1, Long.MAX_VALUE, list, aVar, null);
    }

    public static j a(String str, String str2, String str3, String str4, int i3, int i16, String str5) {
        return new j(str, str2, str3, str4, i3, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, i16, str5, -1, Long.MAX_VALUE, null, null, null);
    }

    public static j a(String str, String str2, long j3) {
        return new j(str, null, str2, null, -1, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, j3, null, null, null);
    }

    public static j a(String str, String str2, String str3, int i3, com.tencent.luggage.wxa.p.a aVar) {
        return new j(str, null, str2, str3, i3, -1, -1, -1, -1.0f, -1, -1.0f, null, -1, null, -1, -1, -1, -1, -1, 0, null, -1, Long.MAX_VALUE, null, aVar, null);
    }

    public j a(int i3) {
        return new j(this.f133891a, this.f133895e, this.f133896f, this.f133893c, this.f133892b, i3, this.f133900j, this.f133901k, this.f133902l, this.f133903m, this.C, this.E, this.D, this.F, this.G, this.H, this.I, this.J, this.K, this.M, this.N, this.O, this.L, this.f133898h, this.f133899i, this.f133894d);
    }

    public j a(long j3) {
        return new j(this.f133891a, this.f133895e, this.f133896f, this.f133893c, this.f133892b, this.f133897g, this.f133900j, this.f133901k, this.f133902l, this.f133903m, this.C, this.E, this.D, this.F, this.G, this.H, this.I, this.J, this.K, this.M, this.N, this.O, j3, this.f133898h, this.f133899i, this.f133894d);
    }

    public j a(String str, String str2, int i3, int i16, int i17, int i18, String str3) {
        return new j(str, this.f133895e, this.f133896f, str2, i3, this.f133897g, i16, i17, this.f133902l, this.f133903m, this.C, this.E, this.D, this.F, this.G, this.H, this.I, this.J, this.K, i18, str3, this.O, this.L, this.f133898h, this.f133899i, this.f133894d);
    }

    public j a(int i3, int i16) {
        return new j(this.f133891a, this.f133895e, this.f133896f, this.f133893c, this.f133892b, this.f133897g, this.f133900j, this.f133901k, this.f133902l, this.f133903m, this.C, this.E, this.D, this.F, this.G, this.H, this.I, i3, i16, this.M, this.N, this.O, this.L, this.f133898h, this.f133899i, this.f133894d);
    }

    public j a(com.tencent.luggage.wxa.p.a aVar) {
        return new j(this.f133891a, this.f133895e, this.f133896f, this.f133893c, this.f133892b, this.f133897g, this.f133900j, this.f133901k, this.f133902l, this.f133903m, this.C, this.E, this.D, this.F, this.G, this.H, this.I, this.J, this.K, this.M, this.N, this.O, this.L, this.f133898h, aVar, this.f133894d);
    }

    public j a(com.tencent.luggage.wxa.a0.a aVar) {
        return new j(this.f133891a, this.f133895e, this.f133896f, this.f133893c, this.f133892b, this.f133897g, this.f133900j, this.f133901k, this.f133902l, this.f133903m, this.C, this.E, this.D, this.F, this.G, this.H, this.I, this.J, this.K, this.M, this.N, this.O, this.L, this.f133898h, this.f133899i, aVar);
    }

    public final MediaFormat a() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.f133896f);
        a(mediaFormat, IjkMediaMeta.IJKM_KEY_LANGUAGE, this.N);
        a(mediaFormat, "max-input-size", this.f133897g);
        a(mediaFormat, "width", this.f133900j);
        a(mediaFormat, "height", this.f133901k);
        a(mediaFormat, "frame-rate", this.f133902l);
        a(mediaFormat, "rotation-degrees", this.f133903m);
        a(mediaFormat, "channel-count", this.G);
        a(mediaFormat, "sample-rate", this.H);
        a(mediaFormat, "encoder-delay", this.J);
        a(mediaFormat, "encoder-padding", this.K);
        for (int i3 = 0; i3 < this.f133898h.size(); i3++) {
            mediaFormat.setByteBuffer("csd-" + i3, ByteBuffer.wrap((byte[]) this.f133898h.get(i3)));
        }
        a(mediaFormat, this.F);
        return mediaFormat;
    }

    public j(Parcel parcel) {
        this.f133891a = parcel.readString();
        this.f133895e = parcel.readString();
        this.f133896f = parcel.readString();
        this.f133893c = parcel.readString();
        this.f133892b = parcel.readInt();
        this.f133897g = parcel.readInt();
        this.f133900j = parcel.readInt();
        this.f133901k = parcel.readInt();
        this.f133902l = parcel.readFloat();
        this.f133903m = parcel.readInt();
        this.C = parcel.readFloat();
        this.E = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.D = parcel.readInt();
        this.F = (com.tencent.luggage.wxa.o0.b) parcel.readParcelable(com.tencent.luggage.wxa.o0.b.class.getClassLoader());
        this.G = parcel.readInt();
        this.H = parcel.readInt();
        this.I = parcel.readInt();
        this.J = parcel.readInt();
        this.K = parcel.readInt();
        this.M = parcel.readInt();
        this.N = parcel.readString();
        this.O = parcel.readInt();
        this.L = parcel.readLong();
        int readInt = parcel.readInt();
        this.f133898h = new ArrayList(readInt);
        for (int i3 = 0; i3 < readInt; i3++) {
            this.f133898h.add(parcel.createByteArray());
        }
        this.f133899i = (com.tencent.luggage.wxa.p.a) parcel.readParcelable(com.tencent.luggage.wxa.p.a.class.getClassLoader());
        this.f133894d = (com.tencent.luggage.wxa.a0.a) parcel.readParcelable(com.tencent.luggage.wxa.a0.a.class.getClassLoader());
    }

    public static void a(MediaFormat mediaFormat, com.tencent.luggage.wxa.o0.b bVar) {
        if (bVar == null) {
            return;
        }
        a(mediaFormat, "color-transfer", bVar.f135966c);
        a(mediaFormat, "color-standard", bVar.f135964a);
        a(mediaFormat, "color-range", bVar.f135965b);
        a(mediaFormat, "hdr-static-info", bVar.f135967d);
    }

    public static void a(MediaFormat mediaFormat, String str, String str2) {
        if (str2 != null) {
            mediaFormat.setString(str, str2);
        }
    }

    public static void a(MediaFormat mediaFormat, String str, int i3) {
        if (i3 != -1) {
            mediaFormat.setInteger(str, i3);
        }
    }

    public static void a(MediaFormat mediaFormat, String str, float f16) {
        if (f16 != -1.0f) {
            mediaFormat.setFloat(str, f16);
        }
    }

    public static void a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static String a(j jVar) {
        if (jVar == null) {
            return "null";
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("id=");
        sb5.append(jVar.f133891a);
        sb5.append(", mimeType=");
        sb5.append(jVar.f133896f);
        if (jVar.f133892b != -1) {
            sb5.append(", bitrate=");
            sb5.append(jVar.f133892b);
        }
        if (jVar.f133900j != -1 && jVar.f133901k != -1) {
            sb5.append(", res=");
            sb5.append(jVar.f133900j);
            sb5.append(HippyTKDListViewAdapter.X);
            sb5.append(jVar.f133901k);
        }
        if (jVar.f133902l != -1.0f) {
            sb5.append(", fps=");
            sb5.append(jVar.f133902l);
        }
        if (jVar.G != -1) {
            sb5.append(", channels=");
            sb5.append(jVar.G);
        }
        if (jVar.H != -1) {
            sb5.append(", sample_rate=");
            sb5.append(jVar.H);
        }
        if (jVar.N != null) {
            sb5.append(", language=");
            sb5.append(jVar.N);
        }
        return sb5.toString();
    }
}
