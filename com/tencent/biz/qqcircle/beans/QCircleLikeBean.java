package com.tencent.biz.qqcircle.beans;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import feedcloud.FeedCloudCommon$BytesEntry;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleLikeBean extends QCircleInitBean {
    private List<byte[]> busiTranparentList = new ArrayList();
    private String commentId;
    private int count;
    private String likeId;
    private int noticeType;
    private String replyId;
    private int requestType;
    private long time;

    public List<FeedCloudCommon$BytesEntry> getBusiTranparent() {
        ArrayList arrayList = new ArrayList();
        List<byte[]> list = this.busiTranparentList;
        if (list != null) {
            for (byte[] bArr : list) {
                if (bArr != null) {
                    FeedCloudCommon$BytesEntry feedCloudCommon$BytesEntry = new FeedCloudCommon$BytesEntry();
                    try {
                        feedCloudCommon$BytesEntry.mergeFrom(bArr);
                        arrayList.add(feedCloudCommon$BytesEntry);
                    } catch (InvalidProtocolBufferMicroException e16) {
                        e16.printStackTrace();
                    }
                }
            }
        }
        return arrayList;
    }

    public String getCommentId() {
        return this.commentId;
    }

    public int getCount() {
        return this.count;
    }

    public String getLikeId() {
        return this.likeId;
    }

    public int getNoticeType() {
        return this.noticeType;
    }

    public String getReplyId() {
        return this.replyId;
    }

    public int getRequestType() {
        return this.requestType;
    }

    public long getTime() {
        return this.time;
    }

    public void setBusiTranparentList(List<byte[]> list) {
        this.busiTranparentList.clear();
        this.busiTranparentList.addAll(list);
    }

    public void setCommentId(String str) {
        this.commentId = str;
    }

    public void setCount(int i3) {
        this.count = i3;
    }

    public void setLikeId(String str) {
        this.likeId = str;
    }

    public void setNoticeType(int i3) {
        this.noticeType = i3;
    }

    public void setReplyId(String str) {
        this.replyId = str;
    }

    public void setRequestType(int i3) {
        this.requestType = i3;
    }

    public void setTime(long j3) {
        this.time = j3;
    }
}
