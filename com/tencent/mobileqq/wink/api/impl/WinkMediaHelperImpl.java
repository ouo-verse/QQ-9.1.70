package com.tencent.mobileqq.wink.api.impl;

import android.graphics.BitmapFactory;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.wink.api.IWinkMediaHelper;
import com.tencent.mobileqq.wink.editor.export.WinkExportUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes21.dex */
public class WinkMediaHelperImpl implements IWinkMediaHelper {
    public static final String TAG = "WinkMediaHelperImpl";

    @Override // com.tencent.mobileqq.wink.api.IWinkMediaHelper
    public LocalMediaInfo buildLocalMediaInfoByPath(String str) {
        int mediaType = QAlbumUtil.getMediaType(str);
        if (mediaType != 0) {
            if (mediaType != 1) {
                return null;
            }
            return WinkExportUtils.d(str);
        }
        return WinkExportUtils.c(str);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkMediaHelper
    public LocalMediaInfo buildLocalMediaInfoForVideo(String str) {
        return WinkExportUtils.d(str);
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkMediaHelper
    public boolean isSupportImageFormat(File file) {
        if (file != null && file.exists()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            localMediaInfo.mediaWidth = options.outWidth;
            localMediaInfo.mediaHeight = options.outHeight;
            localMediaInfo.mMimeType = "image/jpeg";
            boolean b16 = new d93.c().b(localMediaInfo);
            if (!b16) {
                QLog.d(TAG, 1, "unsupported image format width: " + localMediaInfo.mediaWidth + " height: " + localMediaInfo.mediaHeight);
            }
            return b16;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.wink.api.IWinkMediaHelper
    public boolean isSupportVideoFormat(int i3, int i16, int i17) {
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.mediaWidth = i3;
        localMediaInfo.mediaHeight = i16;
        localMediaInfo.mMimeType = "video/mp4";
        localMediaInfo.mDuration = i17;
        if (!new d93.c().c(localMediaInfo)) {
            QLog.d(TAG, 1, "unsupported video format duration: " + localMediaInfo.mDuration);
            return false;
        }
        return d93.c.INSTANCE.d(localMediaInfo);
    }
}
