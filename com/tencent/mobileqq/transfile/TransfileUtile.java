package com.tencent.mobileqq.transfile;

import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.proxy.dlg.location.QbAddrData;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TransfileUtile {
    static IPatchRedirector $redirector_ = null;
    public static final byte IMG_FMT_BMP = 1;
    public static final byte IMG_FMT_GIF = 2;
    public static final byte IMG_FMT_INVALID = 0;
    public static final byte IMG_FMT_JPG = 3;
    public static final byte IMG_FMT_PNG = 4;
    public static final int IMG_SCALE_120 = 120;
    public static final int IMG_SCALE_160 = 160;
    public static final int IMG_SCALE_640 = 640;
    public static final int IMG_SCALE_960 = 960;
    public static final int IMG_SCALE_ORG = 0;
    private static final String TAG = "TransfileUtile";
    public static final int TYPE_BILLD = 65538;
    public static final int TYPE_DISCUSSION = 4;
    public static final int TYPE_FILE = 0;
    public static final int TYPE_MARKET_FACE = 9;
    public static final int TYPE_PA_IMAGE_TEXT = 5;
    public static final int TYPE_PA_SHARE = 7;
    public static final int TYPE_PA_TEXT = 6;
    public static final int TYPE_PHOTO = 1;
    public static final int TYPE_PTT = 2;
    public static final int TYPE_PTT_CENTER = 8;
    public static final int TYPE_VIEDO = 3;

    public TransfileUtile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String[] analysisTransFileProtocolData(String str) {
        String[] split;
        if (str == null || (split = str.split("\u0016")) == null || split.length < 2) {
            return null;
        }
        return split[1].split("\\|");
    }

    public static String getForwardMsgContent(String str, String str2, String str3, long j3, int i3) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append((char) 22);
        String[] analysisTransFileProtocolData = analysisTransFileProtocolData(str);
        if (analysisTransFileProtocolData == null) {
            return "";
        }
        for (int i16 = 0; i16 < analysisTransFileProtocolData.length && i16 < 5; i16++) {
            sb5.append(analysisTransFileProtocolData[i16]);
            sb5.append(QbAddrData.DATA_SPLITER);
        }
        if (analysisTransFileProtocolData.length == 4) {
            sb5.append("");
            sb5.append(QbAddrData.DATA_SPLITER);
        } else {
            sb5.append(str2);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(str3);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(j3);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(i3);
        }
        return sb5.toString();
    }

    public static byte getImgFormat(String str) {
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < str.length()) {
            String lowerCase = str.substring(lastIndexOf + 1).toLowerCase();
            if ("bmp".equals(lowerCase)) {
                return (byte) 1;
            }
            if ("gif".equals(lowerCase)) {
                return (byte) 2;
            }
            if (!"jpg".equals(lowerCase) && !MimeHelper.IMAGE_SUBTYPE_JPEG.equals(lowerCase)) {
                if ("png".equals(lowerCase)) {
                    return (byte) 4;
                }
            } else {
                return (byte) 3;
            }
        }
        return (byte) 0;
    }

    public static String getPicMD5ByMsgContent(String str) {
        String[] analysisTransFileProtocolData = analysisTransFileProtocolData(str);
        if (analysisTransFileProtocolData == null || analysisTransFileProtocolData.length < 6) {
            return null;
        }
        String str2 = analysisTransFileProtocolData[5];
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getPicMD5ByMsgContent:" + str2);
        }
        if (str2.length() != 32) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getPicMD5ByMsgContent: error md5: length is not 32.");
            }
            return null;
        }
        return str2;
    }

    @Deprecated
    public static String makeTransFileProtocolData(String str, long j3, int i3, boolean z16) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((char) 22);
        stringBuffer.append(str);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(j3);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(i3);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(z16 ? 1 : 0);
        return stringBuffer.toString();
    }

    public static String makeTransFileProtocolDataForForwardImage(String str, String str2, String str3, long j3, int i3) {
        String makeTransFileProtocolData = makeTransFileProtocolData(str, 0L, 1, true, str2);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(str2);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(str3);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(j3);
        stringBuffer.append(QbAddrData.DATA_SPLITER);
        stringBuffer.append(i3);
        return makeTransFileProtocolData + stringBuffer.toString();
    }

    @Deprecated
    public static String makeTransFileProtocolData(String str, long j3, int i3, boolean z16, String str2) {
        String str3 = makeTransFileProtocolData(str, j3, i3, z16) + "|";
        if (str2 != null && str2.length() > 0) {
            return str3 + str2;
        }
        return str3 + "null";
    }

    public static String makeTransFileProtocolData(String str, long j3, int i3, boolean z16, String str2, String str3, String str4) {
        String str5;
        String str6;
        String str7 = makeTransFileProtocolData(str, j3, i3, z16) + "|";
        if (str2 != null && str2.length() > 0) {
            str5 = str7 + str2;
        } else {
            str5 = str7 + "null";
        }
        String str8 = str5 + "|";
        if (str3 != null && str3.length() > 0) {
            str6 = str8 + str3;
        } else {
            str6 = str8 + "null";
        }
        String str9 = str6 + "|";
        if (str4 != null && str4.length() > 0) {
            return str9 + str4;
        }
        return str9 + "null";
    }

    public static String makeTransFileProtocolData(String str, long j3, int i3, boolean z16, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i16, int i17) {
        return makeTransFileProtocolData(str, j3, i3, z16, str2, str3, str4, str5, str6, str7, str8, i16, i17, null);
    }

    public static String makeTransFileProtocolData(String str, long j3, int i3, boolean z16, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i16, int i17, String str9) {
        String str10;
        String str11;
        String str12;
        String str13;
        String str14 = makeTransFileProtocolData(str, j3, i3, z16, str2, str3, str4) + "|";
        if (str5 != null && str5.length() > 0) {
            str10 = str14 + str5;
        } else {
            str10 = str14 + "null";
        }
        String str15 = str10 + "|";
        if (str6 != null && str6.length() > 0) {
            str11 = str15 + str6;
        } else {
            str11 = str15 + "null";
        }
        String str16 = str11 + "|";
        if (str7 != null && str7.length() > 0) {
            str12 = str16 + str7;
        } else {
            str12 = str16 + "null";
        }
        String str17 = str12 + "|";
        if (str8 != null && str8.length() > 0) {
            str13 = str17 + str8;
        } else {
            str13 = str17 + "null";
        }
        String str18 = (((str13 + "|") + i16) + "|") + i17;
        if (str9 == null) {
            return str18;
        }
        return (str18 + "|") + str9;
    }
}
