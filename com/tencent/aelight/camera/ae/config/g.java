package com.tencent.aelight.camera.ae.config;

import camera.MOBILE_QQ_MATERIAL_INTERFACE.CameraPropertyAIRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetFontDataRsp;
import camera.MOBILE_QQ_MATERIAL_INTERFACE.GetWatermarkDictRsp;
import com.tencent.mobileqq.app.BusinessObserver;

/* compiled from: P */
/* loaded from: classes32.dex */
public abstract class g implements BusinessObserver {
    public static final int STATE_SENSITIVE_FACE_FAILED = -2;
    public static final int STATE_SENSITIVE_FACE_ILLEGAL = -1;
    public static final int STATE_SENSITIVE_FACE_LEGAL = 0;
    private static final String TAG = "CameraPeakServiceObserver";

    private void handleCameraMaterialResponse(boolean z16, Object obj) {
        ms.a.f(TAG, "receive resp of camera property success:" + z16);
        if (obj != null && (obj instanceof CameraPropertyAIRsp)) {
            onUpdateCameraMaterialResponse(z16, (CameraPropertyAIRsp) obj);
            return;
        }
        ms.a.f(TAG, "receive resp of camera property response is null or is not valid:" + obj);
        onUpdateCameraMaterialResponse(z16, null);
    }

    private void preWatermarkLocation(boolean z16, Object obj) {
        ms.a.f(TAG, "requestDictBySSO receive resp of watermark success:" + z16);
        if (obj != null && (obj instanceof GetWatermarkDictRsp)) {
            onUpdateWatermarkLocation(z16, (GetWatermarkDictRsp) obj);
            return;
        }
        ms.a.c(TAG, "requestDictBySSO watermark location response is null or is not valid." + obj);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public final void onUpdate(int i3, boolean z16, Object obj) {
        switch (i3) {
            case 1:
                onUpdateRecommendText(z16, (com.tencent.aelight.camera.ae.gif.c) obj);
                return;
            case 2:
                onUpdateTextValid(z16, ((Boolean) obj).booleanValue());
                return;
            case 3:
                onUpdateOnlineUserNum(z16, ((Integer) obj).intValue());
                return;
            case 4:
                onGetFontData(z16, (GetFontDataRsp) obj);
                return;
            case 5:
                onUpdateFaceDetect(z16, ((Integer) obj).intValue());
                return;
            case 6:
                preWatermarkLocation(z16, obj);
                return;
            case 7:
                handleCameraMaterialResponse(z16, obj);
                return;
            default:
                return;
        }
    }

    protected void onGetFontData(boolean z16, GetFontDataRsp getFontDataRsp) {
    }

    public void onUpdateCameraMaterialResponse(boolean z16, CameraPropertyAIRsp cameraPropertyAIRsp) {
    }

    public void onUpdateFaceDetect(boolean z16, int i3) {
    }

    public void onUpdateOnlineUserNum(boolean z16, int i3) {
    }

    public void onUpdateRecommendText(boolean z16, com.tencent.aelight.camera.ae.gif.c cVar) {
    }

    public void onUpdateTextValid(boolean z16, boolean z17) {
    }

    public void onUpdateWatermarkLocation(boolean z16, GetWatermarkDictRsp getWatermarkDictRsp) {
    }
}
