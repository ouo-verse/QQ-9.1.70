package com.tencent.biz.subscribe.widget.textview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import cf0.c;
import com.tencent.biz.subscribe.comment.o;
import com.tencent.biz.subscribe.widget.textview.RichTextParser;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.theme.ISkinIgnoreTypeface;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.regex.Matcher;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AsyncRichTextView extends SafeTextView implements Handler.Callback, ISkinIgnoreTypeface {
    private Drawable.Callback C;
    protected c.a D;
    protected c.a E;
    protected View.OnClickListener F;
    private boolean G;
    private boolean H;
    private Handler I;
    private double J;
    protected int K;
    private String L;
    private boolean M;
    private boolean N;
    private boolean P;
    protected int Q;
    protected ColorStateList R;
    protected int S;
    protected c.a T;
    protected URLDrawable.URLDrawableListener U;

    /* renamed from: d, reason: collision with root package name */
    private Context f96562d;

    /* renamed from: e, reason: collision with root package name */
    private CharSequence f96563e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f96564f;

    /* renamed from: h, reason: collision with root package name */
    private int f96565h;

    /* renamed from: i, reason: collision with root package name */
    private int f96566i;

    /* renamed from: m, reason: collision with root package name */
    private int f96567m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements c.a {
        a() {
        }

        @Override // cf0.c.a
        public boolean onClick(String str) {
            c.a aVar = AsyncRichTextView.this.E;
            if (aVar != null) {
                aVar.onClick(str);
            }
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface c {
    }

    public AsyncRichTextView(Context context) {
        super(context, null);
        this.f96566i = Integer.MIN_VALUE;
        this.f96567m = Integer.MIN_VALUE;
        this.G = true;
        this.H = false;
        this.I = new Handler(Looper.getMainLooper(), this);
        this.J = 1.0d;
        this.M = false;
        this.Q = Color.parseColor("#CFB027");
        this.R = BaseApplication.getContext().getResources().getColorStateList(R.color.ahm);
        this.S = -1;
        this.T = new a();
        this.U = new b(this);
        d(context, null);
    }

    private void d(Context context, AttributeSet attributeSet) {
        this.f96562d = context;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.EmoText);
        try {
            double d16 = obtainStyledAttributes.getFloat(R.styleable.EmoText_emo_icon_scale, 1.0f);
            this.J = d16;
            if (d16 <= 0.1d || d16 >= 10.0d) {
                this.J = 1.0d;
            }
            this.K = obtainStyledAttributes.getInt(R.styleable.EmoText_emo_icon_alignment, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void e(CharSequence charSequence, ColorStateList colorStateList, int i3, int i16, c.a aVar, Drawable.Callback callback) {
        this.f96563e = charSequence;
        this.f96564f = colorStateList;
        this.f96565h = i3;
        this.D = aVar;
        this.C = callback;
        RichTextParser.b bVar = new RichTextParser.b();
        bVar.f96587a = (int) (getTextSize() * this.J);
        bVar.f96588b = this.K;
        bVar.f96589c = getText();
        RichTextParser.a f16 = RichTextParser.f(bVar, getContext(), charSequence, colorStateList, i3, this.f96566i, i16, aVar, null, null, this.U, this.G, this.H);
        if (f16 != null && f16.f96584d) {
            if (aVar != null) {
                setMovementMethod(getDefaultMovementMethod());
            }
        } else if (f16 != null) {
            boolean z16 = f16.f96585e;
        }
        super.setText(new QQText(g(f16), 3, 16), (TextView.BufferType) null);
    }

    @RequiresApi(api = 16)
    protected void f() {
        int i3;
        this.P = false;
        if (getEllipsize() == TextUtils.TruncateAt.END && getLayout() != null && getLineCount() > getMaxLines() && getMaxLines() > 0) {
            int lineStart = getLayout().getLineStart(getMaxLines() - 1);
            CharSequence ellipsize = TextUtils.ellipsize(getText().subSequence(lineStart, getText().length()), getPaint(), (getWidth() - getPaddingLeft()) - getPaddingRight(), TextUtils.TruncateAt.END);
            if (this.N) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(getText());
                ImageSpan[] imageSpanArr = (ImageSpan[]) spannableStringBuilder.getSpans(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), ImageSpan.class);
                if (imageSpanArr.length > 0 && imageSpanArr[0].getDrawable() != null) {
                    i3 = imageSpanArr[0].getDrawable().getIntrinsicWidth();
                } else {
                    i3 = 0;
                }
                int i16 = i3 + 0;
                if (i16 > 0) {
                    CharSequence subSequence = ellipsize.subSequence(0, ellipsize.length() - 1);
                    int ceil = i16 + ((int) Math.ceil(getPaint().measureText(MiniBoxNoticeInfo.APPNAME_SUFFIX.toString())));
                    int length = subSequence.length();
                    int i17 = 0;
                    while (i17 < ceil) {
                        if (subSequence.toString().endsWith(QzoneEmotionUtils.EMO_TAIL)) {
                            Matcher matcher = o.f96044o.matcher(subSequence);
                            while (true) {
                                if (!matcher.find()) {
                                    break;
                                }
                                int start = matcher.start();
                                int end = matcher.end();
                                if (start < length && end == length) {
                                    i17 = (int) (i17 + getTextSize());
                                    length = start;
                                    break;
                                }
                            }
                        } else if (length > 0) {
                            i17 += (int) Math.floor(getPaint().measureText(subSequence.subSequence(length - 1, length).toString()));
                            length--;
                        }
                        if (length >= 0) {
                            subSequence = subSequence.subSequence(0, length);
                        }
                    }
                    SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(subSequence);
                    spannableStringBuilder2.append((CharSequence) MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    spannableStringBuilder2.append((CharSequence) " ");
                    spannableStringBuilder2.setSpan(imageSpanArr[0], spannableStringBuilder2.length() - 1, spannableStringBuilder2.length(), 33);
                    ellipsize = spannableStringBuilder2;
                }
            }
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder();
            if (lineStart > 0) {
                spannableStringBuilder3.append(getText().subSequence(0, lineStart));
            }
            spannableStringBuilder3.append(ellipsize);
            super.setText(new QQText(spannableStringBuilder3, 3, 16), (TextView.BufferType) null);
            this.P = true;
        }
    }

    @Override // android.widget.TextView
    protected MovementMethod getDefaultMovementMethod() {
        return LinkMovementMethod.getInstance();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        CharSequence charSequence;
        if (message.what == 1 && (charSequence = (CharSequence) message.obj) != null && charSequence.equals(this.f96563e)) {
            e(charSequence, this.f96564f, this.f96565h, this.f96567m, this.D, this.C);
            return false;
        }
        return false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CharSequence text = getText();
        if (text instanceof SpannableStringBuilder) {
            ((SpannableStringBuilder) text).clearSpans();
        }
    }

    @Override // android.widget.TextView, android.view.View
    @RequiresApi(api = 16)
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (this.M) {
            f();
            this.M = false;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        setFocusable(false);
        return super.onTouchEvent(motionEvent);
    }

    public void setBoldText(boolean z16) {
        TextPaint paint = getPaint();
        if (paint != null) {
            paint.setFakeBoldText(z16);
        }
    }

    public void setDefaultAtColor(String str) {
        this.Q = Color.parseColor(str);
    }

    public void setDefaultUserNameClickListener(c.a aVar) {
        this.T = aVar;
    }

    public void setNeedParseColor(boolean z16) {
        this.G = z16;
    }

    public void setNoNeedAtOrSchema(boolean z16) {
        this.H = z16;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.F = onClickListener;
        super.setOnClickListener(onClickListener);
    }

    public void setOnUserNewClickListener(c.a aVar) {
        this.E = aVar;
    }

    public void setOrgText(String str) {
        this.L = str;
    }

    public void setSchemaColorRes(int i3) {
        this.f96567m = i3;
    }

    @Override // com.tencent.biz.subscribe.widget.textview.SafeTextView, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.M = true;
        e(charSequence, this.R, this.Q, this.S, this.T, null);
    }

    public void setUrlColorRes(int i3) {
        this.f96566i = i3;
    }

    public void setDefaultAtColor(int i3) {
        this.Q = i3;
    }

    public AsyncRichTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f96566i = Integer.MIN_VALUE;
        this.f96567m = Integer.MIN_VALUE;
        this.G = true;
        this.H = false;
        this.I = new Handler(Looper.getMainLooper(), this);
        this.J = 1.0d;
        this.M = false;
        this.Q = Color.parseColor("#CFB027");
        this.R = BaseApplication.getContext().getResources().getColorStateList(R.color.ahm);
        this.S = -1;
        this.T = new a();
        this.U = new b(this);
        d(context, attributeSet);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        private WeakReference<AsyncRichTextView> f96569d;

        public b(AsyncRichTextView asyncRichTextView) {
            this.f96569d = new WeakReference<>(asyncRichTextView);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            if (QLog.isColorLevel()) {
                QLog.d("AsyncRichTextView", 4, "onLoadSuccessed ");
            }
            WeakReference<AsyncRichTextView> weakReference = this.f96569d;
            if (weakReference != null && weakReference.get() != null) {
                this.f96569d.get().invalidate();
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }

    protected Spannable g(Spannable spannable) {
        return spannable;
    }

    public void setOnCustomSchemaClickListener(cf0.a aVar) {
    }

    public void setOnCustomUrlClickListener(cf0.b bVar) {
    }

    public void setOnTriggerEllipseListener(c cVar) {
    }

    public AsyncRichTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f96566i = Integer.MIN_VALUE;
        this.f96567m = Integer.MIN_VALUE;
        this.G = true;
        this.H = false;
        this.I = new Handler(Looper.getMainLooper(), this);
        this.J = 1.0d;
        this.M = false;
        this.Q = Color.parseColor("#CFB027");
        this.R = BaseApplication.getContext().getResources().getColorStateList(R.color.ahm);
        this.S = -1;
        this.T = new a();
        this.U = new b(this);
        d(context, attributeSet);
    }
}
