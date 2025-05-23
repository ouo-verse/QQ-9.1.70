package com.tencent.mobileqq.nearby.now;

import com.tencent.mobileqq.app.BusinessObserver;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 == 1000 && z16) {
            Object[] objArr = (Object[]) obj;
            a(((Boolean) objArr[0]).booleanValue(), (String) objArr[1]);
        }
    }

    protected void a(boolean z16, String str) {
    }
}
