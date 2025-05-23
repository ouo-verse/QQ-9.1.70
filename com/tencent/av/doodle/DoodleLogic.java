package com.tencent.av.doodle;

import android.graphics.Color;
import android.graphics.PointF;
import android.os.SystemClock;
import androidx.core.internal.view.SupportMenu;
import com.tencent.av.AVFunDrawing$DrawingInfo;
import com.tencent.av.AVFunDrawing$MessageBody;
import com.tencent.av.AVFunDrawing$PointInfo;
import com.tencent.av.AVFunDrawing$VersionInfo;
import com.tencent.av.doodle.api.IDoodleApi;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DoodleLogic {

    /* renamed from: p, reason: collision with root package name */
    private static DoodleLogic f73580p;

    /* renamed from: q, reason: collision with root package name */
    static int f73581q;

    /* renamed from: a, reason: collision with root package name */
    ConcurrentLinkedQueue<com.tencent.av.doodle.b> f73582a = new ConcurrentLinkedQueue<>();

    /* renamed from: b, reason: collision with root package name */
    com.tencent.av.doodle.b[] f73583b = new com.tencent.av.doodle.b[2];

    /* renamed from: c, reason: collision with root package name */
    boolean f73584c = false;

    /* renamed from: d, reason: collision with root package name */
    private a f73585d = null;

    /* renamed from: e, reason: collision with root package name */
    public int f73586e = SupportMenu.CATEGORY_MASK;

    /* renamed from: f, reason: collision with root package name */
    public int f73587f = 1;

    /* renamed from: g, reason: collision with root package name */
    public float f73588g = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    public int f73589h = 0;

    /* renamed from: i, reason: collision with root package name */
    public int f73590i = 0;

    /* renamed from: j, reason: collision with root package name */
    ReentrantLock f73591j = new ReentrantLock();

    /* renamed from: k, reason: collision with root package name */
    boolean[] f73592k = new boolean[2];

    /* renamed from: l, reason: collision with root package name */
    public boolean f73593l = false;

    /* renamed from: m, reason: collision with root package name */
    public int f73594m = 0;

    /* renamed from: n, reason: collision with root package name */
    public final c f73595n = new c(this);

    /* renamed from: o, reason: collision with root package name */
    ConcurrentLinkedQueue<b> f73596o = new ConcurrentLinkedQueue<>();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public interface a {
        void a(int i3);

        void invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        AVFunDrawing$MessageBody f73597a;

        /* renamed from: b, reason: collision with root package name */
        long f73598b = com.tencent.av.utils.e.i();

        b(AVFunDrawing$MessageBody aVFunDrawing$MessageBody) {
            this.f73597a = aVFunDrawing$MessageBody;
        }
    }

    public static DoodleLogic b() {
        synchronized (DoodleLogic.class) {
            if (f73580p == null) {
                f73580p = new DoodleLogic();
            }
        }
        return f73580p;
    }

    private void e(int i3) {
        com.tencent.av.doodle.b bVar = this.f73583b[i3];
        if (bVar != null) {
            bVar.f73616i = SystemClock.elapsedRealtime();
            a aVar = this.f73585d;
            if (aVar != null) {
                aVar.a(i3);
            }
            Iterator<com.tencent.av.doodle.b> it = this.f73582a.iterator();
            while (it.hasNext()) {
                com.tencent.av.doodle.b next = it.next();
                long j3 = bVar.f73616i;
                if (j3 - next.f73616i <= 1200) {
                    next.f73616i = j3;
                }
            }
            this.f73582a.offer(bVar);
        }
        this.f73583b[i3] = null;
        QLog.w("DoodleLogic", 1, "offerDoodle, index[" + i3 + "], item[" + bVar + "], size[" + this.f73582a.size() + "]");
    }

    private void i(int i3) {
        boolean z16 = false;
        com.tencent.av.doodle.b bVar = this.f73583b[0];
        AVFunDrawing$PointInfo aVFunDrawing$PointInfo = new AVFunDrawing$PointInfo();
        aVFunDrawing$PointInfo.uint32_type.set(i3);
        AVFunDrawing$MessageBody aVFunDrawing$MessageBody = new AVFunDrawing$MessageBody();
        aVFunDrawing$MessageBody.uint32_msg_type.set(2);
        AVFunDrawing$DrawingInfo aVFunDrawing$DrawingInfo = new AVFunDrawing$DrawingInfo();
        if (bVar != null) {
            z16 = true;
        }
        if (z16) {
            PointF pointF = bVar.f73615h;
            float f16 = pointF.x;
            float f17 = pointF.y;
            aVFunDrawing$PointInfo.float_x.set(f16);
            aVFunDrawing$PointInfo.float_y.set(f17);
            aVFunDrawing$DrawingInfo.uint32_pen_type.set(bVar.f73609b);
            aVFunDrawing$DrawingInfo.str_pen_name.set(bVar.f73610c);
            aVFunDrawing$DrawingInfo.str_pen_color.set("#" + Integer.toHexString(bVar.f73614g));
            aVFunDrawing$DrawingInfo.uint32_pen_width.set(bVar.f73611d);
            aVFunDrawing$DrawingInfo.uint32_screen_width.set(bVar.f73612e);
            aVFunDrawing$DrawingInfo.uint32_screen_height.set(bVar.f73613f);
        } else {
            SmallScreenUtils.n("\u6ca1\u6709doodleItem");
        }
        aVFunDrawing$DrawingInfo.msg_point_info.add(aVFunDrawing$PointInfo);
        aVFunDrawing$MessageBody.drawingInfo.set(aVFunDrawing$DrawingInfo);
        aVFunDrawing$MessageBody.uint32_seq.set(a());
        this.f73596o.add(new b(aVFunDrawing$MessageBody));
        if (i3 == 3) {
            if (this.f73596o.size() == 1) {
                m(100L, true);
            }
        } else if (this.f73596o.size() == 1) {
            j();
        }
    }

    synchronized int a() {
        int i3;
        i3 = f73581q + 1;
        f73581q = i3;
        return i3;
    }

    public a c() {
        return this.f73585d;
    }

    public boolean d() {
        if (this.f73594m > 0) {
            return true;
        }
        return false;
    }

    public void f(long j3) {
        for (com.tencent.av.doodle.b bVar : this.f73583b) {
            if (bVar != null) {
                bVar.d(j3);
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:(4:(2:114|115)(1:(7:102|103|104|105|106|107|(15:109|40|41|42|43|44|45|46|47|48|49|50|51|52|(12:54|55|56|57|58|59|(2:61|(2:63|(1:65)(1:78))(1:79))(3:80|81|82)|66|67|68|69|70))))|51|52|(0))|42|43|44|45|46|47|48|49|50) */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01ab, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01ac, code lost:
    
        r7 = "DoodleLogic";
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0127 A[Catch: Exception -> 0x0285, InvalidProtocolBufferMicroException -> 0x0289, TRY_ENTER, TRY_LEAVE, TryCatch #11 {InvalidProtocolBufferMicroException -> 0x0289, blocks: (B:49:0x011b, B:54:0x0127, B:57:0x0134, B:66:0x0185, B:70:0x0195, B:80:0x0176, B:23:0x01e1, B:145:0x0233, B:148:0x0248, B:151:0x027c), top: B:8:0x0020 }] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.av.doodle.DoodleLogic] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int g(byte[] bArr) {
        String str;
        int i3;
        int i16;
        boolean z16;
        int i17;
        int i18;
        float f16;
        float f17;
        com.tencent.av.doodle.b[] bVarArr;
        com.tencent.av.doodle.b bVar;
        int i19;
        com.tencent.av.doodle.b bVar2;
        ?? r16 = this;
        int i26 = 1;
        int i27 = 0;
        try {
            try {
                try {
                    AVFunDrawing$MessageBody mergeFrom = new AVFunDrawing$MessageBody().mergeFrom(bArr);
                    int i28 = mergeFrom.uint32_msg_type.get();
                    str = "]";
                    try {
                        try {
                            try {
                                if (i28 != 1) {
                                    if (i28 != 2) {
                                        i16 = i28;
                                    } else {
                                        try {
                                            try {
                                                AVFunDrawing$DrawingInfo aVFunDrawing$DrawingInfo = mergeFrom.drawingInfo;
                                                long j3 = mergeFrom.uint64_time.get();
                                                long i29 = com.tencent.av.utils.e.i();
                                                if (i29 > j3) {
                                                    i17 = (int) (i29 - j3);
                                                } else {
                                                    i17 = 0 - ((int) (j3 - i29));
                                                }
                                                if (aVFunDrawing$DrawingInfo.msg_point_info.size() > 0) {
                                                    try {
                                                        i16 = i28;
                                                        try {
                                                            AVFunDrawing$PointInfo aVFunDrawing$PointInfo = aVFunDrawing$DrawingInfo.msg_point_info.get(0);
                                                            i18 = aVFunDrawing$PointInfo.uint32_type.get();
                                                            try {
                                                                f16 = aVFunDrawing$PointInfo.float_x.get();
                                                                f17 = aVFunDrawing$PointInfo.float_y.get();
                                                                bVarArr = r16.f73583b;
                                                                r16 = 1;
                                                                try {
                                                                    try {
                                                                        bVar = bVarArr[1];
                                                                    } catch (InvalidProtocolBufferMicroException e16) {
                                                                        e = e16;
                                                                        str = "DoodleLogic";
                                                                        i3 = r16;
                                                                        i27 = i16;
                                                                        QLog.w(str, i3, "receiveDoodle, InvalidProtocolBufferMicroException", e);
                                                                        return i27;
                                                                    }
                                                                } catch (Exception e17) {
                                                                    e = e17;
                                                                }
                                                            } catch (InvalidProtocolBufferMicroException e18) {
                                                                e = e18;
                                                            } catch (Exception e19) {
                                                                e = e19;
                                                            }
                                                        } catch (InvalidProtocolBufferMicroException e26) {
                                                            e = e26;
                                                            str = "DoodleLogic";
                                                        } catch (Exception e27) {
                                                            e = e27;
                                                            str = "DoodleLogic";
                                                        }
                                                    } catch (InvalidProtocolBufferMicroException e28) {
                                                        e = e28;
                                                        str = "DoodleLogic";
                                                        i16 = i28;
                                                    }
                                                    try {
                                                        try {
                                                            try {
                                                                if (i18 == 1) {
                                                                    try {
                                                                        bVarArr[1] = DoodleUtils.f(aVFunDrawing$DrawingInfo.uint32_pen_type.get());
                                                                    } catch (InvalidProtocolBufferMicroException e29) {
                                                                        e = e29;
                                                                        i3 = 1;
                                                                        str = "DoodleLogic";
                                                                        i27 = i16;
                                                                        QLog.w(str, i3, "receiveDoodle, InvalidProtocolBufferMicroException", e);
                                                                        return i27;
                                                                    }
                                                                } else if (bVar == null) {
                                                                    try {
                                                                        try {
                                                                            bVarArr[1] = DoodleUtils.f(aVFunDrawing$DrawingInfo.uint32_pen_type.get());
                                                                            if (i18 == 2) {
                                                                                i19 = 1;
                                                                                StringBuilder sb5 = new StringBuilder();
                                                                                sb5.append("receiveDoodle, point_type[");
                                                                                sb5.append(i18);
                                                                                sb5.append("->");
                                                                                sb5.append(i19);
                                                                                sb5.append("], pt[");
                                                                                sb5.append(f16);
                                                                                sb5.append(", ");
                                                                                sb5.append(f17);
                                                                                sb5.append("], uint32_seq[");
                                                                                sb5.append(mergeFrom.uint32_seq.get());
                                                                                sb5.append("], offset[");
                                                                                sb5.append(i17);
                                                                                sb5.append(" = ");
                                                                                sb5.append(i29);
                                                                                sb5.append(" - ");
                                                                                sb5.append(j3);
                                                                                sb5.append("], old[");
                                                                                sb5.append(bVar);
                                                                                sb5.append("], new[");
                                                                                i26 = 1;
                                                                                sb5.append(this.f73583b[1]);
                                                                                sb5.append("]");
                                                                                String sb6 = sb5.toString();
                                                                                str = "DoodleLogic";
                                                                                QLog.w(str, 2, sb6);
                                                                                i26 = 1;
                                                                                bVar2 = this.f73583b[1];
                                                                                if (bVar2 != null) {
                                                                                    bVar2.f73610c = aVFunDrawing$DrawingInfo.str_pen_name.get();
                                                                                    this.f73583b[1].f73614g = Color.parseColor(aVFunDrawing$DrawingInfo.str_pen_color.get());
                                                                                    this.f73583b[1].f73611d = aVFunDrawing$DrawingInfo.uint32_pen_width.get();
                                                                                    this.f73583b[1].f73612e = aVFunDrawing$DrawingInfo.uint32_screen_width.get();
                                                                                    this.f73583b[1].f73613f = aVFunDrawing$DrawingInfo.uint32_screen_height.get();
                                                                                    if (i19 != 1) {
                                                                                        if (i19 != 2) {
                                                                                            if (i19 == 3) {
                                                                                                p(1, f16, f17);
                                                                                            }
                                                                                        } else {
                                                                                            n(1, f16, f17);
                                                                                        }
                                                                                    } else {
                                                                                        ((IDoodleApi) QRoute.api(IDoodleApi.class)).notifyAddDoodleSurfaceView();
                                                                                        o(1, f16, f17);
                                                                                    }
                                                                                    StringBuilder sb7 = new StringBuilder();
                                                                                    sb7.append("receiveDoodle, after[");
                                                                                    i3 = 1;
                                                                                    try {
                                                                                        sb7.append(this.f73583b[1]);
                                                                                        sb7.append("]");
                                                                                        QLog.w(str, 2, sb7.toString());
                                                                                    } catch (InvalidProtocolBufferMicroException e36) {
                                                                                        e = e36;
                                                                                        i27 = i16;
                                                                                        QLog.w(str, i3, "receiveDoodle, InvalidProtocolBufferMicroException", e);
                                                                                        return i27;
                                                                                    }
                                                                                }
                                                                            }
                                                                        } catch (InvalidProtocolBufferMicroException e37) {
                                                                            e = e37;
                                                                            i3 = 1;
                                                                            str = "DoodleLogic";
                                                                            i27 = i16;
                                                                            QLog.w(str, i3, "receiveDoodle, InvalidProtocolBufferMicroException", e);
                                                                            return i27;
                                                                        }
                                                                    } catch (InvalidProtocolBufferMicroException e38) {
                                                                        e = e38;
                                                                        str = "DoodleLogic";
                                                                        i27 = i16;
                                                                        i3 = 1;
                                                                        QLog.w(str, i3, "receiveDoodle, InvalidProtocolBufferMicroException", e);
                                                                        return i27;
                                                                    }
                                                                }
                                                                bVar2 = this.f73583b[1];
                                                                if (bVar2 != null) {
                                                                }
                                                            } catch (InvalidProtocolBufferMicroException e39) {
                                                                e = e39;
                                                                i3 = i26;
                                                                i27 = i16;
                                                                QLog.w(str, i3, "receiveDoodle, InvalidProtocolBufferMicroException", e);
                                                                return i27;
                                                            }
                                                            i26 = 1;
                                                            sb5.append(this.f73583b[1]);
                                                            sb5.append("]");
                                                            String sb62 = sb5.toString();
                                                            str = "DoodleLogic";
                                                            QLog.w(str, 2, sb62);
                                                            i26 = 1;
                                                        } catch (InvalidProtocolBufferMicroException e46) {
                                                            e = e46;
                                                            str = "DoodleLogic";
                                                            i27 = i16;
                                                            i3 = 1;
                                                            QLog.w(str, i3, "receiveDoodle, InvalidProtocolBufferMicroException", e);
                                                            return i27;
                                                        }
                                                    } catch (Exception e47) {
                                                        e = e47;
                                                        str = "DoodleLogic";
                                                        i27 = i16;
                                                        QLog.w(str, 1, "receiveDoodle, Exception", e);
                                                        return i27;
                                                    }
                                                    i19 = i18;
                                                    StringBuilder sb52 = new StringBuilder();
                                                    sb52.append("receiveDoodle, point_type[");
                                                    sb52.append(i18);
                                                    sb52.append("->");
                                                    sb52.append(i19);
                                                    sb52.append("], pt[");
                                                    sb52.append(f16);
                                                    sb52.append(", ");
                                                    sb52.append(f17);
                                                    sb52.append("], uint32_seq[");
                                                    sb52.append(mergeFrom.uint32_seq.get());
                                                    sb52.append("], offset[");
                                                    sb52.append(i17);
                                                    sb52.append(" = ");
                                                    sb52.append(i29);
                                                    sb52.append(" - ");
                                                    sb52.append(j3);
                                                    sb52.append("], old[");
                                                    sb52.append(bVar);
                                                    sb52.append("], new[");
                                                } else {
                                                    i16 = i28;
                                                    QLog.w("DoodleLogic", 1, "receiveDoodle, msg_point_info[null], uint32_seq[" + mergeFrom.uint32_seq.get() + "], offset[" + i17 + " = " + i29 + " - " + j3 + "]");
                                                }
                                            } catch (InvalidProtocolBufferMicroException e48) {
                                                e = e48;
                                                str = "DoodleLogic";
                                                i16 = i28;
                                            }
                                        } catch (Exception e49) {
                                            e = e49;
                                            str = "DoodleLogic";
                                            i16 = i28;
                                        }
                                    }
                                } else {
                                    i16 = i28;
                                    AVFunDrawing$VersionInfo aVFunDrawing$VersionInfo = mergeFrom.versionInfo;
                                    r16.f73594m = aVFunDrawing$VersionInfo.uint32_version.get();
                                    if (aVFunDrawing$VersionInfo.uint32_support_drawing.get() != 0) {
                                        z16 = true;
                                    } else {
                                        z16 = false;
                                    }
                                    r16.f73593l = z16;
                                    QLog.w("DoodleLogic", 1, "receiveDoodle, mPeerVersion[" + r16.f73594m + "], mIsPeerSupport[" + r16.f73593l + "], uint32_seq[" + mergeFrom.uint32_seq.get() + "]");
                                    SmallScreenUtils.m();
                                }
                                return i16;
                            } catch (Exception e56) {
                                e = e56;
                            }
                        } catch (InvalidProtocolBufferMicroException e57) {
                            e = e57;
                        }
                    } catch (InvalidProtocolBufferMicroException e58) {
                        e = e58;
                    }
                } catch (InvalidProtocolBufferMicroException e59) {
                    e = e59;
                    str = "DoodleLogic";
                    i3 = 1;
                }
            } catch (Exception e65) {
                e = e65;
                str = "DoodleLogic";
            }
        } catch (InvalidProtocolBufferMicroException e66) {
            e = e66;
            str = "DoodleLogic";
            i3 = 1;
        }
    }

    public void h() {
        this.f73582a.clear();
        com.tencent.av.doodle.b[] bVarArr = this.f73583b;
        bVarArr[0] = null;
        bVarArr[1] = null;
        this.f73593l = false;
        this.f73594m = 0;
        this.f73586e = SupportMenu.CATEGORY_MASK;
        this.f73588g = -1.0f;
        boolean[] zArr = this.f73592k;
        zArr[0] = false;
        zArr[1] = false;
        int size = this.f73596o.size();
        this.f73596o.clear();
        QLog.w("DoodleLogic", 1, "resetDoodle, mSendQuene[" + size + "]", new Throwable("\u6253\u5370\u8c03\u7528\u6808"));
    }

    void j() {
        b poll = this.f73596o.poll();
        if (poll == null) {
            QLog.w("DoodleLogic", 1, "sendDoodle, \u7ed3\u675f");
            return;
        }
        AVFunDrawing$MessageBody aVFunDrawing$MessageBody = poll.f73597a;
        long i3 = com.tencent.av.utils.e.i();
        aVFunDrawing$MessageBody.uint64_time.set(i3);
        ((IDoodleApi) QRoute.api(IDoodleApi.class)).sendAVFunChatMsg(2, aVFunDrawing$MessageBody.toByteArray());
        AVFunDrawing$PointInfo aVFunDrawing$PointInfo = aVFunDrawing$MessageBody.drawingInfo.get().msg_point_info.get(0);
        float f16 = aVFunDrawing$PointInfo.float_x.get();
        float f17 = aVFunDrawing$PointInfo.float_y.get();
        int i16 = aVFunDrawing$PointInfo.uint32_type.get();
        if (QLog.isDevelopLevel()) {
            QLog.w("DoodleLogic", 1, "sendDoodle, sendtime[" + i3 + "], offset[" + (i3 - poll.f73598b) + "], pt[" + f16 + ", " + f17 + "], uint32_type[" + i16 + "], uint32_seq[" + aVFunDrawing$MessageBody.uint32_seq.get() + "], size[" + this.f73596o.size() + "]");
        }
        if (this.f73596o.size() > 0) {
            m(1L, false);
        }
    }

    public void k() {
        boolean e16 = DoodleUtils.e();
        AVFunDrawing$MessageBody aVFunDrawing$MessageBody = new AVFunDrawing$MessageBody();
        aVFunDrawing$MessageBody.uint32_msg_type.set(1);
        AVFunDrawing$VersionInfo aVFunDrawing$VersionInfo = new AVFunDrawing$VersionInfo();
        aVFunDrawing$VersionInfo.uint32_version.set(1);
        aVFunDrawing$VersionInfo.uint32_support_drawing.set(e16 ? 1 : 0);
        aVFunDrawing$MessageBody.versionInfo.set(aVFunDrawing$VersionInfo);
        int a16 = a();
        aVFunDrawing$MessageBody.uint32_seq.set(a16);
        ((IDoodleApi) QRoute.api(IDoodleApi.class)).sendAVFunChatMsg(2, aVFunDrawing$MessageBody.toByteArray());
        QLog.w("DoodleLogic", 1, "sendSelfIsSupport, isSelfSupport[" + e16 + "], seq[" + a16 + "]");
        SmallScreenUtils.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(a aVar) {
        this.f73585d = aVar;
    }

    void m(long j3, boolean z16) {
        if (com.tencent.av.utils.e.k() && z16) {
            QLog.w("DoodleLogic", 1, "startSendDoodleHandle, delayMillis[" + j3 + "]");
        }
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.av.doodle.DoodleLogic.1
            @Override // java.lang.Runnable
            public void run() {
                DoodleLogic.this.j();
            }
        }, j3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i3, float f16, float f17) {
        boolean z16;
        this.f73591j.lock();
        try {
            com.tencent.av.doodle.b bVar = this.f73583b[i3];
            if (bVar != null && bVar.e(f16, f17)) {
                if (i3 == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.f73584c = z16;
                if (z16) {
                    i(2);
                }
                a aVar = this.f73585d;
                if (aVar != null) {
                    aVar.invalidate();
                }
            }
        } finally {
            this.f73591j.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i3, float f16, float f17) {
        boolean z16;
        this.f73591j.lock();
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        try {
            this.f73584c = z16;
            this.f73592k[i3] = true;
            if (z16) {
                this.f73583b[0] = DoodleUtils.f(this.f73587f);
                com.tencent.av.doodle.b bVar = this.f73583b[0];
                bVar.f73614g = this.f73586e;
                bVar.f73609b = this.f73587f;
                bVar.f73612e = this.f73589h;
                bVar.f73613f = this.f73590i;
            }
            QLog.w("DoodleLogic", 1, "touch_start, index[" + i3 + "], item[" + this.f73583b[i3] + "], pt[" + f16 + ", " + f17 + "]");
            this.f73583b[i3].f(f16, f17);
            if (this.f73584c) {
                i(1);
            }
            a aVar = this.f73585d;
            if (aVar != null) {
                aVar.invalidate();
            }
        } finally {
            this.f73591j.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i3, float f16, float f17) {
        boolean z16;
        this.f73591j.lock();
        try {
            com.tencent.av.doodle.b bVar = this.f73583b[i3];
            if (bVar != null) {
                bVar.g(f16, f17);
            }
            if (i3 == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f73584c = z16;
            if (z16) {
                i(3);
            }
            QLog.w("DoodleLogic", 1, "touch_up, index[" + i3 + "], item[" + this.f73583b[i3] + "], pt[" + f16 + ", " + f17 + "]");
            e(i3);
            a aVar = this.f73585d;
            if (aVar != null) {
                aVar.invalidate();
            }
            this.f73592k[i3] = false;
        } finally {
            this.f73591j.unlock();
        }
    }
}
