package com.tencent.ntcompose.material;

import com.tencent.kuikly.core.views.PageListEvent;
import com.tencent.kuikly.core.views.be;
import com.tencent.ntcompose.core.ComposeRenderView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/material/PageListViewPropUpdater;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PageListViewPropUpdater implements com.tencent.ntcompose.core.f {

    /* renamed from: a, reason: collision with root package name */
    public static final PageListViewPropUpdater f339345a = new PageListViewPropUpdater();

    PageListViewPropUpdater() {
    }

    @Override // com.tencent.ntcompose.core.f
    public void resetPropToView(ComposeRenderView view, String propKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
    }

    @Override // com.tencent.ntcompose.core.f
    public void setPropToView(ComposeRenderView view, String propKey, Object propArg0, Object propArg1, Object propArg2, Object propArg3, Object propArg4) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Object viewAttr = view.b().getViewAttr();
        Intrinsics.checkNotNull(viewAttr, "null cannot be cast to non-null type com.tencent.kuikly.core.views.PageListAttr");
        be beVar = (be) viewAttr;
        switch (propKey.hashCode()) {
            case -2080578396:
                if (propKey.equals("pageItemWidth")) {
                    Float f16 = propArg0 instanceof Float ? (Float) propArg0 : null;
                    if (f16 != null) {
                        beVar.pageItemWidth(f16.floatValue());
                        return;
                    }
                    return;
                }
                return;
            case -1620387262:
                if (propKey.equals("defaultPageIndex")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Int");
                    beVar.defaultPageIndex(((Integer) propArg0).intValue());
                    return;
                }
                return;
            case -1443069368:
                if (propKey.equals("pageIndexRatio")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    beVar.setIndexRatio(((Float) propArg0).floatValue());
                    return;
                }
                return;
            case -1268106055:
                if (propKey.equals("onPageIndexDidChanged")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'index')] kotlin.Int, kotlin.Unit>");
                    final Function1 function1 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1);
                    Object viewEvent = view.b().getViewEvent();
                    PageListEvent pageListEvent = viewEvent instanceof PageListEvent ? (PageListEvent) viewEvent : null;
                    if (pageListEvent != null) {
                        pageListEvent.pageIndexDidChanged(new Function1<Object, Unit>() { // from class: com.tencent.ntcompose.material.PageListViewPropUpdater$setPropToView$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                                invoke2(obj);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(Object obj) {
                                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                function1.invoke(Integer.valueOf(((com.tencent.kuikly.core.nvi.serialization.json.e) obj).j("index")));
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            case -506415607:
                if (propKey.equals("pageItemHeight")) {
                    Float f17 = propArg0 instanceof Float ? (Float) propArg0 : null;
                    if (f17 != null) {
                        beVar.pageItemHeight(f17.floatValue());
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }
}
