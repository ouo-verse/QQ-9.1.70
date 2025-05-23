package com.tencent.mobileqq.leba.entity;

import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f240499a;

    /* renamed from: b, reason: collision with root package name */
    public int f240500b;

    /* renamed from: c, reason: collision with root package name */
    public final int f240501c;

    public l(long j3, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.f240499a = j3;
        this.f240500b = i3;
        this.f240501c = i16;
    }

    public boolean a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.f240500b == 1) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        if (this.f240499a == lVar.f240499a && this.f240500b == lVar.f240500b) {
            return true;
        }
        return false;
    }
}
