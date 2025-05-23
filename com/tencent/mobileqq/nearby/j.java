package com.tencent.mobileqq.nearby;

import com.tencent.mobileqq.app.BusinessObserver;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class j implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 != 12) {
            switch (i3) {
                case 4:
                    Object[] objArr = (Object[]) obj;
                    d(z16, (String) objArr[0], (List) objArr[1], (String) objArr[2], ((Integer) objArr[3]).intValue(), ((Integer) objArr[4]).intValue());
                    return;
                case 5:
                    Object[] objArr2 = (Object[]) obj;
                    if (z16 && objArr2 != null && objArr2.length == 1) {
                        b(z16, (List) objArr2[0]);
                        return;
                    } else {
                        b(false, null);
                        return;
                    }
                case 6:
                    f(z16, ((Boolean) ((Object[]) obj)[0]).booleanValue());
                    return;
                case 7:
                    e(z16);
                    return;
                case 8:
                    Object[] objArr3 = (Object[]) obj;
                    a((String) objArr3[0], (String) objArr3[1], objArr3[2]);
                    return;
                default:
                    return;
            }
        }
        c(z16);
    }

    protected void c(boolean z16) {
    }

    public void e(boolean z16) {
    }

    public void b(boolean z16, List<Object> list) {
    }

    public void f(boolean z16, boolean z17) {
    }

    public void a(String str, String str2, Object obj) {
    }

    public void d(boolean z16, String str, List<m92.a> list, String str2, int i3, int i16) {
    }
}
