package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.m;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPSharePanelItemView extends ComposeView<NBPSharePanelItemViewAttr, NBPSharePanelItemViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPSharePanelItemViewAttr access$getAttr(NBPSharePanelItemView nBPSharePanelItemView) {
        return (NBPSharePanelItemViewAttr) nBPSharePanelItemView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelItemView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelItemView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(52.0f, 74.0f);
                        mVar2.alignItemsCenter();
                        return Unit.INSTANCE;
                    }
                });
                final NBPSharePanelItemView nBPSharePanelItemView = NBPSharePanelItemView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelItemView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelItemView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(52.0f, 52.0f);
                                tVar2.allCenter();
                                tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                tVar2.borderRadius(26.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPSharePanelItemView nBPSharePanelItemView2 = NBPSharePanelItemView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelItemView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final NBPSharePanelItemView nBPSharePanelItemView3 = NBPSharePanelItemView.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelItemView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(24.0f, 24.0f);
                                        afVar2.q();
                                        b.a.b(afVar2, NBPSharePanelItemView.access$getAttr(NBPSharePanelItemView.this).data.icon, false, 2, null);
                                        if (Intrinsics.areEqual(NBPSharePanelItemView.access$getAttr(NBPSharePanelItemView.this).data.text, "\u4fdd\u5b58\u56fe\u7247") || Intrinsics.areEqual(NBPSharePanelItemView.access$getAttr(NBPSharePanelItemView.this).data.text, "\u590d\u5236\u94fe\u63a5") || Intrinsics.areEqual(NBPSharePanelItemView.access$getAttr(NBPSharePanelItemView.this).data.text, "\u9644\u8fd1\u52a8\u6001")) {
                                            afVar2.t(QUIToken.color$default("icon_primary"));
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
                final NBPSharePanelItemView nBPSharePanelItemView2 = NBPSharePanelItemView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelItemView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final NBPSharePanelItemView nBPSharePanelItemView3 = NBPSharePanelItemView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPSharePanelItemView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                ce ceVar2 = ceVar;
                                ceVar2.marginTop(8.0f);
                                ceVar2.text(NBPSharePanelItemView.access$getAttr(NBPSharePanelItemView.this).data.text);
                                ceVar2.color(QUIToken.color$default("text_primary"));
                                ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                ceVar2.fontWeight400();
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
        return new NBPSharePanelItemViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPSharePanelItemViewEvent();
    }
}
