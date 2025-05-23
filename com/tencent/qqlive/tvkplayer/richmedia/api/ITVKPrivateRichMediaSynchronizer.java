package com.tencent.qqlive.tvkplayer.richmedia.api;

import androidx.annotation.NonNull;
import com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer;
import com.tencent.thumbplayer.api.richmedia.ITPRichMediaSynchronizer;

/* loaded from: classes23.dex */
public interface ITVKPrivateRichMediaSynchronizer extends ITVKRichMediaSynchronizer {

    /* loaded from: classes23.dex */
    public interface ITVKOnRichMediaPrepareListener {
        void onRichMediaPrepareFailed();

        void onRichMediaPrepared();
    }

    ITPRichMediaSynchronizer getITPRichMediaSynchronizer();

    boolean isHasRichMediaPrepared();

    void prepareAsync() throws IllegalStateException;

    void release();

    void reset() throws IllegalStateException;

    void setOnRichMediaPreparedListener(ITVKOnRichMediaPrepareListener iTVKOnRichMediaPrepareListener);

    void setRichMediaFuncListUrl(@NonNull String str) throws IllegalStateException, IllegalArgumentException;
}
