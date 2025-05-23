package com.tencent.pts.core;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.itemview.PTSRootNodeItemViewDelegate;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.utils.PTSAnimationUtil;
import com.tencent.pts.utils.PTSLog;
import java.util.List;

/* loaded from: classes22.dex */
public class PTSRootNode {
    static IPatchRedirector $redirector_ = null;
    public static final int ROOT_NODE_TYPE_ITEM_VIEW = 1;
    public static final int ROOT_NODE_TYPE_RECYCLER_VIEW = 0;
    private final String TAG;
    private IPTSRootNodeDelegate mDelegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PTSRootNode(PTSAppInstance pTSAppInstance, ViewGroup viewGroup, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, pTSAppInstance, viewGroup, Integer.valueOf(i3));
            return;
        }
        this.TAG = getClass().getSimpleName();
        initDelegate(pTSAppInstance, i3);
        init(viewGroup, i3);
    }

    private void init(ViewGroup viewGroup, int i3) {
        if (i3 == 0) {
            View onCreateNativeView = this.mDelegate.onCreateNativeView();
            if (viewGroup == null) {
                PTSLog.i(this.TAG, "[init], rootView is null.");
                return;
            } else if (onCreateNativeView == null) {
                PTSLog.i(this.TAG, "[init], nativeRootView is null.");
                return;
            } else {
                viewGroup.addView(onCreateNativeView, new ViewGroup.LayoutParams(-1, -1));
                return;
            }
        }
        if (i3 == 1) {
            this.mDelegate.setRootView(viewGroup);
        }
    }

    private void initDelegate(PTSAppInstance pTSAppInstance, int i3) {
        if (i3 == 0) {
            this.mDelegate = new PTSRootNodeRecyclerViewDelegate(pTSAppInstance);
        } else if (i3 == 1) {
            this.mDelegate = new PTSRootNodeItemViewDelegate(pTSAppInstance);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addOnRecyclerViewScrollListener(RecyclerView.OnScrollListener onScrollListener) {
        IPTSRootNodeDelegate iPTSRootNodeDelegate = this.mDelegate;
        if (iPTSRootNodeDelegate instanceof PTSRootNodeRecyclerViewDelegate) {
            ((PTSRootNodeRecyclerViewDelegate) iPTSRootNodeDelegate).addOnScrollListener(onScrollListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean animation(PTSNodeInfo pTSNodeInfo, PTSAnimationUtil.AnimationInfo animationInfo) {
        return this.mDelegate.animation(pTSNodeInfo, animationInfo);
    }

    public PTSNodeInfo getRootNodeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (PTSNodeInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        IPTSRootNodeDelegate iPTSRootNodeDelegate = this.mDelegate;
        if (iPTSRootNodeDelegate instanceof PTSRootNodeItemViewDelegate) {
            return ((PTSRootNodeItemViewDelegate) iPTSRootNodeDelegate).getRootNodeInfo();
        }
        return null;
    }

    public View getRootView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mDelegate.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean insert(PTSNodeInfo pTSNodeInfo, int i3) {
        return this.mDelegate.insert(pTSNodeInfo, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean modify(PTSNodeInfo pTSNodeInfo) {
        return this.mDelegate.modify(pTSNodeInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onLayoutTempPatchFinished() {
        this.mDelegate.onLayoutTempPatchFinished();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean refreshNodeList(List<PTSNodeInfo> list) {
        return this.mDelegate.refreshNodeList(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean remove(int i3) {
        return this.mDelegate.remove(i3);
    }

    public void setRootView(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup);
        } else {
            this.mDelegate.setRootView(viewGroup);
        }
    }
}
