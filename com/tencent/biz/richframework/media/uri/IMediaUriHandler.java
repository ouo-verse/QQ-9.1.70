package com.tencent.biz.richframework.media.uri;

import android.content.Context;
import com.tencent.biz.richframework.file.FileType;
import com.tencent.biz.richframework.media.MediaType;
import java.io.File;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface IMediaUriHandler {
    UriWrapper getMediaUri(Context context, FileType fileType, File file, String str, boolean z16);

    boolean isTarget(MediaType mediaType);
}
