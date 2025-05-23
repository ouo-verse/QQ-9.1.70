package com.tencent.aelight.camera.aebase;

import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.q;

/* compiled from: P */
/* loaded from: classes32.dex */
public class g {
    public static q a(int i3, or.e eVar, or.d dVar) {
        if (i3 == -1000) {
            return new AEPituCameraUnit();
        }
        if (i3 != 10007) {
            if (i3 != 10017 && i3 != 10000) {
                if (i3 == 10001) {
                    return new AEPituQzoneCameraUnit(eVar, dVar);
                }
                if (i3 == 10012) {
                    return new h(eVar, dVar);
                }
                if (i3 != 10013) {
                    switch (i3) {
                        case 10023:
                        case 10024:
                            break;
                        case 10025:
                            return new QFaceUnlockCameraCaptureUnit(eVar, dVar);
                        default:
                            return new AEPituCameraUnit(eVar, dVar);
                    }
                }
            }
            return new AEPituCameraUnit(eVar, dVar);
        }
        return new i(eVar, dVar);
    }
}
