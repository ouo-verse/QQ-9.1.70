package com.tencent.mobileqq.vas.updatesystem.api.impl;

import androidx.annotation.WorkerThread;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.photo.MediaDBValues;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.updatesystem.data.VasUpdateData;
import com.tencent.mobileqq.vas.updatesystem.impl.e;
import com.tencent.mobileqq.vas.updatesystem.service.VasUpdateObserver;
import com.tencent.mobileqq.vas.utils.VasCommonUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.List;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private r33.b f311163a;

    /* renamed from: b, reason: collision with root package name */
    private e f311164b;

    /* renamed from: c, reason: collision with root package name */
    private VasUpdateObserver f311165c = new a();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    private class a implements VasUpdateObserver {
        a() {
        }

        protected void a(boolean z16, Object obj) {
            if (z16) {
                VasUpdateData.GetUrlRsp getUrlRsp = (VasUpdateData.GetUrlRsp) obj;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("cookie", getUrlRsp.cookie);
                    JSONArray jSONArray = new JSONArray();
                    for (int i3 = 0; i3 < getUrlRsp.updateList.size(); i3++) {
                        VasUpdateData.UpdateInfo updateInfo = getUrlRsp.updateList.get(i3);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("bid", updateInfo.bid);
                        jSONObject2.put("scid", updateInfo.scid);
                        jSONObject2.put("dst_version", updateInfo.dstVersion);
                        jSONObject2.put("src_version", updateInfo.srcVersion);
                        jSONObject2.put("delta_mode", updateInfo.deltaMode);
                        jSONObject2.put("storage_mode", updateInfo.storageMode);
                        jSONObject2.put("compress_mode", updateInfo.compressMode);
                        jSONObject2.put("url", updateInfo.url);
                        jSONObject2.put(MediaDBValues.FILESIZE, updateInfo.filesize);
                        jSONObject2.put("filecontent", updateInfo.filecontent);
                        jSONObject2.put("code", updateInfo.code);
                        jSONObject2.put("appVersion", updateInfo.appVersion);
                        jSONArray.mo162put(jSONObject2);
                    }
                    jSONObject.put("update_list", jSONArray);
                    if (QLog.isColorLevel()) {
                        QLog.d("VasUpdateService", 2, "onQuickUpdateGetUrl data = " + jSONObject.toString());
                    }
                    if (b.this.f311163a != null) {
                        b.this.i(0, "GetUrlRsp", jSONObject.toString());
                        return;
                    }
                    return;
                } catch (Exception e16) {
                    QLog.e("VasUpdateService", 1, "onQuickUpdateGetUrl error: ", e16);
                    if (b.this.f311163a != null) {
                        b.this.i((int) getUrlRsp.ret, "GetUrlRsp", "{\"cookie\":" + getUrlRsp.cookie + "}");
                        return;
                    }
                    return;
                }
            }
            VasUpdateData.QuickUpdateRsp quickUpdateRsp = (VasUpdateData.QuickUpdateRsp) obj;
            QLog.e("VasUpdateService", 1, "onQuickUpdateGetUrl result = " + quickUpdateRsp.ret + " cookie = " + quickUpdateRsp.cookie);
            if (b.this.f311163a != null) {
                b.this.i((int) quickUpdateRsp.ret, "GetUrlRsp", "{\"cookie\":" + quickUpdateRsp.cookie + "}");
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0197  */
        /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void b(boolean z16, Object obj) {
            String str;
            String str2;
            VasUpdateData.SyncVCRRsp syncVCRRsp;
            VasUpdateData.SyncVCRRsp syncVCRRsp2;
            JSONObject jSONObject;
            String str3 = "}";
            String str4 = "{\"cookie\":";
            if (z16) {
                VasUpdateData.SyncVCRRsp syncVCRRsp3 = (VasUpdateData.SyncVCRRsp) obj;
                JSONObject jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("cookie", syncVCRRsp3.cookie);
                    jSONObject2.put("seq", syncVCRRsp3.seq);
                    jSONObject2.put("polltime", syncVCRRsp3.polltime);
                    jSONObject2.put("continueFlag", syncVCRRsp3.continueFlag);
                    jSONObject2.put("syncSwitch", syncVCRRsp3.syncSwitch);
                    jSONObject2.put("environment", syncVCRRsp3.environment);
                    JSONArray jSONArray = new JSONArray();
                    int i3 = 0;
                    while (i3 < syncVCRRsp3.vcrList.size()) {
                        VasUpdateData.VCR vcr = syncVCRRsp3.vcrList.get(i3);
                        JSONObject jSONObject3 = new JSONObject();
                        syncVCRRsp2 = syncVCRRsp3;
                        try {
                            jSONObject3.put("bid", vcr.bid);
                            jSONObject3.put("scid", vcr.scid);
                            jSONObject3.put("optype", vcr.optype);
                            jSONObject3.put("version", vcr.version);
                            jSONObject3.put("appVersion", vcr.appVersion);
                            jSONArray.mo162put(jSONObject3);
                            i3++;
                            syncVCRRsp3 = syncVCRRsp2;
                        } catch (Exception e16) {
                            e = e16;
                            syncVCRRsp = syncVCRRsp2;
                            str = str3;
                            str2 = str4;
                            QLog.e("VasUpdateService", 1, "onQuickUpdateSync error: ", e);
                            if (b.this.f311163a != null) {
                                b.this.i(-1, "SyncVCRRsp", str2 + syncVCRRsp.cookie + str);
                                return;
                            }
                            return;
                        }
                    }
                    syncVCRRsp2 = syncVCRRsp3;
                    jSONObject2.put("vcr_list", jSONArray);
                    jSONObject = new JSONObject();
                    syncVCRRsp = syncVCRRsp2;
                } catch (Exception e17) {
                    e = e17;
                    str = "}";
                    str2 = "{\"cookie\":";
                    syncVCRRsp = syncVCRRsp3;
                }
                try {
                    jSONObject.put("plver", syncVCRRsp.preload.ver);
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i16 = 0; i16 < syncVCRRsp.preload.itemList.size(); i16++) {
                        VasUpdateData.ItemVersion itemVersion = syncVCRRsp.preload.itemList.get(i16);
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("bid", itemVersion.bid);
                        jSONObject4.put("scid", itemVersion.scid);
                        jSONObject4.put("flag", itemVersion.flag);
                        jSONArray2.mo162put(jSONObject4);
                    }
                    jSONObject.put("item_list", jSONArray2);
                    jSONObject2.put("preload", jSONObject);
                    JSONObject jSONObject5 = new JSONObject();
                    jSONObject5.put("rpver", syncVCRRsp.report.ver);
                    JSONArray jSONArray3 = new JSONArray();
                    int i17 = 0;
                    while (i17 < syncVCRRsp.report.itemList.size()) {
                        VasUpdateData.ItemVersion itemVersion2 = syncVCRRsp.report.itemList.get(i17);
                        JSONObject jSONObject6 = new JSONObject();
                        str = str3;
                        str2 = str4;
                        try {
                            jSONObject6.put("bid", itemVersion2.bid);
                            jSONObject6.put("scid", itemVersion2.scid);
                            jSONArray3.mo162put(jSONObject6);
                            i17++;
                            str3 = str;
                            str4 = str2;
                        } catch (Exception e18) {
                            e = e18;
                            QLog.e("VasUpdateService", 1, "onQuickUpdateSync error: ", e);
                            if (b.this.f311163a != null) {
                            }
                        }
                    }
                    str = str3;
                    str2 = str4;
                    jSONObject5.put("item_list", jSONArray3);
                    jSONObject2.put("report", jSONObject5);
                    if (QLog.isColorLevel()) {
                        QLog.d("VasUpdateService", 2, "onQuickUpdateSync data = " + jSONObject2.toString());
                    }
                    if (b.this.f311163a != null) {
                        b.this.i(0, "SyncVCRRsp", jSONObject2.toString());
                    }
                } catch (Exception e19) {
                    e = e19;
                    str = str3;
                    str2 = str4;
                    QLog.e("VasUpdateService", 1, "onQuickUpdateSync error: ", e);
                    if (b.this.f311163a != null) {
                    }
                }
            } else {
                VasUpdateData.QuickUpdateRsp quickUpdateRsp = (VasUpdateData.QuickUpdateRsp) obj;
                QLog.e("VasUpdateService", 1, "onQuickUpdateSync result = " + quickUpdateRsp.ret + " cookie = " + quickUpdateRsp.cookie);
                if (b.this.f311163a != null) {
                    b.this.i((int) quickUpdateRsp.ret, "SyncVCRRsp", "{\"cookie\":" + quickUpdateRsp.cookie + "}");
                }
            }
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (i3 == 16) {
                b(z16, obj);
            } else if (i3 == 17) {
                a(z16, obj);
            }
        }
    }

    public b() {
        h();
        g();
    }

    private void g() {
        QLog.i("VasUpdateService", 1, "initEngine: " + this);
        this.f311163a = r33.b.l();
        this.f311164b = (e) VasUpdateWrapper.getCmdManager();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.vas.updatesystem.api.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                b.this.j();
            }
        }, 16, null, true);
    }

    private void h() {
        BaseQQAppInterface baseQQAppInterface;
        if (VasCommonUtils.INSTANCE.isMainProcess() && (baseQQAppInterface = (BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime()) != null && !baseQQAppInterface.containObserver(this.f311165c, true)) {
            baseQQAppInterface.addObserver(this.f311165c, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(int i3, @NotNull String str, @NotNull String str2) {
        e eVar = this.f311164b;
        if (eVar != null && eVar.b() != null) {
            this.f311164b.b().onPbResponse(i3, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @WorkerThread
    public void j() {
        r33.b bVar = this.f311163a;
        if (bVar != null) {
            bVar.i();
        }
    }

    public List<IBusinessCallback> d() {
        return this.f311163a.c();
    }

    public <T extends IBusinessCallback> T e(Class<T> cls) {
        if (cls == null) {
            return null;
        }
        h();
        r33.b bVar = this.f311163a;
        if (bVar == null) {
            return null;
        }
        try {
            return (BaseUpdateBusiness) bVar.e(cls);
        } catch (NullPointerException e16) {
            QLog.e("VasUpdateService", 1, "getBusinessCallback: " + e16);
            return null;
        }
    }

    public <T extends IBusinessCallback> T f(Long l3) {
        if (this.f311163a == null) {
            return null;
        }
        h();
        try {
            return this.f311163a.d(l3.longValue());
        } catch (Exception e16) {
            QLog.e("VasUpdateService", 1, "getBusinessCallback: " + e16);
            return null;
        }
    }
}
