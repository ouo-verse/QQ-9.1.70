package com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting;

import com.qq.e.comm.constants.Constants;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionAttr;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionEvent;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionView;
import com.tencent.hippykotlin.demo.pages.base.ECTransitionViewKt;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.a;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.thumbplayer.core.codec.decoder.ITPMediaCodecDecoder;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes32.dex */
public final class AnchorResolutionSettingPage extends BasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AnchorResolutionSettingPage.class, "showContent", "getShowContent()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(AnchorResolutionSettingPage.class, "selectedIndex", "getSelectedIndex()I", 0)};
    public final Lazy contentViewHeight$delegate;
    public final Lazy resolutions$delegate;
    public final ReadWriteProperty selectedIndex$delegate;
    public final Lazy showCloseBtn$delegate;
    public final ReadWriteProperty showContent$delegate;

    public AnchorResolutionSettingPage() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c<Resolution>>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage$resolutions$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final c<AnchorResolutionSettingPage.Resolution> invoke() {
                List split$default;
                c<AnchorResolutionSettingPage.Resolution> cVar = new c<>(null, null, null, 7, null);
                split$default = StringsKt__StringsKt.split$default((CharSequence) AnchorResolutionSettingPage.this.getPageData().n().p("resolutions"), new String[]{","}, false, 0, 6, (Object) null);
                int i3 = 0;
                for (Object obj : split$default) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    cVar.add(new AnchorResolutionSettingPage.Resolution(i3, (String) obj));
                    i3 = i16;
                }
                return cVar;
            }
        });
        this.resolutions$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage$contentViewHeight$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(AnchorResolutionSettingPage.this.getPageData().n().k("height", ITPMediaCodecDecoder.BYTES_SET_MEDIA_DRM_SESSION_ID));
            }
        });
        this.contentViewHeight$delegate = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage$showCloseBtn$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(AnchorResolutionSettingPage.this.getPageData().n().k(Constants.KEYS.SHOW_CLOSE_BTN, 0));
            }
        });
        this.showCloseBtn$delegate = lazy3;
        this.showContent$delegate = c01.c.a(Boolean.TRUE);
        this.selectedIndex$delegate = c01.c.a(0);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        mVar.justifyContentFlexEnd();
                        return Unit.INSTANCE;
                    }
                });
                final AnchorResolutionSettingPage anchorResolutionSettingPage = AnchorResolutionSettingPage.this;
                ECTransitionViewKt.TransitionFadeInOutView(viewContainer2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECTransitionView eCTransitionView) {
                        ECTransitionView eCTransitionView2 = eCTransitionView;
                        final AnchorResolutionSettingPage anchorResolutionSettingPage2 = AnchorResolutionSettingPage.this;
                        eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.2.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                AnchorResolutionSettingPage anchorResolutionSettingPage3 = AnchorResolutionSettingPage.this;
                                eCTransitionAttr2.setTransitionAppear(((Boolean) anchorResolutionSettingPage3.showContent$delegate.getValue(anchorResolutionSettingPage3, AnchorResolutionSettingPage.$$delegatedProperties[0])).booleanValue());
                                eCTransitionAttr2.absolutePosition(0.0f, 0.0f, 0.0f, 0.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final AnchorResolutionSettingPage anchorResolutionSettingPage3 = AnchorResolutionSettingPage.this;
                        eCTransitionView2.event(new Function1<ECTransitionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionEvent eCTransitionEvent) {
                                final AnchorResolutionSettingPage anchorResolutionSettingPage4 = AnchorResolutionSettingPage.this;
                                eCTransitionEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.2.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        r1.showContent$delegate.setValue(AnchorResolutionSettingPage.this, AnchorResolutionSettingPage.$$delegatedProperties[0], Boolean.FALSE);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final AnchorResolutionSettingPage anchorResolutionSettingPage2 = AnchorResolutionSettingPage.this;
                ECTransitionViewKt.TransitionFromBottomView(viewContainer2, new Function1<ECTransitionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ECTransitionView eCTransitionView) {
                        ECTransitionView eCTransitionView2 = eCTransitionView;
                        final AnchorResolutionSettingPage anchorResolutionSettingPage3 = AnchorResolutionSettingPage.this;
                        eCTransitionView2.attr(new Function1<ECTransitionAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionAttr eCTransitionAttr) {
                                ECTransitionAttr eCTransitionAttr2 = eCTransitionAttr;
                                AnchorResolutionSettingPage anchorResolutionSettingPage4 = AnchorResolutionSettingPage.this;
                                eCTransitionAttr2.setTransitionAppear(((Boolean) anchorResolutionSettingPage4.showContent$delegate.getValue(anchorResolutionSettingPage4, AnchorResolutionSettingPage.$$delegatedProperties[0])).booleanValue());
                                eCTransitionAttr2.mo113backgroundColor(new h(4278517791L));
                                return Unit.INSTANCE;
                            }
                        });
                        eCTransitionView2.event(new Function1<ECTransitionEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ECTransitionEvent eCTransitionEvent) {
                                final ECTransitionEvent eCTransitionEvent2 = eCTransitionEvent;
                                eCTransitionEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                        return Unit.INSTANCE;
                                    }
                                });
                                eCTransitionEvent2.transitionFinish(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool) {
                                        if (!bool.booleanValue()) {
                                            k notifyModule = IPagerIdKtxKt.getNotifyModule(ECTransitionEvent.this);
                                            e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("action", "close");
                                            Unit unit = Unit.INSTANCE;
                                            notifyModule.c("resSettingCallback", m3, true);
                                            BridgeModule.closePage$default(IPagerIdKtxKt.getBridgeModule(ECTransitionEvent.this), null, null, 3);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final AnchorResolutionSettingPage anchorResolutionSettingPage4 = AnchorResolutionSettingPage.this;
                        w.a(eCTransitionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                v vVar2 = vVar;
                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(56.0f);
                                        tVar2.flexDirectionRow();
                                        tVar2.alignItemsCenter();
                                        tVar2.justifyContentCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                ceVar2.fontWeightSemisolid();
                                                ceVar2.color(h.INSTANCE.m());
                                                ceVar2.text("\u76f4\u64ad\u753b\u8d28");
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final AnchorResolutionSettingPage anchorResolutionSettingPage5 = AnchorResolutionSettingPage.this;
                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 8, null);
                                                tVar2.alignItemsCenter();
                                                tVar2.justifyContentCenter();
                                                a.C5863a.a(tVar2, 0.0f, 16.0f, 0.0f, 16.0f, 5, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final AnchorResolutionSettingPage anchorResolutionSettingPage6 = AnchorResolutionSettingPage.this;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final AnchorResolutionSettingPage anchorResolutionSettingPage7 = AnchorResolutionSettingPage.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        r1.showContent$delegate.setValue(AnchorResolutionSettingPage.this, AnchorResolutionSettingPage.$$delegatedProperties[0], Boolean.FALSE);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3.3.3
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.size(12.0f, 12.0f);
                                                        b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAFAAAABQBAMAAAB8P++eAAAAElBMVEUAAAD///////////////////8+Uq06AAAABXRSTlMAMO8g3xMWgmoAAABsSURBVEjH7cyxCYBAEETRlWvgsIMNzA3sQGzgcPtvRTgmPJjJnR9/XqxqPbSu1L72jK6BVamBVSApCJKDIBmIUQIrDRo0aPDvYOxzfE86bsc87zBp0qRJkwI5ukhmhEIC5CRATgLkJEBOLsAPjkyb6UuzHp8AAAAASUVORK5CYII=", false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                if (((Number) AnchorResolutionSettingPage.this.showCloseBtn$delegate.getValue()).intValue() == 1) {
                                    final AnchorResolutionSettingPage anchorResolutionSettingPage6 = AnchorResolutionSettingPage.this;
                                    w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3.4
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public final Unit invoke(v vVar3) {
                                            v vVar4 = vVar3;
                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3.4.1
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(t tVar) {
                                                    t tVar2 = tVar;
                                                    Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 2, null);
                                                    tVar2.alignItemsCenter();
                                                    tVar2.justifyContentCenter();
                                                    a.C5863a.a(tVar2, 0.0f, 16.0f, 0.0f, 16.0f, 5, null);
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            final AnchorResolutionSettingPage anchorResolutionSettingPage7 = AnchorResolutionSettingPage.this;
                                            vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3.4.2
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(u uVar) {
                                                    final AnchorResolutionSettingPage anchorResolutionSettingPage8 = AnchorResolutionSettingPage.this;
                                                    uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3.4.2.1
                                                        {
                                                            super(1);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(ClickParams clickParams) {
                                                            r1.showContent$delegate.setValue(AnchorResolutionSettingPage.this, AnchorResolutionSettingPage.$$delegatedProperties[0], Boolean.FALSE);
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                            ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3.4.3
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(ImageView imageView) {
                                                    imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.3.4.3.1
                                                        @Override // kotlin.jvm.functions.Function1
                                                        public final Unit invoke(af afVar) {
                                                            af afVar2 = afVar;
                                                            afVar2.size(17.5f, 17.5f);
                                                            b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABcAAAAXCAYAAADgKtSgAAAAAXNSR0IArs4c6QAAAIRlWElmTU0AKgAAAAgABQESAAMAAAABAAEAAAEaAAUAAAABAAAASgEbAAUAAAABAAAAUgEoAAMAAAABAAIAAIdpAAQAAAABAAAAWgAAAAAAAABIAAAAAQAAAEgAAAABAAOgAQADAAAAAQABAACgAgAEAAAAAQAAABegAwAEAAAAAQAAABcAAAAAVd28qgAAAAlwSFlzAAALEwAACxMBAJqcGAAAAVlpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IlhNUCBDb3JlIDYuMC4wIj4KICAgPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4KICAgICAgPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIKICAgICAgICAgICAgeG1sbnM6dGlmZj0iaHR0cDovL25zLmFkb2JlLmNvbS90aWZmLzEuMC8iPgogICAgICAgICA8dGlmZjpPcmllbnRhdGlvbj4xPC90aWZmOk9yaWVudGF0aW9uPgogICAgICA8L3JkZjpEZXNjcmlwdGlvbj4KICAgPC9yZGY6UkRGPgo8L3g6eG1wbWV0YT4KGV7hBwAAAjVJREFUSA29lDFOW0EQhjEOoqZEkdIREsFZbGw3XIFU9hFS5ACkoqel5wYcISAayqRIAgiSOCTKy/fv23+ZZ/s5RSRG+t8/Ozs7M293dldWnlKqqlp3PvSO9UXseXgVrC3yKTYctsApGMoId4TiEJRoR5+AY7AZXB5VJhT4DEhuQE+z8FwCbKteif4GfAOSE/Dcc4kxrANVLPleU3UL9+UAlwToMfAB4x9A4nXv0IuPEwwxqmLJtKY0TglykmfJuU4YA//M/hfwrn0azEQPqGKJK7lG34uOjGNgV36J/WX0SzrG+Nt9xv4D76USDOQMa48d0AWo4u0839ySbJxNoICSu5qqK/gIfMnj+8zn8KvWwJqQ4NSWwJXmeJX3+AOG13ltNwVZ9lECz6MPwBWQ/AIP4LcGiNo2HR7878AhaOwKbYVEgf9k1ngsf1i3c36fHSxydETX4X0GElWsBPoDyUcw8lr08se2NRiHUgF6bDfvMeYkPoOvjFKbwuW8GkE10KSN6DGwu0J7PAafgMRdpK6au8mOtSyw+1hd4cMboatiie+B7kV7glx9vCD+dfWx2y1tG+M94HvgAspbVKrOQXXiE+BKvMe6eb4gXfR4Jn3GvslTdIn+aH82+BpGvccSV6K3wle69DG2cnDoSuC3yGfzFlspIiXCsAn0HktUcXqE4KYj3thmE/gMDpnbaFTuARMvwHuwIxs8Fzj4xgT7+KrixYHDorIFtrUxwWL7thbStv6/7H8BVknQrcX+DHMAAAAASUVORK5CYII=", false, 2, null);
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
                        w.a(eCTransitionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar) {
                                vVar.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(1.0f);
                                        tVar2.mo113backgroundColor(new h(520093695L));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final AnchorResolutionSettingPage anchorResolutionSettingPage5 = AnchorResolutionSettingPage.this;
                        ar.a(eCTransitionView2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(aq<?, ?> aqVar) {
                                aq<?, ?> aqVar2 = aqVar;
                                final AnchorResolutionSettingPage anchorResolutionSettingPage6 = AnchorResolutionSettingPage.this;
                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.5.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ao aoVar) {
                                        ao aoVar2 = aoVar;
                                        aoVar2.mo141height(((Number) AnchorResolutionSettingPage.this.contentViewHeight$delegate.getValue()).intValue());
                                        aoVar2.marginTop(10.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final AnchorResolutionSettingPage anchorResolutionSettingPage7 = AnchorResolutionSettingPage.this;
                                Function0<c<AnchorResolutionSettingPage.Resolution>> function0 = new Function0<c<AnchorResolutionSettingPage.Resolution>>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.5.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final c<AnchorResolutionSettingPage.Resolution> invoke() {
                                        return (c) AnchorResolutionSettingPage.this.resolutions$delegate.getValue();
                                    }
                                };
                                final AnchorResolutionSettingPage anchorResolutionSettingPage8 = AnchorResolutionSettingPage.this;
                                LoopDirectivesViewKt.a(aqVar2, function0, new Function2<LoopDirectivesView<AnchorResolutionSettingPage.Resolution>, AnchorResolutionSettingPage.Resolution, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.5.3
                                    {
                                        super(2);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Unit invoke(LoopDirectivesView<AnchorResolutionSettingPage.Resolution> loopDirectivesView, AnchorResolutionSettingPage.Resolution resolution) {
                                        final AnchorResolutionSettingPage.Resolution resolution2 = resolution;
                                        final AnchorResolutionSettingPage anchorResolutionSettingPage9 = AnchorResolutionSettingPage.this;
                                        w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.5.3.1
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.5.3.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionRow();
                                                        tVar2.alignItemsCenter();
                                                        tVar2.justifyContentSpaceBetween();
                                                        tVar2.mo141height(56.0f);
                                                        a.C5863a.a(tVar2, 0.0f, 16.0f, 0.0f, 16.0f, 5, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final AnchorResolutionSettingPage.Resolution resolution3 = AnchorResolutionSettingPage.Resolution.this;
                                                cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.5.3.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final AnchorResolutionSettingPage.Resolution resolution4 = AnchorResolutionSettingPage.Resolution.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.5.3.1.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                ce ceVar2 = ceVar;
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.fontWeightSemisolid();
                                                                ceVar2.color(h.INSTANCE.m());
                                                                ceVar2.text(AnchorResolutionSettingPage.Resolution.this.name);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final AnchorResolutionSettingPage.Resolution resolution4 = AnchorResolutionSettingPage.Resolution.this;
                                                final AnchorResolutionSettingPage anchorResolutionSettingPage10 = anchorResolutionSettingPage9;
                                                ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.5.3.1.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        int i3 = AnchorResolutionSettingPage.Resolution.this.index;
                                                        AnchorResolutionSettingPage anchorResolutionSettingPage11 = anchorResolutionSettingPage10;
                                                        return Boolean.valueOf(i3 == ((Number) anchorResolutionSettingPage11.selectedIndex$delegate.getValue(anchorResolutionSettingPage11, AnchorResolutionSettingPage.$$delegatedProperties[1])).intValue());
                                                    }
                                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.5.3.1.4
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView) {
                                                        ah.a(conditionView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.5.3.1.4.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ImageView imageView) {
                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.5.3.1.4.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(af afVar) {
                                                                        af afVar2 = afVar;
                                                                        afVar2.size(14.5f, 10.0f);
                                                                        b.a.b(afVar2, "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAB0AAAAUBAMAAACDsiv0AAAAKlBMVEUAAAAAmP8Amv8AnP8Anf8AmP8Amv8AoP8Alv8Am/8Amf8Amv8AmP8Amv/6f3t+AAAADXRSTlMAgN8hXyDvEDC+n3Bg21o94wAAAGFJREFUGNNjQAaWAShcZl1VFL7R3UsFKNJ3L6JK3xUgQpodTbrNAUWaI/cKinTZ3bsgBUEwwxnv3gUqYEUYLgtUAJWGK4BIIxQIgaURCu6CpREKUF3OCJNGKBBA4fOshjMBziAzWZruwTMAAAAASUVORK5CYII=", false, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final AnchorResolutionSettingPage anchorResolutionSettingPage11 = anchorResolutionSettingPage9;
                                                final AnchorResolutionSettingPage.Resolution resolution5 = AnchorResolutionSettingPage.Resolution.this;
                                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.5.3.1.5
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final u uVar2 = uVar;
                                                        final AnchorResolutionSettingPage anchorResolutionSettingPage12 = AnchorResolutionSettingPage.this;
                                                        final AnchorResolutionSettingPage.Resolution resolution6 = resolution5;
                                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqlive.anchor_resolution_setting.AnchorResolutionSettingPage.body.1.3.5.3.1.5.1
                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                AnchorResolutionSettingPage anchorResolutionSettingPage13 = AnchorResolutionSettingPage.this;
                                                                ReadWriteProperty readWriteProperty = anchorResolutionSettingPage13.selectedIndex$delegate;
                                                                KProperty<?>[] kPropertyArr = AnchorResolutionSettingPage.$$delegatedProperties;
                                                                int intValue = ((Number) readWriteProperty.getValue(anchorResolutionSettingPage13, kPropertyArr[1])).intValue();
                                                                int i3 = resolution6.index;
                                                                if (intValue != i3) {
                                                                    AnchorResolutionSettingPage anchorResolutionSettingPage14 = AnchorResolutionSettingPage.this;
                                                                    anchorResolutionSettingPage14.selectedIndex$delegate.setValue(anchorResolutionSettingPage14, kPropertyArr[1], Integer.valueOf(i3));
                                                                    k notifyModule = IPagerIdKtxKt.getNotifyModule(uVar2);
                                                                    e eVar = new e();
                                                                    AnchorResolutionSettingPage.Resolution resolution7 = resolution6;
                                                                    eVar.v("action", "select");
                                                                    eVar.v("resolution", resolution7.name);
                                                                    Unit unit = Unit.INSTANCE;
                                                                    notifyModule.c("resSettingCallback", eVar, true);
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
                        });
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.selectedIndex$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(getPageData().n().k("selectedIndex", 0)));
    }

    /* loaded from: classes32.dex */
    public static final class Resolution {
        public final int index;
        public final String name;

        public Resolution(int i3, String str) {
            this.index = i3;
            this.name = str;
        }

        public final int hashCode() {
            return this.name.hashCode() + (this.index * 31);
        }

        public final String toString() {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("Resolution(index=");
            m3.append(this.index);
            m3.append(", name=");
            return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.name, ')');
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Resolution)) {
                return false;
            }
            Resolution resolution = (Resolution) obj;
            return this.index == resolution.index && Intrinsics.areEqual(this.name, resolution.name);
        }
    }
}
