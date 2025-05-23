package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.BusinessObserver;

/* compiled from: P */
/* loaded from: classes18.dex */
public class v implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4 && obj != null) {
                        Object[] objArr = (Object[]) obj;
                        if (objArr.length == 1) {
                            b(((Integer) objArr[0]).intValue());
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (obj != null) {
                    Object[] objArr2 = (Object[]) obj;
                    if (objArr2.length == 2) {
                        a(z16, (String) objArr2[0], (String) objArr2[1]);
                        return;
                    }
                    return;
                }
                return;
            }
            if (obj != null) {
                Object[] objArr3 = (Object[]) obj;
                if (objArr3.length == 4) {
                    c((String) objArr3[0], (String) objArr3[1], (String) objArr3[2], (String) objArr3[3]);
                    return;
                }
                return;
            }
            return;
        }
        if (obj != null) {
            Object[] objArr4 = (Object[]) obj;
            if (objArr4.length == 2) {
                d((String) objArr4[0], (String) objArr4[1]);
            }
        }
    }

    public void b(int i3) {
    }

    public void d(String str, String str2) {
    }

    public void a(boolean z16, String str, String str2) {
    }

    public void c(String str, String str2, String str3, String str4) {
    }
}
