package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPTagsEditViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class OptionalTagView extends ComposeView<OptionalTagViewAttr, OptionalTagViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ OptionalTagViewAttr access$getAttr(OptionalTagView optionalTagView) {
        return (OptionalTagViewAttr) optionalTagView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.OptionalTagView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final OptionalTagView optionalTagView = OptionalTagView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.OptionalTagView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        h j3;
                        m mVar2 = mVar;
                        mVar2.borderRadius(4.0f);
                        mVar2.m136border(new e(OptionalTagView.access$getAttr(OptionalTagView.this).getSelected() ? 0.0f : 1.0f, BorderStyle.SOLID, QUIToken.color$default("border_standard")));
                        mVar2.mo141height(32.0f);
                        mVar2.margin(6.0f);
                        mVar2.padding(6.0f, 8.0f, 6.0f, 8.0f);
                        mVar2.allCenter();
                        if (OptionalTagView.access$getAttr(OptionalTagView.this).getSelected()) {
                            j3 = new h(443832831L);
                        } else {
                            j3 = h.INSTANCE.j();
                        }
                        mVar2.mo113backgroundColor(j3);
                        return Unit.INSTANCE;
                    }
                });
                final OptionalTagView optionalTagView2 = OptionalTagView.this;
                cg.a(viewContainer2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.OptionalTagView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(TextView textView) {
                        final OptionalTagView optionalTagView3 = OptionalTagView.this;
                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.OptionalTagView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ce ceVar) {
                                h color$default;
                                ce ceVar2 = ceVar;
                                ceVar2.text(OptionalTagView.access$getAttr(OptionalTagView.this).getTag().tag.f435363e);
                                if (OptionalTagView.access$getAttr(OptionalTagView.this).getSelected()) {
                                    color$default = new h(4285815295L);
                                } else {
                                    color$default = QUIToken.color$default("text_primary");
                                }
                                ceVar2.color(color$default);
                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                ceVar2.fontWeight400();
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final OptionalTagView optionalTagView3 = OptionalTagView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.OptionalTagView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        Event event2 = event;
                        final OptionalTagView optionalTagView4 = OptionalTagView.this;
                        event2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.OptionalTagView.body.1.3.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
                            
                                if ((r3 != null && r3.hitSelectTagMaxLimit()) != false) goto L13;
                             */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(ClickParams clickParams) {
                                if (!OptionalTagView.access$getAttr(OptionalTagView.this).getSelected()) {
                                    NBPTagsEditViewModel nBPTagsEditViewModel = OptionalTagView.access$getAttr(OptionalTagView.this).viewModel;
                                }
                                OptionalTagView.access$getAttr(OptionalTagView.this).setSelected(true ^ OptionalTagView.access$getAttr(OptionalTagView.this).getSelected());
                                OptionalTagView optionalTagView5 = OptionalTagView.this;
                                optionalTagView5.emit("select", OptionalTagView.access$getAttr(optionalTagView5));
                                return Unit.INSTANCE;
                            }
                        });
                        final OptionalTagView optionalTagView5 = OptionalTagView.this;
                        FrameEventKt.d(event2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view.OptionalTagView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(d dVar) {
                                OptionalTagView.access$getAttr(OptionalTagView.this).getTag().viewWith = dVar.getWidth();
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
        return new OptionalTagViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new OptionalTagViewEvent();
    }
}
