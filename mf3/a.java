package mf3;

import com.tencent.mobileqq.zplan.report.c;
import com.tencent.state.report.SquareReportConst;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import yi3.e;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0006B'\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\rR\u0014\u0010\u0010\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lmf3/a;", "", "", "c", "b", "", "a", "J", "bubbleId", "", "I", "bubbleType", "", "Ljava/lang/String;", "externalEntrance", "d", "bubbleJump", "", "canJump", "<init>", "(JILjava/lang/String;Z)V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    private static final Set<Integer> f416670f;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long bubbleId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int bubbleType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String externalEntrance;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final String bubbleJump;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lmf3/a$a;", "", "Lyi3/e;", "bubbleInfo", "", "c", "", "externalEntrance", "Lmf3/a;", "b", "", "", "needReportBubbleTypes", "Ljava/util/Set;", "a", "()Ljava/util/Set;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: mf3.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes38.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Set<Integer> a() {
            return a.f416670f;
        }

        public final a b(e bubbleInfo, String externalEntrance) {
            Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
            if (!c(bubbleInfo) || externalEntrance == null) {
                return null;
            }
            return new a(bubbleInfo.getId(), bubbleInfo.getType(), externalEntrance, bubbleInfo.a());
        }

        public final boolean c(e bubbleInfo) {
            Intrinsics.checkNotNullParameter(bubbleInfo, "bubbleInfo");
            return a().contains(Integer.valueOf(bubbleInfo.getType()));
        }

        Companion() {
        }
    }

    static {
        Set<Integer> of5;
        of5 = SetsKt__SetsKt.setOf((Object[]) new Integer[]{1, 2});
        f416670f = of5;
    }

    public a(long j3, int i3, String externalEntrance, boolean z16) {
        String str;
        Intrinsics.checkNotNullParameter(externalEntrance, "externalEntrance");
        this.bubbleId = j3;
        this.bubbleType = i3;
        this.externalEntrance = externalEntrance;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        this.bubbleJump = str;
    }

    public final void b() {
        Map<String, Object> mutableMapOf;
        c cVar = c.f335070a;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "click"), TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, this.externalEntrance), TuplesKt.to("zplan_bubble_jump", this.bubbleJump), TuplesKt.to(SquareReportConst.Key.KEY_ACTION_BUBBLE_ID, Long.valueOf(this.bubbleId)), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_BUBBLE_TYPE, Integer.valueOf(this.bubbleType)));
        cVar.a("ev_zplan_external_bubble_action", mutableMapOf);
    }

    public final void c() {
        Map<String, Object> mutableMapOf;
        c cVar = c.f335070a;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"), TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, this.externalEntrance), TuplesKt.to("zplan_bubble_jump", this.bubbleJump), TuplesKt.to(SquareReportConst.Key.KEY_ACTION_BUBBLE_ID, Long.valueOf(this.bubbleId)), TuplesKt.to(SquareReportConst.Key.KEY_ZPLAN_BUBBLE_TYPE, Integer.valueOf(this.bubbleType)));
        cVar.a("ev_zplan_external_bubble_action", mutableMapOf);
    }
}
