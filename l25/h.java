package l25;

import c45.b;
import c45.d;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class h extends c45.j {

    /* renamed from: d, reason: collision with root package name */
    public int f413764d;

    /* renamed from: e, reason: collision with root package name */
    public String f413765e;

    /* renamed from: f, reason: collision with root package name */
    public i f413766f;

    public h() {
        this(0, null, null, 7, null);
    }

    @Override // c45.j
    public final c45.j decodeWith(c45.f fVar) {
        return fVar.g(new h(0, null, null, 7, null));
    }

    public /* synthetic */ h(int i3, String str, i iVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(d.c.f30317b.b().getValue(), "", null);
    }

    @Override // c45.j
    public final Map<Integer, c45.h> getIndexes() {
        Map<Integer, c45.h> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(1, new c45.h(1, Integer.valueOf(this.f413764d), new b.a(false))), TuplesKt.to(2, new c45.h(2, this.f413765e, new b.e.g(false))), TuplesKt.to(3, new c45.h(3, this.f413766f, new b.d(new i("")))));
        return mapOf;
    }

    public h(int i3, String str, i iVar) {
        this.f413764d = i3;
        this.f413765e = str;
        this.f413766f = iVar;
    }

    @Override // c45.j
    public final void setValue(int i3, Object obj) {
        if (i3 == 1) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int{ kuikly.com.tencent.trpcprotocol.lplan.common.channel_feed.Channel_feedKt.RichTextContentType }");
            this.f413764d = ((Integer) obj).intValue();
        } else if (i3 == 2) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            this.f413765e = (String) obj;
        } else {
            if (i3 != 3) {
                return;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.lplan.common.channel_feed.ChRichTextTextContent");
            this.f413766f = (i) obj;
        }
    }
}
