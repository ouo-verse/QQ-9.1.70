package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.QAdUIKit;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Range;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import com.tencent.mobileqq.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class SpanSequenceTextView extends AppCompatTextView {
    private SpannableStringBuilder C;
    private Spannable D;
    private b E;
    private float F;
    private float G;
    private float H;
    private long I;
    private Runnable J;

    /* renamed from: h, reason: collision with root package name */
    private HashMap<Range<Integer>, ImageSpan> f303727h;

    /* renamed from: i, reason: collision with root package name */
    private HashMap<Range<Integer>, ClickableSpan> f303728i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f303729m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends View {
        public a(Context context) {
            super(context);
        }

        @Override // android.view.View
        protected void onMeasure(int i3, int i16) {
            setMeasuredDimension(0, 0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
        void a(View view);

        void b(View view);
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static abstract class e {

        /* renamed from: a, reason: collision with root package name */
        protected int f303739a;

        /* renamed from: b, reason: collision with root package name */
        protected c f303740b;

        /* renamed from: c, reason: collision with root package name */
        protected int f303741c;

        public e(int i3) {
            this.f303739a = i3;
        }

        public void a(@IdRes int i3, c cVar) {
            this.f303741c = i3;
            this.f303740b = cVar;
        }

        public void b(c cVar) {
            a(R.id.f29790ml, cVar);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class f extends e {

        /* renamed from: d, reason: collision with root package name */
        protected String f303742d;

        /* renamed from: e, reason: collision with root package name */
        protected int f303743e;

        public f(int i3, String str, int i16) {
            super(i3);
            this.f303742d = str;
            this.f303743e = i16;
        }
    }

    public SpanSequenceTextView(Context context) {
        super(context);
        this.f303727h = new HashMap<>();
        this.f303728i = new HashMap<>();
        this.f303729m = false;
        this.J = new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.QAdUIKit.SpanSequenceTextView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SpanSequenceTextView.this.E != null) {
                    Selection.removeSelection(SpanSequenceTextView.this.D);
                    SpanSequenceTextView.this.E = null;
                }
            }
        };
        k(context);
    }

    private void e(d dVar) {
        if (dVar.f303735d == null) {
            return;
        }
        Range<Integer> range = new Range<>(Integer.valueOf(this.C.length()), Integer.valueOf(this.C.length() + 3));
        this.C.append((CharSequence) "img");
        setImageColor(dVar.f303735d, Integer.valueOf(dVar.f303738g));
        if (dVar.f303735d != null) {
            i(dVar, range);
        }
        p(dVar, range);
    }

    private void f(e eVar) {
        if (eVar instanceof f) {
            e(new d(0, eVar.f303739a, new PaintDrawable(pw2.e.a(R.color.ajr))));
        }
    }

    private void g(f fVar) {
        if (fVar.f303742d == null) {
            return;
        }
        SpannableString spannableString = new SpannableString(fVar.f303742d);
        spannableString.setSpan(new ForegroundColorSpan(fVar.f303743e), 0, spannableString.length(), 17);
        o(spannableString, fVar);
        this.C.append((CharSequence) spannableString);
    }

    private boolean h(float f16, float f17, MotionEvent motionEvent) {
        if (Math.abs(f16 - motionEvent.getX()) < this.H && Math.abs(f17 - motionEvent.getY()) < this.H) {
            return true;
        }
        return false;
    }

    private void i(d dVar, Range<Integer> range) {
        Drawable drawable = dVar.f303735d;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(0, 0, dVar.f303736e, dVar.f303737f);
        this.f303727h.put(range, new cv2.a(drawable, dVar.f303739a, 0));
    }

    private b j(MotionEvent motionEvent) {
        ClickableSpan clickableSpan;
        try {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            int totalPaddingLeft = x16 - getTotalPaddingLeft();
            int totalPaddingTop = y16 - getTotalPaddingTop();
            int scrollX = totalPaddingLeft + getScrollX();
            int scrollY = totalPaddingTop + getScrollY();
            Layout layout = getLayout();
            int lineForVertical = layout.getLineForVertical(scrollY);
            if (scrollY <= layout.getLineBottom(lineForVertical) && scrollY >= layout.getLineTop(lineForVertical)) {
                float f16 = scrollX;
                if (f16 <= layout.getLineWidth(lineForVertical)) {
                    int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, f16);
                    ClickableSpan[] clickableSpanArr = (ClickableSpan[]) this.D.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                    if (clickableSpanArr != null && clickableSpanArr.length != 0) {
                        clickableSpan = clickableSpanArr[0];
                    } else {
                        clickableSpan = null;
                    }
                    if (clickableSpan == null || !(clickableSpan instanceof b)) {
                        return null;
                    }
                    return (b) clickableSpan;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return null;
    }

    private void k(Context context) {
        this.H = ViewConfiguration.get(context).getScaledTouchSlop();
        this.I = ViewConfiguration.getLongPressTimeout();
    }

    private void l() {
        for (Map.Entry<Range<Integer>, ImageSpan> entry : this.f303727h.entrySet()) {
            Range<Integer> key = entry.getKey();
            this.C.setSpan(entry.getValue(), key.getLower().intValue(), key.getUpper().intValue(), 17);
        }
        this.f303727h.clear();
    }

    private void m() {
        for (Map.Entry<Range<Integer>, ClickableSpan> entry : this.f303728i.entrySet()) {
            Range<Integer> key = entry.getKey();
            this.C.setSpan(entry.getValue(), key.getLower().intValue(), key.getUpper().intValue(), 17);
        }
        this.f303728i.clear();
    }

    private void n() {
        this.f303727h.clear();
        this.f303728i.clear();
        this.f303729m = true;
        this.C = new SpannableStringBuilder();
    }

    private void o(SpannableString spannableString, f fVar) {
        if (fVar.f303740b == null) {
            return;
        }
        setHighlightColor(0);
        spannableString.setSpan(new b(fVar.f303741c, fVar.f303740b), 0, spannableString.length(), 17);
    }

    private void p(d dVar, Range<Integer> range) {
        if (dVar.f303740b == null) {
            return;
        }
        setHighlightColor(0);
        this.f303728i.put(range, new b(dVar.f303741c, dVar.f303740b));
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        int action = motionEvent.getAction();
        Spannable spannable = this.D;
        if (spannable == null) {
            return super.onTouchEvent(motionEvent);
        }
        if (action == 0) {
            b j3 = j(motionEvent);
            if (j3 != null) {
                Selection.setSelection(this.D, this.D.getSpanStart(j3), this.D.getSpanEnd(j3));
                this.E = j3;
                this.F = motionEvent.getX();
                this.G = motionEvent.getY();
                removeCallbacks(this.J);
                postDelayed(this.J, this.I);
                return true;
            }
        } else if (action == 2) {
            b j16 = j(motionEvent);
            b bVar = this.E;
            if (bVar != null && j16 != bVar) {
                this.E = null;
                Selection.removeSelection(this.D);
                removeCallbacks(this.J);
            }
        } else if (this.E != null) {
            Selection.removeSelection(spannable);
            if (h(this.F, this.G, motionEvent)) {
                this.E.onClick(this);
                z16 = true;
            } else {
                z16 = false;
            }
            this.E = null;
            removeCallbacks(this.J);
            if (z16) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setImageColor(Drawable drawable, Integer num) {
        if (drawable != null && num != null) {
            drawable.mutate();
            drawable.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_ATOP);
        }
    }

    public void setRichText(List<e> list) {
        n();
        for (e eVar : list) {
            if (eVar.f303739a > 0) {
                f(eVar);
            }
            if (eVar instanceof f) {
                g((f) eVar);
            } else if (eVar instanceof d) {
                e((d) eVar);
            }
        }
        l();
        m();
        this.f303729m = false;
        setText(this.C);
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (charSequence instanceof Spannable) {
            this.D = (Spannable) charSequence;
        } else {
            this.D = null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class d extends e {

        /* renamed from: d, reason: collision with root package name */
        protected Drawable f303735d;

        /* renamed from: e, reason: collision with root package name */
        protected int f303736e;

        /* renamed from: f, reason: collision with root package name */
        protected int f303737f;

        /* renamed from: g, reason: collision with root package name */
        protected int f303738g;

        public d(int i3, int i16, Drawable drawable) {
            super(i3);
            this.f303735d = drawable;
            this.f303736e = i16;
            this.f303737f = i16;
        }

        public d(int i3, int i16, int i17, Drawable drawable) {
            super(i3);
            this.f303735d = drawable;
            this.f303736e = i16;
            this.f303737f = i17;
        }
    }

    public SpanSequenceTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f303727h = new HashMap<>();
        this.f303728i = new HashMap<>();
        this.f303729m = false;
        this.J = new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.QAdUIKit.SpanSequenceTextView.1
            @Override // java.lang.Runnable
            public void run() {
                if (SpanSequenceTextView.this.E != null) {
                    Selection.removeSelection(SpanSequenceTextView.this.D);
                    SpanSequenceTextView.this.E = null;
                }
            }
        };
        k(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        private c f303731d;

        /* renamed from: e, reason: collision with root package name */
        private a f303732e;

        /* renamed from: f, reason: collision with root package name */
        private int f303733f;

        public b(@IdRes int i3, c cVar) {
            this.f303733f = i3;
            this.f303731d = cVar;
            a();
        }

        private void a() {
            if (this.f303731d != null) {
                SpanSequenceTextView spanSequenceTextView = SpanSequenceTextView.this;
                this.f303732e = new a(spanSequenceTextView.getContext());
                ViewParent parent = SpanSequenceTextView.this.getParent();
                this.f303732e.setId(this.f303733f);
                if (parent != null) {
                    ((ViewGroup) parent).addView(this.f303732e);
                }
                this.f303731d.a(this.f303732e);
            }
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@NonNull View view) {
            c cVar = this.f303731d;
            if (cVar != null) {
                cVar.b(this.f303732e);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@NonNull TextPaint textPaint) {
        }
    }
}
