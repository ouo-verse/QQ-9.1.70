package com.tencent.mobileqq.zootopia.download.normal;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.z1.download.FileDownloadParams;
import com.tencent.mobileqq.z1.download.ZPlanFileCategory;
import com.tencent.mobileqq.zootopia.download.BaseDownloadTask;
import com.tencent.mobileqq.zootopia.download.ah;
import com.tencent.mobileqq.zootopia.download.v;
import com.tencent.mobileqq.zootopia.download.x;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009b\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007*\u0001R\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bV\u0010WJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006J\u001c\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nJ\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\nJ \u0010\u0015\u001a\u00020\u00042\u0018\u0010\u0007\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0004\u0012\u00020\u00040\u0012J\u001c\u0010\u0016\u001a\u00020\u00042\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00040\u0012J,\u0010\u0017\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u00040\u0012J8\u0010\u001a\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00132\u001a\u0010\u0007\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0019\u0012\u0004\u0012\u00020\u00040\u0012J\u001e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\nJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010 \u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dJ\u0014\u0010\"\u001a\u00020\u00042\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\n0\u0013J\"\u0010'\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\n2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020%0\u0012J;\u0010/\u001a\u00020\u00042\u0006\u0010)\u001a\u00020(2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-H\u0002\u00a2\u0006\u0004\b/\u00100J\u0018\u00102\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u00020-H\u0002J\u0018\u00105\u001a\u00020\u00042\u0006\u00103\u001a\u00020$2\u0006\u0010)\u001a\u000204H\u0002J\u001a\u00106\u001a\u0004\u0018\u00010\u00142\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0002J:\u0010:\u001a\u0004\u0018\u00010$2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\n2\b\b\u0002\u00108\u001a\u00020%2\b\b\u0002\u00109\u001a\u00020%H\u0002J\u001c\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020$2\n\b\u0002\u00107\u001a\u0004\u0018\u00010\nH\u0002J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010;\u001a\u00020$H\u0002Je\u0010B\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?2\b\b\u0002\u0010A\u001a\u00020%H\u0002\u00a2\u0006\u0004\bB\u0010CJ[\u0010D\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010?H\u0002\u00a2\u0006\u0004\bD\u0010ER\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010T\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/normal/FileDownloadManager;", "", "Lcom/tencent/mobileqq/z1/download/a;", "downloadParams", "", "y", "Lkotlin/Function0;", "callback", "t", "l", "", "r", "", "category", "url", tl.h.F, "subCategoryName", DomainData.DOMAIN_NAME, "Lkotlin/Function1;", "", "Lcom/tencent/mobileqq/zootopia/download/normal/FileDownloadData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", "urlList", "Ljava/util/ArrayList;", "p", "desPath", "G", "Lcom/tencent/mobileqq/zootopia/download/ah;", "listener", "f", HippyTKDListViewAdapter.X, "cacheDirList", "k", "modId", "Lcom/tencent/mobileqq/zootopia/download/normal/FileDownloadEntity;", "", "dataFilter", "g", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "status", "", "progress", "", "size", "E", "(Lcom/tencent/mobileqq/zootopia/download/x;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Long;)V", "threadSwitchCostTime", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "downloadEntity", "Lcom/tencent/mobileqq/zootopia/download/BaseDownloadTask;", ReportConstant.COSTREPORT_PREFIX, "u", "extraSavePath", "skipCheck", "printLog", "v", "entity", "i", "j", "filePath", "Lcom/tencent/mobileqq/zootopia/download/normal/i;", "dbCallback", "forceSwitchThread", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/String;Lcom/tencent/mobileqq/zootopia/download/normal/i;Z)V", BdhLogUtil.LogTag.Tag_Conn, "(ILjava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/String;Lcom/tencent/mobileqq/zootopia/download/normal/i;)V", "Lec3/a;", "b", "Lec3/a;", "downloadTaskReport", "Lcom/tencent/mobileqq/zootopia/download/normal/b;", "c", "Lcom/tencent/mobileqq/zootopia/download/normal/b;", "dbHelper", "Lcom/tencent/mobileqq/zootopia/download/normal/BaseDownloadQueue;", "d", "Lcom/tencent/mobileqq/zootopia/download/normal/BaseDownloadQueue;", "downloadQueue", "com/tencent/mobileqq/zootopia/download/normal/FileDownloadManager$a", "e", "Lcom/tencent/mobileqq/zootopia/download/normal/FileDownloadManager$a;", "taskListener", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class FileDownloadManager {

    /* renamed from: a, reason: collision with root package name */
    public static final FileDownloadManager f328148a = new FileDownloadManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ec3.a downloadTaskReport = new ec3.a();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final b dbHelper = new b();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final BaseDownloadQueue downloadQueue;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static final a taskListener;

    static {
        BaseDownloadQueue baseDownloadQueue = new BaseDownloadQueue(ac3.b.INSTANCE.c().getFileTaskLimit(), 0, 2, null);
        downloadQueue = baseDownloadQueue;
        a aVar = new a();
        taskListener = aVar;
        baseDownloadQueue.f(aVar);
    }

    FileDownloadManager() {
    }

    private final void A(final int category, final String url, final Integer status, final Float progress, final Long size, final String filePath, final i dbCallback, boolean forceSwitchThread) {
        v.f328299a.o(forceSwitchThread, new Function0<Unit>(category, url, status, progress, size, filePath, dbCallback) { // from class: com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager$updateDownloadData$1
            final /* synthetic */ int $category;
            final /* synthetic */ i $dbCallback;
            final /* synthetic */ String $filePath;
            final /* synthetic */ Float $progress;
            final /* synthetic */ Long $size;
            final /* synthetic */ Integer $status;
            final /* synthetic */ String $url;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FileDownloadManager.f328148a.C(this.$category, this.$url, this.$status, this.$progress, this.$size, this.$filePath, null);
            }
        });
    }

    private final void i(FileDownloadEntity entity, String extraSavePath) {
        if (entity.downloadStatus == 5) {
            String str = entity.filePath;
            if (TextUtils.isEmpty(str) || !((TextUtils.isEmpty(extraSavePath) || Intrinsics.areEqual(extraSavePath, str)) && FileUtils.fileExistsAndNotEmpty(str))) {
                entity.downloadStatus = 6;
                int i3 = entity.category;
                String str2 = entity.url;
                Intrinsics.checkNotNullExpressionValue(str2, "entity.url");
                B(this, i3, str2, 6, null, null, extraSavePath, null, true, 88, null);
                QLog.e("ZootopiaFileDownloadManager", 1, "checkCompleteData " + entity.url + " filePath invalid - " + str + ", extraSavePath= " + extraSavePath, new Throwable("printStack"));
                j(entity);
            }
        }
    }

    private final void s(FileDownloadEntity downloadEntity, BaseDownloadTask task) {
        BaseDownloadQueue.v(downloadQueue, task, false, 2, null);
        dbHelper.n(downloadEntity);
    }

    private final FileDownloadEntity v(int category, String url, String extraSavePath, boolean skipCheck, boolean printLog) {
        FileDownloadEntity e16 = dbHelper.e(category, url);
        if (e16 == null) {
            e16 = null;
        } else if (!skipCheck) {
            f328148a.i(e16, extraSavePath);
        }
        if (printLog) {
            QLog.i("ZootopiaFileDownloadManager", 1, "queryDownloadInfoFromDbWithCheck " + category + "- " + url + ", FileDownloadEntity=" + e16 + ", status= " + (e16 != null ? Integer.valueOf(e16.downloadStatus) : null));
        }
        return e16;
    }

    public final void G(int category, String url, String desPath) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(desPath, "desPath");
        D(this, category, url, null, null, null, desPath, null, 92, null);
    }

    public final void f(ah listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        downloadQueue.f(listener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g(String modId, Function1<? super FileDownloadEntity, Boolean> dataFilter) {
        Intrinsics.checkNotNullParameter(modId, "modId");
        Intrinsics.checkNotNullParameter(dataFilter, "dataFilter");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            List<FileDownloadEntity> a16 = dbHelper.a();
            ArrayList<FileDownloadEntity> arrayList = new ArrayList();
            for (Object obj : a16) {
                if (dataFilter.invoke(obj).booleanValue()) {
                    arrayList.add(obj);
                }
            }
            QLog.i("ZootopiaFileDownloadManager", 1, modId + " autoClearOldVersionModRes BEGIN, needDeleteEntityList.size= " + arrayList.size() + ", totalDownloadList.size=" + a16.size());
            int i3 = 0;
            if (!arrayList.isEmpty()) {
                for (FileDownloadEntity fileDownloadEntity : arrayList) {
                    if (fileDownloadEntity.downloadStatus == 5) {
                        FileDownloadManager fileDownloadManager = f328148a;
                        int i16 = fileDownloadEntity.category;
                        String str = fileDownloadEntity.url;
                        Intrinsics.checkNotNullExpressionValue(str, "it.url");
                        downloadQueue.g(fileDownloadManager.h(i16, str));
                        b bVar = dbHelper;
                        int i17 = fileDownloadEntity.category;
                        String str2 = fileDownloadEntity.url;
                        Intrinsics.checkNotNullExpressionValue(str2, "it.url");
                        bVar.b(i17, str2);
                        i3++;
                    }
                }
            }
            QLog.i("ZootopiaFileDownloadManager", 1, modId + " autoClearOldVersionModRes, needDeleteEntityList.size= " + arrayList.size() + ", deletedSize= " + i3 + ", costTime= " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e16) {
            QLog.e("ZootopiaFileDownloadManager", 1, "autoClearOldVersionModRes, exception", e16);
        }
    }

    public final String h(int category, String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        try {
            return category + url;
        } catch (Exception e16) {
            QLog.e("ZootopiaFileDownloadManager", 1, "buildTaskId exception - category=" + category + ",  url=" + url, e16);
            return url;
        } catch (OutOfMemoryError e17) {
            QLog.e("ZootopiaFileDownloadManager", 1, "buildTaskId OOM - category=" + category + ",  url=" + url, e17);
            return url;
        }
    }

    public final void l(final FileDownloadParams downloadParams, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final String r16 = r(downloadParams);
        QLog.e("ZootopiaFileDownloadManager", 1, "deleteTask " + r16);
        v.f328299a.o(true, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager$deleteTask$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BaseDownloadQueue baseDownloadQueue;
                b bVar;
                baseDownloadQueue = FileDownloadManager.downloadQueue;
                baseDownloadQueue.g(r16);
                bVar = FileDownloadManager.dbHelper;
                bVar.b(downloadParams.getCategory(), downloadParams.getUrl());
                callback.invoke();
            }
        });
    }

    public final void m(final Function1<? super List<FileDownloadData>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        v.f328299a.o(true, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager$getAllDownloadData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                b bVar;
                ArrayList arrayList;
                int collectionSizeOrDefault;
                synchronized (FileDownloadManager.f328148a) {
                    bVar = FileDownloadManager.dbHelper;
                    List<FileDownloadEntity> a16 = bVar.a();
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
                    arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = a16.iterator();
                    while (it.hasNext()) {
                        arrayList.add(com.tencent.mobileqq.zootopia.download.c.f328029a.i((FileDownloadEntity) it.next()));
                    }
                }
                callback.invoke(arrayList);
            }
        });
    }

    public final String n(int category, String subCategoryName) {
        String str;
        if (TextUtils.isEmpty(subCategoryName)) {
            str = "";
        } else {
            str = "_" + subCategoryName;
        }
        for (ZPlanFileCategory zPlanFileCategory : ZPlanFileCategory.values()) {
            if (zPlanFileCategory.getValue() == category) {
                return zPlanFileCategory.getDesc() + str;
            }
        }
        return "Category_" + category + str;
    }

    public final void o(int category, String url, final Function1<? super FileDownloadData, Unit> callback) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ArrayList arrayList = new ArrayList();
        arrayList.add(url);
        Unit unit = Unit.INSTANCE;
        p(category, arrayList, new Function1<ArrayList<FileDownloadData>, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager$getDownloadData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ArrayList<FileDownloadData> arrayList2) {
                invoke2(arrayList2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ArrayList<FileDownloadData> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                callback.invoke(it.size() > 0 ? it.get(0) : null);
            }
        });
    }

    public final void p(final int category, final List<String> urlList, final Function1<? super ArrayList<FileDownloadData>, Unit> callback) {
        Intrinsics.checkNotNullParameter(urlList, "urlList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        v.f328299a.o(true, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager$getDownloadDataList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FileDownloadData u16;
                ArrayList<FileDownloadData> arrayList = new ArrayList<>();
                FileDownloadManager fileDownloadManager = FileDownloadManager.f328148a;
                List<String> list = urlList;
                int i3 = category;
                synchronized (fileDownloadManager) {
                    Iterator<String> it = list.iterator();
                    while (it.hasNext()) {
                        u16 = FileDownloadManager.f328148a.u(i3, it.next());
                        arrayList.add(u16);
                    }
                    Unit unit = Unit.INSTANCE;
                }
                callback.invoke(arrayList);
            }
        });
    }

    public final void q(Function1<? super FileDownloadData, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        v.f328299a.o(true, new FileDownloadManager$getDressData$1(callback));
    }

    public final String r(FileDownloadParams downloadParams) {
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        return h(downloadParams.getCategory(), downloadParams.getUrl());
    }

    public final void t(FileDownloadParams downloadParams, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        final String r16 = r(downloadParams);
        QLog.i("ZootopiaFileDownloadManager", 1, "pauseDownload " + r16);
        v.f328299a.o(true, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager$pauseDownload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BaseDownloadQueue baseDownloadQueue;
                baseDownloadQueue = FileDownloadManager.downloadQueue;
                BaseDownloadQueue.q(baseDownloadQueue, r16, false, 2, null);
                Function0<Unit> function0 = callback;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
    }

    public final void x(ah listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        downloadQueue.r(listener);
    }

    public final void y(final FileDownloadParams downloadParams) {
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        com.tencent.mobileqq.zootopia.download.file.a.f328049a.a(downloadParams);
        final long currentTimeMillis = System.currentTimeMillis();
        v.f328299a.o(true, new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.normal.FileDownloadManager$startDownload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                FileDownloadManager.f328148a.z(FileDownloadParams.this, System.currentTimeMillis() - currentTimeMillis);
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/zootopia/download/normal/FileDownloadManager$a", "Lcom/tencent/mobileqq/zootopia/download/ah;", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "", "d", "b", "c", "e", "", "code", tl.h.F, "", "progress", "f", "", "size", "i", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends ah {
        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void b(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            FileDownloadManager.F(FileDownloadManager.f328148a, task, 2, null, null, 12, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void c(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            QLog.i("ZootopiaFileDownloadManager", 1, task.getId() + " complete");
            FileDownloadManager.F(FileDownloadManager.f328148a, task, 5, null, null, 12, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void d(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            FileDownloadManager.F(FileDownloadManager.f328148a, task, 1, null, null, 12, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void e(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            FileDownloadManager.F(FileDownloadManager.f328148a, task, 4, null, null, 12, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void f(float progress, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            FileDownloadManager.F(FileDownloadManager.f328148a, task, null, Float.valueOf(progress), null, 10, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void h(int code, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            QLog.e("ZootopiaFileDownloadManager", 1, task.getId() + " onFailed " + code);
            FileDownloadManager.F(FileDownloadManager.f328148a, task, 6, Float.valueOf(0.0f), null, 8, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void i(long size, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            FileDownloadManager.F(FileDownloadManager.f328148a, task, 2, null, Long.valueOf(size), 4, null);
        }

        a() {
            super(null, 1, null);
        }
    }

    private final void j(FileDownloadEntity entity) {
        QLog.e("ZootopiaFileDownloadManager", 1, "clearTaskWhenFileInvalid");
        int i3 = entity.category;
        String str = entity.url;
        Intrinsics.checkNotNullExpressionValue(str, "entity.url");
        downloadQueue.g(h(i3, str));
    }

    private final void E(x task, Integer status, Float progress, Long size) {
        String str;
        boolean z16 = task instanceof f;
        f fVar = z16 ? (f) task : null;
        int category = fVar != null ? fVar.getCategory() : 0;
        f fVar2 = z16 ? (f) task : null;
        if (fVar2 == null || (str = fVar2.getUrl()) == null) {
            str = "";
        }
        B(this, category, str, status, progress, size, null, null, true, 32, null);
    }

    public final void k(List<String> cacheDirList) {
        int i3;
        boolean contains$default;
        Intrinsics.checkNotNullParameter(cacheDirList, "cacheDirList");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            List<FileDownloadEntity> a16 = dbHelper.a();
            ArrayList<FileDownloadEntity> arrayList = new ArrayList();
            Iterator<T> it = a16.iterator();
            while (true) {
                i3 = 0;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                FileDownloadEntity fileDownloadEntity = (FileDownloadEntity) next;
                Iterator<String> it5 = cacheDirList.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    String next2 = it5.next();
                    String str = fileDownloadEntity.filePath;
                    Intrinsics.checkNotNullExpressionValue(str, "it.filePath");
                    contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) next2, false, 2, (Object) null);
                    if (contains$default) {
                        i3 = 1;
                        break;
                    }
                }
                if (i3 != 0) {
                    arrayList.add(next);
                }
            }
            QLog.i("ZootopiaFileDownloadManager", 1, "deleteOldTaskDataWhenClearCache BEGIN, needDeleteEntityList.size= " + arrayList.size() + ", totalDownloadList.size=" + a16.size() + ", cacheDirList= " + cacheDirList);
            if (!arrayList.isEmpty()) {
                for (FileDownloadEntity fileDownloadEntity2 : arrayList) {
                    if (fileDownloadEntity2.downloadStatus == 5) {
                        FileDownloadManager fileDownloadManager = f328148a;
                        int i16 = fileDownloadEntity2.category;
                        String str2 = fileDownloadEntity2.url;
                        Intrinsics.checkNotNullExpressionValue(str2, "it.url");
                        downloadQueue.g(fileDownloadManager.h(i16, str2));
                        b bVar = dbHelper;
                        int i17 = fileDownloadEntity2.category;
                        String str3 = fileDownloadEntity2.url;
                        Intrinsics.checkNotNullExpressionValue(str3, "it.url");
                        bVar.b(i17, str3);
                        i3++;
                    }
                }
            }
            QLog.i("ZootopiaFileDownloadManager", 1, "deleteOldTaskDataWhenClearCache, needDeleteEntityList.size= " + arrayList.size() + ", deletedSize= " + i3 + ", costTime= " + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e16) {
            QLog.e("ZootopiaFileDownloadManager", 1, "deleteOldTaskDataWhenClearCache, exception", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(FileDownloadParams downloadParams, long threadSwitchCostTime) {
        long currentTimeMillis = System.currentTimeMillis();
        String url = downloadParams.getUrl();
        String k3 = v.f328299a.k(downloadParams);
        FileDownloadEntity w3 = w(this, downloadParams.getCategory(), url, k3, false, true, 8, null);
        if (w3 != null) {
            if (!TextUtils.isEmpty(k3)) {
                w3.filePath = k3;
            }
        } else {
            w3 = com.tencent.mobileqq.zootopia.download.c.f328029a.j(downloadParams);
        }
        FileDownloadEntity fileDownloadEntity = w3;
        String n3 = n(downloadParams.getCategory(), downloadParams.getSubCategoryName());
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        Integer srcModId = downloadParams.getSrcModId();
        String srcModName = downloadParams.getSrcModName();
        String srcBizScene = downloadParams.getSrcBizScene();
        Integer valueOf = srcBizScene != null ? Integer.valueOf(srcBizScene.hashCode()) : null;
        QLog.i("ZootopiaFileDownloadManager", 1, n3 + ", srcModInfo=" + srcModId + "_" + srcModName + ", bizScene=" + valueOf + " - try startDownload " + url + " - " + downloadParams.getFileName() + ", header= " + downloadParams.d() + ", entityFilePath= " + fileDownloadEntity.filePath + ", threadSwitchCostTime= " + threadSwitchCostTime + ", queryDbCostTime= " + currentTimeMillis2 + ", downloadEntity= " + fileDownloadEntity + ", read status - " + fileDownloadEntity.downloadStatus);
        String r16 = r(downloadParams);
        if (fileDownloadEntity.downloadStatus == 5) {
            QLog.i("ZootopiaFileDownloadManager", 1, n3 + ", already exist - " + url);
            downloadQueue.o(r16, downloadParams, fileDownloadEntity);
        } else if (!BaseDownloadQueue.w(downloadQueue, r16, false, downloadParams, 2, null)) {
            s(fileDownloadEntity, com.tencent.mobileqq.zootopia.download.c.f328029a.g(downloadParams, fileDownloadEntity));
        }
        downloadTaskReport.n(n3, url, threadSwitchCostTime, currentTimeMillis2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final FileDownloadData u(int category, String url) {
        FileDownloadEntity w3 = w(this, category, url, null, false, false, 28, null);
        if (w3 != null) {
            return com.tencent.mobileqq.zootopia.download.c.f328029a.i(w3);
        }
        return null;
    }

    static /* synthetic */ void F(FileDownloadManager fileDownloadManager, x xVar, Integer num, Float f16, Long l3, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            num = null;
        }
        if ((i3 & 4) != 0) {
            f16 = null;
        }
        if ((i3 & 8) != 0) {
            l3 = null;
        }
        fileDownloadManager.E(xVar, num, f16, l3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(int category, String url, Integer status, Float progress, Long size, String filePath, i dbCallback) {
        FileDownloadEntity w3 = w(this, category, url, null, status != null, false, 20, null);
        if (w3 != null) {
            if (status != null) {
                w3.downloadStatus = status.intValue();
            }
            if (progress != null) {
                w3.progress = progress.floatValue();
            }
            if (size != null) {
                w3.size = size.longValue();
            }
            if (filePath != null) {
                w3.filePath = filePath;
            }
            dbHelper.n(w3);
            if (dbCallback != null) {
                dbCallback.a(Result.m476constructorimpl(w3));
                return;
            }
            return;
        }
        QLog.e("ZootopiaFileDownloadManager", 1, url + " update status cant find downloadInfo - " + status, new Throwable("teststack, not crash"));
    }

    static /* synthetic */ FileDownloadEntity w(FileDownloadManager fileDownloadManager, int i3, String str, String str2, boolean z16, boolean z17, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            str2 = null;
        }
        return fileDownloadManager.v(i3, str, str2, (i16 & 8) != 0 ? false : z16, (i16 & 16) != 0 ? false : z17);
    }

    static /* synthetic */ void D(FileDownloadManager fileDownloadManager, int i3, String str, Integer num, Float f16, Long l3, String str2, i iVar, int i16, Object obj) {
        fileDownloadManager.C(i3, str, (i16 & 4) != 0 ? null : num, (i16 & 8) != 0 ? null : f16, (i16 & 16) != 0 ? null : l3, (i16 & 32) != 0 ? null : str2, (i16 & 64) != 0 ? null : iVar);
    }

    static /* synthetic */ void B(FileDownloadManager fileDownloadManager, int i3, String str, Integer num, Float f16, Long l3, String str2, i iVar, boolean z16, int i16, Object obj) {
        fileDownloadManager.A(i3, str, (i16 & 4) != 0 ? null : num, (i16 & 8) != 0 ? null : f16, (i16 & 16) != 0 ? null : l3, (i16 & 32) != 0 ? null : str2, (i16 & 64) != 0 ? null : iVar, (i16 & 128) != 0 ? false : z16);
    }
}
