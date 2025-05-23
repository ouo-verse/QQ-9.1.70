package com.tencent.pts.ui.vnode;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.pts.core.lite.PTSLiteItemViewManager;
import com.tencent.pts.ui.PTSNodeAttributeConstant;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.view.PTSScrollView;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSConstant;
import com.tencent.pts.utils.PTSLog;
import com.tencent.pts.utils.PTSValueConvertUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes22.dex */
public class PTSNodeScrollView extends PTSNodeVirtual {
    static IPatchRedirector $redirector_;

    /* loaded from: classes22.dex */
    public static class a implements PTSNodeVirtual.a {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public View buildNativeView(Context context, PTSNodeVirtual pTSNodeVirtual) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (View) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) pTSNodeVirtual);
            }
            return new PTSScrollView((PTSNodeScrollView) pTSNodeVirtual);
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public PTSNodeVirtual buildNodeVirtual(PTSAppInstance pTSAppInstance) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PTSNodeVirtual) iPatchRedirector.redirect((short) 2, (Object) this, (Object) pTSAppInstance);
            }
            return new PTSNodeScrollView(pTSAppInstance);
        }
    }

    public PTSNodeScrollView(PTSAppInstance pTSAppInstance) {
        super(pTSAppInstance, "view", PTSConstant.CUSTOM_VIEW_TYPE_SCROLL_VIEW);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pTSAppInstance);
        }
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public void addChild(PTSNodeVirtual pTSNodeVirtual) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) pTSNodeVirtual);
            return;
        }
        if (isLeafNode()) {
            PTSLog.e(this.TAG, "[addChild] failed, can not add child for leaf node, nodeInfo = \n" + getNodeInfo());
            return;
        }
        if (this.mChildren == null) {
            this.mChildren = new ArrayList();
        }
        if (pTSNodeVirtual == null) {
            PTSLog.e(this.TAG, "[addChild] failed, child is null.");
            return;
        }
        this.mChildren.add(pTSNodeVirtual);
        pTSNodeVirtual.setParent(this);
        PTSScrollView pTSScrollView = (PTSScrollView) getView();
        if (pTSScrollView != null) {
            pTSScrollView.addChild(pTSNodeVirtual.getView());
        }
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public void onParseValueFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            super.onParseValueFinished();
            ((PTSScrollView) getView()).scrollTo(0, 0);
        }
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual
    public void removeChild(PTSNodeVirtual pTSNodeVirtual) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pTSNodeVirtual);
            return;
        }
        if (isLeafNode()) {
            PTSLog.e(this.TAG, "[removeChild] failed, can not remove child for leaf node, nodeInfo = \n" + getNodeInfo());
            return;
        }
        List<PTSNodeVirtual> list = this.mChildren;
        if (list != null && pTSNodeVirtual != null) {
            list.remove(pTSNodeVirtual);
            pTSNodeVirtual.setParent(null);
            PTSScrollView pTSScrollView = (PTSScrollView) getView();
            if (pTSScrollView != null) {
                pTSScrollView.removeChild(pTSNodeVirtual.getView());
            }
        }
    }

    public void triggerItemViewExposure(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        List<PTSNodeVirtual> list = this.mChildren;
        if (list == null) {
            PTSLog.e(this.TAG, "[triggerItemViewExposure] failed, mChildren is null.");
            return;
        }
        if (i3 >= 0 && i3 < list.size()) {
            PTSNodeInfo nodeInfo = this.mChildren.get(i3).getNodeInfo();
            PTSAppInstance appInstance = getAppInstance();
            if (nodeInfo != null && appInstance != null) {
                if (PTSLog.isDebug()) {
                    PTSLog.i(this.TAG, "[triggerItemViewExposure], childIndex = " + i3);
                }
                if (appInstance.isLiteAppInstance()) {
                    HashMap<String, String> eventInfo = nodeInfo.getEventInfo();
                    String string = PTSValueConvertUtil.getString(nodeInfo.getAttributes().get(PTSNodeAttributeConstant.EVENT_TYPE_PTS_ON_SCROLL_ITEM_EXPOSURE));
                    PTSAppInstance.PTSLiteAppInstance pTSLiteAppInstance = (PTSAppInstance.PTSLiteAppInstance) appInstance;
                    IPTSLiteEventListener liteEventListener = pTSLiteAppInstance.getLiteEventListener();
                    PTSLiteItemViewManager liteItemViewManager = pTSLiteAppInstance.getLiteItemViewManager();
                    if (liteEventListener != null) {
                        pTSLiteAppInstance.triggerLiteEvent(5, string, eventInfo, ((PTSScrollView) getView()).getChildAt(i3), appInstance.getPtsComposer());
                        return;
                    } else {
                        if (liteItemViewManager != null) {
                            liteItemViewManager.triggerLiteEvent(5, string, eventInfo, ((PTSScrollView) getView()).getChildAt(i3));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            PTSLog.e(this.TAG, "[triggerItemViewExposure] failed, nodeInfo is null or ptsAppInstance is null.");
            return;
        }
        PTSLog.e(this.TAG, "[triggerItemViewExposure] failed, index is not valid.");
    }
}
