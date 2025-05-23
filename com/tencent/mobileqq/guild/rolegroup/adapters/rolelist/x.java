package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.StringRes;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.RoleGroupListViewModel;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u00a2\u0006\u0004\b3\u00104J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u0011\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u0012\u001a\u00020\u000bJ/\u0010\u0016\u001a\u00020\u000b2\b\b\u0001\u0010\u0013\u001a\u00020\u00042\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0014\"\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010 R\u0014\u0010$\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010#R\u0014\u0010%\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010 R\u0014\u0010'\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010 R\u0014\u0010*\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010)R\u0014\u0010,\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010)R$\u0010/\u001a\u00020-2\u0006\u0010.\u001a\u00020-8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b/\u00100\"\u0004\b+\u00101R$\u00102\u001a\u00020-2\u0006\u0010.\u001a\u00020-8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b2\u00100\"\u0004\b&\u00101\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/x;", "", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$ShowState;", "state", "", "j", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "role", "d", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/g;", "extra", "", "a", "Landroid/view/View$OnClickListener;", "listener", "e", "Landroid/view/View$OnLongClickListener;", "i", "c", "resId", "", "args", "g", "(I[Ljava/lang/Object;)V", "Landroid/view/View;", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "b", "layoutContent", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "textUserDescription", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "imageRoleColor", "adminRoleColor", "f", "title", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "buttonMovable", tl.h.F, "layoutUserCount", "", "value", "isSelected", "()Z", "(Z)V", "isEnabled", "<init>", "(Landroid/view/View;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
final class x {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View itemView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View layoutContent;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView textUserDescription;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView imageRoleColor;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView adminRoleColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView title;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup buttonMovable;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewGroup layoutUserCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/x$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "a", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.x$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final View a(@NotNull ViewGroup parent) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.ew8, parent, false);
            Intrinsics.checkNotNull(inflate);
            return inflate;
        }

        Companion() {
        }
    }

    public x(@NotNull View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.itemView = itemView;
        View findViewById = itemView.findViewById(R.id.e38);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.layout_content)");
        this.layoutContent = findViewById;
        View findViewById2 = itemView.findViewById(R.id.f95825g1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.text_user_count)");
        this.textUserDescription = (TextView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.xdq);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.icon_dot_role_color)");
        this.imageRoleColor = (ImageView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.xda);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.icon_admin_role_color)");
        this.adminRoleColor = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.title)");
        this.title = (TextView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.tju);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.button_movable)");
        this.buttonMovable = (ViewGroup) findViewById6;
        View findViewById7 = itemView.findViewById(R.id.yfq);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.layout_text_layout)");
        this.layoutUserCount = (ViewGroup) findViewById7;
    }

    public static /* synthetic */ void b(x xVar, RoleGroupModel roleGroupModel, RoleGroupListViewModel.ShowState showState, DisplayExtra displayExtra, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            displayExtra = null;
        }
        xVar.a(roleGroupModel, showState, displayExtra);
    }

    private final int d(RoleGroupModel role, RoleGroupListViewModel.ShowState state) {
        if (state == RoleGroupListViewModel.ShowState.SORTABLE && role.getRolePermission().getIsSortableInList()) {
            return 0;
        }
        return 8;
    }

    private final int j(RoleGroupListViewModel.ShowState state) {
        if (state == RoleGroupListViewModel.ShowState.NORMAL) {
            return 0;
        }
        return 8;
    }

    public final void a(@NotNull RoleGroupModel role, @NotNull RoleGroupListViewModel.ShowState state, @Nullable DisplayExtra extra) {
        Intrinsics.checkNotNullParameter(role, "role");
        Intrinsics.checkNotNullParameter(state, "state");
        this.title.setText(role.getName());
        if (role.v() && extra != null) {
            this.textUserDescription.setText(extra.getDescription());
        } else {
            com.tencent.mobileqq.guild.base.extension.s.c(this.textUserDescription, R.string.f157681nk, Integer.valueOf(role.getUserCount()));
        }
        dy1.a aVar = dy1.a.f395200a;
        int color = role.getColor();
        int roleType = role.getRoleType();
        boolean b16 = aVar.b(role.getLvRole());
        ImageView imageView = this.imageRoleColor;
        TextView textView = this.adminRoleColor;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
        aVar.d(color, roleType, b16, imageView, textView, context);
        this.layoutUserCount.setVisibility(j(state));
        this.buttonMovable.setVisibility(d(role, state));
    }

    public final void c() {
        this.layoutContent.setOnLongClickListener(null);
    }

    public final void e(@Nullable View.OnClickListener listener) {
        this.layoutContent.setOnClickListener(listener);
    }

    public final void f(boolean z16) {
        ae.c(this.layoutContent, z16, this.itemView);
    }

    public final void g(@StringRes int resId, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        com.tencent.mobileqq.guild.base.extension.s.c(this.textUserDescription, resId, Arrays.copyOf(args, args.length));
    }

    public final void h(boolean z16) {
        ae.d(this.itemView, z16);
    }

    public final void i(@Nullable View.OnLongClickListener listener) {
        this.layoutContent.setOnLongClickListener(listener);
    }
}
