package com.tencent.hippykotlin.demo.pages.nearby.interactive;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NBPInteractivePageSource$EnumUnboxingLocalUtility;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.HomepageSource;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractiveMsgListRequest;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractiveRepo$fetchInteractiveMsgList$1;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemViewEvent;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemViewEvent;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeView;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveFollowedMeViewEvent;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemView;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveGroupItemViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractivePraiseItemView;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractivePraiseItemViewAttr;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractivePraiseItemViewEvent;
import com.tencent.hippykotlin.demo.pages.nearby.interactive.view_model.NBPInteractiveViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.FooterRefreshEndState;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.FooterRefreshView;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.f;
import com.tencent.kuikly.core.views.h;
import com.tencent.kuikly.core.views.i;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.kuikly.core.views.x;
import com.tencent.kuikly.core.views.y;
import com.tencent.kuikly.core.views.z;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import i35.a;
import i35.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n25.g;
import n25.l;

/* loaded from: classes31.dex */
public final class NBPInteractivePage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPInteractivePage.class, "footerRefreshText", "getFooterRefreshText()Ljava/lang/String;", 0)};
    public String closeMsgPageNotification;
    public aa<FooterRefreshView> footerRefreshRef;
    public NBPInteractiveViewModel viewModel;
    public String source = NBPInteractivePageSource$EnumUnboxingLocalUtility._getValue(2);
    public final ReadWriteProperty footerRefreshText$delegate = c.a("");

    /* loaded from: classes31.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FooterRefreshState.values().length];
            try {
                iArr[FooterRefreshState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[FooterRefreshState.REFRESHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[FooterRefreshState.NONE_MORE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[FooterRefreshState.FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void access$gotoFeedDetailPage(NBPInteractivePage nBPInteractivePage, g gVar) {
        nBPInteractivePage.getClass();
        if (gVar == null) {
            return;
        }
        e eVar = new e();
        eVar.t("click_feed_type", gVar.f418069f);
        eVar.v("comment_id", gVar.f418072m);
        eVar.v("reply_id", gVar.C);
        l lVar = gVar.F;
        if (lVar != null) {
            QQNearbyModule.Companion.getInstance().openFeedDetail(lVar, 2, eVar);
        }
    }

    public static final void access$gotoPersonalPage(NBPInteractivePage nBPInteractivePage, g gVar) {
        r25.e eVar;
        nBPInteractivePage.getClass();
        if (gVar == null || (eVar = gVar.f418070h) == null) {
            return;
        }
        long j3 = eVar.f430610d;
        NBPJumpUtil.jumpPersonaPage$default(2, String.valueOf(j3), j3 == UserDataManager.INSTANCE.getUserSelfInfo().tid, false, HomepageSource.INTER_USER_LIST, null, 40);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.justifyContentCenter();
                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                                tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().getNavigationBarHeight());
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.positionAbsolute();
                                        tVar2.m142left(10.0f);
                                        tVar2.m150top(tVar2.getPagerData().getStatusBarHeight());
                                        tVar2.m138bottom(0.0f);
                                        tVar2.justifyContentCenter();
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.2.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.2.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                QQKuiklyPlatformApi.Companion.closePage$default();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.2.2.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.2.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(24.0f, 24.0f);
                                                b.a.b(afVar2, QUIToken.INSTANCE.image("chevron_left", null), false, 2, null);
                                                afVar2.t(QUIToken.color$default("icon_primary"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginTop(ceVar2.getPagerData().getStatusBarHeight());
                                        ceVar2.text("\u4e92\u52a8\u6d88\u606f");
                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                        ceVar2.fontWeight500();
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
                final NBPInteractivePage nBPInteractivePage = NBPInteractivePage.this;
                ar.a(viewContainer2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        aq<?, ?> aqVar2 = aqVar;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                aoVar.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPInteractivePage nBPInteractivePage2 = NBPInteractivePage.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPInteractiveViewModel nBPInteractiveViewModel = NBPInteractivePage.this.viewModel;
                                if (nBPInteractiveViewModel != null) {
                                    return Integer.valueOf(nBPInteractiveViewModel.getPageState());
                                }
                                return null;
                            }
                        };
                        final NBPInteractivePage nBPInteractivePage3 = NBPInteractivePage.this;
                        BindDirectivesViewKt.a(aqVar2, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                NBPInteractiveViewModel nBPInteractiveViewModel = NBPInteractivePage.this.viewModel;
                                Integer valueOf = nBPInteractiveViewModel != null ? Integer.valueOf(nBPInteractiveViewModel.getPageState()) : null;
                                if (valueOf != null && valueOf.intValue() == 0) {
                                    w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.mo153width(tVar2.getPagerData().m());
                                                    tVar2.mo141height(tVar2.getPagerData().l() - tVar2.getPagerData().getNavigationBarHeight());
                                                    tVar2.allCenter();
                                                    tVar2.flexDirectionRow();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            i.a(vVar2, new Function1<h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.1.2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(h hVar) {
                                                    hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.1.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(f fVar) {
                                                            f fVar2 = fVar;
                                                            fVar2.size(20.0f, 20.0f);
                                                            fVar2.h(true);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.1.3
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.1.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.marginLeft(4.0f);
                                                            ceVar2.text("\u52a0\u8f7d\u4e2d,\u8bf7\u7a0d\u540e...");
                                                            NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 13.0f, null, 2, null, "text_primary");
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else if (valueOf != null && valueOf.intValue() == 3) {
                                    w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.2.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.mo153width(tVar2.getPagerData().m());
                                                    tVar2.mo141height(tVar2.getPagerData().l() - tVar2.getPagerData().getNavigationBarHeight());
                                                    tVar2.allCenter();
                                                    tVar2.flexDirectionColumn();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.2.2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.2.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            afVar2.size(100.0f, 100.0f);
                                                            b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_rJayQJ9gRzZ.png", false, 2, null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.2.3
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.2.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.marginTop(24.0f);
                                                            ceVar2.text("\u6682\u65e0\u4e92\u52a8\u6d88\u606f");
                                                            NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 17.0f, null, 2, null, "text_primary");
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else if (valueOf != null && valueOf.intValue() == 1) {
                                    final NBPInteractivePage nBPInteractivePage4 = NBPInteractivePage.this;
                                    w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.mo153width(tVar2.getPagerData().m());
                                                    tVar2.mo141height(tVar2.getPagerData().l() - tVar2.getPagerData().getNavigationBarHeight());
                                                    tVar2.allCenter();
                                                    tVar2.flexDirectionColumn();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPInteractivePage nBPInteractivePage5 = NBPInteractivePage.this;
                                            vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.3.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    final NBPInteractivePage nBPInteractivePage6 = NBPInteractivePage.this;
                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.3.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            NBPInteractiveViewModel nBPInteractiveViewModel2 = NBPInteractivePage.this.viewModel;
                                                            if (nBPInteractiveViewModel2 != null) {
                                                                nBPInteractiveViewModel2.setPageState(0);
                                                                nBPInteractiveViewModel2.getInteractiveMsgList().clear();
                                                                nBPInteractiveViewModel2.fetchFirstInteractiveMsgList();
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.3.3
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.3.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            afVar2.size(86.0f, 86.0f);
                                                            b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMgAAADICAMAAACahl6sAAAATlBMVEUAAABMTExMTExQUFBMTExMTExISEhLS0tLS0tMTExQUFBAQEBLS0tKSkpLS0tNTU1MTExMTExMTExMTExKSkpJSUlMTExLS0tMTExMTEzb8illAAAAGXRSTlMA3+8gv4AgX5BAEBBwMKCfz2+vUI9QQc4/sIny8wAAB+NJREFUeNrtndty2yAQhlkOAnSWHLvV+79oJ8TxOnXqALuScEf/XWbSKp/2wAILEocOHTp06NChQ4cOHSJKddYMgwaAJUjCqGdnzr4Wr6K6m4ZRLv+U1G7yonDV3mm5xEi7cm2jJr0kSU9KFCdv4KsDjYObrFdKiaBGdf40ufkvg4EriqX+YgsYptOTP6/x03wPPdpSWPwsEcLZRkSoOvUjsvQlBL/VuT5fWX1nFrGragNI0YhkNcgCe6JM8vOFmmQKtAvsjXKGT2N4YpANe6L4q1NIVwmyqhvK1hmsdlcM9CkmlH5TFHsNDocYDCib+5fS19hAp2JC2dYo5w9zgBfsOsFGRsHokEasIrMEvTViZSlAr1pFFayevjDKZStWEhpFruZe+AzoxHpCoxixluo+JefS43Be6UFqRLdaW+2KgaIA3Wp9dYAka3CMldhIFZKswKEbsZnqGUm4OXqxqRyS8HIYsbHMB8nLc9xIXp6DmaQmctBJRp4cE7KHEzspVBMD2zuZxW7STP5gg5c2YjfVoTKy5ECX7xzU8Zw+xkvFEeid2FWdRKcgDa6t2FltmP2SA8SJ3RXe55k4EkIjdleNYZKfwytRgEKYaJJjGVGEQphYgmONohDpd+dqXtyx3lXJ3MylCnKsW6nkRbpCxhIFCfLi3X6k7oJ0yfuLIFTPRUnn+IjliXTvYAkae0WPd6yXCAahbNBxbRU4TMGbGqQekYJlxlpLTKRbGsQtf+mNIwXDlgbBgQh8c7ep5skmSSxURg6D9F9K5xo4TOLSxhJPNAi+jdPXYQDIiSvNrj3LGPL+TIGq8WfiWDInObfnBhEsID4lA9vgBGWCBIdtE37Xlgpi4sNd0UO9ewbSiUxhqHWEFBet+jzI5RnIAv25poW7iR7VLa1T8znIu+YzZfYO0Z7VZLY4BoofQYKgV/m+pSKJdZ4xsH35GUiAJfQz6ci8pfM8y+sbhfPPs5Z3EIFCfdN1Vs5SPVLEpF8/QDZKFXw/auj8lRsbemqixxH7iZLcFglRhYdLr7M83LXNRoOgN4JNL4FdVIiccuaz2qeP7BfI8S8bFSQYIknmkDavRLGQ3iBZxxSOPrFgnLBvNgcEuxhNYpB0EbltTmh8wfeZB4INc1olzZfaiEBqEzs1XUOsfk1im1kbkZB0wpyqkyE6PK2Mx6CXsQ8+RQwRMr7QshJb0YggohqDUWz8kCgjEkIkx4dbcU2sTErIyx/rRh9ZMeKDM0DoJCOmrSfeN8dzWM6pro0n6X90QxO5r94hBxuI8CHofkcWKYYn+xrk4ADBNGh48u8cXWkZ5KCDIImJTjQD1zDSrbEcVMXvwunYdFDoutZtIIEfyzH1P4CEgf1/AOF5mIVnIMC0HLs6iAVcv2q+XdcC+wIgXZiI4xrBY8n6UbKXDmJwpdE9br0NuNJoigZR+u6v9OHVnz8wLnBbDPg8AarKBfESz/Y92Z6uhgUZ6SD848iEE/gfGgYsUNwLp038IBgec/NjCwcaxZQ4sn87Mar6q1XA+dh5VOQs4ldE0ZjNIRPc/iSfkFCKRpx6ZXNAl9bzHkGSPpFFkDbrf8azAIkk58ztt7eIqW6eRSRyJJCY3JYUEzH1yiPpchqsp+xDRqeIdJClivcfEXISruEVL5w2Pf2VUm5XIgzs2GTFpdpoWBbJeCcYDiOp+ZdWDRM21QnZF5e+WNRK5OA50o9Ja4qoYkDwyCwo1lscIGJlteZbR2nx9rAu1O3otAztq0kdHPQTjHJCN2M4TYj1kE7Zjad3y8ru8ZgUXT3Getz+NN3+04Or0bwWhwhPaIci94dperxjQxlXO1RcrBE6wQgdHLyPk7iu/zDTpr+iidIORV+wiUibnA1l8O5b5YJgezVbi3DqekzHMkfQ0aceOqpvYc5IjFJ6ezUhTSbYFTBKaZ71K2EIGFlisn0YECsOl7UpB4A8g289ligDy6nKKqXe1yynhGX7tWisOOqsIe1okmK6tcx2QqhWhx8mllD/neYWrsSJVY+hHp0aZMM91Z146kWbmhuMYLqdlO/m0z65WjNoEiLKpOWygMa+8c0Mghn4TRQmNEhKyilvyRENkn4xQVFCgyRv3VxEQTplXo2iS7y8AkS6fInXiVTZFxMUE+9V/l10tSwp3oFw85ot4pawO8eyxClFAULHylIlS7ooDCpK6i6jUnHBsY7L9IJNCwiTjnrnJYaJEjtKActs3xIvy2G63NYyZXAtdtPMVir11Ouw6Qlr5rHtuOvFxYxDWbX3VdKVEC9OcuN4cRLkYCTZoVjpkYObZN7ykwT6W45iP9rwL6kROZhJtv5sB3Lwk2xWC7d4MptbeJ/A21aftuk5HkS6CoDuVqtneyvXf0YrIz7/VP73spReIsOc7r9rGsXIjeIQzxXBSbDrAkvCMZRiP/dH+DwhwSiIwuizyVFe3pcxayMJtwKTUIARRbkrhv4ttpcFpi8uX0JsEI5Y8qGAVfk+NRIaCvhRFm3rDIoWP9lsGrGr7LggS5JdFFIs2or95e/6NMb+HAVTWwfYpDL/FmWosuOCgnm61E8McW4HWFB6KmADBlWFN4ySenbT+dKpK5JS6mJbN4xyuReYIjbEHvpnliTpqZg947/VeBcHI7XzRXnUd/KT0/IJwzhMXfEQd7Y5GTfrEa5IAKCHwdiuWG86dOjQoUOHDh06dOhl9Aea9iC3qxu2fAAAAABJRU5ErkJggg==", false, 2, null);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.3.4
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.3.4.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.marginTop(24.0f);
                                                            ceVar2.text("\u7f51\u7edc\u5f02\u5e38\uff0c\u70b9\u51fb\u91cd\u8bd5");
                                                            NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 13.0f, null, 2, null, "text_primary");
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else if (valueOf != null && valueOf.intValue() == 2) {
                                    final NBPInteractivePage nBPInteractivePage5 = NBPInteractivePage.this;
                                    Function0<com.tencent.kuikly.core.reactive.collection.c<i35.b>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<i35.b>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.4
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final com.tencent.kuikly.core.reactive.collection.c<i35.b> invoke() {
                                            NBPInteractiveViewModel nBPInteractiveViewModel2 = NBPInteractivePage.this.viewModel;
                                            com.tencent.kuikly.core.reactive.collection.c<i35.b> interactiveMsgList = nBPInteractiveViewModel2 != null ? nBPInteractiveViewModel2.getInteractiveMsgList() : null;
                                            Intrinsics.checkNotNull(interactiveMsgList);
                                            return interactiveMsgList;
                                        }
                                    };
                                    final NBPInteractivePage nBPInteractivePage6 = NBPInteractivePage.this;
                                    LoopDirectivesViewKt.b(bindDirectivesView2, function02, new Function4<LoopDirectivesView<i35.b>, i35.b, Integer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5
                                        {
                                            super(4);
                                        }

                                        @Override // kotlin.jvm.functions.Function4
                                        public final Unit invoke(LoopDirectivesView<i35.b> loopDirectivesView, i35.b bVar, Integer num, Integer num2) {
                                            g gVar;
                                            LoopDirectivesView<i35.b> loopDirectivesView2 = loopDirectivesView;
                                            final i35.b bVar2 = bVar;
                                            final int intValue = num.intValue();
                                            num2.intValue();
                                            int i3 = bVar2.f407158e;
                                            if (i3 == 1) {
                                                final d dVar = bVar2.f407159f;
                                                Integer valueOf2 = (dVar == null || (gVar = dVar.f407168d) == null) ? null : Integer.valueOf(gVar.f418069f);
                                                if (valueOf2 != null && valueOf2.intValue() == 51) {
                                                    final NBPInteractivePage nBPInteractivePage7 = NBPInteractivePage.this;
                                                    loopDirectivesView2.addChild(new NBPInteractiveCommentItemView(), new Function1<NBPInteractiveCommentItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NBPInteractiveCommentItemView nBPInteractiveCommentItemView) {
                                                            NBPInteractiveCommentItemView nBPInteractiveCommentItemView2 = nBPInteractiveCommentItemView;
                                                            final d dVar2 = d.this;
                                                            nBPInteractiveCommentItemView2.attr(new Function1<NBPInteractiveCommentItemViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NBPInteractiveCommentItemViewAttr nBPInteractiveCommentItemViewAttr) {
                                                                    nBPInteractiveCommentItemViewAttr.psvFeed = d.this.f407168d;
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPInteractivePage nBPInteractivePage8 = nBPInteractivePage7;
                                                            final d dVar3 = d.this;
                                                            nBPInteractiveCommentItemView2.event(new Function1<NBPInteractiveCommentItemViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.2.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NBPInteractiveCommentItemViewEvent nBPInteractiveCommentItemViewEvent) {
                                                                    NBPInteractiveCommentItemViewEvent nBPInteractiveCommentItemViewEvent2 = nBPInteractiveCommentItemViewEvent;
                                                                    final NBPInteractivePage nBPInteractivePage9 = NBPInteractivePage.this;
                                                                    final d dVar4 = dVar3;
                                                                    nBPInteractiveCommentItemViewEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.2.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            NBPInteractivePage.access$gotoFeedDetailPage(NBPInteractivePage.this, dVar4.f407168d);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final NBPInteractivePage nBPInteractivePage10 = NBPInteractivePage.this;
                                                                    final d dVar5 = dVar3;
                                                                    nBPInteractiveCommentItemViewEvent2.avatarClickFn = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.2.2.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Unit invoke() {
                                                                            NBPInteractivePage.access$gotoPersonalPage(NBPInteractivePage.this, dVar5.f407168d);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    };
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                } else if (valueOf2 != null && valueOf2.intValue() == 52) {
                                                    final NBPInteractivePage nBPInteractivePage8 = NBPInteractivePage.this;
                                                    loopDirectivesView2.addChild(new NBPInteractiveCommentReplyItemView(), new Function1<NBPInteractiveCommentReplyItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.3
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NBPInteractiveCommentReplyItemView nBPInteractiveCommentReplyItemView) {
                                                            NBPInteractiveCommentReplyItemView nBPInteractiveCommentReplyItemView2 = nBPInteractiveCommentReplyItemView;
                                                            final d dVar2 = d.this;
                                                            nBPInteractiveCommentReplyItemView2.attr(new Function1<NBPInteractiveCommentReplyItemViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.3.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NBPInteractiveCommentReplyItemViewAttr nBPInteractiveCommentReplyItemViewAttr) {
                                                                    nBPInteractiveCommentReplyItemViewAttr.psvFeed = d.this.f407168d;
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPInteractivePage nBPInteractivePage9 = nBPInteractivePage8;
                                                            final d dVar3 = d.this;
                                                            nBPInteractiveCommentReplyItemView2.event(new Function1<NBPInteractiveCommentReplyItemViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.3.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NBPInteractiveCommentReplyItemViewEvent nBPInteractiveCommentReplyItemViewEvent) {
                                                                    NBPInteractiveCommentReplyItemViewEvent nBPInteractiveCommentReplyItemViewEvent2 = nBPInteractiveCommentReplyItemViewEvent;
                                                                    final NBPInteractivePage nBPInteractivePage10 = NBPInteractivePage.this;
                                                                    final d dVar4 = dVar3;
                                                                    nBPInteractiveCommentReplyItemViewEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.3.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            NBPInteractivePage.access$gotoFeedDetailPage(NBPInteractivePage.this, dVar4.f407168d);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final NBPInteractivePage nBPInteractivePage11 = NBPInteractivePage.this;
                                                                    final d dVar5 = dVar3;
                                                                    nBPInteractiveCommentReplyItemViewEvent2.avatarClickFn = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.3.2.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Unit invoke() {
                                                                            NBPInteractivePage.access$gotoPersonalPage(NBPInteractivePage.this, dVar5.f407168d);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    };
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                } else if (valueOf2 != null && valueOf2.intValue() == 62) {
                                                    final NBPInteractivePage nBPInteractivePage9 = NBPInteractivePage.this;
                                                    loopDirectivesView2.addChild(new NBPInteractivePraiseItemView(), new Function1<NBPInteractivePraiseItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.4
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(NBPInteractivePraiseItemView nBPInteractivePraiseItemView) {
                                                            NBPInteractivePraiseItemView nBPInteractivePraiseItemView2 = nBPInteractivePraiseItemView;
                                                            final d dVar2 = d.this;
                                                            nBPInteractivePraiseItemView2.attr(new Function1<NBPInteractivePraiseItemViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.4.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NBPInteractivePraiseItemViewAttr nBPInteractivePraiseItemViewAttr) {
                                                                    nBPInteractivePraiseItemViewAttr.psvFeed = d.this.f407168d;
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPInteractivePage nBPInteractivePage10 = nBPInteractivePage9;
                                                            final d dVar3 = d.this;
                                                            nBPInteractivePraiseItemView2.event(new Function1<NBPInteractivePraiseItemViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.4.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(NBPInteractivePraiseItemViewEvent nBPInteractivePraiseItemViewEvent) {
                                                                    NBPInteractivePraiseItemViewEvent nBPInteractivePraiseItemViewEvent2 = nBPInteractivePraiseItemViewEvent;
                                                                    final NBPInteractivePage nBPInteractivePage11 = NBPInteractivePage.this;
                                                                    final d dVar4 = dVar3;
                                                                    nBPInteractivePraiseItemViewEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.4.2.1
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ClickParams clickParams) {
                                                                            NBPInteractivePage.access$gotoFeedDetailPage(NBPInteractivePage.this, dVar4.f407168d);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final NBPInteractivePage nBPInteractivePage12 = NBPInteractivePage.this;
                                                                    final d dVar5 = dVar3;
                                                                    nBPInteractivePraiseItemViewEvent2.avatarClickFn = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.4.2.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(0);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function0
                                                                        public final Unit invoke() {
                                                                            NBPInteractivePage.access$gotoPersonalPage(NBPInteractivePage.this, dVar5.f407168d);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    };
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                }
                                            } else if (i3 == 2) {
                                                final NBPInteractivePage nBPInteractivePage10 = NBPInteractivePage.this;
                                                loopDirectivesView2.addChild(new NBPInteractiveGroupItemView(), new Function1<NBPInteractiveGroupItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPInteractiveGroupItemView nBPInteractiveGroupItemView) {
                                                        final NBPInteractivePage nBPInteractivePage11 = NBPInteractivePage.this;
                                                        final int i16 = intValue;
                                                        nBPInteractiveGroupItemView.attr(new Function1<NBPInteractiveGroupItemViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.1.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(NBPInteractiveGroupItemViewAttr nBPInteractiveGroupItemViewAttr) {
                                                                NBPInteractiveGroupItemViewAttr nBPInteractiveGroupItemViewAttr2 = nBPInteractiveGroupItemViewAttr;
                                                                nBPInteractiveGroupItemViewAttr2.viewModel = NBPInteractivePage.this.viewModel;
                                                                nBPInteractiveGroupItemViewAttr2.index = i16;
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                            } else if (i3 == 3) {
                                                final NBPInteractivePage nBPInteractivePage11 = NBPInteractivePage.this;
                                                loopDirectivesView2.addChild(new NBPInteractiveFollowedMeView(), new Function1<NBPInteractiveFollowedMeView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.5
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView) {
                                                        NBPInteractiveFollowedMeView nBPInteractiveFollowedMeView2 = nBPInteractiveFollowedMeView;
                                                        final NBPInteractivePage nBPInteractivePage12 = NBPInteractivePage.this;
                                                        final i35.b bVar3 = bVar2;
                                                        nBPInteractiveFollowedMeView2.attr(new Function1<NBPInteractiveFollowedMeViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.5.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(NBPInteractiveFollowedMeViewAttr nBPInteractiveFollowedMeViewAttr) {
                                                                NBPInteractiveFollowedMeViewAttr nBPInteractiveFollowedMeViewAttr2 = nBPInteractiveFollowedMeViewAttr;
                                                                nBPInteractiveFollowedMeViewAttr2.viewModel = NBPInteractivePage.this.viewModel;
                                                                i35.b bVar4 = bVar3;
                                                                d dVar2 = bVar4.f407159f;
                                                                nBPInteractiveFollowedMeViewAttr2.followData = dVar2 != null ? dVar2.f407170f : null;
                                                                nBPInteractiveFollowedMeViewAttr2.timestamp = bVar4.f407160h;
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPInteractivePage nBPInteractivePage13 = NBPInteractivePage.this;
                                                        final i35.b bVar4 = bVar2;
                                                        nBPInteractiveFollowedMeView2.event(new Function1<NBPInteractiveFollowedMeViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.5.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(NBPInteractiveFollowedMeViewEvent nBPInteractiveFollowedMeViewEvent) {
                                                                final NBPInteractivePage nBPInteractivePage14 = NBPInteractivePage.this;
                                                                final i35.b bVar5 = bVar4;
                                                                nBPInteractiveFollowedMeViewEvent.avatarClickFn = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.5.5.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Unit invoke() {
                                                                        a aVar;
                                                                        s35.af afVar;
                                                                        NBPInteractivePage nBPInteractivePage15 = NBPInteractivePage.this;
                                                                        d dVar2 = bVar5.f407159f;
                                                                        long j3 = (dVar2 == null || (aVar = dVar2.f407170f) == null || (afVar = aVar.f407155h) == null) ? 0L : afVar.f433207e;
                                                                        KProperty<Object>[] kPropertyArr = NBPInteractivePage.$$delegatedProperties;
                                                                        nBPInteractivePage15.getClass();
                                                                        NBPJumpUtil.jumpPersonaPage$default(2, String.valueOf(j3), j3 == UserDataManager.INSTANCE.getUserSelfInfo().tid, false, HomepageSource.INTER_USER_LIST, null, 40);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                };
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
                                    final NBPInteractivePage nBPInteractivePage7 = NBPInteractivePage.this;
                                    Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.6
                                        {
                                            super(0);
                                        }

                                        /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
                                        
                                            if ((!r0.isEmpty()) == true) goto L10;
                                         */
                                        @Override // kotlin.jvm.functions.Function0
                                        /*
                                            Code decompiled incorrectly, please refer to instructions dump.
                                        */
                                        public final Object invoke() {
                                            NBPInteractiveViewModel nBPInteractiveViewModel2 = NBPInteractivePage.this.viewModel;
                                            boolean z16 = (nBPInteractiveViewModel2 == null || (r0 = nBPInteractiveViewModel2.getInteractiveMsgList()) == null) ? false : true;
                                            return Boolean.valueOf(z16);
                                        }
                                    };
                                    final NBPInteractivePage nBPInteractivePage8 = NBPInteractivePage.this;
                                    ConditionViewKt.c(bindDirectivesView2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.7
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ConditionView conditionView) {
                                            final NBPInteractivePage nBPInteractivePage9 = NBPInteractivePage.this;
                                            z.a(conditionView, new Function1<FooterRefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.7.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(FooterRefreshView footerRefreshView) {
                                                    FooterRefreshView footerRefreshView2 = footerRefreshView;
                                                    final NBPInteractivePage nBPInteractivePage10 = NBPInteractivePage.this;
                                                    footerRefreshView2.ref(footerRefreshView2, new Function1<aa<FooterRefreshView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.7.1.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(aa<FooterRefreshView> aaVar) {
                                                            NBPInteractivePage.this.footerRefreshRef = aaVar;
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    footerRefreshView2.attr(new Function1<x, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.7.1.2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(x xVar) {
                                                            x xVar2 = xVar;
                                                            xVar2.allCenter();
                                                            xVar2.mo141height(40.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPInteractivePage nBPInteractivePage11 = NBPInteractivePage.this;
                                                    footerRefreshView2.event(new Function1<y, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.7.1.3
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(y yVar) {
                                                            y yVar2 = yVar;
                                                            final NBPInteractivePage nBPInteractivePage12 = NBPInteractivePage.this;
                                                            yVar2.i(new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.7.1.3.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(FooterRefreshState footerRefreshState) {
                                                                    final NBPInteractivePage nBPInteractivePage13 = NBPInteractivePage.this;
                                                                    KProperty<Object>[] kPropertyArr = NBPInteractivePage.$$delegatedProperties;
                                                                    nBPInteractivePage13.getClass();
                                                                    int i3 = NBPInteractivePage.WhenMappings.$EnumSwitchMapping$0[footerRefreshState.ordinal()];
                                                                    if (i3 == 1) {
                                                                        nBPInteractivePage13.setFooterRefreshText("");
                                                                    } else if (i3 == 2) {
                                                                        nBPInteractivePage13.setFooterRefreshText("\u6b63\u5728\u52a0\u8f7d...");
                                                                        final NBPInteractiveViewModel nBPInteractiveViewModel2 = nBPInteractivePage13.viewModel;
                                                                        if (nBPInteractiveViewModel2 != null) {
                                                                            final Function2<FooterRefreshEndState, Boolean, Unit> function2 = new Function2<FooterRefreshEndState, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage$footerStateChanged$1

                                                                                /* loaded from: classes31.dex */
                                                                                public /* synthetic */ class WhenMappings {
                                                                                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                                                                                    static {
                                                                                        int[] iArr = new int[FooterRefreshEndState.values().length];
                                                                                        try {
                                                                                            iArr[FooterRefreshEndState.SUCCESS.ordinal()] = 1;
                                                                                        } catch (NoSuchFieldError unused) {
                                                                                        }
                                                                                        try {
                                                                                            iArr[FooterRefreshEndState.NONE_MORE_DATA.ordinal()] = 2;
                                                                                        } catch (NoSuchFieldError unused2) {
                                                                                        }
                                                                                        try {
                                                                                            iArr[FooterRefreshEndState.FAILURE.ordinal()] = 3;
                                                                                        } catch (NoSuchFieldError unused3) {
                                                                                        }
                                                                                        $EnumSwitchMapping$0 = iArr;
                                                                                    }
                                                                                }

                                                                                {
                                                                                    super(2);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function2
                                                                                public final Unit invoke(FooterRefreshEndState footerRefreshEndState, Boolean bool) {
                                                                                    FooterRefreshView b16;
                                                                                    FooterRefreshView b17;
                                                                                    FooterRefreshView b18;
                                                                                    aa<FooterRefreshView> aaVar;
                                                                                    FooterRefreshView b19;
                                                                                    boolean booleanValue = bool.booleanValue();
                                                                                    int i16 = WhenMappings.$EnumSwitchMapping$0[footerRefreshEndState.ordinal()];
                                                                                    if (i16 != 1) {
                                                                                        if (i16 == 2) {
                                                                                            aa<FooterRefreshView> aaVar2 = NBPInteractivePage.this.footerRefreshRef;
                                                                                            if (aaVar2 != null && (b18 = aaVar2.b()) != null) {
                                                                                                b18.t(FooterRefreshEndState.NONE_MORE_DATA);
                                                                                            }
                                                                                        } else if (i16 == 3 && (aaVar = NBPInteractivePage.this.footerRefreshRef) != null && (b19 = aaVar.b()) != null) {
                                                                                            b19.t(FooterRefreshEndState.FAILURE);
                                                                                        }
                                                                                    } else if (booleanValue) {
                                                                                        aa<FooterRefreshView> aaVar3 = NBPInteractivePage.this.footerRefreshRef;
                                                                                        if (aaVar3 != null && (b17 = aaVar3.b()) != null) {
                                                                                            b17.t(FooterRefreshEndState.NONE_MORE_DATA);
                                                                                        }
                                                                                    } else {
                                                                                        aa<FooterRefreshView> aaVar4 = NBPInteractivePage.this.footerRefreshRef;
                                                                                        if (aaVar4 != null && (b16 = aaVar4.b()) != null) {
                                                                                            b16.t(FooterRefreshEndState.SUCCESS);
                                                                                        }
                                                                                    }
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            };
                                                                            boolean z16 = nBPInteractiveViewModel2.isEnd;
                                                                            if (z16) {
                                                                                function2.invoke(FooterRefreshEndState.NONE_MORE_DATA, Boolean.valueOf(z16));
                                                                            } else if (!nBPInteractiveViewModel2.isRequesting) {
                                                                                nBPInteractiveViewModel2.isRequesting = true;
                                                                                ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchMoreInteractiveMsgList cookie:"), nBPInteractiveViewModel2.cookie.f30291a.length, KLog.INSTANCE, "NBPInteractivePage");
                                                                                c45.a aVar = nBPInteractiveViewModel2.cookie;
                                                                                Function1<j35.f, Unit> function1 = new Function1<j35.f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view_model.NBPInteractiveViewModel$fetchMoreInteractiveMsgList$1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    /* JADX WARN: Multi-variable type inference failed */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(j35.f fVar) {
                                                                                        j35.f fVar2 = fVar;
                                                                                        if (fVar2 != null) {
                                                                                            NBPInteractiveViewModel nBPInteractiveViewModel3 = NBPInteractiveViewModel.this;
                                                                                            nBPInteractiveViewModel3.isEnd = fVar2.f409219f;
                                                                                            nBPInteractiveViewModel3.cookie = fVar2.f409220h;
                                                                                            nBPInteractiveViewModel3.getInteractiveMsgList().addAll(fVar2.f409218e);
                                                                                            function2.invoke(FooterRefreshEndState.SUCCESS, Boolean.valueOf(NBPInteractiveViewModel.this.isEnd));
                                                                                        } else {
                                                                                            function2.invoke(FooterRefreshEndState.FAILURE, Boolean.valueOf(NBPInteractiveViewModel.this.isEnd));
                                                                                        }
                                                                                        KLog kLog = KLog.INSTANCE;
                                                                                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchMoreInteractiveMsgList list size:");
                                                                                        m3.append(NBPInteractiveViewModel.this.getInteractiveMsgList().size());
                                                                                        m3.append(", isEnd:");
                                                                                        m3.append(NBPInteractiveViewModel.this.isEnd);
                                                                                        m3.append(", cookie:");
                                                                                        ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(m3, NBPInteractiveViewModel.this.cookie.f30291a.length, kLog, "NBPInteractivePage");
                                                                                        NBPInteractiveViewModel.this.isRequesting = false;
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                };
                                                                                NBPInteractiveMsgListRequest nBPInteractiveMsgListRequest = new NBPInteractiveMsgListRequest(20, aVar);
                                                                                NBPInteractiveRepo$fetchInteractiveMsgList$1 nBPInteractiveRepo$fetchInteractiveMsgList$1 = new NBPInteractiveRepo$fetchInteractiveMsgList$1(function1);
                                                                                APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.interact_svr.Interact.SsoGetInteractMsgList");
                                                                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                                QQKuiklyPlatformApi.Companion.sendPbRequest$default(nBPInteractiveMsgListRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, nBPInteractiveRepo$fetchInteractiveMsgList$1), 6);
                                                                            }
                                                                        }
                                                                    } else if (i3 == 3) {
                                                                        nBPInteractivePage13.setFooterRefreshText("");
                                                                    } else if (i3 == 4) {
                                                                        nBPInteractivePage13.setFooterRefreshText("");
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPInteractivePage nBPInteractivePage13 = NBPInteractivePage.this;
                                                            yVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.7.1.3.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    aa<FooterRefreshView> aaVar;
                                                                    FooterRefreshView b16;
                                                                    FooterRefreshView b17;
                                                                    aa<FooterRefreshView> aaVar2 = NBPInteractivePage.this.footerRefreshRef;
                                                                    if (((aaVar2 == null || (b17 = aaVar2.b()) == null) ? null : b17.getRefreshState()) == FooterRefreshState.FAILURE && (aaVar = NBPInteractivePage.this.footerRefreshRef) != null && (b16 = aaVar.b()) != null) {
                                                                        b16.p();
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPInteractivePage nBPInteractivePage12 = NBPInteractivePage.this;
                                                    w.a(footerRefreshView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.7.1.4
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar) {
                                                            v vVar2 = vVar;
                                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.7.1.4.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.flexDirectionRow();
                                                                    tVar2.allCenter();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPInteractivePage nBPInteractivePage13 = NBPInteractivePage.this;
                                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.7.1.4.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(TextView textView) {
                                                                    final NBPInteractivePage nBPInteractivePage14 = NBPInteractivePage.this;
                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage.body.1.3.3.7.1.4.2.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ce ceVar) {
                                                                            ce ceVar2 = ceVar;
                                                                            ce.fontSize$default(ceVar2.fontWeight400(), 15.0f, null, 2, null);
                                                                            ceVar2.color(new com.tencent.kuikly.core.base.h(4288256409L));
                                                                            NBPInteractivePage nBPInteractivePage15 = NBPInteractivePage.this;
                                                                            ceVar2.value((String) nBPInteractivePage15.footerRefreshText$delegate.getValue(nBPInteractivePage15, NBPInteractivePage.$$delegatedProperties[0]));
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
                                }
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

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.source = getPageData().n().q("source", "1");
        NBPInteractiveViewModel nBPInteractiveViewModel = new NBPInteractiveViewModel(getPageData());
        nBPInteractiveViewModel.fetchFirstInteractiveMsgList();
        this.viewModel = nBPInteractiveViewModel;
        this.closeMsgPageNotification = k.b((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "NEARBY_CLOSE_MSG_PAGE_EVENT", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.NBPInteractivePage$created$2
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.closePage$default();
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    public final void setFooterRefreshText(String str) {
        this.footerRefreshText$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        super.viewDestroyed();
        customDtReportPageExposure(false);
        String str = this.closeMsgPageNotification;
        if (str != null) {
            ((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule")).e("NEARBY_CLOSE_MSG_PAGE_EVENT", str);
        }
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        customDtReportPageExposure(true);
    }

    public final void customDtReportPageExposure(boolean z16) {
        String str;
        if (z16) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_interact_msg_list");
        m3.v("nearby_user_from", this.source);
        m3.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, m3);
    }
}
