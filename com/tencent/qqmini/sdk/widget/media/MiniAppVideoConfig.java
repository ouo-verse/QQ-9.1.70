package com.tencent.qqmini.sdk.widget.media;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippy.qq.view.video.constants.HVideoConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.qqmini.sdk.widget.media.danmu.Barrage;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppVideoConfig {
    private static final String TAG = "MiniAppVideoConfig";
    public List<Barrage> barrages;
    public boolean customCache;
    public boolean enablePlayGesture;
    public boolean hide;
    public boolean isBarrageOpen;
    public boolean isFullScreen;
    public String lastPoster;
    public String mUrls;
    public boolean needEvent;
    public int parentId;
    public String playBtnPosition;
    public boolean showControlProgress;
    public boolean showLiveBtn;
    public String title;
    public int videoX;
    public int videoY;
    public String poster = null;
    public String objectFit = HVideoConstants.ResizeType.RESIZE_CONTAIN;
    public double initialTime = 0.0d;
    public boolean enableDanmu = false;
    public boolean showDanmuBtn = false;
    public boolean isShowBasicControl = true;
    public boolean isShowControlBar = true;
    public boolean autoplay = false;
    public boolean isLive = false;
    public boolean isMuted = false;
    public boolean loop = false;
    public boolean pageGesture = false;
    public boolean muted = false;
    public int direction = -1;
    public int videoWidth = 300;
    public int videoHeight = 150;
    public boolean isPageOnBackground = false;
    public int maxVolume = 0;
    public boolean autoPauseIfNavigate = true;
    public boolean autoPauseIfOpenNative = true;
    public String provisionUrl = "";
    public String licenseUrl = "";
    public boolean isDrm = false;
    public boolean showProgress = true;
    public boolean showPlayBtn = true;
    public boolean showCenterPlayBtn = true;
    public boolean showFullScreenBtn = true;
    public boolean enableProgressGesture = true;
    public boolean showMuteBtn = false;
    public boolean hideTimeDesc = false;
    boolean isResetPath = false;
    boolean isBusyInChangeScreen = false;
    long lastSmallScreenTime = -1;
    public boolean underGameView = false;

    private List<Barrage> parseDanmuList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return this.barrages;
        }
        List<Barrage> list = this.barrages;
        if (list == null) {
            this.barrages = new LinkedList();
        } else {
            list.clear();
        }
        int length = jSONArray.length();
        if (length > 0) {
            for (int i3 = 0; i3 < length; i3++) {
                try {
                    this.barrages.add(Barrage.parseJson(jSONArray.getJSONObject(i3)));
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return this.barrages;
    }

    public void initSetting(JSONObject jSONObject) {
        this.poster = jSONObject.optString(QAdVrReport.ElementID.AD_POSTER, this.poster);
        this.enableDanmu = jSONObject.optBoolean("enableDanmu", this.enableDanmu);
        this.needEvent = jSONObject.optBoolean("needEvent", this.needEvent);
        this.hide = jSONObject.optBoolean("hide", this.hide);
        this.loop = jSONObject.optBoolean("loop", this.loop);
        this.enablePlayGesture = jSONObject.optBoolean("enablePlayGesture", this.enablePlayGesture);
        this.direction = jSONObject.optInt("direction", this.direction);
        this.isShowBasicControl = jSONObject.optBoolean("showBasicControls", this.isShowBasicControl);
        this.isShowControlBar = jSONObject.optBoolean(MosaicConstants$JsProperty.PROP_CONTROLS, this.isShowControlBar);
        this.autoPauseIfNavigate = jSONObject.optBoolean("autoPauseIfNavigate", this.autoPauseIfNavigate);
        this.autoPauseIfOpenNative = jSONObject.optBoolean("autoPauseIfOpenNative", this.autoPauseIfOpenNative);
        this.muted = jSONObject.optBoolean("muted", this.muted);
        this.objectFit = jSONObject.optString("objectFit", this.objectFit);
        this.autoplay = jSONObject.optBoolean("autoplay", this.autoplay);
        this.barrages = parseDanmuList((JSONArray) jSONObject.opt("danmuList"));
        this.isLive = jSONObject.optBoolean("isLive", this.isLive);
        this.isMuted = jSONObject.optBoolean("isMuted", this.isMuted);
        this.pageGesture = jSONObject.optBoolean("pageGesture", this.pageGesture);
        this.initialTime = jSONObject.optDouble("initialTime", this.initialTime);
        this.parentId = jSONObject.optInt("parentId", this.parentId);
        this.customCache = jSONObject.optBoolean("customCache", this.customCache);
        this.provisionUrl = jSONObject.optString("provisionUrl", this.provisionUrl);
        this.licenseUrl = jSONObject.optString("licenseUrl", this.licenseUrl);
        this.isDrm = jSONObject.optBoolean("isDrm", this.isDrm);
        this.title = jSONObject.optString("title", this.title);
        this.playBtnPosition = jSONObject.optString("playBtnPosition", this.playBtnPosition);
        this.showDanmuBtn = jSONObject.optBoolean("showDanmuBtn", this.showDanmuBtn);
        this.showLiveBtn = jSONObject.optBoolean("showLiveBtn", this.showLiveBtn);
        this.showPlayBtn = jSONObject.optBoolean("showPlayBtn", this.showPlayBtn);
        this.showFullScreenBtn = jSONObject.optBoolean("showFullScreenBtn", this.showFullScreenBtn);
        this.showProgress = jSONObject.optBoolean("showProgress", this.showProgress);
        this.showControlProgress = jSONObject.optBoolean("showControlProgress", this.showControlProgress);
        this.showMuteBtn = jSONObject.optBoolean("showMuteBtn", this.showMuteBtn);
        this.showCenterPlayBtn = jSONObject.optBoolean("showCenterPlayBtn", this.showCenterPlayBtn);
        this.enableProgressGesture = jSONObject.optBoolean("enableProgressGesture", this.enableProgressGesture);
        this.underGameView = jSONObject.optBoolean("underGameView", this.underGameView);
        if (!this.isFullScreen) {
            JSONObject optJSONObject = jSONObject.optJSONObject("position");
            if (optJSONObject != null) {
                this.videoX = optJSONObject.optInt("left", this.videoX);
                this.videoY = optJSONObject.optInt("top", this.videoY);
                this.videoWidth = optJSONObject.optInt("width", this.videoWidth);
                this.videoHeight = optJSONObject.optInt("height", this.videoHeight);
                return;
            }
            this.videoX = jSONObject.optInt(HippyTKDListViewAdapter.X, this.videoX);
            this.videoY = jSONObject.optInt("y", this.videoY);
            this.videoWidth = jSONObject.optInt("width", this.videoWidth);
            this.videoHeight = jSONObject.optInt("height", this.videoHeight);
        }
    }
}
