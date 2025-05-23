package com.tencent.mobileqq.qrscan;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qrscan.api.IQRDataApi;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class q extends MSFServlet {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static String f276777d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24593);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f276777d = "QRCodeServlet";
        }
    }

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg != null) {
            QLog.d(f276777d, 2, fromServiceMsg.toString());
        }
        boolean z18 = false;
        if (fromServiceMsg != null && fromServiceMsg.isSuccess() && fromServiceMsg.getResultCode() == 1000) {
            z16 = true;
        } else {
            z16 = false;
        }
        Bundle bundle = null;
        if (z16) {
            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
            if (wupBuffer != null) {
                byte[] a16 = fh.a(wupBuffer);
                bundle = new Bundle();
                String str = new String(a16);
                bundle.putString("result", str);
                QLog.d(f276777d, 2, str);
                z18 = z16;
            }
            z17 = z18;
        } else {
            QLog.e(f276777d, 2, " MSF response is null");
            z17 = z16;
        }
        notifyObserver(intent, 0, z17, bundle, o.class);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        if (intent == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Bundle extras = intent.getExtras();
            String[] strArr = {IQRDataApi.PARAM_NO_VERIFY_TOKEN, "d", "appid", "ul", IQRDataApi.PARAM_BQQ, "md5", "fromuin", "touin", "ip", "url", "guid", "uuid", "type"};
            for (int i3 = 0; i3 < 13; i3++) {
                String str = strArr[i3];
                if (extras.containsKey(str)) {
                    Object obj = extras.get(str);
                    if (obj instanceof ArrayList) {
                        jSONObject.put(str, new JSONArray((Collection) obj));
                    } else if (TextUtils.equals("type", str)) {
                        jSONObject.put(str, Integer.valueOf(obj.toString()));
                    } else {
                        jSONObject.put(str, obj);
                    }
                }
            }
            if (extras.containsKey("extra")) {
                Bundle bundle = extras.getBundle("extra");
                for (String str2 : bundle.keySet()) {
                    jSONObject.put(str2, bundle.get(str2));
                }
            }
            String jSONObject2 = jSONObject.toString();
            packet.setTimeout(30000L);
            packet.setSSOCommand(extras.getString("cmd"));
            packet.putSendData(fh.b(jSONObject2.getBytes()));
            QLog.i(f276777d, 1, "onSend result: " + jSONObject2);
        } catch (JSONException unused) {
            QLog.d(f276777d, 2, "json error");
        }
    }
}
