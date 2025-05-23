package com.tencent.hippykotlin.demo.pages.nearby.interactive.view;

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
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import n25.g;
import r25.e;

/* loaded from: classes31.dex */
public final class NBPInteractiveCommentReplyItemView extends ComposeView<NBPInteractiveCommentReplyItemViewAttr, NBPInteractiveCommentReplyItemViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPInteractiveCommentReplyItemViewAttr access$getAttr(NBPInteractiveCommentReplyItemView nBPInteractiveCommentReplyItemView) {
        return (NBPInteractiveCommentReplyItemViewAttr) nBPInteractiveCommentReplyItemView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPInteractiveCommentReplyItemViewEvent access$getEvent(NBPInteractiveCommentReplyItemView nBPInteractiveCommentReplyItemView) {
        return (NBPInteractiveCommentReplyItemViewEvent) nBPInteractiveCommentReplyItemView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        g gVar = ((NBPInteractiveCommentReplyItemViewAttr) getAttr()).psvFeed;
        if (gVar == null) {
            gVar = new g(null, null, 0, null, null, null, null, null, 0, null, 1023, null);
        }
        e eVar = gVar.f418070h;
        if (eVar == null) {
            eVar = new e(0L, null, null, 0, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        }
        final e eVar2 = eVar;
        e eVar3 = gVar.f418071i;
        if (eVar3 == null) {
            eVar3 = new e(0L, null, null, 0, null, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
        }
        final e eVar4 = eVar3;
        final float m3 = getPagerData().m() - 32.0f;
        final g gVar2 = gVar;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final float f16 = m3;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView$body$1.1
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
                final e eVar5 = eVar2;
                final NBPInteractiveCommentReplyItemView nBPInteractiveCommentReplyItemView = this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        ImageView imageView2 = imageView;
                        final e eVar6 = e.this;
                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.2.1
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
                        final NBPInteractiveCommentReplyItemView nBPInteractiveCommentReplyItemView2 = nBPInteractiveCommentReplyItemView;
                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageEvent imageEvent) {
                                final NBPInteractiveCommentReplyItemView nBPInteractiveCommentReplyItemView3 = NBPInteractiveCommentReplyItemView.this;
                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        Function0<Unit> function0 = NBPInteractiveCommentReplyItemView.access$getEvent(NBPInteractiveCommentReplyItemView.this).avatarClickFn;
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
                final e eVar6 = eVar2;
                final g gVar3 = gVar2;
                final e eVar7 = eVar4;
                final NBPInteractiveCommentReplyItemView nBPInteractiveCommentReplyItemView2 = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionColumn();
                                return Unit.INSTANCE;
                            }
                        });
                        final e eVar8 = e.this;
                        final g gVar4 = gVar3;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.justifyContentSpaceBetween();
                                        tVar2.flexDirectionRow();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final e eVar9 = e.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final e eVar10 = e.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.2.2.1
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
                                final g gVar5 = gVar4;
                                InteractiveTimeViewKt.InteractiveTime(vVar4, new Function1<InteractiveTimeView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(InteractiveTimeView interactiveTimeView) {
                                        final g gVar6 = g.this;
                                        interactiveTimeView.attr(new Function1<InteractiveTimeViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.2.3.1
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
                        final e eVar9 = eVar7;
                        final g gVar5 = gVar3;
                        final NBPInteractiveCommentReplyItemView nBPInteractiveCommentReplyItemView3 = nBPInteractiveCommentReplyItemView2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.m140flex(1.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentSpaceBetween();
                                        tVar2.marginTop(4.0f);
                                        tVar2.m149right(0.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final e eVar10 = e.this;
                                final g gVar6 = gVar5;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.3.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.m140flex(1.0f);
                                                tVar2.flexDirectionColumn();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final e eVar11 = e.this;
                                        final g gVar7 = gVar6;
                                        RichTextViewKt.b(vVar6, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.3.2.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(RichTextView richTextView) {
                                                RichTextView richTextView2 = richTextView;
                                                richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.3.2.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(RichTextAttr richTextAttr) {
                                                        RichTextAttr richTextAttr2 = richTextAttr;
                                                        richTextAttr2.textPostProcessor("emoji");
                                                        richTextAttr2.m140flex(1.0f);
                                                        richTextAttr2.marginRight(16.0f);
                                                        richTextAttr2.color(QUIToken.color$default("text_primary"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.3.2.2.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(cf cfVar) {
                                                        cf cfVar2 = cfVar;
                                                        ce.fontSize$default(cfVar2, 14.0f, null, 2, null);
                                                        cfVar2.text("\u56de\u590d\u4e86");
                                                        cfVar2.fontWeight400();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final e eVar12 = e.this;
                                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.3.2.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(cf cfVar) {
                                                        cf cfVar2 = cfVar;
                                                        String str = e.this.J;
                                                        if (str.length() > 15) {
                                                            StringBuilder sb5 = new StringBuilder();
                                                            String substring = str.substring(0, 15);
                                                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                            sb5.append(substring);
                                                            sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                                                            str = sb5.toString();
                                                        }
                                                        ce.fontSize$default(cfVar2, 14.0f, null, 2, null);
                                                        cfVar2.text(str);
                                                        cfVar2.fontWeight400();
                                                        cfVar2.color(QUIToken.color$default("text_secondary"));
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final g gVar8 = gVar7;
                                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.3.2.2.4
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(cf cfVar) {
                                                        String str;
                                                        cf cfVar2 = cfVar;
                                                        cfVar2.fontWeight400();
                                                        ce.fontSize$default(cfVar2, 14.0f, null, 2, null);
                                                        StringBuilder sb5 = new StringBuilder();
                                                        sb5.append(MsgSummary.STR_COLON);
                                                        n25.e eVar13 = g.this.D;
                                                        if (eVar13 == null || (str = eVar13.f418060d) == null) {
                                                            str = "";
                                                        }
                                                        sb5.append(str);
                                                        cfVar2.text(sb5.toString());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final g gVar8 = gVar6;
                                        vVar6.addChild(new InteractiveReplyButtonView(), new Function1<InteractiveReplyButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.3.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(InteractiveReplyButtonView interactiveReplyButtonView) {
                                                final g gVar9 = g.this;
                                                interactiveReplyButtonView.attr(new Function1<InteractiveReplyButtonViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.3.2.3.1
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
                                final NBPInteractiveCommentReplyItemView nBPInteractiveCommentReplyItemView4 = nBPInteractiveCommentReplyItemView3;
                                NBPInteractiveThumbnailViewKt.NBPInteractiveThumbnail(vVar4, new Function1<NBPInteractiveThumbnailView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NBPInteractiveThumbnailView nBPInteractiveThumbnailView) {
                                        final NBPInteractiveCommentReplyItemView nBPInteractiveCommentReplyItemView5 = NBPInteractiveCommentReplyItemView.this;
                                        nBPInteractiveThumbnailView.attr(new Function1<NBPInteractiveThumbnailViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.3.3.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(NBPInteractiveThumbnailViewAttr nBPInteractiveThumbnailViewAttr) {
                                                nBPInteractiveThumbnailViewAttr.psvFeed = NBPInteractiveCommentReplyItemView.access$getAttr(NBPInteractiveCommentReplyItemView.this).psvFeed;
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
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        final float f18 = f17;
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.view.NBPInteractiveCommentReplyItemView.body.1.4.1
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
        return new NBPInteractiveCommentReplyItemViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPInteractiveCommentReplyItemViewEvent();
    }
}
