package com.qzone.feed.business.service;

import NS_MOBILE_FEEDS.s_event_tag;
import NS_MOBILE_FEEDS.single_feed;
import NS_UNDEAL_COUNT.feed_host_info;
import NS_UNDEAL_COUNT.feed_info;
import android.text.TextUtils;
import com.qzone.adapter.feedcomponent.e;
import com.qzone.adapter.feedcomponent.f;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.qzone.proxy.feedcomponent.manager.e;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellFollowGuide;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.proxy.feedcomponent.model.CellPresentInfo;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PolymorphicPraiseEmotionData;
import com.qzone.proxy.feedcomponent.model.PresentMan;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.service.FeedIncrementalUpdateService;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.publish.business.publishqueue.h;
import com.qzone.publish.business.task.QZoneQueueTask;
import com.qzone.publish.ui.model.MediaWrapper;
import com.qzone.reborn.qqvideo.layer.QZoneQVideoFeedConvertManager;
import com.qzone.util.image.ImageInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.WiFiDash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d implements com.qzone.proxy.feedcomponent.manager.d, IObserver.background {

    /* renamed from: d, reason: collision with root package name */
    private long f47223d;

    /* renamed from: e, reason: collision with root package name */
    private long f47224e;

    /* renamed from: f, reason: collision with root package name */
    private int f47225f;

    /* renamed from: h, reason: collision with root package name */
    private com.qzone.proxy.feedcomponent.manager.c f47226h;

    /* renamed from: i, reason: collision with root package name */
    private e f47227i;

    /* renamed from: m, reason: collision with root package name */
    private e.a f47228m;

    public d(com.qzone.proxy.feedcomponent.manager.e eVar, e.a aVar, int i3, int i16) {
        this.f47225f = i3;
        this.f47227i = eVar;
        this.f47228m = aVar;
    }

    private void B(BusinessFeedData businessFeedData) {
        VideoInfo videoInfo;
        CellLocalInfo localInfo = businessFeedData.getLocalInfo();
        if ((localInfo != null && localInfo.isFake()) && (videoInfo = businessFeedData.getVideoInfo()) != null) {
            videoInfo.playType = (byte) (videoInfo.playType & 1);
        }
    }

    private void C(BusinessFeedData businessFeedData, boolean z16) {
        if (businessFeedData.getRecommAction() != null) {
            businessFeedData.getRecommAction().hasFollowed = z16 ? 1 : 0;
            if (businessFeedData.isSingleAdvContainerFeed()) {
                Iterator<BusinessFeedData> it = businessFeedData.getRecBusinessFeedDatas().iterator();
                while (it.hasNext()) {
                    BusinessFeedData next = it.next();
                    if (next.getRecommAction() != null) {
                        next.getRecommAction().hasFollowed = z16 ? 1 : 0;
                    }
                }
            }
        }
    }

    private void c() {
        EventCenter.getInstance().removeObserver(this);
    }

    private boolean e(String str, String[] strArr) {
        BusinessFeedData query = this.f47227i.query(str, strArr);
        if (query == null) {
            return false;
        }
        if (un.c.e().h(query)) {
            if (this.f47227i.deleteFeedDataDbOnly(str, strArr)) {
                FeedManager.addDeletedFakeFeedClientKey(query.getFeedCommInfo().clientkey);
                return un.c.e().q(query, this.f47227i.getCurrentUIDatas());
            }
            QLog.e("QZoneReeditContentRecordManager", 1, "hookReeditFeedIfNeed delete DB failed!");
            return false;
        }
        QLog.d("QZoneReeditContentRecordManager", 1, "hookReeditFeedIfNeed not hit,direct return!");
        return false;
    }

    private void g(String str, boolean z16, long j3, boolean z17, boolean z18) {
        BusinessFeedData businessFeedData;
        List<BusinessFeedData> currentUIDatas;
        BusinessFeedData queryWithMem = queryWithMem("ugc_key= ?", str, null);
        com.qzone.proxy.feedcomponent.manager.e eVar = this.f47227i;
        if (eVar == null || (currentUIDatas = eVar.getCurrentUIDatas()) == null || currentUIDatas.size() <= 0) {
            businessFeedData = null;
        } else {
            businessFeedData = null;
            for (BusinessFeedData businessFeedData2 : currentUIDatas) {
                if (businessFeedData2.getUser() != null && businessFeedData2.getUser().uin == j3) {
                    if (businessFeedData2.getFeedCommInfo() != null) {
                        A(businessFeedData2, z18, z16);
                    }
                    if (businessFeedData2.getRecommAction() != null && !z18) {
                        businessFeedData2.getRecommAction().hasFollowed = z16 ? 1 : 0;
                    }
                    if (!businessFeedData2.isFriendLikeContainer() && businessFeedData2.getRecBusinessFeedDatas() != null) {
                        Iterator<BusinessFeedData> it = businessFeedData2.getRecBusinessFeedDatas().iterator();
                        while (it.hasNext()) {
                            BusinessFeedData next = it.next();
                            if (next.getFeedCommInfo() != null) {
                                A(next, z18, z16);
                            }
                            if (next.getRecommAction() != null && !z18) {
                                next.getRecommAction().hasFollowed = z16 ? 1 : 0;
                            }
                        }
                    }
                    l(businessFeedData2, null, false);
                }
                if (businessFeedData2.getOriginalInfo() != null && businessFeedData2.getOriginalInfo().getUser() != null && businessFeedData2.getOriginalInfo().getUser().uin == j3) {
                    BusinessFeedData originalInfo = businessFeedData2.getOriginalInfo();
                    if (originalInfo.getFeedCommInfo() != null) {
                        A(originalInfo, z18, z16);
                    }
                    if (originalInfo.getRecommAction() != null && !z18) {
                        originalInfo.getRecommAction().hasFollowed = z16 ? 1 : 0;
                    }
                    l(businessFeedData2, null, false);
                    businessFeedData = businessFeedData2;
                }
            }
        }
        if (queryWithMem == null) {
            if (businessFeedData != null) {
                l(businessFeedData, null, !z17);
                return;
            }
            return;
        }
        if (!z17) {
            if (queryWithMem.getFeedCommInfo() != null) {
                A(queryWithMem, z18, z16);
            }
            C(queryWithMem, z16);
        } else {
            if (queryWithMem.getOriginalInfoSafe().getFeedCommInfo() != null) {
                queryWithMem.getOriginalInfoSafe().getFeedCommInfo().isFollowed = z16;
            }
            if (queryWithMem.getOriginalInfoSafe().getRecommAction() != null) {
                queryWithMem.getOriginalInfoSafe().getRecommAction().hasFollowed = z16 ? 1 : 0;
            }
        }
        l(queryWithMem, null, !z17);
    }

    private void j(long j3) {
        List<BusinessFeedData> currentUIDatas = this.f47227i.getCurrentUIDatas();
        if (currentUIDatas == null || currentUIDatas.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (BusinessFeedData businessFeedData : currentUIDatas) {
            if (businessFeedData.getUser().uin == j3 && !businessFeedData.getFeedCommInfo().isFamousRecommAdvFeed()) {
                arrayList.add(businessFeedData);
            }
        }
        b(arrayList);
    }

    private void k(long j3, boolean z16) {
        com.qzone.proxy.feedcomponent.manager.c cVar;
        List<BusinessFeedData> currentUIDatas = this.f47227i.getCurrentUIDatas();
        boolean z17 = false;
        if (currentUIDatas != null && !currentUIDatas.isEmpty()) {
            boolean z18 = false;
            for (BusinessFeedData businessFeedData : currentUIDatas) {
                if (businessFeedData != null && businessFeedData.getUser().uin == j3 && (businessFeedData.getFeedCommInfo().isFamousRecommAdvFeed() || businessFeedData.getFeedCommInfo().isLikeRecommFamousFeed() || businessFeedData.isBrandUgcAdvFeeds())) {
                    businessFeedData.getFeedCommInfo().isFollowed = z16;
                    if (businessFeedData.getRecommAction() != null) {
                        businessFeedData.getRecommAction().hasFollowed = z16 ? 1 : 0;
                    }
                    l(businessFeedData, null, false);
                    z18 = true;
                }
            }
            z17 = z18;
        }
        if (!z17 || (cVar = this.f47226h) == null) {
            return;
        }
        cVar.onFeedUpdate(null, z17);
    }

    private synchronized void n(HashMap<String, FeedIncrementalUpdateService.a> hashMap) {
        ArrayList arrayList = new ArrayList();
        List<BusinessFeedData> increaseUpdate = this.f47227i.increaseUpdate(hashMap, arrayList);
        if (increaseUpdate != null && increaseUpdate.size() > 0) {
            this.f47226h.onFeedPartionUpdate(increaseUpdate);
        }
        if (arrayList.size() > 0) {
            QZoneFeedUpdateService.c().b(arrayList);
        }
    }

    private void q(String str) {
        BusinessFeedData queryWithMem = this.f47227i.queryWithMem(null, str, null);
        if (queryWithMem != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(queryWithMem);
            QZoneFeedUpdateService.c().a(arrayList);
        }
    }

    private void r(String str) {
        BusinessFeedData queryWithMem = this.f47227i.queryWithMem(null, str, null);
        if (queryWithMem != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(queryWithMem);
            QZoneFeedUpdateService.c().b(arrayList);
        }
    }

    private void s(String str, String str2, String str3) {
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
        this.f47226h.onFeedUpdate(queryWithMem, true);
    }

    public static void t(com.qzone.proxy.feedcomponent.manager.d dVar, String str, BusinessFeedData businessFeedData) {
        if (QZoneQVideoFeedConvertManager.f58793a.a(dVar, str, businessFeedData) || FeedManager.shouldFilterDeletedFakeFeed(businessFeedData)) {
            return;
        }
        f.r0(dVar, str, businessFeedData);
    }

    private synchronized void v(List<single_feed> list) {
        List<BusinessFeedData> increaseUpdate = this.f47227i.increaseUpdate(list, new ArrayList());
        if (increaseUpdate != null && increaseUpdate.size() > 0) {
            this.f47226h.onFeedPartionUpdate(increaseUpdate);
        }
    }

    private void x(String str) {
        com.qzone.proxy.feedcomponent.manager.e eVar;
        if (TextUtils.isEmpty(str) || (eVar = this.f47227i) == null) {
            return;
        }
        BusinessFeedData feedDataByFeedsKey = eVar.getFeedDataByFeedsKey(str);
        if (feedDataByFeedsKey != null && feedDataByFeedsKey.cellNegativeFeedback != null) {
            if (!feedDataByFeedsKey.isNegativeFeedback()) {
                this.f47227i.getFeedDataByFeedsKey(str).setNegativeFeedback(true);
                com.qzone.proxy.feedcomponent.manager.c cVar = this.f47226h;
                if (cVar != null) {
                    cVar.onFeedUpdate(feedDataByFeedsKey, true);
                }
                LpReportInfo_pf00064.allReport(302, 90, 1);
                return;
            }
            this.f47227i.getFeedDataByFeedsKey(str).setNegativeFeedback(false);
            this.f47227i.deleteByFeedsKey(str, true);
            com.qzone.proxy.feedcomponent.manager.c cVar2 = this.f47226h;
            if (cVar2 != null) {
                cVar2.onFeedDelete();
                return;
            }
            return;
        }
        this.f47227i.deleteByFeedsKey(str, true);
        com.qzone.proxy.feedcomponent.manager.c cVar3 = this.f47226h;
        if (cVar3 != null) {
            cVar3.onFeedDelete();
        }
    }

    private void y(String str) {
        CellFollowGuide cellFollowGuide;
        BusinessFeedData queryWithMem = queryWithMem("ugc_key = ?", str, null);
        if (queryWithMem == null || (cellFollowGuide = queryWithMem.cellFollowGuide) == null) {
            return;
        }
        cellFollowGuide.hideTextAndAvatar = true;
        l(queryWithMem, null, true);
    }

    public int d() {
        return this.f47225f;
    }

    public void i(String str) {
        List<BusinessFeedData> currentUIDatas;
        if (TextUtils.isEmpty(str) || (currentUIDatas = this.f47227i.getCurrentUIDatas()) == null || currentUIDatas.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (BusinessFeedData businessFeedData : currentUIDatas) {
            if (businessFeedData.getPictureInfo() != null && str.equals(businessFeedData.getPictureInfo().albumid)) {
                arrayList.add(businessFeedData);
            }
        }
        b(arrayList);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void notify(int i3, Object... objArr) {
        EventCenter.getInstance().post(this.f47228m.f41884a, i3, objArr);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void o(long j3, long j16) {
        if (this.f47223d == j3 && this.f47224e == j16) {
            return;
        }
        this.f47223d = j3;
        this.f47224e = j16;
        a();
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void p(com.qzone.proxy.feedcomponent.manager.c cVar) {
        this.f47226h = cVar;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public BusinessFeedData queryWithMem(String str, String str2, String str3) {
        com.qzone.proxy.feedcomponent.manager.e eVar = this.f47227i;
        if (eVar == null) {
            return null;
        }
        BusinessFeedData queryWithMem = eVar.queryWithMem(str, str2, str3);
        if (queryWithMem == null) {
            return queryWithMem;
        }
        queryWithMem.hasCalculate = false;
        return queryWithMem;
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void u(String str, String[] strArr, boolean z16) {
        com.qzone.proxy.feedcomponent.manager.c cVar;
        if (this.f47227i != null) {
            if ((e(str, strArr) || this.f47227i.deleteFeedData(str, strArr)) && z16 && (cVar = this.f47226h) != null) {
                cVar.onFeedDelete();
            }
        }
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void w(BusinessFeedData businessFeedData) {
        com.qzone.proxy.feedcomponent.manager.c cVar;
        BusinessFeedData f16 = f(businessFeedData);
        com.qzone.proxy.feedcomponent.manager.e eVar = this.f47227i;
        if (eVar == null || !eVar.saveFakeFeed(f16) || (cVar = this.f47226h) == null) {
            return;
        }
        cVar.onFeedCreate(f16);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    @Deprecated
    public void z(String str, boolean z16) {
        u(str, null, z16);
    }

    private void A(BusinessFeedData businessFeedData, boolean z16, boolean z17) {
        if (z16) {
            businessFeedData.getFeedCommInfo().isSpecialFollowed = z17;
        } else {
            businessFeedData.getFeedCommInfo().isFollowed = z17;
        }
    }

    private void a() {
        int i3 = this.f47225f;
        if (i3 == 0) {
            EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 8, 6, 7, 5, 1, 9, 10, 20, 3, 4, 2, 42, 11, 13, 16, 41, 15, 40, 17, 46, 14, 70, 34, 37, 38, 39, 43, 44, 45, 55, 58, 59, 68, 69, 49, 60, 50, 53, 54, 56, 61, 72, 73, 74, 78, 85);
            EventCenter.getInstance().addObserver(this, 3, "Face", 1);
            EventCenter.getInstance().addObserver(this, 3, "Permission", 1, 2, 3);
            EventCenter.getInstance().addObserver(this, 3, "UGCPermission", 37, 67);
            EventCenter.getInstance().addObserver(this, 3, "PushDataUpdate", 1, 2, 3, 4, 5);
            EventCenter.getInstance().addObserver(this, 3, "Feed", 30, 31);
            return;
        }
        if (i3 == 23) {
            EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 8, 6, 7, 5, 9, 77, 20, 3, 4, 42, 13, 16, 41, 15, 40, 17, 46, 14, 34, 37, 38, 39, 43, 44, 45, 55, 58, 59, 68, 69, 49, 60, 50, 56, 61, 73, 74);
            EventCenter.getInstance().addObserver(this, 3, "Face", 1);
            EventCenter.getInstance().addObserver(this, 3, "Permission", 1, 2, 3);
            EventCenter.getInstance().addObserver(this, 3, "UGCPermission", 37, 67);
            EventCenter.getInstance().addObserver(this, 3, "PushDataUpdate", 1, 2, 3, 4, 5);
            EventCenter.getInstance().addObserver(this, 3, "Feed", 30);
            return;
        }
        if (i3 == 3 || i3 == 4 || i3 == 12) {
            EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 3, 8, 6, 7, 5, 20, 4, 58, 59, 68, 69, 13, 16, 15, 17, 46, 14, 43, 55, 56, 73, 74);
            EventCenter.getInstance().addObserver(this, 3, "Face", 1);
            if (this.f47225f == 4) {
                EventCenter.getInstance().addObserver(this, 3, "WriteOperation", new int[0]);
                return;
            }
            return;
        }
        if (i3 == 10) {
            EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 3, 8, 6, 7, 5, 20, 4, 58, 59, 68, 69, 13, 16, 15, 17, 46, 14, 38, 43, 55, 56, 72, 73, 74);
            EventCenter.getInstance().addObserver(this, 3, "Face", 1);
            return;
        }
        if (i3 == 15) {
            EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 3, 8, 6, 7, 5, 20, 4, 58, 59, 68, 69, 13, 16, 15, 17, 46, 14, 38, 43, 55, 56, 73, 74);
            EventCenter.getInstance().addObserver(this, 3, "Face", 1);
            return;
        }
        if (i3 == 19) {
            EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 8, 6, 7, 5, 1, 9, 10, 20, 3, 4, 2, 42, 11, 13, 16, 41, 15, 40, 17, 46, 14, 34, 37, 38, 39, 43, 44, 45, 55, 58, 59, 68, 69, 49, 60, 50, 53, 54, 56, 72, 73, 74);
            EventCenter.getInstance().addObserver(this, 3, "Face", 1);
            EventCenter.getInstance().addObserver(this, 3, "Permission", 1, 2, 3);
            EventCenter.getInstance().addObserver(this, 3, "UGCPermission", 37);
            return;
        }
        if (i3 == 1) {
            EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 12, 5, 38, 20, 4, 36, 16, 58, 59, 68, 69, 65, 78);
            return;
        }
        if (i3 == 2 || i3 == 18) {
            EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 3, 6, 5, 9, 20, 4, 16, 15, 14, 10, 11, 1, 2, 8, 17, 46, 13, 44, 45, 49, 60, 50, 43, 55, 56, 58, 59, 68, 69, 61, 37, 72, 73, 74, 78, 85);
            EventCenter.getInstance().addObserver(this, 3, "Face", 1);
            EventCenter.getInstance().addObserver(this, 3, "PushDataUpdate", 1, 2);
            EventCenter.getInstance().addObserver(this, 3, "Feed", 31);
            return;
        }
        if (i3 == 8) {
            EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 3, 8, 6, 7, 5, 20, 4, 16, 15, 17, 14, 43, 55, 56, 58, 59, 68, 69);
            return;
        }
        if (i3 == 24 || i3 == 26 || i3 == 27) {
            EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 8, 6, 7, 5, 1, 9, 10, 20, 3, 4, 2, 42, 11, 13, 16, 41, 15, 40, 17, 46, 14, 34, 37, 38, 39, 43, 44, 45, 55, 58, 59, 68, 69, 49, 60, 50, 53, 54, 56, 61, 73, 74);
            EventCenter.getInstance().addObserver(this, 3, "Face", 1);
            EventCenter.getInstance().addObserver(this, 3, "Permission", 1, 2, 3);
            EventCenter.getInstance().addObserver(this, 3, "UGCPermission", 37, 67);
            EventCenter.getInstance().addObserver(this, 3, "PushDataUpdate", 1, 2, 3, 4, 5);
            EventCenter.getInstance().addObserver(this, 3, "Feed", 30, 34);
            return;
        }
        if (i3 == 25) {
            EventCenter.getInstance().addObserver(this, 3, "WriteOperation", 8, 6, 7, 5, 1, 9, 10, 20, 3, 4, 2, 42, 11, 13, 16, 41, 15, 40, 17, 46, 14, 34, 37, 38, 39, 43, 44, 45, 55, 58, 59, 68, 69, 49, 60, 50, 53, 54, 56, 61, 73, 74);
            EventCenter.getInstance().addObserver(this, 3, "Face", 1);
            EventCenter.getInstance().addObserver(this, 3, "Permission", 1, 2, 3);
            EventCenter.getInstance().addObserver(this, 3, "UGCPermission", 37, 67);
            EventCenter.getInstance().addObserver(this, 3, "PushDataUpdate", 1, 2, 3, 4, 5);
            EventCenter.getInstance().addObserver(this, 3, "Feed", 30);
        }
    }

    private void b(List<BusinessFeedData> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        String[] strArr = new String[list.size()];
        for (int i3 = 0; i3 < list.size(); i3++) {
            BusinessFeedData businessFeedData = list.get(i3);
            if (businessFeedData != null) {
                if (!TextUtils.isEmpty(sb5)) {
                    sb5.append(" or ");
                }
                sb5.append("feed_key");
                sb5.append("=?");
                strArr[i3] = businessFeedData.getFeedCommInfo().feedskey;
            }
        }
        if (TextUtils.isEmpty(sb5)) {
            return;
        }
        u(sb5.toString(), strArr, true);
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void close() {
        this.f47223d = 0L;
        this.f47224e = 0L;
        c();
    }

    @Override // com.qzone.proxy.feedcomponent.manager.d
    public void l(BusinessFeedData businessFeedData, String str, boolean z16) {
        com.qzone.proxy.feedcomponent.manager.e eVar;
        com.qzone.proxy.feedcomponent.manager.c cVar;
        if (businessFeedData == null || (eVar = this.f47227i) == null || !eVar.updateFeedData(businessFeedData) || (cVar = this.f47226h) == null) {
            return;
        }
        cVar.onFeedUpdate(businessFeedData, z16);
    }

    private void h(Object[] objArr) {
        if (objArr == null) {
            return;
        }
        if (this.f47225f == 1) {
            f.X(this, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), (String) objArr[3], (String) objArr[4], ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue());
            return;
        }
        if (objArr.length > 8) {
            Object obj = objArr[8];
            if (obj instanceof String) {
                f.P(this, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), (String) objArr[3], ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), (String) obj, objArr.length > 10 ? (Map) objArr[10] : null);
                return;
            }
        }
        if (objArr.length > 7) {
            f.O(this, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), (String) objArr[3], ((Integer) objArr[5]).intValue(), ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue());
        }
    }

    private void m(List<feed_host_info> list) {
        BusinessFeedData businessFeedData;
        String str;
        Object obj;
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f47227i.getCurrentUIDatas());
        List<BusinessFeedData> arrayList2 = new ArrayList<>();
        Iterator<feed_host_info> it = list.iterator();
        while (it.hasNext()) {
            ArrayList<feed_info> arrayList3 = it.next().vec_feedInfos;
            if (arrayList3 != null) {
                for (feed_info feed_infoVar : arrayList3) {
                    Iterator it5 = arrayList.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            businessFeedData = null;
                            break;
                        }
                        businessFeedData = (BusinessFeedData) it5.next();
                        if (feed_infoVar.uOrgFeedUin == businessFeedData.getUser().uin && feed_infoVar.uFeedCTime > businessFeedData.getFeedCommInfo().time / 1000) {
                            break;
                        }
                    }
                    if (businessFeedData != null && !arrayList2.contains(businessFeedData)) {
                        arrayList2.add(businessFeedData);
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("onFeedUnrealCount uin:");
                    sb5.append(feed_infoVar.uOrgFeedUin);
                    sb5.append(" uOrgFeedTime:");
                    sb5.append(feed_infoVar.uOrgFeedTime);
                    sb5.append(" uFeedCTime:");
                    sb5.append(feed_infoVar.uFeedCTime);
                    sb5.append(" ugckey:");
                    if (businessFeedData != null) {
                        str = businessFeedData.getFeedCommInfo().ugckey;
                    } else {
                        str = WiFiDash.NOT_AVALIBLE;
                    }
                    sb5.append(str);
                    sb5.append(" localFeedTime:");
                    if (businessFeedData != null) {
                        obj = Long.valueOf(businessFeedData.getFeedCommInfo().time);
                    } else {
                        obj = "0";
                    }
                    sb5.append(obj);
                    com.qzone.proxy.feedcomponent.b.e("FeedUpdate", sb5.toString());
                }
            }
        }
        if (arrayList2.size() > 0) {
            QZoneFeedUpdateService.c().b(arrayList2);
        }
    }

    private BusinessFeedData f(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return null;
        }
        if (i.H().Z0(System.currentTimeMillis() / 1000) && businessFeedData.isFakeFeedSafe()) {
            CellLocalInfo localInfoV2 = businessFeedData.getLocalInfoV2();
            CellFeedCommInfo feedCommInfoV2 = businessFeedData.getFeedCommInfoV2();
            if (localInfoV2 != null) {
                localInfoV2.setSoftFake();
                localInfoV2.setModifiedFlag();
            }
            if (feedCommInfoV2 != null && businessFeedData.getVideoInfo() == null && !businessFeedData.isMixVideoPic() && !businessFeedData.isDynamicAlbumFeed()) {
                feedCommInfoV2.actiontype = 0;
            }
        }
        B(businessFeedData);
        return businessFeedData;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x004f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:174:0x057c  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x05bb  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x05ce  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0696  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x06ab  */
    /* JADX WARN: Removed duplicated region for block: B:255:? A[RETURN, SYNTHETIC] */
    @Override // com.qzone.common.event.IObserver.background
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onEventBackgroundThread(Event event) {
        s_event_tag s_event_tagVar;
        HashMap hashMap;
        List<MediaWrapper> list;
        s_event_tag s_event_tagVar2;
        Map map;
        Object obj;
        Object obj2;
        d dVar = this;
        Object[] objArr = (Object[]) event.params;
        if ("WriteOperation".equals(event.source.getName())) {
            int i3 = event.what;
            if (i3 == 20) {
                if (dVar.f47225f == 1) {
                    f.G0(this, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), (String) objArr[3], (String) objArr[4], (String) objArr[5], ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), ((Integer) objArr[8]).intValue(), (String) objArr[9]);
                    return;
                } else {
                    f.A0(this, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), (String) objArr[3], (String) objArr[5], ((Integer) objArr[6]).intValue(), ((Integer) objArr[7]).intValue(), ((Integer) objArr[8]).intValue(), (String) objArr[9]);
                    return;
                }
            }
            if (i3 == 34) {
                dVar.i((String) objArr[0]);
                return;
            }
            if (i3 == 65) {
                f.m0(dVar, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue());
                return;
            }
            if (i3 != 83) {
                if (i3 != 85) {
                    if (i3 != 49) {
                        if (i3 != 50) {
                            if (i3 == 77) {
                                f.v0(dVar, (String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Integer) objArr[3]).intValue() != dVar.f47225f);
                                return;
                            }
                            if (i3 != 78) {
                                switch (i3) {
                                    case 1:
                                        if (objArr.length >= 9) {
                                            Object obj3 = objArr[8];
                                            if (obj3 instanceof PublishEventTag) {
                                                PublishEventTag publishEventTag = (PublishEventTag) obj3;
                                                s_event_tag s_event_tagVar3 = new s_event_tag();
                                                s_event_tagVar3.f24992id = publishEventTag.f45886id;
                                                s_event_tagVar3.pic_url = publishEventTag.picUrl;
                                                s_event_tagVar3.show_txt = publishEventTag.title;
                                                s_event_tagVar3.show_desc = publishEventTag.desc;
                                                s_event_tagVar2 = s_event_tagVar3;
                                                if (objArr.length >= 13) {
                                                    Object obj4 = objArr[12];
                                                    if ((obj4 instanceof String) && TextUtils.isEmpty((String) obj4) && dVar.f47225f == 24) {
                                                        return;
                                                    }
                                                }
                                                Map map2 = (objArr.length >= 11 || (obj2 = objArr[10]) == null || !(obj2 instanceof Map)) ? null : (Map) obj2;
                                                Map map3 = (objArr.length >= 14 || (obj = objArr[13]) == null || !(obj instanceof Map)) ? null : (Map) obj;
                                                HashMap hashMap2 = new HashMap();
                                                if (objArr.length > 14) {
                                                    Object obj5 = objArr[14];
                                                    if (obj5 instanceof String) {
                                                        hashMap2.put("recomBottom", (String) obj5);
                                                    }
                                                }
                                                if (objArr.length > 15) {
                                                    Object obj6 = objArr[15];
                                                    if (obj6 instanceof Map) {
                                                        map = (Map) obj6;
                                                        f.s0(this, (String) objArr[0], (String) objArr[1], (List) objArr[2], (VideoInfo) objArr[3], (String) objArr[4], (Integer) objArr[5], (Map) objArr[6], (ArrayList) objArr[7], s_event_tagVar2, d(), (Map) objArr[9], map2, map3, hashMap2, map);
                                                        return;
                                                    }
                                                }
                                                map = null;
                                                f.s0(this, (String) objArr[0], (String) objArr[1], (List) objArr[2], (VideoInfo) objArr[3], (String) objArr[4], (Integer) objArr[5], (Map) objArr[6], (ArrayList) objArr[7], s_event_tagVar2, d(), (Map) objArr[9], map2, map3, hashMap2, map);
                                                return;
                                            }
                                        }
                                        s_event_tagVar2 = null;
                                        if (objArr.length >= 13) {
                                        }
                                        if (objArr.length >= 11) {
                                        }
                                        if (objArr.length >= 14) {
                                        }
                                        HashMap hashMap22 = new HashMap();
                                        if (objArr.length > 14) {
                                        }
                                        if (objArr.length > 15) {
                                        }
                                        map = null;
                                        f.s0(this, (String) objArr[0], (String) objArr[1], (List) objArr[2], (VideoInfo) objArr[3], (String) objArr[4], (Integer) objArr[5], (Map) objArr[6], (ArrayList) objArr[7], s_event_tagVar2, d(), (Map) objArr[9], map2, map3, hashMap22, map);
                                        return;
                                    case 2:
                                    case 11:
                                        break;
                                    case 3:
                                        f.M(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], (PictureItem) objArr[5], objArr.length >= 8 ? (ArrayList) objArr[7] : null, objArr.length >= 9 ? (Map) objArr[8] : null);
                                        return;
                                    case 4:
                                        dVar.h(objArr);
                                        return;
                                    case 5:
                                        if (dVar.f47225f == 1) {
                                            f.F0(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], (User) objArr[5], (String) objArr[6], (Map) objArr[7]);
                                            return;
                                        } else {
                                            f.z0(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[3], (User) objArr[5], (Map) objArr[7]);
                                            return;
                                        }
                                    case 6:
                                        f.n0(this, (String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Integer) objArr[3]).intValue() != dVar.f47225f, ((Integer) objArr[4]).intValue(), (CustomPraiseData) objArr[5], ((Integer) objArr[6]).intValue(), (PolymorphicPraiseEmotionData) objArr[7]);
                                        return;
                                    case 7:
                                        f.o0(this, (String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue(), ((Integer) objArr[5]).intValue());
                                        return;
                                    case 8:
                                        f.e0(dVar, (String) objArr[0], (String) objArr[1]);
                                        return;
                                    case 9:
                                        f.k0(dVar, (String) objArr[0], (String) objArr[1]);
                                        return;
                                    case 10:
                                        if (dVar.f47225f == 24) {
                                            return;
                                        }
                                        f.J0(this, (String) objArr[0], (List) objArr[1], (String) objArr[2], ((Long) objArr[3]).longValue(), (BusinessAlbumInfo) objArr[4], 4097, (Map) objArr[5], objArr.length == 7 ? (Map) objArr[6] : null);
                                        return;
                                    case 12:
                                        f.W(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], (String) objArr[4], null, (Map) objArr[5]);
                                        return;
                                    case 13:
                                        QZoneQueueTask qZoneQueueTask = (QZoneQueueTask) objArr[0];
                                        if (qZoneQueueTask != null) {
                                            if (h.f(qZoneQueueTask)) {
                                                f.i0(dVar, qZoneQueueTask.clientKey);
                                            }
                                            s8.c.a(dVar, qZoneQueueTask);
                                            return;
                                        }
                                        return;
                                    case 14:
                                        f.p0(this, (String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[5]).intValue(), (CustomPraiseData) objArr[6]);
                                        return;
                                    case 15:
                                        f.Y(dVar, (String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                                        return;
                                    case 16:
                                        f.a0(dVar, (String) objArr[0], (String) objArr[1], (String) objArr[2]);
                                        return;
                                    case 17:
                                        f.g0(dVar, (String) objArr[0], (String) objArr[1]);
                                        return;
                                    default:
                                        switch (i3) {
                                            case 36:
                                                f.f0(dVar, (String) objArr[0], (String) objArr[1]);
                                                return;
                                            case 37:
                                                g((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Long) objArr[2]).longValue(), ((Boolean) objArr[3]).booleanValue(), false);
                                                return;
                                            case 38:
                                                if (objArr != null) {
                                                    if (objArr.length == 1 || (objArr.length > 1 && objArr[1] == null)) {
                                                        dVar.x((String) objArr[0]);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                return;
                                            case 39:
                                                f.l0(this, (String) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue(), ((Boolean) objArr[4]).booleanValue());
                                                return;
                                            case 40:
                                                f.Z(dVar, (String) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                                                return;
                                            case 41:
                                                f.b0(dVar, (String) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                                                return;
                                            case 42:
                                                QZoneQueueTask qZoneQueueTask2 = (QZoneQueueTask) objArr[0];
                                                if (qZoneQueueTask2 != null) {
                                                    f.c0(dVar, qZoneQueueTask2.clientKey);
                                                    return;
                                                }
                                                return;
                                            case 43:
                                                f.x0(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], ((Long) objArr[3]).longValue(), ((Integer) objArr[4]).intValue());
                                                return;
                                            case 44:
                                                f.K0(this, (String) objArr[0], (List) objArr[1], (VideoInfo) objArr[2], (String) objArr[3], ((Long) objArr[4]).longValue(), (BusinessAlbumInfo) objArr[5], 4097, (Map) objArr[6], objArr.length == 8 ? (Map) objArr[7] : null);
                                                return;
                                            case 45:
                                                break;
                                            case 46:
                                                f.h0(dVar, (String) objArr[0], (String) objArr[1]);
                                                return;
                                            default:
                                                switch (i3) {
                                                    case 53:
                                                        f.t0(this, (String) objArr[0], (String) objArr[1], (List) objArr[2], (List) objArr[3], (List) objArr[4], (String) objArr[5], d());
                                                        return;
                                                    case 54:
                                                        f.d0(dVar, (String) objArr[0], (String) objArr[1], (String) objArr[2]);
                                                        return;
                                                    case 55:
                                                        synchronized (this) {
                                                            f.y0(dVar, (String) objArr[0], (String) objArr[1], (String) objArr[2]);
                                                        }
                                                        return;
                                                    case 56:
                                                        f.Q0(this, (String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Integer) objArr[3]).intValue() != dVar.f47225f, ((Integer) objArr[4]).intValue(), (CustomPraiseData) objArr[5], -1, null);
                                                        return;
                                                    default:
                                                        switch (i3) {
                                                            case 58:
                                                                f.U(dVar, (String) objArr[0], (String) objArr[1], ((Boolean) objArr[2]).booleanValue(), ((Integer) objArr[3]).intValue());
                                                                return;
                                                            case 59:
                                                                f.V(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], ((Boolean) objArr[3]).booleanValue(), ((Integer) objArr[4]).intValue(), (String) objArr[5], ((Boolean) objArr[6]).booleanValue(), ((Integer) objArr[7]).intValue());
                                                                return;
                                                            case 60:
                                                                break;
                                                            case 61:
                                                                f.u0(this, (String) objArr[0], (String) objArr[1], (List) objArr[2], (HashMap) objArr[3], (ArrayList) objArr[4]);
                                                                return;
                                                            default:
                                                                switch (i3) {
                                                                    case 67:
                                                                        g((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Long) objArr[2]).longValue(), ((Boolean) objArr[3]).booleanValue(), true);
                                                                        return;
                                                                    case 68:
                                                                        f.D0(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], ((Boolean) objArr[3]).booleanValue(), ((Integer) objArr[4]).intValue());
                                                                        return;
                                                                    case 69:
                                                                        f.E0(this, (String) objArr[0], (String) objArr[1], (String) objArr[2], ((Boolean) objArr[3]).booleanValue(), ((Integer) objArr[4]).intValue(), (String) objArr[5], (String) objArr[6], ((Boolean) objArr[7]).booleanValue(), ((Integer) objArr[8]).intValue());
                                                                        return;
                                                                    case 70:
                                                                        f.j0(dVar, (String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Integer) objArr[3]).intValue() != dVar.f47225f);
                                                                        return;
                                                                    default:
                                                                        switch (i3) {
                                                                            case 72:
                                                                                f.H0(dVar, (String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue());
                                                                                return;
                                                                            case 73:
                                                                                f.K(dVar, (String) objArr[0]);
                                                                                return;
                                                                            case 74:
                                                                                f.L(dVar, ((Boolean) objArr[0]).booleanValue(), (String) objArr[1], (String) objArr[2]);
                                                                                return;
                                                                            default:
                                                                                return;
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                            } else {
                                dVar = this;
                                dVar.l(dVar.queryWithMem(f.y((String) objArr[0]), (String) objArr[0], null), null, ((Boolean) objArr[1]).booleanValue());
                            }
                        }
                        t(dVar, (String) objArr[0], (BusinessFeedData) objArr[1]);
                        return;
                    }
                    if (objArr.length >= 10) {
                        Object obj7 = objArr[9];
                        if (obj7 instanceof PublishEventTag) {
                            PublishEventTag publishEventTag2 = (PublishEventTag) obj7;
                            s_event_tag s_event_tagVar4 = new s_event_tag();
                            s_event_tagVar4.f24992id = publishEventTag2.f45886id;
                            s_event_tagVar4.pic_url = publishEventTag2.picUrl;
                            s_event_tagVar4.show_txt = publishEventTag2.title;
                            s_event_tagVar4.show_desc = publishEventTag2.desc;
                            s_event_tagVar = s_event_tagVar4;
                            if (objArr.length >= 11) {
                                Object obj8 = objArr[10];
                                if (obj8 instanceof HashMap) {
                                    hashMap = (HashMap) obj8;
                                    HashMap hashMap3 = hashMap;
                                    list = (List) objArr[1];
                                    if (list != null) {
                                        for (MediaWrapper mediaWrapper : list) {
                                            if (mediaWrapper.getImageInfo() != null) {
                                                ImageInfo imageInfo = mediaWrapper.getImageInfo();
                                                hashMap3.put(imageInfo.mPath, String.valueOf(imageInfo.panoramaType));
                                            }
                                        }
                                        if (list.size() > 0) {
                                            f.L0(this, (String) objArr[0], (List) objArr[1], (String) objArr[2], ((Long) objArr[3]).longValue(), (BusinessAlbumInfo) objArr[4], 4097, (Map) objArr[5], ((Integer) objArr[6]).intValue(), objArr.length >= 8 ? (Map) objArr[7] : null, objArr.length >= 9 ? (Map) objArr[8] : null, s_event_tagVar, hashMap3);
                                            return;
                                        }
                                        return;
                                    }
                                    return;
                                }
                            }
                            hashMap = new HashMap();
                            HashMap hashMap32 = hashMap;
                            list = (List) objArr[1];
                            if (list != null) {
                            }
                        }
                    }
                    s_event_tagVar = null;
                    if (objArr.length >= 11) {
                    }
                    hashMap = new HashMap();
                    HashMap hashMap322 = hashMap;
                    list = (List) objArr[1];
                    if (list != null) {
                    }
                }
                dVar.l((BusinessFeedData) objArr[0], null, true);
                return;
            }
            if (objArr == null || objArr.length <= 1) {
                return;
            }
            f.I0(dVar, (String) objArr[0], ((Integer) objArr[1]).intValue());
            return;
        }
        if ("Permission".equals(event.source.getName())) {
            int i16 = event.what;
            if (i16 == 1) {
                dVar.j(((Long) objArr[0]).longValue());
                return;
            } else {
                if (i16 != 2) {
                    if (i16 != 3) {
                        return;
                    }
                    dVar.k(((Long) objArr[0]).longValue(), false);
                    return;
                }
                dVar.k(((Long) objArr[0]).longValue(), true);
                return;
            }
        }
        if ("Face".equals(event.source.getName()) && event.what == 1) {
            f.q0(dVar, (String) objArr[0], (ArrayList) objArr[1], ((Boolean) objArr[2]).booleanValue());
            return;
        }
        if ("UGCPermission".equals(event.source.getName())) {
            if (event.what != 37) {
                return;
            }
            g((String) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Long) objArr[2]).longValue(), ((Boolean) objArr[3]).booleanValue(), false);
            return;
        }
        if ("PushDataUpdate".equals(event.source.getName())) {
            int i17 = event.what;
            if (i17 == 1) {
                dVar.n((HashMap) objArr[0]);
                return;
            }
            if (i17 == 2) {
                dVar.v((List) objArr[0]);
                return;
            }
            if (i17 == 3) {
                dVar.r((String) objArr[0]);
                return;
            } else {
                if (i17 != 4) {
                    if (i17 != 5) {
                        return;
                    }
                    dVar.q((String) objArr[0]);
                    return;
                }
                dVar.m((List) objArr[0]);
                return;
            }
        }
        if ("Feed".equals(event.source.getName())) {
            int i18 = event.what;
            if (i18 != 31) {
                if (i18 != 34) {
                    return;
                }
                dVar.y((String) objArr[0]);
            } else {
                dVar.s((String) objArr[0], (String) objArr[1], (String) objArr[2]);
            }
        }
    }
}
