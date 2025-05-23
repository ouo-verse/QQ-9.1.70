package com.tencent.mobileqq.weiyun.channel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$MsgHead;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.weiyun.transmission.ErrorCode;
import com.tencent.weiyun.utils.Singleton;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static Singleton<d, Void> f315153d;

    /* renamed from: a, reason: collision with root package name */
    private AtomicInteger f315154a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<Integer, b> f315155b;

    /* renamed from: c, reason: collision with root package name */
    private long f315156c;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class a extends Singleton<d, Void> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.weiyun.utils.Singleton
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d create(Void r46) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46);
            }
            return new d(null);
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface b {
        void a(int i3, String str, byte[] bArr);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19854);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f315153d = new a();
        }
    }

    /* synthetic */ d(a aVar) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar);
    }

    public static d a() {
        return f315153d.get(null);
    }

    private void d(int i3, String str, byte[] bArr) {
        int parseInt;
        if (str != null && str.length() != 0) {
            if (QLog.isColorLevel()) {
                QLog.d("WySender", 1, "sendRequestInner : seq[" + i3 + "], cmd[" + str + "]");
            }
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (str.contains(".")) {
                String[] split = str.split("\\.");
                parseInt = Integer.parseInt(split[split.length - 1]);
            } else {
                parseInt = Integer.parseInt(str);
            }
            com.tencent.mobileqq.weiyun.channel.b bVar = new com.tencent.mobileqq.weiyun.channel.b(parseInt, bArr);
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", waitAppRuntime.getAccount(), str);
            toServiceMsg.setTimeout(Math.min(60000L, (long) (Math.pow(this.f315156c, 0.15d) * 30000.0d)));
            toServiceMsg.setEnableFastResend(true);
            toServiceMsg.putWupBuffer(c.b(bVar));
            toServiceMsg.extraData.putInt("sequence", i3);
            toServiceMsg.extraData.putLong("sendtimekey", System.currentTimeMillis());
            NewIntent newIntent = new NewIntent(waitAppRuntime.getApplication(), e.class);
            newIntent.putExtra(ToServiceMsg.class.getSimpleName(), toServiceMsg);
            waitAppRuntime.startServlet(newIntent);
            return;
        }
        QLog.e("WySender", 1, "sendRequestInner : seq[" + i3 + "], cmd is empty");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        int resultCode;
        com.tencent.mobileqq.weiyun.channel.b bVar;
        int i3 = toServiceMsg.extraData.getInt("sequence");
        if (fromServiceMsg.isSuccess()) {
            resultCode = 0;
        } else {
            resultCode = fromServiceMsg.getResultCode();
        }
        if (resultCode == 1002) {
            this.f315156c++;
        } else {
            this.f315156c = 1L;
        }
        byte[] bArr = null;
        if (resultCode == 0) {
            bVar = c.a(fromServiceMsg.getWupBuffer());
        } else {
            bVar = null;
        }
        String businessFailMsg = fromServiceMsg.getBusinessFailMsg();
        if (resultCode == 1002) {
            businessFailMsg = "(1002)" + businessFailMsg;
        }
        if (resultCode == 0) {
            if (bVar == null) {
                resultCode = ErrorCode.CMD_SERVER_ERROR;
            } else {
                WeiyunPB$MsgHead c16 = bVar.c();
                int i16 = c16.retcode.get();
                if (i16 != 0) {
                    businessFailMsg = c16.retmsg.get();
                    resultCode = i16;
                }
            }
        }
        b remove = this.f315155b.remove(Integer.valueOf(i3));
        if (remove != null) {
            if (bVar != null) {
                bArr = bVar.b();
            }
            remove.a(resultCode, businessFailMsg, bArr);
        }
    }

    public void c(String str, byte[] bArr, b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, bArr, bVar);
            return;
        }
        int incrementAndGet = this.f315154a.incrementAndGet();
        if (bVar != null) {
            this.f315155b.put(Integer.valueOf(incrementAndGet), bVar);
        }
        d(incrementAndGet, str, bArr);
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f315154a = new AtomicInteger(0);
        this.f315155b = new ConcurrentHashMap<>();
        this.f315156c = 1L;
    }
}
