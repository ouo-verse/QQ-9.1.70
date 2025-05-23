package com.tencent.mobileqq.unifiedebug;

import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.pb.unifiedebug.RemoteDebugReportMsg$RemoteLogReq;
import com.tencent.pb.unifiedebug.RemoteDebugReportMsg$RemoteLogRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public QQAppInterface f305799a;

    /* renamed from: b, reason: collision with root package name */
    public BusinessObserver f305800b;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements BusinessObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
            }
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
                return;
            }
            if (z16) {
                byte[] byteArray = bundle.getByteArray("extra_data");
                if (byteArray != null) {
                    try {
                        RemoteDebugReportMsg$RemoteLogRsp remoteDebugReportMsg$RemoteLogRsp = new RemoteDebugReportMsg$RemoteLogRsp();
                        remoteDebugReportMsg$RemoteLogRsp.mergeFrom(byteArray);
                        if (remoteDebugReportMsg$RemoteLogRsp.i32_ret.has()) {
                            int i16 = remoteDebugReportMsg$RemoteLogRsp.i32_ret.get();
                            if (QLog.isColorLevel()) {
                                QLog.d("UnifiedDebugReporter", 2, "onReceive: retCode=" + i16);
                                return;
                            }
                            return;
                        }
                        return;
                    } catch (InvalidProtocolBufferMicroException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("UnifiedDebugReporter", 2, "onReceive: exception=" + e16.getMessage());
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.e("UnifiedDebugReporter", 2, "onReceive: isSuccess=" + z16);
            }
        }
    }

    public c(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f305800b = new a();
            this.f305799a = qQAppInterface;
        }
    }

    public String a(int i3, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) jSONObject);
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("status", i3);
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            jSONObject2.put("data", jSONObject);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("UnifiedDebugReporter", 2, "reportStatus: exception=" + e16.getMessage());
            }
        }
        return jSONObject2.toString();
    }

    public void b(long j3, int i3, JSONObject jSONObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), jSONObject);
            return;
        }
        RemoteDebugReportMsg$RemoteLogReq remoteDebugReportMsg$RemoteLogReq = new RemoteDebugReportMsg$RemoteLogReq();
        remoteDebugReportMsg$RemoteLogReq.str_seq.set(String.valueOf(j3));
        remoteDebugReportMsg$RemoteLogReq.str_data.set(a(i3, jSONObject));
        NewIntent newIntent = new NewIntent(this.f305799a.getApp(), b.class);
        newIntent.putExtra(WadlProxyConsts.EXTRA_CMD, "ClubDebugging.report");
        newIntent.putExtra("extra_data", remoteDebugReportMsg$RemoteLogReq.toByteArray());
        newIntent.setObserver(this.f305800b);
        this.f305799a.startServlet(newIntent);
        if (QLog.isColorLevel()) {
            QLog.d("UnifiedDebugReporter", 2, "reportStatus: seq=" + j3 + ", statusCode=" + i3 + ", data=" + jSONObject);
        }
    }
}
