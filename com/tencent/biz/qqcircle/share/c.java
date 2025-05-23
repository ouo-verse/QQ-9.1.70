package com.tencent.biz.qqcircle.share;

import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.ITimiShareHelper;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.TgShareParam;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import feedcloud.FeedCloudMeta$StFeed;
import uq3.q;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c extends QCircleBaseShareOperation {

    /* renamed from: u, reason: collision with root package name */
    private IAegisLogApi f92358u;

    public c(QCircleBaseShareOperation.a aVar) {
        super(aVar);
        this.f92358u = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
    }

    private TgShareParam L() {
        return yb0.a.a(t().feed, t().feedBlockData);
    }

    private void M() {
        H(25, 2, t().extraTypeInfo, "");
        d("share", "qq_aio");
    }

    private void N() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str;
        int i3;
        if (t().extraTypeInfo != null) {
            feedCloudMeta$StFeed = t().extraTypeInfo.mFeed;
        } else {
            feedCloudMeta$StFeed = null;
        }
        QCircleLpReportDc05501.DataBuilder subActionType = ua0.c.a(feedCloudMeta$StFeed).setActionType(25).setSubActionType(2);
        if (t().extraTypeInfo != null && t().extraTypeInfo.mFeed != null) {
            str = t().extraTypeInfo.mFeed.poster.f398463id.get();
        } else {
            str = "";
        }
        QCircleLpReportDc05501.DataBuilder toUin = subActionType.setToUin(str);
        if (t().extraTypeInfo != null) {
            i3 = t().extraTypeInfo.mDataPosition;
        } else {
            i3 = -1;
        }
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(toUin.setIndex(i3).setPageId(m())));
    }

    private void O() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(t().feed.poster.f398463id.get()).setActionType(11).setSubActionType(9).setThrActionType(1).setExt9(o()).setFeedReportInfo(p()).setPageId(m()));
    }

    private void P() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(F()).setSubActionType(3).setThrActionType(1).setExt6(String.valueOf(t().polymerizationName)).setPageId(m()));
    }

    private void Q() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(t().feed.poster.f398463id.get()).setActionType(6).setSubActionType(4).setThrActionType(1).setPageId(m()));
    }

    private void R() {
        if (!C(57) && !uq3.c.g6()) {
            if (C(32)) {
                O();
                return;
            }
            if (C(31)) {
                Q();
                return;
            } else if (A()) {
                P();
                return;
            } else {
                N();
                return;
            }
        }
        M();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && t().feed != null && t().feed.share != null && f() != null) {
            I(true);
            ((ITimiShareHelper) QRoute.api(ITimiShareHelper.class)).shareToQQ(f(), L(), v(), x());
            this.f92358u.d("QFSSharePart", "shareToQQ  success");
            R();
            ua0.d.a(m(), n()).q(t().extraTypeInfo);
            q.c(f(), "share_lately_type_key", "share_type_qq");
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
