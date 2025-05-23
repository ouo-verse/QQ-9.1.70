package com.tencent.qqnt.aio.adapter.api.impl;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForRichState;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottie;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.ITextPreviewApi;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.api.IPreviewTextApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgBubble;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgFont;
import com.tencent.robot.api.IRobotIdentityApi;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J(\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/TextPreviewApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/ITextPreviewApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "", "isBlockSpeech", "isRobotChatAndSender", "Landroid/content/Intent;", "intent", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "", "handleReplyMsg", "", "previewText", "", "realMsgId", "openTextPreview", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TextPreviewApiImpl implements ITextPreviewApi {
    public static final String TAG = "TextPreviewApiImpl";

    private final void handleReplyMsg(Intent intent, MsgRecord msgRecord) {
        MsgRecord msgRecord2;
        ArrayList<MsgElement> arrayList;
        Integer num;
        ArrayList<MsgRecord> arrayList2 = msgRecord.records;
        if (arrayList2 == null || arrayList2.size() != 1 || (msgRecord2 = msgRecord.records.get(0)) == null || msgRecord2.msgType != 2 || (arrayList = msgRecord2.elements) == null || arrayList.size() != 1) {
            return;
        }
        MsgElement msgElement = msgRecord2.elements.get(0);
        if (msgElement.elementType == 6 && (num = msgElement.faceElement.stickerType) != null) {
            Intrinsics.checkNotNullExpressionValue(num, "elem.faceElement.stickerType");
            if (QQSysFaceUtil.isBigStickerByType(num.intValue())) {
                AniStickerLottie.init();
                intent.putExtra("anistickerLocID", QQSysFaceUtil.convertToLocal(msgElement.faceElement.faceIndex));
                intent.putExtra("anistickerResultID", msgElement.faceElement.resultId);
            }
        }
    }

    private final boolean isBlockSpeech(com.tencent.aio.api.runtime.a aioContext, AIOMsgItem msgItem) {
        return isRobotChatAndSender(aioContext, msgItem);
    }

    private final boolean isRobotChatAndSender(com.tencent.aio.api.runtime.a aioContext, AIOMsgItem msgItem) {
        IRobotIdentityApi iRobotIdentityApi = (IRobotIdentityApi) QRoute.api(IRobotIdentityApi.class);
        return iRobotIdentityApi.isMatchRobotChatType(Integer.valueOf(aioContext.g().r().c().e())) && iRobotIdentityApi.isRobotUin(Long.valueOf(msgItem.getMsgRecord().senderUin));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openTextPreview$lambda$2(final com.tencent.aio.api.runtime.a aioContext, final AIOMsgItem msgItem, ActivityResult activityResult) {
        Intrinsics.checkNotNullParameter(aioContext, "$aioContext");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        if (activityResult.getResultCode() != 14001) {
            return;
        }
        ThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.qqnt.aio.adapter.api.impl.bb
            @Override // java.lang.Runnable
            public final void run() {
                TextPreviewApiImpl.openTextPreview$lambda$2$lambda$1(com.tencent.aio.api.runtime.a.this, msgItem);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void openTextPreview$lambda$2$lambda$1(com.tencent.aio.api.runtime.a aioContext, AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(aioContext, "$aioContext");
        Intrinsics.checkNotNullParameter(msgItem, "$msgItem");
        aioContext.e().h(new AIOMsgSendEvent.MsgOnClickReplyEvent(msgItem, 0, false, 4, null));
    }

    @Override // com.tencent.qqnt.aio.adapter.api.ITextPreviewApi
    public void openTextPreview(final com.tencent.aio.api.runtime.a aioContext, String previewText, final AIOMsgItem msgItem, long realMsgId) {
        int intValue;
        int intValue2;
        int intValue3;
        VASMsgFont vASMsgFont;
        VASMsgBubble vASMsgBubble;
        VASMsgBubble vASMsgBubble2;
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(previewText, "previewText");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "openTextPreview " + previewText);
        }
        Fragment c16 = aioContext.c();
        Integer num = null;
        FragmentActivity activity = c16 != null ? c16.getActivity() : null;
        if (activity != null && !activity.isFinishing()) {
            boolean A = com.tencent.mobileqq.aio.utils.d.A(msgItem);
            MsgRecord msgRecord = msgItem.getMsgRecord();
            Intent intent = ((IPreviewTextApi) QRoute.api(IPreviewTextApi.class)).createTextPreviewIntent(activity);
            intent.putExtra("peeruin", String.valueOf(msgRecord.peerUin));
            intent.putExtra(IPublicAccountBrowser.KEY_UIN_TYPE, com.tencent.nt.adapter.session.c.c(msgRecord.chatType));
            intent.putExtra("content", previewText);
            intent.putExtra("uniseq", msgRecord.msgId);
            intent.putExtra("realMsgId", realMsgId);
            intent.putExtra(AppConstants.Key.COLUMN_MSG_SENDER_UIN, String.valueOf(msgRecord.senderUin));
            intent.putExtra("real_msg_sender_uin", String.valueOf(msgRecord.senderUin));
            intent.putExtra(ShortVideoConstants.PARAM_KEY_SESSION_TYPE, com.tencent.nt.adapter.session.c.c(msgRecord.chatType));
            intent.putExtra("isMultiMsg", msgRecord.msgType == 8);
            intent.putExtra("is_unsafe_msg", A);
            intent.putExtra("key_bundle_nt_folder", A);
            intent.putExtra("key_bundle_nt_peeruid", msgRecord.peerUid);
            intent.putExtra(AppConstants.Key.NT_CHAT_TYPE, msgRecord.chatType);
            intent.putExtra("is_block_speech", isBlockSpeech(aioContext, msgItem));
            if (com.tencent.mobileqq.aio.utils.d.q(msgItem)) {
                AniStickerLottie.init();
                QRouteApi api = QRoute.api(IAIOMsgItemApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IAIOMsgItemApi::class.java)");
                IAIOMsgItemApi iAIOMsgItemApi = (IAIOMsgItemApi) api;
                intent.putExtra("anistickerLocID", iAIOMsgItemApi.getLocalIdOfAniStickerMsg(msgItem));
                intent.putExtra("anistickerResultID", iAIOMsgItemApi.getResultIdOfAniStickerMsg(msgItem));
            } else if (msgRecord.msgType == 9 && msgRecord.msgId != realMsgId) {
                Intrinsics.checkNotNullExpressionValue(intent, "this");
                handleReplyMsg(intent, msgRecord);
            }
            MsgAttributeInfo msgAttributeInfo = msgRecord.msgAttrs.get(0);
            VASMsgElement vASMsgElement = msgAttributeInfo != null ? msgAttributeInfo.vasMsgInfo : null;
            Integer num2 = (vASMsgElement == null || (vASMsgBubble2 = vASMsgElement.bubbleInfo) == null) ? null : vASMsgBubble2.bubbleId;
            if (num2 == null) {
                intValue = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(num2, "vasMsgInfo?.bubbleInfo?.bubbleId?: 0");
                intValue = num2.intValue();
            }
            Integer num3 = (vASMsgElement == null || (vASMsgBubble = vASMsgElement.bubbleInfo) == null) ? null : vASMsgBubble.bubbleDiyTextId;
            if (num3 == null) {
                intValue2 = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(num3, "vasMsgInfo?.bubbleInfo?.bubbleDiyTextId?: 0");
                intValue2 = num3.intValue();
            }
            if (vASMsgElement != null && (vASMsgFont = vASMsgElement.vasFont) != null) {
                num = vASMsgFont.fontId;
            }
            if (num == null) {
                intValue3 = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(num, "vasMsgInfo?.vasFont?.fontId?: 0");
                intValue3 = num.intValue();
            }
            intent.putExtra("bubbleId", intValue);
            intent.putExtra("bubbleDiyId", intValue2);
            intent.putExtra(MessageForRichState.SIGN_MSG_FONT_ID, String.valueOf(intValue3));
            intent.putExtra("fontEffectId", com.tencent.qqnt.aio.utils.n.f352308a.c(msgItem));
            ts.a f16 = aioContext.f();
            if (f16 != null) {
                Intrinsics.checkNotNullExpressionValue(intent, "intent");
                f16.a(intent, new ActivityResultCallback() { // from class: com.tencent.qqnt.aio.adapter.api.impl.bc
                    @Override // androidx.activity.result.ActivityResultCallback
                    public final void onActivityResult(Object obj) {
                        TextPreviewApiImpl.openTextPreview$lambda$2(com.tencent.aio.api.runtime.a.this, msgItem, (ActivityResult) obj);
                    }
                });
            }
            activity.overridePendingTransition(R.anim.f154468ac, 0);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w(TAG, 2, "openTextPreview error, activity is null or finishing");
        }
    }
}
