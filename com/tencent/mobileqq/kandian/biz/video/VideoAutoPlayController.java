package com.tencent.mobileqq.kandian.biz.video;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

@Deprecated
/* loaded from: classes33.dex */
public class VideoAutoPlayController implements IVideoAutoPlayController {
    public static final long COMFIREINTERVAL = 600000;
    public static final String TAG = "VideoAutoPlayController";
    private static String cuin;
    private static long mLastComfireTime;
    private static VideoAutoPlayController sInstance;
    public static boolean sPauseScrollToNextVideo;
    private int channelId;
    private long mChannelFrom;
    public boolean mConfirmCanPlayInXg;
    public Context mContext;
    protected boolean mDeviceAllowAutoPlayVideo;
    private boolean mIsRefreshingList;
    private boolean mIsWifi;
    public float mPlayableAreaHeigth;
    public float mScreenHeight;
    public float mVideoHeight;
    private boolean shouldCheckSrtting;

    VideoAutoPlayController() {
        this(-1);
    }

    public static synchronized VideoAutoPlayController getInstance() {
        VideoAutoPlayController videoAutoPlayController;
        synchronized (VideoAutoPlayController.class) {
            if (sInstance == null) {
                sInstance = new VideoAutoPlayController();
            }
            videoAutoPlayController = sInstance;
        }
        return videoAutoPlayController;
    }

    public static boolean isAllowPlayInXgNetwork() {
        if (mLastComfireTime == -1) {
            return false;
        }
        if (MobileQQ.sProcessId == 1) {
            String currentUin = ((QQAppInterface) BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
            if (!currentUin.equals(cuin)) {
                cuin = currentUin;
                mLastComfireTime = -1L;
                return false;
            }
        }
        return System.currentTimeMillis() - mLastComfireTime < 600000;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public boolean canAutoPlayVideo() {
        return false;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public boolean isNeedNetWorkAlert() {
        return (NetworkUtil.isWifiConnected(this.mContext) || isAllowPlayInXgNetwork()) ? false : true;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public boolean isNeedNetWorkAlertForIPC() {
        return (NetworkUtil.isWifiConnected(this.mContext) || this.mConfirmCanPlayInXg) ? false : true;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public boolean isRefreshingList() {
        return this.mIsRefreshingList;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public boolean isWifi() {
        return this.mIsWifi;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public void setChannelFrom(long j3) {
        this.mChannelFrom = j3;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public void setChannelId(int i3) {
        this.channelId = i3;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public void setIsRefreshingList(boolean z16) {
        this.mIsRefreshingList = z16;
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public void updateNetworkChange(boolean z16) {
        this.mIsWifi = z16;
    }

    VideoAutoPlayController(int i3) {
        this.mScreenHeight = 0.0f;
        this.mPlayableAreaHeigth = -1.0f;
        this.mVideoHeight = -1.0f;
        this.mDeviceAllowAutoPlayVideo = true;
        this.mIsRefreshingList = false;
        this.shouldCheckSrtting = true;
        this.mConfirmCanPlayInXg = false;
        this.channelId = 0;
        this.mChannelFrom = i3;
        this.mContext = BaseApplicationImpl.getApplication().getApplicationContext();
        this.mScreenHeight = r6.getResources().getDisplayMetrics().heightPixels;
        float f16 = (int) ((this.mContext.getResources().getDisplayMetrics().widthPixels / 16.0d) * 9.0d);
        this.mVideoHeight = f16;
        this.mPlayableAreaHeigth = f16 * 2.0f * 1.2f;
        this.mDeviceAllowAutoPlayVideo = true;
        checkVideoPlaySetting();
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.TAG_READINJOY_VIDEO, 2, "mDeviceAutoPlaySwitch : " + this.mDeviceAllowAutoPlayVideo);
        }
    }

    @Override // com.tencent.mobileqq.kandian.biz.video.api.IVideoAutoPlayController
    public void initVideoPlaySetting(String str) {
        this.shouldCheckSrtting = false;
    }

    private void checkVideoPlaySetting() {
    }
}
