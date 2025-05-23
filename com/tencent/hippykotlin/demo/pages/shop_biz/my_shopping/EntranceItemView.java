package com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping;

import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class EntranceItemView extends ComposeView<EntranceItemViewAttr, l> {
    public final float defaultSize = 24.0f;
    public final float defaultMargin = 16.0f;
    public final float itemHeight = 56.0f;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        EntranceItem entranceItem = ((EntranceItemViewAttr) getAttr()).itemData;
        T t16 = entranceItem;
        if (entranceItem == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemData");
            t16 = 0;
        }
        objectRef.element = t16;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntranceItemView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final EntranceItemView entranceItemView = EntranceItemView.this;
                final Ref.ObjectRef<EntranceItem> objectRef2 = objectRef;
                w.a(viewContainer, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntranceItemView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final EntranceItemView entranceItemView2 = EntranceItemView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntranceItemView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo141height(EntranceItemView.this.itemHeight);
                                tVar2.flexDirectionRow();
                                return Unit.INSTANCE;
                            }
                        });
                        final Ref.ObjectRef<EntranceItem> objectRef3 = objectRef2;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntranceItemView.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final u uVar2 = uVar;
                                final Ref.ObjectRef<EntranceItem> objectRef4 = objectRef3;
                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntranceItemView.body.1.1.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        boolean contains$default;
                                        boolean contains$default2;
                                        boolean contains$default3;
                                        boolean contains$default4;
                                        String str = objectRef4.element.title;
                                        contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "\u6211\u7684\u8ba2\u5355", false, 2, (Object) null);
                                        if (contains$default) {
                                            EntrancePage.Companion.doReport("ds_order_entry_clk");
                                        }
                                        contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "\u6211\u7684\u4f18\u60e0\u5238", false, 2, (Object) null);
                                        if (contains$default2) {
                                            EntrancePage.Companion.doReport("ds_coupon_entry_clk");
                                        }
                                        contains$default3 = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "\u79ef\u5206\u5546\u57ce", false, 2, (Object) null);
                                        if (!contains$default3) {
                                            contains$default4 = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) "\u6781\u5149\u76f2\u76d2", false, 2, (Object) null);
                                            if (contains$default4) {
                                                EntrancePage.Companion.doReport("blindbox_entry_clk");
                                            }
                                            BridgeModule.openPage$default(IPagerIdKtxKt.getBridgeModule(uVar2), objectRef4.element.scheme, true, null, null, 28);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final EntranceItemView entranceItemView3 = EntranceItemView.this;
                        final Ref.ObjectRef<EntranceItem> objectRef4 = objectRef2;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntranceItemView.body.1.1.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final EntranceItemView entranceItemView4 = EntranceItemView.this;
                                final Ref.ObjectRef<EntranceItem> objectRef5 = objectRef4;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntranceItemView.body.1.1.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.marginLeft(EntranceItemView.this.defaultMargin);
                                        afVar2.alignSelfCenter();
                                        float f16 = EntranceItemView.this.defaultSize;
                                        afVar2.size(f16, f16);
                                        EntranceItem entranceItem2 = objectRef5.element;
                                        b.a.b(afVar2, (String) entranceItem2.iconSrc$delegate.getValue(entranceItem2, EntranceItem.$$delegatedProperties[0]), false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final EntranceItemView entranceItemView4 = EntranceItemView.this;
                        final Ref.ObjectRef<EntranceItem> objectRef5 = objectRef2;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntranceItemView.body.1.1.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final EntranceItemView entranceItemView5 = EntranceItemView.this;
                                final Ref.ObjectRef<EntranceItem> objectRef6 = objectRef5;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntranceItemView.body.1.1.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.m140flex(1.0f);
                                        ceVar2.alignSelfCenter();
                                        ceVar2.marginLeft(EntranceItemView.this.defaultMargin);
                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                        ceVar2.fontWeight400();
                                        ceVar2.color(IPagerIdKtxKt.getSkinColor(ceVar2).getPrimaryTextColor());
                                        ceVar2.fontFamily("PingFangSC");
                                        ceVar2.text(objectRef6.element.title);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final EntranceItemView entranceItemView5 = EntranceItemView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntranceItemView.body.1.1.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final EntranceItemView entranceItemView6 = EntranceItemView.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.my_shopping.EntranceItemView.body.1.1.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.alignSelfCenter();
                                        afVar2.marginRight(EntranceItemView.this.defaultMargin);
                                        afVar2.size(16.0f, 16.0f);
                                        b.a.b(afVar2, "qecommerce_skin_icon_general_arrow_right_secondary", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
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

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new EntranceItemViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
