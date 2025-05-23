package com.tencent.biz.richframework.video.rfw.player.strategy;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.SuperPlayerSDKMgr;

/* loaded from: classes5.dex */
public class RFWPlayerAV1DecodeStrategy {
    private static volatile RFWPlayerAV1DecodeStrategy sInstance;
    private boolean mHasInit;

    RFWPlayerAV1DecodeStrategy() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.richframework.video.rfw.player.strategy.RFWPlayerAV1DecodeStrategy.1
            @Override // java.lang.Runnable
            public void run() {
                if (uq3.c.h()) {
                    RFWPlayerAV1DecodeStrategy.this.initWhitList();
                }
            }
        });
    }

    public static RFWPlayerAV1DecodeStrategy g() {
        if (sInstance == null) {
            synchronized (RFWPlayerAV1DecodeStrategy.class) {
                if (sInstance == null) {
                    sInstance = new RFWPlayerAV1DecodeStrategy();
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void initWhitList() {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        String G0 = uq3.c.G0();
        if (TextUtils.isEmpty(G0)) {
            RFWLog.d("QFSPlayerAV1DecodeStrategy", RFWLog.USR, "whitList is empty");
            return;
        }
        String[] split = G0.split(";");
        String mobileModel = QCircleDeviceInfoUtils.getMobileModel();
        if (split != null && split.length >= 0 && !TextUtils.isEmpty(mobileModel)) {
            for (String str : split) {
                if (str.equalsIgnoreCase(mobileModel)) {
                    SuperPlayerSDKMgr.clearVideoHwCodecBlackList(1029);
                    RFWLog.d("QFSPlayerAV1DecodeStrategy", RFWLog.USR, "is white list model:" + mobileModel);
                    return;
                }
            }
            RFWLog.d("QFSPlayerAV1DecodeStrategy", RFWLog.USR, "is black model:" + mobileModel);
            QQVideoPlaySDKManager.addVideoHwCodecBlackList(1029);
            return;
        }
        RFWLog.d("QFSPlayerAV1DecodeStrategy", RFWLog.USR, "whitList is empty or currentModel is empty");
    }
}
