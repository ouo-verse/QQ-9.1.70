package com.tencent.mobileqq.qqlive.room.livelabel;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes17.dex */
public class j {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public f55.e[] f271629a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f271630b;

    /* renamed from: c, reason: collision with root package name */
    public f55.h[] f271631c;

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public j a(j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (j) iPatchRedirector.redirect((short) 3, (Object) this, (Object) jVar);
        }
        if (jVar == null) {
            return this;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(this.f271629a));
        f55.e[] eVarArr = jVar.f271629a;
        int length = eVarArr.length;
        if (length <= 1) {
            return this;
        }
        arrayList.addAll(Arrays.asList(eVarArr).subList(1, length));
        this.f271629a = (f55.e[]) arrayList.toArray(new f55.e[0]);
        ArrayList arrayList2 = new ArrayList(Arrays.asList(this.f271631c));
        arrayList2.addAll(Arrays.asList(jVar.f271631c));
        this.f271631c = (f55.h[]) arrayList2.toArray(new f55.h[0]);
        return this;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "SecondLabelBean{secondLabelInfos=" + Arrays.toString(this.f271629a) + ", isShowLogo=" + this.f271630b + ", firstTabLables=" + Arrays.toString(this.f271631c) + '}';
    }
}
