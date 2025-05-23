package com.tencent.mobileqq.troop.aivoicechat.api.impl;

import com.tencent.mobileqq.troop.aivoicechat.api.ITroopAIVoiceChatApi;
import com.tencent.mobileqq.troop.aivoicechat.api.impl.TroopAIVoiceChatApiImpl;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.AIVoiceChatType;
import com.tencent.qqnt.kernel.nativeinterface.AIVoiceInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.OtherBusinessInfo;
import com.tencent.qqnt.kernel.nativeinterface.PttElement;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import vr2.j;
import zr2.b;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J`\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t26\u0010\u000e\u001a2\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00070\u000fH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/troop/aivoicechat/api/impl/TroopAIVoiceChatApiImpl;", "Lcom/tencent/mobileqq/troop/aivoicechat/api/ITroopAIVoiceChatApi;", "()V", "getJumpParser", "Ljava/lang/Class;", "", "sendAiPttMsg", "", "groupUin", "", "aiVoiceType", "", "timbreId", "text", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "result", "errMsg", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class TroopAIVoiceChatApiImpl implements ITroopAIVoiceChatApi {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendAiPttMsg$lambda$3(TroopAIVoiceChatApiImpl this$0, j msgReporter, Function2 callback, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgReporter, "$msgReporter");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (QLog.isDebugVersion()) {
            QLog.d(this$0.getClass().getSimpleName(), 4, "sendAiPttMsg, " + i3 + ", " + errMsg);
        }
        Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
        msgReporter.a(i3, errMsg);
        callback.invoke(Integer.valueOf(i3), errMsg);
    }

    @Override // com.tencent.mobileqq.troop.aivoicechat.api.ITroopAIVoiceChatApi
    public Class<Object> getJumpParser() {
        return b.class;
    }

    @Override // com.tencent.mobileqq.troop.aivoicechat.api.ITroopAIVoiceChatApi
    public void sendAiPttMsg(String groupUin, int aiVoiceType, String timbreId, String text, final Function2<? super Integer, ? super String, Unit> callback) {
        Long longOrNull;
        IKernelService iKernelService;
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        Intrinsics.checkNotNullParameter(timbreId, "timbreId");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (aiVoiceType != AIVoiceChatType.KAIVOICECHATTYPESOUND.ordinal()) {
            QLog.e(TroopAIVoiceChatApiImpl.class.getSimpleName(), 1, "sendAiPttMsg err, aiVoiceType is " + aiVoiceType);
            return;
        }
        if (!(groupUin.length() == 0)) {
            if (!(timbreId.length() == 0)) {
                if (!(text.length() == 0)) {
                    longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(groupUin);
                    if (longOrNull != null) {
                        long longValue = longOrNull.longValue();
                        ArrayList<MsgElement> arrayList = new ArrayList<>();
                        PttElement pttElement = new PttElement();
                        OtherBusinessInfo otherBusinessInfo = pttElement.otherBusinessInfo;
                        otherBusinessInfo.aiVoiceType = aiVoiceType;
                        AIVoiceInfo aIVoiceInfo = new AIVoiceInfo();
                        aIVoiceInfo.groupCode = longValue;
                        aIVoiceInfo.text = text;
                        aIVoiceInfo.voiceTimbreID = timbreId;
                        otherBusinessInfo.aiVoiceInfo = aIVoiceInfo;
                        MsgElement msgElement = new MsgElement();
                        msgElement.elementType = 4;
                        msgElement.pttElement = pttElement;
                        arrayList.add(msgElement);
                        final j jVar = new j(groupUin, aiVoiceType, timbreId, text);
                        AppRuntime f16 = bg.f();
                        w msgService = (f16 == null || (iKernelService = (IKernelService) f16.getRuntimeService(IKernelService.class, "")) == null) ? null : iKernelService.getMsgService();
                        if (msgService != null) {
                            msgService.F(0L, new Contact(2, groupUin, ""), arrayList, new IOperateCallback() { // from class: xr2.a
                                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                                public final void onResult(int i3, String str) {
                                    TroopAIVoiceChatApiImpl.sendAiPttMsg$lambda$3(TroopAIVoiceChatApiImpl.this, jVar, callback, i3, str);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
        QLog.e(TroopAIVoiceChatApiImpl.class.getSimpleName(), 1, "sendAiPttMsg err, " + groupUin + "-" + timbreId + "-" + text);
    }
}
