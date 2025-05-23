package com.tencent.hippykotlin.demo.pages.base.view;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.pager.c;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class QQKuiklyPageView extends DeclarativeBaseView<QQKuiklyPageAttr, QQKuiklyPageEvent> implements c {
    public static final /* synthetic */ int $r8$clinit = 0;

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QQKuiklyPageAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QQKuiklyPageEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final void didInit() {
        super.didInit();
        if (((QQKuiklyPageAttr) getAttr()).didSetPageData) {
            return;
        }
        QQKuiklyPageAttr qQKuiklyPageAttr = (QQKuiklyPageAttr) getViewAttr();
        e eVar = new e();
        qQKuiklyPageAttr.didSetPageData = true;
        if (!eVar.a(KuiklyLaunchParams.PARAM_MIN_RES_VERSION)) {
            eVar.v(KuiklyLaunchParams.PARAM_MIN_RES_VERSION, "");
        }
        if (!eVar.a(KuiklyLaunchParams.PARAM_ERROR_URL)) {
            eVar.v(KuiklyLaunchParams.PARAM_ERROR_URL, "");
        }
        qQKuiklyPageAttr.with(ISchemeApi.KEY_PAGE_DATA, eVar.toString());
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001c, code lost:
    
        if (r0.pagerAppear == true) goto L11;
     */
    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void didMoveToParentView() {
        super.didMoveToParentView();
        getPager().addPagerEventObserver(this);
        b pager = getPager();
        BasePager basePager = pager instanceof BasePager ? (BasePager) pager : null;
        boolean z16 = basePager != null;
        if (z16) {
            sendPagerEvent(Pager.PAGER_EVENT_DID_APPEAR, null);
        }
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        getPager().removePagerEventObserver(this);
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onPagerEvent(String str, e eVar) {
        if (Intrinsics.areEqual(str, Pager.PAGER_EVENT_DID_DISAPPEAR) || Intrinsics.areEqual(str, Pager.PAGER_EVENT_DID_APPEAR)) {
            sendPagerEvent(str, eVar);
        }
    }

    @Override // com.tencent.kuikly.core.pager.c
    public final void onRootViewSizeChanged(double d16, double d17) {
        c.a.a(this, d16, d17);
    }

    public final void sendPagerEvent(String str, e eVar) {
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("event", str);
        if (eVar == null) {
            eVar = new e();
        }
        m3.v("data", eVar);
        AbstractBaseView.callRenderViewMethod$default(this, "sendEvent", m3.toString(), null, 4, null);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "QQKuiklyPageView";
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final void willInit() {
        super.willInit();
        event(new Function1<QQKuiklyPageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.view.QQKuiklyPageView$willInit$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QQKuiklyPageEvent qQKuiklyPageEvent) {
                QQKuiklyPageEvent qQKuiklyPageEvent2 = qQKuiklyPageEvent;
                final QQKuiklyPageView qQKuiklyPageView = QQKuiklyPageView.this;
                VisibilityEventKt.b(qQKuiklyPageEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.view.QQKuiklyPageView$willInit$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object obj) {
                        QQKuiklyPageView qQKuiklyPageView2 = QQKuiklyPageView.this;
                        int i3 = QQKuiklyPageView.$r8$clinit;
                        qQKuiklyPageView2.sendPagerEvent("didAppear", null);
                        return Unit.INSTANCE;
                    }
                });
                final QQKuiklyPageView qQKuiklyPageView2 = QQKuiklyPageView.this;
                VisibilityEventKt.c(qQKuiklyPageEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.view.QQKuiklyPageView$willInit$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object obj) {
                        QQKuiklyPageView qQKuiklyPageView3 = QQKuiklyPageView.this;
                        int i3 = QQKuiklyPageView.$r8$clinit;
                        qQKuiklyPageView3.sendPagerEvent("didDisappear", null);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
    }
}
