package com.tencent.mobileqq.gamecenter.utils;

import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes12.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f213444a = new a();

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements DownloadParams.DecodeHandler {
        a() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (QLog.isDevelopLevel()) {
                QLog.d("URLDrawableDecodeHandler", 4, "ROUND_FACE_DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 2) {
                    float q16 = ah.q();
                    if (q16 < 0.01f) {
                        q16 = 1.0f;
                    }
                    int i3 = (int) (iArr[0] / q16);
                    iArr[0] = i3;
                    int i16 = (int) (iArr[1] / q16);
                    iArr[1] = i16;
                    return k.a(bitmap, i3, i16);
                }
            }
            return k.a(bitmap, 50, 50);
        }
    }

    public static final int[] a(int i3, int i16, int i17) {
        return new int[]{i3, i16, i17};
    }
}
