package com.tencent.biz.pubaccount.weishi.player;

import android.graphics.Bitmap;
import com.tencent.biz.pubaccount.weishi.player.wrapper.WSPlayerDownloadInfo;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class c {
    public void a(WSPlayerWrapper wSPlayerWrapper, long j3) {
        if (QLog.isColorLevel()) {
            x.a("WSPlayerListenerAdapter", 2, "[onAccessVideoBitRate] videoPlayer:" + wSPlayerWrapper + ", videoBitRate:" + j3);
        }
    }

    public void b(WSPlayerWrapper wSPlayerWrapper, boolean z16, int i3, int i16, Bitmap bitmap) {
        if (QLog.isColorLevel()) {
            x.a("WSPlayerListenerAdapter", 2, "[onCaptureImage] result:" + z16 + ", errCode:" + i3 + ", id:" + i16 + ", bitmap:" + bitmap + ", videoPlayer:" + wSPlayerWrapper);
        }
    }

    public void c(WSPlayerWrapper wSPlayerWrapper) {
        if (QLog.isColorLevel()) {
            x.a("WSPlayerListenerAdapter", 2, "[onCompletion] videoPlayer:" + wSPlayerWrapper);
        }
    }

    public void d(WSPlayerWrapper wSPlayerWrapper, WSPlayerDownloadInfo wSPlayerDownloadInfo) {
        if (QLog.isColorLevel()) {
            x.a("WSPlayerListenerAdapter", 2, "[onDownloadCallback] info:" + wSPlayerDownloadInfo + ", videoPlayer:" + wSPlayerWrapper);
        }
    }

    public boolean e(WSPlayerWrapper wSPlayerWrapper, int i3, int i16, int i17, String str, Object obj) {
        if (!QLog.isColorLevel()) {
            return false;
        }
        x.a("WSPlayerListenerAdapter", 2, "[onError] model:" + i3 + ", what:" + i16 + ", extra:" + i17 + ", detailInfo:" + str + ", info:" + obj);
        return false;
    }

    public boolean f(WSPlayerWrapper wSPlayerWrapper, int i3, Object obj) {
        if (!QLog.isColorLevel()) {
            return false;
        }
        x.a("WSPlayerListenerAdapter", 2, "[onInfo] what:" + i3 + ", extra:" + obj + ", videoPlayer:" + wSPlayerWrapper);
        return false;
    }

    public void g(WSPlayerWrapper wSPlayerWrapper, WSPlayerDownloadInfo wSPlayerDownloadInfo) {
        if (QLog.isColorLevel()) {
            x.a("WSPlayerListenerAdapter", 2, "[onPcdnDownloadFailed] pcdnErrorSize:" + wSPlayerDownloadInfo.getPcdnErrorSize() + ", pcdnStopReasonSet:" + wSPlayerDownloadInfo.F() + ", pcdnErrorCount:" + wSPlayerDownloadInfo.getPcdnErrorCount() + ", videoPlayer:" + wSPlayerWrapper);
        }
    }

    public void h(WSPlayerWrapper wSPlayerWrapper) {
        if (QLog.isColorLevel()) {
            x.a("WSPlayerListenerAdapter", 2, "[onSeekComplete] videoPlayer:" + wSPlayerWrapper);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(int i3, int i16, int i17) {
        if (QLog.isColorLevel()) {
            x.a("WSPlayerListenerAdapter", 2, "[setupBufferRange] emergencyTimeSec:" + i3 + ", safePlayTimeSec:" + i16 + ", preloadDurationSec:" + i17);
        }
    }

    public abstract void j(WSPlayerWrapper wSPlayerWrapper, Object obj);
}
