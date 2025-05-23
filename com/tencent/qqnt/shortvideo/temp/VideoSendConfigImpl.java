package com.tencent.qqnt.shortvideo.temp;

import com.tencent.qqnt.shortvideo.temp.api.IVideoSendConfig;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/qqnt/shortvideo/temp/VideoSendConfigImpl;", "Lcom/tencent/qqnt/shortvideo/temp/api/IVideoSendConfig;", "()V", "getVideoThumbMaxWidth", "", "shortvideo_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes25.dex */
public final class VideoSendConfigImpl implements IVideoSendConfig {
    @Override // com.tencent.qqnt.shortvideo.temp.api.IVideoSendConfig
    public int getVideoThumbMaxWidth() {
        return 640;
    }
}
