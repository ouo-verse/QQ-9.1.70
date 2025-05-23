package com.tencent.mobileqq.ar.arengine;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.YTFace.cluster.FaceCluster;
import com.tencent.YTFace.model.FaceStatus;
import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.mobileqq.ar.DrawView2;
import com.tencent.mobileqq.ar.FaceScanDownloadManager;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceActInfo;
import com.tencent.mobileqq.ar.aidl.ARScanStarFaceConfigInfo;
import com.tencent.mobileqq.ar.arengine.o;
import com.tencent.mobileqq.armap.ARMapTracer;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARLocalFaceRecog {
    public static boolean B = true;
    public static Handler C;

    /* renamed from: a, reason: collision with root package name */
    FaceCluster f197821a;

    /* renamed from: b, reason: collision with root package name */
    int f197822b;

    /* renamed from: c, reason: collision with root package name */
    int f197823c;

    /* renamed from: d, reason: collision with root package name */
    int f197824d;

    /* renamed from: e, reason: collision with root package name */
    HandlerThread f197825e;

    /* renamed from: f, reason: collision with root package name */
    HandlerThread f197826f;

    /* renamed from: g, reason: collision with root package name */
    Handler f197827g;

    /* renamed from: h, reason: collision with root package name */
    volatile boolean f197828h;

    /* renamed from: i, reason: collision with root package name */
    volatile boolean f197829i;

    /* renamed from: j, reason: collision with root package name */
    long f197830j;

    /* renamed from: k, reason: collision with root package name */
    int f197831k;

    /* renamed from: l, reason: collision with root package name */
    ARScanStarFaceConfigInfo f197832l;

    /* renamed from: m, reason: collision with root package name */
    private ARFacePreviewResample f197833m;

    /* renamed from: n, reason: collision with root package name */
    Context f197834n;

    /* renamed from: o, reason: collision with root package name */
    volatile boolean f197835o;

    /* renamed from: s, reason: collision with root package name */
    a f197839s;

    /* renamed from: t, reason: collision with root package name */
    long f197840t;

    /* renamed from: x, reason: collision with root package name */
    o f197844x;

    /* renamed from: p, reason: collision with root package name */
    Handler.Callback f197836p = new Handler.Callback() { // from class: com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            final int i3;
            char c16;
            Iterator<b> it;
            char c17;
            boolean z16;
            ARScanStarFaceActInfo g16;
            int i16 = message.what;
            int i17 = 2;
            if (i16 != 1) {
                if (i16 != 3) {
                    return false;
                }
                if (QLog.isColorLevel() && ARLocalFaceRecog.B) {
                    QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE start");
                }
                long currentTimeMillis = System.currentTimeMillis();
                ARLocalFaceRecog.this.f197838r = true;
                byte[] bArr = (byte[]) message.obj;
                ArrayList<DrawView2.a> arrayList = new ArrayList<>();
                synchronized (ARLocalFaceRecog.this.f197843w) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    ARLocalFaceRecog aRLocalFaceRecog = ARLocalFaceRecog.this;
                    FaceStatus[] trackFace = aRLocalFaceRecog.f197821a.trackFace(bArr, aRLocalFaceRecog.f197822b, aRLocalFaceRecog.f197823c, aRLocalFaceRecog.f197824d, false);
                    long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                    if (QLog.isColorLevel() && ARLocalFaceRecog.B) {
                        QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE realFace,trackSingeFace[TimeCost] = " + uptimeMillis2);
                        com.tencent.mobileqq.ar.a.a().g(uptimeMillis2);
                    }
                    Iterator<b> it5 = ARLocalFaceRecog.this.f197841u.iterator();
                    while (it5.hasNext()) {
                        b next = it5.next();
                        if (next.f197864j) {
                            if (QLog.isColorLevel() && ARLocalFaceRecog.B) {
                                QLog.d("AREngine_ARLocalFaceRecog", i17, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE realFace start ");
                            }
                            if (trackFace != null) {
                                for (FaceStatus faceStatus : trackFace) {
                                    int i18 = faceStatus.trace_id;
                                    FaceStatus faceStatus2 = next.f197866l;
                                    if (i18 == faceStatus2.trace_id) {
                                        float[] fArr = faceStatus2.feature;
                                        next.f197866l = faceStatus;
                                        faceStatus.feature = fArr;
                                        c17 = 0;
                                        break;
                                    }
                                }
                            }
                            c17 = '\uffff';
                            if (c17 != 0) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Lost realFace  faceInfo.lostCount = " + next.f197865k);
                                }
                                int i19 = next.f197865k + 1;
                                next.f197865k = i19;
                                if (i19 > 0) {
                                    next.f197864j = false;
                                    next.f197865k = 0;
                                    ARLocalFaceRecog.this.f197831k++;
                                }
                                it = it5;
                            } else {
                                next.f197865k = 0;
                                if (QLog.isColorLevel() && ARLocalFaceRecog.B) {
                                    QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Track realFace success,update");
                                }
                                DrawView2.a aVar = new DrawView2.a();
                                aVar.f197427a = next.f197866l.xys;
                                aVar.f197430d = next.f197857c;
                                FaceStatus faceStatus3 = next.f197866l;
                                int i26 = faceStatus3.f61315x;
                                int i27 = faceStatus3.f61316y;
                                it = it5;
                                Rect rect = new Rect(i26, i27, faceStatus3.width + i26, faceStatus3.height + i27);
                                aVar.f197428b = rect;
                                aVar.f197429c = DrawView2.a.b(rect, next.f197866l.xys);
                                aVar.f197432f = next.f197856b;
                                aVar.f197433g = next.f197858d;
                                String str = next.f197859e;
                                aVar.f197431e = str;
                                aVar.f197438l = next.f197863i;
                                if (next.f197855a == 2) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                aVar.f197439m = z16;
                                if (z16) {
                                    boolean h16 = ARLocalFaceRecog.this.h(str);
                                    aVar.f197440n = h16;
                                    if (h16 && (g16 = ARLocalFaceRecog.this.g(aVar.f197431e)) != null) {
                                        aVar.f197442p = g16.f197695m;
                                        aVar.f197437k = g16.f197694i;
                                    }
                                    aVar.f197435i = next.f197862h;
                                    aVar.f197436j = next.f197861g;
                                }
                                aVar.f197441o = next.f197860f;
                                arrayList.add(aVar);
                            }
                        } else {
                            it = it5;
                            if (QLog.isColorLevel()) {
                                QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Try to recover realFace, isRecovering = " + ARLocalFaceRecog.this.f197837q);
                            }
                            if (!ARLocalFaceRecog.this.f197837q && !ARLocalFaceRecog.this.f197829i) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Send Recover Msg");
                                }
                                if (ARLocalFaceRecog.C.hasMessages(1)) {
                                    ARLocalFaceRecog.C.removeMessages(1);
                                }
                                Message obtain = Message.obtain();
                                obtain.what = 1;
                                obtain.obj = bArr;
                                ARLocalFaceRecog.C.sendMessage(obtain);
                            }
                        }
                        it5 = it;
                        i17 = 2;
                    }
                    Iterator<b> it6 = ARLocalFaceRecog.this.f197842v.iterator();
                    while (it6.hasNext()) {
                        b next2 = it6.next();
                        if (next2.f197864j) {
                            if (QLog.isColorLevel() && ARLocalFaceRecog.B) {
                                QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE tmpFace trackSingeFace start");
                            }
                            if (trackFace != null) {
                                for (FaceStatus faceStatus4 : trackFace) {
                                    int i28 = faceStatus4.trace_id;
                                    FaceStatus faceStatus5 = next2.f197866l;
                                    if (i28 == faceStatus5.trace_id) {
                                        float[] fArr2 = faceStatus5.feature;
                                        next2.f197866l = faceStatus4;
                                        faceStatus4.feature = fArr2;
                                        c16 = 0;
                                        break;
                                    }
                                }
                            }
                            c16 = '\uffff';
                            if (QLog.isColorLevel() && ARLocalFaceRecog.B) {
                                QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]MSG_TRACK_FACE [TimeCost] tmpFace trackSingeFace = " + uptimeMillis2);
                            }
                            if (c16 != 0) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Lost tmpFace");
                                }
                                next2.f197864j = false;
                                it6.remove();
                            } else {
                                if (QLog.isColorLevel() && ARLocalFaceRecog.B) {
                                    QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE Track tmpFace success,update ,faceInfo.faceID = " + next2.f197856b);
                                }
                                DrawView2.a aVar2 = new DrawView2.a();
                                aVar2.f197427a = next2.f197866l.xys;
                                aVar2.f197430d = next2.f197857c;
                                aVar2.f197432f = next2.f197856b;
                                FaceStatus faceStatus6 = next2.f197866l;
                                int i29 = faceStatus6.f61315x;
                                int i36 = faceStatus6.f61316y;
                                Rect rect2 = new Rect(i29, i36, faceStatus6.width + i29, faceStatus6.height + i36);
                                aVar2.f197428b = rect2;
                                aVar2.f197429c = DrawView2.a.b(rect2, next2.f197866l.xys);
                                aVar2.f197444r = true;
                                arrayList.add(aVar2);
                            }
                        } else if (QLog.isColorLevel()) {
                            QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE  tmpFace not tracked ,error!");
                        }
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (!ARLocalFaceRecog.this.f197829i && ARLocalFaceRecog.this.f197839s != null) {
                    x xVar = new x();
                    xVar.f198293d = arrayList;
                    ARLocalFaceRecog aRLocalFaceRecog2 = ARLocalFaceRecog.this;
                    xVar.f198291b = aRLocalFaceRecog2.f197840t;
                    aRLocalFaceRecog2.f197839s.c(xVar);
                    if (ARLocalFaceRecog.this.f197845y > 0 && arrayList.size() > 0) {
                        long currentTimeMillis3 = System.currentTimeMillis() - ARLocalFaceRecog.this.f197845y;
                        w.a().f198290g = currentTimeMillis3;
                        w.i();
                        ARLocalFaceRecog.this.f197845y = -1L;
                        if (QLog.isColorLevel()) {
                            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face] MSG_TRACK_FACE update UI,firstlocalRecogCost = " + currentTimeMillis3);
                        }
                    }
                }
                ARLocalFaceRecog.this.f197838r = false;
                if (!QLog.isColorLevel() || !ARLocalFaceRecog.B) {
                    return false;
                }
                QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_TRACK_FACE finish, dataSize = " + arrayList.size() + ",trackMsgExeCost = " + currentTimeMillis2 + ",curTrackFrameIndex = " + ARLocalFaceRecog.this.f197840t + ",mIsPause = " + ARLocalFaceRecog.this.f197829i);
                return false;
            }
            long currentTimeMillis4 = System.currentTimeMillis();
            ARLocalFaceRecog.this.f197837q = true;
            final byte[] bArr2 = (byte[]) message.obj;
            long uptimeMillis3 = SystemClock.uptimeMillis();
            ARLocalFaceRecog aRLocalFaceRecog3 = ARLocalFaceRecog.this;
            FaceStatus[] trackFace2 = aRLocalFaceRecog3.f197821a.trackFace(bArr2, aRLocalFaceRecog3.f197822b, aRLocalFaceRecog3.f197823c, aRLocalFaceRecog3.f197824d, false);
            long uptimeMillis4 = SystemClock.uptimeMillis() - uptimeMillis3;
            w.e(uptimeMillis4);
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detectFace[TimeCost] = " + uptimeMillis4);
            }
            if (trackFace2 != null && trackFace2.length > 0 && QLog.isColorLevel()) {
                QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detectFaceCount = " + trackFace2.length);
            }
            FaceStatus[] e16 = ARLocalFaceRecog.this.e(trackFace2);
            ARLocalFaceRecog.this.r(e16, trackFace2);
            if (e16 != null && e16.length > 0 && !ARLocalFaceRecog.this.f197829i) {
                i3 = e16.length;
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detectFaceCount = " + i3);
                }
                final float[][] fArr3 = new float[i3];
                final float[][] fArr4 = new float[i3];
                synchronized (ARLocalFaceRecog.this.f197843w) {
                    for (int i37 = 0; i37 < i3; i37++) {
                        ARLocalFaceRecog aRLocalFaceRecog4 = ARLocalFaceRecog.this;
                        if (!aRLocalFaceRecog4.u(aRLocalFaceRecog4.f197841u, e16[i37])) {
                            b bVar = new b();
                            bVar.f197864j = true;
                            ARLocalFaceRecog aRLocalFaceRecog5 = ARLocalFaceRecog.this;
                            int i38 = aRLocalFaceRecog5.A;
                            bVar.f197856b = i38;
                            aRLocalFaceRecog5.A = i38 + 1;
                            bVar.f197866l = e16[i37];
                            aRLocalFaceRecog5.f197842v.add(bVar);
                            fArr3[i37] = e16[i37].xys;
                            if (QLog.isColorLevel()) {
                                QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  add a tempFace ,faceInfo.faceID = " + bVar.f197856b);
                            }
                        }
                    }
                }
                Handler handler = ARLocalFaceRecog.this.f197827g;
                if (handler != null && handler.hasMessages(1)) {
                    ARLocalFaceRecog.this.f197827g.removeMessages(1);
                }
                Message obtain2 = Message.obtain(ARLocalFaceRecog.this.f197827g, new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QLog.isColorLevel()) {
                            QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE start ");
                        }
                        for (int i39 = 0; i39 < i3; i39++) {
                            if (fArr3[i39] != null && !ARLocalFaceRecog.this.f197829i) {
                                long uptimeMillis5 = SystemClock.uptimeMillis();
                                if (QLog.isColorLevel()) {
                                    QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature start ");
                                }
                                float[][] fArr5 = fArr4;
                                ARLocalFaceRecog aRLocalFaceRecog6 = ARLocalFaceRecog.this;
                                fArr5[i39] = aRLocalFaceRecog6.f197821a.calcuFaceFeature(bArr2, aRLocalFaceRecog6.f197822b, aRLocalFaceRecog6.f197823c, fArr3[i39], aRLocalFaceRecog6.f197824d);
                                long uptimeMillis6 = SystemClock.uptimeMillis() - uptimeMillis5;
                                w.c(uptimeMillis6);
                                if (QLog.isColorLevel()) {
                                    QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face]SUB_MSG_EXTRACT_FACE_FEATRUE  calcuFaceFeature[TimeCost] = " + uptimeMillis6);
                                    com.tencent.mobileqq.ar.a.a().f(uptimeMillis6);
                                    if (fArr4[i39] != null) {
                                        QLog.d("AREngine_ARLocalFaceRecog", 2, "  calcuFaceFeature feature = " + Arrays.toString(fArr4[i39]));
                                    }
                                }
                            } else if (QLog.isColorLevel()) {
                                QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  faceShape is null i = " + i39);
                            }
                        }
                        synchronized (ARLocalFaceRecog.this.f197843w) {
                            List<b> list = ARLocalFaceRecog.this.f197841u;
                            int size = list.size();
                            if (size > 0 && !ARLocalFaceRecog.this.f197829i) {
                                if (size == 1) {
                                    if (ARLocalFaceRecog.this.q(list.get(0), fArr4, fArr3) && ARLocalFaceRecog.C.hasMessages(1)) {
                                        ARLocalFaceRecog.C.removeMessages(1);
                                    }
                                } else if (size == 2) {
                                    b bVar2 = list.get(0);
                                    b bVar3 = list.get(1);
                                    boolean z17 = bVar2.f197864j;
                                    if (!z17 && bVar3.f197864j) {
                                        if (ARLocalFaceRecog.this.q(bVar2, fArr4, fArr3) && ARLocalFaceRecog.C.hasMessages(1)) {
                                            ARLocalFaceRecog.C.removeMessages(1);
                                        }
                                    } else if (z17 && !bVar3.f197864j) {
                                        if (ARLocalFaceRecog.this.q(bVar3, fArr4, fArr3) && ARLocalFaceRecog.C.hasMessages(1)) {
                                            ARLocalFaceRecog.C.removeMessages(1);
                                        }
                                    } else if (!z17 && !bVar3.f197864j) {
                                        int f16 = ARLocalFaceRecog.this.f(fArr4, bVar2.f197866l.feature);
                                        int f17 = ARLocalFaceRecog.this.f(fArr4, bVar3.f197866l.feature);
                                        if (f16 >= 0 || f17 >= 0) {
                                            if (f16 >= 0 && f17 < 0) {
                                                bVar2.f197866l.xys = fArr3[f16];
                                                bVar2.f197864j = true;
                                            } else if (f16 < 0 && f17 >= 0) {
                                                bVar3.f197866l.xys = fArr3[f17];
                                                bVar3.f197864j = true;
                                            } else if (f16 == f17) {
                                                float calcuSimilarity = ARLocalFaceRecog.this.f197821a.calcuSimilarity(fArr4[f16], bVar2.f197866l.feature);
                                                float calcuSimilarity2 = ARLocalFaceRecog.this.f197821a.calcuSimilarity(fArr4[f17], bVar3.f197866l.feature);
                                                if (QLog.isColorLevel()) {
                                                    QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  similarity1  = " + calcuSimilarity + ",similarity2 = " + calcuSimilarity2);
                                                }
                                                if (calcuSimilarity > calcuSimilarity2) {
                                                    FaceStatus faceStatus7 = bVar2.f197866l;
                                                    float[][] fArr6 = fArr3;
                                                    faceStatus7.xys = fArr6[f16];
                                                    bVar2.f197864j = true;
                                                    float[][] fArr7 = fArr4;
                                                    fArr7[f16] = null;
                                                    ARLocalFaceRecog.this.q(bVar3, fArr7, fArr6);
                                                } else {
                                                    FaceStatus faceStatus8 = bVar3.f197866l;
                                                    float[][] fArr8 = fArr3;
                                                    faceStatus8.xys = fArr8[f17];
                                                    bVar3.f197864j = true;
                                                    float[][] fArr9 = fArr4;
                                                    fArr9[f17] = null;
                                                    ARLocalFaceRecog.this.q(bVar2, fArr9, fArr8);
                                                }
                                            } else {
                                                FaceStatus faceStatus9 = bVar2.f197866l;
                                                float[][] fArr10 = fArr3;
                                                faceStatus9.xys = fArr10[f16];
                                                bVar2.f197864j = true;
                                                bVar3.f197866l.xys = fArr10[f17];
                                                bVar3.f197864j = true;
                                            }
                                        }
                                        if (ARLocalFaceRecog.this.j(list) && ARLocalFaceRecog.C.hasMessages(1)) {
                                            ARLocalFaceRecog.C.removeMessages(1);
                                        }
                                    } else if (QLog.isColorLevel()) {
                                        QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  calc error status");
                                    }
                                }
                            }
                            ARLocalFaceRecog aRLocalFaceRecog7 = ARLocalFaceRecog.this;
                            aRLocalFaceRecog7.c(aRLocalFaceRecog7.f197842v);
                            ARLocalFaceRecog.this.A = 10;
                            if (QLog.isColorLevel()) {
                                QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE end ,clear tmpFace");
                            }
                        }
                        ARLocalFaceRecog.this.f197837q = false;
                        if (QLog.isColorLevel()) {
                            QLog.d("AREngine_ARLocalFaceRecog", 2, "SUB_MSG_EXTRACT_FACE_FEATRUE  finish");
                        }
                    }
                });
                obtain2.what = 1;
                Handler handler2 = ARLocalFaceRecog.this.f197827g;
                if (handler2 != null) {
                    handler2.sendMessage(obtain2);
                }
            } else {
                ARLocalFaceRecog.this.f197837q = false;
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE  detect no face");
                }
                i3 = 0;
            }
            long currentTimeMillis5 = System.currentTimeMillis() - currentTimeMillis4;
            if (!QLog.isColorLevel()) {
                return false;
            }
            QLog.d("AREngine_ARLocalFaceRecog", 2, "MSG_DETECT_AND_RECOVER_FACE finish, faceCount = " + i3 + ",recoverMsgExeCost = " + currentTimeMillis5);
            return false;
        }
    };

    /* renamed from: q, reason: collision with root package name */
    volatile boolean f197837q = false;

    /* renamed from: r, reason: collision with root package name */
    volatile boolean f197838r = false;

    /* renamed from: u, reason: collision with root package name */
    List<b> f197841u = new ArrayList();

    /* renamed from: v, reason: collision with root package name */
    List<b> f197842v = new ArrayList();

    /* renamed from: w, reason: collision with root package name */
    Object f197843w = new Object();

    /* renamed from: y, reason: collision with root package name */
    long f197845y = -1;

    /* renamed from: z, reason: collision with root package name */
    final int f197846z = 10;
    int A = 10;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface a {
        void c(x xVar);
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f197855a;

        /* renamed from: b, reason: collision with root package name */
        public int f197856b;

        /* renamed from: c, reason: collision with root package name */
        public String f197857c;

        /* renamed from: d, reason: collision with root package name */
        public String f197858d;

        /* renamed from: e, reason: collision with root package name */
        public String f197859e;

        /* renamed from: f, reason: collision with root package name */
        public float f197860f;

        /* renamed from: g, reason: collision with root package name */
        public String f197861g;

        /* renamed from: h, reason: collision with root package name */
        public String f197862h;

        /* renamed from: i, reason: collision with root package name */
        public String f197863i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f197864j;

        /* renamed from: k, reason: collision with root package name */
        public int f197865k;

        /* renamed from: l, reason: collision with root package name */
        public FaceStatus f197866l;

        public String toString() {
            return "FaceInfo{name='" + this.f197857c + "', tracked=" + this.f197864j + ", lostCount=" + this.f197865k + ", faceType=" + this.f197855a + ", faceStatus=" + this.f197866l + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ARLocalFaceRecog() {
        this.f197824d = 90;
        if (((ICameraCompatible) QRoute.api(ICameraCompatible.class)).isFoundProduct(com.tencent.aelight.camera.constants.a.f68993g)) {
            this.f197824d = 270;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "ARLocalFaceRecog  rotateDegree = " + this.f197824d);
        }
    }

    public static boolean k() {
        boolean equals = DeviceInfoMonitor.getModel().equals("vivo X6Plus A");
        if (ARMapTracer.a() == 3) {
            return true;
        }
        return equals;
    }

    public boolean a(final o oVar) {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face][ScanStarFace]addFaceCloudRecogResult start,faceResult = " + oVar);
        }
        this.f197835o = true;
        final long currentTimeMillis = System.currentTimeMillis();
        C.post(new Runnable() { // from class: com.tencent.mobileqq.ar.arengine.ARLocalFaceRecog.2
            @Override // java.lang.Runnable
            public void run() {
                ARLocalFaceRecog aRLocalFaceRecog;
                synchronized (ARLocalFaceRecog.this.f197843w) {
                    ARLocalFaceRecog aRLocalFaceRecog2 = ARLocalFaceRecog.this;
                    aRLocalFaceRecog2.c(aRLocalFaceRecog2.f197841u);
                    ARLocalFaceRecog aRLocalFaceRecog3 = ARLocalFaceRecog.this;
                    aRLocalFaceRecog3.c(aRLocalFaceRecog3.f197842v);
                    aRLocalFaceRecog = ARLocalFaceRecog.this;
                    aRLocalFaceRecog.A = 10;
                }
                o oVar2 = oVar;
                aRLocalFaceRecog.f197844x = oVar2;
                if (oVar2 != null && oVar2.f198226i != null) {
                    synchronized (aRLocalFaceRecog.f197843w) {
                        ARLocalFaceRecog aRLocalFaceRecog4 = ARLocalFaceRecog.this;
                        o oVar3 = aRLocalFaceRecog4.f197844x;
                        if (oVar3.f198226i.length > 2) {
                            aRLocalFaceRecog4.d(aRLocalFaceRecog4.f197841u, oVar3);
                            ARLocalFaceRecog aRLocalFaceRecog5 = ARLocalFaceRecog.this;
                            aRLocalFaceRecog5.b(aRLocalFaceRecog5.f197841u, aRLocalFaceRecog5.f197844x);
                        } else {
                            int i3 = 0;
                            while (true) {
                                FaceStatus[] faceStatusArr = ARLocalFaceRecog.this.f197844x.f198226i;
                                if (i3 >= faceStatusArr.length) {
                                    break;
                                }
                                FaceStatus faceStatus = faceStatusArr[i3];
                                if (QLog.isColorLevel()) {
                                    QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]addFaceCloudRecogResult faceFeature = " + Arrays.toString(faceStatus.feature));
                                }
                                b bVar = new b();
                                bVar.f197855a = 1;
                                bVar.f197857c = "";
                                ArrayList<o.a> arrayList = ARLocalFaceRecog.this.f197844x.f198225h;
                                if (arrayList != null) {
                                    Iterator<o.a> it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        o.a next = it.next();
                                        if (next.f198228b == i3) {
                                            bVar.f197855a = 2;
                                            bVar.f197857c = next.f198229c;
                                            bVar.f197858d = next.f198230d;
                                            bVar.f197859e = String.valueOf(next.f198227a);
                                            bVar.f197861g = next.f198231e;
                                            bVar.f197862h = next.f198232f;
                                            bVar.f197863i = next.f198233g;
                                            bVar.f197860f = next.f198234h;
                                        }
                                    }
                                }
                                bVar.f197864j = true;
                                bVar.f197866l = faceStatus;
                                bVar.f197856b = i3;
                                ARLocalFaceRecog.this.f197841u.add(bVar);
                                i3++;
                            }
                        }
                    }
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face][ScanStarFace]addFaceCloudRecogResult finish,totalFaceList = " + ARLocalFaceRecog.this.f197841u + ",addFaceClouDResultCost = " + currentTimeMillis2);
                }
                ARLocalFaceRecog.this.f197845y = System.currentTimeMillis();
                ARLocalFaceRecog.this.f197835o = false;
            }
        });
        return true;
    }

    void b(List<b> list, o oVar) {
        for (FaceStatus faceStatus : oVar.f198226i) {
            Iterator<b> it = list.iterator();
            while (it.hasNext() && it.next().f197866l != faceStatus) {
            }
        }
    }

    void c(List<b> list) {
        if (list != null && list.size() > 0) {
            list.clear();
        }
    }

    void d(List<b> list, o oVar) {
        int i3;
        FaceStatus faceStatus;
        String str;
        if (oVar.f198226i.length > 2) {
            ArrayList<o.a> arrayList = oVar.f198225h;
            if (arrayList != null) {
                i3 = arrayList.size();
            } else {
                i3 = 0;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARLocalFaceRecog", 2, "filterCloudFaceResult starCount = " + i3);
            }
            String str2 = "";
            if (i3 > 0) {
                FaceStatus faceStatus2 = null;
                if (i3 == 1) {
                    b bVar = new b();
                    int i16 = oVar.f198225h.get(0).f198228b;
                    bVar.f197864j = true;
                    bVar.f197856b = 0;
                    bVar.f197866l = oVar.f198226i[i16];
                    int i17 = 0;
                    while (i17 < i3) {
                        o.a aVar = oVar.f198225h.get(i17);
                        if (aVar.f198228b == i16) {
                            bVar.f197855a = 2;
                            bVar.f197857c = aVar.f198229c;
                            bVar.f197858d = aVar.f198230d;
                            str = str2;
                            bVar.f197859e = String.valueOf(aVar.f198227a);
                            bVar.f197861g = aVar.f198231e;
                            bVar.f197862h = aVar.f198232f;
                            bVar.f197863i = aVar.f198233g;
                            bVar.f197860f = aVar.f198234h;
                        } else {
                            str = str2;
                        }
                        i17++;
                        str2 = str;
                    }
                    String str3 = str2;
                    int i18 = 0;
                    int i19 = 0;
                    while (true) {
                        FaceStatus[] faceStatusArr = oVar.f198226i;
                        if (i18 >= faceStatusArr.length) {
                            break;
                        }
                        if (i18 != i16) {
                            if (faceStatus2 == null) {
                                faceStatus = faceStatusArr[i18];
                            } else {
                                faceStatus = faceStatusArr[i18];
                                if (faceStatus.width * faceStatus.height <= faceStatus2.width * faceStatus2.height) {
                                }
                            }
                            i19 = i18;
                            faceStatus2 = faceStatus;
                        }
                        i18++;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("AREngine_ARLocalFaceRecog", 2, "filterCloudFaceResult starCount = " + i3 + ",bigFaceID = " + i19);
                    }
                    b bVar2 = new b();
                    bVar2.f197855a = 1;
                    bVar2.f197857c = str3;
                    bVar2.f197864j = true;
                    bVar2.f197866l = faceStatus2;
                    bVar2.f197856b = 1;
                    list.add(bVar);
                    list.add(bVar2);
                } else if (i3 == 2) {
                    b bVar3 = new b();
                    bVar3.f197864j = true;
                    bVar3.f197856b = 0;
                    bVar3.f197866l = oVar.f198226i[0];
                    b bVar4 = new b();
                    bVar4.f197864j = true;
                    bVar4.f197856b = 1;
                    bVar4.f197866l = oVar.f198226i[1];
                    for (int i26 = 0; i26 < i3; i26++) {
                        o.a aVar2 = oVar.f198225h.get(i26);
                        if (aVar2.f198228b == 0) {
                            bVar3.f197855a = 2;
                            bVar3.f197857c = aVar2.f198229c;
                            bVar3.f197858d = aVar2.f198230d;
                            bVar3.f197859e = String.valueOf(aVar2.f198227a);
                            bVar3.f197861g = aVar2.f198231e;
                            bVar3.f197862h = aVar2.f198232f;
                            bVar3.f197863i = aVar2.f198233g;
                            bVar3.f197860f = aVar2.f198234h;
                        }
                        if (aVar2.f198228b == 1) {
                            bVar4.f197855a = 2;
                            bVar4.f197857c = aVar2.f198229c;
                            bVar4.f197858d = aVar2.f198230d;
                            bVar4.f197859e = String.valueOf(aVar2.f198227a);
                            bVar4.f197861g = aVar2.f198231e;
                            bVar4.f197862h = aVar2.f198232f;
                            bVar4.f197863i = aVar2.f198233g;
                            bVar4.f197860f = aVar2.f198234h;
                        }
                    }
                    list.add(bVar3);
                    list.add(bVar4);
                } else {
                    FaceStatus faceStatus3 = oVar.f198226i[0];
                    int i27 = 0;
                    int i28 = 0;
                    while (true) {
                        FaceStatus[] faceStatusArr2 = oVar.f198226i;
                        if (i28 >= faceStatusArr2.length) {
                            break;
                        }
                        FaceStatus faceStatus4 = faceStatusArr2[i28];
                        if (faceStatus4.width * faceStatus4.height > faceStatus3.width * faceStatus3.height) {
                            i27 = i28;
                            faceStatus3 = faceStatus4;
                        }
                        i28++;
                    }
                    int i29 = -2;
                    int i36 = 0;
                    while (true) {
                        FaceStatus[] faceStatusArr3 = oVar.f198226i;
                        if (i36 >= faceStatusArr3.length) {
                            break;
                        }
                        if (i36 != i27) {
                            if (faceStatus2 == null) {
                                faceStatus2 = faceStatusArr3[i36];
                                i29 = i36;
                            } else {
                                FaceStatus faceStatus5 = faceStatusArr3[i36];
                                if (faceStatus5.width * faceStatus5.height > faceStatus2.width * faceStatus2.height) {
                                    i29 = i36;
                                    faceStatus2 = faceStatus5;
                                }
                            }
                        }
                        i36++;
                    }
                    b bVar5 = new b();
                    bVar5.f197864j = true;
                    bVar5.f197856b = 0;
                    bVar5.f197866l = faceStatus3;
                    b bVar6 = new b();
                    bVar6.f197864j = true;
                    bVar6.f197856b = 1;
                    bVar6.f197866l = faceStatus2;
                    for (int i37 = 0; i37 < i3; i37++) {
                        o.a aVar3 = oVar.f198225h.get(i37);
                        if (aVar3.f198228b == i27) {
                            bVar5.f197855a = 2;
                            bVar5.f197857c = aVar3.f198229c;
                            bVar5.f197858d = aVar3.f198230d;
                            bVar5.f197859e = String.valueOf(aVar3.f198227a);
                            bVar5.f197861g = aVar3.f198231e;
                            bVar5.f197862h = aVar3.f198232f;
                            bVar5.f197863i = aVar3.f198233g;
                            bVar5.f197860f = aVar3.f198234h;
                        }
                        if (aVar3.f198228b == i29) {
                            bVar6.f197855a = 2;
                            bVar6.f197857c = aVar3.f198229c;
                            bVar6.f197858d = aVar3.f198230d;
                            bVar6.f197859e = String.valueOf(aVar3.f198227a);
                            bVar6.f197861g = aVar3.f198231e;
                            bVar6.f197862h = aVar3.f198232f;
                            bVar6.f197863i = aVar3.f198233g;
                            bVar6.f197860f = aVar3.f198234h;
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("AREngine_ARLocalFaceRecog", 2, "filterCloudFaceResult starCount = " + i3 + ",bigFaceID = " + i27 + ",secondBigFaceID = " + i29);
                    }
                    list.add(bVar5);
                    list.add(bVar6);
                }
            } else {
                FaceStatus[] e16 = e(oVar.f198226i);
                b bVar7 = new b();
                bVar7.f197855a = 1;
                bVar7.f197857c = "";
                bVar7.f197864j = true;
                bVar7.f197856b = 0;
                if (e16 != null) {
                    bVar7.f197866l = e16[0];
                }
                b bVar8 = new b();
                bVar8.f197855a = 1;
                bVar8.f197857c = "";
                bVar8.f197864j = true;
                bVar8.f197856b = 1;
                if (e16 != null) {
                    bVar8.f197866l = e16[1];
                }
                list.add(bVar7);
                list.add(bVar8);
            }
        }
    }

    FaceStatus[] e(FaceStatus[] faceStatusArr) {
        if (faceStatusArr != null && faceStatusArr.length > 0) {
            if (faceStatusArr.length > 2) {
                FaceStatus[] faceStatusArr2 = new FaceStatus[2];
                faceStatusArr2[0] = faceStatusArr[0];
                int i3 = 0;
                for (int i16 = 0; i16 < faceStatusArr.length; i16++) {
                    FaceStatus faceStatus = faceStatusArr[i16];
                    int i17 = faceStatus.width * faceStatus.height;
                    FaceStatus faceStatus2 = faceStatusArr2[0];
                    if (i17 > faceStatus2.width * faceStatus2.height) {
                        faceStatusArr2[0] = faceStatus;
                        i3 = i16;
                    }
                }
                int i18 = -2;
                for (int i19 = 0; i19 < faceStatusArr.length; i19++) {
                    if (i19 != i3) {
                        FaceStatus faceStatus3 = faceStatusArr2[1];
                        if (faceStatus3 == null) {
                            faceStatusArr2[1] = faceStatusArr[i19];
                        } else {
                            FaceStatus faceStatus4 = faceStatusArr[i19];
                            if (faceStatus4.width * faceStatus4.height > faceStatus3.width * faceStatus3.height) {
                                faceStatusArr2[1] = faceStatus4;
                            }
                        }
                        i18 = i19;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARLocalFaceRecog", 2, "filterLocalDetectFace  bigFaceID = " + i3 + ",secondBigFaceID = " + i18 + ",faceCount = " + faceStatusArr.length);
                }
                return faceStatusArr2;
            }
            return faceStatusArr;
        }
        return null;
    }

    int f(float[][] fArr, float[] fArr2) {
        int length = fArr.length;
        float[] fArr3 = new float[length];
        for (int i3 = 0; i3 < length; i3++) {
            float[] fArr4 = fArr[i3];
            if (fArr4 != null) {
                fArr3[i3] = this.f197821a.calcuSimilarity(fArr4, fArr2);
            } else if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARLocalFaceRecog", 2, "findFaceIndexByFaceFeature2 faceFeature is null,i = " + i3);
            }
        }
        float f16 = fArr3[0];
        int i16 = -1;
        for (int i17 = 0; i17 < length; i17++) {
            float f17 = fArr3[i17];
            if (f17 >= f16) {
                i16 = i17;
                f16 = f17;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "findFaceIndexByFaceFeature targetFaceFeature = " + Arrays.toString(fArr2));
            QLog.d("AREngine_ARLocalFaceRecog", 2, "findFaceIndexByFaceFeature newFaceFeature = " + Arrays.toString(fArr[0]));
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "findFaceIndexByFaceFeature2 index = " + i16 + ",finalSimilarity = " + f16);
        }
        Float.isNaN(f16);
        if (f16 < 0.5d) {
            return -1;
        }
        return i16;
    }

    ARScanStarFaceActInfo g(String str) {
        ARScanStarFaceConfigInfo aRScanStarFaceConfigInfo;
        ARScanStarFaceActInfo[] aRScanStarFaceActInfoArr;
        ARScanStarFaceActInfo aRScanStarFaceActInfo = null;
        if (!TextUtils.isEmpty(str) && (aRScanStarFaceConfigInfo = this.f197832l) != null && (aRScanStarFaceActInfoArr = aRScanStarFaceConfigInfo.f197697e) != null && aRScanStarFaceActInfoArr.length > 0) {
            int length = aRScanStarFaceActInfoArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                ARScanStarFaceActInfo aRScanStarFaceActInfo2 = this.f197832l.f197697e[i3];
                if (aRScanStarFaceActInfo2 != null && str.equals(aRScanStarFaceActInfo2.f197691e)) {
                    aRScanStarFaceActInfo = aRScanStarFaceActInfo2;
                }
            }
        }
        return aRScanStarFaceActInfo;
    }

    boolean h(String str) {
        ARScanStarFaceConfigInfo aRScanStarFaceConfigInfo;
        ARScanStarFaceActInfo[] aRScanStarFaceActInfoArr;
        boolean z16 = false;
        z16 = false;
        z16 = false;
        z16 = false;
        if (!TextUtils.isEmpty(str) && (aRScanStarFaceConfigInfo = this.f197832l) != null && (aRScanStarFaceActInfoArr = aRScanStarFaceConfigInfo.f197697e) != null && aRScanStarFaceActInfoArr.length > 0) {
            int length = aRScanStarFaceActInfoArr.length;
            boolean z17 = false;
            for (int i3 = 0; i3 < length; i3++) {
                ARScanStarFaceActInfo aRScanStarFaceActInfo = this.f197832l.f197697e[i3];
                long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
                if (aRScanStarFaceActInfo != null && str.equals(aRScanStarFaceActInfo.f197691e) && serverTimeMillis > aRScanStarFaceActInfo.C && serverTimeMillis < aRScanStarFaceActInfo.D) {
                    z17 = true;
                }
            }
            z16 = z17;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]hasStarActivity result = " + z16 + "starUin = " + str);
        }
        return z16;
    }

    public boolean i(Context context, int i3, int i16, ARScanStarFaceConfigInfo aRScanStarFaceConfigInfo, a aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!FaceCluster.useAssetSo) {
            boolean i17 = FaceScanDownloadManager.i();
            if (i17) {
                com.tencent.mobileqq.ar.o.d(context);
                this.f197821a = FaceCluster.getInstance();
            } else {
                com.tencent.mobileqq.ar.o.f198546c = false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]init ,isResourceReady = " + i17 + ",FaceScanModelsLoader.hasFaceModelInit = " + com.tencent.mobileqq.ar.o.f198546c);
            }
        }
        this.f197834n = context;
        this.f197822b = i3;
        this.f197823c = i16;
        this.f197839s = aVar;
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[DEBUG_SCAN_yt_face] [ScanStarFace]init result = true,previewWidth = " + i3 + ",previewHeight = " + i16 + ",useAssetSo = " + FaceCluster.useAssetSo + ",localFaceRecogerInitCost = " + currentTimeMillis2);
        }
        ARReport.c().j(currentTimeMillis2, true);
        w.f(currentTimeMillis2);
        this.f197832l = aRScanStarFaceConfigInfo;
        this.f197828h = false;
        this.f197829i = false;
        return true;
    }

    boolean j(List<b> list) {
        while (true) {
            boolean z16 = true;
            for (b bVar : list) {
                if (!z16 || !bVar.f197864j) {
                    z16 = false;
                }
            }
            return z16;
        }
    }

    public boolean l() {
        return this.f197829i;
    }

    public boolean m() {
        return this.f197835o;
    }

    public void n() {
        boolean i3 = FaceScanDownloadManager.i();
        if (i3) {
            com.tencent.mobileqq.ar.o.d(this.f197834n);
            this.f197821a = FaceCluster.getInstance();
        } else {
            com.tencent.mobileqq.ar.o.f198546c = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace]notifyResourceDownloadFinish ,isResourceReady = " + i3 + ",FaceScanModelsLoader.hasFaceModelInit = " + com.tencent.mobileqq.ar.o.f198546c);
        }
    }

    public void o(long j3, byte[] bArr) {
        int size;
        if (bArr != null && this.f197828h && !this.f197829i && com.tencent.mobileqq.ar.o.f198546c) {
            synchronized (this.f197843w) {
                size = this.f197841u.size();
            }
            if (QLog.isColorLevel() && B) {
                QLog.d("AREngine_ARLocalFaceRecog", 2, "onPreviewFrame totalFaceSize = " + size);
            }
            if (size == 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARLocalFaceRecog", 2, "ARFaceTest onPreviewFrame totalFaceSize is 0,frameIdx = " + j3 + ",isPreparingData = " + this.f197835o);
                    return;
                }
                return;
            }
            if (QLog.isColorLevel() && B) {
                QLog.d("AREngine_ARLocalFaceRecog", 2, " Try to track Face, isTracking = " + this.f197838r + ",frameIndex = " + j3);
            }
            if (!this.f197838r) {
                if (QLog.isColorLevel() && B) {
                    QLog.d("AREngine_ARLocalFaceRecog", 2, "ARFaceTest Send track Face msg frameIdx = " + j3);
                }
                if (C.hasMessages(3)) {
                    C.removeMessages(3);
                }
                this.f197833m.f(bArr);
                byte[] b16 = this.f197833m.b();
                this.f197840t = j3;
                Message obtain = Message.obtain();
                obtain.what = 3;
                obtain.obj = b16;
                C.sendMessage(obtain);
            }
        }
    }

    public void p() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace] pause ,mIsPause = " + this.f197829i);
        }
        if (this.f197829i) {
            return;
        }
        this.f197829i = true;
        synchronized (this.f197843w) {
            c(this.f197841u);
            c(this.f197842v);
            this.A = 10;
            C.removeCallbacksAndMessages(null);
            this.f197827g.removeCallbacksAndMessages(null);
        }
        if (this.f197830j > 0) {
            w.h(System.currentTimeMillis() - this.f197830j, this.f197831k);
            this.f197830j = 0L;
            this.f197831k = 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean q(b bVar, float[][] fArr, float[][] fArr2) {
        boolean z16;
        if (!bVar.f197864j) {
            long uptimeMillis = SystemClock.uptimeMillis();
            int f16 = f(fArr, bVar.f197866l.feature);
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            if (QLog.isColorLevel()) {
                QLog.d("AREngine_ARLocalFaceRecog", 2, "recoverSingleFace findFaceIndexByFaceFeature[TimeCost] = " + uptimeMillis2);
            }
            if (f16 >= 0 && f16 < fArr.length) {
                bVar.f197866l.xys = fArr2[f16];
                z16 = true;
                bVar.f197864j = true;
                if (QLog.isColorLevel()) {
                    QLog.d("AREngine_ARLocalFaceRecog", 2, "recoverSingleFace  result = " + z16 + ",faceInfo = " + bVar);
                }
                return z16;
            }
        }
        z16 = false;
        if (QLog.isColorLevel()) {
        }
        return z16;
    }

    void r(FaceStatus[] faceStatusArr, FaceStatus[] faceStatusArr2) {
        if (faceStatusArr2 == null) {
            return;
        }
        for (FaceStatus faceStatus : faceStatusArr2) {
            if (faceStatusArr != null) {
                int length = faceStatusArr.length;
                for (int i3 = 0; i3 < length && faceStatus != faceStatusArr[i3]; i3++) {
                }
            }
        }
    }

    public void s() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace] resume ,mIsPause = " + this.f197829i);
        }
        if (!this.f197829i) {
            return;
        }
        this.f197829i = false;
        this.f197830j = System.currentTimeMillis();
        this.f197831k = 0;
    }

    public void t(ARFacePreviewResample aRFacePreviewResample) {
        this.f197833m = aRFacePreviewResample;
    }

    boolean u(List<b> list, FaceStatus faceStatus) {
        boolean z16;
        boolean z17 = false;
        if (list != null && list.size() > 0) {
            boolean z18 = false;
            for (b bVar : list) {
                if (bVar.f197864j) {
                    FaceStatus faceStatus2 = bVar.f197866l;
                    int abs = Math.abs((faceStatus2.f61315x + (faceStatus2.width / 2)) - (faceStatus.f61315x + (faceStatus.width / 2)));
                    FaceStatus faceStatus3 = bVar.f197866l;
                    int abs2 = Math.abs((faceStatus3.f61316y + (faceStatus3.height / 2)) - (faceStatus.f61316y + (faceStatus.height / 2)));
                    int min = Math.min(bVar.f197866l.width / 2, faceStatus.width / 2);
                    int min2 = Math.min(bVar.f197866l.height / 2, faceStatus.height / 2);
                    if (abs < min && abs2 < min2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("AREngine_ARLocalFaceRecog", 2, " shouldFilterTmpFace,distanceX = " + abs + ",distanceY = " + abs2 + ",w = " + min + ",h = " + min2);
                    }
                    z18 = z16;
                }
            }
            z17 = z18;
        }
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, " shouldFilterTmpFace,result = " + z17);
        }
        return z17;
    }

    public boolean v() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace] start ,mIsStarted = " + this.f197828h);
        }
        if (this.f197828h) {
            return true;
        }
        if (this.f197825e == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("ARLocalFaceRecog");
            this.f197825e = baseHandlerThread;
            baseHandlerThread.start();
            C = new Handler(this.f197825e.getLooper(), this.f197836p);
        }
        if (this.f197826f == null) {
            BaseHandlerThread baseHandlerThread2 = new BaseHandlerThread("ARLocalFaceRecog_exFeature");
            this.f197826f = baseHandlerThread2;
            baseHandlerThread2.start();
            this.f197827g = new Handler(this.f197826f.getLooper());
        }
        this.f197828h = true;
        this.f197829i = false;
        return true;
    }

    public void w() {
        if (QLog.isColorLevel()) {
            QLog.d("AREngine_ARLocalFaceRecog", 2, "[ScanStarFace] stop,mIsStarted = " + this.f197828h);
        }
        if (!this.f197828h) {
            return;
        }
        this.f197828h = false;
        synchronized (this.f197843w) {
            c(this.f197841u);
            c(this.f197842v);
            this.A = 10;
            C.removeCallbacksAndMessages(null);
            this.f197827g.removeCallbacksAndMessages(null);
        }
        this.f197825e.quit();
        this.f197825e = null;
        C = null;
        this.f197826f.quit();
        this.f197826f = null;
        this.f197827g = null;
    }

    public void x() {
        QLog.d("AREngine_ARLocalFaceRecog", 1, "[ScanStarFace] uninit");
        Handler handler = C;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        com.tencent.mobileqq.ar.o.j();
        QLog.d("AREngine_ARLocalFaceRecog", 1, "[ScanStarFace] uninit finish");
    }
}
