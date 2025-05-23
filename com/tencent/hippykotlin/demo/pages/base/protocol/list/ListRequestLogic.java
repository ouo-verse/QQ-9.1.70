package com.tencent.hippykotlin.demo.pages.base.protocol.list;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.detail.model.BoxType$EnumUnboxingSharedUtility;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.ISSOReqModel;
import com.tencent.hippykotlin.demo.pages.base.ISSORspModel;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes31.dex */
public class ListRequestLogic<REQ extends ISSOReqModel, RSP> implements IListRequestLogic<REQ, RSP> {
    public final String cmd;
    public final ISSORspModel<RSP> decodeModel;
    public boolean isEndMark;
    public boolean isRequesting;
    public final REQ reqModel;
    public final int nextCookieType = 2;
    public Object nextCookieMark = emptyNextCookie();

    /* JADX WARN: Multi-variable type inference failed */
    public ListRequestLogic(String str, ISSOReqModel iSSOReqModel, ISSORspModel iSSORspModel) {
        this.cmd = str;
        this.reqModel = iSSOReqModel;
        this.decodeModel = iSSORspModel;
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

    public String getCookieKey() {
        return "cookie";
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.protocol.list.IListRequestLogic
    public final boolean isEnd() {
        return this.isEndMark;
    }

    public final void reqFirstPage(Function1<? super RSP, Unit> function1, Function2<? super Integer, ? super String, Unit> function2) {
        if (this.isRequesting) {
            Utils utils = Utils.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[Info][ListReq] the page is requesting, can`t req. {cmd:");
            m3.append(this.cmd);
            m3.append('}');
            utils.logToNative(m3.toString());
            return;
        }
        this.nextCookieMark = emptyNextCookie();
        reqNextPage(function1, function2);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.protocol.list.IListRequestLogic
    public final void reqNextPage(final Function1<? super RSP, Unit> function1, final Function2<? super Integer, ? super String, Unit> function2) {
        if (this.isRequesting) {
            Utils utils = Utils.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[Info][ListReq] the page is requesting, can`t req. {cmd:");
            m3.append(this.cmd);
            m3.append('}');
            utils.logToNative(m3.toString());
            return;
        }
        e encode = this.reqModel.encode();
        encode.v(getCookieKey(), this.nextCookieMark);
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        String str = this.cmd;
        Function1<e, Unit> function12 = new Function1<e, Unit>(this) { // from class: com.tencent.hippykotlin.demo.pages.base.protocol.list.ListRequestLogic$reqNextPage$1
            public final /* synthetic */ ListRequestLogic<REQ, RSP> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                Object m16;
                e eVar2 = eVar;
                if (eVar2 != null) {
                    String q16 = eVar2.q("data", "");
                    int k3 = eVar2.k("errorCode", 0);
                    String q17 = eVar2.q("errorMsg", "");
                    if (q16.length() > 0) {
                        ListRequestLogic<REQ, RSP> listRequestLogic = this.this$0;
                        listRequestLogic.getClass();
                        e eVar3 = new e(q16);
                        Object decode = listRequestLogic.decodeModel.decode(eVar3);
                        int ordinal = BoxType$EnumUnboxingSharedUtility.ordinal(listRequestLogic.nextCookieType);
                        if (ordinal == 0) {
                            m16 = eVar3.m(listRequestLogic.getCookieKey());
                            if (m16 == null) {
                                m16 = new e();
                            }
                        } else if (ordinal == 1) {
                            m16 = eVar3.q(listRequestLogic.getCookieKey(), "");
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                        listRequestLogic.nextCookieMark = m16;
                        listRequestLogic.isEndMark = listRequestLogic.parsePageIsEnd(eVar3);
                        Utils utils2 = Utils.INSTANCE;
                        StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[Info][ListReq]req page success, {cmd:");
                        m17.append(this.this$0.cmd);
                        m17.append(" isEnd:");
                        m17.append(this.this$0.isEndMark);
                        m17.append('}');
                        utils2.logToNative(m17.toString());
                        this.this$0.getClass();
                        function1.invoke(decode);
                    } else {
                        Utils utils3 = Utils.INSTANCE;
                        StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[Error][ListReq]req page failure, {cmd:");
                        m18.append(this.this$0.cmd);
                        m18.append(" isEnd:");
                        m18.append(this.this$0.isEndMark);
                        m18.append(" code:");
                        m18.append(k3);
                        m18.append(" msg:{");
                        m18.append(q17);
                        m18.append("}}");
                        utils3.logToNative(m18.toString());
                        this.this$0.getClass();
                        function2.invoke(Integer.valueOf(k3), q17);
                    }
                } else {
                    Utils utils4 = Utils.INSTANCE;
                    StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("[Error][ListReq]req page failure, {cmd:");
                    m19.append(this.this$0.cmd);
                    m19.append(" isEnd:");
                    m19.append(this.this$0.isEndMark);
                    m19.append(" code:-1 msg:{sso channel failure}}");
                    utils4.logToNative(m19.toString());
                    this.this$0.getClass();
                    function2.invoke(-1, "sso channel failure");
                }
                this.this$0.isRequesting = false;
                return Unit.INSTANCE;
            }
        };
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.ssoRequest(str, encode, false, function12);
    }

    public boolean parsePageIsEnd(e eVar) {
        throw null;
    }
}
