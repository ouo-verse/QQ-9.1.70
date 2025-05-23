package com.tencent.mobileqq.richmedia.particlesystem.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: classes18.dex */
public class ParticleSoftRenderer extends View implements jm2.a {
    private int C;
    private int D;

    /* renamed from: d, reason: collision with root package name */
    private final Object f281733d;

    /* renamed from: e, reason: collision with root package name */
    private List<pm2.a> f281734e;

    /* renamed from: f, reason: collision with root package name */
    private final Queue<List<pm2.a>> f281735f;

    /* renamed from: h, reason: collision with root package name */
    private final int f281736h;

    /* renamed from: i, reason: collision with root package name */
    private final SparseArray<Paint> f281737i;

    /* renamed from: m, reason: collision with root package name */
    private long f281738m;

    public ParticleSoftRenderer(Context context) {
        super(context);
        this.f281733d = new Object();
        this.f281734e = null;
        this.f281735f = new LinkedList();
        this.f281736h = 255;
        this.f281737i = new SparseArray<>(256);
        this.f281738m = 0L;
        setBackgroundColor(0);
        addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.richmedia.particlesystem.render.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                ParticleSoftRenderer.this.d(view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
    }

    private Paint b(float f16) {
        int min = Math.min(255, (int) (f16 * 255.0f));
        Paint paint = this.f281737i.get(min);
        if (paint == null) {
            Paint paint2 = new Paint();
            paint2.setColor(Color.argb(min, 255, 255, 255));
            this.f281737i.put(min, paint2);
            return paint2;
        }
        return paint;
    }

    static void e(List<pm2.a> list) {
        if (list != null) {
            Iterator<pm2.a> it = list.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    @Override // jm2.a
    public int K() {
        return this.D;
    }

    @Override // pm2.c
    public void a(List<pm2.a> list) {
        synchronized (this.f281733d) {
            this.f281738m++;
            if (list == null) {
                list = Collections.emptyList();
            }
            if (list.isEmpty()) {
                this.f281734e = null;
                this.f281735f.clear();
            }
            if (this.f281735f.size() < 4) {
                this.f281735f.offer(list);
            } else {
                e(list);
            }
            postInvalidate();
        }
    }

    List<pm2.a> c() {
        h();
        return this.f281734e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        this.C = i17 - i3;
        this.D = i18 - i16;
    }

    protected void f(Canvas canvas, pm2.a aVar) {
        Paint b16 = b(aVar.f426470a);
        Bitmap bitmap = aVar.f426471b;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, aVar.f426472c, b16);
        } else {
            canvas.setMatrix(aVar.f426472c);
            canvas.drawCircle(0.0f, 0.0f, 30.0f, b16);
        }
    }

    protected void g(Canvas canvas, List<pm2.a> list) {
        if (canvas != null && list != null) {
            Iterator<pm2.a> it = list.iterator();
            while (it.hasNext()) {
                f(canvas, it.next());
            }
        }
    }

    void h() {
        List<pm2.a> poll = this.f281735f.poll();
        if (poll == null) {
            return;
        }
        List<pm2.a> list = this.f281734e;
        if (list != null) {
            e(list);
        }
        this.f281734e = poll;
    }

    @Override // jm2.a
    public int i1() {
        return this.C;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        long j3;
        List<pm2.a> c16;
        super.onDraw(canvas);
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.f281733d) {
            j3 = this.f281738m;
            c16 = c();
        }
        g(canvas, c16);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        if (currentTimeMillis2 > 5) {
            Log.i("ParticleSoftRenderer", "onDraw, index=" + j3 + ", time=" + currentTimeMillis2);
        }
    }

    public void setRenderEventListener(b bVar) {
    }
}
