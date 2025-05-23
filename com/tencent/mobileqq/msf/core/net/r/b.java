package com.tencent.mobileqq.msf.core.net.r;

import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.PushRegisterInfo;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    public static final String f248968a = "HeratbeatProxy";

    /* renamed from: b, reason: collision with root package name */
    public static byte[] f248969b = null;

    /* renamed from: c, reason: collision with root package name */
    public static byte[] f248970c = null;

    /* renamed from: d, reason: collision with root package name */
    public static final String f248971d = "OS.Hello";

    /* renamed from: e, reason: collision with root package name */
    public static boolean f248972e = false;

    /* renamed from: f, reason: collision with root package name */
    private static int f248973f = -1;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f248974g = false;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28083);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static boolean a(ToServiceMsg toServiceMsg) {
        try {
            int length = f248971d.getBytes().length + 13 + 1 + 0 + 4;
            int parseLong = (int) (Long.parseLong(toServiceMsg.getUin()) & (-1));
            byte length2 = (byte) (f248971d.getBytes().length + 1);
            ByteBuffer allocate = ByteBuffer.allocate(length);
            allocate.putInt(length).putInt(20140601).putInt(parseLong).put(length2).put(f248971d.getBytes()).put((byte) 1).putInt(0);
            byte[] array = allocate.array();
            byte[] bArr = new byte[array.length];
            f248969b = bArr;
            System.arraycopy(array, 0, bArr, 0, array.length);
            return true;
        } catch (Exception e16) {
            QLog.d(f248968a, 1, "encap toservicemsg failed " + e16.toString());
            return false;
        }
    }

    public static void b(byte[] bArr) {
        if (bArr != null) {
            try {
                QLog.d(f248968a, 1, "rsp length:" + bArr.length);
            } catch (Exception e16) {
                QLog.d(f248968a, 1, "set response byte failed " + e16.toString());
                return;
            }
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        f248970c = bArr2;
        System.arraycopy(bArr, 0, bArr2, 0, length);
    }

    public static int c() {
        return f248973f;
    }

    public static boolean d() {
        return f248974g;
    }

    private static com.tencent.mobileqq.msf.core.push.a b() {
        PushRegisterInfo pushRegisterInfo;
        Iterator<String> it = MsfService.core.pushManager.f249742i.keySet().iterator();
        while (it.hasNext()) {
            com.tencent.mobileqq.msf.core.push.a aVar = MsfService.core.pushManager.f249742i.get(it.next());
            if (aVar != null && (pushRegisterInfo = aVar.f249597k) != null) {
                long j3 = aVar.f249589c;
                if (j3 != 0) {
                    try {
                        if (pushRegisterInfo.uin != null && j3 > 0) {
                            QLog.d(f248968a, 1, "get pushinfo uin:" + aVar.f249597k.uin + ", pushid:" + aVar.f249589c);
                            return aVar;
                        }
                    } catch (Exception e16) {
                        QLog.d(f248968a, 1, "failed to get pushinfo", e16);
                    }
                } else {
                    continue;
                }
            }
        }
        return null;
    }

    public static boolean b(ToServiceMsg toServiceMsg) {
        try {
            QLog.d(f248968a, 1, "send heartbeat os.hello");
            com.tencent.mobileqq.msf.core.f0.a msfNetService = MsfService.core.getMsfNetService();
            if (!(msfNetService instanceof com.tencent.mobileqq.msf.core.f0.d.a)) {
                return false;
            }
            if (!((com.tencent.mobileqq.msf.core.f0.d.a) msfNetService).r().j().f250076a.a(BaseApplication.getContext().getAppId(), 0, toServiceMsg.getServiceCmd(), "", toServiceMsg.getMsfCommand(), toServiceMsg.getUin(), toServiceMsg.getRequestSsoSeq(), f248969b, toServiceMsg)) {
                return false;
            }
            f248973f = toServiceMsg.getRequestSsoSeq();
            f248974g = true;
            return true;
        } catch (Exception e16) {
            QLog.d(f248968a, 1, "failed to send ok.hello " + e16.toString());
            return false;
        }
    }

    private static boolean a(FromServiceMsg fromServiceMsg, byte[] bArr) {
        try {
            fromServiceMsg.getWupBuffer();
            return true;
        } catch (Exception e16) {
            QLog.d(f248968a, 1, "encap fromservicemsg failed " + e16.toString());
            return false;
        }
    }

    public static boolean a() {
        try {
            com.tencent.mobileqq.msf.core.push.a b16 = b();
            if (b16 == null) {
                QLog.d(f248968a, 1, "encap heartbeat proxy failed to get appPushInfo");
                return false;
            }
            ToServiceMsg toServiceMsg = new ToServiceMsg("", b16.f249597k.uin, f248971d);
            toServiceMsg.setAppId(b16.f249587a);
            toServiceMsg.setTimeout(30000L);
            toServiceMsg.setMsfCommand(MsfCommand.msf_oshello);
            toServiceMsg.setRequestSsoSeq(MsfService.getCore().getNextSeq());
            if (!a(toServiceMsg)) {
                QLog.d(f248968a, 1, "encap heartbeat failed");
                return false;
            }
            if (b(toServiceMsg)) {
                return true;
            }
            QLog.d(f248968a, 1, "failed to send heartbeat request");
            return false;
        } catch (Exception e16) {
            QLog.d(f248968a, 1, "encap heartbeat proxy failed " + e16.toString());
            return false;
        }
    }

    public static boolean a(byte[] bArr) {
        QLog.d(f248968a, 1, "recv heartbeat os.hello");
        f248974g = false;
        b(bArr);
        a.t();
        return true;
    }
}
