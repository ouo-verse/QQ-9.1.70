package ff2;

import com.tencent.ecommerce.base.ticket.api.IECPSKeyCallback;
import com.tencent.ecommerce.base.ticket.api.IECTicketManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import yg0.ECPsKey;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J7\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ%\u0010\u000e\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\u0010\u001a\u00020\r2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016\u00a2\u0006\u0004\b\u0010\u0010\u000fJ\b\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0016"}, d2 = {"Lff2/a;", "Lcom/tencent/ecommerce/base/ticket/api/IECTicketManager;", "", "", "domains", "", "domainToPsKeyMap", "", "Lyg0/b;", "b", "([Ljava/lang/String;Ljava/util/Map;)Ljava/util/List;", "Lcom/tencent/ecommerce/base/ticket/api/IECPSKeyCallback;", "callback", "", "getPsKeysAsync", "([Ljava/lang/String;Lcom/tencent/ecommerce/base/ticket/api/IECPSKeyCallback;)V", "getPsKeysAsyncNoCache", "", "getServerTimeMillis", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IECTicketManager {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"ff2/a$b", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements sd2.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String[] f398563b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IECPSKeyCallback f398564c;

        b(String[] strArr, IECPSKeyCallback iECPSKeyCallback) {
            this.f398563b = strArr;
            this.f398564c = iECPSKeyCallback;
        }

        @Override // sd2.a
        public void onFail(String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("ECTicket", 1, "getPsKey Failed errMsg:" + errMsg);
            this.f398564c.onFailed(errMsg);
        }

        @Override // sd2.a
        public void onSuccess(Map<String, String> domainToKeyMap) {
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            List<ECPsKey> b16 = a.this.b(this.f398563b, domainToKeyMap);
            QLog.d("ECTicket", 1, "getPsKey Success");
            this.f398564c.onSuccess(b16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0003H\u0016\u00a8\u0006\t"}, d2 = {"ff2/a$c", "Lsd2/a;", "", "", "domainToKeyMap", "", "onSuccess", "errMsg", "onFail", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class c implements sd2.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String[] f398566b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ IECPSKeyCallback f398567c;

        c(String[] strArr, IECPSKeyCallback iECPSKeyCallback) {
            this.f398566b = strArr;
            this.f398567c = iECPSKeyCallback;
        }

        @Override // sd2.a
        public void onFail(String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            QLog.e("ECTicket", 1, "getPsKeysAsyncNoCache Failed errMsg:" + errMsg);
            this.f398567c.onFailed(errMsg);
        }

        @Override // sd2.a
        public void onSuccess(Map<String, String> domainToKeyMap) {
            Intrinsics.checkNotNullParameter(domainToKeyMap, "domainToKeyMap");
            List<ECPsKey> b16 = a.this.b(this.f398566b, domainToKeyMap);
            QLog.d("ECTicket", 1, "getPsKeysAsyncNoCache Success");
            this.f398567c.onSuccess(b16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ECPsKey> b(String[] domains, Map<String, String> domainToPsKeyMap) {
        ArrayList arrayList = new ArrayList();
        for (String str : domains) {
            arrayList.add(new ECPsKey(str, domainToPsKeyMap.get(str), false));
        }
        return arrayList;
    }

    @Override // com.tencent.ecommerce.base.ticket.api.IECTicketManager
    public void getPsKeysAsync(String[] domains, IECPSKeyCallback callback) {
        Intrinsics.checkNotNullParameter(domains, "domains");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String arrays = Arrays.toString(domains);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        QLog.d("ECTicket", 1, "getPsKeysAsync,domains:" + arrays);
        QQAppInterface b16 = ECRuntimeManager.INSTANCE.b();
        if (b16 == null) {
            QLog.e("ECTicket", 2, "getPsKeysAsync | app is null");
            callback.onFailed("appInterface is null");
        } else {
            if (!b16.isLogin()) {
                QLog.e("ECTicket", 2, "getPsKeysAsync | app not login");
                callback.onFailed("not login");
                return;
            }
            Object[] copyOf = Arrays.copyOf(domains, domains.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
            IRuntimeService runtimeService = b16.getRuntimeService(IPskeyManager.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026essConstant.ALL\n        )");
            ((IPskeyManager) runtimeService).getPskey((String[]) copyOf, new b(domains, callback));
        }
    }

    @Override // com.tencent.ecommerce.base.ticket.api.IECTicketManager
    public void getPsKeysAsyncNoCache(String[] domains, IECPSKeyCallback callback) {
        Intrinsics.checkNotNullParameter(domains, "domains");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String arrays = Arrays.toString(domains);
        Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
        QLog.d("ECTicket", 1, "getPsKeysAsyncNoCache,domains:" + arrays);
        QQAppInterface b16 = ECRuntimeManager.INSTANCE.b();
        if (b16 == null) {
            QLog.e("ECTicket", 2, "getPsKeysAsync | app is null");
            callback.onFailed("appInterface is null");
        } else {
            if (!b16.isLogin()) {
                QLog.e("ECTicket", 2, "getPsKeysAsync | app not login");
                callback.onFailed("not login");
                return;
            }
            Object[] copyOf = Arrays.copyOf(domains, domains.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
            IRuntimeService runtimeService = b16.getRuntimeService(IPskeyManager.class, "all");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026essConstant.ALL\n        )");
            ((IPskeyManager) runtimeService).replacePskey((String[]) copyOf, new c(domains, callback));
        }
    }

    @Override // com.tencent.ecommerce.base.ticket.api.IECTicketManager
    public long getServerTimeMillis() {
        return NetConnInfoCenter.getServerTimeMillis();
    }
}
