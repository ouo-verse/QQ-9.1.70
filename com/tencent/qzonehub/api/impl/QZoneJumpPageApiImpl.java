package com.tencent.qzonehub.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.qzone.util.aq;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.utils.abtest.QCommonOnlineExpProviderImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qzonehub.api.IQZoneApiProxy;
import com.tencent.qzonehub.api.IQZoneJumpPageApi;
import cooperation.qzone.util.QZLog;
import mqq.app.MobileQQ;

/* loaded from: classes34.dex */
public class QZoneJumpPageApiImpl implements IQZoneJumpPageApi {
    private static final String TAG = "QZoneJumpPageApiImpl";
    private IQZoneApiProxy mQZoneApiProxy = null;
    private IAccountRuntime mAccountRuntime = null;

    private IAccountRuntime getAccountRuntime() {
        if (this.mAccountRuntime == null) {
            this.mAccountRuntime = (IAccountRuntime) QRoute.api(IAccountRuntime.class);
        }
        return this.mAccountRuntime;
    }

    private IQZoneApiProxy getApiProxy() {
        if (this.mQZoneApiProxy == null) {
            this.mQZoneApiProxy = (IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class);
        }
        return this.mQZoneApiProxy;
    }

    private boolean isCurrentLoginUser(long j3) {
        IAccountRuntime accountRuntime = getAccountRuntime();
        return accountRuntime != null && TextUtils.equals(String.valueOf(j3), accountRuntime.getAccount());
    }

    @Override // com.tencent.qzonehub.api.IQZoneJumpPageApi
    public boolean isCallToProfileCard(Context context) {
        if (com.qzone.reborn.feedpro.utils.d.f54318a.b()) {
            return true;
        }
        boolean needShowQzoneFrame = ((IQZoneApiProxy) QRoute.api(IQZoneApiProxy.class)).needShowQzoneFrame(context, MobileQQ.sMobileQQ.peekAppRuntime());
        boolean t16 = StudyModeManager.t();
        QZLog.d(TAG, 1, "[isCallToProfileCard] isShowQzoneFrame: " + needShowQzoneFrame + " | isStudyMode = " + t16);
        return needShowQzoneFrame && !t16;
    }

    @Override // com.tencent.qzonehub.api.IQZoneJumpPageApi
    public boolean isNewQConciseFragment(Context context) {
        return QCommonOnlineExpProviderImpl.EXP_QQ_LEBA_CONCISE_THEME_CONTENT_B.equals(getApiProxy().getExpContentInSimpleUI());
    }

    @Override // com.tencent.qzonehub.api.IQZoneJumpPageApi
    public void jumpToQQProfileCardIntent(long j3, int i3) {
        int i16;
        try {
            if (isCurrentLoginUser(j3)) {
                i16 = 0;
            } else {
                i16 = aq.b(j3) ? 60 : 61;
            }
            AllInOne allInOne = new AllInOne(String.valueOf(j3), i16);
            allInOne.profileEntryType = i3;
            if (i3 == 125) {
                allInOne.f260789pa = 96;
                allInOne.subSourceId = 3;
            }
            ProfileUtils.openProfileCard(BaseApplication.getContext(), allInOne);
        } catch (Throwable th5) {
            QZLog.e(TAG, "jump to qq profile card failed!", th5);
        }
    }
}
