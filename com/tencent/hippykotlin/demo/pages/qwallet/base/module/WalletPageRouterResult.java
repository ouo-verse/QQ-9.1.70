package com.tencent.hippykotlin.demo.pages.qwallet.base.module;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes33.dex */
public final class WalletPageRouterResult {
    public final e data;
    public final Integer retCode;
    public final String retMsg;

    public WalletPageRouterResult(Integer num, String str, e eVar) {
        this.retCode = num;
        this.retMsg = str;
        this.data = eVar;
    }

    public final int hashCode() {
        Integer num = this.retCode;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.retMsg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        e eVar = this.data;
        return hashCode2 + (eVar != null ? eVar.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("WalletPageRouterResult(retCode=");
        m3.append(this.retCode);
        m3.append(", retMsg=");
        m3.append(this.retMsg);
        m3.append(", data=");
        m3.append(this.data);
        m3.append(')');
        return m3.toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletPageRouterResult)) {
            return false;
        }
        WalletPageRouterResult walletPageRouterResult = (WalletPageRouterResult) obj;
        return Intrinsics.areEqual(this.retCode, walletPageRouterResult.retCode) && Intrinsics.areEqual(this.retMsg, walletPageRouterResult.retMsg) && Intrinsics.areEqual(this.data, walletPageRouterResult.data);
    }
}
