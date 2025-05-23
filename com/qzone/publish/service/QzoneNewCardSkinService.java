package com.qzone.publish.service;

import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_MATERIAL.MaterialUserInfo;
import NS_MOBILE_MATERIAL.MaterialUserItem;
import NS_MOBILE_MATERIAL.material_cate_get_req;
import NS_MOBILE_MATERIAL.material_cate_get_rsp;
import NS_MOBILE_MATERIAL.material_get_my_item_req;
import NS_MOBILE_MATERIAL.material_get_my_item_rsp;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Observable;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.personalize.business.FeedSkinData;
import com.qzone.personalize.business.NewCardSkinDataTotal;
import com.qzone.util.al;
import com.tencent.mobileqq.vas.VasLogReporter;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneNewCardSkinService extends Observable implements IQZoneServiceListener {
    private static final al<QzoneNewCardSkinService, Void> E = new a();
    private final b C;
    private final b D;

    /* renamed from: d, reason: collision with root package name */
    private boolean f51292d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f51293e;

    /* renamed from: f, reason: collision with root package name */
    private NewCardSkinDataTotal f51294f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f51295h;

    /* renamed from: i, reason: collision with root package name */
    private FeedSkinData f51296i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f51297m;

    /* compiled from: P */
    /* renamed from: com.qzone.publish.service.QzoneNewCardSkinService$3, reason: invalid class name */
    /* loaded from: classes39.dex */
    class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f51301d;
        final /* synthetic */ QzoneNewCardSkinService this$0;

        @Override // java.lang.Runnable
        public void run() {
            DbCacheManager I = this.this$0.I(this.f51301d);
            if (I == null) {
                return;
            }
            I.r0("uin=?");
            I.t0(new String[]{"" + this.f51301d});
            NewCardSkinDataTotal newCardSkinDataTotal = (NewCardSkinDataTotal) I.k0("uin=?", new String[]{"" + this.f51301d});
            if (newCardSkinDataTotal != null) {
                if (this.f51301d == LoginData.getInstance().getUin()) {
                    this.this$0.f51294f = newCardSkinDataTotal;
                }
                this.this$0.P(this.f51301d, newCardSkinDataTotal, 1);
                return;
            }
            this.this$0.P(this.f51301d, null, 1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<QzoneNewCardSkinService, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QzoneNewCardSkinService a(Void r16) {
            return new QzoneNewCardSkinService();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f51308a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f51309b;

        /* renamed from: c, reason: collision with root package name */
        String f51310c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f51311d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f51312e = new a();

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements a.InterfaceC10828a {
            a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("QzoneNewCardSkinService", 4, "DbCacheManager onClosed QzoneBarrageEffectService table:" + b.this.f51310c);
                }
                b bVar = b.this;
                bVar.f51308a = 0L;
                bVar.f51309b = null;
            }
        }

        public b(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f51310c = str;
            this.f51311d = cls;
        }
    }

    QzoneNewCardSkinService() {
        super("NewCardSkinFollowFeeds");
        this.f51292d = false;
        this.f51293e = false;
        this.f51295h = true;
        this.f51297m = false;
        this.C = new b("TABLE_PERSONAL_NEWCARDSKIN", NewCardSkinDataTotal.class);
        this.D = new b("TABLE_PERSONAL_LOGINCARDSKIN", FeedSkinData.class);
    }

    public static QzoneNewCardSkinService F() {
        return E.get(null);
    }

    private void L(long j3) {
        b bVar = this.C;
        if (bVar.f51308a != j3) {
            synchronized (bVar) {
                b bVar2 = this.C;
                if (bVar2.f51308a != j3) {
                    E(bVar2);
                }
            }
        }
    }

    private void M(long j3) {
        b bVar = this.D;
        if (bVar.f51308a != j3) {
            synchronized (bVar) {
                b bVar2 = this.D;
                if (bVar2.f51308a != j3) {
                    E(bVar2);
                }
            }
        }
    }

    public FeedSkinData G() {
        return this.f51296i;
    }

    public boolean H(long j3, Handler handler) {
        if (NetworkState.isNetSupport()) {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneGetMyItemNewCardSkinRequest(j3), handler, this, 2));
            VasLogReporter.getQzoneFeedsCard().report("get feeds card req send");
            QZLog.i("QzoneNewCardSkinService", "@newcard getMyItemNewCardSkin, send getmyitem");
            return true;
        }
        VasLogReporter.getQzoneFeedsCard().report("get feeds card req NetworkState.isNetSupport() is false");
        QZLog.w("QzoneNewCardSkinService", "@newcard getMyItemNewCardSkin, NetworkState.isNetSupport() is false");
        return false;
    }

    public DbCacheManager I(long j3) {
        L(j3);
        return this.C.f51309b;
    }

    public boolean J(long j3, Handler handler) {
        if (NetworkState.isNetSupport()) {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneGetNewCardSkinListRequest(j3), handler, this, 1));
            QZLog.i("QzoneNewCardSkinService", "@newcard getNewCardSkinList , send getcardlist");
            return true;
        }
        QZLog.w("QzoneNewCardSkinService", "getNewCardSkinList , NetworkState.isNetSupport() is false");
        return false;
    }

    public DbCacheManager K(long j3) {
        M(j3);
        return this.D.f51309b;
    }

    public boolean W(long j3, Handler handler) {
        if (NetworkState.isNetSupport()) {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneSetCardSkinSystemDefaultRequest(j3), handler, this, 3));
            QZLog.i("QzoneNewCardSkinService", "@newcard setNewCardSwitch , send getmyitem");
            return true;
        }
        QZLog.w("QzoneNewCardSkinService", "setBarrageEffectSwitch , NetworkState.isNetSupport() is false");
        return false;
    }

    public void X(boolean z16) {
        this.f51297m = z16;
        O();
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneNewCardSkinService", 2, "QzoneNewCardSkinService\t onTaskResponse() task.mType:" + qZoneTask.mType);
        }
        int i3 = qZoneTask.mType;
        if (i3 == 1) {
            S(qZoneTask);
        } else {
            if (i3 != 2) {
                return;
            }
            R(qZoneTask);
        }
    }

    public void N() {
        this.f51293e = true;
    }

    public void O() {
        this.f51295h = true;
    }

    public void P(long j3, NewCardSkinDataTotal newCardSkinDataTotal, int i3) {
        notify(1, Long.valueOf(j3), newCardSkinDataTotal, Integer.valueOf(i3));
    }

    public void Q(long j3, FeedSkinData feedSkinData) {
        notify(2, Long.valueOf(j3), feedSkinData);
    }

    public void R(QZoneTask qZoneTask) {
        MaterialItem materialItem;
        FeedSkinData fromMatirialInfo;
        QZoneResult result = qZoneTask.getResult(2);
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        material_get_my_item_rsp material_get_my_item_rspVar = (material_get_my_item_rsp) qZoneRequest.rsp;
        material_get_my_item_req material_get_my_item_reqVar = (material_get_my_item_req) qZoneRequest.req;
        if (material_get_my_item_rspVar != null) {
            if (material_get_my_item_rspVar.iCode == 0) {
                MaterialUserInfo materialUserInfo = material_get_my_item_rspVar.stUserItemInfo;
                if (materialUserInfo != null && materialUserInfo.iSwitchState != 0) {
                    MaterialUserItem materialUserItem = materialUserInfo.stCurrentItem;
                    if (materialUserItem == null || (materialItem = materialUserItem.stItem) == null || (fromMatirialInfo = FeedSkinData.fromMatirialInfo(materialItem, material_get_my_item_reqVar.lUin, true)) == null) {
                        return;
                    }
                    Z(material_get_my_item_reqVar.lUin, fromMatirialInfo, 0);
                    VasLogReporter.getQzoneFeedsCard().report("get feeds card rsp id:" + fromMatirialInfo.sSkinId);
                    return;
                }
                Z(material_get_my_item_reqVar.lUin, new FeedSkinData(1), 0);
                VasLogReporter.getQzoneFeedsCard().report("get feeds card response.stUserItemInfo:" + material_get_my_item_rspVar.stUserItemInfo + "state:" + material_get_my_item_rspVar.stUserItemInfo.iSwitchState);
                return;
            }
            return;
        }
        QZLog.e("QzoneNewCardSkinService", "onGetMyItemSkinResponse fail, code = " + result.getReturnCode() + ", msg = " + result.getMessage());
    }

    public void S(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1);
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        material_cate_get_rsp material_cate_get_rspVar = (material_cate_get_rsp) qZoneRequest.rsp;
        material_cate_get_req material_cate_get_reqVar = (material_cate_get_req) qZoneRequest.req;
        if (material_cate_get_rspVar != null) {
            if (material_cate_get_rspVar.iCode == 0) {
                NewCardSkinDataTotal createFromResponse = NewCardSkinDataTotal.createFromResponse(material_cate_get_reqVar.lUin, material_cate_get_rspVar);
                if (createFromResponse != null) {
                    this.f51292d = true;
                    Y(material_cate_get_reqVar.lUin, createFromResponse, 0);
                    return;
                } else {
                    QZLog.e("QzoneNewCardSkinService", "onGetNewCardSkinListResponse fail, QzoneBarrageEffectData.createFromResponse return null");
                    return;
                }
            }
            QZLog.e("QzoneNewCardSkinService", "onGetNewCardSkinListResponse fail, response.iCode = " + material_cate_get_rspVar.iCode);
            return;
        }
        QZLog.e("QzoneNewCardSkinService", "onGetNewCardSkinListResponse fail, code = " + result.getReturnCode() + ", msg = " + result.getMessage());
    }

    public void T(final long j3, boolean z16) {
        if (!z16 && this.f51296i != null && j3 == LoginData.getInstance().getUin()) {
            QZLog.i("@newcard", 1, "loginNewCardPersonaleData skinId:" + this.f51296i.sSkinId);
            Q(j3, this.f51296i);
            return;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.service.QzoneNewCardSkinService.5
            @Override // java.lang.Runnable
            public void run() {
                DbCacheManager K = QzoneNewCardSkinService.this.K(j3);
                if (K == null) {
                    return;
                }
                K.r0("uin=?");
                K.t0(new String[]{"" + j3});
                FeedSkinData feedSkinData = (FeedSkinData) K.k0("uin=?", new String[]{"" + j3});
                if (feedSkinData != null) {
                    QZLog.i("@newcard", 1, "reload DB skinId:" + feedSkinData.sSkinId);
                    if (j3 == LoginData.getInstance().getUin()) {
                        QzoneNewCardSkinService.this.f51296i = feedSkinData;
                    }
                    VasLogReporter.getQzoneFeedsCard().report("get local db feeds card:" + feedSkinData.sSkinId);
                    QzoneNewCardSkinService.this.Q(j3, feedSkinData);
                    return;
                }
                VasLogReporter.getQzoneFeedsCard().report("get local db feeds card:null");
                QZLog.i("@newcard", 1, "reload DB data: null");
                QzoneNewCardSkinService.this.Q(j3, null);
            }
        });
    }

    public void V(final long j3, final Handler handler, FeedSkinData feedSkinData) {
        if (feedSkinData != null && feedSkinData.iNewFeedSkin == 1 && TextUtils.isEmpty(feedSkinData.sPicUrl)) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.service.QzoneNewCardSkinService.6
                @Override // java.lang.Runnable
                public void run() {
                    QzoneNewCardSkinService.this.W(j3, handler);
                }
            });
        }
    }

    public void Y(final long j3, final NewCardSkinDataTotal newCardSkinDataTotal, final int i3) {
        if (i3 == 0) {
            this.f51294f = newCardSkinDataTotal;
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.service.QzoneNewCardSkinService.2
            @Override // java.lang.Runnable
            public void run() {
                DbCacheManager I = QzoneNewCardSkinService.this.I(j3);
                if (I != null) {
                    if (newCardSkinDataTotal == null) {
                        I.b0("uin=?", new String[]{"" + j3});
                    } else {
                        I.r0("uin=?");
                        I.t0(new String[]{"" + j3});
                        NewCardSkinDataTotal newCardSkinDataTotal2 = (NewCardSkinDataTotal) I.k0("uin=?", new String[]{"" + j3});
                        if (newCardSkinDataTotal2 != null && j3 == newCardSkinDataTotal2.uin && i3 == 0 && TextUtils.isEmpty(newCardSkinDataTotal.defaultFont)) {
                            newCardSkinDataTotal.defaultFont = newCardSkinDataTotal2.defaultFont;
                        }
                        I.o0(newCardSkinDataTotal, 2);
                    }
                    QzoneNewCardSkinService.this.P(j3, newCardSkinDataTotal, 0);
                }
            }
        });
    }

    public void Z(final long j3, final FeedSkinData feedSkinData, final int i3) {
        String str;
        if (i3 == 0) {
            this.f51296i = feedSkinData;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("from network loginNewCardPersonaleData id:");
            if (feedSkinData != null) {
                str = feedSkinData.sSkinId;
            } else {
                str = "null";
            }
            sb5.append(str);
            QZLog.i("@newcard", 1, sb5.toString());
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.service.QzoneNewCardSkinService.4
            @Override // java.lang.Runnable
            public void run() {
                DbCacheManager K = QzoneNewCardSkinService.this.K(j3);
                if (K != null) {
                    if (feedSkinData == null) {
                        K.b0("uin=?", new String[]{"" + j3});
                    } else {
                        K.r0("uin=?");
                        K.t0(new String[]{"" + j3});
                        K.o0(feedSkinData, 2);
                        QZLog.i("@newcard", 1, "db cacheManager saved skinId:" + feedSkinData.sSkinId);
                        VasLogReporter.getQzoneFeedsCard().report("db cacheManager saved skinId:" + feedSkinData.sSkinId + " from:" + i3);
                    }
                }
                QzoneNewCardSkinService.this.Q(j3, feedSkinData);
            }
        });
    }

    private void E(b bVar) {
        DbCacheManager dbCacheManager;
        if (bVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != bVar.f51308a || (dbCacheManager = bVar.f51309b) == null || dbCacheManager.isClosed()) {
            bVar.f51308a = uin;
            DbCacheManager e16 = c.g().e(bVar.f51311d, uin, bVar.f51310c);
            bVar.f51309b = e16;
            e16.U(bVar.f51312e);
        }
    }

    public void U(long j3, Handler handler, boolean z16) {
        if (z16) {
            H(j3, handler);
            this.f51295h = false;
        } else if (this.f51295h) {
            H(j3, handler);
            this.f51295h = false;
        }
    }
}
