package org.light;

import android.graphics.RectF;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.light.bean.WMElement;
import org.light.callback.ComponentUpdateCallback;
import org.light.callback.WillReadSampleCallback;
import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class Controller {
    public static final int ControllerType_Camera = 1;
    public static final int ControllerType_Movie = 0;
    private static final String TAG = "Controller";
    protected long nativeHandle;

    static {
        try {
            nativeInit();
        } catch (Error e16) {
            LightLogUtil.e(TAG, e16.toString());
        }
    }

    private native void nativeAddComponent(int i3, String str);

    private native void nativeAddComponentUpdateMonitor(int i3);

    private native void nativeAddEntity(int i3, int i16, String str);

    private native String nativeFetchComponent(int i3);

    private native void nativeFinalize();

    private native HashMap<String, String> nativeGetAssetData();

    private native AudioPlaceHolder[] nativeGetAudioPlaceHolders();

    private native RectF nativeGetBoundsByKey(String str);

    private native TextPlaceHolder nativeGetEditableTextUnderPoint(float f16, float f17);

    private native WMElement[] nativeGetEditableWMItems();

    private native int[] nativeGetEntitiesUnderPoint(float f16, float f17);

    private native String[] nativeGetSoundEffectIDs();

    private native TextPlaceHolder[] nativeGetTextPlaceHolderByEntityId(int i3);

    private native TextPlaceHolder[] nativeGetTextPlaceHolders();

    private native TimeLine[] nativeGetTimeLines();

    private native boolean nativeHasAudio();

    private native boolean nativeHasSpecificMakeUpType(int i3);

    private static native void nativeInit();

    private native void nativeRemoveComponent(int i3, String str);

    private native void nativeRemoveComponentUpdateMonitor(int i3);

    private native void nativeRemoveEntity(int i3);

    private native void nativeReplaceAudioAsset(String str, AudioAsset audioAsset);

    private native void nativeResetAsset();

    private native void nativeSetAssetData(HashMap<String, String> hashMap);

    private native void nativeSetComponentUpdateCallback(ComponentUpdateCallback componentUpdateCallback);

    private native void nativeSetExternalAudioProcessor(HashMap<String, IExternalAudioProcessor> hashMap);

    private native void nativeSetMaterialClipAssets(String str, ClipAsset[] clipAssetArr, FaceDetectCallback faceDetectCallback);

    private native void nativeSetTextAsset(String str, TextAsset textAsset);

    private native void nativeSetWillReadSampleCallback(WillReadSampleCallback willReadSampleCallback);

    private native void nativeUpdateComponent(int i3, String str);

    private native void nativeUpdateResource(String str);

    public void addComponent(int i3, String str) {
        nativeAddComponent(i3, str);
    }

    public void addComponentUpdateMonitor(int i3) {
        nativeAddComponentUpdateMonitor(i3);
    }

    public void addEntity(int i3, int i16, String str) {
        nativeAddEntity(i3, i16, str);
    }

    public String fetchComponent(int i3) {
        return nativeFetchComponent(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void finalize() throws Throwable {
        super.finalize();
        if (this.nativeHandle != 0) {
            nativeFinalize();
        }
    }

    public HashMap<String, String> getAssetData() {
        return nativeGetAssetData();
    }

    public AudioPlaceHolder[] getAudioPlaceHolders() {
        return nativeGetAudioPlaceHolders();
    }

    public RectF getBoundsByKey(String str) {
        return nativeGetBoundsByKey(str);
    }

    public TextPlaceHolder getEditableTextUnderPoint(float f16, float f17) {
        return nativeGetEditableTextUnderPoint(f16, f17);
    }

    public List<WMElement> getEditableWMElement() {
        ArrayList arrayList = new ArrayList();
        WMElement[] editableWMItems = getEditableWMItems();
        if (editableWMItems == null) {
            return arrayList;
        }
        for (WMElement wMElement : editableWMItems) {
            wMElement.controller = this;
            arrayList.add(wMElement);
        }
        return arrayList;
    }

    public WMElement[] getEditableWMItems() {
        return nativeGetEditableWMItems();
    }

    public int[] getEntitiesUnderPoint(float f16, float f17) {
        return nativeGetEntitiesUnderPoint(f16, f17);
    }

    public String[] getSoundEffectIDs() {
        return nativeGetSoundEffectIDs();
    }

    public TextPlaceHolder[] getTextPlaceHolderByEntityId(int i3) {
        return nativeGetTextPlaceHolderByEntityId(i3);
    }

    public TextPlaceHolder[] getTextPlaceHolders() {
        return nativeGetTextPlaceHolders();
    }

    public TimeLine[] getTimeLines() {
        return nativeGetTimeLines();
    }

    public boolean hasAudio() {
        return nativeHasAudio();
    }

    public boolean hasSpecificMakeUpType(int i3) {
        return nativeHasSpecificMakeUpType(i3);
    }

    public void removeComponent(int i3, String str) {
        nativeRemoveComponent(i3, str);
    }

    public void removeComponentUpdateMonitor(int i3) {
        nativeRemoveComponentUpdateMonitor(i3);
    }

    public void removeEntity(int i3) {
        nativeRemoveEntity(i3);
    }

    public void replaceAudioAsset(String str, AudioAsset audioAsset) {
        nativeReplaceAudioAsset(str, audioAsset);
    }

    public void resetAsset() {
        nativeResetAsset();
    }

    public void setAssetData(HashMap<String, String> hashMap) {
        nativeSetAssetData(hashMap);
    }

    public void setComponentUpdateCallback(ComponentUpdateCallback componentUpdateCallback) {
        nativeSetComponentUpdateCallback(componentUpdateCallback);
    }

    public void setExternalAudioProcessor(HashMap<String, IExternalAudioProcessor> hashMap) {
        nativeSetExternalAudioProcessor(hashMap);
    }

    public void setMaterialClipAssets(String str, ClipAsset[] clipAssetArr) {
        setMaterialClipAssets(str, clipAssetArr, null);
    }

    public void setTextAsset(String str, TextAsset textAsset) {
        nativeSetTextAsset(str, textAsset);
    }

    public void setWillReadSampleCallback(WillReadSampleCallback willReadSampleCallback) {
        nativeSetWillReadSampleCallback(willReadSampleCallback);
    }

    public abstract int type();

    public void updateComponent(int i3, String str) {
        nativeUpdateComponent(i3, str);
    }

    public void updateResource(String str) {
        nativeUpdateResource(str);
    }

    public void setMaterialClipAssets(String str, ClipAsset[] clipAssetArr, FaceDetectCallback faceDetectCallback) {
        nativeSetMaterialClipAssets(str, clipAssetArr, faceDetectCallback);
    }
}
