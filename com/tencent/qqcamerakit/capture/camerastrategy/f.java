package com.tencent.qqcamerakit.capture.camerastrategy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static double f344910a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11512);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f344910a = 0.009999999776482582d;
        }
    }

    private static com.tencent.qqcamerakit.capture.d a(List<com.tencent.qqcamerakit.capture.d> list, int i3, int i16, int i17, int i18, int i19, int i26) {
        int i27 = 2;
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.e("ResolutionStrategy", 2, "getHighVersionPreviewSize[wantedPreviewSize]: width=" + i3 + "  height=" + i16);
        }
        float f16 = i3 / i16;
        ArrayList<com.tencent.qqcamerakit.capture.d> arrayList = new ArrayList();
        ArrayList<com.tencent.qqcamerakit.capture.d> arrayList2 = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<com.tencent.qqcamerakit.capture.d> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.tencent.qqcamerakit.capture.d next = it.next();
                if (next != null) {
                    int max = Math.max(next.f344911a, next.f344912b);
                    int min = Math.min(next.f344911a, next.f344912b);
                    if (next.f344912b == i16 && next.f344911a == i3) {
                        arrayList2.add(new com.tencent.qqcamerakit.capture.d(i3, i16));
                        if (com.tencent.qqcamerakit.common.e.f()) {
                            com.tencent.qqcamerakit.common.e.e("ResolutionStrategy", i27, "getHighVersionPreviewSize first: width = " + i3 + "  height = " + i16);
                        }
                    } else if (max > i19 && max < i17) {
                        if (min > i26 && min < i18) {
                            arrayList.add(new com.tencent.qqcamerakit.capture.d(max, min));
                        }
                        i27 = 2;
                    }
                }
                i27 = 2;
            }
        }
        float f17 = 10000.0f;
        if (arrayList2.size() == 0) {
            for (com.tencent.qqcamerakit.capture.d dVar : arrayList) {
                if (dVar != null) {
                    float max2 = f16 - (Math.max(dVar.f344911a, dVar.f344912b) / Math.min(dVar.f344911a, dVar.f344912b));
                    if (Math.abs(max2) < f344910a) {
                        arrayList2.add(dVar);
                    }
                    if (Math.abs(max2) < f17) {
                        f17 = Math.abs(max2);
                    }
                }
            }
            if (com.tencent.qqcamerakit.common.e.f()) {
                for (int i28 = 0; i28 < arrayList2.size(); i28++) {
                    com.tencent.qqcamerakit.common.e.e("ResolutionStrategy", 2, "getHighVersionPreviewSize secend: width = " + ((com.tencent.qqcamerakit.capture.d) arrayList2.get(i28)).f344911a + " height = " + ((com.tencent.qqcamerakit.capture.d) arrayList2.get(i28)).f344912b + " w/h = " + (((com.tencent.qqcamerakit.capture.d) arrayList2.get(i28)).f344911a / ((com.tencent.qqcamerakit.capture.d) arrayList2.get(i28)).f344912b));
                }
            }
        }
        if (arrayList2.size() == 0) {
            for (com.tencent.qqcamerakit.capture.d dVar2 : arrayList) {
                if (dVar2 != null && Math.abs(Math.abs(f16 - (Math.max(dVar2.f344911a, dVar2.f344912b) / Math.min(dVar2.f344911a, dVar2.f344912b))) - f17) < f344910a) {
                    arrayList2.add(dVar2);
                }
            }
            if (com.tencent.qqcamerakit.common.e.f()) {
                for (int i29 = 0; i29 < arrayList2.size(); i29++) {
                    com.tencent.qqcamerakit.common.e.e("ResolutionStrategy", 2, "getHighVersionPreviewSize third: width = " + ((com.tencent.qqcamerakit.capture.d) arrayList2.get(i29)).f344911a + " height = " + ((com.tencent.qqcamerakit.capture.d) arrayList2.get(i29)).f344912b + " w/h = " + (((com.tencent.qqcamerakit.capture.d) arrayList2.get(i29)).f344911a / ((com.tencent.qqcamerakit.capture.d) arrayList2.get(i29)).f344912b));
                }
            }
        }
        if (arrayList2.size() > 0) {
            com.tencent.qqcamerakit.capture.d dVar3 = (com.tencent.qqcamerakit.capture.d) arrayList2.get(0);
            for (com.tencent.qqcamerakit.capture.d dVar4 : arrayList2) {
                if (dVar4 != null && dVar4.f344911a * dVar4.f344912b > dVar3.f344911a * dVar3.f344912b) {
                    dVar3 = dVar4;
                }
            }
            return dVar3;
        }
        return null;
    }

    public static com.tencent.qqcamerakit.capture.d[] b(com.tencent.qqcamerakit.capture.d dVar, com.tencent.qqcamerakit.capture.d dVar2, com.tencent.qqcamerakit.capture.d dVar3) {
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.e("ResolutionStrategy", 2, "getPreviewAndPictureSize, viewSize:" + dVar + " wantedPreviewSize: " + dVar2 + " wantedPictureSize: " + dVar3);
        }
        com.tencent.qqcamerakit.capture.d[] dVarArr = new com.tencent.qqcamerakit.capture.d[2];
        com.tencent.qqcamerakit.capture.d d16 = d(c(), dVar2.f344911a, dVar2.f344912b, dVar.f344911a, dVar.f344912b);
        if (d16 != null) {
            dVarArr[0] = d16;
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.e("ResolutionStrategy", 2, "getPreviewSize preview = ", d16, " customPreviewSizeStrategy:", false);
            }
            int i3 = dVar3.f344911a;
            int i16 = dVar3.f344912b;
            if (dVar3.equals(dVar2)) {
                i3 = d16.f344911a;
                i16 = d16.f344912b;
            }
            com.tencent.qqcamerakit.capture.d b16 = e.b(i3, i16, dVar.f344911a, dVar.f344912b, 1);
            if (b16 != null) {
                dVarArr[1] = b16;
                if (com.tencent.qqcamerakit.common.e.f()) {
                    com.tencent.qqcamerakit.common.e.e("ResolutionStrategy", 2, "getPictureSize picture = ", b16);
                }
            } else {
                com.tencent.qqcamerakit.common.e.e("ResolutionStrategy", 1, "getPictureSize previewSize null");
            }
            return dVarArr;
        }
        com.tencent.qqcamerakit.common.e.d("ResolutionStrategy", 1, "getPreviewSize previewSize null");
        return dVarArr;
    }

    public static List<com.tencent.qqcamerakit.capture.d> c() {
        if (a.f344888b) {
            return com.tencent.qqcamerakit.capture.camera2.b.Q().U(false);
        }
        return com.tencent.qqcamerakit.capture.camera.a.d().f(false);
    }

    public static com.tencent.qqcamerakit.capture.d d(List<com.tencent.qqcamerakit.capture.d> list, int i3, int i16, int i17, int i18) {
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.e("ResolutionStrategy", 2, "getPreviewSizeV2: dstwidth = " + i3 + "  dstheight = " + i16);
        }
        com.tencent.qqcamerakit.capture.d a16 = a(list, i3, i16, 2600, 1500, FSUploadConst.ERR_FILE_NOT_EXIST, 1000);
        if (a16 != null) {
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.e("ResolutionStrategy", 2, "getPreviewSizeGuaranteeOK: DEFAULT resolution is OK.");
            }
            return a16;
        }
        com.tencent.qqcamerakit.capture.d a17 = a(list, i3, i16, 2600, 1500, 1000, 700);
        if (a17 != null) {
            if (com.tencent.qqcamerakit.common.e.f()) {
                com.tencent.qqcamerakit.common.e.e("ResolutionStrategy", 2, "getPreviewSizeGuaranteeOK: 720P resolution is OK.");
            }
            return a17;
        }
        return e(list, i3, i16, i17, i18);
    }

    private static com.tencent.qqcamerakit.capture.d e(List<com.tencent.qqcamerakit.capture.d> list, int i3, int i16, int i17, int i18) {
        String str;
        String str2;
        Iterator<com.tencent.qqcamerakit.capture.d> it;
        int i19;
        double d16 = i18 / i17;
        String str3 = "ResolutionStrategy";
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.e("ResolutionStrategy", 2, "getPreviewSize[self-adaption] physicRatio = " + d16);
        }
        com.tencent.qqcamerakit.capture.d dVar = new com.tencent.qqcamerakit.capture.d();
        if (list != null && !list.isEmpty()) {
            Iterator<com.tencent.qqcamerakit.capture.d> it5 = list.iterator();
            long j3 = Long.MAX_VALUE;
            while (it5.hasNext()) {
                com.tencent.qqcamerakit.capture.d next = it5.next();
                if (next != null && (i19 = next.f344911a) >= i3) {
                    int i26 = next.f344912b;
                    str2 = str3;
                    if (i26 >= i16) {
                        it = it5;
                        if (i19 / i26 >= d16) {
                            long j16 = i19 * i26;
                            if (j16 < j3) {
                                dVar.f344911a = i19;
                                dVar.f344912b = i26;
                                j3 = j16;
                            } else if (j16 == j3 && i19 < dVar.f344911a) {
                                dVar.f344911a = i19;
                                dVar.f344912b = i26;
                            }
                        }
                        str3 = str2;
                        it5 = it;
                    }
                    it = it5;
                    str3 = str2;
                    it5 = it;
                }
                str2 = str3;
                it = it5;
                str3 = str2;
                it5 = it;
            }
        }
        String str4 = str3;
        if (com.tencent.qqcamerakit.common.e.f()) {
            str = str4;
            com.tencent.qqcamerakit.common.e.e(str, 2, "getPreviewSize[self-adaption] have no resolution >= (w*h)");
        } else {
            str = str4;
        }
        if ((dVar.f344911a <= 0 || dVar.f344912b <= 0) && list != null && !list.isEmpty()) {
            long j17 = 0;
            for (com.tencent.qqcamerakit.capture.d dVar2 : list) {
                if (dVar2 != null) {
                    int i27 = dVar2.f344911a;
                    int i28 = dVar2.f344912b;
                    if (i27 / i28 >= d16) {
                        long j18 = i27 * i28;
                        if (j18 > j17) {
                            dVar.f344911a = i27;
                            dVar.f344912b = i28;
                            j17 = j18;
                        } else if (j18 == j17 && i27 < dVar.f344911a) {
                            dVar.f344911a = i27;
                            dVar.f344912b = i28;
                        }
                    }
                }
            }
        }
        if (com.tencent.qqcamerakit.common.e.f()) {
            com.tencent.qqcamerakit.common.e.e(str, 2, "getPreviewSize[self-adaption] cSize.width=" + dVar.f344911a + "  cSize.height=" + dVar.f344912b);
        }
        if (dVar.f344911a > 0 && dVar.f344912b > 0) {
            return dVar;
        }
        if (list != null && !list.isEmpty() && list.get(0) != null) {
            dVar.f344911a = list.get(0).f344911a;
            dVar.f344912b = list.get(0).f344912b;
            return dVar;
        }
        return null;
    }
}
