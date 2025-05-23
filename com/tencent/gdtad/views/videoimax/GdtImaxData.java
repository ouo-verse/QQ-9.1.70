package com.tencent.gdtad.views.videoimax;

import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoData;
import java.io.Serializable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Deprecated
/* loaded from: classes6.dex */
public final class GdtImaxData implements Serializable {

    /* renamed from: ad, reason: collision with root package name */
    private GdtAd f109725ad;
    private String[] danmakuContents;
    private Boolean isDanmakuAdv;
    private GdtVideoData videoData;
    private int videoSplicePageStyle = 0;
    private String webUrl;

    public GdtAd getAd() {
        return this.f109725ad;
    }

    public String[] getDanmakuContents() {
        return this.danmakuContents;
    }

    public GdtVideoData getVideoData() {
        return this.videoData;
    }

    public int getVideoSplicePageStyle() {
        return this.videoSplicePageStyle;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public boolean isDanmakuAdv() {
        Boolean bool = this.isDanmakuAdv;
        if (bool != null) {
            return bool.booleanValue();
        }
        this.isDanmakuAdv = Boolean.FALSE;
        GdtAd gdtAd = this.f109725ad;
        if (gdtAd != null && gdtAd.isValid()) {
            try {
                JSONObject jSONObject = new JSONObject(this.f109725ad.info.ext_json.get());
                if (jSONObject.has("bullet_screen")) {
                    JSONArray jSONArray = jSONObject.getJSONArray("bullet_screen");
                    if (jSONArray.length() != 0) {
                        this.danmakuContents = new String[jSONArray.length()];
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            this.danmakuContents[i3] = jSONArray.get(i3).toString();
                        }
                        this.isDanmakuAdv = Boolean.TRUE;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return this.isDanmakuAdv.booleanValue();
    }

    public void setAd(GdtAd gdtAd) {
        this.f109725ad = gdtAd;
    }

    public void setVideoData(GdtVideoData gdtVideoData) {
        this.videoData = gdtVideoData;
    }

    public void setWebUrl(String str) {
        this.webUrl = str;
    }
}
