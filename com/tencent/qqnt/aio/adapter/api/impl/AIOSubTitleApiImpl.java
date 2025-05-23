package com.tencent.qqnt.aio.adapter.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.adapter.api.IAIOSubTitleApi;
import com.tencent.qqnt.aio.helper.C2CSubTitleHelper;
import com.tencent.qqnt.aio.helper.fi;
import com.tencent.qqnt.ntrelation.onlinestatusinfo.api.IOnlineStatusInfoService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOSubTitleApiImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOSubTitleApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "isRobotPeer", "Lcom/tencent/qqnt/ntrelation/onlinestatusinfo/bean/c;", "simpleInfo", "Lcom/tencent/mobileqq/onlinestatus/au;", "onlineStatusItem", "", "getStatusName", "isSelf", "getOnlineStatusItem", "mAIOContext", "Lcom/tencent/mobileqq/aio/title/ai;", "getTroopSubTitleData", "getC2CSubTitleData", "", "onRoamLoadingEnd", "getSubTitleSync", "<init>", "()V", "Companion", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class AIOSubTitleApiImpl implements IAIOSubTitleApi {
    public static final String TAG = "AIOSubTitleApiImpl";

    private final com.tencent.mobileqq.aio.title.ai getC2CSubTitleData(com.tencent.aio.api.runtime.a mAIOContext) {
        String b16;
        AIOParam g16;
        AIOSession r16;
        AIOContact c16;
        String j3;
        com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c onlineStatusSimpleInfoWithUid;
        if (isRobotPeer(mAIOContext)) {
            return null;
        }
        C2CSubTitleHelper.Companion companion = C2CSubTitleHelper.INSTANCE;
        com.tencent.mobileqq.aio.title.ai a16 = companion.a(mAIOContext);
        if (a16 != null) {
            return a16;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
        AIOParam g17 = mAIOContext.g();
        if (g17 == null || (b16 = su3.c.b(g17)) == null || (g16 = mAIOContext.g()) == null || (r16 = g16.r()) == null || (c16 = r16.c()) == null || (j3 = c16.j()) == null || (onlineStatusSimpleInfoWithUid = ((IOnlineStatusInfoService) QRoute.api(IOnlineStatusInfoService.class)).getOnlineStatusSimpleInfoWithUid(j3, "AIOSubTitleApiImpl_getC2CSubTitleData")) == null || !companion.b(onlineStatusSimpleInfoWithUid)) {
            return null;
        }
        boolean areEqual = Intrinsics.areEqual(b16, qQAppInterface.getCurrentUin());
        com.tencent.mobileqq.onlinestatus.au onlineStatusItem = getOnlineStatusItem(areEqual, onlineStatusSimpleInfoWithUid);
        if (onlineStatusItem.f255489b == 1000 && areEqual) {
            return null;
        }
        Drawable[] subtitleOnlineDrawable = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getSubtitleOnlineDrawable(qQAppInterface, onlineStatusSimpleInfoWithUid, true, true);
        return new com.tencent.mobileqq.aio.title.ai(null, subtitleOnlineDrawable[0], subtitleOnlineDrawable[1], getStatusName(onlineStatusSimpleInfoWithUid, onlineStatusItem), "1");
    }

    private final com.tencent.mobileqq.onlinestatus.au getOnlineStatusItem(boolean isSelf, com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c simpleInfo) {
        com.tencent.mobileqq.onlinestatus.au onlineStatusItem = ((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOnlineStatusItem(((IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class)).getOldStatus(simpleInfo), simpleInfo.e0(), !isSelf);
        Intrinsics.checkNotNullExpressionValue(onlineStatusItem, "api(IOnLineStatueHelperA\u2026        !isSelf\n        )");
        return onlineStatusItem;
    }

    private final String getStatusName(com.tencent.qqnt.ntrelation.onlinestatusinfo.bean.c simpleInfo, com.tencent.mobileqq.onlinestatus.au onlineStatusItem) {
        boolean z16 = com.tencent.mobileqq.friend.status.b.a(simpleInfo.u(), simpleInfo.z()) == 4 && onlineStatusItem.f255489b > 0;
        IOnLineStatueHelperApi iOnLineStatueHelperApi = (IOnLineStatueHelperApi) QRoute.api(IOnLineStatueHelperApi.class);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
        String displayOnlineStatusInfo = iOnLineStatueHelperApi.getDisplayOnlineStatusInfo((QQAppInterface) peekAppRuntime, simpleInfo, null, 1, onlineStatusItem, Boolean.valueOf(z16));
        Intrinsics.checkNotNullExpressionValue(displayOnlineStatusInfo, "api(IOnLineStatueHelperA\u2026NewOnlineStatus\n        )");
        return displayOnlineStatusInfo;
    }

    private final com.tencent.mobileqq.aio.title.ai getTroopSubTitleData(com.tencent.aio.api.runtime.a mAIOContext) {
        return fi.INSTANCE.a(mAIOContext);
    }

    private final boolean isRobotPeer(com.tencent.aio.api.runtime.a aioContext) {
        String b16;
        AIOParam g16 = aioContext.g();
        if (g16 == null || (b16 = su3.c.b(g16)) == null) {
            return false;
        }
        return com.tencent.mobileqq.troop.utils.k.l(MobileQQ.sMobileQQ.peekAppRuntime(), b16);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOSubTitleApi
    public com.tencent.mobileqq.aio.title.ai getSubTitleSync(com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        int e16 = aioContext.g().r().c().e();
        if (e16 == 1) {
            return getC2CSubTitleData(aioContext);
        }
        if (e16 != 2) {
            return null;
        }
        return getTroopSubTitleData(aioContext);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOSubTitleApi
    public void onRoamLoadingEnd(com.tencent.aio.api.runtime.a aioContext) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        aioContext.e().h(new AIOTitleEvent.SubTitleRequestEvent(1));
    }
}
