package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement;

import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.UserSelfBaseInfo;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.internal.GroupAttr;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import s35.ab;
import s35.af;
import s35.y;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TacitAgreementGuestSelectContentView extends ComposeView<TacitAgreementGuestSelectContentAttr, TacitAgreementGuestSelectContentEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TacitAgreementGuestSelectContentAttr access$getAttr(TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView) {
        return (TacitAgreementGuestSelectContentAttr) tacitAgreementGuestSelectContentView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String access$getHeadIcon(TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView, Integer num) {
        UserSelfBaseInfo selfBaseInfo;
        String str;
        af userInfo;
        tacitAgreementGuestSelectContentView.getClass();
        if (num != null && num.intValue() == 2) {
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((TacitAgreementGuestSelectContentAttr) tacitAgreementGuestSelectContentView.getAttr()).viewModel;
            if (nBPHomePageBaseViewModel == null || (userInfo = nBPHomePageBaseViewModel.getUserInfo()) == null || (str = userInfo.E) == null) {
                return "";
            }
        } else {
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((TacitAgreementGuestSelectContentAttr) tacitAgreementGuestSelectContentView.getAttr()).viewModel;
            if (nBPHomePageBaseViewModel2 == null || (selfBaseInfo = nBPHomePageBaseViewModel2.getSelfBaseInfo()) == null || (str = selfBaseInfo.avatarUrl) == null) {
                return "";
            }
        }
        return str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final int access$getOptionsNum(TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView) {
        List<ab> list;
        y data = ((TacitAgreementGuestSelectContentAttr) tacitAgreementGuestSelectContentView.getAttr()).getData();
        if (data == null || (list = data.f433285f) == null) {
            return 0;
        }
        return list.size();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.mo153width(200.0f);
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView = TacitAgreementGuestSelectContentView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.borderRadius(12.0f);
                                tVar2.flexDirectionColumn();
                                tVar2.allCenter();
                                if (PageDataExtKt.isNightMode(tVar2.getPagerData())) {
                                    GroupAttr.backgroundImage$default(tVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_hcCnrC45w4O.png", null, 2, null);
                                } else {
                                    GroupAttr.backgroundImage$default(tVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_Yo9Tz3tYbpu.png", null, 2, null);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView2 = TacitAgreementGuestSelectContentView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView3 = TacitAgreementGuestSelectContentView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        String str;
                                        ce ceVar2 = ceVar;
                                        ceVar2.positionAbsolute();
                                        ceVar2.mo153width(168.0f);
                                        ceVar2.m142left(16.0f);
                                        ceVar2.m150top(16.0f);
                                        ceVar2.lineHeight(20.0f);
                                        if (PageDataExtKt.isNightMode(ceVar2.getPagerData())) {
                                            ceVar2.color(h.INSTANCE.m());
                                        } else {
                                            ceVar2.color(new h(5849456L, 1.0f));
                                        }
                                        y data = TacitAgreementGuestSelectContentView.access$getAttr(TacitAgreementGuestSelectContentView.this).getData();
                                        if (data == null || (str = data.f433284e) == null) {
                                            str = "";
                                        }
                                        ceVar2.text(str);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.fontWeight500();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView3 = TacitAgreementGuestSelectContentView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.positionAbsolute();
                                        tVar2.mo153width(168.0f);
                                        tVar2.m142left(16.0f);
                                        tVar2.m138bottom(12.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView4 = TacitAgreementGuestSelectContentView.this;
                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(TacitAgreementGuestSelectContentView.access$getOptionsNum(TacitAgreementGuestSelectContentView.this) == 1);
                                    }
                                };
                                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView5 = TacitAgreementGuestSelectContentView.this;
                                ConditionViewKt.c(vVar4, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final ab abVar;
                                        List<ab> list;
                                        Object orNull;
                                        ConditionView conditionView2 = conditionView;
                                        y data = TacitAgreementGuestSelectContentView.access$getAttr(TacitAgreementGuestSelectContentView.this).getData();
                                        if (data == null || (list = data.f433285f) == null) {
                                            abVar = null;
                                        } else {
                                            orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
                                            abVar = (ab) orNull;
                                        }
                                        final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView6 = TacitAgreementGuestSelectContentView.this;
                                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.3.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.m140flex(1.0f);
                                                        tVar2.flexDirectionRow();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final ab abVar2 = ab.this;
                                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.3.1.2
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        ab abVar3 = ab.this;
                                                        return Boolean.valueOf(abVar3 != null && abVar3.f433193d == 0);
                                                    }
                                                };
                                                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView7 = tacitAgreementGuestSelectContentView6;
                                                ConditionViewKt.c(vVar6, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.3.1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView3) {
                                                        ConditionView conditionView4 = conditionView3;
                                                        final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView8 = TacitAgreementGuestSelectContentView.this;
                                                        ah.a(conditionView4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.3.1.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView9 = TacitAgreementGuestSelectContentView.this;
                                                                imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.3.1.3.1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                                        com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                                        afVar2.size(16.0f, 16.0f);
                                                                        afVar2.borderRadius(8.0f);
                                                                        b.a.b(afVar2, TacitAgreementGuestSelectContentView.access$getHeadIcon(TacitAgreementGuestSelectContentView.this, 0), false, 2, null);
                                                                        afVar2.m136border(new e(1.0f, BorderStyle.SOLID, h.INSTANCE.m()));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView9 = TacitAgreementGuestSelectContentView.this;
                                                        ah.a(conditionView4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.3.1.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView10 = TacitAgreementGuestSelectContentView.this;
                                                                imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.3.1.3.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                                        com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                                        afVar2.size(16.0f, 16.0f);
                                                                        b.a.b(afVar2, TacitAgreementGuestSelectContentView.access$getHeadIcon(TacitAgreementGuestSelectContentView.this, 2), false, 2, null);
                                                                        afVar2.borderRadius(8.0f);
                                                                        afVar2.marginLeft(-3.0f);
                                                                        afVar2.m136border(new e(1.0f, BorderStyle.SOLID, h.INSTANCE.m()));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView8 = tacitAgreementGuestSelectContentView6;
                                                final ab abVar3 = ab.this;
                                                ConditionViewKt.a(vVar6, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.3.1.4
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView3) {
                                                        final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView9 = TacitAgreementGuestSelectContentView.this;
                                                        final ab abVar4 = abVar3;
                                                        ah.a(conditionView3, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.3.1.4.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView10 = TacitAgreementGuestSelectContentView.this;
                                                                final ab abVar5 = abVar4;
                                                                imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.3.1.4.1.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                                        com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                                        afVar2.size(16.0f, 16.0f);
                                                                        afVar2.borderRadius(8.0f);
                                                                        TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView11 = TacitAgreementGuestSelectContentView.this;
                                                                        ab abVar6 = abVar5;
                                                                        b.a.b(afVar2, TacitAgreementGuestSelectContentView.access$getHeadIcon(tacitAgreementGuestSelectContentView11, abVar6 != null ? Integer.valueOf(abVar6.f433193d) : null), false, 2, null);
                                                                        afVar2.m136border(new e(1.0f, BorderStyle.SOLID, h.INSTANCE.m()));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView9 = tacitAgreementGuestSelectContentView6;
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.3.1.5
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView10 = TacitAgreementGuestSelectContentView.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.3.1.5.1
                                                            {
                                                                super(1);
                                                            }

                                                            /* JADX WARN: Code restructure failed: missing block: B:8:0x0029, code lost:
                                                            
                                                                if (r0 != null) goto L11;
                                                             */
                                                            @Override // kotlin.jvm.functions.Function1
                                                            /*
                                                                Code decompiled incorrectly, please refer to instructions dump.
                                                            */
                                                            public final Unit invoke(ce ceVar) {
                                                                String str;
                                                                List<ab> list2;
                                                                Object orNull2;
                                                                ce ceVar2 = ceVar;
                                                                NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 12.0f, null, 2, null, "text_primary");
                                                                y data2 = TacitAgreementGuestSelectContentView.access$getAttr(TacitAgreementGuestSelectContentView.this).getData();
                                                                if (data2 != null && (list2 = data2.f433285f) != null) {
                                                                    orNull2 = CollectionsKt___CollectionsKt.getOrNull(list2, 0);
                                                                    ab abVar4 = (ab) orNull2;
                                                                    if (abVar4 != null) {
                                                                        str = abVar4.f433194e;
                                                                    }
                                                                }
                                                                str = "";
                                                                ceVar2.text(str);
                                                                ceVar2.marginLeft(4.0f);
                                                                ceVar2.fontWeight400();
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
                                });
                                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView6 = TacitAgreementGuestSelectContentView.this;
                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.4
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Boolean.valueOf(TacitAgreementGuestSelectContentView.access$getOptionsNum(TacitAgreementGuestSelectContentView.this) == 2);
                                    }
                                };
                                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView7 = TacitAgreementGuestSelectContentView.this;
                                ConditionViewKt.c(vVar4, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        final ab abVar;
                                        List<ab> list;
                                        Object orNull;
                                        List<ab> list2;
                                        Object orNull2;
                                        ConditionView conditionView2 = conditionView;
                                        y data = TacitAgreementGuestSelectContentView.access$getAttr(TacitAgreementGuestSelectContentView.this).getData();
                                        final ab abVar2 = null;
                                        if (data == null || (list2 = data.f433285f) == null) {
                                            abVar = null;
                                        } else {
                                            orNull2 = CollectionsKt___CollectionsKt.getOrNull(list2, 0);
                                            abVar = (ab) orNull2;
                                        }
                                        y data2 = TacitAgreementGuestSelectContentView.access$getAttr(TacitAgreementGuestSelectContentView.this).getData();
                                        if (data2 != null && (list = data2.f433285f) != null) {
                                            orNull = CollectionsKt___CollectionsKt.getOrNull(list, 1);
                                            abVar2 = (ab) orNull;
                                        }
                                        final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView8 = TacitAgreementGuestSelectContentView.this;
                                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.5.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.5.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.m140flex(1.0f);
                                                        tVar2.flexDirectionColumn();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView9 = TacitAgreementGuestSelectContentView.this;
                                                final ab abVar3 = abVar;
                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.5.1.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        v vVar8 = vVar7;
                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.5.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirectionRow();
                                                                tVar2.marginBottom(2.0f);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView10 = TacitAgreementGuestSelectContentView.this;
                                                        final ab abVar4 = abVar3;
                                                        ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.5.1.2.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView11 = TacitAgreementGuestSelectContentView.this;
                                                                final ab abVar5 = abVar4;
                                                                imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.5.1.2.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                                        com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                                        afVar2.size(16.0f, 16.0f);
                                                                        afVar2.borderRadius(8.0f);
                                                                        TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView12 = TacitAgreementGuestSelectContentView.this;
                                                                        ab abVar6 = abVar5;
                                                                        b.a.b(afVar2, TacitAgreementGuestSelectContentView.access$getHeadIcon(tacitAgreementGuestSelectContentView12, abVar6 != null ? Integer.valueOf(abVar6.f433193d) : null), false, 2, null);
                                                                        afVar2.m136border(new e(1.0f, BorderStyle.SOLID, h.INSTANCE.m()));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final ab abVar5 = abVar3;
                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.5.1.2.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final ab abVar6 = ab.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.5.1.2.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        String str;
                                                                        ce ceVar2 = ceVar;
                                                                        NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 12.0f, null, 2, null, "text_primary");
                                                                        ab abVar7 = ab.this;
                                                                        if (abVar7 == null || (str = abVar7.f433194e) == null) {
                                                                            str = "";
                                                                        }
                                                                        ceVar2.text(str);
                                                                        ceVar2.marginLeft(4.0f);
                                                                        ceVar2.fontWeight400();
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
                                                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView10 = TacitAgreementGuestSelectContentView.this;
                                                final ab abVar4 = abVar2;
                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.5.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        v vVar8 = vVar7;
                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.5.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                tVar.flexDirectionRow();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView11 = TacitAgreementGuestSelectContentView.this;
                                                        final ab abVar5 = abVar4;
                                                        ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.5.1.3.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                final TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView12 = TacitAgreementGuestSelectContentView.this;
                                                                final ab abVar6 = abVar5;
                                                                imageView.attr(new Function1<com.tencent.kuikly.core.views.af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.5.1.3.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(com.tencent.kuikly.core.views.af afVar) {
                                                                        com.tencent.kuikly.core.views.af afVar2 = afVar;
                                                                        afVar2.size(16.0f, 16.0f);
                                                                        afVar2.borderRadius(8.0f);
                                                                        TacitAgreementGuestSelectContentView tacitAgreementGuestSelectContentView13 = TacitAgreementGuestSelectContentView.this;
                                                                        ab abVar7 = abVar6;
                                                                        b.a.b(afVar2, TacitAgreementGuestSelectContentView.access$getHeadIcon(tacitAgreementGuestSelectContentView13, abVar7 != null ? Integer.valueOf(abVar7.f433193d) : null), false, 2, null);
                                                                        afVar2.m136border(new e(1.0f, BorderStyle.SOLID, h.INSTANCE.m()));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final ab abVar6 = abVar4;
                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.5.1.3.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final ab abVar7 = ab.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementGuestSelectContentView.body.1.2.3.5.1.3.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        String str;
                                                                        ce ceVar2 = ceVar;
                                                                        NBPArticleFeedItemView$body$1$3$3$3$3$1$1$$ExternalSyntheticOutline0.m(ceVar2, 12.0f, null, 2, null, "text_primary");
                                                                        ab abVar8 = ab.this;
                                                                        if (abVar8 == null || (str = abVar8.f433194e) == null) {
                                                                            str = "";
                                                                        }
                                                                        ceVar2.text(str);
                                                                        ceVar2.marginLeft(4.0f);
                                                                        ceVar2.fontWeight400();
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
        return new TacitAgreementGuestSelectContentAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new TacitAgreementGuestSelectContentEvent();
    }
}
