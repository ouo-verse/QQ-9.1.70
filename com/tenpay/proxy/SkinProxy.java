package com.tenpay.proxy;

import android.os.ResultReceiver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.skin.api.IHbSkinApi;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes27.dex */
public class SkinProxy {
    public static final String TAG = "SkinProxy";

    public static void getSkinPopResUrlAsync(final int i3, final String str, final int i16, final ResultReceiver resultReceiver) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tenpay.proxy.a
            @Override // java.lang.Runnable
            public final void run() {
                SkinProxy.lambda$getSkinPopResUrlAsync$0(i3, str, i16, resultReceiver);
            }
        }, 32, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$getSkinPopResUrlAsync$0(int i3, String str, int i16, ResultReceiver resultReceiver) {
        try {
            ((IHbSkinApi) QRoute.apiIPCSync(IHbSkinApi.class)).ipcGetSkinPopUrl(i3, str, i16, resultReceiver);
        } catch (Exception e16) {
            QLog.d(TAG, 1, "loadHBSkinTask: ipc error", e16);
        }
    }
}
