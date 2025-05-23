package com.qzone.proxy.feedcomponent.text;

import android.graphics.Paint;
import com.etrump.mixlayout.api.IETEngine;
import com.etrump.mixlayout.api.IETFont;
import com.etrump.mixlayout.o;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.font.api.IETFontService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.font.IFontManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e {

    /* renamed from: h, reason: collision with root package name */
    private static Object f50713h = new Object();

    /* renamed from: i, reason: collision with root package name */
    private static e f50714i;

    /* renamed from: a, reason: collision with root package name */
    private IETEngine f50715a;

    /* renamed from: b, reason: collision with root package name */
    private IETEngine f50716b;

    /* renamed from: c, reason: collision with root package name */
    private IETEngine f50717c;

    /* renamed from: d, reason: collision with root package name */
    public AtomicBoolean f50718d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    public AtomicBoolean f50719e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    public AtomicBoolean f50720f = new AtomicBoolean(false);

    /* renamed from: g, reason: collision with root package name */
    public AtomicBoolean f50721g = new AtomicBoolean(false);

    private IETEngine a() {
        if (l()) {
            return ((IETFontService) QRoute.api(IETFontService.class)).getETEngineInstance();
        }
        return null;
    }

    public static e f() {
        if (f50714i == null) {
            f50714i = new e();
        }
        return f50714i;
    }

    private boolean l() {
        if (!o.b() && o.a()) {
            return o.c();
        }
        if (o.a()) {
            return true;
        }
        ((IFontManager) QRoute.api(IFontManager.class)).startFontSoDownload(null);
        QLog.d("ETSpace", 1, "initEngine but libvipfont.so didn't download, start download.");
        return false;
    }

    public IETEngine b() {
        return this.f50715a;
    }

    public IETEngine c() {
        i();
        return this.f50717c;
    }

    public IETEngine d() {
        k();
        return this.f50716b;
    }

    public synchronized Paint.FontMetrics e(IETFont iETFont) {
        if (this.f50715a != null && iETFont != null) {
            Paint.FontMetrics fontMetrics = new Paint.FontMetrics();
            if (this.f50715a.nativeGetFontMetrics(fontMetrics, iETFont)) {
                return fontMetrics;
            }
        }
        return null;
    }

    public synchronized int g(String str, int i3, int i16, IETFont iETFont, Paint paint, float[] fArr, boolean z16) {
        IETEngine iETEngine;
        if (z16) {
            iETEngine = this.f50716b;
        } else {
            iETEngine = this.f50715a;
        }
        IETEngine iETEngine2 = iETEngine;
        if (iETEngine2 == null) {
            return 0;
        }
        int nativeSpaceGetTextWidths = iETEngine2.nativeSpaceGetTextWidths(str, i3, i16, iETFont, paint, new int[fArr.length]);
        for (int i17 = 0; i17 < nativeSpaceGetTextWidths; i17++) {
            fArr[i17] = r7[i17];
        }
        return nativeSpaceGetTextWidths;
    }

    public boolean h(int i3, int i16) {
        if (this.f50715a != null && this.f50718d.get()) {
            return true;
        }
        synchronized (f50713h) {
            if (this.f50715a == null) {
                this.f50715a = a();
            }
            IETEngine iETEngine = this.f50715a;
            if (iETEngine == null) {
                return false;
            }
            try {
                try {
                    if (iETEngine.initEngine(i3, i16)) {
                        if (QLog.isColorLevel()) {
                            QLog.d("ETSpace", 2, "start init font engine,num=" + i3 + ",cache=" + i16);
                        }
                        this.f50718d.set(true);
                    }
                    return true;
                } catch (Error e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("ETSpace", 2, "init font engine fail " + e16.getMessage());
                    }
                    return false;
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                return false;
            }
        }
    }

    public boolean i() {
        if (this.f50717c != null && this.f50720f.get()) {
            return true;
        }
        synchronized (f50713h) {
            if (this.f50717c == null) {
                this.f50717c = l() ? ((IETFontService) QRoute.api(IETFontService.class)).getInstanceForAnimation() : null;
            }
            IETEngine iETEngine = this.f50717c;
            if (iETEngine == null) {
                return false;
            }
            try {
                boolean initEngine = iETEngine.initEngine(8, 10485760);
                if (initEngine) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ETSpace", 2, "start init xuandong Animation engine succ");
                    }
                    this.f50720f.set(true);
                }
                return initEngine;
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("ETSpace", 2, "init xuandong Animation engine fail " + th5.getMessage());
                }
                return false;
            }
        }
    }

    public boolean j() {
        return k() && i();
    }

    public boolean k() {
        if (this.f50716b != null && this.f50719e.get()) {
            return true;
        }
        synchronized (f50713h) {
            if (this.f50716b == null) {
                this.f50716b = l() ? ((IETFontService) QRoute.api(IETFontService.class)).getInstanceForSpace() : null;
            }
            IETEngine iETEngine = this.f50716b;
            if (iETEngine == null) {
                return false;
            }
            try {
                boolean initEngine = iETEngine.initEngine(8, 10485760);
                if (initEngine) {
                    if (QLog.isColorLevel()) {
                        QLog.d("ETSpace", 2, "start init xuandong space engine succ");
                    }
                    this.f50719e.set(true);
                }
                return initEngine;
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("ETSpace", 2, "init xuandong space engine fail " + th5.getMessage());
                }
                return false;
            }
        }
    }

    public synchronized float m(String str, int i3, int i16, IETFont iETFont, Paint paint) {
        if (this.f50715a == null) {
            return 0.0f;
        }
        return r0.nativeSpaceMeasureText(str, i3, i16, iETFont, paint);
    }
}
