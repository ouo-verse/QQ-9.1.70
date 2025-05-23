package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data;

import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.IQPlusTrafficSkeletonItemData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonGroupRepeatItemData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonItemData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonViewAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonViewKt;
import com.tencent.kuikly.core.base.ViewContainer;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class QPlusAccessHomeDataView$bodyWithSkeletonView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public static final QPlusAccessHomeDataView$bodyWithSkeletonView$1 INSTANCE = new QPlusAccessHomeDataView$bodyWithSkeletonView$1();

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        QPlusTrafficSkeletonViewKt.SkeletonView(viewContainer, new Function1<QPlusTrafficSkeletonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView$bodyWithSkeletonView$1.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusTrafficSkeletonView qPlusTrafficSkeletonView) {
                qPlusTrafficSkeletonView.attr(new Function1<QPlusTrafficSkeletonViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data.QPlusAccessHomeDataView.bodyWithSkeletonView.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QPlusTrafficSkeletonViewAttr qPlusTrafficSkeletonViewAttr) {
                        ArrayList<IQPlusTrafficSkeletonItemData> arrayListOf;
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new QPlusTrafficSkeletonGroupRepeatItemData(new QPlusTrafficSkeletonItemData(60.0f, 28.0f, 8.0f, 0.0f, 16.0f, 0.0f, 40), 2, 8.0f, null, null, 236), new QPlusTrafficSkeletonGroupRepeatItemData(new QPlusTrafficSkeletonItemData(52.0f, 28.0f, 8.0f, 0.0f, 16.0f, 0.0f, 40), 3, 8.0f, null, null, 236), new QPlusTrafficSkeletonGroupRepeatItemData(new QPlusTrafficSkeletonItemData(80.0f, 45.0f, 8.0f, 0.0f, 16.0f, 0.0f, 40), 4, 8.0f, null, null, 236));
                        qPlusTrafficSkeletonViewAttr.viewData = arrayListOf;
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }

    public QPlusAccessHomeDataView$bodyWithSkeletonView$1() {
        super(1);
    }
}
