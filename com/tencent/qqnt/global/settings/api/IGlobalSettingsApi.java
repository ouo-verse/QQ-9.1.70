package com.tencent.qqnt.global.settings.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.global.settings.notification.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\u0006H&J\b\u0010\f\u001a\u00020\u0006H&J\"\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/global/settings/api/IGlobalSettingsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "onEnterChat", "", "isNewMessageNotificationShow", "isAioTopNotificationShow", "needNotificationLight", "isGlobalShowPreview", "needLockScreenNotification", "isOpenNoClearNotification", "", "uin", "", "chatType", "Lcom/tencent/qqnt/global/settings/notification/a;", "notificationExtInfo", "isSessionShowPreview", "global_settings_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IGlobalSettingsApi extends QRouteApi {
    boolean isAioTopNotificationShow();

    boolean isGlobalShowPreview();

    boolean isNewMessageNotificationShow();

    boolean isOpenNoClearNotification();

    boolean isSessionShowPreview(long uin, int chatType, @Nullable a notificationExtInfo);

    boolean needLockScreenNotification();

    boolean needNotificationLight();

    void onEnterChat(@NotNull com.tencent.aio.api.runtime.a aioContext);
}
