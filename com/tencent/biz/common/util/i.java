package com.tencent.biz.common.util;

import com.tencent.mobileqq.app.bs;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class i extends bs {
    protected void a(boolean z16, OpenID openID) {
        throw null;
    }

    @Override // com.tencent.mobileqq.app.bs, com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 == 1) {
            QLog.d("openid", 2, "isSuccess=" + z16 + ",data=" + obj);
            a(z16, (OpenID) obj);
        }
    }
}
