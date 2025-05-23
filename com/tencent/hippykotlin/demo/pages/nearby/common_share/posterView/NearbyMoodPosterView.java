package com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.base.u;
import com.tencent.kuikly.core.base.y;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.LoadSuccessParams;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes31.dex */
public final class NearbyMoodPosterView extends ComposeView<NearbyMoodPosterViewAttr, NearbyMoodPosterViewEvent> {
    public Set<String> imageLoadingSet = new LinkedHashSet();

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NearbyMoodPosterViewAttr access$getAttr(NearbyMoodPosterView nearbyMoodPosterView) {
        return (NearbyMoodPosterViewAttr) nearbyMoodPosterView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$onImageLoaded(NearbyMoodPosterView nearbyMoodPosterView) {
        Function0<Unit> function0;
        nearbyMoodPosterView.getClass();
        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("onImageLoaded: ", "frameUrl", KLog.INSTANCE, "NearbyMoodPosterView");
        nearbyMoodPosterView.imageLoadingSet.remove("frameUrl");
        if (!nearbyMoodPosterView.imageLoadingSet.isEmpty() || (function0 = ((NearbyMoodPosterViewEvent) nearbyMoodPosterView.getEvent()).onRenderSuccessListener) == null) {
            return;
        }
        function0.invoke();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(720.0f, 1080.0f);
                        mVar2.transform(new u(0.8f, 0.8f));
                        return Unit.INSTANCE;
                    }
                });
                KLog kLog = KLog.INSTANCE;
                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("frameUrl: "), NearbyMoodPosterView.access$getAttr(NearbyMoodPosterView.this).data.mainPosterBgUrl, kLog, "NearbyMoodPosterView");
                NearbyMoodPosterView nearbyMoodPosterView = NearbyMoodPosterView.this;
                nearbyMoodPosterView.getClass();
                DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("addImageLoading: ", "frameUrl", kLog, "NearbyMoodPosterView");
                nearbyMoodPosterView.imageLoadingSet.add("frameUrl");
                UserDataManager userDataManager = UserDataManager.INSTANCE;
                final String str = userDataManager.getUserSelfInfo().nickName;
                if (str.length() == 0) {
                    str = "\u9644\u8fd1\u7528\u6237";
                }
                final String str2 = userDataManager.getUserSelfInfo().avatarUrl;
                final NearbyMoodPosterView nearbyMoodPosterView2 = NearbyMoodPosterView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(720.0f, 1080.0f);
                                tVar2.allCenter();
                                tVar2.flexDirectionColumn();
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyMoodPosterView nearbyMoodPosterView3 = NearbyMoodPosterView.this;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                ImageView imageView2 = imageView;
                                final NearbyMoodPosterView nearbyMoodPosterView4 = NearbyMoodPosterView.this;
                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        afVar2.size(720.0f, 1080.0f);
                                        b.a.b(afVar2, NearbyMoodPosterView.access$getAttr(NearbyMoodPosterView.this).data.mainPosterBgUrl, false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyMoodPosterView nearbyMoodPosterView5 = NearbyMoodPosterView.this;
                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageEvent imageEvent) {
                                        final NearbyMoodPosterView nearbyMoodPosterView6 = NearbyMoodPosterView.this;
                                        imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView.body.1.2.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                                NearbyMoodPosterView.access$onImageLoaded(NearbyMoodPosterView.this);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final String str3 = str2;
                        final String str4 = str;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView.body.1.2.3
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        Attr.absolutePosition$default(tVar2, 580.0f, 360.0f, 0.0f, 0.0f, 12, null);
                                        tVar2.mo141height(48.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.mo113backgroundColor(h.INSTANCE.m());
                                        tVar2.transform(new y(-0.5f, 0.0f, 0.0f, 0.0f, 14, null));
                                        tVar2.paddingTop(6.0f);
                                        tVar2.paddingLeft(6.0f);
                                        tVar2.paddingBottom(6.0f);
                                        tVar2.paddingRight(14.0f);
                                        tVar2.borderRadius(24.0f);
                                        tVar2.marginLeft(1.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final String str5 = str3;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView.body.1.2.3.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final String str6 = str5;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView.body.1.2.3.2.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(36.0f);
                                                afVar2.borderRadius(18.0f);
                                                afVar2.mo113backgroundColor(h.INSTANCE.e());
                                                b.a.b(afVar2, str6, false, 2, null);
                                                afVar2.marginRight(16.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final String str6 = str4;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView.body.1.2.3.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final String str7 = str6;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView.body.1.2.3.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                TextViewExtKt.textWithLineHeightFix(ceVar2, str7);
                                                ceVar2.color(new h(4279901214L));
                                                ceVar2.fontWeight500();
                                                ce.fontSize$default(ceVar2, 24.0f, null, 2, null);
                                                ceVar2.lineHeight(30.0f);
                                                ceVar2.lines(1);
                                                ceVar2.textPostProcessor("emoji");
                                                ceVar2.m144maxWidth(190.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView.body.1.2.3.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyMoodPosterView.body.1.2.3.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.absolutePositionAllZero();
                                                afVar2.size(48.0f);
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_h91B-70xrPB.png", false, 2, null);
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
        return new NearbyMoodPosterViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyMoodPosterViewEvent();
    }
}
