package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class FollowImageTextView extends LinearLayout {
    static IPatchRedirector $redirector_;
    private int C;
    private boolean D;
    private d E;
    private int F;

    /* renamed from: d, reason: collision with root package name */
    private a f302311d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f302312e;

    /* renamed from: f, reason: collision with root package name */
    private LinearLayout f302313f;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f302314h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f302315i;

    /* renamed from: m, reason: collision with root package name */
    private CharSequence f302316m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends TextView {
        static IPatchRedirector $redirector_;

        public a(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FollowImageTextView.this, (Object) context);
            }
        }

        @Override // android.widget.TextView, android.view.View
        protected void onDraw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
                return;
            }
            if (FollowImageTextView.this.D) {
                super.onDraw(canvas);
                return;
            }
            TextPaint paint = getPaint();
            paint.setColor(getCurrentTextColor());
            paint.drawableState = getDrawableState();
            d h16 = FollowImageTextView.this.h();
            h16.e(FollowImageTextView.this.C - 1);
            h16.a(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        CharSequence f302318a;

        /* renamed from: b, reason: collision with root package name */
        int f302319b;

        /* renamed from: c, reason: collision with root package name */
        int f302320c;

        /* renamed from: d, reason: collision with root package name */
        int f302321d;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface c {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private List<b> f302322a;

        /* renamed from: b, reason: collision with root package name */
        private CharSequence f302323b;

        /* renamed from: c, reason: collision with root package name */
        private int f302324c;

        /* renamed from: d, reason: collision with root package name */
        private int f302325d;

        /* renamed from: e, reason: collision with root package name */
        private int f302326e;

        /* renamed from: f, reason: collision with root package name */
        private int f302327f;

        /* renamed from: g, reason: collision with root package name */
        private int f302328g;

        /* renamed from: h, reason: collision with root package name */
        private int f302329h;

        /* renamed from: i, reason: collision with root package name */
        private int f302330i;

        /* renamed from: j, reason: collision with root package name */
        private TextPaint f302331j;

        /* renamed from: k, reason: collision with root package name */
        private FollowImageTextView f302332k;

        public d(FollowImageTextView followImageTextView) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) followImageTextView);
            } else {
                this.f302322a = new ArrayList();
                this.f302332k = followImageTextView;
            }
        }

        private void b() {
            this.f302322a.clear();
            int c16 = c();
            if (c16 <= 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("FollowImageTextView", 2, "lineWidth=" + c16);
                    return;
                }
                return;
            }
            int length = this.f302323b.length();
            int i3 = 0;
            int i16 = 0;
            int i17 = 0;
            while (i3 < length) {
                if (this.f302323b.charAt(i3) == '\n') {
                    b bVar = new b();
                    bVar.f302319b = i16;
                    bVar.f302320c = i3 - 1;
                    bVar.f302321d = i17;
                    bVar.f302318a = this.f302323b.subSequence(i16, i3);
                    this.f302322a.add(bVar);
                    i16 = i3 + 1;
                    i17 = 0;
                } else {
                    int d16 = d(this.f302323b.subSequence(i16, i3 + 1));
                    if (d16 > c16) {
                        b bVar2 = new b();
                        bVar2.f302319b = i16;
                        bVar2.f302320c = i3 - 1;
                        bVar2.f302321d = i17;
                        bVar2.f302318a = this.f302323b.subSequence(i16, i3);
                        this.f302322a.add(bVar2);
                        int i18 = i3 - 1;
                        if (this.f302322a.size() >= length) {
                            break;
                        }
                        i17 = 0;
                        i16 = i3;
                        i3 = i18;
                    } else if (i3 == length - 1) {
                        b bVar3 = new b();
                        bVar3.f302319b = i16;
                        bVar3.f302320c = i3 - 1;
                        bVar3.f302321d = d16;
                        bVar3.f302318a = this.f302323b.subSequence(i16, length);
                        this.f302322a.add(bVar3);
                    } else {
                        i17 = d16;
                    }
                }
                i3++;
            }
            FollowImageTextView.e(this.f302332k);
        }

        private int c() {
            return (this.f302324c - this.f302329h) - this.f302327f;
        }

        private int d(CharSequence charSequence) {
            return (int) this.f302331j.measureText(charSequence, 0, charSequence.length());
        }

        public void a(Canvas canvas) {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
                return;
            }
            int size = this.f302322a.size();
            int i3 = this.f302326e;
            if (i3 > 0 && i3 < size) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                size = i3;
            }
            for (int i16 = 0; i16 < size; i16++) {
                CharSequence charSequence = this.f302322a.get(i16).f302318a;
                canvas.drawText(charSequence, 0, charSequence.length(), this.f302327f + 0, this.f302331j.getTextSize() + (this.f302325d * i16) + this.f302328g, this.f302331j);
            }
            if (!z16 || size >= this.f302322a.size()) {
                this.f302332k.k(false);
                return;
            }
            b bVar = this.f302322a.get(size);
            int length = this.f302323b.length();
            int i17 = bVar.f302319b;
            if (i17 <= -1 || i17 >= length) {
                this.f302332k.k(false);
                return;
            }
            this.f302332k.f302312e.setText(this.f302323b.subSequence(i17, length));
            this.f302332k.k(true);
        }

        public void e(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a aVar = this.f302332k.f302311d;
                this.f302323b = aVar.getText();
                this.f302331j = aVar.getPaint();
                this.f302324c = aVar.getMeasuredWidth();
                this.f302325d = aVar.getLineHeight();
                this.f302327f = aVar.getPaddingLeft();
                this.f302328g = aVar.getPaddingTop();
                this.f302329h = aVar.getPaddingRight();
                this.f302330i = aVar.getPaddingBottom();
                this.f302326e = i3;
                b();
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }

    public FollowImageTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f302316m = "";
        this.C = Integer.MAX_VALUE;
        this.D = true;
        this.F = 10;
        i(context);
    }

    static /* bridge */ /* synthetic */ c e(FollowImageTextView followImageTextView) {
        followImageTextView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public d h() {
        if (this.E == null) {
            this.E = new d(this);
        }
        return this.E;
    }

    private void i(Context context) {
        setOrientation(1);
        LinearLayout linearLayout = new LinearLayout(context);
        this.f302313f = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f302313f.setOrientation(0);
        addView(this.f302313f);
        a aVar = new a(context);
        this.f302311d = aVar;
        aVar.setId(R.id.f166602gj2);
        this.f302311d.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f302313f.addView(this.f302311d);
        LinearLayout linearLayout2 = new LinearLayout(context);
        this.f302314h = linearLayout2;
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f302314h.setOrientation(0);
        this.f302314h.setVisibility(8);
        addView(this.f302314h);
        TextView textView = new TextView(context);
        this.f302312e = textView;
        textView.setId(R.id.f166603gj3);
        this.f302312e.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.f302312e.setSingleLine(true);
        this.f302312e.setEllipsize(TextUtils.TruncateAt.END);
        this.f302312e.setIncludeFontPadding(false);
        this.f302314h.addView(this.f302312e);
        this.f302315i = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        layoutParams.leftMargin = (int) ((this.F * context.getResources().getDisplayMetrics().density) + 0.5f);
        this.f302315i.setLayoutParams(layoutParams);
        this.f302315i.setVisibility(8);
        this.f302313f.addView(this.f302315i);
    }

    private void j() {
        boolean z16;
        int i3 = this.C;
        if (i3 < 2) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.D = z16;
        if (z16) {
            this.f302311d.setMaxLines(1);
            this.f302311d.setEllipsize(TextUtils.TruncateAt.END);
        } else {
            this.f302311d.setMaxLines(i3 - 1);
            this.f302311d.setEllipsize(null);
        }
        this.f302311d.setText(this.f302316m);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z16) {
        int visibility = this.f302314h.getVisibility();
        if (!z16 || visibility != 0) {
            if (!z16 && visibility == 8) {
                return;
            }
            if (z16) {
                this.f302314h.setVisibility(0);
                this.f302313f.removeView(this.f302315i);
                this.f302314h.addView(this.f302315i);
            } else {
                this.f302314h.setVisibility(8);
                this.f302314h.removeView(this.f302315i);
                this.f302313f.addView(this.f302315i);
            }
        }
    }

    public void setAllChildOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) onClickListener);
            return;
        }
        this.f302311d.setOnClickListener(onClickListener);
        this.f302312e.setOnClickListener(onClickListener);
        this.f302315i.setOnClickListener(onClickListener);
    }

    public void setAllChildOnTouchListener(View.OnTouchListener onTouchListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) onTouchListener);
            return;
        }
        this.f302311d.setOnTouchListener(onTouchListener);
        this.f302312e.setOnTouchListener(onTouchListener);
        this.f302315i.setOnTouchListener(onTouchListener);
    }

    public void setAllChildTag(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, obj);
            return;
        }
        this.f302311d.setTag(obj);
        this.f302312e.setTag(obj);
        this.f302315i.setTag(obj);
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) charSequence);
        } else {
            this.f302311d.setContentDescription(charSequence);
            this.f302312e.setContentDescription(charSequence);
        }
    }

    public void setFollowImageResource(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.f302315i.setImageResource(i3);
        }
    }

    public void setFollowImageVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, i3);
        } else {
            this.f302315i.setVisibility(i3);
        }
    }

    public void setFollowImageWH(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f302315i.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        this.f302315i.setLayoutParams(layoutParams);
    }

    public void setMaxLines(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.C = i3;
            j();
        }
    }

    public void setMaxWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, i3);
        } else {
            this.f302311d.setMaxWidth(i3);
            this.f302312e.setMaxWidth(i3);
        }
    }

    public void setOnTextLineChangeListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) cVar);
        }
    }

    public void setText(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) charSequence);
        } else {
            if (TextUtils.equals(this.f302316m, charSequence)) {
                return;
            }
            this.f302316m = charSequence;
            j();
        }
    }

    public void setTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f302311d.setTextColor(i3);
            this.f302312e.setTextColor(i3);
        }
    }

    public void setTextSize(int i3, float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Float.valueOf(f16));
        } else {
            this.f302311d.setTextSize(i3, f16);
            this.f302312e.setTextSize(i3, f16);
        }
    }

    public void setTextSize(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
        } else {
            this.f302311d.setTextSize(f16);
            this.f302312e.setTextSize(f16);
        }
    }

    public FollowImageTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f302316m = "";
        this.C = Integer.MAX_VALUE;
        this.D = true;
        this.F = 10;
        i(context);
    }

    public FollowImageTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f302316m = "";
        this.C = Integer.MAX_VALUE;
        this.D = true;
        this.F = 10;
        i(context);
    }
}
