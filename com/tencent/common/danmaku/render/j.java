package com.tencent.common.danmaku.render;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.danmaku.data.ViewDanmaku;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class j extends com.tencent.common.danmaku.render.a<ViewDanmaku> {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private SparseArray<List<a>> f99769b;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        protected final View f99770a;

        /* renamed from: b, reason: collision with root package name */
        private RectF f99771b;

        /* renamed from: c, reason: collision with root package name */
        private Paint f99772c;

        public a(View view) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) view);
                return;
            }
            this.f99771b = new RectF();
            this.f99772c = new Paint();
            if (view != null) {
                this.f99770a = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private View d(View view, float f16, float f17) {
            RectF rectF = new RectF();
            Iterator<View> it = view.getTouchables().iterator();
            boolean z16 = false;
            View view2 = null;
            while (it.hasNext()) {
                View next = it.next();
                float x16 = next.getX();
                float y16 = next.getY();
                rectF.set(x16, y16, next.getMeasuredWidth() + x16, next.getMeasuredWidth() + y16);
                if (rectF.contains(f16, f17)) {
                    if (next.equals(view)) {
                        z16 = true;
                    } else if (next instanceof ViewGroup) {
                        view2 = d(view, f16 - x16, f17 - f16);
                    } else {
                        return next;
                    }
                }
            }
            if (z16 && view2 == null) {
                return view;
            }
            return view2;
        }

        public void a(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
                return;
            }
            this.f99771b.set(0.0f, 0.0f, this.f99770a.getMeasuredWidth(), this.f99770a.getMeasuredHeight());
            this.f99772c.setAlpha((int) (this.f99770a.getAlpha() * 255.0f));
            int saveLayer = canvas.saveLayer(this.f99771b, this.f99772c, 31);
            this.f99770a.draw(canvas);
            canvas.restoreToCount(saveLayer);
        }

        public int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.f99770a.getMeasuredHeight();
        }

        public int c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
            }
            return this.f99770a.getMeasuredWidth();
        }

        public View e(com.tencent.common.danmaku.tool.h hVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (View) iPatchRedirector.redirect((short) 7, (Object) this, (Object) hVar);
            }
            return d(this.f99770a, hVar.a(), hVar.b());
        }

        public void f(int i3, int i16, int i17, int i18) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            } else {
                this.f99770a.layout(i3, i16, i17, i18);
            }
        }

        public void g(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            } else {
                this.f99770a.measure(i3, i16);
            }
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f99769b = new SparseArray<>();
        }
    }

    @Override // com.tencent.common.danmaku.render.a
    public boolean a(com.tencent.common.danmaku.data.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar)).booleanValue();
        }
        return aVar instanceof ViewDanmaku;
    }

    public int h(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, obj)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.common.danmaku.render.a
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public com.tencent.common.danmaku.util.a e(ViewDanmaku viewDanmaku) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.common.danmaku.util.a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewDanmaku);
        }
        int h16 = h(viewDanmaku.l());
        List<a> list = this.f99769b.get(h16);
        if (list == null) {
            list = new ArrayList<>();
            this.f99769b.put(h16, list);
        }
        if (list.isEmpty()) {
            list.add(k(h16));
        }
        a remove = list.remove(0);
        j(h16, remove, viewDanmaku);
        remove.g(View.MeasureSpec.makeMeasureSpec(viewDanmaku.F(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(viewDanmaku.E(), Integer.MIN_VALUE));
        remove.f(0, 0, remove.c(), remove.b());
        viewDanmaku.D0(remove);
        viewDanmaku.h0(remove.c());
        viewDanmaku.g0(remove.b());
        return new com.tencent.common.danmaku.util.a(remove.c(), remove.b());
    }

    public abstract void j(int i3, a aVar, ViewDanmaku viewDanmaku);

    public abstract a k(int i3);

    @Override // com.tencent.common.danmaku.render.a
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void f(Canvas canvas, ViewDanmaku viewDanmaku, com.tencent.common.danmaku.inject.b bVar, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, canvas, viewDanmaku, bVar, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        a A0 = viewDanmaku.A0();
        if (A0 == null) {
            return;
        }
        if (!viewDanmaku.B0()) {
            A0.g(View.MeasureSpec.makeMeasureSpec(A0.c(), 1073741824), View.MeasureSpec.makeMeasureSpec(A0.b(), 1073741824));
            A0.f(0, 0, A0.c(), A0.b());
            viewDanmaku.C0(true);
        }
        canvas.save();
        canvas.translate(f16, f17);
        A0.a(canvas);
        canvas.restore();
    }

    @Override // com.tencent.common.danmaku.render.a
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void g(ViewDanmaku viewDanmaku) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) viewDanmaku);
            return;
        }
        a A0 = viewDanmaku.A0();
        if (A0 != null) {
            int h16 = h(viewDanmaku.l());
            List<a> list = this.f99769b.get(h16);
            if (list == null) {
                list = new ArrayList<>();
                this.f99769b.put(h16, list);
            }
            list.add(A0);
            viewDanmaku.D0(null);
        }
    }
}
