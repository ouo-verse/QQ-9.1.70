package com.tencent.mobileqq.vasgift.business.common.service;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.protobuf.nano.MessageNano;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.gamecenter.api.IYunGameConstant;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qqgift.api.service.IQQGiftRechargeModule;
import com.tencent.mobileqq.qqgift.data.service.d;
import com.tencent.mobileqq.qqgift.data.service.e;
import com.tencent.mobileqq.qqgift.data.service.f;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.VasTraceLog;
import com.tencent.mobileqq.vas.VasTraceLogProxy;
import com.tencent.mobileqq.vas.api.VasSkey;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.mobileqq.vasgift.api.impl.service.QQGiftSendGiftReportHelper;
import com.tencent.mobileqq.vasgift.utils.ThreadManager;
import com.tencent.mobileqq.vasgift.utils.k;
import com.tencent.mobileqq.vasgift.utils.m;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.api.auth.AuthScene;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$BatchGift;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$BatchPackage;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$ChannelPersonalInfo;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$ExtendInfo;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$GetPackageItemsReq;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$GetPackageItemsRsp;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$GetPackageReq;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$GetPackageRsp;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$GiftItem;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$GroupPersonalInfo;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$ItemInfo;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$LivePersonalInfo;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$MapFieldEntry;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$PackageGiftItem;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$Personalise;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$RecentExpireInfo;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$SceneItem;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$SsoGetFreeCoinsReq;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$SsoGetFreeCoinsRsp;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$SsoGetGiftItemsReq;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$SsoGetGiftItemsRsp;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$SsoGetSceneItemReq;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$SsoGetSceneItemRsp;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$TabItem;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$TagInfo;
import com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel.giftMidgroundPanel$WelfareInfo;
import com.tencent.trpcprotocol.qqva.midasPayCoinb$GetChargeProductReq;
import com.tencent.trpcprotocol.qqva.midasPayCoinb$GetChargeProductRsp;
import com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift.sendgift$BatchConsumeReq;
import com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift.sendgift$BatchConsumeRsp;
import com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift.sendgift$BatchErrInfo;
import com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift.sendgift$BatchSendInfo;
import com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift.sendgift$ConsumeOverReq;
import com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift.sendgift$ConsumeOverRsp;
import com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift.sendgift$ConsumeReq;
import com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift.sendgift$ConsumeRsp;
import com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift.sendgift$ExtData;
import com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift.sendgift$OrderInfo;
import com.tencent.trpcprotocol.qqva.midground_sendgift.sendgift.sendgift$Token;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oh2.c;
import org.json.JSONException;
import org.json.JSONObject;
import rh2.e;
import rh2.g;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VasGiftServiceModuleImpl implements oh2.b {

    /* renamed from: a, reason: collision with root package name */
    private f f311496a;

    /* renamed from: b, reason: collision with root package name */
    private nh2.c f311497b;

    /* renamed from: c, reason: collision with root package name */
    private sendgift$ConsumeReq f311498c;

    /* renamed from: d, reason: collision with root package name */
    private sendgift$BatchConsumeReq f311499d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.qqgift.data.service.c f311500e;

    /* renamed from: g, reason: collision with root package name */
    private com.tencent.mobileqq.qqgift.data.service.a f311502g;

    /* renamed from: i, reason: collision with root package name */
    private long f311504i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f311505j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f311506k;

    /* renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<Long, d43.a> f311501f = null;

    /* renamed from: h, reason: collision with root package name */
    private String f311503h = "";

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a implements e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rh2.c f311546d;

        a(rh2.c cVar) {
            this.f311546d = cVar;
        }

        @Override // qh2.d
        public void onFailed(int i3, String str) {
            this.f311546d.onFailed(i3, str);
        }

        @Override // rh2.e
        public void onReceive(List<d> list) {
            this.f311546d.e(list.get(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class b implements BusinessObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (z16 && i3 == 0 && obj != null) {
                sendgift$ConsumeOverRsp sendgift_consumeoverrsp = new sendgift$ConsumeOverRsp();
                try {
                    sendgift_consumeoverrsp.mergeFrom((byte[]) obj);
                    QLog.e("VasGiftServiceModuleImpl", 1, "doSendComboOver ret=" + sendgift_consumeoverrsp.ret.get() + ", msg=" + sendgift_consumeoverrsp.f381636msg.get());
                    VasGiftServiceModuleImpl vasGiftServiceModuleImpl = VasGiftServiceModuleImpl.this;
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("doSendComboOver rsp:");
                    sb5.append(OidbWrapper.proto2String(sendgift_consumeoverrsp));
                    vasGiftServiceModuleImpl.Z0(sb5.toString());
                    return;
                } catch (Exception e16) {
                    QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
                    VasGiftServiceModuleImpl.this.Z0("doSendComboOver crash:" + e16);
                    return;
                }
            }
            QLog.e("VasGiftServiceModuleImpl", 1, "doSendComboOver error! isSuccess=" + z16 + ",type=" + i3);
            VasGiftServiceModuleImpl.this.Z0("doSendComboOver req error:isSuccess=" + z16 + ",type=" + i3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class c implements BusinessObserver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ rh2.d f311549d;

        c(rh2.d dVar) {
            this.f311549d = dVar;
        }

        @Override // com.tencent.mobileqq.app.BusinessObserver
        public void onUpdate(int i3, boolean z16, Object obj) {
            if (!z16) {
                return;
            }
            if (obj == null) {
                this.f311549d.g(-1, "", 0L);
            }
            giftMidgroundPanel$SsoGetFreeCoinsRsp giftmidgroundpanel_ssogetfreecoinsrsp = new giftMidgroundPanel$SsoGetFreeCoinsRsp();
            if (obj != null) {
                try {
                    giftmidgroundpanel_ssogetfreecoinsrsp.mergeFrom((byte[]) obj);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e16.printStackTrace();
                }
                this.f311549d.g(giftmidgroundpanel_ssogetfreecoinsrsp.ret.get(), giftmidgroundpanel_ssogetfreecoinsrsp.f381626msg.get(), giftmidgroundpanel_ssogetfreecoinsrsp.balance.get());
            }
        }
    }

    private String A0(rh2.f fVar, dn0.b bVar, String str) {
        nh2.c cVar = this.f311497b;
        if (cVar == null || cVar.getSDKConfig() == null) {
            return "";
        }
        String str2 = this.f311497b.getSDKConfig().f264973b;
        String str3 = c() + ContainerUtils.FIELD_DELIMITER;
        if (bVar.f394297b != 0) {
            str3 = str3 + bVar.f394297b + ContainerUtils.FIELD_DELIMITER;
        }
        if (bVar.f394298c != 0) {
            str3 = str3 + bVar.f394298c + ContainerUtils.FIELD_DELIMITER;
        }
        if (bVar.f394299d != 0) {
            str3 = str3 + bVar.f394299d + ContainerUtils.FIELD_DELIMITER;
        }
        if (bVar.f394300e != 0) {
            str3 = str3 + bVar.f394300e + ContainerUtils.FIELD_DELIMITER;
        }
        if (!TextUtils.isEmpty(str)) {
            str3 = str3 + str + ContainerUtils.FIELD_DELIMITER;
        }
        if (bVar.f394303h != 0) {
            str3 = str3 + bVar.f394303h + ContainerUtils.FIELD_DELIMITER;
        }
        if (bVar.f394304i != 0) {
            str3 = str3 + bVar.f394304i + ContainerUtils.FIELD_DELIMITER;
        }
        if (bVar.f394305j != 0) {
            str3 = str3 + bVar.f394305j + ContainerUtils.FIELD_DELIMITER;
        }
        if (!TextUtils.isEmpty(str2)) {
            str3 = str3 + str2 + ContainerUtils.FIELD_DELIMITER;
        }
        try {
            return MD5Utils.encodeHexStr(str3).toLowerCase();
        } catch (Exception e16) {
            X0(fVar, -1, "appSecretKey encode fail");
            QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
            return "";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String B0(List<giftMidgroundPanel$ExtendInfo> list) {
        String str;
        String str2 = "";
        if (list == null) {
            str = "";
        } else {
            str = "";
            for (giftMidgroundPanel$ExtendInfo giftmidgroundpanel_extendinfo : list) {
                if (giftmidgroundpanel_extendinfo.key.get().equals("ReportTabID")) {
                    str2 = giftmidgroundpanel_extendinfo.value.get();
                } else if (giftmidgroundpanel_extendinfo.key.get().equals("ReportFlowID")) {
                    str = giftmidgroundpanel_extendinfo.value.get();
                }
            }
        }
        return "{\"rule_detail\":[{\"model_id\":\"" + str2 + AECameraConstants.WIDGETINFO_SEPARATE + str + "\"}]}";
    }

    @NonNull
    private List<sendgift$ExtData> C0(d dVar, com.tencent.mobileqq.qqgift.data.service.c cVar) {
        boolean z16;
        Map<String, String> map;
        Map<String, String> map2;
        ArrayList arrayList = new ArrayList();
        if (dVar != null && (map2 = dVar.M) != null && "true".equalsIgnoreCase(map2.get("needBatchInfo"))) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (dVar != null && (map = dVar.M) != null && map.containsKey("batchSendCnt")) {
            sendgift$ExtData sendgift_extdata = new sendgift$ExtData();
            sendgift_extdata.ext_key.set("batchSendCnt");
            sendgift_extdata.ext_value.set(dVar.M.get("batchSendCnt"));
            arrayList.add(sendgift_extdata);
        }
        for (Map.Entry<String, String> entry : cVar.f264870k.entrySet()) {
            if (z16 || !entry.getKey().equals("batchSendCnt")) {
                sendgift$ExtData sendgift_extdata2 = new sendgift$ExtData();
                sendgift_extdata2.ext_key.set(entry.getKey());
                sendgift_extdata2.ext_value.set(entry.getValue());
                arrayList.add(sendgift_extdata2);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String E0() {
        com.tencent.mobileqq.qqgift.data.service.a aVar = this.f311502g;
        if (aVar != null) {
            return aVar.a(c());
        }
        return c() + J0();
    }

    private String F0(com.tencent.mobileqq.qqgift.data.service.a aVar) {
        if (aVar != null) {
            return aVar.a(c());
        }
        return c() + J0();
    }

    private String G0() {
        nh2.c cVar = this.f311497b;
        String str = "0";
        if (cVar == null) {
            return "0";
        }
        if (cVar.getSDKConfig() != null && !TextUtils.isEmpty(this.f311497b.getSDKConfig().f264978g)) {
            return String.valueOf(this.f311497b.getSDKConfig().f264978g);
        }
        IQQGiftRechargeModule f16 = this.f311497b.f();
        if (this.f311497b.getSDKConfig() != null) {
            str = String.valueOf(this.f311497b.getSDKConfig().f264972a);
        }
        return f16.U(str);
    }

    private String H0(String str) {
        JSONObject jSONObject;
        try {
            if (TextUtils.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("str_ruleid", b());
            return jSONObject.toString();
        } catch (JSONException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private String J0() {
        nh2.c cVar = this.f311497b;
        if (cVar != null && cVar.getSDKConfig() != null && !TextUtils.isEmpty(this.f311497b.getSDKConfig().f264977f)) {
            return this.f311497b.getSDKConfig().f264977f;
        }
        return "0";
    }

    private void K0(com.tencent.mobileqq.qqgift.data.service.a aVar, final qh2.d dVar) {
        String str;
        this.f311502g = aVar;
        VasTraceLogProxy vasTraceLogProxy = VasTraceLog.GiftRepo.GIFT_TEST;
        vasTraceLogProxy.report("prepare");
        giftMidgroundPanel$SsoGetSceneItemReq M0 = M0(aVar);
        try {
            vasTraceLogProxy.report("send_request");
            VasUtil.getService().getPbRequest().request("trpc.qqva.gift_midground_panel.GiftMidgroundPanel.SsoGetSceneItem", new String(M0.toByteArray(), "ISO8859_1"), new BusinessObserver() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.1
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public void onUpdate(int i3, boolean z16, Object obj) {
                    long j3;
                    VasTraceLogProxy vasTraceLogProxy2 = VasTraceLog.GiftRepo.GIFT_TEST;
                    vasTraceLogProxy2.report("receive_request");
                    vasTraceLogProxy2.end();
                    if (z16 && i3 == 0 && obj != null) {
                        final giftMidgroundPanel$SsoGetSceneItemRsp giftmidgroundpanel_ssogetsceneitemrsp = new giftMidgroundPanel$SsoGetSceneItemRsp();
                        try {
                            giftmidgroundpanel_ssogetsceneitemrsp.mergeFrom((byte[]) obj);
                            if (giftmidgroundpanel_ssogetsceneitemrsp.code.get() == 0) {
                                boolean z17 = giftmidgroundpanel_ssogetsceneitemrsp.show_package_tab.get();
                                e.a aVar2 = new e.a();
                                final List<com.tencent.mobileqq.qqgift.data.service.e> a16 = VasGiftServiceModuleImpl.this.a1(giftmidgroundpanel_ssogetsceneitemrsp.item.get(), VasGiftServiceModuleImpl.this.V0(z17), VasGiftServiceModuleImpl.this.W0(VasGiftServiceModuleImpl.this.P0(aVar2, giftmidgroundpanel_ssogetsceneitemrsp)), aVar2);
                                if (m.a()) {
                                    j3 = Math.max(giftmidgroundpanel_ssogetsceneitemrsp.cache_time.get(), m.b());
                                } else {
                                    j3 = 0;
                                }
                                com.tencent.mobileqq.vasgift.business.common.service.a.e().m(VasGiftServiceModuleImpl.this.E0(), j3, a16);
                                if (dVar != null) {
                                    ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.1.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                            qh2.d dVar2 = dVar;
                                            if (dVar2 instanceof rh2.e) {
                                                ((rh2.e) dVar2).onReceive(VasGiftServiceModuleImpl.this.j1(a16));
                                            } else if (dVar2 instanceof g) {
                                                ((g) dVar2).onReceive(a16);
                                            }
                                            QLog.e("VasGiftServiceModuleImpl", 1, "getGiftList success");
                                        }
                                    });
                                }
                                if (QLog.isColorLevel()) {
                                    QLog.e("VasGiftServiceModuleImpl", 1, "getGiftList:" + a16);
                                }
                                VasGiftServiceModuleImpl.this.f1(giftmidgroundpanel_ssogetsceneitemrsp.item.scene_infos.get());
                                VasGiftServiceModuleImpl vasGiftServiceModuleImpl = VasGiftServiceModuleImpl.this;
                                vasGiftServiceModuleImpl.f311503h = vasGiftServiceModuleImpl.B0(giftmidgroundpanel_ssogetsceneitemrsp.ext_info.get());
                                com.tencent.mobileqq.vasgift.business.common.service.a.e().k(VasGiftServiceModuleImpl.this.E0(), VasGiftServiceModuleImpl.this.f311503h, z17);
                            } else if (dVar != null) {
                                ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.1.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        dVar.onFailed(giftmidgroundpanel_ssogetsceneitemrsp.code.get(), giftmidgroundpanel_ssogetsceneitemrsp.f381629msg.get());
                                        QLog.e("VasGiftServiceModuleImpl", 1, "getGiftList failed: code=" + giftmidgroundpanel_ssogetsceneitemrsp.code.get() + ",msg=" + giftmidgroundpanel_ssogetsceneitemrsp.f381629msg.get());
                                    }
                                });
                            }
                            if (QLog.isColorLevel()) {
                                VasGiftServiceModuleImpl.this.Z0("getGiftList rsp:" + OidbWrapper.proto2String(giftmidgroundpanel_ssogetsceneitemrsp));
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
                            VasGiftServiceModuleImpl.this.Z0("getGiftList req crash!" + e16);
                            return;
                        }
                    }
                    QLog.e("VasGiftServiceModuleImpl", 1, "getGiftList error! isSuccess=" + z16 + ",type=" + i3);
                    VasGiftServiceModuleImpl.this.Z0("getGiftList req fail! isSuccess=" + z16 + ",type=" + i3);
                }
            });
            if (QLog.isColorLevel()) {
                str = "getGiftList req:" + OidbWrapper.proto2String(M0);
            } else {
                str = "getGiftList";
            }
            Z0(str);
        } catch (Exception e16) {
            QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
            Z0("getGiftList crash:" + e16);
        }
    }

    private int L0(com.tencent.mobileqq.qqgift.data.service.c cVar) {
        if (cVar.f264865f) {
            return 1;
        }
        if (cVar.f264864e) {
            if (cVar.f264868i > 0) {
                return 2;
            }
            return 3;
        }
        return 0;
    }

    @NonNull
    private giftMidgroundPanel$SsoGetSceneItemReq M0(com.tencent.mobileqq.qqgift.data.service.a aVar) {
        giftMidgroundPanel$SsoGetSceneItemReq giftmidgroundpanel_ssogetsceneitemreq = new giftMidgroundPanel$SsoGetSceneItemReq();
        String I0 = I0();
        giftmidgroundpanel_ssogetsceneitemreq.business_id.set(I0);
        giftmidgroundpanel_ssogetsceneitemreq.f381628id.set("");
        giftMidgroundPanel$Personalise giftmidgroundpanel_personalise = new giftMidgroundPanel$Personalise();
        if (aVar != null) {
            giftMidgroundPanel$LivePersonalInfo giftmidgroundpanel_livepersonalinfo = new giftMidgroundPanel$LivePersonalInfo();
            giftmidgroundpanel_livepersonalinfo.anchor_id.set(aVar.f264858d);
            giftmidgroundpanel_livepersonalinfo.game_type.set(aVar.f264857c);
            giftmidgroundpanel_livepersonalinfo.source.set(aVar.f264856b);
            giftmidgroundpanel_personalise.live_info.set(giftmidgroundpanel_livepersonalinfo);
            giftmidgroundpanel_personalise.type.set(1);
        } else if (I0.equals(String.valueOf(10012))) {
            giftMidgroundPanel$GroupPersonalInfo giftmidgroundpanel_grouppersonalinfo = new giftMidgroundPanel$GroupPersonalInfo();
            nh2.c cVar = this.f311497b;
            if (cVar != null && cVar.getSDKConfig() != null) {
                if (!TextUtils.isEmpty(this.f311497b.getSDKConfig().f264974c)) {
                    giftmidgroundpanel_grouppersonalinfo.version.set(this.f311497b.getSDKConfig().f264974c);
                }
                if (this.f311497b.getSDKConfig().f264980i != null && this.f311497b.getSDKConfig().f264980i.containsKey("groupID") && !TextUtils.isEmpty(this.f311497b.getSDKConfig().f264980i.get("groupID"))) {
                    giftmidgroundpanel_grouppersonalinfo.group_id.set(this.f311497b.getSDKConfig().f264980i.get("groupID"));
                }
            }
            giftmidgroundpanel_grouppersonalinfo.source.set("android");
            giftmidgroundpanel_personalise.group_info.set(giftmidgroundpanel_grouppersonalinfo);
            giftmidgroundpanel_personalise.type.set(3);
        } else {
            giftMidgroundPanel$ChannelPersonalInfo giftmidgroundpanel_channelpersonalinfo = new giftMidgroundPanel$ChannelPersonalInfo();
            nh2.c cVar2 = this.f311497b;
            if (cVar2 != null && cVar2.getSDKConfig() != null) {
                if (!TextUtils.isEmpty(this.f311497b.getSDKConfig().f264974c)) {
                    giftmidgroundpanel_channelpersonalinfo.version.set(this.f311497b.getSDKConfig().f264974c);
                }
                if (this.f311497b.getSDKConfig().f264980i != null && this.f311497b.getSDKConfig().f264980i.containsKey("channel_id")) {
                    giftmidgroundpanel_channelpersonalinfo.channel_id.set(this.f311497b.getSDKConfig().f264980i.get("channel_id"));
                }
            }
            giftmidgroundpanel_channelpersonalinfo.source.set("android");
            giftmidgroundpanel_personalise.channel_info.set(giftmidgroundpanel_channelpersonalinfo);
            giftmidgroundpanel_personalise.type.set(2);
        }
        giftmidgroundpanel_ssogetsceneitemreq.persionalise_info.set(giftmidgroundpanel_personalise);
        giftmidgroundpanel_ssogetsceneitemreq.scene_type.set(2);
        return giftmidgroundpanel_ssogetsceneitemreq;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x01b4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x011c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0134 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x013e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x016d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0196 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01a0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01aa A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01cc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00fe A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void N0(giftMidgroundPanel$GiftItem giftmidgroundpanel_giftitem, d dVar) {
        giftMidgroundPanel$ItemInfo giftmidgroundpanel_iteminfo = giftmidgroundpanel_giftitem.material_item.get();
        dVar.f264874d = Long.valueOf(giftmidgroundpanel_giftitem.f381624id.get()).intValue();
        dVar.f264876e = giftmidgroundpanel_iteminfo.name.get();
        dVar.f264878f = Long.valueOf(giftmidgroundpanel_iteminfo.price.get()).intValue();
        dVar.T = giftmidgroundpanel_giftitem.desc.get();
        dVar.C = Long.valueOf(giftmidgroundpanel_iteminfo.tian_quan_id.get()).intValue();
        dVar.P = w0(giftmidgroundpanel_giftitem);
        List<giftMidgroundPanel$MapFieldEntry> list = giftmidgroundpanel_giftitem.business_infos.get();
        if (list != null) {
            for (giftMidgroundPanel$MapFieldEntry giftmidgroundpanel_mapfieldentry : list) {
                String str = giftmidgroundpanel_mapfieldentry.key.get();
                str.hashCode();
                char c16 = '\uffff';
                switch (str.hashCode()) {
                    case -1473606019:
                        if (str.equals("actButtonMsg")) {
                            c16 = 0;
                        }
                        switch (c16) {
                            case 0:
                                dVar.f264880g0 = giftmidgroundpanel_mapfieldentry.value.get();
                                break;
                            case 1:
                                try {
                                    dVar.F = Integer.parseInt(giftmidgroundpanel_mapfieldentry.value.get());
                                    break;
                                } catch (NumberFormatException e16) {
                                    QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
                                    dVar.F = 0;
                                    break;
                                }
                            case 2:
                                dVar.f264882h0 = giftmidgroundpanel_mapfieldentry.value.get();
                                break;
                            case 3:
                                dVar.f264873c0 = giftmidgroundpanel_mapfieldentry.value.get();
                                break;
                            case 4:
                                dVar.f264871a0 = giftmidgroundpanel_mapfieldentry.value.get();
                                break;
                            case 5:
                                if (dVar.G == null) {
                                    dVar.G = new d.c();
                                }
                                try {
                                    dVar.G.f264891d = Long.parseLong(giftmidgroundpanel_mapfieldentry.value.get());
                                    break;
                                } catch (NumberFormatException e17) {
                                    QLog.e("VasGiftServiceModuleImpl", 1, e17, new Object[0]);
                                    dVar.G.f264891d = 0L;
                                    break;
                                }
                            case 6:
                                try {
                                    dVar.f264881h = Integer.parseInt(giftmidgroundpanel_mapfieldentry.value.get());
                                    break;
                                } catch (NumberFormatException e18) {
                                    QLog.e("VasGiftServiceModuleImpl", 1, e18, new Object[0]);
                                    dVar.f264881h = 1;
                                    break;
                                }
                            case 7:
                                if (dVar.G == null) {
                                    dVar.G = new d.c();
                                }
                                dVar.G.f264892e = giftmidgroundpanel_mapfieldentry.value.get();
                                break;
                            case '\b':
                                dVar.f264872b0 = giftmidgroundpanel_mapfieldentry.value.get();
                                break;
                            case '\t':
                                try {
                                    dVar.f264883i = Integer.parseInt(giftmidgroundpanel_mapfieldentry.value.get());
                                    break;
                                } catch (NumberFormatException e19) {
                                    QLog.e("VasGiftServiceModuleImpl", 1, e19, new Object[0]);
                                    dVar.f264883i = 0;
                                    break;
                                }
                            default:
                                if (dVar.M == null) {
                                    dVar.M = new HashMap();
                                }
                                dVar.M.put(giftmidgroundpanel_mapfieldentry.key.get(), giftmidgroundpanel_mapfieldentry.value.get());
                                break;
                        }
                    case 27394392:
                        if (str.equals("giftPay")) {
                            c16 = 1;
                        }
                        switch (c16) {
                        }
                        break;
                    case 280721775:
                        if (str.equals("actJumpUrl")) {
                            c16 = 2;
                        }
                        switch (c16) {
                        }
                        break;
                    case 321545849:
                        if (str.equals("userLevel")) {
                            c16 = 3;
                        }
                        switch (c16) {
                        }
                        break;
                    case 443458437:
                        if (str.equals("isfansGroupGift")) {
                            c16 = 4;
                        }
                        switch (c16) {
                        }
                        break;
                    case 515047614:
                        if (str.equals("countDownTime")) {
                            c16 = 5;
                        }
                        switch (c16) {
                        }
                        break;
                    case 849368202:
                        if (str.equals("giftType")) {
                            c16 = 6;
                        }
                        switch (c16) {
                        }
                        break;
                    case 1022214321:
                        if (str.equals(QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT)) {
                            c16 = 7;
                        }
                        switch (c16) {
                        }
                        break;
                    case 1363537957:
                        if (str.equals("fansGroupLevel")) {
                            c16 = '\b';
                        }
                        switch (c16) {
                        }
                        break;
                    case 1643267187:
                        if (str.equals("effectLevel")) {
                            c16 = '\t';
                        }
                        switch (c16) {
                        }
                        break;
                    default:
                        switch (c16) {
                        }
                        break;
                }
            }
        }
        for (giftMidgroundPanel$MapFieldEntry giftmidgroundpanel_mapfieldentry2 : giftmidgroundpanel_iteminfo.resource.get().images.get()) {
            if (giftmidgroundpanel_mapfieldentry2.key.get().equals("dynamicPreviewImage.png")) {
                dVar.Q = giftmidgroundpanel_mapfieldentry2.value.get();
            } else if (giftmidgroundpanel_mapfieldentry2.key.get().equals("staticPreviewImage.png")) {
                dVar.R = giftmidgroundpanel_mapfieldentry2.value.get();
            }
        }
        giftMidgroundPanel$TagInfo giftmidgroundpanel_taginfo = giftmidgroundpanel_giftitem.tag_item.get();
        if (giftmidgroundpanel_taginfo != null) {
            dVar.W = giftmidgroundpanel_taginfo.icon_url.get();
            dVar.Z = giftmidgroundpanel_taginfo.pos.get();
            dVar.Y = giftmidgroundpanel_taginfo.f381631id.get();
            dVar.X = giftmidgroundpanel_taginfo.name.get();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> O0(List<giftMidgroundPanel$GiftItem> list) {
        ArrayList arrayList = new ArrayList();
        try {
            for (giftMidgroundPanel$GiftItem giftmidgroundpanel_giftitem : list) {
                d dVar = new d();
                N0(giftmidgroundpanel_giftitem, dVar);
                arrayList.add(dVar);
            }
        } catch (Exception e16) {
            QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean P0(e.a aVar, giftMidgroundPanel$SsoGetSceneItemRsp giftmidgroundpanel_ssogetsceneitemrsp) {
        giftMidgroundPanel$WelfareInfo giftmidgroundpanel_welfareinfo = giftmidgroundpanel_ssogetsceneitemrsp.welfare_info.get();
        if (giftmidgroundpanel_welfareinfo != null) {
            boolean z16 = giftmidgroundpanel_welfareinfo.is_open.get();
            aVar.f264901b = giftmidgroundpanel_welfareinfo.tab_name.get();
            aVar.f264902c = giftmidgroundpanel_welfareinfo.url.get();
            return z16;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q0(d dVar, int i3, int i16, rh2.f fVar, boolean z16, int i17, String str) {
        if (z16) {
            b1(dVar, i3, i16, fVar);
        } else if (i17 == -11153 && !this.f311506k) {
            b1(dVar, i3, i16, fVar);
        } else {
            h1(i17, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R0(int i3, int i16, rh2.f fVar, boolean z16, int i17, String str) {
        if (z16) {
            c1(i3, i16, fVar);
            return;
        }
        QLog.e("VasGiftServiceModuleImpl", 1, "\u672a\u6210\u5e74\u4eba\u8ba4\u8bc1\u5931\u8d25" + i17 + ", " + str);
        if (i17 == -11153 && !this.f311506k) {
            c1(i3, i16, fVar);
        } else {
            h1(i17, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d S0(giftMidgroundPanel$PackageGiftItem giftmidgroundpanel_packagegiftitem) {
        d dVar = new d();
        if (giftmidgroundpanel_packagegiftitem != null) {
            N0(giftmidgroundpanel_packagegiftitem.gift_item.get(), dVar);
            dVar.f264875d0 = true;
            dVar.f264877e0 = giftmidgroundpanel_packagegiftitem.total_num.get();
            ArrayList arrayList = new ArrayList();
            if (giftmidgroundpanel_packagegiftitem.expire_info.get() != null) {
                for (giftMidgroundPanel$RecentExpireInfo giftmidgroundpanel_recentexpireinfo : giftmidgroundpanel_packagegiftitem.expire_info.get()) {
                    d.b bVar = new d.b();
                    bVar.f264890b = giftmidgroundpanel_recentexpireinfo.expire_num.get();
                    bVar.f264889a = giftmidgroundpanel_recentexpireinfo.expire_time.get();
                    arrayList.add(bVar);
                }
            }
            dVar.f264879f0 = arrayList;
        }
        return dVar;
    }

    private dn0.a T0(d dVar, int i3, long j3, int i16) {
        dn0.a aVar = new dn0.a();
        if (this.f311500e != null) {
            aVar.f394286a = c();
            com.tencent.mobileqq.qqgift.data.service.c cVar = this.f311500e;
            aVar.f394287b = cVar.f264860a;
            aVar.f394288c = cVar.f264861b;
            aVar.f394289d = dVar.f264874d;
            aVar.f394290e = i3;
            aVar.f394291f = j3;
            aVar.f394292g = i16;
            aVar.f394293h = i16;
            aVar.f394294i = dVar.f264875d0;
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : this.f311500e.f264870k.entrySet()) {
                cn0.a aVar2 = new cn0.a();
                aVar2.f31132a = entry.getKey();
                aVar2.f31133b = entry.getValue();
                arrayList.add(aVar2);
            }
            aVar.f394295j = (cn0.a[]) arrayList.toArray(new cn0.a[arrayList.size()]);
        }
        return aVar;
    }

    private dn0.b U0(@NonNull d dVar, int i3, int i16, rh2.f fVar) {
        dn0.b bVar = new dn0.b();
        if (this.f311500e != null) {
            bVar.f394296a = c();
            com.tencent.mobileqq.qqgift.data.service.c cVar = this.f311500e;
            bVar.f394297b = cVar.f264860a;
            bVar.f394298c = cVar.f264861b;
            bVar.f394299d = dVar.f264874d;
            bVar.f394300e = dVar.D;
            String a16 = cVar.a();
            String str = "";
            if (a16 == null) {
                a16 = "";
            }
            bVar.f394302g = a16;
            bVar.f394303h = dVar.H;
            bVar.f394304i = i3;
            bVar.f394305j = i16;
            bVar.f394306k = dVar.f264875d0;
            String A0 = A0(fVar, bVar, this.f311500e.a());
            if (A0 != null) {
                str = A0;
            }
            bVar.f394301f = str;
            ArrayList arrayList = new ArrayList();
            ConcurrentHashMap<String, String> concurrentHashMap = this.f311500e.f264870k;
            if (concurrentHashMap != null) {
                for (Map.Entry<String, String> entry : concurrentHashMap.entrySet()) {
                    cn0.a aVar = new cn0.a();
                    aVar.f31132a = entry.getKey();
                    aVar.f31133b = entry.getValue();
                    arrayList.add(aVar);
                }
            }
            bVar.f394307l = (cn0.a[]) arrayList.toArray(new cn0.a[arrayList.size()]);
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean V0(boolean z16) {
        if (!z16 || !VasToggle.isEnable(VasToggle.VAS_GIFT_PACKAGE_ENABLE, false)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean W0(boolean z16) {
        if (z16 && VasNormalToggle.VAS_GIFT_SHOW_WELFARE.isEnable(true)) {
            return true;
        }
        return false;
    }

    private void X0(rh2.f fVar, int i3, String str) {
        if (fVar != null) {
            fVar.onFailed(i3, str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasGiftServiceModuleImpl", 2, "giftSendCallback code " + i3);
        }
    }

    @NonNull
    private sendgift$OrderInfo Y0(com.tencent.mobileqq.qqgift.data.service.c cVar, long j3, long j16) {
        String str = cVar.f264870k.get(IYunGameConstant.KEY_AUTH_KEY);
        cVar.f264870k.remove(IYunGameConstant.KEY_AUTH_KEY);
        sendgift$OrderInfo sendgift_orderinfo = new sendgift$OrderInfo();
        sendgift_orderinfo.gift_id.set(cVar.f264862c);
        sendgift$Token sendgift_token = new sendgift$Token();
        sendgift_token.open_id.set(String.valueOf(j3));
        PBStringField pBStringField = sendgift_token.open_key;
        if (str == null) {
            str = "";
        }
        pBStringField.set(str);
        sendgift_token.token_type.set(4);
        sendgift_token.connect_appid.set(0);
        sendgift_token.domain_id.set(5);
        sendgift_orderinfo.sender.set(sendgift_token);
        sendgift$Token sendgift_token2 = new sendgift$Token();
        sendgift_token2.open_id.set(String.valueOf(j16));
        sendgift_token2.open_key.set("");
        sendgift_token2.token_type.set(0);
        sendgift_token2.connect_appid.set(0);
        sendgift_token2.domain_id.set(5);
        sendgift_orderinfo.recver.set(sendgift_token2);
        sendgift_orderinfo.create_time.set(System.currentTimeMillis());
        sendgift_orderinfo.polaris_services.set(WadlProxyConsts.CHANNEL);
        return sendgift_orderinfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(String str) {
        try {
            VasLogReporter.getVasGift().report(str, VasLogReportProxy.LEVEL.HIGHEST);
        } catch (Exception e16) {
            QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<com.tencent.mobileqq.qqgift.data.service.e> a1(giftMidgroundPanel$SceneItem giftmidgroundpanel_sceneitem, boolean z16, boolean z17, e.a aVar) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (giftmidgroundpanel_sceneitem != null) {
            try {
                if (giftmidgroundpanel_sceneitem.items.get() != null) {
                    for (giftMidgroundPanel$TabItem giftmidgroundpanel_tabitem : giftmidgroundpanel_sceneitem.items.get()) {
                        com.tencent.mobileqq.qqgift.data.service.e eVar = new com.tencent.mobileqq.qqgift.data.service.e();
                        eVar.f264894a = giftmidgroundpanel_tabitem.f381630id.get();
                        eVar.f264895b = giftmidgroundpanel_tabitem.name.get();
                        eVar.f264896c = giftmidgroundpanel_tabitem.desc.get();
                        eVar.f264897d = giftmidgroundpanel_tabitem.enable_desc.get();
                        List<d> O0 = O0(giftmidgroundpanel_tabitem.items.get());
                        String str2 = eVar.f264894a;
                        String str3 = eVar.f264895b;
                        if (eVar.f264897d) {
                            str = eVar.f264896c;
                        } else {
                            str = "";
                        }
                        eVar.f264898e = u0(O0, str2, str3, str, str2.equals("PACKAGE_TAB_ID"));
                        arrayList.add(eVar);
                    }
                }
            } catch (Exception e16) {
                QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
            }
        }
        if (z16) {
            t0(arrayList, null, null);
        }
        if (z17) {
            v0(arrayList, aVar);
        }
        return arrayList;
    }

    private void b1(d dVar, int i3, int i16, rh2.f fVar) {
        dn0.b U0 = U0(dVar, i3, i16, fVar);
        l1(dVar, U0);
        k1(dVar);
        y0(dVar, fVar, U0);
    }

    private void c1(int i3, int i16, rh2.f fVar) {
        dn0.b bVar = new dn0.b();
        if (this.f311500e != null) {
            bVar.f394296a = c();
            com.tencent.mobileqq.qqgift.data.service.c cVar = this.f311500e;
            bVar.f394297b = cVar.f264860a;
            bVar.f394298c = cVar.f264861b;
            bVar.f394299d = i3;
            bVar.f394300e = i16;
            String a16 = cVar.a();
            String str = "";
            if (a16 == null) {
                a16 = "";
            }
            bVar.f394302g = a16;
            bVar.f394303h = 0L;
            bVar.f394304i = 0;
            bVar.f394305j = 0;
            com.tencent.mobileqq.qqgift.data.service.c cVar2 = this.f311500e;
            bVar.f394306k = cVar2.f264864e;
            String A0 = A0(fVar, bVar, cVar2.a());
            if (A0 != null) {
                str = A0;
            }
            bVar.f394301f = str;
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, String> entry : this.f311500e.f264870k.entrySet()) {
                cn0.a aVar = new cn0.a();
                aVar.f31132a = entry.getKey();
                aVar.f31133b = entry.getValue();
                arrayList.add(aVar);
            }
            bVar.f394307l = (cn0.a[]) arrayList.toArray(new cn0.a[arrayList.size()]);
            if (this.f311500e.f264866g) {
                x0(fVar, bVar);
                return;
            }
        }
        y0(null, fVar, bVar);
    }

    private sendgift$ConsumeOverReq d1(d dVar, dn0.a aVar) {
        AppRuntime appRuntime;
        sendgift$ConsumeOverReq sendgift_consumeoverreq = new sendgift$ConsumeOverReq();
        sendgift_consumeoverreq.req_msg.set(ByteStringMicro.copyFrom(MessageNano.toByteArray(aVar)));
        sendgift$OrderInfo sendgift_orderinfo = new sendgift$OrderInfo();
        sendgift_orderinfo.gift_id.set(aVar.f394289d);
        sendgift$Token sendgift_token = new sendgift$Token();
        sendgift_token.open_id.set(String.valueOf(aVar.f394287b));
        nh2.c cVar = this.f311497b;
        if (cVar != null) {
            appRuntime = cVar.getAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            appRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        }
        sendgift_token.open_key.set(VasSkey.getPSkey(appRuntime, "qzone.qq.com"));
        sendgift_token.token_type.set(4);
        sendgift_token.connect_appid.set(0);
        sendgift_token.domain_id.set(5);
        sendgift_orderinfo.sender.set(sendgift_token);
        sendgift$Token sendgift_token2 = new sendgift$Token();
        sendgift_token2.open_id.set(String.valueOf(aVar.f394288c));
        sendgift_token2.open_key.set("");
        sendgift_token2.token_type.set(0);
        sendgift_token2.connect_appid.set(0);
        sendgift_token2.domain_id.set(5);
        sendgift_orderinfo.recver.set(sendgift_token2);
        sendgift_orderinfo.create_time.set(System.currentTimeMillis());
        sendgift_orderinfo.polaris_services.set("");
        sendgift_consumeoverreq.info.set(sendgift_orderinfo);
        sendgift_consumeoverreq.scene_id.set(c());
        sendgift_consumeoverreq.combo_seq.set(aVar.f394291f);
        sendgift_consumeoverreq.combo_cnt.set(aVar.f394292g);
        sendgift_consumeoverreq.all_combo_cnt.set(aVar.f394293h);
        sendgift_consumeoverreq.pay_from.set(aVar.f394294i ? 1 : 0);
        sendgift_consumeoverreq.plat.set(119);
        sendgift_consumeoverreq.ext_dict.set(C0(dVar, this.f311500e));
        return sendgift_consumeoverreq;
    }

    private void e1(d dVar, dn0.b bVar, String str) {
        AppRuntime appRuntime;
        if (this.f311498c.scene_id.get() != 10010) {
            this.f311498c.req_msg.set(ByteStringMicro.copyFrom(MessageNano.toByteArray(bVar)));
            sendgift$OrderInfo sendgift_orderinfo = new sendgift$OrderInfo();
            sendgift_orderinfo.gift_id.set(bVar.f394299d);
            sendgift$Token sendgift_token = new sendgift$Token();
            sendgift_token.open_id.set(String.valueOf(bVar.f394297b));
            nh2.c cVar = this.f311497b;
            if (cVar != null) {
                appRuntime = cVar.getAppRuntime();
            } else {
                appRuntime = null;
            }
            if (appRuntime == null) {
                appRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            }
            String pSkey = VasSkey.getPSkey(appRuntime, "qzone.qq.com");
            PBStringField pBStringField = sendgift_token.open_key;
            if (pSkey == null) {
                pSkey = "";
            }
            pBStringField.set(pSkey);
            sendgift_token.token_type.set(4);
            sendgift_token.connect_appid.set(0);
            sendgift_token.domain_id.set(5);
            sendgift_orderinfo.sender.set(sendgift_token);
            sendgift$Token sendgift_token2 = new sendgift$Token();
            sendgift_token2.open_id.set(String.valueOf(bVar.f394298c));
            sendgift_token2.open_key.set("");
            sendgift_token2.token_type.set(0);
            sendgift_token2.connect_appid.set(0);
            sendgift_token2.domain_id.set(5);
            sendgift_orderinfo.recver.set(sendgift_token2);
            sendgift_orderinfo.create_time.set(System.currentTimeMillis());
            sendgift_orderinfo.polaris_services.set("");
            this.f311498c.info.set(sendgift_orderinfo);
            this.f311498c.scene_id.set(c());
            this.f311498c.combo_seq.set(bVar.f394303h);
            this.f311498c.combo_cnt.set(bVar.f394304i);
            this.f311498c.all_combo_cnt.set(bVar.f394305j);
            this.f311498c.plat.set(119);
            this.f311498c.report_ext.set(H0(bVar.f394302g));
        }
        List<sendgift$ExtData> C0 = C0(dVar, this.f311500e);
        sendgift$ExtData sendgift_extdata = new sendgift$ExtData();
        sendgift_extdata.ext_key.set("req_timestamp");
        sendgift_extdata.ext_value.set(str);
        this.f311498c.pay_from.set(bVar.f394306k ? 1 : 0);
        this.f311498c.send_type.set(L0(x()));
        this.f311498c.ext_dict.set(C0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0025. Please report as an issue. */
    public void f1(List<giftMidgroundPanel$MapFieldEntry> list) {
        this.f311496a = new f();
        for (giftMidgroundPanel$MapFieldEntry giftmidgroundpanel_mapfieldentry : list) {
            String str = giftmidgroundpanel_mapfieldentry.key.get();
            str.hashCode();
            char c16 = '\uffff';
            switch (str.hashCode()) {
                case 188134865:
                    if (str.equals("isOpenFreeCoin")) {
                        c16 = 0;
                        break;
                    }
                    break;
                case 398146376:
                    if (str.equals("freeCoinName")) {
                        c16 = 1;
                        break;
                    }
                    break;
                case 844134674:
                    if (str.equals("freeCoinUrl")) {
                        c16 = 2;
                        break;
                    }
                    break;
            }
            switch (c16) {
                case 0:
                    this.f311496a.f264903a = giftmidgroundpanel_mapfieldentry.value.get();
                    break;
                case 1:
                    this.f311496a.f264904b = giftmidgroundpanel_mapfieldentry.value.get();
                    break;
                case 2:
                    this.f311496a.f264905c = giftmidgroundpanel_mapfieldentry.value.get();
                    break;
            }
        }
    }

    private void g1(com.tencent.mobileqq.qqgift.data.service.c cVar) {
        long j3 = cVar.f264860a;
        long j16 = cVar.f264861b;
        this.f311498c.info.set(Y0(cVar, j3, j16));
        String str = cVar.f264870k.get("key_req_msg");
        if (str != null) {
            this.f311498c.req_msg.set(ByteStringMicro.copyFrom(PluginBaseInfoHelper.Base64Helper.decode(str, 0)));
            this.f311498c.scene_id.set(c());
            this.f311498c.plat.set(119);
            this.f311498c.pay_from.set(cVar.f264865f ? 1 : 0);
            cVar.f264870k.remove("key_req_msg");
        }
        com.tencent.mobileqq.qqgift.data.service.c cVar2 = this.f311500e;
        if (cVar2 != null) {
            cVar2.f264860a = j3;
            cVar2.f264861b = j16;
            cVar2.f264869j = cVar.f264869j;
            cVar2.f264870k = cVar.f264870k;
        }
    }

    private void h1(int i3, String str) {
        QLog.e("VasGiftServiceModuleImpl", 1, "\u672a\u6210\u5e74\u4eba\u8ba4\u8bc1\u5931\u8d25" + i3 + ", " + str);
        if (i3 == -11153) {
            if (this.f311506k) {
                QQToast.makeText(BaseApplication.getContext(), "\u672a\u5b9e\u540d\u8ba4\u8bc1", 1).show();
            }
        } else if (i3 == -11154) {
            QQToast.makeText(BaseApplication.getContext(), "\u672a\u6ee118\u5468\u5c81\u4ed8\u8d39\u529f\u80fd\u6682\u4e0d\u53ef\u7528", 1).show();
        } else {
            QQToast.makeText(BaseApplication.getContext(), str, 1).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<Long> i1(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(Long.parseLong(it.next())));
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> j1(List<com.tencent.mobileqq.qqgift.data.service.e> list) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    for (com.tencent.mobileqq.qqgift.data.service.e eVar : list) {
                        List<d> list2 = eVar.f264898e;
                        String str2 = eVar.f264894a;
                        String str3 = eVar.f264895b;
                        if (eVar.f264897d) {
                            str = eVar.f264896c;
                        } else {
                            str = "";
                        }
                        arrayList.addAll(u0(list2, str2, str3, str, str2.equals("PACKAGE_TAB_ID")));
                    }
                }
            } catch (Exception e16) {
                QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
            }
        }
        return arrayList;
    }

    private void k1(@NonNull d dVar) {
        ConcurrentHashMap<Long, d43.a> concurrentHashMap = this.f311501f;
        if (concurrentHashMap != null) {
            if (concurrentHashMap.containsKey(Long.valueOf(dVar.H))) {
                d43.a aVar = this.f311501f.get(Long.valueOf(dVar.H));
                if (aVar != null) {
                    aVar.f392789a.incrementAndGet();
                    return;
                }
                return;
            }
            this.f311501f.put(Long.valueOf(dVar.H), new d43.a(new AtomicInteger(1)));
        }
    }

    private void l1(d dVar, dn0.b bVar) {
        if (dVar.K == 0) {
            dVar.K = bVar.f394298c;
        }
        if (dVar.M == null && bVar.f394307l.length > 0) {
            HashMap hashMap = new HashMap();
            for (cn0.a aVar : bVar.f394307l) {
                hashMap.put(aVar.f31132a, aVar.f31133b);
            }
            dVar.M = hashMap;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(List<com.tencent.mobileqq.qqgift.data.service.e> list, List<d> list2, e.a aVar) {
        boolean z16;
        if (list == null) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        if (list2 != null && !list2.isEmpty()) {
            u0(list2, "PACKAGE_TAB_ID", BaseApplication.getContext().getString(R.string.f209925gq), "", true);
        } else {
            list2 = arrayList;
        }
        Iterator<com.tencent.mobileqq.qqgift.data.service.e> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                com.tencent.mobileqq.qqgift.data.service.e next = it.next();
                if (next.f264894a.equals("PACKAGE_TAB_ID")) {
                    next.f264898e = list2;
                    next.f264899f = aVar;
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            com.tencent.mobileqq.qqgift.data.service.e eVar = new com.tencent.mobileqq.qqgift.data.service.e();
            eVar.f264894a = "PACKAGE_TAB_ID";
            nh2.c cVar = this.f311497b;
            if (cVar != null && cVar.getSDKConfig() != null && (this.f311497b.getSDKConfig().f264972a == 10011 || this.f311497b.getSDKConfig().f264972a == 10008)) {
                eVar.f264895b = BaseApplication.getContext().getString(R.string.f210045h2);
            } else {
                eVar.f264895b = BaseApplication.getContext().getString(R.string.f209925gq);
            }
            eVar.f264897d = true;
            eVar.f264899f = aVar;
            eVar.f264898e = list2;
            list.add(eVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<d> u0(List<d> list, String str, String str2, String str3, boolean z16) {
        if (list == null) {
            return new ArrayList();
        }
        for (d dVar : list) {
            dVar.V = str;
            dVar.U = str2;
            dVar.S = str3;
            dVar.f264875d0 = z16;
        }
        return list;
    }

    private void v0(List<com.tencent.mobileqq.qqgift.data.service.e> list, e.a aVar) {
        boolean z16;
        if (list == null) {
            list = new ArrayList<>();
        }
        Iterator<com.tencent.mobileqq.qqgift.data.service.e> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                com.tencent.mobileqq.qqgift.data.service.e next = it.next();
                if (next.f264894a.equals("WELFARE_TAB_ID")) {
                    next.f264898e = new ArrayList();
                    next.f264899f = aVar;
                    z16 = true;
                    break;
                }
            } else {
                z16 = false;
                break;
            }
        }
        if (!z16) {
            com.tencent.mobileqq.qqgift.data.service.e eVar = new com.tencent.mobileqq.qqgift.data.service.e();
            eVar.f264894a = "WELFARE_TAB_ID";
            eVar.f264895b = aVar.f264901b;
            eVar.f264897d = false;
            eVar.f264899f = aVar;
            eVar.f264898e = new ArrayList();
            list.add(eVar);
        }
    }

    private List<d.a> w0(giftMidgroundPanel$GiftItem giftmidgroundpanel_giftitem) {
        PBRepeatMessageField<giftMidgroundPanel$BatchGift> pBRepeatMessageField;
        int size;
        giftMidgroundPanel$BatchPackage giftmidgroundpanel_batchpackage = giftmidgroundpanel_giftitem.batch_send_info;
        if (giftmidgroundpanel_batchpackage == null || (pBRepeatMessageField = giftmidgroundpanel_batchpackage.batch_gifts) == null || (size = pBRepeatMessageField.size()) == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < size; i3++) {
            d.a aVar = new d.a();
            aVar.f264885a = pBRepeatMessageField.get(i3).f381622id.get();
            aVar.f264886b = pBRepeatMessageField.get(i3).cnt.get();
            aVar.f264887c = pBRepeatMessageField.get(i3).f381623msg.get();
            aVar.f264888d = pBRepeatMessageField.get(i3).is_effect.get();
            arrayList.add(aVar);
        }
        return arrayList;
    }

    private void x0(final rh2.f fVar, dn0.b bVar) {
        String str;
        try {
            VasUtil.getService().getPbRequest().request("trpc.qqva.midground_sendgift.Sendgift.SsoBatchConsume", new String(this.f311499d.toByteArray(), "ISO8859_1"), new BusinessObserver() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.4
                /* JADX WARN: Removed duplicated region for block: B:23:0x0138 A[Catch: Exception -> 0x0154, TRY_LEAVE, TryCatch #0 {Exception -> 0x0154, blocks: (B:7:0x0013, B:10:0x002c, B:13:0x003a, B:15:0x0071, B:17:0x007d, B:19:0x008d, B:20:0x00a5, B:21:0x0132, B:23:0x0138, B:28:0x00cf, B:29:0x00d9, B:31:0x00df, B:33:0x00ef, B:35:0x00ff, B:37:0x010b, B:39:0x011b, B:40:0x012c), top: B:6:0x0013 }] */
                /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
                @Override // com.tencent.mobileqq.app.BusinessObserver
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onUpdate(int i3, boolean z16, Object obj) {
                    if (z16 && i3 == 0 && obj != null) {
                        final sendgift$BatchConsumeRsp sendgift_batchconsumersp = new sendgift$BatchConsumeRsp();
                        try {
                            sendgift_batchconsumersp.mergeFrom((byte[]) obj);
                            final ArrayList arrayList = new ArrayList();
                            if (sendgift_batchconsumersp.ret.get() != 0 && sendgift_batchconsumersp.ret.get() != -11008) {
                                QLog.e("VasGiftServiceModuleImpl", 1, "consumeBatchedRequest failed ret=" + sendgift_batchconsumersp.ret.get() + ", msg=" + sendgift_batchconsumersp.f381635msg.get());
                                ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.4.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fVar.onFailed((int) sendgift_batchconsumersp.ret.get(), sendgift_batchconsumersp.f381635msg.get());
                                    }
                                });
                                if (VasGiftServiceModuleImpl.this.f311497b != null && VasGiftServiceModuleImpl.this.f311497b.d() != null && VasGiftServiceModuleImpl.this.f311497b.d().O() != null) {
                                    VasGiftServiceModuleImpl.this.f311497b.d().O().e(false, (int) sendgift_batchconsumersp.ret.get(), "");
                                }
                                VasGiftServiceModuleImpl.this.Z0("consumeBatchedRequest failed:ret=" + sendgift_batchconsumersp.ret.get() + ", msg=" + sendgift_batchconsumersp.f381635msg.get());
                                if (!QLog.isColorLevel()) {
                                    VasGiftServiceModuleImpl.this.Z0("consumeBatchedRequest rsp:" + OidbWrapper.proto2String(sendgift_batchconsumersp));
                                    return;
                                }
                                return;
                            }
                            Iterator<sendgift$BatchErrInfo> it = sendgift_batchconsumersp.errs.get().iterator();
                            while (it.hasNext()) {
                                arrayList.add(it.next().receiver_open_id.get());
                            }
                            ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    fVar.f(null);
                                    rh2.f fVar2 = fVar;
                                    if (fVar2 instanceof rh2.b) {
                                        ((rh2.b) fVar2).i(arrayList, (int) sendgift_batchconsumersp.ret.get());
                                    }
                                }
                            });
                            if (VasGiftServiceModuleImpl.this.f311497b != null && VasGiftServiceModuleImpl.this.f311497b.d() != null && VasGiftServiceModuleImpl.this.f311497b.d().O() != null) {
                                VasGiftServiceModuleImpl.this.f311497b.d().O().e(true, 0, "");
                            }
                            QLog.e("VasGiftServiceModuleImpl", 1, "consumeBatchedRequest success");
                            if (!QLog.isColorLevel()) {
                            }
                        } catch (Exception e16) {
                            QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
                            VasGiftServiceModuleImpl.this.Z0("consumeBatchedRequest crash:" + e16);
                        }
                    } else {
                        QLog.e("VasGiftServiceModuleImpl", 1, "consumeBatchedRequest error! isSuccess=" + z16 + ",type=" + i3);
                        VasGiftServiceModuleImpl.this.Z0("consumeBatchedRequest req error:isSuccess=" + z16 + ",type=" + i3);
                    }
                }
            });
            if (QLog.isColorLevel()) {
                str = "consumeBatchedRequest req:" + OidbWrapper.proto2String(this.f311498c);
            } else {
                str = "consumeCurrency req";
            }
            Z0(str);
        } catch (Exception e16) {
            QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
            Z0("consumeBatchedRequest crash:" + e16);
        }
    }

    private void y0(d dVar, final rh2.f fVar, dn0.b bVar) {
        String str;
        try {
            final String valueOf = String.valueOf(System.currentTimeMillis());
            e1(dVar, bVar, valueOf);
            VasUtil.getService().getPbRequest().request("trpc.qqva.midground_sendgift.Sendgift.SsoConsume", new String(this.f311498c.toByteArray(), "ISO8859_1"), new BusinessObserver() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.5
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public void onUpdate(int i3, boolean z16, Object obj) {
                    if (z16 && i3 == 0 && obj != null) {
                        final sendgift$ConsumeRsp sendgift_consumersp = new sendgift$ConsumeRsp();
                        try {
                            sendgift_consumersp.mergeFrom((byte[]) obj);
                            if (sendgift_consumersp.ret.get() == 0) {
                                ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.5.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fVar.f(null);
                                    }
                                });
                                if (VasGiftServiceModuleImpl.this.f311497b != null && VasGiftServiceModuleImpl.this.f311497b.d() != null && VasGiftServiceModuleImpl.this.f311497b.d().O() != null) {
                                    VasGiftServiceModuleImpl.this.f311497b.d().O().e(true, 0, valueOf);
                                }
                                QLog.e("VasGiftServiceModuleImpl", 1, "consumeCurrency success");
                            } else {
                                QLog.e("VasGiftServiceModuleImpl", 1, "consumeCurrency failed ret=" + sendgift_consumersp.ret.get() + ", msg=" + sendgift_consumersp.f381637msg.get());
                                ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.5.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fVar.onFailed((int) sendgift_consumersp.ret.get(), sendgift_consumersp.f381637msg.get());
                                    }
                                });
                                if (VasGiftServiceModuleImpl.this.f311497b != null && VasGiftServiceModuleImpl.this.f311497b.d() != null && VasGiftServiceModuleImpl.this.f311497b.d().O() != null) {
                                    VasGiftServiceModuleImpl.this.f311497b.d().O().e(false, (int) sendgift_consumersp.ret.get(), valueOf);
                                }
                                VasGiftServiceModuleImpl.this.Z0("consumeCurrency failed:ret=" + sendgift_consumersp.ret.get() + ", msg=" + sendgift_consumersp.f381637msg.get());
                            }
                            if (QLog.isColorLevel()) {
                                VasGiftServiceModuleImpl.this.Z0("consumeCurrency rsp:" + OidbWrapper.proto2String(sendgift_consumersp));
                                return;
                            }
                            return;
                        } catch (Exception e16) {
                            QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
                            VasGiftServiceModuleImpl.this.Z0("consumeCurrency crash:" + e16);
                            return;
                        }
                    }
                    QLog.e("VasGiftServiceModuleImpl", 1, "consumeCurrency error! isSuccess=" + z16 + ",type=" + i3);
                    VasGiftServiceModuleImpl.this.Z0("consumeCurrency req error:isSuccess=" + z16 + ",type=" + i3);
                }
            });
            if (QLog.isColorLevel()) {
                str = "consumeCurrency req:" + OidbWrapper.proto2String(this.f311498c);
            } else {
                str = "consumeCurrency req";
            }
            Z0(str);
        } catch (Exception e16) {
            QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
            Z0("consumeCurrency crash:" + e16);
        }
    }

    private void z0(d dVar, dn0.a aVar, QQGiftSendGiftReportHelper.SendGiftReportData sendGiftReportData) {
        String str;
        if (aVar == null) {
            QLog.e("VasGiftServiceModuleImpl", 1, "doSendComboOver req is null!");
            if (sendGiftReportData == null) {
                QQGiftSendGiftReportHelper.a(true, new QQGiftSendGiftReportHelper.SendGiftReportData("doSendComboOver req is null and reportData is null!"));
                return;
            }
            sendGiftReportData.D = (System.nanoTime() - sendGiftReportData.D) / 1000000;
            sendGiftReportData.C = "doSendComboOver req is null!";
            QQGiftSendGiftReportHelper.a(true, sendGiftReportData);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasGiftServiceModuleImpl", 2, "doSendComboOver giftId:" + aVar.f394289d + ", seq:" + aVar.f394291f);
        }
        Bundle bundle = new Bundle();
        if (sendGiftReportData != null) {
            bundle.putParcelable("extra_send_gift_report_data", sendGiftReportData);
        }
        try {
            sendgift$ConsumeOverReq d16 = d1(dVar, aVar);
            VasUtil.getService().getPbRequest().request("trpc.qqva.midground_sendgift.Sendgift.SsoConsumeOver", new String(d16.toByteArray(), "ISO8859_1"), new b());
            if (QLog.isColorLevel()) {
                str = "doSendComboOver req:" + OidbWrapper.proto2String(d16);
            } else {
                str = "doSendComboOver req";
            }
            Z0(str);
        } catch (Exception e16) {
            QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
            Z0("doSendComboOver crash:" + e16);
        }
    }

    @Override // oh2.b
    public void B(Activity activity, final d dVar, final int i3, final int i16, final rh2.f fVar) {
        if (dVar == null) {
            QLog.e("VasGiftServiceModuleImpl", 1, "sendComboGift data is null!");
            QQGiftSendGiftReportHelper.a(false, new QQGiftSendGiftReportHelper.SendGiftReportData("sendComboGift data is null!"));
        } else if (dVar.F == 1) {
            b1(dVar, i3, i16, fVar);
        } else {
            this.f311497b.e().m(activity, this.f311506k, new c.a() { // from class: com.tencent.mobileqq.vasgift.business.common.service.b
                @Override // oh2.c.a
                public final void a(boolean z16, int i17, String str) {
                    VasGiftServiceModuleImpl.this.Q0(dVar, i3, i16, fVar, z16, i17, str);
                }
            });
        }
    }

    @Override // oh2.b
    public List<d> D() {
        return j1(com.tencent.mobileqq.vasgift.business.common.service.a.e().c(E0()));
    }

    public void D0(List<Long> list, final rh2.e eVar) {
        String str;
        if (list != null && !list.isEmpty()) {
            giftMidgroundPanel$SsoGetGiftItemsReq giftmidgroundpanel_ssogetgiftitemsreq = new giftMidgroundPanel$SsoGetGiftItemsReq();
            giftmidgroundpanel_ssogetgiftitemsreq.ids.addAll(list);
            try {
                VasUtil.getService().getPbRequest().request("trpc.qqva.gift_midground_panel.GiftMidgroundPanel.SsoGetGiftItems", new String(giftmidgroundpanel_ssogetgiftitemsreq.toByteArray(), "ISO8859_1"), new BusinessObserver() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.2
                    @Override // com.tencent.mobileqq.app.BusinessObserver
                    public void onUpdate(int i3, boolean z16, Object obj) {
                        if (z16 && i3 == 0 && obj != null) {
                            final giftMidgroundPanel$SsoGetGiftItemsRsp giftmidgroundpanel_ssogetgiftitemsrsp = new giftMidgroundPanel$SsoGetGiftItemsRsp();
                            try {
                                giftmidgroundpanel_ssogetgiftitemsrsp.mergeFrom((byte[]) obj);
                                if (giftmidgroundpanel_ssogetgiftitemsrsp.code.get() == 0) {
                                    final List<d> O0 = VasGiftServiceModuleImpl.this.O0(giftmidgroundpanel_ssogetgiftitemsrsp.items.get());
                                    com.tencent.mobileqq.vasgift.business.common.service.a.e().n(VasGiftServiceModuleImpl.this.E0(), O0);
                                    ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.2.1
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            eVar.onReceive(O0);
                                            QLog.e("VasGiftServiceModuleImpl", 1, "getGiftIds success");
                                        }
                                    });
                                    if (QLog.isColorLevel()) {
                                        QLog.e("VasGiftServiceModuleImpl", 1, "getGiftIds:" + O0);
                                    }
                                } else {
                                    ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.2.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            eVar.onFailed(giftmidgroundpanel_ssogetgiftitemsrsp.code.get(), giftmidgroundpanel_ssogetgiftitemsrsp.f381627msg.get());
                                            QLog.e("VasGiftServiceModuleImpl", 1, "getGiftIds failed: code=" + giftmidgroundpanel_ssogetgiftitemsrsp.code.get() + ",msg=" + giftmidgroundpanel_ssogetgiftitemsrsp.f381627msg.get());
                                        }
                                    });
                                }
                                if (QLog.isColorLevel()) {
                                    VasGiftServiceModuleImpl.this.Z0("getGiftIds rsp:" + OidbWrapper.proto2String(giftmidgroundpanel_ssogetgiftitemsrsp));
                                    return;
                                }
                                return;
                            } catch (Exception e16) {
                                QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
                                VasGiftServiceModuleImpl.this.Z0("getGiftIds crash:" + e16);
                                return;
                            }
                        }
                        QLog.e("VasGiftServiceModuleImpl", 1, "getGiftIds error! isSuccess=" + z16 + ",type=" + i3);
                        VasGiftServiceModuleImpl.this.Z0("getGiftIds req error:isSuccess=" + z16 + ",type=" + i3);
                    }
                });
                if (QLog.isColorLevel()) {
                    str = "getGiftIds req:" + OidbWrapper.proto2String(giftmidgroundpanel_ssogetgiftitemsreq);
                } else {
                    str = "getGiftIds req";
                }
                Z0(str);
            } catch (Exception e16) {
                QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
                Z0("getGiftIds crash:" + e16);
            }
        }
    }

    @Override // oh2.b
    public void F(final rh2.a aVar) {
        try {
            midasPayCoinb$GetChargeProductReq midaspaycoinb_getchargeproductreq = new midasPayCoinb$GetChargeProductReq();
            midaspaycoinb_getchargeproductreq.access_appid.set(Integer.parseInt(G0()));
            VasUtil.getService().getPbRequest().request("trpc.common_pay.midas_pay.MidasPayCoinb.SsoGetChargeProduct", new String(midaspaycoinb_getchargeproductreq.toByteArray(), "ISO8859_1"), new BusinessObserver() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.7
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public void onUpdate(final int i3, final boolean z16, final Object obj) {
                    ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.7.1
                        @Override // java.lang.Runnable
                        public void run() {
                            int i16;
                            if (z16 && i3 == 0 && obj != null) {
                                midasPayCoinb$GetChargeProductRsp midaspaycoinb_getchargeproductrsp = new midasPayCoinb$GetChargeProductRsp();
                                try {
                                    midaspaycoinb_getchargeproductrsp.mergeFrom((byte[]) obj);
                                    if (midaspaycoinb_getchargeproductrsp.balance.has() && midaspaycoinb_getchargeproductrsp.balance.first_save.has()) {
                                        i16 = midaspaycoinb_getchargeproductrsp.balance.first_save.get();
                                    } else {
                                        i16 = 0;
                                    }
                                    if (midaspaycoinb_getchargeproductrsp.balance.has()) {
                                        aVar.h(midaspaycoinb_getchargeproductrsp.balance.balance.get(), midaspaycoinb_getchargeproductrsp.balance.marketing_balance.get(), 0L, i16);
                                        return;
                                    }
                                    aVar.h(0L, 0L, 0L, i16);
                                    return;
                                } catch (InvalidProtocolBufferMicroException e16) {
                                    QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
                                    aVar.h(0L, 0L, 0L, 0);
                                    return;
                                }
                            }
                            aVar.h(0L, 0L, 0L, 0);
                        }
                    });
                }
            });
        } catch (Exception e16) {
            QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
            aVar.h(0L, 0L, 0L, 0);
        }
    }

    @Override // oh2.b
    public List<com.tencent.mobileqq.qqgift.data.service.e> H() {
        return com.tencent.mobileqq.vasgift.business.common.service.a.e().c(E0());
    }

    public String I0() {
        String valueOf = String.valueOf(c());
        nh2.c cVar = this.f311497b;
        if (cVar != null && cVar.getSDKConfig() != null && !TextUtils.isEmpty(this.f311497b.getSDKConfig().f264976e)) {
            return this.f311497b.getSDKConfig().f264976e;
        }
        return valueOf;
    }

    @Override // oh2.b
    public void J(com.tencent.mobileqq.qqgift.data.service.a aVar, g gVar) {
        K0(aVar, gVar);
    }

    @Override // oh2.b
    public void K(int i3, rh2.c cVar) {
        try {
            D0(Collections.singletonList(Long.valueOf(i3)), new a(cVar));
        } catch (Exception e16) {
            QLog.e("VasGiftServiceModuleImpl", 1, e16, new Object[0]);
            Z0("getGiftDetail crash:" + e16);
        }
    }

    @Override // oh2.b
    public void L(rh2.d dVar) {
        f fVar = this.f311496a;
        if (fVar != null && fVar.f264903a.equals("true")) {
            giftMidgroundPanel$SsoGetFreeCoinsReq giftmidgroundpanel_ssogetfreecoinsreq = new giftMidgroundPanel$SsoGetFreeCoinsReq();
            giftmidgroundpanel_ssogetfreecoinsreq.business_id.set(String.valueOf(c()));
            try {
                VasUtil.getService().getPbRequest().request("trpc.qqva.midground_sendgift.Sendgift.SsoGetFreeCoins", new String(giftmidgroundpanel_ssogetfreecoinsreq.toByteArray(), "ISO8859_1"), new c(dVar));
                return;
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
                return;
            }
        }
        dVar.onCancel();
    }

    @Override // oh2.b
    public void M(rh2.e eVar) {
        K0(null, eVar);
    }

    @Override // nh2.a
    public void N(nh2.c cVar) {
        this.f311497b = cVar;
        this.f311498c = new sendgift$ConsumeReq();
        this.f311499d = new sendgift$BatchConsumeReq();
        this.f311500e = new com.tencent.mobileqq.qqgift.data.service.c();
        this.f311501f = new ConcurrentHashMap<>();
        k kVar = k.f312037a;
        if (kVar.a(cVar)) {
            this.f311506k = kVar.b(AuthScene.RECHARGE);
        } else {
            this.f311506k = VasToggle.VAS_SEND_GIFT_AUTH_ENABLE.isEnable(false);
        }
    }

    @Override // oh2.b
    public void P(com.tencent.mobileqq.qqgift.data.service.a aVar, rh2.e eVar) {
        K0(aVar, eVar);
    }

    @Override // oh2.b
    public void Q(com.tencent.mobileqq.qqgift.data.service.c cVar) {
        if (!cVar.f264866g) {
            g1(cVar);
            return;
        }
        List<String> list = cVar.f264867h;
        if (list != null && !list.isEmpty()) {
            long j3 = cVar.f264860a;
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                sendgift$BatchSendInfo sendgift_batchsendinfo = new sendgift$BatchSendInfo();
                sendgift_batchsendinfo.infos.set(Y0(cVar, j3, Long.parseLong(str)));
                sendgift_batchsendinfo.ext_dict.set(C0(null, cVar));
                sendgift_batchsendinfo.report_ext.set(H0(cVar.a()));
                arrayList.add(sendgift_batchsendinfo);
            }
            this.f311499d.send_infos.set(arrayList);
            this.f311499d.scene_id.set(c());
            this.f311499d.plat.set(119);
            this.f311499d.pay_from.set(cVar.f264864e ? 1 : 0);
            this.f311499d.send_type.set(L0(cVar));
            this.f311499d.plat.set(119);
            return;
        }
        QLog.e("VasGiftServiceModuleImpl", 1, "isMultiMember but empty list");
    }

    @Override // oh2.b
    public void V(final g gVar) {
        if (gVar == null) {
            return;
        }
        giftMidgroundPanel$GetPackageReq giftmidgroundpanel_getpackagereq = new giftMidgroundPanel$GetPackageReq();
        giftmidgroundpanel_getpackagereq.business_id.set(I0());
        try {
            VasUtil.getService().getPbRequest().request("trpc.qqva.gift_midground_panel.Package.SsoGetPackage", new String(giftmidgroundpanel_getpackagereq.toByteArray(), "ISO8859_1"), new BusinessObserver() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.9
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public void onUpdate(int i3, boolean z16, Object obj) {
                    boolean z17;
                    if (z16 && obj != null) {
                        giftMidgroundPanel$GetPackageRsp giftmidgroundpanel_getpackagersp = new giftMidgroundPanel$GetPackageRsp();
                        try {
                            giftmidgroundpanel_getpackagersp.mergeFrom((byte[]) obj);
                            ArrayList arrayList = new ArrayList();
                            if (giftmidgroundpanel_getpackagersp.gift_items.get() != null) {
                                Iterator<giftMidgroundPanel$PackageGiftItem> it = giftmidgroundpanel_getpackagersp.gift_items.get().iterator();
                                while (it.hasNext()) {
                                    arrayList.add(VasGiftServiceModuleImpl.this.S0(it.next()));
                                }
                            }
                            List<Long> i16 = VasGiftServiceModuleImpl.this.i1(giftmidgroundpanel_getpackagersp.gift_ids.get());
                            if (!i16.isEmpty()) {
                                for (Long l3 : i16) {
                                    Iterator it5 = arrayList.iterator();
                                    while (true) {
                                        if (it5.hasNext()) {
                                            if (l3.intValue() == ((d) it5.next()).f264874d) {
                                                z17 = true;
                                                break;
                                            }
                                        } else {
                                            z17 = false;
                                            break;
                                        }
                                    }
                                    if (!z17) {
                                        d dVar = new d();
                                        dVar.f264874d = l3.intValue();
                                        arrayList.add(dVar);
                                    }
                                }
                            }
                            VasGiftServiceModuleImpl.this.u0(arrayList, "PACKAGE_TAB_ID", BaseApplication.getContext().getString(R.string.f209925gq), "", true);
                            e.a aVar = new e.a();
                            if (giftmidgroundpanel_getpackagersp.empty_info.get() != null) {
                                aVar.f264900a = giftmidgroundpanel_getpackagersp.empty_info.get().empty_msg.get();
                                aVar.f264901b = giftmidgroundpanel_getpackagersp.empty_info.get().button.get();
                                aVar.f264902c = giftmidgroundpanel_getpackagersp.empty_info.get().url.get();
                            }
                            final ArrayList arrayList2 = new ArrayList();
                            VasGiftServiceModuleImpl.this.t0(arrayList2, arrayList, aVar);
                            if (VasGiftServiceModuleImpl.this.f311504i <= giftmidgroundpanel_getpackagersp.time_stamp.get()) {
                                ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.9.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        gVar.onReceive(arrayList2);
                                        VasGiftServiceModuleImpl.this.Z0("getPackageGifts success");
                                    }
                                });
                                VasGiftServiceModuleImpl.this.f311504i = giftmidgroundpanel_getpackagersp.time_stamp.get();
                                if (QLog.isColorLevel()) {
                                    VasGiftServiceModuleImpl.this.Z0("getPackageGifts result: packageGiftData=" + arrayList + ",emptyInfo=" + aVar);
                                    return;
                                }
                                return;
                            }
                            gVar.onFailed(-1, "request error");
                            VasGiftServiceModuleImpl.this.Z0("getPackageGifts req error: not last data");
                            return;
                        } catch (InvalidProtocolBufferMicroException e16) {
                            gVar.onFailed(-1, "request error");
                            e16.printStackTrace();
                            VasGiftServiceModuleImpl.this.Z0("getPackageGifts crash:" + e16);
                            return;
                        }
                    }
                    gVar.onFailed(-1, "request error");
                    VasGiftServiceModuleImpl.this.Z0("getPackageGifts req error:isSuccess=" + z16 + ",type=" + i3);
                }
            });
        } catch (UnsupportedEncodingException e16) {
            gVar.onFailed(-1, "request error");
            e16.printStackTrace();
            Z0("getPackageGifts crash:" + e16);
        }
    }

    @Override // oh2.b
    public f W() {
        return this.f311496a;
    }

    @Override // oh2.b
    public void X(Activity activity, final int i3, int i16, final int i17, final rh2.f fVar) {
        if (i16 == 1) {
            c1(i3, i17, fVar);
        } else {
            this.f311497b.e().m(activity, this.f311506k, new c.a() { // from class: com.tencent.mobileqq.vasgift.business.common.service.c
                @Override // oh2.c.a
                public final void a(boolean z16, int i18, String str) {
                    VasGiftServiceModuleImpl.this.R0(i3, i17, fVar, z16, i18, str);
                }
            });
        }
    }

    @Override // oh2.b
    public String b() {
        if (TextUtils.isEmpty(this.f311503h)) {
            this.f311503h = com.tencent.mobileqq.vasgift.business.common.service.a.e().b(E0());
        }
        return this.f311503h;
    }

    @Override // oh2.b
    public int c() {
        com.tencent.mobileqq.qqgift.sdk.config.a sDKConfig;
        nh2.c cVar = this.f311497b;
        if (cVar != null && (sDKConfig = cVar.getSDKConfig()) != null) {
            com.tencent.mobileqq.qqgift.data.service.a aVar = this.f311502g;
            if (aVar != null) {
                int i3 = aVar.f264855a;
                if (i3 == 2 && sDKConfig.f264972a == 10008) {
                    return 10011;
                }
                if (i3 == 3 && sDKConfig.f264972a == 10008) {
                    return 10013;
                }
            }
            return sDKConfig.f264972a;
        }
        return 0;
    }

    @Override // nh2.a
    public void destroy() {
        this.f311501f = null;
    }

    @Override // oh2.b
    public void o(List<Long> list, final rh2.e eVar) {
        if (eVar == null) {
            return;
        }
        giftMidgroundPanel$GetPackageItemsReq giftmidgroundpanel_getpackageitemsreq = new giftMidgroundPanel$GetPackageItemsReq();
        giftmidgroundpanel_getpackageitemsreq.business_id.set(I0());
        giftmidgroundpanel_getpackageitemsreq.gift_ids.set(list);
        try {
            VasUtil.getService().getPbRequest().request("trpc.qqva.gift_midground_panel.Package.SsoGetPackageItems", new String(giftmidgroundpanel_getpackageitemsreq.toByteArray(), "ISO8859_1"), new BusinessObserver() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.10
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public void onUpdate(int i3, boolean z16, Object obj) {
                    if (z16 && obj != null) {
                        giftMidgroundPanel$GetPackageItemsRsp giftmidgroundpanel_getpackageitemsrsp = new giftMidgroundPanel$GetPackageItemsRsp();
                        try {
                            giftmidgroundpanel_getpackageitemsrsp.mergeFrom((byte[]) obj);
                            final ArrayList arrayList = new ArrayList();
                            if (giftmidgroundpanel_getpackageitemsrsp.gift_items.get() != null) {
                                Iterator<giftMidgroundPanel$PackageGiftItem> it = giftmidgroundpanel_getpackageitemsrsp.gift_items.get().iterator();
                                while (it.hasNext()) {
                                    arrayList.add(VasGiftServiceModuleImpl.this.S0(it.next()));
                                }
                            }
                            VasGiftServiceModuleImpl.this.u0(arrayList, "PACKAGE_TAB_ID", BaseApplication.getContext().getString(R.string.f209925gq), "", true);
                            if (VasGiftServiceModuleImpl.this.f311504i <= giftmidgroundpanel_getpackageitemsrsp.time_stamp.get()) {
                                ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.business.common.service.VasGiftServiceModuleImpl.10.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        eVar.onReceive(arrayList);
                                        VasGiftServiceModuleImpl.this.Z0("getPackageGifts ids success");
                                    }
                                });
                                VasGiftServiceModuleImpl.this.f311504i = giftmidgroundpanel_getpackageitemsrsp.time_stamp.get();
                                if (QLog.isColorLevel()) {
                                    VasGiftServiceModuleImpl.this.Z0("getPackageGifts ids result: packageGiftData=" + arrayList);
                                    return;
                                }
                                return;
                            }
                            eVar.onFailed(-1, "request error");
                            VasGiftServiceModuleImpl.this.Z0("getPackageGifts ids req error: not last data");
                            return;
                        } catch (InvalidProtocolBufferMicroException e16) {
                            eVar.onFailed(-1, "request error");
                            e16.printStackTrace();
                            VasGiftServiceModuleImpl.this.Z0("getPackageGifts ids crash:" + e16);
                            return;
                        }
                    }
                    eVar.onFailed(-1, "request error");
                    VasGiftServiceModuleImpl.this.Z0("getPackageGifts ids req error:isSuccess=" + z16 + ",type=" + i3);
                }
            });
        } catch (UnsupportedEncodingException e16) {
            eVar.onFailed(-1, "request error");
            e16.printStackTrace();
            Z0("getPackageGifts ids crash:" + e16);
        }
    }

    @Override // oh2.b
    public boolean r() {
        if (!this.f311505j) {
            boolean z16 = false;
            if (com.tencent.mobileqq.vasgift.business.common.service.a.e().h(E0()) && VasToggle.isEnable(VasToggle.VAS_GIFT_PACKAGE_ENABLE, false)) {
                z16 = true;
            }
            this.f311505j = z16;
        }
        return this.f311505j;
    }

    @Override // oh2.b
    public List<d> t(com.tencent.mobileqq.qqgift.data.service.a aVar) {
        return j1(com.tencent.mobileqq.vasgift.business.common.service.a.e().c(F0(aVar)));
    }

    @Override // oh2.b
    public void v(List<Long> list, rh2.e eVar) {
        D0(list, eVar);
    }

    @Override // oh2.b
    public void w(d dVar, int i3, long j3, int i16, int i17) {
        if (dVar == null) {
            QLog.e("VasGiftServiceModuleImpl", 1, "notifyComboOver giftData is null!");
            QQGiftSendGiftReportHelper.a(true, new QQGiftSendGiftReportHelper.SendGiftReportData("notifyComboOver giftData is null!"));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasGiftServiceModuleImpl", 2, "notifyComboOver giftId:" + dVar.f264874d + ", comboSeq:" + j3);
        }
        dn0.a T0 = T0(dVar, i3, j3, i16);
        z0(dVar, T0, new QQGiftSendGiftReportHelper.SendGiftReportData(dVar.f264874d, dVar.f264876e, j3, i16, i16, System.nanoTime(), T0.f394288c, T0.f394287b));
    }

    @Override // oh2.b
    public com.tencent.mobileqq.qqgift.data.service.c x() {
        return this.f311500e;
    }

    @Override // oh2.b
    public void z() {
        com.tencent.mobileqq.vasgift.business.common.service.a.e().a(E0());
    }
}
