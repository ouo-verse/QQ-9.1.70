package com.tencent.hippykotlin.demo.pages.jubao;

import c01.c;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.msf.core.f0.c.e.h;
import com.tencent.tuxmeterqui.config.TuxUIConstants;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class PageModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(PageModel.class, "grayTipData", "getGrayTipData()Lcom/tencent/hippykotlin/demo/pages/jubao/GrayTipData;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(PageModel.class, "evidenceNum", "getEvidenceNum()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(PageModel.class, "isFollowAccount", "isFollowAccount()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(PageModel.class, "isDeleteFriend", "isDeleteFriend()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(PageModel.class, "isBlackFriend", "isBlackFriend()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(PageModel.class, "isQuitGroup", "isQuitGroup()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(PageModel.class, "operateStatus", "getOperateStatus()I", 0)};
    public String addReason;
    public final ReadWriteProperty evidenceNum$delegate;
    public int evidenceViewFlag;
    public final ReadWriteProperty grayTipData$delegate;
    public final ReadWriteProperty isBlackFriend$delegate;
    public final ReadWriteProperty isDeleteFriend$delegate;
    public final ReadWriteProperty isFollowAccount$delegate;
    public boolean isNoticeEvidence;
    public final ReadWriteProperty isQuitGroup$delegate;
    public boolean isWb;
    public String jubaoSuccessSeqId;
    public ErrorData loadingErrorData;
    public long money;
    public final Lazy o3Module$delegate;
    public final ReadWriteProperty operateStatus$delegate;
    public ArrayList<OperateData> operatesData;
    public String originalAppId;
    public final JubaoInnerPage page;
    public HashMap<String, String> pics;
    public final Lazy postData$delegate;
    public String psKey;
    public ArrayList<JubaoReasonData> reasonsData;
    public ArrayList<JubaoSelectData> selectData;
    public e selectedMsgRecords;
    public JubaoReasonData selectedReasonData;
    public JubaoTypeData selectedTypeData;
    public ErrorData submitErrorData;
    public long submitTime;
    public UpdateReasonData updateReason;
    public final ArrayList<UpdateReasonData> updateReasonList;
    public int uploadCompleteNum;
    public int uploadSuccessNum;
    public String uuid;

    public PageModel(JubaoInnerPage jubaoInnerPage) {
        Lazy lazy;
        Lazy lazy2;
        this.page = jubaoInnerPage;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<O3Module>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$o3Module$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final O3Module invoke() {
                return (O3Module) PageModel.this.page.acquireModule("QQKuiklySecurityModule");
            }
        });
        this.o3Module$delegate = lazy;
        this.psKey = "";
        this.originalAppId = "";
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<O3PostData>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$postData$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final O3PostData invoke() {
                e m3 = PageModel.this.page.getPageData().n().m("jubaoModel");
                if (m3 == null) {
                    m3 = new e();
                }
                return new O3PostData(m3);
            }
        });
        this.postData$delegate = lazy2;
        this.grayTipData$delegate = c.a(null);
        this.selectData = new ArrayList<>();
        this.reasonsData = new ArrayList<>();
        this.evidenceViewFlag = 2;
        this.loadingErrorData = new ErrorData("", "", 0, "\u8fd4\u56de");
        this.evidenceNum$delegate = c.a(0);
        this.addReason = "";
        this.uuid = "";
        Boolean bool = Boolean.FALSE;
        this.isFollowAccount$delegate = c.a(bool);
        this.submitErrorData = new ErrorData("", "", 0, "\u8fd4\u56de");
        this.operatesData = new ArrayList<>();
        this.isDeleteFriend$delegate = c.a(bool);
        this.isBlackFriend$delegate = c.a(bool);
        this.isQuitGroup$delegate = c.a(bool);
        this.operateStatus$delegate = c.a(0);
        this.pics = new HashMap<>();
        this.updateReason = new UpdateReasonData("", 0, 0);
        this.updateReasonList = new ArrayList<>();
    }

    public static final void access$onSinglePicUploadComplete(PageModel pageModel, int i3, String str, String str2, boolean z16, Function1 function1) {
        synchronized (pageModel) {
            boolean z17 = true;
            if (z16) {
                pageModel.pics.put(str, str2);
                pageModel.uploadSuccessNum++;
            }
            int i16 = pageModel.uploadCompleteNum + 1;
            pageModel.uploadCompleteNum = i16;
            if (i16 == i3) {
                if (pageModel.uploadSuccessNum != i16) {
                    z17 = false;
                }
                function1.invoke(Boolean.valueOf(z17));
            }
        }
    }

    public final e getDTParams() {
        e jubaoDTBaseParams = ConstantsKt.getJubaoDTBaseParams();
        JubaoReasonData jubaoReasonData = this.selectedReasonData;
        jubaoDTBaseParams.v("safe_report_type", jubaoReasonData != null ? jubaoReasonData.name : null);
        JubaoTypeData jubaoTypeData = this.selectedTypeData;
        jubaoDTBaseParams.v("jb_detail", jubaoTypeData != null ? jubaoTypeData.name : null);
        return jubaoDTBaseParams;
    }

    public final int getEvidenceNum() {
        return ((Number) this.evidenceNum$delegate.getValue(this, $$delegatedProperties[1])).intValue();
    }

    public final GrayTipData getGrayTipData() {
        return (GrayTipData) this.grayTipData$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final O3Module getO3Module() {
        return (O3Module) this.o3Module$delegate.getValue();
    }

    public final int getOperateStatus() {
        return ((Number) this.operateStatus$delegate.getValue(this, $$delegatedProperties[6])).intValue();
    }

    public final O3PostData getPostData() {
        return (O3PostData) this.postData$delegate.getValue();
    }

    public final boolean isBlackFriend() {
        return ((Boolean) this.isBlackFriend$delegate.getValue(this, $$delegatedProperties[4])).booleanValue();
    }

    public final boolean isDeleteFriend() {
        return ((Boolean) this.isDeleteFriend$delegate.getValue(this, $$delegatedProperties[3])).booleanValue();
    }

    public final boolean isFollowAccount() {
        return ((Boolean) this.isFollowAccount$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }

    public final boolean isQuitGroup() {
        return ((Boolean) this.isQuitGroup$delegate.getValue(this, $$delegatedProperties[5])).booleanValue();
    }

    public final void pullGrayTipDataInner(final Function1<? super Boolean, Unit> function1) {
        O3Module o3Module = getO3Module();
        e eVar = new e();
        eVar.v("gray_tips_id", getPostData().grayId);
        Unit unit = Unit.INSTANCE;
        o3Module.sendRequest("GetGrayTipsTemplate", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$pullGrayTipDataInner$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e m3;
                e m16;
                e eVar3 = eVar2;
                int j3 = eVar3 != null ? eVar3.j("code") : -1;
                e m17 = (eVar3 == null || (m3 = eVar3.m("data")) == null || (m16 = m3.m("template")) == null) ? null : m16.m("value");
                ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).log("GetGrayTipsTemplate code is " + j3);
                if (j3 == 0 && m17 != null) {
                    int j16 = m17.j("tagId");
                    boolean z16 = m17.k("evidence", 0) == 1;
                    final String p16 = m17.p("content");
                    final String p17 = m17.p("imgUrl");
                    final String p18 = m17.p(WadlProxyConsts.KEY_JUMP_URL);
                    PageModel pageModel = PageModel.this;
                    pageModel.selectedReasonData = new JubaoReasonData("", null, z16, false, "");
                    pageModel.selectedTypeData = new JubaoTypeData("", Integer.valueOf(j16));
                    final PageModel pageModel2 = PageModel.this;
                    final Function1<Boolean, Unit> function12 = function1;
                    pageModel2.pullTemplateData(new Function1<Boolean, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$pullGrayTipDataInner$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Unit invoke(Boolean bool) {
                            boolean booleanValue = bool.booleanValue();
                            if (booleanValue) {
                                PageModel pageModel3 = PageModel.this;
                                pageModel3.grayTipData$delegate.setValue(pageModel3, PageModel.$$delegatedProperties[0], new GrayTipData(p16, p17, p18));
                            }
                            function12.invoke(Boolean.valueOf(booleanValue));
                            return Unit.INSTANCE;
                        }
                    });
                } else {
                    PageModel.this.loadingErrorData = new ErrorData("\u7f51\u7edc\u5f02\u5e38", "\u62c9\u53d6\u6570\u636e\u5931\u8d25", 2, "\u8fd4\u56de");
                    function1.invoke(Boolean.FALSE);
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void pullTemplateData(final Function1<? super Boolean, Unit> function1) {
        if (this.originalAppId.length() == 0) {
            this.originalAppId = getPostData().appId;
        }
        BridgeModule bridgeModule = (BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule");
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("pullTemplateData appid:");
        m3.append(getPostData().appId);
        bridgeModule.log(m3.toString());
        O3Module o3Module = getO3Module();
        e eVar = new e();
        eVar.v("appid", getPostData().appId);
        Unit unit = Unit.INSTANCE;
        o3Module.sendRequest("GetImpeachTemplate", eVar, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$pullTemplateData$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3;
                int i3;
                Object obj;
                Object obj2;
                b bVar;
                boolean z16;
                b l3;
                String str;
                boolean z17;
                b bVar2;
                e eVar4 = eVar2;
                Object obj3 = null;
                e m16 = eVar4 != null ? eVar4.m("data") : null;
                Integer valueOf = eVar4 != null ? Integer.valueOf(eVar4.j("code")) : null;
                e m17 = m16 != null ? m16.m("template") : null;
                if (m17 == null || (eVar3 = m17.m("value")) == null) {
                    eVar3 = new e();
                }
                JubaoConfig.isQuickJubao = m16 != null ? m16.f("is_one_click_impeach") : false;
                com.tencent.kuikly.core.manager.c cVar = com.tencent.kuikly.core.manager.c.f117352a;
                BridgeModule bridgeModule2 = (BridgeModule) cVar.g().acquireModule("HRBridgeModule");
                StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("IsOneClickImpeach is ");
                m18.append(JubaoConfig.isQuickJubao);
                bridgeModule2.log(m18.toString());
                e m19 = m16 != null ? m16.m("user_profile") : null;
                PageModel pageModel = PageModel.this;
                if (m19 != null) {
                    m19.f("IsXhhUser");
                }
                pageModel.getClass();
                ((BridgeModule) cVar.g().acquireModule("HRBridgeModule")).log("user_profile data is " + m19);
                PageModel pageModel2 = PageModel.this;
                b l16 = eVar3.l("proofs");
                boolean z18 = true;
                if (l16 != null) {
                    List<Object> w3 = l16.w();
                    i3 = w3.contains("msg") ? 1 : 2;
                    if (w3.contains("forceMsg")) {
                        i3 = 0;
                    }
                } else {
                    i3 = 2;
                }
                pageModel2.evidenceViewFlag = i3;
                if (PageModel.this.operatesData.isEmpty()) {
                    PageModel pageModel3 = PageModel.this;
                    ArrayList<OperateData> arrayList = new ArrayList<>();
                    b l17 = eVar3.l("newOperates");
                    if (l17 != null) {
                        int c16 = l17.c();
                        for (int i16 = 0; i16 < c16; i16++) {
                            e l18 = l17.l(i16);
                            if (l18 != null) {
                                OperateData operateData = new OperateData();
                                operateData.type = l18.j("type");
                                operateData.subType = l18.j(QCircleLpReportDc010001.KEY_SUBTYPE);
                                operateData.title = l18.p("title");
                                operateData.desc = l18.p("desc");
                                operateData.btnText = l18.p(TuxUIConstants.POP_BTN_TEXT);
                                operateData.picUrl = l18.p("picUrl");
                                operateData.jumpUrl = l18.p(WadlProxyConsts.KEY_JUMP_URL);
                                arrayList.add(operateData);
                            }
                        }
                    }
                    pageModel3.operatesData = arrayList;
                }
                final PageModel pageModel4 = PageModel.this;
                Iterator<T> it = pageModel4.operatesData.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (((OperateData) obj).subType == 5) {
                        break;
                    }
                }
                final OperateData operateData2 = (OperateData) obj;
                if (operateData2 != null) {
                    O3Module o3Module2 = pageModel4.getO3Module();
                    Function1<e, Unit> function12 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$checkFollowAccountsStatus$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:4:0x0032, code lost:
                        
                            if (r5.j("code") == 1) goto L8;
                         */
                        @Override // kotlin.jvm.functions.Function1
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(e eVar5) {
                            e eVar6 = eVar5;
                            ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).log("isFollowOfficialAccounts result:" + eVar6);
                            PageModel pageModel5 = PageModel.this;
                            boolean z19 = eVar6 != null;
                            pageModel5.isFollowAccount$delegate.setValue(pageModel5, PageModel.$$delegatedProperties[2], Boolean.valueOf(z19));
                            if (PageModel.this.isFollowAccount()) {
                                PageModel.this.operatesData.remove(operateData2);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    o3Module2.getClass();
                    e m26 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("uin", "1770946116");
                    Unit unit2 = Unit.INSTANCE;
                    o3Module2.toNative(false, "isFollowOfficialAccounts", m26.toString(), function12, false);
                }
                final PageModel pageModel5 = PageModel.this;
                Iterator<T> it5 = pageModel5.operatesData.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it5.next();
                    if (((OperateData) obj2).subType == 1) {
                        break;
                    }
                }
                final OperateData operateData3 = (OperateData) obj2;
                if (operateData3 != null) {
                    if (pageModel5.getPostData().isFriend) {
                        operateData3.subType = 6;
                        operateData3.title = "\u5220\u9664\u8be5\u597d\u53cb";
                        operateData3.btnText = "\u53bb\u5220\u9664";
                    } else {
                        O3Module o3Module3 = pageModel5.getO3Module();
                        String str2 = pageModel5.getPostData().evilUin;
                        Function1<e, Unit> function13 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$checkIsBlackList$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:11:0x0045, code lost:
                            
                                if (r0 != false) goto L14;
                             */
                            @Override // kotlin.jvm.functions.Function1
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public final Unit invoke(e eVar5) {
                                e eVar6 = eVar5;
                                ((BridgeModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("HRBridgeModule")).log("isInBlackList result:" + eVar6);
                                boolean z19 = false;
                                if (!(eVar6 != null && eVar6.k(h.f248218g, -1) == 0)) {
                                    if (eVar6 != null && eVar6.j("isBlock") == 1) {
                                        z19 = true;
                                    }
                                }
                                PageModel.this.operatesData.remove(operateData3);
                                return Unit.INSTANCE;
                            }
                        };
                        o3Module3.getClass();
                        e m27 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("eviluin", str2);
                        Unit unit3 = Unit.INSTANCE;
                        o3Module3.toNative(false, "isInBlackList", m27.toString(), function13, false);
                    }
                }
                final PageModel pageModel6 = PageModel.this;
                Iterator<T> it6 = pageModel6.operatesData.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        break;
                    }
                    Object next = it6.next();
                    if (((OperateData) next).subType == 2) {
                        obj3 = next;
                        break;
                    }
                }
                final OperateData operateData4 = (OperateData) obj3;
                if (operateData4 != null) {
                    O3Module o3Module4 = pageModel6.getO3Module();
                    String str3 = pageModel6.getPostData().groupCode;
                    Function1<e, Unit> function14 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.PageModel$checkIsTroopMember$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Code restructure failed: missing block: B:4:0x000d, code lost:
                        
                            if (r3.k("result", -1) == 1) goto L8;
                         */
                        @Override // kotlin.jvm.functions.Function1
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public final Unit invoke(e eVar5) {
                            e eVar6 = eVar5;
                            boolean z19 = eVar6 != null;
                            if (!z19) {
                                PageModel.this.operatesData.remove(operateData4);
                            }
                            return Unit.INSTANCE;
                        }
                    };
                    o3Module4.getClass();
                    e m28 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("troopUin", str3);
                    Unit unit4 = Unit.INSTANCE;
                    o3Module4.toNative(false, "isTroopMember", m28.toString(), function14, false);
                }
                ArrayList arrayList2 = new ArrayList();
                b l19 = eVar3.l("reasons");
                if (l19 != null) {
                    int c17 = l19.c();
                    int i17 = 0;
                    while (i17 < c17) {
                        ArrayList arrayList3 = new ArrayList();
                        e l26 = l19.l(i17);
                        if (l26 == null || (l3 = l26.l(ComicCancelRedPointPopItemData.JSON_KEY_TAGS)) == null) {
                            bVar = l19;
                            z16 = z18;
                        } else {
                            int c18 = l3.c();
                            int i18 = 0;
                            while (i18 < c18) {
                                e l27 = l3.l(i18);
                                if (l27 != null) {
                                    bVar2 = l19;
                                    arrayList3.add(new JubaoTypeData(l27.p("name"), Integer.valueOf(l27.j("id"))));
                                } else {
                                    bVar2 = l19;
                                }
                                i18++;
                                l19 = bVar2;
                            }
                            bVar = l19;
                            String p16 = l26.p("name");
                            if (Intrinsics.areEqual(p16, "\u5176\u4ed6")) {
                                str = "\u4ee5\u4e0a\u5185\u5bb9\u5747\u4e0d\u8d34\u5207";
                                z17 = true;
                            } else {
                                str = p16;
                                z17 = false;
                            }
                            z16 = true;
                            arrayList2.add(new JubaoReasonData(str, arrayList3, l26.k("moreEvidence", -1) == 1, z17, l26.p("description")));
                        }
                        i17++;
                        z18 = z16;
                        l19 = bVar;
                    }
                }
                if (arrayList2.isEmpty()) {
                    PageModel.this.loadingErrorData = new ErrorData("\u7f51\u7edc\u5f02\u5e38", "\u62c9\u53d6\u6570\u636e\u5931\u8d25:" + valueOf, 2, "\u8fd4\u56de");
                    function1.invoke(Boolean.FALSE);
                } else {
                    ArrayList<JubaoSelectData> arrayList4 = PageModel.this.selectData;
                    ArrayList arrayList5 = new ArrayList();
                    b l28 = eVar3.l("newSelect");
                    if (l28 != null) {
                        int c19 = l28.c();
                        for (int i19 = 0; i19 < c19; i19++) {
                            e l29 = l28.l(i19);
                            if (l29 != null) {
                                arrayList5.add(new JubaoSelectData(l29.p("appId"), l29.p("desc"), l29.p("subDesc"), l29.f("isSingleCheck"), l29.f("isFirstChoice")));
                            }
                        }
                    }
                    arrayList4.addAll(arrayList5);
                    PageModel.this.reasonsData.clear();
                    PageModel.this.reasonsData.addAll(arrayList2);
                    function1.invoke(Boolean.TRUE);
                }
                return Unit.INSTANCE;
            }
        });
    }

    public final void setEvidenceNum(int i3) {
        this.evidenceNum$delegate.setValue(this, $$delegatedProperties[1], Integer.valueOf(i3));
    }

    public final void setOperateStatus(int i3) {
        this.operateStatus$delegate.setValue(this, $$delegatedProperties[6], Integer.valueOf(i3));
    }
}
