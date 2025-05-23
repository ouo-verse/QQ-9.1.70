package com.tencent.hippykotlin.demo.pages.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.RefreshListState;
import com.tencent.hippykotlin.demo.pages.base.extension.AttrExtKt;
import com.tencent.kuikly.core.base.AbstractBaseView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.RefreshView;
import com.tencent.kuikly.core.views.RefreshViewState;
import com.tencent.kuikly.core.views.ScrollParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.ap;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.bk;
import com.tencent.kuikly.core.views.bl;
import com.tencent.kuikly.core.views.bm;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECRefreshListView<T> extends ComposeView<ECRefreshListViewAttr<T>, ECRefreshListViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECRefreshListView.class, "headerText", "getHeaderText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECRefreshListView.class, "footerRefreshState", "getFooterRefreshState()Lcom/tencent/kuikly/core/views/FooterRefreshState;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ECRefreshListView.class, "networkState", "getNetworkState()Lcom/tencent/hippykotlin/demo/pages/base/NetworkState;", 0)};
    public Function2<? super ViewContainer<?, ?>, ? super T, Unit> itemViewBuilder;
    public aa<RefreshView> refreshView;
    public aa<ECStateView> stateView;
    public final ReadWriteProperty headerText$delegate = c.a("\u4e0b\u62c9\u5237\u65b0");
    public final ReadWriteProperty footerRefreshState$delegate = c.a(FooterRefreshState.IDLE);
    public final ReadWriteProperty networkState$delegate = c.a(NetworkState.Loading);

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RefreshViewState.values().length];
            try {
                iArr[RefreshViewState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RefreshViewState.PULLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RefreshViewState.REFRESHING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ECRefreshListViewAttr access$getAttr(ECRefreshListView eCRefreshListView) {
        return (ECRefreshListViewAttr) eCRefreshListView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ECRefreshListViewEvent access$getEvent(ECRefreshListView eCRefreshListView) {
        return (ECRefreshListViewEvent) eCRefreshListView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$handleHeaderStateChange(ECRefreshListView eCRefreshListView, RefreshViewState refreshViewState) {
        String str;
        eCRefreshListView.getClass();
        int i3 = WhenMappings.$EnumSwitchMapping$0[refreshViewState.ordinal()];
        if (i3 == 1) {
            str = "\u4e0b\u62c9\u5237\u65b0";
        } else if (i3 == 2) {
            str = "\u91ca\u653e\u5237\u65b0";
        } else if (i3 == 3) {
            Function0<Unit> function0 = ((ECRefreshListViewEvent) eCRefreshListView.getEvent()).refreshHandler;
            if (function0 != null) {
                function0.invoke();
            }
            str = "\u6b63\u5728\u5237\u65b0";
        } else {
            throw new NoWhenBranchMatchedException();
        }
        eCRefreshListView.headerText$delegate.setValue(eCRefreshListView, $$delegatedProperties[0], str);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView$body$1
            public final /* synthetic */ ECRefreshListView<T> $ctx;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$ctx = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.flexDirectionColumn();
                        return Unit.INSTANCE;
                    }
                });
                final ECRefreshListView<T> eCRefreshListView = this.$ctx;
                ar.a(viewContainer2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(aq<?, ?> aqVar) {
                        final aq<?, ?> aqVar2 = aqVar;
                        final ECRefreshListView<Object> eCRefreshListView2 = eCRefreshListView;
                        aqVar2.ref(aqVar2, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                ECRefreshListView<Object> eCRefreshListView3 = eCRefreshListView2;
                                KProperty<Object>[] kPropertyArr = ECRefreshListView.$$delegatedProperties;
                                eCRefreshListView3.getClass();
                                return Unit.INSTANCE;
                            }
                        });
                        final ECRefreshListView<Object> eCRefreshListView3 = eCRefreshListView;
                        aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ao aoVar) {
                                ao aoVar2 = aoVar;
                                aoVar2.m140flex(1.0f);
                                aoVar2.showScrollerIndicator(false);
                                if (ECRefreshListView.access$getAttr(eCRefreshListView3).preloadDistance > 0.0f) {
                                    aoVar2.preloadViewDistance(ECRefreshListView.access$getAttr(eCRefreshListView3).preloadDistance);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final ECRefreshListView<Object> eCRefreshListView4 = eCRefreshListView;
                        aqVar2.event(new Function1<ap, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ap apVar) {
                                ap apVar2 = apVar;
                                final ECRefreshListView<Object> eCRefreshListView5 = eCRefreshListView4;
                                apVar2.dragBegin(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        ScrollParams scrollParams2 = scrollParams;
                                        Function1<? super ScrollParams, Unit> function1 = ECRefreshListView.access$getEvent(eCRefreshListView5).dragBeginHandler;
                                        if (function1 != null) {
                                            function1.invoke(scrollParams2);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final ECRefreshListView<Object> eCRefreshListView6 = eCRefreshListView4;
                                apVar2.scrollEnd(new Function1<ScrollParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.3.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ScrollParams scrollParams) {
                                        ScrollParams scrollParams2 = scrollParams;
                                        Function1<? super ScrollParams, Unit> function1 = ECRefreshListView.access$getEvent(eCRefreshListView6).scrollEndHandler;
                                        if (function1 != null) {
                                            function1.invoke(scrollParams2);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final ECRefreshListView<Object> eCRefreshListView5 = eCRefreshListView;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Boolean.valueOf(ECRefreshListView.access$getAttr(eCRefreshListView5).getDataList().isEmpty() && ECRefreshListView.access$getAttr(eCRefreshListView5).emptyViewBuilder == null);
                            }
                        };
                        final ECRefreshListView<Object> eCRefreshListView6 = eCRefreshListView;
                        ConditionViewKt.c(aqVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.5
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                final ECRefreshListView<Object> eCRefreshListView7 = eCRefreshListView6;
                                w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.5.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        final ECRefreshListView<Object> eCRefreshListView8 = eCRefreshListView7;
                                        vVar.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.5.1.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final u uVar2 = uVar;
                                                final ECRefreshListView<Object> eCRefreshListView9 = eCRefreshListView8;
                                                FrameEventKt.d(uVar2, new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.5.1.1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(d dVar) {
                                                        AbstractBaseView<?, ?> view = u.this.getView();
                                                        FlexNode flexNode = view != null ? view.getFlexNode() : null;
                                                        if (flexNode != null) {
                                                            flexNode.L0(eCRefreshListView9.getFlexNode().t());
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
                        if (ECRefreshListView.access$getAttr(eCRefreshListView).supportRefreshHeader) {
                            final ECRefreshListView<Object> eCRefreshListView7 = eCRefreshListView;
                            bm.b(aqVar2, false, new Function1<RefreshView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.6
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(RefreshView refreshView) {
                                    RefreshView refreshView2 = refreshView;
                                    final ECRefreshListView<Object> eCRefreshListView8 = eCRefreshListView7;
                                    refreshView2.ref(refreshView2, new Function1<aa<RefreshView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.6.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(aa<RefreshView> aaVar) {
                                            eCRefreshListView8.refreshView = aaVar;
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    refreshView2.attr(new Function1<bk, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.6.2
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(bk bkVar) {
                                            bk bkVar2 = bkVar;
                                            bkVar2.flexDirectionRow();
                                            bkVar2.justifyContentCenter();
                                            bkVar2.alignItemsCenter();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    ah.a(refreshView2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.6.3
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.6.3.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQCAMAAAC5zwKfAAABQVBMVEUAAAD////v6u/////t5+3y7PL7+/vx7fLg19/07PTr6+vd1Nzh1uHp5Oj09PTu6e749Pjy8vPv7O/o5Oj4+Pns6ez19fXm3Ob4+Pjp4urp4ujz8PLc2N7Z1dvm5Ofh2uH7/Pzn4efz8/P6+vr09/fb0Nvl2uXr5+ri3+Laztr09fbe1t/o3Ofx8fHdz9729vbk2uHw6fDx8vL9/f3d0N38/Pzb1dvi2ODx8vLq6urv8PDt7e3t7+78/P3s6+zj4uTi4OLRxdHn5uf+//7z9PTZz9je297WztXRx9Dg3uHWydXTytLb19vZ0tjl5OX2+Pfo6OjZ19rOw8329ffu5+7d193d0Nzr5Ovn4ejY1djOzM/d1NzUxtTh0+Hh2+Dc2tzTzNLOxc3ay9rV09bS0NPSx9HW0Nb4+Pnp3+nMyMzl2eVVtzfcAAAAOHRSTlMAA0QHPjAP/uMWDfnYlIZgHOTW0LSgko94d1km9fG6rptsa2BI/O3n5NPKxcKsnFVVI/Ty8OqmhNTrSmMAAAL9SURBVFjD7dXXVuJQFIDh0FE60rGOjr1OTUglGtAEkFCCVAWU4vs/wOxzIjNzw5IVnKvJv7yKrs99SoAwMzMzMzMz+79z2i92A3tpy8doK4ljmqYp6CBq/YDhYl8yDI3FsiiW1pYlraEMjsEzirzAR1eX8T4xgJEkCSKDxBIvCGsrS3iYQyBE0xyMyN/ljIt7DHi42apFGDGX27QYPI8Qo3OzNXM6WCgkjYExTp/vBiIzyNOX/KiuB414QYrJIO4eApHhOHwod48FdegzAib+gDBiBg+IQFUdjjbe7o7DfxbdcS4Ihjk4EwziJf8eUG0+t54j27HE7l4M78KhdaETsVIIzOg7SMKK4VXhMTh8brXEKkTSDA0PhXXHO5t34Y+ESBKDICIOL7gsgpcrNMGbrp+uHTQ4+DUHD+sn8zHYlTBVKj1AFEdngMQah7wyPwOnLTf8qQ/+I03Bs3r7ah63ekY9NodF99bPlE/kaEYPOPD0AfGKp9MNuNubNHmje925u7jNihs/UkH82okUFtEbhzwReXBnmsOnljLKJbaPSdJVe4CRi5pmnwdGWPZ7xL9rTzttAQSiOJ0rlUqiKJYpeHvu2fsq6XLVJq9dRW2O8oNvzrk7GBqz1zj2K/tX1/AUx7JVsGqNyWT/NL7f7vfzeSXbOSfmZktFw67qGCOzMDke61Jj8vra7XbjK7CJl1Jevr3NZo/e+Yi0pa2BpN8XbjRqKEAacOiC0MvV25KUz8uDgabfPPuRnM1mz8FbpFRPEHiefxCgO8AKarMIC1TkTkf2WgicxXFpXfjT0XZYz/V66AewQrMI2tOT8gIjdQYBwkiBertQB0uFkxxhTUE7loUBbYZAy2YR18azAXbb71cqAH62G/1GdkuSVGy3NUlSlDcOPC1JGC2NxG5X0yTwKuBVkBcnjHflhWsiadoAgXg++XOSWKZVn0eSoRfYQcQNvHZiyRxbQCryCyRL7h0bsXzBnS2vx+Nxn8TtFuKjsthsFsLMzMzMzMzsH/cLPKnsav8gklIAAAAASUVORK5CYII=", false, 2, null);
                                                    afVar2.mo153width(40.0f);
                                                    afVar2.mo141height(40.0f);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final ECRefreshListView<Object> eCRefreshListView9 = eCRefreshListView7;
                                    cg.a(refreshView2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.6.4
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final ECRefreshListView<Object> eCRefreshListView10 = eCRefreshListView9;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.6.4.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.marginLeft(5.0f);
                                                    ECRefreshListView<Object> eCRefreshListView11 = eCRefreshListView10;
                                                    ceVar2.text((String) eCRefreshListView11.headerText$delegate.getValue(eCRefreshListView11, ECRefreshListView.$$delegatedProperties[0]));
                                                    ceVar2.color(new h(4291282887L));
                                                    ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                    ceVar2.fontWeightBold();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final ECRefreshListView<Object> eCRefreshListView10 = eCRefreshListView7;
                                    refreshView2.event(new Function1<bl, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.6.5
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(bl blVar) {
                                            final ECRefreshListView<Object> eCRefreshListView11 = eCRefreshListView10;
                                            blVar.j(new Function1<RefreshViewState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.6.5.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(RefreshViewState refreshViewState) {
                                                    ECRefreshListView.access$handleHeaderStateChange(eCRefreshListView11, refreshViewState);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            }, 1, null);
                        }
                        final ECRefreshListView<Object> eCRefreshListView8 = eCRefreshListView;
                        Function0<com.tencent.kuikly.core.reactive.collection.c<Object>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<Object>>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final com.tencent.kuikly.core.reactive.collection.c<Object> invoke() {
                                return ECRefreshListView.access$getAttr(eCRefreshListView8).getDataList();
                            }
                        };
                        final ECRefreshListView<Object> eCRefreshListView9 = eCRefreshListView;
                        LoopDirectivesViewKt.a(aqVar2, function02, new Function2<LoopDirectivesView<Object>, Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.8
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Unit invoke(LoopDirectivesView<Object> loopDirectivesView, final Object obj) {
                                final ECRefreshListView<Object> eCRefreshListView10 = eCRefreshListView9;
                                w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.8.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        Function2<? super ViewContainer<?, ?>, ? super Object, Unit> function2 = eCRefreshListView10.itemViewBuilder;
                                        if (function2 == null) {
                                            Intrinsics.throwUninitializedPropertyAccessException("itemViewBuilder");
                                            function2 = null;
                                        }
                                        function2.invoke(vVar2, obj);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        if (ECRefreshListView.access$getAttr(eCRefreshListView).supportRefreshFooter) {
                            final ECRefreshListView<Object> eCRefreshListView10 = eCRefreshListView;
                            Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.9
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Boolean.valueOf(!ECRefreshListView.access$getAttr(eCRefreshListView10).getDataList().isEmpty());
                                }
                            };
                            final ECRefreshListView<Object> eCRefreshListView11 = eCRefreshListView;
                            ConditionViewKt.c(aqVar2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.10
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ConditionView conditionView) {
                                    ConditionView conditionView2 = conditionView;
                                    final ECRefreshListView<Object> eCRefreshListView12 = eCRefreshListView11;
                                    Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.10.1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(0);
                                        }

                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            ECRefreshListView<Object> eCRefreshListView13 = eCRefreshListView12;
                                            return Boolean.valueOf(((FooterRefreshState) eCRefreshListView13.footerRefreshState$delegate.getValue(eCRefreshListView13, ECRefreshListView.$$delegatedProperties[1])) == FooterRefreshState.NONE_MORE_DATA && ECRefreshListView.access$getAttr(eCRefreshListView12).footerViewBuilder != null);
                                        }
                                    };
                                    final ECRefreshListView<Object> eCRefreshListView13 = eCRefreshListView11;
                                    ConditionViewKt.c(conditionView2, function04, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.10.2
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ConditionView conditionView3) {
                                            ConditionView conditionView4 = conditionView3;
                                            Function1<? super ViewContainer<?, ?>, Unit> function1 = ECRefreshListView.access$getAttr(eCRefreshListView13).footerViewBuilder;
                                            if (function1 != null) {
                                                function1.invoke(conditionView4);
                                            }
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final ECRefreshListView<Object> eCRefreshListView14 = eCRefreshListView11;
                                    ConditionViewKt.a(conditionView2, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.10.3
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ConditionView conditionView3) {
                                            final ECRefreshListView<Object> eCRefreshListView15 = eCRefreshListView14;
                                            ECRefreshFooterKt.ECRefreshFooter(conditionView3, new Function1<ECRefreshFooter, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.10.3.1
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ECRefreshFooter eCRefreshFooter) {
                                                    ECRefreshFooter eCRefreshFooter2 = eCRefreshFooter;
                                                    final ECRefreshListView<Object> eCRefreshListView16 = eCRefreshListView15;
                                                    eCRefreshFooter2.attr(new Function1<ECRefreshFooterAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.10.3.1.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ECRefreshFooterAttr eCRefreshFooterAttr) {
                                                            ECRefreshFooterAttr eCRefreshFooterAttr2 = eCRefreshFooterAttr;
                                                            eCRefreshFooterAttr2.setPreloadDistance(500.0f);
                                                            ECRefreshListView<Object> eCRefreshListView17 = eCRefreshListView16;
                                                            eCRefreshFooterAttr2.setFooterRefreshState((FooterRefreshState) eCRefreshListView17.footerRefreshState$delegate.getValue(eCRefreshListView17, ECRefreshListView.$$delegatedProperties[1]));
                                                            eCRefreshFooterAttr2.footerNoMoreText = ECRefreshListView.access$getAttr(eCRefreshListView16).footerNoMoreText;
                                                            ECRefreshListViewAttr access$getAttr = ECRefreshListView.access$getAttr(eCRefreshListView16);
                                                            eCRefreshFooterAttr2.showIphoneXSafeBottom$delegate.setValue(eCRefreshFooterAttr2, ECRefreshFooterAttr.$$delegatedProperties[3], Boolean.valueOf(((Boolean) access$getAttr.showIphoneXSafeBottom$delegate.getValue(access$getAttr, ECRefreshListViewAttr.$$delegatedProperties[0])).booleanValue()));
                                                            eCRefreshFooterAttr2.footerHeight = ECRefreshListView.access$getAttr(eCRefreshListView16).footerHeight;
                                                            ECRefreshListView.access$getAttr(eCRefreshListView16).getClass();
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    final ECRefreshListView<Object> eCRefreshListView17 = eCRefreshListView15;
                                                    eCRefreshFooter2.event(new Function1<ECRefreshFooterEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.10.3.1.2
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ECRefreshFooterEvent eCRefreshFooterEvent) {
                                                            ECRefreshFooterEvent eCRefreshFooterEvent2 = eCRefreshFooterEvent;
                                                            final ECRefreshListView<Object> eCRefreshListView18 = eCRefreshListView17;
                                                            eCRefreshFooterEvent2.onRefreshingHandlerFn = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.10.3.1.2.1
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(0);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function0
                                                                public final Unit invoke() {
                                                                    Function0<Unit> function05 = ECRefreshListView.access$getEvent(eCRefreshListView18).loadMoreHandler;
                                                                    if (function05 != null) {
                                                                        function05.invoke();
                                                                    }
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
                                                            final ECRefreshListView<Object> eCRefreshListView19 = eCRefreshListView17;
                                                            eCRefreshFooterEvent2.refreshStateDidChangeHandlerFn = new Function1<FooterRefreshState, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.10.3.1.2.2
                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                {
                                                                    super(1);
                                                                }

                                                                @Override // kotlin.jvm.functions.Function1
                                                                public final Unit invoke(FooterRefreshState footerRefreshState) {
                                                                    ECRefreshListView<Object> eCRefreshListView20 = eCRefreshListView19;
                                                                    KProperty<Object>[] kPropertyArr = ECRefreshListView.$$delegatedProperties;
                                                                    eCRefreshListView20.setFooterRefreshState(footerRefreshState);
                                                                    return Unit.INSTANCE;
                                                                }
                                                            };
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
                        } else {
                            final ECRefreshListView<Object> eCRefreshListView12 = eCRefreshListView;
                            ConditionViewKt.c(aqVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.11
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Code restructure failed: missing block: B:6:0x0039, code lost:
                                
                                    if (r2.getPager().getPageData().getIsIphoneX() != false) goto L10;
                                 */
                                @Override // kotlin.jvm.functions.Function0
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Object invoke() {
                                    boolean z16 = true;
                                    if (!ECRefreshListView.access$getAttr(eCRefreshListView12).getDataList().isEmpty()) {
                                        ECRefreshListViewAttr access$getAttr = ECRefreshListView.access$getAttr(eCRefreshListView12);
                                        if (((Boolean) access$getAttr.showIphoneXSafeBottom$delegate.getValue(access$getAttr, ECRefreshListViewAttr.$$delegatedProperties[0])).booleanValue()) {
                                        }
                                    }
                                    z16 = false;
                                    return Boolean.valueOf(z16);
                                }
                            }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.12
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ConditionView conditionView) {
                                    w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.12.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar) {
                                            vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.2.12.1.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    AttrExtKt.backgroundColorToken(tVar2, "qecommerce_skin_color_bg_default");
                                                    tVar2.mo141height(34.0f);
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
                        return Unit.INSTANCE;
                    }
                });
                final ECRefreshListView<T> eCRefreshListView2 = this.$ctx;
                viewContainer2.addChild(new ECStateView(), new Function1<ECStateView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView$body$1.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECStateView eCStateView) {
                        ECStateView eCStateView2 = eCStateView;
                        final ECRefreshListView<Object> eCRefreshListView3 = eCRefreshListView2;
                        eCStateView2.ref(eCStateView2, new Function1<aa<ECStateView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aa<ECStateView> aaVar) {
                                eCRefreshListView3.stateView = aaVar;
                                return Unit.INSTANCE;
                            }
                        });
                        final ECRefreshListView<Object> eCRefreshListView4 = eCRefreshListView2;
                        eCStateView2.attr(new Function1<ECStateViewAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.3.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECStateViewAttr eCStateViewAttr) {
                                ECStateViewAttr eCStateViewAttr2 = eCStateViewAttr;
                                ECRefreshListView<Object> eCRefreshListView5 = eCRefreshListView4;
                                eCStateViewAttr2.state$delegate.setValue(eCStateViewAttr2, ECStateViewAttr.$$delegatedProperties[0], (NetworkState) eCRefreshListView5.networkState$delegate.getValue(eCRefreshListView5, ECRefreshListView.$$delegatedProperties[2]));
                                eCStateViewAttr2.emptyText = ECRefreshListView.access$getAttr(eCRefreshListView4).emptyText;
                                ECRefreshListView.access$getAttr(eCRefreshListView4).getClass();
                                eCStateViewAttr2.emptyImgToken = null;
                                ECRefreshListView.access$getAttr(eCRefreshListView4).getClass();
                                eCStateViewAttr2.emptyViewBackgroundColor = null;
                                ECRefreshListView.access$getAttr(eCRefreshListView4).getClass();
                                eCStateViewAttr2.emptyTextColor = null;
                                ECRefreshListView.access$getAttr(eCRefreshListView4).getClass();
                                eCStateViewAttr2.errorImageToken = null;
                                ECRefreshListView.access$getAttr(eCRefreshListView4).getClass();
                                eCStateViewAttr2.errorTextColor = null;
                                eCStateViewAttr2.m154zIndex(1);
                                Integer num = ECRefreshListView.access$getAttr(eCRefreshListView4).loadingDelay;
                                if (num != null) {
                                    eCStateViewAttr2.loadingDelay = Integer.valueOf(num.intValue());
                                }
                                eCStateViewAttr2.emptyViewBuilder = ECRefreshListView.access$getAttr(eCRefreshListView4).emptyViewBuilder;
                                eCStateViewAttr2.errorViewBuilder = ECRefreshListView.access$getAttr(eCRefreshListView4).errorViewBuilder;
                                eCStateViewAttr2.buttonBgColor = ECRefreshListView.access$getAttr(eCRefreshListView4).buttonBgColor;
                                return Unit.INSTANCE;
                            }
                        });
                        final ECRefreshListView<Object> eCRefreshListView5 = eCRefreshListView2;
                        eCStateView2.event(new Function1<ECStateViewEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.3.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECStateViewEvent eCStateViewEvent) {
                                final ECRefreshListView<Object> eCRefreshListView6 = eCRefreshListView5;
                                eCStateViewEvent.retryHandler = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView.body.1.3.3.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        Function0<Unit> function0 = ECRefreshListView.access$getEvent(eCRefreshListView6).retryHandler;
                                        if (function0 != null) {
                                            function0.invoke();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
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
        return new ECRefreshListViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new ECRefreshListViewEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        ReactiveObserver.Companion companion = ReactiveObserver.INSTANCE;
        ECRefreshListViewAttr eCRefreshListViewAttr = (ECRefreshListViewAttr) getAttr();
        companion.b((RefreshListState) eCRefreshListViewAttr.listState$delegate.getValue(eCRefreshListViewAttr, ECRefreshListViewAttr.$$delegatedProperties[2]), new Function1<Boolean, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.base.ECRefreshListView$created$1
            public final /* synthetic */ ECRefreshListView<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                FooterRefreshState footerRefreshState;
                NetworkState networkState;
                bool.booleanValue();
                ECRefreshListView<T> eCRefreshListView = this.this$0;
                ECRefreshListViewAttr access$getAttr = ECRefreshListView.access$getAttr(eCRefreshListView);
                RefreshListState refreshListState = (RefreshListState) access$getAttr.listState$delegate.getValue(access$getAttr, ECRefreshListViewAttr.$$delegatedProperties[2]);
                if (Intrinsics.areEqual(refreshListState, RefreshListState.Idle.INSTANCE)) {
                    networkState = NetworkState.Idle;
                } else if (Intrinsics.areEqual(refreshListState, RefreshListState.Loading.INSTANCE)) {
                    networkState = NetworkState.Loading;
                } else if (refreshListState instanceof RefreshListState.Empty) {
                    ECRefreshListView.access$handleRefreshResult(this.this$0, true, false);
                    networkState = NetworkState.Empty;
                } else if (refreshListState instanceof RefreshListState.Error) {
                    ECRefreshListView.access$handleRefreshResult(this.this$0, false, false);
                    networkState = NetworkState.Error;
                } else if (refreshListState instanceof RefreshListState.RefreshResult) {
                    RefreshListState.RefreshResult refreshResult = (RefreshListState.RefreshResult) refreshListState;
                    ECRefreshListView.access$handleRefreshResult(this.this$0, refreshResult.isSucceed, refreshResult.hasMoreData);
                    networkState = NetworkState.Success;
                } else if (refreshListState instanceof RefreshListState.LoadingMoreResult) {
                    ECRefreshListView<T> eCRefreshListView2 = this.this$0;
                    RefreshListState.LoadingMoreResult loadingMoreResult = (RefreshListState.LoadingMoreResult) refreshListState;
                    eCRefreshListView2.getClass();
                    boolean z16 = loadingMoreResult.isSucceed;
                    if (z16 && loadingMoreResult.hasMoreData) {
                        footerRefreshState = FooterRefreshState.IDLE;
                    } else if (z16) {
                        footerRefreshState = FooterRefreshState.NONE_MORE_DATA;
                    } else {
                        footerRefreshState = FooterRefreshState.FAILURE;
                    }
                    eCRefreshListView2.setFooterRefreshState(footerRefreshState);
                    networkState = NetworkState.Success;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                eCRefreshListView.networkState$delegate.setValue(eCRefreshListView, ECRefreshListView.$$delegatedProperties[2], networkState);
                return Unit.INSTANCE;
            }
        });
    }

    public final void setFooterRefreshState(FooterRefreshState footerRefreshState) {
        this.footerRefreshState$delegate.setValue(this, $$delegatedProperties[1], footerRefreshState);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLayout() {
        ECStateView b16;
        super.viewDidLayout();
        aa<ECStateView> aaVar = this.stateView;
        FlexNode flexNode = (aaVar == null || (b16 = aaVar.b()) == null) ? null : b16.getFlexNode();
        if (flexNode == null) {
            return;
        }
        flexNode.L0(getFlexNode().t());
    }

    public static final void access$handleRefreshResult(ECRefreshListView eCRefreshListView, boolean z16, boolean z17) {
        String str;
        FooterRefreshState footerRefreshState;
        RefreshView b16;
        if (z16) {
            str = "\u5237\u65b0\u6210\u529f";
        } else {
            str = "\u5237\u65b0\u5931\u8d25";
        }
        eCRefreshListView.headerText$delegate.setValue(eCRefreshListView, $$delegatedProperties[0], str);
        aa<RefreshView> aaVar = eCRefreshListView.refreshView;
        if (aaVar != null && (b16 = aaVar.b()) != null) {
            b16.p();
        }
        if (!z17) {
            footerRefreshState = FooterRefreshState.NONE_MORE_DATA;
        } else {
            footerRefreshState = FooterRefreshState.IDLE;
        }
        eCRefreshListView.setFooterRefreshState(footerRefreshState);
    }
}
