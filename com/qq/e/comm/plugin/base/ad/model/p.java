package com.qq.e.comm.plugin.base.ad.model;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.qq.e.comm.plugin.k.ay;
import com.qq.e.comm.plugin.k.y;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class p extends f implements NativeUnifiedADData {
    private int O;
    private int P;
    private List<String> Q;
    private String R;
    private int S;
    private double T;
    private String U;
    private int V;
    private long W;
    private String X;
    private e Y;
    private JSONObject Z;

    /* renamed from: aa, reason: collision with root package name */
    private int f39078aa;

    /* renamed from: ab, reason: collision with root package name */
    private int f39079ab;

    /* renamed from: ac, reason: collision with root package name */
    private String f39080ac;

    /* renamed from: ad, reason: collision with root package name */
    private int f39081ad;

    /* renamed from: ae, reason: collision with root package name */
    private String f39082ae;

    /* renamed from: af, reason: collision with root package name */
    private Integer f39083af;

    /* renamed from: ag, reason: collision with root package name */
    private String f39084ag;

    /* renamed from: ah, reason: collision with root package name */
    private String f39085ah;

    /* renamed from: ai, reason: collision with root package name */
    private String f39086ai;

    /* renamed from: aj, reason: collision with root package name */
    private o f39087aj;

    /* renamed from: ak, reason: collision with root package name */
    private JSONObject f39088ak;

    /* renamed from: al, reason: collision with root package name */
    private List<CarouselData> f39089al;

    /* renamed from: am, reason: collision with root package name */
    private String f39090am;

    public p(String str, String str2, String str3, com.qq.e.comm.plugin.base.ad.b bVar, JSONObject jSONObject) {
        super(str, str2, str3, bVar);
        this.Q = new ArrayList();
        this.f39089al = new ArrayList();
        this.Z = jSONObject;
        f(jSONObject);
    }

    private void d(JSONArray jSONArray) {
        if (SDKStatus.getSDKVersionCode() < 330) {
            GDTLogger.d("parseCarouselInfoList : plugin error");
        } else if (!y.a(jSONArray)) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                this.f39089al.add(new g(jSONArray.optJSONObject(i3)));
            }
        }
    }

    private void f(JSONObject jSONObject) {
        e(jSONObject);
        if (jSONObject == null) {
            return;
        }
        this.O = jSONObject.optInt("pattern_type");
        this.P = jSONObject.optInt("inner_adshowtype");
        this.f39083af = Integer.valueOf(jSONObject.optInt("native_video_endcard"));
        this.f39084ag = jSONObject.optString("endcard");
        this.f39085ah = jSONObject.optString("left_bottom_text");
        this.f39086ai = jSONObject.optString("element_structure_content");
        JSONArray optJSONArray = jSONObject.optJSONArray("img_list");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                this.Q.add(optJSONArray.optString(i3));
            }
        }
        this.R = jSONObject.optString("video");
        if (isAppAd()) {
            e c16 = com.qq.e.comm.plugin.k.d.c(jSONObject);
            this.Y = c16;
            this.S = c16.d();
            this.T = this.Y.c();
            this.U = this.Y.b();
            this.V = this.Y.e();
            this.W = this.Y.a();
        }
        this.X = jSONObject.optString("template_id");
        this.f39078aa = jSONObject.optInt("pic_width");
        this.f39079ab = jSONObject.optInt("pic_height");
        this.f39080ac = jSONObject.optString("ecpm_level");
        this.f39081ad = jSONObject.optInt("video_duration") * 1000;
        this.f39082ae = jSONObject.optString(AppDownloadCallback.BUTTON_TXT);
        this.f39087aj = o.a(jSONObject.optJSONObject("marketing_pendant"));
        this.f39088ak = jSONObject.optJSONObject("pass_through_data");
        d(jSONObject.optJSONArray("materials"));
        JSONObject optJSONObject = jSONObject.optJSONObject("ext");
        if (y.a(optJSONObject)) {
            E(optJSONObject.optString("appname"));
        }
    }

    private void o(int i3) {
        try {
            String c16 = ay.c(k(), "slot", String.valueOf(i3));
            String c17 = ay.c(j(), "slot", String.valueOf(i3));
            GDTLogger.d("pos append videoApUrl = " + c16);
            GDTLogger.d("pos append apUrl = " + c17);
            h(c17);
            i(c16);
            if (y.a(av())) {
                av().put("apurl", c17);
                av().put("v_apurl", c16);
            }
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    public void E(String str) {
        this.f39090am = str;
    }

    @Override // com.qq.e.comm.plugin.base.ad.model.f
    public String L() {
        return this.f39084ag;
    }

    public String ar() {
        return this.R;
    }

    public boolean as() {
        if (!StringUtil.isEmpty(ar())) {
            return true;
        }
        return false;
    }

    public String at() {
        return this.X;
    }

    public String au() {
        return this.f39017l;
    }

    public JSONObject av() {
        return this.Z;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, List<View> list) {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean dealClickNegativeFeedBackActionWithActionIndex(int i3) {
        return false;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean equalsAdData(NativeUnifiedADData nativeUnifiedADData) {
        return false;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    @Deprecated
    public int getAdPatternType() {
        if (as()) {
            return 2;
        }
        int i3 = this.O;
        if ((i3 == 27 || i3 == 15) && this.Q.size() == 3) {
            return 3;
        }
        if (this.O == 31) {
            return 4;
        }
        return 1;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getAdShowType() {
        return this.P;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getAppName() {
        return this.f39090am;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public double getAppPrice() {
        return this.T;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getAppScore() {
        return this.S;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getAppStatus() {
        return this.V;
    }

    @Override // com.qq.e.comm.plugin.base.ad.model.f, com.qq.e.tg.nativ.NativeUnifiedADData
    public String getButtonTxt() {
        return this.f39082ae;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getCTAText() {
        String str;
        if (c() != null) {
            str = c().a();
        } else {
            str = "";
        }
        if (StringUtil.isEmpty(str)) {
            GDTLogger.i("\u975e\u8425\u9500\u7ec4\u4ef6\u5e7f\u544a");
        }
        return str;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public List<CarouselData> getCarouselDataList() {
        return this.f39089al;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getCorporateImageName() {
        return this.L;
    }

    @Override // com.qq.e.comm.plugin.base.ad.model.f, com.qq.e.tg.nativ.NativeUnifiedADData
    public String getDesc() {
        return this.f39008c;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public long getDownloadCount() {
        return this.W;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getECPMLevel() {
        return this.f39080ac;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getElementStructContent() {
        return this.f39086ai;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getIconUrl() {
        return this.f39010e;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public List<String> getImgList() {
        return this.Q;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getImgUrl() {
        return this.f39009d;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public JSONObject getKaraokeJsonData() {
        return null;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getLeftButtonText() {
        return this.f39085ah;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public JSONArray getNegativeFeedbackItemsInfo() {
        List<q> O = O();
        if (O != null && !O.isEmpty()) {
            JSONArray jSONArray = new JSONArray();
            try {
                for (q qVar : O) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("icon_url", qVar.a());
                    jSONObject.put("text", qVar.b());
                    jSONArray.mo162put(jSONObject);
                }
                return jSONArray;
            } catch (Exception unused) {
                GDTLogger.e("negativeFeedBackItemList parse error");
            }
        }
        return null;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public JSONObject getPassThroughData() {
        return this.f39088ak;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getPendantUrl() {
        o oVar = this.f39087aj;
        if (oVar != null) {
            return oVar.a();
        }
        return null;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getPictureHeight() {
        return this.f39079ab;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getPictureWidth() {
        return this.f39078aa;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getPkgName() {
        return this.U;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getProgress() {
        return -1;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public String getTitle() {
        return this.f39007b;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getVideoCurrentPosition() {
        return -1;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getVideoDuration() {
        return this.f39081ad;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public int getVideoStatus() {
        return -1;
    }

    @Override // com.qq.e.comm.plugin.base.ad.model.f, com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean isAppAd() {
        return this.f39022q;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean isSkippable() {
        return false;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public boolean isVideoMute() {
        return false;
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setRenderPosition(int i3) {
        o(i3);
    }

    @Override // com.qq.e.comm.plugin.base.ad.model.f
    public String toString() {
        return "NativeUnifiedADDataImpl{super='" + super.toString() + "', mPatternType=" + this.O + ", mImgList=" + this.Q + ", mVideoUrl='" + this.R + "', mAppScore=" + this.S + ", mAppPrice=" + this.T + ", mPkgName='" + this.U + "', mAppStatus=" + this.V + ", mDownLoadCount=" + this.W + ", mTemplateId='" + this.X + "', mAppInfo=" + this.Y + ", mAdData=" + this.Z + '}';
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void bindAdToView(Context context, NativeAdContainer nativeAdContainer, FrameLayout.LayoutParams layoutParams, Map<View, Integer> map) {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void destroy() {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void negativeFeedback() {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void pause() {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void pauseVideo() {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void resume() {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void resumeVideo() {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void startVideo() {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void stopVideo() {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void bindCarouselView(CarouselParams carouselParams) {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void onVideoADExposured(View view) {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void preloadVideo(VideoPreloadListener videoPreloadListener) {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setCustomViewParams(NativeUnifiedCustomViewParams nativeUnifiedCustomViewParams) {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setJumpPageVideoMute(boolean z16) {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setLandingPageResultReceiver(WeakReference<VideoResultReceiver> weakReference) {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setNativeAdEventListener(NativeADEventListener nativeADEventListener) {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void setVideoMute(boolean z16) {
    }

    @Override // com.qq.e.tg.nativ.NativeUnifiedADData
    public void bindMediaView(MediaView mediaView, VideoOption videoOption, NativeADMediaListener nativeADMediaListener) {
    }
}
