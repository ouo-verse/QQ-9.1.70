package com.tencent.qqcamerakit.capture.camerastrategy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqcamerakit.capture.camerastrategy.c;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f344908a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11486);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f344908a = false;
        }
    }

    public static int[] a(int i3) {
        int[] h16 = h(d(), i3);
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.e("CameraFpsStrategy", 2, "getFpsRange, selectFps:", Integer.valueOf(h16[0]), " ", Integer.valueOf(h16[1]), " customFpsStrategy:", false);
        }
        return h16;
    }

    private static int[] b(List<int[]> list, int i3) {
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.e("CameraFpsStrategy", 2, "getMaxRangeFps");
        }
        ArrayList arrayList = new ArrayList();
        for (int[] iArr : list) {
            if (iArr[1] == i3) {
                arrayList.add(iArr);
            }
        }
        int[] c16 = c(arrayList);
        if (c16 != null) {
            return c16;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int[] iArr2 : list) {
            if (iArr2[1] >= i3) {
                arrayList2.add(iArr2);
            }
        }
        int[] c17 = c(arrayList2);
        if (c17 != null) {
            return c17;
        }
        return e(list);
    }

    private static int[] c(List<int[]> list) {
        int[] iArr = null;
        int i3 = 0;
        for (int[] iArr2 : list) {
            int i16 = iArr2[1] - iArr2[0];
            if (i16 > i3) {
                iArr = iArr2;
                i3 = i16;
            }
        }
        return iArr;
    }

    private static List<int[]> d() {
        List<int[]> e16;
        if (a.f344888b) {
            e16 = com.tencent.qqcamerakit.capture.camera2.b.Q().S();
        } else {
            e16 = com.tencent.qqcamerakit.capture.camera.a.d().e();
        }
        g(e16);
        return e16;
    }

    private static int[] e(List<int[]> list) {
        int i3;
        int i16;
        if (a.f344888b) {
            i3 = 15;
        } else {
            i3 = 15000;
        }
        int[] iArr = null;
        for (int[] iArr2 : list) {
            if (iArr == null || ((i16 = iArr2[0]) <= i3 && iArr2[1] - i16 > iArr[1] - iArr[0])) {
                iArr = iArr2;
            }
        }
        return iArr;
    }

    private static int[] f(List<int[]> list, int i3) {
        int i16;
        int i17;
        int i18;
        int i19;
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.e("CameraFpsStrategy", 2, "getZoneFps");
        }
        int[] iArr = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        for (int[] iArr2 : list) {
            if (iArr2 != null && iArr2.length >= 2) {
                int i26 = iArr2[0];
                if (i26 >= i3 && (i19 = iArr2[1]) < iArr[1]) {
                    iArr[0] = i26;
                    iArr[1] = i19;
                } else if (i26 >= i3 && (i18 = iArr2[1]) == iArr[1] && i26 < iArr[0]) {
                    iArr[0] = i26;
                    iArr[1] = i18;
                }
            }
        }
        if (iArr[0] == Integer.MAX_VALUE || iArr[1] == Integer.MAX_VALUE) {
            iArr[1] = 0;
            iArr[0] = 0;
            for (int[] iArr3 : list) {
                if (iArr3 != null && iArr3.length >= 2) {
                    int i27 = iArr3[0];
                    if (i27 <= i3 && (i17 = iArr3[1]) > iArr[1]) {
                        iArr[0] = i27;
                        iArr[1] = i17;
                    } else if (i27 <= i3 && (i16 = iArr3[1]) == iArr[1] && i27 > iArr[0]) {
                        iArr[0] = i27;
                        iArr[1] = i16;
                    }
                }
            }
        }
        if (iArr[0] != Integer.MAX_VALUE && iArr[1] != Integer.MAX_VALUE) {
            return iArr;
        }
        return null;
    }

    private static void g(List<int[]> list) {
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 < list.size(); i3++) {
                int[] iArr = list.get(i3);
                if (iArr != null && iArr.length >= 2) {
                    if (com.tencent.qqcamerakit.common.e.f()) {
                        com.tencent.qqcamerakit.common.e.e("CameraFpsStrategy", 2, "printFpsRange[i=" + i3 + " fps[low]=" + iArr[0] + " fps[high]=" + iArr[1] + "]");
                    }
                } else if (com.tencent.qqcamerakit.common.e.f()) {
                    com.tencent.qqcamerakit.common.e.e("CameraFpsStrategy", 2, "printFpsRange[i=" + i3 + " ele=null]");
                }
            }
            return;
        }
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.e("CameraFpsStrategy", 2, "printFpsRange[listFpsRange=null]");
        }
    }

    public static int[] h(List<int[]> list, int i3) {
        int[] b16;
        int i16;
        int[] iArr = {Integer.MAX_VALUE, Integer.MAX_VALUE};
        if (!a.f344888b) {
            i3 *= 1000;
        }
        if (list == null) {
            iArr[0] = i3;
            iArr[1] = i3;
            return iArr;
        }
        boolean c16 = f344908a ? !b.c(c.a.f344898g) : b.c(c.a.f344899h);
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.e("CameraFpsStrategy", 2, "selectFpsRange, fixFpsMode:", Boolean.valueOf(f344908a), " fixedFps:", Boolean.valueOf(c16));
        }
        if (c16) {
            b16 = f(list, i3);
            if (b16 == null) {
                b16 = b(list, i3);
            }
        } else {
            b16 = b(list, i3);
            if (b16 == null) {
                b16 = f(list, i3);
            }
        }
        if (b16 == null) {
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.e("CameraFpsStrategy", 2, "selectFpsRange, fpsRange null, goto backup strategy");
            }
            for (int[] iArr2 : list) {
                if (iArr2 != null && iArr2.length >= 2 && i3 >= iArr2[0] && i3 <= (i16 = iArr2[1])) {
                    iArr[0] = i3;
                    iArr[1] = i16;
                    return iArr;
                }
            }
        }
        return b16;
    }
}
