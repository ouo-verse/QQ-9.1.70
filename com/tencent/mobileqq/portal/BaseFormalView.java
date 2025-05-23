package com.tencent.mobileqq.portal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class BaseFormalView extends RelativeLayout {
    static IPatchRedirector $redirector_;

    public BaseFormalView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    public abstract void e(int i3, int i16, String str);

    public abstract long f();

    public abstract void g(ViewGroup viewGroup);

    public abstract boolean h();

    public abstract void i();

    public abstract void j();

    public abstract void k(@NonNull MotionEvent motionEvent);

    public abstract void l(@Nullable MotionEvent motionEvent);

    public abstract void m();

    public abstract void n();

    public abstract void o(long j3, long j16, CharSequence charSequence);

    public abstract void p();

    public abstract void q(Function1<Boolean, Unit> function1);

    public abstract void r(ViewGroup viewGroup);

    public abstract void s();

    public abstract void setGiftFiredNums(List<Integer> list);

    public abstract void setProgressLogo(String str);

    public abstract void setStartAndEndText(String str, String str2);

    public abstract void setUpgradeNums(List<Integer> list);

    public abstract void t();

    public abstract void u();

    public BaseFormalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public BaseFormalView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
    }
}
