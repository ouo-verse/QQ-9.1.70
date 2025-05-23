package b2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.hihonor.cloudservice.framework.aidl.DataBuffer;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface a extends IInterface {
    void d3(DataBuffer dataBuffer);

    /* compiled from: P */
    /* renamed from: b2.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractBinderC0086a extends Binder implements a {
        public AbstractBinderC0086a() {
            attachInterface(this, "com.hihonor.cloudservice.framework.aidl.IServiceCallback");
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) {
            DataBuffer dataBuffer;
            if (i3 != 1598968902) {
                if (i3 != 1) {
                    return super.onTransact(i3, parcel, parcel2, i16);
                }
                parcel.enforceInterface("com.hihonor.cloudservice.framework.aidl.IServiceCallback");
                if (parcel.readInt() != 0) {
                    dataBuffer = DataBuffer.CREATOR.createFromParcel(parcel);
                } else {
                    dataBuffer = null;
                }
                d3(dataBuffer);
                return true;
            }
            parcel2.writeString("com.hihonor.cloudservice.framework.aidl.IServiceCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
