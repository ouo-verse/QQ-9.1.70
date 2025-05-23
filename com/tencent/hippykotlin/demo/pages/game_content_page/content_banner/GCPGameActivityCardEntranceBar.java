package com.tencent.hippykotlin.demo.pages.game_content_page.content_banner;

import com.tencent.hippykotlin.demo.pages.base.SkinColor;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.GameCard;
import com.tencent.hippykotlin.demo.pages.game_content_page.repo.data.game.IconButton;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
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

/* loaded from: classes31.dex */
public final class GCPGameActivityCardEntranceBar extends ComposeView<GCPGameActivityCardEntranceBarAttr, l> {
    public final GCPGameActivityCardEntranceBarAttr viewAttr = new GCPGameActivityCardEntranceBarAttr();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceBar$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceBar$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.justifyContentCenter();
                        return Unit.INSTANCE;
                    }
                });
                final GCPGameActivityCardEntranceBar gCPGameActivityCardEntranceBar = GCPGameActivityCardEntranceBar.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceBar$body$1.2
                    {
                        super(0);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
                    
                        if ((!r0.isEmpty()) != false) goto L8;
                     */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        boolean z16;
                        List<IconButton> list = GCPGameActivityCardEntranceBar.this.viewAttr.dataList;
                        if (list != null) {
                            Intrinsics.checkNotNull(list);
                            z16 = true;
                        }
                        z16 = false;
                        return Boolean.valueOf(z16);
                    }
                };
                final GCPGameActivityCardEntranceBar gCPGameActivityCardEntranceBar2 = GCPGameActivityCardEntranceBar.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceBar$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final GCPGameActivityCardEntranceBar gCPGameActivityCardEntranceBar3 = GCPGameActivityCardEntranceBar.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceBar.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceBar.body.1.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentSpaceBetween();
                                        tVar2.marginLeft(16.0f);
                                        tVar2.marginRight(16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                List<IconButton> list = GCPGameActivityCardEntranceBar.this.viewAttr.dataList;
                                Intrinsics.checkNotNull(list);
                                int size = list.size();
                                for (final int i3 = 0; i3 < size; i3++) {
                                    final GCPGameActivityCardEntranceBar gCPGameActivityCardEntranceBar4 = GCPGameActivityCardEntranceBar.this;
                                    vVar2.addChild(new GCPGameActivityCardEntranceItem(), new Function1<GCPGameActivityCardEntranceItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceBar.body.1.3.1.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(GCPGameActivityCardEntranceItem gCPGameActivityCardEntranceItem) {
                                            final GCPGameActivityCardEntranceBar gCPGameActivityCardEntranceBar5 = GCPGameActivityCardEntranceBar.this;
                                            final int i16 = i3;
                                            gCPGameActivityCardEntranceItem.attr(new Function1<GCPGameActivityCardEntranceItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceBar.body.1.3.1.2.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(GCPGameActivityCardEntranceItemAttr gCPGameActivityCardEntranceItemAttr) {
                                                    GCPGameActivityCardEntranceItemAttr gCPGameActivityCardEntranceItemAttr2 = gCPGameActivityCardEntranceItemAttr;
                                                    GameCard gameCard = GCPGameActivityCardEntranceBar.this.viewAttr.gameData;
                                                    if (gameCard == null) {
                                                        Intrinsics.throwUninitializedPropertyAccessException("gameData");
                                                        gameCard = null;
                                                    }
                                                    gCPGameActivityCardEntranceItemAttr2.gameData = gameCard;
                                                    List<IconButton> list2 = GCPGameActivityCardEntranceBar.this.viewAttr.dataList;
                                                    Intrinsics.checkNotNull(list2);
                                                    gCPGameActivityCardEntranceItemAttr2.buttonData = list2.get(i16);
                                                    GCPGameActivityCardEntranceBarAttr gCPGameActivityCardEntranceBarAttr = GCPGameActivityCardEntranceBar.this.viewAttr;
                                                    gCPGameActivityCardEntranceItemAttr2.gameTab = gCPGameActivityCardEntranceBarAttr.gameTab;
                                                    gCPGameActivityCardEntranceItemAttr2.index = i16;
                                                    gCPGameActivityCardEntranceItemAttr2.pageDidAppearTimes$delegate.setValue(gCPGameActivityCardEntranceItemAttr2, GCPGameActivityCardEntranceItemAttr.$$delegatedProperties[0], Integer.valueOf(((Number) gCPGameActivityCardEntranceBarAttr.pageDidAppearTimes$delegate.getValue(gCPGameActivityCardEntranceBarAttr, GCPGameActivityCardEntranceBarAttr.$$delegatedProperties[0])).intValue()));
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
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceBar$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceBar.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceBar.body.1.4.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentSpaceBetween();
                                        tVar2.marginLeft(16.0f);
                                        tVar2.marginRight(16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceBar.body.1.4.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceBar.body.1.4.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginLeft(5.0f);
                                                ceVar2.color(SkinColor.whiteTextColor);
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.fontFamily("PingFang SC");
                                                ceVar2.text("\u67e5\u770b\u8be6\u60c5");
                                                ceVar2.lines(1);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceBar.body.1.4.1.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.content_banner.GCPGameActivityCardEntranceBar.body.1.4.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
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
                });
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
