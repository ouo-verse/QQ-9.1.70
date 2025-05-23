package com.tencent.biz.qqcircle.beans;

import android.text.TextUtils;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import java.net.URLEncoder;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QCircleEvilReportInfo {
    public String appid;
    public String appname;
    public String buddyflag;
    public String contentid;
    public String eviluinType;
    public String eviluind;
    public String isAnonymous;
    public String scene;
    public String subapp;
    public String system;
    public String textEvidence;
    public String uintyped;
    public String versiond;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class Builder {
        public String system = "android";
        public String versiond = QCircleHostConstants._AppSetting.getVersion();
        public String uintyped = "1";
        public String appname = "KQQ";
        public String appid = "2400002";
        public String subapp = "";
        public String scene = "";
        public String eviluind = "";
        public String eviluinType = "";
        public String isAnonymous = "1";
        public String buddyflag = "0";
        public String contentid = "";
        public String cryptoVersion = "";
        public String textEvidence = "";

        public QCircleEvilReportInfo build() {
            return new QCircleEvilReportInfo(this);
        }

        public Builder setAppid(String str) {
            this.appid = str;
            return this;
        }

        public Builder setAppname(String str) {
            this.appname = str;
            return this;
        }

        public Builder setBuddyflag(String str) {
            this.buddyflag = str;
            return this;
        }

        public Builder setContentid(String str) {
            this.contentid = str;
            return this;
        }

        public Builder setCryptoVersion(String str) {
            this.cryptoVersion = str;
            return this;
        }

        public Builder setEviluinType(String str) {
            this.eviluinType = str;
            return this;
        }

        public Builder setEviluind(String str) {
            this.eviluind = str;
            return this;
        }

        public Builder setIsAnonymous(String str) {
            this.isAnonymous = str;
            return this;
        }

        public Builder setScene(String str) {
            this.scene = str;
            return this;
        }

        public Builder setSubapp(String str) {
            this.subapp = str;
            return this;
        }

        public Builder setSystem(String str) {
            this.system = str;
            return this;
        }

        public Builder setTextEvidence(String str) {
            this.textEvidence = str;
            return this;
        }

        public Builder setUintyped(String str) {
            this.uintyped = str;
            return this;
        }

        public Builder setVersiond(String str) {
            this.versiond = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class ContentIdBuilder {
        public String accountType;
        public String barrageId;
        public String commentId;
        public String createTime;
        public String feedId;
        public String posterId;
        public String replyId;
        public String tagName;

        public String getContentId() {
            StringBuilder sb5 = new StringBuilder();
            if (!TextUtils.isEmpty(this.feedId)) {
                sb5.append("feed_id=");
                sb5.append(this.feedId);
                sb5.append("|");
            }
            if (!TextUtils.isEmpty(this.createTime)) {
                sb5.append("ctim=");
                sb5.append(this.createTime);
                sb5.append("|");
            }
            if (!TextUtils.isEmpty(this.posterId)) {
                sb5.append("poster_id=");
                sb5.append(this.posterId);
                sb5.append("|");
            }
            if (!TextUtils.isEmpty(this.commentId)) {
                sb5.append("comment_id=");
                sb5.append(this.commentId);
                sb5.append("|");
            }
            if (!TextUtils.isEmpty(this.replyId)) {
                sb5.append("reply_id=");
                sb5.append(this.replyId);
                sb5.append("|");
            }
            if (!TextUtils.isEmpty(this.tagName)) {
                sb5.append("tag_name=");
                sb5.append(URLEncoder.encode(this.tagName));
                sb5.append("|");
            }
            if (!TextUtils.isEmpty(this.barrageId)) {
                sb5.append("barrage_id=");
                sb5.append(this.barrageId);
                sb5.append("|");
            }
            if (!TextUtils.isEmpty(this.accountType)) {
                sb5.append("account_type=");
                sb5.append(URLEncoder.encode(this.accountType));
                sb5.append("|");
            }
            sb5.deleteCharAt(sb5.length() - 1);
            return sb5.toString();
        }

        public ContentIdBuilder setAccount_Type(String str) {
            this.accountType = str;
            return this;
        }

        public ContentIdBuilder setBarrageId(String str) {
            this.barrageId = str;
            return this;
        }

        public ContentIdBuilder setCommentId(String str) {
            this.commentId = str;
            return this;
        }

        public ContentIdBuilder setCreateTime(String str) {
            this.createTime = str;
            return this;
        }

        public ContentIdBuilder setFeedId(String str) {
            this.feedId = str;
            return this;
        }

        public ContentIdBuilder setPosterId(String str) {
            this.posterId = str;
            return this;
        }

        public ContentIdBuilder setReplyId(String str) {
            this.replyId = str;
            return this;
        }

        public ContentIdBuilder setTagName(String str) {
            this.tagName = str;
            return this;
        }
    }

    QCircleEvilReportInfo(Builder builder) {
        this.system = builder.system;
        this.versiond = builder.versiond;
        this.uintyped = builder.uintyped;
        this.appname = builder.appname;
        this.appid = builder.appid;
        this.subapp = builder.subapp;
        this.scene = builder.scene;
        this.eviluind = builder.eviluind;
        this.eviluinType = builder.eviluinType;
        this.isAnonymous = builder.isAnonymous;
        this.contentid = builder.contentid;
        this.buddyflag = builder.buddyflag;
        this.textEvidence = builder.textEvidence;
    }
}
