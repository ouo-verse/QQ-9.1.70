package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ar extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public long f404175d;

    /* renamed from: e, reason: collision with root package name */
    public String f404176e;

    /* renamed from: f, reason: collision with root package name */
    public String f404177f;

    /* renamed from: h, reason: collision with root package name */
    public String f404178h;

    /* renamed from: i, reason: collision with root package name */
    public String f404179i;

    public ar() {
        this(0L, null, null, null, null, 31, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ar(0L, null, null, null, null, 31, null));
    }

    public /* synthetic */ ar(long j3, String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", "", "", "");
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f404175d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f404176e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f404177f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f404178h, new b.e.g(false))), TuplesKt.to(5, new c45.h(5, this.f404179i, new b.e.g(false))));
        return mapOf;
    }

    public ar(long j3, String str, String str2, String str3, String str4) {
        this.f404175d = j3;
        this.f404176e = str;
        this.f404177f = str2;
        this.f404178h = str3;
        this.f404179i = str4;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
            this.f404175d = ((Long) obj).longValue();
            return;
        }
        if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404176e = (String) obj;
            return;
        }
        if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404177f = (String) obj;
        } else if (i3 == 4) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404178h = (String) obj;
        } else {
            if (i3 != 5) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f404179i = (String) obj;
        }
    }
}
