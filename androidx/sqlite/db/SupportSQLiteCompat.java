package androidx.sqlite.db;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.io.File;
import java.util.List;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class SupportSQLiteCompat {

    /* compiled from: P */
    @RequiresApi(16)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static final class Api16Impl {
        Api16Impl() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void cancel(@NonNull CancellationSignal cancellationSignal) {
            cancellationSignal.cancel();
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static CancellationSignal createCancellationSignal() {
            return new CancellationSignal();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static boolean deleteDatabase(@NonNull File file) {
            return SQLiteDatabase.deleteDatabase(file);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void disableWriteAheadLogging(@NonNull SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.disableWriteAheadLogging();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static boolean isWriteAheadLoggingEnabled(@NonNull SQLiteDatabase sQLiteDatabase) {
            return sQLiteDatabase.isWriteAheadLoggingEnabled();
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Cursor rawQueryWithFactory(@NonNull SQLiteDatabase sQLiteDatabase, @NonNull String str, @NonNull String[] strArr, @NonNull String str2, @NonNull CancellationSignal cancellationSignal, @NonNull SQLiteDatabase.CursorFactory cursorFactory) {
            return sQLiteDatabase.rawQueryWithFactory(cursorFactory, str, strArr, str2, cancellationSignal);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void setForeignKeyConstraintsEnabled(@NonNull SQLiteDatabase sQLiteDatabase, boolean z16) {
            sQLiteDatabase.setForeignKeyConstraintsEnabled(z16);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void setWriteAheadLoggingEnabled(@NonNull SQLiteOpenHelper sQLiteOpenHelper, boolean z16) {
            sQLiteOpenHelper.setWriteAheadLoggingEnabled(z16);
        }
    }

    /* compiled from: P */
    @RequiresApi(19)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static final class Api19Impl {
        Api19Impl() {
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static Uri getNotificationUri(@NonNull Cursor cursor) {
            return cursor.getNotificationUri();
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static boolean isLowRamDevice(@NonNull ActivityManager activityManager) {
            return activityManager.isLowRamDevice();
        }
    }

    /* compiled from: P */
    @RequiresApi(21)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static final class Api21Impl {
        Api21Impl() {
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static File getNoBackupFilesDir(@NonNull Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    /* compiled from: P */
    @RequiresApi(23)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static final class Api23Impl {
        Api23Impl() {
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void setExtras(@NonNull Cursor cursor, @NonNull Bundle bundle) {
            cursor.setExtras(bundle);
        }
    }

    /* compiled from: P */
    @RequiresApi(29)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public static final class Api29Impl {
        Api29Impl() {
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static List<Uri> getNotificationUris(@NonNull Cursor cursor) {
            List<Uri> notificationUris;
            notificationUris = cursor.getNotificationUris();
            return notificationUris;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static void setNotificationUris(@NonNull Cursor cursor, @NonNull ContentResolver contentResolver, @NonNull List<Uri> list) {
            cursor.setNotificationUris(contentResolver, list);
        }
    }

    SupportSQLiteCompat() {
    }
}
