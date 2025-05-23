package e25;

import c45.b;
import com.tencent.mobileqq.startup.step.InitSkin;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ae extends c45.j {
    public long C;
    public float D;

    /* renamed from: d, reason: collision with root package name */
    public long f395438d;

    /* renamed from: e, reason: collision with root package name */
    public String f395439e;

    /* renamed from: f, reason: collision with root package name */
    public String f395440f;

    /* renamed from: h, reason: collision with root package name */
    public final List<y> f395441h;

    /* renamed from: i, reason: collision with root package name */
    public final List<i> f395442i;

    /* renamed from: m, reason: collision with root package name */
    public long f395443m;

    public ae() {
        this(0L, null, null, null, null, 0L, 0L, 0.0f, 255, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new ae(0L, null, null, null, null, 0L, 0L, 0.0f, 255, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f395438d = ((Long) obj).longValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f395439e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f395440f = (String) obj;
                return;
            case 4:
                List<y> list = this.f395441h;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.intimate_space.social_tree.PhotoSocialAsset>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            case 5:
                List<i> list2 = this.f395442i;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.intimate_space.social_tree.FlowerState>");
                CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
                return;
            case 6:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.f395443m = ((Long) obj).longValue();
                return;
            case 7:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                this.C = ((Long) obj).longValue();
                return;
            case 8:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
                this.D = ((Float) obj).floatValue();
                return;
            default:
                return;
        }
    }

    public /* synthetic */ ae(long j3, String str, String str2, List list, List list2, long j16, long j17, float f16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(0L, "", "", new ArrayList(), new ArrayList(), 0L, 0L, 0.0f);
    }

    public ae(long j3, String str, String str2, List<y> list, List<i> list2, long j16, long j17, float f16) {
        this.f395438d = j3;
        this.f395439e = str;
        this.f395440f = str2;
        this.f395441h = list;
        this.f395442i = list2;
        this.f395443m = j16;
        this.C = j17;
        this.D = f16;
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Long.valueOf(this.f395438d), new b.e.i(false))), TuplesKt.to(2, new c45.h(2, this.f395439e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f395440f, new b.e.g(false))), TuplesKt.to(4, new c45.h(4, this.f395441h, new b.f(new b.d(new y(null, null, 0, null, 15, null)), false))), TuplesKt.to(5, new c45.h(5, this.f395442i, new b.f(new b.d(new i(0L, null, 0L, null, null, 0, null, null, null, null, 0, null, 0L, InitSkin.DRAWABLE_COUNT, null)), false))), TuplesKt.to(6, new c45.h(6, Long.valueOf(this.f395443m), new b.e.i(false))), TuplesKt.to(7, new c45.h(7, Long.valueOf(this.C), new b.e.i(false))), TuplesKt.to(8, new c45.h(8, Float.valueOf(this.D), new b.e.d(false))));
        return mapOf;
    }
}
