package com.tencent.mobileqq.ar.arengine;

import android.opengl.Matrix;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.FramePerformanceMonitor;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.aidl.ArConfigInfo;
import com.tencent.mobileqq.ar.model.ArFeatureInfo;
import com.tencent.mobileqq.ar.model.QQARSession;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.ytcommon.util.YTCommonInterface;
import com.youtu.arsdk.AROption;
import com.youtu.arsdk.ARPatternInfo;
import com.youtu.arsdk.ARShell;
import com.youtu.arsdk.ARTargetInfo;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARLocalMarkerRecog {
    private long Q;

    /* renamed from: f, reason: collision with root package name */
    private FramePerformanceMonitor f197896f;

    /* renamed from: g, reason: collision with root package name */
    private AROption f197897g;

    /* renamed from: a, reason: collision with root package name */
    private final int f197891a = 25;

    /* renamed from: b, reason: collision with root package name */
    private final int f197892b = 800;

    /* renamed from: c, reason: collision with root package name */
    private ProcessWorker f197893c = null;

    /* renamed from: d, reason: collision with root package name */
    private int f197894d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f197895e = 0;

    /* renamed from: h, reason: collision with root package name */
    Object f197898h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private Object f197899i = new Object();

    /* renamed from: j, reason: collision with root package name */
    private int f197900j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f197901k = 0;

    /* renamed from: l, reason: collision with root package name */
    private float[] f197902l = null;

    /* renamed from: m, reason: collision with root package name */
    private boolean f197903m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f197904n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f197905o = false;

    /* renamed from: p, reason: collision with root package name */
    private boolean f197906p = false;

    /* renamed from: q, reason: collision with root package name */
    private boolean f197907q = false;

    /* renamed from: r, reason: collision with root package name */
    private boolean f197908r = false;

    /* renamed from: s, reason: collision with root package name */
    private ArConfigInfo f197909s = null;

    /* renamed from: t, reason: collision with root package name */
    private ArrayList<ArCloudConfigInfo> f197910t = null;

    /* renamed from: u, reason: collision with root package name */
    private Map<String, ArCloudConfigInfo> f197911u = null;

    /* renamed from: v, reason: collision with root package name */
    private int f197912v = 2;

    /* renamed from: w, reason: collision with root package name */
    private int f197913w = 0;

    /* renamed from: x, reason: collision with root package name */
    private int f197914x = 0;

    /* renamed from: y, reason: collision with root package name */
    private int f197915y = -1;

    /* renamed from: z, reason: collision with root package name */
    private a f197916z = null;
    private Object A = new Object();
    private Object B = new Object();
    private ArrayList<b> C = null;
    private int D = 0;
    private int E = 0;
    private int F = 0;
    private int G = 0;
    private long H = 0;
    private long I = 0;
    private int J = 0;
    private String K = "";
    private int L = 0;
    private int M = 0;
    private long N = 0;
    private long O = 0;
    private long P = 0;
    private final int R = 5000;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class ProcessWorker extends BaseThread {
        private long C;
        byte[] E;
        private long H;
        private boolean I;
        private long J;
        private boolean D = false;
        private long G = com.tencent.mobileqq.ar.y.a().f198845e;
        private boolean F = true;

        public ProcessWorker() {
            this.E = new byte[((ARLocalMarkerRecog.this.f197894d * ARLocalMarkerRecog.this.f197895e) * 3) / 2];
            setDaemon(true);
            start();
        }

        public void o() {
            this.F = false;
            if (getState() == Thread.State.WAITING) {
                synchronized (this) {
                    notify();
                }
            }
        }

        void p(long j3, byte[] bArr) {
            if (getState() == Thread.State.WAITING) {
                if (ARLocalMarkerRecog.this.f197912v == 2) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if ((!this.I || currentTimeMillis - this.J >= 1500) && ((ARLocalMarkerRecog.this.Q == 0 || currentTimeMillis - ARLocalMarkerRecog.this.Q >= 5000) && ARLocalMarkerRecog.this.f197914x >= 2)) {
                        if (currentTimeMillis - this.H < this.G) {
                            return;
                        }
                        if (ARLocalMarkerRecog.this.Q != 0) {
                            ARLocalMarkerRecog.this.Q = 0L;
                        }
                    }
                    if (currentTimeMillis - this.H >= this.G) {
                        ARLocalMarkerRecog.this.f197914x = 0;
                    }
                }
                byte[] bArr2 = this.E;
                System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
                this.H = System.currentTimeMillis();
                this.C = j3;
                this.D = true;
                synchronized (this) {
                    notify();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:103:0x0299 A[Catch: Exception -> 0x0411, all -> 0x0414, TryCatch #7 {Exception -> 0x0411, blocks: (B:87:0x0238, B:175:0x023c, B:177:0x024b, B:90:0x024f, B:92:0x025b, B:93:0x0265, B:95:0x026b, B:100:0x0276, B:101:0x0291, B:103:0x0299, B:104:0x02a4, B:106:0x02ac, B:108:0x02b4, B:109:0x02d3, B:111:0x02dc, B:113:0x031b, B:115:0x0325, B:117:0x0335, B:118:0x039d, B:120:0x03a8, B:121:0x03ad, B:123:0x03b2, B:124:0x03b7, B:149:0x03b5, B:150:0x03ab, B:152:0x02e4, B:154:0x02ec, B:155:0x02f3, B:160:0x0303, B:163:0x0310, B:170:0x0281, B:172:0x028a, B:184:0x0225, B:186:0x022e), top: B:174:0x023c }] */
        /* JADX WARN: Removed duplicated region for block: B:106:0x02ac A[Catch: Exception -> 0x0411, all -> 0x0414, TryCatch #7 {Exception -> 0x0411, blocks: (B:87:0x0238, B:175:0x023c, B:177:0x024b, B:90:0x024f, B:92:0x025b, B:93:0x0265, B:95:0x026b, B:100:0x0276, B:101:0x0291, B:103:0x0299, B:104:0x02a4, B:106:0x02ac, B:108:0x02b4, B:109:0x02d3, B:111:0x02dc, B:113:0x031b, B:115:0x0325, B:117:0x0335, B:118:0x039d, B:120:0x03a8, B:121:0x03ad, B:123:0x03b2, B:124:0x03b7, B:149:0x03b5, B:150:0x03ab, B:152:0x02e4, B:154:0x02ec, B:155:0x02f3, B:160:0x0303, B:163:0x0310, B:170:0x0281, B:172:0x028a, B:184:0x0225, B:186:0x022e), top: B:174:0x023c }] */
        /* JADX WARN: Removed duplicated region for block: B:111:0x02dc A[Catch: Exception -> 0x0411, all -> 0x0414, TryCatch #7 {Exception -> 0x0411, blocks: (B:87:0x0238, B:175:0x023c, B:177:0x024b, B:90:0x024f, B:92:0x025b, B:93:0x0265, B:95:0x026b, B:100:0x0276, B:101:0x0291, B:103:0x0299, B:104:0x02a4, B:106:0x02ac, B:108:0x02b4, B:109:0x02d3, B:111:0x02dc, B:113:0x031b, B:115:0x0325, B:117:0x0335, B:118:0x039d, B:120:0x03a8, B:121:0x03ad, B:123:0x03b2, B:124:0x03b7, B:149:0x03b5, B:150:0x03ab, B:152:0x02e4, B:154:0x02ec, B:155:0x02f3, B:160:0x0303, B:163:0x0310, B:170:0x0281, B:172:0x028a, B:184:0x0225, B:186:0x022e), top: B:174:0x023c }] */
        /* JADX WARN: Removed duplicated region for block: B:115:0x0325 A[Catch: Exception -> 0x0411, all -> 0x0414, TryCatch #7 {Exception -> 0x0411, blocks: (B:87:0x0238, B:175:0x023c, B:177:0x024b, B:90:0x024f, B:92:0x025b, B:93:0x0265, B:95:0x026b, B:100:0x0276, B:101:0x0291, B:103:0x0299, B:104:0x02a4, B:106:0x02ac, B:108:0x02b4, B:109:0x02d3, B:111:0x02dc, B:113:0x031b, B:115:0x0325, B:117:0x0335, B:118:0x039d, B:120:0x03a8, B:121:0x03ad, B:123:0x03b2, B:124:0x03b7, B:149:0x03b5, B:150:0x03ab, B:152:0x02e4, B:154:0x02ec, B:155:0x02f3, B:160:0x0303, B:163:0x0310, B:170:0x0281, B:172:0x028a, B:184:0x0225, B:186:0x022e), top: B:174:0x023c }] */
        /* JADX WARN: Removed duplicated region for block: B:131:0x03ef A[Catch: Exception -> 0x040f, all -> 0x0414, TryCatch #1 {Exception -> 0x040f, blocks: (B:148:0x03bc, B:128:0x03c0, B:129:0x03e7, B:131:0x03ef, B:133:0x03f7, B:135:0x03ff), top: B:147:0x03bc }] */
        /* JADX WARN: Removed duplicated region for block: B:145:0x0422 A[Catch: all -> 0x0414, TRY_LEAVE, TryCatch #11 {all -> 0x0414, blocks: (B:33:0x004f, B:35:0x0057, B:36:0x005d, B:56:0x00c0, B:60:0x00c1, B:63:0x00cb, B:64:0x00d5, B:182:0x01f7, B:87:0x0238, B:175:0x023c, B:177:0x024b, B:90:0x024f, B:92:0x025b, B:93:0x0265, B:95:0x026b, B:99:0x0274, B:100:0x0276, B:101:0x0291, B:103:0x0299, B:104:0x02a4, B:106:0x02ac, B:108:0x02b4, B:109:0x02d3, B:111:0x02dc, B:113:0x031b, B:115:0x0325, B:117:0x0335, B:118:0x039d, B:120:0x03a8, B:121:0x03ad, B:123:0x03b2, B:124:0x03b7, B:148:0x03bc, B:128:0x03c0, B:129:0x03e7, B:131:0x03ef, B:133:0x03f7, B:135:0x03ff, B:143:0x0419, B:145:0x0422, B:149:0x03b5, B:150:0x03ab, B:152:0x02e4, B:154:0x02ec, B:155:0x02f3, B:158:0x02fc, B:160:0x0303, B:163:0x0310, B:170:0x0281, B:172:0x028a, B:86:0x0205, B:184:0x0225, B:186:0x022e, B:189:0x021d), top: B:32:0x004f, outer: #17 }] */
        /* JADX WARN: Removed duplicated region for block: B:151:0x03e6  */
        /* JADX WARN: Removed duplicated region for block: B:152:0x02e4 A[Catch: Exception -> 0x0411, all -> 0x0414, TryCatch #7 {Exception -> 0x0411, blocks: (B:87:0x0238, B:175:0x023c, B:177:0x024b, B:90:0x024f, B:92:0x025b, B:93:0x0265, B:95:0x026b, B:100:0x0276, B:101:0x0291, B:103:0x0299, B:104:0x02a4, B:106:0x02ac, B:108:0x02b4, B:109:0x02d3, B:111:0x02dc, B:113:0x031b, B:115:0x0325, B:117:0x0335, B:118:0x039d, B:120:0x03a8, B:121:0x03ad, B:123:0x03b2, B:124:0x03b7, B:149:0x03b5, B:150:0x03ab, B:152:0x02e4, B:154:0x02ec, B:155:0x02f3, B:160:0x0303, B:163:0x0310, B:170:0x0281, B:172:0x028a, B:184:0x0225, B:186:0x022e), top: B:174:0x023c }] */
        /* JADX WARN: Removed duplicated region for block: B:172:0x028a A[Catch: Exception -> 0x0411, all -> 0x0414, TryCatch #7 {Exception -> 0x0411, blocks: (B:87:0x0238, B:175:0x023c, B:177:0x024b, B:90:0x024f, B:92:0x025b, B:93:0x0265, B:95:0x026b, B:100:0x0276, B:101:0x0291, B:103:0x0299, B:104:0x02a4, B:106:0x02ac, B:108:0x02b4, B:109:0x02d3, B:111:0x02dc, B:113:0x031b, B:115:0x0325, B:117:0x0335, B:118:0x039d, B:120:0x03a8, B:121:0x03ad, B:123:0x03b2, B:124:0x03b7, B:149:0x03b5, B:150:0x03ab, B:152:0x02e4, B:154:0x02ec, B:155:0x02f3, B:160:0x0303, B:163:0x0310, B:170:0x0281, B:172:0x028a, B:184:0x0225, B:186:0x022e), top: B:174:0x023c }] */
        /* JADX WARN: Removed duplicated region for block: B:173:0x0264  */
        /* JADX WARN: Removed duplicated region for block: B:174:0x023c A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:92:0x025b A[Catch: Exception -> 0x0411, all -> 0x0414, TryCatch #7 {Exception -> 0x0411, blocks: (B:87:0x0238, B:175:0x023c, B:177:0x024b, B:90:0x024f, B:92:0x025b, B:93:0x0265, B:95:0x026b, B:100:0x0276, B:101:0x0291, B:103:0x0299, B:104:0x02a4, B:106:0x02ac, B:108:0x02b4, B:109:0x02d3, B:111:0x02dc, B:113:0x031b, B:115:0x0325, B:117:0x0335, B:118:0x039d, B:120:0x03a8, B:121:0x03ad, B:123:0x03b2, B:124:0x03b7, B:149:0x03b5, B:150:0x03ab, B:152:0x02e4, B:154:0x02ec, B:155:0x02f3, B:160:0x0303, B:163:0x0310, B:170:0x0281, B:172:0x028a, B:184:0x0225, B:186:0x022e), top: B:174:0x023c }] */
        /* JADX WARN: Removed duplicated region for block: B:95:0x026b A[Catch: Exception -> 0x0411, all -> 0x0414, TRY_LEAVE, TryCatch #7 {Exception -> 0x0411, blocks: (B:87:0x0238, B:175:0x023c, B:177:0x024b, B:90:0x024f, B:92:0x025b, B:93:0x0265, B:95:0x026b, B:100:0x0276, B:101:0x0291, B:103:0x0299, B:104:0x02a4, B:106:0x02ac, B:108:0x02b4, B:109:0x02d3, B:111:0x02dc, B:113:0x031b, B:115:0x0325, B:117:0x0335, B:118:0x039d, B:120:0x03a8, B:121:0x03ad, B:123:0x03b2, B:124:0x03b7, B:149:0x03b5, B:150:0x03ab, B:152:0x02e4, B:154:0x02ec, B:155:0x02f3, B:160:0x0303, B:163:0x0310, B:170:0x0281, B:172:0x028a, B:184:0x0225, B:186:0x022e), top: B:174:0x023c }] */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int, boolean] */
        /* JADX WARN: Type inference failed for: r2v7 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:182:? -> B:178:0x0220). Please report as a decompilation issue!!! */
        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public synchronized void run() {
            boolean z16;
            ARTargetInfo[] aRTargetInfoArr;
            ARLocalMarkerRecog aRLocalMarkerRecog;
            boolean z17;
            int i3;
            int i16;
            ARTargetInfo aRTargetInfo;
            int i17;
            ARLocalMarkerRecog aRLocalMarkerRecog2;
            int i18;
            int i19;
            z zVar;
            float f16;
            float f17;
            float f18;
            long j3;
            long currentTimeMillis;
            int nativeTrack;
            int i26;
            int i27;
            ARTargetInfo[] aRTargetInfoArr2;
            setName("ProcessWorker");
            ?? r26 = 1;
            ARTargetInfo[] allocateInitialized = ARTargetInfo.allocateInitialized(1);
            while (this.F) {
                while (!this.D && this.F) {
                    try {
                        LockMethodProxy.wait(this);
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                        if (QLog.isColorLevel()) {
                            QLog.i("AREngine_ARLocalMarkerRecog", 2, "InterruptedException", e16);
                        }
                    }
                }
                if (!this.F) {
                    return;
                }
                this.D = false;
                System.currentTimeMillis();
                synchronized (ARLocalMarkerRecog.this.f197899i) {
                    ARLocalMarkerRecog.this.f197907q = r26;
                    try {
                        try {
                            if (ARLocalMarkerRecog.this.f197912v == 2) {
                                synchronized (ARLocalMarkerRecog.this.A) {
                                    for (int i28 = 0; i28 < ARLocalMarkerRecog.this.C.size(); i28++) {
                                        if (!((b) ARLocalMarkerRecog.this.C.get(i28)).f197920d) {
                                            ARLocalMarkerRecog aRLocalMarkerRecog3 = ARLocalMarkerRecog.this;
                                            if (aRLocalMarkerRecog3.L(((b) aRLocalMarkerRecog3.C.get(i28)).f197917a, ((b) ARLocalMarkerRecog.this.C.get(i28)).f197918b, ((b) ARLocalMarkerRecog.this.C.get(i28)).f197919c)) {
                                                ((b) ARLocalMarkerRecog.this.C.get(i28)).f197920d = r26;
                                            }
                                        }
                                    }
                                }
                            }
                            i3 = ARLocalMarkerRecog.this.f197912v;
                            try {
                                long currentTimeMillis2 = System.currentTimeMillis();
                                synchronized (ARLocalMarkerRecog.this.B) {
                                    if (i3 == 2) {
                                        j3 = currentTimeMillis2;
                                        try {
                                            long currentTimeMillis3 = System.currentTimeMillis();
                                            int nativeRecognize = ARShell.nativeRecognize(this.E, allocateInitialized);
                                            try {
                                                ARTargetInfo aRTargetInfo2 = allocateInitialized[0];
                                                if (nativeRecognize == 0 && aRTargetInfo2.pose[14] >= -800.0f) {
                                                    i27 = 0;
                                                } else {
                                                    i27 = 2;
                                                }
                                                aRTargetInfo2.state = i27;
                                                long currentTimeMillis4 = System.currentTimeMillis();
                                                ARLocalMarkerRecog.this.L += r26;
                                                ARLocalMarkerRecog.this.N += currentTimeMillis4 - j3;
                                                long currentTimeMillis5 = System.currentTimeMillis();
                                                if (i3 != allocateInitialized[0].state) {
                                                    StringBuilder sb5 = new StringBuilder();
                                                    sb5.append("ARTimeTest. recog. timelen = ");
                                                    aRTargetInfoArr2 = allocateInitialized;
                                                    try {
                                                        sb5.append(currentTimeMillis5 - currentTimeMillis3);
                                                        sb5.append(", starttime = ");
                                                        sb5.append(currentTimeMillis3);
                                                        sb5.append(", endtime = ");
                                                        sb5.append(currentTimeMillis5);
                                                        sb5.append(", target[0].state = ");
                                                        sb5.append(aRTargetInfoArr2[0].state);
                                                        QLog.i("AREngine_ARLocalMarkerRecog", 1, sb5.toString());
                                                    } catch (Throwable th5) {
                                                        th = th5;
                                                        i16 = nativeRecognize;
                                                        aRTargetInfoArr = aRTargetInfoArr2;
                                                        throw th;
                                                        break;
                                                    }
                                                } else {
                                                    aRTargetInfoArr2 = allocateInitialized;
                                                }
                                                i16 = nativeRecognize;
                                                aRTargetInfoArr = aRTargetInfoArr2;
                                            } catch (Throwable th6) {
                                                th = th6;
                                                aRTargetInfoArr = allocateInitialized;
                                                i16 = nativeRecognize;
                                            }
                                        } catch (Throwable th7) {
                                            th = th7;
                                            aRTargetInfoArr = allocateInitialized;
                                            i16 = -1;
                                            throw th;
                                            break;
                                            break;
                                        }
                                    } else {
                                        ARTargetInfo[] aRTargetInfoArr3 = allocateInitialized;
                                        j3 = currentTimeMillis2;
                                        try {
                                            currentTimeMillis = System.currentTimeMillis();
                                            aRTargetInfoArr = aRTargetInfoArr3;
                                        } catch (Throwable th8) {
                                            th = th8;
                                            aRTargetInfoArr = aRTargetInfoArr3;
                                        }
                                        try {
                                            nativeTrack = ARShell.nativeTrack(this.E, aRTargetInfoArr);
                                        } catch (Throwable th9) {
                                            th = th9;
                                            i16 = -1;
                                            throw th;
                                            break;
                                            break;
                                        }
                                        try {
                                            ARTargetInfo aRTargetInfo3 = aRTargetInfoArr[0];
                                            if (nativeTrack == 0 && aRTargetInfo3.pose[14] >= -800.0f) {
                                                i26 = 1;
                                            } else {
                                                i26 = 2;
                                            }
                                            aRTargetInfo3.state = i26;
                                            long currentTimeMillis6 = System.currentTimeMillis();
                                            if (i3 != aRTargetInfoArr[0].state) {
                                                QLog.i("AREngine_ARLocalMarkerRecog", 1, "ARTimeTest. track. timelen = " + (currentTimeMillis6 - currentTimeMillis) + ", starttime = " + currentTimeMillis + ", endtime = " + currentTimeMillis6 + ", target[0].state = " + aRTargetInfoArr[0].state);
                                            }
                                            long currentTimeMillis7 = System.currentTimeMillis();
                                            ARLocalMarkerRecog.this.M++;
                                            ARLocalMarkerRecog.this.O += currentTimeMillis7 - j3;
                                            i16 = nativeTrack;
                                        } catch (Throwable th10) {
                                            th = th10;
                                            i16 = nativeTrack;
                                            throw th;
                                            break;
                                            break;
                                        }
                                    }
                                    try {
                                    } catch (Throwable th11) {
                                        th = th11;
                                        throw th;
                                        break;
                                        break;
                                    }
                                }
                                if (i3 == 2) {
                                    try {
                                        com.tencent.mobileqq.ar.a.a().d(System.currentTimeMillis() - j3);
                                    } catch (Exception e17) {
                                        e = e17;
                                        e.printStackTrace();
                                        if (QLog.isColorLevel()) {
                                            QLog.d("AREngine_ARLocalMarkerRecog", 2, "Recognize/Track", e);
                                        }
                                        ARLocalMarkerRecog aRLocalMarkerRecog4 = ARLocalMarkerRecog.this;
                                        if (i16 == 0) {
                                        }
                                        i17 = 2;
                                        aRLocalMarkerRecog4.f197912v = i17;
                                        aRLocalMarkerRecog2 = ARLocalMarkerRecog.this;
                                        if (aRLocalMarkerRecog2.f197912v == 2) {
                                        }
                                        aRLocalMarkerRecog2.f197914x = i18;
                                        if (i3 == 2) {
                                        }
                                        if (ARLocalMarkerRecog.this.f197912v != 2) {
                                        }
                                        if (ARLocalMarkerRecog.this.G == 0) {
                                        }
                                        if (ARLocalMarkerRecog.this.f197912v == 0) {
                                        }
                                        if (ARLocalMarkerRecog.this.f197912v == 2) {
                                        }
                                        i19 = 2;
                                        zVar = new z();
                                        zVar.f198323c = i19;
                                        if (i19 == 2) {
                                        }
                                        if (ARLocalMarkerRecog.this.f197904n) {
                                        }
                                        aRLocalMarkerRecog = ARLocalMarkerRecog.this;
                                        z17 = false;
                                        aRLocalMarkerRecog.f197907q = z17;
                                        Thread.yield();
                                        r26 = z16;
                                        allocateInitialized = aRTargetInfoArr;
                                    }
                                } else {
                                    com.tencent.mobileqq.ar.a.a().e(System.currentTimeMillis() - j3);
                                }
                            } catch (Exception e18) {
                                e = e18;
                                aRTargetInfoArr = allocateInitialized;
                                i16 = -1;
                            }
                            ARLocalMarkerRecog aRLocalMarkerRecog42 = ARLocalMarkerRecog.this;
                        } finally {
                        }
                    } catch (Exception e19) {
                        e = e19;
                        z16 = r26;
                        aRTargetInfoArr = allocateInitialized;
                    }
                    if (i16 == 0) {
                        try {
                            aRTargetInfo = aRTargetInfoArr[0];
                        } catch (Exception e26) {
                            e = e26;
                            z16 = true;
                            e.printStackTrace();
                            if (QLog.isColorLevel()) {
                            }
                            aRLocalMarkerRecog = ARLocalMarkerRecog.this;
                            z17 = false;
                            aRLocalMarkerRecog.f197907q = z17;
                            Thread.yield();
                            r26 = z16;
                            allocateInitialized = aRTargetInfoArr;
                        }
                        if (aRTargetInfo.pose[14] >= -800.0f) {
                            i17 = aRTargetInfo.state;
                            aRLocalMarkerRecog42.f197912v = i17;
                            aRLocalMarkerRecog2 = ARLocalMarkerRecog.this;
                            if (aRLocalMarkerRecog2.f197912v == 2) {
                                i18 = ARLocalMarkerRecog.this.f197914x + 1;
                            } else {
                                i18 = 0;
                            }
                            aRLocalMarkerRecog2.f197914x = i18;
                            if (i3 == 2 && ARLocalMarkerRecog.this.f197912v == 2) {
                                try {
                                    this.I = true;
                                    this.J = System.currentTimeMillis();
                                } catch (Exception e27) {
                                    e = e27;
                                    z16 = true;
                                    e.printStackTrace();
                                    if (QLog.isColorLevel()) {
                                    }
                                    aRLocalMarkerRecog = ARLocalMarkerRecog.this;
                                    z17 = false;
                                    aRLocalMarkerRecog.f197907q = z17;
                                    Thread.yield();
                                    r26 = z16;
                                    allocateInitialized = aRTargetInfoArr;
                                }
                            } else if (ARLocalMarkerRecog.this.f197912v != 2) {
                                this.I = false;
                                this.J = 0L;
                            }
                            if (ARLocalMarkerRecog.this.G == 0) {
                                ARLocalMarkerRecog.this.J++;
                            }
                            if (ARLocalMarkerRecog.this.f197912v == 0 && ARLocalMarkerRecog.this.G == 0) {
                                ARLocalMarkerRecog.this.I = System.currentTimeMillis();
                                ARLocalMarkerRecog aRLocalMarkerRecog5 = ARLocalMarkerRecog.this;
                                aRLocalMarkerRecog5.G = (int) (aRLocalMarkerRecog5.I - ARLocalMarkerRecog.this.H);
                                ARLocalMarkerRecog.this.K = "";
                            }
                            if (ARLocalMarkerRecog.this.f197912v == 2) {
                                ARLocalMarkerRecog.this.f197913w = 0;
                            } else if (ARLocalMarkerRecog.this.f197912v == 0) {
                                ARLocalMarkerRecog.this.f197913w = 0;
                            } else if (ARLocalMarkerRecog.this.f197912v == 1) {
                                ARLocalMarkerRecog.this.f197913w++;
                                i19 = 2;
                                if (ARLocalMarkerRecog.this.f197913w >= 2) {
                                    if (ARLocalMarkerRecog.this.f197913w == 2) {
                                        i19 = 0;
                                    } else {
                                        i19 = 1;
                                    }
                                }
                                zVar = new z();
                                zVar.f198323c = i19;
                                if (i19 == 2) {
                                    ARPatternInfo aRPatternInfo = new ARPatternInfo();
                                    ARShell.getMarkerInfo(aRTargetInfoArr[0].markerIndex, aRPatternInfo);
                                    if (i19 == 0) {
                                        QLog.i("AREngine_ARLocalMarkerRecog", 1, "getMarkerInfo. name = " + aRPatternInfo.name + ", markerType = " + aRPatternInfo.markerType + ", index = " + aRPatternInfo.index + ", xSize = " + aRPatternInfo.xSize + ", ySize = " + aRPatternInfo.ySize + ", param1 = " + aRPatternInfo.param1 + ", param2 = " + aRPatternInfo.param2 + ", param3 = " + aRPatternInfo.param3);
                                    }
                                    zVar.f198324d = aRPatternInfo.name;
                                    int i29 = aRPatternInfo.markerType;
                                    zVar.f198325e = i29;
                                    if (i29 == 1) {
                                        f16 = aRPatternInfo.param1;
                                    } else {
                                        f16 = aRPatternInfo.xSize;
                                    }
                                    zVar.f198326f = f16;
                                    if (i29 == 1) {
                                        f17 = aRPatternInfo.param2;
                                    } else {
                                        f17 = aRPatternInfo.ySize;
                                    }
                                    zVar.f198327g = f17;
                                    z16 = true;
                                    if (i29 == 1) {
                                        try {
                                            f18 = aRPatternInfo.param3;
                                        } catch (Exception e28) {
                                            e = e28;
                                            e.printStackTrace();
                                            if (QLog.isColorLevel()) {
                                                QLog.d("AREngine_ARLocalMarkerRecog", 2, "Exception", e);
                                            }
                                            aRLocalMarkerRecog = ARLocalMarkerRecog.this;
                                            z17 = false;
                                            aRLocalMarkerRecog.f197907q = z17;
                                            Thread.yield();
                                            r26 = z16;
                                            allocateInitialized = aRTargetInfoArr;
                                        }
                                    } else {
                                        f18 = 0.0f;
                                    }
                                    zVar.f198328h = f18;
                                    float[] fArr = new float[16];
                                    zVar.f198329i = fArr;
                                    float[] fArr2 = aRTargetInfoArr[0].pose;
                                    System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
                                    zVar.f198330j = (ArCloudConfigInfo) ARLocalMarkerRecog.this.f197911u.get(aRPatternInfo.name);
                                    zVar.f198322b = this.C;
                                } else {
                                    z16 = true;
                                }
                                if (ARLocalMarkerRecog.this.f197904n && !ARLocalMarkerRecog.this.f197908r && ARLocalMarkerRecog.this.f197916z != null) {
                                    ARLocalMarkerRecog.this.f197916z.a(zVar);
                                }
                                aRLocalMarkerRecog = ARLocalMarkerRecog.this;
                                z17 = false;
                                aRLocalMarkerRecog.f197907q = z17;
                                Thread.yield();
                            }
                            i19 = 2;
                            zVar = new z();
                            zVar.f198323c = i19;
                            if (i19 == 2) {
                            }
                            if (ARLocalMarkerRecog.this.f197904n) {
                                ARLocalMarkerRecog.this.f197916z.a(zVar);
                            }
                            aRLocalMarkerRecog = ARLocalMarkerRecog.this;
                            z17 = false;
                            aRLocalMarkerRecog.f197907q = z17;
                            Thread.yield();
                        }
                    }
                    i17 = 2;
                    aRLocalMarkerRecog42.f197912v = i17;
                    aRLocalMarkerRecog2 = ARLocalMarkerRecog.this;
                    if (aRLocalMarkerRecog2.f197912v == 2) {
                    }
                    aRLocalMarkerRecog2.f197914x = i18;
                    if (i3 == 2) {
                    }
                    if (ARLocalMarkerRecog.this.f197912v != 2) {
                    }
                    if (ARLocalMarkerRecog.this.G == 0) {
                    }
                    if (ARLocalMarkerRecog.this.f197912v == 0) {
                        ARLocalMarkerRecog.this.I = System.currentTimeMillis();
                        ARLocalMarkerRecog aRLocalMarkerRecog52 = ARLocalMarkerRecog.this;
                        aRLocalMarkerRecog52.G = (int) (aRLocalMarkerRecog52.I - ARLocalMarkerRecog.this.H);
                        ARLocalMarkerRecog.this.K = "";
                    }
                    if (ARLocalMarkerRecog.this.f197912v == 2) {
                    }
                    i19 = 2;
                    zVar = new z();
                    zVar.f198323c = i19;
                    if (i19 == 2) {
                    }
                    if (ARLocalMarkerRecog.this.f197904n) {
                    }
                    aRLocalMarkerRecog = ARLocalMarkerRecog.this;
                    z17 = false;
                    aRLocalMarkerRecog.f197907q = z17;
                    Thread.yield();
                }
                r26 = z16;
                allocateInitialized = aRTargetInfoArr;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void a(z zVar);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f197917a = "";

        /* renamed from: b, reason: collision with root package name */
        public String f197918b = "";

        /* renamed from: c, reason: collision with root package name */
        public ArCloudConfigInfo f197919c = null;

        /* renamed from: d, reason: collision with root package name */
        public boolean f197920d = false;

        /* renamed from: e, reason: collision with root package name */
        public boolean f197921e = false;

        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean L(String str, String str2, ArCloudConfigInfo arCloudConfigInfo) {
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "addNewMarkerDynamically. markerName = " + str + ", markerFilePath = " + str2);
        ARPatternInfo aRPatternInfo = new ARPatternInfo();
        for (int i3 = 0; i3 < ARShell.getMarkerCount(); i3++) {
            aRPatternInfo.name = "";
            ARShell.getMarkerInfo(i3, aRPatternInfo);
            if (aRPatternInfo.name.equals(str)) {
                QLog.i("ARCloudEngine", 1, "addNewMarkerDynamically. marker already exist.");
                return true;
            }
        }
        this.f197911u.put(arCloudConfigInfo.E.f198409d, arCloudConfigInfo);
        synchronized (this.B) {
            QLog.i("ARCloudEngine", 1, "addNewMarkerDynamically start.");
            System.currentTimeMillis();
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker start. markerName = " + str);
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker end. ret = " + ARShell.nativeAddMarker(str, str2));
        }
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "addNewMarkerDynamically successfully.");
        return true;
    }

    private boolean X() {
        int i3 = 0;
        while (this.f197907q && (i3 = i3 + 1) < 20) {
            try {
                try {
                    LockMethodProxy.sleep(100L);
                } catch (Exception unused) {
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARLocalMarkerRecog", 2, "recognize is running, wait for 100ms to destroy.");
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        synchronized (this.B) {
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeStop start.");
            ARShell.nativeStop();
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeStop end.");
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeDestroy start.");
            ARShell.nativeDestroy();
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeDestroy end.");
        }
        return true;
    }

    public boolean K(String str, String str2, ArCloudConfigInfo arCloudConfigInfo) {
        if (!this.f197904n) {
            return false;
        }
        if (!arCloudConfigInfo.f197699e.equalsIgnoreCase(SemanticAttributes.HttpFlavorValues.HTTP_2_0)) {
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "addNewMarkerDynamically failed. sdk version error. sdk version = " + arCloudConfigInfo.f197699e);
            return false;
        }
        synchronized (this.A) {
            for (int i3 = 0; i3 < this.C.size(); i3++) {
                if (this.C.get(i3).f197917a.equals(str)) {
                    this.C.get(i3).f197918b = str2;
                    this.C.get(i3).f197919c = arCloudConfigInfo;
                    return true;
                }
            }
            b bVar = new b();
            bVar.f197917a = str;
            bVar.f197918b = str2;
            bVar.f197919c = arCloudConfigInfo;
            bVar.f197920d = false;
            bVar.f197921e = false;
            this.C.add(bVar);
            this.Q = System.currentTimeMillis();
            return true;
        }
    }

    public void M() {
        int i3;
        long j3;
        long j16;
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "dataReport. mDataReportRecogQuality = " + this.D + ", mDataReportLoadedFeatureTimeLen = " + this.E + ", mDataReportLoadedFeatureCnt = " + this.F + ", mDataReportFirstRecogSuccessTimeLen = " + this.G + ", mDataReportFirstRecogSuccessStartTime = " + this.H + ", mDataReportFirstRecogSuccessEndTime = " + this.I + ", mDataReportFirstRecogSuccessFrameCnt = " + this.J + ", mDataReportFirstRecogSuccessFeatureId = " + this.K);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("YOUTU_AR_PERF:, init sdk cost  = ");
        sb5.append(this.P);
        sb5.append(", addFeature(1 marker) cost  = ");
        int i16 = this.F;
        if (i16 == 0) {
            i3 = 0;
        } else {
            i3 = this.E / i16;
        }
        sb5.append(i3);
        sb5.append(", recog cost = ");
        int i17 = this.L;
        if (i17 == 0) {
            j3 = 0;
        } else {
            j3 = this.N / i17;
        }
        sb5.append(j3);
        sb5.append(", track cost = ");
        int i18 = this.M;
        if (i18 == 0) {
            j16 = 0;
        } else {
            j16 = this.O / i18;
        }
        sb5.append(j16);
        sb5.append(", recog suc from start  = ");
        sb5.append(this.G);
        QLog.i("AREngine_ARLocalMarkerRecog", 1, sb5.toString());
        ARReport.c().p(this.E, this.F, this.G, this.J, this.D, this.K);
        this.M = 0;
        this.L = 0;
        this.O = 0L;
        this.N = 0L;
    }

    public float[] N(int i3, int i16) {
        if (!this.f197903m) {
            return null;
        }
        if (this.f197900j == i3 && this.f197901k == i16) {
            return this.f197902l;
        }
        this.f197900j = i3;
        this.f197901k = i16;
        float[] fArr = new float[16];
        ARShell.getProjectionMatrix(25.0f, 800.0f, fArr, false);
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. getProjectionMatrix. proMatrix[0] = " + fArr[0] + ", proMatrix[1] = " + fArr[1] + ", proMatrix[2] = " + fArr[2] + ", proMatrix[3] = " + fArr[3] + ", proMatrix[4] = " + fArr[4] + ", proMatrix[5] = " + fArr[5] + ", proMatrix[6] = " + fArr[6] + ", proMatrix[7] = " + fArr[7] + ", proMatrix[8] = " + fArr[8] + ", proMatrix[9] = " + fArr[9] + ", proMatrix[10] = " + fArr[10] + ", proMatrix[11] = " + fArr[11] + ", proMatrix[12] = " + fArr[12] + ", proMatrix[13] = " + fArr[13] + ", proMatrix[14] = " + fArr[14] + ", proMatrix[15] = " + fArr[15]);
        int i17 = this.f197900j;
        int i18 = this.f197901k;
        float f16 = (((float) i17) * 1.0f) / ((float) i18);
        int i19 = this.f197895e;
        int i26 = this.f197894d;
        float f17 = (((float) i19) * 1.0f) / ((float) i26);
        if (f16 > f17) {
            float f18 = ((((i26 * i17) * 1.0f) / i19) / i18) * 1.0f;
            fArr[0] = fArr[0] * f18;
            fArr[8] = fArr[8] * f18;
        } else if (f16 < f17) {
            float f19 = ((((i19 * i18) * 1.0f) / i26) / i17) * 1.0f;
            fArr[5] = fArr[5] * f19;
            fArr[9] = fArr[9] * f19;
        }
        this.f197902l = fArr;
        float[] fArr2 = new float[16];
        if (((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68993g)) {
            Matrix.setRotateM(fArr2, 0, 90.0f, 0.0f, 0.0f, 1.0f);
        } else {
            Matrix.setRotateM(fArr2, 0, 270.0f, 0.0f, 0.0f, 1.0f);
        }
        float[] fArr3 = this.f197902l;
        Matrix.multiplyMM(fArr3, 0, fArr2, 0, fArr3, 0);
        return this.f197902l;
    }

    public boolean O(int i3, int i16, ArConfigInfo arConfigInfo, ArrayList<ArCloudConfigInfo> arrayList, a aVar) {
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "init start. imageWidth = " + i3 + ", imageHeight = " + i16);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f197903m) {
            return true;
        }
        boolean z16 = false;
        this.f197900j = 0;
        this.f197901k = 0;
        this.f197894d = i3;
        this.f197895e = i16;
        this.f197909s = arConfigInfo;
        this.f197910t = arrayList;
        this.C = new ArrayList<>();
        this.f197911u = new HashMap();
        this.f197916z = aVar;
        this.f197896f = null;
        this.f197903m = false;
        this.f197904n = false;
        this.f197905o = false;
        this.f197906p = false;
        this.f197907q = false;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = 0;
        this.H = 0L;
        this.I = 0L;
        this.J = 0;
        this.K = "";
        this.Q = 0L;
        try {
            long currentTimeMillis2 = System.currentTimeMillis();
            if (!ARShell.loadNativeLibrary()) {
                QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm failed. loadNativeLibrary failed.");
                ARReport.c().k(System.currentTimeMillis() - currentTimeMillis2, false);
            } else {
                ARReport.c().k(System.currentTimeMillis() - currentTimeMillis2, true);
                boolean P = P();
                if (!P) {
                    X();
                }
                z16 = P;
            }
        } catch (UnsatisfiedLinkError e16) {
            e16.printStackTrace();
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm failed. loadNativeLibrary failed. UnsatisfiedLinkError.");
        }
        this.f197903m = z16;
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "init end. mIsInited = " + this.f197903m);
        ARReport.c().l(System.currentTimeMillis() - currentTimeMillis, this.f197903m);
        return this.f197903m;
    }

    boolean P() {
        int i3;
        int i16;
        int nativeAddMarker;
        ArFeatureInfo arFeatureInfo;
        String str;
        int i17;
        long currentTimeMillis = System.currentTimeMillis();
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm. start = " + currentTimeMillis);
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm. initAuth ret = " + YTCommonInterface.initAuthForQQ(BaseApplicationImpl.getApplication().getApplicationContext()));
        AROption aROption = new AROption();
        this.f197897g = aROption;
        aROption.width = this.f197894d;
        aROption.height = this.f197895e;
        aROption.cameraParamPath = "";
        aROption.cachePath = "";
        if (u.g() == 0) {
            AROption aROption2 = this.f197897g;
            aROption2.recognizeQuality = 3;
            aROption2.trackQuality = 1;
            aROption2.performanceQuality = 3;
        } else {
            AROption aROption3 = this.f197897g;
            aROption3.recognizeQuality = 3;
            aROption3.trackQuality = 1;
            aROption3.performanceQuality = 2;
        }
        synchronized (this.B) {
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. ARSDKVersion = " + ARShell.getSDKVersion());
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeCreate start.");
            ARShell.nativeCreate(BaseApplicationImpl.getApplication().getApplicationContext());
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeCreate end.");
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeInitialize start. width = " + this.f197897g.width + ", height = " + this.f197897g.height + ", cameraParamPath = " + this.f197897g.cameraParamPath + ", recognizeQuality = " + this.f197897g.recognizeQuality + ", trackQuality = " + this.f197897g.trackQuality + ", performanceQuality = " + this.f197897g.performanceQuality);
            int nativeInitialize = ARShell.nativeInitialize(this.f197897g);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("YouTuNative. nativeInitialize end. ret = ");
            sb5.append(nativeInitialize);
            QLog.i("AREngine_ARLocalMarkerRecog", 1, sb5.toString());
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeStart start.");
            ARShell.nativeStart();
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeStart end.");
        }
        this.P = System.currentTimeMillis() - currentTimeMillis;
        ArConfigInfo arConfigInfo = this.f197909s;
        if (arConfigInfo != null && arConfigInfo.mArCloudConfigInfos != null) {
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "add marker for local. marker count = " + this.f197909s.mArCloudConfigInfos.size());
            i3 = 0;
            i16 = 0;
            for (int i18 = 0; i18 < this.f197909s.mArCloudConfigInfos.size(); i18++) {
                ArCloudConfigInfo arCloudConfigInfo = this.f197909s.mArCloudConfigInfos.get(i18);
                QLog.i("AREngine_ARLocalMarkerRecog", 1, "add marker for local. resource info = " + arCloudConfigInfo.toString());
                if (arCloudConfigInfo.f197699e.equalsIgnoreCase(SemanticAttributes.HttpFlavorValues.HTTP_2_0) && (arFeatureInfo = arCloudConfigInfo.E) != null && (str = arFeatureInfo.f198409d) != null) {
                    String str2 = arFeatureInfo.f198412h;
                    QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker start. markerName = " + str + ", markerFilePath = " + str2);
                    synchronized (this.B) {
                        try {
                            i17 = ARShell.nativeAddMarker(str, str2);
                        } catch (Exception e16) {
                            QLog.i("AREngine_ARLocalMarkerRecog", 1, "nativeAddMarker = " + e16.getMessage());
                            i17 = 0;
                        }
                    }
                    QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker end. ret = " + i17);
                    if (i17 == 0) {
                        i16++;
                        i3++;
                        this.f197911u.put(arCloudConfigInfo.E.f198409d, arCloudConfigInfo);
                    }
                }
            }
        } else {
            i3 = 0;
            i16 = 0;
        }
        if (!QQARSession.f198445n1 && this.f197910t != null) {
            QLog.i("AREngine_ARLocalMarkerRecog", 1, "add marker for cloud. marker count = " + this.f197910t.size());
            for (int i19 = 0; i19 < this.f197910t.size(); i19++) {
                ArCloudConfigInfo arCloudConfigInfo2 = this.f197910t.get(i19);
                if (arCloudConfigInfo2 != null && arCloudConfigInfo2.E != null) {
                    QLog.i("AREngine_ARLocalMarkerRecog", 1, "add marker for cloud. resource info = " + arCloudConfigInfo2.toString());
                    if (arCloudConfigInfo2.f197699e.equalsIgnoreCase(SemanticAttributes.HttpFlavorValues.HTTP_2_0)) {
                        ArFeatureInfo arFeatureInfo2 = arCloudConfigInfo2.E;
                        String str3 = arFeatureInfo2.f198409d;
                        String str4 = arFeatureInfo2.f198412h;
                        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker start. markerName = " + str3 + ", markerFilePath = " + str4);
                        synchronized (this.B) {
                            nativeAddMarker = ARShell.nativeAddMarker(str3, str4);
                        }
                        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. nativeAddMarker end. ret = " + nativeAddMarker);
                        if (nativeAddMarker == 0) {
                            i3++;
                            i16++;
                            this.f197911u.put(arCloudConfigInfo2.E.f198409d, arCloudConfigInfo2);
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        if (this.F == 0) {
            this.F = i3;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        if (this.E == 0) {
            this.E = (int) (currentTimeMillis2 - currentTimeMillis);
        }
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "YouTuNative. initAlgorithm successfully. timelen = " + (currentTimeMillis2 - currentTimeMillis) + ", starttime = " + currentTimeMillis + ", endtime = " + currentTimeMillis2 + ", featureCount = " + i16);
        return true;
    }

    public boolean Q() {
        return this.f197908r;
    }

    public void R(long j3, byte[] bArr) {
        ProcessWorker processWorker;
        if (bArr != null && this.f197904n && !this.f197908r && (processWorker = this.f197893c) != null) {
            processWorker.p(j3, bArr);
        }
    }

    public void S() {
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "pause. mIsPause = " + this.f197908r);
        if (this.f197908r) {
            return;
        }
        this.f197908r = true;
        this.f197912v = 2;
    }

    public void T() {
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "resume. mIsPause = " + this.f197908r);
        if (!this.f197908r) {
            return;
        }
        this.G = 0;
        this.H = System.currentTimeMillis();
        this.I = 0L;
        this.J = 0;
        this.K = "";
        this.f197908r = false;
    }

    public boolean U() {
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "start start.");
        if (this.f197904n) {
            return true;
        }
        this.C.clear();
        this.f197912v = 2;
        if (this.f197893c == null) {
            this.f197893c = new ProcessWorker();
        }
        this.G = 0;
        this.H = System.currentTimeMillis();
        this.I = 0L;
        this.J = 0;
        this.K = "";
        this.f197904n = true;
        this.f197908r = false;
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "start end. mIsStarted = " + this.f197904n);
        return true;
    }

    public void V() {
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "stop start.");
        if (!this.f197904n) {
            return;
        }
        this.C.clear();
        this.f197912v = 2;
        ProcessWorker processWorker = this.f197893c;
        if (processWorker != null) {
            processWorker.o();
            this.f197893c = null;
        }
        this.f197896f = null;
        M();
        this.f197904n = false;
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "stop end. mIsStarted = " + this.f197904n);
    }

    public void W() {
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "uninit start.");
        if (!this.f197903m) {
            return;
        }
        this.f197916z = null;
        X();
        this.f197903m = false;
        QLog.i("AREngine_ARLocalMarkerRecog", 1, "uninit end. mIsInited = " + this.f197903m);
    }
}
