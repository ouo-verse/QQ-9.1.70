package com.tencent.hippykotlin.demo.pages.nearby.interactive.view;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import n25.g;
import r25.e;

/* loaded from: classes31.dex */
public final class NBPInteractiveCommentItemView extends ComposeView<NBPInteractiveCommentItemViewAttr, NBPInteractiveCommentItemViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPInteractiveCommentItemViewAttr access$getAttr(NBPInteractiveCommentItemView nBPInteractiveCommentItemView) {
        return (NBPInteractiveCommentItemViewAttr) nBPInteractiveCommentItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPInteractiveCommentItemViewEvent access$getEvent(NBPInteractiveCommentItemView nBPInteractiveCommentItemView) {
        return (NBPInteractiveCommentItemViewEvent) nBPInteractiveCommentItemView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final g gVar = ((NBPInteractiveCommentItemViewAttr) getAttr()).psvFeed;
        if (gVar == null) {
            gVar = new g(null, null, 0, null, null, null, null, null, 0, null, 1023, null);
        }
        final e eVar = gVar.f418070h;
        if (eVar == null) {
            eVar = new e(0L, null, null, 0, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        }
        final float m3 = getPagerData().m() - 32.0f;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final float f16 = m3;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView$body$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.justifyContentSpaceBetween();
                        mVar2.mo153width(f16);
                        mVar2.marginLeft(16.0f);
                        mVar2.marginTop(16.0f);
                        mVar2.paddingBottom(16.0f);
                        mVar2.positionRelative();
                        return Unit.INSTANCE;
                    }
                });
                final e eVar2 = eVar;
                final NBPInteractiveCommentItemView nBPInteractiveCommentItemView = this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        ImageView imageView2 = imageView;
                        final e eVar3 = e.this;
                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.size(32.0f, 32.0f);
                                afVar2.p();
                                afVar2.borderRadius(16.0f);
                                b.a.b(afVar2, e.this.L, false, 2, null);
                                afVar2.marginRight(16.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPInteractiveCommentItemView nBPInteractiveCommentItemView2 = nBPInteractiveCommentItemView;
                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageEvent imageEvent) {
                                final NBPInteractiveCommentItemView nBPInteractiveCommentItemView3 = NBPInteractiveCommentItemView.this;
                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        Function0<Unit> function0 = NBPInteractiveCommentItemView.access$getEvent(NBPInteractiveCommentItemView.this).avatarClickFn;
                                        if (function0 != null) {
                                            function0.invoke();
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
                final e eVar3 = eVar;
                final g gVar2 = gVar;
                final NBPInteractiveCommentItemView nBPInteractiveCommentItemView2 = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionColumn();
                                tVar2.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final e eVar4 = e.this;
                        final g gVar3 = gVar2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.justifyContentSpaceBetween();
                                        tVar2.flexDirectionRow();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final e eVar5 = e.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final e eVar6 = e.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.text(e.this.J);
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                ceVar2.textPostProcessor("emoji");
                                                ceVar2.fontWeight500();
                                                ceVar2.lineHeight(20.0f);
                                                ceVar2.m144maxWidth(200.0f);
                                                ceVar2.lines(1);
                                                ceVar2.textOverFlowTail();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final g gVar4 = gVar3;
                                InteractiveTimeViewKt.InteractiveTime(vVar4, new Function1<InteractiveTimeView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(InteractiveTimeView interactiveTimeView) {
                                        final g gVar5 = g.this;
                                        interactiveTimeView.attr(new Function1<InteractiveTimeViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(InteractiveTimeViewAttr interactiveTimeViewAttr) {
                                                interactiveTimeViewAttr.createTime = g.this.E;
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final g gVar4 = gVar2;
                        final NBPInteractiveCommentItemView nBPInteractiveCommentItemView3 = nBPInteractiveCommentItemView2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.justifyContentSpaceBetween();
                                        tVar2.flexDirectionRow();
                                        tVar2.marginTop(4.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final g gVar5 = g.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.m140flex(1.0f);
                                                tVar2.marginRight(16.0f);
                                                tVar2.flexDirectionColumn();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final g gVar6 = g.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final g gVar7 = g.this;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.3.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        String str;
                                                        ce ceVar2 = ceVar;
                                                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u8bc4\u8bba\uff1a");
                                                        n25.e eVar5 = g.this.D;
                                                        if (eVar5 == null || (str = eVar5.f418060d) == null) {
                                                            str = "";
                                                        }
                                                        m16.append(str);
                                                        ceVar2.text(m16.toString());
                                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                                        ceVar2.fontWeight400();
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                        ceVar2.textPostProcessor("emoji");
                                                        ceVar2.m140flex(1.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final g gVar7 = g.this;
                                        vVar6.addChild(new InteractiveReplyButtonView(), new Function1<InteractiveReplyButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.3.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(InteractiveReplyButtonView interactiveReplyButtonView) {
                                                final g gVar8 = g.this;
                                                interactiveReplyButtonView.attr(new Function1<InteractiveReplyButtonViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.3.2.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(InteractiveReplyButtonViewAttr interactiveReplyButtonViewAttr) {
                                                        interactiveReplyButtonViewAttr.feed = g.this;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPInteractiveCommentItemView nBPInteractiveCommentItemView4 = nBPInteractiveCommentItemView3;
                                NBPInteractiveThumbnailViewKt.NBPInteractiveThumbnail(vVar4, new Function1<NBPInteractiveThumbnailView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPInteractiveThumbnailView nBPInteractiveThumbnailView) {
                                        final NBPInteractiveCommentItemView nBPInteractiveCommentItemView5 = NBPInteractiveCommentItemView.this;
                                        nBPInteractiveThumbnailView.attr(new Function1<NBPInteractiveThumbnailViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.3.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPInteractiveThumbnailViewAttr nBPInteractiveThumbnailViewAttr) {
                                                nBPInteractiveThumbnailViewAttr.psvFeed = NBPInteractiveCommentItemView.access$getAttr(NBPInteractiveCommentItemView.this).psvFeed;
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
                final float f17 = m3;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final float f18 = f17;
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentItemView.body.1.4.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.positionAbsolute();
                                tVar2.m140flex(1.0f);
                                tVar2.m138bottom(0.0f);
                                tVar2.m142left(0.0f);
                                tVar2.mo141height(0.5f);
                                tVar2.mo153width(f18);
                                tVar2.mo113backgroundColor(QUIToken.color$default("border_standard"));
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
        return new NBPInteractiveCommentItemViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPInteractiveCommentItemViewEvent();
    }
}
