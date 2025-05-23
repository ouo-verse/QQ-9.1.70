package com.tencent.mobileqq.zplan.persistent.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import ji3.f;
import ji3.g;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bg\u0018\u00002\u00020\u0001:\u0001\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J*\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0006H&J$\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000bH&J\u001a\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0015H&J \u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u0017H&J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H&J\u0013\u0010\u001c\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u001e\u001a\u00020\u000eH&J\b\u0010\u001f\u001a\u00020\u000eH&J\u0018\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/zplan/persistent/api/IZPlanDataHelper;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "uin", "Lcom/tencent/mobileqq/zplan/model/ZPlanUserInfo;", "getUserZPlanInfo", "", "forceFromDB", "getUserZPlanInfoFromCache", "", "serviceType", "Lji3/g;", "callback", "needNetReq", "", "getUserZPlanInfoFromNet", "Lcom/tencent/mobileqq/zplan/model/g;", "bgInfo", "saveUserBackgroundInfo", "getUserBackgroundInfo", "", "Lji3/f;", "getUserAppearanceChangeInfo", "Lji3/a;", "checkAppearanceEverChanged", "Lcom/tencent/mobileqq/zplan/persistent/api/IZPlanDataHelper$a;", "listener", "getIsInAlreadyCreatedRolePackage", "checkCreatedRole", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearCreatedRolePackageCache", "updateCreatedRolePackageCache", "keyForCheck", "checkAppearanceKeyUpToDate", "a", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes21.dex */
public interface IZPlanDataHelper extends QRouteApi {

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/zplan/persistent/api/IZPlanDataHelper$a;", "", "", "isInPackage", "", "onResult", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void onResult(int isInPackage);
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class b {
        public static /* synthetic */ void a(IZPlanDataHelper iZPlanDataHelper, String str, int i3, g gVar, boolean z16, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 8) != 0) {
                    z16 = true;
                }
                iZPlanDataHelper.getUserZPlanInfo(str, i3, gVar, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserZPlanInfo");
        }
    }

    void checkAppearanceEverChanged(long uin, int serviceType, @NotNull ji3.a callback);

    boolean checkAppearanceKeyUpToDate(@NotNull String keyForCheck, @NotNull String uin);

    @Nullable
    Object checkCreatedRole(@NotNull Continuation<? super Boolean> continuation);

    void clearCreatedRolePackageCache();

    void getIsInAlreadyCreatedRolePackage(@NotNull a listener);

    void getUserAppearanceChangeInfo(long uin, int serviceType, @NotNull f callback);

    @Nullable
    com.tencent.mobileqq.zplan.model.g getUserBackgroundInfo(@NotNull String uin);

    @NotNull
    ZPlanUserInfo getUserZPlanInfo(@NotNull String uin);

    @NotNull
    ZPlanUserInfo getUserZPlanInfo(@NotNull String uin, boolean forceFromDB);

    void getUserZPlanInfo(@NotNull String uin, int serviceType, @NotNull g callback, boolean needNetReq);

    @Nullable
    ZPlanUserInfo getUserZPlanInfoFromCache(@NotNull String uin);

    void getUserZPlanInfoFromNet(@NotNull String uin, int serviceType, @Nullable g callback);

    void saveUserBackgroundInfo(@NotNull String uin, @Nullable com.tencent.mobileqq.zplan.model.g bgInfo);

    void updateCreatedRolePackageCache();
}
