package com.tencent.richframework.argus.page.db;

import android.app.Application;
import android.database.sqlite.SQLiteCantOpenDatabaseException;
import android.database.sqlite.SQLiteDiskIOException;
import androidx.annotation.WorkerThread;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.delegate.impl.RFWReporter;
import com.tencent.biz.richframework.util.RFWAppUtil;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.richframework.argus.node.ArgusTag;
import com.tencent.richframework.argus.node.ArgusTagKt;
import com.tencent.richframework.argus.node.NodePO;
import com.tencent.tuxmeterqui.question.time.TuxTimeView;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b!\u0010\"J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0002J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0007JA\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00142!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0012\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00050\u0016H\u0007R\u001d\u0010 \u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/richframework/argus/page/db/PageInflateRepository;", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "", "handleDatabaseException", "Lcom/tencent/richframework/argus/node/NodePO;", "fromPage", "", "Lcom/tencent/richframework/argus/page/db/HistoryInflateRecord;", "getPageCountPastSevenDays", "getLaunchInflateRecordPastTreeDays", "", TuxTimeView.TUX_TIME_STYLE_MINUTES, "deleteRecordsBefore", "fromListPage", "getPageCountPastSevenDaysWithListPage", "Lcom/tencent/richframework/argus/page/db/PageInflateRecord;", "pageInflateRecord", "Ljava/lang/Class;", "contextClass", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "callback", "insert", "Lcom/tencent/richframework/argus/page/db/InflateRecordDao;", "inflateRecordDao$delegate", "Lkotlin/Lazy;", "getInflateRecordDao", "()Lcom/tencent/richframework/argus/page/db/InflateRecordDao;", "inflateRecordDao", "<init>", "()V", "lifecycle_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes25.dex */
public final class PageInflateRepository {

    @NotNull
    public static final PageInflateRepository INSTANCE = new PageInflateRepository();

    /* renamed from: inflateRecordDao$delegate, reason: from kotlin metadata */
    private static final Lazy inflateRecordDao;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<InflateRecordDao>() { // from class: com.tencent.richframework.argus.page.db.PageInflateRepository$inflateRecordDao$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final InflateRecordDao invoke() {
                try {
                    ArgusDatabase db5 = ArgusDatabase.getDatabase(RFWApplication.getApplication());
                    Intrinsics.checkNotNullExpressionValue(db5, "db");
                    return db5.getPageInflateDao();
                } catch (Exception e16) {
                    RFWLog.e("PageInflateRepository", RFWLog.USR, e16);
                    return null;
                }
            }
        });
        inflateRecordDao = lazy;
    }

    PageInflateRepository() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final InflateRecordDao getInflateRecordDao() {
        return (InflateRecordDao) inflateRecordDao.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDatabaseException(Exception e16) {
        RFWLog.e("PageInflateRepository", RFWLog.USR, e16);
        HashMap hashMap = new HashMap();
        hashMap.put("db_exception_type", e16.getClass().getName());
        hashMap.put("db_exception", String.valueOf(e16.getMessage()));
        Unit unit = Unit.INSTANCE;
        RFWReporter.reportCommonEvent("argus_db_error", hashMap);
        if (e16 instanceof SQLiteDiskIOException) {
            deleteRecordsBefore(0L);
        } else if (e16 instanceof SQLiteCantOpenDatabaseException) {
            RFWFileUtils.deleteDb("argus_db_release_v6");
        }
    }

    @WorkerThread
    public final void deleteRecordsBefore(long minutes) {
        try {
            long currentTimeMillis = System.currentTimeMillis() - ((minutes * 60) * 1000);
            InflateRecordDao inflateRecordDao2 = getInflateRecordDao();
            if (inflateRecordDao2 != null) {
                inflateRecordDao2.deleteRecordsOlderThan(currentTimeMillis);
            }
        } catch (Exception e16) {
            RFWLog.e("PageInflateRepository", RFWLog.USR, e16);
        }
    }

    @WorkerThread
    @NotNull
    public final List<HistoryInflateRecord> getLaunchInflateRecordPastTreeDays() {
        List<HistoryInflateRecord> emptyList;
        List<HistoryInflateRecord> emptyList2;
        List<HistoryInflateRecord> inflateCountAfterTimeForLaunch;
        try {
            long currentTimeMillis = System.currentTimeMillis() - 259200000;
            InflateRecordDao inflateRecordDao2 = getInflateRecordDao();
            if (inflateRecordDao2 == null || (inflateCountAfterTimeForLaunch = inflateRecordDao2.getInflateCountAfterTimeForLaunch(RFWAppUtil.INSTANCE.getVersionCode(), currentTimeMillis)) == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            return inflateCountAfterTimeForLaunch;
        } catch (Exception e16) {
            handleDatabaseException(e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    @WorkerThread
    @NotNull
    public final List<HistoryInflateRecord> getPageCountPastSevenDays(@Nullable NodePO fromPage) {
        List<HistoryInflateRecord> emptyList;
        List<HistoryInflateRecord> emptyList2;
        List<HistoryInflateRecord> inflateCountAfterTime;
        try {
            long currentTimeMillis = System.currentTimeMillis() - 604800000;
            InflateRecordDao inflateRecordDao2 = getInflateRecordDao();
            if (inflateRecordDao2 == null || (inflateCountAfterTime = inflateRecordDao2.getInflateCountAfterTime(RFWAppUtil.INSTANCE.getVersionCode(), fromPage, currentTimeMillis)) == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            return inflateCountAfterTime;
        } catch (Exception e16) {
            handleDatabaseException(e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    @WorkerThread
    @NotNull
    public final List<HistoryInflateRecord> getPageCountPastSevenDaysWithListPage(@Nullable NodePO fromListPage) {
        List<HistoryInflateRecord> emptyList;
        List<HistoryInflateRecord> emptyList2;
        List<HistoryInflateRecord> inflateCountAfterTimeWithListPage;
        long currentTimeMillis = System.currentTimeMillis() - 604800000;
        try {
            InflateRecordDao inflateRecordDao2 = getInflateRecordDao();
            if (inflateRecordDao2 == null || (inflateCountAfterTimeWithListPage = inflateRecordDao2.getInflateCountAfterTimeWithListPage(RFWAppUtil.INSTANCE.getVersionCode(), fromListPage, currentTimeMillis)) == null) {
                emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                return emptyList2;
            }
            return inflateCountAfterTimeWithListPage;
        } catch (Exception e16) {
            handleDatabaseException(e16);
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
    }

    @WorkerThread
    public final void insert(@NotNull final PageInflateRecord pageInflateRecord, @NotNull final Class<Object> contextClass, @NotNull final Function1<? super PageInflateRecord, Unit> callback) {
        Intrinsics.checkNotNullParameter(pageInflateRecord, "pageInflateRecord");
        Intrinsics.checkNotNullParameter(contextClass, "contextClass");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArgusDbThreadPool.INSTANCE.getInstance().execute(new Runnable() { // from class: com.tencent.richframework.argus.page.db.PageInflateRepository$insert$1
            @Override // java.lang.Runnable
            public final void run() {
                InflateRecordDao inflateRecordDao2;
                String[] tags;
                boolean contains;
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    PageInflateRecord pageInflateRecord2 = PageInflateRecord.this;
                    Application application = RFWApplication.getApplication();
                    Intrinsics.checkNotNullExpressionValue(application, "RFWApplication.getApplication()");
                    pageInflateRecord2.resName = application.getResources().getResourceName(PageInflateRecord.this.resId);
                    PageInflateRecord pageInflateRecord3 = PageInflateRecord.this;
                    if (pageInflateRecord3.itemViewLayoutId != 0) {
                        Application application2 = RFWApplication.getApplication();
                        Intrinsics.checkNotNullExpressionValue(application2, "RFWApplication.getApplication()");
                        pageInflateRecord3.itemViewResName = application2.getResources().getResourceName(PageInflateRecord.this.itemViewLayoutId);
                    }
                    ArgusTag annotationTag = ArgusTagKt.getAnnotationTag(contextClass);
                    if (annotationTag != null && (tags = annotationTag.tags()) != null) {
                        contains = ArraysKt___ArraysKt.contains(tags, "CUSTOM_CONTEXT");
                        if (contains) {
                            PageInflateRecord.this.customContextClassName = contextClass.getName();
                        }
                    }
                    inflateRecordDao2 = PageInflateRepository.INSTANCE.getInflateRecordDao();
                    if (inflateRecordDao2 != null) {
                        inflateRecordDao2.insert(PageInflateRecord.this);
                    }
                    long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                    RFWLog.d("PageInflateRepository", RFWLog.CLR, "collect inflate: resId:" + PageInflateRecord.this.resId + " resName:" + PageInflateRecord.this.resName + TokenParser.SP + "rootCls:" + PageInflateRecord.this.rootClassName + TokenParser.SP + "attach:" + PageInflateRecord.this.attachRoot + TokenParser.SP + "patchId:" + PageInflateRecord.this.patchId + TokenParser.SP + "viewType:" + PageInflateRecord.this.itemViewType + TokenParser.SP + "itemId:" + PageInflateRecord.this.itemViewLayoutId + TokenParser.SP + "itemRes:" + PageInflateRecord.this.itemViewResName + TokenParser.SP + "manager:" + PageInflateRecord.this.recyclerViewLayoutManager + TokenParser.SP + "contextClass:" + contextClass + TokenParser.SP + "cache:" + PageInflateRecord.this.isFromCache + TokenParser.SP + "cost:" + PageInflateRecord.this.costTime + " insert:" + currentTimeMillis2);
                    callback.invoke(PageInflateRecord.this);
                } catch (Exception e16) {
                    PageInflateRepository.INSTANCE.handleDatabaseException(e16);
                }
            }
        });
    }
}
