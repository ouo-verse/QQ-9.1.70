package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order;

import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.IQPlusTrafficSkeletonItemData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonGroupItemData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonGroupRepeatItemData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonItemData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonViewAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonViewKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexJustifyContent;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeOrderView$bodyWithSkeletonView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public static final QPlusTrafficHomeOrderView$bodyWithSkeletonView$1 INSTANCE = new QPlusTrafficHomeOrderView$bodyWithSkeletonView$1();

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        QPlusTrafficSkeletonViewKt.SkeletonView(viewContainer, new Function1<QPlusTrafficSkeletonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView$bodyWithSkeletonView$1.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusTrafficSkeletonView qPlusTrafficSkeletonView) {
                qPlusTrafficSkeletonView.attr(new Function1<QPlusTrafficSkeletonViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.order.QPlusTrafficHomeOrderView.bodyWithSkeletonView.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QPlusTrafficSkeletonViewAttr qPlusTrafficSkeletonViewAttr) {
                        ArrayList arrayListOf;
                        ArrayList arrayListOf2;
                        ArrayList arrayListOf3;
                        ArrayList<IQPlusTrafficSkeletonItemData> arrayListOf4;
                        FlexJustifyContent flexJustifyContent = FlexJustifyContent.SPACE_BETWEEN;
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new QPlusTrafficSkeletonItemData(60.0f, 20.0f, 16.0f, 0.0f, 16.0f, 0.0f, 40), new QPlusTrafficSkeletonItemData(74.0f, 20.0f, 0.0f, 16.0f, 16.0f, 0.0f, 36));
                        FlexDirection flexDirection = FlexDirection.COLUMN;
                        arrayListOf2 = CollectionsKt__CollectionsKt.arrayListOf(new QPlusTrafficSkeletonItemData(74.0f, 20.0f, 16.0f, 0.0f, 16.0f, 0.0f, 40), new QPlusTrafficSkeletonItemData(140.0f, 36.0f, 16.0f, 0.0f, 4.0f, 0.0f, 40));
                        arrayListOf3 = CollectionsKt__CollectionsKt.arrayListOf(new QPlusTrafficSkeletonItemData(65.0f, 65.0f, 16.0f, 0.0f, 14.0f, 14.0f, 8), new QPlusTrafficSkeletonGroupItemData(arrayListOf2, flexDirection, null, 94));
                        arrayListOf4 = CollectionsKt__CollectionsKt.arrayListOf(new QPlusTrafficSkeletonGroupItemData(arrayListOf, null, flexJustifyContent, 62), new QPlusTrafficSkeletonGroupRepeatItemData(new QPlusTrafficSkeletonGroupItemData(arrayListOf3, null, null, 126), 2, 0.0f, flexDirection, null, 188));
                        qPlusTrafficSkeletonViewAttr.viewData = arrayListOf4;
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }

    public QPlusTrafficHomeOrderView$bodyWithSkeletonView$1() {
        super(1);
    }
}
