package cf3;

import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zplan.api.UECacheData;
import com.tencent.qphone.base.util.QLog;
import hv4.c;
import hv4.n;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ue3.d;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016R&\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\b0\fj\b\u0012\u0004\u0012\u00020\b`\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcf3/b;", "Lue3/d;", "Lhv4/d;", "result", "", "d", "e", "refreshCache", "", "cacheKey", "c", "doWhenQQLogout", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "b", "Ljava/util/HashSet;", "mDeleteKeysDuringRequest", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mRequesting", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class b implements d {

    /* renamed from: a, reason: collision with root package name */
    public static final b f30779a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static HashSet<String> mDeleteKeysDuringRequest = new HashSet<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final AtomicBoolean mRequesting = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"cf3/b$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lhv4/d;", "result", "", "a", "", "error", "", "message", "onResultFailure", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes39.dex */
    public static final class a implements e<hv4.d> {
        a() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(hv4.d result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ServerCommonCacheProvider_", 1, "refreshCache onResultSuccess");
            b bVar = b.f30779a;
            bVar.d(result);
            bVar.e();
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("ServerCommonCacheProvider_", 1, "refreshCache onResultFailure error:" + error + ", message:" + message);
            b.f30779a.e();
        }
    }

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(hv4.d result) {
        boolean z16;
        n[] nVarArr = result.f406412a;
        if (nVarArr != null) {
            if (!(nVarArr.length == 0)) {
                z16 = false;
                if (!z16) {
                    QLog.e("ServerCommonCacheProvider_", 1, "handleUEInfoRsp result.list.isNullOrEmpty");
                    return;
                }
                QLog.i("ServerCommonCacheProvider_", 1, "handleUEInfoRsp result.list size:" + nVarArr.length);
                n[] nVarArr2 = result.f406412a;
                Intrinsics.checkNotNullExpressionValue(nVarArr2, "result.list");
                for (n nVar : nVarArr2) {
                    if (mDeleteKeysDuringRequest.contains(nVar.f406474a)) {
                        QLog.e("ServerCommonCacheProvider_", 1, "handleUEInfoRsp key:" + nVar.f406474a + " was deleted during request!");
                    } else {
                        String str = nVar.f406474a;
                        Intrinsics.checkNotNullExpressionValue(str, "ueInfo.key");
                        String str2 = nVar.f406475b;
                        Intrinsics.checkNotNullExpressionValue(str2, "ueInfo.value");
                        UECacheData uECacheData = new UECacheData(str, str2, nVar.f406476c * 1000, nVar.f406477d);
                        ((ue3.b) vb3.a.f441346a.b(ue3.b.class)).V(uECacheData.getKey(), uECacheData);
                    }
                }
                ((ue3.b) vb3.a.f441346a.b(ue3.b.class)).sync();
                QLog.i("ServerCommonCacheProvider_", 1, "handleUEInfoRsp finish");
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        mRequesting.set(false);
        mDeleteKeysDuringRequest.clear();
    }

    @Override // ue3.d
    public void c(String cacheKey) {
        Intrinsics.checkNotNullParameter(cacheKey, "cacheKey");
        QLog.i("ServerCommonCacheProvider_", 1, "onDeleteHappen cacheKey:" + cacheKey);
        if (mRequesting.get()) {
            mDeleteKeysDuringRequest.add(cacheKey);
        }
    }

    @Override // ue3.d
    public void refreshCache() {
        AtomicBoolean atomicBoolean = mRequesting;
        if (atomicBoolean.get()) {
            QLog.e("ServerCommonCacheProvider_", 1, "refreshCache Requesting!");
            return;
        }
        atomicBoolean.set(true);
        QLog.i("ServerCommonCacheProvider_", 1, "refreshCache begin request.");
        mDeleteKeysDuringRequest.clear();
        df3.a.b(df3.a.f393677a, new c(), new a(), 0, 4, null);
    }

    @Override // ue3.d
    public void doWhenQQLogout() {
    }
}
