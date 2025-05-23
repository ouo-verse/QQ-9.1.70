package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.ims.signature$SignatureReport;
import com.tencent.ims.signature$SignatureResult;
import com.tencent.mapsdk.internal.er;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.open.base.MD5Utils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.vivo.push.PushClientConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes11.dex */
public class StartAppCheckHandler extends BusinessHandler implements mqq.observer.BusinessObserver {
    static IPatchRedirector $redirector_;
    final int C;
    final int D;
    e E;
    c F;
    private Handler G;
    private Handler H;
    Runnable I;

    /* renamed from: d, reason: collision with root package name */
    Activity f195089d;

    /* renamed from: e, reason: collision with root package name */
    BrowserAppInterface f195090e;

    /* renamed from: f, reason: collision with root package name */
    AppInterface f195091f;

    /* renamed from: h, reason: collision with root package name */
    boolean f195092h;

    /* renamed from: i, reason: collision with root package name */
    Queue<d> f195093i;

    /* renamed from: m, reason: collision with root package name */
    final int f195094m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a extends Handler {
        static IPatchRedirector $redirector_;

        a(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StartAppCheckHandler.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 == 3) {
                    new BaseThread(StartAppCheckHandler.this.I).start();
                    return;
                }
                return;
            }
            StartAppCheckHandler startAppCheckHandler = StartAppCheckHandler.this;
            if (startAppCheckHandler.f195089d != null && startAppCheckHandler.f195090e != null) {
                NewIntent newIntent = new NewIntent(StartAppCheckHandler.this.f195089d.getApplicationContext(), com.tencent.biz.m.class);
                newIntent.putExtra("data", ((e) message.obj).f195120g.toByteArray());
                newIntent.putExtra("cmd", "SecCheckSigSvc.UploadReq");
                newIntent.setObserver(StartAppCheckHandler.this);
                StartAppCheckHandler.this.f195090e.startServlet(newIntent);
            } else {
                ToServiceMsg createToServiceMsg = startAppCheckHandler.createToServiceMsg("SecCheckSigSvc.UploadReq");
                createToServiceMsg.putWupBuffer(((e) message.obj).f195120g.toByteArray());
                StartAppCheckHandler.this.sendPbReq(createToServiceMsg);
            }
            StartAppCheckHandler startAppCheckHandler2 = StartAppCheckHandler.this;
            startAppCheckHandler2.f195092h = false;
            startAppCheckHandler2.E = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class b extends Handler {
        static IPatchRedirector $redirector_;

        b(Looper looper) {
            super(looper);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StartAppCheckHandler.this, (Object) looper);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            } else if (message.what == 2) {
                d dVar = (d) message.obj;
                StartAppCheckHandler.this.f195093i.remove(dVar);
                dVar.f195111b.startActivity(dVar.f195112c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f195097a;

        /* renamed from: b, reason: collision with root package name */
        long f195098b;

        /* renamed from: c, reason: collision with root package name */
        long f195099c;

        /* renamed from: d, reason: collision with root package name */
        String f195100d;

        /* renamed from: e, reason: collision with root package name */
        String f195101e;

        /* renamed from: f, reason: collision with root package name */
        int f195102f;

        /* renamed from: g, reason: collision with root package name */
        String f195103g;

        /* renamed from: h, reason: collision with root package name */
        String f195104h;

        /* renamed from: i, reason: collision with root package name */
        String f195105i;

        /* renamed from: j, reason: collision with root package name */
        String f195106j;

        /* renamed from: k, reason: collision with root package name */
        String f195107k;

        /* renamed from: l, reason: collision with root package name */
        String f195108l;

        c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StartAppCheckHandler.this, (Object) str);
            } else {
                this.f195108l = str;
                a();
            }
        }

        public void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.f195108l == null) {
                return;
            }
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("AppStartedObserver", 0);
            this.f195097a = sharedPreferences.getLong(this.f195108l + "_timeToWait", 0L);
            this.f195098b = sharedPreferences.getLong(this.f195108l + "_lastReportTime", 0L);
            this.f195099c = sharedPreferences.getLong(this.f195108l + "_lastUpdateTime", 0L);
            this.f195100d = sharedPreferences.getString(this.f195108l + "_sigHash", "");
            this.f195101e = sharedPreferences.getString(this.f195108l + er.f148292u, "");
            this.f195102f = sharedPreferences.getInt(this.f195108l + "_serverResult", 0);
            this.f195103g = sharedPreferences.getString(this.f195108l + "_dlgTitle", "");
            this.f195104h = sharedPreferences.getString(this.f195108l + "_dlgContent", "");
            this.f195105i = sharedPreferences.getString(this.f195108l + "_dlgLButton", "");
            this.f195106j = sharedPreferences.getString(this.f195108l + "_dlgRButoon", "");
            this.f195107k = sharedPreferences.getString(this.f195108l + "_dlgUrl", "");
        }

        public void b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            if (this.f195108l == null) {
                return;
            }
            SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences("AppStartedObserver", 0).edit();
            edit.putLong(this.f195108l + "_timeToWait", this.f195097a);
            edit.putLong(this.f195108l + "_lastReportTime", this.f195098b);
            edit.putLong(this.f195108l + "_lastUpdateTime", this.f195099c);
            edit.putString(this.f195108l + "_sigHash", this.f195100d);
            edit.putString(this.f195108l + er.f148292u, this.f195101e);
            edit.putInt(this.f195108l + "_serverResult", this.f195102f);
            edit.putString(this.f195108l + "_dlgTitle", this.f195103g);
            edit.putString(this.f195108l + "_dlgContent", this.f195104h);
            edit.putString(this.f195108l + "_dlgLButton", this.f195105i);
            edit.putString(this.f195108l + "_dlgRButoon", this.f195106j);
            edit.putString(this.f195108l + "_dlgUrl", this.f195107k);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f195110a;

        /* renamed from: b, reason: collision with root package name */
        Context f195111b;

        /* renamed from: c, reason: collision with root package name */
        Intent f195112c;

        d(String str, Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, StartAppCheckHandler.this, str, context, intent);
                return;
            }
            this.f195110a = str;
            this.f195111b = context;
            this.f195112c = intent;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f195114a;

        /* renamed from: b, reason: collision with root package name */
        int f195115b;

        /* renamed from: c, reason: collision with root package name */
        String f195116c;

        /* renamed from: d, reason: collision with root package name */
        String f195117d;

        /* renamed from: e, reason: collision with root package name */
        String f195118e;

        /* renamed from: f, reason: collision with root package name */
        String f195119f;

        /* renamed from: g, reason: collision with root package name */
        signature$SignatureReport f195120g;

        e(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StartAppCheckHandler.this, (Object) str);
            } else {
                this.f195116c = str;
                this.f195120g = new signature$SignatureReport();
            }
        }
    }

    public StartAppCheckHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f195089d = null;
        this.f195090e = null;
        this.f195091f = null;
        this.f195092h = false;
        this.f195093i = new LinkedList();
        this.f195094m = 1;
        this.C = 2;
        this.D = 3;
        this.G = new a(Looper.getMainLooper());
        this.H = new b(Looper.getMainLooper());
        this.I = new Runnable() { // from class: com.tencent.mobileqq.app.StartAppCheckHandler.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) StartAppCheckHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    StartAppCheckHandler startAppCheckHandler = StartAppCheckHandler.this;
                    PackageInfo G2 = startAppCheckHandler.G2(startAppCheckHandler.f195091f.getApplication(), StartAppCheckHandler.this.E.f195116c);
                    if (G2 != null) {
                        long lastModified = new File(G2.applicationInfo.sourceDir).lastModified();
                        String signatureHash = SecUtil.getSignatureHash(G2.signatures[0].toByteArray());
                        StartAppCheckHandler startAppCheckHandler2 = StartAppCheckHandler.this;
                        startAppCheckHandler2.F.f195099c = lastModified;
                        e eVar = startAppCheckHandler2.E;
                        eVar.f195119f = signatureHash;
                        eVar.f195117d = G2.versionName;
                        eVar.f195118e = MD5Utils.encodeFileHexStr(G2.applicationInfo.sourceDir);
                    }
                    StartAppCheckHandler startAppCheckHandler3 = StartAppCheckHandler.this;
                    c cVar = startAppCheckHandler3.F;
                    e eVar2 = startAppCheckHandler3.E;
                    cVar.f195100d = eVar2.f195119f;
                    cVar.f195101e = eVar2.f195118e;
                    if (QLog.isColorLevel()) {
                        QLog.d("AppStartedHandler", 2, " " + StartAppCheckHandler.this.E.f195114a + " " + StartAppCheckHandler.this.E.f195115b + " " + StartAppCheckHandler.this.E.f195116c + " " + StartAppCheckHandler.this.E.f195117d + " " + StartAppCheckHandler.this.E.f195118e + " " + StartAppCheckHandler.this.E.f195119f);
                    }
                    e eVar3 = StartAppCheckHandler.this.E;
                    if (eVar3.f195116c != null && eVar3.f195117d != null && eVar3.f195118e != null && eVar3.f195119f != null) {
                        eVar3.f195120g.u64_uin.set(eVar3.f195114a);
                        e eVar4 = StartAppCheckHandler.this.E;
                        eVar4.f195120g.u32_client_type.set(eVar4.f195115b);
                        e eVar5 = StartAppCheckHandler.this.E;
                        eVar5.f195120g.str_packname.set(eVar5.f195116c);
                        e eVar6 = StartAppCheckHandler.this.E;
                        eVar6.f195120g.str_version.set(eVar6.f195117d);
                        e eVar7 = StartAppCheckHandler.this.E;
                        eVar7.f195120g.str_md5.set(eVar7.f195118e);
                        e eVar8 = StartAppCheckHandler.this.E;
                        eVar8.f195120g.str_signature.set(eVar8.f195119f);
                        StartAppCheckHandler.this.E.f195120g.u32_protocol_version.set(2);
                        Message message = new Message();
                        message.what = 1;
                        StartAppCheckHandler startAppCheckHandler4 = StartAppCheckHandler.this;
                        message.obj = startAppCheckHandler4.E;
                        startAppCheckHandler4.G.sendMessage(message);
                        if (QLog.isColorLevel()) {
                            QLog.d("AppStartedHandler", 2, "SendStartedAppInfo end..");
                        }
                    }
                    StartAppCheckHandler.this.f195092h = false;
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        };
        this.f195091f = qQAppInterface;
    }

    private void F2(byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:server result code ok");
        }
        signature$SignatureResult signature_signatureresult = new signature$SignatureResult();
        try {
            signature_signatureresult.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:sigResult parse fail");
            }
            e16.printStackTrace();
        }
        if (!H2(signature_signatureresult)) {
            return;
        }
        String str = signature_signatureresult.str_packname.get();
        LinkedList linkedList = new LinkedList();
        int i3 = signature_signatureresult.u32_check_result.get();
        if (i3 != 0 && i3 != 1) {
            if (i3 == 2) {
                for (d dVar : this.f195093i) {
                    if (dVar.f195110a.equals(str)) {
                        linkedList.add(dVar);
                        this.H.removeMessages(2, dVar);
                        Intent intent = new Intent();
                        intent.putExtra("type", 9);
                        Bundle bundle = new Bundle();
                        bundle.putString(NotificationActivity.DLG_TITLE, signature_signatureresult.str_title.get());
                        bundle.putString(NotificationActivity.DLG_CONTENT, signature_signatureresult.str_content.get());
                        bundle.putString(NotificationActivity.DLG_LBUTTON, signature_signatureresult.str_left_button.get());
                        bundle.putString(NotificationActivity.DLG_RBUTTON, signature_signatureresult.str_right_button.get());
                        bundle.putString(NotificationActivity.DLG_URL, signature_signatureresult.str_url.get());
                        intent.putExtras(bundle);
                        intent.setFlags(872415232);
                        RouteUtils.startActivity(this.f195091f.getApplication(), intent, RouterConstants.UI_ROUTER_NOTIFICATION);
                    }
                }
            }
        } else {
            for (d dVar2 : this.f195093i) {
                if (dVar2.f195110a.equals(str)) {
                    linkedList.add(dVar2);
                    Message obtainMessage = this.H.obtainMessage(2, dVar2);
                    this.H.removeMessages(2, dVar2);
                    this.H.sendMessage(obtainMessage);
                }
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            this.f195093i.remove((d) it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public PackageInfo G2(Context context, String str) {
        try {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 64);
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private boolean H2(signature$SignatureResult signature_signatureresult) {
        if (signature_signatureresult.has() && signature_signatureresult.str_packname.has() && signature_signatureresult.str_packname.get() != null && signature_signatureresult.u32_check_result.has() && !signature_signatureresult.str_packname.get().equalsIgnoreCase("MobileQQ")) {
            this.F.f195098b = System.currentTimeMillis();
            if (signature_signatureresult.u32_timeout.has()) {
                this.F.f195097a = signature_signatureresult.u32_timeout.get();
            }
            if (signature_signatureresult.u32_check_result.has()) {
                this.F.f195102f = signature_signatureresult.u32_check_result.get();
            }
            if (signature_signatureresult.str_title.has()) {
                this.F.f195103g = signature_signatureresult.str_title.get();
            }
            if (signature_signatureresult.str_content.has()) {
                this.F.f195104h = signature_signatureresult.str_content.get();
            }
            if (signature_signatureresult.str_left_button.has()) {
                this.F.f195105i = signature_signatureresult.str_left_button.get();
            }
            if (signature_signatureresult.str_right_button.has()) {
                this.F.f195106j = signature_signatureresult.str_right_button.get();
            }
            if (signature_signatureresult.str_url.has()) {
                this.F.f195107k = signature_signatureresult.str_url.get();
            }
            this.F.b();
            this.F = null;
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:packname fail");
            return false;
        }
        return false;
    }

    public static void I2(String str, String str2, String str3, String str4, String str5, String str6) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("openType", str);
        if (str2 != null && str2.length() > 300) {
            str2 = str2.substring(0, 300);
        }
        hashMap.put("url", str2);
        hashMap.put("appName", str3);
        hashMap.put("from", str4);
        hashMap.put("clickOrigin", str5);
        hashMap.put(PushClientConstants.TAG_CLASS_NAME, str6);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "AppOpenUrl", true, 0L, 0L, hashMap, null);
    }

    public void J2(String str, Context context, Intent intent) {
        PackageInfo G2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, context, intent);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppStartedHandler", 2, "<-- AppStartedObserver pkgName=" + str);
        }
        if (!TextUtils.isEmpty(str) && context != null && intent != null) {
            I2(intent.getStringExtra("report_open_type"), intent.getStringExtra("report_url"), str, intent.getStringExtra("report_from"), intent.getStringExtra("report_click_origin"), intent.getStringExtra("report_class_name"));
        }
        if (true != this.f195092h && str != null) {
            this.E = new e(str);
            this.F = new c(str);
            if (Long.valueOf(System.currentTimeMillis()).longValue() < this.F.f195098b + 86400000 && (G2 = G2(this.f195091f.getApplication(), this.E.f195116c)) != null) {
                String signatureHash = SecUtil.getSignatureHash(G2.signatures[0].toByteArray());
                long lastModified = new File(G2.applicationInfo.sourceDir).lastModified();
                c cVar = this.F;
                if (cVar.f195099c == lastModified && cVar.f195100d.equalsIgnoreCase(signatureHash)) {
                    if (this.F.f195102f != 2) {
                        if (context != null && intent != null) {
                            context.startActivity(intent);
                            return;
                        }
                        return;
                    }
                    Intent intent2 = new Intent();
                    intent2.putExtra("type", 9);
                    Bundle bundle = new Bundle();
                    bundle.putString(NotificationActivity.DLG_TITLE, this.F.f195103g);
                    bundle.putString(NotificationActivity.DLG_CONTENT, this.F.f195104h);
                    bundle.putString(NotificationActivity.DLG_LBUTTON, this.F.f195105i);
                    bundle.putString(NotificationActivity.DLG_RBUTTON, this.F.f195106j);
                    bundle.putString(NotificationActivity.DLG_URL, this.F.f195107k);
                    intent2.putExtras(bundle);
                    intent2.setFlags(872415232);
                    RouteUtils.startActivity(this.f195091f.getApplication(), intent2, RouterConstants.UI_ROUTER_NOTIFICATION);
                    try {
                        ReportController.o(null, "P_CliOper", "Safe_StartAppCheck", this.f195091f.getAccount(), "startAppByCheckValid", this.F.f195101e, 0, 0, "", "", "", "");
                        return;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        return;
                    }
                }
            }
            try {
                this.E.f195114a = Long.valueOf(this.f195091f.getAccount()).longValue();
                e eVar = this.E;
                eVar.f195115b = 1;
                eVar.f195116c = str;
                d dVar = new d(str, context, intent);
                this.f195093i.offer(dVar);
                Message message = new Message();
                message.what = 2;
                message.obj = dVar;
                this.H.sendMessage(message);
                Handler handler = this.G;
                long j3 = this.F.f195097a;
                if (j3 <= 0) {
                    j3 = 300;
                }
                handler.sendEmptyMessageDelayed(3, j3);
                this.f195092h = true;
                return;
            } catch (Exception unused) {
                if (QLog.isColorLevel()) {
                    QLog.d("AppStartedHandler", 2, "GetAccount Failed!");
                    return;
                }
                return;
            }
        }
        if (context != null && intent != null) {
            context.startActivity(intent);
        }
    }

    public void K2(String str, Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, context, intent);
            return;
        }
        QQBrowserActivity qQBrowserActivity = (QQBrowserActivity) context;
        this.f195089d = qQBrowserActivity;
        BrowserAppInterface browserAppInterface = (BrowserAppInterface) qQBrowserActivity.getAppRuntime();
        this.f195090e = browserAppInterface;
        this.f195091f = browserAppInterface;
        J2(str, context, intent);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Class) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (serviceCmd != null && serviceCmd.length() != 0) {
            if ("SecCheckSigSvc.UploadReq".equalsIgnoreCase(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package:check result");
                }
                if (fromServiceMsg.isSuccess()) {
                    F2((byte[]) obj);
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AppStartedHandler", 2, "onReceive: onReceive sec_server package: server cmd is null");
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        if (!z16) {
            if (QLog.isColorLevel()) {
                QLog.d("AppStartedHandler", 2, "onReceive: onReceive Observer package:MobileQQ fail");
            }
        } else {
            if (!z16 || bundle == null) {
                return;
            }
            F2(bundle.getByteArray("data"));
        }
    }
}
