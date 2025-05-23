package com.qzone.publish.service;

import NS_MOBILE_MATERIAL.material_cate_get_req;
import NS_MOBILE_MATERIAL.material_cate_get_rsp;
import NS_MOBILE_MATERIAL.material_set_switch_rsp;
import android.os.Handler;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Observable;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.util.al;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import n7.a;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneBarrageEffectService extends Observable implements IQZoneServiceListener {

    /* renamed from: h, reason: collision with root package name */
    private static final al<QzoneBarrageEffectService, Void> f51278h = new a();

    /* renamed from: d, reason: collision with root package name */
    private QzoneBarrageEffectData f51279d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f51280e;

    /* renamed from: f, reason: collision with root package name */
    private final b f51281f;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<QzoneBarrageEffectService, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QzoneBarrageEffectService a(Void r16) {
            return new QzoneBarrageEffectService();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f51286a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f51287b;

        /* renamed from: c, reason: collision with root package name */
        String f51288c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f51289d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f51290e = new a();

        /* compiled from: P */
        /* loaded from: classes39.dex */
        class a implements a.InterfaceC10828a {
            a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("QzoneBarrageEffectService", 4, "DbCacheManager onClosed QzoneBarrageEffectService table:" + b.this.f51288c);
                }
                b bVar = b.this;
                bVar.f51286a = 0L;
                bVar.f51287b = null;
            }
        }

        public b(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f51288c = str;
            this.f51289d = cls;
        }
    }

    QzoneBarrageEffectService() {
        super("BarrageEffect");
        this.f51280e = false;
        this.f51281f = new b("TABLE_BARRAGE_EFFECT_FONT", QzoneBarrageEffectData.class);
    }

    public static QzoneBarrageEffectService G() {
        return f51278h.get(null);
    }

    private void I(long j3) {
        b bVar = this.f51281f;
        if (bVar.f51286a != j3) {
            synchronized (bVar) {
                b bVar2 = this.f51281f;
                if (bVar2.f51286a != j3) {
                    D(bVar2);
                }
            }
        }
    }

    public DbCacheManager E(long j3) {
        I(j3);
        return this.f51281f.f51287b;
    }

    public boolean F(long j3, Handler handler) {
        if (NetworkState.isNetSupport()) {
            QzoneGetBarrageEffectListRequest qzoneGetBarrageEffectListRequest = new QzoneGetBarrageEffectListRequest(j3);
            material_cate_get_req material_cate_get_reqVar = (material_cate_get_req) qzoneGetBarrageEffectListRequest.req;
            if (material_cate_get_reqVar != null) {
                material_cate_get_reqVar.strAttachInfo = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZ_CUSTOM_FONT, QzoneConfig.SECONDARY_SUPER_FONT_LIST_ATTACH_INFO, "start=0&num=500");
            }
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(qzoneGetBarrageEffectListRequest, handler, this, 1));
            return true;
        }
        QZLog.w("QzoneBarrageEffectService", "getBarrageEffectList , NetworkState.isNetSupport() is false");
        return false;
    }

    public boolean H() {
        return this.f51280e;
    }

    public boolean O(long j3, Handler handler) {
        if (NetworkState.isNetSupport()) {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneSetBarrageEffectSwitchRequest(j3), handler, this, 2));
            return true;
        }
        QZLog.w("QzoneBarrageEffectService", "setBarrageEffectSwitch , NetworkState.isNetSupport() is false");
        return false;
    }

    public void P(final long j3, final QzoneBarrageEffectData qzoneBarrageEffectData, final int i3) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.service.QzoneBarrageEffectService.2
            @Override // java.lang.Runnable
            public void run() {
                DbCacheManager E = QzoneBarrageEffectService.this.E(j3);
                if (E != null) {
                    if (qzoneBarrageEffectData == null) {
                        E.b0("uin=?", new String[]{"" + j3});
                    } else {
                        E.r0("uin=?");
                        E.t0(new String[]{"" + j3});
                        QzoneBarrageEffectData qzoneBarrageEffectData2 = (QzoneBarrageEffectData) E.k0("uin=?", new String[]{"" + j3});
                        if (qzoneBarrageEffectData2 != null && j3 == qzoneBarrageEffectData2.uin && i3 == 0) {
                            QzoneBarrageEffectData qzoneBarrageEffectData3 = qzoneBarrageEffectData;
                            if (qzoneBarrageEffectData3.defaultFont < 0) {
                                qzoneBarrageEffectData3.defaultFont = qzoneBarrageEffectData2.defaultFont;
                            }
                        }
                        E.o0(qzoneBarrageEffectData, 2);
                    }
                }
                if (j3 == LoginData.getInstance().getUin()) {
                    QzoneBarrageEffectService.this.f51279d = qzoneBarrageEffectData;
                }
            }
        });
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneBarrageEffectService", 2, "QzoneBarrageEffectService\t onTaskResponse() task.mType:" + qZoneTask.mType);
        }
        int i3 = qZoneTask.mType;
        if (i3 == 1) {
            K(qZoneTask);
        } else {
            if (i3 != 2) {
                return;
            }
            L(qZoneTask);
        }
    }

    private void K(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1);
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        material_cate_get_rsp material_cate_get_rspVar = (material_cate_get_rsp) qZoneRequest.rsp;
        material_cate_get_req material_cate_get_reqVar = (material_cate_get_req) qZoneRequest.req;
        if (material_cate_get_rspVar != null) {
            if (material_cate_get_rspVar.iCode == 0) {
                QzoneBarrageEffectData createFromResponse = QzoneBarrageEffectData.createFromResponse(material_cate_get_reqVar.lUin, material_cate_get_rspVar);
                if (createFromResponse != null) {
                    this.f51280e = true;
                    P(material_cate_get_reqVar.lUin, createFromResponse, 0);
                    J(material_cate_get_reqVar.lUin, createFromResponse, 0);
                    return;
                }
                QZLog.e("QzoneBarrageEffectService", "onGetBarrageEffectListResponse fail, QzoneBarrageEffectData.createFromResponse return null");
                return;
            }
            QZLog.e("QzoneBarrageEffectService", "onGetBarrageEffectListResponse fail, response.iCode = " + material_cate_get_rspVar.iCode);
            return;
        }
        QZLog.e("QzoneBarrageEffectService", "onGetBarrageEffectListResponse fail, code = " + result.getReturnCode() + ", msg = " + result.getMessage());
    }

    private void L(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(2);
        material_set_switch_rsp material_set_switch_rspVar = (material_set_switch_rsp) qZoneTask.mRequest.rsp;
        if (material_set_switch_rspVar != null) {
            if (material_set_switch_rspVar.iCode != 0) {
                QZLog.e("QzoneBarrageEffectService", "onSetBarrageEffectSwitchResponse fail, response.iCode = " + material_set_switch_rspVar.iCode + ", response.errMsg = " + material_set_switch_rspVar.strErrMsg);
                return;
            }
            return;
        }
        QZLog.e("QzoneBarrageEffectService", "onGetBarrageEffectListResponse fail, code = " + result.getReturnCode() + ", msg = " + result.getMessage());
    }

    public void J(long j3, QzoneBarrageEffectData qzoneBarrageEffectData, int i3) {
        notify(1, Long.valueOf(j3), qzoneBarrageEffectData, Integer.valueOf(i3));
    }

    public void M(long j3) {
        N(j3, false);
    }

    public void N(final long j3, boolean z16) {
        if (!z16 && this.f51279d != null && j3 == LoginData.getInstance().getUin()) {
            J(j3, this.f51279d, 1);
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.service.QzoneBarrageEffectService.3
                @Override // java.lang.Runnable
                public void run() {
                    DbCacheManager E = QzoneBarrageEffectService.this.E(j3);
                    if (E == null) {
                        return;
                    }
                    E.r0("uin=?");
                    E.t0(new String[]{"" + j3});
                    QzoneBarrageEffectData qzoneBarrageEffectData = (QzoneBarrageEffectData) E.k0("uin=?", new String[]{"" + j3});
                    if (qzoneBarrageEffectData != null) {
                        if (j3 == LoginData.getInstance().getUin()) {
                            QzoneBarrageEffectService.this.f51279d = qzoneBarrageEffectData;
                        }
                        QzoneBarrageEffectService.this.J(j3, qzoneBarrageEffectData, 1);
                        return;
                    }
                    QzoneBarrageEffectService.this.J(j3, null, 1);
                }
            });
        }
    }

    private void D(b bVar) {
        DbCacheManager dbCacheManager;
        if (bVar == null) {
            return;
        }
        long uin = LoginData.getInstance().getUin();
        if (uin != bVar.f51286a || (dbCacheManager = bVar.f51287b) == null || dbCacheManager.isClosed()) {
            bVar.f51286a = uin;
            DbCacheManager e16 = c.g().e(bVar.f51289d, uin, bVar.f51288c);
            bVar.f51287b = e16;
            e16.U(bVar.f51290e);
        }
    }
}
