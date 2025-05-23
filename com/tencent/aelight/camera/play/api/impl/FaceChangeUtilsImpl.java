package com.tencent.aelight.camera.play.api.impl;

import android.graphics.Bitmap;
import com.tencent.aelight.camera.ae.play.FaceChangeUtils;
import com.tencent.aelight.camera.play.api.IFaceChangeUtils;
import com.tencent.ttpic.openapi.PTFaceAttr;

/* compiled from: P */
/* loaded from: classes32.dex */
public class FaceChangeUtilsImpl implements IFaceChangeUtils {
    @Override // com.tencent.aelight.camera.play.api.IFaceChangeUtils
    public PTFaceAttr detectFaceOrigin(Bitmap bitmap) {
        return FaceChangeUtils.detectFaceOrigin(bitmap);
    }

    @Override // com.tencent.aelight.camera.play.api.IFaceChangeUtils
    public boolean hasFaceInPic(Bitmap bitmap) {
        return FaceChangeUtils.hasFaceInPic(bitmap);
    }
}
