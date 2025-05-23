package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.smtt.sdk.stat.MttLoader;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProStGetFeedCommentsReq {
    public int from;
    public int listNum;
    public int rankingType;
    public int replyListNum;
    public GProStCommonExt extInfo = new GProStCommonExt();
    public String userId = "";
    public String feedId = "";
    public String attchInfo = "";
    public String entrySchema = "";
    public String needInsertCommentID = "";
    public String needInsertReplyID = "";
    public GProStChannelSign channelSign = new GProStChannelSign();
    public ArrayList<GProStComment> needInsertCommentList = new ArrayList<>();

    public String getAttchInfo() {
        return this.attchInfo;
    }

    public GProStChannelSign getChannelSign() {
        return this.channelSign;
    }

    public String getEntrySchema() {
        return this.entrySchema;
    }

    public GProStCommonExt getExtInfo() {
        return this.extInfo;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public int getFrom() {
        return this.from;
    }

    public int getListNum() {
        return this.listNum;
    }

    public String getNeedInsertCommentID() {
        return this.needInsertCommentID;
    }

    public ArrayList<GProStComment> getNeedInsertCommentList() {
        return this.needInsertCommentList;
    }

    public String getNeedInsertReplyID() {
        return this.needInsertReplyID;
    }

    public int getRankingType() {
        return this.rankingType;
    }

    public int getReplyListNum() {
        return this.replyListNum;
    }

    public String getUserId() {
        return this.userId;
    }

    public String toString() {
        return "GProStGetFeedCommentsReq{extInfo=" + this.extInfo + ",userId=" + this.userId + ",feedId=" + this.feedId + ",listNum=" + this.listNum + MttLoader.QQBROWSER_PARAMS_FROME + this.from + ",attchInfo=" + this.attchInfo + ",entrySchema=" + this.entrySchema + ",needInsertCommentID=" + this.needInsertCommentID + ",needInsertReplyID=" + this.needInsertReplyID + ",channelSign=" + this.channelSign + ",rankingType=" + this.rankingType + ",replyListNum=" + this.replyListNum + ",needInsertCommentList=" + this.needInsertCommentList + ",}";
    }
}
