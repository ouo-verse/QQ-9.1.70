package com.tencent.mobileqq.activity.contacts.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes10.dex */
public class RedTouchTextView extends TextView {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public boolean f181497d;

    /* renamed from: e, reason: collision with root package name */
    Paint f181498e;

    public RedTouchTextView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.f181497d = false;
            a();
        }
    }

    private void a() {
        if (this.f181498e == null) {
            Paint paint = new Paint();
            this.f181498e = paint;
            paint.setStyle(Paint.Style.FILL);
            this.f181498e.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f181498e.setColor(SupportMenu.CATEGORY_MASK);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
        } else {
            super.onDraw(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, i16);
            setMeasuredDimension(getMeasuredWidth() + ViewUtils.dip2px(10.0f), getMeasuredHeight() + ViewUtils.dip2px(10.0f));
        }
    }

    public RedTouchTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f181497d = false;
            a();
        }
    }

    public RedTouchTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f181497d = false;
            a();
        }
    }
}
