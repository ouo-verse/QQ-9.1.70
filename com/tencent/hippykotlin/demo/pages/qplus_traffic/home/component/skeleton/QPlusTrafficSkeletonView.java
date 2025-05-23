package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.FlexDirection;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class QPlusTrafficSkeletonView extends ComposeView<QPlusTrafficSkeletonViewAttr, l> {
    public static final Function1 access$bodyWithView(QPlusTrafficSkeletonView qPlusTrafficSkeletonView, QPlusTrafficSkeletonView qPlusTrafficSkeletonView2, IQPlusTrafficSkeletonItemData iQPlusTrafficSkeletonItemData) {
        qPlusTrafficSkeletonView.getClass();
        return new QPlusTrafficSkeletonView$bodyWithView$1(iQPlusTrafficSkeletonItemData, qPlusTrafficSkeletonView2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QPlusTrafficSkeletonViewAttr access$getAttr(QPlusTrafficSkeletonView qPlusTrafficSkeletonView) {
        return (QPlusTrafficSkeletonViewAttr) qPlusTrafficSkeletonView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h hVar;
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.flexDirection(FlexDirection.COLUMN);
                        hVar = IPagerIdKtxKt.getSkinColor(mVar2).tokenColor("qecommerce_skin_color_bg_default", false);
                        mVar2.mo113backgroundColor(hVar);
                        return Unit.INSTANCE;
                    }
                });
                ArrayList<IQPlusTrafficSkeletonItemData> arrayList = QPlusTrafficSkeletonView.access$getAttr(QPlusTrafficSkeletonView.this).viewData;
                QPlusTrafficSkeletonView qPlusTrafficSkeletonView = QPlusTrafficSkeletonView.this;
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    ((QPlusTrafficSkeletonView$bodyWithView$1) QPlusTrafficSkeletonView.access$bodyWithView(qPlusTrafficSkeletonView, qPlusTrafficSkeletonView, (IQPlusTrafficSkeletonItemData) it.next())).invoke(viewContainer2);
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QPlusTrafficSkeletonViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
