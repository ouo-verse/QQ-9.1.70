package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAGetPhotoListReq {
    public boolean canReadCache;
    public boolean enableCache;
    public boolean needPos;
    public int scene;
    public int seq;
    public int sortType;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public StUser owner = new StUser();
    public String albumId = "";
    public String attachInfo = "";
    public String curLloc = "";
    public String reqUrl = "";
    public StUser sharer = new StUser();
    public AlbumQuestion questionAnswer = new AlbumQuestion();

    public String getAlbumId() {
        return this.albumId;
    }

    public String getAttachInfo() {
        return this.attachInfo;
    }

    public boolean getCanReadCache() {
        return this.canReadCache;
    }

    public String getCurLloc() {
        return this.curLloc;
    }

    public boolean getEnableCache() {
        return this.enableCache;
    }

    public boolean getNeedPos() {
        return this.needPos;
    }

    public StUser getOwner() {
        return this.owner;
    }

    public AlbumQuestion getQuestionAnswer() {
        return this.questionAnswer;
    }

    public String getReqUrl() {
        return this.reqUrl;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getScene() {
        return this.scene;
    }

    public int getSeq() {
        return this.seq;
    }

    public StUser getSharer() {
        return this.sharer;
    }

    public int getSortType() {
        return this.sortType;
    }
}
