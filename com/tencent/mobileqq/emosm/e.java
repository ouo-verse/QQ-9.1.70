package com.tencent.mobileqq.emosm;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emoticon.data.MarketFaceConstants;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.SecurityUtile;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import com.tencent.qqnt.kernel.nativeinterface.DigestErrCode;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f204272a = "ipsite.png";

    public static String A(String str, String str2) {
        return MsfSdkUtils.insertMtype(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0038, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x003a, code lost:
    
        com.tencent.qphone.base.util.QLog.e("EmosmUtils", 2, "isGifFile file close Exception:", r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0064, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() == false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean B(String str) throws IOException {
        d dVar = null;
        boolean z16 = false;
        try {
            try {
                d dVar2 = new d(str, "r");
                try {
                    byte[] bArr = new byte[10];
                    dVar2.read(bArr);
                    if (bArr[0] == 71 && bArr[1] == 73) {
                        if (bArr[2] == 70) {
                            z16 = true;
                        }
                    }
                    try {
                        dVar2.close();
                    } catch (IOException e16) {
                        e = e16;
                        e.printStackTrace();
                    }
                } catch (IOException e17) {
                    e = e17;
                    dVar = dVar2;
                    e.printStackTrace();
                    if (QLog.isColorLevel()) {
                        QLog.e("EmosmUtils", 2, "isGifFile file read Exception:", e);
                    }
                    if (dVar != null) {
                        try {
                            dVar.close();
                        } catch (IOException e18) {
                            e = e18;
                            e.printStackTrace();
                        }
                    }
                    return z16;
                } catch (Throwable th5) {
                    th = th5;
                    dVar = dVar2;
                    if (dVar != null) {
                        try {
                            dVar.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                            if (QLog.isColorLevel()) {
                                QLog.e("EmosmUtils", 2, "isGifFile file close Exception:", e19);
                            }
                        }
                    }
                    throw th;
                }
            } catch (IOException e26) {
                e = e26;
            }
            return z16;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static boolean C(String str) {
        if (com.tencent.mobileqq.core.util.a.m(str) != -1) {
            return true;
        }
        return false;
    }

    protected static void D(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, str);
        }
    }

    public static int E(byte[] bArr, String str) {
        if (bArr == null) {
            return 11017;
        }
        byte[] j3 = j(bArr);
        if (j3 == null) {
            return 11018;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "done. encryptFi,desData.len=" + j3.length + " file=" + str + " time=" + System.currentTimeMillis());
        }
        boolean pushData2File = FileUtils.pushData2File(str, j3, false);
        if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "done. write to file " + pushData2File + ",data.len=" + j3.length + " file=" + str + " time=" + System.currentTimeMillis());
        }
        if (pushData2File) {
            return 0;
        }
        return 11019;
    }

    public static int F(byte[] bArr, String str, String str2) {
        if (bArr == null) {
            return 11017;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "doing decryptTEA,srcData.len=" + bArr.length + " emoKey=" + str + " file=" + str2 + " time=" + System.currentTimeMillis());
        }
        byte[] f16 = f(bArr, str.getBytes());
        if (f16 == null) {
            return 11017;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "done. decryptTEA,clearData.len=" + f16.length + " emoKey=" + str + " file=" + str2 + " time=" + System.currentTimeMillis());
        }
        byte[] j3 = j(f16);
        if (j3 == null) {
            return 11018;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "done. encryptFi,desData.len=" + j3.length + " emoKey=" + str + " file=" + str2 + " time=" + System.currentTimeMillis());
        }
        boolean pushData2File = FileUtils.pushData2File(str2, j3, false);
        if (QLog.isColorLevel()) {
            QLog.d("Q.emoji.EmoDown", 2, "done. write to file " + pushData2File + ",data.len=" + j3.length + " file=" + str2 + " time=" + System.currentTimeMillis());
        }
        if (pushData2File) {
            return 0;
        }
        return 11019;
    }

    public static boolean G(Context context) {
        boolean isNetSupport = NetworkUtil.isNetSupport(BaseApplication.getContext());
        if (!isNetSupport) {
            QQToast.makeText(BaseApplication.getContext(), R.string.f209035eb, 0).show();
        }
        return isNetSupport;
    }

    public static String a(byte[] bArr, int i3) {
        if (bArr == null) {
            return null;
        }
        if (i3 == 2) {
            return new String(bArr);
        }
        return PkgTools.toHexStr(bArr).toLowerCase();
    }

    public static int b(int i3) {
        switch (i3) {
            case 2:
                D(" RESULT_CODE_NET_CONNECT_TIMEOUT .");
                return DigestErrCode.UN_SUPPORT_TYPE;
            case 3:
                D(" RESULT_CODE_NET_SO_TIMEOUT .");
                return 11005;
            case 4:
                return h();
            case 5:
            case 7:
            default:
                D("default RESULT_CODE_OTHER_ERROR .");
                return 11011;
            case 6:
                D(" RESULT_CODE_USER_CANCEL .");
                return 11007;
            case 8:
                D(" RESULT_CODE_CONTENT_LOSSY .");
                return DigestErrCode.MSG_EXPIRED;
            case 9:
                D(" RESULT_CODE_NET_UNUSABLE .");
                return DigestErrCode.SPACE_NOT_ENOUGH;
            case 10:
                D(" RESULT_CODE_NET_UNKNOWN_HOST ");
                return DigestErrCode.MSG_ALREADY_ADDED;
            case 11:
                D(" RESULT_CODE_SOCKET_EXCEPTION_ERROR .");
                return QQLiveReportConstants.ATTAID;
            case 12:
                return g();
            case 13:
                D(" RESULT_CODE_URL_STRING_ILLEGAL .");
                return 11014;
            case 14:
                D(" RESULT_CODE_HTTP_RESPONSE_NO_OK .");
                return 11016;
            case 15:
                D(" RESULT_CODE_IS_HTML .");
                return 11021;
        }
    }

    public static int c(byte[] bArr, int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            i16 = (i16 << 8) | (bArr[i17] & 255);
        }
        return i16;
    }

    public static void d(byte[] bArr, int i3, int i16, long j3) {
        SecurityUtile.xorInLimit(bArr, i3, i16, j3, 200);
    }

    public static byte[] e(byte[] bArr) {
        SecurityUtile.xorInLimit(bArr, 0, bArr.length, 0L, 200);
        return bArr;
    }

    public static byte[] f(byte[] bArr, byte[] bArr2) {
        if (!VersionUtils.isrFroyo()) {
            return new Cryptor().decrypt(bArr, bArr2);
        }
        return new Cryptor().decrypt(bArr, bArr2);
    }

    protected static int g() {
        if (Utils.B()) {
            if (Utils.z() < 1048576) {
                D(" RESULT_CODE_SDCARD less 1mb .");
                return 11001;
            }
            D(" RESULT_CODE_LOCAL_FILESYSTEM_FAIL .");
            return 11013;
        }
        D(" RESULT_CODE_SDCARD_UNUSABLE .");
        return 11000;
    }

    protected static int h() {
        if (Utils.B()) {
            if (Utils.z() < 1048576) {
                D(" RESULT_CODE_SDCARD less 1mb .");
                return 11001;
            }
            D(" RESULT_CODE_DOWNLOAD_OTHER_ERROR .");
            return 11011;
        }
        D(" RESULT_CODE_SDCARD_UNUSABLE .");
        return 11000;
    }

    public static byte[] i(String str, int i3) {
        if (i3 != 0 && i3 != 2 && i3 != 4) {
            if (i3 == 1) {
                return str.getBytes();
            }
            return null;
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i16 = 0; i16 < length; i16++) {
            int i17 = i16 * 2;
            bArr[i16] = Integer.valueOf(str.substring(i17, i17 + 2), 16).byteValue();
        }
        return bArr;
    }

    public static byte[] j(byte[] bArr) {
        return SecurityUtile.xorInLimit(bArr, 200);
    }

    public static char[] k(int i3, int i16) {
        return new char[]{(char) (i3 >> 8), (char) (i3 & 255), (char) i16, '\u00ff'};
    }

    public static char[] l(int i3, int i16) {
        return new char[]{'\u00ff', (char) (i3 >> 8), (char) (i3 & 255), (char) i16};
    }

    public static Drawable m(int i3, String str) {
        File file = new File(n(i3, str));
        if (!file.exists()) {
            return null;
        }
        return URLDrawable.getDrawable(file, (URLDrawable.URLDrawableOptions) null);
    }

    public static String n(int i3, String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(MarketFaceConstants.emoticonPackageFolderPath.replace("[epId]", str));
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 22) {
                        if (i3 == 23) {
                            sb5.append(f204272a);
                        }
                    } else {
                        sb5.append("drainage.png");
                    }
                } else {
                    sb5.append("gray.png");
                }
            } else {
                sb5.append("color.png");
            }
        } else {
            sb5.append("list.png");
        }
        return sb5.toString();
    }

    public static String o(int i3, String str, String str2) {
        f204272a = "ipsite_" + str2 + ".png";
        return n(i3, str);
    }

    public static String p(int i3, String str) {
        int m3 = com.tencent.mobileqq.core.util.a.m(str);
        if (m3 == -1) {
            return null;
        }
        int i16 = m3 % 10;
        StringBuilder sb5 = new StringBuilder();
        if (i3 != 2) {
            if (i3 != 3) {
                if (i3 != 4) {
                    if (i3 != 13) {
                        if (i3 != 14) {
                            switch (i3) {
                                case 17:
                                    sb5.append("https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_" + str + "/color.png");
                                    break;
                                case 18:
                                    sb5.append("https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_" + str + "/gray.png");
                                    break;
                                case 19:
                                    sb5.append("https://i.gtimg.cn/qqshow/admindata/comdata/vipSmallEmoji_item_" + str + "/list.png");
                                    break;
                            }
                        }
                    }
                }
                sb5.append("https://i.gtimg.cn/club/item/parcel/img/parcel/" + i16 + "/" + str + "/60x60_gray.png");
            }
            sb5.append("https://i.gtimg.cn/club/item/parcel/img/parcel/" + i16 + "/" + str + "/60x60_color.png");
        } else {
            sb5.append("https://i.gtimg.cn/club/item/parcel/img/parcel/" + i16 + "/" + str + "/126x126.png");
        }
        return A("VIP_emosm", sb5.toString());
    }

    public static byte[] q(String str) {
        byte[] u16 = u(str);
        if (u16 != null) {
            return e(u16);
        }
        return null;
    }

    public static int[] r(char[] cArr) {
        return new int[]{c(new byte[]{(byte) cArr[0], (byte) cArr[1]}, 2), cArr[2]};
    }

    public static String s(Context context, Message message) {
        byte[] bArr;
        if (message != null && (bArr = message.msgData) != null && bArr.length >= 1) {
            MessageForAniSticker messageForAniSticker = new MessageForAniSticker();
            messageForAniSticker.deserializeMsgData(message.msgData);
            return messageForAniSticker.text;
        }
        if (QLog.isColorLevel()) {
            QLog.d(MessageForAniSticker.TAG, 2, "Get Brief for notification when message null");
            return "";
        }
        return "";
    }

    public static String t(Context context, Message message) {
        if (context != null && message != null) {
            MessageForMarketFace messageForMarketFace = new MessageForMarketFace();
            messageForMarketFace.msgData = message.msgData;
            messageForMarketFace.parse();
            MarkFaceMessage markFaceMessage = messageForMarketFace.mMarkFaceMessage;
            if (markFaceMessage != null && !TextUtils.isEmpty(markFaceMessage.faceName)) {
                return "[" + messageForMarketFace.mMarkFaceMessage.faceName + "]";
            }
            return context.getString(R.string.axb);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0030, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x002e, code lost:
    
        if (r0 == null) goto L30;
     */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] u(String str) {
        FileInputStream fileInputStream;
        ?? exists = new File(str).exists();
        FileInputStream fileInputStream2 = null;
        try {
            if (exists != 0) {
                try {
                    fileInputStream = new FileInputStream(new File(str));
                } catch (FileNotFoundException e16) {
                    e = e16;
                    fileInputStream = null;
                } catch (IOException e17) {
                    e = e17;
                    fileInputStream = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException unused) {
                        }
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    fileInputStream.read(bArr);
                    try {
                        fileInputStream.close();
                    } catch (IOException unused2) {
                    }
                    return bArr;
                } catch (FileNotFoundException e18) {
                    e = e18;
                    e.printStackTrace();
                } catch (IOException e19) {
                    e = e19;
                    e.printStackTrace();
                }
            }
            return null;
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = exists;
        }
    }

    public static int v() {
        return 0;
    }

    public static String w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return MarketFaceConstants.emoticonPackageFolderPath.replace("[epId]", str) + "h5.zip";
    }

    public static String x(String str) {
        int m3;
        if (TextUtils.isEmpty(str) || (m3 = com.tencent.mobileqq.core.util.a.m(str)) == -1) {
            return null;
        }
        return A("VIP_emosm", "https://i.gtimg.cn/club/item/parcel/" + (m3 % 10) + "/" + str + "/h5.zip");
    }

    public static String y(String str, int i3) {
        int m3 = com.tencent.mobileqq.core.util.a.m(str);
        if (m3 == -1) {
            return null;
        }
        int i16 = m3 % 10;
        StringBuilder sb5 = new StringBuilder();
        if (i3 == 0) {
            sb5.append("https://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i16 + "/" + str + "/audio.zip");
        } else if (1 == i3) {
            if ("sbig".equalsIgnoreCase(com.tencent.mobileqq.magicface.model.f.d())) {
                sb5.append("https://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i16 + "/" + str + "/androidsbig.zip");
            } else if ("xbig".equalsIgnoreCase(com.tencent.mobileqq.magicface.model.f.d())) {
                sb5.append("https://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i16 + "/" + str + "/androidxbig.zip");
            } else if ("big".equalsIgnoreCase(com.tencent.mobileqq.magicface.model.f.d())) {
                sb5.append("https://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i16 + "/" + str + "/androidbig.zip");
            } else {
                sb5.append("https://i.gtimg.cn/club/item/parcel/multimedia/magicparcel/" + i16 + "/" + str + "/androidsmall.zip");
            }
        }
        return A("VIP_emosm", sb5.toString());
    }

    public static char[] z(int i3, int i16, int i17) {
        char[] k3 = k(i3, i16);
        char[] cArr = {20, k3[3], k3[2], k3[1], k3[0]};
        if (i17 == 2) {
            cArr[1] = '\u01ff';
        }
        return cArr;
    }
}
