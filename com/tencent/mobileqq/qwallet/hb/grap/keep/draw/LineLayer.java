package com.tencent.mobileqq.qwallet.hb.grap.keep.draw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.activity.aio.doodle.g;
import com.tencent.mobileqq.activity.aio.doodle.n;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes16.dex */
public class LineLayer extends com.tencent.mobileqq.qwallet.hb.grap.keep.draw.a implements c, b {

    /* renamed from: x, reason: collision with root package name */
    public static final int f277434x = Color.parseColor("#ff000000");

    /* renamed from: d, reason: collision with root package name */
    private g f277435d;

    /* renamed from: e, reason: collision with root package name */
    private List<n> f277436e;

    /* renamed from: f, reason: collision with root package name */
    private n f277437f;

    /* renamed from: g, reason: collision with root package name */
    private int f277438g;

    /* renamed from: h, reason: collision with root package name */
    private long f277439h;

    /* renamed from: i, reason: collision with root package name */
    private a f277440i;

    /* renamed from: j, reason: collision with root package name */
    private Bitmap f277441j;

    /* renamed from: k, reason: collision with root package name */
    private Canvas f277442k;

    /* renamed from: l, reason: collision with root package name */
    private int f277443l;

    /* renamed from: m, reason: collision with root package name */
    private int f277444m;

    /* renamed from: n, reason: collision with root package name */
    private int f277445n;

    /* renamed from: o, reason: collision with root package name */
    private int f277446o;

    /* renamed from: p, reason: collision with root package name */
    private Paint f277447p;

    /* renamed from: q, reason: collision with root package name */
    private int f277448q;

    /* renamed from: r, reason: collision with root package name */
    private int f277449r;

    /* renamed from: s, reason: collision with root package name */
    private Map<Integer, String> f277450s;

    /* renamed from: t, reason: collision with root package name */
    private Map<Integer, Integer> f277451t;

    /* renamed from: u, reason: collision with root package name */
    private Map<Integer, Integer> f277452u;

    /* renamed from: v, reason: collision with root package name */
    private int f277453v;

    /* renamed from: w, reason: collision with root package name */
    private LoadTempFileJob f277454w;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    static class ClearTempFileJob implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public static final String f277455d = AppConstants.SCRIBBLE_FILE_DIR + FaceUtil.IMG_TEMP + File.separator;

        @Override // java.lang.Runnable
        public void run() {
            try {
                FileUtils.delete(f277455d, true);
            } catch (Exception e16) {
                QLog.d("ClearTempFileJobdownloading", 2, "makedir execption: " + e16);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    static class LoadTempFileJob implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<b> f277456d;

        /* renamed from: e, reason: collision with root package name */
        private int f277457e;

        /* renamed from: f, reason: collision with root package name */
        private Map<Integer, String> f277458f;

        /* renamed from: h, reason: collision with root package name */
        private int f277459h;

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            final int i16 = 0;
            final Bitmap bitmap = null;
            try {
                String str = this.f277458f.get(Integer.valueOf(this.f277457e));
                if (TextUtils.isEmpty(str)) {
                    Iterator<Integer> it = this.f277458f.keySet().iterator();
                    i3 = 0;
                    while (it.hasNext()) {
                        int intValue = it.next().intValue();
                        if (intValue > i3 && intValue <= this.f277457e) {
                            i3 = intValue;
                        }
                    }
                    str = this.f277458f.get(Integer.valueOf(i3));
                } else {
                    i3 = this.f277457e;
                }
                if (!TextUtils.isEmpty(str) && i3 != 0) {
                    bitmap = BitmapFactory.decodeFile(str);
                    i16 = i3;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("UndoJob", 2, "exception :" + e16);
                }
            } catch (OutOfMemoryError unused) {
                if (QLog.isColorLevel()) {
                    QLog.e("UndoJob", 2, "OOM!!");
                }
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.grap.keep.draw.LineLayer.LoadTempFileJob.1
                @Override // java.lang.Runnable
                public void run() {
                    b bVar;
                    if (LoadTempFileJob.this.f277456d != null && (bVar = (b) LoadTempFileJob.this.f277456d.get()) != null) {
                        bVar.b(LoadTempFileJob.this.f277457e, i16, LoadTempFileJob.this.f277459h, bitmap);
                    }
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class SaveTempFileJob implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final String f277462d = AppConstants.SCRIBBLE_FILE_DIR + FaceUtil.IMG_TEMP + File.separator;

        /* renamed from: e, reason: collision with root package name */
        private Bitmap f277463e;

        /* renamed from: f, reason: collision with root package name */
        private int f277464f;

        /* renamed from: h, reason: collision with root package name */
        private int f277465h;

        /* renamed from: i, reason: collision with root package name */
        private WeakReference<c> f277466i;

        public SaveTempFileJob(int i3, int i16, Bitmap bitmap, c cVar) {
            this.f277464f = -1;
            this.f277465h = -1;
            this.f277466i = null;
            QLog.d("SaveTempFileJob", 2, "SaveTempFileJob begin:");
            this.f277466i = new WeakReference<>(cVar);
            if (bitmap == null) {
                return;
            }
            this.f277464f = i3;
            this.f277465h = i16;
            try {
                Bitmap bitmap2 = this.f277463e;
                if (bitmap2 == null) {
                    this.f277463e = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                } else if (bitmap2.getHeight() != bitmap.getHeight() || this.f277463e.getWidth() != bitmap.getWidth()) {
                    this.f277463e.recycle();
                    this.f277463e = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                }
                Paint paint = new Paint();
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
                new Canvas(this.f277463e).drawBitmap(bitmap, 0.0f, 0.0f, paint);
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SaveTempFileJob", 2, "SaveTempFileJob exception:" + e16);
                }
            } catch (OutOfMemoryError e17) {
                if (QLog.isColorLevel()) {
                    QLog.d("SaveTempFileJob", 2, "SaveTempFileJob OOM:" + e17.toString());
                }
            }
            QLog.d("SaveTempFileJob", 2, "SaveTempFileJob end:");
        }

        private void d(final String str) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.qwallet.hb.grap.keep.draw.LineLayer.SaveTempFileJob.1
                @Override // java.lang.Runnable
                public void run() {
                    c cVar;
                    if (SaveTempFileJob.this.f277466i != null && (cVar = (c) SaveTempFileJob.this.f277466i.get()) != null) {
                        cVar.a(!TextUtils.isEmpty(str), SaveTempFileJob.this.f277464f, SaveTempFileJob.this.f277465h, str);
                    }
                }
            });
        }

        private String e(int i3, Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            try {
                String str = this.f277462d + i3 + ".tmp";
                if (FileUtils.fileExists(str)) {
                    FileUtils.deleteFile(str);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return str;
            } catch (Exception e16) {
                QLog.e("SaveTempFileJob", 1, "error msg in qqpay-impl module: ", e16);
                if (QLog.isColorLevel()) {
                    QLog.e("SaveTempFileJob", 2, "saveFileCache exception:" + e16);
                }
                return null;
            }
        }

        private void f() {
            try {
                File file = new File(this.f277462d);
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e16) {
                QLog.d("SaveTempFileJobdownloading", 2, "makedir execption: " + e16);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LineLayer.this.f277440i == null) {
                return;
            }
            if (this.f277463e == null) {
                d(null);
                return;
            }
            f();
            d(e(this.f277464f, this.f277463e));
            Bitmap bitmap = this.f277463e;
            if (bitmap != null) {
                bitmap.recycle();
                this.f277463e = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface a {
        void a();

        void b(int i3, int i16);

        void c();
    }

    public LineLayer(DoodleView doodleView) {
        super(doodleView);
        this.f277435d = new g();
        this.f277436e = new ArrayList();
        this.f277438g = f277434x;
        this.f277439h = 0L;
        this.f277443l = 0;
        this.f277444m = 0;
        this.f277445n = 0;
        this.f277446o = 0;
        this.f277448q = -1;
        this.f277449r = 0;
        this.f277450s = new ConcurrentHashMap();
        this.f277451t = new ConcurrentHashMap();
        this.f277452u = new ConcurrentHashMap();
        this.f277453v = 0;
    }

    private void n() {
        Paint paint;
        Canvas canvas = this.f277442k;
        if (canvas != null && (paint = this.f277447p) != null) {
            canvas.drawPaint(paint);
        }
        this.f277445n = 0;
        this.f277446o = 0;
    }

    private void p(Canvas canvas, n nVar, boolean z16) {
        nVar.b(canvas, z16);
    }

    private int[] s() {
        int[] iArr = {0, 0};
        List<n> list = this.f277436e;
        if (list == null) {
            return iArr;
        }
        for (n nVar : list) {
            iArr[0] = iArr[0] + 1;
        }
        return iArr;
    }

    private void v() {
        List<n> list = this.f277436e;
        if (list != null && list.size() != 0) {
            if (!u()) {
                l();
            }
            int size = this.f277436e.size() - 1;
            int i3 = this.f277445n;
            if (size > i3) {
                while (i3 < this.f277436e.size() - 1) {
                    p(this.f277442k, this.f277436e.get(i3), false);
                    i3++;
                }
                this.f277446o = 0;
                this.f277445n = this.f277436e.size() - 1;
            } else if (i3 > this.f277436e.size() - 1) {
                this.f277445n = this.f277436e.size() - 1;
            }
            n nVar = this.f277436e.get(this.f277445n);
            int f16 = nVar.f();
            int i16 = this.f277446o;
            if (f16 > i16) {
                nVar.c(this.f277442k, i16, f16);
                this.f277446o = f16;
                if (f16 == 1) {
                    this.f277446o = 0;
                    return;
                }
                return;
            }
            return;
        }
        n();
    }

    @Override // com.tencent.mobileqq.qwallet.hb.grap.keep.draw.c
    public void a(boolean z16, int i3, int i16, String str) {
        Integer remove = this.f277451t.remove(Integer.valueOf(i3));
        if (remove == null) {
            if (QLog.isColorLevel()) {
                QLog.d("LineLayer", 2, "save result, seq not exist:" + i3 + "-" + i16);
                return;
            }
            return;
        }
        if (i16 != remove.intValue()) {
            this.f277451t.put(Integer.valueOf(i3), remove);
            if (QLog.isColorLevel()) {
                QLog.d("LineLayer", 2, "save result, seq not match:" + i3 + "-" + i16 + "-" + remove.intValue());
                return;
            }
            return;
        }
        if (z16 && !TextUtils.isEmpty(str)) {
            this.f277450s.put(Integer.valueOf(i3), str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("LineLayer", 2, "save result, add cache:" + i3 + "-" + str + ProgressTracer.SEPARATOR + this.f277450s.size());
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.grap.keep.draw.b
    public void b(int i3, int i16, int i17, Bitmap bitmap) {
        this.f277454w = null;
        Integer remove = this.f277452u.remove(Integer.valueOf(i3));
        if (remove == null) {
            if (QLog.isColorLevel()) {
                QLog.d("LineLayer", 2, "undo result, seq not exist:" + i3 + "-" + i16 + "-" + i17);
                return;
            }
            return;
        }
        if (i17 != remove.intValue()) {
            this.f277452u.put(Integer.valueOf(i3), remove);
            if (QLog.isColorLevel()) {
                QLog.d("LineLayer", 2, "undo result, seq not match:" + i3 + "-" + i16 + "-" + i17 + "-" + remove.intValue());
                return;
            }
            return;
        }
        if (i3 != this.f277436e.size()) {
            if (QLog.isColorLevel()) {
                QLog.d("LineLayer", 2, "undo result, pathsize not match:" + i3 + "-" + i16 + "-" + i17 + "-" + this.f277436e.size());
                return;
            }
            return;
        }
        if (i16 != 0 && bitmap != null) {
            if (QLog.isColorLevel()) {
                QLog.d("LineLayer", 2, "undo result, use cache:" + i3 + "-" + i16);
            }
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
            this.f277442k.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            int i18 = i16 - 1;
            this.f277445n = i18;
            n nVar = this.f277436e.get(i18);
            if (nVar != null) {
                int f16 = nVar.f();
                this.f277446o = f16;
                if (f16 == 1) {
                    this.f277446o = 0;
                }
            }
            if (i16 < this.f277436e.size()) {
                v();
            }
            super.f();
            return;
        }
        n();
        super.f();
        if (QLog.isColorLevel()) {
            QLog.d("LineLayer", 2, "undo result, no cache:" + i3 + "-" + i16 + "-" + i17);
        }
    }

    @Override // com.tencent.mobileqq.qwallet.hb.grap.keep.draw.a
    public boolean g() {
        Paint paint = new Paint();
        this.f277447p = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        return true;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.grap.keep.draw.a
    protected void h(Canvas canvas) {
        v();
        o(canvas);
    }

    @Override // com.tencent.mobileqq.qwallet.hb.grap.keep.draw.a
    public boolean i(MotionEvent motionEvent) {
        if (this.f277449r > 10000) {
            a aVar = this.f277440i;
            if (aVar != null) {
                aVar.b(2, 10000);
                this.f277440i.a();
            }
            this.f277437f = null;
            return false;
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    long currentTimeMillis = System.currentTimeMillis() - this.f277439h;
                    n nVar = this.f277437f;
                    if (nVar != null) {
                        nVar.a(x16, y16, currentTimeMillis);
                        this.f277449r++;
                    }
                }
            } else {
                a aVar2 = this.f277440i;
                if (aVar2 != null) {
                    aVar2.a();
                }
                n nVar2 = this.f277437f;
                if (nVar2 != null) {
                    nVar2.d(false);
                    v();
                    this.f277437f.d(true);
                    int f16 = this.f277437f.f();
                    this.f277446o = f16;
                    if (f16 == 1) {
                        this.f277446o = 0;
                    }
                }
                this.f277437f = null;
                this.f277449r = t();
                Iterator<Integer> it = this.f277450s.keySet().iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    if (i3 < intValue) {
                        i3 = intValue;
                    }
                }
                Iterator<Integer> it5 = this.f277451t.keySet().iterator();
                while (it5.hasNext()) {
                    int intValue2 = it5.next().intValue();
                    if (i3 < intValue2) {
                        i3 = intValue2;
                    }
                }
                int i16 = 0;
                for (int i17 = 0; i17 < i3; i17++) {
                    i16 += this.f277436e.get(i17).e();
                }
                if (i16 + 100 < this.f277449r) {
                    v();
                    this.f277453v++;
                    this.f277451t.put(Integer.valueOf(this.f277436e.size()), Integer.valueOf(this.f277453v));
                    ThreadManagerV2.post(new SaveTempFileJob(this.f277436e.size(), this.f277453v, this.f277441j, this), 5, null, true);
                }
            }
        } else {
            a aVar3 = this.f277440i;
            if (aVar3 != null) {
                aVar3.c();
            }
            n nVar3 = new n(this.f277435d, r(), null, this.f277448q);
            this.f277437f = nVar3;
            nVar3.g();
            this.f277439h = System.currentTimeMillis();
            this.f277437f.i(x16, y16);
            this.f277436e.add(this.f277437f);
            this.f277449r = t();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qwallet.hb.grap.keep.draw.a
    public void j(int i3, int i16) {
        super.j(i3, i16);
        this.f277435d.j(i3, i16);
        l();
    }

    public boolean l() {
        int width = this.f277471c.width();
        int height = this.f277471c.height();
        boolean z16 = false;
        if (width <= 0 || height <= 0) {
            return false;
        }
        try {
            if (this.f277443l != width || this.f277444m != height || this.f277441j == null || this.f277442k == null) {
                Bitmap bitmap = this.f277441j;
                if (bitmap != null) {
                    this.f277442k = null;
                    bitmap.recycle();
                    this.f277441j = null;
                }
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.f277441j = createBitmap;
                if (createBitmap != null) {
                    this.f277442k = new Canvas(this.f277441j);
                    this.f277443l = width;
                    this.f277444m = height;
                }
                this.f277445n = 0;
                this.f277446o = 0;
                z16 = true;
            }
            return z16;
        } catch (Exception e16) {
            QLog.e("LineLayer", 1, "error msg in qqpay-impl module: ", e16);
            Bitmap bitmap2 = this.f277441j;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.f277441j = null;
            }
            this.f277443l = 0;
            this.f277444m = 0;
            this.f277442k = null;
            this.f277445n = 0;
            this.f277446o = 0;
            return true;
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e("LineLayer", 2, "checkcache oom:" + e17.toString());
            }
            this.f277443l = 0;
            this.f277444m = 0;
            this.f277442k = null;
            this.f277445n = 0;
            this.f277446o = 0;
            this.f277441j = null;
            return true;
        }
    }

    public void m(boolean z16) {
        this.f277436e.clear();
        this.f277451t.clear();
        this.f277450s.clear();
        this.f277437f = null;
        this.f277449r = 0;
        ThreadManagerV2.post(new ClearTempFileJob(), 5, null, true);
        if (z16) {
            this.f277442k = null;
            Bitmap bitmap = this.f277441j;
            if (bitmap != null) {
                bitmap.recycle();
                this.f277441j = null;
            }
        }
    }

    public void o(Canvas canvas) {
        Bitmap bitmap = this.f277441j;
        if (bitmap != null && canvas != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    public int q() {
        int[] s16 = s();
        return s16[0] + s16[1];
    }

    public int r() {
        return this.f277438g;
    }

    public int t() {
        List<n> list = this.f277436e;
        int i3 = 0;
        if (list == null) {
            return 0;
        }
        Iterator<n> it = list.iterator();
        while (it.hasNext()) {
            i3 += it.next().e();
        }
        return i3;
    }

    public boolean u() {
        if (this.f277441j != null && this.f277442k != null) {
            return true;
        }
        return false;
    }

    public void w(int i3) {
        this.f277438g = i3;
        this.f277448q = -1;
    }

    public void x(int i3) {
        if (this.f277448q == i3) {
            return;
        }
        this.f277438g = -1;
        this.f277448q = i3;
    }

    public void y(a aVar) {
        this.f277440i = aVar;
    }
}
