package com.tencent.thumbplayer.api.richmedia;

import androidx.annotation.Nullable;
import com.tencent.thumbplayer.api.exception.TPLoadLibraryException;
import com.tencent.thumbplayer.api.manager.TPMgr;
import com.tencent.thumbplayer.common.log.TPLogUtil;
import com.tencent.thumbplayer.richmedia.TPRichMediaAsyncRequester;
import com.tencent.thumbplayer.richmedia.TPRichMediaSynchronizer;

/* loaded from: classes26.dex */
public class TPRichMediaFactory {
    private static final String LOG_TAG = "TPRichMediaFactory";

    @Nullable
    public static ITPRichMediaAsyncRequester createRichMediaASyncRequester() {
        if (!TPMgr.isInitialized()) {
            return null;
        }
        try {
            return new TPRichMediaAsyncRequester();
        } catch (TPLoadLibraryException e16) {
            TPLogUtil.e(LOG_TAG, "Failed to create rich media async requester:" + e16.getMessage());
            return null;
        }
    }

    @Nullable
    public static ITPRichMediaSynchronizer createRichMediaSynchronizer() {
        if (!TPMgr.isInitialized()) {
            return null;
        }
        try {
            return new TPRichMediaSynchronizer();
        } catch (TPLoadLibraryException e16) {
            TPLogUtil.e(LOG_TAG, "Failed to create rich media synchronizer:" + e16.getMessage());
            return null;
        }
    }
}
