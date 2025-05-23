package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.base.ISkinColor;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class CommonCouponItemView extends ComposeView<CommonCouponItemAttr, l> {
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0096, code lost:
    
        if (getPager().getPageData().getIsIOS() != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e2, code lost:
    
        if (getPager().getPageData().getIsIOS() != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fb, code lost:
    
        r0 = 16.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00f9, code lost:
    
        r0 = 4.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f7, code lost:
    
        if (getPager().getPageData().getIsIOS() != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ab, code lost:
    
        if (getPager().getPageData().getIsIOS() != false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00bc, code lost:
    
        r10 = 4.0f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00ba, code lost:
    
        if (getPager().getPageData().getIsIOS() != false) goto L61;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        int i3;
        float f16;
        float f17;
        float f18;
        float f19;
        h hVar;
        String str;
        h hVar2;
        CommonCouponItemModel commonCouponItemModel = ((CommonCouponItemAttr) getAttr()).commonCouponItem;
        if (commonCouponItemModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("commonCouponItem");
            commonCouponItemModel = null;
        }
        final CommonCouponItemModel commonCouponItemModel2 = commonCouponItemModel;
        int length = commonCouponItemModel2.discountStr.length();
        if (length >= 0 && length < 4) {
            i3 = 3;
        } else {
            i3 = 4 <= length && length < 6 ? 2 : 1;
        }
        int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(i3);
        if (ordinal == 0) {
            f16 = 12.0f;
        } else if (ordinal == 1) {
            f16 = 16.0f;
        } else {
            if (ordinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            f16 = 20.0f;
        }
        int ordinal2 = BoxType$EnumUnboxingSharedUtility.ordinal(i3);
        float f26 = 6.0f;
        if (ordinal2 == 0 || ordinal2 == 1) {
            f17 = 4.0f;
        } else {
            if (ordinal2 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            f17 = 6.0f;
        }
        int ordinal3 = BoxType$EnumUnboxingSharedUtility.ordinal(i3);
        if (ordinal3 == 0) {
            f18 = 18.0f;
        } else if (ordinal3 == 1) {
            f18 = 24.0f;
        } else {
            if (ordinal3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            f18 = 32.0f;
        }
        final float f27 = f18;
        int ordinal4 = BoxType$EnumUnboxingSharedUtility.ordinal(i3);
        if (ordinal4 != 0) {
            if (ordinal4 != 1) {
                if (ordinal4 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
            }
            f26 = 0.0f;
        }
        final float f28 = commonCouponItemModel2.discountThresholdRule.length() > 6 ? 10.0f : 12.0f;
        int ordinal5 = BoxType$EnumUnboxingSharedUtility.ordinal(i3);
        if (ordinal5 == 0) {
            f19 = 8.0f;
        } else if (ordinal5 != 1) {
            if (ordinal5 != 2) {
                throw new NoWhenBranchMatchedException();
            }
        }
        if (((CommonCouponItemAttr) getAttr()).supportNightMode) {
            if (commonCouponItemModel2.isEnabled) {
                hVar = IPagerIdKtxKt.getSkinColor(this).getRedTextColor();
            } else {
                hVar = IPagerIdKtxKt.getSkinColor(this).getSecondaryTextColor();
            }
        } else if (commonCouponItemModel2.isEnabled) {
            hVar = new h("qecommerce_color_text_red_brand");
        } else {
            hVar = new h("qecommerce_color_text_secondary");
        }
        final h hVar3 = hVar;
        ISkinColor skinColor = IPagerIdKtxKt.getSkinColor(this);
        if (commonCouponItemModel2.isEnabled) {
            str = "qecommerce_skin_color_tag_secondary_40";
        } else {
            str = "qecommerce_skin_color_btn_secondary_red_pressed_40";
        }
        final h hVar4 = skinColor.tokenColor(str, false);
        if (((CommonCouponItemAttr) getAttr()).supportNightMode) {
            hVar2 = IPagerIdKtxKt.getSkinColor(this).getSecondaryTextColor();
        } else {
            hVar2 = new h("qecommerce_color_text_secondary");
        }
        final h hVar5 = hVar2;
        final float f29 = f16;
        final float f36 = f17;
        final float f37 = f26;
        final float f38 = f19;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.m140flex(1.0f);
                        return Unit.INSTANCE;
                    }
                });
                final float f39 = f29;
                final float f46 = f36;
                final h hVar6 = hVar3;
                final float f47 = f27;
                final float f48 = f37;
                final CommonCouponItemModel commonCouponItemModel3 = commonCouponItemModel2;
                final float f49 = f28;
                final float f56 = f38;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionColumn();
                                tVar2.allCenter();
                                tVar2.mo153width(95.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final float f57 = f39;
                        final float f58 = f46;
                        final h hVar7 = hVar6;
                        final float f59 = f47;
                        final float f65 = f48;
                        final CommonCouponItemModel commonCouponItemModel4 = commonCouponItemModel3;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final float f66 = f57;
                                final float f67 = f58;
                                final h hVar8 = hVar7;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.2.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final float f68 = f66;
                                        final float f69 = f67;
                                        final h hVar9 = hVar8;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.2.2.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, f68, null, 2, null);
                                                ceVar2.text("\u00a5");
                                                ceVar2.marginTop(f69);
                                                ceVar2.fontFamily("Qvideo Digit");
                                                ceVar2.color(hVar9);
                                                ceVar2.fontWeight700();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final float f68 = f59;
                                final float f69 = f65;
                                final CommonCouponItemModel commonCouponItemModel5 = commonCouponItemModel4;
                                final h hVar9 = hVar7;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.2.2.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final float f75 = f68;
                                        final float f76 = f69;
                                        final CommonCouponItemModel commonCouponItemModel6 = commonCouponItemModel5;
                                        final h hVar10 = hVar9;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.2.2.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, f75, null, 2, null);
                                                ceVar2.marginTop(f76);
                                                ceVar2.fontFamily("Qvideo Digit");
                                                ceVar2.text(commonCouponItemModel6.discountStr);
                                                ceVar2.color(hVar10);
                                                ceVar2.fontWeightBold();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final float f66 = f49;
                        final CommonCouponItemModel commonCouponItemModel5 = commonCouponItemModel3;
                        final h hVar8 = hVar6;
                        final float f67 = f56;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final float f68 = f66;
                                final CommonCouponItemModel commonCouponItemModel6 = commonCouponItemModel5;
                                final h hVar9 = hVar8;
                                final float f69 = f67;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.2.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ce.fontSize$default(ceVar2, f68, null, 2, null);
                                        ceVar2.text(commonCouponItemModel6.discountThresholdRule);
                                        ceVar2.fontWeight500();
                                        ceVar2.color(hVar9);
                                        ceVar2.textAlignCenter();
                                        ceVar2.marginTop(f69);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final h hVar7 = hVar4;
                final CommonCouponItemModel commonCouponItemModel4 = commonCouponItemModel2;
                final h hVar8 = hVar3;
                final h hVar9 = hVar5;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionColumn();
                                tVar2.justifyContentCenter();
                                tVar2.overflow(true);
                                return Unit.INSTANCE;
                            }
                        });
                        final h hVar10 = h.this;
                        final CommonCouponItemModel commonCouponItemModel5 = commonCouponItemModel4;
                        final h hVar11 = hVar8;
                        final h hVar12 = hVar9;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.flexDirectionRow();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final h hVar13 = h.this;
                                final CommonCouponItemModel commonCouponItemModel6 = commonCouponItemModel5;
                                final h hVar14 = hVar11;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        final h hVar15 = h.this;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo113backgroundColor(h.this);
                                                tVar2.padding(2.0f);
                                                tVar2.borderRadius(2.0f);
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final CommonCouponItemModel commonCouponItemModel7 = commonCouponItemModel6;
                                        final h hVar16 = hVar14;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.2.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final CommonCouponItemModel commonCouponItemModel8 = CommonCouponItemModel.this;
                                                final h hVar17 = hVar16;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.2.2.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text(CommonCouponItemModel.this.couponTypeName);
                                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                        ceVar2.fontWeight500();
                                                        ceVar2.color(hVar17);
                                                        ceVar2.lines(1);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final CommonCouponItemModel commonCouponItemModel7 = commonCouponItemModel5;
                                final h hVar15 = hVar12;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.2.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final CommonCouponItemModel commonCouponItemModel8 = CommonCouponItemModel.this;
                                        final h hVar16 = hVar15;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.2.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text(CommonCouponItemModel.this.issuerName);
                                                ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                ceVar2.color(hVar16);
                                                ceVar2.marginLeft(4.0f);
                                                ceVar2.marginTop(2.0f);
                                                ceVar2.lines(1);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final CommonCouponItemModel commonCouponItemModel6 = commonCouponItemModel4;
                        final h hVar13 = hVar9;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.marginTop(8.0f);
                                        tVar2.marginBottom(8.0f);
                                        tVar2.flexDirectionColumn();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final CommonCouponItemModel commonCouponItemModel7 = CommonCouponItemModel.this;
                                final h hVar14 = hVar13;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.3.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final CommonCouponItemModel commonCouponItemModel8 = CommonCouponItemModel.this;
                                        final h hVar15 = hVar14;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.3.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text(CommonCouponItemModel.this.usableRange);
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.color(hVar15);
                                                ceVar2.lines(1);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final String str2 = CommonCouponItemModel.this.useRule;
                                if (str2 != null) {
                                    final h hVar15 = hVar13;
                                    if (str2.length() > 0) {
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView$body$1$3$3$3$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final String str3 = str2;
                                                final h hVar16 = hVar15;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView$body$1$3$3$3$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginTop(4.0f);
                                                        ceVar2.text(str3);
                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                        ceVar2.color(hVar16);
                                                        ceVar2.lines(1);
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
                        });
                        final CommonCouponItemModel commonCouponItemModel7 = commonCouponItemModel4;
                        final h hVar14 = hVar9;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                final CommonCouponItemModel commonCouponItemModel8 = CommonCouponItemModel.this;
                                final h hVar15 = hVar14;
                                cg.a(vVar3, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final CommonCouponItemModel commonCouponItemModel9 = CommonCouponItemModel.this;
                                        final h hVar16 = hVar15;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.base.CommonCouponItemView.body.1.3.4.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text(CommonCouponItemModel.this.validTime);
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.color(hVar16);
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
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new CommonCouponItemAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
