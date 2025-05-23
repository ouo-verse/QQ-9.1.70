package com.tencent.mobileqq.soload.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqsomonitor.api.ISoMonitorApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoLoaderService;
import com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener;
import com.tencent.mobileqq.soload.biz.OnSoGetPathListener;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.RelatedFileInfo;
import com.tencent.mobileqq.soload.biz.entity.SoDetailInfo;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.biz.entity.SoLocalInfo;
import com.tencent.mobileqq.soload.config.a;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends com.tencent.mobileqq.soload.api.impl.a {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    private static final Map<String, List<OnGetSoLoadInfoListener>> f288565k;

    /* renamed from: l, reason: collision with root package name */
    private static final Map<String, Long> f288566l;

    /* renamed from: m, reason: collision with root package name */
    private static final AtomicBoolean f288567m;

    /* renamed from: n, reason: collision with root package name */
    private static final byte[] f288568n;

    /* renamed from: o, reason: collision with root package name */
    private static final Map<String, Integer> f288569o;

    /* renamed from: p, reason: collision with root package name */
    private static final BroadcastReceiver f288570p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements a.c {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.tencent.mobileqq.soload.config.a.c
        public void a(int i3, SoInfo soInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) soInfo);
                return;
            }
            d dVar = d.this;
            dVar.f288550c = i3;
            LoadParam loadParam = dVar.f288548a;
            com.tencent.mobileqq.soload.util.h.a(loadParam, loadParam.mReportSeq, null, "load.item.getconfig.end", "is64bit=" + (com.tencent.mobileqq.soload.util.e.d() ? 1 : 0) + "&v=" + com.tencent.mobileqq.soload.api.impl.a.d() + "&f=" + d.this.f288548a.mCallType, SoInfo.getReportCode(soInfo), null);
            d dVar2 = d.this;
            dVar2.x(dVar2.f288549b, soInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b implements a.c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f288572a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.soload.entity.a f288573b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ LoadParam.LoadItem f288574c;

        b(String str, com.tencent.mobileqq.soload.entity.a aVar, LoadParam.LoadItem loadItem) {
            this.f288572a = str;
            this.f288573b = aVar;
            this.f288574c = loadItem;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, str, aVar, loadItem);
            }
        }

        @Override // com.tencent.mobileqq.soload.config.a.c
        public void a(int i3, SoInfo soInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) soInfo);
                return;
            }
            if (!d.this.e(soInfo)) {
                d.this.B(2);
                return;
            }
            if (TextUtils.equals(d.this.f288555h.ver, this.f288572a) && this.f288573b.g()) {
                d dVar = d.this;
                dVar.f288556i = "runcrash";
                dVar.B(8);
            } else {
                com.tencent.mobileqq.soload.util.f.d(this.f288574c.name);
                d.this.z(this.f288574c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements OnSoGetPathListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LoadParam.LoadItem f288576a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f288577b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f288578c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ SoLocalInfo f288579d;

        c(LoadParam.LoadItem loadItem, boolean z16, boolean z17, SoLocalInfo soLocalInfo) {
            this.f288576a = loadItem;
            this.f288577b = z16;
            this.f288578c = z17;
            this.f288579d = soLocalInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, loadItem, Boolean.valueOf(z16), Boolean.valueOf(z17), soLocalInfo);
            }
        }

        @Override // com.tencent.mobileqq.soload.biz.OnSoGetPathListener
        public void onResult(int i3, String str, String str2, String str3, boolean z16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, str3, Boolean.valueOf(z16), Integer.valueOf(i16));
                return;
            }
            QLog.i(d.this.v(), 1, "[downloadSo] resCode=" + i3 + ",subErrCode:" + i16 + ",loadItemName:" + this.f288576a.name + ",folderPath:" + str2 + ",filePath: " + str);
            LoadParam loadParam = d.this.f288548a;
            long j3 = loadParam.mReportSeq;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("sc=");
            sb5.append(i16);
            com.tencent.mobileqq.soload.util.h.a(loadParam, j3, null, "load.item.download.end", sb5.toString(), i3, null);
            d.this.f288550c = i16;
            if (i3 == 0 && !TextUtils.isEmpty(str2)) {
                d.this.f288551d = true;
                String absolutePath = new File(str2, d.this.f288549b.soFileName).getAbsolutePath();
                d dVar = d.this;
                dVar.w(this.f288577b, this.f288578c, this.f288579d, absolutePath, str, dVar.f288555h.crc, 2);
                return;
            }
            if (i3 == 2) {
                d.this.B(4);
                return;
            }
            if (i16 == 404) {
                d.this.B(9);
            } else if (i16 != -1000 && i16 != -1001) {
                d.this.B(3);
            } else {
                d.this.B(15);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.soload.api.impl.d$d, reason: collision with other inner class name */
    /* loaded from: classes18.dex */
    public class C8599d implements OnSoGetPathListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f288581a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f288582b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f288583c;

        C8599d(String str, long j3, int i3) {
            this.f288581a = str;
            this.f288582b = j3;
            this.f288583c = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, d.this, str, Long.valueOf(j3), Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.mobileqq.soload.biz.OnSoGetPathListener
        public void onResult(int i3, String str, String str2, String str3, boolean z16, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, str3, Boolean.valueOf(z16), Integer.valueOf(i16));
                return;
            }
            QLog.i(d.this.v(), 1, "[downRFiles] download resCode=" + i3 + ",subErrCode:" + i16 + ",loadItemName:" + d.this.f288549b.name);
            d.this.f288550c = i16;
            if (i3 == 0 && !TextUtils.isEmpty(str2)) {
                d.this.D(str2);
                d.this.o(str2, this.f288581a, str, this.f288582b, this.f288583c);
                d.this.F(str2);
                return;
            }
            d.this.B(11);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class e extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                synchronized (d.f288568n) {
                    if (d.f288565k.size() > 0) {
                        QLog.i("SoLoadWidget.GetSoTaskAsync", 1, "[onReceive] action:" + intent.getAction() + ",LOADING_SO_NAMES:" + d.f288565k + ",LOADING_SO_TIMES:" + d.f288566l);
                        Iterator it = d.f288565k.values().iterator();
                        while (it.hasNext()) {
                            for (OnGetSoLoadInfoListener onGetSoLoadInfoListener : (List) it.next()) {
                                SoLoadInfo soLoadInfo = new SoLoadInfo();
                                soLoadInfo.curCode = 13;
                                onGetSoLoadInfoListener.onGetLoadInfo(soLoadInfo);
                            }
                        }
                        d.f288565k.clear();
                        d.f288566l.clear();
                    }
                }
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21213);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        f288565k = new HashMap();
        f288566l = new HashMap();
        f288567m = new AtomicBoolean(false);
        f288568n = new byte[0];
        f288569o = new HashMap();
        f288570p = new e();
    }

    public d(LoadParam loadParam, LoadParam.LoadItem loadItem) {
        super(loadParam, loadItem);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) loadParam, (Object) loadItem);
        } else {
            C();
        }
    }

    private boolean A(OnGetSoLoadInfoListener onGetSoLoadInfoListener) {
        boolean z16;
        long j3;
        synchronized (f288568n) {
            long currentTimeMillis = System.currentTimeMillis();
            Iterator<Map.Entry<String, List<OnGetSoLoadInfoListener>>> it = f288565k.entrySet().iterator();
            while (true) {
                z16 = false;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, List<OnGetSoLoadInfoListener>> next = it.next();
                String key = next.getKey();
                if (!TextUtils.isEmpty(key) && TextUtils.equals(key, this.f288549b.name)) {
                    next.getValue().add(onGetSoLoadInfoListener);
                    Map<String, Long> map = f288566l;
                    if (map.get(this.f288549b.name) != null) {
                        j3 = map.get(this.f288549b.name).longValue();
                    } else {
                        j3 = 0;
                    }
                    if (currentTimeMillis - j3 < MiniBoxNoticeInfo.MIN_5) {
                        z16 = true;
                    }
                }
            }
            Map<String, List<OnGetSoLoadInfoListener>> map2 = f288565k;
            if (map2.get(this.f288549b.name) == null) {
                LinkedList linkedList = new LinkedList();
                linkedList.add(onGetSoLoadInfoListener);
                map2.put(this.f288549b.name, linkedList);
            }
            if (!z16) {
                f288566l.put(this.f288549b.name, Long.valueOf(currentTimeMillis));
            }
            if (QLog.isColorLevel()) {
                QLog.i(v(), 2, "[insertInSameNameReqList] loadItemName:" + this.f288549b.name + ",LOADING_SO_NAMES:" + map2 + ",LOADING_SO_TIMES:" + f288566l + ",mergeReq:" + z16);
            }
        }
        return z16;
    }

    private void C() {
        if (MobileQQ.sMobileQQ != null && !f288567m.getAndSet(true)) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_KICKED);
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_EXPIRED);
            intentFilter.addAction(NewIntent.ACTION_FORCE_LOGOUT);
            intentFilter.addAction(NewIntent.ACTION_LOGOUT);
            intentFilter.addAction("mqq.intent.action.EXIT_" + MobileQQ.sMobileQQ.getPackageName());
            try {
                MobileQQ.sMobileQQ.registerReceiver(f288570p, intentFilter);
            } catch (Throwable th5) {
                QLog.e(v(), 1, th5, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null) {
                    for (File file2 : listFiles) {
                        D(file2.getAbsolutePath());
                    }
                    return;
                }
                return;
            }
            if (str.endsWith(".so")) {
                ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(MobileQQ.sMobileQQ, str);
            }
        }
    }

    private void E(LoadParam.LoadItem loadItem, long j3, AppRuntime appRuntime) {
        long currentTimeMillis = System.currentTimeMillis() - j3;
        QLog.i(v(), 1, "[handleConfig],waitRuntimeCost:" + currentTimeMillis + ",app:" + appRuntime + ",process:" + MobileQQ.sMobileQQ.getQQProcessName() + ",loadItem:" + loadItem.name);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(String str) {
        int length;
        try {
            File file = new File(str);
            String[] list = file.list();
            if (!file.exists() || list == null || list.length == 0) {
                if (list == null) {
                    length = 0;
                } else {
                    length = list.length;
                }
                QLog.e(v(), 1, "[handleAfterSoExist] folderPath is  exists:" + file.exists() + ",folderListSize:" + length + ",url:" + this.f288555h.relatedFileInfo.url);
                ((ISoLoaderService) QRoute.api(ISoLoaderService.class)).reportRlFolderNotExists(str, this.f288555h.relatedFileInfo.url, length);
            }
        } catch (Exception e16) {
            QLog.e(v(), 1, e16, new Object[0]);
        }
    }

    private void p(String str) {
        boolean deleteFile = FileUtils.deleteFile(str);
        QLog.i(v(), 1, "deleteSoFile " + str + " result: " + deleteFile);
    }

    private void q(String str, String str2) {
        boolean deleteFile = FileUtils.deleteFile(str);
        if (!TextUtils.isEmpty(str2)) {
            QLog.i(v(), 1, "deleteSoZip " + str + " result: " + deleteFile + ",logMsg:" + str2);
        }
    }

    private void r(OnSoGetPathListener onSoGetPathListener) {
        RelatedFileInfo relatedFileInfo;
        boolean z16;
        SoDetailInfo soDetailInfo = this.f288555h;
        if (soDetailInfo != null && (relatedFileInfo = soDetailInfo.relatedFileInfo) != null) {
            String str = relatedFileInfo.url;
            String str2 = relatedFileInfo.md5;
            String str3 = this.f288549b.name;
            if (this.f288548a.mCallType == LoadParam.CALL_TYPE_ASYNC_BY_SYNC) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.tencent.mobileqq.soload.util.f.e(str, str2, str3, z16, onSoGetPathListener);
        }
    }

    private void s(OnSoGetPathListener onSoGetPathListener) {
        boolean z16;
        LoadParam loadParam = this.f288548a;
        if (loadParam != null) {
            SoDetailInfo soDetailInfo = this.f288555h;
            if (soDetailInfo != null) {
                String str = soDetailInfo.url;
                String str2 = soDetailInfo.md5;
                String str3 = this.f288549b.name;
                if (loadParam.mCallType == LoadParam.CALL_TYPE_ASYNC_BY_SYNC) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                com.tencent.mobileqq.soload.util.f.e(str, str2, str3, z16, onSoGetPathListener);
            }
            LoadParam loadParam2 = this.f288548a;
            com.tencent.mobileqq.soload.util.h.a(loadParam2, loadParam2.mReportSeq, null, "load.item.download.start", null, 0, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(LoadParam.LoadItem loadItem, SoInfo soInfo) {
        long currentTimeMillis = System.currentTimeMillis();
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        E(loadItem, currentTimeMillis, waitAppRuntime);
        if (waitAppRuntime != null && !TextUtils.isEmpty(waitAppRuntime.getAccount())) {
            if (!e(soInfo)) {
                B(2);
                return;
            }
            com.tencent.mobileqq.soload.entity.a i3 = com.tencent.mobileqq.soload.util.f.i(this.f288549b.name, this.f288555h.ver);
            if (i3 != null && i3.d()) {
                if (QLog.isColorLevel()) {
                    QLog.i(v(), 2, "[handleConfig] InLoadCrashProtectMode, crashInfo=" + i3);
                }
                this.f288556i = "loadcrash";
                B(8);
                return;
            }
            if (i3 != null && i3.h()) {
                y(loadItem, i3);
                return;
            } else {
                z(loadItem);
                return;
            }
        }
        B(12);
        QLog.e(v(), 1, "handleConfig error,uin is empty,loadItem:" + loadItem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(LoadParam.LoadItem loadItem) {
        boolean z16;
        SoLocalInfo o16 = com.tencent.mobileqq.soload.util.f.o(loadItem, this.f288555h);
        boolean g16 = g(o16);
        boolean f16 = com.tencent.mobileqq.soload.api.impl.a.f(o16, this.f288555h);
        if ((this.f288549b.lops.flag & 4) != 0 && this.f288548a.mCallType != LoadParam.CALL_TYPE_ASYNC_BY_SYNC) {
            z16 = true;
        } else {
            z16 = false;
        }
        boolean z17 = z16;
        if (QLog.isColorLevel()) {
            QLog.i(v(), 2, "[handleSoAndRelatedFile] isSoExist=" + g16 + ",rfolderOk=" + f16 + ",isWeak:" + z17 + ",loadItemName:" + loadItem.name + ",filePath:" + o16.mSoPath);
        }
        this.f288552e = !g16;
        if (!g16) {
            s(new c(loadItem, f16, z17, o16));
        } else {
            w(f16, z17, o16, o16.mSoPath, null, o16.mSoCRC, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(int i3) {
        List<OnGetSoLoadInfoListener> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        SoLoadInfo c16 = c(i3);
        synchronized (f288568n) {
            Map<String, List<OnGetSoLoadInfoListener>> map = f288565k;
            list = map.get(this.f288549b.name);
            map.remove(this.f288549b.name);
            Map<String, Long> map2 = f288566l;
            map2.remove(this.f288549b.name);
            if (QLog.isColorLevel()) {
                QLog.i(v(), 2, "[onSoResult] loadItemName:" + this.f288549b.name + ",resCode:" + i3 + ",LOADING_SO_NAMES:" + map + ",LOADING_SO_TIMES:" + map2);
            }
        }
        if (list != null) {
            for (OnGetSoLoadInfoListener onGetSoLoadInfoListener : list) {
                if (onGetSoLoadInfoListener != null) {
                    onGetSoLoadInfoListener.onGetLoadInfo(c16);
                }
            }
        }
    }

    protected void o(String str, String str2, String str3, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, str3, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (com.tencent.mobileqq.soload.api.impl.a.b(str2, j3, this.f288549b, this.f288555h, i3)) {
            ((ISoMonitorApi) QRoute.api(ISoMonitorApi.class)).registerSoFilePath(MobileQQ.sMobileQQ, str2);
            q(str3, "");
            this.f288554g = str;
            this.f288553f = str2;
            B(0);
            return;
        }
        Map<String, Integer> map = f288569o;
        Integer num = map.get(str2);
        if (num == null) {
            num = 0;
        }
        if (num.intValue() < 3 && com.tencent.mobileqq.soload.util.f.B()) {
            Integer valueOf = Integer.valueOf(num.intValue() + 1);
            map.put(str2, valueOf);
            q(str3, "crc valid failed,retry count:" + valueOf);
            p(str2);
        }
        B(10);
    }

    protected void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(v(), 2, "fetchAndHandleConfig so = " + this.f288549b.name);
        }
        LoadParam loadParam = this.f288548a;
        com.tencent.mobileqq.soload.util.h.a(loadParam, loadParam.mReportSeq, null, "load.item.getconfig.start", this.f288549b.name, 0, null);
        com.tencent.mobileqq.soload.config.a.b().e(this.f288549b.name, new a(), false);
    }

    public void u(OnGetSoLoadInfoListener onGetSoLoadInfoListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) onGetSoLoadInfoListener);
        } else {
            if (A(onGetSoLoadInfoListener)) {
                if (QLog.isColorLevel()) {
                    QLog.i(v(), 2, "insert into same req list");
                    return;
                }
                return;
            }
            t();
        }
    }

    protected String v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "SoLoadWidget.GetSoTaskAsync";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(boolean z16, boolean z17, SoLocalInfo soLocalInfo, String str, String str2, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Boolean.valueOf(z17), soLocalInfo, str, str2, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        if (z16) {
            o(soLocalInfo.mRFileFolder, str, str2, j3, i3);
        } else {
            if (z17) {
                QLog.i(v(), 1, "[handleAfterSoExist] isWeakRelated");
                r(null);
                o(null, str, str2, j3, i3);
                return;
            }
            r(new C8599d(str, j3, i3));
        }
    }

    protected void y(LoadParam.LoadItem loadItem, com.tencent.mobileqq.soload.entity.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) loadItem, (Object) aVar);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(v(), 2, "[handleConfig] isNeedReqForCrash, crashInfo=" + aVar);
        }
        com.tencent.mobileqq.soload.config.a.b().c(loadItem.name, aVar, new b(this.f288555h.ver, aVar, loadItem));
    }
}
