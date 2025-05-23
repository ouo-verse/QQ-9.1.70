package com.tencent.mobileqq.troop.api.impl;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.troop.TroopListRepo;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0002\u001a\f\u0010\u0006\u001a\u00020\u0002*\u00020\u0005H\u0002\u001a\f\u0010\u0007\u001a\u00020\u0002*\u00020\u0005H\u0002\u00a8\u0006\b"}, d2 = {"", "troopUin", "", "f", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", tl.h.F, "e", "qqtroop-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class l {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean e(RobotCoreInfo robotCoreInfo) {
        return robotCoreInfo.allowAddGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(String str) {
        TroopInfo troopInfoFromCache;
        if (str == null || (troopInfoFromCache = TroopListRepo.INSTANCE.getTroopInfoFromCache(str)) == null || !troopInfoFromCache.memberCanInviteRobot()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean g(String str) {
        TroopInfo troopInfoFromCache;
        if (str == null || (troopInfoFromCache = TroopListRepo.INSTANCE.getTroopInfoFromCache(str)) == null || !troopInfoFromCache.isOwnerOrAdmin()) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(RobotCoreInfo robotCoreInfo) {
        if (robotCoreInfo.allowAddGroup && robotCoreInfo.allowInvitedToGroup) {
            return true;
        }
        return false;
    }
}
