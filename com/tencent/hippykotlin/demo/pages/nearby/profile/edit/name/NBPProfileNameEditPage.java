package com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name;

import c01.c;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.HotViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoService$sendProxyRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.view_model.NBPNewEditViewModel;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.views.ActionSheetAttr;
import com.tencent.kuikly.core.views.ActionSheetView;
import com.tencent.kuikly.core.views.InputEvent;
import com.tencent.kuikly.core.views.InputParams;
import com.tencent.kuikly.core.views.InputView;
import com.tencent.kuikly.core.views.KeyboardParams;
import com.tencent.kuikly.core.views.ModalView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ai;
import com.tencent.kuikly.core.views.am;
import com.tencent.kuikly.core.views.bb;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.d;
import com.tencent.kuikly.core.views.e;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import s35.ac;
import s35.af;
import s35.f;
import s35.n;
import s35.o;
import u35.a;
import u35.b;

/* loaded from: classes31.dex */
public final class NBPProfileNameEditPage extends NearbyBasePager {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPProfileNameEditPage.class, "showActionSheet", "getShowActionSheet()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPProfileNameEditPage.class, "keyboardHeight", "getKeyboardHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPProfileNameEditPage.class, "durationLimit", "getDurationLimit()Lkuikly/com/tencent/trpcprotocol/qqstranger/common/qqstranger_user_info/DurationLimit;", 0)};
    public NBPNewEditViewModel viewModel;
    public final ReadWriteProperty showActionSheet$delegate = c.a(Boolean.TRUE);
    public final ReadWriteProperty keyboardHeight$delegate = c.a(Float.valueOf(0.0f));
    public final ReadWriteProperty durationLimit$delegate = c.a(null);
    public String currentNickname = "";
    public boolean shouldCommit = true;

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                final NBPProfileNameEditPage nBPProfileNameEditPage = NBPProfileNameEditPage.this;
                e.a(viewContainer, new Function1<ActionSheetView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage$body$1.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ActionSheetView actionSheetView) {
                        ActionSheetView actionSheetView2 = actionSheetView;
                        final NBPProfileNameEditPage nBPProfileNameEditPage2 = NBPProfileNameEditPage.this;
                        actionSheetView2.attr(new Function1<ActionSheetAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ActionSheetAttr actionSheetAttr) {
                                ActionSheetAttr actionSheetAttr2 = actionSheetAttr;
                                NBPProfileNameEditPage nBPProfileNameEditPage3 = NBPProfileNameEditPage.this;
                                actionSheetAttr2.w(((Boolean) nBPProfileNameEditPage3.showActionSheet$delegate.getValue(nBPProfileNameEditPage3, NBPProfileNameEditPage.$$delegatedProperties[0])).booleanValue());
                                final NBPProfileNameEditPage nBPProfileNameEditPage4 = NBPProfileNameEditPage.this;
                                actionSheetAttr2.j(new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ViewContainer<?, ?> viewContainer2) {
                                        final NBPProfileNameEditPage nBPProfileNameEditPage5 = NBPProfileNameEditPage.this;
                                        w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                final NBPProfileNameEditPage nBPProfileNameEditPage6 = NBPProfileNameEditPage.this;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1.1
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        float floatValue;
                                                        float floatValue2;
                                                        t tVar2 = tVar;
                                                        tVar2.mo153width(tVar2.getPagerData().m());
                                                        floatValue = ((Number) r0.keyboardHeight$delegate.getValue(NBPProfileNameEditPage.this, NBPProfileNameEditPage.$$delegatedProperties[1])).floatValue();
                                                        if (floatValue > 0.0f) {
                                                            floatValue2 = ((Number) r2.keyboardHeight$delegate.getValue(NBPProfileNameEditPage.this, NBPProfileNameEditPage.$$delegatedProperties[1])).floatValue();
                                                            tVar2.mo141height(floatValue2 + 102);
                                                        }
                                                        tVar2.mo113backgroundColor(QUIToken.color$default("bg_top_light"));
                                                        tVar2.alignItemsCenter();
                                                        tVar2.borderRadius(8.0f, 8.0f, 0.0f, 0.0f);
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                final NBPProfileNameEditPage nBPProfileNameEditPage7 = NBPProfileNameEditPage.this;
                                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1.2
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        v vVar4 = vVar3;
                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1.2.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.marginTop(20.0f);
                                                                tVar2.size(tVar2.getPagerData().m() - 32.0f, 56.0f);
                                                                tVar2.mo113backgroundColor(QUIToken.color$default("fill_standard_primary"));
                                                                tVar2.borderRadius(8.0f);
                                                                tVar2.allCenter();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPProfileNameEditPage nBPProfileNameEditPage8 = NBPProfileNameEditPage.this;
                                                        am.a(vVar4, new Function1<InputView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1.2.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(InputView inputView) {
                                                                InputView inputView2 = inputView;
                                                                final NBPProfileNameEditPage nBPProfileNameEditPage9 = NBPProfileNameEditPage.this;
                                                                inputView2.attr(new Function1<ai, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1.2.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ai aiVar) {
                                                                        String str;
                                                                        ai aiVar2 = aiVar;
                                                                        aiVar2.size(aiVar2.getPagerData().m() - 64.0f, 24.0f);
                                                                        if (NBPProfileNameEditPage.this.currentNickname.length() > 12) {
                                                                            str = NBPProfileNameEditPage.this.currentNickname.substring(0, 11);
                                                                            Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                                                                        } else {
                                                                            str = NBPProfileNameEditPage.this.currentNickname;
                                                                        }
                                                                        aiVar2.B(str);
                                                                        aiVar2.u("\u8f93\u5165\u6587\u672c");
                                                                        aiVar2.v(QUIToken.color$default("text_tertiary"));
                                                                        ai.m(aiVar2, 17.0f, null, 2, null);
                                                                        aiVar2.i(QUIToken.color$default("text_primary"));
                                                                        aiVar2.t(12);
                                                                        aiVar2.h(true);
                                                                        aiVar2.w();
                                                                        return Unit.INSTANCE;
                                                                    }
                                                                });
                                                                final NBPProfileNameEditPage nBPProfileNameEditPage10 = NBPProfileNameEditPage.this;
                                                                inputView2.event(new Function1<InputEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1.2.2.2
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(InputEvent inputEvent) {
                                                                        InputEvent inputEvent2 = inputEvent;
                                                                        final NBPProfileNameEditPage nBPProfileNameEditPage11 = NBPProfileNameEditPage.this;
                                                                        InputEvent.q(inputEvent2, false, new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1.2.2.2.1
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(InputParams inputParams) {
                                                                                NBPProfileNameEditPage.this.currentNickname = inputParams.getText();
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }, 1, null);
                                                                        inputEvent2.r(new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1.2.2.2.2
                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(Object obj) {
                                                                                Utils.INSTANCE.currentBridgeModule().qToast("\u8f93\u5165\u592a\u591a\u5b57\u5566", QToastMode.Warning);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NBPProfileNameEditPage nBPProfileNameEditPage12 = NBPProfileNameEditPage.this;
                                                                        InputEvent.l(inputEvent2, false, new Function1<KeyboardParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1.2.2.2.3
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(KeyboardParams keyboardParams) {
                                                                                float floatValue;
                                                                                KeyboardParams keyboardParams2 = keyboardParams;
                                                                                if (NBPProfileNameEditPage.this.getPageData().getIsAndroid()) {
                                                                                    floatValue = ((Number) r0.keyboardHeight$delegate.getValue(NBPProfileNameEditPage.this, NBPProfileNameEditPage.$$delegatedProperties[1])).floatValue();
                                                                                    if (floatValue > 0.0f) {
                                                                                        if (keyboardParams2.getHeight() == 0.0f) {
                                                                                            NBPProfileNameEditPage nBPProfileNameEditPage13 = NBPProfileNameEditPage.this;
                                                                                            nBPProfileNameEditPage13.showActionSheet$delegate.setValue(nBPProfileNameEditPage13, NBPProfileNameEditPage.$$delegatedProperties[0], Boolean.FALSE);
                                                                                        }
                                                                                    }
                                                                                }
                                                                                NBPProfileNameEditPage nBPProfileNameEditPage14 = NBPProfileNameEditPage.this;
                                                                                nBPProfileNameEditPage14.keyboardHeight$delegate.setValue(nBPProfileNameEditPage14, NBPProfileNameEditPage.$$delegatedProperties[1], Float.valueOf(keyboardParams2.getHeight()));
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        }, 1, null);
                                                                        final NBPProfileNameEditPage nBPProfileNameEditPage13 = NBPProfileNameEditPage.this;
                                                                        inputEvent2.o(new Function1<InputParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1.2.2.2.4
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(InputParams inputParams) {
                                                                                NBPProfileNameEditPage.access$handleEditDone(NBPProfileNameEditPage.this);
                                                                                return Unit.INSTANCE;
                                                                            }
                                                                        });
                                                                        final NBPProfileNameEditPage nBPProfileNameEditPage14 = NBPProfileNameEditPage.this;
                                                                        inputEvent2.m(new Function1<String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1.2.2.2.5
                                                                            {
                                                                                super(1);
                                                                            }

                                                                            @Override // kotlin.jvm.functions.Function1
                                                                            public final Unit invoke(String str) {
                                                                                NBPProfileNameEditPage.access$handleEditDone(NBPProfileNameEditPage.this);
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
                                                final NBPProfileNameEditPage nBPProfileNameEditPage8 = NBPProfileNameEditPage.this;
                                                w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1.3
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(v vVar3) {
                                                        v vVar4 = vVar3;
                                                        vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1.3.1
                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(t tVar) {
                                                                t tVar2 = tVar;
                                                                tVar2.size(tVar2.getPagerData().m(), 20.0f);
                                                                tVar2.marginTop(4.0f);
                                                                tVar2.flexDirectionRow();
                                                                tVar2.justifyContentSpaceBetween();
                                                                return Unit.INSTANCE;
                                                            }
                                                        });
                                                        final NBPProfileNameEditPage nBPProfileNameEditPage9 = NBPProfileNameEditPage.this;
                                                        cg.a(vVar4, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1.3.2
                                                            {
                                                                super(1);
                                                            }

                                                            @Override // kotlin.jvm.functions.Function1
                                                            public final Unit invoke(TextView textView) {
                                                                final NBPProfileNameEditPage nBPProfileNameEditPage10 = NBPProfileNameEditPage.this;
                                                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.1.1.1.3.2.1
                                                                    {
                                                                        super(1);
                                                                    }

                                                                    @Override // kotlin.jvm.functions.Function1
                                                                    public final Unit invoke(ce ceVar) {
                                                                        ce ceVar2 = ceVar;
                                                                        ceVar2.marginLeft(32.0f);
                                                                        ceVar2.fontWeight400();
                                                                        ceVar2.color(QUIToken.color$default("text_secondary"));
                                                                        ceVar2.fontFamily("PingFang SC");
                                                                        NBPProfileNameEditPage nBPProfileNameEditPage11 = NBPProfileNameEditPage.this;
                                                                        KProperty<Object>[] kPropertyArr = NBPProfileNameEditPage.$$delegatedProperties;
                                                                        String str = "";
                                                                        if (nBPProfileNameEditPage11.getDurationLimit() != null) {
                                                                            f durationLimit = nBPProfileNameEditPage11.getDurationLimit();
                                                                            Integer valueOf = durationLimit != null ? Integer.valueOf(durationLimit.f433234d) : null;
                                                                            if (valueOf != null && valueOf.intValue() == 1) {
                                                                                str = "\u4eca\u5929";
                                                                            } else if (valueOf != null && valueOf.intValue() == 2) {
                                                                                str = "\u672c\u5468";
                                                                            } else if (valueOf != null && valueOf.intValue() == 3) {
                                                                                str = "\u672c\u6708";
                                                                            } else if (valueOf != null && valueOf.intValue() == 4) {
                                                                                str = "\u4eca\u5e74";
                                                                            }
                                                                            StringBuilder m3 = HotViewKt$$ExternalSyntheticOutline0.m(str, "\u5269\u4f59");
                                                                            f durationLimit2 = nBPProfileNameEditPage11.getDurationLimit();
                                                                            m3.append(durationLimit2 != null ? Integer.valueOf(durationLimit2.f433235e) : null);
                                                                            m3.append("\u6b21\u4fee\u6539\u673a\u4f1a");
                                                                            str = m3.toString();
                                                                        }
                                                                        ceVar2.text(str);
                                                                        ce.fontSize$default(ceVar2, 14.0f, null, 2, null);
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
                        final NBPProfileNameEditPage nBPProfileNameEditPage3 = NBPProfileNameEditPage.this;
                        actionSheetView2.event(new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.2
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(d dVar) {
                                d dVar2 = dVar;
                                final NBPProfileNameEditPage nBPProfileNameEditPage4 = NBPProfileNameEditPage.this;
                                dVar2.j(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.2.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        NBPProfileNameEditPage nBPProfileNameEditPage5 = NBPProfileNameEditPage.this;
                                        nBPProfileNameEditPage5.showActionSheet$delegate.setValue(nBPProfileNameEditPage5, NBPProfileNameEditPage.$$delegatedProperties[0], Boolean.FALSE);
                                        return Unit.INSTANCE;
                                    }
                                });
                                dVar2.h(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.2.2
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Unit invoke() {
                                        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                        QQKuiklyPlatformApi.Companion.closePage$default();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPProfileNameEditPage nBPProfileNameEditPage4 = NBPProfileNameEditPage.this;
                        ConditionViewKt.c(actionSheetView2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.3
                            {
                                super(0);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:4:0x0009, code lost:
                            
                                if (r0.isRequesting == true) goto L8;
                             */
                            @Override // kotlin.jvm.functions.Function0
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Object invoke() {
                                NBPNewEditViewModel nBPNewEditViewModel = NBPProfileNameEditPage.this.viewModel;
                                boolean z16 = nBPNewEditViewModel != null;
                                return Boolean.valueOf(z16);
                            }
                        }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.4
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ConditionView conditionView) {
                                bb.b(conditionView, false, new Function1<ModalView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.4.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ModalView modalView) {
                                        ModalView modalView2 = modalView;
                                        w.a(modalView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.4.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(v vVar) {
                                                v vVar2 = vVar;
                                                vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.4.1.1.1
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(t tVar) {
                                                        t tVar2 = tVar;
                                                        tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().l());
                                                        return Unit.INSTANCE;
                                                    }
                                                });
                                                vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.4.1.1.2
                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(u uVar) {
                                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.4.1.1.2.1
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
                                        ECLoadingViewKt.ECLoading(modalView2, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.4.1.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ECLoadingView eCLoadingView) {
                                                eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage.body.1.1.4.1.2.1
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
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        int j3 = getPageData().n().j("appid");
        this.shouldCommit = getPageData().n().g("commit", this.shouldCommit);
        this.currentNickname = ((com.tencent.kuikly.core.module.d) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRCodecModule")).a(getPageData().n().p("nickname"));
        this.viewModel = new NBPNewEditViewModel(j3, 2);
        final Function1<o, Unit> function1 = new Function1<o, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage$created$1
            {
                super(1);
            }

            /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
            
                if ((!r0.isEmpty()) == true) goto L12;
             */
            @Override // kotlin.jvm.functions.Function1
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Unit invoke(o oVar) {
                Object first;
                ac acVar;
                o oVar2 = oVar;
                boolean z16 = (oVar2 == null || (acVar = oVar2.f433255f) == null || (r0 = acVar.f433195d) == null) ? false : true;
                if (z16) {
                    NBPProfileNameEditPage nBPProfileNameEditPage = NBPProfileNameEditPage.this;
                    ac acVar2 = oVar2.f433255f;
                    Intrinsics.checkNotNull(acVar2);
                    first = CollectionsKt___CollectionsKt.first((List<? extends Object>) acVar2.f433195d);
                    nBPProfileNameEditPage.durationLimit$delegate.setValue(nBPProfileNameEditPage, NBPProfileNameEditPage.$$delegatedProperties[2], (f) first);
                }
                return Unit.INSTANCE;
            }
        };
        final NBPProfileNameEditPage$created$2 nBPProfileNameEditPage$created$2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage$created$2
            @Override // kotlin.jvm.functions.Function2
            public final /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                num.intValue();
                return Unit.INSTANCE;
            }
        };
        n nVar = new n();
        Function1<PbResponse<b>, Unit> function12 = new Function1<PbResponse<b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_profile_edit.repository.NBPNewEditRepository$fetchUpdateLimit$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<b> pbResponse) {
                PbResponse<b> pbResponse2 = pbResponse;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchUpdateLimit proxy retcode:");
                m3.append(pbResponse2.code);
                m3.append(", rsp return code:");
                b bVar = pbResponse2.rsp;
                NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, bVar != null ? Integer.valueOf(bVar.f438201d) : null, kLog, "NBPNewEditRepository");
                if (pbResponse2.success && pbResponse2.rsp != null) {
                    try {
                        Function1<o, Unit> function13 = function1;
                        o oVar = new o(0, null, null, 7, null);
                        b bVar2 = pbResponse2.rsp;
                        Intrinsics.checkNotNull(bVar2, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.ProxyRsp");
                        function13.invoke(i.b(oVar, bVar2.f438203f.f30291a));
                    } catch (Throwable th5) {
                        AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("fetchUpdateLimit decode error: ", th5, KLog.INSTANCE, "NBPNewEditRepository");
                        nBPProfileNameEditPage$created$2.invoke(Integer.valueOf(pbResponse2.code), th5.toString());
                    }
                } else {
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchUpdateLimit error:");
                    m16.append(pbResponse2.code);
                    kLog.e("NBPNewEditRepository", m16.toString());
                    nBPProfileNameEditPage$created$2.invoke(Integer.valueOf(pbResponse2.code), "");
                }
                return Unit.INSTANCE;
            }
        };
        QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new a("QQStranger.UserInfo", "SsoGetUpdateLimit", j3, new c45.a(i.d(nVar))));
        QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(function12);
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
    }

    public final f getDurationLimit() {
        return (f) this.durationLimit$delegate.getValue(this, $$delegatedProperties[2]);
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, com.tencent.kuikly.core.nvi.serialization.json.e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.closePage$default();
        }
    }

    public static final void access$handleEditDone(final NBPProfileNameEditPage nBPProfileNameEditPage) {
        nBPProfileNameEditPage.getClass();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage$handleEditDone$callback$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                if (bool.booleanValue()) {
                    QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                    QQKuiklyPlatformApi.Companion.closePage$default();
                    k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
                    com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
                    eVar.v("nick", NBPProfileNameEditPage.this.currentNickname);
                    Unit unit = Unit.INSTANCE;
                    k.d(kVar, "NEARBY_PROFILE_EDIT_NICK_FINISH", eVar, false, 4, null);
                }
                return Unit.INSTANCE;
            }
        };
        if (nBPProfileNameEditPage.shouldCommit) {
            NBPNewEditViewModel nBPNewEditViewModel = nBPProfileNameEditPage.viewModel;
            if (nBPNewEditViewModel != null) {
                nBPNewEditViewModel.save(new af(null, 0L, nBPProfileNameEditPage.currentNickname, 0, null, 0, null, null, null, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -5, 255), new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.profile.edit.name.NBPProfileNameEditPage$handleEditDone$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Boolean bool) {
                        function1.invoke(Boolean.valueOf(bool.booleanValue()));
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            return;
        }
        function1.invoke(Boolean.TRUE);
    }
}
