package cu;

import android.text.TextUtils;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private AppInterface f391842b;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String[]> f391841a = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<String> f391843c = new ArrayList<>(10);

    public a(AppInterface appInterface) {
        this.f391842b = appInterface;
    }

    public boolean a(String str, String[] strArr, boolean z16) {
        if (!TextUtils.isEmpty(str)) {
            this.f391841a.put(str, strArr);
            if (z16) {
                this.f391843c.add(str);
                return true;
            }
            return true;
        }
        return false;
    }

    public AppInterface b() {
        return this.f391842b;
    }

    public void c(ToServiceMsg toServiceMsg, Class<? extends MSFServlet> cls) {
        if (toServiceMsg.getWupBuffer() != null) {
            long length = toServiceMsg.getWupBuffer().length;
            int i3 = (int) length;
            byte[] bArr = new byte[i3 + 4];
            PkgTools.dWord2Byte(bArr, 0, length + 4);
            PkgTools.copyData(bArr, 4, toServiceMsg.getWupBuffer(), i3);
            toServiceMsg.putWupBuffer(bArr);
            if (QLog.isColorLevel()) {
                QLog.d("MsfServletProxy", 2, "PB cmd: req cmd: " + toServiceMsg.getServiceCmd());
            }
            NewIntent newIntent = new NewIntent(this.f391842b.getApplication(), cls);
            newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
            this.f391842b.startServlet(newIntent);
            toServiceMsg.extraData.putLong("sendtimekey", System.currentTimeMillis());
        }
    }

    public void d(boolean z16, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Exception exc) {
        String serviceCmd;
        byte[] bArr;
        if (toServiceMsg != null && toServiceMsg.extraData != null) {
            AppInterface b16 = b();
            float currentTimeMillis = ((float) (System.currentTimeMillis() - toServiceMsg.extraData.getLong("sendtimekey"))) / 1000.0f;
            String serviceCmd2 = fromServiceMsg.getServiceCmd();
            if (z16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MsfServletProxy", 2, "[RES]cmd=" + serviceCmd2 + ", app seq:" + fromServiceMsg.getAppSeq() + ", sec.=" + currentTimeMillis);
                }
            } else if (exc != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                exc.printStackTrace(new PrintStream(byteArrayOutputStream));
                String str = new String(byteArrayOutputStream.toByteArray());
                if (QLog.isColorLevel()) {
                    QLog.d("MsfServletProxy", 2, "[NOT SEND]cmd=" + serviceCmd2 + ", " + str);
                }
            } else if (QLog.isColorLevel()) {
                QLog.w("MsfServletProxy", 2, "[RES]cmd=" + serviceCmd2 + ", CODE=" + fromServiceMsg.getResultCode() + ", sec.=" + currentTimeMillis);
            }
            boolean booleanValue = ((Boolean) toServiceMsg.getAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.FALSE)).booleanValue();
            if ((z16 || this.f391843c.contains(serviceCmd2)) && booleanValue) {
                if (QLog.isColorLevel()) {
                    QLog.d("MsfServletProxy", 2, "PB cmd: recv cmd: " + serviceCmd2);
                }
                if (fromServiceMsg.getWupBuffer() != null) {
                    int length = fromServiceMsg.getWupBuffer().length - 4;
                    if (length > 0) {
                        byte[] bArr2 = new byte[length];
                        PkgTools.copyData(bArr2, 0, fromServiceMsg.getWupBuffer(), 4, length);
                        fromServiceMsg.putWupBuffer(bArr2);
                    }
                    bArr = fromServiceMsg.getWupBuffer();
                } else {
                    bArr = null;
                }
                String[] strArr = this.f391841a.get(serviceCmd2);
                if (strArr != null && strArr.length > 0) {
                    for (String str2 : strArr) {
                        BusinessHandler businessHandler = b16.getBusinessHandler(str2);
                        if (businessHandler != null) {
                            try {
                                businessHandler.onReceive(toServiceMsg, fromServiceMsg, bArr);
                            } catch (Exception e16) {
                                e16.printStackTrace();
                                if (QLog.isColorLevel()) {
                                    QLog.w("MsfServletProxy", 2, businessHandler.getClass().getSimpleName() + " onReceive error,", e16);
                                }
                            }
                        }
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.w("MsfServletProxy", 2, " handlerIds no map " + serviceCmd2);
                    return;
                }
                return;
            }
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleResponse error req:");
        sb5.append(toServiceMsg);
        sb5.append("|");
        if (fromServiceMsg == null) {
            serviceCmd = "null";
        } else {
            serviceCmd = fromServiceMsg.getServiceCmd();
        }
        sb5.append(serviceCmd);
        AVCoreLog.printAllUserLog("MsfServletProxy", sb5.toString());
    }
}
