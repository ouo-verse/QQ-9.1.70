package i25;

import c45.b;
import c45.f;
import c45.h;
import c45.j;
import c45.k;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import n35.w;
import p35.ah;
import pbandk.a;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class a extends j {

    /* renamed from: d, reason: collision with root package name */
    public final List<String> f407123d;

    /* renamed from: e, reason: collision with root package name */
    public ah f407124e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<String, String> f407125f;

    /* renamed from: h, reason: collision with root package name */
    public final List<w> f407126h;

    public /* synthetic */ a(ah ahVar, Map map, List list, int i3) {
        this((i3 & 1) != 0 ? new ArrayList() : null, (i3 & 2) != 0 ? null : ahVar, (Map<String, String>) ((i3 & 4) != 0 ? new LinkedHashMap() : map), (List<w>) ((i3 & 8) != 0 ? new ArrayList() : list));
    }

    @Override // c45.j
    public final j decodeWith(f fVar) {
        return fVar.g(new a((ah) null, (Map) (0 == true ? 1 : 0), (List) (0 == true ? 1 : 0), 15));
    }

    @Override // c45.j
    public final Map<Integer, h> getIndexes() {
        Map<Integer, h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new h(1, this.f407123d, new b.f(new b.e.g(false), false))), TuplesKt.to(2, new h(2, this.f407124e, new b.d(new ah(null, null, 0, null, null, 0, null, 0, 0, null, null, null, null, 0, 0, null, null, null, null, null, null, 2097151)))), TuplesKt.to(3, new h(3, this.f407125f, new b.C0166b(new b.e.g(false), new b.e.g(false)))), TuplesKt.to(4, new h(4, this.f407126h, new b.f(new b.d(new w(null, null, 3, null)), false))));
        return mapOf;
    }

    public a(List<String> list, ah ahVar, Map<String, String> map, List<w> list2) {
        this.f407123d = list;
        this.f407124e = ahVar;
        this.f407125f = map;
        this.f407126h = list2;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            List<String> list = this.f407123d;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kotlin.String>");
            CollectionsKt__MutableCollectionsKt.addAll(list, (Sequence) obj);
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common.feed.StPoiInfoV2");
            this.f407124e = (ah) obj;
        } else if (i3 == 3) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type pbandk.MessageMap.Entry<kotlin.String, kotlin.String>");
            k.a((a.c) obj, this.f407125f);
        } else {
            if (i3 != 4) {
                return;
            }
            List<w> list2 = this.f407126h;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.sequences.Sequence<kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.MsgInfo>");
            CollectionsKt__MutableCollectionsKt.addAll(list2, (Sequence) obj);
        }
    }
}
