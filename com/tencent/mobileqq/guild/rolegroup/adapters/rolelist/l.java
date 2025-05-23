package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.RoleGroupListViewModel;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dBI\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00128\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016RF\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/l;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/ad;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$ShowState;", "state", "", "l", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Landroid/view/View;", "v", "E", "Lkotlin/jvm/functions/Function2;", "itemClickCallback", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "title", "G", QQWinkConstants.TAB_SUBTITLE, "H", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;)V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class l extends ad {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Function2<r, View, Unit> itemClickCallback;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView title;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final TextView subTitle;

    /* renamed from: H, reason: from kotlin metadata */
    private r item;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/l$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "kotlin.jvm.PlatformType", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.l$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final View b(ViewGroup parent) {
            return LayoutInflater.from(parent.getContext()).inflate(R.layout.ew6, parent, false);
        }

        Companion() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public l(@NotNull ViewGroup parent, @NotNull Function2<? super r, ? super View, Unit> itemClickCallback) {
        super(r2);
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemClickCallback, "itemClickCallback");
        View b16 = INSTANCE.b(parent);
        Intrinsics.checkNotNullExpressionValue(b16, "inflateLayout(parent)");
        this.itemClickCallback = itemClickCallback;
        View findViewById = this.itemView.findViewById(R.id.wlw);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.guild_level_title)");
        this.title = (TextView) findViewById;
        View findViewById2 = this.itemView.findViewById(R.id.wlv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.guild_level_sub_title)");
        this.subTitle = (TextView) findViewById2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(l this$0, r item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.itemClickCallback.invoke(item, view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.ad
    public void l(@NotNull final r item, @NotNull RoleGroupListViewModel.ShowState state) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(state, "state");
        if (item instanceof LevelRoleItem) {
            this.item = item;
            LevelRoleItem levelRoleItem = (LevelRoleItem) item;
            this.title.setText(levelRoleItem.getTitle());
            this.subTitle.setText(levelRoleItem.getSubTitle());
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    l.n(l.this, item, view);
                }
            });
            QQGuildUIUtil.N(levelRoleItem.getIsEnable(), this.itemView);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
