package com.tencent.av.service;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface d extends IInterface {

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static abstract class a extends Binder implements d {

        /* compiled from: P */
        /* renamed from: com.tencent.av.service.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        private static class C0743a implements d {

            /* renamed from: d, reason: collision with root package name */
            private IBinder f74371d;

            C0743a(IBinder iBinder) {
                this.f74371d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f74371d;
            }
        }

        public static d j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.av.service.IAVServiceCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof d)) {
                return (d) queryLocalInterface;
            }
            return new C0743a(iBinder);
        }
    }
}
