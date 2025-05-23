package com.tencent.aelight.camera.play.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.ttpic.openapi.PTFaceAttr;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IFaceChangeUtils extends QRouteApi {
    PTFaceAttr detectFaceOrigin(Bitmap bitmap);

    boolean hasFaceInPic(Bitmap bitmap);
}
