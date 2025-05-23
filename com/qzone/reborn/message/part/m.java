package com.qzone.reborn.message.part;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import bl.CommonNoticeBean;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.util.ToastUtil;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\t*\u0001\u0010\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\f\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/qzone/reborn/message/part/m;", "Lcom/qzone/reborn/base/k;", "Ldl/b;", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "comment", "", "D9", "C9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lbl/a;", "noticeBean", "F8", "com/qzone/reborn/message/part/m$b", "d", "Lcom/qzone/reborn/message/part/m$b;", "mHandler", "<init>", "()V", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class m extends com.qzone.reborn.base.k implements dl.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final b mHandler = new b(Looper.getMainLooper());

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/qzone/reborn/message/part/m$b", "Landroid/os/Handler;", "Landroid/os/Message;", "msg", "", "handleMessage", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public static final class b extends Handler {
        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            super.handleMessage(msg2);
            QZoneResult unpack = QZoneResult.unpack(msg2);
            if (unpack == null || unpack.what != 1000185 || unpack.getSucceed()) {
                return;
            }
            String message = unpack.getMessage();
            if (message == null || message.length() == 0) {
                return;
            }
            ToastUtil.s(unpack.getMessage(), 4);
        }
    }

    private final void C9(Comment comment) {
        if (comment.isliked) {
            LpReportInfo_pf00064.allReport(720, 3, 2);
        } else {
            LpReportInfo_pf00064.allReport(720, 3, 1);
        }
    }

    private final void D9(BusinessFeedData feedData, Comment comment) {
        QZoneWriteOperationService.k kVar = new QZoneWriteOperationService.k();
        kVar.f45701h = feedData.getFeedCommInfo().appid;
        kVar.f45702i = feedData.getOperationInfo().busiParam;
        kVar.f45697d = feedData.getFeedCommInfo().feedskey;
        kVar.f45696c = feedData.getFeedCommInfo().ugckey;
        kVar.f45698e = feedData.getFeedCommInfo().orglikekey;
        kVar.f45694a = feedData.getUser().uin;
        User user = comment.user;
        if (user != null) {
            kVar.f45699f = comment.commentLikekey + "/" + user.uin;
        } else {
            kVar.f45699f = comment.commentLikekey;
        }
        kVar.f45703j = comment.commentid;
        kVar.f45700g = !comment.isliked;
        kVar.f45695b = comment.user;
        kVar.f45705l = 0;
        kVar.f45706m = feedData.getFeedCommInfo().canCustomPraise() ? QzoneCustomPraiseService.i().g() : null;
        kVar.f45707n = 1;
        if (feedData.feedType == 4098) {
            comment.isliked = !comment.isliked;
        }
        QZoneWriteOperationService.v0().t1(this.mHandler, kVar);
    }

    @Override // dl.b
    public void F8(CommonNoticeBean noticeBean) {
        BusinessFeedData businessFeedData;
        bl.f notice;
        if (com.qzone.reborn.feedx.util.l.b("QZonePassiveMessageCommentLikePartonClickCommentLike" + getContext().hashCode(), 500L)) {
            return;
        }
        if (noticeBean == null || (notice = noticeBean.getNotice()) == null) {
            businessFeedData = null;
        } else {
            Object obj = notice.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.EXTRA_DATA java.lang.String();
            if (!(obj instanceof BusinessFeedData)) {
                obj = null;
            }
            businessFeedData = (BusinessFeedData) obj;
        }
        Comment mainComment = businessFeedData != null ? businessFeedData.getMainComment() : null;
        if (businessFeedData != null && mainComment != null) {
            String str = mainComment.commentid;
            if (!(str == null || str.length() == 0)) {
                String str2 = mainComment.commentLikekey;
                if (!(str2 == null || str2.length() == 0)) {
                    D9(businessFeedData, mainComment);
                    C9(mainComment);
                    return;
                }
            }
            RFWLog.e("QZonePassiveMessageCommentLikePart", RFWLog.USR, "[doCommentLike] comment data is invalid");
            return;
        }
        RFWLog.e("QZonePassiveMessageCommentLikePart", RFWLog.USR, "[doCommentLike] feedData or comment is null");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(View rootView) {
        super.onInitView(rootView);
        registerIoc(this, dl.b.class);
    }
}
