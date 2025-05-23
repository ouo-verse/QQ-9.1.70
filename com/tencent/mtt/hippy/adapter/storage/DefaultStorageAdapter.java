package com.tencent.mtt.hippy.adapter.storage;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.text.TextUtils;
import com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DefaultStorageAdapter implements HippyStorageAdapter {
    static final int MAX_SQL_KEYS = 999;
    private Executor mExecutor;
    private ExecutorService mExecutorService;
    private final IHippySQLiteHelper mSQLiteHelper;

    public DefaultStorageAdapter(Context context) {
        this.mSQLiteHelper = new SQLiteHelper(context);
    }

    static String buildKeySelection(int i3) {
        String[] strArr = new String[i3];
        Arrays.fill(strArr, QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        return "key IN (" + TextUtils.join(", ", strArr) + ")";
    }

    static String[] buildKeySelectionArgs(HippyArray hippyArray, int i3, int i16) {
        String[] strArr = new String[i16];
        for (int i17 = 0; i17 < i16; i17++) {
            strArr[i17] = hippyArray.getString(i3 + i17);
        }
        return strArr;
    }

    private void execute(Runnable runnable) {
        if (this.mExecutor == null) {
            if (this.mExecutorService == null) {
                this.mExecutorService = ProxyExecutors.newSingleThreadExecutor();
            }
            this.mExecutor = this.mExecutorService;
        }
        if (runnable != null) {
            this.mExecutor.execute(runnable);
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter
    public void destroyIfNeed() {
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null && !executorService.isShutdown()) {
            this.mExecutorService.shutdown();
            this.mExecutorService = null;
        }
        IHippySQLiteHelper iHippySQLiteHelper = this.mSQLiteHelper;
        if (iHippySQLiteHelper != null) {
            iHippySQLiteHelper.onDestroy();
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter
    public void getAllKeys(final HippyStorageAdapter.Callback<HippyArray> callback) {
        execute(new Runnable() { // from class: com.tencent.mtt.hippy.adapter.storage.DefaultStorageAdapter.4
            /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
            
                if (r1.moveToFirst() != false) goto L9;
             */
            /* JADX WARN: Code restructure failed: missing block: B:11:0x003a, code lost:
            
                r0.pushString(r1.getString(0));
             */
            /* JADX WARN: Code restructure failed: missing block: B:12:0x0046, code lost:
            
                if (r1.moveToNext() != false) goto L28;
             */
            /* JADX WARN: Code restructure failed: missing block: B:16:0x0048, code lost:
            
                r1.close();
                r2.onSuccess(r0);
             */
            /* JADX WARN: Code restructure failed: missing block: B:17:?, code lost:
            
                return;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                try {
                    SQLiteDatabase database = DefaultStorageAdapter.this.mSQLiteHelper.getDatabase();
                    if (database == null) {
                        callback.onError("Database Error");
                        return;
                    }
                    HippyArray hippyArray = new HippyArray();
                    Cursor query = database.query(DefaultStorageAdapter.this.mSQLiteHelper.getTableName(), new String[]{"key"}, null, null, null, null, null);
                    try {
                        try {
                        } catch (Exception e16) {
                            callback.onError(e16.getMessage());
                            query.close();
                        }
                    } catch (Throwable th5) {
                        query.close();
                        throw th5;
                    }
                } catch (Throwable th6) {
                    callback.onError(th6.getMessage());
                }
            }
        });
    }

    @Override // com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter
    public void multiGet(final HippyArray hippyArray, final HippyStorageAdapter.Callback<List<HippyStorageKeyValue>> callback) {
        execute(new Runnable() { // from class: com.tencent.mtt.hippy.adapter.storage.DefaultStorageAdapter.1
            /* JADX WARN: Code restructure failed: missing block: B:21:0x008d, code lost:
            
                if (r2.moveToFirst() != false) goto L19;
             */
            /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:
            
                r3 = new com.tencent.mtt.hippy.adapter.storage.HippyStorageKeyValue();
                r3.key = r2.getString(0);
                r3.value = r2.getString(1);
                r12.put(r3.key, r3);
                r11.remove(r3.key);
             */
            /* JADX WARN: Code restructure failed: missing block: B:23:0x00af, code lost:
            
                if (r2.moveToNext() != false) goto L50;
             */
            /* JADX WARN: Code restructure failed: missing block: B:26:0x00b1, code lost:
            
                r2.close();
                r2 = r11.iterator();
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x00bc, code lost:
            
                if (r2.hasNext() == false) goto L51;
             */
            /* JADX WARN: Code restructure failed: missing block: B:29:0x00be, code lost:
            
                r3 = (java.lang.String) r2.next();
                r4 = new com.tencent.mtt.hippy.adapter.storage.HippyStorageKeyValue();
                r4.key = r3;
                r4.value = "";
                r12.put(r3, r4);
             */
            /* JADX WARN: Code restructure failed: missing block: B:31:0x00d4, code lost:
            
                r11.clear();
             */
            /* JADX WARN: Code restructure failed: missing block: B:32:0x00d7, code lost:
            
                r15 = r15 + 999;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                try {
                    SQLiteDatabase database = DefaultStorageAdapter.this.mSQLiteHelper.getDatabase();
                    if (database == null) {
                        callback.onError("Database Error");
                        return;
                    }
                    String[] strArr = {"key", "value"};
                    HashSet hashSet = new HashSet();
                    HashMap hashMap = new HashMap();
                    ArrayList arrayList = new ArrayList();
                    int i3 = 0;
                    while (i3 < hippyArray.size()) {
                        int min = Math.min(hippyArray.size() - i3, 999);
                        Cursor query = database.query(DefaultStorageAdapter.this.mSQLiteHelper.getTableName(), strArr, DefaultStorageAdapter.buildKeySelection(min), DefaultStorageAdapter.buildKeySelectionArgs(hippyArray, i3, min), null, null, null);
                        hashSet.clear();
                        try {
                            if (query.getCount() != hippyArray.size()) {
                                for (int i16 = i3; i16 < i3 + min; i16++) {
                                    hashSet.add(hippyArray.getString(i16));
                                }
                            }
                        } catch (Throwable th5) {
                            try {
                                callback.onError(th5.getMessage());
                                return;
                            } finally {
                                query.close();
                            }
                        }
                    }
                    int size = hippyArray.size();
                    for (int i17 = 0; i17 < size; i17++) {
                        arrayList.add(hashMap.get(hippyArray.getString(i17)));
                    }
                    hashMap.clear();
                    callback.onSuccess(arrayList);
                } catch (Throwable th6) {
                    callback.onError(th6.getMessage());
                }
            }
        });
    }

    @Override // com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter
    public void multiRemove(final HippyArray hippyArray, final HippyStorageAdapter.Callback<Void> callback) {
        execute(new Runnable() { // from class: com.tencent.mtt.hippy.adapter.storage.DefaultStorageAdapter.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SQLiteDatabase database = DefaultStorageAdapter.this.mSQLiteHelper.getDatabase();
                    if (database == null) {
                        callback.onError("Database Error");
                        return;
                    }
                    try {
                        database.beginTransaction();
                        for (int i3 = 0; i3 < hippyArray.size(); i3 += 999) {
                            int min = Math.min(hippyArray.size() - i3, 999);
                            database.delete(DefaultStorageAdapter.this.mSQLiteHelper.getTableName(), DefaultStorageAdapter.buildKeySelection(min), DefaultStorageAdapter.buildKeySelectionArgs(hippyArray, i3, min));
                        }
                        database.setTransactionSuccessful();
                        callback.onSuccess(null);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                } catch (Throwable th5) {
                    callback.onError(th5.getMessage());
                }
            }
        });
    }

    @Override // com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter
    public void multiSet(final List<HippyStorageKeyValue> list, final HippyStorageAdapter.Callback<Void> callback) {
        execute(new Runnable() { // from class: com.tencent.mtt.hippy.adapter.storage.DefaultStorageAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SQLiteDatabase database = DefaultStorageAdapter.this.mSQLiteHelper.getDatabase();
                    if (database == null) {
                        callback.onError("Database Error");
                        return;
                    }
                    SQLiteStatement compileStatement = database.compileStatement("INSERT OR REPLACE INTO " + DefaultStorageAdapter.this.mSQLiteHelper.getTableName() + " VALUES (?, ?);");
                    try {
                        database.beginTransaction();
                        for (HippyStorageKeyValue hippyStorageKeyValue : list) {
                            compileStatement.clearBindings();
                            compileStatement.bindString(1, hippyStorageKeyValue.key);
                            compileStatement.bindString(2, hippyStorageKeyValue.value);
                            compileStatement.execute();
                        }
                        database.setTransactionSuccessful();
                        callback.onSuccess(null);
                    } finally {
                        try {
                        } finally {
                        }
                    }
                } catch (Throwable th5) {
                    callback.onError(th5.getMessage());
                }
            }
        });
    }

    public DefaultStorageAdapter(Context context, Executor executor) {
        this.mSQLiteHelper = new SQLiteHelper(context);
        this.mExecutor = executor;
    }

    public DefaultStorageAdapter(Executor executor, IHippySQLiteHelper iHippySQLiteHelper) {
        this.mSQLiteHelper = iHippySQLiteHelper;
        this.mExecutor = executor;
    }
}
