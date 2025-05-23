package com.tencent.mobileqq.location.util;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.location.qq_lbs_share$ResultInfo;
import tencent.im.oidb.location.qq_lbs_share$RoomKey;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    @NonNull
    public static qq_lbs_share$RoomKey a(AppRuntime appRuntime, int i3, long j3) {
        qq_lbs_share$RoomKey qq_lbs_share_roomkey = new qq_lbs_share$RoomKey();
        if (i3 == 0) {
            qq_lbs_share_roomkey.aio_type.set(2);
            qq_lbs_share_roomkey.f436010id1.set(Math.min(j3, appRuntime.getLongAccountUin()));
            qq_lbs_share_roomkey.f436011id2.set(Math.max(j3, appRuntime.getLongAccountUin()));
        } else if (i3 == 1) {
            qq_lbs_share_roomkey.aio_type.set(1);
            qq_lbs_share_roomkey.f436010id1.set(j3);
            qq_lbs_share_roomkey.f436011id2.set(0L);
        }
        qq_lbs_share_roomkey.setHasFlag(true);
        return qq_lbs_share_roomkey;
    }

    public static boolean b(String str) {
        com.tencent.qqnt.ntrelation.otherinfo.bean.c otherSimpleInfoWithUid = ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).getOtherSimpleInfoWithUid(((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str), "LocationProtoUtil");
        if (otherSimpleInfoWithUid == null || otherSimpleInfoWithUid.l() != 1) {
            return false;
        }
        return true;
    }

    public static boolean c(String str) {
        TroopInfo troopInfo = ((ITroopInfoService) MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(ITroopInfoService.class, "")).getTroopInfo(str);
        if (troopInfo == null) {
            return false;
        }
        return troopInfo.isSharingLocation();
    }

    public static boolean d(int i3, String str) {
        if (i3 == 0) {
            return b(str);
        }
        if (i3 == 1) {
            return c(str);
        }
        return false;
    }

    public static boolean e(qq_lbs_share$ResultInfo qq_lbs_share_resultinfo) {
        if (qq_lbs_share_resultinfo == null) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LocationProtoUtil", 2, "rspSuccess: invoked. ", " resultInfo.uint32_result: ", Integer.valueOf(qq_lbs_share_resultinfo.uint32_result.get()), " resultInfo.bytes_errmsg: ", qq_lbs_share_resultinfo.bytes_errmsg.get().toStringUtf8(), " resultInfo.uint64_svr_time: ", Long.valueOf(qq_lbs_share_resultinfo.uint64_svr_time.get()));
        }
        if (qq_lbs_share_resultinfo.uint32_result.get() != 0) {
            return false;
        }
        return true;
    }

    public static void f(AppRuntime appRuntime, int i3, String str, boolean z16) {
        if (i3 == 0) {
            String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
            IOtherInfoService iOtherInfoService = (IOtherInfoService) QRoute.api(IOtherInfoService.class);
            com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.c(uidFromUin, str);
            cVar.m();
            cVar.r(z16 ? 1 : 0);
            iOtherInfoService.accurateUpdateNTOtherSimpleInfo(cVar, "LocationProtoUtil", (hx3.c<com.tencent.qqnt.ntrelation.otherinfo.bean.c>) null);
            if (QLog.isColorLevel()) {
                QLog.d("LocationProtoUtil", 2, "updateShareLocationProfileFlag: invoked. saved share state. ", " ei.isSharingLocation: ", Integer.valueOf(cVar.l()));
                return;
            }
            return;
        }
        if (i3 == 1) {
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).updateShareLocationState(str, z16);
        }
    }
}
