package com.tencent.hippykotlin.demo.pages.nearby.feed_like;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.HomepageSource;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.StrangerUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalView;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPHalfScreenModalViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
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
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPFeedLikePage extends NearbyBasePager {
    public static final /* synthetic */ int $r8$clinit = 0;
    public int appID;
    public aa<NBPHalfScreenModalView> modalViewRef;
    public NBPFeedLikeViewModel pageModel;
    public String curFeedId = "";
    public String likeKey = "";
    public String userId = "";

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final float min = Math.min(getPagerData().l() * 0.8f, 620.0f);
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NBPFeedLikePage nBPFeedLikePage = NBPFeedLikePage.this;
                final float f16 = min;
                NBPHalfScreenModalViewKt.NBPHalfScreenModal(viewContainer, new Function1<NBPHalfScreenModalView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(NBPHalfScreenModalView nBPHalfScreenModalView) {
                        NBPHalfScreenModalView nBPHalfScreenModalView2 = nBPHalfScreenModalView;
                        final NBPFeedLikePage nBPFeedLikePage2 = NBPFeedLikePage.this;
                        nBPHalfScreenModalView2.ref(nBPHalfScreenModalView2, new Function1<aa<NBPHalfScreenModalView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<NBPHalfScreenModalView> aaVar) {
                                NBPFeedLikePage.this.modalViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final float f17 = f16;
                        nBPHalfScreenModalView2.attr(new Function1<NBPHalfScreenModalAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPHalfScreenModalAttr nBPHalfScreenModalAttr) {
                                NBPHalfScreenModalAttr nBPHalfScreenModalAttr2 = nBPHalfScreenModalAttr;
                                nBPHalfScreenModalAttr2.mo153width(nBPHalfScreenModalAttr2.getPagerData().m());
                                nBPHalfScreenModalAttr2.mo141height(nBPHalfScreenModalAttr2.getPagerData().l());
                                nBPHalfScreenModalAttr2.contentHeight = f17;
                                nBPHalfScreenModalAttr2.contentBorderRadius = 8.0f;
                                return Unit.INSTANCE;
                            }
                        });
                        nBPHalfScreenModalView2.event(new Function1<NBPHalfScreenModalEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NBPHalfScreenModalEvent nBPHalfScreenModalEvent) {
                                nBPHalfScreenModalEvent.onCloseHandler = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                        return Unit.INSTANCE;
                                    }
                                };
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPFeedLikePage nBPFeedLikePage3 = NBPFeedLikePage.this;
                        nBPHalfScreenModalView2.contentBuilder = new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                ViewContainer<?, ?> viewContainer3 = viewContainer2;
                                viewContainer3.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(m mVar) {
                                        mVar.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(14.0f);
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.2.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.size(36.0f, 5.0f);
                                                        tVar2.mo113backgroundColor(QUIToken.color$default("icon_tertiary"));
                                                        tVar2.borderRadius(3.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedLikePage nBPFeedLikePage4 = NBPFeedLikePage.this;
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(40.0f);
                                                tVar2.allCenter();
                                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPFeedLikePage nBPFeedLikePage5 = NBPFeedLikePage.this;
                                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPFeedLikePage nBPFeedLikePage6 = NBPFeedLikePage.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str;
                                                        ce ceVar2 = ceVar;
                                                        if (NBPFeedLikePage.this.getPageModel().getPageState() == 2) {
                                                            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u70b9\u8d5e ");
                                                            m3.append(NBPFeedLikePage.this.getPageModel().getUserCount());
                                                            str = m3.toString();
                                                        } else {
                                                            str = "";
                                                        }
                                                        ceVar2.text(str);
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.fontWeight500();
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
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo141height(0.5f);
                                                tVar2.mo113backgroundColor(QUIToken.color$default("border_light"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPFeedLikePage nBPFeedLikePage5 = NBPFeedLikePage.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.5
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Integer.valueOf(NBPFeedLikePage.this.getPageModel().getPageState());
                                    }
                                };
                                final NBPFeedLikePage nBPFeedLikePage6 = NBPFeedLikePage.this;
                                BindDirectivesViewKt.a(viewContainer3, function0, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                        BindDirectivesView bindDirectivesView2 = bindDirectivesView;
                                        int pageState = NBPFeedLikePage.this.getPageModel().getPageState();
                                        if (pageState == 0) {
                                            w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar) {
                                                    v vVar2 = vVar;
                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.1.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.flexDirectionColumn();
                                                            tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                            tVar2.m140flex(1.0f);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.1.2
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar3) {
                                                            v vVar4 = vVar3;
                                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.1.2.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.m140flex(1.0f);
                                                                    tVar2.mo153width(tVar2.getPagerData().m());
                                                                    tVar2.paddingTop(200.0f);
                                                                    tVar2.justifyContentCenter();
                                                                    tVar2.flexDirectionRow();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            i.a(vVar4, new Function1<h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.1.2.2
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(h hVar) {
                                                                    hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.1.2.2.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(f fVar) {
                                                                            f fVar2 = fVar;
                                                                            fVar2.size(20.0f, 20.0f);
                                                                            fVar2.h(!c.f117352a.g().isNightMode());
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.1.2.3
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(TextView textView) {
                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.1.2.3.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ce ceVar) {
                                                                            ce ceVar2 = ceVar;
                                                                            ceVar2.marginLeft(4.0f);
                                                                            ceVar2.text("\u52a0\u8f7d\u4e2d,\u8bf7\u7a0d\u540e...");
                                                                            ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                                            ceVar2.color(new com.tencent.kuikly.core.base.h(9211020L, 1.0f));
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
                                        } else if (pageState == 1) {
                                            final NBPFeedLikePage nBPFeedLikePage7 = NBPFeedLikePage.this;
                                            w.a(bindDirectivesView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.3
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar) {
                                                    v vVar2 = vVar;
                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.m140flex(1.0f);
                                                            tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                            tVar2.flexDirectionColumn();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPFeedLikePage nBPFeedLikePage8 = NBPFeedLikePage.this;
                                                    vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.3.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(u uVar) {
                                                            final NBPFeedLikePage nBPFeedLikePage9 = NBPFeedLikePage.this;
                                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.3.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ClickParams clickParams) {
                                                                    NBPFeedLikePage nBPFeedLikePage10 = NBPFeedLikePage.this;
                                                                    int i3 = NBPFeedLikePage.$r8$clinit;
                                                                    nBPFeedLikePage10.getPageModel().setPageState(0);
                                                                    nBPFeedLikePage10.getPageModel().retryCount = 0;
                                                                    nBPFeedLikePage10.getPageModel().requestFeedLikeList();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.3.3
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(v vVar3) {
                                                            v vVar4 = vVar3;
                                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.3.3.1
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(t tVar) {
                                                                    t tVar2 = tVar;
                                                                    tVar2.m140flex(1.0f);
                                                                    tVar2.mo153width(tVar2.getPagerData().m());
                                                                    tVar2.alignItemsCenter();
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.3.3.2
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ImageView imageView) {
                                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.3.3.2.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(af afVar) {
                                                                            af afVar2 = afVar;
                                                                            afVar2.size(86.0f, 86.0f);
                                                                            afVar2.marginTop(200.0f);
                                                                            b.a.b(afVar2, "data:image/png;base64,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", false, 2, null);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.3.3.3
                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(TextView textView) {
                                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.3.3.3.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ce ceVar) {
                                                                            ce ceVar2 = ceVar;
                                                                            ceVar2.marginTop(24.0f);
                                                                            ceVar2.text("\u7f51\u7edc\u5f02\u5e38\uff0c\u70b9\u51fb\u91cd\u8bd5");
                                                                            ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                                            ceVar2.color(com.tencent.kuikly.core.base.h.INSTANCE.b());
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
                                        } else if (pageState == 2) {
                                            final NBPFeedLikePage nBPFeedLikePage8 = NBPFeedLikePage.this;
                                            ar.a(bindDirectivesView2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(aq<?, ?> aqVar) {
                                                    aq<?, ?> aqVar2 = aqVar;
                                                    aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ao aoVar) {
                                                            ao aoVar2 = aoVar;
                                                            aoVar2.m140flex(1.0f);
                                                            aoVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPFeedLikePage nBPFeedLikePage9 = NBPFeedLikePage.this;
                                                    aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.2.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ap apVar) {
                                                            final NBPFeedLikePage nBPFeedLikePage10 = NBPFeedLikePage.this;
                                                            apVar.scroll(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.2.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ScrollParams scrollParams) {
                                                                    ScrollParams scrollParams2 = scrollParams;
                                                                    if (scrollParams2.getContentHeight() - scrollParams2.getViewHeight() < scrollParams2.getOffsetY() + 20.0f) {
                                                                        NBPFeedLikePage.this.getPageModel().requestFeedLikeList();
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPFeedLikePage nBPFeedLikePage10 = NBPFeedLikePage.this;
                                                    Function0<com.tencent.kuikly.core.reactive.collection.c<s35.af>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<s35.af>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.2.3
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final com.tencent.kuikly.core.reactive.collection.c<s35.af> invoke() {
                                                            return NBPFeedLikePage.this.getPageModel().getLikedUsers();
                                                        }
                                                    };
                                                    final NBPFeedLikePage nBPFeedLikePage11 = NBPFeedLikePage.this;
                                                    LoopDirectivesViewKt.a(aqVar2, function02, new Function2<LoopDirectivesView<s35.af>, s35.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.2.4
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Unit invoke(LoopDirectivesView<s35.af> loopDirectivesView, s35.af afVar) {
                                                            final s35.af afVar2 = afVar;
                                                            final NBPFeedLikePage nBPFeedLikePage12 = NBPFeedLikePage.this;
                                                            w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.2.4.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(v vVar) {
                                                                    v vVar2 = vVar;
                                                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.2.4.1.1
                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(t tVar) {
                                                                            t tVar2 = tVar;
                                                                            tVar2.flexDirectionRow();
                                                                            tVar2.size(tVar2.getPagerData().m(), 56.0f);
                                                                            tVar2.alignItemsCenter();
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final s35.af afVar3 = s35.af.this;
                                                                    final NBPFeedLikePage nBPFeedLikePage13 = nBPFeedLikePage12;
                                                                    vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.2.4.1.2
                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(u uVar) {
                                                                            final s35.af afVar4 = s35.af.this;
                                                                            final NBPFeedLikePage nBPFeedLikePage14 = nBPFeedLikePage13;
                                                                            uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.2.4.1.2.1
                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                    String userId = StrangerUtilsKt.getUserId(s35.af.this, nBPFeedLikePage14.appID);
                                                                                    boolean areEqual = Intrinsics.areEqual(userId, nBPFeedLikePage14.userId);
                                                                                    NBPJumpUtil nBPJumpUtil = NBPJumpUtil.INSTANCE;
                                                                                    NBPFeedLikePage nBPFeedLikePage15 = nBPFeedLikePage14;
                                                                                    nBPJumpUtil.jumpPersonaPage(nBPFeedLikePage15.appID, userId, areEqual, false, HomepageSource.FEED_LIKE_LIST, areEqual ? nBPFeedLikePage15.curFeedId : null);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final s35.af afVar4 = s35.af.this;
                                                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.2.4.1.3
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ImageView imageView) {
                                                                            final s35.af afVar5 = s35.af.this;
                                                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.2.4.1.3.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(af afVar6) {
                                                                                    af afVar7 = afVar6;
                                                                                    afVar7.p();
                                                                                    afVar7.size(40.0f, 40.0f);
                                                                                    afVar7.borderRadius(20.0f);
                                                                                    b.a.b(afVar7, s35.af.this.E, false, 2, null);
                                                                                    afVar7.marginLeft(15.0f);
                                                                                    afVar7.marginRight(12.0f);
                                                                                    return Unit.INSTANCE;
                                                                                }
                                                                            });
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                    final s35.af afVar5 = s35.af.this;
                                                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.2.4.1.4
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(TextView textView) {
                                                                            final s35.af afVar6 = s35.af.this;
                                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage.body.1.1.4.6.2.4.1.4.1
                                                                                {
                                                                                    super(1);
                                                                                }

                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                public final Unit invoke(ce ceVar) {
                                                                                    ce ceVar2 = ceVar;
                                                                                    ceVar2.text(s35.af.this.f433209f);
                                                                                    ceVar2.color(QUIToken.color$default("text_primary"));
                                                                                    ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                                    ceVar2.mo153width(250.0f);
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
        this.curFeedId = getPageData().n().p("feed_id");
        this.likeKey = getPageData().n().p(IQzoneMsgApi.LIKE_KEY);
        this.userId = getPageData().n().p("user_id");
        this.appID = Integer.parseInt(getPageData().n().p("app_id"));
        this.pageModel = new NBPFeedLikeViewModel(this.appID, this.likeKey, this.curFeedId, this.userId);
        getPageModel().requestFeedLikeList();
    }

    public final NBPFeedLikeViewModel getPageModel() {
        NBPFeedLikeViewModel nBPFeedLikeViewModel = this.pageModel;
        if (nBPFeedLikeViewModel != null) {
            return nBPFeedLikeViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pageModel");
        return null;
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        NBPHalfScreenModalView b16;
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            aa<NBPHalfScreenModalView> aaVar = this.modalViewRef;
            if (aaVar == null || (b16 = aaVar.b()) == null) {
                return;
            }
            b16.setAnimationOpen(false);
            return;
        }
        super.onReceivePagerEvent(str, eVar);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageDidAppear() {
        super.pageDidAppear();
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_like.NBPFeedLikePage$pageDidAppear$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                IPagerIdKtxKt.getBridgeModule(NBPFeedLikePage.this).setWhiteStatusBarStyle();
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 0, function0);
    }
}
