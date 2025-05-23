package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.ck;
import com.tencent.kuikly.core.views.cm;
import com.tencent.kuikly.core.views.cn;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes31.dex */
public final class NBPNewQQEmojiView extends ComposeView<NBPNewQQEmojiAttr, NBPNewQQEmojiEvent> {
    public static final /* synthetic */ int $r8$clinit = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPNewQQEmojiAttr access$getAttr(NBPNewQQEmojiView nBPNewQQEmojiView) {
        return (NBPNewQQEmojiAttr) nBPNewQQEmojiView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPNewQQEmojiEvent access$getEvent(NBPNewQQEmojiView nBPNewQQEmojiView) {
        return (NBPNewQQEmojiEvent) nBPNewQQEmojiView.getEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final int m3 = (int) (getPagerData().m() / 50.0f);
        final float f16 = m3 * 50.0f;
        final float m16 = ((getPagerData().m() - f16) / 2.0f) - 0.1f;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.mo113backgroundColor(h.INSTANCE.m());
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        event.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPNewQQEmojiView nBPNewQQEmojiView = NBPNewQQEmojiView.this;
                final float f17 = f16;
                final int i3 = m3;
                final float f18 = m16;
                cn.a(viewContainer2, new Function1<cm, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(cm cmVar) {
                        String decodeToString;
                        String decodeToString2;
                        cm cmVar2 = cmVar;
                        final int i16 = i3;
                        final float f19 = f18;
                        cmVar2.attr(new Function1<ck, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ck ckVar) {
                                ck ckVar2 = ckVar;
                                ckVar2.m140flex(1.0f);
                                ckVar2.firstContentLoadMaxIndex(i16 * 6);
                                float f26 = ckVar2.getPagerData().getIsIphoneX() ? 65.0f : 55.0f;
                                float f27 = f19;
                                ckVar2.i(0.0f, f27, f26, f27);
                                ckVar2.h(i16);
                                ckVar2.w(ckVar2.getPagerData().m());
                                ckVar2.mo113backgroundColor(QUIToken.color$default("fill_light_primary"));
                                return Unit.INSTANCE;
                            }
                        });
                        NBPNewQQEmojiView nBPNewQQEmojiView2 = NBPNewQQEmojiView.this;
                        final float f26 = f17;
                        int i17 = NBPNewQQEmojiView.$r8$clinit;
                        nBPNewQQEmojiView2.getClass();
                        final String str = "\u5168\u90e8\u8868\u60c5";
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView$createHeader$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final float f27 = f26;
                                final String str2 = str;
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView$createHeader$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        final float f28 = f27;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createHeader.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo153width(f28);
                                                tVar2.mo141height(45.0f);
                                                tVar2.justifyContentCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final String str3 = str2;
                                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createHeader.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final String str4 = str3;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createHeader.1.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text(str4);
                                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                                        ceVar2.marginLeft(3.0f);
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
                        }.invoke(cmVar2);
                        Object syncToNativeMethod = ((QQKuiklyPlatformApi) cmVar2.acquireModule("QQKuiklyPlatformApi")).syncToNativeMethod("getAllClassicEmojis", new Object[0], (Function1<Object, Unit>) null);
                        ArrayList arrayList = new ArrayList();
                        if (syncToNativeMethod instanceof Object[]) {
                            for (Object obj : (Object[]) syncToNativeMethod) {
                                if (obj instanceof byte[]) {
                                    decodeToString2 = StringsKt__StringsJVMKt.decodeToString((byte[]) obj);
                                    arrayList.add(decodeToString2);
                                }
                            }
                        }
                        final NBPNewQQEmojiView nBPNewQQEmojiView3 = NBPNewQQEmojiView.this;
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            final String str2 = (String) it.next();
                            nBPNewQQEmojiView3.getClass();
                            final float f27 = 30.0f;
                            new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView$createEmojiItem$1
                                public final /* synthetic */ float $itemWidth = 50.0f;

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                    final float f28 = this.$itemWidth;
                                    final NBPNewQQEmojiView nBPNewQQEmojiView4 = NBPNewQQEmojiView.this;
                                    final String str3 = str2;
                                    final float f29 = f27;
                                    w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView$createEmojiItem$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            final float f36 = f28;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createEmojiItem.1.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    float f37 = f36;
                                                    tVar2.size(f37, f37);
                                                    tVar2.allCenter();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPNewQQEmojiView nBPNewQQEmojiView5 = nBPNewQQEmojiView4;
                                            final String str4 = str3;
                                            vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createEmojiItem.1.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    final NBPNewQQEmojiView nBPNewQQEmojiView6 = NBPNewQQEmojiView.this;
                                                    final String str5 = str4;
                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createEmojiItem.1.1.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            Function1<Object, Unit> function1 = ((NBPNewQQEmojiEvent) NBPNewQQEmojiView.this.getViewEvent()).addEmojiCallbackFn;
                                                            if (function1 != null) {
                                                                e eVar = new e();
                                                                eVar.z("emoji", str5);
                                                                function1.invoke(eVar);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final String str5 = str3;
                                            final float f37 = f29;
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createEmojiItem.1.1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final String str6 = str5;
                                                    final float f38 = f37;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createEmojiItem.1.1.3.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.text(str6);
                                                            ceVar2.textPostProcessor("emoji");
                                                            ce.fontSize$default(ceVar2, f38, null, 2, null);
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

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }
                            }.invoke(cmVar2);
                        }
                        NBPNewQQEmojiView nBPNewQQEmojiView4 = NBPNewQQEmojiView.this;
                        final float f28 = f17;
                        nBPNewQQEmojiView4.getClass();
                        final String str3 = "emoji\u8868\u60c5";
                        new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView$createHeader$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                final float f272 = f28;
                                final String str22 = str3;
                                w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView$createHeader$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        final float f282 = f272;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createHeader.1.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo153width(f282);
                                                tVar2.mo141height(45.0f);
                                                tVar2.justifyContentCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final String str32 = str22;
                                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createHeader.1.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final String str4 = str32;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createHeader.1.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text(str4);
                                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                                        ceVar2.marginLeft(3.0f);
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
                        }.invoke(cmVar2);
                        Object syncToNativeMethod2 = ((QQKuiklyPlatformApi) cmVar2.acquireModule("QQKuiklyPlatformApi")).syncToNativeMethod("getSystemEmojis", new Object[0], (Function1<Object, Unit>) null);
                        ArrayList arrayList2 = new ArrayList();
                        if (syncToNativeMethod2 instanceof Object[]) {
                            for (Object obj2 : (Object[]) syncToNativeMethod2) {
                                if (obj2 instanceof byte[]) {
                                    decodeToString = StringsKt__StringsJVMKt.decodeToString((byte[]) obj2);
                                    arrayList2.add(decodeToString);
                                }
                            }
                        }
                        final NBPNewQQEmojiView nBPNewQQEmojiView5 = NBPNewQQEmojiView.this;
                        Iterator it5 = arrayList2.iterator();
                        while (it5.hasNext()) {
                            final String str4 = (String) it5.next();
                            nBPNewQQEmojiView5.getClass();
                            final float f29 = 35.0f;
                            new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView$createEmojiItem$1
                                public final /* synthetic */ float $itemWidth = 50.0f;

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ViewContainer<?, ?> viewContainer3) {
                                    final float f282 = this.$itemWidth;
                                    final NBPNewQQEmojiView nBPNewQQEmojiView42 = NBPNewQQEmojiView.this;
                                    final String str32 = str4;
                                    final float f292 = f29;
                                    w.a(viewContainer3, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView$createEmojiItem$1.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            v vVar2 = vVar;
                                            final float f36 = f282;
                                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createEmojiItem.1.1.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    float f37 = f36;
                                                    tVar2.size(f37, f37);
                                                    tVar2.allCenter();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NBPNewQQEmojiView nBPNewQQEmojiView52 = nBPNewQQEmojiView42;
                                            final String str42 = str32;
                                            vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createEmojiItem.1.1.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    final NBPNewQQEmojiView nBPNewQQEmojiView6 = NBPNewQQEmojiView.this;
                                                    final String str5 = str42;
                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createEmojiItem.1.1.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        /* JADX WARN: Multi-variable type inference failed */
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            Function1<Object, Unit> function1 = ((NBPNewQQEmojiEvent) NBPNewQQEmojiView.this.getViewEvent()).addEmojiCallbackFn;
                                                            if (function1 != null) {
                                                                e eVar = new e();
                                                                eVar.z("emoji", str5);
                                                                function1.invoke(eVar);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final String str5 = str32;
                                            final float f37 = f292;
                                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createEmojiItem.1.1.3
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final String str6 = str5;
                                                    final float f38 = f37;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.createEmojiItem.1.1.3.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.text(str6);
                                                            ceVar2.textPostProcessor("emoji");
                                                            ce.fontSize$default(ceVar2, f38, null, 2, null);
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

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }
                            }.invoke(cmVar2);
                        }
                        return Unit.INSTANCE;
                    }
                });
                final NBPNewQQEmojiView nBPNewQQEmojiView2 = NBPNewQQEmojiView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView$body$1.4
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NBPNewQQEmojiAttr access$getAttr = NBPNewQQEmojiView.access$getAttr(NBPNewQQEmojiView.this);
                        return Boolean.valueOf(((Boolean) access$getAttr.showDeleteBtn$delegate.getValue(access$getAttr, NBPNewQQEmojiAttr.$$delegatedProperties[0])).booleanValue());
                    }
                };
                final NBPNewQQEmojiView nBPNewQQEmojiView3 = NBPNewQQEmojiView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        final NBPNewQQEmojiView nBPNewQQEmojiView4 = NBPNewQQEmojiView.this;
                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.5.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, tVar2.getPagerData().getIsIphoneX() ? 34.0f : 20.0f, 10.0f, 3, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPNewQQEmojiView nBPNewQQEmojiView5 = NBPNewQQEmojiView.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.5.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.5.1.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(60.0f, 37.0f);
                                                tVar2.allCenter();
                                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_top_light"));
                                                tVar2.borderRadius(4.0f);
                                                tVar2.mo139boxShadow(new g(0.0f, 0.0f, 6.0f, new h(0, 0, 0, 0.2f)));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPNewQQEmojiView nBPNewQQEmojiView6 = NBPNewQQEmojiView.this;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.5.1.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPNewQQEmojiView nBPNewQQEmojiView7 = NBPNewQQEmojiView.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.5.1.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Function1<Object, Unit> function1 = NBPNewQQEmojiView.access$getEvent(NBPNewQQEmojiView.this).onDeleteBtnClickFn;
                                                        if (function1 != null) {
                                                            function1.invoke(null);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.5.1.2.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.5.1.2.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        b.a.b(afVar2, "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/Z05dgFGL.png", false, 2, null);
                                                        afVar2.size(25.0f, 25.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPNewQQEmojiView nBPNewQQEmojiView6 = NBPNewQQEmojiView.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.5.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.5.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(60.0f, 37.0f);
                                                tVar2.allCenter();
                                                tVar2.marginTop(12.0f);
                                                tVar2.mo113backgroundColor(QUIToken.color$default("button_bg_primary_default"));
                                                tVar2.borderRadius(4.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPNewQQEmojiView nBPNewQQEmojiView7 = NBPNewQQEmojiView.this;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.5.1.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPNewQQEmojiView nBPNewQQEmojiView8 = NBPNewQQEmojiView.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.5.1.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        Function1<Object, Unit> function1 = NBPNewQQEmojiView.access$getEvent(NBPNewQQEmojiView.this).onSendBtnClickFn;
                                                        if (function1 != null) {
                                                            function1.invoke(null);
                                                        }
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.5.1.3.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPNewQQEmojiView.body.1.5.1.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.fontWeight500();
                                                        ceVar2.text("\u53d1\u9001");
                                                        ceVar2.color(QUIToken.color$default("button_text_primary_default"));
                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
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
        return new NBPNewQQEmojiAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPNewQQEmojiEvent();
    }
}
