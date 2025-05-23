package com.tencent.mobileqq.vas.aiotip.api;

import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH&J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/aiotip/api/IVasAioTipService;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "curType", "", "fromUin", "", "tryTriggerExpireAioTips", "Lcom/tencent/qqnt/msg/d;", "msg", "", "isSender", "tryKeywordsAioTips", "Lcom/tencent/aio/data/AIOParam;", "param", "tryTriggerMsgRoamAioTipsWhenEnterAio", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", "tryTriggerMsgRoamAioTipsWhenSendReceive", "vas_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IVasAioTipService extends QRouteApi {
    void tryKeywordsAioTips(@NotNull d msg2, boolean isSender);

    void tryTriggerExpireAioTips(int curType, @NotNull String fromUin);

    void tryTriggerMsgRoamAioTipsWhenEnterAio(@NotNull AIOParam param);

    void tryTriggerMsgRoamAioTipsWhenSendReceive(@NotNull MsgRecord msgRecord, @NotNull Contact contact);
}
