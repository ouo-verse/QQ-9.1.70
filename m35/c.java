package m35;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
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
public final class c extends j {

    /* renamed from: d, reason: collision with root package name */
    public int f416088d;

    /* renamed from: e, reason: collision with root package name */
    public String f416089e;

    /* renamed from: f, reason: collision with root package name */
    public int f416090f;

    /* renamed from: h, reason: collision with root package name */
    public int f416091h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f416092i;

    /* renamed from: m, reason: collision with root package name */
    public final List<a> f416093m;

    public c() {
        this(0, null, 0, 0, false, null, 63, null);
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new c(0, null, 0, 0, false, null, 63, null));
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        switch (i3) {
            case 1:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f416088d = ((Integer) obj).intValue();
                return;
            case 2:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                this.f416089e = (String) obj;
                return;
            case 3:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f416090f = ((Integer) obj).intValue();
                return;
            case 4:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
                this.f416091h = ((Integer) obj).intValue();
                return;
            case 5:
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                this.f416092i = ((Boolean) obj).booleanValue();
                return;
            case 6:
                List<a> list = this.f416093m;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.filenotify.FileInfo>");
                CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
                return;
            default:
                return;
        }
    }

    public /* synthetic */ c(int i3, String str, int i16, int i17, boolean z16, List list, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this(0, "", 0, 0, false, new ArrayList());
    }

    public c(int i3, String str, int i16, int i17, boolean z16, List<a> list) {
        this.f416088d = i3;
        this.f416089e = str;
        this.f416090f = i16;
        this.f416091h = i17;
        this.f416092i = z16;
        this.f416093m = list;
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, Integer.valueOf(this.f416088d), new b.e.h(false))), TuplesKt.to(2, new h(2, this.f416089e, new b.e.g(false))), TuplesKt.to(3, new h(3, Integer.valueOf(this.f416090f), new b.e.h(false))), TuplesKt.to(4, new h(4, Integer.valueOf(this.f416091h), new b.e.h(false))), TuplesKt.to(5, new h(5, Boolean.valueOf(this.f416092i), new b.e.a(false))), TuplesKt.to(6, new h(6, this.f416093m, new b.f(new b.d(new a(0L, 0L, 0, null, null, null, null, null, 0L, 0, 0, null, null, 0, 0, 32767, null)), false))));
        return mapOf;
    }
}
