package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class PAGetAlbumListRsp {
    public boolean hasMore;
    public boolean isFromCache;
    public int result;
    public int seq;
    public String errMs = "";
    public String traceId = "";
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public ArrayList<AlbumInfo> albums = new ArrayList<>();
    public String attachInfo = "";
    public AlbumPageInfo pageInfo = new AlbumPageInfo();
    public PageEndMsg endMsg = new PageEndMsg();

    public ArrayList<AlbumInfo> getAlbums() {
        return this.albums;
    }

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public PageEndMsg getEndMsg() {
        return this.endMsg;
    }

    public String getErrMs() {
        return this.errMs;
    }

    public boolean getHasMore() {
        return this.hasMore;
    }

    public boolean getIsFromCache() {
        return this.isFromCache;
    }

    public AlbumPageInfo getPageInfo() {
        return this.pageInfo;
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

    public String getTraceId() {
        return this.traceId;
    }
}
