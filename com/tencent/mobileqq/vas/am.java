package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.api.IVasAioData;
import com.tencent.mobileqq.vas.font.magic.IVasMagicFontManager;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.GroupAnonymousInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgAvatarPendant;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgBubble;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgElement;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgFont;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgIceBreak;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgNamePlate;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J4\u0010\n\u001a\u00020\t2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J<\u0010\u000f\u001a\u00020\u000e2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0003H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/am;", "Lcom/tencent/qqnt/kernel/api/b;", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgAttributeInfo;", "Lkotlin/collections/HashMap;", Node.ATTRS_ATTR, "Lcom/tencent/mobileqq/vas/api/IVasAioData$VasAioMsgData;", AppConstants.Key.COLUMN_MSG_DATA, "Lcom/tencent/qqnt/kernel/nativeinterface/VASMsgAvatarPendant;", "b", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "contact", QQBrowserActivity.KEY_MSG_TYPE, "", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class am implements com.tencent.qqnt.kernel.api.b {
    private final VASMsgAvatarPendant b(HashMap<Integer, MsgAttributeInfo> attrs, IVasAioData.VasAioMsgData msgData) {
        int i3;
        VASMsgElement vASMsgElement;
        VASMsgAvatarPendant vASMsgAvatarPendant;
        int intValue;
        int i16 = 0;
        MsgAttributeInfo msgAttributeInfo = attrs.get(0);
        long j3 = 0;
        if (msgAttributeInfo != null && (vASMsgElement = msgAttributeInfo.vasMsgInfo) != null && (vASMsgAvatarPendant = vASMsgElement.avatarPendantInfo) != null) {
            Integer num = vASMsgAvatarPendant.avatarId;
            if (num == null) {
                intValue = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(num, "it.avatarId ?: 0");
                intValue = num.intValue();
            }
            Long l3 = vASMsgAvatarPendant.pendantId;
            if (l3 != null) {
                Intrinsics.checkNotNullExpressionValue(l3, "it.pendantId ?: 0L");
                j3 = l3.longValue();
            }
            Integer num2 = vASMsgAvatarPendant.pendantDiyInfoId;
            if (num2 != null) {
                Intrinsics.checkNotNullExpressionValue(num2, "it.pendantDiyInfoId ?: 0");
                i16 = num2.intValue();
            }
            i3 = i16;
            i16 = intValue;
        } else {
            i3 = 0;
        }
        if (i16 == 0) {
            i16 = msgData.getAvatarId();
            j3 = msgData.getPendantId();
            i3 = msgData.getPendantDiyInfoId();
        }
        return new VASMsgAvatarPendant(Integer.valueOf(i16), Long.valueOf(j3), Integer.valueOf(i3));
    }

    @Override // com.tencent.qqnt.kernel.api.b
    public void a(@NotNull HashMap<Integer, MsgAttributeInfo> attrs, @NotNull Contact contact, int msgType) {
        boolean z16;
        boolean z17;
        int bubbleId;
        int subBubbleId;
        boolean z18;
        VASMsgIceBreak vASMsgIceBreak;
        com.tencent.qqnt.kernel.api.w msgService;
        GroupAnonymousInfo anonymousInfo;
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        Intrinsics.checkNotNullParameter(contact, "contact");
        IKernelService i3 = com.tencent.qqnt.msg.f.i();
        boolean z19 = true;
        int i16 = 0;
        if (i3 != null && (msgService = i3.getMsgService()) != null && (anonymousInfo = msgService.getAnonymousInfo(contact.peerUid)) != null && anonymousInfo.isAnonymousChat) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || contact.chatType == 104) {
            return;
        }
        MsgAttributeInfo msgAttributeInfo = attrs.get(0);
        if (msgAttributeInfo == null) {
            msgAttributeInfo = new MsgAttributeInfo();
        }
        String sendUin = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin();
        IVasAioData iVasAioData = (IVasAioData) QRoute.api(IVasAioData.class);
        Intrinsics.checkNotNullExpressionValue(sendUin, "sendUin");
        IVasAioData.VasAioMsgData aioVasMsgData = iVasAioData.getAioVasMsgData(sendUin);
        aioVasMsgData.setMsgVipLevel(com.tencent.mobileqq.vas.vipicon.l.f311340a.a(aioVasMsgData.getMsgVipLevel()));
        if (msgType == 4) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17 && aioVasMsgData.getBubbleVoiceId() != 0) {
            bubbleId = aioVasMsgData.getBubbleVoiceId();
        } else {
            bubbleId = aioVasMsgData.getBubbleId();
        }
        int i17 = bubbleId;
        if (z17 && aioVasMsgData.getBubbleVoiceId() != 0) {
            subBubbleId = aioVasMsgData.getBubbleVoiceId();
        } else {
            subBubbleId = aioVasMsgData.getSubBubbleId();
        }
        int i18 = subBubbleId;
        int fontId = aioVasMsgData.getFontId();
        QRouteApi api = QRoute.api(IVasMagicFontManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IVasMagicFontManager::class.java)");
        IVasMagicFontManager iVasMagicFontManager = (IVasMagicFontManager) api;
        boolean isDisableMagicFontType = iVasMagicFontManager.isDisableMagicFontType();
        if (!TextUtils.equals(MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), sendUin) && iVasMagicFontManager.hideGuestMagicFont()) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!isDisableMagicFontType && !z18) {
            z19 = false;
        }
        if (z19 && fontId > 16777216) {
            fontId -= 16777216;
        }
        com.tencent.qqnt.kernel.util.a aVar = com.tencent.qqnt.kernel.util.a.f359256a;
        VASMsgNamePlate vASMsgNamePlate = new VASMsgNamePlate(Integer.valueOf(aioVasMsgData.getMsgVipType()), Integer.valueOf(aioVasMsgData.getMsgVipLevel()), Integer.valueOf(aioVasMsgData.getMsgBigClubFlag()), Integer.valueOf(aioVasMsgData.getMsgBigClubLevel()), Integer.valueOf(aioVasMsgData.getGrayNamePlate()), Integer.valueOf(aioVasMsgData.getNamePlateType()), Integer.valueOf(aioVasMsgData.getVipStarFlag()), Integer.valueOf(aioVasMsgData.getNamePlateId()), aioVasMsgData.getCarouselNamePlateIds(), Integer.valueOf(aioVasMsgData.getExtendNamePlateId()), Integer.valueOf(aioVasMsgData.getGameNamePlateId()), 0);
        VASMsgBubble vASMsgBubble = new VASMsgBubble(Integer.valueOf(i17), Integer.valueOf(aioVasMsgData.getBubbleDiyTextId()), Integer.valueOf(i18), Integer.valueOf(aioVasMsgData.getCanConvertToText()));
        VASMsgAvatarPendant b16 = b(attrs, aioVasMsgData);
        Integer valueOf = Integer.valueOf(fontId);
        Long valueOf2 = Long.valueOf(aioVasMsgData.getSubFontId());
        Integer valueOf3 = Integer.valueOf(aioVasMsgData.getDiyFontCfgUpdateTime());
        Integer valueOf4 = Integer.valueOf(aioVasMsgData.getDiyFontImageId());
        if (!z19) {
            i16 = aioVasMsgData.getMagicFontType();
        }
        VASMsgFont vASMsgFont = new VASMsgFont(valueOf, valueOf2, valueOf3, valueOf4, Integer.valueOf(i16));
        VASMsgElement vASMsgElement = msgAttributeInfo.vasMsgInfo;
        if (vASMsgElement != null) {
            vASMsgIceBreak = vASMsgElement.iceBreakInfo;
        } else {
            vASMsgIceBreak = null;
        }
        if (vASMsgIceBreak == null) {
            vASMsgIceBreak = new VASMsgIceBreak();
        }
        attrs.put(0, com.tencent.qqnt.kernel.util.a.d(aVar, msgAttributeInfo, null, null, new VASMsgElement(vASMsgNamePlate, vASMsgBubble, b16, vASMsgFont, vASMsgIceBreak), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 4194294, null));
    }
}
