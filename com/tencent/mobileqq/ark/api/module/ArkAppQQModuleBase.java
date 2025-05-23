package com.tencent.mobileqq.ark.api.module;

import android.app.Activity;
import com.tencent.aio.data.AIOContact;
import com.tencent.ark.ark;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.module.b;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class ArkAppQQModuleBase extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    public ArkAppQQModuleBase(ark.Application application, int i3) {
        super(application, i3);
    }

    public static Activity f() {
        Activity f16 = b.f();
        if (f16 != null) {
            return f16;
        }
        if (MobileQQ.sProcessId == 2) {
            return BaseApplicationImpl.getApplication().getResumeActivity();
        }
        return null;
    }

    public static QQAppInterface p() {
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        if (runtime instanceof QQAppInterface) {
            return (QQAppInterface) runtime;
        }
        return null;
    }

    public static AIOContact q() {
        Activity f16 = f();
        if (f16 instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) f16;
            com.tencent.qqnt.aio.utils.a aVar = com.tencent.qqnt.aio.utils.a.f352276a;
            AIOContact a16 = aVar.a(baseActivity);
            if (a16 == null && (baseActivity instanceof MiniChatActivity)) {
                return aVar.a(baseActivity);
            }
            return a16;
        }
        return null;
    }
}
