package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card;

import c01.c;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProAvatarAttr;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProAvatarEvent;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NearbyProAvatarView;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.NearbyFeedDetailPage;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.LongPressParams;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.ttpic.openapi.filter.LightConstants;
import d45.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import q25.f;

/* loaded from: classes31.dex */
public final class NearbyFDPContentFeedAvatarView extends ComposeView<NearbyFDPContentFeedAvatarViewAttr, NearbyFDPContentFeedAvatarViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPContentFeedAvatarView.class, "avatarDidAppear", "getAvatarDidAppear()Z", 0)};
    public final ReadWriteProperty avatarDidAppear$delegate = c.a(Boolean.FALSE);
    public aa<NearbyProAvatarView> avatarViewRef;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NearbyFDPContentFeedAvatarViewAttr access$getAttr(NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView) {
        return (NearbyFDPContentFeedAvatarViewAttr) nearbyFDPContentFeedAvatarView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean access$shouldPlayAvatar(NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView) {
        NearbyFDPContentFeedAvatarViewAttr nearbyFDPContentFeedAvatarViewAttr = (NearbyFDPContentFeedAvatarViewAttr) nearbyFDPContentFeedAvatarView.getAttr();
        return ((Boolean) nearbyFDPContentFeedAvatarViewAttr.playAvatarEnable$delegate.getValue(nearbyFDPContentFeedAvatarViewAttr, NearbyFDPContentFeedAvatarViewAttr.$$delegatedProperties[4])).booleanValue() && ((Boolean) nearbyFDPContentFeedAvatarView.avatarDidAppear$delegate.getValue(nearbyFDPContentFeedAvatarView, $$delegatedProperties[0])).booleanValue() && !nearbyFDPContentFeedAvatarView.isScrolling();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView = NearbyFDPContentFeedAvatarView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        Event event2 = event;
                        final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView2 = NearbyFDPContentFeedAvatarView.this;
                        VisibilityEventKt.e(event2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView3 = NearbyFDPContentFeedAvatarView.this;
                                nearbyFDPContentFeedAvatarView3.avatarDidAppear$delegate.setValue(nearbyFDPContentFeedAvatarView3, NearbyFDPContentFeedAvatarView.$$delegatedProperties[0], Boolean.TRUE);
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView3 = NearbyFDPContentFeedAvatarView.this;
                        VisibilityEventKt.c(event2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(Object obj) {
                                NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView4 = NearbyFDPContentFeedAvatarView.this;
                                nearbyFDPContentFeedAvatarView4.avatarDidAppear$delegate.setValue(nearbyFDPContentFeedAvatarView4, NearbyFDPContentFeedAvatarView.$$delegatedProperties[0], Boolean.FALSE);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView2 = NearbyFDPContentFeedAvatarView.this;
                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView$body$1.2
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        NearbyFDPContentFeedAvatarViewAttr access$getAttr = NearbyFDPContentFeedAvatarView.access$getAttr(NearbyFDPContentFeedAvatarView.this);
                        return Boolean.valueOf(((Boolean) access$getAttr.loadAvatarView$delegate.getValue(access$getAttr, NearbyFDPContentFeedAvatarViewAttr.$$delegatedProperties[3])).booleanValue());
                    }
                };
                final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView3 = NearbyFDPContentFeedAvatarView.this;
                ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        ConditionView conditionView2 = conditionView;
                        final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView4 = NearbyFDPContentFeedAvatarView.this;
                        conditionView2.addChild(new NearbyProAvatarView(), new Function1<NearbyProAvatarView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(NearbyProAvatarView nearbyProAvatarView) {
                                NearbyProAvatarView nearbyProAvatarView2 = nearbyProAvatarView;
                                final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView5 = NearbyFDPContentFeedAvatarView.this;
                                nearbyProAvatarView2.ref(nearbyProAvatarView2, new Function1<aa<NearbyProAvatarView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.3.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(aa<NearbyProAvatarView> aaVar) {
                                        NearbyFDPContentFeedAvatarView.this.avatarViewRef = aaVar;
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView6 = NearbyFDPContentFeedAvatarView.this;
                                nearbyProAvatarView2.attr(new Function1<NearbyProAvatarAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.3.1.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NearbyProAvatarAttr nearbyProAvatarAttr) {
                                        aa<NearbyProAvatarView> aaVar;
                                        NearbyProAvatarView b16;
                                        String decodeToString;
                                        NearbyProAvatarAttr nearbyProAvatarAttr2 = nearbyProAvatarAttr;
                                        NearbyFDPContentFeedAvatarViewAttr access$getAttr = NearbyFDPContentFeedAvatarView.access$getAttr(NearbyFDPContentFeedAvatarView.this);
                                        ReadWriteProperty readWriteProperty = access$getAttr.filamentResource$delegate;
                                        KProperty<?>[] kPropertyArr = NearbyFDPContentFeedAvatarViewAttr.$$delegatedProperties;
                                        f fVar = (f) readWriteProperty.getValue(access$getAttr, kPropertyArr[2]);
                                        if (fVar != null) {
                                            NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView7 = NearbyFDPContentFeedAvatarView.this;
                                            NearbyFDPContentFeedAvatarViewAttr access$getAttr2 = NearbyFDPContentFeedAvatarView.access$getAttr(nearbyFDPContentFeedAvatarView7);
                                            long longValue = ((Number) access$getAttr2.tinyId$delegate.getValue(access$getAttr2, kPropertyArr[0])).longValue();
                                            NearbyFDPContentFeedAvatarViewAttr access$getAttr3 = NearbyFDPContentFeedAvatarView.access$getAttr(nearbyFDPContentFeedAvatarView7);
                                            boolean booleanValue = ((Boolean) access$getAttr3.male$delegate.getValue(access$getAttr3, kPropertyArr[1])).booleanValue();
                                            long j3 = UserDataManager.INSTANCE.getUserSelfInfo().tid;
                                            e eVar = new e();
                                            eVar.u("tid", longValue);
                                            eVar.w(LightConstants.MALE, booleanValue);
                                            eVar.u("selfTid", j3);
                                            decodeToString = StringsKt__StringsJVMKt.decodeToString(a.b(i.d(fVar)));
                                            eVar.v("resourceInfo", decodeToString);
                                            eVar.w("autoPlay", false);
                                            Unit unit = Unit.INSTANCE;
                                            nearbyProAvatarAttr2.with("avatarData", eVar.toString());
                                        }
                                        NearbyFDPContentFeedAvatarViewAttr access$getAttr4 = NearbyFDPContentFeedAvatarView.access$getAttr(NearbyFDPContentFeedAvatarView.this);
                                        if (((Boolean) access$getAttr4.playAvatarEnable$delegate.getValue(access$getAttr4, kPropertyArr[4])).booleanValue() && (aaVar = NearbyFDPContentFeedAvatarView.this.avatarViewRef) != null && (b16 = aaVar.b()) != null) {
                                            b16.onPlay();
                                        }
                                        nearbyProAvatarAttr2.m151touchEnable(false);
                                        nearbyProAvatarAttr2.absolutePositionAllZero();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView7 = NearbyFDPContentFeedAvatarView.this;
                                nearbyProAvatarView2.event(new Function1<NearbyProAvatarEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.3.1.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(NearbyProAvatarEvent nearbyProAvatarEvent) {
                                        NearbyProAvatarEvent nearbyProAvatarEvent2 = nearbyProAvatarEvent;
                                        final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView8 = NearbyFDPContentFeedAvatarView.this;
                                        nearbyProAvatarEvent2.register("loadSuccess", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.3.1.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                aa<NearbyProAvatarView> aaVar;
                                                NearbyProAvatarView b16;
                                                NearbyProAvatarView b17;
                                                aa<NearbyProAvatarView> aaVar2 = NearbyFDPContentFeedAvatarView.this.avatarViewRef;
                                                if (aaVar2 != null && (b17 = aaVar2.b()) != null) {
                                                    b17.getExtProps().put("didLoad", Boolean.TRUE);
                                                }
                                                if (!NearbyFDPContentFeedAvatarView.access$shouldPlayAvatar(NearbyFDPContentFeedAvatarView.this) && (aaVar = NearbyFDPContentFeedAvatarView.this.avatarViewRef) != null && (b16 = aaVar.b()) != null) {
                                                    AbstractBaseView.callRenderViewMethod$default(b16, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, null, null, 6, null);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView9 = NearbyFDPContentFeedAvatarView.this;
                                        nearbyProAvatarEvent2.register("loadFailure", new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.3.1.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Object obj) {
                                                NearbyProAvatarView b16;
                                                aa<NearbyProAvatarView> aaVar = NearbyFDPContentFeedAvatarView.this.avatarViewRef;
                                                if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                    b16.getExtProps().put("didLoad", Boolean.TRUE);
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
                        final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView5 = NearbyFDPContentFeedAvatarView.this;
                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.3.2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(NearbyFDPContentFeedAvatarView.access$shouldPlayAvatar(NearbyFDPContentFeedAvatarView.this));
                            }
                        };
                        final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView6 = NearbyFDPContentFeedAvatarView.this;
                        BindDirectivesViewKt.a(conditionView2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                NearbyProAvatarView b16;
                                aa<NearbyProAvatarView> aaVar;
                                NearbyProAvatarView b17;
                                NearbyProAvatarView b18;
                                if (NearbyFDPContentFeedAvatarView.access$shouldPlayAvatar(NearbyFDPContentFeedAvatarView.this)) {
                                    aa<NearbyProAvatarView> aaVar2 = NearbyFDPContentFeedAvatarView.this.avatarViewRef;
                                    if (aaVar2 != null && (b18 = aaVar2.b()) != null) {
                                        b18.onPlay();
                                    }
                                } else {
                                    aa<NearbyProAvatarView> aaVar3 = NearbyFDPContentFeedAvatarView.this.avatarViewRef;
                                    if (aaVar3 != null && (b16 = aaVar3.b()) != null) {
                                        NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView7 = NearbyFDPContentFeedAvatarView.this;
                                        if (Intrinsics.areEqual(b16.getExtProps().get("didLoad"), Boolean.TRUE) && (aaVar = nearbyFDPContentFeedAvatarView7.avatarViewRef) != null && (b17 = aaVar.b()) != null) {
                                            AbstractBaseView.callRenderViewMethod$default(b17, MiniSDKConst.NOTIFY_EVENT_ONPAUSE, null, null, 6, null);
                                        }
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView7 = NearbyFDPContentFeedAvatarView.this;
                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.3.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.3.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        tVar.absolutePositionAllZero();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView8 = NearbyFDPContentFeedAvatarView.this;
                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.3.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        u uVar2 = uVar;
                                        final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView9 = NearbyFDPContentFeedAvatarView.this;
                                        uVar2.doubleClick(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.3.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NearbyProAvatarView b16;
                                                aa<NearbyProAvatarView> aaVar = NearbyFDPContentFeedAvatarView.this.avatarViewRef;
                                                if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                    AbstractBaseView.callRenderViewMethod$default(b16, "interact", null, null, 6, null);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView10 = NearbyFDPContentFeedAvatarView.this;
                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.3.4.2.2
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Multi-variable type inference failed */
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                ClickParams clickParams2 = clickParams;
                                                Function1<Object, Unit> function1 = ((NearbyFDPContentFeedAvatarViewEvent) NearbyFDPContentFeedAvatarView.this.getViewEvent()).clickHandler;
                                                if (function1 != null) {
                                                    function1.invoke(clickParams2);
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyFDPContentFeedAvatarView nearbyFDPContentFeedAvatarView11 = NearbyFDPContentFeedAvatarView.this;
                                        uVar2.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyFDPContentFeedAvatarView.body.1.3.4.2.3
                                            {
                                                super(1);
                                            }

                                            /* JADX WARN: Multi-variable type inference failed */
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(LongPressParams longPressParams) {
                                                LongPressParams longPressParams2 = longPressParams;
                                                Function1<Object, Unit> function1 = ((NearbyFDPContentFeedAvatarViewEvent) NearbyFDPContentFeedAvatarView.this.getViewEvent()).longClickHandler;
                                                if (function1 != null) {
                                                    function1.invoke(longPressParams2);
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
        return new NearbyFDPContentFeedAvatarViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyFDPContentFeedAvatarViewEvent();
    }

    public final boolean isScrolling() {
        b pager = getPager();
        NearbyFeedDetailPage nearbyFeedDetailPage = pager instanceof NearbyFeedDetailPage ? (NearbyFeedDetailPage) pager : null;
        return nearbyFeedDetailPage != null && ((Boolean) nearbyFeedDetailPage.isScrolling$delegate.getValue(nearbyFeedDetailPage, NearbyFeedDetailPage.$$delegatedProperties[3])).booleanValue();
    }
}
