package com.tencent.mobileqq.transfile;

import com.tencent.image.JpegExifReader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RichMediaUtil {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_PROPERBALITY = 10000;
    public static final long MAX_ACTIVE_REPORT_DURATION = 600000;
    public static final int REPORT_RECV_TIME_THRESHHOLD = 30000;
    public static final int REPORT_SEND_TIME_THRESHHOLD = 60000;
    private static final String[] SUPPORTED_MODULE;
    private static final String[] SUPPORTED_UINTYPE;
    private static final String TAG = "RichMediaUtil";
    private static String[] imgAllTags;
    private static String[] imgRecvTags;
    private static String[] imgSendTags;
    private static String[] pttDownTags;
    private static Random random;
    private static HashMap<String, ActiveRtpParam> sActiveRptMap;
    private static boolean sIsActiveReport;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class ActiveRtpParam {
        static IPatchRedirector $redirector_;
        int appid;
        String[] tags;

        ActiveRtpParam(int i3, String[] strArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) strArr);
            } else {
                this.tags = strArr;
                this.appid = i3;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(38502);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        SUPPORTED_MODULE = new String[]{"T", "U", "L"};
        SUPPORTED_UINTYPE = new String[]{"c2c", "grp", "dis"};
        random = new Random();
        sActiveRptMap = new HashMap<>();
        sIsActiveReport = false;
    }

    public RichMediaUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getActionDesc(int i3) {
        String str = "" + i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    return "fw";
                }
                return str;
            }
            return "up";
        }
        return "dw";
    }

    public static int getFileType(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 == 65537 || i3 != 131075) {
            return 65537;
        }
        return 131075;
    }

    public static String getFileTypeDesc(int i3) {
        String str = "" + i3;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 6 && i3 != 9 && i3 != 17 && i3 != 20) {
                        if (i3 != 131078) {
                            switch (i3) {
                                case 65537:
                                    return "thu";
                                case 65538:
                                    return "emo";
                                default:
                                    switch (i3) {
                                        case 131075:
                                            return "raw";
                                        case 131076:
                                            return "url";
                                        default:
                                            return str;
                                    }
                            }
                        }
                        return "msg";
                    }
                    return "shortvideo";
                }
                return "ptt";
            }
            return "pic";
        }
        return "fil";
    }

    public static String[] getImageRecvTags() {
        String[] strArr = imgRecvTags;
        if (strArr != null) {
            return strArr;
        }
        ArrayList<String> imageTags = getImageTags("dw");
        String[] strArr2 = (String[]) imageTags.toArray(new String[imageTags.size()]);
        imgRecvTags = strArr2;
        return strArr2;
    }

    public static String[] getImageSendTags() {
        String[] strArr = imgSendTags;
        if (strArr != null) {
            return strArr;
        }
        ArrayList<String> imageTags = getImageTags("up");
        String[] strArr2 = (String[]) imageTags.toArray(new String[imageTags.size()]);
        imgSendTags = strArr2;
        return strArr2;
    }

    public static String[] getImageTags() {
        String[] strArr = imgAllTags;
        if (strArr != null) {
            return strArr;
        }
        ArrayList<String> imageTags = getImageTags("up");
        imageTags.addAll(getImageTags("dw"));
        String[] strArr2 = (String[]) imageTags.toArray(new String[imageTags.size()]);
        imgAllTags = strArr2;
        return strArr2;
    }

    public static String[] getPttDownTags() {
        String[] strArr = pttDownTags;
        if (strArr != null) {
            return strArr;
        }
        ArrayList<String> pttTags = getPttTags("dw");
        String[] strArr2 = (String[]) pttTags.toArray(new String[pttTags.size()]);
        pttDownTags = strArr2;
        return strArr2;
    }

    private static ArrayList<String> getPttTags(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : SUPPORTED_UINTYPE) {
            for (String str3 : SUPPORTED_MODULE) {
                arrayList.add(TransFileUtil.buildTag(str2, "ptt", str, str3));
            }
        }
        return arrayList;
    }

    public static final boolean isActiveReporting() {
        return sIsActiveReport;
    }

    public static boolean isPicLandscape(String str) {
        int i3;
        boolean z16 = false;
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            i3 = JpegExifReader.getRotationDegree(str);
            if (i3 == 90 || i3 == 270) {
                z16 = true;
            }
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isPicLandscape .result =  " + z16 + ",degree = " + i3 + ",path = " + str);
        }
        return z16;
    }

    public static void log(int i3, boolean z16, int i16, String str, String str2, String str3) {
        TransFileUtil.log("T", TransFileUtil.getUinDesc(i3), z16, getFileTypeDesc(i16), str, str2, str3, null);
    }

    public static void logForFw(String str, String str2, String str3, String str4, String str5, String str6, Throwable th5) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("id:");
        sb5.append(str4);
        sb5.append(" \tstep:");
        sb5.append(str5);
        sb5.append(" \tcont:");
        sb5.append(str6);
        sb5.append(" \tver:");
        sb5.append(TransFileUtil.getVersionCode());
        if ("T".equals(str)) {
            sb5.append(" \ttid:");
            sb5.append(Thread.currentThread().getId());
        }
        String buildTag = TransFileUtil.buildTag(str2, str3, "fw", str);
        if (th5 != null) {
            QLog.e(buildTag, 1, sb5.toString(), th5);
        } else if (QLog.isColorLevel() || sIsActiveReport) {
            QLog.d(buildTag, 2, sb5.toString());
        }
    }

    public static void logUI(int i3, boolean z16, int i16, String str, String str2, String str3) {
        TransFileUtil.log("U", TransFileUtil.getUinDesc(i3), z16, getFileTypeDesc(i16), str, str2, str3, null);
    }

    public static void logdLogic(int i3, boolean z16, int i16, String str, String str2, String str3) {
        TransFileUtil.log("L", TransFileUtil.getUinDesc(i3), z16, getFileTypeDesc(i16), str, str2, str3, null);
    }

    public static void loge(String str, String str2, boolean z16, String str3, String str4, String str5, String str6, Throwable th5) {
        String str7;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("id:");
        sb5.append(str4);
        if (z16) {
            str7 = "up";
        } else {
            str7 = "dw";
        }
        sb5.append(" \tstep:");
        sb5.append(str5);
        sb5.append(" \tcont:");
        sb5.append(str6);
        sb5.append(" \tver:");
        sb5.append(TransFileUtil.getVersionCode());
        if ("T".equals(str)) {
            sb5.append(" \ttid:");
            sb5.append(Thread.currentThread().getId());
        }
        String buildTag = TransFileUtil.buildTag(str2, str3, str7, str);
        if (th5 != null) {
            QLog.e(buildTag, 2, sb5.toString(), th5);
        } else if (QLog.isColorLevel() || sIsActiveReport) {
            QLog.e(buildTag, 2, sb5.toString());
        }
    }

    public static void logeLogic(int i3, boolean z16, int i16, String str, String str2, String str3, Throwable th5) {
        loge("L", TransFileUtil.getUinDesc(i3), z16, getFileTypeDesc(i16), str, str2, str3, th5);
    }

    public static void stopImageSendReport(boolean z16, String str) {
        if (str == null) {
            str = "image_sending";
        }
        stopReport("image_sending", z16, str);
    }

    public static void stopReport(String str, boolean z16, String str2) {
        AppRuntime peekAppRuntime;
        synchronized (sActiveRptMap) {
            if (sActiveRptMap.containsKey(str)) {
                if (QLog.isColorLevel() || sIsActiveReport) {
                    QLog.d(TAG, 2, "activeReport stop : " + str + ", " + z16);
                }
                ActiveRtpParam remove = sActiveRptMap.remove(str);
                if (remove != null && (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) != null) {
                    QLog.d(TAG, 1, remove.tags, Integer.valueOf(remove.appid), Boolean.valueOf(z16), str2, peekAppRuntime.getAccount());
                }
                if (sActiveRptMap.isEmpty()) {
                    sIsActiveReport = false;
                }
            }
        }
    }

    public static void logUI(int i3, boolean z16, int i16, String str, String str2, String str3, Throwable th5) {
        TransFileUtil.log("U", TransFileUtil.getUinDesc(i3), z16, getFileTypeDesc(i16), str, str2, str3, th5);
    }

    private static ArrayList<String> getImageTags(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str2 : SUPPORTED_UINTYPE) {
            for (String str3 : SUPPORTED_MODULE) {
                arrayList.add(TransFileUtil.buildTag(str2, "pic", str, str3));
                arrayList.add(TransFileUtil.buildTag(str2, "raw", str, str3));
                arrayList.add(TransFileUtil.buildTag(str2, "thu", str, str3));
            }
        }
        return arrayList;
    }
}
