package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.QColorNickTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QMultiImageTextView extends QColorNickTextView {
    static IPatchRedirector $redirector_;
    private StringBuilder mAppendSpanbleString;
    private ArrayList<SpanAdapter> mAppendedIcon;
    public boolean mIsAppend;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class AlignCenterImageSpan extends ImageSpan {
        static IPatchRedirector $redirector_;

        public AlignCenterImageSpan(Drawable drawable, int i3) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class FontStyle extends SpanAdapter {
        static IPatchRedirector $redirector_;
        public int fontBackgroundColor;
        public int fontColor;
        public int fontSize;

        FontStyle() {
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
                QLog.d("spanStyle", 2, "[FontStyle] start:" + this.start + " end:" + this.end + " fontColor:" + this.fontColor + " fontSize:" + this.fontSize + " fontBackgroundColor" + this.fontBackgroundColor);
            }
            spannableString.setSpan(new AbsoluteSizeSpan(this.fontSize, true), this.start, this.end, 17);
            spannableString.setSpan(new ForegroundColorSpan(this.fontColor), this.start, this.end, 17);
            spannableString.setSpan(new BackgroundColorSpan(this.fontBackgroundColor), this.start, this.end, 17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class IconIDString extends SpanAdapter {
        static IPatchRedirector $redirector_;
        public Drawable drawable;

        IconIDString() {
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
            spannableString.setSpan(new AlignCenterImageSpan(this.drawable, 1), this.start, this.end, 17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class LabelStyle extends SpanAdapter {
        static IPatchRedirector $redirector_;
        public int labelColor;
        public int labelIcon;
        private RoundBackgroundSpan span;

        public LabelStyle(Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) resources);
            } else {
                this.span = new RoundBackgroundSpan(this.labelColor, this.labelIcon, resources);
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
                QLog.d("spanStyle", 2, "[LabelStyle] start:" + this.start + " end:" + this.end + " labelColor:" + this.labelColor + " labelIcon:" + this.labelIcon);
            }
            spannableString.setSpan(this.span, this.start, this.end, 17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class MarginSpan extends ReplacementSpan {
        static IPatchRedirector $redirector_;
        private int mMarginPix;

        public MarginSpan(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.mMarginPix = i3;
            }
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
            }
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
            }
            return this.mMarginPix;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class MarginStyle extends SpanAdapter {
        static IPatchRedirector $redirector_;
        public int marginPix;

        MarginStyle() {
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
                QLog.d("spanStyle", 2, "[MarginStyle] start:" + this.start + " end:" + this.end + " marginPix:" + this.marginPix);
            }
            spannableString.setSpan(new MarginSpan(this.marginPix), this.start, this.end, 17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class RoundBackgroundSpan extends ReplacementSpan {
        static IPatchRedirector $redirector_ = null;
        private static final int iconPadding = 10;
        private static final int padding = 20;
        private int mLabelColor;
        private Bitmap mLabelIcon;

        public RoundBackgroundSpan(int i3, int i16, Resources resources) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), resources);
                return;
            }
            this.mLabelColor = i3;
            if (i16 != 0) {
                try {
                    this.mLabelIcon = BitmapFactory.decodeResource(resources, i16);
                    return;
                } catch (OutOfMemoryError e16) {
                    if (QLog.isColorLevel()) {
                        QLog.d("RoundbackgroundSpan", 2, e16, new Object[0]);
                        return;
                    }
                    return;
                }
            }
            this.mLabelIcon = null;
        }

        private float measureText(Paint paint, CharSequence charSequence, int i3, int i16) {
            float measureText;
            if (this.mLabelIcon != null) {
                measureText = paint.measureText(charSequence, i3, i16) + 10.0f + this.mLabelIcon.getWidth();
            } else {
                measureText = paint.measureText(charSequence, i3, i16);
            }
            return measureText + 40.0f;
        }

        @Override // android.text.style.ReplacementSpan
        public void draw(Canvas canvas, CharSequence charSequence, int i3, int i16, float f16, int i17, int i18, int i19, Paint paint) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, canvas, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), paint);
                return;
            }
            Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
            RectF rectF = new RectF(f16 + 2.0f, fontMetricsInt.top + i18 + 2, (f16 + measureText(paint, charSequence, i3, i16)) - 2.0f, (fontMetricsInt.bottom + i18) - 2);
            paint.setColor(this.mLabelColor);
            paint.setStyle(Paint.Style.STROKE);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(2.0f);
            canvas.drawRoundRect(rectF, 10.0f, 10.0f, paint);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.mLabelColor);
            Bitmap bitmap = this.mLabelIcon;
            if (bitmap != null) {
                if (bitmap.getHeight() < i19 - i17) {
                    float f17 = f16 + 20.0f;
                    canvas.drawBitmap(this.mLabelIcon, f17, (r9 - r5) / 2, paint);
                    canvas.drawText(charSequence, i3, i16, f17 + 10.0f + this.mLabelIcon.getWidth(), i18, paint);
                    return;
                }
                canvas.drawText(charSequence, i3, i16, f16 + 20.0f, i18, paint);
                return;
            }
            canvas.drawText(charSequence, i3, i16, f16 + 20.0f, i18, paint);
        }

        @Override // android.text.style.ReplacementSpan
        public int getSize(Paint paint, CharSequence charSequence, int i3, int i16, Paint.FontMetricsInt fontMetricsInt) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, this, paint, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), fontMetricsInt)).intValue();
            }
            return Math.round(measureText(paint, charSequence, i3, i16));
        }
    }

    public QMultiImageTextView(Context context) {
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
        this.mAppendSpanbleString.append(charSequence, i3, i16);
        this.mIsAppend = true;
        super.append(charSequence, i3, i16);
    }

    public void appendEnd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        SpannableString spannableString = new SpannableString(this.mAppendSpanbleString);
        Iterator<SpanAdapter> it = this.mAppendedIcon.iterator();
        while (it.hasNext()) {
            it.next().getSpan(spannableString);
        }
        setText(spannableString);
    }

    public QMultiImageTextView appendLabel(CharSequence charSequence, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (QMultiImageTextView) iPatchRedirector.redirect((short) 15, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        LabelStyle labelStyle = new LabelStyle(getResources());
        labelStyle.labelColor = i3;
        labelStyle.labelIcon = i16;
        labelStyle.apendString = "[" + this.mAppendedIcon.size() + "]";
        int length = this.mAppendSpanbleString.length();
        labelStyle.start = length;
        labelStyle.end = length + charSequence.length();
        this.mAppendSpanbleString.append(charSequence);
        this.mAppendedIcon.add(labelStyle);
        return this;
    }

    public void appendMargin(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            appendMargin((int) ((f16 * getResources().getDisplayMetrics().density) + 0.5f));
        } else {
            iPatchRedirector.redirect((short) 6, this, Float.valueOf(f16));
        }
    }

    @Override // com.tencent.mobileqq.widget.QColorNickTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) charSequence, (Object) bufferType);
            return;
        }
        if (!this.mIsAppend) {
            ArrayList<SpanAdapter> arrayList = this.mAppendedIcon;
            if (arrayList != null) {
                arrayList.clear();
            }
            this.mAppendSpanbleString = new StringBuilder(charSequence);
        } else {
            this.mIsAppend = false;
        }
        super.setText(charSequence, bufferType);
    }

    public QMultiImageTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public QMultiImageTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.mAppendedIcon = new ArrayList<>();
        this.mAppendSpanbleString = new StringBuilder();
        this.mIsAppend = false;
    }

    public QMultiImageTextView append(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (QMultiImageTextView) iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
        append(getResources().getDrawable(i3), i16, i17);
        return this;
    }

    public void appendMargin(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        MarginStyle marginStyle = new MarginStyle();
        marginStyle.marginPix = i3;
        append(marginStyle);
    }

    public void appendEnd(Drawable drawable, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, drawable, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            append(drawable, i3, i16);
            appendEnd();
        }
    }

    public QMultiImageTextView append(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (QMultiImageTextView) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        Drawable drawable = getResources().getDrawable(i3);
        append(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        return this;
    }

    public void appendEnd(int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            appendEnd(getResources().getDrawable(i3), i16, i17);
        } else {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    public QMultiImageTextView append(Drawable drawable, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (QMultiImageTextView) iPatchRedirector.redirect((short) 10, this, drawable, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        IconIDString iconIDString = new IconIDString();
        iconIDString.drawable = drawable;
        drawable.setBounds(0, 0, i3, i16);
        append(iconIDString);
        return this;
    }

    public void appendEnd(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            Drawable drawable = getResources().getDrawable(i3);
            appendEnd(drawable, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }
    }

    public QMultiImageTextView appendLabel(CharSequence charSequence, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (QMultiImageTextView) iPatchRedirector.redirect((short) 16, (Object) this, (Object) charSequence, i3);
        }
        appendLabel(charSequence, i3, 0);
        return this;
    }

    public void append(CharSequence charSequence, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            return;
        }
        FontStyle fontStyle = new FontStyle();
        fontStyle.fontColor = i3;
        fontStyle.fontSize = i16;
        fontStyle.fontBackgroundColor = i17;
        fontStyle.apendString = "[" + this.mAppendedIcon.size() + "]";
        int length = this.mAppendSpanbleString.length();
        fontStyle.start = length;
        fontStyle.end = length + charSequence.length();
        this.mAppendSpanbleString.append(charSequence);
        this.mAppendedIcon.add(fontStyle);
    }

    public void append(CharSequence charSequence, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            append(charSequence, Color.parseColor(str), i3, 0);
        } else {
            iPatchRedirector.redirect((short) 18, this, charSequence, str, Integer.valueOf(i3));
        }
    }

    public void append(SpanAdapter spanAdapter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) spanAdapter);
            return;
        }
        spanAdapter.apendString = "[" + this.mAppendedIcon.size() + "]";
        int length = this.mAppendSpanbleString.length();
        spanAdapter.start = length;
        spanAdapter.end = length + spanAdapter.apendString.length();
        this.mAppendSpanbleString.append(spanAdapter.apendString);
        this.mAppendedIcon.add(spanAdapter);
    }

    public void append(SpanAdapter spanAdapter, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) spanAdapter, (Object) str);
        } else {
            this.mAppendSpanbleString.append(str);
            this.mAppendedIcon.add(spanAdapter);
        }
    }
}
