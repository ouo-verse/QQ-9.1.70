package com.tencent.biz.qqcircle.entrance;

import com.tencent.biz.qqcircle.QCirclePluginGlobalInfo;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.broadcast.QFSGlobalBroadcastHelper;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.qqcircle.utils.ai;
import cooperation.qqcircle.proxy.QCircleInvokeModule;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a implements QCircleInvokeModule {
    @Override // cooperation.qqcircle.proxy.QCircleInvokeModule
    public void invoke(int i3, int i16, Object... objArr) {
        if (i16 == 1) {
            QCirclePluginGlobalInfo.P();
            QFSGlobalBroadcastHelper.c().e();
            QCirclePluginUtil.release();
            ai.c();
            return;
        }
        if (i16 == 3) {
            QCircleBindPhoneNumberHelper.d();
        }
    }
}
