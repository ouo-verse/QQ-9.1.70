package com.tencent.hippykotlin.demo.pages.hrc_pages;

import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardCompose;
import com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardPagerView;
import com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.c;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public abstract class HippyRenderCardPage extends BasePager implements c {
    public aa<HippyRenderCardPagerView> hrcPagerViewRef;

    public HippyRenderCardPage() {
        addPagerEventObserver(this);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.HippyRenderCardPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final HippyRenderCardPage hippyRenderCardPage = HippyRenderCardPage.this;
                viewContainer.addChild(new HippyRenderCardPagerView(), new Function1<HippyRenderCardPagerView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.HippyRenderCardPage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(HippyRenderCardPagerView hippyRenderCardPagerView) {
                        HippyRenderCardPagerView hippyRenderCardPagerView2 = hippyRenderCardPagerView;
                        final HippyRenderCardPage hippyRenderCardPage2 = HippyRenderCardPage.this;
                        hippyRenderCardPagerView2.ref(hippyRenderCardPagerView2, new Function1<aa<HippyRenderCardPagerView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.hrc_pages.HippyRenderCardPage.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<HippyRenderCardPagerView> aaVar) {
                                HippyRenderCardPage.this.hrcPagerViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new k();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.base.AbstractBaseView
    public final l createEvent() {
        return new l();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.List<com.tencent.kuikly.core.base.aa<com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardView>>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.util.List<com.tencent.kuikly.core.base.aa<com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardView>>, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.util.List<com.tencent.kuikly.core.base.aa<com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardView>>, java.util.ArrayList] */
    @Override // com.tencent.kuikly.core.pager.c
    public final void onPagerEvent(String str, e eVar) {
        aa<HippyRenderCardPagerView> aaVar = this.hrcPagerViewRef;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hrcPagerViewRef");
            aaVar = null;
        }
        HippyRenderCardPagerView b16 = aaVar.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardPagerView");
        HippyRenderCardPagerView hippyRenderCardPagerView = b16;
        hippyRenderCardPagerView.getClass();
        KLog.INSTANCE.d("HippyRenderCardPagerView", "onReceiveCustomEvent pagerEvent:" + str + ",eventData:" + eVar);
        if ("hrc_preCreateNode".equals(str)) {
            hippyRenderCardPagerView.pagerViewAttr.getHrcDataList().add(eVar);
            return;
        }
        if ("hrc_createRealView".equals(str)) {
            int k3 = eVar.k("hrcId", -1);
            if (hippyRenderCardPagerView.getParent() == null || hippyRenderCardPagerView.getRenderView() == null || k3 == -1) {
                return;
            }
            Iterator it = hippyRenderCardPagerView.hrcCardViewRefList.iterator();
            while (it.hasNext()) {
                aa aaVar2 = (aa) it.next();
                DeclarativeBaseView b17 = aaVar2.b();
                Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardView");
                if (k3 == ((HippyRenderCardView) b17).hrcAttr.hrcId) {
                    HippyRenderCardView hippyRenderCardView = (HippyRenderCardView) aaVar2.b();
                    if (hippyRenderCardView != null) {
                        if (hippyRenderCardView.getRenderView() == null) {
                            hippyRenderCardView.createRenderView();
                            RenderView renderView = hippyRenderCardPagerView.getRenderView();
                            Intrinsics.checkNotNull(renderView);
                            renderView.e(hippyRenderCardView.getNativeRef(), -1);
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if ("hrc_removeView".equals(str)) {
            Iterator<e> it5 = hippyRenderCardPagerView.pagerViewAttr.getHrcDataList().iterator();
            int i3 = -1;
            while (it5.hasNext()) {
                e next = it5.next();
                if (eVar.k("hrcId", -1) == next.k("hrcId", -100)) {
                    i3 = hippyRenderCardPagerView.pagerViewAttr.getHrcDataList().indexOf(next);
                }
            }
            if (i3 != -1) {
                hippyRenderCardPagerView.pagerViewAttr.getHrcDataList().remove(i3);
            }
            hippyRenderCardPagerView.hrcCardViewRefList.remove(i3);
            return;
        }
        Iterator it6 = hippyRenderCardPagerView.hrcCardViewRefList.iterator();
        while (it6.hasNext()) {
            DeclarativeBaseView b18 = ((aa) it6.next()).b();
            Intrinsics.checkNotNull(b18, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.base.view.hrc.HippyRenderCardView");
            ((HippyRenderCardView) b18).onReceiveCustomEvent(str, eVar);
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }

    public final void registerCard(String str, Function1<? super e, ? extends HippyRenderCardCompose<?>> function1) {
        HippyRenderCardView.hrcComposeMap.put(str, function1);
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.base.AbstractBaseView
    public final k createAttr() {
        return new k();
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
