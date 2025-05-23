package com.tencent.luggage.wxa.l;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Point;
import com.tencent.luggage.wxa.k.f;
import com.tencent.luggage.wxa.k.q;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class b implements Comparator {
        public b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(q qVar, q qVar2) {
            int a16 = qVar.a() * qVar.b();
            int a17 = qVar2.a() * qVar2.b();
            if (a17 < a16) {
                return -1;
            }
            if (a17 > a16) {
                return 1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public Point f132753a;

        /* renamed from: b, reason: collision with root package name */
        public Point f132754b;

        /* renamed from: c, reason: collision with root package name */
        public Point f132755c;

        /* renamed from: d, reason: collision with root package name */
        public Point f132756d;

        /* renamed from: e, reason: collision with root package name */
        public Point f132757e;

        /* renamed from: f, reason: collision with root package name */
        public Point f132758f;

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            if (this.f132753a != null) {
                stringBuffer.append(this.f132753a.toString() + ",");
            }
            if (this.f132754b != null) {
                stringBuffer.append(this.f132754b.toString() + ",");
            }
            if (this.f132755c != null) {
                stringBuffer.append(this.f132755c.toString() + ",");
            }
            if (this.f132756d != null) {
                stringBuffer.append(this.f132756d.toString() + ",");
            }
            if (this.f132757e != null) {
                stringBuffer.append(this.f132757e.toString() + ",");
            }
            if (this.f132758f != null) {
                stringBuffer.append(this.f132758f.toString() + ",");
            }
            return stringBuffer.toString();
        }
    }

    public static c a(Context context, List list, Point point, int i3, boolean z16) {
        if (list == null) {
            return null;
        }
        return a(context, list, point, i3, 0, z16);
    }

    public static c b(Context context, List list, Point point, int i3, boolean z16) {
        if (list == null) {
            return null;
        }
        Collections.sort(list, new b());
        f.b("MicroMsg.CameraSizeUtil", "tryFindPreviewSizeAnyWay supportedPreviewSizes: %s", a(list));
        int i16 = point.x;
        f.a("MicroMsg.CameraSizeUtil", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewview: %s", Integer.valueOf(i16), Integer.valueOf(point.y), Float.valueOf(i16 / point.y), Integer.valueOf(i3));
        f.a("MicroMsg.CameraSizeUtil", "systemAvailableMemInMB: %d", Long.valueOf(a(context)));
        c cVar = new c();
        Point a16 = a(list, point, z16, i3);
        cVar.f132753a = a16;
        if (a16 != null) {
            cVar.f132754b = a(point, a16, z16);
            cVar.f132755c = a(point, cVar.f132753a, z16, true);
        } else {
            Point point2 = new Point();
            Math.min(point.x, point.y);
            Math.max(point.x, point.y);
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q qVar = (q) it.next();
                point2.x = qVar.b();
                int a17 = qVar.a();
                point2.y = a17;
                int i17 = point2.x;
                if (i17 != a17 && Math.min(i17, a17) <= i3 && Math.max(point2.x, point2.y) <= 2000 && a(point, point2, z16) != null) {
                    cVar.f132753a = new Point(qVar.b(), qVar.a());
                    break;
                }
            }
        }
        f.a("MicroMsg.CameraSizeUtil", "final tryFindBestSize PrewviewSize %s cropSize %s findcount %d with any way", cVar.f132753a, cVar.f132754b, 0);
        return cVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ed A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static c a(Context context, List list, Point point, int i3, int i16, boolean z16) {
        Point b16;
        if (list == null) {
            return null;
        }
        Collections.sort(list, new b());
        f.b("MicroMsg.CameraSizeUtil", "supportedPreviewSizes: %s", a(list));
        int i17 = point.x;
        int i18 = 0;
        f.b("MicroMsg.CameraSizeUtil", "screen.x: %d, screen.y: %d, ratio: %f, upperBoundPrewview: %s lowerBoundPreView: %s", Integer.valueOf(i17), Integer.valueOf(point.y), Float.valueOf(i17 / point.y), Integer.valueOf(i3), Integer.valueOf(i16));
        f.a("MicroMsg.CameraSizeUtil", "systemAvailableMemInMB: %d", Long.valueOf(a(context)));
        c cVar = new c();
        Point a16 = a(list, point, z16, i3);
        cVar.f132753a = a16;
        if (a16 != null) {
            cVar.f132754b = b(point, a16, z16);
            cVar.f132755c = b(point, cVar.f132753a, z16, true);
        } else {
            Point point2 = new Point();
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                q qVar = (q) it.next();
                point2.x = qVar.b();
                int a17 = qVar.a();
                point2.y = a17;
                int i19 = point2.x;
                if (i19 == a17) {
                    f.b("MicroMsg.CameraSizeUtil", "exclude square curSize: %s", point2);
                } else if (point.y > point.x) {
                    if (a17 >= i19) {
                        f.c("MicroMsg.CameraSizeUtil", "screen ratio is differ from preview ratio and unSupport preview is " + qVar);
                    } else {
                        b16 = b(point, point2, z16);
                        if (b16 != null) {
                            f.b("MicroMsg.CameraSizeUtil", "curSize: %s, can not find crop size", point2);
                        } else {
                            f.a("MicroMsg.CameraSizeUtil", "preViewPoint: %s --> bestSize %s ", point2, b16);
                            cVar.f132757e = new Point(b16.x, b16.y);
                            cVar.f132756d = new Point(point2.x, point2.y);
                            cVar.f132758f = b(point, point2, z16, true);
                            if (Math.min(b16.x, b16.y) <= i3) {
                                if (Math.min(b16.x, b16.y) < i16) {
                                    return null;
                                }
                                Point point3 = new Point(point2.x, point2.y);
                                cVar.f132753a = point3;
                                cVar.f132754b = b16;
                                cVar.f132755c = b(point, point3, z16, true);
                                f.a("MicroMsg.CameraSizeUtil", "find bestPreviewSize  %s -> %s findcount %d", point3, b16, 1);
                                i18 = 1;
                            }
                        }
                    }
                } else if (a17 <= i19) {
                    f.c("MicroMsg.CameraSizeUtil", "screen ratio is differ from preview ratio and unSupport preview is " + qVar);
                } else {
                    b16 = b(point, point2, z16);
                    if (b16 != null) {
                    }
                }
            }
        }
        f.a("MicroMsg.CameraSizeUtil", "final tryFindBestSize PrewviewSize %s cropSize %s findcount %d", cVar.f132753a, cVar.f132754b, Integer.valueOf(i18));
        return cVar;
    }

    public static Point b(Point point, Point point2, boolean z16) {
        return b(point, point2, z16, false);
    }

    public static Point b(Point point, Point point2, boolean z16, boolean z17) {
        int i3 = point2.x;
        int i16 = point2.y;
        int i17 = z16 ? point.y : point.x;
        float f16 = z16 ? point.x : point.y;
        float f17 = i17;
        int i18 = (int) (i3 * (f16 / f17));
        if (i18 % 2 != 0) {
            i18--;
        }
        int i19 = (int) (i16 * (f17 / f16));
        if (z17) {
            i18 = a(i18, i16);
        }
        f.b("MicroMsg.CameraSizeUtil", "getCropPreviewSizeWithHeight, previewSize: %s, displaySize: %s, width: %s, newHeight: %s makeMediaCodecHappy %s, newWidth: %s, isRoate: %s", point2, point, Integer.valueOf(i3), Integer.valueOf(i18), Boolean.valueOf(z17), Integer.valueOf(i19), Boolean.valueOf(z16));
        if (i18 <= point2.y && i3 <= point2.x) {
            return new Point(i3, i18);
        }
        f.c("MicroMsg.CameraSizeUtil", "can not adapt to screen");
        return null;
    }

    public static Point a(List list, Point point, boolean z16, int i3) {
        int i16;
        int i17 = point.x;
        int i18 = point.y * i3;
        if (i18 % i17 != 0) {
            return null;
        }
        int i19 = i18 / i17;
        if (z16) {
            int i26 = i3 ^ i19;
            i19 ^= i26;
            i16 = i26 ^ i19;
        } else {
            i16 = i3;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            if (qVar.b() == i16 && qVar.a() == i19) {
                f.a("MicroMsg.CameraSizeUtil", "findEqualsPrewviewSize FindBestSize %d %d", Integer.valueOf(i16), Integer.valueOf(i19));
                return new Point(i16, i19);
            }
            if (Math.min(qVar.b(), qVar.a()) < i3) {
                break;
            }
        }
        return null;
    }

    public static Point a(Point point, Point point2, boolean z16) {
        return a(point, point2, z16, false);
    }

    public static Point a(Point point, Point point2, boolean z16, boolean z17) {
        int i3 = point2.x;
        int i16 = point2.y;
        int i17 = z16 ? point.y : point.x;
        int i18 = z16 ? point.x : point.y;
        float f16 = (i3 >= i17 || i16 >= i18) ? -1.0f : (i16 * 1.0f) / i18;
        int round = f16 > 0.0f ? Math.round(i17 * f16) : (int) (i16 * (i17 / i18));
        if (round % 2 != 0) {
            round++;
        }
        if (z17) {
            round = a(round, point2.y);
        }
        f.b("MicroMsg.CameraSizeUtil", "getCropPreviewSizeWithHeight, previewSize: %s, displaySize: %s, width: %s, newWidth: %s, makeMediaCodecHappy %s, , isRoate: %s", point2, point, Integer.valueOf(i3), Integer.valueOf(round), Boolean.valueOf(z17), Boolean.valueOf(z16));
        if (round > point2.x && f16 <= 0.0f) {
            f.c("MicroMsg.CameraSizeUtil", "can not adapt to screen");
            return null;
        }
        return new Point(round, i16);
    }

    public static Point a(int i3, int i16, int i17, float f16) {
        if (i3 <= 0 || i16 <= 0) {
            return null;
        }
        if (i17 == 90 || i17 == 270) {
            f16 = 1.0f / f16;
        }
        float f17 = 1.0f / f16;
        if (!(((float) i16) * f16 < ((float) i3))) {
            int max = Math.max(i16, i3);
            int i18 = (int) (max * f17);
            if (i17 != 90 && i17 != 270) {
                return new Point(max, i18);
            }
            return new Point(i18, max);
        }
        int min = Math.min(i16, i3);
        int i19 = (int) (min / f17);
        if (i17 != 90 && i17 != 270) {
            return new Point(i19, min);
        }
        return new Point(min, i19);
    }

    public static int a(int i3) {
        return a(i3, Integer.MAX_VALUE);
    }

    public static int a(int i3, int i16) {
        int i17 = i3 % 16;
        if (i17 == 0) {
            return i3;
        }
        int i18 = (16 - i17) + i3;
        return i18 < i16 ? i18 : i3 - i17;
    }

    public static String a(List list) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            q qVar = (q) it.next();
            stringBuffer.append("size: " + qVar.a() + "," + qVar.b() + " " + ((qVar.a() * 1.0d) / qVar.b()) + "||");
        }
        return stringBuffer.toString();
    }

    public static long a(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager == null) {
            return 0L;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return (memoryInfo.availMem / 1024) / 1024;
    }
}
