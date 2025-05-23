package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TacitAgreementTitleGuestView extends ComposeView<TacitAgreementTitleGuestAttr, TacitAgreementTitleGuestEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TacitAgreementTitleGuestAttr access$getAttr(TacitAgreementTitleGuestView tacitAgreementTitleGuestView) {
        return (TacitAgreementTitleGuestAttr) tacitAgreementTitleGuestView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleGuestView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleGuestView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(mVar2.getPagerData().m());
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementTitleGuestView tacitAgreementTitleGuestView = TacitAgreementTitleGuestView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleGuestView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleGuestView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.mo141height(48.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleGuestView.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleGuestView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginLeft(16.0f);
                                        ceVar2.fontWeight400();
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                        ceVar2.text("\u6211\u4eec\u7684\u9ed8\u5951");
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitAgreementTitleGuestView tacitAgreementTitleGuestView2 = TacitAgreementTitleGuestView.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleGuestView.body.1.2.3
                            {
                                super(0);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
                            
                                if ((!r0) == true) goto L10;
                             */
                            @Override // kotlin.jvm.functions.Function0
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object invoke() {
                                boolean z16;
                                String tacitGuestTitle;
                                boolean isBlank;
                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementTitleGuestView.access$getAttr(TacitAgreementTitleGuestView.this).viewModel;
                                if (nBPHomePageBaseViewModel != null && (tacitGuestTitle = nBPHomePageBaseViewModel.getTacitGuestTitle()) != null) {
                                    isBlank = StringsKt__StringsJVMKt.isBlank(tacitGuestTitle);
                                    z16 = true;
                                }
                                z16 = false;
                                return Boolean.valueOf(z16);
                            }
                        };
                        final TacitAgreementTitleGuestView tacitAgreementTitleGuestView3 = TacitAgreementTitleGuestView.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleGuestView.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final TacitAgreementTitleGuestView tacitAgreementTitleGuestView4 = TacitAgreementTitleGuestView.this;
                                cg.a(conditionView, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleGuestView.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final TacitAgreementTitleGuestView tacitAgreementTitleGuestView5 = TacitAgreementTitleGuestView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementTitleGuestView.body.1.2.4.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                String str;
                                                ce ceVar2 = ceVar;
                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementTitleGuestView.access$getAttr(TacitAgreementTitleGuestView.this).viewModel;
                                                if (nBPHomePageBaseViewModel == null || (str = nBPHomePageBaseViewModel.getTacitGuestTitle()) == null) {
                                                    str = "";
                                                }
                                                ceVar2.text(str);
                                                ceVar2.marginLeft(8.0f);
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.fontWeight600();
                                                ceVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(4286277119L), 0.0f), new j(new h(4291521023L), 1.0f));
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
        return new TacitAgreementTitleGuestAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new TacitAgreementTitleGuestEvent();
    }
}
