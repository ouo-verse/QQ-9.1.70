package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.RoleGroupListViewModel;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001 BI\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00128\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0004\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00070\r\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016RF\u0010\u0014\u001a4\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0004\u0012\u0015\u0012\u0013\u0018\u00010\u0010\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00070\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/c;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/ad;", "Lcom/tencent/mobileqq/guild/base/extension/f;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$ShowState;", "state", "", "l", "", "viewType", "", "c", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Landroid/view/View;", "v", "E", "Lkotlin/jvm/functions/Function2;", "itemClickCallback", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "title", "G", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function2;)V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c extends ad implements com.tencent.mobileqq.guild.base.extension.f {

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Function2<r, View, Unit> itemClickCallback;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final TextView title;

    /* renamed from: G, reason: from kotlin metadata */
    private r item;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/c$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "kotlin.jvm.PlatformType", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.c$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final View b(ViewGroup parent) {
            return LayoutInflater.from(parent.getContext()).inflate(R.layout.f168114ew1, parent, false);
        }

        Companion() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c(@NotNull ViewGroup parent, @NotNull Function2<? super r, ? super View, Unit> itemClickCallback) {
        super(r2);
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemClickCallback, "itemClickCallback");
        View b16 = INSTANCE.b(parent);
        Intrinsics.checkNotNullExpressionValue(b16, "inflateLayout(parent)");
        this.itemClickCallback = itemClickCallback;
        View findViewById = this.itemView.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.title)");
        this.title = (TextView) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(c this$0, r item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.itemClickCallback.invoke(item, view);
        EventCollector.getInstance().onViewClicked(view);
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
        if (item instanceof CreateRoleItem) {
            this.item = item;
            this.title.setText(((CreateRoleItem) item).getText());
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.n(c.this, item, view);
                }
            });
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
