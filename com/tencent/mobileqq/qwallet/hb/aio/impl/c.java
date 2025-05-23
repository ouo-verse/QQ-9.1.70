package com.tencent.mobileqq.qwallet.hb.aio.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.qwallet.api.IQWalletNickNameApi;
import com.tencent.mobileqq.qwallet.e;
import com.tencent.mobileqq.qwallet.hb.HbInfo;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.impl.c;
import com.tencent.mobileqq.qwallet.hb.send.PanelEntryData;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.util.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static String f277244b = "qwallet_send_hb_single_top";

    /* renamed from: c, reason: collision with root package name */
    private static final c f277245c = new c();

    /* renamed from: a, reason: collision with root package name */
    private int f277246a = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements o {
        a() {
        }

        @Override // com.tencent.mobileqq.qroute.route.o
        public void onError(int i3) {
            QLog.i("HongBaoSender", 2, "start QrcodeHbGuiderActivity onError");
        }

        @Override // com.tencent.mobileqq.qroute.route.o
        public void onSuccess() {
            QLog.i("HongBaoSender", 2, "start QrcodeHbGuiderActivity onSuccess");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class b implements o {
        b() {
        }

        @Override // com.tencent.mobileqq.qroute.route.o
        public void onError(int i3) {
            QLog.i("HongBaoSender", 2, "start SendHbActivity onError");
        }

        @Override // com.tencent.mobileqq.qroute.route.o
        public void onSuccess() {
            QLog.i("HongBaoSender", 2, "start SendHbActivity onSuccess");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qwallet.hb.aio.impl.c$c, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static class C8459c {

        /* renamed from: a, reason: collision with root package name */
        public int f277249a;

        /* renamed from: b, reason: collision with root package name */
        public String f277250b;

        /* renamed from: c, reason: collision with root package name */
        public String f277251c = "";

        C8459c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        public int f277252a;

        /* renamed from: b, reason: collision with root package name */
        public String f277253b;

        /* renamed from: c, reason: collision with root package name */
        public String f277254c;

        /* renamed from: d, reason: collision with root package name */
        public int f277255d = 1;

        /* renamed from: e, reason: collision with root package name */
        public int f277256e = 0;

        /* renamed from: f, reason: collision with root package name */
        public String f277257f = "";

        /* renamed from: g, reason: collision with root package name */
        public String f277258g = "";

        /* renamed from: h, reason: collision with root package name */
        public String f277259h = "";

        /* renamed from: i, reason: collision with root package name */
        public String f277260i = "";

        /* renamed from: j, reason: collision with root package name */
        public String f277261j = "";

        /* renamed from: k, reason: collision with root package name */
        public String f277262k = "";

        public d(int i3, String str, String str2) {
            this.f277252a = i3;
            this.f277253b = str;
            this.f277254c = str2;
        }
    }

    c() {
    }

    private void c(AppRuntime appRuntime, int i3, d dVar, C8459c c8459c) {
        if (i3 == 0) {
            ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).panelReport(appRuntime, "0X8005CAF", dVar.f277252a);
        } else if (i3 == 1) {
            ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).panelReport(appRuntime, "0X8005FC9", dVar.f277252a);
        }
        int i16 = this.f277246a;
        if (i16 == 0) {
            dVar.f277258g += ".plus";
        } else if (i16 == 1) {
            dVar.f277258g += ".quick";
        }
        com.tencent.mobileqq.qwallet.c.e(dVar.f277258g, c8459c.f277251c, "", "", "");
    }

    private void d(Context context, PanelEntryData panelEntryData, ArrayList<PanelEntryData> arrayList, d dVar, C8459c c8459c, Bundle bundle) {
        if (context == null) {
            return;
        }
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, "/qwallet/redpacket/sendhb");
        activityURIRequest.extra().putInt("come_from", 2);
        activityURIRequest.extra().putString("appInfo", "appid#1344242394|bargainor_id#1000030201|channel#aio");
        activityURIRequest.extra().putBoolean("isFromPanel", true);
        activityURIRequest.extra().putParcelableArrayList("panelEntryData", arrayList);
        if (bundle != null) {
            activityURIRequest.extra().putInt("skin_id", bundle.getInt("skin_id", 0));
            if (bundle.getBoolean(f277244b, false)) {
                activityURIRequest.setFlags(603979776);
            }
        }
        if (panelEntryData != null && panelEntryData.getType() == 3) {
            JSONObject params = panelEntryData.getParams();
            String str = "";
            if (params != null) {
                str = params.optString("theme_id", "");
            }
            activityURIRequest.extra().putString("theme_type", str);
            activityURIRequest.extra().putBoolean("theme", true);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("recv_type", dVar.f277256e);
            jSONObject.put("recv_uin", dVar.f277253b);
            jSONObject.put(WadlProxyConsts.CHANNEL, c8459c.f277249a);
            jSONObject.put("bus_type", c8459c.f277250b);
            int i3 = dVar.f277255d;
            if (i3 > 0) {
                jSONObject.put("people_num", i3);
            }
            if (!TextUtils.isEmpty(dVar.f277257f)) {
                jSONObject.put("session_token", dVar.f277257f);
            }
            if (!TextUtils.isEmpty(dVar.f277259h)) {
                jSONObject.put("placeholder", dVar.f277259h);
            }
            if (!TextUtils.isEmpty(dVar.f277260i)) {
                jSONObject.put("tinyid", dVar.f277260i);
            }
            if (!TextUtils.isEmpty(dVar.f277261j)) {
                jSONObject.put("guild_id", dVar.f277261j);
            }
            if (!TextUtils.isEmpty(dVar.f277262k)) {
                jSONObject.put("sub_guild_id", dVar.f277262k);
            }
        } catch (JSONException e16) {
            QLog.e("HongBaoSender", 1, "error msg in qqpay-impl module: ", e16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("PlusPanel", 2, "click HongBao:params=" + jSONObject);
        }
        activityURIRequest.extra().putString("extra_data", jSONObject.toString());
        QRoute.startUri(activityURIRequest, new b());
    }

    private boolean e(AppRuntime appRuntime, Context context, PanelEntryData panelEntryData, d dVar) {
        JSONObject params = panelEntryData.getParams();
        int type = panelEntryData.getType();
        if (type != 4) {
            if (type != 5) {
                String str = null;
                if (type != 12) {
                    if (type != 13) {
                        return false;
                    }
                    if (params != null) {
                        str = params.optString(QZoneDTLoginReporter.SCHEMA);
                    }
                    QLog.i("HongBaoSender", 2, str);
                    if (TextUtils.isEmpty(str)) {
                        return true;
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("recv_group_type", dVar.f277256e + "");
                    hashMap.put("recv_group_id", dVar.f277253b);
                    hashMap.put("send_uin", appRuntime.getCurrentUin());
                    String a16 = x05.c.a(str, hashMap, true);
                    if (QLog.isColorLevel()) {
                        QLog.i("HongBaoSender", 2, "[go to miniapp] finalSchame: " + a16);
                    }
                    ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).doJumpAction(context, a16);
                    return true;
                }
                if (params != null) {
                    str = params.optString(QZoneDTLoginReporter.SCHEMA);
                }
                QLog.i("HongBaoSender", 2, str);
                if (TextUtils.isEmpty(str)) {
                    return true;
                }
                j(appRuntime, context, dVar.f277253b, dVar.f277256e, dVar.f277255d, str);
                return true;
            }
            com.tencent.mobileqq.qwallet.c.e("plus.hongbao.click", "", "", "", "");
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, "/qwallet/redpacket/qrcodeHb");
            activityURIRequest.extra().putString("appInfo", "");
            QRoute.startUri(activityURIRequest, new a());
            return true;
        }
        if (params == null) {
            return true;
        }
        String optString = params.optString("url", "");
        QLog.i("HongBaoSender", 2, optString);
        if (TextUtils.isEmpty(optString)) {
            return true;
        }
        if (params.optInt("subtype", 0) == 1) {
            if (optString.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) == -1) {
                optString = optString + "?recv_uin=" + dVar.f277253b + "&recv_type=" + dVar.f277256e;
            } else {
                optString = optString + "&recv_uin=" + dVar.f277253b + "&recv_type=" + dVar.f277256e;
            }
        }
        k(context, optString);
        return true;
    }

    public static c f() {
        return f277245c;
    }

    private C8459c h(PanelEntryData panelEntryData) {
        int i3;
        String str;
        Integer a16 = HbInfo.a(panelEntryData.getType());
        if (a16 != null) {
            i3 = a16.intValue();
        } else {
            i3 = 1;
        }
        String valueOf = String.valueOf(2);
        int type = panelEntryData.getType();
        if (type != 0) {
            if (type != 1) {
                if (type != 2) {
                    if (type != 6) {
                        if (type != 7) {
                            str = "";
                            if (type == 18) {
                                valueOf = String.valueOf(1);
                            }
                        } else {
                            str = "13147";
                        }
                    } else {
                        str = "13146";
                    }
                } else {
                    str = "13142";
                }
            } else {
                valueOf = String.valueOf(2);
                str = "13141";
            }
        } else {
            valueOf = String.valueOf(1);
            str = "13140";
        }
        C8459c c8459c = new C8459c();
        c8459c.f277250b = valueOf;
        c8459c.f277249a = i3;
        c8459c.f277251c = str;
        return c8459c;
    }

    public static d i(int i3, String str, String str2) {
        int i16;
        byte[] b06;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        final d dVar = new d(i3, str, str2);
        int i17 = dVar.f277252a;
        String str3 = "entrance.click.c2c";
        int i18 = 1;
        String str4 = "";
        if (i17 == 0) {
            i16 = 1;
        } else {
            int i19 = 2;
            if (i17 == 3000) {
                i18 = ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).getDiscussionMemberNum(peekAppRuntime, dVar.f277253b);
                str3 = "entrance.click.group";
            } else if (i17 == 1) {
                TroopInfo findTroopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(dVar.f277253b);
                if (findTroopInfo != null) {
                    i18 = findTroopInfo.wMemberNum;
                    if (QLog.isColorLevel()) {
                        QLog.d("PlusPanelUtils", 2, "troop uin\uff1a" + dVar.f277253b + " people_num\uff1a" + i18);
                    }
                }
                if (QWalletHelperImpl.isNeedUpdateTroopMemberNum(dVar.f277253b)) {
                    try {
                        if (peekAppRuntime instanceof BaseQQAppInterface) {
                            ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopBasicInfo(dVar.f277253b, "HongBaoSender", null, new Function2() { // from class: com.tencent.mobileqq.qwallet.hb.aio.impl.a
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit l3;
                                    l3 = c.l(c.d.this, (Boolean) obj, (TroopInfo) obj2);
                                    return l3;
                                }
                            });
                        }
                    } catch (NumberFormatException unused) {
                        if (QLog.isColorLevel()) {
                            QLog.d("angelzhuang", 2, "\u7fa4uin\uff1a" + dVar.f277253b + " \u89e3\u6790\u5931\u8d25");
                        }
                    }
                }
                i16 = 3;
                str3 = "entrance.click.chatgroup";
            } else if (i17 == 1000) {
                str4 = dVar.f277254c;
                i16 = 4;
            } else if (i17 == 1004) {
                str4 = dVar.f277254c;
                i16 = 5;
            } else if (i17 != 1001 && i17 != 10002 && i17 != 10004) {
                i19 = 0;
                if (i17 == 10014) {
                    try {
                        i19 = Integer.parseInt("11");
                    } catch (NumberFormatException e16) {
                        QLog.e("HongBaoSender", 1, e16, new Object[0]);
                    }
                    dVar.f277260i = ((IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
                    dVar.f277261j = dVar.f277254c;
                    dVar.f277262k = dVar.f277253b;
                }
                str3 = "";
            } else {
                e eVar = (e) peekAppRuntime.getMsgCache();
                if (eVar != null) {
                    if (dVar.f277252a == 10004) {
                        b06 = eVar.L0(dVar.f277253b);
                    } else {
                        b06 = eVar.b0(dVar.f277253b);
                    }
                    if (b06 != null) {
                        str4 = i.f(b06, 2);
                    }
                }
                ReportController.o(peekAppRuntime, "CliOper", "", "", "0X8005B9D", "0X8005B9D", 0, 0, "", "", "", "");
                str4 = str4;
                i16 = 7;
            }
            i16 = i19;
        }
        dVar.f277258g = str3;
        dVar.f277255d = i18;
        dVar.f277256e = i16;
        dVar.f277257f = str4;
        return dVar;
    }

    private void j(final AppRuntime appRuntime, final Context context, final String str, final int i3, final int i16, final String str2) {
        com.tencent.mobileqq.qwallet.e.a(new e.a() { // from class: com.tencent.mobileqq.qwallet.hb.aio.impl.b
            @Override // com.tencent.mobileqq.qwallet.e.a
            public final void onFinish(int i17, String str3, String str4) {
                c.m(i3, str, appRuntime, i16, str2, context, i17, str3, str4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Unit l(d dVar, Boolean bool, TroopInfo troopInfo) {
        if (bool.booleanValue()) {
            QWalletHelperImpl.saveLastUpdateToopMemberNumTime(dVar.f277253b);
            if (QLog.isColorLevel()) {
                QLog.d("PlusPanelUtils", 2, "onGetTroopInfoForSetJoinTypeRet \u7fa4uin\uff1a" + dVar.f277253b + " \u7fa4\u6210\u5458\u4e2a\u6570\uff1a" + troopInfo.wMemberNum);
                return null;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(int i3, String str, AppRuntime appRuntime, int i16, String str2, Context context, int i17, String str3, String str4) {
        if (i17 == 0 && !TextUtils.isEmpty(str4)) {
            HashMap hashMap = new HashMap();
            hashMap.put("pskey_type", "27");
            hashMap.put("pskey", str4);
            hashMap.put("recv_group_type", i3 + "");
            hashMap.put("recv_group_id", str);
            hashMap.put("send_nickname", ((IQWalletNickNameApi) QRoute.api(IQWalletNickNameApi.class)).getCurrentNickName(str));
            hashMap.put("send_uin", appRuntime.getCurrentUin());
            hashMap.put("group_count", i16 + "");
            ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).doJumpAction(context, x05.c.a(str2, hashMap, true));
            return;
        }
        QLog.i("HongBaoSender", 2, "error get pskey...");
    }

    public int g() {
        return this.f277246a;
    }

    public void k(Context context, String str) {
        int indexOf;
        if (TextUtils.isEmpty(str) || (indexOf = str.indexOf(58)) == -1) {
            return;
        }
        String substring = str.substring(0, indexOf);
        if (TextUtils.isEmpty(substring)) {
            return;
        }
        String lowerCase = substring.toLowerCase();
        if (lowerCase.compareTo("http") == 0 || lowerCase.compareTo("https") == 0) {
            Intent intent = new Intent();
            intent.putExtra("url", str);
            RouteUtils.startActivity(context, intent, RouterConstants.UI_ROUTE_BROWSER);
        }
    }

    public void n(AppRuntime appRuntime, Context context, d dVar, PanelEntryData panelEntryData, ArrayList<PanelEntryData> arrayList, int i3, Bundle bundle) {
        if (panelEntryData == null) {
            return;
        }
        if (e(appRuntime, context, panelEntryData, dVar)) {
            QLog.i("HongBaoSender", 2, "---doSendHbJumpNoEnterSendHbActivity---");
            return;
        }
        C8459c h16 = h(panelEntryData);
        d(context, panelEntryData, arrayList, dVar, h16, bundle);
        c(appRuntime, i3, dVar, h16);
    }

    public void o(int i3) {
        this.f277246a = i3;
    }
}
