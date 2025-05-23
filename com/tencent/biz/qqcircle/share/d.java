package com.tencent.biz.qqcircle.share;

import android.os.Bundle;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.biz.qcircleshadow.lib.QCircleHostConstants;
import com.tencent.biz.qcircleshadow.lib.variation.HostDataTransUtils;
import com.tencent.biz.qqcircle.share.QCircleBaseShareOperation;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.ITimiShareHelper;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.TgShareParam;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.HashMap;
import java.util.List;
import uq3.q;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d extends QCircleBaseShareOperation {

    /* renamed from: u, reason: collision with root package name */
    private final Bundle f92359u;

    /* renamed from: v, reason: collision with root package name */
    private String f92360v;

    /* renamed from: w, reason: collision with root package name */
    private String f92361w;

    /* renamed from: x, reason: collision with root package name */
    private String f92362x;

    /* renamed from: y, reason: collision with root package name */
    private String f92363y;

    public d(QCircleBaseShareOperation.a aVar) {
        super(aVar);
        this.f92359u = new Bundle();
    }

    private void L() {
        List<FeedCloudCommon$Entry> list = t().feed.share.shareQzoneInfo.entrys.get();
        HashMap hashMap = new HashMap();
        if (list != null && list.size() > 0) {
            for (FeedCloudCommon$Entry feedCloudCommon$Entry : list) {
                hashMap.put(feedCloudCommon$Entry.key.get(), feedCloudCommon$Entry.value.get());
            }
            if (t().type == 1) {
                this.f92360v = t().feed.poster.icon.iconUrl.get();
            } else {
                this.f92360v = (String) hashMap.get("COVERURL");
            }
            this.f92361w = (String) hashMap.get("title");
            this.f92362x = (String) hashMap.get("summary");
            this.f92363y = (String) hashMap.get(AlbumCacheData.ACTIONURL);
        }
        this.f92359u.putSerializable(QCircleHostConstants.AppConstants.Key.SHARE_REQ_SHARE_QZONE_INFO(), HostDataTransUtils.wrapSerializableMap(hashMap));
        this.f92359u.putString(QCircleHostConstants.AppConstants.Key.SHARE_REQ_TITLE(), this.f92361w);
        this.f92359u.putString(QCircleHostConstants.AppConstants.Key.SHARE_REQ_DESC(), this.f92362x);
        this.f92359u.putString(QCircleHostConstants.AppConstants.Key.SHARE_REQ_DETAIL_URL(), this.f92363y);
        this.f92359u.putLong(QCircleHostConstants.AppConstants.Key.SHARE_REQ_ID(), 0L);
    }

    private void M() {
        if (!C(57) && !uq3.c.g6()) {
            if (C(32)) {
                P();
                return;
            }
            if (C(31)) {
                R();
                return;
            } else if (A()) {
                Q();
                return;
            } else {
                O();
                return;
            }
        }
        N();
    }

    private void N() {
        H(26, 2, t().extraTypeInfo, "");
        d("share", "qzone");
    }

    private void O() {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        String str;
        int i3;
        if (t().extraTypeInfo != null) {
            feedCloudMeta$StFeed = t().extraTypeInfo.mFeed;
        } else {
            feedCloudMeta$StFeed = null;
        }
        QCircleLpReportDc05501.DataBuilder subActionType = ua0.c.a(feedCloudMeta$StFeed).setActionType(26).setSubActionType(2);
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

    private void P() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(t().feed.poster.f398463id.get()).setActionType(11).setSubActionType(9).setThrActionType(2).setExt9(o()).setFeedReportInfo(p()).setPageId(m()));
    }

    private void Q() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(F()).setSubActionType(3).setThrActionType(2).setExt6(String.valueOf(t().polymerizationName)).setPageId(m()));
    }

    private void R() {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(t().feed.poster.f398463id.get()).setActionType(6).setSubActionType(4).setThrActionType(2).setPageId(m()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    public void G() {
        if (t() != null && t().feed != null && t().feed.poster != null && t().feed.share != null && f() != null) {
            L();
            M();
            TgShareParam.ShareBody shareBody = yb0.a.a(t().feed, t().feedBlockData).getShareBody(0);
            ((ITimiShareHelper) QRoute.api(ITimiShareHelper.class)).shareToQzone(f(), shareBody.title, shareBody.desc, shareBody.imageUrl, shareBody.jumpActionUrl, v(), 0);
            q.c(f(), "share_lately_type_key", "share_type_qzone");
            return;
        }
        J("QFSSharePart");
    }

    @Override // com.tencent.biz.qqcircle.share.QCircleBaseShareOperation
    protected boolean y() {
        return false;
    }
}
