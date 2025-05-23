package androidx.room;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.util.Function;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.SneakyThrow;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelperFactory;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes.dex */
public abstract class RoomDatabase {
    private static final String DB_IMPL_SUFFIX = "_Impl";

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int MAX_BIND_PARAMETER_CNT = 999;
    private boolean mAllowMainThreadQueries;

    @Nullable
    private AutoCloser mAutoCloser;

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    protected List<Callback> mCallbacks;

    @Deprecated
    protected volatile SupportSQLiteDatabase mDatabase;
    private SupportSQLiteOpenHelper mOpenHelper;
    private Executor mQueryExecutor;
    private Executor mTransactionExecutor;
    boolean mWriteAheadLoggingEnabled;
    private final ReentrantReadWriteLock mCloseLock = new ReentrantReadWriteLock();
    private final ThreadLocal<Integer> mSuspendingTransactionId = new ThreadLocal<>();
    private final Map<String, Object> mBackingFieldMap = Collections.synchronizedMap(new HashMap());
    private final InvalidationTracker mInvalidationTracker = createInvalidationTracker();
    private final Map<Class<?>, Object> mTypeConverters = new HashMap();

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> mAutoMigrationSpecs = new HashMap();

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class Builder<T extends RoomDatabase> {
        private boolean mAllowDestructiveMigrationOnDowngrade;
        private boolean mAllowMainThreadQueries;
        private TimeUnit mAutoCloseTimeUnit;
        private List<AutoMigrationSpec> mAutoMigrationSpecs;
        private ArrayList<Callback> mCallbacks;
        private final Context mContext;
        private String mCopyFromAssetPath;
        private File mCopyFromFile;
        private Callable<InputStream> mCopyFromInputStream;
        private final Class<T> mDatabaseClass;
        private SupportSQLiteOpenHelper.Factory mFactory;
        private Set<Integer> mMigrationStartAndEndVersions;
        private Set<Integer> mMigrationsNotRequiredFrom;
        private Intent mMultiInstanceInvalidationIntent;
        private final String mName;
        private PrepackagedDatabaseCallback mPrepackagedDatabaseCallback;
        private QueryCallback mQueryCallback;
        private Executor mQueryCallbackExecutor;
        private Executor mQueryExecutor;
        private Executor mTransactionExecutor;
        private List<Object> mTypeConverters;
        private long mAutoCloseTimeout = -1;
        private JournalMode mJournalMode = JournalMode.AUTOMATIC;
        private boolean mRequireMigration = true;
        private final MigrationContainer mMigrationContainer = new MigrationContainer();

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(@NonNull Context context, @NonNull Class<T> cls, @Nullable String str) {
            this.mContext = context;
            this.mDatabaseClass = cls;
            this.mName = str;
        }

        @NonNull
        public Builder<T> addAutoMigrationSpec(@NonNull AutoMigrationSpec autoMigrationSpec) {
            if (this.mAutoMigrationSpecs == null) {
                this.mAutoMigrationSpecs = new ArrayList();
            }
            this.mAutoMigrationSpecs.add(autoMigrationSpec);
            return this;
        }

        @NonNull
        public Builder<T> addCallback(@NonNull Callback callback) {
            if (this.mCallbacks == null) {
                this.mCallbacks = new ArrayList<>();
            }
            this.mCallbacks.add(callback);
            return this;
        }

        @NonNull
        public Builder<T> addMigrations(@NonNull Migration... migrationArr) {
            if (this.mMigrationStartAndEndVersions == null) {
                this.mMigrationStartAndEndVersions = new HashSet();
            }
            for (Migration migration : migrationArr) {
                this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.startVersion));
                this.mMigrationStartAndEndVersions.add(Integer.valueOf(migration.endVersion));
            }
            this.mMigrationContainer.addMigrations(migrationArr);
            return this;
        }

        @NonNull
        public Builder<T> addTypeConverter(@NonNull Object obj) {
            if (this.mTypeConverters == null) {
                this.mTypeConverters = new ArrayList();
            }
            this.mTypeConverters.add(obj);
            return this;
        }

        @NonNull
        public Builder<T> allowMainThreadQueries() {
            this.mAllowMainThreadQueries = true;
            return this;
        }

        @NonNull
        @SuppressLint({"RestrictedApi"})
        public T build() {
            Executor executor;
            int i3;
            int i16;
            SupportSQLiteOpenHelper.Factory factory;
            if (this.mContext != null) {
                if (this.mDatabaseClass != null) {
                    Executor executor2 = this.mQueryExecutor;
                    if (executor2 == null && this.mTransactionExecutor == null) {
                        Executor iOThreadExecutor = ArchTaskExecutor.getIOThreadExecutor();
                        this.mTransactionExecutor = iOThreadExecutor;
                        this.mQueryExecutor = iOThreadExecutor;
                    } else if (executor2 != null && this.mTransactionExecutor == null) {
                        this.mTransactionExecutor = executor2;
                    } else if (executor2 == null && (executor = this.mTransactionExecutor) != null) {
                        this.mQueryExecutor = executor;
                    }
                    Set<Integer> set = this.mMigrationStartAndEndVersions;
                    if (set != null && this.mMigrationsNotRequiredFrom != null) {
                        for (Integer num : set) {
                            if (this.mMigrationsNotRequiredFrom.contains(num)) {
                                throw new IllegalArgumentException("Inconsistency detected. A Migration was supplied to addMigration(Migration... migrations) that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(int... startVersions). Start version: " + num);
                            }
                        }
                    }
                    SupportSQLiteOpenHelper.Factory factory2 = this.mFactory;
                    if (factory2 == null) {
                        factory2 = new FrameworkSQLiteOpenHelperFactory();
                    }
                    long j3 = this.mAutoCloseTimeout;
                    if (j3 > 0) {
                        if (this.mName != null) {
                            factory2 = new AutoClosingRoomOpenHelperFactory(factory2, new AutoCloser(j3, this.mAutoCloseTimeUnit, this.mTransactionExecutor));
                        } else {
                            throw new IllegalArgumentException("Cannot create auto-closing database for an in-memory database.");
                        }
                    }
                    String str = this.mCopyFromAssetPath;
                    if (str != null || this.mCopyFromFile != null || this.mCopyFromInputStream != null) {
                        if (this.mName != null) {
                            int i17 = 0;
                            if (str == null) {
                                i3 = 0;
                            } else {
                                i3 = 1;
                            }
                            File file = this.mCopyFromFile;
                            if (file == null) {
                                i16 = 0;
                            } else {
                                i16 = 1;
                            }
                            int i18 = i3 + i16;
                            Callable<InputStream> callable = this.mCopyFromInputStream;
                            if (callable != null) {
                                i17 = 1;
                            }
                            if (i18 + i17 == 1) {
                                factory2 = new SQLiteCopyOpenHelperFactory(str, file, callable, factory2);
                            } else {
                                throw new IllegalArgumentException("More than one of createFromAsset(), createFromInputStream(), and createFromFile() were called on this Builder, but the database can only be created using one of the three configurations.");
                            }
                        } else {
                            throw new IllegalArgumentException("Cannot create from asset or file for an in-memory database.");
                        }
                    }
                    QueryCallback queryCallback = this.mQueryCallback;
                    if (queryCallback != null) {
                        factory = new QueryInterceptorOpenHelperFactory(factory2, queryCallback, this.mQueryCallbackExecutor);
                    } else {
                        factory = factory2;
                    }
                    Context context = this.mContext;
                    DatabaseConfiguration databaseConfiguration = new DatabaseConfiguration(context, this.mName, factory, this.mMigrationContainer, this.mCallbacks, this.mAllowMainThreadQueries, this.mJournalMode.resolve(context), this.mQueryExecutor, this.mTransactionExecutor, this.mMultiInstanceInvalidationIntent, this.mRequireMigration, this.mAllowDestructiveMigrationOnDowngrade, this.mMigrationsNotRequiredFrom, this.mCopyFromAssetPath, this.mCopyFromFile, this.mCopyFromInputStream, this.mPrepackagedDatabaseCallback, this.mTypeConverters, this.mAutoMigrationSpecs);
                    T t16 = (T) Room.getGeneratedImplementation(this.mDatabaseClass, RoomDatabase.DB_IMPL_SUFFIX);
                    t16.init(databaseConfiguration);
                    return t16;
                }
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }

        @NonNull
        public Builder<T> createFromAsset(@NonNull String str) {
            this.mCopyFromAssetPath = str;
            return this;
        }

        @NonNull
        public Builder<T> createFromFile(@NonNull File file) {
            this.mCopyFromFile = file;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromInputStream(@NonNull Callable<InputStream> callable) {
            this.mCopyFromInputStream = callable;
            return this;
        }

        @NonNull
        public Builder<T> enableMultiInstanceInvalidation() {
            Intent intent;
            if (this.mName != null) {
                intent = new Intent(this.mContext, (Class<?>) MultiInstanceInvalidationService.class);
            } else {
                intent = null;
            }
            this.mMultiInstanceInvalidationIntent = intent;
            return this;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigration() {
            this.mRequireMigration = false;
            this.mAllowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigrationFrom(int... iArr) {
            if (this.mMigrationsNotRequiredFrom == null) {
                this.mMigrationsNotRequiredFrom = new HashSet(iArr.length);
            }
            for (int i3 : iArr) {
                this.mMigrationsNotRequiredFrom.add(Integer.valueOf(i3));
            }
            return this;
        }

        @NonNull
        public Builder<T> fallbackToDestructiveMigrationOnDowngrade() {
            this.mRequireMigration = true;
            this.mAllowDestructiveMigrationOnDowngrade = true;
            return this;
        }

        @NonNull
        public Builder<T> openHelperFactory(@Nullable SupportSQLiteOpenHelper.Factory factory) {
            this.mFactory = factory;
            return this;
        }

        @NonNull
        @ExperimentalRoomApi
        public Builder<T> setAutoCloseTimeout(@IntRange(from = 0) long j3, @NonNull TimeUnit timeUnit) {
            if (j3 >= 0) {
                this.mAutoCloseTimeout = j3;
                this.mAutoCloseTimeUnit = timeUnit;
                return this;
            }
            throw new IllegalArgumentException("autoCloseTimeout must be >= 0");
        }

        @NonNull
        public Builder<T> setJournalMode(@NonNull JournalMode journalMode) {
            this.mJournalMode = journalMode;
            return this;
        }

        @NonNull
        @ExperimentalRoomApi
        public Builder<T> setMultiInstanceInvalidationServiceIntent(@NonNull Intent intent) {
            if (this.mName == null) {
                intent = null;
            }
            this.mMultiInstanceInvalidationIntent = intent;
            return this;
        }

        @NonNull
        public Builder<T> setQueryCallback(@NonNull QueryCallback queryCallback, @NonNull Executor executor) {
            this.mQueryCallback = queryCallback;
            this.mQueryCallbackExecutor = executor;
            return this;
        }

        @NonNull
        public Builder<T> setQueryExecutor(@NonNull Executor executor) {
            this.mQueryExecutor = executor;
            return this;
        }

        @NonNull
        public Builder<T> setTransactionExecutor(@NonNull Executor executor) {
            this.mTransactionExecutor = executor;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle"})
        public Builder<T> createFromAsset(@NonNull String str, @NonNull PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
            this.mPrepackagedDatabaseCallback = prepackagedDatabaseCallback;
            this.mCopyFromAssetPath = str;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle", "StreamFiles"})
        public Builder<T> createFromFile(@NonNull File file, @NonNull PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
            this.mPrepackagedDatabaseCallback = prepackagedDatabaseCallback;
            this.mCopyFromFile = file;
            return this;
        }

        @NonNull
        @SuppressLint({"BuilderSetStyle", "LambdaLast"})
        public Builder<T> createFromInputStream(@NonNull Callable<InputStream> callable, @NonNull PrepackagedDatabaseCallback prepackagedDatabaseCallback) {
            this.mPrepackagedDatabaseCallback = prepackagedDatabaseCallback;
            this.mCopyFromInputStream = callable;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public enum JournalMode {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static boolean isLowRamDevice(@NonNull ActivityManager activityManager) {
            return SupportSQLiteCompat.Api19Impl.isLowRamDevice(activityManager);
        }

        JournalMode resolve(Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager != null && !isLowRamDevice(activityManager)) {
                return WRITE_AHEAD_LOGGING;
            }
            return TRUNCATE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface QueryCallback {
        void onQuery(@NonNull String str, @NonNull List<Object> list);
    }

    private void internalBeginTransaction() {
        assertNotMainThread();
        SupportSQLiteDatabase writableDatabase = this.mOpenHelper.getWritableDatabase();
        this.mInvalidationTracker.syncTriggers(writableDatabase);
        if (writableDatabase.isWriteAheadLoggingEnabled()) {
            writableDatabase.beginTransactionNonExclusive();
        } else {
            writableDatabase.beginTransaction();
        }
    }

    private void internalEndTransaction() {
        this.mOpenHelper.getWritableDatabase().endTransaction();
        if (!inTransaction()) {
            this.mInvalidationTracker.refreshVersionsAsync();
        }
    }

    private static boolean isMainThread() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$beginTransaction$0(SupportSQLiteDatabase supportSQLiteDatabase) {
        internalBeginTransaction();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$endTransaction$1(SupportSQLiteDatabase supportSQLiteDatabase) {
        internalEndTransaction();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    private <T> T unwrapOpenHelper(Class<T> cls, SupportSQLiteOpenHelper supportSQLiteOpenHelper) {
        if (cls.isInstance(supportSQLiteOpenHelper)) {
            return supportSQLiteOpenHelper;
        }
        if (supportSQLiteOpenHelper instanceof DelegatingOpenHelper) {
            return (T) unwrapOpenHelper(cls, ((DelegatingOpenHelper) supportSQLiteOpenHelper).getDelegate());
        }
        return null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void assertNotMainThread() {
        if (this.mAllowMainThreadQueries || !isMainThread()) {
        } else {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void assertNotSuspendingTransaction() {
        if (!inTransaction() && this.mSuspendingTransactionId.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void beginTransaction() {
        assertNotMainThread();
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser == null) {
            internalBeginTransaction();
        } else {
            autoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.ax
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$beginTransaction$0;
                    lambda$beginTransaction$0 = RoomDatabase.this.lambda$beginTransaction$0((SupportSQLiteDatabase) obj);
                    return lambda$beginTransaction$0;
                }
            });
        }
    }

    @WorkerThread
    public abstract void clearAllTables();

    public void close() {
        if (isOpen()) {
            ReentrantReadWriteLock.WriteLock writeLock = this.mCloseLock.writeLock();
            writeLock.lock();
            try {
                this.mInvalidationTracker.stopMultiInstanceInvalidation();
                this.mOpenHelper.close();
            } finally {
                writeLock.unlock();
            }
        }
    }

    public SupportSQLiteStatement compileStatement(@NonNull String str) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        return this.mOpenHelper.getWritableDatabase().compileStatement(str);
    }

    @NonNull
    protected abstract InvalidationTracker createInvalidationTracker();

    @NonNull
    protected abstract SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration databaseConfiguration);

    @Deprecated
    public void endTransaction() {
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser == null) {
            internalEndTransaction();
        } else {
            autoCloser.executeRefCountingFunction(new Function() { // from class: androidx.room.ay
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    Object lambda$endTransaction$1;
                    lambda$endTransaction$1 = RoomDatabase.this.lambda$endTransaction$1((SupportSQLiteDatabase) obj);
                    return lambda$endTransaction$1;
                }
            });
        }
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public List<Migration> getAutoMigrations(@NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> map) {
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Map<String, Object> getBackingFieldMap() {
        return this.mBackingFieldMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Lock getCloseLock() {
        return this.mCloseLock.readLock();
    }

    @NonNull
    public InvalidationTracker getInvalidationTracker() {
        return this.mInvalidationTracker;
    }

    @NonNull
    public SupportSQLiteOpenHelper getOpenHelper() {
        return this.mOpenHelper;
    }

    @NonNull
    public Executor getQueryExecutor() {
        return this.mQueryExecutor;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
        return Collections.emptySet();
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
        return Collections.emptyMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ThreadLocal<Integer> getSuspendingTransactionId() {
        return this.mSuspendingTransactionId;
    }

    @NonNull
    public Executor getTransactionExecutor() {
        return this.mTransactionExecutor;
    }

    @Nullable
    public <T> T getTypeConverter(@NonNull Class<T> cls) {
        return (T) this.mTypeConverters.get(cls);
    }

    public boolean inTransaction() {
        return this.mOpenHelper.getWritableDatabase().inTransaction();
    }

    @CallSuper
    public void init(@NonNull DatabaseConfiguration databaseConfiguration) {
        boolean z16;
        this.mOpenHelper = createOpenHelper(databaseConfiguration);
        Set<Class<? extends AutoMigrationSpec>> requiredAutoMigrationSpecs = getRequiredAutoMigrationSpecs();
        BitSet bitSet = new BitSet();
        Iterator<Class<? extends AutoMigrationSpec>> it = requiredAutoMigrationSpecs.iterator();
        while (true) {
            int i3 = -1;
            if (it.hasNext()) {
                Class<? extends AutoMigrationSpec> next = it.next();
                int size = databaseConfiguration.autoMigrationSpecs.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    if (next.isAssignableFrom(databaseConfiguration.autoMigrationSpecs.get(size).getClass())) {
                        bitSet.set(size);
                        i3 = size;
                        break;
                    }
                    size--;
                }
                if (i3 >= 0) {
                    this.mAutoMigrationSpecs.put(next, databaseConfiguration.autoMigrationSpecs.get(i3));
                } else {
                    throw new IllegalArgumentException("A required auto migration spec (" + next.getCanonicalName() + ") is missing in the database configuration.");
                }
            } else {
                for (int size2 = databaseConfiguration.autoMigrationSpecs.size() - 1; size2 >= 0; size2--) {
                    if (!bitSet.get(size2)) {
                        throw new IllegalArgumentException("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
                    }
                }
                Iterator<Migration> it5 = getAutoMigrations(this.mAutoMigrationSpecs).iterator();
                while (true) {
                    z16 = false;
                    if (!it5.hasNext()) {
                        break;
                    }
                    Migration next2 = it5.next();
                    if (!databaseConfiguration.migrationContainer.getMigrations().containsKey(Integer.valueOf(next2.startVersion))) {
                        databaseConfiguration.migrationContainer.addMigrations(next2);
                    }
                }
                SQLiteCopyOpenHelper sQLiteCopyOpenHelper = (SQLiteCopyOpenHelper) unwrapOpenHelper(SQLiteCopyOpenHelper.class, this.mOpenHelper);
                if (sQLiteCopyOpenHelper != null) {
                    sQLiteCopyOpenHelper.setDatabaseConfiguration(databaseConfiguration);
                }
                AutoClosingRoomOpenHelper autoClosingRoomOpenHelper = (AutoClosingRoomOpenHelper) unwrapOpenHelper(AutoClosingRoomOpenHelper.class, this.mOpenHelper);
                if (autoClosingRoomOpenHelper != null) {
                    AutoCloser autoCloser = autoClosingRoomOpenHelper.getAutoCloser();
                    this.mAutoCloser = autoCloser;
                    this.mInvalidationTracker.setAutoCloser(autoCloser);
                }
                if (databaseConfiguration.journalMode == JournalMode.WRITE_AHEAD_LOGGING) {
                    z16 = true;
                }
                this.mOpenHelper.setWriteAheadLoggingEnabled(z16);
                this.mCallbacks = databaseConfiguration.callbacks;
                this.mQueryExecutor = databaseConfiguration.queryExecutor;
                this.mTransactionExecutor = new TransactionExecutor(databaseConfiguration.transactionExecutor);
                this.mAllowMainThreadQueries = databaseConfiguration.allowMainThreadQueries;
                this.mWriteAheadLoggingEnabled = z16;
                Intent intent = databaseConfiguration.multiInstanceInvalidationServiceIntent;
                if (intent != null) {
                    this.mInvalidationTracker.startMultiInstanceInvalidation(databaseConfiguration.context, databaseConfiguration.name, intent);
                }
                Map<Class<?>, List<Class<?>>> requiredTypeConverters = getRequiredTypeConverters();
                BitSet bitSet2 = new BitSet();
                for (Map.Entry<Class<?>, List<Class<?>>> entry : requiredTypeConverters.entrySet()) {
                    Class<?> key = entry.getKey();
                    for (Class<?> cls : entry.getValue()) {
                        int size3 = databaseConfiguration.typeConverters.size() - 1;
                        while (true) {
                            if (size3 >= 0) {
                                if (cls.isAssignableFrom(databaseConfiguration.typeConverters.get(size3).getClass())) {
                                    bitSet2.set(size3);
                                    break;
                                }
                                size3--;
                            } else {
                                size3 = -1;
                                break;
                            }
                        }
                        if (size3 >= 0) {
                            this.mTypeConverters.put(cls, databaseConfiguration.typeConverters.get(size3));
                        } else {
                            throw new IllegalArgumentException("A required type converter (" + cls + ") for " + key.getCanonicalName() + " is missing in the database configuration.");
                        }
                    }
                }
                for (int size4 = databaseConfiguration.typeConverters.size() - 1; size4 >= 0; size4--) {
                    if (!bitSet2.get(size4)) {
                        throw new IllegalArgumentException("Unexpected type converter " + databaseConfiguration.typeConverters.get(size4) + ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                    }
                }
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void internalInitInvalidationTracker(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        this.mInvalidationTracker.internalInit(supportSQLiteDatabase);
    }

    public boolean isOpen() {
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser != null) {
            return autoCloser.isActive();
        }
        SupportSQLiteDatabase supportSQLiteDatabase = this.mDatabase;
        if (supportSQLiteDatabase != null && supportSQLiteDatabase.isOpen()) {
            return true;
        }
        return false;
    }

    @NonNull
    public Cursor query(@NonNull String str, @Nullable Object[] objArr) {
        return this.mOpenHelper.getWritableDatabase().query(new SimpleSQLiteQuery(str, objArr));
    }

    public void runInTransaction(@NonNull Runnable runnable) {
        beginTransaction();
        try {
            runnable.run();
            setTransactionSuccessful();
        } finally {
            endTransaction();
        }
    }

    @Deprecated
    public void setTransactionSuccessful() {
        this.mOpenHelper.getWritableDatabase().setTransactionSuccessful();
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class MigrationContainer {
        private HashMap<Integer, TreeMap<Integer, Migration>> mMigrations = new HashMap<>();

        private void addMigration(Migration migration) {
            int i3 = migration.startVersion;
            int i16 = migration.endVersion;
            TreeMap<Integer, Migration> treeMap = this.mMigrations.get(Integer.valueOf(i3));
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                this.mMigrations.put(Integer.valueOf(i3), treeMap);
            }
            Migration migration2 = treeMap.get(Integer.valueOf(i16));
            if (migration2 != null) {
                Log.w("ROOM", "Overriding migration " + migration2 + " with " + migration);
            }
            treeMap.put(Integer.valueOf(i16), migration);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private List<Migration> findUpMigrationPath(List<Migration> list, boolean z16, int i3, int i16) {
            TreeMap<Integer, Migration> treeMap;
            Set<Integer> keySet;
            boolean z17;
            do {
                if (z16) {
                    if (i3 >= i16) {
                        return list;
                    }
                    treeMap = this.mMigrations.get(Integer.valueOf(i3));
                    if (treeMap != null) {
                        return null;
                    }
                    if (z16) {
                        keySet = treeMap.descendingKeySet();
                    } else {
                        keySet = treeMap.keySet();
                    }
                    Iterator<Integer> it = keySet.iterator();
                    while (true) {
                        z17 = false;
                        if (!it.hasNext()) {
                            break;
                        }
                        int intValue = it.next().intValue();
                        if (!z16 ? !(intValue < i16 || intValue >= i3) : !(intValue > i16 || intValue <= i3)) {
                            z17 = true;
                        }
                        if (z17) {
                            list.add(treeMap.get(Integer.valueOf(intValue)));
                            i3 = intValue;
                            z17 = true;
                            break;
                        }
                    }
                } else {
                    if (i3 <= i16) {
                        return list;
                    }
                    treeMap = this.mMigrations.get(Integer.valueOf(i3));
                    if (treeMap != null) {
                    }
                }
            } while (z17);
            return null;
        }

        public void addMigrations(@NonNull Migration... migrationArr) {
            for (Migration migration : migrationArr) {
                addMigration(migration);
            }
        }

        @Nullable
        public List<Migration> findMigrationPath(int i3, int i16) {
            boolean z16;
            if (i3 == i16) {
                return Collections.emptyList();
            }
            if (i16 > i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            return findUpMigrationPath(new ArrayList(), z16, i3, i16);
        }

        @NonNull
        public Map<Integer, Map<Integer, Migration>> getMigrations() {
            return Collections.unmodifiableMap(this.mMigrations);
        }

        public void addMigrations(@NonNull List<Migration> list) {
            Iterator<Migration> it = list.iterator();
            while (it.hasNext()) {
                addMigration(it.next());
            }
        }
    }

    @NonNull
    public Cursor query(@NonNull SupportSQLiteQuery supportSQLiteQuery) {
        return query(supportSQLiteQuery, (CancellationSignal) null);
    }

    @NonNull
    public Cursor query(@NonNull SupportSQLiteQuery supportSQLiteQuery, @Nullable CancellationSignal cancellationSignal) {
        assertNotMainThread();
        assertNotSuspendingTransaction();
        if (cancellationSignal != null) {
            return this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery, cancellationSignal);
        }
        return this.mOpenHelper.getWritableDatabase().query(supportSQLiteQuery);
    }

    public <V> V runInTransaction(@NonNull Callable<V> callable) {
        beginTransaction();
        try {
            try {
                V call = callable.call();
                setTransactionSuccessful();
                return call;
            } catch (RuntimeException e16) {
                throw e16;
            } catch (Exception e17) {
                SneakyThrow.reThrow(e17);
                endTransaction();
                return null;
            }
        } finally {
            endTransaction();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class Callback {
        public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onDestructiveMigration(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }

        public void onOpen(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class PrepackagedDatabaseCallback {
        public void onOpenPrepackagedDatabase(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        }
    }
}
