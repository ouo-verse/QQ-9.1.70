package com.tencent.gdtad.views.videoceiling;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoData;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtVideoCeilingData implements Serializable {

    /* renamed from: ad, reason: collision with root package name */
    @Nullable
    private GdtAd f109706ad;
    private int mActionCode = 0;
    private GdtVideoData videoData;
    private String webUrl;
    private String widthHeightRatio;

    public int getActionCode() {
        return this.mActionCode;
    }

    @Nullable
    public GdtAd getAd() {
        return this.f109706ad;
    }

    public GdtVideoData getVideoData() {
        return this.videoData;
    }

    public String getWebUrl() {
        return this.webUrl;
    }

    public String getWidthHeightRatio() {
        return this.widthHeightRatio;
    }

    public boolean isValid() {
        GdtVideoData gdtVideoData = this.videoData;
        if (gdtVideoData != null && gdtVideoData.isValid() && !TextUtils.isEmpty(this.webUrl)) {
            return true;
        }
        return false;
    }

    public void setActionCode(int i3) {
        this.mActionCode = i3;
    }

    public void setAd(@Nullable GdtAd gdtAd) {
        if (gdtAd == null) {
            return;
        }
        this.f109706ad = gdtAd;
        GdtVideoData gdtVideoData = this.videoData;
        if (gdtVideoData != null) {
            gdtVideoData.setAd(gdtAd);
        }
    }

    public void setVideoData(@NonNull GdtVideoData gdtVideoData) {
        this.videoData = gdtVideoData;
        gdtVideoData.setAd(this.f109706ad);
        this.videoData.setLoop(gdtVideoData.isLoop());
        this.videoData.setPlayScene(7);
    }

    public void setWebUrl(String str) {
        this.webUrl = str;
    }

    public void setWidthHeightRatio(String str) {
        this.widthHeightRatio = str;
    }
}
