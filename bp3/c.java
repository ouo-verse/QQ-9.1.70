package bp3;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u0006B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lbp3/c;", "", "other", "", "equals", "", "a", "I", "i", "()I", "weight", "<init>", "(I)V", "b", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class c {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c, reason: collision with root package name */
    private static final c f28864c;

    /* renamed from: d, reason: collision with root package name */
    private static final c f28865d;

    /* renamed from: e, reason: collision with root package name */
    private static final c f28866e;

    /* renamed from: f, reason: collision with root package name */
    private static final c f28867f;

    /* renamed from: g, reason: collision with root package name */
    private static final c f28868g;

    /* renamed from: h, reason: collision with root package name */
    private static final c f28869h;

    /* renamed from: i, reason: collision with root package name */
    private static final c f28870i;

    /* renamed from: j, reason: collision with root package name */
    private static final c f28871j;

    /* renamed from: k, reason: collision with root package name */
    private static final c f28872k;

    /* renamed from: l, reason: collision with root package name */
    private static final c f28873l;

    /* renamed from: m, reason: collision with root package name */
    private static final c f28874m;

    /* renamed from: n, reason: collision with root package name */
    private static final c f28875n;

    /* renamed from: o, reason: collision with root package name */
    private static final c f28876o;

    /* renamed from: p, reason: collision with root package name */
    private static final c f28877p;

    /* renamed from: q, reason: collision with root package name */
    private static final c f28878q;

    /* renamed from: r, reason: collision with root package name */
    private static final c f28879r;

    /* renamed from: s, reason: collision with root package name */
    private static final c f28880s;

    /* renamed from: t, reason: collision with root package name */
    private static final c f28881t;

    /* renamed from: u, reason: collision with root package name */
    private static final List<c> f28882u;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int weight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\bR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R \u0010\f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0004\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006R \u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u0012\u0004\b\u0011\u0010\b\u001a\u0004\b\u0010\u0010\u0006R \u0010\u0012\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u0012\u0004\b\u0014\u0010\b\u001a\u0004\b\u0013\u0010\u0006R \u0010\u0015\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u0012\u0004\b\u0017\u0010\b\u001a\u0004\b\u0016\u0010\u0006R \u0010\u0018\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0019\u0010\u0006R \u0010\u001b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u0012\u0004\b\u001d\u0010\b\u001a\u0004\b\u001c\u0010\u0006\u00a8\u0006\u001f"}, d2 = {"Lbp3/c$a;", "", "Lbp3/c;", "W100", "Lbp3/c;", "c", "()Lbp3/c;", "getW100$annotations", "()V", "W300", "d", "getW300$annotations", "W400", "e", "getW400$annotations", "W500", "f", "getW500$annotations", "W600", "g", "getW600$annotations", "W700", tl.h.F, "getW700$annotations", "Normal", "b", "getNormal$annotations", "Bold", "a", "getBold$annotations", "<init>", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: bp3.c$a, reason: from kotlin metadata */
    /* loaded from: classes39.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return c.f28879r;
        }

        public final c b() {
            return c.f28876o;
        }

        public final c c() {
            return c.f28864c;
        }

        public final c d() {
            return c.f28866e;
        }

        public final c e() {
            return c.f28867f;
        }

        public final c f() {
            return c.f28868g;
        }

        public final c g() {
            return c.f28869h;
        }

        public final c h() {
            return c.f28870i;
        }

        Companion() {
        }
    }

    static {
        List<c> listOf;
        c cVar = new c(100);
        f28864c = cVar;
        c cVar2 = new c(200);
        f28865d = cVar2;
        c cVar3 = new c(300);
        f28866e = cVar3;
        c cVar4 = new c(400);
        f28867f = cVar4;
        c cVar5 = new c(500);
        f28868g = cVar5;
        c cVar6 = new c(600);
        f28869h = cVar6;
        c cVar7 = new c(700);
        f28870i = cVar7;
        c cVar8 = new c(800);
        f28871j = cVar8;
        c cVar9 = new c(900);
        f28872k = cVar9;
        f28873l = cVar;
        f28874m = cVar2;
        f28875n = cVar3;
        f28876o = cVar4;
        f28877p = cVar5;
        f28878q = cVar6;
        f28879r = cVar7;
        f28880s = cVar8;
        f28881t = cVar9;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new c[]{cVar, cVar2, cVar3, cVar4, cVar5, cVar6, cVar7, cVar8, cVar9});
        f28882u = listOf;
    }

    public c(int i3) {
        this.weight = i3;
        boolean z16 = false;
        if (1 <= i3 && i3 < 1001) {
            z16 = true;
        }
        if (z16) {
            return;
        }
        throw new IllegalArgumentException(("Font weight can be in range [1, 1000]. Current value: " + i3).toString());
    }

    public boolean equals(Object other) {
        return (other instanceof c) && this.weight == ((c) other).weight;
    }

    /* renamed from: i, reason: from getter */
    public final int getWeight() {
        return this.weight;
    }
}
