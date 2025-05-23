package com.tencent.luggage.wxa.v2;

import com.tencent.luggage.wxa.cp.x;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class i {

    /* renamed from: e, reason: collision with root package name */
    public static final a f143031e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f143032a;

    /* renamed from: b, reason: collision with root package name */
    public final long f143033b;

    /* renamed from: c, reason: collision with root package name */
    public final int f143034c;

    /* renamed from: d, reason: collision with root package name */
    public final int f143035d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final i a(String path) {
            int a16;
            int a17;
            Intrinsics.checkNotNullParameter(path, "path");
            if (!x.d(path)) {
                return null;
            }
            try {
                com.tencent.luggage.wxa.ba.b bVar = new com.tencent.luggage.wxa.ba.b();
                bVar.setDataSource(path);
                int a18 = w0.a(bVar.extractMetadata(24), 0);
                if (a18 != 90 && a18 != 270) {
                    a16 = w0.a(bVar.extractMetadata(18), 0);
                    a17 = w0.a(bVar.extractMetadata(19), 0);
                } else {
                    a16 = w0.a(bVar.extractMetadata(19), 0);
                    a17 = w0.a(bVar.extractMetadata(18), 0);
                }
                long a19 = w0.a(bVar.extractMetadata(9), 0L);
                bVar.release();
                return new i(a19, x.e(path), a16, a17);
            } catch (Exception e16) {
                w.b("MicroMsg.VideoMetaData", "MetaDataRetriever failed, e = " + e16);
                return null;
            }
        }
    }

    public i(long j3, long j16, int i3, int i16) {
        this.f143032a = j3;
        this.f143033b = j16;
        this.f143034c = i3;
        this.f143035d = i16;
    }

    public final long a() {
        return this.f143032a;
    }

    public final int b() {
        return this.f143035d;
    }

    public final long c() {
        return this.f143033b;
    }

    public final int d() {
        return this.f143034c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (this.f143032a == iVar.f143032a && this.f143033b == iVar.f143033b && this.f143034c == iVar.f143034c && this.f143035d == iVar.f143035d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((androidx.fragment.app.a.a(this.f143032a) * 31) + androidx.fragment.app.a.a(this.f143033b)) * 31) + this.f143034c) * 31) + this.f143035d;
    }

    public String toString() {
        return "VideoMetaData(duration=" + this.f143032a + ", size=" + this.f143033b + ", width=" + this.f143034c + ", height=" + this.f143035d + ')';
    }
}
