package com.tencent.biz.qqcircle.immersive.layer.base;

import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.bizparts.QCircleLightInteractListPart;
import com.tencent.biz.qqcircle.bizparts.QCircleRichMediaDownLoadPart;
import com.tencent.biz.qqcircle.bizparts.QFSReportBottomSheetPart;
import com.tencent.biz.qqcircle.bizparts.QFSSharePart;
import com.tencent.biz.qqcircle.bizparts.aw;
import com.tencent.biz.qqcircle.bizparts.bq;
import com.tencent.biz.qqcircle.bizparts.bv;
import com.tencent.biz.qqcircle.bizparts.bz;
import com.tencent.biz.qqcircle.bizparts.de;
import com.tencent.biz.qqcircle.debug.g;
import com.tencent.biz.qqcircle.immersive.feed.Cdo;
import com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildAvatarPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBottomInfoPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildMutePresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildODViewPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildPublishBottomInfoPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSHotTagPresenter;
import com.tencent.biz.qqcircle.immersive.feed.QFSLayerFeedPYMKItemPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ab;
import com.tencent.biz.qqcircle.immersive.feed.ac;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedAdFingerCardPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdCardPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdFooterPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdPicPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdSocialPendantPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdTopViewPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ad.QFSFeedChildAdVideoPresenter;
import com.tencent.biz.qqcircle.immersive.feed.ad.ag;
import com.tencent.biz.qqcircle.immersive.feed.ad.ap;
import com.tencent.biz.qqcircle.immersive.feed.ad.at;
import com.tencent.biz.qqcircle.immersive.feed.ad.bc;
import com.tencent.biz.qqcircle.immersive.feed.ad.be;
import com.tencent.biz.qqcircle.immersive.feed.ad.bh;
import com.tencent.biz.qqcircle.immersive.feed.ad.bp;
import com.tencent.biz.qqcircle.immersive.feed.ad.bs;
import com.tencent.biz.qqcircle.immersive.feed.ad.bw;
import com.tencent.biz.qqcircle.immersive.feed.ad.ca;
import com.tencent.biz.qqcircle.immersive.feed.ad.cd;
import com.tencent.biz.qqcircle.immersive.feed.ad.cg;
import com.tencent.biz.qqcircle.immersive.feed.ad.ch;
import com.tencent.biz.qqcircle.immersive.feed.ad.cs;
import com.tencent.biz.qqcircle.immersive.feed.ad.ct;
import com.tencent.biz.qqcircle.immersive.feed.ad.cu;
import com.tencent.biz.qqcircle.immersive.feed.ad.cv;
import com.tencent.biz.qqcircle.immersive.feed.ad.cw;
import com.tencent.biz.qqcircle.immersive.feed.ad.da;
import com.tencent.biz.qqcircle.immersive.feed.ad.dr;
import com.tencent.biz.qqcircle.immersive.feed.ad.ee;
import com.tencent.biz.qqcircle.immersive.feed.ad.s;
import com.tencent.biz.qqcircle.immersive.feed.al;
import com.tencent.biz.qqcircle.immersive.feed.ar;
import com.tencent.biz.qqcircle.immersive.feed.ay;
import com.tencent.biz.qqcircle.immersive.feed.az;
import com.tencent.biz.qqcircle.immersive.feed.ba;
import com.tencent.biz.qqcircle.immersive.feed.bm;
import com.tencent.biz.qqcircle.immersive.feed.br;
import com.tencent.biz.qqcircle.immersive.feed.cc;
import com.tencent.biz.qqcircle.immersive.feed.dj;
import com.tencent.biz.qqcircle.immersive.feed.dm;
import com.tencent.biz.qqcircle.immersive.feed.dn;
import com.tencent.biz.qqcircle.immersive.feed.dp;
import com.tencent.biz.qqcircle.immersive.feed.dq;
import com.tencent.biz.qqcircle.immersive.feed.ds;
import com.tencent.biz.qqcircle.immersive.feed.j;
import com.tencent.biz.qqcircle.immersive.feed.live.QFSFeedChildLiveBottomInfoPresenter;
import com.tencent.biz.qqcircle.immersive.feed.live.QFSFeedChildLivePresenter;
import com.tencent.biz.qqcircle.immersive.feed.live.QFSFeedLiveLongClickPresenter;
import com.tencent.biz.qqcircle.immersive.feed.live.QFSFeedLiveStatePresenter;
import com.tencent.biz.qqcircle.immersive.feed.u;
import com.tencent.biz.qqcircle.immersive.feed.z;
import com.tencent.biz.qqcircle.immersive.layer.biz.QFSLayerDefaultViewModel;
import com.tencent.biz.qqcircle.immersive.part.QFSEmojiCommentPanelPart;
import com.tencent.biz.qqcircle.immersive.part.QFSMainShoppingCartPart;
import com.tencent.biz.qqcircle.immersive.part.QFSMainTabTipExpPart;
import com.tencent.biz.qqcircle.immersive.part.QFSPushBoxSharePart;
import com.tencent.biz.qqcircle.immersive.part.QFSPushRocketProgressPart;
import com.tencent.biz.qqcircle.immersive.part.QFSQCircleTabGuideTipExpPart;
import com.tencent.biz.qqcircle.immersive.part.QFSTagPolymerizationTaskDoneDialogPart;
import com.tencent.biz.qqcircle.immersive.part.ak;
import com.tencent.biz.qqcircle.immersive.part.au;
import com.tencent.biz.qqcircle.immersive.part.cl;
import com.tencent.biz.qqcircle.immersive.part.cm;
import com.tencent.biz.qqcircle.immersive.part.cp;
import com.tencent.biz.qqcircle.immersive.part.du;
import com.tencent.biz.qqcircle.immersive.part.ex;
import com.tencent.biz.qqcircle.immersive.part.ez;
import com.tencent.biz.qqcircle.immersive.part.gj;
import com.tencent.biz.qqcircle.immersive.search.QFSPersonalPanelPart;
import com.tencent.biz.qqcircle.utils.cb;
import com.tencent.biz.qqcircle.utils.co;
import com.tencent.biz.richframework.part.Part;
import feedcloud.FeedCloudMeta$StFeed;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class b {
    public static void a(List<Part> list) {
        if (list == null) {
            return;
        }
        list.add(new gj());
        if (ac0.c.a()) {
            list.add(new du());
            list.add(new a60.d());
        }
    }

    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ab.class);
        arrayList.add(QFSFeedChildAdTopViewPresenter.class);
        arrayList.add(bp.class);
        g.a(arrayList);
        arrayList.add(bc.class);
        arrayList.add(ag.class);
        arrayList.add(cg.class);
        arrayList.add(bh.class);
        arrayList.add(ct.class);
        arrayList.add(cv.class);
        arrayList.add(QFSFeedChildAdVideoPresenter.class);
        arrayList.add(QFSFeedChildAdPicPresenter.class);
        arrayList.add(bm.class);
        arrayList.add(QFSFeedChildAdCardPresenter.class);
        arrayList.add(ap.class);
        arrayList.add(da.class);
        arrayList.add(s.class);
        arrayList.add(z.class);
        arrayList.add(at.class);
        arrayList.add(QFSFeedAdFingerCardPresenter.class);
        arrayList.add(bs.class);
        arrayList.add(QFSFeedChildMutePresenter.class);
        arrayList.add(cu.class);
        arrayList.add(QFSFeedChildAdFooterPresenter.class);
        arrayList.add(cd.class);
        arrayList.add(bw.class);
        arrayList.add(ch.class);
        arrayList.add(cs.class);
        arrayList.add(ca.class);
        arrayList.add(com.tencent.biz.qqcircle.immersive.feed.ad.bm.class);
        arrayList.add(be.class);
        arrayList.add(QFSFeedChildAdSocialPendantPresenter.class);
        arrayList.add(ee.class);
        arrayList.add(dr.class);
        if (co.b()) {
            arrayList.add(cc.class);
        }
        arrayList.add(cw.class);
        return arrayList;
    }

    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> c() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> d16 = d();
        d16.add(j.class);
        return d16;
    }

    @NonNull
    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ab.class);
        return arrayList;
    }

    protected List<Part> e(@NonNull a aVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new cl());
        arrayList.add(new QFSPersonalPanelPart());
        arrayList.add(new bq());
        arrayList.add(new bv());
        arrayList.add(new bz());
        arrayList.add(new QFSReportBottomSheetPart());
        com.tencent.biz.qqcircle.helpers.f.f84618a.a(arrayList, aVar.a(), true);
        arrayList.add(new QFSEmojiCommentPanelPart());
        arrayList.add(new cp());
        arrayList.add(new QFSSharePart());
        arrayList.add(new ak());
        QCircleLightInteractListPart qCircleLightInteractListPart = new QCircleLightInteractListPart();
        qCircleLightInteractListPart.setReportBeanAgent(aVar.a());
        arrayList.add(qCircleLightInteractListPart);
        arrayList.add(new QCircleRichMediaDownLoadPart());
        arrayList.add(new QFSMainTabTipExpPart(true));
        arrayList.add(new QFSMainShoppingCartPart());
        arrayList.add(new QFSPushBoxSharePart());
        arrayList.add(new QFSPushRocketProgressPart());
        arrayList.add(new com.tencent.biz.qqcircle.immersive.part.push.a());
        arrayList.add(new k60.a(true));
        arrayList.add(new cm());
        arrayList.add(new au(1));
        arrayList.add(new QFSTagPolymerizationTaskDoneDialogPart());
        if (cb.c()) {
            arrayList.add(new ez());
            arrayList.add(new ex());
        }
        a(arrayList);
        arrayList.add(new de());
        arrayList.add(new QFSQCircleTabGuideTipExpPart());
        arrayList.add(new aw());
        return arrayList;
    }

    @NonNull
    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> f() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> d16 = d();
        d16.add(dn.class);
        return d16;
    }

    protected abstract List<Part> g(@NonNull a aVar);

    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> h() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> d16 = d();
        d16.add(dj.class);
        return d16;
    }

    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> i() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> d16 = d();
        d16.add(QFSHotTagPresenter.class);
        return d16;
    }

    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> j() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> d16 = d();
        d16.add(dm.class);
        return d16;
    }

    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> k() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QFSFeedChildLiveBottomInfoPresenter.class);
        g.a(arrayList);
        arrayList.add(QFSFeedChildLivePresenter.class);
        arrayList.add(QFSFeedLiveStatePresenter.class);
        arrayList.add(z.class);
        arrayList.add(QFSFeedChildMutePresenter.class);
        arrayList.add(QFSFeedLiveLongClickPresenter.class);
        return arrayList;
    }

    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> l() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> d16 = d();
        d16.add(dp.class);
        return d16;
    }

    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> m() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QFSFeedChildODViewPresenter.class);
        arrayList.add(QFSFeedChildLiveBottomInfoPresenter.class);
        arrayList.add(ar.class);
        arrayList.add(QFSFeedChildMutePresenter.class);
        arrayList.add(QFSFeedLiveLongClickPresenter.class);
        return arrayList;
    }

    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> n() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.tencent.biz.qqcircle.immersive.feed.at.class);
        return arrayList;
    }

    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> o() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> d16 = d();
        g.a(d16);
        d16.add(QFSLayerFeedPYMKItemPresenter.class);
        d16.add(Cdo.class);
        return d16;
    }

    public List<Part> p(a aVar) {
        ArrayList arrayList = new ArrayList();
        if (aVar == null) {
            return arrayList;
        }
        List<Part> e16 = e(aVar);
        if (e16 != null) {
            arrayList.addAll(e16);
        }
        List<Part> g16 = g(aVar);
        if (g16 != null) {
            arrayList.addAll(g16);
        }
        return arrayList;
    }

    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> q() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(QFSFeedChildAvatarPresenter.class);
        arrayList.add(al.class);
        arrayList.add(u.class);
        arrayList.add(com.tencent.biz.qqcircle.immersive.feed.bc.class);
        arrayList.add(br.class);
        arrayList.add(QFSFeedChildBottomInfoPresenter.class);
        arrayList.add(ac.class);
        g.a(arrayList);
        arrayList.add(bm.class);
        return arrayList;
    }

    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> r() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> d16 = d();
        d16.add(ab.class);
        d16.add(dq.class);
        return d16;
    }

    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> s() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ba.class);
        arrayList.add(QFSFeedChildPublishBottomInfoPresenter.class);
        arrayList.add(ay.class);
        arrayList.add(bm.class);
        arrayList.add(az.class);
        return arrayList;
    }

    public List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> t() {
        List<Class<? extends QFSBaseFeedChildPresenter<FeedCloudMeta$StFeed>>> d16 = d();
        d16.add(ds.class);
        return d16;
    }

    public a u() {
        return new com.tencent.biz.qqcircle.immersive.layer.biz.a();
    }

    public Class<? extends com.tencent.biz.qqcircle.viewmodels.a> v() {
        return QFSLayerDefaultViewModel.class;
    }
}
