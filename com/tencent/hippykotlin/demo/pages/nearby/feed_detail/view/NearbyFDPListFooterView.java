package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.NearbyFDPageViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.kuikly.core.views.FooterRefreshEndState;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.FooterRefreshView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.f;
import com.tencent.kuikly.core.views.h;
import com.tencent.kuikly.core.views.i;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.kuikly.core.views.y;
import com.tencent.kuikly.core.views.z;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes31.dex */
public final class NearbyFDPListFooterView extends ComposeView<NearbyFDPListFooterAttr, NearbyFDPListFooterEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPListFooterView.class, "refreshText", "getRefreshText()Ljava/lang/String;", 0)};
    public aa<FooterRefreshView> refreshViewRef;
    public String loadingText = "\u63a8\u8350\u4e2d";
    public String errorText = "\u7f51\u7edc\u5f02\u5e38\uff0c\u70b9\u51fb\u91cd\u8bd5";
    public String noneMoreText = "\u9644\u8fd1\u6ca1\u6709\u65b0\u52a8\u6001\u5566";
    public final ReadWriteProperty refreshText$delegate = c.a("\u63a8\u8350\u4e2d");

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NearbyFDPListFooterAttr access$getAttr(NearbyFDPListFooterView nearbyFDPListFooterView) {
        return (NearbyFDPListFooterAttr) nearbyFDPListFooterView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$tryLoadMore(final NearbyFDPListFooterView nearbyFDPListFooterView) {
        NearbyFDPageViewModel nearbyFDPageViewModel = ((NearbyFDPListFooterAttr) nearbyFDPListFooterView.getAttr()).viewModel;
        if (nearbyFDPageViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            nearbyFDPageViewModel = null;
        }
        nearbyFDPageViewModel.loadNextFeedsListFromLocalForDisplay(new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView$tryLoadMore$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Unit invoke(Boolean bool, Boolean bool2) {
                FooterRefreshView b16;
                boolean booleanValue = bool.booleanValue();
                boolean booleanValue2 = bool2.booleanValue();
                KLog.INSTANCE.i("NBPFeedDetail", "loadNextFeeds " + booleanValue + TokenParser.SP + booleanValue2);
                if (!booleanValue) {
                    final NearbyFDPListFooterView nearbyFDPListFooterView2 = NearbyFDPListFooterView.this;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView$tryLoadMore$1.1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            FooterRefreshView b17;
                            aa<FooterRefreshView> aaVar = NearbyFDPListFooterView.this.refreshViewRef;
                            if (aaVar != null && (b17 = aaVar.b()) != null) {
                                b17.t(FooterRefreshEndState.FAILURE);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    KProperty<Object>[] kPropertyArr = IPagerIdKtxKt.$$delegatedProperties;
                    TimerKt.e(nearbyFDPListFooterView2.getPagerId(), 1000, function0);
                } else if (!booleanValue2) {
                    aa<FooterRefreshView> aaVar = NearbyFDPListFooterView.this.refreshViewRef;
                    if (aaVar != null && (b16 = aaVar.b()) != null) {
                        b16.t(FooterRefreshEndState.SUCCESS);
                    }
                } else {
                    NearbyFDPageViewModel nearbyFDPageViewModel2 = NearbyFDPListFooterView.access$getAttr(NearbyFDPListFooterView.this).viewModel;
                    if (nearbyFDPageViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        nearbyFDPageViewModel2 = null;
                    }
                    final NearbyFDPListFooterView nearbyFDPListFooterView3 = NearbyFDPListFooterView.this;
                    NearbyFDPageViewModel.fetchFeedsFromServerForCache$default(nearbyFDPageViewModel2, false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView$tryLoadMore$1.2
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Unit invoke(Boolean bool3, Boolean bool4) {
                            FooterRefreshView b17;
                            boolean booleanValue3 = bool3.booleanValue();
                            if (!bool4.booleanValue()) {
                                final NearbyFDPListFooterView nearbyFDPListFooterView4 = NearbyFDPListFooterView.this;
                                Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView.tryLoadMore.1.2.1
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        FooterRefreshView b18;
                                        aa<FooterRefreshView> aaVar2 = NearbyFDPListFooterView.this.refreshViewRef;
                                        if (aaVar2 != null && (b18 = aaVar2.b()) != null) {
                                            b18.t(FooterRefreshEndState.FAILURE);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                KProperty<Object>[] kPropertyArr2 = IPagerIdKtxKt.$$delegatedProperties;
                                TimerKt.e(nearbyFDPListFooterView4.getPagerId(), 500, function02);
                            } else if (!booleanValue3) {
                                aa<FooterRefreshView> aaVar2 = NearbyFDPListFooterView.this.refreshViewRef;
                                if (aaVar2 != null && (b17 = aaVar2.b()) != null) {
                                    b17.t(FooterRefreshEndState.NONE_MORE_DATA);
                                }
                            } else {
                                NearbyFDPListFooterView.access$tryLoadMore(NearbyFDPListFooterView.this);
                            }
                            return Unit.INSTANCE;
                        }
                    }, 3);
                }
                return Unit.INSTANCE;
            }
        });
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NearbyFDPListFooterView nearbyFDPListFooterView = NearbyFDPListFooterView.this;
                z.a(viewContainer, new Function1<FooterRefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(FooterRefreshView footerRefreshView) {
                        FooterRefreshView footerRefreshView2 = footerRefreshView;
                        final NearbyFDPListFooterView nearbyFDPListFooterView2 = NearbyFDPListFooterView.this;
                        footerRefreshView2.ref(footerRefreshView2, new Function1<aa<FooterRefreshView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<FooterRefreshView> aaVar) {
                                NearbyFDPListFooterView.this.refreshViewRef = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFDPListFooterView nearbyFDPListFooterView3 = NearbyFDPListFooterView.this;
                        footerRefreshView2.event(new Function1<y, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(y yVar) {
                                y yVar2 = yVar;
                                final NearbyFDPListFooterView nearbyFDPListFooterView4 = NearbyFDPListFooterView.this;
                                yVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        aa<FooterRefreshView> aaVar;
                                        FooterRefreshView b16;
                                        FooterRefreshView b17;
                                        aa<FooterRefreshView> aaVar2 = NearbyFDPListFooterView.this.refreshViewRef;
                                        if (((aaVar2 == null || (b17 = aaVar2.b()) == null) ? null : b17.getRefreshState()) == FooterRefreshState.FAILURE && (aaVar = NearbyFDPListFooterView.this.refreshViewRef) != null && (b16 = aaVar.b()) != null) {
                                            b16.p();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFDPListFooterView nearbyFDPListFooterView5 = NearbyFDPListFooterView.this;
                                yVar2.i(new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView.body.1.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(FooterRefreshState footerRefreshState) {
                                        FooterRefreshState footerRefreshState2 = footerRefreshState;
                                        KLog.INSTANCE.i("NBPFeedDetail", "refreshStateDidChange " + footerRefreshState2);
                                        if (footerRefreshState2 == FooterRefreshState.FAILURE) {
                                            NearbyFDPListFooterView nearbyFDPListFooterView6 = NearbyFDPListFooterView.this;
                                            nearbyFDPListFooterView6.refreshText$delegate.setValue(nearbyFDPListFooterView6, NearbyFDPListFooterView.$$delegatedProperties[0], nearbyFDPListFooterView6.errorText);
                                        } else if (footerRefreshState2 == FooterRefreshState.NONE_MORE_DATA) {
                                            NearbyFDPListFooterView nearbyFDPListFooterView7 = NearbyFDPListFooterView.this;
                                            nearbyFDPListFooterView7.refreshText$delegate.setValue(nearbyFDPListFooterView7, NearbyFDPListFooterView.$$delegatedProperties[0], nearbyFDPListFooterView7.noneMoreText);
                                        } else if (footerRefreshState2 == FooterRefreshState.IDLE) {
                                            NearbyFDPListFooterView nearbyFDPListFooterView8 = NearbyFDPListFooterView.this;
                                            nearbyFDPListFooterView8.refreshText$delegate.setValue(nearbyFDPListFooterView8, NearbyFDPListFooterView.$$delegatedProperties[0], nearbyFDPListFooterView8.loadingText);
                                        } else if (footerRefreshState2 == FooterRefreshState.REFRESHING) {
                                            NearbyFDPListFooterView nearbyFDPListFooterView9 = NearbyFDPListFooterView.this;
                                            nearbyFDPListFooterView9.refreshText$delegate.setValue(nearbyFDPListFooterView9, NearbyFDPListFooterView.$$delegatedProperties[0], nearbyFDPListFooterView9.loadingText);
                                            NearbyFDPListFooterView.access$tryLoadMore(NearbyFDPListFooterView.this);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFDPListFooterView nearbyFDPListFooterView4 = NearbyFDPListFooterView.this;
                        w.a(footerRefreshView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView.body.1.1.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView.body.1.1.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(35.0f);
                                        tVar2.allCenter();
                                        tVar2.flexDirectionRow();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFDPListFooterView nearbyFDPListFooterView5 = NearbyFDPListFooterView.this;
                                ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView.body.1.1.3.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        NearbyFDPListFooterView nearbyFDPListFooterView6 = NearbyFDPListFooterView.this;
                                        return Boolean.valueOf(Intrinsics.areEqual((String) nearbyFDPListFooterView6.refreshText$delegate.getValue(nearbyFDPListFooterView6, NearbyFDPListFooterView.$$delegatedProperties[0]), NearbyFDPListFooterView.this.loadingText));
                                    }
                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView.body.1.1.3.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ConditionView conditionView) {
                                        i.a(conditionView, new Function1<h, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView.body.1.1.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(h hVar) {
                                                hVar.attr(new Function1<f, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView.body.1.1.3.3.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(f fVar) {
                                                        f fVar2 = fVar;
                                                        fVar2.h(!com.tencent.kuikly.core.manager.c.f117352a.g().isNightMode());
                                                        fVar2.transform(new u(0.8f, 0.8f));
                                                        fVar2.marginRight(8.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFDPListFooterView nearbyFDPListFooterView6 = NearbyFDPListFooterView.this;
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView.body.1.1.3.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NearbyFDPListFooterView nearbyFDPListFooterView7 = NearbyFDPListFooterView.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.NearbyFDPListFooterView.body.1.1.3.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                NearbyFDPListFooterView nearbyFDPListFooterView8 = NearbyFDPListFooterView.this;
                                                ceVar2.text((String) nearbyFDPListFooterView8.refreshText$delegate.getValue(nearbyFDPListFooterView8, NearbyFDPListFooterView.$$delegatedProperties[0]));
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.color(4289111718L);
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
                aa<FooterRefreshView> aaVar = NearbyFDPListFooterView.this.refreshViewRef;
                Intrinsics.checkNotNull(aaVar);
                FooterRefreshView b16 = aaVar.b();
                Intrinsics.checkNotNull(b16);
                b16.p();
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new NearbyFDPListFooterAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyFDPListFooterEvent();
    }
}
