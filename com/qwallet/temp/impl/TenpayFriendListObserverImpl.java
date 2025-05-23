package com.qwallet.temp.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.qwallet.temp.IQwTemp;
import com.qwallet.temp.ITenpayFriendListObserver;
import com.tencent.mobileqq.app.ar;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.ipc.CorpReq;
import cooperation.qwallet.plugin.ipc.CorpResp;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TenpayFriendListObserverImpl extends ar implements ITenpayFriendListObserver {
    private HashMap<String, ResultReceiver> mRecieverMap = new HashMap<>();

    @Override // com.qwallet.temp.ITenpayFriendListObserver
    public void add(String str, ResultReceiver resultReceiver) {
        this.mRecieverMap.put(str, resultReceiver);
    }

    @Override // com.qwallet.temp.ITenpayFriendListObserver
    public void destroy() {
        this.mRecieverMap.clear();
    }

    @Override // com.tencent.mobileqq.app.ar
    protected void onUpdateFriendInfo(String str, boolean z16) {
        AppRuntime runtime = ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getRuntime();
        if (!z16 || str == null || runtime == null) {
            return;
        }
        CorpResp corpResp = new CorpResp();
        corpResp.corpReqType = CorpReq.corpReqType;
        corpResp.userNick = ((IQwTemp) QRoute.api(IQwTemp.class)).ContactUtils$getBuddyName(runtime, str, false);
        Bundle bundle = new Bundle();
        corpResp.toBundle(bundle);
        ResultReceiver remove = this.mRecieverMap.remove(str);
        if (remove == null) {
            return;
        }
        remove.send(0, bundle);
    }
}
