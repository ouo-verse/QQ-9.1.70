package com.qzone.proxy.covercomponent;

import com.qzone.common.account.LoginData;
import com.qzone.module.covercomponent.manage.CoverCacheManager;
import com.qzone.proxy.covercomponent.QzoneCoverConst;
import com.qzone.proxy.covercomponent.env.CoverEnv;
import cooperation.qzone.model.CoverCacheData;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QZoneCoverUtils {
    public static int getSuperCoverTrans(CoverCacheData coverCacheData) {
        if (coverCacheData == null) {
            return CoverCacheManager.getSuperCoverTransFromMemory(LoginData.getInstance().getUin());
        }
        if (QzoneCoverConst.CoverStringType.COVER_TYPE_FULL_SCREEN.equals(coverCacheData.type) && coverCacheData.mapExtInfo != null && CoverEnv.isSupportSuperCover()) {
            return CoverCacheManager.transparencyValueRealValue(coverCacheData.mapExtInfo.get(QzoneCoverConst.KEY_TRANSPARENCY));
        }
        return 255;
    }
}
