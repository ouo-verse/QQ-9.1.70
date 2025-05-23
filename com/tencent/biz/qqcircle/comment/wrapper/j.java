package com.tencent.biz.qqcircle.comment.wrapper;

import android.text.TextUtils;
import android.util.Size;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.beans.QFSReplyItemInfo;
import com.tencent.biz.richframework.part.utils.RFSafeListUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StImageUrl;

/* compiled from: P */
/* loaded from: classes4.dex */
public class j extends h<QFSReplyItemInfo> {
    public j(@NonNull View view) {
        super(view);
    }

    @Override // com.tencent.biz.qqcircle.comment.wrapper.h
    protected int k() {
        return R.id.f520229o;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.comment.wrapper.h
    protected String l() {
        T t16 = this.f84148b;
        if (t16 != 0 && ((QFSReplyItemInfo) t16).reply != null && ((QFSReplyItemInfo) t16).reply.replyPic != null) {
            return ((QFSReplyItemInfo) t16).reply.replyPic.picUrl.get();
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.comment.wrapper.h
    protected Size m() {
        T t16 = this.f84148b;
        if (t16 != 0 && ((QFSReplyItemInfo) t16).reply != null && ((QFSReplyItemInfo) t16).reply.replyPic != null) {
            return new Size(((QFSReplyItemInfo) t16).reply.replyPic.width.get(), ((QFSReplyItemInfo) this.f84148b).reply.replyPic.height.get());
        }
        return new Size(0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.comment.wrapper.h
    protected String n() {
        T t16 = this.f84148b;
        if (t16 != 0 && ((QFSReplyItemInfo) t16).reply != null && ((QFSReplyItemInfo) t16).reply.replyPic != null) {
            if (RFSafeListUtils.isEmpty(((QFSReplyItemInfo) t16).reply.replyPic.vecImageUrl.get())) {
                return ((QFSReplyItemInfo) this.f84148b).reply.replyPic.picUrl.get();
            }
            for (FeedCloudMeta$StImageUrl feedCloudMeta$StImageUrl : ((QFSReplyItemInfo) this.f84148b).reply.replyPic.vecImageUrl.get()) {
                if (feedCloudMeta$StImageUrl.levelType.get() == 1) {
                    QLog.d("CommentPicTag", 1, "getReplySmallPicUrl");
                    return feedCloudMeta$StImageUrl.url.get();
                }
            }
            return ((QFSReplyItemInfo) this.f84148b).reply.replyPic.picUrl.get();
        }
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.qqcircle.comment.wrapper.h
    protected void v(String str) {
        T t16 = this.f84148b;
        if (t16 != 0 && ((QFSReplyItemInfo) t16).reply != null && ((QFSReplyItemInfo) t16).reply.replyPic != null && !TextUtils.isEmpty(str)) {
            ((QFSReplyItemInfo) this.f84148b).reply.replyPic.picUrl.set(str);
        }
    }
}
