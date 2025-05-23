package com.tencent.hippykotlin.demo.pages.qwallet.base.module;

import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes33.dex */
public final class WalletPageRouterParam {
    public final e otherParam;
    public final String viewTag = "redgiftRecord";

    public WalletPageRouterParam(e eVar) {
        this.otherParam = eVar;
    }

    public final int hashCode() {
        String str = this.viewTag;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        e eVar = this.otherParam;
        return hashCode + (eVar != null ? eVar.hashCode() : 0);
    }

    public final e toJSONObject() {
        e eVar = this.otherParam;
        if (eVar != null) {
            eVar.v(HippyHeaderListViewController.VIEW_TAG, this.viewTag);
        } else {
            eVar = new e();
            String str = this.viewTag;
            if (str != null) {
                eVar.v(HippyHeaderListViewController.VIEW_TAG, str);
            }
        }
        return eVar;
    }

    public final String toString() {
        return toJSONObject().toString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletPageRouterParam)) {
            return false;
        }
        WalletPageRouterParam walletPageRouterParam = (WalletPageRouterParam) obj;
        return Intrinsics.areEqual(this.viewTag, walletPageRouterParam.viewTag) && Intrinsics.areEqual(this.otherParam, walletPageRouterParam.otherParam);
    }
}
