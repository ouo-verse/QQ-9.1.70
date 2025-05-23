package com.tencent.theme;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.util.LongSparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
@TargetApi(16)
/* loaded from: classes26.dex */
public class f extends LongSparseArray<Drawable.ConstantState> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final int f376059d;

    /* renamed from: e, reason: collision with root package name */
    private final e f376060e;

    /* renamed from: f, reason: collision with root package name */
    private int f376061f;

    public f(int i3, e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) eVar);
            return;
        }
        this.f376061f = 0;
        this.f376059d = i3;
        this.f376060e = eVar;
    }

    @Override // android.util.LongSparseArray
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Drawable.ConstantState get(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 2, (Object) this, j3);
        }
        return this.f376060e.b(this.f376059d, j3);
    }

    @Override // android.util.LongSparseArray
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void put(long j3, Drawable.ConstantState constantState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Long.valueOf(j3), constantState);
        } else {
            this.f376060e.f376051b[this.f376059d].put(j3, constantState);
        }
    }

    @Override // android.util.LongSparseArray
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Drawable.ConstantState valueAt(int i3) {
        Drawable.ConstantState valueAt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 5, (Object) this, i3);
        }
        int i16 = this.f376061f + 1;
        this.f376061f = i16;
        if (i16 > 100) {
            valueAt = null;
            m.b(SkinEngine.TAG, 2, "parentFunction:" + this + ", childFunction=" + this.f376060e.f376051b[this.f376059d], null);
        } else {
            valueAt = this.f376060e.f376051b[this.f376059d].valueAt(i3);
        }
        this.f376061f--;
        return valueAt;
    }

    @Override // android.util.LongSparseArray
    public int size() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.f376060e.f376051b[this.f376059d].size();
    }
}
