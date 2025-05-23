package com.tencent.luggage.wxa.dd;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.dd.b;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.vc.f;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d extends View implements b {

    /* renamed from: a, reason: collision with root package name */
    public final com.tencent.luggage.wxa.vc.b f124186a;

    /* renamed from: b, reason: collision with root package name */
    public final Set f124187b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap f124188c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = d.this.getParent();
            do {
                ((View) parent).forceLayout();
                parent = parent.getParent();
            } while (parent instanceof View);
            if (parent != null) {
                parent.requestLayout();
                d.this.invalidate();
            }
        }
    }

    public d(Context context) {
        super(context);
        this.f124186a = new com.tencent.luggage.wxa.vc.b(this);
        this.f124187b = new LinkedHashSet();
        b();
    }

    @Override // com.tencent.luggage.wxa.dd.b
    public boolean a(Canvas canvas) {
        return this.f124186a.a(canvas);
    }

    @Override // android.view.View
    public void addOnAttachStateChangeListener(View.OnAttachStateChangeListener onAttachStateChangeListener) {
        if (this.f124187b.contains(onAttachStateChangeListener)) {
            return;
        }
        this.f124187b.add(onAttachStateChangeListener);
        super.addOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    public final void b() {
        w.g("MicroMsg.MCanvasView", "init %s", Integer.valueOf(hashCode()));
    }

    public void c() {
        w.g("MicroMsg.MCanvasView", "onPause :%s", Integer.valueOf(hashCode()));
        this.f124186a.g();
        e();
    }

    public void d() {
        w.g("MicroMsg.MCanvasView", "onResume :%s", Integer.valueOf(hashCode()));
        this.f124186a.h();
    }

    public final void e() {
        Bitmap bitmap = this.f124188c;
        if (bitmap != null && !bitmap.isRecycled()) {
            w.d("MicroMsg.MCanvasView", "bitmap recycle %s %s", Integer.valueOf(hashCode()), this.f124188c);
            this.f124188c.recycle();
        }
    }

    public com.tencent.luggage.wxa.vc.d getDrawContext() {
        return this.f124186a.c();
    }

    public String getSessionId() {
        return this.f124186a.d();
    }

    public String getTraceId() {
        return this.f124186a.e();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            Bitmap bitmap = this.f124188c;
            if (bitmap == null || bitmap.isRecycled() || this.f124188c.getWidth() != measuredWidth || this.f124188c.getHeight() != measuredHeight) {
                e();
                try {
                    this.f124188c = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                    w.g("MicroMsg.MCanvasView", "create a new bitmap(id : %s, w : %s, h : %s)", Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
                } catch (OutOfMemoryError unused) {
                    w.b("MicroMsg.MCanvasView", "onDraw oom w:%d h:%d", Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
                    this.f124188c = null;
                }
            }
            Bitmap bitmap2 = this.f124188c;
            if (bitmap2 == null) {
                w.a("MicroMsg.MCanvasView", "bitmap is null.");
                return;
            }
            bitmap2.eraseColor(0);
            f fVar = new f(this.f124188c);
            a(fVar);
            try {
                canvas.drawBitmap(fVar.a(), 0.0f, 0.0f, (Paint) null);
            } catch (Exception e16) {
                w.a("MicroMsg.MCanvasView", e16, "", new Object[0]);
                a(canvas);
            }
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        e();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            try {
                this.f124188c = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                w.g("MicroMsg.MCanvasView", "onSizeChanged, create a new bitmap(id : %s, w : %s, h : %s)", Integer.valueOf(hashCode()), Integer.valueOf(measuredWidth), Integer.valueOf(measuredHeight));
            } catch (OutOfMemoryError unused) {
                w.b("MicroMsg.MCanvasView", "onSizeChanged oom w:%d h:%d", Integer.valueOf(i3), Integer.valueOf(i16));
                this.f124188c = null;
            }
        }
    }

    @Override // android.view.View
    public void removeOnAttachStateChangeListener(View.OnAttachStateChangeListener onAttachStateChangeListener) {
        this.f124187b.remove(onAttachStateChangeListener);
        super.removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    public void setDrawActionReportable(com.tencent.luggage.wxa.cd.a aVar) {
        this.f124186a.a(aVar);
    }

    public void setSessionId(String str) {
        this.f124186a.a(str);
    }

    public void setStartTime(long j3) {
        this.f124186a.a(j3);
    }

    public void setTraceId(String str) {
        this.f124186a.b(str);
    }

    @Override // com.tencent.luggage.wxa.dd.b
    public void a() {
        if (!ViewCompat.isLaidOut(this)) {
            post(new a());
        } else {
            postInvalidate();
        }
    }

    @Override // com.tencent.luggage.wxa.dd.b
    public void b(JSONArray jSONArray, b.a aVar) {
        this.f124186a.b(jSONArray, aVar);
    }

    @Override // com.tencent.luggage.wxa.dd.b
    public void a(JSONArray jSONArray, b.a aVar) {
        this.f124186a.a(jSONArray, aVar);
    }

    @Override // com.tencent.luggage.wxa.dd.b
    public void a(Runnable runnable) {
        post(runnable);
    }
}
