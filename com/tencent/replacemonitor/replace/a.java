package com.tencent.replacemonitor.replace;

import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.replacemonitor.jce.GetMobilePhoneQqApkInfoRequest;
import com.tencent.replacemonitor.jce.GetMobilePhoneQqApkInfoResponse;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends com.tencent.tmassistantbase.network.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private InterfaceC9737a f364888d;

    /* compiled from: P */
    /* renamed from: com.tencent.replacemonitor.replace.a$a, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC9737a {
        void a(int i3, int i16, long j3, String str, long j16, String str2);

        void b(int i3, int i16, String str);
    }

    public a(InterfaceC9737a interfaceC9737a) {
        super(GetMobilePhoneQqApkInfoRequest.class, GetMobilePhoneQqApkInfoResponse.class);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) interfaceC9737a);
        } else {
            this.f364888d = interfaceC9737a;
        }
    }

    @Override // com.tencent.tmassistantbase.network.a
    public void a(int i3, int i16, JceStruct jceStruct, JceStruct jceStruct2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), jceStruct, jceStruct2);
            return;
        }
        if (i16 == 0 && (jceStruct2 instanceof GetMobilePhoneQqApkInfoResponse)) {
            GetMobilePhoneQqApkInfoResponse getMobilePhoneQqApkInfoResponse = (GetMobilePhoneQqApkInfoResponse) jceStruct2;
            int i17 = getMobilePhoneQqApkInfoResponse.ret;
            if (i17 == 0) {
                this.f364888d.a(i3, getMobilePhoneQqApkInfoResponse.strategy, getMobilePhoneQqApkInfoResponse.fileSize, getMobilePhoneQqApkInfoResponse.apkMd5, getMobilePhoneQqApkInfoResponse.maxFileSize, getMobilePhoneQqApkInfoResponse.channelId);
                return;
            } else {
                this.f364888d.b(i3, i17, getMobilePhoneQqApkInfoResponse.f364887msg);
                return;
            }
        }
        this.f364888d.b(i3, i16, "response is " + jceStruct2);
    }
}
