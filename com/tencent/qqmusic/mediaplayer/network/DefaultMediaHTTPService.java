package com.tencent.qqmusic.mediaplayer.network;

import com.tencent.qqmusic.mediaplayer.util.Logger;

/* loaded from: classes23.dex */
public class DefaultMediaHTTPService implements IMediaHTTPService {
    private static final String TAG = "DefaultMediaHTTPService";

    @Override // com.tencent.qqmusic.mediaplayer.network.IMediaHTTPService
    public IMediaHTTPConnection makeHTTPConnection() {
        Logger.d(TAG, "makeHTTPConnection");
        return new DefaultMediaHTTPConnection();
    }
}
