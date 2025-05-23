package com.tencent.mobileqq.text;

import android.graphics.Paint;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public abstract class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private int f292685a;

    /* renamed from: b, reason: collision with root package name */
    private String f292686b;

    public l(int i3, @NonNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
        } else {
            this.f292685a = i3;
            this.f292686b = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f292686b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f292685a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float c(@NonNull Paint paint);
}
