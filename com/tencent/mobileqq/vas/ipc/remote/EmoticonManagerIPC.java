package com.tencent.mobileqq.vas.ipc.remote;

import android.os.Bundle;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.vas.update.callback.listener.IUpdateListener;
import com.tencent.vas.update.entity.UpdateListenerParams;
import eipc.EIPCModule;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

/* loaded from: classes20.dex */
public class EmoticonManagerIPC implements IEmoticonManager {
    @Override // com.tencent.mobileqq.vas.ipc.remote.IEmoticonManager
    public void startTroopNickDownload(int i3, final EIPCModule eIPCModule, final int i16, EIPCResultCallback eIPCResultCallback) {
        ((TroopNickNameBusiness) QQVasUpdateBusinessUtil.getBusinessInstance(TroopNickNameBusiness.class)).addUpdateListener(new IUpdateListener() { // from class: com.tencent.mobileqq.vas.ipc.remote.EmoticonManagerIPC.1
            @Override // com.tencent.vas.update.callback.listener.IUpdateListener
            public void onLoadFail(UpdateListenerParams updateListenerParams) {
                EIPCResult eIPCResult = new EIPCResult();
                Bundle bundle = new Bundle();
                eIPCResult.data = bundle;
                bundle.putBoolean("status", false);
                eIPCModule.callbackResult(i16, eIPCResult);
            }

            @Override // com.tencent.vas.update.callback.listener.IUpdateListener
            public void onLoadSuccess(UpdateListenerParams updateListenerParams) {
                EIPCResult eIPCResult = new EIPCResult();
                Bundle bundle = new Bundle();
                eIPCResult.data = bundle;
                bundle.putBoolean("status", true);
                eIPCResult.data.putString("filepath", ((TroopNickNameBusiness) QQVasUpdateBusinessUtil.getBusinessInstance(TroopNickNameBusiness.class)).getSavePath(updateListenerParams.mBusinessUpdateParams.mScid));
                eIPCModule.callbackResult(i16, eIPCResult);
            }

            @Override // com.tencent.vas.update.callback.listener.IUpdateListener
            public void onProgress(UpdateListenerParams updateListenerParams) {
            }
        });
        ((TroopNickNameBusiness) QQVasUpdateBusinessUtil.getBusinessInstance(TroopNickNameBusiness.class)).startDownload(i3);
    }
}
