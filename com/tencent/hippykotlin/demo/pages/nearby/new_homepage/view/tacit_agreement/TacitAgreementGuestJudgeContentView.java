package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement;

import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.resource.NBPHomepageIconConstantKt;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.internal.GroupAttr;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import s35.y;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TacitAgreementGuestJudgeContentView extends ComposeView<TacitAgreementGuestJudgeContentAttr, TacitAgreementGuestJudgeContentEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TacitAgreementGuestJudgeContentAttr access$getAttr(TacitAgreementGuestJudgeContentView tacitAgreementGuestJudgeContentView) {
        return (TacitAgreementGuestJudgeContentAttr) tacitAgreementGuestJudgeContentView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Pair access$tacitConfig(TacitAgreementGuestJudgeContentView tacitAgreementGuestJudgeContentView, boolean z16) {
        c<y> tacitGuestList;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((TacitAgreementGuestJudgeContentAttr) tacitAgreementGuestJudgeContentView.getAttr()).viewModel;
        int i3 = 0;
        if (nBPHomePageBaseViewModel != null && (tacitGuestList = nBPHomePageBaseViewModel.getTacitGuestList()) != null) {
            TacitAgreementGuestJudgeContentAttr tacitAgreementGuestJudgeContentAttr = (TacitAgreementGuestJudgeContentAttr) tacitAgreementGuestJudgeContentView.getAttr();
            i3 = CollectionsKt___CollectionsKt.indexOf((List<? extends y>) ((List<? extends Object>) tacitGuestList), (y) tacitAgreementGuestJudgeContentAttr.data$delegate.getValue(tacitAgreementGuestJudgeContentAttr, TacitAgreementGuestJudgeContentAttr.$$delegatedProperties[0]));
        }
        List<String> list = NBPHomepageIconConstantKt.TACIT_BG_List;
        if (i3 >= list.size()) {
            i3 %= list.size();
        }
        if (!z16) {
            return new Pair(list.get(i3), NBPHomepageIconConstantKt.TACIT_COLOR_LIST.get(i3));
        }
        return new Pair(NBPHomepageIconConstantKt.TACIT_BG_NIGHT_LIST.get(i3), 16777215L);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestJudgeContentView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestJudgeContentView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.mo153width(118.0f);
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementGuestJudgeContentView tacitAgreementGuestJudgeContentView = TacitAgreementGuestJudgeContentView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestJudgeContentView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final TacitAgreementGuestJudgeContentView tacitAgreementGuestJudgeContentView2 = TacitAgreementGuestJudgeContentView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestJudgeContentView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionColumn();
                                tVar2.borderRadius(12.0f);
                                GroupAttr.backgroundImage$default(tVar2, (String) TacitAgreementGuestJudgeContentView.access$tacitConfig(TacitAgreementGuestJudgeContentView.this, PageDataExtKt.isNightMode(tVar2.getPagerData())).getFirst(), null, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitAgreementGuestJudgeContentView tacitAgreementGuestJudgeContentView3 = TacitAgreementGuestJudgeContentView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestJudgeContentView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final TacitAgreementGuestJudgeContentView tacitAgreementGuestJudgeContentView4 = TacitAgreementGuestJudgeContentView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestJudgeContentView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        ce ceVar2 = ceVar;
                                        ceVar2.mo153width(86.0f);
                                        ceVar2.color(new h(((Number) TacitAgreementGuestJudgeContentView.access$tacitConfig(TacitAgreementGuestJudgeContentView.this, PageDataExtKt.isNightMode(ceVar2.getPagerData())).getSecond()).longValue(), 1.0f));
                                        TacitAgreementGuestJudgeContentAttr access$getAttr = TacitAgreementGuestJudgeContentView.access$getAttr(TacitAgreementGuestJudgeContentView.this);
                                        y yVar = (y) access$getAttr.data$delegate.getValue(access$getAttr, TacitAgreementGuestJudgeContentAttr.$$delegatedProperties[0]);
                                        if (yVar == null || (str = yVar.f433284e) == null) {
                                            str = "";
                                        }
                                        ceVar2.text(str);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.fontWeight500();
                                        ceVar2.lineHeight(20.0f);
                                        ceVar2.marginTop(14.0f);
                                        ceVar2.alignSelfCenter();
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
        return new TacitAgreementGuestJudgeContentAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new TacitAgreementGuestJudgeContentEvent();
    }
}
