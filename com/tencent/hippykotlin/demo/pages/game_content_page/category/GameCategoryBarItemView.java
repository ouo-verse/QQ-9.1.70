package com.tencent.hippykotlin.demo.pages.game_content_page.category;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.d;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameCategoryBarItemView extends ComposeView<GameCategoryBarItemAttr, GameCategoryBarItemEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GameCategoryBarItemView.class, "backgroundImageX", "getBackgroundImageX()F", 0)};
    public final GameCategoryBarItemAttr viewAttr = new GameCategoryBarItemAttr();
    public final ReadWriteProperty backgroundImageX$delegate = c.a(Float.valueOf(0.0f));

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GameCategoryBarItemAttr access$getAttr(GameCategoryBarItemView gameCategoryBarItemView) {
        return (GameCategoryBarItemAttr) gameCategoryBarItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GameCategoryBarItemEvent access$getEvent(GameCategoryBarItemView gameCategoryBarItemView) {
        return (GameCategoryBarItemEvent) gameCategoryBarItemView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                final GameCategoryBarItemView gameCategoryBarItemView = GameCategoryBarItemView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView$body$1.2
                    {
                        super(0);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
                    
                        if (r0.isSelected() == true) goto L8;
                     */
                    @Override // kotlin.jvm.functions.Function0
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invoke() {
                        GameCategoryBarItem item = GameCategoryBarItemView.access$getAttr(GameCategoryBarItemView.this).getItem();
                        boolean z16 = item != null;
                        return Boolean.valueOf(z16);
                    }
                };
                final GameCategoryBarItemView gameCategoryBarItemView2 = GameCategoryBarItemView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final GameCategoryBarItemView gameCategoryBarItemView3 = GameCategoryBarItemView.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView.body.1.3.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.absolutePositionAllZero();
                                        tVar2.allCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameCategoryBarItemView gameCategoryBarItemView4 = GameCategoryBarItemView.this;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView.body.1.3.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final GameCategoryBarItemView gameCategoryBarItemView5 = GameCategoryBarItemView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView.body.1.3.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(36.0f, 36.0f);
                                                GameCategoryBarItemView gameCategoryBarItemView6 = GameCategoryBarItemView.this;
                                                afVar2.marginLeft(((Number) gameCategoryBarItemView6.backgroundImageX$delegate.getValue(gameCategoryBarItemView6, GameCategoryBarItemView.$$delegatedProperties[0])).floatValue());
                                                b.a.b(afVar2, "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/rOvCTjwR.png", false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameCategoryBarItemView gameCategoryBarItemView5 = GameCategoryBarItemView.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView.body.1.3.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final GameCategoryBarItemView gameCategoryBarItemView6 = GameCategoryBarItemView.this;
                                        FrameEventKt.d(uVar, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView.body.1.3.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(d dVar) {
                                                GameCategoryBarItemView gameCategoryBarItemView7 = GameCategoryBarItemView.this;
                                                gameCategoryBarItemView7.backgroundImageX$delegate.setValue(gameCategoryBarItemView7, GameCategoryBarItemView.$$delegatedProperties[0], Float.valueOf((dVar.getWidth() - 36.0f) / 2));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                Function1<Object, Unit> function1 = GameCategoryBarItemView.access$getEvent(GameCategoryBarItemView.this).didShowSelectItemHandlerFn;
                                if (function1 != null) {
                                    function1.invoke(GameCategoryBarItemView.access$getAttr(GameCategoryBarItemView.this).getItem());
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final GameCategoryBarItemView gameCategoryBarItemView3 = GameCategoryBarItemView.this;
                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(GameCategoryBarItemView.access$getAttr(GameCategoryBarItemView.this).getItem().isSelected());
                    }
                };
                final GameCategoryBarItemView gameCategoryBarItemView4 = GameCategoryBarItemView.this;
                BindDirectivesViewKt.a(viewContainer2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                        final GameCategoryBarItemView gameCategoryBarItemView5 = GameCategoryBarItemView.this;
                        w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView.body.1.5.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.marginLeft(13.0f).marginRight(13.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameCategoryBarItemView gameCategoryBarItemView6 = GameCategoryBarItemView.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView.body.1.5.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final GameCategoryBarItemView gameCategoryBarItemView7 = GameCategoryBarItemView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView.body.1.5.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                if (GameCategoryBarItemView.access$getAttr(GameCategoryBarItemView.this).getItem().isSelected()) {
                                                    ceVar2.fontWeight600();
                                                    ceVar2.color(new h(4278229503L));
                                                } else {
                                                    ceVar2.fontWeight400();
                                                    ceVar2.color(new h(4288256409L));
                                                }
                                                ceVar2.lineHeight(20.0f);
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                GameCategoryBarItem item = GameCategoryBarItemView.access$getAttr(GameCategoryBarItemView.this).getItem();
                                                ceVar2.value((String) item.itemText$delegate.getValue(item, GameCategoryBarItem.$$delegatedProperties[0]));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final GameCategoryBarItemView gameCategoryBarItemView7 = GameCategoryBarItemView.this;
                                ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView.body.1.5.1.3
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        GameCategoryBarItem item = GameCategoryBarItemView.access$getAttr(GameCategoryBarItemView.this).getItem();
                                        return Boolean.valueOf(((Boolean) item.showRedPoint$delegate.getValue(item, GameCategoryBarItem.$$delegatedProperties[2])).booleanValue());
                                    }
                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView.body.1.5.1.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView.body.1.5.1.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar3) {
                                                vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBarItemView.body.1.5.1.4.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        Attr.absolutePosition$default(tVar2, -4.5f, 0.0f, 0.0f, -4.5f, 6, null);
                                                        tVar2.size(9.0f, 9.0f);
                                                        tVar2.mo113backgroundColor(new h(4294396976L));
                                                        tVar2.borderRadius(4.5f);
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return this.viewAttr;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new GameCategoryBarItemEvent();
    }
}
