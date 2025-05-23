package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.tts.view.popDownMenuView.PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.CommonProxyService;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPTipOffReportRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerDeleteFeedRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.views.ActionSheetAttr;
import com.tencent.kuikly.core.views.ActionSheetView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.d;
import com.tencent.kuikly.core.views.e;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import s25.j;

/* loaded from: classes31.dex */
public final class NBPFeedActionSheetView extends ComposeView<NBPFeedActionSheetViewAttr, NBPFeedActionSheetViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedActionSheetView.class, "showActionSheet", "getShowActionSheet()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPFeedActionSheetView.class, "showDeleteFeedAlert", "getShowDeleteFeedAlert()Z", 0)};
    public final ReadWriteProperty showActionSheet$delegate = c.a(Boolean.TRUE);
    public final ReadWriteProperty showDeleteFeedAlert$delegate = c.a(Boolean.FALSE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPFeedActionSheetViewAttr access$getAttr(NBPFeedActionSheetView nBPFeedActionSheetView) {
        return (NBPFeedActionSheetViewAttr) nBPFeedActionSheetView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPFeedActionSheetViewEvent access$getEvent(NBPFeedActionSheetView nBPFeedActionSheetView) {
        return (NBPFeedActionSheetViewEvent) nBPFeedActionSheetView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NBPFeedActionSheetView nBPFeedActionSheetView = NBPFeedActionSheetView.this;
                e.a(viewContainer, new Function1<ActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ActionSheetView actionSheetView) {
                        ActionSheetView actionSheetView2 = actionSheetView;
                        final NBPFeedActionSheetView nBPFeedActionSheetView2 = NBPFeedActionSheetView.this;
                        actionSheetView2.attr(new Function1<ActionSheetAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ActionSheetAttr actionSheetAttr) {
                                ActionSheetAttr actionSheetAttr2 = actionSheetAttr;
                                NBPFeedActionSheetView nBPFeedActionSheetView3 = NBPFeedActionSheetView.this;
                                actionSheetAttr2.w(((Boolean) nBPFeedActionSheetView3.showActionSheet$delegate.getValue(nBPFeedActionSheetView3, NBPFeedActionSheetView.$$delegatedProperties[0])).booleanValue());
                                final NBPFeedActionSheetView nBPFeedActionSheetView4 = NBPFeedActionSheetView.this;
                                nBPFeedActionSheetView4.getClass();
                                actionSheetAttr2.j(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView$actionSheet$1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                        ViewContainer<?, ?> viewContainer3 = viewContainer2;
                                        viewContainer3.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView$actionSheet$1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(m mVar) {
                                                m mVar2 = mVar;
                                                mVar2.flexDirectionColumn();
                                                mVar2.borderRadius(8.0f);
                                                mVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                mVar2.mo153width(mVar2.getPagerData().m());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPFeedActionSheetView nBPFeedActionSheetView5 = NBPFeedActionSheetView.this;
                                        viewContainer3.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView$actionSheet$1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Event event) {
                                                final NBPFeedActionSheetView nBPFeedActionSheetView6 = NBPFeedActionSheetView.this;
                                                event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        NBPFeedActionSheetView.this.closeActionSheet();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        if (NBPFeedActionSheetView.access$getAttr(NBPFeedActionSheetView.this).showUnrelatedTheme) {
                                            final NBPFeedActionSheetView nBPFeedActionSheetView6 = NBPFeedActionSheetView.this;
                                            w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView$actionSheet$1.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar) {
                                                    v vVar2 = vVar;
                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.mo141height(56.0f);
                                                            tVar2.allCenter();
                                                            tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPFeedActionSheetView nBPFeedActionSheetView7 = NBPFeedActionSheetView.this;
                                                    vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.3.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(u uVar) {
                                                            final NBPFeedActionSheetView nBPFeedActionSheetView8 = NBPFeedActionSheetView.this;
                                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.3.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    NBPFeedActionSheetView.this.repotThemeTipOff();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.3.3
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.3.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.text("\u548c\u4e3b\u9898\u5730\u56fe\u65e0\u5173");
                                                                    NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 17.0f, null, 2, null, "text_primary");
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.3.4
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar3) {
                                                            vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.3.4.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.positionAbsolute();
                                                                    tVar2.m138bottom(0.0f);
                                                                    tVar2.size(tVar2.getPagerData().m(), 0.5f);
                                                                    tVar2.mo113backgroundColor(QUIToken.color$default("border_standard"));
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
                                        final NBPFeedActionSheetView nBPFeedActionSheetView7 = NBPFeedActionSheetView.this;
                                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView$actionSheet$1.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo141height(56.0f);
                                                        tVar2.allCenter();
                                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedActionSheetView nBPFeedActionSheetView8 = NBPFeedActionSheetView.this;
                                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.4.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final NBPFeedActionSheetView nBPFeedActionSheetView9 = NBPFeedActionSheetView.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.4.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                NBPFeedActionSheetView nBPFeedActionSheetView10 = NBPFeedActionSheetView.this;
                                                                nBPFeedActionSheetView10.showActionSheet$delegate.setValue(nBPFeedActionSheetView10, NBPFeedActionSheetView.$$delegatedProperties[0], Boolean.FALSE);
                                                                NBPFeedActionSheetView.this.onActionSheetBtnClick();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedActionSheetView nBPFeedActionSheetView9 = NBPFeedActionSheetView.this;
                                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.4.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final NBPFeedActionSheetView nBPFeedActionSheetView10 = NBPFeedActionSheetView.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.4.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                NBPFeedActionSheetView.this.getClass();
                                                                ceVar2.color(QUIToken.color$default("feedback_error"));
                                                                ceVar2.text(NBPFeedActionSheetView.this.getActionSheetBtnText());
                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView$actionSheet$1.5
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.5.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo141height(12.0f);
                                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_standard"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPFeedActionSheetView nBPFeedActionSheetView8 = NBPFeedActionSheetView.this;
                                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView$actionSheet$1.6
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.6.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.allCenter();
                                                        tVar2.mo141height(56.0f);
                                                        tVar2.marginBottom(21.0f);
                                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPFeedActionSheetView nBPFeedActionSheetView9 = NBPFeedActionSheetView.this;
                                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.6.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final NBPFeedActionSheetView nBPFeedActionSheetView10 = NBPFeedActionSheetView.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.6.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                NBPFeedActionSheetView.this.closeActionSheet();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.6.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.actionSheet.1.6.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                ceVar2.text("\u53d6\u6d88");
                                                                ceVar2.fontWeight600();
                                                                ceVar2.color(QUIToken.color$default("text_primary"));
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
                        final NBPFeedActionSheetView nBPFeedActionSheetView3 = NBPFeedActionSheetView.this;
                        actionSheetView2.event(new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(d dVar) {
                                d dVar2 = dVar;
                                final NBPFeedActionSheetView nBPFeedActionSheetView4 = NBPFeedActionSheetView.this;
                                dVar2.j(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPFeedActionSheetView.this.closeActionSheet();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedActionSheetView nBPFeedActionSheetView5 = NBPFeedActionSheetView.this;
                                dVar2.h(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView.body.1.1.2.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NBPFeedActionSheetView nBPFeedActionSheetView6 = NBPFeedActionSheetView.this;
                                        if (!((Boolean) nBPFeedActionSheetView6.showDeleteFeedAlert$delegate.getValue(nBPFeedActionSheetView6, NBPFeedActionSheetView.$$delegatedProperties[1])).booleanValue()) {
                                            NBPFeedActionSheetView.this.closeActionSheet();
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
                return Unit.INSTANCE;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void closeActionSheet() {
        ((NBPFeedActionSheetViewEvent) getEvent()).onFireEvent("closedActionSheet", Boolean.TRUE);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPFeedActionSheetViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPFeedActionSheetViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getActionSheetBtnText() {
        if (Intrinsics.areEqual(((NBPFeedActionSheetViewAttr) getAttr()).viewerUserId, ((NBPFeedActionSheetViewAttr) getAttr()).posterUserId)) {
            return "\u5220\u9664";
        }
        return "\u4e3e\u62a5";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onActionSheetBtnClick() {
        if (Intrinsics.areEqual(((NBPFeedActionSheetViewAttr) getAttr()).viewerUserId, ((NBPFeedActionSheetViewAttr) getAttr()).posterUserId)) {
            this.showDeleteFeedAlert$delegate.setValue(this, $$delegatedProperties[1], Boolean.TRUE);
            ((QQUIModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQUIModule")).openAlertDialog("", "\u786e\u5b9a\u8981\u5220\u9664\u8fd9\u6761\u52a8\u6001", "\u518d\u60f3\u60f3", "\u786e\u5b9a", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView$onActionSheetBtnClick$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Boolean bool, Boolean bool2) {
                    boolean booleanValue = bool.booleanValue();
                    bool2.booleanValue();
                    if (booleanValue) {
                        NBPFeedActionSheetView nBPFeedActionSheetView = NBPFeedActionSheetView.this;
                        nBPFeedActionSheetView.showDeleteFeedAlert$delegate.setValue(nBPFeedActionSheetView, NBPFeedActionSheetView.$$delegatedProperties[1], Boolean.FALSE);
                        NBPFeedActionSheetView.this.performDeleteStatusFeed();
                    } else {
                        NBPFeedActionSheetView nBPFeedActionSheetView2 = NBPFeedActionSheetView.this;
                        nBPFeedActionSheetView2.showDeleteFeedAlert$delegate.setValue(nBPFeedActionSheetView2, NBPFeedActionSheetView.$$delegatedProperties[1], Boolean.FALSE);
                        NBPFeedActionSheetView.this.closeActionSheet();
                    }
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        int i3 = ((NBPFeedActionSheetViewAttr) getAttr()).appId;
        String str = ((NBPFeedActionSheetViewAttr) getAttr()).feedId;
        String str2 = ((NBPFeedActionSheetViewAttr) getAttr()).posterTinyId;
        if (i3 == 1) {
            QQNearbyModule.Companion.getInstance().jumpReportPageV2("100826", str2, str);
        } else {
            QQNearbyModule.Companion.getInstance().jumpReportPage(100522, str2, str, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void performDeleteStatusFeed() {
        AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("performDeleteStatusFeed: "), ((NBPFeedActionSheetViewAttr) getAttr()).feedId, KLog.INSTANCE, "NBPFeedActionSheetView");
        int i3 = ((NBPFeedActionSheetViewAttr) getAttr()).appId;
        final String str = ((NBPFeedActionSheetViewAttr) getAttr()).feedId;
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPFeedActionSheetView$performDeleteStatusFeed$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                if (bool.booleanValue()) {
                    Utils utils = Utils.INSTANCE;
                    utils.currentBridgeModule().qToast("\u5220\u9664\u6210\u529f", QToastMode.Success);
                    k notifyModule = utils.notifyModule("");
                    com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                    eVar.v("feedId", NBPFeedActionSheetView.access$getAttr(NBPFeedActionSheetView.this).feedId);
                    Unit unit = Unit.INSTANCE;
                    k.d(notifyModule, "NBPFeedDeleteEvent", eVar, false, 4, null);
                    NBPFeedActionSheetView.access$getEvent(NBPFeedActionSheetView.this).onFireEvent("EVENT_DELETE_STATUS_FEED", NBPFeedActionSheetView.access$getAttr(NBPFeedActionSheetView.this).feedId);
                } else {
                    Utils.INSTANCE.currentBridgeModule().qToast("\u5220\u9664\u5931\u8d25", QToastMode.Warning);
                }
                return Unit.INSTANCE;
            }
        };
        CommonProxyService.INSTANCE.request(new StrangerDeleteFeedRequest(i3, str), new Function4<p35.k, byte[], Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.StrangerFeedRepo$deleteFeedRequest$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public final Unit invoke(p35.k kVar, byte[] bArr, Integer num, String str2) {
                p35.k kVar2 = kVar;
                int intValue = num.intValue();
                String str3 = str2;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("deleteFeedRequest: rspIsNull=");
                m3.append(kVar2 == null);
                m3.append(" feedId=");
                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(PopDownMenuLogic$deleteTtsInfo$1$$ExternalSyntheticOutline0.m(m3, str, ", code=", intValue, ", msg="), str3, kLog, "StrangerFeedRepo");
                if (intValue == 0) {
                    k notifyModule = Utils.INSTANCE.notifyModule("");
                    com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                    eVar.v("feedId", str);
                    Unit unit = Unit.INSTANCE;
                    k.d(notifyModule, "NBPFeedDeleteEvent", eVar, false, 4, null);
                }
                function1.invoke(Boolean.valueOf(intValue == 0));
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void repotThemeTipOff() {
        NBPTipOffReportRequest nBPTipOffReportRequest = new NBPTipOffReportRequest(((NBPFeedActionSheetViewAttr) getAttr()).feedId);
        final Function1 function1 = null;
        Function1<PbResponse<j>, Unit> function12 = new Function1<PbResponse<j>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPTipOffReportRepo$tipOffReport$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<j> pbResponse) {
                PbResponse<j> pbResponse2 = pbResponse;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("tipOffReport: ");
                m3.append(pbResponse2.code);
                m3.append(", ");
                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, pbResponse2.f114187msg, kLog, "NBPTipOffReportRepo");
                Function1<Boolean, Unit> function13 = function1;
                if (function13 != null) {
                    function13.invoke(Boolean.valueOf(pbResponse2.success));
                }
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.map_svr.Map.SsoGetFeedShareInfo");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(nBPTipOffReportRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function12), 6);
        Utils.INSTANCE.currentBridgeModule().qToast("\u53cd\u9988\u6210\u529f\uff0c\u5c06\u4e3a\u4f60\u4f18\u5316\u540e\u7eed\u63a8\u8350", QToastMode.Info);
        closeActionSheet();
    }
}
