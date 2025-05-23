package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.goods_center.card.filter.GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes31.dex */
public final class QPlusTrafficSkeletonView$bodyWithView$1 extends Lambda implements Function1<ViewContainer<?, ?>, Unit> {
    public final /* synthetic */ QPlusTrafficSkeletonView $ctx;
    public final /* synthetic */ IQPlusTrafficSkeletonItemData $data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QPlusTrafficSkeletonView$bodyWithView$1(IQPlusTrafficSkeletonItemData iQPlusTrafficSkeletonItemData, QPlusTrafficSkeletonView qPlusTrafficSkeletonView) {
        super(1);
        this.$data = iQPlusTrafficSkeletonItemData;
        this.$ctx = qPlusTrafficSkeletonView;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
        ViewContainer<?, ?> viewContainer2 = viewContainer;
        int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(this.$data.getDataType$enumunboxing$());
        if (ordinal == 0) {
            QPlusTrafficSkeletonView qPlusTrafficSkeletonView = this.$ctx;
            IQPlusTrafficSkeletonItemData iQPlusTrafficSkeletonItemData = this.$data;
            Intrinsics.checkNotNull(iQPlusTrafficSkeletonItemData, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonItemData");
            final QPlusTrafficSkeletonItemData qPlusTrafficSkeletonItemData = (QPlusTrafficSkeletonItemData) iQPlusTrafficSkeletonItemData;
            qPlusTrafficSkeletonView.getClass();
            new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonView$bodyWithSingleView$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                    final QPlusTrafficSkeletonItemData qPlusTrafficSkeletonItemData2 = QPlusTrafficSkeletonItemData.this;
                    w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonView$bodyWithSingleView$1.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            final QPlusTrafficSkeletonItemData qPlusTrafficSkeletonItemData3 = QPlusTrafficSkeletonItemData.this;
                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonView.bodyWithSingleView.1.1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    QPlusTrafficSkeletonItemData qPlusTrafficSkeletonItemData4 = QPlusTrafficSkeletonItemData.this;
                                    tVar2.size(qPlusTrafficSkeletonItemData4.f114254w, qPlusTrafficSkeletonItemData4.f114253h);
                                    tVar2.borderRadius(4.0f);
                                    QPlusTrafficSkeletonItemData qPlusTrafficSkeletonItemData5 = QPlusTrafficSkeletonItemData.this;
                                    tVar2.margin(qPlusTrafficSkeletonItemData5.top, qPlusTrafficSkeletonItemData5.left, qPlusTrafficSkeletonItemData5.bottom, qPlusTrafficSkeletonItemData5.right);
                                    GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_bg_skeleton_loading_start", false, 2, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            }.invoke(viewContainer2);
        } else if (ordinal == 1) {
            final QPlusTrafficSkeletonView qPlusTrafficSkeletonView2 = this.$ctx;
            IQPlusTrafficSkeletonItemData iQPlusTrafficSkeletonItemData2 = this.$data;
            Intrinsics.checkNotNull(iQPlusTrafficSkeletonItemData2, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonGroupItemData");
            final QPlusTrafficSkeletonGroupItemData qPlusTrafficSkeletonGroupItemData = (QPlusTrafficSkeletonGroupItemData) iQPlusTrafficSkeletonItemData2;
            qPlusTrafficSkeletonView2.getClass();
            new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonView$bodyWithRowView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                    final QPlusTrafficSkeletonGroupItemData qPlusTrafficSkeletonGroupItemData2 = QPlusTrafficSkeletonGroupItemData.this;
                    final QPlusTrafficSkeletonView qPlusTrafficSkeletonView3 = qPlusTrafficSkeletonView2;
                    w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonView$bodyWithRowView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            final QPlusTrafficSkeletonGroupItemData qPlusTrafficSkeletonGroupItemData3 = QPlusTrafficSkeletonGroupItemData.this;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonView.bodyWithRowView.1.1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    float f16 = QPlusTrafficSkeletonGroupItemData.this.f114250w;
                                    if (f16 >= 0.0f) {
                                        tVar2.mo153width(f16);
                                    }
                                    float f17 = QPlusTrafficSkeletonGroupItemData.this.f114249h;
                                    if (f17 >= 0.0f) {
                                        tVar2.mo141height(f17);
                                    }
                                    tVar2.marginLeft(QPlusTrafficSkeletonGroupItemData.this.left).marginTop(QPlusTrafficSkeletonGroupItemData.this.top);
                                    tVar2.flexDirection(QPlusTrafficSkeletonGroupItemData.this.flexDirection);
                                    tVar2.justifyContent(QPlusTrafficSkeletonGroupItemData.this.justifyContent);
                                    GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_bg_default", false, 2, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            ArrayList<IQPlusTrafficSkeletonItemData> arrayList = QPlusTrafficSkeletonGroupItemData.this.itemsData;
                            QPlusTrafficSkeletonView qPlusTrafficSkeletonView4 = qPlusTrafficSkeletonView3;
                            Iterator<T> it = arrayList.iterator();
                            while (it.hasNext()) {
                                ((QPlusTrafficSkeletonView$bodyWithView$1) QPlusTrafficSkeletonView.access$bodyWithView(qPlusTrafficSkeletonView4, qPlusTrafficSkeletonView4, (IQPlusTrafficSkeletonItemData) it.next())).invoke(vVar2);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            }.invoke(viewContainer2);
        } else if (ordinal == 2) {
            final QPlusTrafficSkeletonView qPlusTrafficSkeletonView3 = this.$ctx;
            IQPlusTrafficSkeletonItemData iQPlusTrafficSkeletonItemData3 = this.$data;
            Intrinsics.checkNotNull(iQPlusTrafficSkeletonItemData3, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonGroupRepeatItemData");
            final QPlusTrafficSkeletonGroupRepeatItemData qPlusTrafficSkeletonGroupRepeatItemData = (QPlusTrafficSkeletonGroupRepeatItemData) iQPlusTrafficSkeletonItemData3;
            qPlusTrafficSkeletonView3.getClass();
            new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonView$bodyWithRowRepeatView$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                    final QPlusTrafficSkeletonGroupRepeatItemData qPlusTrafficSkeletonGroupRepeatItemData2 = QPlusTrafficSkeletonGroupRepeatItemData.this;
                    final QPlusTrafficSkeletonView qPlusTrafficSkeletonView4 = qPlusTrafficSkeletonView3;
                    w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonView$bodyWithRowRepeatView$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            final QPlusTrafficSkeletonGroupRepeatItemData qPlusTrafficSkeletonGroupRepeatItemData3 = QPlusTrafficSkeletonGroupRepeatItemData.this;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qplus_traffic.home.component.skeleton.QPlusTrafficSkeletonView.bodyWithRowRepeatView.1.1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    float f16 = QPlusTrafficSkeletonGroupRepeatItemData.this.f114252w;
                                    if (f16 >= 0.0f) {
                                        tVar2.mo153width(f16);
                                    }
                                    float f17 = QPlusTrafficSkeletonGroupRepeatItemData.this.f114251h;
                                    if (f17 >= 0.0f) {
                                        tVar2.mo141height(f17);
                                    }
                                    tVar2.marginLeft(QPlusTrafficSkeletonGroupRepeatItemData.this.left).marginTop(QPlusTrafficSkeletonGroupRepeatItemData.this.top);
                                    tVar2.flexDirection(QPlusTrafficSkeletonGroupRepeatItemData.this.flexDirection);
                                    tVar2.justifyContent(QPlusTrafficSkeletonGroupRepeatItemData.this.justifyContent);
                                    GoodsCenterRangeFilterView$body$1$1$3$2$1$$ExternalSyntheticOutline0.m(tVar2, "qecommerce_skin_color_bg_default", false, 2, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            int i3 = QPlusTrafficSkeletonGroupRepeatItemData.this.repeatCount;
                            for (int i16 = 0; i16 < i3; i16++) {
                                QPlusTrafficSkeletonView qPlusTrafficSkeletonView5 = qPlusTrafficSkeletonView4;
                                ((QPlusTrafficSkeletonView$bodyWithView$1) QPlusTrafficSkeletonView.access$bodyWithView(qPlusTrafficSkeletonView5, qPlusTrafficSkeletonView5, QPlusTrafficSkeletonGroupRepeatItemData.this.itemData)).invoke(vVar2);
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    return Unit.INSTANCE;
                }
            }.invoke(viewContainer2);
        }
        return Unit.INSTANCE;
    }
}
