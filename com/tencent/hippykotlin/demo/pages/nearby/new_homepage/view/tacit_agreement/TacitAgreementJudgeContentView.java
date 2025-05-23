package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.Tacit;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.resource.NBPHomepageIconConstantKt;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view_model.NBPHomePageBaseViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.APNGVView;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.a;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.b;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.internal.GroupAttr;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class TacitAgreementJudgeContentView extends ComposeView<TacitAgreementJudgeContentViewAttr, TacitAgreementJudgeContentViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TacitAgreementJudgeContentView.class, "doAgree", "getDoAgree()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TacitAgreementJudgeContentView.class, "doUnAgree", "getDoUnAgree()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TacitAgreementJudgeContentView.class, "agreeIng", "getAgreeIng()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(TacitAgreementJudgeContentView.class, "unAgreeIng", "getUnAgreeIng()Z", 0)};
    public final ReadWriteProperty agreeIng$delegate;
    public final ReadWriteProperty doAgree$delegate;
    public aa<APNGVView> doAgreeApng;
    public final ReadWriteProperty doUnAgree$delegate;
    public aa<APNGVView> doUnAgreeApng;
    public final ReadWriteProperty unAgreeIng$delegate;

    public TacitAgreementJudgeContentView() {
        Boolean bool = Boolean.FALSE;
        this.doAgree$delegate = c.a(bool);
        this.doUnAgree$delegate = c.a(bool);
        this.agreeIng$delegate = c.a(bool);
        this.unAgreeIng$delegate = c.a(bool);
    }

    public static final boolean access$checkSelectIng(TacitAgreementJudgeContentView tacitAgreementJudgeContentView) {
        ReadWriteProperty readWriteProperty = tacitAgreementJudgeContentView.doAgree$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        return ((Boolean) readWriteProperty.getValue(tacitAgreementJudgeContentView, kPropertyArr[0])).booleanValue() || ((Boolean) tacitAgreementJudgeContentView.doUnAgree$delegate.getValue(tacitAgreementJudgeContentView, kPropertyArr[1])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TacitAgreementJudgeContentViewAttr access$getAttr(TacitAgreementJudgeContentView tacitAgreementJudgeContentView) {
        return (TacitAgreementJudgeContentViewAttr) tacitAgreementJudgeContentView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Pair access$tacitConfig(TacitAgreementJudgeContentView tacitAgreementJudgeContentView, boolean z16) {
        com.tencent.kuikly.core.reactive.collection.c<Tacit> tacitMyList;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((TacitAgreementJudgeContentViewAttr) tacitAgreementJudgeContentView.getAttr()).viewModel;
        int indexOf = (nBPHomePageBaseViewModel == null || (tacitMyList = nBPHomePageBaseViewModel.getTacitMyList()) == null) ? 0 : CollectionsKt___CollectionsKt.indexOf((List<? extends Tacit>) ((List<? extends Object>) tacitMyList), ((TacitAgreementJudgeContentViewAttr) tacitAgreementJudgeContentView.getAttr()).getData());
        List<String> list = NBPHomepageIconConstantKt.TACIT_BG_List;
        if (indexOf >= list.size()) {
            indexOf %= list.size();
        }
        if (!z16) {
            return new Pair(list.get(indexOf), NBPHomepageIconConstantKt.TACIT_COLOR_LIST.get(indexOf));
        }
        return new Pair(NBPHomepageIconConstantKt.TACIT_BG_NIGHT_LIST.get(indexOf), 16777215L);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.mo153width(172.0f);
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementJudgeContentView tacitAgreementJudgeContentView = TacitAgreementJudgeContentView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final TacitAgreementJudgeContentView tacitAgreementJudgeContentView2 = TacitAgreementJudgeContentView.this;
                        VisibilityEventKt.b(event, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                TacitAgreementJudgeContentView tacitAgreementJudgeContentView3 = TacitAgreementJudgeContentView.this;
                                KProperty<Object>[] kPropertyArr = TacitAgreementJudgeContentView.$$delegatedProperties;
                                tacitAgreementJudgeContentView3.report("dt_imp", null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final TacitAgreementJudgeContentView tacitAgreementJudgeContentView2 = TacitAgreementJudgeContentView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final TacitAgreementJudgeContentView tacitAgreementJudgeContentView3 = TacitAgreementJudgeContentView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.flexDirectionColumn();
                                tVar2.allCenter();
                                tVar2.borderRadius(12.0f);
                                GroupAttr.backgroundImage$default(tVar2, (String) TacitAgreementJudgeContentView.access$tacitConfig(TacitAgreementJudgeContentView.this, PageDataExtKt.isNightMode(tVar2.getPagerData())).getFirst(), null, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitAgreementJudgeContentView tacitAgreementJudgeContentView4 = TacitAgreementJudgeContentView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final TacitAgreementJudgeContentView tacitAgreementJudgeContentView5 = TacitAgreementJudgeContentView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.mo153width(140.0f);
                                        ceVar2.positionAbsolute();
                                        ceVar2.m142left(16.0f);
                                        ceVar2.m150top(16.0f);
                                        ceVar2.color(new h(((Number) TacitAgreementJudgeContentView.access$tacitConfig(TacitAgreementJudgeContentView.this, PageDataExtKt.isNightMode(ceVar2.getPagerData())).getSecond()).longValue(), 1.0f));
                                        Tacit data = TacitAgreementJudgeContentView.access$getAttr(TacitAgreementJudgeContentView.this).getData();
                                        String str = data != null ? data.question : null;
                                        Intrinsics.checkNotNull(str);
                                        ceVar2.text(str);
                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                        ceVar2.fontWeight500();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final TacitAgreementJudgeContentView tacitAgreementJudgeContentView5 = TacitAgreementJudgeContentView.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(104.0f, 40.0f);
                                        tVar2.positionAbsolute();
                                        tVar2.m142left(34.0f);
                                        tVar2.m138bottom(20.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentSpaceBetween();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final TacitAgreementJudgeContentView tacitAgreementJudgeContentView6 = TacitAgreementJudgeContentView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(40.0f, 40.0f);
                                                tVar2.borderRadius(20.0f);
                                                tVar2.mo113backgroundColor(h.INSTANCE.m());
                                                tVar2.positionRelative();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final TacitAgreementJudgeContentView tacitAgreementJudgeContentView7 = TacitAgreementJudgeContentView.this;
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final TacitAgreementJudgeContentView tacitAgreementJudgeContentView8 = TacitAgreementJudgeContentView.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        APNGVView b16;
                                                        if (!TacitAgreementJudgeContentView.access$checkSelectIng(TacitAgreementJudgeContentView.this)) {
                                                            TacitAgreementJudgeContentView tacitAgreementJudgeContentView9 = TacitAgreementJudgeContentView.this;
                                                            tacitAgreementJudgeContentView9.doUnAgree$delegate.setValue(tacitAgreementJudgeContentView9, TacitAgreementJudgeContentView.$$delegatedProperties[1], Boolean.TRUE);
                                                            Tacit data = TacitAgreementJudgeContentView.access$getAttr(TacitAgreementJudgeContentView.this).getData();
                                                            if (data != null) {
                                                                data.answer = 2;
                                                            }
                                                            TacitAgreementJudgeContentView.this.report("dt_clck", 0);
                                                            aa<APNGVView> aaVar = TacitAgreementJudgeContentView.this.doUnAgreeApng;
                                                            if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                b16.play();
                                                            }
                                                            final TacitAgreementJudgeContentView tacitAgreementJudgeContentView10 = TacitAgreementJudgeContentView.this;
                                                            TimerKt.c(800, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.2.2.1.1
                                                                {
                                                                    super(0);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Unit invoke() {
                                                                    NBPHomePageBaseViewModel nBPHomePageBaseViewModel;
                                                                    Tacit data2 = TacitAgreementJudgeContentView.access$getAttr(TacitAgreementJudgeContentView.this).getData();
                                                                    if (data2 != null && (nBPHomePageBaseViewModel = TacitAgreementJudgeContentView.access$getAttr(TacitAgreementJudgeContentView.this).viewModel) != null) {
                                                                        nBPHomePageBaseViewModel.removeTacit(data2);
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final TacitAgreementJudgeContentView tacitAgreementJudgeContentView8 = TacitAgreementJudgeContentView.this;
                                        com.tencent.kuikly.core.views.c.a(vVar6, new Function1<APNGVView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(APNGVView aPNGVView) {
                                                APNGVView aPNGVView2 = aPNGVView;
                                                final TacitAgreementJudgeContentView tacitAgreementJudgeContentView9 = TacitAgreementJudgeContentView.this;
                                                aPNGVView2.ref(aPNGVView2, new Function1<aa<APNGVView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.2.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<APNGVView> aaVar) {
                                                        TacitAgreementJudgeContentView.this.doUnAgreeApng = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final TacitAgreementJudgeContentView tacitAgreementJudgeContentView10 = TacitAgreementJudgeContentView.this;
                                                aPNGVView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.2.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(a aVar) {
                                                        a aVar2 = aVar;
                                                        aVar2.positionAbsolute();
                                                        aVar2.m142left(10.0f);
                                                        aVar2.m150top(10.0f);
                                                        aVar2.size(20.0f, 20.0f);
                                                        aVar2.src("https://downv6.qq.com/extendfriend/qq_kl_tacit_false_animation_android.png");
                                                        aVar2.repeatCount(1);
                                                        aVar2.autoPlay(false);
                                                        TacitAgreementJudgeContentView tacitAgreementJudgeContentView11 = TacitAgreementJudgeContentView.this;
                                                        aVar2.m152visibility(((Boolean) tacitAgreementJudgeContentView11.doUnAgree$delegate.getValue(tacitAgreementJudgeContentView11, TacitAgreementJudgeContentView.$$delegatedProperties[1])).booleanValue());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final TacitAgreementJudgeContentView tacitAgreementJudgeContentView11 = TacitAgreementJudgeContentView.this;
                                                aPNGVView2.event(new Function1<b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.2.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(b bVar) {
                                                        b bVar2 = bVar;
                                                        final TacitAgreementJudgeContentView tacitAgreementJudgeContentView12 = TacitAgreementJudgeContentView.this;
                                                        bVar2.i(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.2.3.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                TacitAgreementJudgeContentView tacitAgreementJudgeContentView13 = TacitAgreementJudgeContentView.this;
                                                                tacitAgreementJudgeContentView13.unAgreeIng$delegate.setValue(tacitAgreementJudgeContentView13, TacitAgreementJudgeContentView.$$delegatedProperties[3], Boolean.TRUE);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final TacitAgreementJudgeContentView tacitAgreementJudgeContentView13 = TacitAgreementJudgeContentView.this;
                                                        bVar2.h(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.2.3.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                TacitAgreementJudgeContentView tacitAgreementJudgeContentView14 = TacitAgreementJudgeContentView.this;
                                                                ReadWriteProperty readWriteProperty = tacitAgreementJudgeContentView14.doUnAgree$delegate;
                                                                KProperty<?>[] kPropertyArr = TacitAgreementJudgeContentView.$$delegatedProperties;
                                                                KProperty<?> kProperty = kPropertyArr[1];
                                                                Boolean bool = Boolean.FALSE;
                                                                readWriteProperty.setValue(tacitAgreementJudgeContentView14, kProperty, bool);
                                                                TacitAgreementJudgeContentView tacitAgreementJudgeContentView15 = TacitAgreementJudgeContentView.this;
                                                                tacitAgreementJudgeContentView15.unAgreeIng$delegate.setValue(tacitAgreementJudgeContentView15, kPropertyArr[3], bool);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final TacitAgreementJudgeContentView tacitAgreementJudgeContentView9 = TacitAgreementJudgeContentView.this;
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.2.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final TacitAgreementJudgeContentView tacitAgreementJudgeContentView10 = TacitAgreementJudgeContentView.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.2.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.positionAbsolute();
                                                        afVar2.m142left(10.0f);
                                                        afVar2.m150top(10.0f);
                                                        afVar2.size(20.0f, 20.0f);
                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_sx2g6acApF6.png", false, 2, null);
                                                        TacitAgreementJudgeContentView tacitAgreementJudgeContentView11 = TacitAgreementJudgeContentView.this;
                                                        afVar2.m152visibility(!((Boolean) tacitAgreementJudgeContentView11.unAgreeIng$delegate.getValue(tacitAgreementJudgeContentView11, TacitAgreementJudgeContentView.$$delegatedProperties[3])).booleanValue());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final TacitAgreementJudgeContentView tacitAgreementJudgeContentView7 = TacitAgreementJudgeContentView.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(40.0f, 40.0f);
                                                tVar2.marginLeft(24.0f);
                                                tVar2.borderRadius(20.0f);
                                                tVar2.mo113backgroundColor(h.INSTANCE.m());
                                                tVar2.positionRelative();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final TacitAgreementJudgeContentView tacitAgreementJudgeContentView8 = TacitAgreementJudgeContentView.this;
                                        vVar6.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final TacitAgreementJudgeContentView tacitAgreementJudgeContentView9 = TacitAgreementJudgeContentView.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        APNGVView b16;
                                                        if (!TacitAgreementJudgeContentView.access$checkSelectIng(TacitAgreementJudgeContentView.this)) {
                                                            TacitAgreementJudgeContentView tacitAgreementJudgeContentView10 = TacitAgreementJudgeContentView.this;
                                                            tacitAgreementJudgeContentView10.doAgree$delegate.setValue(tacitAgreementJudgeContentView10, TacitAgreementJudgeContentView.$$delegatedProperties[0], Boolean.TRUE);
                                                            aa<APNGVView> aaVar = TacitAgreementJudgeContentView.this.doAgreeApng;
                                                            if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                b16.play();
                                                            }
                                                            Tacit data = TacitAgreementJudgeContentView.access$getAttr(TacitAgreementJudgeContentView.this).getData();
                                                            if (data != null) {
                                                                TacitAgreementJudgeContentView tacitAgreementJudgeContentView11 = TacitAgreementJudgeContentView.this;
                                                                data.answer = 1;
                                                                NBPHomePageBaseViewModel nBPHomePageBaseViewModel = TacitAgreementJudgeContentView.access$getAttr(tacitAgreementJudgeContentView11).viewModel;
                                                                if (nBPHomePageBaseViewModel != null) {
                                                                    nBPHomePageBaseViewModel.editTacit(data, data.status);
                                                                }
                                                            }
                                                            final TacitAgreementJudgeContentView tacitAgreementJudgeContentView12 = TacitAgreementJudgeContentView.this;
                                                            TimerKt.c(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.3.2.1.2
                                                                {
                                                                    super(0);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Unit invoke() {
                                                                    Tacit data2 = TacitAgreementJudgeContentView.access$getAttr(TacitAgreementJudgeContentView.this).getData();
                                                                    if (data2 != null) {
                                                                        data2.setShowAfter(true);
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            TacitAgreementJudgeContentView.this.report("dt_clck", 1);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final TacitAgreementJudgeContentView tacitAgreementJudgeContentView9 = TacitAgreementJudgeContentView.this;
                                        com.tencent.kuikly.core.views.c.a(vVar6, new Function1<APNGVView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(APNGVView aPNGVView) {
                                                APNGVView aPNGVView2 = aPNGVView;
                                                final TacitAgreementJudgeContentView tacitAgreementJudgeContentView10 = TacitAgreementJudgeContentView.this;
                                                aPNGVView2.ref(aPNGVView2, new Function1<aa<APNGVView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.3.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<APNGVView> aaVar) {
                                                        TacitAgreementJudgeContentView.this.doAgreeApng = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final TacitAgreementJudgeContentView tacitAgreementJudgeContentView11 = TacitAgreementJudgeContentView.this;
                                                aPNGVView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.3.3.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(a aVar) {
                                                        a aVar2 = aVar;
                                                        aVar2.positionAbsolute();
                                                        aVar2.m142left(10.0f);
                                                        aVar2.m150top(10.0f);
                                                        aVar2.size(20.0f, 20.0f);
                                                        aVar2.src("https://downv6.qq.com/extendfriend/qq_kl_tacit_true_animation.png");
                                                        aVar2.repeatCount(1);
                                                        aVar2.autoPlay(false);
                                                        TacitAgreementJudgeContentView tacitAgreementJudgeContentView12 = TacitAgreementJudgeContentView.this;
                                                        aVar2.m152visibility(((Boolean) tacitAgreementJudgeContentView12.doAgree$delegate.getValue(tacitAgreementJudgeContentView12, TacitAgreementJudgeContentView.$$delegatedProperties[0])).booleanValue());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final TacitAgreementJudgeContentView tacitAgreementJudgeContentView12 = TacitAgreementJudgeContentView.this;
                                                aPNGVView2.event(new Function1<com.tencent.kuikly.core.views.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.3.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(com.tencent.kuikly.core.views.b bVar) {
                                                        com.tencent.kuikly.core.views.b bVar2 = bVar;
                                                        final TacitAgreementJudgeContentView tacitAgreementJudgeContentView13 = TacitAgreementJudgeContentView.this;
                                                        bVar2.i(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.3.3.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                TacitAgreementJudgeContentView tacitAgreementJudgeContentView14 = TacitAgreementJudgeContentView.this;
                                                                tacitAgreementJudgeContentView14.agreeIng$delegate.setValue(tacitAgreementJudgeContentView14, TacitAgreementJudgeContentView.$$delegatedProperties[2], Boolean.TRUE);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final TacitAgreementJudgeContentView tacitAgreementJudgeContentView14 = TacitAgreementJudgeContentView.this;
                                                        bVar2.h(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.3.3.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Object obj) {
                                                                TacitAgreementJudgeContentView tacitAgreementJudgeContentView15 = TacitAgreementJudgeContentView.this;
                                                                ReadWriteProperty readWriteProperty = tacitAgreementJudgeContentView15.doAgree$delegate;
                                                                KProperty<?>[] kPropertyArr = TacitAgreementJudgeContentView.$$delegatedProperties;
                                                                KProperty<?> kProperty = kPropertyArr[0];
                                                                Boolean bool = Boolean.FALSE;
                                                                readWriteProperty.setValue(tacitAgreementJudgeContentView15, kProperty, bool);
                                                                TacitAgreementJudgeContentView tacitAgreementJudgeContentView16 = TacitAgreementJudgeContentView.this;
                                                                tacitAgreementJudgeContentView16.agreeIng$delegate.setValue(tacitAgreementJudgeContentView16, kPropertyArr[2], bool);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final TacitAgreementJudgeContentView tacitAgreementJudgeContentView10 = TacitAgreementJudgeContentView.this;
                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.3.4
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final TacitAgreementJudgeContentView tacitAgreementJudgeContentView11 = TacitAgreementJudgeContentView.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.view.tacit_agreement.TacitAgreementJudgeContentView.body.1.3.3.3.4.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.positionAbsolute();
                                                        afVar2.m142left(10.0f);
                                                        afVar2.m150top(10.0f);
                                                        afVar2.size(20.0f, 20.0f);
                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_gzWxNhibYHG.png", false, 2, null);
                                                        TacitAgreementJudgeContentView tacitAgreementJudgeContentView12 = TacitAgreementJudgeContentView.this;
                                                        afVar2.m152visibility(!((Boolean) tacitAgreementJudgeContentView12.agreeIng$delegate.getValue(tacitAgreementJudgeContentView12, TacitAgreementJudgeContentView.$$delegatedProperties[2])).booleanValue());
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
        return new TacitAgreementJudgeContentViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new TacitAgreementJudgeContentViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void report(String str, Integer num) {
        Object obj;
        e eVar;
        NBPHomePageBaseViewModel nBPHomePageBaseViewModel = ((TacitAgreementJudgeContentViewAttr) getAttr()).viewModel;
        if (nBPHomePageBaseViewModel != null) {
            e jsonWithHomePagePgParams = nBPHomePageBaseViewModel.jsonWithHomePagePgParams();
            jsonWithHomePagePgParams.v("dt_eid", "em_bas_true_false_item");
            Tacit data = ((TacitAgreementJudgeContentViewAttr) getAttr()).getData();
            if (data != null) {
                obj = Integer.valueOf(data.f114238id);
            } else {
                obj = "";
            }
            jsonWithHomePagePgParams.v("question_id", obj);
            if (num != null) {
                jsonWithHomePagePgParams.t("choose_type", num.intValue());
            }
            NBPHomePageBaseViewModel nBPHomePageBaseViewModel2 = ((TacitAgreementJudgeContentViewAttr) getAttr()).viewModel;
            if (nBPHomePageBaseViewModel2 != null) {
                eVar = nBPHomePageBaseViewModel2.jsonWithHomePagePgParams();
            } else {
                eVar = new e();
            }
            jsonWithHomePagePgParams.v("cur_pg", eVar);
            jsonWithHomePagePgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
            Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, jsonWithHomePagePgParams);
        }
    }
}
