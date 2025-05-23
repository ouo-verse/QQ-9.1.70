package com.tencent.mobileqq.guild.message.api;

import com.tencent.imcore.message.decoder.j;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.util.List;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildMsgSummaryDecodersApi extends QRouteApi {
    CharSequence decodeMsg(MsgAbstract msgAbstract, String str);

    @Deprecated
    List<j> getMsgSummaryDecoders();
}
