package com.tencent.mobileqq.Doraemon.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.Doraemon.IDoraemonApi;
import com.tencent.mobileqq.Doraemon.i;
import com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError;
import com.tencent.mobileqq.Doraemon.impl.webview.VerifyUrlJobSegment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.oidb_0xb60$ClientInfo;
import tencent.im.oidb.oidb_0xb60$ReqBody;
import tencent.im.oidb.oidb_0xb60$RspBody;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DefaultDoraemonAppInfoHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    private static DefaultDoraemonAppInfoHelper f154101g;

    /* renamed from: a, reason: collision with root package name */
    final Object f154102a;

    /* renamed from: b, reason: collision with root package name */
    boolean f154103b;

    /* renamed from: c, reason: collision with root package name */
    JSONObject f154104c;

    /* renamed from: d, reason: collision with root package name */
    Map<String, i> f154105d;

    /* renamed from: e, reason: collision with root package name */
    long f154106e;

    /* renamed from: f, reason: collision with root package name */
    long f154107f;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a extends SimpleObserver<com.tencent.mobileqq.miniapp.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f154110a;

        a(g gVar) {
            this.f154110a = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DefaultDoraemonAppInfoHelper.this, (Object) gVar);
            }
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(com.tencent.mobileqq.miniapp.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
                return;
            }
            QLog.i("DoraemonOpenAPI.permissionHelper", 1, "getAppInfo(), onNext, result=" + dVar);
            g gVar = this.f154110a;
            if (dVar.f246799h != 1) {
                i3 = 3;
            }
            gVar.a(dVar, i3);
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onError(Error error) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) error);
                return;
            }
            QLog.i("DoraemonOpenAPI.permissionHelper", 1, "getAppInfo(), onError: " + error.getMessage());
            if (error instanceof AppInfoError) {
                i3 = ((AppInfoError) error).type;
            } else {
                i3 = 0;
            }
            this.f154110a.a(null, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b extends JobSegment<com.tencent.mobileqq.miniapp.d, com.tencent.mobileqq.miniapp.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f154112d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f154113e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a extends com.tencent.mobileqq.miniapp.e<JobSegment> {
            static IPatchRedirector $redirector_;

            a(JobSegment jobSegment) {
                super(jobSegment);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this, (Object) jobSegment);
                }
            }

            @Override // com.tencent.mobileqq.miniapp.e
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(JobSegment jobSegment, boolean z16, com.tencent.mobileqq.miniapp.d dVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, jobSegment, Boolean.valueOf(z16), dVar);
                    return;
                }
                QLog.i("DoraemonOpenAPI.permissionHelper", 1, "IDoraemonApi#getAppInfo(), onResult, success=" + z16 + ",appInfo=" + dVar);
                if (z16) {
                    b.this.notifyResult(dVar);
                } else {
                    b.this.notifyError(new AppInfoError(5, "appInfo error"));
                }
            }
        }

        b(String str, int i3) {
            this.f154112d = str;
            this.f154113e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DefaultDoraemonAppInfoHelper.this, str, Integer.valueOf(i3));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tribe.async.async.JobSegment
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void runSegment(JobContext jobContext, com.tencent.mobileqq.miniapp.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jobContext, (Object) dVar);
            } else {
                ((IDoraemonApi) QRoute.api(IDoraemonApi.class)).getAppInfo(this.f154112d, this.f154113e, 1, true, new a(this));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class c extends SimpleObserver<com.tencent.mobileqq.miniapp.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f154116a;

        c(g gVar) {
            this.f154116a = gVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) DefaultDoraemonAppInfoHelper.this, (Object) gVar);
            }
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(com.tencent.mobileqq.miniapp.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
                return;
            }
            QLog.i("DoraemonOpenAPI.permissionHelper", 1, "getAppInfoForWebView(), result=" + dVar);
            g gVar = this.f154116a;
            if (dVar.f246799h != 1) {
                i3 = 3;
            }
            gVar.a(dVar, i3);
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onError(Error error) {
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) error);
                return;
            }
            QLog.i("DoraemonOpenAPI.permissionHelper", 1, "getAppInfoForWebView(), onError: " + error.getMessage());
            if (error instanceof VerifyUrlJobSegment.UrlNotauthorizedError) {
                i3 = 4;
            } else if (error instanceof AppInfoError) {
                i3 = ((AppInfoError) error).type;
            } else {
                i3 = 0;
            }
            this.f154116a.a(null, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d extends JobSegment<com.tencent.mobileqq.miniapp.d, com.tencent.mobileqq.miniapp.d> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f154118d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f154119e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a extends com.tencent.mobileqq.miniapp.e<JobSegment> {
            static IPatchRedirector $redirector_;

            a(JobSegment jobSegment) {
                super(jobSegment);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this, (Object) jobSegment);
                }
            }

            @Override // com.tencent.mobileqq.miniapp.e
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(JobSegment jobSegment, boolean z16, com.tencent.mobileqq.miniapp.d dVar) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, jobSegment, Boolean.valueOf(z16), dVar);
                    return;
                }
                QLog.i("DoraemonOpenAPI.permissionHelper", 1, "getAppInfoForWebView(), success=" + z16 + ", appInfo=" + dVar);
                if (z16) {
                    d.this.notifyResult(dVar);
                } else {
                    d.this.notifyError(new AppInfoError(5, "appInfo error"));
                }
            }
        }

        d(String str, int i3) {
            this.f154118d = str;
            this.f154119e = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DefaultDoraemonAppInfoHelper.this, str, Integer.valueOf(i3));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tribe.async.async.JobSegment
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void runSegment(JobContext jobContext, com.tencent.mobileqq.miniapp.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jobContext, (Object) dVar);
            } else if (dVar.a()) {
                notifyResult(dVar);
                QLog.i("DoraemonOpenAPI.permissionHelper", 1, "appBaseInfo cache is valid");
            } else {
                ((IDoraemonApi) QRoute.api(IDoraemonApi.class)).getAppInfo(this.f154118d, this.f154119e, 1, true, new a(this));
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class e extends JobSegment<com.tencent.mobileqq.miniapp.d, com.tencent.mobileqq.miniapp.d> {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tribe.async.async.JobSegment
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void runSegment(JobContext jobContext, com.tencent.mobileqq.miniapp.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jobContext, (Object) dVar);
                return;
            }
            DefaultDoraemonAppInfoHelper h16 = DefaultDoraemonAppInfoHelper.h();
            if (!h16.f154103b) {
                h16.k();
            }
            notifyResult(dVar);
        }

        /* synthetic */ e(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    private static class f extends JobSegment<com.tencent.mobileqq.miniapp.d, com.tencent.mobileqq.miniapp.d> {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes9.dex */
        public class a extends ProtoUtils.TroopProtocolObserver {
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.miniapp.d f154122d;

            a(com.tencent.mobileqq.miniapp.d dVar) {
                this.f154122d = dVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) f.this, (Object) dVar);
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:43:0x018e  */
            /* JADX WARN: Removed duplicated region for block: B:46:0x0192  */
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
                QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 1, "onResult type=" + this.f154122d.f246793b + ", appid=" + this.f154122d.f246792a + ", code=" + i3);
                if (i3 != 0 || bArr == null) {
                    f.this.notifyError(new AppInfoError(6, "jobApiPermission req error"));
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
                        QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 1, sb5.toString());
                        return;
                    }
                    str = "";
                    StringBuilder sb52 = new StringBuilder();
                    sb52.append("req error code=");
                    sb52.append(i3);
                    if (bArr != null) {
                    }
                    sb52.append(str2);
                    QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 1, sb52.toString());
                    return;
                }
                oidb_0xb60$RspBody oidb_0xb60_rspbody = new oidb_0xb60$RspBody();
                try {
                    oidb_0xb60_rspbody.mergeFrom(bArr);
                    if (oidb_0xb60_rspbody.get_privilege_rsp.api_groups.has() && oidb_0xb60_rspbody.get_privilege_rsp.next_req_duration.has()) {
                        QLog.d("DoraemonOpenAPI.permissionHelper.jobApiPermission", 1, "receive api_groups:" + oidb_0xb60_rspbody.get_privilege_rsp.api_groups.get() + ", api_names:" + oidb_0xb60_rspbody.get_privilege_rsp.api_names.get());
                        DefaultDoraemonAppInfoHelper h16 = DefaultDoraemonAppInfoHelper.h();
                        h16.e(oidb_0xb60_rspbody.get_privilege_rsp.api_groups.get(), this.f154122d.f246806o);
                        if (oidb_0xb60_rspbody.get_privilege_rsp.api_names.size() > 0) {
                            for (String str3 : oidb_0xb60_rspbody.get_privilege_rsp.api_names.get()) {
                                if (h16.j(str3)) {
                                    this.f154122d.f246806o.add(str3);
                                }
                            }
                        }
                        this.f154122d.f246805n = NetConnInfoCenter.getServerTimeMillis() + Math.max(oidb_0xb60_rspbody.get_privilege_rsp.next_req_duration.get() * 1000, MiniBoxNoticeInfo.MIN_5);
                        QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 1, "IDoraemonApi#putAppInfo, appInfo=" + this.f154122d);
                        ((IDoraemonApi) QRoute.api(IDoraemonApi.class)).putAppInfo(this.f154122d);
                        f.this.notifyResult(this.f154122d);
                        return;
                    }
                    f.this.notifyError(new AppInfoError(6, "jobApiPermission rsp invalid"));
                    QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 1, "rsp invalid");
                } catch (InvalidProtocolBufferMicroException e16) {
                    f.this.notifyError(new AppInfoError(6, "jobApiPermission parse rsp error"));
                    QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 1, "parse rsp error", e16);
                }
            }
        }

        f() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tribe.async.async.JobSegment
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void runSegment(JobContext jobContext, com.tencent.mobileqq.miniapp.d dVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) jobContext, (Object) dVar);
                return;
            }
            if (dVar.c()) {
                notifyResult(dVar);
                QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 1, "cache is valid");
                return;
            }
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (waitAppRuntime == null) {
                notifyError(new AppInfoError(6, "jobApiPermission app is null"));
                QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 1, "app is null");
                return;
            }
            try {
                int parseInt = Integer.parseInt(dVar.f246792a);
                oidb_0xb60$ReqBody oidb_0xb60_reqbody = new oidb_0xb60$ReqBody();
                oidb_0xb60_reqbody.get_privilege_req.setHasFlag(true);
                oidb_0xb60_reqbody.get_privilege_req.appid.set(parseInt);
                oidb_0xb60_reqbody.get_privilege_req.app_type.set(dVar.f246793b);
                if (dVar.f246793b == 1) {
                    oidb_0xb60$ClientInfo oidb_0xb60_clientinfo = new oidb_0xb60$ClientInfo();
                    oidb_0xb60_clientinfo.platform.set(1);
                    if (!TextUtils.isEmpty(dVar.f246811t)) {
                        oidb_0xb60_clientinfo.sdk_version.set(dVar.f246811t);
                    }
                    if (!TextUtils.isEmpty(dVar.f246809r)) {
                        oidb_0xb60_clientinfo.android_package_name.set(dVar.f246809r);
                    }
                    if (!TextUtils.isEmpty(dVar.f246810s)) {
                        oidb_0xb60_clientinfo.android_signature.set(dVar.f246810s);
                    }
                    oidb_0xb60_reqbody.client_info.set(oidb_0xb60_clientinfo);
                }
                QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 1, "send type=" + dVar.f246793b + ", appid=" + dVar.f246792a);
                ProtoUtils.c(waitAppRuntime, new a(dVar), oidb_0xb60_reqbody.toByteArray(), "OidbSvc.0xb60_1", 2912, 1, null, 0L);
            } catch (NumberFormatException unused) {
                notifyError(new AppInfoError(6, "jobApiPermission parse appid error"));
                QLog.i("DoraemonOpenAPI.permissionHelper.jobApiPermission", 1, "parse appid error");
            }
        }

        /* synthetic */ f(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) anonymousClass1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface g {
        void a(com.tencent.mobileqq.miniapp.d dVar, int i3);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32823);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f154101g = new DefaultDoraemonAppInfoHelper();
            ((IDoraemonApi) QRoute.api(IDoraemonApi.class)).initBosses();
        }
    }

    public DefaultDoraemonAppInfoHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f154102a = new Object();
        this.f154103b = false;
        this.f154105d = new HashMap();
        this.f154106e = 0L;
        this.f154107f = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (Exception e16) {
            QLog.d("DoraemonOpenAPI.permissionHelper", 1, "closeClosable error : ", e16);
        }
    }

    public static DefaultDoraemonAppInfoHelper h() {
        return f154101g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean j(String str) {
        JSONArray optJSONArray;
        JSONObject jSONObject = this.f154104c;
        if (jSONObject == null) {
            return false;
        }
        if (this.f154105d.get(str) != null) {
            return true;
        }
        Iterator keys = jSONObject.keys();
        while (keys.hasNext()) {
            JSONObject optJSONObject = jSONObject.optJSONObject((String) keys.next());
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("apis")) != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    if (TextUtils.equals(str, optJSONArray.optString(i3))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean l(String str) {
        try {
            this.f154104c = new JSONObject(str);
            this.f154105d.clear();
            return true;
        } catch (JSONException unused) {
            QLog.e("DoraemonOpenAPI.permissionHelper", 1, "parseGroupData error");
            return false;
        }
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0043: MOVE (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]) (LINE:68), block:B:28:0x0043 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0046 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String m(Context context, String str) {
        InputStreamReader inputStreamReader;
        InputStreamReader inputStreamReader2;
        InputStreamReader inputStreamReader3 = null;
        try {
            try {
                inputStreamReader = new InputStreamReader(context.getResources().getAssets().open(str));
            } catch (Exception e16) {
                e = e16;
                inputStreamReader = null;
            } catch (Throwable th5) {
                th = th5;
                if (inputStreamReader3 != null) {
                }
                throw th;
            }
            try {
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuilder sb5 = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb5.append(readLine);
                    sb5.append('\n');
                }
                String sb6 = sb5.toString();
                try {
                    inputStreamReader.close();
                } catch (IOException unused) {
                }
                return sb6;
            } catch (Exception e17) {
                e = e17;
                e.printStackTrace();
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException unused2) {
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStreamReader3 = inputStreamReader2;
            if (inputStreamReader3 != null) {
                try {
                    inputStreamReader3.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        if (serverTimeMillis > this.f154106e) {
            synchronized (this.f154102a) {
                if (serverTimeMillis > this.f154106e) {
                    this.f154106e = serverTimeMillis + MiniBoxNoticeInfo.MIN_5;
                    ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) DefaultDoraemonAppInfoHelper.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            String str;
                            String sb5;
                            AppRuntime waitAppRuntime;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            try {
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append("https://cgi.connect.qq.com/mqqapi/privilege_group_config?platform=1&platform_version=");
                                str = AppSetting.f99551k;
                                sb6.append(str);
                                sb6.append("&data_version=");
                                sb6.append(DefaultDoraemonAppInfoHelper.this.f154107f);
                                sb5 = sb6.toString();
                                waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
                            } catch (Throwable th5) {
                                QLog.e("DoraemonOpenAPI.permissionHelper", 1, "checkup error", th5);
                            }
                            if (waitAppRuntime == null) {
                                QLog.e("DoraemonOpenAPI.permissionHelper", 1, "app is null");
                                return;
                            }
                            String account = waitAppRuntime.getAccount();
                            Response execute = new OkHttpClient().newCall(new Request.Builder().addHeader("Cookie", "uin=" + account + ";skey=skey").addHeader("Referer", "https://connect.qq.com/").url(sb5).build()).execute();
                            JSONObject jSONObject = new JSONObject(execute.body().string());
                            int i3 = jSONObject.getInt("retcode");
                            QLog.i("DoraemonOpenAPI.permissionHelper", 1, "checkup code=" + i3);
                            if (i3 == 0) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                                long j3 = jSONObject2.getLong("version");
                                long j16 = jSONObject2.getLong("next_req_duration") * 1000;
                                if (DefaultDoraemonAppInfoHelper.this.f154107f == j3) {
                                    QLog.i("DoraemonOpenAPI.permissionHelper", 1, "no update, next=" + j16 + ", ver=" + j3);
                                    synchronized (DefaultDoraemonAppInfoHelper.this.f154102a) {
                                        DefaultDoraemonAppInfoHelper.this.f154106e = NetConnInfoCenter.getServerTimeMillis() + Math.max(MiniBoxNoticeInfo.MIN_5, j16);
                                    }
                                    DefaultDoraemonAppInfoHelper.this.d(execute);
                                    return;
                                }
                                JSONObject jSONObject3 = jSONObject2.getJSONObject("list");
                                synchronized (DefaultDoraemonAppInfoHelper.this.f154102a) {
                                    DefaultDoraemonAppInfoHelper.this.f154106e = NetConnInfoCenter.getServerTimeMillis() + Math.max(MiniBoxNoticeInfo.MIN_5, j16);
                                    DefaultDoraemonAppInfoHelper.this.f154107f = j3;
                                }
                                String jSONObject4 = jSONObject3.toString();
                                if (QLog.isColorLevel()) {
                                    QLog.d("DoraemonOpenAPI.permissionHelper", 2, "checkup, next=" + j16 + ", ver=" + j3 + ", list=" + jSONObject4);
                                }
                                synchronized (DefaultDoraemonAppInfoHelper.this) {
                                    DefaultDoraemonAppInfoHelper defaultDoraemonAppInfoHelper = DefaultDoraemonAppInfoHelper.this;
                                    defaultDoraemonAppInfoHelper.f154104c = jSONObject3;
                                    defaultDoraemonAppInfoHelper.f154105d.clear();
                                    BaseApplication.getContext().getSharedPreferences("DoraemonApiGroup.json", 4).edit().putString("content", jSONObject4).putLong("version", j3).putString("app_version", str).apply();
                                }
                                return;
                                QLog.e("DoraemonOpenAPI.permissionHelper", 1, "checkup error", th5);
                            }
                        }
                    }, 5, null, false);
                }
            }
        }
    }

    public void e(List<Integer> list, Set<String> set) {
        JSONArray optJSONArray;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list, (Object) set);
            return;
        }
        set.clear();
        JSONObject jSONObject = this.f154104c;
        if (jSONObject == null) {
            return;
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            JSONObject optJSONObject = jSONObject.optJSONObject(String.valueOf(it.next()));
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("apis")) != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    set.add(optJSONArray.optString(i3));
                }
            }
        }
    }

    public void f(String str, int i3, String str2, String str3, String str4, String str5, g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Integer.valueOf(i3), str2, str3, str4, str5, gVar);
            return;
        }
        com.tencent.mobileqq.miniapp.d appInfo = ((IDoraemonApi) QRoute.api(IDoraemonApi.class)).getAppInfo(str2, i3, 1, false, null, 1);
        QLog.i("DoraemonOpenAPI.permissionHelper", 1, "getAppInfo, cache MiniAppInfo=" + appInfo);
        if (appInfo != null) {
            ThreadManager.getUIHandler().post(new Runnable(gVar, appInfo) { // from class: com.tencent.mobileqq.Doraemon.impl.DefaultDoraemonAppInfoHelper.2
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ g f154108d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ com.tencent.mobileqq.miniapp.d f154109e;

                {
                    this.f154108d = gVar;
                    this.f154109e = appInfo;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DefaultDoraemonAppInfoHelper.this, gVar, appInfo);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    int i16 = 2;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    g gVar2 = this.f154108d;
                    com.tencent.mobileqq.miniapp.d dVar = this.f154109e;
                    if (dVar.f246799h != 1) {
                        i16 = 3;
                    }
                    gVar2.a(dVar, i16);
                }
            });
            return;
        }
        com.tencent.mobileqq.miniapp.d dVar = new com.tencent.mobileqq.miniapp.d(str2, i3);
        dVar.f246811t = str3;
        dVar.f246809r = str4;
        dVar.f246810s = str5;
        AnonymousClass1 anonymousClass1 = null;
        Stream.of(dVar).map(new ThreadOffFunction("DoraemonOpenAPI.permissionHelper", 16)).map(new e(anonymousClass1)).map(new f(anonymousClass1)).map(new b(str2, i3)).map(new UIThreadOffFunction(null)).subscribe(new a(gVar));
    }

    public void g(String str, int i3, String str2, String str3, g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), str2, str3, gVar);
            return;
        }
        com.tencent.mobileqq.miniapp.d appInfo = ((IDoraemonApi) QRoute.api(IDoraemonApi.class)).getAppInfo(str2, i3, 1, false, null, 1);
        if (appInfo == null) {
            appInfo = new com.tencent.mobileqq.miniapp.d(str2, i3);
        }
        AnonymousClass1 anonymousClass1 = null;
        Stream.of(appInfo).map(new ThreadOffFunction("DoraemonOpenAPI.permissionHelper", 16)).map(new e(anonymousClass1)).map(new VerifyUrlJobSegment(str3)).map(new f(anonymousClass1)).map(new d(str2, i3)).map(new UIThreadOffFunction(null)).subscribe(new c(gVar));
    }

    public i i(String str) {
        JSONArray optJSONArray;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (i) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        JSONObject jSONObject = this.f154104c;
        if (jSONObject == null) {
            return null;
        }
        i iVar = this.f154105d.get(str);
        if (iVar == null) {
            Iterator keys = jSONObject.keys();
            while (true) {
                if (!keys.hasNext()) {
                    break;
                }
                String str2 = (String) keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(str2);
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("apis")) != null) {
                    int length = optJSONArray.length();
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            if (TextUtils.equals(str, optJSONArray.optString(i3))) {
                                z16 = true;
                                break;
                            }
                            i3++;
                        } else {
                            z16 = false;
                            break;
                        }
                    }
                    if (z16) {
                        iVar = new i(str2, optJSONObject.optString("name"));
                        int length2 = optJSONArray.length();
                        for (int i16 = 0; i16 < length2; i16++) {
                            this.f154105d.put(optJSONArray.optString(i16), iVar);
                        }
                    }
                }
            }
        }
        return iVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0056 A[Catch: all -> 0x0083, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000c, B:11:0x0011, B:15:0x0017, B:17:0x0033, B:19:0x0040, B:21:0x0046, B:24:0x0056, B:26:0x0070, B:28:0x0076, B:29:0x007f), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void k() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f154103b) {
            return;
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("DoraemonApiGroup.json", 4);
        if (TextUtils.equals(sharedPreferences.getString("app_version", null), AppSetting.f99551k)) {
            String string = sharedPreferences.getString("content", null);
            if (!TextUtils.isEmpty(string)) {
                z16 = l(string);
                if (z16) {
                    this.f154107f = sharedPreferences.getLong("version", 0L);
                }
                if (!z16) {
                    QLog.i("DoraemonOpenAPI.permissionHelper", 1, "fail to read group info, use default");
                    String m3 = m(BaseApplication.getContext(), "DoraemonApiGroup.json");
                    if (!TextUtils.isEmpty(m3)) {
                        z16 = l(m3);
                    }
                    if (!z16) {
                        QLog.e("DoraemonOpenAPI.permissionHelper", 1, "fail to read default group info!");
                    }
                }
                this.f154103b = true;
            }
        }
        z16 = false;
        if (!z16) {
        }
        this.f154103b = true;
    }
}
