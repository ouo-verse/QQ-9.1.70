package com.tencent.mobileqq.vas.updatesystem.handler;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.g;
import com.tencent.mobileqq.vas.updatesystem.api.IVasUpdateToggle;
import com.tencent.mobileqq.vas.updatesystem.data.VasUpdateData;
import com.tencent.mobileqq.vas.updatesystem.service.IVasUpdateHandler;
import com.tencent.mobileqq.vas.updatesystem.service.VasUpdateObserver;
import com.tencent.mobileqq.vas.utils.VasCommonUtils;
import com.tencent.pb.scupdate.SCUpdatePB$ItemVersion;
import com.tencent.pb.scupdate.SCUpdatePB$SCUpdateReq;
import com.tencent.pb.scupdate.SCUpdatePB$SCUpdateRsp;
import com.tencent.pb.scupdate.SCUpdatePB$UpdateInfo;
import com.tencent.pb.scupdate.SCUpdatePB$VCR;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.util.b;
import com.tencent.xweb.FileReaderHelper;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.app.NewIntent;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasUpdateHandler extends BusinessHandler implements IVasUpdateHandler {

    /* renamed from: h, reason: collision with root package name */
    public static final String f311201h = "com.tencent.mobileqq.vas.updatesystem.handler.VasUpdateHandler";

    /* renamed from: i, reason: collision with root package name */
    private static long f311202i;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap<String, BusinessObserver> f311203d;

    /* renamed from: e, reason: collision with root package name */
    private final List<IVasUpdateHandler.a> f311204e;

    /* renamed from: f, reason: collision with root package name */
    private final BaseQQAppInterface f311205f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public static class UpdateRunnable implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        BusinessObserver f311206d;

        /* renamed from: e, reason: collision with root package name */
        boolean f311207e;

        /* renamed from: f, reason: collision with root package name */
        Object f311208f;

        public UpdateRunnable(BusinessObserver businessObserver, boolean z16, Object obj) {
            this.f311206d = businessObserver;
            this.f311207e = z16;
            this.f311208f = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            BusinessObserver businessObserver = this.f311206d;
            if (businessObserver != null) {
                businessObserver.onUpdate(0, this.f311207e, this.f311208f);
            }
        }
    }

    public VasUpdateHandler(BaseQQAppInterface baseQQAppInterface) {
        super(baseQQAppInterface);
        this.f311203d = new HashMap<>();
        this.f311204e = new ArrayList();
        this.f311205f = baseQQAppInterface;
    }

    @NotNull
    private NewIntent D2(String str, BaseApplication baseApplication, byte[] bArr) {
        NewIntent newIntent = new NewIntent(baseApplication, a.class);
        newIntent.putExtra(a.f311209d, str);
        newIntent.putExtra(a.f311210e, bArr);
        return newIntent;
    }

    private void E2(FromServiceMsg fromServiceMsg, BusinessObserver businessObserver, Object obj) {
        ThreadManager.getSubThreadHandler().post(new UpdateRunnable(businessObserver, fromServiceMsg.isSuccess(), obj));
    }

    private boolean F2(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        BusinessObserver businessObserver;
        String stringExtra = intent.getStringExtra("__cmd_seq__");
        if (TextUtils.isEmpty(stringExtra) || !this.f311203d.containsKey(stringExtra) || (businessObserver = this.f311203d.get(stringExtra)) == null) {
            return false;
        }
        this.f311203d.remove(stringExtra);
        Class cls = (Class) intent.getSerializableExtra("__rspClass__");
        if (cls == null) {
            E2(fromServiceMsg, businessObserver, bArr);
            return true;
        }
        try {
            MessageMicro messageMicro = (MessageMicro) cls.newInstance();
            if (bArr != null) {
                messageMicro.mergeFrom(bArr);
                E2(fromServiceMsg, businessObserver, messageMicro);
                return true;
            }
        } catch (Exception e16) {
            QLog.e("ApolloExtensionHandler", 1, "response is error", e16);
        }
        return false;
    }

    private void G2(int i3, boolean z16, VasUpdateData.QuickUpdateRsp quickUpdateRsp) {
        try {
            Iterator<IVasUpdateHandler.a> it = this.f311204e.iterator();
            while (it.hasNext()) {
                if (it.next().a(i3, z16, quickUpdateRsp)) {
                    return;
                }
            }
        } catch (ConcurrentModificationException e16) {
            QLog.i("ApolloExtensionHandler", 1, "traversal is error", e16);
        }
        notifyUI(i3, z16, quickUpdateRsp);
    }

    private void H2(String str, byte[] bArr, String str2, BusinessObserver businessObserver) {
        NewIntent newIntent = new NewIntent(this.f311205f.getApp(), a.class);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("_");
        long j3 = f311202i + 1;
        f311202i = j3;
        sb5.append(j3);
        String sb6 = sb5.toString();
        newIntent.putExtra(a.f311209d, str);
        newIntent.putExtra(a.f311210e, bArr);
        newIntent.putExtra(a.f311211f, 30000L);
        if (!TextUtils.isEmpty(str2)) {
            newIntent.putExtra(a.f311212h, str2);
        }
        newIntent.putExtra("__cmd_seq__", sb6);
        this.f311203d.put(sb6, businessObserver);
        this.f311205f.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.service.IVasUpdateHandler
    public void addHandleQuickUpdateInterceptor(IVasUpdateHandler.a aVar) {
        if (aVar != null && !this.f311204e.contains(aVar)) {
            this.f311204e.add(aVar);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.service.IVasUpdateHandler
    public void handleQuickUpdate(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        long j3;
        if (bArr != null && fromServiceMsg.isSuccess()) {
            SCUpdatePB$SCUpdateRsp sCUpdatePB$SCUpdateRsp = new SCUpdatePB$SCUpdateRsp();
            try {
                sCUpdatePB$SCUpdateRsp.mergeFrom(bArr);
                if (QLog.isColorLevel()) {
                    QLog.d("ApolloExtensionHandler", 2, "handleQuickUpdate ret: " + sCUpdatePB$SCUpdateRsp.ret.get());
                }
                if (sCUpdatePB$SCUpdateRsp.comm.cookie.has()) {
                    j3 = sCUpdatePB$SCUpdateRsp.comm.cookie.get();
                } else {
                    j3 = 0;
                }
                if (sCUpdatePB$SCUpdateRsp.ret.get() == 0) {
                    if (sCUpdatePB$SCUpdateRsp.cmd.get() == 1) {
                        VasUpdateData.SyncVCRRsp syncVCRRsp = new VasUpdateData.SyncVCRRsp();
                        syncVCRRsp.cookie = j3;
                        syncVCRRsp.seq = sCUpdatePB$SCUpdateRsp.rsp0x01.seq.get();
                        syncVCRRsp.continueFlag = sCUpdatePB$SCUpdateRsp.rsp0x01.continue_flag.get();
                        syncVCRRsp.polltime = sCUpdatePB$SCUpdateRsp.comm.polltime.get();
                        syncVCRRsp.syncSwitch = sCUpdatePB$SCUpdateRsp.rsp0x01.sync_switch.get();
                        syncVCRRsp.environment = sCUpdatePB$SCUpdateRsp.rsp0x01.environment.get();
                        for (int i3 = 0; i3 < sCUpdatePB$SCUpdateRsp.rsp0x01.vcr_list.size(); i3++) {
                            SCUpdatePB$VCR sCUpdatePB$VCR = sCUpdatePB$SCUpdateRsp.rsp0x01.vcr_list.get(i3);
                            VasUpdateData.VCR vcr = new VasUpdateData.VCR();
                            vcr.set(sCUpdatePB$VCR);
                            syncVCRRsp.vcrList.add(vcr);
                        }
                        syncVCRRsp.preload.ver = sCUpdatePB$SCUpdateRsp.rsp0x01.preload.plver.get();
                        syncVCRRsp.preload.setList(sCUpdatePB$SCUpdateRsp.rsp0x01.preload.item_list);
                        syncVCRRsp.report.ver = sCUpdatePB$SCUpdateRsp.rsp0x01.report.rpver.get();
                        syncVCRRsp.report.setList(sCUpdatePB$SCUpdateRsp.rsp0x01.report.item_list);
                        G2(16, true, syncVCRRsp);
                        return;
                    }
                    if (sCUpdatePB$SCUpdateRsp.cmd.get() == 2) {
                        VasUpdateData.GetUrlRsp getUrlRsp = new VasUpdateData.GetUrlRsp();
                        getUrlRsp.cookie = j3;
                        for (int i16 = 0; i16 < sCUpdatePB$SCUpdateRsp.rsp0x02.update_list.size(); i16++) {
                            SCUpdatePB$UpdateInfo sCUpdatePB$UpdateInfo = sCUpdatePB$SCUpdateRsp.rsp0x02.update_list.get(i16);
                            VasUpdateData.UpdateInfo updateInfo = new VasUpdateData.UpdateInfo();
                            updateInfo.set(sCUpdatePB$UpdateInfo, i16);
                            getUrlRsp.updateList.add(updateInfo);
                        }
                        G2(17, true, getUrlRsp);
                        return;
                    }
                    return;
                }
                QLog.e("ApolloExtensionHandler", 1, "handleQuickUpdate result = " + sCUpdatePB$SCUpdateRsp.ret.get() + "msg = " + sCUpdatePB$SCUpdateRsp.f342172msg.get());
                VasUpdateData.QuickUpdateRsp quickUpdateRsp = new VasUpdateData.QuickUpdateRsp();
                quickUpdateRsp.ret = sCUpdatePB$SCUpdateRsp.ret.get();
                quickUpdateRsp.cookie = j3;
                if (sCUpdatePB$SCUpdateRsp.cmd.get() == 1) {
                    G2(16, false, quickUpdateRsp);
                } else if (sCUpdatePB$SCUpdateRsp.cmd.get() == 2) {
                    G2(17, false, quickUpdateRsp);
                }
            } catch (Exception e16) {
                QLog.e("ApolloExtensionHandler", 1, "handleQuickUpdate error: ", e16);
                VasUpdateData.QuickUpdateRsp quickUpdateRsp2 = new VasUpdateData.QuickUpdateRsp();
                quickUpdateRsp2.ret = -1L;
                quickUpdateRsp2.cookie = 0L;
                if (sCUpdatePB$SCUpdateRsp.cmd.get() == 1) {
                    G2(16, false, quickUpdateRsp2);
                } else if (sCUpdatePB$SCUpdateRsp.cmd.get() == 2) {
                    G2(17, false, quickUpdateRsp2);
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return VasUpdateObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.service.IVasUpdateHandler
    public void request(String str, MessageMicro messageMicro, Class cls, BusinessObserver businessObserver) {
        NewIntent newIntent = new NewIntent(this.f311205f.getApp(), a.class);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("_");
        long j3 = f311202i + 1;
        f311202i = j3;
        sb5.append(j3);
        String sb6 = sb5.toString();
        newIntent.putExtra(a.f311209d, str);
        newIntent.putExtra(a.f311210e, messageMicro.toByteArray());
        newIntent.putExtra(a.f311211f, 30000L);
        newIntent.putExtra("__cmd_seq__", sb6);
        newIntent.putExtra("__rspClass__", cls);
        this.f311203d.put(sb6, businessObserver);
        this.f311205f.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.service.IVasUpdateHandler
    public boolean requestQuickUpdate(String str, String str2) {
        boolean z16;
        boolean z17;
        int i3;
        try {
            if (b.f362976b.isDebugVersion()) {
                QLog.i("ApolloExtensionHandler", 1, "cmd:" + str + " content:" + str2);
            }
            SCUpdatePB$SCUpdateReq sCUpdatePB$SCUpdateReq = new SCUpdatePB$SCUpdateReq();
            sCUpdatePB$SCUpdateReq.comm.plat.set(109);
            PBBytesField pBBytesField = sCUpdatePB$SCUpdateReq.comm.qver;
            g gVar = g.f308459b;
            pBBytesField.set(ByteStringMicro.copyFrom(gVar.getReportVersionName().getBytes()));
            sCUpdatePB$SCUpdateReq.comm.appver.set(gVar.getReportVersionName());
            sCUpdatePB$SCUpdateReq.comm.osrelease.set(ByteStringMicro.copyFrom(String.valueOf(Build.VERSION.SDK_INT).getBytes()));
            sCUpdatePB$SCUpdateReq.comm.network.set(VasCommonUtils.INSTANCE.getNetWorkType(this.f311205f.getApplication()));
            sCUpdatePB$SCUpdateReq.comm.setHasFlag(true);
            JSONObject jSONObject = new JSONObject(str2);
            if (jSONObject.has("cookie")) {
                sCUpdatePB$SCUpdateReq.comm.cookie.set(jSONObject.optLong("cookie"));
            }
            if (jSONObject.has(FileReaderHelper.OPEN_FILE_FROM_FORCE)) {
                sCUpdatePB$SCUpdateReq.comm.force.set(jSONObject.optInt(FileReaderHelper.OPEN_FILE_FROM_FORCE));
            } else {
                sCUpdatePB$SCUpdateReq.comm.force.set(2);
            }
            if ("SyncVCRReq".equals(str)) {
                sCUpdatePB$SCUpdateReq.cmd.set(1);
                long optLong = jSONObject.optLong("seq");
                int optInt = jSONObject.optInt("sync_mode");
                long optLong2 = jSONObject.optLong("plver");
                long optLong3 = jSONObject.optLong("rpver");
                sCUpdatePB$SCUpdateReq.req0x01.seq.set(optLong);
                sCUpdatePB$SCUpdateReq.req0x01.sync_mode.set(optInt);
                sCUpdatePB$SCUpdateReq.req0x01.plver.set(optLong2);
                sCUpdatePB$SCUpdateReq.req0x01.rpver.set(optLong3);
                JSONArray optJSONArray = jSONObject.optJSONArray("item_list");
                if (optJSONArray != null) {
                    for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i16);
                        int optInt2 = jSONObject2.optInt("bid");
                        String optString = jSONObject2.optString("scid");
                        String optString2 = jSONObject2.optString("version");
                        SCUpdatePB$ItemVersion sCUpdatePB$ItemVersion = new SCUpdatePB$ItemVersion();
                        sCUpdatePB$ItemVersion.bid.set(optInt2);
                        sCUpdatePB$ItemVersion.scid.set(optString);
                        sCUpdatePB$ItemVersion.version.set(optString2);
                        sCUpdatePB$SCUpdateReq.req0x01.item_list.add(sCUpdatePB$ItemVersion);
                    }
                }
                sCUpdatePB$SCUpdateReq.req0x01.setHasFlag(true);
            } else if ("GetUrlReq".equals(str)) {
                try {
                    sCUpdatePB$SCUpdateReq.cmd.set(2);
                    long optLong4 = jSONObject.optLong("delta_mode");
                    long optLong5 = jSONObject.optLong("storage_mode");
                    long optLong6 = jSONObject.optLong("compress_mode");
                    String optString3 = jSONObject.optString("from");
                    sCUpdatePB$SCUpdateReq.comm.from.set(ByteStringMicro.copyFrom(optString3.getBytes()));
                    sCUpdatePB$SCUpdateReq.comm.sceneinfo.set(optString3);
                    sCUpdatePB$SCUpdateReq.req0x02.delta_mode.set((int) optLong4);
                    sCUpdatePB$SCUpdateReq.req0x02.storage_mode.set((int) optLong5);
                    sCUpdatePB$SCUpdateReq.req0x02.compress_mode.set((int) optLong6);
                    JSONArray optJSONArray2 = jSONObject.optJSONArray("item_list");
                    if (optJSONArray2 != null) {
                        for (int i17 = 0; i17 < optJSONArray2.length(); i17++) {
                            JSONObject jSONObject3 = optJSONArray2.getJSONObject(i17);
                            int optInt3 = jSONObject3.optInt("bid");
                            String optString4 = jSONObject3.optString("scid");
                            String optString5 = jSONObject3.optString("srcMd5");
                            SCUpdatePB$ItemVersion sCUpdatePB$ItemVersion2 = new SCUpdatePB$ItemVersion();
                            sCUpdatePB$ItemVersion2.bid.set(optInt3);
                            sCUpdatePB$ItemVersion2.scid.set(optString4);
                            sCUpdatePB$ItemVersion2.version.set(optString5);
                            sCUpdatePB$SCUpdateReq.req0x02.item_list.add(sCUpdatePB$ItemVersion2);
                        }
                    }
                    try {
                        if (((IVasUpdateToggle) QRoute.api(IVasUpdateToggle.class)).isSupportBaseTheme()) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        sCUpdatePB$SCUpdateReq.req0x02.partial_download_flag.set(i3);
                        QLog.i("ApolloExtensionHandler", 1, "scupdate.handle content:" + str2);
                        z16 = true;
                    } catch (Exception e16) {
                        z16 = true;
                        QLog.i("ApolloExtensionHandler", 1, "error happened, " + e16);
                    }
                    sCUpdatePB$SCUpdateReq.req0x02.setHasFlag(z16);
                    z17 = true;
                    sCUpdatePB$SCUpdateReq.setHasFlag(z17);
                    this.f311205f.startServlet(D2("scupdate.handle", this.f311205f.getApp(), sCUpdatePB$SCUpdateReq.toByteArray()));
                    return true;
                } catch (Throwable th5) {
                    th = th5;
                    if (QLog.isColorLevel()) {
                        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                            QLog.e("ApolloExtensionHandler", 2, stackTraceElement.toString());
                        }
                        return false;
                    }
                    return false;
                }
            }
            z17 = true;
            sCUpdatePB$SCUpdateReq.setHasFlag(z17);
            this.f311205f.startServlet(D2("scupdate.handle", this.f311205f.getApp(), sCUpdatePB$SCUpdateReq.toByteArray()));
            return true;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg, byte[] bArr) {
        if (TextUtils.isEmpty(intent.getStringExtra("cmd")) || F2(intent, fromServiceMsg, bArr)) {
            return;
        }
        handleQuickUpdate(intent, fromServiceMsg, bArr);
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.service.IVasUpdateHandler
    public void request(String str, String str2, BusinessObserver businessObserver) {
        try {
            request(str, str2.getBytes("ISO8859_1"), businessObserver);
        } catch (UnsupportedEncodingException e16) {
            QLog.e("ApolloExtensionHandler", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.service.IVasUpdateHandler
    public void request(String str, String str2, String str3, BusinessObserver businessObserver) {
        try {
            H2(str, str2.getBytes("ISO8859_1"), str3, businessObserver);
        } catch (UnsupportedEncodingException e16) {
            QLog.e("ApolloExtensionHandler", 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.mobileqq.vas.updatesystem.service.IVasUpdateHandler
    public void request(String str, byte[] bArr, BusinessObserver businessObserver) {
        H2(str, bArr, null, businessObserver);
    }
}
