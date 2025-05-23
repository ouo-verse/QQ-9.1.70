package com.tencent.qqnt.aio.helper;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.animation.api.IAioAnimationApi;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/qqnt/aio/helper/AIOAnimationHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "", "onCreate", "state", "onMoveToState", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Landroid/os/Handler;", "e", "Landroid/os/Handler;", "mainThreadHandler", "<init>", "()V", "f", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes34.dex */
public final class AIOAnimationHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c() {
        IAioAnimationApi iAioAnimationApi = (IAioAnimationApi) QRoute.api(IAioAnimationApi.class);
        com.tencent.mobileqq.aio.config.a b16 = com.tencent.mobileqq.aio.config.a.INSTANCE.b();
        if (b16.d()) {
            iAioAnimationApi.updateConfig(b16.b(), b16.a());
        }
        iAioAnimationApi.updateResourceIfConfigChanged();
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350628e;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "AIOAnimationHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        QLog.i("AIOAnimationHelper", 1, "onCreate");
        this.aioContext = param.a();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onDestroy() {
        h.a.b(this);
        QLog.i("AIOAnimationHelper", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        QLog.i("AIOAnimationHelper", 1, "onMoveToState state=" + state);
        if (state == 0) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.aio.helper.a
                @Override // java.lang.Runnable
                public final void run() {
                    AIOAnimationHelper.c();
                }
            }, 16, null, true);
            ((IAioAnimationApi) QRoute.api(IAioAnimationApi.class)).setTroopInfoDelegate(new u71.a() { // from class: com.tencent.qqnt.aio.helper.AIOAnimationHelper$onMoveToState$2
                @Override // u71.a
                public boolean a(String troopUin) {
                    Intrinsics.checkNotNullParameter(troopUin, "troopUin");
                    return false;
                }

                @Override // u71.a
                public void b(String memberUin, String troopUin, Function1<? super Boolean, Unit> callback) {
                    com.tencent.aio.api.runtime.a aVar;
                    Intrinsics.checkNotNullParameter(memberUin, "memberUin");
                    Intrinsics.checkNotNullParameter(troopUin, "troopUin");
                    Intrinsics.checkNotNullParameter(callback, "callback");
                    QLog.i("AIOAnimationHelper", 1, "getDragonKingInfo memberUin=" + memberUin + " troopUin=" + troopUin);
                    aVar = AIOAnimationHelper.this.aioContext;
                    if (aVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("aioContext");
                        aVar = null;
                    }
                    Lifecycle lifecycle = aVar.d().getLifecycle();
                    Intrinsics.checkNotNullExpressionValue(lifecycle, "aioContext.lifecycleOwner.lifecycle");
                    BuildersKt__Builders_commonKt.launch$default(LifecycleKt.getCoroutineScope(lifecycle), null, null, new AIOAnimationHelper$onMoveToState$2$getDragonKingInfo$1(troopUin, memberUin, callback, null), 3, null);
                }

                @Override // u71.a
                public boolean c() {
                    return true;
                }
            });
        }
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 12};
    }
}
