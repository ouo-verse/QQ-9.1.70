package com.tencent.mobileqq.msf.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.msf.core.net.l;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.mobileqq.msf.core.x.b;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.sign.QQSecuritySign;
import com.tencent.msf.service.protocol.kqqconfig.GrayUinCheckResp;
import com.tencent.msf.service.protocol.pb.SSOLoginMerge;
import com.tencent.msf.service.protocol.pb.SSOReserveField;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.CodecWarpper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.log.report.LogManager;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.ByteArrayOutputStream;
import java.lang.Thread;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.api.ProcessConstant;

/* compiled from: P */
/* loaded from: classes15.dex */
public class t {
    static IPatchRedirector $redirector_ = null;
    public static final String O = "MSF.C.NetConnTag.";
    private static final String P = "__extraTimeoutSeq";
    public static final String Q = "msf_monitor_quque";
    private static final AtomicInteger R;
    private static final ConcurrentHashMap<String, ConcurrentLinkedQueue<Integer>> S;
    private static final ConcurrentHashMap<String, ConcurrentLinkedQueue<Integer>> T;
    private static int U;
    private static boolean V;
    private static final String[] W;
    private static int X;
    private static byte[] Y;
    public static int Z;

    /* renamed from: a0, reason: collision with root package name */
    public static volatile boolean f250069a0;

    /* renamed from: b0, reason: collision with root package name */
    public static long f250070b0;

    /* renamed from: c0, reason: collision with root package name */
    public static int f250071c0;

    /* renamed from: d0, reason: collision with root package name */
    public static AtomicBoolean f250072d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final CopyOnWriteArraySet<String> f250073e0;

    /* renamed from: f0, reason: collision with root package name */
    private static final CopyOnWriteArraySet<String> f250074f0;

    /* renamed from: g0, reason: collision with root package name */
    private static final AtomicBoolean f250075g0;
    private long A;
    private long B;
    private long C;
    final com.tencent.mobileqq.msf.core.e0.g D;
    final com.tencent.mobileqq.msf.core.e0.f E;
    private final boolean F;
    private byte[] G;
    private final AtomicBoolean H;
    private int I;
    private long J;
    private long K;
    private long L;
    private boolean M;
    private AtomicBoolean N;

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.mobileqq.msf.core.net.o f250076a;

    /* renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap<Integer, ToServiceMsg> f250077b;

    /* renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap<Integer, ArrayList<Integer>> f250078c;

    /* renamed from: d, reason: collision with root package name */
    public ConcurrentHashMap<Integer, ArrayList<ToServiceMsg>> f250079d;

    /* renamed from: e, reason: collision with root package name */
    public LinkedBlockingDeque<ToServiceMsg> f250080e;

    /* renamed from: f, reason: collision with root package name */
    public LinkedBlockingDeque<ToServiceMsg> f250081f;

    /* renamed from: g, reason: collision with root package name */
    private final Handler f250082g;

    /* renamed from: h, reason: collision with root package name */
    private final b f250083h;

    /* renamed from: i, reason: collision with root package name */
    private int f250084i;

    /* renamed from: j, reason: collision with root package name */
    public long f250085j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f250086k;

    /* renamed from: l, reason: collision with root package name */
    public volatile boolean f250087l;

    /* renamed from: m, reason: collision with root package name */
    public AtomicInteger f250088m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList<String> f250089n;

    /* renamed from: o, reason: collision with root package name */
    public final a f250090o;

    /* renamed from: p, reason: collision with root package name */
    private final MsfCore f250091p;

    /* renamed from: q, reason: collision with root package name */
    private final com.tencent.mobileqq.msf.core.f0.d.a f250092q;

    /* renamed from: r, reason: collision with root package name */
    private String f250093r;

    /* renamed from: s, reason: collision with root package name */
    private String f250094s;

    /* renamed from: t, reason: collision with root package name */
    private int f250095t;

    /* renamed from: u, reason: collision with root package name */
    private int f250096u;

    /* renamed from: v, reason: collision with root package name */
    public com.tencent.mobileqq.msf.core.net.r.f f250097v;

    /* renamed from: w, reason: collision with root package name */
    private final c f250098w;

    /* renamed from: x, reason: collision with root package name */
    private volatile boolean f250099x;

    /* renamed from: y, reason: collision with root package name */
    private final Object f250100y;

    /* renamed from: z, reason: collision with root package name */
    private long f250101z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b implements Runnable {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) t.this);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:153:0x0424, code lost:
        
            r0 = r0;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            int size;
            int i3;
            ToServiceMsg toServiceMsg;
            ArrayList<Integer> arrayList;
            ArrayList<ToServiceMsg> arrayList2;
            SSOLoginMerge.BusiBuffData busiBuffData;
            ToServiceMsg peek;
            int i16;
            int i17;
            char c16;
            long j3;
            byte[] wupBuffer;
            Runnable b16;
            IPatchRedirector iPatchRedirector = $redirector_;
            char c17 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            synchronized (t.this.f250100y) {
                size = t.this.f250081f.size();
                if (size > com.tencent.mobileqq.msf.core.x.h.g().b()) {
                    size = com.tencent.mobileqq.msf.core.x.h.g().b();
                }
                i3 = 0;
                if (t.this.f250101z < SystemClock.elapsedRealtime()) {
                    t.this.f250099x = false;
                } else {
                    t.this.f250082g.postDelayed(t.this.f250083h, com.tencent.mobileqq.msf.core.x.h.g().c());
                }
            }
            int i18 = 1;
            if (!t.this.f250099x && t.this.f250081f.size() - com.tencent.mobileqq.msf.core.x.h.g().d() > 0) {
                t.this.f250082g.postDelayed(t.this.f250083h, com.tencent.mobileqq.msf.core.x.h.g().c());
                t.this.f250099x = true;
            }
            int i19 = 4;
            if (QLog.isDevelopLevel()) {
                QLog.d("MSF.C.NetConnTag." + t.this.F, 4, "delayWaitSendList size is " + t.this.f250081f.size() + ", " + size + " sso package should be merged.");
            }
            long j16 = 30000;
            if (size > 0) {
                try {
                    if (size > t.this.f250081f.size()) {
                        size = t.this.f250081f.size();
                    }
                    if (size == 1 && (peek = t.this.f250081f.peek()) != null && peek.getWupBuffer().length < com.tencent.mobileqq.msf.core.x.h.g().f()) {
                        t.b(t.this, peek.getWupBuffer().length);
                        t tVar = t.this;
                        tVar.d(tVar.f250081f.poll());
                        return;
                    }
                    toServiceMsg = new ToServiceMsg("MSF SSOPackageMerge", com.tencent.mobileqq.msf.core.e0.i.f248008o, BaseConstants.CMD_SSO_LOGIN_MERGE);
                    toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
                    toServiceMsg.setMsfCommand(MsfCommand.unknown);
                    if (toServiceMsg.getRequestSsoSeq() == -1) {
                        toServiceMsg.setRequestSsoSeq(t.this.f250091p.getNextSeq());
                    }
                    toServiceMsg.setTimeout(30000L);
                    toServiceMsg.setNeedCallback(false);
                    arrayList = new ArrayList<>();
                    arrayList2 = new ArrayList<>();
                    busiBuffData = new SSOLoginMerge.BusiBuffData();
                } catch (Exception e16) {
                    QLog.d("MSF.C.NetConnTag." + t.this.F, 1, "add delayMsg to send error, close LoginMerge. " + e16, e16);
                    t.this.f250087l = false;
                    while (t.this.f250081f.size() > 0) {
                        ToServiceMsg poll = t.this.f250081f.poll();
                        if (poll != null) {
                            t.this.d(poll);
                        }
                    }
                    return;
                }
            } else {
                toServiceMsg = null;
                arrayList = null;
                arrayList2 = null;
                busiBuffData = null;
            }
            if (size > t.this.f250081f.size()) {
                size = t.this.f250081f.size();
            }
            int i26 = 0;
            int i27 = 0;
            int i28 = 0;
            while (true) {
                if (i26 >= size) {
                    break;
                }
                ToServiceMsg poll2 = t.this.f250081f.poll();
                if (poll2 != null) {
                    if (BaseConstants.CMD_REGPRXYSVC_INFOLOGIN.equals(poll2.getServiceCmd())) {
                        toServiceMsg.getAttributes().put("infoLoginMsg", poll2);
                    } else if (BaseConstants.CMD_REGPRXYSVC_GETOFFMSG.equals(poll2.getServiceCmd())) {
                        toServiceMsg.getAttributes().put("infoLoginMsg", poll2);
                    } else if (BaseConstants.CMD_NEW_REGPRXYSVC_INFOSYNC.equals(poll2.getServiceCmd())) {
                        toServiceMsg.getAttributes().put("infoLoginMsg", poll2);
                    }
                    if (!poll2.isNeedCallback()) {
                        i28++;
                    }
                    i27 += poll2.getWupBuffer().length;
                    if (i27 >= com.tencent.mobileqq.msf.core.x.h.g().d() && i26 != 0) {
                        t.this.f250081f.addFirst(poll2);
                        i16 = i26;
                        break;
                    }
                    t.b(t.this, poll2.getWupBuffer().length);
                    if (i26 == 0) {
                        toServiceMsg.setUin(poll2.getUin());
                    } else if (!toServiceMsg.getUin().equals(poll2.getUin())) {
                        t.this.f250081f.addFirst(poll2);
                        t.a(t.this, poll2.getWupBuffer().length);
                        break;
                    }
                    if (!toServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUTE_KEY_NT_KERNEL_FLAG) && poll2.getAttributes().containsKey(BaseConstants.ATTRIBUTE_KEY_NT_KERNEL_FLAG)) {
                        toServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_NT_KERNEL_FLAG, 32);
                        QLog.d("MSF.C.NetConnTag.", i18, "SSO.LoginMerge Msg set Nt Flag");
                    }
                    SSOLoginMerge.BusiBuffItem busiBuffItem = new SSOLoginMerge.BusiBuffItem();
                    busiBuffItem.SeqNo.set(poll2.getRequestSsoSeq());
                    busiBuffItem.ServiceCmd.set(poll2.getServiceCmd());
                    if (poll2.getWupBuffer().length < i19) {
                        busiBuffItem.BusiBuffLen.set(MsfMsgUtil.addByteLen(poll2.getWupBuffer()).length);
                    } else {
                        busiBuffItem.BusiBuffLen.set(poll2.getWupBuffer().length);
                    }
                    if (poll2.getWupBuffer().length >= i19) {
                        int length = poll2.getWupBuffer().length - i19;
                        wupBuffer = new byte[length];
                        System.arraycopy(poll2.getWupBuffer(), i19, wupBuffer, i3, length);
                    } else {
                        wupBuffer = poll2.getWupBuffer();
                    }
                    busiBuffItem.BusiBuff.set(ByteStringMicro.copyFrom(wupBuffer));
                    busiBuffItem.NeedResp.set(poll2.isNeedCallback());
                    busiBuffItem.message_type.set(t.f(poll2));
                    ArrayList arrayList3 = new ArrayList();
                    for (Map.Entry<String, byte[]> entry : poll2.getTransInfo().entrySet()) {
                        if (entry != null) {
                            if (com.tencent.mobileqq.msf.core.x.o.x().k().contains(entry.getKey())) {
                                SSOReserveField.SsoMapEntry ssoMapEntry = new SSOReserveField.SsoMapEntry();
                                int i29 = size;
                                ssoMapEntry.key.set(entry.getKey());
                                ssoMapEntry.value.set(ByteStringMicro.copyFrom(entry.getValue()));
                                arrayList3.add(ssoMapEntry);
                                if (QLog.isColorLevel()) {
                                    QLog.d("MSF.C.NetConnTag.", 2, "transInfo set key: " + entry.getKey());
                                }
                                size = i29;
                            }
                        }
                    }
                    i17 = size;
                    c16 = 2;
                    if (!arrayList3.isEmpty()) {
                        busiBuffItem.trans_info.set(arrayList3);
                    }
                    busiBuffData.BusiBuffVec.add(busiBuffItem);
                    arrayList.add(Integer.valueOf(poll2.getRequestSsoSeq()));
                    arrayList2.add(poll2);
                    t.this.f250077b.put(Integer.valueOf(poll2.getRequestSsoSeq()), poll2);
                    poll2.getAttributes().put(t.P, Integer.valueOf(t.R.incrementAndGet()));
                    if (poll2.getTimeout() == -1) {
                        j3 = 30000;
                        poll2.setTimeout(30000L);
                        b16 = t.this.f250092q.p().b(poll2, poll2.getTimeout(), t.this);
                    } else {
                        j3 = 30000;
                        b16 = t.this.f250092q.p().b(poll2, poll2.getTimeout(), t.this);
                    }
                    poll2.addAttribute(MsfConstants.ATTRIBUTE_TIMEOUT_CALLBACKER, b16);
                    if (com.tencent.mobileqq.msf.core.x.e.o().a()) {
                        long timeout = poll2.getTimeout() - com.tencent.mobileqq.msf.core.x.e.o().f();
                        if (timeout > 0) {
                            poll2.addAttribute(MsfConstants.ATTRIBUTE_PREDETECT_TIMEOUT_CALLBACKER, t.this.f250092q.p().a(poll2, timeout, t.this));
                        }
                    }
                } else {
                    i17 = size;
                    c16 = c17;
                    j3 = j16;
                }
                i26++;
                j16 = j3;
                c17 = c16;
                size = i17;
                i18 = 1;
                i3 = 0;
                i19 = 4;
            }
            synchronized (t.this.f250100y) {
                if (t.this.f250084i >= com.tencent.mobileqq.msf.core.x.h.g().d() && !t.this.f250099x) {
                    t.this.f250099x = true;
                    t.this.f250082g.post(t.this.f250083h);
                } else if (!t.this.f250099x && t.this.f250081f.size() >= com.tencent.mobileqq.msf.core.x.h.g().b()) {
                    t.this.f250099x = true;
                    t.this.f250082g.post(t.this.f250083h);
                } else if (!t.this.f250099x && !t.this.f250081f.isEmpty()) {
                    t.this.f250082g.postDelayed(t.this.f250083h, com.tencent.mobileqq.msf.core.x.h.g().c());
                    t.this.f250099x = true;
                }
            }
            if (i16 > 0) {
                t.this.f250078c.put(Integer.valueOf(toServiceMsg.getRequestSsoSeq()), arrayList);
                t.this.f250079d.put(Integer.valueOf(toServiceMsg.getRequestSsoSeq()), arrayList2);
                byte[] byteArray = busiBuffData.toByteArray();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                com.tencent.qphone.base.util.g.a(byteArray, byteArrayOutputStream);
                byte[] addByteLen = MsfMsgUtil.addByteLen(byteArrayOutputStream.toByteArray());
                toServiceMsg.putWupBuffer(addByteLen);
                toServiceMsg.getAttributes().put("mergeCount", Integer.valueOf(i16));
                toServiceMsg.getAttributes().put("noRespCount", Integer.valueOf(i28));
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.NetConnTag." + t.this.F, 4, "Delay ToServiceMsg ssoseq: " + toServiceMsg.getRequestSsoSeq() + " delayWaitSendList buffer size is " + byteArray.length + ", zip size is " + addByteLen.length);
                }
            }
            if (toServiceMsg != null) {
                toServiceMsg.addAttribute(BaseConstants.TIMESTAMP_ADDSENDQUEUE, Long.valueOf(System.currentTimeMillis()));
                t.this.d(toServiceMsg);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(27084);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        R = new AtomicInteger();
        S = new ConcurrentHashMap<>();
        T = new ConcurrentHashMap<>();
        U = -1;
        V = false;
        W = new String[]{"StreamSvr.UploadStreamMsg"};
        X = 0;
        Y = null;
        Z = 0;
        f250069a0 = false;
        f250070b0 = 0L;
        f250071c0 = -1;
        f250072d0 = new AtomicBoolean();
        f250073e0 = new CopyOnWriteArraySet<>();
        f250074f0 = new CopyOnWriteArraySet<>();
        f250075g0 = new AtomicBoolean();
    }

    public t(MsfCore msfCore, com.tencent.mobileqq.msf.core.f0.d.a aVar, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, msfCore, aVar, Boolean.valueOf(z16));
            return;
        }
        this.f250077b = new ConcurrentHashMap<>();
        this.f250078c = new ConcurrentHashMap<>();
        this.f250079d = new ConcurrentHashMap<>();
        this.f250080e = new LinkedBlockingDeque<>(1000);
        this.f250081f = new LinkedBlockingDeque<>();
        this.f250083h = new b();
        this.f250084i = 0;
        this.f250085j = 0L;
        this.f250086k = false;
        this.f250087l = false;
        this.f250088m = new AtomicInteger(0);
        this.f250089n = new ArrayList<>();
        this.f250093r = ":";
        this.f250094s = "0";
        this.f250095t = 0;
        this.f250096u = 0;
        this.f250097v = null;
        c cVar = new c();
        this.f250098w = cVar;
        this.f250099x = false;
        this.f250100y = new Object();
        this.A = 0L;
        this.B = SystemClock.uptimeMillis();
        this.C = 0L;
        this.D = new com.tencent.mobileqq.msf.core.e0.g();
        this.E = new com.tencent.mobileqq.msf.core.e0.f();
        this.G = null;
        this.H = new AtomicBoolean();
        this.I = 0;
        this.J = 0L;
        this.K = 0L;
        this.L = 0L;
        this.M = false;
        this.N = new AtomicBoolean(true);
        this.f250091p = msfCore;
        this.f250092q = aVar;
        this.F = z16;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("mergehandle", 5);
        baseHandlerThread.start();
        Handler handler = new Handler(baseHandlerThread.getLooper());
        this.f250082g = handler;
        this.f250076a = new com.tencent.mobileqq.msf.core.net.o(msfCore, aVar, this, handler);
        cVar.setName(q.f249789d);
        this.f250090o = new a(z16);
    }

    private void B() {
        if (this.f250076a.l()) {
            if (f()) {
                ToServiceMsg toServiceMsg = new ToServiceMsg("", "0", BaseConstants.CMD_HEARTBEATALIVE);
                toServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
                toServiceMsg.setRequestSsoSeq(this.f250091p.getNextSeq());
                toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
                toServiceMsg.putWupBuffer(new byte[]{0, 0, 0, 4});
                toServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.x.e.o().f());
                g(toServiceMsg);
                this.I++;
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.NetConnTag." + this.F, 4, "send Heartbeat msg ok");
                }
                this.J = System.currentTimeMillis();
                this.H.set(true);
                return;
            }
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag." + this.F, 4, "conn is also closed.not need send heartbeat msg");
        }
        x();
    }

    static /* synthetic */ long i(t tVar) {
        long j3 = tVar.C;
        tVar.C = j3 - 1;
        return j3;
    }

    private void u() {
        try {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            while (threadGroup.getParent() != null) {
                threadGroup = threadGroup.getParent();
            }
            int activeCount = threadGroup.activeCount();
            Thread[] threadArr = new Thread[activeCount];
            threadGroup.enumerate(threadArr);
            int size = this.f250080e.size();
            boolean z16 = false;
            int i3 = 0;
            while (true) {
                if (i3 < activeCount) {
                    Thread thread = threadArr[i3];
                    if (thread != null && q.f249789d.equals(thread.getName())) {
                        z16 = true;
                        break;
                    }
                    i3++;
                } else {
                    break;
                }
            }
            QLog.d("MSF.C.NetConnTag." + this.F, 1, "sender alive:" + z16 + " size: " + size);
        } catch (Exception e16) {
            QLog.d("MSF.C.NetConnTag." + this.F, 1, "printCurrentThreads error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if ((BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() || !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion()) && this.L != 0 && this.N.compareAndSet(false, true)) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.L;
            this.L = 0L;
            QLog.d("MSF.C.NetConnTag." + this.F, 1, "reportFirstSendMsgTimeWhenBackToForce: usedT = ", Long.valueOf(elapsedRealtime));
            if (this.f250091p.statReporter != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("used_time", String.valueOf(elapsedRealtime));
                this.f250091p.statReporter.a("first_send_msg_time", true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
        }
    }

    private void x() {
        this.I = 0;
        this.H.set(false);
    }

    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            g(false);
        }
    }

    public void C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
            return;
        }
        com.tencent.mobileqq.msf.core.net.o oVar = this.f250076a;
        if (oVar != null && oVar.i() != null) {
            this.f250076a.i().w();
        }
    }

    public void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
            return;
        }
        this.M = false;
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag." + this.F, 2, "onAppBackground");
        }
    }

    public void t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
            return;
        }
        this.M = true;
        this.N.set(false);
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag." + this.F, 2, "onAppForeground");
        }
    }

    public void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else if (!com.tencent.mobileqq.msf.core.e0.i.f248008o.equals("0")) {
            this.f250091p.getAccountCenter().a(false);
        }
    }

    public void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            this.C = 0L;
        }
    }

    public void z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        QLog.d("MSF.C.NetConnTag." + p(), 1, "[revertSSOVersionChange], set old sso version");
        this.f250092q.s().s();
        CodecWarpper.nativeSetIsSupportNewSSO(false, p());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        return this.f250077b.isEmpty();
    }

    public void f(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            this.f250096u = i3;
        } else {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
    }

    public int g(ToServiceMsg toServiceMsg) {
        Runnable b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (toServiceMsg.getRequestSsoSeq() == -1) {
            toServiceMsg.setRequestSsoSeq(this.f250091p.getNextSeq());
        }
        toServiceMsg.addAttribute(BaseConstants.TIMESTAMP_ADDSENDQUEUE, Long.valueOf(System.currentTimeMillis()));
        if (toServiceMsg.isNeedCallback()) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag." + this.F, 2, "add " + toServiceMsg + " to send");
            }
            this.f250077b.put(Integer.valueOf(toServiceMsg.getRequestSsoSeq()), toServiceMsg);
            toServiceMsg.getAttributes().put(P, Integer.valueOf(R.incrementAndGet()));
            if (toServiceMsg.getTimeout() == -1) {
                toServiceMsg.setTimeout(30000L);
                b16 = this.f250092q.p().b(toServiceMsg, toServiceMsg.getTimeout(), this);
            } else {
                b16 = this.f250092q.p().b(toServiceMsg, toServiceMsg.getTimeout(), this);
            }
            toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_TIMEOUT_CALLBACKER, b16);
        }
        try {
            this.f250080e.addFirst(toServiceMsg);
            this.D.a(toServiceMsg);
            this.C++;
        } catch (Exception e16) {
            QLog.d("MSF.C.NetConnTag." + this.F, 1, "inset heartbeatMsg error. " + e16, e16);
        }
        return toServiceMsg.getRequestSsoSeq();
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 38)) {
            this.f250090o.nativeClearReceData();
        } else {
            iPatchRedirector.redirect((short) 38, (Object) this);
        }
    }

    public long i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) ? this.B : ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
    }

    public byte[] j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) ? this.G : (byte[]) iPatchRedirector.redirect((short) 19, (Object) this);
    }

    public String k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.f250094s : (String) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    public int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.f250095t : ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
    }

    public String m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f250093r : (String) iPatchRedirector.redirect((short) 3, (Object) this);
    }

    public int n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this.f250096u : ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
    }

    public long o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) ? this.C : ((Long) iPatchRedirector.redirect((short) 16, (Object) this)).longValue();
    }

    public boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? this.F : ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
    }

    public void r() {
        ToServiceMsg value;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this);
            return;
        }
        Iterator<Map.Entry<Integer, ToServiceMsg>> it = this.f250077b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, ToServiceMsg> next = it.next();
            if (next != null && (value = next.getValue()) != null && !this.f250080e.contains(value) && !value.isFirstPkgAfterConnOpen()) {
                boolean z16 = true;
                if (!value.isFastResendEnabled()) {
                    if (value.isSupportRetry()) {
                        QLog.d("MSF.C.NetConnTag.", 1, "send reteyMsg :" + value.getStringForLog());
                        this.f250080e.offer(value);
                    } else {
                        for (String str : BaseConstants.CMD_NeedResendCmds) {
                            if (value.getServiceCmd().equals(str)) {
                                break;
                            }
                        }
                    }
                    z16 = false;
                }
                if (z16) {
                    FromServiceMsg constructResponse = MsfSdkUtils.constructResponse(value, BaseConstants.CODE_RESENDMSG, "", null);
                    constructResponse.setBusinessFail(BaseConstants.CODE_RESENDMSG);
                    if (this.f250092q.q() != null && this.f250092q.q().d(value)) {
                        this.f250092q.q().b(value, constructResponse, -1);
                    }
                    this.f250091p.addRespToQuque(value, constructResponse);
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int d(ToServiceMsg toServiceMsg) {
        Runnable b16;
        if (toServiceMsg.isNeedCallback()) {
            this.f250077b.put(Integer.valueOf(toServiceMsg.getRequestSsoSeq()), toServiceMsg);
            toServiceMsg.getAttributes().put(P, Integer.valueOf(R.incrementAndGet()));
            if (toServiceMsg.getTimeout() == -1) {
                toServiceMsg.setTimeout(30000L);
                b16 = this.f250092q.p().b(toServiceMsg, toServiceMsg.getTimeout(), this);
            } else {
                b16 = this.f250092q.p().b(toServiceMsg, toServiceMsg.getTimeout(), this);
            }
            if ("LongConn.OffPicUp".equalsIgnoreCase(toServiceMsg.getServiceCmd()) || "ImgStore.GroupPicUp".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
                QLog.d("MSF.C.NetConnTag." + this.F, 1, "Sender PicUpMsg timer start, appSeq: " + toServiceMsg.getAppSeq() + ", delayMillis: " + toServiceMsg.getTimeout());
            }
            toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_TIMEOUT_CALLBACKER, b16);
            if (com.tencent.mobileqq.msf.core.x.e.o().a()) {
                long timeout = toServiceMsg.getTimeout() - com.tencent.mobileqq.msf.core.x.e.o().f();
                if (timeout > 0) {
                    toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_PREDETECT_TIMEOUT_CALLBACKER, this.f250092q.p().a(toServiceMsg, timeout, this));
                }
            }
            if (com.tencent.mobileqq.msf.core.x.b.e1() && this.f250092q.q() != null && this.f250092q.q().d(toServiceMsg)) {
                QLog.d("MSF.C.NetConnTag." + this.F, 1, "add quick send timeout check " + toServiceMsg.getRequestSsoSeq());
                if (this.f250076a.l() && this.f250076a.i() != null && this.f250076a.i().g() != null) {
                    toServiceMsg.getAttributes().put("connIDC", this.f250076a.i().g().f247936m);
                }
                this.f250092q.q().a(toServiceMsg);
                try {
                    this.f250092q.q().f249878j.a(toServiceMsg);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                }
            }
        } else if (toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_SSO_LOGIN_MERGE)) {
            this.f250092q.p().a(toServiceMsg.getRequestSsoSeq(), 30000L, this);
        }
        if (!this.f250080e.offer(toServiceMsg)) {
            QLog.d("MSF.C.NetConnTag." + this.F, 1, "error, add MSG: " + com.tencent.mobileqq.msf.core.z.a.b(toServiceMsg) + " to send queue is full! size: " + this.f250080e.size());
            if (!toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_SSO_LOGIN_MERGE)) {
                FromServiceMsg a16 = o.a(toServiceMsg);
                a16.setBusinessFail(1008, "send queue is full!");
                this.f250091p.addRespToQuque(toServiceMsg, a16);
            } else {
                ArrayList<ToServiceMsg> remove = this.f250079d.remove(Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
                if (remove != null) {
                    Iterator<ToServiceMsg> it = remove.iterator();
                    while (it.hasNext()) {
                        ToServiceMsg next = it.next();
                        FromServiceMsg a17 = o.a(next);
                        a17.setBusinessFail(1008, "send queue is full!");
                        this.f250091p.addRespToQuque(next, a17);
                    }
                }
            }
        } else {
            this.D.a(toServiceMsg);
            this.C++;
            this.f250079d.remove(Integer.valueOf(toServiceMsg.getRequestSsoSeq()));
            QLog.d("MSF.C.NetConnTag." + this.F, 1, "add Msg to sendQueue(" + this.f250080e.size() + "), MSG: " + com.tencent.mobileqq.msf.core.z.a.b(toServiceMsg));
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - this.A >= MiniBoxNoticeInfo.MIN_5) {
                this.A = elapsedRealtime;
                if (QLog.isColorLevel()) {
                    u();
                }
            }
        }
        if (!f250072d0.get() && LogManager.isScreenOn) {
            f250072d0.set(true);
            f250071c0 = toServiceMsg.getRequestSsoSeq();
        }
        return toServiceMsg.getRequestSsoSeq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ConcurrentHashMap<String, ConcurrentLinkedQueue<Integer>> e(boolean z16) {
        return z16 ? S : T;
    }

    private boolean f() {
        return !this.H.get() || System.currentTimeMillis() - this.J >= ((long) com.tencent.mobileqq.msf.core.x.e.o().g());
    }

    public void h(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (toServiceMsg == null || toServiceMsg.getMsfCommand() == MsfCommand.msf_ssoping || toServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive || toServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat) {
            return;
        }
        long longValue = toServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_MSF2NET) ? ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)).longValue() : 0L;
        if (longValue != 0 && longValue <= this.f250076a.i().n()) {
            QLog.d("MSF.C.NetConnTag." + this.F, 1, "preDetectTimeoutMsg return before connSucc.");
            return;
        }
        synchronized (this.H) {
            if (f()) {
                if (System.currentTimeMillis() - this.J > com.tencent.mobileqq.msf.core.x.e.o().i()) {
                    B();
                    QLog.d("MSF.C.NetConnTag." + this.F, 1, "preDetectTimeoutMsg cmd=" + com.tencent.mobileqq.msf.core.z.a.a(toServiceMsg.getServiceCmd()) + ", ssoSeq:" + toServiceMsg.getRequestSsoSeq());
                    if (this.f250091p.statReporter != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("param_preDetectUin", toServiceMsg.getUin());
                        hashMap.put("param_preDetectCmd", toServiceMsg.getServiceCmd());
                        hashMap.put("param_preDetectSsoseq", String.valueOf(toServiceMsg.getRequestSsoSeq()));
                        this.f250091p.statReporter.a("dim.Msf.PreDetectTimeoutMsg", true, 0L, 0L, (Map<String, String>) hashMap, false, false);
                    }
                } else {
                    QLog.d("MSF.C.NetConnTag." + this.F, 1, "notry preDetectTimeoutMsg cmd=" + com.tencent.mobileqq.msf.core.z.a.a(toServiceMsg.getServiceCmd()) + ", ssoSeq:" + toServiceMsg.getRequestSsoSeq());
                }
            }
        }
    }

    public void i(ToServiceMsg toServiceMsg) {
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) toServiceMsg);
            return;
        }
        if (toServiceMsg != null) {
            Runnable runnable2 = (Runnable) toServiceMsg.getAttributes().remove(MsfConstants.ATTRIBUTE_TIMEOUT_CALLBACKER);
            if (runnable2 != null) {
                this.f250092q.p().a().removeCallbacks(runnable2);
            }
            if (!com.tencent.mobileqq.msf.core.x.e.o().a() || (runnable = (Runnable) toServiceMsg.getAttributes().remove(MsfConstants.ATTRIBUTE_PREDETECT_TIMEOUT_CALLBACKER)) == null) {
                return;
            }
            this.f250092q.p().a().removeCallbacks(runnable);
        }
    }

    public void e(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            this.f250095t = i3;
        } else {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        }
    }

    public static void f(boolean z16) {
        Iterator<String> it = d(z16).iterator();
        while (it.hasNext()) {
            CodecWarpper.nativeSetUseSimpleHead(it.next(), false, z16);
        }
        d(z16).clear();
    }

    public byte[] e(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (byte[]) iPatchRedirector.redirect((short) 36, (Object) this, (Object) toServiceMsg);
        }
        if (toServiceMsg == null) {
            return null;
        }
        try {
            String serviceCmd = toServiceMsg.getServiceCmd();
            int indexOf = serviceCmd.indexOf("#");
            if (indexOf != -1) {
                serviceCmd = serviceCmd.substring(0, indexOf);
            }
            String str = serviceCmd;
            if (toServiceMsg.getWupBuffer() == null) {
                return new byte[0];
            }
            byte d16 = com.tencent.mobileqq.msf.core.net.k.d();
            byte activeNetIpFamily = (byte) NetConnInfoCenter.getActiveNetIpFamily(false);
            byte b16 = (byte) (f250069a0 ? activeNetIpFamily | 4 : activeNetIpFamily & (-5));
            d g16 = this.f250076a.i().g();
            byte[] b17 = b(toServiceMsg, str, d16, g16, p());
            byte[] c16 = c(toServiceMsg, str, d16, g16, p());
            f(p());
            byte[] j3 = j();
            byte[] wupBuffer = toServiceMsg.getWupBuffer();
            if (591 == CodecWarpper.getSharedObjectVersion()) {
                return CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", str, j3, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), d16, wupBuffer, false);
            }
            if (595 != CodecWarpper.getSharedObjectVersion() && 600 != CodecWarpper.getSharedObjectVersion()) {
                return CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", str, j3, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), d16, b16, b17, c16, wupBuffer, false);
            }
            return CodecWarpper.nativeEncodeRequest(toServiceMsg.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", str, j3, toServiceMsg.getAppId(), BaseApplication.getContext().getAppId(), toServiceMsg.getUin(), toServiceMsg.getUinType(), d16, b17, c16, wupBuffer, false);
        } catch (Throwable th5) {
            th5.printStackTrace();
            QLog.d("MSF.C.NetConnTag." + this.F, 1, "encode packet failed", th5);
            return new byte[0];
        }
    }

    static /* synthetic */ int b(t tVar, int i3) {
        int i16 = tVar.f250084i - i3;
        tVar.f250084i = i16;
        return i16;
    }

    public void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
            return;
        }
        try {
            if (this.f250076a.l() && this.f250076a.i() != null && this.f250076a.i().v() == i3) {
                g(true);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f250093r = str;
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
    }

    public void b(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            this.G = bArr;
        } else {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class c extends BaseThread {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        long f250104a;

        /* renamed from: b, reason: collision with root package name */
        private final com.tencent.mobileqq.msf.core.y.c f250105b;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements com.tencent.mobileqq.msf.core.y.c {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this);
                }
            }

            @Override // com.tencent.mobileqq.msf.core.y.c
            public void f() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Thread.State state = t.this.f250098w.getState();
                QLog.d("MSF.C.NetConnTag." + t.this.F, 1, "onAppForeground, MsfCoreMsgSender state = " + state);
                if (state == Thread.State.TIMED_WAITING) {
                    t.this.f250098w.interrupt();
                }
            }

            @Override // com.tencent.mobileqq.msf.core.y.c
            public void h() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this);
                }
            }
        }

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) t.this);
            } else {
                this.f250104a = 0L;
                this.f250105b = new a();
            }
        }

        private void a(String str, long j3, Throwable th5) {
            if (MsfService.getCore().getStatReporter() != null) {
                String simpleName = th5.getClass().getSimpleName();
                String message = th5.getMessage();
                HashMap hashMap = new HashMap();
                hashMap.put("account_uin", str);
                hashMap.put("sso_seq", String.valueOf(j3));
                hashMap.put("throwable_bean", simpleName);
                hashMap.put("throwable_msg", message);
                MsfService.getCore().getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.A3, false, 0L, 0L, (Map<String, String>) hashMap, true, false);
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(32:142|143|(4:145|146|147|(3:327|328|(2:330|(3:332|(4:334|335|336|337)|343)(1:344))))(1:349)|149|150|151|(6:161|(3:163|164|165)|166|167|168|169)|174|175|176|177|178|179|180|181|182|183|184|185|186|(7:299|300|301|302|303|304|(14:306|307|308|309|189|190|191|192|193|194|(9:268|269|270|271|272|273|(1:275)|276|277)(12:196|197|198|199|200|(5:251|252|254|255|256)(1:202)|203|(1:250)(1:207)|208|(3:236|(1:238)|239)|240|(3:242|(2:244|245)(1:247)|246))|248|249|246))|188|189|190|191|192|193|194|(0)(0)|248|249|246) */
        /* JADX WARN: Code restructure failed: missing block: B:286:0x07e0, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:287:0x07ed, code lost:
        
            r9 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:297:0x07e2, code lost:
        
            r0 = th;
         */
        /* JADX WARN: Code restructure failed: missing block: B:298:0x07e3, code lost:
        
            r27 = r14;
            r54 = r15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:352:0x05af, code lost:
        
            if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L366;
         */
        /* JADX WARN: Code restructure failed: missing block: B:356:0x05d9, code lost:
        
            com.tencent.qphone.base.util.QLog.d("MSF.C.NetConnTag." + r55.f250106c.F, 2, r10 + " is already sendTimeout,break.");
         */
        /* JADX WARN: Code restructure failed: missing block: B:358:0x05de, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:359:0x05df, code lost:
        
            r2 = r0;
            r14 = 2;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x0cc9, code lost:
        
            if (r55.f250106c.f250091p.mMsfMonitorCallback != null) goto L430;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0d00, code lost:
        
            if (r55.f250106c.f250091p.mMsfMonitorCallback != null) goto L430;
         */
        /* JADX WARN: Removed duplicated region for block: B:196:0x0939 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:238:0x0a6b A[Catch: all -> 0x0b5d, TryCatch #33 {all -> 0x0b5d, blocks: (B:200:0x0948, B:252:0x094e, B:255:0x095f, B:203:0x0986, B:205:0x098c, B:208:0x0997, B:210:0x09aa, B:212:0x09b4, B:214:0x09c1, B:216:0x09ce, B:218:0x09db, B:220:0x09e8, B:222:0x09f5, B:224:0x0a02, B:226:0x0a0f, B:228:0x0a1c, B:230:0x0a29, B:232:0x0a36, B:234:0x0a43, B:236:0x0a57, B:238:0x0a6b, B:239:0x0a81, B:240:0x0ae0, B:242:0x0ae8, B:244:0x0aed, B:260:0x097a, B:361:0x0b3b), top: B:199:0x0948 }] */
        /* JADX WARN: Removed duplicated region for block: B:242:0x0ae8 A[Catch: all -> 0x0b5d, TryCatch #33 {all -> 0x0b5d, blocks: (B:200:0x0948, B:252:0x094e, B:255:0x095f, B:203:0x0986, B:205:0x098c, B:208:0x0997, B:210:0x09aa, B:212:0x09b4, B:214:0x09c1, B:216:0x09ce, B:218:0x09db, B:220:0x09e8, B:222:0x09f5, B:224:0x0a02, B:226:0x0a0f, B:228:0x0a1c, B:230:0x0a29, B:232:0x0a36, B:234:0x0a43, B:236:0x0a57, B:238:0x0a6b, B:239:0x0a81, B:240:0x0ae0, B:242:0x0ae8, B:244:0x0aed, B:260:0x097a, B:361:0x0b3b), top: B:199:0x0948 }] */
        /* JADX WARN: Removed duplicated region for block: B:268:0x088d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0c8c  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0c9e A[Catch: all -> 0x0ccc, TryCatch #22 {all -> 0x0ccc, blocks: (B:67:0x0c24, B:69:0x0c2a, B:70:0x0c37, B:49:0x0c96, B:51:0x0c9e, B:53:0x0ca8, B:54:0x0cb4, B:75:0x0c5c), top: B:66:0x0c24 }] */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0cc1  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x0bbc A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:82:0x0cf8  */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        @SuppressLint({"NewApi"})
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String str;
            char c16;
            String str2;
            ToServiceMsg take;
            String str3;
            boolean z16;
            Throwable th5;
            String str4;
            String str5;
            long longValue;
            String str6;
            String str7;
            byte[] nativeEncodeRequest;
            boolean z17;
            ToServiceMsg toServiceMsg;
            String str8;
            Throwable th6;
            String str9;
            char c17;
            Exception exc;
            int i3;
            int i16;
            int i17;
            boolean z18;
            String str10 = BaseConstants.CMD_SSO_LOGIN_MERGE;
            String str11 = BaseConstants.ATTRIBUTE_SAMEDEVICE;
            IPatchRedirector iPatchRedirector = $redirector_;
            char c18 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            while (true) {
                try {
                    take = t.this.f250080e.take();
                    t.this.D.b(take);
                    if (t.this.f250091p != null && t.this.f250091p.mMsfMonitorCallback != null) {
                        t.this.f250091p.mMsfMonitorCallback.handleStart(1);
                    }
                } catch (Throwable th7) {
                    th = th7;
                    str = str11;
                    c16 = c18;
                    str2 = str10;
                }
                if (take != null) {
                    try {
                        com.tencent.mobileqq.msf.core.h0.c wakeUpLockManager = t.this.f250091p.getWakeUpLockManager();
                        if (wakeUpLockManager != null) {
                            wakeUpLockManager.a(take);
                        }
                        String serviceCmd = take.getServiceCmd();
                        int indexOf = serviceCmd.indexOf("#");
                        if (indexOf != -1) {
                            StringBuilder sb5 = new StringBuilder();
                            try {
                                sb5.append(serviceCmd.substring(indexOf + 1, serviceCmd.length()));
                                sb5.append("_new");
                                str5 = sb5.toString();
                                str4 = serviceCmd.substring(0, indexOf);
                            } catch (Throwable th8) {
                                th = th8;
                                str2 = str10;
                                str3 = str11;
                                z16 = false;
                                c16 = 2;
                                th5 = th;
                                try {
                                    QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th5.toString(), th5);
                                    a(take, "\u53d1\u9001\u9519\u8bef", th5.toString());
                                    t.this.f250080e.remove(take);
                                    t.i(t.this);
                                    if (take.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                                    }
                                    if (t.this.f250091p != null) {
                                    }
                                    LockMethodProxy.sleep(10L);
                                    if (t.this.f250091p != null) {
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    str = str3;
                                    Throwable th10 = th;
                                    try {
                                        QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th10.toString(), th10);
                                        if (t.this.f250091p != null) {
                                        }
                                        str11 = str;
                                        str10 = str2;
                                        c18 = c16;
                                    } finally {
                                    }
                                }
                                str11 = str;
                                str10 = str2;
                                c18 = c16;
                            }
                        } else {
                            str4 = serviceCmd;
                            str5 = null;
                        }
                        longValue = ((Long) take.getAttribute(BaseConstants.TIMESTAMP_ADDSENDQUEUE, 0L)).longValue();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (t.this.f250091p != null && t.this.f250091p.configManager != null) {
                            try {
                                t.this.f250091p.configManager.a(take.getUin(), currentTimeMillis);
                            } catch (Throwable th11) {
                                th = th11;
                                str2 = str10;
                                str3 = str11;
                                c16 = 2;
                                z16 = false;
                                th5 = th;
                                QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th5.toString(), th5);
                                a(take, "\u53d1\u9001\u9519\u8bef", th5.toString());
                                t.this.f250080e.remove(take);
                                t.i(t.this);
                                if (take.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                                }
                                if (t.this.f250091p != null) {
                                }
                                LockMethodProxy.sleep(10L);
                                if (t.this.f250091p != null) {
                                }
                                str11 = str;
                                str10 = str2;
                                c18 = c16;
                            }
                        }
                        if (t.this.f250092q != null && t.this.f250092q.s() != null) {
                            t.this.f250092q.s().a(take.getUin(), currentTimeMillis);
                        }
                        if (take.getWupBuffer() != null) {
                            try {
                                byte d16 = com.tencent.mobileqq.msf.core.net.k.d();
                                if (d16 == 0) {
                                    str6 = str5;
                                    long j3 = this.f250104a;
                                    if (j3 == 0 || currentTimeMillis - j3 > 60000) {
                                        this.f250104a = currentTimeMillis;
                                        try {
                                            NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
                                        } catch (Exception e16) {
                                            QLog.d("MSF.C.NetConnTag." + t.this.F, 1, "checkConnInfo " + e16);
                                        }
                                    }
                                } else {
                                    str6 = str5;
                                }
                                if (d16 != t.X) {
                                    int unused = t.X = d16;
                                    t.f(t.this.p());
                                    QLog.d("MSF.C.NetConnTag." + t.this.F, 1, "resetUserSimpleHead network type changed");
                                }
                                try {
                                    byte activeNetIpFamily = (byte) NetConnInfoCenter.getActiveNetIpFamily(false);
                                    byte b16 = (byte) (t.f250069a0 ? activeNetIpFamily | 4 : activeNetIpFamily & (-5));
                                    if (take.getUin().equals("0") && !com.tencent.mobileqq.msf.core.x.o.x().f().contains(take.getServiceCmd())) {
                                        if (QLog.isColorLevel()) {
                                            try {
                                                QLog.d("MSF.C.NetConnTag." + t.this.F, 2, "replace toServiceMsg uin, cmd  = " + take.getServiceCmd() + ", uin of toServiceMsg = " + take.getUin() + ", lastUseUin = " + com.tencent.mobileqq.msf.core.e0.i.i());
                                            } catch (Throwable th12) {
                                                th = th12;
                                                str2 = str10;
                                                str3 = str11;
                                                c16 = 2;
                                                z16 = false;
                                                th5 = th;
                                                QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th5.toString(), th5);
                                                a(take, "\u53d1\u9001\u9519\u8bef", th5.toString());
                                                t.this.f250080e.remove(take);
                                                t.i(t.this);
                                                if (take.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                                                }
                                                if (t.this.f250091p != null) {
                                                }
                                                LockMethodProxy.sleep(10L);
                                                if (t.this.f250091p != null) {
                                                }
                                                str11 = str;
                                                str10 = str2;
                                                c18 = c16;
                                            }
                                        }
                                        take.setUin(com.tencent.mobileqq.msf.core.e0.i.i());
                                    }
                                    if (com.tencent.mobileqq.msf.core.auth.d.f247429o.containsKey(take.getUin())) {
                                        t.this.f250091p.getAccountCenter().m(take.getUin());
                                        com.tencent.mobileqq.msf.core.auth.d.f247429o.remove(take.getUin());
                                        QLog.d("MSF.C.NetConnTag." + t.this.F, 1, "ReloadKey for uin:" + MsfSdkUtils.getShortUin(take.getUin()) + " while ssoSeq=" + take.getRequestSsoSeq());
                                    }
                                    if (!t.this.f250076a.l()) {
                                        t.f(t.this.p());
                                        QLog.d("MSF.C.NetConnTag." + t.this.F, 1, "resetUserSimpleHead not connect network");
                                    }
                                    if (!take.getUin().equals(com.tencent.mobileqq.msf.core.e0.i.f248008o) || com.tencent.mobileqq.msf.core.x.o.x().c().contains(take.getServiceCmd())) {
                                        try {
                                            t.a(take.getUin(), false, t.this.p());
                                        } catch (Throwable th13) {
                                            th = th13;
                                            str3 = str11;
                                            str2 = str10;
                                            z16 = false;
                                            c16 = 2;
                                            th5 = th;
                                            QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th5.toString(), th5);
                                            a(take, "\u53d1\u9001\u9519\u8bef", th5.toString());
                                            t.this.f250080e.remove(take);
                                            t.i(t.this);
                                            if (take.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                                            }
                                            if (t.this.f250091p != null) {
                                            }
                                            LockMethodProxy.sleep(10L);
                                            if (t.this.f250091p != null) {
                                            }
                                            str11 = str;
                                            str10 = str2;
                                            c18 = c16;
                                        }
                                    }
                                    d g16 = t.this.f250076a.i().g();
                                    byte[] b17 = t.b(take, str4, d16, g16, t.this.p());
                                    byte[] c19 = t.c(take, str4, d16, g16, t.this.p());
                                    if (b17 == null) {
                                        str3 = str11;
                                        try {
                                            QLog.d("MSF.C.NetConnTag." + t.this.p(), 1, "reserveField is null");
                                        } catch (Throwable th14) {
                                            th = th14;
                                            str2 = str10;
                                            c16 = 2;
                                            z16 = false;
                                            th5 = th;
                                            QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th5.toString(), th5);
                                            a(take, "\u53d1\u9001\u9519\u8bef", th5.toString());
                                            t.this.f250080e.remove(take);
                                            t.i(t.this);
                                            if (take.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                                            }
                                            if (t.this.f250091p != null) {
                                            }
                                            LockMethodProxy.sleep(10L);
                                            if (t.this.f250091p != null) {
                                            }
                                            str11 = str;
                                            str10 = str2;
                                            c18 = c16;
                                        }
                                    } else {
                                        str3 = str11;
                                    }
                                    if (c19 == null) {
                                        QLog.d("MSF.C.NetConnTag." + t.this.p(), 1, "reserveFieldWithQimei is null");
                                        t.this.f250091p.getStatReporter().e(t.this.F);
                                    }
                                    try {
                                        if (take.getWupBuffer() == null) {
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("cmd", take.getServiceCmd());
                                            if (t.this.f250091p.getStatReporter() != null) {
                                                t.this.f250091p.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247729p0, false, 0L, 0L, (Map<String, String>) hashMap, false, false);
                                            }
                                        }
                                        if (!t.V) {
                                            if (CodecWarpper.getSharedObjectVersion() != 780 && t.this.f250091p.getStatReporter() != null) {
                                                t.this.f250091p.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247734q0, false, 0L, 0L, (Map<String, String>) null, false, false);
                                            }
                                            boolean unused2 = t.V = true;
                                        }
                                        str7 = str10;
                                    } catch (Exception e17) {
                                        str7 = str10;
                                        QLog.d("MSF.C.NetConnTag." + t.this.F, 1, "failed to report send null msg event ", e17);
                                    }
                                    if (591 == CodecWarpper.getSharedObjectVersion()) {
                                        try {
                                            nativeEncodeRequest = CodecWarpper.nativeEncodeRequest(take.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", str4, t.this.j(), take.getAppId(), BaseApplication.getContext().getAppId(), take.getUin(), take.getUinType(), d16, take.getWupBuffer(), false);
                                        } catch (Throwable th15) {
                                            th5 = th15;
                                            str2 = str7;
                                            c16 = 2;
                                            z16 = false;
                                            QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th5.toString(), th5);
                                            a(take, "\u53d1\u9001\u9519\u8bef", th5.toString());
                                            t.this.f250080e.remove(take);
                                            t.i(t.this);
                                            if (take.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                                            }
                                            if (t.this.f250091p != null) {
                                            }
                                            LockMethodProxy.sleep(10L);
                                            if (t.this.f250091p != null) {
                                            }
                                            str11 = str;
                                            str10 = str2;
                                            c18 = c16;
                                        }
                                    } else {
                                        if (595 != CodecWarpper.getSharedObjectVersion() && 600 != CodecWarpper.getSharedObjectVersion()) {
                                            nativeEncodeRequest = CodecWarpper.nativeEncodeRequest(take.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", str4, t.this.j(), take.getAppId(), BaseApplication.getContext().getAppId(), take.getUin(), take.getUinType(), d16, b16, b17, c19, take.getWupBuffer(), false);
                                        }
                                        nativeEncodeRequest = CodecWarpper.nativeEncodeRequest(take.getRequestSsoSeq(), o.e(), o.g(), o.n(), "", str4, t.this.j(), take.getAppId(), BaseApplication.getContext().getAppId(), take.getUin(), take.getUinType(), d16, b17, c19, take.getWupBuffer(), false);
                                    }
                                    take.setSSOVersion(CodecWarpper.getCurrentSSOVersion(t.this.p()));
                                    if (nativeEncodeRequest != null) {
                                        take.getAttributes().put("reqPkgSize", Integer.valueOf(nativeEncodeRequest.length));
                                    }
                                    if (take.getRequestSsoSeq() == 0) {
                                        MsfCore.sCore.getStatReporter().a(true, take, (FromServiceMsg) null);
                                    }
                                } catch (Throwable th16) {
                                    th = th16;
                                    str3 = str11;
                                    str2 = str10;
                                    z16 = false;
                                }
                            } catch (Throwable th17) {
                                th = th17;
                                str3 = str11;
                            }
                        } else {
                            str7 = str10;
                            str3 = str11;
                            str6 = str5;
                            try {
                                nativeEncodeRequest = new byte[0];
                            } catch (Throwable th18) {
                                th = th18;
                                z16 = false;
                                str2 = str7;
                                c16 = 2;
                                th5 = th;
                                QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th5.toString(), th5);
                                a(take, "\u53d1\u9001\u9519\u8bef", th5.toString());
                                t.this.f250080e.remove(take);
                                t.i(t.this);
                                if (take.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                                }
                                if (t.this.f250091p != null) {
                                    t.this.f250091p.mMsfMonitorCallback.handleEnd(1);
                                }
                                LockMethodProxy.sleep(10L);
                                if (t.this.f250091p != null) {
                                }
                                str11 = str;
                                str10 = str2;
                                c18 = c16;
                            }
                        }
                    } catch (Throwable th19) {
                        th = th19;
                        str3 = str11;
                        z16 = false;
                        c16 = c18;
                        str2 = str10;
                    }
                    if (nativeEncodeRequest == null) {
                        QLog.w("MSF.C.NetConnTag." + t.this.F, 1, "send request body is null, " + take.getStringForLog());
                        t.this.d(take.getRequestSsoSeq());
                        if (t.this.f250091p == null || t.this.f250091p.mMsfMonitorCallback == null) {
                            str11 = str3;
                            str10 = str7;
                            c18 = 2;
                        } else {
                            str = str3;
                            str2 = str7;
                            c16 = 2;
                            t.this.f250091p.mMsfMonitorCallback.handleEnd(1);
                            str11 = str;
                            str10 = str2;
                            c18 = c16;
                        }
                    } else {
                        try {
                            if (!take.getUin().equals("0") && !((Boolean) take.getAttribute(com.tencent.mobileqq.msf.core.auth.b.f247387r, Boolean.FALSE)).booleanValue()) {
                                if (take.getAppId() != -1 && take.getAppId() != 100 && t.this.p()) {
                                    e.b().a(take);
                                }
                            }
                            z17 = false;
                        } catch (Throwable th20) {
                            th = th20;
                        }
                        while (true) {
                            if (z17) {
                                break;
                            }
                            long currentTimeMillis2 = System.currentTimeMillis();
                            if (currentTimeMillis2 - longValue > take.getTimeout()) {
                                break;
                            }
                            long j16 = t.f250070b0;
                            if (j16 != 0) {
                                toServiceMsg = take;
                                if (currentTimeMillis2 - j16 > com.tencent.mobileqq.msf.core.x.b.d0()) {
                                    try {
                                        if (t.this.f250076a.l()) {
                                            if (t.f250070b0 >= t.this.f250076a.i().n()) {
                                                t.f250070b0 = 0L;
                                                if (QLog.isColorLevel()) {
                                                    try {
                                                        QLog.d("MSF.C.NetConnTag." + t.this.F, 2, "lastMessageTimeTooLong closeConn lastMessageTimeTooLong. System.currentTimeMillis() - lastRecvSsoRespTime :" + (System.currentTimeMillis() - t.f250070b0) + " getNetIdleTimeInterval()" + com.tencent.mobileqq.msf.core.x.b.d0());
                                                    } catch (Throwable th21) {
                                                        th5 = th21;
                                                        c16 = 2;
                                                        take = toServiceMsg;
                                                    }
                                                }
                                                t.this.a(com.tencent.qphone.base.a.lastMessageTimeTooLong);
                                            } else {
                                                t.f250070b0 = 0L;
                                            }
                                        }
                                    } catch (Throwable th22) {
                                        th5 = th22;
                                        take = toServiceMsg;
                                        str2 = str7;
                                        c16 = 2;
                                        z16 = false;
                                        QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th5.toString(), th5);
                                        a(take, "\u53d1\u9001\u9519\u8bef", th5.toString());
                                        t.this.f250080e.remove(take);
                                        t.i(t.this);
                                        if (take.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                                        }
                                        if (t.this.f250091p != null) {
                                        }
                                        LockMethodProxy.sleep(10L);
                                        if (t.this.f250091p != null) {
                                        }
                                        str11 = str;
                                        str10 = str2;
                                        c18 = c16;
                                    }
                                }
                            } else {
                                toServiceMsg = take;
                            }
                            try {
                                long j17 = t.f250070b0;
                                if (j17 != 0 && currentTimeMillis2 - j17 > 360000 && t.this.f250076a.l() && t.f250070b0 >= t.this.f250076a.i().n() && !t.this.H.get()) {
                                    if (QLog.isColorLevel()) {
                                        QLog.d("MSF.C.NetConnTag." + t.this.F, 2, "no receive data for 5 minutes, start fast net detect now.");
                                    }
                                    try {
                                        t.this.g(false);
                                    } catch (Throwable th23) {
                                        th5 = th23;
                                        take = toServiceMsg;
                                        c16 = 2;
                                        z16 = false;
                                        str2 = str7;
                                        QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th5.toString(), th5);
                                        a(take, "\u53d1\u9001\u9519\u8bef", th5.toString());
                                        t.this.f250080e.remove(take);
                                        t.i(t.this);
                                        if (take.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                                        }
                                        if (t.this.f250091p != null) {
                                        }
                                        LockMethodProxy.sleep(10L);
                                        if (t.this.f250091p != null) {
                                        }
                                        str11 = str;
                                        str10 = str2;
                                        c18 = c16;
                                    }
                                }
                                take = toServiceMsg;
                                a(take);
                                try {
                                    take.addAttribute(BaseConstants.TIMESTAMP_MSF2NET_BOOT, Long.valueOf(SystemClock.elapsedRealtime()));
                                    take.addAttribute(BaseConstants.TIMESTAMP_MSF2NET, 0L);
                                    take.addAttribute(BaseConstants.Attribute_TAG_SOCKET_ADDRESS, t.this.f250093r);
                                    take.addAttribute(BaseConstants.ATTRIBUT_REQUEST_SENDTIME, Long.valueOf(System.currentTimeMillis()));
                                    take.addAttribute(BaseConstants.ATTRIBUT_REQUEST_SOCKET_CONN_TIME, Long.valueOf(t.this.f250076a.i().n()));
                                    take.addAttribute(BaseConstants.ATTRIBUT_REQUEST_NETSTATE, Integer.valueOf(NetConnInfoCenter.getActiveNetworkType()));
                                    take.addAttribute(BaseConstants.ATTRIBUT_REQUEST_ISCONN, Boolean.valueOf(t.this.f250076a.l()));
                                } catch (Throwable th24) {
                                    th = th24;
                                    str8 = str4;
                                    z16 = false;
                                }
                                if (t.this.M) {
                                    try {
                                        t.this.L = SystemClock.elapsedRealtime();
                                        try {
                                            t.this.M = false;
                                        } catch (Throwable th25) {
                                            th6 = th25;
                                            z16 = false;
                                        }
                                    } catch (Throwable th26) {
                                        th6 = th26;
                                        str8 = str4;
                                        z16 = false;
                                    }
                                    if (QLog.isColorLevel()) {
                                        String str12 = "MSF.C.NetConnTag." + t.this.F;
                                        Object[] objArr = new Object[2];
                                        z18 = false;
                                        try {
                                            objArr[0] = "set mFirstSendMsgTime = ";
                                            objArr[1] = Long.valueOf(t.this.L);
                                            QLog.d(str12, 2, objArr);
                                            z16 = z18;
                                            str8 = str4;
                                            z17 = t.this.f250076a.a(take.getAppId(), take.getAppSeq(), str4, str6, take.getMsfCommand(), take.getUin(), take.getRequestSsoSeq(), nativeEncodeRequest, take);
                                            t.this.B = SystemClock.uptimeMillis();
                                            c16 = 2;
                                        } catch (Throwable th27) {
                                            th6 = th27;
                                            z16 = false;
                                            str8 = str4;
                                            try {
                                                String str13 = "MSF.C.NetConnTag." + t.this.F;
                                                Object[] objArr2 = new Object[5];
                                                objArr2[z16 ? 1 : 0] = "send msg error, ssoSeq: " + take.getRequestSsoSeq();
                                                objArr2[1] = "current thread pid: " + Thread.currentThread().getId();
                                                c16 = 2;
                                                objArr2[2] = "socketEngineID: " + t.this.f250076a.j();
                                                objArr2[3] = "socket hashCode: " + t.this.f250076a.i().v();
                                                objArr2[4] = th6;
                                                QLog.d(str13, 1, objArr2);
                                                a(take.getUin(), (long) take.getRequestSsoSeq(), th6);
                                                if (z17) {
                                                }
                                                c17 = '\uffff';
                                                str7 = str2;
                                                str4 = str9;
                                            } catch (Throwable th28) {
                                                th = th28;
                                                str2 = str7;
                                                c16 = 2;
                                                th5 = th;
                                                QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th5.toString(), th5);
                                                a(take, "\u53d1\u9001\u9519\u8bef", th5.toString());
                                                t.this.f250080e.remove(take);
                                                t.i(t.this);
                                                if (take.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                                                }
                                                if (t.this.f250091p != null) {
                                                }
                                                LockMethodProxy.sleep(10L);
                                                if (t.this.f250091p != null) {
                                                }
                                                str11 = str;
                                                str10 = str2;
                                                c18 = c16;
                                            }
                                        }
                                        if (z17) {
                                            try {
                                                take.getAttributes().remove(BaseConstants.TIMESTAMP_MSF2NET_BOOT);
                                                take.getAttributes().remove(BaseConstants.TIMESTAMP_MSF2NET);
                                                take.getAttributes().remove(BaseConstants.Attribute_TAG_SOCKET_ADDRESS);
                                                take.getAttributes().put("_tag_senddata_error", Boolean.TRUE);
                                                QLog.d("MSF.C.NetConnTag.", 1, Thread.currentThread().getName() + " worker run closeConn writeError");
                                                t.this.a(com.tencent.qphone.base.a.writeError);
                                                try {
                                                    if (!com.tencent.mobileqq.msf.core.y.a.h().i()) {
                                                        QLog.d("MSF.C.NetConnTag." + t.this.F, 1, "start monitor foreground change before thread sleep");
                                                        com.tencent.mobileqq.msf.core.y.a.h().a(this.f250105b);
                                                    }
                                                    LockMethodProxy.sleep(BaseConstants.reSendIntrevTime);
                                                } catch (InterruptedException e18) {
                                                    com.tencent.mobileqq.msf.core.y.a.h().b(this.f250105b);
                                                    QLog.d("MSF.C.NetConnTag." + t.this.F, 1, "MsfCoreMsgSender sleep interrupted", e18);
                                                }
                                                str2 = str7;
                                                str9 = str8;
                                            } catch (Throwable th29) {
                                                th5 = th29;
                                                str2 = str7;
                                                QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th5.toString(), th5);
                                                a(take, "\u53d1\u9001\u9519\u8bef", th5.toString());
                                                t.this.f250080e.remove(take);
                                                t.i(t.this);
                                                if (take.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                                                }
                                                if (t.this.f250091p != null) {
                                                }
                                                LockMethodProxy.sleep(10L);
                                                if (t.this.f250091p != null) {
                                                }
                                                str11 = str;
                                                str10 = str2;
                                                c18 = c16;
                                            }
                                        } else {
                                            try {
                                                take.addAttribute(BaseConstants.TIMESTAMP_MSF2NET, Long.valueOf(System.currentTimeMillis()));
                                                str2 = str7;
                                                str9 = str8;
                                                try {
                                                    if (str2.equals(str9)) {
                                                        try {
                                                            i3 = ((Integer) take.getAttributes().get("mergeCount")).intValue();
                                                            try {
                                                                i17 = ((Integer) take.getAttributes().get("noRespCount")).intValue();
                                                                i16 = i3;
                                                            } catch (Exception e19) {
                                                                exc = e19;
                                                                exc.printStackTrace();
                                                                i16 = i3;
                                                                i17 = z16 ? 1 : 0;
                                                                d.d.c(str9, take.getRequestSsoSeq(), nativeEncodeRequest.length, i16, (!str2.equals(str9) || take.isNeedCallback()) ? i17 : 1);
                                                                if (take.getUin() != null) {
                                                                    if (t.e(t.this.p()).get(take.getUin()) == null) {
                                                                    }
                                                                    ((ConcurrentLinkedQueue) t.e(t.this.p()).get(take.getUin())).offer(Integer.valueOf(take.getRequestSsoSeq()));
                                                                    QLog.d("MSF.C.NetConnTag." + t.this.F, 1, "send Packet addQueue, ssoSeq=" + take.getRequestSsoSeq() + ", uin=" + MsfSdkUtils.getShortUin(take.getUin()));
                                                                }
                                                                if (com.tencent.mobileqq.msf.core.auth.b.f247389t.get()) {
                                                                }
                                                                c17 = '\uffff';
                                                                str7 = str2;
                                                                str4 = str9;
                                                            }
                                                        } catch (Exception e26) {
                                                            exc = e26;
                                                            i3 = z16 ? 1 : 0;
                                                        }
                                                    } else {
                                                        i17 = z16 ? 1 : 0;
                                                        i16 = i17;
                                                    }
                                                    d.d.c(str9, take.getRequestSsoSeq(), nativeEncodeRequest.length, i16, (!str2.equals(str9) || take.isNeedCallback()) ? i17 : 1);
                                                    if (take.getUin() != null && take.getUin().length() > 4 && !take.getServiceCmd().startsWith(BaseConstants.CMD_SA) && !take.getServiceCmd().startsWith(BaseConstants.CMD_SA_WT) && !take.getServiceCmd().equals("ConfigService.ClientReq") && !take.getServiceCmd().equals("ResourceConfig.ClientReq") && !take.getServiceCmd().equals("GrayUinPro.Check") && !take.getServiceCmd().equals(BaseConstants.CMD_WT_LOGIN_REQUESTREBINDMBL) && !take.getServiceCmd().equals(BaseConstants.CMD_WT_LOGIN_ADDCONTACTS) && !take.getServiceCmd().equals(BaseConstants.CMD_CONNAUTHSVR_GETAPPINFO) && !take.getServiceCmd().equals(BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI) && ((!take.getServiceCmd().equals(BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPILIST) || take.getServiceCmd().equals(BaseConstants.CMD_GRAY_APPLY)) && !t.d(t.this.p()).contains(take.getUin()))) {
                                                        if (t.e(t.this.p()).get(take.getUin()) == null) {
                                                            t.e(t.this.p()).put(take.getUin(), new ConcurrentLinkedQueue());
                                                        }
                                                        ((ConcurrentLinkedQueue) t.e(t.this.p()).get(take.getUin())).offer(Integer.valueOf(take.getRequestSsoSeq()));
                                                        QLog.d("MSF.C.NetConnTag." + t.this.F, 1, "send Packet addQueue, ssoSeq=" + take.getRequestSsoSeq() + ", uin=" + MsfSdkUtils.getShortUin(take.getUin()));
                                                    }
                                                    if (com.tencent.mobileqq.msf.core.auth.b.f247389t.get()) {
                                                        c17 = '\uffff';
                                                        if (com.tencent.mobileqq.msf.core.auth.b.f247388s == -1) {
                                                            com.tencent.mobileqq.msf.core.auth.b.f247388s = take.getRequestSsoSeq();
                                                            QLog.d("MSF.C.NetConnTag." + t.this.F, 1, "set afterReloadD2SendSeq " + com.tencent.mobileqq.msf.core.auth.b.f247388s);
                                                        }
                                                        str7 = str2;
                                                        str4 = str9;
                                                    }
                                                } catch (Throwable th30) {
                                                    th = th30;
                                                    th5 = th;
                                                    QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th5.toString(), th5);
                                                    a(take, "\u53d1\u9001\u9519\u8bef", th5.toString());
                                                    t.this.f250080e.remove(take);
                                                    t.i(t.this);
                                                    if (take.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                                                    }
                                                    if (t.this.f250091p != null) {
                                                    }
                                                    LockMethodProxy.sleep(10L);
                                                    if (t.this.f250091p != null) {
                                                    }
                                                    str11 = str;
                                                    str10 = str2;
                                                    c18 = c16;
                                                }
                                            } catch (Throwable th31) {
                                                th = th31;
                                                str2 = str7;
                                            }
                                        }
                                        c17 = '\uffff';
                                        str7 = str2;
                                        str4 = str9;
                                    }
                                }
                                z18 = false;
                                z16 = z18;
                                str8 = str4;
                                z17 = t.this.f250076a.a(take.getAppId(), take.getAppSeq(), str4, str6, take.getMsfCommand(), take.getUin(), take.getRequestSsoSeq(), nativeEncodeRequest, take);
                                t.this.B = SystemClock.uptimeMillis();
                                c16 = 2;
                                if (z17) {
                                }
                                c17 = '\uffff';
                                str7 = str2;
                                str4 = str9;
                            } catch (Throwable th32) {
                                th = th32;
                                take = toServiceMsg;
                                str2 = str7;
                                c16 = 2;
                                z16 = false;
                                th5 = th;
                                QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th5.toString(), th5);
                                a(take, "\u53d1\u9001\u9519\u8bef", th5.toString());
                                t.this.f250080e.remove(take);
                                t.i(t.this);
                                if (take.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                                }
                                if (t.this.f250091p != null) {
                                }
                                LockMethodProxy.sleep(10L);
                                if (t.this.f250091p != null) {
                                }
                                str11 = str;
                                str10 = str2;
                                c18 = c16;
                            }
                            str2 = str7;
                            z16 = false;
                            QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th5.toString(), th5);
                            a(take, "\u53d1\u9001\u9519\u8bef", th5.toString());
                            t.this.f250080e.remove(take);
                            t.i(t.this);
                            if (take.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                                try {
                                    FromServiceMsg fromServiceMsg = (FromServiceMsg) take.getAttribute(take.getServiceCmd());
                                    QLog.d("MSF.C.NetConnTag." + t.this.F, 1, Thread.currentThread().getName() + " kick setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(fromServiceMsg.getUin()));
                                    t.this.f250091p.getAccountCenter().n(fromServiceMsg.getUin());
                                    fromServiceMsg.setBusinessFail(2012, fromServiceMsg.getBusinessFailMsg());
                                    str = str3;
                                    try {
                                        try {
                                            fromServiceMsg.addAttribute(str, Boolean.valueOf(take.getAttributes().containsKey(str) ? ((Boolean) take.getAttribute(str)).booleanValue() : z16));
                                            MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                                            t.this.f250091p.addRespToQuque(null, fromServiceMsg);
                                            t.this.a(com.tencent.qphone.base.a.appCall);
                                        } catch (Throwable th33) {
                                            th = th33;
                                            Throwable th102 = th;
                                            QLog.d("MSF.C.NetConnTag." + t.this.F, 1, th102.toString(), th102);
                                            if (t.this.f250091p != null) {
                                            }
                                            str11 = str;
                                            str10 = str2;
                                            c18 = c16;
                                        }
                                    } catch (Exception e27) {
                                        e = e27;
                                        Exception exc2 = e;
                                        QLog.e("MSF.C.NetConnTag." + t.this.F, 1, "send offlineMsg to app error " + exc2.toString());
                                        if (t.this.f250091p != null) {
                                        }
                                        LockMethodProxy.sleep(10L);
                                        if (t.this.f250091p != null) {
                                        }
                                        str11 = str;
                                        str10 = str2;
                                        c18 = c16;
                                    }
                                } catch (Exception e28) {
                                    e = e28;
                                    str = str3;
                                }
                            } else {
                                str = str3;
                            }
                        }
                        str2 = str7;
                        c16 = 2;
                        z16 = false;
                        take.addAttribute(BaseConstants.ATTRIBUTE_SEND_BY_MAIN, Boolean.valueOf(t.this.p()));
                        t.this.f250092q.f().q(take);
                        t.this.D.c(take);
                        if (take.getMsfCommand() == MsfCommand._msf_kickedAndCleanTokenResp) {
                        }
                    }
                } else {
                    str = str11;
                    c16 = c18;
                    str2 = str10;
                }
                if (t.this.f250091p != null && t.this.f250091p.mMsfMonitorCallback != null) {
                    t.this.f250091p.mMsfMonitorCallback.handleEnd(1);
                }
                LockMethodProxy.sleep(10L);
                if (t.this.f250091p != null) {
                }
                str11 = str;
                str10 = str2;
                c18 = c16;
            }
        }

        private void a(ToServiceMsg toServiceMsg, String str, String str2) {
            t.this.d(toServiceMsg.getRequestSsoSeq());
        }

        private void a(@NonNull ToServiceMsg toServiceMsg) {
            if (t.this.f250076a.l() && t.this.f250092q.q() != null && com.tencent.mobileqq.msf.core.y.a.h().j()) {
                if (t.this.f250092q.q().a(2000L)) {
                    a(toServiceMsg, 1);
                    return;
                } else {
                    if (com.tencent.mobileqq.msf.core.y.a.h().e()) {
                        a(toServiceMsg, 2);
                        return;
                    }
                    return;
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag." + t.this.F, 2, "sendQuiHeartbeatWhenWakeFromDs, isConned = " + t.this.f250076a.l() + ", than return.");
            }
        }

        private void a(@NonNull ToServiceMsg toServiceMsg, int i3) {
            if (toServiceMsg.isSupportRetry()) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag." + t.this.F, 2, "sendQuiHeartbeatWhenWakeFromDs#setRetry, goCase = " + i3);
            }
            toServiceMsg.setIsSupportRetry(true);
            if (t.this.f250091p.getStatReporter() != null) {
                t.this.f250091p.getStatReporter().k();
            }
        }
    }

    public Runnable b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Runnable) iPatchRedirector.redirect((short) 23, (Object) this, i3);
        }
        long A = com.tencent.mobileqq.msf.core.x.b.A();
        if (A > 0) {
            return this.f250092q.p().b(i3, A, this);
        }
        c(i3);
        return null;
    }

    public void c(ToServiceMsg toServiceMsg) {
        Runnable b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, (Object) toServiceMsg);
            return;
        }
        this.f250077b.put(Integer.valueOf(toServiceMsg.getRequestSsoSeq()), toServiceMsg);
        toServiceMsg.getAttributes().put(P, Integer.valueOf(R.incrementAndGet()));
        if (toServiceMsg.getTimeout() == -1) {
            toServiceMsg.setTimeout(30000L);
            b16 = this.f250092q.p().b(toServiceMsg, toServiceMsg.getTimeout(), this);
        } else {
            b16 = this.f250092q.p().b(toServiceMsg, toServiceMsg.getTimeout(), this);
        }
        toServiceMsg.addAttribute(MsfConstants.ATTRIBUTE_TIMEOUT_CALLBACKER, b16);
    }

    static /* synthetic */ int a(t tVar, int i3) {
        int i16 = tVar.f250084i + i3;
        tVar.f250084i = i16;
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int f(ToServiceMsg toServiceMsg) {
        int i3 = toServiceMsg.getAttributes().containsKey(BaseConstants.TPS_TELEMETRY_TRACING_INFO) ? 2 : 0;
        if (toServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUTE_KEY_NT_KERNEL_FLAG)) {
            i3 |= 32;
        }
        String b16 = com.tencent.mobileqq.msf.core.e0.k.c().b();
        if (!BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() && !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && !TextUtils.isEmpty(b16)) {
            i3 |= 4;
        }
        return BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() ? i3 | 8 : i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int b(ToServiceMsg toServiceMsg) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Integer) iPatchRedirector.redirect((short) 27, (Object) this, (Object) toServiceMsg)).intValue();
        }
        if (toServiceMsg == null) {
            return -1;
        }
        if (this.f250091p.isSuspended()) {
            QLog.d("MSF.C.NetConnTag." + this.F, 1, "handleSsoFailCode, msfcore suspent");
            FromServiceMsg a16 = o.a(toServiceMsg);
            a16.setBusinessFail(2009, "MSF is suspeded.");
            this.f250091p.addRespToQuque(toServiceMsg, a16);
            return toServiceMsg.getRequestSsoSeq();
        }
        if (toServiceMsg.getWupBuffer() != null && toServiceMsg.getWupBuffer().length > 103424) {
            FromServiceMsg a17 = o.a(toServiceMsg);
            a17.setBusinessFail(2019, "check the wupbuf size in range[0, 101kb]");
            this.f250091p.addRespToQuque(toServiceMsg, a17);
            return toServiceMsg.getRequestSsoSeq();
        }
        CopyOnWriteArrayList<b.C8100b> copyOnWriteArrayList = this.f250091p.configManager.f250200e;
        if (copyOnWriteArrayList != null) {
            Iterator<b.C8100b> it = copyOnWriteArrayList.iterator();
            b.C8100b c8100b = null;
            while (it.hasNext()) {
                c8100b = it.next();
                if (c8100b.f250201a + c8100b.f250202b.f25188b < System.currentTimeMillis() / 1000) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag." + this.F, 2, "OverloadPushNotify item expired sCmd = " + c8100b.f250203c);
                    }
                    this.f250091p.configManager.f250200e.remove(c8100b);
                } else {
                    String serviceCmd = toServiceMsg.getServiceCmd();
                    String str = c8100b.f250203c;
                    if (str.charAt(str.length() - 1) == '*') {
                        String str2 = c8100b.f250203c;
                        if (serviceCmd.startsWith(str2.substring(0, str2.length() - 1))) {
                            if (QLog.isColorLevel()) {
                                QLog.d("MSF.C.NetConnTag." + this.F, 2, "OverloadPushNotify item matched strServiceCmd = " + serviceCmd + " sCmd:" + c8100b.f250203c);
                            }
                            z16 = true;
                        }
                    } else if (c8100b.f250203c.equals(serviceCmd)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("MSF.C.NetConnTag." + this.F, 2, "OverloadPushNotify item matched strServiceCmd = " + serviceCmd + " sCmd:" + c8100b.f250203c);
                        }
                        z16 = true;
                    }
                    if (z16 && c8100b != null) {
                        if (c8100b.f250202b.f25191e == 1) {
                            FromServiceMsg fromServiceMsg = new FromServiceMsg();
                            fromServiceMsg.setUin("0");
                            fromServiceMsg.setServiceCmd(BaseConstants.CMD_OVER_LOAD_PUSH_NOTIFY);
                            fromServiceMsg.setMsfCommand(MsfCommand.onOverloadPushNotify);
                            fromServiceMsg.setAppId(BaseApplication.getContext().getAppId());
                            fromServiceMsg.setMsgSuccess();
                            fromServiceMsg.setRequestSsoSeq(this.f250091p.getNextSeq());
                            MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
                            fromServiceMsg.getAttributes().put("msg", new String(c8100b.f250202b.f25190d));
                            this.f250091p.addRespToQuque(null, fromServiceMsg);
                            c8100b.f250202b.f25191e = (byte) 0;
                        }
                        FromServiceMsg a18 = o.a(toServiceMsg);
                        a.a.b.a.a.d.a aVar = c8100b.f250202b;
                        a18.setBusinessFail(aVar.f25189c, new String(aVar.f25190d));
                        this.f250091p.addRespToQuque(toServiceMsg, a18);
                        if (QLog.isColorLevel()) {
                            QLog.d("MSF.C.NetConnTag." + this.F, 2, "OverloadPushNotify server overload block tomsg: " + toServiceMsg + " frommsg: " + a18);
                        }
                        return toServiceMsg.getRequestSsoSeq();
                    }
                }
            }
            z16 = false;
            if (z16) {
                if (c8100b.f250202b.f25191e == 1) {
                }
                FromServiceMsg a182 = o.a(toServiceMsg);
                a.a.b.a.a.d.a aVar2 = c8100b.f250202b;
                a182.setBusinessFail(aVar2.f25189c, new String(aVar2.f25190d));
                this.f250091p.addRespToQuque(toServiceMsg, a182);
                if (QLog.isColorLevel()) {
                }
                return toServiceMsg.getRequestSsoSeq();
            }
        }
        if (toServiceMsg.getAppId() <= 0 && toServiceMsg.getMsfCommand() != MsfCommand.openConn && (TextUtils.isEmpty(toServiceMsg.getServiceCmd()) || !toServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_SA_WT))) {
            FromServiceMsg a19 = o.a(toServiceMsg);
            a19.setBusinessFail(1007, "msg appid is " + toServiceMsg.getAppId());
            this.f250091p.addRespToQuque(toServiceMsg, a19);
            return toServiceMsg.getRequestSsoSeq();
        }
        if (f250075g0.get()) {
            FromServiceMsg a26 = o.a(toServiceMsg);
            a26.setBusinessFail(2014, "error");
            this.f250091p.addRespToQuque(toServiceMsg, a26);
            return toServiceMsg.getRequestSsoSeq();
        }
        GrayUinCheckResp grayUinCheckResp = u.f250109g.get(toServiceMsg.getUin());
        if (grayUinCheckResp != null && toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_WT_LOGIN_AUTH)) {
            e.b().a().remove(toServiceMsg.getUin());
            u.f250109g.remove(toServiceMsg.getUin());
            grayUinCheckResp = null;
        }
        if (grayUinCheckResp != null && !toServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_SA) && !toServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_WT_LOGIN_AUTH) && !toServiceMsg.getServiceCmd().equals("GrayUinPro.Check") && !toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_GRAY_APPLY)) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag." + this.F, 2, "error, " + toServiceMsg.getUin() + " not in gray list");
            }
            FromServiceMsg a27 = o.a(toServiceMsg);
            try {
                a27.setBusinessFail(2008, new String(grayUinCheckResp.err_msg, "UTF-8"));
            } catch (Exception unused) {
                a27.setBusinessFail(2008, toServiceMsg.getUin() + " not in gray list");
            }
            a27.addAttribute(a27.getServiceCmd(), String.valueOf(grayUinCheckResp.is_yingyongbao));
            this.f250091p.addRespToQuque(toServiceMsg, a27);
            if (this.f250091p.getAccountCenter().k(a27.getUin())) {
                QLog.d("MSF.C.NetConnTag." + this.F, 1, Thread.currentThread().getName() + " addSendQueue setAccountNoLogin uin=" + MsfSdkUtils.getShortUin(a27.getUin()));
                this.f250091p.getAccountCenter().n(a27.getUin());
            }
            return toServiceMsg.getRequestSsoSeq();
        }
        com.tencent.mobileqq.msf.core.g0.a aVar3 = this.f250091p.standbyModeManager;
        if (aVar3 != null && aVar3.i()) {
            if (!this.f250091p.standbyModeManager.c(toServiceMsg.getServiceCmd())) {
                QLog.d("MSF.C.NetConnTag." + this.F, 1, "refuse to send request cmd: " + toServiceMsg.getServiceCmd() + " ssoseq: " + toServiceMsg.getRequestSsoSeq() + " by standbyMode");
                this.f250091p.getStandByModeManager().b(toServiceMsg);
                FromServiceMsg a28 = o.a(toServiceMsg);
                a28.setBusinessFail(2018, "standby mode force stop request");
                this.f250091p.addRespToQuque(toServiceMsg, a28);
                if (!this.f250076a.l()) {
                    ToServiceMsg connOpenMsg = MsfMsgUtil.getConnOpenMsg("");
                    MsfSdkUtils.addToMsgProcessName("", connOpenMsg);
                    this.f250091p.sendSsoMsg(connOpenMsg);
                }
                return toServiceMsg.getRequestSsoSeq();
            }
            this.f250091p.getStandByModeManager().a(toServiceMsg);
        }
        CodecWarpper.nativeGetFileStoreKey();
        String i3 = this.f250091p.getAccountCenter().i(toServiceMsg.getUin());
        if (i3 != null) {
            toServiceMsg.setUin(i3);
        }
        if (!toServiceMsg.getUin().equals("0") && !com.tencent.mobileqq.msf.core.e0.i.f248008o.equals(toServiceMsg.getUin()) && MsfSdkUtils.isUinLong(toServiceMsg.getUin())) {
            QLog.d("MSF.C.NetConnTag." + this.F, 1, "setLastUseUin from=" + MsfSdkUtils.getShortUin(com.tencent.mobileqq.msf.core.e0.i.f248008o) + " to=" + MsfSdkUtils.getShortUin(toServiceMsg.getUin()));
            com.tencent.mobileqq.msf.core.e0.i.f248008o = toServiceMsg.getUin();
        }
        if (toServiceMsg.getRequestSsoSeq() == -1) {
            toServiceMsg.setRequestSsoSeq(this.f250091p.getNextSeq());
        }
        if (!toServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_APP2MSF)) {
            toServiceMsg.addAttribute(BaseConstants.TIMESTAMP_APP2MSF, Long.valueOf(System.currentTimeMillis()));
        }
        toServiceMsg.addAttribute(BaseConstants.TIMESTAMP_ADDSENDQUEUE, Long.valueOf(System.currentTimeMillis()));
        if (!this.f250086k && this.f250087l) {
            this.f250085j = SystemClock.elapsedRealtime();
            this.f250086k = true;
        }
        if (toServiceMsg.getServiceCmd().equals(BaseConstants.CMD_NT_PUSH_REGISTER) && toServiceMsg.getMsfCommand().equals(MsfCommand._msf_RegPush) && this.f250087l) {
            this.f250085j = SystemClock.elapsedRealtime();
            this.f250086k = true;
            String[] V2 = com.tencent.mobileqq.msf.core.x.b.V();
            if (V2 != null && com.tencent.mobileqq.msf.core.x.o.x().e().size() != V2.length) {
                com.tencent.mobileqq.msf.core.x.o.x().a(V2);
            } else if (V2 == null) {
                com.tencent.mobileqq.msf.core.x.o.x().a(null);
            }
        }
        if (a(toServiceMsg.getUin(), toServiceMsg.getServiceCmd())) {
            boolean c16 = m.i().c();
            this.f250091p.getStatReporter().a(toServiceMsg.getServiceCmd(), toServiceMsg.getUin(), c16);
            if (c16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + this.F, 2, "block cmd:" + toServiceMsg.getServiceCmd() + " because of no login\n toServiceMsg uin = " + toServiceMsg.getUin());
                } else {
                    QLog.d("MSF.C.NetConnTag." + this.F, 1, "block cmd=" + com.tencent.mobileqq.msf.core.z.a.a(toServiceMsg.getServiceCmd()) + " because of no login\n toServiceMsg uin = " + MsfSdkUtils.getShortUin(toServiceMsg.getUin()));
                }
                FromServiceMsg a29 = o.a(toServiceMsg);
                a29.setBusinessFail(BaseConstants.CODE_SEND_WITH_NO_AUTH_ERROR, "cmd is not in noLoginWhiteList");
                this.f250091p.addRespToQuque(toServiceMsg, a29);
                return toServiceMsg.getRequestSsoSeq();
            }
        }
        if (this.f250087l && SystemClock.elapsedRealtime() - this.f250085j < com.tencent.mobileqq.msf.core.x.h.g().e()) {
            if (com.tencent.mobileqq.msf.core.x.o.x().e().size() == 0) {
                com.tencent.mobileqq.msf.core.x.o.x().a(null);
            }
            if (!com.tencent.mobileqq.msf.core.x.o.x().e().contains(toServiceMsg.getServiceCmd()) && ((TextUtils.isEmpty(toServiceMsg.getServiceCmd()) || !toServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_SA_WT)) && ((!BaseConstants.CMD_REQUEST_CONFIG.equals(toServiceMsg.getServiceCmd()) || !((Boolean) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_DISABLE_MERGE, Boolean.FALSE)).booleanValue()) && ((com.tencent.mobileqq.msf.core.x.m.g() || !toServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUTE_KEY_NT_KERNEL_FLAG)) && !com.tencent.mobileqq.msf.core.d0.a.c().a(toServiceMsg.getServiceCmd()))))) {
                this.f250101z = SystemClock.elapsedRealtime();
                this.f250081f.add(toServiceMsg);
                int length = toServiceMsg.getWupBuffer().length;
                synchronized (this.f250100y) {
                    this.f250084i += length;
                    if (!this.f250099x) {
                        this.f250082g.postDelayed(this.f250083h, com.tencent.mobileqq.msf.core.x.h.g().c());
                        this.f250099x = true;
                    }
                }
                String serviceCmd2 = toServiceMsg.getServiceCmd();
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + this.F, 2, "add Msg to delayWaitSendList, ssoSeq: " + toServiceMsg.getRequestSsoSeq() + " cmd: " + serviceCmd2 + " uin: " + toServiceMsg.getUin() + " len: " + toServiceMsg.getWupBuffer().length);
                } else {
                    QLog.d("MSF.C.NetConnTag." + this.F, 1, "add Msg to delayWaitSendList, ssoSeq: " + toServiceMsg.getRequestSsoSeq() + " cmd= " + com.tencent.mobileqq.msf.core.z.a.a(serviceCmd2) + " uin: " + MsfSdkUtils.getShortUin(toServiceMsg.getUin()) + " len: " + toServiceMsg.getWupBuffer().length);
                }
                return toServiceMsg.getRequestSsoSeq();
            }
            return d(toServiceMsg);
        }
        return d(toServiceMsg);
    }

    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            this.f250094s = str;
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
    }

    public boolean a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) context)).booleanValue();
        }
        try {
            if (com.tencent.mobileqq.msf.core.x.b.d()) {
                this.f250097v = new com.tencent.mobileqq.msf.core.net.r.f(context);
                com.tencent.mobileqq.msf.core.e0.i.f248005l = true;
            }
        } catch (Throwable th5) {
            QLog.d("MSF.C.NetConnTag." + this.F, 1, "init socketAdaptorfactory failed", th5);
        }
        try {
            this.f250090o.init(context, !BaseApplication.getContext().getMSFInterfaceAdapter().isReleaseVersion(), this.F);
        } catch (UnsatisfiedLinkError e16) {
            com.tencent.mobileqq.msf.core.c0.j.a("codecwrapperV2", CodecWarpper.isLoaded, CodecWarpper.soLoadResultCode, e16.getMessage());
        }
        CodecWarpper.nativeSetKsid(this.f250091p.getAccountCenter().d());
        CodecWarpper.nativeInitNoLoginWhiteList(com.tencent.mobileqq.msf.core.x.o.x().f());
        this.f250091p.getAccountCenter().j();
        CodecWarpper.nativeSetNoLoginWithNoAccountInfoSwitch(com.tencent.mobileqq.msf.core.x.m.h());
        this.f250098w.start();
        if (p()) {
            if (!BaseApplication.getContext().getMSFInterfaceAdapter().isReleaseVersion()) {
                boolean z16 = BaseApplication.getContext().getSharedPreferences("mobileQQ", 4).getBoolean(Q, false);
                if (z16) {
                    l.a(this);
                }
                QLog.d("MSF.C.NetConnTag.", 1, "Start msf debug monitor queues: " + z16);
            }
            l.b(this);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static byte[] c(ToServiceMsg toServiceMsg, String str, int i3, d dVar, boolean z16) {
        if (TextUtils.isEmpty(o.k())) {
            QLog.d("MSF.C.NetConnTag.", 1, "[buildReserveFiledWithQimei] qimei is null.");
            return null;
        }
        SSOReserveField.ReserveFields a16 = a(toServiceMsg, str, dVar != null ? dVar.c() : 1, i3, z16);
        if (a16 == null) {
            a16 = new SSOReserveField.ReserveFields();
        }
        a16.qimei.set(ByteStringMicro.copyFrom(o.k().getBytes()));
        if (TextUtils.isEmpty(o.g())) {
            a16.imsi.set(0);
        } else {
            try {
                a16.imsi.set(Integer.parseInt(o.g()));
            } catch (Exception e16) {
                a16.imsi.set(0);
                QLog.e("MSF.C.NetConnTag." + z16, 1, "parse imsi failed, ", e16);
            }
        }
        a16.newconn_flag.set(!z16 ? 1 : 0);
        if (dVar != null) {
            a16.sso_ip_origin.set(dVar.a());
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("buildReserveFiled nt_core_version:");
            sb5.append(a16.nt_core_version.get());
            sb5.append(" networkType:");
            sb5.append(a16.network_type.get());
            sb5.append(" activeIpFamily:");
            sb5.append(a16.ip_stack_type.get());
            sb5.append(" sso_ip_origin:");
            sb5.append(a16.sso_ip_origin.get());
            sb5.append(" flag:");
            sb5.append(a16.flag.get());
            sb5.append(" message_type:");
            sb5.append(a16.message_type.get());
            sb5.append(", uid: ");
            sb5.append(a16.uid.get());
            sb5.append(" of the uin:");
            sb5.append(MsfSdkUtils.getShortUin(toServiceMsg.getUin()));
            sb5.append(", trace info:");
            sb5.append(a16.trace_parent.get());
            QLog.d("MSF.C.NetConnTag." + z16, 2, sb5.toString());
        }
        return a16.toByteArray();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(boolean z16) {
        if (this.f250076a.l()) {
            if (f()) {
                ToServiceMsg toServiceMsg = new ToServiceMsg("", "0", BaseConstants.CMD_HEARTBEATALIVE);
                toServiceMsg.setMsfCommand(MsfCommand._msf_HeartbeatAlive);
                toServiceMsg.setRequestSsoSeq(this.f250091p.getNextSeq());
                toServiceMsg.setAppId(BaseApplication.getContext().getAppId());
                toServiceMsg.putWupBuffer(new byte[]{0, 0, 0, 4});
                if (z16) {
                    toServiceMsg.setTimeout(com.tencent.mobileqq.msf.core.x.b.B());
                } else {
                    toServiceMsg.setTimeout(10000L);
                }
                g(toServiceMsg);
                this.I = com.tencent.mobileqq.msf.core.x.e.o().c();
                if (QLog.isDevelopLevel()) {
                    QLog.d("MSF.C.NetConnTag." + this.F, 4, "send fast net detect Heartbeat msg ok");
                }
                if (!z16 || com.tencent.mobileqq.msf.core.x.b.U0()) {
                    this.J = System.currentTimeMillis();
                    if (QLog.isDevelopLevel()) {
                        QLog.d("MSF.C.NetConnTag." + this.F, 1, "Update send heartbeat time: " + this.J);
                    }
                }
                this.H.set(true);
                return;
            }
            QLog.d("MSF.C.NetConnTag." + this.F, 4, "conn is also closed.not need send heartbeat msg");
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("MSF.C.NetConnTag." + this.F, 4, "conn is also closed.not need send heartbeat msg");
        }
        x();
    }

    public void a(com.tencent.mobileqq.msf.core.e0.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            this.D.a((com.tencent.mobileqq.msf.core.e0.g) eVar);
        } else {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) eVar);
        }
    }

    public void a(com.tencent.mobileqq.msf.core.e0.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 14)) {
            this.E.a(dVar);
        } else {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) dVar);
        }
    }

    public boolean a(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        boolean z16;
        String uin;
        com.tencent.mobileqq.msf.core.c0.j jVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this, (Object) toServiceMsg, (Object) fromServiceMsg)).booleanValue();
        }
        if (toServiceMsg == null) {
            return false;
        }
        if (toServiceMsg.getMsfCommand() == MsfCommand.msf_ssoping) {
            this.f250076a.i().x();
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag." + this.F, 2, Thread.currentThread().getName() + " onFoundTimeoutMsg closeConn closeBySSOPingTimeout");
            }
            a(com.tencent.qphone.base.a.closeBySSOPingTimeout);
            return false;
        }
        if (toServiceMsg.getMsfCommand() == MsfCommand.msf_oshello) {
            QLog.d("MSF.C.NetConnTag." + this.F, 1, "cannot get os hello response");
            return false;
        }
        try {
            int activeNetworkType = NetConnInfoCenter.getActiveNetworkType();
            long n3 = this.f250076a.i().n();
            boolean l3 = this.f250076a.l();
            long longValue = toServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUT_REQUEST_SENDTIME) ? ((Long) toServiceMsg.getAttribute(BaseConstants.ATTRIBUT_REQUEST_SENDTIME)).longValue() : 0L;
            long longValue2 = toServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUT_REQUEST_SOCKET_CONN_TIME) ? ((Long) toServiceMsg.getAttribute(BaseConstants.ATTRIBUT_REQUEST_SOCKET_CONN_TIME)).longValue() : 0L;
            int intValue = toServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUT_REQUEST_NETSTATE) ? ((Integer) toServiceMsg.getAttribute(BaseConstants.ATTRIBUT_REQUEST_NETSTATE)).intValue() : 0;
            boolean booleanValue = toServiceMsg.getAttributes().containsKey(BaseConstants.ATTRIBUT_REQUEST_ISCONN) ? ((Boolean) toServiceMsg.getAttribute(BaseConstants.ATTRIBUT_REQUEST_ISCONN)).booleanValue() : false;
            if (this.f250091p.statReporter != null) {
                HashMap hashMap = new HashMap();
                hashMap.put(BaseConstants.ATTRIBUT_REQUEST_SENDTIME, "" + longValue);
                hashMap.put(BaseConstants.ATTRIBUT_REQUEST_SOCKET_CONN_TIME, "" + longValue2);
                hashMap.put(BaseConstants.ATTRIBUT_REQUEST_NETSTATE, "" + intValue);
                hashMap.put(BaseConstants.ATTRIBUT_REQUEST_ISCONN, "" + booleanValue);
                hashMap.put(BaseConstants.ATTRIBUT_TIMEOUT_NETSTATE, "" + activeNetworkType);
                hashMap.put(BaseConstants.ATTRIBUT_TIMEOUT_ISCONN, "" + l3);
                hashMap.put(BaseConstants.ATTRIBUT_TIMEOUT_SOCKET_CONN_TIME, "" + n3);
                this.f250091p.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.f247780z3, false, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
        } catch (Exception e16) {
            QLog.e("MSF.C.NetConnTag." + this.F + this.F, 1, "report 1002 failed", e16);
        }
        if (toServiceMsg.isNeedRemindSlowNetwork()) {
            com.tencent.mobileqq.msf.core.net.l.a(l.b.f248789a);
        }
        toServiceMsg.addAttribute(BaseConstants.Attribute_TAG_SOCKET_CONNERROR, com.tencent.mobileqq.msf.core.net.o.W);
        fromServiceMsg.addAttribute(BaseConstants.Attribute_TAG_SOCKET_CONNERROR, com.tencent.mobileqq.msf.core.net.o.W);
        if (toServiceMsg.getAttributes().containsKey(BaseConstants.Attribute_TAG_SOCKET_ADDRESS)) {
            fromServiceMsg.addAttribute(BaseConstants.Attribute_TAG_SOCKET_ADDRESS, toServiceMsg.getAttribute(BaseConstants.Attribute_TAG_SOCKET_ADDRESS));
        }
        if (com.tencent.mobileqq.msf.core.e0.i.f248005l && com.tencent.mobileqq.msf.core.net.r.f.f()) {
            try {
                this.f250097v.b().b(toServiceMsg.getRequestSsoSeq(), true);
            } catch (Exception e17) {
                QLog.d("MSF.C.NetConnTag." + this.F, 1, "adaptor recv timeout failed", e17);
            }
        }
        long longValue3 = toServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_MSF2NET) ? ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)).longValue() : 0L;
        long currentTimeMillis = System.currentTimeMillis();
        long longValue4 = toServiceMsg.getAttributes().containsKey(BaseConstants.TIMESTAMP_ADDSENDQUEUE) ? ((Long) toServiceMsg.getAttribute(BaseConstants.TIMESTAMP_ADDSENDQUEUE)).longValue() : 0L;
        try {
            if (toServiceMsg.getServiceCmd().equals("MessageSvc.PbGetMsg") && (jVar = this.f250091p.statReporter) != null) {
                jVar.a(com.tencent.mobileqq.msf.core.c0.g.N0, false, 0L, 0L, (Map<String, String>) null, false, false);
            }
        } catch (Exception e18) {
            QLog.d("MSF.C.NetConnTag." + this.F, 1, "", e18);
        }
        try {
            if (toServiceMsg.getServiceCmd() == com.tencent.mobileqq.msf.core.push.g.f249697z) {
                long longValue5 = ((Long) toServiceMsg.getAttribute(BaseConstants.ATTRIBUTE_ALARM_ELAPSED_TIEM, 0L)).longValue();
                if (com.tencent.mobileqq.msf.core.x.b.f250194y && longValue5 > com.tencent.mobileqq.msf.core.x.b.m0() && longValue4 >= this.f250076a.i().n() && (uin = toServiceMsg.getUin()) != null) {
                    if (com.tencent.mobileqq.msf.core.x.b.f250195z && Long.parseLong(uin) % 2 != 0) {
                        this.f250091p.pushManager.A = SystemClock.elapsedRealtime();
                        QLog.d("MSF.C.NetConnTag." + this.F, 1, "wakeup alarm exceeded and detect timeout, but not close conn");
                    }
                    QLog.d("MSF.C.NetConnTag." + this.F, 1, "try close conn by wakeup alarm exceeded and detect timeout:" + longValue5);
                    a(com.tencent.qphone.base.a.closeByAlarmSimpleGetTimeout);
                    if (this.f250091p.getStatReporter() == null) {
                        return false;
                    }
                    this.f250091p.getStatReporter().a("3", uin, true, 0L);
                    return false;
                }
            }
        } catch (Exception e19) {
            QLog.d("MSF.C.NetConnTag." + this.F, 1, "SimpleGet timeout error!", e19);
        }
        if (longValue4 != 0) {
            long j3 = currentTimeMillis - longValue4;
            if (j3 > toServiceMsg.getTimeout() && j3 > this.f250091p.pushManager.n() && toServiceMsg.getTimeout() < this.f250091p.pushManager.n()) {
                com.tencent.mobileqq.msf.core.net.n i3 = this.f250076a.i();
                if (i3 == null || !i3.j() || i3.n() == 0 || longValue4 < i3.n()) {
                    return true;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + this.F, 2, "xiaomi 2s: " + toServiceMsg.getRequestSsoSeq() + " msg timeout , addtoqueueTime is " + j3 + ",try close conn");
                }
                a(com.tencent.qphone.base.a.closeByNetDetectTooLongForPhoneSleep);
                x();
                return true;
            }
        }
        if (longValue3 != 0 && longValue3 <= this.f250076a.i().n()) {
            QLog.d("MSF.C.NetConnTag." + this.F, 1, "found timeout msg " + toServiceMsg + " before connSucc.");
        } else {
            if (toServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive) {
                QLog.d("MSF.C.NetConnTag." + this.F, 1, "found timeout heartalive msg " + toServiceMsg.getRequestSsoSeq());
                a(fromServiceMsg, toServiceMsg);
                return false;
            }
            if (toServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat) {
                QLog.d("MSF.C.NetConnTag." + this.F, 1, "found timeout quickheartbeat msg " + toServiceMsg.getRequestSsoSeq());
                this.f250092q.q().a(toServiceMsg, fromServiceMsg, false);
                return false;
            }
            synchronized (this) {
                if (f()) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (currentTimeMillis2 - this.J > com.tencent.mobileqq.msf.core.x.e.o().e()) {
                        if (toServiceMsg.getRequestSsoSeq() == f250071c0) {
                            f250071c0 = -1;
                            QLog.d("MSF.C.NetConnTag." + this.F, 1, "found first msg screen on timeout try close conn " + toServiceMsg);
                            a(com.tencent.qphone.base.a.closeForScrrenOnFirstMsgTimeout);
                            x();
                            return true;
                        }
                        if (com.tencent.mobileqq.msf.core.x.e.o().d()) {
                            B();
                        }
                    } else {
                        QLog.d("MSF.C.NetConnTag." + this.F, 1, "found timeout msg check time: timeNow = " + currentTimeMillis2 + " firstSendHeartBeatTime = " + this.J + " ConfigManager.getHeartBeatTimeInterval() = " + com.tencent.mobileqq.msf.core.x.e.o().e());
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + this.F, 2, "sendingHeartBeat: " + this.H + "net detect has started, no need sendHeartbeat");
                }
            }
        }
        if (toServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive) {
            return false;
        }
        if (toServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat) {
            this.f250092q.q().a(toServiceMsg, fromServiceMsg, true);
            return false;
        }
        try {
            if (this.f250076a.l()) {
                String[] strArr = W;
                int length = strArr.length;
                int i16 = 0;
                while (true) {
                    if (i16 >= length) {
                        z16 = true;
                        break;
                    }
                    String str = strArr[i16];
                    if (!TextUtils.isEmpty(str) && str.equals(toServiceMsg.getServiceCmd())) {
                        z16 = false;
                        break;
                    }
                    i16++;
                }
                if (z16) {
                    if (!this.f250089n.contains(toServiceMsg.getServiceCmd())) {
                        this.f250089n.add(toServiceMsg.getServiceCmd());
                    }
                    if (this.f250088m.incrementAndGet() >= com.tencent.mobileqq.msf.core.x.b.n()) {
                        if (this.f250089n.size() > 2) {
                            QLog.d("MSF.C.NetConnTag." + this.F, 1, "Continue wait resp for bus packets ,try close conn");
                            this.f250088m.set(0);
                            this.f250089n.clear();
                            a(com.tencent.qphone.base.a.continueWaitRspTimeout);
                            x();
                        } else {
                            if (QLog.isColorLevel()) {
                                QLog.d("MSF.C.NetConnTag." + this.F, 2, "Continue wait resp timeout by single cmd:" + this.f250089n.get(0));
                            } else {
                                QLog.d("MSF.C.NetConnTag." + this.F, 2, "Continue wait resp timeout by single cmd=" + com.tencent.mobileqq.msf.core.z.a.a(this.f250089n.get(0)));
                            }
                            this.f250088m.set(0);
                            this.f250089n.clear();
                            HashMap hashMap2 = new HashMap();
                            hashMap2.put("event_cmd", this.f250089n.get(0));
                            if (this.f250091p.getStatReporter() != null) {
                                this.f250091p.getStatReporter().a(com.tencent.mobileqq.msf.core.c0.g.f247739r0, false, 0L, 0L, (Map<String, String>) hashMap2, false, false);
                            }
                        }
                    }
                }
            }
            return true;
        } catch (Exception e26) {
            QLog.d("MSF.C.NetConnTag." + this.F, 1, " Continue wait resp for bus packets ,try close conn failed: " + e26);
            return true;
        }
    }

    public void g() {
        d g16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        com.tencent.mobileqq.msf.core.net.n i3 = this.f250076a.i();
        if (i3 == null || (g16 = i3.g()) == null) {
            return;
        }
        if (m.i().d() && g16.l()) {
            QLog.d("MSF.C.NetConnTag." + p(), 1, "[checkSSOVersionChange], set new sso version");
            CodecWarpper.nativeSetIsSupportNewSSO(true, p());
            return;
        }
        QLog.d("MSF.C.NetConnTag." + p(), 1, "[checkSSOVersionChange], set old sso version, msfV20Toggle: " + m.i().d() + ", isSupportNewSSO: " + g16.l());
        CodecWarpper.nativeSetIsSupportNewSSO(false, p());
    }

    public ToServiceMsg d(int i3) {
        Runnable runnable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (ToServiceMsg) iPatchRedirector.redirect((short) 32, (Object) this, i3);
        }
        ToServiceMsg remove = this.f250077b.remove(Integer.valueOf(i3));
        if (remove != null) {
            this.f250092q.p().a().removeCallbacks((Runnable) remove.getAttributes().remove(MsfConstants.ATTRIBUTE_TIMEOUT_CALLBACKER));
            if (com.tencent.mobileqq.msf.core.x.e.o().a() && (runnable = (Runnable) remove.getAttributes().remove(MsfConstants.ATTRIBUTE_PREDETECT_TIMEOUT_CALLBACKER)) != null) {
                this.f250092q.p().a().removeCallbacks(runnable);
            }
            if (this.f250091p.getStatReporter() != null && remove.isSupportRetry()) {
                this.f250091p.getStatReporter().d(true);
            }
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static CopyOnWriteArraySet<String> d(boolean z16) {
        return z16 ? f250073e0 : f250074f0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class a extends CodecWarpper {
        static IPatchRedirector $redirector_;

        public a(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, t.this, Boolean.valueOf(z16));
            } else {
                this.mIsMain = z16;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:44:0x066e  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x06ab  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x07ec  */
        /* JADX WARN: Removed duplicated region for block: B:82:0x08e4  */
        /* JADX WARN: Removed duplicated region for block: B:84:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0821  */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0670  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private void a(FromServiceMsg fromServiceMsg, int i3) {
            String serviceCmd;
            long j3;
            long j16;
            int i16;
            FromServiceMsg fromServiceMsg2;
            ToServiceMsg toServiceMsg;
            com.tencent.mobileqq.msf.core.x.q s16;
            String sb5;
            com.tencent.mobileqq.msf.service.n.a(fromServiceMsg);
            fromServiceMsg.addAttribute(BaseConstants.TIMESTAMP_NET2MSF, Long.valueOf(System.currentTimeMillis()));
            fromServiceMsg.addAttribute(BaseConstants.TIMESTAMP_NET2MSF_BOOT, Long.valueOf(SystemClock.elapsedRealtime()));
            byte[] msgCookie = fromServiceMsg.getMsgCookie();
            if (msgCookie != null && msgCookie.length > 0) {
                t.this.b(msgCookie);
            }
            fromServiceMsg.setRequestSsoSeq(fromServiceMsg.getAppSeq());
            if (!fromServiceMsg.isSuccess() && fromServiceMsg.getBusinessFailCode() == -10008) {
                t.a(fromServiceMsg.getUin(), false, t.this.p());
            } else if (fromServiceMsg.getUin() != null && fromServiceMsg.getUin().length() > 4 && !t.d(t.this.p()).contains(fromServiceMsg.getUin()) && fromServiceMsg.isSuccess() && fromServiceMsg.getSsoEnc() == 1 && !fromServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_SA) && !fromServiceMsg.getServiceCmd().startsWith(BaseConstants.CMD_SA_WT) && !fromServiceMsg.getServiceCmd().equals("ConfigService.ClientReq") && !fromServiceMsg.getServiceCmd().equals("ResourceConfig.ClientReq") && !fromServiceMsg.getServiceCmd().equals("GrayUinPro.Check") && !fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_WT_LOGIN_REQUESTREBINDMBL) && !fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_WT_LOGIN_ADDCONTACTS) && !fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_CONNAUTHSVR_GETAPPINFO) && !fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPI) && (!fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_CONNAUTHSVR_GETAUTHAPILIST) || fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_GRAY_APPLY))) {
                ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) t.e(t.this.p()).get(fromServiceMsg.getUin());
                if (concurrentLinkedQueue != null && concurrentLinkedQueue.contains(Integer.valueOf(fromServiceMsg.getRequestSsoSeq()))) {
                    t.e(t.this.p()).remove(fromServiceMsg.getUin());
                    t.a(fromServiceMsg.getUin(), true, t.this.p());
                    QLog.d(CodecWarpper.tag + t.this.F, 1, "recv Packet removeItem setV9, ssoSeq:" + fromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(fromServiceMsg.getUin()));
                } else {
                    QLog.d(CodecWarpper.tag + t.this.F, 1, "recv Packet ssoSeq:" + fromServiceMsg.getRequestSsoSeq() + ", uin:" + MsfSdkUtils.getShortUin(fromServiceMsg.getUin()));
                }
            }
            if (NetConnInfoCenter.isNeedWifiAuth()) {
                NetConnInfoCenter.setNeedWifiAuth(false);
            }
            ToServiceMsg d16 = t.this.d(fromServiceMsg.getRequestSsoSeq());
            if (d16 != null) {
                serviceCmd = d16.getServiceCmd();
            } else {
                serviceCmd = fromServiceMsg.getServiceCmd();
            }
            String str = serviceCmd;
            if (d16 == null || d16.getAttribute(BaseConstants.TIMESTAMP_MSF2NET) == null || fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF) == null) {
                j3 = 0;
            } else {
                long longValue = ((Long) fromServiceMsg.getAttribute(BaseConstants.TIMESTAMP_NET2MSF)).longValue() - ((Long) d16.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)).longValue();
                if (longValue < 0) {
                    longValue = 0;
                }
                if (longValue > TTL.MAX_VALUE) {
                    longValue = 0;
                }
                fromServiceMsg.addAttribute(BaseConstants.TIMESTAMP_MSF2NET, d16.getAttribute(BaseConstants.TIMESTAMP_MSF2NET));
                j3 = longValue;
            }
            StringBuilder sb6 = new StringBuilder();
            String serviceCmd2 = fromServiceMsg.getServiceCmd();
            boolean z16 = d.a.f392523f;
            if (QLog.isColorLevel()) {
                if (j3 == 0) {
                    sb5 = String.valueOf(j3);
                    j16 = j3;
                } else {
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(j3);
                    j16 = j3;
                    sb7.append(NetConnInfoCenter.getSignalStrengthsLog());
                    sb5 = sb7.toString();
                }
                if (fromServiceMsg.getResultCode() != 1000) {
                    String str2 = "MSF.C.NetConnTag." + t.this.F;
                    sb6.append("netRecv ssoSeq:");
                    sb6.append(fromServiceMsg.getRequestSsoSeq());
                    sb6.append(" uin:");
                    sb6.append(fromServiceMsg.getUin());
                    sb6.append(" cmd:");
                    sb6.append(serviceCmd2);
                    sb6.append(" len:");
                    sb6.append(i3);
                    sb6.append(" costTime:");
                    sb6.append(sb5);
                    sb6.append(" code:");
                    sb6.append(fromServiceMsg.getResultCode());
                    sb6.append(" failMsg:");
                    sb6.append(fromServiceMsg.getBusinessFailMsg());
                    sb6.append(" cross:");
                    sb6.append(z16 ? 1 : 0);
                    sb6.append(" socketEngineID: ");
                    sb6.append(t.this.f250076a.j());
                    sb6.append(" socket: ");
                    sb6.append(t.this.f250076a.i().v());
                    sb6.append(" socketFd: ");
                    sb6.append(t.this.f250076a.i().u());
                    sb6.append(" remainRecvBuffSize: ");
                    sb6.append(t.this.f250076a.i().p());
                    sb6.append(" recvBuffSize: ");
                    sb6.append(t.this.f250076a.i().o());
                    QLog.d(str2, 2, sb6.toString());
                    fromServiceMsg2 = fromServiceMsg;
                } else {
                    sb6.append("netRecv ssoSeq:");
                    sb6.append(fromServiceMsg.getRequestSsoSeq());
                    sb6.append(" uin:");
                    sb6.append(fromServiceMsg.getUin());
                    sb6.append(" cmd:");
                    sb6.append(serviceCmd2);
                    sb6.append(" len:");
                    sb6.append(i3);
                    sb6.append(" ssoRoute:");
                    sb6.append(fromServiceMsg.getAttribute(BaseConstants.DELTA_TIME_SERVER, 0L));
                    sb6.append(" costTime:");
                    sb6.append(sb5);
                    sb6.append(" cross:");
                    sb6.append(" socketEngineID: ");
                    sb6.append(t.this.f250076a.j());
                    sb6.append(" socket: ");
                    sb6.append(t.this.f250076a.i().v());
                    sb6.append(" socketFd: ");
                    sb6.append(t.this.f250076a.i().u());
                    sb6.append(" remainRecvBuffSize: ");
                    sb6.append(t.this.f250076a.i().p());
                    sb6.append(" recvBuffSize: ");
                    sb6.append(t.this.f250076a.i().o());
                    sb6.append("\nSSOReserveField.SsoTrpcResponse, ret:");
                    sb6.append(fromServiceMsg.getTrpcRspFuncRetCode());
                    sb6.append(", funcRetCode: ");
                    sb6.append(fromServiceMsg.getTrpcRspFuncRetCode());
                    sb6.append(", errorMsg:");
                    sb6.append(Arrays.toString(fromServiceMsg.getTrpcRspErrorMsg()));
                    if (!fromServiceMsg.getTransInfo().isEmpty()) {
                        sb6.append("\nSSOReserveField.SsoMapEntry, ");
                        for (Map.Entry<String, byte[]> entry : fromServiceMsg.getTransInfo().entrySet()) {
                            if (entry != null) {
                                sb6.append("key: ");
                                sb6.append(entry.getKey());
                                sb6.append(", value: ");
                                sb6.append(Arrays.toString(entry.getValue()));
                                sb6.append(";");
                            }
                        }
                    }
                    QLog.d("MSF.C.NetConnTag." + t.this.F, 2, sb6.toString());
                    fromServiceMsg2 = fromServiceMsg;
                }
                i16 = 1000;
            } else {
                j16 = j3;
                i16 = 1000;
                if (fromServiceMsg.getResultCode() != 1000) {
                    String str3 = "MSF.C.NetConnTag." + t.this.F;
                    sb6.append("netRecv ssoSeq:");
                    sb6.append(fromServiceMsg.getRequestSsoSeq());
                    sb6.append(" uin:");
                    sb6.append(MsfSdkUtils.getShortUin(fromServiceMsg.getUin()));
                    sb6.append(" cmd=");
                    sb6.append(com.tencent.mobileqq.msf.core.z.a.a(serviceCmd2));
                    sb6.append(" ");
                    sb6.append(fromServiceMsg.getRequestSsoSeq() + i3);
                    sb6.append(" code:");
                    sb6.append(fromServiceMsg.getResultCode());
                    sb6.append(" failMsg:");
                    sb6.append(fromServiceMsg.getBusinessFailMsg());
                    sb6.append(" cross:");
                    sb6.append(z16 ? 1 : 0);
                    sb6.append(" socketEngineID: ");
                    sb6.append(t.this.f250076a.j());
                    sb6.append(" socket: ");
                    sb6.append(t.this.f250076a.i().v());
                    QLog.d(str3, 1, sb6.toString());
                    fromServiceMsg2 = fromServiceMsg;
                } else {
                    String str4 = "MSF.C.NetConnTag." + t.this.F;
                    sb6.append("netRecv ssoSeq:");
                    sb6.append(fromServiceMsg.getRequestSsoSeq());
                    sb6.append(" uin:");
                    sb6.append(MsfSdkUtils.getShortUin(fromServiceMsg.getUin()));
                    sb6.append(" cmd=");
                    sb6.append(com.tencent.mobileqq.msf.core.z.a.a(serviceCmd2));
                    sb6.append(" ");
                    sb6.append(fromServiceMsg.getRequestSsoSeq() + i3);
                    sb6.append(" ssoRoute:");
                    fromServiceMsg2 = fromServiceMsg;
                    sb6.append(fromServiceMsg2.getAttribute(BaseConstants.DELTA_TIME_SERVER, 0L));
                    sb6.append(" cross:");
                    sb6.append(z16 ? 1 : 0);
                    sb6.append(" socketEngineID: ");
                    sb6.append(t.this.f250076a.j());
                    sb6.append(" socket: ");
                    sb6.append(t.this.f250076a.i().v());
                    QLog.d(str4, 1, sb6.toString());
                }
            }
            fromServiceMsg2.addAttribute(BaseConstants.Attribute_TAG_LOGSTR, t.this.f250093r + "|" + fromServiceMsg.getRequestSsoSeq() + "|" + fromServiceMsg.getServiceCmd() + "|");
            fromServiceMsg2.addAttribute(BaseConstants.Attribute_TAG_SOCKET_ADDRESS, t.this.f250093r);
            if (d16 != null) {
                try {
                    toServiceMsg = d16;
                    try {
                        t.this.f250076a.a(fromServiceMsg2, toServiceMsg);
                    } catch (Exception e16) {
                        e = e16;
                        t.this.f250076a.r();
                        t.this.f250076a.f248870t = 0L;
                        QLog.d(CodecWarpper.tag + t.this.F, 1, "call firstResponseGetted error " + e, e);
                        int i17 = i16;
                        d.d.d(str, fromServiceMsg.getRequestSsoSeq(), i3, j16, toServiceMsg != null);
                        if (t.this.f250091p.isReconnectSso.get()) {
                            t.this.f250076a.i().a(com.tencent.qphone.base.a.pushNeedReConn);
                            t.this.f250091p.isReconnectSso.set(false);
                        }
                        if (toServiceMsg != null) {
                        }
                        if (!t.f250075g0.get()) {
                        }
                        t.this.f250091p.getAccountCenter().f247404j.c();
                        r.l().h();
                        s16 = t.this.f250092q.s();
                        if (s16 == null) {
                        }
                    }
                } catch (Exception e17) {
                    e = e17;
                    toServiceMsg = d16;
                }
            } else {
                toServiceMsg = d16;
            }
            int i172 = i16;
            d.d.d(str, fromServiceMsg.getRequestSsoSeq(), i3, j16, toServiceMsg != null);
            if (t.this.f250091p.isReconnectSso.get() && t.this.q()) {
                t.this.f250076a.i().a(com.tencent.qphone.base.a.pushNeedReConn);
                t.this.f250091p.isReconnectSso.set(false);
            }
            if (toServiceMsg != null) {
                fromServiceMsg2.setAppSeq(toServiceMsg.getAppSeq());
                fromServiceMsg2.setMsfCommand(toServiceMsg.getMsfCommand());
                fromServiceMsg2.setAppId(toServiceMsg.getAppId());
                if (!fromServiceMsg.isSuccess()) {
                    int businessFailCode = fromServiceMsg.getBusinessFailCode();
                    if (businessFailCode == 302) {
                        fromServiceMsg2.setBusinessFail(-302);
                        businessFailCode = -302;
                    }
                    if (businessFailCode == -302) {
                        t.this.f250076a.i().a(com.tencent.qphone.base.a.connFull);
                        t.this.f250091p.reSendMsg(toServiceMsg);
                        return;
                    }
                    if (businessFailCode == -10008) {
                        if (fromServiceMsg.getRequestSsoSeq() == 0) {
                            MsfCore.sCore.getStatReporter().a(false, toServiceMsg, fromServiceMsg2);
                        }
                        if (!MsfMsgUtil.hasResendMsg(toServiceMsg, BaseConstants.ATTRIBUTE_MSG_HAS_RESEND_BY_10008)) {
                            toServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_MSG_HAS_RESEND_BY_10008, Boolean.TRUE);
                            QLog.d(CodecWarpper.tag + t.this.F, 1, "Resend 10008 " + toServiceMsg.getShortStringForLog());
                            t.this.f250091p.reSendMsg(toServiceMsg);
                            return;
                        }
                        QLog.d(CodecWarpper.tag + t.this.F, 1, "This msg has already resend by -10008, won't resend again!");
                    } else if (businessFailCode == -10119) {
                        if (!MsfMsgUtil.hasResendMsg(toServiceMsg, BaseConstants.ATTRIBUTE_MSG_HAS_RESEND_BY_10119)) {
                            toServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_MSG_HAS_RESEND_BY_10119, Boolean.TRUE);
                            QLog.d(CodecWarpper.tag + t.this.F, 1, "Resend 10119 " + toServiceMsg.getShortStringForLog());
                            t.this.f250091p.reSendMsg(toServiceMsg);
                            return;
                        }
                        QLog.d(CodecWarpper.tag + t.this.F, 1, "This msg has already resend by CODE_V20_DISABLE, won't resend again!");
                    }
                }
            }
            if (!t.f250075g0.get()) {
                QLog.e(CodecWarpper.tag + t.this.F, 1, "invalidSign, " + fromServiceMsg2 + " is droped.");
            } else if (toServiceMsg == null && fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_REQ_CHECKSIGNATURE) && fromServiceMsg.getBusinessFailCode() != i172) {
                QLog.e(CodecWarpper.tag + t.this.F, 1, "PhSigLcId.Check failed, code = " + fromServiceMsg.getBusinessFailCode());
            } else {
                if (fromServiceMsg.getMsfCommand() == MsfCommand._msf_HeartbeatAlive) {
                    t.this.a(fromServiceMsg2, toServiceMsg);
                } else if (fromServiceMsg.getMsfCommand() == MsfCommand._msf_QuickHeartBeat) {
                    t.this.f250092q.q().a(toServiceMsg, fromServiceMsg2, false);
                } else {
                    t.this.f250088m.set(0);
                    t.this.f250089n.clear();
                    t.this.f250091p.getSsoRespHandler().a(toServiceMsg, fromServiceMsg2);
                }
                t.this.f250092q.f().n(toServiceMsg, fromServiceMsg2);
                t.this.E.a(toServiceMsg, fromServiceMsg2);
                t.this.w();
            }
            t.this.f250091p.getAccountCenter().f247404j.c();
            r.l().h();
            s16 = t.this.f250092q.s();
            if (s16 == null) {
                s16.b();
            }
        }

        @Override // com.tencent.qphone.base.util.CodecWarpper
        public void onInvalidData(int i3, int i16, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
                return;
            }
            QLog.d(CodecWarpper.tag + t.this.F, 1, "MSF.C.CodecWarpper onInvalidData " + i3 + " size is " + i16 + ", error uin is: " + str + ", mainAccount is: " + t.this.f250091p.getMainAccount() + ", try to closeConn");
            t.this.f250076a.i().a(a(i3));
            try {
                t.this.f250076a.d();
            } catch (Exception e16) {
                QLog.d(CodecWarpper.tag + t.this.F, 1, "call findResponseDataError error " + e16);
            }
            a(i3, i16, str);
        }

        @Override // com.tencent.qphone.base.util.CodecWarpper
        public void onInvalidSign() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            QLog.d(CodecWarpper.tag + t.this.F, 1, "MSF.C.CodecWarpper onInvalidSign");
            FromServiceMsg fromServiceMsg = new FromServiceMsg(BaseApplication.getContext().getAppId(), t.this.f250091p.getNextSeq(), "0", BaseConstants.CMD_INVALIDSIGN);
            fromServiceMsg.setBusinessFail(2014, "onInvalidSign");
            fromServiceMsg.setMsfCommand(MsfCommand.onInvalidSign);
            MsfSdkUtils.addFromMsgProcessName("*", fromServiceMsg);
            t.this.f250091p.addRespToQuque(null, fromServiceMsg);
            t.f250075g0.set(true);
        }

        @Override // com.tencent.qphone.base.util.CodecWarpper
        public void onResponse(int i3, Object obj, int i16, byte[] bArr) {
            Throwable th5;
            FromServiceMsg fromServiceMsg;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), obj, Integer.valueOf(i16), bArr);
                return;
            }
            if (obj != null) {
                FromServiceMsg fromServiceMsg2 = null;
                try {
                    if (t.f250071c0 != -1) {
                        t.f250071c0 = -1;
                    }
                    t.this.K = System.currentTimeMillis();
                    t.f250070b0 = t.this.K;
                    fromServiceMsg = (FromServiceMsg) obj;
                } catch (Throwable th6) {
                    th5 = th6;
                }
                try {
                    int length = fromServiceMsg.getWupBuffer().length;
                    com.tencent.mobileqq.msf.core.h0.c wakeUpLockManager = t.this.f250091p.getWakeUpLockManager();
                    if (wakeUpLockManager != null) {
                        wakeUpLockManager.a(fromServiceMsg);
                    }
                    int resultCode = fromServiceMsg.getResultCode();
                    fromServiceMsg.addAttribute(BaseConstants.KEY_SSO_RET_CODE, String.valueOf(resultCode));
                    if (resultCode != -10119) {
                        switch (resultCode) {
                            case -10112:
                                QLog.d(CodecWarpper.tag + t.this.F, 1, "handleHttpSsoResp result code: " + fromServiceMsg.getResultCode());
                                break;
                            case -10111:
                                QLog.d(CodecWarpper.tag + t.this.F, 1, "handleHttpSsoResp result code: " + fromServiceMsg.getResultCode());
                                t.this.f250092q.s().d();
                                if (NetConnInfoCenter.getActiveNetIpFamily(true) != 2) {
                                    t.this.f250076a.i().a(com.tencent.qphone.base.a.pushNeedReConn);
                                    t.this.f250091p.isReconnectSso.set(false);
                                    QLog.d(CodecWarpper.tag + t.this.F, 1, "close conn");
                                    break;
                                }
                                break;
                            case -10110:
                                t.this.f250092q.s().d();
                                t.this.f250076a.i().a(com.tencent.qphone.base.a.pushNeedReConn);
                                t.this.f250091p.isReconnectSso.set(false);
                                QLog.d(CodecWarpper.tag + t.this.F, 1, "close conn, handleHttpSsoResp result code: " + fromServiceMsg.getResultCode());
                                break;
                        }
                    } else {
                        QLog.d(CodecWarpper.tag + t.this.F, 1, "handleSsoResp result code: " + fromServiceMsg.getResultCode());
                        t.this.z();
                    }
                    if (fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_SSO_LOGIN_MERGE)) {
                        fromServiceMsg.setRequestSsoSeq(fromServiceMsg.getAppSeq());
                        if (!fromServiceMsg.isSuccess()) {
                            if (QLog.isColorLevel()) {
                                QLog.d("MSF.C.NetConnTag." + t.this.F, 2, "failed merge netRecv ssoSeq:" + fromServiceMsg.getRequestSsoSeq() + " cmd:" + fromServiceMsg.getServiceCmd() + " len: " + fromServiceMsg.getWupBuffer().length);
                            } else {
                                QLog.d("MSF.C.NetConnTag." + t.this.F, 1, "failed merge netRecv ssoSeq:" + fromServiceMsg.getRequestSsoSeq() + " cmd=" + com.tencent.mobileqq.msf.core.z.a.a(fromServiceMsg.getServiceCmd()) + " len: " + fromServiceMsg.getWupBuffer().length);
                            }
                            ArrayList<Integer> remove = t.this.f250078c.remove(Integer.valueOf(fromServiceMsg.getRequestSsoSeq()));
                            if (fromServiceMsg.getBusinessFailCode() == -10107) {
                                if (t.this.f250087l) {
                                    t.this.f250087l = false;
                                }
                                QLog.d("MSF.C.NetConnTag." + t.this.F, 1, "merge not support, " + Arrays.toString(remove.toArray()) + "resend, close merge.");
                            }
                            if (remove != null) {
                                Iterator<Integer> it = remove.iterator();
                                while (it.hasNext()) {
                                    ToServiceMsg d16 = t.this.d(it.next().intValue());
                                    if (d16 != null) {
                                        t.this.d(d16);
                                    }
                                }
                                return;
                            }
                        }
                    }
                    if ((fromServiceMsg.getFlag() & 1) != 0) {
                        byte[] wupBuffer = fromServiceMsg.getWupBuffer();
                        if (wupBuffer.length > 4) {
                            try {
                                int i17 = ((wupBuffer[0] & 255) << 24) | 0 | ((wupBuffer[1] & 255) << 16) | ((wupBuffer[2] & 255) << 8) | (wupBuffer[3] & 255);
                                byte[] bArr2 = new byte[i17];
                                System.arraycopy(wupBuffer, 4, bArr2, 0, i17 - 4);
                                byte[] b16 = com.tencent.qphone.base.util.g.b(bArr2);
                                byte[] bArr3 = new byte[b16.length + 4];
                                bArr3[0] = (byte) (((b16.length + 4) >> 24) & 255);
                                bArr3[1] = (byte) (((b16.length + 4) >> 16) & 255);
                                bArr3[2] = (byte) (((b16.length + 4) >> 8) & 255);
                                bArr3[3] = (byte) ((b16.length + 4) & 255);
                                System.arraycopy(b16, 0, bArr3, 4, b16.length);
                                fromServiceMsg.putWupBuffer(bArr3);
                            } catch (Exception e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(CodecWarpper.tag + t.this.F, 2, "uncompress data failed " + e16);
                                }
                                if (!fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_SSO_LOGIN_MERGE)) {
                                    onInvalidData(-7, wupBuffer.length, fromServiceMsg.getUin());
                                    return;
                                } else {
                                    a(-7, wupBuffer.length, fromServiceMsg.getRequestSsoSeq());
                                    return;
                                }
                            }
                        } else if (!fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_SSO_LOGIN_MERGE)) {
                            onInvalidData(-6, wupBuffer.length, fromServiceMsg.getUin());
                            return;
                        } else {
                            a(-6, wupBuffer.length, fromServiceMsg.getRequestSsoSeq());
                            return;
                        }
                    }
                    if (bArr != null) {
                        try {
                            SSOReserveField.ReserveFields reserveFields = new SSOReserveField.ReserveFields();
                            reserveFields.mergeFrom(bArr);
                            if (reserveFields.trpc_rsp.has()) {
                                SSOReserveField.SsoTrpcResponse ssoTrpcResponse = reserveFields.trpc_rsp.get();
                                fromServiceMsg.setTrpcRspRetCode(ssoTrpcResponse.ret.get());
                                fromServiceMsg.setTrpcRspFuncRetCode(ssoTrpcResponse.func_ret.get());
                                fromServiceMsg.setTrpcRspErrorMsg(ssoTrpcResponse.error_msg.get().toByteArray());
                            }
                            if (reserveFields.trans_info.has()) {
                                for (SSOReserveField.SsoMapEntry ssoMapEntry : reserveFields.trans_info.get()) {
                                    if (ssoMapEntry.key.get() != null) {
                                        fromServiceMsg.addTransInfo(ssoMapEntry.key.get(), ssoMapEntry.value.get().toByteArray());
                                    }
                                }
                            }
                            if (reserveFields.message_type.has() && reserveFields.message_type.get() == 1) {
                                fromServiceMsg.setIsColorLevel(true);
                            }
                            if (reserveFields.sec_sig_flag.has() && com.tencent.mobileqq.msf.core.d0.a.c().a() != reserveFields.sec_sig_flag.get()) {
                                com.tencent.mobileqq.msf.core.d0.a.c().a(reserveFields.sec_sig_flag.get());
                            }
                            if (reserveFields.sso_route_cost.has()) {
                                fromServiceMsg.addAttribute(BaseConstants.DELTA_TIME_SERVER, Integer.valueOf(reserveFields.sso_route_cost.get()));
                            }
                        } catch (Exception e17) {
                            QLog.d(CodecWarpper.tag + t.this.F, 1, "resolve sso reserve field failed", e17);
                        }
                    }
                    if (fromServiceMsg.isSuccess() && fromServiceMsg.getServiceCmd().equals(BaseConstants.CMD_SSO_LOGIN_MERGE)) {
                        QLog.d("MSF.C.NetConnTag." + t.this.F, 1, "netRecv Delay FromServiceMsg ssoSeq:" + fromServiceMsg.getRequestSsoSeq() + " scmd: " + fromServiceMsg.getServiceCmd() + " len: " + length + " uncompressed len: " + fromServiceMsg.getWupBuffer().length);
                        SSOLoginMerge.BusiBuffData busiBuffData = new SSOLoginMerge.BusiBuffData();
                        int length2 = fromServiceMsg.getWupBuffer().length - 4;
                        byte[] bArr4 = new byte[length2];
                        System.arraycopy(fromServiceMsg.getWupBuffer(), 4, bArr4, 0, length2);
                        for (SSOLoginMerge.BusiBuffItem busiBuffItem : busiBuffData.mergeFrom(bArr4).BusiBuffVec.get()) {
                            FromServiceMsg fromServiceMsg3 = new FromServiceMsg();
                            fromServiceMsg3.setServiceCmd(busiBuffItem.ServiceCmd.get());
                            fromServiceMsg3.setRequestSsoSeq(busiBuffItem.SeqNo.get());
                            fromServiceMsg3.putWupBuffer(busiBuffItem.BusiBuff.get().toByteArray());
                            fromServiceMsg3.setAppSeq(fromServiceMsg3.getRequestSsoSeq());
                            fromServiceMsg3.setMsgSuccess();
                            fromServiceMsg3.setUin(fromServiceMsg.getUin());
                            fromServiceMsg3.putWupBuffer(MsfMsgUtil.addByteLen(fromServiceMsg3.getWupBuffer()));
                            if (fromServiceMsg.getAttribute(BaseConstants.DELTA_TIME_SERVER) != null) {
                                fromServiceMsg3.addAttribute(BaseConstants.DELTA_TIME_SERVER, fromServiceMsg.getAttribute(BaseConstants.DELTA_TIME_SERVER));
                            }
                            if (busiBuffItem.trpc_rsp.has()) {
                                SSOReserveField.SsoTrpcResponse ssoTrpcResponse2 = busiBuffItem.trpc_rsp.get();
                                fromServiceMsg3.setTrpcRspRetCode(ssoTrpcResponse2.ret.get());
                                fromServiceMsg3.setTrpcRspFuncRetCode(ssoTrpcResponse2.func_ret.get());
                                fromServiceMsg3.setTrpcRspErrorMsg(ssoTrpcResponse2.error_msg.get().toByteArray());
                            }
                            if (busiBuffItem.trans_info.has()) {
                                for (SSOReserveField.SsoMapEntry ssoMapEntry2 : busiBuffItem.trans_info.get()) {
                                    if (ssoMapEntry2.key.get() != null) {
                                        fromServiceMsg3.addTransInfo(ssoMapEntry2.key.get(), ssoMapEntry2.value.get().toByteArray());
                                    }
                                }
                            }
                            if (busiBuffItem.message_type.has() && busiBuffItem.message_type.get() == 1) {
                                fromServiceMsg3.setIsColorLevel(true);
                            }
                            a(fromServiceMsg3, fromServiceMsg3.getWupBuffer().length);
                        }
                        return;
                    }
                    if (fromServiceMsg.isSuccess() && fromServiceMsg.getServiceCmd().equals("RegPrxySvc.oidb_0x769")) {
                        MsfPullConfigUtil.parseConfigResponse(fromServiceMsg.getWupBuffer(), true);
                    } else {
                        a(fromServiceMsg, i16);
                    }
                } catch (Throwable th7) {
                    th5 = th7;
                    fromServiceMsg2 = fromServiceMsg;
                    if (th5.toString().contains("InvalidProtocol") && fromServiceMsg2 != null) {
                        a(-8, i16, fromServiceMsg2.getRequestSsoSeq());
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d(CodecWarpper.tag + t.this.F, 2, "handleSsoResp " + obj + " error " + th5.toString(), th5);
                    }
                }
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:80:0x02ab, code lost:
        
            if (r9 > com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL.MAX_VALUE) goto L77;
         */
        @Override // com.tencent.qphone.base.util.CodecWarpper
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int onSSOPingResponse(byte[] bArr, int i3) {
            ByteBuffer wrap;
            int i16;
            long j3;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) bArr, i3)).intValue();
            }
            if (bArr == null) {
                QLog.d(CodecWarpper.tag + t.this.F, 1, "MSF.C.CodecWarpper onSSOPingResponse error, data null, connId = " + i3);
                return -1;
            }
            if (bArr.length <= 4) {
                QLog.d(CodecWarpper.tag + t.this.F, 1, "MSF.C.CodecWarpper onSSOPingResponse error, length: " + bArr.length);
                return 1;
            }
            int length = bArr.length;
            try {
                wrap = ByteBuffer.wrap(bArr);
                i16 = wrap.getInt();
            } catch (Exception e16) {
                e16.printStackTrace();
                QLog.d(CodecWarpper.tag + t.this.F, 1, "MSF.C.CodecWarpper onSSOPingResponse error, exception : ", e16);
            }
            if (i16 != length) {
                return 1;
            }
            wrap.getInt();
            wrap.getInt();
            int i17 = wrap.get() - 1;
            if (i17 > 0 && i17 <= i16 - 13) {
                byte[] bArr2 = new byte[i17];
                wrap.get(bArr2, 0, i17);
                String str2 = new String(bArr2);
                if (!str2.equals(ProcessConstant.MSF) && !str2.equals("GWv4") && com.tencent.mobileqq.msf.core.x.b.c() && com.tencent.mobileqq.msf.core.net.r.b.d()) {
                    try {
                        com.tencent.mobileqq.msf.core.net.r.b.a(bArr);
                    } catch (Exception e17) {
                        QLog.d(CodecWarpper.tag + t.this.F, 1, "heartbeatproxy failed to process back msg ", e17);
                    }
                    return 0;
                }
                wrap.position((wrap.position() + wrap.get()) - 1);
                int i18 = wrap.getInt();
                String a16 = a(wrap, i18, i3);
                if ("GWv4".equals(str2)) {
                    t.Z = i18;
                    if (bArr.length == 50) {
                        byte[] bArr3 = new byte[24];
                        wrap.get(bArr3, 0, 24);
                        byte[] unused = t.Y = bArr3;
                        if (QLog.isColorLevel()) {
                            QLog.d(CodecWarpper.tag + t.this.F, 2, "MSF.C.CodecWarpper onSSOPingResponse sGwV4Sec:" + t.Y);
                        }
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(CodecWarpper.tag + t.this.F, 2, "MSF.C.CodecWarpper onSSOPingResponse cmd:" + str2 + ", ip:" + a16 + ", totalsize=" + length);
                } else {
                    QLog.d(CodecWarpper.tag + t.this.F, 1, "MSF.C.CodecWarpper onSSOPingResponse cmd=" + com.tencent.mobileqq.msf.core.z.a.a(str2) + ", GatewayIp=" + com.tencent.mobileqq.msf.core.z.a.a(a16) + ", totalsize=" + length);
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    for (int i19 = 0; i19 < length; i19++) {
                        if (i19 % 4 == 0) {
                            sb5.append("\n");
                        }
                        String hexString = Integer.toHexString(bArr[i19] & 255);
                        if (hexString.length() == 1) {
                            hexString = "0" + hexString;
                        }
                        sb5.append(hexString);
                        sb5.append(" ");
                    }
                    QLog.d(CodecWarpper.tag + t.this.F, 2, "MSF.C.CodecWarpper onSSOPingResponse pingBack=" + sb5.toString());
                }
                t.this.f250076a.e(i3);
                com.tencent.mobileqq.msf.core.net.n c16 = t.this.f250076a.c(i3);
                if (c16 == null) {
                    QLog.d(CodecWarpper.tag + t.this.F, 1, "MSF.C.CodecWarpper onSSOPingResponse error, get socketEngine null, connId = " + i3);
                    return -1;
                }
                ToServiceMsg x16 = c16.x();
                if (x16 != null && x16.getAttribute(BaseConstants.TIMESTAMP_MSF2NET) != null) {
                    j3 = SystemClock.elapsedRealtime() - ((Long) x16.getAttribute(BaseConstants.TIMESTAMP_MSF2NET)).longValue();
                    if (j3 < 0) {
                        j3 = 0;
                    }
                }
                j3 = 0;
                if (x16 != null) {
                    t.this.f250092q.f().f(x16.getRequestSsoSeq(), j3);
                    StringBuilder sb6 = new StringBuilder();
                    String serviceCmd = x16.getServiceCmd();
                    if (QLog.isColorLevel()) {
                        if (j3 == 0) {
                            str = String.valueOf(j3);
                        } else {
                            str = j3 + NetConnInfoCenter.getSignalStrengthsLog();
                        }
                        String str3 = "MSF.C.NetConnTag." + t.this.F;
                        sb6.append("netRecv ssoSeq:");
                        sb6.append(x16.getRequestSsoSeq());
                        sb6.append(" uin:");
                        sb6.append(x16.getUin());
                        sb6.append(" cmd:");
                        sb6.append(x16.getServiceCmd());
                        sb6.append(" len:");
                        sb6.append(length);
                        sb6.append(" costTime:");
                        sb6.append(str);
                        QLog.d(str3, 1, sb6.toString());
                    } else {
                        String str4 = "MSF.C.NetConnTag." + t.this.F;
                        sb6.append("netRecv ssoSeq:");
                        sb6.append(x16.getRequestSsoSeq());
                        sb6.append(" uin:");
                        sb6.append(MsfSdkUtils.getShortUin(x16.getUin()));
                        sb6.append(" cmd=");
                        sb6.append(com.tencent.mobileqq.msf.core.z.a.a(serviceCmd));
                        sb6.append(" " + (x16.getRequestSsoSeq() + length));
                        QLog.d(str4, 1, sb6.toString());
                    }
                }
                return 0;
            }
            return 1;
        }

        private void a(int i3, int i16, String str) {
            if (MsfService.getCore().getStatReporter() != null) {
                HashMap hashMap = new HashMap();
                hashMap.put("fail_code", String.valueOf(i3));
                hashMap.put("data_len", String.valueOf(i16));
                hashMap.put("error_uin", str);
                MsfService.getCore().getStatReporter().a("msf_invalid_data", false, 0L, 0L, (Map<String, String>) hashMap, true, false);
            }
        }

        private com.tencent.qphone.base.a a(int i3) {
            switch (i3) {
                case -8:
                    return com.tencent.qphone.base.a.closeByPbUnpackFailInLoginMerge;
                case -7:
                    return com.tencent.qphone.base.a.closeByZlibUncompressException;
                case -6:
                    return com.tencent.qphone.base.a.closeByZlibDataLengthTooShort;
                case -5:
                    return com.tencent.qphone.base.a.invalidData;
                case -4:
                    return com.tencent.qphone.base.a.closeByDecryptFailEmpty;
                case -3:
                    return com.tencent.qphone.base.a.closeByDecryptFailTwice;
                case -2:
                    return com.tencent.qphone.base.a.closeByDecryptFailOnce;
                default:
                    return com.tencent.qphone.base.a.closeForOtherReason;
            }
        }

        public void a(int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
                return;
            }
            QLog.d(CodecWarpper.tag + t.this.F, 1, "MSF.C.CodecWarpper loginMerge onInvalidData " + i3 + " size is " + i16 + ", try to closeConn");
            t.this.f250076a.i().a(a(i3));
            StringBuilder sb5 = new StringBuilder();
            sb5.append(com.tencent.mobileqq.msf.core.e0.i.f248008o);
            sb5.append("|");
            sb5.append(BaseApplication.getContext().getAppId());
            sb5.append("|");
            sb5.append(i17);
            sb5.append("|");
            sb5.append(i3);
            sb5.append("|");
            sb5.append(t.this.f250076a.i().g().n());
            if (QLog.isDevelopLevel()) {
                QLog.d(CodecWarpper.tag + t.this.F, 4, "CodecStatHelper Report loginMerge_error " + sb5.toString());
            }
            HashMap hashMap = new HashMap();
            hashMap.put("loginMerge_failDetail", sb5.toString());
            if (MsfService.getCore().getStatReporter() != null) {
                MsfService.getCore().getStatReporter().a("loginMerge_error", true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            }
        }

        private String a(ByteBuffer byteBuffer, int i3, int i16) {
            com.tencent.mobileqq.msf.core.net.n c16 = t.this.f250076a.c(i16);
            String str = "";
            if (c16 == null) {
                QLog.e(CodecWarpper.tag + t.this.F, 1, "get null socketEngine with connId: " + i16);
                return "";
            }
            if (c16.f() == 0) {
                QLog.e(CodecWarpper.tag + t.this.F, 1, "get socketEngine with connId: " + i16 + " IpFamily=0");
                return "";
            }
            if (c16.f() == 1) {
                str = String.valueOf((i3 >> 24) & 255) + '.' + ((i3 >> 16) & 255) + '.' + ((i3 >> 8) & 255) + '.' + (i3 & 255);
            } else if (c16.f() == 2) {
                str = a(byteBuffer);
            }
            c16.a(str);
            if (QLog.isColorLevel()) {
                QLog.d(CodecWarpper.tag + t.this.F, 2, "check SocketEngine=" + i16 + " GatewayIp, GatewayIp:" + str);
            } else {
                QLog.d(CodecWarpper.tag + t.this.F, 1, "check SocketEngine=" + i16 + " GatewayIp, GatewayIp=" + com.tencent.mobileqq.msf.core.z.a.a(str));
            }
            return str;
        }

        private String a(ByteBuffer byteBuffer) {
            if (byteBuffer.remaining() < 16) {
                QLog.d(CodecWarpper.tag + t.this.F, 1, "setGatewayIpV6, remaining = " + byteBuffer.remaining());
                return "";
            }
            try {
                StringBuilder sb5 = new StringBuilder();
                byte[] bArr = new byte[2];
                for (int i3 = 0; i3 < 8; i3++) {
                    byteBuffer.get(bArr);
                    sb5.append(HexUtil.bytes2HexStr(bArr));
                    if (i3 != 7) {
                        sb5.append(":");
                    }
                }
                return g.a(sb5.toString().toLowerCase());
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d(CodecWarpper.tag + t.this.F, 2, "setGatewayIpV6 throws e", th5);
                }
                return "";
            }
        }
    }

    public void a(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) runnable);
        } else if (runnable != null) {
            this.f250092q.p().a(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(FromServiceMsg fromServiceMsg, ToServiceMsg toServiceMsg) {
        if (fromServiceMsg.getBusinessFailCode() == 1002) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag." + this.F, 2, "handleHeartbeat wait " + toServiceMsg + " timeout.");
            }
            if (!this.f250076a.l()) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + this.F, 2, "conn is also closed.");
                }
                x();
                return;
            }
            if (this.I >= com.tencent.mobileqq.msf.core.x.e.o().c()) {
                try {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag." + this.F, 2, "Heartbeat continueTimeoutCount is " + this.I + ",closeConn closeByNetDetectFailed");
                    }
                    a(com.tencent.qphone.base.a.closeByNetDetectFailed);
                    x();
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MSF.C.NetConnTag." + this.F, 2, e16.toString(), e16);
                        return;
                    }
                    return;
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.J > com.tencent.mobileqq.msf.core.x.e.o().c() * com.tencent.mobileqq.msf.core.x.e.o().f()) {
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + this.F, 2, "timenow - firstSendHeartBeatTime is " + (currentTimeMillis - this.J) + ",closeConn continueWaitRspTimeout");
                }
                a(com.tencent.qphone.base.a.continueWaitRspTimeout);
                x();
                return;
            }
            B();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MSF.C.NetConnTag." + this.F, 2, "recv heart resp.now conn is alive.");
        }
        x();
    }

    @Nullable
    public static byte[] b(ToServiceMsg toServiceMsg, String str, int i3, d dVar, boolean z16) {
        SSOReserveField.ReserveFields a16 = a(toServiceMsg, str, dVar != null ? dVar.c() : 1, i3, z16);
        if (a16 == null) {
            a16 = new SSOReserveField.ReserveFields();
        }
        a16.newconn_flag.set(!z16 ? 1 : 0);
        return a16.toByteArray();
    }

    private boolean a(String str, String str2) {
        return (this.f250091p.getAccountCenter().k(str) || str2.equals(BaseConstants.CMD_HEARTBEATPING) || str2.equals(BaseConstants.CMD_HEARTBEATALIVE) || str2.equals(BaseConstants.CMD_GETTIMENEW) || com.tencent.mobileqq.msf.core.x.o.x().f().contains(str2)) ? false : true;
    }

    public void a(com.tencent.qphone.base.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 29)) {
            this.f250076a.a(aVar);
        } else {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) aVar);
        }
    }

    public static void a(String str, boolean z16) {
        a(str, z16, true);
        a(str, z16, false);
    }

    public static void a(String str, boolean z16, boolean z17) {
        if (z16) {
            d(z17).add(str);
            QLog.d("MSF.C.NetConnTag." + z17, 1, "use simple head for uin:" + MsfSdkUtils.getShortUin(str));
        } else {
            d(z17).remove(str);
            QLog.d("MSF.C.NetConnTag." + z17, 1, "use full head for uin:" + MsfSdkUtils.getShortUin(str));
            if (e(z17).containsKey(str)) {
                e(z17).remove(str);
                QLog.d("MSF.C.NetConnTag.", 1, "clear storeSendSsoSeq tag for uin:" + MsfSdkUtils.getShortUin(str));
            }
        }
        CodecWarpper.nativeSetUseSimpleHead(str, z16, z17);
    }

    public void a(byte[] bArr, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) bArr, i3);
            return;
        }
        if (!this.f250076a.d(i3)) {
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag." + this.F, 2, "onRecvSsoResp: dump, connId: " + i3);
                return;
            }
            return;
        }
        if (bArr != null && bArr.length > 4 && bArr.length <= 50) {
            if (this.f250090o.onSSOPingResponse(bArr, i3) > 0) {
                this.f250090o.nativeOnReceData(bArr, i3);
                return;
            }
            return;
        }
        this.f250090o.nativeOnReceData(bArr, i3);
    }

    @Nullable
    public static byte[] a(ToServiceMsg toServiceMsg, String str, int i3, int i16) {
        SSOReserveField.ReserveFields a16 = a(toServiceMsg, str, i16, i3, true);
        if (a16 == null) {
            a16 = new SSOReserveField.ReserveFields();
        }
        a16.newconn_flag.set(0);
        return a16.toByteArray();
    }

    @Nullable
    private static SSOReserveField.ReserveFields a(ToServiceMsg toServiceMsg, String str, int i3, int i16, boolean z16) {
        byte[] bArr;
        try {
            SSOReserveField.ReserveFields reserveFields = new SSOReserveField.ReserveFields();
            int i17 = MsfCore.mLocaleId;
            if (i17 > 0) {
                reserveFields.locale_id.set(i17);
            }
            if (2 <= i3 && (bArr = Y) != null) {
                reserveFields.client_ipcookie.set(ByteStringMicro.copyFrom(bArr));
            }
            if (!com.tencent.mobileqq.msf.core.x.o.x().f().contains(str) || !com.tencent.mobileqq.msf.core.x.m.h()) {
                reserveFields.uid.set(MsfCore.sCore.getAccountCenter().g().d(toServiceMsg.getUin()));
            }
            reserveFields.nt_core_version.set(BaseApplication.getContext().getNTCoreVersion());
            int activeNetIpFamily = NetConnInfoCenter.getActiveNetIpFamily(false);
            if (activeNetIpFamily == 1) {
                reserveFields.ip_stack_type.set(1);
            } else if (activeNetIpFamily == 2) {
                reserveFields.ip_stack_type.set(2);
            } else if (activeNetIpFamily == 3) {
                reserveFields.ip_stack_type.set(3);
            } else {
                reserveFields.ip_stack_type.set(0);
            }
            reserveFields.network_type.set(i16);
            if (toServiceMsg.getAttributes().containsKey(BaseConstants.TPS_TELEMETRY_TRACING_INFO)) {
                reserveFields.trace_parent.set(toServiceMsg.getTraceInfo());
            }
            String b16 = com.tencent.mobileqq.msf.core.e0.k.c().b();
            if (!BaseApplication.getContext().getMSFInterfaceAdapter().isGrayVersion() && !BaseApplication.getContext().getMSFInterfaceAdapter().isPublicVersion() && !TextUtils.isEmpty(b16)) {
                reserveFields.env.set(b16);
            }
            reserveFields.message_type.set(f(toServiceMsg));
            int i18 = (TextUtils.isEmpty(NetConnInfoCenter.getCurrentSSID()) || NetConnInfoCenter.getCurrentSSID().equals(BaseConstants.UNKNOWN_SSID_STRING)) ? 1 : 0;
            if (MsfService.getCore().isWeakNet()) {
                i18 |= 2;
            }
            reserveFields.flag.set(i18);
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, byte[]> entry : toServiceMsg.getTransInfo().entrySet()) {
                if (entry != null && com.tencent.mobileqq.msf.core.x.o.x().k().contains(entry.getKey())) {
                    SSOReserveField.SsoMapEntry ssoMapEntry = new SSOReserveField.SsoMapEntry();
                    ssoMapEntry.key.set(entry.getKey());
                    ssoMapEntry.value.set(ByteStringMicro.copyFrom(entry.getValue()));
                    arrayList.add(ssoMapEntry);
                }
            }
            if (!arrayList.isEmpty()) {
                reserveFields.trans_info.set(arrayList);
            }
            a(reserveFields, toServiceMsg, str, Boolean.valueOf(z16));
            a(reserveFields, Boolean.valueOf(z16));
            return reserveFields;
        } catch (Exception e16) {
            QLog.d("MSF.C.NetConnTag.", 1, "failed to construct reserve field", e16);
            return null;
        }
    }

    private static void a(SSOReserveField.ReserveFields reserveFields, Boolean bool) {
        if (bool.booleanValue() && com.tencent.mobileqq.msf.core.x.o.x().k().contains(BaseConstants.KEY_CLIENT_CONN_SEQ)) {
            List<SSOReserveField.SsoMapEntry> arrayList = new ArrayList<>();
            if (reserveFields.trans_info.has()) {
                arrayList = reserveFields.trans_info.get();
            }
            SSOReserveField.SsoMapEntry ssoMapEntry = new SSOReserveField.SsoMapEntry();
            ssoMapEntry.key.set(BaseConstants.KEY_CLIENT_CONN_SEQ);
            ssoMapEntry.value.set(ByteStringMicro.copyFrom(String.valueOf(MsfService.core.getConnSeq()).getBytes()));
            arrayList.add(ssoMapEntry);
            reserveFields.trans_info.set(arrayList);
        }
    }

    private static void a(SSOReserveField.ReserveFields reserveFields, ToServiceMsg toServiceMsg, String str, Boolean bool) {
        byte[] bArr;
        if (BaseApplication.getContext().getMSFInterfaceAdapter().isReleaseVersion() && com.tencent.mobileqq.msf.core.d0.a.c().a() == 0) {
            return;
        }
        try {
            if (!com.tencent.mobileqq.msf.core.d0.a.c().d()) {
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.mobileqq.msf.core.d0.a.c().a(MsfCore.sCore, o.k());
                if (QLog.isColorLevel()) {
                    QLog.d("MSF.C.NetConnTag." + bool, 2, "[FEKitManager], init cost: " + (System.currentTimeMillis() - currentTimeMillis));
                }
                toServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_SECURITY_INIT_COST_TIME, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            QQSecuritySign.SignResult a16 = com.tencent.mobileqq.msf.core.d0.a.c().a(toServiceMsg, str);
            if (a16 == null || (bArr = a16.sign) == null) {
                return;
            }
            int length = bArr.length;
            byte[] bArr2 = a16.token;
            int length2 = bArr2 == null ? 0 : bArr2.length;
            byte[] bArr3 = a16.extra;
            int length3 = bArr3 == null ? 0 : bArr3.length;
            if (QLog.isColorLevel()) {
                QLog.d("MSF.C.NetConnTag." + bool, 2, "[FEKitManager], set sign of cmd = " + str + "\n sign = " + MsfSdkUtils.getShortHexString(a16.sign, Math.min(length / 2, 8)) + ", len = " + length + "\n token = " + MsfSdkUtils.getShortHexString(a16.token, Math.min(length2 / 2, 8)) + ", len = " + length2 + "\n extra = " + MsfSdkUtils.getShortHexString(a16.extra, Math.min(length3 / 2, 8)) + ", len = " + length3);
            }
            SSOReserveField.SsoSecureInfo ssoSecureInfo = new SSOReserveField.SsoSecureInfo();
            ssoSecureInfo.sec_sig.set(ByteStringMicro.copyFrom(a16.sign));
            PBBytesField pBBytesField = ssoSecureInfo.sec_device_token;
            byte[] bArr4 = a16.token;
            if (bArr4 == null) {
                bArr4 = new byte[0];
            }
            pBBytesField.set(ByteStringMicro.copyFrom(bArr4));
            PBBytesField pBBytesField2 = ssoSecureInfo.sec_extra;
            byte[] bArr5 = a16.extra;
            if (bArr5 == null) {
                bArr5 = new byte[0];
            }
            pBBytesField2.set(ByteStringMicro.copyFrom(bArr5));
            reserveFields.sec_info.set(ssoSecureInfo);
            toServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_IS_SECURITY_SIGN, Boolean.TRUE);
            toServiceMsg.addAttribute(BaseConstants.ATTRIBUTE_KEY_SECURITY_SIGN_COST_TIME, Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        } catch (Exception e16) {
            QLog.e("MSF.C.NetConnTag." + bool, 1, "[FEKitManager] set sign error", e16);
        }
    }
}
