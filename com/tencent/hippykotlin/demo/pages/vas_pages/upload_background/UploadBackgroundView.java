package com.tencent.hippykotlin.demo.pages.vas_pages.upload_background;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.prompt_converation.view.ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQUtils;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheDiskLru$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.vas_base.VasModule;
import com.tencent.hippykotlin.demo.pages.vas_base.native_api.UpdateSystem;
import com.tencent.hippykotlin.demo.pages.vas_base.views.LottieAnimationAttr;
import com.tencent.hippykotlin.demo.pages.vas_base.views.LottieAttr;
import com.tencent.hippykotlin.demo.pages.vas_base.views.VasLottieAnimationView;
import com.tencent.hippykotlin.demo.pages.vas_base.views.VasLottieAnimationView$playAnimation$1;
import com.tencent.hippykotlin.demo.pages.vas_base.views.VasLottieView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.e;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.TouchParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.reactive.ReactiveObserver;
import com.tencent.kuikly.core.views.CanvasView;
import com.tencent.kuikly.core.views.CanvasViewKt;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.LoadResolutionParams;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.p;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tenpay.proxy.dlg.location.QbAddrData;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__IndentKt;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class UploadBackgroundView extends ComposeView<UploadBackgroundAttr, l> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UploadBackgroundView.class, "topPos", "getTopPos()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UploadBackgroundView.class, "leftPos", "getLeftPos()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UploadBackgroundView.class, "bottomPos", "getBottomPos()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UploadBackgroundView.class, "rightPos", "getRightPos()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UploadBackgroundView.class, "topBorder", "getTopBorder()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UploadBackgroundView.class, "bottomBorder", "getBottomBorder()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UploadBackgroundView.class, "leftBorder", "getLeftBorder()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UploadBackgroundView.class, "rightBorder", "getRightBorder()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(UploadBackgroundView.class, "opacity", "getOpacity()F", 0)};
    public static final Companion Companion = new Companion();
    public static final h MOVE_LINE_COLOR = new h(4008701935L);
    public final ReadWriteProperty bottomBorder$delegate;
    public final ReadWriteProperty bottomPos$delegate;
    public int chooseObject;
    public int counts;
    public float imageHeight;
    public final String imagePath;
    public float imagePercent = 1.0f;
    public float imageWidth;
    public final ReadWriteProperty leftBorder$delegate;
    public final ReadWriteProperty leftPos$delegate;
    public DeclarativeBaseView<?, ?> lottieView;
    public final ReadWriteProperty opacity$delegate;
    public float originBottomPos;
    public float originLeftPos;
    public float originRightPos;
    public float originTopPos;
    public final UpLoadBackgroundPage page;
    public int previousCounts;
    public float rememberBottomPos;
    public float rememberLeftPos;
    public float rememberRightPos;
    public float rememberTopPos;
    public final ReadWriteProperty rightBorder$delegate;
    public final ReadWriteProperty rightPos$delegate;
    public float startHeight;
    public float startWidth;
    public float startX;
    public float startX1;
    public float startX2;
    public float startY;
    public float startY1;
    public float startY2;
    public final ReadWriteProperty topBorder$delegate;
    public final ReadWriteProperty topPos$delegate;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
    }

    public UploadBackgroundView(UpLoadBackgroundPage upLoadBackgroundPage, String str) {
        this.page = upLoadBackgroundPage;
        this.imagePath = str;
        Float valueOf = Float.valueOf(0.0f);
        this.topPos$delegate = c.a(valueOf);
        this.leftPos$delegate = c.a(valueOf);
        this.bottomPos$delegate = c.a(valueOf);
        this.rightPos$delegate = c.a(valueOf);
        this.topBorder$delegate = c.a(Float.valueOf(60.0f));
        this.bottomBorder$delegate = c.a(Float.valueOf(40.0f));
        Float valueOf2 = Float.valueOf(30.0f);
        this.leftBorder$delegate = c.a(valueOf2);
        this.rightBorder$delegate = c.a(valueOf2);
        this.opacity$delegate = c.a(Float.valueOf(1.0f));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ UploadBackgroundAttr access$getAttr(UploadBackgroundView uploadBackgroundView) {
        return (UploadBackgroundAttr) uploadBackgroundView.getAttr();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final UpLoadBackgroundPage upLoadBackgroundPage = this.page;
        final String str = this.imagePath;
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.mo113backgroundColor(h.INSTANCE.b());
                        mVar2.absolutePositionAllZero();
                        mVar2.m147opacity(1.0f);
                        return Unit.INSTANCE;
                    }
                });
                final String str2 = str;
                final UploadBackgroundView uploadBackgroundView = this;
                final UpLoadBackgroundPage upLoadBackgroundPage2 = upLoadBackgroundPage;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView$body$1.2

                    /* compiled from: P */
                    /* renamed from: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView$body$1$2$6, reason: invalid class name */
                    /* loaded from: classes33.dex */
                    public final class AnonymousClass6 extends Lambda implements Function1<u, Unit> {
                        public final /* synthetic */ UploadBackgroundView $ctx;
                        public final /* synthetic */ UpLoadBackgroundPage $page;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public AnonymousClass6(UploadBackgroundView uploadBackgroundView, UpLoadBackgroundPage upLoadBackgroundPage) {
                            super(1);
                            this.$ctx = uploadBackgroundView;
                            this.$page = upLoadBackgroundPage;
                        }

                        public static final void access$invoke$commonEnd(UpLoadBackgroundPage upLoadBackgroundPage, UploadBackgroundView uploadBackgroundView) {
                            float floatValue;
                            float floatValue2;
                            float floatValue3;
                            float floatValue4;
                            float floatValue5;
                            float floatValue6;
                            float floatValue7;
                            float floatValue8;
                            float floatValue9;
                            float floatValue10;
                            float floatValue11;
                            float floatValue12;
                            float floatValue13;
                            float floatValue14;
                            float floatValue15;
                            float floatValue16;
                            float f16 = upLoadBackgroundPage.imageWeightOrigin;
                            floatValue = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                            floatValue2 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                            float f17 = (floatValue - floatValue2) * f16;
                            float v3 = uploadBackgroundView.getFlexNode().v();
                            floatValue3 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                            float f18 = v3 - floatValue3;
                            floatValue4 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                            upLoadBackgroundPage.subImageLeft = f17 / (f18 - floatValue4);
                            float f19 = upLoadBackgroundPage.imageWeightOrigin;
                            floatValue5 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                            floatValue6 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                            float f26 = (floatValue5 - floatValue6) * f19;
                            float v16 = uploadBackgroundView.getFlexNode().v();
                            floatValue7 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                            float f27 = v16 - floatValue7;
                            floatValue8 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                            upLoadBackgroundPage.subImageRight = f26 / (f27 - floatValue8);
                            float f28 = upLoadBackgroundPage.imageHeightOrigin;
                            floatValue9 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                            floatValue10 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                            float f29 = (floatValue9 - floatValue10) * f28;
                            float t16 = uploadBackgroundView.getFlexNode().t();
                            floatValue11 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                            float f36 = t16 - floatValue11;
                            floatValue12 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                            upLoadBackgroundPage.subImageBottom = f29 / (f36 - floatValue12);
                            float f37 = upLoadBackgroundPage.imageHeightOrigin;
                            floatValue13 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                            floatValue14 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                            float f38 = (floatValue13 - floatValue14) * f37;
                            float t17 = uploadBackgroundView.getFlexNode().t();
                            floatValue15 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                            floatValue16 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                            upLoadBackgroundPage.subImageTop = f38 / ((t17 - floatValue15) - floatValue16);
                            if (upLoadBackgroundPage.subImageLeft < 0.0f) {
                                upLoadBackgroundPage.subImageLeft = 0.0f;
                            }
                            if (upLoadBackgroundPage.subImageRight < 0.0f) {
                                upLoadBackgroundPage.subImageRight = 0.0f;
                            }
                        }

                        public static final void access$invoke$commonStart(UploadBackgroundView uploadBackgroundView, float f16, float f17) {
                            float floatValue;
                            float floatValue2;
                            float floatValue3;
                            float floatValue4;
                            float floatValue5;
                            float floatValue6;
                            float floatValue7;
                            float floatValue8;
                            float floatValue9;
                            float floatValue10;
                            float floatValue11;
                            float floatValue12;
                            float floatValue13;
                            float floatValue14;
                            float floatValue15;
                            float floatValue16;
                            float floatValue17;
                            float floatValue18;
                            float floatValue19;
                            float floatValue20;
                            float floatValue21;
                            float floatValue22;
                            float floatValue23;
                            float floatValue24;
                            float floatValue25;
                            float floatValue26;
                            float floatValue27;
                            float floatValue28;
                            float floatValue29;
                            float floatValue30;
                            float floatValue31;
                            float floatValue32;
                            float floatValue33;
                            float floatValue34;
                            float floatValue35;
                            float floatValue36;
                            uploadBackgroundView.startX = f16;
                            uploadBackgroundView.startY = f17;
                            float t16 = uploadBackgroundView.getFlexNode().t();
                            floatValue = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                            float f18 = t16 - floatValue;
                            floatValue2 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                            uploadBackgroundView.startHeight = f18 - floatValue2;
                            float v3 = uploadBackgroundView.getFlexNode().v();
                            floatValue3 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                            float f19 = v3 - floatValue3;
                            floatValue4 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                            uploadBackgroundView.startWidth = f19 - floatValue4;
                            uploadBackgroundView.opacity$delegate.setValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[8], Float.valueOf(0.2f));
                            floatValue5 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                            if (f16 - floatValue5 > -10.0f) {
                                floatValue34 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                if (f16 - floatValue34 < 10.0f) {
                                    floatValue35 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    if (f17 - floatValue35 > -10.0f) {
                                        floatValue36 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                        if (f17 - floatValue36 < 10.0f) {
                                            uploadBackgroundView.chooseObject = 6;
                                            return;
                                        }
                                    }
                                }
                            }
                            float v16 = uploadBackgroundView.getFlexNode().v();
                            floatValue6 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                            if (f16 - (v16 - floatValue6) > -10.0f) {
                                float v17 = uploadBackgroundView.getFlexNode().v();
                                floatValue31 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                if (f16 - (v17 - floatValue31) < 10.0f) {
                                    floatValue32 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    if (f17 - floatValue32 > -10.0f) {
                                        floatValue33 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                        if (f17 - floatValue33 < 10.0f) {
                                            uploadBackgroundView.chooseObject = 7;
                                            return;
                                        }
                                    }
                                }
                            }
                            float v18 = uploadBackgroundView.getFlexNode().v();
                            floatValue7 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                            if (f16 - (v18 - floatValue7) > -10.0f) {
                                float v19 = uploadBackgroundView.getFlexNode().v();
                                floatValue28 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                if (f16 - (v19 - floatValue28) < 10.0f) {
                                    float t17 = uploadBackgroundView.getFlexNode().t();
                                    floatValue29 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    if (f17 - (t17 - floatValue29) > -10.0f) {
                                        float t18 = uploadBackgroundView.getFlexNode().t();
                                        floatValue30 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                        if (f17 - (t18 - floatValue30) < 10.0f) {
                                            uploadBackgroundView.chooseObject = 8;
                                            return;
                                        }
                                    }
                                }
                            }
                            float t19 = uploadBackgroundView.getFlexNode().t();
                            floatValue8 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                            if (f17 - (t19 - floatValue8) > -10.0f) {
                                float t26 = uploadBackgroundView.getFlexNode().t();
                                floatValue25 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                if (f17 - (t26 - floatValue25) < 10.0f) {
                                    floatValue26 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    if (f16 - floatValue26 > -10.0f) {
                                        floatValue27 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                        if (f16 - floatValue27 < 10.0f) {
                                            uploadBackgroundView.chooseObject = 9;
                                            return;
                                        }
                                    }
                                }
                            }
                            floatValue9 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                            if (f16 > floatValue9) {
                                float v26 = uploadBackgroundView.getFlexNode().v();
                                floatValue22 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                if (f16 < v26 - floatValue22) {
                                    floatValue23 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    if (f17 > floatValue23 - 10.0f) {
                                        floatValue24 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                        if (f17 < floatValue24 + 10.0f) {
                                            uploadBackgroundView.chooseObject = 1;
                                            return;
                                        }
                                    }
                                }
                            }
                            floatValue10 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                            if (f17 > floatValue10) {
                                float t27 = uploadBackgroundView.getFlexNode().t();
                                floatValue19 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                if (f17 < t27 - floatValue19) {
                                    float v27 = uploadBackgroundView.getFlexNode().v();
                                    floatValue20 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    if (f16 > (v27 - floatValue20) - 10.0f) {
                                        float v28 = uploadBackgroundView.getFlexNode().v();
                                        floatValue21 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                        if (f16 < (v28 - floatValue21) + 10.0f) {
                                            uploadBackgroundView.chooseObject = 2;
                                            return;
                                        }
                                    }
                                }
                            }
                            floatValue11 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                            if (f16 > floatValue11) {
                                float v29 = uploadBackgroundView.getFlexNode().v();
                                floatValue16 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                if (f16 < v29 - floatValue16) {
                                    float t28 = uploadBackgroundView.getFlexNode().t();
                                    floatValue17 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    if (f17 > (t28 - floatValue17) - 10.0f) {
                                        float t29 = uploadBackgroundView.getFlexNode().t();
                                        floatValue18 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                        if (f17 < (t29 - floatValue18) + 10.0f) {
                                            uploadBackgroundView.chooseObject = 3;
                                            return;
                                        }
                                    }
                                }
                            }
                            floatValue12 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                            if (f17 > floatValue12) {
                                float t36 = uploadBackgroundView.getFlexNode().t();
                                floatValue13 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                if (f17 < t36 - floatValue13) {
                                    floatValue14 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    if (f16 > floatValue14 - 10.0f) {
                                        floatValue15 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                        if (f16 < floatValue15 + 10.0f) {
                                            uploadBackgroundView.chooseObject = 4;
                                            return;
                                        }
                                    }
                                }
                            }
                            uploadBackgroundView.chooseObject = 5;
                        }

                        public static final void access$invoke$pickEnd(UploadBackgroundView uploadBackgroundView) {
                            float floatValue;
                            float floatValue2;
                            float floatValue3;
                            float floatValue4;
                            float floatValue5;
                            float floatValue6;
                            float floatValue7;
                            float floatValue8;
                            float floatValue9;
                            float floatValue10;
                            float floatValue11;
                            float floatValue12;
                            float floatValue13;
                            float floatValue14;
                            float floatValue15;
                            float floatValue16;
                            float floatValue17;
                            float floatValue18;
                            float floatValue19;
                            float floatValue20;
                            float floatValue21;
                            float floatValue22;
                            float floatValue23;
                            float floatValue24;
                            float floatValue25;
                            float floatValue26;
                            float floatValue27;
                            float floatValue28;
                            float floatValue29;
                            float floatValue30;
                            float floatValue31;
                            float floatValue32;
                            float floatValue33;
                            float floatValue34;
                            float floatValue35;
                            float floatValue36;
                            float floatValue37;
                            float floatValue38;
                            float floatValue39;
                            float floatValue40;
                            float floatValue41;
                            float floatValue42;
                            float floatValue43;
                            float floatValue44;
                            float floatValue45;
                            float floatValue46;
                            float floatValue47;
                            float floatValue48;
                            float floatValue49;
                            float floatValue50;
                            float floatValue51;
                            float floatValue52;
                            float floatValue53;
                            float floatValue54;
                            float floatValue55;
                            float floatValue56;
                            float floatValue57;
                            float floatValue58;
                            float floatValue59;
                            float floatValue60;
                            float floatValue61;
                            float floatValue62;
                            float floatValue63;
                            float floatValue64;
                            float floatValue65;
                            float floatValue66;
                            float floatValue67;
                            float floatValue68;
                            float floatValue69;
                            float floatValue70;
                            float floatValue71;
                            float floatValue72;
                            float floatValue73;
                            float floatValue74;
                            float floatValue75;
                            float floatValue76;
                            float floatValue77;
                            float floatValue78;
                            float floatValue79;
                            float floatValue80;
                            float floatValue81;
                            float floatValue82;
                            float floatValue83;
                            float floatValue84;
                            float floatValue85;
                            float floatValue86;
                            float floatValue87;
                            float floatValue88;
                            float floatValue89;
                            float floatValue90;
                            float floatValue91;
                            float floatValue92;
                            float floatValue93;
                            float floatValue94;
                            float floatValue95;
                            float floatValue96;
                            float floatValue97;
                            float floatValue98;
                            float floatValue99;
                            float floatValue100;
                            float floatValue101;
                            float floatValue102;
                            float floatValue103;
                            float floatValue104;
                            float floatValue105;
                            float floatValue106;
                            float floatValue107;
                            float floatValue108;
                            float floatValue109;
                            float floatValue110;
                            float floatValue111;
                            float floatValue112;
                            float floatValue113;
                            float floatValue114;
                            float floatValue115;
                            float floatValue116;
                            float floatValue117;
                            float floatValue118;
                            float floatValue119;
                            float floatValue120;
                            float floatValue121;
                            float floatValue122;
                            float floatValue123;
                            float floatValue124;
                            float floatValue125;
                            float floatValue126;
                            float floatValue127;
                            float floatValue128;
                            float floatValue129;
                            float floatValue130;
                            float floatValue131;
                            float floatValue132;
                            float floatValue133;
                            float floatValue134;
                            float floatValue135;
                            float floatValue136;
                            float floatValue137;
                            float floatValue138;
                            float floatValue139;
                            float floatValue140;
                            float floatValue141;
                            float floatValue142;
                            float floatValue143;
                            float floatValue144;
                            switch (uploadBackgroundView.chooseObject) {
                                case 1:
                                    floatValue = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    floatValue2 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    float f16 = floatValue2 + floatValue;
                                    floatValue3 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    float f17 = floatValue3 - uploadBackgroundView.startY;
                                    float f18 = 2;
                                    float f19 = f16 / f18;
                                    ReadWriteProperty readWriteProperty = uploadBackgroundView.topBorder$delegate;
                                    KProperty<?>[] kPropertyArr = UploadBackgroundView.$$delegatedProperties;
                                    readWriteProperty.setValue(uploadBackgroundView, kPropertyArr[4], Float.valueOf(f19));
                                    uploadBackgroundView.bottomBorder$delegate.setValue(uploadBackgroundView, kPropertyArr[5], Float.valueOf(f19));
                                    floatValue4 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                    float f26 = f17 / f18;
                                    uploadBackgroundView.topPos$delegate.setValue(uploadBackgroundView, kPropertyArr[0], Float.valueOf(floatValue4 - f26));
                                    floatValue5 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                    uploadBackgroundView.bottomPos$delegate.setValue(uploadBackgroundView, kPropertyArr[2], Float.valueOf(floatValue5 + f26));
                                    floatValue6 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    floatValue7 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                    uploadBackgroundView.topPos$delegate.setValue(uploadBackgroundView, kPropertyArr[0], Float.valueOf(Math.min(floatValue6, floatValue7)));
                                    floatValue8 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    floatValue9 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                    uploadBackgroundView.bottomPos$delegate.setValue(uploadBackgroundView, kPropertyArr[2], Float.valueOf(Math.min(floatValue8, floatValue9)));
                                    return;
                                case 2:
                                    floatValue10 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    floatValue11 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    float f27 = floatValue11 + floatValue10;
                                    float v3 = uploadBackgroundView.getFlexNode().v();
                                    floatValue12 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    float f28 = (v3 - floatValue12) - uploadBackgroundView.startX;
                                    float f29 = 2;
                                    float f36 = f27 / f29;
                                    ReadWriteProperty readWriteProperty2 = uploadBackgroundView.leftBorder$delegate;
                                    KProperty<?>[] kPropertyArr2 = UploadBackgroundView.$$delegatedProperties;
                                    readWriteProperty2.setValue(uploadBackgroundView, kPropertyArr2[6], Float.valueOf(f36));
                                    uploadBackgroundView.rightBorder$delegate.setValue(uploadBackgroundView, kPropertyArr2[7], Float.valueOf(f36));
                                    floatValue13 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                    float f37 = f28 / f29;
                                    uploadBackgroundView.leftPos$delegate.setValue(uploadBackgroundView, kPropertyArr2[1], Float.valueOf(floatValue13 - f37));
                                    floatValue14 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                    uploadBackgroundView.rightPos$delegate.setValue(uploadBackgroundView, kPropertyArr2[3], Float.valueOf(floatValue14 + f37));
                                    floatValue15 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                    floatValue16 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    uploadBackgroundView.leftPos$delegate.setValue(uploadBackgroundView, kPropertyArr2[1], Float.valueOf(Math.min(floatValue15, floatValue16)));
                                    floatValue17 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                    floatValue18 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    uploadBackgroundView.rightPos$delegate.setValue(uploadBackgroundView, kPropertyArr2[3], Float.valueOf(Math.min(floatValue17, floatValue18)));
                                    return;
                                case 3:
                                    floatValue19 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    floatValue20 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    float f38 = floatValue20 + floatValue19;
                                    float t16 = uploadBackgroundView.getFlexNode().t();
                                    floatValue21 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    float f39 = (t16 - floatValue21) - uploadBackgroundView.startY;
                                    float f46 = 5;
                                    ReadWriteProperty readWriteProperty3 = uploadBackgroundView.topBorder$delegate;
                                    KProperty<?>[] kPropertyArr3 = UploadBackgroundView.$$delegatedProperties;
                                    readWriteProperty3.setValue(uploadBackgroundView, kPropertyArr3[4], Float.valueOf((3 * f38) / f46));
                                    float f47 = 2;
                                    uploadBackgroundView.bottomBorder$delegate.setValue(uploadBackgroundView, kPropertyArr3[5], Float.valueOf((f38 * f47) / f46));
                                    floatValue22 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                    float f48 = f39 / f47;
                                    uploadBackgroundView.topPos$delegate.setValue(uploadBackgroundView, kPropertyArr3[0], Float.valueOf(floatValue22 - f48));
                                    floatValue23 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                    uploadBackgroundView.bottomPos$delegate.setValue(uploadBackgroundView, kPropertyArr3[2], Float.valueOf(floatValue23 + f48));
                                    floatValue24 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    floatValue25 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                    uploadBackgroundView.topPos$delegate.setValue(uploadBackgroundView, kPropertyArr3[0], Float.valueOf(Math.min(floatValue24, floatValue25)));
                                    floatValue26 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    floatValue27 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                    uploadBackgroundView.bottomPos$delegate.setValue(uploadBackgroundView, kPropertyArr3[2], Float.valueOf(Math.min(floatValue26, floatValue27)));
                                    return;
                                case 4:
                                    floatValue28 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    floatValue29 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    float f49 = floatValue29 + floatValue28;
                                    floatValue30 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    float f56 = floatValue30 - uploadBackgroundView.startX;
                                    float f57 = 2;
                                    float f58 = f49 / f57;
                                    ReadWriteProperty readWriteProperty4 = uploadBackgroundView.leftBorder$delegate;
                                    KProperty<?>[] kPropertyArr4 = UploadBackgroundView.$$delegatedProperties;
                                    readWriteProperty4.setValue(uploadBackgroundView, kPropertyArr4[6], Float.valueOf(f58));
                                    uploadBackgroundView.rightBorder$delegate.setValue(uploadBackgroundView, kPropertyArr4[7], Float.valueOf(f58));
                                    floatValue31 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                    float f59 = f56 / f57;
                                    uploadBackgroundView.leftPos$delegate.setValue(uploadBackgroundView, kPropertyArr4[1], Float.valueOf(floatValue31 - f59));
                                    floatValue32 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                    uploadBackgroundView.rightPos$delegate.setValue(uploadBackgroundView, kPropertyArr4[3], Float.valueOf(floatValue32 + f59));
                                    floatValue33 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                    floatValue34 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    uploadBackgroundView.leftPos$delegate.setValue(uploadBackgroundView, kPropertyArr4[1], Float.valueOf(Math.min(floatValue33, floatValue34)));
                                    floatValue35 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                    floatValue36 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    uploadBackgroundView.rightPos$delegate.setValue(uploadBackgroundView, kPropertyArr4[3], Float.valueOf(Math.min(floatValue35, floatValue36)));
                                    return;
                                case 5:
                                    floatValue37 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                    floatValue38 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    if (floatValue37 > floatValue38) {
                                        floatValue61 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                        floatValue62 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                        float f65 = floatValue61 - floatValue62;
                                        floatValue63 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                        ReadWriteProperty readWriteProperty5 = uploadBackgroundView.leftPos$delegate;
                                        KProperty<?>[] kPropertyArr5 = UploadBackgroundView.$$delegatedProperties;
                                        readWriteProperty5.setValue(uploadBackgroundView, kPropertyArr5[1], Float.valueOf(floatValue63 - f65));
                                        floatValue64 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                        uploadBackgroundView.rightPos$delegate.setValue(uploadBackgroundView, kPropertyArr5[3], Float.valueOf(floatValue64 + f65));
                                    }
                                    floatValue39 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                    floatValue40 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    if (floatValue39 > floatValue40) {
                                        floatValue57 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                        floatValue58 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                        float f66 = floatValue57 - floatValue58;
                                        floatValue59 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                        ReadWriteProperty readWriteProperty6 = uploadBackgroundView.rightPos$delegate;
                                        KProperty<?>[] kPropertyArr6 = UploadBackgroundView.$$delegatedProperties;
                                        readWriteProperty6.setValue(uploadBackgroundView, kPropertyArr6[3], Float.valueOf(floatValue59 - f66));
                                        floatValue60 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                        uploadBackgroundView.leftPos$delegate.setValue(uploadBackgroundView, kPropertyArr6[1], Float.valueOf(floatValue60 + f66));
                                    }
                                    floatValue41 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                    floatValue42 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    if (floatValue41 > floatValue42) {
                                        floatValue53 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                        floatValue54 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                        float f67 = floatValue53 - floatValue54;
                                        floatValue55 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                        ReadWriteProperty readWriteProperty7 = uploadBackgroundView.topPos$delegate;
                                        KProperty<?>[] kPropertyArr7 = UploadBackgroundView.$$delegatedProperties;
                                        readWriteProperty7.setValue(uploadBackgroundView, kPropertyArr7[0], Float.valueOf(floatValue55 - f67));
                                        floatValue56 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                        uploadBackgroundView.bottomPos$delegate.setValue(uploadBackgroundView, kPropertyArr7[2], Float.valueOf(floatValue56 + f67));
                                    }
                                    floatValue43 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                    floatValue44 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    if (floatValue43 > floatValue44) {
                                        floatValue49 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                        floatValue50 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                        float f68 = floatValue49 - floatValue50;
                                        floatValue51 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                        ReadWriteProperty readWriteProperty8 = uploadBackgroundView.topPos$delegate;
                                        KProperty<?>[] kPropertyArr8 = UploadBackgroundView.$$delegatedProperties;
                                        readWriteProperty8.setValue(uploadBackgroundView, kPropertyArr8[0], Float.valueOf(floatValue51 + f68));
                                        floatValue52 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                        uploadBackgroundView.bottomPos$delegate.setValue(uploadBackgroundView, kPropertyArr8[2], Float.valueOf(floatValue52 - f68));
                                    }
                                    invoke$revertWhenInvalid(uploadBackgroundView, "endMoveImage");
                                    floatValue45 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                    uploadBackgroundView.rememberLeftPos = floatValue45;
                                    floatValue46 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                    uploadBackgroundView.rememberRightPos = floatValue46;
                                    floatValue47 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                    uploadBackgroundView.rememberBottomPos = floatValue47;
                                    floatValue48 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                    uploadBackgroundView.rememberTopPos = floatValue48;
                                    return;
                                case 6:
                                    float v16 = uploadBackgroundView.getFlexNode().v();
                                    floatValue65 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    float f69 = v16 - floatValue65;
                                    floatValue66 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    float f75 = uploadBackgroundView.startWidth / (f69 - floatValue66);
                                    float v17 = uploadBackgroundView.getFlexNode().v() - uploadBackgroundView.startWidth;
                                    floatValue67 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    float f76 = v17 - floatValue67;
                                    ReadWriteProperty readWriteProperty9 = uploadBackgroundView.leftBorder$delegate;
                                    KProperty<?>[] kPropertyArr9 = UploadBackgroundView.$$delegatedProperties;
                                    readWriteProperty9.setValue(uploadBackgroundView, kPropertyArr9[6], Float.valueOf(f76));
                                    float t17 = uploadBackgroundView.getFlexNode().t() - uploadBackgroundView.startHeight;
                                    floatValue68 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    uploadBackgroundView.topBorder$delegate.setValue(uploadBackgroundView, kPropertyArr9[4], Float.valueOf(t17 - floatValue68));
                                    float v18 = uploadBackgroundView.getFlexNode().v();
                                    floatValue69 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    float f77 = v18 - floatValue69;
                                    float v19 = uploadBackgroundView.getFlexNode().v();
                                    floatValue70 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    float f78 = v19 - floatValue70;
                                    floatValue71 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                    uploadBackgroundView.leftPos$delegate.setValue(uploadBackgroundView, kPropertyArr9[1], Float.valueOf(f77 - ((f78 - floatValue71) * f75)));
                                    floatValue72 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    floatValue73 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    floatValue74 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                    uploadBackgroundView.rightPos$delegate.setValue(uploadBackgroundView, kPropertyArr9[3], Float.valueOf(floatValue72 - ((floatValue73 - floatValue74) * f75)));
                                    float t18 = uploadBackgroundView.getFlexNode().t();
                                    floatValue75 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    float f79 = t18 - floatValue75;
                                    float t19 = uploadBackgroundView.getFlexNode().t();
                                    floatValue76 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    float f85 = t19 - floatValue76;
                                    floatValue77 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                    uploadBackgroundView.topPos$delegate.setValue(uploadBackgroundView, kPropertyArr9[0], Float.valueOf(f79 - ((f85 - floatValue77) * f75)));
                                    floatValue78 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    floatValue79 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    floatValue80 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                    uploadBackgroundView.bottomPos$delegate.setValue(uploadBackgroundView, kPropertyArr9[2], Float.valueOf(floatValue78 - ((floatValue79 - floatValue80) * f75)));
                                    floatValue81 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                    uploadBackgroundView.rememberBottomPos = floatValue81;
                                    floatValue82 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                    uploadBackgroundView.rememberLeftPos = floatValue82;
                                    floatValue83 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                    uploadBackgroundView.rememberRightPos = floatValue83;
                                    floatValue84 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                    uploadBackgroundView.rememberTopPos = floatValue84;
                                    return;
                                case 7:
                                    float v26 = uploadBackgroundView.getFlexNode().v();
                                    floatValue85 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    float f86 = v26 - floatValue85;
                                    floatValue86 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    float f87 = uploadBackgroundView.startWidth / (f86 - floatValue86);
                                    float v27 = uploadBackgroundView.getFlexNode().v() - uploadBackgroundView.startWidth;
                                    floatValue87 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    float f88 = v27 - floatValue87;
                                    ReadWriteProperty readWriteProperty10 = uploadBackgroundView.rightBorder$delegate;
                                    KProperty<?>[] kPropertyArr10 = UploadBackgroundView.$$delegatedProperties;
                                    readWriteProperty10.setValue(uploadBackgroundView, kPropertyArr10[7], Float.valueOf(f88));
                                    float t26 = uploadBackgroundView.getFlexNode().t() - uploadBackgroundView.startHeight;
                                    floatValue88 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    uploadBackgroundView.topBorder$delegate.setValue(uploadBackgroundView, kPropertyArr10[4], Float.valueOf(t26 - floatValue88));
                                    floatValue89 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    floatValue90 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    floatValue91 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                    uploadBackgroundView.leftPos$delegate.setValue(uploadBackgroundView, kPropertyArr10[1], Float.valueOf(floatValue89 - ((floatValue90 - floatValue91) * f87)));
                                    float v28 = uploadBackgroundView.getFlexNode().v();
                                    floatValue92 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    float f89 = v28 - floatValue92;
                                    float v29 = uploadBackgroundView.getFlexNode().v();
                                    floatValue93 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    float f95 = v29 - floatValue93;
                                    floatValue94 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                    uploadBackgroundView.rightPos$delegate.setValue(uploadBackgroundView, kPropertyArr10[3], Float.valueOf(f89 - ((f95 - floatValue94) * f87)));
                                    float t27 = uploadBackgroundView.getFlexNode().t();
                                    floatValue95 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    float f96 = t27 - floatValue95;
                                    float t28 = uploadBackgroundView.getFlexNode().t();
                                    floatValue96 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    float f97 = t28 - floatValue96;
                                    floatValue97 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                    uploadBackgroundView.topPos$delegate.setValue(uploadBackgroundView, kPropertyArr10[0], Float.valueOf(f96 - ((f97 - floatValue97) * f87)));
                                    floatValue98 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    floatValue99 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                    floatValue100 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                    uploadBackgroundView.bottomPos$delegate.setValue(uploadBackgroundView, kPropertyArr10[2], Float.valueOf(floatValue98 - ((floatValue99 - floatValue100) * f87)));
                                    floatValue101 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                    uploadBackgroundView.rememberLeftPos = floatValue101;
                                    floatValue102 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                    uploadBackgroundView.rememberRightPos = floatValue102;
                                    floatValue103 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                    uploadBackgroundView.rememberTopPos = floatValue103;
                                    floatValue104 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                    uploadBackgroundView.rememberBottomPos = floatValue104;
                                    return;
                                case 8:
                                    float v36 = uploadBackgroundView.getFlexNode().v();
                                    floatValue105 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    float f98 = v36 - floatValue105;
                                    floatValue106 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    float f99 = uploadBackgroundView.startWidth / (f98 - floatValue106);
                                    float v37 = uploadBackgroundView.getFlexNode().v() - uploadBackgroundView.startWidth;
                                    floatValue107 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    float f100 = v37 - floatValue107;
                                    ReadWriteProperty readWriteProperty11 = uploadBackgroundView.rightBorder$delegate;
                                    KProperty<?>[] kPropertyArr11 = UploadBackgroundView.$$delegatedProperties;
                                    readWriteProperty11.setValue(uploadBackgroundView, kPropertyArr11[7], Float.valueOf(f100));
                                    float t29 = uploadBackgroundView.getFlexNode().t() - uploadBackgroundView.startHeight;
                                    floatValue108 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    uploadBackgroundView.bottomBorder$delegate.setValue(uploadBackgroundView, kPropertyArr11[5], Float.valueOf(t29 - floatValue108));
                                    floatValue109 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    floatValue110 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    floatValue111 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                    uploadBackgroundView.leftPos$delegate.setValue(uploadBackgroundView, kPropertyArr11[1], Float.valueOf(floatValue109 - ((floatValue110 - floatValue111) * f99)));
                                    float v38 = uploadBackgroundView.getFlexNode().v();
                                    floatValue112 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    float f101 = v38 - floatValue112;
                                    float v39 = uploadBackgroundView.getFlexNode().v();
                                    floatValue113 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    float f102 = v39 - floatValue113;
                                    floatValue114 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                    uploadBackgroundView.rightPos$delegate.setValue(uploadBackgroundView, kPropertyArr11[3], Float.valueOf(f101 - ((f102 - floatValue114) * f99)));
                                    floatValue115 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    floatValue116 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    floatValue117 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                    uploadBackgroundView.topPos$delegate.setValue(uploadBackgroundView, kPropertyArr11[0], Float.valueOf(floatValue115 - ((floatValue116 - floatValue117) * f99)));
                                    float t36 = uploadBackgroundView.getFlexNode().t();
                                    floatValue118 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    float f103 = t36 - floatValue118;
                                    float t37 = uploadBackgroundView.getFlexNode().t();
                                    floatValue119 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    float f104 = t37 - floatValue119;
                                    floatValue120 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                    uploadBackgroundView.bottomPos$delegate.setValue(uploadBackgroundView, kPropertyArr11[2], Float.valueOf(f103 - ((f104 - floatValue120) * f99)));
                                    floatValue121 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                    uploadBackgroundView.rememberLeftPos = floatValue121;
                                    floatValue122 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                    uploadBackgroundView.rememberRightPos = floatValue122;
                                    floatValue123 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                    uploadBackgroundView.rememberBottomPos = floatValue123;
                                    floatValue124 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                    uploadBackgroundView.rememberTopPos = floatValue124;
                                    return;
                                case 9:
                                    float v46 = uploadBackgroundView.getFlexNode().v();
                                    floatValue125 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    float f105 = v46 - floatValue125;
                                    floatValue126 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                    float f106 = uploadBackgroundView.startWidth / (f105 - floatValue126);
                                    float t38 = uploadBackgroundView.getFlexNode().t() - uploadBackgroundView.startHeight;
                                    floatValue127 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    float f107 = t38 - floatValue127;
                                    ReadWriteProperty readWriteProperty12 = uploadBackgroundView.bottomBorder$delegate;
                                    KProperty<?>[] kPropertyArr12 = UploadBackgroundView.$$delegatedProperties;
                                    readWriteProperty12.setValue(uploadBackgroundView, kPropertyArr12[5], Float.valueOf(f107));
                                    float v47 = uploadBackgroundView.getFlexNode().v() - uploadBackgroundView.startWidth;
                                    floatValue128 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    uploadBackgroundView.leftBorder$delegate.setValue(uploadBackgroundView, kPropertyArr12[6], Float.valueOf(v47 - floatValue128));
                                    float v48 = uploadBackgroundView.getFlexNode().v();
                                    floatValue129 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    float f108 = v48 - floatValue129;
                                    float v49 = uploadBackgroundView.getFlexNode().v();
                                    floatValue130 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    float f109 = v49 - floatValue130;
                                    floatValue131 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                    uploadBackgroundView.leftPos$delegate.setValue(uploadBackgroundView, kPropertyArr12[1], Float.valueOf(f108 - ((f109 - floatValue131) * f106)));
                                    floatValue132 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    floatValue133 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                    floatValue134 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                    uploadBackgroundView.rightPos$delegate.setValue(uploadBackgroundView, kPropertyArr12[3], Float.valueOf(floatValue132 - ((floatValue133 - floatValue134) * f106)));
                                    float t39 = uploadBackgroundView.getFlexNode().t();
                                    floatValue135 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    float f110 = t39 - floatValue135;
                                    float t46 = uploadBackgroundView.getFlexNode().t();
                                    floatValue136 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    float f111 = t46 - floatValue136;
                                    floatValue137 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                    uploadBackgroundView.bottomPos$delegate.setValue(uploadBackgroundView, kPropertyArr12[2], Float.valueOf(f110 - ((f111 - floatValue137) * f106)));
                                    floatValue138 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    floatValue139 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    floatValue140 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                    uploadBackgroundView.topPos$delegate.setValue(uploadBackgroundView, kPropertyArr12[0], Float.valueOf(floatValue138 - ((floatValue139 - floatValue140) * f106)));
                                    floatValue141 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                    uploadBackgroundView.rememberLeftPos = floatValue141;
                                    floatValue142 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                    uploadBackgroundView.rememberRightPos = floatValue142;
                                    floatValue143 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                    uploadBackgroundView.rememberBottomPos = floatValue143;
                                    floatValue144 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                    uploadBackgroundView.rememberTopPos = floatValue144;
                                    return;
                                case 10:
                                    invoke$endPinth(uploadBackgroundView);
                                    return;
                                default:
                                    return;
                            }
                        }

                        public static final void invoke$endPinth(UploadBackgroundView uploadBackgroundView) {
                            float floatValue;
                            float floatValue2;
                            float floatValue3;
                            float floatValue4;
                            invoke$revertWhenInvalid(uploadBackgroundView, "endPinth");
                            floatValue = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                            uploadBackgroundView.rememberLeftPos = floatValue;
                            floatValue2 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                            uploadBackgroundView.rememberRightPos = floatValue2;
                            floatValue3 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                            uploadBackgroundView.rememberBottomPos = floatValue3;
                            floatValue4 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                            uploadBackgroundView.rememberTopPos = floatValue4;
                        }

                        public static final void invoke$revertWhenInvalid(UploadBackgroundView uploadBackgroundView, String str) {
                            float floatValue;
                            float floatValue2;
                            float floatValue3;
                            float floatValue4;
                            float floatValue5;
                            float floatValue6;
                            float floatValue7;
                            float floatValue8;
                            float floatValue9;
                            float floatValue10;
                            String trimIndent;
                            float floatValue11;
                            float floatValue12;
                            float floatValue13;
                            float floatValue14;
                            float floatValue15;
                            float floatValue16;
                            floatValue = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                            floatValue2 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                            if (!UploadBackgroundViewKt.access$moreThan(floatValue, floatValue2)) {
                                floatValue11 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                floatValue12 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                if (!UploadBackgroundViewKt.access$moreThan(floatValue11, floatValue12)) {
                                    floatValue13 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                    floatValue14 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                    if (!UploadBackgroundViewKt.access$moreThan(floatValue13, floatValue14)) {
                                        floatValue15 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                        floatValue16 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                        if (!UploadBackgroundViewKt.access$moreThan(floatValue15, floatValue16)) {
                                            return;
                                        }
                                    }
                                }
                            }
                            KLog kLog = KLog.INSTANCE;
                            StringBuilder m3 = CacheDiskLru$$ExternalSyntheticOutline0.m("\n                                revert pinth invalid from:", str, "\n                                leftPos=");
                            floatValue3 = ((Number) uploadBackgroundView.leftPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                            m3.append(floatValue3);
                            m3.append(" should < leftBorder=");
                            floatValue4 = ((Number) uploadBackgroundView.leftBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                            m3.append(floatValue4);
                            m3.append("\n                                rightPos=");
                            floatValue5 = ((Number) uploadBackgroundView.rightPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                            m3.append(floatValue5);
                            m3.append(" should < rightBorder=");
                            floatValue6 = ((Number) uploadBackgroundView.rightBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                            m3.append(floatValue6);
                            m3.append("\n                                topPos=");
                            floatValue7 = ((Number) uploadBackgroundView.topPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                            m3.append(floatValue7);
                            m3.append(" should < topBorder=");
                            floatValue8 = ((Number) uploadBackgroundView.topBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                            m3.append(floatValue8);
                            m3.append("\n                                bottomPos=");
                            floatValue9 = ((Number) uploadBackgroundView.bottomPos$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                            m3.append(floatValue9);
                            m3.append(" should < bottomBorder=");
                            floatValue10 = ((Number) uploadBackgroundView.bottomBorder$delegate.getValue(uploadBackgroundView, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                            m3.append(floatValue10);
                            m3.append("\n                            ");
                            trimIndent = StringsKt__IndentKt.trimIndent(m3.toString());
                            kLog.e("UploadBackgroundView", trimIndent);
                            float f16 = uploadBackgroundView.originLeftPos;
                            ReadWriteProperty readWriteProperty = uploadBackgroundView.leftPos$delegate;
                            KProperty<?>[] kPropertyArr = UploadBackgroundView.$$delegatedProperties;
                            readWriteProperty.setValue(uploadBackgroundView, kPropertyArr[1], Float.valueOf(f16));
                            uploadBackgroundView.rightPos$delegate.setValue(uploadBackgroundView, kPropertyArr[3], Float.valueOf(uploadBackgroundView.originRightPos));
                            uploadBackgroundView.topPos$delegate.setValue(uploadBackgroundView, kPropertyArr[0], Float.valueOf(uploadBackgroundView.originTopPos));
                            uploadBackgroundView.bottomPos$delegate.setValue(uploadBackgroundView, kPropertyArr[2], Float.valueOf(uploadBackgroundView.originBottomPos));
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(u uVar) {
                            u uVar2 = uVar;
                            final UploadBackgroundView uploadBackgroundView = this.$ctx;
                            uVar2.touchDown(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.6.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TouchParams touchParams) {
                                    TouchParams touchParams2 = touchParams;
                                    UploadBackgroundView.this.counts = touchParams2.c().size();
                                    UploadBackgroundView.this.previousCounts = touchParams2.c().size();
                                    AnonymousClass6.access$invoke$commonStart(UploadBackgroundView.this, touchParams2.c().get(0).getPageX(), touchParams2.c().get(0).getPageY());
                                    ConversationListKt$AddConversation$1$$ExternalSyntheticOutline0.m(BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("chooseObject="), UploadBackgroundView.this.chooseObject, KLog.INSTANCE, "touchDown");
                                    return Unit.INSTANCE;
                                }
                            });
                            final UploadBackgroundView uploadBackgroundView2 = this.$ctx;
                            final UpLoadBackgroundPage upLoadBackgroundPage = this.$page;
                            uVar2.touchMove(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.6.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Removed duplicated region for block: B:58:0x03ea  */
                                @Override // kotlin.jvm.functions.Function1
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                */
                                public final Unit invoke(TouchParams touchParams) {
                                    float floatValue;
                                    float floatValue2;
                                    float floatValue3;
                                    float floatValue4;
                                    float floatValue5;
                                    float floatValue6;
                                    float floatValue7;
                                    float floatValue8;
                                    float floatValue9;
                                    float floatValue10;
                                    float floatValue11;
                                    float floatValue12;
                                    float floatValue13;
                                    float floatValue14;
                                    float floatValue15;
                                    String trimIndent;
                                    float floatValue16;
                                    float floatValue17;
                                    float floatValue18;
                                    String trimIndent2;
                                    float floatValue19;
                                    float floatValue20;
                                    float floatValue21;
                                    float floatValue22;
                                    float floatValue23;
                                    float floatValue24;
                                    float floatValue25;
                                    float floatValue26;
                                    float floatValue27;
                                    float floatValue28;
                                    float floatValue29;
                                    float floatValue30;
                                    float floatValue31;
                                    float floatValue32;
                                    float floatValue33;
                                    float floatValue34;
                                    float floatValue35;
                                    float floatValue36;
                                    float floatValue37;
                                    float floatValue38;
                                    float floatValue39;
                                    float floatValue40;
                                    float floatValue41;
                                    float floatValue42;
                                    float floatValue43;
                                    float floatValue44;
                                    float floatValue45;
                                    float floatValue46;
                                    float floatValue47;
                                    float floatValue48;
                                    float floatValue49;
                                    float floatValue50;
                                    float floatValue51;
                                    float floatValue52;
                                    float floatValue53;
                                    float floatValue54;
                                    float floatValue55;
                                    float floatValue56;
                                    float floatValue57;
                                    float floatValue58;
                                    float floatValue59;
                                    float floatValue60;
                                    TouchParams touchParams2 = touchParams;
                                    UploadBackgroundView.this.counts = touchParams2.c().size();
                                    float pageX = touchParams2.c().get(0).getPageX();
                                    float pageY = touchParams2.c().get(0).getPageY();
                                    UploadBackgroundView uploadBackgroundView3 = UploadBackgroundView.this;
                                    int i3 = uploadBackgroundView3.counts;
                                    if (i3 == 1 && uploadBackgroundView3.previousCounts == 1) {
                                        switch (uploadBackgroundView3.chooseObject) {
                                            case 1:
                                                float t16 = uploadBackgroundView3.getFlexNode().t();
                                                floatValue = ((Number) uploadBackgroundView3.bottomBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                                float v3 = uploadBackgroundView3.getFlexNode().v();
                                                floatValue2 = ((Number) uploadBackgroundView3.rightBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                                float f16 = v3 - floatValue2;
                                                floatValue3 = ((Number) uploadBackgroundView3.leftBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                                if (pageY < (t16 - floatValue) - (((f16 - floatValue3) * 2) / 3)) {
                                                    floatValue4 = ((Number) uploadBackgroundView3.topPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                                    if (pageY > floatValue4 && pageY >= 60.0f) {
                                                        uploadBackgroundView3.topBorder$delegate.setValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[4], Float.valueOf(pageY));
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 2:
                                                floatValue5 = ((Number) uploadBackgroundView3.leftBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                                if (pageX > floatValue5 + 180.0f) {
                                                    float v16 = uploadBackgroundView3.getFlexNode().v();
                                                    floatValue6 = ((Number) uploadBackgroundView3.rightPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                                    if (pageX < v16 - floatValue6 && pageX <= uploadBackgroundView3.getFlexNode().v() - 10.0f) {
                                                        uploadBackgroundView3.rightBorder$delegate.setValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[7], Float.valueOf(uploadBackgroundView3.getFlexNode().v() - pageX));
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 3:
                                                floatValue7 = ((Number) uploadBackgroundView3.topBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                                float v17 = uploadBackgroundView3.getFlexNode().v();
                                                floatValue8 = ((Number) uploadBackgroundView3.rightBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                                float f17 = v17 - floatValue8;
                                                floatValue9 = ((Number) uploadBackgroundView3.leftBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                                if (pageY > (((f17 - floatValue9) * 2) / 3) + floatValue7) {
                                                    float t17 = uploadBackgroundView3.getFlexNode().t();
                                                    floatValue10 = ((Number) uploadBackgroundView3.bottomPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                                    if (pageY < t17 - floatValue10 && pageY <= uploadBackgroundView3.getFlexNode().t() - 40.0f) {
                                                        uploadBackgroundView3.bottomBorder$delegate.setValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[5], Float.valueOf(uploadBackgroundView3.getFlexNode().t() - pageY));
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 4:
                                                float v18 = uploadBackgroundView3.getFlexNode().v();
                                                floatValue11 = ((Number) uploadBackgroundView3.rightBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                                if (pageX < (v18 - floatValue11) - 180.0f) {
                                                    floatValue12 = ((Number) uploadBackgroundView3.leftPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                                    if (pageX > floatValue12 && pageX > 10.0f) {
                                                        uploadBackgroundView3.leftBorder$delegate.setValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[6], Float.valueOf(pageX));
                                                        break;
                                                    }
                                                }
                                                break;
                                            case 5:
                                                float f18 = pageX - uploadBackgroundView3.startX;
                                                float f19 = pageY - uploadBackgroundView3.startY;
                                                float f26 = uploadBackgroundView3.rememberLeftPos + f18;
                                                float f27 = uploadBackgroundView3.rememberTopPos + f19;
                                                float f28 = uploadBackgroundView3.rememberRightPos - f18;
                                                float f29 = uploadBackgroundView3.rememberBottomPos - f19;
                                                floatValue13 = ((Number) uploadBackgroundView3.leftBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                                if (f26 < floatValue13) {
                                                    floatValue20 = ((Number) uploadBackgroundView3.rightBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                                    if (f28 < floatValue20) {
                                                        ReadWriteProperty readWriteProperty = uploadBackgroundView3.leftPos$delegate;
                                                        KProperty<?>[] kPropertyArr = UploadBackgroundView.$$delegatedProperties;
                                                        readWriteProperty.setValue(uploadBackgroundView3, kPropertyArr[1], Float.valueOf(f26));
                                                        uploadBackgroundView3.rightPos$delegate.setValue(uploadBackgroundView3, kPropertyArr[3], Float.valueOf(f28));
                                                        floatValue16 = ((Number) uploadBackgroundView3.topBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                                        if (f27 < floatValue16) {
                                                            floatValue19 = ((Number) uploadBackgroundView3.bottomBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                                            if (f29 < floatValue19) {
                                                                ReadWriteProperty readWriteProperty2 = uploadBackgroundView3.bottomPos$delegate;
                                                                KProperty<?>[] kPropertyArr2 = UploadBackgroundView.$$delegatedProperties;
                                                                readWriteProperty2.setValue(uploadBackgroundView3, kPropertyArr2[2], Float.valueOf(f29));
                                                                uploadBackgroundView3.topPos$delegate.setValue(uploadBackgroundView3, kPropertyArr2[0], Float.valueOf(f27));
                                                                break;
                                                            }
                                                        }
                                                        KLog kLog = KLog.INSTANCE;
                                                        StringBuilder sb5 = new StringBuilder();
                                                        sb5.append("\n                                movePhoto error: \n                                moveToTop=");
                                                        sb5.append(f27);
                                                        sb5.append(" moveToBottom=");
                                                        sb5.append(f29);
                                                        sb5.append("\n                                topBorder=");
                                                        floatValue17 = ((Number) uploadBackgroundView3.topBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                                        sb5.append(floatValue17);
                                                        sb5.append(" bottomBorder=");
                                                        floatValue18 = ((Number) uploadBackgroundView3.bottomBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                                        sb5.append(floatValue18);
                                                        sb5.append("\n                            ");
                                                        trimIndent2 = StringsKt__IndentKt.trimIndent(sb5.toString());
                                                        kLog.e("UploadBackgroundView", trimIndent2);
                                                        break;
                                                    }
                                                }
                                                KLog kLog2 = KLog.INSTANCE;
                                                StringBuilder sb6 = new StringBuilder();
                                                sb6.append("\n                                movePhoto error: \n                                moveToLeft=");
                                                sb6.append(f26);
                                                sb6.append(" moveToRight=");
                                                sb6.append(f28);
                                                sb6.append(" \n                                leftBorder=");
                                                floatValue14 = ((Number) uploadBackgroundView3.leftBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                                sb6.append(floatValue14);
                                                sb6.append(" rightBorder=");
                                                floatValue15 = ((Number) uploadBackgroundView3.rightBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                                sb6.append(floatValue15);
                                                sb6.append("}\n                            ");
                                                trimIndent = StringsKt__IndentKt.trimIndent(sb6.toString());
                                                kLog2.e("UploadBackgroundView", trimIndent);
                                                floatValue16 = ((Number) uploadBackgroundView3.topBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                                if (f27 < floatValue16) {
                                                }
                                                KLog kLog3 = KLog.INSTANCE;
                                                StringBuilder sb52 = new StringBuilder();
                                                sb52.append("\n                                movePhoto error: \n                                moveToTop=");
                                                sb52.append(f27);
                                                sb52.append(" moveToBottom=");
                                                sb52.append(f29);
                                                sb52.append("\n                                topBorder=");
                                                floatValue17 = ((Number) uploadBackgroundView3.topBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                                sb52.append(floatValue17);
                                                sb52.append(" bottomBorder=");
                                                floatValue18 = ((Number) uploadBackgroundView3.bottomBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                                sb52.append(floatValue18);
                                                sb52.append("\n                            ");
                                                trimIndent2 = StringsKt__IndentKt.trimIndent(sb52.toString());
                                                kLog3.e("UploadBackgroundView", trimIndent2);
                                            case 6:
                                                float v19 = uploadBackgroundView3.getFlexNode().v();
                                                floatValue21 = ((Number) uploadBackgroundView3.rightBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                                if (pageX < (v19 - floatValue21) - 30.0f) {
                                                    floatValue24 = ((Number) uploadBackgroundView3.leftPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                                    if (pageX > floatValue24) {
                                                        floatValue25 = ((Number) uploadBackgroundView3.topBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                                        floatValue26 = ((Number) uploadBackgroundView3.topPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                                        if (UploadBackgroundViewKt.access$equalOrMoreThan(floatValue25, floatValue26)) {
                                                            float v26 = uploadBackgroundView3.getFlexNode().v();
                                                            floatValue27 = ((Number) uploadBackgroundView3.rightBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                                            float f36 = (((v26 - floatValue27) - pageX) * uploadBackgroundView3.startHeight) / uploadBackgroundView3.startWidth;
                                                            float t18 = uploadBackgroundView3.getFlexNode().t();
                                                            floatValue28 = ((Number) uploadBackgroundView3.bottomBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                                            float f37 = (t18 - floatValue28) - f36;
                                                            floatValue29 = ((Number) uploadBackgroundView3.topPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                                            if (UploadBackgroundViewKt.access$equalOrMoreThan(f37, floatValue29)) {
                                                                ReadWriteProperty readWriteProperty3 = uploadBackgroundView3.leftBorder$delegate;
                                                                KProperty<?>[] kPropertyArr3 = UploadBackgroundView.$$delegatedProperties;
                                                                readWriteProperty3.setValue(uploadBackgroundView3, kPropertyArr3[6], Float.valueOf(pageX));
                                                                uploadBackgroundView3.topBorder$delegate.setValue(uploadBackgroundView3, kPropertyArr3[4], Float.valueOf(f37));
                                                                break;
                                                            } else {
                                                                KLog kLog4 = KLog.INSTANCE;
                                                                StringBuilder sb7 = new StringBuilder();
                                                                sb7.append("moveBorderTopLeft error : moveTo=");
                                                                sb7.append(f37);
                                                                sb7.append(" topPos=");
                                                                floatValue30 = ((Number) uploadBackgroundView3.topPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                                                sb7.append(floatValue30);
                                                                kLog4.i("UploadBackgroundView", sb7.toString());
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                KLog kLog5 = KLog.INSTANCE;
                                                StringBuilder sb8 = new StringBuilder();
                                                sb8.append("moveBorderTopLeft error : pageX=");
                                                sb8.append(pageX);
                                                sb8.append(" topBorder=");
                                                floatValue22 = ((Number) uploadBackgroundView3.topBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                                sb8.append(floatValue22);
                                                sb8.append(" topPos=");
                                                floatValue23 = ((Number) uploadBackgroundView3.topPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                                sb8.append(floatValue23);
                                                kLog5.i("UploadBackgroundView", sb8.toString());
                                                break;
                                            case 7:
                                                floatValue31 = ((Number) uploadBackgroundView3.leftBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                                if (pageX > floatValue31 + 30.0f) {
                                                    float v27 = uploadBackgroundView3.getFlexNode().v();
                                                    floatValue34 = ((Number) uploadBackgroundView3.rightPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                                    if (pageX < v27 - floatValue34) {
                                                        floatValue35 = ((Number) uploadBackgroundView3.topBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                                        floatValue36 = ((Number) uploadBackgroundView3.topPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                                        if (UploadBackgroundViewKt.access$equalOrMoreThan(floatValue35, floatValue36)) {
                                                            float v28 = uploadBackgroundView3.getFlexNode().v() - pageX;
                                                            float v29 = uploadBackgroundView3.getFlexNode().v() - v28;
                                                            floatValue37 = ((Number) uploadBackgroundView3.leftBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                                            float f38 = ((v29 - floatValue37) * uploadBackgroundView3.startHeight) / uploadBackgroundView3.startWidth;
                                                            float t19 = uploadBackgroundView3.getFlexNode().t();
                                                            floatValue38 = ((Number) uploadBackgroundView3.bottomBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                                            float f39 = (t19 - floatValue38) - f38;
                                                            floatValue39 = ((Number) uploadBackgroundView3.topPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                                            if (UploadBackgroundViewKt.access$equalOrMoreThan(f39, floatValue39)) {
                                                                ReadWriteProperty readWriteProperty4 = uploadBackgroundView3.rightBorder$delegate;
                                                                KProperty<?>[] kPropertyArr4 = UploadBackgroundView.$$delegatedProperties;
                                                                readWriteProperty4.setValue(uploadBackgroundView3, kPropertyArr4[7], Float.valueOf(v28));
                                                                uploadBackgroundView3.topBorder$delegate.setValue(uploadBackgroundView3, kPropertyArr4[4], Float.valueOf(f39));
                                                                break;
                                                            } else {
                                                                KLog kLog6 = KLog.INSTANCE;
                                                                StringBuilder sb9 = new StringBuilder();
                                                                sb9.append("moveBorderTopRight error : moveTo=");
                                                                sb9.append(f39);
                                                                sb9.append(" topPos=");
                                                                floatValue40 = ((Number) uploadBackgroundView3.topPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                                                sb9.append(floatValue40);
                                                                kLog6.i("UploadBackgroundView", sb9.toString());
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                KLog kLog7 = KLog.INSTANCE;
                                                StringBuilder sb10 = new StringBuilder();
                                                sb10.append("moveBorderTopRight error : pageX=");
                                                sb10.append(pageX);
                                                sb10.append(" topBorder=");
                                                floatValue32 = ((Number) uploadBackgroundView3.topBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                                sb10.append(floatValue32);
                                                sb10.append(" topPos=");
                                                floatValue33 = ((Number) uploadBackgroundView3.topPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                                sb10.append(floatValue33);
                                                kLog7.i("UploadBackgroundView", sb10.toString());
                                                break;
                                            case 8:
                                                floatValue41 = ((Number) uploadBackgroundView3.leftBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                                if (pageX > floatValue41 + 30.0f) {
                                                    float v36 = uploadBackgroundView3.getFlexNode().v();
                                                    floatValue44 = ((Number) uploadBackgroundView3.rightPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                                    if (pageX < v36 - floatValue44) {
                                                        floatValue45 = ((Number) uploadBackgroundView3.bottomBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                                        floatValue46 = ((Number) uploadBackgroundView3.bottomPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                                        if (UploadBackgroundViewKt.access$equalOrMoreThan(floatValue45, floatValue46)) {
                                                            float v37 = uploadBackgroundView3.getFlexNode().v() - pageX;
                                                            float v38 = uploadBackgroundView3.getFlexNode().v() - v37;
                                                            floatValue47 = ((Number) uploadBackgroundView3.leftBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                                            float f46 = ((v38 - floatValue47) * uploadBackgroundView3.startHeight) / uploadBackgroundView3.startWidth;
                                                            float t26 = uploadBackgroundView3.getFlexNode().t();
                                                            floatValue48 = ((Number) uploadBackgroundView3.topBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                                            float f47 = (t26 - floatValue48) - f46;
                                                            floatValue49 = ((Number) uploadBackgroundView3.bottomPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                                            if (UploadBackgroundViewKt.access$equalOrMoreThan(f47, floatValue49)) {
                                                                ReadWriteProperty readWriteProperty5 = uploadBackgroundView3.rightBorder$delegate;
                                                                KProperty<?>[] kPropertyArr5 = UploadBackgroundView.$$delegatedProperties;
                                                                readWriteProperty5.setValue(uploadBackgroundView3, kPropertyArr5[7], Float.valueOf(v37));
                                                                uploadBackgroundView3.bottomBorder$delegate.setValue(uploadBackgroundView3, kPropertyArr5[5], Float.valueOf(f47));
                                                                break;
                                                            } else {
                                                                KLog kLog8 = KLog.INSTANCE;
                                                                StringBuilder sb11 = new StringBuilder();
                                                                sb11.append("moveBorderBottomRight error : moveTo=");
                                                                sb11.append(f47);
                                                                sb11.append(" bottomPos=");
                                                                floatValue50 = ((Number) uploadBackgroundView3.bottomPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                                                sb11.append(floatValue50);
                                                                kLog8.i("UploadBackgroundView", sb11.toString());
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                KLog kLog9 = KLog.INSTANCE;
                                                StringBuilder sb12 = new StringBuilder();
                                                sb12.append("moveBorderBottomRight error : pageX=");
                                                sb12.append(pageX);
                                                sb12.append(" topBorder=");
                                                floatValue42 = ((Number) uploadBackgroundView3.bottomBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                                sb12.append(floatValue42);
                                                sb12.append(" bottomPos=");
                                                floatValue43 = ((Number) uploadBackgroundView3.bottomPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                                sb12.append(floatValue43);
                                                kLog9.i("UploadBackgroundView", sb12.toString());
                                                break;
                                            case 9:
                                                float v39 = uploadBackgroundView3.getFlexNode().v();
                                                floatValue51 = ((Number) uploadBackgroundView3.rightBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                                if (pageX < (v39 - floatValue51) - 30.0f) {
                                                    floatValue54 = ((Number) uploadBackgroundView3.leftPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                                    if (pageX > floatValue54) {
                                                        floatValue55 = ((Number) uploadBackgroundView3.bottomBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                                        floatValue56 = ((Number) uploadBackgroundView3.bottomPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                                        if (UploadBackgroundViewKt.access$equalOrMoreThan(floatValue55, floatValue56)) {
                                                            float v46 = uploadBackgroundView3.getFlexNode().v();
                                                            floatValue57 = ((Number) uploadBackgroundView3.rightBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                                            float f48 = (((v46 - floatValue57) - pageX) * uploadBackgroundView3.startHeight) / uploadBackgroundView3.startWidth;
                                                            float t27 = uploadBackgroundView3.getFlexNode().t();
                                                            floatValue58 = ((Number) uploadBackgroundView3.topBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                                            float f49 = (t27 - floatValue58) - f48;
                                                            floatValue59 = ((Number) uploadBackgroundView3.bottomPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                                            if (UploadBackgroundViewKt.access$equalOrMoreThan(f49, floatValue59)) {
                                                                ReadWriteProperty readWriteProperty6 = uploadBackgroundView3.leftBorder$delegate;
                                                                KProperty<?>[] kPropertyArr6 = UploadBackgroundView.$$delegatedProperties;
                                                                readWriteProperty6.setValue(uploadBackgroundView3, kPropertyArr6[6], Float.valueOf(pageX));
                                                                uploadBackgroundView3.bottomBorder$delegate.setValue(uploadBackgroundView3, kPropertyArr6[5], Float.valueOf(f49));
                                                                break;
                                                            } else {
                                                                KLog kLog10 = KLog.INSTANCE;
                                                                StringBuilder sb13 = new StringBuilder();
                                                                sb13.append("moveBorderBottomLeft error : moveTo=");
                                                                sb13.append(f49);
                                                                sb13.append(" bottomPos=");
                                                                floatValue60 = ((Number) uploadBackgroundView3.bottomPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                                                sb13.append(floatValue60);
                                                                kLog10.i("UploadBackgroundView", sb13.toString());
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                                KLog kLog11 = KLog.INSTANCE;
                                                StringBuilder sb14 = new StringBuilder();
                                                sb14.append("moveBorderBottomLeft error : pageX=");
                                                sb14.append(pageX);
                                                sb14.append(" topBorder=");
                                                floatValue52 = ((Number) uploadBackgroundView3.bottomBorder$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                                sb14.append(floatValue52);
                                                sb14.append(" bottomPos=");
                                                floatValue53 = ((Number) uploadBackgroundView3.bottomPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                                sb14.append(floatValue53);
                                                kLog11.i("UploadBackgroundView", sb14.toString());
                                                break;
                                        }
                                    } else if (i3 >= 2 && uploadBackgroundView3.previousCounts == 1) {
                                        float pageX2 = touchParams2.c().get(1).getPageX();
                                        float pageY2 = touchParams2.c().get(1).getPageY();
                                        AnonymousClass6.access$invoke$pickEnd(UploadBackgroundView.this);
                                        AnonymousClass6.access$invoke$commonEnd(upLoadBackgroundPage, UploadBackgroundView.this);
                                        UploadBackgroundView uploadBackgroundView4 = UploadBackgroundView.this;
                                        uploadBackgroundView4.chooseObject = 10;
                                        uploadBackgroundView4.startX1 = pageX;
                                        uploadBackgroundView4.startY1 = pageY;
                                        uploadBackgroundView4.startX2 = pageX2;
                                        uploadBackgroundView4.startY2 = pageY2;
                                    } else if (i3 >= 2 && uploadBackgroundView3.previousCounts >= 2) {
                                        float pageX3 = touchParams2.c().get(1).getPageX();
                                        float pageY3 = touchParams2.c().get(1).getPageY();
                                        UploadBackgroundView uploadBackgroundView5 = UploadBackgroundView.this;
                                        float f56 = pageX3 - pageX;
                                        float f57 = pageY - pageY3;
                                        float f58 = uploadBackgroundView5.startX1 - uploadBackgroundView5.startX2;
                                        float f59 = uploadBackgroundView5.startY1 - uploadBackgroundView5.startY2;
                                        float sqrt = (float) Math.sqrt(((f57 * f57) + (f56 * f56)) / ((f59 * f59) + (f58 * f58)));
                                        if (Float.isNaN(sqrt)) {
                                            KLog.INSTANCE.e("UploadBackgroundView", "movePinth percent.isNaN()");
                                            sqrt = 1.0f;
                                        }
                                        float f65 = uploadBackgroundView5.startY1;
                                        float f66 = f65 - ((f65 - uploadBackgroundView5.rememberTopPos) * sqrt);
                                        ReadWriteProperty readWriteProperty7 = uploadBackgroundView5.topPos$delegate;
                                        KProperty<?>[] kPropertyArr7 = UploadBackgroundView.$$delegatedProperties;
                                        readWriteProperty7.setValue(uploadBackgroundView5, kPropertyArr7[0], Float.valueOf(f66));
                                        float f67 = uploadBackgroundView5.startX1;
                                        uploadBackgroundView5.leftPos$delegate.setValue(uploadBackgroundView5, kPropertyArr7[1], Float.valueOf(f67 - ((f67 - uploadBackgroundView5.rememberLeftPos) * sqrt)));
                                        uploadBackgroundView5.bottomPos$delegate.setValue(uploadBackgroundView5, kPropertyArr7[2], Float.valueOf((uploadBackgroundView5.getFlexNode().t() - uploadBackgroundView5.startY1) - (((uploadBackgroundView5.getFlexNode().t() - uploadBackgroundView5.rememberBottomPos) - uploadBackgroundView5.startY1) * sqrt)));
                                        uploadBackgroundView5.rightPos$delegate.setValue(uploadBackgroundView5, kPropertyArr7[3], Float.valueOf((uploadBackgroundView5.getFlexNode().v() - uploadBackgroundView5.startX1) - (((uploadBackgroundView5.getFlexNode().v() - uploadBackgroundView5.rememberRightPos) - uploadBackgroundView5.startX1) * sqrt)));
                                    } else if (i3 == 1 && uploadBackgroundView3.previousCounts >= 2) {
                                        AnonymousClass6.invoke$endPinth(uploadBackgroundView3);
                                        AnonymousClass6.access$invoke$commonStart(UploadBackgroundView.this, pageX, pageY);
                                    }
                                    UploadBackgroundView uploadBackgroundView6 = UploadBackgroundView.this;
                                    uploadBackgroundView6.previousCounts = uploadBackgroundView6.counts;
                                    return Unit.INSTANCE;
                                }
                            });
                            final UploadBackgroundView uploadBackgroundView3 = this.$ctx;
                            final UpLoadBackgroundPage upLoadBackgroundPage2 = this.$page;
                            uVar2.touchUp(new Function1<TouchParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.6.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(TouchParams touchParams) {
                                    UploadBackgroundView uploadBackgroundView4 = UploadBackgroundView.this;
                                    uploadBackgroundView4.previousCounts = uploadBackgroundView4.counts;
                                    uploadBackgroundView4.counts = touchParams.c().size();
                                    AnonymousClass6.access$invoke$pickEnd(UploadBackgroundView.this);
                                    AnonymousClass6.access$invoke$commonEnd(upLoadBackgroundPage2, UploadBackgroundView.this);
                                    UploadBackgroundView uploadBackgroundView5 = UploadBackgroundView.this;
                                    uploadBackgroundView5.opacity$delegate.setValue(uploadBackgroundView5, UploadBackgroundView.$$delegatedProperties[8], Float.valueOf(1.0f));
                                    return Unit.INSTANCE;
                                }
                            });
                            return Unit.INSTANCE;
                        }
                    }

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                tVar.absolutePositionAllZero();
                                return Unit.INSTANCE;
                            }
                        });
                        final String str3 = str2;
                        final UploadBackgroundView uploadBackgroundView2 = uploadBackgroundView;
                        final UpLoadBackgroundPage upLoadBackgroundPage3 = upLoadBackgroundPage2;
                        ah.a(vVar2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageView imageView) {
                                ImageView imageView2 = imageView;
                                final String str4 = str3;
                                final UploadBackgroundView uploadBackgroundView3 = uploadBackgroundView2;
                                imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(af afVar) {
                                        float floatValue;
                                        float floatValue2;
                                        float floatValue3;
                                        float floatValue4;
                                        af afVar2 = afVar;
                                        b.a.a(afVar2, e.INSTANCE.a(str4), false, 2, null);
                                        floatValue = ((Number) r0.topPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                        floatValue2 = ((Number) r1.leftPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                        floatValue3 = ((Number) r2.bottomPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                        floatValue4 = ((Number) r3.rightPos$delegate.getValue(uploadBackgroundView3, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                        afVar2.absolutePosition(floatValue, floatValue2, floatValue3, floatValue4);
                                        afVar2.q();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final UploadBackgroundView uploadBackgroundView4 = uploadBackgroundView2;
                                final UpLoadBackgroundPage upLoadBackgroundPage4 = upLoadBackgroundPage3;
                                imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageEvent imageEvent) {
                                        final UploadBackgroundView uploadBackgroundView5 = UploadBackgroundView.this;
                                        final UpLoadBackgroundPage upLoadBackgroundPage5 = upLoadBackgroundPage4;
                                        imageEvent.i(new Function1<LoadResolutionParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView$body$1$2$2$2$handler$1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(LoadResolutionParams loadResolutionParams) {
                                                float floatValue;
                                                float floatValue2;
                                                float floatValue3;
                                                float floatValue4;
                                                float floatValue5;
                                                float floatValue6;
                                                float floatValue7;
                                                float floatValue8;
                                                float floatValue9;
                                                float floatValue10;
                                                float floatValue11;
                                                float floatValue12;
                                                float floatValue13;
                                                float floatValue14;
                                                float floatValue15;
                                                float floatValue16;
                                                float floatValue17;
                                                float floatValue18;
                                                float floatValue19;
                                                float floatValue20;
                                                float floatValue21;
                                                float floatValue22;
                                                float floatValue23;
                                                float floatValue24;
                                                float floatValue25;
                                                float floatValue26;
                                                float floatValue27;
                                                float floatValue28;
                                                float floatValue29;
                                                float floatValue30;
                                                LoadResolutionParams loadResolutionParams2 = loadResolutionParams;
                                                float g16 = UploadBackgroundView.this.getPagerData().g();
                                                float h16 = UploadBackgroundView.this.getPagerData().h();
                                                float f16 = g16 / h16;
                                                float f17 = UploadBackgroundView.access$getAttr(UploadBackgroundView.this).viewHeight;
                                                float f18 = UploadBackgroundView.access$getAttr(UploadBackgroundView.this).viewWidth;
                                                floatValue = ((Number) r4.topBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                                floatValue2 = ((Number) r5.bottomBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                                float f19 = (f17 - floatValue) - floatValue2;
                                                float f26 = f19 / f16;
                                                float f27 = 2;
                                                float f28 = (h16 - f26) / f27;
                                                r6.leftBorder$delegate.setValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[6], Float.valueOf(f28));
                                                r6.rightBorder$delegate.setValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[7], Float.valueOf(f28));
                                                UploadBackgroundView.this.imageWidth = loadResolutionParams2.getWidth();
                                                UploadBackgroundView.this.imageHeight = loadResolutionParams2.getHeight();
                                                KLog kLog = KLog.INSTANCE;
                                                kLog.i("UploadBackgroundView", "screenWidth=" + h16 + " borderWidth=" + f26 + " borderHeight=" + f19 + " screenPercent=" + f16 + " layoutHeight=" + f17);
                                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("W H: ");
                                                m3.append(UploadBackgroundView.this.imageWidth);
                                                m3.append(';');
                                                m3.append(UploadBackgroundView.this.imageHeight);
                                                m3.append(" leftBorder:rightBorder: ");
                                                floatValue3 = ((Number) r6.leftBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                                m3.append(floatValue3);
                                                m3.append(';');
                                                floatValue4 = ((Number) r5.rightBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                                m3.append(floatValue4);
                                                kLog.i("UploadBackgroundView", m3.toString());
                                                UpLoadBackgroundPage upLoadBackgroundPage6 = upLoadBackgroundPage5;
                                                UploadBackgroundView uploadBackgroundView6 = UploadBackgroundView.this;
                                                float f29 = uploadBackgroundView6.imageHeight;
                                                upLoadBackgroundPage6.imageHeightOrigin = f29;
                                                float f36 = uploadBackgroundView6.imageWidth;
                                                upLoadBackgroundPage6.imageWeightOrigin = f36;
                                                float f37 = f19 / f29;
                                                uploadBackgroundView6.imageHeight = f29 * f37;
                                                uploadBackgroundView6.imageWidth = f36 * f37;
                                                uploadBackgroundView6.imagePercent = f37;
                                                while (true) {
                                                    UploadBackgroundView uploadBackgroundView7 = UploadBackgroundView.this;
                                                    float f38 = uploadBackgroundView7.imageWidth;
                                                    floatValue5 = ((Number) uploadBackgroundView7.leftBorder$delegate.getValue(uploadBackgroundView7, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                                    floatValue6 = ((Number) r1.rightBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                                    if (f38 < (f18 - floatValue5) - floatValue6) {
                                                        UploadBackgroundView uploadBackgroundView8 = UploadBackgroundView.this;
                                                        uploadBackgroundView8.imageWidth *= 1.01f;
                                                        uploadBackgroundView8.imageHeight *= 1.01f;
                                                        uploadBackgroundView8.imagePercent *= 1.01f;
                                                    } else {
                                                        UploadBackgroundView uploadBackgroundView9 = UploadBackgroundView.this;
                                                        float f39 = 5;
                                                        uploadBackgroundView9.topPos$delegate.setValue(uploadBackgroundView9, UploadBackgroundView.$$delegatedProperties[0], Float.valueOf(((f17 - uploadBackgroundView9.imageHeight) * 3) / f39));
                                                        UploadBackgroundView uploadBackgroundView10 = UploadBackgroundView.this;
                                                        uploadBackgroundView10.bottomPos$delegate.setValue(uploadBackgroundView10, UploadBackgroundView.$$delegatedProperties[2], Float.valueOf(((f17 - uploadBackgroundView10.imageHeight) * f27) / f39));
                                                        UploadBackgroundView uploadBackgroundView11 = UploadBackgroundView.this;
                                                        uploadBackgroundView11.leftPos$delegate.setValue(uploadBackgroundView11, UploadBackgroundView.$$delegatedProperties[1], Float.valueOf((f18 - uploadBackgroundView11.imageWidth) / f27));
                                                        UploadBackgroundView uploadBackgroundView12 = UploadBackgroundView.this;
                                                        uploadBackgroundView12.rightPos$delegate.setValue(uploadBackgroundView12, UploadBackgroundView.$$delegatedProperties[3], Float.valueOf((f18 - uploadBackgroundView12.imageWidth) / f27));
                                                        UploadBackgroundView uploadBackgroundView13 = UploadBackgroundView.this;
                                                        floatValue7 = ((Number) uploadBackgroundView13.leftPos$delegate.getValue(uploadBackgroundView13, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                                        uploadBackgroundView13.rememberLeftPos = floatValue7;
                                                        UploadBackgroundView uploadBackgroundView14 = UploadBackgroundView.this;
                                                        floatValue8 = ((Number) uploadBackgroundView14.bottomPos$delegate.getValue(uploadBackgroundView14, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                                        uploadBackgroundView14.rememberBottomPos = floatValue8;
                                                        UploadBackgroundView uploadBackgroundView15 = UploadBackgroundView.this;
                                                        floatValue9 = ((Number) uploadBackgroundView15.rightPos$delegate.getValue(uploadBackgroundView15, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                                        uploadBackgroundView15.rememberRightPos = floatValue9;
                                                        UploadBackgroundView uploadBackgroundView16 = UploadBackgroundView.this;
                                                        floatValue10 = ((Number) uploadBackgroundView16.topPos$delegate.getValue(uploadBackgroundView16, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                                        uploadBackgroundView16.rememberTopPos = floatValue10;
                                                        UploadBackgroundView uploadBackgroundView17 = UploadBackgroundView.this;
                                                        floatValue11 = ((Number) uploadBackgroundView17.leftPos$delegate.getValue(uploadBackgroundView17, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                                        uploadBackgroundView17.originLeftPos = floatValue11;
                                                        UploadBackgroundView uploadBackgroundView18 = UploadBackgroundView.this;
                                                        floatValue12 = ((Number) uploadBackgroundView18.bottomPos$delegate.getValue(uploadBackgroundView18, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                                        uploadBackgroundView18.originBottomPos = floatValue12;
                                                        UploadBackgroundView uploadBackgroundView19 = UploadBackgroundView.this;
                                                        floatValue13 = ((Number) uploadBackgroundView19.rightPos$delegate.getValue(uploadBackgroundView19, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                                        uploadBackgroundView19.originRightPos = floatValue13;
                                                        UploadBackgroundView uploadBackgroundView20 = UploadBackgroundView.this;
                                                        floatValue14 = ((Number) uploadBackgroundView20.topPos$delegate.getValue(uploadBackgroundView20, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                                        uploadBackgroundView20.originTopPos = floatValue14;
                                                        UpLoadBackgroundPage upLoadBackgroundPage7 = upLoadBackgroundPage5;
                                                        float f46 = upLoadBackgroundPage7.imageWeightOrigin;
                                                        floatValue15 = ((Number) r1.leftBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                                        floatValue16 = ((Number) r4.leftPos$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                                        float f47 = (floatValue15 - floatValue16) * f46;
                                                        floatValue17 = ((Number) r0.leftPos$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                                        floatValue18 = ((Number) r4.rightPos$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                                        upLoadBackgroundPage7.subImageLeft = f47 / ((f18 - floatValue17) - floatValue18);
                                                        UpLoadBackgroundPage upLoadBackgroundPage8 = upLoadBackgroundPage5;
                                                        float f48 = upLoadBackgroundPage8.imageWeightOrigin;
                                                        floatValue19 = ((Number) r1.rightBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                                        floatValue20 = ((Number) r4.rightPos$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                                        float f49 = (floatValue19 - floatValue20) * f48;
                                                        floatValue21 = ((Number) r0.rightPos$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[3])).floatValue();
                                                        float f56 = f18 - floatValue21;
                                                        floatValue22 = ((Number) r0.leftPos$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[1])).floatValue();
                                                        upLoadBackgroundPage8.subImageRight = f49 / (f56 - floatValue22);
                                                        UpLoadBackgroundPage upLoadBackgroundPage9 = upLoadBackgroundPage5;
                                                        float f57 = upLoadBackgroundPage9.imageHeightOrigin;
                                                        floatValue23 = ((Number) r1.bottomBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                                        floatValue24 = ((Number) r3.bottomPos$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                                        float f58 = (floatValue23 - floatValue24) * f57;
                                                        floatValue25 = ((Number) r0.topPos$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                                        floatValue26 = ((Number) r3.bottomPos$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                                        upLoadBackgroundPage9.subImageBottom = f58 / ((f17 - floatValue25) - floatValue26);
                                                        UpLoadBackgroundPage upLoadBackgroundPage10 = upLoadBackgroundPage5;
                                                        float f59 = upLoadBackgroundPage10.imageHeightOrigin;
                                                        floatValue27 = ((Number) r1.topBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                                        floatValue28 = ((Number) r3.topPos$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                                        float f65 = (floatValue27 - floatValue28) * f59;
                                                        floatValue29 = ((Number) r0.topPos$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[0])).floatValue();
                                                        float f66 = f17 - floatValue29;
                                                        floatValue30 = ((Number) r0.bottomPos$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[2])).floatValue();
                                                        upLoadBackgroundPage10.subImageTop = f65 / (f66 - floatValue30);
                                                        return Unit.INSTANCE;
                                                    }
                                                }
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        AnonymousClass3 anonymousClass3 = new Function1<CanvasView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(CanvasView canvasView) {
                                canvasView.attr(new Function1<Attr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Attr attr) {
                                        attr.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        };
                        final UploadBackgroundView uploadBackgroundView3 = uploadBackgroundView;
                        CanvasViewKt.a(vVar2, anonymousClass3, new Function3<p, Float, Float, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.4
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(p pVar, Float f16, Float f17) {
                                float floatValue;
                                float floatValue2;
                                float floatValue3;
                                float floatValue4;
                                float floatValue5;
                                float floatValue6;
                                float floatValue7;
                                float floatValue8;
                                float floatValue9;
                                float floatValue10;
                                float floatValue11;
                                float floatValue12;
                                float floatValue13;
                                float floatValue14;
                                float floatValue15;
                                float floatValue16;
                                float floatValue17;
                                float floatValue18;
                                float floatValue19;
                                float floatValue20;
                                float floatValue21;
                                float floatValue22;
                                float floatValue23;
                                float floatValue24;
                                float floatValue25;
                                float floatValue26;
                                float floatValue27;
                                float floatValue28;
                                float floatValue29;
                                float floatValue30;
                                float floatValue31;
                                float floatValue32;
                                float floatValue33;
                                float floatValue34;
                                float floatValue35;
                                float floatValue36;
                                float floatValue37;
                                float floatValue38;
                                p pVar2 = pVar;
                                float floatValue39 = f16.floatValue();
                                float floatValue40 = f17.floatValue();
                                pVar2.b();
                                UploadBackgroundView.Companion.getClass();
                                pVar2.n(UploadBackgroundView.MOVE_LINE_COLOR);
                                pVar2.j(1.0f);
                                floatValue = ((Number) r0.leftBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                floatValue2 = ((Number) r1.topBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                pVar2.k(floatValue, floatValue2);
                                floatValue3 = ((Number) r0.rightBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                floatValue4 = ((Number) r1.topBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                pVar2.i(floatValue39 - floatValue3, floatValue4);
                                floatValue5 = ((Number) r0.rightBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                floatValue6 = ((Number) r1.bottomBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                pVar2.i(floatValue39 - floatValue5, floatValue40 - floatValue6);
                                floatValue7 = ((Number) r0.leftBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                floatValue8 = ((Number) r1.bottomBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                pVar2.i(floatValue7, floatValue40 - floatValue8);
                                floatValue9 = ((Number) r0.leftBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                floatValue10 = ((Number) r1.topBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                pVar2.i(floatValue9, floatValue10);
                                pVar2.m();
                                pVar2.c();
                                pVar2.b();
                                floatValue11 = ((Number) r0.leftBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                floatValue12 = ((Number) r1.topBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                pVar2.k(floatValue11, floatValue12 + 5.0f);
                                pVar2.j(3.0f);
                                floatValue13 = ((Number) r0.leftBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                floatValue14 = ((Number) r1.topBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                pVar2.i(floatValue13, floatValue14);
                                floatValue15 = ((Number) r0.leftBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                floatValue16 = ((Number) r1.topBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                pVar2.i(floatValue15 + 5.0f, floatValue16);
                                floatValue17 = ((Number) r0.rightBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                floatValue18 = ((Number) r1.topBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                pVar2.k((floatValue39 - floatValue17) - 5.0f, floatValue18);
                                floatValue19 = ((Number) r0.rightBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                floatValue20 = ((Number) r1.topBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                pVar2.i(floatValue39 - floatValue19, floatValue20);
                                floatValue21 = ((Number) r0.rightBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                floatValue22 = ((Number) r1.topBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                pVar2.i(floatValue39 - floatValue21, floatValue22 + 5.0f);
                                floatValue23 = ((Number) r0.rightBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                floatValue24 = ((Number) r1.bottomBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                pVar2.k(floatValue39 - floatValue23, (floatValue40 - floatValue24) - 5.0f);
                                floatValue25 = ((Number) r0.rightBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                floatValue26 = ((Number) r1.bottomBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                pVar2.i(floatValue39 - floatValue25, floatValue40 - floatValue26);
                                floatValue27 = ((Number) r0.rightBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                floatValue28 = ((Number) r1.bottomBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                pVar2.i((floatValue39 - floatValue27) - 5.0f, floatValue40 - floatValue28);
                                floatValue29 = ((Number) r0.leftBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                floatValue30 = ((Number) r1.bottomBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                pVar2.k(floatValue29 + 5.0f, floatValue40 - floatValue30);
                                floatValue31 = ((Number) r0.leftBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                floatValue32 = ((Number) r1.bottomBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                pVar2.i(floatValue31, floatValue40 - floatValue32);
                                floatValue33 = ((Number) r0.leftBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                floatValue34 = ((Number) r1.bottomBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                pVar2.i(floatValue33, (floatValue40 - floatValue34) - 5.0f);
                                pVar2.k(0.0f, 0.0f);
                                pVar2.m();
                                pVar2.c();
                                KLog kLog = KLog.INSTANCE;
                                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("page:");
                                m3.append(UploadBackgroundView.this.getPagerData().m());
                                m3.append(':');
                                m3.append(UploadBackgroundView.this.getPagerData().l());
                                m3.append(" width=");
                                m3.append(floatValue39);
                                m3.append(" height=");
                                m3.append(floatValue40);
                                m3.append(" topBorder=");
                                floatValue35 = ((Number) r5.topBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                m3.append(floatValue35);
                                m3.append(" bottomBorder=");
                                floatValue36 = ((Number) r5.bottomBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                m3.append(floatValue36);
                                m3.append(" leftBorder=");
                                floatValue37 = ((Number) r5.leftBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                m3.append(floatValue37);
                                m3.append(" rightBorder=");
                                floatValue38 = ((Number) r5.rightBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                m3.append(floatValue38);
                                kLog.i("UploadBackgroundView", m3.toString());
                                return Unit.INSTANCE;
                            }
                        });
                        final UploadBackgroundView uploadBackgroundView4 = uploadBackgroundView;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final UploadBackgroundView uploadBackgroundView5 = UploadBackgroundView.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        float floatValue;
                                        float floatValue2;
                                        float floatValue3;
                                        float floatValue4;
                                        t tVar2 = tVar;
                                        tVar2.absolutePositionAllZero();
                                        floatValue = ((Number) r0.topBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[4])).floatValue();
                                        tVar2.m150top(floatValue + 4.0f);
                                        floatValue2 = ((Number) r0.rightBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                        tVar2.m149right(floatValue2 + 2.0f);
                                        floatValue3 = ((Number) r0.leftBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                        tVar2.m142left(floatValue3 + 2.0f);
                                        floatValue4 = ((Number) r0.bottomBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[5])).floatValue();
                                        tVar2.m138bottom(floatValue4 + 4.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (QQUtils.INSTANCE.compare("9.0.30") >= 0) {
                                    final UploadBackgroundView uploadBackgroundView6 = UploadBackgroundView.this;
                                    vVar4.addChild(new VasLottieAnimationView(), new Function1<VasLottieAnimationView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.5.2
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(VasLottieAnimationView vasLottieAnimationView) {
                                            VasLottieAnimationView vasLottieAnimationView2 = vasLottieAnimationView;
                                            final UploadBackgroundView uploadBackgroundView7 = UploadBackgroundView.this;
                                            vasLottieAnimationView2.ref(vasLottieAnimationView2, new Function1<aa<VasLottieAnimationView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.5.2.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(aa<VasLottieAnimationView> aaVar) {
                                                    UploadBackgroundView.this.lottieView = aaVar.b();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final UploadBackgroundView uploadBackgroundView8 = UploadBackgroundView.this;
                                            vasLottieAnimationView2.attr(new Function1<LottieAnimationAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.5.2.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(LottieAnimationAttr lottieAnimationAttr) {
                                                    float floatValue;
                                                    LottieAnimationAttr lottieAnimationAttr2 = lottieAnimationAttr;
                                                    lottieAnimationAttr2.absolutePositionAllZero();
                                                    floatValue = ((Number) r0.opacity$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[8])).floatValue();
                                                    lottieAnimationAttr2.m147opacity(floatValue);
                                                    lottieAnimationAttr2.with("repeatCount", -1);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                } else {
                                    final UploadBackgroundView uploadBackgroundView7 = UploadBackgroundView.this;
                                    vVar4.addChild(new VasLottieView(), new Function1<VasLottieView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.5.3
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(VasLottieView vasLottieView) {
                                            VasLottieView vasLottieView2 = vasLottieView;
                                            final UploadBackgroundView uploadBackgroundView8 = UploadBackgroundView.this;
                                            vasLottieView2.ref(vasLottieView2, new Function1<aa<VasLottieView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.5.3.1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(aa<VasLottieView> aaVar) {
                                                    UploadBackgroundView.this.lottieView = aaVar.b();
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final UploadBackgroundView uploadBackgroundView9 = UploadBackgroundView.this;
                                            vasLottieView2.attr(new Function1<LottieAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.5.3.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(LottieAttr lottieAttr) {
                                                    float floatValue;
                                                    LottieAttr lottieAttr2 = lottieAttr;
                                                    lottieAttr2.absolutePositionAllZero();
                                                    floatValue = ((Number) r0.opacity$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[8])).floatValue();
                                                    lottieAttr2.m147opacity(floatValue);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            return Unit.INSTANCE;
                                        }
                                    });
                                }
                                final UploadBackgroundView uploadBackgroundView8 = UploadBackgroundView.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.5.4
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final UploadBackgroundView uploadBackgroundView9 = UploadBackgroundView.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView.body.1.2.5.4.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                float floatValue;
                                                float floatValue2;
                                                float floatValue3;
                                                af afVar2 = afVar;
                                                afVar2.absolutePositionAllZero();
                                                float m3 = UploadBackgroundView.this.getPagerData().m();
                                                floatValue = ((Number) r1.rightBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[7])).floatValue();
                                                float f16 = m3 - floatValue;
                                                floatValue2 = ((Number) r1.leftBorder$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[6])).floatValue();
                                                afVar2.mo141height(((f16 - floatValue2) - 6.0f) / 2);
                                                b.a.b(afVar2, "https://tianquan.gtimg.cn/shoal/qqgxh/8ea26ceb-4f67-4a21-88f0-beb3459a63da.png", false, 2, null);
                                                floatValue3 = ((Number) r0.opacity$delegate.getValue(UploadBackgroundView.this, UploadBackgroundView.$$delegatedProperties[8])).floatValue();
                                                afVar2.m147opacity(floatValue3);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        vVar2.event(new AnonymousClass6(uploadBackgroundView, upLoadBackgroundPage2));
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new UploadBackgroundAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ViewContainer, com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void createRenderView() {
        super.createRenderView();
        ReactiveObserver.INSTANCE.b(Integer.valueOf(((UploadBackgroundAttr) getAttr()).getItemId()), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView$createRenderView$1
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r15v14, types: [com.tencent.kuikly.core.base.Attr] */
            /* JADX WARN: Type inference failed for: r15v23, types: [com.tencent.kuikly.core.base.Attr] */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                String str;
                ?? viewAttr;
                ?? viewAttr2;
                bool.booleanValue();
                if (UploadBackgroundView.this.lottieView != null) {
                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("colorScreen.");
                    if (UploadBackgroundView.this.getPagerData().getIsAndroid()) {
                        str = "android";
                    } else {
                        str = "ios";
                    }
                    m3.append(str);
                    m3.append('.');
                    m3.append(UploadBackgroundView.access$getAttr(UploadBackgroundView.this).getItemId());
                    final String sb5 = m3.toString();
                    UploadBackgroundView.this.page.platformApi.getVasModule().$$delegate_7.updateSystem.getClass();
                    KLog kLog = KLog.INSTANCE;
                    kLog.i("UpdateSystem", "getUpdateSystemFile 22 - " + sb5);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append(22L);
                    sb6.append(QbAddrData.DATA_SPLITER);
                    sb6.append(sb5);
                    String sb7 = sb6.toString();
                    VasModule.Companion companion = VasModule.Companion;
                    final String bVar = companion.getInstance().toNative(false, "getUpdateSystemFile", sb7, null, true).toString();
                    UploadBackgroundView.this.page.platformApi.getVasModule().$$delegate_7.updateSystem.getClass();
                    kLog.i("UpdateSystem", "isUpdateSystemFileExists 22 - " + sb5);
                    StringBuilder sb8 = new StringBuilder();
                    sb8.append(22L);
                    sb8.append(QbAddrData.DATA_SPLITER);
                    sb8.append(sb5);
                    boolean areEqual = Intrinsics.areEqual(companion.getInstance().toNative(false, "isUpdateSystemFileExists", sb8.toString(), null, true).toString(), "true");
                    DeclarativeBaseView<?, ?> declarativeBaseView = UploadBackgroundView.this.lottieView;
                    if (declarativeBaseView instanceof VasLottieAnimationView) {
                        Intrinsics.checkNotNull(declarativeBaseView, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.vas_base.views.VasLottieAnimationView");
                        final VasLottieAnimationView vasLottieAnimationView = (VasLottieAnimationView) declarativeBaseView;
                        final LottieAnimationAttr lottieAnimationAttr = (LottieAnimationAttr) vasLottieAnimationView.getViewAttr();
                        if (UploadBackgroundView.access$getAttr(UploadBackgroundView.this).getItemId() == 0) {
                            vasLottieAnimationView.performTaskWhenRenderViewDidLoad(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.views.VasLottieAnimationView$cancelAnimation$1
                                {
                                    super(0);
                                }

                                @Override // kotlin.jvm.functions.Function0
                                public final Unit invoke() {
                                    RenderView renderView = VasLottieAnimationView.this.getRenderView();
                                    if (renderView != null) {
                                        RenderView.b(renderView, "cancelAnimation", null, null, 6, null);
                                    }
                                    return Unit.INSTANCE;
                                }
                            });
                            DeclarativeBaseView<?, ?> declarativeBaseView2 = UploadBackgroundView.this.lottieView;
                            if (declarativeBaseView2 != null && (viewAttr2 = declarativeBaseView2.getViewAttr()) != 0) {
                                viewAttr2.m152visibility(false);
                            }
                        } else {
                            lottieAnimationAttr.m152visibility(true);
                            if (areEqual) {
                                lottieAnimationAttr.with("animationFromFile", bVar + "/fullscreen.json");
                                lottieAnimationAttr.with("imagePath", bVar + "/images");
                                vasLottieAnimationView.performTaskWhenRenderViewDidLoad(new VasLottieAnimationView$playAnimation$1(vasLottieAnimationView));
                            } else {
                                UpdateSystem updateSystem = UploadBackgroundView.this.page.platformApi.getVasModule().$$delegate_7.updateSystem;
                                final UploadBackgroundView uploadBackgroundView = UploadBackgroundView.this;
                                updateSystem.downloadUpdateSystem(sb5, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView$createRenderView$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool2) {
                                        String str2;
                                        boolean booleanValue = bool2.booleanValue();
                                        String str3 = sb5;
                                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("colorScreen.");
                                        if (uploadBackgroundView.getPagerData().getIsAndroid()) {
                                            str2 = "android";
                                        } else {
                                            str2 = "ios";
                                        }
                                        m16.append(str2);
                                        m16.append('.');
                                        m16.append(UploadBackgroundView.access$getAttr(uploadBackgroundView).getItemId());
                                        if (Intrinsics.areEqual(str3, m16.toString())) {
                                            if (booleanValue) {
                                                lottieAnimationAttr.with("animationFromFile", bVar + "/fullscreen.json");
                                                lottieAnimationAttr.with("imagePath", bVar + "/images");
                                                VasLottieAnimationView vasLottieAnimationView2 = vasLottieAnimationView;
                                                vasLottieAnimationView2.getClass();
                                                vasLottieAnimationView2.performTaskWhenRenderViewDidLoad(new VasLottieAnimationView$playAnimation$1(vasLottieAnimationView2));
                                            } else {
                                                KLog.INSTANCE.e(uploadBackgroundView.page.getPageName(), "download effect error");
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                        }
                    } else if (declarativeBaseView instanceof VasLottieView) {
                        Intrinsics.checkNotNull(declarativeBaseView, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.vas_base.views.VasLottieView");
                        final LottieAttr lottieAttr = (LottieAttr) ((VasLottieView) declarativeBaseView).getViewAttr();
                        if (UploadBackgroundView.access$getAttr(UploadBackgroundView.this).getItemId() == 0) {
                            DeclarativeBaseView<?, ?> declarativeBaseView3 = UploadBackgroundView.this.lottieView;
                            if (declarativeBaseView3 != null && (viewAttr = declarativeBaseView3.getViewAttr()) != 0) {
                                viewAttr.m152visibility(false);
                            }
                        } else {
                            lottieAttr.m152visibility(true);
                            if (areEqual) {
                                lottieAttr.with("jsonPath", bVar + "/fullscreen.json");
                                lottieAttr.with("imagePath", bVar + "/images");
                            } else {
                                UpdateSystem updateSystem2 = UploadBackgroundView.this.page.platformApi.getVasModule().$$delegate_7.updateSystem;
                                final UploadBackgroundView uploadBackgroundView2 = UploadBackgroundView.this;
                                updateSystem2.downloadUpdateSystem(sb5, new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_pages.upload_background.UploadBackgroundView$createRenderView$1.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool2) {
                                        String str2;
                                        boolean booleanValue = bool2.booleanValue();
                                        String str3 = sb5;
                                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("colorScreen.");
                                        if (uploadBackgroundView2.getPagerData().getIsAndroid()) {
                                            str2 = "android";
                                        } else {
                                            str2 = "ios";
                                        }
                                        m16.append(str2);
                                        m16.append('.');
                                        m16.append(UploadBackgroundView.access$getAttr(uploadBackgroundView2).getItemId());
                                        if (Intrinsics.areEqual(str3, m16.toString())) {
                                            if (booleanValue) {
                                                lottieAttr.with("jsonPath", bVar + "/fullscreen.json");
                                                lottieAttr.with("imagePath", bVar + "/images");
                                            } else {
                                                KLog.INSTANCE.e(uploadBackgroundView2.page.getPageName(), "download effect error");
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }
}
