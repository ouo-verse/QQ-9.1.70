package com.tencent.qqnt.chats.biz.onlinestatus.impl;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.onlinestatus.utils.u;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.biz.bean.a;
import com.tencent.qqnt.chats.biz.onlinestatus.IOnlineStatusChatsHelper;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.nativeinterface.LiteBusinessType;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/qqnt/chats/biz/onlinestatus/impl/OnlineStatusChatsHelperImpl;", "Lcom/tencent/qqnt/chats/biz/onlinestatus/IOnlineStatusChatsHelper;", "", "event", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "", "map", "", "addDTReportParams", "", "canOnlineStatusRevealShow", "<init>", "()V", "Companion", "a", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class OnlineStatusChatsHelperImpl implements IOnlineStatusChatsHelper {

    @NotNull
    private static final String TAG = "OnlineStatusChatsHelperImpl";

    @Override // com.tencent.qqnt.chats.biz.onlinestatus.IOnlineStatusChatsHelper
    public void addDTReportParams(@NotNull String event, @NotNull g item, @NotNull Map<String, Object> map) {
        boolean z16;
        c cVar;
        String str;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(map, "map");
        if (Intrinsics.areEqual(event, "qq_clck")) {
            a aVar = (a) item.h(LiteBusinessType.KONLINESTATUS);
            if (aVar != null) {
                cVar = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(item.k(), TAG);
                z16 = u.f256378a.a(cVar, aVar);
            } else {
                z16 = false;
                cVar = null;
            }
            if (z16) {
                str = "true";
            } else {
                str = "false";
            }
            map.put("is_status_icon_exposed", str);
            if (z16 && cVar != null) {
                map.put(ProfileCardDtReportUtil.STATUS_ID, String.valueOf(cVar.e0()));
            } else {
                map.put(ProfileCardDtReportUtil.STATUS_ID, "");
            }
        }
    }

    @Override // com.tencent.qqnt.chats.biz.onlinestatus.IOnlineStatusChatsHelper
    public boolean canOnlineStatusRevealShow(@NotNull g item) {
        Intrinsics.checkNotNullParameter(item, "item");
        a aVar = (a) item.h(LiteBusinessType.KONLINESTATUS);
        if (aVar == null) {
            return false;
        }
        return u.f256378a.a(((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(item.k(), TAG), aVar);
    }
}
