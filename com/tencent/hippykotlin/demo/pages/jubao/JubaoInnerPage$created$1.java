package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$created$1", f = "JubaoInnerPage.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class JubaoInnerPage$created$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ JubaoInnerPage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JubaoInnerPage$created$1(JubaoInnerPage jubaoInnerPage, Continuation<? super JubaoInnerPage$created$1> continuation) {
        super(2, continuation);
        this.this$0 = jubaoInnerPage;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new JubaoInnerPage$created$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((JubaoInnerPage$created$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ResultKt.throwOnFailure(obj);
        QQKuiklyPlatformApi qQKuiklyPlatformApi = (QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi");
        final JubaoInnerPage jubaoInnerPage = this.this$0;
        qQKuiklyPlatformApi.getPSkey("accounts.qq.com", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$created$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                String str;
                e eVar2 = eVar;
                PageModel pageModel = JubaoInnerPage.this.pageModel;
                if (eVar2 == null || (str = eVar2.p("p_skey")) == null) {
                    str = "";
                }
                pageModel.psKey = str;
                c cVar = c.f117352a;
                BridgeModule bridgeModule = (BridgeModule) cVar.g().acquireModule("HRBridgeModule");
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("get pskey result is ");
                m3.append(JubaoInnerPage.this.pageModel.psKey.length() > 0);
                bridgeModule.log(m3.toString());
                final JubaoInnerPageController jubaoInnerPageController = JubaoInnerPage.this.pageController;
                if (jubaoInnerPageController.pageModel.getPostData().grayId.length() == 0) {
                    jubaoInnerPageController.pageModel.pullTemplateData(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$pullData$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Boolean bool) {
                            if (!bool.booleanValue()) {
                                JubaoInnerPageController.this.jumpToNextPage(3, 0);
                            } else {
                                final JubaoInnerPageController jubaoInnerPageController2 = JubaoInnerPageController.this;
                                final PageModel pageModel2 = jubaoInnerPageController2.pageModel;
                                final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$pullData$1.1
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(Boolean bool2) {
                                        if (!bool2.booleanValue()) {
                                            JubaoInnerPageController.this.jumpToNextPage(3, 0);
                                        } else {
                                            JubaoInnerPageController.this.toJubaoStartPage();
                                        }
                                        return Unit.INSTANCE;
                                    }
                                };
                                pageModel2.getClass();
                                e eVar3 = new e();
                                eVar3.v("appid", pageModel2.getPostData().appId);
                                e eVar4 = new e();
                                eVar4.v("key", pageModel2.psKey);
                                eVar4.v(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN, PageDataExtKt.getUin(pageModel2.page.getPageData()));
                                Unit unit = Unit.INSTANCE;
                                eVar3.v("content", eVar4);
                                eVar3.v("ext", pageModel2.getPostData().postData.toString());
                                eVar3.v("qrt_token", pageModel2.getPostData().token);
                                pageModel2.getO3Module().sendRequest("SSOValidate", eVar3, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$ssoValidate$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    /* JADX WARN: Multi-variable type inference failed */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public final Unit invoke(e eVar5) {
                                        e m16;
                                        e eVar6 = eVar5;
                                        e m17 = (eVar6 == null || (m16 = eVar6.m("data")) == null) ? null : m16.m("result");
                                        String str2 = "\u8fd4\u56de";
                                        if (m17 == null) {
                                            PageModel.this.loadingErrorData = new ErrorData("\u7f51\u7edc\u5f02\u5e38", "\u62c9\u53d6\u6570\u636e\u5931\u8d25", 2, "\u8fd4\u56de");
                                            function1.invoke(Boolean.FALSE);
                                        } else {
                                            int j3 = m17.j("code");
                                            String p16 = m17.p("title");
                                            String p17 = m17.p("desc");
                                            boolean f16 = m17.f("link_to_impeach");
                                            if (j3 == 0) {
                                                function1.invoke(Boolean.TRUE);
                                            } else if (j3 != 3) {
                                                PageModel pageModel3 = PageModel.this;
                                                int i3 = f16 ? 1 : 2;
                                                if (f16) {
                                                    str2 = "\u7ee7\u7eed\u4e3e\u62a5";
                                                }
                                                pageModel3.loadingErrorData = new ErrorData(p16, p17, i3, str2);
                                                function1.invoke(Boolean.FALSE);
                                            } else {
                                                O3Module o3Module = PageModel.this.getO3Module();
                                                final Function1<Boolean, Unit> function12 = function1;
                                                final PageModel pageModel4 = PageModel.this;
                                                Function1<e, Unit> function13 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$ssoValidate$1.1
                                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                                    /* JADX WARN: Multi-variable type inference failed */
                                                    {
                                                        super(1);
                                                    }

                                                    @Override // kotlin.jvm.functions.Function1
                                                    public final Unit invoke(e eVar7) {
                                                        e eVar8 = eVar7;
                                                        ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).log("puzzleResult is " + eVar8);
                                                        if (eVar8 != null && eVar8.j("code") == 0) {
                                                            e m18 = eVar8.m("data");
                                                            if ((m18 != null ? m18.k("ret", -1) : -1) == 0) {
                                                                function12.invoke(Boolean.TRUE);
                                                                return Unit.INSTANCE;
                                                            }
                                                        }
                                                        pageModel4.getO3Module().dismiss();
                                                        return Unit.INSTANCE;
                                                    }
                                                };
                                                o3Module.getClass();
                                                e eVar7 = new e();
                                                eVar7.v("url", "https://accounts.qq.com/report/center/captcha?_wv=2&sid=" + Random.INSTANCE.nextLong());
                                                Unit unit2 = Unit.INSTANCE;
                                                o3Module.toNative(false, "puzzleVerify", eVar7.toString(), function13, false);
                                            }
                                        }
                                        return Unit.INSTANCE;
                                    }
                                });
                            }
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    final PageModel pageModel2 = jubaoInnerPageController.pageModel;
                    final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$pullData$2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Boolean bool) {
                            String str2;
                            boolean z16 = false;
                            if (!bool.booleanValue()) {
                                JubaoInnerPageController.this.jumpToNextPage(3, 0);
                            } else {
                                GrayTipData grayTipData = JubaoInnerPageController.this.pageModel.getGrayTipData();
                                if (grayTipData != null && (str2 = grayTipData.imgUrl) != null) {
                                    if (str2.length() > 0) {
                                        z16 = true;
                                    }
                                }
                                if (z16) {
                                    JubaoInnerPageController.this.pageModel.getO3Module().floatingViewSlideToMaxHeight();
                                }
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    pageModel2.getClass();
                    BridgeModule bridgeModule2 = (BridgeModule) cVar.g().acquireModule("HRBridgeModule");
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("pullGrayTipData grayId:");
                    m16.append(pageModel2.getPostData().grayId);
                    bridgeModule2.log(m16.toString());
                    if (pageModel2.page.getPageData().getIsIOS()) {
                        pageModel2.pullGrayTipDataInner(function1);
                    } else {
                        O3Module o3Module = pageModel2.getO3Module();
                        String str2 = pageModel2.getPostData().uid;
                        String str3 = pageModel2.getPostData().chatType;
                        Function1<e, Unit> function12 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$pullGrayTipData$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(e eVar3) {
                                String str4;
                                String p16;
                                e eVar4 = eVar3;
                                String str5 = "";
                                if (eVar4 == null || (str4 = eVar4.p("uin")) == null) {
                                    str4 = "";
                                }
                                if (eVar4 != null && (p16 = eVar4.p("encryptUin")) != null) {
                                    str5 = p16;
                                }
                                Boolean valueOf = eVar4 != null ? Boolean.valueOf(eVar4.g(IProfileProtocolConst.PARAM_IS_FRIEND, false)) : null;
                                if (str4.length() == 0) {
                                    ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).log("uid2uin error " + eVar4);
                                    PageModel.this.loadingErrorData = new ErrorData("\u7f51\u7edc\u5f02\u5e38", "\u62c9\u53d6\u6570\u636e\u5931\u8d25", 2, "\u8fd4\u56de");
                                    function1.invoke(Boolean.FALSE);
                                } else {
                                    if (Intrinsics.areEqual(PageModel.this.getPostData().chatType, "0")) {
                                        O3PostData postData = PageModel.this.getPostData();
                                        postData.chatUin = str5;
                                        postData.postData.v("chatuin", str5);
                                        O3PostData postData2 = PageModel.this.getPostData();
                                        postData2.evilUin = str4;
                                        postData2.postData.v("eviluin", str4);
                                        PageModel.this.getPostData().postData.v("eviluin_type", "2");
                                        if (Intrinsics.areEqual(valueOf, Boolean.TRUE)) {
                                            O3PostData postData3 = PageModel.this.getPostData();
                                            postData3.isFriend = true;
                                            postData3.postData.v("buddyflag", Integer.valueOf(d.b(true)));
                                        }
                                    } else if (Intrinsics.areEqual(PageModel.this.getPostData().chatType, "1")) {
                                        O3PostData postData4 = PageModel.this.getPostData();
                                        postData4.groupCode = str4;
                                        postData4.postData.v("groupcode", str4);
                                        O3PostData postData5 = PageModel.this.getPostData();
                                        postData5.evilUin = str4;
                                        postData5.postData.v("eviluin", str4);
                                        O3PostData postData6 = PageModel.this.getPostData();
                                        postData6.chatUin = str4;
                                        postData6.postData.v("chatuin", str4);
                                        PageModel.this.getPostData().postData.v("eviluin_type", "4");
                                    }
                                    PageModel.this.pullGrayTipDataInner(function1);
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        o3Module.getClass();
                        e m17 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("uid", str2, "chatType", str3);
                        Unit unit = Unit.INSTANCE;
                        o3Module.toNative(false, "uidToUin", m17.toString(), function12, false);
                    }
                }
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
