package com.tencent.biz.pubaccount.util.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountHandler;
import com.tencent.biz.pubaccount.api.IPublicAccountReportManager;
import com.tencent.biz.pubaccount.api.impl.PublicAccountServletImpl;
import com.tencent.biz.pubaccount.util.PAReportInfo;
import com.tencent.biz.pubaccount.util.api.IPAReportUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.mp.mobileqq_mp$ReportPublicAccountRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$ReportPublicAccountResponse;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class PAReportUtilImpl implements IPAReportUtil {
    public static final String COMMAND_READ_AD_MSG = "read_ad_msg";
    public static final String COMMAND_SEND_AD_RECEIPT = "send_ad_receipt";
    public static final String SSO_COMMAND_REPORT = "ad_report";
    public static final String TAG = "PAReport";

    /* loaded from: classes32.dex */
    class b implements BusinessObserver {
        b() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            StringBuilder sb5;
            boolean isColorLevel;
            if (QLog.isColorLevel()) {
                QLog.d("PAReport", 2, "reportClickEventForAdver onReceive: " + String.valueOf(z16));
            }
            if (z16) {
                long j3 = -1;
                try {
                    try {
                        byte[] byteArray = bundle.getByteArray("data");
                        mobileqq_mp$ReportPublicAccountResponse mobileqq_mp_reportpublicaccountresponse = new mobileqq_mp$ReportPublicAccountResponse();
                        mobileqq_mp_reportpublicaccountresponse.mergeFrom(byteArray);
                        if (mobileqq_mp_reportpublicaccountresponse.ret_info.has() && mobileqq_mp_reportpublicaccountresponse.ret_info.ret_code.has()) {
                            j3 = mobileqq_mp_reportpublicaccountresponse.ret_info.ret_code.get();
                            if (j3 == 0) {
                                if (isColorLevel) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("PAReport", 2, "reportClickEventRuntime exception", e16);
                        }
                        if (!QLog.isColorLevel()) {
                            return;
                        } else {
                            sb5 = new StringBuilder();
                        }
                    }
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                        sb5.append("reportClickEventRuntime ret_code: ");
                        sb5.append(String.valueOf(j3));
                        QLog.d("PAReport", 2, sb5.toString());
                    }
                } finally {
                    if (QLog.isColorLevel()) {
                        QLog.d("PAReport", 2, "reportClickEventRuntime ret_code: " + String.valueOf(-1L));
                    }
                }
            }
        }
    }

    private static void reportClickEventRuntime(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, String str6, String str7, String str8, List<String> list) {
        if (!TextUtils.isEmpty(str6) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str) && appInterface != null) {
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                int size = list.size();
                if (size > 0) {
                    sb5.append(list.get(0));
                    int i18 = 1;
                    while (i18 < size) {
                        sb5.append("|");
                        sb5.append(list.get(i18));
                        i18++;
                        size = size;
                    }
                }
                QLog.d("PAReport", 2, "Reporting: " + str + "|" + str2 + "|" + str3 + "|" + str4 + "|" + str5 + "|" + i3 + "|" + i16 + "|" + i17 + "|" + str6 + "|" + str7 + "|" + str8 + "|" + sb5.toString());
            }
            NewIntent newIntent = new NewIntent(appInterface.getApplication(), PublicAccountServletImpl.class);
            newIntent.putExtra("cmd", PublicAccountServletImpl.CMD_PREFIX_PUBLIC_REPORT);
            mobileqq_mp$ReportPublicAccountRequest mobileqq_mp_reportpublicaccountrequest = new mobileqq_mp$ReportPublicAccountRequest();
            mobileqq_mp_reportpublicaccountrequest.tag.set(str);
            mobileqq_mp_reportpublicaccountrequest.mainAction.set(str2);
            mobileqq_mp_reportpublicaccountrequest.toUin.set(str3);
            mobileqq_mp_reportpublicaccountrequest.subAction.set(str4);
            mobileqq_mp_reportpublicaccountrequest.actionName.set(str5);
            mobileqq_mp_reportpublicaccountrequest.fromType.set(i3);
            mobileqq_mp_reportpublicaccountrequest.count.set(i16);
            mobileqq_mp_reportpublicaccountrequest.result.set(i17);
            mobileqq_mp_reportpublicaccountrequest.f247284r2.set(str6);
            mobileqq_mp_reportpublicaccountrequest.f247285r3.set(str7);
            mobileqq_mp_reportpublicaccountrequest.f247286r4.set(str8);
            mobileqq_mp_reportpublicaccountrequest.f247287r5.set(list);
            newIntent.putExtra("data", mobileqq_mp_reportpublicaccountrequest.toByteArray());
            newIntent.setObserver(new a(appInterface, list, str, str2, str3, str4, str5, i3, i16, i17, str6, str7, str8));
            appInterface.startServlet(newIntent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PAReport", 2, "r2 or mainAction or tag or app is null");
        }
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPAReportUtil
    public void reportAdMsgArriveReceipt(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, List<String> list) {
        if (QLog.isColorLevel()) {
            QLog.d("PAReport", 2, "sendAdArriveReceipt report");
        }
        long serverTime = NetConnInfoCenter.getServerTime() * 1000;
        JSONObject jSONObject = new JSONObject();
        try {
            String k3 = AppSetting.k();
            jSONObject.put(IPublicAccountBrowser.KEY_PUB_UIN, str3);
            jSONObject.put("q_user_agent", k3);
            jSONObject.put("gdt_imp_data", str4);
            jSONObject.put("view_id", str5);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        reportClickEventRuntime(appInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, appInterface.getAccount(), str, str2, 0, 1, 0, COMMAND_SEND_AD_RECEIPT, String.valueOf(serverTime), jSONObject.toString(), list);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPAReportUtil
    public void reportAdMsgRead(AppInterface appInterface, String str, String str2, String str3, List<String> list, List<String> list2, List<String> list3) {
        if (QLog.isColorLevel()) {
            QLog.d("PAReport", 2, "reportAdMsgRead report msgId size = " + list2.size());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            String k3 = AppSetting.k();
            JSONArray jSONArray = new JSONArray();
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                jSONArray.put(i3, list.get(i3));
            }
            jSONObject.put(IPublicAccountBrowser.KEY_PUB_UIN, str3);
            jSONObject.put("q_user_agent", k3);
            jSONObject.put("hardware_addr", "");
            jSONObject.put("mobile_imsi", "");
            jSONObject.put("mobile_android_id", "");
            jSONObject.put("mobile_imei", "");
            jSONObject.put("gdt_cli_data", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            int size2 = list3.size();
            for (int i16 = 0; i16 < size2; i16++) {
                jSONArray2.put(i16, list3.get(i16));
            }
            jSONObject.put("view_id", jSONArray2);
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        reportClickEventRuntime(appInterface, "P_CliOper", IPublicAccountHandler.MAIN_ACTION, appInterface.getAccount(), str, str2, 0, 1, 0, COMMAND_READ_AD_MSG, String.valueOf(NetConnInfoCenter.getServerTime() * 1000), jSONObject.toString(), list2);
    }

    @Override // com.tencent.biz.pubaccount.util.api.IPAReportUtil
    public void reportClickEventForAdver(AppInterface appInterface, String str, String str2, String str3) {
        if (QLog.isColorLevel()) {
            QLog.d("PAReport", 2, "reportClickEventForAdver send: " + str + "r4:" + str2 + "r5:" + str3);
        }
        NewIntent newIntent = new NewIntent(appInterface.getApplication(), PublicAccountServletImpl.class);
        newIntent.putExtra("cmd", PublicAccountServletImpl.CMD_PREFIX_PUBLIC_REPORT);
        mobileqq_mp$ReportPublicAccountRequest mobileqq_mp_reportpublicaccountrequest = new mobileqq_mp$ReportPublicAccountRequest();
        mobileqq_mp_reportpublicaccountrequest.tag.set("P_CliOper");
        mobileqq_mp_reportpublicaccountrequest.mainAction.set(IPublicAccountHandler.MAIN_ACTION);
        mobileqq_mp_reportpublicaccountrequest.toUin.set(str);
        mobileqq_mp_reportpublicaccountrequest.subAction.set("");
        mobileqq_mp_reportpublicaccountrequest.actionName.set("");
        mobileqq_mp_reportpublicaccountrequest.fromType.set(0);
        mobileqq_mp_reportpublicaccountrequest.count.set(1);
        mobileqq_mp_reportpublicaccountrequest.result.set(0);
        mobileqq_mp_reportpublicaccountrequest.f247284r2.set("click_ad_msg");
        mobileqq_mp_reportpublicaccountrequest.f247285r3.set(String.valueOf(NetConnInfoCenter.getServerTime() * 1000));
        mobileqq_mp_reportpublicaccountrequest.f247286r4.set(str2);
        ArrayList arrayList = new ArrayList();
        arrayList.add(str3);
        mobileqq_mp_reportpublicaccountrequest.f247287r5.set(arrayList);
        newIntent.putExtra("data", mobileqq_mp_reportpublicaccountrequest.toByteArray());
        newIntent.setObserver(new b());
        appInterface.startServlet(newIntent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a implements BusinessObserver {
        final /* synthetic */ String C;
        final /* synthetic */ int D;
        final /* synthetic */ int E;
        final /* synthetic */ int F;
        final /* synthetic */ String G;
        final /* synthetic */ String H;
        final /* synthetic */ String I;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f80198d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List f80199e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f80200f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f80201h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f80202i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ String f80203m;

        a(AppInterface appInterface, List list, String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, String str6, String str7, String str8) {
            this.f80198d = appInterface;
            this.f80199e = list;
            this.f80200f = str;
            this.f80201h = str2;
            this.f80202i = str3;
            this.f80203m = str4;
            this.C = str5;
            this.D = i3;
            this.E = i16;
            this.F = i17;
            this.G = str6;
            this.H = str7;
            this.I = str8;
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            StringBuilder sb5;
            boolean isColorLevel;
            if (QLog.isColorLevel()) {
                QLog.d("PAReport", 2, "reportClickEventRuntime onReceive: " + String.valueOf(z16));
            }
            if (z16) {
                long j3 = -1;
                try {
                    try {
                        byte[] byteArray = bundle.getByteArray("data");
                        mobileqq_mp$ReportPublicAccountResponse mobileqq_mp_reportpublicaccountresponse = new mobileqq_mp$ReportPublicAccountResponse();
                        mobileqq_mp_reportpublicaccountresponse.mergeFrom(byteArray);
                        if (mobileqq_mp_reportpublicaccountresponse.ret_info.has() && mobileqq_mp_reportpublicaccountresponse.ret_info.ret_code.has()) {
                            j3 = mobileqq_mp_reportpublicaccountresponse.ret_info.ret_code.get();
                            if (j3 == 0) {
                                ((IPublicAccountReportManager) this.f80198d.getRuntimeService(IPublicAccountReportManager.class, "all")).scheduleReport();
                                if (isColorLevel) {
                                    return;
                                } else {
                                    return;
                                }
                            }
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("PAReport", 2, "reportClickEventRuntime exception", e16);
                        }
                        if (!QLog.isColorLevel()) {
                            return;
                        } else {
                            sb5 = new StringBuilder();
                        }
                    }
                    if (QLog.isColorLevel()) {
                        sb5 = new StringBuilder();
                        sb5.append("reportClickEventRuntime ret_code: ");
                        sb5.append(String.valueOf(j3));
                        QLog.d("PAReport", 2, sb5.toString());
                        return;
                    }
                    return;
                } finally {
                    if (QLog.isColorLevel()) {
                        QLog.d("PAReport", 2, "reportClickEventRuntime ret_code: " + String.valueOf(j3));
                    }
                }
            }
            IPublicAccountReportManager iPublicAccountReportManager = (IPublicAccountReportManager) this.f80198d.getRuntimeService(IPublicAccountReportManager.class, "all");
            StringBuilder sb6 = new StringBuilder();
            int size = this.f80199e.size();
            if (size > 0) {
                sb6.append((String) this.f80199e.get(0));
                for (int i16 = 1; i16 < size; i16++) {
                    sb6.append("|");
                    sb6.append((String) this.f80199e.get(i16));
                }
            }
            iPublicAccountReportManager.addReporting(new PAReportInfo(this.f80200f, this.f80201h, this.f80202i, this.f80203m, this.C, this.D, this.E, this.F, this.G, this.H, this.I, sb6.toString()));
        }
    }
}
