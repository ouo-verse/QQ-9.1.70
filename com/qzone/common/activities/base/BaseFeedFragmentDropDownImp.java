package com.qzone.common.activities.base;

import NS_MOBILE_FEEDS.s_droplist_option;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.logic.presenter.BaseFeedPresenter;
import com.qzone.common.logic.report.MiscReportUtils;
import com.qzone.detail.business.service.QZoneDetailService;
import com.qzone.feed.utils.AdsFeedbackReporter;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.module.feedcomponent.actionreport.control.FeedActionRecorder;
import com.qzone.module.feedcomponent.util.QZoneFrdHotVideo00064Reporter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.ClickedPoint;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.ui.FeedElement;
import com.qzone.widget.QzoneBottomSheetMenuMore;
import com.qzone.widget.f;
import com.tencent.luan.ioc.annotation.Inject;
import com.tencent.luan.ioc.annotation.Named;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import n5.d;

/* compiled from: P */
@Named("BaseFeedFragmentDropDownImp")
/* loaded from: classes39.dex */
public class BaseFeedFragmentDropDownImp implements d5.h<BusinessFeedData> {

    /* renamed from: k, reason: collision with root package name */
    private static boolean f44982k = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FEED_DROPDOWN_USE_BOTTOM_SHEET, true);

    /* renamed from: a, reason: collision with root package name */
    private BaseFeedFragmentContainerImp f44983a;

    /* renamed from: b, reason: collision with root package name */
    private d5.c f44984b;

    /* renamed from: c, reason: collision with root package name */
    private d5.j<BusinessFeedData> f44985c;

    /* renamed from: d, reason: collision with root package name */
    private d5.t f44986d;

    /* renamed from: e, reason: collision with root package name */
    private d5.i f44987e;

    /* renamed from: f, reason: collision with root package name */
    private d5.ae f44988f;

    /* renamed from: g, reason: collision with root package name */
    private d5.ac f44989g;

    /* renamed from: h, reason: collision with root package name */
    private BaseFeedFragmentFeedPresenterImp f44990h;

    /* renamed from: i, reason: collision with root package name */
    private com.qzone.widget.f f44991i = null;

    /* renamed from: j, reason: collision with root package name */
    private QZoneFeedOperateLogic f44992j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements f.c {
        b() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            BaseFeedFragmentDropDownImp.this.f44992j.onHideFeeds(false, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements f.c {
        c() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (businessFeedData.isSecretFeed() && businessFeedData.getFeedCommInfo() != null && businessFeedData.getCellSummaryV2() != null) {
                QZoneWriteOperationService.v0().g2(BaseFeedFragmentDropDownImp.this.f44983a.getHandler(), businessFeedData.getFeedCommInfo().ugckey, businessFeedData.getCellSummaryV2().summary);
                return;
            }
            com.tencent.mobileqq.dt.api.b c16 = com.qzone.feed.utils.f.c();
            com.qzone.feed.utils.f.b(c16, businessFeedData);
            com.qzone.feed.utils.f.a(BaseFeedFragmentDropDownImp.this.f44983a.getActivity(), c16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements f.c {
        d() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            BaseFeedFragmentDropDownImp.this.f44992j.onShareToWxMoments();
            if (businessFeedData == null || businessFeedData.getCellLuckyMoney() == null) {
                return;
            }
            ClickReport.q("481", "3", "1", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements f.c {
        e() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            BaseFeedFragmentDropDownImp.this.f44992j.onShareToWeixin();
            if (businessFeedData == null || businessFeedData.getCellLuckyMoney() == null) {
                return;
            }
            ClickReport.q("481", "3", "2", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements f.c {
        f() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            BaseFeedFragmentDropDownImp.this.f44992j.onShareToQQ();
            if (businessFeedData == null || businessFeedData.getCellLuckyMoney() == null) {
                return;
            }
            ClickReport.q("481", "3", "3", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g implements f.c {
        g() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (!businessFeedData.isFriendLikeVerticalSlideContainer() && !businessFeedData.isFrdLikeVideoContainer()) {
                BaseFeedFragmentDropDownImp.this.f44985c.b(new com.qzone.common.activities.base.k(businessFeedData), BaseFeedFragmentDropDownImp.this.f44990h.f());
                return;
            }
            ArrayList<BusinessFeedData> recBusinessFeedDatas = businessFeedData.getRecBusinessFeedDatas();
            if (recBusinessFeedDatas != null && recBusinessFeedDatas.size() != 0) {
                boolean x16 = BaseFeedFragmentDropDownImp.this.x(businessFeedData);
                if (QZLog.isColorLevel()) {
                    QZLog.d("BaseFeedFragmentPopupWi", 2, "[setCollectClickListener][onClick] isAllFavorited=" + x16);
                }
                for (BusinessFeedData businessFeedData2 : recBusinessFeedDatas) {
                    if (x16) {
                        BaseFeedFragmentDropDownImp.this.f44985c.d(new com.qzone.common.activities.base.k(businessFeedData), BaseFeedFragmentDropDownImp.this.f44990h.f());
                    } else {
                        BaseFeedFragmentDropDownImp.this.f44985c.a(new com.qzone.common.activities.base.k(businessFeedData2), BaseFeedFragmentDropDownImp.this.f44990h.f());
                    }
                }
                return;
            }
            QZLog.w("BaseFeedFragmentPopupWi", "[setCollectClickListener][onClick] recFeeds is empty");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class h implements f.c {
        h() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            BaseFeedFragmentDropDownImp baseFeedFragmentDropDownImp = BaseFeedFragmentDropDownImp.this;
            baseFeedFragmentDropDownImp.t(baseFeedFragmentDropDownImp.f44983a.getActivity(), businessFeedData.getUser().uin, 3011, QZoneContant.QZ_REQUEST_EVENT_TAG_FEED_ADD_FRIEND);
            x5.a.a(businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class i implements DialogInterface.OnDismissListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            BaseFeedFragmentDropDownImp.this.f44991i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class j implements QzoneBottomSheetMenuMore.j {
        j() {
        }

        @Override // com.qzone.widget.QzoneBottomSheetMenuMore.j
        public boolean a(CellFeedCommInfo cellFeedCommInfo) {
            return BaseFeedFragmentDropDownImp.this.y(cellFeedCommInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class k implements PopupWindow.OnDismissListener {
        k() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            BaseFeedFragmentDropDownImp.this.f44991i = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class n implements f.c {
        n() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            BaseFeedFragmentDropDownImp.this.f44992j.onFeedEdit();
            com.qzone.feed.business.service.a f16 = BaseFeedFragmentDropDownImp.this.f44983a.f();
            if (f16 != null && f16.f47216d == 0) {
                FeedActionRecorder.getInstance().addAction(businessFeedData, 0, System.currentTimeMillis(), 52, 1, 0, false);
            }
            if (businessFeedData == null || businessFeedData.getCellLuckyMoney() == null) {
                return;
            }
            ClickReport.q("481", "3", "4", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class o implements f.c {
        o() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            BusinessFeedData businessFeedData2;
            BaseFeedFragmentDropDownImp.this.f44990h.f().onClick(null, FeedElement.FEEDBACK, i3, null);
            if (businessFeedData != null && businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds() && businessFeedData.isSubFeed) {
                QZoneWriteOperationService.v0().J(businessFeedData.containerIndex, businessFeedData.parentFeedData, 2);
                BaseFeedFragmentDropDownImp.this.f44987e.b("WriteOperation", 38, businessFeedData.parentFeedData.getFeedCommInfo().feedskey);
            }
            if ((businessFeedData == null || (businessFeedData2 = businessFeedData.parentFeedData) == null || (!businessFeedData2.isFriendLikeContainer() && !businessFeedData.parentFeedData.isFrdLikeMiniAppContainer()) || businessFeedData.parentFeedData.getFeedCommInfo() == null) ? false : true) {
                BaseFeedFragmentDropDownImp.this.f44987e.b("WriteOperation", 38, businessFeedData.parentFeedData.getFeedCommInfo().feedskey);
            }
            if (businessFeedData != null && businessFeedData.isFriendAnniversaryFeed()) {
                HashMap hashMap = new HashMap();
                if (businessFeedData.getCellGuiding() != null) {
                    hashMap.put("guiding_type", String.valueOf(businessFeedData.getCellGuiding().guiding_type));
                }
                QZoneWriteOperationService.v0().f2(1, 3L, 1, hashMap);
            }
            if (businessFeedData != null && !businessFeedData.isCardFollowMoreRecommendContainerFeed()) {
                BaseFeedFragmentDropDownImp.this.f44987e.b("WriteOperation", 38, businessFeedData.getFeedCommInfo().feedskey);
            }
            BaseFeedFragmentDropDownImp.this.z(businessFeedData);
            if (businessFeedData == null || !businessFeedData.isFriendVideoFeed()) {
                return;
            }
            if (businessFeedData.getFeedCommInfo().feedsAttr2 == 4194304) {
                com.qzone.adapter.feedcomponent.i.H().f2(693, 5, 0, null);
            } else {
                com.qzone.adapter.feedcomponent.i.H().f2(691, 5, 0, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class t implements f.c {
        t() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (!BaseFeedFragmentDropDownImp.this.f44983a.e()) {
                c6.a.j(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"), 3);
            } else if (BaseFeedFragmentDropDownImp.this.f44990h.f() != null) {
                BaseFeedFragmentDropDownImp.this.f44990h.f().E0(businessFeedData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class u implements f.c {
        u() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds() && businessFeedData.isSubFeed) {
                QZoneWriteOperationService.v0().J(businessFeedData.containerIndex, businessFeedData.parentFeedData, 4);
            }
            BaseFeedFragmentDropDownImp.this.f44987e.b("WriteOperation", 38, businessFeedData.parentFeedData.getFeedCommInfo().feedskey);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class v implements f.c {
        v() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (!BaseFeedFragmentDropDownImp.this.f44983a.e()) {
                c6.a.j(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"), 3);
                return;
            }
            long c16 = BaseFeedFragmentDropDownImp.this.f44984b == null ? 0L : BaseFeedFragmentDropDownImp.this.f44984b.c();
            long j3 = businessFeedData.owner_uin;
            if (j3 == 0) {
                j3 = businessFeedData.getUser().uin;
            }
            if (c16 == j3) {
                LpReportInfo_pf00064.report(129, 1);
            } else {
                LpReportInfo_pf00064.report(129, 2);
            }
            d5.t tVar = BaseFeedFragmentDropDownImp.this.f44986d;
            long j16 = businessFeedData.owner_uin;
            if (j16 == 0) {
                j16 = businessFeedData.getUser().uin;
            }
            tVar.k(j16, "default");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class w implements f.c {

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements d.g {
            a() {
            }

            @Override // n5.d.g
            public void a(BusinessAlbumInfo businessAlbumInfo) {
                Intent x16 = ak.x(BaseFeedFragmentDropDownImp.this.f44983a.getActivity(), BaseFeedFragmentDropDownImp.this.f44983a.getActivity().getResources().getString(R.string.gng), 0);
                if (businessAlbumInfo != null) {
                    x16.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_DEFAULT_ALBUM_ID, businessAlbumInfo.mAlbumId);
                }
                BaseFeedFragmentDropDownImp.this.f44983a.startActivityForResult(x16, QZoneContant.QZ_SELECT_ALBUM);
            }
        }

        w() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            BaseFeedFragmentDropDownImp.this.f44992j.onForword(new a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class x implements f.c {
        x() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (!BaseFeedFragmentDropDownImp.this.f44983a.e()) {
                c6.a.j(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"), 3);
            } else {
                BaseFeedFragmentDropDownImp.this.f44990h.f().G0(businessFeedData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class y implements f.c {
        y() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (BaseFeedFragmentDropDownImp.this.f44983a != null && !BaseFeedFragmentDropDownImp.this.f44983a.e()) {
                c6.a.j(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"), 3);
                return;
            }
            BaseFeedPresenter f16 = BaseFeedFragmentDropDownImp.this.f44990h == null ? null : BaseFeedFragmentDropDownImp.this.f44990h.f();
            if (f16 == null) {
                QLog.e("BaseFeedFragmentPopupWi", 1, "[onClick] presenter should not be null.");
            } else {
                f16.r0(businessFeedData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class z implements f.c {
        z() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            BaseFeedFragmentDropDownImp.this.f44992j.onHideFeeds(true, -1);
        }
    }

    @Inject
    public BaseFeedFragmentDropDownImp() {
    }

    private void B() {
        this.f44991i.z(1, new h());
    }

    private void C() {
        this.f44991i.z(24, new v());
    }

    private void D() {
        this.f44991i.z(17, new q());
    }

    private void E() {
        this.f44991i.z(8, new g());
    }

    private void F() {
        this.f44991i.w(1, new f.b() { // from class: com.qzone.common.activities.base.BaseFeedFragmentDropDownImp.27
            @Override // com.qzone.widget.f.b
            public void a(int i3, BusinessFeedData businessFeedData, s_droplist_option s_droplist_optionVar, int i16, boolean z16) {
                s_droplist_option s_droplist_optionVar2;
                final BusinessFeedData businessFeedData2;
                int i17;
                if (s_droplist_optionVar == null) {
                    return;
                }
                if (s_droplist_optionVar.reporttype != 0) {
                    if (businessFeedData.getRecommAction() != null && businessFeedData.getRecommAction().reportUrl != null) {
                        AdsFeedbackReporter.report(businessFeedData.getRecommAction().reportUrl + s_droplist_optionVar.reporttype);
                    }
                    s_droplist_optionVar2 = s_droplist_optionVar;
                } else {
                    int i18 = i16 < 0 ? 32 : i16;
                    Map<Integer, String> map = businessFeedData.getOperationInfo().cookie;
                    map.put(11, s_droplist_optionVar.reportattach);
                    QZoneWriteOperationService.v0().L(map, i18, 0, i3, s_droplist_optionVar.actiontype, (s_droplist_optionVar.actiontype == 39 && z16) ? 1 : 0, true, false, null, null, 0L, false, false, null, false, businessFeedData);
                    s_droplist_optionVar2 = s_droplist_optionVar;
                }
                if (s_droplist_optionVar2.actiontype != 2 || TextUtils.isEmpty(s_droplist_optionVar2.jumpurl)) {
                    businessFeedData2 = businessFeedData;
                } else {
                    HashMap hashMap = new HashMap();
                    businessFeedData2 = businessFeedData;
                    hashMap.put("businessFeedData", businessFeedData2);
                    BaseFeedFragmentDropDownImp.this.f44989g.a(s_droplist_optionVar2.jumpurl, null, hashMap);
                }
                if (s_droplist_optionVar2.actiontype == 40) {
                    BaseFeedFragmentDropDownImp.this.f44988f.a(BaseFeedFragmentDropDownImp.this.f44983a.getResources().getString(R.string.f170930b53));
                    String str = businessFeedData.getFeedCommInfo().feedskey;
                    if (businessFeedData.isGDTAdvFeed() && businessFeedData2.isSubFeed) {
                        str = businessFeedData2.parentFeedData.getFeedCommInfo().feedskey;
                    }
                    BaseFeedFragmentDropDownImp.this.f44990h.f().K0(businessFeedData2);
                    i17 = 1;
                    BaseFeedFragmentDropDownImp.this.f44987e.b("WriteOperation", 38, str);
                } else {
                    i17 = 1;
                }
                if (s_droplist_optionVar2.actiontype == 41) {
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(new Runnable() { // from class: com.qzone.common.activities.base.BaseFeedFragmentDropDownImp.27.1
                        @Override // java.lang.Runnable
                        public void run() {
                            BaseFeedFragmentDropDownImp.this.f44987e.b("WriteOperation", 38, businessFeedData2.getFeedCommInfo().feedskey);
                        }
                    }, 2000L);
                }
                if (businessFeedData.isGDTAdvFeed() && businessFeedData2.cellNegativeFeedback != null && s_droplist_optionVar2.actiontype == 56) {
                    String str2 = businessFeedData.getFeedCommInfo().feedskey;
                    if (businessFeedData.isGDTAdvFeed() && businessFeedData2.isSubFeed) {
                        str2 = businessFeedData2.parentFeedData.getFeedCommInfo().feedskey;
                    }
                    d5.i iVar = BaseFeedFragmentDropDownImp.this.f44987e;
                    Object[] objArr = new Object[i17];
                    objArr[0] = str2;
                    iVar.b("WriteOperation", 38, objArr);
                    BaseFeedFragmentDropDownImp.this.f44990h.f().K0(businessFeedData2);
                }
            }
        });
    }

    private void G() {
        this.f44991i.z(5, new y());
    }

    private void H() {
        this.f44991i.z(18, new r());
    }

    private void I() {
        this.f44991i.z(4, new n());
    }

    private void J() {
        this.f44991i.z(3, new b());
    }

    private void K() {
        this.f44991i.z(6, new x());
    }

    private void L() {
        this.f44991i.H(1, new p());
    }

    private void M() {
        this.f44991i.z(2, new z());
    }

    private void N() {
        this.f44991i.z(16, new o());
    }

    private void O() {
        this.f44991i.z(20, new u());
    }

    private void P() {
        this.f44991i.z(7, new c());
    }

    private void Q() {
        this.f44991i.z(10, new w());
    }

    private void R() {
        this.f44991i.z(25, new s());
    }

    private void S() {
        this.f44991i.z(23, new t());
    }

    private void T() {
        this.f44991i.z(12, new a());
    }

    private void U() {
        this.f44991i.z(15, new d());
    }

    private void V() {
        this.f44991i.z(9, new f());
    }

    private void W() {
        this.f44991i.z(14, new e());
    }

    private void X() {
        this.f44991i.z(11, new l());
    }

    private void Y() {
        this.f44991i.z(13, new m());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Activity activity, long j3, int i3, int i16) {
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(activity, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(this.f44983a.getActivity(), 1, String.valueOf(j3), "", i3, 21, null, null, null, null, null), i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String u(CellFeedCommInfo cellFeedCommInfo) {
        return cellFeedCommInfo.feedsType == 0 ? cellFeedCommInfo.feedskey : cellFeedCommInfo.feedsid;
    }

    private void w(BusinessFeedData businessFeedData) {
        if (this.f44991i == null) {
            if (f44982k) {
                QzoneBottomSheetMenuMore qzoneBottomSheetMenuMore = new QzoneBottomSheetMenuMore(this.f44983a.getActivity(), businessFeedData);
                this.f44991i = qzoneBottomSheetMenuMore;
                qzoneBottomSheetMenuMore.setOnDismissListener(new i());
                ((QzoneBottomSheetMenuMore) this.f44991i).U2(new j());
                return;
            }
            com.qzone.widget.q qVar = new com.qzone.widget.q(this.f44983a.getActivity());
            this.f44991i = qVar;
            qVar.setOnDismissListener(new k());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean x(BusinessFeedData businessFeedData) {
        d5.j<BusinessFeedData> jVar;
        d5.j<BusinessFeedData> jVar2;
        if (businessFeedData == null) {
            QZLog.w("BaseFeedFragmentPopupWi", "[isFavorited] mFeedData is null");
            return false;
        }
        if (!businessFeedData.isFriendLikeVerticalSlideContainer() && !businessFeedData.isFrdLikeVideoContainer()) {
            return (businessFeedData.getFeedCommInfo() == null || (jVar2 = this.f44985c) == null || !jVar2.c(businessFeedData.getFeedCommInfo().ugckey)) ? false : true;
        }
        ArrayList<BusinessFeedData> recBusinessFeedDatas = businessFeedData.getRecBusinessFeedDatas();
        if (recBusinessFeedDatas == null || recBusinessFeedDatas.size() == 0) {
            return false;
        }
        for (BusinessFeedData businessFeedData2 : recBusinessFeedDatas) {
            String str = "null";
            if (!QZoneFeedUtil.f(businessFeedData2)) {
                if (QZLog.isColorLevel()) {
                    if (("[isCollected] " + businessFeedData2.getFeedCommInfo()) != null) {
                        str = businessFeedData2.getFeedCommInfo().ugckey + " can not collect";
                    }
                    QZLog.d("BaseFeedFragmentPopupWi", 2, str);
                }
            } else if (businessFeedData2.getFeedCommInfo() == null || (jVar = this.f44985c) == null || !jVar.c(businessFeedData2.getFeedCommInfo().ugckey)) {
                if (!QZLog.isColorLevel()) {
                    return false;
                }
                if (("[isFavorited] feed:" + businessFeedData2.getFeedCommInfo()) != null) {
                    str = businessFeedData2.getFeedCommInfo().ugckey + " not favorite";
                }
                QZLog.d("BaseFeedFragmentPopupWi", 2, str);
                return false;
            }
        }
        return true;
    }

    @Override // d5.h
    public void a(View view, d5.k<BusinessFeedData> kVar, int i3, Object obj) {
        BusinessFeedData b16 = kVar.b();
        if (b16 == null || !(obj instanceof ClickedPoint) || this.f44983a.getActivity() == null) {
            return;
        }
        w(b16);
        if (this.f44992j == null) {
            this.f44992j = v();
        }
        this.f44992j.setFeedData(b16);
        B();
        E();
        V();
        W();
        U();
        P();
        J();
        M();
        G();
        K();
        X();
        Y();
        I();
        Q();
        C();
        N();
        L();
        O();
        D();
        H();
        F();
        S();
        R();
        T();
        if (this.f44991i.j()) {
            return;
        }
        com.qzone.widget.f fVar = this.f44991i;
        if (fVar instanceof com.qzone.widget.q) {
            com.qzone.widget.q qVar = (com.qzone.widget.q) fVar;
            ClickedPoint clickedPoint = (ClickedPoint) obj;
            qVar.W1(i3, b16);
            qVar.U1(clickedPoint.getWidth());
            qVar.T1(clickedPoint.getHeight());
            com.qzone.widget.r.a(this.f44983a.getActivity(), this.f44983a.g(), view, i3, b16, clickedPoint, qVar);
            return;
        }
        if (fVar instanceof QzoneBottomSheetMenuMore) {
            ((QzoneBottomSheetMenuMore) fVar).show();
        }
    }

    @Override // d5.h
    public void b(d5.k<BusinessFeedData> kVar) {
        v();
        this.f44992j.setFeedData(kVar.b());
        this.f44992j.onHideFeeds(false, -1);
    }

    @Override // d5.h
    public void c(d5.k<BusinessFeedData> kVar, int i3) {
        v();
        this.f44992j.setFeedData(kVar.b());
        this.f44992j.hideNewUserRecommendFeeds(i3);
    }

    @Override // d5.h
    public void d(d5.k<BusinessFeedData> kVar) {
        BusinessFeedData b16 = kVar.b();
        com.qzone.widget.f fVar = this.f44991i;
        if (fVar != null && fVar.j() && this.f44991i.o() != null && this.f44991i.o() == b16) {
            this.f44991i.p();
        }
        QZoneFeedOperateLogic qZoneFeedOperateLogic = this.f44992j;
        if (qZoneFeedOperateLogic != null) {
            qZoneFeedOperateLogic.dismissHideFeedDialog(b16);
        }
    }

    @Override // d5.h
    public void handleGetShareUrl(boolean z16, Bundle bundle) {
        v().handleGetShareUrl(z16, bundle);
    }

    @Inject
    public void setBaseFeedPresenterImp(BaseFeedFragmentFeedPresenterImp baseFeedFragmentFeedPresenterImp) {
        this.f44990h = baseFeedFragmentFeedPresenterImp;
    }

    @Inject
    @Named("BaseFragmentConfigImp")
    public void setConfigInf(d5.c cVar) {
        this.f44984b = cVar;
    }

    @Inject
    public void setContainer(d5.u uVar) {
        this.f44983a = (BaseFeedFragmentContainerImp) uVar;
    }

    @Inject
    public void setEventInf(d5.i iVar) {
        this.f44987e = iVar;
    }

    @Inject
    @Named("BaseFeedFragmentFavorImp")
    public void setFavorInf(d5.j<BusinessFeedData> jVar) {
        this.f44985c = jVar;
    }

    @Inject
    @Named("BaseFeedFragmentJumpImp")
    public void setJumpInf(d5.t tVar) {
        this.f44986d = tVar;
    }

    @Inject
    @Named("BaseFeedFragmentSchemeImp")
    public void setSchemeInf(d5.ac acVar) {
        this.f44989g = acVar;
    }

    @Inject
    @Named("BaseFragmentToastImp")
    public void setToastInf(d5.ae aeVar) {
        this.f44988f = aeVar;
    }

    final QZoneFeedOperateLogic v() {
        if (this.f44992j == null) {
            this.f44992j = new QZoneFeedOperateLogic(this.f44983a.getHandler(), this.f44983a.getActivity(), "feed");
        }
        return this.f44992j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class l implements f.c {
        l() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
                if (businessFeedData.getFeedCommInfo().isRealTimeTTTReport()) {
                    com.qzone.adapter.feedcomponent.i.H().y(12, businessFeedData.getFeedCommInfo().isFollowed ? 50 : 49, 1, System.currentTimeMillis(), null, businessFeedData, i3, 0);
                } else {
                    com.qzone.adapter.feedcomponent.i.H().z(12, businessFeedData.getFeedCommInfo().isFollowed ? 50 : 49, 1, System.currentTimeMillis(), businessFeedData, i3, 0);
                }
            }
            BaseFeedFragmentDropDownImp.this.f44990h.f().q(null, businessFeedData, i3, false, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class m implements f.c {
        m() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
                if (businessFeedData.getFeedCommInfo().isRealTimeTTTReport()) {
                    com.qzone.adapter.feedcomponent.i.H().y(12, businessFeedData.getFeedCommInfo().isFollowed ? 50 : 49, 1, System.currentTimeMillis(), null, businessFeedData, i3, 0);
                } else {
                    com.qzone.adapter.feedcomponent.i.H().z(12, businessFeedData.getFeedCommInfo().isFollowed ? 50 : 49, 1, System.currentTimeMillis(), businessFeedData, i3, 0);
                }
            }
            BaseFeedFragmentDropDownImp.this.f44990h.f().q(null, businessFeedData, i3, false, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class s implements f.c {
        s() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            User user;
            if (businessFeedData == null || (user = businessFeedData.getUser()) == null) {
                return;
            }
            MiniChatActivity.S2(BaseFeedFragmentDropDownImp.this.f44983a.getActivity(), 0, String.valueOf(user.uin), user.nickName, false, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements f.c {

        /* compiled from: P */
        /* renamed from: com.qzone.common.activities.base.BaseFeedFragmentDropDownImp$a$a, reason: collision with other inner class name */
        /* loaded from: classes39.dex */
        class DialogInterfaceOnClickListenerC0364a implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0364a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                BaseFeedFragmentDropDownImp.this.f44983a.i("jhan_feedzhiding", BaseFeedFragmentDropDownImp.this.f44983a.getResources().getString(R.string.gia));
            }
        }

        a() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (businessFeedData == null) {
                return;
            }
            if (!NetworkState.isNetSupport()) {
                c6.a.i(BaseFeedFragmentDropDownImp.this.f44983a.getResources().getString(R.string.ci5));
            }
            if (BaseFeedFragmentDropDownImp.this.y(businessFeedData.getFeedCommInfo()) || (BaseFeedFragmentDropDownImp.this.f44984b != null && BaseFeedFragmentDropDownImp.this.f44984b.isVip())) {
                QZoneDetailService.U().D0(BaseFeedFragmentDropDownImp.this.u(businessFeedData.getFeedCommInfo()), BaseFeedFragmentDropDownImp.this.y(businessFeedData.getFeedCommInfo()), businessFeedData.getFeedCommInfo().feedsType, BaseFeedFragmentDropDownImp.this.f44983a.getHandler());
            } else {
                new com.qzone.component.e().f(BaseFeedFragmentDropDownImp.this.f44983a.getActivity(), 230, null, BaseFeedFragmentDropDownImp.this.f44983a.getResources().getString(R.string.gg5), BaseFeedFragmentDropDownImp.this.f44983a.getResources().getString(R.string.gi_), BaseFeedFragmentDropDownImp.this.f44983a.getResources().getString(R.string.cancel), new DialogInterfaceOnClickListenerC0364a(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class q implements f.c {
        q() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (businessFeedData == null) {
                return;
            }
            if (businessFeedData.getCellGuiding().guiding_type != 4) {
                HashMap hashMap = new HashMap();
                if (businessFeedData.getCellGuiding() != null) {
                    hashMap.put("guiding_type", String.valueOf(businessFeedData.getCellGuiding().guiding_type));
                }
                QZoneWriteOperationService.v0().f2(1, 1L, 1, hashMap);
            }
            if (businessFeedData.isFunctionGuideFeed()) {
                MiscReportUtils.k(businessFeedData.getCellGuiding(), "report_drop_down_menu_close_feeds");
            }
            BaseFeedFragmentDropDownImp.this.f44987e.b("WriteOperation", 38, businessFeedData.getFeedCommInfo().feedskey);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class r implements f.c {
        r() {
        }

        @Override // com.qzone.widget.f.c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (businessFeedData == null) {
                return;
            }
            if (businessFeedData.getCellGuiding().guiding_type != 4) {
                HashMap hashMap = new HashMap();
                if (businessFeedData.getCellGuiding() != null) {
                    hashMap.put("guiding_type", String.valueOf(businessFeedData.getCellGuiding().guiding_type));
                }
                QZoneWriteOperationService.v0().f2(1, 2L, 1, hashMap);
            }
            if (businessFeedData.isFunctionGuideFeed()) {
                MiscReportUtils.k(businessFeedData.getCellGuiding(), "report_drop_down_menu_never_show");
            }
            BaseFeedFragmentDropDownImp.this.f44987e.b("WriteOperation", 38, businessFeedData.getFeedCommInfo().feedskey);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean y(CellFeedCommInfo cellFeedCommInfo) {
        if (cellFeedCommInfo == null) {
            return false;
        }
        return cellFeedCommInfo.isTopFeed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(BusinessFeedData businessFeedData, String str) {
        if (businessFeedData == null || str == null) {
            return;
        }
        if (com.qzone.proxy.feedcomponent.model.c.b(businessFeedData) || com.qzone.proxy.feedcomponent.model.c.c(businessFeedData)) {
            QZoneFrdHotVideo00064Reporter.reportNegativeFeedbackClick(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class p implements f.d {
        p() {
        }

        @Override // com.qzone.widget.f.d
        public void a(int i3, BusinessFeedData businessFeedData, s_droplist_option s_droplist_optionVar) {
            if (s_droplist_optionVar == null) {
                return;
            }
            int i16 = s_droplist_optionVar.reporttypeV2;
            int i17 = s_droplist_optionVar.reporttype;
            fp.a aVar = new fp.a(s_droplist_optionVar);
            if (i16 == 5) {
                QZoneWriteOperationService.v0().O(BaseFeedFragmentDropDownImp.this.f44983a.getHandler(), businessFeedData.getUser().uin, s_droplist_optionVar.reporttype, businessFeedData.getOperationInfo().droplist_cookie, aVar);
            }
            if (i16 == 4 || i16 == 5) {
                FeedActionRecorder.getInstance().addAction(businessFeedData, i3, System.currentTimeMillis(), 12, i17, 1, 0, false, null, false, 0L);
            }
            BaseFeedFragmentDropDownImp.this.A(businessFeedData, s_droplist_optionVar.optext);
        }
    }

    protected void z(BusinessFeedData businessFeedData) {
    }
}
