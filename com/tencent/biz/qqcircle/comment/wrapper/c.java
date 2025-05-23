package com.tencent.biz.qqcircle.comment.wrapper;

import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSCommentItemInfo;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StImageUrl;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends h<QFSCommentItemInfo> {
    public c(@NonNull View view) {
        super(view);
    }

    @Override // com.tencent.biz.qqcircle.comment.wrapper.h
    protected int k() {
        return R.id.f360913m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.comment.wrapper.h
    protected String l() {
        T t16 = this.f84148b;
        if (t16 != 0 && ((QFSCommentItemInfo) t16).comment != null && ((QFSCommentItemInfo) t16).comment.commentPic != null) {
            return ((QFSCommentItemInfo) t16).comment.commentPic.picUrl.get();
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.comment.wrapper.h
    protected Size m() {
        T t16 = this.f84148b;
        if (t16 != 0 && ((QFSCommentItemInfo) t16).comment != null && ((QFSCommentItemInfo) t16).comment.commentPic != null) {
            return new Size(((QFSCommentItemInfo) t16).comment.commentPic.width.get(), ((QFSCommentItemInfo) this.f84148b).comment.commentPic.height.get());
        }
        return new Size(0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.comment.wrapper.h
    protected String n() {
        T t16 = this.f84148b;
        if (t16 != 0 && ((QFSCommentItemInfo) t16).comment != null && ((QFSCommentItemInfo) t16).comment.commentPic != null) {
            if (RFSafeListUtils.isEmpty(((QFSCommentItemInfo) t16).comment.commentPic.vecImageUrl.get())) {
                return ((QFSCommentItemInfo) this.f84148b).comment.commentPic.picUrl.get();
            }
            for (FeedCloudMeta$StImageUrl feedCloudMeta$StImageUrl : ((QFSCommentItemInfo) this.f84148b).comment.commentPic.vecImageUrl.get()) {
                if (feedCloudMeta$StImageUrl.levelType.get() == 1) {
                    QLog.d("CommentPicTag", 1, "getCommentSmallPicUrl");
                    return feedCloudMeta$StImageUrl.url.get();
                }
            }
            return ((QFSCommentItemInfo) this.f84148b).comment.commentPic.picUrl.get();
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.comment.wrapper.h
    protected void v(String str) {
        T t16 = this.f84148b;
        if (t16 != 0 && ((QFSCommentItemInfo) t16).comment != null && ((QFSCommentItemInfo) t16).comment.commentPic != null && !TextUtils.isEmpty(str)) {
            ((QFSCommentItemInfo) this.f84148b).comment.commentPic.picUrl.set(str);
        }
    }
}
