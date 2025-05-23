package com.tencent.sqshow.zootopia.samestyle;

import com.tencent.sqshow.zootopia.widget.tab.BaseZPlanTabTitleData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B#\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateCat;", "Lcom/tencent/sqshow/zootopia/widget/tab/BaseZPlanTabTitleData;", "", "", "toString", "name", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Lmv4/j;", "d", "Lmv4/j;", "getReddotMsg", "()Lmv4/j;", "reddotMsg", "id", "<init>", "(Ljava/lang/String;JLmv4/j;)V", "Companion", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanTemplateCat extends BaseZPlanTabTitleData<Long> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    private static final ZPlanTemplateCat f372826e = new ZPlanTemplateCat("", -1, new mv4.j());

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final transient mv4.j reddotMsg;
    private final String name;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateCat$a;", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateCat;", "INVALID_CAT", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateCat;", "a", "()Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplateCat;", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.samestyle.ZPlanTemplateCat$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanTemplateCat a() {
            return ZPlanTemplateCat.f372826e;
        }

        Companion() {
        }
    }

    public /* synthetic */ ZPlanTemplateCat(String str, long j3, mv4.j jVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? 0L : j3, (i3 & 4) != 0 ? new mv4.j() : jVar);
    }

    public final String getName() {
        return this.name;
    }

    public final mv4.j getReddotMsg() {
        return this.reddotMsg;
    }

    public String toString() {
        return "name:" + this.name + ", id:" + getId();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanTemplateCat(String name, long j3, mv4.j reddotMsg) {
        super(Long.valueOf(j3), name);
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(reddotMsg, "reddotMsg");
        this.name = name;
        this.reddotMsg = reddotMsg;
    }
}
