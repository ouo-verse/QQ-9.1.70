package com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark;

import a35.e;
import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.base.MarkerViewExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.vas.avatar.NtFaceConstant;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes31.dex */
public final class NBPLandMarkerView extends ComposeView<NBPLandMarkerAttr, l> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPLandMarkerView.class, "summaryTextAnimationTick", "getSummaryTextAnimationTick()I", 0)};
    public final ReadWriteProperty summaryTextAnimationTick$delegate = c.a(0);
    public String summaryTextTimeoutRef = "";
    public float summaryTextTranslateX;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NBPLandMarkerAttr access$getAttr(NBPLandMarkerView nBPLandMarkerView) {
        return (NBPLandMarkerAttr) nBPLandMarkerView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPLandMarkerViewModel vm5 = ((NBPLandMarkerAttr) getAttr()).getVm();
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPLandMarkerViewModel nBPLandMarkerViewModel = NBPLandMarkerViewModel.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.flexDirectionColumn();
                        MarkerViewExtKt.bindMarkerStatusChange(mVar2, NBPLandMarkerViewModel.this, 0.0f);
                        return Unit.INSTANCE;
                    }
                });
                final NBPLandMarkerViewModel nBPLandMarkerViewModel2 = NBPLandMarkerViewModel.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final NBPLandMarkerViewModel nBPLandMarkerViewModel3 = NBPLandMarkerViewModel.this;
                        MarkerViewExtKt.bindMarkerPopShow(event, nBPLandMarkerViewModel3.anchor, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.2.1
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Unit invoke() {
                                NBPLandMarkerViewModel.this.readyToFocus = true;
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPLandMarkerViewModel nBPLandMarkerViewModel3 = NBPLandMarkerViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPLandMarkerViewModel nBPLandMarkerViewModel4 = NBPLandMarkerViewModel.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.size(NBPLandMarkerViewModel.this.getMsgBubbleSize().getWidth(), NBPLandMarkerViewModel.this.getMsgBubbleSize().getHeight());
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPLandMarkerViewModel nBPLandMarkerViewModel5 = NBPLandMarkerViewModel.this;
                        Function0<com.tencent.kuikly.core.reactive.collection.c<NBPMsgBubbleInfo>> function0 = new Function0<com.tencent.kuikly.core.reactive.collection.c<NBPMsgBubbleInfo>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.3.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final com.tencent.kuikly.core.reactive.collection.c<NBPMsgBubbleInfo> invoke() {
                                return NBPLandMarkerViewModel.this.getAreaMsgList();
                            }
                        };
                        final NBPLandMarkerViewModel nBPLandMarkerViewModel6 = NBPLandMarkerViewModel.this;
                        LoopDirectivesViewKt.a(vVar2, function0, new Function2<LoopDirectivesView<NBPMsgBubbleInfo>, NBPMsgBubbleInfo, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.3.3
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<NBPMsgBubbleInfo> loopDirectivesView, NBPMsgBubbleInfo nBPMsgBubbleInfo) {
                                final NBPMsgBubbleInfo nBPMsgBubbleInfo2 = nBPMsgBubbleInfo;
                                final NBPLandMarkerViewModel nBPLandMarkerViewModel7 = NBPLandMarkerViewModel.this;
                                w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.3.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        final NBPLandMarkerViewModel nBPLandMarkerViewModel8 = NBPLandMarkerViewModel.this;
                                        final NBPMsgBubbleInfo nBPMsgBubbleInfo3 = nBPMsgBubbleInfo2;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.3.3.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                b l3 = b.Companion.l(b.INSTANCE, 0.5f, null, 2, null);
                                                NBPLandMarkerViewModel nBPLandMarkerViewModel9 = NBPLandMarkerViewModel.this;
                                                tVar2.animate(l3, Integer.valueOf(((Number) nBPLandMarkerViewModel9.msgBubbleAnimationTick$delegate.getValue(nBPLandMarkerViewModel9, NBPLandMarkerViewModel.$$delegatedProperties[5])).intValue()));
                                                tVar2.m147opacity(nBPMsgBubbleInfo3.alpha);
                                                d.a.a(tVar2, null, new u(nBPMsgBubbleInfo3.scale, 0.0f, 2, null), new y(0.0f, nBPMsgBubbleInfo3.translateY, 0.0f, 0.0f, 12, null), null, null, 25, null);
                                                tVar2.mo113backgroundColor(h.INSTANCE.m());
                                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 11, null);
                                                tVar2.borderRadius(6.0f);
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPMsgBubbleInfo nBPMsgBubbleInfo4 = nBPMsgBubbleInfo2;
                                        final NBPLandMarkerViewModel nBPLandMarkerViewModel9 = NBPLandMarkerViewModel.this;
                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.3.3.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                final NBPMsgBubbleInfo nBPMsgBubbleInfo5 = NBPMsgBubbleInfo.this;
                                                final NBPLandMarkerViewModel nBPLandMarkerViewModel10 = nBPLandMarkerViewModel9;
                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.3.3.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.text(NBPMsgBubbleInfo.this.text);
                                                        ce.fontSize$default(ceVar2, 11.0f, null, 2, null);
                                                        ceVar2.mo153width(nBPLandMarkerViewModel10.getMsgBubbleSize().getWidth());
                                                        ceVar2.lines(1);
                                                        ceVar2.textOverFlowTail();
                                                        ceVar2.marginLeft(6.0f);
                                                        ceVar2.marginRight(6.0f);
                                                        ceVar2.marginTop(6.0f);
                                                        ceVar2.marginBottom(6.0f);
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
                final NBPLandMarkerViewModel nBPLandMarkerViewModel4 = NBPLandMarkerViewModel.this;
                final NBPLandMarkerView nBPLandMarkerView = this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView$body$1.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final NBPLandMarkerViewModel nBPLandMarkerViewModel5 = NBPLandMarkerViewModel.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                final NBPLandMarkerViewModel nBPLandMarkerViewModel6 = NBPLandMarkerViewModel.this;
                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        Object firstOrNull;
                                        String str;
                                        af afVar2 = afVar;
                                        afVar2.size(NBPLandMarkerViewModel.this.getBgSize().getWidth(), NBPLandMarkerViewModel.this.getBgSize().getHeight());
                                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) NBPLandMarkerViewModel.this.area.f421832f);
                                        o25.c cVar = (o25.c) firstOrNull;
                                        if (cVar == null || (str = cVar.f421838d) == null) {
                                            str = "";
                                        }
                                        b.a.b(afVar2, str, false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPLandMarkerViewModel nBPLandMarkerViewModel6 = NBPLandMarkerViewModel.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.absolutePositionAllZero();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPLandMarkerViewModel nBPLandMarkerViewModel7 = NBPLandMarkerViewModel.this;
                                LoopDirectivesViewKt.a(vVar4, new Function0<com.tencent.kuikly.core.reactive.collection.c<NBPLandMarkOnlineUsers>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.2.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final com.tencent.kuikly.core.reactive.collection.c<NBPLandMarkOnlineUsers> invoke() {
                                        return NBPLandMarkerViewModel.this.getOnlineUserList();
                                    }
                                }, new Function2<LoopDirectivesView<NBPLandMarkOnlineUsers>, NBPLandMarkOnlineUsers, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.2.3
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(LoopDirectivesView<NBPLandMarkOnlineUsers> loopDirectivesView, NBPLandMarkOnlineUsers nBPLandMarkOnlineUsers) {
                                        final NBPLandMarkOnlineUsers nBPLandMarkOnlineUsers2 = nBPLandMarkOnlineUsers;
                                        w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                final NBPLandMarkOnlineUsers nBPLandMarkOnlineUsers3 = NBPLandMarkOnlineUsers.this;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.2.3.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.size(28.0f, 28.0f);
                                                        Attr.absolutePosition$default(tVar2, NBPLandMarkOnlineUsers.this.position.getSecond().floatValue(), NBPLandMarkOnlineUsers.this.position.getFirst().floatValue(), 0.0f, 0.0f, 12, null);
                                                        tVar2.mo113backgroundColor(h.INSTANCE.m());
                                                        tVar2.borderRadius(14.0f);
                                                        tVar2.allCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPLandMarkOnlineUsers nBPLandMarkOnlineUsers4 = NBPLandMarkOnlineUsers.this;
                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.2.3.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        final NBPLandMarkOnlineUsers nBPLandMarkOnlineUsers5 = NBPLandMarkOnlineUsers.this;
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.2.3.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                String str;
                                                                af afVar2 = afVar;
                                                                afVar2.size(26.0f, 26.0f);
                                                                afVar2.borderRadius(13.0f);
                                                                e eVar = NBPLandMarkOnlineUsers.this.userInfo.f25449d;
                                                                if (eVar == null || (str = eVar.f25452e) == null) {
                                                                    str = "";
                                                                }
                                                                b.a.b(afVar2, str, false, 2, null);
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
                        final NBPLandMarkerViewModel nBPLandMarkerViewModel7 = NBPLandMarkerViewModel.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPLandMarkerViewModel nBPLandMarkerViewModel8 = NBPLandMarkerViewModel.this;
                                return (String) nBPLandMarkerViewModel8.adUrl$delegate.getValue(nBPLandMarkerViewModel8, NBPLandMarkerViewModel.$$delegatedProperties[3]);
                            }
                        };
                        final NBPLandMarkerViewModel nBPLandMarkerViewModel8 = NBPLandMarkerViewModel.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NBPLandMarkerViewModel nBPLandMarkerViewModel9 = NBPLandMarkerViewModel.this;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.4.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.absolutePositionAllZero();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final Pair<Float, Float> calAdPosition = NBPLandMarkerViewModel.this.calAdPosition();
                                        final NBPLandMarkerViewModel nBPLandMarkerViewModel10 = NBPLandMarkerViewModel.this;
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.4.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final NBPLandMarkerViewModel nBPLandMarkerViewModel11 = NBPLandMarkerViewModel.this;
                                                final Pair<Float, Float> pair = calAdPosition;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.4.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.size(NBPLandMarkerViewModel.this.getAdSize().getWidth(), NBPLandMarkerViewModel.this.getAdSize().getHeight());
                                                        NBPLandMarkerViewModel nBPLandMarkerViewModel12 = NBPLandMarkerViewModel.this;
                                                        b.a.b(afVar2, (String) nBPLandMarkerViewModel12.adUrl$delegate.getValue(nBPLandMarkerViewModel12, NBPLandMarkerViewModel.$$delegatedProperties[3]), false, 2, null);
                                                        Attr.absolutePosition$default(afVar2, pair.getSecond().floatValue(), pair.getFirst().floatValue(), 0.0f, 0.0f, 12, null);
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
                        final NBPLandMarkerViewModel nBPLandMarkerViewModel9 = NBPLandMarkerViewModel.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.5
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPLandMarkerViewModel nBPLandMarkerViewModel10 = NBPLandMarkerViewModel.this;
                                return Boolean.valueOf(((String) nBPLandMarkerViewModel10.areaName$delegate.getValue(nBPLandMarkerViewModel10, NBPLandMarkerViewModel.$$delegatedProperties[1])).length() > 0);
                            }
                        };
                        final NBPLandMarkerViewModel nBPLandMarkerViewModel10 = NBPLandMarkerViewModel.this;
                        final NBPLandMarkerView nBPLandMarkerView2 = nBPLandMarkerView;
                        ConditionViewKt.c(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final NBPLandMarkerViewModel nBPLandMarkerViewModel11 = NBPLandMarkerViewModel.this;
                                final NBPLandMarkerView nBPLandMarkerView3 = nBPLandMarkerView2;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.6.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.6.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, -10.0f, 0.0f, 1, null);
                                                tVar2.allCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPLandMarkerViewModel nBPLandMarkerViewModel12 = NBPLandMarkerViewModel.this;
                                        final NBPLandMarkerView nBPLandMarkerView4 = nBPLandMarkerView3;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.6.1.2
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                List<String> list;
                                                boolean startsWith$default;
                                                String replace$default;
                                                v vVar6 = vVar5;
                                                NBPLandMarkerViewModel nBPLandMarkerViewModel13 = NBPLandMarkerViewModel.this;
                                                nBPLandMarkerViewModel13.getClass();
                                                final ArrayList arrayList = new ArrayList(3);
                                                arrayList.add(new h(4288412671L));
                                                arrayList.add(new h(4284924927L));
                                                arrayList.add(new h(4284062207L));
                                                try {
                                                    o25.d dVar = nBPLandMarkerViewModel13.area.f421834i;
                                                    if (dVar != null && (list = dVar.f421842e) != null) {
                                                        int i3 = 0;
                                                        for (Object obj : list) {
                                                            int i16 = i3 + 1;
                                                            if (i3 < 0) {
                                                                CollectionsKt__CollectionsKt.throwIndexOverflow();
                                                            }
                                                            String str = (String) obj;
                                                            KLog.INSTANCE.i("NBPLandMarkerViewModel", "areaColor: " + i3 + ", " + str);
                                                            if (i3 <= 2) {
                                                                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, RelationNTPushServiceImpl.PRE_HEX_STRING, false, 2, null);
                                                                if (startsWith$default) {
                                                                    arrayList.set(i3, new h(h.INSTANCE.o(str)));
                                                                } else {
                                                                    h.Companion companion = h.INSTANCE;
                                                                    replace$default = StringsKt__StringsJVMKt.replace$default(str, "#", RelationNTPushServiceImpl.PRE_HEX_STRING, false, 4, (Object) null);
                                                                    arrayList.set(i3, new h(companion.o(replace$default)));
                                                                }
                                                            }
                                                            i3 = i16;
                                                        }
                                                    }
                                                } catch (Exception e16) {
                                                    KLog.INSTANCE.e("NBPLandMarkerViewModel", "getBrandColors error=" + e16);
                                                }
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.6.1.2.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        Object first;
                                                        t tVar2 = tVar;
                                                        tVar2.borderRadius(5.0f);
                                                        tVar2.m136border(new com.tencent.kuikly.core.base.e(1.5f, BorderStyle.SOLID, h.INSTANCE.m()));
                                                        Direction direction = Direction.TO_TOP_RIGHT;
                                                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) arrayList);
                                                        tVar2.mo135backgroundLinearGradient(direction, new j((h) first, 0.0f), new j(arrayList.get(1), 0.54f), new j(arrayList.get(2), 1.0f));
                                                        tVar2.flexDirectionRow();
                                                        tVar2.alignItemsCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPLandMarkerViewModel nBPLandMarkerViewModel14 = NBPLandMarkerViewModel.this;
                                                final NBPLandMarkerView nBPLandMarkerView5 = nBPLandMarkerView4;
                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.6.1.2.2
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        v vVar8 = vVar7;
                                                        final NBPLandMarkerViewModel nBPLandMarkerViewModel15 = NBPLandMarkerViewModel.this;
                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.6.1.2.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.overflow(true);
                                                                tVar2.m144maxWidth(NBPLandMarkerViewModel.this.getSummaryTextMaxWidth());
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPLandMarkerViewModel nBPLandMarkerViewModel16 = NBPLandMarkerViewModel.this;
                                                        final NBPLandMarkerView nBPLandMarkerView6 = nBPLandMarkerView5;
                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.6.1.2.2.2
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                TextView textView2 = textView;
                                                                final NBPLandMarkerViewModel nBPLandMarkerViewModel17 = NBPLandMarkerViewModel.this;
                                                                final NBPLandMarkerView nBPLandMarkerView7 = nBPLandMarkerView6;
                                                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.6.1.2.2.2.1
                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.marginTop(4.0f);
                                                                        ceVar2.marginBottom(4.0f);
                                                                        ceVar2.marginLeft(8.0f);
                                                                        ceVar2.marginRight(8.0f);
                                                                        ceVar2.fontWeight500();
                                                                        ceVar2.color(h.INSTANCE.m());
                                                                        ce.fontSize$default(ceVar2, 13.0f, null, 2, null);
                                                                        NBPLandMarkerViewModel nBPLandMarkerViewModel18 = NBPLandMarkerViewModel.this;
                                                                        ceVar2.text((String) nBPLandMarkerViewModel18.areaName$delegate.getValue(nBPLandMarkerViewModel18, NBPLandMarkerViewModel.$$delegatedProperties[1]));
                                                                        ceVar2.lines(1);
                                                                        ceVar2.animate(b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 3.0f, null, 2, null), Integer.valueOf(nBPLandMarkerView7.getSummaryTextAnimationTick()));
                                                                        ceVar2.transform(new y(nBPLandMarkerView7.summaryTextTranslateX, 0.0f, 0.0f, 0.0f, 12, null));
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPLandMarkerView nBPLandMarkerView8 = nBPLandMarkerView6;
                                                                textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.6.1.2.2.2.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextEvent textEvent) {
                                                                        final NBPLandMarkerView nBPLandMarkerView9 = NBPLandMarkerView.this;
                                                                        FrameEventKt.d(textEvent, new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.map.marker.markers.landmark.NBPLandMarkerView.body.1.4.6.1.2.2.2.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(com.tencent.kuikly.core.layout.d dVar2) {
                                                                                NBPLandMarkerView.this.scheduleSummaryTextMarqueeIfNeed(dVar2);
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
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NBPLandMarkerAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        NBPLandMarkerViewModel vm5 = ((NBPLandMarkerAttr) getAttr()).getVm();
        if (vm5.currentScheduleIndex != 0) {
            vm5.msgBubbleAnimating = true;
            vm5.scheduleMsgBubbleAnimate(0);
        }
        vm5.requestAreaInfo(vm5.area.f421830d, 0L);
        com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
        eVar.v("nearby_square_type", NtFaceConstant.SMALL);
        eVar.v("dt_pgid", "pg_nearby_home_map");
        eVar.v("dt_eid", "em_nearby_square_icon");
        eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView, com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        NBPLandMarkerViewModel vm5 = ((NBPLandMarkerAttr) getAttr()).getVm();
        if (vm5.areaMsgRequestTimeoutRef.length() > 0) {
            TimerKt.b(vm5.areaMsgRequestTimeoutRef);
            vm5.areaMsgRequestTimeoutRef = "";
        }
        if (vm5.areaRequestTimeoutRef.length() > 0) {
            TimerKt.b(vm5.areaRequestTimeoutRef);
            vm5.areaRequestTimeoutRef = "";
        }
        if (vm5.msgBubbleAnimateTimeoutRef.length() > 0) {
            TimerKt.b(vm5.msgBubbleAnimateTimeoutRef);
            vm5.msgBubbleAnimateTimeoutRef = "";
        }
        vm5.msgBubbleAnimating = false;
        if (this.summaryTextTimeoutRef.length() > 0) {
            TimerKt.b(this.summaryTextTimeoutRef);
            this.summaryTextTimeoutRef = "";
        }
    }

    public final int getSummaryTextAnimationTick() {
        return ((Number) this.summaryTextAnimationTick$delegate.getValue(this, $$delegatedProperties[0])).intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void scheduleSummaryTextMarqueeIfNeed(com.tencent.kuikly.core.layout.d dVar) {
        if (getSummaryTextAnimationTick() == 0 && dVar.getWidth() > ((NBPLandMarkerAttr) getAttr()).getVm().getSummaryTextMaxWidth()) {
            KLog.INSTANCE.i("NBPLandMarkerView", "start summary text marquee");
            setSummaryTextAnimationTick(getSummaryTextAnimationTick() + 1);
            NBPLandMarkerView$scheduleSummaryTextMarquee$1 nBPLandMarkerView$scheduleSummaryTextMarquee$1 = new NBPLandMarkerView$scheduleSummaryTextMarquee$1(this, dVar);
            KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
            this.summaryTextTimeoutRef = TimerKt.e(getPagerId(), 1000, nBPLandMarkerView$scheduleSummaryTextMarquee$1);
        }
    }

    public final void setSummaryTextAnimationTick(int i3) {
        this.summaryTextAnimationTick$delegate.setValue(this, $$delegatedProperties[0], Integer.valueOf(i3));
    }
}
