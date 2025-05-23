package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.DynamicFaceLayer;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DoodleView extends View {
    protected List<tr.a> C;
    protected Map<String, tr.a> D;
    protected com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.a E;
    private tr.a F;
    private tr.a G;
    private Bitmap H;
    private Paint I;
    private Canvas J;
    public DoodleLayout K;
    public boolean L;
    private LinkedList<tr.a> M;
    private Comparator<tr.a> N;
    private long P;
    private final Matrix Q;
    private RectF R;
    private final RectF S;

    /* renamed from: d, reason: collision with root package name */
    public int f68234d;

    /* renamed from: e, reason: collision with root package name */
    public int f68235e;

    /* renamed from: f, reason: collision with root package name */
    public int f68236f;

    /* renamed from: h, reason: collision with root package name */
    public int f68237h;

    /* renamed from: i, reason: collision with root package name */
    public ur.a f68238i;

    /* renamed from: m, reason: collision with root package name */
    public EditVideoParams f68239m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements Comparator<tr.a> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(tr.a aVar, tr.a aVar2) {
            return aVar2.i() - aVar.i();
        }
    }

    public DoodleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = true;
        this.M = new LinkedList<>();
        this.N = new a();
        this.P = 0L;
        this.Q = new Matrix();
        this.R = null;
        this.S = new RectF();
        v();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A(long j3) {
        Map<String, tr.a> map = this.D;
        if (map != null && map.size() != 0) {
            Iterator<tr.a> it = this.D.values().iterator();
            while (it.hasNext()) {
                if (!it.next().m(j3)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean l() {
        int i3;
        int i16 = this.f68236f;
        boolean z16 = false;
        if (i16 <= 0 || (i3 = this.f68237h) <= 0) {
            return false;
        }
        try {
            this.H = Bitmap.createBitmap(i16, i3, Bitmap.Config.ARGB_8888);
            this.J = new Canvas(this.H);
            z16 = true;
            hd0.c.a("DoodleView", "create Doodle bitmap, width:" + this.f68236f + ",height:" + this.f68237h);
            return true;
        } catch (OutOfMemoryError e16) {
            hd0.c.h("DoodleView", "create doodle bitmap failed: %s", e16);
            return z16;
        }
    }

    private void m() {
        long uptimeMillis = SystemClock.uptimeMillis();
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c cVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c) this.D.get("LineLayer");
        if (cVar != null && cVar.L.p()) {
            d dVar = cVar.L;
            if (dVar.f68327g == null) {
                dVar.I(this.H.getWidth());
            }
        }
        this.J.drawPaint(this.I);
        Canvas canvas = new Canvas(this.H);
        EditVideoParams editVideoParams = this.f68239m;
        if (editVideoParams != null && editVideoParams.r() && cVar != null) {
            cVar.T(canvas);
        }
        LinkedList linkedList = new LinkedList(this.D.values());
        Collections.sort(linkedList, this.N);
        for (int size = linkedList.size() - 1; size >= 0; size--) {
            tr.a aVar = (tr.a) linkedList.get(size);
            if (aVar != null) {
                aVar.b(canvas);
            }
        }
        hd0.c.a("DoodleView", "drawLayerInDoodleBitmap cost time:" + (SystemClock.uptimeMillis() - uptimeMillis));
    }

    private void x() {
        this.C.add(this.E);
        this.f68238i.f439854a.a(this.C, this);
        for (tr.a aVar : this.C) {
            this.D.put(aVar.h(), aVar);
        }
        hd0.c.a("DoodleView", "DoodleView hold layers:" + this.D.toString());
        this.F = this.E;
        tr.a aVar2 = this.C.size() > 1 ? this.C.get(1) : null;
        if (aVar2 != null && (aVar2.j() != this.f68234d || aVar2.f() != this.f68235e)) {
            onSizeChanged(this.f68234d, this.f68235e, aVar2.j(), aVar2.f());
        }
        super.requestLayout();
    }

    private boolean y() {
        Bitmap bitmap = this.H;
        return (bitmap == null || bitmap.isRecycled()) ? false : true;
    }

    public boolean B() {
        return this.F == this.E;
    }

    public void C() {
        Iterator<tr.a> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().o();
        }
        E();
    }

    public void D() {
        int i3;
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c cVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c) this.D.get("LineLayer");
        if (cVar == null || !cVar.L.p() || (i3 = this.f68236f) <= 0) {
            return;
        }
        cVar.L.z(i3);
    }

    public void E() {
        hd0.c.a("DoodleView", "recycle bitmap.");
        if (y()) {
            this.H.recycle();
            this.H = null;
            this.J = null;
        }
    }

    public void F(boolean z16, float f16, float f17, float f18, PointF pointF, boolean z17, int i3) {
        DoodleLayout doodleLayout = this.K;
        if (doodleLayout == null) {
            return;
        }
        doodleLayout.u1(z16, f16, (int) f17, (int) f18, pointF, z17, i3);
    }

    public void G() {
        setActiveLayer(this.E);
        setTopLevelLayer(this.E);
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
        invalidate();
    }

    public void j(tr.a aVar) {
        if (this.F == aVar) {
            G();
        }
    }

    public void k() {
        List<tr.a> list = this.C;
        if (list != null) {
            Iterator<tr.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
            Canvas canvas = this.J;
            if (canvas != null) {
                canvas.drawPaint(this.I);
            }
        }
        super.invalidate();
    }

    public tr.a n(MotionEvent motionEvent) {
        LinkedList linkedList = new LinkedList(this.C);
        Collections.sort(linkedList, this.N);
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            tr.a aVar = (tr.a) linkedList.get(i3);
            if (aVar != null && aVar.a(motionEvent)) {
                return aVar;
            }
        }
        return this.E;
    }

    public tr.a o() {
        return this.F;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.L) {
            if (this.R != null) {
                canvas.save();
                this.Q.mapRect(this.S, this.R);
                canvas.clipRect(this.S);
            }
            EditVideoParams editVideoParams = this.f68239m;
            if (editVideoParams != null && editVideoParams.r()) {
                Iterator<Map.Entry<String, tr.a>> it = this.D.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    tr.a value = it.next().getValue();
                    if (value instanceof com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c) {
                        ((com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c) value).L.h(canvas);
                        break;
                    }
                }
            }
            this.M.clear();
            this.M.addAll(this.D.values());
            Collections.sort(this.M, this.N);
            for (int size = this.M.size() - 1; size >= 0; size--) {
                tr.a aVar = this.M.get(size);
                if (aVar != null) {
                    aVar.d(canvas);
                }
            }
            if (this.R != null) {
                canvas.restore();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i16);
        int size2 = View.MeasureSpec.getSize(i16);
        if (mode == Integer.MIN_VALUE) {
            size2 = (size * 3) / 2;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        String str;
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d dVar;
        tr.a aVar;
        tr.a aVar2 = this.F;
        if (aVar2 != null && (aVar2 instanceof com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c)) {
            return aVar2.c(motionEvent);
        }
        if (motionEvent.getActionMasked() == 0) {
            tr.a n3 = n(motionEvent);
            this.G = n3;
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.a aVar3 = this.E;
            if (n3 == aVar3 && (aVar = this.F) != aVar3 && aVar != null) {
                this.G = aVar;
            }
            tr.a aVar4 = this.G;
            if ((aVar4 instanceof com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d) && !(this.F instanceof com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d)) {
                ((com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d) aVar4).L(true);
            }
            if (!(this.G instanceof com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d) && (dVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.d) this.D.get("ShapeLayer")) != null) {
                dVar.I().i();
            }
            setTopLevelLayer(this.G);
            tr.a aVar5 = this.G;
            if (aVar5 != null) {
                str = aVar5.toString();
            } else {
                str = "null hold the TouchEvent.";
            }
            hd0.c.a("DoodleView", str);
        }
        tr.a aVar6 = this.G;
        if (aVar6 != null) {
            return aVar6.c(motionEvent);
        }
        return false;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i3) {
        super.onVisibilityChanged(view, i3);
        if (isShown()) {
            super.invalidate();
        }
    }

    public int p() {
        return this.f68237h;
    }

    public int q() {
        return this.f68236f;
    }

    public RectF r() {
        if (this.R == null) {
            return null;
        }
        return new RectF(this.R);
    }

    public Bitmap s() {
        if (!l()) {
            hd0.c.g("DoodleView", "create doodle bitmap failed.");
            return null;
        }
        m();
        return h(this.H);
    }

    public void setActiveLayer(tr.a aVar) {
        this.F = aVar;
    }

    public void setContentBounds(RectF rectF) {
        this.R = rectF;
        invalidate();
    }

    public void setDoodleConfig(ur.a aVar) {
        hd0.c.a("DoodleView", "init DoodleConfig: " + aVar.toString());
        this.f68238i = aVar;
        this.C.clear();
        this.D.clear();
        x();
    }

    public void setDoodleLayout(DoodleLayout doodleLayout) {
        this.K = doodleLayout;
    }

    public void setExtraTransform(Matrix matrix) {
        this.Q.set(matrix);
        Iterator<tr.a> it = this.C.iterator();
        while (it.hasNext()) {
            it.next().x(matrix);
        }
        invalidate();
    }

    public void setTimeStamp(final long j3) {
        this.P = j3;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (A(j3)) {
                requestLayout();
                invalidate();
                return;
            }
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DoodleView.this.A(j3)) {
                    DoodleView.this.requestLayout();
                    DoodleView.this.invalidate();
                }
            }
        });
    }

    public void setTopLevelLayer(tr.a aVar) {
        tr.a aVar2 = null;
        int i3 = 0;
        for (tr.a aVar3 : this.C) {
            if (aVar3.i() > i3 && !(aVar3 instanceof DynamicFaceLayer)) {
                i3 = aVar3.i();
                aVar2 = aVar3;
            }
        }
        if (aVar != aVar2) {
            aVar.k(i3);
            if (aVar2 != null) {
                aVar2.r();
            }
            aVar.s();
        }
    }

    public <LAYER extends tr.a> LAYER t(String str) {
        LAYER layer = (LAYER) this.D.get(str);
        if (layer != null) {
            return layer;
        }
        throw new IllegalArgumentException("this layer is not exist in DoodleView.");
    }

    public long u() {
        return this.P;
    }

    protected void v() {
        Paint paint = new Paint();
        this.I = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.C = new ArrayList();
        this.D = new LinkedHashMap();
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.a aVar = new com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.a(this);
        this.E = aVar;
        this.F = aVar;
        setLayerType(1, null);
    }

    public void w(EditVideoParams editVideoParams) {
        h hVar;
        this.f68239m = editVideoParams;
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c cVar = (com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c) this.D.get("LineLayer");
        if (cVar == null || (hVar = (h) cVar.L.l(103)) == null) {
            return;
        }
        if (editVideoParams.r()) {
            hVar.p(104);
            return;
        }
        EditVideoParams.EditSource editSource = editVideoParams.f204059i;
        if (!(editSource instanceof EditTakeVideoSource) && !(editSource instanceof EditLocalVideoSource)) {
            hVar.p(103);
        } else {
            hVar.p(105);
        }
    }

    public boolean z() {
        Iterator<tr.a> it = this.C.iterator();
        while (it.hasNext()) {
            if (!it.next().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private Bitmap h(Bitmap bitmap) {
        if (bitmap == null || this.R == null) {
            return bitmap;
        }
        RectF rectF = this.R;
        Rect rect = new Rect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
        Rect rect2 = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        if (!rect2.intersect(rect) || rect2.isEmpty()) {
            return bitmap;
        }
        try {
            return Bitmap.createBitmap(bitmap, rect2.left, rect2.top, rect2.width(), rect2.height());
        } catch (OutOfMemoryError e16) {
            hd0.c.h("DoodleView", "crop doodle bitmap fail: ", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        if (i3 <= 0 || i16 <= 0) {
            return;
        }
        if (this.f68238i != null) {
            hd0.c.a("DoodleView", "DoodleViewWidth:" + i3 + ",DoodleViewHeight:" + i16 + ",MaxWidth:" + this.f68238i.f439855b + ",MaxHeight:" + this.f68238i.f439856c);
            if (i(i3, i16, 0, 0) == (getLayerType() == 1)) {
                setLayerType(2, null);
            }
            this.f68234d = i3;
            this.f68235e = i16;
            ur.a aVar = this.f68238i;
            int i19 = aVar.f439855b;
            if (i19 == 0) {
                i19 = i3;
            }
            int i26 = aVar.f439856c;
            if (i26 == 0) {
                i26 = i16;
            }
            float c16 = zr.a.c(i3, i16, i19, i26);
            this.f68236f = (int) (this.f68234d * c16);
            this.f68237h = (int) (this.f68235e * c16);
            for (tr.a aVar2 : this.C) {
                aVar2.z(c16);
                aVar2.A(i3, i16);
            }
            return;
        }
        this.f68236f = 0;
        this.f68237h = 0;
        hd0.c.g("DoodleView", "DoodleConfig is null.");
    }

    private boolean i(int i3, int i16, int i17, int i18) {
        if (i3 == i17 && i16 == i18) {
            return false;
        }
        int scaledMaximumDrawingCacheSize = ViewConfiguration.get(getContext()).getScaledMaximumDrawingCacheSize();
        int i19 = i3 * i16 * 4;
        boolean z16 = i19 > scaledMaximumDrawingCacheSize;
        if (z16) {
            hd0.c.t("DoodleView", "drawingCache exceed!!! needSize:" + i19 + " > maxSize:" + scaledMaximumDrawingCacheSize + " bytes. w=" + i3 + ",h=" + i16);
        }
        return z16;
    }
}
