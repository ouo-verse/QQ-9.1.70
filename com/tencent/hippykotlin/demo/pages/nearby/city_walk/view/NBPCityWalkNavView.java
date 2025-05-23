package com.tencent.hippykotlin.demo.pages.nearby.city_walk.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProSafeTip;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.repository.GetPostStatusRequest;
import com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model.NBPCityWalkViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.compose.c;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qzone.util.WnsError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import n25.i;
import n25.j;
import n25.k;
import n25.l;
import q25.f;
import q25.g;
import v25.p;

/* loaded from: classes31.dex */
public final class NBPCityWalkNavView extends ComposeView<NBPCityWalkNavAttr, NNBPCityWalkNavEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPCityWalkNavAttr access$getAttr(NBPCityWalkNavView nBPCityWalkNavView) {
        return (NBPCityWalkNavAttr) nBPCityWalkNavView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPCityWalkNavView nBPCityWalkNavView = NBPCityWalkNavView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        float m3 = mVar2.getPagerData().m();
                        mVar2.getPagerData().getIsIOS();
                        mVar2.size(m3, 44.0f);
                        mVar2.justifyContentSpaceBetween();
                        mVar2.alignItemsCenter();
                        mVar2.marginBottom(16.0f);
                        int ordinal = NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getFrom().ordinal();
                        if (ordinal == 0) {
                            mVar2.marginTop(mVar2.getPagerData().getStatusBarHeight());
                        } else if (ordinal == 1) {
                            Attr.absolutePosition$default(mVar2, mVar2.getPagerData().getStatusBarHeight(), 0.0f, 0.0f, 0.0f, 4, null);
                        }
                        return Unit.INSTANCE;
                    }
                });
                final NBPCityWalkNavView nBPCityWalkNavView2 = NBPCityWalkNavView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.marginLeft(16.0f);
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPCityWalkNavView nBPCityWalkNavView3 = NBPCityWalkNavView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                ImageView imageView2 = imageView;
                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.mo153width(28.0f);
                                        afVar2.mo141height(28.0f);
                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_qkbGb7PMnGy.png", false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPCityWalkNavView nBPCityWalkNavView4 = NBPCityWalkNavView.this;
                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageEvent imageEvent) {
                                        final NBPCityWalkNavView nBPCityWalkNavView5 = NBPCityWalkNavView.this;
                                        imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.2.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                int ordinal = NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getFrom().ordinal();
                                                if (ordinal == 0) {
                                                    NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getViewModel().setDisplay(false);
                                                } else if (ordinal == 1) {
                                                    NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getViewModel().setPreview(false);
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
                        final NBPCityWalkNavView nBPCityWalkNavView4 = NBPCityWalkNavView.this;
                        ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.2.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getFrom() == CityWalkNavFrom.PREVIEW);
                            }
                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.2.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.2.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.2.4.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.color(new h(0L, 1.0f));
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                ceVar2.textAlignCenter();
                                                ceVar2.marginLeft(8.0f);
                                                ceVar2.text("\u9884\u89c8\u8def\u7ebf");
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
                final NBPCityWalkNavView nBPCityWalkNavView3 = NBPCityWalkNavView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getFrom();
                    }
                };
                final NBPCityWalkNavView nBPCityWalkNavView4 = NBPCityWalkNavView.this;
                BindDirectivesViewKt.a(viewContainer2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                        int ordinal = NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getFrom().ordinal();
                        if (ordinal == 0) {
                            final NBPCityWalkNavView nBPCityWalkNavView5 = NBPCityWalkNavView.this;
                            c.a(bindDirectivesView2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.4.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ButtonView buttonView) {
                                    ButtonView buttonView2 = buttonView;
                                    final NBPCityWalkNavView nBPCityWalkNavView6 = NBPCityWalkNavView.this;
                                    buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.4.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(a aVar) {
                                            final a aVar2 = aVar;
                                            aVar2.size(90.0f, 34.0f);
                                            aVar2.marginLeft(8.0f);
                                            aVar2.marginRight(16.0f);
                                            aVar2.borderRadius(4.0f);
                                            aVar2.mo113backgroundColor(new h(4278229503L));
                                            aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.4.1.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.value("\u4e0b\u4e00\u6b65");
                                                    ceVar2.color(h.INSTANCE.m());
                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                    ceVar2.fontWeight500();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPCityWalkNavView nBPCityWalkNavView7 = NBPCityWalkNavView.this;
                                            Function0<? extends Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.4.1.1.2
                                                {
                                                    super(0);
                                                }

                                                @Override // kotlin.jvm.functions.Function0
                                                public final Object invoke() {
                                                    return NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getViewModel().getChooseList();
                                                }
                                            };
                                            final NBPCityWalkNavView nBPCityWalkNavView8 = NBPCityWalkNavView.this;
                                            aVar2.bindValueChange(function02, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.4.1.1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Object obj) {
                                                    aVar2.m147opacity(NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getViewModel().getChooseList().size() >= 2 ? 1.0f : 0.5f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPCityWalkNavView nBPCityWalkNavView7 = NBPCityWalkNavView.this;
                                    buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.4.1.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                            final NBPCityWalkNavView nBPCityWalkNavView8 = NBPCityWalkNavView.this;
                                            bVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.4.1.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    if (NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getViewModel().getChooseList().size() >= 2) {
                                                        com.tencent.kuikly.core.reactive.collection.c<l> previewList = NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getViewModel().getPreviewList();
                                                        NBPCityWalkNavView nBPCityWalkNavView9 = NBPCityWalkNavView.this;
                                                        previewList.clear();
                                                        previewList.addAll(NBPCityWalkNavView.access$getAttr(nBPCityWalkNavView9).getViewModel().getChooseList());
                                                        NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getViewModel().setPreview(true);
                                                    } else {
                                                        Utils.INSTANCE.currentBridgeModule().toast("\u8bf7\u9009\u62e9\u81f3\u5c112\u6761\u8db3\u8ff9\u54e6");
                                                    }
                                                    NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getViewModel().getClass();
                                                    e eVar = new e();
                                                    eVar.v("dt_pgid", "pg_nearby_citywalk_choose_content");
                                                    NBPCityWalkNavView nBPCityWalkNavView10 = NBPCityWalkNavView.this;
                                                    eVar.v("dt_eid", "em_nearby_next_btn");
                                                    eVar.t("check_num", NBPCityWalkNavView.access$getAttr(nBPCityWalkNavView10).getViewModel().getChooseList().size());
                                                    eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", eVar);
                                                    KLog.INSTANCE.i("NNBPCityWalkNavView", "click: \u4e0b\u4e00\u6b65");
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                        } else if (ordinal == 1) {
                            final NBPCityWalkNavView nBPCityWalkNavView6 = NBPCityWalkNavView.this;
                            c.a(bindDirectivesView2, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.4.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ButtonView buttonView) {
                                    ButtonView buttonView2 = buttonView;
                                    final NBPCityWalkNavView nBPCityWalkNavView7 = NBPCityWalkNavView.this;
                                    buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.4.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(a aVar) {
                                            a aVar2 = aVar;
                                            aVar2.size(90.0f, 34.0f);
                                            aVar2.marginLeft(8.0f);
                                            aVar2.marginRight(16.0f);
                                            aVar2.borderRadius(4.0f);
                                            aVar2.mo113backgroundColor(new h(4278229503L));
                                            aVar2.m154zIndex(99);
                                            final NBPCityWalkNavView nBPCityWalkNavView8 = NBPCityWalkNavView.this;
                                            aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.4.2.1.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.value("\u7acb\u5373\u53d1\u5e03");
                                                    ceVar2.color(h.INSTANCE.m());
                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                    ceVar2.fontWeight500();
                                                    ceVar2.m152visibility(!NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getViewModel().isPublishing());
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPCityWalkNavView nBPCityWalkNavView9 = NBPCityWalkNavView.this;
                                            aVar2.m(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.4.2.1.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    afVar2.positionAbsolute();
                                                    afVar2.m142left(35.5f);
                                                    afVar2.m150top(7.5f);
                                                    afVar2.size(19.0f, 19.0f);
                                                    b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_vcgIvkNdBPJ.png", false, 2, null);
                                                    afVar2.m152visibility(NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getViewModel().isPublishing());
                                                    if (NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getViewModel().isPublishing()) {
                                                        afVar2.transform(new com.tencent.kuikly.core.base.t(3600000.0f, 0.0f, 0.0f, 6, null));
                                                    } else {
                                                        afVar2.transform(new com.tencent.kuikly.core.base.t(0.0f, 0.0f, 0.0f, 6, null));
                                                    }
                                                    afVar2.animate(b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 10000.0f, null, 2, null), Boolean.valueOf(NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getViewModel().isPublishing()));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NBPCityWalkNavView nBPCityWalkNavView8 = NBPCityWalkNavView.this;
                                    buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.4.2.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                            final NBPCityWalkNavView nBPCityWalkNavView9 = NBPCityWalkNavView.this;
                                            bVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view.NBPCityWalkNavView.body.1.4.2.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ClickParams clickParams) {
                                                    Object firstOrNull;
                                                    CharSequence trim;
                                                    boolean isBlank;
                                                    final NBPCityWalkViewModel viewModel = NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getViewModel();
                                                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) viewModel.getPreviewList());
                                                    l lVar = (l) firstOrNull;
                                                    if (lVar != null) {
                                                        List<j> list = lVar.f418097m;
                                                        ArrayList arrayList = new ArrayList();
                                                        Iterator<T> it = list.iterator();
                                                        while (it.hasNext()) {
                                                            n35.w wVar = ((j) it.next()).f418083d;
                                                            if (wVar != null) {
                                                                arrayList.add(wVar);
                                                            }
                                                        }
                                                        j jVar = lVar.F;
                                                        n35.w wVar2 = jVar != null ? jVar.f418083d : null;
                                                        if (!viewModel.isPublishing()) {
                                                            viewModel.setPublishing(true);
                                                            KLog.INSTANCE.i("NBPCityWalkViewModel", "publish city walk start");
                                                            g gVar = lVar.f418094f;
                                                            int i3 = gVar != null ? gVar.f428257d : 0;
                                                            int i16 = gVar != null ? gVar.f428258e : 0;
                                                            f fVar = lVar.f418095h;
                                                            int i17 = fVar != null ? fVar.f428251d : 0;
                                                            trim = StringsKt__StringsKt.trim((CharSequence) viewModel.content);
                                                            String obj = trim.toString();
                                                            isBlank = StringsKt__StringsJVMKt.isBlank(obj);
                                                            if (isBlank) {
                                                                obj = OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(new StringBuilder(), UserDataManager.INSTANCE.getUserSelfInfo().nickName, "\u7684\u4e00\u6761\u8db3\u8ff9\u8def\u7ebf");
                                                            }
                                                            k kVar = lVar.C;
                                                            Intrinsics.checkNotNull(kVar);
                                                            List<n25.m> list2 = lVar.J;
                                                            n25.b makeCityWalkInfo = viewModel.makeCityWalkInfo();
                                                            final Function1<s25.f, Unit> function1 = new Function1<s25.f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model.NBPCityWalkViewModel$publish$2
                                                                {
                                                                    super(1);
                                                                }

                                                                /* JADX WARN: Removed duplicated region for block: B:29:0x006d  */
                                                                /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
                                                                /* JADX WARN: Removed duplicated region for block: B:56:0x015e  */
                                                                @Override // kotlin.jvm.functions.Function1
                                                                /*
                                                                    Code decompiled incorrectly, please refer to instructions dump.
                                                                */
                                                                public final Unit invoke(s25.f fVar2) {
                                                                    boolean z16;
                                                                    m25.f fVar3;
                                                                    String decodeToString;
                                                                    ArrayList arrayListOf;
                                                                    i iVar;
                                                                    i iVar2;
                                                                    String str;
                                                                    l lVar2;
                                                                    n25.b bVar2;
                                                                    List<n25.a> list3;
                                                                    l lVar3;
                                                                    s25.f fVar4 = fVar2;
                                                                    KLog kLog = KLog.INSTANCE;
                                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("publish city walk response: ");
                                                                    m3.append((fVar4 == null || (lVar3 = fVar4.f433139d) == null) ? null : Integer.valueOf(lVar3.L));
                                                                    m3.append(", ");
                                                                    NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, (fVar4 == null || (lVar2 = fVar4.f433139d) == null || (bVar2 = lVar2.M) == null || (list3 = bVar2.f418049d) == null) ? null : Integer.valueOf(list3.size()), kLog, "NBPCityWalkViewModel");
                                                                    NBPCityWalkViewModel.this.setPublishing(false);
                                                                    l lVar4 = fVar4 != null ? fVar4.f433139d : null;
                                                                    if (lVar4 != null) {
                                                                        m25.f fVar5 = fVar4.f433141f;
                                                                        if (fVar5 != null && (str = fVar5.f416063e) != null) {
                                                                            if (str.length() > 0) {
                                                                                z16 = true;
                                                                                if (z16) {
                                                                                    BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                                                                                    m25.f fVar6 = fVar4.f433141f;
                                                                                    Intrinsics.checkNotNull(fVar6);
                                                                                    currentBridgeModule.qToast(fVar6.f416063e, QToastMode.Success);
                                                                                }
                                                                                fVar3 = fVar4.f433141f;
                                                                                if (!(fVar3 == null && fVar3.f416062d == 0)) {
                                                                                    NBPCityWalkViewModel nBPCityWalkViewModel = NBPCityWalkViewModel.this;
                                                                                    nBPCityWalkViewModel.getClass();
                                                                                    com.tencent.kuikly.core.module.k kVar2 = (com.tencent.kuikly.core.module.k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
                                                                                    e eVar = new e();
                                                                                    eVar.v("source", nBPCityWalkViewModel.source);
                                                                                    decodeToString = StringsKt__StringsJVMKt.decodeToString(d45.a.b(c45.i.d(lVar4)));
                                                                                    eVar.v("statusFeed", decodeToString);
                                                                                    Unit unit = Unit.INSTANCE;
                                                                                    com.tencent.kuikly.core.module.k.d(kVar2, "onPublishFeedFinish", eVar, false, 4, null);
                                                                                    new QQNearbyModule().asyncToNativeMethod("notifyFeedRefresh", new Object[]{c45.i.d(lVar4)}, (Function1<Object, Unit>) null);
                                                                                    NBPCityWalkViewModel nBPCityWalkViewModel2 = NBPCityWalkViewModel.this;
                                                                                    if (Intrinsics.areEqual(nBPCityWalkViewModel2.source, "0")) {
                                                                                        k kVar3 = lVar4.C;
                                                                                        double d16 = 0.0d;
                                                                                        double d17 = (kVar3 == null || (iVar2 = kVar3.C) == null) ? 0.0d : iVar2.f418079d / 1000000;
                                                                                        if (kVar3 != null && (iVar = kVar3.C) != null) {
                                                                                            d16 = iVar.f418080e / 1000000;
                                                                                        }
                                                                                        QQNearbyModule.Companion.scrollToPositionOnMap$default(d17, d16);
                                                                                        Function0<Unit> function02 = nBPCityWalkViewModel2.jumpFeedDetailPageCb;
                                                                                        if (function02 != null) {
                                                                                            function02.invoke();
                                                                                        }
                                                                                        NBPUserSelfInfo userSelfInfo = UserDataManager.INSTANCE.getUserSelfInfo();
                                                                                        long j3 = userSelfInfo.tid;
                                                                                        String str2 = userSelfInfo.avatarUrl;
                                                                                        String str3 = userSelfInfo.nickName;
                                                                                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new r25.b(1001, new r25.c(userSelfInfo.avatarDressBorderUrl, 23), 2));
                                                                                        NBPJumpUtil.jumpSquareFeedList$default(new p(j3, null, str3, str2, arrayListOf, WnsError.WNS_CODE_LOGIN_A2_EXPIRED), lVar4, null, "2", true, null, null, null, 224);
                                                                                    } else {
                                                                                        kLog.i("NBPCityWalk", "did closePage");
                                                                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                                                                    }
                                                                                } else {
                                                                                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("publish city walk failed, rsp.response.msg: ");
                                                                                    m25.f fVar7 = fVar4.f433141f;
                                                                                    m16.append(fVar7 != null ? fVar7.f416063e : null);
                                                                                    kLog.e("NBPCityWalkViewModel", m16.toString());
                                                                                }
                                                                            }
                                                                        }
                                                                        z16 = false;
                                                                        if (z16) {
                                                                        }
                                                                        fVar3 = fVar4.f433141f;
                                                                        if (!(fVar3 == null && fVar3.f416062d == 0)) {
                                                                        }
                                                                    } else {
                                                                        kLog.e("NBPCityWalkViewModel", "requestPublishCityWalk failed, statusFeed is null");
                                                                    }
                                                                    NBPCityWalkViewModel.this.getClass();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.view_model.NBPCityWalkViewModel$publish$3
                                                                {
                                                                    super(2);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function2
                                                                public final Unit invoke(Integer num, String str) {
                                                                    String str2;
                                                                    int intValue = num.intValue();
                                                                    String str3 = str;
                                                                    boolean z16 = false;
                                                                    NBPCityWalkViewModel.this.setPublishing(false);
                                                                    NearbyProSafeTip nearbyProSafeTip = NearbyProSafeTip.INSTANCE;
                                                                    if (NearbyProSafeTip.PUNISHED_ERROR_CODES.contains(Integer.valueOf(intValue))) {
                                                                        nearbyProSafeTip.dangerTip(str3);
                                                                        z16 = true;
                                                                    }
                                                                    if (!z16) {
                                                                        if (intValue == 10003) {
                                                                            str2 = str3;
                                                                        } else if (intValue != 15001) {
                                                                            str2 = "\u670d\u52a1\u5668\u7e41\u5fd9\uff0c\u53d1\u5e03\u5931\u8d25!";
                                                                        } else {
                                                                            str2 = "\u8be5\u529f\u80fd\u7ef4\u62a4\u4e2d";
                                                                        }
                                                                        Utils.INSTANCE.currentBridgeModule().qToast(str2, QToastMode.Warning);
                                                                    }
                                                                    KLog.INSTANCE.e("NBPCityWalkViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("requestPublishFeed failed, errorCode: ", intValue, ", errorMsg: ", str3));
                                                                    NBPCityWalkViewModel.this.getClass();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            GetPostStatusRequest getPostStatusRequest = new GetPostStatusRequest(i3, i16, i17, obj, kVar, arrayList, wVar2, list2, makeCityWalkInfo);
                                                            Function1<PbResponse<s25.f>, Unit> function12 = new Function1<PbResponse<s25.f>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.city_walk.repository.NBPCityWalkRepository$requestPublishFeed$1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(PbResponse<s25.f> pbResponse) {
                                                                    PbResponse<s25.f> pbResponse2 = pbResponse;
                                                                    if (pbResponse2.success) {
                                                                        function1.invoke(pbResponse2.rsp);
                                                                    } else {
                                                                        function2.invoke(Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.feed_svr.StatusWrite.SsoPostStatus");
                                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                            QQKuiklyPlatformApi.Companion.sendPbRequest$default(getPostStatusRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function12), 6);
                                                        }
                                                    }
                                                    e jsonWithPreviewPgId = NBPCityWalkNavView.access$getAttr(NBPCityWalkNavView.this).getViewModel().jsonWithPreviewPgId();
                                                    jsonWithPreviewPgId.v("dt_eid", "em_nearby_publish_btn");
                                                    jsonWithPreviewPgId.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                    Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithPreviewPgId);
                                                    KLog.INSTANCE.i("NNBPCityWalkNavView", "click: \u53d1\u5e03");
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPCityWalkNavAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NNBPCityWalkNavEvent();
    }
}
