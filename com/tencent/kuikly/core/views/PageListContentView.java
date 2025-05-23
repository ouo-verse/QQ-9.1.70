package com.tencent.kuikly.core.views;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b2\u00103J\u0018\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0003\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0002H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016J \u0010\u001a\u001a\u00020\u00042\u000e\u0010\u0018\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0019\u001a\u00020\u0010H\u0016J\u001f\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0000\u00a2\u0006\u0004\b\u001b\u0010\u001cR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010*\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u00101\u001a\u0004\u0018\u00010\u00108\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/kuikly/core/views/PageListContentView;", "Lcom/tencent/kuikly/core/views/ListContentView;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "subView", "", "I", "itemView", "H", "M", UserInfo.SEX_FEMALE, "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "O", "", "offsetX", "offsetY", "", "K", "J", "G", "Lcom/tencent/kuikly/core/views/bn;", "params", tl.h.F, "setFrameToRenderView", "child", "index", "didInsertDomChild", "L", "(FF)I", "", "k", "Z", "getDidInitDefaultPageIndex", "()Z", "setDidInitDefaultPageIndex", "(Z)V", "didInitDefaultPageIndex", "l", "getCurrentPageIndex", "()I", "setCurrentPageIndex", "(I)V", "currentPageIndex", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/Integer;", "getTargetScrollToIndex$core_release", "()Ljava/lang/Integer;", "N", "(Ljava/lang/Integer;)V", "targetScrollToIndex", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class PageListContentView extends ListContentView {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean didInitDefaultPageIndex;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int currentPageIndex;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Integer targetScrollToIndex;

    private final void F() {
        ViewContainer<?, ?> parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListView<*, *>");
        if (((PageListView) parent).getIsCustomPaging()) {
            return;
        }
        getPager().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.PageListContentView$autoResetOffsetIfNeed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ViewContainer<?, ?> parent2 = PageListContentView.this.getParent();
                Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListView<*, *>");
                be beVar = (be) ((PageListView) parent2).getViewAttr();
                int currentPageIndex = PageListContentView.this.getCurrentPageIndex();
                if (beVar.isHorizontalDirection$core_release()) {
                    ViewContainer<?, ?> parent3 = PageListContentView.this.getParent();
                    Intrinsics.checkNotNull(parent3, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListView<*, *>");
                    FlexNode flexNode = beVar.getFlexNode();
                    Intrinsics.checkNotNull(flexNode);
                    ScrollerView.setContentOffset$default((PageListView) parent3, currentPageIndex * flexNode.U(), 0.0f, false, null, 12, null);
                    return;
                }
                ViewContainer<?, ?> parent4 = PageListContentView.this.getParent();
                Intrinsics.checkNotNull(parent4, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListView<*, *>");
                FlexNode flexNode2 = beVar.getFlexNode();
                Intrinsics.checkNotNull(flexNode2);
                ScrollerView.setContentOffset$default((PageListView) parent4, 0.0f, currentPageIndex * flexNode2.K(), false, null, 12, null);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void G(float offsetX, float offsetY) {
        int L = L(offsetX, offsetY);
        if (L != this.currentPageIndex) {
            Integer num = this.targetScrollToIndex;
            if (num == null || (num != null && num.intValue() == L)) {
                Integer num2 = this.targetScrollToIndex;
                if (num2 != null && num2.intValue() == L) {
                    this.targetScrollToIndex = null;
                }
                this.currentPageIndex = L;
                com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                eVar.t("index", L);
                ViewContainer<?, ?> parent = getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListView<*, *>");
                ((PageListEvent) ((PageListView) parent).getViewEvent()).onFireEvent("pageIndexDidChanged", eVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.tencent.kuikly.core.base.Attr] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.tencent.kuikly.core.base.Attr] */
    public final void H(DeclarativeBaseView<?, ?> itemView) {
        ViewContainer<?, ?> parent = getParent();
        if (parent != null) {
            A viewAttr = parent.getViewAttr();
            Intrinsics.checkNotNull(viewAttr, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListAttr");
            be beVar = (be) viewAttr;
            if (beVar.getPageItemWidth() == null && beVar.getPageItemHeight() == null) {
                return;
            }
            ?? viewAttr2 = itemView.getViewAttr();
            FlexNode flexNode = ((com.tencent.kuikly.core.base.m) parent.getViewAttr()).getFlexNode();
            Intrinsics.checkNotNull(flexNode);
            viewAttr2.mo153width(flexNode.U());
            ?? viewAttr3 = itemView.getViewAttr();
            FlexNode flexNode2 = ((com.tencent.kuikly.core.base.m) parent.getViewAttr()).getFlexNode();
            Intrinsics.checkNotNull(flexNode2);
            viewAttr3.mo141height(flexNode2.K());
            if (beVar.getPageItemSizeChangeCallback$core_release() == null) {
                beVar.setPageItemSizeChangeCallback$core_release(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.PageListContentView$fillItemViewSizeIfNeed$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        PageListContentView.this.M();
                    }
                });
            }
        }
    }

    private final void I(final DeclarativeBaseView<?, ?> subView) {
        final ViewContainer<?, ?> parent = getParent();
        Intrinsics.checkNotNull(parent);
        subView.attr(new Function1<Attr, Unit>() { // from class: com.tencent.kuikly.core.views.PageListContentView$fillSubViewLayoutAttr$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Attr attr) {
                invoke2(attr);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:7:0x004b  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Attr attr) {
                boolean z16;
                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                A viewAttr = parent.getViewAttr();
                Intrinsics.checkNotNull(viewAttr, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListAttr");
                attr.margin(0.0f);
                attr.positionRelative();
                this.H(subView);
                A viewAttr2 = parent.getViewAttr();
                Intrinsics.checkNotNull(viewAttr2, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListAttr");
                if (!((be) viewAttr2).getKeepItemAlive()) {
                    A viewAttr3 = parent.getViewAttr();
                    Intrinsics.checkNotNull(viewAttr3, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListAttr");
                    if (!((be) viewAttr3).getKeepAlive()) {
                        z16 = false;
                        if (z16) {
                            return;
                        }
                        attr.keepAlive(true);
                        return;
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int J(float offsetX, float offsetY) {
        float K;
        ViewContainer<?, ?> parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListView<*, *>");
        be beVar = (be) ((PageListView) parent).getViewAttr();
        if (!beVar.isHorizontalDirection$core_release()) {
            offsetX = offsetY;
        }
        if (beVar.isHorizontalDirection$core_release()) {
            FlexNode flexNode = beVar.getFlexNode();
            Intrinsics.checkNotNull(flexNode);
            K = flexNode.U();
        } else {
            FlexNode flexNode2 = beVar.getFlexNode();
            Intrinsics.checkNotNull(flexNode2);
            K = flexNode2.K();
        }
        float f16 = offsetX / K;
        float f17 = f16 - ((int) f16);
        float indexRatio = beVar.getIndexRatio();
        if (f17 <= indexRatio || f17 >= 1 - indexRatio) {
            return (int) (f16 + indexRatio);
        }
        return -1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int K(float offsetX, float offsetY) {
        List<DeclarativeBaseView<?, ?>> a16 = VirtualViewKt.a(this);
        ViewContainer<?, ?> parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListView<*, *>");
        PageListView pageListView = (PageListView) parent;
        int i3 = 0;
        if (((be) pageListView.getViewAttr()).isHorizontalDirection$core_release()) {
            float width = offsetX + (pageListView.getFrame().getWidth() * 0.1f);
            int size = a16.size();
            while (i3 < size) {
                com.tencent.kuikly.core.layout.d frame = a16.get(i3).getFrame();
                if (frame.getX() < width && frame.getX() + frame.getWidth() > width) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        float height = offsetY + (pageListView.getFrame().getHeight() * 0.1f);
        int size2 = a16.size();
        while (i3 < size2) {
            com.tencent.kuikly.core.layout.d frame2 = a16.get(i3).getFrame();
            if (frame2.getY() < height && frame2.getY() + frame2.getHeight() > height) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M() {
        List list;
        list = CollectionsKt___CollectionsKt.toList(VirtualViewKt.a(this));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            H((DeclarativeBaseView) it.next());
        }
        F();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void O(com.tencent.kuikly.core.layout.d frame) {
        if (this.didInitDefaultPageIndex || frame.getWidth() <= 0.0f || frame.getHeight() <= 0.0f) {
            return;
        }
        this.didInitDefaultPageIndex = true;
        ViewContainer<?, ?> parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListView<*, *>");
        be beVar = (be) ((PageListView) parent).getViewAttr();
        int defaultPageIndex = beVar.getDefaultPageIndex();
        if (defaultPageIndex > 0) {
            if (beVar.isHorizontalDirection$core_release()) {
                ViewContainer<?, ?> parent2 = getParent();
                Intrinsics.checkNotNull(parent2, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListView<*, *>");
                FlexNode flexNode = beVar.getFlexNode();
                Intrinsics.checkNotNull(flexNode);
                ScrollerView.setContentOffset$default((PageListView) parent2, defaultPageIndex * flexNode.U(), 0.0f, false, null, 12, null);
                return;
            }
            ViewContainer<?, ?> parent3 = getParent();
            Intrinsics.checkNotNull(parent3, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListView<*, *>");
            FlexNode flexNode2 = beVar.getFlexNode();
            Intrinsics.checkNotNull(flexNode2);
            ScrollerView.setContentOffset$default((PageListView) parent3, 0.0f, defaultPageIndex * flexNode2.K(), false, null, 12, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int L(float offsetX, float offsetY) {
        int J;
        ViewContainer<?, ?> parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListView<*, *>");
        PageListView pageListView = (PageListView) parent;
        int i3 = this.currentPageIndex;
        if (pageListView.getIsCustomPaging()) {
            J = K(offsetX, offsetY);
        } else {
            J = J(offsetX, offsetY);
        }
        if (J >= 0) {
            i3 = J;
        }
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    public final void N(Integer num) {
        this.targetScrollToIndex = num;
    }

    @Override // com.tencent.kuikly.core.views.ListContentView, com.tencent.kuikly.core.base.ViewContainer
    public void didInsertDomChild(DeclarativeBaseView<?, ?> child, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        super.didInsertDomChild(child, index);
        I(child);
    }

    public final int getCurrentPageIndex() {
        return this.currentPageIndex;
    }

    @Override // com.tencent.kuikly.core.views.ListContentView, com.tencent.kuikly.core.views.ScrollerContentView
    public void h(float offsetX, float offsetY, ScrollParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        super.h(offsetX, offsetY, params);
        if (params.getIsDragging()) {
            this.targetScrollToIndex = null;
        }
        G(offsetX, offsetY);
    }

    @Override // com.tencent.kuikly.core.views.ListContentView, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void setFrameToRenderView(com.tencent.kuikly.core.layout.d frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        super.setFrameToRenderView(frame);
        O(frame);
    }
}
