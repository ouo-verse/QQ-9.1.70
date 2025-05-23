package com.tencent.biz.qqcircle.immersive.personal.bean;

import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdTianshuFeedData;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.personal.publishguide.PublishGuideData;
import com.tencent.biz.qqcircle.immersive.utils.af;
import com.tencent.biz.qqcircle.utils.bh;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$CovenantLiteDialog;
import feedcloud.FeedCloudMeta$FeedAlbum;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudRead$StGetMainPageBasicDataRsp;
import feedcloud.FeedCloudRead$StGetMainPageCommDataRsp;
import feedcloud.FeedCloudRead$StTemplateInfo;
import feedcloud.FeedCloudRead$UserAlbumInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import qqcircle.QQCircleBase$StUserBusiData;
import qqcircle.QQCircleFeedBase$StMainPageBasicBusiRspData;
import qqcircle.QQCircleProfile$StProfileBizData;
import tianshu.QQCircleTianShu$AdItem;
import tianshu.QQCircleTianShu$MapEntry;
import tianshu.QQCircleTianShu$RspEntry;

/* loaded from: classes4.dex */
public class QFSPersonalInfo {
    public static boolean O = false;
    public static String P = "";
    public static String Q = "";
    public String A;
    public String B;
    public int E;
    public String F;
    public b40.d H;
    private CopyOnWriteArrayList<a> I;
    public FeedCloudMeta$CovenantLiteDialog J;
    public List<QFSPersonalTemplateCarouselInfo> K;
    public PublishGuideData N;

    /* renamed from: a, reason: collision with root package name */
    long f88414a;

    /* renamed from: b, reason: collision with root package name */
    String f88415b;

    /* renamed from: e, reason: collision with root package name */
    private QQCircleProfile$StProfileBizData f88418e;

    /* renamed from: o, reason: collision with root package name */
    public String f88428o;

    /* renamed from: p, reason: collision with root package name */
    public String f88429p;

    /* renamed from: q, reason: collision with root package name */
    public String f88430q;

    /* renamed from: r, reason: collision with root package name */
    public FeedCloudRead$StTemplateInfo f88431r;

    /* renamed from: s, reason: collision with root package name */
    public List<Integer> f88432s;

    /* renamed from: t, reason: collision with root package name */
    public String f88433t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f88434u;

    /* renamed from: v, reason: collision with root package name */
    public String f88435v;

    /* renamed from: w, reason: collision with root package name */
    public String f88436w;

    /* renamed from: x, reason: collision with root package name */
    public String f88437x;

    /* renamed from: z, reason: collision with root package name */
    public String f88439z;

    /* renamed from: c, reason: collision with root package name */
    public FeedCloudMeta$StUser f88416c = new FeedCloudMeta$StUser();

    /* renamed from: d, reason: collision with root package name */
    public QQCircleBase$StUserBusiData f88417d = new QQCircleBase$StUserBusiData();

    /* renamed from: f, reason: collision with root package name */
    public String f88419f = "";

    /* renamed from: g, reason: collision with root package name */
    public String f88420g = "";

    /* renamed from: h, reason: collision with root package name */
    public String f88421h = "";

    /* renamed from: i, reason: collision with root package name */
    public int f88422i = 0;

    /* renamed from: j, reason: collision with root package name */
    public int f88423j = 0;

    /* renamed from: k, reason: collision with root package name */
    public boolean f88424k = false;

    /* renamed from: l, reason: collision with root package name */
    public boolean f88425l = false;

    /* renamed from: m, reason: collision with root package name */
    public boolean f88426m = false;

    /* renamed from: n, reason: collision with root package name */
    public boolean f88427n = false;

    /* renamed from: y, reason: collision with root package name */
    public int f88438y = 0;
    public String C = "";
    private boolean D = false;
    private int G = 0;
    public boolean L = false;
    public boolean M = false;

    /* renamed from: com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo$4, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass4 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FeedCloudMeta$StUser f88443d;
        final /* synthetic */ QFSPersonalInfo this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.w(this.f88443d.busiData.get().toByteArray());
            this.this$0.l();
        }
    }

    /* loaded from: classes4.dex */
    public interface a {
        void b(QFSPersonalInfo qFSPersonalInfo);
    }

    public QFSPersonalInfo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = this.I;
        if (copyOnWriteArrayList == null) {
            return;
        }
        Iterator<a> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next != null) {
                next.b(this);
            }
        }
        this.I.clear();
    }

    private void m(FeedCloudRead$UserAlbumInfo feedCloudRead$UserAlbumInfo) {
        ArrayList arrayList = new ArrayList();
        if (this.f88425l && feedCloudRead$UserAlbumInfo.allow_create_album.get()) {
            arrayList.add(new b40.a());
            QLog.i("FSPersonalInfo", 1, "[parseAlbumsData] -> allow_create_album");
        }
        List<FeedCloudMeta$FeedAlbum> list = feedCloudRead$UserAlbumInfo.albums.get();
        if (list != null && !list.isEmpty()) {
            for (FeedCloudMeta$FeedAlbum feedCloudMeta$FeedAlbum : list) {
                arrayList.add(new b40.a(feedCloudMeta$FeedAlbum));
                QLog.i("FSPersonalInfo", 1, "[parseAlbumsData] -> album status:" + feedCloudMeta$FeedAlbum.status.get());
            }
        }
        QLog.i("FSPersonalInfo", 1, "[parseAlbumsData] -> albumInfos.size = " + arrayList.size());
        this.H = new b40.d(this.f88420g, feedCloudRead$UserAlbumInfo.load_more_attach_info.get(), feedCloudRead$UserAlbumInfo.has_more.get(), arrayList);
    }

    private void n(FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp) {
        this.f88431r = feedCloudRead$StGetMainPageCommDataRsp.templateInfo;
    }

    private void p(QQCircleFeedBase$StMainPageBasicBusiRspData qQCircleFeedBase$StMainPageBasicBusiRspData) {
        List<Integer> list;
        boolean z16;
        if (qQCircleFeedBase$StMainPageBasicBusiRspData.opMask.has()) {
            list = qQCircleFeedBase$StMainPageBasicBusiRspData.opMask.get();
        } else {
            list = null;
        }
        this.f88432s = list;
        if (list != null && list.contains(7)) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f88434u = z16;
    }

    private void q(FeedCloudRead$StGetMainPageBasicDataRsp feedCloudRead$StGetMainPageBasicDataRsp) {
        String str;
        if (feedCloudRead$StGetMainPageBasicDataRsp.pmBeginShow.has()) {
            str = feedCloudRead$StGetMainPageBasicDataRsp.pmBeginShow.get();
        } else {
            str = null;
        }
        this.f88428o = str;
        boolean z16 = true;
        if (feedCloudRead$StGetMainPageBasicDataRsp.isPenguinUser.get() != 1) {
            z16 = false;
        }
        this.D = z16;
        this.J = feedCloudRead$StGetMainPageBasicDataRsp.dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(byte[] bArr) {
        QQCircleFeedBase$StMainPageBasicBusiRspData qQCircleFeedBase$StMainPageBasicBusiRspData = new QQCircleFeedBase$StMainPageBasicBusiRspData();
        try {
            qQCircleFeedBase$StMainPageBasicBusiRspData.mergeFrom(bArr);
            u(qQCircleFeedBase$StMainPageBasicBusiRspData);
            p(qQCircleFeedBase$StMainPageBasicBusiRspData);
            this.f88435v = qQCircleFeedBase$StMainPageBasicBusiRspData.userFeedbackButtonJumpUrl.get();
            if (qQCircleFeedBase$StMainPageBasicBusiRspData.profileBusiData.has()) {
                QQCircleProfile$StProfileBizData qQCircleProfile$StProfileBizData = new QQCircleProfile$StProfileBizData();
                this.f88418e = qQCircleProfile$StProfileBizData;
                qQCircleProfile$StProfileBizData.mergeFrom(qQCircleFeedBase$StMainPageBasicBusiRspData.profileBusiData.get().toByteArray());
            }
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("FSPersonalInfo", 1, "mergeFrom StMainPageBusiRspData error");
            e16.printStackTrace();
        }
    }

    private boolean s(FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp) {
        if (this.L) {
            QLog.d("FSPersonalInfo", 1, "parseTemplateCarouselInfo, cache data ");
            return false;
        }
        List<QFSPersonalTemplateCarouselInfo> b16 = QFSPersonalTemplateCarouselInfo.INSTANCE.b(feedCloudRead$StGetMainPageCommDataRsp.tianshuMaterialInfos.get(), feedCloudRead$StGetMainPageCommDataRsp.templateInfo);
        if (!b16.isEmpty()) {
            QLog.d("FSPersonalInfo", 1, "parseTemplateCarouselInfo, templateCarouselInfoList is not null ");
            this.K = b16;
            return true;
        }
        QLog.d("FSPersonalInfo", 1, "parseTemplateCarouselInfo, templateCarouselInfoList is null ");
        this.K = null;
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c6, code lost:
    
        switch(r8) {
            case 0: goto L91;
            case 1: goto L90;
            case 2: goto L89;
            case 3: goto L88;
            case 4: goto L87;
            case 5: goto L86;
            default: goto L98;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d4, code lost:
    
        if (android.text.TextUtils.isEmpty(r5.value.get()) != false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d6, code lost:
    
        r9.A = r5.value.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00e9, code lost:
    
        if (android.text.TextUtils.isEmpty(r5.value.get()) != false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00eb, code lost:
    
        r9.f88436w = r5.value.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00ff, code lost:
    
        if (android.text.TextUtils.isEmpty(r5.value.get()) != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0101, code lost:
    
        r9.f88437x = r5.value.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0115, code lost:
    
        if (android.text.TextUtils.isEmpty(r5.value.get()) != false) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0117, code lost:
    
        r9.f88438y = java.lang.Integer.parseInt(r5.value.get());
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0125, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0126, code lost:
    
        com.tencent.qphone.base.util.QLog.e("FSPersonalInfo", 1, "mapEntry.value.get() exception:", r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0138, code lost:
    
        if (android.text.TextUtils.isEmpty(r5.value.get()) != false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x013a, code lost:
    
        r9.f88439z = r5.value.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x014e, code lost:
    
        if (android.text.TextUtils.isEmpty(r5.value.get()) != false) goto L110;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0150, code lost:
    
        r9.B = r5.value.get();
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void t(List<QQCircleTianShu$RspEntry> list) {
        if (list != null && !list.isEmpty()) {
            for (QQCircleTianShu$RspEntry qQCircleTianShu$RspEntry : list) {
                if (qQCircleTianShu$RspEntry.key.get() == 1040) {
                    List<QQCircleTianShu$AdItem> list2 = qQCircleTianShu$RspEntry.value.lst.get();
                    if (list2 != null && !list2.isEmpty()) {
                        for (int size = list2.size() - 1; size >= 0; size--) {
                            QQCircleTianShu$AdItem qQCircleTianShu$AdItem = list2.get(size);
                            this.E = qQCircleTianShu$AdItem.iAdId.get();
                            this.F = qQCircleTianShu$AdItem.traceinfo.get();
                            Iterator<QQCircleTianShu$MapEntry> it = qQCircleTianShu$AdItem.argList.get().iterator();
                            while (it.hasNext()) {
                                QQCircleTianShu$MapEntry next = it.next();
                                String str = next.key.get();
                                str.hashCode();
                                char c16 = '\uffff';
                                switch (str.hashCode()) {
                                    case -1759410662:
                                        if (str.equals(QZoneAdTianshuFeedData.KEY_BUTTON_TEXT)) {
                                            c16 = 0;
                                            break;
                                        }
                                        break;
                                    case -907987551:
                                        if (str.equals(QZoneDTLoginReporter.SCHEMA)) {
                                            c16 = 1;
                                            break;
                                        }
                                        break;
                                    case -245025015:
                                        if (str.equals("card_type")) {
                                            c16 = 2;
                                            break;
                                        }
                                        break;
                                    case -42298471:
                                        if (str.equals("sub_title")) {
                                            c16 = 3;
                                            break;
                                        }
                                        break;
                                    case 808229970:
                                        if (str.equals("main_title")) {
                                            c16 = 4;
                                            break;
                                        }
                                        break;
                                    case 1427821874:
                                        if (str.equals("background_img")) {
                                            c16 = 5;
                                            break;
                                        }
                                        break;
                                }
                                while (it.hasNext()) {
                                }
                            }
                        }
                    } else {
                        return;
                    }
                }
            }
            return;
        }
        QLog.e("FSPersonalInfo", 1, "rspEntry == null");
    }

    private void u(QQCircleFeedBase$StMainPageBasicBusiRspData qQCircleFeedBase$StMainPageBasicBusiRspData) {
        List<FeedCloudCommon$Entry> list = qQCircleFeedBase$StMainPageBasicBusiRspData.urlInfo.get();
        this.f88429p = af.a(list, "TaskCenterUrl");
        this.f88430q = af.a(list, "CreatorGrowthCenterUrl");
    }

    private void v(FeedCloudMeta$StUser feedCloudMeta$StUser) {
        boolean z16;
        if (feedCloudMeta$StUser == null) {
            return;
        }
        this.f88416c = feedCloudMeta$StUser;
        this.f88419f = feedCloudMeta$StUser.icon.iconUrl.get();
        this.f88420g = feedCloudMeta$StUser.f398463id.get();
        this.f88421h = feedCloudMeta$StUser.nick.get();
        this.G = feedCloudMeta$StUser.newAddedFansCount.get();
        this.f88422i = feedCloudMeta$StUser.blackState.get();
        this.f88425l = QCirclePluginUtil.isOwner(this.f88420g);
        int i3 = this.f88422i;
        boolean z17 = false;
        if (i3 != 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f88426m = z16;
        if (i3 == 1 || i3 == 3) {
            z17 = true;
        }
        this.f88427n = z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(byte[] bArr) {
        QQCircleBase$StUserBusiData qQCircleBase$StUserBusiData = new QQCircleBase$StUserBusiData();
        this.f88417d = qQCircleBase$StUserBusiData;
        try {
            qQCircleBase$StUserBusiData.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("FSPersonalInfo", 1, "mergeFrom StUserBusiData error");
            e16.printStackTrace();
        }
    }

    public void A(final FeedCloudRead$StGetMainPageBasicDataRsp feedCloudRead$StGetMainPageBasicDataRsp) {
        if (feedCloudRead$StGetMainPageBasicDataRsp == null) {
            return;
        }
        q(feedCloudRead$StGetMainPageBasicDataRsp);
        v(feedCloudRead$StGetMainPageBasicDataRsp.user);
        if (!RFWThreadManager.isMainThread()) {
            r(feedCloudRead$StGetMainPageBasicDataRsp.busiRspData.get().toByteArray());
            w(feedCloudRead$StGetMainPageBasicDataRsp.user.busiData.get().toByteArray());
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo.2
                @Override // java.lang.Runnable
                public void run() {
                    QFSPersonalInfo.this.r(feedCloudRead$StGetMainPageBasicDataRsp.busiRspData.get().toByteArray());
                    QFSPersonalInfo qFSPersonalInfo = QFSPersonalInfo.this;
                    qFSPersonalInfo.w(qFSPersonalInfo.f88416c.busiData.get().toByteArray());
                    QFSPersonalInfo.this.l();
                }
            });
        }
    }

    public void B(final FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp) {
        this.f88423j = feedCloudRead$StGetMainPageCommDataRsp.feedCount.get();
        this.f88433t = feedCloudRead$StGetMainPageCommDataRsp.specialMainPageTailText.get();
        this.M = feedCloudRead$StGetMainPageCommDataRsp.isOpenShareAD.get();
        O = "1".equals(bh.d(feedCloudRead$StGetMainPageCommDataRsp.extInfo.mapInfo.get(), "should_show_qzone_album_entry"));
        P = bh.d(feedCloudRead$StGetMainPageCommDataRsp.extInfo.mapInfo.get(), "qzone_album_entry_tips");
        Q = bh.d(feedCloudRead$StGetMainPageCommDataRsp.extInfo.mapInfo.get(), "qzone_album_schema");
        if (!s(feedCloudRead$StGetMainPageCommDataRsp)) {
            if (!this.L) {
                this.N = PublishGuideData.INSTANCE.a(feedCloudRead$StGetMainPageCommDataRsp.guide_banner.get());
            } else {
                QLog.i("FSPersonalInfo", 1, "QFSPersonalInfo no update isCache");
            }
            t(feedCloudRead$StGetMainPageCommDataRsp.tianshuMaterialInfos.get());
            n(feedCloudRead$StGetMainPageCommDataRsp);
        }
        m(feedCloudRead$StGetMainPageCommDataRsp.albumInfo.get());
        if (!RFWThreadManager.isMainThread()) {
            o(feedCloudRead$StGetMainPageCommDataRsp);
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo.3
                @Override // java.lang.Runnable
                public void run() {
                    QFSPersonalInfo.this.o(feedCloudRead$StGetMainPageCommDataRsp);
                }
            });
        }
    }

    public void e(a aVar) {
        CopyOnWriteArrayList<a> copyOnWriteArrayList = this.I;
        if (copyOnWriteArrayList == null) {
            this.I = new CopyOnWriteArrayList<>();
        } else if (copyOnWriteArrayList.contains(aVar)) {
            return;
        }
        this.I.add(aVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.f88420g.equals(((QFSPersonalInfo) obj).f88420g);
        }
        return false;
    }

    public long f() {
        return this.f88414a;
    }

    public String g() {
        return this.f88415b;
    }

    public int h() {
        return this.G;
    }

    public String i() {
        return this.f88416c.f398463id.get();
    }

    public b40.d j() {
        return this.H;
    }

    public boolean k() {
        return this.D;
    }

    public void x(long j3) {
        this.f88414a = j3;
    }

    public void y(String str) {
        this.f88415b = str;
    }

    public void z(b40.d dVar) {
        this.H = dVar;
    }

    public QFSPersonalInfo(final FeedCloudMeta$StUser feedCloudMeta$StUser) {
        if (feedCloudMeta$StUser == null) {
            return;
        }
        v(feedCloudMeta$StUser);
        if (!RFWThreadManager.isMainThread()) {
            w(feedCloudMeta$StUser.busiData.get().toByteArray());
        } else {
            RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalInfo.1
                @Override // java.lang.Runnable
                public void run() {
                    QFSPersonalInfo.this.w(feedCloudMeta$StUser.busiData.get().toByteArray());
                    QFSPersonalInfo.this.l();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(FeedCloudRead$StGetMainPageCommDataRsp feedCloudRead$StGetMainPageCommDataRsp) {
    }
}
