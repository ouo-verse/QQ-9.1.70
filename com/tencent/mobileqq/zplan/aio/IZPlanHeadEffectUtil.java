package com.tencent.mobileqq.zplan.aio;

import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@QRouteFactory(singleton = true)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/IZPlanHeadEffectUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "enable", "", "source", "", "saveExtInfoToMessage", "", "message", "Lcom/tencent/imcore/message/Message;", "key", "value", "zplan_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {""})
/* loaded from: classes21.dex */
public interface IZPlanHeadEffectUtil extends QRouteApi {
    boolean enable(@NotNull String source);

    void saveExtInfoToMessage(@NotNull Message message, @NotNull String key, @NotNull String value);
}
