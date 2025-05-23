package com.tencent.mobileqq.icgame.api.impl.pendant;

import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.IQQLiveSDK;
import com.tencent.mobileqq.icgame.api.impl.IQQLiveBaseModule;
import com.tencent.mobileqq.icgame.api.pendant.IQQLiveModulePendant;
import com.tencent.mobileqq.icgame.data.pendant.PendantViewData;
import com.tencent.mobileqq.icgame.data.pendant.WebPendantData;
import com.tencent.mobileqq.icgame.sso.c;
import com.tencent.mobileqq.icgame.sso.h;
import com.tencent.mobileqq.icgame.sso.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cp4.e;
import cp4.f;
import cp4.g;
import cp4.j;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import z22.a;

/* loaded from: classes15.dex */
public class QQLiveModulePendant extends IQQLiveBaseModule implements IQQLiveModulePendant {
    public static final int MILL_SECOND = 1000;
    private static final int MIN_SECOND = 60;
    private static final String PULL_VIEW_INFO_METHOD = "PullViewInfo";
    private static final long ROOM_ID_WRAPPER = 4294967295L;
    private static final String SERVICE_NAME = "trpc.icggame.pendant_config_svr.PendantConfigSvr";
    private static final String TAG = "ICGameModulePendant";
    private Set<a> fetchInfoListeners = new HashSet();

    @VisibleForTesting
    long updateDuration = 0;
    private long roomId = 0;
    private long anchorUid = 0;
    private final AtomicBoolean isStartQuery = new AtomicBoolean(false);

    @VisibleForTesting
    final Runnable fetchInfoRun = new Runnable() { // from class: com.tencent.mobileqq.icgame.api.impl.pendant.QQLiveModulePendant.2
        @Override // java.lang.Runnable
        public void run() {
            if (QQLiveModulePendant.this.fetchInfoListeners.isEmpty()) {
                QLog.i(QQLiveModulePendant.TAG, 1, "fetchInfoListeners is empty, stop run");
                return;
            }
            QQLiveModulePendant qQLiveModulePendant = QQLiveModulePendant.this;
            if (qQLiveModulePendant.updateDuration < 1) {
                qQLiveModulePendant.updateDuration = 60L;
            }
            qQLiveModulePendant.doFetchPendantInfo();
            ThreadManagerV2.getUIHandlerV2().postDelayed(this, QQLiveModulePendant.this.updateDuration * 1000);
        }
    };

    private void appendMetaData(String str, StringBuilder sb5) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                String string = jSONObject.getString(str2);
                sb5.append(ContainerUtils.FIELD_DELIMITER);
                sb5.append(str2);
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(string);
            }
        } catch (Exception e16) {
            QLog.d(TAG, 1, "appendMetaData exception fail " + e16.getMessage());
        }
    }

    private String buildWebDataUrl(String str, long j3, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder(str);
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
        } else {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        }
        sb5.append("roomId=");
        sb5.append(this.roomId & 4294967295L);
        sb5.append("&anchorId=");
        sb5.append(this.anchorUid);
        sb5.append("&view_id=");
        sb5.append(j3);
        appendMetaData(str2, sb5);
        String sb6 = sb5.toString();
        if (this.roomId == 0) {
            ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).a(TAG, "qqlivePendant buildWebDataUrl room id is 0!");
        }
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i(TAG, "room: " + this.roomId + " qqlive pendant url:" + sb6);
        return sb6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doFetchPendantInfo() {
        ((IAegisLogApi) QRoute.api(IAegisLogApi.class)).i(TAG, "doFetchPendantInfo roomId:" + this.roomId);
        e eVar = new e();
        eVar.f391590a = this.roomId;
        c cVar = (c) this.sdkImpl.getExtModule("sso_module");
        if (cVar != null) {
            cVar.f(SERVICE_NAME, PULL_VIEW_INFO_METHOD, MessageNano.toByteArray(eVar), new h(new com.tencent.mobileqq.icgame.sso.a() { // from class: com.tencent.mobileqq.icgame.api.impl.pendant.QQLiveModulePendant.1
                @Override // com.tencent.mobileqq.icgame.sso.a
                public void onBusinessFailed(int i3, String str) {
                    super.onBusinessFailed(i3, str);
                }

                @Override // com.tencent.mobileqq.icgame.sso.a
                public void onProxyRequestSuccess(int i3, i iVar) throws InvalidProtocolBufferNanoException {
                    if (QQLiveModulePendant.this.fetchInfoListeners.isEmpty()) {
                        QLog.e(QQLiveModulePendant.TAG, 1, "request success, but listener is empty");
                        return;
                    }
                    f c16 = f.c(iVar.e());
                    QQLiveModulePendant.this.updateDuration = c16.f391592b;
                    QLog.i(QQLiveModulePendant.TAG, 1, "the update Duration " + QQLiveModulePendant.this.updateDuration);
                    QQLiveModulePendant.this.isStartQuery.compareAndSet(false, true);
                    ArrayList<PendantViewData> transToPendantServiceBean = QQLiveModulePendant.this.transToPendantServiceBean("init", c16);
                    Iterator it = QQLiveModulePendant.this.fetchInfoListeners.iterator();
                    while (it.hasNext()) {
                        ((a) it.next()).onRecv(transToPendantServiceBean);
                    }
                }
            }));
        }
    }

    private PendantViewData transferViewInfoToBean(String str, cp4.i iVar) {
        PendantViewData pendantViewData = new PendantViewData();
        pendantViewData.viewId = iVar.f391598a;
        pendantViewData.viewType = iVar.f391599b;
        pendantViewData.version = iVar.f391600c;
        pendantViewData.visible = iVar.f391601d;
        g gVar = iVar.f391602e;
        pendantViewData.minUpdateDuration = gVar.f391593a;
        pendantViewData.maxUpdateDuration = gVar.f391594b;
        try {
            JSONObject jSONObject = new JSONObject(iVar.f391603f);
            pendantViewData.viewWidth = t42.h.c(jSONObject.optInt("width", 0));
            pendantViewData.viewHeight = t42.h.c(jSONObject.optInt("height", 0));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (iVar.f391599b == 1) {
            WebPendantData webPendantData = new WebPendantData();
            webPendantData.dataCmd = str;
            webPendantData.pendantWebUrl = buildWebDataUrl(iVar.f391605h.f391611a, iVar.f391598a, iVar.f391603f);
            j jVar = iVar.f391605h;
            webPendantData.pendantWebData = jVar.f391612b;
            webPendantData.pendentWebDataSig = jVar.f391614d;
            pendantViewData.webPendantData = webPendantData;
        } else {
            cp4.c cVar = iVar.f391605h.f391613c;
            if (cVar == null) {
                QLog.d(TAG, 1, " the view info of pci is null");
                return null;
            }
            if (cVar.f391587a == null) {
                QLog.e(TAG, 1, "transferViewInfoToBean viewInfo.getInfo().getPendantData().getInfosList() == null return null");
                return null;
            }
            pendantViewData.businessData = cVar.f391588b;
        }
        return pendantViewData;
    }

    @Override // com.tencent.mobileqq.icgame.api.pendant.IQQLiveModulePendant
    public void addFetchPendantInfoListener(a aVar) {
        if (aVar != null && !this.fetchInfoListeners.contains(aVar)) {
            this.fetchInfoListeners.add(aVar);
        }
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void destroy() {
        this.isStartQuery.set(false);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.fetchInfoRun);
        this.fetchInfoListeners.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.impl.IQQLiveBaseModule, com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        super.init(iQQLiveSDK);
    }

    @Override // com.tencent.mobileqq.icgame.api.pendant.IQQLiveModulePendant
    public void removeFetchPendantInfoListener(a aVar) {
        this.fetchInfoListeners.remove(aVar);
    }

    @Override // com.tencent.mobileqq.icgame.api.IQQLiveModule
    public void reset() {
        this.isStartQuery.set(false);
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.fetchInfoRun);
        this.fetchInfoListeners.clear();
    }

    @Override // com.tencent.mobileqq.icgame.api.pendant.IQQLiveModulePendant
    public void startFetchPendantInfo(long j3, long j16) {
        if (this.isStartQuery.get()) {
            QLog.d(TAG, 1, "the pendant fetch looper is beginning ");
            return;
        }
        this.anchorUid = j3;
        this.roomId = j16;
        ThreadManagerV2.getUIHandlerV2().post(this.fetchInfoRun);
    }

    @VisibleForTesting
    ArrayList<PendantViewData> transToPendantServiceBean(String str, f fVar) {
        ArrayList<PendantViewData> arrayList = new ArrayList<>();
        for (cp4.i iVar : fVar.f391591a) {
            if (iVar.f391605h != null) {
                arrayList.add(transferViewInfoToBean(str, iVar));
            }
        }
        return arrayList;
    }
}
