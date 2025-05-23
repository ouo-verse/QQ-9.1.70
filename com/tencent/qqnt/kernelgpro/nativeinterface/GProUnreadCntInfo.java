package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProUnreadCntInfo {
    public GProUnreadCnt allUnreadCnt;
    public GProUnreadCnt atallUnreadCnt;
    public GProUnreadCnt atmeUnreadCnt;
    public byte[] headerUrl;
    public GProGuildGroupOptType lastRelatedToFeedType;
    public int lastRelatedToMeType;
    public GProContact peer;
    public int relatedToMeCnt;
    public String relatedToMeString;
    public long relatedToMeStringTime;
    public GProUnreadCnt showUnreadCnt;

    public GProUnreadCntInfo() {
        this.showUnreadCnt = new GProUnreadCnt();
        this.allUnreadCnt = new GProUnreadCnt();
        this.atmeUnreadCnt = new GProUnreadCnt();
        this.atallUnreadCnt = new GProUnreadCnt();
        this.peer = new GProContact();
        this.relatedToMeString = "";
        this.lastRelatedToFeedType = GProGuildGroupOptType.values()[0];
        this.headerUrl = new byte[0];
    }

    public GProUnreadCnt getAllUnreadCnt() {
        return this.allUnreadCnt;
    }

    public GProUnreadCnt getAtallUnreadCnt() {
        return this.atallUnreadCnt;
    }

    public GProUnreadCnt getAtmeUnreadCnt() {
        return this.atmeUnreadCnt;
    }

    public byte[] getHeaderUrl() {
        return this.headerUrl;
    }

    public GProGuildGroupOptType getLastRelatedToFeedType() {
        return this.lastRelatedToFeedType;
    }

    public int getLastRelatedToMeType() {
        return this.lastRelatedToMeType;
    }

    public GProContact getPeer() {
        return this.peer;
    }

    public int getRelatedToMeCnt() {
        return this.relatedToMeCnt;
    }

    public String getRelatedToMeString() {
        return this.relatedToMeString;
    }

    public long getRelatedToMeStringTime() {
        return this.relatedToMeStringTime;
    }

    public GProUnreadCnt getShowUnreadCnt() {
        return this.showUnreadCnt;
    }

    public String toString() {
        return "GProUnreadCntInfo{showUnreadCnt=" + this.showUnreadCnt + ",allUnreadCnt=" + this.allUnreadCnt + ",atmeUnreadCnt=" + this.atmeUnreadCnt + ",atallUnreadCnt=" + this.atallUnreadCnt + ",peer=" + this.peer + ",relatedToMeString=" + this.relatedToMeString + ",relatedToMeCnt=" + this.relatedToMeCnt + ",lastRelatedToMeType=" + this.lastRelatedToMeType + ",relatedToMeStringTime=" + this.relatedToMeStringTime + ",lastRelatedToFeedType=" + this.lastRelatedToFeedType + ",headerUrl=" + this.headerUrl + ",}";
    }

    public GProUnreadCntInfo(GProUnreadCnt gProUnreadCnt, GProUnreadCnt gProUnreadCnt2, GProUnreadCnt gProUnreadCnt3, GProUnreadCnt gProUnreadCnt4, GProContact gProContact, String str, int i3, int i16, long j3, GProGuildGroupOptType gProGuildGroupOptType, byte[] bArr) {
        this.showUnreadCnt = new GProUnreadCnt();
        this.allUnreadCnt = new GProUnreadCnt();
        this.atmeUnreadCnt = new GProUnreadCnt();
        this.atallUnreadCnt = new GProUnreadCnt();
        this.peer = new GProContact();
        this.relatedToMeString = "";
        GProGuildGroupOptType gProGuildGroupOptType2 = GProGuildGroupOptType.values()[0];
        this.showUnreadCnt = gProUnreadCnt;
        this.allUnreadCnt = gProUnreadCnt2;
        this.atmeUnreadCnt = gProUnreadCnt3;
        this.atallUnreadCnt = gProUnreadCnt4;
        this.peer = gProContact;
        this.relatedToMeString = str;
        this.relatedToMeCnt = i3;
        this.lastRelatedToMeType = i16;
        this.relatedToMeStringTime = j3;
        this.lastRelatedToFeedType = gProGuildGroupOptType;
        this.headerUrl = bArr;
    }
}
