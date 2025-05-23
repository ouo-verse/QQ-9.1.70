package com.tencent.mobileqq.guild.rolegroup.adapters.rolelist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.RoleGroupListViewModel;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/f;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/ad;", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/d;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$ShowState;", "state", "l", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "description", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "<init>", "(Landroid/view/ViewGroup;)V", UserInfo.SEX_FEMALE, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class f extends ad {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final TextView description;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\f\u0010\t\u001a\u00020\b*\u00020\u0007H\u0002J\f\u0010\n\u001a\u00020\b*\u00020\u0007H\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/f$a;", "", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "kotlin.jvm.PlatformType", "d", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/d;", "", "f", "e", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.f$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final View d(ViewGroup parent) {
            return LayoutInflater.from(parent.getContext()).inflate(R.layout.ew5, parent, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String e(DescriptionItem descriptionItem) {
            String joinToString$default;
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(descriptionItem.c(), "\n", null, null, 0, null, null, 62, null);
            return joinToString$default;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String f(DescriptionItem descriptionItem) {
            String joinToString$default;
            joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(descriptionItem.c(), "", null, null, 0, null, null, 62, null);
            return joinToString$default;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/adapters/rolelist/f$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            f.this.description.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            if (f.this.description.getTag() instanceof DescriptionItem) {
                f fVar = f.this;
                Object tag = fVar.description.getTag();
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.DescriptionItem");
                fVar.q((DescriptionItem) tag);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f(@NotNull ViewGroup parent) {
        super(r2);
        Intrinsics.checkNotNullParameter(parent, "parent");
        View d16 = INSTANCE.d(parent);
        Intrinsics.checkNotNullExpressionValue(d16, "inflateLayout(parent)");
        View findViewById = this.itemView.findViewById(R.id.bgt);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.description)");
        this.description = (TextView) findViewById;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.description.getWidth() != 0 && (this$0.description.getTag() instanceof DescriptionItem)) {
            Object tag = this$0.description.getTag();
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.DescriptionItem");
            this$0.q((DescriptionItem) tag);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(DescriptionItem item) {
        Companion companion = INSTANCE;
        String f16 = companion.f(item);
        if (this.description.getPaint().measureText(f16) < this.description.getWidth()) {
            this.description.setText(f16);
            this.description.setGravity(17);
        } else {
            this.description.setText(companion.e(item));
            this.description.setGravity(3);
        }
    }

    @Override // com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.ad
    public void l(@NotNull r item, @NotNull RoleGroupListViewModel.ShowState state) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(state, "state");
        if (item instanceof DescriptionItem) {
            this.description.setTag(item);
            if (this.description.getWidth() != 0) {
                q((DescriptionItem) item);
                return;
            } else {
                this.description.getViewTreeObserver().addOnGlobalLayoutListener(new b());
                Function0.b(200, new Runnable() { // from class: com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.p(f.this);
                    }
                });
                return;
            }
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}
