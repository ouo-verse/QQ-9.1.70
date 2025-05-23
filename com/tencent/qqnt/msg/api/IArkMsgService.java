package com.tencent.qqnt.msg.api;

import com.tencent.mobileqq.mini.out.nativePlugins.SmsPlugin;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/msg/api/IArkMsgService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "guildID", "channelID", "Lcom/tencent/qqnt/msg/data/a;", "arkMsgModel", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "listener", "", SmsPlugin.API_SEND_SMS, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "", "sendMsgWithMsgId", "msg_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IArkMsgService extends QRouteApi {
    void sendMsg(@NotNull Contact contact, @NotNull com.tencent.qqnt.msg.data.a arkMsgModel, @Nullable IOperateCallback listener);

    void sendMsg(@NotNull String guildID, @NotNull String channelID, @NotNull com.tencent.qqnt.msg.data.a arkMsgModel, @Nullable IOperateCallback listener);

    long sendMsgWithMsgId(@NotNull Contact contact, @NotNull com.tencent.qqnt.msg.data.a arkMsgModel, @Nullable IOperateCallback listener);
}
