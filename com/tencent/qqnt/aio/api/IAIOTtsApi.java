package com.tencent.qqnt.aio.api;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/qqnt/aio/api/IAIOTtsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "", "isMsgSupportTts", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "", "getTtsContent", "aio_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IAIOTtsApi extends QRouteApi {
    @NotNull
    String getTtsContent(@NotNull AIOMsgItem msgItem);

    boolean isMsgSupportTts(@Nullable com.tencent.aio.data.msglist.a msgItem);
}
