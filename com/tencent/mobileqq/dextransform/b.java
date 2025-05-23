package com.tencent.mobileqq.dextransform;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public e[] f203538a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public d[] f203539b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public String[] f203540c;

    /* renamed from: d, reason: collision with root package name */
    private Pattern[] f203541d;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public boolean a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        String[] strArr = this.f203540c;
        if (strArr == null) {
            return false;
        }
        if (this.f203541d == null) {
            this.f203541d = new Pattern[strArr.length];
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.f203540c;
                if (i3 >= strArr2.length) {
                    break;
                }
                this.f203541d[i3] = Pattern.compile(strArr2[i3]);
                i3++;
            }
        }
        for (Pattern pattern : this.f203541d) {
            if (pattern.matcher(str).matches()) {
                return true;
            }
        }
        return false;
    }

    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        e[] eVarArr = this.f203538a;
        if (eVarArr != null) {
            for (e eVar : eVarArr) {
                if (!eVar.c()) {
                    return false;
                }
            }
        }
        d[] dVarArr = this.f203539b;
        if (dVarArr != null) {
            for (d dVar : dVarArr) {
                if (!dVar.c()) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }
}
