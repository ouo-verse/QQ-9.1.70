package com.tencent.mobileqq.kandian.biz.video.api;

import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/kandian/biz/video/api/IVideoFeedsAppInterfaceFactory;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", OperateCustomButton.OPERATE_CREATE, "Lcom/tencent/common/app/business/BaseToolAppInterface;", "app", "Lmqq/app/MobileQQ;", "procname", "", "kandian-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes15.dex */
public interface IVideoFeedsAppInterfaceFactory extends QRouteApi {
    @Nullable
    BaseToolAppInterface create(@NotNull MobileQQ app, @NotNull String procname);
}
