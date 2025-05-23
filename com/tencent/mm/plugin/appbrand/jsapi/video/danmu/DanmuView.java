package com.tencent.mm.plugin.appbrand.jsapi.video.danmu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.luggage.wxa.jq.g;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.zp.h;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class DanmuView extends View {
    public volatile int C;
    public volatile boolean D;
    public LinkedList E;
    public Paint F;
    public long G;
    public LinkedList H;

    /* renamed from: a, reason: collision with root package name */
    public final Context f152166a;

    /* renamed from: b, reason: collision with root package name */
    public int f152167b;

    /* renamed from: c, reason: collision with root package name */
    public int f152168c;

    /* renamed from: d, reason: collision with root package name */
    public int f152169d;

    /* renamed from: e, reason: collision with root package name */
    public float f152170e;

    /* renamed from: f, reason: collision with root package name */
    public float f152171f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f152172g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f152173h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.ug.c f152174i;

    /* renamed from: j, reason: collision with root package name */
    public HashMap f152175j;

    /* renamed from: k, reason: collision with root package name */
    public final Deque f152176k;

    /* renamed from: l, reason: collision with root package name */
    public List f152177l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f152178m;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DanmuView.this.D = true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DanmuView.this.D = false;
            DanmuView.this.invalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.tencent.luggage.wxa.ug.d f152181a;

        public c(com.tencent.luggage.wxa.ug.d dVar) {
            this.f152181a = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (DanmuView.this.f152177l) {
                int i3 = 0;
                while (true) {
                    if (i3 >= DanmuView.this.f152177l.size()) {
                        break;
                    }
                    if (this.f152181a.b() <= ((com.tencent.luggage.wxa.ug.d) DanmuView.this.f152177l.get(i3)).b()) {
                        DanmuView.this.f152177l.add(i3, this.f152181a);
                        break;
                    }
                    i3++;
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f152183a;

        public d(List list) {
            this.f152183a = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (DanmuView.this.f152176k) {
                DanmuView.this.f152176k.addAll(this.f152183a);
            }
            synchronized (DanmuView.this.f152177l) {
                DanmuView.this.f152177l.addAll(this.f152183a);
            }
            DanmuView.this.postInvalidate();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class e implements g {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f152185a;

        public e(int i3) {
            this.f152185a = i3;
        }

        @Override // com.tencent.luggage.wxa.jq.g, com.tencent.luggage.wxa.jq.f
        public String getKey() {
            return "DanmuView-seekToPlayTime";
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (DanmuView.this.f152176k) {
                for (int size = DanmuView.this.f152177l.size() - 1; size >= 0; size--) {
                    com.tencent.luggage.wxa.ug.d dVar = (com.tencent.luggage.wxa.ug.d) DanmuView.this.f152177l.get(size);
                    if (dVar.b() < this.f152185a) {
                        break;
                    }
                    w.g("MicroMsg.DanmuView", "seekToPlayTime addBack i=%d showTime=%d", Integer.valueOf(size), Integer.valueOf(dVar.b()));
                    DanmuView.this.f152176k.addFirst(dVar);
                }
            }
            DanmuView.this.o();
        }
    }

    public DanmuView(Context context) {
        this(context, null);
    }

    public final void d() {
        HashMap hashMap = this.f152175j;
        if (hashMap != null) {
            synchronized (hashMap) {
                for (int i3 = 0; i3 < this.f152175j.size(); i3++) {
                    ArrayList arrayList = (ArrayList) this.f152175j.get(Integer.valueOf(i3));
                    if (arrayList != null) {
                        arrayList.clear();
                    }
                }
            }
        }
    }

    public final void e() {
        HashMap hashMap = this.f152175j;
        if (hashMap != null && !hashMap.isEmpty()) {
            this.f152175j.clear();
        }
    }

    public final void f() {
        synchronized (this.f152176k) {
            if (!this.f152176k.isEmpty()) {
                this.f152176k.clear();
            }
        }
    }

    public final void g() {
        if (l()) {
            this.D = true;
        } else {
            post(new a());
        }
    }

    public float getYOffset() {
        return this.f152171f - this.f152170e;
    }

    public final double h() {
        this.E.addLast(Long.valueOf(System.nanoTime()));
        double longValue = (r0 - ((Long) this.E.getFirst()).longValue()) / 1.0E9d;
        if (this.E.size() > 100) {
            this.E.removeFirst();
        }
        if (longValue <= 0.0d) {
            return 0.0d;
        }
        return this.E.size() / longValue;
    }

    public void i() {
        this.C = 4;
        invalidate();
    }

    public final void j() {
        this.f152175j = new HashMap(this.f152167b);
        for (int i3 = 0; i3 < this.f152167b; i3++) {
            this.f152175j.put(Integer.valueOf(i3), new ArrayList(this.f152169d));
        }
    }

    public final void k() {
        this.f152178m = new int[this.f152167b];
        float a16 = com.tencent.luggage.wxa.ug.b.a(this.f152166a);
        float height = getHeight() * this.f152170e;
        int i3 = 0;
        int i16 = 0;
        while (i16 < this.f152167b) {
            int i17 = i16 + 1;
            this.f152178m[i16] = (int) (((i17 * a16) + height) - ((3.0f * a16) / 4.0f));
            i16 = i17;
        }
        if (this.f152173h) {
            this.H.clear();
            this.H.add(Float.valueOf(height));
            while (i3 < this.f152167b) {
                i3++;
                this.H.add(Float.valueOf((i3 * a16) + height));
            }
        }
    }

    public final boolean l() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    public void m() {
        this.C = 2;
        invalidate();
    }

    public void n() {
        a(this.f152170e, this.f152171f);
        setBackgroundColor(0);
        setDrawingCacheBackgroundColor(0);
        a();
    }

    public final void o() {
        if (l()) {
            this.D = false;
            invalidate();
        } else {
            post(new b());
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        LinkedList linkedList;
        int b16;
        LinkedList linkedList2;
        super.onDraw(canvas);
        if (this.D) {
            w.d("MicroMsg.DanmuView", "inTransition");
            return;
        }
        if (this.C == 1) {
            try {
                canvas.drawColor(0);
                for (int i3 = 0; i3 < this.f152175j.size(); i3++) {
                    Iterator it = ((ArrayList) this.f152175j.get(Integer.valueOf(i3))).iterator();
                    while (it.hasNext()) {
                        com.tencent.luggage.wxa.ug.d dVar = (com.tencent.luggage.wxa.ug.d) it.next();
                        if (dVar.c()) {
                            it.remove();
                        } else {
                            dVar.a(canvas, false);
                        }
                    }
                }
                if (System.currentTimeMillis() - this.G > this.f152168c) {
                    this.G = System.currentTimeMillis();
                    synchronized (this.f152176k) {
                        if (this.f152176k.size() > 0) {
                            com.tencent.luggage.wxa.ug.d dVar2 = (com.tencent.luggage.wxa.ug.d) this.f152176k.getFirst();
                            int a16 = this.f152174i.a();
                            while (dVar2 != null && dVar2.b(a16)) {
                                this.f152176k.pollFirst();
                                dVar2 = (com.tencent.luggage.wxa.ug.d) this.f152176k.getFirst();
                            }
                            if (dVar2 != null && dVar2.a(a16) && (b16 = b(dVar2)) >= 0) {
                                dVar2.a(canvas.getWidth() - 2, this.f152178m[b16]);
                                dVar2.a(canvas, false);
                                ((ArrayList) this.f152175j.get(Integer.valueOf(b16))).add(dVar2);
                                this.f152176k.pollFirst();
                            }
                        }
                    }
                }
                if (this.f152172g && this.E != null) {
                    canvas.drawText("FPS:" + ((int) h()), 5.0f, 20.0f, this.F);
                }
                if (this.f152173h && (linkedList = this.H) != null) {
                    Iterator it5 = linkedList.iterator();
                    while (it5.hasNext()) {
                        float floatValue = ((Float) it5.next()).floatValue();
                        canvas.drawLine(0.0f, floatValue, getWidth(), floatValue, this.F);
                    }
                }
            } catch (Exception e16) {
                w.h("MicroMsg.DanmuView", "STATUS_RUNNING onDraw e=%s", e16);
            }
            invalidate();
            return;
        }
        if (this.C == 2) {
            try {
                canvas.drawColor(0);
                for (int i16 = 0; i16 < this.f152175j.size(); i16++) {
                    Iterator it6 = ((ArrayList) this.f152175j.get(Integer.valueOf(i16))).iterator();
                    while (it6.hasNext()) {
                        ((com.tencent.luggage.wxa.ug.d) it6.next()).a(canvas, true);
                    }
                }
                if (this.f152172g && this.E != null) {
                    canvas.drawText("FPS:" + ((int) h()), 5.0f, 20.0f, this.F);
                }
                if (this.f152173h && (linkedList2 = this.H) != null) {
                    Iterator it7 = linkedList2.iterator();
                    while (it7.hasNext()) {
                        float floatValue2 = ((Float) it7.next()).floatValue();
                        canvas.drawLine(0.0f, floatValue2, getWidth(), floatValue2, this.F);
                    }
                }
            } catch (Exception e17) {
                w.h("MicroMsg.DanmuView", "STATUS_PAUSE onDraw e=%s", e17);
            }
            invalidate();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        k();
    }

    public void p() {
        this.C = 1;
        invalidate();
    }

    public void setDanmuViewCallBack(com.tencent.luggage.wxa.ug.c cVar) {
        this.f152174i = cVar;
    }

    public void setMaxRow(int i3) {
        this.f152167b = i3;
        d();
        a();
    }

    public void setMaxRunningPerRow(int i3) {
        this.f152169d = i3;
    }

    public void setPickItemInterval(int i3) {
        this.f152168c = i3;
    }

    public void setShowFps(boolean z16) {
        this.f152172g = z16;
        if (z16) {
            if (this.F == null || this.E == null) {
                TextPaint textPaint = new TextPaint(1);
                this.F = textPaint;
                textPaint.setColor(-256);
                this.F.setTextSize(20.0f);
                this.E = new LinkedList();
            }
        }
    }

    public void setShowLines(boolean z16) {
        this.f152173h = z16;
        if (z16 && this.H == null) {
            this.H = new LinkedList();
        }
    }

    public DanmuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final int b(com.tencent.luggage.wxa.ug.d dVar) {
        int i3 = 0;
        while (true) {
            try {
                int i16 = this.f152167b;
                if (i3 >= i16) {
                    return -1;
                }
                int i17 = (i3 + 0) % i16;
                ArrayList arrayList = (ArrayList) this.f152175j.get(Integer.valueOf(i17));
                if (arrayList.size() == 0) {
                    return i17;
                }
                if (arrayList.size() <= this.f152169d && !dVar.a((com.tencent.luggage.wxa.ug.d) arrayList.get(arrayList.size() - 1))) {
                    return i17;
                }
                i3++;
            } catch (Exception e16) {
                w.f("MicroMsg.DanmuView", "findVacant,Exception:" + e16.getMessage());
                return -1;
            }
        }
    }

    public final void c() {
        e();
        f();
    }

    public DanmuView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f152167b = 5;
        this.f152168c = 500;
        this.f152169d = 10;
        this.f152170e = 0.0f;
        this.f152171f = 0.6f;
        this.f152172g = false;
        this.f152173h = false;
        this.f152176k = new LinkedList();
        this.f152177l = new LinkedList();
        this.C = 3;
        this.G = 0L;
        this.f152166a = context;
    }

    public final void a(float f16, float f17) {
        if (f16 >= f17) {
            throw new IllegalArgumentException("start_Y_offset must < end_Y_offset");
        }
        if (f16 < 0.0f || f16 >= 1.0f || f17 < 0.0f || f17 > 1.0f) {
            throw new IllegalArgumentException("start_Y_offset and end_Y_offset must between 0 and 1)");
        }
    }

    public final void a() {
        j();
        k();
    }

    public void a(com.tencent.luggage.wxa.ug.d dVar) {
        synchronized (this.f152176k) {
            this.f152176k.offerFirst(dVar);
            h.f146825d.b(new c(dVar), "DanmuView-addItemToWaitingHead");
        }
    }

    public void b() {
        this.C = 3;
        c();
        this.f152177l.clear();
        invalidate();
    }

    public void a(List list, boolean z16) {
        if (z16) {
            h.f146825d.b(new d(list));
            return;
        }
        synchronized (this.f152176k) {
            this.f152176k.addAll(list);
        }
        synchronized (this.f152177l) {
            this.f152177l.addAll(list);
        }
    }

    public void b(float f16, float f17) {
        this.f152170e = f16;
        this.f152171f = f17;
    }

    public void b(List list, boolean z16) {
        g();
        c();
        this.f152177l.clear();
        n();
        if (list != null && !list.isEmpty()) {
            a(list, z16);
            o();
        } else {
            o();
        }
    }

    public void a(int i3) {
        w.d("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", Integer.valueOf(i3));
        g();
        c();
        n();
        h.f146825d.execute(new e(i3));
    }
}
