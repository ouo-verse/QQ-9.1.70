package com.tencent.mobileqq.emoticon.data;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import java.io.File;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface MarketFaceConstants {
    public static final IPatchRedirector $redirector_ = null;
    public static final String H5MagicFileListPath;
    public static final String H5MagicIndexHtmlPath;
    public static final String H5MagicRootPath;
    public static final String H5MagicZipPath;
    public static final String SDCARD_EMOTICON_SAVE;
    public static final String emoticonAIOPreviewPath;
    public static final String emoticonAPNGPath;
    public static final String emoticonEncryptPath;
    public static final String emoticonJsonFilePath;
    public static final String emoticonPackageFolderPath;
    public static final String emoticonPreviewPath;
    public static final String emoticonSoundPath;
    public static final String magicFaceZipPath;
    public static final String pngFramePath;

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(33954), (Class<?>) MarketFaceConstants.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
            return;
        }
        String str = AppConstants.SDCARD_EMOTICON_SAVE;
        SDCARD_EMOTICON_SAVE = str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        sb5.append("[epId]");
        String str2 = File.separator;
        sb5.append(str2);
        String sb6 = sb5.toString();
        emoticonPackageFolderPath = sb6;
        pngFramePath = sb6 + "pngframe/";
        magicFaceZipPath = sb6 + "[epId].zip";
        String str3 = sb6 + "h5magic" + str2;
        H5MagicRootPath = str3;
        H5MagicFileListPath = str3 + "fileList";
        H5MagicIndexHtmlPath = str3 + "index.html";
        H5MagicZipPath = sb6 + "h5_json.zip";
        emoticonAPNGPath = sb6 + "[eId]_apng";
        emoticonEncryptPath = sb6 + "[eId]";
        emoticonJsonFilePath = sb6 + "[epId].jtmp";
        emoticonAIOPreviewPath = sb6 + "[eId]_aio.png";
        emoticonPreviewPath = sb6 + "[eId]_thu.png";
        emoticonSoundPath = sb6 + "[eId].amr";
    }
}
