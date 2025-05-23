package com.tencent.hippy.qq.api.impl;

import android.text.TextUtils;
import com.tencent.hippy.qq.adapter.HippyQQImageLoader;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.hippy.qq.api.IHippyImageUtil;
import com.tencent.hippy.qq.offline.HippyOfflineAssist;
import com.tencent.image.URLDrawable;
import java.io.File;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyImageUtilImpl implements IHippyImageUtil {
    @Override // com.tencent.hippy.qq.api.IHippyImageUtil
    public String getImageLocalPath(String str) {
        String offlineResPath = HippyOfflineAssist.getOfflineResPath(str);
        if (!TextUtils.isEmpty(offlineResPath)) {
            if (new File(offlineResPath).exists()) {
                return offlineResPath;
            }
            return null;
        }
        File fileInLocal = URLDrawable.getDrawable(str).getFileInLocal();
        if (fileInLocal != null && fileInLocal.exists()) {
            return fileInLocal.getAbsolutePath();
        }
        return null;
    }

    @Override // com.tencent.hippy.qq.api.IHippyImageUtil
    public String getImageType(File file) {
        return HippyImageInfo.getImageType(file);
    }

    @Override // com.tencent.hippy.qq.api.IHippyImageUtil
    public String getUrlWithParams(String str) {
        return HippyQQImageLoader.getUrlWithIsAvifSupport(str);
    }
}
