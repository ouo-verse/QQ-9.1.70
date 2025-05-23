package com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.view.OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyProKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.BDHService;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.ClickLocation;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.LongPressParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import d45.a;
import defpackage.k;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import n35.v;
import n35.w;
import n35.z;
import p35.ag;
import p35.n;

/* loaded from: classes31.dex */
public final class NBPArticleFeedImageView extends ComposeView<NBPArticleFeedImageViewAttr, NBPArticleFeedImageViewEvent> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM = ((NBPArticleFeedImageViewAttr) getAttr()).f114202vm;
        final NBPArticleFeedModel nBPArticleFeedModel = null;
        if (nBPArticleFeedDetailVM == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vm");
            nBPArticleFeedDetailVM = null;
        }
        NBPArticleFeedModel nBPArticleFeedModel2 = ((NBPArticleFeedImageViewAttr) getAttr()).feedModel;
        if (nBPArticleFeedModel2 != null) {
            nBPArticleFeedModel = nBPArticleFeedModel2;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("feedModel");
        }
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedImageView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPArticleFeedModel nBPArticleFeedModel3 = NBPArticleFeedModel.this;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedImageView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        Pair<Float, Float> pair = NBPArticleFeedModel.this.coverSize;
                        mVar2.size(pair.getFirst().floatValue(), pair.getSecond().floatValue());
                        mVar2.marginTop(12.0f);
                        mVar2.marginLeft(16.0f);
                        mVar2.marginRight(16.0f);
                        mVar2.borderRadius(4.0f);
                        mVar2.mo113backgroundColor(new h(211, 211, 211, 0.3f));
                        mVar2.overflow(true);
                        return Unit.INSTANCE;
                    }
                });
                final NBPArticleFeedModel nBPArticleFeedModel4 = NBPArticleFeedModel.this;
                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM2 = nBPArticleFeedDetailVM;
                final NBPArticleFeedImageView nBPArticleFeedImageView = this;
                ah.a(viewContainer2, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedImageView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ImageView imageView) {
                        ImageView imageView2 = imageView;
                        final int nativeRef = imageView2.getNativeRef();
                        final NBPArticleFeedModel nBPArticleFeedModel5 = NBPArticleFeedModel.this;
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM3 = nBPArticleFeedDetailVM2;
                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedImageView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(af afVar) {
                                Pair<Float, Float> pair;
                                List<ag> list;
                                Object firstOrNull;
                                Pair<Float, Float> pair2;
                                Pair<Float, Float> pair3;
                                float coerceAtLeast;
                                float coerceAtLeast2;
                                af afVar2 = afVar;
                                NBPArticleFeedModel nBPArticleFeedModel6 = NBPArticleFeedModel.this;
                                if (nBPArticleFeedModel6.isHeadFeed && (pair = nBPArticleFeedDetailVM3.firstFeedImageSize) != null) {
                                    Intrinsics.checkNotNull(pair);
                                } else {
                                    float m3 = afVar2.getPagerData().m();
                                    float dpScaleDensity = PageDataExtKt.getDpScaleDensity(afVar2.getPagerData());
                                    n feed = nBPArticleFeedModel6.getFeed();
                                    if (feed != null && (list = feed.f425198m) != null) {
                                        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                                        if (((ag) firstOrNull) != null) {
                                            float f16 = m3 - 32;
                                            if (nBPArticleFeedModel6.appId == 2) {
                                                pair2 = new Pair<>(Float.valueOf(f16), Float.valueOf((f16 / 3) * 4));
                                            } else {
                                                pair2 = new Pair<>(Float.valueOf(f16), Float.valueOf(f16));
                                                try {
                                                    float f17 = r6.f425142h / dpScaleDensity;
                                                    float f18 = r6.f425141f / dpScaleDensity;
                                                    float f19 = 0.42f * f16;
                                                    if (f17 >= f19 || f18 >= f19) {
                                                        float f26 = f17 / f18;
                                                        if (f26 >= 3.0f) {
                                                            pair3 = new Pair<>(Float.valueOf(f16), Float.valueOf(f19));
                                                        } else {
                                                            float f27 = f18 / f17;
                                                            if (f27 >= 3.0f) {
                                                                pair = new Pair<>(Float.valueOf(f19), Float.valueOf(f19 * f27));
                                                            } else {
                                                                if (!(f17 > f18)) {
                                                                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(f26 * f16, f19);
                                                                    pair3 = new Pair<>(Float.valueOf(coerceAtLeast), Float.valueOf(f16));
                                                                } else {
                                                                    Float valueOf = Float.valueOf(f16);
                                                                    coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(f16 / f26, f19);
                                                                    pair3 = new Pair<>(valueOf, Float.valueOf(coerceAtLeast2));
                                                                }
                                                            }
                                                        }
                                                        pair = pair3;
                                                    } else {
                                                        pair = new Pair<>(Float.valueOf(f19), Float.valueOf(f19));
                                                    }
                                                } catch (Throwable th5) {
                                                    AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("e: ", th5, KLog.INSTANCE, "getCoverSize");
                                                }
                                            }
                                            pair = pair2;
                                        }
                                    }
                                    pair = nBPArticleFeedModel6.coverSize;
                                }
                                afVar2.size(pair.getFirst().floatValue(), pair.getSecond().floatValue());
                                afVar2.p();
                                int i3 = nBPArticleFeedDetailVM3.appId;
                                if (i3 == 2) {
                                    Object imageUrl = NBPArticleFeedModel.this.getImageUrl();
                                    Intrinsics.checkNotNull(imageUrl, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqntv2.richmedia.richmedia.IndexNode");
                                    NearbyProKtxKt.srcWithIndexNode(afVar2, (v) imageUrl);
                                } else if (i3 == 1) {
                                    Object imageUrl2 = NBPArticleFeedModel.this.getImageUrl();
                                    Intrinsics.checkNotNull(imageUrl2, "null cannot be cast to non-null type kotlin.String");
                                    b.a.b(afVar2, (String) imageUrl2, false, 2, null);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPArticleFeedDetailVM nBPArticleFeedDetailVM4 = nBPArticleFeedDetailVM2;
                        final NBPArticleFeedModel nBPArticleFeedModel6 = NBPArticleFeedModel.this;
                        final NBPArticleFeedImageView nBPArticleFeedImageView2 = nBPArticleFeedImageView;
                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedImageView.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ImageEvent imageEvent) {
                                ImageEvent imageEvent2 = imageEvent;
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM5 = NBPArticleFeedDetailVM.this;
                                final NBPArticleFeedModel nBPArticleFeedModel7 = nBPArticleFeedModel6;
                                final int i3 = nativeRef;
                                imageEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedImageView.body.1.2.2.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Code restructure failed: missing block: B:27:0x0093, code lost:
                                    
                                        if ((r3.length() > 0) == true) goto L37;
                                     */
                                    /* JADX WARN: Removed duplicated region for block: B:24:0x008a  */
                                    /* JADX WARN: Removed duplicated region for block: B:29:0x0099  */
                                    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
                                    /* JADX WARN: Removed duplicated region for block: B:39:0x00c7  */
                                    /* JADX WARN: Removed duplicated region for block: B:40:0x00d4  */
                                    /* JADX WARN: Removed duplicated region for block: B:43:0x00a8  */
                                    @Override // kotlin.jvm.functions.Function1
                                    /*
                                        Code decompiled incorrectly, please refer to instructions dump.
                                    */
                                    public final Unit invoke(ClickParams clickParams) {
                                        Object firstOrNull;
                                        v vVar;
                                        String decodeToString;
                                        String str;
                                        w wVar;
                                        v vVar2;
                                        List<z> list;
                                        Object firstOrNull2;
                                        z zVar;
                                        byte[] d16;
                                        List<z> list2;
                                        Object firstOrNull3;
                                        NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = NBPArticleFeedDetailVM.this;
                                        NBPArticleFeedModel nBPArticleFeedModel8 = nBPArticleFeedModel7;
                                        final int i16 = i3;
                                        nBPArticleFeedDetailVM6.getClass();
                                        if (nBPArticleFeedModel8.isHeadFeed) {
                                            n feed = nBPArticleFeedModel8.getFeed();
                                            if (feed != null) {
                                                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) feed.f425198m);
                                                final ag agVar = (ag) firstOrNull;
                                                if (agVar != null) {
                                                    KLog kLog = KLog.INSTANCE;
                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onContentPicClick HeadFeed: ");
                                                    m3.append(nBPArticleFeedDetailVM6.appId);
                                                    m3.append(", ");
                                                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, nBPArticleFeedDetailVM6.feedId, kLog, "NBPArticleFeedDetailVM");
                                                    final QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                                                    int i17 = nBPArticleFeedDetailVM6.appId;
                                                    final String str2 = nBPArticleFeedDetailVM6.feedId;
                                                    companion.getClass();
                                                    boolean z16 = true;
                                                    if (i17 != 1) {
                                                        if (i17 == 2) {
                                                            w wVar2 = agVar.f425139d;
                                                            if (wVar2 != null && (list2 = wVar2.f418273d) != null) {
                                                                firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                                                                z zVar2 = (z) firstOrNull3;
                                                                if (zVar2 != null) {
                                                                    vVar = zVar2.f418280d;
                                                                    decodeToString = (vVar != null || (d16 = i.d(vVar)) == null) ? null : StringsKt__StringsJVMKt.decodeToString(a.b(d16));
                                                                    if (decodeToString != null) {
                                                                    }
                                                                    z16 = false;
                                                                    if (!z16) {
                                                                        StringBuilder sb5 = new StringBuilder();
                                                                        NearbyConst nearbyConst = NearbyConst.INSTANCE;
                                                                        str = OpenQZoneSheetKt$OpenQZoneSheet$2$1$2$2$$ExternalSyntheticOutline0.m(sb5, "nearbypro://", decodeToString);
                                                                    } else {
                                                                        str = "";
                                                                    }
                                                                    wVar = agVar.f425139d;
                                                                    if (wVar != null && (list = wVar.f418273d) != null) {
                                                                        firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                                                                        zVar = (z) firstOrNull2;
                                                                        if (zVar != null) {
                                                                            vVar2 = zVar.f418280d;
                                                                            if (k.a(c.f117352a)) {
                                                                                e m16 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("src", str, "feedId", str2);
                                                                                m16.t("imageTag", i16);
                                                                                Unit unit = Unit.INSTANCE;
                                                                                companion.asyncToNativeMethod("openGalleryPreview", m16, (Function1<? super e, Unit>) null);
                                                                            } else if (vVar2 != null) {
                                                                                BDHService.INSTANCE.reqDownPhoto(vVar2, new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$openGalleryPreview$2
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(String str3) {
                                                                                        final String str4 = str3;
                                                                                        if (str4.length() > 0) {
                                                                                            QQNearbyModule qQNearbyModule = QQNearbyModule.this;
                                                                                            final String str5 = str2;
                                                                                            final int i18 = i16;
                                                                                            qQNearbyModule.asyncToNativeMethod("openGalleryPreview", new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$openGalleryPreview$2.1
                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                {
                                                                                                    super(1);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(e eVar) {
                                                                                                    e eVar2 = eVar;
                                                                                                    final String str6 = str4;
                                                                                                    eVar2.D("picUrls", new Function1<com.tencent.kuikly.core.nvi.serialization.json.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule.openGalleryPreview.2.1.1
                                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                        {
                                                                                                            super(1);
                                                                                                        }

                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                        public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.b bVar) {
                                                                                                            com.tencent.kuikly.core.nvi.serialization.json.b bVar2 = bVar;
                                                                                                            bVar2.a(bVar2, str6);
                                                                                                            return Unit.INSTANCE;
                                                                                                        }
                                                                                                    });
                                                                                                    eVar2.v("feedId", str5);
                                                                                                    eVar2.t("imageTag", i18);
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            }), (Function1<? super e, Unit>) null);
                                                                                        }
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                            }
                                                                        }
                                                                    }
                                                                    vVar2 = null;
                                                                    if (k.a(c.f117352a)) {
                                                                    }
                                                                }
                                                            }
                                                            vVar = null;
                                                            if (vVar != null) {
                                                            }
                                                            if (decodeToString != null) {
                                                            }
                                                            z16 = false;
                                                            if (!z16) {
                                                            }
                                                            wVar = agVar.f425139d;
                                                            if (wVar != null) {
                                                                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                                                                zVar = (z) firstOrNull2;
                                                                if (zVar != null) {
                                                                }
                                                            }
                                                            vVar2 = null;
                                                            if (k.a(c.f117352a)) {
                                                            }
                                                        }
                                                    } else if (k.a(c.f117352a)) {
                                                        e eVar = new e();
                                                        eVar.v("src", agVar.f425140e);
                                                        eVar.v("feedId", str2);
                                                        eVar.t("imageTag", i16);
                                                        Unit unit2 = Unit.INSTANCE;
                                                        companion.asyncToNativeMethod("openGalleryPreview", eVar, (Function1<? super e, Unit>) null);
                                                    } else {
                                                        companion.asyncToNativeMethod("openGalleryPreview", new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$openGalleryPreview$4
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(e eVar2) {
                                                                e eVar3 = eVar2;
                                                                final ag agVar2 = agVar;
                                                                eVar3.D("picUrls", new Function1<com.tencent.kuikly.core.nvi.serialization.json.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule$openGalleryPreview$4.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.b bVar) {
                                                                        com.tencent.kuikly.core.nvi.serialization.json.b bVar2 = bVar;
                                                                        bVar2.a(bVar2, ag.this.f425140e);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                eVar3.v("feedId", str2);
                                                                eVar3.t("imageTag", i16);
                                                                return Unit.INSTANCE;
                                                            }
                                                        }), (Function1<? super e, Unit>) null);
                                                    }
                                                }
                                            }
                                        } else {
                                            KLog kLog2 = KLog.INSTANCE;
                                            StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("onContentPicClick HeadFeed: ");
                                            m17.append(nBPArticleFeedDetailVM6.appId);
                                            m17.append(", ");
                                            AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m17, nBPArticleFeedDetailVM6.feedId, kLog2, "NBPArticleFeedDetailVM");
                                            nBPArticleFeedDetailVM6.onItemViewClick(nBPArticleFeedModel8);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM6 = NBPArticleFeedDetailVM.this;
                                final NBPArticleFeedModel nBPArticleFeedModel8 = nBPArticleFeedModel6;
                                imageEvent2.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedImageView.body.1.2.2.2
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(LongPressParams longPressParams) {
                                        NBPArticleFeedDetailVM.this.onFeedLongPress(nBPArticleFeedModel8);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPArticleFeedDetailVM nBPArticleFeedDetailVM7 = NBPArticleFeedDetailVM.this;
                                final NBPArticleFeedModel nBPArticleFeedModel9 = nBPArticleFeedModel6;
                                final NBPArticleFeedImageView nBPArticleFeedImageView3 = nBPArticleFeedImageView2;
                                imageEvent2.doubleClick(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedImageView.body.1.2.2.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        ClickParams clickParams2 = clickParams;
                                        NBPArticleFeedDetailVM.this.onLikeIconClick(nBPArticleFeedModel9, true, new ClickLocation(clickParams2.getX(), clickParams2.getY()).getTargetLocation(nBPArticleFeedImageView3, Reflection.getOrCreateKotlinClass(NBPArticleFeedItemView.class)));
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
        return new NBPArticleFeedImageViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new NBPArticleFeedImageViewEvent();
    }
}
