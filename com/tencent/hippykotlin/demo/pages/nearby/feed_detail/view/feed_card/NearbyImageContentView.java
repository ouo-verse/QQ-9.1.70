package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyProKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPStatusContentViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.w;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n35.v;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyImageContentView extends ComposeView<NearbyImageContentViewAttr, NearbyImageContentViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NearbyImageContentViewAttr access$getAttr(NearbyImageContentView nearbyImageContentView) {
        return (NearbyImageContentViewAttr) nearbyImageContentView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyImageContentView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NearbyImageContentView nearbyImageContentView = NearbyImageContentView.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyImageContentView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo153width(NearbyImageContentView.access$getAttr(NearbyImageContentView.this).getContentWidth());
                        mVar2.mo141height((NearbyImageContentView.access$getAttr(NearbyImageContentView.this).getContentWidth() / 3) * 4);
                        mVar2.borderRadius(12.0f);
                        mVar2.mo113backgroundColor(new h(4294310143L));
                        return Unit.INSTANCE;
                    }
                });
                final NearbyImageContentView nearbyImageContentView2 = NearbyImageContentView.this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyImageContentView$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        final NearbyImageContentView nearbyImageContentView3 = NearbyImageContentView.this;
                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyImageContentView.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                v statusImageIndexNode;
                                af afVar2 = afVar;
                                NearbyImageContentViewAttr access$getAttr = NearbyImageContentView.access$getAttr(NearbyImageContentView.this);
                                ReadWriteProperty readWriteProperty = access$getAttr.viewModel$delegate;
                                KProperty<?>[] kPropertyArr = NearbyImageContentViewAttr.$$delegatedProperties;
                                NearbyFDPStatusContentViewModel nearbyFDPStatusContentViewModel = (NearbyFDPStatusContentViewModel) readWriteProperty.getValue(access$getAttr, kPropertyArr[1]);
                                if (nearbyFDPStatusContentViewModel != null && (statusImageIndexNode = nearbyFDPStatusContentViewModel.getStatusImageIndexNode()) != null) {
                                    NearbyProKtxKt.srcWithIndexNode(afVar2, statusImageIndexNode);
                                } else {
                                    NearbyImageContentView nearbyImageContentView4 = NearbyImageContentView.this;
                                    KLog kLog = KLog.INSTANCE;
                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("feedID=");
                                    NearbyImageContentViewAttr access$getAttr2 = NearbyImageContentView.access$getAttr(nearbyImageContentView4);
                                    NearbyFDPStatusContentViewModel nearbyFDPStatusContentViewModel2 = (NearbyFDPStatusContentViewModel) access$getAttr2.viewModel$delegate.getValue(access$getAttr2, kPropertyArr[1]);
                                    m3.append(nearbyFDPStatusContentViewModel2 != null ? nearbyFDPStatusContentViewModel2.getFeedID() : null);
                                    m3.append(", statusImageIndexNode is null, ");
                                    kLog.e("NearbyImageContentView", m3.toString());
                                }
                                afVar2.m140flex(1.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NearbyImageContentView nearbyImageContentView3 = NearbyImageContentView.this;
                w.a(viewContainer2, new Function1<com.tencent.kuikly.core.views.v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyImageContentView$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(com.tencent.kuikly.core.views.v vVar) {
                        final NearbyImageContentView nearbyImageContentView4 = NearbyImageContentView.this;
                        vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card.NearbyImageContentView.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.mo153width(NearbyImageContentView.access$getAttr(NearbyImageContentView.this).getContentWidth());
                                tVar2.mo141height(153.0f);
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, -1.0f, 0.0f, 9, null);
                                tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(0L, 0.0f), 0.0f), new j(new h(0L, 0.6f), 1.0f));
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
        return new NearbyImageContentViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyImageContentViewEvent();
    }
}
