package com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGView;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGViewKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.b;
import com.tencent.kuikly.core.base.event.AnimationCompletionParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class LiveHotSaleView extends ComposeView<LiveHotSaleViewAttr, HotSaleViewEvent> {
    public final LiveHotSaleViewAttr viewAttr = new LiveHotSaleViewAttr();

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final LiveHotSaleView liveHotSaleView = LiveHotSaleView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo141height(27.0f).borderRadius(13.5f);
                        mVar2.flexDirectionRow().alignItemsCenter();
                        mVar2.mo135backgroundLinearGradient(Direction.TO_RIGHT, new j(new h(2163305728L), 0.0f), new j(new h(15822080L), 1.0f));
                        mVar2.transform(new y(1.25f, 0.0f, 0.0f, 0.0f, 12, null));
                        mVar2.m147opacity(0.0f);
                        LiveHotSaleViewAttr liveHotSaleViewAttr = LiveHotSaleView.this.viewAttr;
                        ReadWriteProperty readWriteProperty = liveHotSaleViewAttr.appearAnimated$delegate;
                        KProperty<?>[] kPropertyArr = LiveHotSaleViewAttr.$$delegatedProperties;
                        if (((Boolean) readWriteProperty.getValue(liveHotSaleViewAttr, kPropertyArr[1])).booleanValue()) {
                            mVar2.transform(new y(0.0f, 0.0f, 0.0f, 0.0f, 12, null));
                            mVar2.m147opacity(1.0f);
                        }
                        b n3 = b.Companion.n(b.INSTANCE, 0.5f, 0.8f, 0.7f, null, 8, null);
                        LiveHotSaleViewAttr liveHotSaleViewAttr2 = LiveHotSaleView.this.viewAttr;
                        mVar2.m134animation(n3, (Object) Boolean.valueOf(((Boolean) liveHotSaleViewAttr2.appearAnimated$delegate.getValue(liveHotSaleViewAttr2, kPropertyArr[1])).booleanValue()));
                        return Unit.INSTANCE;
                    }
                });
                final LiveHotSaleView liveHotSaleView2 = LiveHotSaleView.this;
                viewContainer2.event(new Function1<Event, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Event event) {
                        final LiveHotSaleView liveHotSaleView3 = LiveHotSaleView.this;
                        event.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                LiveHotSaleView.this.viewAttr.setIncreaseAnimated(true);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                PAGViewKt.PAG(viewContainer2, new Function1<PAGView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView$body$1.3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(PAGView pAGView) {
                        pAGView.attr(new Function1<PAGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(PAGAttr pAGAttr) {
                                PAGAttr pAGAttr2 = pAGAttr;
                                pAGAttr2.marginLeft(2.0f);
                                pAGAttr2.size(20.0f, 20.0f);
                                pAGAttr2.src("https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/p3Hm1RZt.pag");
                                pAGAttr2.repeatCount(Integer.MAX_VALUE);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView$body$1.4
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                af afVar2 = afVar;
                                afVar2.marginRight(2.0f);
                                afVar2.size(29.0f, 14.0f);
                                b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFcAAAAqCAMAAADxqjdBAAAAOVBMVEUAAAD///////////////////////////////////////////////////////////////////////8KOjVvAAAAEnRSTlMAQN+fv2CA7yAQz3CQMK9QXzEto0fhAAACCElEQVRIx9XW25LbIAwGYCQOAoztrN//YVsIQTKsD+mk0+5/s2sTPgMWjNUPjbcl0F9eJcAz4aAdthK9vzSXLmzPwP/r6u0q5u+6C/7OVkKIRpltiP0Dt3PwX7mrE3k9RDuRx333vXr4sHtdZ/Z56ZTtXexSXcJ9Dtzp0N3u5cB1lfug60UtwadcRNoUUqTn5Ty6+iLErjERSTwKy5/B5Tid3LTOQR0XF09Nui2LcMfCJOMg4wZL0n3XHLs8p1cHferSmy7ccXGCoNblwgWnDd1xMUZZv/bUtXYFr1SAaaHR1bzf/H5ftN85jc0N3vsgVyEu+Z3Nk5HuEHZ5s2G+/XId9zNi+dMsxpHOXV87lVP0wGVZzu/cRR7ut26i3q3/Tz26Wuuqy7/y0o0o1y/AmgxV9+QM5pmx6xS73CgzTwsVd+IdcuoyO7puu5cDN7OfdxHUR1zrXlnzUx6K44Hj33VnKGlfnfkef342NMeafWjPRVOjcuKrZOb2YkMrSW4dE/S2D3o512YM2pL3wZZDYVBBkzSHTWe5rKm9IP3U8q7hZk6AhDuO+Kj1+w+50EYZudh9m0Ti+dnUrStZ9SXuLI9CM6aWNkrggxdre0nCcfImMx67egj1IaVXP0ot55ODowp1GnrvruI0crzTqV8S+M6lJNb9C6XruJv8XIj9kkyDGyvKgaU2/QJZ/4CsXsuN1wAAAABJRU5ErkJggg==", false, 2, null);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final LiveHotSaleView liveHotSaleView3 = LiveHotSaleView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final LiveHotSaleView liveHotSaleView4 = LiveHotSaleView.this;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView.body.1.5.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                LiveHotSaleView liveHotSaleView5 = LiveHotSaleView.this;
                                Utils utils = Utils.INSTANCE;
                                String pagerId = tVar2.getPagerId();
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("live_explain increaseAnimated");
                                m3.append(liveHotSaleView5.viewAttr.getIncreaseAnimated());
                                utils.bridgeModule(pagerId).log(m3.toString());
                                if (liveHotSaleView5.viewAttr.getIncreaseAnimated()) {
                                    tVar2.transform(new u(1.2f, 1.2f));
                                } else {
                                    tVar2.transform(new u(1.0f, 1.0f));
                                }
                                tVar2.m134animation(b.Companion.l(com.tencent.kuikly.core.base.b.INSTANCE, 0.15f, null, 2, null), (Object) Boolean.valueOf(liveHotSaleView5.viewAttr.getIncreaseAnimated()));
                                return Unit.INSTANCE;
                            }
                        });
                        final LiveHotSaleView liveHotSaleView5 = LiveHotSaleView.this;
                        vVar2.event(new Function1<com.tencent.kuikly.core.views.u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView.body.1.5.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(com.tencent.kuikly.core.views.u uVar) {
                                final com.tencent.kuikly.core.views.u uVar2 = uVar;
                                final LiveHotSaleView liveHotSaleView6 = LiveHotSaleView.this;
                                uVar2.animationCompletion(new Function1<AnimationCompletionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView.body.1.5.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(AnimationCompletionParams animationCompletionParams) {
                                        Utils.INSTANCE.bridgeModule(com.tencent.kuikly.core.views.u.this.getPagerId()).log("live_explain hot sale animation completion");
                                        if (liveHotSaleView6.viewAttr.getIncreaseAnimated()) {
                                            liveHotSaleView6.viewAttr.setIncreaseAnimated(false);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final LiveHotSaleView liveHotSaleView6 = LiveHotSaleView.this;
                        RichTextViewKt.b(vVar2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView.body.1.5.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextView richTextView) {
                                RichTextView richTextView2 = richTextView;
                                final LiveHotSaleView liveHotSaleView7 = LiveHotSaleView.this;
                                richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView.body.1.5.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(RichTextAttr richTextAttr) {
                                        RichTextAttr richTextAttr2 = richTextAttr;
                                        if (LiveHotSaleView.this.getPagerData().getIsIOS()) {
                                            richTextAttr2.marginTop(4.0f);
                                        } else {
                                            richTextAttr2.marginBottom(2.6f);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView.body.1.5.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cf cfVar) {
                                        cf cfVar2 = cfVar;
                                        ce.fontSize$default(cfVar2, 15.0f, null, 2, null).fontFamily("Qvideo Digit").color(h.INSTANCE.m()).fontWeightBold();
                                        cfVar2.text(HippyTKDListViewAdapter.X);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final LiveHotSaleView liveHotSaleView8 = LiveHotSaleView.this;
                                RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive_biz.live_explain_page.view.LiveHotSaleView.body.1.5.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(cf cfVar) {
                                        cf cfVar2 = cfVar;
                                        ce.fontSize$default(cfVar2, 22.0f, null, 2, null).fontFamily("Qvideo Digit").color(h.INSTANCE.m()).fontWeightBold();
                                        LiveHotSaleViewAttr liveHotSaleViewAttr = LiveHotSaleView.this.viewAttr;
                                        ReadWriteProperty readWriteProperty = liveHotSaleViewAttr.hotSaleNum$delegate;
                                        KProperty<?>[] kPropertyArr = LiveHotSaleViewAttr.$$delegatedProperties;
                                        if (((Number) readWriteProperty.getValue(liveHotSaleViewAttr, kPropertyArr[2])).intValue() > 9999) {
                                            ce.fontSize$default(cfVar2, 18.0f, null, 2, null);
                                            cfVar2.value("9999+");
                                        } else {
                                            ce.fontSize$default(cfVar2, 22.0f, null, 2, null);
                                            LiveHotSaleViewAttr liveHotSaleViewAttr2 = LiveHotSaleView.this.viewAttr;
                                            cfVar2.value(String.valueOf(((Number) liveHotSaleViewAttr2.hotSaleNum$delegate.getValue(liveHotSaleViewAttr2, kPropertyArr[2])).intValue()));
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
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return this.viewAttr;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new HotSaleViewEvent();
    }

    public final void playIncreaseAnimation() {
        this.viewAttr.setIncreaseAnimated(true);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
    }
}
