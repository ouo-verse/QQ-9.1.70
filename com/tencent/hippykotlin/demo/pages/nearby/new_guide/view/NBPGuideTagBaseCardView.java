package com.tencent.hippykotlin.demo.pages.nearby.new_guide.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.t;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.LoadSuccessParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import t35.a;

/* loaded from: classes31.dex */
public final class NBPGuideTagBaseCardView extends ComposeView<NBPGuideTagBaseCardAttr, NBPGuideTagBaseCardEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPGuideTagBaseCardAttr access$getAttr(NBPGuideTagBaseCardView nBPGuideTagBaseCardView) {
        return (NBPGuideTagBaseCardAttr) nBPGuideTagBaseCardView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPGuideTagBaseCardView nBPGuideTagBaseCardView = NBPGuideTagBaseCardView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        NBPGuideTagBaseCardView nBPGuideTagBaseCardView2 = NBPGuideTagBaseCardView.this;
                        int i3 = NBPGuideTagBaseCardView.$r8$clinit;
                        mVar2.size(nBPGuideTagBaseCardView2.getCardRealWidth(), (NBPGuideTagBaseCardView.this.getCardRealWidth() * 216.0f) / 327.0f);
                        mVar2.allCenter();
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideTagBaseCardView nBPGuideTagBaseCardView2 = NBPGuideTagBaseCardView.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        ImageView imageView2 = imageView;
                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.absolutePositionAllZero();
                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_uDyMxWgD2ws.png", false, 2, null);
                                afVar2.borderRadius(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPGuideTagBaseCardView nBPGuideTagBaseCardView3 = NBPGuideTagBaseCardView.this;
                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageEvent imageEvent) {
                                final NBPGuideTagBaseCardView nBPGuideTagBaseCardView4 = NBPGuideTagBaseCardView.this;
                                imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Multi-variable type inference failed */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                        Function1<? super Boolean, Unit> function1 = ((NBPGuideTagBaseCardEvent) NBPGuideTagBaseCardView.this.getViewEvent()).resLoadedEventHandler;
                                        if (function1 != null) {
                                            function1.invoke(Boolean.TRUE);
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
                final NBPGuideTagBaseCardView nBPGuideTagBaseCardView3 = NBPGuideTagBaseCardView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView$body$1.3
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(NBPGuideTagBaseCardView.access$getAttr(NBPGuideTagBaseCardView.this).getTagList().size() == 0);
                    }
                };
                final NBPGuideTagBaseCardView nBPGuideTagBaseCardView4 = NBPGuideTagBaseCardView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPGuideTagBaseCardView nBPGuideTagBaseCardView5 = NBPGuideTagBaseCardView.this;
                        ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final NBPGuideTagBaseCardView nBPGuideTagBaseCardView6 = NBPGuideTagBaseCardView.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView.body.1.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.positionAbsolute();
                                        NBPGuideTagBaseCardView nBPGuideTagBaseCardView7 = NBPGuideTagBaseCardView.this;
                                        int i3 = NBPGuideTagBaseCardView.$r8$clinit;
                                        afVar2.m150top(((((nBPGuideTagBaseCardView7.getCardRealWidth() * 216.0f) / 327.0f) - ((NBPGuideTagBaseCardView.this.getCardRealWidth() - 120.0f) * 0.32f)) / 2.0f) - 10.0f);
                                        afVar2.m142left(60.0f);
                                        afVar2.size(NBPGuideTagBaseCardView.this.getCardRealWidth() - 120.0f, (NBPGuideTagBaseCardView.this.getCardRealWidth() - 120.0f) * 0.32f);
                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_eWeCDSgk9Js.png", false, 2, null);
                                        afVar2.o();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideTagBaseCardView nBPGuideTagBaseCardView5 = NBPGuideTagBaseCardView.this;
                Function0<c<a>> function02 = new Function0<c<a>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView$body$1.5
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final c<a> invoke() {
                        return NBPGuideTagBaseCardView.access$getAttr(NBPGuideTagBaseCardView.this).getTagList();
                    }
                };
                final NBPGuideTagBaseCardView nBPGuideTagBaseCardView6 = NBPGuideTagBaseCardView.this;
                LoopDirectivesViewKt.b(viewContainer2, function02, new Function4<LoopDirectivesView<a>, a, Integer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView$body$1.6
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public final Unit invoke(LoopDirectivesView<a> loopDirectivesView, a aVar, Integer num, Integer num2) {
                        final a aVar2 = aVar;
                        final int intValue = num.intValue();
                        num2.intValue();
                        final NBPGuideTagBaseCardView nBPGuideTagBaseCardView7 = NBPGuideTagBaseCardView.this;
                        cg.a(loopDirectivesView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView.body.1.6.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final NBPGuideTagBaseCardView nBPGuideTagBaseCardView8 = NBPGuideTagBaseCardView.this;
                                final a aVar3 = aVar2;
                                final int i3 = intValue;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView.body.1.6.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.positionAbsolute();
                                        ceVar2.color(NBPGuideTagBaseCardView.access$getAttr(NBPGuideTagBaseCardView.this).getTagColor());
                                        ceVar2.lines(1);
                                        ceVar2.textOverFlowTail();
                                        ceVar2.text(aVar3.f435363e);
                                        NBPGuideTagPosition nBPGuideTagPosition = NBPGuideTagBaseCardView.access$getAttr(NBPGuideTagBaseCardView.this).getTagPositions().get(i3);
                                        int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(nBPGuideTagPosition.horizontal);
                                        if (ordinal == 0) {
                                            ceVar2.m142left(nBPGuideTagPosition.f114236x);
                                        } else if (ordinal == 1) {
                                            ceVar2.m149right(nBPGuideTagPosition.f114236x);
                                        }
                                        ceVar2.m150top(nBPGuideTagPosition.f114237y);
                                        int i16 = i3;
                                        if (i16 == 0) {
                                            ce.fontSize$default(ceVar2, 30.0f, null, 2, null);
                                            ceVar2.fontWeight500();
                                            ceVar2.m147opacity(1.0f);
                                            ceVar2.fontFamily("PingFang SC");
                                            ceVar2.lineHeight(36.0f);
                                            ceVar2.size(200.0f, 36.0f);
                                            ceVar2.textAlignCenter();
                                            ceVar2.m154zIndex(2);
                                        } else if (i16 < 6) {
                                            ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                            ceVar2.fontWeight500();
                                            ceVar2.m147opacity(0.7f);
                                            ceVar2.m144maxWidth(100.0f);
                                            ceVar2.m154zIndex(1);
                                        } else {
                                            ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                            ceVar2.fontWeight500();
                                            ceVar2.m147opacity(0.3f);
                                            ceVar2.m144maxWidth(100.0f);
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
                final NBPGuideTagBaseCardView nBPGuideTagBaseCardView7 = NBPGuideTagBaseCardView.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView$body$1.7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final NBPGuideTagBaseCardView nBPGuideTagBaseCardView8 = NBPGuideTagBaseCardView.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagBaseCardView.body.1.7.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.size(48.0f, 48.0f);
                                b.a.b(afVar2, NBPGuideTagBaseCardView.access$getAttr(NBPGuideTagBaseCardView.this).getEmojiUrl(), false, 2, null);
                                afVar2.positionAbsolute();
                                Pair<Float, Float> emojiPosition = NBPGuideTagBaseCardView.access$getAttr(NBPGuideTagBaseCardView.this).getEmojiPosition();
                                float floatValue = emojiPosition.component1().floatValue();
                                float floatValue2 = emojiPosition.component2().floatValue();
                                afVar2.m142left(floatValue);
                                afVar2.m150top(floatValue2);
                                afVar2.transform(new t(NBPGuideTagBaseCardView.access$getAttr(NBPGuideTagBaseCardView.this).getEmojiRotation(), 0.0f, 0.0f, 6, null));
                                afVar2.m154zIndex(3);
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
        return new NBPGuideTagBaseCardAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPGuideTagBaseCardEvent();
    }

    public final float getCardRealWidth() {
        return Math.min(getPagerData().m(), 420.0f) - 48.0f;
    }
}
