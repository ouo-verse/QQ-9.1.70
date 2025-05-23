package n;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

/* compiled from: P */
/* loaded from: classes.dex */
public interface a extends IInterface {

    /* compiled from: P */
    /* renamed from: n.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC10813a extends Binder implements a {

        /* compiled from: P */
        /* renamed from: n.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        private static class C10814a implements a {

            /* renamed from: d, reason: collision with root package name */
            private IBinder f417910d;

            C10814a(IBinder iBinder) {
                this.f417910d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f417910d;
            }
        }

        public static a j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.android.internal.telephony.ISms");
            if (queryLocalInterface != null && (queryLocalInterface instanceof a)) {
                return (a) queryLocalInterface;
            }
            return new C10814a(iBinder);
        }
    }
}
