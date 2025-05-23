package com.tencent.mobileqq.transfile;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.aw;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes19.dex */
public class DataLineFaceDownloader extends AbstractImageDownloader {
    static IPatchRedirector $redirector_ = null;
    public static final String PROTOCOL_DATALINE_FACE = "datalineface";
    static final String TAG = "DataLineFaceDownloader";

    public DataLineFaceDownloader(BaseApplicationImpl baseApplicationImpl) {
        super(TAG, baseApplicationImpl);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplicationImpl);
    }

    private String compressImage(Context context, String str) {
        String j3 = aw.j(context, str, 0);
        ImageInfo imageInfo = new ImageInfo();
        aw.c(4, context, str, j3, true, imageInfo, 0);
        return imageInfo.f184139m;
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (File) iPatchRedirector.redirect((short) 3, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        Object obj = downloadParams.tag;
        if (obj instanceof MessageForPic) {
            str = ((MessageForPic) obj).path;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            if (file.length() >= 1048576) {
                String compressImage = compressImage(this.application.getApplicationContext(), str);
                if (FileUtils.fileExists(compressImage)) {
                    File file2 = new File(compressImage);
                    QLog.i(TAG, 1, "DatalineChat downloadImage compress, orgFilePath:" + str + " orgFileSize:" + file.length() + " compressPath:" + compressImage + " compressFileSize:" + file2.length());
                    file = file2;
                }
            } else {
                QLog.i(TAG, 1, "DatalineChat downloadImage uncompress, orgFilePath:" + str + " orgFileSize:" + file.length());
            }
            BaseImageDownloader.copyFromFile(outputStream, file, uRLDrawableHandler);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return true;
    }

    public DataLineFaceDownloader(String str, BaseApplicationImpl baseApplicationImpl) {
        super(str, baseApplicationImpl);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) baseApplicationImpl);
    }
}
