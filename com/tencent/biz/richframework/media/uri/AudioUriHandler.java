package com.tencent.biz.richframework.media.uri;

import android.content.Context;
import com.tencent.biz.richframework.file.FileType;
import com.tencent.biz.richframework.media.MediaType;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AudioUriHandler implements IMediaUriHandler {
    @Override // com.tencent.biz.richframework.media.uri.IMediaUriHandler
    public UriWrapper getMediaUri(Context context, FileType fileType, File file, String str, boolean z16) {
        return null;
    }

    @Override // com.tencent.biz.richframework.media.uri.IMediaUriHandler
    public boolean isTarget(MediaType mediaType) {
        if (mediaType == MediaType.AUDIO) {
            return true;
        }
        return false;
    }
}
