package com.tencent.ttpic.facedetect;

import android.graphics.Matrix;
import java.util.List;

/* compiled from: P */
/* loaded from: classes27.dex */
public class FaceStatusUtil {
    public static List<FaceStatus> rotateFaceStatusFor3D(List<FaceStatus> list, int i3, int i16, int i17) {
        if (list != null) {
            for (int i18 = 0; i18 < list.size(); i18++) {
                FaceStatus faceStatus = list.get(i18);
                i17 = (i17 + 360) % 360;
                if (i17 == 90) {
                    float f16 = faceStatus.pitch;
                    faceStatus.pitch = -faceStatus.yaw;
                    faceStatus.yaw = f16;
                    faceStatus.roll += i17;
                } else if (i17 == 180) {
                    faceStatus.pitch = -faceStatus.pitch;
                    faceStatus.yaw = -faceStatus.yaw;
                    faceStatus.roll += i17;
                } else if (i17 == 270) {
                    float f17 = faceStatus.pitch;
                    faceStatus.pitch = faceStatus.yaw;
                    faceStatus.yaw = -f17;
                    faceStatus.roll += i17;
                }
                Matrix matrix = new Matrix();
                matrix.reset();
                matrix.postTranslate((-i3) / 2.0f, (-i16) / 2.0f);
                matrix.postRotate(i17, 0.0f, 0.0f);
                if (i17 != 90 && i17 != 270) {
                    matrix.postTranslate(i3 / 2.0f, i16 / 2.0f);
                } else {
                    matrix.postTranslate(i16 / 2.0f, i3 / 2.0f);
                }
                float[] fArr = new float[2];
                matrix.mapPoints(fArr, new float[]{faceStatus.f381696tx, faceStatus.f381697ty});
                faceStatus.f381696tx = fArr[0];
                faceStatus.f381697ty = fArr[1];
            }
        }
        return list;
    }
}
