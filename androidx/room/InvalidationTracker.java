package androidx.room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.LiveData;
import androidx.sqlite.db.SimpleSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.consts.QzoneDataUpdateAction;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;

/* compiled from: P */
/* loaded from: classes.dex */
public class InvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE room_table_modification_log(table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";

    @VisibleForTesting
    static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1 ";

    @VisibleForTesting
    static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1;";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String[] TRIGGERS = {QzoneDataUpdateAction.UPDATE, "DELETE", "INSERT"};
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";

    @Nullable
    AutoCloser mAutoCloser;
    volatile SupportSQLiteStatement mCleanupStatement;
    final RoomDatabase mDatabase;
    private volatile boolean mInitialized;
    private final InvalidationLiveDataContainer mInvalidationLiveDataContainer;
    private MultiInstanceInvalidationClient mMultiInstanceInvalidationClient;
    private final ObservedTableTracker mObservedTableTracker;

    @SuppressLint({"RestrictedApi"})
    @VisibleForTesting
    final SafeIterableMap<Observer, ObserverWrapper> mObserverMap;
    AtomicBoolean mPendingRefresh;

    @VisibleForTesting
    Runnable mRefreshRunnable;
    private final Object mSyncTriggersLock;

    @NonNull
    final HashMap<String, Integer> mTableIdLookup;
    final String[] mTableNames;

    @NonNull
    private Map<String, Set<String>> mViewTables;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ObservedTableTracker {
        static final int ADD = 1;
        static final int NO_OP = 0;
        static final int REMOVE = 2;
        boolean mNeedsSync;
        final long[] mTableObservers;
        final int[] mTriggerStateChanges;
        final boolean[] mTriggerStates;

        ObservedTableTracker(int i3) {
            long[] jArr = new long[i3];
            this.mTableObservers = jArr;
            boolean[] zArr = new boolean[i3];
            this.mTriggerStates = zArr;
            this.mTriggerStateChanges = new int[i3];
            Arrays.fill(jArr, 0L);
            Arrays.fill(zArr, false);
        }

        @Nullable
        int[] getTablesToSync() {
            boolean z16;
            synchronized (this) {
                if (!this.mNeedsSync) {
                    return null;
                }
                int length = this.mTableObservers.length;
                for (int i3 = 0; i3 < length; i3++) {
                    int i16 = 1;
                    if (this.mTableObservers[i3] > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    boolean[] zArr = this.mTriggerStates;
                    if (z16 != zArr[i3]) {
                        int[] iArr = this.mTriggerStateChanges;
                        if (!z16) {
                            i16 = 2;
                        }
                        iArr[i3] = i16;
                    } else {
                        this.mTriggerStateChanges[i3] = 0;
                    }
                    zArr[i3] = z16;
                }
                this.mNeedsSync = false;
                return (int[]) this.mTriggerStateChanges.clone();
            }
        }

        boolean onAdded(int... iArr) {
            boolean z16;
            synchronized (this) {
                z16 = false;
                for (int i3 : iArr) {
                    long[] jArr = this.mTableObservers;
                    long j3 = jArr[i3];
                    jArr[i3] = 1 + j3;
                    if (j3 == 0) {
                        z16 = true;
                        this.mNeedsSync = true;
                    }
                }
            }
            return z16;
        }

        boolean onRemoved(int... iArr) {
            boolean z16;
            synchronized (this) {
                z16 = false;
                for (int i3 : iArr) {
                    long[] jArr = this.mTableObservers;
                    long j3 = jArr[i3];
                    jArr[i3] = j3 - 1;
                    if (j3 == 1) {
                        z16 = true;
                        this.mNeedsSync = true;
                    }
                }
            }
            return z16;
        }

        void resetTriggerState() {
            synchronized (this) {
                Arrays.fill(this.mTriggerStates, false);
                this.mNeedsSync = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class ObserverWrapper {
        final Observer mObserver;
        private final Set<String> mSingleTableSet;
        final int[] mTableIds;
        private final String[] mTableNames;

        ObserverWrapper(Observer observer, int[] iArr, String[] strArr) {
            this.mObserver = observer;
            this.mTableIds = iArr;
            this.mTableNames = strArr;
            if (iArr.length == 1) {
                HashSet hashSet = new HashSet();
                hashSet.add(strArr[0]);
                this.mSingleTableSet = Collections.unmodifiableSet(hashSet);
                return;
            }
            this.mSingleTableSet = null;
        }

        void notifyByTableInvalidStatus(Set<Integer> set) {
            int length = this.mTableIds.length;
            Set<String> set2 = null;
            for (int i3 = 0; i3 < length; i3++) {
                if (set.contains(Integer.valueOf(this.mTableIds[i3]))) {
                    if (length == 1) {
                        set2 = this.mSingleTableSet;
                    } else {
                        if (set2 == null) {
                            set2 = new HashSet<>(length);
                        }
                        set2.add(this.mTableNames[i3]);
                    }
                }
            }
            if (set2 != null) {
                this.mObserver.onInvalidated(set2);
            }
        }

        void notifyByTableNames(String[] strArr) {
            Set<String> set = null;
            if (this.mTableNames.length == 1) {
                int length = strArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (strArr[i3].equalsIgnoreCase(this.mTableNames[0])) {
                        set = this.mSingleTableSet;
                        break;
                    }
                    i3++;
                }
            } else {
                HashSet hashSet = new HashSet();
                for (String str : strArr) {
                    String[] strArr2 = this.mTableNames;
                    int length2 = strArr2.length;
                    int i16 = 0;
                    while (true) {
                        if (i16 < length2) {
                            String str2 = strArr2[i16];
                            if (str2.equalsIgnoreCase(str)) {
                                hashSet.add(str2);
                                break;
                            }
                            i16++;
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    set = hashSet;
                }
            }
            if (set != null) {
                this.mObserver.onInvalidated(set);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    static class WeakObserver extends Observer {
        final WeakReference<Observer> mDelegateRef;
        final InvalidationTracker mTracker;

        WeakObserver(InvalidationTracker invalidationTracker, Observer observer) {
            super(observer.mTables);
            this.mTracker = invalidationTracker;
            this.mDelegateRef = new WeakReference<>(observer);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@NonNull Set<String> set) {
            Observer observer = this.mDelegateRef.get();
            if (observer == null) {
                this.mTracker.removeObserver(this);
            } else {
                observer.onInvalidated(set);
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, String... strArr) {
        this(roomDatabase, new HashMap(), Collections.emptyMap(), strArr);
    }

    private static void appendTriggerName(StringBuilder sb5, String str, String str2) {
        sb5.append("`");
        sb5.append("room_table_modification_trigger_");
        sb5.append(str);
        sb5.append("_");
        sb5.append(str2);
        sb5.append("`");
    }

    private static void beginTransactionInternal(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (supportSQLiteDatabase.isWriteAheadLoggingEnabled()) {
            supportSQLiteDatabase.beginTransactionNonExclusive();
        } else {
            supportSQLiteDatabase.beginTransaction();
        }
    }

    private String[] resolveViews(String[] strArr) {
        HashSet hashSet = new HashSet();
        for (String str : strArr) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (this.mViewTables.containsKey(lowerCase)) {
                hashSet.addAll(this.mViewTables.get(lowerCase));
            } else {
                hashSet.add(str);
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    private void startTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i3) {
        supportSQLiteDatabase.execSQL("INSERT OR IGNORE INTO room_table_modification_log VALUES(" + i3 + ", 0)");
        String str = this.mTableNames[i3];
        StringBuilder sb5 = new StringBuilder();
        for (String str2 : TRIGGERS) {
            sb5.setLength(0);
            sb5.append("CREATE TEMP TRIGGER IF NOT EXISTS ");
            appendTriggerName(sb5, str, str2);
            sb5.append(" AFTER ");
            sb5.append(str2);
            sb5.append(" ON `");
            sb5.append(str);
            sb5.append("` BEGIN UPDATE ");
            sb5.append(UPDATE_TABLE_NAME);
            sb5.append(" SET ");
            sb5.append(INVALIDATED_COLUMN_NAME);
            sb5.append(" = 1");
            sb5.append(" WHERE ");
            sb5.append(TABLE_ID_COLUMN_NAME);
            sb5.append(" = ");
            sb5.append(i3);
            sb5.append(" AND ");
            sb5.append(INVALIDATED_COLUMN_NAME);
            sb5.append(" = 0");
            sb5.append("; END");
            supportSQLiteDatabase.execSQL(sb5.toString());
        }
    }

    private void stopTrackingTable(SupportSQLiteDatabase supportSQLiteDatabase, int i3) {
        String str = this.mTableNames[i3];
        StringBuilder sb5 = new StringBuilder();
        for (String str2 : TRIGGERS) {
            sb5.setLength(0);
            sb5.append("DROP TRIGGER IF EXISTS ");
            appendTriggerName(sb5, str, str2);
            supportSQLiteDatabase.execSQL(sb5.toString());
        }
    }

    private String[] validateAndResolveTableNames(String[] strArr) {
        String[] resolveViews = resolveViews(strArr);
        for (String str : resolveViews) {
            if (!this.mTableIdLookup.containsKey(str.toLowerCase(Locale.US))) {
                throw new IllegalArgumentException("There is no table with name " + str);
            }
        }
        return resolveViews;
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void addObserver(@NonNull Observer observer) {
        ObserverWrapper putIfAbsent;
        String[] resolveViews = resolveViews(observer.mTables);
        int[] iArr = new int[resolveViews.length];
        int length = resolveViews.length;
        for (int i3 = 0; i3 < length; i3++) {
            Integer num = this.mTableIdLookup.get(resolveViews[i3].toLowerCase(Locale.US));
            if (num != null) {
                iArr[i3] = num.intValue();
            } else {
                throw new IllegalArgumentException("There is no table with name " + resolveViews[i3]);
            }
        }
        ObserverWrapper observerWrapper = new ObserverWrapper(observer, iArr, resolveViews);
        synchronized (this.mObserverMap) {
            putIfAbsent = this.mObserverMap.putIfAbsent(observer, observerWrapper);
        }
        if (putIfAbsent == null && this.mObservedTableTracker.onAdded(iArr)) {
            syncTriggers();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addWeakObserver(Observer observer) {
        addObserver(new WeakObserver(this, observer));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Deprecated
    public <T> LiveData<T> createLiveData(String[] strArr, Callable<T> callable) {
        return createLiveData(strArr, false, callable);
    }

    boolean ensureInitialization() {
        if (!this.mDatabase.isOpen()) {
            return false;
        }
        if (!this.mInitialized) {
            this.mDatabase.getOpenHelper().getWritableDatabase();
        }
        if (!this.mInitialized) {
            Log.e("ROOM", "database is not initialized even though it is open");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void internalInit(SupportSQLiteDatabase supportSQLiteDatabase) {
        synchronized (this) {
            if (this.mInitialized) {
                Log.e("ROOM", "Invalidation tracker is initialized twice :/.");
                return;
            }
            supportSQLiteDatabase.execSQL("PRAGMA temp_store = MEMORY;");
            supportSQLiteDatabase.execSQL("PRAGMA recursive_triggers='ON';");
            supportSQLiteDatabase.execSQL(CREATE_TRACKING_TABLE_SQL);
            syncTriggers(supportSQLiteDatabase);
            this.mCleanupStatement = supportSQLiteDatabase.compileStatement(RESET_UPDATED_TABLES_SQL);
            this.mInitialized = true;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @VisibleForTesting(otherwise = 3)
    public void notifyObserversByTableNames(String... strArr) {
        synchronized (this.mObserverMap) {
            Iterator<Map.Entry<Observer, ObserverWrapper>> it = this.mObserverMap.iterator();
            while (it.hasNext()) {
                Map.Entry<Observer, ObserverWrapper> next = it.next();
                if (!next.getKey().isRemote()) {
                    next.getValue().notifyByTableNames(strArr);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAutoCloseCallback() {
        synchronized (this) {
            this.mInitialized = false;
            this.mObservedTableTracker.resetTriggerState();
        }
    }

    public void refreshVersionsAsync() {
        if (this.mPendingRefresh.compareAndSet(false, true)) {
            AutoCloser autoCloser = this.mAutoCloser;
            if (autoCloser != null) {
                autoCloser.incrementCountAndEnsureDbIsOpen();
            }
            this.mDatabase.getQueryExecutor().execute(this.mRefreshRunnable);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @WorkerThread
    public void refreshVersionsSync() {
        AutoCloser autoCloser = this.mAutoCloser;
        if (autoCloser != null) {
            autoCloser.incrementCountAndEnsureDbIsOpen();
        }
        syncTriggers();
        this.mRefreshRunnable.run();
    }

    @SuppressLint({"RestrictedApi"})
    @WorkerThread
    public void removeObserver(@NonNull Observer observer) {
        ObserverWrapper remove;
        synchronized (this.mObserverMap) {
            remove = this.mObserverMap.remove(observer);
        }
        if (remove != null && this.mObservedTableTracker.onRemoved(remove.mTableIds)) {
            syncTriggers();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAutoCloser(AutoCloser autoCloser) {
        this.mAutoCloser = autoCloser;
        autoCloser.setAutoCloseCallback(new Runnable() { // from class: androidx.room.af
            @Override // java.lang.Runnable
            public final void run() {
                InvalidationTracker.this.onAutoCloseCallback();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startMultiInstanceInvalidation(Context context, String str, Intent intent) {
        this.mMultiInstanceInvalidationClient = new MultiInstanceInvalidationClient(context, str, intent, this, this.mDatabase.getQueryExecutor());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopMultiInstanceInvalidation() {
        MultiInstanceInvalidationClient multiInstanceInvalidationClient = this.mMultiInstanceInvalidationClient;
        if (multiInstanceInvalidationClient != null) {
            multiInstanceInvalidationClient.stop();
            this.mMultiInstanceInvalidationClient = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void syncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        if (supportSQLiteDatabase.inTransaction()) {
            return;
        }
        try {
            Lock closeLock = this.mDatabase.getCloseLock();
            closeLock.lock();
            try {
                synchronized (this.mSyncTriggersLock) {
                    int[] tablesToSync = this.mObservedTableTracker.getTablesToSync();
                    if (tablesToSync == null) {
                        return;
                    }
                    int length = tablesToSync.length;
                    beginTransactionInternal(supportSQLiteDatabase);
                    for (int i3 = 0; i3 < length; i3++) {
                        try {
                            int i16 = tablesToSync[i3];
                            if (i16 == 1) {
                                startTrackingTable(supportSQLiteDatabase, i3);
                            } else if (i16 == 2) {
                                stopTrackingTable(supportSQLiteDatabase, i3);
                            }
                        } finally {
                            supportSQLiteDatabase.endTransaction();
                        }
                    }
                    supportSQLiteDatabase.setTransactionSuccessful();
                }
            } finally {
                closeLock.unlock();
            }
        } catch (SQLiteException | IllegalStateException e16) {
            Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e16);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public InvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, Set<String>> map2, String... strArr) {
        this.mAutoCloser = null;
        this.mPendingRefresh = new AtomicBoolean(false);
        this.mInitialized = false;
        this.mObserverMap = new SafeIterableMap<>();
        this.mSyncTriggersLock = new Object();
        this.mRefreshRunnable = new Runnable() { // from class: androidx.room.InvalidationTracker.1
            private Set<Integer> checkUpdatedTable() {
                HashSet hashSet = new HashSet();
                Cursor query = InvalidationTracker.this.mDatabase.query(new SimpleSQLiteQuery(InvalidationTracker.SELECT_UPDATED_TABLES_SQL));
                while (query.moveToNext()) {
                    try {
                        hashSet.add(Integer.valueOf(query.getInt(0)));
                    } catch (Throwable th5) {
                        query.close();
                        throw th5;
                    }
                }
                query.close();
                if (!hashSet.isEmpty()) {
                    InvalidationTracker.this.mCleanupStatement.executeUpdateDelete();
                }
                return hashSet;
            }

            /* JADX WARN: Code restructure failed: missing block: B:30:0x0071, code lost:
            
                if (r0 != null) goto L26;
             */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x0073, code lost:
            
                r0.decrementCountAndScheduleClose();
             */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x0094, code lost:
            
                if (r1 == null) goto L53;
             */
            /* JADX WARN: Code restructure failed: missing block: B:34:0x009a, code lost:
            
                if (r1.isEmpty() != false) goto L67;
             */
            /* JADX WARN: Code restructure failed: missing block: B:35:0x009c, code lost:
            
                r0 = r5.this$0.mObserverMap;
             */
            /* JADX WARN: Code restructure failed: missing block: B:36:0x00a0, code lost:
            
                monitor-enter(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:38:0x00a1, code lost:
            
                r2 = r5.this$0.mObserverMap.iterator();
             */
            /* JADX WARN: Code restructure failed: missing block: B:40:0x00ad, code lost:
            
                if (r2.hasNext() == false) goto L63;
             */
            /* JADX WARN: Code restructure failed: missing block: B:41:0x00af, code lost:
            
                r2.next().getValue().notifyByTableInvalidStatus(r1);
             */
            /* JADX WARN: Code restructure failed: missing block: B:43:0x00bf, code lost:
            
                monitor-exit(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:45:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:50:?, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:51:0x00c4, code lost:
            
                return;
             */
            /* JADX WARN: Code restructure failed: missing block: B:64:0x0091, code lost:
            
                if (r0 == null) goto L39;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                AutoCloser autoCloser;
                AutoCloser autoCloser2;
                Lock closeLock = InvalidationTracker.this.mDatabase.getCloseLock();
                closeLock.lock();
                Set<Integer> set = null;
                try {
                    try {
                        if (!InvalidationTracker.this.ensureInitialization()) {
                            if (autoCloser2 != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                        if (!InvalidationTracker.this.mPendingRefresh.compareAndSet(true, false)) {
                            closeLock.unlock();
                            AutoCloser autoCloser3 = InvalidationTracker.this.mAutoCloser;
                            if (autoCloser3 != null) {
                                autoCloser3.decrementCountAndScheduleClose();
                                return;
                            }
                            return;
                        }
                        if (InvalidationTracker.this.mDatabase.inTransaction()) {
                            closeLock.unlock();
                            AutoCloser autoCloser4 = InvalidationTracker.this.mAutoCloser;
                            if (autoCloser4 != null) {
                                autoCloser4.decrementCountAndScheduleClose();
                                return;
                            }
                            return;
                        }
                        SupportSQLiteDatabase writableDatabase = InvalidationTracker.this.mDatabase.getOpenHelper().getWritableDatabase();
                        writableDatabase.beginTransactionNonExclusive();
                        try {
                            set = checkUpdatedTable();
                            writableDatabase.setTransactionSuccessful();
                            closeLock.unlock();
                            autoCloser = InvalidationTracker.this.mAutoCloser;
                        } finally {
                            writableDatabase.endTransaction();
                        }
                    } catch (SQLiteException | IllegalStateException e16) {
                        Log.e("ROOM", "Cannot run invalidation tracker. Is the db closed?", e16);
                        closeLock.unlock();
                        autoCloser = InvalidationTracker.this.mAutoCloser;
                    }
                } finally {
                    closeLock.unlock();
                    autoCloser2 = InvalidationTracker.this.mAutoCloser;
                    if (autoCloser2 != null) {
                        autoCloser2.decrementCountAndScheduleClose();
                    }
                }
            }
        };
        this.mDatabase = roomDatabase;
        this.mObservedTableTracker = new ObservedTableTracker(strArr.length);
        this.mTableIdLookup = new HashMap<>();
        this.mViewTables = map2;
        this.mInvalidationLiveDataContainer = new InvalidationLiveDataContainer(roomDatabase);
        int length = strArr.length;
        this.mTableNames = new String[length];
        for (int i3 = 0; i3 < length; i3++) {
            String str = strArr[i3];
            Locale locale = Locale.US;
            String lowerCase = str.toLowerCase(locale);
            this.mTableIdLookup.put(lowerCase, Integer.valueOf(i3));
            String str2 = map.get(strArr[i3]);
            if (str2 != null) {
                this.mTableNames[i3] = str2.toLowerCase(locale);
            } else {
                this.mTableNames[i3] = lowerCase;
            }
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String value = entry.getValue();
            Locale locale2 = Locale.US;
            String lowerCase2 = value.toLowerCase(locale2);
            if (this.mTableIdLookup.containsKey(lowerCase2)) {
                String lowerCase3 = entry.getKey().toLowerCase(locale2);
                HashMap<String, Integer> hashMap = this.mTableIdLookup;
                hashMap.put(lowerCase3, hashMap.get(lowerCase2));
            }
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public <T> LiveData<T> createLiveData(String[] strArr, boolean z16, Callable<T> callable) {
        return this.mInvalidationLiveDataContainer.create(validateAndResolveTableNames(strArr), z16, callable);
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static abstract class Observer {
        final String[] mTables;

        protected Observer(@NonNull String str, String... strArr) {
            String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 1);
            this.mTables = strArr2;
            strArr2[strArr.length] = str;
        }

        boolean isRemote() {
            return false;
        }

        public abstract void onInvalidated(@NonNull Set<String> set);

        public Observer(@NonNull String[] strArr) {
            this.mTables = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
    }

    void syncTriggers() {
        if (this.mDatabase.isOpen()) {
            syncTriggers(this.mDatabase.getOpenHelper().getWritableDatabase());
        }
    }
}
