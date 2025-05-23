package com.tencent.mobileqq.miniapp;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.lang.ref.Reference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import tencent.im.oidb.oidb_0xb61$ReqBody;
import tencent.im.oidb.oidb_0xb61$RspBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MiniAppInfoManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    Map<String, d> f246780a;

    public MiniAppInfoManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f246780a = new ConcurrentHashMap();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(d dVar, int i3, int i16) {
        if (QLog.isDevelopLevel()) {
            QLog.d("MiniAppInfoManager", 4, "getAppInfoFromCache cache valid. cacheKey=", dVar.f246807p);
        }
        if (i16 == 1) {
            if (dVar.f246805n > NetConnInfoCenter.getServerTimeMillis()) {
                return true;
            }
        } else if (i16 == 0) {
            if (i3 == 1 && dVar.f246803l > NetConnInfoCenter.getServerTimeMillis()) {
                return true;
            }
            if (i3 == 2 && dVar.f246804m > NetConnInfoCenter.getServerTimeMillis()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d b(String str, int i3, int i16, boolean z16) {
        d dVar = this.f246780a.get(str);
        if (dVar != null && z16) {
            if (!a(dVar, i3, i16)) {
                return null;
            }
            return dVar;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("MiniAppInfoManager", 4, "getAppInfoFromCache cache invalid. cacheKey=", str);
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(d dVar, int i3, e eVar) {
        ThreadManagerV2.excute(new Runnable(eVar, dVar, i3) { // from class: com.tencent.mobileqq.miniapp.MiniAppInfoManager.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ e f246781d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ d f246782e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f246783f;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.miniapp.MiniAppInfoManager$1$a */
            /* loaded from: classes15.dex */
            class a extends ProtoUtils.a {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:65:0x01f6  */
                /* JADX WARN: Removed duplicated region for block: B:67:0x01fa  */
                @Override // com.tencent.biz.ProtoUtils.TroopProtocolObserver
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResult(int i3, byte[] bArr, Bundle bundle) {
                    Reference reference;
                    String str;
                    String str2;
                    Reference reference2;
                    Reference reference3;
                    Reference reference4;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), bArr, bundle);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("MiniAppInfoManager", 2, "onResult type=" + AnonymousClass1.this.f246782e.f246793b + ", appid=" + AnonymousClass1.this.f246782e.f246792a + ", code=" + i3);
                    }
                    if (i3 == 0 && bArr != null) {
                        oidb_0xb61$RspBody oidb_0xb61_rspbody = new oidb_0xb61$RspBody();
                        try {
                            oidb_0xb61_rspbody.mergeFrom(bArr);
                            if (oidb_0xb61_rspbody.wording.has()) {
                                AnonymousClass1.this.f246782e.f246802k = oidb_0xb61_rspbody.wording.get();
                            }
                            if (AnonymousClass1.this.f246783f == 1 && oidb_0xb61_rspbody.get_appinfo_rsp.appinfo.has()) {
                                AnonymousClass1.this.f246782e.f246794c = oidb_0xb61_rspbody.get_appinfo_rsp.appinfo.platform.get();
                                AnonymousClass1.this.f246782e.f246795d = oidb_0xb61_rspbody.get_appinfo_rsp.appinfo.app_name.get();
                                AnonymousClass1.this.f246782e.f246799h = oidb_0xb61_rspbody.get_appinfo_rsp.appinfo.app_state.get();
                                AnonymousClass1.this.f246782e.f246796e = oidb_0xb61_rspbody.get_appinfo_rsp.appinfo.icon_url.get();
                                AnonymousClass1.this.f246782e.f246798g = oidb_0xb61_rspbody.get_appinfo_rsp.appinfo.icon_small_url.get();
                                AnonymousClass1.this.f246782e.f246797f = oidb_0xb61_rspbody.get_appinfo_rsp.appinfo.icon_middle_url.get();
                                if (oidb_0xb61_rspbody.next_req_duration.has()) {
                                    AnonymousClass1.this.f246782e.f246803l = NetConnInfoCenter.getServerTimeMillis() + Math.max(oidb_0xb61_rspbody.next_req_duration.get() * 1000, MiniBoxNoticeInfo.MIN_5);
                                }
                            } else if (AnonymousClass1.this.f246783f == 2 && oidb_0xb61_rspbody.get_mqqapp_url_rsp.has()) {
                                AnonymousClass1.this.f246782e.f246800i = oidb_0xb61_rspbody.get_mqqapp_url_rsp.app_version.get();
                                AnonymousClass1.this.f246782e.f246801j = oidb_0xb61_rspbody.get_mqqapp_url_rsp.pkg_url.get();
                                if (oidb_0xb61_rspbody.next_req_duration.has()) {
                                    AnonymousClass1.this.f246782e.f246804m = NetConnInfoCenter.getServerTimeMillis() + Math.max(oidb_0xb61_rspbody.next_req_duration.get() * 1000, MiniBoxNoticeInfo.MIN_5);
                                }
                            } else {
                                e eVar = AnonymousClass1.this.f246781d;
                                if (eVar != null && (reference3 = eVar.f246812a) != null) {
                                    eVar.a(reference3.get(), false, AnonymousClass1.this.f246782e);
                                    return;
                                }
                                return;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("MiniAppInfoManager", 2, "receive appInfo: " + AnonymousClass1.this.f246782e);
                            }
                            g.m().r(AnonymousClass1.this.f246782e);
                            e eVar2 = AnonymousClass1.this.f246781d;
                            if (eVar2 != null && (reference4 = eVar2.f246812a) != null) {
                                eVar2.a(reference4.get(), true, AnonymousClass1.this.f246782e);
                                return;
                            }
                            return;
                        } catch (InvalidProtocolBufferMicroException unused) {
                            e eVar3 = AnonymousClass1.this.f246781d;
                            if (eVar3 != null && (reference2 = eVar3.f246812a) != null) {
                                eVar3.a(reference2.get(), false, AnonymousClass1.this.f246782e);
                                return;
                            }
                            return;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        if (bArr != null) {
                            try {
                                str = new oidb_0xb61$RspBody().mergeFrom(bArr).wording.get();
                            } catch (InvalidProtocolBufferMicroException unused2) {
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
                            QLog.i("MiniAppInfoManager", 2, sb5.toString());
                        }
                        str = "";
                        StringBuilder sb52 = new StringBuilder();
                        sb52.append("req error code=");
                        sb52.append(i3);
                        if (bArr != null) {
                        }
                        sb52.append(str2);
                        QLog.i("MiniAppInfoManager", 2, sb52.toString());
                    }
                    e eVar4 = AnonymousClass1.this.f246781d;
                    if (eVar4 != null && (reference = eVar4.f246812a) != null) {
                        eVar4.a(reference.get(), false, AnonymousClass1.this.f246782e);
                    }
                }
            }

            {
                this.f246781d = eVar;
                this.f246782e = dVar;
                this.f246783f = i3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, MiniAppInfoManager.this, eVar, dVar, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Reference reference;
                Reference reference2;
                Reference reference3;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                if (runtime == null) {
                    e eVar2 = this.f246781d;
                    if (eVar2 != null && (reference3 = eVar2.f246812a) != null) {
                        eVar2.a(reference3.get(), false, this.f246782e);
                        return;
                    }
                    return;
                }
                try {
                    int parseInt = Integer.parseInt(this.f246782e.f246792a);
                    oidb_0xb61$ReqBody oidb_0xb61_reqbody = new oidb_0xb61$ReqBody();
                    int i16 = this.f246783f;
                    if (i16 == 1) {
                        oidb_0xb61_reqbody.get_appinfo_req.setHasFlag(true);
                        oidb_0xb61_reqbody.get_appinfo_req.appid.set(parseInt);
                        oidb_0xb61_reqbody.get_appinfo_req.app_type.set(this.f246782e.f246793b);
                    } else if (i16 == 2) {
                        oidb_0xb61_reqbody.get_mqqapp_url_req.setHasFlag(true);
                        oidb_0xb61_reqbody.get_mqqapp_url_req.appid.set(parseInt);
                        oidb_0xb61_reqbody.get_mqqapp_url_req.app_type.set(this.f246782e.f246793b);
                        oidb_0xb61_reqbody.get_mqqapp_url_req.app_version.set(this.f246782e.f246800i);
                        oidb_0xb61_reqbody.get_mqqapp_url_req.platform.set(4);
                        oidb_0xb61_reqbody.get_mqqapp_url_req.sys_version.set(String.valueOf(Build.VERSION.SDK_INT));
                        oidb_0xb61_reqbody.get_mqqapp_url_req.qq_version.set(AppSetting.f99551k);
                    } else {
                        e eVar3 = this.f246781d;
                        if (eVar3 != null && (reference2 = eVar3.f246812a) != null) {
                            eVar3.a(reference2.get(), false, this.f246782e);
                            return;
                        }
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("MiniAppInfoManager", 2, "serviceType=" + this.f246783f + ", apptype=" + this.f246782e.f246793b + ", appid=" + this.f246782e.f246792a);
                    }
                    ProtoUtils.c(runtime, new a(), oidb_0xb61_reqbody.toByteArray(), "OidbSvc.0xb61", 2913, this.f246783f, null, 0L);
                } catch (NumberFormatException unused) {
                    e eVar4 = this.f246781d;
                    if (eVar4 != null && (reference = eVar4.f246812a) != null) {
                        eVar4.a(reference.get(), false, this.f246782e);
                    }
                }
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(d dVar) {
        if (QLog.isDevelopLevel()) {
            QLog.d("MiniAppInfoManager", 4, "verifyAppInfo. appState=", Integer.valueOf(dVar.f246799h));
        }
        if (dVar == null || dVar.f246799h != 1) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(d dVar) {
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppInfoManager", 2, "verifyDownloadUrl. downloadUrl=", dVar.f246801j);
        }
        return !TextUtils.isEmpty(dVar.f246801j);
    }
}
