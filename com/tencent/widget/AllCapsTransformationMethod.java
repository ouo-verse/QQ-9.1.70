package com.tencent.widget;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AllCapsTransformationMethod implements TransformationMethod2 {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "AllCapsTransformationMethod";
    private boolean mEnabled;
    private Locale mLocale;

    public AllCapsTransformationMethod(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.mLocale = context.getResources().getConfiguration().locale;
        }
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (CharSequence) iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence, (Object) view);
        }
        if (this.mEnabled) {
            if (charSequence != null) {
                return charSequence.toString().toUpperCase(this.mLocale);
            }
            return null;
        }
        QLog.w(TAG, 2, "Caller did not enable length changes; not transforming text");
        return charSequence;
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z16, int i3, Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, charSequence, Boolean.valueOf(z16), Integer.valueOf(i3), rect);
        }
    }

    @Override // com.tencent.widget.TransformationMethod2
    public void setLengthChangesAllowed(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.mEnabled = z16;
        }
    }
}
