package com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView;

import c01.c;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyProKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NearbyFeedPosterData;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.a;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.d;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
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
import com.tencent.kuikly.demo.pages.base.qrcode.QRCodeView;
import defpackage.k;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.Typography;

/* loaded from: classes31.dex */
public final class NearbyFeedPosterView extends ComposeView<NearbyFeedPosterViewAttr, NearbyFeedPosterViewEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedPosterView.class, "showQRCode", "getShowQRCode()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFeedPosterView.class, "qrCodeReady", "getQrCodeReady()Z", 0)};
    public Map<String, ImageLoadingTask> imageLoadingTasks = new LinkedHashMap();
    public final ReadWriteProperty qrCodeReady$delegate;
    public final ReadWriteProperty showQRCode$delegate;

    public NearbyFeedPosterView() {
        Boolean bool = Boolean.FALSE;
        this.showQRCode$delegate = c.a(bool);
        this.qrCodeReady$delegate = c.a(bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ NearbyFeedPosterViewAttr access$getAttr(NearbyFeedPosterView nearbyFeedPosterView) {
        return (NearbyFeedPosterViewAttr) nearbyFeedPosterView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final String access$getTitle(NearbyFeedPosterView nearbyFeedPosterView) {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(((NearbyFeedPosterViewAttr) nearbyFeedPosterView.getAttr()).data.feedTitle);
        if (!isBlank) {
            return ((NearbyFeedPosterViewAttr) nearbyFeedPosterView.getAttr()).data.feedTitle;
        }
        return ((NearbyFeedPosterViewAttr) nearbyFeedPosterView.getAttr()).config.titleFallbackText;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [java.util.LinkedHashMap, java.util.Map<java.lang.String, com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.ImageLoadingTask>] */
    public static final void access$onImageLoaded(NearbyFeedPosterView nearbyFeedPosterView, String str) {
        Function0<Unit> function0;
        Object obj;
        Function0<Unit> function02;
        nearbyFeedPosterView.getClass();
        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("onImageLoaded: ", str, KLog.INSTANCE, "NearbyFeedPosterView");
        ImageLoadingTask remove = nearbyFeedPosterView.imageLoadingTasks.remove(str);
        if (remove != null) {
            if (remove.blockShow) {
                Iterator it = nearbyFeedPosterView.imageLoadingTasks.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    } else {
                        obj = it.next();
                        if (((ImageLoadingTask) obj).blockShow) {
                            break;
                        }
                    }
                }
                if ((obj == null) && (function02 = ((NearbyFeedPosterViewEvent) nearbyFeedPosterView.getEvent()).onReadyToShowListener) != null) {
                    function02.invoke();
                }
            }
            if (nearbyFeedPosterView.imageLoadingTasks.isEmpty() && (function0 = ((NearbyFeedPosterViewEvent) nearbyFeedPosterView.getEvent()).onReadyToCaptureListener) != null) {
                function0.invoke();
            }
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onImageLoaded: imageLoadingTasks: ");
            m3.append(nearbyFeedPosterView.imageLoadingTasks.size());
            m3.append(", details: ");
            m3.append(nearbyFeedPosterView.imageLoadingTasks);
            kLog.i("NearbyFeedPosterView", m3.toString());
        }
    }

    public static void addImageLoading$default(NearbyFeedPosterView nearbyFeedPosterView, String str) {
        nearbyFeedPosterView.getClass();
        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("addImageLoading: ", str, KLog.INSTANCE, "NearbyFeedPosterView");
        nearbyFeedPosterView.imageLoadingTasks.put(str, new ImageLoadingTask(str, true));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(((NearbyFeedPosterViewAttr) getAttr()).mode);
        if (ordinal == 0) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$normalBody$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                    ViewContainer<?, ?> viewContainer2 = viewContainer;
                    viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$normalBody$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(m mVar) {
                            mVar.size(630.0f, 848.0f);
                            return Unit.INSTANCE;
                        }
                    });
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("frameUrl: "), NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.frameUrl, KLog.INSTANCE, "NearbyFeedPosterView");
                    NearbyFeedPosterView.addImageLoading$default(NearbyFeedPosterView.this, "frameUrl");
                    final NearbyFeedPosterView nearbyFeedPosterView = NearbyFeedPosterView.this;
                    ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$normalBody$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ImageView imageView) {
                            ImageView imageView2 = imageView;
                            final NearbyFeedPosterView nearbyFeedPosterView2 = NearbyFeedPosterView.this;
                            imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.2.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(af afVar) {
                                    af afVar2 = afVar;
                                    Attr.absolutePosition$default(afVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                    afVar2.size(630.0f, 848.0f);
                                    b.a.b(afVar2, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.frameUrl, false, 2, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            final NearbyFeedPosterView nearbyFeedPosterView3 = NearbyFeedPosterView.this;
                            imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.2.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageEvent imageEvent) {
                                    final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                                    imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.2.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                            NearbyFeedPosterView.access$onImageLoaded(NearbyFeedPosterView.this, "frameUrl");
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    final NearbyFeedPosterView nearbyFeedPosterView2 = NearbyFeedPosterView.this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$normalBody$1.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.3.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    Attr.absolutePosition$default(tVar2, 14.0f, 14.0f, 0.0f, 0.0f, 12, null);
                                    tVar2.size(602.0f, 602.0f);
                                    tVar2.borderRadius(4.0f);
                                    return Unit.INSTANCE;
                                }
                            });
                            if (NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.feedImage != null) {
                                NearbyFeedPosterView.addImageLoading$default(NearbyFeedPosterView.this, "feedImage");
                                final NearbyFeedPosterView nearbyFeedPosterView3 = NearbyFeedPosterView.this;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        ImageView imageView2 = imageView;
                                        final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                if (NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.appId == 2) {
                                                    afVar2.size(602.0f, 848.0f);
                                                } else {
                                                    afVar2.m140flex(1.0f);
                                                }
                                                NearbyProKtxKt.srcWithIndexNode(afVar2, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.feedImage);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NearbyFeedPosterView nearbyFeedPosterView5 = NearbyFeedPosterView.this;
                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.3.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageEvent imageEvent) {
                                                final NearbyFeedPosterView nearbyFeedPosterView6 = NearbyFeedPosterView.this;
                                                imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.3.2.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                                        NearbyFeedPosterView.access$onImageLoaded(NearbyFeedPosterView.this, "feedImage");
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
                                if (NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.feedFallbackImage.length() > 0) {
                                    NearbyFeedPosterView.addImageLoading$default(NearbyFeedPosterView.this, "feedFallbackImage");
                                    final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.3.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            ImageView imageView2 = imageView;
                                            final NearbyFeedPosterView nearbyFeedPosterView5 = NearbyFeedPosterView.this;
                                            imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.3.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    afVar2.m140flex(1.0f);
                                                    b.a.b(afVar2, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.feedFallbackImage, false, 2, null);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NearbyFeedPosterView nearbyFeedPosterView6 = NearbyFeedPosterView.this;
                                            imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.3.3.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageEvent imageEvent) {
                                                    final NearbyFeedPosterView nearbyFeedPosterView7 = NearbyFeedPosterView.this;
                                                    imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.3.3.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                                            NearbyFeedPosterView.access$onImageLoaded(NearbyFeedPosterView.this, "feedFallbackImage");
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
                                    NearbyFeedPosterView.addImageLoading$default(NearbyFeedPosterView.this, "feedFallbackImage2");
                                    final NearbyFeedPosterView nearbyFeedPosterView5 = NearbyFeedPosterView.this;
                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.3.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            ImageView imageView2 = imageView;
                                            final NearbyFeedPosterView nearbyFeedPosterView6 = NearbyFeedPosterView.this;
                                            imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.3.4.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    afVar2.m140flex(1.0f);
                                                    b.a.b(afVar2, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.imageFallbackUrl, false, 2, null);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NearbyFeedPosterView nearbyFeedPosterView7 = NearbyFeedPosterView.this;
                                            imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.3.4.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageEvent imageEvent) {
                                                    final NearbyFeedPosterView nearbyFeedPosterView8 = NearbyFeedPosterView.this;
                                                    imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.3.4.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                                            NearbyFeedPosterView.access$onImageLoaded(NearbyFeedPosterView.this, "feedFallbackImage2");
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
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    final NearbyFeedPosterView nearbyFeedPosterView3 = NearbyFeedPosterView.this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$normalBody$1.4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.4.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    Attr.absolutePosition$default(tVar2, 644.8f, 21.0f, 0.0f, 0.0f, 12, null);
                                    tVar2.size(588.0f, 52.0f);
                                    tVar2.flexDirectionRow();
                                    return Unit.INSTANCE;
                                }
                            });
                            final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.4.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    final NearbyFeedPosterView nearbyFeedPosterView5 = NearbyFeedPosterView.this;
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.4.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            ce ceVar2 = ceVar;
                                            ceVar2.text(NearbyFeedPosterView.access$getTitle(NearbyFeedPosterView.this));
                                            ceVar2.color(h.INSTANCE.o(NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.titleFontColor));
                                            ce.fontSize$default(ceVar2, 44.0f, null, 2, null);
                                            ceVar2.mo153width(588.0f);
                                            ceVar2.lines(1);
                                            ceVar2.fontWeight500();
                                            ceVar2.textAlignLeft();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$normalBody$1.5
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.5.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    Attr.absolutePosition$default(tVar2, 711.0f, 21.0f, 0.0f, 0.0f, 12, null);
                                    tVar2.size(490.0f, 28.0f);
                                    tVar2.flexDirectionRow();
                                    tVar2.alignItemsCenter();
                                    tVar2.overflow(true);
                                    return Unit.INSTANCE;
                                }
                            });
                            if (NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.userAvatar.length() > 0) {
                                final NearbyFeedPosterView nearbyFeedPosterView5 = NearbyFeedPosterView.this;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.5.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NearbyFeedPosterView nearbyFeedPosterView6 = NearbyFeedPosterView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.5.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(24.6f, 24.6f);
                                                afVar2.borderRadius(14.0f);
                                                b.a.b(afVar2, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.userAvatar, false, 2, null);
                                                afVar2.marginRight(7.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            final NearbyFeedPosterView nearbyFeedPosterView6 = NearbyFeedPosterView.this;
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.5.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    final NearbyFeedPosterView nearbyFeedPosterView7 = NearbyFeedPosterView.this;
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.5.3.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            ce ceVar2 = ceVar;
                                            ceVar2.text(NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.userNickname);
                                            ceVar2.color(h.INSTANCE.o(NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.nicknameFontColor));
                                            ceVar2.m144maxWidth(180.0f);
                                            ceVar2.lines(1);
                                            ce.fontSize$default(ceVar2, 20.0f, null, 2, null);
                                            ceVar2.fontWeight400();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            if (NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.appId == 2) {
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.5.4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.5.4.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u00b7");
                                                ceVar2.marginLeft(10.0f);
                                                ceVar2.marginRight(10.0f);
                                                ceVar2.fontWeight400();
                                                ceVar2.color(new h(9474196L, 1.0f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFeedPosterView nearbyFeedPosterView7 = NearbyFeedPosterView.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.5.5
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        final String str;
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.5.5.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                tVar.m140flex(1.0f);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        NearbyFeedPosterData.AddressInfo addressInfo = NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.feedAddress;
                                        if (addressInfo != null) {
                                            String str2 = addressInfo.city;
                                            String str3 = addressInfo.district;
                                            String str4 = addressInfo.displayName;
                                            if (!Intrinsics.areEqual(str2, str4) && !Intrinsics.areEqual(str3, str4)) {
                                                str = str2 + str3 + Typography.middleDot + str4;
                                            } else {
                                                str = AgreementConsentViewKt$$ExternalSyntheticOutline0.m(str2, str3);
                                            }
                                        } else {
                                            str = "";
                                        }
                                        if (str.length() > 0) {
                                            final NearbyFeedPosterView nearbyFeedPosterView8 = NearbyFeedPosterView.this;
                                            cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.5.5.2
                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(TextView textView) {
                                                    final String str5 = str;
                                                    final NearbyFeedPosterView nearbyFeedPosterView9 = nearbyFeedPosterView8;
                                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.5.5.2.1
                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ce ceVar) {
                                                            ce ceVar2 = ceVar;
                                                            ceVar2.text(str5);
                                                            ceVar2.color(h.INSTANCE.o(NearbyFeedPosterView.access$getAttr(nearbyFeedPosterView9).config.locTagFontColor));
                                                            ce.fontSize$default(ceVar2, 20.0f, null, 2, null);
                                                            ceVar2.m140flex(1.0f);
                                                            ceVar2.lines(1);
                                                            ceVar2.fontWeight400();
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
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    NearbyFeedPosterView.addImageLoading$default(NearbyFeedPosterView.this, "qrCodeDefault");
                    final NearbyFeedPosterView nearbyFeedPosterView5 = NearbyFeedPosterView.this;
                    ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$normalBody$1.6
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ImageView imageView) {
                            ImageView imageView2 = imageView;
                            final NearbyFeedPosterView nearbyFeedPosterView6 = NearbyFeedPosterView.this;
                            imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.6.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(af afVar) {
                                    af afVar2 = afVar;
                                    b.a.b(afVar2, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.staticQRCodeUrl, false, 2, null);
                                    afVar2.size(78.6f);
                                    afVar2.positionAbsolute();
                                    afVar2.m149right(30.6f);
                                    afVar2.m138bottom(54.6f);
                                    NearbyFeedPosterView nearbyFeedPosterView7 = NearbyFeedPosterView.this;
                                    afVar2.m147opacity(((Boolean) nearbyFeedPosterView7.qrCodeReady$delegate.getValue(nearbyFeedPosterView7, NearbyFeedPosterView.$$delegatedProperties[1])).booleanValue() ? 0.0f : 1.0f);
                                    return Unit.INSTANCE;
                                }
                            });
                            final NearbyFeedPosterView nearbyFeedPosterView7 = NearbyFeedPosterView.this;
                            imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.6.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageEvent imageEvent) {
                                    final NearbyFeedPosterView nearbyFeedPosterView8 = NearbyFeedPosterView.this;
                                    imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.6.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                            NearbyFeedPosterView.access$onImageLoaded(NearbyFeedPosterView.this, "qrCodeDefault");
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    final NearbyFeedPosterView nearbyFeedPosterView6 = NearbyFeedPosterView.this;
                    Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$normalBody$1.7
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            NearbyFeedPosterView nearbyFeedPosterView7 = NearbyFeedPosterView.this;
                            return Boolean.valueOf(((Boolean) nearbyFeedPosterView7.showQRCode$delegate.getValue(nearbyFeedPosterView7, NearbyFeedPosterView.$$delegatedProperties[0])).booleanValue());
                        }
                    };
                    final NearbyFeedPosterView nearbyFeedPosterView7 = NearbyFeedPosterView.this;
                    ConditionViewKt.c(viewContainer2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$normalBody$1.8
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ConditionView conditionView) {
                            final NearbyFeedPosterView nearbyFeedPosterView8 = NearbyFeedPosterView.this;
                            conditionView.addChild(new QRCodeView(), new Function1<QRCodeView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.8.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(QRCodeView qRCodeView) {
                                    QRCodeView qRCodeView2 = qRCodeView;
                                    final NearbyFeedPosterView nearbyFeedPosterView9 = NearbyFeedPosterView.this;
                                    qRCodeView2.attr(new Function1<n01.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.8.1.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(n01.b bVar) {
                                            n01.b bVar2 = bVar;
                                            bVar2.i(NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.getWxShareH5Url(NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.appId, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.userId, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.feedId), 78.6f);
                                            bVar2.positionAbsolute();
                                            bVar2.m149right(30.6f);
                                            bVar2.m138bottom(54.6f);
                                            NearbyFeedPosterView nearbyFeedPosterView10 = NearbyFeedPosterView.this;
                                            bVar2.m147opacity(((Boolean) nearbyFeedPosterView10.qrCodeReady$delegate.getValue(nearbyFeedPosterView10, NearbyFeedPosterView.$$delegatedProperties[1])).booleanValue() ? 1.0f : 0.0f);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NearbyFeedPosterView nearbyFeedPosterView10 = NearbyFeedPosterView.this;
                                    qRCodeView2.event(new Function1<n01.c, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.8.1.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(n01.c cVar) {
                                            n01.c cVar2 = cVar;
                                            final NearbyFeedPosterView nearbyFeedPosterView11 = NearbyFeedPosterView.this;
                                            FrameEventKt.f(cVar2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.8.1.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Object obj) {
                                                    NearbyFeedPosterView nearbyFeedPosterView12 = NearbyFeedPosterView.this;
                                                    e eVar = new e();
                                                    eVar.w("state", true);
                                                    Unit unit = Unit.INSTANCE;
                                                    nearbyFeedPosterView12.onFireEvent("setQRCodeState", eVar);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NearbyFeedPosterView nearbyFeedPosterView12 = NearbyFeedPosterView.this;
                                            cVar2.f417921a = new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.8.1.2.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(Object obj) {
                                                    NearbyFeedPosterView.access$onImageLoaded(NearbyFeedPosterView.this, CommonConstant.KEY_QR_CODE);
                                                    int i3 = k.a(com.tencent.kuikly.core.manager.c.f117352a) ? 10 : 500;
                                                    final NearbyFeedPosterView nearbyFeedPosterView13 = NearbyFeedPosterView.this;
                                                    TimerKt.d(i3, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.normalBody.1.8.1.2.2.1
                                                        {
                                                            super(0);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function0
                                                        public final Unit invoke() {
                                                            NearbyFeedPosterView nearbyFeedPosterView14 = NearbyFeedPosterView.this;
                                                            e eVar = new e();
                                                            eVar.w("state", false);
                                                            Unit unit = Unit.INSTANCE;
                                                            nearbyFeedPosterView14.onFireEvent("setQRCodeState", eVar);
                                                            NearbyFeedPosterView nearbyFeedPosterView15 = NearbyFeedPosterView.this;
                                                            nearbyFeedPosterView15.qrCodeReady$delegate.setValue(nearbyFeedPosterView15, NearbyFeedPosterView.$$delegatedProperties[1], Boolean.TRUE);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
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
            };
        }
        if (ordinal != 1) {
            if (ordinal == 2) {
                return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$wxArkBody$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                        ViewContainer<?, ?> viewContainer2 = viewContainer;
                        viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$wxArkBody$1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(m mVar) {
                                m mVar2 = mVar;
                                mVar2.size(46.0f, 46.0f);
                                mVar2.mo113backgroundColor(h.INSTANCE.m());
                                return Unit.INSTANCE;
                            }
                        });
                        NearbyFeedPosterView.addImageLoading$default(NearbyFeedPosterView.this, "wxArkTextBg");
                        final NearbyFeedPosterView nearbyFeedPosterView = NearbyFeedPosterView.this;
                        ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$wxArkBody$1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                ImageView imageView2 = imageView;
                                final NearbyFeedPosterView nearbyFeedPosterView2 = NearbyFeedPosterView.this;
                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.wxArkBody.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        af afVar2 = afVar;
                                        Attr.absolutePosition$default(afVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                        afVar2.size(46.0f, 46.0f);
                                        b.a.b(afVar2, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.wxShareTextBgUrl, false, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyFeedPosterView nearbyFeedPosterView3 = NearbyFeedPosterView.this;
                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.wxArkBody.1.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageEvent imageEvent) {
                                        final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                                        imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.wxArkBody.1.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                                NearbyFeedPosterView.access$onImageLoaded(NearbyFeedPosterView.this, "wxArkTextBg");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        if (NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.appId == 2) {
                            final NearbyFeedPosterView nearbyFeedPosterView2 = NearbyFeedPosterView.this;
                            w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$wxArkBody$1.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(v vVar) {
                                    v vVar2 = vVar;
                                    vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.wxArkBody.1.3.1
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(t tVar) {
                                            t tVar2 = tVar;
                                            Attr.absolutePosition$default(tVar2, 4.0f, 1.0f, 0.0f, 0.0f, 12, null);
                                            tVar2.size(43.0f, 26.0f);
                                            tVar2.flexDirectionRow();
                                            tVar2.allCenter();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NearbyFeedPosterView nearbyFeedPosterView3 = NearbyFeedPosterView.this;
                                    cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.wxArkBody.1.3.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(TextView textView) {
                                            final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                                            textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.wxArkBody.1.3.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ce ceVar) {
                                                    ce ceVar2 = ceVar;
                                                    ceVar2.text(NearbyFeedPosterView.access$getTitle(NearbyFeedPosterView.this));
                                                    ceVar2.color(h.INSTANCE.o(NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.wxShareTextFontColor));
                                                    ceVar2.lines(2);
                                                    ceVar2.mo153width(43.0f);
                                                    ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                    ceVar2.lineHeight(13.0f);
                                                    ceVar2.fontWeight500();
                                                    ceVar2.textAlignCenter();
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
                };
            }
            throw new NoWhenBranchMatchedException();
        }
        if (((NearbyFeedPosterViewAttr) getAttr()).data.appId == 2) {
            return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$qqArkBody$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                    ViewContainer<?, ?> viewContainer2 = viewContainer;
                    viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$qqArkBody$1.1
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(m mVar) {
                            m mVar2 = mVar;
                            mVar2.size(239.0f, 159.0f);
                            mVar2.borderRadius(4.0f);
                            mVar2.mo113backgroundColor(h.INSTANCE.m());
                            return Unit.INSTANCE;
                        }
                    });
                    NearbyFeedPosterView.addImageLoading$default(NearbyFeedPosterView.this, "arkFrameUrl");
                    final NearbyFeedPosterView nearbyFeedPosterView = NearbyFeedPosterView.this;
                    ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$qqArkBody$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ImageView imageView) {
                            ImageView imageView2 = imageView;
                            final NearbyFeedPosterView nearbyFeedPosterView2 = NearbyFeedPosterView.this;
                            imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.2.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(af afVar) {
                                    af afVar2 = afVar;
                                    Attr.absolutePosition$default(afVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                    afVar2.size(239.0f, 159.0f);
                                    afVar2.p();
                                    b.a.b(afVar2, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.arkFrameUrl, false, 2, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            final NearbyFeedPosterView nearbyFeedPosterView3 = NearbyFeedPosterView.this;
                            imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.2.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageEvent imageEvent) {
                                    final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                                    imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.2.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                            NearbyFeedPosterView.access$onImageLoaded(NearbyFeedPosterView.this, "arkFrameUrl");
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    final NearbyFeedPosterView nearbyFeedPosterView2 = NearbyFeedPosterView.this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$qqArkBody$1.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.3.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    Attr.absolutePosition$default(tVar2, 11.57f, 123.0f, 0.0f, 0.0f, 12, null);
                                    tVar2.size(100.0f, 100.0f);
                                    d.a.a(tVar2, new com.tencent.kuikly.core.base.t(6.0f, 0.0f, 0.0f, 6, null), null, null, new a(0.0f, 0.0f), null, 22, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            if (NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.feedImage != null) {
                                final NearbyFeedPosterView nearbyFeedPosterView3 = NearbyFeedPosterView.this;
                                ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.m140flex(1.0f);
                                                afVar2.borderRadius(0.58f);
                                                NearbyProKtxKt.srcWithIndexNode(afVar2, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.feedImage);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                            } else {
                                if (NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.feedFallbackImage.length() > 0) {
                                    NearbyFeedPosterView.addImageLoading$default(NearbyFeedPosterView.this, "feedFallbackImage");
                                    final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.3.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            ImageView imageView2 = imageView;
                                            final NearbyFeedPosterView nearbyFeedPosterView5 = NearbyFeedPosterView.this;
                                            imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.3.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    afVar2.m140flex(1.0f);
                                                    afVar2.borderRadius(0.58f);
                                                    b.a.b(afVar2, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.feedFallbackImage, false, 2, null);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NearbyFeedPosterView nearbyFeedPosterView6 = NearbyFeedPosterView.this;
                                            imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.3.3.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageEvent imageEvent) {
                                                    final NearbyFeedPosterView nearbyFeedPosterView7 = NearbyFeedPosterView.this;
                                                    imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.3.3.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                                            NearbyFeedPosterView.access$onImageLoaded(NearbyFeedPosterView.this, "feedFallbackImage");
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
                                    NearbyFeedPosterView.addImageLoading$default(NearbyFeedPosterView.this, "feedFallbackImage2");
                                    final NearbyFeedPosterView nearbyFeedPosterView5 = NearbyFeedPosterView.this;
                                    ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.3.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageView imageView) {
                                            ImageView imageView2 = imageView;
                                            final NearbyFeedPosterView nearbyFeedPosterView6 = NearbyFeedPosterView.this;
                                            imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.3.4.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(af afVar) {
                                                    af afVar2 = afVar;
                                                    afVar2.m140flex(1.0f);
                                                    afVar2.borderRadius(0.58f);
                                                    b.a.b(afVar2, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.imageFallbackUrl, false, 2, null);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final NearbyFeedPosterView nearbyFeedPosterView7 = NearbyFeedPosterView.this;
                                            imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.3.4.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageEvent imageEvent) {
                                                    final NearbyFeedPosterView nearbyFeedPosterView8 = NearbyFeedPosterView.this;
                                                    imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.3.4.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                                            NearbyFeedPosterView.access$onImageLoaded(NearbyFeedPosterView.this, "feedFallbackImage2");
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
                            }
                            return Unit.INSTANCE;
                        }
                    });
                    final NearbyFeedPosterView nearbyFeedPosterView3 = NearbyFeedPosterView.this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$qqArkBody$1.4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.4.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    Attr.absolutePosition$default(tVar2, 118.03f, 113.11f, 0.0f, 0.0f, 12, null);
                                    tVar2.size(97.6f, 12.18f);
                                    tVar2.flexDirectionRow();
                                    tVar2.allCenter();
                                    d.a.a(tVar2, new com.tencent.kuikly.core.base.t(6.0f, 0.0f, 0.0f, 6, null), null, null, new a(0.0f, 0.0f), null, 22, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.4.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    final NearbyFeedPosterView nearbyFeedPosterView5 = NearbyFeedPosterView.this;
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.4.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            ce ceVar2 = ceVar;
                                            ceVar2.text(NearbyFeedPosterView.access$getTitle(NearbyFeedPosterView.this));
                                            ceVar2.color(h.INSTANCE.o(NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.arkTitleFontColor));
                                            ceVar2.lines(1);
                                            ceVar2.m140flex(1.0f);
                                            ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                            ceVar2.fontWeight600();
                                            ceVar2.textAlignCenter();
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                    w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$qqArkBody$1.5
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(v vVar) {
                            v vVar2 = vVar;
                            vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.5.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(t tVar) {
                                    t tVar2 = tVar;
                                    Attr.absolutePosition$default(tVar2, 106.0f, 9.0f, 0.0f, 0.0f, 12, null);
                                    tVar2.size(84.0f, 40.0f);
                                    tVar2.flexDirectionRow();
                                    tVar2.justifyContentCenter();
                                    return Unit.INSTANCE;
                                }
                            });
                            final NearbyFeedPosterView nearbyFeedPosterView5 = NearbyFeedPosterView.this;
                            cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.5.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TextView textView) {
                                    final NearbyFeedPosterView nearbyFeedPosterView6 = NearbyFeedPosterView.this;
                                    textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqArkBody.1.5.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ce ceVar) {
                                            String str;
                                            ce ceVar2 = ceVar;
                                            NearbyFeedPosterData.AddressInfo addressInfo = NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.feedAddress;
                                            if (addressInfo == null || (str = addressInfo.city) == null) {
                                                str = "";
                                            }
                                            ceVar2.text(str);
                                            ceVar2.color(h.INSTANCE.o(NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.arkLocFontColor));
                                            ceVar2.lines(2);
                                            ceVar2.lineHeight(19.0f);
                                            ceVar2.mo153width(84.0f);
                                            ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                            ceVar2.fontWeight600();
                                            ceVar2.textAlignCenter();
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
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$qqqArkBodyJieban$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$qqqArkBodyJieban$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.size(239.0f, 159.0f);
                        mVar2.borderRadius(4.0f);
                        mVar2.mo113backgroundColor(h.INSTANCE.m());
                        return Unit.INSTANCE;
                    }
                });
                if (NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.feedFallbackImage.length() > 0) {
                    NearbyFeedPosterView.addImageLoading$default(NearbyFeedPosterView.this, "feedFallbackImage");
                    final NearbyFeedPosterView nearbyFeedPosterView = NearbyFeedPosterView.this;
                    ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$qqqArkBodyJieban$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ImageView imageView) {
                            ImageView imageView2 = imageView;
                            final NearbyFeedPosterView nearbyFeedPosterView2 = NearbyFeedPosterView.this;
                            imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.2.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(af afVar) {
                                    af afVar2 = afVar;
                                    afVar2.m140flex(1.0f);
                                    afVar2.borderRadius(0.58f);
                                    afVar2.h(2.5f);
                                    b.a.b(afVar2, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.feedFallbackImage, false, 2, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            final NearbyFeedPosterView nearbyFeedPosterView3 = NearbyFeedPosterView.this;
                            imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.2.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageEvent imageEvent) {
                                    final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                                    imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.2.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                            NearbyFeedPosterView.access$onImageLoaded(NearbyFeedPosterView.this, "feedFallbackImage");
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$qqqArkBodyJieban$1.3
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ImageView imageView) {
                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.3.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(af afVar) {
                                    af afVar2 = afVar;
                                    Attr.absolutePosition$default(afVar2, -10.0f, 85.0f, 0.0f, 0.0f, 12, null);
                                    afVar2.size(165.0f, 188.1f);
                                    b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_JQB8x8zMQID.png", false, 2, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                    ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$qqqArkBodyJieban$1.4
                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ImageView imageView) {
                            imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.4.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(af afVar) {
                                    af afVar2 = afVar;
                                    Attr.absolutePosition$default(afVar2, 45.0f, 23.0f, 0.0f, 0.0f, 12, null);
                                    afVar2.size(69.0f, 71.0f);
                                    b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_q0BYlJAxF55.png", false, 2, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    NearbyFeedPosterView.addImageLoading$default(NearbyFeedPosterView.this, "feedFallbackImage2");
                    final NearbyFeedPosterView nearbyFeedPosterView2 = NearbyFeedPosterView.this;
                    ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$qqqArkBodyJieban$1.5
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(ImageView imageView) {
                            ImageView imageView2 = imageView;
                            final NearbyFeedPosterView nearbyFeedPosterView3 = NearbyFeedPosterView.this;
                            imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.5.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(af afVar) {
                                    af afVar2 = afVar;
                                    afVar2.m140flex(1.0f);
                                    afVar2.borderRadius(0.58f);
                                    b.a.b(afVar2, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.arkFrameUrl, false, 2, null);
                                    return Unit.INSTANCE;
                                }
                            });
                            final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                            imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.5.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageEvent imageEvent) {
                                    final NearbyFeedPosterView nearbyFeedPosterView5 = NearbyFeedPosterView.this;
                                    imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.5.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                            NearbyFeedPosterView.access$onImageLoaded(NearbyFeedPosterView.this, "feedFallbackImage2");
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
                final NearbyFeedPosterView nearbyFeedPosterView3 = NearbyFeedPosterView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$qqqArkBodyJieban$1.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.6.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 15.57f, 123.0f, 0.0f, 0.0f, 12, null);
                                tVar2.size(96.0f, 96.0f);
                                d.a.a(tVar2, new com.tencent.kuikly.core.base.t(2.5f, 0.0f, 0.0f, 6, null), null, null, new a(0.0f, 0.0f), null, 22, null);
                                tVar2.allCenter();
                                return Unit.INSTANCE;
                            }
                        });
                        if (NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.feedFallbackImage.length() > 0) {
                            NearbyFeedPosterView.addImageLoading$default(NearbyFeedPosterView.this, "feedFallbackImage");
                            final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.6.2
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageView imageView) {
                                    ImageView imageView2 = imageView;
                                    final NearbyFeedPosterView nearbyFeedPosterView5 = NearbyFeedPosterView.this;
                                    imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.6.2.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(af afVar) {
                                            af afVar2 = afVar;
                                            afVar2.absolutePositionAllZero();
                                            afVar2.borderRadius(0.58f);
                                            b.a.b(afVar2, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).data.feedFallbackImage, false, 2, null);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NearbyFeedPosterView nearbyFeedPosterView6 = NearbyFeedPosterView.this;
                                    imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.6.2.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageEvent imageEvent) {
                                            final NearbyFeedPosterView nearbyFeedPosterView7 = NearbyFeedPosterView.this;
                                            imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.6.2.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                                    NearbyFeedPosterView.access$onImageLoaded(NearbyFeedPosterView.this, "feedFallbackImage");
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
                            NearbyFeedPosterView.addImageLoading$default(NearbyFeedPosterView.this, "feedFallbackImage2");
                            final NearbyFeedPosterView nearbyFeedPosterView5 = NearbyFeedPosterView.this;
                            ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.6.3
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(ImageView imageView) {
                                    ImageView imageView2 = imageView;
                                    final NearbyFeedPosterView nearbyFeedPosterView6 = NearbyFeedPosterView.this;
                                    imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.6.3.1
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(af afVar) {
                                            af afVar2 = afVar;
                                            afVar2.absolutePositionAllZero();
                                            afVar2.borderRadius(0.58f);
                                            afVar2.p();
                                            b.a.b(afVar2, NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.arkImageFallbackUrl, false, 2, null);
                                            return Unit.INSTANCE;
                                        }
                                    });
                                    final NearbyFeedPosterView nearbyFeedPosterView7 = NearbyFeedPosterView.this;
                                    imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.6.3.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(ImageEvent imageEvent) {
                                            final NearbyFeedPosterView nearbyFeedPosterView8 = NearbyFeedPosterView.this;
                                            imageEvent.j(new Function1<LoadSuccessParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.6.3.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(LoadSuccessParams loadSuccessParams) {
                                                    NearbyFeedPosterView.access$onImageLoaded(NearbyFeedPosterView.this, "feedFallbackImage2");
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
                final NearbyFeedPosterView nearbyFeedPosterView4 = NearbyFeedPosterView.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView$qqqArkBodyJieban$1.7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.7.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 118.03f, 117.11f, 0.0f, 0.0f, 12, null);
                                tVar2.size(96.0f, 12.18f);
                                tVar2.flexDirectionRow();
                                tVar2.allCenter();
                                d.a.a(tVar2, new com.tencent.kuikly.core.base.t(2.5f, 0.0f, 0.0f, 6, null), null, null, new a(0.0f, 0.0f), null, 22, null);
                                return Unit.INSTANCE;
                            }
                        });
                        final NearbyFeedPosterView nearbyFeedPosterView5 = NearbyFeedPosterView.this;
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.7.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                final NearbyFeedPosterView nearbyFeedPosterView6 = NearbyFeedPosterView.this;
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.common_share.posterView.NearbyFeedPosterView.qqqArkBodyJieban.1.7.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text(NearbyFeedPosterView.access$getTitle(NearbyFeedPosterView.this));
                                        ceVar2.color(h.INSTANCE.o(NearbyFeedPosterView.access$getAttr(NearbyFeedPosterView.this).config.arkTitleFontColor));
                                        ceVar2.lines(1);
                                        ceVar2.m140flex(1.0f);
                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                        ceVar2.fontWeight600();
                                        ceVar2.textAlignCenter();
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
        return new NearbyFeedPosterViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NearbyFeedPosterViewEvent();
    }
}
