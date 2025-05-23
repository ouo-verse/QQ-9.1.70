package com.tencent.qqnt.aio.adapter.api;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J0\u0010\f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/IMessageRecordFactoryApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createPicMessage", "Lcom/tencent/mobileqq/data/ChatMessage;", "app", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "picElement", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "createSendMsgMarketFace", "Lcom/tencent/mobileqq/data/MessageForMarketFace;", "friendUin", "", "groupUin", "type", "", "mfm", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes23.dex */
public interface IMessageRecordFactoryApi extends QRouteApi {
    @NotNull
    ChatMessage createPicMessage(@NotNull BaseQQAppInterface app, @NotNull MsgRecord msgRecord, @NotNull MsgElement msgElement);

    @NotNull
    ChatMessage createPicMessage(@NotNull BaseQQAppInterface app, @NotNull MsgRecord msgRecord, @Nullable PicElement picElement);

    @NotNull
    MessageForMarketFace createSendMsgMarketFace(@NotNull BaseQQAppInterface app, @NotNull String friendUin, @NotNull String groupUin, int type, @NotNull MarkFaceMessage mfm);
}
