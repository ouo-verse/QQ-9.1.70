package com.tencent.mobileqq.vas.process;

import android.graphics.drawable.Drawable;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.cachedrawable.dynamicdrawable.api.a;
import com.tencent.cachedrawable.dynamicdrawable.cachedrawable.FastDynamicDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.vas.VasLogNtReporter;
import com.tencent.mobileqq.vas.VipNtMMKV;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.lovechat.LoveChatBgDrawable;
import com.tencent.mobileqq.vas.pendant.RecentPendantDrawable;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.BubbleBusiness;
import com.tencent.mobileqq.vip.api.IVipDataUtils;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.data.converter.c;
import com.tencent.qqnt.chats.data.converter.f;
import com.tencent.qqnt.chats.data.converter.g;
import com.tencent.qqnt.chats.data.converter.k;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalElement;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalNamePlate;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/vas/process/VasRecentInfoProcess;", "Lcom/tencent/qqnt/chats/data/converter/g;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "uin", "", "a", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "", "matchPayload", "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "update", "Lcom/tencent/mobileqq/vas/process/a;", "Lcom/tencent/mobileqq/vas/process/a;", "frequency", "<init>", "()V", "b", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasRecentInfoProcess extends g {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Function2<Integer, Long, Drawable> f310569c = new Function2<Integer, Long, FastDynamicDrawable>() { // from class: com.tencent.mobileqq.vas.process.VasRecentInfoProcess$Companion$sLoveChatUnreadInvoke$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ FastDynamicDrawable invoke(Integer num, Long l3) {
            return invoke(num.intValue(), l3.longValue());
        }

        @NotNull
        public final FastDynamicDrawable invoke(int i3, long j3) {
            com.tencent.mobileqq.vas.lovechat.a aVar = (com.tencent.mobileqq.vas.lovechat.a) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.lovechat.a.class);
            a.C1005a a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
            String g16 = aVar.g(i3, j3);
            Intrinsics.checkNotNullExpressionValue(g16, "business.getUnreadDrawablePath(id, unreadNum)");
            return a16.d(g16).i("RECENT").a();
        }
    };

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final Function1<Integer, Drawable> f310570d = new Function1<Integer, FastDynamicDrawable>() { // from class: com.tencent.mobileqq.vas.process.VasRecentInfoProcess$Companion$sLoveChatPendantInvoke$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ FastDynamicDrawable invoke(Integer num) {
            return invoke(num.intValue());
        }

        @NotNull
        public final FastDynamicDrawable invoke(int i3) {
            com.tencent.mobileqq.vas.lovechat.a aVar = (com.tencent.mobileqq.vas.lovechat.a) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.lovechat.a.class);
            a.C1005a a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
            String f16 = aVar.f(i3);
            Intrinsics.checkNotNullExpressionValue(f16, "business.getPendantDrawablePath(id)");
            return a16.d(f16).i("RECENT").a();
        }
    };

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static final Function1<Integer, Drawable> f310571e = new Function1<Integer, LoveChatBgDrawable>() { // from class: com.tencent.mobileqq.vas.process.VasRecentInfoProcess$Companion$sLoveChatBackgroundInvoke$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ LoveChatBgDrawable invoke(Integer num) {
            return invoke(num.intValue());
        }

        @NotNull
        public final LoveChatBgDrawable invoke(int i3) {
            return new LoveChatBgDrawable(i3);
        }
    };

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Function1<Integer, Drawable> f310572f = new Function1<Integer, RecentPendantDrawable>() { // from class: com.tencent.mobileqq.vas.process.VasRecentInfoProcess$Companion$sVasPendantInvoke$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ RecentPendantDrawable invoke(Integer num) {
            return invoke(num.intValue());
        }

        @NotNull
        public final RecentPendantDrawable invoke(int i3) {
            return new RecentPendantDrawable(i3);
        }
    };

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    private static final Function2<Integer, Long, Drawable> f310573g = new Function2<Integer, Long, FastDynamicDrawable>() { // from class: com.tencent.mobileqq.vas.process.VasRecentInfoProcess$Companion$sUnreadBubbleInvoke$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ FastDynamicDrawable invoke(Integer num, Long l3) {
            return invoke(num.intValue(), l3.longValue());
        }

        @NotNull
        public final FastDynamicDrawable invoke(int i3, long j3) {
            BubbleBusiness bubbleBusiness = (BubbleBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(BubbleBusiness.class);
            a.C1005a a16 = com.tencent.cachedrawable.dynamicdrawable.api.a.a();
            String unreadPath = bubbleBusiness.getUnreadPath(i3, j3);
            Intrinsics.checkNotNullExpressionValue(unreadPath, "business.getUnreadPath(id, unreadNum)");
            return a16.d(unreadPath).i("RECENT").a();
        }
    };

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final a frequency = new a();

    private final void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item, String uin) {
        int colorName;
        String str;
        item.U(new g.h());
        IVasRecentData.FriendsVipData friendsVipData = ((IVasRecentData) QRoute.api(IVasRecentData.class)).getFriendsVipData(uin, true);
        VipData vipDataForFriends = ((IVipDataUtils) QRoute.api(IVipDataUtils.class)).getVipDataForFriends(uin);
        friendsVipData.setSpecialShapeMaskId(vipDataForFriends.getSpecialAvatarId());
        if (vipDataForFriends.getUseDefaultNickColor()) {
            colorName = -1;
        } else {
            colorName = vipDataForFriends.getColorName();
        }
        friendsVipData.setColorName(colorName);
        String str2 = null;
        if (friendsVipData.getIsLove() && friendsVipData.getLoveChatItemId() == 0) {
            IVipDataUtils iVipDataUtils = (IVipDataUtils) QRoute.api(IVipDataUtils.class);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                str = peekAppRuntime.getCurrentUin();
            } else {
                str = null;
            }
            friendsVipData.setLoveChatItemId(iVipDataUtils.getVipDataForFriends(str).getLoveChatItemId());
        }
        if (vipDataForFriends.getPendantIsVip() && vipDataForFriends.getPendantItemId() > 0) {
            friendsVipData.setPendantItemId(vipDataForFriends.getPendantItemId());
        }
        if (vipDataForFriends.getNameplateItemId() > 0) {
            friendsVipData.setDiyNamePlateItemId(vipDataForFriends.getNameplateItemId());
            friendsVipData.getDiyNamePlateContentIds().add(Integer.valueOf(vipDataForFriends.getNameplateFgId()));
            for (int i3 : vipDataForFriends.getNameplateLetters()) {
                friendsVipData.getDiyNamePlateContentIds().add(Integer.valueOf(i3));
            }
        }
        if (!friendsVipData.getIsSuperVip()) {
            friendsVipData.setNamePlateId(-1);
        }
        Integer num = item.s().vasMsgInfo.bubbleId;
        if (num != null) {
            friendsVipData.setBubbleId(num.intValue());
        }
        this.frequency.a(item, friendsVipData);
        VASPersonalNamePlate vASPersonalNamePlate = new VASPersonalNamePlate(Integer.valueOf(friendsVipData.getGrayNameplateFlag()), Integer.valueOf(friendsVipData.getVipType()), Integer.valueOf(friendsVipData.getVipLevel()), Integer.valueOf(friendsVipData.getNamePlateId()), friendsVipData.getCarouselNamePlateIds(), Integer.valueOf(friendsVipData.getDiyNamePlateItemId()), friendsVipData.getDiyNamePlateContentIds(), Integer.valueOf(friendsVipData.getVipIconEx()), Integer.valueOf(friendsVipData.getGameCardId()), 0, 0);
        g.h hVar = new g.h();
        hVar.t(friendsVipData.getColorName());
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime2 != null) {
            str2 = peekAppRuntime2.getCurrentUin();
        }
        if (str2 == null) {
            str2 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str2, "MobileQQ.sMobileQQ.peekA\u2026ntime()?.currentUin ?: \"\"");
        }
        hVar.s(VipNtMMKV.INSTANCE.getShowColorName().decodeBool(str2, true));
        hVar.y(vASPersonalNamePlate);
        hVar.v(friendsVipData.getLoveChatItemId());
        if (hVar.b() > 0) {
            hVar.x(f310569c);
            hVar.w(f310570d);
            hVar.u(f310571e);
        }
        if (!SimpleUIUtil.isNowSimpleMode()) {
            hVar.D(friendsVipData.getPendantItemId());
            hVar.z(friendsVipData.getThemePendantId());
        }
        if (hVar.i() > 0 || hVar.f() > 0) {
            hVar.C(f310572f);
        }
        if (friendsVipData.getBubbleId() > 0 && new File(((BubbleBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(BubbleBusiness.class)).getUnreadPath(friendsVipData.getBubbleId(), 0L)).exists()) {
            hVar.A(friendsVipData.getBubbleId());
            hVar.B(f310573g);
        }
        item.U(hVar);
        item.s().vasPersonalInfo = new VASPersonalElement(vASPersonalNamePlate, Integer.valueOf(friendsVipData.getColorName()), Integer.valueOf(friendsVipData.getLoveChatItemId()), 0L, Integer.valueOf(friendsVipData.getPendantItemId()), 0, 0);
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public boolean matchPayload(@NotNull f payload) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (!(payload instanceof k) && !(payload instanceof com.tencent.qqnt.chats.data.converter.a)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull c params) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        if (item.n() != 1) {
            IVasRecentData.FriendsVipData friendsVipData = ((IVasRecentData) QRoute.api(IVasRecentData.class)).getFriendsVipData("");
            this.frequency.a(item, friendsVipData);
            g.h hVar = new g.h();
            hVar.z(friendsVipData.getThemePendantId());
            if (hVar.f() > 0) {
                hVar.C(f310572f);
            }
            item.U(hVar);
            return;
        }
        VasLogNtReporter.INSTANCE.getRecentDraw().reportDebug("[processRecent]: msgId is " + item.s().getMsgId() + " send[" + item.s().senderUin + "] peer[" + item.s().peerUin + "]");
        a(item, String.valueOf(item.s().peerUin));
    }
}
