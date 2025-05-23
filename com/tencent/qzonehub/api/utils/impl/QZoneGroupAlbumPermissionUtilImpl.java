package com.tencent.qzonehub.api.utils.impl;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.troopgag.api.ITroopGagService;
import com.tencent.mobileqq.troop.troopgag.data.d;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.utils.IQZoneGroupAlbumPermissionUtil;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes34.dex */
public class QZoneGroupAlbumPermissionUtilImpl implements IQZoneGroupAlbumPermissionUtil {
    private static final String TAG = "QZoneGroupAlbumArkUtilImpl";

    @Override // com.tencent.qzonehub.api.utils.IQZoneGroupAlbumPermissionUtil
    public boolean isSupportForwardToGroupAlbum(String str) {
        if (str.isEmpty()) {
            QLog.d(TAG, 1, "isSupportForwardToGroupAlbum groupCode empty");
            return false;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d(TAG, 1, "isSupportForwardToGroupAlbum runtime null");
            return false;
        }
        d selfGagInfo = ((ITroopGagService) peekAppRuntime.getRuntimeService(ITroopGagService.class, "")).getSelfGagInfo(str, true);
        if (selfGagInfo != null && selfGagInfo.f300235b) {
            return false;
        }
        TroopInfo findTroopInfo = ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(str);
        if (findTroopInfo != null) {
            return findTroopInfo.isOwnerOrAdmin() || (findTroopInfo.troopPrivilegeFlag & 1) == 0;
        }
        QLog.d(TAG, 1, "isSupportForwardToGroupAlbum info null");
        return false;
    }
}
