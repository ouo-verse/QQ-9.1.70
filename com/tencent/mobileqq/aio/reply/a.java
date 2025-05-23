package com.tencent.mobileqq.aio.reply;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends ArrowKeyMovementMethod {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static a f193178c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f193179a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f193180b;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f193179a = false;
            this.f193180b = false;
        }
    }

    private int a(int i3) {
        if (!this.f193180b) {
            return 0;
        }
        return (e.f194142a.d() - i3) / 2;
    }

    private int b(TextView textView) {
        if (!this.f193180b) {
            return 0;
        }
        return textView.getPaddingTop();
    }

    public static MovementMethod getInstance() {
        if (f193178c == null) {
            f193178c = new a();
        }
        return f193178c;
    }

    public void c(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.f193180b = z16;
        }
    }

    @Override // android.text.method.ArrowKeyMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
    public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
        d dVar;
        Drawable drawable;
        d dVar2;
        Drawable drawable2;
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, textView, spannable, motionEvent)).booleanValue();
        }
        int action = motionEvent.getAction();
        int i17 = 20;
        int i18 = 40;
        if (action == 1) {
            int x16 = (int) motionEvent.getX();
            int y16 = (int) motionEvent.getY();
            if (textView.getTag(R.id.gja) != null && (drawable2 = (dVar2 = (d) textView.getTag(R.id.gja)).getDrawable()) != null) {
                int intrinsicWidth = drawable2.getIntrinsicWidth();
                int intrinsicHeight = drawable2.getIntrinsicHeight();
                if (b.c()) {
                    i3 = a(intrinsicWidth);
                    i16 = b(textView);
                } else {
                    i17 = 0;
                    i18 = 0;
                    i3 = 0;
                    i16 = 0;
                }
                int i19 = i17 + i16;
                int i26 = intrinsicWidth + i3 + i18;
                int i27 = intrinsicHeight + i17 + i16;
                if (new Rect(i3, i19, i26, i27).contains(x16, y16)) {
                    Rect rect = new Rect((intrinsicWidth - dVar2.f193186m) + i3, i19, i26, i27);
                    if (b.c()) {
                        if (rect.contains(x16, y16)) {
                            dVar2.j();
                            this.f193179a = false;
                        } else if (this.f193179a) {
                            textView.setCompoundDrawables(null, dVar2.getDrawable(), null, null);
                            this.f193179a = false;
                        } else {
                            dVar2.i(textView);
                        }
                    } else {
                        dVar2.i(textView);
                    }
                    return true;
                }
                if (this.f193179a && b.c()) {
                    textView.setCompoundDrawables(null, dVar2.getDrawable(), null, null);
                    this.f193179a = false;
                    return true;
                }
            }
        } else if (b.c() && action == 0) {
            int x17 = (int) motionEvent.getX();
            int y17 = (int) motionEvent.getY();
            if (textView.getTag(R.id.gja) != null && (drawable = (dVar = (d) textView.getTag(R.id.gja)).getDrawable()) != null) {
                int intrinsicWidth2 = drawable.getIntrinsicWidth();
                int intrinsicHeight2 = drawable.getIntrinsicHeight();
                int a16 = a(intrinsicWidth2);
                if (new Rect((intrinsicWidth2 - dVar.f193186m) + a16, 20, intrinsicWidth2 + a16 + 40, intrinsicHeight2 + 20).contains(x17, y17)) {
                    textView.setCompoundDrawables(null, dVar.d(), null, null);
                    this.f193179a = true;
                    return true;
                }
            }
        }
        return Touch.onTouchEvent(textView, spannable, motionEvent);
    }
}
