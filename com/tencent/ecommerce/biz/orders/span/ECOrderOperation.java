package com.tencent.ecommerce.biz.orders.span;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/span/ECOrderOperation;", "", "meanings", "", "(Ljava/lang/String;ILjava/lang/String;)V", "CheckAddressReachable", "CalculateOrderPrice", "SubmitOrder", "OrderSubmitDetail", "CheckOrderUnPaid", "CheckLottery", "OrderVerification", "CancelOrder", "PayOrder", "UpdateAddress", "ConfirmReceive", "DelayReceive", "WriteComment", "BuyAgain", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public enum ECOrderOperation {
    CheckAddressReachable("\u6821\u9a8c\u5730\u5740\u662f\u5426\u53ef\u8fbe"),
    CalculateOrderPrice("\u8ba1\u7b97\u4ef7\u683c"),
    SubmitOrder("\u63d0\u4ea4\u8ba2\u5355"),
    OrderSubmitDetail("\u8ba2\u5355\u63d0\u4ea4\u8be6\u60c5"),
    CheckOrderUnPaid("\u68c0\u67e5\u652f\u4ed8\u72b6\u6001"),
    CheckLottery("\u76f2\u76d2\u6d3b\u52a8\u5f00\u5956"),
    OrderVerification("\u4eba\u673a\u6821\u9a8c"),
    CancelOrder("\u53d6\u6d88\u8ba2\u5355"),
    PayOrder("\u652f\u4ed8\u8ba2\u5355"),
    UpdateAddress("\u66f4\u65b0\u5730\u5740"),
    ConfirmReceive("\u786e\u8ba4\u6536\u8d27"),
    DelayReceive("\u5ef6\u957f\u6536\u8d27"),
    WriteComment("\u8bc4\u4ef7\u8ba2\u5355"),
    BuyAgain("\u518d\u6b21\u8d2d\u4e70");

    public final String meanings;

    ECOrderOperation(String str) {
        this.meanings = str;
    }
}
