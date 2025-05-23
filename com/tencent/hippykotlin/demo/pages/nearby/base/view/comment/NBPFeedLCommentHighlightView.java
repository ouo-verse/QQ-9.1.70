package com.tencent.hippykotlin.demo.pages.nearby.base.view.comment;

import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.q;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPFeedLCommentHighlightView extends ComposeView<NBPFeedLCommentHighlightAttr, NBPFeedLCommentHighlightEvent> {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedLCommentHighlightView$body$1
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                viewContainer.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedLCommentHighlightView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(h.INSTANCE.j());
                        mVar2.absolutePositionAllZero();
                        mVar2.m150top(-6.0f);
                        mVar2.m138bottom(-6.0f);
                        mVar2.m142left(-100.0f);
                        mVar2.m149right(-100.0f);
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPFeedLCommentHighlightAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPFeedLCommentHighlightEvent();
    }

    public final void trigger() {
        final h color$default = QUIToken.color$default("fill_standard_primary");
        q.a.a(this, b.Companion.l(b.INSTANCE, 0.2f, null, 2, null), null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedLCommentHighlightView$trigger$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Attr attr) {
                attr.mo113backgroundColor(h.this);
                return Unit.INSTANCE;
            }
        }, 2, null);
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedLCommentHighlightView$trigger$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                q.a.a(NBPFeedLCommentHighlightView.this, b.Companion.l(b.INSTANCE, 0.2f, null, 2, null), null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedLCommentHighlightView$trigger$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Attr attr) {
                        attr.mo113backgroundColor(h.INSTANCE.j());
                        return Unit.INSTANCE;
                    }
                }, 2, null);
                return Unit.INSTANCE;
            }
        };
        KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
        TimerKt.e(getPagerId(), 700, function0);
    }
}
