package com.tencent.mobileqq.msf.core.d0;

import com.tencent.mobileqq.channel.ChannelManager;
import com.tencent.mobileqq.channel.ChannelProxyExt;
import com.tencent.mobileqq.fe.EventCallback;
import com.tencent.mobileqq.fe.FEKit;
import com.tencent.mobileqq.fe.IFEKitLog;
import com.tencent.mobileqq.fe.g;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.q;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sign.QQSecuritySign;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicBoolean;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: e, reason: collision with root package name */
    private static final String f247942e = "FEKitManager";

    /* renamed from: f, reason: collision with root package name */
    public static final String f247943f = "mobileqq.msf.security";

    /* renamed from: g, reason: collision with root package name */
    public static final String f247944g = "sp_security_name";

    /* renamed from: h, reason: collision with root package name */
    public static final String f247945h = "sp_security_flag_name";

    /* renamed from: i, reason: collision with root package name */
    private static final AtomicBoolean f247946i;

    /* renamed from: j, reason: collision with root package name */
    public static final int f247947j = 2;

    /* renamed from: k, reason: collision with root package name */
    private static int f247948k = 0;

    /* renamed from: l, reason: collision with root package name */
    public static final int f247949l = 4;

    /* renamed from: a, reason: collision with root package name */
    private MsfCore f247950a;

    /* renamed from: b, reason: collision with root package name */
    private final ChannelProxyExt f247951b;

    /* renamed from: c, reason: collision with root package name */
    private final g f247952c;

    /* renamed from: d, reason: collision with root package name */
    public IFEKitLog f247953d;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.msf.core.d0.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    class C8074a extends ChannelProxyExt {
        static IPatchRedirector $redirector_;

        C8074a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.channel.ChannelProxyExt
        public void sendMessage(String str, byte[] bArr, String str2, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, bArr, str2, Long.valueOf(j3));
                return;
            }
            ToServiceMsg toServiceMsg = new ToServiceMsg(a.f247943f, str2, str);
            toServiceMsg.setMsfCommand(MsfCommand.msf_FEKit);
            toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
            toServiceMsg.setRequestSsoSeq(a.this.f247950a.getNextSeq());
            toServiceMsg.setTimeout(30000L);
            toServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_KEY_SECURITY_CALLBACK_ID, Long.valueOf(j3));
            int length = bArr.length + 4;
            ByteBuffer allocate = ByteBuffer.allocate(length);
            allocate.order(ByteOrder.BIG_ENDIAN);
            allocate.putInt(length);
            allocate.put(bArr);
            toServiceMsg.putWupBuffer(allocate.array());
            QLog.d(a.f247942e, 1, "[FEKitManager] sendMessage with to: " + toServiceMsg);
            a.this.f247950a.sendSsoMsg(toServiceMsg);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements g {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.fe.g
        public void dispatchEventToApp(String str, byte[] bArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) bArr);
                return;
            }
            FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), a.this.f247950a.getNextSeq(), a.this.f247950a.getMainAccount(), BaseConstants.CMD_SEC_DISPATCH_TO_APP);
            fromServiceMsg.setMsfCommand(MsfCommand.msf_sec_dispatch_to_app_event);
            fromServiceMsg.putWupBuffer(bArr);
            fromServiceMsg.setRequestSsoSeq(a.this.f247950a.getNextSeq());
            fromServiceMsg.setMsgSuccess();
            fromServiceMsg.addAttribute(BaseConstants.KEY_SEC_EVENT, str);
            if (a.this.f247950a.pushManager.r()) {
                fromServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_RESP_NEEDBOOTAPP, 1);
            }
            MsfSdkUtils.addFromMsgProcessName(MsfSdkUtils.getMainProcessName(), fromServiceMsg);
            a.this.f247950a.addRespToQuque(null, fromServiceMsg);
            QLog.d(a.f247942e, 1, "[FEKitManager] dispatchEventToApp with from: " + fromServiceMsg);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c extends IFEKitLog {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.fe.IFEKitLog
        public void d(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2);
            } else {
                QLog.d(str, i3, str2);
            }
        }

        @Override // com.tencent.mobileqq.fe.IFEKitLog
        public void e(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), str2);
            } else {
                QLog.e(str, i3, str2);
            }
        }

        @Override // com.tencent.mobileqq.fe.IFEKitLog
        public void i(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2);
            } else {
                QLog.i(str, i3, str2);
            }
        }

        @Override // com.tencent.mobileqq.fe.IFEKitLog
        public void v(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2);
            } else {
                QLog.i(str, i3, str2);
            }
        }

        @Override // com.tencent.mobileqq.fe.IFEKitLog
        public void w(String str, int i3, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2);
            } else {
                QLog.w(str, i3, str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class d implements Runnable {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            } else {
                FEKit.getInstance().requestToken();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f247958a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28073);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f247958a = new a(null);
            }
        }

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27402);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f247946i = new AtomicBoolean(false);
            f247948k = 2;
        }
    }

    /* synthetic */ a(C8074a c8074a) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) c8074a);
    }

    public static a c() {
        return e.f247958a;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return FEKit.getInstance().mInit;
    }

    public boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return f247946i.get();
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        QLog.d(f247942e, 1, "invoke onConnOpened start");
        FEKit.getInstance().onConnOpened();
        QLog.d(f247942e, 1, "invoke onConnOpened end");
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f247951b = new C8074a();
        this.f247952c = new b();
        this.f247953d = new c();
        f247948k = BaseApplication.getContext().getSharedPreferences(f247944g, 0).getInt(f247945h, 2);
        QLog.d(f247942e, 1, "FEKitManager read security sign flag from sp, value = " + f247948k);
    }

    public void a(MsfCore msfCore, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msfCore, (Object) str);
            return;
        }
        if (f247946i.compareAndSet(false, true)) {
            QLog.d(f247942e, 1, "FEKitManager init");
            this.f247950a = msfCore;
            FEKit.getInstance().init(BaseApplication.getContext(), this.f247950a.getMainAccount(), util.buf_to_string(NetConnInfoCenter.GUID), "", str, BaseApplication.getContext().getQua());
            FEKit.getInstance().initLog(this.f247953d);
            FEKit.getInstance().setAppEventDispatcher(this.f247952c);
            ChannelManager.getInstance().init(this.f247951b);
            q.s().post(new d());
        }
    }

    public void a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            QLog.d(f247942e, 1, "[FEKitManager] handleSecServiceResp with to: " + toServiceMsg + "; from: " + fromServiceMsg);
            Long l3 = 0L;
            try {
                l3 = (Long) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_KEY_SECURITY_CALLBACK_ID);
            } catch (Exception e16) {
                QLog.e(f247942e, 1, "[FEKitManager] get callBackId error ", e16);
            }
            byte[] wupBuffer = fromServiceMsg.getWupBuffer();
            if (fromServiceMsg.getWupBuffer().length >= 4) {
                int length = fromServiceMsg.getWupBuffer().length - 4;
                byte[] bArr2 = new byte[length];
                System.arraycopy(fromServiceMsg.getWupBuffer(), 4, bArr2, 0, length);
                bArr = bArr2;
            } else {
                bArr = wupBuffer;
            }
            QLog.d(f247942e, 1, "invoke handleSecServiceResp start");
            ChannelManager.getInstance().onReceive(fromServiceMsg.getServiceCmd(), bArr, fromServiceMsg.getBusinessFailCode() == 1000, fromServiceMsg.getBusinessFailCode(), l3.longValue());
            QLog.d(f247942e, 1, "invoke handleSecServiceResp end");
            return;
        }
        QLog.d(f247942e, 1, "[FEKitManager] handleSecServiceResp with null toServiceMsg and fromServiceMsg");
    }

    public void a(String str, String str2, EventCallback eventCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, eventCallback);
            return;
        }
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isReleaseVersion() && f247948k == 0) {
            QLog.d(f247942e, 1, "handleSecDispatchEvent failed, return by not init or close security sign");
            return;
        }
        try {
            QLog.d(f247942e, 1, "invoke handleSecDispatchEvent start");
            FEKit.getInstance().dispatchEvent(str, str2, eventCallback);
            QLog.d(f247942e, 1, "invoke handleSecDispatchEvent end");
        } catch (Exception e16) {
            QLog.d(f247942e, 1, "dispatchEvent error, ", e16);
        }
    }

    public void a(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (b()) {
            if (BaseApplication.getContext().getMSFInterfaceAdapter().isReleaseVersion() && f247948k == 0) {
                return;
            }
            QLog.d(f247942e, 1, "invoke onReceiveSecError start");
            FEKit.getInstance().onReceiveSecError(str, j3, j16);
            QLog.d(f247942e, 1, "invoke onReceiveSecError end");
        }
    }

    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).booleanValue();
        }
        QLog.d(f247942e, 1, "invoke isNeedSign start");
        boolean needSign = FEKit.getInstance().needSign(str);
        QLog.d(f247942e, 1, "invoke isNeedSign end");
        return needSign;
    }

    public QQSecuritySign.SignResult a(ToServiceMsg toServiceMsg, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (QQSecuritySign.SignResult) iPatchRedirector.redirect((short) 11, (Object) this, (Object) toServiceMsg, (Object) str);
        }
        QLog.d(f247942e, 1, "invoke getSign start");
        byte[] wupBuffer = toServiceMsg.getWupBuffer();
        if (toServiceMsg.getWupBuffer().length >= 4) {
            int length = toServiceMsg.getWupBuffer().length - 4;
            byte[] bArr = new byte[length];
            System.arraycopy(toServiceMsg.getWupBuffer(), 4, bArr, 0, length);
            wupBuffer = bArr;
        }
        QQSecuritySign.SignResult sign = FEKit.getInstance().getSign(str, wupBuffer, toServiceMsg.getRequestSsoSeq(), toServiceMsg.getUin());
        QLog.d(f247942e, 1, "invoke getSign end");
        return sign;
    }

    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, i3);
            return;
        }
        f247948k = i3;
        BaseApplication.getContext().getSharedPreferences(f247944g, 0).edit().putInt(f247945h, i3).apply();
        QLog.d(f247942e, 1, "[FEKitManager] set and save sec_sign_flag = " + i3);
    }

    public int a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) ? f247948k : ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
    }
}
