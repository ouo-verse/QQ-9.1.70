package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes31.dex */
public final class NBPLikeNumberView extends ComposeView<NBPLikeNumAttr, NBPLikeNumEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLikeNumberView.class, "topValue0", "getTopValue0()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLikeNumberView.class, "topValue1", "getTopValue1()Z", 0)};
    public final ReadWriteProperty topValue0$delegate;
    public final ReadWriteProperty topValue1$delegate;

    public NBPLikeNumberView() {
        Boolean bool = Boolean.FALSE;
        this.topValue0$delegate = c.a(bool);
        this.topValue1$delegate = c.a(bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$animationCompletion(NBPLikeNumberView nBPLikeNumberView) {
        NBPLikeNumAttr nBPLikeNumAttr = (NBPLikeNumAttr) nBPLikeNumberView.getAttr();
        nBPLikeNumAttr.number$delegate.setValue(nBPLikeNumAttr, NBPLikeNumAttr.$$delegatedProperties[0], Integer.valueOf(((NBPLikeNumAttr) nBPLikeNumberView.getAttr()).getNewNumber()));
        nBPLikeNumberView.setTopValue0(false);
        nBPLikeNumberView.setTopValue1(false);
        ((NBPLikeNumAttr) nBPLikeNumberView.getAttr()).setNeedAnimation(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$bindAnimation(NBPLikeNumberView nBPLikeNumberView) {
        NBPLikeNumAttr nBPLikeNumAttr = (NBPLikeNumAttr) nBPLikeNumberView.getAttr();
        if (((Boolean) nBPLikeNumAttr.needAnimation$delegate.getValue(nBPLikeNumAttr, NBPLikeNumAttr.$$delegatedProperties[2])).booleanValue()) {
            if (((NBPLikeNumAttr) nBPLikeNumberView.getAttr()).getNumber() > 99 || ((NBPLikeNumAttr) nBPLikeNumberView.getAttr()).getNewNumber() > 99) {
                nBPLikeNumberView.setTopValue0(false);
                nBPLikeNumberView.setTopValue1(false);
            }
            int number = ((NBPLikeNumAttr) nBPLikeNumberView.getAttr()).getNumber() / 10;
            int newNumber = ((NBPLikeNumAttr) nBPLikeNumberView.getAttr()).getNewNumber() / 10;
            int number2 = ((NBPLikeNumAttr) nBPLikeNumberView.getAttr()).getNumber() % 10;
            int newNumber2 = ((NBPLikeNumAttr) nBPLikeNumberView.getAttr()).getNewNumber() % 10;
            if (newNumber != number) {
                nBPLikeNumberView.setTopValue0(true);
                nBPLikeNumberView.setTopValue1(true);
            } else if (newNumber == number && number2 != newNumber2 && newNumber != 0) {
                nBPLikeNumberView.setTopValue1(true);
            } else if (number == 0 && newNumber == 0) {
                nBPLikeNumberView.setTopValue0(true);
                nBPLikeNumberView.setTopValue1(true);
            }
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("bindAnimation = t0: ");
            m3.append(nBPLikeNumberView.getTopValue0());
            m3.append(", t1: ");
            m3.append(((Boolean) nBPLikeNumberView.topValue1$delegate.getValue(nBPLikeNumberView, $$delegatedProperties[1])).booleanValue());
            kLog.d("NBPLikeNumberView", m3.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$fontWeight(NBPLikeNumberView nBPLikeNumberView, ce ceVar) {
        int i3 = ((NBPLikeNumAttr) nBPLikeNumberView.getAttr()).fontWeight;
        if (i3 == 300) {
            ceVar.fontWeight300();
            return;
        }
        if (i3 == 400) {
            ceVar.fontWeight400();
            return;
        }
        if (i3 == 500) {
            ceVar.fontWeight500();
            return;
        }
        if (i3 == 600) {
            ceVar.fontWeight600();
        } else if (i3 != 700) {
            ceVar.fontWeight400();
        } else {
            ceVar.fontWeight700();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPLikeNumAttr access$getAttr(NBPLikeNumberView nBPLikeNumberView) {
        return (NBPLikeNumAttr) nBPLikeNumberView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final List access$splitDigits(NBPLikeNumberView nBPLikeNumberView, int i3) {
        List reversed;
        List split$default;
        List split$default2;
        nBPLikeNumberView.getClass();
        ArrayList arrayList = new ArrayList();
        if (i3 == 0) {
            split$default2 = StringsKt__StringsKt.split$default((CharSequence) ((NBPLikeNumAttr) nBPLikeNumberView.getAttr()).defaultText, new String[]{""}, false, 0, 6, (Object) null);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : split$default2) {
                if (((String) obj).length() > 0) {
                    arrayList2.add(obj);
                }
            }
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList.add((String) it.next());
            }
            return arrayList;
        }
        if (i3 <= 99) {
            while (i3 > 0) {
                arrayList.add(String.valueOf(i3 % 10));
                i3 /= 10;
            }
            reversed = CollectionsKt___CollectionsKt.reversed(arrayList);
            return reversed;
        }
        split$default = StringsKt__StringsKt.split$default((CharSequence) "99+", new String[]{""}, false, 0, 6, (Object) null);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : split$default) {
            if (((String) obj2).length() > 0) {
                arrayList3.add(obj2);
            }
        }
        Iterator it5 = arrayList3.iterator();
        while (it5.hasNext()) {
            arrayList.add((String) it5.next());
        }
        return arrayList;
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.m140flex(1.0f);
                        return Unit.INSTANCE;
                    }
                });
                final NBPLikeNumberView nBPLikeNumberView = NBPLikeNumberView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPLikeNumAttr access$getAttr = NBPLikeNumberView.access$getAttr(NBPLikeNumberView.this);
                        return Boolean.valueOf(((Boolean) access$getAttr.needAnimation$delegate.getValue(access$getAttr, NBPLikeNumAttr.$$delegatedProperties[2])).booleanValue());
                    }
                };
                final NBPLikeNumberView nBPLikeNumberView2 = NBPLikeNumberView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        final NBPLikeNumberView nBPLikeNumberView3 = NBPLikeNumberView.this;
                        final int number = NBPLikeNumberView.access$getAttr(nBPLikeNumberView3).getNumber();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$makeAnimationView$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final NBPLikeNumberView nBPLikeNumberView4 = NBPLikeNumberView.this;
                                final int i3 = number;
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$makeAnimationView$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        final NBPLikeNumberView nBPLikeNumberView5 = NBPLikeNumberView.this;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView.makeAnimationView.1.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.mo141height(NBPLikeNumberView.access$getAttr(NBPLikeNumberView.this).innerHeight);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        List access$splitDigits = NBPLikeNumberView.access$splitDigits(NBPLikeNumberView.this, i3);
                                        final NBPLikeNumberView nBPLikeNumberView6 = NBPLikeNumberView.this;
                                        final int i16 = 0;
                                        for (Object obj : access$splitDigits) {
                                            int i17 = i16 + 1;
                                            if (i16 < 0) {
                                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                                            }
                                            final String str = (String) obj;
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$makeAnimationView$1$1$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    TextView textView2 = textView;
                                                    final String str2 = str;
                                                    final NBPLikeNumberView nBPLikeNumberView7 = nBPLikeNumberView6;
                                                    final int i18 = i16;
                                                    textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$makeAnimationView$1$1$2$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            TextViewExtKt.textWithLineHeightFix(ceVar2, str2);
                                                            ceVar2.lineHeight(NBPLikeNumberView.access$getAttr(nBPLikeNumberView7).innerHeight);
                                                            ceVar2.mo141height(NBPLikeNumberView.access$getAttr(nBPLikeNumberView7).innerHeight);
                                                            ceVar2.color(NBPLikeNumberView.access$getAttr(nBPLikeNumberView7).color);
                                                            ce.fontSize$default(ceVar2, NBPLikeNumberView.access$getAttr(nBPLikeNumberView7).fontSize, null, 2, null);
                                                            NBPLikeNumberView.access$fontWeight(nBPLikeNumberView7, ceVar2);
                                                            ceVar2.transform(new y(0.0f, nBPLikeNumberView7.getTopValue(i18) ? -1.0f : 0.0f, 0.0f, 0.0f, 12, null));
                                                            ceVar2.m134animation(b.Companion.j(b.INSTANCE, 0.5f, null, 2, null), (Object) Boolean.valueOf(nBPLikeNumberView7.getTopValue(i18)));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPLikeNumberView nBPLikeNumberView8 = nBPLikeNumberView6;
                                                    textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$makeAnimationView$1$1$2$1.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextEvent textEvent) {
                                                            TextEvent textEvent2 = textEvent;
                                                            final NBPLikeNumberView nBPLikeNumberView9 = NBPLikeNumberView.this;
                                                            FrameEventKt.d(textEvent2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView.makeAnimationView.1.1.2.1.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(d dVar) {
                                                                    NBPLikeNumberView.access$bindAnimation(NBPLikeNumberView.this);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPLikeNumberView nBPLikeNumberView10 = NBPLikeNumberView.this;
                                                            textEvent2.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView.makeAnimationView.1.1.2.1.2.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                                                    NBPLikeNumberView.access$animationCompletion(NBPLikeNumberView.this);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPLikeNumberView nBPLikeNumberView11 = NBPLikeNumberView.this;
                                                            FrameEventKt.g(textEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView.makeAnimationView.1.1.2.1.2.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(Object obj2) {
                                                                    NBPLikeNumberView.access$animationCompletion(NBPLikeNumberView.this);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPLikeNumberView nBPLikeNumberView12 = NBPLikeNumberView.this;
                                                            VisibilityEventKt.c(textEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView.makeAnimationView.1.1.2.1.2.4
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(Object obj2) {
                                                                    NBPLikeNumberView.access$animationCompletion(NBPLikeNumberView.this);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            i16 = i17;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }.invoke(conditionView2);
                        final NBPLikeNumberView nBPLikeNumberView4 = NBPLikeNumberView.this;
                        final int newNumber = NBPLikeNumberView.access$getAttr(nBPLikeNumberView4).getNewNumber();
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$makeAnimationView$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final NBPLikeNumberView nBPLikeNumberView42 = NBPLikeNumberView.this;
                                final int i3 = newNumber;
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$makeAnimationView$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        final NBPLikeNumberView nBPLikeNumberView5 = NBPLikeNumberView.this;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView.makeAnimationView.1.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.mo141height(NBPLikeNumberView.access$getAttr(NBPLikeNumberView.this).innerHeight);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        List access$splitDigits = NBPLikeNumberView.access$splitDigits(NBPLikeNumberView.this, i3);
                                        final NBPLikeNumberView nBPLikeNumberView6 = NBPLikeNumberView.this;
                                        final int i16 = 0;
                                        for (Object obj : access$splitDigits) {
                                            int i17 = i16 + 1;
                                            if (i16 < 0) {
                                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                                            }
                                            final String str = (String) obj;
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$makeAnimationView$1$1$2$1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    TextView textView2 = textView;
                                                    final String str2 = str;
                                                    final NBPLikeNumberView nBPLikeNumberView7 = nBPLikeNumberView6;
                                                    final int i18 = i16;
                                                    textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$makeAnimationView$1$1$2$1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            TextViewExtKt.textWithLineHeightFix(ceVar2, str2);
                                                            ceVar2.lineHeight(NBPLikeNumberView.access$getAttr(nBPLikeNumberView7).innerHeight);
                                                            ceVar2.mo141height(NBPLikeNumberView.access$getAttr(nBPLikeNumberView7).innerHeight);
                                                            ceVar2.color(NBPLikeNumberView.access$getAttr(nBPLikeNumberView7).color);
                                                            ce.fontSize$default(ceVar2, NBPLikeNumberView.access$getAttr(nBPLikeNumberView7).fontSize, null, 2, null);
                                                            NBPLikeNumberView.access$fontWeight(nBPLikeNumberView7, ceVar2);
                                                            ceVar2.transform(new y(0.0f, nBPLikeNumberView7.getTopValue(i18) ? -1.0f : 0.0f, 0.0f, 0.0f, 12, null));
                                                            ceVar2.m134animation(b.Companion.j(b.INSTANCE, 0.5f, null, 2, null), (Object) Boolean.valueOf(nBPLikeNumberView7.getTopValue(i18)));
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final NBPLikeNumberView nBPLikeNumberView8 = nBPLikeNumberView6;
                                                    textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$makeAnimationView$1$1$2$1.2
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextEvent textEvent) {
                                                            TextEvent textEvent2 = textEvent;
                                                            final NBPLikeNumberView nBPLikeNumberView9 = NBPLikeNumberView.this;
                                                            FrameEventKt.d(textEvent2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView.makeAnimationView.1.1.2.1.2.1
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(d dVar) {
                                                                    NBPLikeNumberView.access$bindAnimation(NBPLikeNumberView.this);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPLikeNumberView nBPLikeNumberView10 = NBPLikeNumberView.this;
                                                            textEvent2.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView.makeAnimationView.1.1.2.1.2.2
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                                                    NBPLikeNumberView.access$animationCompletion(NBPLikeNumberView.this);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPLikeNumberView nBPLikeNumberView11 = NBPLikeNumberView.this;
                                                            FrameEventKt.g(textEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView.makeAnimationView.1.1.2.1.2.3
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(Object obj2) {
                                                                    NBPLikeNumberView.access$animationCompletion(NBPLikeNumberView.this);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            final NBPLikeNumberView nBPLikeNumberView12 = NBPLikeNumberView.this;
                                                            VisibilityEventKt.c(textEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView.makeAnimationView.1.1.2.1.2.4
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(Object obj2) {
                                                                    NBPLikeNumberView.access$animationCompletion(NBPLikeNumberView.this);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            i16 = i17;
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        }.invoke(conditionView2);
                        return Unit.INSTANCE;
                    }
                });
                final NBPLikeNumberView nBPLikeNumberView3 = NBPLikeNumberView.this;
                ConditionViewKt.a(viewContainer2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPLikeNumberView nBPLikeNumberView4 = NBPLikeNumberView.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView.body.1.4.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Integer.valueOf(NBPLikeNumberView.access$getAttr(NBPLikeNumberView.this).getNumber());
                            }
                        };
                        final NBPLikeNumberView nBPLikeNumberView5 = NBPLikeNumberView.this;
                        BindDirectivesViewKt.a(conditionView, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                final NBPLikeNumberView nBPLikeNumberView6 = NBPLikeNumberView.this;
                                final int number = NBPLikeNumberView.access$getAttr(nBPLikeNumberView6).getNumber();
                                new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$makeStaticView$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                        final NBPLikeNumberView nBPLikeNumberView7 = NBPLikeNumberView.this;
                                        final int i3 = number;
                                        w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$makeStaticView$1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                final NBPLikeNumberView nBPLikeNumberView8 = NBPLikeNumberView.this;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView.makeStaticView.1.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionRow();
                                                        tVar2.mo141height(NBPLikeNumberView.access$getAttr(NBPLikeNumberView.this).innerHeight);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                List access$splitDigits = NBPLikeNumberView.access$splitDigits(NBPLikeNumberView.this, i3);
                                                final NBPLikeNumberView nBPLikeNumberView9 = NBPLikeNumberView.this;
                                                int i16 = 0;
                                                for (Object obj : access$splitDigits) {
                                                    int i17 = i16 + 1;
                                                    if (i16 < 0) {
                                                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                    }
                                                    final String str = (String) obj;
                                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$makeStaticView$1$1$2$1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            final String str2 = str;
                                                            final NBPLikeNumberView nBPLikeNumberView10 = nBPLikeNumberView9;
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeNumberView$makeStaticView$1$1$2$1.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    TextViewExtKt.textWithLineHeightFix(ceVar2, str2);
                                                                    ceVar2.mo141height(NBPLikeNumberView.access$getAttr(nBPLikeNumberView10).innerHeight);
                                                                    ceVar2.lineHeight(NBPLikeNumberView.access$getAttr(nBPLikeNumberView10).innerHeight);
                                                                    ceVar2.color(NBPLikeNumberView.access$getAttr(nBPLikeNumberView10).color);
                                                                    ce.fontSize$default(ceVar2, NBPLikeNumberView.access$getAttr(nBPLikeNumberView10).fontSize, null, 2, null);
                                                                    NBPLikeNumberView.access$fontWeight(nBPLikeNumberView10, ceVar2);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            });
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    i16 = i17;
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                }.invoke(bindDirectivesView);
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
        return new NBPLikeNumAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPLikeNumEvent();
    }

    public final boolean getTopValue0() {
        return ((Boolean) this.topValue0$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setTopValue0(boolean z16) {
        this.topValue0$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }

    public final void setTopValue1(boolean z16) {
        this.topValue1$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }

    public final boolean getTopValue(int i3) {
        if (i3 == 0) {
            return getTopValue0();
        }
        if (i3 != 1) {
            return getTopValue0();
        }
        return ((Boolean) this.topValue1$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }
}
