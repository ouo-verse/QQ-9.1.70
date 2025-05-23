package com.tencent.mobileqq.qqecommerce.biz.messagecenter.api;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqecommerce.biz.messagecenter.api.model.MessageItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\nH&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H&J$\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/IEcommerceMsgCenter;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/EcommerceMsgCenterSource;", "source", "", "launchMainPage", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/EcommerceMsgDetailSource;", "launchDetailPage", "launchSettingsPage", "", "exposureTimeSec", "Lcom/tencent/mobileqq/qqecommerce/biz/messagecenter/api/model/b;", "messageItem", "reportExposureInAIO", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IEcommerceMsgCenter extends QRouteApi {
    void launchDetailPage(@NotNull Context context, @NotNull EcommerceMsgDetailSource source);

    void launchMainPage(@NotNull BaseQQAppInterface app, @NotNull Context context, @NotNull EcommerceMsgCenterSource source);

    void launchSettingsPage(@NotNull Context context);

    void reportExposureInAIO(@NotNull BaseQQAppInterface app, long exposureTimeSec, @Nullable MessageItem messageItem);
}
