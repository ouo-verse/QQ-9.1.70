package com.tencent.hippykotlin.demo.pages.nearby.main.control.title;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.TextViewExtKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPJumpUtil;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPMainKtxKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.hippykotlin.demo.pages.nearby.main.theme.NBPMainMapThemeViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.AccessibilityRole;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.event.LongPressParams;
import com.tencent.kuikly.core.base.g;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes31.dex */
public final class NBPMainTitleView extends ComposeView<k, l> {
    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        final NBPMainTitleViewModel titleViewModel = NBPViewModelStoreKt.getTitleViewModel(NBPMainKtxKt.getNbpVMStore(getPager()));
        final NBPMainMapThemeViewModel mapThemeVM = NBPViewModelStoreKt.getMapThemeVM(NBPMainKtxKt.getNbpVMStore(getPager()));
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView$body$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                final NBPMainTitleViewModel nBPMainTitleViewModel = NBPMainTitleViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                tVar2.size(40.5f, 50.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainTitleViewModel nBPMainTitleViewModel2 = NBPMainTitleViewModel.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NBPMainTitleViewModel nBPMainTitleViewModel3 = NBPMainTitleViewModel.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPMainTitleViewModel.this.onBackIconClick();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                viewContainer2.getPager().getPageData().getIsIOS();
                final NBPMainMapThemeViewModel nBPMainMapThemeViewModel = mapThemeVM;
                final NBPMainTitleView nBPMainTitleView = this;
                final NBPMainTitleViewModel nBPMainTitleViewModel2 = NBPMainTitleViewModel.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView$body$1.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        final float f16 = 44.0f;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.marginTop(tVar2.getPagerData().getStatusBarHeight());
                                tVar2.mo153width(tVar2.getPagerData().m());
                                tVar2.mo141height(f16);
                                tVar2.alignItemsCenter();
                                tVar2.paddingLeft(16.0f);
                                tVar2.paddingRight(16.0f);
                                tVar2.justifyContentSpaceBetween();
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainMapThemeViewModel nBPMainMapThemeViewModel2 = NBPMainMapThemeViewModel.this;
                        final NBPMainTitleView nBPMainTitleView2 = nBPMainTitleView;
                        final NBPMainTitleViewModel nBPMainTitleViewModel3 = nBPMainTitleViewModel2;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.size(36.0f, 36.0f);
                                        tVar2.borderRadius(18.0f);
                                        h.Companion companion = h.INSTANCE;
                                        tVar2.mo113backgroundColor(companion.m());
                                        tVar2.boxShadow(new g(0.0f, 2.25f, 6.75f, companion.a(0.12f)), true);
                                        tVar2.accessibility("\u8fd4\u56de");
                                        tVar2.accessibilityRole(AccessibilityRole.BUTTON);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMainMapThemeViewModel nBPMainMapThemeViewModel3 = NBPMainMapThemeViewModel.this;
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        final NBPMainMapThemeViewModel nBPMainMapThemeViewModel4 = NBPMainMapThemeViewModel.this;
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                String image;
                                                af afVar2 = afVar;
                                                afVar2.size(18.0f, 18.0f);
                                                afVar2.marginTop(9.0f);
                                                afVar2.marginLeft(7.87f);
                                                if (NBPMainMapThemeViewModel.this.isCityTheme()) {
                                                    image = QUIToken.INSTANCE.image("chevron_left", new h(4281282611L));
                                                } else {
                                                    image = QUIToken.INSTANCE.image("close", new h(4281282611L));
                                                }
                                                b.a.b(afVar2, image, false, 2, null);
                                                afVar2.o();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPMainTitleView nBPMainTitleView3 = nBPMainTitleView2;
                                final NBPMainTitleViewModel nBPMainTitleViewModel4 = nBPMainTitleViewModel3;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.2.3
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        u uVar2 = uVar;
                                        final NBPMainTitleViewModel nBPMainTitleViewModel5 = nBPMainTitleViewModel4;
                                        uVar2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                NBPMainTitleViewModel.this.onBackIconClick();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        if (!PageDataExtKt.isPublic(NBPMainTitleView.this.getPagerData())) {
                                            uVar2.longPress(new Function1<LongPressParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.2.3.2
                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(LongPressParams longPressParams) {
                                                    if (!NBPJumpUtil.fastClickUtils.isFastDoubleClick()) {
                                                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("jumpDebugSettingsPage scheme=", "mqqapi://kuikly/open?version=1&src_type=app&page_name=nbp_debug_settings", KLog.INSTANCE, "NBPJumpUtil");
                                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                        QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?version=1&src_type=app&page_name=nbp_debug_settings", false, 6);
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            });
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPMainMapThemeViewModel nBPMainMapThemeViewModel3 = NBPMainMapThemeViewModel.this;
                        Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.3
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                NBPMainMapThemeViewModel nBPMainMapThemeViewModel4 = NBPMainMapThemeViewModel.this;
                                return Boolean.valueOf(((String) nBPMainMapThemeViewModel4.themeIcon$delegate.getValue(nBPMainMapThemeViewModel4, NBPMainMapThemeViewModel.$$delegatedProperties[1])).length() > 0);
                            }
                        };
                        final NBPMainTitleViewModel nBPMainTitleViewModel4 = nBPMainTitleViewModel2;
                        final NBPMainMapThemeViewModel nBPMainMapThemeViewModel4 = NBPMainMapThemeViewModel.this;
                        ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                ConditionView conditionView2 = conditionView;
                                final NBPMainTitleViewModel nBPMainTitleViewModel5 = NBPMainTitleViewModel.this;
                                final NBPMainMapThemeViewModel nBPMainMapThemeViewModel5 = nBPMainMapThemeViewModel4;
                                w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        v vVar4 = vVar3;
                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.flexDirectionRow();
                                                tVar2.alignItemsCenter();
                                                tVar2.mo141height(44.0f);
                                                tVar2.borderRadius(22.0f);
                                                h.Companion companion = h.INSTANCE;
                                                tVar2.mo113backgroundColor(companion.m());
                                                tVar2.paddingLeft(8.0f);
                                                tVar2.paddingRight(16.0f);
                                                tVar2.paddingTop(6.0f);
                                                tVar2.paddingBottom(6.0f);
                                                tVar2.boxShadow(new g(0.0f, 3.0f, 6.0f, companion.a(0.08f)), true);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPMainTitleViewModel nBPMainTitleViewModel6 = NBPMainTitleViewModel.this;
                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                final NBPMainTitleViewModel nBPMainTitleViewModel7 = NBPMainTitleViewModel.this;
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ClickParams clickParams) {
                                                        byte[] encodeToByteArray;
                                                        String str = NBPMainTitleViewModel.this.getCurMapTheme().f421849d;
                                                        e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
                                                        DataCardKt$DataCard$3$1$1$1$1$1$1$$ExternalSyntheticOutline0.m("jumpChooseThemePage schema:", str, KLog.INSTANCE, "NBPChooseThemePage");
                                                        QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                                                        encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(jsonWithMainPgParams.toString());
                                                        companion.setSharePenetratePageData(new byte[][]{encodeToByteArray});
                                                        QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                                                        QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?target=52&channel=2&version=1&src_type=app&modal_mode=1&page_name=nearbypro_choose_theme&theme_id=" + str + "&custom_back_pressed=1", false, 6);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPMainMapThemeViewModel nBPMainMapThemeViewModel6 = nBPMainMapThemeViewModel5;
                                        ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ImageView imageView) {
                                                final NBPMainMapThemeViewModel nBPMainMapThemeViewModel7 = NBPMainMapThemeViewModel.this;
                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(af afVar) {
                                                        af afVar2 = afVar;
                                                        afVar2.size(32.0f, 32.0f);
                                                        afVar2.o();
                                                        NBPMainMapThemeViewModel nBPMainMapThemeViewModel8 = NBPMainMapThemeViewModel.this;
                                                        b.a.b(afVar2, (String) nBPMainMapThemeViewModel8.themeIcon$delegate.getValue(nBPMainMapThemeViewModel8, NBPMainMapThemeViewModel.$$delegatedProperties[1]), false, 2, null);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPMainMapThemeViewModel nBPMainMapThemeViewModel7 = nBPMainMapThemeViewModel5;
                                        final NBPMainTitleViewModel nBPMainTitleViewModel7 = NBPMainTitleViewModel.this;
                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4
                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar5) {
                                                v vVar6 = vVar5;
                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.flexDirectionColumn();
                                                        tVar2.marginLeft(4.0f);
                                                        tVar2.justifyContentCenter();
                                                        tVar2.m146minWidth(80.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPMainMapThemeViewModel nBPMainMapThemeViewModel8 = NBPMainMapThemeViewModel.this;
                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextView textView) {
                                                        final NBPMainMapThemeViewModel nBPMainMapThemeViewModel9 = NBPMainMapThemeViewModel.this;
                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4.2.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ce ceVar) {
                                                                String str;
                                                                ce ceVar2 = ceVar;
                                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                                ceVar2.lineHeight(17.0f);
                                                                ceVar2.fontWeight500();
                                                                ceVar2.color(h.INSTANCE.b());
                                                                if (NBPMainMapThemeViewModel.this.isCityTheme()) {
                                                                    str = StringsKt__StringsKt.removeSuffix(UserDataManager.INSTANCE.getUserSelfInfo().locationCity, (CharSequence) "\u5e02");
                                                                } else {
                                                                    NBPMainMapThemeViewModel nBPMainMapThemeViewModel10 = NBPMainMapThemeViewModel.this;
                                                                    str = (String) nBPMainMapThemeViewModel10.themeName$delegate.getValue(nBPMainMapThemeViewModel10, NBPMainMapThemeViewModel.$$delegatedProperties[2]);
                                                                }
                                                                TextViewExtKt.textWithLineHeightFix(ceVar2, str);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPMainMapThemeViewModel nBPMainMapThemeViewModel9 = NBPMainMapThemeViewModel.this;
                                                final NBPMainTitleViewModel nBPMainTitleViewModel8 = nBPMainTitleViewModel7;
                                                w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4.3
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar7) {
                                                        v vVar8 = vVar7;
                                                        vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.flexDirectionRow();
                                                                tVar2.alignItemsCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPMainMapThemeViewModel nBPMainMapThemeViewModel10 = NBPMainMapThemeViewModel.this;
                                                        cg.a(vVar8, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final NBPMainMapThemeViewModel nBPMainMapThemeViewModel11 = NBPMainMapThemeViewModel.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4.3.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ce.fontSize$default(ceVar2, 10.0f, null, 2, null);
                                                                        ceVar2.fontWeight400();
                                                                        ceVar2.lineHeight(12.0f);
                                                                        ceVar2.lines(1);
                                                                        ceVar2.color(new h(9474196L, 1.0f));
                                                                        StringBuilder sb5 = new StringBuilder();
                                                                        NBPMainMapThemeViewModel nBPMainMapThemeViewModel12 = NBPMainMapThemeViewModel.this;
                                                                        sb5.append(((Number) nBPMainMapThemeViewModel12.personCount$delegate.getValue(nBPMainMapThemeViewModel12, NBPMainMapThemeViewModel.$$delegatedProperties[5])).intValue());
                                                                        sb5.append("\u4eba\u5171\u5efa");
                                                                        TextViewExtKt.textWithLineHeightFix(ceVar2, sb5.toString());
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPMainMapThemeViewModel nBPMainMapThemeViewModel11 = NBPMainMapThemeViewModel.this;
                                                        Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4.3.3
                                                            {
                                                                super(0);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function0
                                                            public final Object invoke() {
                                                                return Boolean.valueOf(NBPMainMapThemeViewModel.this.isCityTheme());
                                                            }
                                                        };
                                                        final NBPMainTitleViewModel nBPMainTitleViewModel9 = nBPMainTitleViewModel8;
                                                        ConditionViewKt.c(vVar8, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4.3.4
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ConditionView conditionView3) {
                                                                ConditionView conditionView4 = conditionView3;
                                                                final NBPMainTitleViewModel nBPMainTitleViewModel10 = NBPMainTitleViewModel.this;
                                                                w.a(conditionView4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4.3.4.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar9) {
                                                                        v vVar10 = vVar9;
                                                                        vVar10.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4.3.4.1.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.size(15.0f, 15.0f);
                                                                                Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 7, null);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NBPMainTitleViewModel nBPMainTitleViewModel11 = NBPMainTitleViewModel.this;
                                                                        vVar10.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4.3.4.1.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(u uVar) {
                                                                                final NBPMainTitleViewModel nBPMainTitleViewModel12 = NBPMainTitleViewModel.this;
                                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4.3.4.1.2.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        NBPMainTitleViewModel.this.getClass();
                                                                                        KLog.INSTANCE.i("NBPMainTitleViewModel", "openSafeStatementDialog");
                                                                                        ((QQUIModule) c.f117352a.g().acquireModule("QQUIModule")).openAlertDialog("\u5b89\u5168\u58f0\u660e", QQNearbyModule.Companion.getInstance().getStringFromQQCommonConfig("nearby_pro_beta_version_dsc", "\u65b0\u9644\u8fd1\u662f\u57fa\u4e8e\u8d85\u7ea7QQ\u79c0\u5f62\u8c61\u53ca\u9644\u8fd1\u964c\u751f\u4eba\u7684\u793e\u4ea4\u573a\u666f\u3002\u7528\u6237\u53ef\u4ee5\u5728\u8be5\u573a\u666f\u5185\u5206\u4eab\u72b6\u6001\uff0c\u7ed3\u8bc6\u9644\u8fd1\u7684\u4eba\u3002\u4f7f\u7528\u65b0\u9644\u8fd1\u9700\u5f00\u542f\u5b9a\u4f4d\uff0c\u5176\u4ed6\u4eba\u80fd\u770b\u5230\u4f60\u5927\u81f4\u4f4d\u7f6e\uff08\u4e0d\u662f\u786e\u5207\u4f4d\u7f6e\uff09\uff0c\u79bb\u5f00\u9644\u8fd1\u540e\u4f1a\u81ea\u52a8\u6e05\u9664\u4f60\u7684\u4f4d\u7f6e\u4fe1\u606f\u3002\n\n\u65b0\u9644\u8fd1\u81f4\u529b\u4e8e\u63d0\u4f9b\u7eff\u8272\u5065\u5eb7\u7684\u4e92\u8054\u7f51\u73af\u5883\uff0c\u5021\u5bfc\u5065\u5eb7\u6587\u660e\u6c9f\u901a\uff0c\u5e73\u53f0\u4e25\u7981\u51fa\u73b0\u8fdd\u6cd5\u8fdd\u89c4\uff0c\u8272\u60c5\u4f4e\u4fd7\uff0c\u8fdd\u80cc\u793e\u4f1a\u516c\u4fd7\u826f\u5fb7\uff0c\u6076\u610f\u5f15\u6d41\u7b49\u4fe1\u606f\uff0c\u82e5\u6709\u53d1\u73b0\u8fdd\u89c4\u597d\u53cb\u8bf7\u53ca\u65f6\u4e3e\u62a5\uff0c\u5e73\u53f0\u5c06\u6309\u89c4\u5219\u8fdb\u884c\u8d26\u53f7\u51bb\u7ed3\u5904\u7f6e\uff0c\u53e6\u5916\u5927\u5bb6\u6ce8\u610f\u8d22\u4ea7\u5b89\u5168\uff0c\u8c28\u9632\u7f51\u7edc\u8bc8\u9a97\uff01"), "", "\u6211\u77e5\u9053\u4e86", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleViewModel$openSafeStatementDialog$1
                                                                                            @Override // kotlin.jvm.functions.Function2
                                                                                            public final /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Boolean bool2) {
                                                                                                bool.booleanValue();
                                                                                                bool2.booleanValue();
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
                                                                                        jsonWithMainPgParams.v("dt_eid", "em_nearby_question_mark");
                                                                                        jsonWithMainPgParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", jsonWithMainPgParams);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                ah.a(conditionView4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4.3.4.2
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ImageView imageView) {
                                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.1.4.3.4.2.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(af afVar) {
                                                                                af afVar2 = afVar;
                                                                                afVar2.size(9.0f, 9.0f);
                                                                                afVar2.marginLeft(1.0f);
                                                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_zZX4UzleTUk.png", false, 2, null);
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
                                w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar3) {
                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.control.title.NBPMainTitleView.body.1.2.4.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.mo153width(36.0f);
                                                tVar2.mo141height(36.0f);
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
        return new k();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new l();
    }
}
