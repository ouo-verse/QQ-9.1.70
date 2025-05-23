package com.tencent.luggage.wxa.n1;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue;
import com.tencent.luggage.wxa.tk.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.qbar.QBar;
import com.tencent.qbar.QbarNative;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public long f135114a;

    /* renamed from: c, reason: collision with root package name */
    public C6494b f135116c;

    /* renamed from: d, reason: collision with root package name */
    public c f135117d;

    /* renamed from: b, reason: collision with root package name */
    public int[] f135115b = {2, 1};

    /* renamed from: e, reason: collision with root package name */
    public LuggageScanDecodeQueue.ScanDecodeCallBack f135118e = new a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.n1.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6494b {

        /* renamed from: a, reason: collision with root package name */
        public int f135125a;

        /* renamed from: b, reason: collision with root package name */
        public int f135126b;

        /* renamed from: c, reason: collision with root package name */
        public int f135127c;

        /* renamed from: d, reason: collision with root package name */
        public int f135128d;

        /* renamed from: e, reason: collision with root package name */
        public int f135129e;

        public C6494b(int i3, int i16, int i17, int i18, int i19) {
            this.f135125a = i3;
            this.f135126b = i16;
            this.f135127c = i17;
            this.f135128d = i18;
            this.f135129e = i19;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c {
        void a();

        void a(int i3, String str, int i16, byte[] bArr, QbarNative.QBarPoint qBarPoint);
    }

    public void b() {
        LuggageScanDecodeQueue.getInstance().stopSession(this.f135114a);
        LuggageScanDecodeQueue.getInstance().release();
    }

    public void a(c cVar) {
        this.f135117d = cVar;
    }

    public void a(Context context) {
        this.f135114a = System.currentTimeMillis();
        LuggageScanDecodeQueue.getInstance().init(context);
        LuggageScanDecodeQueue.getInstance().setReaders(this.f135115b);
        LuggageScanDecodeQueue.getInstance().startSession(this.f135114a, this.f135118e);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x00fb, code lost:
    
        if (r0.f135128d != r21) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(byte[] bArr, int i3, int i16, int i17, int i18, Point point, Rect rect, int i19, int i26) {
        int i27;
        Rect rect2;
        int i28;
        if (rect == null) {
            Rect rect3 = new Rect(0, 0, i3, i16);
            w.d("WMPF.QbarScanDecoder", "scanArea is null, use whole screen area, left: %d, top: %d, right: %d, bottom: %d", 0, 0, Integer.valueOf(i3), Integer.valueOf(i16));
            rect2 = rect3;
            i27 = i3;
            i28 = i16;
        } else {
            w.d("WMPF.QbarScanDecoder", "origin scan area decodeDegrees: %d, left: %d, top: %d, right: %d, bottom: %d", Integer.valueOf(i19), Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom));
            Rect a16 = a(rect, point, i3, i16, i19, i26);
            w.d("WMPF.QbarScanDecoder", "translated scan area decodeDegrees: %d, left: %d, top: %d, right: %d, bottom: %d", Integer.valueOf(i19), Integer.valueOf(a16.left), Integer.valueOf(a16.top), Integer.valueOf(a16.right), Integer.valueOf(a16.bottom));
            int i29 = a16.left;
            if (i29 >= i3) {
                i29 = i3 - 1;
            }
            int i36 = a16.top;
            if (i36 >= i16) {
                i36 = i16 - 1;
            }
            int abs = Math.abs(a16.width()) + i29 > i3 ? i3 - i29 : Math.abs(a16.width());
            int abs2 = Math.abs(a16.height()) + i36 > i16 ? i16 - i36 : Math.abs(a16.height());
            Rect rect4 = new Rect(i29, i36, i29 + abs, i36 + abs2);
            i27 = abs;
            rect2 = rect4;
            i28 = abs2;
        }
        C6494b c6494b = this.f135116c;
        if (c6494b != null && c6494b.f135127c == i17) {
        }
        this.f135116c = new C6494b(i27, i28, i17, i18, i19);
        LuggageScanDecodeQueue.getInstance().addDecodeTask(bArr, new Point(i3, i16), i19, rect2);
    }

    public final void a(int i3, String str, int i16, byte[] bArr, QbarNative.QBarPoint qBarPoint) {
        c cVar = this.f135117d;
        if (cVar != null) {
            cVar.a(i3, str, i16, bArr, qBarPoint);
        }
    }

    public final void a() {
        c cVar = this.f135117d;
        if (cVar != null) {
            cVar.a();
        }
    }

    public final Rect a(Rect rect, Point point, int i3, int i16, int i17, int i18) {
        int i19;
        int i26;
        Rect rect2 = new Rect();
        int i27 = rect.left;
        int i28 = rect.top;
        int i29 = rect.right;
        int i36 = rect.bottom;
        if (point != null) {
            if (i17 != 90 && i17 != 270) {
                i26 = Math.max(i16 - point.y, 0);
                i19 = Math.max(i3 - point.x, 0);
            } else {
                i26 = Math.max(i3 - point.y, 0);
                i19 = Math.max(i16 - point.x, 0);
            }
            if (i18 == 1) {
                i19 /= 2;
                i26 /= 2;
            }
        } else {
            i19 = 0;
            i26 = 0;
        }
        int i37 = 360 - i17;
        if (i37 == 0) {
            rect2.left = i27 + i19;
            rect2.top = i28 + i26;
            rect2.right = i29 + i19;
            rect2.bottom = i36 + i26;
        } else if (i37 == 90) {
            int i38 = (i3 - i36) - i26;
            rect2.left = i38;
            rect2.left = Math.max(i38, 0);
            rect2.top = i27 + i19;
            int i39 = (i3 - i28) - i26;
            rect2.right = i39;
            rect2.right = Math.max(i39, 0);
            rect2.bottom = i29 + i19;
        } else if (i37 == 180) {
            int i46 = (i3 - i29) - i19;
            rect2.left = i46;
            rect2.left = Math.max(i46, 0);
            int i47 = (i16 - i36) - i26;
            rect2.top = i47;
            rect2.top = Math.max(i47, 0);
            int i48 = (i3 - i27) - i19;
            rect2.right = i48;
            rect2.right = Math.max(i48, 0);
            int i49 = (i16 - i28) - i26;
            rect2.bottom = i49;
            rect2.bottom = Math.max(i49, 0);
        } else if (i37 == 270) {
            rect2.left = i28 + i26;
            int i56 = (i16 - i29) - i19;
            rect2.top = i56;
            rect2.top = Math.max(i56, 0);
            rect2.right = i36 + i26;
            int i57 = (i16 - i27) - i19;
            rect2.bottom = i57;
            rect2.bottom = Math.max(i57, 0);
        }
        return rect2;
    }

    public final void a(QbarNative.QBarPoint qBarPoint, C6494b c6494b) {
        if (qBarPoint == null) {
            return;
        }
        int i3 = c6494b.f135125a;
        int i16 = c6494b.f135126b;
        int i17 = c6494b.f135127c;
        int i18 = c6494b.f135128d;
        int i19 = c6494b.f135129e;
        if (i19 == 90 || i19 == 270) {
            i16 = i3;
            i3 = i16;
        }
        float f16 = qBarPoint.f342416x0;
        float f17 = qBarPoint.f342417x1;
        float f18 = qBarPoint.f342418x2;
        float f19 = qBarPoint.f342419x3;
        float f26 = qBarPoint.f342420y0;
        float f27 = qBarPoint.f342421y1;
        float f28 = qBarPoint.f342422y2;
        float f29 = qBarPoint.f342423y3;
        int i26 = (i19 + 270) % 360;
        if (i26 == 90) {
            float f36 = i3;
            qBarPoint.f342416x0 = f36 - f19;
            qBarPoint.f342417x1 = f36 - f16;
            qBarPoint.f342418x2 = f36 - f17;
            qBarPoint.f342419x3 = f36 - f18;
            qBarPoint.f342420y0 = f29;
            qBarPoint.f342421y1 = f26;
            qBarPoint.f342422y2 = f27;
            qBarPoint.f342423y3 = f28;
        } else if (i26 == 180) {
            float f37 = i3;
            qBarPoint.f342416x0 = f37 - f18;
            qBarPoint.f342417x1 = f37 - f19;
            qBarPoint.f342418x2 = f37 - f16;
            qBarPoint.f342419x3 = f37 - f17;
            float f38 = i16;
            qBarPoint.f342420y0 = f38 - f28;
            qBarPoint.f342421y1 = f38 - f29;
            qBarPoint.f342422y2 = f38 - f26;
            qBarPoint.f342423y3 = f38 - f27;
        } else if (i26 == 270) {
            qBarPoint.f342416x0 = f17;
            qBarPoint.f342417x1 = f18;
            qBarPoint.f342418x2 = f19;
            qBarPoint.f342419x3 = f16;
            float f39 = i16;
            qBarPoint.f342420y0 = f39 - f27;
            qBarPoint.f342421y1 = f39 - f28;
            qBarPoint.f342422y2 = f39 - f29;
            qBarPoint.f342423y3 = f39 - f26;
        }
        float max = Math.max((i18 * 1.0f) / i16, (i17 * 1.0f) / i3);
        qBarPoint.f342416x0 *= max;
        qBarPoint.f342417x1 *= max;
        qBarPoint.f342418x2 *= max;
        qBarPoint.f342419x3 *= max;
        qBarPoint.f342420y0 *= max;
        qBarPoint.f342421y1 *= max;
        qBarPoint.f342422y2 *= max;
        qBarPoint.f342423y3 *= max;
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements LuggageScanDecodeQueue.ScanDecodeCallBack {

        /* compiled from: P */
        /* renamed from: com.tencent.luggage.wxa.n1.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes8.dex */
        public class RunnableC6493a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f135120a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ List f135121b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ List f135122c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ List f135123d;

            public RunnableC6493a(long j3, List list, List list2, List list3) {
                this.f135120a = j3;
                this.f135121b = list;
                this.f135122c = list2;
                this.f135123d = list3;
            }

            @Override // java.lang.Runnable
            public void run() {
                int i3;
                QbarNative.QBarPoint qBarPoint;
                long j3 = b.this.f135114a;
                long j16 = this.f135120a;
                if (j3 == j16 && j16 != 0) {
                    List list = this.f135121b;
                    if (list == null || list.isEmpty()) {
                        b.this.a();
                        return;
                    }
                    int i16 = 1;
                    w.d("WMPF.QbarScanDecoder", "onDecodeSuccess result size: %d", Integer.valueOf(this.f135121b.size()));
                    QBar.QBarResult qBarResult = (QBar.QBarResult) this.f135121b.get(0);
                    List list2 = this.f135122c;
                    if (list2 != null && !list2.isEmpty()) {
                        i3 = ((QbarNative.QBarReportMsg) this.f135122c.get(0)).qrcodeVersion;
                    } else {
                        i3 = 0;
                    }
                    List list3 = this.f135123d;
                    if (list3 != null && !list3.isEmpty()) {
                        qBarPoint = (QbarNative.QBarPoint) this.f135123d.get(0);
                    } else {
                        qBarPoint = null;
                    }
                    QbarNative.QBarPoint qBarPoint2 = qBarPoint;
                    if (b.this.f135116c != null) {
                        b bVar = b.this;
                        bVar.a(qBarPoint2, bVar.f135116c);
                    }
                    String str = qBarResult.typeName;
                    if (!str.equals(CommonConstant.RETKEY.QR_CODE) && !str.equals("WX_CODE")) {
                        i16 = 2;
                    }
                    b.this.a(i16, qBarResult.data, i3, qBarResult.rawData, qBarPoint2);
                }
            }
        }

        public a() {
        }

        @Override // com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue.ScanDecodeCallBack
        public void onDecodeSuccess(long j3, List list, List list2, List list3, Bundle bundle) {
            l.a(new RunnableC6493a(j3, list, list3, list2));
        }

        @Override // com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue.ScanDecodeCallBack
        public void notifyEvent(long j3, Bundle bundle) {
        }

        @Override // com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue.ScanDecodeCallBack
        public void postTakeShot(long j3, long j16) {
        }
    }
}
