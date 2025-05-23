package com.tencent.mtt.hippy.views.modal;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyController;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.uimanager.HippyGroupController;
import com.tencent.mtt.hippy.views.modal.HippyModalHostView;

/* compiled from: P */
@HippyController(name = HippyModalHostManager.HIPPY_CLASS)
/* loaded from: classes20.dex */
public class HippyModalHostManager extends HippyGroupController<HippyModalHostView> {
    public static final String HIPPY_CLASS = "Modal";

    protected HippyModalHostView createModalHostView(Context context) {
        return new HippyModalHostView(context);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public StyleNode createNode(boolean z16) {
        return new ModalStyleNode();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    protected View createViewImpl(Context context) {
        final HippyModalHostView createModalHostView = createModalHostView(context);
        createModalHostView.setOnRequestCloseListener(new HippyModalHostView.OnRequestCloseListener() { // from class: com.tencent.mtt.hippy.views.modal.HippyModalHostManager.1
            @Override // com.tencent.mtt.hippy.views.modal.HippyModalHostView.OnRequestCloseListener
            public void onRequestClose(DialogInterface dialogInterface) {
                new RequestCloseEvent().send(createModalHostView, null);
            }
        });
        createModalHostView.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.mtt.hippy.views.modal.HippyModalHostManager.2
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                new ShowEvent().send(createModalHostView, null);
            }
        });
        return createModalHostView;
    }

    @HippyControllerProps(defaultString = "none", defaultType = HippyControllerProps.STRING, name = "animationType")
    public void setAnimationType(HippyModalHostView hippyModalHostView, String str) {
        hippyModalHostView.setAnimationType(str);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "immersionStatusBar")
    public void setEnterImmersionStatusBar(HippyModalHostView hippyModalHostView, boolean z16) {
        hippyModalHostView.setEnterImmersionStatusBar(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "darkStatusBarText")
    public void setImmersionStatusBarTextDarkColor(HippyModalHostView hippyModalHostView, boolean z16) {
        hippyModalHostView.setImmersionStatusBarTextDarkColor(z16);
    }

    @HippyControllerProps(defaultType = HippyControllerProps.BOOLEAN, name = "transparent")
    public void setTransparent(HippyModalHostView hippyModalHostView, boolean z16) {
        hippyModalHostView.setTransparent(z16);
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onAfterUpdateProps(HippyModalHostView hippyModalHostView) {
        super.onAfterUpdateProps((HippyModalHostManager) hippyModalHostView);
        hippyModalHostView.showOrUpdate();
    }

    @Override // com.tencent.mtt.hippy.uimanager.HippyViewController
    public void onViewDestroy(HippyModalHostView hippyModalHostView) {
        super.onViewDestroy((HippyModalHostManager) hippyModalHostView);
        hippyModalHostView.onInstanceDestroy(hippyModalHostView.getId());
    }
}
