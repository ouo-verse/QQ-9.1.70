package com.tencent.qimei.k;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface c extends IInterface {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static abstract class a extends Binder implements c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f343324a = 0;

        /* compiled from: P */
        /* renamed from: com.tencent.qimei.k.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        public static class C9324a implements c {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public IBinder f343325a;

            public C9324a(IBinder iBinder) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
                } else {
                    this.f343325a = iBinder;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
                }
                return this.f343325a;
            }
        }
    }
}
