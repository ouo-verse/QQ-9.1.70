package com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public class c extends ReplacementSpan {
    private int C;
    private d F;
    private e G;
    private InterfaceC7762c H;
    private b I;

    /* renamed from: d, reason: collision with root package name */
    private final g f221494d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f221495e;

    /* renamed from: f, reason: collision with root package name */
    private View f221496f;

    /* renamed from: h, reason: collision with root package name */
    private Rect f221497h;
    h J = new a();

    /* renamed from: i, reason: collision with root package name */
    private boolean f221498i = true;

    /* renamed from: m, reason: collision with root package name */
    private int f221499m = 0;
    private boolean E = false;
    private boolean D = false;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements h {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.h
        public void a() {
            c.this.f221498i = true;
            c.this.G.a(c.this);
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    interface b {
        boolean a(c cVar, CharSequence charSequence);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.c$c, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public interface InterfaceC7762c {
        void a(c cVar);
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface d {
        void a(c cVar);
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    interface e {
        void a(c cVar);
    }

    public c(g gVar) {
        this.f221494d = gVar;
    }

    public static boolean e(FrameLayout.LayoutParams layoutParams, FrameLayout.LayoutParams layoutParams2) {
        if (layoutParams == null && layoutParams2 == null) {
            return false;
        }
        if (layoutParams != null && layoutParams2 != null && layoutParams.height == layoutParams2.height && layoutParams.width == layoutParams2.width && layoutParams.leftMargin == layoutParams2.leftMargin && layoutParams.topMargin == layoutParams2.topMargin) {
            return false;
        }
        return true;
    }

    public static FrameLayout.LayoutParams f(Point point, int i3, int i16) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i16);
        layoutParams.leftMargin = point.x;
        layoutParams.topMargin = point.y;
        return layoutParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k() {
        InterfaceC7762c interfaceC7762c = this.H;
        if (interfaceC7762c != null) {
            interfaceC7762c.a(this);
        }
    }

    public boolean d(String str) {
        View view;
        View view2 = this.f221496f;
        if (view2 == null || this.f221495e == null || this.f221497h == null) {
            return false;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view2.getLayoutParams();
        Rect rect = this.f221495e;
        FrameLayout.LayoutParams f16 = f(new Point(rect.left, rect.top), this.f221497h.width(), this.f221497h.height());
        if (e(layoutParams, f16)) {
            if (QLog.isDevelopLevel()) {
                QLog.d("RichTextSpan", 4, "[adjustViewPosition] this: " + hashCode() + ", mDrawRect" + this.f221495e.toString() + ", mRect: " + this.f221497h.toString() + ", fromSource: " + str);
            }
            View view3 = this.f221496f;
            Rect rect2 = this.f221495e;
            view3.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
            this.f221496f.setLayoutParams(f16);
            this.f221496f.requestLayout();
            if (!this.D && this.H != null && (view = this.f221496f) != null) {
                this.D = true;
                view.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.richtext.longfeed.richtextspan.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        c.this.k();
                    }
                });
            }
        }
        this.f221498i = false;
        return true;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, @NonNull Paint paint) {
        d dVar;
        if (this.f221497h == null || this.f221498i) {
            this.f221497h = new Rect(0, 0, this.f221494d.getWidth(), this.f221494d.getHeight());
        }
        Rect rect = this.f221497h;
        int i26 = rect.bottom;
        int i27 = i19 - i26;
        int i28 = this.f221499m;
        if (i28 == 1) {
            i17 = i27 - paint.getFontMetricsInt().descent;
        } else if (i28 == 2) {
            i17 = (i17 + ((i19 - i17) / 2)) - (i26 / 2);
        } else if (i28 != 3) {
            i17 = i27;
        }
        if (this.f221495e == null) {
            this.f221495e = new Rect();
        }
        Rect rect2 = new Rect(this.f221495e);
        Rect rect3 = this.f221495e;
        int i29 = (int) f16;
        rect3.left = i29;
        rect3.top = i17;
        rect3.right = i29 + rect.width();
        this.f221495e.bottom = i17 + rect.height();
        if (QLog.isDevelopLevel()) {
            QLog.d("RichTextSpan", 4, "[draw] this: " + hashCode() + ", mDrawRect" + this.f221495e.toString() + ", mRect: " + this.f221497h.toString());
        }
        if (!this.E && (dVar = this.F) != null) {
            this.E = true;
            dVar.a(this);
        }
        b bVar = this.I;
        if (bVar == null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("RichTextSpan", 4, "[draw] this: " + hashCode() + ", mOnAdjustViewPositionListener is null!");
            }
            d("draw");
            return;
        }
        if (bVar.a(this, charSequence)) {
            d("draw");
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("RichTextSpan", 4, "[draw] this: " + hashCode() + ", setToOriginDrawRect: " + rect2);
        }
        this.f221495e = rect2;
    }

    public Rect g() {
        return this.f221495e;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence charSequence, int i3, int i16, @Nullable Paint.FontMetricsInt fontMetricsInt) {
        if (this.f221497h == null || this.f221498i) {
            this.f221497h = new Rect(0, 0, this.f221494d.getWidth(), this.f221494d.getHeight());
        }
        if (fontMetricsInt != null) {
            int i17 = -this.f221497h.bottom;
            fontMetricsInt.ascent = i17;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i17;
            fontMetricsInt.bottom = 0;
        }
        return this.f221497h.right;
    }

    public View h() {
        return this.f221496f;
    }

    public g i() {
        return this.f221494d;
    }

    public int j() {
        return this.C;
    }

    public View l() {
        this.f221496f = this.f221494d.c(this.J);
        d(HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW);
        return this.f221496f;
    }

    public void m() {
        this.f221494d.onDestroyView();
    }

    public void n() {
        this.f221494d.h(this.f221496f);
    }

    public void o() {
        this.f221494d.g(this.f221496f);
    }

    public void p(b bVar) {
        this.I = bVar;
    }

    public void q(InterfaceC7762c interfaceC7762c) {
        this.H = interfaceC7762c;
    }

    public void r(d dVar) {
        this.F = dVar;
    }

    public void s(e eVar) {
        this.G = eVar;
    }

    public void t(int i3) {
        this.f221499m = i3;
    }

    public void u(int i3) {
        this.C = i3;
    }
}
