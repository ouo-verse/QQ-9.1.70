package com.tencent.pts.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeView;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSAnimationUtil;
import com.tencent.pts.utils.PTSLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes22.dex */
public class PTSRecyclerViewAdapter extends RecyclerView.Adapter<PTSViewHolder> {
    static IPatchRedirector $redirector_;
    private final String TAG;
    private PTSAppInstance mAppInstance;
    private List<PTSNodeInfo> mData;
    private HashMap<String, PTSNodeInfo> mUniqueIDToNodeInfoMap;
    private SparseArray<PTSNodeInfo> mViewTypeToNodeInfoMap;

    public PTSRecyclerViewAdapter(PTSAppInstance pTSAppInstance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pTSAppInstance);
            return;
        }
        this.TAG = "PTSRecyclerViewAdapter";
        this.mData = new ArrayList();
        this.mViewTypeToNodeInfoMap = new SparseArray<>();
        this.mUniqueIDToNodeInfoMap = new HashMap<>();
        this.mAppInstance = pTSAppInstance;
    }

    private void addIDToNodeInfoMap(PTSNodeInfo pTSNodeInfo) {
        if (pTSNodeInfo != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(pTSNodeInfo);
            while (!linkedList.isEmpty()) {
                PTSNodeInfo pTSNodeInfo2 = (PTSNodeInfo) linkedList.remove();
                this.mUniqueIDToNodeInfoMap.put(pTSNodeInfo2.getUniqueID(), pTSNodeInfo2);
                if (pTSNodeInfo2.hasChildren()) {
                    linkedList.addAll(pTSNodeInfo2.getChildren());
                }
            }
            return;
        }
        PTSLog.i("PTSRecyclerViewAdapter", "[addIDToNodeInfoMap], nodeInfo is null.");
    }

    private void bindNodeInfo(PTSViewHolder pTSViewHolder, PTSNodeInfo pTSNodeInfo, PTSAppInstance pTSAppInstance) {
        PTSNodeFactory.bindData(pTSAppInstance, pTSNodeInfo, pTSViewHolder.viewIdToNodeListMap);
    }

    private PTSNodeInfo getNodeInfoByID(String str) {
        return this.mUniqueIDToNodeInfoMap.get(str);
    }

    private void removeIDToNodeInfoMap(PTSNodeInfo pTSNodeInfo) {
        if (pTSNodeInfo != null) {
            LinkedList linkedList = new LinkedList();
            linkedList.add(pTSNodeInfo);
            while (!linkedList.isEmpty()) {
                PTSNodeInfo pTSNodeInfo2 = (PTSNodeInfo) linkedList.remove();
                this.mUniqueIDToNodeInfoMap.remove(pTSNodeInfo2.getUniqueID());
                if (pTSNodeInfo2.hasChildren()) {
                    linkedList.addAll(pTSNodeInfo2.getChildren());
                }
            }
            return;
        }
        PTSLog.i("PTSRecyclerViewAdapter", "[removeIDToNodeInfoMap], nodeInfo is null.");
    }

    private void saveUniqueIDToNodeInfoMap(List<PTSNodeInfo> list) {
        if (list != null && !list.isEmpty()) {
            Iterator<PTSNodeInfo> it = list.iterator();
            while (it.hasNext()) {
                addIDToNodeInfoMap(it.next());
            }
        }
    }

    public void animation(PTSNodeInfo pTSNodeInfo, PTSAnimationUtil.AnimationInfo animationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) pTSNodeInfo, (Object) animationInfo);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        List<PTSNodeInfo> list = this.mData;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, i3)).intValue();
        }
        PTSNodeInfo pTSNodeInfo = this.mData.get(i3);
        try {
            size = Integer.valueOf(pTSNodeInfo.getAttributes().getPTSCellType()).intValue();
        } catch (NumberFormatException unused) {
            size = i3 + this.mData.size();
        }
        if (this.mViewTypeToNodeInfoMap.get(size) == null) {
            this.mViewTypeToNodeInfoMap.put(size, pTSNodeInfo);
        }
        return size;
    }

    public void insert(PTSNodeInfo pTSNodeInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) pTSNodeInfo, i3);
            return;
        }
        PTSNodeInfo nodeInfoByID = getNodeInfoByID(pTSNodeInfo.getParentID());
        if (nodeInfoByID != null) {
            nodeInfoByID.addChild(pTSNodeInfo);
        } else if (i3 > this.mData.size()) {
            PTSLog.e("PTSRecyclerViewAdapter", "[insert] insertIndex error, insertIndex = " + i3);
            this.mData.add(pTSNodeInfo);
        } else {
            this.mData.add(i3, pTSNodeInfo);
        }
        addIDToNodeInfoMap(pTSNodeInfo);
    }

    public void modify(PTSNodeInfo pTSNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) pTSNodeInfo);
            return;
        }
        PTSNodeInfo nodeInfoByID = getNodeInfoByID(pTSNodeInfo.getParentID());
        int i3 = 0;
        if (nodeInfoByID != null) {
            List<PTSNodeInfo> children = nodeInfoByID.getChildren();
            while (i3 < children.size()) {
                PTSNodeInfo pTSNodeInfo2 = children.get(i3);
                if (pTSNodeInfo2.equals(pTSNodeInfo)) {
                    pTSNodeInfo.addChildren(pTSNodeInfo2.getChildren());
                    nodeInfoByID.setChild(i3, pTSNodeInfo);
                    addIDToNodeInfoMap(pTSNodeInfo);
                    PTSLog.d("PTSRecyclerViewAdapter", "[modify] update child.");
                    return;
                }
                i3++;
            }
            return;
        }
        while (i3 < this.mData.size()) {
            PTSNodeInfo pTSNodeInfo3 = this.mData.get(i3);
            if (pTSNodeInfo3.equals(pTSNodeInfo)) {
                pTSNodeInfo.addChildren(pTSNodeInfo3.getChildren());
                this.mData.set(i3, pTSNodeInfo);
                addIDToNodeInfoMap(pTSNodeInfo);
                PTSLog.d("PTSRecyclerViewAdapter", "[modify] update mData child.");
                return;
            }
            i3++;
        }
    }

    public void onLayoutTempPatchFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            notifyDataSetChanged();
        }
    }

    public void remove(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        PTSNodeInfo nodeInfoByID = getNodeInfoByID(String.valueOf(i3));
        if (nodeInfoByID != null) {
            PTSNodeInfo nodeInfoByID2 = getNodeInfoByID(nodeInfoByID.getParentID());
            if (nodeInfoByID2 != null) {
                nodeInfoByID2.removeChild(nodeInfoByID);
            } else {
                this.mData.remove(nodeInfoByID);
            }
            removeIDToNodeInfoMap(nodeInfoByID);
        }
    }

    public void setData(List<PTSNodeInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        this.mData.clear();
        this.mData.addAll(list);
        notifyDataSetChanged();
        saveUniqueIDToNodeInfoMap(list);
    }

    /* loaded from: classes22.dex */
    public static class PTSViewHolder extends RecyclerView.ViewHolder {
        static IPatchRedirector $redirector_;
        private HashMap<String, List<PTSNodeVirtual>> viewIdToNodeListMap;

        PTSViewHolder(PTSNodeVirtual pTSNodeVirtual, HashMap<String, List<PTSNodeVirtual>> hashMap) {
            super(pTSNodeVirtual.getView());
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.viewIdToNodeListMap = hashMap;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) pTSNodeVirtual, (Object) hashMap);
            }
        }

        PTSViewHolder(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull PTSViewHolder pTSViewHolder, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            PTSNodeInfo pTSNodeInfo = this.mData.get(i3);
            bindNodeInfo(pTSViewHolder, pTSNodeInfo, this.mAppInstance);
            PTSLog.d("PTSRecyclerViewAdapter", "[onBindViewHolder] position = " + i3 + ", nodeInfo = " + pTSNodeInfo);
        } else {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) pTSViewHolder, i3);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(pTSViewHolder, i3, getItemId(i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // android.support.v7.widget.RecyclerView.Adapter
    @NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PTSViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        PTSViewHolder pTSViewHolder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (PTSViewHolder) iPatchRedirector.redirect((short) 4, (Object) this, (Object) viewGroup, i3);
        }
        PTSNodeInfo pTSNodeInfo = this.mViewTypeToNodeInfoMap.get(i3);
        if (pTSNodeInfo == null) {
            PTSLog.e("PTSRecyclerViewAdapter", "[onCreateViewHolder], no this viewType.");
            if (PTSLog.isDebug()) {
                throw new IllegalArgumentException("[onCreateViewHolder], no this viewType.");
            }
        }
        HashMap hashMap = new HashMap();
        PTSNodeVirtual buildVirtualNodeBFS = PTSNodeFactory.buildVirtualNodeBFS(pTSNodeInfo, this.mAppInstance, hashMap);
        if (buildVirtualNodeBFS == null) {
            PTSLog.e("PTSRecyclerViewAdapter", "[onCreateViewHolder], create null parent node.");
            if (!PTSLog.isDebug()) {
                buildVirtualNodeBFS = new PTSNodeView(this.mAppInstance);
            } else {
                throw new IllegalArgumentException("[onCreateViewHolder], create null parent node.");
            }
        }
        try {
            pTSViewHolder = new PTSViewHolder(buildVirtualNodeBFS, hashMap);
        } catch (IllegalArgumentException e16) {
            PTSLog.e("PTSRecyclerViewAdapter", "[onCreateViewHolder], viewType = " + i3 + ", e = " + e16);
            pTSViewHolder = null;
            if (pTSViewHolder != null) {
            }
        } catch (Exception e17) {
            PTSLog.e("PTSRecyclerViewAdapter", "[onCreateViewHolder], viewType = " + i3 + ", e = " + e17);
            pTSViewHolder = null;
            if (pTSViewHolder != null) {
            }
        }
        if (pTSViewHolder != null) {
            return pTSViewHolder;
        }
        FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
        frameLayout.setVisibility(8);
        PTSViewHolder pTSViewHolder2 = new PTSViewHolder(frameLayout);
        PTSLog.i("PTSRecyclerViewAdapter", "[onCreateViewHolder], use empty container.");
        return pTSViewHolder2;
    }
}
