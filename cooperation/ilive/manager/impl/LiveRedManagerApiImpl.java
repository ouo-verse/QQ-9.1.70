package cooperation.ilive.manager.impl;

import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.util.Pair;
import cooperation.ilive.manager.ILiveRedManagerApi;
import cooperation.ilive.manager.IliveRedManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0016\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcooperation/ilive/manager/impl/LiveRedManagerApiImpl;", "Lcooperation/ilive/manager/ILiveRedManagerApi;", "()V", "getDrawerLiveReportStr2", "", "appInfo", "Lcom/tencent/mobileqq/tianshu/pb/BusinessInfoCheckUpdate$AppInfo;", "getIliveRecomRedInfo", "Lcom/tencent/util/Pair;", "getRedAdId", "", "isRecomRedJumpUrl", "", "shopJumpUrl", "parseShopRedBuffer", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes28.dex */
public final class LiveRedManagerApiImpl implements ILiveRedManagerApi {
    @Override // cooperation.ilive.manager.ILiveRedManagerApi
    @NotNull
    public String getDrawerLiveReportStr2(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo) {
        String drawerLiveReportStr2 = IliveRedManager.getDrawerLiveReportStr2(appInfo);
        Intrinsics.checkNotNullExpressionValue(drawerLiveReportStr2, "getDrawerLiveReportStr2(appInfo)");
        return drawerLiveReportStr2;
    }

    @Override // cooperation.ilive.manager.ILiveRedManagerApi
    @Nullable
    public Pair<String, String> getIliveRecomRedInfo() {
        return IliveRedManager.getIliveRecomRedInfo();
    }

    @Override // cooperation.ilive.manager.ILiveRedManagerApi
    public long getRedAdId(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo) {
        return IliveRedManager.getRedAdId(appInfo);
    }

    @Override // cooperation.ilive.manager.ILiveRedManagerApi
    public boolean isRecomRedJumpUrl(@Nullable String shopJumpUrl) {
        return IliveRedManager.isRecomRedJumpUrl(shopJumpUrl);
    }

    @Override // cooperation.ilive.manager.ILiveRedManagerApi
    @Nullable
    public String parseShopRedBuffer(@Nullable BusinessInfoCheckUpdate.AppInfo appInfo) {
        return IliveRedManager.parseShopRedBuffer(appInfo);
    }
}
