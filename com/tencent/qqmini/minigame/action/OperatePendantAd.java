package com.tencent.qqmini.minigame.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.PendantAdInfo;

/* loaded from: classes23.dex */
public class OperatePendantAd implements Action<Boolean> {
    private IMiniAppContext miniAppContext;
    private String operateType;
    private PendantAdInfo pendantAdInfo;

    public static OperatePendantAd obtain(IMiniAppContext iMiniAppContext) {
        OperatePendantAd operatePendantAd = new OperatePendantAd();
        operatePendantAd.miniAppContext = iMiniAppContext;
        return operatePendantAd;
    }

    public boolean remove() {
        this.operateType = "remove";
        return ((Boolean) this.miniAppContext.performAction(this)).booleanValue();
    }

    public boolean show(PendantAdInfo pendantAdInfo) {
        this.operateType = "add";
        this.pendantAdInfo = pendantAdInfo;
        return ((Boolean) this.miniAppContext.performAction(this)).booleanValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Boolean perform(BaseRuntime baseRuntime) {
        IPage page = baseRuntime.getPage();
        if (page == null) {
            return null;
        }
        return Boolean.valueOf(page.operatePendantAd(this.operateType, this.pendantAdInfo));
    }
}
