package com.tencent.imcore.message.api;

import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\bg\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/imcore/message/api/INTMsgProxyUtilsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "transToCompatMsgType", "", "Lcom/tencent/mobileqq/data/MessageRecord;", TabPreloadItem.TAB_NAME_MESSAGE, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "peerUin", "", "uinType", "", "IMCore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes7.dex */
public interface INTMsgProxyUtilsApi extends QRouteApi {
    @NotNull
    List<MessageRecord> transToCompatMsgType(@NotNull List<MsgRecord> msgList, @NotNull String peerUin, int uinType);
}
