package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQUIModule;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.superplayer.report.SPReportHelper;
import defpackage.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes31.dex */
public final class JubaoInnerPageController {
    public final JubaoInnerPage page;
    public final PageModel pageModel;

    public JubaoInnerPageController(JubaoInnerPage jubaoInnerPage, PageModel pageModel) {
        this.page = jubaoInnerPage;
        this.pageModel = pageModel;
    }

    public final void doBlackFriend() {
        O3Module o3Module = this.pageModel.getO3Module();
        String str = this.pageModel.getPostData().evilUin;
        Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$doBlackFriend$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                c cVar = c.f117352a;
                ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).log("blackFriend result is " + eVar2);
                String p16 = eVar2 != null ? eVar2.p("errMsg") : null;
                Integer valueOf = eVar2 != null ? Integer.valueOf(eVar2.j("code")) : null;
                if (valueOf != null && valueOf.intValue() == 0 && Intrinsics.areEqual(p16, "cancel")) {
                    ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).log("blackFriend user cancel");
                } else if (valueOf != null && valueOf.intValue() == 0) {
                    PageModel pageModel = JubaoInnerPageController.this.pageModel;
                    pageModel.isBlackFriend$delegate.setValue(pageModel, PageModel.$$delegatedProperties[4], Boolean.TRUE);
                    ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).qToast("\u5df2\u52a0\u5165\u9ed1\u540d\u5355", QToastMode.Success);
                } else {
                    ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).qToast("\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5", QToastMode.Warning);
                }
                return Unit.INSTANCE;
            }
        };
        o3Module.getClass();
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("eviluin", str);
        Unit unit = Unit.INSTANCE;
        o3Module.toNative(false, "blackFriend", m3.toString(), function1, false);
    }

    public final void jumpToNextPage(int i3, int i16) {
        PageViewData curPageViewData = this.page.getCurPageViewData();
        JubaoInnerPage jubaoInnerPage = this.page;
        jubaoInnerPage.setCurPageViewData(new PageViewData(i3, i16 | curPageViewData.curViewFlag));
        if (i3 != 0) {
            jubaoInnerPage.pageViewDataStack.add(jubaoInnerPage.getCurPageViewData());
        }
        onViewChanged();
    }

    public final void onBackClick() {
        Object orNull;
        Object orNull2;
        if ((this.pageModel.getOperateStatus() == 1 || this.pageModel.getOperateStatus() == 3) ? false : true) {
            final int i3 = this.page.getCurPageViewData().curStep;
            final JubaoInnerPage jubaoInnerPage = this.page;
            final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$onBackClick$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    JubaoInnerPageController.this.onViewChanged();
                    if (i3 == 7) {
                        PageModel pageModel = JubaoInnerPageController.this.pageModel;
                        pageModel.selectedMsgRecords = null;
                        pageModel.setEvidenceNum(0);
                        JubaoInnerPageController.this.pageModel.uuid = "";
                    }
                    if (i3 == 8) {
                        PageModel pageModel2 = JubaoInnerPageController.this.pageModel;
                        pageModel2.money = 0L;
                        pageModel2.pics.clear();
                    }
                    return Unit.INSTANCE;
                }
            };
            orNull = CollectionsKt___CollectionsKt.getOrNull(jubaoInnerPage.pageViewDataStack, r0.size() - 2);
            PageViewData pageViewData = (PageViewData) orNull;
            if (pageViewData != null && pageViewData.curStep != 0) {
                ArrayList<ComposeView<?, ?>> arrayList = jubaoInnerPage.viewStack;
                orNull2 = CollectionsKt___CollectionsKt.getOrNull(arrayList, arrayList.size() - 1);
                JubaoAnimationView jubaoAnimationView = orNull2 instanceof JubaoAnimationView ? (JubaoAnimationView) orNull2 : null;
                if (jubaoAnimationView != null) {
                    jubaoInnerPage.viewStack.remove(jubaoAnimationView);
                    Function0<Unit> function02 = new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPage$back$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final Unit invoke() {
                            Object last;
                            JubaoInnerPage jubaoInnerPage2 = JubaoInnerPage.this;
                            CollectionsKt__MutableCollectionsKt.removeLast(jubaoInnerPage2.pageViewDataStack);
                            last = CollectionsKt___CollectionsKt.last((List<? extends Object>) jubaoInnerPage2.pageViewDataStack);
                            jubaoInnerPage2.setCurPageViewData((PageViewData) last);
                            function0.invoke();
                            return Unit.INSTANCE;
                        }
                    };
                    jubaoAnimationView.translateAnimationFlag$delegate.setValue(jubaoAnimationView, JubaoAnimationView.$$delegatedProperties[0], Boolean.FALSE);
                    jubaoAnimationView.outAnimationComplete = function02;
                    return;
                }
                return;
            }
            jubaoInnerPage.pageModel.getO3Module().dismiss();
        }
    }

    public final void onSelectChatMsgClick() {
        String str;
        if (this.pageModel.getOperateStatus() == 3) {
            return;
        }
        final PageModel pageModel = this.pageModel;
        pageModel.getClass();
        ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).log("selectChatMsgs");
        O3Module o3Module = pageModel.getO3Module();
        String str2 = pageModel.getPostData().identifier;
        String str3 = pageModel.getPostData().chatUin;
        String str4 = pageModel.getPostData().chatType;
        String str5 = pageModel.getPostData().groupCode;
        String str6 = pageModel.getPostData().evilUin;
        int j3 = pageModel.getPostData().postData.j("topicid");
        String p16 = pageModel.getPostData().postData.p("uinname");
        e eVar = pageModel.selectedMsgRecords;
        if (eVar == null || (str = eVar.toString()) == null) {
            str = "";
        }
        Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$selectChatMsgs$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                final e eVar3 = eVar2;
                ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).log("selectedMsg is " + eVar3);
                if (eVar3 != null) {
                    int j16 = eVar3.j("msgcount");
                    PageModel pageModel2 = PageModel.this;
                    pageModel2.selectedMsgRecords = eVar3;
                    if (j16 <= 0) {
                        pageModel2.uuid = "";
                        pageModel2.setEvidenceNum(0);
                    } else {
                        O3Module o3Module2 = pageModel2.getO3Module();
                        String str7 = PageModel.this.getPostData().identifier;
                        String str8 = PageModel.this.getPostData().chatUin;
                        String str9 = PageModel.this.getPostData().chatType;
                        String str10 = PageModel.this.getPostData().groupCode;
                        String str11 = PageModel.this.getPostData().evilUin;
                        String eVar4 = eVar3.toString();
                        final PageModel pageModel3 = PageModel.this;
                        o3Module2.uploadChatMsgs(str7, str8, str9, str10, str11, eVar4, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$selectChatMsgs$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(e eVar5) {
                                String str12;
                                String p17;
                                e eVar6 = eVar5;
                                ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).log("uploadChatMsgs result is " + eVar6);
                                PageModel pageModel4 = PageModel.this;
                                String str13 = "";
                                if (eVar6 == null || (str12 = eVar6.p("uuid")) == null) {
                                    str12 = "";
                                }
                                pageModel4.uuid = str12;
                                O3PostData postData = PageModel.this.getPostData();
                                if (eVar6 != null && (p17 = eVar6.p("result")) != null) {
                                    str13 = p17;
                                }
                                postData.postData.v("upload_result", str13);
                                PageModel.this.setEvidenceNum(eVar3.j("msgcount"));
                                return Unit.INSTANCE;
                            }
                        });
                    }
                }
                return Unit.INSTANCE;
            }
        };
        o3Module.getClass();
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m(IECDtReport.ACTION_IDENTIFIER, str2, "chatuin", str3);
        m3.v("chattype", str4);
        m3.v("groupcode", str5);
        m3.v("eviluin", str6);
        m3.t("topicid", j3);
        m3.v("uinname", p16);
        m3.v("msgs", str);
        Unit unit = Unit.INSTANCE;
        o3Module.toNative(false, "selectChatMsgs", m3.toString(), function1, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0009, code lost:
    
        if (r0.moreEvidence == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onSelectChatMsgCompleteClick() {
        JubaoReasonData jubaoReasonData = this.pageModel.selectedReasonData;
        boolean z16 = jubaoReasonData != null;
        if (z16 && !JubaoConfig.isQuickJubao) {
            jumpToNextPage(8, 16);
        } else {
            submit();
        }
    }

    public final void onSubmitSuccessInner() {
        Object obj;
        this.pageModel.setOperateStatus(4);
        O3Module o3Module = this.pageModel.getO3Module();
        String str = this.pageModel.getPostData().identifier;
        o3Module.getClass();
        e eVar = new e();
        eVar.t("reportStatus", 1);
        eVar.v("callbackId", str);
        Unit unit = Unit.INSTANCE;
        o3Module.toNative(false, "notifyStatus", eVar.toString(), null, false);
        JubaoReasonData jubaoReasonData = this.pageModel.selectedReasonData;
        if (!Intrinsics.areEqual(jubaoReasonData != null ? jubaoReasonData.name : null, "\u5b58\u5728\u6b3a\u8bc8\u9a97\u94b1\u884c\u4e3a") && !JubaoConfig.isQuickJubao) {
            Iterator<T> it = this.pageModel.operatesData.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (((OperateData) obj).subType == 4) {
                        break;
                    }
                }
            }
            OperateData operateData = (OperateData) obj;
            if (operateData != null) {
                this.pageModel.operatesData.remove(operateData);
            }
        }
        JubaoReasonData jubaoReasonData2 = this.pageModel.selectedReasonData;
        if (Intrinsics.areEqual(jubaoReasonData2 != null ? jubaoReasonData2.name : null, "QQ\u53f7\u7801\u88ab\u76d7\u7528")) {
            CollectionsKt__MutableCollectionsKt.removeAll((List) this.pageModel.operatesData, (Function1) new Function1<OperateData, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$onSubmitSuccessInner$3
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(OperateData operateData2) {
                    return Boolean.valueOf(operateData2.subType == 6);
                }
            });
        }
        jumpToNextPage(9, 32);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
    
        if (r4.moreEvidence == true) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onTypeItemClick(JubaoTypeData jubaoTypeData) {
        PageModel pageModel = this.pageModel;
        pageModel.selectedTypeData = jubaoTypeData;
        if (pageModel.evidenceViewFlag == 2) {
            JubaoReasonData jubaoReasonData = pageModel.selectedReasonData;
            boolean z16 = jubaoReasonData != null;
            if (z16) {
                jumpToNextPage(8, 16);
                return;
            } else {
                submit();
                return;
            }
        }
        jumpToNextPage(7, 8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0032, code lost:
    
        if ((r0.length() > 0) == true) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onViewChanged() {
        int i3 = this.page.getCurPageViewData().curStep;
        boolean z16 = true;
        if (i3 != 1) {
            if (i3 == 7) {
                this.pageModel.getO3Module().floatingViewSlideToMidHeight();
            } else if (i3 != 12) {
                this.pageModel.getO3Module().floatingViewSlideToMaxHeight();
            } else {
                GrayTipData grayTipData = this.pageModel.getGrayTipData();
                if (grayTipData != null && (r0 = grayTipData.imgUrl) != null) {
                }
                z16 = false;
                if (z16) {
                    this.pageModel.getO3Module().floatingViewSlideToMaxHeight();
                } else {
                    this.pageModel.getO3Module().floatingViewSlideToMidHeight();
                }
            }
        } else if (this.page.getPageData().getIsIOS()) {
            TimerKt.d(100, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$setHeight$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Unit invoke() {
                    JubaoInnerPageController.this.pageModel.getO3Module().floatingViewSlideToMidHeight();
                    return Unit.INSTANCE;
                }
            });
        } else {
            this.pageModel.getO3Module().floatingViewSlideToMidHeight();
        }
        int i16 = this.page.getCurPageViewData().curStep;
        if (i16 != 4 && i16 != 5 && i16 != 6 && i16 != 8 && i16 != 9 && i16 != 13) {
            O3Module.updateFloatingView$default(this.pageModel.getO3Module(), 0, null, null, Boolean.TRUE, 15);
        } else {
            O3Module.updateFloatingView$default(this.pageModel.getO3Module(), 0, null, null, Boolean.FALSE, 15);
        }
    }

    public final void operate(OperateData operateData) {
        int i3 = operateData.type;
        if (i3 == 1 || i3 == 2) {
            QQKuiklyPlatformApi.openPage$default((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi"), operateData.jumpUrl, false, 6);
            return;
        }
        if (i3 != 3) {
            return;
        }
        int i16 = operateData.subType;
        if (i16 == 1) {
            if (this.pageModel.isBlackFriend()) {
                return;
            }
            if (this.page.getPageData().getIsIOS()) {
                doBlackFriend();
                return;
            } else {
                ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).showAlert("\u62c9\u9ed1\u8be5\u7528\u6237", "\u62c9\u9ed1\u8be5\u7528\u6237\u540e\uff0c\u4f60\u5c06\u4e0d\u518d\u6536\u5230\u5bf9\u65b9\u7684\u6d88\u606f\u548c\u597d\u53cb\u9a8c\u8bc1\uff0c\u5e76\u4e14\u4e92\u76f8\u770b\u4e0d\u5230\u5bf9\u65b9\u7684\u7a7a\u95f4\u548cQQ\u77ed\u89c6\u9891\u3002", "\u8fd4\u56de", "\u786e\u8ba4\u62c9\u9ed1", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$blackFriend$1
                    {
                        super(1);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
                    
                        if (r2.j("index") == 1) goto L8;
                     */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Unit invoke(e eVar) {
                        e eVar2 = eVar;
                        boolean z16 = eVar2 != null;
                        if (z16) {
                            JubaoInnerPageController.this.doBlackFriend();
                        }
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
        }
        if (i16 == 2) {
            if (this.pageModel.isQuitGroup()) {
                return;
            }
            ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).showAlert("\u9000\u51fa\u7fa4\u804a", "\u9000\u51fa\u7fa4\u804a\u540e\uff0c\u4f60\u7684\u8bbe\u5907\u4e2d\u8be5\u7fa4\u804a\u7684\u804a\u5929\u8bb0\u5f55\u5c06\u88ab\u6e05\u9664\uff0c\u8bf7\u786e\u4fdd\u4f60\u5df2\u5c06\u91cd\u8981\u4fe1\u606f\u8fdb\u884c\u4fdd\u5b58\u3002\u9000\u7fa4\u901a\u77e5\u4ec5\u7fa4\u7ba1\u7406\u5458\u53ef\u89c1\u3002", "\u8fd4\u56de", "\u9000\u51fa", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$quitGroup$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar) {
                    e eVar2 = eVar;
                    if (eVar2 != null && eVar2.j("index") == 1) {
                        O3Module o3Module = JubaoInnerPageController.this.pageModel.getO3Module();
                        String str = JubaoInnerPageController.this.pageModel.getPostData().groupCode;
                        final JubaoInnerPageController jubaoInnerPageController = JubaoInnerPageController.this;
                        Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$quitGroup$1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(e eVar3) {
                                e eVar4 = eVar3;
                                c cVar = c.f117352a;
                                ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).log("quitGroup result is " + eVar4);
                                if (eVar4 != null && eVar4.j("code") == 0) {
                                    PageModel pageModel = JubaoInnerPageController.this.pageModel;
                                    pageModel.isQuitGroup$delegate.setValue(pageModel, PageModel.$$delegatedProperties[5], Boolean.TRUE);
                                    if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar)) {
                                        ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).qToast("\u5df2\u9000\u51fa\u7fa4\u804a", QToastMode.Success);
                                    }
                                    JubaoInnerPageController.this.pageModel.getO3Module().dismiss();
                                } else {
                                    ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).qToast("\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5", QToastMode.Warning);
                                }
                                return Unit.INSTANCE;
                            }
                        };
                        o3Module.getClass();
                        e eVar3 = new e();
                        eVar3.v("groupcode", str);
                        eVar3.w("clearHistory", true);
                        Unit unit = Unit.INSTANCE;
                        o3Module.toNative(false, "quitGroup", eVar3.toString(), function1, false);
                    }
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        if (i16 == 4) {
            QQKuiklyPlatformApi.openPage$default((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi"), operateData.jumpUrl, false, 6);
            return;
        }
        if (i16 != 5) {
            if (i16 == 6 && !this.pageModel.isDeleteFriend()) {
                ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).showAlert("\u5220\u9664\u8be5\u597d\u53cb", "\u5220\u9664\u8be5\u597d\u53cb\u540e\uff0c\u4f60\u4eec\u7684\u804a\u5929\u8bb0\u5f55\u5c06\u88ab\u6e05\u9664\uff0c\u540e\u7eed\u4f60\u5c06\u4e0d\u518d\u770b\u5230\u8be5\u7528\u6237\u53d1\u5e03\u7684\u52a8\u6001\u7b49\u5185\u5bb9\u3002", "\u8fd4\u56de", "\u786e\u8ba4\u5220\u9664", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$deleteFriend$1
                    {
                        super(1);
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
                    
                        if (r8.j("index") == 1) goto L8;
                     */
                    @Override // kotlin.jvm.functions.Function1
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Unit invoke(e eVar) {
                        boolean z16;
                        e eVar2 = eVar;
                        if (eVar2 != null) {
                            z16 = true;
                        }
                        z16 = false;
                        if (z16) {
                            O3Module o3Module = JubaoInnerPageController.this.pageModel.getO3Module();
                            String str = JubaoInnerPageController.this.pageModel.getPostData().evilUin;
                            final JubaoInnerPageController jubaoInnerPageController = JubaoInnerPageController.this;
                            Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$deleteFriend$1.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public final Unit invoke(e eVar3) {
                                    e eVar4 = eVar3;
                                    c cVar = c.f117352a;
                                    ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).log("deleteFriend result is " + eVar4);
                                    if (eVar4 != null && eVar4.j("code") == 0) {
                                        PageModel pageModel = JubaoInnerPageController.this.pageModel;
                                        pageModel.isDeleteFriend$delegate.setValue(pageModel, PageModel.$$delegatedProperties[3], Boolean.TRUE);
                                        ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).qToast("\u5df2\u5220\u9664\u8be5\u597d\u53cb", QToastMode.Success);
                                    } else {
                                        ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).qToast("\u7f51\u7edc\u9519\u8bef\uff0c\u8bf7\u9000\u51fa\u91cd\u8bd5", QToastMode.Warning);
                                    }
                                    return Unit.INSTANCE;
                                }
                            };
                            o3Module.getClass();
                            e eVar3 = new e();
                            eVar3.v("eviluin", str);
                            eVar3.w("shouldShield", false);
                            Unit unit = Unit.INSTANCE;
                            o3Module.toNative(false, "deleteFriend", eVar3.toString(), function1, false);
                        }
                        return Unit.INSTANCE;
                    }
                });
                return;
            }
            return;
        }
        if (this.pageModel.isFollowAccount()) {
            return;
        }
        O3Module o3Module = this.pageModel.getO3Module();
        Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$followO3$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                c cVar = c.f117352a;
                ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).log("followOfficialAccounts result:" + eVar2);
                if (eVar2 != null && eVar2.j("code") == 0) {
                    PageModel pageModel = JubaoInnerPageController.this.pageModel;
                    pageModel.isFollowAccount$delegate.setValue(pageModel, PageModel.$$delegatedProperties[2], Boolean.TRUE);
                    ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).qToast("\u5173\u6ce8\u6210\u529f", QToastMode.Success);
                } else {
                    ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).qToast("\u5173\u6ce8\u5931\u8d25", QToastMode.Warning);
                }
                return Unit.INSTANCE;
            }
        };
        o3Module.getClass();
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("uin", "1770946116");
        Unit unit = Unit.INSTANCE;
        o3Module.toNative(false, "followOfficialAccounts", m3.toString(), function1, false);
    }

    public final void quickJubaoWhenSelectAppId() {
        if (this.pageModel.evidenceViewFlag == 2) {
            realSubmit();
        } else {
            jumpToNextPage(7, 8);
        }
    }

    public final void realSubmit() {
        this.pageModel.setOperateStatus(3);
        final PageModel pageModel = this.pageModel;
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$realSubmit$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    final JubaoInnerPageController jubaoInnerPageController = JubaoInnerPageController.this;
                    if (JubaoConfig.isQuickJubao) {
                        PageModel pageModel2 = jubaoInnerPageController.pageModel;
                        final Function3<Integer, String, List<? extends UpdateReasonData>, Unit> function3 = new Function3<Integer, String, List<? extends UpdateReasonData>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$onSubmitSuccess$1
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public final Unit invoke(Integer num, String str, List<? extends UpdateReasonData> list) {
                                List<? extends UpdateReasonData> list2 = list;
                                if (num.intValue() == 0 && !list2.isEmpty()) {
                                    JubaoInnerPageController.this.pageModel.updateReasonList.addAll(list2);
                                } else {
                                    JubaoInnerPageController jubaoInnerPageController2 = JubaoInnerPageController.this;
                                    jubaoInnerPageController2.pageModel.updateReasonList.add(new UpdateReasonData("\u8272\u60c5\u4f4e\u4fd7", 0, 0));
                                    jubaoInnerPageController2.pageModel.updateReasonList.add(new UpdateReasonData("\u653f\u6cbb\u8c23\u8a00", 0, 0));
                                    jubaoInnerPageController2.pageModel.updateReasonList.add(new UpdateReasonData("\u5e7f\u544a\u5f15\u6d41", 0, 0));
                                    jubaoInnerPageController2.pageModel.updateReasonList.add(new UpdateReasonData("\u6b3a\u8bc8\u9a97\u94b1", 1, 1));
                                    jubaoInnerPageController2.pageModel.updateReasonList.add(new UpdateReasonData("\u66b4\u529b\u6050\u6016", 0, 1));
                                    jubaoInnerPageController2.pageModel.updateReasonList.add(new UpdateReasonData("\u8fdd\u6cd5\u8fdd\u89c4", 0, 1));
                                    jubaoInnerPageController2.pageModel.updateReasonList.add(new UpdateReasonData("\u8425\u9500\u6c34\u519b", 0, 0));
                                    jubaoInnerPageController2.pageModel.updateReasonList.add(new UpdateReasonData("\u672a\u6210\u5e74\u76f8\u5173", 2, 1));
                                    jubaoInnerPageController2.pageModel.updateReasonList.add(new UpdateReasonData("\u7f51\u66b4\u4fb5\u6743", 0, 0));
                                    jubaoInnerPageController2.pageModel.updateReasonList.add(new UpdateReasonData("\u53f7\u7801\u88ab\u76d7", 3, 0));
                                    jubaoInnerPageController2.pageModel.updateReasonList.add(new UpdateReasonData("\u4e0d\u53cb\u5584\u53d1\u8a00", 0, 0));
                                    jubaoInnerPageController2.pageModel.updateReasonList.add(new UpdateReasonData("\u5176\u4ed6", 0, 0));
                                }
                                JubaoInnerPageController.this.onSubmitSuccessInner();
                                return Unit.INSTANCE;
                            }
                        };
                        O3PostData postData = pageModel2.getPostData();
                        String str = pageModel2.jubaoSuccessSeqId;
                        if (str == null) {
                            str = "";
                        }
                        postData.postData.v("seq_id", str);
                        e contentValidateReq$qecommerce_biz_release = JubaoUtil.INSTANCE.getContentValidateReq$qecommerce_biz_release(pageModel2);
                        contentValidateReq$qecommerce_biz_release.v("qrt_token", pageModel2.getPostData().token);
                        pageModel2.getO3Module().sendRequest("ImpeachReasonSuggestor", contentValidateReq$qecommerce_biz_release, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$pullAgentReason$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final Unit invoke(e eVar) {
                                e eVar2 = eVar;
                                e m3 = eVar2 != null ? eVar2.m("data") : null;
                                if (m3 == null) {
                                    ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).log("pullAgentReason error jsonResult empty");
                                    function3.invoke(-1, "", new ArrayList());
                                } else {
                                    int k3 = m3.k("result_code", -1);
                                    ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).log("pullAgentReason complete " + k3 + TokenParser.SP + m3);
                                    b l3 = m3.l("reason_list");
                                    if (l3 == null) {
                                        l3 = new b();
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    int c16 = l3.c();
                                    for (int i3 = 0; i3 < c16; i3++) {
                                        e l16 = l3.l(i3);
                                        if (l16 != null) {
                                            String p16 = l16.p("reason");
                                            int j3 = l16.j("is_special_reason");
                                            int j16 = l16.j("show_alarm");
                                            if (p16.length() > 0) {
                                                arrayList.add(new UpdateReasonData(p16, j3, j16));
                                            }
                                        }
                                    }
                                    function3.invoke(Integer.valueOf(k3), "", arrayList);
                                }
                                return Unit.INSTANCE;
                            }
                        });
                    } else {
                        jubaoInnerPageController.onSubmitSuccessInner();
                    }
                } else {
                    JubaoInnerPageController.this.pageModel.setOperateStatus(4);
                    JubaoInnerPageController.this.jumpToNextPage(10, 0);
                }
                return Unit.INSTANCE;
            }
        };
        pageModel.getClass();
        e contentValidateReq$qecommerce_biz_release = JubaoUtil.INSTANCE.getContentValidateReq$qecommerce_biz_release(pageModel);
        contentValidateReq$qecommerce_biz_release.v("qrt_token", pageModel.getPostData().token);
        pageModel.getO3Module().sendRequest("SSOImpeach", contentValidateReq$qecommerce_biz_release, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$submitReport$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e m3;
                e m16;
                e eVar2 = eVar;
                c cVar = c.f117352a;
                ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).log("submit result is " + eVar2);
                String str = null;
                e m17 = (eVar2 == null || (m16 = eVar2.m("data")) == null) ? null : m16.m("result");
                if (m17 == null) {
                    PageModel.this.submitErrorData = new ErrorData("\u7f51\u7edc\u5f02\u5e38", "\u540e\u53f0\u65e0\u6cd5\u6536\u5230\u4f60\u7684\u8bf7\u6c42\uff0c\u8bf7\u8fd4\u56de\u91cd\u8bd5\u4e3e\u62a5", 0, "\u8fd4\u56de");
                    function1.invoke(null);
                } else {
                    int j3 = m17.j("code");
                    String p16 = m17.p("title");
                    String p17 = m17.p("desc");
                    m17.f("link_to_impeach");
                    if (j3 != 0) {
                        PageModel.this.submitErrorData = new ErrorData(p16, p17, 0, "\u8fd4\u56de");
                        function1.invoke(Boolean.FALSE);
                    } else {
                        e m18 = eVar2.m("data");
                        boolean f16 = m18 != null ? m18.f("is_wb") : false;
                        PageModel pageModel2 = PageModel.this;
                        pageModel2.isWb = f16;
                        if (!f16 && !JubaoConfig.isQuickJubao) {
                            CollectionsKt__MutableCollectionsKt.removeAll((List) pageModel2.operatesData, (Function1) new Function1<OperateData, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$submitReport$1.1
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(OperateData operateData) {
                                    return Boolean.valueOf(Intrinsics.areEqual(operateData.desc, "wb"));
                                }
                            });
                        }
                        PageModel.this.submitTime = ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).currentTimeStamp();
                        PageModel pageModel3 = PageModel.this;
                        e m19 = eVar2.m("data");
                        if (m19 != null && (m3 = m19.m(SPReportHelper.KEY_DEBUG_INFO)) != null) {
                            str = m3.p("seq_id");
                        }
                        pageModel3.jubaoSuccessSeqId = str;
                        BridgeModule bridgeModule = (BridgeModule) cVar.g().acquireModule("HRBridgeModule");
                        StringBuilder m26 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("jubaoSuccessSeqId:");
                        m26.append(PageModel.this.jubaoSuccessSeqId);
                        bridgeModule.log(m26.toString());
                        function1.invoke(Boolean.TRUE);
                    }
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void submit() {
        if (this.pageModel.getOperateStatus() == 3) {
            return;
        }
        this.pageModel.setOperateStatus(3);
        PageModel pageModel = this.pageModel;
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$submit$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                if (!Intrinsics.areEqual(bool, Boolean.TRUE)) {
                    PageModel pageModel2 = JubaoInnerPageController.this.pageModel;
                    if (!pageModel2.isNoticeEvidence) {
                        pageModel2.setOperateStatus(0);
                        BridgeModule bridgeModule = (BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule");
                        final JubaoInnerPageController jubaoInnerPageController = JubaoInnerPageController.this;
                        bridgeModule.showAlert("\u4e3e\u62a5\u5efa\u8bae", "\u4f60\u5f53\u524d\u63d0\u4f9b\u7684\u8bc1\u636e\u8f83\u5c11\uff0c\u5b89\u5168\u4e2d\u5fc3\u53ef\u80fd\u65e0\u6cd5\u5bf9\u4f60\u7684\u4e3e\u62a5\u8fdb\u884c\u88c1\u5b9a\uff0c\u5efa\u8bae\u4f60\u8865\u5145\u66f4\u591a\u8bc1\u636e\u540e\u91cd\u65b0\u63d0\u4ea4\u3002", "\u8fd4\u56de\u8865\u5145", "\u76f4\u63a5\u63d0\u4ea4", new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$submit$1.1
                            {
                                super(1);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:4:0x000c, code lost:
                            
                                if (r2.j("index") == 1) goto L8;
                             */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(e eVar) {
                                e eVar2 = eVar;
                                boolean z16 = eVar2 != null;
                                if (z16) {
                                    JubaoInnerPageController.this.realSubmit();
                                }
                                return Unit.INSTANCE;
                            }
                        });
                        JubaoInnerPageController.this.pageModel.isNoticeEvidence = true;
                        return Unit.INSTANCE;
                    }
                }
                JubaoInnerPageController.this.realSubmit();
                return Unit.INSTANCE;
            }
        };
        pageModel.getClass();
        e contentValidateReq$qecommerce_biz_release = JubaoUtil.INSTANCE.getContentValidateReq$qecommerce_biz_release(pageModel);
        ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).log("contentValid request");
        pageModel.getO3Module().sendRequest("SSOContentValidate", contentValidateReq$qecommerce_biz_release, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$contentValid$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e m3;
                e eVar2 = eVar;
                ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).log("contentValid result " + eVar2);
                e m16 = (eVar2 == null || (m3 = eVar2.m("data")) == null) ? null : m3.m("result");
                if (m16 == null) {
                    function1.invoke(null);
                } else {
                    int j3 = m16.j("code");
                    m16.p("title");
                    m16.p("desc");
                    m16.f("link_to_impeach");
                    function1.invoke(Boolean.valueOf(j3 == 0));
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void toJubaoStartPage() {
        if (this.pageModel.selectData.isEmpty()) {
            if (!JubaoConfig.isQuickJubao) {
                jumpToNextPage(4, 1);
                return;
            } else {
                quickJubaoWhenSelectAppId();
                return;
            }
        }
        jumpToNextPage(1, 0);
    }

    public final void updateReasonInner() {
        c cVar = c.f117352a;
        long currentTimeStamp = ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).currentTimeStamp();
        PageModel pageModel = this.pageModel;
        if (currentTimeStamp - pageModel.submitTime >= MiniBoxNoticeInfo.MIN_5) {
            ((QQUIModule) cVar.g().acquireModule("QQUIModule")).openAlertDialog("\u64cd\u4f5c\u8d85\u65f6", "\u5f53\u524d\u4e3e\u62a5\u5df2\u63d0\u4ea4\u6210\u529f\uff0c\u4e3e\u62a5\u539f\u56e0\u7f3a\u5931\u4e0d\u4f1a\u5f71\u54cd\u5ba1\u6838\u51c6\u786e\u6027\u3002\u5982\u4f60\u4ecd\u9700\u8981\u8865\u5145\u4e3e\u62a5\u539f\u56e0\uff0c\u53ef\u5c1d\u8bd5\u91cd\u65b0\u4e3e\u62a5\u3002", "", "\u597d\u7684", "", false, new Function2<Boolean, Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$updateReasonInner$1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Unit invoke(Boolean bool, Boolean bool2) {
                    bool.booleanValue();
                    bool2.booleanValue();
                    JubaoInnerPageController.this.pageModel.getO3Module().dismiss();
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        pageModel.setOperateStatus(5);
        PageModel pageModel2 = this.pageModel;
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$updateReasonInner$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Boolean bool) {
                boolean booleanValue = bool.booleanValue();
                JubaoInnerPageController.this.pageModel.setOperateStatus(booleanValue ? 6 : 7);
                if (booleanValue) {
                    final JubaoInnerPageController jubaoInnerPageController = JubaoInnerPageController.this;
                    TimerKt.g(new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController$updateReasonInner$2.1
                        {
                            super(0);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:34:0x008f, code lost:
                        
                            if ((r0 != null && r0.subType == 2) != false) goto L39;
                         */
                        @Override // kotlin.jvm.functions.Function0
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke() {
                            Object orNull;
                            Object orNull2;
                            Object orNull3;
                            PageModel pageModel3 = JubaoInnerPageController.this.pageModel;
                            if (pageModel3.updateReason.flag != 1) {
                                CollectionsKt__MutableCollectionsKt.removeAll((List) pageModel3.operatesData, (Function1) new Function1<OperateData, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController.updateReasonInner.2.1.1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(OperateData operateData) {
                                        return Boolean.valueOf(operateData.subType == 4);
                                    }
                                });
                            }
                            PageModel pageModel4 = JubaoInnerPageController.this.pageModel;
                            int i3 = pageModel4.updateReason.flag;
                            if (i3 == 2) {
                                pageModel4.isWb = true;
                            }
                            if (i3 == 3 && pageModel4.getPostData().isFriend) {
                                CollectionsKt__MutableCollectionsKt.removeAll((List) JubaoInnerPageController.this.pageModel.operatesData, (Function1) new Function1<OperateData, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController.updateReasonInner.2.1.2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(OperateData operateData) {
                                        return Boolean.valueOf(operateData.subType == 6);
                                    }
                                });
                            }
                            PageModel pageModel5 = JubaoInnerPageController.this.pageModel;
                            if (!pageModel5.isWb) {
                                CollectionsKt__MutableCollectionsKt.removeAll((List) pageModel5.operatesData, (Function1) new Function1<OperateData, Boolean>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoInnerPageController.updateReasonInner.2.1.3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(OperateData operateData) {
                                        return Boolean.valueOf(Intrinsics.areEqual(operateData.desc, "wb"));
                                    }
                                });
                            }
                            PageModel pageModel6 = JubaoInnerPageController.this.pageModel;
                            if (pageModel6.updateReason.alarm == 1) {
                                int i16 = 0;
                                orNull = CollectionsKt___CollectionsKt.getOrNull(pageModel6.operatesData, 0);
                                OperateData operateData = (OperateData) orNull;
                                if (!(operateData != null && operateData.subType == 6)) {
                                    orNull2 = CollectionsKt___CollectionsKt.getOrNull(JubaoInnerPageController.this.pageModel.operatesData, 0);
                                    OperateData operateData2 = (OperateData) orNull2;
                                    if (!(operateData2 != null && operateData2.subType == 1)) {
                                        orNull3 = CollectionsKt___CollectionsKt.getOrNull(JubaoInnerPageController.this.pageModel.operatesData, 0);
                                        OperateData operateData3 = (OperateData) orNull3;
                                    }
                                }
                                i16 = 1;
                                ArrayList<OperateData> arrayList = JubaoInnerPageController.this.pageModel.operatesData;
                                OperateData operateData4 = new OperateData();
                                operateData4.type = 1;
                                operateData4.title = "\u7acb\u5373\u62a5\u8b66";
                                operateData4.desc = "QQ\u5b89\u5168\u4e2d\u5fc3\u4f1a\u534f\u52a9\u8b66\u65b9\u4e00\u540c\u5904\u7406\u3002";
                                operateData4.btnText = "\u53bb\u67e5\u770b";
                                operateData4.jumpUrl = "mqqapi://miniapp/open?_atype=0&_mappid=1112223557&_miniapptype=1&_mvid=&_path=pkgReport%2Fpages%2Freport_guide%2Findex&_vt=3&via=qq_txws&_sig=1115006160&_nq=scene%3Dqq";
                                Unit unit = Unit.INSTANCE;
                                arrayList.add(i16, operateData4);
                            }
                            JubaoInnerPageController.this.pageModel.setOperateStatus(8);
                            if (JubaoInnerPageController.this.page.getCurPageViewData().curStep == 8) {
                                JubaoInnerPageController.this.jumpToNextPage(9, 32);
                            }
                            return Unit.INSTANCE;
                        }
                    }, 1000);
                } else {
                    ((QQKuiklyPlatformApi) c.f117352a.g().acquireModule("QQKuiklyPlatformApi")).qqToast("\u66f4\u65b0\u539f\u56e0\u5931\u8d25", QToastMode.Warning);
                }
                return Unit.INSTANCE;
            }
        };
        pageModel2.getClass();
        e eVar = new e();
        eVar.v("appid", pageModel2.getPostData().appId);
        eVar.v("sequence_id", pageModel2.jubaoSuccessSeqId);
        eVar.v("eviluin", pageModel2.getPostData().evilUin);
        eVar.v("reason", pageModel2.updateReason.desc);
        b a16 = o.a(eVar, "desc", pageModel2.addReason);
        Iterator<Map.Entry<String, String>> it = pageModel2.pics.entrySet().iterator();
        while (it.hasNext()) {
            a16.t(it.next().getValue());
        }
        Unit unit = Unit.INSTANCE;
        eVar.v(s4.c.PICS, a16);
        eVar.v("phone", "");
        eVar.w("has_money_loss", pageModel2.money > 0);
        eVar.u("money_loss", pageModel2.money);
        pageModel2.getO3Module().sendRequest("UpdateImpeachReason", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$updateReason$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                e m3 = eVar3 != null ? eVar3.m("data") : null;
                if (m3 == null) {
                    ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).log("updateReason error jsonResult empty");
                    function1.invoke(Boolean.FALSE);
                } else {
                    int j3 = m3.j("code");
                    ((BridgeModule) c.f117352a.g().acquireModule("HRBridgeModule")).log("updateReason complete " + m3);
                    function1.invoke(Boolean.valueOf(j3 == 0));
                }
                return Unit.INSTANCE;
            }
        });
    }
}
