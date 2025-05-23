package com.tencent.gamematrix.gmcg.sdk.view;

import android.graphics.Bitmap;
import com.tencent.gamematrix.gmcg.api.model.GmCgDeviceInfo;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGAppUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGFileUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGStringUtil;
import com.tencent.gamematrix.gmcg.base.utils.CGSystemUtil;
import java.io.File;
import java.io.FileOutputStream;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGLoadingLastFrameCache {
    private static final String CG_LOADING_FRAME_IMG_PREFIX = "cg_loading_frame_";
    private final GmCgDeviceInfo mGmCgDeviceInfo;

    public CGLoadingLastFrameCache(GmCgDeviceInfo gmCgDeviceInfo) {
        this.mGmCgDeviceInfo = gmCgDeviceInfo;
    }

    private String getLastFrameSavePath() {
        if (this.mGmCgDeviceInfo != null) {
            try {
            } catch (Exception unused) {
                return null;
            }
        }
        return CGAppUtil.getAppImgSaveDir() + File.separator + CG_LOADING_FRAME_IMG_PREFIX + CGSystemUtil.encryptMd5((this.mGmCgDeviceInfo.getDeviceTag() + "@" + this.mGmCgDeviceInfo.getDeviceID() + "@" + this.mGmCgDeviceInfo.getControlkey()).getBytes()) + ".jpg";
    }

    public String getLastFrameImgIfHave() {
        File[] listFiles;
        String lastFrameSavePath = getLastFrameSavePath();
        if (CGStringUtil.notEmpty(lastFrameSavePath) && (listFiles = new File(CGAppUtil.getAppImgSaveDir()).listFiles()) != null && listFiles.length > 0) {
            for (File file : listFiles) {
                CGLog.i("CGLoadingLastFrameCache getLastFrameImgIfHave: " + file.getAbsolutePath());
                if (file.getName().contains(CG_LOADING_FRAME_IMG_PREFIX)) {
                    if (file.getAbsolutePath().equals(lastFrameSavePath)) {
                        CGLog.i("CGLoadingLastFrameCache getLastFrameImgIfHave: found");
                        return file.getAbsolutePath();
                    }
                    CGLog.i("CGLoadingLastFrameCache getLastFrameImgIfHave: delete other");
                    CGFileUtil.deleteFile(file.getAbsolutePath());
                }
            }
            return null;
        }
        return null;
    }

    public void removeLastFrameImgIfHave() {
        CGLog.i("CGLoadingLastFrameCache removeLastFrameImgIfHave");
        for (File file : new File(CGAppUtil.getAppImgSaveDir()).listFiles()) {
            if (file.getName().startsWith(CG_LOADING_FRAME_IMG_PREFIX)) {
                CGFileUtil.deleteFile(file.getAbsolutePath());
            }
        }
    }

    public void saveLastFrameAsImg(Bitmap bitmap) {
        String lastFrameSavePath = getLastFrameSavePath();
        if (CGStringUtil.notEmpty(lastFrameSavePath)) {
            CGLog.i("CGLoadingLastFrameCache saveLastFrameAsImg: " + lastFrameSavePath);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(lastFrameSavePath));
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }
}
