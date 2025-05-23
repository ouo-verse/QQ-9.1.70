package com.tencent.mobileqq.Doraemon.monitor;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.Doraemon.monitor.a;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.oidb_0xb6f$ReqBody;
import tencent.im.oidb.oidb_0xb6f$RspBody;

/* loaded from: classes9.dex */
public class DoraemonAPIReporterMain implements com.tencent.mobileqq.Doraemon.monitor.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    a.InterfaceC7087a f154228a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public class a extends ProtoUtils.TroopProtocolObserver {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f154248d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f154249e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f154250f;

        a(String str, String str2, int i3) {
            this.f154248d = str;
            this.f154249e = str2;
            this.f154250f = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, DoraemonAPIReporterMain.this, str, str2, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
        public void onResult(int i3, byte[] bArr, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("DoraemonOpenAPI.report", 2, "onResult key=" + this.f154248d + ", api=" + this.f154249e + ", count=" + this.f154250f + ", code=" + i3);
            }
            if (i3 == 0 && bArr != null) {
                oidb_0xb6f$RspBody oidb_0xb6f_rspbody = new oidb_0xb6f$RspBody();
                try {
                    oidb_0xb6f_rspbody.mergeFrom(bArr);
                    if (oidb_0xb6f_rspbody.report_freq_rsp.has()) {
                        DoraemonAPIReporterMain.this.g(this.f154248d, oidb_0xb6f_rspbody.report_freq_rsp.identity.apptype.get(), String.valueOf(oidb_0xb6f_rspbody.report_freq_rsp.identity.appid.get()), oidb_0xb6f_rspbody.report_freq_rsp.identity.apiName.get(), oidb_0xb6f_rspbody.report_freq_rsp.remain_times.get(), 1000 * oidb_0xb6f_rspbody.report_freq_rsp.expire_time.get());
                        return;
                    } else {
                        if (QLog.isColorLevel()) {
                            QLog.i("DoraemonOpenAPI.report", 2, "rsp invalid");
                            return;
                        }
                        return;
                    }
                } catch (InvalidProtocolBufferMicroException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i("DoraemonOpenAPI.report", 2, "parse rsp error", e16);
                        return;
                    }
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.i("DoraemonOpenAPI.report", 2, "req error");
            }
        }
    }

    public DoraemonAPIReporterMain() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void f(String str, int i3, String str2, String str3, int i16) {
        if (MobileQQ.sProcessId != 1) {
            QLog.e("DoraemonOpenAPI.report", 1, "process is not main process");
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            QLog.e("DoraemonOpenAPI.report", 1, "app is null");
            return;
        }
        oidb_0xb6f$ReqBody oidb_0xb6f_reqbody = new oidb_0xb6f$ReqBody();
        oidb_0xb6f_reqbody.report_freq_req.identity.apptype.set(i3);
        try {
            oidb_0xb6f_reqbody.report_freq_req.identity.appid.set(Integer.parseInt(str2));
            oidb_0xb6f_reqbody.report_freq_req.identity.apiName.set(str3);
            oidb_0xb6f_reqbody.report_freq_req.identity.setHasFlag(true);
            oidb_0xb6f_reqbody.report_freq_req.invoke_times.set(i16);
            oidb_0xb6f_reqbody.report_freq_req.setHasFlag(true);
            if (QLog.isColorLevel()) {
                QLog.i("DoraemonOpenAPI.report", 2, "send key=" + str + ", api=" + str3 + ", count=" + i16);
            }
            ProtoUtils.c(waitAppRuntime, new a(str, str3, i16), oidb_0xb6f_reqbody.toByteArray(), "OidbSvc.0xb6f_1", 2927, 1, null, 0L);
        } catch (NumberFormatException e16) {
            QLog.e("DoraemonOpenAPI.report", 1, "parse appid error appid=" + str2, e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, int i3, String str2, String str3, long j3, long j16) {
        if (QLog.isColorLevel()) {
            QLog.d("DoraemonOpenAPI.report", 2, "updateFrequenceData key=" + str + ", api=" + str3 + ", remain=" + j3 + ", exp=" + j16);
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null && MobileQQ.sProcessId == 1) {
            ThreadManagerV2.post(new Runnable(waitAppRuntime, i3, str2, str3, j3, j16) { // from class: com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.3
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AppRuntime f154233d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f154234e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f154235f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f154236h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ long f154237i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ long f154238m;

                {
                    this.f154233d = waitAppRuntime;
                    this.f154234e = i3;
                    this.f154235f = str2;
                    this.f154236h = str3;
                    this.f154237i = j3;
                    this.f154238m = j16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, DoraemonAPIReporterMain.this, waitAppRuntime, Integer.valueOf(i3), str2, str3, Long.valueOf(j3), Long.valueOf(j16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (TextUtils.isEmpty(this.f154233d.getAccount())) {
                        QLog.e("DoraemonOpenAPI.report", 1, "updateFrequenceData, uin is empty!!!", new Throwable("uin is empty"));
                        return;
                    }
                    EntityManager createEntityManager = this.f154233d.getEntityManagerFactory().createEntityManager();
                    APIQuotaEntity aPIQuotaEntity = new APIQuotaEntity();
                    aPIQuotaEntity.type = this.f154234e;
                    aPIQuotaEntity.appid = this.f154235f;
                    aPIQuotaEntity.apiName = this.f154236h;
                    aPIQuotaEntity.remainTimes = this.f154237i;
                    aPIQuotaEntity.expireTimeMillis = this.f154238m;
                    createEntityManager.persistOrReplace(aPIQuotaEntity);
                }
            }, 5, null, true);
        } else {
            QLog.e("DoraemonOpenAPI.report", 1, "app is null or process is not main process");
        }
        a.InterfaceC7087a interfaceC7087a = this.f154228a;
        if (interfaceC7087a != null) {
            ThreadManager.getUIHandler().post(new Runnable(interfaceC7087a, str, i3, str2, str3, j3, j16) { // from class: com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ long C;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ a.InterfaceC7087a f154239d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f154240e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f154241f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f154242h;

                /* renamed from: i, reason: collision with root package name */
                final /* synthetic */ String f154243i;

                /* renamed from: m, reason: collision with root package name */
                final /* synthetic */ long f154244m;

                {
                    this.f154239d = interfaceC7087a;
                    this.f154240e = str;
                    this.f154241f = i3;
                    this.f154242h = str2;
                    this.f154243i = str3;
                    this.f154244m = j3;
                    this.C = j16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, DoraemonAPIReporterMain.this, interfaceC7087a, str, Integer.valueOf(i3), str2, str3, Long.valueOf(j3), Long.valueOf(j16));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        this.f154239d.a(this.f154240e, this.f154241f, this.f154242h, this.f154243i, this.f154244m, this.C);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(String str, List<APIQuotaEntity> list) {
        if (QLog.isColorLevel()) {
            QLog.d("DoraemonOpenAPI.report", 2, "updateFrequenceDataBatch key=" + str);
        }
        a.InterfaceC7087a interfaceC7087a = this.f154228a;
        if (interfaceC7087a != null) {
            HashMap hashMap = new HashMap(list.size());
            for (APIQuotaEntity aPIQuotaEntity : list) {
                APIQuotaItem aPIQuotaItem = new APIQuotaItem();
                aPIQuotaItem.remainTimes = aPIQuotaEntity.remainTimes;
                aPIQuotaItem.expireTimeMillis = aPIQuotaEntity.expireTimeMillis;
                hashMap.put(aPIQuotaEntity.apiName, aPIQuotaItem);
            }
            ThreadManager.getUIHandler().post(new Runnable(interfaceC7087a, str, hashMap) { // from class: com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ a.InterfaceC7087a f154245d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f154246e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ HashMap f154247f;

                {
                    this.f154245d = interfaceC7087a;
                    this.f154246e = str;
                    this.f154247f = hashMap;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, DoraemonAPIReporterMain.this, interfaceC7087a, str, hashMap);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        this.f154245d.b(this.f154246e, this.f154247f);
                    }
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.monitor.a
    public void a(a.InterfaceC7087a interfaceC7087a) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) interfaceC7087a);
        } else {
            this.f154228a = interfaceC7087a;
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.monitor.a
    public void b(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2);
            return;
        }
        if (MobileQQ.sProcessId != 1) {
            QLog.e("DoraemonOpenAPI.report", 1, "process is not main process");
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            QLog.e("DoraemonOpenAPI.report", 1, "app is null");
        } else {
            ThreadManagerV2.post(new Runnable(waitAppRuntime, i3, str2, str) { // from class: com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporterMain.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ AppRuntime f154229d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f154230e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ String f154231f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ String f154232h;

                {
                    this.f154229d = waitAppRuntime;
                    this.f154230e = i3;
                    this.f154231f = str2;
                    this.f154232h = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, DoraemonAPIReporterMain.this, waitAppRuntime, Integer.valueOf(i3), str2, str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (TextUtils.isEmpty(this.f154229d.getAccount())) {
                        QLog.e("DoraemonOpenAPI.report", 1, "loadApiQuotaData, uin is empty!!!", new Throwable("uin is empty"));
                        return;
                    }
                    EntityManager createEntityManager = this.f154229d.getEntityManagerFactory().createEntityManager();
                    if (createEntityManager == null) {
                        QLog.d("DoraemonOpenAPI.report", 1, "EntityManager is null");
                        return;
                    }
                    List<? extends Entity> query = createEntityManager.query(APIQuotaEntity.class, false, "type=? and appid=?", new String[]{String.valueOf(this.f154230e), this.f154231f}, null, null, null, null);
                    if (query != null && query.size() > 0) {
                        DoraemonAPIReporterMain.this.h(this.f154232h, query);
                    }
                }
            }, 5, null, true);
        }
    }

    @Override // com.tencent.mobileqq.Doraemon.monitor.a
    public void c(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), str2, str3);
        } else {
            f(str, i3, str2, str3, 1);
        }
    }
}
