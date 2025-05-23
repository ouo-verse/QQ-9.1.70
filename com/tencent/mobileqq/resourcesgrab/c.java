package com.tencent.mobileqq.resourcesgrab;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.theme.SkinData;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public int f281276a;

    /* renamed from: b, reason: collision with root package name */
    public SkinData f281277b;

    /* renamed from: c, reason: collision with root package name */
    public int[][] f281278c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f281279d;

    public c(int i3, SkinData skinData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) skinData);
        } else {
            this.f281276a = i3;
            this.f281277b = skinData;
        }
    }
}
