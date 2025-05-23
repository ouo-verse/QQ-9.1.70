package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.RotateAnimation;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationCrop;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.aw;
import com.tencent.mobileqq.utils.o;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import cooperation.plugin.IPluginManager;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.util.QZLog;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* loaded from: classes10.dex */
public class PhotoUtils extends o {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_FRIEND_UIN = "PHOTO_KEY_FRIEND_UIN";
    public static final int SIZE_1_M = 1048576;
    private static final String TAG = "PhotoUtils";
    public static SimpleDateFormat sDateFormatForHour;
    public static SimpleDateFormat sDateFormatForMinute;

    /* loaded from: classes10.dex */
    public interface SendReportType {
        public static final String Send_compress = "Send_compress";
        public static final String Send_raw = "Send_raw";
    }

    /* loaded from: classes10.dex */
    public static class WatermarkPicTask implements Runnable {
        static IPatchRedirector $redirector_ = null;
        public static final int MSG_DONE = 1000;
        public static final int MSG_FAILED = 1001;
        private final String mDstPath;
        private final MqqHandler mHandler;
        private final String mSrcPath;

        public WatermarkPicTask(String str, String str2, MqqHandler mqqHandler) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, mqqHandler);
                return;
            }
            this.mSrcPath = str;
            this.mDstPath = str2;
            this.mHandler = mqqHandler;
        }

        private void sendMsg(int i3) {
            MqqHandler mqqHandler = this.mHandler;
            if (mqqHandler != null) {
                mqqHandler.sendEmptyMessage(i3);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x011b  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0130  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x0147  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x014a  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            Bitmap bitmap;
            int i3;
            int i16;
            int height;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                Bitmap bitmap2 = null;
                Bitmap decodeFileWithBufferedStream = BaseImageUtil.decodeFileWithBufferedStream(this.mSrcPath, null);
                if (decodeFileWithBufferedStream == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(PhotoUtils.TAG, 2, "decode src is null.");
                    }
                    sendMsg(1001);
                    return;
                }
                int width = decodeFileWithBufferedStream.getWidth();
                int height2 = decodeFileWithBufferedStream.getHeight();
                int i17 = aw.i(this.mSrcPath);
                if (QLog.isColorLevel()) {
                    QLog.d(PhotoUtils.TAG, 2, "watermark pic task, w=" + width + ", h=" + height2 + ", r=" + i17);
                }
                Bitmap decodeResourceStream = BaseImageUtil.decodeResourceStream(BaseApplication.getContext().getResources(), R.drawable.f161870hb0);
                boolean z16 = true;
                if (width != 576) {
                    float f16 = width / 576.0f;
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeResourceStream, (int) (decodeResourceStream.getWidth() * f16), (int) (decodeResourceStream.getHeight() * f16), true);
                    decodeResourceStream.recycle();
                    decodeResourceStream = createScaledBitmap;
                }
                if (decodeResourceStream == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(PhotoUtils.TAG, 2, "can not load watermark icon.");
                    }
                    decodeFileWithBufferedStream.recycle();
                    sendMsg(1001);
                    return;
                }
                boolean z17 = false;
                try {
                    bitmap = Bitmap.createBitmap(width, height2, Bitmap.Config.ARGB_8888);
                    try {
                        Canvas canvas = new Canvas(bitmap);
                        canvas.drawBitmap(decodeFileWithBufferedStream, 0.0f, 0.0f, (Paint) null);
                        if (((i17 / 90) + 1) % 2 != 0) {
                            z16 = false;
                        }
                        if (z16) {
                            i16 = width - 20;
                            height = decodeResourceStream.getHeight();
                        } else {
                            i16 = height2 - 20;
                            height = decodeResourceStream.getHeight();
                        }
                        int i18 = i16 - height;
                        if (z16) {
                            canvas.save();
                            canvas.rotate(360 - i17, width / 2, height2 / 2);
                            canvas.translate(r0 - r7, r7 - r0);
                        }
                        canvas.drawBitmap(decodeResourceStream, 20.0f, i18, (Paint) null);
                        if (z16) {
                            canvas.restore();
                        }
                    } catch (Exception e16) {
                        e = e16;
                        bitmap2 = bitmap;
                        if (QLog.isColorLevel()) {
                            QLog.e(PhotoUtils.TAG, 2, e, new Object[0]);
                        }
                        bitmap = bitmap2;
                        if (bitmap != null) {
                        }
                        decodeFileWithBufferedStream.recycle();
                        decodeResourceStream.recycle();
                        if (QLog.isColorLevel()) {
                        }
                        if (z17) {
                        }
                        sendMsg(i3);
                    } catch (OutOfMemoryError e17) {
                        e = e17;
                        bitmap2 = bitmap;
                        if (QLog.isColorLevel()) {
                            QLog.e(PhotoUtils.TAG, 2, e, new Object[0]);
                        }
                        bitmap = bitmap2;
                        if (bitmap != null) {
                        }
                        decodeFileWithBufferedStream.recycle();
                        decodeResourceStream.recycle();
                        if (QLog.isColorLevel()) {
                        }
                        if (z17) {
                        }
                        sendMsg(i3);
                    }
                } catch (Exception e18) {
                    e = e18;
                } catch (OutOfMemoryError e19) {
                    e = e19;
                }
                if (bitmap != null) {
                    z17 = com.tencent.biz.qqstory.utils.b.b(bitmap, this.mDstPath);
                    bitmap.recycle();
                }
                decodeFileWithBufferedStream.recycle();
                decodeResourceStream.recycle();
                if (QLog.isColorLevel()) {
                    QLog.d(PhotoUtils.TAG, 2, "add watermark, result=" + z17);
                }
                if (z17) {
                    i3 = 1000;
                } else {
                    i3 = 1001;
                }
                sendMsg(i3);
            } catch (OutOfMemoryError unused) {
                if (QLog.isColorLevel()) {
                    QLog.d(PhotoUtils.TAG, 2, "decode src cause oom.");
                }
                sendMsg(1001);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68843);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            sDateFormatForMinute = new SimpleDateFormat("yyyy\u5e74MM\u6708dd HH\u70b9mm\u5206");
            sDateFormatForHour = new SimpleDateFormat("yyyy\u5e74MM\u6708dd HH\u70b9");
        }
    }

    public PhotoUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void backToPhoto(Intent intent, Activity activity) {
        intent.setClassName(intent.getStringExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME), intent.getStringExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_CLASS_NAME));
        intent.addFlags(603979776);
        activity.startActivity(intent);
        activity.finish();
    }

    public static int calculateInSampleSizeByWidth(BitmapFactory.Options options, int i3) {
        int i16 = options.outWidth;
        int i17 = 1;
        if (i16 > i3) {
            while ((i16 / 2) / i17 > i3) {
                i17 *= 2;
            }
        }
        return i17;
    }

    public static void copyReportInfo(Intent intent, ActivityURIRequest activityURIRequest) {
        boolean booleanExtra = intent.getBooleanExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT, false);
        String stringExtra = intent.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT_ACTION_NAME);
        String stringExtra2 = intent.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_ALBUM_REPORT_REVERSE2);
        String stringExtra3 = intent.getStringExtra(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_CAMERA_REPORT_REVERSE2);
        activityURIRequest.extra().putBoolean(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT, booleanExtra);
        activityURIRequest.extra().putString(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_REPORT_ACTION_NAME, stringExtra);
        activityURIRequest.extra().putString(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_ALBUM_REPORT_REVERSE2, stringExtra2);
        activityURIRequest.extra().putString(PeakConstants.CUSTOM_PHOTOPREVIEW_SENDBTN_CAMERA_REPORT_REVERSE2, stringExtra3);
    }

    public static String createContentDescription(int i3, LocalMediaInfo localMediaInfo, int i16) {
        StringBuilder sb5 = new StringBuilder();
        if (i3 != 1) {
            sb5.append("\u7167\u7247 ");
        } else {
            sb5.append("\u89c6\u9891 ");
        }
        sb5.append("\u62cd\u6444\u65f6\u95f4: ");
        sb5.append(sDateFormatForMinute.format(new Date(localMediaInfo.modifiedDate * 1000)));
        return sb5.toString();
    }

    public static String createContentDescriptionWithCheckBox(int i3, LocalMediaInfo localMediaInfo, int i16, boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        if (i3 != 1) {
            sb5.append("\u7167\u7247 ");
        } else {
            sb5.append("\u89c6\u9891 ");
        }
        sb5.append("\u62cd\u6444\u65f6\u95f4: ");
        sb5.append(sDateFormatForHour.format(new Date(localMediaInfo.modifiedDate * 1000)));
        return sb5.toString();
    }

    public static Bitmap drawBitmap(Bitmap bitmap, Bitmap bitmap2, int i3) {
        new Canvas(bitmap).drawBitmap(bitmap2, 0.0f, i3, (Paint) null);
        return bitmap;
    }

    public static Bitmap getBitmapFromFile(String str, int i3, int i16) {
        int calculateInSampleSizeByWidth;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            o.decodeFileWithBuffer(str, options);
            if (i3 <= 0 && i16 <= 0) {
                calculateInSampleSizeByWidth = 1;
            } else {
                calculateInSampleSizeByWidth = calculateInSampleSizeByWidth(options, i3);
            }
            options.inSampleSize = calculateInSampleSizeByWidth;
            options.inJustDecodeBounds = false;
            return o.decodeFileWithBuffer(str, options);
        } catch (Exception e16) {
            QZLog.e(TAG, 1, "getBitmapFromFile, exception", e16);
            return null;
        } catch (OutOfMemoryError unused) {
            QZLog.e(TAG, 1, "getBitmapFromFile, OutOfMemoryError");
            return null;
        }
    }

    public static String getCameraPath(String str, String str2, String str3) {
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        Object valueOf4;
        Object valueOf5;
        if (str2 == null) {
            str2 = "";
        }
        if (str3 == null) {
            str3 = "";
        }
        Calendar calendar = Calendar.getInstance();
        StringBuilder sb5 = new StringBuilder(str);
        sb5.append(str2);
        sb5.append(calendar.get(1));
        int i3 = calendar.get(2) + 1;
        if (i3 < 10) {
            valueOf = "0" + i3;
        } else {
            valueOf = Integer.valueOf(i3);
        }
        sb5.append(valueOf);
        int i16 = calendar.get(5);
        if (i16 < 10) {
            valueOf2 = "0" + i16;
        } else {
            valueOf2 = Integer.valueOf(i16);
        }
        sb5.append(valueOf2);
        int i17 = calendar.get(11);
        if (i17 < 10) {
            valueOf3 = "0" + i17;
        } else {
            valueOf3 = Integer.valueOf(i17);
        }
        sb5.append(valueOf3);
        int i18 = calendar.get(12);
        if (i18 < 10) {
            valueOf4 = "0" + i18;
        } else {
            valueOf4 = Integer.valueOf(i18);
        }
        sb5.append(valueOf4);
        int i19 = calendar.get(13);
        if (i19 < 10) {
            valueOf5 = "0" + i19;
        } else {
            valueOf5 = Integer.valueOf(i19);
        }
        sb5.append(valueOf5);
        sb5.append(calendar.getTimeInMillis());
        if (!new File(sb5.toString() + str3).exists()) {
            return sb5.toString() + str3;
        }
        StringBuilder sb6 = new StringBuilder(sb5);
        int length = sb5.length();
        for (int i26 = 1; i26 < Integer.MAX_VALUE; i26++) {
            sb6.append('(');
            sb6.append(i26);
            sb6.append(')');
            sb6.append(str3);
            if (!new File(sb6.toString()).exists()) {
                break;
            }
            sb6.delete(length, sb6.length());
        }
        return sb6.toString();
    }

    public static int getFileType(String str, ArrayList<LocalMediaInfo> arrayList) {
        LocalMediaInfo mediaInfo = getMediaInfo(str, arrayList);
        if (mediaInfo == null) {
            return -1;
        }
        return QAlbumUtil.getMediaType(mediaInfo);
    }

    public static LocalMediaInfo getMediaInfo(String str, ArrayList<LocalMediaInfo> arrayList) {
        if (TextUtils.isEmpty(str) || arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        Iterator<LocalMediaInfo> it = arrayList.iterator();
        while (it.hasNext()) {
            LocalMediaInfo next = it.next();
            if (next.path.equals(str)) {
                return next;
            }
        }
        return null;
    }

    public static String getRawPhotoSize(Context context, float f16) {
        float f17 = f16 / 1024000;
        if (f17 >= 10.0f) {
            return new DecimalFormat("0").format(f17) + "M";
        }
        if (f17 >= 1.0f) {
            return new DecimalFormat("0.0").format(f17) + "M";
        }
        double d16 = f17;
        if (d16 >= 0.001d) {
            return new DecimalFormat("0").format(f17 * 1024.0f) + "K";
        }
        if (d16 >= 1.0E-4d) {
            return new DecimalFormat("0.0").format(f17 * 1024.0f) + "K";
        }
        return "0.1K";
    }

    public static int getTypeforReport(SessionInfo sessionInfo) {
        if (sessionInfo != null) {
            int i3 = sessionInfo.f179555d;
            if (i3 == 0) {
                return 1;
            }
            if (i3 != 1) {
                if (i3 != 1000 && i3 != 1025 && i3 != 7400 && i3 != 10004 && i3 != 10008) {
                    switch (i3) {
                        default:
                            switch (i3) {
                                case 1020:
                                case 1021:
                                case 1022:
                                case 1023:
                                    break;
                                default:
                                    return 5;
                            }
                        case 1003:
                        case 1004:
                        case 1005:
                        case 1006:
                            return 3;
                    }
                }
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public static int getTypeforReport2(SessionInfo sessionInfo) {
        if (sessionInfo != null) {
            int i3 = sessionInfo.f179555d;
            if (i3 == 0) {
                return 1;
            }
            if (i3 != 1) {
                if (i3 != 1000 && i3 != 1025) {
                    if (i3 != 3000) {
                        if (i3 != 6000 && i3 != 6003 && i3 != 6005) {
                            if (i3 != 7400 && i3 != 10004 && i3 != 10008) {
                                switch (i3) {
                                    default:
                                        switch (i3) {
                                            case 1020:
                                            case 1021:
                                            case 1022:
                                            case 1023:
                                                break;
                                            default:
                                                return -1;
                                        }
                                    case 1003:
                                    case 1004:
                                    case 1005:
                                    case 1006:
                                        return 3;
                                }
                            }
                        } else {
                            return 5;
                        }
                    } else {
                        return 4;
                    }
                }
                return 3;
            }
            return 2;
        }
        return 0;
    }

    public static int getTypeforReportSpcialDiscuss(SessionInfo sessionInfo) {
        if (sessionInfo == null) {
            return -1;
        }
        if (sessionInfo.f179555d == 3000) {
            return 2;
        }
        return getTypeforReport(sessionInfo);
    }

    public static boolean isJPEGImage(String str) {
        String imageMimeType = o.getImageMimeType(str);
        if (TextUtils.isEmpty(imageMimeType)) {
            return false;
        }
        return imageMimeType.contains("image/jpeg");
    }

    public static long makeBatchIdQzone() {
        return System.currentTimeMillis();
    }

    public static void onSendResult(Activity activity, int i3, int i16, Intent intent, boolean z16, String str) {
        if (intent != null) {
            intent.removeExtra(PeakConstants.VIDEO_INFO);
        }
        if ((i3 == 2 || i3 == 7001) && i16 == -1) {
            if (intent == null) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "[onSendResult] data = null");
                }
                intent = new Intent();
            }
            intent.putExtra(PeakConstants.SEND_PHOTO_ACTIVITY_RESULT, -1);
            if (i3 == 7001) {
                Intent intent2 = activity.getIntent();
                QZoneHelper.saveSelectedAlbumInfo(str, intent2.getStringExtra("uin"), intent2.getStringExtra("UploadPhoto.key_album_id"), intent2.getStringExtra("UploadPhoto.key_album_name"));
                intent2.putExtras(intent);
                intent2.setClassName(activity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), activity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
                if (!z16) {
                    intent2.addFlags(603979776);
                    activity.startActivity(intent2);
                }
            } else {
                intent.setClassName(activity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), activity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME"));
                if (!z16) {
                    intent.addFlags(603979776);
                    m.f(intent);
                    activity.startActivity(intent);
                } else {
                    QLog.e(TAG, 1, "Watermark has been deleted!");
                }
            }
            activity.finish();
            QAlbumUtil.anim(activity, false, false);
        }
    }

    public static void reportSendSize(QQAppInterface qQAppInterface, String str, int i3, int i16) {
        StatisticCollector.getInstance(BaseApplication.getContext()).reportActionCount(qQAppInterface, qQAppInterface.getCurrentAccountUin(), "Pic_edit", str, 0, 1, null, String.valueOf(i3), null, String.valueOf(i16), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    public static boolean restorePhotoExif(String str, String str2) {
        String str3;
        int i3;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists() && file2.exists()) {
                try {
                    try {
                        if (!JpegExifReader.isCrashJpeg(str)) {
                            try {
                                if (!JpegExifReader.isCrashJpeg(str2)) {
                                    if (isJPEGImage(str) && isJPEGImage(str2)) {
                                        ExifInterface exifInterface = new ExifInterface(str);
                                        ExifInterface exifInterface2 = new ExifInterface(str2);
                                        String attribute = exifInterface.getAttribute("GPSLatitude");
                                        if (!TextUtils.isEmpty(attribute)) {
                                            exifInterface2.setAttribute("GPSLatitude", attribute);
                                        }
                                        String attribute2 = exifInterface.getAttribute("GPSLatitudeRef");
                                        if (!TextUtils.isEmpty(attribute2)) {
                                            exifInterface2.setAttribute("GPSLatitudeRef", attribute2);
                                        }
                                        String attribute3 = exifInterface.getAttribute("GPSLongitude");
                                        if (!TextUtils.isEmpty(attribute3)) {
                                            exifInterface2.setAttribute("GPSLongitude", attribute3);
                                        }
                                        String attribute4 = exifInterface.getAttribute("GPSLongitudeRef");
                                        if (!TextUtils.isEmpty(attribute4)) {
                                            exifInterface2.setAttribute("GPSLongitudeRef", attribute4);
                                        }
                                        String attribute5 = exifInterface.getAttribute("DateTime");
                                        if (!TextUtils.isEmpty(attribute5)) {
                                            exifInterface2.setAttribute("DateTime", attribute5);
                                        }
                                        String attribute6 = exifInterface.getAttribute("Flash");
                                        if (!TextUtils.isEmpty(attribute6)) {
                                            exifInterface2.setAttribute("Flash", attribute6);
                                        }
                                        String attribute7 = exifInterface.getAttribute("FocalLength");
                                        if (!TextUtils.isEmpty(attribute7)) {
                                            exifInterface2.setAttribute("FocalLength", attribute7);
                                        }
                                        String attribute8 = exifInterface.getAttribute("GPSDateStamp");
                                        if (!TextUtils.isEmpty(attribute8)) {
                                            exifInterface2.setAttribute("GPSDateStamp", attribute8);
                                        }
                                        String attribute9 = exifInterface.getAttribute("GPSTimeStamp");
                                        if (!TextUtils.isEmpty(attribute9)) {
                                            exifInterface2.setAttribute("GPSTimeStamp", attribute9);
                                        }
                                        String attribute10 = exifInterface.getAttribute("Make");
                                        if (!TextUtils.isEmpty(attribute10)) {
                                            exifInterface2.setAttribute("Make", attribute10);
                                        }
                                        String attribute11 = exifInterface.getAttribute("Model");
                                        if (!TextUtils.isEmpty(attribute11)) {
                                            exifInterface2.setAttribute("Model", attribute11);
                                        }
                                        String attribute12 = exifInterface.getAttribute("WhiteBalance");
                                        if (!TextUtils.isEmpty(attribute12)) {
                                            exifInterface2.setAttribute("WhiteBalance", attribute12);
                                        }
                                        String attribute13 = exifInterface.getAttribute("FNumber");
                                        if (!TextUtils.isEmpty(attribute13)) {
                                            exifInterface2.setAttribute("FNumber", attribute13);
                                        }
                                        String attribute14 = exifInterface.getAttribute("ExposureTime");
                                        if (!TextUtils.isEmpty(attribute14)) {
                                            exifInterface2.setAttribute("ExposureTime", attribute14);
                                        }
                                        String attribute15 = exifInterface.getAttribute("ISOSpeedRatings");
                                        if (!TextUtils.isEmpty(attribute15)) {
                                            exifInterface2.setAttribute("ISOSpeedRatings", attribute15);
                                        }
                                        String attribute16 = exifInterface.getAttribute("GPSAltitude");
                                        if (!TextUtils.isEmpty(attribute16)) {
                                            exifInterface2.setAttribute("GPSAltitude", attribute16);
                                        }
                                        String attribute17 = exifInterface.getAttribute("GPSAltitudeRef");
                                        if (!TextUtils.isEmpty(attribute17)) {
                                            exifInterface2.setAttribute("GPSAltitudeRef", attribute17);
                                        }
                                        exifInterface2.saveAttributes();
                                        return true;
                                    }
                                    return false;
                                }
                                return false;
                            } catch (IOException e16) {
                                e = e16;
                                i3 = 0;
                                str3 = TAG;
                                QLog.e(str3, 1, e, new Object[i3]);
                                return i3;
                            }
                        }
                        return false;
                    } catch (Exception e17) {
                        QLog.e(TAG, 1, e17, new Object[0]);
                        return false;
                    }
                } catch (IOException e18) {
                    e = e18;
                    str3 = TAG;
                    i3 = 0;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void rotate180Degrees(View view, boolean z16) {
        float f16;
        float f17 = 180.0f;
        if (z16) {
            f16 = 180.0f;
        } else {
            f16 = 0.0f;
        }
        if (z16) {
            f17 = 360.0f;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(f16, f17, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(300L);
        rotateAnimation.setFillAfter(true);
        view.startAnimation(rotateAnimation);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x001d -> B:12:0x0039). Please report as a decompilation issue!!! */
    public static boolean saveBitmapToFile(Bitmap bitmap, File file, Bitmap.CompressFormat compressFormat, int i3, boolean z16) {
        boolean z17 = false;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        z17 = bitmap.compress(compressFormat, i3, bufferedOutputStream2);
                        bufferedOutputStream2.flush();
                        if (z16) {
                            bitmap.recycle();
                        }
                        bufferedOutputStream2.close();
                    } catch (Exception e16) {
                        e = e16;
                        bufferedOutputStream = bufferedOutputStream2;
                        QLog.e(TAG, 1, "saveBitmapToFile exception", e);
                        if (bufferedOutputStream != null) {
                            bufferedOutputStream.close();
                        }
                        return z17;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e17) {
                                e17.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e18) {
                e = e18;
            }
        } catch (IOException e19) {
            e19.printStackTrace();
        }
        return z17;
    }

    static void sendCropImgResultToCoverStoreBroadCast(Context context, String str, int i3) {
        Intent intent = new Intent();
        intent.setAction("action.com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity.cover_img_crop_end");
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
        intent.putExtra(PeakConstants.QZONE_COVER_SYNC_FLAG, i3);
        context.sendBroadcast(intent);
    }

    public static void sendPhoto(Activity activity, Intent intent, ArrayList<String> arrayList, int i3, boolean z16) {
        String stringExtra = intent.getStringExtra(KEY_FRIEND_UIN);
        if (stringExtra != null) {
            intent.putExtra("uin", stringExtra);
        }
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        if (arrayList.size() == 1) {
            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", arrayList.get(0));
        }
        intent.putExtra(PeakConstants.SEND_SIZE_SPEC, i3);
        String stringExtra2 = intent.getStringExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME);
        String stringExtra3 = intent.getStringExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME);
        if (TextUtils.isEmpty(stringExtra3) || TextUtils.isEmpty(stringExtra2)) {
            stringExtra2 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
            stringExtra3 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("sendPhoto packageName=%s className=%s", stringExtra2, stringExtra3));
        }
        if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra3)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, String.format("sendPhoto extras=%s", intent.getExtras()));
            }
            intent.setClassName(stringExtra2, stringExtra3);
            intent.addFlags(603979776);
            boolean booleanExtra = intent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
            if (QLog.isColorLevel()) {
                QLog.d("forward", 2, "sendPhoto isCallFromPlugin=" + booleanExtra + "className=" + stringExtra3);
            }
            boolean booleanExtra2 = intent.getBooleanExtra(PeakConstants.IS_TROOP_SEND_MIXED_MSG, false);
            if (QLog.isColorLevel()) {
                QLog.d("zivonchen", 2, "sendPhoto isTroopSendMixedMsg = " + booleanExtra2);
            }
            boolean booleanExtra3 = intent.getBooleanExtra(PeakConstants.IS_START_ACTIVITY_FOR_RESULT, false);
            boolean booleanExtra4 = intent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
            if (booleanExtra2) {
                sendPhotoFromAio(activity, intent, arrayList, i3);
                activity.finish();
            } else if (booleanExtra4) {
                sendPhotoFromAio(activity, intent, arrayList, i3);
                activity.finish();
            } else if (booleanExtra3) {
                activity.setResult(-1, intent);
            } else if (!booleanExtra) {
                intent.putExtra("param_compressInitTime", System.currentTimeMillis());
                if (intent.getBooleanExtra("sIsCloudPrinter", false)) {
                    activity.startActivityForResult(intent, 102);
                } else {
                    activity.startActivityForResult(intent, 2);
                }
            } else {
                String stringExtra4 = intent.getStringExtra("PhotoConst.PLUGIN_NAME");
                String stringExtra5 = intent.getStringExtra("PhotoConst.PLUGIN_APK");
                String stringExtra6 = intent.getStringExtra("PhotoConst.UIN");
                if ("qzone_plugin.apk".equals(stringExtra5)) {
                    if (stringExtra3.equals("com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity")) {
                        sendCropImgResultToCoverStoreBroadCast(activity, arrayList.get(0), intent.getIntExtra(PeakConstants.QZONE_COVER_SYNC_FLAG, 0));
                    } else {
                        QzonePluginProxyActivity.setActivityNameToIntent(intent, stringExtra3);
                        intent.putExtra("cleartop", true);
                        intent.putExtra(PeakConstants.IS_FROM_PHOTO_LIST, true);
                        QZoneHelper.launchQZone(activity, stringExtra6, intent, -1);
                        z16 = false;
                    }
                } else if ("qqfav.apk".equals(stringExtra5)) {
                    QfavHelper.D(activity, stringExtra6, intent, 2);
                } else if (IQQComicPluginUtil.COMIC_PLUGIN_ID.equals(stringExtra5)) {
                    intent.putExtra("cleartop", true);
                    IPluginManager.i iVar = new IPluginManager.i(0);
                    iVar.f390198d = stringExtra5;
                    iVar.f390201g = stringExtra4;
                    iVar.f390197c = stringExtra6;
                    iVar.f390202h = stringExtra3;
                    iVar.f390203i = ((IQQComicUtil) QRoute.api(IQQComicUtil.class)).getProxyActivityClass(stringExtra3);
                    iVar.f390204j = intent;
                    iVar.f390205k = 2;
                    IPluginManager.B5(activity, iVar);
                }
            }
            if (!z16) {
                activity.finish();
                QAlbumUtil.anim(activity, false, false);
                return;
            }
            return;
        }
        String stringExtra7 = intent.getStringExtra(PeakConstants.DEST_BROADCAST_ACTION_NAME);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("sendPhoto action=%s", stringExtra7));
        }
        if (TextUtils.isEmpty(stringExtra7)) {
            QQToast.makeText(activity, HardCodeUtil.qqStr(R.string.p6h), 0).show();
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, String.format("sendPhoto extras=%s", intent.getExtras()));
        }
        intent.setComponent(null);
        intent.setAction(stringExtra7);
        intent.setFlags(intent.getFlags() & (-536870913) & (-67108865));
        try {
            activity.sendBroadcast(intent);
            activity.finish();
        } catch (Exception e16) {
            QLog.d(TAG, 1, "sendPhoto fail!", e16);
        }
    }

    public static void sendPhotoForPhotoPlus(Activity activity, Intent intent, ArrayList<String> arrayList) {
        String stringExtra = intent.getStringExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_CLASS_NAME);
        intent.setClassName(intent.getStringExtra(PeakConstants.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME), stringExtra);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
        if (arrayList.size() == 1) {
            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", arrayList.get(0));
        }
        intent.putExtra(PeakConstants.SEND_SIZE_SPEC, 0);
        intent.putExtra(PeakConstants.SEND_FLAG, true);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendPhotoForPhotoPlus , activity = " + activity + ",data = " + intent.getExtras());
        }
        intent.addFlags(603979776);
        if (stringExtra.contains("ForwardRecentActivity")) {
            int flags = intent.getFlags();
            if ((524288 & flags) > 0) {
                intent.setFlags(flags & (-524289));
            }
        }
        if (!intent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
            String stringExtra2 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            String stringExtra3 = intent.getStringExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME);
            if ("com.tencent.mobileqq.activity.SplashActivity".equals(stringExtra2) && "com.tencent.mobileqq.activity.photo.PhotoPreviewActivity".equals(stringExtra) && "com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(stringExtra3)) {
                intent.setClassName(intent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), stringExtra2);
            } else if ("com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(stringExtra)) {
                intent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.SplashActivity");
            }
            intent.putExtra("open_chatfragment_fromphoto", true);
            activity.startActivity(intent);
        } else if ("qzone_plugin.apk".equals(intent.getStringExtra("PhotoConst.PLUGIN_APK"))) {
            if (!stringExtra.contains("QZone") && intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME") != null) {
                stringExtra = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            }
            intent.getStringExtra("PhotoConst.PLUGIN_NAME");
            String stringExtra4 = intent.getStringExtra("PhotoConst.PLUGIN_APK");
            String stringExtra5 = intent.getStringExtra("PhotoConst.UIN");
            if ("qzone_plugin.apk".equals(stringExtra4)) {
                QzonePluginProxyActivity.setActivityNameToIntent(intent, stringExtra);
                intent.putExtra("cleartop", true);
                QZoneHelper.launchQZone(activity, stringExtra5, intent, -1);
            }
        }
        if (Utils.G(intent.getStringExtra("uin"))) {
            ReportController.o(null, "dc00898", "", "", "0X8007249", "0X8007249", 0, 0, "", "", "", "");
        }
        activity.finish();
    }

    public static final void sendPhotoFromAio(Context context, Intent intent, ArrayList<String> arrayList, int i3) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (intent == null) {
                intent = new Intent();
            }
            String stringExtra = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
            String stringExtra2 = intent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
            intent.setClassName(stringExtra, stringExtra2);
            intent.putExtra("open_chatfragment_fromphoto", true);
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", arrayList);
            intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", arrayList.get(0));
            intent.putExtra(PeakConstants.SEND_SIZE_SPEC, i3);
            intent.putExtra(PeakConstants.SEND_FLAG, true);
            intent.addFlags(603979776);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "sendPhotoFromAio activity = " + stringExtra2 + ", packageName = " + stringExtra + ", data = " + intent.getExtras());
            }
            intent.putExtra("open_chatfragment_fromphoto", true);
            context.startActivity(intent);
        }
    }

    public static void startPhotoEdit(Intent intent, Activity activity, String str, int i3, int i16, int i17, int i18, String str2, String str3) {
        int intExtra = intent.getIntExtra("Business_Origin", 0);
        if (100 != intExtra && 102 != intExtra && 103 != intExtra && 105 != intExtra) {
            intent.setClass(activity, PhotoCropActivity.class);
        } else {
            intent.setClass(activity, PhotoCropForPortraitActivity.class);
            intent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getShapeOfBusi(intExtra));
        }
        intent.removeExtra("Business_Origin");
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str2);
        intent.putExtra(PeakConstants.TARGET_PATH, str3);
        intent.putExtra(PeakConstants.CLIP_WIDTH, i3);
        intent.putExtra(PeakConstants.CLIP_HEIGHT, i16);
        intent.putExtra(PeakConstants.TARGET_WIDTH, i17);
        intent.putExtra(PeakConstants.TARGET_HEIGHT, i18);
        activity.startActivity(intent);
        QAlbumUtil.anim(activity, false, true);
    }

    public static void startPhotoEditForResult(Intent intent, Activity activity, String str, int i3, int i16, int i17, int i18, String str2, String str3, int i19) {
        int intExtra = intent.getIntExtra("Business_Origin", 0);
        if (100 != intExtra && 102 != intExtra && 103 != intExtra && 105 != intExtra && 106 != intExtra && 107 != intExtra) {
            intent.setClass(activity, PhotoCropActivity.class);
        } else {
            intent.setClass(activity, PhotoCropForPortraitActivity.class);
            intent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getShapeOfBusi(intExtra));
        }
        intent.removeExtra("Business_Origin");
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str2);
        intent.putExtra(PeakConstants.TARGET_PATH, str3);
        intent.putExtra(PeakConstants.CLIP_WIDTH, i3);
        intent.putExtra(PeakConstants.CLIP_HEIGHT, i16);
        intent.putExtra(PeakConstants.TARGET_WIDTH, i17);
        intent.putExtra(PeakConstants.TARGET_HEIGHT, i18);
        activity.startActivityForResult(intent, i19);
        QAlbumUtil.anim(activity, false, true);
    }

    public static void startPhotoListEdit(Intent intent, Activity activity, String str, int i3, int i16, int i17, int i18, String str2) {
        startPhotoListEditForResult(intent, activity, str, i3, i16, i17, i18, str2, -1);
    }

    public static void startPhotoListEditForResult(Intent intent, Activity activity, String str, int i3, int i16, int i17, int i18, String str2, int i19) {
        intent.setClass(activity, NewPhotoListActivity.class);
        intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 50);
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, PhotoListCustomizationCrop.F);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", str);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        intent.putExtra(PeakConstants.IS_SINGLE_NEED_EDIT, true);
        intent.putExtra(PeakConstants.TARGET_PATH, str2);
        intent.putExtra(PeakConstants.CLIP_WIDTH, i3);
        intent.putExtra(PeakConstants.CLIP_HEIGHT, i16);
        intent.putExtra(PeakConstants.TARGET_WIDTH, i17);
        intent.putExtra(PeakConstants.TARGET_HEIGHT, i18);
        intent.putExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, true);
        intent.putExtra(PeakConstants.USE_32_BIT_CONFIG, true);
        if (i19 > -1) {
            intent.putExtra("keyAction", "actionSelectPicture");
            activity.startActivityForResult(intent, i19);
        } else {
            activity.startActivity(intent);
        }
        QAlbumUtil.anim(activity, false, true);
    }

    public static void reportSendSize(QQAppInterface qQAppInterface, int i3, ArrayList<String> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        String str = SendReportType.Send_compress;
        if (i3 != 0 && i3 == 2) {
            str = SendReportType.Send_raw;
        }
        Iterator<String> it = arrayList.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            String next = it.next();
            if (next == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "reportSendSize sendReportType:path == null");
                }
            } else {
                i16 = (int) (i16 + new File(next).length());
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "reportSendSize sendReportType:" + str + ",count:" + arrayList.size() + ",totalSize:" + i16);
        }
        reportSendSize(qQAppInterface, str, arrayList.size(), i16);
    }

    public static void onSendResult(Activity activity, int i3, int i16, Intent intent, boolean z16) {
        if (activity == null || ((BaseActivity) activity).app == null) {
            return;
        }
        onSendResult(activity, i3, i16, intent, z16, MobileQQ.sMobileQQ.peekAppRuntime().getAccount());
    }
}
