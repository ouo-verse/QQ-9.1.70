package com.tencent.qqnt.aio.adapter.api;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IMsgConverterUtilsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "convertToChatMessage", "Lcom/tencent/mobileqq/data/ChatMessage;", "app", "Lmqq/app/AppRuntime;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getArkMsgElem", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "getFaceMsgElem", "getFileMsgElem", "getMKDMsgElem", "getMarketFaceMsgElem", "getMsgElem", "elementId", "", "getMultiForwardMsgElem", "getPicMsgElem", "getPttMsgElem", "getVideoMsgElem", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IMsgConverterUtilsApi extends QRouteApi {
    @Nullable
    ChatMessage convertToChatMessage(@NotNull AppRuntime app, @NotNull MsgRecord msgRecord);

    @Nullable
    MsgElement getArkMsgElem(@NotNull MsgRecord msgRecord);

    @Nullable
    MsgElement getFaceMsgElem(@NotNull MsgRecord msgRecord);

    @Nullable
    MsgElement getFileMsgElem(@NotNull MsgRecord msgRecord);

    @Nullable
    MsgElement getMKDMsgElem(@NotNull MsgRecord msgRecord);

    @Nullable
    MsgElement getMarketFaceMsgElem(@NotNull MsgRecord msgRecord);

    @Nullable
    MsgElement getMsgElem(@NotNull MsgRecord msgRecord, long elementId);

    @Nullable
    MsgElement getMultiForwardMsgElem(@NotNull MsgRecord msgRecord);

    @Nullable
    MsgElement getPicMsgElem(@NotNull MsgRecord msgRecord);

    @Nullable
    MsgElement getPttMsgElem(@NotNull MsgRecord msgRecord);

    @Nullable
    MsgElement getVideoMsgElem(@NotNull MsgRecord msgRecord);
}
