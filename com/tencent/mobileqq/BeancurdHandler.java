package com.tencent.mobileqq;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.BeancurdHandler;
import com.tencent.mobileqq.api.ITofuActionApi;
import com.tencent.mobileqq.app.BaseBusinessHandler;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.NewBeancurdMsg;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msg.api.IFeatureSwitch;
import com.tencent.mobileqq.oidb.cmd0xf7e.oidb_cmd0xf7e$LastTofu;
import com.tencent.mobileqq.oidb.cmd0xf7e.oidb_cmd0xf7e$ReqBody;
import com.tencent.mobileqq.oidb.cmd0xf7e.oidb_cmd0xf7e$RspBody;
import com.tencent.mobileqq.oidb.tofuCommon.TofuCommon$Content;
import com.tencent.mobileqq.oidb.tofuCommon.TofuCommon$TofuCubeInfo;
import com.tencent.mobileqq.onlinestatus.api.IAvatarStatusViewApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes9.dex */
public class BeancurdHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.beancurd.a f154055d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f154056e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.BeancurdHandler$1, reason: invalid class name */
    /* loaded from: classes9.dex */
    public class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ NewBeancurdMsg f154057d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f154058e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f154059f;

        AnonymousClass1(NewBeancurdMsg newBeancurdMsg, String str, String str2) {
            this.f154057d = newBeancurdMsg;
            this.f154058e = str;
            this.f154059f = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BeancurdHandler.this, newBeancurdMsg, str, str2);
            }
        }

        private void e() {
            QLog.i("BeancurdHandler", 1, "try to update enableNewYearTofu and statusInfo, busiId: " + this.f154057d.busiid + ", busiUuid: " + this.f154057d.busiUuid);
            ((ITofuActionApi) QRoute.api(ITofuActionApi.class)).enableNewYearTofuUpdate(((BaseBusinessHandler) BeancurdHandler.this).appRuntime, this.f154058e);
            ((ITofuActionApi) QRoute.api(ITofuActionApi.class)).trigToGetAvatarStatusInfo(((BaseBusinessHandler) BeancurdHandler.this).appRuntime, this.f154058e);
            IAvatarStatusViewApi iAvatarStatusViewApi = (IAvatarStatusViewApi) QRoute.api(IAvatarStatusViewApi.class);
            final NewBeancurdMsg newBeancurdMsg = this.f154057d;
            final String str = this.f154059f;
            iAvatarStatusViewApi.downloadAllTofuBg(new Function1() { // from class: com.tencent.mobileqq.e
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit f16;
                    f16 = BeancurdHandler.AnonymousClass1.this.f(newBeancurdMsg, str, (Boolean) obj);
                    return f16;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit f(NewBeancurdMsg newBeancurdMsg, String str, Boolean bool) {
            try {
                boolean isEnableNewYearTofu = ((ITofuActionApi) QRoute.api(ITofuActionApi.class)).isEnableNewYearTofu(((BaseBusinessHandler) BeancurdHandler.this).appRuntime);
                QLog.i("BeancurdHandler", 1, "downloadAllTofuBg callback, try to onUpdateBeancurd to DB, enableNewYearTofu:" + isEnableNewYearTofu + ", busiId: " + newBeancurdMsg.busiid + ", busiUuid: " + newBeancurdMsg.busiUuid);
                if (BeancurdHandler.this.f154055d != null && isEnableNewYearTofu) {
                    BeancurdHandler.this.f154055d.d(newBeancurdMsg, str);
                }
                BeancurdHandler.this.Z2();
                return null;
            } catch (Throwable th5) {
                QLog.i("BeancurdHandler", 1, "handleOnlineStatusTofu exception: " + th5);
                BeancurdHandler.this.Z2();
                return null;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                e();
            }
        }
    }

    protected BeancurdHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f154056e = true;
        }
    }

    private boolean M2(oidb_cmd0xf7e$RspBody oidb_cmd0xf7e_rspbody) {
        if (!oidb_cmd0xf7e_rspbody.msg_tofu_cube_info.has()) {
            QLog.d("BeancurdHandler", 1, "rsp is invalid");
            return true;
        }
        return false;
    }

    private NewBeancurdMsg.ExtraTofuInfo N2(String str) {
        if (TextUtils.equals(str, "sogou")) {
            return new NewBeancurdMsg.ExtraTofuInfo(false, 1);
        }
        return new NewBeancurdMsg.ExtraTofuInfo(false, 3);
    }

    public static String P2(TofuCommon$TofuCubeInfo tofuCommon$TofuCubeInfo) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("busiid", tofuCommon$TofuCubeInfo.uint64_busi_id.get());
            jSONObject.put("busi_uuid", tofuCommon$TofuCubeInfo.string_busi_uuid.get());
            jSONObject.put("beancurd_style", tofuCommon$TofuCubeInfo.uint32_style.get());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("detail", tofuCommon$TofuCubeInfo.busi_desc.title.get());
            jSONObject2.put("color", tofuCommon$TofuCubeInfo.busi_desc.color.get());
            jSONObject.put("description", jSONObject2);
            if (tofuCommon$TofuCubeInfo.string_backgroud.has()) {
                jSONObject.put("background", tofuCommon$TofuCubeInfo.string_backgroud.get());
            }
            if (tofuCommon$TofuCubeInfo.string_resource.has()) {
                jSONObject.put("busiicon", tofuCommon$TofuCubeInfo.string_resource.get());
            }
            if (tofuCommon$TofuCubeInfo.busi_detail.has()) {
                List<TofuCommon$Content> list = tofuCommon$TofuCubeInfo.busi_detail.get();
                JSONArray jSONArray = new JSONArray();
                for (TofuCommon$Content tofuCommon$Content : list) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("detail", tofuCommon$Content.title.get());
                    jSONObject3.put("color", tofuCommon$Content.color.get());
                    jSONArray.mo162put(jSONObject3);
                }
                jSONObject.put("content_list", jSONArray);
            }
            if (tofuCommon$TofuCubeInfo.uint64_uin.has()) {
                JSONArray jSONArray2 = new JSONArray();
                Iterator<Long> it = tofuCommon$TofuCubeInfo.uint64_uin.get().iterator();
                while (it.hasNext()) {
                    jSONArray2.mo162put(String.valueOf(it.next().longValue()));
                }
                jSONObject.put("frd_uin", jSONArray2);
            }
            if (tofuCommon$TofuCubeInfo.string_busi_ext.has()) {
                jSONObject.put("busi_extra", tofuCommon$TofuCubeInfo.string_busi_ext.get());
            }
        } catch (JSONException e16) {
            QLog.d("BeancurdHandler", 1, "getBeancurdExInfoStr err: ", e16);
        }
        return jSONObject.toString();
    }

    private long S2(Context context, String str, String str2, String str3) {
        if (TextUtils.equals(str3, "sogou") || !this.f154056e) {
            return 0L;
        }
        return Q2(context, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U2(oidb_cmd0xf7e$ReqBody oidb_cmd0xf7e_reqbody, String str, String str2, HashMap hashMap) {
        ArrayList arrayList = new ArrayList();
        if (hashMap != null && hashMap.size() > 0) {
            for (Map.Entry entry : hashMap.entrySet()) {
                oidb_cmd0xf7e$LastTofu oidb_cmd0xf7e_lasttofu = new oidb_cmd0xf7e$LastTofu();
                oidb_cmd0xf7e_lasttofu.uint64_busi_id.set(((Long) entry.getValue()).longValue());
                oidb_cmd0xf7e_lasttofu.string_busi_uuid.set((String) entry.getKey());
                arrayList.add(oidb_cmd0xf7e_lasttofu);
            }
        }
        oidb_cmd0xf7e_reqbody.lastTofus.set(arrayList);
        X2(str, str2, oidb_cmd0xf7e_reqbody);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V2(final String str, Context context, String str2, final String str3) {
        com.tencent.mobileqq.beancurd.a aVar;
        try {
            final oidb_cmd0xf7e$ReqBody oidb_cmd0xf7e_reqbody = new oidb_cmd0xf7e$ReqBody();
            oidb_cmd0xf7e_reqbody.uint64_frd_uin.set(Long.valueOf(str).longValue());
            oidb_cmd0xf7e_reqbody.uint64_last_pull_time.set(S2(context, str2, str, str3));
            oidb_cmd0xf7e_reqbody.version.set(AppSetting.f99551k);
            if (((ITofuActionApi) QRoute.api(ITofuActionApi.class)).isEnableTofuMsgDelete(this.appRuntime) && (aVar = this.f154055d) != null) {
                aVar.a(str, new r81.a() { // from class: com.tencent.mobileqq.d
                    @Override // r81.a
                    public final void onResult(HashMap hashMap) {
                        BeancurdHandler.this.U2(oidb_cmd0xf7e_reqbody, str, str3, hashMap);
                    }
                });
            } else {
                X2(str, str3, oidb_cmd0xf7e_reqbody);
            }
        } catch (NumberFormatException e16) {
            Z2();
            QLog.e("BeancurdHandler", 1, "doRequestBeancurd err: " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W2(NewBeancurdMsg newBeancurdMsg, String str, String str2, boolean z16, com.tencent.mobileqq.onlinestatus.model.f fVar) {
        QLog.i("BeancurdHandler", 1, "tryUpdateFriendAvatarSwitch callback, busiId: " + newBeancurdMsg.busiid + ", busiUuid: " + newBeancurdMsg.busiUuid);
        ThreadManagerV2.excute(new AnonymousClass1(newBeancurdMsg, str, str2), 16, null, false);
    }

    private void X2(String str, String str2, oidb_cmd0xf7e$ReqBody oidb_cmd0xf7e_reqbody) {
        QLog.i("BeancurdHandler", 1, "realToRequest, uin:" + StringUtil.getSimpleUinForPrint(str) + ", channel:" + str2);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xf7e_1", 3966, 1, oidb_cmd0xf7e_reqbody.toByteArray(), 30000L);
        makeOIDBPkg.addAttribute("friendUin", str);
        makeOIDBPkg.addAttribute(WadlProxyConsts.CHANNEL, str2);
        sendPbReq(makeOIDBPkg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z2() {
        com.tencent.mobileqq.beancurd.a aVar = this.f154055d;
        if (aVar != null) {
            aVar.b();
        }
    }

    protected boolean L2(Context context, String str, String str2) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, this, context, str, str2)).booleanValue();
        }
        if (NetConnInfoCenter.getServerTime() >= R2(context, str, str2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            return z16;
        }
        QLog.i("BeancurdHandler", 1, "doRequestBeancurd failed: uin is null || friendUin is null");
        return false;
    }

    protected void O2(final Context context, final String str, final String str2, final String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, context, str, str2, str3);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.c
                @Override // java.lang.Runnable
                public final void run() {
                    BeancurdHandler.this.V2(str2, context, str, str3);
                }
            }, 32, null, false);
        }
    }

    protected long Q2(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, this, context, str, str2)).longValue();
        }
        return ((Long) com.tencent.mobileqq.utils.p.b(context, str, str2 + "last_requestTime", 0L)).longValue();
    }

    protected long R2(Context context, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, this, context, str, str2)).longValue();
        }
        return ((Long) com.tencent.mobileqq.utils.p.b(context, str, str2 + "next_requestTime", 0L)).longValue();
    }

    protected void T2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (obj == null) {
            if (QLog.isColorLevel()) {
                QLog.i("BeancurdHandler", 2, "handleGetBeancurd | data is null");
            }
            Z2();
            return;
        }
        final String str = (String) toServiceMsg.getAttribute("friendUin", "");
        final String str2 = (String) toServiceMsg.getAttribute(WadlProxyConsts.CHANNEL, "");
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        try {
            oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            if (oidb_sso_oidbssopkg.bytes_bodybuffer.has() && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                oidb_cmd0xf7e$RspBody oidb_cmd0xf7e_rspbody = new oidb_cmd0xf7e$RspBody();
                oidb_cmd0xf7e_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                d3(this.appRuntime.getApp(), this.appRuntime.getCurrentAccountUin(), str, oidb_cmd0xf7e_rspbody.uint64_next_pull_time.get());
                c3(this.appRuntime.getApp(), this.appRuntime.getCurrentAccountUin(), str, NetConnInfoCenter.getServerTime());
                if (((ITofuActionApi) QRoute.api(ITofuActionApi.class)).isEnableTofuMsgDelete(this.appRuntime) && this.f154055d != null) {
                    this.f154055d.c(oidb_cmd0xf7e_rspbody.lastTofus.get(), str, str2);
                }
                if (M2(oidb_cmd0xf7e_rspbody)) {
                    Z2();
                    return;
                }
                TofuCommon$TofuCubeInfo tofuCommon$TofuCubeInfo = oidb_cmd0xf7e_rspbody.msg_tofu_cube_info;
                final NewBeancurdMsg newBeancurdMsg = new NewBeancurdMsg();
                newBeancurdMsg.busiid = tofuCommon$TofuCubeInfo.uint64_busi_id.get();
                newBeancurdMsg.frienduin = str;
                newBeancurdMsg.busiUuid = tofuCommon$TofuCubeInfo.string_busi_uuid.get();
                newBeancurdMsg.extensionInfoStr = P2(tofuCommon$TofuCubeInfo);
                newBeancurdMsg.pushInfoString = N2(str2).toJsonString();
                boolean isFeatureSwitchEnable = ((IFeatureSwitch) QRoute.api(IFeatureSwitch.class)).isFeatureSwitchEnable("new_year_tofu_insert_db_change", true);
                QLog.i("BeancurdHandler", 1, "get tofu msg response, beancurdMsg" + newBeancurdMsg + ", newYearTofuInsertSwitch:" + isFeatureSwitchEnable + ", channel:" + str2);
                if (isFeatureSwitchEnable && newBeancurdMsg.busiid == ((ITofuActionApi) QRoute.api(ITofuActionApi.class)).getOnlineStatusBeancurdBusiId()) {
                    ((ITofuActionApi) QRoute.api(ITofuActionApi.class)).tryUpdateFriendAvatarSwitch(this.appRuntime, new ec2.b() { // from class: com.tencent.mobileqq.b
                        @Override // ec2.b
                        public final void a(boolean z16, com.tencent.mobileqq.onlinestatus.model.f fVar) {
                            BeancurdHandler.this.W2(newBeancurdMsg, str, str2, z16, fVar);
                        }
                    });
                    return;
                }
                if (newBeancurdMsg.busiid == ((ITofuActionApi) QRoute.api(ITofuActionApi.class)).getOnlineStatusBeancurdBusiId()) {
                    ((ITofuActionApi) QRoute.api(ITofuActionApi.class)).tryUpdateFriendAvatarSwitch(this.appRuntime, null);
                }
                com.tencent.mobileqq.beancurd.a aVar = this.f154055d;
                if (aVar != null) {
                    aVar.d(newBeancurdMsg, str2);
                }
                Z2();
                return;
            }
            QLog.e("BeancurdHandler", 1, "handleGetBeancurd oidb error");
            Z2();
        } catch (InvalidProtocolBufferMicroException e16) {
            Z2();
            if (QLog.isColorLevel()) {
                QLog.e("BeancurdHandler", 2, "handleGetBeancurd err", e16);
            }
        }
    }

    public void Y2(Context context, String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, str, str2, str3);
            return;
        }
        if (!TextUtils.equals(str3, "sogou") && !L2(context, str, str2) && this.f154056e) {
            QLog.i("BeancurdHandler", 1, "can not request before next requestTime");
            Z2();
        } else {
            O2(context, str, str2, str3);
        }
    }

    public void a3(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.f154056e = z16;
        }
    }

    public void b3(com.tencent.mobileqq.beancurd.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar);
        } else {
            this.f154055d = aVar;
        }
    }

    protected void c3(Context context, String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, context, str, str2, Long.valueOf(j3));
            return;
        }
        com.tencent.mobileqq.utils.p.g(context, str, true, str2 + "last_requestTime", Long.valueOf(j3));
    }

    protected void d3(Context context, String str, String str2, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, context, str, str2, Long.valueOf(j3));
            return;
        }
        com.tencent.mobileqq.utils.p.g(context, str, true, str2 + "next_requestTime", Long.valueOf(j3));
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0xf7e_1");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.d("BeancurdHandler", 2, "onReceive,resp == null");
            }
        } else {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (!msgCmdFilter(serviceCmd) && serviceCmd.equals("OidbSvc.0xf7e_1")) {
                T2(toServiceMsg, fromServiceMsg, obj);
            }
        }
    }
}
