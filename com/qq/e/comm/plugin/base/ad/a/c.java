package com.qq.e.comm.plugin.base.ad.a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.plugin.base.ad.model.p;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.tg.cfg.CarouselParams;
import com.qq.e.tg.cfg.VideoOption;
import com.qq.e.tg.cfg.VideoResultReceiver;
import com.qq.e.tg.nativ.CarouselData;
import com.qq.e.tg.nativ.MediaView;
import com.qq.e.tg.nativ.NativeADEventListener;
import com.qq.e.tg.nativ.NativeADMediaListener;
import com.qq.e.tg.nativ.NativeUnifiedADData;
import com.qq.e.tg.nativ.NativeUnifiedCustomViewParams;
import com.qq.e.tg.nativ.VideoPreloadListener;
import com.qq.e.tg.nativ.widget.NativeAdContainer;
import com.qq.e.tg.tangram.ad.TangramAdListener;
import com.qq.e.tg.tangram.module.TangramAd;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c implements com.qq.e.comm.plugin.b.a, TangramAd {

    /* renamed from: a, reason: collision with root package name */
    p f38356a;

    /* renamed from: b, reason: collision with root package name */
    TangramAdListener f38357b;

    /* renamed from: c, reason: collision with root package name */
    boolean f38358c;

    public c(String str, String str2, String str3, com.qq.e.comm.plugin.base.ad.b bVar, boolean z16, JSONObject jSONObject) {
        this.f38356a = new p(str, str2, str3, bVar, jSONObject);
        this.f38358c = z16;
        ((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).addStatusListener(this.f38356a.getPkgName(), this);
    }

    public p a() {
        return this.f38356a;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
        this.f38356a.bindAdToView(context, nativeAdContainer, layoutParams, list);
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void bindCarouselView(CarouselParams carouselParams) {
        this.f38356a.bindCarouselView(carouselParams);
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
        this.f38356a.bindMediaView(mediaView, videoOption, nativeADMediaListener);
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean dealClickNegativeFeedBackActionWithActionIndex(int i3) {
        return this.f38356a.dealClickNegativeFeedBackActionWithActionIndex(i3);
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void destroy() {
        this.f38356a.destroy();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return this.f38356a.equalsAdData(nativeUnifiedADData);
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getAdPatternType() {
        return this.f38356a.getAdPatternType();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getAdShowType() {
        return this.f38356a.getAdShowType();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getAppName() {
        p pVar = this.f38356a;
        if (pVar == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return null;
        }
        return pVar.getAppName();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.f38356a.getAppPrice();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.f38356a.getAppScore();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.f38356a.getAppStatus();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getButtonTxt() {
        return this.f38356a.getButtonTxt();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getCTAText() {
        return this.f38356a.getCTAText();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public List<CarouselData> getCarouselDataList() {
        p pVar = this.f38356a;
        if (pVar == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return null;
        }
        return pVar.getCarouselDataList();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getCorporateImageName() {
        p pVar = this.f38356a;
        if (pVar == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
            return null;
        }
        return pVar.getCorporateImageName();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.f38356a.getDesc();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.f38356a.getDownloadCount();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getECPM() {
        return this.f38356a.getECPM();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getECPMLevel() {
        return this.f38356a.getECPMLevel();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getElementStructContent() {
        return this.f38356a.getElementStructContent();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return this.f38356a.getIconUrl();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        return this.f38356a.getImgList();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return this.f38356a.getImgUrl();
    }

    @Override // com.qq.e.tg.tangram.module.TangramAd
    public JSONObject getJsonData() {
        return this.f38356a.av();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public JSONObject getKaraokeJsonData() {
        return null;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getLeftButtonText() {
        return this.f38356a.getLeftButtonText();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public JSONArray getNegativeFeedbackItemsInfo() {
        return this.f38356a.getNegativeFeedbackItemsInfo();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public JSONObject getPassThroughData() {
        return this.f38356a.getPassThroughData();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getPendantUrl() {
        return this.f38356a.getPendantUrl();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.f38356a.getPictureHeight();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.f38356a.getPictureWidth();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getPkgName() {
        return this.f38356a.getPkgName();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getProgress() {
        return this.f38356a.getProgress();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.f38356a.getTitle();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        return this.f38356a.getVideoCurrentPosition();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.f38356a.getVideoDuration();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getVideoStatus() {
        return this.f38356a.getVideoStatus();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.f38356a.isAppAd();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean isSkippable() {
        return false;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean isVideoMute() {
        return this.f38356a.isVideoMute();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean isWeChatCanvasAd() {
        return this.f38356a.isWeChatCanvasAd();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void negativeFeedback() {
        this.f38356a.negativeFeedback();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void onVideoADExposured(View view) {
        this.f38356a.onVideoADExposured(view);
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void pause() {
        this.f38356a.pause();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void pauseVideo() {
        this.f38356a.pauseVideo();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void preloadVideo(VideoPreloadListener videoPreloadListener) {
        this.f38356a.preloadVideo(videoPreloadListener);
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void resume() {
        this.f38356a.resume();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void resumeVideo() {
        this.f38356a.resumeVideo();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setCustomViewParams(NativeUnifiedCustomViewParams nativeUnifiedCustomViewParams) {
        this.f38356a.setCustomViewParams(nativeUnifiedCustomViewParams);
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setJumpPageVideoMute(boolean z16) {
        this.f38356a.setJumpPageVideoMute(z16);
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setLandingPageResultReceiver(WeakReference<VideoResultReceiver> weakReference) {
        p pVar = this.f38356a;
        if (pVar == null) {
            GDTLogger.d("NativeUnifiedADDataAdapter mAdData is null");
        } else {
            pVar.setLandingPageResultReceiver(weakReference);
        }
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
        this.f38356a.setNativeAdEventListener(nativeADEventListener);
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setRenderPosition(int i3) {
        this.f38356a.setRenderPosition(i3);
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z16) {
        this.f38356a.setVideoMute(z16);
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void startVideo() {
        this.f38356a.startVideo();
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void stopVideo() {
        this.f38356a.stopVideo();
    }

    public void a(TangramAdListener tangramAdListener) {
        this.f38357b = tangramAdListener;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, Map<View, Integer> map) {
        this.f38356a.bindAdToView(context, nativeAdContainer, layoutParams, map);
    }
}
