package com.tencent.mobileqq.zootopia.download;

import android.text.TextUtils;
import ck3.ZPlanModReqInfo;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.z1.download.data.ZootopiaDownloadParams;
import com.tencent.mobileqq.z1.download.data.ZootopiaResData;
import com.tencent.mobileqq.z1.download.db.ZootopiaDownloadEntity;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import com.tencent.mobileqq.zootopia.download.ZPlanModDownloadManagerProxy;
import com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData;
import com.tencent.mobileqq.zootopia.download.db.ZootopiaDownloadDBProxy;
import com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchManager;
import com.tencent.mobileqq.zootopia.download.normal.BaseDownloadQueue;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import wg3.b;

@Metadata(d1 = {"\u0000\u00a7\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\b*\u0001W\u0018\u0000 ]2\u00020\u0001:\u0001?B\u0007\u00a2\u0006\u0004\b[\u0010\\J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\nJ$\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\u0004\u0012\u00020\u00040\rJ \u0010\u0012\u001a\u00020\u00042\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0011\u0012\u0004\u0012\u00020\u00040\rJ \u0010\u0014\u001a\u00020\u00042\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0011\u0012\u0004\u0012\u00020\u00040\rJ$\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00040\rJ,\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\n2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u00040\rJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0011J\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fJ\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fJE\u0010)\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b)\u0010*J\u000e\u0010+\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H\u0002J\u0018\u00103\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.2\u0006\u00102\u001a\u000201H\u0002J\"\u00104\u001a\u00020\u00042\u0018\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u0011\u0012\u0004\u0012\u00020\u00040\rH\u0002J.\u00105\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\n2\u0014\u0010\u000f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u0004\u0012\u00020\u00040\rH\u0002J\u001c\u00107\u001a\u0004\u0018\u00010.2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u00106\u001a\u00020\nH\u0002J\u000e\u00108\u001a\b\u0012\u0004\u0012\u00020.0\u0011H\u0002J\u0010\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u00020.H\u0002J\u0010\u0010;\u001a\u00020\u00042\u0006\u00109\u001a\u00020.H\u0002JG\u0010<\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010$2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b<\u0010*J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\u0014\u0010A\u001a\u00020>8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0014\u0010E\u001a\u00020B8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bC\u0010DR\u0014\u0010I\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0014\u0010M\u001a\u00020J8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LRA\u0010V\u001a!\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\bN\u0012\b\bO\u0012\u0004\b\b(\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u0014\u0010Z\u001a\u00020W8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bX\u0010Y\u00a8\u0006^"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ZPlanModDownloadManagerProxy;", "", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaDownloadParams;", "downloadParams", "", "G", "", "id", "D", "j", "", "startNext", "y", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaResData;", "callback", "w", "", "p", "Lcom/tencent/mobileqq/zootopia/download/data/ZootopiaDownloadData;", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "forceSearchDb", "r", "Lcom/tencent/mobileqq/zootopia/download/x;", "v", "", "t", "Lcom/tencent/mobileqq/zootopia/download/normal/g;", "queueListener", "E", "Lcom/tencent/mobileqq/zootopia/download/ah;", "listener", "i", BdhLogUtil.LogTag.Tag_Conn, "status", "", "progress", "", "completeTime", "version", "L", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Float;Ljava/lang/Long;Ljava/lang/String;)V", "O", "H", "K", "Lcom/tencent/mobileqq/z1/download/db/ZootopiaDownloadEntity;", "downloadEntity", "l", "Lcom/tencent/mobileqq/zootopia/download/ZootopiaDownloadTask;", "task", HippyTKDListViewAdapter.X, "o", ReportConstant.COSTREPORT_PREFIX, "skipCheck", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "B", "entity", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "N", "I", "Lec3/a;", "a", "Lec3/a;", "downloadNormalReporter", "Lxg3/a;", "b", "Lxg3/a;", "diffUpdateReporter", "Lcom/tencent/mobileqq/zootopia/download/db/ZootopiaDownloadDBProxy;", "c", "Lcom/tencent/mobileqq/zootopia/download/db/ZootopiaDownloadDBProxy;", "dbHelper", "Lcom/tencent/mobileqq/zootopia/download/normal/BaseDownloadQueue;", "d", "Lcom/tencent/mobileqq/zootopia/download/normal/BaseDownloadQueue;", "downloadQueue", "Lkotlin/ParameterName;", "name", "e", "Lkotlin/jvm/functions/Function1;", "u", "()Lkotlin/jvm/functions/Function1;", UserInfo.SEX_FEMALE, "(Lkotlin/jvm/functions/Function1;)V", "taskDeletedListener", "com/tencent/mobileqq/zootopia/download/ZPlanModDownloadManagerProxy$c", "f", "Lcom/tencent/mobileqq/zootopia/download/ZPlanModDownloadManagerProxy$c;", "taskListener", "<init>", "()V", "g", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanModDownloadManagerProxy {

    /* renamed from: g, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: from kotlin metadata */
    private final ec3.a downloadNormalReporter = new ec3.a();

    /* renamed from: b, reason: from kotlin metadata */
    private final xg3.a diffUpdateReporter = new xg3.a();

    /* renamed from: c, reason: from kotlin metadata */
    private final ZootopiaDownloadDBProxy dbHelper = new ZootopiaDownloadDBProxy();

    /* renamed from: d, reason: from kotlin metadata */
    private final BaseDownloadQueue downloadQueue;

    /* renamed from: e, reason: from kotlin metadata */
    private Function1<? super String, Unit> taskDeletedListener;

    /* renamed from: f, reason: from kotlin metadata */
    private final c taskListener;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/ZPlanModDownloadManagerProxy$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.download.ZPlanModDownloadManagerProxy$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/download/ZPlanModDownloadManagerProxy$b", "Lwg3/b$a;", "", "isSuccess", "", "errorCode", "", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements b.a {
        b() {
        }

        @Override // wg3.b.a
        public void a(boolean isSuccess, int errorCode, String errorMessage) {
            QLog.i("ZPlanModDownloadManagerProxy", 1, "preload diffPatch so, res = " + isSuccess + ", errorCode = " + errorCode + ", errorMessage " + errorMessage);
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/zootopia/download/ZPlanModDownloadManagerProxy$c", "Lcom/tencent/mobileqq/zootopia/download/ah;", "Lcom/tencent/mobileqq/zootopia/download/x;", "task", "", "d", "b", "a", "c", "e", "", "code", tl.h.F, "", "progress", "f", "g", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends ah {
        c() {
            super(null, 1, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void a(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanModDownloadManagerProxy.M(ZPlanModDownloadManagerProxy.this, task.getId(), 3, null, null, null, 28, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void b(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanModDownloadManagerProxy.M(ZPlanModDownloadManagerProxy.this, task.getId(), 2, null, null, null, 28, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void c(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            QLog.i("ZPlanModDownloadManagerProxy", 1, task.getId() + " complete");
            ZPlanModDownloadManagerProxy.M(ZPlanModDownloadManagerProxy.this, task.getId(), 5, null, Long.valueOf(System.currentTimeMillis()), null, 20, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void d(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanModDownloadManagerProxy.M(ZPlanModDownloadManagerProxy.this, task.getId(), 1, null, null, null, 28, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void e(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanModDownloadManagerProxy.M(ZPlanModDownloadManagerProxy.this, task.getId(), 4, null, null, null, 28, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void f(float progress, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            ZPlanModDownloadManagerProxy.M(ZPlanModDownloadManagerProxy.this, task.getId(), 2, Float.valueOf(progress), null, null, 24, null);
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void g(x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            QLog.e("ZPlanModDownloadManagerProxy", 1, task.getId() + " onTaskDeleted invoke taskDeletedListener again");
            Function1<String, Unit> u16 = ZPlanModDownloadManagerProxy.this.u();
            if (u16 != null) {
                u16.invoke(task.getId());
            }
        }

        @Override // com.tencent.mobileqq.zootopia.download.ah, com.tencent.mobileqq.zootopia.download.y
        public void h(int i3, x task) {
            Intrinsics.checkNotNullParameter(task, "task");
            QLog.e("ZPlanModDownloadManagerProxy", 1, task.getId() + " onFailed " + i3);
            ZPlanModDownloadManagerProxy.M(ZPlanModDownloadManagerProxy.this, task.getId(), 6, Float.valueOf(0.0f), null, null, 24, null);
        }
    }

    public ZPlanModDownloadManagerProxy() {
        BaseDownloadQueue baseDownloadQueue = new BaseDownloadQueue(ac3.b.INSTANCE.c().getModTaskLimit(), 0, 2, null);
        this.downloadQueue = baseDownloadQueue;
        c cVar = new c();
        this.taskListener = cVar;
        baseDownloadQueue.f(cVar);
    }

    public final List<ZootopiaDownloadEntity> B() {
        int collectionSizeOrDefault;
        List<ZootopiaDownloadEntity> a16 = this.dbHelper.a();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (ZootopiaDownloadEntity zootopiaDownloadEntity : a16) {
            k(zootopiaDownloadEntity);
            arrayList.add(zootopiaDownloadEntity);
        }
        return arrayList;
    }

    private final void I(final ZootopiaDownloadParams downloadParams) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zootopia.download.aa
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanModDownloadManagerProxy.J(ZootopiaDownloadParams.this);
            }
        }, 2000L);
    }

    public static final void J(ZootopiaDownloadParams downloadParams) {
        Intrinsics.checkNotNullParameter(downloadParams, "$downloadParams");
        ZPlanModReqInfo zPlanModReqInfo = new ZPlanModReqInfo(downloadParams.getSummaryData().getId(), downloadParams.getModVersionSimpleData().getNowMapVer(), downloadParams.getModVersionSimpleData().getPackType());
        QLog.i("ZPlanModDownloadManagerProxy", 1, "tryPreloadHotPatchWhenStartDownload - " + zPlanModReqInfo);
        ZPlanModHotPatchManager.u(ZPlanModHotPatchManager.f328077a, "preloadWhenStart", zPlanModReqInfo, null, false, false, 28, null);
    }

    private final void K(String id5, ZootopiaDownloadParams downloadParams) {
        x k3 = this.downloadQueue.k(id5);
        ZootopiaDownloadTask zootopiaDownloadTask = k3 instanceof ZootopiaDownloadTask ? (ZootopiaDownloadTask) k3 : null;
        if (zootopiaDownloadTask != null) {
            zootopiaDownloadTask.t0(downloadParams.getUrl());
            zootopiaDownloadTask.q0(downloadParams.getModVersionSimpleData());
            boolean isSilentDownload = downloadParams.getExtraData().isSilentDownload();
            if (zootopiaDownloadTask.m0() != isSilentDownload) {
                QLog.e("ZPlanModDownloadManagerProxy", 1, "updateCacheTaskInfo, silentDownload " + id5 + ", old= " + zootopiaDownloadTask.m0() + ", new= " + isSilentDownload);
            }
            zootopiaDownloadTask.s0(isSilentDownload);
            zootopiaDownloadTask.r0(downloadParams.getExtraData().getNeedNotification());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003a A[Catch: all -> 0x0056, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:24:0x0007, B:6:0x0011, B:9:0x0019, B:11:0x0021, B:13:0x0029, B:15:0x0031, B:16:0x0033, B:20:0x003a), top: B:23:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void N(String id5, Integer status, Float progress, Long completeTime, String version) {
        boolean z16;
        ZootopiaDownloadEntity z17;
        synchronized (INSTANCE) {
            if (status != null) {
                if (status.intValue() == 6) {
                    z16 = true;
                    z17 = z(id5, z16);
                    if (z17 == null) {
                        if (status != null) {
                            z17.downloadStatus = status.intValue();
                        }
                        if (progress != null) {
                            z17.progress = progress.floatValue();
                        }
                        if (completeTime != null) {
                            z17.completeTime = completeTime.longValue();
                        }
                        if (version != null) {
                            z17.version = version;
                        }
                        this.dbHelper.i(z17);
                        return;
                    }
                    QLog.e("ZPlanModDownloadManagerProxy", 1, id5 + " update status cant find downloadInfo");
                    Unit unit = Unit.INSTANCE;
                    return;
                }
            }
            z16 = false;
            z17 = z(id5, z16);
            if (z17 == null) {
            }
        }
    }

    public final void k(ZootopiaDownloadEntity entity) {
        if (entity.downloadStatus == 5) {
            v vVar = v.f328299a;
            String str = entity.zootopiaId;
            Intrinsics.checkNotNullExpressionValue(str, "entity.zootopiaId");
            String str2 = entity.projectName;
            Intrinsics.checkNotNullExpressionValue(str2, "entity.projectName");
            String j3 = vVar.j(str, str2);
            if (TextUtils.isEmpty(j3) || !new File(j3).exists()) {
                this.downloadNormalReporter.p(entity);
                entity.downloadStatus = 6;
                String str3 = entity.zootopiaId;
                Intrinsics.checkNotNullExpressionValue(str3, "entity.zootopiaId");
                M(this, str3, 6, null, null, null, 28, null);
                QLog.e("ZPlanModDownloadManagerProxy", 1, "checkCompleteData " + entity.zootopiaId + " pak invalid - " + j3);
                m(entity);
            }
        }
    }

    private final void l(ZootopiaDownloadEntity downloadEntity) {
        FileUtils.deleteDirectory(downloadEntity.filePath);
        BaseDownloadQueue baseDownloadQueue = this.downloadQueue;
        String str = downloadEntity.zootopiaId;
        Intrinsics.checkNotNullExpressionValue(str, "downloadEntity.zootopiaId");
        baseDownloadQueue.g(str);
        Function1<? super String, Unit> function1 = this.taskDeletedListener;
        if (function1 != null) {
            String str2 = downloadEntity.zootopiaId;
            Intrinsics.checkNotNullExpressionValue(str2, "downloadEntity.zootopiaId");
            function1.invoke(str2);
        }
    }

    private final void o(final Function1<? super List<? extends ZootopiaDownloadEntity>, Unit> callback) {
        v.f328299a.n(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZPlanModDownloadManagerProxy$getAllDownloadEntity$1
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
                List<? extends ZootopiaDownloadEntity> B;
                ZPlanModDownloadManagerProxy.Companion companion = ZPlanModDownloadManagerProxy.INSTANCE;
                ZPlanModDownloadManagerProxy zPlanModDownloadManagerProxy = this;
                synchronized (companion) {
                    B = zPlanModDownloadManagerProxy.B();
                }
                callback.invoke(B);
            }
        });
    }

    public final void x(ZootopiaDownloadEntity zootopiaDownloadEntity, ZootopiaDownloadTask zootopiaDownloadTask) {
        this.dbHelper.i(zootopiaDownloadEntity);
        BaseDownloadQueue.v(this.downloadQueue, zootopiaDownloadTask, false, 2, null);
    }

    private final ZootopiaDownloadEntity z(String str, boolean z16) {
        ZootopiaDownloadEntity k3 = this.dbHelper.k(str);
        if (k3 == null) {
            return null;
        }
        if (z16) {
            return k3;
        }
        k(k3);
        return k3;
    }

    public final void C(ah listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.downloadQueue.r(listener);
    }

    public final void D(final String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        v.f328299a.n(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZPlanModDownloadManagerProxy$resumeDownloadById$1
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
                BaseDownloadQueue baseDownloadQueue2;
                ZPlanModDownloadManagerProxy.Companion companion = ZPlanModDownloadManagerProxy.INSTANCE;
                String str = id5;
                ZPlanModDownloadManagerProxy zPlanModDownloadManagerProxy = this;
                synchronized (companion) {
                    QLog.i("ZPlanModDownloadManagerProxy", 1, "try resumeDownload with id " + str);
                    ZootopiaDownloadEntity A = ZPlanModDownloadManagerProxy.A(zPlanModDownloadManagerProxy, str, false, 2, null);
                    if (A != null) {
                        baseDownloadQueue = zPlanModDownloadManagerProxy.downloadQueue;
                        if (baseDownloadQueue.h(str)) {
                            baseDownloadQueue2 = zPlanModDownloadManagerProxy.downloadQueue;
                            BaseDownloadQueue.w(baseDownloadQueue2, str, false, null, 6, null);
                            return;
                        } else {
                            zPlanModDownloadManagerProxy.x(A, c.f328029a.f(A));
                            Unit unit = Unit.INSTANCE;
                            return;
                        }
                    }
                    QLog.e("ZPlanModDownloadManagerProxy", 1, "resumeDownload " + str + " not find data");
                }
            }
        });
    }

    public final void E(com.tencent.mobileqq.zootopia.download.normal.g queueListener) {
        Intrinsics.checkNotNullParameter(queueListener, "queueListener");
        this.downloadQueue.s(queueListener);
    }

    public final void F(Function1<? super String, Unit> function1) {
        this.taskDeletedListener = function1;
    }

    public final void G(final ZootopiaDownloadParams downloadParams) {
        Intrinsics.checkNotNullParameter(downloadParams, "downloadParams");
        v.f328299a.n(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZPlanModDownloadManagerProxy$startDownload$1
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
                ZPlanModDownloadManagerProxy.Companion companion = ZPlanModDownloadManagerProxy.INSTANCE;
                ZPlanModDownloadManagerProxy zPlanModDownloadManagerProxy = ZPlanModDownloadManagerProxy.this;
                ZootopiaDownloadParams zootopiaDownloadParams = downloadParams;
                synchronized (companion) {
                    zPlanModDownloadManagerProxy.H(zootopiaDownloadParams);
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
    }

    public final void L(final String id5, final Integer status, final Float progress, final Long completeTime, final String version) {
        Intrinsics.checkNotNullParameter(id5, "id");
        v.f328299a.n(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZPlanModDownloadManagerProxy$updateDownloadData$1
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
                ZPlanModDownloadManagerProxy.this.N(id5, status, progress, completeTime, version);
            }
        });
    }

    public final void O(final String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        v.f328299a.n(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZPlanModDownloadManagerProxy$updateDownloadDataWhenDiffPatchFail$1
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
                ZootopiaDownloadDBProxy zootopiaDownloadDBProxy;
                ZPlanModDownloadManagerProxy.Companion companion = ZPlanModDownloadManagerProxy.INSTANCE;
                ZPlanModDownloadManagerProxy zPlanModDownloadManagerProxy = ZPlanModDownloadManagerProxy.this;
                String str = id5;
                synchronized (companion) {
                    ZootopiaDownloadEntity A = ZPlanModDownloadManagerProxy.A(zPlanModDownloadManagerProxy, str, false, 2, null);
                    if (A != null) {
                        A.isDiffUpdate = false;
                        zootopiaDownloadDBProxy = zPlanModDownloadManagerProxy.dbHelper;
                        zootopiaDownloadDBProxy.i(A);
                    } else {
                        QLog.e("ZPlanModDownloadManagerProxy", 1, str + " updateDownloadDataWhenDiffPatchFail cant find downloadInfo");
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
    }

    public final void i(ah listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.downloadQueue.f(listener);
    }

    public final void j(final String id5) {
        Intrinsics.checkNotNullParameter(id5, "id");
        w(id5, new Function1<ZootopiaResData, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZPlanModDownloadManagerProxy$cancelDownload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaResData zootopiaResData) {
                invoke2(zootopiaResData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaResData zootopiaResData) {
                BaseDownloadQueue baseDownloadQueue;
                ZootopiaDownloadDBProxy zootopiaDownloadDBProxy;
                ZPlanModDownloadManagerProxy.Companion companion = ZPlanModDownloadManagerProxy.INSTANCE;
                ZPlanModDownloadManagerProxy zPlanModDownloadManagerProxy = ZPlanModDownloadManagerProxy.this;
                String str = id5;
                synchronized (companion) {
                    if (zootopiaResData != null) {
                        try {
                            FileUtils.deleteDirectory(zootopiaResData.getFilePath());
                        } catch (Throwable th5) {
                            throw th5;
                        }
                    }
                    baseDownloadQueue = zPlanModDownloadManagerProxy.downloadQueue;
                    baseDownloadQueue.g(str);
                    zootopiaDownloadDBProxy = zPlanModDownloadManagerProxy.dbHelper;
                    zootopiaDownloadDBProxy.b(str);
                    Function1<String, Unit> u16 = zPlanModDownloadManagerProxy.u();
                    if (u16 != null) {
                        u16.invoke(str);
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
        ZPlanModHotPatchManager.f328077a.p(id5, "cancelMainPakDownload", true);
    }

    public final void n(final Function1<? super List<ZootopiaDownloadData>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        o(new Function1<List<? extends ZootopiaDownloadEntity>, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZPlanModDownloadManagerProxy$getAllDownloadData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ZootopiaDownloadEntity> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends ZootopiaDownloadEntity> entityList) {
                int collectionSizeOrDefault;
                Intrinsics.checkNotNullParameter(entityList, "entityList");
                List<? extends ZootopiaDownloadEntity> list = entityList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(c.f328029a.c((ZootopiaDownloadEntity) it.next()));
                }
                callback.invoke(arrayList);
            }
        });
    }

    public final void p(final Function1<? super List<ZootopiaResData>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        o(new Function1<List<? extends ZootopiaDownloadEntity>, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZPlanModDownloadManagerProxy$getAllZootopiaResInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ZootopiaDownloadEntity> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends ZootopiaDownloadEntity> entityList) {
                int collectionSizeOrDefault;
                Intrinsics.checkNotNullParameter(entityList, "entityList");
                List<? extends ZootopiaDownloadEntity> list = entityList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(c.f328029a.k((ZootopiaDownloadEntity) it.next()));
                }
                callback.invoke(arrayList);
            }
        });
    }

    public final void q(String id5, Function1<? super ZootopiaDownloadData, Unit> callback) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(callback, "callback");
        r(id5, false, callback);
    }

    public final void r(String id5, boolean forceSearchDb, final Function1<? super ZootopiaDownloadData, Unit> callback) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        s(id5, forceSearchDb, new Function1<ZootopiaDownloadEntity, Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZPlanModDownloadManagerProxy$getDownloadData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ZootopiaDownloadEntity zootopiaDownloadEntity) {
                invoke2(zootopiaDownloadEntity);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Type inference failed for: r3v2, types: [T, com.tencent.mobileqq.zootopia.download.data.ZootopiaDownloadData] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ZootopiaDownloadEntity zootopiaDownloadEntity) {
                if (zootopiaDownloadEntity != null) {
                    objectRef.element = c.f328029a.c(zootopiaDownloadEntity);
                }
                callback.invoke(objectRef.element);
            }
        });
    }

    public final int t() {
        return this.downloadQueue.l();
    }

    public final Function1<String, Unit> u() {
        return this.taskDeletedListener;
    }

    public final List<x> v() {
        return this.downloadQueue.n();
    }

    public final void w(final String id5, final Function1<? super ZootopiaResData, Unit> callback) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(callback, "callback");
        v.f328299a.n(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZPlanModDownloadManagerProxy$getZootopiaResInfo$1
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
                ZootopiaResData k3;
                ZPlanModDownloadManagerProxy.Companion companion = ZPlanModDownloadManagerProxy.INSTANCE;
                ZPlanModDownloadManagerProxy zPlanModDownloadManagerProxy = this;
                String str = id5;
                synchronized (companion) {
                    ZootopiaDownloadEntity A = ZPlanModDownloadManagerProxy.A(zPlanModDownloadManagerProxy, str, false, 2, null);
                    k3 = A != null ? c.f328029a.k(A) : null;
                    Unit unit = Unit.INSTANCE;
                }
                callback.invoke(k3);
            }
        });
    }

    public final void y(String id5, boolean startNext) {
        Intrinsics.checkNotNullParameter(id5, "id");
        this.downloadQueue.p(id5, startNext);
    }

    private final void m(ZootopiaDownloadEntity zootopiaDownloadEntity) {
        QLog.e("ZPlanModDownloadManagerProxy", 1, "clearTaskWhenFileInvalid");
        String taskId = zootopiaDownloadEntity.zootopiaId;
        BaseDownloadQueue baseDownloadQueue = this.downloadQueue;
        Intrinsics.checkNotNullExpressionValue(taskId, "taskId");
        baseDownloadQueue.g(taskId);
    }

    private final void s(final String str, final boolean z16, final Function1<? super ZootopiaDownloadEntity, Unit> function1) {
        if (!z16) {
            ZootopiaDownloadEntity l3 = this.dbHelper.l(str);
            if (l3 != null) {
                k(l3);
            } else {
                l3 = null;
            }
            if (l3 != null) {
                function1.invoke(l3);
                return;
            }
        }
        v.f328299a.n(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.download.ZPlanModDownloadManagerProxy$getDownloadEntity$1
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
                ZootopiaDownloadDBProxy zootopiaDownloadDBProxy;
                ZootopiaDownloadEntity k3;
                ZootopiaDownloadDBProxy zootopiaDownloadDBProxy2;
                if (z16) {
                    zootopiaDownloadDBProxy2 = this.dbHelper;
                    k3 = zootopiaDownloadDBProxy2.e(str);
                } else {
                    zootopiaDownloadDBProxy = this.dbHelper;
                    k3 = zootopiaDownloadDBProxy.k(str);
                }
                if (k3 != null) {
                    this.k(k3);
                } else {
                    k3 = null;
                }
                function1.invoke(k3);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x0261, code lost:
    
        if (r7 == null) goto L168;
     */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0251  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void H(ZootopiaDownloadParams downloadParams) {
        boolean z16;
        boolean z17;
        boolean z18;
        ZootopiaDownloadEntity d16;
        boolean z19;
        String str;
        long j3;
        ZPlanMapDiffPatchInfo diffPatchInfo;
        pv4.e diffPatchInfo2;
        pv4.e diffPatchInfo3;
        pv4.e diffPatchInfo4;
        String id5 = downloadParams.getSummaryData().getId();
        QLog.i("ZPlanModDownloadManagerProxy", 1, "try startDownload " + id5 + " " + downloadParams.getSummaryData().getTitle() + " " + downloadParams.getVersion());
        ZootopiaDownloadEntity A = A(this, id5, false, 2, null);
        if (A == null) {
            A = com.tencent.mobileqq.zootopia.download.c.f328029a.d(downloadParams);
        }
        if (A.isSilentDownload != downloadParams.getExtraData().isSilentDownload()) {
            A.isSilentDownload = downloadParams.getExtraData().isSilentDownload();
            z16 = true;
        } else {
            z16 = false;
        }
        A.isPlayTogether = downloadParams.getExtraData().isPlayDownloadTogether();
        if (Intrinsics.areEqual(A.url, downloadParams.getUrl()) || TextUtils.isEmpty(downloadParams.getUrl())) {
            z17 = false;
        } else {
            A.url = downloadParams.getUrl();
            z17 = true;
        }
        QLog.i("ZPlanModDownloadManagerProxy", 1, "startDownloadInner self md5:" + A.md5 + ", downloadParams.md5:" + downloadParams.getModVersionSimpleData().getMd5() + ", " + z16 + ", isUrlChanged= " + z17);
        A.md5 = downloadParams.getModVersionSimpleData().getMd5();
        A.pakMd5 = downloadParams.getModVersionSimpleData().getPakMd5();
        A.packType = downloadParams.getModVersionSimpleData().getPackType();
        A.needNotification = downloadParams.getExtraData().getNeedNotification();
        I(downloadParams);
        if (!Intrinsics.areEqual(A.version, downloadParams.getVersion())) {
            String curBaseVersion = A.version;
            boolean a16 = ZPlanMapDiffPatchInfo.INSTANCE.a();
            ZPlanMapDiffPatchInfo diffPatchInfo5 = downloadParams.getDiffPatchInfo();
            if ((diffPatchInfo5 != null && diffPatchInfo5.isValid()) && a16) {
                v vVar = v.f328299a;
                String str2 = A.zootopiaId;
                Intrinsics.checkNotNullExpressionValue(str2, "downloadEntity.zootopiaId");
                String str3 = A.projectName;
                Intrinsics.checkNotNullExpressionValue(str3, "downloadEntity.projectName");
                String j16 = vVar.j(str2, str3);
                if (FileUtils.fileExists(j16)) {
                    String e16 = com.tencent.mobileqq.portal.o.e(j16);
                    if (!TextUtils.isEmpty(e16)) {
                        pv4.e diffPatchInfo6 = diffPatchInfo5.diffPatchInfo();
                        if (Intrinsics.areEqual(e16, diffPatchInfo6 != null ? diffPatchInfo6.f427593e : null)) {
                            z18 = true;
                            String str4 = A.zootopiaId;
                            String str5 = A.version;
                            int i3 = A.downloadStatus;
                            String version = downloadParams.getVersion();
                            ZPlanMapDiffPatchInfo diffPatchInfo7 = downloadParams.getDiffPatchInfo();
                            QLog.i("ZPlanModDownloadManagerProxy", 1, str4 + " update curVer " + str5 + " status " + i3 + " newVer " + version + ", clientEnableDiffPatch= " + a16 + ", useDiffPatch= " + z18 + ", diffUrl= " + ((diffPatchInfo7 != null || (diffPatchInfo4 = diffPatchInfo7.diffPatchInfo()) == null) ? null : diffPatchInfo4.f427589a));
                            if (!z18) {
                                ZootopiaDownloadDBProxy zootopiaDownloadDBProxy = this.dbHelper;
                                String str6 = A.zootopiaId;
                                Intrinsics.checkNotNullExpressionValue(str6, "downloadEntity.zootopiaId");
                                zootopiaDownloadDBProxy.b(str6);
                                l(A);
                            }
                            com.tencent.mobileqq.zootopia.download.c cVar = com.tencent.mobileqq.zootopia.download.c.f328029a;
                            d16 = cVar.d(downloadParams);
                            if (TextUtils.isEmpty(d16.scriptType)) {
                                d16.scriptType = A.scriptType;
                            }
                            if (TextUtils.isEmpty(d16.runScript)) {
                                d16.runScript = A.runScript;
                            }
                            d16.isUpdate = true;
                            d16.isDiffUpdate = z18;
                            x(d16, cVar.f(d16));
                            if (z18) {
                                QLog.i("ZPlanModDownloadManagerProxy", 1, "preload diffPatch so");
                                wg3.b.f445625a.c(new b());
                            }
                            ZPlanMapDiffPatchInfo diffPatchInfo8 = downloadParams.getDiffPatchInfo();
                            z19 = diffPatchInfo8 == null && diffPatchInfo8.isValid();
                            xg3.a aVar = this.diffUpdateReporter;
                            Intrinsics.checkNotNullExpressionValue(curBaseVersion, "curBaseVersion");
                            String version2 = downloadParams.getVersion();
                            if (z19) {
                                ZPlanMapDiffPatchInfo diffPatchInfo9 = downloadParams.getDiffPatchInfo();
                                str = (diffPatchInfo9 == null || (diffPatchInfo3 = diffPatchInfo9.diffPatchInfo()) == null) ? null : diffPatchInfo3.f427589a;
                            }
                            str = "";
                            j3 = 0;
                            if (z19 && (diffPatchInfo = downloadParams.getDiffPatchInfo()) != null && (diffPatchInfo2 = diffPatchInfo.diffPatchInfo()) != null) {
                                j3 = diffPatchInfo2.f427590b;
                            }
                            aVar.f(id5, curBaseVersion, version2, str, j3, downloadParams.getUrl(), downloadParams.getSize(), a16, z18);
                            return;
                        }
                    }
                    String str7 = A.zootopiaId;
                    pv4.e diffPatchInfo10 = diffPatchInfo5.diffPatchInfo();
                    QLog.e("ZPlanModDownloadManagerProxy", 1, str7 + " oldMd5 not valid - " + e16 + ", dstMd5= " + (diffPatchInfo10 != null ? diffPatchInfo10.f427593e : null) + ", " + j16);
                }
            }
            z18 = false;
            String str42 = A.zootopiaId;
            String str52 = A.version;
            int i36 = A.downloadStatus;
            String version3 = downloadParams.getVersion();
            ZPlanMapDiffPatchInfo diffPatchInfo72 = downloadParams.getDiffPatchInfo();
            if (diffPatchInfo72 != null) {
            }
            QLog.i("ZPlanModDownloadManagerProxy", 1, str42 + " update curVer " + str52 + " status " + i36 + " newVer " + version3 + ", clientEnableDiffPatch= " + a16 + ", useDiffPatch= " + z18 + ", diffUrl= " + ((diffPatchInfo72 != null || (diffPatchInfo4 = diffPatchInfo72.diffPatchInfo()) == null) ? null : diffPatchInfo4.f427589a));
            if (!z18) {
            }
            com.tencent.mobileqq.zootopia.download.c cVar2 = com.tencent.mobileqq.zootopia.download.c.f328029a;
            d16 = cVar2.d(downloadParams);
            if (TextUtils.isEmpty(d16.scriptType)) {
            }
            if (TextUtils.isEmpty(d16.runScript)) {
            }
            d16.isUpdate = true;
            d16.isDiffUpdate = z18;
            x(d16, cVar2.f(d16));
            if (z18) {
            }
            ZPlanMapDiffPatchInfo diffPatchInfo82 = downloadParams.getDiffPatchInfo();
            if (diffPatchInfo82 == null) {
            }
            xg3.a aVar2 = this.diffUpdateReporter;
            Intrinsics.checkNotNullExpressionValue(curBaseVersion, "curBaseVersion");
            String version22 = downloadParams.getVersion();
            if (z19) {
            }
            str = "";
            j3 = 0;
            if (z19) {
                j3 = diffPatchInfo2.f427590b;
            }
            aVar2.f(id5, curBaseVersion, version22, str, j3, downloadParams.getUrl(), downloadParams.getSize(), a16, z18);
            return;
        }
        if (this.downloadQueue.h(id5)) {
            K(id5, downloadParams);
            this.dbHelper.i(A);
            BaseDownloadQueue.w(this.downloadQueue, id5, z16, null, 4, null);
            return;
        }
        x(A, com.tencent.mobileqq.zootopia.download.c.f328029a.f(A));
    }

    public static /* synthetic */ ZootopiaDownloadEntity A(ZPlanModDownloadManagerProxy zPlanModDownloadManagerProxy, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return zPlanModDownloadManagerProxy.z(str, z16);
    }

    public static /* synthetic */ void M(ZPlanModDownloadManagerProxy zPlanModDownloadManagerProxy, String str, Integer num, Float f16, Long l3, String str2, int i3, Object obj) {
        zPlanModDownloadManagerProxy.L(str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : f16, (i3 & 8) != 0 ? null : l3, (i3 & 16) != 0 ? null : str2);
    }
}
