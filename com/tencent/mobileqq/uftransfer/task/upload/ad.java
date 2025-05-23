package com.tencent.mobileqq.uftransfer.task.upload;

import com.tencent.mobileqq.filemanager.excitingtransfer.excitingtransfersdk.ExcitingTransferUploaderRp;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ad {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final int f305495a;

    /* renamed from: b, reason: collision with root package name */
    public final String f305496b;

    /* renamed from: c, reason: collision with root package name */
    public String f305497c;

    /* renamed from: d, reason: collision with root package name */
    public Object f305498d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f305499e;

    /* renamed from: f, reason: collision with root package name */
    public long f305500f;

    /* renamed from: g, reason: collision with root package name */
    public long f305501g;

    public ad(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            return;
        }
        this.f305497c = "";
        this.f305499e = false;
        this.f305500f = 0L;
        this.f305501g = 0L;
        this.f305495a = i3;
        this.f305496b = str;
    }

    public ExcitingTransferUploaderRp a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ExcitingTransferUploaderRp) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Object obj = this.f305498d;
        if (obj != null && (obj instanceof ExcitingTransferUploaderRp)) {
            return (ExcitingTransferUploaderRp) obj;
        }
        return null;
    }

    public ad(int i3, String str, String str2, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, Boolean.valueOf(z16), obj);
            return;
        }
        this.f305500f = 0L;
        this.f305501g = 0L;
        this.f305495a = i3;
        this.f305496b = str;
        this.f305497c = str2;
        this.f305498d = obj;
        this.f305499e = z16;
    }
}
