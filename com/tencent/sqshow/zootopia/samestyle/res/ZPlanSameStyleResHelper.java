package com.tencent.sqshow.zootopia.samestyle.res;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadReq;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadUrlRsp;
import com.tencent.mobileqq.zootopia.ipc.e;
import com.tencent.mobileqq.zplan.ipc.api.IZPlanIPCHelper;
import com.tencent.mobileqq.zplan.model.ZPlanUEResInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.samestyle.res.ZPlanSameStyleResHelper;
import com.tencent.zplan.common.utils.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import ji3.n;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nx4.a;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001,B\t\b\u0002\u00a2\u0006\u0004\b*\u0010+J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0016\u0010\u0013\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0006\u0010\u0018\u001a\u00020\u0017J\u001a\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u001b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tR$\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00030\u001cj\b\u0012\u0004\u0012\u00020\u0003`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\"0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\t0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/res/ZPlanSameStyleResHelper;", "", "", "", "resPathList", "Lcom/tencent/sqshow/zootopia/samestyle/res/ZPlanSameStyleResHelper$a;", "batchDownloadResult", "", "j", "Lji3/n;", "listener", "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, ReportConstant.COSTREPORT_PREFIX, "", "errorCode", "t", "Lkotlin/Function0;", "callback", DomainData.DOMAIN_NAME, "msg", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "p", "fromSource", "k", "u", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "b", "Ljava/util/ArrayList;", "SAME_STYLE_BS_PATH_LIST", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/zplan/model/ZPlanUEResInfo;", "c", "Ljava/util/concurrent/ConcurrentHashMap;", "bsResCacheMap", "Ljava/util/concurrent/CopyOnWriteArrayList;", "d", "Ljava/util/concurrent/CopyOnWriteArrayList;", "listenerList", "<init>", "()V", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanSameStyleResHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final ZPlanSameStyleResHelper f372974a = new ZPlanSameStyleResHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<String> SAME_STYLE_BS_PATH_LIST;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final ConcurrentHashMap<String, ZPlanUEResInfo> bsResCacheMap;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final CopyOnWriteArrayList<n> listenerList;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0082\b\u0018\u00002\u00020\u0001B3\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t\u0012\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR#\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/res/ZPlanSameStyleResHelper$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/concurrent/ConcurrentHashMap;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "b", "()Ljava/util/concurrent/ConcurrentHashMap;", "successMap", "errorMap", "<init>", "(Ljava/util/concurrent/ConcurrentHashMap;Ljava/util/concurrent/ConcurrentHashMap;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.samestyle.res.ZPlanSameStyleResHelper$a, reason: from toString */
    /* loaded from: classes34.dex */
    public static final /* data */ class BatchDownloadResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final ConcurrentHashMap<String, String> successMap;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final ConcurrentHashMap<String, Integer> errorMap;

        public BatchDownloadResult() {
            this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }

        public final ConcurrentHashMap<String, Integer> a() {
            return this.errorMap;
        }

        public final ConcurrentHashMap<String, String> b() {
            return this.successMap;
        }

        public int hashCode() {
            return (this.successMap.hashCode() * 31) + this.errorMap.hashCode();
        }

        public String toString() {
            return "BatchDownloadResult(successMap=" + this.successMap + ", errorMap=" + this.errorMap + ")";
        }

        public BatchDownloadResult(ConcurrentHashMap<String, String> successMap, ConcurrentHashMap<String, Integer> errorMap) {
            Intrinsics.checkNotNullParameter(successMap, "successMap");
            Intrinsics.checkNotNullParameter(errorMap, "errorMap");
            this.successMap = successMap;
            this.errorMap = errorMap;
        }

        public /* synthetic */ BatchDownloadResult(ConcurrentHashMap concurrentHashMap, ConcurrentHashMap concurrentHashMap2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? new ConcurrentHashMap() : concurrentHashMap, (i3 & 2) != 0 ? new ConcurrentHashMap() : concurrentHashMap2);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BatchDownloadResult)) {
                return false;
            }
            BatchDownloadResult batchDownloadResult = (BatchDownloadResult) other;
            return Intrinsics.areEqual(this.successMap, batchDownloadResult.successMap) && Intrinsics.areEqual(this.errorMap, batchDownloadResult.errorMap);
        }
    }

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("CMShow/Assets/AnimationUnpak/Morphs/SK_CH_Face");
        arrayList.add("CMShow/Assets/AnimationUnpak/Morphs/SK_CH_Face_AI");
        SAME_STYLE_BS_PATH_LIST = arrayList;
        bsResCacheMap = new ConcurrentHashMap<>();
        listenerList = new CopyOnWriteArrayList<>();
    }

    ZPlanSameStyleResHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(List<String> resPathList, BatchDownloadResult batchDownloadResult) {
        r("checkResBatchDownloadResult, successSize= " + batchDownloadResult.b().size() + ", errSize= " + batchDownloadResult.a().size());
        if (resPathList.size() == batchDownloadResult.b().size() + batchDownloadResult.a().size()) {
            r("checkResBatchDownloadResult, FINISH");
            if (batchDownloadResult.a().isEmpty()) {
                s();
            } else {
                Integer nextElement = batchDownloadResult.a().elements().nextElement();
                t(nextElement == null ? -1 : nextElement.intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        listenerList.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(final Function0<Unit> callback) {
        if (Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) {
            callback.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.res.a
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanSameStyleResHelper.o(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function0 callback) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(String msg2) {
        QLog.e("ZPlanSameStyleResHelper_BS", 1, msg2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(String msg2) {
        QLog.i("ZPlanSameStyleResHelper_BS", 1, msg2);
    }

    private final void s() {
        n(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.samestyle.res.ZPlanSameStyleResHelper$notifyAllReady$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CopyOnWriteArrayList copyOnWriteArrayList;
                CopyOnWriteArrayList copyOnWriteArrayList2;
                String str;
                CopyOnWriteArrayList copyOnWriteArrayList3;
                CopyOnWriteArrayList copyOnWriteArrayList4;
                ZPlanSameStyleResHelper zPlanSameStyleResHelper = ZPlanSameStyleResHelper.f372974a;
                copyOnWriteArrayList = ZPlanSameStyleResHelper.listenerList;
                int size = copyOnWriteArrayList.size();
                copyOnWriteArrayList2 = ZPlanSameStyleResHelper.listenerList;
                if (copyOnWriteArrayList2.size() == 1) {
                    copyOnWriteArrayList4 = ZPlanSameStyleResHelper.listenerList;
                    str = " - " + copyOnWriteArrayList4.get(0);
                } else {
                    str = "";
                }
                zPlanSameStyleResHelper.r("notifyAllReady - listener.size = " + size + str);
                ArrayList arrayList = new ArrayList();
                copyOnWriteArrayList3 = ZPlanSameStyleResHelper.listenerList;
                arrayList.addAll(copyOnWriteArrayList3);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).a();
                }
                ZPlanSameStyleResHelper.f372974a.m();
            }
        });
    }

    private final void t(final int errorCode) {
        n(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.samestyle.res.ZPlanSameStyleResHelper$notifyError$1
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
                CopyOnWriteArrayList copyOnWriteArrayList;
                CopyOnWriteArrayList copyOnWriteArrayList2;
                String str;
                CopyOnWriteArrayList copyOnWriteArrayList3;
                CopyOnWriteArrayList copyOnWriteArrayList4;
                ZPlanSameStyleResHelper zPlanSameStyleResHelper = ZPlanSameStyleResHelper.f372974a;
                int i3 = errorCode;
                copyOnWriteArrayList = ZPlanSameStyleResHelper.listenerList;
                int size = copyOnWriteArrayList.size();
                copyOnWriteArrayList2 = ZPlanSameStyleResHelper.listenerList;
                if (copyOnWriteArrayList2.size() == 1) {
                    copyOnWriteArrayList4 = ZPlanSameStyleResHelper.listenerList;
                    str = " - " + copyOnWriteArrayList4.get(0);
                } else {
                    str = "";
                }
                zPlanSameStyleResHelper.q("notifyError - " + i3 + " - listener.size = " + size + str);
                ArrayList arrayList = new ArrayList();
                copyOnWriteArrayList3 = ZPlanSameStyleResHelper.listenerList;
                arrayList.addAll(copyOnWriteArrayList3);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((n) it.next()).onDownloadFail(errorCode);
                }
                ZPlanSameStyleResHelper.f372974a.m();
            }
        });
    }

    public final void k(String fromSource, n listener) {
        Intrinsics.checkNotNullParameter(fromSource, "fromSource");
        r(fromSource + "  checkSameStyleRes BEGIN - " + listener);
        i(listener);
        if (p()) {
            r("use local cache, callback immediately");
            s();
            return;
        }
        final BatchDownloadResult batchDownloadResult = new BatchDownloadResult(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        final ArrayList<String> arrayList = SAME_STYLE_BS_PATH_LIST;
        for (final String str : arrayList) {
            ((IZPlanIPCHelper) QRoute.api(IZPlanIPCHelper.class)).downloadRemoteManagerDownloadResByPath(new ZPlanResDownloadReq(str, null, null, 6, null), new e() { // from class: com.tencent.sqshow.zootopia.samestyle.res.ZPlanSameStyleResHelper$checkSameStyleRes$1$1
                @Override // com.tencent.mobileqq.zootopia.ipc.e
                public void a(final int errorCode, String errorMessage) {
                    ZPlanSameStyleResHelper zPlanSameStyleResHelper = ZPlanSameStyleResHelper.f372974a;
                    zPlanSameStyleResHelper.q(str + " - checkSameStyleRes#onGetDownloadUrlError, " + errorCode + " - " + errorMessage);
                    final ZPlanSameStyleResHelper.BatchDownloadResult batchDownloadResult2 = batchDownloadResult;
                    final String str2 = str;
                    final ArrayList<String> arrayList2 = arrayList;
                    zPlanSameStyleResHelper.n(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.samestyle.res.ZPlanSameStyleResHelper$checkSameStyleRes$1$1$onGetDownloadUrlError$1
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
                            ZPlanSameStyleResHelper.BatchDownloadResult.this.a().put(str2, Integer.valueOf(errorCode));
                            ZPlanSameStyleResHelper.f372974a.j(arrayList2, ZPlanSameStyleResHelper.BatchDownloadResult.this);
                        }
                    });
                }

                @Override // com.tencent.mobileqq.zootopia.ipc.e
                public void b(int statusCode, final String filePath, a.b result, final ZPlanResDownloadUrlRsp urlRspInfo) {
                    Intrinsics.checkNotNullParameter(urlRspInfo, "urlRspInfo");
                    ZPlanSameStyleResHelper zPlanSameStyleResHelper = ZPlanSameStyleResHelper.f372974a;
                    zPlanSameStyleResHelper.r(str + " - checkSameStyleRes#onDownloadSucceed, " + filePath);
                    final ZPlanSameStyleResHelper.BatchDownloadResult batchDownloadResult2 = batchDownloadResult;
                    final String str2 = str;
                    final ArrayList<String> arrayList2 = arrayList;
                    zPlanSameStyleResHelper.n(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.samestyle.res.ZPlanSameStyleResHelper$checkSameStyleRes$1$1$onDownloadSucceed$1
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
                            ConcurrentHashMap concurrentHashMap;
                            ConcurrentHashMap<String, String> b16 = ZPlanSameStyleResHelper.BatchDownloadResult.this.b();
                            String str3 = str2;
                            String str4 = filePath;
                            if (str4 == null) {
                                str4 = "";
                            }
                            b16.put(str3, str4);
                            concurrentHashMap = ZPlanSameStyleResHelper.bsResCacheMap;
                            String str5 = str2;
                            String fullUrl = urlRspInfo.getFullUrl();
                            String str6 = filePath;
                            concurrentHashMap.put(str5, new ZPlanUEResInfo(str5, fullUrl, str6 != null ? str6 : "", urlRspInfo.getMd5()));
                            ZPlanSameStyleResHelper.f372974a.j(arrayList2, ZPlanSameStyleResHelper.BatchDownloadResult.this);
                        }
                    });
                }

                @Override // com.tencent.mobileqq.zootopia.ipc.e
                public void onDownloadFailed(final int errorCode, String errorMessage) {
                    ZPlanSameStyleResHelper zPlanSameStyleResHelper = ZPlanSameStyleResHelper.f372974a;
                    zPlanSameStyleResHelper.q(str + " - checkSameStyleRes#onDownloadFailed, " + errorCode + " - " + errorMessage);
                    final ZPlanSameStyleResHelper.BatchDownloadResult batchDownloadResult2 = batchDownloadResult;
                    final String str2 = str;
                    final ArrayList<String> arrayList2 = arrayList;
                    zPlanSameStyleResHelper.n(new Function0<Unit>() { // from class: com.tencent.sqshow.zootopia.samestyle.res.ZPlanSameStyleResHelper$checkSameStyleRes$1$1$onDownloadFailed$1
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
                            ZPlanSameStyleResHelper.BatchDownloadResult.this.a().put(str2, Integer.valueOf(errorCode));
                            ZPlanSameStyleResHelper.f372974a.j(arrayList2, ZPlanSameStyleResHelper.BatchDownloadResult.this);
                        }
                    });
                }
            });
        }
    }

    public final boolean p() {
        for (String str : SAME_STYLE_BS_PATH_LIST) {
            ZPlanUEResInfo zPlanUEResInfo = bsResCacheMap.get(str);
            String localFilePath = zPlanUEResInfo != null ? zPlanUEResInfo.getLocalFilePath() : null;
            if (TextUtils.isEmpty(localFilePath) || !c.f385288a.h(localFilePath)) {
                f372974a.r("isUEBsResourceReady false, path= " + str + " - localPath= " + localFilePath);
                return false;
            }
        }
        r("isUEBsResourceReady true");
        return true;
    }

    private final void i(n listener) {
        if (listener != null) {
            CopyOnWriteArrayList<n> copyOnWriteArrayList = listenerList;
            if (copyOnWriteArrayList.contains(listener)) {
                return;
            }
            copyOnWriteArrayList.add(listener);
        }
    }

    public final void u(n listener) {
        if (listener != null) {
            CopyOnWriteArrayList<n> copyOnWriteArrayList = listenerList;
            if (copyOnWriteArrayList.contains(listener)) {
                copyOnWriteArrayList.remove(listener);
            }
        }
    }

    public static /* synthetic */ void l(ZPlanSameStyleResHelper zPlanSameStyleResHelper, String str, n nVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            nVar = null;
        }
        zPlanSameStyleResHelper.k(str, nVar);
    }
}
