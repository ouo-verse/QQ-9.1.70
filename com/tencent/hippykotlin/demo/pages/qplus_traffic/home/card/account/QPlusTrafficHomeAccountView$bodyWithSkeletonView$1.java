package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account;

import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.IQPlusTrafficSkeletonItemData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonGroupRepeatItemData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonItemData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonViewAttr;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonViewKt;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.layout.FlexJustifyContent;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeAccountView$bodyWithSkeletonView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public static final QPlusTrafficHomeAccountView$bodyWithSkeletonView$1 INSTANCE = new QPlusTrafficHomeAccountView$bodyWithSkeletonView$1();

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        QPlusTrafficSkeletonViewKt.SkeletonView(viewContainer, new Function1<QPlusTrafficSkeletonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView$bodyWithSkeletonView$1.1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(QPlusTrafficSkeletonView qPlusTrafficSkeletonView) {
                qPlusTrafficSkeletonView.attr(new Function1<QPlusTrafficSkeletonViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.account.QPlusTrafficHomeAccountView.bodyWithSkeletonView.1.1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(QPlusTrafficSkeletonViewAttr qPlusTrafficSkeletonViewAttr) {
                        ArrayList<IQPlusTrafficSkeletonItemData> arrayListOf;
                        FlexJustifyContent flexJustifyContent = FlexJustifyContent.SPACE_AROUND;
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new QPlusTrafficSkeletonItemData(60.0f, 21.0f, 16.0f, 0.0f, 16.0f, 0.0f, 40), new QPlusTrafficSkeletonGroupRepeatItemData(new QPlusTrafficSkeletonItemData(61.0f, 23.0f, 0.0f, 0.0f, 16.0f, 0.0f, 44), 2, 0.0f, null, flexJustifyContent, 124), new QPlusTrafficSkeletonGroupRepeatItemData(new QPlusTrafficSkeletonItemData(85.0f, 17.0f, 0.0f, 0.0f, 4.0f, 0.0f, 44), 2, 0.0f, null, flexJustifyContent, 124));
                        qPlusTrafficSkeletonViewAttr.viewData = arrayListOf;
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }

    public QPlusTrafficHomeAccountView$bodyWithSkeletonView$1() {
        super(1);
    }
}
