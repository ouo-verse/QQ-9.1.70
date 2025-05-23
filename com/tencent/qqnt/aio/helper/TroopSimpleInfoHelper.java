package com.tencent.qqnt.aio.helper;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopListRepoApi;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/qqnt/aio/helper/TroopSimpleInfoHelper;", "Lcom/tencent/aio/main/businesshelper/h;", "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "c", "", "e", "", "getId", "", "getTag", "", "interestedIn", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "state", "onMoveToState", "d", "Ljava/lang/String;", "peerUid", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "<init>", "()V", "f", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TroopSimpleInfoHelper implements com.tencent.aio.main.businesshelper.h {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String peerUid;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LifecycleOwner lifecycleOwner;

    /* JADX INFO: Access modifiers changed from: private */
    public final AppRuntime c() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private final void e() {
        String str;
        QRouteApi api = QRoute.api(ITroopListRepoApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopListRepoApi::class.java)");
        ITroopListRepoApi iTroopListRepoApi = (ITroopListRepoApi) api;
        String str2 = this.peerUid;
        LifecycleOwner lifecycleOwner = null;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUid");
            str = null;
        } else {
            str = str2;
        }
        if (ITroopListRepoApi.a.b(iTroopListRepoApi, str, "TroopSimpleInfoHelper", false, 4, null) && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("102927", true)) {
            return;
        }
        ITroopInfoRepoApi iTroopInfoRepoApi = (ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class);
        String str3 = this.peerUid;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("peerUid");
            str3 = null;
        }
        LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
        if (lifecycleOwner2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
        } else {
            lifecycleOwner = lifecycleOwner2;
        }
        iTroopInfoRepoApi.fetchTroopInfoForAIO(str3, "TroopSimpleInfoHelper", lifecycleOwner, new TroopSimpleInfoHelper$getSimpleInfo$1(this));
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.O;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "TroopSimpleInfoHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        this.peerUid = param.a().g().r().c().j();
        LifecycleOwner d16 = param.a().d();
        Intrinsics.checkNotNullExpressionValue(d16, "param.aioContext.lifecycleOwner");
        this.lifecycleOwner = d16;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{12, 1};
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        if (state == 1) {
            e();
        }
    }
}
