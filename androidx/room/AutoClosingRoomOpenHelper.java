package androidx.room;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.SQLException;
import android.database.sqlite.SQLiteTransactionListener;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.arch.core.util.Function;
import androidx.room.AutoClosingRoomOpenHelper;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public final class AutoClosingRoomOpenHelper implements SupportSQLiteOpenHelper, DelegatingOpenHelper {

    @NonNull
    private final AutoCloser mAutoCloser;

    @NonNull
    private final AutoClosingSupportSQLiteDatabase mAutoClosingDb;

    @NonNull
    private final SupportSQLiteOpenHelper mDelegateOpenHelper;

    /* compiled from: P */
    /* loaded from: classes.dex */
    static final class AutoClosingSupportSQLiteDatabase implements SupportSQLiteDatabase {

        @NonNull
        private final AutoCloser mAutoCloser;

        AutoClosingSupportSQLiteDatabase(@NonNull AutoCloser autoCloser) {
            this.mAutoCloser = autoCloser;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Integer lambda$delete$5(String str, String str2, Object[] objArr, SupportSQLiteDatabase supportSQLiteDatabase) {
            return Integer.valueOf(supportSQLiteDatabase.delete(str, str2, objArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$execSQL$7(String str, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL(str);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$execSQL$8(String str, Object[] objArr, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.execSQL(str, objArr);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Long lambda$insert$4(String str, int i3, ContentValues contentValues, SupportSQLiteDatabase supportSQLiteDatabase) {
            return Long.valueOf(supportSQLiteDatabase.insert(str, i3, contentValues));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean lambda$isWriteAheadLoggingEnabled$13(SupportSQLiteDatabase supportSQLiteDatabase) {
            return Boolean.valueOf(supportSQLiteDatabase.isWriteAheadLoggingEnabled());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Boolean lambda$needUpgrade$9(int i3, SupportSQLiteDatabase supportSQLiteDatabase) {
            return Boolean.valueOf(supportSQLiteDatabase.needUpgrade(i3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$pokeOpen$0(SupportSQLiteDatabase supportSQLiteDatabase) {
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$setForeignKeyConstraintsEnabled$12(boolean z16, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setForeignKeyConstraintsEnabled(z16);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$setLocale$10(Locale locale, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setLocale(locale);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$setMaxSqlCacheSize$11(int i3, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setMaxSqlCacheSize(i3);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Long lambda$setMaximumSize$2(long j3, SupportSQLiteDatabase supportSQLiteDatabase) {
            return Long.valueOf(supportSQLiteDatabase.setMaximumSize(j3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$setPageSize$3(long j3, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setPageSize(j3);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$setVersion$1(int i3, SupportSQLiteDatabase supportSQLiteDatabase) {
            supportSQLiteDatabase.setVersion(i3);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Integer lambda$update$6(String str, int i3, ContentValues contentValues, String str2, Object[] objArr, SupportSQLiteDatabase supportSQLiteDatabase) {
            return Integer.valueOf(supportSQLiteDatabase.update(str, i3, contentValues, str2, objArr));
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransaction() {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransaction();
            } catch (Throwable th5) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th5;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionNonExclusive() {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionNonExclusive();
            } catch (Throwable th5) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th5;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListener(SQLiteTransactionListener sQLiteTransactionListener) {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListener(sQLiteTransactionListener);
            } catch (Throwable th5) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th5;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener sQLiteTransactionListener) {
            try {
                this.mAutoCloser.incrementCountAndEnsureDbIsOpen().beginTransactionWithListenerNonExclusive(sQLiteTransactionListener);
            } catch (Throwable th5) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th5;
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.mAutoCloser.closeDatabaseIfOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public SupportSQLiteStatement compileStatement(String str) {
            return new AutoClosingSupportSqliteStatement(str, this.mAutoCloser);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int delete(final String str, final String str2, final Object[] objArr) {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.g
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Integer lambda$delete$5;
                    lambda$delete$5 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$delete$5(str, str2, objArr, (SupportSQLiteDatabase) obj);
                    return lambda$delete$5;
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void disableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean enableWriteAheadLogging() {
            throw new UnsupportedOperationException("Enable/disable write ahead logging on the OpenHelper instead of on the database directly.");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void endTransaction() {
            if (this.mAutoCloser.getDelegateDatabase() != null) {
                try {
                    this.mAutoCloser.getDelegateDatabase().endTransaction();
                    return;
                } finally {
                    this.mAutoCloser.decrementCountAndScheduleClose();
                }
            }
            throw new IllegalStateException("End transaction called but delegateDb is null");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public /* synthetic */ void execPerConnectionSQL(String str, Object[] objArr) {
            androidx.sqlite.db.c.a(this, str, objArr);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(final String str) throws SQLException {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.c
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$execSQL$7;
                    lambda$execSQL$7 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$execSQL$7(str, (SupportSQLiteDatabase) obj);
                    return lambda$execSQL$7;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public List<Pair<String, String>> getAttachedDbs() {
            return (List) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.y
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteDatabase) obj).getAttachedDbs();
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getMaximumSize() {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.d
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).getMaximumSize());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long getPageSize() {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.k
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((SupportSQLiteDatabase) obj).getPageSize());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public String getPath() {
            return (String) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.n
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteDatabase) obj).getPath();
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int getVersion() {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.q
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(((SupportSQLiteDatabase) obj).getVersion());
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean inTransaction() {
            if (this.mAutoCloser.getDelegateDatabase() == null) {
                return false;
            }
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.x
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).inTransaction());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long insert(final String str, final int i3, final ContentValues contentValues) throws SQLException {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.p
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Long lambda$insert$4;
                    lambda$insert$4 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$insert$4(str, i3, contentValues, (SupportSQLiteDatabase) obj);
                    return lambda$insert$4;
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDatabaseIntegrityOk() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.e
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isDatabaseIntegrityOk());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isDbLockedByCurrentThread() {
            if (this.mAutoCloser.getDelegateDatabase() == null) {
                return false;
            }
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.s
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isDbLockedByCurrentThread());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public /* synthetic */ boolean isExecPerConnectionSQLSupported() {
            return androidx.sqlite.db.c.b(this);
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isOpen() {
            SupportSQLiteDatabase delegateDatabase = this.mAutoCloser.getDelegateDatabase();
            if (delegateDatabase == null) {
                return false;
            }
            return delegateDatabase.isOpen();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean isReadOnly() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.t
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Boolean.valueOf(((SupportSQLiteDatabase) obj).isReadOnly());
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 16)
        public boolean isWriteAheadLoggingEnabled() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.a
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean lambda$isWriteAheadLoggingEnabled$13;
                    lambda$isWriteAheadLoggingEnabled$13 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$isWriteAheadLoggingEnabled$13((SupportSQLiteDatabase) obj);
                    return lambda$isWriteAheadLoggingEnabled$13;
                }
            })).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean needUpgrade(final int i3) {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.i
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Boolean lambda$needUpgrade$9;
                    lambda$needUpgrade$9 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$needUpgrade$9(i3, (SupportSQLiteDatabase) obj);
                    return lambda$needUpgrade$9;
                }
            })).booleanValue();
        }

        void pokeOpen() {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.b
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$pokeOpen$0;
                    lambda$pokeOpen$0 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$pokeOpen$0((SupportSQLiteDatabase) obj);
                    return lambda$pokeOpen$0;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(String str) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(str), this.mAutoCloser);
            } catch (Throwable th5) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th5;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 16)
        public void setForeignKeyConstraintsEnabled(final boolean z16) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.l
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$setForeignKeyConstraintsEnabled$12;
                    lambda$setForeignKeyConstraintsEnabled$12 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setForeignKeyConstraintsEnabled$12(z16, (SupportSQLiteDatabase) obj);
                    return lambda$setForeignKeyConstraintsEnabled$12;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setLocale(final Locale locale) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.w
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$setLocale$10;
                    lambda$setLocale$10 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setLocale$10(locale, (SupportSQLiteDatabase) obj);
                    return lambda$setLocale$10;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setMaxSqlCacheSize(final int i3) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.u
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$setMaxSqlCacheSize$11;
                    lambda$setMaxSqlCacheSize$11 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setMaxSqlCacheSize$11(i3, (SupportSQLiteDatabase) obj);
                    return lambda$setMaxSqlCacheSize$11;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public long setMaximumSize(final long j3) {
            return ((Long) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.h
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Long lambda$setMaximumSize$2;
                    lambda$setMaximumSize$2 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setMaximumSize$2(j3, (SupportSQLiteDatabase) obj);
                    return lambda$setMaximumSize$2;
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setPageSize(final long j3) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.j
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$setPageSize$3;
                    lambda$setPageSize$3 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setPageSize$3(j3, (SupportSQLiteDatabase) obj);
                    return lambda$setPageSize$3;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setTransactionSuccessful() {
            SupportSQLiteDatabase delegateDatabase = this.mAutoCloser.getDelegateDatabase();
            if (delegateDatabase != null) {
                delegateDatabase.setTransactionSuccessful();
                return;
            }
            throw new IllegalStateException("setTransactionSuccessful called but delegateDb is null");
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void setVersion(final int i3) {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.f
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$setVersion$1;
                    lambda$setVersion$1 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$setVersion$1(i3, (SupportSQLiteDatabase) obj);
                    return lambda$setVersion$1;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public int update(final String str, final int i3, final ContentValues contentValues, final String str2, final Object[] objArr) {
            return ((Integer) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.v
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Integer lambda$update$6;
                    lambda$update$6 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$update$6(str, i3, contentValues, str2, objArr, (SupportSQLiteDatabase) obj);
                    return lambda$update$6;
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely() {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new o())).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public void execSQL(final String str, final Object[] objArr) throws SQLException {
            this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.m
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$execSQL$8;
                    lambda$execSQL$8 = AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.lambda$execSQL$8(str, objArr, (SupportSQLiteDatabase) obj);
                    return lambda$execSQL$8;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public boolean yieldIfContendedSafely(long j3) {
            return ((Boolean) this.mAutoCloser.executeRefCountingFunction(new o())).booleanValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(String str, Object[] objArr) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(str, objArr), this.mAutoCloser);
            } catch (Throwable th5) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th5;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        public Cursor query(SupportSQLiteQuery supportSQLiteQuery) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery), this.mAutoCloser);
            } catch (Throwable th5) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th5;
            }
        }

        @Override // androidx.sqlite.db.SupportSQLiteDatabase
        @RequiresApi(api = 24)
        public Cursor query(SupportSQLiteQuery supportSQLiteQuery, CancellationSignal cancellationSignal) {
            try {
                return new KeepAliveCursor(this.mAutoCloser.incrementCountAndEnsureDbIsOpen().query(supportSQLiteQuery, cancellationSignal), this.mAutoCloser);
            } catch (Throwable th5) {
                this.mAutoCloser.decrementCountAndScheduleClose();
                throw th5;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    private static final class KeepAliveCursor implements Cursor {
        private final AutoCloser mAutoCloser;
        private final Cursor mDelegate;

        KeepAliveCursor(Cursor cursor, AutoCloser autoCloser) {
            this.mDelegate = cursor;
            this.mAutoCloser = autoCloser;
        }

        @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.mDelegate.close();
            this.mAutoCloser.decrementCountAndScheduleClose();
        }

        @Override // android.database.Cursor
        public void copyStringToBuffer(int i3, CharArrayBuffer charArrayBuffer) {
            this.mDelegate.copyStringToBuffer(i3, charArrayBuffer);
        }

        @Override // android.database.Cursor
        @Deprecated
        public void deactivate() {
            this.mDelegate.deactivate();
        }

        @Override // android.database.Cursor
        public byte[] getBlob(int i3) {
            return this.mDelegate.getBlob(i3);
        }

        @Override // android.database.Cursor
        public int getColumnCount() {
            return this.mDelegate.getColumnCount();
        }

        @Override // android.database.Cursor
        public int getColumnIndex(String str) {
            return this.mDelegate.getColumnIndex(str);
        }

        @Override // android.database.Cursor
        public int getColumnIndexOrThrow(String str) throws IllegalArgumentException {
            return this.mDelegate.getColumnIndexOrThrow(str);
        }

        @Override // android.database.Cursor
        public String getColumnName(int i3) {
            return this.mDelegate.getColumnName(i3);
        }

        @Override // android.database.Cursor
        public String[] getColumnNames() {
            return this.mDelegate.getColumnNames();
        }

        @Override // android.database.Cursor
        public int getCount() {
            return this.mDelegate.getCount();
        }

        @Override // android.database.Cursor
        public double getDouble(int i3) {
            return this.mDelegate.getDouble(i3);
        }

        @Override // android.database.Cursor
        public Bundle getExtras() {
            return this.mDelegate.getExtras();
        }

        @Override // android.database.Cursor
        public float getFloat(int i3) {
            return this.mDelegate.getFloat(i3);
        }

        @Override // android.database.Cursor
        public int getInt(int i3) {
            return this.mDelegate.getInt(i3);
        }

        @Override // android.database.Cursor
        public long getLong(int i3) {
            return this.mDelegate.getLong(i3);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 19)
        public Uri getNotificationUri() {
            return SupportSQLiteCompat.Api19Impl.getNotificationUri(this.mDelegate);
        }

        @Override // android.database.Cursor
        @Nullable
        @RequiresApi(api = 29)
        public List<Uri> getNotificationUris() {
            return SupportSQLiteCompat.Api29Impl.getNotificationUris(this.mDelegate);
        }

        @Override // android.database.Cursor
        public int getPosition() {
            return this.mDelegate.getPosition();
        }

        @Override // android.database.Cursor
        public short getShort(int i3) {
            return this.mDelegate.getShort(i3);
        }

        @Override // android.database.Cursor
        public String getString(int i3) {
            return this.mDelegate.getString(i3);
        }

        @Override // android.database.Cursor
        public int getType(int i3) {
            return this.mDelegate.getType(i3);
        }

        @Override // android.database.Cursor
        public boolean getWantsAllOnMoveCalls() {
            return this.mDelegate.getWantsAllOnMoveCalls();
        }

        @Override // android.database.Cursor
        public boolean isAfterLast() {
            return this.mDelegate.isAfterLast();
        }

        @Override // android.database.Cursor
        public boolean isBeforeFirst() {
            return this.mDelegate.isBeforeFirst();
        }

        @Override // android.database.Cursor
        public boolean isClosed() {
            return this.mDelegate.isClosed();
        }

        @Override // android.database.Cursor
        public boolean isFirst() {
            return this.mDelegate.isFirst();
        }

        @Override // android.database.Cursor
        public boolean isLast() {
            return this.mDelegate.isLast();
        }

        @Override // android.database.Cursor
        public boolean isNull(int i3) {
            return this.mDelegate.isNull(i3);
        }

        @Override // android.database.Cursor
        public boolean move(int i3) {
            return this.mDelegate.move(i3);
        }

        @Override // android.database.Cursor
        public boolean moveToFirst() {
            return this.mDelegate.moveToFirst();
        }

        @Override // android.database.Cursor
        public boolean moveToLast() {
            return this.mDelegate.moveToLast();
        }

        @Override // android.database.Cursor
        public boolean moveToNext() {
            return this.mDelegate.moveToNext();
        }

        @Override // android.database.Cursor
        public boolean moveToPosition(int i3) {
            return this.mDelegate.moveToPosition(i3);
        }

        @Override // android.database.Cursor
        public boolean moveToPrevious() {
            return this.mDelegate.moveToPrevious();
        }

        @Override // android.database.Cursor
        public void registerContentObserver(ContentObserver contentObserver) {
            this.mDelegate.registerContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDelegate.registerDataSetObserver(dataSetObserver);
        }

        @Override // android.database.Cursor
        @Deprecated
        public boolean requery() {
            return this.mDelegate.requery();
        }

        @Override // android.database.Cursor
        public Bundle respond(Bundle bundle) {
            return this.mDelegate.respond(bundle);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 23)
        public void setExtras(Bundle bundle) {
            SupportSQLiteCompat.Api23Impl.setExtras(this.mDelegate, bundle);
        }

        @Override // android.database.Cursor
        public void setNotificationUri(ContentResolver contentResolver, Uri uri) {
            this.mDelegate.setNotificationUri(contentResolver, uri);
        }

        @Override // android.database.Cursor
        @RequiresApi(api = 29)
        public void setNotificationUris(@NonNull ContentResolver contentResolver, @NonNull List<Uri> list) {
            SupportSQLiteCompat.Api29Impl.setNotificationUris(this.mDelegate, contentResolver, list);
        }

        @Override // android.database.Cursor
        public void unregisterContentObserver(ContentObserver contentObserver) {
            this.mDelegate.unregisterContentObserver(contentObserver);
        }

        @Override // android.database.Cursor
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDelegate.unregisterDataSetObserver(dataSetObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoClosingRoomOpenHelper(@NonNull SupportSQLiteOpenHelper supportSQLiteOpenHelper, @NonNull AutoCloser autoCloser) {
        this.mDelegateOpenHelper = supportSQLiteOpenHelper;
        this.mAutoCloser = autoCloser;
        autoCloser.init(supportSQLiteOpenHelper);
        this.mAutoClosingDb = new AutoClosingSupportSQLiteDatabase(autoCloser);
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.mAutoClosingDb.close();
        } catch (IOException e16) {
            SneakyThrow.reThrow(e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public AutoCloser getAutoCloser() {
        return this.mAutoCloser;
    }

    @NonNull
    SupportSQLiteDatabase getAutoClosingDb() {
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @Nullable
    public String getDatabaseName() {
        return this.mDelegateOpenHelper.getDatabaseName();
    }

    @Override // androidx.room.DelegatingOpenHelper
    @NonNull
    public SupportSQLiteOpenHelper getDelegate() {
        return this.mDelegateOpenHelper;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NonNull
    @RequiresApi(api = 24)
    public SupportSQLiteDatabase getReadableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @NonNull
    @RequiresApi(api = 24)
    public SupportSQLiteDatabase getWritableDatabase() {
        this.mAutoClosingDb.pokeOpen();
        return this.mAutoClosingDb;
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper
    @RequiresApi(api = 16)
    public void setWriteAheadLoggingEnabled(boolean z16) {
        this.mDelegateOpenHelper.setWriteAheadLoggingEnabled(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class AutoClosingSupportSqliteStatement implements SupportSQLiteStatement {
        private final AutoCloser mAutoCloser;
        private final ArrayList<Object> mBinds = new ArrayList<>();
        private final String mSql;

        AutoClosingSupportSqliteStatement(String str, AutoCloser autoCloser) {
            this.mSql = str;
            this.mAutoCloser = autoCloser;
        }

        private void doBinds(SupportSQLiteStatement supportSQLiteStatement) {
            int i3 = 0;
            while (i3 < this.mBinds.size()) {
                int i16 = i3 + 1;
                Object obj = this.mBinds.get(i3);
                if (obj == null) {
                    supportSQLiteStatement.bindNull(i16);
                } else if (obj instanceof Long) {
                    supportSQLiteStatement.bindLong(i16, ((Long) obj).longValue());
                } else if (obj instanceof Double) {
                    supportSQLiteStatement.bindDouble(i16, ((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    supportSQLiteStatement.bindString(i16, (String) obj);
                } else if (obj instanceof byte[]) {
                    supportSQLiteStatement.bindBlob(i16, (byte[]) obj);
                }
                i3 = i16;
            }
        }

        private <T> T executeSqliteStatementWithRefCount(final Function<SupportSQLiteStatement, T> function) {
            return (T) this.mAutoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.ab
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$executeSqliteStatementWithRefCount$0;
                    lambda$executeSqliteStatementWithRefCount$0 = AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement.this.lambda$executeSqliteStatementWithRefCount$0(function, (SupportSQLiteDatabase) obj);
                    return lambda$executeSqliteStatementWithRefCount$0;
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$execute$1(SupportSQLiteStatement supportSQLiteStatement) {
            supportSQLiteStatement.execute();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Object lambda$executeSqliteStatementWithRefCount$0(Function function, SupportSQLiteDatabase supportSQLiteDatabase) {
            SupportSQLiteStatement compileStatement = supportSQLiteDatabase.compileStatement(this.mSql);
            doBinds(compileStatement);
            return function.apply(compileStatement);
        }

        private void saveBinds(int i3, Object obj) {
            int i16 = i3 - 1;
            if (i16 >= this.mBinds.size()) {
                for (int size = this.mBinds.size(); size <= i16; size++) {
                    this.mBinds.add(null);
                }
            }
            this.mBinds.set(i16, obj);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindBlob(int i3, byte[] bArr) {
            saveBinds(i3, bArr);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindDouble(int i3, double d16) {
            saveBinds(i3, Double.valueOf(d16));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindLong(int i3, long j3) {
            saveBinds(i3, Long.valueOf(j3));
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindNull(int i3) {
            saveBinds(i3, null);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void bindString(int i3, String str) {
            saveBinds(i3, str);
        }

        @Override // androidx.sqlite.db.SupportSQLiteProgram
        public void clearBindings() {
            this.mBinds.clear();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public void execute() {
            executeSqliteStatementWithRefCount(new Function() { // from class: androidx.room.ae
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$execute$1;
                    lambda$execute$1 = AutoClosingRoomOpenHelper.AutoClosingSupportSqliteStatement.lambda$execute$1((SupportSQLiteStatement) obj);
                    return lambda$execute$1;
                }
            });
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long executeInsert() {
            return ((Long) executeSqliteStatementWithRefCount(new Function() { // from class: androidx.room.ac
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((SupportSQLiteStatement) obj).executeInsert());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public int executeUpdateDelete() {
            return ((Integer) executeSqliteStatementWithRefCount(new Function() { // from class: androidx.room.z
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Integer.valueOf(((SupportSQLiteStatement) obj).executeUpdateDelete());
                }
            })).intValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public long simpleQueryForLong() {
            return ((Long) executeSqliteStatementWithRefCount(new Function() { // from class: androidx.room.ad
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return Long.valueOf(((SupportSQLiteStatement) obj).simpleQueryForLong());
                }
            })).longValue();
        }

        @Override // androidx.sqlite.db.SupportSQLiteStatement
        public String simpleQueryForString() {
            return (String) executeSqliteStatementWithRefCount(new Function() { // from class: androidx.room.aa
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return ((SupportSQLiteStatement) obj).simpleQueryForString();
                }
            });
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }
}
