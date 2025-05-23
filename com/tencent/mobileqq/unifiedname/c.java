package com.tencent.mobileqq.unifiedname;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static void a(int i3, int i16, String[] strArr, b bVar) {
        switch (i3) {
            case 2:
                f(strArr, bVar);
                return;
            case 3:
                j(i16, strArr, bVar);
                return;
            case 4:
                e(i16, strArr, bVar);
                return;
            case 5:
                c(i16, strArr, bVar);
                return;
            case 6:
                d(i16, strArr, bVar);
                return;
            case 7:
                h(i16, strArr, bVar);
                return;
            case 8:
                i(i16, strArr, bVar);
                return;
            case 9:
            case 11:
                g(i16, strArr, bVar);
                return;
            case 10:
                b(i16, strArr, bVar);
                return;
            default:
                a aVar = bVar.f305805a;
                aVar.f305803a = 0;
                aVar.f305804b = strArr[0];
                bVar.f305806b.clear();
                return;
        }
    }

    public static void b(int i3, String[] strArr, b bVar) {
        if (i3 == 2) {
            f(strArr, bVar);
        } else if (i3 == 1) {
            a aVar = bVar.f305805a;
            aVar.f305803a = 0;
            aVar.f305804b = strArr[0];
            bVar.f305806b.clear();
        }
    }

    public static void c(int i3, String[] strArr, b bVar) {
        bVar.f305806b.clear();
        if (i3 == 2) {
            if (!TextUtils.isEmpty(strArr[4])) {
                a aVar = bVar.f305805a;
                aVar.f305803a = 4;
                aVar.f305804b = strArr[4];
                return;
            }
            a aVar2 = bVar.f305805a;
            aVar2.f305803a = 0;
            aVar2.f305804b = strArr[0];
            if (!TextUtils.isEmpty(strArr[2])) {
                a aVar3 = new a();
                aVar3.f305803a = 2;
                aVar3.f305804b = strArr[2];
                bVar.f305806b.add(aVar3);
                return;
            }
            return;
        }
        if (i3 == 1) {
            if (!TextUtils.isEmpty(strArr[2])) {
                a aVar4 = bVar.f305805a;
                aVar4.f305803a = 2;
                aVar4.f305804b = strArr[2];
            } else {
                a aVar5 = bVar.f305805a;
                aVar5.f305803a = 0;
                aVar5.f305804b = strArr[0];
            }
        }
    }

    public static void d(int i3, String[] strArr, b bVar) {
        bVar.f305806b.clear();
        if (i3 == 2) {
            if (!TextUtils.isEmpty(strArr[4])) {
                a aVar = bVar.f305805a;
                aVar.f305803a = 4;
                aVar.f305804b = strArr[4];
                if (!TextUtils.isEmpty(strArr[3])) {
                    a aVar2 = new a();
                    aVar2.f305803a = 3;
                    aVar2.f305804b = strArr[3];
                    bVar.f305806b.add(aVar2);
                    return;
                }
                return;
            }
            a aVar3 = bVar.f305805a;
            aVar3.f305803a = 0;
            aVar3.f305804b = strArr[0];
            if (!TextUtils.isEmpty(strArr[3])) {
                a aVar4 = new a();
                aVar4.f305803a = 3;
                aVar4.f305804b = strArr[3];
                bVar.f305806b.add(aVar4);
                return;
            }
            return;
        }
        if (i3 == 1) {
            a aVar5 = new a();
            aVar5.f305803a = 0;
            aVar5.f305804b = strArr[0];
            bVar.f305806b.add(aVar5);
            if (!TextUtils.isEmpty(strArr[3])) {
                a aVar6 = bVar.f305805a;
                aVar6.f305803a = 3;
                aVar6.f305804b = strArr[3];
                return;
            } else {
                a aVar7 = bVar.f305805a;
                aVar7.f305803a = 0;
                aVar7.f305804b = strArr[0];
                return;
            }
        }
        if (i3 == 3) {
            a aVar8 = new a();
            aVar8.f305803a = 7;
            aVar8.f305804b = strArr[0];
            bVar.f305806b.add(aVar8);
            if (!TextUtils.isEmpty(strArr[3])) {
                a aVar9 = bVar.f305805a;
                aVar9.f305803a = 3;
                aVar9.f305804b = strArr[3];
            } else {
                a aVar10 = bVar.f305805a;
                aVar10.f305803a = 0;
                aVar10.f305804b = strArr[0];
            }
        }
    }

    public static void e(int i3, String[] strArr, b bVar) {
        if (i3 == 2) {
            f(strArr, bVar);
            return;
        }
        if (i3 == 1) {
            bVar.f305806b.clear();
            if (!TextUtils.isEmpty(strArr[6])) {
                a aVar = bVar.f305805a;
                aVar.f305803a = 6;
                aVar.f305804b = strArr[6];
            } else {
                a aVar2 = bVar.f305805a;
                aVar2.f305803a = 0;
                aVar2.f305804b = strArr[0];
            }
        }
    }

    public static void f(String[] strArr, b bVar) {
        bVar.f305806b.clear();
        if (!TextUtils.isEmpty(strArr[4])) {
            a aVar = bVar.f305805a;
            aVar.f305803a = 4;
            aVar.f305804b = strArr[4];
            if (!TextUtils.isEmpty(strArr[3])) {
                a aVar2 = new a();
                aVar2.f305803a = 3;
                aVar2.f305804b = strArr[3];
                bVar.f305806b.add(aVar2);
                return;
            }
            return;
        }
        a aVar3 = bVar.f305805a;
        aVar3.f305803a = 0;
        aVar3.f305804b = strArr[0];
        if (!TextUtils.isEmpty(strArr[3])) {
            a aVar4 = new a();
            aVar4.f305803a = 3;
            aVar4.f305804b = strArr[3];
            bVar.f305806b.add(aVar4);
        }
    }

    public static void g(int i3, String[] strArr, b bVar) {
        if (i3 == 2) {
            f(strArr, bVar);
            return;
        }
        if (i3 == 1) {
            bVar.f305806b.clear();
            if (!TextUtils.isEmpty(strArr[5])) {
                a aVar = bVar.f305805a;
                aVar.f305803a = 5;
                aVar.f305804b = strArr[5];
            } else {
                a aVar2 = bVar.f305805a;
                aVar2.f305803a = 0;
                aVar2.f305804b = strArr[0];
            }
        }
    }

    public static void h(int i3, String[] strArr, b bVar) {
        if (i3 == 2) {
            f(strArr, bVar);
        } else if (i3 == 1) {
            a aVar = bVar.f305805a;
            aVar.f305803a = 0;
            aVar.f305804b = strArr[0];
            bVar.f305806b.clear();
        }
    }

    public static void i(int i3, String[] strArr, b bVar) {
        if (i3 == 2) {
            f(strArr, bVar);
            return;
        }
        if (i3 == 1) {
            bVar.f305806b.clear();
            if (!TextUtils.isEmpty(strArr[3])) {
                a aVar = bVar.f305805a;
                aVar.f305803a = 3;
                aVar.f305804b = strArr[3];
            } else {
                a aVar2 = bVar.f305805a;
                aVar2.f305803a = 0;
                aVar2.f305804b = strArr[0];
            }
        }
    }

    public static void j(int i3, String[] strArr, b bVar) {
        bVar.f305806b.clear();
        if (i3 == 2) {
            if (!TextUtils.isEmpty(strArr[1])) {
                a aVar = bVar.f305805a;
                aVar.f305803a = 1;
                aVar.f305804b = strArr[1];
                if (!TextUtils.isEmpty(strArr[4])) {
                    a aVar2 = new a();
                    aVar2.f305803a = 4;
                    aVar2.f305804b = strArr[4];
                    bVar.f305806b.add(aVar2);
                }
                if (!TextUtils.isEmpty(strArr[3])) {
                    a aVar3 = new a();
                    aVar3.f305803a = 3;
                    aVar3.f305804b = strArr[3];
                    bVar.f305806b.add(aVar3);
                    return;
                }
                return;
            }
            if (!TextUtils.isEmpty(strArr[4])) {
                a aVar4 = bVar.f305805a;
                aVar4.f305803a = 4;
                aVar4.f305804b = strArr[4];
                if (!TextUtils.isEmpty(strArr[3])) {
                    a aVar5 = new a();
                    aVar5.f305803a = 3;
                    aVar5.f305804b = strArr[3];
                    bVar.f305806b.add(aVar5);
                    return;
                }
                return;
            }
            a aVar6 = bVar.f305805a;
            aVar6.f305803a = 0;
            aVar6.f305804b = strArr[0];
            if (!TextUtils.isEmpty(strArr[3])) {
                a aVar7 = new a();
                aVar7.f305803a = 3;
                aVar7.f305804b = strArr[3];
                bVar.f305806b.add(aVar7);
                return;
            }
            return;
        }
        if (i3 == 1) {
            if (!TextUtils.isEmpty(strArr[1])) {
                a aVar8 = bVar.f305805a;
                aVar8.f305803a = 1;
                aVar8.f305804b = strArr[1];
            } else if (!TextUtils.isEmpty(strArr[6])) {
                a aVar9 = bVar.f305805a;
                aVar9.f305803a = 6;
                aVar9.f305804b = strArr[6];
            } else {
                a aVar10 = bVar.f305805a;
                aVar10.f305803a = 0;
                aVar10.f305804b = strArr[0];
            }
        }
    }
}
