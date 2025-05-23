package com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ModalView;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.bb;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieBottomBubbleTipView extends ComposeView<AdelieBottomBubbleTipViewAttr, AdelieBottomBubbleTipViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AdelieBottomBubbleTipView.class, "textWidth", "getTextWidth()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AdelieBottomBubbleTipView.class, "textHeight", "getTextHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AdelieBottomBubbleTipView.class, "bubbleWidth", "getBubbleWidth()F", 0)};
    public final ReadWriteProperty bubbleWidth$delegate;
    public final ReadWriteProperty textHeight$delegate;
    public final ReadWriteProperty textWidth$delegate;

    public AdelieBottomBubbleTipView() {
        Float valueOf = Float.valueOf(0.0f);
        this.textWidth$delegate = c.a(valueOf);
        this.textHeight$delegate = c.a(valueOf);
        this.bubbleWidth$delegate = c.a(valueOf);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ AdelieBottomBubbleTipViewAttr access$getAttr(AdelieBottomBubbleTipView adelieBottomBubbleTipView) {
        return (AdelieBottomBubbleTipViewAttr) adelieBottomBubbleTipView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ AdelieBottomBubbleTipViewEvent access$getEvent(AdelieBottomBubbleTipView adelieBottomBubbleTipView) {
        return (AdelieBottomBubbleTipViewEvent) adelieBottomBubbleTipView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final AdelieBottomBubbleTipView adelieBottomBubbleTipView = AdelieBottomBubbleTipView.this;
                bb.b(viewContainer, false, new Function1<ModalView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ModalView modalView) {
                        ModalView modalView2 = modalView;
                        final AdelieBottomBubbleTipView adelieBottomBubbleTipView2 = AdelieBottomBubbleTipView.this;
                        modalView2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(m mVar) {
                                m mVar2 = mVar;
                                mVar2.mo113backgroundColor(h.INSTANCE.j());
                                AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this).getClass();
                                mVar2.m151touchEnable(false);
                                return Unit.INSTANCE;
                            }
                        });
                        final AdelieBottomBubbleTipView adelieBottomBubbleTipView3 = AdelieBottomBubbleTipView.this;
                        modalView2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Event event) {
                                Event event2 = event;
                                AdelieBottomBubbleTipViewAttr access$getAttr = AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this);
                                if (((Boolean) access$getAttr.enableClickOutSideDissmis$delegate.getValue(access$getAttr, AdelieBottomBubbleTipViewAttr.$$delegatedProperties[4])).booleanValue()) {
                                    final AdelieBottomBubbleTipView adelieBottomBubbleTipView4 = AdelieBottomBubbleTipView.this;
                                    event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.body.1.1.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ClickParams clickParams) {
                                            Function0<Unit> function0 = AdelieBottomBubbleTipView.access$getEvent(AdelieBottomBubbleTipView.this).clickHandler;
                                            if (function0 != null) {
                                                function0.invoke();
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final AdelieBottomBubbleTipView adelieBottomBubbleTipView4 = AdelieBottomBubbleTipView.this;
                        w.a(modalView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final AdelieBottomBubbleTipView adelieBottomBubbleTipView5 = AdelieBottomBubbleTipView.this;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.body.1.1.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        float floatValue;
                                        t tVar2 = tVar;
                                        tVar2.flexDirectionColumn();
                                        float anchorX = AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this).getAnchorX();
                                        floatValue = ((Number) r1.bubbleWidth$delegate.getValue(AdelieBottomBubbleTipView.this, AdelieBottomBubbleTipView.$$delegatedProperties[2])).floatValue();
                                        float max = Math.max((anchorX - (floatValue * 0.233f)) - 7.0f, 20.0f);
                                        AdelieBottomBubbleTipView adelieBottomBubbleTipView6 = AdelieBottomBubbleTipView.this;
                                        ReadWriteProperty readWriteProperty = adelieBottomBubbleTipView6.textWidth$delegate;
                                        KProperty<?>[] kPropertyArr = AdelieBottomBubbleTipView.$$delegatedProperties;
                                        float f16 = 32.0f;
                                        if (((Number) readWriteProperty.getValue(adelieBottomBubbleTipView6, kPropertyArr[0])).floatValue() <= (tVar2.getPagerData().m() - 32.0f) - max) {
                                            FloatCompanionObject floatCompanionObject = FloatCompanionObject.INSTANCE;
                                            f16 = Float.NaN;
                                        }
                                        if (AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this).direction == 2) {
                                            AdelieBottomBubbleTipViewAttr access$getAttr = AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this);
                                            Attr.absolutePosition$default(tVar2, 2.0f + ((Number) access$getAttr.anchorY$delegate.getValue(access$getAttr, AdelieBottomBubbleTipViewAttr.$$delegatedProperties[2])).floatValue(), max, 0.0f, f16, 4, null);
                                        } else {
                                            AdelieBottomBubbleTipViewAttr access$getAttr2 = AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this);
                                            float floatValue2 = ((Number) access$getAttr2.anchorY$delegate.getValue(access$getAttr2, AdelieBottomBubbleTipViewAttr.$$delegatedProperties[2])).floatValue() - 25.0f;
                                            AdelieBottomBubbleTipView adelieBottomBubbleTipView7 = AdelieBottomBubbleTipView.this;
                                            Attr.absolutePosition$default(tVar2, floatValue2 - ((Number) adelieBottomBubbleTipView7.textHeight$delegate.getValue(adelieBottomBubbleTipView7, kPropertyArr[1])).floatValue(), max, 0.0f, f16, 4, null);
                                        }
                                        AdelieBottomBubbleTipViewAttr access$getAttr3 = AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this);
                                        tVar2.m144maxWidth(((Number) access$getAttr3.bubbleMaxWidth$delegate.getValue(access$getAttr3, AdelieBottomBubbleTipViewAttr.$$delegatedProperties[0])).floatValue());
                                        return Unit.INSTANCE;
                                    }
                                });
                                final AdelieBottomBubbleTipView adelieBottomBubbleTipView6 = AdelieBottomBubbleTipView.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.body.1.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        u uVar2 = uVar;
                                        final AdelieBottomBubbleTipView adelieBottomBubbleTipView7 = AdelieBottomBubbleTipView.this;
                                        FrameEventKt.d(uVar2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.body.1.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(d dVar) {
                                                AdelieBottomBubbleTipView adelieBottomBubbleTipView8 = AdelieBottomBubbleTipView.this;
                                                adelieBottomBubbleTipView8.bubbleWidth$delegate.setValue(adelieBottomBubbleTipView8, AdelieBottomBubbleTipView.$$delegatedProperties[2], Float.valueOf(dVar.getWidth()));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final AdelieBottomBubbleTipView adelieBottomBubbleTipView8 = AdelieBottomBubbleTipView.this;
                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.body.1.1.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                Function0<Unit> function0 = AdelieBottomBubbleTipView.access$getEvent(AdelieBottomBubbleTipView.this).clickHandler;
                                                if (function0 != null) {
                                                    function0.invoke();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this).direction == 2) {
                                    final AdelieBottomBubbleTipView adelieBottomBubbleTipView7 = AdelieBottomBubbleTipView.this;
                                    final int i3 = AdelieBottomBubbleTipView.access$getAttr(adelieBottomBubbleTipView7).direction;
                                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView$arrow$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            final AdelieBottomBubbleTipView adelieBottomBubbleTipView8 = AdelieBottomBubbleTipView.this;
                                            final int i16 = i3;
                                            ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView$arrow$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    final AdelieBottomBubbleTipView adelieBottomBubbleTipView9 = AdelieBottomBubbleTipView.this;
                                                    final int i17 = i16;
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.arrow.1.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            float floatValue;
                                                            float floatValue2;
                                                            af afVar2 = afVar;
                                                            float anchorX = AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this).getAnchorX();
                                                            floatValue = ((Number) r1.bubbleWidth$delegate.getValue(AdelieBottomBubbleTipView.this, AdelieBottomBubbleTipView.$$delegatedProperties[2])).floatValue();
                                                            float max = Math.max((anchorX - (floatValue * 0.233f)) - 7.0f, 20.0f);
                                                            floatValue2 = ((Number) r3.bubbleWidth$delegate.getValue(AdelieBottomBubbleTipView.this, AdelieBottomBubbleTipView.$$delegatedProperties[2])).floatValue();
                                                            float f16 = floatValue2 * 0.233f;
                                                            if (max + f16 > AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this).getAnchorX()) {
                                                                f16 = (AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this).getAnchorX() - max) - 7.0f;
                                                            }
                                                            afVar2.marginLeft(f16);
                                                            if (i17 == 1) {
                                                                afVar2.marginTop(-1.0f);
                                                            }
                                                            afVar2.size(14.0f, 7.0f);
                                                            if (i17 == 2) {
                                                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACEAAAAPBAMAAACYbLsaAAAAGFBMVEUAAAD///////////////////////////8jfp1fAAAAB3RSTlMAgF8w78+/tL6sOgAAAFBJREFUGNNVyjEOgCAQBVHUC9jZ2tlaGC9g4Xk0mn99ILAMO+Xkhdr578E13br8OaTPoVGptz+bcqsjIEhFEBAENKj1lLOIZiMgCMgIyAgoAuhbPKAB1U3ZAAAAAElFTkSuQmCC", false, 2, null);
                                                            } else {
                                                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACEAAAAPCAYAAABqQqYpAAAAAXNSR0IArs4c6QAAAFBlWElmTU0AKgAAAAgAAgESAAMAAAABAAEAAIdpAAQAAAABAAAAJgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAIaADAAQAAAABAAAADwAAAAB6bD97AAABWWlUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iWE1QIENvcmUgNi4wLjAiPgogICA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPgogICAgICA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIgogICAgICAgICAgICB4bWxuczp0aWZmPSJodHRwOi8vbnMuYWRvYmUuY29tL3RpZmYvMS4wLyI+CiAgICAgICAgIDx0aWZmOk9yaWVudGF0aW9uPjE8L3RpZmY6T3JpZW50YXRpb24+CiAgICAgIDwvcmRmOkRlc2NyaXB0aW9uPgogICA8L3JkZjpSREY+CjwveDp4bXBtZXRhPgoZXuEHAAAAh0lEQVQ4EcXSAQqAIAwFULuRN/Io2ck6QkfpCPYXDjQkas45+AxE9E1cUkrRObcis2q7LyYIMqNiNTkE1pAawBpDSBtgCHkHGEC+AQpIUP6pgc/+1YHQgsgArFWA9AEUIDqADoguQAAZAyggHv/kRFpF6573Du10EfKE2AF4ugw50Kl2RPwCFw7L3rzv+3mAAAAAAElFTkSuQmCC", false, 2, null);
                                                            }
                                                            afVar2.t(QUIToken.color$default("bg_bottom_light"));
                                                            afVar2.m154zIndex(2);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    }.invoke(vVar2);
                                    final AdelieBottomBubbleTipView adelieBottomBubbleTipView8 = AdelieBottomBubbleTipView.this;
                                    final int i16 = AdelieBottomBubbleTipView.access$getAttr(adelieBottomBubbleTipView8).direction;
                                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView$content$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            final AdelieBottomBubbleTipView adelieBottomBubbleTipView9 = AdelieBottomBubbleTipView.this;
                                            final int i17 = i16;
                                            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView$content$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    final int i18 = i17;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.content.1.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                                                            tVar2.borderRadius(8.0f);
                                                            if (tVar2.getPagerData().getIsIOS()) {
                                                                tVar2.mo139boxShadow(new g(0.0f, i18 == 2 ? -6.5f : 6.5f, 6.0f, new h(436207616L)));
                                                            } else {
                                                                tVar2.mo139boxShadow(new g(0.0f, i18 == 2 ? -2.0f : 2.0f, 6.0f, new h(436207616L)));
                                                            }
                                                            tVar2.m154zIndex(1);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final AdelieBottomBubbleTipView adelieBottomBubbleTipView10 = adelieBottomBubbleTipView9;
                                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.content.1.1.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            TextView textView2 = textView;
                                                            final AdelieBottomBubbleTipView adelieBottomBubbleTipView11 = AdelieBottomBubbleTipView.this;
                                                            textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.content.1.1.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.marginTop(8.0f);
                                                                    ceVar2.marginBottom(8.0f);
                                                                    ceVar2.marginLeft(6.0f);
                                                                    ceVar2.marginRight(6.0f);
                                                                    ceVar2.fontFamily("PingFang SC");
                                                                    ceVar2.fontWeight400();
                                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                    ceVar2.lineHeight(18.0f);
                                                                    ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                    AdelieBottomBubbleTipViewAttr access$getAttr = AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this);
                                                                    ceVar2.text((String) access$getAttr.bubbleTipMsg$delegate.getValue(access$getAttr, AdelieBottomBubbleTipViewAttr.$$delegatedProperties[3]));
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final AdelieBottomBubbleTipView adelieBottomBubbleTipView12 = AdelieBottomBubbleTipView.this;
                                                            textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.content.1.1.2.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(TextEvent textEvent) {
                                                                    final AdelieBottomBubbleTipView adelieBottomBubbleTipView13 = AdelieBottomBubbleTipView.this;
                                                                    FrameEventKt.d(textEvent, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.content.1.1.2.2.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(d dVar) {
                                                                            d dVar2 = dVar;
                                                                            AdelieBottomBubbleTipView adelieBottomBubbleTipView14 = AdelieBottomBubbleTipView.this;
                                                                            float width = dVar2.getWidth();
                                                                            ReadWriteProperty readWriteProperty = adelieBottomBubbleTipView14.textWidth$delegate;
                                                                            KProperty<?>[] kPropertyArr = AdelieBottomBubbleTipView.$$delegatedProperties;
                                                                            readWriteProperty.setValue(adelieBottomBubbleTipView14, kPropertyArr[0], Float.valueOf(width));
                                                                            AdelieBottomBubbleTipView adelieBottomBubbleTipView15 = AdelieBottomBubbleTipView.this;
                                                                            adelieBottomBubbleTipView15.textHeight$delegate.setValue(adelieBottomBubbleTipView15, kPropertyArr[1], Float.valueOf(dVar2.getHeight()));
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
                                    }.invoke(vVar2);
                                } else {
                                    final AdelieBottomBubbleTipView adelieBottomBubbleTipView9 = AdelieBottomBubbleTipView.this;
                                    final int i17 = AdelieBottomBubbleTipView.access$getAttr(adelieBottomBubbleTipView9).direction;
                                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView$content$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            final AdelieBottomBubbleTipView adelieBottomBubbleTipView92 = AdelieBottomBubbleTipView.this;
                                            final int i172 = i17;
                                            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView$content$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar3) {
                                                    v vVar4 = vVar3;
                                                    final int i18 = i172;
                                                    vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.content.1.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                                                            tVar2.borderRadius(8.0f);
                                                            if (tVar2.getPagerData().getIsIOS()) {
                                                                tVar2.mo139boxShadow(new g(0.0f, i18 == 2 ? -6.5f : 6.5f, 6.0f, new h(436207616L)));
                                                            } else {
                                                                tVar2.mo139boxShadow(new g(0.0f, i18 == 2 ? -2.0f : 2.0f, 6.0f, new h(436207616L)));
                                                            }
                                                            tVar2.m154zIndex(1);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final AdelieBottomBubbleTipView adelieBottomBubbleTipView10 = adelieBottomBubbleTipView92;
                                                    cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.content.1.1.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            TextView textView2 = textView;
                                                            final AdelieBottomBubbleTipView adelieBottomBubbleTipView11 = AdelieBottomBubbleTipView.this;
                                                            textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.content.1.1.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    ceVar2.marginTop(8.0f);
                                                                    ceVar2.marginBottom(8.0f);
                                                                    ceVar2.marginLeft(6.0f);
                                                                    ceVar2.marginRight(6.0f);
                                                                    ceVar2.fontFamily("PingFang SC");
                                                                    ceVar2.fontWeight400();
                                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                    ceVar2.lineHeight(18.0f);
                                                                    ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                    AdelieBottomBubbleTipViewAttr access$getAttr = AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this);
                                                                    ceVar2.text((String) access$getAttr.bubbleTipMsg$delegate.getValue(access$getAttr, AdelieBottomBubbleTipViewAttr.$$delegatedProperties[3]));
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final AdelieBottomBubbleTipView adelieBottomBubbleTipView12 = AdelieBottomBubbleTipView.this;
                                                            textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.content.1.1.2.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(TextEvent textEvent) {
                                                                    final AdelieBottomBubbleTipView adelieBottomBubbleTipView13 = AdelieBottomBubbleTipView.this;
                                                                    FrameEventKt.d(textEvent, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.content.1.1.2.2.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(d dVar) {
                                                                            d dVar2 = dVar;
                                                                            AdelieBottomBubbleTipView adelieBottomBubbleTipView14 = AdelieBottomBubbleTipView.this;
                                                                            float width = dVar2.getWidth();
                                                                            ReadWriteProperty readWriteProperty = adelieBottomBubbleTipView14.textWidth$delegate;
                                                                            KProperty<?>[] kPropertyArr = AdelieBottomBubbleTipView.$$delegatedProperties;
                                                                            readWriteProperty.setValue(adelieBottomBubbleTipView14, kPropertyArr[0], Float.valueOf(width));
                                                                            AdelieBottomBubbleTipView adelieBottomBubbleTipView15 = AdelieBottomBubbleTipView.this;
                                                                            adelieBottomBubbleTipView15.textHeight$delegate.setValue(adelieBottomBubbleTipView15, kPropertyArr[1], Float.valueOf(dVar2.getHeight()));
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
                                    }.invoke(vVar2);
                                    final AdelieBottomBubbleTipView adelieBottomBubbleTipView10 = AdelieBottomBubbleTipView.this;
                                    final int i18 = AdelieBottomBubbleTipView.access$getAttr(adelieBottomBubbleTipView10).direction;
                                    new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView$arrow$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                            final AdelieBottomBubbleTipView adelieBottomBubbleTipView82 = AdelieBottomBubbleTipView.this;
                                            final int i162 = i18;
                                            ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView$arrow$1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    final AdelieBottomBubbleTipView adelieBottomBubbleTipView92 = AdelieBottomBubbleTipView.this;
                                                    final int i172 = i162;
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.AdelieBottomBubbleTipView.arrow.1.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            float floatValue;
                                                            float floatValue2;
                                                            af afVar2 = afVar;
                                                            float anchorX = AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this).getAnchorX();
                                                            floatValue = ((Number) r1.bubbleWidth$delegate.getValue(AdelieBottomBubbleTipView.this, AdelieBottomBubbleTipView.$$delegatedProperties[2])).floatValue();
                                                            float max = Math.max((anchorX - (floatValue * 0.233f)) - 7.0f, 20.0f);
                                                            floatValue2 = ((Number) r3.bubbleWidth$delegate.getValue(AdelieBottomBubbleTipView.this, AdelieBottomBubbleTipView.$$delegatedProperties[2])).floatValue();
                                                            float f16 = floatValue2 * 0.233f;
                                                            if (max + f16 > AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this).getAnchorX()) {
                                                                f16 = (AdelieBottomBubbleTipView.access$getAttr(AdelieBottomBubbleTipView.this).getAnchorX() - max) - 7.0f;
                                                            }
                                                            afVar2.marginLeft(f16);
                                                            if (i172 == 1) {
                                                                afVar2.marginTop(-1.0f);
                                                            }
                                                            afVar2.size(14.0f, 7.0f);
                                                            if (i172 == 2) {
                                                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACEAAAAPBAMAAACYbLsaAAAAGFBMVEUAAAD///////////////////////////8jfp1fAAAAB3RSTlMAgF8w78+/tL6sOgAAAFBJREFUGNNVyjEOgCAQBVHUC9jZ2tlaGC9g4Xk0mn99ILAMO+Xkhdr578E13br8OaTPoVGptz+bcqsjIEhFEBAENKj1lLOIZiMgCMgIyAgoAuhbPKAB1U3ZAAAAAElFTkSuQmCC", false, 2, null);
                                                            } else {
                                                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACEAAAAPCAYAAABqQqYpAAAAAXNSR0IArs4c6QAAAFBlWElmTU0AKgAAAAgAAgESAAMAAAABAAEAAIdpAAQAAAABAAAAJgAAAAAAA6ABAAMAAAABAAEAAKACAAQAAAABAAAAIaADAAQAAAABAAAADwAAAAB6bD97AAABWWlUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iWE1QIENvcmUgNi4wLjAiPgogICA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPgogICAgICA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIgogICAgICAgICAgICB4bWxuczp0aWZmPSJodHRwOi8vbnMuYWRvYmUuY29tL3RpZmYvMS4wLyI+CiAgICAgICAgIDx0aWZmOk9yaWVudGF0aW9uPjE8L3RpZmY6T3JpZW50YXRpb24+CiAgICAgIDwvcmRmOkRlc2NyaXB0aW9uPgogICA8L3JkZjpSREY+CjwveDp4bXBtZXRhPgoZXuEHAAAAh0lEQVQ4EcXSAQqAIAwFULuRN/Io2ck6QkfpCPYXDjQkas45+AxE9E1cUkrRObcis2q7LyYIMqNiNTkE1pAawBpDSBtgCHkHGEC+AQpIUP6pgc/+1YHQgsgArFWA9AEUIDqADoguQAAZAyggHv/kRFpF6573Du10EfKE2AF4ugw50Kl2RPwCFw7L3rzv+3mAAAAAAElFTkSuQmCC", false, 2, null);
                                                            }
                                                            afVar2.t(QUIToken.color$default("bg_bottom_light"));
                                                            afVar2.m154zIndex(2);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    }.invoke(vVar2);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                }, 1, null);
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new AdelieBottomBubbleTipViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new AdelieBottomBubbleTipViewEvent();
    }
}
