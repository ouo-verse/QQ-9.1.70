package com.qq.e.tg.nativ;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADEventListener;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.util.AdErrorConvertor;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.cfg.CarouselParams;
import com.qq.e.tg.cfg.VideoOption;
import com.qq.e.tg.cfg.VideoResultReceiver;
import com.qq.e.tg.nativ.widget.NativeAdContainer;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NativeUnifiedADDataAdapter implements NativeUnifiedADData {

    /* renamed from: a, reason: collision with root package name */
    private NativeUnifiedADData f40585a;

    /* renamed from: b, reason: collision with root package name */
    private NativeADEventListener f40586b;

    /* renamed from: c, reason: collision with root package name */
    private NativeADMediaListener f40587c;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<NativeCarouselListener> f40588d;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class UnifiedAdListener implements ADListener {
        UnifiedAdListener() {
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (aDEvent.getType() <= 4) {
                NativeUnifiedADDataAdapter.a(NativeUnifiedADDataAdapter.this, aDEvent);
            } else if (aDEvent.getType() <= 15) {
                NativeUnifiedADDataAdapter.b(NativeUnifiedADDataAdapter.this, aDEvent);
            } else {
                NativeUnifiedADDataAdapter.c(NativeUnifiedADDataAdapter.this, aDEvent);
            }
        }

        /* synthetic */ UnifiedAdListener(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, byte b16) {
            this();
        }
    }

    public NativeUnifiedADDataAdapter(NativeUnifiedADData nativeUnifiedADData) {
        this.f40585a = nativeUnifiedADData;
        if (nativeUnifiedADData instanceof ADEventListener) {
            ((ADEventListener) nativeUnifiedADData).setAdListener(new UnifiedAdListener(this, (byte) 0));
        }
    }

    static /* synthetic */ void a(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f40586b != null) {
            int type = aDEvent.getType();
            if (type != 1) {
                if (type != 2) {
                    if (type != 3) {
                        if (type == 4) {
                            nativeUnifiedADDataAdapter.f40586b.onADStatusChanged();
                            return;
                        }
                        return;
                    } else {
                        if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                            nativeUnifiedADDataAdapter.f40586b.onADError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                            return;
                        }
                        return;
                    }
                }
                if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof String)) {
                    try {
                        NativeUnifiedADData.ext.put(Constants.KEYS.EXPOSED_CLICK_URL_KEY, (String) aDEvent.getParas()[0]);
                    } catch (Exception e16) {
                        GDTLogger.e("native 2.0 set click url error");
                        e16.printStackTrace();
                    }
                    nativeUnifiedADDataAdapter.f40586b.onADClicked();
                    return;
                }
                return;
            }
            nativeUnifiedADDataAdapter.f40586b.onADExposed();
        }
    }

    static /* synthetic */ void b(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        if (nativeUnifiedADDataAdapter.f40587c != null) {
            switch (aDEvent.getType()) {
                case 5:
                    nativeUnifiedADDataAdapter.f40587c.onVideoInit();
                    return;
                case 6:
                    nativeUnifiedADDataAdapter.f40587c.onVideoLoading();
                    return;
                case 7:
                    nativeUnifiedADDataAdapter.f40587c.onVideoReady();
                    return;
                case 8:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        nativeUnifiedADDataAdapter.f40587c.onVideoLoaded(((Integer) aDEvent.getParas()[0]).intValue());
                        return;
                    }
                    return;
                case 9:
                    nativeUnifiedADDataAdapter.f40587c.onVideoStart();
                    return;
                case 10:
                    nativeUnifiedADDataAdapter.f40587c.onVideoPause();
                    return;
                case 11:
                    nativeUnifiedADDataAdapter.f40587c.onVideoResume();
                    return;
                case 12:
                    nativeUnifiedADDataAdapter.f40587c.onVideoCompleted();
                    return;
                case 13:
                    if (aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                        nativeUnifiedADDataAdapter.f40587c.onVideoError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()));
                        return;
                    }
                    return;
                case 14:
                    nativeUnifiedADDataAdapter.f40587c.onVideoStop();
                    return;
                case 15:
                    nativeUnifiedADDataAdapter.f40587c.onVideoClicked();
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void c(NativeUnifiedADDataAdapter nativeUnifiedADDataAdapter, ADEvent aDEvent) {
        NativeCarouselListener nativeCarouselListener;
        int i3;
        WeakReference<NativeCarouselListener> weakReference = nativeUnifiedADDataAdapter.f40588d;
        if (weakReference != null) {
            nativeCarouselListener = weakReference.get();
        } else {
            nativeCarouselListener = null;
        }
        if (nativeCarouselListener != null) {
            int type = aDEvent.getType();
            if (type != 20) {
                if (type == 21 && aDEvent.getParas().length == 1 && (aDEvent.getParas()[0] instanceof Integer)) {
                    nativeCarouselListener.onCarouselClick(((Integer) aDEvent.getParas()[0]).intValue());
                    return;
                }
                return;
            }
            try {
                if (aDEvent.getParas().length > 0 && (aDEvent.getParas()[0] instanceof Integer)) {
                    if (aDEvent.getParas().length == 2 && (aDEvent.getParas()[1] instanceof Integer)) {
                        i3 = ((Integer) aDEvent.getParas()[1]).intValue();
                    } else {
                        i3 = Integer.MIN_VALUE;
                    }
                    nativeCarouselListener.onCarouselError(AdErrorConvertor.formatErrorCode(((Integer) aDEvent.getParas()[0]).intValue()), i3);
                }
            } catch (Throwable th5) {
                GDTLogger.e("handleCarouselEvent", th5);
            }
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.bindAdToView(context, nativeAdContainer, layoutParams, list);
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void bindCarouselView(CarouselParams carouselParams) {
        WeakReference<NativeCarouselListener> weakReference;
        if (carouselParams != null) {
            weakReference = carouselParams.getCarouselListener();
        } else {
            weakReference = null;
        }
        this.f40588d = weakReference;
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.bindCarouselView(carouselParams);
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        this.f40587c = nativeADMediaListener;
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.bindMediaView(mediaView, videoOption, null);
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean dealClickNegativeFeedBackActionWithActionIndex(int i3) {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return false;
        }
        return nativeUnifiedADData.dealClickNegativeFeedBackActionWithActionIndex(i3);
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void destroy() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.destroy();
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        NativeUnifiedADData nativeUnifiedADData2 = this.f40585a;
        if (nativeUnifiedADData2 == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return false;
        }
        return nativeUnifiedADData2.equalsAdData(nativeUnifiedADData);
    }

    public NativeUnifiedADData getAdData() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return null;
        }
        return nativeUnifiedADData;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return 0;
        }
        return nativeUnifiedADData.getAdPatternType();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getAdShowType() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return 0;
        }
        return nativeUnifiedADData.getAdShowType();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getAppName() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return null;
        }
        return nativeUnifiedADData.getAppName();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public double getAppPrice() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return 0.0d;
        }
        return nativeUnifiedADData.getAppPrice();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getAppScore() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return 0;
        }
        return nativeUnifiedADData.getAppScore();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getAppStatus() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return 0;
        }
        return nativeUnifiedADData.getAppStatus();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getButtonTxt() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return "";
        }
        return nativeUnifiedADData.getButtonTxt();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getCTAText() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return "";
        }
        return nativeUnifiedADData.getCTAText();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public List<CarouselData> getCarouselDataList() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return null;
        }
        return nativeUnifiedADData.getCarouselDataList();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getCorporateImageName() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return null;
        }
        return nativeUnifiedADData.getCorporateImageName();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getDesc() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return "";
        }
        return nativeUnifiedADData.getDesc();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return 0L;
        }
        return nativeUnifiedADData.getDownloadCount();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getECPM() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return 0;
        }
        return nativeUnifiedADData.getECPM();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getECPMLevel() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return "";
        }
        return nativeUnifiedADData.getECPMLevel();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getElementStructContent() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return "";
        }
        return nativeUnifiedADData.getElementStructContent();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getIconUrl() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return "";
        }
        return nativeUnifiedADData.getIconUrl();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return null;
        }
        return nativeUnifiedADData.getImgList();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getImgUrl() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return "";
        }
        return nativeUnifiedADData.getImgUrl();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public JSONObject getKaraokeJsonData() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return null;
        }
        return nativeUnifiedADData.getKaraokeJsonData();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getLeftButtonText() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return "";
        }
        return nativeUnifiedADData.getLeftButtonText();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public JSONArray getNegativeFeedbackItemsInfo() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return null;
        }
        return nativeUnifiedADData.getNegativeFeedbackItemsInfo();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public JSONObject getPassThroughData() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return null;
        }
        return nativeUnifiedADData.getPassThroughData();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getPendantUrl() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return "";
        }
        return nativeUnifiedADData.getPendantUrl();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return 0;
        }
        return nativeUnifiedADData.getPictureHeight();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return 0;
        }
        return nativeUnifiedADData.getPictureWidth();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getPkgName() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return "";
        }
        return nativeUnifiedADData.getPkgName();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getProgress() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return 0;
        }
        return nativeUnifiedADData.getProgress();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getTitle() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return "";
        }
        return nativeUnifiedADData.getTitle();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return 0;
        }
        return nativeUnifiedADData.getVideoCurrentPosition();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return 0;
        }
        return nativeUnifiedADData.getVideoDuration();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getVideoStatus() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return 0;
        }
        return nativeUnifiedADData.getVideoStatus();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return false;
        }
        return nativeUnifiedADData.isAppAd();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean isSkippable() {
        if (this.f40585a == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        }
        return false;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean isVideoMute() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return false;
        }
        return nativeUnifiedADData.isVideoMute();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean isWeChatCanvasAd() {
        try {
            return this.f40585a.isWeChatCanvasAd();
        } catch (Throwable unused) {
            GDTLogger.e("NativeUnifiedADDataAdapter isWeChatCanvasAd error");
            return false;
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        this.f40585a.negativeFeedback();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void onVideoADExposured(View view) {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.onVideoADExposured(view);
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void pause() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.pause();
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void pauseVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.pauseVideo();
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void preloadVideo(VideoPreloadListener videoPreloadListener) {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.preloadVideo(videoPreloadListener);
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void resume() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.resume();
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void resumeVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.resumeVideo();
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setCustomViewParams(NativeUnifiedCustomViewParams nativeUnifiedCustomViewParams) {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.setCustomViewParams(nativeUnifiedCustomViewParams);
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setJumpPageVideoMute(boolean z16) {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.setJumpPageVideoMute(z16);
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setLandingPageResultReceiver(WeakReference<VideoResultReceiver> weakReference) {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.setLandingPageResultReceiver(weakReference);
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        this.f40586b = nativeADEventListener;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setRenderPosition(int i3) {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.setRenderPosition(i3);
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z16) {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.setVideoMute(z16);
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void startVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.startVideo();
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void stopVideo() {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.stopVideo();
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, Map<View, Integer> map) {
        NativeUnifiedADData nativeUnifiedADData = this.f40585a;
        if (nativeUnifiedADData == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            nativeUnifiedADData.bindAdToView(context, nativeAdContainer, layoutParams, map);
        }
    }
}
