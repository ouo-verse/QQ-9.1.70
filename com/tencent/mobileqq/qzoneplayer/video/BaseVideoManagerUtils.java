package com.tencent.mobileqq.qzoneplayer.video;

import com.tencent.oskplayer.util.PlayerUtils;
import java.util.HashMap;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes35.dex */
public class BaseVideoManagerUtils {
    private static final String LOG_TAG = "BaseVideoManagerUtils";
    private static final int ORIGINAL_VIDEO_MAX_SIZE = 100;
    private static ChangeSurfaceHolder mGlobalChangeSurfaceHolder;
    private static final HashMap<String, Boolean> sOriginalVideoMap = new HashMap<>(100);

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class ChangeSurfaceHolder {
        public ChangeSurfaceResult changeSurfaceResult;
        public BaseVideo newSurface;
        public BaseVideo oldSurface;
    }

    /* compiled from: P */
    /* loaded from: classes35.dex */
    public static class ChangeSurfaceResult {
        public boolean isChangeSurfaceOccurred;
        public boolean isManagerChanged;
        public boolean isSwitchBackSurfaceOccurred;
        public boolean willChangeSurfaceHappen;
    }

    public static synchronized ChangeSurfaceResult changeSurface(BaseVideo baseVideo) {
        synchronized (BaseVideoManagerUtils.class) {
            ChangeSurfaceResult changeSurfaceResult = new ChangeSurfaceResult();
            if (baseVideo == null) {
                PlayerUtils.log(6, LOG_TAG, "changeSurface failed, newsurface can not be null");
                return changeSurfaceResult;
            }
            ChangeSurfaceHolder changeSurfaceHolder = mGlobalChangeSurfaceHolder;
            if (changeSurfaceHolder == null) {
                PlayerUtils.log(6, LOG_TAG, "changeSurface failed, mGlobalChangeSurfaceHolder not set by feeds");
                return changeSurfaceResult;
            }
            BaseVideo baseVideo2 = changeSurfaceHolder.oldSurface;
            PlayerUtils.log(4, LOG_TAG, "changeSurface oldSurface=" + PlayerUtils.toString(baseVideo2) + " newSurface=" + PlayerUtils.toString(baseVideo));
            if (baseVideo2 != null && baseVideo2.getVideoPlayInfo() != null && baseVideo.getVideoPlayInfo() != null) {
                String str = baseVideo2.getVideoPlayInfo().videoId;
                String str2 = baseVideo.getVideoPlayInfo().videoId;
                if (str != null && !str.equals(str2)) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(baseVideo);
                    BaseVideoManager.getFeedVideoManager().stopVideo(baseVideo2);
                    BaseVideoManager.getFeedVideoManager().onListIdleSingleVideo(linkedList);
                    PlayerUtils.log(5, LOG_TAG, "changeSurface videoId not same, just play new video");
                    return changeSurfaceResult;
                }
            }
            changeSurfaceResult.isManagerChanged = true;
            ChangeSurfaceHolder changeSurfaceHolder2 = mGlobalChangeSurfaceHolder;
            changeSurfaceHolder2.oldSurface = baseVideo2;
            changeSurfaceHolder2.newSurface = baseVideo;
            changeSurfaceHolder2.changeSurfaceResult = changeSurfaceResult;
            return BaseVideoManager.getFeedVideoManager().n(mGlobalChangeSurfaceHolder, 0, -1);
        }
    }

    public static synchronized void clearLastChangeSurface() {
        BaseVideo baseVideo;
        ChangeSurfaceResult changeSurfaceResult;
        synchronized (BaseVideoManagerUtils.class) {
            ChangeSurfaceHolder changeSurfaceHolder = mGlobalChangeSurfaceHolder;
            if (changeSurfaceHolder != null && (baseVideo = changeSurfaceHolder.oldSurface) != null && (changeSurfaceResult = changeSurfaceHolder.changeSurfaceResult) != null) {
                changeSurfaceResult.isSwitchBackSurfaceOccurred = true;
                baseVideo.onPause();
            }
        }
    }

    public static ChangeSurfaceHolder getGlobalChangeSurfaceHolder() {
        return mGlobalChangeSurfaceHolder;
    }

    public static HashMap<String, Boolean> getOriginalVideoMap() {
        return sOriginalVideoMap;
    }

    @Deprecated
    public static synchronized void setGlobalChangeSurfaceHolder(ChangeSurfaceHolder changeSurfaceHolder) {
        synchronized (BaseVideoManagerUtils.class) {
            PlayerUtils.log(4, "michalliu", "setGlobalChangeSurfaceHolder " + changeSurfaceHolder);
            mGlobalChangeSurfaceHolder = changeSurfaceHolder;
        }
    }

    public static synchronized boolean switchBackSurface() {
        synchronized (BaseVideoManagerUtils.class) {
            ChangeSurfaceHolder changeSurfaceHolder = mGlobalChangeSurfaceHolder;
            if (changeSurfaceHolder == null) {
                PlayerUtils.log(6, LOG_TAG, "switchBackSurface: mGlobalChangeSurfaceHolder is null");
                return false;
            }
            BaseVideo baseVideo = changeSurfaceHolder.oldSurface;
            if (baseVideo == null) {
                BaseVideoManager.getFeedVideoManager().removeVideoView(mGlobalChangeSurfaceHolder.newSurface);
                return false;
            }
            PlayerUtils.log(4, LOG_TAG, "\u4ece\u6d6e\u5c42\u7a7f\u8d8a\u56de\u6765\u64ad\u653e");
            if (!baseVideo.isSurfaceAvailable()) {
                PlayerUtils.log(4, LOG_TAG, "\u7b49\u5f85surface\u5c31\u7eea");
                return false;
            }
            BaseVideoManager.getFeedVideoManager().b(baseVideo);
            ChangeSurfaceResult changeSurfaceResult = mGlobalChangeSurfaceHolder.changeSurfaceResult;
            if (changeSurfaceResult == null) {
                return false;
            }
            changeSurfaceResult.isSwitchBackSurfaceOccurred = true;
            return true;
        }
    }
}
