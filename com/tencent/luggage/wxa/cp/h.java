package com.tencent.luggage.wxa.cp;

import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.cp.k;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends com.tencent.luggage.wxa.cp.a {
    public static final Parcelable.Creator<h> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final k f123757a;

    /* renamed from: b, reason: collision with root package name */
    public final long f123758b;

    /* renamed from: c, reason: collision with root package name */
    public final g f123759c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f123760d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h createFromParcel(Parcel parcel) {
            return new h(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h[] newArray(int i3) {
            return new h[i3];
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b extends f {

        /* renamed from: a, reason: collision with root package name */
        public final k.a f123761a;

        /* renamed from: b, reason: collision with root package name */
        public final List f123762b;

        /* renamed from: c, reason: collision with root package name */
        public final long f123763c;

        public b(k.a aVar, long j3, Map map) {
            super(h.this, map);
            this.f123761a = aVar;
            this.f123762b = Collections.singletonList(aVar);
            this.f123763c = j3;
        }

        @Override // com.tencent.luggage.wxa.cp.f
        public k.a a(String str, int i3) {
            return this.f123761a;
        }

        @Override // com.tencent.luggage.wxa.cp.f
        public List c() {
            return this.f123762b;
        }

        @Override // com.tencent.luggage.wxa.cp.k.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public h b() {
            return h.this;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.f123761a.equals(bVar.f123761a) || this.f123763c != bVar.f123763c) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return b.class.hashCode() ^ c0.a(this.f123761a, Long.valueOf(this.f123763c));
        }

        @Override // com.tencent.luggage.wxa.cp.b
        public String toString() {
            return "expire(" + c0.a(this.f123763c) + ") <- " + this.f123761a;
        }

        @Override // com.tencent.luggage.wxa.cp.f, com.tencent.luggage.wxa.cp.b, com.tencent.luggage.wxa.cp.k.a
        public void a(CancellationSignal cancellationSignal) {
            int i3;
            int i16;
            long currentTimeMillis = System.currentTimeMillis() - this.f123763c;
            long j3 = 0;
            try {
                Iterable<i> a16 = c0.a(this.f123761a, "", true);
                if (a16 != null) {
                    long j16 = 0;
                    i3 = 0;
                    for (i iVar : a16) {
                        try {
                            cancellationSignal.throwIfCanceled();
                            if (iVar.f123770f) {
                                if (h.this.f123760d) {
                                    iVar.f123771g.b(iVar.f123765a, false);
                                }
                            } else if (iVar.f123769e <= currentTimeMillis && iVar.a()) {
                                long j17 = iVar.f123768d;
                                if (j17 < 0) {
                                    j17 = iVar.f123767c;
                                }
                                j16 += j17;
                                i3++;
                            }
                        } catch (Exception e16) {
                            e = e16;
                            j3 = j16;
                            try {
                                i16 = e instanceof OperationCanceledException ? 4 : 5;
                            } catch (Throwable th5) {
                                th = th5;
                                i16 = 3;
                                a(i16, "deleteSize", Long.valueOf(j3), "deleteFiles", Integer.valueOf(i3));
                                throw th;
                            }
                            try {
                                throw e;
                            } catch (Throwable th6) {
                                th = th6;
                                a(i16, "deleteSize", Long.valueOf(j3), "deleteFiles", Integer.valueOf(i3));
                                throw th;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            j3 = j16;
                            i16 = 3;
                            a(i16, "deleteSize", Long.valueOf(j3), "deleteFiles", Integer.valueOf(i3));
                            throw th;
                        }
                    }
                    j3 = j16;
                } else {
                    i3 = 0;
                }
                a(3, "deleteSize", Long.valueOf(j3), "deleteFiles", Integer.valueOf(i3));
                super.a(cancellationSignal);
            } catch (Exception e17) {
                e = e17;
                i3 = 0;
            } catch (Throwable th8) {
                th = th8;
                i3 = 0;
            }
        }
    }

    public h(k kVar, long j3) {
        this.f123757a = kVar;
        this.f123758b = j3;
        this.f123759c = null;
        this.f123760d = false;
    }

    @Override // com.tencent.luggage.wxa.cp.d
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k.a a(Map map) {
        long a16;
        k.a aVar = (k.a) this.f123757a.a(map);
        g gVar = this.f123759c;
        if (gVar == null) {
            a16 = this.f123758b;
        } else {
            a16 = c0.a(gVar.a(map), this.f123758b);
        }
        return new b(aVar, a16, map);
    }

    @Override // com.tencent.luggage.wxa.cp.a, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f123758b != hVar.f123758b || this.f123760d != hVar.f123760d || !this.f123757a.equals(hVar.f123757a) || !c0.a(this.f123759c, hVar.f123759c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return h.class.hashCode() ^ c0.a(this.f123757a, Long.valueOf(this.f123758b), this.f123759c, Boolean.valueOf(this.f123760d));
    }

    public String toString() {
        String gVar;
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("expire(");
        g gVar2 = this.f123759c;
        if (gVar2 == null) {
            gVar = c0.a(this.f123758b);
        } else {
            gVar = gVar2.toString();
        }
        sb5.append(gVar);
        if (this.f123760d) {
            str = ", D";
        } else {
            str = "";
        }
        sb5.append(str);
        sb5.append(") <- ");
        sb5.append(this.f123757a);
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        String str;
        c0.b(parcel, h.class, 3);
        parcel.writeParcelable(this.f123757a, i3);
        parcel.writeLong(this.f123758b);
        g gVar = this.f123759c;
        if (gVar == null) {
            str = null;
        } else {
            str = gVar.f123752a;
        }
        parcel.writeString(str);
        parcel.writeByte(this.f123760d ? (byte) 1 : (byte) 0);
    }

    public h(Parcel parcel) {
        c0.a(parcel, h.class, 3);
        k kVar = (k) parcel.readParcelable(getClass().getClassLoader());
        this.f123757a = kVar;
        if (kVar != null) {
            this.f123758b = parcel.readLong();
            String readString = parcel.readString();
            this.f123759c = readString == null ? null : new g(readString);
            this.f123760d = parcel.readByte() != 0;
            return;
        }
        throw new IllegalArgumentException("Wrong wrapped filesystem.");
    }
}
