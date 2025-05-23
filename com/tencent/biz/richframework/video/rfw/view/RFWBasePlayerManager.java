package com.tencent.biz.richframework.video.rfw.view;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes5.dex */
public abstract class RFWBasePlayerManager {
    private static volatile boolean sIsSdkInit = false;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$initPlay$0(boolean z16) {
        if (!z16) {
            QLog.e("BasePlayerManager", 1, "onSDKInited failed");
        } else {
            sIsSdkInit = true;
        }
    }

    public abstract RFWPlayer getPlayer(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void initPlay() {
        if (!sIsSdkInit && !QQVideoPlaySDKManager.isSDKReady()) {
            try {
                QQVideoPlaySDKManager.initSDKAsync(RFWApplication.getApplication(), new SDKInitListener() { // from class: com.tencent.biz.richframework.video.rfw.view.a
                    @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                    public final void onSDKInited(boolean z16) {
                        RFWBasePlayerManager.lambda$initPlay$0(z16);
                    }
                });
            } catch (RuntimeException e16) {
                QLog.e("BasePlayerManager", 1, e16.getMessage());
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void iteratorRelease(Iterator<Map.Entry<String, RFWPlayer>> it) {
        if (it == null) {
            return;
        }
        while (it.hasNext()) {
            it.next().getValue().release(RFWPlayer.RELEASE_FROM_PLAYER_MANGER);
            it.remove();
        }
    }

    public abstract RFWPlayer newAQCirclePlayer(String str);

    public abstract void putPlayer(String str, RFWPlayer rFWPlayer);

    public abstract boolean releasePlayer(String str);

    public void removeReUsePlayer(String str) {
    }

    public void putReusePlayer(String str, RFWPlayer rFWPlayer) {
    }
}
