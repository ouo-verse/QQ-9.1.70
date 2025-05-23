package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.RoleGroupListViewModel;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u00128\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016RF\u0010\u000f\u001a4\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0003\u0012\u0015\u0012\u0013\u0018\u00010\u000b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00060\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/o;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/ad;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$ShowState;", "state", "", "l", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Landroid/view/View;", "v", "E", "Lkotlin/jvm/functions/Function2;", "itemClickCallback", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/x;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/x;", "controller", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class o extends ad {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Function2<r, View, Unit> itemClickCallback;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final x controller;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public o(@NotNull ViewGroup parent, @NotNull Function2<? super r, ? super View, Unit> itemClickCallback) {
        super(x.INSTANCE.a(parent));
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemClickCallback, "itemClickCallback");
        this.itemClickCallback = itemClickCallback;
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        this.controller = new x(itemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(o this$0, r item, View view) {
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
        if (item instanceof RoleEveryoneItem) {
            x.b(this.controller, ((RoleEveryoneItem) item).getRole(), state, null, 4, null);
            this.controller.g(R.string.f154571f6, new Object[0]);
            this.controller.f(true);
            this.controller.e(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    o.n(o.this, item, view);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
