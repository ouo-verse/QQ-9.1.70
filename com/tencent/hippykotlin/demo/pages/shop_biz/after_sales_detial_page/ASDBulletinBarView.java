package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionEvent;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.f;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ModalView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.bb;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ASDBulletinBarView extends ComposeView<ASDBulletinBarAttr, l> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ASDBulletinBarView.class, "showToastModal", "getShowToastModal()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ASDBulletinBarView.class, "toastAnimationAppear", "getToastAnimationAppear()Z", 0)};
    public final ReadWriteProperty showToastModal$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty toastAnimationAppear$delegate = c.a(Boolean.TRUE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ASDBulletinBarAttr access$getAttr(ASDBulletinBarView aSDBulletinBarView) {
        return (ASDBulletinBarAttr) aSDBulletinBarView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        AttrExtKt.backgroundColorToken(mVar2, "qecommerce_skin_color_bg_default");
                        mVar2.paddingTop(12.0f);
                        return Unit.INSTANCE;
                    }
                });
                final ASDBulletinBarView aSDBulletinBarView = ASDBulletinBarView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final ASDBulletinBarView aSDBulletinBarView2 = ASDBulletinBarView.this;
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ClickParams clickParams) {
                                ASDBulletinBarView aSDBulletinBarView3 = ASDBulletinBarView.this;
                                aSDBulletinBarView3.showToastModal$delegate.setValue(aSDBulletinBarView3, ASDBulletinBarView.$$delegatedProperties[0], Boolean.TRUE);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ASDBulletinBarView aSDBulletinBarView2 = ASDBulletinBarView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.mo141height(28.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(16.0f);
                                        ceVar2.marginRight(8.0f);
                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_secondary");
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.text("\u516c\u544a");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ASDBulletinBarView aSDBulletinBarView3 = ASDBulletinBarView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.m140flex(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ASDBulletinBarView aSDBulletinBarView4 = ASDBulletinBarView.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.3.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final ASDBulletinBarView aSDBulletinBarView5 = ASDBulletinBarView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.3.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                                Bulletin bulletin = null;
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.lines(1);
                                                Bulletin bulletin2 = ASDBulletinBarView.access$getAttr(ASDBulletinBarView.this).bulletin;
                                                if (bulletin2 != null) {
                                                    bulletin = bulletin2;
                                                } else {
                                                    Intrinsics.throwUninitializedPropertyAccessException("bulletin");
                                                }
                                                ceVar2.text(bulletin.txt);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.3.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.3.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.marginLeft(10.0f);
                                        afVar2.marginRight(16.0f);
                                        afVar2.size(16.0f, 16.0f);
                                        b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAADEAAAAxBAMAAACBslwvAAAAG1BMVEUAAACZmZmZmZmVlZWXl5eXl5eXl5efn5+ZmZmlM1WdAAAACHRSTlMAgO8wQGEgECPwZG4AAABBSURBVDjLYxjiwAGXBGMjLhmJDgHsEmwaHbg0GXXg0sQ8qokCTawdHS0E9WDaM6qFFC3sCC2E8wIi/+DJc8MBAAAlYCfZ1SCbIAAAAABJRU5ErkJggg==", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final ASDBulletinBarView aSDBulletinBarView3 = ASDBulletinBarView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        ASDBulletinBarView aSDBulletinBarView4 = ASDBulletinBarView.this;
                        return Boolean.valueOf(((Boolean) aSDBulletinBarView4.showToastModal$delegate.getValue(aSDBulletinBarView4, ASDBulletinBarView.$$delegatedProperties[0])).booleanValue());
                    }
                };
                final ASDBulletinBarView aSDBulletinBarView4 = ASDBulletinBarView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final ASDBulletinBarView aSDBulletinBarView5 = ASDBulletinBarView.this;
                        bb.b(conditionView, false, new Function1<ModalView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ModalView modalView) {
                                ModalView modalView2 = modalView;
                                modalView2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(m mVar) {
                                        mVar.justifyContentFlexEnd();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ASDBulletinBarView aSDBulletinBarView6 = ASDBulletinBarView.this;
                                ECTransitionViewKt.TransitionFadeInOutView(modalView2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECTransitionView eCTransitionView) {
                                        ECTransitionView eCTransitionView2 = eCTransitionView;
                                        final ASDBulletinBarView aSDBulletinBarView7 = ASDBulletinBarView.this;
                                        eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                                ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                                eCTransitionAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                                eCTransitionAttr2.mo113backgroundColor(new h(0, 0, 0, 0.5f));
                                                ASDBulletinBarView aSDBulletinBarView8 = ASDBulletinBarView.this;
                                                eCTransitionAttr2.setTransitionAppear(((Boolean) aSDBulletinBarView8.toastAnimationAppear$delegate.getValue(aSDBulletinBarView8, ASDBulletinBarView.$$delegatedProperties[1])).booleanValue());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ASDBulletinBarView aSDBulletinBarView8 = ASDBulletinBarView.this;
                                        eCTransitionView2.event(new Function1<ECTransitionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECTransitionEvent eCTransitionEvent) {
                                                ECTransitionEvent eCTransitionEvent2 = eCTransitionEvent;
                                                final ASDBulletinBarView aSDBulletinBarView9 = ASDBulletinBarView.this;
                                                eCTransitionEvent2.transitionFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Boolean bool) {
                                                        if (!bool.booleanValue()) {
                                                            ASDBulletinBarView.this.setToastAnimationAppear(true);
                                                            ASDBulletinBarView aSDBulletinBarView10 = ASDBulletinBarView.this;
                                                            aSDBulletinBarView10.showToastModal$delegate.setValue(aSDBulletinBarView10, ASDBulletinBarView.$$delegatedProperties[0], Boolean.FALSE);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ASDBulletinBarView aSDBulletinBarView10 = ASDBulletinBarView.this;
                                                eCTransitionEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.2.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        ASDBulletinBarView.this.setToastAnimationAppear(false);
                                                        ASDReportModel aSDReportModel = ((ASDBulletinBarAttr) ASDBulletinBarView.this.getViewAttr()).reportModel;
                                                        if (aSDReportModel != null) {
                                                            e eVar = new e();
                                                            eVar.t("notice_scene", 5);
                                                            aSDReportModel.reportDT("eport_notice_cli", eVar);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ASDBulletinBarView aSDBulletinBarView7 = ASDBulletinBarView.this;
                                ECTransitionViewKt.TransitionFromBottomView(modalView2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECTransitionView eCTransitionView) {
                                        ECTransitionView eCTransitionView2 = eCTransitionView;
                                        final ASDBulletinBarView aSDBulletinBarView8 = ASDBulletinBarView.this;
                                        eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                                ASDBulletinBarView aSDBulletinBarView9 = ASDBulletinBarView.this;
                                                eCTransitionAttr.setTransitionAppear(((Boolean) aSDBulletinBarView9.toastAnimationAppear$delegate.getValue(aSDBulletinBarView9, ASDBulletinBarView.$$delegatedProperties[1])).booleanValue());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final ASDBulletinBarView aSDBulletinBarView9 = ASDBulletinBarView.this;
                                        w.a(eCTransitionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_bg_default");
                                                        tVar2.m137borderRadius(new f(5.0f, 5.0f, 0.0f, 0.0f));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ASDBulletinBarView aSDBulletinBarView10 = ASDBulletinBarView.this;
                                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        v vVar4 = vVar3;
                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.mo141height(56.0f);
                                                                tVar2.flexDirectionRow();
                                                                tVar2.alignItemsCenter();
                                                                tVar2.justifyContentCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.2.2
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.2.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                        ceVar2.fontWeightMedium();
                                                                        AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                                                        ceVar2.text("\u516c\u544a");
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final ASDBulletinBarView aSDBulletinBarView11 = ASDBulletinBarView.this;
                                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.2.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar5) {
                                                                v vVar6 = vVar5;
                                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.2.3.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 2, null);
                                                                        tVar2.mo153width(60.0f);
                                                                        tVar2.alignItemsCenter();
                                                                        tVar2.justifyContentCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final ASDBulletinBarView aSDBulletinBarView12 = ASDBulletinBarView.this;
                                                                vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.2.3.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(u uVar) {
                                                                        final ASDBulletinBarView aSDBulletinBarView13 = ASDBulletinBarView.this;
                                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.2.3.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                ASDBulletinBarView.this.setToastAnimationAppear(false);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.2.3.3
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ImageView imageView) {
                                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.2.3.3.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(af afVar) {
                                                                                af afVar2 = afVar;
                                                                                afVar2.size(20.0f, 20.0f);
                                                                                b.a.b(afVar2, "qecommerce_skin_icon_nav_close", false, 2, null);
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
                                                final ASDBulletinBarView aSDBulletinBarView11 = ASDBulletinBarView.this;
                                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final ASDBulletinBarView aSDBulletinBarView12 = ASDBulletinBarView.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                Bulletin bulletin = null;
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                AttrExtKt.colorToken(ceVar2, "qecommerce_skin_color_text_primary");
                                                                Bulletin bulletin2 = ASDBulletinBarView.access$getAttr(ASDBulletinBarView.this).bulletin;
                                                                if (bulletin2 != null) {
                                                                    bulletin = bulletin2;
                                                                } else {
                                                                    Intrinsics.throwUninitializedPropertyAccessException("bulletin");
                                                                }
                                                                ceVar2.text(bulletin.txt);
                                                                ceVar2.margin(0.0f, 16.0f, 32.0f, 16.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ASDBulletinBarView aSDBulletinBarView12 = ASDBulletinBarView.this;
                                                ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.4
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        return Boolean.valueOf(ASDBulletinBarView.this.getPagerData().getIsIOS());
                                                    }
                                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.5
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView2) {
                                                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.5.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar3) {
                                                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page.ASDBulletinBarView.body.1.5.1.3.2.5.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        tVar.mo141height(30.0f);
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
                                });
                                return Unit.INSTANCE;
                            }
                        }, 1, null);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new ASDBulletinBarAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    public final void setToastAnimationAppear(boolean z16) {
        this.toastAnimationAppear$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        ASDReportModel aSDReportModel = ((ASDBulletinBarAttr) getViewAttr()).reportModel;
        if (aSDReportModel != null) {
            e eVar = new e();
            eVar.t("notice_scene", 5);
            aSDReportModel.reportDT("report_notice_exp", eVar);
        }
    }
}
