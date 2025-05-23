package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Context;
import com.tencent.mobileqq.troop.navigatebar.experiment.view.TroopAioNavResLoadUtil;
import com.tencent.qqnt.aio.adapter.api.IAIONavigationApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIONavigationApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIONavigationApi;", "Lcom/tencent/qqnt/aio/adapter/api/IAIONavigationApi$a;", "getNavCache", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/aio/adapter/api/IAIONavigationApi$b;", "callback", "", "loadNavRes", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIONavigationApiImpl implements IAIONavigationApi {
    public static final String TAG = "AIONavigationApiImpl";
    private static IAIONavigationApi.a sCache;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadNavRes$lambda$2(AIONavigationApiImpl this$0, IAIONavigationApi.b callback, TroopAioNavResLoadUtil.a aVar) {
        Unit unit;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (aVar != null) {
            IAIONavigationApi.a aVar2 = new IAIONavigationApi.a();
            aVar2.e(aVar.f297991d);
            aVar2.f(aVar.f297990c);
            aVar2.g(aVar.f297989b);
            aVar2.h(aVar.f297988a);
            sCache = aVar2;
            callback.a(aVar2);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            callback.onFailed();
        }
        TroopAioNavResLoadUtil.l(null);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIONavigationApi
    public IAIONavigationApi.a getNavCache() {
        return sCache;
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIONavigationApi
    public void loadNavRes(Context context, final IAIONavigationApi.b callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IAIONavigationApi.a aVar = sCache;
        if (aVar != null) {
            callback.a(aVar);
        } else {
            TroopAioNavResLoadUtil.l(new TroopAioNavResLoadUtil.b() { // from class: com.tencent.qqnt.aio.adapter.api.impl.q
                @Override // com.tencent.mobileqq.troop.navigatebar.experiment.view.TroopAioNavResLoadUtil.b
                public final void a(TroopAioNavResLoadUtil.a aVar2) {
                    AIONavigationApiImpl.loadNavRes$lambda$2(AIONavigationApiImpl.this, callback, aVar2);
                }
            });
            TroopAioNavResLoadUtil.j();
        }
    }
}
