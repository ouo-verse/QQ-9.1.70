package com.tencent.mobileqq.activity.aio.photo;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public interface i extends IInterface {
    void a1();

    void e5(AIORichMediaData[] aIORichMediaDataArr, int i3);

    void j0(long j3, int i3, int i16, String str, String[] strArr, String str2, MessageForShortVideo messageForShortVideo, int i17, Bundle bundle);

    void notifyImageProgress(long j3, int i3, int i16, int i17, long j16, boolean z16);

    void notifyImageResult(long j3, int i3, int i16, int i17, String str, boolean z16);

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static abstract class a extends Binder implements i {

        /* JADX INFO: Access modifiers changed from: private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.activity.aio.photo.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C7134a implements i {

            /* renamed from: d, reason: collision with root package name */
            private IBinder f179749d;

            C7134a(IBinder iBinder) {
                this.f179749d = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f179749d;
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.i
            public void e5(AIORichMediaData[] aIORichMediaDataArr, int i3) {
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
                        obtain.writeTypedArray(aIORichMediaDataArr, 0);
                        obtain.writeInt(i3);
                        OaidMonitor.binderTransact(this.f179749d, 2, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProviderCallBack", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.i
            public void j0(long j3, int i3, int i16, String str, String[] strArr, String str2, MessageForShortVideo messageForShortVideo, int i17, Bundle bundle) {
                if (QLog.isColorLevel()) {
                    QLog.d("IAIOImageProviderCallBack", 2, "carverW notifyVideoUrl");
                }
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
                        obtain.writeLong(j3);
                        obtain.writeInt(i3);
                        obtain.writeInt(i16);
                        obtain.writeString(str);
                        if (strArr != null) {
                            obtain.writeInt(strArr.length);
                            for (String str3 : strArr) {
                                obtain.writeString(str3);
                            }
                        } else {
                            obtain.writeInt(-1);
                        }
                        obtain.writeString(str2);
                        obtain.writeParcelable(messageForShortVideo, 0);
                        obtain.writeInt(i17);
                        obtain.writeBundle(bundle);
                        OaidMonitor.binderTransact(this.f179749d, 5, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProviderCallBack", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.i
            public void notifyImageProgress(long j3, int i3, int i16, int i17, long j16, boolean z16) {
                int i18;
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
                        obtain.writeLong(j3);
                        obtain.writeInt(i3);
                        obtain.writeInt(i16);
                        obtain.writeInt(i17);
                        obtain.writeLong(j16);
                        if (z16) {
                            i18 = 1;
                        } else {
                            i18 = 0;
                        }
                        obtain.writeByte((byte) i18);
                        OaidMonitor.binderTransact(this.f179749d, 3, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProviderCallBack", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }

            @Override // com.tencent.mobileqq.activity.aio.photo.i
            public void notifyImageResult(long j3, int i3, int i16, int i17, String str, boolean z16) {
                int i18;
                Parcel obtain = Parcel.obtain();
                try {
                    try {
                        OaidMonitor.writeParcelToken(obtain, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
                        obtain.writeLong(j3);
                        obtain.writeInt(i3);
                        obtain.writeInt(i16);
                        obtain.writeInt(i17);
                        obtain.writeString(str);
                        if (z16) {
                            i18 = 1;
                        } else {
                            i18 = 0;
                        }
                        obtain.writeByte((byte) i18);
                        OaidMonitor.binderTransact(this.f179749d, 1, obtain, null, 1);
                    } catch (RemoteException e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e("IAIOImageProviderCallBack", 2, e16.getMessage(), e16);
                        }
                    }
                } finally {
                    OaidMonitor.parcelRecycle(obtain);
                }
            }
        }

        public a() {
            attachInterface(this, "com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
        }

        public static i j(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
            if (queryLocalInterface != null && (queryLocalInterface instanceof i)) {
                return (i) queryLocalInterface;
            }
            return new C7134a(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i3, Parcel parcel, Parcel parcel2, int i16) throws RemoteException {
            boolean z16;
            boolean z17;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            if (i3 != 5) {
                                if (i3 != 1598968902) {
                                    return super.onTransact(i3, parcel, parcel2, i16);
                                }
                                parcel2.writeString("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
                                return true;
                            }
                            if (QLog.isColorLevel()) {
                                QLog.d("IAIOImageProviderCallBack", 2, "carverW onTransact -> case TRANSACTION_notifyVideoURL");
                            }
                            parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
                            long readLong = parcel.readLong();
                            int readInt = parcel.readInt();
                            int readInt2 = parcel.readInt();
                            String readString = parcel.readString();
                            int readInt3 = parcel.readInt();
                            String[] strArr = new String[readInt3];
                            for (int i17 = 0; i17 < readInt3; i17++) {
                                strArr[i17] = parcel.readString();
                            }
                            j0(readLong, readInt, readInt2, readString, strArr, parcel.readString(), (MessageForShortVideo) parcel.readParcelable(MessageForShortVideo.class.getClassLoader()), parcel.readInt(), parcel.readBundle());
                            return true;
                        }
                        parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
                        a1();
                        return true;
                    }
                    parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
                    long readLong2 = parcel.readLong();
                    int readInt4 = parcel.readInt();
                    int readInt5 = parcel.readInt();
                    int readInt6 = parcel.readInt();
                    long readLong3 = parcel.readLong();
                    if (parcel.readByte() == 1) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    notifyImageProgress(readLong2, readInt4, readInt5, readInt6, readLong3, z17);
                    return true;
                }
                parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
                e5((AIORichMediaData[]) parcel.createTypedArray(AIORichMediaData.CREATOR), parcel.readInt());
                return true;
            }
            parcel.enforceInterface("com.tencent.mobileqq.activity.aio.photo.IAIOImageProviderCallBack");
            long readLong4 = parcel.readLong();
            int readInt7 = parcel.readInt();
            int readInt8 = parcel.readInt();
            int readInt9 = parcel.readInt();
            String readString2 = parcel.readString();
            if (parcel.readByte() != 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            notifyImageResult(readLong4, readInt7, readInt8, readInt9, readString2, z16);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
