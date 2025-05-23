package com.tencent.mobileqq.qqecommerce.base.somanager;

import com.tencent.ecommerce.base.somanager.api.IECLoadSoCallback;
import com.tencent.ecommerce.base.somanager.api.IECSoManager;
import com.tencent.mobileqq.kandian.biz.pts.api.IProteusSupportUtil;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/base/somanager/d;", "Lcom/tencent/ecommerce/base/somanager/api/IECSoManager;", "", "isPtsLiteSoReady", "Lcom/tencent/ecommerce/base/somanager/api/IECLoadSoCallback;", "callback", "", "loadPtsLiteSo", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class d implements IECSoManager {

    /* renamed from: a, reason: collision with root package name */
    public static final d f262484a = new d();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/qqecommerce/base/somanager/d$a", "Lb62/a;", "", "result", "", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements b62.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECLoadSoCallback f262485a;

        a(IECLoadSoCallback iECLoadSoCallback) {
            this.f262485a = iECLoadSoCallback;
        }

        @Override // b62.a
        public void a(int result) {
            com.tencent.xaction.log.b.a("ECSoLoadManager", 1, "[loadPtsLiteSo] end onLoadResult result = " + result + " callback = " + this.f262485a);
            this.f262485a.loadResult(result);
        }
    }

    d() {
    }

    @Override // com.tencent.ecommerce.base.somanager.api.IECSoManager
    public boolean isPtsLiteSoReady() {
        return ((IProteusSupportUtil) QRoute.api(IProteusSupportUtil.class)).isPtsLiteSoReady();
    }

    @Override // com.tencent.ecommerce.base.somanager.api.IECSoManager
    public void loadPtsLiteSo(IECLoadSoCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        com.tencent.xaction.log.b.a("ECSoLoadManager", 1, "[loadPtsLiteSo] begin");
        ((IProteusSupportUtil) QRoute.api(IProteusSupportUtil.class)).initPtsLite(new a(callback));
    }
}
