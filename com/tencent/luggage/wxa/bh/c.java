package com.tencent.luggage.wxa.bh;

import android.os.SystemClock;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.tencent.luggage.wxa.d0.n;
import com.tencent.luggage.wxa.k0.f;
import com.tencent.luggage.wxa.l0.d;
import com.tencent.luggage.wxa.m.j;
import com.tencent.luggage.wxa.tn.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c extends com.tencent.luggage.wxa.k0.a {

    /* renamed from: p, reason: collision with root package name */
    public static final a f122730p = new a(null);

    /* renamed from: q, reason: collision with root package name */
    public static final int f122731q = AdaptiveTrackSelection.DEFAULT_MAX_INITIAL_BITRATE;

    /* renamed from: r, reason: collision with root package name */
    public static final int f122732r = 10000;

    /* renamed from: s, reason: collision with root package name */
    public static final int f122733s = 25000;

    /* renamed from: t, reason: collision with root package name */
    public static final int f122734t = 25000;

    /* renamed from: u, reason: collision with root package name */
    public static final float f122735u = 0.75f;

    /* renamed from: g, reason: collision with root package name */
    public final d f122736g;

    /* renamed from: h, reason: collision with root package name */
    public final int f122737h;

    /* renamed from: i, reason: collision with root package name */
    public final float f122738i;

    /* renamed from: j, reason: collision with root package name */
    public final long f122739j;

    /* renamed from: k, reason: collision with root package name */
    public final long f122740k;

    /* renamed from: l, reason: collision with root package name */
    public final long f122741l;

    /* renamed from: m, reason: collision with root package name */
    public int f122742m;

    /* renamed from: n, reason: collision with root package name */
    public int f122743n;

    /* renamed from: o, reason: collision with root package name */
    public volatile double f122744o;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class b implements f.a {

        /* renamed from: a, reason: collision with root package name */
        public final d f122745a;

        /* renamed from: b, reason: collision with root package name */
        public final int f122746b;

        /* renamed from: c, reason: collision with root package name */
        public final int f122747c;

        /* renamed from: d, reason: collision with root package name */
        public final int f122748d;

        /* renamed from: e, reason: collision with root package name */
        public final int f122749e;

        /* renamed from: f, reason: collision with root package name */
        public final float f122750f;

        /* renamed from: g, reason: collision with root package name */
        public final ArrayList f122751g;

        /* renamed from: h, reason: collision with root package name */
        public volatile double f122752h;

        public b(d bandwidthMeter, int i3, int i16, int i17, int i18, float f16) {
            Intrinsics.checkNotNullParameter(bandwidthMeter, "bandwidthMeter");
            this.f122745a = bandwidthMeter;
            this.f122746b = i3;
            this.f122747c = i16;
            this.f122748d = i17;
            this.f122749e = i18;
            this.f122750f = f16;
            this.f122751g = new ArrayList();
            this.f122752h = -1.0d;
        }

        @Override // com.tencent.luggage.wxa.k0.f.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(n group, int... tracks) {
            Intrinsics.checkNotNullParameter(group, "group");
            Intrinsics.checkNotNullParameter(tracks, "tracks");
            c cVar = new c(group, tracks, this.f122745a, this.f122746b, this.f122747c, this.f122748d, this.f122749e, this.f122750f);
            cVar.a(this.f122752h);
            this.f122751g.add(cVar);
            return cVar;
        }

        public final void a(double d16) {
            w.d("MicroMsg.AdavanceTrackSelection", "set#preferredPeakBitRate, value: " + d16);
            this.f122752h = d16;
            Iterator it = this.f122751g.iterator();
            while (it.hasNext()) {
                ((c) it.next()).a(d16);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(n group, int[] tracks, d bandwidthMeter, int i3, long j3, long j16, long j17, float f16) {
        super(group, Arrays.copyOf(tracks, tracks.length));
        com.tencent.luggage.wxa.bh.a aVar;
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(tracks, "tracks");
        Intrinsics.checkNotNullParameter(bandwidthMeter, "bandwidthMeter");
        this.f122736g = bandwidthMeter;
        this.f122737h = i3;
        this.f122738i = f16;
        this.f122744o = -1.0d;
        this.f122739j = j3 * 1000;
        this.f122740k = j16 * 1000;
        this.f122741l = j17 * 1000;
        if (bandwidthMeter instanceof com.tencent.luggage.wxa.bh.a) {
            aVar = (com.tencent.luggage.wxa.bh.a) bandwidthMeter;
        } else {
            aVar = null;
        }
        if (aVar != null) {
            aVar.b();
        }
        this.f122742m = b(-1L);
        this.f122743n = 1;
    }

    public final void a(double d16) {
        this.f122744o = d16;
    }

    @Override // com.tencent.luggage.wxa.k0.f
    public Object b() {
        return null;
    }

    @Override // com.tencent.luggage.wxa.k0.f
    public int f() {
        return this.f122743n;
    }

    @Override // com.tencent.luggage.wxa.k0.f
    public void a(long j3) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i3 = this.f122742m;
        int b16 = b(elapsedRealtime);
        this.f122742m = b16;
        if (b16 != i3) {
            if (!b(i3, elapsedRealtime)) {
                j a16 = a(i3);
                int i16 = a(this.f122742m).f133892b;
                int i17 = a16.f133892b;
                if (i16 > i17 && j3 < this.f122739j) {
                    w.d("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack < selectIndex = " + this.f122742m + ", bufferedDurationUs = " + j3 + ", min = " + this.f122739j);
                    this.f122742m = i3;
                } else if (i16 < i17 && j3 >= this.f122740k) {
                    w.d("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack > selectIndex = " + this.f122742m + ", bufferedDurationUs = " + j3);
                    this.f122742m = i3;
                }
            }
            if (this.f122742m != i3) {
                this.f122743n = 3;
            }
        }
        w.d("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] updateSelectedTrack selectIndex = " + this.f122742m);
    }

    public final int b(long j3) {
        long j16;
        long a16 = this.f122736g.a();
        double d16 = this.f122744o;
        if (!Double.isNaN(d16) && 0.0d < d16) {
            j16 = (long) d16;
        } else if (a16 == -1) {
            j16 = this.f122737h;
        } else {
            j16 = ((float) a16) * this.f122738i;
        }
        w.d("MicroMsg.AdavanceTrackSelection", "[TRACE_ADAPTIVE] determineIdealSelectedIndex bitrateEstimate = " + a16 + ", effectiveBitrate = " + j16);
        int i3 = this.f131370b;
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            if (j3 == -1 || !b(i17, j3)) {
                if (a(i17).f133892b <= j16) {
                    return i17;
                }
                i16 = i17;
            }
        }
        return i16;
    }

    @Override // com.tencent.luggage.wxa.k0.f
    public int a() {
        return this.f122742m;
    }
}
