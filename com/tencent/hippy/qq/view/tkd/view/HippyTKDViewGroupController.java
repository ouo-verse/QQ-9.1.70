package com.tencent.hippy.qq.view.tkd.view;

import android.content.Context;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.common.HippyTKDCommonBorderHandler;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.view.HippyViewGroup;
import com.tencent.mtt.hippy.views.view.HippyViewGroupController;

/* compiled from: P */
@HippyController(name = "View")
/* loaded from: classes7.dex */
public class HippyTKDViewGroupController extends HippyViewGroupController {
    private static final String PROP_NAME_DISABLE_EXTERNAL_SCROLL = "disableExternalScroll";

    @Override // com.tencent.mtt.hippy.views.view.HippyViewGroupController, com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        return new HippyTKDViewGroup(context);
    }

    @HippyControllerProps(defaultNumber = 0.0d, defaultType = "number", name = PROP_NAME_DISABLE_EXTERNAL_SCROLL)
    public void disableExternalScroll(final HippyViewGroup hippyViewGroup, final int i3) {
        hippyViewGroup.post(new Runnable() { // from class: com.tencent.hippy.qq.view.tkd.view.HippyTKDViewGroupController.1
            @Override // java.lang.Runnable
            public void run() {
                HippyViewGroup hippyViewGroup2 = hippyViewGroup;
                if (hippyViewGroup2 instanceof HippyTKDViewGroup) {
                    ((HippyTKDViewGroup) hippyViewGroup2).setDisableExternalScroll(i3);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    @HippyControllerProps(name = NodeProps.CUSTOM_PROP)
    public void setCustomProp(HippyViewGroup hippyViewGroup, String str, Object obj) {
        if (hippyViewGroup instanceof HippyTKDCommonBorderHandler.HippyQBCommonBorder) {
            HippyTKDCommonBorderHandler.handleCommonBorderColor((HippyTKDCommonBorderHandler.HippyQBCommonBorder) hippyViewGroup, str, obj);
        }
    }
}
