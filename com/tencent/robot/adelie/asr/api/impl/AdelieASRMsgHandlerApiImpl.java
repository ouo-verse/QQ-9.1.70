package com.tencent.robot.adelie.asr.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.AdelieMsgAttr;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.util.a;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.adelie.asr.api.IAdelieASRMsgHandlerApi;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/robot/adelie/asr/api/impl/AdelieASRMsgHandlerApiImpl;", "Lcom/tencent/robot/adelie/asr/api/IAdelieASRMsgHandlerApi;", "", "peerUin", "text", "", "extInfo", "", "addAndSendASRMsg", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieASRMsgHandlerApiImpl implements IAdelieASRMsgHandlerApi {

    @NotNull
    public static final String TAG = "AdelieASRMsgHandlerApiImpl";

    @Override // com.tencent.robot.adelie.asr.api.IAdelieASRMsgHandlerApi
    public void addAndSendASRMsg(@NotNull String peerUin, @NotNull String text, @NotNull byte[] extInfo) {
        MsgAttributeInfo a16;
        Intrinsics.checkNotNullParameter(peerUin, "peerUin");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        Contact contact = new Contact();
        contact.setChatType(42);
        contact.setPeerUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(peerUin));
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        arrayList.add(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createTextElement(text));
        QLog.d(TAG, 1, "addAndSendASRMsg peerUin=" + peerUin + " " + contact + " size=" + extInfo.length);
        HashMap<Integer, MsgAttributeInfo> hashMap = new HashMap<>();
        a16 = a.f359256a.a(16, (i16 & 2) != 0 ? 0L : 0L, (i16 & 4) != 0 ? null : null, (i16 & 8) != 0 ? null : null, (i16 & 16) != 0 ? null : null, (i16 & 32) != 0 ? null : null, (i16 & 64) != 0 ? null : null, (i16 & 128) != 0 ? null : null, (i16 & 256) != 0 ? null : null, (i16 & 512) != 0 ? null : null, (i16 & 1024) != 0 ? null : null, (i16 & 2048) != 0 ? null : null, (i16 & 4096) != 0 ? null : null, (i16 & 8192) != 0 ? null : null, (i16 & 16384) != 0 ? null : null, (i16 & 32768) != 0 ? null : null, (i16 & 65536) != 0 ? null : new AdelieMsgAttr(0L, 1L, extInfo), (i16 & 131072) != 0 ? null : null, (i16 & 262144) != 0 ? null : null);
        hashMap.put(16, a16);
        ((IMsgService) QRoute.api(IMsgService.class)).sendMsg(contact, arrayList, hashMap, (IOperateCallback) null);
    }
}
