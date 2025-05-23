package com.tencent.qzonehub.api.utils.impl;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQzoneOfflineCacheHelper;
import com.tencent.qzonehub.api.utils.impl.QzoneOfflineCacheHelperImpl;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import cooperation.qzone.webviewplugin.QzoneOfflineCacheHelper;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import u5.b;

/* compiled from: P */
/* loaded from: classes34.dex */
public class QzoneOfflineCacheHelperImpl implements IQzoneOfflineCacheHelper {
    private static final String TAG = "QzoneOfflineCacheHelper";

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$clearQZoneAppCache$0(long j3) {
        try {
            QLog.i(TAG, 2, "clearQZoneAppCache,uin=" + j3);
            LocalMultiProcConfig.putBool(QZoneJsConstants.TAG_QZONE_FORCE_REFREASH, true);
            LocalMultiProcConfig.putBool(QZoneJsConstants.TAG_QZONE_FIRST_IN, true);
            LocalMultiProcConfig.putBool(QZoneJsConstants.TAG_QZONE_FORCE_REFREASH_PASSIVE, true);
            LocalMultiProcConfig.putBool(QZoneJsConstants.TAG_QZONE_FIRST_IN_PASSIVE, true);
            updataSmallGameLastCacheFinishTime(j3, 0L);
            b.j(j3);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "clearQZoneAppCache error.", e16);
        }
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneOfflineCacheHelper
    public void clearQZoneAppCache() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        final long longAccountUin = peekAppRuntime.getLongAccountUin();
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: gz3.d
            @Override // java.lang.Runnable
            public final void run() {
                QzoneOfflineCacheHelperImpl.this.lambda$clearQZoneAppCache$0(longAccountUin);
            }
        });
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneOfflineCacheHelper
    public long getSmallGameLastCacheTime(long j3) {
        return QzoneOfflineCacheHelper.getSmallGameLastCacheTime(j3);
    }

    @Override // com.tencent.qzonehub.api.utils.IQzoneOfflineCacheHelper
    public void updataSmallGameLastCacheFinishTime(long j3, long j16) {
        QzoneOfflineCacheHelper.updataSmallGameLastCacheFinishTime(j3, j16);
    }
}
