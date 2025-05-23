package com.tencent.hippykotlin.demo.pages.nearby.new_guide.view;

import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import t35.a;

/* loaded from: classes31.dex */
public final class NBPGuideTagPickerView extends ComposeView<NBPGuideTagPickerAttr, NBPGuideTagPickerEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPGuideTagPickerAttr access$getAttr(NBPGuideTagPickerView nBPGuideTagPickerView) {
        return (NBPGuideTagPickerAttr) nBPGuideTagPickerView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagPickerView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPGuideTagPickerView nBPGuideTagPickerView = NBPGuideTagPickerView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagPickerView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionRow();
                        mVar2.flexWrapWrap();
                        mVar2.mo153width(NBPGuideViewConstKt.pageViewFitWidth(NBPGuideTagPickerView.this));
                        mVar2.paddingLeft(24.0f);
                        mVar2.paddingRight(24.0f);
                        mVar2.justifyContentSpaceBetween();
                        return Unit.INSTANCE;
                    }
                });
                final NBPGuideTagPickerView nBPGuideTagPickerView2 = NBPGuideTagPickerView.this;
                Function0<c<a>> function0 = new Function0<c<a>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagPickerView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final c<a> invoke() {
                        NBPGuideTagPickerAttr access$getAttr = NBPGuideTagPickerView.access$getAttr(NBPGuideTagPickerView.this);
                        return (c) access$getAttr.tagList$delegate.getValue(access$getAttr, NBPGuideTagPickerAttr.$$delegatedProperties[0]);
                    }
                };
                final NBPGuideTagPickerView nBPGuideTagPickerView3 = NBPGuideTagPickerView.this;
                LoopDirectivesViewKt.b(viewContainer2, function0, new Function4<LoopDirectivesView<a>, a, Integer, Integer, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagPickerView$body$1.3
                    {
                        super(4);
                    }

                    @Override // kotlin.jvm.functions.Function4
                    public final Unit invoke(LoopDirectivesView<a> loopDirectivesView, a aVar, Integer num, Integer num2) {
                        final a aVar2 = aVar;
                        final int intValue = num.intValue();
                        num2.intValue();
                        final NBPGuideTagPickerView nBPGuideTagPickerView4 = NBPGuideTagPickerView.this;
                        final int i3 = 3;
                        w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagPickerView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final NBPGuideTagPickerView nBPGuideTagPickerView5 = NBPGuideTagPickerView.this;
                                final int i16 = i3;
                                final int i17 = intValue;
                                final a aVar3 = aVar2;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagPickerView.body.1.3.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        NBPGuideTagPickerView nBPGuideTagPickerView6 = NBPGuideTagPickerView.this;
                                        int i18 = i16;
                                        int i19 = NBPGuideTagPickerView.$r8$clinit;
                                        tVar2.mo153width((Math.min(nBPGuideTagPickerView6.getPagerData().m(), 420.0f) - 72.0f) / i18);
                                        tVar2.mo141height(44.0f);
                                        tVar2.allCenter();
                                        tVar2.flexDirectionRow();
                                        tVar2.padding(4.0f);
                                        if (i17 / i16 != 0) {
                                            tVar2.marginTop(12.0f);
                                        } else {
                                            tVar2.marginTop(0.0f);
                                        }
                                        tVar2.borderRadius(8.0f);
                                        tVar2.m136border(new e(0.5f, BorderStyle.SOLID, QUIToken.color$default("fill_standard_quaternary")));
                                        c<a> selectedTagList = NBPGuideTagPickerView.access$getAttr(NBPGuideTagPickerView.this).getSelectedTagList();
                                        a aVar4 = aVar3;
                                        boolean z16 = false;
                                        if (!(selectedTagList instanceof Collection) || !selectedTagList.isEmpty()) {
                                            Iterator<a> it = selectedTagList.iterator();
                                            while (true) {
                                                if (!it.hasNext()) {
                                                    break;
                                                }
                                                if (it.next().f435362d == aVar4.f435362d) {
                                                    z16 = true;
                                                    break;
                                                }
                                            }
                                        }
                                        if (z16) {
                                            tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_brand"));
                                        } else {
                                            tVar2.mo113backgroundColor(h.INSTANCE.j());
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final a aVar4 = aVar2;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagPickerView.body.1.3.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final a aVar5 = a.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagPickerView.body.1.3.1.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                Object firstOrNull;
                                                af afVar2 = afVar;
                                                afVar2.mo153width(20.0f);
                                                afVar2.mo141height(20.0f);
                                                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) a.this.f435364f);
                                                String str = (String) firstOrNull;
                                                if (str == null) {
                                                    str = "";
                                                }
                                                b.a.b(afVar2, str, false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final a aVar5 = aVar2;
                                final NBPGuideTagPickerView nBPGuideTagPickerView6 = NBPGuideTagPickerView.this;
                                final int i18 = i3;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagPickerView.body.1.3.1.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final a aVar6 = a.this;
                                        final NBPGuideTagPickerView nBPGuideTagPickerView7 = nBPGuideTagPickerView6;
                                        final int i19 = i18;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagPickerView.body.1.3.1.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.fontWeight400();
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.text(a.this.f435363e);
                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                ceVar2.marginLeft(4.0f);
                                                ceVar2.textOverFlowTail();
                                                NBPGuideTagPickerView nBPGuideTagPickerView8 = nBPGuideTagPickerView7;
                                                int i26 = i19;
                                                int i27 = NBPGuideTagPickerView.$r8$clinit;
                                                ceVar2.m144maxWidth(((Math.min(nBPGuideTagPickerView8.getPagerData().m(), 420.0f) - 72.0f) / i26) - 28.0f);
                                                ceVar2.lines(1);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPGuideTagPickerView nBPGuideTagPickerView7 = NBPGuideTagPickerView.this;
                                final a aVar6 = aVar2;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagPickerView.body.1.3.1.4
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPGuideTagPickerView nBPGuideTagPickerView8 = NBPGuideTagPickerView.this;
                                        final a aVar7 = aVar6;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_guide.view.NBPGuideTagPickerView.body.1.3.1.4.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Multi-variable type inference failed */
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                if (NBPGuideTagPickerView.access$getAttr(NBPGuideTagPickerView.this).getSelectedTagList().contains(aVar7)) {
                                                    NBPGuideTagPickerView.access$getAttr(NBPGuideTagPickerView.this).getSelectedTagList().remove(aVar7);
                                                } else {
                                                    NBPGuideTagPickerView.access$getAttr(NBPGuideTagPickerView.this).getSelectedTagList().add(aVar7);
                                                }
                                                Function1<? super a, Unit> function1 = ((NBPGuideTagPickerEvent) NBPGuideTagPickerView.this.getViewEvent()).eventHandler;
                                                if (function1 != null) {
                                                    function1.invoke(aVar7);
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
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPGuideTagPickerAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPGuideTagPickerEvent();
    }
}
