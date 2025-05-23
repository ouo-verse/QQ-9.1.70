package com.tencent.gdtad.views.video;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.aditem.GdtAd;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtVideoData implements Serializable {

    /* renamed from: ad, reason: collision with root package name */
    @Nullable
    private GdtAd f109682ad;
    private String coverURL;
    private boolean forceNotShowControllerView;
    private String url;
    private String vid;
    private long durationMillis = 0;
    private long startPositionMillis = 0;
    private boolean loop = true;
    private int playScene = -1;
    private boolean directPlay = false;
    private boolean visibleDirectPlay = false;
    private int videoDefaultBackgroundColor = -16777216;
    private boolean needReport = true;
    private boolean isVolumOpen = true;

    public GdtVideoData() {
    }

    @Nullable
    public GdtAd getAd() {
        return this.f109682ad;
    }

    public String getCoverUrl() {
        return this.coverURL;
    }

    public long getDurationMillis() {
        return this.durationMillis;
    }

    public int getPlayScene() {
        return this.playScene;
    }

    public long getStartPositionMillis() {
        return this.startPositionMillis;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVid() {
        return this.vid;
    }

    public int getVideoDefaultBackgroundColor() {
        return this.videoDefaultBackgroundColor;
    }

    public boolean isDirectPlay() {
        return this.directPlay;
    }

    public boolean isForceNotShowControllerView() {
        return this.forceNotShowControllerView;
    }

    public boolean isLoop() {
        return this.loop;
    }

    public boolean isValid() {
        GdtAd gdtAd;
        if (TextUtils.isEmpty(getUrl()) && ((gdtAd = this.f109682ad) == null || TextUtils.isEmpty(gdtAd.getTencent_video_id()))) {
            return false;
        }
        return true;
    }

    public boolean isVisibleDirectPlay() {
        return this.visibleDirectPlay;
    }

    public boolean isVolumOpen() {
        return this.isVolumOpen;
    }

    public boolean needReport() {
        return this.needReport;
    }

    public void setAd(@Nullable GdtAd gdtAd) {
        if (gdtAd != null) {
            this.f109682ad = gdtAd;
        }
    }

    public void setCoverUrl(String str) {
        this.coverURL = str;
    }

    public void setDirectPlay(boolean z16) {
        this.directPlay = z16;
    }

    public void setDurationMillis(long j3) {
        this.durationMillis = j3;
    }

    public void setForceNotShowControllerView(boolean z16) {
        this.forceNotShowControllerView = z16;
    }

    public void setLoop(boolean z16) {
        this.loop = z16;
    }

    public void setNeedReport(boolean z16) {
        this.needReport = z16;
    }

    public void setPlayScene(int i3) {
        this.playScene = i3;
    }

    public void setStartPositionMillis(long j3) {
        this.startPositionMillis = j3;
    }

    public void setUrl(@NonNull String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.startsWith("https")) {
                this.url = str.replaceFirst("https", "http");
            } else if (str.startsWith("HTTPS")) {
                this.url = str.replaceFirst("HTTPS", "http");
            } else {
                this.url = str;
            }
        }
    }

    public void setVid(String str) {
        this.vid = str;
    }

    public void setVideoDefaultBackgroundColor(int i3) {
        this.videoDefaultBackgroundColor = i3;
    }

    public void setVisibleDirectPlay(boolean z16) {
        this.visibleDirectPlay = z16;
    }

    public void setVolumOpen(boolean z16) {
        this.isVolumOpen = z16;
    }

    public GdtVideoData(GdtVideoData gdtVideoData) {
        setAd(gdtVideoData.getAd());
        setUrl(gdtVideoData.getUrl());
        setVid(gdtVideoData.getVid());
        setCoverUrl(gdtVideoData.getCoverUrl());
        setDirectPlay(gdtVideoData.isDirectPlay());
        setVisibleDirectPlay(gdtVideoData.isVisibleDirectPlay());
        setDurationMillis(gdtVideoData.getDurationMillis());
        setLoop(gdtVideoData.isLoop());
        setForceNotShowControllerView(gdtVideoData.isForceNotShowControllerView());
        setNeedReport(gdtVideoData.needReport());
        setPlayScene(gdtVideoData.getPlayScene());
        setStartPositionMillis(gdtVideoData.getStartPositionMillis());
        setVideoDefaultBackgroundColor(gdtVideoData.getVideoDefaultBackgroundColor());
        setVolumOpen(gdtVideoData.isVolumOpen());
    }
}
