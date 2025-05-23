package com.tencent.mobileqq.Doraemon.impl.webview;

import android.os.Bundle;
import android.util.LruCache;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.miniapp.d;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import tencent.im.oidb.oidb_0xb60$ReqBody;
import tencent.im.oidb.oidb_0xb60$RspBody;

/* compiled from: P */
/* loaded from: classes9.dex */
public class VerifyUrlJobSegment extends JobSegment<d, d> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    static LruCache<String, Long> f154207e;

    /* renamed from: d, reason: collision with root package name */
    String f154208d;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class UrlNotauthorizedError extends Error {
        static IPatchRedirector $redirector_;

        public UrlNotauthorizedError() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ d f154209d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f154210e;

        a(d dVar, String str) {
            this.f154209d = dVar;
            this.f154210e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, VerifyUrlJobSegment.this, dVar, str);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0165  */
        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            QLog.i("DoraemonOpenAPI.jobVerifyUrl", 1, "onResult type=" + this.f154209d.f246793b + ", appid=" + this.f154209d.f246792a + ", url=" + VerifyUrlJobSegment.this.f154208d + ", code=" + i3);
            if (i3 == 0 && bArr != null) {
                oidb_0xb60$RspBody oidb_0xb60_rspbody = new oidb_0xb60$RspBody();
                try {
                    oidb_0xb60_rspbody.mergeFrom(bArr);
                    if (!oidb_0xb60_rspbody.check_url_rsp.has()) {
                        VerifyUrlJobSegment.this.notifyError(new AppInfoError(7, "jobVerifyUrl rsp invalid"));
                        QLog.i("DoraemonOpenAPI.jobVerifyUrl", 1, "rsp invalid");
                        return;
                    }
                    QLog.d("DoraemonOpenAPI.jobVerifyUrl", 1, "receive is_auth:" + oidb_0xb60_rspbody.check_url_rsp.is_authed.get() + ", duration:" + oidb_0xb60_rspbody.check_url_rsp.next_req_duration.get());
                    if (!oidb_0xb60_rspbody.check_url_rsp.is_authed.get()) {
                        VerifyUrlJobSegment.this.notifyError(new UrlNotauthorizedError());
                        return;
                    }
                    VerifyUrlJobSegment.f154207e.put(this.f154210e, Long.valueOf(NetConnInfoCenter.getServerTimeMillis() + (oidb_0xb60_rspbody.check_url_rsp.next_req_duration.get() * 1000)));
                    QLog.i("DoraemonOpenAPI.jobVerifyUrl", 1, "sendOIDBRequest, onResult, appInfo=" + this.f154209d);
                    VerifyUrlJobSegment.this.notifyResult(this.f154209d);
                    return;
                } catch (InvalidProtocolBufferMicroException e16) {
                    VerifyUrlJobSegment.this.notifyError(new AppInfoError(7, "jobVerifyUrl parse rsp error"));
                    QLog.i("DoraemonOpenAPI.jobVerifyUrl", 1, "parse rsp error", e16);
                    return;
                }
            }
            VerifyUrlJobSegment.this.notifyError(new AppInfoError(7, "jobVerifyUrl req error " + i3));
            if (bArr != null) {
                try {
                    str = new oidb_0xb60$RspBody().mergeFrom(bArr).wording.get();
                } catch (InvalidProtocolBufferMicroException unused) {
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("req error code=");
                sb5.append(i3);
                if (bArr != null) {
                    str2 = ", data=null";
                } else {
                    str2 = ", msg=" + str;
                }
                sb5.append(str2);
                QLog.i("DoraemonOpenAPI.jobVerifyUrl", 1, sb5.toString());
            }
            str = "";
            StringBuilder sb52 = new StringBuilder();
            sb52.append("req error code=");
            sb52.append(i3);
            if (bArr != null) {
            }
            sb52.append(str2);
            QLog.i("DoraemonOpenAPI.jobVerifyUrl", 1, sb52.toString());
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32985);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f154207e = new LruCache<>(16);
        }
    }

    public VerifyUrlJobSegment(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f154208d = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tribe.async.async.JobSegment
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public void runSegment(JobContext jobContext, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jobContext, (Object) dVar);
            return;
        }
        String str = dVar.f246807p + util.base64_pad_url + this.f154208d;
        Long l3 = f154207e.get(str);
        if (l3 != null && l3.longValue() > NetConnInfoCenter.getServerTimeMillis()) {
            QLog.i("DoraemonOpenAPI.jobVerifyUrl", 1, "cache hit");
            notifyResult(dVar);
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            notifyError(new AppInfoError(7, "jobVerifyUrl app is null"));
            QLog.i("DoraemonOpenAPI.jobVerifyUrl", 1, "app is null");
            return;
        }
        try {
            int parseInt = Integer.parseInt(dVar.f246792a);
            oidb_0xb60$ReqBody oidb_0xb60_reqbody = new oidb_0xb60$ReqBody();
            oidb_0xb60_reqbody.check_url_req.setHasFlag(true);
            oidb_0xb60_reqbody.check_url_req.url.set(this.f154208d);
            oidb_0xb60_reqbody.check_url_req.appid.set(parseInt);
            oidb_0xb60_reqbody.check_url_req.app_type.set(dVar.f246793b);
            QLog.i("DoraemonOpenAPI.jobVerifyUrl", 1, "send type=" + dVar.f246793b + ", appid=" + dVar.f246792a + ", url=" + this.f154208d);
            ProtoUtils.c(waitAppRuntime, new a(dVar, str), oidb_0xb60_reqbody.toByteArray(), "OidbSvc.0xb60_2", 2912, 2, null, 0L);
        } catch (NumberFormatException unused) {
            notifyError(new AppInfoError(7, "jobVerifyUrl parse appid error"));
            QLog.i("DoraemonOpenAPI.jobVerifyUrl", 1, "parse appid error");
        }
    }
}
