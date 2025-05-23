package com.tencent.pts.core.itemview;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.PTSNodeFactory;
import com.tencent.pts.ui.PTSNodeInfo;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes22.dex */
public class PTSItemView extends FrameLayout {
    static IPatchRedirector $redirector_;
    public final String TAG;
    private PTSAppInstance appInstance;
    private HashMap<String, List<PTSNodeVirtual>> viewIdToNodeListMap;

    public PTSItemView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.TAG = "PTSItemView";
            this.viewIdToNodeListMap = new HashMap<>();
        }
    }

    private void attachRootNode(PTSNodeVirtual pTSNodeVirtual) {
        if (pTSNodeVirtual != null && pTSNodeVirtual.getView() != null) {
            if (pTSNodeVirtual.getView().getParent() == null) {
                addView(pTSNodeVirtual.getView());
            } else {
                PTSLog.d("PTSItemView", "[attachRootNode], do not attach again.");
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(pTSNodeVirtual.getWidth(), pTSNodeVirtual.getHeight());
            } else {
                layoutParams.width = pTSNodeVirtual.getWidth();
                layoutParams.height = pTSNodeVirtual.getHeight();
            }
            if (PTSLog.isDebug()) {
                PTSLog.i("PTSItemView", "[attachRootNode], lp.width = " + layoutParams.width + ", lp.height = " + layoutParams.height);
            }
            setLayoutParams(layoutParams);
        }
    }

    private void bindDataImpl(PTSAppInstance pTSAppInstance, PTSNodeInfo pTSNodeInfo, HashMap<String, List<PTSNodeVirtual>> hashMap) {
        attachRootNode(PTSNodeFactory.bindData(pTSAppInstance, pTSNodeInfo, hashMap));
    }

    private void updateAppInstance(PTSAppInstance pTSAppInstance) {
        this.appInstance = pTSAppInstance;
        pTSAppInstance.getRootNode().setRootView(this);
        for (List<PTSNodeVirtual> list : this.viewIdToNodeListMap.values()) {
            if (list != null) {
                for (PTSNodeVirtual pTSNodeVirtual : list) {
                    if (pTSNodeVirtual != null) {
                        pTSNodeVirtual.setPTSAppInstance(pTSAppInstance);
                    }
                }
            }
        }
    }

    public void bindData(PTSAppInstance pTSAppInstance) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pTSAppInstance);
            return;
        }
        if (pTSAppInstance == null) {
            PTSLog.e("PTSItemView", "[bindData], appInstance is null.");
            return;
        }
        if (pTSAppInstance.getRootNode() == null) {
            PTSLog.e("PTSItemView", "[bindData], appInstance.getRootNode is null.");
            return;
        }
        updateAppInstance(pTSAppInstance);
        PTSNodeInfo rootNodeInfo = pTSAppInstance.getRootNode().getRootNodeInfo();
        if (rootNodeInfo == null) {
            PTSLog.i("PTSItemView", "[bindData], rootNodeInfo is null.");
        } else {
            bindDataImpl(pTSAppInstance, rootNodeInfo, this.viewIdToNodeListMap);
        }
    }

    public PTSAppInstance getAppInstance() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (PTSAppInstance) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.appInstance;
    }
}
