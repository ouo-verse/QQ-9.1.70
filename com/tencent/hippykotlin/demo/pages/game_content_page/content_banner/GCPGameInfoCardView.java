package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.advertisement.GamePrivilegeInfo;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameCard;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes31.dex */
public final class GCPGameInfoCardView extends ComposeView<GCPActivityInfoViewAttr, GCPActivityInfoViewEvent> {
    public aa<GCPGameEntranceButton> btnRef;
    public aa<v> friendAvatarsRef;
    public aa<TextView> friendPlayTextRef;
    public aa<TextView> titleTextRef;

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean access$canShowGameIcon(GCPGameInfoCardView gCPGameInfoCardView) {
        boolean isBlank;
        if (((GCPActivityInfoViewAttr) gCPGameInfoCardView.getAttr()).showGameIcon) {
            isBlank = StringsKt__StringsJVMKt.isBlank(((GCPActivityInfoViewAttr) gCPGameInfoCardView.getAttr()).getData().gameIcon);
            if (!isBlank) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GCPActivityInfoViewAttr access$getAttr(GCPGameInfoCardView gCPGameInfoCardView) {
        return (GCPActivityInfoViewAttr) gCPGameInfoCardView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final float access$getBtnAreaWidth(GCPGameInfoCardView gCPGameInfoCardView) {
        GCPGameEntranceViewAttr gCPGameEntranceViewAttr;
        FlexNode flexNode;
        aa<GCPGameEntranceButton> aaVar = gCPGameInfoCardView.btnRef;
        if (aaVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnRef");
            aaVar = null;
        }
        GCPGameEntranceButton b16 = aaVar.b();
        if (b16 == null || (gCPGameEntranceViewAttr = (GCPGameEntranceViewAttr) b16.getViewAttr()) == null || (flexNode = gCPGameEntranceViewAttr.getFlexNode()) == null) {
            return 0.0f;
        }
        return flexNode.v();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final GameCard data = ((GCPActivityInfoViewAttr) getAttr()).getData();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        if (SkinColor.INSTANCE.isNightMode(mVar2.getPagerId())) {
                            mVar2.mo113backgroundColor(new h(4281413937L));
                        }
                        return Unit.INSTANCE;
                    }
                });
                final GCPGameInfoCardView gCPGameInfoCardView = GCPGameInfoCardView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final GCPGameInfoCardView gCPGameInfoCardView2 = GCPGameInfoCardView.this;
                        FrameEventKt.d(event, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.2.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(d dVar) {
                                TextView b16;
                                ce ceVar;
                                TextView b17;
                                ce ceVar2;
                                v b18;
                                t tVar;
                                FlexNode flexNode;
                                d dVar2 = dVar;
                                float f16 = 0.0f;
                                float f17 = GCPGameInfoCardView.access$canShowGameIcon(GCPGameInfoCardView.this) ? 62.0f : 0.0f;
                                float width = dVar2.getWidth() - GCPGameInfoCardView.access$getBtnAreaWidth(GCPGameInfoCardView.this);
                                aa<v> aaVar = GCPGameInfoCardView.this.friendAvatarsRef;
                                if (aaVar != null && (b18 = aaVar.b()) != null && (tVar = (t) b18.getViewAttr()) != null && (flexNode = tVar.getFlexNode()) != null) {
                                    f16 = flexNode.v();
                                }
                                float f18 = (width - f16) - (44.0f + f17);
                                aa<TextView> aaVar2 = GCPGameInfoCardView.this.friendPlayTextRef;
                                if (aaVar2 != null && (b17 = aaVar2.b()) != null && (ceVar2 = (ce) b17.getViewAttr()) != null) {
                                    ceVar2.m144maxWidth(f18);
                                }
                                float width2 = (dVar2.getWidth() - GCPGameInfoCardView.access$getBtnAreaWidth(GCPGameInfoCardView.this)) - (f17 + 40.0f);
                                aa<TextView> aaVar3 = GCPGameInfoCardView.this.titleTextRef;
                                if (aaVar3 != null && (b16 = aaVar3.b()) != null && (ceVar = (ce) b16.getViewAttr()) != null) {
                                    ceVar.m144maxWidth(width2);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GCPGameInfoCardView gCPGameInfoCardView2 = GCPGameInfoCardView.this;
                final GameCard gameCard = data;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameInfoCardView gCPGameInfoCardView3 = GCPGameInfoCardView.this;
                        final GameCard gameCard2 = gameCard;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final GCPGameInfoCardView gCPGameInfoCardView4 = GCPGameInfoCardView.this;
                                final GameCard gameCard3 = gameCard2;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.3.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        String str;
                                        af afVar2 = afVar;
                                        afVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                        if (GCPGameInfoCardView.access$getAttr(GCPGameInfoCardView.this).isBigStyle) {
                                            str = gameCard3.backgroundBig;
                                        } else {
                                            str = gameCard3.background;
                                        }
                                        b.a.b(afVar2, str, false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameInfoCardView gCPGameInfoCardView4 = GCPGameInfoCardView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                final GCPGameInfoCardView gCPGameInfoCardView5 = GCPGameInfoCardView.this;
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        if (GCPGameInfoCardView.access$getAttr(GCPGameInfoCardView.this).isBigStyle) {
                                            tVar2.mo141height(72.0f);
                                            Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 4, null);
                                            tVar2.mo135backgroundLinearGradient(Direction.TO_TOP, new j(new h(0, 0, 0, 0.0f), 0.0f), new j(new h(0, 0, 0, 0.35f), 1.0f));
                                        } else {
                                            tVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                            tVar2.mo135backgroundLinearGradient(Direction.TO_LEFT, new j(new h(0, 0, 0, 0.0f), 0.0f), new j(new h(0, 0, 0, 0.35f), 1.0f));
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameInfoCardView gCPGameInfoCardView5 = GCPGameInfoCardView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                final GCPGameInfoCardView gCPGameInfoCardView6 = GCPGameInfoCardView.this;
                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.3.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        if (GCPGameInfoCardView.access$getAttr(GCPGameInfoCardView.this).isBigStyle) {
                                            GCPActivityInfoViewAttr access$getAttr = GCPGameInfoCardView.access$getAttr(GCPGameInfoCardView.this);
                                            if ((access$getAttr.getPagerData().getIsIOS() || access$getAttr.getData().privilege == null) ? false : true) {
                                                tVar2.mo141height(57.0f);
                                            } else {
                                                tVar2.mo141height(38.0f);
                                            }
                                            Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 1, null);
                                        } else {
                                            tVar2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                        }
                                        tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(0, 0, 0, 0.0f), 0.0f), new j(new h(0, 0, 0, 0.35f), 1.0f));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                if (GCPGameInfoCardView.access$canShowGameIcon(GCPGameInfoCardView.this)) {
                    final GCPGameInfoCardView gCPGameInfoCardView3 = GCPGameInfoCardView.this;
                    ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView$body$1.4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ImageView imageView) {
                            final GCPGameInfoCardView gCPGameInfoCardView4 = GCPGameInfoCardView.this;
                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.4.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(af afVar) {
                                    af afVar2 = afVar;
                                    b.a.b(afVar2, GCPGameInfoCardView.access$getAttr(GCPGameInfoCardView.this).getData().gameIcon, false, 2, null);
                                    afVar2.size(50.0f, 50.0f);
                                    afVar2.q();
                                    afVar2.m150top(16.0f);
                                    afVar2.m142left(16.0f);
                                    afVar2.positionAbsolute();
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                final GameCard gameCard2 = data;
                final GCPGameInfoCardView gCPGameInfoCardView4 = GCPGameInfoCardView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView$body$1.5
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final GameCard gameCard3 = GameCard.this;
                        final GCPGameInfoCardView gCPGameInfoCardView5 = gCPGameInfoCardView4;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.5.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
                            
                                if (r0.isEmpty() == true) goto L8;
                             */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                List<String> list = GameCard.this.partnerPortraits;
                                boolean z16 = list != null;
                                if (z16) {
                                    if (GCPGameInfoCardView.access$getAttr(gCPGameInfoCardView5).isBigStyle) {
                                        tVar2.m150top(30.0f);
                                    } else {
                                        tVar2.m150top(33.0f);
                                    }
                                } else {
                                    tVar2.m150top(16.0f);
                                }
                                if (GCPGameInfoCardView.access$canShowGameIcon(gCPGameInfoCardView5)) {
                                    tVar2.m142left(78.0f);
                                } else {
                                    tVar2.m142left(16.0f);
                                }
                                tVar2.positionAbsolute();
                                tVar2.justifyContentCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameInfoCardView gCPGameInfoCardView6 = gCPGameInfoCardView4;
                        final GameCard gameCard4 = GameCard.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.5.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                TextView textView2 = textView;
                                final GCPGameInfoCardView gCPGameInfoCardView7 = GCPGameInfoCardView.this;
                                textView2.ref(textView2, new Function1<aa<TextView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.5.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<TextView> aaVar) {
                                        GCPGameInfoCardView.this.titleTextRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameCard gameCard5 = gameCard4;
                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.5.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.color(h.INSTANCE.m());
                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                        ceVar2.fontFamily("PingFang SC");
                                        ceVar2.fontWeightBold();
                                        ceVar2.fontWeight500();
                                        ceVar2.text(GameCard.this.title);
                                        ceVar2.lines(1);
                                        ceVar2.textOverFlowTail();
                                        ceVar2.mo141height(22.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GameCard gameCard5 = GameCard.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.5.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                if (GameCard.this.partnerPortraits != null) {
                                    return Boolean.valueOf(!r0.isEmpty());
                                }
                                return null;
                            }
                        };
                        final GCPGameInfoCardView gCPGameInfoCardView7 = gCPGameInfoCardView4;
                        final GameCard gameCard6 = GameCard.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.5.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final GCPGameInfoCardView gCPGameInfoCardView8 = GCPGameInfoCardView.this;
                                final GameCard gameCard7 = gameCard6;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.5.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final GCPGameInfoCardView gCPGameInfoCardView9 = GCPGameInfoCardView.this;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.5.4.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                if (GCPGameInfoCardView.access$getAttr(GCPGameInfoCardView.this).isBigStyle) {
                                                    tVar2.marginTop(6.0f);
                                                } else {
                                                    tVar2.marginTop(11.0f);
                                                }
                                                tVar2.positionAbsolute();
                                                tVar2.flexDirectionRow();
                                                tVar2.justifyContentCenter();
                                                tVar2.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GameCard gameCard8 = gameCard7;
                                        final GCPGameInfoCardView gCPGameInfoCardView10 = GCPGameInfoCardView.this;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.5.4.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                final GCPGameInfoCardView gCPGameInfoCardView11 = gCPGameInfoCardView10;
                                                vVar6.ref(vVar6, new Function1<aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.5.4.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<v> aaVar) {
                                                        GCPGameInfoCardView.this.friendAvatarsRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.5.4.1.2.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.allCenter();
                                                        tVar2.flexDirectionRow();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                List<String> list = GameCard.this.partnerPortraits;
                                                if (list != null) {
                                                    int size = list.size();
                                                    for (final int i3 = 0; i3 < size; i3++) {
                                                        final String str = list.get(i3);
                                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView$body$1$5$4$1$2$3$1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                final String str2 = str;
                                                                final int i16 = i3;
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView$body$1$5$4$1$2$3$1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        af afVar2 = afVar;
                                                                        afVar2.mo153width(20.0f);
                                                                        afVar2.mo141height(20.0f);
                                                                        afVar2.borderRadius(10.0f);
                                                                        afVar2.m136border(new e(0.5f, BorderStyle.SOLID, h.INSTANCE.m()));
                                                                        b.a.b(afVar2, str2, false, 2, null);
                                                                        if (i16 != 0) {
                                                                            afVar2.marginLeft(-8.0f);
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
                                        });
                                        final GCPGameInfoCardView gCPGameInfoCardView11 = GCPGameInfoCardView.this;
                                        final GameCard gameCard9 = gameCard7;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.5.4.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                TextView textView2 = textView;
                                                final GCPGameInfoCardView gCPGameInfoCardView12 = GCPGameInfoCardView.this;
                                                textView2.ref(textView2, new Function1<aa<TextView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.5.4.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<TextView> aaVar) {
                                                        GCPGameInfoCardView.this.friendPlayTextRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GameCard gameCard10 = gameCard9;
                                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.5.4.1.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.marginLeft(4.0f);
                                                        ceVar2.color(h.INSTANCE.m());
                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                        ceVar2.fontFamily("PingFang SC");
                                                        ceVar2.text(GameCard.this.partnerDescription);
                                                        ceVar2.lines(1);
                                                        ceVar2.textOverFlowTail();
                                                        ceVar2.fontWeight500();
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
                final GCPGameInfoCardView gCPGameInfoCardView5 = GCPGameInfoCardView.this;
                final GameCard gameCard3 = data;
                viewContainer2.addChild(new GCPGameEntranceButton(), new Function1<GCPGameEntranceButton, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView$body$1.6
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(GCPGameEntranceButton gCPGameEntranceButton) {
                        GCPGameEntranceButton gCPGameEntranceButton2 = gCPGameEntranceButton;
                        final GCPGameInfoCardView gCPGameInfoCardView6 = GCPGameInfoCardView.this;
                        gCPGameEntranceButton2.ref(gCPGameEntranceButton2, new Function1<aa<GCPGameEntranceButton>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.6.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<GCPGameEntranceButton> aaVar) {
                                GCPGameInfoCardView.this.btnRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final GameCard gameCard4 = gameCard3;
                        final GCPGameInfoCardView gCPGameInfoCardView7 = GCPGameInfoCardView.this;
                        gCPGameEntranceButton2.attr(new Function1<GCPGameEntranceViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.6.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GCPGameEntranceViewAttr gCPGameEntranceViewAttr) {
                                GCPGameEntranceViewAttr gCPGameEntranceViewAttr2 = gCPGameEntranceViewAttr;
                                gCPGameEntranceViewAttr2.data = GameCard.this;
                                gCPGameEntranceViewAttr2.gameTab = GCPGameInfoCardView.access$getAttr(gCPGameInfoCardView7).gameTab;
                                gCPGameEntranceViewAttr2.positionAbsolute();
                                if (GCPGameInfoCardView.access$getAttr(gCPGameInfoCardView7).isBigStyle) {
                                    gCPGameEntranceViewAttr2.m150top(25.0f);
                                } else {
                                    gCPGameEntranceViewAttr2.m150top(28.0f);
                                }
                                gCPGameEntranceViewAttr2.m149right(16.0f);
                                gCPGameEntranceViewAttr2.mo141height(32.0f);
                                gCPGameEntranceViewAttr2.alignSelfFlexEnd();
                                gCPGameEntranceViewAttr2.alignSelfCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        final GCPGameInfoCardView gCPGameInfoCardView8 = GCPGameInfoCardView.this;
                        gCPGameEntranceButton2.event(new Function1<GCPGameEntranceViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.6.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(GCPGameEntranceViewEvent gCPGameEntranceViewEvent) {
                                GCPGameEntranceViewEvent gCPGameEntranceViewEvent2 = gCPGameEntranceViewEvent;
                                final GCPGameInfoCardView gCPGameInfoCardView9 = GCPGameInfoCardView.this;
                                gCPGameEntranceViewEvent2.register("statusChange", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.6.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        GCPGameInfoCardView.this.emit("statusChange", obj);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GCPGameInfoCardView gCPGameInfoCardView10 = GCPGameInfoCardView.this;
                                gCPGameEntranceViewEvent2.register("buttonClick", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.6.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        GCPGameInfoCardView.this.emit("buttonClick", obj);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                GCPActivityInfoViewAttr access$getAttr = GCPGameInfoCardView.access$getAttr(GCPGameInfoCardView.this);
                if ((access$getAttr.getPagerData().getIsIOS() || access$getAttr.getData().privilege == null) ? false : true) {
                    final GameCard gameCard4 = data;
                    viewContainer2.addChild(new GCPGameMetaInfoView(), new Function1<GCPGameMetaInfoView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView$body$1.7
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(GCPGameMetaInfoView gCPGameMetaInfoView) {
                            final GameCard gameCard5 = GameCard.this;
                            gCPGameMetaInfoView.attr(new Function1<GCPGameMetaInfoBarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameInfoCardView.body.1.7.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(GCPGameMetaInfoBarAttr gCPGameMetaInfoBarAttr) {
                                    GCPGameMetaInfoBarAttr gCPGameMetaInfoBarAttr2 = gCPGameMetaInfoBarAttr;
                                    GamePrivilegeInfo gamePrivilegeInfo = GameCard.this.privilege;
                                    Intrinsics.checkNotNull(gamePrivilegeInfo);
                                    gCPGameMetaInfoBarAttr2.privilegeInfo = gamePrivilegeInfo;
                                    Attr.absolutePosition$default(gCPGameMetaInfoBarAttr2, 0.0f, 16.0f, 8.0f, 16.0f, 1, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                }
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new GCPActivityInfoViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GCPActivityInfoViewEvent();
    }
}
