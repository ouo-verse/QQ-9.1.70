package com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.log.KLog;
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
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import o25.f;
import p35.n;

/* loaded from: classes31.dex */
public final class NBPArticleFeedDetailTagView extends ComposeView<NBPArticleFeedDetailTagViewAttr, l> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final n nVar = ((NBPArticleFeedDetailTagViewAttr) getAttr()).feed;
        if (nVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feed");
            nVar = null;
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.alignItemsFlexStart();
                        mVar2.flexWrapWrap();
                        mVar2.flexDirectionRow();
                        mVar2.mo141height(26.0f);
                        mVar2.alignItemsCenter();
                        mVar2.marginTop(4.0f);
                        return Unit.INSTANCE;
                    }
                });
                Iterator<String> it = n.this.I.iterator();
                while (it.hasNext()) {
                    f mapThemeFromCache = NearbyProUtilsKt.getMapThemeFromCache(it.next());
                    if (mapThemeFromCache != null) {
                        NBPArticleFeedDetailTagView nBPArticleFeedDetailTagView = this;
                        final String str = mapThemeFromCache.C;
                        final String str2 = mapThemeFromCache.f421850e;
                        nBPArticleFeedDetailTagView.getClass();
                        final Function0 function0 = null;
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView$buildTagView$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final Function0<Unit> function02 = function0;
                                final String str3 = str;
                                final String str4 = str2;
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView$buildTagView$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView.buildTagView.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                tVar2.marginRight(8.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final Function0<Unit> function03 = function02;
                                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView.buildTagView.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                u uVar2 = uVar;
                                                final Function0<Unit> function04 = function03;
                                                if (function04 != null) {
                                                    uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView.buildTagView.1.1.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            function04.invoke();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final String str5 = str3;
                                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView.buildTagView.1.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final String str6 = str5;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView.buildTagView.1.1.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.size(14.0f, 14.0f);
                                                        afVar2.o();
                                                        b.a.b(afVar2, str6, false, 2, null);
                                                        afVar2.t(QUIToken.color$default("text_secondary"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final String str6 = str4;
                                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView.buildTagView.1.1.4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final String str7 = str6;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView.buildTagView.1.1.4.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginLeft(4.0f);
                                                        ceVar2.text(str7);
                                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                        ceVar2.fontWeight400();
                                                        ceVar2.textOverFlowTail();
                                                        ceVar2.lines(1);
                                                        ceVar2.m144maxWidth(ceVar2.getPagerData().m() - 50.0f);
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
                        }.invoke(viewContainer2);
                    }
                }
                final p35.ah ahVar = n.this.C;
                if (ahVar != null) {
                    NBPArticleFeedDetailTagView nBPArticleFeedDetailTagView2 = this;
                    final String str3 = ahVar.Q;
                    final Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView$body$1$3$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            if (!NearbyProUtilsKt.canOpenPOIPage$default(p35.ah.this)) {
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ignore poi=");
                                m3.append(p35.ah.this.f425143d);
                                m3.append('(');
                                m3.append(p35.ah.this.Q);
                                m3.append(')');
                                kLog.i("NBPArticleFeedDetailTagView", m3.toString());
                            } else {
                                KLog kLog2 = KLog.INSTANCE;
                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("goto middlePage poi=");
                                m16.append(p35.ah.this.f425143d);
                                m16.append('(');
                                m16.append(p35.ah.this.Q);
                                m16.append(')');
                                kLog2.i("NBPArticleFeedDetailTagView", m16.toString());
                                p35.ah ahVar2 = p35.ah.this;
                                if (ahVar2 == null) {
                                    ahVar2 = null;
                                }
                                if (ahVar2 == null) {
                                    kLog2.i("NBPJumpUtil", "jumpPOIMiddlePage poi is null");
                                } else {
                                    QQNearbyModule.Companion.getInstance().setSharePenetratePageData(new byte[][]{i.d(ahVar2)});
                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                    QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearby_middle_page&nbp_source=4&local_bundle_name=nearbypro", false, 6);
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    nBPArticleFeedDetailTagView2.getClass();
                    final String str4 = "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_t7FaMbGvRMi.png";
                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView$buildTagView$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                            final Function0<Unit> function022 = function02;
                            final String str32 = str4;
                            final String str42 = str3;
                            w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView$buildTagView$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView.buildTagView.1.1.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            tVar2.flexDirectionRow();
                                            tVar2.alignItemsCenter();
                                            tVar2.marginRight(8.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final Function0<Unit> function03 = function022;
                                    vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView.buildTagView.1.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(u uVar) {
                                            u uVar2 = uVar;
                                            final Function0<Unit> function04 = function03;
                                            if (function04 != null) {
                                                uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView.buildTagView.1.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        function04.invoke();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final String str5 = str32;
                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView.buildTagView.1.1.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            final String str6 = str5;
                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView.buildTagView.1.1.3.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    afVar2.size(14.0f, 14.0f);
                                                    afVar2.o();
                                                    b.a.b(afVar2, str6, false, 2, null);
                                                    afVar2.t(QUIToken.color$default("text_secondary"));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final String str6 = str42;
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView.buildTagView.1.1.4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final String str7 = str6;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailTagView.buildTagView.1.1.4.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.marginLeft(4.0f);
                                                    ceVar2.text(str7);
                                                    ceVar2.color(QUIToken.color$default("text_secondary"));
                                                    ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                    ceVar2.fontWeight400();
                                                    ceVar2.textOverFlowTail();
                                                    ceVar2.lines(1);
                                                    ceVar2.m144maxWidth(ceVar2.getPagerData().m() - 50.0f);
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
                    }.invoke(viewContainer2);
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPArticleFeedDetailTagViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
