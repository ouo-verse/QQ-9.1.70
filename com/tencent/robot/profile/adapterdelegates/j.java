package com.tencent.robot.profile.adapterdelegates;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.biz.richframework.part.adapter.section.SectionViewHolder;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\u000e\u001a\u00020\nH\u0016J4\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0013\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00060\u00120\u00110\bH\u0016J2\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00152\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\bH\u0014R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001a\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/robot/profile/adapterdelegates/j;", "Lcom/tencent/robot/profile/adapterdelegates/g;", "Landroid/view/View;", "itemView", "", "f", "Lcom/tencent/robot/profile/data/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "items", "", "position", "", "d", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "initSection", "Lcom/tencent/biz/richframework/part/adapter/section/SectionViewHolder;", "holder", "", "payloads", "e", "Landroid/view/ViewGroup;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class j extends g {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ViewGroup parent;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\u000f\u00b8\u0006\u0000"}, d2 = {"androidx/core/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View;", "view", "", "left", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "", "onLayoutChange", "core-ktx_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class a implements View.OnLayoutChangeListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f367850e;

        public a(View view) {
            this.f367850e = view;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@NotNull View view, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
            Intrinsics.checkNotNullParameter(view, "view");
            view.removeOnLayoutChangeListener(this);
            j.this.f(this.f367850e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(final View itemView) {
        ViewGroup viewGroup = this.parent;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException(HippyNestedScrollComponent.PRIORITY_PARENT);
            viewGroup = null;
        }
        int height = viewGroup.getHeight();
        int top = height - itemView.getTop();
        ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
        if (layoutParams != null) {
            if (top <= itemView.getMinimumHeight() || top >= height) {
                top = itemView.getMinimumHeight();
            }
            layoutParams.height = top;
            itemView.setLayoutParams(layoutParams);
            itemView.post(new Runnable() { // from class: com.tencent.robot.profile.adapterdelegates.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.g(itemView);
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(View itemView) {
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        itemView.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate, com.tencent.biz.richframework.part.adapter.delegate.AbsListItemAdapterDelegate
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean isForViewType(@NotNull com.tencent.robot.profile.data.g item, @NotNull List<com.tencent.robot.profile.data.g> items, int position) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(items, "items");
        return item instanceof com.tencent.robot.profile.data.m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder2(@NotNull com.tencent.robot.profile.data.g item, @NotNull SectionViewHolder<?> holder, int position, @NotNull List<Object> payloads) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(holder, "holder");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.onBindViewHolder2((j) item, (SectionViewHolder) holder, position, payloads);
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        view.setBackgroundColor(view.getContext().getColor(R.color.qui_common_bg_bottom_light));
        com.tencent.robot.profile.data.m mVar = (com.tencent.robot.profile.data.m) item;
        if (mVar.getNeedReverseEmpty()) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = ViewUtils.dpToPx(mVar.getCom.heytap.databaseengine.apiv3.data.Element.ELEMENT_NAME_DISTANCE java.lang.String()) + mVar.h();
                view.setLayoutParams(layoutParams);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        }
        view.setMinimumHeight(ViewUtils.dpToPx(mVar.getCom.heytap.databaseengine.apiv3.data.Element.ELEMENT_NAME_DISTANCE java.lang.String()) + mVar.h());
        view.addOnLayoutChangeListener(new a(view));
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.hom;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<com.tencent.robot.profile.data.g>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        this.parent = parent;
    }
}
