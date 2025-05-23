package com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.repository.pageRequest;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes33.dex */
public final class PageRequestLogic<REQ extends ISSOModel, RSP> implements IPageRequestLogic<REQ, RSP> {
    public final String cmd;
    public boolean isDestroy;
    public boolean isEnd;
    public boolean isRequesting;
    public Object nextCookie = emptyNextCookie();
    public final int nextCookieType;
    public final REQ reqModel;
    public final ISSOModelFactory<RSP> rspFactory;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/String;TREQ;Lcom/tencent/hippykotlin/demo/pages/base/ISSOModelFactory<TRSP;>;Ljava/lang/Object;)V */
    /* JADX WARN: Multi-variable type inference failed */
    public PageRequestLogic(String str, ISSOModel iSSOModel, ISSOModelFactory iSSOModelFactory, int i3) {
        this.cmd = str;
        this.reqModel = iSSOModel;
        this.rspFactory = iSSOModelFactory;
        this.nextCookieType = i3;
    }

    public final Object emptyNextCookie() {
        int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(this.nextCookieType);
        if (ordinal == 0) {
            return new e();
        }
        if (ordinal == 1) {
            return "";
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.repository.pageRequest.IPageRequestLogic
    public final boolean isEnd() {
        return this.isEnd;
    }

    public final void reqFirstPage(Function1<? super RSP, Unit> function1, Function2<? super Integer, ? super String, Unit> function2) {
        if (this.isRequesting) {
            Utils utils = Utils.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[Info][PageReq] the page is requesting, can`t req. {cmd:");
            m3.append(this.cmd);
            m3.append('}');
            utils.logToNative(m3.toString());
            return;
        }
        this.nextCookie = emptyNextCookie();
        reqNextPage(function1, function2);
    }

    @Override // com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.repository.pageRequest.IPageRequestLogic
    public final void reqNextPage(final Function1<? super RSP, Unit> function1, final Function2<? super Integer, ? super String, Unit> function2) {
        if (this.isDestroy) {
            Utils utils = Utils.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[Info][PageReq] the page is destroy, can`t req. {cmd:");
            m3.append(this.cmd);
            m3.append('}');
            utils.logToNative(m3.toString());
            return;
        }
        if (this.isRequesting) {
            Utils utils2 = Utils.INSTANCE;
            StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[Info][PageReq] the page is requesting, can`t req. {cmd:");
            m16.append(this.cmd);
            m16.append('}');
            utils2.logToNative(m16.toString());
            return;
        }
        e encode = this.reqModel.encode();
        encode.v("cookie", this.nextCookie);
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        String str = this.cmd;
        Function1<e, Unit> function12 = new Function1<e, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.shop_biz.shop_coupon_page.my_coupon.repository.pageRequest.PageRequestLogic$reqNextPage$1
            public final /* synthetic */ PageRequestLogic<REQ, RSP> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                Object m17;
                e eVar2 = eVar;
                if (eVar2 != null) {
                    String q16 = eVar2.q("data", "");
                    int k3 = eVar2.k("errorCode", 0);
                    String q17 = eVar2.q("errorMsg", "");
                    if (q16.length() > 0) {
                        PageRequestLogic<REQ, RSP> pageRequestLogic = this.this$0;
                        pageRequestLogic.getClass();
                        e eVar3 = new e(q16);
                        Object decode = pageRequestLogic.rspFactory.decode(eVar3);
                        pageRequestLogic.isEnd = eVar3.g("is_end", false);
                        int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(pageRequestLogic.nextCookieType);
                        if (ordinal == 0) {
                            m17 = eVar3.m("cookie");
                            if (m17 == null) {
                                m17 = new e();
                            }
                        } else if (ordinal == 1) {
                            m17 = eVar3.q("cookie", "");
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        pageRequestLogic.nextCookie = m17;
                        Utils utils3 = Utils.INSTANCE;
                        StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[Info][PageReq]req page success, {cmd:");
                        m18.append(this.this$0.cmd);
                        m18.append(" isEnd:");
                        m18.append(this.this$0.isEnd);
                        m18.append('}');
                        utils3.logToNative(m18.toString());
                        if (!this.this$0.isDestroy) {
                            function1.invoke(decode);
                        }
                    } else {
                        Utils utils4 = Utils.INSTANCE;
                        StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[Error][PageReq]req page failure, {cmd:");
                        m19.append(this.this$0.cmd);
                        m19.append(" isEnd:");
                        m19.append(this.this$0.isEnd);
                        m19.append(" code:");
                        m19.append(k3);
                        m19.append(" msg:{");
                        m19.append(q17);
                        m19.append("}}");
                        utils4.logToNative(m19.toString());
                        if (!this.this$0.isDestroy) {
                            function2.invoke(Integer.valueOf(k3), q17);
                        }
                    }
                } else {
                    Utils utils5 = Utils.INSTANCE;
                    StringBuilder m26 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[Error][PageReq]req page failure, {cmd:");
                    m26.append(this.this$0.cmd);
                    m26.append(" isEnd:");
                    m26.append(this.this$0.isEnd);
                    m26.append(" code:-1 msg:{sso channel failure}}");
                    utils5.logToNative(m26.toString());
                    if (!this.this$0.isDestroy) {
                        function2.invoke(-1, "sso channel failure");
                    }
                }
                this.this$0.isRequesting = false;
                return Unit.INSTANCE;
            }
        };
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.ssoRequest(str, encode, false, function12);
    }
}
