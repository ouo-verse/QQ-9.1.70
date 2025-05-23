package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.offlinePush.EnterBackgroundParam;
import com.tencent.imsdk.offlinePush.EnterForegroundParam;
import com.tencent.imsdk.offlinePush.OfflinePushManager;

/* loaded from: classes7.dex */
public class V2TIMOfflinePushManagerImpl extends V2TIMOfflinePushManager {
    private final String TAG = "V2TIMOfflinePushManagerImpl";

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class V2TIMOfflinePushManagerImplHolder {
        private static final V2TIMOfflinePushManagerImpl v2TIMOfflinePushManagerImpl = new V2TIMOfflinePushManagerImpl();

        V2TIMOfflinePushManagerImplHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static V2TIMOfflinePushManagerImpl getInstance() {
        return V2TIMOfflinePushManagerImplHolder.v2TIMOfflinePushManagerImpl;
    }

    @Override // com.tencent.imsdk.v2.V2TIMOfflinePushManager
    public void doBackground(int i3, V2TIMCallback v2TIMCallback) {
        if (i3 < 0) {
            i3 = 0;
        }
        int instanceType = SystemUtil.getInstanceType();
        EnterBackgroundParam enterBackgroundParam = new EnterBackgroundParam();
        enterBackgroundParam.setC2cUnreadMessageCount(i3);
        enterBackgroundParam.setDeviceBrand(instanceType);
        OfflinePushManager.getInstance().doEnterBackground(enterBackgroundParam, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMOfflinePushManagerImpl.2
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i16, String str) {
                super.fail(i16, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMOfflinePushManager
    public void doForeground(V2TIMCallback v2TIMCallback) {
        int instanceType = SystemUtil.getInstanceType();
        EnterForegroundParam enterForegroundParam = new EnterForegroundParam();
        enterForegroundParam.setDeviceBrand(instanceType);
        OfflinePushManager.getInstance().doEnterForeground(enterForegroundParam, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMOfflinePushManagerImpl.3
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str) {
                super.fail(i3, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMOfflinePushManager
    public void setOfflinePushConfig(V2TIMOfflinePushConfig v2TIMOfflinePushConfig, V2TIMCallback v2TIMCallback) {
        if (v2TIMOfflinePushConfig == null) {
            v2TIMOfflinePushConfig = new V2TIMOfflinePushConfig(0L, "");
        }
        v2TIMOfflinePushConfig.getOfflinePushToken().setDeviceBrand(SystemUtil.getInstanceType());
        OfflinePushManager.getInstance().setOfflinePushToken(v2TIMOfflinePushConfig.getOfflinePushToken(), new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMOfflinePushManagerImpl.1
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str) {
                super.fail(i3, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }
}
