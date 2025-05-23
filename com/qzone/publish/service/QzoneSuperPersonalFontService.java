package com.qzone.publish.service;

import NS_MOBILE_MATERIAL.material_cate_get_req;
import NS_MOBILE_MATERIAL.material_cate_get_rsp;
import NS_MOBILE_MATERIAL.material_set_switch_rsp;
import android.os.Handler;
import com.qzone.album.protocol.QzoneGetSuperFontListRequest;
import com.qzone.album.protocol.QzoneSetSuperFontSwitchRequest;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Observable;
import com.qzone.common.protocol.request.QZoneRequest;
import com.qzone.component.cache.database.DbCacheManager;
import com.qzone.component.cache.database.c;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.qzone.util.al;
import common.config.service.QzoneConfig;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import n7.a;

/* loaded from: classes39.dex */
public class QzoneSuperPersonalFontService extends Observable implements IQZoneServiceListener {

    /* renamed from: f, reason: collision with root package name */
    private static final al<QzoneSuperPersonalFontService, Void> f51314f = new a();

    /* renamed from: d, reason: collision with root package name */
    private QzoneSuperPersonalFontData f51315d;

    /* renamed from: e, reason: collision with root package name */
    private final b f51316e;

    /* loaded from: classes39.dex */
    class a extends al<QzoneSuperPersonalFontService, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QzoneSuperPersonalFontService a(Void r16) {
            return new QzoneSuperPersonalFontService();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        long f51321a;

        /* renamed from: b, reason: collision with root package name */
        DbCacheManager f51322b;

        /* renamed from: c, reason: collision with root package name */
        String f51323c;

        /* renamed from: d, reason: collision with root package name */
        Class<? extends com.qzone.component.cache.database.a> f51324d;

        /* renamed from: e, reason: collision with root package name */
        a.InterfaceC10828a f51325e = new a();

        /* loaded from: classes39.dex */
        class a implements a.InterfaceC10828a {
            a() {
            }

            @Override // n7.a.InterfaceC10828a
            public void onClosed(n7.a aVar) {
                if (QZLog.isDevelopLevel()) {
                    QZLog.d("QzoneSuperPersonalFontService", 4, "DbCacheManager onClosed QzoneSuperPersonalFontService table:" + b.this.f51323c);
                }
                b bVar = b.this;
                bVar.f51321a = 0L;
                bVar.f51322b = null;
            }
        }

        public b(String str, Class<? extends com.qzone.component.cache.database.a> cls) {
            this.f51323c = str;
            this.f51324d = cls;
        }
    }

    QzoneSuperPersonalFontService() {
        super("PersonalFont");
        this.f51316e = new b("TABLE_SUPER_PERSONAL_FONT", QzoneSuperPersonalFontData.class);
    }

    public static QzoneSuperPersonalFontService F() {
        return f51314f.get(null);
    }

    private void H(long j3) {
        b bVar = this.f51316e;
        if (bVar.f51321a != j3) {
            synchronized (bVar) {
                b bVar2 = this.f51316e;
                if (bVar2.f51321a != j3) {
                    D(bVar2);
                }
            }
        }
    }

    public boolean E(long j3, Handler handler) {
        if (NetworkState.isNetSupport()) {
            QzoneGetSuperFontListRequest qzoneGetSuperFontListRequest = new QzoneGetSuperFontListRequest(j3);
            material_cate_get_req material_cate_get_reqVar = (material_cate_get_req) qzoneGetSuperFontListRequest.req;
            if (material_cate_get_reqVar != null) {
                material_cate_get_reqVar.strAttachInfo = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QZ_CUSTOM_FONT, QzoneConfig.SECONDARY_SUPER_FONT_LIST_ATTACH_INFO, "start=0&num=500");
            }
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(qzoneGetSuperFontListRequest, handler, this, 1));
            return true;
        }
        QZLog.w("QzoneSuperPersonalFontService", "getBarrageEffectList , NetworkState.isNetSupport() is false");
        return false;
    }

    public DbCacheManager G(long j3) {
        H(j3);
        return this.f51316e.f51322b;
    }

    public boolean N(long j3, Handler handler) {
        if (NetworkState.isNetSupport()) {
            QZoneBusinessLooper.getInstance().runTask(new QZoneTask(new QzoneSetSuperFontSwitchRequest(j3), handler, this, 2));
            return true;
        }
        QZLog.w("QzoneSuperPersonalFontService", "setBarrageEffectSwitch , NetworkState.isNetSupport() is false");
        return false;
    }

    public void O(final long j3, final QzoneSuperPersonalFontData qzoneSuperPersonalFontData, final int i3) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.service.QzoneSuperPersonalFontService.2
            @Override // java.lang.Runnable
            public void run() {
                DbCacheManager G = QzoneSuperPersonalFontService.this.G(j3);
                if (G != null) {
                    if (qzoneSuperPersonalFontData == null) {
                        G.b0("uin=?", new String[]{"" + j3});
                    } else {
                        G.r0("uin=?");
                        G.t0(new String[]{"" + j3});
                        QzoneSuperPersonalFontData qzoneSuperPersonalFontData2 = (QzoneSuperPersonalFontData) G.k0("uin=?", new String[]{"" + j3});
                        if (qzoneSuperPersonalFontData2 != null && j3 == qzoneSuperPersonalFontData2.uin && i3 == 0) {
                            QzoneSuperPersonalFontData qzoneSuperPersonalFontData3 = qzoneSuperPersonalFontData;
                            if (qzoneSuperPersonalFontData3.defaultFont < 0) {
                                qzoneSuperPersonalFontData3.defaultFont = qzoneSuperPersonalFontData2.defaultFont;
                            }
                        }
                        G.o0(qzoneSuperPersonalFontData, 2);
                    }
                }
                if (j3 == LoginData.getInstance().getUin()) {
                    QzoneSuperPersonalFontService.this.f51315d = qzoneSuperPersonalFontData;
                }
            }
        });
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneSuperPersonalFontService", 2, "QzoneSuperPersonalFontService\t onTaskResponse() task.mType:" + qZoneTask.mType);
        }
        int i3 = qZoneTask.mType;
        if (i3 == 1) {
            J(qZoneTask);
        } else {
            if (i3 != 2) {
                return;
            }
            K(qZoneTask);
        }
    }

    private void J(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(1);
        QZoneRequest qZoneRequest = qZoneTask.mRequest;
        material_cate_get_rsp material_cate_get_rspVar = (material_cate_get_rsp) qZoneRequest.rsp;
        material_cate_get_req material_cate_get_reqVar = (material_cate_get_req) qZoneRequest.req;
        if (material_cate_get_rspVar != null) {
            if (material_cate_get_rspVar.iCode == 0) {
                QzoneSuperPersonalFontData createFromResponse = QzoneSuperPersonalFontData.createFromResponse(material_cate_get_reqVar.lUin, material_cate_get_rspVar);
                if (createFromResponse != null) {
                    O(material_cate_get_reqVar.lUin, createFromResponse, 0);
                    I(material_cate_get_reqVar.lUin, createFromResponse, 0);
                    return;
                } else {
                    QZLog.e("QzoneSuperPersonalFontService", "onGetFontListResponse fail, QzoneSuperPersonalFontData.createFromResponse return null");
                    return;
                }
            }
            QZLog.e("QzoneSuperPersonalFontService", "onGetFontListResponse fail, response.iCode = " + material_cate_get_rspVar.iCode);
            return;
        }
        QZLog.e("QzoneSuperPersonalFontService", "onGetFontListResponse fail, code = " + result.getReturnCode() + ", msg = " + result.getMessage());
    }

    private void K(QZoneTask qZoneTask) {
        QZoneResult result = qZoneTask.getResult(2);
        material_set_switch_rsp material_set_switch_rspVar = (material_set_switch_rsp) qZoneTask.mRequest.rsp;
        if (material_set_switch_rspVar != null) {
            if (material_set_switch_rspVar.iCode != 0) {
                QZLog.e("QzoneSuperPersonalFontService", "onSetFontSwitchResponse fail, response.iCode = " + material_set_switch_rspVar.iCode + ", response.errMsg = " + material_set_switch_rspVar.strErrMsg);
                return;
            }
            return;
        }
        QZLog.e("QzoneSuperPersonalFontService", "onGetFontListResponse fail, code = " + result.getReturnCode() + ", msg = " + result.getMessage());
    }

    public void I(long j3, QzoneSuperPersonalFontData qzoneSuperPersonalFontData, int i3) {
        notify(2, Long.valueOf(j3), qzoneSuperPersonalFontData, Integer.valueOf(i3));
    }

    public void L(long j3) {
        M(j3, false);
    }

    public void M(final long j3, boolean z16) {
        if (!z16 && this.f51315d != null && j3 == LoginData.getInstance().getUin()) {
            I(j3, this.f51315d, 1);
        } else {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.publish.service.QzoneSuperPersonalFontService.3
                @Override // java.lang.Runnable
                public void run() {
                    DbCacheManager G = QzoneSuperPersonalFontService.this.G(j3);
                    if (G == null) {
                        return;
                    }
                    G.r0("uin=?");
                    G.t0(new String[]{"" + j3});
                    QzoneSuperPersonalFontData qzoneSuperPersonalFontData = (QzoneSuperPersonalFontData) G.k0("uin=?", new String[]{"" + j3});
                    if (qzoneSuperPersonalFontData != null) {
                        if (j3 == LoginData.getInstance().getUin()) {
                            QzoneSuperPersonalFontService.this.f51315d = qzoneSuperPersonalFontData;
                        }
                        QzoneSuperPersonalFontService.this.I(j3, qzoneSuperPersonalFontData, 1);
                        return;
                    }
                    QzoneSuperPersonalFontService.this.I(j3, null, 1);
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
        if (uin != bVar.f51321a || (dbCacheManager = bVar.f51322b) == null || dbCacheManager.isClosed()) {
            bVar.f51321a = uin;
            DbCacheManager e16 = c.g().e(bVar.f51324d, uin, bVar.f51323c);
            bVar.f51322b = e16;
            e16.U(bVar.f51325e);
        }
    }
}
