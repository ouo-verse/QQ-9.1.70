package com.tencent.kuikly.core.views;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.VirtualViewKt;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.FlexPositionType;
import com.tencent.kuikly.core.views.PageListEvent;
import com.tencent.kuikly.core.views.be;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005:\u00014B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J!\u0010\u000e\u001a\u00020\u00062\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u000b\u00a2\u0006\u0002\b\fH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0018\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0013J\u001f\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0000\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001e\u001a\u00020\u001dH\u0016J\u000f\u0010\u001f\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b!\u0010\"J\u0006\u0010#\u001a\u00020\u0011J1\u0010(\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010%\u001a\u0004\u0018\u00010$H\u0010\u00a2\u0006\u0004\b&\u0010'R\"\u0010)\u001a\u00020\u00138\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020\u00138\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.\u00a8\u00065"}, d2 = {"Lcom/tencent/kuikly/core/views/PageListView;", "Lcom/tencent/kuikly/core/views/be;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/kuikly/core/views/PageListEvent;", "E", "Lcom/tencent/kuikly/core/views/aq;", "", "useCustomPaging", "Lcom/tencent/kuikly/core/views/co;", "params", "scrollToNextItem", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "init", "attr", "didInit", "willInit", "", "index", "", "animated", "scrollToPageIndex", "", "offsetX", "offsetY", "Lcom/tencent/kuikly/core/views/PageListView$a;", "getCrossItemViewInOffset$core_release", "(FF)Lcom/tencent/kuikly/core/views/PageListView$a;", "getCrossItemViewInOffset", "Lcom/tencent/kuikly/core/views/ScrollerContentView;", "createContentView", "createAttr", "()Lcom/tencent/kuikly/core/views/be;", "createEvent", "()Lcom/tencent/kuikly/core/views/PageListEvent;", "getCurrentPageIndex", "Lcom/tencent/kuikly/core/views/bs;", "springAnimation", "callContentOffset$core_release", "(FFZLcom/tencent/kuikly/core/views/bs;)V", "callContentOffset", "isCustomPaging", "Z", "isCustomPaging$core_release", "()Z", "setCustomPaging$core_release", "(Z)V", "didCallAttr", "getDidCallAttr$core_release", "setDidCallAttr$core_release", "<init>", "()V", "a", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class PageListView<A extends be, E extends PageListEvent> extends aq<A, E> {
    private boolean didCallAttr;
    private boolean isCustomPaging;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ be access$getAttr(PageListView pageListView) {
        return (be) pageListView.getAttr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void scrollToNextItem(co params) {
        if (getContentView() == null || ((be) getAttr()).getFlexNode() == null) {
            return;
        }
        CrossItemViewInfo crossItemViewInOffset$core_release = getCrossItemViewInOffset$core_release(params.getOffsetX(), params.getOffsetY());
        if (((be) getAttr()).isHorizontalDirection$core_release()) {
            if (crossItemViewInOffset$core_release.b() != null) {
                float offset = crossItemViewInOffset$core_release.getOffset();
                if (crossItemViewInOffset$core_release.getCrossPercentage01() > 0.0f) {
                    float width = crossItemViewInOffset$core_release.b().getFlexNode().getLayoutFrame().getWidth();
                    if (params.getVelocityX() > 0.0f) {
                        offset = crossItemViewInOffset$core_release.getOffset() + width;
                    } else {
                        if (params.getVelocityX() == 0.0f) {
                            float offset2 = crossItemViewInOffset$core_release.getOffset();
                            if (crossItemViewInOffset$core_release.getCrossPercentage01() < 0.5d) {
                                width = 0.0f;
                            }
                            offset = offset2 + width;
                        }
                    }
                }
                ScrollerContentView contentView = getContentView();
                Intrinsics.checkNotNull(contentView);
                float width2 = contentView.getFlexNode().getLayoutFrame().getWidth();
                FlexNode flexNode = ((be) getAttr()).getFlexNode();
                Intrinsics.checkNotNull(flexNode);
                setContentOffset(Math.min(offset, width2 - flexNode.getLayoutFrame().getWidth()), 0.0f, true, new bs(400, 1.0f, params.getVelocityX()));
                return;
            }
            return;
        }
        if (crossItemViewInOffset$core_release.b() != null) {
            float offset3 = crossItemViewInOffset$core_release.getOffset();
            if (crossItemViewInOffset$core_release.getCrossPercentage01() > 0.0f) {
                float height = crossItemViewInOffset$core_release.b().getFlexNode().getLayoutFrame().getHeight();
                if (params.getVelocityY() > 0.0f) {
                    offset3 = crossItemViewInOffset$core_release.getOffset() + height;
                } else {
                    if (params.getVelocityY() == 0.0f) {
                        float offset4 = crossItemViewInOffset$core_release.getOffset();
                        if (crossItemViewInOffset$core_release.getCrossPercentage01() < 0.5d) {
                            height = 0.0f;
                        }
                        offset3 = offset4 + height;
                    }
                }
            }
            ScrollerContentView contentView2 = getContentView();
            Intrinsics.checkNotNull(contentView2);
            float height2 = contentView2.getFlexNode().getLayoutFrame().getHeight();
            FlexNode flexNode2 = ((be) getAttr()).getFlexNode();
            Intrinsics.checkNotNull(flexNode2);
            setContentOffset(0.0f, Math.min(offset3, height2 - flexNode2.getLayoutFrame().getHeight()), true, new bs(400, 1.0f, params.getVelocityY()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.q
    public void attr(Function1<? super A, Unit> init) {
        com.tencent.kuikly.core.base.m mVar;
        com.tencent.kuikly.core.base.m mVar2;
        Intrinsics.checkNotNullParameter(init, "init");
        super.attr(init);
        this.didCallAttr = true;
        if (((be) getAttr()).isHorizontalDirection$core_release() && ((be) getAttr()).getPageItemWidth() != null) {
            if (getFlexNode().G() == FlexPositionType.RELATIVE) {
                ViewContainer<?, ?> domParent = getDomParent();
                if ((domParent == null || (mVar2 = (com.tencent.kuikly.core.base.m) domParent.getViewAttr()) == null || !mVar2.isHorizontalDirection$core_release()) ? false : true) {
                    if (!(getFlexNode().i() == 0.0f)) {
                        useCustomPaging();
                        return;
                    }
                }
            }
            ((be) getAttr()).pagingEnable(true);
            return;
        }
        if (!((be) getAttr()).isHorizontalDirection$core_release() && ((be) getAttr()).getPageItemHeight() != null) {
            if (getFlexNode().G() == FlexPositionType.RELATIVE) {
                ViewContainer<?, ?> domParent2 = getDomParent();
                if ((domParent2 == null || (mVar = (com.tencent.kuikly.core.base.m) domParent2.getViewAttr()) == null || mVar.isHorizontalDirection$core_release()) ? false : true) {
                    if (!(getFlexNode().i() == 0.0f)) {
                        useCustomPaging();
                        return;
                    }
                }
            }
            ((be) getAttr()).pagingEnable(true);
            return;
        }
        useCustomPaging();
    }

    @Override // com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView
    public ScrollerContentView createContentView() {
        return new PageListContentView();
    }

    @Override // com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
        if (this.didCallAttr) {
            return;
        }
        attr(new Function1<A, Unit>() { // from class: com.tencent.kuikly.core.views.PageListView$didInit$1
            /* JADX WARN: Incorrect types in method signature: (TA;)V */
            public final void invoke(be attr) {
                Intrinsics.checkNotNullParameter(attr, "$this$attr");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke((be) obj);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CrossItemViewInfo getCrossItemViewInOffset$core_release(float offsetX, float offsetY) {
        DeclarativeBaseView<?, ?> declarativeBaseView;
        float height;
        ScrollerContentView contentView = getContentView();
        Intrinsics.checkNotNull(contentView);
        List<DeclarativeBaseView<?, ?>> a16 = VirtualViewKt.a(contentView);
        if (!((be) getAttr()).isHorizontalDirection$core_release()) {
            offsetX = offsetY;
        }
        Iterator<DeclarativeBaseView<?, ?>> it = a16.iterator();
        float f16 = 0.0f;
        int i3 = 0;
        float f17 = 0.0f;
        while (true) {
            if (!it.hasNext()) {
                declarativeBaseView = null;
                break;
            }
            declarativeBaseView = it.next();
            if (((be) getAttr()).isHorizontalDirection$core_release()) {
                height = declarativeBaseView.getFlexNode().getLayoutFrame().getWidth();
            } else {
                height = declarativeBaseView.getFlexNode().getLayoutFrame().getHeight();
            }
            if (f17 <= offsetX && f17 + height > offsetX) {
                f16 = (offsetX - f17) / height;
                break;
            }
            f17 += height;
            i3++;
        }
        return new CrossItemViewInfo(declarativeBaseView, f16, f17, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int getCurrentPageIndex() {
        ScrollerContentView contentView = getContentView();
        PageListContentView pageListContentView = contentView instanceof PageListContentView ? (PageListContentView) contentView : null;
        if (pageListContentView != null) {
            return pageListContentView.getCurrentPageIndex();
        }
        return ((be) getViewAttr()).getDefaultPageIndex();
    }

    /* renamed from: getDidCallAttr$core_release, reason: from getter */
    public final boolean getDidCallAttr() {
        return this.didCallAttr;
    }

    /* renamed from: isCustomPaging$core_release, reason: from getter */
    public final boolean getIsCustomPaging() {
        return this.isCustomPaging;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean scrollToPageIndex(int index, boolean animated) {
        ScrollerContentView contentView;
        DeclarativeBaseView<?, ?> subview;
        FlexNode flexNode;
        com.tencent.kuikly.core.layout.d layoutFrame;
        if (getContentView() == null || ((be) getAttr()).getFlexNode() == null) {
            return false;
        }
        ScrollerContentView contentView2 = getContentView();
        Intrinsics.checkNotNull(contentView2);
        if (contentView2.getFlexNode().getLayoutFrame().f() || (contentView = getContentView()) == null || (subview = contentView.getSubview(index)) == null || (flexNode = subview.getFlexNode()) == null || (layoutFrame = flexNode.getLayoutFrame()) == null) {
            return false;
        }
        ScrollerView.setContentOffset$default(this, layoutFrame.getX(), layoutFrame.getY(), animated, null, 8, null);
        return true;
    }

    public final void setCustomPaging$core_release(boolean z16) {
        this.isCustomPaging = z16;
    }

    public final void setDidCallAttr$core_release(boolean z16) {
        this.didCallAttr = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public void willInit() {
        super.willInit();
        ((be) getViewAttr()).showScrollerIndicator(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void useCustomPaging() {
        this.isCustomPaging = true;
        ((be) getAttr()).flingEnable(false);
        ((be) getAttr()).pagingEnable(false);
        event(new Function1<E, Unit>(this) { // from class: com.tencent.kuikly.core.views.PageListView$useCustomPaging$1
            final /* synthetic */ PageListView<A, E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke((PageListEvent) obj);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Incorrect types in method signature: (TE;)V */
            public final void invoke(PageListEvent event) {
                Intrinsics.checkNotNullParameter(event, "$this$event");
                final PageListView<A, E> pageListView = this.this$0;
                event.willDragEndBySync(new Function1<co, Unit>() { // from class: com.tencent.kuikly.core.views.PageListView$useCustomPaging$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(co coVar) {
                        invoke2(coVar);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(co it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        boolean isHorizontalDirection$core_release = PageListView.access$getAttr(pageListView).isHorizontalDirection$core_release();
                        if (!isHorizontalDirection$core_release || it.getOffsetX() >= 0.0f) {
                            if (isHorizontalDirection$core_release || it.getOffsetY() >= 0.0f) {
                                pageListView.scrollToNextItem(it);
                            }
                        }
                    }
                });
            }
        });
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0010\u0010\u000e\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R!\u0010\u000e\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/kuikly/core/views/PageListView$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "a", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "b", "()Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "itemView", "", UserInfo.SEX_FEMALE, "()F", "crossPercentage01", "c", "offset", "d", "I", "getIndex", "()I", "index", "<init>", "(Lcom/tencent/kuikly/core/base/DeclarativeBaseView;FFI)V", "core_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.kuikly.core.views.PageListView$a, reason: from toString */
    /* loaded from: classes33.dex */
    public static final /* data */ class CrossItemViewInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final DeclarativeBaseView<?, ?> itemView;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final float crossPercentage01;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final float offset;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final int index;

        public CrossItemViewInfo(DeclarativeBaseView<?, ?> declarativeBaseView, float f16, float f17, int i3) {
            this.itemView = declarativeBaseView;
            this.crossPercentage01 = f16;
            this.offset = f17;
            this.index = i3;
        }

        /* renamed from: a, reason: from getter */
        public final float getCrossPercentage01() {
            return this.crossPercentage01;
        }

        public final DeclarativeBaseView<?, ?> b() {
            return this.itemView;
        }

        /* renamed from: c, reason: from getter */
        public final float getOffset() {
            return this.offset;
        }

        public int hashCode() {
            DeclarativeBaseView<?, ?> declarativeBaseView = this.itemView;
            return ((((((declarativeBaseView == null ? 0 : declarativeBaseView.hashCode()) * 31) + Float.floatToIntBits(this.crossPercentage01)) * 31) + Float.floatToIntBits(this.offset)) * 31) + this.index;
        }

        public String toString() {
            return "CrossItemViewInfo(itemView=" + this.itemView + ", crossPercentage01=" + this.crossPercentage01 + ", offset=" + this.offset + ", index=" + this.index + ')';
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CrossItemViewInfo)) {
                return false;
            }
            CrossItemViewInfo crossItemViewInfo = (CrossItemViewInfo) other;
            return Intrinsics.areEqual(this.itemView, crossItemViewInfo.itemView) && Float.compare(this.crossPercentage01, crossItemViewInfo.crossPercentage01) == 0 && Float.compare(this.offset, crossItemViewInfo.offset) == 0 && this.index == crossItemViewInfo.index;
        }
    }

    @Override // com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public A createAttr() {
        return (A) new be();
    }

    @Override // com.tencent.kuikly.core.views.aq, com.tencent.kuikly.core.views.ScrollerView, com.tencent.kuikly.core.base.AbstractBaseView
    public E createEvent() {
        return (E) new PageListEvent();
    }

    @Override // com.tencent.kuikly.core.views.ScrollerView
    public void callContentOffset$core_release(float offsetX, float offsetY, boolean animated, bs springAnimation) {
        if (animated || springAnimation != null) {
            ScrollerContentView contentView = getContentView();
            PageListContentView pageListContentView = contentView instanceof PageListContentView ? (PageListContentView) contentView : null;
            if (pageListContentView != null) {
                int L = pageListContentView.L(offsetX, offsetY);
                if (Math.abs(L - getCurrentPageIndex()) > 1) {
                    pageListContentView.N(Integer.valueOf(L));
                }
            }
        }
        super.callContentOffset$core_release(offsetX, offsetY, animated, springAnimation);
    }

    public static /* synthetic */ boolean scrollToPageIndex$default(PageListView pageListView, int i3, boolean z16, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                z16 = false;
            }
            return pageListView.scrollToPageIndex(i3, z16);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToPageIndex");
    }
}
