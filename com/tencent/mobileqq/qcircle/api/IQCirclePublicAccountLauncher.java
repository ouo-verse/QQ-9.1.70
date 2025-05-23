package com.tencent.mobileqq.qcircle.api;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/IQCirclePublicAccountLauncher;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getJumpUrl", "", "launchInfo", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountDetailPageLaunchInfo;", "hasRedDot", "", "launchQCircleFromPublicAccount", "", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "context", "Landroid/content/Context;", "source", "Lcom/tencent/mobileqq/qcircle/api/QCirclePublicAccountLauncherSource;", "launchQCirclePublicAccountDetailPage", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCirclePublicAccountLauncher extends QRouteApi {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a {
        public static /* synthetic */ String a(IQCirclePublicAccountLauncher iQCirclePublicAccountLauncher, QCirclePublicAccountDetailPageLaunchInfo qCirclePublicAccountDetailPageLaunchInfo, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                return iQCirclePublicAccountLauncher.getJumpUrl(qCirclePublicAccountDetailPageLaunchInfo, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getJumpUrl");
        }
    }

    @NotNull
    String getJumpUrl(@Nullable QCirclePublicAccountDetailPageLaunchInfo launchInfo, boolean hasRedDot);

    void launchQCircleFromPublicAccount(@NotNull BaseQQAppInterface app, @NotNull Context context, @NotNull QCirclePublicAccountLauncherSource source);

    void launchQCirclePublicAccountDetailPage(@NotNull Context context);
}
