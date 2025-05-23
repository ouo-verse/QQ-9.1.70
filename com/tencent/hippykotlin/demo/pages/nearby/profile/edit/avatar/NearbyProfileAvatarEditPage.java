package com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar;

import c01.c;
import c45.i;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BasePager;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.ImageAttrExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGAttr;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGView;
import com.tencent.hippykotlin.demo.pages.foundation.view.PAGViewKt;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.AvatarEditBackgroundData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.AvatarEditHeadActionData;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoService$sendProxyRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.module.NearbyProfileBridgeModule;
import com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.repository.AvatarEditHeadDressBorderData;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.BorderStyle;
import com.tencent.kuikly.core.base.Direction;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.attr.c;
import com.tencent.kuikly.core.base.attr.e;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.j;
import com.tencent.kuikly.core.directives.BindDirectivesView;
import com.tencent.kuikly.core.directives.BindDirectivesViewKt;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.directives.LoopDirectivesView;
import com.tencent.kuikly.core.directives.LoopDirectivesViewKt;
import com.tencent.kuikly.core.layout.FlexWrap;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.views.ActionSheetAttr;
import com.tencent.kuikly.core.views.ActionSheetView;
import com.tencent.kuikly.core.views.ImageEvent;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ModalView;
import com.tencent.kuikly.core.views.ScrollerView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.ao;
import com.tencent.kuikly.core.views.aq;
import com.tencent.kuikly.core.views.ar;
import com.tencent.kuikly.core.views.bb;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.compose.ButtonView;
import com.tencent.kuikly.core.views.compose.a;
import com.tencent.kuikly.core.views.d;
import com.tencent.kuikly.core.views.e;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.mobileqq.soload.api.SoLoad;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import s35.s;

/* loaded from: classes31.dex */
public final class NearbyProfileAvatarEditPage extends BasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyProfileAvatarEditPage.class, "showActionSheet", "getShowActionSheet()Z", 0)};
    public aa<aq<?, ?>> bgListRef;
    public NearbyProfileAvatarEditViewModel viewModel;
    public final ReadWriteProperty showActionSheet$delegate = c.a(Boolean.TRUE);
    public int appId = 2;

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage = NearbyProfileAvatarEditPage.this;
                e.a(viewContainer, new Function1<ActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ActionSheetView actionSheetView) {
                        ActionSheetView actionSheetView2 = actionSheetView;
                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage2 = NearbyProfileAvatarEditPage.this;
                        actionSheetView2.attr(new Function1<ActionSheetAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ActionSheetAttr actionSheetAttr) {
                                ActionSheetAttr actionSheetAttr2 = actionSheetAttr;
                                NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage3 = NearbyProfileAvatarEditPage.this;
                                actionSheetAttr2.w(((Boolean) nearbyProfileAvatarEditPage3.showActionSheet$delegate.getValue(nearbyProfileAvatarEditPage3, NearbyProfileAvatarEditPage.$$delegatedProperties[0])).booleanValue());
                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage4 = NearbyProfileAvatarEditPage.this;
                                actionSheetAttr2.j(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage5 = NearbyProfileAvatarEditPage.this;
                                        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_middle_light"));
                                                        tVar2.alignItemsCenter();
                                                        tVar2.borderRadius(8.0f, 8.0f, 0.0f, 0.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        vVar3.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.mo135backgroundLinearGradient(Direction.TO_BOTTOM, new j(new h(419469823L), 0.0f), new j(new h(14277081L), 1.0f));
                                                                tVar2.absolutePositionAllZero();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage6 = NearbyProfileAvatarEditPage.this;
                                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        v vVar4 = vVar3;
                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.size(tVar2.getPagerData().m(), 51.0f);
                                                                tVar2.alignItemsCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage7 = NearbyProfileAvatarEditPage.this;
                                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar5) {
                                                                v vVar6 = vVar5;
                                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.3.2.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.size(tVar2.getPagerData().m(), 34.0f);
                                                                        tVar2.allCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage8 = NearbyProfileAvatarEditPage.this;
                                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.3.2.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ImageView imageView) {
                                                                        ImageView imageView2 = imageView;
                                                                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.3.2.2.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(af afVar) {
                                                                                af afVar2 = afVar;
                                                                                afVar2.size(24.0f, 24.0f);
                                                                                afVar2.m142left(24.5f);
                                                                                afVar2.m150top(10.0f);
                                                                                b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_w40dODQavm4.png", false, 2, null);
                                                                                afVar2.t(QUIToken.color$default("icon_primary"));
                                                                                Attr.absolutePosition$default(afVar2, 10.0f, 16.0f, 0.0f, 0.0f, 12, null);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage9 = NearbyProfileAvatarEditPage.this;
                                                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.3.2.2.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageEvent imageEvent) {
                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage10 = NearbyProfileAvatarEditPage.this;
                                                                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.3.2.2.2.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                        NearbyProfileAvatarEditPage.this.getViewModel().closePage();
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage9 = NearbyProfileAvatarEditPage.this;
                                                                cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.3.2.3
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage10 = NearbyProfileAvatarEditPage.this;
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.3.2.3.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                String str;
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.fontWeight500();
                                                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                                                ceVar2.fontFamily("PingFang SC");
                                                                                StringBuilder sb5 = new StringBuilder();
                                                                                sb5.append("\u6211\u7684");
                                                                                int i3 = NearbyProfileAvatarEditPage.this.appId;
                                                                                if (i3 == 1) {
                                                                                    str = SoLoad.BIZ_TRTC_PARTY_HOUSE;
                                                                                } else if (i3 != 2) {
                                                                                    str = "";
                                                                                } else {
                                                                                    str = "\u9644\u8fd1";
                                                                                }
                                                                                sb5.append(str);
                                                                                sb5.append("\u5934\u50cf");
                                                                                ceVar2.text(sb5.toString());
                                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                                ceVar2.marginTop(10.0f);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage8 = NearbyProfileAvatarEditPage.this;
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.3.3
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage9 = NearbyProfileAvatarEditPage.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.3.3.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        String str;
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.fontWeight400();
                                                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                        ceVar2.fontFamily("PingFang SC");
                                                                        StringBuilder sb5 = new StringBuilder();
                                                                        sb5.append("\u9009\u62e9\u7684\u5934\u50cf\u4ec5\u5728\u300c");
                                                                        int i3 = NearbyProfileAvatarEditPage.this.appId;
                                                                        if (i3 == 1) {
                                                                            str = SoLoad.BIZ_TRTC_PARTY_HOUSE;
                                                                        } else if (i3 != 2) {
                                                                            str = "";
                                                                        } else {
                                                                            str = "\u9644\u8fd1";
                                                                        }
                                                                        sb5.append(str);
                                                                        sb5.append("\u300d\u4f7f\u7528");
                                                                        ceVar2.text(sb5.toString());
                                                                        ce.fontSize$default(ceVar2, 12.0f, null, 2, null);
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage7 = NearbyProfileAvatarEditPage.this;
                                                Function0<Object> function0 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.4
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        boolean z16;
                                                        if (!NearbyProfileAvatarEditPage.this.getViewModel().isNetworkError()) {
                                                            NearbyProfileAvatarEditViewModel viewModel = NearbyProfileAvatarEditPage.this.getViewModel();
                                                            if (((Boolean) viewModel.isBatchRecordFinish$delegate.getValue(viewModel, NearbyProfileAvatarEditViewModel.$$delegatedProperties[3])).booleanValue()) {
                                                                z16 = true;
                                                                return Boolean.valueOf(z16);
                                                            }
                                                        }
                                                        z16 = false;
                                                        return Boolean.valueOf(z16);
                                                    }
                                                };
                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage8 = NearbyProfileAvatarEditPage.this;
                                                ConditionViewKt.c(vVar2, function0, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView) {
                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage9 = NearbyProfileAvatarEditPage.this;
                                                        ar.a(conditionView, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(aq<?, ?> aqVar) {
                                                                aq<?, ?> aqVar2 = aqVar;
                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage10 = NearbyProfileAvatarEditPage.this;
                                                                aqVar2.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ao aoVar) {
                                                                        ao aoVar2 = aoVar;
                                                                        aoVar2.size(NearbyProfileAvatarEditPage.this.getPageData().m(), (NearbyProfileAvatarEditPage.this.getPageData().l() * 0.78f) - 51.0f);
                                                                        aoVar2.allCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage11 = NearbyProfileAvatarEditPage.this;
                                                                w.a(aqVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar3) {
                                                                        v vVar4 = vVar3;
                                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.size(tVar2.getPagerData().m(), 120.0f);
                                                                                tVar2.allCenter();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage12 = NearbyProfileAvatarEditPage.this;
                                                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(v vVar5) {
                                                                                v vVar6 = vVar5;
                                                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(t tVar) {
                                                                                        t tVar2 = tVar;
                                                                                        tVar2.size(120.0f, 120.0f);
                                                                                        tVar2.mo113backgroundColor(h.INSTANCE.j());
                                                                                        tVar2.marginTop(32.0f);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage13 = NearbyProfileAvatarEditPage.this;
                                                                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.2
                                                                                    {
                                                                                        super(0);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function0
                                                                                    public final Object invoke() {
                                                                                        return NearbyProfileAvatarEditPage.this.getViewModel().getCurBackgroudData();
                                                                                    }
                                                                                };
                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage14 = NearbyProfileAvatarEditPage.this;
                                                                                BindDirectivesViewKt.a(vVar6, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.3
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage15 = NearbyProfileAvatarEditPage.this;
                                                                                        ah.a(bindDirectivesView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.3.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ImageView imageView) {
                                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage16 = NearbyProfileAvatarEditPage.this;
                                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.3.1.1
                                                                                                    {
                                                                                                        super(1);
                                                                                                    }

                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(af afVar) {
                                                                                                        String str;
                                                                                                        af afVar2 = afVar;
                                                                                                        afVar2.size(120.0f, 120.0f);
                                                                                                        AvatarEditBackgroundData curBackgroudData = NearbyProfileAvatarEditPage.this.getViewModel().getCurBackgroudData();
                                                                                                        if (curBackgroudData == null || (str = curBackgroudData.url) == null) {
                                                                                                            str = "";
                                                                                                        }
                                                                                                        ImageAttrExtKt.srcUrl(afVar2, str, null);
                                                                                                        Attr.absolutePosition$default(afVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                                                                                        afVar2.borderRadius(60.0f);
                                                                                                        return Unit.INSTANCE;
                                                                                                    }
                                                                                                });
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage15 = NearbyProfileAvatarEditPage.this;
                                                                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.4
                                                                                    {
                                                                                        super(0);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function0
                                                                                    public final Object invoke() {
                                                                                        return NearbyProfileAvatarEditPage.this.getViewModel().getCurHeadActionData();
                                                                                    }
                                                                                };
                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage16 = NearbyProfileAvatarEditPage.this;
                                                                                BindDirectivesViewKt.a(vVar6, function03, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.5
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage17 = NearbyProfileAvatarEditPage.this;
                                                                                        ah.a(bindDirectivesView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.5.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ImageView imageView) {
                                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage18 = NearbyProfileAvatarEditPage.this;
                                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.5.1.1
                                                                                                    {
                                                                                                        super(1);
                                                                                                    }

                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(af afVar) {
                                                                                                        String str;
                                                                                                        af afVar2 = afVar;
                                                                                                        afVar2.size(120.0f, 120.0f);
                                                                                                        e.Companion companion = com.tencent.kuikly.core.base.attr.e.INSTANCE;
                                                                                                        AvatarEditHeadActionData curHeadActionData = NearbyProfileAvatarEditPage.this.getViewModel().getCurHeadActionData();
                                                                                                        if (curHeadActionData == null || (str = curHeadActionData.getAvatarNormalPath()) == null) {
                                                                                                            str = "";
                                                                                                        }
                                                                                                        b.a.a(afVar2, companion.a(str), false, 2, null);
                                                                                                        Attr.absolutePosition$default(afVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                                                                                        afVar2.borderRadius(60.0f);
                                                                                                        return Unit.INSTANCE;
                                                                                                    }
                                                                                                });
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage17 = NearbyProfileAvatarEditPage.this;
                                                                                ConditionViewKt.c(vVar6, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.6
                                                                                    {
                                                                                        super(0);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function0
                                                                                    public final Object invoke() {
                                                                                        AvatarEditHeadDressBorderData curHeadDressBorderData = NearbyProfileAvatarEditPage.this.getViewModel().getCurHeadDressBorderData();
                                                                                        String str = curHeadDressBorderData != null ? curHeadDressBorderData.url : null;
                                                                                        return Boolean.valueOf(str == null || str.length() == 0);
                                                                                    }
                                                                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.7
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ConditionView conditionView2) {
                                                                                        w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.7.1
                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(v vVar7) {
                                                                                                vVar7.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.7.1.1
                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(t tVar) {
                                                                                                        t tVar2 = tVar;
                                                                                                        tVar2.size(120.0f, 120.0f);
                                                                                                        tVar2.mo113backgroundColor(h.INSTANCE.j());
                                                                                                        tVar2.m136border(new com.tencent.kuikly.core.base.e(2.0f, BorderStyle.SOLID, new h(4294967295L)));
                                                                                                        tVar2.borderRadius(60.0f);
                                                                                                        Attr.absolutePosition$default(tVar2, 0.0f, 0.0f, 0.0f, 0.0f, 12, null);
                                                                                                        return Unit.INSTANCE;
                                                                                                    }
                                                                                                });
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage18 = NearbyProfileAvatarEditPage.this;
                                                                                Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.8
                                                                                    {
                                                                                        super(0);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function0
                                                                                    public final Object invoke() {
                                                                                        return NearbyProfileAvatarEditPage.this.getViewModel().getCurHeadDressBorderData();
                                                                                    }
                                                                                };
                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage19 = NearbyProfileAvatarEditPage.this;
                                                                                BindDirectivesViewKt.a(vVar6, function04, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.9
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage20 = NearbyProfileAvatarEditPage.this;
                                                                                        ah.a(bindDirectivesView, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.9.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ImageView imageView) {
                                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage21 = NearbyProfileAvatarEditPage.this;
                                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.2.2.9.1.1
                                                                                                    {
                                                                                                        super(1);
                                                                                                    }

                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(af afVar) {
                                                                                                        String str;
                                                                                                        af afVar2 = afVar;
                                                                                                        afVar2.size(140.0f, 140.0f);
                                                                                                        AvatarEditHeadDressBorderData curHeadDressBorderData = NearbyProfileAvatarEditPage.this.getViewModel().getCurHeadDressBorderData();
                                                                                                        if (curHeadDressBorderData == null || (str = curHeadDressBorderData.url) == null) {
                                                                                                            str = "";
                                                                                                        }
                                                                                                        ImageAttrExtKt.srcUrl(afVar2, str, null);
                                                                                                        Attr.absolutePosition$default(afVar2, -10.0f, -10.0f, 0.0f, 0.0f, 12, null);
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
                                                                cg.a(aqVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.3
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.3.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.fontWeight500();
                                                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                                                ceVar2.fontFamily("PingFang SC");
                                                                                ceVar2.text("\u9009\u62e9\u52a8\u4f5c");
                                                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                                                c.a.a(ceVar2, 25.0f, 20.0f, 0.0f, 0.0f, 12, null);
                                                                                ceVar2.alignSelfFlexStart();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage12 = NearbyProfileAvatarEditPage.this;
                                                                ar.a(aqVar2, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(aq<?, ?> aqVar3) {
                                                                        aq<?, ?> aqVar4 = aqVar3;
                                                                        aqVar4.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ao aoVar) {
                                                                                ao aoVar2 = aoVar;
                                                                                c.a.a(aoVar2, 7.5f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                                aoVar2.marginLeft(10.0f);
                                                                                aoVar2.size(aoVar2.getPagerData().m() - 22.0f, 69.0f);
                                                                                aoVar2.flexDirectionRow();
                                                                                aoVar2.scrollEnable(true);
                                                                                aoVar2.showScrollerIndicator(false);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage13 = NearbyProfileAvatarEditPage.this;
                                                                        Function0<com.tencent.kuikly.core.reactive.collection.c<AvatarEditHeadActionData>> function02 = new Function0<com.tencent.kuikly.core.reactive.collection.c<AvatarEditHeadActionData>>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4.2
                                                                            {
                                                                                super(0);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function0
                                                                            public final com.tencent.kuikly.core.reactive.collection.c<AvatarEditHeadActionData> invoke() {
                                                                                return NearbyProfileAvatarEditPage.this.getViewModel().getHeadActionDataList();
                                                                            }
                                                                        };
                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage14 = NearbyProfileAvatarEditPage.this;
                                                                        LoopDirectivesViewKt.a(aqVar4, function02, new Function2<LoopDirectivesView<AvatarEditHeadActionData>, AvatarEditHeadActionData, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4.3
                                                                            {
                                                                                super(2);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function2
                                                                            public final Unit invoke(LoopDirectivesView<AvatarEditHeadActionData> loopDirectivesView, AvatarEditHeadActionData avatarEditHeadActionData) {
                                                                                final AvatarEditHeadActionData avatarEditHeadActionData2 = avatarEditHeadActionData;
                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage15 = NearbyProfileAvatarEditPage.this;
                                                                                w.a(loopDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4.3.1
                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(v vVar3) {
                                                                                        v vVar4 = vVar3;
                                                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4.3.1.1
                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(t tVar) {
                                                                                                t tVar2 = tVar;
                                                                                                tVar2.allCenter();
                                                                                                tVar2.size(70.0f, 69.0f);
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        final AvatarEditHeadActionData avatarEditHeadActionData3 = AvatarEditHeadActionData.this;
                                                                                        ConditionViewKt.c(vVar4, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4.3.1.2
                                                                                            {
                                                                                                super(0);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function0
                                                                                            public final Object invoke() {
                                                                                                AvatarEditHeadActionData avatarEditHeadActionData4 = AvatarEditHeadActionData.this;
                                                                                                return Boolean.valueOf(((Boolean) avatarEditHeadActionData4.isSelected$delegate.getValue(avatarEditHeadActionData4, AvatarEditHeadActionData.$$delegatedProperties[1])).booleanValue());
                                                                                            }
                                                                                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4.3.1.3
                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ConditionView conditionView2) {
                                                                                                w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4.3.1.3.1
                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(v vVar5) {
                                                                                                        vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4.3.1.3.1.1
                                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                                            public final Unit invoke(t tVar) {
                                                                                                                t tVar2 = tVar;
                                                                                                                tVar2.alignItemsCenter();
                                                                                                                tVar2.size(69.0f, 69.0f);
                                                                                                                Attr.absolutePosition$default(tVar2, 0.0f, 0.5f, 0.0f, 0.0f, 12, null);
                                                                                                                tVar2.borderRadius(34.5f);
                                                                                                                tVar2.m136border(new com.tencent.kuikly.core.base.e(3.0f, BorderStyle.SOLID, new h(4278229503L)));
                                                                                                                return Unit.INSTANCE;
                                                                                                            }
                                                                                                        });
                                                                                                        return Unit.INSTANCE;
                                                                                                    }
                                                                                                });
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        final AvatarEditHeadActionData avatarEditHeadActionData4 = AvatarEditHeadActionData.this;
                                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage16 = nearbyProfileAvatarEditPage15;
                                                                                        w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4.3.1.4
                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(v vVar5) {
                                                                                                v vVar6 = vVar5;
                                                                                                vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4.3.1.4.1
                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(t tVar) {
                                                                                                        t tVar2 = tVar;
                                                                                                        tVar2.size(60.0f, 60.0f);
                                                                                                        tVar2.borderRadius(30.0f);
                                                                                                        tVar2.mo113backgroundColor(new h(4293323504L));
                                                                                                        return Unit.INSTANCE;
                                                                                                    }
                                                                                                });
                                                                                                final AvatarEditHeadActionData avatarEditHeadActionData5 = AvatarEditHeadActionData.this;
                                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage17 = nearbyProfileAvatarEditPage16;
                                                                                                ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4.3.1.4.2
                                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                    {
                                                                                                        super(1);
                                                                                                    }

                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(ImageView imageView) {
                                                                                                        ImageView imageView2 = imageView;
                                                                                                        final AvatarEditHeadActionData avatarEditHeadActionData6 = AvatarEditHeadActionData.this;
                                                                                                        imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4.3.1.4.2.1
                                                                                                            {
                                                                                                                super(1);
                                                                                                            }

                                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                                            public final Unit invoke(af afVar) {
                                                                                                                af afVar2 = afVar;
                                                                                                                afVar2.size(60.0f, 60.0f);
                                                                                                                b.a.a(afVar2, com.tencent.kuikly.core.base.attr.e.INSTANCE.a(AvatarEditHeadActionData.this.getAvatarNormalPath()), false, 2, null);
                                                                                                                afVar2.borderRadius(30.0f);
                                                                                                                return Unit.INSTANCE;
                                                                                                            }
                                                                                                        });
                                                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage18 = nearbyProfileAvatarEditPage17;
                                                                                                        final AvatarEditHeadActionData avatarEditHeadActionData7 = AvatarEditHeadActionData.this;
                                                                                                        imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4.3.1.4.2.2
                                                                                                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                            {
                                                                                                                super(1);
                                                                                                            }

                                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                                            public final Unit invoke(ImageEvent imageEvent) {
                                                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage19 = NearbyProfileAvatarEditPage.this;
                                                                                                                final AvatarEditHeadActionData avatarEditHeadActionData8 = avatarEditHeadActionData7;
                                                                                                                imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.4.3.1.4.2.2.1
                                                                                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                    {
                                                                                                                        super(1);
                                                                                                                    }

                                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                                                        NearbyProfileAvatarEditViewModel viewModel = NearbyProfileAvatarEditPage.this.getViewModel();
                                                                                                                        AvatarEditHeadActionData avatarEditHeadActionData9 = avatarEditHeadActionData8;
                                                                                                                        AvatarEditHeadActionData curHeadActionData = viewModel.getCurHeadActionData();
                                                                                                                        if (!(curHeadActionData != null && avatarEditHeadActionData9.actionId == curHeadActionData.actionId)) {
                                                                                                                            AvatarEditHeadActionData curHeadActionData2 = viewModel.getCurHeadActionData();
                                                                                                                            if (curHeadActionData2 != null) {
                                                                                                                                curHeadActionData2.setSelected(false);
                                                                                                                            }
                                                                                                                            avatarEditHeadActionData9.setSelected(true);
                                                                                                                            viewModel.setCurHeadActionData(avatarEditHeadActionData9);
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
                                                                });
                                                                cg.a(aqVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.5
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.5.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.fontWeight500();
                                                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                                                ceVar2.fontFamily("PingFang SC");
                                                                                ceVar2.text("\u9009\u62e9\u80cc\u666f");
                                                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                                                c.a.a(ceVar2, 19.5f, 20.0f, 0.0f, 0.0f, 12, null);
                                                                                ceVar2.alignSelfFlexStart();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage13 = NearbyProfileAvatarEditPage.this;
                                                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.6
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        return NearbyProfileAvatarEditPage.this.getViewModel().getBackgroundDataList();
                                                                    }
                                                                };
                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage14 = NearbyProfileAvatarEditPage.this;
                                                                BindDirectivesViewKt.a(aqVar2, function02, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.7
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage15 = NearbyProfileAvatarEditPage.this;
                                                                        ar.a(bindDirectivesView, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.7.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(aq<?, ?> aqVar3) {
                                                                                aq<?, ?> aqVar4 = aqVar3;
                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage16 = NearbyProfileAvatarEditPage.this;
                                                                                aqVar4.ref(aqVar4, new Function1<aa<aq<?, ?>>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.7.1.1
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(aa<aq<?, ?>> aaVar) {
                                                                                        NearbyProfileAvatarEditPage.this.bgListRef = aaVar;
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                aqVar4.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.7.1.2
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ao aoVar) {
                                                                                        ao aoVar2 = aoVar;
                                                                                        c.a.a(aoVar2, 9.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                                        aoVar2.marginLeft(10.0f);
                                                                                        aoVar2.size(aoVar2.getPagerData().m(), 46.0f);
                                                                                        aoVar2.flexDirectionRow();
                                                                                        aoVar2.scrollEnable(true);
                                                                                        aoVar2.showScrollerIndicator(false);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                ArrayList<AvatarEditBackgroundData> backgroundDataList = NearbyProfileAvatarEditPage.this.getViewModel().getBackgroundDataList();
                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage17 = NearbyProfileAvatarEditPage.this;
                                                                                for (final AvatarEditBackgroundData avatarEditBackgroundData : backgroundDataList) {
                                                                                    w.a(aqVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage$body$1$1$1$1$1$5$1$7$1$3$1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(v vVar3) {
                                                                                            v vVar4 = vVar3;
                                                                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage$body$1$1$1$1$1$5$1$7$1$3$1.1
                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(t tVar) {
                                                                                                    t tVar2 = tVar;
                                                                                                    tVar2.allCenter();
                                                                                                    tVar2.size(50.0f, 46.0f);
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            final AvatarEditBackgroundData avatarEditBackgroundData2 = AvatarEditBackgroundData.this;
                                                                                            ConditionViewKt.c(vVar4, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage$body$1$1$1$1$1$5$1$7$1$3$1.2
                                                                                                {
                                                                                                    super(0);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                                public final Object invoke() {
                                                                                                    AvatarEditBackgroundData avatarEditBackgroundData3 = AvatarEditBackgroundData.this;
                                                                                                    return Boolean.valueOf(((Boolean) avatarEditBackgroundData3.isSelected$delegate.getValue(avatarEditBackgroundData3, AvatarEditBackgroundData.$$delegatedProperties[0])).booleanValue());
                                                                                                }
                                                                                            }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage$body$1$1$1$1$1$5$1$7$1$3$1.3
                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(ConditionView conditionView2) {
                                                                                                    w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.7.1.3.1.3.1
                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                        public final Unit invoke(v vVar5) {
                                                                                                            vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.7.1.3.1.3.1.1
                                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                                public final Unit invoke(t tVar) {
                                                                                                                    t tVar2 = tVar;
                                                                                                                    tVar2.alignItemsCenter();
                                                                                                                    tVar2.size(46.0f, 46.0f);
                                                                                                                    Attr.absolutePosition$default(tVar2, 0.0f, 2.0f, 0.0f, 0.0f, 12, null);
                                                                                                                    tVar2.borderRadius(23.0f);
                                                                                                                    tVar2.m136border(new com.tencent.kuikly.core.base.e(2.0f, BorderStyle.SOLID, new h(4278229503L)));
                                                                                                                    return Unit.INSTANCE;
                                                                                                                }
                                                                                                            });
                                                                                                            return Unit.INSTANCE;
                                                                                                        }
                                                                                                    });
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            final AvatarEditBackgroundData avatarEditBackgroundData3 = AvatarEditBackgroundData.this;
                                                                                            final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage18 = nearbyProfileAvatarEditPage17;
                                                                                            ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage$body$1$1$1$1$1$5$1$7$1$3$1.4
                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                {
                                                                                                    super(1);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(ImageView imageView) {
                                                                                                    ImageView imageView2 = imageView;
                                                                                                    final AvatarEditBackgroundData avatarEditBackgroundData4 = AvatarEditBackgroundData.this;
                                                                                                    imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.7.1.3.1.4.1
                                                                                                        {
                                                                                                            super(1);
                                                                                                        }

                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                        public final Unit invoke(af afVar) {
                                                                                                            af afVar2 = afVar;
                                                                                                            afVar2.size(40.0f, 40.0f);
                                                                                                            ImageAttrExtKt.srcUrl(afVar2, AvatarEditBackgroundData.this.url, null);
                                                                                                            afVar2.borderRadius(20.0f);
                                                                                                            return Unit.INSTANCE;
                                                                                                        }
                                                                                                    });
                                                                                                    final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage19 = nearbyProfileAvatarEditPage18;
                                                                                                    final AvatarEditBackgroundData avatarEditBackgroundData5 = AvatarEditBackgroundData.this;
                                                                                                    imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.7.1.3.1.4.2
                                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                        {
                                                                                                            super(1);
                                                                                                        }

                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                        public final Unit invoke(ImageEvent imageEvent) {
                                                                                                            final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage20 = NearbyProfileAvatarEditPage.this;
                                                                                                            final AvatarEditBackgroundData avatarEditBackgroundData6 = avatarEditBackgroundData5;
                                                                                                            imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.7.1.3.1.4.2.1
                                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                {
                                                                                                                    super(1);
                                                                                                                }

                                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                                                    NearbyProfileAvatarEditViewModel viewModel = NearbyProfileAvatarEditPage.this.getViewModel();
                                                                                                                    AvatarEditBackgroundData avatarEditBackgroundData7 = avatarEditBackgroundData6;
                                                                                                                    AvatarEditBackgroundData curBackgroudData = viewModel.getCurBackgroudData();
                                                                                                                    if (!(curBackgroudData != null && avatarEditBackgroundData7.f114206id == curBackgroudData.f114206id)) {
                                                                                                                        AvatarEditBackgroundData curBackgroudData2 = viewModel.getCurBackgroudData();
                                                                                                                        if (curBackgroudData2 != null) {
                                                                                                                            curBackgroudData2.setSelected(false);
                                                                                                                        }
                                                                                                                        avatarEditBackgroundData7.setSelected(true);
                                                                                                                        viewModel.setCurBackgroudData(avatarEditBackgroundData7);
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
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                cg.a(aqVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.8
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(TextView textView) {
                                                                        textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.8.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ce ceVar) {
                                                                                ce ceVar2 = ceVar;
                                                                                ceVar2.fontWeight500();
                                                                                ceVar2.color(QUIToken.color$default("text_primary"));
                                                                                ceVar2.fontFamily("PingFang SC");
                                                                                ceVar2.text("\u5934\u50cf\u6846");
                                                                                ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
                                                                                c.a.a(ceVar2, 21.0f, 20.0f, 0.0f, 0.0f, 12, null);
                                                                                ceVar2.alignSelfFlexStart();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage15 = NearbyProfileAvatarEditPage.this;
                                                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.9
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        NearbyProfileAvatarEditViewModel viewModel = NearbyProfileAvatarEditPage.this.getViewModel();
                                                                        return (ArrayList) viewModel.headDressBorderDataList$delegate.getValue(viewModel, NearbyProfileAvatarEditViewModel.$$delegatedProperties[2]);
                                                                    }
                                                                };
                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage16 = NearbyProfileAvatarEditPage.this;
                                                                BindDirectivesViewKt.a(aqVar2, function03, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.10
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage17 = NearbyProfileAvatarEditPage.this;
                                                                        ar.a(bindDirectivesView, new Function1<aq<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.10.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(aq<?, ?> aqVar3) {
                                                                                aq<?, ?> aqVar4 = aqVar3;
                                                                                aqVar4.attr(new Function1<ao, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.10.1.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ao aoVar) {
                                                                                        ao aoVar2 = aoVar;
                                                                                        c.a.a(aoVar2, 9.0f, 0.0f, 0.0f, 0.0f, 14, null);
                                                                                        aoVar2.marginLeft(10.0f);
                                                                                        aoVar2.size(aoVar2.getPagerData().m() - 23.0f, 46.0f);
                                                                                        aoVar2.flexDirectionRow();
                                                                                        aoVar2.scrollEnable(true);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                NearbyProfileAvatarEditViewModel viewModel = NearbyProfileAvatarEditPage.this.getViewModel();
                                                                                ArrayList<AvatarEditHeadDressBorderData> arrayList = (ArrayList) viewModel.headDressBorderDataList$delegate.getValue(viewModel, NearbyProfileAvatarEditViewModel.$$delegatedProperties[2]);
                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage18 = NearbyProfileAvatarEditPage.this;
                                                                                for (final AvatarEditHeadDressBorderData avatarEditHeadDressBorderData : arrayList) {
                                                                                    w.a(aqVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage$body$1$1$1$1$1$5$1$10$1$2$1
                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                        {
                                                                                            super(1);
                                                                                        }

                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                        public final Unit invoke(v vVar3) {
                                                                                            v vVar4 = vVar3;
                                                                                            vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage$body$1$1$1$1$1$5$1$10$1$2$1.1
                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(t tVar) {
                                                                                                    t tVar2 = tVar;
                                                                                                    tVar2.allCenter();
                                                                                                    tVar2.size(50.0f, 46.0f);
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            final AvatarEditHeadDressBorderData avatarEditHeadDressBorderData2 = AvatarEditHeadDressBorderData.this;
                                                                                            ConditionViewKt.c(vVar4, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage$body$1$1$1$1$1$5$1$10$1$2$1.2
                                                                                                {
                                                                                                    super(0);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function0
                                                                                                public final Object invoke() {
                                                                                                    AvatarEditHeadDressBorderData avatarEditHeadDressBorderData3 = AvatarEditHeadDressBorderData.this;
                                                                                                    return Boolean.valueOf(((Boolean) avatarEditHeadDressBorderData3.isSelected$delegate.getValue(avatarEditHeadDressBorderData3, AvatarEditHeadDressBorderData.$$delegatedProperties[0])).booleanValue());
                                                                                                }
                                                                                            }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage$body$1$1$1$1$1$5$1$10$1$2$1.3
                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(ConditionView conditionView2) {
                                                                                                    w.a(conditionView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.10.1.2.1.3.1
                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                        public final Unit invoke(v vVar5) {
                                                                                                            vVar5.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.10.1.2.1.3.1.1
                                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                                public final Unit invoke(t tVar) {
                                                                                                                    t tVar2 = tVar;
                                                                                                                    tVar2.alignItemsCenter();
                                                                                                                    tVar2.size(46.0f, 46.0f);
                                                                                                                    Attr.absolutePosition$default(tVar2, 0.0f, 2.0f, 0.0f, 0.0f, 12, null);
                                                                                                                    tVar2.borderRadius(23.0f);
                                                                                                                    tVar2.m136border(new com.tencent.kuikly.core.base.e(2.0f, BorderStyle.SOLID, new h(4278229503L)));
                                                                                                                    return Unit.INSTANCE;
                                                                                                                }
                                                                                                            });
                                                                                                            return Unit.INSTANCE;
                                                                                                        }
                                                                                                    });
                                                                                                    return Unit.INSTANCE;
                                                                                                }
                                                                                            });
                                                                                            final AvatarEditHeadDressBorderData avatarEditHeadDressBorderData3 = AvatarEditHeadDressBorderData.this;
                                                                                            final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage19 = nearbyProfileAvatarEditPage18;
                                                                                            ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage$body$1$1$1$1$1$5$1$10$1$2$1.4
                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                {
                                                                                                    super(1);
                                                                                                }

                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                public final Unit invoke(ImageView imageView) {
                                                                                                    ImageView imageView2 = imageView;
                                                                                                    final AvatarEditHeadDressBorderData avatarEditHeadDressBorderData4 = AvatarEditHeadDressBorderData.this;
                                                                                                    imageView2.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.10.1.2.1.4.1
                                                                                                        {
                                                                                                            super(1);
                                                                                                        }

                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                        public final Unit invoke(af afVar) {
                                                                                                            af afVar2 = afVar;
                                                                                                            afVar2.size(40.0f, 40.0f);
                                                                                                            ImageAttrExtKt.srcUrl(afVar2, AvatarEditHeadDressBorderData.this.showPic, null);
                                                                                                            return Unit.INSTANCE;
                                                                                                        }
                                                                                                    });
                                                                                                    final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage20 = nearbyProfileAvatarEditPage19;
                                                                                                    final AvatarEditHeadDressBorderData avatarEditHeadDressBorderData5 = AvatarEditHeadDressBorderData.this;
                                                                                                    imageView2.event(new Function1<ImageEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.10.1.2.1.4.2
                                                                                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                        {
                                                                                                            super(1);
                                                                                                        }

                                                                                                        @Override // kotlin.jvm.functions.Function1
                                                                                                        public final Unit invoke(ImageEvent imageEvent) {
                                                                                                            final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage21 = NearbyProfileAvatarEditPage.this;
                                                                                                            final AvatarEditHeadDressBorderData avatarEditHeadDressBorderData6 = avatarEditHeadDressBorderData5;
                                                                                                            imageEvent.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.10.1.2.1.4.2.1
                                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                {
                                                                                                                    super(1);
                                                                                                                }

                                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                                public final Unit invoke(ClickParams clickParams) {
                                                                                                                    NearbyProfileAvatarEditPage.this.getViewModel().selectHeadDressBorderData(avatarEditHeadDressBorderData6);
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
                                                                                }
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage17 = NearbyProfileAvatarEditPage.this;
                                                                Function0<Object> function04 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.11
                                                                    {
                                                                        super(0);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function0
                                                                    public final Object invoke() {
                                                                        return NearbyProfileAvatarEditPage.this.getViewModel().getCurHeadActionData();
                                                                    }
                                                                };
                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage18 = NearbyProfileAvatarEditPage.this;
                                                                BindDirectivesViewKt.a(aqVar2, function04, new Function1<BindDirectivesView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.12
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(BindDirectivesView bindDirectivesView) {
                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage19 = NearbyProfileAvatarEditPage.this;
                                                                        w.a(bindDirectivesView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.12.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(v vVar3) {
                                                                                v vVar4 = vVar3;
                                                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.12.1.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(t tVar) {
                                                                                        t tVar2 = tVar;
                                                                                        tVar2.size(tVar2.getPagerData().m(), 45.0f);
                                                                                        tVar2.marginTop(35.0f);
                                                                                        tVar2.allCenter();
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage20 = NearbyProfileAvatarEditPage.this;
                                                                                com.tencent.kuikly.core.views.compose.c.a(vVar4, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.12.1.2
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ButtonView buttonView) {
                                                                                        ButtonView buttonView2 = buttonView;
                                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage21 = NearbyProfileAvatarEditPage.this;
                                                                                        buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.12.1.2.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            /* JADX WARN: Code restructure failed: missing block: B:4:0x0021, code lost:
                                                                                            
                                                                                                if (((java.lang.Boolean) r0.isRecordFinish$delegate.getValue(r0, com.tencent.hippykotlin.demo.pages.nearby.base.data.AvatarEditHeadActionData.$$delegatedProperties[2])).booleanValue() == true) goto L8;
                                                                                             */
                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            /*
                                                                                                Code decompiled incorrectly, please refer to instructions dump.
                                                                                            */
                                                                                            public final Unit invoke(a aVar) {
                                                                                                boolean z16;
                                                                                                h hVar;
                                                                                                a aVar2 = aVar;
                                                                                                AvatarEditHeadActionData curHeadActionData = NearbyProfileAvatarEditPage.this.getViewModel().getCurHeadActionData();
                                                                                                if (curHeadActionData != null) {
                                                                                                    z16 = true;
                                                                                                }
                                                                                                z16 = false;
                                                                                                if (z16) {
                                                                                                    hVar = new h(4278229503L);
                                                                                                } else {
                                                                                                    hVar = new h(2147523071L);
                                                                                                }
                                                                                                aVar2.mo113backgroundColor(hVar);
                                                                                                aVar2.size(168.0f, 45.0f);
                                                                                                aVar2.marginTop(32.0f);
                                                                                                aVar2.marginBottom(70.0f);
                                                                                                aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.12.1.2.1.1
                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(ce ceVar) {
                                                                                                        ce ceVar2 = ceVar;
                                                                                                        ceVar2.fontWeight500();
                                                                                                        ceVar2.color(new h(4294967295L));
                                                                                                        ceVar2.fontFamily("PingFang SC");
                                                                                                        ceVar2.text("\u5b8c\u6210");
                                                                                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                                                        return Unit.INSTANCE;
                                                                                                    }
                                                                                                });
                                                                                                aVar2.borderRadius(4.0f);
                                                                                                AvatarEditHeadActionData curHeadActionData2 = NearbyProfileAvatarEditPage.this.getViewModel().getCurHeadActionData();
                                                                                                aVar2.m151touchEnable(curHeadActionData2 != null ? ((Boolean) curHeadActionData2.isRecordFinish$delegate.getValue(curHeadActionData2, AvatarEditHeadActionData.$$delegatedProperties[2])).booleanValue() : false);
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage22 = NearbyProfileAvatarEditPage.this;
                                                                                        buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.12.1.2.2
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage23 = NearbyProfileAvatarEditPage.this;
                                                                                                bVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.5.1.12.1.2.2.1
                                                                                                    {
                                                                                                        super(1);
                                                                                                    }

                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                    public final Unit invoke(ClickParams clickParams) {
                                                                                                        final NearbyProfileAvatarEditViewModel viewModel = NearbyProfileAvatarEditPage.this.getViewModel();
                                                                                                        if (!NearbyProUtilsKt.checkEditAccess(viewModel.appId)) {
                                                                                                            KLog.INSTANCE.e("NearbyProfileAvatarEditViewModel", "Illegal path, no access to edit");
                                                                                                        } else if (!((Boolean) viewModel.isSettingAvatar$delegate.getValue(viewModel, NearbyProfileAvatarEditViewModel.$$delegatedProperties[8])).booleanValue()) {
                                                                                                            viewModel.setSettingAvatar(true);
                                                                                                            if (viewModel.getCurHeadActionData() == null) {
                                                                                                                viewModel.setSettingAvatar(false);
                                                                                                                KLog.INSTANCE.e("NearbyProfileAvatarEditViewModel", "curHeadActionData is null");
                                                                                                                Utils.INSTANCE.currentBridgeModule().qToast("\u8bf7\u9009\u62e9\u52a8\u4f5c", QToastMode.Warning);
                                                                                                            } else if (viewModel.getCurBackgroudData() == null) {
                                                                                                                viewModel.setSettingAvatar(false);
                                                                                                                KLog.INSTANCE.e("NearbyProfileAvatarEditViewModel", "curBackgroudData is null");
                                                                                                                Utils.INSTANCE.currentBridgeModule().qToast("\u8bf7\u9009\u62e9\u80cc\u666f", QToastMode.Warning);
                                                                                                            } else if (viewModel.getCurHeadDressBorderData() == null) {
                                                                                                                viewModel.setSettingAvatar(false);
                                                                                                                KLog.INSTANCE.e("NearbyProfileAvatarEditViewModel", "curHeadDressBorderData is null");
                                                                                                                Utils.INSTANCE.currentBridgeModule().qToast("\u8bf7\u9009\u62e9\u5934\u50cf\u6846", QToastMode.Warning);
                                                                                                            } else {
                                                                                                                NearbyProfileBridgeModule bridgeModule = viewModel.bridgeModule();
                                                                                                                AvatarEditHeadActionData curHeadActionData = viewModel.getCurHeadActionData();
                                                                                                                Intrinsics.checkNotNull(curHeadActionData);
                                                                                                                AvatarEditBackgroundData curBackgroudData = viewModel.getCurBackgroudData();
                                                                                                                Intrinsics.checkNotNull(curBackgroudData);
                                                                                                                Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit> function1 = new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditViewModel$setAvatarHead$1
                                                                                                                    {
                                                                                                                        super(1);
                                                                                                                    }

                                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
                                                                                                                        com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = eVar;
                                                                                                                        if (eVar2 != null) {
                                                                                                                            if (eVar2.f("isSuccess")) {
                                                                                                                                String p16 = eVar2.p("composeAvatarPath");
                                                                                                                                NearbyProfileBridgeModule bridgeModule2 = NearbyProfileAvatarEditViewModel.this.bridgeModule();
                                                                                                                                final NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel = NearbyProfileAvatarEditViewModel.this;
                                                                                                                                int i3 = nearbyProfileAvatarEditViewModel.appId;
                                                                                                                                Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit> function12 = new Function1<com.tencent.kuikly.core.nvi.serialization.json.e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditViewModel$setAvatarHead$1.1
                                                                                                                                    {
                                                                                                                                        super(1);
                                                                                                                                    }

                                                                                                                                    /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
                                                                                                                                    
                                                                                                                                        if ((r1.length() == 0) != false) goto L44;
                                                                                                                                     */
                                                                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                                                                    /*
                                                                                                                                        Code decompiled incorrectly, please refer to instructions dump.
                                                                                                                                    */
                                                                                                                                    public final Unit invoke(com.tencent.kuikly.core.nvi.serialization.json.e eVar3) {
                                                                                                                                        n35.w wVar;
                                                                                                                                        com.tencent.kuikly.core.nvi.serialization.json.e eVar4 = eVar3;
                                                                                                                                        if (eVar4 != null) {
                                                                                                                                            final String p17 = eVar4.p(PhotoCategorySummaryInfo.AVATAR_URL);
                                                                                                                                            AvatarEditHeadDressBorderData curHeadDressBorderData = NearbyProfileAvatarEditViewModel.this.getCurHeadDressBorderData();
                                                                                                                                            Intrinsics.checkNotNull(curHeadDressBorderData);
                                                                                                                                            String str = curHeadDressBorderData.url;
                                                                                                                                            if (NearbyProfileAvatarEditViewModel.this.appId == 2) {
                                                                                                                                                UserDataManager userDataManager = UserDataManager.INSTANCE;
                                                                                                                                                NBPUserSelfInfo userSelfInfo = userDataManager.getUserSelfInfo();
                                                                                                                                                boolean updateAvatar = userSelfInfo.updateAvatar(p17);
                                                                                                                                                boolean updateAvatarDressBorderUrl = userSelfInfo.updateAvatarDressBorderUrl(str);
                                                                                                                                                if (updateAvatar || updateAvatarDressBorderUrl) {
                                                                                                                                                    userDataManager.saveUserSelfInfo();
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            String p18 = eVar4.p("msgInfo");
                                                                                                                                            if (NearbyProfileAvatarEditViewModel.this.appId == 2) {
                                                                                                                                            }
                                                                                                                                            byte[] a16 = d45.a.a(p18);
                                                                                                                                            List list = null;
                                                                                                                                            byte b16 = 0;
                                                                                                                                            byte b17 = 0;
                                                                                                                                            if (a16 != null) {
                                                                                                                                                wVar = (n35.w) i.b(new n35.w(list, b17 == true ? 1 : 0, 3, b16 == true ? 1 : 0), a16);
                                                                                                                                            } else {
                                                                                                                                                wVar = null;
                                                                                                                                            }
                                                                                                                                            n25.j jVar = new n25.j(wVar, p17, 4);
                                                                                                                                            NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel2 = NearbyProfileAvatarEditViewModel.this;
                                                                                                                                            int i16 = nearbyProfileAvatarEditViewModel2.appId;
                                                                                                                                            AvatarEditHeadActionData curHeadActionData2 = nearbyProfileAvatarEditViewModel2.getCurHeadActionData();
                                                                                                                                            Intrinsics.checkNotNull(curHeadActionData2);
                                                                                                                                            AvatarEditBackgroundData curBackgroudData2 = NearbyProfileAvatarEditViewModel.this.getCurBackgroudData();
                                                                                                                                            Intrinsics.checkNotNull(curBackgroudData2);
                                                                                                                                            AvatarEditHeadDressBorderData curHeadDressBorderData2 = NearbyProfileAvatarEditViewModel.this.getCurHeadDressBorderData();
                                                                                                                                            Intrinsics.checkNotNull(curHeadDressBorderData2);
                                                                                                                                            final NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel3 = NearbyProfileAvatarEditViewModel.this;
                                                                                                                                            final Function1<s35.t, Unit> function13 = new Function1<s35.t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditViewModel.setAvatarHead.1.1.1
                                                                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                                                {
                                                                                                                                                    super(1);
                                                                                                                                                }

                                                                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                                                                public final Unit invoke(s35.t tVar) {
                                                                                                                                                    com.tencent.kuikly.core.nvi.serialization.json.e eVar5 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                                                                                                    NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel4 = NearbyProfileAvatarEditViewModel.this;
                                                                                                                                                    eVar5.v("nearby_modify_type", "head");
                                                                                                                                                    AvatarEditHeadDressBorderData curHeadDressBorderData3 = nearbyProfileAvatarEditViewModel4.getCurHeadDressBorderData();
                                                                                                                                                    Intrinsics.checkNotNull(curHeadDressBorderData3);
                                                                                                                                                    eVar5.v("nearby_frame_id", curHeadDressBorderData3.dressId);
                                                                                                                                                    eVar5.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                                                                                                                                    Utils utils = Utils.INSTANCE;
                                                                                                                                                    utils.currentBridgeModule().reportCustomDtEvent("ev_nearby_modify", eVar5);
                                                                                                                                                    NearbyProfileAvatarEditViewModel.this.setSettingAvatar(false);
                                                                                                                                                    utils.currentBridgeModule().qToast("\u5934\u50cf\u4fee\u6539\u6210\u529f", QToastMode.Success);
                                                                                                                                                    NearbyProfileAvatarEditViewModel.this.closePage();
                                                                                                                                                    k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
                                                                                                                                                    com.tencent.kuikly.core.nvi.serialization.json.e eVar6 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                                                                                                    String str2 = p17;
                                                                                                                                                    eVar6.t("itemId", 1);
                                                                                                                                                    eVar6.v("value", str2);
                                                                                                                                                    Unit unit = Unit.INSTANCE;
                                                                                                                                                    k.d(kVar, "onNearbyProUserInfoChange", eVar6, false, 4, null);
                                                                                                                                                    return Unit.INSTANCE;
                                                                                                                                                }
                                                                                                                                            };
                                                                                                                                            final NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel4 = NearbyProfileAvatarEditViewModel.this;
                                                                                                                                            final Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditViewModel.setAvatarHead.1.1.2
                                                                                                                                                {
                                                                                                                                                    super(2);
                                                                                                                                                }

                                                                                                                                                @Override // kotlin.jvm.functions.Function2
                                                                                                                                                public final Unit invoke(Integer num, String str2) {
                                                                                                                                                    KLog.INSTANCE.e("NearbyProfileAvatarEditViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("requestSetAvatarHead failed, errorCode: ", num.intValue(), ", errorMsg: ", str2));
                                                                                                                                                    NearbyProfileAvatarEditViewModel.this.setSettingAvatar(false);
                                                                                                                                                    Utils.INSTANCE.currentBridgeModule().qToast("\u5934\u50cf\u4fee\u6539\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", QToastMode.Warning);
                                                                                                                                                    return Unit.INSTANCE;
                                                                                                                                                }
                                                                                                                                            };
                                                                                                                                            com.tencent.kuikly.core.nvi.serialization.json.e eVar5 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                                                                                            com.tencent.kuikly.core.nvi.serialization.json.e eVar6 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                                                                                            eVar6.t("actionId", curHeadActionData2.actionId);
                                                                                                                                            eVar6.v("actionName", curHeadActionData2.actionName);
                                                                                                                                            eVar6.v("defaultUrl", curHeadActionData2.defaultUrl);
                                                                                                                                            eVar6.t("avatarSize", curHeadActionData2.avatarSize);
                                                                                                                                            eVar6.v("appearanceKey", curHeadActionData2.appearanceKey);
                                                                                                                                            v35.b bVar2 = curHeadActionData2.boundsClipperInfo;
                                                                                                                                            eVar6.v("boundsClipperInfo_x", Float.valueOf(bVar2 != null ? bVar2.f440925d : 0.0f));
                                                                                                                                            v35.b bVar3 = curHeadActionData2.boundsClipperInfo;
                                                                                                                                            eVar6.v("boundsClipperInfo_y", Float.valueOf(bVar3 != null ? bVar3.f440926e : 0.0f));
                                                                                                                                            v35.b bVar4 = curHeadActionData2.boundsClipperInfo;
                                                                                                                                            eVar6.v("boundsClipperInfo_width", Float.valueOf(bVar4 != null ? bVar4.f440927f : 0.0f));
                                                                                                                                            v35.b bVar5 = curHeadActionData2.boundsClipperInfo;
                                                                                                                                            eVar6.v("boundsClipperInfo_height", Float.valueOf(bVar5 != null ? bVar5.f440928h : 0.0f));
                                                                                                                                            com.tencent.kuikly.core.nvi.serialization.json.b bVar6 = new com.tencent.kuikly.core.nvi.serialization.json.b();
                                                                                                                                            ArrayList<Integer> arrayList = curHeadActionData2.eventTags;
                                                                                                                                            if (arrayList != null) {
                                                                                                                                                Iterator<T> it = arrayList.iterator();
                                                                                                                                                while (it.hasNext()) {
                                                                                                                                                    bVar6.r(((Number) it.next()).intValue());
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            eVar6.v("eventTags", bVar6);
                                                                                                                                            eVar6.v("eventInfo", curHeadActionData2.eventInfo);
                                                                                                                                            Unit unit = Unit.INSTANCE;
                                                                                                                                            eVar5.v("headActionData", eVar6);
                                                                                                                                            com.tencent.kuikly.core.nvi.serialization.json.e eVar7 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                                                                                            eVar7.t("id", curBackgroudData2.f114206id);
                                                                                                                                            eVar7.v("url", curBackgroudData2.url);
                                                                                                                                            eVar5.v("backgroudData", eVar7);
                                                                                                                                            s sVar = new s(jVar, eVar5.toString(), new r25.c(curHeadDressBorderData2.dressId, curHeadDressBorderData2.name, curHeadDressBorderData2.showPic, curHeadDressBorderData2.url, curHeadDressBorderData2.dressStatus));
                                                                                                                                            Function1<PbResponse<u35.b>, Unit> function14 = new Function1<PbResponse<u35.b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.repository.NearbyProfileAvatarEditRepository$setAvatarHead$1
                                                                                                                                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                                                                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                                                                                                {
                                                                                                                                                    super(1);
                                                                                                                                                }

                                                                                                                                                /* JADX WARN: Multi-variable type inference failed */
                                                                                                                                                @Override // kotlin.jvm.functions.Function1
                                                                                                                                                public final Unit invoke(PbResponse<u35.b> pbResponse) {
                                                                                                                                                    PbResponse<u35.b> pbResponse2 = pbResponse;
                                                                                                                                                    KLog kLog = KLog.INSTANCE;
                                                                                                                                                    StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("setAvatarHead proxy retcode:");
                                                                                                                                                    m3.append(pbResponse2.code);
                                                                                                                                                    m3.append(", rsp return code:");
                                                                                                                                                    u35.b bVar7 = pbResponse2.rsp;
                                                                                                                                                    NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, bVar7 != null ? Integer.valueOf(bVar7.f438201d) : null, kLog, "NearbyProfileAvatarEditRepository");
                                                                                                                                                    if (pbResponse2.success && pbResponse2.rsp != null) {
                                                                                                                                                        try {
                                                                                                                                                            Function1<s35.t, Unit> function15 = function13;
                                                                                                                                                            s35.t tVar = new s35.t(0, null, null, null, 15, null);
                                                                                                                                                            u35.b bVar8 = pbResponse2.rsp;
                                                                                                                                                            Intrinsics.checkNotNull(bVar8, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.ProxyRsp");
                                                                                                                                                            function15.invoke(i.b(tVar, bVar8.f438203f.f30291a));
                                                                                                                                                        } catch (Throwable th5) {
                                                                                                                                                            AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("setAvatarHead decode error: ", th5, KLog.INSTANCE, "NearbyProfileAvatarEditRepository");
                                                                                                                                                            function2.invoke(Integer.valueOf(pbResponse2.code), th5.toString());
                                                                                                                                                        }
                                                                                                                                                    } else {
                                                                                                                                                        function2.invoke(Integer.valueOf(pbResponse2.code), "");
                                                                                                                                                    }
                                                                                                                                                    return Unit.INSTANCE;
                                                                                                                                                }
                                                                                                                                            };
                                                                                                                                            QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.UserInfo", "SsoSetAvatarHead", i16, new c45.a(i.d(sVar))));
                                                                                                                                            QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(function14);
                                                                                                                                            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
                                                                                                                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                                                                                                            NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
                                                                                                                                        } else {
                                                                                                                                            KLog.INSTANCE.e("NearbyProfileAvatarEditViewModel", "uploadAvatarImage failed");
                                                                                                                                            Utils.INSTANCE.currentBridgeModule().qToast("\u5934\u50cf\u4fee\u6539\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", QToastMode.Warning);
                                                                                                                                            NearbyProfileAvatarEditViewModel.this.setSettingAvatar(false);
                                                                                                                                        }
                                                                                                                                        return Unit.INSTANCE;
                                                                                                                                    }
                                                                                                                                };
                                                                                                                                bridgeModule2.getClass();
                                                                                                                                com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                                                                                eVar3.v("avatarNormalPath", p16);
                                                                                                                                eVar3.t("appId", i3);
                                                                                                                                bridgeModule2.toNative(false, "uploadAvatarImage", eVar3.toString(), function12, false);
                                                                                                                            } else {
                                                                                                                                KLog.INSTANCE.e("NearbyProfileAvatarEditViewModel", "composeAvatarImage failed");
                                                                                                                                Utils.INSTANCE.currentBridgeModule().qToast("\u5934\u50cf\u4fee\u6539\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", QToastMode.Warning);
                                                                                                                                NearbyProfileAvatarEditViewModel.this.setSettingAvatar(false);
                                                                                                                            }
                                                                                                                        }
                                                                                                                        return Unit.INSTANCE;
                                                                                                                    }
                                                                                                                };
                                                                                                                bridgeModule.getClass();
                                                                                                                com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                                                                com.tencent.kuikly.core.nvi.serialization.json.e eVar2 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                                                                eVar2.v("uin", curHeadActionData.uin);
                                                                                                                eVar2.t("actionId", curHeadActionData.actionId);
                                                                                                                eVar2.v("defaultUrl", curHeadActionData.defaultUrl);
                                                                                                                com.tencent.kuikly.core.nvi.serialization.json.b a16 = o.a(eVar2, "appearanceKey", curHeadActionData.appearanceKey);
                                                                                                                ArrayList<Integer> arrayList = curHeadActionData.eventTags;
                                                                                                                if (arrayList != null) {
                                                                                                                    Iterator<T> it = arrayList.iterator();
                                                                                                                    while (it.hasNext()) {
                                                                                                                        a16.r(((Number) it.next()).intValue());
                                                                                                                    }
                                                                                                                }
                                                                                                                eVar2.v("eventTags", a16);
                                                                                                                Unit unit = Unit.INSTANCE;
                                                                                                                eVar.v("headActionData", eVar2);
                                                                                                                com.tencent.kuikly.core.nvi.serialization.json.e eVar3 = new com.tencent.kuikly.core.nvi.serialization.json.e();
                                                                                                                eVar3.t("id", curBackgroudData.f114206id);
                                                                                                                eVar3.v("url", curBackgroudData.url);
                                                                                                                eVar.v("backgroudData", eVar3);
                                                                                                                eVar.v("avatarNormalPath", curHeadActionData.getAvatarNormalPath());
                                                                                                                bridgeModule.toNative(false, "composeAvatarImage", eVar.toString(), function1, false);
                                                                                                            }
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
                                                });
                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage9 = NearbyProfileAvatarEditPage.this;
                                                Function0<Object> function02 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.6
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        boolean z16;
                                                        if (!NearbyProfileAvatarEditPage.this.getViewModel().isNetworkError()) {
                                                            NearbyProfileAvatarEditViewModel viewModel = NearbyProfileAvatarEditPage.this.getViewModel();
                                                            if (!((Boolean) viewModel.isBatchRecordFinish$delegate.getValue(viewModel, NearbyProfileAvatarEditViewModel.$$delegatedProperties[3])).booleanValue()) {
                                                                z16 = true;
                                                                return Boolean.valueOf(z16);
                                                            }
                                                        }
                                                        z16 = false;
                                                        return Boolean.valueOf(z16);
                                                    }
                                                };
                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage10 = NearbyProfileAvatarEditPage.this;
                                                ConditionViewKt.c(vVar2, function02, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.7
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView) {
                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage11 = NearbyProfileAvatarEditPage.this;
                                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.7.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar3) {
                                                                v vVar4 = vVar3;
                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage12 = NearbyProfileAvatarEditPage.this;
                                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.7.1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.size(NearbyProfileAvatarEditPage.this.getPageData().m(), (NearbyProfileAvatarEditPage.this.getPageData().l() * 0.78f) - 51.0f);
                                                                        tVar2.allCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.7.1.2
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar5) {
                                                                        v vVar6 = vVar5;
                                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.7.1.2.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.marginTop(-100.0f);
                                                                                tVar2.flexWrap(FlexWrap.WRAP);
                                                                                tVar2.flexDirectionColumn();
                                                                                tVar2.alignItemsCenter();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        PAGViewKt.PAG(vVar6, new Function1<PAGView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.7.1.2.2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(PAGView pAGView) {
                                                                                pAGView.attr(new Function1<PAGAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.7.1.2.2.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(PAGAttr pAGAttr) {
                                                                                        PAGAttr pAGAttr2 = pAGAttr;
                                                                                        pAGAttr2.size(132.0f, 132.0f);
                                                                                        pAGAttr2.autoPlay(true);
                                                                                        pAGAttr2.repeatCount(10);
                                                                                        pAGAttr2.src("https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/PaYAhldu.pag");
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        cg.a(vVar6, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.7.1.2.3
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(TextView textView) {
                                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.7.1.2.3.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(ce ceVar) {
                                                                                        ce ceVar2 = ceVar;
                                                                                        ceVar2.marginTop(9.0f);
                                                                                        ceVar2.fontWeight500();
                                                                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                                        ceVar2.fontFamily("PingFang SC");
                                                                                        ceVar2.text("\u6b63\u5728\u51c6\u5907\u5934\u50cf");
                                                                                        ce.fontSize$default(ceVar2, 16.0f, null, 2, null);
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
                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage11 = NearbyProfileAvatarEditPage.this;
                                                Function0<Object> function03 = new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.8
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        return Boolean.valueOf(NearbyProfileAvatarEditPage.this.getViewModel().isNetworkError());
                                                    }
                                                };
                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage12 = NearbyProfileAvatarEditPage.this;
                                                ConditionViewKt.c(vVar2, function03, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.9
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView) {
                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage13 = NearbyProfileAvatarEditPage.this;
                                                        w.a(conditionView, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.9.1
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(v vVar3) {
                                                                v vVar4 = vVar3;
                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage14 = NearbyProfileAvatarEditPage.this;
                                                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.9.1.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(t tVar) {
                                                                        t tVar2 = tVar;
                                                                        tVar2.size(NearbyProfileAvatarEditPage.this.getPageData().m(), (NearbyProfileAvatarEditPage.this.getPageData().l() * 0.78f) - 51.0f);
                                                                        tVar2.allCenter();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage15 = NearbyProfileAvatarEditPage.this;
                                                                w.a(vVar4, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.9.1.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar5) {
                                                                        v vVar6 = vVar5;
                                                                        vVar6.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.9.1.2.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.marginTop(-100.0f);
                                                                                tVar2.flexWrap(FlexWrap.WRAP);
                                                                                tVar2.flexDirectionColumn();
                                                                                tVar2.alignItemsCenter();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        ah.a(vVar6, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.9.1.2.2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ImageView imageView) {
                                                                                imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.9.1.2.2.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(af afVar) {
                                                                                        af afVar2 = afVar;
                                                                                        afVar2.size(100.0f, 100.0f);
                                                                                        b.a.b(afVar2, "https://image.superqqshow.qq.com/wuji/qq_lplan/lplan_pic_resouce/3c6784d9_BlCuWe2DE2F.png", false, 2, null);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage16 = NearbyProfileAvatarEditPage.this;
                                                                        com.tencent.kuikly.core.views.compose.c.a(vVar6, new Function1<ButtonView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.9.1.2.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ButtonView buttonView) {
                                                                                ButtonView buttonView2 = buttonView;
                                                                                buttonView2.attr(new Function1<a, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.9.1.2.3.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(a aVar) {
                                                                                        a aVar2 = aVar;
                                                                                        aVar2.mo113backgroundColor(new h(4278229503L));
                                                                                        aVar2.size(168.0f, 45.0f);
                                                                                        aVar2.marginTop(10.0f);
                                                                                        aVar2.q(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.9.1.2.3.1.1
                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ce ceVar) {
                                                                                                ce ceVar2 = ceVar;
                                                                                                ceVar2.fontWeight500();
                                                                                                ceVar2.color(new h(4294967295L));
                                                                                                ceVar2.fontFamily("PingFang SC");
                                                                                                ceVar2.text("\u70b9\u51fb\u91cd\u8bd5");
                                                                                                ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                                                                                return Unit.INSTANCE;
                                                                                            }
                                                                                        });
                                                                                        aVar2.borderRadius(4.0f);
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage17 = NearbyProfileAvatarEditPage.this;
                                                                                buttonView2.event(new Function1<com.tencent.kuikly.core.views.compose.b, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.9.1.2.3.2
                                                                                    {
                                                                                        super(1);
                                                                                    }

                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final Unit invoke(com.tencent.kuikly.core.views.compose.b bVar) {
                                                                                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage18 = NearbyProfileAvatarEditPage.this;
                                                                                        bVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.9.1.2.3.2.1
                                                                                            {
                                                                                                super(1);
                                                                                            }

                                                                                            @Override // kotlin.jvm.functions.Function1
                                                                                            public final Unit invoke(ClickParams clickParams) {
                                                                                                NearbyProfileAvatarEditPage.this.getViewModel().requestAvatarHeadConfig();
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
                                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage13 = NearbyProfileAvatarEditPage.this;
                                                ConditionViewKt.c(vVar2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.10
                                                    {
                                                        super(0);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function0
                                                    public final Object invoke() {
                                                        NearbyProfileAvatarEditViewModel viewModel = NearbyProfileAvatarEditPage.this.getViewModel();
                                                        return Boolean.valueOf(((Boolean) viewModel.isSettingAvatar$delegate.getValue(viewModel, NearbyProfileAvatarEditViewModel.$$delegatedProperties[8])).booleanValue());
                                                    }
                                                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.11
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(ConditionView conditionView) {
                                                        bb.b(conditionView, false, new Function1<ModalView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.11.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(ModalView modalView) {
                                                                ModalView modalView2 = modalView;
                                                                w.a(modalView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.11.1.1
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(v vVar3) {
                                                                        v vVar4 = vVar3;
                                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.11.1.1.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(t tVar) {
                                                                                t tVar2 = tVar;
                                                                                tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().l());
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.11.1.1.2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(u uVar) {
                                                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.11.1.1.2.1
                                                                                    @Override // kotlin.jvm.functions.Function1
                                                                                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                                                                                        return Unit.INSTANCE;
                                                                                    }
                                                                                });
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                ECLoadingViewKt.ECLoading(modalView2, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.11.1.2
                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ECLoadingView eCLoadingView) {
                                                                        eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.1.1.1.11.1.2.1
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(ECLoadingAttr eCLoadingAttr) {
                                                                                eCLoadingAttr.delayShow = false;
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                return Unit.INSTANCE;
                                                            }
                                                        }, 1, null);
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
                        final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage3 = NearbyProfileAvatarEditPage.this;
                        actionSheetView2.event(new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(d dVar) {
                                d dVar2 = dVar;
                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage4 = NearbyProfileAvatarEditPage.this;
                                dVar2.j(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage5 = NearbyProfileAvatarEditPage.this;
                                        nearbyProfileAvatarEditPage5.showActionSheet$delegate.setValue(nearbyProfileAvatarEditPage5, NearbyProfileAvatarEditPage.$$delegatedProperties[0], Boolean.FALSE);
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage5 = NearbyProfileAvatarEditPage.this;
                                dVar2.h(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage.body.1.1.2.2
                                    {
                                        super(0);
                                    }

                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        NearbyProfileAvatarEditPage.this.getViewModel().closePage();
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

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final Map<String, Module> createExternalModules() {
        Map<String, Module> mutableMap;
        mutableMap = MapsKt__MapsKt.toMutableMap(super.createExternalModules());
        if (mutableMap != null) {
            mutableMap.put("NearbyProfileKuiklyModule", new NearbyProfileBridgeModule());
        }
        if (mutableMap != null) {
            mutableMap.put("QQNearbyModule", new QQNearbyModule());
        }
        return mutableMap;
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.appId = getPageData().n().j("appid");
        this.viewModel = new NearbyProfileAvatarEditViewModel(getPagerId(), this.appId, new IPageCallback() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.NearbyProfileAvatarEditPage$created$1
            @Override // com.tencent.hippykotlin.demo.pages.nearby.profile.edit.avatar.IPageCallback
            public final void scrollToSpecifiedBgListIndex(int i3) {
                NearbyProfileAvatarEditPage nearbyProfileAvatarEditPage = NearbyProfileAvatarEditPage.this;
                aa<aq<?, ?>> aaVar = nearbyProfileAvatarEditPage.bgListRef;
                if (aaVar != null) {
                    float m3 = ((i3 + 1) * 49.0f) - (nearbyProfileAvatarEditPage.getPagerData().m() - 23.0f);
                    if (m3 < 0.0f) {
                        m3 = 0.0f;
                    }
                    aq<?, ?> b16 = aaVar.b();
                    if (b16 != null) {
                        ScrollerView.setContentOffset$default(b16, m3, 0.0f, false, null, 8, null);
                    }
                }
            }
        });
    }

    public final NearbyProfileAvatarEditViewModel getViewModel() {
        NearbyProfileAvatarEditViewModel nearbyProfileAvatarEditViewModel = this.viewModel;
        if (nearbyProfileAvatarEditViewModel != null) {
            return nearbyProfileAvatarEditViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.closePage$default();
        }
    }
}
