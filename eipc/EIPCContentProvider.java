package eipc;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qmethod.pandoraex.monitor.ContactsMonitor;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppContentProvider;
import mqq.app.MobileQQ;

/* loaded from: classes28.dex */
public class EIPCContentProvider extends AppContentProvider {
    public static final String AUTHORITY;
    public static final String COL_SERVICE = "service";
    public static final Uri CONTENT_URI;
    public static boolean sIsDexInjectFinish;

    /* loaded from: classes28.dex */
    private static class EIPCBinderCursor extends MatrixCursor {
        public static final String KEY_BINDER = "EIPCBinderCursor";
        Bundle mBinderExtra;

        public EIPCBinderCursor(String[] strArr, IBinder iBinder) {
            super(strArr);
            this.mBinderExtra = new Bundle();
            if (iBinder != null) {
                this.mBinderExtra.putParcelable(KEY_BINDER, new BinderParcelable(iBinder));
            }
        }

        @Override // android.database.AbstractCursor, android.database.Cursor
        public Bundle getExtras() {
            return this.mBinderExtra;
        }

        /* loaded from: classes28.dex */
        public static class BinderParcelable implements Parcelable {
            public static final Parcelable.Creator<BinderParcelable> CREATOR = new Parcelable.Creator<BinderParcelable>() { // from class: eipc.EIPCContentProvider.EIPCBinderCursor.BinderParcelable.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public BinderParcelable createFromParcel(Parcel parcel) {
                    return new BinderParcelable(parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public BinderParcelable[] newArray(int i3) {
                    return new BinderParcelable[i3];
                }
            };
            public IBinder mBinder;

            BinderParcelable(IBinder iBinder) {
                this.mBinder = iBinder;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i3) {
                parcel.writeStrongBinder(this.mBinder);
            }

            BinderParcelable(Parcel parcel) {
                this.mBinder = parcel.readStrongBinder();
            }
        }
    }

    static {
        String str = MobileQQ.PACKAGE_NAME + ".eipcmobileqq";
        AUTHORITY = str;
        CONTENT_URI = Uri.parse("content://" + str + "/binder");
        sIsDexInjectFinish = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0052 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static IBinder queryBinder(Context context) {
        Throwable th5;
        Cursor cursor;
        IBinder iBinder = null;
        try {
            try {
                cursor = ContactsMonitor.query(context.getContentResolver(), CONTENT_URI, null, null, new String[]{"service"}, null);
            } catch (Exception e16) {
                e = e16;
                cursor = null;
            } catch (Throwable th6) {
                th5 = th6;
                cursor = null;
                if (cursor != null) {
                }
                throw th5;
            }
        } catch (Exception e17) {
            QLog.e(EIPCConst.TAG, 1, "connectProvider ", e17);
        }
        try {
            try {
                Bundle extras = cursor.getExtras();
                extras.setClassLoader(EIPCBinderCursor.BinderParcelable.class.getClassLoader());
                iBinder = ((EIPCBinderCursor.BinderParcelable) extras.getParcelable(EIPCBinderCursor.KEY_BINDER)).mBinder;
                cursor.close();
            } catch (Throwable th7) {
                th5 = th7;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception e18) {
                        QLog.e(EIPCConst.TAG, 1, "connectProvider ", e18);
                    }
                }
                throw th5;
            }
        } catch (Exception e19) {
            e = e19;
            QLog.e(EIPCConst.TAG, 1, "connectProvider ", e);
            if (cursor != null) {
                cursor.close();
            }
            return iBinder;
        }
        return iBinder;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (sIsDexInjectFinish) {
            MobileQQ.sMobileQQ.waitAppRuntime();
        }
        return new EIPCBinderCursor(new String[]{"service"}, (IBinder) EIPCServer.getServer().channel);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
