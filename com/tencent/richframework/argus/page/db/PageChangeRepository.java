package com.tencent.richframework.argus.page.db;

import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDiskIOException;
import android.util.Log;
import androidx.annotation.WorkerThread;
import androidx.fragment.app.Argus;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWReporter;
import com.tencent.biz.richframework.util.RFWAppUtil;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.richframework.argus.node.NodePO;
import com.tencent.richframework.argus.page.PageInfoPO;
import com.tencent.tuxmeterqui.question.time.TuxTimeView;
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

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0007J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fR\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/richframework/argus/page/db/PageChangeRepository;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "handleDatabaseException", "Lcom/tencent/richframework/argus/page/PageInfoPO;", "fromPage", "", TuxTimeView.TUX_TIME_STYLE_MINUTES, "", "Lcom/tencent/richframework/argus/page/db/HistoryPageChange;", "getHistoryPageChange", "deletePageRecordBefore", "Lcom/tencent/richframework/argus/page/db/PageChangeRecord;", "pageChangeRecord", "insert", "Lcom/tencent/richframework/argus/page/db/PageChangeRecordDao;", "pageRecordDao$delegate", "Lkotlin/Lazy;", "getPageRecordDao", "()Lcom/tencent/richframework/argus/page/db/PageChangeRecordDao;", "pageRecordDao", "<init>", "()V", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class PageChangeRepository {

    @NotNull
    public static final PageChangeRepository INSTANCE = new PageChangeRepository();

    /* renamed from: pageRecordDao$delegate, reason: from kotlin metadata */
    private static final Lazy pageRecordDao;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<PageChangeRecordDao>() { // from class: com.tencent.richframework.argus.page.db.PageChangeRepository$pageRecordDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final PageChangeRecordDao invoke() {
                try {
                    ArgusDatabase db5 = ArgusDatabase.getDatabase(RFWApplication.getApplication());
                    Intrinsics.checkNotNullExpressionValue(db5, "db");
                    return db5.getPageRecordDao();
                } catch (Exception e16) {
                    RFWLog.e("PageChangeRepository", RFWLog.USR, e16);
                    return null;
                }
            }
        });
        pageRecordDao = lazy;
    }

    PageChangeRepository() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PageChangeRecordDao getPageRecordDao() {
        return (PageChangeRecordDao) pageRecordDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDatabaseException(Exception e16) {
        RFWLog.e("PageChangeRepository", RFWLog.USR, e16);
        HashMap hashMap = new HashMap();
        hashMap.put("db_exception_type", e16.getClass().getName());
        hashMap.put("db_exception", String.valueOf(e16.getMessage()));
        Unit unit = Unit.INSTANCE;
        RFWReporter.reportCommonEvent("argus_db_error", hashMap);
        if (e16 instanceof SQLiteDiskIOException) {
            deletePageRecordBefore(0L);
        } else if (e16 instanceof SQLiteCantOpenDatabaseException) {
            RFWFileUtils.deleteDb("argus_db_release_v6");
        }
    }

    @WorkerThread
    public final void deletePageRecordBefore(long minutes) {
        long currentTimeMillis = System.currentTimeMillis() - ((minutes * 60) * 1000);
        try {
            PageChangeRecordDao pageRecordDao2 = getPageRecordDao();
            if (pageRecordDao2 != null) {
                pageRecordDao2.deleteRecordsOlderThan(currentTimeMillis);
            }
        } catch (Exception e16) {
            RFWLog.e("PageChangeRepository", RFWLog.USR, e16);
        }
    }

    @WorkerThread
    @NotNull
    public final List<HistoryPageChange> getHistoryPageChange(@Nullable PageInfoPO fromPage, long minutes) {
        List<HistoryPageChange> emptyList;
        List<HistoryPageChange> emptyList2;
        List<HistoryPageChange> pageCountAfterTime;
        long currentTimeMillis = System.currentTimeMillis() - ((minutes * 60) * 1000);
        try {
            PageChangeRecordDao pageRecordDao2 = getPageRecordDao();
            if (pageRecordDao2 == null || (pageCountAfterTime = pageRecordDao2.getPageCountAfterTime(RFWAppUtil.INSTANCE.getVersionCode(), fromPage, currentTimeMillis)) == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            return pageCountAfterTime;
        } catch (Exception e16) {
            handleDatabaseException(e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    public final void insert(@NotNull final PageChangeRecord pageChangeRecord) {
        Intrinsics.checkNotNullParameter(pageChangeRecord, "pageChangeRecord");
        ArgusDbThreadPool.INSTANCE.getInstance().execute(new Runnable() { // from class: com.tencent.richframework.argus.page.db.PageChangeRepository$insert$1
            @Override // java.lang.Runnable
            public final void run() {
                PageChangeRecordDao pageRecordDao2;
                String str;
                String str2;
                String str3;
                String str4;
                String obj;
                String pageInfoPO;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (Argus.INSTANCE.isDebug()) {
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append("insert_from");
                        PageInfoPO pageInfoPO2 = PageChangeRecord.this.fromPage;
                        String str5 = "null";
                        if (pageInfoPO2 == null || (str = pageInfoPO2.toString()) == null) {
                            str = "null";
                        }
                        sb5.append(str);
                        Log.i("Argus_insertDb", sb5.toString());
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append("insert_fromGroup");
                        PageInfoPO pageInfoPO3 = PageChangeRecord.this.fromGroupPage;
                        String str6 = " null";
                        if (pageInfoPO3 == null || (str2 = pageInfoPO3.toString()) == null) {
                            str2 = " null";
                        }
                        sb6.append(str2);
                        Log.i("Argus_insertDb", sb6.toString());
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append("insert_toPage");
                        PageInfoPO pageInfoPO4 = PageChangeRecord.this.toPage;
                        if (pageInfoPO4 != null && (pageInfoPO = pageInfoPO4.toString()) != null) {
                            str6 = pageInfoPO;
                        }
                        sb7.append(str6);
                        Log.i("Argus_insertDb", sb7.toString());
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append("pending");
                        List<NodePO> list = PageChangeRecord.this.pendingBlocks;
                        if (list == null || (str3 = list.toString()) == null) {
                            str3 = "null";
                        }
                        sb8.append(str3);
                        Log.i("Argus_insertDb", sb8.toString());
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append("firstShow");
                        List<NodePO> list2 = PageChangeRecord.this.firstShowBlocks;
                        if (list2 == null || (str4 = list2.toString()) == null) {
                            str4 = "null";
                        }
                        sb9.append(str4);
                        Log.i("Argus_insertDb", sb9.toString());
                        StringBuilder sb10 = new StringBuilder();
                        sb10.append("add");
                        List<NodePO> list3 = PageChangeRecord.this.addBlocks;
                        if (list3 != null && (obj = list3.toString()) != null) {
                            str5 = obj;
                        }
                        sb10.append(str5);
                        Log.i("Argus_insertDb", sb10.toString());
                    }
                    pageRecordDao2 = PageChangeRepository.INSTANCE.getPageRecordDao();
                    if (pageRecordDao2 != null) {
                        pageRecordDao2.insert(PageChangeRecord.this);
                    }
                    Log.d("PageChangeRepository", "[insert] pageChangeRecord: " + PageChangeRecord.this + ", timeCost: " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                } catch (Exception e16) {
                    PageChangeRepository.INSTANCE.handleDatabaseException(e16);
                }
            }
        });
    }
}
