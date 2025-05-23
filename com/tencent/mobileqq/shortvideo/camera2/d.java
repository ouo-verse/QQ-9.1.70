package com.tencent.mobileqq.shortvideo.camera2;

import android.annotation.TargetApi;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.tencent.mobileqq.shortvideo.camera2.Camera2Control;
import com.tencent.mobileqq.shortvideo.mediadevice.CameraControl;
import com.tencent.mobileqq.winkpublish.publishconst.FSUploadConst;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
@TargetApi(21)
/* loaded from: classes18.dex */
public class d {
    public static void a(int i3, String str) {
        if (i3 == 1) {
            QLog.w("Camera2Control", 1, str);
        } else if (i3 == 2) {
            QLog.e("Camera2Control", 1, str);
        }
    }

    public static int b(CameraCharacteristics cameraCharacteristics, int i3) {
        if (i3 == -1) {
            i3 = 0;
        }
        int i16 = ((i3 + 45) / 90) * 90;
        int intValue = ((Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
        if (num != null && num.intValue() == 0) {
            return ((intValue - i16) + 360) % 360;
        }
        return (intValue + i16) % 360;
    }

    private static CameraControl.b c(List<CameraControl.b> list, int i3, int i16) {
        int i17;
        if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[wantedPreviewSize]: width=" + i3 + "  height=" + i16);
        }
        CameraControl.b bVar = new CameraControl.b();
        int i18 = -1;
        if (list != null && !list.isEmpty()) {
            for (CameraControl.b bVar2 : list) {
                if (bVar2 != null && bVar2.f288112b == i16 && (i17 = bVar2.f288111a) >= i3 && (i18 < 0 || i17 <= i18)) {
                    i18 = i17;
                }
            }
        }
        if (i18 > 0) {
            bVar.f288112b = i16;
            bVar.f288111a = i18;
            if (i18 / 4 == i16 / 3) {
                if (QLog.isColorLevel()) {
                    QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize[4:3]...");
                }
                return bVar;
            }
            if (QLog.isColorLevel()) {
                QLog.i("Camera2Control", 2, "[Camera2] getHighVersionPreviewSize: RATIO_MUST_EQUAL cSize:" + bVar.toString());
            }
            return bVar;
        }
        return null;
    }

    private static CameraControl.b d(List<CameraControl.b> list, int i3, int i16, int i17, int i18, int i19, int i26) {
        if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3[wantedPreviewSize]: width=" + i3 + "  height=" + i16);
        }
        float f16 = i3 / i16;
        ArrayList<CameraControl.b> arrayList = new ArrayList();
        ArrayList<CameraControl.b> arrayList2 = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<CameraControl.b> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CameraControl.b next = it.next();
                if (next != null) {
                    int max = Math.max(next.f288111a, next.f288112b);
                    int min = Math.min(next.f288111a, next.f288112b);
                    if (next.f288112b == i16 && max == i3) {
                        arrayList2.add(new CameraControl.b(i3, i16));
                        if (QLog.isColorLevel()) {
                            QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 first: width=" + i3 + "  height=" + i16);
                        }
                    } else if (max > i19 && max < i17) {
                        if (min > i26 && min < i18) {
                            arrayList.add(new CameraControl.b(max, min));
                        }
                    }
                }
            }
        }
        float f17 = 10000.0f;
        if (arrayList2.size() == 0) {
            for (CameraControl.b bVar : arrayList) {
                if (bVar != null) {
                    float max2 = f16 - (Math.max(bVar.f288111a, bVar.f288112b) / Math.min(bVar.f288111a, bVar.f288112b));
                    if (Math.abs(max2) < CameraControl.f288076q) {
                        arrayList2.add(bVar);
                    }
                    if (Math.abs(max2) < f17) {
                        f17 = Math.abs(max2);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                for (int i27 = 0; i27 < arrayList2.size(); i27++) {
                    QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 secend: width=" + ((CameraControl.b) arrayList2.get(i27)).f288111a + " height=" + ((CameraControl.b) arrayList2.get(i27)).f288112b + " w/h=" + (((CameraControl.b) arrayList2.get(i27)).f288111a / ((CameraControl.b) arrayList2.get(i27)).f288112b));
                }
            }
        }
        if (arrayList2.size() == 0) {
            for (CameraControl.b bVar2 : arrayList) {
                if (bVar2 != null) {
                    if (Math.abs(Math.abs(f16 - (Math.max(bVar2.f288111a, bVar2.f288112b) / Math.min(bVar2.f288111a, bVar2.f288112b))) - f17) < CameraControl.f288076q) {
                        arrayList2.add(bVar2);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                for (int i28 = 0; i28 < arrayList2.size(); i28++) {
                    QLog.i("Camera2Control", 2, "[@] getHighVersionPreviewSizeV3 third: width=" + ((CameraControl.b) arrayList2.get(i28)).f288111a + " height=" + ((CameraControl.b) arrayList2.get(i28)).f288112b + " w/h=" + (((CameraControl.b) arrayList2.get(i28)).f288111a / ((CameraControl.b) arrayList2.get(i28)).f288112b));
                }
            }
        }
        if (arrayList2.size() > 0) {
            CameraControl.b bVar3 = (CameraControl.b) arrayList2.get(0);
            for (CameraControl.b bVar4 : arrayList2) {
                if (bVar4 != null && bVar4.f288111a * bVar4.f288112b > bVar3.f288111a * bVar3.f288112b) {
                    bVar3 = bVar4;
                }
            }
            return bVar3;
        }
        return null;
    }

    private static CameraControl.b e(int i3, int i16, int i17, List<CameraControl.b> list) {
        int max = Math.max(i3 * i17, i16 * i17);
        if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "setParamsPictureSize targetWidth " + max);
        }
        CameraControl.b bVar = new CameraControl.b(0, 0);
        int i18 = Integer.MAX_VALUE;
        for (CameraControl.b bVar2 : list) {
            int abs = Math.abs(bVar2.f288111a - max);
            if (i18 > abs) {
                bVar.f288111a = bVar2.f288111a;
                bVar.f288112b = bVar2.f288112b;
                i18 = abs;
            }
        }
        return bVar;
    }

    @TargetApi(21)
    private static CameraControl.b f(int i3, int i16, int i17, int i18, int i19, Camera2Control.h hVar) {
        if (hVar != null) {
            try {
                if (hVar.a()) {
                    StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) hVar.f287828b.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                    if (streamConfigurationMap == null) {
                        a(2, "[Camera2]getPictureSize map null!");
                        return null;
                    }
                    CameraControl.b bVar = new CameraControl.b();
                    Size[] outputSizes = streamConfigurationMap.getOutputSizes(256);
                    if (outputSizes != null && outputSizes.length > 0) {
                        ArrayList<CameraControl.b> arrayList = new ArrayList();
                        for (Size size : outputSizes) {
                            arrayList.add(new CameraControl.b(size.getWidth(), size.getHeight()));
                        }
                        CameraControl.b bVar2 = new CameraControl.b();
                        int min = Math.min(i3, i16);
                        int max = Math.max(i3, i16);
                        float f16 = max / min;
                        ArrayList<CameraControl.b> arrayList2 = new ArrayList();
                        float f17 = 10000.0f;
                        for (CameraControl.b bVar3 : arrayList) {
                            a(1, "[Camera2] setPictureSize[list]: width=" + bVar3.f288111a + " height=" + bVar3.f288112b + " w/h=" + (bVar3.f288111a / bVar3.f288112b));
                            float f18 = (((float) bVar3.f288111a) / ((float) bVar3.f288112b)) - f16;
                            if (Math.abs(f18) <= CameraControl.f288076q) {
                                arrayList2.add(bVar3);
                            }
                            if (bVar3.f288111a >= max && f17 > Math.abs(f18)) {
                                float abs = Math.abs(f18);
                                bVar2.f288111a = bVar3.f288111a;
                                bVar2.f288112b = bVar3.f288112b;
                                f17 = abs;
                            }
                        }
                        if (arrayList2.isEmpty() && bVar2.f288111a >= max) {
                            if (QLog.isColorLevel()) {
                                QLog.i("Camera2Control", 2, "[Camera2]getPictureSize: width=" + bVar2.f288111a + " height=" + bVar2.f288112b + " w/h=" + (bVar2.f288111a / bVar2.f288112b));
                            }
                            return bVar2;
                        }
                        if (arrayList2.isEmpty() && arrayList.size() > 0) {
                            bVar.f288111a = ((CameraControl.b) arrayList.get(0)).f288111a;
                            bVar.f288112b = ((CameraControl.b) arrayList.get(0)).f288112b;
                            return bVar;
                        }
                        if (arrayList2.isEmpty()) {
                            return null;
                        }
                        if (i19 == -1) {
                            for (CameraControl.b bVar4 : arrayList2) {
                                int i26 = bVar.f288111a;
                                int i27 = bVar4.f288111a;
                                if (i26 < i27) {
                                    bVar.f288111a = i27;
                                    bVar.f288112b = bVar4.f288112b;
                                }
                            }
                        } else {
                            bVar = e(i17, i18, i19, arrayList2);
                        }
                        if (bVar.f288111a == 0) {
                            return null;
                        }
                        return bVar;
                    }
                    a(2, "[Camera2]getPictureSize outPutSizes null!");
                    return null;
                }
            } catch (Exception e16) {
                a(2, "[Camera2]getPictureSize" + e16);
                return null;
            }
        }
        a(2, "[Camera2]getPictureSize camera2Info null!");
        return null;
    }

    public static CameraControl.b[] g(int i3, int i16, int i17, int i18, Camera2Control.h hVar) {
        a(1, "[Camera2] getPreviewAndPictureSizeV2 wanted size=" + i3 + " " + i16 + " cliped=" + i17 + " " + i18);
        CameraControl.b[] bVarArr = new CameraControl.b[2];
        CameraControl.b j3 = j(i3, i16, i17, i18, true, hVar);
        if (j3 != null) {
            bVarArr[0] = j3;
            a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 preview=" + j3.f288111a + " " + j3.f288112b);
            CameraControl.b f16 = f(j3.f288111a, j3.f288112b, i17, i18, 1, hVar);
            bVarArr[1] = f16;
            if (f16 != null) {
                a(1, "[Camera2] getPreviewAndPictureSizeV2 sizeGuarantee way2 picture=" + f16.f288111a + " " + f16.f288112b);
            }
        }
        return bVarArr;
    }

    public static CameraControl.b[] h(int i3, int i16, int i17, int i18, Camera2Control.h hVar) {
        a(1, "[Camera2] getPreviewAndPictureSizeV3 wanted size=" + i3 + " " + i16 + " cliped=" + i17 + " " + i18);
        if (hVar == null) {
            a(2, "[Camera2] getPreviewAndPictureSizeV3 camera2Info:" + hVar);
            return null;
        }
        CameraControl.b[] bVarArr = new CameraControl.b[2];
        CameraControl.b k3 = k(i3, i16, i17, i18, true, hVar);
        if (k3 != null) {
            bVarArr[0] = k3;
            a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 preview=" + k3.f288111a + " " + k3.f288112b);
            CameraControl.b f16 = f(k3.f288111a, k3.f288112b, i17, i18, 1, hVar);
            bVarArr[1] = f16;
            if (f16 != null) {
                a(1, "[@] getPreviewAndPictureSizeV3 sizeGuarantee way2 picture=" + f16.f288111a + " " + f16.f288112b);
            }
        }
        return bVarArr;
    }

    private static CameraControl.b i(List<CameraControl.b> list, int i3, int i16, int i17, int i18) {
        String str;
        String str2;
        int i19;
        double d16 = i18 / i17;
        String str3 = "Camera2Control";
        if (QLog.isColorLevel()) {
            QLog.i("Camera2Control", 2, "[Camera2] getPreviewSize[self-adaption] physicRatio=" + d16);
        }
        CameraControl.b bVar = new CameraControl.b();
        if (list != null && !list.isEmpty()) {
            long j3 = Long.MAX_VALUE;
            for (CameraControl.b bVar2 : list) {
                if (bVar2 != null && (i19 = bVar2.f288111a) >= i3) {
                    int i26 = bVar2.f288112b;
                    if (i26 >= i16) {
                        str2 = str3;
                        if (i19 / i26 >= d16) {
                            long j16 = i19 * i26;
                            if (j16 < j3) {
                                bVar.f288111a = i19;
                                bVar.f288112b = i26;
                                j3 = j16;
                            } else if (j16 == j3 && i19 < bVar.f288111a) {
                                bVar.f288111a = i19;
                                bVar.f288112b = i26;
                            }
                        }
                        str3 = str2;
                    }
                    str2 = str3;
                    str3 = str2;
                }
                str2 = str3;
                str3 = str2;
            }
        }
        String str4 = str3;
        if (QLog.isColorLevel()) {
            str = str4;
            QLog.i(str, 2, "[Camera2] getPreviewSize[self-adaption] have no resolution >= (w*h)");
        } else {
            str = str4;
        }
        if ((bVar.f288111a <= 0 || bVar.f288112b <= 0) && list != null && !list.isEmpty()) {
            long j17 = 0;
            for (CameraControl.b bVar3 : list) {
                if (bVar3 != null) {
                    int i27 = bVar3.f288111a;
                    int i28 = bVar3.f288112b;
                    if (i27 / i28 >= d16) {
                        long j18 = i27 * i28;
                        if (j18 > j17) {
                            bVar.f288111a = i27;
                            bVar.f288112b = i28;
                            j17 = j18;
                        } else if (j18 == j17 && i27 < bVar.f288111a) {
                            bVar.f288111a = i27;
                            bVar.f288112b = i28;
                        }
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(str, 2, "[Camera2] getPreviewSize[self-adaption] cSize.width=" + bVar.f288111a + "  cSize.height=" + bVar.f288112b);
        }
        if (bVar.f288111a > 0 && bVar.f288112b > 0) {
            return bVar;
        }
        if (list != null && !list.isEmpty() && list.get(0) != null) {
            bVar.f288111a = list.get(0).f288111a;
            bVar.f288112b = list.get(0).f288112b;
            return bVar;
        }
        return null;
    }

    public static CameraControl.b j(int i3, int i16, int i17, int i18, boolean z16, Camera2Control.h hVar) {
        int i19;
        if (hVar != null) {
            try {
                if (hVar.a()) {
                    StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) hVar.f287828b.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                    ArrayList arrayList = new ArrayList();
                    Size[] outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
                    int i26 = 0;
                    if (outputSizes != null) {
                        for (Size size : outputSizes) {
                            arrayList.add(new CameraControl.b(size.getWidth(), size.getHeight()));
                        }
                    }
                    if (arrayList.size() > 0) {
                        for (int i27 = 0; i27 < arrayList.size(); i27++) {
                            a(1, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK[list]: width=" + ((CameraControl.b) arrayList.get(i27)).f288111a + " height=" + ((CameraControl.b) arrayList.get(i27)).f288112b + " w/h=" + (((CameraControl.b) arrayList.get(i27)).f288111a / ((CameraControl.b) arrayList.get(i27)).f288112b));
                        }
                    }
                    CameraControl.b c16 = c(arrayList, i3, i16);
                    if (c16 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: DEFAULT resolution os OK. size:" + c16.toString());
                        }
                        return c16;
                    }
                    CameraControl.b c17 = c(arrayList, 960, 720);
                    if (c17 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV2 sizeGuaranteeOK: 640*480 resolution os OK.");
                        }
                        return c17;
                    }
                    CameraControl.b i28 = i(arrayList, i3, i16, i17, i18);
                    if (z16) {
                        if (i28 == null) {
                            i19 = 0;
                        } else {
                            i19 = i28.f288111a;
                        }
                        if (i28 != null) {
                            i26 = i28.f288112b;
                        }
                        com.tencent.mobileqq.activity.richmedia.f.j(4, i3, i16, i19, i26);
                    }
                    return i28;
                }
            } catch (Exception unused) {
                a(2, "[Camera2] getPreviewSizeV2 exception!");
                return null;
            }
        }
        a(2, "[Camera2]getPreviewSizeV2 camera2Info: " + hVar);
        return null;
    }

    @TargetApi(21)
    private static CameraControl.b k(int i3, int i16, int i17, int i18, boolean z16, Camera2Control.h hVar) {
        int i19;
        if (hVar != null) {
            try {
                if (hVar.a()) {
                    StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) hVar.f287828b.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                    ArrayList arrayList = new ArrayList();
                    Size[] outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class);
                    if (outputSizes == null) {
                        return null;
                    }
                    int i26 = 0;
                    for (Size size : outputSizes) {
                        arrayList.add(new CameraControl.b(size.getWidth(), size.getHeight()));
                    }
                    if (arrayList.size() > 0) {
                        for (int i27 = 0; i27 < arrayList.size(); i27++) {
                            a(1, "[Camera2] getPreviewSizeV3 sizeGuaranteeOK[list]: width=" + ((CameraControl.b) arrayList.get(i27)).f288111a + " height=" + ((CameraControl.b) arrayList.get(i27)).f288112b + " w/h=" + (((CameraControl.b) arrayList.get(i27)).f288111a / ((CameraControl.b) arrayList.get(i27)).f288112b));
                        }
                    }
                    CameraControl.b d16 = d(arrayList, i3, i16, 2600, 1500, FSUploadConst.ERR_FILE_NOT_EXIST, 1000);
                    if (d16 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: DEFAULT resolution os OK. size:" + d16);
                        }
                        if (z16) {
                            com.tencent.mobileqq.activity.richmedia.f.j(2, i3, i16, d16.f288111a, d16.f288112b);
                        }
                        return d16;
                    }
                    CameraControl.b d17 = d(arrayList, i3, i16, 2600, 1500, 1000, 700);
                    if (d17 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeV3 SizeGuaranteeOK: 640*480 resolution os OK. size:" + d17);
                        }
                        if (z16) {
                            com.tencent.mobileqq.activity.richmedia.f.j(3, i3, i16, d17.f288111a, d17.f288112b);
                        }
                        return d17;
                    }
                    CameraControl.b i28 = i(arrayList, i3, i16, i17, i18);
                    if (z16) {
                        if (i28 == null) {
                            i19 = 0;
                        } else {
                            i19 = i28.f288111a;
                        }
                        if (i28 != null) {
                            i26 = i28.f288112b;
                        }
                        com.tencent.mobileqq.activity.richmedia.f.j(4, i3, i16, i19, i26);
                    }
                    if (QLog.isColorLevel()) {
                        QLog.i("Camera2Control", 2, "[Camera2] getPreviewSizeGuaranteeOK: getPreviewSize. size:" + i28);
                    }
                    return i28;
                }
            } catch (Exception unused) {
            }
        }
        a(2, "[Camera2]getPreviewSizeV3 camera2Info: " + hVar);
        return null;
    }
}
