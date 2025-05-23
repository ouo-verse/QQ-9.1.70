package com.tencent.av.business.manager.report;

import android.app.ActivityManager;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.funchat.record.e;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VideoNodeReporter extends com.tencent.av.business.manager.a {
    static String E;
    HandlerThread C;
    Handler.Callback D;

    /* renamed from: h, reason: collision with root package name */
    List<b> f73413h;

    /* renamed from: i, reason: collision with root package name */
    int f73414i;

    /* renamed from: m, reason: collision with root package name */
    Handler f73415m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a implements Handler.Callback {
        a() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x005e, code lost:
        
            if (r4.equals("com.tencent.av.ui.AVActivity") != false) goto L21;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00b2  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x00c7  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
        @Override // android.os.Handler.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean handleMessage(Message message) {
            long j3;
            boolean z16;
            long j16;
            boolean h16;
            long j17;
            boolean u16;
            if (QLog.isColorLevel()) {
                QLog.d("VideoNodeReporter", 2, "handleMessage msg =  " + message.what);
            }
            if (message.what == 1) {
                long j18 = 1;
                VideoNodeReporter.this.v(36, 1L);
                boolean p16 = SmallScreenUtils.p(BaseApplication.getContext());
                VideoNodeReporter videoNodeReporter = VideoNodeReporter.this;
                if (p16) {
                    j3 = 1;
                } else {
                    j3 = 0;
                }
                videoNodeReporter.v(23, j3);
                String str = null;
                try {
                    str = ConfigHandler.O2(BaseApplication.getContext());
                    if (!TextUtils.isEmpty(str)) {
                    }
                    z16 = true;
                } catch (Exception e16) {
                    QLog.d("VideoNodeReporter", 1, "handleMessage Exception ,msg =  " + message.what, e16);
                }
                VideoNodeReporter videoNodeReporter2 = VideoNodeReporter.this;
                if (!z16) {
                    j16 = 1;
                } else {
                    j16 = 0;
                }
                videoNodeReporter2.v(28, j16);
                VideoNodeReporter videoNodeReporter3 = VideoNodeReporter.this;
                int i3 = videoNodeReporter3.f73414i;
                videoNodeReporter3.v(37, i3);
                if (r.h0() != null) {
                    r.h0().L3("batteryValue", String.valueOf(i3));
                }
                h16 = r.h1(BaseApplication.getContext());
                VideoNodeReporter videoNodeReporter4 = VideoNodeReporter.this;
                if (!h16) {
                    j17 = 1;
                } else {
                    j17 = 0;
                }
                videoNodeReporter4.v(39, j17);
                u16 = SmallScreenUtils.u(BaseApplication.getContext());
                VideoNodeReporter videoNodeReporter5 = VideoNodeReporter.this;
                if (!u16) {
                    j18 = 0;
                }
                videoNodeReporter5.v(40, j18);
                VideoNodeReporter.this.x();
                int i16 = e.a().f75878j;
                QLog.d("VideoNodeReporter", 1, "handleMessage, activityName =  " + str + ",isAppForground = " + p16 + ",isBackground = " + z16 + ",checkDuration = " + i16);
                VideoNodeReporter.this.f73415m.sendEmptyMessageDelayed(1, (long) i16);
            }
            return false;
            z16 = false;
            VideoNodeReporter videoNodeReporter22 = VideoNodeReporter.this;
            if (!z16) {
            }
            videoNodeReporter22.v(28, j16);
            VideoNodeReporter videoNodeReporter32 = VideoNodeReporter.this;
            int i36 = videoNodeReporter32.f73414i;
            videoNodeReporter32.v(37, i36);
            if (r.h0() != null) {
            }
            h16 = r.h1(BaseApplication.getContext());
            VideoNodeReporter videoNodeReporter42 = VideoNodeReporter.this;
            if (!h16) {
            }
            videoNodeReporter42.v(39, j17);
            u16 = SmallScreenUtils.u(BaseApplication.getContext());
            VideoNodeReporter videoNodeReporter52 = VideoNodeReporter.this;
            if (!u16) {
            }
            videoNodeReporter52.v(40, j18);
            VideoNodeReporter.this.x();
            int i162 = e.a().f75878j;
            QLog.d("VideoNodeReporter", 1, "handleMessage, activityName =  " + str + ",isAppForground = " + p16 + ",isBackground = " + z16 + ",checkDuration = " + i162);
            VideoNodeReporter.this.f73415m.sendEmptyMessageDelayed(1, (long) i162);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: c, reason: collision with root package name */
        String f73427c;

        /* renamed from: g, reason: collision with root package name */
        public String f73431g;

        /* renamed from: h, reason: collision with root package name */
        public String f73432h;

        /* renamed from: i, reason: collision with root package name */
        public long f73433i;

        /* renamed from: j, reason: collision with root package name */
        public long f73434j;

        /* renamed from: a, reason: collision with root package name */
        public long f73425a = -1;

        /* renamed from: b, reason: collision with root package name */
        boolean f73426b = false;

        /* renamed from: d, reason: collision with root package name */
        long[] f73428d = new long[41];

        /* renamed from: e, reason: collision with root package name */
        public int f73429e = -1;

        /* renamed from: f, reason: collision with root package name */
        public int f73430f = -1;

        /* renamed from: k, reason: collision with root package name */
        public String f73435k = "KilledBySystem";

        b() {
        }

        public String a(int i3, long j3) {
            if (i3 >= 0 && i3 < 41) {
                if (j3 == 1) {
                    this.f73428d[i3] = 1;
                } else {
                    this.f73428d[i3] = j3;
                }
                StringBuilder sb5 = new StringBuilder();
                for (int i16 = 0; i16 < 41; i16++) {
                    if (i16 != 14) {
                        if (i16 != 20) {
                            if (i16 != 29) {
                                if (i16 != 36) {
                                    sb5.append(String.valueOf(this.f73428d[i16]));
                                    sb5.append(QbAddrData.DATA_SPLITER);
                                } else {
                                    if (this.f73433i > 0) {
                                        this.f73434j = (System.currentTimeMillis() - this.f73433i) / 1000;
                                    }
                                    sb5.append(this.f73434j);
                                    sb5.append(QbAddrData.DATA_SPLITER);
                                }
                            } else {
                                sb5.append(this.f73435k);
                                sb5.append(QbAddrData.DATA_SPLITER);
                            }
                        } else {
                            sb5.append(0);
                            sb5.append(QbAddrData.DATA_SPLITER);
                        }
                    } else {
                        if (this.f73428d[14] == 0) {
                            this.f73427c = VideoNodeReporter.s();
                            this.f73428d[14] = 1;
                        }
                        sb5.append(this.f73427c);
                        sb5.append(QbAddrData.DATA_SPLITER);
                    }
                }
                return sb5.toString();
            }
            AVCoreLog.printAllUserLog("VideoNodeReporter", "buildBody report error:" + i3);
            return null;
        }

        public String b() {
            String model = DeviceInfoMonitor.getModel();
            String valueOf = String.valueOf(Build.VERSION.SDK_INT);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("Android");
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(model);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(valueOf);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(valueOf);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f73432h);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.f73431g);
            sb5.append(QbAddrData.DATA_SPLITER);
            int i3 = this.f73430f;
            if (i3 != -1) {
                sb5.append(i3);
                sb5.append(QbAddrData.DATA_SPLITER);
            } else {
                sb5.append(String.valueOf(this.f73428d[20]));
                sb5.append(QbAddrData.DATA_SPLITER);
            }
            sb5.append(this.f73429e);
            sb5.append(QbAddrData.DATA_SPLITER);
            return sb5.toString();
        }

        public void c(SessionInfo sessionInfo, String str) {
            if (sessionInfo != null) {
                int i3 = sessionInfo.f73075s;
                if (i3 != -1) {
                    this.f73429e = i3;
                }
                int i16 = sessionInfo.f73035i;
                if (i16 != 0) {
                    this.f73430f = i16;
                }
                if (!TextUtils.isEmpty(sessionInfo.f73091w)) {
                    this.f73431g = sessionInfo.f73091w;
                }
            }
            if (!TextUtils.isEmpty(str)) {
                this.f73432h = str;
            }
        }
    }

    public VideoNodeReporter(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
        String str;
        this.D = new a();
        this.f73413h = new ArrayList();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("VideoNodeReportThread");
        this.C = baseHandlerThread;
        baseHandlerThread.start();
        this.f73415m = new Handler(this.C.getLooper(), this.D);
        String[] split = MobileQQ.processName.split(":");
        if (split != null && split.length == 2) {
            str = split[1];
        } else {
            str = null;
        }
        E = "avideo_node_report_" + str;
        if (QLog.isColorLevel()) {
            QLog.d("VideoNodeReporter", 2, "construct VideoNodeReporter  sSPName = " + E);
        }
    }

    private void D(long j3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoNodeReporter", 2, "writeSpSessionRecord,roomId = " + j3 + ",detail = " + str);
        }
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSystemSharedPreferences(E, 0).edit();
        edit.putString(String.valueOf(j3), str);
        edit.commit();
    }

    private void p() {
        SharedPreferences systemSharedPreferences = BaseApplicationImpl.getApplication().getSystemSharedPreferences(E, 0);
        Map<String, ?> all = systemSharedPreferences.getAll();
        if (all != null && all.size() > 0) {
            QLog.d("VideoNodeReporter", 1, "checkAndReportCrashRecord, allContent.size() = " + all.size());
            for (Map.Entry<String, ?> entry : all.entrySet()) {
                try {
                    z(Long.decode(entry.getKey()).longValue());
                } catch (Exception e16) {
                    QLog.d("VideoNodeReporter", 1, "checkAndReportCrashRecord Exception ", e16);
                    systemSharedPreferences.edit().remove(entry.getKey()).commit();
                }
            }
        }
        QLog.d("VideoNodeReporter", 1, "checkAndReportCrashRecord allContent = " + all);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(long j3, int i3, long j16) {
        if (QLog.isColorLevel()) {
            QLog.d("VideoNodeReporter", 2, " reportNode ,node = " + i3 + ",value = " + j16 + ",roomId = " + j3);
        }
        b r16 = r(j3);
        if (r16 == null) {
            r16 = new b();
            r16.f73425a = j3;
            this.f73413h.add(r16);
        }
        String currentAccountUin = this.f73316e.getCurrentAccountUin();
        SessionInfo f16 = n.e().f();
        if (r16.f73425a == f16.b()) {
            r16.c(f16, currentAccountUin);
        }
        D(j3, r16.b() + r16.a(i3, j16));
    }

    static String s() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String t(long j3) {
        String string = BaseApplicationImpl.getApplication().getSystemSharedPreferences(E, 0).getString(String.valueOf(j3), "");
        QLog.d("VideoNodeReporter", 1, "getSpSessionRecord roomId = " + j3 + ",result = " + string);
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(long j3) {
        SharedPreferences.Editor edit = BaseApplicationImpl.getApplication().getSystemSharedPreferences(E, 0).edit();
        edit.remove(String.valueOf(j3));
        edit.commit();
        AVCoreLog.printAllUserLog("VideoNodeReporter", "removeSpSessionRecord,roomId = " + j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        try {
            ActivityManager activityManager = (ActivityManager) this.f73316e.getApplication().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            long g16 = (ah.g(Process.myPid()) / 1024) / 1024;
            long j3 = (memoryInfo.availMem / 1024) / 1024;
            long j16 = (memoryInfo.threshold / 1024) / 1024;
            QLog.d("VideoNodeReporter", 1, "reportMemoryStatus,availMem = " + j3 + ",threshold = " + j16 + ",isLowMemory = " + memoryInfo.lowMemory + ",pss = " + g16);
            v(21, j16);
            v(15, j3);
            v(22, g16);
        } catch (Exception e16) {
            QLog.d("VideoNodeReporter", 1, "reportMemoryStatus,Exception ", e16);
        }
    }

    public void A(int i3) {
        this.f73414i = i3;
    }

    public void B(final long j3) {
        QLog.d("VideoNodeReporter", 1, "updateCallerRoomId roomId = " + j3);
        this.f73415m.post(new Runnable() { // from class: com.tencent.av.business.manager.report.VideoNodeReporter.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoNodeReporter.this.f73413h.size() > 0) {
                    for (b bVar : VideoNodeReporter.this.f73413h) {
                        if (bVar.f73425a == -1) {
                            long j16 = j3;
                            bVar.f73425a = j16;
                            VideoNodeReporter.this.w(j16, 26, j16);
                            QLog.d("VideoNodeReporter", 1, "updateCallerRoomId  updated roomId = " + j3);
                            VideoNodeReporter.this.u(-1L);
                        }
                    }
                }
            }
        });
    }

    public void C(final String str) {
        this.f73415m.post(new Runnable() { // from class: com.tencent.av.business.manager.report.VideoNodeReporter.5
            @Override // java.lang.Runnable
            public void run() {
                QLog.d("VideoNodeReporter", 1, "updateCrashType ,crashType = " + str);
                if (VideoNodeReporter.this.f73413h.size() > 0) {
                    Iterator<b> it = VideoNodeReporter.this.f73413h.iterator();
                    while (it.hasNext()) {
                        it.next().f73435k = str;
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public void g() {
        AVCoreLog.printAllUserLog("VideoNodeReporter", "onCreate ");
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public boolean i(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public void j(long j3, int i3, String str, String str2) {
        AVCoreLog.printAllUserLog("VideoNodeReporter", " onSessionStatusChanged :" + i3 + ",para = " + str2);
        if (i3 == 1) {
            if (this.f73413h.size() > 0) {
                Iterator<b> it = this.f73413h.iterator();
                while (it.hasNext()) {
                    it.next().f73433i = System.currentTimeMillis();
                }
            }
            v(38, this.f73414i);
        }
    }

    b r(long j3) {
        if (this.f73413h.size() > 0) {
            for (b bVar : this.f73413h) {
                if (j3 == bVar.f73425a) {
                    return bVar;
                }
            }
        }
        return null;
    }

    public void v(final int i3, final long j3) {
        Handler handler;
        QLog.d("VideoNodeReporter", 1, " report ,node = " + i3 + ",value = " + j3);
        if (this.f73316e != null && r.h0() != null && n.e().f() != null && (handler = this.f73415m) != null) {
            if (this.f73316e.f73120h0) {
                AVCoreLog.printAllUserLog("VideoNodeReporter", " report error 1 ,exit has been called,node = " + i3);
                return;
            }
            handler.post(new Runnable() { // from class: com.tencent.av.business.manager.report.VideoNodeReporter.3
                @Override // java.lang.Runnable
                public void run() {
                    QLog.d("VideoNodeReporter", 1, "in runnabe report ,node = " + i3 + ",value = " + j3);
                    if (VideoNodeReporter.this.f73413h.size() > 0) {
                        Iterator<b> it = VideoNodeReporter.this.f73413h.iterator();
                        while (it.hasNext()) {
                            VideoNodeReporter.this.w(it.next().f73425a, i3, j3);
                        }
                        return;
                    }
                    QLog.d("VideoNodeReporter", 1, " report ,node = " + i3 + ",value = " + j3 + ",seesionRecordList is empty");
                }
            });
            return;
        }
        AVCoreLog.printAllUserLog("VideoNodeReporter", " report error 0: " + i3 + "|" + this.f73316e);
    }

    public void w(final long j3, final int i3, final long j16) {
        Handler handler;
        QLog.d("VideoNodeReporter", 1, " reportByRoomId ,node = " + i3 + ",value = " + j16);
        if (this.f73316e != null && r.h0() != null && n.e().f() != null && (handler = this.f73415m) != null) {
            if (this.f73316e.f73120h0) {
                AVCoreLog.printAllUserLog("VideoNodeReporter", " reportByRoomId error 1 ,exit has been called,node = " + i3);
                return;
            }
            if (j3 == 0) {
                QLog.d("VideoNodeReporter", 1, "reportByRoomId rooid is 0", new Throwable("test"));
                return;
            } else {
                handler.post(new Runnable() { // from class: com.tencent.av.business.manager.report.VideoNodeReporter.4
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoNodeReporter.this.q(j3, i3, j16);
                    }
                });
                return;
            }
        }
        AVCoreLog.printAllUserLog("VideoNodeReporter", " reportByRoomId error 0: " + i3 + "|" + this.f73316e);
    }

    public void x() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.business.manager.report.VideoNodeReporter.6
                @Override // java.lang.Runnable
                public void run() {
                    VideoNodeReporter.this.y();
                }
            }, 16, null, true);
        } else {
            y();
        }
    }

    public void z(final long j3) {
        this.f73415m.post(new Runnable() { // from class: com.tencent.av.business.manager.report.VideoNodeReporter.7
            @Override // java.lang.Runnable
            public void run() {
                String t16 = VideoNodeReporter.this.t(j3);
                QLog.d("VideoNodeReporter", 1, "reportToServer ,roomId = " + j3 + ", detail = " + t16);
                if (!TextUtils.isEmpty(t16) && j3 != 0) {
                    DcReportUtil.b(null, "dc02402", t16);
                }
                VideoNodeReporter.this.u(j3);
                Iterator<b> it = VideoNodeReporter.this.f73413h.iterator();
                while (it.hasNext()) {
                    if (j3 == it.next().f73425a) {
                        it.remove();
                    }
                }
            }
        });
    }
}
