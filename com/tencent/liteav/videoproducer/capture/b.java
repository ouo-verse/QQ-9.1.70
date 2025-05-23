package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.k;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class b {
    public static Size a(List<Size> list, k kVar, int i3, int i16) {
        double d16;
        Size size = new Size(i3, i16);
        LiteavLog.i("CameraSupervisor", "preview wanted: " + size + " cameraRotation:" + kVar);
        if (list == null) {
            LiteavLog.e("CameraSupervisor", "findBestMatchedPreviewSize getPreviewSizes null");
            return size;
        }
        if (kVar == k.ROTATION_90 || kVar == k.ROTATION_270) {
            size.swap();
        }
        double aspectRatio = size.aspectRatio();
        Size size2 = new Size(640, 640);
        int i17 = size.width;
        int i18 = size2.width;
        if (i17 <= i18 && size.height <= size2.height) {
            size2.set(size);
        } else {
            int i19 = size.height;
            if (i17 > i19) {
                size2.height = (i18 * i19) / i17;
            } else {
                size2.width = (size2.height * i17) / i19;
            }
        }
        ArrayList<Size> arrayList = new ArrayList();
        StringBuilder sb5 = new StringBuilder();
        long j3 = Long.MAX_VALUE;
        for (Size size3 : list) {
            sb5.append(size3);
            sb5.append(", ");
            long round = (size3.width < size2.width || size3.height < size2.height) ? Long.MAX_VALUE : Math.round(Math.abs(size3.aspectRatio() - aspectRatio) * 10.0d);
            if (round < j3) {
                arrayList.clear();
                arrayList.add(size3);
                j3 = round;
            } else if (round == j3) {
                arrayList.add(size3);
            }
        }
        LiteavLog.i("CameraSupervisor", "support preview size list: ".concat(String.valueOf(sb5)));
        Collections.sort(arrayList, c.a());
        Size size4 = (Size) arrayList.get(0);
        int area = size.getArea() * 1000;
        double d17 = Double.MAX_VALUE;
        for (Size size5 : arrayList) {
            LiteavLog.i("CameraSupervisor", "size in same buck ".concat(String.valueOf(size5)));
            if (aspectRatio > size5.aspectRatio()) {
                int i26 = size5.width;
                d16 = ((i26 * i26) * 1000) / aspectRatio;
            } else {
                int i27 = size5.height;
                d16 = i27 * i27 * aspectRatio * 1000.0d;
            }
            double d18 = area;
            if (d16 / d18 >= 0.9d) {
                double d19 = d16 - d18;
                if (Math.abs(d19) < d17) {
                    d17 = Math.abs(d19);
                    size4 = size5;
                }
            }
        }
        LiteavLog.i("CameraSupervisor", "best match preview size ".concat(String.valueOf(size4)));
        return new Size(size4.width, size4.height);
    }

    public static com.tencent.liteav.videoproducer.a.a a(com.tencent.liteav.videoproducer.a.a[] aVarArr, int i3, boolean z16) {
        if (aVarArr != null && aVarArr.length != 0) {
            int i16 = 0;
            for (com.tencent.liteav.videoproducer.a.a aVar : aVarArr) {
                LiteavLog.i("CameraSupervisor", "supported fps range: ".concat(String.valueOf(aVar)));
            }
            if (z16) {
                Arrays.sort(aVarArr, d.a());
                int length = aVarArr.length;
                while (i16 < length) {
                    com.tencent.liteav.videoproducer.a.a aVar2 = aVarArr[i16];
                    if (aVar2.f119572a >= i3) {
                        return aVar2;
                    }
                    i16++;
                }
            } else {
                Arrays.sort(aVarArr, e.a());
                int length2 = aVarArr.length;
                while (i16 < length2) {
                    com.tencent.liteav.videoproducer.a.a aVar3 = aVarArr[i16];
                    if (aVar3.f119572a <= i3 && i3 <= aVar3.f119573b) {
                        return aVar3;
                    }
                    i16++;
                }
            }
        }
        return null;
    }
}
