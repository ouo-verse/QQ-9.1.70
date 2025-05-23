package com.tencent.qqmini.minigame.action;

import android.view.View;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class OperateCustomButton implements Action<Boolean> {
    public static final String OPERATE_CREATE = "create";
    public static final String OPERATE_DESTROY = "destroy";
    public static final String OPERATE_HIDE = "hide";
    public static final String OPERATE_SHOW = "show";
    public static final String OPERATE_UPDATE = "update";
    private long componentId;
    private JSONObject jsonParam;
    private IMiniAppContext miniAppContext;
    private View.OnClickListener onClickListener;
    private String operateType;

    public static OperateCustomButton obtain(IMiniAppContext iMiniAppContext) {
        OperateCustomButton operateCustomButton = new OperateCustomButton();
        operateCustomButton.miniAppContext = iMiniAppContext;
        return operateCustomButton;
    }

    public boolean operate(String str, long j3, JSONObject jSONObject, View.OnClickListener onClickListener) {
        this.operateType = str;
        this.componentId = j3;
        this.jsonParam = jSONObject;
        this.onClickListener = onClickListener;
        return ((Boolean) this.miniAppContext.performAction(this)).booleanValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public Boolean perform(BaseRuntime baseRuntime) {
        IPage page = baseRuntime.getPage();
        if (page == null) {
            return null;
        }
        return Boolean.valueOf(page.operateCustomButton(this.operateType, this.componentId, this.jsonParam, this.onClickListener));
    }
}
