package com.qzone.business.favorite.service;

import NS_MOBILE_OPERATION.PhotoInformation;
import NS_MOBILE_OPERATION.operation_addfavour_rsp;
import NS_MOBILE_OPERATION.operation_delfavour_rsp;
import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.qzone.business.favorite.protocol.QzoneAddFavorRequest;
import com.qzone.business.favorite.protocol.QzoneDelFavorRequest;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.event.Event;
import com.qzone.common.event.IObserver;
import com.qzone.common.event.Observable;
import com.qzone.util.al;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import common.config.service.QzoneConfig;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import g5.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneFavoriteService extends Observable implements IObserver.background, IQZoneServiceListener {

    /* renamed from: e, reason: collision with root package name */
    private static String f44494e = "QzoneFavoriteService";

    /* renamed from: f, reason: collision with root package name */
    private static final al<QzoneFavoriteService, Void> f44495f = new a();

    /* renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f44496d;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<QzoneFavoriteService, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QzoneFavoriteService a(Void r16) {
            return new QzoneFavoriteService();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z16) {
            super.onChange(z16);
            QzoneFavoriteService.M().H();
            if (QZLog.isColorLevel()) {
                QZLog.d("QzoneFavoriteService", 2, "onchange ");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface d {
        void a(String str, boolean z16);
    }

    QzoneFavoriteService() {
        super("Favor");
        this.f44496d = new ConcurrentHashMap<>();
        D();
    }

    private void D() {
        QfavHelper.c(BaseApplication.getContext(), null);
        g5.a.c(new c(QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).getHandler()));
    }

    private void K(final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        T(str);
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneFavoriteService", 2, "ugcKey=" + str + ",dele");
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.business.favorite.service.QzoneFavoriteService.5
            @Override // java.lang.Runnable
            public void run() {
                g5.a.a(str);
            }
        });
    }

    public static QzoneFavoriteService M() {
        return f44495f.get(null);
    }

    private void U(final boolean z16, final boolean z17) {
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new Runnable() { // from class: com.qzone.business.favorite.service.QzoneFavoriteService.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (z16) {
                        if (z17) {
                            cooperation.qqfav.d.e(null, 41, 9);
                        } else {
                            cooperation.qqfav.d.f(null, 2);
                        }
                    } else if (z17) {
                        cooperation.qqfav.d.e(null, 43, 9);
                    } else {
                        cooperation.qqfav.d.f(null, 1);
                    }
                } catch (Error | Exception unused) {
                }
            }
        });
    }

    private void W(String str, String str2, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z16) {
            this.f44496d.remove(str);
        } else {
            this.f44496d.put(str, str2);
        }
    }

    public void H() {
        ConcurrentHashMap<String, String> concurrentHashMap = this.f44496d;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
    }

    public void L() {
        this.f44496d.clear();
    }

    public void Q(d dVar, String str) {
        if (TextUtils.isEmpty(str)) {
            if (dVar != null) {
                dVar.a(null, false);
                return;
            }
            return;
        }
        String str2 = this.f44496d.get(str);
        if (TextUtils.isEmpty(str2)) {
            S(dVar, str);
        } else if (dVar != null) {
            dVar.a(str2, true);
        }
    }

    public boolean R(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f44496d.get(str))) ? false : true;
    }

    public void S(d dVar, String str) {
        g5.a.b(new b(str, dVar), str);
    }

    public void V(final String str, final String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneFavoriteService", 2, "ugcKey=" + str + ",favorID=" + str2 + ",save");
        }
        G(str, str2);
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).post(new Runnable() { // from class: com.qzone.business.favorite.service.QzoneFavoriteService.4
            @Override // java.lang.Runnable
            public void run() {
                g5.a.d(str, str2);
            }
        });
    }

    @Override // com.qzone.common.event.IObserver.background
    public void onEventBackgroundThread(Event event) {
        if ("Runtime".equals(event.source.getName()) && event.what == 2) {
            L();
        }
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        int i3 = qZoneTask.mType;
        if (i3 == 3585) {
            O(qZoneTask);
        } else {
            if (i3 != 3586) {
                return;
            }
            P(qZoneTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G(String str, String str2) {
        W(str, str2, false);
    }

    private void T(String str) {
        W(str, null, true);
    }

    public void J(long j3, String str, String str2, long j16, long j17, boolean z16, Handler handler) {
        QZoneTask qZoneTask = new QZoneTask(new QzoneDelFavorRequest(j3, str, j16, j17), handler, this, 3586);
        qZoneTask.extraData.put(s4.c.UGCKEY, str2);
        qZoneTask.extraData.put("key.fromOtherProcess", Boolean.valueOf(z16));
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
        U(z16, false);
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneFavoriteService", 2, "ugcKey=" + str2 + ",favorId=" + str + ",appid=" + j16 + ",subid=" + j17 + ",del");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f44502a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f44503b;

        b(String str, d dVar) {
            this.f44502a = str;
            this.f44503b = dVar;
        }

        @Override // g5.a.b
        public void onResult(boolean z16, Bundle bundle) {
            if (z16 && bundle != null) {
                String string = bundle.getString("rsp_fav_id");
                if (!TextUtils.isEmpty(string)) {
                    QzoneFavoriteService.this.G(this.f44502a, string);
                    d dVar = this.f44503b;
                    if (dVar != null) {
                        dVar.a(string, true);
                        return;
                    }
                    return;
                }
            }
            d dVar2 = this.f44503b;
            if (dVar2 != null) {
                dVar2.a(null, false);
            }
        }
    }

    private boolean N(QZoneTask qZoneTask) {
        HashMap<Object, Object> hashMap;
        if (qZoneTask == null || (hashMap = qZoneTask.extraData) == null) {
            return false;
        }
        Boolean bool = hashMap.get("key.fromOtherProcess") instanceof Boolean ? (Boolean) qZoneTask.extraData.get("key.fromOtherProcess") : null;
        return bool != null && bool.booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void O(QZoneTask qZoneTask) {
        String str;
        String str2;
        boolean z16;
        if (qZoneTask == null) {
            return;
        }
        if (qZoneTask.succeeded()) {
            JceStruct jceStruct = qZoneTask.mRequest.rsp;
            operation_addfavour_rsp operation_addfavour_rspVar = jceStruct instanceof operation_addfavour_rsp ? (operation_addfavour_rsp) jceStruct : null;
            if (operation_addfavour_rspVar != null) {
                if (operation_addfavour_rspVar.ret == 0 && (qZoneTask.extraData.get(s4.c.UGCKEY) instanceof String)) {
                    V((String) qZoneTask.extraData.get(s4.c.UGCKEY), operation_addfavour_rspVar.strFavID);
                    str2 = "";
                    z16 = true;
                } else {
                    String str3 = operation_addfavour_rspVar.f25010msg;
                    QZLog.w(QZLog.TO_DEVICE_TAG, f44494e + "_add favor ugc rsp failed! code=" + operation_addfavour_rspVar.ret + " msg=" + operation_addfavour_rspVar.f25010msg);
                    str2 = str3;
                    z16 = false;
                }
                qZoneTask.mResultCode = operation_addfavour_rspVar.ret;
                qZoneTask.f45835msg = operation_addfavour_rspVar.f25010msg;
                if (N(qZoneTask)) {
                    notify(1, qZoneTask.extraData.get(s4.c.UGCKEY), Boolean.valueOf(z16), str2);
                    return;
                }
                QZoneResult result = qZoneTask.getResult(1000028);
                result.setData(qZoneTask.extraData.get(s4.c.UGCKEY));
                qZoneTask.sendResultMsg(result);
                return;
            }
            str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NotResponse", "\u54cd\u5e94\u4e3a\u7a7a");
            QZLog.w(QZLog.TO_DEVICE_TAG, f44494e + "_add favor ugc rsp failed!rsp is null");
        } else {
            str = qZoneTask.f45835msg;
            QZLog.w(QZLog.TO_DEVICE_TAG, f44494e + "_add favor ugc failed!code=" + qZoneTask.mResultCode + ",msg=" + qZoneTask.f45835msg);
        }
        str2 = str;
        z16 = false;
        if (N(qZoneTask)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void P(QZoneTask qZoneTask) {
        String str;
        String str2;
        boolean z16;
        if (qZoneTask == null) {
            return;
        }
        if (qZoneTask.succeeded()) {
            JceStruct jceStruct = qZoneTask.mRequest.rsp;
            operation_delfavour_rsp operation_delfavour_rspVar = jceStruct instanceof operation_delfavour_rsp ? (operation_delfavour_rsp) jceStruct : null;
            if (operation_delfavour_rspVar != null) {
                if (operation_delfavour_rspVar.ret == 0 && (qZoneTask.extraData.get(s4.c.UGCKEY) instanceof String)) {
                    K((String) qZoneTask.extraData.get(s4.c.UGCKEY));
                    str2 = "";
                    z16 = true;
                } else {
                    String str3 = operation_delfavour_rspVar.error_msg;
                    QZLog.w(QZLog.TO_DEVICE_TAG, f44494e + "_del favor ugc rsp failed! code=" + operation_delfavour_rspVar.ret + " msg=" + operation_delfavour_rspVar.error_msg);
                    str2 = str3;
                    z16 = false;
                }
                qZoneTask.mResultCode = operation_delfavour_rspVar.ret;
                qZoneTask.f45835msg = operation_delfavour_rspVar.error_msg;
                if (N(qZoneTask)) {
                    notify(2, qZoneTask.extraData.get(s4.c.UGCKEY), Boolean.valueOf(z16), str2);
                    return;
                }
                QZoneResult result = qZoneTask.getResult(1000029);
                result.setData(qZoneTask.extraData.get(s4.c.UGCKEY));
                qZoneTask.sendResultMsg(result);
                return;
            }
            str = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NotResponse", "\u54cd\u5e94\u4e3a\u7a7a");
            QZLog.w(QZLog.TO_DEVICE_TAG, f44494e + "_del favor ugc rsp failed!rsp is null");
        } else {
            str = qZoneTask.f45835msg;
            QZLog.w(QZLog.TO_DEVICE_TAG, f44494e + "_del favor ugc failed!code=" + qZoneTask.mResultCode + ",msg=" + qZoneTask.f45835msg);
        }
        str2 = str;
        z16 = false;
        if (N(qZoneTask)) {
        }
    }

    public void F(long j3, long j16, long j17, String str, String str2, String str3, HashMap<String, String> hashMap, ArrayList<PhotoInformation> arrayList, boolean z16, Handler handler) {
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneFavoriteService", 2, "ugcKey=" + str3 + ",add,owenwe_uin=" + j3 + ",login uin=" + LoginData.getInstance().getUin() + ",appid=" + j16 + ",subid=" + j17 + ",cellid=" + str + ",sid=" + str2);
        }
        QZoneTask qZoneTask = new QZoneTask(new QzoneAddFavorRequest(j3, j16, j17, str, str2, str3, arrayList, "", hashMap), handler, this, 3585);
        qZoneTask.extraData.put(s4.c.UGCKEY, str3);
        qZoneTask.extraData.put("key.fromOtherProcess", Boolean.valueOf(z16));
        U(z16, true);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    public void I(long j3, String str, String str2, long j16, long j17, Handler handler) {
        J(j3, str, str2, j16, j17, false, handler);
    }

    public void E(long j3, long j16, long j17, String str, String str2, String str3, HashMap<String, String> hashMap, ArrayList<PhotoInformation> arrayList, Handler handler) {
        F(j3, j16, j17, str, str2, str3, hashMap, arrayList, false, handler);
    }
}
