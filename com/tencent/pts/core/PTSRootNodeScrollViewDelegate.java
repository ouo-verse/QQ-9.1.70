package com.tencent.pts.core;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSAnimationUtil;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes22.dex */
public class PTSRootNodeScrollViewDelegate implements IPTSRootNodeDelegate {
    static IPatchRedirector $redirector_;
    private final String TAG;
    private PTSAppInstance mAppInstance;
    private HashMap<String, PTSNodeVirtual> mNodeMap;
    private ScrollView mScrollView;

    PTSRootNodeScrollViewDelegate(PTSAppInstance pTSAppInstance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pTSAppInstance);
            return;
        }
        this.TAG = "PTSRootNodeScrollViewDelegate";
        this.mNodeMap = new HashMap<>();
        this.mAppInstance = pTSAppInstance;
    }

    private void clearNodeMap() {
        if (this.mScrollView.getChildCount() > 0) {
            this.mScrollView.removeAllViews();
        }
    }

    private PTSNodeVirtual getNodeVirtualByID(String str) {
        return this.mNodeMap.get(str);
    }

    private void putNodeIntoMap(PTSNodeInfo pTSNodeInfo, PTSNodeVirtual pTSNodeVirtual) {
        this.mNodeMap.put(pTSNodeInfo.getUniqueID(), pTSNodeVirtual);
    }

    private void removeNodeFromMap(PTSNodeInfo pTSNodeInfo) {
        this.mNodeMap.remove(pTSNodeInfo.getUniqueID());
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public boolean animation(PTSNodeInfo pTSNodeInfo, PTSAnimationUtil.AnimationInfo animationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) pTSNodeInfo, (Object) animationInfo)).booleanValue();
        }
        PTSNodeVirtual nodeVirtualByID = getNodeVirtualByID(pTSNodeInfo.getUniqueID());
        if (nodeVirtualByID != null) {
            PTSAnimationUtil.playAnimation(animationInfo, nodeVirtualByID, nodeVirtualByID.getNodeInfo(), pTSNodeInfo);
            return true;
        }
        return false;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public View getRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mScrollView;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public boolean insert(PTSNodeInfo pTSNodeInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) pTSNodeInfo, i3)).booleanValue();
        }
        PTSNodeVirtual buildVirtualNode = PTSNodeFactory.buildVirtualNode(pTSNodeInfo, this.mAppInstance);
        boolean z16 = true;
        if (pTSNodeInfo.isRootNode()) {
            clearNodeMap();
            this.mScrollView.addView(buildVirtualNode.getView());
        } else if (pTSNodeInfo.hasParent()) {
            getNodeVirtualByID(pTSNodeInfo.getParentID()).addChild(buildVirtualNode);
        } else if (!PTSLog.isDebug()) {
            z16 = false;
        } else {
            PTSLog.e("PTSRootNodeScrollViewDelegate", "insert exception, nodeInfo = \n" + pTSNodeInfo);
            throw new IllegalArgumentException("PTSRootNode insert exception, the node is not root node or has any parent node.");
        }
        putNodeIntoMap(pTSNodeInfo, buildVirtualNode);
        PTSLog.i("PTSRootNodeScrollViewDelegate", "insert node, opRes = " + z16 + ", nodeInfo = \n" + pTSNodeInfo);
        return z16;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public boolean modify(PTSNodeInfo pTSNodeInfo) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) pTSNodeInfo)).booleanValue();
        }
        PTSNodeVirtual nodeVirtualByID = getNodeVirtualByID(pTSNodeInfo.getUniqueID());
        if (nodeVirtualByID != null) {
            PTSLog.i("PTSRootNodeScrollViewDelegate", "modify node, \n old nodeInfo = \n" + nodeVirtualByID.getNodeInfo() + "\n new nodeInfo = \n" + pTSNodeInfo);
            nodeVirtualByID.bindNodeInfo(pTSNodeInfo);
            z16 = true;
        } else {
            z16 = false;
        }
        PTSLog.i("PTSRootNodeScrollViewDelegate", "modify node, opRes = " + z16);
        return z16;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public View onCreateNativeView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        ScrollView scrollView = new ScrollView(this.mAppInstance.getContext());
        this.mScrollView = scrollView;
        return scrollView;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public void onLayoutTempPatchFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        }
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public boolean refreshNodeList(List<PTSNodeInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) list)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public boolean remove(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        PTSNodeVirtual nodeVirtualByID = getNodeVirtualByID(String.valueOf(i3));
        PTSNodeInfo nodeInfo = nodeVirtualByID.getNodeInfo();
        boolean z16 = true;
        if (nodeInfo.isRootNode()) {
            this.mScrollView.removeView(nodeVirtualByID.getView());
        } else {
            if (nodeInfo.hasParent()) {
                PTSNodeVirtual parent = nodeVirtualByID.getParent();
                if (parent != null) {
                    parent.removeChild(nodeVirtualByID);
                }
            } else if (PTSLog.isDebug()) {
                PTSLog.e("PTSRootNodeScrollViewDelegate", "remove exception, nodeInfo = \n" + nodeInfo);
                throw new IllegalArgumentException("PTSRootNode remove exception, the node is not root node or has any parent node.");
            }
            z16 = false;
        }
        removeNodeFromMap(nodeInfo);
        PTSLog.i("PTSRootNodeScrollViewDelegate", "remove node, opRes = " + z16 + ", new nodeInfo = \n" + nodeInfo);
        return z16;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public void setRootView(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup);
        }
    }
}
