package com.tencent.mobileqq.redtouch;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.data.RedTouchConst;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;
import org.apache.http.Header;

/* compiled from: P */
/* loaded from: classes17.dex */
public class f extends AbsDownloader {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected BaseApplicationImpl f280297d;

    public f(BaseApplicationImpl baseApplicationImpl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplicationImpl);
        } else {
            this.f280297d = baseApplicationImpl;
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        Header header;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        if (downloadParams != null && file != null && (header = downloadParams.getHeader(RedTouchConst.PicDownload.ISCIRCLE)) != null) {
            String value = header.getValue();
            if (!TextUtils.isEmpty(value)) {
                int intValue = Integer.valueOf(value).intValue();
                BaseApplicationImpl baseApplicationImpl = this.f280297d;
                if (baseApplicationImpl != null) {
                    i3 = x.c(baseApplicationImpl, 30.0f);
                } else {
                    i3 = 90;
                }
                Bitmap decodeScaledBitmap = BaseImageUtil.decodeScaledBitmap(file.getAbsolutePath(), i3, i3);
                if (intValue == 1) {
                    if (decodeScaledBitmap != null) {
                        return BaseImageUtil.getRoundedCornerBitmap(decodeScaledBitmap, decodeScaledBitmap.getWidth(), decodeScaledBitmap.getWidth(), decodeScaledBitmap.getHeight());
                    }
                    return null;
                }
                return decodeScaledBitmap;
            }
            return null;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (File) iPatchRedirector.redirect((short) 2, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        if (downloadParams != null && (obj = downloadParams.tag) != null && (obj instanceof String)) {
            String str = (String) obj;
            try {
                File file = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE));
                file.mkdirs();
                File file2 = new File(file, Utils.Crc64String(str));
                if (file2.exists()) {
                    return file2;
                }
                if (DownloaderFactory.o(new com.tencent.mobileqq.vip.g(str, file2), null) == 0) {
                    return file2;
                }
            } catch (Exception e16) {
                QLog.e("AbsDownloader", 1, "download exception " + e16);
            }
        }
        return null;
    }
}
