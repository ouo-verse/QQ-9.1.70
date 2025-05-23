package com.tencent.mobileqq.wink.editor.mosaic.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.wink.editor.mosaic.doodle.DoodleLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import w53.b;

/* compiled from: P */
/* loaded from: classes21.dex */
public class DoodleView extends View {
    protected Map<String, v63.a> C;
    protected u63.a D;
    private v63.a E;
    private v63.a F;
    private Bitmap G;
    private Paint H;
    private Canvas I;
    public DoodleLayout J;
    public boolean K;
    private LinkedList<v63.a> L;
    private Comparator<v63.a> M;
    private long N;
    private final Matrix P;

    @Nullable
    private RectF Q;
    private final RectF R;

    /* renamed from: d, reason: collision with root package name */
    public int f320643d;

    /* renamed from: e, reason: collision with root package name */
    public int f320644e;

    /* renamed from: f, reason: collision with root package name */
    public int f320645f;

    /* renamed from: h, reason: collision with root package name */
    public int f320646h;

    /* renamed from: i, reason: collision with root package name */
    public t63.a f320647i;

    /* renamed from: m, reason: collision with root package name */
    protected List<v63.a> f320648m;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    class a implements Comparator<v63.a> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(v63.a aVar, v63.a aVar2) {
            return aVar2.d() - aVar.d();
        }
    }

    public DoodleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.K = true;
        this.L = new LinkedList<>();
        this.M = new a();
        this.N = 0L;
        this.P = new Matrix();
        this.Q = null;
        this.R = new RectF();
        e();
    }

    private boolean g() {
        Bitmap bitmap = this.G;
        if (bitmap != null && !bitmap.isRecycled()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h(long j3) {
        Map<String, v63.a> map = this.C;
        if (map != null && map.size() != 0) {
            Iterator<v63.a> it = this.C.values().iterator();
            while (it.hasNext()) {
                if (!it.next().g(j3)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void b() {
        List<v63.a> list = this.f320648m;
        if (list != null) {
            Iterator<v63.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().clear();
            }
            Canvas canvas = this.I;
            if (canvas != null) {
                canvas.drawPaint(this.H);
            }
        }
        super.invalidate();
    }

    public v63.a c(MotionEvent motionEvent) {
        LinkedList linkedList = new LinkedList(this.f320648m);
        Collections.sort(linkedList, this.M);
        for (int i3 = 0; i3 < linkedList.size(); i3++) {
            v63.a aVar = (v63.a) linkedList.get(i3);
            if (aVar != null && aVar.a(motionEvent)) {
                return aVar;
            }
        }
        return this.D;
    }

    public v63.a d() {
        return this.E;
    }

    protected void e() {
        Paint paint = new Paint();
        this.H = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f320648m = new ArrayList();
        this.C = new LinkedHashMap();
        u63.a aVar = new u63.a(this);
        this.D = aVar;
        this.E = aVar;
        setLayerType(1, null);
    }

    void f() {
        this.f320648m.add(this.D);
        this.f320647i.getClass();
        throw null;
    }

    public void i() {
        Iterator<v63.a> it = this.f320648m.iterator();
        while (it.hasNext()) {
            it.next().i();
        }
        j();
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NonNull Drawable drawable) {
        super.invalidateDrawable(drawable);
        invalidate();
    }

    public void j() {
        b.a("DoodleView_Mosaic", "recycle bitmap.");
        if (g()) {
            this.G.recycle();
            this.G = null;
            this.I = null;
        }
    }

    public void k() {
        setActiveLayer(this.D);
        setTopLevelLayer(this.D);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (!this.K) {
            return;
        }
        if (this.Q != null) {
            canvas.save();
            this.P.mapRect(this.R, this.Q);
            canvas.clipRect(this.R);
        }
        Iterator<Map.Entry<String, v63.a>> it = this.C.entrySet().iterator();
        while (it.hasNext()) {
            v63.a value = it.next().getValue();
            if (value instanceof u63.b) {
                ((u63.b) value).getClass();
                throw null;
            }
        }
        this.L.clear();
        this.L.addAll(this.C.values());
        Collections.sort(this.L, this.M);
        for (int size = this.L.size() - 1; size >= 0; size--) {
            v63.a aVar = this.L.get(size);
            if (aVar != null) {
                aVar.c(canvas);
            }
        }
        if (this.Q != null) {
            canvas.restore();
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
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        if (i3 > 0 && i16 > 0) {
            b.a("DoodleView_Mosaic", "onSizeChanged... DoodleViewWidth:" + i3 + ",DoodleViewHeight:" + i16);
            this.f320643d = i3;
            this.f320644e = i16;
            if (this.f320647i != null) {
                float a16 = x63.a.a(i3, i16, i3, i16);
                this.f320645f = (int) (this.f320643d * a16);
                this.f320646h = (int) (this.f320644e * a16);
                b.a("DoodleView_Mosaic", "onSizeChanged... DoodleViewWidth:" + i3 + ",DoodleViewHeight:" + i16 + ",MaxWidth:" + this.f320647i.f435494a + ",MaxHeight:" + this.f320647i.f435495b + ",scaleValue:" + a16);
                for (v63.a aVar : this.f320648m) {
                    aVar.o(a16);
                    aVar.p(i3, i16);
                }
                return;
            }
            this.f320645f = 0;
            this.f320646h = 0;
            b.c("DoodleView_Mosaic", "DoodleConfig is null.");
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        String str;
        v63.a aVar;
        v63.a aVar2 = this.E;
        if (aVar2 != null && (aVar2 instanceof u63.b)) {
            return aVar2.b(motionEvent);
        }
        if (motionEvent.getActionMasked() == 0) {
            v63.a c16 = c(motionEvent);
            this.F = c16;
            u63.a aVar3 = this.D;
            if (c16 == aVar3 && (aVar = this.E) != aVar3 && aVar != null) {
                this.F = aVar;
            }
            setTopLevelLayer(this.F);
            v63.a aVar4 = this.F;
            if (aVar4 != null) {
                str = aVar4.toString();
            } else {
                str = "null hold the TouchEvent.";
            }
            b.a("DoodleView_Mosaic", str);
        }
        v63.a aVar5 = this.F;
        if (aVar5 != null) {
            return aVar5.b(motionEvent);
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

    public void setActiveLayer(v63.a aVar) {
        this.E = aVar;
    }

    public void setContentBounds(@Nullable RectF rectF) {
        this.Q = rectF;
        invalidate();
    }

    public void setDoodleConfig(t63.a aVar) {
        b.a("DoodleView_Mosaic", "init DoodleConfig: " + aVar.toString());
        this.f320647i = aVar;
        this.f320648m.clear();
        this.C.clear();
        f();
    }

    public void setDoodleLayout(DoodleLayout doodleLayout) {
        this.J = doodleLayout;
    }

    public void setExtraTransform(@NonNull Matrix matrix) {
        this.P.set(matrix);
        Iterator<v63.a> it = this.f320648m.iterator();
        while (it.hasNext()) {
            it.next().n(matrix);
        }
        invalidate();
    }

    public void setMosaicPicMode() {
        if (((u63.b) this.C.get("LineLayer_mosaic")) == null) {
        } else {
            throw null;
        }
    }

    public void setTimeStamp(final long j3) {
        this.N = j3;
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (h(j3)) {
                requestLayout();
                invalidate();
                return;
            }
            return;
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.mosaic.ui.DoodleView.2
            @Override // java.lang.Runnable
            public void run() {
                if (DoodleView.this.h(j3)) {
                    DoodleView.this.requestLayout();
                    DoodleView.this.invalidate();
                }
            }
        });
    }

    public void setTopLevelLayer(v63.a aVar) {
        v63.a aVar2 = null;
        int i3 = 0;
        for (v63.a aVar3 : this.f320648m) {
            if (aVar3.d() > i3) {
                i3 = aVar3.d();
                aVar2 = aVar3;
            }
        }
        if (aVar != aVar2) {
            aVar.e(i3);
            if (aVar2 != null) {
                aVar2.l();
            }
            aVar.m();
        }
    }
}
