package com.tencent.pts.core.itemview;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.bridge.PTSJSBridge;
import com.tencent.pts.bridge.PTSJSBridgeManager;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes22.dex */
public class PTSItemViewManager {
    static IPatchRedirector $redirector_;
    public final String TAG;
    private Activity activity;
    private PTSJSBridge jsBridge;
    private HashMap<String, PTSAppInstance> mItemIDToAppInstanceMap;

    public PTSItemViewManager(Activity activity, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, str, str2);
            return;
        }
        this.TAG = "PTSItemViewManager";
        this.activity = activity;
        this.jsBridge = PTSJSBridgeManager.getInstance().getJSBridge(activity, str, str2);
        this.mItemIDToAppInstanceMap = new HashMap<>();
    }

    private void bindData(PTSItemData pTSItemData, PTSItemView pTSItemView) {
        if (pTSItemData != null && pTSItemView != null) {
            String itemID = pTSItemData.getItemID();
            if (TextUtils.isEmpty(itemID)) {
                PTSLog.e("PTSItemViewManager", "[bindData] error, itemId is null.");
                return;
            }
            PTSAppInstance pTSAppInstance = this.mItemIDToAppInstanceMap.get(itemID);
            if (pTSAppInstance == null) {
                pTSAppInstance = new PTSAppInstance.Builder().withContext(this.activity).withRootView(pTSItemView).withRootNodeType(1).withPTSJSBridge(this.jsBridge).withItemData(pTSItemData).withPageName(pTSItemData.getPageName()).withFrameTreeJson(pTSItemData.getFrameTreeJson()).withPageJs(pTSItemData.getPageJs()).build();
                this.mItemIDToAppInstanceMap.put(itemID, pTSAppInstance);
            }
            pTSItemView.bindData(pTSAppInstance);
            PTSThreadUtil.runOnSubThread(new Runnable(pTSItemData, pTSAppInstance) { // from class: com.tencent.pts.core.itemview.PTSItemViewManager.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ PTSAppInstance val$appInstanceTemp;
                final /* synthetic */ PTSItemData val$itemData;

                {
                    this.val$itemData = pTSItemData;
                    this.val$appInstanceTemp = pTSAppInstance;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, PTSItemViewManager.this, pTSItemData, pTSAppInstance);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else if (!this.val$itemData.equals(this.val$appInstanceTemp.getItemData())) {
                        this.val$appInstanceTemp.setItemData(this.val$itemData);
                    }
                }
            });
            return;
        }
        PTSLog.e("PTSItemViewManager", "[bindData] error, itemData or ptsItemView is null.");
    }

    private void destroyAppInstance() {
        HashMap<String, PTSAppInstance> hashMap = this.mItemIDToAppInstanceMap;
        if (hashMap != null) {
            Iterator<PTSAppInstance> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
            this.mItemIDToAppInstanceMap.clear();
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        PTSLog.i("PTSItemViewManager", "[destroy].");
        destroyAppInstance();
        Activity activity = this.activity;
        if (activity != null && activity.isFinishing()) {
            PTSLog.i("PTSItemViewManager", "[destroy], destroyJSBridge.");
            PTSJSBridgeManager.getInstance().destroyJSBridge(this.activity);
        } else {
            PTSLog.i("PTSItemViewManager", "[destroy], do not destroyJSBridge.");
        }
    }

    public PTSItemView getView(View view, PTSItemData pTSItemData) {
        PTSItemView pTSItemView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (PTSItemView) iPatchRedirector.redirect((short) 3, (Object) this, (Object) view, (Object) pTSItemData);
        }
        if (view instanceof PTSItemView) {
            pTSItemView = (PTSItemView) view;
        } else {
            pTSItemView = new PTSItemView(this.activity);
        }
        bindData(pTSItemData, pTSItemView);
        return pTSItemView;
    }
}
