package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasAioData;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.BubbleBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.ColorNameBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.DiyVipIconDownloadBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.FontBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness;
import com.tencent.mobileqq.vip.api.i;
import com.tencent.qqnt.aio.adapter.api.IAIOChatBackgroundApi;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgBubble;
import com.tencent.qqnt.kernel.nativeinterface.VASMsgFont;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/al;", "", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msg", "Lcom/tencent/mobileqq/vas/api/IVasAioData$VasAioPersonalData;", "data", "", "b", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class al {
    public final void a(@NotNull AIOMsgItem msg2, @NotNull IVasAioData.VasAioPersonalData data) {
        int intValue;
        int intValue2;
        Integer bubbleId;
        int intValue3;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        Integer num = msg2.o0().get(2);
        if (num != null) {
            Intrinsics.checkNotNullExpressionValue(num, "this ?: return@with");
            if (num.intValue() > 0 && !((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 333L).isFileExists(num.intValue())) {
                new i.e(num.intValue()).f(msg2);
                msg2.o0().put(2, 0);
            }
        }
        VASMsgBubble bubble = data.getBubble();
        Integer num2 = bubble.subBubbleId;
        if (num2 == null) {
            intValue = 0;
        } else {
            Intrinsics.checkNotNullExpressionValue(num2, "this.subBubbleId ?: 0");
            intValue = num2.intValue();
        }
        if (intValue > 0) {
            bubbleId = bubble.subBubbleId;
        } else {
            Integer num3 = bubble.bubbleId;
            if (num3 == null) {
                intValue2 = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(num3, "this.bubbleId?: 0");
                intValue2 = num3.intValue();
            }
            bubbleId = Integer.valueOf(intValue2);
        }
        Intrinsics.checkNotNullExpressionValue(bubbleId, "bubbleId");
        if (bubbleId.intValue() > 0 && !((BubbleBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(BubbleBusiness.class)).isFileExists(bubbleId.intValue())) {
            new i.h(bubbleId.intValue()).f(msg2);
            data.setBubble(new VASMsgBubble());
        }
        String currentChatBackgroundBg = ((IAIOChatBackgroundApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOChatBackgroundApi.class)).getCurrentChatBackgroundBg(String.valueOf(msg2.getMsgRecord().peerUin), msg2.p0());
        if (currentChatBackgroundBg == null) {
            currentChatBackgroundBg = "";
        }
        msg2.e1(currentChatBackgroundBg);
        if (!f13.a.f397699a.c()) {
            Integer num4 = data.getFont().fontId;
            if (num4 == null) {
                intValue3 = 0;
            } else {
                Intrinsics.checkNotNullExpressionValue(num4, "this.fontId?: 0");
                intValue3 = num4.intValue();
            }
            if (intValue3 > 0) {
                long j3 = intValue3;
                int i3 = (int) (((j3 & 255) << 8) + ((j3 >> 8) & 255));
                if (i3 > 0 && !((FontBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(FontBusiness.class)).isFileExists(i3)) {
                    new i.k(i3).f(msg2);
                    data.setFont(new VASMsgFont());
                }
            }
        }
        int troopColorNameId = data.getTroopColorNameId();
        if (troopColorNameId > 0 && ((TroopNickNameBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(TroopNickNameBusiness.class)).getConfig(troopColorNameId) == null) {
            new i.n(troopColorNameId).f(msg2);
            data.setTroopColorNameId(0);
        }
        int diyNamePlateItemId = data.getDiyNamePlateItemId();
        if (diyNamePlateItemId > 0 && !((DiyVipIconDownloadBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(DiyVipIconDownloadBusiness.class)).isFileExists(diyNamePlateItemId)) {
            new i.j(diyNamePlateItemId).f(msg2);
            data.setDiyNamePlateItemId(0);
        }
        if (data.getVipType() > 0 && data.getNamePlateId() >= 0) {
            int namePlateId = data.getNamePlateId();
            com.tencent.mobileqq.vas.vipicon.g gVar = (com.tencent.mobileqq.vas.vipicon.g) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.vipicon.g.class);
            if (!gVar.isFileExists(namePlateId)) {
                new i.l(namePlateId).f(msg2);
                data.setNamePlateId(-1);
            }
            ArrayList<Integer> carouselNamePlateIds = data.getCarouselNamePlateIds();
            boolean z16 = true;
            if (!carouselNamePlateIds.isEmpty()) {
                Iterator<T> it = carouselNamePlateIds.iterator();
                while (it.hasNext()) {
                    int intValue4 = ((Number) it.next()).intValue();
                    if (!gVar.isFileExists(intValue4)) {
                        new i.l(intValue4).f(msg2);
                        z16 = false;
                    }
                }
                if (!z16) {
                    data.getCarouselNamePlateIds().clear();
                }
            }
        }
        int extendNamePlateId = data.getExtendNamePlateId();
        if (extendNamePlateId > 0 && !((com.tencent.mobileqq.vas.vipicon.k) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.vipicon.k.class)).isFileExists(extendNamePlateId)) {
            new i.m(extendNamePlateId).f(msg2);
            data.setExtendNamePlateId(0);
        }
        int gameNamePlateId = data.getGameNamePlateId();
        if (gameNamePlateId > 0 && !((com.tencent.mobileqq.vas.vipicon.a) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.vipicon.a.class)).isFileExists(gameNamePlateId)) {
            new i.b(gameNamePlateId).f(msg2);
            data.setGameNamePlateId(0);
        }
        int colorName = data.getColorName();
        if (colorName > 0 && !((ColorNameBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(ColorNameBusiness.class)).isFileExists(colorName)) {
            new i.C8957i(colorName).f(msg2);
            data.setColorName(0);
        }
    }

    public final void b(@NotNull AIOMsgItem msg2, @NotNull IVasAioData.VasAioPersonalData data) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(data, "data");
        data.setTroopColorNameId(0);
        data.setDiyNamePlateItemId(0);
        data.setNamePlateId(-1);
        data.setExtendNamePlateId(0);
        data.setGameNamePlateId(0);
        data.setBubble(new VASMsgBubble());
        data.setFont(new VASMsgFont());
        msg2.o0().put(2, 0);
    }
}
