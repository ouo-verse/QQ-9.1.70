package com.tencent.avcore.rtc.node.report;

import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.avcore.rtc.node.report.data.CommonNodeData;
import com.tencent.avcore.rtc.node.report.data.EndState;
import com.tencent.avcore.rtc.node.report.data.NodeEvent;
import com.tencent.avcore.rtc.node.report.data.NodeInfo;
import com.tencent.avcore.rtc.node.report.data.StartState;
import com.tencent.avcore.rtc.node.report.utils.c;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RtcNodeReportManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f77491a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f77492b;

    /* renamed from: c, reason: collision with root package name */
    private final long f77493c;

    /* renamed from: d, reason: collision with root package name */
    private RtcNodeReport f77494d;

    /* renamed from: e, reason: collision with root package name */
    private HandlerThread f77495e;

    /* renamed from: f, reason: collision with root package name */
    private volatile Handler f77496f;

    /* renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<String, CommonNodeData> f77497g;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final RtcNodeReportManager f77520a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33268);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f77520a = new RtcNodeReportManager();
            }
        }
    }

    RtcNodeReportManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f77491a = false;
        this.f77492b = false;
        this.f77493c = 200L;
        this.f77497g = new ConcurrentHashMap<>();
        this.f77494d = RtcNodeReport.e();
    }

    private void d() {
        if (this.f77496f == null) {
            init();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        if (!this.f77491a) {
            f();
            this.f77491a = true;
            QLog.d("RtcNodeReportManager", 1, "RtcNodeReportManager load result:=" + this.f77492b);
        }
        return this.f77492b;
    }

    private void f() {
        try {
            System.loadLibrary("rtc_node_report");
            this.f77492b = true;
        } catch (Throwable unused) {
            this.f77492b = false;
        }
    }

    public static RtcNodeReportManager getInstance() {
        return a.f77520a;
    }

    public void addNodeEvent(String str, int i3, NodeEvent nodeEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, Integer.valueOf(i3), nodeEvent);
        } else {
            if (this.f77496f == null) {
                return;
            }
            this.f77496f.post(new Runnable(str, nodeEvent, i3) { // from class: com.tencent.avcore.rtc.node.report.RtcNodeReportManager.4
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f77509d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ NodeEvent f77510e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f77511f;

                {
                    this.f77509d = str;
                    this.f77510e = nodeEvent;
                    this.f77511f = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RtcNodeReportManager.this, str, nodeEvent, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (RtcNodeReportManager.this.e() && c.e() && !TextUtils.isEmpty(this.f77509d) && this.f77510e != null) {
                        RtcNodeReportManager.this.f77494d.a(this.f77509d, this.f77511f, this.f77510e);
                    }
                }
            });
        }
    }

    public void cleanAllNodeReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            if (this.f77496f == null) {
                return;
            }
            this.f77496f.post(new Runnable() { // from class: com.tencent.avcore.rtc.node.report.RtcNodeReportManager.8
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RtcNodeReportManager.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (RtcNodeReportManager.this.e() && c.e()) {
                        RtcNodeReportManager.this.f77494d.b();
                    }
                }
            });
        }
    }

    public void cleanNodeReport(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            if (this.f77496f == null) {
                return;
            }
            this.f77496f.post(new Runnable(str) { // from class: com.tencent.avcore.rtc.node.report.RtcNodeReportManager.7
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f77517d;

                {
                    this.f77517d = str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RtcNodeReportManager.this, (Object) str);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        if (!RtcNodeReportManager.this.e() || !c.e() || TextUtils.isEmpty(this.f77517d)) {
                            return;
                        }
                        RtcNodeReportManager.this.f77497g.remove(this.f77517d);
                        RtcNodeReportManager.this.f77494d.c(this.f77517d);
                    }
                }
            });
        }
    }

    public void endNode(String str, int i3, EndState endState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), endState);
        } else {
            if (this.f77496f == null) {
                return;
            }
            this.f77496f.post(new Runnable(str, endState, i3) { // from class: com.tencent.avcore.rtc.node.report.RtcNodeReportManager.5
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f77512d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ EndState f77513e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ int f77514f;

                {
                    this.f77512d = str;
                    this.f77513e = endState;
                    this.f77514f = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RtcNodeReportManager.this, str, endState, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (RtcNodeReportManager.this.e() && c.e() && !TextUtils.isEmpty(this.f77512d) && this.f77513e != null) {
                        RtcNodeReportManager.this.f77494d.d(this.f77512d, this.f77514f, this.f77513e);
                    }
                }
            });
        }
    }

    public CommonNodeData getCommonNodeData(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CommonNodeData) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f77497g.get(str);
    }

    public synchronized void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f77496f == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("VideoNodeReportThread");
            this.f77495e = baseHandlerThread;
            baseHandlerThread.start();
            this.f77496f = new Handler(this.f77495e.getLooper());
            setCallback(this);
        }
    }

    public void log(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str, (Object) str2);
        } else {
            ThreadManagerV2.excute(new Runnable(str, str2) { // from class: com.tencent.avcore.rtc.node.report.RtcNodeReportManager.11
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f77500d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ String f77501e;

                {
                    this.f77500d = str;
                    this.f77501e = str2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RtcNodeReportManager.this, str, str2);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        QLog.d(this.f77500d, 1, this.f77501e);
                    }
                }
            }, 128, null, true);
        }
    }

    public void postDelayRunnable(Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, runnable, Long.valueOf(j3));
        } else {
            if (this.f77496f == null) {
                return;
            }
            this.f77496f.postDelayed(runnable, j3);
        }
    }

    public void report(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, i3);
        } else {
            if (this.f77496f == null) {
                return;
            }
            this.f77496f.post(new Runnable(str, i3) { // from class: com.tencent.avcore.rtc.node.report.RtcNodeReportManager.6
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f77515d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ int f77516e;

                {
                    this.f77515d = str;
                    this.f77516e = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RtcNodeReportManager.this, str, Integer.valueOf(i3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (RtcNodeReportManager.this.e() && c.e()) {
                        RtcNodeReportManager.this.f77494d.f(this.f77515d, this.f77516e);
                    }
                }
            });
        }
    }

    public void reportInterrupt(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Long.valueOf(j3));
        } else {
            if (this.f77496f == null) {
                return;
            }
            this.f77496f.post(new Runnable(i3, j3) { // from class: com.tencent.avcore.rtc.node.report.RtcNodeReportManager.9
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ int f77518d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ long f77519e;

                {
                    this.f77518d = i3;
                    this.f77519e = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, RtcNodeReportManager.this, Integer.valueOf(i3), Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (RtcNodeReportManager.this.e() && c.e()) {
                        RtcNodeReportManager.this.f77494d.g(this.f77518d, this.f77519e);
                    }
                }
            });
        }
    }

    public void setCallback(RtcNodeReportManager rtcNodeReportManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) rtcNodeReportManager);
        } else {
            if (this.f77496f == null) {
                return;
            }
            this.f77496f.post(new Runnable(rtcNodeReportManager) { // from class: com.tencent.avcore.rtc.node.report.RtcNodeReportManager.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RtcNodeReportManager f77498d;

                {
                    this.f77498d = rtcNodeReportManager;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RtcNodeReportManager.this, (Object) rtcNodeReportManager);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (RtcNodeReportManager.this.e() && c.e()) {
                        RtcNodeReportManager.this.f77494d.h(this.f77498d);
                    }
                }
            });
        }
    }

    public void setNodeCommonData(String str, CommonNodeData commonNodeData, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, commonNodeData, str2);
            return;
        }
        d();
        if (this.f77496f == null) {
            return;
        }
        this.f77496f.post(new Runnable(str, commonNodeData, str2) { // from class: com.tencent.avcore.rtc.node.report.RtcNodeReportManager.2
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f77502d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ CommonNodeData f77503e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f77504f;

            {
                this.f77502d = str;
                this.f77503e = commonNodeData;
                this.f77504f = str2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RtcNodeReportManager.this, str, commonNodeData, str2);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (RtcNodeReportManager.this.e() && c.e() && !TextUtils.isEmpty(this.f77502d) && this.f77503e != null) {
                    RtcNodeReportManager.this.f77497g.put(this.f77502d, this.f77503e);
                    RtcNodeReportManager.this.f77494d.i(this.f77502d, this.f77503e, this.f77504f);
                }
            }
        });
    }

    public void startNode(String str, int i3, StartState startState, NodeInfo nodeInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, Integer.valueOf(i3), startState, nodeInfo);
            return;
        }
        d();
        if (this.f77496f == null) {
            return;
        }
        this.f77496f.post(new Runnable(str, startState, nodeInfo, i3) { // from class: com.tencent.avcore.rtc.node.report.RtcNodeReportManager.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f77505d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ StartState f77506e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ NodeInfo f77507f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f77508h;

            {
                this.f77505d = str;
                this.f77506e = startState;
                this.f77507f = nodeInfo;
                this.f77508h = i3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, RtcNodeReportManager.this, str, startState, nodeInfo, Integer.valueOf(i3));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                if (RtcNodeReportManager.this.e() && c.e() && !TextUtils.isEmpty(this.f77505d) && this.f77506e != null && this.f77507f != null) {
                    RtcNodeReportManager.this.f77494d.j(this.f77505d, this.f77508h, this.f77506e, this.f77507f);
                }
            }
        });
    }

    public void report(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            ThreadManagerV2.executeDelay(new Runnable(str3) { // from class: com.tencent.avcore.rtc.node.report.RtcNodeReportManager.10
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ String f77499d;

                {
                    this.f77499d = str3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) RtcNodeReportManager.this, (Object) str3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (TextUtils.isEmpty(this.f77499d)) {
                        QLog.d("rtc_node_report", 1, "report empty keyvalues");
                        return;
                    }
                    HashMap<String, String> a16 = com.tencent.avcore.rtc.node.report.utils.a.a(this.f77499d);
                    com.tencent.avcore.rtc.node.report.utils.a.b("0DOU0EDF8O4GDAXD", "rtc_node_report", a16);
                    QLog.d("rtc_node_report", 1, "report content:=" + this.f77499d + ",mapsize:=" + a16.size());
                }
            }, 128, null, true, 200L);
        } else {
            iPatchRedirector.redirect((short) 14, this, str, str2, str3);
        }
    }
}
