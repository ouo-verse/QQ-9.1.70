package com.tencent.mobileqq.transfile;

import android.app.Application;
import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.k;
import com.tencent.mobileqq.pic.t;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import mqq.app.AccountNotMatchException;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class AbstractImageDownloader extends BaseImageDownloader {
    static IPatchRedirector $redirector_ = null;
    private static final String BIG_IMG_DECODE = "big_img_decode";
    private static final String BIG_IMG_DECODE_LONG = "big_img_decode_long";
    private static final String BIG_IMG_DECODE_SLICE = "big_img_decode_slice";
    private static int BITMAP_CACHE_1M = 0;
    private static int BITMAP_CACHE_2M = 0;
    public static int DISPLAY_HEIGHT = 0;
    public static int DISPLAY_WIDTH = 0;
    private static final int ERRORCODE_BIG_IMG_LARGER_THAN_CACHE = 1;
    private static final int ERRORCODE_BIG_IMG_OOM_FAILED_LARGER_THAN_CACHE = 5;
    private static final int ERRORCODE_BIG_IMG_OOM_FAILED_LONG_IMG = 6;
    private static final int ERRORCODE_BIG_IMG_OOM_LONG_IMG = 3;
    private static final int ERRORCODE_BIG_IMG_OOM_NOT_LONG_IMG = 4;
    private static final int ERRORCODE_BIG_IMG_OOM_SMALLER_THAN_1280 = -1;
    private static final int ERRORCODE_BIG_IMG_OOM_SMALLER_THAN_CACHE = 2;
    private static final int ERRORCODE_BIG_IMG_SUCCESS = 0;
    private static final int REPORT_BIG_IMG_BASE_CONST = 88000;
    public static final String TAG_C2C = "c2c_file";
    public static final String TAG_DISCUSS = "discuss_file";
    public static final String TAG_GROUP = "group_file";
    protected BaseApplicationImpl application;
    protected String tag;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface Step {
        public static final int CONVERT_URL = 3;
        public static final int DOWNLOAD_FILE = 4;
        public static final int INIT = 1;
        public static final int MSG_URL_DOWN = 2;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75939);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        DISPLAY_WIDTH = 0;
        DISPLAY_HEIGHT = 0;
        BITMAP_CACHE_1M = 1048576;
        BITMAP_CACHE_2M = 1048576 * 2;
    }

    public AbstractImageDownloader(String str, BaseApplicationImpl baseApplicationImpl) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) baseApplicationImpl);
        } else {
            this.tag = str;
            this.application = baseApplicationImpl;
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options, int i3, int i16) {
        return Utils.calculateInSampleSize(options, i3, i16);
    }

    public static int getRoundRadius(Application application, int i3) {
        float f16;
        float f17;
        if (i3 > 150) {
            f16 = i3 / 100;
        } else {
            f16 = 1.0f;
        }
        double d16 = application.getResources().getDisplayMetrics().density;
        if (d16 <= 1.5d || d16 <= 2.0d) {
            f17 = f16 * 9.0f;
        } else {
            f17 = f16 * 4.0f;
        }
        return (int) f17;
    }

    private void log(Object obj, String str, String str2) {
        if (obj instanceof DownloadParams) {
            DownloadParams downloadParams = (DownloadParams) obj;
            Object obj2 = downloadParams.tag;
            if (obj2 instanceof t) {
                t tVar = (t) obj2;
                String protocol2 = downloadParams.url.getProtocol();
                boolean z16 = false;
                if (tVar.isSendFromLocal()) {
                    int fileType = RichMediaUtil.getFileType(((IPicHelper) QRoute.api(IPicHelper.class)).getFileSizeType(protocol2, false));
                    v picUploadInfo = tVar.getPicUploadInfo();
                    RichMediaUtil.log(picUploadInfo.f258713h, false, fileType, String.valueOf(picUploadInfo.D), str, str2);
                    return;
                } else {
                    k picDownloadInfo = tVar.getPicDownloadInfo();
                    if (picDownloadInfo.R == 1) {
                        z16 = true;
                    }
                    RichMediaUtil.log(picDownloadInfo.f258713h, false, RichMediaUtil.getFileType(((IPicHelper) QRoute.api(IPicHelper.class)).getFileSizeType(protocol2, z16)), String.valueOf(picDownloadInfo.D), str, str2);
                    return;
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.RICH_MEDIA, 2, "obj" + obj + " \tstep:" + str + " \tcontent:" + str2);
        }
    }

    private void logDecodeFile(DownloadParams downloadParams, File file, String str, BitmapFactory.Options options, int i3, boolean z16, String str2) {
        if (z16) {
            if (QLog.isColorLevel()) {
                log(downloadParams, "DecodeFile", "DecodeFile SUCCESS,retryCount=" + i3 + ",options.inSampleSize=" + options.inSampleSize + ",cacheFile=" + file.getAbsolutePath() + JefsClass.INDEX_URL + str + ",extraMsg=" + str2);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            log(downloadParams, "DecodeFile", "DecodeFile FAIL,retryCount=" + i3 + ",options.inSampleSize=" + options.inSampleSize + ",cacheFile=" + file.getAbsolutePath() + JefsClass.INDEX_URL + str + ",extraMsg=" + str2);
        }
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler);
        }
        if (QLog.isColorLevel()) {
            log(downloadParams, "DecodeFile", "decodeFile config.tag " + downloadParams.tag);
        }
        try {
            String str = downloadParams.urlStr;
            URL url = downloadParams.url;
            if (QLog.isColorLevel()) {
                log(downloadParams, "DecodeFile", "DecodeFile START,cacheFile=" + file.getAbsolutePath() + JefsClass.INDEX_URL + str);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = URLDrawableHelper.mConfig;
            options.inDensity = 160;
            options.inTargetDensity = 160;
            options.inScreenDensity = 160;
            options.inJustDecodeBounds = true;
            if (GifDrawable.isGifFile(file)) {
                if (QLog.isColorLevel()) {
                    log(downloadParams, "DecodeFile", "DecodeFile END,GIF image,cacheFile=" + file.getAbsolutePath() + JefsClass.INDEX_URL + str);
                    return null;
                }
                return null;
            }
            options.inJustDecodeBounds = true;
            SafeBitmapFactory.decodeFile(file.getAbsolutePath(), options);
            if (options.outHeight != 0 && options.outWidth != 0) {
                return decodeImage(url, file, downloadParams, options);
            }
            file.delete();
            logDecodeFile(downloadParams, file, str, options, 1, false, "step:decode bounds error, not valid pic");
            throw new IOException("step:decode bounds error, not valid pic");
        } catch (Exception e16) {
            String exceptionMessage = ProcessorReport.getExceptionMessage(e16);
            if (exceptionMessage == null || exceptionMessage.length() == 0) {
                exceptionMessage = e16.toString();
            }
            if (QLog.isColorLevel()) {
                QLog.e(this.tag, 2, exceptionMessage);
                log(downloadParams, "DecodeFile", "DecodeFile FAIL,exceptionmsg:" + exceptionMessage);
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("params_failDesc", exceptionMessage);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actPicUIDecoder", false, -1L, 0L, hashMap, "", true);
            throw e16;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseImageDownloader
    public int getTryTime(URL url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url)).intValue();
        }
        if (!url.getProtocol().equals(ProtocolDownloaderConstants.PROTOCOL_DATALINE_IMAGE) && !url.getProtocol().equals(AbsDownloader.PROTOCAL_FAVORITE_IMAGE)) {
            return super.getTryTime(url);
        }
        return 3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    void reportBitmapSize(Application application, String str, int i3, boolean z16) {
        int i16;
        int i17;
        char c16;
        int i18 = i3 * 4;
        try {
            if (i18 < BITMAP_CACHE_1M) {
                i17 = z16;
            } else {
                int i19 = i18 / BITMAP_CACHE_2M;
                if (i19 >= 10) {
                    if (z16 != 0) {
                        c16 = 17;
                    } else {
                        c16 = 16;
                    }
                } else if (i19 >= 8) {
                    if (z16 != 0) {
                        c16 = 15;
                    } else {
                        c16 = 14;
                    }
                } else if (i19 >= 6) {
                    if (z16 != 0) {
                        c16 = '\r';
                    } else {
                        c16 = '\f';
                    }
                } else {
                    int i26 = i19 * 2;
                    if (z16 != 0) {
                        i16 = i26 + 3;
                    } else {
                        i16 = i26 + 2;
                    }
                    i17 = i16;
                }
                i17 = c16;
            }
            QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getAppRuntime(str);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", Integer.toString(i17 + 88050));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(qQAppInterface.getCurrentAccountUin(), "report_aio_photo_size", false, 0L, 0L, hashMap, "");
        } catch (AccountNotMatchException unused) {
        }
    }

    void reportDecodeData(boolean z16, boolean z17, boolean z18, boolean z19, int i3, int i16, String str, boolean z26) {
        if (i16 == 3) {
            int i17 = i3 - 1;
            if (i3 == 1) {
                reportDecodeImage(this.application, BIG_IMG_DECODE, 0, str, i17);
                reportDecodeImage(this.application, BIG_IMG_DECODE_LONG, 0, str, i17);
                return;
            }
            if (z26) {
                if (!z16) {
                    if (z18) {
                        reportDecodeImage(this.application, BIG_IMG_DECODE, -1, str, i17);
                    } else {
                        reportDecodeImage(this.application, BIG_IMG_DECODE, 2, str, i17);
                    }
                } else {
                    reportDecodeImage(this.application, BIG_IMG_DECODE, 1, str, i17);
                }
                if (z17) {
                    reportDecodeImage(this.application, BIG_IMG_DECODE_LONG, 3, str, i17);
                } else {
                    reportDecodeImage(this.application, BIG_IMG_DECODE_LONG, 4, str, i17);
                }
                if (z17) {
                    reportDecodeImage(this.application, BIG_IMG_DECODE_SLICE, 0, str, i17);
                    return;
                }
                return;
            }
            if (z16) {
                reportDecodeImage(this.application, BIG_IMG_DECODE, 5, str, i17);
            }
            if (z17) {
                reportDecodeImage(this.application, BIG_IMG_DECODE_LONG, 6, str, i17);
            }
            if (z19) {
                reportDecodeImage(this.application, BIG_IMG_DECODE_SLICE, 6, str, i17);
            }
        }
    }

    void reportDecodeImage(Application application, String str, int i3, String str2, int i16) {
        boolean z16;
        int i17 = i3 + (i16 * 7) + REPORT_BIG_IMG_BASE_CONST;
        if (str2 != null) {
            try {
                str2 = ((QQAppInterface) BaseApplicationImpl.getApplication().getAppRuntime(str2)).getCurrentAccountUin();
            } catch (AccountNotMatchException unused) {
                return;
            }
        }
        String str3 = str2;
        if (i16 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_FailCode", Integer.toString(i17));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str3, str, z16, 0L, 0L, hashMap, "");
    }
}
