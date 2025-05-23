package com.tencent.qqnt.aio.adapter.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001JZ\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072>\u0010\b\u001a:\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u0003\u0018\u00010\tj\u0004\u0018\u0001`\u000eH&Jm\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072S\u0010\b\u001aO\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0011j\u0004\u0018\u0001`\u0013H&\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IGuildMsgApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "setGProGuildMsgRead", "", "guildId", "", "chatType", "", "cb", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "result", "errMsg", "Lcom/tencent/qqnt/aio/adapter/api/ISetGProGuildMsgReadCallback;", "setGuildUnNotifyFlag", "unNotifyType", "Lkotlin/Function3;", "needNotice", "Lcom/tencent/qqnt/aio/adapter/api/ISetGProGuildMessageNotifyCallback;", "aio_adapter_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IGuildMsgApi extends QRouteApi {
    void setGProGuildMsgRead(@Nullable String guildId, int chatType, @Nullable Function2<? super Integer, ? super String, Unit> cb5);

    void setGuildUnNotifyFlag(@NotNull String guildId, int unNotifyType, @Nullable Function3<? super Integer, ? super String, ? super Integer, Unit> cb5);
}
