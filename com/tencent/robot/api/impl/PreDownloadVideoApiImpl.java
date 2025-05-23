package com.tencent.robot.api.impl;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.api.IPreDownloadVideoApi;
import com.tencent.superplayer.api.SuperPlayerFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/robot/api/impl/PreDownloadVideoApiImpl;", "Lcom/tencent/robot/api/IPreDownloadVideoApi;", "", AppConstants.Key.KEY_QZONE_VIDEO_URL, "", "preVideoDownload", "", "lastCallTime", "J", "uin", "Ljava/lang/String;", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class PreDownloadVideoApiImpl implements IPreDownloadVideoApi {

    @NotNull
    public static final String TAG = "PreDownloadVideoApiImpl";
    private long lastCallTime;

    @NotNull
    private String uin = "";

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preVideoDownload$lambda$0(boolean z16) {
        QLog.i(TAG, 1, "initSDKAsync " + z16);
    }

    @Override // com.tencent.robot.api.IPreDownloadVideoApi
    public void preVideoDownload(@NotNull String videoUrl) {
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        long currentTimeMillis = System.currentTimeMillis();
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        String currentUin = mobileQQ.peekAppRuntime().getCurrentAccountUin();
        if (currentTimeMillis - this.lastCallTime < 30000 && Intrinsics.areEqual(this.uin, currentUin)) {
            QLog.i(TAG, 1, "preVideoDownload is called too frequently. Please wait. uin " + this.uin + " current " + currentUin);
            return;
        }
        this.lastCallTime = currentTimeMillis;
        Intrinsics.checkNotNullExpressionValue(currentUin, "currentUin");
        this.uin = currentUin;
        if (!QQVideoPlaySDKManager.isSDKReady()) {
            QQVideoPlaySDKManager.initSDKAsync(mobileQQ, new SDKInitListener() { // from class: com.tencent.robot.api.impl.a
                @Override // com.tencent.mobileqq.videoplatform.SDKInitListener
                public final void onSDKInited(boolean z16) {
                    PreDownloadVideoApiImpl.preVideoDownload$lambda$0(z16);
                }
            });
        }
        try {
            SuperPlayerFactory.createPreDownloader(mobileQQ, 170).startPreDownload(SuperPlayerFactory.createVideoInfoForUrl(videoUrl, 101, "", u64.a.f438505a.a()), 3000000L);
            QLog.i(TAG, 1, "preVideoDownload start");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "preVideoDownload " + e16);
        }
    }
}
