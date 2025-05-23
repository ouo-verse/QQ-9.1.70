package com.tencent.mobileqq.text;

import android.os.SystemClock;
import android.util.SparseIntArray;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emoticon.QQSysFaceSwitcher;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes18.dex */
public class EmotcationConstants {
    static IPatchRedirector $redirector_ = null;
    public static final Map<String, Integer> DOUBLE_EMOJI_MAP;
    public static int[] EMOJI_CODES = null;
    public static String[] EMOJI_CONTENT_DESC = null;
    public static final SparseIntArray EMOJI_MAP;
    public static final int FIRST_EMOJI_RES;
    public static final String IDX = "faceIdx";
    public static final int INDEX_OFFSET = 1000;
    static final int INVALID_EMOJ_RES;
    public static final int[] LOCALE_TO_SERVER;
    public static final Map<Integer, String> LOCAL_ID_TO_EMOJI_UNICODE_MAP;
    public static final int MAX_NORMAL_EMOJI_SERVER_ID = 247;
    public static final int[] STATIC_SYS_EMOTCATION_RESOURCE;
    public static final char SYS_EMOTCATION_HEAD = 20;
    public static final char SYS_EMOTCATION_MODULO_OFFSET = 'A';
    public static final int SYS_EMOTCATION_MODULO_VALUE = 128;
    public static final String[] SYS_EMOTICON_SYMBOL;
    private static final String TAG = "EmotcationConstants";
    public static int VALID_EMOJI_COUNT;
    public static int VALID_SYS_EMOTCATION_COUNT;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42744);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        int[] iArr = com.tencent.qqnt.emoji.a.STATIC_SYS_EMOJI_RESOURCE;
        STATIC_SYS_EMOTCATION_RESOURCE = iArr;
        VALID_SYS_EMOTCATION_COUNT = iArr.length;
        SYS_EMOTICON_SYMBOL = com.tencent.qqnt.emoji.a.SYS_EMOTICON_SYMBOL;
        FIRST_EMOJI_RES = R.drawable.b_3;
        INVALID_EMOJ_RES = R.drawable.bco;
        VALID_EMOJI_COUNT = 247;
        EMOJI_CODES = com.tencent.qqnt.emoji.a.EMOJI_CODES;
        EMOJI_CONTENT_DESC = com.tencent.qqnt.emoji.a.EMOJI_CONTENT_DESC;
        long uptimeMillis = SystemClock.uptimeMillis();
        EMOJI_MAP = new SparseIntArray(EMOJI_CODES.length);
        DOUBLE_EMOJI_MAP = new HashMap(300);
        LOCAL_ID_TO_EMOJI_UNICODE_MAP = new HashMap(300);
        for (int i3 = 0; i3 < VALID_EMOJI_COUNT; i3++) {
            EMOJI_MAP.put(EMOJI_CODES[i3], i3);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "old init cost:" + (SystemClock.uptimeMillis() - uptimeMillis) + "EMOJI_CODES.length=" + EMOJI_CODES.length);
        }
        AppleEmojiManager.loadEmojiMapFromDisk();
        LOCALE_TO_SERVER = new int[]{13, 12, 27, 20, 39, 38, 97, 46, 63, 5, 9, 33, 16, 18, 106, 59, 55, 112, 21, 2, 6, 4, 19, 14, 11, 10, 26, 96, 66, 116, 22, 23, 15, 0, 32, 8, 109, 28, 42, 36, 1, 108, 30, 3, 103, 49, 101, 85, 105, 34, 29, 111, 76, 77, 78, 79, 118, 64, 61, 53, 89, 113, 117, 119, 124, 122, 60, 50, 75, 81, 56, 41, 121, 120, 67, 74, 69, 57, 37, 129, 54, 24, 25, 31, 35, 98, 99, 100, 102, 104, 107, 110, 114, 115, 123, 43, 86, 125, 126, 127, 128, 130, 131, 132, 133, 134, 7, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 194, -1, -1, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, -1, 210, 211, 212, -1, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, -1, 187, 188, -1, 190, -1, 192, 193, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247};
    }

    public EmotcationConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void addLocalIdDoubleUnicode(int i3, int i16, int i17) {
        try {
            if (Character.isDefined(i16) && Character.isDefined(i17)) {
                LOCAL_ID_TO_EMOJI_UNICODE_MAP.put(Integer.valueOf(i3), String.valueOf(Character.toChars(i16)) + String.valueOf(Character.toChars(i17)));
            }
        } catch (Throwable unused) {
            QLog.e(TAG, 1, "addLocalIdDoubleUnicode error, unicode=", Integer.valueOf(i16), ", unicode2=", Integer.valueOf(i17));
        }
    }

    private static void addLocalIdSingleUnicode(int i3, int i16) {
        try {
            if (Character.isDefined(i16)) {
                LOCAL_ID_TO_EMOJI_UNICODE_MAP.put(Integer.valueOf(i3), String.valueOf(Character.toChars(i16)));
            }
        } catch (Throwable unused) {
            QLog.e(TAG, 1, "addLocalIdSingleUnicode error, unicode=", Integer.valueOf(i16));
        }
    }

    public static String afterXml(String str, String str2, boolean z16) {
        int length;
        int i3;
        StringBuilder sb5;
        if (!android.text.TextUtils.isEmpty(str)) {
            int length2 = str.length();
            if (str2 == null) {
                length = 0;
            } else {
                length = str2.length();
            }
            if (length2 >= length + 15) {
                StringBuilder sb6 = new StringBuilder("\\[emoji:0x[a-fA-F0-9]{5}");
                StringBuilder sb7 = new StringBuilder("\\[sysEmo:[0-9]{3}-[0-9]{3}");
                if (!android.text.TextUtils.isEmpty(str2)) {
                    sb6.append(str2);
                    sb7.append(str2);
                    i3 = str2.length();
                } else {
                    i3 = 0;
                }
                sb6.append("\\]");
                sb7.append("\\]");
                Matcher matcher = Pattern.compile(sb6.toString()).matcher(str);
                StringBuffer stringBuffer = new StringBuffer();
                if (QLog.isColorLevel()) {
                    sb5 = new StringBuilder(1024);
                    sb5.append("afterXml src:");
                    sb5.append(str);
                    sb5.append(" start");
                } else {
                    sb5 = null;
                }
                boolean z17 = false;
                while (matcher.find()) {
                    int intValue = Integer.valueOf(str.substring(matcher.start() + 9, (matcher.end() - 1) - i3), 16).intValue();
                    if (intValue > 65535) {
                        matcher.appendReplacement(stringBuffer, new String(new int[]{intValue}, 0, 1));
                    }
                    if (sb5 != null) {
                        sb5.append("\n");
                        sb5.append("unicode");
                        sb5.append(":");
                        sb5.append(intValue);
                    }
                    z17 = true;
                }
                matcher.appendTail(stringBuffer);
                if (z16) {
                    String stringBuffer2 = stringBuffer.toString();
                    Matcher matcher2 = Pattern.compile(sb7.toString()).matcher(stringBuffer2);
                    stringBuffer = new StringBuffer();
                    while (matcher2.find()) {
                        String[] split = stringBuffer2.substring(matcher2.start() + 8, (matcher2.end() - 1) - i3).split("-");
                        int intValue2 = Integer.valueOf(split[0], 10).intValue();
                        int intValue3 = Integer.valueOf(split[1], 10).intValue();
                        if (intValue2 != 92) {
                            matcher2.appendReplacement(stringBuffer, new String(new char[]{20, (char) intValue2}));
                        } else {
                            matcher2.appendReplacement(stringBuffer, new String(new char[]{20}));
                            stringBuffer.append((char) intValue2);
                        }
                        stringBuffer.append((char) intValue3);
                        if (sb5 != null) {
                            sb5.append("\n");
                            sb5.append("sysEmo");
                            sb5.append(":");
                            sb5.append(intValue2);
                            sb5.append("|");
                            sb5.append(intValue3);
                        }
                        z17 = true;
                    }
                    matcher2.appendTail(stringBuffer);
                }
                if (sb5 != null) {
                    QLog.i(TAG, 2, sb5.toString());
                }
                if (z17) {
                    return stringBuffer.toString();
                }
                return str;
            }
            return str;
        }
        return str;
    }

    public static String beforXml(String str, String str2, boolean z16) {
        StringBuilder sb5;
        int i3;
        String str3 = str;
        if (android.text.TextUtils.isEmpty(str)) {
            return str3;
        }
        if (Character.codePointCount(str3, 0, str.length()) == str.length() && !str3.contains(new String(new char[]{20}))) {
            return str3;
        }
        if (QLog.isColorLevel()) {
            QLog.i(EmotcationConstants.class.getSimpleName(), 2, "beforeXml:" + str3);
        }
        StringBuilder sb6 = new StringBuilder("[emoji:0x%05x");
        StringBuilder sb7 = new StringBuilder("[sysEmo:%03d-%03d");
        if (!android.text.TextUtils.isEmpty(str2)) {
            sb6.append(str2);
            sb7.append(str2);
        }
        sb6.append(']');
        sb7.append(']');
        if (QLog.isColorLevel()) {
            sb5 = new StringBuilder(1024);
            sb5.append("beforXml start");
        } else {
            sb5 = null;
        }
        int length = str.length();
        int i16 = 0;
        while (i16 < length) {
            int codePointAt = str3.codePointAt(i16);
            if (codePointAt > 65535) {
                String substring = str3.substring(i16, i16 + 2);
                String format = String.format(sb6.toString(), Integer.valueOf(codePointAt));
                str3 = str3.replace(substring, format);
                i16 += format.length() - 1;
                length = str3.length();
                if (sb5 != null) {
                    sb5.append("\n");
                    sb5.append("unicode");
                    sb5.append(":");
                    sb5.append(codePointAt);
                }
            } else if (codePointAt == 20 && (i3 = i16 + 2) < length && z16) {
                int codePointAt2 = str3.codePointAt(i16 + 1);
                int codePointAt3 = str3.codePointAt(i3);
                String substring2 = str3.substring(i16, i16 + 3);
                String format2 = String.format(sb7.toString(), Integer.valueOf(codePointAt2), Integer.valueOf(codePointAt3));
                str3 = str3.replace(substring2, format2);
                i16 += format2.length() - 1;
                int length2 = str3.length();
                if (sb5 != null) {
                    sb5.append("\n");
                    sb5.append("sysEmo");
                    sb5.append(":");
                    sb5.append(codePointAt2);
                    sb5.append("|");
                    sb5.append(codePointAt3);
                }
                length = length2;
            }
            i16++;
        }
        if (sb5 != null) {
            QLog.i(TAG, 2, sb5.toString());
        }
        return str3;
    }

    public static int getDoubleEmoji(int i3, int i16) {
        Map<String, Integer> map;
        if (((i16 <= 127994 || i16 >= 128000) && ((i3 <= 127461 || i3 >= 127488) && (i3 <= 34 || i3 >= 64))) || (map = DOUBLE_EMOJI_MAP) == null) {
            return -1;
        }
        Integer num = map.get(i3 + "|" + i16);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    public static String getEmojiDesc(int i3) {
        if (i3 >= 0 && i3 < EMOJI_CONTENT_DESC.length) {
            return EMOJI_CONTENT_DESC[i3] + " ";
        }
        return " \u672a\u77e5 ";
    }

    public static int getSingleEmoji(int i3) {
        boolean z16;
        boolean z17 = true;
        boolean z18 = false;
        if (i3 > 8251 && i3 < 13056) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && i3 > 126979 && i3 < 129473) {
            if ((i3 <= 127461 || i3 >= 127488) && (i3 <= 41 || i3 >= 64)) {
                z18 = true;
            }
        } else {
            z18 = z16;
        }
        if (z18 || i3 <= 65 || i3 >= 175) {
            z17 = z18;
        }
        if (!z17) {
            return -1;
        }
        return EMOJI_MAP.get(i3, -1);
    }

    public static boolean isSkinEmoji(int i3) {
        switch (i3) {
            case 127995:
            case 127996:
            case 127997:
            case 127998:
            case 127999:
                return true;
            default:
                return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void setEmojiMap(File file, File file2) {
        if (file != null && file2 != null) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (AppleEmojiManager.isEmojiFileAvailable(file, file2)) {
                DOUBLE_EMOJI_MAP.clear();
                BufferedInputStream bufferedInputStream = null;
                try {
                    try {
                        try {
                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                            try {
                                boolean g16 = QQSysFaceSwitcher.f204652a.g();
                                while (true) {
                                    int read = bufferedInputStream2.read();
                                    if (read == -1) {
                                        break;
                                    }
                                    if (read == 1) {
                                        int readIntFromStream = AppleEmojiManager.readIntFromStream(bufferedInputStream2);
                                        int readIntFromStream2 = AppleEmojiManager.readIntFromStream(bufferedInputStream2) + 1000;
                                        EMOJI_MAP.put(readIntFromStream, readIntFromStream2);
                                        if (g16) {
                                            addLocalIdSingleUnicode(readIntFromStream2, readIntFromStream);
                                        }
                                    } else {
                                        int readIntFromStream3 = AppleEmojiManager.readIntFromStream(bufferedInputStream2);
                                        int readIntFromStream4 = AppleEmojiManager.readIntFromStream(bufferedInputStream2);
                                        int readIntFromStream5 = AppleEmojiManager.readIntFromStream(bufferedInputStream2);
                                        int i3 = readIntFromStream5 + 1000;
                                        DOUBLE_EMOJI_MAP.put(readIntFromStream3 + "|" + readIntFromStream4, Integer.valueOf(i3));
                                        if (g16) {
                                            addLocalIdDoubleUnicode(i3, readIntFromStream3, readIntFromStream4);
                                        }
                                    }
                                }
                                bufferedInputStream2.close();
                            } catch (IOException e16) {
                                e = e16;
                                bufferedInputStream = bufferedInputStream2;
                                QLog.e(TAG, 1, "", e);
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (!QLog.isColorLevel()) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                bufferedInputStream = bufferedInputStream2;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e17) {
                                        e17.printStackTrace();
                                    }
                                }
                                throw th;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                        }
                    } catch (IOException e18) {
                        e = e18;
                    }
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
                if (!QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "setEmojiMap cost:", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis), "setEmojiMap EMOJI_MAP size=", Integer.valueOf(EMOJI_MAP.size()), "DOUBLE_EMOJI_MAP=", Integer.valueOf(DOUBLE_EMOJI_MAP.size()));
                    return;
                }
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setEmojiMap emoji's file is null");
        }
    }
}
