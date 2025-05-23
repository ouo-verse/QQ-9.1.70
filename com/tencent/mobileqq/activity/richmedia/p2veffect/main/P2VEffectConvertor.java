package com.tencent.mobileqq.activity.richmedia.p2veffect.main;

import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IControllerFilterProvider;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IControllerPrepareListener;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IFastRenderCallback;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IOnStopCompleteListener;
import com.tencent.mobileqq.activity.richmedia.p2veffect.listener.IP2VEnginePlayerCallback;
import com.tencent.mobileqq.activity.richmedia.p2veffect.model.MediaItem;
import cooperation.qzone.util.JarReflectUtil;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import java.util.ArrayList;

/* loaded from: classes10.dex */
public class P2VEffectConvertor implements IP2VEffectControll {
    private Object p2vEffectController;

    public P2VEffectConvertor(GLSurfaceView gLSurfaceView, IControllerPrepareListener iControllerPrepareListener) {
        this.p2vEffectController = null;
        this.p2vEffectController = JarReflectUtil.creatSpecifiedObject("com.tencent.mobileqq.activity.richmedia.p2veffect.P2VEffectsController", getParamsClass(GLSurfaceView.class, IControllerPrepareListener.class), gLSurfaceView, iControllerPrepareListener);
    }

    private Class[] getParamsClass(Class... clsArr) {
        Class[] clsArr2 = new Class[clsArr.length];
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            clsArr2[i3] = clsArr[i3];
        }
        return clsArr2;
    }

    @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
    public void addPlayerCallback(IP2VEnginePlayerCallback iP2VEnginePlayerCallback) {
        JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "addPlayerCallback", false, getParamsClass(IP2VEnginePlayerCallback.class), iP2VEnginePlayerCallback);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
    public void cancelSave(IOnStopCompleteListener iOnStopCompleteListener) {
        JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "cancelSave", false, getParamsClass(IOnStopCompleteListener.class), iOnStopCompleteListener);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
    public void onDestroy() {
        JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, MosaicConstants$JsFunction.FUNC_ON_DESTROY, false, null, null);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
    public void pausePlay() {
        JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, QZoneJsConstants.METHOD_RECORDER_PAUSE_PLAY, false, null, null);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
    public void prepare() {
        JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "prepare", false, null, null);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
    public void requestDraw() {
        JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "requestDraw", false, null, null);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
    public void resetVideoIndex() {
        JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "resetVideoIndex", false, null, null);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
    public void save(String str, IFastRenderCallback iFastRenderCallback) {
        JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "save", false, getParamsClass(String.class, IFastRenderCallback.class), str, iFastRenderCallback);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
    public void setFilterProvider(IControllerFilterProvider iControllerFilterProvider) {
        JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "setFilterProvider", false, getParamsClass(IControllerFilterProvider.class), iControllerFilterProvider);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
    public void setMediaItems(ArrayList<MediaItem> arrayList) {
        JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "setMediaItems", false, getParamsClass(ArrayList.class), arrayList);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
    public void setSquareTypeAndColor(int i3, int i16, int i17, int i18) {
        Object obj = this.p2vEffectController;
        Class cls = Integer.TYPE;
        JarReflectUtil.callSpecifiedMethod(obj, "setSquareTypeAndColor", false, getParamsClass(cls, cls, cls, cls), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
    }

    @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
    public void setWaterMarkerBitmap(Bitmap bitmap) {
        JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "setWaterMarkerBitmap", false, getParamsClass(Bitmap.class), bitmap);
    }

    @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
    public void setWaterMarkerEnable(boolean z16) {
        JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "setWaterMarkerEnable", false, getParamsClass(Boolean.TYPE), Boolean.valueOf(z16));
    }

    @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
    public void startPlay(boolean z16) {
        JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, "startPlay", false, getParamsClass(Boolean.TYPE), Boolean.valueOf(z16));
    }

    @Override // com.tencent.mobileqq.activity.richmedia.p2veffect.main.IP2VEffectControll
    public void stopPlay() {
        JarReflectUtil.callSpecifiedMethod(this.p2vEffectController, QZoneJsConstants.METHOD_RECORDER_STOP_PLAY, false, null, null);
    }
}
