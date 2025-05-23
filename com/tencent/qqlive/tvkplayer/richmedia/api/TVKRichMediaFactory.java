package com.tencent.qqlive.tvkplayer.richmedia.api;

import com.tencent.qqlive.tvkplayer.api.richmedia.sync.ITVKRichMediaSynchronizer;
import com.tencent.qqlive.tvkplayer.richmedia.sync.TVKRichMediaSynchronizerImpl;
import com.tencent.qqlive.tvkplayer.richmedia.sync.TVKRichMediaSynchronizerWrapper;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKRichMediaFactory {
    public static ITVKPrivateRichMediaSynchronizer createRichMediaImpl() {
        return new TVKRichMediaSynchronizerImpl();
    }

    public static ITVKRichMediaSynchronizer createRichMediaSynchronizer(ITVKPrivateRichMediaSynchronizer iTVKPrivateRichMediaSynchronizer) {
        return new TVKRichMediaSynchronizerWrapper(iTVKPrivateRichMediaSynchronizer);
    }
}
