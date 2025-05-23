package com.qzone.detail.ui.component;

import android.os.Bundle;
import android.view.View;
import com.qzone.common.logic.presenter.BaseFeedPresenter;
import com.qzone.detail.ui.activity.QzoneCommentDetailActivity;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import java.lang.ref.WeakReference;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends FeedElementBaseClickListener {
    WeakReference<QzoneCommentDetailActivity> E;
    BusinessFeedData F;

    public d(QzoneCommentDetailActivity qzoneCommentDetailActivity, b bVar) {
        super(qzoneCommentDetailActivity, bVar);
        this.E = new WeakReference<>(qzoneCommentDetailActivity);
        this.F = bVar.T0().R();
    }

    @Override // com.qzone.detail.ui.component.FeedElementBaseClickListener
    protected void N(Object obj) {
        QzoneCommentDetailActivity qzoneCommentDetailActivity;
        if (obj instanceof User) {
            r6.a.o().j((User) obj);
            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(659, 3, 0), false, false);
        } else {
            if (!(obj instanceof Long) || (qzoneCommentDetailActivity = this.E.get()) == null) {
                return;
            }
            r6.a.K(qzoneCommentDetailActivity, ((Long) obj).longValue());
            LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(659, 4, 0), false, false);
        }
    }

    @Override // com.qzone.detail.ui.component.FeedElementBaseClickListener
    protected void e0(View view, Object obj) {
        List<Reply> list;
        Reply reply;
        List<Reply> list2;
        b bVar = this.f46969e.get();
        if (bVar == null) {
            return;
        }
        if (bVar.getAppid() == 334) {
            bVar.Pd();
            return;
        }
        Bundle bundle = (Bundle) obj;
        int i3 = bundle.getInt("position");
        bundle.getInt("position");
        int i16 = bundle.getInt("reply_pos", -1);
        int i17 = bundle.getInt("commenttype", 0);
        Comment comment = QzoneCommentDetailActivity.f46847v1;
        if (i17 == 0) {
            if (i16 != -1 && comment != null && (list2 = comment.replies) != null && i16 < list2.size()) {
                reply = comment.replies.get(i16);
            }
            reply = null;
        } else {
            if (i17 == 1 && i16 != -1 && comment != null && (list = comment.replies) != null && i16 < list.size()) {
                reply = comment.replies.get(i16);
            }
            reply = null;
        }
        bVar.p6(view, comment, reply, i3, 100);
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(659, 5, 0), false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.detail.ui.component.FeedElementBaseClickListener
    public void f0(View view, Integer num) {
        super.f0(view, num);
        LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064(659, 5, 0), false, false);
    }

    @Override // com.qzone.detail.ui.component.FeedElementBaseClickListener
    protected void s0(View view, Object obj) {
        int i3;
        boolean z16;
        User user;
        if (obj instanceof Long) {
            BusinessFeedData businessFeedData = this.F;
            if (businessFeedData == null || businessFeedData.getCellUserInfo() == null) {
                i3 = 0;
                z16 = false;
            } else {
                i3 = this.F.getCellUserInfo().actionType;
                z16 = this.F.getFeedCommInfo().isBizRecomFeeds();
            }
            if (((Long) obj).longValue() != 0 && !z16) {
                BusinessFeedData businessFeedData2 = this.F;
                if (businessFeedData2 != null) {
                    if (businessFeedData2.getOriginalInfo() != null) {
                        user = this.F.getOriginalInfo().getUser();
                        if (user == null || !obj.equals(Long.valueOf(user.uin))) {
                            user = this.F.getUser();
                        }
                    } else {
                        user = this.F.getUser();
                    }
                    r6.a.o().k(user, this.F.getFeedCommInfo().ugckey);
                }
            } else {
                BusinessFeedData businessFeedData3 = this.F;
                if (businessFeedData3 != null && businessFeedData3.isCanvasAd()) {
                    i3 = r6.a.o().m(this.F, 0, BaseFeedPresenter.Q, null, com.qzone.misc.network.report.f.i(2, 3));
                }
            }
            BusinessFeedData businessFeedData4 = this.F;
            if (businessFeedData4 != null && businessFeedData4.isBrandUgcAdvFeeds()) {
                com.qzone.misc.network.report.f.e(this.F);
                return;
            }
            BusinessFeedData businessFeedData5 = this.F;
            if (businessFeedData5 != null && businessFeedData5.isAdFeeds() && this.F.getLocalInfo() != null && this.F.getLocalInfo().canLike && this.F.getLocalInfo().canComment) {
                int i16 = 5000;
                if ((this.F.getCellUserInfo() == null || this.F.getCellUserInfo().actionType != 2) && (this.F.getCellUserInfo().actionType != 20 || this.F.getOperationInfo() == null || this.F.getOperationInfo().actionType != 2)) {
                    i16 = 5001;
                }
                r6.a.y(this.F, i16, i3, 0, null);
                return;
            }
            r6.a.w(this.F, 2, i3, 0);
        }
    }
}
