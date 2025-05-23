package com.tencent.pts.core;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.PTSRecyclerViewAdapter;
import com.tencent.pts.utils.PTSAnimationUtil;
import com.tencent.pts.utils.PTSLog;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes22.dex */
public class PTSRootNodeRecyclerViewDelegate implements IPTSRootNodeDelegate {
    static IPatchRedirector $redirector_;
    private final String TAG;
    private PTSRecyclerViewAdapter mAdapter;
    private PTSAppInstance mAppInstance;
    private List<PTSNodeInfo> mDataList;
    private RecyclerView mRecyclerView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PTSRootNodeRecyclerViewDelegate(PTSAppInstance pTSAppInstance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) pTSAppInstance);
            return;
        }
        this.TAG = "PTSRootNodeRecyclerViewDelegate";
        this.mAppInstance = pTSAppInstance;
        this.mDataList = new ArrayList();
    }

    public void addOnScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) onScrollListener);
        } else {
            this.mRecyclerView.addOnScrollListener(onScrollListener);
        }
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public boolean animation(PTSNodeInfo pTSNodeInfo, PTSAnimationUtil.AnimationInfo animationInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) pTSNodeInfo, (Object) animationInfo)).booleanValue();
        }
        PTSLog.d("PTSRootNodeRecyclerViewDelegate", "[animation] nodeInfo = " + pTSNodeInfo);
        this.mAdapter.animation(pTSNodeInfo, animationInfo);
        return true;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public View getRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mRecyclerView;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public boolean insert(PTSNodeInfo pTSNodeInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) pTSNodeInfo, i3)).booleanValue();
        }
        PTSLog.d("PTSRootNodeRecyclerViewDelegate", "[insert] insertIndex = " + i3 + ", nodeInfo = " + pTSNodeInfo);
        this.mAdapter.insert(pTSNodeInfo, i3);
        return true;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public boolean modify(PTSNodeInfo pTSNodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) pTSNodeInfo)).booleanValue();
        }
        PTSLog.d("PTSRootNodeRecyclerViewDelegate", "[modify] nodeInfo = " + pTSNodeInfo);
        this.mAdapter.modify(pTSNodeInfo);
        return true;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public View onCreateNativeView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        RecyclerView recyclerView = new RecyclerView(this.mAppInstance.getContext());
        this.mRecyclerView = recyclerView;
        recyclerView.setHasFixedSize(true);
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(this.mAppInstance.getContext()));
        PTSRecyclerViewAdapter pTSRecyclerViewAdapter = new PTSRecyclerViewAdapter(this.mAppInstance);
        this.mAdapter = pTSRecyclerViewAdapter;
        this.mRecyclerView.setAdapter(pTSRecyclerViewAdapter);
        return this.mRecyclerView;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public void onLayoutTempPatchFinished() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            this.mAdapter.onLayoutTempPatchFinished();
        }
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public boolean refreshNodeList(List<PTSNodeInfo> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) list)).booleanValue();
        }
        this.mDataList.clear();
        if (list != null) {
            this.mDataList.addAll(list);
        }
        this.mAdapter.setData(this.mDataList);
        if (PTSLog.isDebug()) {
            PTSLog.d("PTSRootNodeRecyclerViewDelegate", "refreshNodeList, list count = " + this.mDataList.size());
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < this.mDataList.size(); i3++) {
                sb5.append("mDataList [");
                sb5.append(i3);
                sb5.append("] = ");
                sb5.append(this.mDataList.get(i3));
                sb5.append("\n");
            }
            PTSLog.d("PTSRootNodeRecyclerViewDelegate", sb5.toString());
            return true;
        }
        return true;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public boolean remove(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, i3)).booleanValue();
        }
        PTSLog.d("PTSRootNodeRecyclerViewDelegate", "[remove] nodeUniqueID = " + i3);
        this.mAdapter.remove(i3);
        return true;
    }

    @Override // com.tencent.pts.core.IPTSRootNodeDelegate
    public void setRootView(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewGroup);
        }
    }
}
