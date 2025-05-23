package com.tencent.thumbplayer.richmedia;

import com.tencent.thumbplayer.api.asset.ITPUrlMediaAsset;
import com.tencent.thumbplayer.api.common.TPTimeRange;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequesterListener;
import com.tencent.thumbplayer.api.richmedia.TPRichMediaFeature;
import com.tencent.thumbplayer.common.TPNativeRetCode;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.core.utils.TPFieldCalledByNative;
import com.tencent.thumbplayer.libloader.TPLibraryLoader;

/* loaded from: classes26.dex */
public class TPRichMediaAsyncRequester implements ITPRichMediaAsyncRequester {
    private static final int INVALID_REQUEST_ID = -1;
    private static final String TAG = "TPRichMediaAsyncRequester";

    @TPFieldCalledByNative
    private long mNativeContext = 0;

    public TPRichMediaAsyncRequester() throws TPLoadLibraryException {
        if (TPLibraryLoader.isAllLibrariesSuccessfullyLoaded()) {
            try {
                native_setup();
                return;
            } catch (UnsatisfiedLinkError e16) {
                TPLogUtil.e(TAG, "Failed to create native rich media async requester:" + e16.getMessage());
                throw new TPLoadLibraryException("failed to create rich media async requester");
            }
        }
        throw new TPLoadLibraryException("native libraries not successfully loaded");
    }

    private native void native_cancelRequest(int i3);

    private native TPRichMediaFeature[] native_getFeatures();

    private native int native_prepareAsync();

    private native void native_release();

    private native int native_requestDataAsyncAtPositionMs(int i3, long j3);

    private native int native_requestDataAsyncAtPositionMsArray(int i3, long[] jArr);

    private native int native_requestDataAsyncAtTimeRange(int i3, TPTimeRange tPTimeRange);

    private native int native_requestDataAsyncAtTimeRangeArray(int i3, TPTimeRange[] tPTimeRangeArr);

    private native void native_setListener(ITPRichMediaAsyncRequesterListener iTPRichMediaAsyncRequesterListener);

    private native int native_setRichMediaSource(ITPUrlMediaAsset iTPUrlMediaAsset);

    private native void native_setup();

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public void cancelRequest(int i3) {
        try {
            native_cancelRequest(i3);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public TPRichMediaFeature[] getFeatures() {
        try {
            return native_getFeatures();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
            return new TPRichMediaFeature[0];
        }
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public void prepareAsync() throws IllegalStateException {
        int i3;
        try {
            i3 = native_prepareAsync();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
            i3 = TPNativeRetCode.FAILED;
        }
        if (i3 == 0) {
            return;
        }
        throw new IllegalStateException("prepareAsync, ret=" + i3);
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public void release() {
        try {
            setListener(null);
            native_release();
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public int requestDataAsyncAtPositionMs(int i3, long j3) {
        try {
            return native_requestDataAsyncAtPositionMs(i3, j3);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public int requestDataAsyncAtPositionMsArray(int i3, long[] jArr) {
        try {
            return native_requestDataAsyncAtPositionMsArray(i3, jArr);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public int requestDataAsyncAtTimeRange(int i3, TPTimeRange tPTimeRange) {
        if (tPTimeRange == null) {
            TPLogUtil.w(TAG, "requestDataAsyncAtTimeRange, timeRange == null");
            return -1;
        }
        try {
            return native_requestDataAsyncAtTimeRange(i3, tPTimeRange);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
            return -1;
        }
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public int requestDataAsyncAtTimeRangeArray(int i3, TPTimeRange[] tPTimeRangeArr) {
        if (tPTimeRangeArr != null && tPTimeRangeArr.length != 0) {
            try {
                return native_requestDataAsyncAtTimeRangeArray(i3, tPTimeRangeArr);
            } catch (UnsatisfiedLinkError e16) {
                TPLogUtil.e(TAG, e16.getMessage());
                return -1;
            }
        }
        TPLogUtil.w(TAG, "requestDataAsyncAtTimeRangeArray, timeRanges is null or empty");
        return -1;
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public void setListener(ITPRichMediaAsyncRequesterListener iTPRichMediaAsyncRequesterListener) {
        try {
            native_setListener(iTPRichMediaAsyncRequesterListener);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
        }
    }

    @Override // com.tencent.thumbplayer.api.richmedia.ITPRichMediaAsyncRequester
    public void setRichMediaSource(ITPUrlMediaAsset iTPUrlMediaAsset) throws IllegalStateException, IllegalArgumentException {
        int i3;
        try {
            i3 = native_setRichMediaSource(iTPUrlMediaAsset);
        } catch (UnsatisfiedLinkError e16) {
            TPLogUtil.e(TAG, e16.getMessage());
            i3 = TPNativeRetCode.FAILED;
        }
        if (i3 == 0) {
            return;
        }
        if (i3 == 11000012) {
            throw new IllegalArgumentException("setRichMediaSource\uff0cinvalid argument, urlMediaAsset=" + iTPUrlMediaAsset);
        }
        throw new IllegalStateException("setRichMediaSource:" + i3);
    }
}
