package com.qq.e.tg.nativ;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.tg.cfg.CarouselParams;
import com.qq.e.tg.cfg.VideoOption;
import com.qq.e.tg.cfg.VideoResultReceiver;
import com.qq.e.tg.nativ.widget.NativeAdContainer;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface NativeUnifiedADData {
    public static final int AD_CLICKED = 2;
    public static final int AD_ERROR = 3;
    public static final int AD_EXPOSED = 1;
    public static final int AD_STATUS_CHANGED = 4;
    public static final int CAROUSEL_CLICKED = 21;
    public static final int CAROUSEL_ERROR = 20;
    public static final int MEDIA_CLICKED = 15;
    public static final int MEDIA_COMPLETED = 12;
    public static final int MEDIA_ERROR = 13;
    public static final int MEDIA_INIT = 5;
    public static final int MEDIA_LOADED = 8;
    public static final int MEDIA_LOADING = 6;
    public static final int MEDIA_PAUSE = 10;
    public static final int MEDIA_READY = 7;
    public static final int MEDIA_RESUME = 11;
    public static final int MEDIA_START = 9;
    public static final int MEDIA_STOP = 14;
    public static final Map<String, String> ext = new HashMap();

    void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list);

    void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, Map<View, Integer> map);

    void bindCarouselView(CarouselParams carouselParams);

    void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener);

    boolean dealClickNegativeFeedBackActionWithActionIndex(int i3);

    void destroy();

    boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData);

    int getAdPatternType();

    int getAdShowType();

    String getAppName();

    double getAppPrice();

    int getAppScore();

    int getAppStatus();

    String getButtonTxt();

    String getCTAText();

    List<CarouselData> getCarouselDataList();

    String getCorporateImageName();

    String getDesc();

    long getDownloadCount();

    int getECPM();

    String getECPMLevel();

    String getElementStructContent();

    String getIconUrl();

    List<String> getImgList();

    String getImgUrl();

    JSONObject getKaraokeJsonData();

    String getLeftButtonText();

    JSONArray getNegativeFeedbackItemsInfo();

    JSONObject getPassThroughData();

    String getPendantUrl();

    int getPictureHeight();

    int getPictureWidth();

    String getPkgName();

    int getProgress();

    String getTitle();

    int getVideoCurrentPosition();

    int getVideoDuration();

    int getVideoStatus();

    boolean isAppAd();

    boolean isSkippable();

    boolean isVideoMute();

    boolean isWeChatCanvasAd();

    void negativeFeedback();

    void onVideoADExposured(View view);

    void pause();

    void pauseVideo();

    void preloadVideo(VideoPreloadListener videoPreloadListener);

    void resume();

    void resumeVideo();

    void setCustomViewParams(NativeUnifiedCustomViewParams nativeUnifiedCustomViewParams);

    void setJumpPageVideoMute(boolean z16);

    void setLandingPageResultReceiver(WeakReference<VideoResultReceiver> weakReference);

    void setNativeAdEventListener(NativeADEventListener nativeADEventListener);

    void setRenderPosition(int i3);

    void setVideoMute(boolean z16);

    void startVideo();

    void stopVideo();
}
