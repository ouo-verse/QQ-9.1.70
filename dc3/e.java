package dc3;

import com.epicgames.ue4.ZPlanVersion;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadReq;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadUrlRsp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ab;
import hv4.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0002J\"\u0010\u000f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J,\u0010\u0018\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\u0014\u0010\u0017\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\rH\u0016R(\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Ldc3/e;", "Ldc3/d;", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadReq;", "", "Lcom/tencent/mobileqq/z1/download/ZPlanResDownloadUrlRsp;", "params", "", "u", "param", "ret", "t", "", "errorCode", "", "errorMessage", ReportConstant.COSTREPORT_PREFIX, "logMsg", "r", "Lqb3/a;", "listener", "v", "requestList", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "g", DomainData.DOMAIN_NAME, "Ljava/util/concurrent/ConcurrentHashMap;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "requestUrlListener", "<init>", "()V", "f", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends d<ZPlanResDownloadReq, List<? extends ZPlanResDownloadUrlRsp>> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ConcurrentHashMap<String, CopyOnWriteArrayList<qb3.a>> requestUrlListener = new ConcurrentHashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"dc3/e$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhv4/b;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<hv4.b> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<ZPlanResDownloadReq> f393597d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f393598e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<List<ZPlanResDownloadUrlRsp>> f393599f;

        b(List<ZPlanResDownloadReq> list, e eVar, com.tencent.mobileqq.zootopia.api.e<List<ZPlanResDownloadUrlRsp>> eVar2) {
            this.f393597d = list;
            this.f393598e = eVar;
            this.f393599f = eVar2;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(hv4.b result) {
            Intrinsics.checkNotNullParameter(result, "result");
            HashMap hashMap = new HashMap();
            j[] jVarArr = result.f406410c;
            if (jVarArr != null) {
                for (j it : jVarArr) {
                    String str = it.f406438b;
                    Intrinsics.checkNotNullExpressionValue(str, "it.path");
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    hashMap.put(str, it);
                }
            }
            ArrayList arrayList = new ArrayList();
            for (ZPlanResDownloadReq zPlanResDownloadReq : this.f393597d) {
                j jVar = hashMap.containsKey(zPlanResDownloadReq.getPath()) ? (j) hashMap.get(zPlanResDownloadReq.getPath()) : null;
                if (jVar == null) {
                    this.f393598e.s(zPlanResDownloadReq, -99001, "net success but not found");
                } else {
                    String str2 = jVar.f406437a;
                    Intrinsics.checkNotNullExpressionValue(str2, "foundItem.url");
                    String str3 = jVar.f406439c;
                    Intrinsics.checkNotNullExpressionValue(str3, "foundItem.md5");
                    String str4 = jVar.f406438b;
                    Intrinsics.checkNotNullExpressionValue(str4, "foundItem.path");
                    ZPlanResDownloadUrlRsp zPlanResDownloadUrlRsp = new ZPlanResDownloadUrlRsp(str2, str3, str4);
                    arrayList.add(zPlanResDownloadUrlRsp);
                    this.f393598e.t(zPlanResDownloadReq, zPlanResDownloadUrlRsp);
                }
            }
            com.tencent.mobileqq.zootopia.api.e<List<ZPlanResDownloadUrlRsp>> eVar = this.f393599f;
            if (eVar != null) {
                eVar.onResultSuccess(arrayList);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            Iterator<ZPlanResDownloadReq> it = this.f393597d.iterator();
            while (it.hasNext()) {
                this.f393598e.s(it.next(), error, message);
            }
            com.tencent.mobileqq.zootopia.api.e<List<ZPlanResDownloadUrlRsp>> eVar = this.f393599f;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }
    }

    private final void r(String logMsg) {
        QLog.i(n(), 1, logMsg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(ZPlanResDownloadReq param, int errorCode, String errorMessage) {
        String uniqueKey = param.getUniqueKey();
        CopyOnWriteArrayList<qb3.a> copyOnWriteArrayList = this.requestUrlListener.get(uniqueKey);
        if (copyOnWriteArrayList != null) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((qb3.a) it.next()).a(errorCode, errorMessage);
            }
        }
        this.requestUrlListener.remove(uniqueKey);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(ZPlanResDownloadReq param, ZPlanResDownloadUrlRsp ret) {
        String uniqueKey = param.getUniqueKey();
        CopyOnWriteArrayList<qb3.a> copyOnWriteArrayList = this.requestUrlListener.get(uniqueKey);
        if (copyOnWriteArrayList != null) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((qb3.a) it.next()).b(ret);
            }
        }
        this.requestUrlListener.remove(uniqueKey);
    }

    @Override // dc3.d
    public void g(List<? extends ZPlanResDownloadReq> requestList, com.tencent.mobileqq.zootopia.api.e<List<? extends ZPlanResDownloadUrlRsp>> callback) {
        Intrinsics.checkNotNullParameter(requestList, "requestList");
        hv4.a aVar = new hv4.a();
        if (!requestList.isEmpty()) {
            aVar.f406405a = ab.INSTANCE.d();
            aVar.f406406b = ZPlanVersion.ZPlanVersion;
            ArrayList arrayList = new ArrayList();
            Iterator<? extends ZPlanResDownloadReq> it = requestList.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getPath());
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            aVar.f406407c = (String[]) array;
        }
        f.b(f.f393600a, aVar, new b(requestList, this, callback), 0, 4, null);
    }

    @Override // dc3.d
    public String n() {
        return "ZPlanResProxyDownload_GatherLoader_";
    }

    public final void v(ZPlanResDownloadReq param, qb3.a listener) {
        Intrinsics.checkNotNullParameter(param, "param");
        String uniqueKey = param.getUniqueKey();
        CopyOnWriteArrayList<qb3.a> copyOnWriteArrayList = this.requestUrlListener.get(uniqueKey);
        if (copyOnWriteArrayList == null) {
            CopyOnWriteArrayList<qb3.a> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            this.requestUrlListener.put(uniqueKey, copyOnWriteArrayList2);
            r("newListenerList, requestSingleData ZPlanResDownloadReq@" + param.hashCode() + " - " + uniqueKey);
            copyOnWriteArrayList2.add(listener);
            u(param);
            return;
        }
        r("listenerList already exist!!!");
        if (copyOnWriteArrayList.contains(listener)) {
            return;
        }
        copyOnWriteArrayList.add(listener);
    }

    private final void u(ZPlanResDownloadReq params) {
        List mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(params);
        k(mutableListOf, false);
    }
}
