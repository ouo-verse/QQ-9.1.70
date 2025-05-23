package com.tencent.kuikly.core.views;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aekit.plugin.core.AIInput;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.StyleSpace;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerEvent;
import com.tencent.mtt.hippy.views.waterfalllist.WaterFallComponentName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005B\u0007\u00a2\u0006\u0004\bx\u0010#J\b\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\r\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u000f\u0010\u0019\u001a\u00020\u0016H\u0010\u00a2\u0006\u0004\b\u0017\u0010\u0018J,\u0010\u001e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ5\u0010!\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0010\u00a2\u0006\u0004\b\u001f\u0010 J\u000f\u0010$\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\"\u0010#J$\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J$\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0%2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J8\u0010,\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\b2\b\b\u0002\u0010*\u001a\u00020\b2\b\b\u0002\u0010+\u001a\u00020\b2\b\b\u0002\u0010\u001b\u001a\u00020\u001aJ.\u0010-\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\b2\b\b\u0002\u0010)\u001a\u00020\b2\b\b\u0002\u0010*\u001a\u00020\b2\b\b\u0002\u0010+\u001a\u00020\bJJ\u00106\u001a\u00020\u0006\"\u0010\b\u0002\u0010/*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030.2\u0006\u00100\u001a\u00028\u00022\u0017\u00103\u001a\u0013\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00020\u000601\u00a2\u0006\u0002\b22\u0006\u00105\u001a\u000204H\u0016\u00a2\u0006\u0004\b6\u00107J\u0010\u00108\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0005H\u0016J\b\u00109\u001a\u00020\u0006H\u0016J\b\u0010:\u001a\u00020\u0006H\u0016J\u000f\u0010;\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00028\u0001H\u0016\u00a2\u0006\u0004\b=\u0010>J\b\u0010@\u001a\u00020?H\u0016J\b\u0010A\u001a\u00020\u0006H\u0016J\u0010\u0010D\u001a\u00020\u00062\u0006\u0010C\u001a\u00020BH\u0016J\u000f\u0010F\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\bE\u0010#J\u001f\u0010K\u001a\u00020\u00062\u0006\u0010G\u001a\u00020\b2\u0006\u0010H\u001a\u00020\bH\u0000\u00a2\u0006\u0004\bI\u0010JJ\u000f\u0010M\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\bL\u0010#J\u0006\u0010N\u001a\u00020\u001aJ)\u0010S\u001a\u00020\u00062!\u0010R\u001a\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(Q\u0012\u0004\u0012\u00020\u000601R$\u0010U\u001a\u00020\b2\u0006\u0010T\u001a\u00020\b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR$\u0010Y\u001a\u00020\b2\u0006\u0010T\u001a\u00020\b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bY\u0010V\u001a\u0004\bZ\u0010XR\u0016\u0010[\u001a\u00020B8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\"\u0010]\u001a\u00020\u001a8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bRa\u0010i\u001aH\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(Q\u0012\u0004\u0012\u00020\u0006010cj#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0014\u00a2\u0006\f\bO\u0012\b\bP\u0012\u0004\b\b(Q\u0012\u0004\u0012\u00020\u000601`d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010hR(\u0010j\u001a\u0004\u0018\u00010\u00142\b\u0010T\u001a\u0004\u0018\u00010\u00148\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\bj\u0010k\u001a\u0004\bl\u0010mR+\u0010s\u001a\u0012\u0012\u0004\u0012\u00020\u00100nj\b\u0012\u0004\u0012\u00020\u0010`o8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bp\u0010f\u001a\u0004\bq\u0010rR\u0011\u0010u\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\bt\u0010XR\u0011\u0010w\u001a\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\bv\u0010X\u00a8\u0006y"}, d2 = {"Lcom/tencent/kuikly/core/views/ScrollerView;", "Lcom/tencent/kuikly/core/views/ScrollerAttr;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/kuikly/core/views/ScrollerEvent;", "E", "Lcom/tencent/kuikly/core/base/ViewContainer;", "", "initScrollerContentComponentIfNeed", "", "offsetX", "offsetY", "Lcom/tencent/kuikly/core/views/bn;", "params", "handleListDidScroll", "listenScrollEvent", "performAllContentViewLazyTasks", "Lcom/tencent/kuikly/core/views/ad;", "observer", "addScrollerViewEventObserver", "removeScrollerViewEventObserver", "Lcom/tencent/kuikly/core/views/ScrollerContentView;", "createContentView", "Lcom/tencent/kuikly/core/layout/FlexNode;", "internalCreateFlexNode$core_release", "()Lcom/tencent/kuikly/core/layout/FlexNode;", "internalCreateFlexNode", "", "animated", "Lcom/tencent/kuikly/core/views/bs;", "springAnimation", "setContentOffset", "callContentOffset$core_release", "(FFZLcom/tencent/kuikly/core/views/bs;)V", "callContentOffset", "contentViewDidSetFrameToRenderView$core_release", "()V", "contentViewDidSetFrameToRenderView", "Lkotlin/Pair;", "transformInputSetContentOffset", "transformOutputContentOffset", "top", "left", "bottom", "right", "setContentInset", "setContentInsetWhenEndDrag", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "T", "child", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "init", "", "index", "addChild", "(Lcom/tencent/kuikly/core/base/DeclarativeBaseView;Lkotlin/jvm/functions/Function1;I)V", "realContainerView", "willInit", "didInit", "createAttr", "()Lcom/tencent/kuikly/core/views/ScrollerAttr;", "createEvent", "()Lcom/tencent/kuikly/core/views/ScrollerEvent;", "", "viewName", "didRemoveFromParentView", "Lcom/tencent/kuikly/core/layout/d;", AIInput.KEY_FRAME, "layoutFrameDidChanged", "subViewsDidLayout$core_release", "subViewsDidLayout", "width", "height", "contentSizeDidChanged$core_release", "(FF)V", "contentSizeDidChanged", "firePagerParentScrollerDidScroll$core_release", "firePagerParentScrollerDidScroll", "isRowFlexDirection", "Lkotlin/ParameterName;", "name", "view", "task", "performTaskWhenContentViewDidCreated", "<set-?>", "curOffsetX", UserInfo.SEX_FEMALE, "getCurOffsetX", "()F", "curOffsetY", "getCurOffsetY", "lastFrame", "Lcom/tencent/kuikly/core/layout/d;", "shouldListenWillEndDrag", "Z", "getShouldListenWillEndDrag$core_release", "()Z", "setShouldListenWillEndDrag$core_release", "(Z)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contentViewLazyTasks$delegate", "Lkotlin/Lazy;", "getContentViewLazyTasks", "()Ljava/util/ArrayList;", "contentViewLazyTasks", "contentView", "Lcom/tencent/kuikly/core/views/ScrollerContentView;", "getContentView", "()Lcom/tencent/kuikly/core/views/ScrollerContentView;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "scrollerViewEventObserverSet$delegate", "getScrollerViewEventObserverSet", "()Ljava/util/HashSet;", "scrollerViewEventObserverSet", "getContentViewOffsetX", "contentViewOffsetX", "getContentViewOffsetY", "contentViewOffsetY", "<init>", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class ScrollerView<A extends ScrollerAttr, E extends ScrollerEvent> extends ViewContainer<A, E> {
    private ScrollerContentView contentView;

    /* renamed from: contentViewLazyTasks$delegate, reason: from kotlin metadata */
    private final Lazy contentViewLazyTasks;
    private float curOffsetX;
    private float curOffsetY;
    private com.tencent.kuikly.core.layout.d lastFrame = com.tencent.kuikly.core.layout.d.INSTANCE.a();

    /* renamed from: scrollerViewEventObserverSet$delegate, reason: from kotlin metadata */
    private final Lazy scrollerViewEventObserverSet;
    private boolean shouldListenWillEndDrag;

    public ScrollerView() {
        Lazy lazy;
        Lazy lazy2;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<ArrayList<Function1<? super ScrollerContentView, ? extends Unit>>>() { // from class: com.tencent.kuikly.core.views.ScrollerView$contentViewLazyTasks$2
            @Override // kotlin.jvm.functions.Function0
            public final ArrayList<Function1<? super ScrollerContentView, ? extends Unit>> invoke() {
                return new ArrayList<>();
            }
        });
        this.contentViewLazyTasks = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<HashSet<ad>>() { // from class: com.tencent.kuikly.core.views.ScrollerView$scrollerViewEventObserverSet$2
            @Override // kotlin.jvm.functions.Function0
            public final HashSet<ad> invoke() {
                return new HashSet<>();
            }
        });
        this.scrollerViewEventObserverSet = lazy2;
    }

    private final ArrayList<Function1<ScrollerContentView, Unit>> getContentViewLazyTasks() {
        return (ArrayList) this.contentViewLazyTasks.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final HashSet<ad> getScrollerViewEventObserverSet() {
        return (HashSet) this.scrollerViewEventObserverSet.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleListDidScroll(float offsetX, float offsetY, ScrollParams params) {
        List mutableList;
        this.curOffsetX = offsetX;
        this.curOffsetY = offsetY;
        ScrollerContentView scrollerContentView = this.contentView;
        if (scrollerContentView != null) {
            scrollerContentView.i(offsetX, offsetY);
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) getScrollerViewEventObserverSet());
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            ((ad) it.next()).onContentOffsetDidChanged(this.curOffsetX, this.curOffsetY, params);
        }
        ScrollerContentView scrollerContentView2 = this.contentView;
        if (scrollerContentView2 != null) {
            scrollerContentView2.h(offsetX, offsetY, params);
        }
        if (com.tencent.kuikly.core.pager.h.b()) {
            com.tencent.kuikly.core.pager.b h16 = com.tencent.kuikly.core.manager.c.f117352a.h();
            Pager pager = h16 instanceof Pager ? (Pager) h16 : null;
            if (pager != null) {
                pager.fireOnPagerDidScroll(this);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initScrollerContentComponentIfNeed() {
        if (this.contentView == null) {
            ScrollerContentView createContentView = createContentView();
            this.contentView = createContentView;
            if (createContentView != null) {
                createContentView.setPagerId(getPagerId());
                createContentView.getFlexNode().n0(getFlexNode().j());
                createContentView.getFlexNode().q0(getFlexNode().m());
                createContentView.getFlexNode().k0(getFlexNode().e());
                createContentView.getFlexNode().p0(getFlexNode().l());
                FlexNode flexNode = createContentView.getFlexNode();
                StyleSpace.Type type = StyleSpace.Type.TOP;
                flexNode.G0(type, getFlexNode().E(type));
                FlexNode flexNode2 = createContentView.getFlexNode();
                StyleSpace.Type type2 = StyleSpace.Type.LEFT;
                flexNode2.G0(type2, getFlexNode().E(type2));
                createContentView.getFlexNode().G0(type, getFlexNode().E(type));
                FlexNode flexNode3 = createContentView.getFlexNode();
                StyleSpace.Type type3 = StyleSpace.Type.BOTTOM;
                flexNode3.G0(type3, getFlexNode().E(type3));
            }
            final boolean wrapContentSize = ((ScrollerAttr) getViewAttr()).getWrapContentSize();
            ScrollerContentView scrollerContentView = this.contentView;
            if (scrollerContentView != null) {
                scrollerContentView.setWrapContentSize$core_release(wrapContentSize);
            }
            if (getFlexNode().j() != FlexDirection.ROW && getFlexNode().j() != FlexDirection.ROW_REVERSE) {
                ScrollerContentView scrollerContentView2 = this.contentView;
                Intrinsics.checkNotNull(scrollerContentView2);
                super.addChild(scrollerContentView2, new Function1<ScrollerContentView, Unit>() { // from class: com.tencent.kuikly.core.views.ScrollerView$initScrollerContentComponentIfNeed$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ScrollerContentView scrollerContentView3) {
                        invoke2(scrollerContentView3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ScrollerContentView addChild) {
                        Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                        final boolean z16 = wrapContentSize;
                        addChild.attr(new Function1<com.tencent.kuikly.core.base.m, Unit>() { // from class: com.tencent.kuikly.core.views.ScrollerView$initScrollerContentComponentIfNeed$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.m mVar) {
                                invoke2(mVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(com.tencent.kuikly.core.base.m attr) {
                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                if (z16) {
                                    return;
                                }
                                Attr.absolutePosition$default(attr, 0.0f, 0.0f, 0.0f, 0.0f, 4, null);
                            }
                        });
                    }
                }, 0);
            } else {
                ScrollerContentView scrollerContentView3 = this.contentView;
                Intrinsics.checkNotNull(scrollerContentView3);
                super.addChild(scrollerContentView3, new Function1<ScrollerContentView, Unit>() { // from class: com.tencent.kuikly.core.views.ScrollerView$initScrollerContentComponentIfNeed$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ScrollerContentView scrollerContentView4) {
                        invoke2(scrollerContentView4);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ScrollerContentView addChild) {
                        Intrinsics.checkNotNullParameter(addChild, "$this$addChild");
                        final boolean z16 = wrapContentSize;
                        addChild.attr(new Function1<com.tencent.kuikly.core.base.m, Unit>() { // from class: com.tencent.kuikly.core.views.ScrollerView$initScrollerContentComponentIfNeed$2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.base.m mVar) {
                                invoke2(mVar);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(com.tencent.kuikly.core.base.m attr) {
                                Intrinsics.checkNotNullParameter(attr, "$this$attr");
                                if (z16) {
                                    return;
                                }
                                Attr.absolutePosition$default(attr, 0.0f, 0.0f, 0.0f, 0.0f, 8, null);
                            }
                        });
                    }
                }, 0);
            }
            ScrollerContentView scrollerContentView4 = this.contentView;
            Intrinsics.checkNotNull(scrollerContentView4);
            insertDomSubView(scrollerContentView4, 0);
            performAllContentViewLazyTasks();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void listenScrollEvent() {
        final Function1<Object, Unit> handlerWithEventName = ((ScrollerEvent) getEvent()).handlerWithEventName("scroll");
        ((ScrollerEvent) getViewEvent()).scroll(new Function1<ScrollParams, Unit>(this) { // from class: com.tencent.kuikly.core.views.ScrollerView$listenScrollEvent$1
            final /* synthetic */ ScrollerView<A, E> $ctx;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$ctx = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScrollParams scrollParams) {
                invoke2(scrollParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ScrollParams it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Pair<Float, Float> transformOutputContentOffset = this.$ctx.transformOutputContentOffset(it.getOffsetX(), it.getOffsetY());
                it.h(transformOutputContentOffset.getFirst().floatValue());
                it.i(transformOutputContentOffset.getSecond().floatValue());
                this.$ctx.handleListDidScroll(it.getOffsetX(), it.getOffsetY(), it);
                Function1<Object, Unit> function1 = handlerWithEventName;
                if (function1 != null) {
                    function1.invoke(it);
                }
            }
        });
        final Function1<Object, Unit> handlerWithEventName2 = ((ScrollerEvent) getEvent()).handlerWithEventName("dragBegin");
        ((ScrollerEvent) getViewEvent()).dragBegin(new Function1<ScrollParams, Unit>(this) { // from class: com.tencent.kuikly.core.views.ScrollerView$listenScrollEvent$2
            final /* synthetic */ ScrollerView<A, E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScrollParams scrollParams) {
                invoke2(scrollParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ScrollParams scrollParam) {
                HashSet scrollerViewEventObserverSet;
                List mutableList;
                Intrinsics.checkNotNullParameter(scrollParam, "scrollParam");
                scrollerViewEventObserverSet = this.this$0.getScrollerViewEventObserverSet();
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) scrollerViewEventObserverSet);
                Iterator it = mutableList.iterator();
                while (it.hasNext()) {
                    ((ad) it.next()).scrollerDragBegin(scrollParam);
                }
                Function1<Object, Unit> function1 = handlerWithEventName2;
                if (function1 != null) {
                    function1.invoke(scrollParam);
                }
            }
        });
        final Function1<Object, Unit> handlerWithEventName3 = ((ScrollerEvent) getEvent()).handlerWithEventName("scrollEnd");
        ((ScrollerEvent) getViewEvent()).scrollEnd(new Function1<ScrollParams, Unit>(this) { // from class: com.tencent.kuikly.core.views.ScrollerView$listenScrollEvent$3
            final /* synthetic */ ScrollerView<A, E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ScrollParams scrollParams) {
                invoke2(scrollParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ScrollParams scrollParam) {
                HashSet scrollerViewEventObserverSet;
                List mutableList;
                Intrinsics.checkNotNullParameter(scrollParam, "scrollParam");
                scrollerViewEventObserverSet = this.this$0.getScrollerViewEventObserverSet();
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) scrollerViewEventObserverSet);
                Iterator it = mutableList.iterator();
                while (it.hasNext()) {
                    ((ad) it.next()).scrollerScrollDidEnd(scrollParam);
                }
                Function1<Object, Unit> function1 = handlerWithEventName3;
                if (function1 != null) {
                    function1.invoke(scrollParam);
                }
            }
        });
    }

    private final void performAllContentViewLazyTasks() {
        ScrollerContentView scrollerContentView = this.contentView;
        if (scrollerContentView != null) {
            Iterator<T> it = getContentViewLazyTasks().iterator();
            while (it.hasNext()) {
                ((Function1) it.next()).invoke(scrollerContentView);
            }
            getContentViewLazyTasks().clear();
        }
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer
    public <T extends DeclarativeBaseView<?, ?>> void addChild(T child, Function1<? super T, Unit> init, int index) {
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(init, "init");
        initScrollerContentComponentIfNeed();
        ScrollerContentView scrollerContentView = this.contentView;
        Intrinsics.checkNotNull(scrollerContentView);
        scrollerContentView.addChild(child, init, index);
    }

    public final void addScrollerViewEventObserver(ad observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        getScrollerViewEventObserverSet().add(observer);
    }

    public final void contentSizeDidChanged$core_release(float width, float height) {
        List mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) getScrollerViewEventObserverSet());
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            ((ad) it.next()).contentSizeDidChanged(width, height);
        }
    }

    public final void contentViewDidSetFrameToRenderView$core_release() {
        List mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) getScrollerViewEventObserverSet());
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            ((ad) it.next()).contentViewDidSetFrameToRenderView();
        }
    }

    public ScrollerContentView createContentView() {
        return new ScrollerContentView();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didInit() {
        super.didInit();
        listenScrollEvent();
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        getScrollerViewEventObserverSet().clear();
    }

    public final void firePagerParentScrollerDidScroll$core_release() {
        List mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) getScrollerViewEventObserverSet());
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            ((ad) it.next()).onPagerParentScrollerDidScroll();
        }
    }

    public final ScrollerContentView getContentView() {
        return this.contentView;
    }

    public final float getContentViewOffsetX() {
        ScrollerContentView scrollerContentView = this.contentView;
        if (scrollerContentView != null) {
            return scrollerContentView.getOffsetX();
        }
        return 0.0f;
    }

    public final float getContentViewOffsetY() {
        ScrollerContentView scrollerContentView = this.contentView;
        if (scrollerContentView != null) {
            return scrollerContentView.getOffsetY();
        }
        return 0.0f;
    }

    public final float getCurOffsetX() {
        return this.curOffsetX;
    }

    public final float getCurOffsetY() {
        return this.curOffsetY;
    }

    /* renamed from: getShouldListenWillEndDrag$core_release, reason: from getter */
    public final boolean getShouldListenWillEndDrag() {
        return this.shouldListenWillEndDrag;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public FlexNode internalCreateFlexNode$core_release() {
        FlexNode internalCreateFlexNode$core_release = super.internalCreateFlexNode$core_release();
        internalCreateFlexNode$core_release.J0(true);
        return internalCreateFlexNode$core_release;
    }

    public final boolean isRowFlexDirection() {
        ScrollerContentView scrollerContentView = this.contentView;
        if ((scrollerContentView instanceof ScrollerContentView ? scrollerContentView : null) == null) {
            return false;
        }
        Intrinsics.checkNotNull(scrollerContentView, "null cannot be cast to non-null type com.tencent.kuikly.core.views.ScrollerContentView");
        return scrollerContentView.isRowFlexDirection();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0054, code lost:
    
        if ((r4.lastFrame.getHeight() == r5.getHeight()) == false) goto L18;
     */
    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.AbstractBaseView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutFrameDidChanged(com.tencent.kuikly.core.layout.d frame) {
        List mutableList;
        Intrinsics.checkNotNullParameter(frame, "frame");
        super.layoutFrameDidChanged(frame);
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) getScrollerViewEventObserverSet());
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            ((ad) it.next()).scrollFrameDidChanged(frame);
        }
        if (!this.lastFrame.f()) {
            if (this.lastFrame.getWidth() == frame.getWidth()) {
            }
            subViewsDidLayout$core_release();
        }
        this.lastFrame = frame;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void performTaskWhenContentViewDidCreated(Function1<? super ScrollerContentView, Unit> task) {
        Intrinsics.checkNotNullParameter(task, "task");
        ScrollerContentView scrollerContentView = this.contentView;
        if (scrollerContentView != null) {
            task.invoke(scrollerContentView);
        } else {
            getContentViewLazyTasks().add(task);
        }
    }

    @Override // com.tencent.kuikly.core.base.ViewContainer
    public ViewContainer<?, ?> realContainerView() {
        ScrollerContentView scrollerContentView = this.contentView;
        if (scrollerContentView == null) {
            return this;
        }
        Intrinsics.checkNotNull(scrollerContentView);
        return scrollerContentView;
    }

    public final void removeScrollerViewEventObserver(ad observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        getScrollerViewEventObserverSet().remove(observer);
    }

    public final void setContentInset(final float top, final float left, final float bottom, final float right, final boolean animated) {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>(this) { // from class: com.tencent.kuikly.core.views.ScrollerView$setContentInset$1
            final /* synthetic */ ScrollerView<A, E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RenderView renderView = this.this$0.getRenderView();
                if (renderView != null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(top);
                    sb5.append(TokenParser.SP);
                    sb5.append(left);
                    sb5.append(TokenParser.SP);
                    sb5.append(bottom);
                    sb5.append(TokenParser.SP);
                    sb5.append(right);
                    sb5.append(TokenParser.SP);
                    sb5.append(com.tencent.kuikly.core.base.d.b(animated));
                    RenderView.b(renderView, WaterFallComponentName.PROPERTY_CONTENT_INSET, sb5.toString(), null, 4, null);
                }
            }
        });
    }

    public final void setContentInsetWhenEndDrag(final float top, final float left, final float bottom, final float right) {
        performTaskWhenRenderViewDidLoad(new Function0<Unit>(this) { // from class: com.tencent.kuikly.core.views.ScrollerView$setContentInsetWhenEndDrag$1
            final /* synthetic */ ScrollerView<A, E> this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                RenderView renderView = this.this$0.getRenderView();
                if (renderView != null) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(top);
                    sb5.append(TokenParser.SP);
                    sb5.append(left);
                    sb5.append(TokenParser.SP);
                    sb5.append(bottom);
                    sb5.append(TokenParser.SP);
                    sb5.append(right);
                    RenderView.b(renderView, "contentInsetWhenEndDrag", sb5.toString(), null, 4, null);
                }
            }
        });
    }

    public final void setContentOffset(float offsetX, float offsetY, final boolean animated, final bs springAnimation) {
        final Pair<Float, Float> transformInputSetContentOffset = transformInputSetContentOffset(offsetX, offsetY);
        performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.ScrollerView$setContentOffset$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ScrollerContentView contentView;
                if (!animated && springAnimation == null && (contentView = this.getContentView()) != null) {
                    contentView.i(transformInputSetContentOffset.getFirst().floatValue(), transformInputSetContentOffset.getSecond().floatValue());
                }
                this.callContentOffset$core_release(transformInputSetContentOffset.getFirst().floatValue(), transformInputSetContentOffset.getSecond().floatValue(), animated, springAnimation);
            }
        });
    }

    public final void setShouldListenWillEndDrag$core_release(boolean z16) {
        this.shouldListenWillEndDrag = z16;
    }

    public final void subViewsDidLayout$core_release() {
        List mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) getScrollerViewEventObserverSet());
        Iterator it = mutableList.iterator();
        while (it.hasNext()) {
            ((ad) it.next()).subViewsDidLayout();
        }
    }

    public Pair<Float, Float> transformInputSetContentOffset(float offsetX, float offsetY) {
        return new Pair<>(Float.valueOf(offsetX), Float.valueOf(offsetY));
    }

    public Pair<Float, Float> transformOutputContentOffset(float offsetX, float offsetY) {
        return new Pair<>(Float.valueOf(offsetX), Float.valueOf(offsetY));
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        return "KRScrollView";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void willInit() {
        super.willInit();
        ((ScrollerAttr) getAttr()).overflow(true);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public A createAttr() {
        return (A) new ScrollerAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public E createEvent() {
        return (E) new ScrollerEvent();
    }

    public void callContentOffset$core_release(float offsetX, float offsetY, boolean animated, bs springAnimation) {
        String str;
        if (springAnimation != null) {
            str = springAnimation.toString();
        } else {
            str = "";
        }
        RenderView renderView = getRenderView();
        if (renderView != null) {
            RenderView.b(renderView, "contentOffset", offsetX + TokenParser.SP + offsetY + TokenParser.SP + com.tencent.kuikly.core.base.d.b(animated) + str, null, 4, null);
        }
    }

    public static /* synthetic */ void callContentOffset$core_release$default(ScrollerView scrollerView, float f16, float f17, boolean z16, bs bsVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            if ((i3 & 8) != 0) {
                bsVar = null;
            }
            scrollerView.callContentOffset$core_release(f16, f17, z16, bsVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: callContentOffset");
    }

    public static /* synthetic */ void setContentOffset$default(ScrollerView scrollerView, float f16, float f17, boolean z16, bs bsVar, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                z16 = false;
            }
            if ((i3 & 8) != 0) {
                bsVar = null;
            }
            scrollerView.setContentOffset(f16, f17, z16, bsVar);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setContentOffset");
    }

    public static /* synthetic */ void setContentInsetWhenEndDrag$default(ScrollerView scrollerView, float f16, float f17, float f18, float f19, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                f16 = 0.0f;
            }
            if ((i3 & 2) != 0) {
                f17 = 0.0f;
            }
            if ((i3 & 4) != 0) {
                f18 = 0.0f;
            }
            if ((i3 & 8) != 0) {
                f19 = 0.0f;
            }
            scrollerView.setContentInsetWhenEndDrag(f16, f17, f18, f19);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setContentInsetWhenEndDrag");
    }

    public static /* synthetic */ void setContentInset$default(ScrollerView scrollerView, float f16, float f17, float f18, float f19, boolean z16, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                f16 = 0.0f;
            }
            if ((i3 & 2) != 0) {
                f17 = 0.0f;
            }
            if ((i3 & 4) != 0) {
                f18 = 0.0f;
            }
            if ((i3 & 8) != 0) {
                f19 = 0.0f;
            }
            if ((i3 & 16) != 0) {
                z16 = false;
            }
            scrollerView.setContentInset(f16, f17, f18, f19, z16);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setContentInset");
    }
}
