package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ag implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        boolean z17 = false;
        switch (i3) {
            case 1:
                if (obj != null) {
                    Object[] objArr = (Object[]) obj;
                    if (objArr.length == 2) {
                        e((String) objArr[0], (TeamWorkFileImportInfo) objArr[1]);
                        return;
                    }
                    return;
                }
                return;
            case 2:
                if (obj != null) {
                    a((TeamWorkFileImportInfo) obj);
                    return;
                }
                return;
            case 3:
                if (obj != null) {
                    Object[] objArr2 = (Object[]) obj;
                    if (objArr2.length == 1) {
                        c(((Integer) objArr2[0]).intValue());
                        return;
                    }
                    return;
                }
                return;
            case 4:
                if (obj != null) {
                    d((TeamWorkFileImportInfo) obj);
                    return;
                }
                return;
            case 5:
                if (obj != null) {
                    Object[] objArr3 = (Object[]) obj;
                    if (objArr3.length == 1) {
                        if (((Integer) objArr3[0]).intValue() > 0) {
                            z17 = true;
                        }
                        b(z17);
                        return;
                    }
                    return;
                }
                return;
            case 6:
                if (obj != null) {
                    Object[] objArr4 = (Object[]) obj;
                    if (objArr4.length == 3) {
                        f((String) objArr4[0], (String) objArr4[1], (TeamWorkFileImportInfo) objArr4[2]);
                        return;
                    }
                    return;
                }
                return;
            case 7:
                if (obj != null) {
                    Object[] objArr5 = (Object[]) obj;
                    if (objArr5.length == 1) {
                        g((TeamWorkFileImportInfo) objArr5[0]);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void a(TeamWorkFileImportInfo teamWorkFileImportInfo) {
    }

    public void b(boolean z16) {
    }

    public void c(int i3) {
    }

    public void d(TeamWorkFileImportInfo teamWorkFileImportInfo) {
    }

    public void g(TeamWorkFileImportInfo teamWorkFileImportInfo) {
    }

    public void e(String str, TeamWorkFileImportInfo teamWorkFileImportInfo) {
    }

    public void f(String str, String str2, TeamWorkFileImportInfo teamWorkFileImportInfo) {
    }
}
