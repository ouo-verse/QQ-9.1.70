package com.tencent.mobileqq.app;

import PayMQQ.UniPayRequest;
import PayMQQ.UniPayResponse;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes11.dex */
public class UniPayHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<a> f195165d;

    /* loaded from: classes11.dex */
    public static abstract class a {
        static IPatchRedirector $redirector_;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        public abstract void a();
    }

    public UniPayHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f195165d = new ArrayList<>();
        }
    }

    private void D2() {
        Iterator<a> it = this.f195165d.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void E2(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
        } else if (aVar != null && !this.f195165d.contains(aVar)) {
            this.f195165d.add(aVar);
        }
    }

    public void F2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        UniPayRequest uniPayRequest = new UniPayRequest(this.appRuntime.getAccount(), "android" + str);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getAccount(), "VipSTCheckServer.UinPay");
        toServiceMsg.extraData.putSerializable("UniPayRequest", uniPayRequest);
        super.send(toServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null && obj != null) {
            String serviceCmd = toServiceMsg.getServiceCmd();
            if (TextUtils.isEmpty(serviceCmd)) {
                return;
            }
            if (serviceCmd.compareTo("VipSTCheckServer.UinPay") == 0 && QLog.isColorLevel()) {
                QLog.i("UniPayHandler", 2, "req---" + toServiceMsg + ",res----" + fromServiceMsg + ",data-----" + obj);
            }
            if (serviceCmd.compareTo("VipSTCheckServer.UinPay") == 0) {
                UniPayResponse uniPayResponse = (UniPayResponse) obj;
                String sUin = uniPayResponse.getSUin();
                int iShowOpen = uniPayResponse.getIShowOpen();
                int iUniPayType = uniPayResponse.getIUniPayType();
                new HashMap();
                Map<String, String> mapResponse = uniPayResponse.getMapResponse();
                String str3 = mapResponse.get("cur_st");
                String str4 = mapResponse.get("net_mobile_club");
                String str5 = mapResponse.get("open_month");
                String str6 = mapResponse.get("platform");
                String str7 = mapResponse.get("ret");
                String str8 = mapResponse.get("show_open");
                String str9 = mapResponse.get("uin");
                String str10 = mapResponse.get("uin_pay_type");
                if (QLog.isColorLevel()) {
                    str = str10;
                    StringBuilder sb5 = new StringBuilder();
                    str2 = "uin_pay_type";
                    sb5.append("sUin==");
                    sb5.append(sUin);
                    sb5.append(",isShowOpen==");
                    sb5.append(iShowOpen);
                    sb5.append(",iUniPayType==");
                    sb5.append(iUniPayType);
                    QLog.d("UniPayHandler", 2, sb5.toString());
                } else {
                    str = str10;
                    str2 = "uin_pay_type";
                }
                SharedPreferences.Editor edit = this.appRuntime.getApp().getSharedPreferences("uniPaySp_" + sUin, 4).edit();
                edit.putString("sUin", sUin);
                edit.putInt("isShowOpen", iShowOpen);
                edit.putInt("iUinpPayType", iUniPayType);
                edit.putString("cur_st", str3);
                edit.putString("net_mobile_club", str4);
                edit.putString("open_month", str5);
                edit.putString("platform", str6);
                edit.putString("ret", str7);
                edit.putString("show_open", str8);
                edit.putString("uin", str9);
                edit.putString(str2, str);
                edit.commit();
                D2();
            }
        }
    }
}
