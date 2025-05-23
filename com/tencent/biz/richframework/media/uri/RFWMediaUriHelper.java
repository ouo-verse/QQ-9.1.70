package com.tencent.biz.richframework.media.uri;

import android.content.Context;
import android.os.Build;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.file.FileType;
import com.tencent.biz.richframework.media.MediaType;
import com.tencent.biz.richframework.util.RFWFileUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWMediaUriHelper {
    private final List<IMediaUriHandler> mMediaUriHandlers = new ArrayList();

    public RFWMediaUriHelper() {
        registerUriHandler();
    }

    private void registerUriHandler() {
        this.mMediaUriHandlers.add(new ImageUriHandler());
        this.mMediaUriHandlers.add(new VideoUriHandler());
        this.mMediaUriHandlers.add(new AudioUriHandler());
    }

    public UriWrapper getMediaUri(Context context, File file, String str, boolean z16) {
        FileType fileType = RFWFileUtils.getFileType(file.getPath());
        if (fileType == null) {
            if (Build.VERSION.SDK_INT >= 29) {
                RFWLog.d("RFWMediaUriHelper", RFWLog.USR, "[getMediaUri] unknown fileType, save to download.");
                return FileUriHandler.getMediaUri(context, file, str, z16);
            }
            RFWLog.e("RFWMediaUriHelper", RFWLog.USR, "[getMediaUri] fileType invalid.");
            return null;
        }
        if (!fileType.getTypeInfo().isSysAlbumSupported()) {
            RFWLog.e("RFWMediaUriHelper", RFWLog.USR, "[getMediaUri] Album unsupported type: " + fileType.name());
            return null;
        }
        for (IMediaUriHandler iMediaUriHandler : this.mMediaUriHandlers) {
            MediaType mediaType = fileType.getTypeInfo().getMediaType();
            if (iMediaUriHandler.isTarget(mediaType)) {
                UriWrapper mediaUri = iMediaUriHandler.getMediaUri(context, fileType, file, str, z16);
                mediaUri.mediaType = mediaType;
                return mediaUri;
            }
        }
        return null;
    }
}
