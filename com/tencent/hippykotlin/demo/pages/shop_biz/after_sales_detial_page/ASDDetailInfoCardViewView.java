package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ASDDetailInfoCardViewView extends ComposeView<ASDDetailInfoCardViewAttr, l> {
    public final ASDDetailInfoCardViewAttr viewAttr = new ASDDetailInfoCardViewAttr();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(SkinColor.INSTANCE.fgColor(mVar2.getPagerId()));
                        mVar2.marginTop(8.0f);
                        mVar2.padding(16.0f);
                        return Unit.INSTANCE;
                    }
                });
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ce.fontSize$default(ceVar2, 15.0f, null, 2, null).fontWeightMedium().text("\u8be6\u7ec6\u4fe1\u606f").color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId()));
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                DetailInfoCard detailInfoCard = ASDDetailInfoCardViewView.this.viewAttr.detailInfo;
                if (detailInfoCard == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("detailInfo");
                    detailInfoCard = null;
                }
                ArrayList<DetailInfoRecord> arrayList = detailInfoCard.records;
                if (arrayList != null) {
                    Iterator<DetailInfoRecord> it = arrayList.iterator();
                    while (it.hasNext()) {
                        final DetailInfoRecord next = it.next();
                        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView$body$1$3$1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView$body$1$3$1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow().justifyContentSpaceBetween().alignItemsCenter();
                                        tVar2.marginTop(16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final DetailInfoRecord detailInfoRecord = DetailInfoRecord.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView$body$1$3$1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final DetailInfoRecord detailInfoRecord2 = DetailInfoRecord.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView.body.1.3.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null).text(DetailInfoRecord.this.title).color(SkinColor.INSTANCE.subTextColor(ceVar2.getPagerId()));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final DetailInfoRecord detailInfoRecord2 = DetailInfoRecord.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView$body$1$3$1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView.body.1.3.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                tVar2.mo141height(13.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final DetailInfoRecord detailInfoRecord3 = DetailInfoRecord.this;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView.body.1.3.1.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final DetailInfoRecord detailInfoRecord4 = DetailInfoRecord.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView.body.1.3.1.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null).color(SkinColor.INSTANCE.subTextColor(ceVar2.getPagerId()));
                                                        ceVar2.text(DetailInfoRecord.this.content);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final DetailInfoRecord detailInfoRecord4 = DetailInfoRecord.this;
                                        if (detailInfoRecord4.detaiInfoType == 1) {
                                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView.body.1.3.1.3.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    TextView textView2 = textView;
                                                    textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView.body.1.3.1.3.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.marginLeft(8.0f);
                                                            ce.fontSize$default(ceVar2, 14.0f, null, 2, null).color(SkinColor.INSTANCE.blackTextColor(ceVar2.getPagerId()));
                                                            ceVar2.text("\u590d\u5236");
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final DetailInfoRecord detailInfoRecord5 = DetailInfoRecord.this;
                                                    textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView.body.1.3.1.3.3.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextEvent textEvent) {
                                                            final TextEvent textEvent2 = textEvent;
                                                            final DetailInfoRecord detailInfoRecord6 = DetailInfoRecord.this;
                                                            textEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDDetailInfoCardViewView.body.1.3.1.3.3.2.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    Utils utils = Utils.INSTANCE;
                                                                    utils.bridgeModule(TextEvent.this.getPagerId()).copyToPasteboard(detailInfoRecord6.content);
                                                                    utils.bridgeModule(TextEvent.this.getPagerId()).toast("\u5df2\u590d\u5236");
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                    }
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return this.viewAttr;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
