package oi3;

import com.tencent.mobileqq.zplan.utils.bb;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oi3.a;
import t74.r;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000f\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\t\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016R\"\u0010\u000f\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Loi3/b;", "Loi3/a;", "", "", "extra", "", "c", "d", "toString", "Lal0/a;", "Lal0/a;", "getAvatarResourceStep", "()Lal0/a;", h.F, "(Lal0/a;)V", "avatarResourceStep", "e", "getAnimationResourceStep", "g", "animationResourceStep", "f", "setReloadAvatarStep", "reloadAvatarStep", "<init>", "(Lal0/a;Lal0/a;Lal0/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private al0.a avatarResourceStep;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private al0.a animationResourceStep;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private al0.a reloadAvatarStep;

    public /* synthetic */ b(al0.a aVar, al0.a aVar2, al0.a aVar3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new al0.a(0L, 0L, false, 0, null, 31, null) : aVar, (i3 & 2) != 0 ? new al0.a(0L, 0L, false, 0, null, 31, null) : aVar2, (i3 & 4) != 0 ? new al0.a(0L, 0L, false, 0, null, 31, null) : aVar3);
    }

    @Override // oi3.a
    public void c(Map<String, String> extra) {
        Map mutableMapOf;
        Intrinsics.checkNotNullParameter(extra, "extra");
        a.Companion companion = a.INSTANCE;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(companion.b(getLoadSo(), "loadSoTC"), companion.b(this.avatarResourceStep, "fetchAvatarResourceTC"), companion.b(this.animationResourceStep, "fetchAnimationResourceTC"), companion.b(this.reloadAvatarStep, "reloadAvatarTC"));
        mutableMapOf.putAll(extra);
        String e16 = bb.f335811a.e();
        if (e16 == null) {
            e16 = "";
        }
        Pair pair = TuplesKt.to("params_uin", e16);
        mutableMapOf.put(pair.getFirst(), pair.getSecond());
        Pair pair2 = TuplesKt.to("params_timestamp", String.valueOf(al0.a.INSTANCE.b()));
        mutableMapOf.put(pair2.getFirst(), pair2.getSecond());
        r.e(null, "zplanlite_launch_duration_native_app", mutableMapOf, 1, null);
    }

    @Override // oi3.a
    public void d() {
        super.d();
        a.Companion companion = a.INSTANCE;
        companion.a(this.avatarResourceStep);
        companion.a(this.animationResourceStep);
        companion.a(this.reloadAvatarStep);
    }

    /* renamed from: f, reason: from getter */
    public final al0.a getReloadAvatarStep() {
        return this.reloadAvatarStep;
    }

    public final void g(al0.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.animationResourceStep = aVar;
    }

    public final void h(al0.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.avatarResourceStep = aVar;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("loadSo:" + getLoadSo() + "\n");
        sb5.append("fetchAvatarResource:" + this.avatarResourceStep + "\n");
        sb5.append("fetchAnimationResource:" + this.animationResourceStep + "\n");
        sb5.append("reloadAvatar:" + this.reloadAvatarStep);
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        return sb6;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(al0.a avatarResourceStep, al0.a animationResourceStep, al0.a reloadAvatarStep) {
        super(null, null, 3, null);
        Intrinsics.checkNotNullParameter(avatarResourceStep, "avatarResourceStep");
        Intrinsics.checkNotNullParameter(animationResourceStep, "animationResourceStep");
        Intrinsics.checkNotNullParameter(reloadAvatarStep, "reloadAvatarStep");
        this.avatarResourceStep = avatarResourceStep;
        this.animationResourceStep = animationResourceStep;
        this.reloadAvatarStep = reloadAvatarStep;
    }
}
