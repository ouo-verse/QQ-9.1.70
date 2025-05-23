package com.tencent.biz.qqcircle.beans;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.comment.effect.d;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StReply;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSCommentItemInfo extends QFSCommentOrReplyActionBean {
    public FeedCloudMeta$StComment comment;
    public int fakeReplyPos;
    private String mFastCommentText;
    public List<QFSReplyItemInfo> replyItemList;
    public int type;

    public QFSCommentItemInfo(int i3) {
        this.type = i3;
    }

    public QFSReplyItemInfo addFakeReply(String str, FeedCloudMeta$StReply feedCloudMeta$StReply, d dVar) {
        int i3;
        this.comment.replyCount.set(this.comment.replyCount.get() + 1);
        List<FeedCloudMeta$StReply> list = this.comment.vecReply.get();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i17 < list.size()) {
                FeedCloudMeta$StReply feedCloudMeta$StReply2 = list.get(i17);
                if (feedCloudMeta$StReply2 != null && TextUtils.equals(feedCloudMeta$StReply2.f398460id.get(), str)) {
                    i3 = i17 + 1;
                    break;
                }
                i17++;
            } else {
                i3 = 0;
                break;
            }
        }
        list.add(i3, feedCloudMeta$StReply);
        if (this.replyItemList == null) {
            this.replyItemList = new ArrayList();
        }
        QFSReplyItemInfo qFSReplyItemInfo = new QFSReplyItemInfo(5, feedCloudMeta$StReply, 0);
        int i18 = 0;
        while (true) {
            if (i18 < this.replyItemList.size()) {
                FeedCloudMeta$StReply feedCloudMeta$StReply3 = this.replyItemList.get(i18).reply;
                if (feedCloudMeta$StReply3 != null && TextUtils.equals(feedCloudMeta$StReply3.f398460id.get(), str)) {
                    i16 = i18 + 1;
                    break;
                }
                i18++;
            } else {
                break;
            }
        }
        this.fakeReplyPos = i16;
        this.replyItemList.add(i16, qFSReplyItemInfo);
        qFSReplyItemInfo.mEffectBean = dVar;
        return qFSReplyItemInfo;
    }

    public void addReplyItemInfo(int i3) {
        addReplyItemInfo(i3, null, 0);
    }

    public String getFastCommentText() {
        return this.mFastCommentText;
    }

    public void removeReplyItemInfo(String str, int i3) {
        if (this.replyItemList == null) {
            return;
        }
        int i16 = 0;
        while (true) {
            if (i16 >= this.replyItemList.size()) {
                break;
            }
            if (this.replyItemList.get(i16).reply != null && str.equals(this.replyItemList.get(i16).reply.f398460id.get())) {
                this.replyItemList.remove(i16);
                break;
            }
            i16++;
        }
        for (int i17 = 0; i17 < this.replyItemList.size(); i17++) {
            if (this.replyItemList.get(i17).type == 6 && i17 < i3 && this.replyItemList.get(i17).moreNum > 0 && i17 < this.comment.vecReply.size()) {
                this.replyItemList.add(i17, new QFSReplyItemInfo(5, this.comment.vecReply.get(i17).get()));
                int i18 = i17 + 1;
                if (this.replyItemList.get(i18).moreNum - 1 == 0) {
                    this.replyItemList.remove(i18);
                } else {
                    QFSReplyItemInfo qFSReplyItemInfo = this.replyItemList.get(i18);
                    qFSReplyItemInfo.moreNum--;
                }
            }
        }
    }

    public void setFastCommentText(String str) {
        this.mFastCommentText = str;
    }

    public void updateReplyItemInfo(String str, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        List<QFSReplyItemInfo> list = this.replyItemList;
        if (list == null) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            if (this.replyItemList.get(size).reply != null && str.equals(this.replyItemList.get(size).reply.f398460id.get())) {
                this.replyItemList.get(size).reply = feedCloudMeta$StReply;
                return;
            }
        }
    }

    public void addReplyItemInfo(int i3, int i16) {
        addReplyItemInfo(i3, null, i16);
    }

    public QFSCommentItemInfo(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        this.comment = feedCloudMeta$StComment;
    }

    public void addReplyItemInfo(int i3, FeedCloudMeta$StReply feedCloudMeta$StReply) {
        addReplyItemInfo(i3, feedCloudMeta$StReply, 0);
    }

    @NonNull
    public QFSReplyItemInfo addReplyItemInfo(int i3, FeedCloudMeta$StReply feedCloudMeta$StReply, int i16) {
        if (this.replyItemList == null) {
            this.replyItemList = new ArrayList();
        }
        QFSReplyItemInfo qFSReplyItemInfo = new QFSReplyItemInfo(i3, feedCloudMeta$StReply, i16);
        int size = this.replyItemList.size() - 1;
        if (i3 == 5 && this.replyItemList.size() > 0 && this.replyItemList.get(size).type != 5) {
            this.replyItemList.add(size, qFSReplyItemInfo);
        } else {
            this.replyItemList.add(qFSReplyItemInfo);
        }
        return qFSReplyItemInfo;
    }

    public QFSCommentItemInfo(FeedCloudMeta$StComment feedCloudMeta$StComment, d dVar) {
        this.comment = feedCloudMeta$StComment;
        this.mEffectBean = dVar;
    }
}
