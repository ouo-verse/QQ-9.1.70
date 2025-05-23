package pg3;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.qphone.base.util.QLog;
import iw4.c;
import iw4.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pu4.o;
import pu4.p;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\u0002J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\tJ\u001e\u0010\u0010\u001a\u00020\u00042\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t\u0018\u00010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lpg3/a;", "", "Liw4/d;", "rsp", "", "j", "g", h.F, "f", "", "Lpu4/o;", "d", "Lpu4/p;", "e", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", "i", "b", "Liw4/d;", "selfClothesInfoCache", "", "c", "Z", "isRequesting", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f426176a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static d selfClothesInfoCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean isRequesting;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"pg3/a$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Liw4/d;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: pg3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public static final class C11014a implements e<d> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e<List<p>> f426179d;

        C11014a(e<List<p>> eVar) {
            this.f426179d = eVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0044, code lost:
        
            r4 = kotlin.collections.ArraysKt___ArraysKt.toList(r4);
         */
        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onResultSuccess(d result) {
            List<p> arrayList;
            Intrinsics.checkNotNullParameter(result, "result");
            p[] pVarArr = result.f408880a;
            QLog.i("ZPlanClothesHelper", 1, "requestSelfClothesInfo#onResultSuccess, size = " + (pVarArr != null ? Integer.valueOf(pVarArr.length) : null) + "");
            a.isRequesting = false;
            a.selfClothesInfoCache = result;
            a.f426176a.j(result);
            e<List<p>> eVar = this.f426179d;
            if (eVar != null) {
                p[] pVarArr2 = result.f408880a;
                if (pVarArr2 == null || arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                eVar.onResultSuccess(arrayList);
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ZPlanClothesHelper", 1, "requestSelfClothesInfo#onResultFailure, " + error + " - " + message);
            a.isRequesting = false;
            e<List<p>> eVar = this.f426179d;
            if (eVar != null) {
                eVar.onResultFailure(error, message);
            }
        }
    }

    a() {
    }

    private final d g() {
        byte[] bytes = ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBytes("zplan_self_clothes_info", new byte[0]);
        if (!(!(bytes.length == 0))) {
            return null;
        }
        try {
            return d.c(bytes);
        } catch (Exception e16) {
            QLog.e("ZPlanClothesHelper", 1, "readFromSp, parse exception", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(d rsp) {
        try {
            IZPlanMMKVApi iZPlanMMKVApi = (IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class);
            byte[] byteArray = MessageNano.toByteArray(rsp);
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(rsp)");
            iZPlanMMKVApi.setBytes("zplan_self_clothes_info", byteArray);
        } catch (Exception e16) {
            QLog.e("ZPlanClothesHelper", 1, "updateToSp exception", e16);
        }
    }

    public final List<o> d() {
        ArrayList arrayList = new ArrayList();
        for (p pVar : e()) {
            o oVar = new o();
            oVar.f427504a = pVar.f427507a;
            oVar.f427505b = pVar.f427512f;
            arrayList.add(oVar);
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        r0 = kotlin.collections.ArraysKt___ArraysKt.toList(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<p> e() {
        List<p> list;
        if (selfClothesInfoCache == null) {
            selfClothesInfoCache = g();
        }
        d dVar = selfClothesInfoCache;
        return (dVar == null || (r0 = dVar.f408880a) == null || list == null) ? new ArrayList() : list;
    }

    public final d f() {
        if (selfClothesInfoCache == null) {
            selfClothesInfoCache = g();
        }
        return selfClothesInfoCache;
    }

    public final void i(e<List<p>> callback) {
        if (isRequesting) {
            QLog.i("ZPlanClothesHelper", 1, "requestSelfClothesInfo isRequesting");
            return;
        }
        isRequesting = true;
        QLog.i("ZPlanClothesHelper", 1, "requestSelfClothesInfo#BEGIN");
        yb4.a.b(yb4.a.f450048a, new c(), new C11014a(callback), 0, 4, null);
    }

    public final void h() {
        QLog.i("ZPlanClothesHelper", 1, "refreshClothesCache");
        selfClothesInfoCache = g();
    }
}
