package org.light;

import org.light.utils.LightLogUtil;

/* compiled from: P */
/* loaded from: classes29.dex */
public class MovieController extends Controller {
    private static final String TAG = "MovieController";

    static {
        try {
            nativeInit();
        } catch (Error e16) {
            LightLogUtil.e(TAG, e16.toString());
        }
    }

    private native long nativeDuration();

    private native TimeRange[] nativeGetBoundsTrackTimeRanges();

    private native ClipInfo[][] nativeGetClipInfos();

    private native ClipPlaceHolder[] nativeGetClipPlaceHolders();

    private native LUTPlaceHolder[] nativeGetLUTPlaceHolders();

    private native float nativeGetOriginVolume();

    private native TimeRange[] nativeGetTextTimeRanges();

    private native boolean nativeHasAudio();

    private static native void nativeInit();

    private native void nativeRegisterClipSourceFactory(ClipSourceFactory clipSourceFactory);

    private native void nativeReplaceLUTAsset(String str, LUTAsset lUTAsset);

    private native void nativeSetClipAssets(ClipAsset[] clipAssetArr, String str, boolean z16);

    private native void nativeSetOriginVolume(float f16, int i3);

    public long duration() {
        return nativeDuration();
    }

    public TimeRange[] getBoundsTrackTimeRanges() {
        return nativeGetBoundsTrackTimeRanges();
    }

    public ClipInfo[][] getClipInfos() {
        return nativeGetClipInfos();
    }

    public ClipPlaceHolder[] getClipPlaceHolders() {
        return nativeGetClipPlaceHolders();
    }

    public LUTPlaceHolder[] getLUTPlaceHolders() {
        return nativeGetLUTPlaceHolders();
    }

    public boolean getMediasTotalDurationLimitationStatus() {
        return nativeGetMediasTotalDurationLimitationStatus();
    }

    public float getOriginVolume() {
        return nativeGetOriginVolume();
    }

    public TimeRange[] getTextTimeRanges() {
        return nativeGetTextTimeRanges();
    }

    @Override // org.light.Controller
    public boolean hasAudio() {
        return nativeHasAudio();
    }

    public native boolean nativeGetMediasTotalDurationLimitationStatus();

    public native void nativeSetRenderMediaSize(int i3, int i16);

    public native void nativeSetupMediasTotalDurationLimitationStatus(boolean z16);

    public void registerClipSourceFactory(ClipSourceFactory clipSourceFactory) {
        nativeRegisterClipSourceFactory(clipSourceFactory);
    }

    public void replaceLUTAsset(String str, LUTAsset lUTAsset) {
        nativeReplaceLUTAsset(str, lUTAsset);
    }

    public void setClipAssets(ClipAsset[] clipAssetArr, String str) {
        setClipAssets(clipAssetArr, str, true);
    }

    public void setOriginVolume(float f16) {
        nativeSetOriginVolume(f16, -1);
    }

    public void setOriginVolumeForClip(float f16, int i3) {
        nativeSetOriginVolume(f16, i3);
    }

    public void setRenderMediaSize(int i3, int i16) {
        nativeSetRenderMediaSize(i3, i16);
    }

    public void setupMediasTotalDurationLimitationStatus(boolean z16) {
        nativeSetupMediasTotalDurationLimitationStatus(z16);
    }

    @Override // org.light.Controller
    public int type() {
        return 0;
    }

    public void setClipAssets(ClipAsset[] clipAssetArr, String str, boolean z16) {
        nativeSetClipAssets(clipAssetArr, str, z16);
    }
}
