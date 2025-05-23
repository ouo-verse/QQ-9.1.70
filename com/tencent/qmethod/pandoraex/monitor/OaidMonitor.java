package com.tencent.qmethod.pandoraex.monitor;

import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicReference;
import vr3.a;

/* compiled from: P */
/* loaded from: classes22.dex */
public class OaidMonitor {
    private static final String OPPO_INTERFACE_TOKEN = "com.heytap.openid.IOpenID";
    private static final String VIVO_OAID_HOST = "content://com.vivo.vms.IdProvider/IdentifierId/";
    private static final String VIVO_OAID_PATH = "OAID";
    private static HashSet<Parcel> sOppoParcelSet = new HashSet<>(256);
    private static Method sMiGetOaidMethod = null;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    static abstract class VivoOaidCall extends com.tencent.qmethod.pandoraex.core.k<Cursor> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.qmethod.pandoraex.core.k
        public abstract Cursor call();

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.tencent.qmethod.pandoraex.core.k
        public Cursor convertFrom(Object obj) {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"id", "key", "value"});
            matrixCursor.addRow(new Object[]{0, OaidMonitor.VIVO_OAID_PATH, obj});
            return matrixCursor;
        }

        @Override // com.tencent.qmethod.pandoraex.core.k
        public Object convertTo(Cursor cursor) {
            int columnIndex;
            if (cursor == null || (columnIndex = cursor.getColumnIndex("value")) < 0) {
                return "";
            }
            try {
                if (cursor.moveToNext()) {
                    return cursor.getString(columnIndex);
                }
            } finally {
                try {
                    return "";
                } finally {
                }
            }
            return "";
        }
    }

    public static boolean binderTransact(final IBinder iBinder, final int i3, final Parcel parcel, final Parcel parcel2, final int i16) throws Throwable {
        if (parcel != null && sOppoParcelSet.contains(parcel)) {
            final AtomicReference atomicReference = new AtomicReference();
            Boolean bool = (Boolean) a.C11438a.o(new com.tencent.qmethod.pandoraex.core.k<Boolean>() { // from class: com.tencent.qmethod.pandoraex.monitor.OaidMonitor.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.tencent.qmethod.pandoraex.core.k
                public Boolean call() {
                    try {
                        return Boolean.valueOf(iBinder.transact(i3, parcel, parcel2, i16));
                    } catch (RemoteException e16) {
                        atomicReference.set(e16);
                        return Boolean.FALSE;
                    }
                }
            }).f("device").c("OAID#OPPO").j(Boolean.FALSE).e();
            if (atomicReference.get() == null) {
                return bool.booleanValue();
            }
            throw ((RemoteException) atomicReference.get());
        }
        return iBinder.transact(i3, parcel, parcel2, i16);
    }

    public static Object getMIOaid(final Object obj, final Object obj2) throws Throwable {
        final Method method = sMiGetOaidMethod;
        if (method == null) {
            method = Class.forName("com.android.id.impl.IdProviderImpl").getMethod(com.tencent.luggage.wxa.q2.e.NAME, Context.class);
            sMiGetOaidMethod = method;
        }
        final AtomicReference atomicReference = new AtomicReference();
        Object e16 = a.C11438a.p(new com.tencent.qmethod.pandoraex.core.k<Object>() { // from class: com.tencent.qmethod.pandoraex.monitor.OaidMonitor.2
            @Override // com.tencent.qmethod.pandoraex.core.k
            public Object call() {
                try {
                    return method.invoke(obj, obj2);
                } catch (Throwable th5) {
                    atomicReference.set(th5);
                    return "";
                }
            }
        }).f("device").c("OAID#XIAOMI").j("").e();
        if (atomicReference.get() == null) {
            return e16;
        }
        throw ((Throwable) atomicReference.get());
    }

    public static boolean isVivoOaid(String str) {
        if (str.endsWith(VIVO_OAID_PATH) && str.startsWith(VIVO_OAID_HOST)) {
            return true;
        }
        return false;
    }

    public static void parcelRecycle(Parcel parcel) {
        parcel.recycle();
        sOppoParcelSet.remove(parcel);
    }

    public static void writeParcelToken(Parcel parcel, String str) {
        parcel.writeInterfaceToken(str);
        if (str.startsWith(OPPO_INTERFACE_TOKEN)) {
            sOppoParcelSet.add(parcel);
        }
    }
}
