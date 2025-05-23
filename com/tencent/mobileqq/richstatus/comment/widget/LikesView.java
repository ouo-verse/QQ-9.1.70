package com.tencent.mobileqq.richstatus.comment.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class LikesView extends TextView {
    static IPatchRedirector $redirector_;
    private c C;
    private Drawable D;

    /* renamed from: d, reason: collision with root package name */
    private String f282347d;

    /* renamed from: e, reason: collision with root package name */
    private int f282348e;

    /* renamed from: f, reason: collision with root package name */
    private int f282349f;

    /* renamed from: h, reason: collision with root package name */
    private int f282350h;

    /* renamed from: i, reason: collision with root package name */
    private long f282351i;

    /* renamed from: m, reason: collision with root package name */
    private List<com.tencent.mobileqq.richstatus.comment.bean.a> f282352m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LikesView.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class b extends com.tencent.mobileqq.richstatus.comment.spannable.b {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f282354e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i3, String str) {
            super(i3);
            this.f282354e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LikesView.this, Integer.valueOf(i3), str);
            }
        }

        @Override // android.text.style.ClickableSpan, android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else if (LikesView.this.C != null) {
                LikesView.this.C.onClick(this.f282354e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface c {
        void onClick(String str);
    }

    public LikesView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f282347d = "LikesView";
            c();
        }
    }

    private void c() {
        this.f282350h = getResources().getColor(R.color.f157830cb);
        this.D = getResources().getDrawable(R.drawable.bho);
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.LikesView, 0, 0);
        try {
            this.f282348e = obtainStyledAttributes.getColor(R.styleable.LikesView_like_item_color, getResources().getColor(R.color.aea));
            this.f282349f = obtainStyledAttributes.getColor(R.styleable.LikesView_like_item_selector_color, getResources().getColor(R.color.ac_));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private SpannableString g(String str, String str2) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new b(this.f282348e, str2), 0, spannableString.length(), 33);
        return spannableString;
    }

    private SpannableString h() {
        SpannableString spannableString = new SpannableString("  ");
        int f16 = BaseAIOUtils.f(20.0f, getResources());
        this.D.setBounds(0, 0, f16, f16);
        spannableString.setSpan(new ImageSpan(this.D, 0), 0, 1, 33);
        return spannableString;
    }

    public Drawable b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.D;
    }

    public void e(List<com.tencent.mobileqq.richstatus.comment.bean.a> list, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, list, Long.valueOf(j3));
            return;
        }
        this.f282351i = j3;
        this.f282352m = list;
        f();
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        List<com.tencent.mobileqq.richstatus.comment.bean.a> list = this.f282352m;
        if (list != null && list.size() > 0) {
            setVisibility(0);
            spannableStringBuilder.append((CharSequence) h());
            for (int i3 = 0; i3 < this.f282352m.size(); i3++) {
                com.tencent.mobileqq.richstatus.comment.bean.a aVar = this.f282352m.get(i3);
                if (aVar != null) {
                    com.tencent.mobileqq.richstatus.comment.bean.b bVar = aVar.f282321b;
                    spannableStringBuilder.append((CharSequence) g(bVar.f282323b, bVar.f282322a));
                    if (i3 != this.f282352m.size() - 1) {
                        spannableStringBuilder.append((CharSequence) ", ");
                    }
                }
            }
            if (this.f282351i > 1) {
                spannableStringBuilder.append((CharSequence) String.format(getContext().getResources().getString(R.string.vyb), Long.valueOf(this.f282351i)));
            } else {
                spannableStringBuilder.append((CharSequence) getContext().getResources().getString(R.string.vya));
            }
            setText(new QQText(spannableStringBuilder, 3, 17));
            setTextColor(this.f282350h);
            setMovementMethod(new com.tencent.mobileqq.richstatus.comment.spannable.a(this.f282349f, getContext().getResources().getColor(R.color.ajr)));
            setOnClickListener(new a());
            return;
        }
        setVisibility(8);
    }

    public void setItemColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.f282348e = i3;
        }
    }

    public void setLikSpanDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) drawable);
        } else {
            this.D = drawable;
        }
    }

    public void setNormalTextColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
        } else {
            this.f282350h = i3;
        }
    }

    public void setOnItemClickListener(c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar);
        } else {
            this.C = cVar;
        }
    }

    public LikesView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f282347d = "LikesView";
        c();
        d(attributeSet);
    }

    public LikesView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.f282347d = "LikesView";
        c();
        d(attributeSet);
    }
}
