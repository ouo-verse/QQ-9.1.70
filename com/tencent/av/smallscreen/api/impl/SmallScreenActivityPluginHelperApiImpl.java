package com.tencent.av.smallscreen.api.impl;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.smallscreen.api.ISmallScreenActivityPluginHelperApi;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes32.dex */
public class SmallScreenActivityPluginHelperApiImpl implements ISmallScreenActivityPluginHelperApi {
    private static final String TAG = "SmallScreenActivityPluginHelperApiImpl";

    @Override // com.tencent.av.smallscreen.api.ISmallScreenActivityPluginHelperApi
    public void onPauseRender(final long j3, final BaseVideoAppInterface baseVideoAppInterface, final boolean z16, boolean z17) {
        if (baseVideoAppInterface instanceof VideoAppInterface) {
            final boolean h16 = r.h1(baseVideoAppInterface.getApp());
            if (QLog.isColorLevel() || !h16 || z17) {
                QLog.w(TAG, 1, "onPauseRender, isQuit[" + z17 + "], isScreenOn[" + h16 + "], seq[" + j3 + "]");
            }
            if (z17) {
                return;
            }
            if (SmallScreenUtils.w()) {
                final SessionInfo f16 = n.e().f();
                int i3 = f16.f73035i;
                final boolean z18 = i3 == 2 || i3 == 4;
                final boolean m3 = r.h0().x0().m();
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.smallscreen.api.impl.SmallScreenActivityPluginHelperApiImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SmallScreenUtils.c(j3, 2, baseVideoAppInterface.getApp(), z16 && h16 && !m3, baseVideoAppInterface.getCurrentAccountUin(), z18, f16.H2);
                    }
                }, 16, null, false);
                SmallScreenUtilsApiImpl.reportActionOn(baseVideoAppInterface.getApp(), f16);
                return;
            }
            SmallScreenUtils.B(j3, baseVideoAppInterface, 2);
            return;
        }
        QLog.e(TAG, 1, "invalid BaseVideoAppInterface");
    }
}
