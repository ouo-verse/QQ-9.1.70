package com.tencent.hippykotlin.demo.pages.adelie.common.compose.view.superResolution;

import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.AdelieSuperResolutionImageView;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.AdelieSuperResolutionImageViewAttr;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.AdelieSuperResolutionImageViewEvent;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.LoadSuccessParams;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.core.f;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes31.dex */
public final class AdelieSuperResolutionPropUpdater implements f {
    public static final AdelieSuperResolutionPropUpdater INSTANCE = new AdelieSuperResolutionPropUpdater();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.ntcompose.core.f
    public final void setPropToView(ComposeRenderView composeRenderView, String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        DeclarativeBaseView<?, ?> b16 = composeRenderView.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.AdelieSuperResolutionImageView");
        AdelieSuperResolutionImageViewAttr adelieSuperResolutionImageViewAttr = (AdelieSuperResolutionImageViewAttr) ((AdelieSuperResolutionImageView) b16).getViewAttr();
        int hashCode = str.hashCode();
        if (hashCode == -1021576190) {
            if (str.equals("loadSuperResolutionSuccess")) {
                Object viewEvent = composeRenderView.b().getViewEvent();
                Intrinsics.checkNotNull(viewEvent, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.AdelieSuperResolutionImageViewEvent");
                AdelieSuperResolutionImageViewEvent adelieSuperResolutionImageViewEvent = (AdelieSuperResolutionImageViewEvent) viewEvent;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function1<com.tencent.kuikly.core.views.LoadSuccessParams, kotlin.Unit>");
                final Function1 function1 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
                adelieSuperResolutionImageViewEvent.getClass();
                adelieSuperResolutionImageViewEvent.register("loadSuperResolutionSuccess", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.AdelieSuperResolutionImageViewEvent$loadSuperResolutionSuccess$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object obj6) {
                        function1.invoke(LoadSuccessParams.INSTANCE.a(obj6));
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            return;
        }
        if (hashCode == 114148) {
            if (str.equals("src")) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                adelieSuperResolutionImageViewAttr.with("src", (String) obj);
                return;
            }
            return;
        }
        if (hashCode != 1845177636) {
            if (hashCode == 1915020349 && str.equals("loadSuccess")) {
                Object viewEvent2 = composeRenderView.b().getViewEvent();
                Intrinsics.checkNotNull(viewEvent2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.AdelieSuperResolutionImageViewEvent");
                AdelieSuperResolutionImageViewEvent adelieSuperResolutionImageViewEvent2 = (AdelieSuperResolutionImageViewEvent) viewEvent2;
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function1<com.tencent.kuikly.core.views.LoadSuccessParams, kotlin.Unit>");
                final Function1 function12 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
                adelieSuperResolutionImageViewEvent2.getClass();
                adelieSuperResolutionImageViewEvent2.register("loadSuccess", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.AdelieSuperResolutionImageViewEvent$loadSuccess$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object obj6) {
                        function12.invoke(LoadSuccessParams.INSTANCE.a(obj6));
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            return;
        }
        if (str.equals("loadFail")) {
            Object viewEvent3 = composeRenderView.b().getViewEvent();
            Intrinsics.checkNotNull(viewEvent3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.AdelieSuperResolutionImageViewEvent");
            AdelieSuperResolutionImageViewEvent adelieSuperResolutionImageViewEvent3 = (AdelieSuperResolutionImageViewEvent) viewEvent3;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Function1<com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams, kotlin.Unit>");
            final Function1 function13 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
            adelieSuperResolutionImageViewEvent3.getClass();
            adelieSuperResolutionImageViewEvent3.register("loadFail", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.AdelieSuperResolutionImageViewEvent$loadFail$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object obj6) {
                    Function1<LoadFailParams, Unit> function14 = function13;
                    e eVar = obj6 instanceof e ? (e) obj6 : null;
                    if (eVar == null) {
                        eVar = new e();
                    }
                    function14.invoke(new LoadFailParams(eVar.k("code", 0), eVar.q("msg", "")));
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.ntcompose.core.f
    public final void resetPropToView(ComposeRenderView composeRenderView, String str) {
    }
}
