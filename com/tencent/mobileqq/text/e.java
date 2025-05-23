package com.tencent.mobileqq.text;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes18.dex */
public class e extends SpannableStringBuilder {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static Editable.Factory f292679e;

    /* renamed from: d, reason: collision with root package name */
    private int f292680d;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a extends Editable.Factory {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.text.Editable.Factory
        public Editable newEditable(CharSequence charSequence) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Editable) iPatchRedirector.redirect((short) 2, (Object) this, (Object) charSequence);
            }
            if (charSequence instanceof e) {
                return (Editable) charSequence;
            }
            return new e(charSequence, 16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75856);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f292679e = new a();
        }
    }

    public e(CharSequence charSequence, int i3) {
        super(a(charSequence, i3));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) charSequence, i3);
        } else {
            this.f292680d = i3;
        }
    }

    private static CharSequence a(CharSequence charSequence, int i3) {
        if (charSequence instanceof c) {
            return ((c) charSequence).j();
        }
        return new c(charSequence, i3).j();
    }

    @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
    public CharSequence subSequence(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (CharSequence) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        return super.subSequence(i3, i16);
    }

    @Override // android.text.SpannableStringBuilder, android.text.Editable
    public SpannableStringBuilder replace(int i3, int i16, CharSequence charSequence, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SpannableStringBuilder) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), charSequence, Integer.valueOf(i17), Integer.valueOf(i18));
        }
        if (i3 < 0) {
            i3 = 0;
        }
        try {
            int length = length();
            if (i16 > length) {
                i16 = length;
            }
            if (i16 < 0) {
                if (QLog.isColorLevel()) {
                    QLog.w("ColorNick.EmoticonBuilder", 2, "selection error, start = " + i3 + " end = " + i16 + " length = " + length);
                }
                i16 = 0;
            }
            if (charSequence.length() > 0) {
                charSequence = new c(charSequence, this.f292680d).j();
            }
            return super.replace(i3, i16, charSequence, i17, i18);
        } catch (Throwable th5) {
            QLog.e("ColorNick.EmoticonBuilder", 1, "QQTextBuilder.replace caused crash..text:" + toString() + ", replace text:" + ((Object) charSequence) + " , " + i3 + "-" + i16 + " , " + i17 + "-" + i18, th5);
            return new SpannableStringBuilder();
        }
    }
}
