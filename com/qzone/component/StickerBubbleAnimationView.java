package com.qzone.component;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Point;
import android.graphics.Shader;
import android.os.SystemClock;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.qzone.component.c;
import com.qzone.component.g;
import com.qzone.util.ar;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class StickerBubbleAnimationView extends FrameLayout implements View.OnAttachStateChangeListener, g.a, ValueAnimator.AnimatorUpdateListener {
    private static final int H = ar.e(48.0f);
    private static final int I = ar.e(72.0f);
    private int C;
    private StrokeTextView D;
    private final PokeLikeWizard E;
    private ValueAnimator F;
    private StickerBubbleAnimationCallback G;

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, List<g>> f46272d;

    /* renamed from: e, reason: collision with root package name */
    private List<a> f46273e;

    /* renamed from: f, reason: collision with root package name */
    private List<Long> f46274f;

    /* renamed from: h, reason: collision with root package name */
    private String f46275h;

    /* renamed from: i, reason: collision with root package name */
    private int f46276i;

    /* renamed from: m, reason: collision with root package name */
    private int f46277m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public interface StickerBubbleAnimationCallback {
        void onAnimationEnd();

        void onSurfaceDestroyed();
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private Point f46279a;

        /* renamed from: b, reason: collision with root package name */
        private String f46280b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f46281c;

        /* renamed from: d, reason: collision with root package name */
        private c.b f46282d;

        /* renamed from: e, reason: collision with root package name */
        private c.a f46283e;

        /* renamed from: f, reason: collision with root package name */
        private int f46284f;

        public a(Point point, String str, boolean z16, c.b bVar, c.a aVar, int i3) {
            this.f46279a = point;
            this.f46280b = str;
            this.f46281c = z16;
            this.f46282d = bVar;
            this.f46283e = aVar;
            this.f46284f = i3;
        }
    }

    public StickerBubbleAnimationView(Context context) {
        super(context);
        this.f46272d = new HashMap();
        this.f46275h = null;
        this.f46276i = 0;
        this.f46277m = 0;
        this.E = PokeLikeWizard.INSTANCE;
        n();
    }

    private void e() {
        boolean z16;
        StickerBubbleAnimationCallback stickerBubbleAnimationCallback;
        if (this.f46272d.size() == 0) {
            return;
        }
        Iterator<String> it = this.f46272d.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                z16 = true;
                break;
            }
            List<g> list = this.f46272d.get(it.next());
            if (list != null && list.size() > 0) {
                z16 = false;
                break;
            }
        }
        if (!z16 || (stickerBubbleAnimationCallback = this.G) == null) {
            return;
        }
        stickerBubbleAnimationCallback.onAnimationEnd();
    }

    private void f(a aVar, long j3) {
        List<g> list = this.f46272d.get(aVar.f46280b);
        if (list == null) {
            list = new LinkedList<>();
            this.f46272d.put(aVar.f46280b, list);
        }
        list.add(i(aVar, j3, aVar.f46281c));
    }

    private void g(long j3, Canvas canvas) {
        long uptimeMillis = SystemClock.uptimeMillis();
        Iterator<String> it = this.f46272d.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            i3 += h(this.f46272d.get(it.next()), j3, canvas);
        }
        this.D.setText(HippyTKDListViewAdapter.X + Math.min(this.f46276i, 1000));
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (QLog.isColorLevel() && this.C % 60 == 0) {
            QLog.d("StickerBubbleAnimViewCost", 2, "draw " + i3 + " items, take time " + uptimeMillis2);
        }
    }

    @Override // com.qzone.component.g.a
    public void a(final g gVar) {
        post(new Runnable() { // from class: com.qzone.component.StickerBubbleAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                List list = (List) StickerBubbleAnimationView.this.f46272d.get(gVar.f46720r);
                if (list != null) {
                    list.remove(gVar);
                }
            }
        });
    }

    public void d(a aVar, boolean z16, int i3) {
        if (getVisibility() == 8) {
            setVisibility(0);
        }
        if (z16) {
            String str = this.f46275h;
            if (str == null || !str.equals(aVar.f46280b)) {
                this.f46276i = i3;
                this.f46277m = 0;
                this.f46275h = aVar.f46280b;
            }
            this.f46276i++;
            this.f46277m++;
        }
        this.f46273e.add(aVar);
    }

    public int j() {
        return this.f46277m;
    }

    public int k() {
        return this.f46276i;
    }

    public String l() {
        return this.f46275h;
    }

    public void m() {
        if (this.D.getVisibility() == 0) {
            this.D.setVisibility(8);
            this.F.cancel();
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = (((Float) valueAnimator.getAnimatedValue()).floatValue() * 0.4f) + 0.6f;
        this.D.setScaleX(floatValue);
        this.D.setScaleY(floatValue);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (getVisibility() != 0) {
            return;
        }
        this.C++;
        long uptimeMillis = SystemClock.uptimeMillis();
        Iterator<a> it = this.f46273e.iterator();
        while (it.hasNext()) {
            f(it.next(), uptimeMillis);
        }
        this.f46273e.clear();
        g(uptimeMillis, canvas);
        e();
        invalidate();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        Log.i("StickerBubbleAnimView", "onViewAttachedToWindow: ");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        q();
    }

    public void p(int i3) {
        if (this.D.getVisibility() == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.D.getLayoutParams();
        int e16 = i3 - ar.e(82.0f);
        layoutParams.topMargin = e16;
        if (e16 < 0) {
            layoutParams.topMargin = i3 + PolymorphicLikeWindow.S;
        }
        this.D.setLayoutParams(layoutParams);
        this.D.setVisibility(0);
        this.D.setScaleX(1.0f);
        this.D.setScaleY(1.0f);
        this.F.start();
    }

    public void q() {
        this.f46272d.clear();
        this.f46273e.clear();
        o();
        m();
        StickerBubbleAnimationCallback stickerBubbleAnimationCallback = this.G;
        if (stickerBubbleAnimationCallback != null) {
            stickerBubbleAnimationCallback.onSurfaceDestroyed();
        }
    }

    public void setAnimationCallback(StickerBubbleAnimationCallback stickerBubbleAnimationCallback) {
        this.G = stickerBubbleAnimationCallback;
    }

    private g i(a aVar, long j3, boolean z16) {
        int i3;
        c.b bVar = new c.b(aVar.f46282d);
        c.a aVar2 = new c.a(aVar.f46283e);
        Point point = aVar.f46279a;
        if (z16) {
            i3 = I;
        } else {
            i3 = H;
        }
        g gVar = new g(point, bVar, aVar2, j3, i3, z16, aVar.f46284f, aVar.f46280b, this.E.getPokeLikeAnimItem(aVar.f46280b));
        gVar.p(this);
        return gVar;
    }

    private void n() {
        setBackgroundColor(0);
        setFocusable(false);
        setClickable(false);
        this.f46273e = new LinkedList();
        this.f46274f = new ArrayList(70);
        StrokeTextView strokeTextView = new StrokeTextView(getContext());
        this.D = strokeTextView;
        strokeTextView.setTypeface(this.E.loadTypeFace());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, ar.e(60.0f));
        this.D.setTextSize(ar.e(23.0f));
        this.D.setGravity(17);
        addView(this.D, layoutParams);
        this.D.setVisibility(8);
        TextPaint paint = this.D.getPaint();
        paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, 0.4f * paint.getTextSize(), -3646923, -993432, Shader.TileMode.MIRROR));
        this.D.setStrokeWidth(ar.e(10.0f));
        addOnAttachStateChangeListener(this);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f, 1.0f);
        this.F = ofFloat;
        ofFloat.setDuration(200L);
        this.F.setRepeatCount(-1);
        this.F.setInterpolator(new LinearInterpolator());
        this.F.addUpdateListener(this);
    }

    public void c(a aVar, boolean z16) {
        d(aVar, z16, 0);
    }

    public void o() {
        this.f46275h = null;
        this.f46276i = 0;
        this.f46277m = 0;
    }

    private int h(List<g> list, long j3, Canvas canvas) {
        if (list == null) {
            return 0;
        }
        for (g gVar : list) {
            gVar.f46721s.c(true, j3 - gVar.j());
            gVar.f(canvas, j3, getWidth(), getHeight(), getAlpha());
        }
        return list.size();
    }

    public StickerBubbleAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f46272d = new HashMap();
        this.f46275h = null;
        this.f46276i = 0;
        this.f46277m = 0;
        this.E = PokeLikeWizard.INSTANCE;
        n();
    }

    public StickerBubbleAnimationView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f46272d = new HashMap();
        this.f46275h = null;
        this.f46276i = 0;
        this.f46277m = 0;
        this.E = PokeLikeWizard.INSTANCE;
        n();
    }
}
