package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.NBPMarkerStatus;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.a;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.e;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.q;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NBPPersonMarkerFocusedAttachmentView extends ComposeView<NBPPersonMarkerFocusedAttachmentAttr, NBPPersonMarkerFocusedAttachmentEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPPersonMarkerFocusedAttachmentView.class, NodeProps.VISIBLE, "getVisible()Z", 0)};
    public String hideTimeoutHandle;
    public aa<v> leftTagRef;
    public aa<v> onlineRef;
    public aa<v> rightTagRef;
    public aa<v> sayHiRef;
    public final ReadWriteProperty visible$delegate = c.a(Boolean.FALSE);

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPPersonMarkerFocusedAttachmentAttr access$getAttr(NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView) {
        return (NBPPersonMarkerFocusedAttachmentAttr) nBPPersonMarkerFocusedAttachmentView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        Object orNull;
        Object orNull2;
        orNull = CollectionsKt___CollectionsKt.getOrNull(((NBPPersonMarkerFocusedAttachmentAttr) getAttr()).tags, 0);
        final String str = (String) orNull;
        orNull2 = CollectionsKt___CollectionsKt.getOrNull(((NBPPersonMarkerFocusedAttachmentAttr) getAttr()).tags, 1);
        final String str2 = (String) orNull2;
        if (str2 == null) {
            str2 = "\u9644\u8fd1\u65b0\u4eba";
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.absolutePositionAllZero();
                        mVar2.size(0.0f);
                        mVar2.m142left(14.0f);
                        mVar2.m150top(14.0f);
                        return Unit.INSTANCE;
                    }
                });
                final NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView = NBPPersonMarkerFocusedAttachmentView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        boolean booleanValue;
                        booleanValue = ((Boolean) r0.visible$delegate.getValue(NBPPersonMarkerFocusedAttachmentView.this, NBPPersonMarkerFocusedAttachmentView.$$delegatedProperties[0])).booleanValue();
                        return Boolean.valueOf(booleanValue);
                    }
                };
                final String str3 = str;
                final NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView2 = NBPPersonMarkerFocusedAttachmentView.this;
                final String str4 = str2;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        final NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView3 = nBPPersonMarkerFocusedAttachmentView2;
                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView4 = NBPPersonMarkerFocusedAttachmentView.this;
                                vVar2.ref(vVar2, new Function1<aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<v> aaVar) {
                                        NBPPersonMarkerFocusedAttachmentView.this.sayHiRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        tVar2.mo141height(80.0f);
                                        tVar2.mo153width(200.0f);
                                        tVar2.m142left(-100.0f);
                                        tVar2.m150top(0.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.justifyContentCenter();
                                        tVar2.m147opacity(0.0f);
                                        d.a.a(tVar2, null, NBPPersonMarkerFocusedAttachmentViewKt.minScale, null, new a(0.5f, 0.0f), null, 21, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.1.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.1.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(82.0f, 32.0f);
                                                h.Companion companion = h.INSTANCE;
                                                tVar2.mo113backgroundColor(companion.m());
                                                NBPMainKtxKt.boxShadowWithBlackSet$default(tVar2, new g(0.0f, 4.0f, 12.0f, companion.a(0.12f)));
                                                tVar2.borderRadius(16.0f);
                                                tVar2.m136border(new e(1.24f, BorderStyle.SOLID, companion.a(0.1f)));
                                                tVar2.allCenter();
                                                tVar2.flexDirectionRow();
                                                tVar2.marginTop(33.64f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.1.3.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.1.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_3GACz8aHqBb.png", false, 2, null);
                                                        afVar2.size(20.0f);
                                                        afVar2.marginRight(4.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.1.3.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.1.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, "\u6253\u62db\u547c");
                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                        ceVar2.lineHeight(17.0f);
                                                        ceVar2.fontWeight400();
                                                        ceVar2.color(h.INSTANCE.b());
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
                        final String str5 = str3;
                        if (str5 != null) {
                            final NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView4 = nBPPersonMarkerFocusedAttachmentView2;
                            w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    final NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView5 = NBPPersonMarkerFocusedAttachmentView.this;
                                    vVar2.ref(vVar2, new Function1<aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(aa<v> aaVar) {
                                            NBPPersonMarkerFocusedAttachmentView.this.leftTagRef = aaVar;
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.2.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                            tVar2.mo141height(48.0f);
                                            tVar2.mo153width(200.0f);
                                            tVar2.m142left(-200.0f);
                                            tVar2.m150top(-24.0f);
                                            tVar2.m147opacity(0.0f);
                                            d.a.a(tVar2, new com.tencent.kuikly.core.base.t(20.0f, 0.0f, 0.0f, 6, null), NBPPersonMarkerFocusedAttachmentViewKt.minScale, null, new a(1.0f, 0.5f), null, 20, null);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final String str6 = str5;
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.2.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.2.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    tVar2.flexDirectionRow();
                                                    Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                                    tVar2.m149right(32.81f);
                                                    tVar2.m150top(15.0f);
                                                    NBPMainKtxKt.boxShadowWithBlackSet$default(tVar2, new g(0.0f, 2.4f, 4.8f, h.INSTANCE.a(0.12f)));
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final String str7 = str6;
                                            w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.2.3.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(v vVar5) {
                                                    v vVar6 = vVar5;
                                                    vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.2.3.2.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(t tVar) {
                                                            t tVar2 = tVar;
                                                            tVar2.borderRadius(10.0f);
                                                            tVar2.mo113backgroundColor(h.INSTANCE.m());
                                                            tVar2.mo141height(20.0f);
                                                            tVar2.paddingLeft(7.23f);
                                                            tVar2.paddingRight(7.23f);
                                                            tVar2.allCenter();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final String str8 = str7;
                                                    cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.2.3.2.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(TextView textView) {
                                                            final String str9 = str8;
                                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.2.3.2.2.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(ce ceVar) {
                                                                    ce ceVar2 = ceVar;
                                                                    TextViewExtKt.textWithLineHeightFix(ceVar2, str9);
                                                                    ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                                    ceVar2.lineHeight(14.0f);
                                                                    ceVar2.fontWeight500();
                                                                    ceVar2.color(new h(4279901214L));
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
                        }
                        final NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView5 = nBPPersonMarkerFocusedAttachmentView2;
                        final String str6 = str4;
                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView6 = NBPPersonMarkerFocusedAttachmentView.this;
                                vVar2.ref(vVar2, new Function1<aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<v> aaVar) {
                                        NBPPersonMarkerFocusedAttachmentView.this.rightTagRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        tVar2.mo141height(40.0f);
                                        tVar2.mo153width(200.0f);
                                        tVar2.m142left(0.0f);
                                        tVar2.m150top(-10.0f);
                                        tVar2.m147opacity(0.0f);
                                        d.a.a(tVar2, new com.tencent.kuikly.core.base.t(-20.0f, 0.0f, 0.0f, 6, null), NBPPersonMarkerFocusedAttachmentViewKt.minScale, null, new a(0.0f, 0.25f), null, 20, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final String str7 = str6;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.3.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                                tVar2.m142left(32.0f);
                                                tVar2.m150top(10.0f);
                                                NBPMainKtxKt.boxShadowWithBlackSet$default(tVar2, new g(0.0f, 2.4f, 4.8f, h.INSTANCE.a(0.12f)));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final String str8 = str7;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.3.3.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.3.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.borderRadius(10.0f);
                                                        tVar2.mo113backgroundColor(h.INSTANCE.m());
                                                        tVar2.mo141height(20.0f);
                                                        tVar2.paddingLeft(10.75f);
                                                        tVar2.paddingRight(10.75f);
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final String str9 = str8;
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.3.3.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final String str10 = str9;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.3.3.2.2.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                TextViewExtKt.textWithLineHeightFix(ceVar2, str10);
                                                                ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                                ceVar2.lineHeight(14.0f);
                                                                ceVar2.fontWeight500();
                                                                ceVar2.color(new h(4279901214L));
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
                        final NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView6 = nBPPersonMarkerFocusedAttachmentView2;
                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                final NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView7 = NBPPersonMarkerFocusedAttachmentView.this;
                                vVar2.ref(vVar2, new Function1<aa<v>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<v> aaVar) {
                                        NBPPersonMarkerFocusedAttachmentView.this.onlineRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.4.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                        tVar2.mo141height(40.0f);
                                        tVar2.mo153width(200.0f);
                                        tVar2.m142left(0.0f);
                                        tVar2.m150top(-30.0f);
                                        tVar2.m147opacity(0.0f);
                                        d.a.a(tVar2, new com.tencent.kuikly.core.base.t(20.0f, 0.0f, 0.0f, 6, null), NBPPersonMarkerFocusedAttachmentViewKt.minScale, null, new a(0.0f, 0.75f), null, 20, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.4.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.4.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                                tVar2.m142left(32.0f);
                                                tVar2.m138bottom(10.0f);
                                                NBPMainKtxKt.boxShadowWithBlackSet$default(tVar2, new g(0.0f, 2.4f, 4.8f, h.INSTANCE.a(0.12f)));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.4.3.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.4.3.2.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.borderRadius(10.0f);
                                                        tVar2.mo113backgroundColor(h.INSTANCE.m());
                                                        tVar2.mo141height(20.0f);
                                                        tVar2.paddingLeft(7.2f);
                                                        tVar2.paddingRight(7.2f);
                                                        tVar2.allCenter();
                                                        tVar2.flexDirectionRow();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.4.3.2.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.4.3.2.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.size(6.0f);
                                                                tVar2.borderRadius(3.0f);
                                                                tVar2.marginRight(2.0f);
                                                                tVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(4289527673L), 0.0f), new j(new h(4282187697L), 0.5f), new j(new h(4282184703L), 1.0f));
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.4.3.2.3
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView.body.1.3.4.3.2.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                TextViewExtKt.textWithLineHeightFix(ceVar2, "\u5728\u7ebf\u4e2d");
                                                                ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                                ceVar2.lineHeight(14.0f);
                                                                ceVar2.fontWeight500();
                                                                ceVar2.color(new h(4279901214L));
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
        return new NBPPersonMarkerFocusedAttachmentAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPPersonMarkerFocusedAttachmentEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDestroyed() {
        super.viewDestroyed();
        unbindAllValueChange();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        bindValueChange(new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$viewDidLoad$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                NBPPersonMarkerFocusedAttachmentAttr access$getAttr = NBPPersonMarkerFocusedAttachmentView.access$getAttr(NBPPersonMarkerFocusedAttachmentView.this);
                return (NBPMarkerStatus) access$getAttr.markerStatus$delegate.getValue(access$getAttr, NBPPersonMarkerFocusedAttachmentAttr.$$delegatedProperties[0]);
            }
        }, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$viewDidLoad$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Object obj) {
                boolean booleanValue;
                v b16;
                v b17;
                v b18;
                v b19;
                if (obj == NBPMarkerStatus.Focused) {
                    NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView = NBPPersonMarkerFocusedAttachmentView.this;
                    nBPPersonMarkerFocusedAttachmentView.visible$delegate.setValue(nBPPersonMarkerFocusedAttachmentView, NBPPersonMarkerFocusedAttachmentView.$$delegatedProperties[0], Boolean.TRUE);
                    final NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView2 = NBPPersonMarkerFocusedAttachmentView.this;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$viewDidLoad$2.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            v b26;
                            v b27;
                            v b28;
                            v b29;
                            NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView3 = NBPPersonMarkerFocusedAttachmentView.this;
                            aa<v> aaVar = nBPPersonMarkerFocusedAttachmentView3.sayHiRef;
                            if (aaVar != null && (b29 = aaVar.b()) != null) {
                                com.tencent.kuikly.core.base.b t16 = b.Companion.t(com.tencent.kuikly.core.base.b.INSTANCE, 0.8f, 0.6f, 0.0f, null, 8, null);
                                t16.h(0.125f);
                                q.a.a(b29, t16, null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$animateShow$1$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Attr attr) {
                                        Attr attr2 = attr;
                                        attr2.m147opacity(1.0f);
                                        d.a.a(attr2, null, NBPPersonMarkerFocusedAttachmentViewKt.maxScale, null, new a(0.5f, 0.0f), null, 21, null);
                                        return Unit.INSTANCE;
                                    }
                                }, 2, null);
                            }
                            aa<v> aaVar2 = nBPPersonMarkerFocusedAttachmentView3.leftTagRef;
                            if (aaVar2 != null && (b28 = aaVar2.b()) != null) {
                                com.tencent.kuikly.core.base.b t17 = b.Companion.t(com.tencent.kuikly.core.base.b.INSTANCE, 0.8f, 0.6f, 0.0f, null, 8, null);
                                t17.h(0.16f);
                                q.a.a(b28, t17, null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$animateShow$2$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Attr attr) {
                                        Attr attr2 = attr;
                                        attr2.m147opacity(1.0f);
                                        d.a.a(attr2, new com.tencent.kuikly.core.base.t(0.0f, 0.0f, 0.0f, 6, null), NBPPersonMarkerFocusedAttachmentViewKt.maxScale, null, new a(1.0f, 0.5f), null, 20, null);
                                        return Unit.INSTANCE;
                                    }
                                }, 2, null);
                            }
                            aa<v> aaVar3 = nBPPersonMarkerFocusedAttachmentView3.rightTagRef;
                            if (aaVar3 != null && (b27 = aaVar3.b()) != null) {
                                com.tencent.kuikly.core.base.b t18 = b.Companion.t(com.tencent.kuikly.core.base.b.INSTANCE, 0.8f, 0.6f, 0.0f, null, 8, null);
                                t18.h(0.08f);
                                q.a.a(b27, t18, null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$animateShow$3$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Attr attr) {
                                        Attr attr2 = attr;
                                        attr2.m147opacity(1.0f);
                                        d.a.a(attr2, new com.tencent.kuikly.core.base.t(3.6f, 0.0f, 0.0f, 6, null), NBPPersonMarkerFocusedAttachmentViewKt.maxScale, null, new a(0.0f, 0.25f), null, 20, null);
                                        return Unit.INSTANCE;
                                    }
                                }, 2, null);
                            }
                            aa<v> aaVar4 = nBPPersonMarkerFocusedAttachmentView3.onlineRef;
                            if (aaVar4 != null && (b26 = aaVar4.b()) != null) {
                                com.tencent.kuikly.core.base.b t19 = b.Companion.t(com.tencent.kuikly.core.base.b.INSTANCE, 0.8f, 0.6f, 0.0f, null, 8, null);
                                t19.h(0.0f);
                                q.a.a(b26, t19, null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$animateShow$4$2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Attr attr) {
                                        Attr attr2 = attr;
                                        attr2.m147opacity(1.0f);
                                        d.a.a(attr2, new com.tencent.kuikly.core.base.t(-5.57f, 0.0f, 0.0f, 6, null), NBPPersonMarkerFocusedAttachmentViewKt.maxScale, null, new a(0.0f, 0.75f), null, 20, null);
                                        return Unit.INSTANCE;
                                    }
                                }, 2, null);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                    TimerKt.e(nBPPersonMarkerFocusedAttachmentView2.getPagerId(), 50, function0);
                } else {
                    booleanValue = ((Boolean) r11.visible$delegate.getValue(NBPPersonMarkerFocusedAttachmentView.this, NBPPersonMarkerFocusedAttachmentView.$$delegatedProperties[0])).booleanValue();
                    if (booleanValue) {
                        final NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView3 = NBPPersonMarkerFocusedAttachmentView.this;
                        final Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$viewDidLoad$2.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                boolean booleanValue2;
                                booleanValue2 = ((Boolean) r0.visible$delegate.getValue(NBPPersonMarkerFocusedAttachmentView.this, NBPPersonMarkerFocusedAttachmentView.$$delegatedProperties[0])).booleanValue();
                                if (booleanValue2) {
                                    NBPPersonMarkerFocusedAttachmentView nBPPersonMarkerFocusedAttachmentView4 = NBPPersonMarkerFocusedAttachmentView.this;
                                    nBPPersonMarkerFocusedAttachmentView4.visible$delegate.setValue(nBPPersonMarkerFocusedAttachmentView4, NBPPersonMarkerFocusedAttachmentView.$$delegatedProperties[0], Boolean.FALSE);
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        String str = nBPPersonMarkerFocusedAttachmentView3.hideTimeoutHandle;
                        if (str != null) {
                            TimerKt.b(str);
                        }
                        Function0<Unit> function03 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$animateHide$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                function02.invoke();
                                return Unit.INSTANCE;
                            }
                        };
                        KProperty<Object>[] kPropertyArr2 = IPagerIdKtxKt.$$delegatedProperties;
                        nBPPersonMarkerFocusedAttachmentView3.hideTimeoutHandle = TimerKt.e(nBPPersonMarkerFocusedAttachmentView3.getPagerId(), 200, function03);
                        aa<v> aaVar = nBPPersonMarkerFocusedAttachmentView3.sayHiRef;
                        if (aaVar != null && (b19 = aaVar.b()) != null) {
                            q.a.a(b19, b.Companion.j(com.tencent.kuikly.core.base.b.INSTANCE, 0.2f, null, 2, null), null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$animateHide$3$1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Attr attr) {
                                    Attr attr2 = attr;
                                    attr2.m147opacity(0.0f);
                                    d.a.a(attr2, null, NBPPersonMarkerFocusedAttachmentViewKt.minScale, null, new a(0.5f, 0.0f), null, 21, null);
                                    return Unit.INSTANCE;
                                }
                            }, 2, null);
                        }
                        aa<v> aaVar2 = nBPPersonMarkerFocusedAttachmentView3.leftTagRef;
                        if (aaVar2 != null && (b18 = aaVar2.b()) != null) {
                            q.a.a(b18, b.Companion.j(com.tencent.kuikly.core.base.b.INSTANCE, 0.2f, null, 2, null), null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$animateHide$4$1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Attr attr) {
                                    Attr attr2 = attr;
                                    attr2.m147opacity(0.0f);
                                    d.a.a(attr2, new com.tencent.kuikly.core.base.t(20.0f, 0.0f, 0.0f, 6, null), NBPPersonMarkerFocusedAttachmentViewKt.minScale, null, new a(1.0f, 0.5f), null, 20, null);
                                    return Unit.INSTANCE;
                                }
                            }, 2, null);
                        }
                        aa<v> aaVar3 = nBPPersonMarkerFocusedAttachmentView3.rightTagRef;
                        if (aaVar3 != null && (b17 = aaVar3.b()) != null) {
                            q.a.a(b17, b.Companion.j(com.tencent.kuikly.core.base.b.INSTANCE, 0.2f, null, 2, null), null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$animateHide$5$1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Attr attr) {
                                    Attr attr2 = attr;
                                    attr2.m147opacity(0.0f);
                                    d.a.a(attr2, new com.tencent.kuikly.core.base.t(-20.0f, 0.0f, 0.0f, 6, null), NBPPersonMarkerFocusedAttachmentViewKt.minScale, null, new a(0.0f, 0.25f), null, 20, null);
                                    return Unit.INSTANCE;
                                }
                            }, 2, null);
                        }
                        aa<v> aaVar4 = nBPPersonMarkerFocusedAttachmentView3.onlineRef;
                        if (aaVar4 != null && (b16 = aaVar4.b()) != null) {
                            q.a.a(b16, b.Companion.j(com.tencent.kuikly.core.base.b.INSTANCE, 0.2f, null, 2, null), null, new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.person.NBPPersonMarkerFocusedAttachmentView$animateHide$6$1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(Attr attr) {
                                    Attr attr2 = attr;
                                    attr2.m147opacity(0.0f);
                                    d.a.a(attr2, new com.tencent.kuikly.core.base.t(20.0f, 0.0f, 0.0f, 6, null), NBPPersonMarkerFocusedAttachmentViewKt.minScale, null, new a(0.0f, 0.75f), null, 20, null);
                                    return Unit.INSTANCE;
                                }
                            }, 2, null);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }
}
