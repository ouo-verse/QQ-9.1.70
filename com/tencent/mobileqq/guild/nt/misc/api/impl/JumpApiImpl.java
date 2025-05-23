package com.tencent.mobileqq.guild.nt.misc.api.impl;

import android.content.Context;
import androidx.annotation.Nullable;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.guild.nt.misc.api.IJumpApi;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes14.dex */
public class JumpApiImpl implements IJumpApi {
    public static final String TAG = "JumpApiImpl";

    @Override // com.tencent.mobileqq.guild.nt.misc.api.IJumpApi
    public boolean doJumpAction(Context context, String str) {
        return doJumpAction(MobileQQ.sMobileQQ.peekAppRuntime(), context, str, null);
    }

    @Override // com.tencent.mobileqq.guild.nt.misc.api.IJumpApi
    public boolean doJumpAction(AppRuntime appRuntime, Context context, String str) {
        return doJumpAction(appRuntime, context, str, null);
    }

    @Override // com.tencent.mobileqq.guild.nt.misc.api.IJumpApi
    public boolean doJumpAction(@Nullable AppRuntime appRuntime, Context context, String str, IJumpApi.a aVar) {
        if (appRuntime != null && !(appRuntime instanceof BaseQQAppInterface)) {
            QLog.e(TAG, 1, "appRuntime is not BaseQQAppInterface");
            return false;
        }
        ax c16 = bi.c((BaseQQAppInterface) appRuntime, context, str);
        if (c16 != null) {
            applyOverrideOptions(c16, aVar);
            return c16.b();
        }
        QLog.e(TAG, 1, "jumpAction is null, schemeUrl = " + str);
        return false;
    }

    private void applyOverrideOptions(ax axVar, IJumpApi.a aVar) {
    }
}
