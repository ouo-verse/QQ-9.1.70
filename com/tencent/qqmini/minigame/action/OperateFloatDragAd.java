package com.tencent.qqmini.minigame.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.FloatDragAdInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public class OperateFloatDragAd implements Action<Boolean> {
    private FloatDragAdInfo floatDragAdInfo;
    private IMiniAppContext miniAppContext;
    private String operateType;

    public static OperateFloatDragAd obtain(IMiniAppContext iMiniAppContext) {
        OperateFloatDragAd operateFloatDragAd = new OperateFloatDragAd();
        operateFloatDragAd.miniAppContext = iMiniAppContext;
        return operateFloatDragAd;
    }

    public boolean remove() {
        this.operateType = "remove";
        return ((Boolean) this.miniAppContext.performAction(this)).booleanValue();
    }

    public boolean show(FloatDragAdInfo floatDragAdInfo) {
        this.operateType = "add";
        this.floatDragAdInfo = floatDragAdInfo;
        return ((Boolean) this.miniAppContext.performAction(this)).booleanValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Boolean perform(BaseRuntime baseRuntime) {
        IPage page = baseRuntime.getPage();
        if (page == null) {
            return null;
        }
        return Boolean.valueOf(page.operateFloatDragAd(this.operateType, this.floatDragAdInfo));
    }
}
