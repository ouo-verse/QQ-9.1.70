package com.tencent.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.ColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class MultiImageTextView extends ColorNickTextView {
    static IPatchRedirector $redirector_;
    private ArrayList<SpanAdapter> L;
    private StringBuilder M;
    public boolean N;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class a extends ImageSpan {
        static IPatchRedirector $redirector_;

        public a(Drawable drawable, int i3) {
            super(drawable, i3);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) drawable, i3);
            }
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
                return;
            }
            Drawable drawable = getDrawable();
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            int i26 = ((((fontMetricsInt.descent + i18) + i18) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2);
            canvas.save();
            canvas.translate(f16, i26);
            drawable.draw(canvas);
            canvas.restore();
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class b extends SpanAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public Drawable f384626a;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.widget.SpanAdapter
        public void getSpan(SpannableString spannableString) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) spannableString);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("spanStyle", 2, "[ImageStyle] start:" + this.start + " end:" + this.end);
            }
            spannableString.setSpan(new a(this.f384626a, 1), this.start, this.end, 17);
        }
    }

    public MultiImageTextView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    @Override // android.widget.TextView
    public void append(CharSequence charSequence, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.M.append(charSequence, i3, i16);
        this.N = true;
        super.append(charSequence, i3, i16);
    }

    public MultiImageTextView g(Drawable drawable, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (MultiImageTextView) iPatchRedirector.redirect((short) 10, this, drawable, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        b bVar = new b();
        bVar.f384626a = drawable;
        drawable.setBounds(0, 0, i3, i16);
        h(bVar);
        return this;
    }

    public void h(SpanAdapter spanAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) spanAdapter);
            return;
        }
        spanAdapter.apendString = "[" + this.L.size() + "]";
        int length = this.M.length();
        spanAdapter.start = length;
        spanAdapter.end = length + spanAdapter.apendString.length();
        this.M.append(spanAdapter.apendString);
        this.L.add(spanAdapter);
    }

    public void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        SpannableString spannableString = new SpannableString(this.M);
        Iterator<SpanAdapter> it = this.L.iterator();
        while (it.hasNext()) {
            it.next().getSpan(spannableString);
        }
        setText(spannableString);
    }

    @Override // com.tencent.mobileqq.widget.ColorNickTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) charSequence, (Object) bufferType);
            return;
        }
        if (!this.N) {
            ArrayList<SpanAdapter> arrayList = this.L;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.M = new StringBuilder(charSequence);
        } else {
            this.N = false;
        }
        super.setText(charSequence, bufferType);
    }

    public MultiImageTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public MultiImageTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.L = new ArrayList<>();
        this.M = new StringBuilder();
        this.N = false;
    }
}
