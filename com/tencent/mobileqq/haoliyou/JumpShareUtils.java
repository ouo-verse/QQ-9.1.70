package com.tencent.mobileqq.haoliyou;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.media.ExifInterface;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.image.JpegExifReader;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.api.IScanUtilApi;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import msf.msgsvc.msg_ctrl$MsgCtrl;
import msf.msgsvc.msg_ctrl$ResvResvInfo;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class JumpShareUtils {
    static IPatchRedirector $redirector_ = null;
    public static final int MAX_SOURCE_SIZE = 1280;
    public static final int RECOG_RESULT_ERROR = 100;
    public static final int RECOG_RESULT_EXIST = 101;
    public static final int RECOG_RESULT_NOTEXIST = 102;
    public static final String TAG = "CheckForward.JumpShareUtils";
    public static final long TIME_INTERVAL_ONE = 1800000;
    public static final long TIME_INTERVAL_THREE = 7200000;
    public static final long TIME_INTERVAL_TWO = 3600000;
    public static final int TYPE_PKG_ONE = 1;
    public static final int TYPE_PKG_TWO = 2;
    public static volatile boolean isQRing;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(72497);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            isQRing = false;
        }
    }

    public JumpShareUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String CutStringByByte(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            if (str.getBytes("UTF-8").length < i3) {
                return str;
            }
        } catch (UnsupportedEncodingException e16) {
            e16.printStackTrace();
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i16 = 0;
        int i17 = 0;
        while (true) {
            if (i16 >= i3) {
                break;
            }
            char charAt = str.charAt(i16);
            stringBuffer.append(charAt);
            try {
                i17 += String.valueOf(charAt).getBytes("UTF-8").length;
                if (i17 > i3) {
                    stringBuffer.deleteCharAt(stringBuffer.length() - 1);
                    break;
                }
                i16++;
            } catch (UnsupportedEncodingException e17) {
                e17.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }

    public static int getBlackFlag() {
        BaseApplication context = BaseApplication.getContext();
        if (context == null) {
            return 0;
        }
        boolean hasPackage = hasPackage(context, 1);
        if (hasPackage(context, 2)) {
            return (hasPackage ? 1 : 0) | 2;
        }
        return hasPackage ? 1 : 0;
    }

    private static Pair<Integer, Integer> getGpgFlag(String str) {
        int i3;
        if (JpegExifReader.isCrashJpeg(str) || !PhotoUtils.isJPEGImage(str)) {
            return null;
        }
        int i16 = 0;
        try {
            ExifInterface exifInterface = new ExifInterface(str);
            i3 = !TextUtils.isEmpty(exifInterface.getAttribute("GPSLatitude")) ? 1 : 0;
            try {
                if (!TextUtils.isEmpty(exifInterface.getAttribute("Make"))) {
                    i3 |= 2;
                }
                String attribute = exifInterface.getAttribute("DateTime");
                if (!TextUtils.isEmpty(attribute)) {
                    try {
                        i16 = (int) (new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(attribute).getTime() / 1000);
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                }
            } catch (Exception e17) {
                e = e17;
                e.printStackTrace();
                return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
            }
        } catch (Exception e18) {
            e = e18;
            i3 = 0;
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
    }

    public static Pair<Integer, Integer> getImgFileWH(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            SafeBitmapFactory.decodeFile(str, options);
            int i3 = options.outWidth;
            int i16 = options.outHeight;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getImgFileWH " + i3 + APLogFileUtil.SEPARATOR_LOG + i16);
            }
            return new Pair<>(Integer.valueOf(i3), Integer.valueOf(i16));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static msg_ctrl$MsgCtrl getMsgCtrl(String str, int i3, int i16, String str2) {
        boolean z16;
        Pair<Integer, Integer> imgFileWH;
        File file;
        msg_ctrl$MsgCtrl msg_ctrl_msgctrl = new msg_ctrl$MsgCtrl();
        msg_ctrl$ResvResvInfo msg_ctrl_resvresvinfo = new msg_ctrl$ResvResvInfo();
        boolean z17 = true;
        if (str2 == null) {
            if (!TextUtils.isEmpty(str)) {
                file = new File(str);
            } else {
                file = null;
            }
            if (file != null && file.exists()) {
                if (ZhuoXusManager.instance().isSendFileQRCodeOpen()) {
                    Pair<StringBuilder, StringBuilder> qRCodeResult = getQRCodeResult(BaseApplication.getContext(), file);
                    if (qRCodeResult == null) {
                        if (QLog.isColorLevel()) {
                            QLog.w(TAG, 1, "calc file faild!");
                        }
                    } else {
                        Object obj = qRCodeResult.first;
                        if (obj != null) {
                            str2 = ((StringBuilder) obj).toString();
                        }
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.i("IMG_FILE_QR", 1, "chounizadi is false!");
                }
                str2 = "";
            } else {
                if (QLog.isColorLevel()) {
                    QLog.w(TAG, 1, "file not exists!");
                }
                return null;
            }
        }
        String CutStringByByte = CutStringByByte(str2, 128);
        if (!TextUtils.isEmpty(CutStringByByte)) {
            msg_ctrl_resvresvinfo.bytes_reserv1.set(ByteStringMicro.copyFromUtf8(CutStringByByte));
            z16 = true;
        } else {
            z16 = false;
        }
        if (ZhuoXusManager.instance().isSendFileScanApp() && getNeedReportInstallFlag()) {
            msg_ctrl_resvresvinfo.uint32_flag.set(1);
            msg_ctrl_resvresvinfo.uint64_reserv2.set(getBlackFlag());
            z16 = true;
        } else if (QLog.isColorLevel()) {
            QLog.i("IMG_FILE_QR", 1, "chounizadi is false!");
        }
        if (ZhuoXusManager.instance().isSendFileExifInfo()) {
            Pair<Integer, Integer> gpgFlag = getGpgFlag(str);
            if (gpgFlag != null) {
                msg_ctrl_resvresvinfo.uint64_reserv3.set(((Integer) gpgFlag.first).intValue());
                msg_ctrl_resvresvinfo.uint32_create_time.set(((Integer) gpgFlag.second).intValue());
            }
            if ((i3 == 0 || i16 == 0) && (imgFileWH = getImgFileWH(str)) != null) {
                i3 = ((Integer) imgFileWH.first).intValue();
                i16 = ((Integer) imgFileWH.second).intValue();
            }
            msg_ctrl_resvresvinfo.uint32_pic_width.set(i3);
            msg_ctrl_resvresvinfo.uint32_pic_height.set(i16);
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("IMG_FILE_QR", 1, "ZhuoXusManager exif switch is false!");
            }
            z17 = z16;
        }
        if (!z17) {
            return null;
        }
        msg_ctrl_msgctrl.resv_resv_info.set(msg_ctrl_resvresvinfo);
        return msg_ctrl_msgctrl;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0362 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x03ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static msg_ctrl$MsgCtrl getMsgCtrlForPicMsg(String str) {
        String str2;
        String str3;
        ?? r16;
        msg_ctrl$MsgCtrl msg_ctrl_msgctrl;
        String str4;
        long j3;
        String str5;
        JSONObject jSONObject;
        String str6;
        String str7;
        String str8;
        String string;
        String str9;
        HashMap<String, String> hashMap = new HashMap<>();
        msg_ctrl$MsgCtrl msg_ctrl_msgctrl2 = new msg_ctrl$MsgCtrl();
        msg_ctrl$ResvResvInfo msg_ctrl_resvresvinfo = new msg_ctrl$ResvResvInfo();
        if (ZhuoXusManager.instance().isSendPicQRCodeOpen() && !TextUtils.isEmpty(str)) {
            hashMap.put("param_qO", "1");
            hashMap.put("param_hU", "0");
            if (new File(str).exists()) {
                long currentTimeMillis = System.currentTimeMillis();
                Pair<StringBuilder, StringBuilder> qRCodeResult = getQRCodeResult(BaseApplication.getContext(), new File(str));
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                hashMap.put("param_rqC", String.valueOf(currentTimeMillis2));
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getMsgCtrlForPicMsg, rq tc = " + currentTimeMillis2);
                }
                if (qRCodeResult != null) {
                    str9 = ((StringBuilder) qRCodeResult.first).toString();
                } else {
                    str9 = null;
                }
                if (!TextUtils.isEmpty(str9)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getMsgCtrlForPicMsg, qu = " + str9);
                    }
                    try {
                        String CutStringByByte = CutStringByByte(str9, 128);
                        msg_ctrl_resvresvinfo.bytes_reserv1.set(ByteStringMicro.copyFromUtf8(CutStringByByte));
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "getMsgCtrlForPicMsg, set  r1 = " + CutStringByByte);
                        }
                        hashMap.put("param_hU", "1");
                    } catch (Exception e16) {
                        e16.printStackTrace();
                    }
                } else if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "getMsgCtrlForPicMsg, u null");
                }
            } else if (QLog.isColorLevel()) {
                QLog.w(TAG, 1, "file not exists!");
            }
        } else {
            hashMap.put("param_qO", "0");
        }
        if (!ZhuoXusManager.instance().isSendPicAppProbOpen() || !getNeedReportInstallFlag()) {
            str2 = "ImageLength";
            str3 = "param_hasPW";
            r16 = "param_hasPL";
            msg_ctrl_msgctrl = msg_ctrl_msgctrl2;
            str4 = "ImageWidth";
            hashMap.put("param_aPO", "0");
        } else {
            hashMap.put("param_aPO", "1");
            long currentTimeMillis3 = System.currentTimeMillis();
            int blackFlag = getBlackFlag();
            msg_ctrl_resvresvinfo.uint32_flag.set(1);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getMsgCtrlForPicMsg, set f = 1");
            }
            str3 = "param_hasPW";
            r16 = "param_hasPL";
            msg_ctrl_resvresvinfo.uint64_reserv2.set(blackFlag);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getMsgCtrlForPicMsg, set r2 = " + blackFlag);
            }
            long currentTimeMillis4 = System.currentTimeMillis();
            if (!QLog.isColorLevel()) {
                str2 = "ImageLength";
                msg_ctrl_msgctrl = msg_ctrl_msgctrl2;
                str4 = "ImageWidth";
            } else {
                StringBuilder sb5 = new StringBuilder();
                msg_ctrl_msgctrl = msg_ctrl_msgctrl2;
                sb5.append("getMsgCtrlForPicMsg, ap t c = ");
                str4 = "ImageWidth";
                str2 = "ImageLength";
                sb5.append(currentTimeMillis4 - currentTimeMillis3);
                QLog.d(TAG, 2, sb5.toString());
            }
            hashMap.put("param_aPC", String.valueOf(currentTimeMillis4 - currentTimeMillis3));
            hashMap.put("param_aI", String.valueOf(blackFlag));
        }
        if (ZhuoXusManager.instance().isSendPicExifOpen()) {
            hashMap.put("param_rEO", "1");
            long currentTimeMillis5 = System.currentTimeMillis();
            if (!JpegExifReader.isCrashJpeg(str) && PhotoUtils.isJPEGImage(str)) {
                try {
                    ExifInterface exifInterface = new ExifInterface(str);
                    if (!TextUtils.isEmpty(exifInterface.getAttribute("GPSLatitude"))) {
                        j3 = 1;
                    } else {
                        j3 = 0;
                    }
                    String attribute = exifInterface.getAttribute("Make");
                    if (attribute != null && !TextUtils.isEmpty(attribute)) {
                        j3 |= 2;
                    }
                    msg_ctrl_resvresvinfo.uint64_reserv3.set(j3);
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getMsgCtrlForPicMsg, set r3  = " + j3);
                    }
                    hashMap.put("param_pF", String.valueOf(j3));
                    try {
                        String attribute2 = exifInterface.getAttribute("DateTime");
                        if (!TextUtils.isEmpty(attribute2)) {
                            int time = (int) (new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(attribute2).getTime() / 1000);
                            msg_ctrl_resvresvinfo.uint32_create_time.set(time);
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "getMsgCtrlForPicMsg, set ct  = " + time);
                            }
                            hashMap.put("param_hPT", "1");
                        } else {
                            hashMap.put("param_hPT", "0");
                        }
                    } catch (Exception e17) {
                        e17.printStackTrace();
                    }
                    try {
                        String attribute3 = exifInterface.getAttribute("ImageDescription");
                        if (!TextUtils.isEmpty(attribute3)) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "decrip = " + attribute3);
                            }
                            jSONObject = new JSONObject(attribute3);
                            str6 = str2;
                            try {
                                String string2 = jSONObject.getString(str6);
                                str5 = str4;
                                try {
                                    string = jSONObject.getString(str5);
                                    try {
                                    } catch (Throwable th5) {
                                        th = th5;
                                        jSONObject = r16;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    jSONObject = r16;
                                    str7 = string2;
                                    str8 = null;
                                    th.printStackTrace();
                                    if (TextUtils.isEmpty(str7)) {
                                    }
                                    if (TextUtils.isEmpty(str8)) {
                                    }
                                    long currentTimeMillis6 = System.currentTimeMillis();
                                    if (QLog.isColorLevel()) {
                                    }
                                    hashMap.put("param_rEC", String.valueOf(currentTimeMillis6 - currentTimeMillis5));
                                    msg_ctrl$MsgCtrl msg_ctrl_msgctrl3 = msg_ctrl_msgctrl;
                                    msg_ctrl_msgctrl3.resv_resv_info.set(msg_ctrl_resvresvinfo);
                                    if (QLog.isColorLevel()) {
                                    }
                                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "act_getMsgCtrlForPicMsg", true, 0L, 0L, hashMap, "");
                                    return msg_ctrl_msgctrl3;
                                }
                                try {
                                    if (!TextUtils.isEmpty(string2)) {
                                        msg_ctrl_resvresvinfo.uint32_pic_height.set(Integer.valueOf(string2).intValue());
                                        if (QLog.isColorLevel()) {
                                            try {
                                                QLog.d(TAG, 2, "getMsgCtrlForPicMsg, set _pc  = " + Integer.valueOf(string2));
                                            } catch (Throwable th7) {
                                                th = th7;
                                                str8 = string;
                                                jSONObject = r16;
                                                str7 = string2;
                                                th.printStackTrace();
                                                if (TextUtils.isEmpty(str7)) {
                                                }
                                                if (TextUtils.isEmpty(str8)) {
                                                }
                                                long currentTimeMillis62 = System.currentTimeMillis();
                                                if (QLog.isColorLevel()) {
                                                }
                                                hashMap.put("param_rEC", String.valueOf(currentTimeMillis62 - currentTimeMillis5));
                                                msg_ctrl$MsgCtrl msg_ctrl_msgctrl32 = msg_ctrl_msgctrl;
                                                msg_ctrl_msgctrl32.resv_resv_info.set(msg_ctrl_resvresvinfo);
                                                if (QLog.isColorLevel()) {
                                                }
                                                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "act_getMsgCtrlForPicMsg", true, 0L, 0L, hashMap, "");
                                                return msg_ctrl_msgctrl32;
                                            }
                                        }
                                        jSONObject = r16;
                                        hashMap.put(jSONObject, "1");
                                    } else {
                                        jSONObject = r16;
                                        hashMap.put(jSONObject, "0");
                                    }
                                    if (!TextUtils.isEmpty(string)) {
                                        msg_ctrl_resvresvinfo.uint32_pic_width.set(Integer.valueOf(string).intValue());
                                        if (QLog.isColorLevel()) {
                                            QLog.d(TAG, 2, "getMsgCtrlForPicMsg, set _pw  = " + Integer.valueOf(string));
                                        }
                                        hashMap.put(str3, "1");
                                    } else {
                                        hashMap.put(str3, "0");
                                    }
                                    str8 = string;
                                    str7 = string2;
                                } catch (Throwable th8) {
                                    th = th8;
                                    str8 = string;
                                    str7 = string2;
                                    th.printStackTrace();
                                    if (TextUtils.isEmpty(str7)) {
                                    }
                                    if (TextUtils.isEmpty(str8)) {
                                    }
                                    long currentTimeMillis622 = System.currentTimeMillis();
                                    if (QLog.isColorLevel()) {
                                    }
                                    hashMap.put("param_rEC", String.valueOf(currentTimeMillis622 - currentTimeMillis5));
                                    msg_ctrl$MsgCtrl msg_ctrl_msgctrl322 = msg_ctrl_msgctrl;
                                    msg_ctrl_msgctrl322.resv_resv_info.set(msg_ctrl_resvresvinfo);
                                    if (QLog.isColorLevel()) {
                                    }
                                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "act_getMsgCtrlForPicMsg", true, 0L, 0L, hashMap, "");
                                    return msg_ctrl_msgctrl322;
                                }
                            } catch (Throwable th9) {
                                th = th9;
                                str5 = str4;
                                jSONObject = r16;
                                str7 = null;
                                str8 = null;
                                th.printStackTrace();
                                if (TextUtils.isEmpty(str7)) {
                                }
                                if (TextUtils.isEmpty(str8)) {
                                }
                                long currentTimeMillis6222 = System.currentTimeMillis();
                                if (QLog.isColorLevel()) {
                                }
                                hashMap.put("param_rEC", String.valueOf(currentTimeMillis6222 - currentTimeMillis5));
                                msg_ctrl$MsgCtrl msg_ctrl_msgctrl3222 = msg_ctrl_msgctrl;
                                msg_ctrl_msgctrl3222.resv_resv_info.set(msg_ctrl_resvresvinfo);
                                if (QLog.isColorLevel()) {
                                }
                                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "act_getMsgCtrlForPicMsg", true, 0L, 0L, hashMap, "");
                                return msg_ctrl_msgctrl3222;
                            }
                        } else {
                            str5 = str4;
                            jSONObject = r16;
                            str6 = str2;
                            str7 = null;
                            str8 = null;
                        }
                    } catch (Throwable th10) {
                        th = th10;
                        str5 = str4;
                        jSONObject = r16;
                        str6 = str2;
                    }
                    if (TextUtils.isEmpty(str7)) {
                        try {
                            String attribute4 = exifInterface.getAttribute(str6);
                            if (!TextUtils.isEmpty(attribute4)) {
                                msg_ctrl_resvresvinfo.uint32_pic_height.set(Integer.valueOf(attribute4).intValue());
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "getMsgCtrlForPicMsg, set ph  = " + Integer.valueOf(attribute4));
                                }
                                hashMap.put(jSONObject, "1");
                            } else {
                                hashMap.put(jSONObject, "0");
                            }
                        } catch (Exception e18) {
                            e18.printStackTrace();
                        }
                    }
                    if (TextUtils.isEmpty(str8)) {
                        try {
                            String attribute5 = exifInterface.getAttribute(str5);
                            if (!TextUtils.isEmpty(attribute5)) {
                                msg_ctrl_resvresvinfo.uint32_pic_width.set(Integer.valueOf(attribute5).intValue());
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, "getMsgCtrlForPicMsg, set pw  = " + Integer.valueOf(attribute5));
                                }
                                hashMap.put(str3, "1");
                            } else {
                                hashMap.put(str3, "0");
                            }
                        } catch (Exception e19) {
                            e19.printStackTrace();
                        }
                    }
                } catch (Exception e26) {
                    e26.printStackTrace();
                }
            }
            long currentTimeMillis62222 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getMsgCtrlForPicMsg, re, t c = " + (currentTimeMillis62222 - currentTimeMillis5));
            }
            hashMap.put("param_rEC", String.valueOf(currentTimeMillis62222 - currentTimeMillis5));
        } else {
            hashMap.put("param_rEO", "0");
        }
        msg_ctrl$MsgCtrl msg_ctrl_msgctrl32222 = msg_ctrl_msgctrl;
        msg_ctrl_msgctrl32222.resv_resv_info.set(msg_ctrl_resvresvinfo);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getMsgCtrlForPicMsg, set ri");
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "act_getMsgCtrlForPicMsg", true, 0L, 0L, hashMap, "");
        return msg_ctrl_msgctrl32222;
    }

    public static boolean getNeedReportInstallFlag() {
        ZhuoXusManager instance = ZhuoXusManager.instance();
        if (!instance.needThinkElseAppInstalled()) {
            return false;
        }
        String packageName1 = instance.packageName1();
        String packageName2 = instance.packageName2();
        if (TextUtils.isEmpty(packageName1) || TextUtils.isEmpty(packageName2)) {
            return false;
        }
        return true;
    }

    public static Pair<StringBuilder, StringBuilder> getQRCodeResult(Context context, File file) {
        if (isQRing) {
            return null;
        }
        isQRing = true;
        Pair<StringBuilder, StringBuilder> decodeQRCodeFromFile = ((IScanUtilApi) QRoute.api(IScanUtilApi.class)).decodeQRCodeFromFile(Uri.parse("file://" + file.getAbsolutePath()), context);
        isQRing = false;
        return decodeQRCodeFromFile;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0066, code lost:
    
        if (r2 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0070, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0068, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x006d, code lost:
    
        if (r2 == null) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getSHA1(String str) {
        BufferedInputStream bufferedInputStream;
        MessageDigest messageDigest;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            try {
                try {
                    byte[] bArr = new byte[10240];
                    try {
                        messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
                    } catch (NoSuchAlgorithmException e16) {
                        QLog.e(TAG, 1, "getSHA1 NoSuchAlgorithmException", e16);
                        messageDigest = null;
                    }
                    if (messageDigest == null) {
                        QLog.e(TAG, 1, "getSHA1 digest is null ");
                        try {
                            bufferedInputStream.close();
                        } catch (IOException unused) {
                        }
                        return null;
                    }
                    while (true) {
                        int read = bufferedInputStream.read(bArr);
                        if (read > 0) {
                            messageDigest.update(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException unused2) {
                            }
                        }
                    }
                    bufferedInputStream.close();
                    String bytes2HexStr = HexUtil.bytes2HexStr(messageDigest.digest());
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "getSHA1 = " + bytes2HexStr);
                    }
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused3) {
                    }
                    return bytes2HexStr;
                } catch (FileNotFoundException unused4) {
                }
            } catch (Throwable unused5) {
            }
        } catch (FileNotFoundException unused6) {
            bufferedInputStream = null;
        } catch (Throwable unused7) {
            bufferedInputStream = null;
        }
    }

    public static boolean hasPackage(Context context, String str) {
        if (context != null && str != null) {
            try {
                if (InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 256) != null) {
                    return true;
                }
            } catch (PackageManager.NameNotFoundException | Exception unused) {
            }
        }
        return false;
    }

    public static boolean hasPackage(Context context, int i3) {
        String packageName2;
        if (context == null) {
            return false;
        }
        ZhuoXusManager instance = ZhuoXusManager.instance();
        if (!instance.needThinkElseAppInstalled()) {
            return false;
        }
        if (i3 == 1) {
            packageName2 = instance.packageName1();
        } else {
            packageName2 = i3 == 2 ? instance.packageName2() : null;
        }
        if (TextUtils.isEmpty(packageName2)) {
            return false;
        }
        return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), packageName2, 256) != null;
    }
}
