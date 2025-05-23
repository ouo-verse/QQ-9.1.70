package com.tencent.pts.core.lite;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.core.PTSThreadUtil;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.utils.PTSLog;
import java.util.HashMap;
import java.util.Iterator;

@Deprecated
/* loaded from: classes22.dex */
public class PTSLiteItemViewManager {
    static IPatchRedirector $redirector_;
    public final String TAG;
    private Context context;
    private HashMap<String, PTSAppInstance> itemIdToAppInstanceMap;
    private IPTSLiteEventListener liteEventListener;

    public PTSLiteItemViewManager(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.TAG = "PTSLiteItemViewManager";
        this.context = context;
        this.itemIdToAppInstanceMap = new HashMap<>();
    }

    private void bindData(PTSItemData pTSItemData, PTSItemView pTSItemView) {
        if (pTSItemData != null && pTSItemView != null) {
            String itemID = pTSItemData.getItemID();
            if (TextUtils.isEmpty(itemID)) {
                PTSLog.e("PTSLiteItemViewManager", "[bindData] error, itemId is null.");
                return;
            }
            PTSAppInstance pTSAppInstance = this.itemIdToAppInstanceMap.get(itemID);
            if (pTSAppInstance == null) {
                pTSAppInstance = new PTSAppInstance.Builder().withContext(this.context).withRootView(pTSItemView).withRootNodeType(1).withItemData(pTSItemData).withPageName(pTSItemData.getPageName()).withFrameTreeJson(pTSItemData.getFrameTreeJson()).withLiteItemViewManager(this).build();
                this.itemIdToAppInstanceMap.put(itemID, pTSAppInstance);
            }
            pTSItemView.bindData(pTSAppInstance);
            PTSThreadUtil.runOnSubThread(new Runnable(pTSItemData, pTSAppInstance) { // from class: com.tencent.pts.core.lite.PTSLiteItemViewManager.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ PTSAppInstance val$appInstanceTemp;
                final /* synthetic */ PTSItemData val$itemData;

                {
                    this.val$itemData = pTSItemData;
                    this.val$appInstanceTemp = pTSAppInstance;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, PTSLiteItemViewManager.this, pTSItemData, pTSAppInstance);
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
        PTSLog.e("PTSLiteItemViewManager", "[bindData] error, itemData or ptsItemView is null.");
    }

    private void destroyAppInstance() {
        HashMap<String, PTSAppInstance> hashMap = this.itemIdToAppInstanceMap;
        if (hashMap != null) {
            Iterator<PTSAppInstance> it = hashMap.values().iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
            this.itemIdToAppInstanceMap.clear();
        }
    }

    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            PTSLog.i("PTSLiteItemViewManager", "[destroy]");
            destroyAppInstance();
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
            pTSItemView = new PTSItemView(this.context);
        }
        bindData(pTSItemData, pTSItemView);
        return pTSItemView;
    }

    public void setLiteEventListener(IPTSLiteEventListener iPTSLiteEventListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) iPTSLiteEventListener);
        } else {
            this.liteEventListener = iPTSLiteEventListener;
        }
    }

    public void triggerLiteEvent(int i3, String str, HashMap<String, String> hashMap, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), str, hashMap, view);
            return;
        }
        IPTSLiteEventListener iPTSLiteEventListener = this.liteEventListener;
        if (iPTSLiteEventListener == null) {
            PTSLog.i("PTSLiteItemViewManager", "[triggerLiteEvent], liteEventListener is null.");
            return;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            PTSLog.i("PTSLiteItemViewManager", "[triggerLiteEvent] unknown, eventType = " + i3);
                            return;
                        }
                        iPTSLiteEventListener.onScrollViewItemExposureTriggered(str, hashMap, view, null);
                        return;
                    }
                    iPTSLiteEventListener.onSwiperDragTriggered(str, hashMap, view, null);
                    return;
                }
                iPTSLiteEventListener.onSwiperItemExposureTriggered(str, hashMap, view, null);
                return;
            }
            iPTSLiteEventListener.onExposureTriggered(str, hashMap, view, null);
            return;
        }
        iPTSLiteEventListener.onTapEventTriggered(str, hashMap, view, null);
    }
}
