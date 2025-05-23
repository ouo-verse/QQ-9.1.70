package com.tencent.hippykotlin.demo.pages.game_content_page.category;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ScrollerAttr;
import com.tencent.kuikly.core.views.ScrollerEvent;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.bo;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class GameCategoryBar extends ComposeView<GameCategoryBarAttr, GameCategoryBarEvent> {
    public float contentSizeWidth;
    public aa<ScrollerView<?, ?>> listRef;
    public final GameCategoryBarAttr viewAttr = new GameCategoryBarAttr();
    public ArrayList<aa<GameCategoryBarItemView>> categoryItemRefs = new ArrayList<>();

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GameCategoryBarAttr access$getAttr(GameCategoryBar gameCategoryBar) {
        return (GameCategoryBarAttr) gameCategoryBar.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ GameCategoryBarEvent access$getEvent(GameCategoryBar gameCategoryBar) {
        return (GameCategoryBarEvent) gameCategoryBar.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$onClickItem(final GameCategoryBar gameCategoryBar, final int i3) {
        c<GameCategoryBarItem> items = ((GameCategoryBarAttr) gameCategoryBar.getAttr()).getItems();
        GameCategoryBarAttr gameCategoryBarAttr = (GameCategoryBarAttr) gameCategoryBar.getAttr();
        ReadWriteProperty readWriteProperty = gameCategoryBarAttr.currentIndex$delegate;
        KProperty<?>[] kPropertyArr = GameCategoryBarAttr.$$delegatedProperties;
        GameCategoryBarItem gameCategoryBarItem = items.get(((Number) readWriteProperty.getValue(gameCategoryBarAttr, kPropertyArr[0])).intValue());
        GameCategoryBarItem gameCategoryBarItem2 = ((GameCategoryBarAttr) gameCategoryBar.getAttr()).getItems().get(i3);
        gameCategoryBarItem.setSelected(false);
        gameCategoryBarItem2.setSelected(true);
        GameCategoryBarAttr gameCategoryBarAttr2 = (GameCategoryBarAttr) gameCategoryBar.getAttr();
        gameCategoryBarAttr2.currentIndex$delegate.setValue(gameCategoryBarAttr2, kPropertyArr[0], Integer.valueOf(i3));
        gameCategoryBar.emit("onClickCategoryItem", Integer.valueOf(i3));
        com.tencent.kuikly.core.manager.c.f117352a.g().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar$onClickItem$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                ScrollerView<?, ?> b16;
                float f16;
                float m3;
                ScrollerView<?, ?> b17;
                FlexNode flexNode;
                aa<ScrollerView<?, ?>> aaVar = GameCategoryBar.this.listRef;
                if (aaVar != null && (b16 = aaVar.b()) != null) {
                    GameCategoryBar gameCategoryBar2 = GameCategoryBar.this;
                    GameCategoryBarItemView b18 = gameCategoryBar2.categoryItemRefs.get(i3).b();
                    if (b18 != null) {
                        float f17 = 2;
                        float max = Math.max(((b18.getFlexNode().getLayoutFrame().getWidth() / f17) + b18.getFlexNode().getLayoutFrame().getX()) - (gameCategoryBar2.getPagerData().m() / f17), 0.0f);
                        float f18 = gameCategoryBar2.contentSizeWidth;
                        aa<ScrollerView<?, ?>> aaVar2 = gameCategoryBar2.listRef;
                        if (aaVar2 != null && (b17 = aaVar2.b()) != null && (flexNode = b17.getFlexNode()) != null) {
                            m3 = flexNode.v();
                        } else {
                            m3 = gameCategoryBar2.getPagerData().m();
                        }
                        f16 = Math.min(max, Math.max(f18 - m3, 0.0f));
                    } else {
                        f16 = 0.0f;
                    }
                    ScrollerView.setContentOffset$default(b16, f16, 0.0f, true, null, 8, null);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo141height(48.0f);
                        mVar2.marginLeft(11.0f);
                        mVar2.flexDirectionRow();
                        return Unit.INSTANCE;
                    }
                });
                final GameCategoryBar gameCategoryBar = GameCategoryBar.this;
                bo.a(viewContainer2, new Function1<ScrollerView<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ScrollerView<?, ?> scrollerView) {
                        ScrollerView<?, ?> scrollerView2 = scrollerView;
                        final GameCategoryBar gameCategoryBar2 = GameCategoryBar.this;
                        scrollerView2.ref(scrollerView2, new Function1<aa<ScrollerView<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<ScrollerView<?, ?>> aaVar) {
                                GameCategoryBar.this.listRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        scrollerView2.attr(new Function1<ScrollerAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ScrollerAttr scrollerAttr) {
                                ScrollerAttr scrollerAttr2 = scrollerAttr;
                                scrollerAttr2.m140flex(1.0f);
                                scrollerAttr2.flexDirectionRow();
                                scrollerAttr2.showScrollerIndicator(false);
                                return Unit.INSTANCE;
                            }
                        });
                        final GameCategoryBar gameCategoryBar3 = GameCategoryBar.this;
                        scrollerView2.event(new Function1<ScrollerEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ScrollerEvent scrollerEvent) {
                                final GameCategoryBar gameCategoryBar4 = GameCategoryBar.this;
                                scrollerEvent.contentSizeChanged(new Function2<Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar.body.1.2.3.1
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(Float f16, Float f17) {
                                        float floatValue = f16.floatValue();
                                        f17.floatValue();
                                        GameCategoryBar.this.contentSizeWidth = floatValue;
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final GameCategoryBar gameCategoryBar4 = GameCategoryBar.this;
                        Function0<c<GameCategoryBarItem>> function0 = new Function0<c<GameCategoryBarItem>>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar.body.1.2.4
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final c<GameCategoryBarItem> invoke() {
                                return GameCategoryBar.access$getAttr(GameCategoryBar.this).getItems();
                            }
                        };
                        final GameCategoryBar gameCategoryBar5 = GameCategoryBar.this;
                        LoopDirectivesViewKt.a(scrollerView2, function0, new Function2<LoopDirectivesView<GameCategoryBarItem>, GameCategoryBarItem, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar.body.1.2.5
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<GameCategoryBarItem> loopDirectivesView, GameCategoryBarItem gameCategoryBarItem) {
                                final GameCategoryBarItem gameCategoryBarItem2 = gameCategoryBarItem;
                                final int indexOf = GameCategoryBar.access$getAttr(GameCategoryBar.this).getItems().indexOf(gameCategoryBarItem2);
                                final GameCategoryBar gameCategoryBar6 = GameCategoryBar.this;
                                loopDirectivesView.addChild(new GameCategoryBarItemView(), new Function1<GameCategoryBarItemView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar.body.1.2.5.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(GameCategoryBarItemView gameCategoryBarItemView) {
                                        GameCategoryBarItemView gameCategoryBarItemView2 = gameCategoryBarItemView;
                                        final int i3 = indexOf;
                                        final GameCategoryBar gameCategoryBar7 = gameCategoryBar6;
                                        gameCategoryBarItemView2.ref(gameCategoryBarItemView2, new Function1<aa<GameCategoryBarItemView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar.body.1.2.5.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aa<GameCategoryBarItemView> aaVar) {
                                                aa<GameCategoryBarItemView> aaVar2 = aaVar;
                                                if (i3 == 0) {
                                                    gameCategoryBar7.categoryItemRefs.clear();
                                                }
                                                gameCategoryBar7.categoryItemRefs.add(i3, aaVar2);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GameCategoryBarItem gameCategoryBarItem3 = gameCategoryBarItem2;
                                        gameCategoryBarItemView2.attr(new Function1<GameCategoryBarItemAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar.body.1.2.5.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(GameCategoryBarItemAttr gameCategoryBarItemAttr) {
                                                gameCategoryBarItemAttr.item = GameCategoryBarItem.this;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final GameCategoryBar gameCategoryBar8 = gameCategoryBar6;
                                        final int i16 = indexOf;
                                        gameCategoryBarItemView2.event(new Function1<GameCategoryBarItemEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar.body.1.2.5.1.3
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(GameCategoryBarItemEvent gameCategoryBarItemEvent) {
                                                GameCategoryBarItemEvent gameCategoryBarItemEvent2 = gameCategoryBarItemEvent;
                                                final GameCategoryBar gameCategoryBar9 = GameCategoryBar.this;
                                                final int i17 = i16;
                                                gameCategoryBarItemEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar.body.1.2.5.1.3.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        GameCategoryBar.access$onClickItem(GameCategoryBar.this, i17);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final GameCategoryBar gameCategoryBar10 = GameCategoryBar.this;
                                                gameCategoryBarItemEvent2.didShowSelectItemHandlerFn = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.game_content_page.category.GameCategoryBar.body.1.2.5.1.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        Function1<Object, Unit> function1 = GameCategoryBar.access$getEvent(GameCategoryBar.this).didShowSelectItemHandlerFn;
                                                        if (function1 != null) {
                                                            function1.invoke(obj);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                };
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
        return new GameCategoryBarEvent();
    }
}
