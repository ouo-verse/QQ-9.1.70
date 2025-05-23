package com.tencent.gdtad.basics.motivevideo.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.video.GdtVideoData;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtMotiveVideoModel {
    private static final String TAG = "GdtMotiveVideoModel";

    @Nullable
    private qq_ad_get.QQAdGetRsp.AdInfo mAdInfo;

    @Nullable
    private GdtAd mGdtAd;
    private GdtMotiveVideoPageData mGdtMotiveVideoPageData;
    private GdtVideoData mGdtVideoData;

    public GdtMotiveVideoModel(@Nullable GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        GdtLog.d(TAG, "[GdtMotiveVideoModel]\n" + gdtMotiveVideoPageData.adsContent);
        this.mGdtMotiveVideoPageData = gdtMotiveVideoPageData;
        initAdInfo(gdtMotiveVideoPageData);
        initVideoData(gdtMotiveVideoPageData);
    }

    private void initAdInfo(@NonNull GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        if (TextUtils.isEmpty(gdtMotiveVideoPageData.adsContent)) {
            GdtLog.e(TAG, "[adJson==null error]");
            return;
        }
        try {
            this.mAdInfo = (qq_ad_get.QQAdGetRsp.AdInfo) qq_ad_get.QQAdGetRsp.AdInfo.class.cast(GdtJsonPbUtil.pbFromJson(new qq_ad_get.QQAdGetRsp.AdInfo(), new JSONObject(gdtMotiveVideoPageData.adsContent)));
        } catch (Throwable th5) {
            GdtLog.e(TAG, "GdtMotiveVideoModel error]", th5);
        }
    }

    private void initVideoData(@NonNull GdtMotiveVideoPageData gdtMotiveVideoPageData) {
        this.mGdtAd = new GdtAd(this.mAdInfo);
        GdtVideoData gdtVideoData = new GdtVideoData();
        this.mGdtVideoData = gdtVideoData;
        gdtVideoData.setAd(this.mGdtAd);
        this.mGdtVideoData.setPlayScene(11);
        this.mGdtVideoData.setUrl(gdtMotiveVideoPageData.url);
    }

    public boolean canShowCustomDialog() {
        GdtAd gdtAd = this.mGdtAd;
        if (gdtAd != null && gdtAd.canShowCustomDialog()) {
            return true;
        }
        return false;
    }

    @Nullable
    public qq_ad_get.QQAdGetRsp.AdInfo getAdInfo() {
        return this.mAdInfo;
    }

    @Nullable
    public GdtAd getGdtAd() {
        return this.mGdtAd;
    }

    public GdtMotiveVideoPageData getGdtMotiveVideoPageData() {
        return this.mGdtMotiveVideoPageData;
    }

    public GdtVideoData getGdtVideoData() {
        return this.mGdtVideoData;
    }
}
