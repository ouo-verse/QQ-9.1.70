package com.tencent.mobileqq.text;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
class j extends l {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private final EmoticonSpan f292683c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(@NonNull String str, int i3, int i16) {
        super(2, str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.f292683c = new EmoticonSpan(i3, i16, 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.text.l
    public float c(@NonNull Paint paint) {
        float f16;
        Drawable drawable = this.f292683c.getDrawable();
        if (drawable != null) {
            f16 = drawable.getBounds().width();
        } else {
            f16 = 0.0f;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NickWrapper", 2, "getWidth normal span width " + f16);
        }
        return f16;
    }
}
