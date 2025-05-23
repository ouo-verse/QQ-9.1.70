package com.tencent.mobileqq.vip.api;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J(\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H&J \u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vip/api/IVasFrequency;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/mobileqq/vip/api/i;", "business", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "", "requestResourceForRecent", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "requestResourceForAIO", "", "isAio", "", "sendUin", "", "peerUid", "requestDataChangeForUid", "sAio", "", "chatType", "requestDataChangeAll", "vas_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasFrequency extends QRouteApi {
    void requestDataChangeAll(boolean sAio, int chatType, @NotNull i business);

    void requestDataChangeForUid(boolean isAio, long sendUin, @NotNull String peerUid, @NotNull i business);

    void requestResourceForAIO(@NotNull i business, @NotNull AIOMsgItem msgItem);

    void requestResourceForRecent(@NotNull i business, @NotNull RecentContactInfo info);
}
