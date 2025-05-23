package com.tencent.mobileqq.guild.main.alert;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Deprecated(message = "\u4e0d\u5efa\u8bae\u7ee7\u7eed\u4f7f\u7528\uff0c\u9664\u975e\u80fd\u4fdd\u8bc1\u8c03\u7528\u573a\u666f\u4e0b\u5b58\u5728\u4e3b\u6846\u67b6\u9875\u9762\uff0c\u5426\u5219\u4f1a\u65e0\u6cd5\u5c55\u793a\u5f39\u7a97", replaceWith = @ReplaceWith(expression = "MediaChannelDialogFragment", imports = {}))
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/main/alert/GuildMainAlertEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", RemoteMessageConst.MessageBody.MSG_CONTENT, "", "buttonContent", "(Ljava/lang/String;Ljava/lang/String;)V", "getButtonContent", "()Ljava/lang/String;", "getMsgContent", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class GuildMainAlertEvent extends SimpleBaseEvent {

    @NotNull
    private final String buttonContent;

    @NotNull
    private final String msgContent;

    public GuildMainAlertEvent(@NotNull String msgContent, @NotNull String buttonContent) {
        Intrinsics.checkNotNullParameter(msgContent, "msgContent");
        Intrinsics.checkNotNullParameter(buttonContent, "buttonContent");
        this.msgContent = msgContent;
        this.buttonContent = buttonContent;
    }

    @NotNull
    public final String getButtonContent() {
        return this.buttonContent;
    }

    @NotNull
    public final String getMsgContent() {
        return this.msgContent;
    }
}
