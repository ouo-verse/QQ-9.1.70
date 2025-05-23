package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PAVerifyAlbumQuestionReq {
    public int seq;
    public RequestTimelineInfo requestTimeLine = new RequestTimelineInfo();
    public String albumId = "";
    public AlbumQuestion questionAnswer = new AlbumQuestion();
    public StUser albumOwner = new StUser();

    public String getAlbumId() {
        return this.albumId;
    }

    public StUser getAlbumOwner() {
        return this.albumOwner;
    }

    public AlbumQuestion getQuestionAnswer() {
        return this.questionAnswer;
    }

    public RequestTimelineInfo getRequestTimeLine() {
        return this.requestTimeLine;
    }

    public int getSeq() {
        return this.seq;
    }
}
