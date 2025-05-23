package com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPNewEditViewModel;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.Pager;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.TextAreaEvent;
import com.tencent.kuikly.core.views.TextAreaView;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.cc;
import com.tencent.kuikly.core.views.cd;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.random.Random;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes31.dex */
public final class NBPManifestoEditPage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPManifestoEditPage.class, "initDeclaration", "getInitDeclaration()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPManifestoEditPage.class, "currentDeclaration", "getCurrentDeclaration()Ljava/lang/String;", 0)};
    public int appId;
    public final ReadWriteProperty currentDeclaration$delegate;
    public final FastClickUtils fastClickUtils;
    public final ReadWriteProperty initDeclaration$delegate;
    public String oldDeclaration;
    public String recommendDeclaration;
    public final List<String> recommendDeclarations;
    public aa<TextView> textViewRef;
    public NBPNewEditViewModel viewModel;

    public NBPManifestoEditPage() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{"\u559c\u6b22\u503e\u542c\u7684 i \u4eba\u5728\u6b64\uff0c\u60f3\u6210\u4e3a\u4f60\u7684\u4e13\u5c5e\u6811\u6d1e", "\u5e73\u5e73\u65e0\u5947\u7684\u79d2\u56de\u5c0f\u80fd\u624b\uff0c\u5520\u55d1\u662f\u65e5\u5e38\u5145\u7535\uff0c\u548c\u6211\u804a\u4f1a\u513f\u5457\uff1f", "\u6d41\u661f\u4e00\u6837\u7684\u6211\uff0c\u5212\u8fc7\u5929\u9645\u843d\u5728\u4f60\u5fc3\u91cc\u3002\u7231\u597d\u5e7f\u6cdb\uff0c\u7279\u522b\u662f\u661f\u7a7a\u548c\u97f3\u4e50", "\u751f\u6d3b\u65e0\u804a\uff0c\u597d\u5728\u6211\u5f88\u6709\u8da3\u3002\u51c6\u5907\u597d\u88ab\u6211\u7684\u5e7d\u9ed8\u51fb\u4e2d\u4e86\u5417\uff1f", "\u9ad8\u51b7\u5916\u8868\u4e0b\u662f\u641e\u7b11\u7684\u5185\u5fc3\uff0c\u9762\u65e0\u8868\u60c5\u53ea\u662f\u6211\u7684\u5047\u8c61"});
        this.recommendDeclarations = listOf;
        this.recommendDeclaration = "";
        this.initDeclaration$delegate = c.a("");
        this.currentDeclaration$delegate = c.a("");
        this.oldDeclaration = "";
        this.fastClickUtils = new FastClickUtils(500L);
    }

    public static final String access$getCurrentDeclaration(NBPManifestoEditPage nBPManifestoEditPage) {
        return (String) nBPManifestoEditPage.currentDeclaration$delegate.getValue(nBPManifestoEditPage, $$delegatedProperties[1]);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.m140flex(1.0f);
                        mVar2.flexDirectionColumn();
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_standard"));
                        return Unit.INSTANCE;
                    }
                });
                final NBPManifestoEditPage nBPManifestoEditPage = NBPManifestoEditPage.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage$body$1.2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.justifyContentCenter();
                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                                float m3 = tVar2.getPagerData().m();
                                tVar2.getPagerData().getIsIOS();
                                tVar2.size(m3, tVar2.getPagerData().getStatusBarHeight() + 44.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPManifestoEditPage nBPManifestoEditPage2 = NBPManifestoEditPage.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.positionAbsolute();
                                        tVar2.m142left(10.0f);
                                        tVar2.m150top(tVar2.getPagerData().getStatusBarHeight());
                                        tVar2.m138bottom(0.0f);
                                        tVar2.justifyContentCenter();
                                        tVar2.alignItemsCenter();
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPManifestoEditPage nBPManifestoEditPage3 = NBPManifestoEditPage.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPManifestoEditPage nBPManifestoEditPage4 = NBPManifestoEditPage.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                if (!NBPManifestoEditPage.this.fastClickUtils.isFastDoubleClick()) {
                                                    NBPManifestoEditPage.this.showAlertWhenExit();
                                                }
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.2.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(24.0f, 24.0f);
                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_gprg2tiIEyx.png", false, 2, null);
                                                afVar2.t(QUIToken.color$default("text_nav_secondary"));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginTop(ceVar2.getPagerData().getStatusBarHeight());
                                        ceVar2.text("\u586b\u5199\u4ea4\u53cb\u5ba3\u8a00");
                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                        ceVar2.fontWeight500();
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPManifestoEditPage nBPManifestoEditPage3 = NBPManifestoEditPage.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.4
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                final NBPManifestoEditPage nBPManifestoEditPage4 = NBPManifestoEditPage.this;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.4.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        CharSequence trimEnd;
                                        t tVar2 = tVar;
                                        tVar2.positionAbsolute();
                                        tVar2.m150top(tVar2.getPagerData().getStatusBarHeight());
                                        tVar2.m138bottom(0.0f);
                                        tVar2.m149right(10.0f);
                                        tVar2.justifyContentCenter();
                                        tVar2.alignItemsCenter();
                                        trimEnd = StringsKt__StringsKt.trimEnd((CharSequence) NBPManifestoEditPage.access$getCurrentDeclaration(NBPManifestoEditPage.this));
                                        tVar2.m151touchEnable(trimEnd.toString().length() > 0);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPManifestoEditPage nBPManifestoEditPage5 = NBPManifestoEditPage.this;
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.4.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        final NBPManifestoEditPage nBPManifestoEditPage6 = NBPManifestoEditPage.this;
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.4.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                CharSequence trimEnd;
                                                trimEnd = StringsKt__StringsKt.trimEnd((CharSequence) NBPManifestoEditPage.access$getCurrentDeclaration(NBPManifestoEditPage.this));
                                                if (trimEnd.toString().length() < 10) {
                                                    Utils.INSTANCE.currentBridgeModule().qToast("\u8bf7\u8f93\u516510\u4e2a\u5b57\u4ee5\u4e0a", QToastMode.Info);
                                                } else {
                                                    NBPManifestoEditPage nBPManifestoEditPage7 = NBPManifestoEditPage.this;
                                                    NBPNewEditViewModel nBPNewEditViewModel = nBPManifestoEditPage7.viewModel;
                                                    if (nBPNewEditViewModel != null) {
                                                        nBPNewEditViewModel.save(new s35.af(null, 0L, null, 0, null, 0, null, null, null, (String) nBPManifestoEditPage7.currentDeclaration$delegate.getValue(nBPManifestoEditPage7, NBPManifestoEditPage.$$delegatedProperties[1]), null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -513, 255), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.4.2.1.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(Boolean bool) {
                                                                if (bool.booleanValue()) {
                                                                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                    QQKuiklyPlatformApi.Companion.closePage$default();
                                                                }
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                    }
                                                }
                                                e dtDeclarationPageParam = NBPManifestoEditPage.this.getDtDeclarationPageParam();
                                                dtDeclarationPageParam.v("dt_eid", "em_nearby_kl_complete_btn");
                                                dtDeclarationPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dtDeclarationPageParam);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPManifestoEditPage nBPManifestoEditPage6 = NBPManifestoEditPage.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.4.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPManifestoEditPage nBPManifestoEditPage7 = NBPManifestoEditPage.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.2.4.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                CharSequence trimEnd;
                                                h color$default;
                                                ce ceVar2 = ceVar;
                                                ceVar2.text("\u5b8c\u6210");
                                                trimEnd = StringsKt__StringsKt.trimEnd((CharSequence) NBPManifestoEditPage.access$getCurrentDeclaration(NBPManifestoEditPage.this));
                                                if (trimEnd.toString().length() > 0) {
                                                    color$default = QUIToken.color$default("text_primary");
                                                } else {
                                                    color$default = QUIToken.color$default("text_secondary");
                                                }
                                                ceVar2.color(color$default);
                                                ceVar2.fontWeight400();
                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
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
                final NBPManifestoEditPage nBPManifestoEditPage2 = NBPManifestoEditPage.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.m140flex(1.0f);
                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_standard"));
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPManifestoEditPage nBPManifestoEditPage3 = NBPManifestoEditPage.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.mo141height(197.0f);
                                        tVar2.margin(16.0f, 16.0f, 0.0f, 16.0f);
                                        tVar2.borderRadius(8.0f);
                                        tVar2.mo113backgroundColor(QUIToken.color$default("fill_light_secondary"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPManifestoEditPage nBPManifestoEditPage4 = NBPManifestoEditPage.this;
                                cd.a(vVar4, new Function1<TextAreaView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.2.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextAreaView textAreaView) {
                                        TextAreaView textAreaView2 = textAreaView;
                                        final NBPManifestoEditPage nBPManifestoEditPage5 = NBPManifestoEditPage.this;
                                        textAreaView2.ref(textAreaView2, new Function1<aa<TextAreaView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.2.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(aa<TextAreaView> aaVar) {
                                                NBPManifestoEditPage nBPManifestoEditPage6 = NBPManifestoEditPage.this;
                                                KProperty<Object>[] kPropertyArr = NBPManifestoEditPage.$$delegatedProperties;
                                                nBPManifestoEditPage6.getClass();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPManifestoEditPage nBPManifestoEditPage6 = NBPManifestoEditPage.this;
                                        textAreaView2.attr(new Function1<cc, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.2.2.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(cc ccVar) {
                                                cc ccVar2 = ccVar;
                                                Attr.absolutePosition$default(ccVar2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                                ccVar2.m150top(16.0f);
                                                ccVar2.m138bottom(16.0f);
                                                ccVar2.m142left(16.0f);
                                                ccVar2.m149right(16.0f);
                                                ccVar2.w("\u8f93\u5165\u6587\u672c");
                                                ccVar2.x(QUIToken.color$default("text_tertiary"));
                                                ccVar2.i(QUIToken.color$default("text_primary"));
                                                cc.m(ccVar2, 17.0f, null, 2, null);
                                                ccVar2.v(76);
                                                NBPManifestoEditPage nBPManifestoEditPage7 = NBPManifestoEditPage.this;
                                                ccVar2.D((String) nBPManifestoEditPage7.initDeclaration$delegate.getValue(nBPManifestoEditPage7, NBPManifestoEditPage.$$delegatedProperties[0]));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPManifestoEditPage nBPManifestoEditPage7 = NBPManifestoEditPage.this;
                                        textAreaView2.event(new Function1<TextAreaEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.2.2.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextAreaEvent textAreaEvent) {
                                                TextAreaEvent textAreaEvent2 = textAreaEvent;
                                                final NBPManifestoEditPage nBPManifestoEditPage8 = NBPManifestoEditPage.this;
                                                TextAreaEvent.o(textAreaEvent2, false, new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.2.2.3.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(InputParams inputParams) {
                                                        CharSequence trimEnd;
                                                        trimEnd = StringsKt__StringsKt.trimEnd((CharSequence) inputParams.getText());
                                                        String obj = trimEnd.toString();
                                                        if (obj.length() >= 76) {
                                                            obj = obj.substring(0, 76);
                                                            Intrinsics.checkNotNullExpressionValue(obj, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                        }
                                                        NBPManifestoEditPage nBPManifestoEditPage9 = NBPManifestoEditPage.this;
                                                        nBPManifestoEditPage9.currentDeclaration$delegate.setValue(nBPManifestoEditPage9, NBPManifestoEditPage.$$delegatedProperties[1], obj);
                                                        return Unit.INSTANCE;
                                                    }
                                                }, 1, null);
                                                textAreaEvent2.p(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.2.2.3.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(Object obj) {
                                                        Utils.INSTANCE.currentBridgeModule().qToast("\u8f93\u5165\u6587\u5b57\u4e0d\u8981\u8d85\u8fc776\u5b57", QToastMode.Info);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPManifestoEditPage nBPManifestoEditPage5 = NBPManifestoEditPage.this;
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.2.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        final NBPManifestoEditPage nBPManifestoEditPage6 = NBPManifestoEditPage.this;
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.2.3.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                CharSequence trimEnd;
                                                CharSequence trimEnd2;
                                                ce ceVar2 = ceVar;
                                                Attr.absolutePosition$default(ceVar2, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
                                                ceVar2.m138bottom(15.0f);
                                                ceVar2.m149right(25.0f);
                                                ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                ceVar2.lines(1);
                                                ceVar2.fontWeight400();
                                                trimEnd = StringsKt__StringsKt.trimEnd((CharSequence) NBPManifestoEditPage.access$getCurrentDeclaration(NBPManifestoEditPage.this));
                                                if (trimEnd.toString().length() == 76) {
                                                    ceVar2.color(QUIToken.color$default("feedback_error"));
                                                } else {
                                                    ceVar2.color(QUIToken.color$default("text_secondary"));
                                                }
                                                StringBuilder sb5 = new StringBuilder();
                                                trimEnd2 = StringsKt__StringsKt.trimEnd((CharSequence) NBPManifestoEditPage.access$getCurrentDeclaration(NBPManifestoEditPage.this));
                                                sb5.append(trimEnd2.toString().length());
                                                sb5.append("/76");
                                                ceVar2.text(sb5.toString());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPManifestoEditPage nBPManifestoEditPage4 = NBPManifestoEditPage.this;
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(t tVar) {
                                        t tVar2 = tVar;
                                        tVar2.margin(16.0f, 16.0f, 0.0f, 16.0f);
                                        tVar2.mo141height(115.0f);
                                        tVar2.borderRadius(8.0f);
                                        tVar2.mo113backgroundColor(QUIToken.color$default("fill_light_secondary"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(TextView textView) {
                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ce ceVar) {
                                                ce ceVar2 = ceVar;
                                                ceVar2.marginLeft(16.0f);
                                                ceVar2.marginTop(16.0f);
                                                ceVar2.text("\u770b\u770b\u522b\u4eba\u600e\u4e48\u8bf4");
                                                ceVar2.fontWeight400();
                                                ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
                                                ceVar2.color(new h(9211020L, 1.0f));
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPManifestoEditPage nBPManifestoEditPage5 = NBPManifestoEditPage.this;
                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.3
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar5) {
                                        v vVar6 = vVar5;
                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.margin(8.0f, 16.0f, 16.0f, 16.0f);
                                                tVar2.mo141height(52.0f);
                                                tVar2.borderRadius(4.0f);
                                                tVar2.flexDirectionRow();
                                                tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                                tVar2.alignItemsCenter();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPManifestoEditPage nBPManifestoEditPage6 = NBPManifestoEditPage.this;
                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.3.2
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(TextView textView) {
                                                TextView textView2 = textView;
                                                final NBPManifestoEditPage nBPManifestoEditPage7 = NBPManifestoEditPage.this;
                                                textView2.ref(textView2, new Function1<aa<TextView>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.3.2.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(aa<TextView> aaVar) {
                                                        NBPManifestoEditPage.this.textViewRef = aaVar;
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPManifestoEditPage nBPManifestoEditPage8 = NBPManifestoEditPage.this;
                                                textView2.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.3.2.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ce ceVar) {
                                                        ce ceVar2 = ceVar;
                                                        ceVar2.lines(2);
                                                        ceVar2.text(NBPManifestoEditPage.this.recommendDeclaration);
                                                        ceVar2.color(new h(9211020L, 1.0f));
                                                        ceVar2.fontWeight400();
                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                        ceVar2.marginLeft(12.0f);
                                                        ceVar2.mo153width(ceVar2.getPagerData().m() - 112.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPManifestoEditPage nBPManifestoEditPage9 = NBPManifestoEditPage.this;
                                                textView2.event(new Function1<TextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.3.2.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(TextEvent textEvent) {
                                                        final NBPManifestoEditPage nBPManifestoEditPage10 = NBPManifestoEditPage.this;
                                                        textEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.3.2.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                NBPManifestoEditPage nBPManifestoEditPage11 = NBPManifestoEditPage.this;
                                                                ReadWriteProperty readWriteProperty = nBPManifestoEditPage11.initDeclaration$delegate;
                                                                KProperty<?>[] kPropertyArr = NBPManifestoEditPage.$$delegatedProperties;
                                                                if (!Intrinsics.areEqual((String) readWriteProperty.getValue(nBPManifestoEditPage11, kPropertyArr[0]), NBPManifestoEditPage.this.recommendDeclaration)) {
                                                                    NBPManifestoEditPage nBPManifestoEditPage12 = NBPManifestoEditPage.this;
                                                                    nBPManifestoEditPage12.initDeclaration$delegate.setValue(nBPManifestoEditPage12, kPropertyArr[0], "");
                                                                    NBPManifestoEditPage nBPManifestoEditPage13 = NBPManifestoEditPage.this;
                                                                    nBPManifestoEditPage13.initDeclaration$delegate.setValue(nBPManifestoEditPage13, kPropertyArr[0], nBPManifestoEditPage13.recommendDeclaration);
                                                                }
                                                                e dtDeclarationPageParam = NBPManifestoEditPage.this.getDtDeclarationPageParam();
                                                                dtDeclarationPageParam.v("dt_eid", "em_nearby_kl_fill_text");
                                                                dtDeclarationPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dtDeclarationPageParam);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        final NBPManifestoEditPage nBPManifestoEditPage7 = NBPManifestoEditPage.this;
                                        w.a(vVar6, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.3.3
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar7) {
                                                v vVar8 = vVar7;
                                                vVar8.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.3.3.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.positionAbsolute();
                                                        tVar2.m149right(12.0f);
                                                        tVar2.m150top(0.0f);
                                                        tVar2.m138bottom(0.0f);
                                                        tVar2.justifyContentCenter();
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                ah.a(vVar8, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.3.3.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ImageView imageView) {
                                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.3.3.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(af afVar) {
                                                                af afVar2 = afVar;
                                                                afVar2.size(16.0f, 16.0f);
                                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_BRRaDZOKepp.png", false, 2, null);
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPManifestoEditPage nBPManifestoEditPage8 = NBPManifestoEditPage.this;
                                                vVar8.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.3.3.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        final NBPManifestoEditPage nBPManifestoEditPage9 = NBPManifestoEditPage.this;
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.3.3.3.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ClickParams clickParams) {
                                                                Object random;
                                                                TextView b16;
                                                                NBPManifestoEditPage nBPManifestoEditPage10 = NBPManifestoEditPage.this;
                                                                random = CollectionsKt___CollectionsKt.random(nBPManifestoEditPage10.recommendDeclarations, Random.INSTANCE);
                                                                nBPManifestoEditPage10.recommendDeclaration = (String) random;
                                                                aa<TextView> aaVar = NBPManifestoEditPage.this.textViewRef;
                                                                if (aaVar != null && (b16 = aaVar.b()) != null) {
                                                                    final NBPManifestoEditPage nBPManifestoEditPage11 = NBPManifestoEditPage.this;
                                                                    b16.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage.body.1.3.3.3.3.3.1.1
                                                                        {
                                                                            super(1);
                                                                        }

                                                                        @Override // kotlin.jvm.functions.Function1
                                                                        public final Unit invoke(ce ceVar) {
                                                                            ceVar.text(NBPManifestoEditPage.this.recommendDeclaration);
                                                                            return Unit.INSTANCE;
                                                                        }
                                                                    });
                                                                }
                                                                e dtDeclarationPageParam = NBPManifestoEditPage.this.getDtDeclarationPageParam();
                                                                dtDeclarationPageParam.v("dt_eid", "em_nearby_kl_refresh_btn");
                                                                dtDeclarationPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dtDeclarationPageParam);
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
        Object random;
        super.created();
        this.appId = getPageData().n().j("appid");
        this.viewModel = new NBPNewEditViewModel(this.appId, 6);
        String base64Code = Utils.INSTANCE.currentBridgeModule().base64Code(getPageData().n().p("declaration"), false);
        this.oldDeclaration = base64Code;
        if (base64Code.length() > 76) {
            String substring = this.oldDeclaration.substring(0, 76);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            this.oldDeclaration = substring;
        }
        String str = this.oldDeclaration;
        ReadWriteProperty readWriteProperty = this.currentDeclaration$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[1], str);
        this.initDeclaration$delegate.setValue(this, kPropertyArr[0], this.oldDeclaration);
        random = CollectionsKt___CollectionsKt.random(this.recommendDeclarations, Random.INSTANCE);
        this.recommendDeclaration = (String) random;
    }

    public final e getDtDeclarationPageParam() {
        e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
        nearbyDTBaseParams.v("dt_pgid", "pg_nearby_pal_declaration");
        nearbyDTBaseParams.t("nearby_kl_appid", this.appId);
        e eVar = new e();
        eVar.t("nearby_kl_appid", this.appId);
        Unit unit = Unit.INSTANCE;
        nearbyDTBaseParams.v("cur_pg", eVar);
        return nearbyDTBaseParams;
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            showAlertWhenExit();
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        super.pageWillDestroy();
        KLog.INSTANCE.i("NBPSetProfileTagEditPage", Pager.PAGER_EVENT_WILL_DESTROY);
        reportPageExposure(false);
    }

    public final void showAlertWhenExit() {
        if (!Intrinsics.areEqual((String) this.currentDeclaration$delegate.getValue(this, $$delegatedProperties[1]), this.oldDeclaration)) {
            ((QQUIModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("QQUIModule")).openAlertDialog("", "\u662f\u5426\u653e\u5f03\u7f16\u8f91", "\u7ee7\u7eed\u7f16\u8f91", "\u653e\u5f03", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.NBPManifestoEditPage$showAlertWhenExit$1
                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Boolean bool, Boolean bool2) {
                    boolean booleanValue = bool.booleanValue();
                    bool2.booleanValue();
                    if (booleanValue) {
                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                        QQKuiklyPlatformApi.Companion.closePage$default();
                    }
                    return Unit.INSTANCE;
                }
            });
        } else {
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.closePage$default();
        }
        e dtDeclarationPageParam = getDtDeclarationPageParam();
        dtDeclarationPageParam.v("dt_eid", "em_nearby_kl_return_btn");
        dtDeclarationPageParam.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dtDeclarationPageParam);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        reportPageExposure(true);
    }

    public final void reportPageExposure(boolean z16) {
        String str;
        if (z16) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_pal_declaration");
        m3.t("nearby_kl_appid", this.appId);
        m3.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, m3);
    }
}
