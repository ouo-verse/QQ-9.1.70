package com.tencent.mobileqq.activity.history.api.impl;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.history.NTChatHistoryMsgForwardSingleton;
import com.tencent.mobileqq.activity.history.RealNTChatHistoryMsgForwardSingleton;
import com.tencent.mobileqq.activity.history.api.INTChatHistoryMsgForwardApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0011\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0001J\u0019\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0096\u0001J\u001f\u0010\u000f\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000e\u001a\u00020\rH\u0096\u0001\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/activity/history/api/impl/NTChatHistoryMsgForwardApiImpl;", "Lcom/tencent/mobileqq/activity/history/api/INTChatHistoryMsgForwardApi;", "Landroid/content/Intent;", "data", "", "doChatHistoryMsgForward", "Landroid/content/Context;", "context", "intent", "previewForwardMsg", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecordList", "Lcom/tencent/mobileqq/activity/history/NTChatHistoryMsgForwardSingleton$a;", "params", "setData", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class NTChatHistoryMsgForwardApiImpl implements INTChatHistoryMsgForwardApi {
    private final /* synthetic */ RealNTChatHistoryMsgForwardSingleton $$delegate_0 = RealNTChatHistoryMsgForwardSingleton.INSTANCE;

    @Override // com.tencent.mobileqq.activity.history.api.INTChatHistoryMsgForwardApi
    public void doChatHistoryMsgForward(Intent data) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.$$delegate_0.doChatHistoryMsgForward(data);
    }

    @Override // com.tencent.mobileqq.activity.history.api.INTChatHistoryMsgForwardApi
    public void previewForwardMsg(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.$$delegate_0.previewForwardMsg(context, intent);
    }

    @Override // com.tencent.mobileqq.activity.history.api.INTChatHistoryMsgForwardApi
    public void setData(List<MsgRecord> msgRecordList, NTChatHistoryMsgForwardSingleton.a params) {
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        Intrinsics.checkNotNullParameter(params, "params");
        this.$$delegate_0.setData(msgRecordList, params);
    }
}
