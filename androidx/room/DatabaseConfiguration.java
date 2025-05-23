package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.migration.AutoMigrationSpec;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import java.io.File;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes.dex */
public class DatabaseConfiguration {
    public final boolean allowDestructiveMigrationOnDowngrade;
    public final boolean allowMainThreadQueries;

    @NonNull
    public final List<AutoMigrationSpec> autoMigrationSpecs;

    @Nullable
    public final List<RoomDatabase.Callback> callbacks;

    @NonNull
    public final Context context;

    @Nullable
    public final String copyFromAssetPath;

    @Nullable
    public final File copyFromFile;

    @Nullable
    public final Callable<InputStream> copyFromInputStream;
    public final RoomDatabase.JournalMode journalMode;
    private final Set<Integer> mMigrationNotRequiredFrom;

    @NonNull
    public final RoomDatabase.MigrationContainer migrationContainer;
    public final boolean multiInstanceInvalidation;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public final Intent multiInstanceInvalidationServiceIntent;

    @Nullable
    public final String name;

    @Nullable
    public final RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback;

    @NonNull
    public final Executor queryExecutor;
    public final boolean requireMigration;

    @NonNull
    public final SupportSQLiteOpenHelper.Factory sqliteOpenHelperFactory;

    @NonNull
    public final Executor transactionExecutor;

    @NonNull
    public final List<Object> typeConverters;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z16, RoomDatabase.JournalMode journalMode, @NonNull Executor executor, boolean z17, @Nullable Set<Integer> set) {
        this(context, str, factory, migrationContainer, list, z16, journalMode, executor, executor, false, z17, false, set, (String) null, (File) null, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<Object>) null, (List<AutoMigrationSpec>) null);
    }

    public boolean isMigrationRequired(int i3, int i16) {
        boolean z16;
        Set<Integer> set;
        if (i3 > i16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.allowDestructiveMigrationOnDowngrade) {
            return false;
        }
        if (this.requireMigration && ((set = this.mMigrationNotRequiredFrom) == null || !set.contains(Integer.valueOf(i3)))) {
            return true;
        }
        return false;
    }

    @Deprecated
    public boolean isMigrationRequiredFrom(int i3) {
        return isMigrationRequired(i3, i3 + 1);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z16, RoomDatabase.JournalMode journalMode, @NonNull Executor executor, @NonNull Executor executor2, boolean z17, boolean z18, boolean z19, @Nullable Set<Integer> set) {
        this(context, str, factory, migrationContainer, list, z16, journalMode, executor, executor2, z17, z18, z19, set, (String) null, (File) null, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<Object>) null, (List<AutoMigrationSpec>) null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z16, RoomDatabase.JournalMode journalMode, @NonNull Executor executor, @NonNull Executor executor2, boolean z17, boolean z18, boolean z19, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file) {
        this(context, str, factory, migrationContainer, list, z16, journalMode, executor, executor2, z17, z18, z19, set, str2, file, (Callable<InputStream>) null, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<Object>) null, (List<AutoMigrationSpec>) null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z16, @NonNull RoomDatabase.JournalMode journalMode, @NonNull Executor executor, @NonNull Executor executor2, boolean z17, boolean z18, boolean z19, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable) {
        this(context, str, factory, migrationContainer, list, z16, journalMode, executor, executor2, z17, z18, z19, set, str2, file, callable, (RoomDatabase.PrepackagedDatabaseCallback) null, (List<Object>) null, (List<AutoMigrationSpec>) null);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z16, @NonNull RoomDatabase.JournalMode journalMode, @NonNull Executor executor, @NonNull Executor executor2, boolean z17, boolean z18, boolean z19, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
        this(context, str, factory, migrationContainer, list, z16, journalMode, executor, executor2, z17, z18, z19, set, str2, file, callable, prepackagedDatabaseCallback, (List<Object>) null, (List<AutoMigrationSpec>) null);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z16, @NonNull RoomDatabase.JournalMode journalMode, @NonNull Executor executor, @NonNull Executor executor2, boolean z17, boolean z18, boolean z19, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @Nullable List<Object> list2) {
        this(context, str, factory, migrationContainer, list, z16, journalMode, executor, executor2, z17, z18, z19, set, str2, file, callable, prepackagedDatabaseCallback, list2, (List<AutoMigrationSpec>) null);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z16, @NonNull RoomDatabase.JournalMode journalMode, @NonNull Executor executor, @NonNull Executor executor2, boolean z17, boolean z18, boolean z19, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @Nullable List<Object> list2, @Nullable List<AutoMigrationSpec> list3) {
        this(context, str, factory, migrationContainer, list, z16, journalMode, executor, executor2, z17 ? new Intent(context, (Class<?>) MultiInstanceInvalidationService.class) : null, z18, z19, set, str2, file, callable, prepackagedDatabaseCallback, list2, list3);
    }

    @SuppressLint({"LambdaLast"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public DatabaseConfiguration(@NonNull Context context, @Nullable String str, @NonNull SupportSQLiteOpenHelper.Factory factory, @NonNull RoomDatabase.MigrationContainer migrationContainer, @Nullable List<RoomDatabase.Callback> list, boolean z16, @NonNull RoomDatabase.JournalMode journalMode, @NonNull Executor executor, @NonNull Executor executor2, @Nullable Intent intent, boolean z17, boolean z18, @Nullable Set<Integer> set, @Nullable String str2, @Nullable File file, @Nullable Callable<InputStream> callable, @Nullable RoomDatabase.PrepackagedDatabaseCallback prepackagedDatabaseCallback, @Nullable List<Object> list2, @Nullable List<AutoMigrationSpec> list3) {
        this.sqliteOpenHelperFactory = factory;
        this.context = context;
        this.name = str;
        this.migrationContainer = migrationContainer;
        this.callbacks = list;
        this.allowMainThreadQueries = z16;
        this.journalMode = journalMode;
        this.queryExecutor = executor;
        this.transactionExecutor = executor2;
        this.multiInstanceInvalidationServiceIntent = intent;
        this.multiInstanceInvalidation = intent != null;
        this.requireMigration = z17;
        this.allowDestructiveMigrationOnDowngrade = z18;
        this.mMigrationNotRequiredFrom = set;
        this.copyFromAssetPath = str2;
        this.copyFromFile = file;
        this.copyFromInputStream = callable;
        this.prepackagedDatabaseCallback = prepackagedDatabaseCallback;
        this.typeConverters = list2 == null ? Collections.emptyList() : list2;
        this.autoMigrationSpecs = list3 == null ? Collections.emptyList() : list3;
    }
}
