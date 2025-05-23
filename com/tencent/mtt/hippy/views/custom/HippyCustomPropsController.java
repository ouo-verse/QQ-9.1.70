package com.tencent.mtt.hippy.views.custom;

import android.content.Context;
import android.view.View;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.HippyInstanceContext;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.uimanager.HippyViewController;
import com.tencent.mtt.hippy.uimanager.RenderNode;

@HippyController(name = HippyCustomPropsController.CLASS_NAME)
/* loaded from: classes20.dex */
public class HippyCustomPropsController extends HippyViewController {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String CLASS_NAME = "CustomProps";
    public static final String DT_EBLID = "dt_elementBizLeafIdentifier";

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return null;
    }

    protected void onSetDTElementBizLeafIdentifier(View view) {
        HippyEngineContext engineContext;
        RenderNode renderNode;
        if (view == null) {
            return;
        }
        Context context = view.getContext();
        if ((context instanceof HippyInstanceContext) && (engineContext = ((HippyInstanceContext) context).getEngineContext()) != null && (renderNode = engineContext.getRenderManager().getRenderNode(view.getId())) != null) {
            renderNode.mHasSetDteblId = true;
        }
    }
}
