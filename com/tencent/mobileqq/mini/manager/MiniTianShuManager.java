package com.tencent.mobileqq.mini.manager;

import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniTianShuManager {
    public static final String TAG = "MiniTianShuManager";
    private static List<TianShuGetAdvCallback> mCallbackList = new ArrayList();

    public static void requestAdv(List<TianShuAdPosItemData> list, final TianShuGetAdvCallback tianShuGetAdvCallback) {
        if (list == null || list.size() <= 0 || tianShuGetAdvCallback == null) {
            return;
        }
        TianShuGetAdvCallback tianShuGetAdvCallback2 = new TianShuGetAdvCallback() { // from class: com.tencent.mobileqq.mini.manager.MiniTianShuManager.1
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                TianShuGetAdvCallback.this.onGetAdvs(z16, getAdsRsp);
                MiniTianShuManager.mCallbackList.remove(this);
                QLog.i(MiniTianShuManager.TAG, 1, "remove callback " + MiniTianShuManager.mCallbackList.size());
            }
        };
        mCallbackList.add(tianShuGetAdvCallback2);
        QLog.i(TAG, 1, "add callback " + mCallbackList.size());
        TianShuManager.getInstance().requestAdv(list, tianShuGetAdvCallback2);
    }
}
