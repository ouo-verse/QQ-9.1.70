package com.tencent.pts.core.itemview;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.IPTSRootNodeDelegate;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSAnimationUtil;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes22.dex */
public class PTSRootNodeItemViewDelegate implements IPTSRootNodeDelegate {
    static IPatchRedirector $redirector_;
    public final String TAG;
    private PTSAppInstance mAppInstance;
    private HashMap<String, PTSNodeInfo> mIDToNodeInfoMap;
    private PTSNodeInfo mRootNodeInfo;
    private PTSItemView mRootView;

    public PTSRootNodeItemViewDelegate(PTSAppInstance pTSAppInstance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pTSAppInstance);
            return;
        }
        this.TAG = "PTSRootNodeItemViewDelegate";
        this.mAppInstance = pTSAppInstance;
        this.mIDToNodeInfoMap = new HashMap<>();
    }

    private void addToNodeInfoMap(PTSNodeInfo pTSNodeInfo) {
        if (pTSNodeInfo == null) {
            return;
        }
        this.mIDToNodeInfoMap.put(pTSNodeInfo.getUniqueID(), pTSNodeInfo);
    }

    private void clearNodeInfoMap() {
        this.mIDToNodeInfoMap.clear();
    }

    private PTSNodeInfo getNodeInfoByID(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.mIDToNodeInfoMap.get(str);
    }

    private boolean isSameAppInstance() {
        PTSAppInstance pTSAppInstance;
        PTSItemView pTSItemView = this.mRootView;
        if (pTSItemView == null || (pTSAppInstance = this.mAppInstance) == null || pTSAppInstance != pTSItemView.getAppInstance()) {
            return false;
        }
        return true;
    }

    private void removeFromNodeInfoMap(PTSNodeInfo pTSNodeInfo) {
        if (pTSNodeInfo == null) {
            return;
        }
        this.mIDToNodeInfoMap.remove(pTSNodeInfo.getUniqueID());
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public boolean animation(PTSNodeInfo pTSNodeInfo, PTSAnimationUtil.AnimationInfo animationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) pTSNodeInfo, (Object) animationInfo)).booleanValue();
        }
        return true;
    }

    public PTSNodeInfo getRootNodeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PTSNodeInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mRootNodeInfo;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public View getRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mRootView;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public boolean insert(PTSNodeInfo pTSNodeInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) pTSNodeInfo, i3)).booleanValue();
        }
        if (PTSLog.isDebug()) {
            PTSLog.d("PTSRootNodeItemViewDelegate", "[insert] insertIndex = " + i3 + ", nodeInfo = " + pTSNodeInfo);
        }
        if (pTSNodeInfo == null) {
            return false;
        }
        if (pTSNodeInfo.isRootNode()) {
            this.mRootNodeInfo = pTSNodeInfo;
            clearNodeInfoMap();
        } else if (pTSNodeInfo.hasParent()) {
            PTSNodeInfo nodeInfoByID = getNodeInfoByID(pTSNodeInfo.getParentID());
            if (nodeInfoByID != null) {
                nodeInfoByID.addChild(i3, pTSNodeInfo);
            } else {
                PTSLog.e("PTSRootNodeItemViewDelegate", "[insert] error, can not find parent nodeInfo, nodeInfo = " + pTSNodeInfo);
            }
        } else {
            PTSLog.e("PTSRootNodeItemViewDelegate", "[insert] error, index = " + i3 + ", nodeInfo = \n" + pTSNodeInfo);
        }
        addToNodeInfoMap(pTSNodeInfo);
        return true;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public boolean modify(PTSNodeInfo pTSNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) pTSNodeInfo)).booleanValue();
        }
        if (PTSLog.isDebug()) {
            PTSLog.d("PTSRootNodeItemViewDelegate", "[modify] nodeInfo = " + pTSNodeInfo);
        }
        int i3 = 0;
        if (pTSNodeInfo == null) {
            return false;
        }
        if (pTSNodeInfo.isRootNode()) {
            PTSNodeInfo pTSNodeInfo2 = this.mRootNodeInfo;
            if (pTSNodeInfo2 != null) {
                pTSNodeInfo.addChildren(pTSNodeInfo2.getChildren());
            }
            this.mRootNodeInfo = pTSNodeInfo;
        } else if (pTSNodeInfo.hasParent()) {
            PTSNodeInfo nodeInfoByID = getNodeInfoByID(pTSNodeInfo.getParentID());
            if (nodeInfoByID != null) {
                List<PTSNodeInfo> children = nodeInfoByID.getChildren();
                while (true) {
                    if (i3 >= children.size()) {
                        break;
                    }
                    PTSNodeInfo pTSNodeInfo3 = children.get(i3);
                    if (pTSNodeInfo3.equals(pTSNodeInfo)) {
                        pTSNodeInfo.addChildren(pTSNodeInfo3.getChildren());
                        nodeInfoByID.setChild(i3, pTSNodeInfo);
                        break;
                    }
                    i3++;
                }
            } else {
                PTSLog.e("PTSRootNodeItemViewDelegate", "[modify] error, can not find parent nodeInfo, nodeInfo = " + pTSNodeInfo);
            }
        } else {
            PTSLog.e("PTSRootNodeItemViewDelegate", "[modify] error, nodeInfo does not have parent, nodeInfo = " + pTSNodeInfo);
        }
        addToNodeInfoMap(pTSNodeInfo);
        return true;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public View onCreateNativeView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public void onLayoutTempPatchFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else if (isSameAppInstance()) {
            this.mRootView.bindData(this.mAppInstance);
        } else {
            PTSLog.i("PTSRootNodeItemViewDelegate", "[onLayoutTempPatchFinished], do not update, not the valid appInstance or the rootView is null.");
        }
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public boolean refreshNodeList(List<PTSNodeInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) list)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public boolean remove(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        PTSNodeInfo nodeInfoByID = getNodeInfoByID(String.valueOf(i3));
        if (PTSLog.isDebug()) {
            PTSLog.d("PTSRootNodeItemViewDelegate", "[remove] nodeUniqueID = " + i3 + ", nodeInfo = " + nodeInfoByID);
        }
        if (nodeInfoByID == null) {
            PTSLog.e("PTSRootNodeItemViewDelegate", "[remove] nodeInfo does not exists, nodeUniqueID = " + i3);
            return false;
        }
        if (nodeInfoByID.isRootNode()) {
            this.mRootNodeInfo = null;
            clearNodeInfoMap();
        } else if (nodeInfoByID.hasParent()) {
            PTSNodeInfo nodeInfoByID2 = getNodeInfoByID(nodeInfoByID.getParentID());
            if (nodeInfoByID2 != null) {
                nodeInfoByID2.removeChild(nodeInfoByID);
            } else {
                PTSLog.e("PTSRootNodeItemViewDelegate", "[remove] error, can not find parent nodeInfo, nodeUniqueID = " + i3);
            }
        } else {
            PTSLog.e("PTSRootNodeItemViewDelegate", "[remove] error, nodeUniqueID = " + i3);
        }
        removeFromNodeInfoMap(nodeInfoByID);
        return true;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public void setRootView(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup);
        } else if (viewGroup instanceof PTSItemView) {
            this.mRootView = (PTSItemView) viewGroup;
        }
    }
}
