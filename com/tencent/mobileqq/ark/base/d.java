package com.tencent.mobileqq.ark.base;

import com.tencent.aio.data.AIOContact;
import com.tencent.mobileqq.app.QBaseActivity;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d extends DefaultApplicationCallback {
    public static boolean e() {
        AIOContact a16;
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null && (a16 = com.tencent.qqnt.aio.utils.a.f352276a.a(qBaseActivity)) != null && a16.e() == 103) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.ark.base.DefaultApplicationCallback
    public boolean b(String str) {
        if (!super.b(str)) {
            return false;
        }
        return !e();
    }
}
