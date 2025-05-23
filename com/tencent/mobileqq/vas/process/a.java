package com.tencent.mobileqq.vas.process;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasRecentData;
import com.tencent.mobileqq.vas.updatesystem.api.IVasBusinessManager;
import com.tencent.mobileqq.vas.updatesystem.business.ColorNameBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.DiyVipIconDownloadBusiness;
import com.tencent.mobileqq.vas.vipicon.k;
import com.tencent.mobileqq.vip.api.i;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/process/a;", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/mobileqq/vas/api/IVasRecentData$FriendsVipData;", "data", "", "a", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {
    public final void a(@NotNull g item, @NotNull IVasRecentData.FriendsVipData data) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(data, "data");
        int specialShapeMaskId = data.getSpecialShapeMaskId();
        if (specialShapeMaskId > 0 && !((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 333L).isFileExists(specialShapeMaskId)) {
            new i.e(specialShapeMaskId).g(item.s());
            data.setSpecialShapeMaskId(0);
        }
        int diyNamePlateItemId = data.getDiyNamePlateItemId();
        if (diyNamePlateItemId > 0 && !((DiyVipIconDownloadBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(DiyVipIconDownloadBusiness.class)).isFileExists(diyNamePlateItemId)) {
            new i.j(diyNamePlateItemId).g(item.s());
            data.setDiyNamePlateItemId(0);
        }
        if (data.getVipType() > 0 && data.getNamePlateId() >= 0) {
            int namePlateId = data.getNamePlateId();
            com.tencent.mobileqq.vas.vipicon.g gVar = (com.tencent.mobileqq.vas.vipicon.g) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.vipicon.g.class);
            if (!gVar.isFileExists(namePlateId)) {
                new i.l(namePlateId).g(item.s());
                data.setNamePlateId(-1);
            }
            ArrayList<Integer> carouselNamePlateIds = data.getCarouselNamePlateIds();
            boolean z16 = true;
            if (!carouselNamePlateIds.isEmpty()) {
                Iterator<T> it = carouselNamePlateIds.iterator();
                while (it.hasNext()) {
                    int intValue = ((Number) it.next()).intValue();
                    if (!gVar.isFileExists(intValue)) {
                        new i.l(intValue).g(item.s());
                        z16 = false;
                    }
                }
                if (!z16) {
                    data.getCarouselNamePlateIds().clear();
                }
            }
        }
        int vipIconEx = data.getVipIconEx();
        if (vipIconEx > 0 && !((k) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(k.class)).isFileExists(vipIconEx)) {
            new i.m(vipIconEx).g(item.s());
            data.setVipIconEx(0);
        }
        int colorName = data.getColorName();
        if (colorName > 0 && !((ColorNameBusiness) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(ColorNameBusiness.class)).isFileExists(colorName)) {
            new i.C8957i(data.getColorName()).g(item.s());
            data.setColorName(0);
        }
        int loveChatItemId = data.getLoveChatItemId();
        if (loveChatItemId > 0 && !((com.tencent.mobileqq.vas.lovechat.a) ((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance(com.tencent.mobileqq.vas.lovechat.a.class)).isFileExists(loveChatItemId)) {
            new i.c(loveChatItemId).g(item.s());
            data.setLoveChatItemId(0);
        }
        int pendantItemId = data.getPendantItemId();
        if (pendantItemId > 0) {
            try {
                if (!((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 4L).isFileExists(pendantItemId)) {
                    new i.d(pendantItemId).g(item.s());
                    data.setPendantItemId(0);
                }
            } catch (NullPointerException unused) {
            }
        }
        int themePendantId = data.getThemePendantId();
        if (themePendantId > 0) {
            try {
                if (!((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 4L).isFileExists(themePendantId)) {
                    new i.d(themePendantId).g(item.s());
                    data.setThemePendantId(0);
                }
            } catch (NullPointerException unused2) {
            }
        }
        int bubbleId = data.getBubbleId();
        if (bubbleId > 0 && !((IVasBusinessManager) QRoute.api(IVasBusinessManager.class)).getBusinessInstance((Long) 2L).isFileExists(bubbleId)) {
            new i.f(bubbleId).g(item.s());
            data.setBubbleId(0);
        }
    }
}
