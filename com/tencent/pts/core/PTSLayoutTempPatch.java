package com.tencent.pts.core;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSAnimationUtil;
import com.tencent.pts.utils.PTSLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes22.dex */
public class PTSLayoutTempPatch {
    static IPatchRedirector $redirector_ = null;
    public static final int PTS_LAYOUT_PATCH_INSERT_CHILD = 2;
    public static final int PTS_LAYOUT_PATCH_MODIFY = 1;
    public static final int PTS_LAYOUT_PATCH_NONE = 0;
    public static final int PTS_LAYOUT_PATCH_REMOVE_CHILD = 4;
    public static final int PTS_LAYOUT_PATCH_REORDER_CHILD = 8;
    public static final String TAG = "PTSLayoutTempPatch";
    public List<PTSAnimationSet> animationNodeList;
    public int layoutPatchType;
    public List<PTSNodeInfoInsert> newNodeInfoList;
    public PTSNodeInfo nodeInfo;
    public List<Integer> removeNodeIDList;

    /* loaded from: classes22.dex */
    public static class PTSAnimationSet {
        static IPatchRedirector $redirector_;
        private PTSAnimationUtil.AnimationInfo animationInfo;
        private PTSNodeInfo nodeInfo;

        public PTSAnimationSet() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* loaded from: classes22.dex */
    public static class PTSNodeInfoInsert {
        static IPatchRedirector $redirector_;
        public int insertIndex;
        public PTSNodeInfo nodeInfo;

        public PTSNodeInfoInsert() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public PTSLayoutTempPatch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.newNodeInfoList = new ArrayList();
        this.removeNodeIDList = new ArrayList();
        this.animationNodeList = new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyLayoutTempPatchList(List<PTSLayoutTempPatch> list, PTSAppInstance pTSAppInstance) {
        PTSNodeInfo pTSNodeInfo;
        List<Integer> list2;
        List<PTSNodeInfoInsert> list3;
        if (pTSAppInstance != null && list != null && !list.isEmpty()) {
            PTSRootNode rootNode = pTSAppInstance.getRootNode();
            if (rootNode == null) {
                PTSLog.e(TAG, "[applyLayoutTempPatchList] failed, ptsRootNode is null.");
                return;
            }
            for (int i3 = 0; i3 < list.size(); i3++) {
                PTSLayoutTempPatch pTSLayoutTempPatch = list.get(i3);
                if ((pTSLayoutTempPatch.layoutPatchType & 2) > 0 && (list3 = pTSLayoutTempPatch.newNodeInfoList) != null) {
                    for (PTSNodeInfoInsert pTSNodeInfoInsert : list3) {
                        rootNode.insert(pTSNodeInfoInsert.nodeInfo, pTSNodeInfoInsert.insertIndex);
                    }
                }
                if ((pTSLayoutTempPatch.layoutPatchType & 4) > 0 && (list2 = pTSLayoutTempPatch.removeNodeIDList) != null) {
                    Iterator<Integer> it = list2.iterator();
                    while (it.hasNext()) {
                        rootNode.remove(it.next().intValue());
                    }
                }
                List<PTSAnimationSet> list4 = pTSLayoutTempPatch.animationNodeList;
                if (list4 != null && !list4.isEmpty()) {
                    for (PTSAnimationSet pTSAnimationSet : pTSLayoutTempPatch.animationNodeList) {
                        rootNode.animation(pTSAnimationSet.nodeInfo, pTSAnimationSet.animationInfo);
                    }
                } else if ((pTSLayoutTempPatch.layoutPatchType & 1) > 0 && (pTSNodeInfo = pTSLayoutTempPatch.nodeInfo) != null) {
                    rootNode.modify(pTSNodeInfo);
                }
            }
            rootNode.onLayoutTempPatchFinished();
        }
    }

    public void appendAnimation(PTSNodeInfo pTSNodeInfo, PTSAnimationUtil.AnimationInfo animationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) pTSNodeInfo, (Object) animationInfo);
            return;
        }
        PTSAnimationSet pTSAnimationSet = new PTSAnimationSet();
        pTSAnimationSet.nodeInfo = pTSNodeInfo;
        pTSAnimationSet.animationInfo = animationInfo;
        this.animationNodeList.add(pTSAnimationSet);
    }

    public void appendNewNodeInfo(PTSNodeInfo pTSNodeInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) pTSNodeInfo, i3);
            return;
        }
        PTSNodeInfoInsert pTSNodeInfoInsert = new PTSNodeInfoInsert();
        pTSNodeInfoInsert.nodeInfo = pTSNodeInfo;
        pTSNodeInfoInsert.insertIndex = i3;
        this.newNodeInfoList.add(pTSNodeInfoInsert);
    }

    public void appendRemoveNodeID(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.removeNodeIDList.add(Integer.valueOf(i3));
        }
    }

    public void setLayoutPatchType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.layoutPatchType = i3;
        }
    }

    public void setNodeInfo(PTSNodeInfo pTSNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pTSNodeInfo);
        } else {
            this.nodeInfo = pTSNodeInfo;
        }
    }
}
