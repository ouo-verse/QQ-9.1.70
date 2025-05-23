package com.tencent.richframework.argus.page.db;

import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDiskIOException;
import androidx.annotation.WorkerThread;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWReporter;
import com.tencent.biz.richframework.util.RFWAppUtil;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.richframework.argus.node.NodePO;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J\u0016\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u0007J\b\u0010\u000f\u001a\u00020\u0005H\u0007R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/richframework/argus/page/db/ListLayoutInflateRepository;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "handleDatabaseException", "Lcom/tencent/richframework/argus/node/NodePO;", "fromListPage", "", "Lcom/tencent/richframework/argus/page/db/ListHistoryInflateRecord;", "getListPageHistoryInflateRecord", "Lcom/tencent/richframework/argus/page/db/ListLayoutInflateRecord;", "records", "insertAll", "deleteAll", "Lcom/tencent/richframework/argus/page/db/ListLayoutInflateRecordDao;", "listInflateRecordDao$delegate", "Lkotlin/Lazy;", "getListInflateRecordDao", "()Lcom/tencent/richframework/argus/page/db/ListLayoutInflateRecordDao;", "listInflateRecordDao", "<init>", "()V", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class ListLayoutInflateRepository {

    @NotNull
    public static final ListLayoutInflateRepository INSTANCE = new ListLayoutInflateRepository();

    /* renamed from: listInflateRecordDao$delegate, reason: from kotlin metadata */
    private static final Lazy listInflateRecordDao;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<ListLayoutInflateRecordDao>() { // from class: com.tencent.richframework.argus.page.db.ListLayoutInflateRepository$listInflateRecordDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final ListLayoutInflateRecordDao invoke() {
                try {
                    ArgusDatabase db5 = ArgusDatabase.getDatabase(RFWApplication.getApplication());
                    Intrinsics.checkNotNullExpressionValue(db5, "db");
                    return db5.getListInflateDao();
                } catch (Exception e16) {
                    RFWLog.e("PageInflateRepository", RFWLog.USR, e16);
                    return null;
                }
            }
        });
        listInflateRecordDao = lazy;
    }

    ListLayoutInflateRepository() {
    }

    private final ListLayoutInflateRecordDao getListInflateRecordDao() {
        return (ListLayoutInflateRecordDao) listInflateRecordDao.getValue();
    }

    private final void handleDatabaseException(Exception e16) {
        RFWLog.e("PageInflateRepository", RFWLog.USR, e16);
        HashMap hashMap = new HashMap();
        hashMap.put("db_exception_type", e16.getClass().getName());
        hashMap.put("db_exception", String.valueOf(e16.getMessage()));
        Unit unit = Unit.INSTANCE;
        RFWReporter.reportCommonEvent("argus_db_error", hashMap);
        if (e16 instanceof SQLiteDiskIOException) {
            deleteAll();
        } else if (e16 instanceof SQLiteCantOpenDatabaseException) {
            RFWFileUtils.deleteDb("argus_db_release_v6");
        }
    }

    @WorkerThread
    public final void deleteAll() {
        try {
            ListLayoutInflateRecordDao listInflateRecordDao2 = getListInflateRecordDao();
            if (listInflateRecordDao2 != null) {
                listInflateRecordDao2.deleteAll();
            }
        } catch (Exception e16) {
            RFWLog.e("PageInflateRepository", RFWLog.USR, e16);
        }
    }

    @WorkerThread
    @NotNull
    public final List<ListHistoryInflateRecord> getListPageHistoryInflateRecord(@Nullable NodePO fromListPage) {
        List<ListHistoryInflateRecord> emptyList;
        List<ListHistoryInflateRecord> emptyList2;
        List<ListHistoryInflateRecord> aLlListLayoutInflateRecord;
        try {
            ListLayoutInflateRecordDao listInflateRecordDao2 = getListInflateRecordDao();
            if (listInflateRecordDao2 == null || (aLlListLayoutInflateRecord = listInflateRecordDao2.getALlListLayoutInflateRecord(RFWAppUtil.INSTANCE.getVersionCode(), fromListPage)) == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            return aLlListLayoutInflateRecord;
        } catch (Exception e16) {
            handleDatabaseException(e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    @WorkerThread
    public final void insertAll(@NotNull List<? extends ListLayoutInflateRecord> records) {
        Intrinsics.checkNotNullParameter(records, "records");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            ListLayoutInflateRecordDao listInflateRecordDao2 = getListInflateRecordDao();
            if (listInflateRecordDao2 != null) {
                listInflateRecordDao2.insertAll(records);
            }
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            RFWLog.d("PageInflateRepository", RFWLog.USR, "[insertAll] listRecords: " + records + ", timeCost: " + currentTimeMillis2 + "ms");
        } catch (Exception e16) {
            handleDatabaseException(e16);
        }
    }
}
