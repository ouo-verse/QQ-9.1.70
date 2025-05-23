package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import android.view.View;
import android.view.ViewGroup;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.RoleGroupListViewModel;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0081\u0001\u0012\u0006\u0010#\u001a\u00020\"\u00128\u0010\u0015\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\u000e\u00126\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u000e\u00a2\u0006\u0004\b$\u0010%J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016RF\u0010\u0015\u001a4\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0011\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\b0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014RD\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\f8V@VX\u0096\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/v;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/ad;", "Lcom/tencent/mobileqq/guild/base/extension/f;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/h;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$ShowState;", "state", "", "l", "", "viewType", "", "c", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Landroid/view/View;", "v", "E", "Lkotlin/jvm/functions/Function2;", "itemClickCallback", "position", UserInfo.SEX_FEMALE, "dragStartCallback", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/x;", "G", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/x;", "controller", "value", "isSelected", "()Z", "setSelected", "(Z)V", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class v extends ad implements com.tencent.mobileqq.guild.base.extension.f, h {

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Function2<r, View, Unit> itemClickCallback;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Function2<r, Integer, Boolean> dragStartCallback;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final x controller;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public v(@NotNull ViewGroup parent, @NotNull Function2<? super r, ? super View, Unit> itemClickCallback, @NotNull Function2<? super r, ? super Integer, Boolean> dragStartCallback) {
        super(x.INSTANCE.a(parent));
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemClickCallback, "itemClickCallback");
        Intrinsics.checkNotNullParameter(dragStartCallback, "dragStartCallback");
        this.itemClickCallback = itemClickCallback;
        this.dragStartCallback = dragStartCallback;
        View itemView = this.itemView;
        Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
        this.controller = new x(itemView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(v this$0, r item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.itemClickCallback.invoke(item, view);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean p(v this$0, r item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        return this$0.dragStartCallback.invoke(item, Integer.valueOf(this$0.getAdapterPosition())).booleanValue();
    }

    @Override // com.tencent.mobileqq.guild.base.extension.f
    public boolean c(int viewType) {
        if (viewType == 3 || viewType == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.ad
    public void l(@NotNull final r item, @NotNull RoleGroupListViewModel.ShowState state) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(state, "state");
        if (item instanceof RoleItem) {
            RoleItem roleItem = (RoleItem) item;
            this.controller.a(roleItem.getRole(), state, roleItem.getExtra());
            this.controller.f(roleItem.getExtra().getEnable());
            this.controller.e(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    v.o(v.this, item, view);
                }
            });
            if (state == RoleGroupListViewModel.ShowState.SORTABLE) {
                this.controller.i(new View.OnLongClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.u
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        boolean p16;
                        p16 = v.p(v.this, item, view);
                        return p16;
                    }
                });
                return;
            } else {
                this.controller.c();
                return;
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.h
    public void setSelected(boolean z16) {
        this.controller.h(z16);
    }
}
