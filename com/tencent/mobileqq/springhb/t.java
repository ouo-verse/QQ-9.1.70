package com.tencent.mobileqq.springhb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.IQWalletApi;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.springhb.api.ISpringHbTempApi;
import com.tencent.mobileqq.springhb.c;
import com.tencent.mobileqq.springhb.debug.DebugMonitorHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;
import tencent.im.spring_hb.ReportData$ExtendItem;
import tencent.im.spring_hb.ReportData$NYCommonInfo;
import tencent.im.spring_hb.ReportData$NYReportItem;
import tencent.im.spring_hb.ReportData$NYReportReq;
import tencent.im.spring_hb.ReportData$NYReportRsp;

/* compiled from: P */
/* loaded from: classes18.dex */
public class t implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private static final byte[] M;
    private long C;
    private long D;
    private long E;
    private boolean F;
    private long G;
    private long H;
    private boolean I;
    private final Handler J;
    private final DebugMonitorHelper K;
    private final BroadcastReceiver L;

    /* renamed from: d, reason: collision with root package name */
    public final String f289622d;

    /* renamed from: e, reason: collision with root package name */
    private final AppRuntime f289623e;

    /* renamed from: f, reason: collision with root package name */
    private final int f289624f;

    /* renamed from: h, reason: collision with root package name */
    private LinkedList<ReportInfo> f289625h;

    /* renamed from: i, reason: collision with root package name */
    private int f289626i;

    /* renamed from: m, reason: collision with root package name */
    private int f289627m;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class a extends BroadcastReceiver {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<t> f289628a;

        /* renamed from: b, reason: collision with root package name */
        private final int f289629b;

        public a(t tVar, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) tVar, i3);
            } else {
                this.f289628a = new WeakReference<>(tVar);
                this.f289629b = i3;
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                return;
            }
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && GuardManager.ACTION_PLUGIN_STATE_CHANGE.equals(action) && intent.getIntExtra(GuardManager.KEY_PLUGIN_STATE, 0) == 0) {
                com.tencent.mobileqq.springhb.util.b bVar = com.tencent.mobileqq.springhb.util.b.f289632a;
                bVar.f("Springhb_report.SpringHbReportManager" + this.f289629b, false, "[onReceive] bg action");
                t tVar = this.f289628a.get();
                if (tVar != null) {
                    tVar.O(3);
                    return;
                }
                bVar.d("Springhb_report.SpringHbReportManager" + this.f289629b, false, "[onReceive] manager is null");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26024);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            M = new byte[0];
        }
    }

    public t(AppRuntime appRuntime, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, i3);
            return;
        }
        this.f289625h = new LinkedList<>();
        this.F = false;
        this.G = 1200L;
        this.H = 5L;
        this.I = false;
        this.J = new WeakReferenceHandler(ThreadManagerV2.getQQCommonThreadLooper(), this);
        this.f289624f = i3;
        this.f289622d = "Springhb_report.SpringHbReportManager" + i3;
        this.f289623e = appRuntime;
        this.K = new DebugMonitorHelper(appRuntime);
        this.L = new a(this, i3);
        r();
        O(3);
    }

    private boolean A(ReportInfo reportInfo) {
        boolean z16;
        Map<String, String> map;
        if (TextUtils.equals(c.b.f288986r, reportInfo.bussId) && (map = reportInfo.extParams) != null && map.containsKey("ext4")) {
            String str = reportInfo.extParams.get("ext4");
            if (!TextUtils.isEmpty(str)) {
                reportInfo.extParams.put("ext4", str.replace("\r\n", " ").replace("\n", " "));
            }
        }
        if (reportInfo.isRealTime && this.F) {
            reportInfo.isRealTime = false;
        }
        if (NetConnInfoCenter.getServerTime() > this.C) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.f289627m = 0;
        }
        int i3 = this.f289627m;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return false;
                }
                return true;
            }
            if (TextUtils.equals(c.b.f288970b, reportInfo.bussId) || TextUtils.equals(c.b.f288969a, reportInfo.bussId)) {
                return true;
            }
            reportInfo.isRealTime = false;
            return false;
        }
        reportInfo.isRealTime = false;
        return false;
    }

    private LinkedList<ReportInfo> B() {
        LinkedList<ReportInfo> linkedList;
        Throwable th5;
        try {
            try {
                synchronized (M) {
                    try {
                        linkedList = (LinkedList) ((IQWalletApi) QRoute.api(IQWalletApi.class)).readObject(p());
                    } catch (Throwable th6) {
                        linkedList = null;
                        th = th6;
                    }
                }
            } catch (Throwable th7) {
                th = th7;
            }
            try {
                throw th;
            } catch (Throwable th8) {
                th5 = th8;
                com.tencent.mobileqq.springhb.util.b.f289632a.e(this.f289622d, false, "readFromFile:", th5);
                if (linkedList == null) {
                    return new LinkedList<>();
                }
                return linkedList;
            }
        } catch (Throwable th9) {
            linkedList = null;
            th5 = th9;
        }
    }

    private void C() {
        Iterator<String> it = y.c().iterator();
        while (it.hasNext()) {
            ((IArkAPIService) QRoute.api(IArkAPIService.class)).registerAppNotification(it.next(), y.d());
        }
    }

    private void D() {
        String simpleString;
        Iterator<ReportInfo> it = this.f289625h.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            ReportInfo next = it.next();
            if (next == null || next.retryCount >= 2) {
                it.remove();
                com.tencent.mobileqq.springhb.util.b bVar = com.tencent.mobileqq.springhb.util.b.f289632a;
                String str = this.f289622d;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("[removeTimeOutReport] ");
                if (next == null) {
                    simpleString = "";
                } else {
                    simpleString = next.toSimpleString();
                }
                sb5.append(simpleString);
                bVar.f(str, true, sb5.toString());
                z16 = true;
            }
        }
        if (z16) {
            J(false);
        }
    }

    private void F(long j3) {
        try {
            Iterator<ReportInfo> it = this.f289625h.iterator();
            while (it.hasNext()) {
                ReportInfo next = it.next();
                if (next.reqSeq == j3) {
                    next.isSending = false;
                }
            }
        } catch (Throwable th5) {
            com.tencent.mobileqq.springhb.util.b.f289632a.e(this.f289622d, false, "resetSendingState:", th5);
        }
    }

    private void G(int i3) {
        if (i3 == 0) {
            this.f289626i = 18;
        } else {
            this.f289626i = i3;
        }
        int min = Math.min(2000, this.f289626i);
        this.f289626i = min;
        int max = Math.max(10, min);
        this.f289626i = max;
        com.tencent.mobileqq.springhb.util.a.f289630a.k("batch_size", max, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
    }

    private void H(boolean z16) {
        this.F = z16;
        com.tencent.mobileqq.springhb.util.a.f289630a.i("report_is_overload", z16, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
    }

    private void I() {
        long serverTime = NetConnInfoCenter.getServerTime();
        this.D = serverTime;
        com.tencent.mobileqq.springhb.util.a.f289630a.m("last_report_time", serverTime, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
    }

    private void J(boolean z16) {
        if (!z16) {
            long serverTime = NetConnInfoCenter.getServerTime() - this.E;
            if (serverTime <= 5) {
                long j3 = 5 - serverTime;
                com.tencent.mobileqq.springhb.util.b.f289632a.f(this.f289622d, true, "[saveReportFile] no need to save, saveDelayTime=" + j3);
                this.J.removeMessages(100);
                this.J.sendEmptyMessageDelayed(100, j3 * 1000);
                return;
            }
        }
        this.J.removeMessages(100);
        long serverTime2 = NetConnInfoCenter.getServerTime();
        this.E = serverTime2;
        com.tencent.mobileqq.springhb.util.a.f289630a.m("last_save_report_file_time", serverTime2, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
        com.tencent.mobileqq.springhb.util.b.f289632a.f(this.f289622d, false, "[saveReportFile] go to save mLastSaveFileTime:" + this.E + " size:" + this.f289625h.size());
        final LinkedList<ReportInfo> linkedList = new LinkedList<>(this.f289625h);
        this.K.p((long) linkedList.size());
        this.K.o((long) com.tencent.mobileqq.springhb.debug.b.f289046a.f(linkedList));
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.springhb.p
            @Override // java.lang.Runnable
            public final void run() {
                t.this.w(linkedList);
            }
        }, 64, null, false);
    }

    private void K(long j3) {
        if (j3 == 0) {
            this.G = 1200L;
        } else {
            this.G = j3;
        }
        com.tencent.mobileqq.springhb.util.a.f289630a.m("report_interval", this.G, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
    }

    private void L(int i3) {
        this.f289627m = i3;
        if (i3 < 0 || i3 > 3) {
            this.f289627m = 0;
        }
        com.tencent.mobileqq.springhb.util.a.f289630a.k("report_level", this.f289627m, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000d, code lost:
    
        if (r10 > 86400) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void M(long j3) {
        long j16 = 0;
        if (j3 >= 0) {
            j16 = 86400;
        }
        j3 = j16;
        long serverTime = NetConnInfoCenter.getServerTime() + j3;
        this.C = serverTime;
        com.tencent.mobileqq.springhb.util.a.f289630a.m("report_level_time", serverTime, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
    }

    private void N(long j3) {
        if (j3 == 0) {
            this.H = 5L;
        } else {
            this.H = j3;
        }
        com.tencent.mobileqq.springhb.util.a.f289630a.m("switch_to_bg_interval", this.H, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O(final int i3) {
        this.J.post(new Runnable() { // from class: com.tencent.mobileqq.springhb.q
            @Override // java.lang.Runnable
            public final void run() {
                t.this.x(i3);
            }
        });
    }

    private void P(int i3) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        long j3;
        int o16 = o();
        if (o16 <= 0) {
            com.tencent.mobileqq.springhb.util.b.f289632a.f(this.f289622d, true, "[tryReportInner] reportScene:" + i3 + ",reportCount:" + o16);
            if (i3 == 0 || i3 == 1) {
                J(false);
                return;
            }
            return;
        }
        if (o16 >= this.f289626i) {
            z16 = true;
        } else {
            z16 = false;
        }
        long abs = Math.abs(NetConnInfoCenter.getServerTime() - this.D);
        if (abs >= this.G && this.D != 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (i3 != 0 && i3 != 4 && i3 != 2) {
            z18 = false;
        } else {
            z18 = true;
        }
        if (i3 == 3 && abs >= this.H) {
            z19 = true;
        } else {
            z19 = false;
        }
        com.tencent.mobileqq.springhb.util.b bVar = com.tencent.mobileqq.springhb.util.b.f289632a;
        bVar.f(this.f289622d, false, "[tryReportInner] reportScene:" + i3 + ",reportCount:" + o16 + ",mBatchSize:" + this.f289626i + ",isRealTime:" + z18 + ",mLastReportTime:" + this.D + ",reportInterval:" + abs + ",isTimeOk:" + z17 + ",isRealTimeBySwitchBg:" + z19);
        if ((z18 || z17 || z16 || z19) && NetworkUtil.isNetSupport(this.f289623e.getApp())) {
            m(i3);
            I();
            bVar.f(this.f289622d, true, "[tryReportInner] saveLastReportTime:" + this.D);
            this.J.removeMessages(101);
            return;
        }
        if (this.D == 0) {
            j3 = this.G;
        } else {
            j3 = this.G - abs;
        }
        if (j3 <= 0) {
            j3 = this.G;
        }
        bVar.f(this.f289622d, true, "[tryReportInner] schedule delayTime:" + j3);
        this.J.removeMessages(101);
        this.J.sendEmptyMessageDelayed(101, j3 * 1000);
        if (i3 == 3) {
            if (this.J.hasMessages(100)) {
                J(true);
                return;
            }
            return;
        }
        J(false);
    }

    private void g(@NonNull ReportInfo reportInfo) {
        D();
        Iterator<ReportInfo> it = this.f289625h.iterator();
        while (it.hasNext()) {
            ReportInfo next = it.next();
            if (h(next) && next.merge(reportInfo)) {
                com.tencent.mobileqq.springhb.util.b.f289632a.f(this.f289622d, true, "[addToCache] merge suc:" + next + " size:" + this.f289625h.size());
                return;
            }
        }
        this.f289625h.add(reportInfo);
        com.tencent.mobileqq.springhb.util.b bVar = com.tencent.mobileqq.springhb.util.b.f289632a;
        bVar.f(this.f289622d, true, "[addToCache] merge fail, directly added size:" + this.f289625h.size());
        if (this.f289625h.size() == 1) {
            I();
            bVar.f(this.f289622d, true, "[addToCache] saveLastReportTime:" + this.D);
        }
    }

    private boolean h(ReportInfo reportInfo) {
        if (!reportInfo.isSending && reportInfo.retryCount < 2) {
            return true;
        }
        return false;
    }

    private void i(long j3, int i3) {
        if (i3 == 0 || i3 == 110002) {
            try {
                ListIterator<ReportInfo> listIterator = this.f289625h.listIterator();
                while (listIterator.hasNext()) {
                    if (listIterator.next().reqSeq == j3) {
                        listIterator.remove();
                    }
                }
            } catch (Throwable th5) {
                com.tencent.mobileqq.springhb.util.b.f289632a.e(this.f289622d, false, "cleanOrSaveReqList:", th5);
                return;
            }
        }
        J(true);
    }

    private NewIntent j(byte[] bArr, long j3) {
        NewIntent newIntent = new NewIntent(this.f289623e.getApp(), u.class);
        newIntent.putExtra("data", bArr);
        newIntent.putExtra("report_cnt", j3);
        newIntent.putExtra("activity_type", this.f289624f);
        return newIntent;
    }

    private ReportData$NYReportItem k(ReportInfo reportInfo) {
        ReportData$NYReportItem reportData$NYReportItem = new ReportData$NYReportItem();
        reportData$NYReportItem.bussID.set(reportInfo.bussId);
        reportData$NYReportItem.fromSrc.set(reportInfo.fromSrc);
        reportData$NYReportItem.moduleID.set(reportInfo.moduleId);
        reportData$NYReportItem.subModuleID.set(reportInfo.subModuleId);
        reportData$NYReportItem.operationCode.set(reportInfo.operationCode);
        reportData$NYReportItem.optime.set(reportInfo.opTime);
        reportData$NYReportItem.count.set(reportInfo.count);
        reportData$NYReportItem.type.set(reportInfo.reportType);
        if (reportInfo.extParams == null) {
            return reportData$NYReportItem;
        }
        LinkedList linkedList = new LinkedList();
        for (Map.Entry<String, String> entry : reportInfo.extParams.entrySet()) {
            if (entry != null) {
                ReportData$ExtendItem reportData$ExtendItem = new ReportData$ExtendItem();
                reportData$ExtendItem.key.set(entry.getKey());
                reportData$ExtendItem.value.set(entry.getValue());
                linkedList.add(reportData$ExtendItem);
            }
        }
        reportData$NYReportItem.extParams.set(linkedList);
        return reportData$NYReportItem;
    }

    private ReportData$NYCommonInfo l() {
        ReportData$NYCommonInfo reportData$NYCommonInfo = new ReportData$NYCommonInfo();
        String cityCode = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCityCode();
        if (!TextUtils.isEmpty(cityCode)) {
            reportData$NYCommonInfo.adcode.set(cityCode);
        }
        reportData$NYCommonInfo.platform.set(1);
        reportData$NYCommonInfo.qqVersion.set(AppSetting.f99551k);
        reportData$NYCommonInfo.model.set(ah.F());
        reportData$NYCommonInfo.brand.set(ah.C());
        reportData$NYCommonInfo.ver.set(ah.t());
        reportData$NYCommonInfo.appid.set(AppSetting.f());
        PBUInt32Field pBUInt32Field = reportData$NYCommonInfo.net;
        com.tencent.mobileqq.springhb.util.b bVar = com.tencent.mobileqq.springhb.util.b.f289632a;
        pBUInt32Field.set(bVar.a());
        reportData$NYCommonInfo.vip_type.set(bVar.c(this.f289623e));
        return reportData$NYCommonInfo;
    }

    private void m(int i3) {
        try {
            HashMap hashMap = new HashMap();
            HashMap<Long, LinkedList<ReportInfo>> hashMap2 = new HashMap<>();
            long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
            D();
            Iterator<ReportInfo> it = this.f289625h.iterator();
            while (it.hasNext()) {
                ReportInfo next = it.next();
                if (h(next)) {
                    if (next.reqSeq == 0) {
                        next.reqSeq = serverTimeMillis;
                    } else {
                        next.retryCount++;
                    }
                    next.isSending = true;
                    LinkedList linkedList = (LinkedList) hashMap.get(Long.valueOf(next.reqSeq));
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        hashMap.put(Long.valueOf(next.reqSeq), linkedList);
                    }
                    linkedList.add(k(next));
                    LinkedList<ReportInfo> linkedList2 = hashMap2.get(Long.valueOf(next.reqSeq));
                    if (linkedList2 == null) {
                        linkedList2 = new LinkedList<>();
                        hashMap2.put(Long.valueOf(next.reqSeq), linkedList2);
                    }
                    linkedList2.add(next);
                }
            }
            y(hashMap2);
            for (Map.Entry entry : hashMap.entrySet()) {
                LinkedList<ReportData$NYReportItem> linkedList3 = (LinkedList) entry.getValue();
                ReportData$NYReportReq reportData$NYReportReq = new ReportData$NYReportReq();
                reportData$NYReportReq.commonInfo.set(l());
                reportData$NYReportReq.reportItems.set(linkedList3);
                reportData$NYReportReq.triggerSource.set(i3);
                reportData$NYReportReq.uin.set(this.f289623e.getLongAccountUin());
                long a16 = com.tencent.mobileqq.springhb.debug.b.f289046a.a(linkedList3);
                NewIntent j3 = j(reportData$NYReportReq.toByteArray(), a16);
                j3.setObserver(q(((Long) entry.getKey()).longValue()));
                this.f289623e.startServlet(j3);
                this.K.f(a16);
                this.K.g(1L);
            }
        } catch (Throwable th5) {
            com.tencent.mobileqq.springhb.util.b.f289632a.e(this.f289622d, false, "doReportRequest:", th5);
        }
    }

    private int o() {
        Iterator<ReportInfo> it = this.f289625h.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (h(it.next())) {
                i3++;
            }
        }
        return i3;
    }

    private String p() {
        StringBuilder sb5 = new StringBuilder(((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getQWalletInternalPath());
        sb5.append(this.f289623e.getAccount());
        sb5.append("/.config/");
        if (this.f289624f == 2) {
            sb5.append("report2025.cache");
        } else {
            sb5.append("report2024.cache");
        }
        return sb5.toString();
    }

    private BusinessObserver q(final long j3) {
        return new BusinessObserver() { // from class: com.tencent.mobileqq.springhb.r
            @Override // mqq.observer.BusinessObserver
            public final void onReceive(int i3, boolean z16, Bundle bundle) {
                t.this.u(j3, i3, z16, bundle);
            }
        };
    }

    private void r() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(GuardManager.ACTION_PLUGIN_STATE_CHANGE);
            this.f289623e.getApp().registerReceiver(this.L, intentFilter);
        } catch (Throwable th5) {
            com.tencent.mobileqq.springhb.util.b.f289632a.e(this.f289622d, false, "init:", th5);
        }
        com.tencent.mobileqq.springhb.util.a aVar = com.tencent.mobileqq.springhb.util.a.f289630a;
        this.f289626i = aVar.c("batch_size", 18, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
        this.F = aVar.a("report_is_overload", false, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
        this.G = aVar.e("report_interval", 1200L, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
        this.H = aVar.e("switch_to_bg_interval", 5L, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
        this.f289627m = aVar.c("report_level", 0, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
        this.C = aVar.e("report_level_time", 0L, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
        this.D = aVar.e("last_report_time", 0L, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
        this.E = aVar.e("last_save_report_file_time", 0L, com.tencent.mobileqq.springhb.a.a(this.f289624f), false, this.f289623e);
        C();
        com.tencent.mobileqq.springhb.util.b.f289632a.f(this.f289622d, false, "[init] mBatchSize:" + this.f289626i + ",mIsOverLoad:" + this.F + ",mReportInterval:" + this.G + ",mSwitchToBgInterval:" + this.H + ",mReportLevel:" + this.f289627m + ",mReportLevelValidTime:" + this.C + ",mLastReportTime:" + this.D + ",mLastSaveFileTime:" + this.E);
    }

    private void s() {
        if (this.I) {
            return;
        }
        this.f289625h = B();
        D();
        com.tencent.mobileqq.springhb.util.b.f289632a.f(this.f289622d, false, "[initReportItemsFromFile] size:" + this.f289625h.size() + " mReportItems:" + this.f289625h);
        this.I = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void t(int i3, boolean z16, long j3, Bundle bundle) {
        com.tencent.mobileqq.springhb.util.b bVar = com.tencent.mobileqq.springhb.util.b.f289632a;
        bVar.f(this.f289622d, true, "[reportListener] onReceive:type:" + i3 + ",isSuc:" + z16 + ",reqSeq:" + j3);
        try {
            F(j3);
            if (z16) {
                this.K.e(bundle.getLong("report_cnt", 0L));
            } else {
                this.K.c(bundle.getLong("report_cnt", 0L));
            }
            byte[] byteArray = bundle.getByteArray("data");
            if (byteArray != null && z16) {
                ReportData$NYReportRsp reportData$NYReportRsp = new ReportData$NYReportRsp();
                reportData$NYReportRsp.mergeFrom(byteArray);
                int i16 = reportData$NYReportRsp.ret.get();
                bVar.f(this.f289622d, false, "[reportListener] onReceive nyReportRsp:" + bVar.h(reportData$NYReportRsp));
                if (i16 == 110002) {
                    H(true);
                } else {
                    H(false);
                }
                i(j3, i16);
                G(reportData$NYReportRsp.batchSize.get());
                K(reportData$NYReportRsp.reportInterval.get());
                N(reportData$NYReportRsp.switchToBgInterval.get());
                L(reportData$NYReportRsp.reportLevel.get());
                M(reportData$NYReportRsp.reportLevelTime.get());
            }
        } catch (Throwable th5) {
            com.tencent.mobileqq.springhb.util.b.f289632a.e(this.f289622d, false, "[reportListener] onReceive fail exception:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(final long j3, final int i3, final boolean z16, final Bundle bundle) {
        this.J.post(new Runnable() { // from class: com.tencent.mobileqq.springhb.s
            @Override // java.lang.Runnable
            public final void run() {
                t.this.t(i3, z16, j3, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(ReportInfo reportInfo, int i3) {
        try {
            com.tencent.mobileqq.springhb.util.b bVar = com.tencent.mobileqq.springhb.util.b.f289632a;
            bVar.f(this.f289622d, false, "[report] " + reportInfo + ",over:" + this.F + ",level:" + this.f289627m + ",levelTime:" + this.C + ",from:" + i3);
            this.K.b(1L);
            if (((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).disableReport(this.f289624f)) {
                bVar.f(this.f289622d, false, "[report] disableReport");
                this.K.d(1L);
                return;
            }
            s();
            if (A(reportInfo)) {
                bVar.f(this.f289622d, false, "[report] sorry, we should drop this info");
                this.K.d(1L);
                return;
            }
            int i16 = 1;
            if (com.tencent.mobileqq.springhb.debug.b.f289046a.b()) {
                reportInfo.isRealTime = true;
            }
            g(reportInfo);
            if (reportInfo.isRealTime) {
                i16 = 0;
            }
            P(i16);
        } catch (Throwable th5) {
            com.tencent.mobileqq.springhb.util.b.f289632a.e(this.f289622d, false, "report:", th5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(LinkedList linkedList) {
        synchronized (M) {
            ((IQWalletApi) QRoute.api(IQWalletApi.class)).saveObject(linkedList, p());
            com.tencent.mobileqq.springhb.util.b.f289632a.f(this.f289622d, true, "[saveReportFile] done");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(int i3) {
        if (((ISpringHbTempApi) QRoute.api(ISpringHbTempApi.class)).disableReport(this.f289624f)) {
            com.tencent.mobileqq.springhb.util.b.f289632a.f(this.f289622d, false, "[tryReport] disableReport");
            return;
        }
        s();
        if (i3 == 4) {
            if (this.J.hasMessages(100)) {
                J(true);
                return;
            }
            return;
        }
        P(i3);
    }

    private void y(HashMap<Long, LinkedList<ReportInfo>> hashMap) {
        for (Map.Entry<Long, LinkedList<ReportInfo>> entry : hashMap.entrySet()) {
            com.tencent.mobileqq.springhb.util.b bVar = com.tencent.mobileqq.springhb.util.b.f289632a;
            bVar.f(this.f289622d, false, "[ReportToSvrItem] reqSeq=" + entry.getKey() + " size=" + entry.getValue().size() + " info=" + bVar.g(entry.getValue()));
        }
    }

    public void E(final ReportInfo reportInfo, final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) reportInfo, i3);
            return;
        }
        if (reportInfo == null) {
            com.tencent.mobileqq.springhb.util.b.f289632a.d(this.f289622d, false, "reportInfo is null from:" + i3);
            return;
        }
        this.J.post(new Runnable() { // from class: com.tencent.mobileqq.springhb.o
            @Override // java.lang.Runnable
            public final void run() {
                t.this.v(reportInfo, i3);
            }
        });
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 != 100) {
            if (i3 == 101) {
                P(2);
                return false;
            }
            return false;
        }
        J(true);
        return false;
    }

    public DebugMonitorHelper n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (DebugMonitorHelper) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.K;
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.mobileqq.springhb.util.b.f289632a.f(this.f289622d, false, "[onDestroy]");
        O(4);
        this.K.k();
        try {
            this.f289623e.getApp().unregisterReceiver(this.L);
        } catch (Throwable th5) {
            com.tencent.mobileqq.springhb.util.b.f289632a.e(this.f289622d, false, "onDestroy:", th5);
        }
    }
}
