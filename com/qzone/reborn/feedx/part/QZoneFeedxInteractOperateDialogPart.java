package com.qzone.reborn.feedx.part;

import NS_MOBILE_FEEDS.s_droplist_option;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.qzone.album.data.AlbumCacheDataManager;
import com.qzone.business.favorite.service.QzoneFavoriteService;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.QZoneFeedOperateLogic;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.common.logic.report.MiscReportUtils;
import com.qzone.commoncode.module.gdt.GdtFeedUtilForQZone;
import com.qzone.detail.business.service.QZoneDetailService;
import com.qzone.feed.business.service.QZoneFeedService;
import com.qzone.feed.utils.AdsFeedbackReporter;
import com.qzone.feed.utils.QZoneFeedUtil;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.module.feedcomponent.actionreport.control.FeedActionRecorder;
import com.qzone.personalize.ArchiveMemorySettingGuide;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.publish.business.publishqueue.QZonePublishQueue;
import com.qzone.publish.business.task.IQueueTask;
import com.qzone.reborn.feedx.request.QZoneFeedxGetUgcRightRequest;
import com.qzone.reborn.share.QZoneFeedXBottomSheetMenuMore;
import com.qzone.reborn.share.c;
import com.qzone.util.ToastUtil;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.tianshu.api.IQbossReportManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.state.report.SquareReportConst;
import common.config.service.QzoneConfig;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.api.QZoneContant;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil;
import fh.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import n5.d;
import qzone.QZoneRightAccess$GetUgcRightRsp;

/* loaded from: classes37.dex */
public class QZoneFeedxInteractOperateDialogPart extends com.qzone.reborn.feedx.part.g implements gf.h, d5.n<BusinessFeedData>, ArchiveMemorySettingGuide.c, IObserver.main {
    private String C;
    private BusinessFeedData D;
    private int E;
    private long F;
    private int G;
    private String H;
    private int I;

    /* renamed from: e, reason: collision with root package name */
    private QZoneFeedOperateLogic f54906e;

    /* renamed from: h, reason: collision with root package name */
    private boolean f54908h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<String> f54909i;

    /* renamed from: m, reason: collision with root package name */
    private int f54910m;

    /* renamed from: d, reason: collision with root package name */
    private com.qzone.reborn.share.c f54905d = null;

    /* renamed from: f, reason: collision with root package name */
    private boolean f54907f = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class ab implements c.InterfaceC0499c {
        ab() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            String d16 = com.qzone.reborn.feedx.util.n.d(businessFeedData);
            QZLog.d("QZoneFeedxInteractOperateDialogPart", 1, "[intimateSpaceClick] intimateSpaceUrl = " + d16);
            if (!TextUtils.isEmpty(d16)) {
                yo.d.d(d16, QZoneFeedxInteractOperateDialogPart.this.getContext(), null);
            }
            fo.c.c("ev_qz_feed_settings_page_clck", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class ac implements c.InterfaceC0499c {
        ac() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (!NetworkUtil.isNetSupport(QZoneFeedxInteractOperateDialogPart.this.getActivity())) {
                c6.a.j(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"), 3);
                QZoneFeedxInteractOperateDialogPart.this.W9(10, businessFeedData);
            } else {
                QZoneFeedxInteractOperateDialogPart.this.ta(businessFeedData);
                QZoneFeedxInteractOperateDialogPart.this.W9(10, businessFeedData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class ad implements c.InterfaceC0499c {
        ad() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds() && businessFeedData.isSubFeed) {
                QZoneWriteOperationService.v0().J(businessFeedData.containerIndex, businessFeedData.parentFeedData, 4);
            }
            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData.parentFeedData.getFeedCommInfo().feedskey);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class ae implements c.InterfaceC0499c {
        ae() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (!NetworkUtil.isNetSupport(QZoneFeedxInteractOperateDialogPart.this.getActivity())) {
                c6.a.j(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"), 3);
                QZoneFeedxInteractOperateDialogPart.this.W9(7, businessFeedData);
                return;
            }
            long uin = LoginData.getInstance().getUin();
            long j3 = businessFeedData.owner_uin;
            if (j3 == 0) {
                j3 = businessFeedData.getUser().uin;
            }
            if (uin == j3) {
                LpReportInfo_pf00064.report(129, 1);
            } else {
                LpReportInfo_pf00064.report(129, 2);
            }
            Activity activity = QZoneFeedxInteractOperateDialogPart.this.getActivity();
            long j16 = businessFeedData.owner_uin;
            if (j16 == 0) {
                j16 = businessFeedData.getUser().uin;
            }
            vo.c.E(activity, j16, "default");
            QZoneFeedxInteractOperateDialogPart.this.W9(7, businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class af implements c.InterfaceC0499c {

        /* loaded from: classes37.dex */
        class a implements d.g {
            a() {
            }

            @Override // n5.d.g
            public void a(BusinessAlbumInfo businessAlbumInfo) {
                Intent x16 = com.qzone.common.activities.base.ak.x(QZoneFeedxInteractOperateDialogPart.this.getActivity(), HardCodeUtil.qqStr(R.string.gng), 0);
                if (businessAlbumInfo != null) {
                    x16.putExtra(QZoneHelper.QZonePersonalAlbumContants.KEY_DEFAULT_ALBUM_ID, businessAlbumInfo.mAlbumId);
                }
                QZoneFeedxInteractOperateDialogPart.this.B9(x16, QZoneContant.QZ_SELECT_ALBUM);
            }
        }

        af() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            QZoneFeedxInteractOperateDialogPart.this.f54906e.onForword(new a());
            QZoneFeedxInteractOperateDialogPart.this.W9(3, businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class ag implements c.InterfaceC0499c {
        ag() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (NetworkUtil.isNetSupport(QZoneFeedxInteractOperateDialogPart.this.getActivity())) {
                QZoneFeedxInteractOperateDialogPart.this.ua(businessFeedData);
            } else {
                c6.a.j(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"), 3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class ah implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f54925d;

        ah(BusinessFeedData businessFeedData) {
            this.f54925d = businessFeedData;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (!NetworkState.isNetSupport()) {
                c6.a.h(R.string.ghi);
                return;
            }
            if (this.f54925d.getFeedCommInfo() != null) {
                QZoneWriteOperationService.v0().k2(QZoneFeedxInteractOperateDialogPart.this.getMainHandler(), this.f54925d.getFeedCommInfo().ugckey, this.f54925d.getFeedCommInfo().clientkey);
            }
            LpReportInfo_pf00064.allReport(611, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b implements c.InterfaceC0499c {
        b() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            QZoneFeedxInteractOperateDialogPart.this.qa(businessFeedData);
            QZoneFeedxInteractOperateDialogPart.this.W9(11, businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f54928d;

        c(BusinessFeedData businessFeedData) {
            this.f54928d = businessFeedData;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (NetworkState.isNetSupport()) {
                QZoneFeedxInteractOperateDialogPart.this.X9(this.f54928d, false);
            } else {
                c6.a.h(R.string.ghi);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            QZoneFeedxInteractOperateDialogPart.this.f54908h = i3 == 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ BusinessFeedData f54931d;

        e(BusinessFeedData businessFeedData) {
            this.f54931d = businessFeedData;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (!NetworkState.isNetSupport()) {
                c6.a.h(R.string.ghi);
                return;
            }
            QZoneFeedxInteractOperateDialogPart qZoneFeedxInteractOperateDialogPart = QZoneFeedxInteractOperateDialogPart.this;
            qZoneFeedxInteractOperateDialogPart.X9(this.f54931d, qZoneFeedxInteractOperateDialogPart.f54908h);
            u5.b.p0("key_last_checked_state_del_media_file", QZoneFeedxInteractOperateDialogPart.this.f54908h, LoginData.getInstance().getUin());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ArchiveMemorySettingGuide.o().w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class h implements DialogInterface.OnClickListener {
        h() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ArchiveMemorySettingGuide.o().x();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class i implements DialogInterface.OnCancelListener {
        i() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            ArchiveMemorySettingGuide.o().w();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class j implements c.InterfaceC0499c {
        j() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            QZoneFeedxInteractOperateDialogPart.this.f54906e.onHideFeeds(true, -1);
            QZoneFeedxInteractOperateDialogPart.this.W9(5, businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class k implements c.InterfaceC0499c {
        k() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            QZoneFeedxInteractOperateDialogPart.this.f54906e.onHideFeeds(false, -1);
            QZoneFeedxInteractOperateDialogPart.this.W9(4, businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class m implements c.InterfaceC0499c {
        m() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            QZoneFeedxInteractOperateDialogPart.this.f54906e.onShareToWxMoments();
            if (businessFeedData == null || businessFeedData.getCellLuckyMoney() == null) {
                return;
            }
            ClickReport.q("481", "3", "1", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class n implements c.InterfaceC0499c {
        n() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            QZoneFeedxInteractOperateDialogPart.this.f54906e.onShareToWeixin();
            if (businessFeedData == null || businessFeedData.getCellLuckyMoney() == null) {
                return;
            }
            ClickReport.q("481", "3", "2", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class o implements c.InterfaceC0499c {
        o() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            QZoneFeedxInteractOperateDialogPart.this.f54906e.onShareToQQ();
            if (businessFeedData == null || businessFeedData.getCellLuckyMoney() == null) {
                return;
            }
            ClickReport.q("481", "3", "3", true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class p implements c.InterfaceC0499c {
        p() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            QZoneFeedxInteractOperateDialogPart.this.U9(new com.qzone.common.activities.base.k(businessFeedData), QZoneFeedxInteractOperateDialogPart.this);
            QZoneFeedxInteractOperateDialogPart.this.W9(2, businessFeedData);
        }
    }

    /* loaded from: classes37.dex */
    class q implements QzoneFavoriteService.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f54944a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f54945b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f54946c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f54947d;

        q(long j3, String str, long j16, long j17) {
            this.f54944a = j3;
            this.f54945b = str;
            this.f54946c = j16;
            this.f54947d = j17;
        }

        @Override // com.qzone.business.favorite.service.QzoneFavoriteService.d
        public void a(String str, boolean z16) {
            QzoneFavoriteService.M().I(this.f54944a, str, this.f54945b, this.f54946c, this.f54947d, QZoneFeedxInteractOperateDialogPart.this.getMainHandler());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class r implements c.InterfaceC0499c {
        r() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            QZoneFeedxInteractOperateDialogPart qZoneFeedxInteractOperateDialogPart = QZoneFeedxInteractOperateDialogPart.this;
            qZoneFeedxInteractOperateDialogPart.S9(qZoneFeedxInteractOperateDialogPart.getActivity(), businessFeedData.getUser().uin, 3011, QZoneContant.QZ_REQUEST_EVENT_TAG_FEED_ADD_FRIEND);
            x5.a.a(businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class s implements DialogInterface.OnDismissListener {
        s() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            QZoneFeedxInteractOperateDialogPart.this.f54905d = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class w implements c.InterfaceC0499c {
        w() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            QZoneFeedxInteractOperateDialogPart.this.f54906e.onFeedEdit();
            QZoneFeedService U = QZoneFeedService.U();
            if (U != null && U.f47216d == 0) {
                FeedActionRecorder.getInstance().addAction(businessFeedData, 0, System.currentTimeMillis(), 52, 1, 0, false);
            }
            if (businessFeedData != null && businessFeedData.getCellLuckyMoney() != null) {
                ClickReport.q("481", "3", "4", true);
            }
            QZoneFeedxInteractOperateDialogPart.this.W9(9, businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class x implements c.InterfaceC0499c {
        x() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            BusinessFeedData businessFeedData2;
            QZoneFeedxInteractOperateDialogPart.this.ga(businessFeedData, i3);
            if (businessFeedData != null && businessFeedData.getFeedCommInfo().isBizRecomFamousFeeds() && businessFeedData.isSubFeed) {
                QZoneWriteOperationService.v0().J(businessFeedData.containerIndex, businessFeedData.parentFeedData, 2);
                EventCenter.getInstance().post("WriteOperation", 38, businessFeedData.parentFeedData.getFeedCommInfo().feedskey);
            }
            if ((businessFeedData == null || (businessFeedData2 = businessFeedData.parentFeedData) == null || (!businessFeedData2.isFriendLikeContainer() && !businessFeedData.parentFeedData.isFrdLikeMiniAppContainer()) || businessFeedData.parentFeedData.getFeedCommInfo() == null) ? false : true) {
                EventCenter.getInstance().post("WriteOperation", 38, businessFeedData.parentFeedData.getFeedCommInfo().feedskey);
            }
            if (businessFeedData != null && businessFeedData.isFriendAnniversaryFeed()) {
                HashMap hashMap = new HashMap();
                if (businessFeedData.getCellGuiding() != null) {
                    hashMap.put("guiding_type", String.valueOf(businessFeedData.getCellGuiding().guiding_type));
                }
                QZoneWriteOperationService.v0().f2(1, 3L, 1, hashMap);
            }
            if (businessFeedData != null && !businessFeedData.isCardFollowMoreRecommendContainerFeed()) {
                EventCenter.getInstance().post("WriteOperation", 38, businessFeedData.getFeedCommInfo().feedskey);
            }
            QZoneFeedxInteractOperateDialogPart.this.sa(businessFeedData);
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

    private void Aa() {
        this.f54905d.m(24, new ae());
    }

    private void Ba() {
        this.f54905d.m(17, new z());
    }

    private void Ca() {
        this.f54905d.m(8, new p());
    }

    private void Da() {
        this.f54905d.I(1, new c.b() { // from class: com.qzone.reborn.feedx.part.QZoneFeedxInteractOperateDialogPart.36
            @Override // com.qzone.reborn.share.c.b
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
                    yo.g gVar = new yo.g(s_droplist_optionVar2.jumpurl, null);
                    gVar.f450714g = hashMap;
                    yo.d.b(QZoneFeedxInteractOperateDialogPart.this.getActivity(), gVar);
                }
                if (s_droplist_optionVar2.actiontype == 40) {
                    String str = businessFeedData.getFeedCommInfo().feedskey;
                    if (QZoneAdFeedDataExtKt.isRewardAd(businessFeedData)) {
                        ih.f.f407629a.g(businessFeedData2);
                    } else if (QZoneAdFeedDataExtKt.isTianshuAd(businessFeedData)) {
                        ih.f.f407629a.i(QZoneAdFeedDataExtKt.getTianshuData(businessFeedData), 4);
                    } else {
                        ToastUtil.r(HardCodeUtil.qqStr(R.string.f170930b53));
                        if (businessFeedData.isGDTAdvFeed() && businessFeedData2.isSubFeed) {
                            str = businessFeedData2.parentFeedData.getFeedCommInfo().feedskey;
                        }
                        QZoneFeedxInteractOperateDialogPart.this.va(businessFeedData2);
                    }
                    i17 = 1;
                    EventCenter.getInstance().post("WriteOperation", 38, str);
                } else {
                    i17 = 1;
                }
                if (s_droplist_optionVar2.actiontype == 41) {
                    QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.part.QZoneFeedxInteractOperateDialogPart.36.1
                        @Override // java.lang.Runnable
                        public void run() {
                            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData2.getFeedCommInfo().feedskey);
                        }
                    }, 2000L);
                }
                if (businessFeedData.isGDTAdvFeed() && businessFeedData2.cellNegativeFeedback != null && s_droplist_optionVar2.actiontype == 56) {
                    String str2 = businessFeedData.getFeedCommInfo().feedskey;
                    if (businessFeedData.isGDTAdvFeed() && businessFeedData2.isSubFeed) {
                        str2 = businessFeedData2.parentFeedData.getFeedCommInfo().feedskey;
                    }
                    EventCenter eventCenter = EventCenter.getInstance();
                    Object[] objArr = new Object[i17];
                    objArr[0] = str2;
                    eventCenter.post("WriteOperation", 38, objArr);
                    QZoneFeedxInteractOperateDialogPart.this.va(businessFeedData2);
                }
            }
        });
    }

    private void Ea() {
        this.f54905d.m(5, new b());
    }

    private void Fa() {
        this.f54905d.m(18, new aa());
    }

    private void Ga() {
        this.f54905d.m(4, new w());
    }

    private void Ha() {
        this.f54905d.m(3, new k());
    }

    private void Ia() {
        this.f54905d.m(6, new ag());
    }

    private void Ja() {
        this.f54905d.m(27, new ab());
    }

    private void Ka() {
        this.f54905d.B(1, new y());
    }

    private void La() {
        this.f54905d.m(2, new j());
    }

    private void Ma() {
        this.f54905d.m(16, new x());
    }

    private void Na() {
        this.f54905d.m(20, new ad());
    }

    private void Oa() {
        this.f54905d.m(7, new l());
    }

    private void Pa() {
        this.f54905d.m(10, new af());
    }

    private void Qa() {
        this.f54905d.m(25, new u());
    }

    private void Ra() {
        this.f54905d.m(23, new ac());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S9(Activity activity, long j3, int i3, int i16) {
        ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).launchAddFriendForResult(activity, ((IAddFriendApi) QRoute.api(IAddFriendApi.class)).startAddFriend(getActivity(), 1, String.valueOf(j3), "", i3, 21, null, null, null, null, null), i16);
    }

    private void Sa() {
        this.f54905d.m(12, new a());
    }

    private void Ta() {
        this.f54905d.m(15, new m());
    }

    private void Ua() {
        this.f54905d.m(9, new o());
    }

    private void Va() {
        this.f54905d.m(14, new n());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W9(int i3, BusinessFeedData businessFeedData) {
        b.Companion companion = fh.b.INSTANCE;
        if (companion.f(businessFeedData)) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(companion.a(businessFeedData));
            hashMap.put(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, Integer.valueOf(i3));
            hashMap.put("qq_eid", "em_qz_more");
            hashMap.put("qq_pgid", Z9());
            hashMap.putAll(aa(businessFeedData));
            fo.c.c("qq_clck", hashMap);
        }
    }

    private void Wa() {
        this.f54905d.m(11, new t());
    }

    private void Xa() {
        this.f54905d.m(13, new v());
    }

    private void Za(BusinessFeedData businessFeedData) {
        String qqStr;
        this.f54908h = QZoneFeedUtil.z();
        if (businessFeedData != null && businessFeedData.isQQVideoFeeds()) {
            qqStr = com.dataline.util.j.d("\u786e\u8ba4\u5220\u9664\u8fd9\u6761\u52a8\u6001\u5417\uff1f\u7a7a\u95f4\u52a8\u6001\u548cQQ\u5c0f\u4e16\u754c\u5c06\u540c\u65f6\u5220\u9664\u54e6");
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.gey);
        }
        DialogUtil.createDialogWithCheckBox(getActivity(), 230, null, qqStr, QZoneFeedUtil.A(businessFeedData), this.f54908h, HardCodeUtil.qqStr(R.string.gd5), HardCodeUtil.qqStr(R.string.a8j), new d(), new e(businessFeedData), new f()).show();
    }

    private Map<String, Object> aa(BusinessFeedData businessFeedData) {
        HashMap hashMap = new HashMap();
        if (ef.b.h(businessFeedData)) {
            hashMap.put("open_visit_state", 0);
            hashMap.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, LoginData.getInstance().getUid());
        } else {
            hashMap.put("open_visit_state", 1);
            hashMap.put(SquareReportConst.Key.KEY_ZPLAN_TO_UID, "");
        }
        if (businessFeedData != null) {
            hashMap.put("touin", Long.valueOf(businessFeedData.getUser().uin));
        }
        return hashMap;
    }

    private void ab(int i3, String str, ArrayList<String> arrayList) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(UgcSettingUtil.KEY_PERMISSION_CODE, i3);
        if (arrayList != null && arrayList.size() > 0) {
            bundle.putStringArrayList("uin_list", arrayList);
            ArrayList<String> arrayList2 = new ArrayList<>(arrayList.size());
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(s8.f.f().g(it.next()));
            }
            bundle.putStringArrayList(UgcSettingUtil.KEY_NICKNAMES, arrayList2);
        }
        if (com.qzone.feed.utils.h.h(i3) && !TextUtils.isEmpty(this.C)) {
            bundle.putString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, this.C);
        }
        yo.d.k(getActivity(), str, QZoneContant.QZ_FEED_PERMISSION_SET_REQUEST_CODE, bundle, null, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String ba(CellFeedCommInfo cellFeedCommInfo) {
        return cellFeedCommInfo.feedsType == 0 ? cellFeedCommInfo.feedskey : cellFeedCommInfo.feedsid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ga(BusinessFeedData businessFeedData, int i3) {
        int i16;
        int i17;
        if (businessFeedData.isSpecialCareInContainerFeed()) {
            LpReportInfo_pf00064.allReport(PlayerResources.ViewId.EXTENDED_VIEW_BTN_NORMAL_BUTTON, 2, 2);
        } else if (businessFeedData.isCardFriendsRecommendContainerFeed() || businessFeedData.isCardSchoolRecommendContainerFeed() || businessFeedData.isCardFollowMoreRecommendContainerFeed() || businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed()) {
            LpReportInfo_pf00064.allReport(PlayerResources.ViewId.EXTENDED_VIEW_BTN_SHINE_BUTTON, 2, 2);
        }
        if (businessFeedData.isCardFollowMoreRecommendContainerFeed()) {
            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData.getFeedCommInfo().feedskey);
        }
        if (!businessFeedData.isFriendPlayingFeedV2() && !businessFeedData.isAlbumRecFeed() && !businessFeedData.isFrdLikeMiniAppContainer()) {
            if (businessFeedData.isFriendPlayingRecomm()) {
                com.qzone.util.ap.f59791b.e(45, 1, i3, businessFeedData);
            }
        } else {
            com.qzone.util.ap.f59791b.e(64, 1, i3, businessFeedData);
        }
        if (businessFeedData.isCardFriendsRecommendContainerFeed()) {
            Iterator<s_droplist_option> it = businessFeedData.getFeedCommInfo().customDroplist.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i17 = 81;
                    break;
                }
                s_droplist_option next = it.next();
                if (next.actiontype == 42) {
                    i17 = next.reporttype;
                    break;
                }
            }
            QZoneWriteOperationService.v0().O(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).getHandler(), businessFeedData.getUser().uin, i17, businessFeedData.getOperationInfo().droplist_cookie, null);
        }
        String str = "";
        if (!businessFeedData.isFriendBirthdayContainerFeed() && !businessFeedData.isCardSchoolRecommendContainerFeed() && !businessFeedData.isCardFollowMoreRecommendContainerFeed() && !businessFeedData.isSpecialCareInContainerFeed() && !businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed() && !businessFeedData.isFriendAnniversaryFeed() && !businessFeedData.isRegisterAnniversaryFeed() && !businessFeedData.isFunctionGuideFeed() && !businessFeedData.isQCircleRecommFeed()) {
            if (businessFeedData.isRecomEventTagFeed()) {
                com.qzone.adapter.feedcomponent.i.z2(Boolean.FALSE);
                EventCenter.getInstance().post("WriteOperation", 38, businessFeedData.getFeedCommInfo().feedskey);
                com.qzone.adapter.feedcomponent.i.H().z(12, 24, 1, System.currentTimeMillis(), businessFeedData, i3, 0);
                ClickReport.q("302", "557", "5", true);
                return;
            }
            if (businessFeedData.isNewGuideFeed()) {
                LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064(302, 102, 4);
                lpReportInfo_pf00064.reserves3 = businessFeedData.getCellGuiding().guiding_type + "";
                LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
            }
        } else {
            EventCenter.getInstance().post("Feed", 27);
            com.qzone.adapter.feedcomponent.i.z2(Boolean.FALSE);
            T9(businessFeedData);
            QZoneWriteOperationService.v0().I(i3, businessFeedData);
            if (businessFeedData.isCardSchoolRecommendContainerFeed()) {
                LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064("650", "8"), false, false);
            } else if (businessFeedData.isCardSpecialFollowMoreRecommendContainerFeed()) {
                LpReportManager.getInstance().reportToPF00064(new LpReportInfo_pf00064("721", "7"), false, false);
            }
        }
        BusinessFeedData businessFeedData2 = (businessFeedData.getRecBusinessFeedDatas() == null || (i16 = businessFeedData.currShowIndex) < 0 || i16 >= businessFeedData.getRecBusinessFeedDatas().size() || businessFeedData.isSpecialCareInContainerFeed() || businessFeedData.isFriendVideoFeed()) ? businessFeedData : businessFeedData.getRecBusinessFeedDatas().get(businessFeedData.currShowIndex);
        if (businessFeedData2.getRecommAction() != null && businessFeedData2.getRecommAction().reportUrl != null) {
            str = businessFeedData2.getRecommAction().reportUrl;
        }
        if (businessFeedData2.getActiveAdv() != null && businessFeedData2.getActiveAdv().reportUrl != null) {
            str = businessFeedData2.getActiveAdv().reportUrl;
        }
        if (businessFeedData2.isAttach() && businessFeedData2.getCellAdvContainerAttach().isReport == 1 && !StringUtil.isEmpty(businessFeedData2.getCellAdvContainerAttach().reportUrl)) {
            str = businessFeedData2.getCellAdvContainerAttach().reportUrl;
        }
        if (businessFeedData2.isCardSpecialFollowMoreRecommendContainerFeed()) {
            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData2.getFeedCommInfo().feedskey);
            return;
        }
        if (businessFeedData2.isSpecialCareInContainerFeed()) {
            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData2.getFeedCommInfo().feedskey);
            MiscReportUtils.p();
            return;
        }
        if (businessFeedData2.isFriendBirthdayContainerFeed()) {
            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData2.getFeedCommInfo().feedskey);
            return;
        }
        if (businessFeedData2.isFunctionGuideFeed()) {
            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData2.getFeedCommInfo().feedskey);
            return;
        }
        if (businessFeedData2.isFriendAnniversaryFeed()) {
            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData2.getFeedCommInfo().feedskey);
            return;
        }
        if (businessFeedData2.isRegisterAnniversaryFeed()) {
            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData2.getFeedCommInfo().feedskey);
            return;
        }
        if (businessFeedData2.getFeedCommInfo().isRecomLiveShowFeed()) {
            QZoneWriteOperationService v06 = QZoneWriteOperationService.v0();
            BusinessFeedData businessFeedData3 = businessFeedData2.parentFeedData;
            if (businessFeedData3 == null) {
                businessFeedData3 = businessFeedData2;
            }
            v06.I(i3, businessFeedData3);
            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData2.getFeedCommInfo().feedskey);
            return;
        }
        if (businessFeedData2.getFeedCommInfo().isYunYingFeeds()) {
            ((IQbossReportManager) QRoute.api(IQbossReportManager.class)).reportClose(businessFeedData2.getOperationInfo().qbossTrace, null);
            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData.getFeedCommInfo().feedskey);
            return;
        }
        if (businessFeedData2.isNewGuideFeed()) {
            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData.getFeedCommInfo().feedskey);
            return;
        }
        if (businessFeedData2.isAlbumRecFeed()) {
            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData.getFeedCommInfo().feedskey);
            return;
        }
        if (businessFeedData2.isQCircleRecommFeed()) {
            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData.getFeedCommInfo().feedskey);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AdsFeedbackReporter.report(str + "2001");
        ToastUtil.r(HardCodeUtil.qqStr(R.string.f170930b53));
        EventCenter.getInstance().post("WriteOperation", 38, businessFeedData.getFeedCommInfo().feedskey);
    }

    private void ha(QZoneResult qZoneResult) {
        if (qZoneResult.getReturnCode() == 0) {
            c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastReportSuccess", "\u4e3e\u62a5\u6210\u529f"));
            return;
        }
        if (qZoneResult.getReturnCode() == -10108) {
            c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastReportYet", "\u5df2\u4e3e\u62a5\u8fc7"));
            return;
        }
        c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastReportFail", "\u4e3e\u62a5\u5931\u8d25 code:") + qZoneResult.getReturnCode());
    }

    private void ia(QZoneResult qZoneResult) {
        if (qZoneResult.getReturnCode() == 0) {
            c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastShieldSuccess", "\u5c4f\u853d\u6210\u529f"));
        } else {
            c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastShieldFail", "\u5c4f\u853d\u5931\u8d25"));
        }
    }

    private void ja(QZoneResult qZoneResult) {
        int i3 = qZoneResult.what;
        if (i3 == 1000106) {
            if (qZoneResult.getSucceed()) {
                c6.a.j(HardCodeUtil.qqStr(R.string.gny), 5);
                eb(qZoneResult.getFeedId());
                xa();
                return;
            }
            c6.a.j(HardCodeUtil.qqStr(R.string.gnx), 5);
            return;
        }
        if (i3 == 1000107) {
            if (qZoneResult.getSucceed()) {
                c6.a.j(HardCodeUtil.qqStr(R.string.gd8), 5);
                fb();
                xa();
                return;
            }
            c6.a.j(HardCodeUtil.qqStr(R.string.gd7), 5);
        }
    }

    private void ma(BusinessFeedData businessFeedData) {
        if (this.f54905d == null) {
            QZoneFeedXBottomSheetMenuMore qZoneFeedXBottomSheetMenuMore = new QZoneFeedXBottomSheetMenuMore(getActivity(), businessFeedData);
            this.f54905d = qZoneFeedXBottomSheetMenuMore;
            qZoneFeedXBottomSheetMenuMore.setOnDismissListener(new s());
        }
    }

    private boolean na(BusinessFeedData businessFeedData) {
        if (QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DEL_SING_ALBUM_FEED_USE_CMD_DELIC, 0) == 0) {
            return false;
        }
        return (businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().uploadnum == 1) || (businessFeedData.getOriginalInfoSafe().getPictureInfo() != null && businessFeedData.getOriginalInfoSafe().getPictureInfo().uploadnum == 1) || QZoneFeedUtil.w(businessFeedData);
    }

    private boolean oa(int i3) {
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_NAME_RESUME_FRAGMENT, 4095);
        if ((i3 & config) != 0) {
            boolean isResumed = getHostFragment().isResumed();
            QZLog.i("QZoneFeedxInteractOperateDialogPart", 2, "isResumed   flag:", Integer.valueOf(i3), "\uff0cwnsFlags:", Integer.valueOf(config), "\uff0ccall isResumed\uff1a", Boolean.valueOf(isResumed));
            return isResumed;
        }
        boolean isVisible = getHostFragment().isVisible();
        QZLog.i("QZoneFeedxInteractOperateDialogPart", 2, "isResumed   flag:", Integer.valueOf(i3), "\uff0cwnsFlags:", Integer.valueOf(config), "\uff0ccall isVisible:", Boolean.valueOf(isVisible));
        return isVisible;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void pa(int i3, String str, BaseRequest baseRequest, boolean z16, long j3, String str2, QZoneRightAccess$GetUgcRightRsp qZoneRightAccess$GetUgcRightRsp) {
        QLog.d("QZoneFeedxInteractOperateDialogPart", 1, "QZoneFeedxInteractOperateDialogPart->onReceive: dispatch Success:" + z16 + " | CmdName:" + baseRequest.getCmd() + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str2);
        if (!z16 || j3 != 0 || qZoneRightAccess$GetUgcRightRsp == null || qZoneRightAccess$GetUgcRightRsp.uin_list.get() == null) {
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<Long> it = qZoneRightAccess$GetUgcRightRsp.uin_list.get().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().toString());
        }
        ab(i3, str, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ua(BusinessFeedData businessFeedData) {
        new com.qzone.component.e().g(getActivity(), null, HardCodeUtil.qqStr(R.string.gno), new ah(businessFeedData), null);
        LpReportInfo_pf00064.allReport(302, 80);
    }

    private void za() {
        this.f54905d.m(1, new r());
    }

    @Override // d5.n
    public boolean Lc() {
        return true;
    }

    public boolean R9(d5.k<BusinessFeedData> kVar, d5.n<BusinessFeedData> nVar) {
        if (QzoneFavoriteService.M().R(kVar.d())) {
            return false;
        }
        QZoneFeedUtil.f0(3585, kVar.b(), getMainHandler(), nVar);
        ClickReport.i(kVar.a(), Integer.toString(kVar.getAppId()), "", "", false, 302, 22, 4);
        return true;
    }

    public void U9(d5.k<BusinessFeedData> kVar, d5.n<BusinessFeedData> nVar) {
        if (R9(kVar, nVar)) {
            return;
        }
        V9(kVar, nVar);
    }

    public boolean V9(d5.k<BusinessFeedData> kVar, d5.n<BusinessFeedData> nVar) {
        if (!QzoneFavoriteService.M().R(kVar.d())) {
            return false;
        }
        QZoneFeedUtil.f0(3586, kVar.b(), getMainHandler(), nVar);
        ClickReport.i(kVar.a(), Integer.toString(kVar.getAppId()), "", "", false, 302, 22, 5);
        return true;
    }

    public void Ya(CharSequence charSequence) {
        if (getActivity().isFinishing() || getActivity().isDestroyed()) {
            return;
        }
        QQCustomDialog message = DialogUtil.createCustomDialog(getActivity(), 230).setPositiveButton(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "DialogGoSetting", "\u53bb\u8bbe\u7f6e"), new h()).setNegativeButton(com.qzone.util.l.a(R.string.j6l), new g()).setMessage(charSequence);
        message.setTitle(R.string.gnz);
        message.setOnCancelListener(new i());
        if (!getActivity().isFinishing() && !getActivity().isDestroyed()) {
            try {
                message.show();
                ArchiveMemorySettingGuide.o().z();
            } catch (Exception unused) {
            }
        }
    }

    protected String Z9() {
        gf.k kVar = (gf.k) getIocInterface(gf.k.class);
        if (kVar == null) {
            return "";
        }
        return fo.c.h(kVar.getPageType());
    }

    @Override // d5.n
    public void b9(d5.k<BusinessFeedData> kVar) {
        long a16 = kVar.a();
        String d16 = kVar.d();
        QzoneFavoriteService.M().Q(new q(a16, d16, kVar.getAppId(), kVar.c()), d16);
    }

    public void bb(String str, String str2) {
        getActivity().startActivityForResult(com.qzone.common.activities.base.ak.r(getActivity(), str, str2, false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip()), QZoneContant.QZ_REQUEST_OPEN_VIP);
    }

    final QZoneFeedOperateLogic ca() {
        if (this.f54906e == null) {
            this.f54906e = new QZoneFeedOperateLogic(getMainHandler(), getActivity(), "feed");
        }
        return this.f54906e;
    }

    public void cb(BusinessFeedData businessFeedData) {
        this.D = businessFeedData;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void da(QZoneResult qZoneResult) {
        if (!qZoneResult.getSucceed()) {
            if (!TextUtils.isEmpty(qZoneResult.getMessage())) {
                c6.a.i(qZoneResult.getMessage());
                return;
            } else {
                c6.a.h(R.string.gds);
                return;
            }
        }
        broadcastMessage("notify_list_adapter_ui", null);
    }

    public void eb(String str) {
        lg.r.f414520a.c(str);
        BusinessFeedData businessFeedData = this.D;
        if (businessFeedData == null || businessFeedData.getCellFeedCommInfo() == null) {
            return;
        }
        this.D.getCellFeedCommInfo().setFeedTop();
    }

    public void fb() {
        lg.r.f414520a.a();
        BusinessFeedData businessFeedData = this.D;
        if (businessFeedData == null || businessFeedData.getCellFeedCommInfo() == null) {
            return;
        }
        this.D.getCellFeedCommInfo().cancelFeedTop();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onActivityResult(int i3, int i16, Intent intent) {
        BusinessAlbumInfo businessAlbumInfo;
        super.onActivityResult(i3, i16, intent);
        if (i3 == 21) {
            if (i16 == -1) {
                this.C = "";
            }
        } else {
            if (i3 == 5679) {
                la(intent);
                return;
            }
            if (i3 == 9236) {
                this.f54907f = true;
            } else {
                if (i3 != 37679 || intent == null || (businessAlbumInfo = (BusinessAlbumInfo) intent.getParcelableExtra(QZoneHelper.QZoneAlbumConstants.KEY_SELECTED_ALBUMINFO)) == null) {
                    return;
                }
                n5.d.l().v(businessAlbumInfo);
            }
        }
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if ("Favor".equals(event.source.getName())) {
            Object[] objArr = (Object[]) event.params;
            int i3 = event.what;
            if (i3 == 1) {
                Boolean bool = (Boolean) objArr[1];
                ra(bool.booleanValue(), (String) objArr[2], 3585);
            } else {
                if (i3 != 2) {
                    return;
                }
                Boolean bool2 = (Boolean) objArr[1];
                ra(bool2.booleanValue(), (String) objArr[2], 3586);
            }
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void onHandleMessage(Message message) {
        super.onHandleMessage(message);
        QZoneResult unpack = QZoneResult.unpack(message);
        if (unpack == null) {
            return;
        }
        switch (message.what) {
            case 999909:
                da(unpack);
                return;
            case 999984:
                if (unpack.getSucceed()) {
                    if (C9() != null) {
                        C9().P1();
                        return;
                    }
                    return;
                }
                c6.a.i(unpack.getMessage());
                return;
            case 1000028:
            case 1000029:
                unpack.getSucceed();
                c6.a.i(unpack.getMessage());
                return;
            case 1000083:
                Bundle bundle = unpack.getBundle();
                if (this.E == 72) {
                    if (bundle == null) {
                        bundle = new Bundle();
                    }
                    bundle.putBoolean("isShareToQQFriendDirect", true);
                    bundle.putLong("shareToQQFriendDirectUIN", this.F);
                    bundle.putInt("shareToQQFriendDirectType", this.G);
                    bundle.putString("shareToQQFriendDirectNick", this.H);
                }
                ca().handleGetShareUrl(unpack.getSucceed(), bundle);
                return;
            case 1000106:
            case 1000107:
                ja(unpack);
                return;
            case 1000112:
                ea(unpack);
                return;
            case 1000176:
                ha(unpack);
                return;
            case 1000178:
                ia(unpack);
                return;
            default:
                return;
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.tencent.biz.richframework.part.Part
    public void onInitView(View view) {
        super.onInitView(view);
        registerIoc(this, gf.h.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        n5.d.l().i(activity);
        n5.d.l().h(2);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        EventCenter.getInstance().removeObserver(this);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        EventCenter.getInstance().addUIObserver(this, "Favor", 1, 2);
    }

    public void qa(BusinessFeedData businessFeedData) {
        if (!NetworkUtil.isNetSupport(getActivity())) {
            c6.a.j(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkNotConnect", "\u7f51\u7edc\u65e0\u8fde\u63a5"), 3);
            return;
        }
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null) {
            return;
        }
        if (QZoneFeedUtil.U(businessFeedData)) {
            Za(businessFeedData);
        } else {
            new com.qzone.component.e().g(getActivity(), null, QZoneFeedUtil.D(businessFeedData), new c(businessFeedData), null);
        }
    }

    public void wa(final int i3, final String str) {
        BusinessFeedData businessFeedData = this.D;
        if (businessFeedData == null || businessFeedData.getCellFeedCommInfo() == null) {
            return;
        }
        VSNetworkHelper.getInstance().sendRequest(new QZoneFeedxGetUgcRightRequest(this.D.getCellFeedCommInfo().appid, this.D.getCellFeedCommInfo().ugcRightKey, this.D.getCellFeedCommInfo().time), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.qzone.reborn.feedx.part.ai
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                QZoneFeedxInteractOperateDialogPart.this.pa(i3, str, baseRequest, z16, j3, str2, (QZoneRightAccess$GetUgcRightRsp) obj);
            }
        });
    }

    public void xa() {
        gf.k kVar = (gf.k) getIocInterface(gf.k.class);
        if (kVar == null || kVar.getPageType() == 1) {
            return;
        }
        broadcastMessage("SCROLL_TO_TOP_AND_REFRESH", null);
    }

    @Override // gf.h
    public void y5(BusinessFeedData businessFeedData) {
        cb(businessFeedData);
        if (businessFeedData == null || businessFeedData.getPermissionInfoV2() == null) {
            return;
        }
        int g16 = com.qzone.feed.utils.h.g(businessFeedData.getPermissionInfoV2().permission_visit);
        int i3 = businessFeedData.getPermissionInfoV2().permission_source;
        String str = businessFeedData.getPermissionInfoV2().permission_jumpurl;
        if (i3 == 3 || i3 == 1) {
            yo.d.k(getActivity(), str, QZoneContant.QZ_PERMISSION_SET_REQUEST_CODE, null, null, null);
        } else if (i3 == 2) {
            if (com.qzone.feed.utils.h.h(g16)) {
                wa(g16, str);
            } else {
                ab(g16, str, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class t implements c.InterfaceC0499c {
        t() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
                if (businessFeedData.getFeedCommInfo().isRealTimeTTTReport()) {
                    com.qzone.adapter.feedcomponent.i.H().y(12, businessFeedData.getFeedCommInfo().isFollowed ? 50 : 49, 1, System.currentTimeMillis(), null, businessFeedData, i3, 0);
                } else {
                    com.qzone.adapter.feedcomponent.i.H().z(12, businessFeedData.getFeedCommInfo().isFollowed ? 50 : 49, 1, System.currentTimeMillis(), businessFeedData, i3, 0);
                }
            }
            QZoneFeedxInteractOperateDialogPart.this.Y9(businessFeedData, i3, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class u implements c.InterfaceC0499c {
        u() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            User user;
            if (businessFeedData != null && (user = businessFeedData.getUser()) != null) {
                MiniChatActivity.S2(QZoneFeedxInteractOperateDialogPart.this.getActivity(), 0, String.valueOf(user.uin), user.nickName, false, 1);
            }
            QZoneFeedxInteractOperateDialogPart.this.W9(1, businessFeedData);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class v implements c.InterfaceC0499c {
        v() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (businessFeedData != null && businessFeedData.getFeedCommInfo() != null) {
                if (businessFeedData.getFeedCommInfo().isRealTimeTTTReport()) {
                    com.qzone.adapter.feedcomponent.i.H().y(12, businessFeedData.getFeedCommInfo().isFollowed ? 50 : 49, 1, System.currentTimeMillis(), null, businessFeedData, i3, 0);
                } else {
                    com.qzone.adapter.feedcomponent.i.H().z(12, businessFeedData.getFeedCommInfo().isFollowed ? 50 : 49, 1, System.currentTimeMillis(), businessFeedData, i3, 0);
                }
            }
            QZoneFeedxInteractOperateDialogPart.this.Y9(businessFeedData, i3, false, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements c.InterfaceC0499c {

        /* renamed from: com.qzone.reborn.feedx.part.QZoneFeedxInteractOperateDialogPart$a$a, reason: collision with other inner class name */
        /* loaded from: classes37.dex */
        class DialogInterfaceOnClickListenerC0461a implements DialogInterface.OnClickListener {
            DialogInterfaceOnClickListenerC0461a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                if (QZoneFeedxInteractOperateDialogPart.this.f54907f) {
                    QZoneFeedxInteractOperateDialogPart.this.f54907f = false;
                    QZoneFeedxInteractOperateDialogPart.this.bb("jhan_feedzhiding", HardCodeUtil.qqStr(R.string.gia));
                }
            }
        }

        a() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (businessFeedData == null) {
                return;
            }
            QZoneFeedxInteractOperateDialogPart.this.W9(8, businessFeedData);
            if (!NetworkState.isNetSupport()) {
                c6.a.i(HardCodeUtil.qqStr(R.string.ci5));
            }
            lg.r rVar = lg.r.f414520a;
            if (rVar.b(businessFeedData) || LoginData.getInstance().isQzoneVip()) {
                QZoneDetailService.U().D0(QZoneFeedxInteractOperateDialogPart.this.ba(businessFeedData.getFeedCommInfo()), rVar.b(businessFeedData), businessFeedData.getFeedCommInfo().feedsType, QZoneFeedxInteractOperateDialogPart.this.getMainHandler());
            } else {
                new com.qzone.component.e().f(QZoneFeedxInteractOperateDialogPart.this.getActivity(), 230, null, HardCodeUtil.qqStr(R.string.gg5), HardCodeUtil.qqStr(R.string.gi_), HardCodeUtil.qqStr(R.string.cancel), new DialogInterfaceOnClickListenerC0461a(), null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class aa implements c.InterfaceC0499c {
        aa() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
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
            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData.getFeedCommInfo().feedskey);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class l implements c.InterfaceC0499c {
        l() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
        public void a(int i3, BusinessFeedData businessFeedData) {
            if (businessFeedData.isSecretFeed() && businessFeedData.getFeedCommInfo() != null && businessFeedData.getCellSummaryV2() != null) {
                QZoneWriteOperationService.v0().g2(QZoneFeedxInteractOperateDialogPart.this.getMainHandler(), businessFeedData.getFeedCommInfo().ugckey, businessFeedData.getCellSummaryV2().summary);
            } else {
                b(businessFeedData);
            }
            QZoneFeedxInteractOperateDialogPart.this.W9(6, businessFeedData);
        }

        private void b(BusinessFeedData businessFeedData) {
            if (businessFeedData == null) {
                return;
            }
            com.tencent.mobileqq.dt.api.b c16 = com.qzone.feed.utils.f.c();
            com.qzone.feed.utils.f.b(c16, businessFeedData);
            com.qzone.feed.utils.f.a(QZoneFeedxInteractOperateDialogPart.this.getActivity(), c16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class z implements c.InterfaceC0499c {
        z() {
        }

        @Override // com.qzone.reborn.share.c.InterfaceC0499c
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
            EventCenter.getInstance().post("WriteOperation", 38, businessFeedData.getFeedCommInfo().feedskey);
        }
    }

    private void la(Intent intent) {
        if (intent == null || intent.getExtras() == null || this.D == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras.containsKey(UgcSettingUtil.KEY_PERMISSION_CODE)) {
            this.f54910m = extras.getInt(UgcSettingUtil.KEY_PERMISSION_CODE, 1);
        }
        if (extras.containsKey("uin_list")) {
            ArrayList<String> stringArrayList = extras.getStringArrayList("uin_list");
            if (stringArrayList == null) {
                stringArrayList = new ArrayList<>();
            }
            ArrayList<String> arrayList = new ArrayList<>();
            this.f54909i = arrayList;
            arrayList.addAll(stringArrayList);
        }
        if (com.qzone.feed.utils.h.h(this.f54910m)) {
            this.C = extras.getString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON);
        }
        if (this.f54910m <= 0 || this.D.getFeedCommInfo() == null) {
            return;
        }
        QZoneWriteOperationService.v0().j2(getMainHandler(), this.D.getIdInfo().cellId, this.D.getFeedCommInfo().ugckey, this.f54910m, this.f54909i);
    }

    @Override // com.qzone.personalize.ArchiveMemorySettingGuide.c
    public void D4(CharSequence charSequence) {
        if (oa(16)) {
            Ya(charSequence);
        }
    }

    @Override // gf.h
    public void h2(BusinessFeedData businessFeedData, int i3, QZoneFeedXBottomSheetMenuMore.i iVar) {
        if (businessFeedData == null || getActivity() == null) {
            return;
        }
        this.I = i3;
        cb(businessFeedData);
        ma(businessFeedData);
        if (this.f54906e == null) {
            this.f54906e = ca();
        }
        this.f54906e.setFeedData(businessFeedData);
        za();
        Ca();
        Ua();
        Va();
        Ta();
        Oa();
        Ha();
        La();
        Ea();
        Ia();
        Wa();
        Xa();
        Ga();
        Pa();
        Aa();
        Ma();
        Ka();
        Na();
        Ba();
        Fa();
        Da();
        Ra();
        Qa();
        Ja();
        Sa();
        if (this.f54905d.j()) {
            return;
        }
        QZoneFeedXBottomSheetMenuMore qZoneFeedXBottomSheetMenuMore = (QZoneFeedXBottomSheetMenuMore) this.f54905d;
        qZoneFeedXBottomSheetMenuMore.l2(iVar);
        qZoneFeedXBottomSheetMenuMore.show();
    }

    public void ta(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null) {
            return;
        }
        int i3 = businessFeedData.getFeedCommInfo().appid;
        if ((i3 == 311 || i3 == 6100) && com.qzone.proxy.feedcomponent.util.d.j(businessFeedData.getFeedCommInfo().operatemask2, 27)) {
            QZoneWriteOperationService.v0().i2(getMainHandler(), businessFeedData.getIdInfo().cellId, businessFeedData.getFeedCommInfo().ugckey);
        } else {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastNonsupporToEdit", "\u8be5\u8bf4\u8bf4\u5185\u5bb9\u6682\u65f6\u4e0d\u652f\u6301\u7f16\u8f91"));
        }
    }

    public void va(BusinessFeedData businessFeedData) {
        List<BusinessFeedData> data;
        BusinessFeedData businessFeedData2;
        if (businessFeedData == null || "1".equals(GdtFeedUtilForQZone.g(businessFeedData)) || C9() == null || C9().T1().getValue() == null || (data = C9().T1().getValue().getData()) == null || data.size() <= 0) {
            return;
        }
        Iterator<BusinessFeedData> it = data.iterator();
        boolean z16 = false;
        while (true) {
            if (!it.hasNext()) {
                businessFeedData2 = null;
                break;
            }
            businessFeedData2 = it.next();
            if ("0".equals(GdtFeedUtilForQZone.g(businessFeedData2))) {
                if (businessFeedData2 == businessFeedData && !z16) {
                    z16 = true;
                } else if (businessFeedData2 != null && businessFeedData2.isGDTAdvFeed() && z16) {
                    break;
                }
            }
        }
        if (businessFeedData2 != null) {
            GdtFeedUtilForQZone.e(businessFeedData2);
            GdtFeedUtilForQZone.C(businessFeedData2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y9(BusinessFeedData businessFeedData, int i3, boolean z16, boolean z17) {
        int c16;
        String str;
        if (businessFeedData == null) {
            return;
        }
        if (!NetworkState.isNetSupport()) {
            ToastUtil.n(R.string.ghi);
            return;
        }
        String str2 = "3";
        if (businessFeedData.isQzoneCardFeed()) {
            if (businessFeedData.getFeedCommInfo().isFollowed) {
                str = "3";
            } else {
                str = "4";
            }
            ClickReport.p("644", str, "", null, true);
        }
        if (businessFeedData.getFeedCommInfo() == null || !businessFeedData.getFeedCommInfo().isLikeRecommFamousFeed()) {
            c16 = z17 ? 3 : c6.a.c(businessFeedData);
        } else {
            c16 = z17 ? 16 : 12;
        }
        int i16 = c16;
        if (z16) {
            BusinessFeedData originalInfo = businessFeedData.getOriginalInfo();
            QZoneWriteOperationService.v0().p0(originalInfo.getUser().uin, !originalInfo.getFeedCommInfo().isFollowed, 10, getMainHandler(), originalInfo.getFeedCommInfo().feedskey, i3, originalInfo.getFeedCommInfo().needAdvReport(), originalInfo.getOperationInfo().cookie, originalInfo.getFeedCommInfo().isInstalled, businessFeedData, z16, 0);
            if (!originalInfo.getFeedCommInfo().isFollowed) {
                str2 = "2";
            }
            ClickReport.q("462", str2, "2", true);
            return;
        }
        QZoneWriteOperationService.v0().p0(businessFeedData.getUser().uin, !businessFeedData.getFeedCommInfo().isFollowed, i16, getMainHandler(), businessFeedData.getFeedCommInfo().feedskey, i3, businessFeedData.getFeedCommInfo().needAdvReport(), businessFeedData.getOperationInfo().cookie, businessFeedData.getFeedCommInfo().isInstalled, businessFeedData, z16, 0);
    }

    private void ea(QZoneResult qZoneResult) {
        if (qZoneResult == null) {
            return;
        }
        if (!qZoneResult.getSucceed()) {
            if (qZoneResult.getMessage() != null && qZoneResult.getMessage().length() > 0) {
                c6.a.i(qZoneResult.getMessage());
                return;
            } else {
                c6.a.i(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastConcernFail", "\u5173\u6ce8\u5931\u8d25"));
                return;
            }
        }
        qZoneResult.getBundle().getLong("uin", 0L);
        qZoneResult.getBundle().getBoolean("isFollow", false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x007a, code lost:
    
        if (java.lang.Integer.valueOf(r8).intValue() == 1) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void T9(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            return;
        }
        if (businessFeedData.isCardFriendsRecommendContainerFeed()) {
            LpReportInfo_pf00064.allReport(619, 10, 6);
            return;
        }
        if (businessFeedData.isSpecialCareInContainerFeed()) {
            LpReportInfo_pf00064.allReport(619, 11, 6);
            return;
        }
        int i3 = 1;
        if (businessFeedData.isFunctionGuideFeed()) {
            if (businessFeedData.getCellGuiding() != null) {
                if (businessFeedData.getCellGuiding().guiding_type == 1) {
                    LpReportInfo_pf00064.allReport(619, 4, 3);
                    return;
                } else {
                    if (businessFeedData.getCellGuiding().guiding_type == 4) {
                        LpReportInfo_pf00064.allReport(619, 3, 3);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (!businessFeedData.isFriendAnniversaryFeed() || businessFeedData.getCellGuiding() == null) {
            return;
        }
        CellGuiding cellGuiding = businessFeedData.getCellGuiding();
        if (cellGuiding.guiding_type == 5) {
            Map<String, String> map = cellGuiding.extendInfo;
            if (map != null) {
                String str = map.get("sub_guide_type");
                if (!TextUtils.isEmpty(str)) {
                    try {
                    } catch (Exception e16) {
                        QLog.e("QZoneFeedxInteractOperateDialogPart", 1, "advTopReportFeedClose  e = " + e16.getMessage());
                    }
                }
            }
            i3 = 2;
            LpReportInfo_pf00064.allReport(619, 15, 2, String.valueOf(i3));
            return;
        }
        ArrayList<User> arrayList = cellGuiding.vecUsers;
        if (arrayList != null) {
            if (arrayList.size() > 2) {
                LpReportInfo_pf00064.allReport(619, 13, 4, "");
                return;
            }
            Iterator<User> it = cellGuiding.vecUsers.iterator();
            while (it.hasNext()) {
                User next = it.next();
                if (next != null) {
                    long uin = LoginData.getInstance().getUin();
                    long j3 = next.uin;
                    if (uin != j3) {
                        LpReportInfo_pf00064.allReport(619, 7, 4, String.valueOf(j3));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class y implements c.d {
        y() {
        }

        @Override // com.qzone.reborn.share.c.d
        public void a(int i3, BusinessFeedData businessFeedData, s_droplist_option s_droplist_optionVar) {
            if (s_droplist_optionVar == null) {
                return;
            }
            int i16 = s_droplist_optionVar.reporttypeV2;
            int i17 = s_droplist_optionVar.reporttype;
            fp.a aVar = new fp.a(s_droplist_optionVar);
            if (i16 == 5) {
                QZoneWriteOperationService.v0().O(QZoneFeedxInteractOperateDialogPart.this.getMainHandler(), businessFeedData.getUser().uin, s_droplist_optionVar.reporttype, businessFeedData.getOperationInfo().droplist_cookie, aVar);
            }
            if (i16 == 4 || i16 == 5) {
                FeedActionRecorder.getInstance().addAction(businessFeedData, i3, System.currentTimeMillis(), 12, i17, 1, 0, false, null, false, 0L);
            }
        }
    }

    private void ra(boolean z16, String str, int i3) {
        if (3585 == i3) {
            QfavHelper.B(getActivity(), LoginData.getInstance().getUinString(), z16, str, false);
            return;
        }
        if (3586 == i3) {
            if (z16) {
                ToastUtil.o(R.string.gfr, 5);
            } else if (TextUtils.isEmpty(str)) {
                ToastUtil.o(R.string.b3x, 4);
            } else {
                ToastUtil.s(str, 4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X9(BusinessFeedData businessFeedData, boolean z16) {
        int i3;
        Object valueOf;
        String str;
        if (businessFeedData == null || businessFeedData.getFeedCommInfo() == null || ArchiveMemorySettingGuide.o().y(businessFeedData, this)) {
            return;
        }
        int i16 = businessFeedData.getFeedCommInfo().appid;
        String str2 = businessFeedData.getIdInfo().cellId;
        String str3 = businessFeedData.getIdInfo().subId;
        String str4 = businessFeedData.getFeedCommInfo().clientkey;
        Map<Integer, String> map = businessFeedData.getOperationInfo().busiParam;
        String str5 = "1";
        if (i16 == 4) {
            str3 = "2";
        } else if ((i16 == 311 || i16 == 6100) && map != null) {
            map.put(10, "1");
        }
        String str6 = str3;
        HashMap hashMap = new HashMap();
        if (!z16) {
            str5 = "0";
        }
        hashMap.put("del_all_media_file", str5);
        if (i16 == 4 && na(businessFeedData)) {
            i3 = 4;
            QZoneWriteOperationService.v0().Z(getMainHandler(), businessFeedData.getFeedCommInfo().ugckey, businessFeedData.getFeedCommInfo().feedskey, str4, businessFeedData.getFeedCommInfo().appid, businessFeedData.getUser().uin, businessFeedData.getFeedCommInfo().feedsType, businessFeedData.getFeedCommInfo().getTime(), businessFeedData.getOperationInfo().busiParam, 25, str2, "");
        } else {
            i3 = 4;
            if (businessFeedData.getFeedCommInfo() != null && businessFeedData.getFeedCommInfo().appid == 330) {
                QZoneWriteOperationService.v0().e0(getMainHandler(), businessFeedData.getFeedCommInfo().ugckey, str4);
            } else {
                QZoneWriteOperationService.v0().V(0, getMainHandler(), businessFeedData.getFeedCommInfo().ugckey, businessFeedData.getFeedCommInfo().feedskey, str4, businessFeedData.getFeedCommInfo().appid, LoginData.getInstance().getUin(), str2, str6, 0, map, 25, "", hashMap);
            }
        }
        businessFeedData.getFeedCommInfoV2();
        if (businessFeedData.getLocalInfoV2() != null) {
            final String str7 = businessFeedData.getFeedCommInfoV2().clientkey;
            List<IQueueTask> B = QZonePublishQueue.w().B(str7);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("remove task clientKey = ");
            sb5.append(str7);
            sb5.append(", taskList size = ");
            if (B == null) {
                valueOf = "null";
            } else {
                valueOf = Integer.valueOf(B.size());
            }
            sb5.append(valueOf);
            QZLog.i("QZoneFeedxInteractOperateDialogPart", sb5.toString());
            if (B != null) {
                for (IQueueTask iQueueTask : B) {
                    if (iQueueTask != null) {
                        boolean f16 = QZonePublishQueue.w().f(iQueueTask);
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("remove task task'cacheKey = ");
                        sb6.append(iQueueTask.getCommentUniKey());
                        sb6.append(" ");
                        if (f16) {
                            str = "success";
                        } else {
                            str = "failed";
                        }
                        sb6.append(str);
                        QZLog.i("QZoneFeedxInteractOperateDialogPart", sb6.toString());
                    }
                }
            }
            if (z16 && i16 == i3) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.reborn.feedx.part.QZoneFeedxInteractOperateDialogPart.15
                    @Override // java.lang.Runnable
                    public void run() {
                        QLog.d("QZoneFeedxInteractOperateDialogPart", 1, "start delete fake photo data");
                        AlbumCacheDataManager.J().k0(str7);
                        AlbumCacheDataManager.J().m0(str7);
                        AlbumCacheDataManager.J().n0(str7);
                        QLog.d("QZoneFeedxInteractOperateDialogPart", 1, "finish delete fake photo data");
                    }
                });
            }
        }
    }

    @Override // d5.n
    public void F7() {
    }

    protected void sa(BusinessFeedData businessFeedData) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
