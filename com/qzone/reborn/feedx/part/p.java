package com.qzone.reborn.feedx.part;

import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.util.ToastUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes37.dex */
public class p extends g implements gf.d {
    protected int D9() {
        return 0;
    }

    @Override // gf.d
    public void P0(BusinessFeedData businessFeedData, Comment comment, Reply reply) {
        if (com.qzone.reborn.feedx.util.l.b("QZoneFeedxCommentLikePartonClickReplyLike" + getContext().hashCode(), 500L)) {
            return;
        }
        if (businessFeedData != null && comment != null && reply != null) {
            QZoneWriteOperationService.k kVar = new QZoneWriteOperationService.k();
            kVar.f45701h = businessFeedData.getFeedCommInfo().appid;
            kVar.f45702i = businessFeedData.getOperationInfo().busiParam;
            kVar.f45697d = businessFeedData.getFeedCommInfo().feedskey;
            kVar.f45696c = businessFeedData.getFeedCommInfo().ugckey;
            kVar.f45698e = businessFeedData.getFeedCommInfo().orglikekey;
            kVar.f45694a = businessFeedData.getUser().uin;
            kVar.f45704k = reply.replyId;
            kVar.f45699f = reply.replyLikeKey;
            kVar.f45703j = comment.commentid;
            kVar.f45700g = !reply.isliked;
            kVar.f45695b = reply.user;
            kVar.f45705l = 2;
            if (businessFeedData.getFeedCommInfo().canCustomPraise()) {
                kVar.f45706m = QzoneCustomPraiseService.i().g();
            }
            kVar.f45707n = 1;
            QZoneWriteOperationService.v0().v1(getMainHandler(), kVar);
            return;
        }
        QLog.e("QZoneFeedxCommentLikePart", 1, "onClickReplyLike  params error");
    }

    @Override // gf.d
    public void R6(BusinessFeedData businessFeedData, Comment comment) {
        if (com.qzone.reborn.feedx.util.l.b("QZoneFeedxCommentLikePartonClickCommentLike" + getContext().hashCode(), 500L)) {
            return;
        }
        if (businessFeedData != null && comment != null) {
            QZoneWriteOperationService.k kVar = new QZoneWriteOperationService.k();
            kVar.f45701h = businessFeedData.getFeedCommInfo().appid;
            kVar.f45702i = businessFeedData.getOperationInfo().busiParam;
            kVar.f45697d = businessFeedData.getFeedCommInfo().feedskey;
            kVar.f45696c = businessFeedData.getFeedCommInfo().ugckey;
            kVar.f45698e = businessFeedData.getFeedCommInfo().orglikekey;
            kVar.f45694a = businessFeedData.getUser().uin;
            if (comment.user != null) {
                kVar.f45699f = comment.commentLikekey + "/" + comment.user.uin;
            } else {
                kVar.f45699f = comment.commentLikekey;
            }
            kVar.f45703j = comment.commentid;
            kVar.f45700g = !comment.isliked;
            kVar.f45695b = comment.user;
            kVar.f45705l = D9();
            if (businessFeedData.getFeedCommInfo().canCustomPraise()) {
                kVar.f45706m = QzoneCustomPraiseService.i().g();
            }
            kVar.f45707n = 1;
            if (businessFeedData.feedType == 4098) {
                comment.isliked = !comment.isliked;
            }
            QZoneWriteOperationService.v0().t1(getMainHandler(), kVar);
            return;
        }
        QLog.e("QZoneFeedxCommentLikePart", 1, "onClickCommentLike  params error");
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null || unpack.what != 1000185 || unpack.getSucceed() || TextUtils.isEmpty(unpack.getMessage())) {
            return;
        }
        ToastUtil.r(unpack.getMessage());
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        registerIoc(this, gf.d.class);
    }
}
