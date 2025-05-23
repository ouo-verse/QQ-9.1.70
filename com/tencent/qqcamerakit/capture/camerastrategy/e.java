package com.tencent.qqcamerakit.capture.camerastrategy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static double f344909a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11498);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f344909a = 0.009999999776482582d;
        }
    }

    private static com.tencent.qqcamerakit.capture.d a(int i3, int i16, int i17, List<com.tencent.qqcamerakit.capture.d> list) {
        int max = Math.max(i3 * i17, i16 * i17);
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.e("PictureSizeStrategy", 2, "setParamsPictureSize targetWidth " + max);
        }
        com.tencent.qqcamerakit.capture.d dVar = new com.tencent.qqcamerakit.capture.d(0, 0);
        int i18 = Integer.MAX_VALUE;
        for (com.tencent.qqcamerakit.capture.d dVar2 : list) {
            int abs = Math.abs(dVar2.f344911a - max);
            if (i18 > abs) {
                dVar.f344911a = dVar2.f344911a;
                dVar.f344912b = dVar2.f344912b;
                i18 = abs;
            }
        }
        return dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static com.tencent.qqcamerakit.capture.d b(int i3, int i16, int i17, int i18, int i19) {
        List<com.tencent.qqcamerakit.capture.d> c16 = c();
        if (c16 != null && !c16.isEmpty()) {
            int min = Math.min(i3, i16);
            int max = Math.max(i3, i16);
            float f16 = max / min;
            ArrayList<com.tencent.qqcamerakit.capture.d> arrayList = new ArrayList();
            com.tencent.qqcamerakit.capture.d dVar = new com.tencent.qqcamerakit.capture.d();
            double d16 = 10000.0d;
            for (com.tencent.qqcamerakit.capture.d dVar2 : c16) {
                if (dVar2 != null) {
                    if (com.tencent.qqcamerakit.common.e.f()) {
                        com.tencent.qqcamerakit.common.e.e("PictureSizeStrategy", 2, "getPictureSize[list]: " + dVar2);
                    }
                    double d17 = f16;
                    if (Math.abs(dVar2.a() - d17) <= f344909a) {
                        arrayList.add(dVar2);
                    }
                    if (dVar2.f344911a >= max && d16 > Math.abs(dVar2.a() - d17)) {
                        d16 = Math.abs(dVar2.a() - d17);
                        dVar.f344911a = dVar2.f344911a;
                        dVar.f344912b = dVar2.f344912b;
                    }
                }
            }
            if (arrayList.isEmpty() && dVar.f344911a >= max) {
                if (com.tencent.qqcamerakit.common.e.f()) {
                    com.tencent.qqcamerakit.common.e.e("PictureSizeStrategy", 2, "getPictureSize: " + dVar);
                }
                return dVar;
            }
            com.tencent.qqcamerakit.capture.d dVar3 = new com.tencent.qqcamerakit.capture.d();
            if (arrayList.isEmpty() && c16.size() > 0) {
                dVar3.f344911a = c16.get(0).f344911a;
                dVar3.f344912b = c16.get(0).f344912b;
                return dVar3;
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            if (i19 == -1) {
                for (com.tencent.qqcamerakit.capture.d dVar4 : arrayList) {
                    int i26 = dVar3.f344911a;
                    int i27 = dVar4.f344911a;
                    if (i26 < i27) {
                        dVar3.f344911a = i27;
                        dVar3.f344912b = dVar4.f344912b;
                    }
                }
            } else {
                dVar3 = a(i17, i18, i19, arrayList);
            }
            if (dVar3.f344911a == 0) {
                return null;
            }
            return dVar3;
        }
        return null;
    }

    public static List<com.tencent.qqcamerakit.capture.d> c() {
        if (a.f344888b) {
            return com.tencent.qqcamerakit.capture.camera2.b.Q().U(true);
        }
        return com.tencent.qqcamerakit.capture.camera.a.d().f(true);
    }
}
