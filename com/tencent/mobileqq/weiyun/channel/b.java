package com.tencent.mobileqq.weiyun.channel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.weiyun.pb.WeiyunPB$MsgHead;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicInteger f315149c;

    /* renamed from: a, reason: collision with root package name */
    private final WeiyunPB$MsgHead f315150a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f315151b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19843);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f315149c = new AtomicInteger(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(WeiyunPB$MsgHead weiyunPB$MsgHead, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) weiyunPB$MsgHead, (Object) bArr);
        } else {
            this.f315150a = weiyunPB$MsgHead;
            this.f315151b = bArr;
        }
    }

    private WeiyunPB$MsgHead a(int i3) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        WeiyunPB$MsgHead weiyunPB$MsgHead = new WeiyunPB$MsgHead();
        weiyunPB$MsgHead.uin.set(waitAppRuntime.getLongAccountUin());
        weiyunPB$MsgHead.seq.set(d());
        weiyunPB$MsgHead.type.set(1);
        weiyunPB$MsgHead.cmd.set(i3);
        weiyunPB$MsgHead.emulator_flag.set(0);
        weiyunPB$MsgHead.appid.set(31532);
        weiyunPB$MsgHead.encrypt.set(0);
        weiyunPB$MsgHead.zip_flag.set(0);
        weiyunPB$MsgHead.version.set(com.tencent.mobileqq.weiyun.utils.b.a());
        weiyunPB$MsgHead.fix_version.set(com.tencent.mobileqq.weiyun.utils.b.d());
        weiyunPB$MsgHead.nettype.set(NetworkUtil.getNetworkType(waitAppRuntime.getApplication()));
        weiyunPB$MsgHead.major_version.set(com.tencent.mobileqq.weiyun.utils.b.b());
        weiyunPB$MsgHead.minor_version.set(com.tencent.mobileqq.weiyun.utils.b.c());
        return weiyunPB$MsgHead;
    }

    public byte[] b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (byte[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f315151b;
    }

    public WeiyunPB$MsgHead c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (WeiyunPB$MsgHead) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.f315150a;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        return f315149c.getAndIncrement();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bArr);
        } else {
            this.f315151b = bArr;
            this.f315150a = a(i3);
        }
    }
}
