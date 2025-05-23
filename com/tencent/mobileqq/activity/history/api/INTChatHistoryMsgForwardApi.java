package com.tencent.mobileqq.activity.history.api;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.history.NTChatHistoryMsgForwardSingleton;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u001e\u0010\r\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H&\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/activity/history/api/INTChatHistoryMsgForwardApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "previewForwardMsg", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecordList", "Lcom/tencent/mobileqq/activity/history/NTChatHistoryMsgForwardSingleton$a;", "params", "setData", "data", "doChatHistoryMsgForward", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface INTChatHistoryMsgForwardApi extends QRouteApi {
    void doChatHistoryMsgForward(@NotNull Intent data);

    void previewForwardMsg(@NotNull Context context, @NotNull Intent intent);

    void setData(@NotNull List<MsgRecord> msgRecordList, @NotNull NTChatHistoryMsgForwardSingleton.a params);
}
