package com.qzone.detail.business.service;

import NS_MOBILE_AD_BANNER.QueryADBannerRsp;
import NS_MOBILE_AD_BANNER.QueryADBannerUnit;
import NS_MOBILE_FEEDS.mobile_detail_rsp;
import NS_MOBILE_FEEDS.mobile_festival_rsp;
import NS_MOBILE_FEEDS.operation_topfeeds_req;
import NS_MOBILE_FEEDS.operation_topfeeds_rsp;
import NS_MOBILE_FEEDS.single_feed;
import NS_MOBILE_OPERATION.operation_hide_feeds_rsp;
import NS_MOBILE_QUN.qun_get_detail_rsp;
import NS_QMALL_COVER.ProfileQzmallDeco;
import NS_QMALL_COVER.QzmallCustomPraise;
import NS_QMALL_COVER.QzmallProfileDecoGetRsp;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.jce.wup.UniAttribute;
import com.qq.taf.jce.JceStruct;
import com.qzone.adapter.feedcomponent.f;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.IQZoneFeedOperateLogicInterface;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.common.event.Observable;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.component.banner.BusinessADBannerData;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.detail.business.protocol.MobileQQGetFeedDetailRequest;
import com.qzone.detail.business.protocol.QZoneGetADFeedDetailRequest;
import com.qzone.detail.business.protocol.QZonehideSingleFeedRequest;
import com.qzone.detail.business.protocol.QzoneGetFeedDetailRequest;
import com.qzone.detail.business.protocol.QzoneSetFeedTopRequest;
import com.qzone.feed.business.model.FestivalResponse;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.proxy.feedcomponent.c;
import com.qzone.proxy.feedcomponent.manager.d;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.CellPresentInfo;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseEmotionData;
import com.qzone.proxy.feedcomponent.model.PresentMan;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.proxy.feedcomponent.util.j;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qqlive.common.api.AegisLogger;
import cooperation.qzone.mobilereport.MobileReportManager;
import cooperation.qzone.report.lp.LpReportInfo_dc01245;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneDetailService extends Observable implements IQZoneServiceListener, d, IObserver.background {
    public int C;
    public String D;
    public int E;
    public int F;
    public FestivalResponse G;
    private String H;
    protected b I;

    /* renamed from: d, reason: collision with root package name */
    public boolean f46826d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f46827e;

    /* renamed from: f, reason: collision with root package name */
    private BusinessFeedData f46828f;

    /* renamed from: h, reason: collision with root package name */
    private BusinessFeedData f46829h;

    /* renamed from: i, reason: collision with root package name */
    private Map<Integer, String> f46830i;

    /* renamed from: m, reason: collision with root package name */
    public String f46831m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class DetailFeedDataKeys implements SmartParcelable {

        @NeedParcel
        public String cellId;

        @NeedParcel
        public String feedsKey;

        @NeedParcel
        public String ugcKey;

        public DetailFeedDataKeys() {
        }

        public void setCellId(String str) {
            this.cellId = str;
        }

        public DetailFeedDataKeys(String str, String str2) {
            this.ugcKey = str;
            this.feedsKey = str2;
        }

        public DetailFeedDataKeys(String str, String str2, String str3) {
            this.ugcKey = str;
            this.feedsKey = str2;
            this.cellId = str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements a.InterfaceC10828a {
        a() {
        }

        @Override // n7.a.InterfaceC10828a
        public void onClosed(n7.a aVar) {
            if (QZLog.isColorLevel()) {
                QZLog.d("DbCacheDatabase.CacheManager", 2, "DbCacheManager onClosed " + QZoneDetailService.this + ",table:" + QZoneDetailService.this.P());
            }
            QZoneDetailService.this.I.a();
        }
    }

    public QZoneDetailService() {
        super("Detail");
        this.f46826d = false;
        this.f46827e = false;
        this.f46831m = "";
        this.C = 0;
        this.D = "";
        this.E = 0;
        this.F = 0;
        this.I = new b();
        this.H = "Detail";
        I();
    }

    private void I() {
        EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 3, 4, 15, 7, 40, 16, 41, 8, 6, 56, 5, 14, 9, 17, 46, 18, 19, 20, 31, 34, 37, 39, 43, 55, 58, 59, 68, 69, 72, 74, 73, 83);
        EventCenter.getInstance().addObserver(this, 3, "Face", 1);
        EventCenter.getInstance().addObserver(this, 3, "Feed", 30, 31);
    }

    private void M() {
        EventCenter.getInstance().removeObserver(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String P() {
        return this.H;
    }

    public static QZoneDetailService U() {
        return new QZoneDetailService();
    }

    private void k0(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(qZoneTask.mType == 5 ? 1000106 : 1000107);
        JceStruct jceStruct = qZoneTask.mRequest.rsp;
        operation_topfeeds_rsp operation_topfeeds_rspVar = jceStruct instanceof operation_topfeeds_rsp ? (operation_topfeeds_rsp) jceStruct : null;
        if (operation_topfeeds_rspVar != null) {
            result.setSucceed(operation_topfeeds_rspVar.ret == 0);
        } else {
            result.setSucceed(false);
        }
        JceStruct jceStruct2 = qZoneTask.mRequest.req;
        operation_topfeeds_req operation_topfeeds_reqVar = jceStruct2 instanceof operation_topfeeds_req ? (operation_topfeeds_req) jceStruct2 : null;
        if (operation_topfeeds_reqVar != null) {
            result.setFeedId(operation_topfeeds_reqVar.strkey);
        }
        qZoneTask.sendResultMsg(result);
    }

    private void m0(String str, boolean z16, String str2, String str3, PictureItem pictureItem) {
        CellPictureInfo pictureInfo;
        BusinessFeedData businessFeedData = this.f46828f;
        if (businessFeedData == null || (pictureInfo = businessFeedData.getPictureInfo()) == null || pictureInfo.pics == null) {
            return;
        }
        for (int i3 = 0; i3 < pictureInfo.pics.size(); i3++) {
            PictureItem pictureItem2 = pictureInfo.pics.get(i3);
            if (com.qzone.proxy.feedcomponent.util.d.o(pictureItem2, pictureItem.currentUrl.url) || com.qzone.proxy.feedcomponent.util.d.o(pictureItem2, pictureItem.originUrl.url)) {
                t0(str, z16, i3, str2, str3, 0, null);
            }
        }
    }

    private void p0(String str) {
        CellPictureInfo pictureInfo;
        if (this.f46828f == null || TextUtils.isEmpty(str) || (pictureInfo = this.f46828f.getPictureInfo()) == null || !str.equals(pictureInfo.albumid)) {
            return;
        }
        L(this.f46828f);
        o0();
    }

    private void q0(String str, String str2) {
        Pair<CellPictureInfo, Boolean> m3;
        Object obj;
        BusinessFeedData businessFeedData = this.f46828f;
        if (businessFeedData == null || (m3 = com.qzone.proxy.feedcomponent.util.d.m(businessFeedData)) == null || (obj = m3.first) == null || ((CellPictureInfo) obj).pics == null) {
            return;
        }
        ArrayList<PictureItem> arrayList = ((CellPictureInfo) obj).pics;
        int i3 = 0;
        while (true) {
            if (i3 >= arrayList.size()) {
                break;
            }
            PictureItem pictureItem = arrayList.get(i3);
            if (pictureItem != null && pictureItem.lloc.equals(str2)) {
                arrayList.remove(i3);
                break;
            }
            i3++;
        }
        if (arrayList.size() > 0) {
            E0(this.f46828f, true);
        } else {
            L(this.f46828f);
            o0();
        }
    }

    private void r0(String str, String str2) {
        BusinessFeedData businessFeedData = this.f46828f;
        if (businessFeedData == null) {
            return;
        }
        L(businessFeedData);
        o0();
    }

    private void s0(String str, boolean z16, long j3, boolean z17) {
        BusinessFeedData x06 = x0("ugc_key = ?", str, null);
        if (x06 == null) {
            return;
        }
        if (x06.getUser().uin == j3) {
            if (x06.getFeedCommInfo() != null) {
                x06.getFeedCommInfo().isFollowed = z16;
            }
            if (x06.getRecommAction() != null) {
                x06.getRecommAction().hasFollowed = z16 ? 1 : 0;
            }
        }
        BusinessFeedData originalInfo = x06.getOriginalInfo();
        if (originalInfo != null && originalInfo.getUser().uin == j3) {
            if (originalInfo.getFeedCommInfo() != null) {
                originalInfo.getFeedCommInfo().isFollowed = z16;
            }
            if (originalInfo.getRecommAction() != null) {
                originalInfo.getRecommAction().hasFollowed = z16 ? 1 : 0;
            }
        }
        if (!z17) {
            x06.getFeedCommInfo().isFollowed = z16;
            if (x06.getRecommAction() != null) {
                x06.getRecommAction().hasFollowed = z16 ? 1 : 0;
            }
        } else {
            x06.getOriginalInfoSafe().getFeedCommInfo().isFollowed = z16;
            if (x06.getOriginalInfoSafe().getRecommAction() != null) {
                x06.getOriginalInfoSafe().getRecommAction().hasFollowed = z16 ? 1 : 0;
            }
        }
        E0(x06, true);
    }

    private void t0(String str, boolean z16, int i3, String str2, String str3, int i16, CustomPraiseData customPraiseData) {
        PictureItem pictureItem;
        ArrayList<PictureItem> arrayList;
        BusinessFeedData businessFeedData = this.f46828f;
        if (businessFeedData == null) {
            return;
        }
        CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
        if (pictureInfo == null || (arrayList = pictureInfo.pics) == null || arrayList.size() <= i3) {
            pictureItem = null;
        } else {
            pictureItem = pictureInfo.pics.get(i3);
            pictureItem.isLike = z16;
        }
        ArrayList<Object> detailContent = this.f46828f.getDetailContent();
        if (detailContent != null && detailContent.size() > 0) {
            ArrayList arrayList2 = new ArrayList();
            int size = detailContent.size();
            for (int i17 = 0; i17 < size; i17++) {
                if (detailContent.get(i17) instanceof PictureItem) {
                    arrayList2.add((PictureItem) detailContent.get(i17));
                }
            }
            if (arrayList2.size() > i3) {
                ((PictureItem) arrayList2.get(i3)).isLike = z16;
            }
        }
        CellCommentInfo commentInfo = this.f46828f.getCommentInfo();
        if (commentInfo != null && commentInfo.commments != null) {
            for (int i18 = 0; i18 < commentInfo.commments.size(); i18++) {
                Comment comment = commentInfo.commments.get(i18);
                ArrayList<PictureItem> arrayList3 = comment.pictureItems;
                if (arrayList3 != null && arrayList3.size() > 0) {
                    PictureItem pictureItem2 = comment.pictureItems.get(0);
                    if (pictureItem != null && (com.qzone.proxy.feedcomponent.util.d.o(pictureItem2, pictureItem.currentUrl.url) || com.qzone.proxy.feedcomponent.util.d.o(pictureItem2, pictureItem.originUrl.url))) {
                        pictureItem2.isLike = z16;
                    }
                }
            }
            E0(this.f46828f, true);
            return;
        }
        n0();
    }

    private void v0(String str, String str2, String str3) {
        BusinessFeedData queryWithMem = queryWithMem("ugc_key = ?", str2, null);
        if (queryWithMem == null) {
            j.c(AegisLogger.GIFT, "feed null" + str2);
            return;
        }
        CellPresentInfo cellPresentInfo = queryWithMem.getCellPresentInfo();
        if (cellPresentInfo == null) {
            cellPresentInfo = new CellPresentInfo();
            queryWithMem.setCellPresentInfo(cellPresentInfo);
        }
        if (cellPresentInfo.presentmans == null) {
            cellPresentInfo.presentmans = new ArrayList<>();
        }
        long uin = LoginData.getInstance().getUin();
        int i3 = 0;
        while (true) {
            if (i3 >= cellPresentInfo.presentmans.size()) {
                i3 = -1;
                break;
            } else if (cellPresentInfo.presentmans.get(i3).user.uin == uin) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 == 0) {
            return;
        }
        if (i3 == -1) {
            PresentMan presentMan = new PresentMan();
            User user = new User();
            presentMan.user = user;
            user.uin = uin;
            cellPresentInfo.presentmans.add(0, presentMan);
            cellPresentInfo.num++;
        } else {
            cellPresentInfo.presentmans.add(0, cellPresentInfo.presentmans.remove(i3));
        }
        E0(queryWithMem, true);
    }

    private void y0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        UniAttribute uniAttribute;
        ArrayList<QueryADBannerUnit> arrayList;
        if (qZoneTask.mResultCode == 0 && (uniAttribute = qZoneTask.mUniAttr) != null && uniAttribute.containsKey("hostBanner")) {
            QueryADBannerRsp queryADBannerRsp = (QueryADBannerRsp) qZoneTask.mUniAttr.get("hostBanner");
            if (queryADBannerRsp != null && (arrayList = queryADBannerRsp.vecAdBanner) != null && arrayList.size() > 0) {
                ArrayList<QueryADBannerUnit> arrayList2 = queryADBannerRsp.vecAdBanner;
                ArrayList arrayList3 = new ArrayList();
                int size = arrayList2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList3.add(new BusinessADBannerData(arrayList2.get(i3)));
                }
                ParcelableWrapper.putArrayListToBundle(qZoneResult.getBundle(), BusinessADBannerData.STORE_KEY, arrayList3);
                return;
            }
            if (QZLog.isColorLevel()) {
                QZLog.d(QZLog.TO_DEVICE_TAG, 2, "GETBANNER: bannaer is null");
            }
        }
    }

    private void z0(QZoneTask qZoneTask, QZoneResult qZoneResult) {
        QzmallCustomPraise qzmallCustomPraise;
        UniAttribute uniAttribute = qZoneTask.mUniAttr;
        if (uniAttribute == null || qZoneTask.mResultCode != 0) {
            return;
        }
        if (uniAttribute.containsKey("hostQzmallDeco")) {
            QzmallProfileDecoGetRsp qzmallProfileDecoGetRsp = (QzmallProfileDecoGetRsp) qZoneTask.mUniAttr.get("hostQzmallDeco");
            if (qzmallProfileDecoGetRsp != null) {
                ProfileQzmallDeco profileQzmallDeco = (ProfileQzmallDeco) t5.b.b(ProfileQzmallDeco.class, qzmallProfileDecoGetRsp.vecBuff);
                if (profileQzmallDeco != null && (qzmallCustomPraise = profileQzmallDeco.stCustomPraise) != null && qzmallCustomPraise.iItemId != 0) {
                    QzoneCustomPraiseService.i().p(CustomPraiseData.createFromResponse(qzmallCustomPraise));
                    return;
                } else {
                    QzoneCustomPraiseService.i().p(null);
                    QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QzoneDetailService read: CustomPraise is null");
                    return;
                }
            }
            QzoneCustomPraiseService.i().p(null);
            QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QzoneDetailService read: CustomPraise is null");
            return;
        }
        QzoneCustomPraiseService.i().p(null);
        QZLog.i(QZLog.TO_DEVICE_TAG, 1, "QzoneDetailService read: CustomPraise is empty");
    }

    public void A0(final BusinessFeedData businessFeedData, final String str) {
        if (TextUtils.isEmpty(str)) {
            if (businessFeedData != null) {
                str = businessFeedData.getFeedCommInfo().ugckey;
            } else {
                str = "";
            }
        }
        this.f46828f = businessFeedData;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.detail.business.service.QZoneDetailService.1
            @Override // java.lang.Runnable
            public void run() {
                String str2;
                QZoneDetailService qZoneDetailService = QZoneDetailService.this;
                String str3 = str;
                BusinessFeedData businessFeedData2 = businessFeedData;
                if (businessFeedData2 != null) {
                    str2 = businessFeedData2.getFeedCommInfo().feedskey;
                } else {
                    str2 = "";
                }
                BusinessFeedData W = qZoneDetailService.W(str3, str2);
                if (W != null) {
                    if (QZoneDetailService.this.f46828f != null && QZoneDetailService.this.f46828f.isBrandUgcAdvFeeds()) {
                        W.getOperationInfo().cookie = QZoneDetailService.this.f46828f.getOperationInfo().cookie;
                    }
                    QZoneDetailService qZoneDetailService2 = QZoneDetailService.this;
                    qZoneDetailService2.w0(qZoneDetailService2.f46828f, W);
                    QZoneDetailService.this.f46828f = W;
                    QZoneDetailService.this.n0();
                }
            }
        });
    }

    public void B0(BusinessFeedData businessFeedData) {
        this.f46828f = businessFeedData;
    }

    public void C0(final String str, final String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.detail.business.service.QZoneDetailService.2
            @Override // java.lang.Runnable
            public void run() {
                BusinessFeedData W = QZoneDetailService.this.W(str, str2);
                if (W != null) {
                    if (QZoneDetailService.this.f46828f != null && QZoneDetailService.this.f46828f.isBrandUgcAdvFeeds()) {
                        W.getOperationInfo().cookie = QZoneDetailService.this.f46828f.getOperationInfo().cookie;
                    }
                    QZoneDetailService qZoneDetailService = QZoneDetailService.this;
                    qZoneDetailService.w0(qZoneDetailService.f46828f, W);
                    QZoneDetailService.this.f46828f = W;
                    QZoneDetailService.this.n0();
                }
            }
        });
    }

    public void D0(String str, boolean z16, int i3, Handler handler) {
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneSetFeedTopRequest(LoginData.getInstance().getUin(), z16 ? 2 : 1, i3, str), handler, this, z16 ? 6 : 5));
        MobileReportManager.getInstance().reportAction("qzone_pri", "2", "12", 144, 1, System.currentTimeMillis());
    }

    public void O() {
        DbCacheManager T;
        if (V() > 20 && (T = T()) != null) {
            T.V(10, null);
        }
        close();
    }

    public BusinessFeedData Q() {
        return this.f46829h;
    }

    public BusinessFeedData R() {
        if (this.f46828f == null) {
            this.f46828f = new BusinessFeedData();
        }
        return this.f46828f;
    }

    public BusinessFeedData S() {
        BusinessFeedData businessFeedData = this.f46828f;
        if (businessFeedData == null) {
            return businessFeedData;
        }
        if ((businessFeedData.getDetailContent() != null && this.f46828f.getDetailContent().size() >= 50) || (this.f46828f.getOriginalInfoSafe().getDetailContent() != null && this.f46828f.getOriginalInfoSafe().getDetailContent().size() >= 50)) {
            BusinessFeedData K = K(this.f46828f);
            if (this.f46828f.getDetailContent() != null && this.f46828f.getDetailContent().size() >= 50) {
                K.getDetailContent().clear();
                K.getDetailContent().addAll(this.f46828f.getDetailContent().subList(0, 50));
            }
            if (this.f46828f.getOriginalInfoSafe().getDetailContent() != null && this.f46828f.getOriginalInfoSafe().getDetailContent().size() >= 50) {
                K.getOriginalInfoSafe().getDetailContent().clear();
                K.getOriginalInfoSafe().getDetailContent().addAll(this.f46828f.getOriginalInfoSafe().getDetailContent().subList(0, 50));
            }
            return K;
        }
        return this.f46828f;
    }

    protected DbCacheManager T() {
        N(this.I);
        return this.I.f46844b;
    }

    public int V() {
        DbCacheManager T = T();
        if (T != null) {
            return T.e0();
        }
        return 0;
    }

    public BusinessFeedData W(String str, String str2) {
        DbCacheManager T;
        ArrayList<? extends IDBCacheDataWrapper> i06;
        if (!TextUtils.isEmpty(str) && (T = T()) != null && (i06 = T.i0("ugc_key=? OR feed_key=?", new String[]{str, str2}, null, 0, 1)) != null && i06.size() > 0) {
            IDBCacheDataWrapper iDBCacheDataWrapper = i06.get(0);
            if (iDBCacheDataWrapper instanceof BusinessFeedData) {
                return (BusinessFeedData) iDBCacheDataWrapper;
            }
        }
        return null;
    }

    public void Z(Map<String, String> map, Handler handler, String str) {
        MobileQQGetFeedDetailRequest mobileQQGetFeedDetailRequest = new MobileQQGetFeedDetailRequest(map);
        if (str != null) {
            mobileQQGetFeedDetailRequest.setRefer(str);
        }
        QZoneBusinessLooper.getInstance().runTask(new QZoneTask(mobileQQGetFeedDetailRequest, handler, this, 0));
        this.f46827e = true;
    }

    public BusinessFeedData c0() {
        return this.f46828f;
    }

    public void l0(Handler handler, String str) {
        BusinessFeedData R = R();
        if (R != null) {
            String str2 = TextUtils.isEmpty(str) ? R.getFeedCommInfo().feedskey : str;
            if (R.getFeedCommInfo().isLikeRecommFamousFeed()) {
                ClickReport.c(PlayerResources.ViewId.OPEN_FREE_TRAFFIC_CONTAINER, 2, "", true, new String[0]);
            }
            long j3 = R.getUser() != null ? R.getUser().uin : 0L;
            long j16 = R.getFeedCommInfo().time;
            if (j16 > 0) {
                j16 /= 1000;
            }
            QZoneTask qZoneTask = new QZoneTask(new QZonehideSingleFeedRequest(str2, j3, j16), handler, this, 7);
            qZoneTask.addParameter(IQZoneFeedOperateLogicInterface.EVENT_PARAMETER_KEY_HIDE_FEEDS_KEY, str);
            QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        switch (qZoneTask.mType) {
            case 0:
                d0(qZoneTask);
                return;
            case 1:
                e0(qZoneTask);
                return;
            case 2:
            case 9:
            default:
                return;
            case 3:
                h0(qZoneTask);
                return;
            case 4:
                i0(qZoneTask);
                return;
            case 5:
            case 6:
                k0(qZoneTask);
                return;
            case 7:
                g0(qZoneTask);
                return;
            case 8:
                f0(qZoneTask);
                return;
            case 10:
                j0(qZoneTask);
                return;
        }
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public BusinessFeedData queryWithMem(String str, String str2, String str3) {
        return x0(str, str2, str3);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void u(String str, String[] strArr, boolean z16) {
        DbCacheManager T = T();
        if (T == null || T.b0(str, strArr) <= 0 || !z16) {
            return;
        }
        n0();
    }

    public BusinessFeedData x0(String str, String str2, String str3) {
        String[] strArr;
        DbCacheManager T = T();
        if (T == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3);
        }
        if (arrayList.size() != 0) {
            strArr = new String[arrayList.size()];
            arrayList.toArray(strArr);
        } else {
            strArr = null;
        }
        if (arrayList.size() == 0) {
            strArr = null;
        }
        return (BusinessFeedData) T.dbQueryFirstData(str, null, strArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f46843a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f46844b;

        b() {
        }

        public void a() {
            this.f46843a = 0L;
            this.f46844b = null;
        }
    }

    private void d0(QZoneTask qZoneTask) {
        mobile_festival_rsp mobile_festival_rspVar;
        BusinessFeedData businessFeedData;
        this.f46827e = false;
        QZoneResult result = qZoneTask.getResult(999900);
        mobile_detail_rsp mobile_detail_rspVar = (mobile_detail_rsp) qZoneTask.mRequest.rsp;
        if (mobile_detail_rspVar != null) {
            BusinessFeedData createFrom = BusinessFeedData.createFrom(mobile_detail_rspVar.detail_data);
            single_feed single_feedVar = mobile_detail_rspVar.ugc_detail_adv;
            if (single_feedVar != null) {
                BusinessFeedData createFrom2 = BusinessFeedData.createFrom(single_feedVar, 2);
                this.f46829h = createFrom2;
                GdtFeedUtilForQZone.x(createFrom2, 2);
            }
            BusinessFeedData businessFeedData2 = this.f46828f;
            if (businessFeedData2 != null && businessFeedData2.isBrandUgcAdvFeeds() && createFrom != null) {
                createFrom.getFeedCommInfoV2().setBrandUgcAdvFeeds();
                createFrom.getOperationInfo().cookie = this.f46828f.getOperationInfo().cookie;
            }
            if (createFrom != null && createFrom.getVideoRecommendInfo() == null && (businessFeedData = this.f46828f) != null) {
                createFrom.setVideoRecommendInfo(businessFeedData.getVideoRecommendInfo());
            }
            w0(R(), createFrom);
            c.f50143a.getUiInterface().replaceVideoInfoIfNecessary(createFrom);
            if (createFrom != null) {
                createFrom.setDbPriority((int) (System.currentTimeMillis() / 1000));
            }
            w(createFrom);
            this.C = mobile_detail_rspVar.hasmore;
            this.f46831m = mobile_detail_rspVar.attach_info;
            this.E = mobile_detail_rspVar.hasmore_essence;
            this.D = mobile_detail_rspVar.attach_info_essence;
            Bundle bundle = new Bundle();
            ParcelableWrapper.putDataToBundle(bundle, BusinessFeedData.STORE_KEY, createFrom);
            bundle.putInt("bannerInfo", this.F);
            result.setData(bundle);
            FeedSkinData cellFeedSkinInfo = createFrom != null ? createFrom.getCellFeedSkinInfo() : null;
            if (cellFeedSkinInfo != null && QZLog.isColorLevel()) {
                QZLog.d("QZoneCardLogic", 2, "DetailPage response from server uin: " + createFrom.getUser().uin + ",getCoverInfo().coverId: " + cellFeedSkinInfo.sSkinId + ",cellCover.coverTimeStamp: " + cellFeedSkinInfo.lTime + ",cellCover.cover_type: " + cellFeedSkinInfo.nSkinType);
            }
            this.f46828f = createFrom;
        } else {
            result.setSucceed(false);
        }
        UniAttribute uniAttribute = qZoneTask.mUniAttr;
        if (uniAttribute != null && uniAttribute.containsKey("festival") && (mobile_festival_rspVar = (mobile_festival_rsp) qZoneTask.mUniAttr.get("festival")) != null) {
            this.G = FestivalResponse.convertFromRsp(mobile_festival_rspVar);
        }
        z0(qZoneTask, result);
        y0(qZoneTask, result);
        qZoneTask.sendResultMsg(result);
        notify(5, Integer.valueOf(this.C));
        H(this.f46828f, 4);
    }

    private void e0(QZoneTask qZoneTask) {
        int i3;
        this.f46826d = false;
        BusinessFeedData R = R();
        QZoneResult result = qZoneTask.getResult(999927);
        mobile_detail_rsp mobile_detail_rspVar = (mobile_detail_rsp) qZoneTask.mRequest.rsp;
        if (mobile_detail_rspVar != null) {
            BusinessFeedData createFrom = BusinessFeedData.createFrom(mobile_detail_rspVar.detail_data);
            if (createFrom == null) {
                return;
            }
            HashMap<Object, Object> hashMap = qZoneTask.extraData;
            if (hashMap != null) {
                int intValue = ((Integer) hashMap.get(0)).intValue();
                boolean z16 = ((Integer) qZoneTask.extraData.get(1)).intValue() == 1;
                boolean booleanValue = ((Boolean) qZoneTask.extraData.get(2)).booleanValue();
                this.C = mobile_detail_rspVar.hasmore;
                this.f46831m = mobile_detail_rspVar.attach_info;
                R.getCommentInfo().commentNum = createFrom.getCommentInfo().commentNum;
                if (z16) {
                    R.getLikeInfo().likeMans = createFrom.getLikeInfo().likeMans;
                    R.getLikeInfo().likeNum = createFrom.getLikeInfo().likeNum;
                    R.getLikeInfo().isLiked = createFrom.getLikeInfo().isLiked;
                    R.getFeedCommInfo().curlikekey = createFrom.getFeedCommInfo().curlikekey;
                    R.getFeedCommInfo().orglikekey = createFrom.getFeedCommInfo().orglikekey;
                }
                switch (intValue) {
                    case 1048577:
                        R.getCommentInfo().commments = createFrom.getCommentInfo().commments;
                        break;
                    case 1048578:
                        if (createFrom.getCommentInfo().commments != null && createFrom.getCommentInfo().commments.size() != 0) {
                            if (R.getCommentInfo().commments != null) {
                                ArrayList<Comment> arrayList = R.getCommentInfo().commments;
                                ArrayList<Comment> arrayList2 = createFrom.getCommentInfo().commments;
                                ArrayList arrayList3 = null;
                                for (int size = arrayList.size() - 1; size >= 0; size--) {
                                    Comment comment = arrayList.get(size);
                                    if (comment.isTempData) {
                                        if (arrayList3 == null) {
                                            arrayList3 = new ArrayList();
                                        }
                                        arrayList3.add(comment);
                                        arrayList.remove(comment);
                                    }
                                }
                                if (arrayList3 != null) {
                                    for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
                                        Comment comment2 = (Comment) arrayList3.get(size2);
                                        Iterator<Comment> it = arrayList2.iterator();
                                        while (it.hasNext()) {
                                            Comment next = it.next();
                                            if (!TextUtils.isEmpty(comment2.commentid) && comment2.commentid.equals(next.commentid)) {
                                                arrayList3.remove(comment2);
                                            }
                                        }
                                    }
                                }
                                arrayList.addAll(arrayList2);
                                if (arrayList3 != null && arrayList3.size() > 0) {
                                    arrayList.addAll(arrayList3);
                                    break;
                                }
                            } else {
                                R.getCommentInfo().commments = new ArrayList<>();
                                break;
                            }
                        }
                        break;
                }
                if (booleanValue) {
                    R.setDbPriority((int) (System.currentTimeMillis() / 1000));
                    w(R);
                }
                if (R.getCommentEssence() != null && (i3 = R.getCommentEssence().commentNum) > 0) {
                    this.E = i3;
                }
            }
            notify(5, Integer.valueOf(this.C));
            Bundle bundle = new Bundle();
            ParcelableWrapper.putDataToBundle(bundle, BusinessFeedData.STORE_KEY, R);
            bundle.putInt("hasmore", this.C);
            result.setData(bundle);
        } else {
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }

    private void f0(QZoneTask qZoneTask) {
        this.f46826d = false;
        BusinessFeedData R = R();
        QZoneResult result = qZoneTask.getResult(1000144);
        mobile_detail_rsp mobile_detail_rspVar = (mobile_detail_rsp) qZoneTask.mRequest.rsp;
        if (mobile_detail_rspVar != null) {
            BusinessFeedData createFrom = BusinessFeedData.createFrom(mobile_detail_rspVar.detail_data);
            if (createFrom == null) {
                return;
            }
            HashMap<Object, Object> hashMap = qZoneTask.extraData;
            if (hashMap != null) {
                int intValue = ((Integer) hashMap.get(0)).intValue();
                ((Integer) qZoneTask.extraData.get(1)).intValue();
                boolean booleanValue = ((Boolean) qZoneTask.extraData.get(2)).booleanValue();
                this.E = mobile_detail_rspVar.hasmore_essence;
                this.D = mobile_detail_rspVar.attach_info_essence;
                int i3 = createFrom.getCommentEssence() != null ? createFrom.getCommentEssence().commentNum : 0;
                if (R.getCommentEssence() != null) {
                    R.getCommentEssence().commentNum = i3;
                }
                if (intValue != 1048577) {
                    if (intValue == 1048579 && createFrom.getCommentEssence() != null && createFrom.getCommentEssence().commments != null && createFrom.getCommentEssence().commments.size() != 0) {
                        if (R.getCommentEssence() != null && R.getCommentEssence().commments != null) {
                            ArrayList<Comment> arrayList = R.getCommentEssence().commments;
                            ArrayList<Comment> arrayList2 = createFrom.getCommentEssence().commments;
                            ArrayList arrayList3 = null;
                            for (int size = arrayList.size() - 1; size >= 0; size--) {
                                Comment comment = arrayList.get(size);
                                if (comment.isTempData) {
                                    if (arrayList3 == null) {
                                        arrayList3 = new ArrayList();
                                    }
                                    arrayList3.add(comment);
                                    arrayList.remove(comment);
                                }
                            }
                            if (arrayList3 != null) {
                                for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
                                    Comment comment2 = (Comment) arrayList3.get(size2);
                                    Iterator<Comment> it = arrayList2.iterator();
                                    while (it.hasNext()) {
                                        Comment next = it.next();
                                        if (!TextUtils.isEmpty(comment2.commentid) && comment2.commentid.equals(next.commentid)) {
                                            arrayList3.remove(comment2);
                                        }
                                    }
                                }
                            }
                            arrayList.addAll(arrayList2);
                            if (arrayList3 != null && arrayList3.size() > 0) {
                                arrayList.addAll(arrayList3);
                            }
                        } else {
                            R.getCommentEssence().commments = new ArrayList<>();
                        }
                    }
                } else {
                    R.getCommentInfo().commments = createFrom.getCommentInfo().commments;
                }
                if (booleanValue) {
                    R.setDbPriority((int) (System.currentTimeMillis() / 1000));
                    w(R);
                }
            }
            Bundle bundle = new Bundle();
            ParcelableWrapper.putDataToBundle(bundle, BusinessFeedData.STORE_KEY, R);
            bundle.putInt("hasmore", this.E);
            result.setData(bundle);
        } else {
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }

    private void h0(QZoneTask qZoneTask) {
        this.f46827e = false;
        QZoneResult result = qZoneTask.getResult(999900);
        qun_get_detail_rsp qun_get_detail_rspVar = (qun_get_detail_rsp) qZoneTask.mRequest.rsp;
        if (qun_get_detail_rspVar != null) {
            BusinessFeedData createFrom = BusinessFeedData.createFrom(qun_get_detail_rspVar.detail_data);
            this.f46828f = createFrom;
            createFrom.setDbPriority((int) (System.currentTimeMillis() / 1000));
            w(this.f46828f);
            this.C = qun_get_detail_rspVar.hasmore;
            this.f46831m = qun_get_detail_rspVar.attach_info;
            Bundle bundle = new Bundle();
            ParcelableWrapper.putDataToBundle(bundle, BusinessFeedData.STORE_KEY, this.f46828f);
            result.setData(bundle);
        } else {
            result.setSucceed(false);
        }
        y0(qZoneTask, result);
        qZoneTask.sendResultMsg(result);
    }

    private void i0(QZoneTask qZoneTask) {
        this.f46826d = false;
        BusinessFeedData R = R();
        QZoneResult result = qZoneTask.getResult(999927);
        qun_get_detail_rsp qun_get_detail_rspVar = (qun_get_detail_rsp) qZoneTask.mRequest.rsp;
        if (qun_get_detail_rspVar != null) {
            BusinessFeedData createFrom = BusinessFeedData.createFrom(qun_get_detail_rspVar.detail_data);
            if (createFrom == null) {
                return;
            }
            HashMap<Object, Object> hashMap = qZoneTask.extraData;
            if (hashMap != null) {
                int intValue = ((Integer) hashMap.get(0)).intValue();
                boolean z16 = ((Integer) qZoneTask.extraData.get(1)).intValue() == 1;
                this.C = qun_get_detail_rspVar.hasmore;
                this.f46831m = qun_get_detail_rspVar.attach_info;
                R.getCommentInfo().commentNum = createFrom.getCommentInfo().commentNum;
                if (z16) {
                    R.getLikeInfo().likeMans = createFrom.getLikeInfo().likeMans;
                    R.getLikeInfo().likeNum = createFrom.getLikeInfo().likeNum;
                    R.getLikeInfo().isLiked = createFrom.getLikeInfo().isLiked;
                    R.getFeedCommInfo().curlikekey = createFrom.getFeedCommInfo().curlikekey;
                    R.getFeedCommInfo().orglikekey = createFrom.getFeedCommInfo().orglikekey;
                }
                switch (intValue) {
                    case 1048577:
                        R.getCommentInfo().commments = createFrom.getCommentInfo().commments;
                        break;
                    case 1048578:
                        if (createFrom.getCommentInfo().commments != null && createFrom.getCommentInfo().commments.size() != 0) {
                            if (R.getCommentInfo().commments != null) {
                                ArrayList<Comment> arrayList = R.getCommentInfo().commments;
                                ArrayList<Comment> arrayList2 = createFrom.getCommentInfo().commments;
                                ArrayList arrayList3 = null;
                                for (int size = arrayList.size() - 1; size >= 0; size--) {
                                    Comment comment = arrayList.get(size);
                                    if (comment.isTempData) {
                                        if (arrayList3 == null) {
                                            arrayList3 = new ArrayList();
                                        }
                                        arrayList3.add(comment);
                                        arrayList.remove(comment);
                                    }
                                }
                                if (arrayList3 != null) {
                                    for (int size2 = arrayList3.size() - 1; size2 >= 0; size2--) {
                                        Comment comment2 = (Comment) arrayList3.get(size2);
                                        Iterator<Comment> it = arrayList2.iterator();
                                        while (it.hasNext()) {
                                            Comment next = it.next();
                                            if (!TextUtils.isEmpty(comment2.commentid) && comment2.commentid.equals(next.commentid)) {
                                                arrayList3.remove(comment2);
                                            }
                                        }
                                    }
                                }
                                arrayList.addAll(arrayList2);
                                if (arrayList3 != null && arrayList3.size() > 0) {
                                    arrayList.addAll(arrayList3);
                                    break;
                                }
                            } else {
                                R.getCommentInfo().commments = new ArrayList<>();
                                break;
                            }
                        }
                        break;
                }
            }
            R.setDbPriority((int) (System.currentTimeMillis() / 1000));
            w(R);
            Bundle bundle = new Bundle();
            ParcelableWrapper.putDataToBundle(bundle, BusinessFeedData.STORE_KEY, R);
            result.setData(bundle);
        } else {
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        notify(1, new Object[0]);
    }

    private void o0() {
        notify(2, new Object[0]);
    }

    private void u0() {
        notify(3, new Object[0]);
    }

    public void J() {
        this.f46829h = null;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void close() {
        this.f46828f = null;
        DbCacheManager T = T();
        if (T != null) {
            T.close();
        }
        this.I.a();
        this.f46830i = null;
        M();
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    @Deprecated
    public void z(String str, boolean z16) {
        u(str, null, z16);
    }

    public void H(BusinessFeedData businessFeedData, int i3) {
        if (businessFeedData == null || !businessFeedData.isLiveVideoFeed()) {
            return;
        }
        BusinessFeedData originalInfo = businessFeedData.getOriginalInfo() != null ? businessFeedData.getOriginalInfo() : null;
        long j06 = i.H().j0();
        long j3 = businessFeedData.getUser() != null ? businessFeedData.getUser().uin : 0L;
        long j16 = (originalInfo == null || originalInfo.getUser() == null) ? 0L : originalInfo.getUser().uin;
        LpReportInfo_dc01245.report(j16 != 0 ? j16 : j3, j06, i3, 0);
    }

    public void X(final long j3, final int i3, final String str, final String str2, Map<Integer, String> map, final Handler handler, final String str3, final Map<String, String> map2, final boolean z16, final String str4) {
        final Map<Integer, String> hashMap = map == null ? new HashMap() : map;
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.detail.business.service.QZoneDetailService.3
            @Override // java.lang.Runnable
            public void run() {
                QZoneRequest qzoneGetFeedDetailRequest = new QzoneGetFeedDetailRequest(j3, i3, str, str2, (Map<Integer, String>) hashMap, (Map<String, String>) map2, z16, str4);
                BusinessFeedData R = QZoneDetailService.this.R();
                if (R != null && R.isGDTAdvFeed() && !R.isBrandUgcAdvFeeds() && !R.isMyMediaCardAdvFeed()) {
                    qzoneGetFeedDetailRequest = new QZoneGetADFeedDetailRequest(j3, i3, str, str2, hashMap);
                }
                String str5 = str3;
                if (str5 != null) {
                    qzoneGetFeedDetailRequest.setRefer(str5);
                }
                QZoneBusinessLooper.getInstance().runTask(new QZoneTask(qzoneGetFeedDetailRequest, handler, QZoneDetailService.this, 0));
                QZoneDetailService.this.f46827e = true;
            }
        });
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void w(BusinessFeedData businessFeedData) {
        DbCacheManager T;
        if (businessFeedData == null || (T = T()) == null) {
            return;
        }
        T.Z(businessFeedData, 1);
    }

    private void N(b bVar) {
        DbCacheManager dbCacheManager;
        if (bVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != bVar.f46843a || (dbCacheManager = bVar.f46844b) == null || dbCacheManager.isClosed()) {
            bVar.f46843a = uin;
            DbCacheManager e16 = com.qzone.component.cache.database.c.g().e(BusinessFeedData.class, uin, P());
            bVar.f46844b = e16;
            e16.U(new a());
        }
    }

    private void g0(QZoneTask qZoneTask) {
        String str;
        QZoneResult result = qZoneTask.getResult(1000108);
        try {
            try {
                operation_hide_feeds_rsp operation_hide_feeds_rspVar = (operation_hide_feeds_rsp) qZoneTask.mRequest.rsp;
                if (operation_hide_feeds_rspVar != null) {
                    result.setSucceed(operation_hide_feeds_rspVar.ret == 0);
                    if (operation_hide_feeds_rspVar.ret == 0) {
                        Object parameter = qZoneTask.getParameter(IQZoneFeedOperateLogicInterface.EVENT_PARAMETER_KEY_HIDE_FEEDS_KEY);
                        if (parameter == null) {
                            str = "";
                        } else {
                            str = (String) parameter;
                        }
                        EventCenter.getInstance().post("WriteOperation", 38, str);
                    }
                } else {
                    result.setSucceed(false);
                }
            } catch (Exception e16) {
                result.setSucceed(false);
                QZLog.w("handleHideSignleFeedRespone", e16.toString());
            }
        } finally {
            qZoneTask.sendResultMsg(result);
        }
    }

    private void j0(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(999900);
        mobile_detail_rsp mobile_detail_rspVar = (mobile_detail_rsp) qZoneTask.mRequest.rsp;
        if (mobile_detail_rspVar != null) {
            BusinessFeedData createFrom = BusinessFeedData.createFrom(mobile_detail_rspVar.detail_data);
            if (createFrom != null) {
                createFrom.setDbPriority((int) (System.currentTimeMillis() / 1000));
            }
            Bundle bundle = new Bundle();
            ParcelableWrapper.putDataToBundle(bundle, BusinessFeedData.STORE_KEY, createFrom);
            result.setData(bundle);
        } else {
            result.setSucceed(false);
        }
        qZoneTask.sendResultMsg(result);
    }

    public void E0(BusinessFeedData businessFeedData, boolean z16) {
        if (businessFeedData == null) {
            return;
        }
        if (this.f46828f != null && businessFeedData.getFeedCommInfo() != null && businessFeedData.isGDTAdvFeed()) {
            businessFeedData.getFeedCommInfo().feedsAttr2 |= 32;
        }
        if (this.f46828f != null && businessFeedData.getFeedCommInfo().ugckey.equals(this.f46828f.getFeedCommInfo().ugckey)) {
            this.f46828f = businessFeedData;
            if (this.f46830i != null && businessFeedData.getOperationInfoV2() != null && this.f46828f.getOperationInfoV2().feedReportCookie != null) {
                this.f46828f.getOperationInfoV2().putAllFeedReportCookieSync(this.f46830i);
            }
        }
        DbCacheManager T = T();
        if (T != null && T.a0(businessFeedData, "feed_key=?", new String[]{businessFeedData.getFeedCommInfo().feedskey}) && z16) {
            n0();
        }
    }

    protected void L(BusinessFeedData businessFeedData) {
        if (businessFeedData != null) {
            u("feed_key=?", new String[]{businessFeedData.getFeedCommInfo().feedskey}, false);
        }
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void l(BusinessFeedData businessFeedData, String str, boolean z16) {
        if (businessFeedData == null) {
            return;
        }
        if (this.f46828f != null && !TextUtils.isEmpty(businessFeedData.getFeedCommInfo().ugckey) && businessFeedData.getFeedCommInfo().ugckey.equals(this.f46828f.getFeedCommInfo().ugckey)) {
            this.f46828f = businessFeedData;
            if (this.f46830i != null && businessFeedData.getOperationInfoV2() != null && this.f46828f.getOperationInfoV2().feedReportCookie != null) {
                this.f46829h.getOperationInfoV2().putAllFeedReportCookieSync(this.f46830i);
            }
        }
        DbCacheManager T = T();
        if (T != null) {
            String[] strArr = {businessFeedData.getFeedCommInfo().feedskey};
            if (TextUtils.isEmpty(str)) {
                str = "feed_key=?";
            }
            if (T.a0(businessFeedData, str, strArr) && z16) {
                n0();
            }
        }
    }

    @Override // com.qzone.common.event.IObserver.background
    public void onEventBackgroundThread(Event event) {
        Object[] objArr = (Object[]) event.params;
        if ("WriteOperation".equals(event.source.getName())) {
            int i3 = event.what;
            if (i3 == 31) {
                p0((String) objArr[1]);
                return;
            }
            if (i3 == 34) {
                p0((String) objArr[0]);
                return;
            }
            if (i3 == 37) {
                s0((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Long) objArr[2]).longValue(), ((Boolean) objArr[3]).booleanValue());
                return;
            }
            if (i3 == 43) {
                f.x0(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], ((Long) objArr[3]).longValue(), ((Integer) objArr[4]).intValue());
                return;
            }
            if (i3 == 46) {
                r0((String) objArr[0], (String) objArr[1]);
                return;
            }
            if (i3 == 83) {
                if (objArr == null || objArr.length <= 1) {
                    return;
                }
                f.I0(this, (String) objArr[0], ((Integer) objArr[1]).intValue());
                return;
            }
            if (i3 == 55) {
                f.y0(this, (String) objArr[0], (String) objArr[1], (String) objArr[2]);
                return;
            }
            if (i3 == 56) {
                f.Q0(this, (String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Integer) objArr[3]).intValue() != 1000, ((Integer) objArr[4]).intValue(), (CustomPraiseData) objArr[5], -1, null);
                return;
            }
            if (i3 == 58) {
                f.U(this, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Integer) objArr[3]).intValue());
                return;
            }
            if (i3 == 59) {
                f.V(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], ((Boolean) objArr[3]).booleanValue(), ((Integer) objArr[4]).intValue(), (String) objArr[5], ((Boolean) objArr[6]).booleanValue(), ((Integer) objArr[7]).intValue());
                return;
            }
            if (i3 == 68) {
                f.D0(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], ((Boolean) objArr[3]).booleanValue(), ((Integer) objArr[4]).intValue());
                return;
            }
            if (i3 != 69) {
                switch (i3) {
                    case 3:
                        f.M(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], (PictureItem) objArr[5], objArr.length >= 8 ? (ArrayList) objArr[7] : null, objArr.length >= 9 ? (Map) objArr[8] : null);
                        return;
                    case 4:
                        if (objArr.length > 7) {
                            f.P(this, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), (String) objArr[3], ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), (String) objArr[8], objArr.length > 10 ? (Map) objArr[10] : null);
                            return;
                        } else {
                            f.N(this, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), (String) objArr[3], ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue());
                            return;
                        }
                    case 5:
                        f.z0(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], (User) objArr[5], (Map) objArr[7]);
                        return;
                    case 6:
                        f.n0(this, (String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Integer) objArr[3]).intValue() != 1000, ((Integer) objArr[4]).intValue(), (CustomPraiseData) objArr[5], ((Integer) objArr[6]).intValue(), (PolymorphicPraiseEmotionData) objArr[7]);
                        return;
                    case 7:
                        f.o0(this, (String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue());
                        return;
                    case 8:
                        f.e0(this, (String) objArr[0], (String) objArr[1]);
                        return;
                    case 9:
                        f.k0(this, (String) objArr[0], (String) objArr[1]);
                        return;
                    default:
                        switch (i3) {
                            case 14:
                                t0((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Integer) objArr[2]).intValue(), (String) objArr[3], (String) objArr[4], ((Integer) objArr[5]).intValue(), (CustomPraiseData) objArr[6]);
                                return;
                            case 15:
                                f.Y(this, (String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                                return;
                            case 16:
                                f.a0(this, (String) objArr[0], (String) objArr[1], (String) objArr[2]);
                                return;
                            case 17:
                                q0((String) objArr[0], (String) objArr[1]);
                                return;
                            case 18:
                                u0();
                                return;
                            case 19:
                                m0((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), (String) objArr[2], (String) objArr[3], (PictureItem) objArr[4]);
                                return;
                            case 20:
                                f.A0(this, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), (String) objArr[3], (String) objArr[5], ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), ((Integer) objArr[8]).intValue(), (String) objArr[9]);
                                return;
                            default:
                                switch (i3) {
                                    case 39:
                                        f.l0(this, (String) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), ((Boolean) objArr[4]).booleanValue());
                                        return;
                                    case 40:
                                        f.Z(this, (String) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                                        return;
                                    case 41:
                                        f.b0(this, (String) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                                        return;
                                    default:
                                        switch (i3) {
                                            case 72:
                                                f.H0(this, (String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                                                return;
                                            case 73:
                                                f.K(this, (String) objArr[0]);
                                                return;
                                            case 74:
                                                f.L(this, ((Boolean) objArr[0]).booleanValue(), (String) objArr[1], (String) objArr[2]);
                                                return;
                                            default:
                                                return;
                                        }
                                }
                        }
                }
            }
            f.E0(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], ((Boolean) objArr[3]).booleanValue(), ((Integer) objArr[4]).intValue(), (String) objArr[5], (String) objArr[6], ((Boolean) objArr[7]).booleanValue(), ((Integer) objArr[8]).intValue());
            return;
        }
        if (event.what == 1) {
            f.q0(this, (String) objArr[0], (ArrayList) objArr[1], ((Boolean) objArr[2]).booleanValue());
        } else if ("Feed".equals(event.source.getName()) && event.what == 31) {
            v0((String) objArr[0], (String) objArr[1], (String) objArr[2]);
        }
    }

    private BusinessFeedData K(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        ParcelableWrapper.writeDataToParcel(obtain, 0, businessFeedData);
        obtain.setDataPosition(0);
        BusinessFeedData businessFeedData2 = (BusinessFeedData) ParcelableWrapper.createDataFromParcel(obtain);
        OaidMonitor.parcelRecycle(obtain);
        return businessFeedData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(BusinessFeedData businessFeedData, BusinessFeedData businessFeedData2) {
        if (businessFeedData == null || businessFeedData2 == null) {
            return;
        }
        if (businessFeedData.isGDTAdvFeed() && businessFeedData.isBrandUgcAdvFeeds()) {
            businessFeedData2.getFeedCommInfo().feedsAttr2 |= 32;
            if (businessFeedData2.getOperationInfo().cookie != null && businessFeedData.getOperationInfo().cookie != null) {
                businessFeedData2.getOperationInfo().cookie.putAll(businessFeedData.getOperationInfo().cookie);
            } else {
                businessFeedData2.getOperationInfo().cookie = businessFeedData.getOperationInfo().cookie;
            }
            if (businessFeedData2.getOperationInfo().busiParam != null && businessFeedData.getOperationInfo().busiParam != null) {
                businessFeedData2.getOperationInfo().busiParam.putAll(businessFeedData.getOperationInfo().busiParam);
            } else {
                businessFeedData2.getOperationInfo().busiParam = businessFeedData.getOperationInfo().busiParam;
            }
            businessFeedData2.getFeedCommInfo().setBrandUgcAdvFeeds();
        }
        if (businessFeedData.isMyMediaCardAdvFeed()) {
            businessFeedData2.getFeedCommInfo().feedsAttr2 |= 131072;
        }
    }

    public void a0(long j3, int i3, String str, String str2, String str3, int i16, Map<Integer, String> map, int i17, boolean z16, boolean z17, Handler handler) {
        int i18 = z16 ? 6 : 2;
        QZoneRequest qzoneGetFeedDetailRequest = new QzoneGetFeedDetailRequest(j3, i3, str, str2, i18, str3, i16, map);
        BusinessFeedData R = R();
        if (R != null && R.isAdFeeds()) {
            qzoneGetFeedDetailRequest = new QZoneGetADFeedDetailRequest(j3, i3, str, str2, i18, str3, i16, map);
        }
        QZoneTask qZoneTask = new QZoneTask(qzoneGetFeedDetailRequest, handler, this, 1);
        qZoneTask.extraData.put(0, Integer.valueOf(i17));
        qZoneTask.extraData.put(1, Integer.valueOf(z16 ? 1 : 0));
        qZoneTask.extraData.put(2, Boolean.valueOf(z17));
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        this.f46826d = true;
    }

    public void b0(long j3, int i3, String str, String str2, String str3, int i16, Map<Integer, String> map, int i17, boolean z16, boolean z17, Handler handler) {
        int i18 = z16 ? 38 : 34;
        QZoneRequest qzoneGetFeedDetailRequest = new QzoneGetFeedDetailRequest(j3, i3, str, str2, i18, str3, i16, map);
        BusinessFeedData R = R();
        if (R != null && R.isAdFeeds()) {
            qzoneGetFeedDetailRequest = new QZoneGetADFeedDetailRequest(j3, i3, str, str2, i18, str3, i16, map);
        }
        QZoneTask qZoneTask = new QZoneTask(qzoneGetFeedDetailRequest, handler, this, 8);
        qZoneTask.extraData.put(0, Integer.valueOf(i17));
        qZoneTask.extraData.put(1, Integer.valueOf(z16 ? 1 : 0));
        qZoneTask.extraData.put(2, Boolean.valueOf(z17));
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        this.f46826d = true;
    }

    public void Y(long j3, int i3, String str, String str2, Map<Integer, String> map, Handler handler, boolean z16) {
        X(j3, i3, str, str2, map, handler, null, null, z16, null);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void p(com.qzone.proxy.feedcomponent.manager.c cVar) {
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void o(long j3, long j16) {
    }
}
