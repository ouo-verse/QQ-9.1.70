package com.tencent.mobileqq.vas.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.vas.api.INtVipStatus;
import com.tencent.mobileqq.vas.util.VasUtil;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/NtVipStatusImpl;", "Lcom/tencent/mobileqq/vas/api/INtVipStatus;", "()V", "getPrivilegeFlags", "", "uin", "", "isBigClub", "", "isSVip", "isStar", "isSuperQQ", "isVip", "keyWordsEnable", "vas-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class NtVipStatusImpl implements INtVipStatus {
    @Override // com.tencent.mobileqq.vas.api.INtVipStatus
    public int getPrivilegeFlags(@Nullable String uin) {
        AppRuntime appRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            return 0;
        }
        return VasUtil.getSignedService(appRuntime).getVipStatus().getPrivilegeFlags(null);
    }

    @Override // com.tencent.mobileqq.vas.api.INtVipStatus
    public boolean isBigClub() {
        AppRuntime appRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            return false;
        }
        return VasUtil.getSignedService(appRuntime).getVipStatus().isBigClub();
    }

    @Override // com.tencent.mobileqq.vas.api.INtVipStatus
    public boolean isSVip() {
        AppRuntime appRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            return false;
        }
        return VasUtil.getSignedService(appRuntime).getVipStatus().isSVip();
    }

    @Override // com.tencent.mobileqq.vas.api.INtVipStatus
    public boolean isStar() {
        AppRuntime appRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            return false;
        }
        return VasUtil.getSignedService(appRuntime).getVipStatus().isStar();
    }

    @Override // com.tencent.mobileqq.vas.api.INtVipStatus
    public boolean isSuperQQ() {
        AppRuntime appRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            return false;
        }
        return VasUtil.getSignedService(appRuntime).getVipStatus().isSuperQQ();
    }

    @Override // com.tencent.mobileqq.vas.api.INtVipStatus
    public boolean isVip() {
        AppRuntime appRuntime;
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ != null) {
            appRuntime = mobileQQ.peekAppRuntime();
        } else {
            appRuntime = null;
        }
        if (appRuntime == null) {
            return false;
        }
        return VasUtil.getSignedService(appRuntime).getVipStatus().isVip();
    }

    @Override // com.tencent.mobileqq.vas.api.INtVipStatus
    public boolean keyWordsEnable() {
        return ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).keyWordIsEnable();
    }
}
