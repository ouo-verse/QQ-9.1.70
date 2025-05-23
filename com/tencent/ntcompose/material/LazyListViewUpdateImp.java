package com.tencent.ntcompose.material;

import com.tencent.hippy.qq.view.viola.list.TkdListView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.co;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import to3.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/material/LazyListViewUpdateImp;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class LazyListViewUpdateImp implements com.tencent.ntcompose.core.f {

    /* renamed from: a, reason: collision with root package name */
    public static final LazyListViewUpdateImp f339344a = new LazyListViewUpdateImp();

    LazyListViewUpdateImp() {
    }

    @Override // com.tencent.ntcompose.core.f
    public void resetPropToView(ComposeRenderView view, String propKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ntcompose.core.f
    public void setPropToView(ComposeRenderView view, String propKey, Object propArg0, Object propArg1, Object propArg2, Object propArg3, Object propArg4) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        DeclarativeBaseView<?, ?> b16 = view.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.kuikly.core.views.ListView<com.tencent.kuikly.core.views.ListAttr, com.tencent.kuikly.core.views.ListEvent>");
        final aq aqVar = (aq) b16;
        final com.tencent.kuikly.core.views.ao aoVar = (com.tencent.kuikly.core.views.ao) aqVar.getViewAttr();
        switch (propKey.hashCode()) {
            case -1617291911:
                if (propKey.equals("onContentSizeChanged")) {
                    ap apVar = (ap) aqVar.getViewEvent();
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function2<@[ParameterName(name = 'width')] kotlin.Float, @[ParameterName(name = 'height')] kotlin.Float, kotlin.Unit>{ com.tencent.ntcompose.material.LazyListKt.ContentSizeChangedEventCallback }");
                    apVar.contentSizeChanged((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 2));
                    return;
                }
                return;
            case -1235167597:
                if (propKey.equals("listState")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.foundation.lazy.LazyListState");
                    com.tencent.ntcompose.foundation.lazy.d dVar = (com.tencent.ntcompose.foundation.lazy.d) propArg0;
                    if (aoVar.getExtProps().get("listState") == dVar) {
                        return;
                    }
                    aoVar.getExtProps().put("listState", dVar);
                    dVar.i(new com.tencent.kuikly.core.base.aa<>(aqVar.getPagerId(), aqVar.getNativeRef()));
                    return;
                }
                return;
            case -1157066076:
                if (propKey.equals("firstMaxIndexLoad")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Int");
                    aoVar.firstContentLoadMaxIndex(((Integer) propArg0).intValue());
                    return;
                }
                return;
            case -1104094626:
                if (propKey.equals("onBeginDrag") && !((ap) aqVar.getViewEvent()).getExtProps().containsKey("didBindBeginDrag")) {
                    ((ap) aqVar.getViewEvent()).getExtProps().put("didBindBeginDrag", 1);
                    ap apVar2 = (ap) aqVar.getViewEvent();
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'e')] com.tencent.kuikly.core.views.ScrollParams, kotlin.Unit>{ com.tencent.ntcompose.material.LazyListKt.ListEventCallback }");
                    apVar2.dragBegin((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            case -451062440:
                if (propKey.equals("contentPadding")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.foundation.layout.PaddingValues");
                    com.tencent.ntcompose.foundation.layout.l lVar = (com.tencent.ntcompose.foundation.layout.l) propArg0;
                    float top = lVar.getTop();
                    LayoutDirection layoutDirection = LayoutDirection.Ltr;
                    aoVar.padding(top, lVar.a(layoutDirection), lVar.getBottom(), lVar.b(layoutDirection));
                    return;
                }
                return;
            case -271432240:
                if (propKey.equals("onEndDrag") && !((ap) aqVar.getViewEvent()).getExtProps().containsKey("didBindEndDrag")) {
                    ((ap) aqVar.getViewEvent()).getExtProps().put("didBindEndDrag", 1);
                    ap apVar3 = (ap) aqVar.getViewEvent();
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'e')] com.tencent.kuikly.core.views.ScrollParams, kotlin.Unit>{ com.tencent.ntcompose.material.LazyListKt.ListEventCallback }");
                    apVar3.dragEnd((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            case -84911448:
                if (propKey.equals("onWillDragEndBySync")) {
                    aoVar.flingEnable(false);
                    ap apVar4 = (ap) aqVar.getViewEvent();
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<com.tencent.kuikly.core.views.WillEndDragParams, kotlin.Unit>");
                    apVar4.willDragEndBySync((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            case 29257060:
                if (propKey.equals("itemsLayoutType")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.material.ListItemsLayoutType");
                    ListItemsLayoutType listItemsLayoutType = (ListItemsLayoutType) propArg0;
                    if (listItemsLayoutType == ListItemsLayoutType.ColumnLinear) {
                        aoVar.flexDirectionColumn();
                        return;
                    }
                    if (listItemsLayoutType == ListItemsLayoutType.RowLinear) {
                        aoVar.flexDirectionRow();
                        return;
                    } else if (listItemsLayoutType == ListItemsLayoutType.VerticalGrid) {
                        aoVar.flexDirectionColumn();
                        return;
                    } else {
                        if (listItemsLayoutType == ListItemsLayoutType.HorizontalGrid) {
                            aoVar.flexDirectionRow();
                            return;
                        }
                        return;
                    }
                }
                return;
            case 286735604:
                if (propKey.equals("paddingEnable")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    aoVar.pagingEnable(((Boolean) propArg0).booleanValue());
                    return;
                }
                return;
            case 369680317:
                if (propKey.equals(ScrollerAttr.SCROLL_WITH_PARENT)) {
                    aoVar.scrollWithParent((Boolean) propArg0);
                    return;
                }
                return;
            case 386979759:
                if (propKey.equals(TkdListView.EVENT_TYPE_SCROLL_END) && !((ap) aqVar.getViewEvent()).getExtProps().containsKey("didBindScrollEnd")) {
                    ((ap) aqVar.getViewEvent()).getExtProps().put("didBindScrollEnd", 1);
                    ap apVar5 = (ap) aqVar.getViewEvent();
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'e')] com.tencent.kuikly.core.views.ScrollParams, kotlin.Unit>{ com.tencent.ntcompose.material.LazyListKt.ListEventCallback }");
                    apVar5.scrollEnd((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            case 629240233:
                if (propKey.equals("userScrollEnabled")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    aoVar.scrollEnable(((Boolean) propArg0).booleanValue());
                    return;
                }
                return;
            case 794879274:
                if (propKey.equals("visibleAreaIgnoreBottomMargin")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    aoVar.visibleAreaIgnoreBottomMargin(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 972542030:
                if (propKey.equals(ScrollerAttr.BOUNCES_ENABLE)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    ScrollerAttr.bouncesEnable$default(aoVar, ((Boolean) propArg0).booleanValue(), false, 2, null);
                    return;
                }
                return;
            case 1069199971:
                if (propKey.equals("preloadViewDistance")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    aoVar.preloadViewDistance(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 1406211986:
                if (propKey.equals("visibleAreaIgnoreTopMargin")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    aoVar.visibleAreaIgnoreTopMargin(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 1442056142:
                if (propKey.equals("flingBehavior")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.foundation.gestures.FlingBehavior");
                    final to3.a aVar = (to3.a) propArg0;
                    if (aoVar.getExtProps().get("flingBehavior") == aVar) {
                        return;
                    }
                    aoVar.getExtProps().put("flingBehavior", aVar);
                    aoVar.flingEnable(false);
                    ((ap) aqVar.getViewEvent()).willDragEndBySync(new Function1<co, Unit>() { // from class: com.tencent.ntcompose.material.LazyListViewUpdateImp$setPropToView$1$1
                        /* JADX INFO: Access modifiers changed from: package-private */
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
                        public final void invoke2(co params) {
                            float a16;
                            Intrinsics.checkNotNullParameter(params, "params");
                            Object obj = com.tencent.kuikly.core.views.ao.this.getExtProps().get("listState");
                            com.tencent.ntcompose.foundation.lazy.d dVar2 = obj instanceof com.tencent.ntcompose.foundation.lazy.d ? (com.tencent.ntcompose.foundation.lazy.d) obj : null;
                            if (dVar2 == null) {
                                dVar2 = new com.tencent.ntcompose.foundation.lazy.d(0, 0.0f);
                                aq<com.tencent.kuikly.core.views.ao, ap> aqVar2 = aqVar;
                                dVar2.i(new com.tencent.kuikly.core.base.aa<>(aqVar2.getPagerId(), aqVar2.getNativeRef()));
                                com.tencent.kuikly.core.views.ao.this.getExtProps().put("listState", dVar2);
                            }
                            com.tencent.ntcompose.foundation.lazy.d dVar3 = dVar2;
                            to3.a aVar2 = aVar;
                            dVar3.m(false);
                            if (dVar3.j()) {
                                a16 = aVar2.a(dVar3, params.getVelocityX());
                            } else {
                                a16 = aVar2.a(dVar3, params.getVelocityY());
                            }
                            if (dVar3.getDidCallSetContentOffset()) {
                                return;
                            }
                            if (a16 == 0.0f) {
                                b.a.a(dVar3, 0.0f, false, null, 6, null);
                            }
                        }
                    });
                    return;
                }
                return;
            case 1454025080:
                if (propKey.equals(ScrollerAttr.SHOW_SCROLLER_INDICATOR)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    aoVar.showScrollerIndicator(((Boolean) propArg0).booleanValue());
                    return;
                }
                return;
            case 1490730380:
                if (propKey.equals(HippyScrollViewEventHelper.EVENT_TYPE_SCROLL) && !((ap) aqVar.getViewEvent()).getExtProps().containsKey("didBindScroll")) {
                    ((ap) aqVar.getViewEvent()).getExtProps().put("didBindScroll", 1);
                    ap apVar6 = (ap) aqVar.getViewEvent();
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'e')] com.tencent.kuikly.core.views.ScrollParams, kotlin.Unit>{ com.tencent.ntcompose.material.LazyListKt.ListEventCallback }");
                    apVar6.scroll((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                return;
            case 1973298442:
                if (propKey.equals(ScrollerAttr.SYNC_SCROLL_IN_MAX_OFFSET)) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    aoVar.syncScrollInMaxOffset(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case 2087406920:
                if (propKey.equals("syncScroll")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    aoVar.syncScroll(((Boolean) propArg0).booleanValue());
                    return;
                }
                return;
            default:
                return;
        }
    }
}
