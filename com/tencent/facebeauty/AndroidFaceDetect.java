package com.tencent.facebeauty;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.FaceDetector;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AndroidFaceDetect extends FaceDetect {
    static IPatchRedirector $redirector_;

    public AndroidFaceDetect() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    void caculateFaceAndEyes(PointF pointF, float f16, int i3, int i16) {
        int i17;
        FaceParam faceParam = new FaceParam();
        Rect rect = new Rect();
        faceParam.mFace = rect;
        float f17 = pointF.x;
        double d16 = f16;
        double d17 = 1.2d * d16;
        int i18 = (int) (f17 - d17);
        rect.left = i18;
        float f18 = pointF.y;
        int i19 = (int) (f18 - (0.9d * d16));
        rect.top = i19;
        int i26 = (int) (f17 + d17);
        rect.right = i26;
        int i27 = (int) (f18 + (1.4d * d16));
        rect.bottom = i27;
        if (i18 < 0) {
            rect.left = 0;
        }
        if (i19 < 0) {
            rect.top = 0;
        }
        if (i26 > i3) {
            rect.right = i3;
        }
        if (i27 > i16) {
            rect.bottom = i16;
        }
        Rect rect2 = new Rect();
        faceParam.mEye = rect2;
        float f19 = pointF.x;
        double d18 = 0.8d * d16;
        int i28 = (int) (f19 - d18);
        rect2.left = i28;
        float f26 = pointF.y;
        int i29 = (int) (f26 - (0.2d * d16));
        rect2.top = i29;
        int i36 = (int) (f19 + d18);
        rect2.right = i36;
        int i37 = (int) (f26 + (d16 * 0.28d));
        rect2.bottom = i37;
        if (i28 < 0) {
            i17 = 0;
            rect2.left = 0;
        } else {
            i17 = 0;
        }
        if (i29 < 0) {
            rect2.top = i17;
        }
        if (i36 > i3) {
            rect2.right = i3;
        }
        if (i37 > i16) {
            rect2.bottom = i16;
        }
        Rect rect3 = new Rect();
        faceParam.mLeftEye = rect3;
        rect3.left = rect2.left;
        rect3.right = ((rect2.width() * 3) / 7) + rect3.left;
        rect3.top = rect2.top - (rect2.height() / 6);
        rect3.bottom = ((rect2.height() * 4) / 3) + rect3.top;
        faceParam.mLeftEyeCenter = new Point(rect3.centerX(), rect3.centerY());
        Rect rect4 = new Rect(rect3);
        faceParam.mRightEye = rect4;
        rect4.left += (rect2.width() * 2) / 3;
        rect4.right += (rect2.width() * 2) / 3;
        faceParam.mRightEyeCenter = new Point(rect4.centerX(), rect4.centerY());
        Rect rect5 = new Rect();
        faceParam.mMouth = rect5;
        rect5.left = (int) (rect.left + ((rect.width() * 0.6d) / 2.0d));
        rect5.top = (int) (rect.top + (rect.height() * 0.72d));
        rect5.right = ((int) (rect.width() * 0.4d)) + rect5.left;
        rect5.bottom = ((int) (rect.height() * 0.16000000000000003d)) + rect5.top;
        faceParam.width = i3;
        faceParam.height = i16;
        this.mFaceParams.add(faceParam);
    }

    @Override // com.tencent.facebeauty.FaceDetect
    protected void doDetectFace(Bitmap bitmap) {
        int i3;
        int i16;
        Bitmap bitmap2 = bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bitmap2);
            return;
        }
        this.mDetectedFace = false;
        this.mFaceParams.clear();
        this.faceCount = 0;
        if (bitmap2 == null) {
            return;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        PointF pointF = new PointF();
        Bitmap.Config config = bitmap.getConfig();
        Bitmap.Config config2 = Bitmap.Config.RGB_565;
        if (config == config2) {
            i16 = 1;
        } else {
            if (width > height) {
                i3 = width;
            } else {
                i3 = height;
            }
            i16 = i3 / 512;
            if (i16 < 1) {
                i16 = 1;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(width / i16, height / i16, config2);
                new Canvas(createBitmap).drawBitmap(bitmap2, new Rect(0, 0, width, height), new Rect(0, 0, width / i16, height / i16), (Paint) null);
                bitmap2 = createBitmap;
            } catch (OutOfMemoryError unused) {
                pointF.x = bitmap.getWidth() / 2;
                pointF.y = bitmap.getHeight() / 2;
                caculateFaceAndEyes(pointF, bitmap.getWidth() / 4, width, height);
                return;
            }
        }
        FaceDetector.Face[] faceArr = new FaceDetector.Face[10];
        int findFaces = new FaceDetector(bitmap2.getWidth(), bitmap2.getHeight(), 10).findFaces(bitmap2, faceArr);
        bitmap2.recycle();
        this.faceCount = findFaces;
        int i17 = 0;
        while (i17 < this.faceCount) {
            FaceDetector.Face face2 = faceArr[i17];
            float eyesDistance = face2.eyesDistance();
            int i18 = i17 + 1;
            int i19 = i17;
            for (int i26 = i18; i26 < this.faceCount; i26++) {
                float eyesDistance2 = faceArr[i26].eyesDistance();
                if (eyesDistance2 > eyesDistance) {
                    i19 = i26;
                    eyesDistance = eyesDistance2;
                }
            }
            if (i19 != i17) {
                FaceDetector.Face face3 = faceArr[i19];
                faceArr[i19] = face2;
                faceArr[i17] = face3;
            }
            i17 = i18;
        }
        for (int i27 = 0; i27 < findFaces; i27++) {
            this.mDetectedFace = true;
            faceArr[i27].getMidPoint(pointF);
            float eyesDistance3 = faceArr[i27].eyesDistance();
            float f16 = i16;
            pointF.x *= f16;
            pointF.y *= f16;
            caculateFaceAndEyes(pointF, eyesDistance3 * f16, width, height);
        }
    }

    @Override // com.tencent.facebeauty.FaceDetect
    protected void doInitial() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.facebeauty.FaceDetect
    protected void doRelease() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }
}
