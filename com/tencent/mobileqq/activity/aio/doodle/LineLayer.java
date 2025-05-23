package com.tencent.mobileqq.activity.aio.doodle;

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
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileOutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class LineLayer extends com.tencent.mobileqq.activity.aio.doodle.a implements s, h {

    /* renamed from: x, reason: collision with root package name */
    public static final int f178436x = Color.parseColor("#ff000000");

    /* renamed from: d, reason: collision with root package name */
    private g f178437d;

    /* renamed from: e, reason: collision with root package name */
    private List<n> f178438e;

    /* renamed from: f, reason: collision with root package name */
    private n f178439f;

    /* renamed from: g, reason: collision with root package name */
    private int f178440g;

    /* renamed from: h, reason: collision with root package name */
    private long f178441h;

    /* renamed from: i, reason: collision with root package name */
    private a f178442i;

    /* renamed from: j, reason: collision with root package name */
    private Bitmap f178443j;

    /* renamed from: k, reason: collision with root package name */
    private Canvas f178444k;

    /* renamed from: l, reason: collision with root package name */
    private int f178445l;

    /* renamed from: m, reason: collision with root package name */
    private int f178446m;

    /* renamed from: n, reason: collision with root package name */
    private int f178447n;

    /* renamed from: o, reason: collision with root package name */
    private int f178448o;

    /* renamed from: p, reason: collision with root package name */
    private Paint f178449p;

    /* renamed from: q, reason: collision with root package name */
    private int f178450q;

    /* renamed from: r, reason: collision with root package name */
    private int f178451r;

    /* renamed from: s, reason: collision with root package name */
    private Map<Integer, String> f178452s;

    /* renamed from: t, reason: collision with root package name */
    private Map<Integer, Integer> f178453t;

    /* renamed from: u, reason: collision with root package name */
    private Map<Integer, Integer> f178454u;

    /* renamed from: v, reason: collision with root package name */
    private int f178455v;

    /* renamed from: w, reason: collision with root package name */
    private LoadTempFileJob f178456w;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class ClearTempFileJob implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public final String f178457d = AppConstants.SCRIBBLE_FILE_DIR + FaceUtil.IMG_TEMP + File.separator;

        public ClearTempFileJob() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                FileUtils.delete(this.f178457d, true);
            } catch (Exception e16) {
                QLog.d("ClearTempFileJobdownloading", 2, "makedir execption: " + e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes10.dex */
    public class LoadTempFileJob implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<h> f178458d;

        /* renamed from: e, reason: collision with root package name */
        private int f178459e;

        /* renamed from: f, reason: collision with root package name */
        private Map<Integer, String> f178460f = new HashMap();

        /* renamed from: h, reason: collision with root package name */
        private int f178461h;

        public LoadTempFileJob(int i3, Map<Integer, String> map, int i16, h hVar) {
            this.f178461h = -1;
            this.f178458d = new WeakReference<>(hVar);
            this.f178459e = i3;
            this.f178460f.putAll(map);
            this.f178461h = i16;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i3;
            final int i16 = 0;
            final Bitmap bitmap = null;
            try {
                String str = this.f178460f.get(Integer.valueOf(this.f178459e));
                if (TextUtils.isEmpty(str)) {
                    Iterator<Integer> it = this.f178460f.keySet().iterator();
                    i3 = 0;
                    while (it.hasNext()) {
                        int intValue = it.next().intValue();
                        if (intValue > i3 && intValue <= this.f178459e) {
                            i3 = intValue;
                        }
                    }
                    str = this.f178460f.get(Integer.valueOf(i3));
                } else {
                    i3 = this.f178459e;
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.doodle.LineLayer.LoadTempFileJob.1
                @Override // java.lang.Runnable
                public void run() {
                    h hVar;
                    if (LoadTempFileJob.this.f178458d != null && (hVar = (h) LoadTempFileJob.this.f178458d.get()) != null) {
                        hVar.b(LoadTempFileJob.this.f178459e, i16, LoadTempFileJob.this.f178461h, bitmap);
                    }
                }
            });
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class SaveTempFileJob implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        public final String f178465d = AppConstants.SCRIBBLE_FILE_DIR + FaceUtil.IMG_TEMP + File.separator;

        /* renamed from: e, reason: collision with root package name */
        private Bitmap f178466e;

        /* renamed from: f, reason: collision with root package name */
        private int f178467f;

        /* renamed from: h, reason: collision with root package name */
        private int f178468h;

        /* renamed from: i, reason: collision with root package name */
        private WeakReference<s> f178469i;

        public SaveTempFileJob(int i3, int i16, Bitmap bitmap, s sVar) {
            this.f178467f = -1;
            this.f178468h = -1;
            this.f178469i = null;
            QLog.d("SaveTempFileJob", 2, "SaveTempFileJob begin:");
            this.f178469i = new WeakReference<>(sVar);
            if (bitmap == null) {
                return;
            }
            this.f178467f = i3;
            this.f178468h = i16;
            try {
                Bitmap bitmap2 = this.f178466e;
                if (bitmap2 == null) {
                    this.f178466e = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                } else if (bitmap2.getHeight() != bitmap.getHeight() || this.f178466e.getWidth() != bitmap.getWidth()) {
                    this.f178466e.recycle();
                    this.f178466e = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                }
                Paint paint = new Paint();
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
                new Canvas(this.f178466e).drawBitmap(bitmap, 0.0f, 0.0f, paint);
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
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.doodle.LineLayer.SaveTempFileJob.1
                @Override // java.lang.Runnable
                public void run() {
                    s sVar;
                    if (SaveTempFileJob.this.f178469i != null && (sVar = (s) SaveTempFileJob.this.f178469i.get()) != null) {
                        sVar.a(!TextUtils.isEmpty(str), SaveTempFileJob.this.f178467f, SaveTempFileJob.this.f178468h, str);
                    }
                }
            });
        }

        private String e(int i3, Bitmap bitmap) {
            if (bitmap == null) {
                return null;
            }
            try {
                String str = this.f178465d + i3 + ".tmp";
                if (FileUtils.fileExists(str)) {
                    FileUtils.deleteFile(str);
                }
                FileOutputStream fileOutputStream = new FileOutputStream(str);
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                return str;
            } catch (Exception e16) {
                e16.printStackTrace();
                if (QLog.isColorLevel()) {
                    QLog.e("SaveTempFileJob", 2, "saveFileCache exception:" + e16);
                }
                return null;
            }
        }

        private void f() {
            try {
                File file = new File(this.f178465d);
                if (!file.exists()) {
                    file.mkdirs();
                }
            } catch (Exception e16) {
                QLog.d("SaveTempFileJobdownloading", 2, "makedir execption: " + e16);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (LineLayer.this.f178442i == null) {
                return;
            }
            if (this.f178466e == null) {
                d(null);
                return;
            }
            f();
            d(e(this.f178467f, this.f178466e));
            Bitmap bitmap = this.f178466e;
            if (bitmap != null) {
                bitmap.recycle();
                this.f178466e = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        void a();

        void b(int i3, int i16);
    }

    public LineLayer(DoodleView doodleView) {
        super(doodleView);
        this.f178437d = new g();
        this.f178438e = new ArrayList();
        this.f178440g = f178436x;
        this.f178441h = 0L;
        this.f178445l = 0;
        this.f178446m = 0;
        this.f178447n = 0;
        this.f178448o = 0;
        this.f178450q = -1;
        this.f178451r = 0;
        this.f178452s = new ConcurrentHashMap();
        this.f178453t = new ConcurrentHashMap();
        this.f178454u = new ConcurrentHashMap();
        this.f178455v = 0;
    }

    private void n() {
        Paint paint;
        Canvas canvas = this.f178444k;
        if (canvas != null && (paint = this.f178449p) != null) {
            canvas.drawPaint(paint);
        }
        this.f178447n = 0;
        this.f178448o = 0;
    }

    private void p(Canvas canvas, n nVar, boolean z16) {
        nVar.b(canvas, z16);
    }

    private int[] s() {
        int[] iArr = {0, 0};
        List<n> list = this.f178438e;
        if (list == null) {
            return iArr;
        }
        for (n nVar : list) {
            iArr[0] = iArr[0] + 1;
        }
        return iArr;
    }

    private void v() {
        List<n> list = this.f178438e;
        if (list != null && list.size() != 0) {
            if (!u()) {
                l();
            }
            int size = this.f178438e.size() - 1;
            int i3 = this.f178447n;
            if (size > i3) {
                while (i3 < this.f178438e.size() - 1) {
                    p(this.f178444k, this.f178438e.get(i3), false);
                    i3++;
                }
                this.f178448o = 0;
                this.f178447n = this.f178438e.size() - 1;
            } else if (i3 > this.f178438e.size() - 1) {
                this.f178447n = this.f178438e.size() - 1;
            }
            n nVar = this.f178438e.get(this.f178447n);
            int f16 = nVar.f();
            int i16 = this.f178448o;
            if (f16 > i16) {
                nVar.c(this.f178444k, i16, f16);
                this.f178448o = f16;
                if (f16 == 1) {
                    this.f178448o = 0;
                    return;
                }
                return;
            }
            return;
        }
        n();
    }

    private void z() {
        this.f178455v++;
        this.f178454u.put(Integer.valueOf(this.f178438e.size()), Integer.valueOf(this.f178455v));
        LoadTempFileJob loadTempFileJob = this.f178456w;
        if (loadTempFileJob != null) {
            ThreadManagerV2.remove(loadTempFileJob);
            this.f178456w = null;
        }
        LoadTempFileJob loadTempFileJob2 = new LoadTempFileJob(this.f178438e.size(), this.f178452s, this.f178455v, this);
        this.f178456w = loadTempFileJob2;
        ThreadManagerV2.post(loadTempFileJob2, 5, null, false);
    }

    public void A() {
        if (QLog.isColorLevel()) {
            QLog.d("LineLayer", 2, "undo begin");
        }
        List<n> list = this.f178438e;
        if (list != null && !list.isEmpty()) {
            this.f178453t.remove(Integer.valueOf(this.f178438e.size()));
            this.f178454u.remove(Integer.valueOf(this.f178438e.size()));
            this.f178452s.remove(Integer.valueOf(this.f178438e.size()));
            List<n> list2 = this.f178438e;
            list2.remove(list2.size() - 1);
            if (this.f178438e.size() == 0) {
                this.f178451r = 0;
                ThreadManagerV2.post(new ClearTempFileJob(), 5, null, true);
                this.f178453t.clear();
                this.f178454u.clear();
                this.f178452s.clear();
                n();
            } else {
                this.f178451r = t();
            }
        }
        if (this.f178451r < 100) {
            if (QLog.isColorLevel()) {
                QLog.d("LineLayer", 2, "undo draw directly");
            }
            n();
            super.f();
        } else {
            z();
            if (QLog.isColorLevel()) {
                QLog.d("LineLayer", 2, "undo try use cache");
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("LineLayer", 2, "undo end");
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.s
    public void a(boolean z16, int i3, int i16, String str) {
        Integer remove = this.f178453t.remove(Integer.valueOf(i3));
        if (remove == null) {
            if (QLog.isColorLevel()) {
                QLog.d("LineLayer", 2, "save result, seq not exist:" + i3 + "-" + i16);
                return;
            }
            return;
        }
        if (i16 != remove.intValue()) {
            this.f178453t.put(Integer.valueOf(i3), remove);
            if (QLog.isColorLevel()) {
                QLog.d("LineLayer", 2, "save result, seq not match:" + i3 + "-" + i16 + "-" + remove.intValue());
                return;
            }
            return;
        }
        if (z16 && !TextUtils.isEmpty(str)) {
            this.f178452s.put(Integer.valueOf(i3), str);
        }
        if (QLog.isColorLevel()) {
            QLog.d("LineLayer", 2, "save result, add cache:" + i3 + "-" + str + ProgressTracer.SEPARATOR + this.f178452s.size());
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.h
    public void b(int i3, int i16, int i17, Bitmap bitmap) {
        this.f178456w = null;
        Integer remove = this.f178454u.remove(Integer.valueOf(i3));
        if (remove == null) {
            if (QLog.isColorLevel()) {
                QLog.d("LineLayer", 2, "undo result, seq not exist:" + i3 + "-" + i16 + "-" + i17);
                return;
            }
            return;
        }
        if (i17 != remove.intValue()) {
            this.f178454u.put(Integer.valueOf(i3), remove);
            if (QLog.isColorLevel()) {
                QLog.d("LineLayer", 2, "undo result, seq not match:" + i3 + "-" + i16 + "-" + i17 + "-" + remove.intValue());
                return;
            }
            return;
        }
        if (i3 != this.f178438e.size()) {
            if (QLog.isColorLevel()) {
                QLog.d("LineLayer", 2, "undo result, pathsize not match:" + i3 + "-" + i16 + "-" + i17 + "-" + this.f178438e.size());
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
            this.f178444k.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            int i18 = i16 - 1;
            this.f178447n = i18;
            n nVar = this.f178438e.get(i18);
            if (nVar != null) {
                int f16 = nVar.f();
                this.f178448o = f16;
                if (f16 == 1) {
                    this.f178448o = 0;
                }
            }
            if (i16 < this.f178438e.size()) {
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

    @Override // com.tencent.mobileqq.activity.aio.doodle.a
    public boolean g() {
        Paint paint = new Paint();
        this.f178449p = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.a
    protected void h(Canvas canvas) {
        v();
        o(canvas);
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.a
    public boolean i(MotionEvent motionEvent) {
        if (this.f178451r > 10000) {
            a aVar = this.f178442i;
            if (aVar != null) {
                aVar.b(2, 10000);
                this.f178442i.a();
            }
            this.f178439f = null;
            return false;
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    long currentTimeMillis = System.currentTimeMillis() - this.f178441h;
                    n nVar = this.f178439f;
                    if (nVar != null) {
                        nVar.a(x16, y16, currentTimeMillis);
                        this.f178451r++;
                    }
                }
            } else {
                a aVar2 = this.f178442i;
                if (aVar2 != null) {
                    aVar2.a();
                }
                n nVar2 = this.f178439f;
                if (nVar2 != null) {
                    nVar2.d(false);
                    v();
                    this.f178439f.d(true);
                    int f16 = this.f178439f.f();
                    this.f178448o = f16;
                    if (f16 == 1) {
                        this.f178448o = 0;
                    }
                }
                this.f178439f = null;
                this.f178451r = t();
                Iterator<Integer> it = this.f178452s.keySet().iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    if (i3 < intValue) {
                        i3 = intValue;
                    }
                }
                Iterator<Integer> it5 = this.f178453t.keySet().iterator();
                while (it5.hasNext()) {
                    int intValue2 = it5.next().intValue();
                    if (i3 < intValue2) {
                        i3 = intValue2;
                    }
                }
                int i16 = 0;
                for (int i17 = 0; i17 < i3; i17++) {
                    i16 += this.f178438e.get(i17).e();
                }
                if (i16 + 100 < this.f178451r) {
                    v();
                    this.f178455v++;
                    this.f178453t.put(Integer.valueOf(this.f178438e.size()), Integer.valueOf(this.f178455v));
                    ThreadManagerV2.post(new SaveTempFileJob(this.f178438e.size(), this.f178455v, this.f178443j, this), 5, null, true);
                }
            }
        } else {
            n nVar3 = new n(this.f178437d, r(), null, this.f178450q);
            this.f178439f = nVar3;
            nVar3.g();
            this.f178441h = System.currentTimeMillis();
            this.f178439f.i(x16, y16);
            this.f178438e.add(this.f178439f);
            this.f178451r = t();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.a
    public void j(int i3, int i16) {
        super.j(i3, i16);
        this.f178437d.j(i3, i16);
        l();
    }

    public boolean l() {
        int width = this.f178507c.width();
        int height = this.f178507c.height();
        boolean z16 = false;
        if (width <= 0 || height <= 0) {
            return false;
        }
        try {
            if (this.f178445l != width || this.f178446m != height || this.f178443j == null || this.f178444k == null) {
                Bitmap bitmap = this.f178443j;
                if (bitmap != null) {
                    this.f178444k = null;
                    bitmap.recycle();
                    this.f178443j = null;
                }
                Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                this.f178443j = createBitmap;
                if (createBitmap != null) {
                    this.f178444k = new Canvas(this.f178443j);
                    this.f178445l = width;
                    this.f178446m = height;
                }
                this.f178447n = 0;
                this.f178448o = 0;
                z16 = true;
            }
            return z16;
        } catch (Exception e16) {
            e16.printStackTrace();
            Bitmap bitmap2 = this.f178443j;
            if (bitmap2 != null) {
                bitmap2.recycle();
                this.f178443j = null;
            }
            this.f178445l = 0;
            this.f178446m = 0;
            this.f178444k = null;
            this.f178447n = 0;
            this.f178448o = 0;
            return true;
        } catch (OutOfMemoryError e17) {
            if (QLog.isColorLevel()) {
                QLog.e("LineLayer", 2, "checkcache oom:" + e17.toString());
            }
            this.f178445l = 0;
            this.f178446m = 0;
            this.f178444k = null;
            this.f178447n = 0;
            this.f178448o = 0;
            this.f178443j = null;
            return true;
        }
    }

    public void m(boolean z16) {
        this.f178438e.clear();
        this.f178453t.clear();
        this.f178452s.clear();
        this.f178439f = null;
        this.f178451r = 0;
        ThreadManagerV2.post(new ClearTempFileJob(), 5, null, true);
        if (z16) {
            this.f178444k = null;
            Bitmap bitmap = this.f178443j;
            if (bitmap != null) {
                bitmap.recycle();
                this.f178443j = null;
            }
        }
    }

    public void o(Canvas canvas) {
        Bitmap bitmap = this.f178443j;
        if (bitmap != null && canvas != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    public int q() {
        int[] s16 = s();
        return s16[0] + s16[1];
    }

    public int r() {
        return this.f178440g;
    }

    public int t() {
        List<n> list = this.f178438e;
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
        if (this.f178443j != null && this.f178444k != null) {
            return true;
        }
        return false;
    }

    public void w(int i3) {
        this.f178440g = i3;
        this.f178450q = -1;
    }

    public void x(int i3) {
        if (this.f178450q == i3) {
            return;
        }
        this.f178440g = -1;
        this.f178450q = i3;
    }

    public void y(a aVar) {
        this.f178442i = aVar;
    }
}
