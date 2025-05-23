package com.tencent.biz.richframework.video.rfw.player.playinterceptor;

import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFWConfig;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.video.rfw.RFWPlayer;
import com.tencent.biz.richframework.video.rfw.player.RFWPlayerOptions;
import com.tencent.biz.richframework.video.rfw.player.playinterceptor.controller.RFWBaseInterceptorController;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.utils.CommonUtil;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDownloadProxy;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyFactory;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: classes5.dex */
public class RFWPlayerClearInvalidCacheInterceptor extends RFWPlayerBaseInterceptor {
    private static final Set<Integer> INVALID_SET;

    static {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        INVALID_SET = copyOnWriteArraySet;
        copyOnWriteArraySet.add(11030407);
        copyOnWriteArraySet.add(Integer.valueOf(VideoPlaySDKManager.ERR_VIDEO_FILE_DAMAGED));
    }

    public RFWPlayerClearInvalidCacheInterceptor(RFWBaseInterceptorController rFWBaseInterceptorController) {
        super(rFWBaseInterceptorController);
    }

    private void clearErrorInvalidVideoCache(int i3) {
        RFWPlayer rFWPlayer;
        String fileId;
        if (!isEnabledErrorClearInvalidCache() || !INVALID_SET.contains(Integer.valueOf(i3))) {
            return;
        }
        RFWPlayerOptions options = getOptions();
        if (options != null && (rFWPlayer = this.mPlayer) != null) {
            SuperPlayerVideoInfo currentSuperVideoInfo = rFWPlayer.getCurrentSuperVideoInfo();
            if (currentSuperVideoInfo == null) {
                fileId = "";
            } else {
                fileId = currentSuperVideoInfo.getFileId();
            }
            if (TextUtils.isEmpty(fileId)) {
                RFWLog.d("RFWPlayerClearInvalidCacheInterceptor", RFWLog.USR, "[clearErrorInvalidVideoCache] fileId should not be null.");
                return;
            }
            int sceneId = options.getSceneId();
            int i16 = CommonUtil.i(sceneId);
            ITPDownloadProxy tPDownloadProxy = TPDownloadProxyFactory.getTPDownloadProxy(i16);
            if (tPDownloadProxy == null) {
                RFWLog.d("RFWPlayerClearInvalidCacheInterceptor", RFWLog.USR, "[clearErrorInvalidVideoCache] downloadProxy == null, fileId: " + fileId);
                return;
            }
            RFWLog.d(getTag() + "RFWPlayerClearInvalidCacheInterceptor", RFWLog.USR, "[clearErrorInvalidVideoCache] fileId: " + fileId + " | sceneId: " + sceneId + " | serviceType: " + i16);
            tPDownloadProxy.clearCache(CommonUtil.h(i16), fileId, 4);
            return;
        }
        RFWLog.d("RFWPlayerClearInvalidCacheInterceptor", RFWLog.USR, "[clearErrorInvalidVideoCache] options == null || mPlayer == null.");
    }

    private boolean isEnabledErrorClearInvalidCache() {
        return RFWConfig.getConfigValue("rfw_error_clear_invalid_cache", true);
    }

    @Override // com.tencent.biz.richframework.video.rfw.player.playinterceptor.RFWPlayerBaseInterceptor
    public boolean onError(ISuperPlayer iSuperPlayer, int i3, int i16, int i17, String str) {
        boolean onError = super.onError(iSuperPlayer, i3, i16, i17, str);
        clearErrorInvalidVideoCache(i17);
        return onError;
    }
}
