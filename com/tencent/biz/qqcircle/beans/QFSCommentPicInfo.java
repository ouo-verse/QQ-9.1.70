package com.tencent.biz.qqcircle.beans;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.biz.qqcircle.utils.ct;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StImage;
import feedcloud.FeedCloudMeta$StReply;
import java.io.Serializable;

/* loaded from: classes4.dex */
public class QFSCommentPicInfo implements Serializable, Parcelable {
    public static final Parcelable.Creator<QFSCommentPicInfo> CREATOR = new Parcelable.Creator<QFSCommentPicInfo>() { // from class: com.tencent.biz.qqcircle.beans.QFSCommentPicInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QFSCommentPicInfo createFromParcel(Parcel parcel) {
            return new QFSCommentPicInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public QFSCommentPicInfo[] newArray(int i3) {
            return new QFSCommentPicInfo[i3];
        }
    };
    private static final String TAG = "QFSCommentPicInfo";
    private static final long serialVersionUID = 1;
    private byte[] commentBytes;
    private int expressionSrc;
    private transient FeedCloudMeta$StImage mCacheImage;
    private String mCommentId;
    private String mFeedId;
    private byte[] mImageInfo;
    private boolean mIsEmojiPic;
    private String mReplyId;
    private byte[] replyBytes;

    public QFSCommentPicInfo(String str, String str2, String str3, FeedCloudMeta$StImage feedCloudMeta$StImage) {
        this.mFeedId = str;
        this.mCommentId = str2;
        this.mReplyId = str3;
        if (feedCloudMeta$StImage != null) {
            this.mImageInfo = feedCloudMeta$StImage.toByteArray();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int evaluateBytesLength() {
        byte[] bArr = this.commentBytes;
        int i3 = 0;
        if (bArr != null) {
            i3 = 0 + bArr.length;
        }
        byte[] bArr2 = this.replyBytes;
        if (bArr2 != null) {
            i3 += bArr2.length;
        }
        byte[] bArr3 = this.mImageInfo;
        if (bArr3 != null) {
            return i3 + bArr3.length;
        }
        return i3;
    }

    public FeedCloudMeta$StComment getComment() {
        if (this.commentBytes != null) {
            FeedCloudMeta$StComment feedCloudMeta$StComment = new FeedCloudMeta$StComment();
            try {
                feedCloudMeta$StComment.mergeFrom(this.commentBytes);
                return feedCloudMeta$StComment;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "[getComment] ", e16);
                return null;
            }
        }
        return null;
    }

    public String getCommentId() {
        return this.mCommentId;
    }

    public String getExpressionSrcString() {
        int i3 = this.expressionSrc;
        if (i3 == 10002) {
            return QCircleDaTongConstant.ElementParamValue.XSJ_CMT_TYPE_ASSOCIATE_EMOJI;
        }
        if (i3 == 10001) {
            return QCircleDaTongConstant.ElementParamValue.XSJ_CMT_TYPE_COLLECT_EMOJI;
        }
        return "";
    }

    public String getFavEmojiUrl() {
        FeedCloudMeta$StImage image = getImage();
        if (image == null) {
            return "";
        }
        return ct.c(image);
    }

    public String getFeedId() {
        return this.mFeedId;
    }

    public FeedCloudMeta$StImage getImage() {
        FeedCloudMeta$StImage feedCloudMeta$StImage = this.mCacheImage;
        if (feedCloudMeta$StImage != null) {
            return feedCloudMeta$StImage;
        }
        FeedCloudMeta$StImage feedCloudMeta$StImage2 = new FeedCloudMeta$StImage();
        try {
            byte[] bArr = this.mImageInfo;
            if (bArr != null && bArr.length > 0) {
                feedCloudMeta$StImage2.mergeFrom(bArr);
                this.mCacheImage = feedCloudMeta$StImage2;
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "[getImage] error:" + e16);
        }
        return this.mCacheImage;
    }

    public FeedCloudMeta$StReply getReply() {
        if (this.replyBytes != null) {
            FeedCloudMeta$StReply feedCloudMeta$StReply = new FeedCloudMeta$StReply();
            try {
                feedCloudMeta$StReply.mergeFrom(this.replyBytes);
                return feedCloudMeta$StReply;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "[getReply] ", e16);
                return null;
            }
        }
        return null;
    }

    public String getReplyId() {
        return this.mReplyId;
    }

    public boolean hasMaskPic() {
        FeedCloudMeta$StImage image = getImage();
        if (image == null) {
            return false;
        }
        return ct.a(image);
    }

    public boolean isEmojiPic() {
        return this.mIsEmojiPic;
    }

    public void setComment(FeedCloudMeta$StComment feedCloudMeta$StComment) {
        if (feedCloudMeta$StComment != null) {
            this.commentBytes = feedCloudMeta$StComment.toByteArray();
        }
    }

    public void setEmojiPic(boolean z16) {
        this.mIsEmojiPic = z16;
    }

    public void setExpressionSrc(int i3) {
        this.expressionSrc = i3;
    }

    public void setReply(FeedCloudMeta$StReply feedCloudMeta$StReply) {
        if (feedCloudMeta$StReply != null) {
            this.replyBytes = feedCloudMeta$StReply.toByteArray();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mFeedId);
        parcel.writeString(this.mCommentId);
        parcel.writeString(this.mReplyId);
        parcel.writeByte(this.mIsEmojiPic ? (byte) 1 : (byte) 0);
        parcel.writeByteArray(this.mImageInfo);
        parcel.writeInt(this.expressionSrc);
        parcel.writeByteArray(this.commentBytes);
        parcel.writeByteArray(this.replyBytes);
    }

    public QFSCommentPicInfo(FeedCloudMeta$StImage feedCloudMeta$StImage) {
        if (feedCloudMeta$StImage != null) {
            this.mImageInfo = feedCloudMeta$StImage.toByteArray();
        }
    }

    protected QFSCommentPicInfo(Parcel parcel) {
        this.mFeedId = parcel.readString();
        this.mCommentId = parcel.readString();
        this.mReplyId = parcel.readString();
        this.mIsEmojiPic = parcel.readByte() != 0;
        this.mImageInfo = parcel.createByteArray();
        this.expressionSrc = parcel.readInt();
        this.commentBytes = parcel.createByteArray();
        this.replyBytes = parcel.createByteArray();
    }
}
