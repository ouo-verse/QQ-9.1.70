package com.tencent.mobileqq.guild.discoveryv2.content.recommend.delegate;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.SpaceData;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0004\u001a\u00020\u0003H\u0016J4\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u001a\u0010\f\u001a\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b0\n0\tH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/z;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/a;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/s;", "", "getLayoutId", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroid/view/View;", "itemView", "", "Ljava/lang/Class;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "sections", "", "initSection", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class z extends com.tencent.mobileqq.guild.discoveryv2.content.base.a<SpaceData> {

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/delegate/z$a;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/s;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "p", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a extends Section<SpaceData> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        @NotNull
        public int[] getViewStubLayoutId() {
            return new int[0];
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        public void onInitView(@NotNull View containerView) {
            StaggeredGridLayoutManager.LayoutParams layoutParams;
            Intrinsics.checkNotNullParameter(containerView, "containerView");
            ViewGroup.LayoutParams layoutParams2 = containerView.getLayoutParams();
            if (layoutParams2 instanceof StaggeredGridLayoutManager.LayoutParams) {
                layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
            } else {
                layoutParams = null;
            }
            if (layoutParams != null) {
                layoutParams.setFullSpan(true);
                containerView.setLayoutParams(layoutParams);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.richframework.part.adapter.section.Section
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public void onBindData(@NotNull SpaceData data, int position, @Nullable List<Object> payload) {
            ViewGroup.LayoutParams layoutParams;
            Intrinsics.checkNotNullParameter(data, "data");
            View view = this.mRootView;
            StaggeredGridLayoutManager.LayoutParams layoutParams2 = null;
            if (view != null) {
                layoutParams = view.getLayoutParams();
            } else {
                layoutParams = null;
            }
            if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
                layoutParams2 = (StaggeredGridLayoutManager.LayoutParams) layoutParams;
            }
            if (layoutParams2 != null) {
                layoutParams2.setFullSpan(true);
                if (((ViewGroup.MarginLayoutParams) layoutParams2).height != ((int) cw.c(data.getDistanceDp()))) {
                    ((ViewGroup.MarginLayoutParams) layoutParams2).height = (int) cw.c(data.getDistanceDp());
                    this.mRootView.setLayoutParams(layoutParams2);
                }
            }
        }
    }

    public z() {
        super(SpaceData.class);
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public int getLayoutId() {
        return R.layout.eve;
    }

    @Override // com.tencent.biz.richframework.part.adapter.delegate.AbsItemAdapterDelegate
    public void initSection(@NotNull ViewGroup parent, @NotNull View itemView, @NotNull List<Class<? extends Section<SpaceData>>> sections) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(sections, "sections");
        sections.add(a.class);
    }
}
