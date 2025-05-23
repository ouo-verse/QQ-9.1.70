package com.tencent.mobileqq.activity.aio.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.doodle.LoadDataJob;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes10.dex */
public class DoodleDrawer implements com.tencent.mobileqq.scribble.b, LoadDataJob.b {
    private Canvas C;
    private Paint H;
    private WeakReference<a> J;
    private String L;
    private View M;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f178352m;

    /* renamed from: d, reason: collision with root package name */
    private int f178347d = -1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f178348e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f178349f = 0;

    /* renamed from: h, reason: collision with root package name */
    private g f178350h = new g();

    /* renamed from: i, reason: collision with root package name */
    private List<o> f178351i = new ArrayList();
    private int D = 0;
    private int E = 0;
    private Object F = new Object();
    private long G = -1;
    private long I = -1;
    private boolean K = false;
    private b N = new b();
    private LoadDataJob P = null;
    private Map<Integer, Integer> Q = new HashMap();
    boolean R = false;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        void a(String str, long j3, Bitmap bitmap);

        void b(String str, int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private bc f178356a;

        b() {
        }

        public void a(Runnable runnable) {
            bc bcVar;
            if (runnable != null && (bcVar = this.f178356a) != null) {
                bcVar.post(runnable);
            }
        }

        public void b() {
            bc bcVar = this.f178356a;
            if (bcVar != null) {
                bcVar.removeCallbacksAndMessages(null);
            }
        }

        public void c() {
            if (this.f178356a == null) {
                this.f178356a = ThreadManagerV2.newHandlerRecycleThread("DoodleDrawerThread", 0).b();
            }
        }

        public void d() {
            bc bcVar = this.f178356a;
            if (bcVar != null) {
                bcVar.removeCallbacksAndMessages(null);
                this.f178356a = null;
            }
        }
    }

    private void B(int i3) {
        synchronized (this.f178351i) {
            for (o oVar : this.f178351i) {
                if (oVar.n() == i3) {
                    oVar.v(i3);
                }
            }
        }
    }

    private boolean e() {
        boolean z16 = false;
        if (this.E > 0 && this.D > 0) {
            synchronized (this.F) {
                Bitmap bitmap = this.f178352m;
                if (bitmap != null && this.C != null) {
                    return true;
                }
                if (bitmap != null) {
                    try {
                        try {
                            DoodleResHelper.k().o(this.f178352m);
                            this.f178352m = null;
                        } catch (OutOfMemoryError unused) {
                            if (QLog.isColorLevel()) {
                                QLog.e("DoodleDrawer", 2, "create bitmapcache OOM!");
                            }
                            if (this.f178352m != null) {
                                DoodleResHelper.k().o(this.f178352m);
                                this.f178352m = null;
                            }
                            this.C = null;
                            this.G = -1L;
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("DoodleDrawer", 2, "create bitmapcache execption!" + e16);
                        }
                        if (this.f178352m != null) {
                            DoodleResHelper.k().o(this.f178352m);
                            this.f178352m = null;
                        }
                        this.C = null;
                        this.G = -1L;
                    }
                }
                Bitmap c16 = DoodleResHelper.k().c(this.D, this.E);
                this.f178352m = c16;
                if (c16 != null) {
                    Canvas canvas = new Canvas(this.f178352m);
                    this.C = canvas;
                    canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
                    this.D = this.f178352m.getWidth();
                    this.E = this.f178352m.getHeight();
                }
                g();
                z16 = true;
                return z16;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("DoodleDrawer", 2, "checkcache error:" + this.D + "-" + this.E);
        }
        return false;
    }

    private boolean f(String str) {
        synchronized (this) {
            String str2 = this.L;
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                return true;
            }
            this.L = str;
            return false;
        }
    }

    private void g() {
        Paint paint;
        synchronized (this.F) {
            if (this.H == null) {
                Paint paint2 = new Paint();
                this.H = paint2;
                paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            }
            Canvas canvas = this.C;
            if (canvas != null && (paint = this.H) != null) {
                canvas.drawPaint(paint);
            }
            this.G = -1L;
        }
    }

    private void h() {
        synchronized (this.f178351i) {
            this.f178351i.clear();
            this.I = -1L;
        }
    }

    private boolean i(String str, long j3) {
        Bitmap decodeFile;
        try {
            String n3 = n(str);
            if (!TextUtils.isEmpty(n3) && (decodeFile = BitmapFactory.decodeFile(n3)) != null) {
                Paint paint = new Paint();
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
                paint.setAntiAlias(true);
                synchronized (this.F) {
                    if (this.C != null) {
                        this.C.drawBitmap(decodeFile, new Rect(0, 0, decodeFile.getWidth(), decodeFile.getHeight()), new Rect(0, 0, this.f178352m.getWidth(), this.f178352m.getHeight()), paint);
                    }
                    this.G = j3;
                }
                decodeFile.recycle();
                return true;
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
        return false;
    }

    private boolean j(Canvas canvas, long j3, long j16, long j17, List<o> list) {
        boolean z16;
        long m3;
        long j18;
        if (j3 <= j16 && canvas != null) {
            int i3 = this.f178347d;
            if (i3 != 3 && i3 != 0) {
                return false;
            }
            Iterator<o> it = list.iterator();
            long j19 = 0;
            long j26 = 0;
            while (true) {
                if (it.hasNext()) {
                    o next = it.next();
                    if (l() == 1) {
                        m3 = next.l();
                    } else {
                        m3 = next.m();
                    }
                    long j27 = j19 + m3;
                    long j28 = j27 + j26;
                    if (j28 <= j3) {
                        j26 += 100;
                        j19 = j27;
                    } else {
                        if (j28 <= j16) {
                            if (this.G < j16) {
                                next.e(canvas);
                            }
                            j19 = j27;
                            z16 = true;
                        } else {
                            if (j3 > j19 + j26) {
                                j18 = (j3 - j19) - j26;
                            } else {
                                j18 = 0;
                            }
                            z16 = true;
                            next.i(canvas, j18, (j16 - j19) - j26);
                            j19 = j16 - j26;
                        }
                        j26 += 100;
                        if (j19 + j26 > j16) {
                            break;
                        }
                    }
                } else {
                    z16 = true;
                    break;
                }
            }
            if ((j19 + j26) - 100 >= j17) {
                return false;
            }
            return z16;
        }
        if (QLog.isColorLevel()) {
            QLog.e("DoodleDrawer", 2, "drawSegmentsInner:param error: " + j3 + " " + j16);
        }
        return false;
    }

    private String n(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            str2 = str.substring(0, str.lastIndexOf(95)) + "_cache";
        } catch (Exception unused) {
        }
        if (!FileUtils.fileExists(str2)) {
            return null;
        }
        return str2;
    }

    private void r(String str, long j3) {
        WeakReference<a> weakReference;
        a aVar;
        boolean z16;
        String str2 = this.L;
        if (str2 != null && str2.equalsIgnoreCase(str) && (weakReference = this.J) != null && (aVar = weakReference.get()) != null) {
            synchronized (this.F) {
                aVar.a(str, j3, this.f178352m);
            }
            synchronized (this) {
                z16 = false;
                if (this.f178347d == 3) {
                    this.f178347d = 0;
                    z16 = true;
                }
            }
            if (z16) {
                aVar.b(str, this.f178347d);
            }
        }
    }

    private void s() {
        if (this.f178347d != 3) {
            if (QLog.isColorLevel()) {
                QLog.d("DoodleDrawer", 2, "onTextureReady: state error:" + this.f178347d);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DoodleDrawer", 2, "onTextureReady: prepare:" + this.K);
        }
        if (this.K) {
            u(TTL.MAX_VALUE, false);
        } else {
            u(-1L, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str, long j3, List<o> list) {
        long j16;
        int i3 = this.f178347d;
        if ((i3 != 3 && i3 != 0) || list == null) {
            return;
        }
        if (!e()) {
            r(str, this.G);
            return;
        }
        if (j3 < this.G) {
            g();
        }
        if (j3 < 0) {
            r(str, this.G);
            return;
        }
        long p16 = p(list);
        long j17 = this.G;
        if (j17 >= p16) {
            r(str, j17);
            return;
        }
        if (j3 >= p16) {
            if (QLog.isColorLevel()) {
                QLog.d("DoodleDrawer", 2, "draw last frame try use cache");
            }
            if (i(str, p16)) {
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleDrawer", 2, "cache ok, drawfilecache finish");
                }
                r(str, this.G);
                return;
            }
        }
        long j18 = this.G;
        if (j3 > p16) {
            j16 = p16;
        } else {
            j16 = j3;
        }
        if (j18 >= j16) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.F) {
            try {
                try {
                    if (j(this.C, j18, j16, p16, list)) {
                        if (this.G < j16) {
                            this.G = j16;
                        }
                    } else {
                        this.G = p16;
                        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                        if (currentTimeMillis2 > 1000 && j16 >= p16) {
                            if (QLog.isColorLevel()) {
                                QLog.d("DoodleDrawer", 2, "creage file cache:" + currentTimeMillis2 + "-" + str);
                            }
                            x(str, this.f178352m);
                            if (QLog.isColorLevel()) {
                                QLog.d("DoodleDrawer", 2, "creage file cache end");
                            }
                        }
                    }
                    r(str, this.G);
                } catch (Throwable th5) {
                    th = th5;
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                throw th;
            }
        }
    }

    private void x(String str, Bitmap bitmap) {
        if (!TextUtils.isEmpty(str) && bitmap != null) {
            String str2 = str.substring(0, str.lastIndexOf(95)) + "_cache";
            if (FileUtils.fileExists(str2)) {
                return;
            }
            String str3 = str2 + "tmp";
            if (FileUtils.fileExists(str3)) {
                FileUtils.deleteFile(str3);
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(str3);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                FileUtils.rename(str3, str2);
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.e("DoodleDrawer", 2, "saveFileCache exception:" + e16);
                }
                FileUtils.delete(str2, true);
            }
        }
    }

    private void z() {
        b bVar = this.N;
        if (bVar != null) {
            bVar.b();
        }
        u(-1L, false);
        synchronized (this) {
            this.f178347d = -1;
            this.f178348e = false;
            LoadDataJob loadDataJob = this.P;
            if (loadDataJob != null) {
                ThreadManagerV2.removeJobFromThreadPool(loadDataJob, 16);
                this.P = null;
            }
            LoadDataJob loadDataJob2 = new LoadDataJob(this.L, this.D, this.E, this);
            this.P = loadDataJob2;
            ThreadManagerV2.excute(loadDataJob2, 16, null, true);
            QLog.d("DoodleDrawer", 2, "run task now:" + this.L);
            this.f178347d = 1;
        }
    }

    public void A() {
        Bitmap bitmap;
        synchronized (this) {
            this.f178347d = -1;
            this.f178348e = false;
            bitmap = null;
            this.J = null;
            this.M = null;
            this.L = "";
            LoadDataJob loadDataJob = this.P;
            if (loadDataJob != null) {
                ThreadManagerV2.removeJobFromThreadPool(loadDataJob, 16);
                this.P = null;
            }
        }
        this.N.d();
        synchronized (this.F) {
            this.G = -1L;
            this.C = null;
            Bitmap bitmap2 = this.f178352m;
            if (bitmap2 != null) {
                this.f178352m = null;
                bitmap = bitmap2;
            }
            this.E = 0;
            this.D = 0;
        }
        if (bitmap != null) {
            DoodleResHelper.k().o(bitmap);
        }
        h();
        QLog.d("DoodleDrawer", 2, "DoodleDrawer uninit end");
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.b
    public void a(String str, int i3, g gVar, List<o> list, Map<Integer, Integer> map) {
        a aVar;
        if (gVar != null && list != null) {
            synchronized (this) {
                b bVar = this.N;
                if (bVar != null) {
                    bVar.c();
                }
                String str2 = this.L;
                if (str2 != null && str2.equalsIgnoreCase(str)) {
                    if (i3 == 4) {
                        this.f178347d = 4;
                        this.f178348e = true;
                        WeakReference<a> weakReference = this.J;
                        if (weakReference != null && (aVar = weakReference.get()) != null) {
                            aVar.b(str, 4);
                        }
                        return;
                    }
                    this.f178347d = 2;
                    h();
                    g();
                    this.P = null;
                    if (QLog.isColorLevel()) {
                        QLog.d("DoodleDrawer", 2, "onResult:" + str + " result:" + i3 + " State:" + this.f178347d);
                    }
                    this.f178348e = false;
                    if (this.f178347d == 1) {
                        QLog.d("DoodleDrawer", 2, "onResult: reset data, state is loading now");
                        return;
                    }
                    this.f178350h.i(gVar);
                    synchronized (this.f178351i) {
                        this.f178351i.clear();
                        this.f178351i.addAll(list);
                    }
                    synchronized (this) {
                        this.Q.clear();
                        if (map != null && map.size() > 0) {
                            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                                if (entry.getValue().intValue() == 4) {
                                    this.Q.put(entry.getKey(), 1);
                                    DoodleResHelper.k().p(0, entry.getKey().intValue(), this.M, this);
                                }
                            }
                        }
                        if (this.Q.size() > 0) {
                            if (QLog.isColorLevel()) {
                                QLog.d("DoodleDrawer", 2, "onResult:" + str + " waitting res");
                            }
                            return;
                        }
                        this.f178347d = 3;
                        s();
                        if (QLog.isColorLevel()) {
                            QLog.d("DoodleDrawer", 2, "onResult end:" + str);
                        }
                        return;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d("DoodleDrawer", 2, "onResult is not current data");
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("DoodleDrawer", 2, "onResult param error");
        }
        this.f178348e = true;
        this.f178347d = 4;
    }

    @Override // com.tencent.mobileqq.scribble.b
    public void b(View view, int i3, com.tencent.mobileqq.scribble.c cVar, int i16) {
        a aVar;
        if (cVar != null && view != null) {
            WeakReference<a> weakReference = this.J;
            if (weakReference != null) {
                aVar = weakReference.get();
            } else {
                aVar = null;
            }
            if (aVar != null && this.M == view) {
                boolean z16 = true;
                if (i3 != 1 || this.f178347d != 2) {
                    return;
                }
                boolean z17 = false;
                if (1 == i16) {
                    synchronized (this) {
                        this.Q.remove(Integer.valueOf(cVar.f282547b));
                    }
                    B(cVar.f282547b);
                } else if (4 != i16) {
                    synchronized (this) {
                        if (this.Q.get(Integer.valueOf(cVar.f282547b)) != null) {
                            this.Q.remove(Integer.valueOf(cVar.f282547b));
                            this.Q.put(Integer.valueOf(cVar.f282547b), 4);
                        } else {
                            z16 = false;
                        }
                    }
                    z17 = z16;
                }
                synchronized (this) {
                    if (z17) {
                        this.f178347d = 4;
                        aVar.b(this.L, 4);
                    } else if (this.Q.size() == 0) {
                        this.f178347d = 3;
                        s();
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.LoadDataJob.b
    public boolean c(String str) {
        synchronized (this) {
            String str2 = this.L;
            if (str2 == null) {
                return false;
            }
            if (!str2.equalsIgnoreCase(str)) {
                return false;
            }
            if (this.R) {
                this.f178347d = -1;
                this.L = "";
                return false;
            }
            return true;
        }
    }

    public int k() {
        int i3;
        synchronized (this) {
            i3 = this.f178347d;
        }
        return i3;
    }

    public final int l() {
        return this.f178349f;
    }

    public int m() {
        int size;
        synchronized (this.f178351i) {
            size = this.f178351i.size();
        }
        return size;
    }

    public long o() {
        long l3;
        long j3 = 0;
        if (this.I <= 0) {
            synchronized (this.f178351i) {
                if (this.f178351i.size() == 0) {
                    this.I = 0L;
                } else {
                    for (o oVar : this.f178351i) {
                        if (l() == 1) {
                            l3 = oVar.l();
                        } else if (l() == 0) {
                            l3 = oVar.m();
                        }
                        j3 += l3;
                    }
                    this.I = j3 + ((this.f178351i.size() - 1) * 100);
                }
            }
        }
        return this.I;
    }

    public long p(List<o> list) {
        long l3;
        long j3 = 0;
        if (list == null || list.size() == 0) {
            return 0L;
        }
        for (o oVar : list) {
            if (l() == 1) {
                l3 = oVar.l();
            } else if (l() == 0) {
                l3 = oVar.m();
            }
            j3 += l3;
        }
        return j3 + ((list.size() - 1) * 100);
    }

    public void q(a aVar, int i3, int i16, int i17) {
        this.J = new WeakReference<>(aVar);
        this.f178349f = i3;
        this.D = i16;
        this.E = i17;
        e();
        this.f178347d = -1;
        this.f178348e = false;
    }

    public void t(boolean z16) {
        this.R = z16;
    }

    public boolean u(final long j3, boolean z16) {
        int i3;
        if (j3 > 0 && (i3 = this.f178347d) != 3 && i3 != 0) {
            return false;
        }
        final ArrayList arrayList = new ArrayList();
        synchronized (this.f178351i) {
            arrayList.addAll(this.f178351i);
        }
        if (!z16) {
            final String str = this.L;
            this.N.a(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.doodle.DoodleDrawer.1
                @Override // java.lang.Runnable
                public void run() {
                    DoodleDrawer.this.v(str, j3, arrayList);
                }
            });
        } else {
            v(this.L, j3, arrayList);
        }
        if (j3 >= o()) {
            return false;
        }
        return true;
    }

    public void w() {
        a aVar;
        a aVar2;
        int i3 = this.f178347d;
        if (i3 == 0) {
            WeakReference<a> weakReference = this.J;
            if (weakReference != null && (aVar2 = weakReference.get()) != null) {
                aVar2.b(this.L, 0);
                return;
            }
            return;
        }
        if (i3 != 1 && i3 != -1) {
            if (this.f178348e) {
                z();
                return;
            }
            synchronized (this) {
                this.f178347d = 2;
                if (this.Q.size() > 0) {
                    Iterator<Map.Entry<Integer, Integer>> it = this.Q.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry<Integer, Integer> next = it.next();
                        int intValue = next.getKey().intValue();
                        if (DoodleResHelper.k().l(0, intValue)) {
                            it.remove();
                            B(intValue);
                        } else {
                            next.setValue(1);
                            DoodleResHelper.k().p(0, intValue, this.M, this);
                        }
                    }
                }
                if (this.Q.size() > 0) {
                    WeakReference<a> weakReference2 = this.J;
                    if (weakReference2 != null && (aVar = weakReference2.get()) != null) {
                        aVar.b(this.L, 2);
                    }
                } else {
                    this.f178347d = 3;
                    s();
                }
            }
        }
    }

    public boolean y(String str, boolean z16, Context context) {
        if (QLog.isColorLevel()) {
            QLog.d("DoodleDrawer", 2, "setData \uff1a" + str + " state:" + this.f178347d);
        }
        long j3 = -1;
        if (TextUtils.isEmpty(str)) {
            QLog.e("DoodleDrawer", 2, "setContent filename is null");
            this.L = "";
            this.f178347d = -1;
            u(-1L, false);
            return false;
        }
        if (f(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("DoodleDrawer", 2, "checkdigest, no change:" + this.f178347d + " old prepare:" + this.K);
            }
            synchronized (this) {
                if (this.K == z16) {
                    int i3 = this.f178347d;
                    if (i3 == 0) {
                        return false;
                    }
                    if (i3 != 4) {
                        return true;
                    }
                    w();
                    return false;
                }
                this.K = z16;
                int i16 = this.f178347d;
                if (i16 != -1 && i16 != 1 && i16 != 2) {
                    if (i16 != 0 && i16 != 3) {
                        w();
                        QLog.d("DoodleDrawer", 2, "checkdigest, state error:" + this.f178347d);
                        return false;
                    }
                    this.f178347d = 3;
                    if (z16) {
                        j3 = Long.MAX_VALUE;
                    }
                    u(j3, false);
                    QLog.d("DoodleDrawer", 2, "checkdigest, preapre:" + j3);
                    return true;
                }
                QLog.d("DoodleDrawer", 2, "checkdigest, waitting event");
                return true;
            }
        }
        synchronized (this) {
            View view = new View(context);
            this.M = view;
            view.setVisibility(4);
            this.K = z16;
        }
        z();
        return true;
    }
}
