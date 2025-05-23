package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.history.NTChatHistoryMsgForwardSingleton;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IChatHistoryForwardApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ6\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/ChatHistoryForwardApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IChatHistoryForwardApi;", "Landroid/content/Context;", "context", "", "forwardType", "chatType", "", "peerUid", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecordList", "", "forwardChatHistory", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ChatHistoryForwardApiImpl implements IChatHistoryForwardApi {
    private static final String TAG = "ChatHistoryForwardApiImpl";

    @Override // com.tencent.qqnt.aio.adapter.api.IChatHistoryForwardApi
    public void forwardChatHistory(Context context, int forwardType, int chatType, String peerUid, List<MsgRecord> msgRecordList) {
        ArrayList<String> arrayListOf;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(msgRecordList, "msgRecordList");
        if (msgRecordList.isEmpty()) {
            QLog.e(TAG, 1, "chat history forward error: msg list empty");
            return;
        }
        NTChatHistoryMsgForwardSingleton.INSTANCE.setData(msgRecordList, new NTChatHistoryMsgForwardSingleton.a(forwardType, chatType, peerUid));
        Activity activity = (Activity) context;
        Intent intent = new Intent(activity, (Class<?>) ForwardRecentActivity.class);
        intent.putExtra("forward_type", -3);
        intent.putExtra(AppConstants.Key.FORWARD_NT_FROM_AIO_MSG, true);
        intent.putExtra(AppConstants.Key.FORWARD_NT_CHAT_HISTORY, true);
        if (forwardType == 0) {
            String string = context.getString(R.string.mpw);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026.qqstr_forwards_0d019093)");
            String str2 = "";
            if (chatType == 1) {
                com.tencent.qqnt.kernel.api.m b16 = com.tencent.qqnt.msg.f.b();
                if (b16 != null) {
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(peerUid);
                    Map<String, String> buddyNick = b16.getBuddyNick(arrayListOf);
                    if (buddyNick != null && (str = buddyNick.get(peerUid)) != null) {
                        str2 = str;
                    }
                }
                str2 = str2 + context.getString(R.string.mq7);
            } else if (chatType == 2) {
                str2 = context.getString(R.string.l2u) + context.getString(R.string.mq7);
            }
            intent.putExtra(AppConstants.Key.FORWARD_NT_PREVIEW_MINIAIO_TITLE, str2);
            intent.putExtra(AppConstants.Key.FORWARD_TEXT, string + str2);
        } else {
            String string2 = context.getString(R.string.mqp);
            String string3 = context.getString(R.string.f172011mqq);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri\u2026.qqstr_forwards_b221c326)");
            String format = String.format(string3, Arrays.copyOf(new Object[]{Integer.valueOf(msgRecordList.size())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            intent.putExtra(AppConstants.Key.FORWARD_NT_PREVIEW_MINIAIO_TITLE, context.getString(R.string.f172196o92));
            intent.putExtra(AppConstants.Key.FORWARD_TEXT, string2 + format);
        }
        ForwardBaseOption.startForwardActivityForResult(activity, intent, 21);
    }
}
