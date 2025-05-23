package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAGetShareInfoRsp {
    public boolean isFromCache;
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public StShare share = new StShare();
    public ArrayList<Integer> buttons = new ArrayList<>();
    public AlbumInfo album = new AlbumInfo();
    public ArrayList<StMedia> medias = new ArrayList<>();

    public AlbumInfo getAlbum() {
        return this.album;
    }

    public ArrayList<Integer> getButtons() {
        return this.buttons;
    }

    public String getErrMs() {
        return this.errMs;
    }

    public boolean getIsFromCache() {
        return this.isFromCache;
    }

    public ArrayList<StMedia> getMedias() {
        return this.medias;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getResult() {
        return this.result;
    }

    public int getSeq() {
        return this.seq;
    }

    public StShare getShare() {
        return this.share;
    }

    public String getTraceId() {
        return this.traceId;
    }
}
