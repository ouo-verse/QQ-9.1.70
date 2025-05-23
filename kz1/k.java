package kz1;

import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.component.GuildQUIEmptyState;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\u0003\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\u000e"}, d2 = {"Lkz1/k;", "Lkz1/g;", "Lmz1/f;", "Lvp1/h;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "position", "", "t", "viewBinding", "<init>", "(Lvp1/h;)V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class k extends g<mz1.f, vp1.h> {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lkz1/k$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lkz1/k;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: kz1.k$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final k a(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            vp1.h g16 = vp1.h.g(com.tencent.guild.aio.reserve2.busi.chosen.view.c.a(parent), parent, false);
            Intrinsics.checkNotNullExpressionValue(g16, "inflate(parent.layoutInflater, parent, false)");
            return new k(g16);
        }

        Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull vp1.h viewBinding) {
        super(viewBinding);
        Intrinsics.checkNotNullParameter(viewBinding, "viewBinding");
        GuildQUIEmptyState a16 = new GuildQUIEmptyState.a(this.itemView.getContext()).u("\u6682\u65e0\u5e94\u7528").r(true).s(3).a();
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-1, -2);
        marginLayoutParams.topMargin = ViewUtils.dip2px(48.0f);
        viewBinding.f443018b.addView(a16, marginLayoutParams);
    }

    @Override // kz1.i
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void n(@NotNull mz1.f item, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
    }
}
