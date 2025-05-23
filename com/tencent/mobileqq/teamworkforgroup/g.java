package com.tencent.mobileqq.teamworkforgroup;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g implements BusinessObserver {

    /* renamed from: d, reason: collision with root package name */
    public static String f292610d = "GroupTeamWorkObserver";

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (QLog.isColorLevel()) {
            QLog.i(f292610d, 2, "GroupTeamWorkObserver type=" + i3 + ", isSuccess=" + z16);
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 7 && obj != null) {
                            Object[] objArr = (Object[]) obj;
                            if (objArr.length == 3) {
                                e(z16, ((Integer) objArr[0]).intValue(), (String) objArr[1]);
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    if (obj != null) {
                        Object[] objArr2 = (Object[]) obj;
                        if (objArr2.length == 2) {
                            a(z16, ((Integer) objArr2[0]).intValue(), (String) objArr2[1]);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (obj != null) {
                    Object[] objArr3 = (Object[]) obj;
                    if (objArr3.length == 3) {
                        c(z16, ((Integer) objArr3[0]).intValue(), (String) objArr3[1], (List) objArr3[2]);
                        return;
                    }
                    return;
                }
                return;
            }
            if (obj != null) {
                Object[] objArr4 = (Object[]) obj;
                if (objArr4.length == 5) {
                    d(z16, ((Integer) objArr4[0]).intValue(), (String) objArr4[1], (List) objArr4[2], ((Integer) objArr4[3]).intValue(), ((Boolean) objArr4[4]).booleanValue());
                    return;
                }
                return;
            }
            return;
        }
        if (obj != null) {
            Object[] objArr5 = (Object[]) obj;
            if (objArr5.length == 5) {
                b(z16, ((Integer) objArr5[0]).intValue(), (String) objArr5[1], (List) objArr5[2], ((Integer) objArr5[3]).intValue(), ((Integer) objArr5[4]).intValue());
            }
        }
    }

    public void a(boolean z16, int i3, String str) {
    }

    public void e(boolean z16, int i3, String str) {
    }

    public void c(boolean z16, int i3, String str, List<GPadInfo> list) {
    }

    public void b(boolean z16, int i3, String str, List<GPadInfo> list, int i16, int i17) {
    }

    public void d(boolean z16, int i3, String str, List<GPadInfo> list, int i16, boolean z17) {
    }
}
