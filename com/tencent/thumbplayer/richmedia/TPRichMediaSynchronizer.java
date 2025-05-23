package com.tencent.thumbplayer.richmedia;

import com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizerListener;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaData;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeature;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaOptParam;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.core.utils.TPFieldCalledByNative;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;
import com.tencent.thumbplayer.richmedia.ITPInnerRichMediaSynchronizer;

/* loaded from: classes26.dex */
public class TPRichMediaSynchronizer implements ITPInnerRichMediaSynchronizer {
    private static final String TAG = "TPRichMediaSynchronizer";

    @TPFieldCalledByNative
    private long mNativeContext = 0;

    public TPRichMediaSynchronizer() throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                native_setup();
                return;
            } catch (UnsatisfiedLinkError e16) {
                TPLogUtil.e(TAG, "Failed to create native rich media:" + e16.getMessage());
                throw new TPLoadLibraryException("Failed to create rich media synchronizer:" + e16.getMessage());
            }
        }
        throw new TPLoadLibraryException("native libraries not successfully loaded");
    }

    private native int native_deselectFeatureAsync(int i3);

    private native TPRichMediaFeature[] native_getFeatures();

    private native TPRichMediaData native_getRichMediaDataAtPositionMs(long j3, int[] iArr);

    private native int native_prepareAsync();

    private native void native_release();

    private native int native_reset();

    private native int native_seek(long j3);

    private native int native_selectFeatureAsync(int i3, TPRichMediaOptParam tPRichMediaOptParam);

    private native void native_setInnerListener(ITPInnerRichMediaSynchronizer.ITPInnerRichMediaSynchronizerListener iTPInnerRichMediaSynchronizerListener);

    private native void native_setListener(ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener);

    private native int native_setPlaybackRate(float f16);

    private native int native_setRichMediaSource(ITPUrlMediaAsset iTPUrlMediaAsset);

    private native void native_setup();

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void deselectFeatureAsync(int i3) throws IllegalStateException, IllegalArgumentException {
        try {
            int native_deselectFeatureAsync = native_deselectFeatureAsync(i3);
            if (native_deselectFeatureAsync == 0) {
                return;
            }
            if (native_deselectFeatureAsync == 11000012) {
                throw new IllegalArgumentException();
            }
            throw new IllegalStateException("deselectFeatureAsync:" + native_deselectFeatureAsync);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
        }
    }

    protected void finalize() throws Throwable {
        setInnerListener(null);
        setListener(null);
        release();
        super.finalize();
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public TPRichMediaFeature[] getFeatures() {
        try {
            return native_getFeatures();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.richmedia.ITPInnerRichMediaSynchronizer
    public TPRichMediaData getRichMediaDataAtPositionMs(long j3, int[] iArr) {
        try {
            return native_getRichMediaDataAtPositionMs(j3, iArr);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
            return null;
        }
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void prepareAsync() throws IllegalStateException {
        try {
            int native_prepareAsync = native_prepareAsync();
            if (native_prepareAsync == 0) {
                return;
            }
            throw new IllegalStateException("prepareAsync:" + native_prepareAsync);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void release() {
        try {
            setInnerListener(null);
            setListener(null);
            native_release();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void reset() throws IllegalStateException {
        try {
            int native_reset = native_reset();
            if (native_reset == 0) {
                return;
            }
            throw new IllegalStateException("reset:" + native_reset);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.richmedia.ITPInnerRichMediaSynchronizer
    public void seek(long j3) throws IllegalStateException, IllegalArgumentException {
        try {
            int native_seek = native_seek(j3);
            if (native_seek == 0) {
                return;
            }
            if (native_seek == 11000012) {
                throw new IllegalArgumentException();
            }
            throw new IllegalStateException("seek:" + native_seek);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void selectFeatureAsync(int i3, TPRichMediaOptParam tPRichMediaOptParam) throws IllegalStateException, IllegalArgumentException {
        try {
            int native_selectFeatureAsync = native_selectFeatureAsync(i3, tPRichMediaOptParam);
            if (native_selectFeatureAsync == 0) {
                return;
            }
            if (native_selectFeatureAsync == 11000012) {
                throw new IllegalArgumentException();
            }
            throw new IllegalStateException("selectAsync:" + native_selectFeatureAsync);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.richmedia.ITPInnerRichMediaSynchronizer
    public void setInnerListener(ITPInnerRichMediaSynchronizer.ITPInnerRichMediaSynchronizerListener iTPInnerRichMediaSynchronizerListener) {
        try {
            native_setInnerListener(iTPInnerRichMediaSynchronizerListener);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void setListener(ITPRichMediaSynchronizerListener iTPRichMediaSynchronizerListener) {
        try {
            native_setListener(iTPRichMediaSynchronizerListener);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.richmedia.ITPInnerRichMediaSynchronizer
    public void setPlaybackRate(float f16) throws IllegalStateException, IllegalArgumentException {
        try {
            int native_setPlaybackRate = native_setPlaybackRate(f16);
            if (native_setPlaybackRate == 0) {
                return;
            }
            if (native_setPlaybackRate == 11000012) {
                throw new IllegalArgumentException();
            }
            throw new IllegalStateException("setPlaybackRate:" + native_setPlaybackRate);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer
    public void setRichMediaSource(ITPUrlMediaAsset iTPUrlMediaAsset) throws IllegalStateException, IllegalArgumentException {
        try {
            int native_setRichMediaSource = native_setRichMediaSource(iTPUrlMediaAsset);
            if (native_setRichMediaSource == 0) {
                return;
            }
            if (native_setRichMediaSource == 11000012) {
                throw new IllegalArgumentException();
            }
            throw new IllegalStateException("setRichMediaSource:" + native_setRichMediaSource);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
        }
    }
}
