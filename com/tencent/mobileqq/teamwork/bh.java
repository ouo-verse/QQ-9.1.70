package com.tencent.mobileqq.teamwork;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.pb.teamwork.TimDocSSOMsg$UinRightInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class bh implements BusinessObserver {
    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 != 2) {
            if (i3 != 13) {
                switch (i3) {
                    case 5:
                        if (obj != null) {
                            Object[] objArr = (Object[]) obj;
                            d(z16, (String) objArr[0], ((Integer) objArr[1]).intValue());
                            return;
                        }
                        return;
                    case 6:
                        if (obj != null) {
                            Object[] objArr2 = (Object[]) obj;
                            h(z16, (String) objArr2[0], ((Integer) objArr2[1]).intValue());
                            return;
                        }
                        return;
                    case 7:
                        if (obj != null) {
                            Object[] objArr3 = (Object[]) obj;
                            c(z16, (String) objArr3[0], ((Integer) objArr3[1]).intValue(), (List) objArr3[2]);
                            return;
                        }
                        return;
                    case 8:
                        if (obj != null) {
                            f(z16, (Object[]) obj);
                            return;
                        }
                        return;
                    case 9:
                        if (obj != null) {
                            i(z16, (Object[]) obj);
                            break;
                        }
                        break;
                    case 10:
                        break;
                    case 11:
                        if (obj != null) {
                            g(z16, (Object[]) obj);
                            return;
                        }
                        return;
                    default:
                        return;
                }
                if (obj != null) {
                    b(z16, (Object[]) obj);
                    return;
                }
                return;
            }
            if (obj != null) {
                Object[] objArr4 = (Object[]) obj;
                if (objArr4.length == 2) {
                    e(z16, ((Integer) objArr4[0]).intValue(), ((Integer) objArr4[1]).intValue());
                    return;
                }
                return;
            }
            return;
        }
        if (obj != null) {
            Object[] objArr5 = (Object[]) obj;
            if (objArr5.length == 2) {
                a(z16, ((Integer) objArr5[0]).intValue(), (String) objArr5[1]);
            }
        }
    }

    public void b(boolean z16, Object[] objArr) {
    }

    public void f(boolean z16, Object[] objArr) {
    }

    public void g(boolean z16, Object[] objArr) {
    }

    public void i(boolean z16, Object[] objArr) {
    }

    public void a(boolean z16, int i3, String str) {
    }

    public void d(boolean z16, String str, int i3) {
    }

    public void e(boolean z16, int i3, int i16) {
    }

    public void h(boolean z16, String str, int i3) {
    }

    public void c(boolean z16, String str, int i3, List<TimDocSSOMsg$UinRightInfo> list) {
    }
}
