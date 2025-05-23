package h25;

import c45.b;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class w extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public float f404248d;

    /* renamed from: e, reason: collision with root package name */
    public float f404249e;

    /* renamed from: f, reason: collision with root package name */
    public float f404250f;

    public w() {
        this(0.0f, 0.0f, 0.0f, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new w(0.0f, 0.0f, 0.0f, 7, null));
    }

    public /* synthetic */ w(float f16, float f17, float f18, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0.0f, 0.0f, 0.0f);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Float.valueOf(this.f404248d), new b.e.d(false))), TuplesKt.to(2, new c45.h(2, Float.valueOf(this.f404249e), new b.e.d(false))), TuplesKt.to(3, new c45.h(3, Float.valueOf(this.f404250f), new b.e.d(false))));
        return mapOf;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            this.f404248d = ((Float) obj).floatValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            this.f404249e = ((Float) obj).floatValue();
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
            this.f404250f = ((Float) obj).floatValue();
        }
    }

    public w(float f16, float f17, float f18) {
        this.f404248d = f16;
        this.f404249e = f17;
        this.f404250f = f18;
    }
}
