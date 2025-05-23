package com.tencent.hippykotlin.demo.pages.nearby.aio;

import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingAttr;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingView;
import com.tencent.hippykotlin.demo.pages.base.ECLoadingViewKt;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.hippykotlin.demo.pages.foundation.qui_token.QUIToken;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePager;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository$requestOpenID$1;
import com.tencent.kuikly.core.base.ViewContainer;
import com.tencent.kuikly.core.base.attr.b;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.VisibilityEventKt;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.m;
import com.tencent.kuikly.core.directives.ConditionView;
import com.tencent.kuikly.core.directives.ConditionViewKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.views.ImageView;
import com.tencent.kuikly.core.views.ModalView;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextEvent;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.RichTextViewKt;
import com.tencent.kuikly.core.views.SwitchView;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.af;
import com.tencent.kuikly.core.views.ah;
import com.tencent.kuikly.core.views.bb;
import com.tencent.kuikly.core.views.bt;
import com.tencent.kuikly.core.views.bu;
import com.tencent.kuikly.core.views.bv;
import com.tencent.kuikly.core.views.ce;
import com.tencent.kuikly.core.views.cf;
import com.tencent.kuikly.core.views.cg;
import com.tencent.kuikly.core.views.t;
import com.tencent.kuikly.core.views.u;
import com.tencent.kuikly.core.views.v;
import com.tencent.kuikly.core.views.w;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import f35.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class NBPAIOSettingPage extends NearbyBasePager {
    public NBPAIOSettingViewModel viewModel;
    public String tid = "";
    public String nickName = "";
    public String chatType = "";

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final Function1<ViewContainer<?, ?>, Unit> body() {
        return new Function1<ViewContainer<?, ?>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage$body$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(ViewContainer<?, ?> viewContainer) {
                ViewContainer<?, ?> viewContainer2 = viewContainer;
                viewContainer2.attr(new Function1<m, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage$body$1.1
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(m mVar) {
                        m mVar2 = mVar;
                        mVar2.alignItemsCenter();
                        mVar2.flexDirectionColumn();
                        mVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_standard"));
                        return Unit.INSTANCE;
                    }
                });
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage$body$1.2
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.2.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.alignItemsCenter();
                                tVar2.justifyContentCenter();
                                tVar2.mo113backgroundColor(QUIToken.color$default("bg_bottom_light"));
                                tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().getNavigationBarHeight());
                                return Unit.INSTANCE;
                            }
                        });
                        w.a(vVar2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.2.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(v vVar3) {
                                v vVar4 = vVar3;
                                vVar4.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.2.2.1
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
                                vVar4.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.2.2.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(u uVar) {
                                        uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.2.2.2.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(ClickParams clickParams) {
                                                QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                                QQKuiklyPlatformApi.Companion.closePage$default();
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                ah.a(vVar4, new Function1<ImageView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.2.2.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ImageView imageView) {
                                        imageView.attr(new Function1<af, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.2.2.3.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(af afVar) {
                                                af afVar2 = afVar;
                                                afVar2.size(24.0f, 24.0f);
                                                b.a.b(afVar2, QUIToken.INSTANCE.image("chevron_left", QUIToken.color$default("text_primary")), false, 2, null);
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.2.3
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.2.3.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.marginTop(ceVar2.getPagerData().getStatusBarHeight());
                                        ceVar2.text("\u804a\u5929\u8bbe\u7f6e");
                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                        ceVar2.fontWeight500();
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
                final NBPAIOSettingPage nBPAIOSettingPage = NBPAIOSettingPage.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage$body$1.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.3.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.flexDirectionRow();
                                tVar2.size(tVar2.getPagerData().m() - 32.0f, 42.0f);
                                tVar2.alignItemsCenter();
                                tVar2.justifyContentSpaceBetween();
                                tVar2.mo113backgroundColor(QUIToken.color$default("fill_light_secondary"));
                                tVar2.marginTop(22.0f);
                                tVar2.borderRadius(4.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.3.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.3.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u5c4f\u853d\u6b64\u4eba");
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        ceVar2.fontFamily("PingFang SC");
                                        ceVar2.color(QUIToken.color$default("text_primary"));
                                        ceVar2.fontWeight400();
                                        ceVar2.marginLeft(16.0f);
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPAIOSettingPage nBPAIOSettingPage2 = NBPAIOSettingPage.this;
                        bv.a(vVar2, new Function1<SwitchView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.3.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(SwitchView switchView) {
                                SwitchView switchView2 = switchView;
                                final NBPAIOSettingPage nBPAIOSettingPage3 = NBPAIOSettingPage.this;
                                switchView2.attr(new Function1<bt, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.3.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(bt btVar) {
                                        bt btVar2 = btVar;
                                        btVar2.marginRight(16.0f);
                                        btVar2.size(47.0f, 26.0f);
                                        btVar2.n(new h(4278229503L));
                                        btVar2.r(new h(4289111718L));
                                        NBPAIOSettingViewModel viewModel = NBPAIOSettingPage.this.getViewModel();
                                        btVar2.l(((Boolean) viewModel.isBlock$delegate.getValue(viewModel, NBPAIOSettingViewModel.$$delegatedProperties[0])).booleanValue());
                                        return Unit.INSTANCE;
                                    }
                                });
                                final NBPAIOSettingPage nBPAIOSettingPage4 = NBPAIOSettingPage.this;
                                switchView2.event(new Function1<bu, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.3.3.2
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(bu buVar) {
                                        final NBPAIOSettingPage nBPAIOSettingPage5 = NBPAIOSettingPage.this;
                                        buVar.i(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.3.3.2.1
                                            {
                                                super(1);
                                            }

                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(Boolean bool) {
                                                boolean booleanValue = bool.booleanValue();
                                                NBPAIOSettingPage.this.getViewModel().setBlock(booleanValue);
                                                if (booleanValue) {
                                                    QQUIModule qQUIModule = (QQUIModule) c.f117352a.g().acquireModule("QQUIModule");
                                                    final NBPAIOSettingPage nBPAIOSettingPage6 = NBPAIOSettingPage.this;
                                                    qQUIModule.openAlertDialog("", "\u5c4f\u853d\u540e\uff0c\u4f60\u5c06\u4e0d\u518d\u6536\u5230\u5bf9\u65b9\u7684\u6d88\u606f", "\u53d6\u6d88", "\u786e\u5b9a", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.3.3.2.1.1
                                                        {
                                                            super(2);
                                                        }

                                                        @Override // kotlin.jvm.functions.Function2
                                                        public final Unit invoke(Boolean bool2, Boolean bool3) {
                                                            boolean booleanValue2 = bool2.booleanValue();
                                                            bool3.booleanValue();
                                                            if (booleanValue2) {
                                                                NBPAIOSettingPage.this.getViewModel().blockSomeone(true);
                                                            } else {
                                                                NBPAIOSettingPage.this.getViewModel().setBlock(false);
                                                            }
                                                            return Unit.INSTANCE;
                                                        }
                                                    });
                                                } else {
                                                    NBPAIOSettingPage.this.getViewModel().blockSomeone(false);
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
                final NBPAIOSettingPage nBPAIOSettingPage2 = NBPAIOSettingPage.this;
                w.a(viewContainer2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage$body$1.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(v vVar) {
                        v vVar2 = vVar;
                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.4.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(t tVar) {
                                t tVar2 = tVar;
                                tVar2.size(tVar2.getPagerData().m() - 32.0f, 45.0f);
                                tVar2.allCenter();
                                tVar2.mo113backgroundColor(new h(4278229503L));
                                tVar2.marginTop(20.0f);
                                tVar2.borderRadius(4.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        cg.a(vVar2, new Function1<TextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.4.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(TextView textView) {
                                textView.attr(new Function1<ce, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.4.2.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ce ceVar) {
                                        ce ceVar2 = ceVar;
                                        ceVar2.text("\u52a0\u4e3a\u597d\u53cb");
                                        ce.fontSize$default(ceVar2, 17.0f, null, 2, null);
                                        ceVar2.fontFamily("PingFang SC");
                                        ceVar2.color(h.INSTANCE.m());
                                        ceVar2.fontWeight500();
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPAIOSettingPage nBPAIOSettingPage3 = NBPAIOSettingPage.this;
                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.4.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(u uVar) {
                                final NBPAIOSettingPage nBPAIOSettingPage4 = NBPAIOSettingPage.this;
                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.4.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        final NBPAIOSettingViewModel viewModel = NBPAIOSettingPage.this.getViewModel();
                                        if (!viewModel.isRequesting()) {
                                            viewModel.setRequesting(true);
                                            String str = viewModel.tid;
                                            Function1<d, Unit> function1 = new Function1<d, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingViewModel$enterAddFriendPage$1
                                                {
                                                    super(1);
                                                }

                                                @Override // kotlin.jvm.functions.Function1
                                                public final Unit invoke(d dVar) {
                                                    d dVar2 = dVar;
                                                    NBPAIOSettingViewModel.this.setRequesting(false);
                                                    if (dVar2 == null) {
                                                        KLog.INSTANCE.e("NBPAIOSettingViewModel", "requestOpenID failed, rspModel is null");
                                                    } else if (dVar2.f397794f) {
                                                        Utils.INSTANCE.currentBridgeModule().qToast("\u5bf9\u65b9\u5df2\u7ecf\u662f\u597d\u53cb", QToastMode.Info);
                                                    } else {
                                                        NBPAIOSettingViewModel nBPAIOSettingViewModel = NBPAIOSettingViewModel.this;
                                                        nBPAIOSettingViewModel.getClass();
                                                        ((QQNearbyModule) c.f117352a.k(nBPAIOSettingViewModel.pagerId).acquireModule("QQNearbyModule")).enterAddFriendPage(dVar2.f397793e, UserDataManager.INSTANCE.getUserSelfInfo().nickName);
                                                    }
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            Function2<Integer, String, Unit> function2 = new Function2<Integer, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingViewModel$enterAddFriendPage$2
                                                {
                                                    super(2);
                                                }

                                                @Override // kotlin.jvm.functions.Function2
                                                public final Unit invoke(Integer num, String str2) {
                                                    NBPAIOSettingViewModel.this.setRequesting(false);
                                                    KLog.INSTANCE.e("NBPAIOSettingViewModel", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("requestOpenID failed, errorCode: ", num.intValue(), ", errorMsg: ", str2));
                                                    Utils.INSTANCE.currentBridgeModule().qToast("\u6dfb\u52a0\u597d\u53cb\u5931\u8d25", QToastMode.Warning);
                                                    return Unit.INSTANCE;
                                                }
                                            };
                                            NBPNewHomeRepository.GetOpenIDRequest getOpenIDRequest = new NBPNewHomeRepository.GetOpenIDRequest(Long.parseLong(str));
                                            NBPNewHomeRepository$requestOpenID$1 nBPNewHomeRepository$requestOpenID$1 = new NBPNewHomeRepository$requestOpenID$1(function1, function2);
                                            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.user_manager_svr.User.SsoGetOpenId");
                                            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
                                            QQKuiklyPlatformApi.Companion.sendPbRequest$default(getOpenIDRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, nBPNewHomeRepository$requestOpenID$1), 6);
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
                final NBPAIOSettingPage nBPAIOSettingPage3 = NBPAIOSettingPage.this;
                RichTextViewKt.b(viewContainer2, new Function1<RichTextView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage$body$1.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(RichTextView richTextView) {
                        RichTextView richTextView2 = richTextView;
                        richTextView2.attr(new Function1<RichTextAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.5.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextAttr richTextAttr) {
                                richTextAttr.marginTop(20.0f);
                                return Unit.INSTANCE;
                            }
                        });
                        RichTextViewKt.c(richTextView2, new Function1<cf, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.5.2
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(cf cfVar) {
                                cf cfVar2 = cfVar;
                                cfVar2.text("\u88ab\u9a9a\u6270\u4e86\uff1f\u4e3e\u62a5\u8be5\u7528\u6237");
                                ce.fontSize$default(cfVar2, 14.0f, null, 2, null);
                                cfVar2.color(new h(4278229503L));
                                return Unit.INSTANCE;
                            }
                        });
                        final NBPAIOSettingPage nBPAIOSettingPage4 = NBPAIOSettingPage.this;
                        richTextView2.event(new Function1<RichTextEvent, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.5.3
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(RichTextEvent richTextEvent) {
                                RichTextEvent richTextEvent2 = richTextEvent;
                                final NBPAIOSettingPage nBPAIOSettingPage5 = NBPAIOSettingPage.this;
                                richTextEvent2.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.5.3.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ClickParams clickParams) {
                                        QQNearbyModule.Companion.getInstance().jumpReportPage(10022, NBPAIOSettingPage.this.tid, "", "119");
                                        e eVar = new e();
                                        eVar.v("dt_eid", "em_nearby_report");
                                        eVar.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", eVar);
                                        return Unit.INSTANCE;
                                    }
                                });
                                VisibilityEventKt.e(richTextEvent2, new Function1<Object, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.5.3.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Object obj) {
                                        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("dt_eid", "em_nearby_report", DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU"));
                                        return Unit.INSTANCE;
                                    }
                                });
                                return Unit.INSTANCE;
                            }
                        });
                        return Unit.INSTANCE;
                    }
                });
                final NBPAIOSettingPage nBPAIOSettingPage4 = NBPAIOSettingPage.this;
                ConditionViewKt.c(viewContainer2, new Function0<Object>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage$body$1.6
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Boolean.valueOf(NBPAIOSettingPage.this.getViewModel().isRequesting());
                    }
                }, new Function1<ConditionView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage$body$1.7
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(ConditionView conditionView) {
                        bb.b(conditionView, false, new Function1<ModalView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.7.1
                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(ModalView modalView) {
                                ModalView modalView2 = modalView;
                                w.a(modalView2, new Function1<v, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.7.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(v vVar) {
                                        v vVar2 = vVar;
                                        vVar2.attr(new Function1<t, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.7.1.1.1
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(t tVar) {
                                                t tVar2 = tVar;
                                                tVar2.size(tVar2.getPagerData().m(), tVar2.getPagerData().l());
                                                return Unit.INSTANCE;
                                            }
                                        });
                                        vVar2.event(new Function1<u, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.7.1.1.2
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Unit invoke(u uVar) {
                                                uVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.7.1.1.2.1
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
                                ECLoadingViewKt.ECLoading(modalView2, new Function1<ECLoadingView, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.7.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(ECLoadingView eCLoadingView) {
                                        eCLoadingView.attr(new Function1<ECLoadingAttr, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.aio.NBPAIOSettingPage.body.1.7.1.2.1
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
        };
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.base.ComposeView
    public final void created() {
        super.created();
        this.tid = getPageData().n().q("tid", "");
        this.nickName = getPageData().n().q("nickname", "");
        this.chatType = getPageData().n().q("chat_type", "");
        this.viewModel = new NBPAIOSettingViewModel(getPagerId(), this.tid);
    }

    public final NBPAIOSettingViewModel getViewModel() {
        NBPAIOSettingViewModel nBPAIOSettingViewModel = this.viewModel;
        if (nBPAIOSettingViewModel != null) {
            return nBPAIOSettingViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    @Override // com.tencent.kuikly.core.pager.Pager, com.tencent.kuikly.core.pager.b
    public final void onReceivePagerEvent(String str, e eVar) {
        super.onReceivePagerEvent(str, eVar);
        if (Intrinsics.areEqual(str, "onModalModeBackPressed")) {
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.closePage$default();
        }
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.BasePager, com.tencent.kuikly.core.pager.Pager
    public final void pageWillDestroy() {
        super.pageWillDestroy();
        customDtReportPageExposure(false);
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLoad() {
        super.viewDidLoad();
        customDtReportPageExposure(true);
    }

    public final void customDtReportPageExposure(boolean z16) {
        String str;
        if (z16) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_chat_setting", DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU"));
    }
}
