package com.tencent.mobileqq.qcircle.api;

import android.annotation.TargetApi;
import android.app.Notification;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\bH&J\b\u0010\r\u001a\u00020\nH&J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\b2\b\b\u0002\u0010\u0004\u001a\u00020\u0003H'J(\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\bH&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/IQCircleNotificationApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "areAllEnabled", "", "useCache", "cancelNotification", "", "tag", "", "id", "", "getHideBadgeChannel", "getOtherChannel", "getQCircleCommonNotifyId", "isChannelEnabled", "channelId", "showNotification", "notification", "Landroid/app/Notification;", WadlProxyConsts.CHANNEL, "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IQCircleNotificationApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class a {
        public static /* synthetic */ boolean a(IQCircleNotificationApi iQCircleNotificationApi, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = true;
                }
                return iQCircleNotificationApi.areAllEnabled(z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: areAllEnabled");
        }

        public static /* synthetic */ boolean b(IQCircleNotificationApi iQCircleNotificationApi, String str, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    z16 = true;
                }
                return iQCircleNotificationApi.isChannelEnabled(str, z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isChannelEnabled");
        }
    }

    boolean areAllEnabled(boolean useCache);

    void cancelNotification(@NotNull String tag, int id5);

    @NotNull
    String getHideBadgeChannel();

    @NotNull
    String getOtherChannel();

    int getQCircleCommonNotifyId();

    @TargetApi(26)
    boolean isChannelEnabled(@NotNull String channelId, boolean useCache);

    void showNotification(@NotNull String tag, int id5, @NotNull Notification notification, @NotNull String channel);
}
