package com.tencent.mobileqq.vas.menu.impl;

import android.content.Context;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IUrlEnterIdApi;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.menu.IJumpDressUp;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.IAIOJumpAction;
import com.tencent.qqnt.aio.adapter.api.IReportControllerApi;
import com.tencent.qqnt.aio.utils.n;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgAvatarPendant;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgBubble;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgFont;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/menu/impl/JumpDressUpImpl;", "Lcom/tencent/mobileqq/vas/menu/IJumpDressUp;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "aioMsgItem", "", "jumpToDressUp", "", "isSupportDressUpBtn", "<init>", "()V", "Companion", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class JumpDressUpImpl implements IJumpDressUp {

    @NotNull
    private static final String CUSTOM_URL = "https://zb.vip.qq.com/v2/pages/aioDressPage?fromPage=1&targetUin=%s&widgetId=%s&bubbleId=%s&fontId=%s&fontEffectId=%s&chatId=%s";
    public static final int DOUBLE_CLICK_F_ID = 37;
    public static final int DOUBLE_CLICK_M_ID = 38;

    @NotNull
    private static final String TAG = "JumpDressUpImpl";
    private static final boolean IS_SUPPORT_DRESS_UP_BTN = ar.INSTANCE.b("shouyouye", "2024-03-11", "vas_support_long_click_dress_up_btn").isEnable(false);

    @Override // com.tencent.mobileqq.vas.menu.IJumpDressUp
    public boolean isSupportDressUpBtn() {
        return IS_SUPPORT_DRESS_UP_BTN;
    }

    @Override // com.tencent.mobileqq.vas.menu.IJumpDressUp
    public void jumpToDressUp(@NotNull Context context, @NotNull AIOMsgItem aioMsgItem) {
        boolean z16;
        VASMsgElement vASMsgElement;
        Integer num;
        int intValue;
        Integer num2;
        int intValue2;
        long longValue;
        int i3;
        VASMsgAvatarPendant vASMsgAvatarPendant;
        VASMsgFont vASMsgFont;
        VASMsgBubble vASMsgBubble;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(aioMsgItem, "aioMsgItem");
        if (aioMsgItem.getMsgRecord().senderUin == MobileQQ.sMobileQQ.peekAppRuntime().getLongAccountUin()) {
            z16 = true;
        } else {
            z16 = false;
        }
        MsgRecord msgRecord = aioMsgItem.getMsgRecord();
        long j3 = msgRecord.senderUin;
        MsgAttributeInfo msgAttributeInfo = msgRecord.msgAttrs.get(0);
        Long l3 = null;
        if (msgAttributeInfo != null) {
            vASMsgElement = msgAttributeInfo.vasMsgInfo;
        } else {
            vASMsgElement = null;
        }
        if (vASMsgElement != null && (vASMsgBubble = vASMsgElement.bubbleInfo) != null) {
            num = vASMsgBubble.bubbleId;
        } else {
            num = null;
        }
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        if (vASMsgElement != null && (vASMsgFont = vASMsgElement.vasFont) != null) {
            num2 = vASMsgFont.fontId;
        } else {
            num2 = null;
        }
        if (num2 == null) {
            intValue2 = 0;
        } else {
            intValue2 = num2.intValue();
        }
        if (vASMsgElement != null && (vASMsgAvatarPendant = vASMsgElement.avatarPendantInfo) != null) {
            l3 = vASMsgAvatarPendant.pendantId;
        }
        if (l3 == null) {
            longValue = 0;
        } else {
            longValue = l3.longValue();
        }
        long j16 = msgRecord.peerUin;
        int c16 = n.f352308a.c(aioMsgItem);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j3);
        StringBuilder sb6 = new StringBuilder();
        sb6.append(intValue);
        StringBuilder sb7 = new StringBuilder();
        sb7.append(intValue2);
        StringBuilder sb8 = new StringBuilder();
        sb8.append(c16);
        String format = String.format(CUSTOM_URL, Arrays.copyOf(new Object[]{sb5.toString(), Long.valueOf(longValue), sb6.toString(), sb7.toString(), sb8.toString(), Long.valueOf(j16)}, 6));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        IUrlEnterIdApi iUrlEnterIdApi = (IUrlEnterIdApi) QRoute.api(IUrlEnterIdApi.class);
        if (z16) {
            i3 = 38;
        } else {
            i3 = 37;
        }
        String addEntryParamToUrl = iUrlEnterIdApi.addEntryParamToUrl(format, i3, "aioLpress");
        QLog.i(TAG, 1, "jumpToDressUp jumpUrl:" + addEntryParamToUrl);
        a.Companion companion = a.INSTANCE;
        ((IAIOJumpAction) companion.a(IAIOJumpAction.class)).openBrowser(context, addEntryParamToUrl);
        ((IReportControllerApi) companion.a(IReportControllerApi.class)).reportWith898(MobileQQ.sMobileQQ.peekAppRuntime(), "", String.valueOf(msgRecord.peerUin), "0X800C5F2", "0X800C5F2", msgRecord.chatType, 0, "", "", "", "");
    }
}
