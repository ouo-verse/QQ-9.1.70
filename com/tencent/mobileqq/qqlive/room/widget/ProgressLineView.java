package com.tencent.mobileqq.qqlive.room.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes17.dex */
public class ProgressLineView extends FrameLayout {
    static IPatchRedirector $redirector_;

    public ProgressLineView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            a(context);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.hbw, (ViewGroup) this, true);
    }

    public void setProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Float.valueOf(f16));
        } else {
            View findViewById = findViewById(R.id.f642235n);
            findViewById.post(new Runnable(f16, findViewById) { // from class: com.tencent.mobileqq.qqlive.room.widget.ProgressLineView.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ float f272144d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ View f272145e;

                {
                    this.f272144d = f16;
                    this.f272145e = findViewById;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ProgressLineView.this, Float.valueOf(f16), findViewById);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    int width = ProgressLineView.this.getWidth();
                    int i3 = (int) (this.f272144d * width);
                    if (i3 < 0) {
                        i3 = 0;
                    }
                    if (i3 <= width) {
                        width = i3;
                    }
                    ViewGroup.LayoutParams layoutParams = this.f272145e.getLayoutParams();
                    layoutParams.width = width;
                    this.f272145e.setLayoutParams(layoutParams);
                }
            });
        }
    }

    public ProgressLineView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            a(context);
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        }
    }

    public ProgressLineView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            a(context);
        } else {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        }
    }
}
