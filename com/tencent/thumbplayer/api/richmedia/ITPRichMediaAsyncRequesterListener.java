package com.tencent.thumbplayer.api.richmedia;

import androidx.annotation.NonNull;
import com.tencent.thumbplayer.api.common.TPError;

/* loaded from: classes26.dex */
public interface ITPRichMediaAsyncRequesterListener {
    void onRequestDataError(ITPRichMediaAsyncRequester iTPRichMediaAsyncRequester, int i3, int i16, TPError tPError);

    void onRequestDataSuccess(ITPRichMediaAsyncRequester iTPRichMediaAsyncRequester, int i3, int i16, @NonNull TPRichMediaData tPRichMediaData);

    void onRequesterError(ITPRichMediaAsyncRequester iTPRichMediaAsyncRequester, TPError tPError);

    void onRequesterPrepared(ITPRichMediaAsyncRequester iTPRichMediaAsyncRequester);
}
