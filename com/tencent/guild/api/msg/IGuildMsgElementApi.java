package com.tencent.guild.api.msg;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/guild/api/msg/IGuildMsgElementApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getElementContent", "", DTConstants.TAG.ELEMENT, "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "isArkElem", "", "elem", "isPictureElem", "isReplyElem", "isTextElem", "isVideoElem", "nt-guild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGuildMsgElementApi extends QRouteApi {
    @NotNull
    String getElementContent(@NotNull MsgElement element);

    boolean isArkElem(@NotNull MsgElement elem);

    boolean isPictureElem(@NotNull MsgElement elem);

    boolean isReplyElem(@NotNull MsgElement elem);

    boolean isTextElem(@NotNull MsgElement elem);

    boolean isVideoElem(@NotNull MsgElement elem);
}
